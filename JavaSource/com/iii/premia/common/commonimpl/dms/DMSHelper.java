package com.iii.premia.common.commonimpl.dms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.StringTokenizer;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.login.model.LoginBean;
import com.iii.pel.login.model.LoginManagedBean;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class DMSHelper {

	public String buildURLForApplicationCode(String applicationCode, LoginBean loginBean, 
			HttpServletRequest request) throws Exception {
		CRUDHandler handler = new CRUDHandler();
		String applicationURL = null;
		Connection connection = null;
		ResultSet resultSet = null;
		String FETCH_APP_URL = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_CODE=?";
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(FETCH_APP_URL, connection, 
					new Object[]{applicationCode});
			if(resultSet.next()){
				applicationURL = resultSet.getString("PS_CODE_DESC");
				applicationURL = applicationURL 
					+ "?" 
					//+ DMSConstant.DMS_PARAMS 
					//+ "="
					// Hard coded needs to remove
					//"http://10.44.8.65:8080/PremiaBroker/jsf/login/home.xhtml?"+DMSConstant.DMS_PARAMS+"="
					+ prepareParameters(applicationCode, loginBean);
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}

		return applicationURL;
	}
	
	private String prepareParameters(String applicationCode, LoginBean loginBean){
		StringBuilder stringBuilder = new StringBuilder();
		String parameterString = null;
		
		try{
			stringBuilder.append(DMSConstant.USER_NAME);
			stringBuilder.append(DMSConstant.EQUALS_OPERATOR);
			stringBuilder.append(loginBean.getUserName());
			stringBuilder.append(DMSConstant.ENCODED_PARAMETER_SEPARATOR);
			stringBuilder.append(DMSConstant.PASSWORD);
			stringBuilder.append(DMSConstant.EQUALS_OPERATOR);
			stringBuilder.append(loginBean.getPassword());
			stringBuilder.append(DMSConstant.ENCODED_PARAMETER_SEPARATOR);
			stringBuilder.append(DMSConstant.COMPANY);
			stringBuilder.append(DMSConstant.EQUALS_OPERATOR);
			stringBuilder.append(loginBean.getCompanyCode());
			stringBuilder.append(DMSConstant.ENCODED_PARAMETER_SEPARATOR);
			stringBuilder.append(DMSConstant.BRANCH);
			stringBuilder.append(DMSConstant.EQUALS_OPERATOR);
			stringBuilder.append(loginBean.getDivisionCode());
			stringBuilder.append(DMSConstant.ENCODED_PARAMETER_SEPARATOR);
			stringBuilder.append(DMSConstant.DEPARTMENT);
			stringBuilder.append(DMSConstant.EQUALS_OPERATOR);
			stringBuilder.append(loginBean.getDepartmentCode());
			stringBuilder.append(DMSConstant.ENCODED_PARAMETER_SEPARATOR);
			stringBuilder.append(DMSConstant.LOCALE);
			stringBuilder.append(DMSConstant.EQUALS_OPERATOR);
			stringBuilder.append(loginBean.getPageLocale());
			
			// Encode parameter string
			//parameterString = DMSEncoder(stringBuilder.toString());
			
		} /*catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/ finally{
			
		}
		
		//return parameterString;
		return stringBuilder.toString();
	}
	
	public String DMSEncoder(String parameters){
		StringBuilder builder = new StringBuilder();
		char bit = '#';
		
		if(parameters != null && parameters.length()>0){
			for(int index=0, size=parameters.length(); index<size; index++){
				bit = parameters.charAt(index);
				if(index%2 == 0){
					bit+=1;
				}else{
					bit-=1;
				}
				
				builder.append(bit);
			}
		}
		
		// [ Added for Hex check
		return builder.toString().replace("%", "$$$").replace("#", "(((");
		// Added for Hex check ]
	}
	
	public String DMSDecoder(String parameters){
		StringBuilder builder = new StringBuilder();
		char bit = '#';
		
		if(parameters != null && parameters.length()>0){
			// [ Added for Hex check
			parameters = parameters.replace("(((", "#").replace("$$$", "%");
			// Added for Hex check ]
			
			for(int index=0, size=parameters.length(); index<size; index++){
				bit = parameters.charAt(index);
				if(index%2 == 0){
					bit-=1;
				}else{
					bit+=1;
				}
				
				builder.append(bit);
			}
			
		}
		
		return builder.toString();
	}
	
	public static void main(String[] args) {
		String name = "USER_NAME=MARSH&PASSWORD=MARSH&COMPANY=001&BRANCH=001&DEPARTMENT=005&LOCALE=en";
		DMSHelper helper = new DMSHelper();
		String encoded = helper.DMSEncoder(name);
		System.out.println("Actual  String       : "+name);
		System.out.println("Encoded String       : "+encoded);
		encoded = helper.DMSEncoder(encoded);
		System.out.println("Double Encoded String: "+encoded);
		encoded = helper.DMSDecoder(encoded);
		System.out.println("Decoded String       : "+encoded);
		encoded = helper.DMSDecoder(encoded);
		System.out.println("Double Decoded String: "+encoded);
	}
	
	public void processRequest(HttpServletRequest request) throws Exception{
		String parameters = request.getParameter(DMSConstant.DMS_PARAMS);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		StringTokenizer tokenizer = null;
		LoginManagedBean loginManagedBean = new LoginManagedBean();
		LoginBean loginBean = loginManagedBean.getLoginBean();
		String token = null;
		String key = null;
		String value = null;
		int equalOperatorIndex = -1;
		
		//request.getSession().setAttribute("loginManagedBean", loginManagedBean);
		sessionMap.put("loginManagedBean", loginManagedBean);
		/*parameters = DMSDecoder(parameters);
		tokenizer = new StringTokenizer(parameters, DMSConstant.ENCODED_PARAMETER_SEPARATOR);
		while(tokenizer.hasMoreTokens()){
			token = tokenizer.nextToken();
			equalOperatorIndex = token.indexOf(DMSConstant.EQUALS_OPERATOR);
			key = token.substring(0, equalOperatorIndex);
			value = token.substring(equalOperatorIndex+1);
			if(DMSConstant.USER_NAME.equals(key)){
				loginBean.setUserName(value);
			}else if(DMSConstant.PASSWORD.equals(key)){
				loginBean.setPassword(value);
			}else if(DMSConstant.COMPANY.equals(key)){
				loginBean.setCompanyCode(value);
			}else if(DMSConstant.BRANCH.equals(key)){
				loginBean.setDivisionCode(value);
			}else if(DMSConstant.DEPARTMENT.equals(key)){
				loginBean.setDepartmentCode(value);
			}else if(DMSConstant.LOCALE.equals(key)){
				loginBean.setPageLocale(value);
			}
		}*/
		loginBean.setPageLocale("en");
		loginBean.setUserName("PREMIADMIN");
		loginBean.setPassword("P11JLIFE");
		loginBean.setCompanyCode("001");
		loginBean.setDivisionCode("YHW04");
		loginBean.setDepartmentCode("HIT01");
		// Perform login action
		sessionMap.put("pageLocale", loginBean.getPageLocale());
		loginManagedBean.loginAction();
		///perform execute action
		PILT002_APAC_COMPOSITE_ACTION comPositeAction = new PILT002_APAC_COMPOSITE_ACTION();
		try {
			comPositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN().setPOL_SYS_ID(getPolSysId());
			comPositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN().setROWID(getRowId(getPolSysId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		comPositeAction.getPT_IL_POLICY_ACTION_BEAN().setFormFlag(true);
		comPositeAction.getPT_IL_POLICY_ACTION_BEAN().setBlockFlag(true);
		HttpSession session = request.getSession();
		session.setAttribute("PILT002_APAC_COMPOSITE_ACTION", comPositeAction);
		comPositeAction.getPT_IL_POLICY_ACTION_BEAN().onLoad(null);
	}
	
	private Long getPolSysId() throws Exception{
		String query = "SELECT PWTH_TRAN_SYS_ID FROM P_WF_DUMMY";
		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		Long polSysId = null;
		
		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(query, con);
			if (rs.next()) {
				polSysId = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return polSysId;
	}
	
	private String getRowId(Long polSysId) throws Exception{
		String query = "SELECT ROWID FROM PT_IL_POLICY WHERE POL_SYS_ID = ?";
		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		String rowId = null;
		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(query, con,new Object[]{polSysId});
			if (rs.next()) {
				rowId = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return rowId;
	}
	
	public boolean processRequestParameters(HttpServletRequest request, LoginManagedBean loginManagedBean){
		/*LoginBean loginBean = null;
		boolean isAutoLoginRequested = false;
		
		if(request.getParameter(DMSConstant.USER_NAME) != null){
			if(loginManagedBean == null){
				loginManagedBean = new LoginManagedBean();
				request.getSession().setAttribute("loginManagedBean", loginManagedBean);
			}
			
			loginBean = loginManagedBean.getLoginBean();
			loginBean.setUserName(request.getParameter(DMSConstant.USER_NAME));
			loginBean.setPassword(request.getParameter(DMSConstant.PASSWORD));
			loginBean.setCompanyCode(request.getParameter(DMSConstant.COMPANY));
			loginBean.setDivisionCode(request.getParameter(DMSConstant.BRANCH));
			loginBean.setDepartmentCode(request.getParameter(DMSConstant.DEPARTMENT));
			loginBean.setPageLocale(request.getParameter(DMSConstant.LOCALE));
			System.out.println("--------8<------------ Broker Session: "+request.getSession().getId());
			
			isAutoLoginRequested = true;
		}
		
		return isAutoLoginRequested;*/
		
		boolean isAutoLoginRequested = false;
		String DMSParams = null;
		String fromAppURL = null;
		
		DMSParams = request.getParameter(DMSConstant.DMS_PARAMS);
		fromAppURL = request.getParameter(DMSConstant.FROM_APP_URL);
		// Set the error message from url
		request.setAttribute(DMSConstant.ERROR_MESSAGE_KEY, request.getParameter(DMSConstant.ERROR_MESSAGE_KEY));
		if(DMSParams != null){
			//if(loginManagedBean == null){
				loginManagedBean = new LoginManagedBean();
				request.getSession().setAttribute("loginManagedBean", loginManagedBean);
			//}
			
			populateLoginBeanFromEncryptedURL(DMSParams, fromAppURL, loginManagedBean.getLoginBean());
			isAutoLoginRequested = true;
		}
		
		return isAutoLoginRequested;
	}
	private void populateLoginBeanFromEncryptedURL(String DMSParams, String fromAppURL, LoginBean loginBean){		
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		StringTokenizer tokenizer = null;
		String token = null;
		String key = null;
		String value = null;
		int equalOperatorIndex = -1;

		DMSParams = DMSDecoder(DMSParams);
		tokenizer = new StringTokenizer(DMSParams, DMSConstant.ENCODED_PARAMETER_SEPARATOR);
		while(tokenizer.hasMoreTokens()){
			token = tokenizer.nextToken();
			equalOperatorIndex = token.indexOf(DMSConstant.EQUALS_OPERATOR);
			key = token.substring(0, equalOperatorIndex);
			value = token.substring(equalOperatorIndex+1);
			if(DMSConstant.USER_NAME.equals(key)){
				loginBean.setUserName(value);
			}else if(DMSConstant.PASSWORD.equals(key)){
				loginBean.setPassword(value);
			}else if(DMSConstant.COMPANY.equals(key)){
				loginBean.setCompanyCode(value);
			}else if(DMSConstant.BRANCH.equals(key)){
				loginBean.setDivisionCode(value);
			}else if(DMSConstant.DEPARTMENT.equals(key)){
				loginBean.setDepartmentCode(value);
			}else if(DMSConstant.LOCALE.equals(key)){
				loginBean.setPageLocale(value);
			}
		}
		
		// Decode from app url, parameters of which is already in a state to redirect (encoded) after decoding
		fromAppURL = DMSDecoder(fromAppURL);
		sessionMap.put(DMSConstant.FROM_APP_URL, fromAppURL);

		// set locale
		sessionMap.put("pageLocale", loginBean.getPageLocale());

	}
	
	public void populateAppDetailListForUser(DMSDetails DMSDetails) throws Exception{
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		//String FETCH_APP_DETAILS = "SELECT DISTINCT PAD.* FROM PM_APPLICATION_DTLS PAD, PM_LOGIN_SWITCH PLS WHERE PAD.PAD_APPL_CODE=PLS.PLS_TO_APPLICATION AND PLS.PLS_FM_USER_ID=?";
		String FETCH_TO_APP_DETAILS = "SELECT DISTINCT PAD.*,PLS.* " 
			+ "FROM PM_APPLICATION_DTLS PAD, PM_LOGIN_SWITCH PLS " 
			+ "WHERE PAD.PAD_APPL_CODE=PLS.PLS_TO_APPLICATION " 
			+ "AND PLS.PLS_FM_USER_ID=? "
			+ "AND PLS.PLS_FM_APPLICATION=? "
			+ "AND PLS.PLS_FM_COMPANY=? "
			+ "AND PLS.PLS_FM_DIVISION=? "
			+ "AND PLS.PLS_FM_DEPARTMENT=? ";
		String FETCH_FROM_APP_DETAILS = "SELECT * FROM PM_APPLICATION_DTLS WHERE PAD_APPL_CODE=?"; 
		DMSAppDetailsBean fromAppDetails = DMSDetails.getFromAppDetails();
		DMSAppDetailsBean toAppDetailBean = null;
		
		try {
			connection = CommonUtils.getConnection();
			
			resultSet2 = handler.executeSelectStatement(FETCH_FROM_APP_DETAILS, 
					connection, new Object[]{fromAppDetails.getAppCode()});
			if(resultSet2.next()){
				fromAppDetails.setAppDescription(resultSet2.getString("PAD_APPL_DESC"));
				fromAppDetails.setAppHomeURL(resultSet2.getString("PAD_APPL_URL"));
			}

			resultSet1 = handler.executeSelectStatement(FETCH_TO_APP_DETAILS, connection, 
					new Object[]{fromAppDetails.getUserId(),
						fromAppDetails.getAppCode(),
						fromAppDetails.getCompany(),
						fromAppDetails.getBranch(),
						fromAppDetails.getDepartment()});
			
			// Clearing to app details
			DMSDetails.getToAppDetailsList().clear();
			// Preparing to app details
			while(resultSet1.next()){
				toAppDetailBean = new DMSAppDetailsBean();
				toAppDetailBean.setAppCode(resultSet1.getString("PAD_APPL_CODE"));
				toAppDetailBean.setAppDescription(resultSet1.getString("PAD_APPL_DESC"));
				toAppDetailBean.setAppHomeURL(resultSet1.getString("PAD_APPL_URL"));
				// User details
				toAppDetailBean.setUserId(resultSet1.getString("PLS_TO_USER_ID"));
				toAppDetailBean.setPassword(DMSCryptograph.decode(resultSet1.getString("PLS_TO_USER_PWD")).trim());
				toAppDetailBean.setCompany(resultSet1.getString("PLS_TO_COMPANY"));
				toAppDetailBean.setBranch(resultSet1.getString("PLS_TO_DIVISION"));
				toAppDetailBean.setDepartment(resultSet1.getString("PLS_TO_DEPARTMENT"));
				toAppDetailBean.setLocale(fromAppDetails.getLocale());
				
				// Set from user password
				fromAppDetails.setPassword(DMSCryptograph.decode(resultSet1.getString("PLS_FM_USER_PWD")));
				
				// Appending user cred. to app URL
				toAppDetailBean.setAppHomeURL(toAppDetailBean.getAppHomeURL() + 
						DMSConstant.URL_PARAMETER_SEPARATOR + 
						DMSConstant.DMS_PARAMS +
						DMSConstant.EQUALS_OPERATOR + 
						prepareParameters(toAppDetailBean.getUserId(),
								toAppDetailBean.getPassword(),
								toAppDetailBean.getCompany(),
								toAppDetailBean.getBranch(),
								toAppDetailBean.getDepartment(),
								fromAppDetails.getLocale(),
								true) + 
						DMSConstant.ENCODED_PARAMETER_SEPARATOR + 
						DMSConstant.FROM_APP_URL + 
						DMSConstant.EQUALS_OPERATOR +
						DMSEncoder(
							fromAppDetails.getAppHomeURL() +
							DMSConstant.URL_PARAMETER_SEPARATOR +
							DMSConstant.DMS_PARAMS + 
							DMSConstant.EQUALS_OPERATOR +
							prepareParameters(fromAppDetails.getUserId(), 
									fromAppDetails.getPassword(), 
									fromAppDetails.getCompany(), 
									fromAppDetails.getBranch(), 
									fromAppDetails.getDepartment(), 
									fromAppDetails.getLocale(),
									true)));	
				
				DMSDetails.getToAppDetailsList().add(toAppDetailBean);
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet1);}catch(Exception exc){}
			try{CommonUtils.closeCursor(resultSet2);}catch(Exception exc){}
		}
		
		return;
	}

	public String buildURLForApplication(String applicationHomeURL,
			String applicationName,
			String userName,
			String password,
			String companyCode,
			String divisionCode,
			String departmentCode,
			String pageLocale) throws Exception {
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet resultSet = null;
		String FETCH_APP_DTLS = "SELECT * FROM PM_LOGIN_SWITCH WHERE PLS_FM_APPLICATION=? "
			+ "AND PLS_FM_USER_ID=? "
			+ "AND PLS_FM_COMPANY=? "
			+ "AND PLS_FM_DIVISION=? "
			+ "AND PLS_FM_DEPARTMENT=?";
		String FETCH_CURRENT_APP_HOME_URL = "";
		String toUserName = null;
		String toPassword = null;
		String toCompanyCode = null;
		String toDivisionCode = null;
		String toDepartmentCode = null;
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(FETCH_APP_DTLS, connection, 
					new Object[]{applicationName,
					userName,
					companyCode,
					divisionCode,
					departmentCode});
			if(resultSet.next()){
				toUserName = resultSet.getString("PLS_TO_USER_ID");
				toPassword = resultSet.getString("PLS_TO_USER_PWD");
				toCompanyCode = resultSet.getString("PLS_TO_COMPANY");
				toDivisionCode = resultSet.getString("PLS_TO_DIVISION");
				toDepartmentCode = resultSet.getString("PLS_TO_DEPARTMENT");

				applicationHomeURL = applicationHomeURL 
					+ "?" 
					+ prepareParameters(toUserName,
							toPassword,
							toCompanyCode,
							toDivisionCode,
							toDepartmentCode,
							pageLocale,
							false);
			}else{
				throw new Exception("You are not authorised to access the selected Application. Please contact to Administrator.");
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}

		return applicationHomeURL;
	}

	private String prepareParameters(
			String userName,
			String password,
			String companyCode,
			String divisionCode,
			String departmentCode,
			String pageLocale,
			boolean encodeParameterString){
		StringBuilder stringBuilder = new StringBuilder();
		String parameterString = null;
		
		stringBuilder.append(DMSConstant.USER_NAME);
		stringBuilder.append(DMSConstant.EQUALS_OPERATOR);
		stringBuilder.append(userName);
		stringBuilder.append(DMSConstant.ENCODED_PARAMETER_SEPARATOR);
		stringBuilder.append(DMSConstant.PASSWORD);
		stringBuilder.append(DMSConstant.EQUALS_OPERATOR);
		stringBuilder.append(password);
		stringBuilder.append(DMSConstant.ENCODED_PARAMETER_SEPARATOR);
		stringBuilder.append(DMSConstant.COMPANY);
		stringBuilder.append(DMSConstant.EQUALS_OPERATOR);
		stringBuilder.append(companyCode);
		stringBuilder.append(DMSConstant.ENCODED_PARAMETER_SEPARATOR);
		stringBuilder.append(DMSConstant.BRANCH);
		stringBuilder.append(DMSConstant.EQUALS_OPERATOR);
		stringBuilder.append(divisionCode);
		stringBuilder.append(DMSConstant.ENCODED_PARAMETER_SEPARATOR);
		stringBuilder.append(DMSConstant.DEPARTMENT);
		stringBuilder.append(DMSConstant.EQUALS_OPERATOR);
		stringBuilder.append(departmentCode);
		stringBuilder.append(DMSConstant.ENCODED_PARAMETER_SEPARATOR);
		stringBuilder.append(DMSConstant.LOCALE);
		stringBuilder.append(DMSConstant.EQUALS_OPERATOR);
		stringBuilder.append(pageLocale);
		
		// Encode parameter string
		if(encodeParameterString){
			parameterString = DMSEncoder(stringBuilder.toString());
		}else{
			parameterString = stringBuilder.toString();
		}
			
		//return parameterString;
		return parameterString;
	}
	
	public String appendFromAppURL(String toAppURL, DMSAppDetailsBean fromAppDetailsBean){
		String completeURL = null;
		
		completeURL = toAppURL + 
			DMSConstant.ENCODED_PARAMETER_SEPARATOR + 
			DMSConstant.FROM_APP_URL + 
			DMSConstant.EQUALS_OPERATOR +
			DMSEncoder(
				fromAppDetailsBean.getAppHomeURL() +
				DMSConstant.URL_PARAMETER_SEPARATOR +
				DMSConstant.DMS_PARAMS + 
				DMSConstant.EQUALS_OPERATOR +
				prepareParameters(fromAppDetailsBean.getUserId(), 
						fromAppDetailsBean.getPassword(), 
						fromAppDetailsBean.getCompany(), 
						fromAppDetailsBean.getBranch(), 
						fromAppDetailsBean.getDepartment(), 
						fromAppDetailsBean.getLocale(),
						true));
		
		return completeURL;
	}
	
	public String prepareRedirectURLForErrorOnAutoLogin(String url, String errorMessage){
		StringBuffer bufferURL = new StringBuffer(url);
		StringBuffer bufferErrorMessage = new StringBuffer();
		
		bufferErrorMessage.append(DMSConstant.ENCODED_PARAMETER_SEPARATOR);
		bufferErrorMessage.append(DMSConstant.ERROR_MESSAGE_KEY);
		bufferErrorMessage.append(DMSConstant.EQUALS_OPERATOR);
		bufferErrorMessage.append(errorMessage);
		
		//bufferURL.append(DMSEncoder(bufferErrorMessage.toString()));
		bufferURL.append(bufferErrorMessage.toString());
		
		return bufferURL.toString();
	}
	
	
	/*date of joining 
	string s=" "
		s[i] == 32 */
}
