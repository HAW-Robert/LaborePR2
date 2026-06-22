// Robert Arnds & Max Müller
// Personendaten
//21.06.26


package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;
import java.awt.GridBagLayout;
public class PersonPanel extends JPanel {
    private JLabel label;
    private Person personToShow;
    
    //Person Panel holt die Informationen über die Personen aus Person.java und gibt die weiter an PersonView.java 
    public PersonPanel(Person personToShow){
        this.personToShow = personToShow;
         //Neues objekt der klasse label erstellen , dabei wird der Konstruktor von JLabel aufgerufen. Dieser besteht mindestens aus dem Text(Inhalt) und dem centering man könnte auch noch ein icon hinzufügen 
    label = new JLabel(personToShow.getAdress()+ " " +personToShow.getTitle()+ " "+personToShow.getGivenName()+ " "+personToShow.getSurname(), JLabel.CENTER);
    //GridBagLayout sorgt in zusammenarbeit mit JLabel.centre für die zentrierung des textes im feld
    setLayout(new GridBagLayout());
    Font font = new Font("SansSerif", Font.BOLD, 20);
     label.setForeground(Color.BLACK);// set some colors
    label.setBackground(Color.WHITE); 
   //label.setOpaque(true);
    label.setFont(font);
    
 add(label);
    }
    @Override
    protected void paintComponent(Graphics g){
        // Standard-Zeichenroutine von JPanel aufrufen,
    // damit das Panel korrekt neu gezeichnet wird.
        super.paintComponent(g);
        if (personToShow!=null)
             // Falls ein Personenobjekt vorhanden ist,
            // wird der Text des Labels mit den aktuellen Personendaten aktualisiert.
             // Dadurch werden Änderungen an der Person nach einem repaint()
            // automatisch in der Anzeige übernommen.
        label.setText(personToShow.getAdress()+ " "+personToShow.getTitle()+" "+personToShow.getGivenName()+" "+personToShow.getSurname()+"");
    }

}
