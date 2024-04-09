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

        var zajac = new Zajac("No pockaj");
        var klietkaNaZajaca = new Klietka();
        klietkaNaZajaca.vypisPopis();
        klietkaNaZajaca.vlozZviera(zajac);
        klietkaNaZajaca.vypisPopis();

//        var divnaKlietka = new Klietka();
//        divnaKlietka.vypisPopis();
//        divnaKlietka.vlozZviera(50);
//        divnaKlietka.vypisPopis();
    }
}