import java.util.Iterator;

public class Range implements Iterable<Integer> {
    private final int hornaHranica;

    public Range(int hornaHranica) {
        this.hornaHranica = hornaHranica;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator(this.hornaHranica);
    }
}
