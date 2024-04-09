import java.util.Iterator;

public class LepsiePrvocisla implements Iterable<Integer> {
    private final int max;

    public LepsiePrvocisla(int max) {
        this.max = max;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new PrvocislaIterator(this.max);
    }
}
