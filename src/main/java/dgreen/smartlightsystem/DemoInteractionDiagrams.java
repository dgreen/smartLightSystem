/*
 * File: DemoInteractionDiagrams.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  smartLightSystem - EE333 Spring 2019
 * Vers: 1.0.0 03/30/2019 dgg - initial coding
 */
package dgreen.smartlightsystem;

import dgreen.logging.Logger;
import dgreen.logging.PrintLogger;

/**
 * Demonstration the two simple stories in the Interaction Diagrams
 * @author David G. Green dgreen@uab.edu
 */
public class DemoInteractionDiagrams {
    
    /**
     * Run the setup and stories associated with interaction diagrams 1 and 2
     * @param args
     */
    public static void main(String[] args) {
        
        Controller  controller;
        Hub         hub;
        Bulb        b1;
        Bulb        b2;
        Devices     pool;

        Logger      logger = new PrintLogger();
        logger.setLevel(Logger.DEBUG);

        b1         = new Bulb("100", logger);
        b2         = new Bulb("101", logger);
        pool       = new Devices();
        hub        = new Hub(pool, logger);

                
        pool.add(b1);
        pool.add(b2);

        controller = new Controller(logger);
        
        controller.add(hub);
        
        // Interaction Diagram #1
        
        logger.log(Logger.ALWAYS, "Demo Interaction Diagram 1");
        
        try {
            controller.addDevice("100", "BULB");
            DeviceProperties deviceProperties;
            deviceProperties = controller.getDeviceProperties("BULB");
            // print them out
            controller.setDevice("BULB", new Property("Status", "On"));
            // check
            controller.setDevice("BULB", new Property("Status", "Off"));
            //
        } catch( SmartSystemException e) {
            logger.log(Logger.ERROR, "SmartSystemException occurred unexpectedly");
        }
        
        // Interaction Diagram #2
        
        logger.log(Logger.ALWAYS, "Set up precondition for Interaction Diagram 2");
        
        try {
            controller.addDevice("101", "MoodLight");

            logger.log(Logger.ALWAYS, "Demo Interaction Diagram 2");

            controller.setDevice("MoodLight", new Property("Color",  "blue"));
            controller.setDevice("MoodLight", new Property("Status", "On"));
        } catch( SmartSystemException e) {
            logger.log(Logger.ERROR, "SmartSystemException occurred unexpectedly");
        }
        
        logger.close();
    }

}
