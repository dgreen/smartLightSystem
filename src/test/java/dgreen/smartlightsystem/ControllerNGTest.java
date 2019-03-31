/*
 * File: ControllerNGTest.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  smartLightSystem - EE333 Spring 2019
 * Vers: 1.0.0 03/30/2019 dgg - initial coding
 */
package dgreen.smartlightsystem;

import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author David G. Green dgreen@uab.edu
 */
public class ControllerNGTest {
    
    private Controller  controller;
    private Hub         hub;
    private Bulb        b1;
    private Bulb        b2;
    private Devices     pool;


    @BeforeMethod
    public void setUpMethod() throws Exception {
        b1         = new Bulb("100", null);
        b2         = new Bulb("101", null);
        pool       = new Devices();
        hub        = new Hub(pool, null);

                
        pool.add(b1);
        pool.add(b2);

        controller = new Controller(null);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of addDevice method, of class Controller.
     */
    @Test
    public void testAddDevice() throws Exception {
        controller.add(hub);
        
        try {
            controller.addDevice("100", "Bulb1");

            // should 1 device, with same values but not be same device
            assertEquals(hub.getKnownDevices().size(), 1);
            assertTrue(b1.equals(hub.getKnownDevices().findDevice("100")));
            assertTrue(hub.getKnownDevices().findDevice("100") != b1);

            controller.addDevice("101", "Bulb2");
            assertEquals(hub.getKnownDevices().size(), 2);
            assertTrue(b2.equals(hub.getKnownDevices().findDevice("101")));
            assertTrue(hub.getKnownDevices().findDevice("101") != b2);
            try {
                controller.addDevice("101", "NewName");
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
     * Test of setDevice method, of class Controller.
     */
    @Test
    public void testSetDevice() throws Exception {
        
        controller.add(hub);
        
        try {
            controller.addDevice("100", "Bulb1");
            controller.addDevice("101", "Bulb2");

            controller.setDevice("Bulb1", new Property("Status", "On"));

            // check local copy
            assertEquals(hub.getKnownDevices().findDevice("100").getProperties().getProperty("Status").getValue(),
                         "On");
            // check local copy using getDeviceProperties method
            assertEquals(controller.getDeviceProperties("Bulb1").getProperty("Status").getValue(), "On");

            // check actual bulb
            assertEquals(b1.getProperties().getProperty("Status").getValue(), "On");
        } catch(Exception e) {
            fail("Exception thrown");
        }
    }

}