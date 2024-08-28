package com.iii.pel.devutils;

import java.lang.reflect.Field;

import com.iii.apps.persistence.Column;

public class SettersGenerator {
	/**
	 * @author 53337 
	 *  This Class, generate Setters based on @Columns specified in respected bean.
	 *  
	 */
	public static void main(String[] args) {
		// 1. Change Bean Object, which bean you want to Prepare setters .  
		//TODO needs to be done properly
		//com.iii.gi.forms.PGIM0018.PGIM_EST_CHRG_DTL obj = new com.iii.gi.forms.PGIM0018.PGIM_EST_CHRG_DTL();
		Object obj = null;
		// 2. Assign valueBeanName based on your Bean name .   
		String valueBeanName = "valueBean";
		// 3. Assign resultSetName .   
		String resultSetName = "resultSet";
		Class beanType = obj.getClass();
		try {
			for (Field fields : beanType.getDeclaredFields()) {
				fields.setAccessible(true);
				if (fields.isAnnotationPresent(Column.class)) {
					
					String columnName = fields.getAnnotation(Column.class).name();
					String str = fields.getType().getSimpleName();
					
					// checking if String contains any int type variables, replace as Int and prepare String.
					str = str.replace("int", "Int");

					System.out.println(valueBeanName + ".set" + columnName + "("
							+ resultSetName + ".get" + str + "(\"" + columnName
							+ "\"));");
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
}