public class Lev extends Zviera implements Nazvany {
    private final String meno;

    public Lev(String meno) {
        this.meno = meno;
    }

    @Override
    public String getMeno() {
        return this.meno;
    }

    @Override
    public void zozer(Jedlo jedlo) {
        if (jedlo instanceof Steak) {
            System.out.println("Lev zozral steak");
        } else {
            System.out.println("Lev chce steak, nie takuto hovadinu");
        }
    }
}
