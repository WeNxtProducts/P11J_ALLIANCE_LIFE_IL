package com.iii.premia.common.commonimpl.sso;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iii.pel.login.model.LoginBean;
import com.iii.pel.login.model.LoginManagedBean;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class SSOAction extends CommonAction{
	private SSODetails ssoDetails;
	private String selectedAppURL;
	
	public SSOAction(){
		SSOHelper helper = new SSOHelper();
		LoginManagedBean managedBean = null;
		LoginBean loginBean = null;
		CommonUtils commonUtils = new CommonUtils();
		SSOAppDetailsBean fromAppDetails = null;
		ssoDetails = new SSODetails();

		try {
			managedBean = (LoginManagedBean)commonUtils.getMappedBeanFromSession("loginManagedBean");
			loginBean = managedBean.getLoginBean();

			// Set user details
			fromAppDetails = ssoDetails.getFromAppDetails();
			fromAppDetails.setAppCode(Messages.getString("messageProperties_SSO", 
					"SSO$APPLICATION$NAME"));
			fromAppDetails.setUserId(loginBean.getUserName());
			fromAppDetails.setPassword(loginBean.getPassword());
			fromAppDetails.setCompany(loginBean.getCompanyCode());
			fromAppDetails.setBranch(loginBean.getDivisionCode());
			fromAppDetails.setDepartment(loginBean.getDepartmentCode());
			fromAppDetails.setLocale(loginBean.getPageLocale());
			ssoDetails.setFromAppDetails(fromAppDetails);
			
			// Populate SSO related from and to app details
			helper.populateAppDetailListForUser(ssoDetails);
		} catch (Exception e) {
			e.printStackTrace();
			// Setting exception message to session and must be displayed at home page
			CommonUtils.setGlobalVariable("ERROR_MESSAGE", e.getMessage());
		}
	}
	
	public String illuslatorAction(){
		String redirectUrl = "http://127.0.0.1:8181/";
		HttpServletResponse response = null;
		
		try {
			response = (HttpServletResponse) FacesContext.getCurrentInstance()
					.getExternalContext().getResponse();
			response.sendRedirect(redirectUrl);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String redirectApplication(){
		String outcome = null;
		String redirectUrl = null;//"http://10.44.8.65:8080/GL10_5/jsf/jsp/home.jsf?USER_NAME=FIN&PASSWORD=FIN&COMPANY=001&BRANCH=HO&DEPARTMENT=ADM&LOCALE=en";
		HttpServletResponse response = null;
		SSOHelper helper = new SSOHelper();
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
					ssoDetails.getFromAppDetails());*/
			
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

	public SSODetails getSsoDetails() {
		return ssoDetails;
	}

	public void setSsoDetails(SSODetails ssoDetails) {
		this.ssoDetails = ssoDetails;
	}
	
	/*Added by Ram on 08/11/2016 for FALCONLIFE-1347884*/
	public String changePassword(){
		System.out.println("Enter into changePassword");
		return "PM290_RESET_EXPIRED_PASSWORD";
	}
	/*End*/
}
