package labs.lab2.functions;


/**
 * Abstract class for mathematical functions from R to R.
 */
public abstract class Function {
    
    /** 
     * Is the function defined at the given value of x?
     * 
     * @param x  the x-value of interest
     * 
     * @return true iff f is defined for the given value
     */
    public abstract boolean isDefinedFor(double x);

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
    public abstract double evaluate(double x);


    /**
     * Computes a function term as text.
     * 
     * For example, if f is the sine function is should return 
     * "sin(z)" if f.functionTerm("z") is called. 
     *  
     * @param x the text that shall be used as parameter. 
     * @return a text describing the function term. 
     */
    public abstract String functionTerm(String x);
    
    /**
     * Computes the first derivative of the function.
     * 
     * @return 1st derivative of f
     */
    public abstract Function derivative();

    /**
     * Computes the default text representation of the function.
     */
    @Override
    public String toString() {
        return functionTerm("x");
    }
 

    /**
     * Provides a collection of some functions for the function viewer.
     * Can be extended if you like.
     * 
     * @return an array of functions to be shown in the viewer.
     */
    public static Function[] showTheseFunctions() {
        return new Function[] { 
            // 1 + 2x -1 x^2
            new Polynomial(1,2,-1),
            // cos(x)
            new TrigonometricFunction(Trigonometric.COSINE),
            /* 
            // tan(x)
             new TrigonometricFunction(Trigonometric.TANGENT),
            // 2 * sin(x)
            new ScaledFunction(2,
                               new TrigonometricFunction(Trigonometric.SINE)),
            // 3 + cos(x)
            new SumOfFunctions(new Polynomial(3),
                               new TrigonometricFunction(Trigonometric.COSINE)),
            // (0+x) * (sin(x))
            new ProductOfFunctions(new Polynomial(0,1),
                                   new TrigonometricFunction(Trigonometric.SINE)),
            // sin(x^2)
            new ChainOfFunctions(                                   
                new TrigonometricFunction(Trigonometric.SINE),
                new Polynomial(0,0,1)),
                */
        };
    }
}
