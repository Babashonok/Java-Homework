package tat.bsu.transport;

import org.junit.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;

import org.testng.annotations.Test;
import tat.bsu.route.Checkpoint;
import tat.bsu.route.DistanceCounter;
import tat.bsu.route.Path;

/**
 * test class Vehicle
 */
public class VehicleTest {

    DistanceCounter counter = new DistanceCounter();

    @BeforeMethod
    public void setUp() throws Exception {
        Path path = new Path();
        path.addCheckpointToThePath(new Checkpoint(100.0, 100.0));
        path.addCheckpointToThePath(new Checkpoint(100.0, 0));
        counter.findWholeDistance(path);
    }
    @DataProvider(name = "consumptionRate")
    public Object [][] findDifferentConsumptionsValue() {
        return new Object [][] {
                {20.0, new Vehicle(100.0, 20.0, 5)},
                {20.0, new Vehicle(100.0, -20.0, 5)},
                {0.0, new Vehicle(100.0, 0.0, 5)},
        };
    }
    @Test(dataProvider = "consumptionRate")
    public void findConsumption(double expected, Vehicle vehicle) throws Exception {
        double consumption = vehicle.findConsumption(counter);
        assertEquals(consumption, expected, 0.00001);
    }

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
    public void checkExceptionOfConsumptionRate(Double outOfRangeVariable) {
        Vehicle vehicle = new Vehicle(100.0, outOfRangeVariable, 5);
    }
    @Test(dataProvider = "fourMagicNumbers", expectedExceptions = IllegalArgumentException.class)
    public void checkExceptionOfSpeedRate(Double outOfRangeVariable) {
        Vehicle vehicle = new Vehicle(outOfRangeVariable, 20.0, 5);
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
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testExceptionOfTravelWithNoPassangers() throws Exception {
        Vehicle vehicle = new Vehicle(50.0, 20.0, 0);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void catchExceptionOfOneNoNubmerCharacteristic() {
        Vehicle vehicle = new Vehicle(Double.parseDouble("test"), 20.0, 5);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void catchExceptionOfAllNoNubmersCharacteristics() {
        Vehicle vehicle = new Vehicle(Double.parseDouble("test"),Double.parseDouble("test"), Integer.parseInt("test"));
    }
    @DataProvider(name = "cost")
    public Object [][] findDifferentCostValue() {
        return new Object [][] {
                {4.0, new Vehicle(100.0, 20.0, 5)},
                {4.0, new Vehicle(100.0, -20.0, 5)},
                {0.0, new Vehicle(100.0, 0.0, 5)},
        };
    }
    @Test(dataProvider = "cost")
    public void findCost(double expected, Vehicle vehicle) throws Exception {
        double cost = vehicle.getCostPerPerson(counter);
        assertEquals(cost, expected, 0.00001);
    }



}