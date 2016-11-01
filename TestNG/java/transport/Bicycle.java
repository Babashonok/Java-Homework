package tat.bsu.transport;

import tat.bsu.route.DistanceCounter;

/**
 * Class that realize bicycle way of passing the path
 */
public class Bicycle implements Moveable {

    private double speed;

    /**
     * constructor that initialize bicycle speed
     * if characretistic has negative value, remake it to the positive value
     * initialize validator , that check variables on operable range and throws exception
     * if they out of the range
     * @param speed
     */
    public Bicycle(double speed)  {
        DoubleValidator validator = new DoubleValidator();
        this.speed = validator.checkVariableThatCannotBeZero(speed);
    }

    /**
     * interface method that gives object an ability to determine oneself speed
     * @return
     */
    public double getSpeed() {
        return speed;
    }
    /**
     * find spent consumption in the path
     * @param counter
     * @return
     */
    public double findPathTime(DistanceCounter counter){
        return counter.getWholeDistance() / speed;
    }
    /**
     * interface method that gives object an ability to output characteristics about movement
     * @param counter
     * @return
     */
    public String getInfoAboutMoves(DistanceCounter counter) {
        return "Bicycle : path time = " + findPathTime(counter) + " | cost per person = 0";
    }
}
