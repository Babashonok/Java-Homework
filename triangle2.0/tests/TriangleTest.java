package triangle;

import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.*;

/**
 * test Class Triangle
 */
public class TriangleTest {

    @Test(dataProvider = "valid triangles", dataProviderClass = DataProviders.class)
    public void testValidTrianglesType(Triangle triangle, String message) throws Exception {
        assertEquals(triangle.getTriangleType(), message);
    }
}
