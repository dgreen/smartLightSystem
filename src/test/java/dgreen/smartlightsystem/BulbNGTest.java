/*
 * File: Bulb.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  smartLightSystem - EE333 Spring 2019
 * Vers: 1.0.0 03/27/2019 dgg - initial coding
 */
package dgreen.smartlightsystem;

import static org.testng.Assert.*;
import org.testng.annotations.*;

/**
 *
 * @author David G. Green dgreen@uab.edu
 */
public class BulbNGTest {
    
    private Bulb b1;
    private Bulb b2;
    
    public BulbNGTest() {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        b1 = new Bulb(null);
        b2 = new Bulb(null);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test
    public void testInitialization() {
        assertEquals(b1.get("Status").getValue(),    "Off");
        assertEquals(b1.get("Color").getValue(),     "white");
        assertEquals(b1.get("Intensity").getValue(), "100");
        assertEquals(b1.get("Type").getValue(),      "Bulb");
        assertEquals(b2.get("Status").getValue(),    "Off");
        assertEquals(b2.get("Color").getValue(),     "white");
        assertEquals(b2.get("Intensity").getValue(), "100");
        assertEquals(b2.get("Type").getValue(),      "Bulb");
    }
    
    @Test
    public void testChange() {
        b1.set(new Property("Status", "On"));
        assertEquals(b1.get("Status").getValue(),    "On");
        assertEquals(b2.get("Status").getValue(),    "Off");
    }
    
    @Test
    public void testLocked() {
        b1.set(new Property("Unknown", "Wacky"));
        assertEquals(b1.get("Unknown"), null);
    }
    
}
