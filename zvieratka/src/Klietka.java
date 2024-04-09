public class Klietka {
    private Zviera zviera;

    public Klietka() {
        this.zviera = null;
    }

    public void vypisPopis() {
        if (this.zviera == null) {
            System.out.println("Prazdna klietka");
        } else if (this.zviera instanceof Nazvany nazvaneZviera) {
            System.out.printf("V klietke je zviera %s%n", nazvaneZviera.getMeno());
        } else {
            System.out.println("V klietke je zviera");
        }
    }

    public void vlozZviera(Zviera zviera) {
        this.zviera = zviera;
    }
}
