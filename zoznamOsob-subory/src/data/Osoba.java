package data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class Osoba implements Serializable {
    private String meno;
    private String priezvisko;
    private int vek;
    private String miestoNarodenia;

    public Osoba() {
    }

    public Osoba(String meno, String priezvisko, int vek, String miestoNarodenia) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.vek = vek;
        this.miestoNarodenia = miestoNarodenia;
    }

    public Osoba setMeno(String meno) {
        this.meno = meno;
        return this;
    }
    public String getMeno() {
        return this.meno;
    }
    public String getPriezvisko() {
        return this.priezvisko;
    }

    public Osoba setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
        return this;
    }

    public int getVek() {
        return this.vek;
    }

    public Osoba setVek(int vek) {
        this.vek = vek;
        return this;
    }

    public String getMiestoNarodenia() {
        return this.miestoNarodenia;
    }

    public void setMiestoNarodenia(String miestoNarodenia) {
        this.miestoNarodenia = miestoNarodenia;
    }

    @Override
    public String toString() {
        return this.priezvisko + " " + this.meno + " [" + this.vek + "] + narodeny(a): " + this.miestoNarodenia;
    }

    public void ulozDoSuboru(DataOutputStream subor)
            throws IOException {
        subor.writeUTF(this.meno);
        subor.writeUTF(this.priezvisko);
        subor.writeInt(this.vek);
    }

    public void nacitajZoSuboru(DataInputStream subor)
            throws IOException {
        this.meno = subor.readUTF();
        this.priezvisko = subor.readUTF();
        this.vek = subor.readInt();
    }
}
