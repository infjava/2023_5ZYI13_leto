package sk.uniza.fri.wof.prostredie;

import sk.uniza.fri.wof.zaklad.Hrac;

public class ObycajnyVychod implements Vychod {
    private final Miestnost miestnost;

    public ObycajnyVychod(Miestnost miestnost) {

        this.miestnost = miestnost;
    }

    @Override
    public Miestnost getMiestnost() {
        return this.miestnost;
    }

    @Override
    public boolean mozemVstupit(Hrac hrac) {
        return true;
    }
}
