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

    @Override
    public void hracZmenilMiestnost() {
        if (this.maBaterky) {
            System.out.println("RADIO: ♩ ♪ ♫ ♬ ♭ ♮ ♯ \uD83C\uDFBC \uD83C\uDFB5 \uD83C\uDFB6");
        }
    }

    public void vlozBaterky() {
        this.maBaterky = true;
    }
}
