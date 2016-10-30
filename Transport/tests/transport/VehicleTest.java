package tat.bsu.transport;

import org.junit.Before;
import org.junit.Test;
import tat.bsu.route.Checkpoint;
import tat.bsu.route.DistanceCounter;
import tat.bsu.route.Path;

import static org.junit.Assert.*;

/**
 * test class Vehicle
 */
public class VehicleTest {

    @Test
    public void getInfoAboutMoves() throws Exception {

    }

    Path path = new Path();
    DistanceCounter counter = new DistanceCounter();

    @Before
    public void setUp() throws Exception {
        path.addCheckpointToThePath(new Checkpoint(100.0, 100.0));
        path.addCheckpointToThePath(new Checkpoint(100.0, 0));
        counter.findWholeDistance(path);
    }

    @Test
    public void findConsumptionOnPathWithPositiveConsumption() throws Exception {
        Vehicle vehicle = new Vehicle(100, 20, 5);
        double consumption = vehicle.findConsumption(counter);
        assertEquals(20.0, consumption, 0.00001);
    }
    @Test
    public void findConsumptionOnPathWithNoConsumption() throws Exception {
        Vehicle vehicle = new Vehicle(100, 0.0, 5);
        double consumption = vehicle.findConsumption(counter);
        assertEquals(0.0, consumption, 0.00001);
    }
    @Test
    public void findConsumptionOnPathWithNegativeConsumption() throws Exception {
        Vehicle vehicle = new Vehicle(100, -20.0, 5);
        double consumption = vehicle.findConsumption(counter);
        assertEquals(20.0, consumption, 0.00001);
    }
    @Test
    public void findTimeOfTravelWithPositiveSpeed() throws Exception {
        Vehicle vehicle = new Vehicle(100, 20.0, 5);
        double pathTime = vehicle.findPathTime(counter);
        assertEquals(1.0, pathTime, 0.00001);
    }
    @Test
    public void findTimeOfTravelWithNegativeSpeed() throws Exception {
        Vehicle vehicle = new Vehicle(-100, 20.0, 5);
        double pathTime = vehicle.findPathTime(counter);
        assertEquals(1.0, pathTime, 0.00001);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testExceptionOfTravelWithZeroSpeed() throws Exception {
        Vehicle vehicle = new Vehicle(0.0, 20.0, 2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testExceptionOfTravelWithNoPassangers() throws Exception {
        Vehicle vehicle = new Vehicle(50.0, 20.0, 0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void catchExceptionOfOneNoNubmerCharacteristic() {
        Vehicle vehicle = new Vehicle(Double.parseDouble("test"), 20.0, 5);
    }
    @Test(expected = IllegalArgumentException.class)
    public void catchExceptionOfAllNoNubmersCharacteristics() {
        Vehicle vehicle = new Vehicle(Double.parseDouble("test"),Double.parseDouble("test"), Integer.parseInt("test"));
    }
    @Test
    public void testCostPerPersonWithPassangersAndPositiveConsumption() {
        Vehicle vehicle = new Vehicle(100, 20.0, 5);
        double cost = vehicle.getCostPerPerson(counter);
        assertEquals(4.0, cost, 0.00001);
    }
    @Test
    public void testCostPerPersonWithPassangersAndNegativeConsumption() {
        Vehicle vehicle = new Vehicle(100, -20.0, 5);
        double cost = vehicle.getCostPerPerson(counter);
        assertEquals(4.0, cost, 0.00001);
    }
    @Test
    public void testCostPerPersonWithPassangersAndZeroConsumption() {
        Vehicle vehicle = new Vehicle(100, 0.0, 5);
        double cost = vehicle.getCostPerPerson(counter);
        assertEquals(0.0, cost, 0.00001);
    }
    @Test(expected = IllegalArgumentException.class)
    public void CheckExceptionOfNoPassangers() {
        Vehicle vehicle = new Vehicle(100, 20.0, 0);
    }

}