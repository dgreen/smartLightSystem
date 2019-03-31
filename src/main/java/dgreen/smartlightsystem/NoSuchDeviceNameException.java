/*
 * File: NoSuchDeviceNameException.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  smartLightSystem - EE333 Spring 2019
 * Vers: 1.0.0 03/30/2019 dgg - initial coding
 */
package dgreen.smartlightsystem;

/**
 * No such device name exception
 * @author dgreen
 */
public class NoSuchDeviceNameException extends SmartSystemException {

    /**
     * Construct exception with a message s
     * @param s 
     */
    public NoSuchDeviceNameException(String s) {
        super(s);
    }

}
