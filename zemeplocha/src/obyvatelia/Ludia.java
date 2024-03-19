package obyvatelia;

public abstract class Ludia extends Tvory {
    public Ludia(int populacia, TypObyvatela typObyvatela) {
        super(populacia, typObyvatela);
    }

    public abstract void prijmiUtok(int pocetUtocnikov);

    public abstract int vypocitajSiluProtiutoku(int pocetUtocnikov);
}
