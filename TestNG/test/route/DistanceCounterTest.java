package tat.bsu.route;


import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 * Test class DictanceCounter
 */
public class DistanceCounterTest {

    Path  path = new Path();
    DistanceCounter counter = new DistanceCounter();


    @Test
    public void findWholeDistanceOfThreeCheckpointsPath()  {
        path.addCheckpointToThePath(new Checkpoint(1.0, 0.0));
        path.addCheckpointToThePath(new Checkpoint(2.0, 0.0));
        path.addCheckpointToThePath(new Checkpoint(2.0, 2.0));
        double distance = counter.findWholeDistance(path);
        assertEquals(3.0, distance , 0.00001);
    }
    @Test
    public void findDistanceBetweenTwoCheckpointsWithPosiviteCoordinates()  {
        Checkpoint point1 = new Checkpoint(1.0, 1.0);
        Checkpoint point2 = new Checkpoint(4.0, 5.0);
        double distance = counter.findDistanceBetweenTwoCheckpoints(point1, point2);
        assertEquals(5.0 , distance , 0.00001);
    }
    @Test
    public void testZeroDistanceBetweenTwoEqualCheckpoints()  {
        Checkpoint point1 = new Checkpoint(1.0, 1.0);
        Checkpoint point2 = new Checkpoint(1.0, 1.0);
        double distance = counter.findDistanceBetweenTwoCheckpoints(point1, point2);
        assertEquals(0.0 , distance , 0.00001);
    }
    @Test
    public void findDistanceBetweenTwoCheckpointsWithNegativeCoordinates()  {
        Checkpoint point1 = new Checkpoint(-1.0, -1.0);
        Checkpoint point2 = new Checkpoint(-4.0, -5.0);
        double distance = counter.findDistanceBetweenTwoCheckpoints(point1, point2);
        assertEquals(5.0 , distance , 0.00001);
    }

}