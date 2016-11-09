package triangle;

import java.math.BigDecimal;

/**
 * Parent abstract class of input parameters
 * All this class inheritance will realize different ways to input sides
 */
public abstract class InputReader {
    /**
     * read input and ask user to change it, if doesn't valid
     * @return
     */
    public abstract BigDecimal readSideLength() throws WrongInputException;
}
