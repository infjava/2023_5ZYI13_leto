package obyvatelia;

public class Zver extends Tvory {
    public Zver(int populacia, TypObyvatela typObyvatela) {
        super(populacia, typObyvatela);
    }

    @Override
    public Tvory vytvorTvory(int pocetTvorov) {
        return new Zver(pocetTvorov, this.getTypObyvatela());
    }
}
