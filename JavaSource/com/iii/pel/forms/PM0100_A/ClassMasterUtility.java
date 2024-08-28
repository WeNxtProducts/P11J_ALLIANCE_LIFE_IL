package com.iii.pel.forms.PM0100_A;

import com.iii.premia.common.utils.CommonUtils;

public class ClassMasterUtility 
{
private String classCode;
public String preBack(){
	// Mapped action bean name for listing bean
	String actionClass = "PM0100_A_Search";
	// Method which prepares the list
	String actionMethod = "fetchClassDetails";
	String returnString = "SearchScreen";
	CommonUtils commonUtils = new CommonUtils();
	
	commonUtils.callRetaintion(actionClass, actionMethod);
	return returnString;
}
public String getClassCode() {
	return classCode;
}
public void setClassCode(String classCode) {
	this.classCode = classCode;
}
}
