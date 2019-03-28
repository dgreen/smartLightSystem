/*
 * File: Hub.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  smartLightSystem - EE333 Spring 2019
 * Vers: 1.0.0 03/27/2019 dgg - initial coding
 *
 * Credits:  (if any for sections of code)
 */
package dgreen.smartlightsystem;

import dgreen.logging.Logger;

/**
 *
 * @author David G. Green dgreen@uab.edu
 */
public class Hub {

    private Logger logger;
    private Devices knownDevices;      // hubs knowledge of known devices
    private Devices pool;               // device pool in environment
    
    
    /**
     * Create a hub
     * 
     * The pool of devices contain references to the real devices out in the environment
     * 
     * The hub will also have an object that is built internally to track the external devices
     * 
     * @param pool Devices object containing devices in the environment (can not be null)
     * @param logger 
     */
    public Hub(Devices pool, Logger logger) {
        this.pool = pool;
        if (logger == null) {
            this.logger = new Logger();  // null logger
        } else {
            this.logger = logger;
        }
        knownDevices = new Devices();
    }
    
    /**
     * Add a device to the hub.  The pool will be searched for a device with the uid
     * and if so, a clone of that device will be placed in the knownDevices with the
     * given name (and uid)
     * @param uid
     * @param name 
     */
    public void addDevice(long uid, String name) {
        
    }
    
    public Devices getKnownDevices() {
        return null;
    }
    
    public Device getDevice(long uid) {
        return null;
    }
    
    public Device getDevice(String name) {
        return null;
    }
    
    public void setDevice(String name, Property property) {
        
    }
    
    public DeviceProperties getDeviceProperties(String name) {
        return null;
    }
    
    
}
