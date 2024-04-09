public class Lev extends Zviera<Lev> implements Nazvany {
    private final String meno;

    public Lev(String meno) {
        this.meno = meno;
    }

    @Override
    public String getMeno() {
        return this.meno;
    }

    @Override
    public void zozer(Jedlo<Lev> jedlo) {
        System.out.println("Lev zozral steak");
    }
}
