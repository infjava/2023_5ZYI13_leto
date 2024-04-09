public class Klietka {
    private Object zviera;

    public Klietka() {
        this.zviera = null;
    }

    public void vypisPopis() {
        if (this.zviera == null) {
            System.out.println("Prazdna klietka");
        } else if (this.zviera instanceof Lev lev) {
            System.out.printf("V klietke je lev %s%n", lev.getMeno());
        } else if (this.zviera instanceof Zajac zajac) {
            System.out.printf("V klietke je zajac %s%n", zajac.getMeno());
        } else {
            System.out.println("V klietke je zviera");
        }
    }

    public void vlozZviera(Object zviera) {
        this.zviera = zviera;
    }
}
