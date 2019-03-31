/*
 * File: DeviceAlreadyRegisteredException.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  smartLightSystem - EE333 Spring 2019
 * Vers: 1.0.0 03/30/2019 dgg - initial coding
 */
package dgreen.smartlightsystem;


/**
 * Device already registered exception
 * @author David G. Green dgreen@uab.edu
 */
public class DeviceAlreadyRegisteredException extends SmartSystemException {

    /**
     * Construct exception with a message s
     * @param s 
     */
    public DeviceAlreadyRegisteredException(String s) {
        super(s);
    }

}
