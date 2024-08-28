package com.iii.pel.login.model;

import java.io.Serializable;
import java.util.List;

import com.iii.apps.persistence.BaseValueBean;
import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

/*added by R. Raja on 14-12-2016 for RM018T - FSD_IL_ZB Life_030_PREMIA Security*/

@Table(name="MENU_USER_LOG")

/*end*/
public class LoginBean extends BaseValueBean implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	
	/*added by R. Raja on 14-12-2016 for RM018T - FSD_IL_ZB Life_030_PREMIA Security*/
	
	 @Column(name="MUL_USER_ID")
	private String userName;
	 
	 @Column(name="MUL_COMP_CODE")
		private String companyCode;
	 
	 @Column(name="MUL_DIVN_CODE")
		private String divisionCode;
	 
	 @Column(name="MUL_DEPT_CODE")
		private String departmentCode;
	 
	 /*end*/
	private String password;
	private String companyCodeDesc;
	private String divisionCodeDesc;
	private String departmentCodeDesc;
	private String userGroupId;
	private String userAskPasswordFlag;
	private String userChangePassword;
	private String userDisableFlag;
	private int userLoginCount;
	private String userCompCode;
	private String userAdministrator;
	private String userVPSFlag;
	private String userPasswordExpiry;
	private String userExpiryDate;
	private String userFirstLogin;
	private String userFreezeFlag;
	private String userValidUpto;
	private String userLastLoginDate;
	private List<String> companyCodeList;
	private List<String> divisionCodeList;
	private List<String> departmentCodeList;
	private String pageLocale;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public List<String> getCompanyCodeList() {
		return companyCodeList;
	}
	public void setCompanyCodeList(List<String> companyCodeList) {
		this.companyCodeList = companyCodeList;
	}
	public String getDivisionCode() {
		return divisionCode;
	}
	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}
	public List<String> getDivisionCodeList() {
		return divisionCodeList;
	}
	public void setDivisionCodeList(List<String> divisionCodeList) {
		this.divisionCodeList = divisionCodeList;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public List<String> getDepartmentCodeList() {
		return departmentCodeList;
	}
	public void setDepartmentCodeList(List<String> departmentCodeList) {
		this.departmentCodeList = departmentCodeList;
	}
	public String getUserGroupId() {
		return userGroupId;
	}
	public void setUserGroupId(String userGroupId) {
		this.userGroupId = userGroupId;
	}
	public String getUserAskPasswordFlag() {
		return userAskPasswordFlag;
	}
	public void setUserAskPasswordFlag(String userAskPasswordFlag) {
		this.userAskPasswordFlag = userAskPasswordFlag;
	}
	public String getUserChangePassword() {
		return userChangePassword;
	}
	public void setUserChangePassword(String userChangePassword) {
		this.userChangePassword = userChangePassword;
	}
	public String getUserDisableFlag() {
		return userDisableFlag;
	}
	public void setUserDisableFlag(String userDisableFlag) {
		this.userDisableFlag = userDisableFlag;
	}
	
	public int getUserLoginCount() {
		return userLoginCount;
	}
	public void setUserLoginCount(int userLoginCount) {
		this.userLoginCount = userLoginCount;
	}
	public String getUserCompCode() {
		return userCompCode;
	}
	public void setUserCompCode(String userCompCode) {
		this.userCompCode = userCompCode;
	}
	public String getUserAdministrator() {
		return userAdministrator;
	}
	public void setUserAdministrator(String userAdministrator) {
		this.userAdministrator = userAdministrator;
	}
	public String getUserVPSFlag() {
		return userVPSFlag;
	}
	public void setUserVPSFlag(String userVPSFlag) {
		this.userVPSFlag = userVPSFlag;
	}
	public String getUserPasswordExpiry() {
		return userPasswordExpiry;
	}
	public void setUserPasswordExpiry(String userPasswordExpiry) {
		this.userPasswordExpiry = userPasswordExpiry;
	}
	public String getUserExpiryDate() {
		return userExpiryDate;
	}
	public void setUserExpiryDate(String userExpiryDate) {
		this.userExpiryDate = userExpiryDate;
	}
	public String getUserFirstLogin() {
		return userFirstLogin;
	}
	public void setUserFirstLogin(String userFirstLogin) {
		this.userFirstLogin = userFirstLogin;
	}
	public String getUserFreezeFlag() {
		return userFreezeFlag;
	}
	public void setUserFreezeFlag(String userFreezeFlag) {
		this.userFreezeFlag = userFreezeFlag;
	}
	public String getUserValidUpto() {
		return userValidUpto;
	}
	public void setUserValidUpto(String userValidUpto) {
		this.userValidUpto = userValidUpto;
	}
	public String getUserLastLoginDate() {
		return userLastLoginDate;
	}
	public void setUserLastLoginDate(String userLastLoginDate) {
		this.userLastLoginDate = userLastLoginDate;
	}
	public String getCompanyCodeDesc() {
		return companyCodeDesc;
	}
	public void setCompanyCodeDesc(String companyCodeDesc) {
		this.companyCodeDesc = companyCodeDesc;
	}
	public String getDivisionCodeDesc() {
		return divisionCodeDesc;
	}
	public void setDivisionCodeDesc(String divisionCodeDesc) {
		this.divisionCodeDesc = divisionCodeDesc;
	}
	public String getDepartmentCodeDesc() {
		return departmentCodeDesc;
	}
	public void setDepartmentCodeDesc(String departmentCodeDesc) {
		this.departmentCodeDesc = departmentCodeDesc;
	}
	public String getPageLocale() {
		return pageLocale;
	}
	public void setPageLocale(String pageLocale) {
		this.pageLocale = pageLocale;
	}
	
	/*added by R. Raja on 14-12-2016 for RM018T - FSD_IL_ZB Life_030_PREMIA Security*/
	 
	 @Column(name="MUL_IP_ADD")
		private String MUL_IP_ADD;
	 
	 @Column(name="MUL_SESSION_ID")
		private String MUL_SESSION_ID;
	
	public String getMUL_IP_ADD() {
		return MUL_IP_ADD;
	}
	public void setMUL_IP_ADD(String mUL_IP_ADD) {
		MUL_IP_ADD = mUL_IP_ADD;
	}
	public String getMUL_SESSION_ID() {
		return MUL_SESSION_ID;
	}
	public void setMUL_SESSION_ID(String mUL_SESSION_ID) {
		MUL_SESSION_ID = mUL_SESSION_ID;
	}
	 
	/*end*/ 


	/*Added by Janani on 18.12.2017 for CSM*/
	
	 @Column(name="MUL_REQ_SESSION_ID")
		private String MUL_REQ_SESSION_ID;
	
	
	private Object sessionVariable;
	
	public String getMUL_REQ_SESSION_ID() {
		return MUL_REQ_SESSION_ID;
	}
	public void setMUL_REQ_SESSION_ID(String mUL_REQ_SESSION_ID) {
		MUL_REQ_SESSION_ID = mUL_REQ_SESSION_ID;
	}
	public Object getSessionVariable() {
		return sessionVariable;
	}
	public void setSessionVariable(Object sessionVariable) {
		this.sessionVariable = sessionVariable;
	}
		
	/*End*/
	
}


