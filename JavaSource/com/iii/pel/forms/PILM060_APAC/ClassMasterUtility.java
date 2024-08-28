package com.iii.pel.forms.PILM060_APAC;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.premia.common.utils.CommonUtils;

public class ClassMasterUtility 
{
private String classCode;
public String preBack(){
	// Mapped action bean name for listing bean
	String actionClass = "PILM060_APAC_search";
	// Method which prepares the list
	String actionMethod = "fetch";
	String returnString = "SearchScreen";
	CommonUtils commonUtils = new CommonUtils();
	
	FacesContext context=FacesContext.getCurrentInstance();
	HttpServletRequest request=(HttpServletRequest)context.getExternalContext().getRequest();	
	HttpSession session = request.getSession();
	PM_IL_WDS_CHARGES_SETUP_ACTION actionBean = (PM_IL_WDS_CHARGES_SETUP_ACTION) session.getAttribute("PILM060_APAC_PM_IL_WDS_CHARGES_SETUP_ACTION");		
	actionBean.setUpdate(false);
	//actionBean.getOnloadButton().setDisabled(false);
	
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
