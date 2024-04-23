import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        var okno = new JFrame("Otázka");
        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        okno.setLayout(new BorderLayout());
        okno.add(new JLabel("Chceš úspešne skončiť predmet Informatika 2?"), BorderLayout.NORTH);
        okno.add(new JButton("Áno"), BorderLayout.WEST);
        okno.add(new JButton("Nie"), BorderLayout.EAST);

        okno.pack();
        okno.setVisible(true);
    }
}
