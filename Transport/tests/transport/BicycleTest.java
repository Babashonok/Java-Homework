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

    Path path =new Path() ;
    DistanceCounter counter  = new DistanceCounter();

    @Before
    public void setUp() throws Exception {
        path.addCheckpointToThePath(new Checkpoint(100.0, 100.0));
        path.addCheckpointToThePath(new Checkpoint(100.0, 0));
        counter.findWholeDistance(path);
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
    @Test(expected = IllegalArgumentException.class)
    public void findTimeOfTravelWithZeroSpeed() throws Exception {
        Bicycle bicycle = new Bicycle(0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void catchExceptionOfOneNoNubmerCharacteristic() {
        Bicycle bicycle = new Bicycle(Double.parseDouble("test"));
    }

}