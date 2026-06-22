package GUI;


//Hier wird die Klasse des Objekts welches wir verändern wollen definiert.
//Alle Attribute welche später verändert werden können müssen hier definiert werden.
public class Person {
    private String adress;
    private String title;
    private String givenName;
    private String surname;
    private PersonView myView = null;

    //Konstruktor 
    public Person(String adress, String title, String givenName, String surname){
        this.adress = adress;
        this.title = title;
        this.givenName = givenName;
        this.surname = surname;
    }
    // Getter und setter sorgen dafür das ich durch code in anderen files trotzdem noch attribute von person ändern kann.
    //Getter 
    public String getAdress(){
        return adress;
    }
    public String getTitle(){
        return title;
    }
    public String getGivenName(){
        return givenName;
    }
    public String getSurname(){
        return surname;
    }
    //Setter
    public void setAdress(String adress){
        this.adress = adress;
        if(myView != null){
            myView.repaint();
        }
    }
    public void setTitle(String title){
        this.title = title;
        if(myView != null){
            myView.repaint();
        }
    }
    public void setGivenName(String givenName){
        this.givenName = givenName;
        if(myView != null){
            myView.repaint();
        }
    }
    public void setSurname(String surname){
        this.surname = surname;
        if(myView != null){
            myView.repaint();
        }
    }

    public PersonView getMyView() {
        return myView;
    }

    public void setMyView(PersonView myView) {
        this.myView = myView;
        if(myView != null){
            myView.repaint();
        }
    }
  
}
