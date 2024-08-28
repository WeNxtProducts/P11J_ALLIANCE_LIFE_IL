package com.iii.pel.forms.PILM001;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.premia.common.utils.CommonUtils;


public class ClassMasterUtility 
{
private String classCode;
public String preBack()
{
	FacesContext context=FacesContext.getCurrentInstance();
	HttpServletRequest request=(HttpServletRequest)context.getExternalContext().getRequest();
	HttpSession session=request.getSession();
	String returnString=null;
	PM_IL_CLASS_ACTION pm_il_class_action=(PM_IL_CLASS_ACTION)session.getAttribute("PM_IL_CLASS_ACTION");
	if(!pm_il_class_action.getPM_IL_CLASS_BEAN().isInsertMode())
	{
	String actionClass = "Search_Action";
	String actionMethod = "fetchClassDetails";
	CommonUtils commonUtils = new CommonUtils();
	commonUtils.callRetaintion(actionClass, actionMethod);
	}
	returnString = "searchScreen";
	return returnString;
}
public String getClassCode() {
	return classCode;
}
public void setClassCode(String classCode) {
	this.classCode = classCode;
}
}
