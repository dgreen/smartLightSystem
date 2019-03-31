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

    /**
     * DEBUG level of logging (most often screened out, lowest value)
     */
    public static final int DEBUG      = 0;
    /**
     * INFO level of logging (&gt; DEBUG)
     */
    public static final int INFO       = 10;
    /**
     * TIMESTAMP Level of logging (&gt; INFO)
    */
    public static final int TIMESTAMP  = 20;
    /**
     * WARNING level of logging (&gt;TIMESTAMP)
     */
    public static final int WARNING    = 50;
    /**
     * ERROR level of logging (&gt; WARNING)
     */
    public static final int ERROR      = 100;
    /**
     * ALWAYS level of logging (&gt; everything else)
     */
    public static final int ALWAYS     = 100000;

    private int logLevel = 0;
    
    /**
     * Create a null logger
     */
    public Logger() {
        
    }

    /**
     * Store the level of logging
     * @param newLevel level for logger to use internally in deciding to write or not
     */
    public void setLevel(int newLevel) {
        logLevel = newLevel;
    }
    
    /**
     * Log mesaage s through write method if level &gt; internal level 
     * @param level level of message
     * @param s     text of message
     */
    public void log(int level, String s) {
        if (level >= logLevel) {
            write(s);
        }
    }
    
    /**
     * Write out message s but since null logger, do nothing (unless overridden in subclass)
     * @param s message to log
     */
    public void write(String s) {
        
    }
    
    /**
     * Close logger - does nothing unless overridden
     */
    public void close() {
        
    }
}
