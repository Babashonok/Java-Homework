package tat.bsu.transport;

import tat.bsu.route.DistanceCounter;

/**
 * Class that realize bicycle way of passing the path
 */
public class Bicycle implements Moveable {

    private double speed;

    /**
     * contructor that initialize bicycle speed
     * if characreristic has negative value, remake it to the positive value
     * @param speed
     */
    public Bicycle(double speed) throws IllegalArgumentException {
        if (Double.valueOf(speed).compareTo(Double.valueOf(0)) == 0) {
            throw new IllegalArgumentException();
        }
        this.speed = Math.abs(speed);
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
