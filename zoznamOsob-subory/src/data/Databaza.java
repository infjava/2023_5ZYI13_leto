package data;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Databaza implements Iterable<Osoba> {
    private static final int MAGIC_NUMBER = 526485253;
    private static final int VERZIA = 1;

    private ArrayList<Osoba> osoby;



    public Databaza() {
        this.osoby = new ArrayList<>();
    }

    @Override
    public Iterator iterator() {
        return this.osoby.iterator();
    }

    public void pridajOsobu(Osoba osoba) {
        this.osoby.add(osoba);
    }

    public void zmazOsobu(Osoba osoba) {
        this.osoby.remove(osoba);
    }

    public void vygenerujOsoby() {
        this.osoby.add(new Osoba("Janko", "aaaa", 2));
        this.osoby.add(new Osoba("Janko", "aaaa", 3));
        this.osoby.add(new Osoba("Janko", "aaaa", 4));
    }

    public void ulozDoSuboru(String cesta) {
        try (var subor = new DataOutputStream(new FileOutputStream(new File(cesta)))) {
            subor.writeInt(MAGIC_NUMBER);
            subor.writeInt(VERZIA);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void nacitajZoSuboru(String cesta) {
        try (var subor = new DataInputStream(new FileInputStream(new File(cesta)))) {
            var magicNumber = subor.readInt();
            if (magicNumber != MAGIC_NUMBER) {
                throw new RuntimeException("Chybny format suboru");
            }
            var verzia = subor.readInt();
            if (verzia > VERZIA) {
                throw new RuntimeException("Chybna verzia programu");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
