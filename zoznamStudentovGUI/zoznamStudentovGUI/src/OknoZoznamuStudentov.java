import javax.swing.*;

public class OknoZoznamuStudentov {
    private final JFrame okno;

    private JList zoznamStudentov;
    private JPanel obsahOkna;
    private JButton pridajButton;
    private JButton odstranButton;
    private JButton upravButton;

    public OknoZoznamuStudentov() {
        this.okno = new JFrame("Zoznam študentov");
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.okno.add(this.obsahOkna);

        this.okno.pack();
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
