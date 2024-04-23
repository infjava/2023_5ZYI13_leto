import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        var okno = new JFrame("Otázka");
        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        okno.setLayout(new BorderLayout());
        okno.add(new JLabel("Chceš úspešne skončiť predmet Informatika 2?"), BorderLayout.NORTH);

        var tlacidla = new JPanel();
        tlacidla.setLayout(new GridLayout());
        tlacidla.add(new JButton("Áno"));
        tlacidla.add(new JButton("Nie"));

        okno.add(tlacidla, BorderLayout.CENTER);

        okno.pack();
        okno.setVisible(true);
    }
}
