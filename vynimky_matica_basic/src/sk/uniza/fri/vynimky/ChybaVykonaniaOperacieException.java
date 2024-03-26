package sk.uniza.fri.vynimky;

public class ChybaVykonaniaOperacieException extends Exception {
    private final int riadok;
    private final int stlpec;

    public ChybaVykonaniaOperacieException(Throwable cause, int riadok, int stlpec) {
        super(cause);

        this.riadok = riadok;
        this.stlpec = stlpec;
    }

    public int getRiadok() {
        return this.riadok;
    }

    public int getStlpec() {
        return this.stlpec;
    }
}
