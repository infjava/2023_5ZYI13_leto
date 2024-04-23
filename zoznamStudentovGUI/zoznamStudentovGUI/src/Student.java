public class Student {
    private final String meno;
    private final String priezvisko;

    public Student(String meno, String priezvisko) {
        this.meno = meno;
        this.priezvisko = priezvisko;
    }

    public String getMeno() {
        return this.meno;
    }

    public String getPriezvisko() {
        return this.priezvisko;
    }

    @Override
    public String toString() {
        return this.meno + ' ' + this.priezvisko;
    }
}
