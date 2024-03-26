package sk.uniza.fri.nacitavanie;

import sk.uniza.fri.Matica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 08-Apr-22 - 08:34
 *
 * @author milan
 */
public class NacitavacSuboru {

    private String cestaKSuboru;

    public NacitavacSuboru(String cestaKSuboru) {
        this.cestaKSuboru = cestaKSuboru;
    }

    public Matica nacitajMaticu() throws FileNotFoundException {
        File file = new File(this.cestaKSuboru);
        Scanner scanner = new Scanner(file);
        // na zaciatku pocet riadkov a stlpcov
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        double[][] matica = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matica[i][j] = scanner.nextDouble();
            }
        }
        scanner.close();
        return new Matica(matica);
    }
}
