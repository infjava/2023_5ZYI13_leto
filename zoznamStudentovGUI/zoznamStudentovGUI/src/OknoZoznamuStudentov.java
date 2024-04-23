import javax.swing.*;

public class OknoZoznamuStudentov {
    private final JFrame okno;
    private final DefaultListModel<Student> modelStudentov;

    private JList<Student> zoznamStudentov;
    private JPanel obsahOkna;
    private JButton pridajButton;
    private JButton odstranButton;
    private JButton upravButton;

    public OknoZoznamuStudentov() {
        this.modelStudentov = new DefaultListModel<>();

        this.modelStudentov.addElement(new Student("Ferko", "Mrkvička"));
        this.modelStudentov.addElement(new Student("Jožko", "Mrkvička"));
        this.modelStudentov.addElement(new Student("Dežko", "Mrkvička"));

        this.zoznamStudentov.setModel(this.modelStudentov);

        this.okno = new JFrame("Zoznam študentov");
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.okno.add(this.obsahOkna);

        this.okno.pack();
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
