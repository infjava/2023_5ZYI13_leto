package sk.uniza.fri.wof.prostredie;

public class Predmet {
    private final String nazov;

    public Predmet(String nazov) {
        this.nazov = nazov;
    }

    public String getNazov() {
        return this.nazov;
    }

    public void pouziSa() {
        System.out.format("Predmet %s sa neda pouzit%n", this.nazov);
    }
}
