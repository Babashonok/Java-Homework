package tat.bsu.transport;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import tat.bsu.route.Checkpoint;
import tat.bsu.route.DistanceCounter;
import tat.bsu.route.Path;



/**
 * test class Bicycle
 */
public class BicycleTest {

    DistanceCounter counter  = new DistanceCounter();

    @BeforeMethod
    public void setUp() throws Exception {
        Path path =new Path() ;
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
    @DataProvider(name = "fourMagicNumbers")
    public static Object [][] checkExceptionsWithZero() {
        return new Object [][] {
                {Double.POSITIVE_INFINITY}, {Double.NEGATIVE_INFINITY}, {Double.NaN}, {0.0}
        };
    }
    @Test(dataProvider = "fourMagicNumbers", expectedExceptions = IllegalArgumentException.class)
    public void checkExceptionOfSpeedRate(Double outOfRangeVariable) {
        Bicycle bicycle = new Bicycle(outOfRangeVariable);
    }


    @Test(expectedExceptions = IllegalArgumentException.class)
    public void catchExceptionOfOneNoNubmerCharacteristic() {
        Bicycle bicycle = new Bicycle(Double.parseDouble("test"));
    }

}