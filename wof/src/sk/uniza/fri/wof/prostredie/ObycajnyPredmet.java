package sk.uniza.fri.wof.prostredie;

public class ObycajnyPredmet implements Predmet {
    private final String nazov;
    private boolean obute;

    public ObycajnyPredmet(String nazov) {
        this.nazov = nazov;
    }

    @Override
    public String getNazov() {
        return this.nazov;
    }

    @Override
    public void pouziSa() {
        switch (this.nazov) {
            case "navleky":
                this.obute = !this.obute;
                if (this.obute) {
                    System.out.println("Obul si si navleky");
                } else {
                    System.out.println("Vyzul si si navleky");
                }
                break;
            default:
                System.out.format("Predmet %s sa neda pouzit%n", this.nazov);
                break;
        }
    }
}
