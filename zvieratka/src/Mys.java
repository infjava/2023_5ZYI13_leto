public class Mys extends Zviera {
    @Override
    public void zozer(Jedlo jedlo) {
        if (jedlo instanceof Syr) {
            System.out.println("Mys zozrala syr");
        } else {
            System.out.println("Mys je sice hladna, ale toto nevymyslaj");
        }
    }
}
