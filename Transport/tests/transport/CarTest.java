package tat.bsu.transport;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * test class Car
 */
public class CarTest {

    @Test(expected = IllegalArgumentException.class)
    public void catchExceptionOfOneNoNubmerCharacteristic() {
        Car car = new Car(Double.parseDouble("test"), 20.0, 5);
    }
    @Test(expected = IllegalArgumentException.class)
    public void catchExceptionOfAllNoNubmersCharacteristics() {
        Car car = new Car(Double.parseDouble("test"), Double.parseDouble("test"), Integer.parseInt("test"));
    }

}