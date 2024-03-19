package obyvatelia;

public class Zver extends Tvory {
    public Zver(int populacia, TypObyvatela typObyvatela) {
        super(populacia, typObyvatela);
    }

    @Override
    protected Tvory vytvorTvory(int pocetTvorov) {
        return new Zver(pocetTvorov, this.getTypObyvatela());
    }
}
