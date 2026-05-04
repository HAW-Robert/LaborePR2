package matrices;

public class ColumnVector extends Matrix{
    
    public ColumnVector(int rows, int cols) {
        super(rows, 1);
        
    }
    public int get(){
        //Durch verwendung von super. kann ich meine bereits existierende (und auf coefficients) zugreifende Methode aufrufen
        return super.getRows();
    }
    public void set(int row,int col, double value){
        super.set(row, 1, value);
    }
    
    
}
