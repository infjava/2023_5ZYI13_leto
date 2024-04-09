public class Main {
    public static void main(String[] args) {
        var lev = new Lev("Alex");
        var klietkaNaLeva = new Klietka();

        klietkaNaLeva.vypisPopis();
        klietkaNaLeva.vlozZviera(lev);
        klietkaNaLeva.vypisPopis();
    }
}