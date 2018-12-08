package com.epam.kira_demidova.java.lesson3.task1;

import java.util.ResourceBundle;

public class ResourseBundle {
	private ResourceBundle bundle;
	
	public ResourseBundle(){
		bundle = ResourceBundle.getBundle("com.epam.kira_demidova.java.lesson3.task1.property.prop");
	}
	public String getValue(String key){
		return bundle.getString(key);
	}
}
