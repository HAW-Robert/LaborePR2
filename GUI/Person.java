package GUI;

public class Person {
    private String adress;
    private String title;
    private String givenName;
    private String surname;

    //Konstruktor 
    public Person(String adress, String title, String givenName, String surname){
        this.adress = adress;
        this.title = title;
        this.givenName = givenName;
        this.surname = surname;
    }

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
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setGivenName(String givenName){
        this.givenName = givenName;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
}
