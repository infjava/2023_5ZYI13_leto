package akcie;

import hlavnyBalik.Policko;
import zemeplocha.Zemeplocha;

import javax.swing.*;

public class AkciaUtok implements Akcia {
    private final int maxPocetUtocnikov;
    private final Policko mojePolicko;
    private final Policko druhePolicko;

    public AkciaUtok(int maxPocetUtocnikov, Policko mojePolicko, Policko druhePolicko) {
        this.maxPocetUtocnikov = maxPocetUtocnikov;
        this.mojePolicko = mojePolicko;
        this.druhePolicko = druhePolicko;
    }

    @Override
    public String getNazov() {
        return "utok";
    }

    @Override
    public void vykonaj(Zemeplocha zemeplocha) {
        var pocetUtocnikov = Integer.parseInt( JOptionPane.showInputDialog( null,
                "Zadaj pocet rytierov na utok.") );

        if (pocetUtocnikov > this.maxPocetUtocnikov) {
            JOptionPane.showMessageDialog( null, "Zvolene tvory nemaju taky pocet obyvatelov.");
            return;
        }

        var cielovyObyvatelia = this.druhePolicko.getObyvatelia().orElseThrow();
        if (pocetUtocnikov > cielovyObyvatelia.getPopulacia()) {
            pocetUtocnikov = cielovyObyvatelia.getPopulacia();
        }

        cielovyObyvatelia.upravPopulaciu(-pocetUtocnikov);
        if (cielovyObyvatelia.getPopulacia() <= 0) {
            this.druhePolicko.zruseniObyvatelia();
        }

        var mojiObyvatelia = this.mojePolicko.getObyvatelia().orElseThrow();
        mojiObyvatelia.upravPopulaciu(-pocetUtocnikov);
        if (mojiObyvatelia.getPopulacia() <= 0) {
            this.mojePolicko.zruseniObyvatelia();
        }
    }
}
