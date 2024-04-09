public class Klietka {
    private Lev lev;

    public Klietka() {
        this.lev = null;
    }

    public void vypisPopis() {
        if (this.lev == null) {
            System.out.println("Prazdna klietka");
        } else {
            System.out.printf("V klietke je lev %s%n", this.lev.getMeno());
        }
    }

    public void vlozZviera(Lev lev) {
        this.lev = lev;
    }
}
