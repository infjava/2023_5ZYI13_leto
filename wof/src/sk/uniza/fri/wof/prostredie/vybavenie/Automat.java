package sk.uniza.fri.wof.prostredie.vybavenie;

import sk.uniza.fri.wof.prostredie.Pouzitelny;
import sk.uniza.fri.wof.prostredie.predmety.ObycajnyPredmet;
import sk.uniza.fri.wof.prostredie.predmety.Predmet;
import sk.uniza.fri.wof.zaklad.Hrac;

import java.util.Scanner;

public class Automat implements Vybavenie, Pouzitelny {
    @Override
    public String getNazov() {
        return "automat";
    }

    @Override
    public String getPopis() {
        return "Výpredaj bagiet a minerálok";
    }

    @Override
    public void pouzi(Hrac hrac) {
        System.out.println("Čo si chceš kúpiť?");
        System.out.println("1 - bagetu");
        System.out.println("2 - minerálku");

        var vstup = new Scanner(System.in);
        var cisloPolozky = vstup.nextInt();
        var novyPredmet = switch (cisloPolozky) {
            case 1 -> new ObycajnyPredmet("bageta");
            case 2 -> new ObycajnyPredmet("mineralka");
            default -> null;
        };
        hrac.pridajPredmetDoInventara(novyPredmet);
    }
}
