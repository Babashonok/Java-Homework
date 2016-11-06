package triangle;

/**
 * Called if input number can't be used in this program
 */
public class WrongInputException extends Exception{

    /**
     * if caught , then output exception  message
     */
    public WrongInputException(String message) {
        super(message);
    }
}
