package com.iii.pel.forms.PT099_A;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.premia.common.utils.CommonUtils;

public class ClassMasterUtility {
	private String classCode;

	public String preBack() {
		// Mapped action bean name for listing bean
		String actionClass = "PT099_A_Search";
		// Method which prepares the list
		String actionMethod = "fetch";
		String returnString = "SearchScreen";
		CommonUtils commonUtils = new CommonUtils();

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		PT_AGENT_TRAN_HDR_ACTION actionBean = (PT_AGENT_TRAN_HDR_ACTION) session
				.getAttribute("PT099_A_PT_AGENT_TRAN_HDR_ACTION");
		// actionBean.setUpdate(false);
		actionBean.getTest().setDisabled(false);

		commonUtils.callRetention(actionClass, actionMethod);
		return returnString;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
}
