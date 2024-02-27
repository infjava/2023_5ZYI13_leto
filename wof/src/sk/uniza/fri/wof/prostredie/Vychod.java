package sk.uniza.fri.wof.prostredie;

import sk.uniza.fri.wof.zaklad.Hrac;

public class Vychod {
    private final Miestnost miestnost;

    public Vychod(Miestnost miestnost) {

        this.miestnost = miestnost;
    }

    public Miestnost getMiestnost() {
        return this.miestnost;
    }

    public boolean mozemVstupit(Hrac hrac) {
        return true;
    }
}
