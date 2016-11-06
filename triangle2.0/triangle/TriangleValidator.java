package triangle;

import java.math.BigDecimal;

/**
 * Service class for Triangle
 * Check correct side length and existence of triangle
 */
public class TriangleValidator {
    /**
     * check triangle for existance
     * every side should be shorter than sum of others
     *
     * @param triangleSides array of 3 bigdecimal sides
     * @return
     */
    public boolean isExist(BigDecimal [] triangleSides) {
        return ((triangleSides[0].compareTo(triangleSides[1].add(triangleSides[2])) < 0 ) &&
                (triangleSides[1].compareTo(triangleSides[2].add(triangleSides[0])) < 0 ) &&
                (triangleSides[2].compareTo(triangleSides[0].add(triangleSides[1])) < 0 ));
    }

    /**
     * check, if side can be used in this task( positive and non-null)
     *
     * @param side BigDecimal interpretation of side length
     * @throws WrongInputException
     */
    public void validateSide(BigDecimal side) throws WrongInputException {
        if (side == null) {
            throw new WrongInputException("Error, one of the sides is Null argument");
        }
        if (side.compareTo(BigDecimal.ZERO) != 1) {
            throw new WrongInputException("Error, one of the sides has negative value");
        }
    }
}
