package sk.uniza.fri.wof.zaklad;

import sk.uniza.fri.wof.prostredie.Miestnost;
import sk.uniza.fri.wof.prostredie.Pouzitelny;
import sk.uniza.fri.wof.prostredie.predmety.Isic;
import sk.uniza.fri.wof.prostredie.predmety.Predmet;
import sk.uniza.fri.wof.reakcie.ReakciaNaChodenie;

import java.util.HashMap;
import java.util.Optional;

public class Hrac {
    private Miestnost aktualnaMiestnost;
    private final HashMap<String, Predmet> inventar;

    public Hrac(Miestnost aktualnaMiestnost) {
        this.aktualnaMiestnost = aktualnaMiestnost;
        this.inventar = new HashMap<>();
    }

    public void posunVSmere(String smer) {

        var vychod = this.aktualnaMiestnost.getVychodVSmere(smer);
        if (vychod.isEmpty()) {
            System.out.println("Tam nie je vychod!");
        } else if (!vychod.get().mozemVstupit(this)) {
            System.out.println("Vstup do tejto miestnosti ti nebol povolený!");
        } else {
            this.aktualnaMiestnost = vychod.get().dajMiestnost();
            this.aktualnaMiestnost.vypisInfoOMiestnosti();
            for (Predmet predmet : this.inventar.values()) {
                if (predmet instanceof ReakciaNaChodenie sledovac) {
                    sledovac.hracSaPohol(this, this.aktualnaMiestnost);
                }
            }
        }
    }

    public void zoberPredmet(String predmet) {
        var zdvihnutyPredmet = this.aktualnaMiestnost.zoberPredmet(predmet);
        if (zdvihnutyPredmet.isPresent()) {
            this.inventar.put(zdvihnutyPredmet.get().getNazov(), zdvihnutyPredmet.get());
        }
        else {
            System.out.println("Tento predmet sa v miestnosti nenachádza.");
        }
    }

    public void polozPredmet(String predmet) {
        Predmet pokladanyPredmet = this.inventar.remove(predmet);
        if (pokladanyPredmet == null) {
            System.out.println("Tento predmet v inventári nemáš");
        }
        else if (!pokladanyPredmet.mozemPolozit()) {
            this.inventar.put(pokladanyPredmet.getNazov(), pokladanyPredmet);
            System.out.printf("Predmet %s sa nedá položiť%n", pokladanyPredmet.getNazov());
            return;
        }
        this.aktualnaMiestnost.polozPredmet(pokladanyPredmet);
    }

    public void odstranPredmet(Predmet predmet) {
        this.inventar.remove(predmet.getNazov());
    }

    public Optional<Predmet> najdiPredmet(String nazov) {
        return Optional.ofNullable(this.inventar.get(nazov));
    }

    /**
     * vypise inventar do terminalu
     *
     */
    public void vypisInventar() {
        if (this.inventar.isEmpty()) {
            System.out.println("Zbytocne pozeras, ved tu nic nie je");
        } else {
            System.out.println("Tvoj inventar obsahuje:");
            for (var predmet : this.inventar.keySet()) {
                System.out.printf("- %s%n", predmet);
            }
        }
    }

    public void pouziPredmet(String nazov) {
        var predmet = this.inventar.get(nazov);
        if (predmet == null) {
            //Ak nemám v inventári, tak skúsim či nieje v miestnosti také vybavenie
            if (!this.aktualnaMiestnost.pouziVybavenie(this, nazov)) {
                System.out.println("Tento predmet nemáš");
            }
            return;
        }
        if (predmet instanceof Pouzitelny pouzitelny) {
            pouzitelny.pouzi(this);
        }
        else {
            System.out.printf("Predmet %s neviem použiť.%n", nazov);
        }
    }

    public Miestnost getAktualnaMiestnost() {
        return this.aktualnaMiestnost;
    }

    public void pridajPredmet(Predmet predmet) {
        this.inventar.put(predmet.getNazov(), predmet);
        System.out.println("Ziskal si predmet "+predmet.getNazov());
    }
}
