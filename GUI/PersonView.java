package GUI;
import javax.swing.*; //der .* sorgt dafür das alles in der BIBliotekh importiert wird 
public class PersonView extends JFrame {
    
//Konstruktor 
public PersonView(Person personToShow){
    //Mit super wird hier der JFrame konstruktor aufgerufen 
    super("Personal Infos");

   PersonPanel panel = new PersonPanel(personToShow);
   add(panel);
   

    setDefaultCloseOperation(EXIT_ON_CLOSE); 

    setSize(400, 160);    // größe des Fensters

    setLocationRelativeTo(null);    // Entweder setLocation und dann x und y geben oder setLocationRealtiveTo ( null) um die bildschirmitte 

    setVisible(true);      // man kann es sehen
}

public static void main(String arg[]){
    Person Tosch = new Person("Herr", "Dr.","Peter","Tosch");
    PersonView view = new PersonView(Tosch);
    PersonCtrl ctrl = new PersonCtrl(Tosch);
    Tosch.setMyView(view);
}
}
