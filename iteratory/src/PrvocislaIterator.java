import java.util.Iterator;

public class PrvocislaIterator implements Iterator<Integer> {
    private final int max;
    private int aktualnaHodnota;

    public PrvocislaIterator(int max) {
        this.max = max;
        this.aktualnaHodnota = 2;
    }

    @Override
    public boolean hasNext() {
        return this.aktualnaHodnota <= this.max;
    }

    @Override
    public Integer next() {
        var prvocislo = this.aktualnaHodnota;
        do {
            this.aktualnaHodnota++;
        } while (!this.jePrvocislo(this.aktualnaHodnota));
        return prvocislo;
    }


    private boolean jePrvocislo(int cislo) {
        for (int i = 2; i < cislo - 1; i++) {
            if ((cislo % i) == 0) {
                return false;
            }
        }

        return true;
    }
}
