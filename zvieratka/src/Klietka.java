/**
 * @param <E> typ zvierata v klietke
 */
public class Klietka<E extends Zviera<E>> {
    private E zviera;

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

    public void vlozZviera(E zviera) {
        this.zviera = zviera;
    }

    public void hodPotravu(Jedlo<E> jedlo) {
        this.zviera.zozer(jedlo);
    }
}
