package tat.bsu.transport;

import tat.bsu.route.DistanceCounter;

import java.util.Map;

/**
 * parent class for every object that requires oil
 */
public class Vehicle implements Moveable{

    private double speed;
    private double consumption100Km;
    private int numberOfPassangers;

    /**
     * constructor that initializes characteristics of Vehicle
     * if characreristic has negative value, remake it to the positive value
     * @param speed
     * @param consumption100Km
     * @param numberOfPassangers
     */
    public Vehicle(double speed, double consumption100Km, int numberOfPassangers) throws IllegalArgumentException {
        if (Double.valueOf(speed).compareTo(Double.valueOf(0)) == 0 || numberOfPassangers == 0) {
            throw new IllegalArgumentException();
        }
        this.speed = Math.abs(speed);
        this.consumption100Km = Math.abs(consumption100Km);
        this.numberOfPassangers = Math.abs(numberOfPassangers);
    }

    /**
     * find spent time in the path
     * @param counter
     * @return
     */
    public double findPathTime(DistanceCounter counter){
        return counter.getWholeDistance() / getSpeed();
    }

    /**
     * find spent consumption in the path
     * @param counter
     * @return
     */
    public double findConsumption(DistanceCounter counter) {
        return  counter.getWholeDistance() * getConsumptionOn100Km() / 100;
    }

    /**
     * interface method that gives object an ability to determine oneself speed
     * @return
     */
    public double getSpeed() {
        return this.speed;
    }

    /**
     * interface method that gives object an ability to output characteristics about movement
     * @param counter
     * @return
     */
    public String getInfoAboutMoves(DistanceCounter counter) {
        return this.getClass().getName() + " : path time = " + findPathTime(counter) + " | cost per person = "
                + getCostPerPerson(counter);
    }

    /**
     * count cost per person as quotient of consumption waste to number of passanger
     * @param counter
     * @return
     */
    public double getCostPerPerson(DistanceCounter counter){
        return findConsumption(counter) / getNumberOfPassangers();
    }

    /**
     * return consumption on 100 km
     * @return
     */
    public double getConsumptionOn100Km() {
        return this.consumption100Km;
    }

    /**
     * return number of passangers
     * @return
     */
    public int getNumberOfPassangers() {
        return this.numberOfPassangers;
    }

}
