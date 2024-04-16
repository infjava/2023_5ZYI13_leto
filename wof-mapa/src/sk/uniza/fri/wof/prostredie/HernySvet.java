package sk.uniza.fri.wof.prostredie;

import sk.uniza.fri.wof.prostredie.predmety.*;
import sk.uniza.fri.wof.prostredie.vybavenie.Automat;
import sk.uniza.fri.wof.prostredie.vybavenie.OvladacVytahu;
import sk.uniza.fri.wof.prostredie.vybavenie.Vybavenie;
import sk.uniza.fri.wof.prostredie.vychody.VstupDoLabaku;
import sk.uniza.fri.wof.prostredie.vychody.Vychod;
import sk.uniza.fri.wof.prostredie.vychody.VychodZVytahu;

import java.util.*;

public class HernySvet {
    private final Miestnost startovaciaMiestnost;


    /**
     * Vytvorí herný svet s mapou definovanou v zdrojovom kóde
     */
    public HernySvet() {
        this.startovaciaMiestnost = this.vytvorMapu();
    }

    /**
     * Vytvori mapu definovanú pomocou zdrojového kódu
     */
    private Miestnost vytvorMapu() {
        try (var mapa = new Scanner(ClassLoader.getSystemResourceAsStream("mapa.txt"))) {
            var sekcia = SekciaMapy.CHYBNA;
            Miestnost aktualnaMiestnost = null;
            Miestnost startovaciaMiestnost = null;
            var miestnosti = new HashMap<String, Miestnost>();
            var vychody = new ArrayList<PopisVychodu>();

            while (mapa.hasNextLine()) {
                var riadokMapy = mapa.nextLine();
                var citacRiadku = new Scanner(riadokMapy);

                if (!citacRiadku.hasNext()) {
                    continue;
                }

                var prveSlovo = citacRiadku.next();

                switch (prveSlovo) {
                    case "miestnost" -> {
                        var nazov = citacRiadku.next();
                        String popis;
                        if (citacRiadku.hasNext()) {
                            popis = citacRiadku.nextLine();
                        } else {
                            popis = nazov;
                        }

                        aktualnaMiestnost = new Miestnost(popis);
                        miestnosti.put(nazov, aktualnaMiestnost);
                    }
                    case "vychody" -> {
                        if (aktualnaMiestnost == null) {
                            throw new ChybnaMapaException("Nie je definovana miestnost");
                        }
                        sekcia = SekciaMapy.VYCHODY;
                    }
                    case "predmety" -> {
                        if (aktualnaMiestnost == null) {
                            throw new ChybnaMapaException("Nie je definovana miestnost");
                        }
                        sekcia = SekciaMapy.PREDMETY;
                    }
                    case "vybavenie" -> {
                        if (aktualnaMiestnost == null) {
                            throw new ChybnaMapaException("Nie je definovana miestnost");
                        }
                        sekcia = SekciaMapy.VYBAVENIE;
                    }
                    case "start" -> {
                        startovaciaMiestnost = miestnosti.get(citacRiadku.next());
                    }
                    default -> {
                        if (aktualnaMiestnost == null) {
                            throw new ChybnaMapaException("Nie je definovana miestnost");
                        }

                        switch (sekcia) {
                            case VYCHODY -> {
                                var smer = prveSlovo.substring(0, prveSlovo.length() - 1);
                                var typAleboCiel = citacRiadku.next();
                                String[] cieloveMiestnosti;
                                String typ;
                                if (citacRiadku.hasNext()) {
                                    cieloveMiestnosti = citacRiadku.nextLine().split(citacRiadku.delimiter().pattern());
                                    typ = typAleboCiel;
                                } else {
                                    cieloveMiestnosti = new String[]{typAleboCiel};
                                    typ = null;
                                }
                                vychody.add(new PopisVychodu(aktualnaMiestnost, smer, Optional.ofNullable(typ), List.of(cieloveMiestnosti)));
                            }
                            case PREDMETY -> {
                                aktualnaMiestnost.polozPredmet(this.vytvorPredmet(prveSlovo, citacRiadku));
                            }
                            case VYBAVENIE -> {
                                aktualnaMiestnost.pridajVybavenie(this.vytvorVybavenie(prveSlovo));
                            }
                            default -> {
                                throw new ChybnaMapaException("Chybna sekcia");
                            }
                        }
                    }
                }

                if (citacRiadku.hasNext()) {
                    throw new ChybnaMapaException("Nenacitana cast riadku");
                }
            }

            for (PopisVychodu popisVychodu : vychody) {
                var cieloveMiestnosti = new ArrayList<Miestnost>();
                for (String nazov : popisVychodu.getCieloveMiestnosti()) {
                    cieloveMiestnosti.add(miestnosti.get(nazov));
                }

                if (popisVychodu.getTyp().isEmpty()) {
                    if (cieloveMiestnosti.size() != 1) {
                        throw new ChybnaMapaException("Nespravny pocet vychodov");
                    }
                    popisVychodu.getAktualnaMiestnost().nastavVychod(popisVychodu.getSmer(), cieloveMiestnosti.get(0));
                } else {
                    popisVychodu.getAktualnaMiestnost().nastavVychod(popisVychodu.getSmer(), this.vytvorVychod(popisVychodu.getTyp().get(), cieloveMiestnosti));
                }
            }

            return startovaciaMiestnost;
        }
    }

    private Predmet vytvorPredmet(String typ, Scanner citacRiadku) {
        return switch (typ) {
            case "ObycajnyPredmet" -> new ObycajnyPredmet(citacRiadku.next());
            case "Hodinky" -> new Hodinky();
            case "Navleky" -> new Navleky();
            case "Radio" -> new Radio();
            case "Isic" -> new Isic(citacRiadku.nextInt());
            case "Baterky" -> new Baterky();
            default -> throw new ChybnaMapaException("Neznamy predmet");
        };
    }

    private Vybavenie vytvorVybavenie(String typ) {
        return switch (typ) {
            case "OvladacVytahu" -> new OvladacVytahu();
            case "Automat" -> new Automat();
            default -> throw new ChybnaMapaException("Nezname vybavenie");
        };
    }

    private Vychod vytvorVychod(String typ, ArrayList<Miestnost> cieloveMiestnosti) {
        return switch (typ) {
            case "VstupDoLabaku" -> new VstupDoLabaku(cieloveMiestnosti.get(0));
            case "VychodZVytahu" -> new VychodZVytahu(cieloveMiestnosti.toArray(new Miestnost[0]));
            default -> throw new ChybnaMapaException("Neznamy typ vychodu");
        };
    }

    public Miestnost getStartovaciaMiestnost() {
        return this.startovaciaMiestnost;
    }
}
