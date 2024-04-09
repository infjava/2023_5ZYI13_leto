public class Zajac implements Nazvany {
    private final String meno;

    public Zajac(String meno) {
        this.meno = meno;
    }

    @Override
    public String getMeno() {
        return this.meno;
    }
}
