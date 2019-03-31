/*
 * File: DeviceNotFoundException.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  smartLightSystem - EE333 Spring 2019
 * Vers: 1.0.0 03/30/2019 dgg - initial coding
 */
package dgreen.smartlightsystem;

/**
 * Device not found exception
 * @author dgreen
 */
public class DeviceNotFoundException extends SmartSystemException {

    /**
     * Construct exception with a message s
     * @param s 
     */
    public DeviceNotFoundException(String s) {
        super(s);
    }

}
