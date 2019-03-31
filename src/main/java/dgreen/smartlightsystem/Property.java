/*
 * File: Property.java
 * Author: dgreen
 * Assignment:  smartLightSystem - EE333 Spring 2019
 * Vers: 1.0.0 03/14/2019 dgg - initial coding
 */
package dgreen.smartlightsystem;

/**
 * Model a property (name, value pair)
 * @author dgreen
 */
public class Property {
    
    private String name;
    private String value;
    
    /**
     * Create a property object with a name and value
     * @param name  property name
     * @param value property value
     */
    public Property(String name, String value) {
        this.name  = name;
        this.value = value;
    }
    
    /**
     * Create a property matching an existing property
     * @param p source property
     */
    public Property(Property p) {
        this.name =  p.name;
        this.value = p.value;
    }

    /**
     * Get the name of this property
     * @return name of property
     */
    public String getName() {
        return name;
    }
    
    /**
     * Get the value of this property
     * @return value of the property
     */
    public String getValue() {
        return value;
    }
    
    /**
     * Set a new value of the property (assumed to be non-null)
     * @param value non-null value of property
     */
    public void setValue(String value) {
        this.value = value;
    }
    
    /**
     * Is the property's name equal to the specified name
     * @param name does this match
     * @return true if a match using equals()
     */
    public boolean isName(String name) {
        return name.equals(this.name);
    }
    
}
