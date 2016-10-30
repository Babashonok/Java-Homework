package tat.bsu.transport;

import tat.bsu.route.DistanceCounter;

/**
 * Class that realize car way of passing the path
 */
public class Car extends Vehicle implements Moveable {

    private double speed;
    private double consumption100Km ;
    private int numberOfPassangers ;

    /**
     * implement constructor of the parent clas Vehicle
     * @param speed
     * @param consumption100Km
     * @param numberOfPassangers
     */
    public Car(double speed, double consumption100Km, int numberOfPassangers) throws IllegalArgumentException {
        super(speed, consumption100Km, numberOfPassangers);
    }

    /**
     * override method from Vehicle that gives object an ability to output characteristics about movement
     * @param counter
     * @return
     */
    @Override
    public String getInfoAboutMoves(DistanceCounter counter) {
        return "Car : path time = " + findPathTime(counter) + " | cost per person = "
                + findConsumption(counter) / getNumberOfPassangers();
    }

}
