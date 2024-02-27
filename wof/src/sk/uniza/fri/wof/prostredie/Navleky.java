package sk.uniza.fri.wof.prostredie;

public class Navleky implements Predmet {
    private boolean obute;

    public Navleky() {
        this.obute = false;
    }

    @Override
    public String getNazov() {
        return "navleky";
    }

    @Override
    public void pouziSa() {
        this.obute = !this.obute;
        if (this.obute) {
            System.out.println("Obul si si navleky");
        } else {
            System.out.println("Vyzul si si navleky");
        }
    }

    @Override
    public boolean mozemPolozit() {
        return !this.obute;
    }

    @Override
    public boolean jeNasadeny() {
        return this.obute;
    }
}
