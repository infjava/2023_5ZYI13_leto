package sk.uniza.fri.wof.prostredie;

import sk.uniza.fri.wof.zaklad.Hrac;

public interface Vychod {
    Miestnost getMiestnost();

    boolean mozemVstupit(Hrac hrac);
}
