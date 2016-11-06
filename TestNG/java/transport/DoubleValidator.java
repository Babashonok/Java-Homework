package tat.bsu.transport;

/**
 * class that checks double variables on operable range
 * if variable is out of range , throw IllegalArgument Exception
 */
public class DoubleValidator {
    /**
     * throw Exception if variable has unoperable value(>sqrt(POSITIVE_INFINITY, NaN)
     * @param var
     * @return absolute value of variable
     * @throws IllegalArgumentException
     */
    public double checkVariableThatCanBeZero(double var) throws IllegalArgumentException {
        if (Math.abs(var) > Math.sqrt(Double.MAX_VALUE) || Double.isNaN(var)) {
            throw new IllegalArgumentException();
        }
        return Math.abs(var);
    }

    /**
     * throw Exception if variable has unoperable value(>sqrt(POSITIVE_INFINITY, NaN, 0)
     * @param var
     * @return absolute value of variable
     * @throws IllegalArgumentException
     */
    public double checkVariableThatCannotBeZero(double var) throws IllegalArgumentException {
        if (Math.abs(var) > Math.sqrt(Double.MAX_VALUE) || Double.isNaN(var)
                || Double.valueOf(var).compareTo(Double.valueOf(0.0)) == 0) {
            throw new IllegalArgumentException();
        }
        return Math.abs(var);
    }

    /**
     * throw Exception if variable equal zero
     * @param var
     * @return absolute value of variable
     * @throws IllegalArgumentException
     */
    public int checkIntVariableThatCannotBeZero(int var) throws IllegalArgumentException {
        if(var == 0) {
            throw new IllegalArgumentException();
        }
        return Math.abs(var);
    }
}
