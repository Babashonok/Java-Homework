package tat.bsu.transport;

import tat.bsu.route.DistanceCounter;

/**
 * Class that realize footwork way of passing the path
 */
public class Footwork implements Moveable {

    private double speed = 5;

    /**
     * contructor that initialize footwork speed
     * if characreristic has negative value, remake it to the positive value
     * @param speed
     */
    public Footwork(double speed) throws IllegalArgumentException {
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
        return "Footwork : path time = " + findPathTime(counter) + " | cost per person = 0";
    }
}
