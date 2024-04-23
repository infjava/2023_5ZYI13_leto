import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OknoSOtazkou {
    private final JFrame okno;

    public OknoSOtazkou() {
        this.okno = new JFrame("Otázka");
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.okno.setLayout(new BorderLayout());
        this.okno.add(new JLabel("Chceš úspešne skončiť predmet Informatika 2?"), BorderLayout.NORTH);

        var tlacidla = new JPanel();
        tlacidla.setLayout(new GridLayout());
        var tlacidloAno = new JButton("Áno");

        tlacidloAno.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "No vidíš, len sa treba snažiť!");
            System.exit(0);
        });

        tlacidla.add(tlacidloAno);
        tlacidla.add(new JButton("Nie"));

        this.okno.add(tlacidla, BorderLayout.CENTER);

        this.okno.pack();
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
