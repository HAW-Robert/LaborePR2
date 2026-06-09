package GUI;
import javax.swing.*; //der .* sorgt dafür das alles in der BIBliotekh importiert wird 
public class PersonView extends JFrame {
    
//Konstruktor 
public PersonView(Person personToShow){
    //Mit super wird hier der JFrame konstruktor aufgerufen 
    super("Personal Infos");

    //Neues objekt der klasse label erstellen , dabei wird der Konstruktor von JLabel aufgerufen. Dieser besteht mindestens aus dem Text(Inhalt) und dem centering man könnte auch noch ein icon hinzufügen 
    JLabel label = new JLabel(personToShow.getAdress()+ " " +personToShow.getTitle()+ " "+personToShow.getGivenName()+ " "+personToShow.getSurname(), JLabel.CENTER);

    add(label);

    setDefaultCloseOperation(EXIT_ON_CLOSE); 

    setSize(400, 160);    // größe des Fensters

    setLocationRelativeTo(null);    // Entweder setLocation und dann x und y geben oder setLocationRealtiveTo ( null) um die bildschirmitte 

    setVisible(true);      // man kann es sehen
}

public static void main(String arg[]){
    Person Tosch = new Person("Herr", "Dr.","Peter","Tosch");
    PersonView view = new PersonView(Tosch);
}
}
