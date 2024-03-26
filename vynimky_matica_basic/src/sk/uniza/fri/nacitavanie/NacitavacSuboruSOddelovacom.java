package sk.uniza.fri.nacitavanie;

import sk.uniza.fri.Matica;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 08-Apr-22 - 08:34
 *
 * @author milan
 */
public class NacitavacSuboruSOddelovacom {

    private String oddelovac;

    public NacitavacSuboruSOddelovacom(String oddelovac) {
        this.oddelovac = oddelovac;
    }

    public Matica nacitajScannerom(Scanner citac) {
        // subor sa cita po riadkoch a riadky sa ukladaju do ArrayList-u
        ArrayList<double[]> zoznamRiadkov = new ArrayList<>();
        int pocetStlpcov = -1;
        int pocitadloRiadkov = 0;

        // cita kym ma dalsie riadky
        while (citac.hasNextLine()) {
            String riadok = citac.nextLine();
            // riadok sa rozdeli podla oddelovaca
            String[] stlpce = riadok.split(this.oddelovac);
            // pocet stlpcov matice sa urci podla 1. riadka
            if (pocetStlpcov < 0) {
                pocetStlpcov = stlpce.length;
            }
            // vytvori sa pole reprezentujuce riadok matice
            double [] pole = new double[pocetStlpcov];
            // nacita sa kazdy prvok pola
            for (int j = 0; j < stlpce.length; j++) {
                pole[j] = Double.parseDouble(stlpce[j]);
            }
            zoznamRiadkov.add(pole);
            pocitadloRiadkov++;
        }
        // riadky sa prekopiruju do matice
        double [][] matica = new double[zoznamRiadkov.size()][pocetStlpcov];
        for (int i = 0; i < zoznamRiadkov.size(); i++) {
            matica[i] = zoznamRiadkov.get(i);
        }
        return new Matica(matica);
    }
}
