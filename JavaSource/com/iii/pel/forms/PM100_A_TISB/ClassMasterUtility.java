package com.iii.pel.forms.PM100_A_TISB;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.premia.common.utils.CommonUtils;

public class ClassMasterUtility 
{
private String classCode;
public String preBack(){
	// Mapped action bean name for listing bean
	String actionClass = "PM100_A_TISB_search";
	// Method which prepares the list
	String actionMethod = "fetch";
	String returnString = "SearchScreen";
	CommonUtils commonUtils = new CommonUtils();
	
	FacesContext context=FacesContext.getCurrentInstance();
	HttpServletRequest request=(HttpServletRequest)context.getExternalContext().getRequest();	
	HttpSession session = request.getSession();
	PM_AGENT_PF_SETUP_ACTION actionBean = (PM_AGENT_PF_SETUP_ACTION) session.getAttribute("PM_AGENT_PF_SETUP_ACTION");		
	actionBean.setUpdate(false);
	//actionBean.getDum().setDisabled(false);
	
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
