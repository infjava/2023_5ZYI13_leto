public class Mys extends Zviera {
    @Override
    public void zozer(Jedlo jedlo) {
        if (!(jedlo instanceof Syr)) {
            throw new NespravnaPotravaException();
        }

        System.out.println("Mys zozrala syr");
    }
}
