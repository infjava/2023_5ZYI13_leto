package obyvatelia;

import akcie.Akcia;
import akcie.AkciaUtok;
import hlavnyBalik.Policko;

import java.util.ArrayList;

public class Rytieri extends Ludia {
    public Rytieri(int populacia) {
        super(populacia, TypObyvatela.RYTIERI);
    }

    @Override
    public ArrayList<Akcia> dajAkcieNa(Policko mojePolicko, Policko druhePolicko) {
        var akcie = super.dajAkcieNa(mojePolicko, druhePolicko);

        var obyvatelia = druhePolicko.getObyvatelia();
        if (obyvatelia.isPresent() && obyvatelia.get() instanceof Ludia && mojePolicko != druhePolicko) {
            akcie.add(new AkciaUtok(this.getPopulacia(), mojePolicko, druhePolicko));
        }

        return akcie;
    }

    @Override
    protected Tvory vytvorTvory(int pocetTvorov) {
        return new Rytieri(pocetTvorov);
    }

    @Override
    public void prijmiUtok(int pocetUtocnikov) {
        this.upravPopulaciu(-pocetUtocnikov);
    }

    @Override
    public int vypocitajSiluProtiutoku(int pocetUtocnikov) {
        if (pocetUtocnikov > this.getPopulacia()) {
            return this.getPopulacia();
        } else {
            return pocetUtocnikov;
        }
    }
}
