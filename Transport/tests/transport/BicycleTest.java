package tat.bsu.transport;

import org.junit.Before;
import org.junit.Test;
import tat.bsu.route.Checkpoint;
import tat.bsu.route.DistanceCounter;
import tat.bsu.route.Path;

import static org.junit.Assert.*;

/**
 * test class Bicycle
 */
public class BicycleTest {

    Path path;
    DistanceCounter counter;
    @Before
    public void setUp() throws Exception {
        path = new Path();
        path.addCheckpointToThePath(new Checkpoint(100.0, 100.0));
        path.addCheckpointToThePath(new Checkpoint(100.0, 0));
        counter = new DistanceCounter(path);
        counter.getWholeDistance();

    }

    @Test
    public void findTimeOfTravelWithPositiveSpeed() throws Exception {
        Bicycle bicycle = new Bicycle(20.0);
        double pathTime = bicycle.findPathTime(counter);
        assertEquals(5.0, pathTime, 0.00001);
    }
    @Test
    public void findTimeOfTravelWithNegativeSpeed() throws Exception {
        Bicycle bicycle = new Bicycle(-20.0);
        double pathTime = bicycle.findPathTime(counter);
        assertEquals(5.0, pathTime, 0.00001);
    }
    @Test
    public void findTimeOfTravelWithZeroSpeed() throws Exception {
        Bicycle bicycle = new Bicycle(0.0);
        double pathTime = bicycle.findPathTime(counter);
        assertEquals(Double.POSITIVE_INFINITY, pathTime, 10e+6);
    }

    @Test
    public void checkEqualityBetweenMethodAndConstantLine() throws Exception {
        Bicycle bicycle = new Bicycle(20.0);
        String constantLine = "Bicycle : path time = 5.0 | cost per person = 0";
        String methodLine = "Bicycle : path time = " + bicycle.findPathTime(counter) + " | cost per person = 0";
        assertEquals(constantLine, methodLine);
    }
    @Test(expected = IllegalArgumentException.class)
    public void catchExceptionOfOneNoNubmerCharacteristic() {
        Bicycle bicycle = new Bicycle(Double.parseDouble("test"));
    }

}