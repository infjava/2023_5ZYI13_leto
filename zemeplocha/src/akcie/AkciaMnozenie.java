package akcie;

import hlavnyBalik.Policko;
import zemeplocha.Zemeplocha;

public class AkciaMnozenie implements Akcia {
    public AkciaMnozenie(Policko mojePolicko, Policko druhePolicko) {
    }

    @Override
    public String getNazov() {
        return "Množenie";
    }

    @Override
    public void vykonaj(Zemeplocha zemeplocha) {
        System.out.println("Mnozte sa!!!");
    }
}
