import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        var okno = new JFrame("Otázka");
        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        okno.setLayout(new GridLayout(2, 2));
        okno.add(new JLabel("Chceš úspešne skončiť predmet Informatika 2?"));
        okno.add(new JLabel());
        okno.add(new JButton("Áno"));
        okno.add(new JButton("Nie"));

        okno.pack();
        okno.setVisible(true);
    }
}
