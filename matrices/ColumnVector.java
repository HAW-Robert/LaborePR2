package matrices;

public class ColumnVector extends Matrix{
    //braucht cols nicht als parameter da es festegelegt ist
    public ColumnVector(int rows) {
        super(rows, 1);
        
    }
    //getter bekommt parameter, da er den wert im kästchen an stelle "row" ausgibt 
    public double getCV(int row){
        //Durch verwendung von super. kann ich meine bereits existierende (und auf coefficients) zugreifende Methode aufrufen
        
        return super.getValue(row, 0);
    }
    //int col muss nicht als parameter übergeben werden da es vom mir auf 1 festgelegt wird 
    public void set(int row, double value){
        super.set(row, 0, value);
    }
    //Methode überprüft ob dimensionen der Vektoren stimmen zum Multiplizieren
    public static boolean multipliable(ColumnVector a, ColumnVector b){
        return a.getRows() == b.getRows();
    }
    //Diese Methode ist Static da sie nicht an ein Objekt gebunden ist. Sie ist objekt unabhängig . Ich könnte jede beliebigen Matrizen damit multiplizieren
    //Wenn die methode nicht Static wäre müsste sie an eine Matrix gebunden sein z.B Matrix A * beliebige Matrix. Aber Matrix A wäre dann fest mit der Methode verbunden.
    public static double scalarProduct(ColumnVector a, ColumnVector b){
        // Variable zum zwischenspeichern von ergebnissen
        double dotProduct =0.0;
        //Rechnung wird nur durchgeführt wenn "multipliable" true zurückgibt
        if(multipliable(a, b)){
            //Schleife geht alle "kästchen" der arrays durch
            for(int i =0; i < a.getRows(); i++){
                //pro durchlauf der schleife wird das produkt der werte der arrays auf dotProduct addiert 
                dotProduct += a.getCV(i) * b.getCV(i);
            }
            
            }
        return dotProduct;
            
        }
    }

