public class Zajac extends Zviera<Zajac> implements Nazvany {
    private final String meno;

    public Zajac(String meno) {
        this.meno = meno;
    }

    @Override
    public String getMeno() {
        return this.meno;
    }

    @Override
    public void zozer(Jedlo<Zajac> jedlo) {
        System.out.println("Zajac zozral mrkvu");
    }
}
