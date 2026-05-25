package Buffer;
//Buffer startet auf zwei / muss min 25% gefüllt sein/ buffer voll und es kommt noch ein dazu wird größe verdoppelt / sind weniger als 25% der plätze gefüllt wird die größe halbiert
//Array muss iterierbar sein
import java.util.Iterator;
public class Buffer implements Iterable{
    //attribute
    private int size; //Wie viele Plätze sind gerade belegt?
    private int first;// Index des ersten Objekts
    private int last;//Index des letzten Objekts
    private Object[] elements;// "elements" ist das Array vom typ Object welches unser Ringpuffer sein wird.
    
    //Konstruktor
public Buffer(){
    this.size = 0;
    this.first = 1; //Erstes Objekt wird wegen meiner Schleifenstruktur immer auf Index 1 gepackt
    this.last = 0;
this.elements = new Object[2];
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
   if (size*4 < elements.length) adaptLength(elements.length/2);
return leaver;
}
public void put(Object object){     //Ein Objekt wird der Warteschlange hinzugefügt//  Gehe normalerweise einen Platz weiter.Wenn du am Ende angekommen bist springe wieder an den Anfang.
    int m = 0;
    if (size==elements.length) adaptLength(elements.length*2);
    if(last+1 >= elements.length){// Prüfung ob last+1 das array sprengen würde 
        m=0;
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

public void adaptLength(int newSize){
        if(newSize < 2){
            newSize = 2;
        }
        Object[] kleinerBuffer = new Object[newSize];
        for(int i = 0; i <size; i++){
            kleinerBuffer[i] = elements[(i+first)%elements.length];
        }
        this.elements = kleinerBuffer;
        
        first =0;
        last = size-1;
   
}  
 @Override
    public Iterator<Object> iterator() {

        return new Iterator<Object>() {

            private int count = 0;
            private int currentIndex = first;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public Object next() {

                Object obj = elements[currentIndex];

                currentIndex = (currentIndex + 1) % elements.length;

                count++;

                return obj;
            }
        };
    }
}