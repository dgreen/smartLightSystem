/*
 * File: Device.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  smartLightSystem - EE333 Spring 2019
 * Vers: 1.0.0 03/14/2019 dgg - initial coding
 */
package dgreen.smartlightsystem;
import  dgreen.logging.Logger;

/**
 * Model of a device
 * @author David G. Green dgreen@uab.edu
 */
public class Device {

    private DeviceProperties properties;
    private long             uid;
    private static long      uidCounter = 10000000;
    private Logger           logger;
    
    public Device(Logger logger) {
        properties = new DeviceProperties();
        uid = uidCounter++;
        if (logger == null) {
            this.logger = new Logger();  // null logger
        } else {
            this.logger = logger;
        }
    }
    
    Property get(String name) {
        return properties.getProperty(name);
    }    
        
    public DeviceProperties getProperties() {
        return properties;
    }

    public long getUid() {
        return uid;
    }
    
    public void set(Property p) {
        properties.setProperty(p);
    }
    
    // how to deal with change uid (if reusing in 
}
