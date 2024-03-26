package sk.uniza.fri;


import java.util.NoSuchElementException;
import java.util.Random;

/**
 * 08-Apr-22 - 08:34
 *
 * @author milan
 */
public class Matica {
    private final double [][] polePrvkov;
    private final int pocetRiadkov;
    private final int pocetStlpcov;

    public Matica(double[][] polePrvkov) {
        this.polePrvkov = polePrvkov;
        this.pocetRiadkov = this.polePrvkov.length;
        this.pocetStlpcov = this.polePrvkov[0].length;
    }

    // naplni maticu nahodnymi prvkami
    public Matica(int pocetRiadkov, int pocetStlpcov, double rozsahOd, double rozsahDo) {
        this.pocetRiadkov = pocetRiadkov;
        this.pocetStlpcov = pocetStlpcov;
        Random rnd = new Random();
        this.polePrvkov = new double[pocetRiadkov][pocetStlpcov];
        for (int i = 0; i < pocetRiadkov; i++) {
            for (int j = 0; j < pocetStlpcov; j++) {
                this.polePrvkov[i][j] = rozsahOd + rnd.nextDouble() * (rozsahDo - rozsahOd);
            }
        }
    }

    public int getPocetRiadkov() {
        return this.pocetRiadkov;
    }

    public int getPocetStlpcov() {
        return this.pocetStlpcov;
    }

    public double dajPrvok(int i, int j) {
        return this.polePrvkov[i][j];
    }

    public Matica vydelMaticePoPrvkoch(Matica mat2) {
        double[][] vysledok = new double[this.pocetRiadkov][this.pocetStlpcov];
        for (int i = 0; i < vysledok.length; i++) {
            for (int j = 0; j < vysledok[0].length; j++) {
                vysledok[i][j] = this.dajPrvok(i, j) / mat2.dajPrvok(i, j);
            }
        }
        return new Matica(vysledok);
    }
    // operacia jednej s druhou
    public Matica vynasobMaticou(Matica mat2) {
        double[][] result = new double[ this.pocetRiadkov][mat2.pocetStlpcov];
        for (int i = 0; i <  this.pocetRiadkov; i++) {
            for (int j = 0; j < mat2.pocetStlpcov; j++) {
                for (int k = 0; k < mat2.pocetRiadkov; k++) {
                    result[i][j] +=  this.polePrvkov[i][k] * mat2.dajPrvok(k, j);
                }
            }
        }

        return new Matica(result);
    }

    //  metoda sa vypise aj inak
    public void vypisMaticuDoKonzoly() {
        for (int i = 0; i < this.pocetRiadkov; i++) {
            for (int j = 0; j < this.pocetStlpcov; j++) {
                System.out.printf(" %9.3f", this.polePrvkov[i][j]);
            }
            System.out.println();
        }
    }

}
