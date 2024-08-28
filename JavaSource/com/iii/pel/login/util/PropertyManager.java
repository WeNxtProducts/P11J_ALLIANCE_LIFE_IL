package com.iii.pel.login.util;

import java.util.ResourceBundle;

public class PropertyManager {
	
	private static ResourceBundle defaultResourceBundle;
	
	static{
		defaultResourceBundle = ResourceBundle.getBundle("login");
	}
	
	private PropertyManager(){
	}
	
	public static String getValue(String key) {
		return (defaultResourceBundle == null ? "" : defaultResourceBundle
				.getString(key));
	}

}
