package obyvatelia;

import akcie.Akcia;
import akcie.AkciaMnozenie;
import akcie.AkciaPresidlenie;
import hlavnyBalik.Policko;

import java.util.ArrayList;

public class Magovia extends Tvory {
    public Magovia(int populacia, int koeficientMagie) {
        super(populacia, TypObyvatela.MAGOVIA);
    }

    @Override
    public ArrayList<Akcia> dajAkcieNa(Policko mojePolicko, Policko druhePolicko) {
        ArrayList<Akcia> akcie = new ArrayList<>();
        var obyvatelia = druhePolicko.getObyvatelia();
        if (obyvatelia.isPresent() && !(obyvatelia.get() instanceof Magovia)) {
            akcie.add(new AkciaMnozenie(mojePolicko, druhePolicko));
        }
        return akcie;
    }
}
