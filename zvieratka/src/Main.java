public class Main {
    public static void main(String[] args) {
        var lev = new Lev("Alex");
        var klietkaNaLeva = new Klietka<Lev>();
//        var klietkaNaLeva = new Klietka<Lev, Syr>();

        klietkaNaLeva.vypisPopis();
        klietkaNaLeva.vlozZviera(lev);
        klietkaNaLeva.vypisPopis();
        klietkaNaLeva.hodPotravu(new Steak());
        klietkaNaLeva.hodPotravu(new Zajac("Fluffy"));
//        klietkaNaLeva.hodPotravu(new Syr());
//        klietkaNaLeva.vlozZviera(new Mys());
//        klietkaNaLeva.vypisPopis();

        var mys = new Mys();
        var klietkaNaMys = new Klietka<Mys>();
        klietkaNaMys.vypisPopis();
        klietkaNaMys.vlozZviera(mys);
        klietkaNaMys.vypisPopis();
        klietkaNaMys.hodPotravu(new Syr());
//        klietkaNaMys.vlozZviera(new Lev("Igor"));
//        klietkaNaMys.vypisPopis();

        var zajac = new Zajac("No pockaj");
        var klietkaNaZajaca = new Klietka<Zajac>();
        klietkaNaZajaca.vypisPopis();
        klietkaNaZajaca.vlozZviera(zajac);
        klietkaNaZajaca.vypisPopis();
        klietkaNaZajaca.hodPotravu(new Mrkva());
//
//        var divnaKlietka = new Klietka<Integer>();
//        divnaKlietka.vypisPopis();
//        divnaKlietka.vlozZviera(50);
//        divnaKlietka.vypisPopis();
    }
}