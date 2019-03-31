/*
 * File: NameAlreadyRegisteredException.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  smartLightSystem - EE333 Spring 2019
 * Vers: 1.0.0 03/30/2019 dgg - initial coding
 */
package dgreen.smartlightsystem;

/**
 * Name already registered exception
 * @author dgreen
 */
public class NameAlreadyRegisteredException extends SmartSystemException {

    /**
     * Construct exception with a message s
     * @param s 
     */
    public NameAlreadyRegisteredException(String s) {
        super(s);
    }

}
