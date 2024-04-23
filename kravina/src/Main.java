import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        var okno = new JFrame("Otázka");
        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        okno.add(new JLabel("Chceš úspešne skončiť predmet Informatika 2?"));

        okno.pack();
        okno.setVisible(true);
    }
}
