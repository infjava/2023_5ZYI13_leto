
import data.Databaza;
import gui.OsobyOkienko;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        var db = new Databaza();
        db.vygenerujOsoby();

        var ook = new OsobyOkienko(db);

    }
}