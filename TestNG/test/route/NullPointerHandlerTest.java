package tat.bsu.route;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * test class NullPointerHandler
 */
public class NullPointerHandlerTest {
    NullPointerHandler handler = new NullPointerHandler();

    @Test(expectedExceptions = NullPointerException.class)
    public void testCheckNullPointerWithNullObject() throws Exception {
         handler.checkNullPointer(null);
    }

}