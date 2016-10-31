package tat.bsu.transport;

import tat.bsu.route.DistanceCounter;

/**
 * parent class for every object that requires oil
 */
public class Vehicle implements Moveable{

    private double speed;
    private double consumption100Km;
    private int numberOfPassangers;

    /**
     * constructor that initializes characteristics of Vehicle
     * @param speed
     * @param consumption100Km
     * @param numberOfPassangers
     */
    public Vehicle(double speed, double consumption100Km, int numberOfPassangers) {
        this.speed = speed;
        this.consumption100Km = consumption100Km;
        this.numberOfPassangers = numberOfPassangers;
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
                + findConsumption(counter) / getNumberOfPassangers();
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
