/*
 * File: Devices.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  smartLightSystem - EE333 Spring 2019
 * Vers: 1.0.1 03/28/2019 dgg - convert from long uid to property UID
 * Vers: 1.0.0 03/27/2019 dgg - initial coding
 */
package dgreen.smartlightsystem;

import java.util.HashMap;

/**
 * A collection of Device(s)
 * @author David G. Green dgreen@uab.edu
 */
public class Devices {
    //              uid     device
    private HashMap<String, Device> devices;
    
    /**
     * Create a collection to hold devices (initially empty)
     */
    public Devices() {
        devices = new HashMap<>();
    }
    
    /**
     * Add a device to the collection.  The uid property of the object will be used
     * as a key and trying a second device with the same key will silently ignored (presently)
     * @param device device object to add to the collection
     */
    public void add(Device device) {
        if (! devices.containsKey(device.getUid()) ) {
            devices.put(device.getUid(), device);
        } else {
            // TBD handle error ?
        }
    }
    
    /**
     * Find a device in collection by looking for its uid
     * @param uid string to use a uid when looking for a particular device
     * @return device found or null if no device
     */
    public Device findDevice(String uid) {
        return devices.get(uid);
    }
    
    /**
     * Return number of devices in collection
     * @return number of devices
     */
    public int size() {
        return devices.size();
    }
    
}

