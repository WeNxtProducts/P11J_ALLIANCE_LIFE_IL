package com.iii.pel.login.model;

import java.io.File;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ajax4jsf.component.html.HtmlAjaxRepeat;

import com.iii.premia.common.utils.CommonUtils;

public class VcardAction {

	/*Added by Ram on 14/03/2017 for default details fetch process of company code,division code*/
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle("Application");
	/*End*/
	
	private ArrayList<VcardBean> vcardList = new ArrayList<VcardBean>();
	
	private HtmlAjaxRepeat vcardTable;
	
	private static final String uDelimiter = "#PUD#";
	private static final String dDelimiter = "#PCD#";
	private static final int MAX_NUMBER_OF_COOKIES_ALLOWED = 3;
	
    
	public VcardAction() {
		getCookies();
		System.out.println("Number cookies: "+vcardList.size());
	}

	public void getCookies() {
		String cookieName = null;
		Cookie[] cookie = ((HttpServletRequest) FacesContext
						.getCurrentInstance().getExternalContext().getRequest()).getCookies();
		if (cookie != null && cookie.length > 0) {
			for (int i = 0; i < cookie.length; i++) {
				cookieName = cookie[i].getName();
				if("PREMIA_COOKIE".equals(cookieName)) {
					String value= cookie[i].getValue();
					// to create Vcard....
					createVCard(value);
				}
			}
		}
	}

	public void premiaCookie(){
		String cookieName = null;
		String cookieValue = null;
		String oldCookieValue=null;
		String[] temp = null;
		LoginManagedBean loginManagedBean = null;
		loginManagedBean = (LoginManagedBean) FacesContext.getCurrentInstance().getExternalContext()
							.getSessionMap().get("loginManagedBean");
		Cookie[] cookie = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getCookies();
		Cookie premiaCookie=null;
		if(cookie != null && cookie.length > 0){
			for(int i =0 ; i< cookie.length ; i++ ){
				cookieName = cookie[i].getName();
				if("PREMIA_COOKIE".equals(cookieName)) {
					//to get old cookie value....
					oldCookieValue= cookie[i].getValue();
				}
				cookieValue = cookie[i].getValue();
				temp = cookieValue.split(dDelimiter);
				for(int j =0; j < temp.length ; j++){
					System.out.println("values in Cookies -->" + temp[j]);
				}
			}
			
		}
		String userCredentials = loginManagedBean.getLoginBean().getUserName()+ dDelimiter +loginManagedBean.getLoginBean().getCompanyCode()+ dDelimiter +
								 loginManagedBean.getLoginBean().getDepartmentCode()+ dDelimiter +loginManagedBean.getLoginBean().getDivisionCode()+ dDelimiter +
								 loginManagedBean.getLoginBean().getPageLocale();
		
		//check the cookie for current user....
		premiaCookie = new Cookie("PREMIA_COOKIE", manageCookies(oldCookieValue, userCredentials));
		premiaCookie.setMaxAge(9999999);
		
		((HttpServletResponse) FacesContext.getCurrentInstance()
				.getExternalContext().getResponse()).addCookie(premiaCookie);
		
	}

	public void userVcardAction(ActionEvent event) {
		//String outcome="";
		LoginManagedBean loginManagedBean = null;
		loginManagedBean = (LoginManagedBean) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("loginManagedBean");
		loginManagedBean.getLoginBean().setPassword(null);
		loginManagedBean.getPassword().resetValue();
		VcardBean vcardBean = (VcardBean) vcardTable.getRowData();
		loginManagedBean.getLoginBean().setUserName(vcardBean.getUserName());
		loginManagedBean.getLoginBean().setCompanyCode(
				vcardBean.getCompanyCode());
		loginManagedBean.getLoginBean().setDepartmentCode(
				vcardBean.getDepartment());
		loginManagedBean.getLoginBean().setDivisionCode(
				vcardBean.getBranchCode());
		loginManagedBean.getLoginBean().setPageLocale(vcardBean.getLanguage());
		loginManagedBean.getUserName().resetValue();
		loginManagedBean.getCompanyCodeBox().resetValue();
		loginManagedBean.getDepartmentCodeBox().resetValue();
		loginManagedBean.getDivisionCodeBox().resetValue();
		loginManagedBean.getLanguage().resetValue();
		
		
		/*Added by Janani on 16.3.2016 for disabling divn & dept code*/
		
		
		if(loginManagedBean.getDivisionCode()!= null)
			{
			
			System.out.println("inside vcard action");
			System.out.println("divncode !=null");
			/*change disabeled = false by raja on 08-02-2017*/ 
			loginManagedBean.getDivisionCodeBox().setDisabled(false);
		}else
		{
			System.out.println("divncode =null");
			loginManagedBean.getDivisionCodeBox().setDisabled(false);
		}
		
		
		if(loginManagedBean.getDepartmentCode()!= null)
		{
			System.out.println("deptcode !=null");
			/*change disabeled = false by raja on 08-02-2017*/ 
			loginManagedBean.getDepartmentCodeBox().setDisabled(false);
		}else
		{
			System.out.println("deptcode =null");
			loginManagedBean.getDepartmentCodeBox().setDisabled(false);
		}
		
		
		/*end*/
		
		/*Added by Ram on 14/03/2017 for default details fetch process of company code,division code*/
		System.out.println("resourceBundle.getString(isDefaultLogin)        "+resourceBundle.getString("isDefaultLogin"));
		if(resourceBundle.getString("isDefaultLogin") != null && resourceBundle.getString("isDefaultLogin").equalsIgnoreCase("Y"))
		 {
			
			loginManagedBean.getDepartmentCodeBox().setDisabled(true);
			loginManagedBean.getDivisionCodeBox().setDisabled(true);
			loginManagedBean.getCompanyCodeBox().setDisabled(true);
		 }
		else
		{
			loginManagedBean.getDepartmentCodeBox().setDisabled(false);
			loginManagedBean.getDivisionCodeBox().setDisabled(false);
			loginManagedBean.getCompanyCodeBox().setDisabled(false);
		}
		 /*End*/
		//return outcome;
		

		loginManagedBean.resetpasswordflag=false;
		loginManagedBean.reset_password_validation();
		
	}

