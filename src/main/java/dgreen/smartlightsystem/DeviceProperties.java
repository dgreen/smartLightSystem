/*
 * File: DeviceProperties.java
 * Author: dgreen
 * Assignment:  smartLightSystem - EE333 Spring 2019
 * Vers: 1.0.0 03/14/2019 dgg - initial coding
 *
 * Credits:  (if any for sections of code)
 */
package dgreen.smartlightsystem;

import java.util.HashMap;
import java.util.Set;

/**
 * A collection of device properties
 * @author dgreen
 */
public class DeviceProperties {

    HashMap<String, Property> propertiesMap;
    private boolean locked;
    
    /**
     * Create the device properties object
     */
    public DeviceProperties() {
        propertiesMap = new HashMap<>();
    }
    
    /**
     * get a Property with name aName from the collection
     * @param aName the name of the property desired
     * @return Property associated with aName
     */
    public Property getProperty(String aName) {
        return propertiesMap.get(aName);
    }
    
    /**
     * Set a property.  If not locked, new properties are allowed.  If locked,
     * silently ignore the new property.
     * @param p property to change or add to collection
     */
    public void setProperty(Property p) {
        if ( locked && ! propertiesMap.containsKey(p.getName())) {
            return;
        }
        propertiesMap.put(p.getName(), p);
    }
    
    /**
     * Lock the device properties object to not allow any new properties (although
     * one can change value of existing named property.
     */
    public void lock() {
        locked = true;
    }

    /**
     * Get the value of locked
     *
     * @return the value of locked
     */
    public boolean isLocked() {
        return locked;
    }
    
    /**
     * Get all of the property names in the collection as a set
     * @return set of strings containing all names
     */
    public Set<String> getPropertyNames() {
        return propertiesMap.keySet();
    }
    
}
