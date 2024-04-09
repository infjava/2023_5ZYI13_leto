import java.util.Iterator;

public class RangeIterator implements Iterator<Integer> {
    private final int hornaHranica;
    private int aktualnaHodnota;

    public RangeIterator(int hornaHranica) {
        this.hornaHranica = hornaHranica;
        this.aktualnaHodnota = 0;
    }

    @Override
    public boolean hasNext() {
        return this.aktualnaHodnota < this.hornaHranica;
    }

    @Override
    public Integer next() {
        this.aktualnaHodnota++;
        return this.aktualnaHodnota;
    }
}
