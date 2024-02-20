public class Main {
    public static void main(String[] args) {
        var ferkoMrkvicka = new Student("Ferko", "Mrkvička", "123456");
        var skupina = new Skupina("5ZYI13");
        skupina.pridaj(ferkoMrkvicka);
        skupina.vypis();
    }
}