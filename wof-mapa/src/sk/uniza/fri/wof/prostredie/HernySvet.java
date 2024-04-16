package sk.uniza.fri.wof.prostredie;

import sk.uniza.fri.wof.prostredie.predmety.*;
import sk.uniza.fri.wof.prostredie.vybavenie.Automat;
import sk.uniza.fri.wof.prostredie.vybavenie.OvladacVytahu;
import sk.uniza.fri.wof.prostredie.vychody.VstupDoLabaku;
import sk.uniza.fri.wof.prostredie.vychody.VychodZVytahu;

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
        final Miestnost startovaciaMiestnost;
        Miestnost terasa = new Miestnost("terasa - hlavny vstup na fakultu");
        Miestnost aula = new Miestnost("aula");
        Miestnost bufet = new Miestnost("bufet");
        Miestnost labak = new Miestnost("pocitacove laboratorium");
        Miestnost kancelaria = new Miestnost("kancelaria spravcu pocitacoveho laboratoria");

        Miestnost vytah = new Miestnost("vytah");
        Miestnost atomovyKryt = new Miestnost("atomovy kryt v pivnici");
        Miestnost chodba1Poschodie = new Miestnost("chodba na prvom poschodí");


        // inicializacia miestnosti = nastavenie vychodov
        terasa.nastavVychod("vychod", aula);
        terasa.nastavVychod("juh", new VstupDoLabaku(labak));
        terasa.nastavVychod("zapad", bufet);
        aula.nastavVychod("zapad", terasa);
        labak.nastavVychod("sever", terasa);
        labak.nastavVychod("vychod", kancelaria);
        kancelaria.nastavVychod("zapad", labak);
        bufet.nastavVychod("vychod", terasa);

        //Z daných miestnosti sa dá vojsť do výtahu
        terasa.nastavVychod("vytah", vytah);
        atomovyKryt.nastavVychod("vytah", vytah);
        chodba1Poschodie.nastavVychod("vytah", vytah);

        vytah.nastavVychod("von", new VychodZVytahu(new Miestnost[]{atomovyKryt, terasa, chodba1Poschodie}));

        terasa.polozPredmet(new ObycajnyPredmet("kamen"));
        terasa.polozPredmet(new Hodinky());
        terasa.polozPredmet(new Navleky());
        labak.polozPredmet(new ObycajnyPredmet("mys"));
        aula.polozPredmet(new Isic(6));
        //bufet.polozPredmet(new ObycajnyPredmet("bageta"));
        terasa.polozPredmet(new Radio());
        bufet.polozPredmet(new Baterky());

        bufet.pridajVybavenie(new Automat());

        vytah.pridajVybavenie(new OvladacVytahu());
        return terasa;
    }

    public Miestnost getStartovaciaMiestnost() {
        return this.startovaciaMiestnost;
    }
}
