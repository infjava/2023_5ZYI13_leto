package gui;

import data.Databaza;
import data.Osoba;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class OsobyOkienko {
    private final DefaultListModel<Osoba> model;
    private JFrame okno;
    private JList osobyList;
    private JPanel panel1;
    private JButton NovyBtn;
    private JButton ZmazatBtn;
    private JButton UlozitBtn;
    private JButton NacitatBtn;
    private Databaza db;

    public OsobyOkienko(Databaza db) {
        this.db = db;


        this.okno = new JFrame("OSOBEEE");
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.okno.setContentPane(this.panel1);
        this.okno.pack();
        this.okno.setVisible(true);

        this.model = new DefaultListModel<Osoba>();
        this.osobyList.setModel(this.model);
        this.nacitajDataZDb();

        this.osobyList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Osoba s = (Osoba)OsobyOkienko.this.osobyList.getSelectedValue();
                    var d = new OsobaEditOkienko(OsobyOkienko.this.okno, s);

                    OsobyOkienko.this.osobyList.revalidate();
                }
            }
        });

        this.NovyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Osoba no = new Osoba();
                var d = new OsobaEditOkienko(OsobyOkienko.this.okno, no);

                if (d.getUlozit()) {
                    OsobyOkienko.this.db.pridajOsobu(no);
                    OsobyOkienko.this.model.addElement(no);
                }

                OsobyOkienko.this.osobyList.revalidate();
            }
        });

        this.ZmazatBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Osoba s = (Osoba)OsobyOkienko.this.osobyList.getSelectedValue();
                OsobyOkienko.this.model.removeElement(s);
                OsobyOkienko.this.db.zmazOsobu(s);

                OsobyOkienko.this.osobyList.revalidate();
            }
        });

        this.UlozitBtn.addActionListener(e -> this.ulozDoSuboru());
        this.NacitatBtn.addActionListener(e -> this.nacitajZoSuboru());

    }

    private void ulozDoSuboru() {
        var vyberSuboru = new JFileChooser();

        this.nastavFiltre(vyberSuboru);

        var vysledok = vyberSuboru.showSaveDialog(this.okno);

        if (vysledok == JFileChooser.APPROVE_OPTION) {
            var vybratySubor = vyberSuboru.getSelectedFile();
            var vybrataCesta = vybratySubor.getAbsolutePath();
            if (!vybratySubor.getName().contains(".")) {
                vybrataCesta += ".osoba";
            }
            this.db.ulozDoSuboru(vybrataCesta);
        }
    }

    private void nacitajZoSuboru() {
        var vyberSuboru = new JFileChooser();

        this.nastavFiltre(vyberSuboru);

        do {
            int vysledok = vyberSuboru.showOpenDialog(this.okno);
            if (vysledok != JFileChooser.APPROVE_OPTION) {
                return;
            }
        } while (vyberSuboru.getSelectedFile() == null || !vyberSuboru.getSelectedFile().exists());

        this.db.nacitajZoSuboru(vyberSuboru.getSelectedFile().getAbsolutePath());
        this.nacitajDataZDb();
    }

    private void nastavFiltre(JFileChooser vyberSuboru) {
        var filter = new FileNameExtensionFilter("Zoznam osôb", "osoba");
        vyberSuboru.addChoosableFileFilter(filter);
        vyberSuboru.setFileFilter(filter);
    }

    public void nacitajDataZDb() {
        this.model.clear();
        for (Osoba o : this.db) {
            this.model.addElement(o);
        }

    }
}
