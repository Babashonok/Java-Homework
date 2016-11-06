package triangle;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class that realize reading input from Console of the program
 * using "Scanner" kit
 */
public class ConsoleInputReader extends InputReader {

    private final String askSideInput = "Please input length of the triangle side";
    private final String askSideReInput = "Error, wrong side input, return to the previous action :";
    private BigDecimal side;


    /**
     * recursive method that will ask user to input side length
     * until user input correct number in the console
     *
     * @return triangle side
     */
    public BigDecimal readSideLength() {
        System.out.println(askSideInput);
        Scanner scan = new Scanner(System.in);
        TriangleValidator validator = new TriangleValidator();
        try {
            side = scan.nextBigDecimal();
            validator.validateSide(side);
        } catch (InputMismatchException | WrongInputException e) {
            System.out.println(askSideReInput);
            readSideLength();
        }
        return side ;
    }
}
