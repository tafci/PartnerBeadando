/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import model.Partner;
import model.PartnerModel;

/**
 *
 * @author johnny
 */
public class PartnerBeadando extends JFrame {

    private JButton torles;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JLabel cim;
    private JLabel fax;
    private JLabel mobil;
    private JLabel nev;
    private JLabel telefon;
    private JLabel telefonok;
    private JList partnerLista;
    private JList telefonLista;
    private JToggleButton hozzaad;
    private JTextField cimmezo;
    private JTextField faxmezo;
    private JTextField mobilmezo;
    private JTextField nevmezo;
    private JTextField telefonmezo;
    private JToggleButton modositas;
    JPanel contentPanel;
    JTable contentTable;
//    private ArrayList<String> tmp;
    // private JPanel contentPanel;

    public void initComp() {

        jScrollPane1 = new JScrollPane();
        jScrollPane2 = new JScrollPane();
        telefonLista = new JList();
        partnerLista = new JList();
        jScrollPane1.setViewportView(partnerLista);
        jScrollPane2.setViewportView(telefonLista);
        partnerLista.setModel(new PartnerModel());
        //  lstPartner.setCellRenderer(new PartnerView());
        jScrollPane2.setViewportView(telefonLista);
//gombok
        hozzaad = new JToggleButton();
         this.hozzaad.setText("Hozzáadás");
        modositas = new JToggleButton();
         this.modositas.setText("Módosítás");
        torles = new JButton();
         this.torles.setText("Törlés");
//Címkék
        telefon = new JLabel();
        mobil = new JLabel();
        fax = new JLabel();
        nev = new JLabel();
        cim = new JLabel();
        telefonok = new JLabel();
        nev.setText("Név:");
        cim.setText("Cím:");
        telefonok.setText("Telefonszámok:");
        telefon.setText("Telefon");
        mobil.setText("Mobil");
        fax.setText("Fax");
//textfieldek
        telefonmezo = new JTextField();
        mobilmezo = new JTextField();
        nevmezo = new JTextField();
        cimmezo = new JTextField();
        faxmezo = new JTextField();


            hozzaad.addActionListener(this::hozzaadasKlikk);
                    modositas.addActionListener(this::modositasKlikk);
        torles.addActionListener(this::torlesKlikk);
        partnerLista.addListSelectionListener(this::partnerListaV);
    }

    public PartnerBeadando() {
        initComp();

        this.setPreferredSize(new Dimension(680, 350));
        this.setTitle("Partner adatbázis");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        upperRow();
        //7    bottomRow();

        this.add(contentPanel);
        this.pack();
        this.setVisible(true);

    }

