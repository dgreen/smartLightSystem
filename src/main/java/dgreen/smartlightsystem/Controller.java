/*
 * File: Controller.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  smartLightSystem - EE333 Spring 2019
 * Vers: 1.0.0 03/30/2019 dgg - initial coding
 */
package dgreen.smartlightsystem;

import dgreen.logging.Logger;
import java.util.ArrayList;

/**
 * Controller for Smart Light System (non-GUI parts)
 * 
 * TBD: Error handling
 * TBD: Local state to avoid lots of traffic
 * 
 * @author David G. Green dgreen@uab.edu
 */
public class Controller {

    private Hub               hub;
    private Logger            logger;
    private ArrayList<String> knownDeviceNames;
    
    /**
     * Create a simple controller with a logger or if null furnished, create a Logger (null) object
     * @param logger the logger to use (or null)
     */
    public Controller(Logger logger) {
        
        knownDeviceNames = new ArrayList<>();
        
        if (logger != null) {
            this.logger = logger;
        } else {
            this.logger = new Logger();
        }
    }
    
    /**
     * Get the properties for a device by name
     * @param name name of device as registered
     * @return Devices properties for the specified device or null if no such device
     * @throws dgreen.smartlightsystem.SmartSystemException (or one of subclasses)
     */
    public DeviceProperties getDeviceProperties(String name) throws SmartSystemException {
        return hub.getDeviceProperties(name);
    }
    
    /**
     * Add hub to controller (or overwrite if another call is made)
     * @param hub hub to use
     */
    public void add(Hub hub) {
        this.hub = hub;
    }
    
    /**
     * Add device with uid to system with specified name
     * @param uid device's uid
     * @param name name to use to refer to device
     * @throws SmartSystemException (or one of subclasses)
     */
    public void addDevice(String uid, String name) throws SmartSystemException {
        hub.addDevice(uid, name);
        knownDeviceNames.add(name);
    }
    
    /**
     * Set property p (name and value) of the device referred to as name 
     * @param name device name
     * @param p property with new desired value
     * @throws SmartSystemException (or one of subclasses)
     */
    public void setDevice(String name, Property p) throws SmartSystemException {
        hub.setDevice(name, p);
    }
    
}
