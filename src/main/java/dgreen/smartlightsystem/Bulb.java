/*
 * File: Bulb.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  smartLightSystem - EE333 Spring 2019
 * Vers: 1.0.0 03/27/2019 dgg - initial coding
 */
package dgreen.smartlightsystem;

import dgreen.logging.Logger;

/**
 * Model a bulb (as a type of device)
 *
 * @author David G. Green dgreen@uab.edu
 */
public class Bulb extends Device {

    /**
     * Create a Bulb setting properties appropriately
     *
     * @param logger
     */
    public Bulb(Logger logger) {
        super(logger);

        /*
         * Dev note:  use super.getProperties() so that it is clear that we won't be
         * using a getProperties that could be defined in Bulb (subclass) in a 
         * constructor.
         */
        super.getProperties().setProperty(new Property("Type", "Bulb"));
        super.getProperties().setProperty(new Property("Status", "Off"));
        super.getProperties().setProperty(new Property("Color", "white"));
        super.getProperties().setProperty(new Property("Intensity", "100"));  // percentage
        super.getProperties().lock();
    }

}