    private JPanel addRightPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        Dimension fieldDimension = new Dimension(200, 20);
        this.nevmezo.setPreferredSize(fieldDimension);
        this.cimmezo.setPreferredSize(fieldDimension);
        this.telefonmezo.setPreferredSize(fieldDimension);
        this.mobilmezo.setPreferredSize(fieldDimension);
        this.faxmezo.setPreferredSize(fieldDimension);
        this.telefonLista.setPreferredSize(new Dimension(200, 100));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Név: "), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Cím: "), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Telefon: "), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Mobil: "), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Fax: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(nevmezo, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(cimmezo, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(telefonmezo, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(mobilmezo, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(faxmezo, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panel.add(new JLabel("Telefonszámok: "), gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        JScrollPane scroll = new JScrollPane(telefonLista,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panel.add(scroll, gbc);

        return panel;
    }

    private void upperRow() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        Dimension fieldDimension = new Dimension(200, 20);
        partnerLista.setPreferredSize(new Dimension(200, 100));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.VERTICAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(partnerLista, gbc);


        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(addRightPanel(), gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(bottomRow(), gbc);
        contentPanel.add(panel);
        //addRightPanel();

    }

    private JPanel bottomRow() {
        JPanel panel1 = new JPanel();
        setLayout(new FlowLayout(FlowLayout.LEFT));
        panel1.add(hozzaad);
        panel1.add(modositas);
        panel1.add(torles);
        hozzaad.setPreferredSize(new Dimension(100, 25));
        modositas.setPreferredSize(new Dimension(100, 25));
        torles.setPreferredSize(new Dimension(100, 25));
        contentPanel.add(panel1);
        return panel1;
    }

    private void hozzaadasKlikk(ActionEvent evt) {
        if (this.hozzaad.isSelected()) {
            this.hozzaad.setText("Mentés");
            this.hozzaad.setIcon(new ImageIcon(getClass().getResource("/org/Images/Save-icon.png")));
            this.cimmezo.setText("");
            this.nevmezo.setText("");
            this.telefonmezo.setText("");
            this.mobilmezo.setText("");
            this.faxmezo.setText("");
            this.nevmezo.setEditable(true);
            this.cimmezo.setEditable(true);
            this.telefonmezo.setEditable(true);
            this.mobilmezo.setEditable(true);
            this.faxmezo.setEditable(true);
            this.partnerLista.setEnabled(false);
            this.modositas.setEnabled(false);
            this.torles.setEnabled(false);
        } else {
            this.hozzaad.setText("Új partner hozzáadása a listához");
            this.cimmezo.setText("");
            this.nevmezo.setText("");
            this.telefonmezo.setText("");
            this.mobilmezo.setText("");
            this.faxmezo.setText("");
            this.nevmezo.setEditable(false);
            this.cimmezo.setEditable(false);
            this.telefonmezo.setEditable(false);
            this.mobilmezo.setEditable(false);
            this.faxmezo.setEditable(false);
            this.partnerLista.setEnabled(true);
            this.modositas.setEnabled(true);
            this.torles.setEnabled(true);
        }

    }

    private void modositasKlikk(ActionEvent Event) {
        if (this.partnerLista.getSelectedIndex() != -1 && this.modositas.isSelected()) {
            this.modositas.setText("Mentés");
            this.modositas.setIcon(new ImageIcon(getClass().getResource("/org/Images/Save-icon.png")));
            this.nevmezo.setEditable(true);
            this.cimmezo.setEditable(true);
            this.telefonmezo.setEditable(true);
            this.mobilmezo.setEditable(true);
            this.faxmezo.setEditable(true);
            this.partnerLista.setEnabled(false);
            this.hozzaad.setEnabled(false);
            this.torles.setEnabled(false);
        } else if (this.partnerLista.getSelectedIndex() >= 0 && !this.modositas.isSelected()) {
            // ((PartnerModel) this.lstPartner.getModel()).updatePartner(this.lstPartner.getSelectedIndex(), ((Partner) this.lstPartner.getSelectedValue()).getId(), this.tfName.getText(), this.tfAddr.getText(), this.tfPhone.getText(), this.tfMobile.getText(), this.tfFax.getText());
            this.modositas.setText("Partner adatainak módosítása");
            this.nevmezo.setEditable(false);
            this.cimmezo.setEditable(false);
            this.telefonmezo.setEditable(false);
            this.mobilmezo.setEditable(false);
            this.faxmezo.setEditable(false);
            this.partnerLista.setEnabled(true);
            this.hozzaad.setEnabled(true);
            this.torles.setEnabled(true);
            this.telefonmezo.setText("");
            this.mobilmezo.setText("");
            this.faxmezo.setText("");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Nincs kiválasztott partner!");
        }
    }

    private void torlesKlikk(ActionEvent Event) {
        if (this.partnerLista.getSelectedIndex() >= 0) {
            //   int request = JOptionPane.showConfirmDialog(this, "Valóban törölni szeretné " + ((Partner) this.lstPartner.getSelectedValue()).getname() + " partnert?", "Figyelmeztetés", JOptionPane.YES_NO_OPTION);
//            System.out.println(request);
////            }
        }
    }
    
    private void partnerListaV(javax.swing.event.ListSelectionEvent evt) {                                    
        // TODO add your handling code here:
        if (this.partnerLista.getSelectedValue() != null) {
          this.nevmezo.setText(this.partnerLista.getName());
            //this.cimmezo.setText(((Partner) this.partnerLista.getSelectedValue()).getAddress());
        }
    }                                   

    public static void main(String[] args) {
        new PartnerBeadando().setVisible(true);
    }

}
