package com.iii.pel.forms.PILM016_APAC;
  
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Enumeration;
import java.util.ResourceBundle;

// TODO: Auto-generated Javadoc
/**
 * Provides helper method to handle property file.
 */
public class PropertyManager {
	
	/** The resource bundle. */
	private static ResourceBundle pelResourceBundle;
    
	/**
	 * Private constructor to implement singleton.
	 */
    private PropertyManager(){
        
    }

    /**
     * Instantiate com.iii.apps.p11rating.properties.rating.properties in it is not instantiate
     */
    private static void instantiateProperty(){
    	if(pelResourceBundle == null){
    		pelResourceBundle = ResourceBundle.getBundle("messageProperties");
    	}
    }
    
    /**
     * Retrieves the string value of a key.
     * 
     * @param key The key string
     * 
     * @return 	The string value for the key
     */
    public static String getValue(String key){
        String value = null;
        
        if(key != null){
        	PropertyManager.instantiateProperty();
            value = pelResourceBundle.getString(key);
        }
        
        return value;
    }
    
    /**
     * Gets the array of values of the key.
     * 
     * @param key 	The key string
     * 
     * @return 		The array of string values
     */
    public static String[] getValueArray(String key){
    	PropertyManager.instantiateProperty();
    	return (PropertyManager.getValue(key).split(","));
    }
    
    /**
     * Method retrives the keys of the bundle and returns as an anumeration of Strings.
     * 
     * @return Enumeration<String> the Enumeration object
     */
    public static Enumeration<String> getKeys(){
    	PropertyManager.instantiateProperty();
    	return pelResourceBundle.getKeys();
    }
    
    /**
     * Appends '_X', '_Y', '_Width', '_Height' with the geven key,
     * gets the corresponding integer values from property file, and returns
     * a java.awt.Rectangle object for the specified values
     * 
     * @param key The key string
     * 
     * @return 	The java.awt.Rectangle object as rectangle
     */
    public static Rectangle getRectangle(String key)
    {
    	PropertyManager.instantiateProperty();
    	int x_position=Integer.parseInt(getValue(key+"_X"));
    	int y_position=Integer.parseInt(getValue(key+"_Y"));
    	int width=Integer.parseInt(getValue(key+"_Width"));
    	int height=Integer.parseInt(getValue(key+"_Height"));
       	Rectangle rectangle=new Rectangle(x_position,y_position,width,height);
    	return rectangle;
      	
    }
    
    /**
     * Gets the color.
     * 
     * @param key the key
     * 
     * @return the color
     */
    public static Color getColor(String key)
    {
    	int red=Integer.parseInt(getValue(key+"_R"));
    	int green=Integer.parseInt(getValue(key+"_G"));
    	int blue=Integer.parseInt(getValue(key+"_B"));
    	
    	Color color=new Color(red,green,blue);
    	return color;
    }

    /**
     * Appends '_Width', '_Height' with the geven key,
     * gets the corresponding integer values from property file, and returns
     * a java.awt.Rectangle object for the specified values
     * 
     * @param key The key string
     * 
     * @return 	The java.awt.Dimension object as dimension
     */
    public static Dimension getDimension(String key)
    {
    	PropertyManager.instantiateProperty();
    	int width=Integer.parseInt(getValue(key+"_Dimension_Width"));
    	int height=Integer.parseInt(getValue(key+"_Dimension_Height"));
       	Dimension dimension=new Dimension(width,height);
    	return dimension;
      	
    }
    
    /**
     * Method checks if a key is there in property file.
     * 
     * @param key the key
     * 
     * @return true, if contains
     */
    public static boolean contains(String key) {
    	PropertyManager.instantiateProperty();
    	return pelResourceBundle.containsKey(key);
    }
    
    /**
     * Retrieves the value for the key string and returns as int value.
     * 
     * @param key The key string
     * 
     * @return 	The int value
     */
    public static int getInt(String key)
    {
    	int value=0;

    	PropertyManager.instantiateProperty();
    	value=Integer.parseInt(getValue(key));
    	return value;
    }
    
    /**
     * Test class for PropertyManager.
     * 
     * @param args 	The command line arguments
     */
    public static void main(String args[]){
    	String string[] = null;
    	PropertyManager.instantiateProperty();
    	string  = getValueArray("_LOADTEST");
    	if(string != null){
    		for(String tstr: string){
    			System.out.println(">"+tstr);
    		}
    	}else{
    		System.out.println("No string array found");
    	}
    	
    }
}
