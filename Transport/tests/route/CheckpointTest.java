package tat.bsu.route;

import org.junit.Test;

/**
 * test class Checkpoint
 */
public class CheckpointTest {

    @Test(expected = IllegalArgumentException.class)
    public void catchExceptionOfBigPositiveNumbers() {
        Checkpoint checkpoint = new Checkpoint(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    @Test(expected = IllegalArgumentException.class)
    public void catchExceptionOfBigNegativeNumbers() {
        Checkpoint checkpoint = new Checkpoint(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }
    @Test(expected = IllegalArgumentException.class)
    public void catchExceptionOfOneNoNubmerCharacteristic() {
        Checkpoint checkpoint = new Checkpoint(Double.parseDouble("a"), Double.parseDouble("5.0"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void catchExceptionOfAllNoNubmersCharacteristics() {
        Checkpoint checkpoint = new Checkpoint(Double.parseDouble("a"), Double.parseDouble("b"));
    }

}