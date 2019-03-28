/*
 * File: Devices.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  smartLightSystem - EE333 Spring 2019
 * Vers: 1.0.0 03/27/2019 dgg - initial coding
 */
package dgreen.smartlightsystem;

import java.util.HashMap;

/**
 * A collection of Device(s)
 * @author David G. Green dgreen@uab.edu
 */
public class Devices {
    private HashMap<Long, Device> devices;
    
    public Devices() {
        devices = new HashMap<>();
    }
    
    public void add(Device device) {
        devices.put(device.getUid(), device);
    }
    
    public Device findDevice(long uid) {
        return devices.get(uid);
    }
}

