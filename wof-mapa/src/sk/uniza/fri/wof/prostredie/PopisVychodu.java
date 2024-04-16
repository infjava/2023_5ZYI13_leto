package sk.uniza.fri.wof.prostredie;

import java.util.Optional;

class PopisVychodu {
    private final Miestnost aktualnaMiestnost;
    private final String smer;
    private final Optional<String> typ;
    private final Iterable<String> cieloveMiestnosti;

    public PopisVychodu(Miestnost aktualnaMiestnost, String smer, Optional<String> typ, Iterable<String> cieloveMiestnosti) {
        this.aktualnaMiestnost = aktualnaMiestnost;
        this.smer = smer;
        this.typ = typ;
        this.cieloveMiestnosti = cieloveMiestnosti;
    }

    public Miestnost getAktualnaMiestnost() {
        return this.aktualnaMiestnost;
    }

    public String getSmer() {
        return this.smer;
    }

    public Optional<String> getTyp() {
        return this.typ;
    }

    public Iterable<String> getCieloveMiestnosti() {
        return this.cieloveMiestnosti;
    }
}
