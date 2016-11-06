package triangle;

import org.testng.annotations.DataProvider;

import java.math.BigDecimal;

/**
 * DataProviders
 */
public class DataProviders {

    @DataProvider(name = "IsoscelesTriangle")
     public static Object[][] getIsoscelesTriangleVariables() {
        return new Object[][]{
                {BigDecimal.valueOf(3), BigDecimal.valueOf(2), BigDecimal.valueOf(2)},
                {BigDecimal.valueOf(2), BigDecimal.valueOf(3), BigDecimal.valueOf(2)},
                {BigDecimal.valueOf(2), BigDecimal.valueOf(2), BigDecimal.valueOf(3)},
        };
    }
    @DataProvider(name = "CommonTriangle")
    public static Object[][] getCommonTriangleVariables() {
        return new Object[][]{
                {BigDecimal.valueOf(3), BigDecimal.valueOf(2), BigDecimal.valueOf(4)},
                {BigDecimal.valueOf(4), BigDecimal.valueOf(3), BigDecimal.valueOf(2)},
                {BigDecimal.valueOf(2), BigDecimal.valueOf(4), BigDecimal.valueOf(3)},
        };
    }
    @DataProvider(name = "NonExistTriangle")
    public static Object[][] getNonExistTriangleVariables() {
        return new Object[][]{
                {BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3)},
                {BigDecimal.valueOf(2), BigDecimal.valueOf(3), BigDecimal.valueOf(1)},
                {BigDecimal.valueOf(3), BigDecimal.valueOf(1), BigDecimal.valueOf(2)},
                {BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(100)},
                {BigDecimal.valueOf(2), BigDecimal.valueOf(100), BigDecimal.valueOf(1)},
                {BigDecimal.valueOf(100), BigDecimal.valueOf(1), BigDecimal.valueOf(2)}
        };
    }
    @DataProvider(name = "InvalidInput")
    public static Object[][] getInvalidInputVariables() {
        return new Object[][]{
                {BigDecimal.valueOf(0)},{BigDecimal.valueOf(-1)},{null}
        };
    }
}
