package tat.bsu.transport;

import org.testng.annotations.*;

/**
 * test class Car
 */
public class CarTest {

    @Test( expectedExceptions = IllegalArgumentException.class)
    public void catchExceptionOfOneNoNubmerCharacteristic() {
        Car car = new Car(Double.parseDouble("test"), 20.0, 5);
    }
    @Test( expectedExceptions = IllegalArgumentException.class)
    public void catchExceptionOfAllNoNubmersCharacteristics() {
        Car car = new Car(Double.parseDouble("test"), Double.parseDouble("test"), Integer.parseInt("test"));
    }

}