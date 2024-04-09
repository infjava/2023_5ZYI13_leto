public class Main {
    public static void main(String[] args) {
        var lev = new Lev("Alex");
        var klietkaNaLeva = new Klietka();

        klietkaNaLeva.vypisPopis();
        klietkaNaLeva.vlozZviera(lev);
        klietkaNaLeva.vypisPopis();

        var mys = new Mys();
        var klietkaNaMys = new Klietka();
        klietkaNaMys.vypisPopis();
        klietkaNaMys.vlozZviera(mys);
        klietkaNaMys.vypisPopis();
    }
}