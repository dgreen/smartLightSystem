/*
 * File: PrintLogger.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  smartLightSystem - EE333 Spring 2019
 * Vers: 1.0.0 03/15/2019 dgg - initial coding
 */
package dgreen.logging;

/**
 *
 * @author David G. Green dgreen@uab.edu
 */
public class PrintLogger extends Logger {
    
    public PrintLogger() {
        super();
    }
    
    @Override
    public void write(String s) {
        System.out.println(s);
    }

}
