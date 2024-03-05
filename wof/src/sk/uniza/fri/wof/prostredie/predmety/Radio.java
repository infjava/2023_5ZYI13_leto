package sk.uniza.fri.wof.prostredie.predmety;

import sk.uniza.fri.wof.zaklad.Hrac;

public class Radio implements Predmet {
    private boolean maBaterky;

    public Radio() {
        this.maBaterky = false;
    }

    @Override
    public String getNazov() {
        return "radio";
    }

    @Override
    public void pouzi(Hrac hrac) {
        System.out.println("Radio sa neda pouzit");
    }

    @Override
    public boolean mozemPolozit() {
        return true;
    }

    public void vlozBaterky() {
        this.maBaterky = true;
    }
}
