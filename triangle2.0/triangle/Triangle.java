package triangle;

import java.math.BigDecimal;

import static triangle.Main.NUMBER_OF_SIDES;

/**
 * Describe properties of geometric triangle
 */
public class Triangle {

    private BigDecimal []  sides = new BigDecimal[NUMBER_OF_SIDES];

    /**
     * initialize triangle sides
     * also check  math existence of this triangle
     *
     * @param sides user-input sides
     * @throws NonExistTriangleException if one side >= sum of other two
     */
    public Triangle(BigDecimal [] sides ) throws NonExistTriangleException {
        TriangleValidator validator = new TriangleValidator();
        if (!validator.isExist(sides)) {
            throw new NonExistTriangleException();
        }
        System.arraycopy(sides, 0, this.sides, 0, sides.length);
    }

    /**
     * get type using math defihitions of triangle types
     * Note: equilateral triangles are also isosceles
     * @return string description of the triangle
     */
    public String getTriangleType() {
        if (sides[0].equals(sides[1]) && sides[0].equals(sides[2])) {
            return "This triangle is equilateral so as isosceles";
        } else if (!sides[0].equals(sides[1]) && !sides[0].equals(sides[2]) && !sides[1].equals(sides[2])) {
            return "This triangle is common";
        } else {
            return "This triangle is isosceles";
        }
    }
}
