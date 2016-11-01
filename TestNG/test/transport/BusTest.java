package tat.bsu.transport;

import org.testng.annotations.*;

/**
 * test class Bus
 */
public class BusTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void catchExceptionOfOneNoNubmerCharacteristic() {
        Bus bus = new Bus(Double.parseDouble("test"), 20.0, 5);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void catchExceptionOfAllNoNubmersCharacteristics() {
        Bus bus = new Bus(Double.parseDouble("test"),Double.parseDouble("test"), Integer.parseInt("test"));
    }

}
