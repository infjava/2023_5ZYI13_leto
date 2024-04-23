import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        var tlacidloNie = new JButton("Nie");

        this.pridajAkcie(tlacidloAno, tlacidloNie);
        this.pridajAkcie(tlacidloNie, tlacidloAno);

        tlacidla.add(tlacidloAno);
        tlacidla.add(tlacidloNie);

        this.okno.add(tlacidla, BorderLayout.CENTER);

        this.okno.pack();
    }

    private void pridajAkcie(JButton tlacidlo, JButton tlacidloDruhe) {
        tlacidlo.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "No vidíš, len sa treba snažiť!");
            System.exit(0);
        });

        tlacidlo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                tlacidlo.setText("Áno");
                tlacidloDruhe.setText("Nie");
            }
        });
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
