/*
 * File: DevicesNGTest.java
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
 * Test Devices
 * @author David G. Green dgreen@uab.edu
 */
public class DevicesNGTest {
    
    Device  device1;
    Device  device2;
    Devices devices;

    @BeforeMethod
    public void setUpMethod() throws Exception {
        device1 = new Device("100", null);
        device2 = new Device("101", null);
        devices = new Devices();
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of add method, of class Devices.
     */
    @Test
    public void testAdd() {
        assertEquals(devices.size(), 0);
        devices.add(device1);
        assertEquals(devices.size(), 1);
        devices.add(device2);
        assertEquals(devices.size(), 2);
    }

    /**
     * Test of findDevice method, of class Devices.
     */
    @Test
    public void testFindDevice() {
        devices.add(device1);
        devices.add(device2);
        assertEquals(devices.findDevice("100"), device1);
        assertEquals(devices.findDevice("101"), device2);
    }

}