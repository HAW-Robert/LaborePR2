package Rechner;
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

public class CalcControl extends JFrame implements ActionListener {
 private JComboBox<String> präfix1 ;
 private JComboBox<String> präfix2 ;
 private String[] auswahl = {"Kilo", " ", "milli"};
    private JTextField spannung ;
    private JTextField stromstärke ;
    private JRadioButton Bogenmaß;
    private JRadioButton Gradmaß;
    private JButton ok;
    private JTextField winkeleingabe;

    private double Volt;
    private double Ampere;
    private int winkelIn;
    private double winkelGrad;
    private String präfixus;
    private String präfixusMaximus;
    private double phi;
    private double p;
    private JLabel Ergebnis;
    private JLabel Entspricht;

    public CalcControl(){
        super("WirkleistungsRechner");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = getContentPane();
    c.setLayout(new GridLayout(6, 7, 6,6));
    c.setBackground(getBackground());
   
         
    //Beschreibung der verschieden flächen im fenster
    //JLabel präfix2 = new JLabel("präfix :  ");
    JLabel spannung1 = new JLabel("Spannung :  ");
    JLabel stromstärke2 = new JLabel("Stromstärke :");
    JLabel winkel = new JLabel("Winkjel in :");
    JLabel phi = new JLabel("Phasenwinkel :");
    JLabel ergebnis = new JLabel("Ergebnis :");
     Ergebnis = new JLabel(String.valueOf(p));
    JLabel entspricht = new JLabel("Entspricht :");
     Entspricht = new JLabel(String.valueOf(Rechner.umRechner(p)));

        //RadioButtons
    Bogenmaß = new JRadioButton("Bogenmaß", true);
    Gradmaß = new JRadioButton("Gradmaß");

        //ComboBox
    präfix1 = new JComboBox<String>(this.auswahl);
    präfix2 = new JComboBox<String>(this.auswahl);

        //Textfelder zur eingabe
    spannung =      new JTextField();
    stromstärke =   new JTextField();
    winkeleingabe = new JTextField();

    //JButton ist der bestätigungsknopf für den anwender 
    ok = new JButton("OK");
    //Ohne actionlistener keine funktion
    ok.addActionListener(this);
         //Button group für radioButton
    ButtonGroup bg = new ButtonGroup();
    bg.add(Bogenmaß);
    bg.add(Gradmaß);

    //Start des aufbaus des fensters 
    JPanel panel = new JPanel();
    panel.add(spannung1);
    panel.add(präfix1);
    panel.add(spannung);
    c.add(panel);

    JPanel panel2 = new JPanel();
    panel2.add(stromstärke2);
    panel2.add(präfix2);
    panel2.add(stromstärke);
    c.add(panel2);

    JPanel panel3 = new JPanel();
    panel3.add(winkel);
    panel3.add(Bogenmaß);
    panel3.add(Gradmaß);
    c.add(panel3);

    JPanel panel4 = new JPanel();
    panel4.add(phi);
    panel4.add(winkeleingabe);
    panel4.add(ok);
    c.add(panel4);

    JPanel panel5 = new JPanel();
    panel5.add(ergebnis);
    panel5.add(Ergebnis);

   c.add(panel5);

    JPanel panel6 = new JPanel();
    panel6.add(entspricht);
    panel6.add(Entspricht);

    c.add(panel6);

     setSize(400, 300);    // größe des Fensters

    setLocationRelativeTo(null);    // Entweder setLocation und dann x und y geben oder setLocationRealtiveTo ( null) um die bildschirmitte 

    setVisible(true); 

    }
    
   
   
   public static void main(String[] args){
    new CalcControl();
   }
   
   
   
    @Override
    public void actionPerformed(ActionEvent e) {
        //Wenn ok gedrückt wird werden sich erst die informationen aus dem fenster geholt
       if (e.getSource() == ok){
         präfixus = (String) präfix1.getSelectedItem();
        String Spannung = spannung.getText();
       if (!Spannung.isEmpty()) {
     Volt = Double.parseDouble(Spannung);
    }
     präfixusMaximus = (String) präfix2.getSelectedItem();
    String Stromstärke = stromstärke.getText();
     if (!Stromstärke.isEmpty()) {
     Ampere = Double.parseDouble(Stromstärke);
    }
    if(Bogenmaß.isSelected()){
        this.winkelIn = 0; // 0 = Bogenmaß
    }else{
        this.winkelIn = 1; // 1 = Gradmaß
    }
    String WinkelGRAD = (String) winkeleingabe.getText();
    if (!WinkelGRAD.isEmpty()) {
     winkelGrad = Double.parseDouble(WinkelGRAD);
    }
    //Jetzt wird die wirkleistung berechnet
     p = Rechner.berechneWirkleistung(Volt,
        Ampere,
        winkelIn,
        winkelGrad,
        phi,
        präfixus,
        präfixusMaximus);
        //Ergebnisse werden ins fenster aktualisiert 
        Ergebnis.setText(String.format("%.7f W", p));
        Entspricht.setText(String.format("%.7f mW", Rechner.umRechner(p)));
    // Kontrolle ob werte übernommen werden 
    System.out.println("========== DEBUG ==========");
// Die print befehle dienen zur überprüfung des codes während des programmierens 
System.out.println("Spannung:      " + Volt);
System.out.println("Spannungspräfix: " + präfixus);

System.out.println("Stromstärke:   " + Ampere);
System.out.println("Strompräfix:   " + präfixusMaximus);

System.out.println("Winkelwert:    " + winkelGrad);

if (winkelIn == 0) {
    System.out.println("Winkeleinheit: Bogenmaß");
} else {
    System.out.println("Winkeleinheit: Gradmaß");
}
System.out.println("Phi:    " + phi);
System.out.println("Ergebnis:    " + p);

System.out.println("===========================");





    }
    
}
}
