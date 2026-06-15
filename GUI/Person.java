package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

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
