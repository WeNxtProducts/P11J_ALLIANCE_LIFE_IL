package com.iii.premia.common.commonimpl.dms;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iii.pel.login.model.LoginBean;
import com.iii.pel.login.model.LoginManagedBean;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class DMSAction extends CommonAction{
	private DMSDetails DMSDetails;
	private String selectedAppURL;
	
	public DMSAction(){
		DMSHelper helper = new DMSHelper();
		LoginManagedBean managedBean = null;
		LoginBean loginBean = null;
		CommonUtils commonUtils = new CommonUtils();
		DMSAppDetailsBean fromAppDetails = null;
		DMSDetails = new DMSDetails();

		try {
			managedBean = (LoginManagedBean)commonUtils.getMappedBeanFromSession("loginManagedBean");
			loginBean = managedBean.getLoginBean();

			// Set user details
			fromAppDetails = DMSDetails.getFromAppDetails();
			fromAppDetails.setAppCode(Messages.getString("messageProperties_DMS", 
					"DMS$APPLICATION$NAME"));
			fromAppDetails.setUserId(loginBean.getUserName());
			fromAppDetails.setPassword(loginBean.getPassword());
			fromAppDetails.setCompany(loginBean.getCompanyCode());
			fromAppDetails.setBranch(loginBean.getDivisionCode());
			fromAppDetails.setDepartment(loginBean.getDepartmentCode());
			fromAppDetails.setLocale(loginBean.getPageLocale());
			DMSDetails.setFromAppDetails(fromAppDetails);
			
			// Populate DMS related from and to app details
			helper.populateAppDetailListForUser(DMSDetails);
		} catch (Exception e) {
			e.printStackTrace();
			// Setting exception message to session and must be displayed at home page
			CommonUtils.setGlobalVariable("ERROR_MESSAGE", e.getMessage());
		}
	}
	
	public String redirectApplication(){
		String outcome = null;
		String redirectUrl = null;//"http://10.44.8.65:8080/GL10_5/jsf/jsp/home.jsf?USER_NAME=FIN&PASSWORD=FIN&COMPANY=001&BRANCH=HO&DEPARTMENT=ADM&LOCALE=en";
		HttpServletResponse response = null;
		DMSHelper helper = new DMSHelper();
		String applicationCode = getApplicationCode();
		CommonUtils commonUtils = new CommonUtils();
		LoginManagedBean managedBean = null;
		LoginBean loginBean = null;
		HttpServletRequest request = null;
		
		try {
			response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			managedBean = (LoginManagedBean)commonUtils.getMappedBeanFromSession("loginManagedBean");
			loginBean = managedBean.getLoginBean();
			/*redirectUrl = helper.buildURLForApplication(
					getSelectedAppURL(),
					applicationCode,
					loginBean.getUserName(),
					loginBean.getPassword(),
					loginBean.getCompanyCode(),
					loginBean.getDivisionCode(),
					loginBean.getDepartmentCode(),
					loginBean.getPageLocale());*/
			/*redirectUrl = helper.appendFromAppURL(getSelectedAppURL(),
					DMSDetails.getFromAppDetails());*/
			
			redirectUrl = getSelectedAppURL();
			response.sendRedirect(redirectUrl);
			System.out.println("Redirect URL: "+redirectUrl);
		} catch (IOException e) {
			e.printStackTrace();
			request.setAttribute("ERROR_MESSAGE", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("ERROR_MESSAGE", e.getMessage());
		}
		
		return outcome;
	}
	
	public String getApplicationCode(){
		// TODO need to take from global variable
		return "BRK";//CommonUtils.getGlobalVariable("APPLICATION_CODE");
	}

	public String getSelectedAppURL() {
		return selectedAppURL;
	}

	public void setSelectedAppURL(String selectedAppURL) {
		this.selectedAppURL = selectedAppURL;
	}

	public DMSDetails getDMSDetails() {
		return DMSDetails;
	}

	public void setDMSDetails(DMSDetails DMSDetails) {
		this.DMSDetails = DMSDetails;
	}
}
