import javax.swing.*;
import java.awt.event.*;

public class PridajStudenta extends JDialog {
    private final DefaultListModel<Student> modelStudentov;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField meno;
    private JTextField priezvisko;

    public PridajStudenta(DefaultListModel<Student> modelStudentov) {
        this.modelStudentov = modelStudentov;
        this.setTitle("Pridaj študenta");

        this.setContentPane(this.contentPane);
        this.setModal(true);
        this.getRootPane().setDefaultButton(this.buttonOK);

        this.buttonOK.addActionListener(e -> this.onOK());

        this.buttonCancel.addActionListener(e -> this.onCancel());

        // call onCancel() when cross is clicked
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                PridajStudenta.this.onCancel();
            }
        });

        // call onCancel() on ESCAPE
        this.contentPane.registerKeyboardAction(
                e -> PridajStudenta.this.onCancel(),
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT
        );

        this.pack();

        this.setResizable(false);
    }

    private void onOK() {
        this.modelStudentov.addElement(
                new Student(
                        this.meno.getText(),
                        this.priezvisko.getText()
                )
        );
        this.dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        this.dispose();
    }
}
