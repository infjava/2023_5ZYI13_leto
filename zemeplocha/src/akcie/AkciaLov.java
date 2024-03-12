package akcie;

import hlavnyBalik.Policko;
import zemeplocha.Zemeplocha;

import javax.swing.*;

public class AkciaLov implements Akcia {
    private final int maxPocetLovcov;
    private final Policko druhePolicko;

    public AkciaLov(int maxPocetLovcov, Policko druhePolicko) {
        this.maxPocetLovcov = maxPocetLovcov;
        this.druhePolicko = druhePolicko;
    }

    @Override
    public String getNazov() {
        return "Lov";
    }

    @Override
    public void vykonaj(Zemeplocha zemeplocha) {
        var pocetLovcov = Integer.parseInt( JOptionPane.showInputDialog( null,
                "Zadaj pocet lovcov, ktori idu lovit.") );

        if (pocetLovcov > this.maxPocetLovcov) {
            JOptionPane.showMessageDialog( null, "Zvolene tvory nemaju taky pocet obyvatelov.");
            return;
        }

        var loveneZveri = this.druhePolicko.getObyvatelia().orElseThrow();
        loveneZveri.upravPopulaciu(-pocetLovcov);

        if (loveneZveri.getPopulacia() <= 0) {
            this.druhePolicko.zruseniObyvatelia();
        }
    }
}
