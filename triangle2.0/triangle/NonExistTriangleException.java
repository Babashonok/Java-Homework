package triangle;

/**
 * Called if triangle side >= sum of other two
 */
public class NonExistTriangleException extends Exception {

    /**
     * if caught , then output exception  message
     */
    public NonExistTriangleException() {
        super("Triangle with that sides doesn't exist");
    }
}
