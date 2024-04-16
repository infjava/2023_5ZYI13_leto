package sk.uniza.fri.wof.prostredie;

import java.util.Scanner;

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
            return null; // TODO
        }
    }

    public Miestnost getStartovaciaMiestnost() {
        return this.startovaciaMiestnost;
    }
}
