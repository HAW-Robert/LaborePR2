package Buffer;

public class Buffer{
    //attribute
    private int size; //Wie viele Plätze sind gerade belegt?
    private int first;// Index des ersten Objekts
    private int last;//Index des letzten Objekts
    private Object[] elements;// "elements" ist das Array vom typ Object welches unser Ringpuffer sein wird.

    //Konstruktor
public Buffer(int buffersize){
    this.size = 0;
    this.first = 1; //Erstes Objekt wird wegen meiner Schleifenstruktur immer auf Index 1 gepackt
    this.last = 0;
this.elements = new Object[buffersize];
}
    //Methoden

public Object get(){   //Das als erstes gekommene Object wird aus der Wartescvhlange entfernt.Ein Element ist im Ringpuffer nicht durch Löschen weg,sondern dadurch, dass first/size es nicht mehr einschließen.
    Object leaver = elements[first];
    if(first+1 >= elements.length){
        this.first=0;
    }else{
        this.first+=1;
    }
    this.size-=1;
return leaver;
}
public void put(Object object){     //Ein Objekt wird der Warteschlange hinzugefügt//  Gehe normalerweise einen Platz weiter.Wenn du am Ende angekommen bist springe wieder an den Anfang.
    int m;
    if(last+1 >= elements.length){// Prüfung ob last+1 das array sprengen würde 
        m = 0; // Falls ja
    }else{
        m = last +1; // Falls nein
    }
    //1. A [0] 2. B [1] 3. C[2] unsw.
    this.elements[m] = object;
    this.last = m;
    this.size += 1;
}
public int getSize(){
    return size;
}
public int getBuffersize(){
    return elements.length;
}





}