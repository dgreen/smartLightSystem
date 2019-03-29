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
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author David G. Green dgreen@uab.edu
 */
public class Hub {

    private Logger logger;
    private Devices knownDevices;             // hubs knowledge of known devices
    private Devices pool;                     // device pool in environment
    //               name   uid
    private HashMap<String,String> namesToUID; // map names to UIDs
    
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
        namesToUID = new HashMap<>();
    }
    
    /**
     * Add a device to the hub.  The pool will be searched for a device with the uid
     * and if so, a clone of that device will be placed in the knownDevices with the
     * given name (and uid)
     * @param uid
     * @param name 
     */
    public void addDevice(String uid, String name) {
        Device foundDevice;
        Device hubCopyDevice;
        
        if ( knownDevices.findDevice(uid) != null ) {
            // handle error -- device already known
            return;
        }
            
        
        if ( (foundDevice = pool.findDevice(uid)) != null ) {
            // add device and associate with name
            hubCopyDevice = foundDevice.mirror();

            knownDevices.add(hubCopyDevice);
            namesToUID.put(name, uid);            
        } else {
            // TBD handle device not found error
        }
    }
    
    public Devices getKnownDevices() { 
        return knownDevices;
    }
    
    public Device getDeviceByUID(String uid) {
        return knownDevices.findDevice(uid);
    }
    
    public Device getDeviceByName(String name) {
        String uid = namesToUID.get(name);
        
        return getDeviceByUID(uid);
    }
    
    public void setDevice(String name, Property property) {
        getDeviceByName(name).set(property);
        pool.findDevice(namesToUID.get(name)).set(property);
    }
    
    public DeviceProperties getDeviceProperties(String name) {
        return getDeviceByName(name).getProperties();
    }
    
}
