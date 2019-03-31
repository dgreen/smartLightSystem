/*
 * File: SmartSystemException.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  smartLightSystem - EE333 Spring 2019
 * Vers: 1.0.0 03/30/2019 dgg - initial coding
 *
 * Credits:  (if any for sections of code)
 */
package dgreen.smartlightsystem;

/**
 * Superclass for all custom exceptions
 * @author David G. Green dgreen@uab.edu
 */
public class SmartSystemException extends Exception {
    
    /**
     * Construct exception with a message s
     * @param s 
     */
    public SmartSystemException(String s) {
        super(s);
    }
    
}
