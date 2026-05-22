package labs.lab2.functions;

/**
 * An enum for trigonometric functions. 
 */
public enum Trigonometric {
    SINE, 
    COSINE, 
    //TANGENT // many functions are missing here! No big deal to add them...
    ;

    /** 
     * Is the function defined at the given value of x?
     * 
     * @param x  the x-value of interest
     * 
     * @return true iff f is defined for the given value
     */
    public boolean isDefinedFor(double x) {
       switch(this) {
        case COSINE: return true; // always defined
        case SINE : return true;  // always defined
        // case TANGENT : return Math.cos(x)!=0.0;
        default : return false;
       }
    }

    /**
     * Evaluates the function at the given value.
     * 
     * IMPORTANT: This method does NOT verify whether f is 
     * defined for the given value. It assumes that it is
     * defined there. 
     * 
     * @param x the value of interest
     * @return f(x)
     */
    public double evaluate(double x) {
        switch(this) {
            case SINE : return Math.sin(x);  // very obvious
            case COSINE : return Math.cos(x);// very obvious
            // case TANGENT : return Math.tan(x);
            default : return 0;
        }
    }

     /**
     * Computes a function term as text.
     * 
     * For example, if f is the sine function is should return 
     * "sin(z)" if f.functionTerm("z") is called. 
     *  
     * @param x the text that shall be used as parameter. 
     * @return a text describing the function term. 
     */
    public String functionTerm(String x) {
        switch(this) {
            case SINE : return "sin(" + x + ")";
            case COSINE : return "cos(" + x + ")";
            // case TANGENT : return "tan(" + x + ")";
            default : return "???";
        }
    }
}
