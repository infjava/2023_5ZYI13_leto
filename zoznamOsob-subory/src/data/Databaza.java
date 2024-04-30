package data;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Databaza implements Iterable<Osoba> {
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
        try (var subor = new ObjectOutputStream(new FileOutputStream(new File(cesta)))) {
            subor.writeObject(this.osoby);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void nacitajZoSuboru(String cesta) {
        try (var subor = new ObjectInputStream(new FileInputStream(new File(cesta)))) {
            this.osoby = (ArrayList<Osoba>)subor.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
