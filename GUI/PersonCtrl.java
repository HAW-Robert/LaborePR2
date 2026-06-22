package GUI;


import java.awt.Container;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JComboBox;
import javax.swing.JButton;

import javax.swing.ButtonGroup;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PersonCtrl extends JFrame implements ActionListener{
    //Attribute
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
        //JFrame super aufruf
       super("Personen-Daten");
        //Ohne diese zeile und dem attribut personToShow würde in diesem file die informationen von personToShow verloren gehen und der code macht nicht was er soll
       this.personToShow = personToShow;
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = getContentPane();
    c.setLayout(new GridLayout(5, 5, 5,5));
    c.setBackground(getBackground());

        //Texte im Panel anlegen erst nur name noch keine position
    JLabel anrede = new JLabel("Anrede:  ");
    JLabel titel = new JLabel("Titel:  ");
    JLabel vorname = new JLabel("Vorname:");
    JLabel nachname = new JLabel("Nachname:");

        // JRadioButton sind die drei obersten knöpfe zum wählen der anrede
    herr   = new JRadioButton("herr",true); // set initially
    frau  = new JRadioButton("frau");
    keine = new JRadioButton("keine");

    //JComboBox obj namens eingabe wird erstellt || typ String || Zur auswahl stehen Inhalt des arrays 
    // JComboBox ist das ausklapp wahl menü für Titel
    eingabe = new JComboBox<String>(this.auswahl);

    //Erstellung der Texteingabefelder für Vor und Nachname
    vorname2 = new JTextField(personToShow.getGivenName() + "");
    nachname2 = new JTextField(personToShow.getSurname() + "");

    //JButton ist der bestätigungsknopf für den anwender 
    ok = new JButton("OK");
    //Ohne actionlistener keine funktion
    ok.addActionListener(this);

    //Durch gruppierung der buttons ist nur einer zurzeit anwählbar
    ButtonGroup bg = new ButtonGroup();
    bg.add(herr);
    bg.add(frau);
    bg.add(keine);
        //Obere "Zeile" im Fentser wierd erstellt
     JPanel panel = new JPanel();
     //Die knöpfe und das Label werden dem Panel geaddet
     //Das Panel dird "c" also de container geaddet
    panel.add(anrede);
    panel.add(herr);
    panel.add(frau);
    panel.add(keine);
    c.add(panel);
    setSize(500, 160);   
        setVisible(true);
        //Zeile zwei
    JPanel panel2 = new JPanel();
    panel2.add(titel);
    panel2.add(vorname);
    panel2.add(nachname);
    c.add(panel2);
    setSize(500, 200);   
        setVisible(true);
//Zeile drei
    JPanel panel3 = new JPanel();
    c.add(panel3);  
    panel3.add(eingabe); 
    panel3.add(vorname2);
    panel3.add(nachname2);
    panel3.add(ok);
     setVisible(true);
    }
   

    public static void main(String args[]){
        Person Tosch = new Person("Herr", "Dr.","Peter","Tosch");
        new PersonCtrl(Tosch);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        //Ist die quelle des "befehls" der Button "ok" ? Dann :
        if (e.getSource() == ok) {  // button pressed?

            //getSelectedItem funktioniert für die JComboBox
        String Titel = (String) eingabe.getSelectedItem();
        personToShow.setTitle(Titel);

        // isSelected funktioniert für die JRadioButtons
        if(herr.isSelected()){
            personToShow.setAdress("Herr");
        }else if(frau.isSelected()){
            personToShow.setAdress("Frau");
        }else{
            personToShow.setAdress(" ");
        }
        //getText wird für die JTextField verwendet
        personToShow.setGivenName(vorname2.getText());
        personToShow.setSurname(nachname2.getText());
     
     System.out.println("Titel " + Titel);
     

    } 
    }
}