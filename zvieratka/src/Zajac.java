public class Zajac extends Zviera implements Nazvany {
    private final String meno;

    public Zajac(String meno) {
        this.meno = meno;
    }

    @Override
    public String getMeno() {
        return this.meno;
    }

    @Override
    public void zozer(Jedlo jedlo) {
        if (jedlo instanceof Mrkva) {
            System.out.println("Zajac zozral mrkvu");
        } else {
            System.out.println("Zajac toto nelubi");
        }
    }
}
