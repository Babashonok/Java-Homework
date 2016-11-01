package tat.bsu.transport;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * test class DoubleValidator
 */
public class DoubleValidatorTest {
    DoubleValidator validator = new DoubleValidator();

    @DataProvider(name = "threeMagicNumbers")
    public  Object [][] checkExceptions() {
        return new Object [][] {
                {Double.POSITIVE_INFINITY}, {Double.NEGATIVE_INFINITY}, {Double.NaN}
        };
    }
    @DataProvider(name = "fourMagicNumbers")
    public static Object [][] checkExceptionsWithZero() {
        return new Object [][] {
                {Double.POSITIVE_INFINITY}, {Double.NEGATIVE_INFINITY}, {Double.NaN}, {0.0}
        };
    }
    @Test(dataProvider = "threeMagicNumbers", expectedExceptions = IllegalArgumentException.class)
    public void testCheckVariableThatCanBeZeroWithUnoperableValues(Double value) throws Exception {
        validator.checkVariableThatCanBeZero(value);

    }

    @Test(dataProvider = "fourMagicNumbers", expectedExceptions = IllegalArgumentException.class)
    public void testCheckVariableThatCannotBeZeroWithUnoperableValues(Double value) throws Exception {
        validator.checkVariableThatCannotBeZero(value);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCheckIntVariableThatCannotBeZeroWithZero() throws Exception {
        validator.checkIntVariableThatCannotBeZero(0);
    }
    @DataProvider(name = "positiveAndNegative")
    public  Object [][] twoNumbersOfDifferentSign() {
        return new Object [][] {
                {20,20}, {20,-20}
        };
    }
    @Test(dataProvider = "positiveAndNegative")
    public void testCheckVariableThatCanBeZeroWithOperableValues(double expected, double value) {
        double variable = validator.checkVariableThatCanBeZero(value);
        assertEquals(variable,expected, 0.00001);
    }
    @Test(dataProvider = "positiveAndNegative")
    public void testCheckVariableThatCannotBeZeroWithOperableValues(double expected, double value) {
        double variable = validator.checkVariableThatCannotBeZero(value);
        assertEquals(variable,expected, 0.00001);
    }
    @Test(dataProvider = "positiveAndNegative")
    public void testCheckIntVariableThatCannotBeZeroWithOperableValues(int expected, int value) {
        double variable = validator.checkIntVariableThatCannotBeZero(value);
        assertEquals(variable,expected, 0.00001);
    }

}