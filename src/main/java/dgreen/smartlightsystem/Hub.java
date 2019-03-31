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
     * Add a device to the hub.The pool will be searched for a device with the uid
     * and if so, a clone of that device will be placed in the knownDevices with the
     * given name (and uid)
     * @param uid uid of the device we think is findable in pool
     * @param name name we want to assign to the device
     * @throws dgreen.smartlightsystem.SmartSystemException (actually subclasses)
     * 
     * Including DeviceAlreadyRegisteredException, DeviceNotFoundException
     */
    public void addDevice(String uid, String name) throws SmartSystemException {
        Device foundDevice;
        Device hubCopyDevice;
        
        if ( knownDevices.findDevice(uid) != null ) {
            throw new DeviceAlreadyRegisteredException(name);
        }            
        
        if ( (foundDevice = pool.findDevice(uid)) != null ) {
            // add device and associate with name
            hubCopyDevice = foundDevice.mirror();

            knownDevices.add(hubCopyDevice);
            namesToUID.put(name, uid);            
        } else {
            throw new DeviceNotFoundException(uid);
        }
    }
    
    /**
     * Supply all of the known devices (registered with hub)
     * @return a collection of devices
     */
    public Devices getKnownDevices() { 
        return knownDevices;
    }
    
    /**
     * Get a device given a UID in known devices
     * @param uid uid of known device
     * @return Device
     * @throws SmartSystemException
     */
    public Device getDeviceByUID(String uid) throws SmartSystemException {
        return knownDevices.findDevice(uid);
    }
    
    /**
     * Get a device given its assigned name
     * @param name assigned name of device
     * @return Device with name
     * @throws SmartSystemException
     * 
     * Exceptions include NoSuchDeviceNameException
     */
    public Device getDeviceByName(String name) throws SmartSystemException {
        String uid = namesToUID.get(name);
        
        if (uid == null) throw new NoSuchDeviceNameException(name);
        
        return getDeviceByUID(uid);
    }
    
    /**
     * Set a property of a device with specified name
     * @param name device name
     * @param property property to set in device
     * @throws SmartSystemException
     * 
     * Exceptions include NoSuchDeviceNameException
     */
    public void setDevice(String name, Property property) throws SmartSystemException {
        Device device = getDeviceByName(name);
        
        if (device == null) throw new NoSuchDeviceNameException(name);
        
        device.set(property);
        pool.findDevice(namesToUID.get(name)).set(property);
    }
    
    /**
     * Get all the properties of a device given its name
     * @param name name of device
     * @return properties of device
     * @throws SmartSystemException
     * 
     * Exceptions include NoSuchDeviceNameException
     */
    public DeviceProperties getDeviceProperties(String name) throws SmartSystemException {
        Device device = getDeviceByName(name);
        
        if (device == null) throw new NoSuchDeviceNameException(name);
        
        return device.getProperties();
    }
    
}
