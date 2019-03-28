/*
 * File: Logger.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  smartLightSystem - EE333 Spring 2019
 * Vers: 1.0.0 03/14/2019 dgg - initial coding
 */
package dgreen.logging;

/**
 * A null logger with support for sub classes
 * @author David G. Green dgreen@uab.edu
 */
public class Logger {

    public static final int DEBUG      = 0;
    public static final int INFO       = 10;
    public static final int TIMESTAMP  = 20;
    public static final int WARNING    = 50;
    public static final int ERROR      = 100;
    public static final int ALWAYS     = 100000;

    private int logLevel = 0;
    
    public Logger() {
        
    }

    public void setLevel(int newLevel) {
        logLevel = newLevel;
    }
    
    public void log(int level, String s) {
        if (level >= logLevel) {
            write(s);
        }
    }
    
    public void write(String s) {
        
    }
    
    public void close() {
        
    }
}
