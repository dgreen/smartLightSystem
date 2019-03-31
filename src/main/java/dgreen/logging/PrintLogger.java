/*
 * File: PrintLogger.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  smartLightSystem - EE333 Spring 2019
 * Vers: 1.0.0 03/15/2019 dgg - initial coding
 */
package dgreen.logging;

/**
 * Log to standard out
 * @author David G. Green dgreen@uab.edu
 */
public class PrintLogger extends Logger {
    
    /**
     * Create a print logger
     */
    public PrintLogger() {
        super();
    }
    
    /**
     * Write message s to stdout
     * @param s message
     */
    @Override
    public void write(String s) {
        System.out.println(s);
    }

}
