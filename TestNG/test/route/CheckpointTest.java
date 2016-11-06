package tat.bsu.route;

import org.testng.annotations.*;


/**
 * test class Checkpoint
 */
public class CheckpointTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void catchExceptionOfBigPositiveNumbers() {
        Checkpoint checkpoint = new Checkpoint(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void catchExceptionOfBigNegativeNumbers() {
        Checkpoint checkpoint = new Checkpoint(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void catchExceptionOfOneNoNubmerCharacteristic() {
        Checkpoint checkpoint = new Checkpoint(Double.parseDouble("a"), Double.parseDouble("5.0"));
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void catchExceptionOfAllNoNubmersCharacteristics() {
        Checkpoint checkpoint = new Checkpoint(Double.parseDouble("a"), Double.parseDouble("b"));
    }
}