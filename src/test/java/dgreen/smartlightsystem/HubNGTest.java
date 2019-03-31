/*
 * File: HubNGTest.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  smartLightSystem - EE333 Spring 2019
 * Vers: 1.0.0 03/29/2019 dgg - initial coding
 */
package dgreen.smartlightsystem;

import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test the Hub (with Bulbs)
 * @author David G. Green dgreen@uab.edu
 */
public class HubNGTest {
    
    private Hub     hub;
    private Bulb    b1;
    private Bulb    b2;
    private Devices pool;

    /**
     * Set up before a test
     *   - two bulbs with 8 digit uids
     *   - add bulbs to pool
     *   - create hub
     * @throws Exception
     */
    @BeforeMethod
    public void setUpMethod() throws Exception {
        b1   = new Bulb("12345678", null);
        b2   = new Bulb("12345679", null);
        pool = new Devices();
        hub  = new Hub(pool, null);
        
        pool.add(b1);
        pool.add(b2);
    }

    /**
     * Tear down after test, does nothing presently
     * @throws Exception
     */
    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of addDevice method, of class Hub.
     */
    @Test
    public void testAddDevice() {
        assertEquals(hub.getKnownDevices().size(), 0);
        try {
            hub.addDevice("12345678", "Bulb1");

            // should 1 device, with same values but not be same device
            assertEquals(hub.getKnownDevices().size(), 1);
            assertTrue(b1.equals(hub.getKnownDevices().findDevice("12345678")));
            assertTrue(hub.getKnownDevices().findDevice("12345678") != b1);

            hub.addDevice("12345679", "Bulb2");
            assertEquals(hub.getKnownDevices().size(), 2);
            assertTrue(b2.equals(hub.getKnownDevices().findDevice("12345679")));
            assertTrue(hub.getKnownDevices().findDevice("12345679") != b2);
            try {
                hub.addDevice("12345679", "NewName");
                fail("Did not throw Excption for additional add");
            } catch(DeviceAlreadyRegisteredException e) {
                // this should happend, proceed
            }
            assertEquals(hub.getKnownDevices().size(), 2);
        } catch(Exception e) {
            fail("Exception thrown");
        }
    }

    /**
     * Test of getDeviceByUID method, of class Hub.
     */
    @Test
    public void testGetDeviceByUID() {
        try {
            hub.addDevice("12345678", "Bulb1");
            hub.addDevice("12345679", "Bulb2");

            assertEquals(hub.getKnownDevices().size(), 2);
            Device d = hub.getDeviceByUID("12345679");

            // should be the copy not original
            assertEquals(d, b2);
            assertTrue(d != b2);
        } catch(Exception e) {
            fail("Exception thrown");
        }
    }

    /**
     * Test of getDeviceByName method, of class Hub.
     */
    @Test
    public void testGetDeviceByName() {
        try {
            hub.addDevice("12345678", "Bulb1");
            hub.addDevice("12345679", "Bulb2");

            assertEquals(hub.getKnownDevices().size(), 2);
            Device d = hub.getDeviceByName("Bulb1");

            // should be the copy not original
            assertEquals(d, b1);
            assertTrue(d != b1);

            try {
                hub.addDevice("12345679", "NewName");
                fail("Did not throw device already registered exception");
            } catch(DeviceAlreadyRegisteredException e) {
                // should happen
            }

            assertEquals(hub.getDeviceByName("Bulb2"), b2);
            try {
                hub.getDeviceByName("NewName");
                fail("Should throw NoSuchDeviceNameException");
            } catch(NoSuchDeviceNameException e) {
                // should happen
            }
        } catch(Exception e) {
            fail("Exception thrown");
        }
    }

    /**
     * Test of setDevice method, of class Hub.
     */
    @Test
    public void testSetDevice() {
        try {
            hub.addDevice("12345678", "Bulb1");
            hub.addDevice("12345679", "Bulb2");

            hub.setDevice("Bulb1", new Property("Status", "On"));

            // check local copy
            assertEquals(hub.getKnownDevices().findDevice("12345678").getProperties().getProperty("Status").getValue(),
                         "On");
            // check local copy using getDeviceProperties method
            assertEquals(hub.getDeviceProperties("Bulb1").getProperty("Status").getValue(), "On");

            // check actual bulb
            assertEquals(b1.getProperties().getProperty("Status").getValue(), "On");
        } catch(Exception e) {
            fail("Exception thrown");
        }
    }
}