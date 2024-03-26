package sk.uniza.fri;

import sk.uniza.fri.nacitavanie.NacitavacSuboru;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class KonzoloveMenu {

    private Matica poleMatic [];

    public KonzoloveMenu() {
        this.poleMatic = new Matica[3];
    }

    public void spusti() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("----------------------------------------");
            System.out.println("Vitaj v jednoduchom nastroji na spracovanie matic!");
            System.out.println("Pre vykonanie operacie zadaj jej cislo:");
            System.out.println("1 - Nacitanie matice zo suboru");
            System.out.println("2 - Vypis matice");
            System.out.println("3 - Nasobenie matic, C = A x B.");
            System.out.println("4 - Delenie matic po prvkoch, C[i][j] = A[i][j] / B[i][j], pre vsetky i,j v matici.");
            System.out.println("5 - Nahradzanie hodnot");
            System.out.println("0 - Ukoncenie programu");
            System.out.println("----------------------------------------");
            while(!sc.hasNextInt()) {
                System.out.println("Neplatny vstup! zadaj znova:");
                sc.next();
            }
            int volba = sc.nextInt();
            switch (volba) {
                case 1:
                    // nacita maticu podla zadanieho indexu
                    poleMatic[this.vyberMatice(sc)] = this.nacitanieMatice(sc);
                    break;
                case 2:
                    int indexVyberu = this.vyberMatice(sc);
                    if(poleMatic[indexVyberu] != null) {
                        System.out.printf("Matica %c:%n", (char) 65 + indexVyberu);
                        poleMatic[indexVyberu].vypisMaticuDoKonzoly();
                    } else {
                        System.out.println("Zadana matica nie je nacitana");
                    }
                    break;
                case 3:
                    poleMatic[2] = poleMatic[0].vynasobMaticou(poleMatic[1]);
                    System.out.println("Vysledok nasobenia ulozeny do matice C");
                    break;
                case 4:
                    poleMatic[2] = poleMatic[0].vydelMaticePoPrvkoch(poleMatic[1]);
                    System.out.println("Vysledok delenia po prvkoch ulozeny do matice C");
                    break;
                case 5:
                    System.out.println("Toto si zial este neimplementoval");
                    break;
                case 0:
                    System.out.println("Ukonci program");
                    return;
                default:
                    System.out.println("Zla volba, zadaj volbu znova.");
            }
        }
    }

    // nacita maticu zo suboru
    public Matica nacitanieMatice(Scanner sc) throws FileNotFoundException {
            System.out.println("Zadaj cestu k suboru (ktory sa nachadza v priecinku subory):");
            String zlozkaSuborov = "src/sk/uniza/fri/subory/";
            String nazovSuboru = sc.next();
            NacitavacSuboru ns = new NacitavacSuboru(zlozkaSuborov + nazovSuboru);
            return ns.nacitajMaticu();
    }

    public int vyberMatice(Scanner sc) {
        while(true) {
            System.out.println("Ktoru maticu chces zvolit (A, B, C) ?");
            String volba = sc.next();
            int indexVolby = (int)volba.charAt(0) - 65;
            if (indexVolby >= 0 && indexVolby < 3) {
                return indexVolby;
            } else {
                System.out.println("Zla volba, opakuj volbu.");
            }
        }
    }
}
