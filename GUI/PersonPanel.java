package GUI;
import javax.swing.*;
public class PersonPanel extends JPanel {
    //Person Panel holt die Informationen über die Personen aus Person.java und gibt die weiter an PersonView.java 
    public PersonPanel(Person personToShow){
         //Neues objekt der klasse label erstellen , dabei wird der Konstruktor von JLabel aufgerufen. Dieser besteht mindestens aus dem Text(Inhalt) und dem centering man könnte auch noch ein icon hinzufügen 
    JLabel label = new JLabel(personToShow.getAdress()+ " " +personToShow.getTitle()+ " "+personToShow.getGivenName()+ " "+personToShow.getSurname(), JLabel.CENTER);
 add(label);
    }
}
