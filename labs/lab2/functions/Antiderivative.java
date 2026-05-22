package labs.lab2.functions;

/**
 * Interface for functions that may have antiderivatives.
 */
public interface Antiderivative {

    /**
     * Can the antiderivative of the function be computed?
     * 
     * @return true if antiderivative is computable.
     */
    public boolean hasAntiderivative();

    /**
     * Computes the antiderivative if possible.
     * 
     * @return the antiderivative of the function.
     */
    public Function antiderivative();
}
