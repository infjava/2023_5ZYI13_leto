package obyvatelia;

import akcie.Akcia;
import akcie.AkciaLov;
import hlavnyBalik.Policko;

import java.util.ArrayList;

public class Lovci extends Ludia {
    public Lovci(int populacia) {
        super(populacia, TypObyvatela.LOVCI);
    }

    @Override
    public ArrayList<Akcia> dajAkcieNa(Policko mojePolicko, Policko druhePolicko) {
        var akcie = super.dajAkcieNa(mojePolicko, druhePolicko);

        var obyvatelia = druhePolicko.getObyvatelia();
        if (obyvatelia.isPresent() && obyvatelia.get() instanceof Zver) {
            akcie.add(new AkciaLov(this.getPopulacia(), druhePolicko));
        }

        return akcie;
    }

    @Override
    protected Tvory vytvorTvory(int pocetTvorov) {
        return new Lovci(pocetTvorov);
    }

    @Override
    public void prijmiUtok(int pocetUtocnikov) {
        this.upravPopulaciu(-pocetUtocnikov * 2);
    }

    @Override
    public int vypocitajSiluProtiutoku(int pocetUtocnikov) {
        return 1;
    }
}
