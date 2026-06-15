package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.TileObserver;

import javax.swing.JComboBox;
import javax.swing.JButton;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PersonCtrl extends JFrame implements ActionListener{
    
  private JRadioButton herr;
  private JRadioButton frau;
  private JRadioButton keine;
  private JButton ok;
  private JComboBox<String> eingabe;
  private String[] auswahl = {" ","Dr.","Prof. Dr."};
  private JTextField vorname2;
  private JTextField nachname2;
  private Person personToShow;
    
    public PersonCtrl(Person personToShow){
       super("Personen-Daten");

       this.personToShow = personToShow;
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = getContentPane();
    c.setLayout(new GridLayout(5, 5, 5,5));
    c.setBackground(getBackground());


    JLabel anrede = new JLabel("Anrede:  ");
    JLabel titel = new JLabel("Titel:  ");
    JLabel vorname = new JLabel("Vorname:");
    JLabel nachname = new JLabel("Nachname:");


    herr   = new JRadioButton("herr",true); // set initially
    frau  = new JRadioButton("frau");
    keine = new JRadioButton("keine");

    //JComboBox obj namens eingabe wird erstellt || typ String || Zur auswahl stehen Inhalt des arrays 
    eingabe = new JComboBox<String>(this.auswahl);

    //Erstellung der Texteingabefelder für Vor und Nachname
    vorname2 = new JTextField(personToShow.getGivenName() + "");
    nachname2 = new JTextField(personToShow.getSurname() + "");
    ok = new JButton("OK");
    ok.addActionListener(this);

    ButtonGroup bg = new ButtonGroup();
    bg.add(herr);
    bg.add(frau);
    bg.add(keine);

     JPanel panel = new JPanel();
    panel.add(anrede);
    panel.add(herr);
    panel.add(frau);
    panel.add(keine);
    c.add(panel);
    setSize(500, 160);   
        setVisible(true);

    JPanel panel2 = new JPanel();
    panel2.add(titel);
    panel2.add(vorname);
    panel2.add(nachname);
    c.add(panel2);
    setSize(500, 200);   
        setVisible(true);

    JPanel panel3 = new JPanel();
    c.add(panel3);  
    panel3.add(eingabe); 
    panel3.add(vorname2);
    panel3.add(nachname2);
    panel3.add(ok);
     setVisible(true);
    }
    public void actionPerformed(ActionEvent e, Person personToShow) {
    
  }

    public static void main(String args[]){
        Person Tosch = new Person("Herr", "Dr.","Peter","Tosch");
        new PersonCtrl(Tosch);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {  // button pressed?
        String Titel = (String) eingabe.getSelectedItem();
     personToShow.setTitle(Titel);
     System.out.println("Titel " + Titel);
     

    } 
    }
}