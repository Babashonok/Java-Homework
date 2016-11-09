package triangle;

import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.assertFalse;
/**
 * test class TriangleValidator
 */
public class TriangleValidatorTest {
    TriangleValidator validator = new TriangleValidator();

    @Test(dataProvider = "nonExist triangles", dataProviderClass = DataProviders.class)
    public void nonExistTriangleTestofMethodIsExist(BigDecimal side1, BigDecimal side2, BigDecimal side3) throws Exception {
        assertFalse(validator.isExist(new BigDecimal[]{side1, side2, side3}));
    }
    @Test(dataProvider = "InvalidInput", dataProviderClass = DataProviders.class,
            expectedExceptions = WrongInputException.class)
    public void TestWrongInputExceptionInValidateSideMethod(BigDecimal invalidInput) throws Exception {
        validator.validateSide(invalidInput);
    }
}