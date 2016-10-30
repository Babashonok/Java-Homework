package tat.bsu.transport;

import org.junit.Before;
import org.junit.Test;
import tat.bsu.route.Checkpoint;
import tat.bsu.route.DistanceCounter;
import tat.bsu.route.Path;

import static org.junit.Assert.*;

/**
 * test class Footwork
 */
public class FootworkTest {
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
        Footwork footwork = new Footwork(5.0);
        double pathTime = footwork.findPathTime(counter);
        assertEquals(20.0, pathTime, 0.00001);
    }
    @Test
    public void findTimeOfTravelWithNegativeSpeed() throws Exception {
        Footwork footwork = new Footwork(-5.0);
        double pathTime = footwork.findPathTime(counter);
        assertEquals(20.0, pathTime, 0.00001);
    }
    @Test
    public void findTimeOfTravelWithZeroSpeed() throws Exception {
        Footwork footwork = new Footwork(0.0);
        double pathTime = footwork.findPathTime(counter);
        assertEquals(Double.POSITIVE_INFINITY, pathTime, 10e+6);
    }

    @Test
    public void checkEqualityBetweenMethodandConstantLine() throws Exception {
        Footwork footwork = new Footwork(5.0);
        String constantLine = "Footwork : path time = 20.0 | cost per person = 0";
        String methodLine = "Footwork : path time = " + footwork.findPathTime(counter) + " | cost per person = 0";
        assertEquals(constantLine, methodLine);
    }
    @Test(expected = IllegalArgumentException.class)
    public void catchExceptionOfOneNoNubmerCharacteristic() {
        Footwork footwork = new Footwork(Double.parseDouble("test"));
    }

}