	public ArrayList<VcardBean> getVcardList() {
		return vcardList;
	}

	public void setVcardList(ArrayList<VcardBean> vcardList) {
		this.vcardList = vcardList;
	}

	// validate  the cookie is avilable for current user .....
	public String manageCookies(String oldCookies, String newCredentials) {
        String[] cookies = null;
        StringBuffer newCookies = new StringBuffer();
        int matchingIndex = -1;
        
        if(oldCookies != null){
        	cookies = oldCookies.split(uDelimiter);
        	for(int index=0; index<cookies.length; index++) {
        		if(newCredentials.equals(cookies[index])){
        			matchingIndex = index;
        			break;
        		}
        	}
        	
        	// Adding cookie at beginning if not exist, else pulling the current credential cookie at beginning
        	// Maintaining only MAX_NUMBER_OF_COOKIES_ALLOWED cookies
        	if(matchingIndex == -1){
        		newCookies.append(newCredentials+uDelimiter);
        	}else{
        		newCookies.append(cookies[matchingIndex]+uDelimiter);
        	}
        	for(int index=0, cookieCount=1; index<cookies.length && cookieCount<MAX_NUMBER_OF_COOKIES_ALLOWED; index++) {
        		if(matchingIndex != index ){
        			cookieCount++;
        			newCookies.append(cookies[index]+uDelimiter);
        		}
        	}
        }else{
    		newCookies.append(newCredentials+uDelimiter);
        }
		
		return newCookies.toString();
	}
	
	
	
	// create the vcard list available for the users.....
	public void createVCard(String cookieData) {
        String[] allusers = null;
		ArrayList<VcardBean> list = new ArrayList<VcardBean>();
		String[] tokens = null;
		VcardBean bean = null;
		
		String login_userid = null;
try{
		
			
			login_userid = CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
		if(cookieData != null){
			allusers = cookieData.split(uDelimiter);
			if(allusers != null){
				for(int index=0; index<allusers.length; index++) {
					tokens = allusers[index].split(dDelimiter);
					if(tokens.length > 4) {
						bean = new VcardBean();
						bean.setUserName(tokens[0]);
						bean.setCompanyCode(tokens[1]);
						bean.setDepartment(tokens[2]);
						bean.setBranchCode(tokens[3]);
						bean.setLanguage(tokens[4]);
						
String uploadPath = CommonUtils.getLoginImagePath();
						
						String img_name = tokens[0]+".jpg";
					
						
						
						System.out.println("img_name              :"+img_name+"      getUserName           "+bean.getUserName());
						
						if(img_name != null)
						{
							uploadPath = uploadPath+File.separator+img_name;
						}
						System.out.println("uploadPath      "+uploadPath);
						File uploadServerPath = new File(uploadPath);
						/*if(uploadServerPath.exists() && (img_name != null && tokens[0] == login_userid))*/
						if(uploadServerPath.exists())
						{
						
						System.out.println("uploadPath IN LOGIN            "+uploadPath);
						
						bean.setImagePath("../../../userprofile/"+tokens[0]+".jpg");
						
						System.out.println("getImagePath           "+bean.getImagePath()+"     "+tokens[0]+"       "+login_userid);
						 
						}
						else
						{
							System.out.println("uploadPath in else part ");
							
							
							bean.setImagePath("./../../resources/images/login/usericon.gif");
							
							System.out.println("getImagePath in else          "+bean.getImagePath()+"     "+tokens[0]+"       "+login_userid);
							 
						}
						
						list.add(bean);
					}
				}
			}
		}

		setVcardList(list);
		
}
catch(Exception e)
{
	e.printStackTrace();
}
	}

	public HtmlAjaxRepeat getVcardTable() {
		return vcardTable;
	}

	public void setVcardTable(HtmlAjaxRepeat vcardTable) {
		this.vcardTable = vcardTable;
	}
}
