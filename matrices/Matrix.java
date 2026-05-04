/*Programm : Labor_1 Matrix
  Autoren  : Robert Arnds
  Datum    : 29.04.26
  Beschreibung: Dieses Programm zeigt wie Objekte und Felder zusammenhängen 
*/
package matrices;

public class Matrix{
  //Das Feld coefficients ist das Array welches gefüllt / Transponiert wird 
private double [][] coefficients ;

//Konstruktors
public Matrix(int rows, int cols){ // Konstruktor sagt wioe groß die matrix ist. Der setter sagt was in der Matrix steht 
coefficients = new double[rows][cols];
}
// Copy Konstruktor 
public Matrix(Matrix anotherMatrix){ // Eine durch diesen Konstruktor erschaffene Kopie wird nicht durch veränderung des Originals verändert 
    int rows = anotherMatrix.coefficients.length; //Zeilen = Länge der Matrix "coefficients"
    int cols = anotherMatrix.coefficients[0].length;// Spalten = anzahl SPalten "coefficients"
    double [][] coefficients2 = new double[rows][cols]; // Neue Matrix erstellt größe wurde vom Original Kopiert
    // Schleifenstruktur um Werte zu kopieren (Identisch wie bei C !!!)
    for(int i = 0; i < rows ; i++ ){ // jede zeile wird durchgegangen
      for(int j = 0; j < cols; j++ ){// jede spalte wird durchgegangen
        coefficients2[i][j] = anotherMatrix.coefficients[i][j]; // bei jedem durchgang also schritt für schritt werden die werte übertragen
      }
    }
    this.coefficients = coefficients2; // Ohne diesen befehl existiert coefficient2 nur innerhalb des konstruktors 
}
//Anzahl Zeilen
public int getRows(){
  return coefficients.length;// Befehl gibt die anzahl an Zeilen zurück 
}
//Anzhal Spalten
public int getCols(){
  if(coefficients.length > 0){//Prüfen ob die Matrix zeilen hat (wenn nicht gibt es auch keine spalten)
    return coefficients[0].length; // Die länge der ersten Zeile ist gleich der Anzahl Spalten 
  }
  return 0;// Falls keine Zeilen vorhanden
}
public double get(int row, int col){ // Return wert double , da inhalt matrix double ist.
  return coefficients[row][col];
}
public void set(int row, int col, double value){ // Hier können werte in die matrix eingetragen werden 
  coefficients[row][col] = value;               // eingetragenen werte sind vom typ double 
}
// Um eine Matrix zu Transponieren muss man zunächst eine Original Matrix mit werten haben. Diese Matrix wird dann kopiert damit wir mit der kopie arbeiten können.
//Bei der Erzeugung der Kopie vertauscht man schon Zeilen und Spalten größe. Anschließend nutzt man for schleifen um die Werte die in den "kästchen" des arrays stehen zu vertauschen
public Matrix transpose(){
  // Annahme :Coefficients enthält werte die Transponiert werden können
  int cols = coefficients.length; //Spalten werden zu Zeilen
  int rows = coefficients[0].length;// Zeilen werden zu Spalten 
  Matrix transMatrix = new Matrix(rows, cols); // transMatrix ist ein neues Objekt der Klasse Matrix. Seine werte sind aber im Feld coefficients gespeichert 
  for(int i =0; i < rows; i++){                 // transMatrix ist garkein Array . coefficents ist das array . 
    for(int j =0; j< cols ; j++){
      transMatrix.coefficients[i][j] = this.coefficients[j][i]; // Hier steht : die werte des arrays welches zum objekt transMatrix gehören werden angesprochen. 
                                                                // transMatrix.coefficients bedeutet das ich auf das Feld coefficients des Matrix Objekts transMatrix zugreife         
    }
  }
  return transMatrix;
}
//A muss so viele Spalten haben wie B zeilen hat.
public static boolean multipliable(Matrix A, Matrix B){
  
  return A.getCols() == B.getRows() ;
  
}
public static Matrix multiply(Matrix A, Matrix B){

  if(multipliable(A, B)){
    // Informationen benötigt für Schleifenrechnung
    int cols = B.getCols();
    int rows = A.getRows();
    int common = A.getCols();
    //Neue Matrix wird Erstellt um ergebnisse darin zu speichern
    Matrix resultMatrix = new Matrix(rows, cols);
    //Schleifen gehen jedes "Kästchen" der arrays durch
    for(int i =0; i < rows ; i ++){
      for(int j =0; j < cols; j++){

        for(int k =0; k < common; k++){
          // .coefficients ist nötig um die arrays aufzurufen 
         resultMatrix.coefficients[i][j] += A.coefficients[i][k] * B.coefficients[k][j];
        }
      }
    }
    return resultMatrix;
  }else
    {return null;}
  }
  
}