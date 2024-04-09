import java.util.ArrayList;
import java.util.Iterator;

public class Prvocisla implements Iterable<Integer> {
    private final int max;
    private final ArrayList<Integer> prvocisla;

    public Prvocisla(int max) {
        this.max = max;

        this.prvocisla = new ArrayList<Integer>();

        for (int i = 2; i <= this.max; i++) {
            if (this.jePrvocislo(i)) {
                this.prvocisla.add(i);
            }
        }
    }

    private boolean jePrvocislo(int cislo) {
        for (int i = 2; i < cislo - 1; i++) {
            if ((cislo % i) == 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Iterator<Integer> iterator() {
        return this.prvocisla.iterator();
        //return new PrvocislaIterator(this.max);
    }
}
