package akcie;

import hlavnyBalik.Policko;
import zemeplocha.Zemeplocha;

public class AkciaMnozenie implements Akcia {
    private final int koeficient;
    private final Policko druhePolicko;

    public AkciaMnozenie(int koeficient, Policko druhePolicko) {
        this.koeficient = koeficient;
        this.druhePolicko = druhePolicko;
    }

    @Override
    public String getNazov() {
        return "Množenie";
    }

    @Override
    public void vykonaj(Zemeplocha zemeplocha) {
        var obyvatelia = this.druhePolicko.getObyvatelia().orElseThrow();
        obyvatelia.rozmnozSa(this.koeficient);
    }
}
