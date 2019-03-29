/*
 * File: Device.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  smartLightSystem - EE333 Spring 2019
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
    
    public Device(String uid, Logger logger) {
        
        properties = new DeviceProperties();
        set(new Property("UID", uid));        
        set(logger);
    }
    
    Property get(String name) {
        return properties.getProperty(name);
    }    
        
    public DeviceProperties getProperties() {
        return properties;
    }

    public String getUid() {
        return properties.getProperty("UID").getValue();
    }
    
    /**
     * Set property of device by using a copy of supplied property
     * @param p property to inform setting
     */
    public void set(Property p) {
        properties.setProperty(new Property(p));
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
    
    public Device mirror() {
        Device d = null;

        try {
            d = (Device) clone();
        } catch (Exception e) {
            
        }
        return d;
    }
    
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
