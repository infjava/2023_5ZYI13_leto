package sk.uniza.fri.wof.prostredie;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hodinky implements Predmet {
    @Override
    public String getNazov() {
        return "hodinky";
    }

    @Override
    public void pouziSa() {
        var dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        var now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

    @Override
    public boolean mozemPolozit() {
        return true;
    }

    @Override
    public boolean jeNasadeny() {
        return false;
    }
}
