/*
 * File: Device.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  smartLightSystem - EE333 Spring 2019
 * Vers: 1.0.3 04/21/2019 dgg - add lock() to lock properties from expanding
 * Vers: 1.0.2 03/30/2019 dgg - fix order of setting up logger and UID property
 * Vers: 1.0.1 03/28/2019 dgg - convert from long uid to property UID and supplied
 *                              at creation (presently uniqueness is caller's 
 *                              responsibility.
 * Vers: 1.0.0 03/14/2019 dgg - initial coding
 */
package dgreen.smartlightsystem;
import  dgreen.logging.Logger;
import java.util.Set;

/**
 * Model of a device
 * @author David G. Green dgreen@uab.edu
 */
public class Device implements Cloneable {

    private DeviceProperties properties;
    private Logger           logger;
    
    /**
     * Create a device with uid which will log with logger
     * @param uid    uid of device
     * @param logger logger to use
     */
    public Device(String uid, Logger logger) {
        
        properties = new DeviceProperties();
        set(logger);
        set(new Property("UID", uid));        
    }
    
    /**
     * Get the property associated with the name
     * @param name name of property
     * @return  property or null
     */
    Property get(String name) {
        return properties.getProperty(name);
    }    
        
    /**
     * Get all the properties of this device
     * @return object of type DeviceProperties containing all properties
     */
    public DeviceProperties getProperties() {
        return properties;
    }

    /**
     * Get the UID of this device
     * @return uid (a string)
     */
    public String getUid() {
        return properties.getProperty("UID").getValue();
    }
    
    /**
     * Set property of device by using a copy of supplied property
     * @param p property to inform setting
     */
    public void set(Property p) {
        properties.setProperty(new Property(p));
        logger.log(Logger.ALWAYS, "Device uid = " +
                              properties.getProperty("UID").getValue() +
                              " setting property: " + p.getName() +
                              " to " + p.getValue()
                );
    }
    
    /**
     * Set the logger for device (made final so it can be used in constructor without
     * fear it is overridden).
     * 
     * Note if no logger, then a Logger logger (no actions) is used.
     * 
     * @param logger the logger (or null if none)
     */
    public final void set(Logger logger) {
        if (logger == null) {
            this.logger = new Logger();
        } else {
            this.logger = logger;
        }     
    }
    
    /**
     * Make a copy of the device making all new parts so to model the 
     * separation between information in the hub and information in a device.  All
     * properties will match.
     * 
     * Done this way to avoid propagating the need to deal with an exception in
     * cloning (in the general case)
     * 
     * @return new Device
     */
    public Device mirror() {
        Device d = null;

        try {
            d = (Device) clone();
        } catch (Exception e) {
            
        }
        return d;
    }
    
    /**
     * Define equality between two devices to mean that all the properties in
     * this object match the same properties in the supplied object o.  Meaning the
     * o object could have additional properties without affecting equality.
     * 
     * This means given two devices d1 and d2, d1.equals(d2) may not yield same
     * result as d2.equals(d1).   This was done to allow the hub copy of the device
     * to contain additional properties if desires.
     * 
     * @param o object to compare to (must be a device to even start to measure equality)
     * @return true if equal (as defined above)
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Device) {
            Device d = (Device) o;
            Set<String> names = properties.getPropertyNames();            
            for (String propertyName : names) {
                if (! properties.getProperty(propertyName).getValue().equals(
                  d.getProperties().getProperty(propertyName).getValue())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Lock this device's properties from expanding
     */
    public void lock() {
        properties.lock();
    }
    
    /**
     * Make a copy of the device making all new parts so to model the 
     * separation between information in the hub and information in a device.  All
     * properties will match.
     * @return copy of device
     * @throws CloneNotSupportedException should not happen
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Device copy = (Device) super.clone();

        set((Logger) null);
                    
        // Create copy of properties from found device into hub copy of the device
        Set<String> foundPropertyNames = properties.getPropertyNames();            
        for (String propertyName : foundPropertyNames) {
            copy.set(new Property(propertyName, get(propertyName).getValue()));
        }
        
        return copy;
    }
}
