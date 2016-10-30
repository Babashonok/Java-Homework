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
    Path path =new Path();
    DistanceCounter counter = new DistanceCounter();
    @Before
    public void setUp() throws Exception {
        path.addCheckpointToThePath(new Checkpoint(100.0, 100.0));
        path.addCheckpointToThePath(new Checkpoint(100.0, 0));
        counter.findWholeDistance(path);
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
    @Test(expected = IllegalArgumentException.class)
    public void findTimeOfTravelWithZeroSpeed() throws Exception {
        Footwork footwork = new Footwork(0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void catchExceptionOfOneNoNubmerCharacteristic() {
        Footwork footwork = new Footwork(Double.parseDouble("test"));
    }

}