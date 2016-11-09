package triangle;

import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.*;

/**
 * test Class Triangle
 */
public class TriangleTest {

    @Test(dataProvider = "IsoscelesTriangle", dataProviderClass = DataProviders.class)
    public void isoscelesTriangleTestofMethodGetTriangleType(BigDecimal side1, BigDecimal side2, BigDecimal side3) throws Exception {
        Triangle triangle = new Triangle(new BigDecimal[]{side1, side2, side3});
        String message = triangle.getTriangleType();
        assertEquals(message, "This triangle is isosceles");
    }
    @Test(dataProvider = "CommonTriangle", dataProviderClass = DataProviders.class)
    public void commonTriangleTestofMethodGetTriangleType(BigDecimal side1, BigDecimal side2, BigDecimal side3) throws Exception {
        Triangle triangle = new Triangle(new BigDecimal[]{side1, side2, side3});
        String message = triangle.getTriangleType();
        assertEquals(message, "This triangle is common");
    }
    @Test
    public void equilateralTriangleTestofMethodGetTriangleType() throws Exception {
        Triangle triangle = new Triangle(new BigDecimal[]{BigDecimal.valueOf(5), BigDecimal.valueOf(5), BigDecimal.valueOf(5)});
        String message = triangle.getTriangleType();
        assertEquals(message, "This triangle is equilateral so as isosceles");
    }


}
