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
    
    Hub hub;
    Bulb b1;
    Bulb b2;
    Devices pool;

    @BeforeMethod
    public void setUpMethod() throws Exception {
        b1   = new Bulb("100", null);
        b2   = new Bulb("101", null);
        pool = new Devices();
        hub  = new Hub(pool, null);
        
        pool.add(b1);
        pool.add(b2);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of addDevice method, of class Hub.
     */
    @Test
    public void testAddDevice() {
        assertEquals(hub.getKnownDevices().size(), 0);
        
        hub.addDevice("100", "Bulb1");

        // should 1 device, with same values but not be same device
        assertEquals(hub.getKnownDevices().size(), 1);
        assertTrue(b1.equals(hub.getKnownDevices().findDevice("100")));
        assertTrue(hub.getKnownDevices().findDevice("100") != b1);
        
        hub.addDevice("101", "Bulb2");
        assertEquals(hub.getKnownDevices().size(), 2);
        assertTrue(b2.equals(hub.getKnownDevices().findDevice("101")));
        assertTrue(hub.getKnownDevices().findDevice("101") != b2);
        
        hub.addDevice("101", "NewName");
        assertEquals(hub.getKnownDevices().size(), 2);
    }

    /**
     * Test of getDeviceByUID method, of class Hub.
     */
    @Test
    public void testGetDeviceByUID() {
        hub.addDevice("100", "Bulb1");
        hub.addDevice("101", "Bulb2");
        
        assertEquals(hub.getKnownDevices().size(), 2);
        Device d = hub.getDeviceByUID("101");
        
        // should be the copy not original
        assertEquals(d, b2);
        assertTrue(d != b2);
    }

    /**
     * Test of getDeviceByName method, of class Hub.
     */
    @Test
    public void testGetDeviceByName() {
        hub.addDevice("100", "Bulb1");
        hub.addDevice("101", "Bulb2");
        
        assertEquals(hub.getKnownDevices().size(), 2);
        Device d = hub.getDeviceByName("Bulb1");
        
        // should be the copy not original
        assertEquals(d, b1);
        assertTrue(d != b1);
        
        hub.addDevice("101", "NewName");
        
        assertEquals(hub.getDeviceByName("Bulb2"), b2);
        hub.getDeviceByName("NewName");
        assertEquals(hub.getDeviceByName("NewName"), null);
    }

    /**
     * Test of setDevice method, of class Hub.
     */
    @Test
    public void testSetDevice() {
        hub.addDevice("100", "Bulb1");
        hub.addDevice("101", "Bulb2");

        hub.setDevice("Bulb1", new Property("Status", "On"));
        
        // check local copy
        assertEquals(hub.getKnownDevices().findDevice("100").getProperties().getProperty("Status").getValue(),
                     "On");
        // check local copy using getDeviceProperties method
        assertEquals(hub.getDeviceProperties("Bulb1").getProperty("Status").getValue(), "On");
        
        // check actual bulb
        assertEquals(b1.getProperties().getProperty("Status").getValue(), "On");
    }
}