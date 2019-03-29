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
    
    public Devices() {
        devices = new HashMap<>();
    }
    
    public void add(Device device) {
        if (! devices.containsKey(device.getUid()) ) {
            devices.put(device.getUid(), device);
        } else {
            // TBD handle error ?
        }
    }
    
    public Device findDevice(String uid) {
        return devices.get(uid);
    }
    
    public int size() {
        return devices.size();
    }
    
}

