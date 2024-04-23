import javax.swing.*;
import java.awt.*;

public class OknoSOtazkou {

    private final JFrame okno;

    public OknoSOtazkou() {
        this.okno = new JFrame("Otázka");
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.okno.setLayout(new BorderLayout());
        this.okno.add(new JLabel("Chceš úspešne skončiť predmet Informatika 2?"), BorderLayout.NORTH);

        var tlacidla = new JPanel();
        tlacidla.setLayout(new GridLayout());
        tlacidla.add(new JButton("Áno"));
        tlacidla.add(new JButton("Nie"));

        this.okno.add(tlacidla, BorderLayout.CENTER);

        this.okno.pack();
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
