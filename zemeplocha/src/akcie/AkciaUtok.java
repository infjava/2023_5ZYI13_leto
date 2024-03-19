package akcie;

import hlavnyBalik.Policko;
import zemeplocha.Zemeplocha;

public class AkciaUtok implements Akcia {
    public AkciaUtok(int maxPocetUtocnikov, Policko mojePolicko, Policko druhePolicko) {
    }

    @Override
    public String getNazov() {
        return "utok";
    }

    @Override
    public void vykonaj(Zemeplocha zemeplocha) {

    }
}
