package triangle;

import java.math.BigDecimal;

/**
 * Entry point of the program
 *" Find type of the triangle according it sides"
 * @author Alexey Babak
 * @version 2.0
 * @since 03.11.2016
 */
public class Main {

    public static int NUMBER_OF_SIDES = 3;

    /**
     * create array of three Bigdecimal numbers
     * @param reader  user input
     * @return array with 3 valid numbers
     */
    public static BigDecimal [] fillSidesArray(ConsoleInputReader reader) {
        BigDecimal [] sides = new BigDecimal[NUMBER_OF_SIDES];
        for (int temp = 0 ; temp < NUMBER_OF_SIDES ; temp ++) {
            sides[temp] = reader.readSideLength();
        }
        return sides;
    }

    /**
     * entry point of the program
     * output information about triangle in the console
     * @param args command line input parameters
     */
    public static void main(String [] args) {
        ConsoleInputReader reader = new ConsoleInputReader();
        try {
            BigDecimal [] sides = fillSidesArray(reader);
            Triangle triangle = new Triangle(sides);
            System.out.println(triangle.getTriangleType());
        } catch (NonExistTriangleException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
