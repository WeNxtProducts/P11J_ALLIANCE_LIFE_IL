package com.iii.premia.common.commonimpl.sso;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.StringTokenizer;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.login.model.LoginBean;
import com.iii.pel.login.model.LoginManagedBean;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class SSOHelper {

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
					//+ SSOConstant.SSO_PARAMS 
					//+ "="
					// Hard coded needs to remove
					//"http://10.44.8.65:8080/PremiaBroker/jsf/login/home.xhtml?"+SSOConstant.SSO_PARAMS+"="
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
			stringBuilder.append(SSOConstant.USER_NAME);
			stringBuilder.append(SSOConstant.EQUALS_OPERATOR);
			stringBuilder.append(loginBean.getUserName());
			stringBuilder.append(SSOConstant.ENCODED_PARAMETER_SEPARATOR);
			stringBuilder.append(SSOConstant.PASSWORD);
			stringBuilder.append(SSOConstant.EQUALS_OPERATOR);
			stringBuilder.append(loginBean.getPassword());
			stringBuilder.append(SSOConstant.ENCODED_PARAMETER_SEPARATOR);
			stringBuilder.append(SSOConstant.COMPANY);
			stringBuilder.append(SSOConstant.EQUALS_OPERATOR);
			stringBuilder.append(loginBean.getCompanyCode());
			stringBuilder.append(SSOConstant.ENCODED_PARAMETER_SEPARATOR);
			stringBuilder.append(SSOConstant.BRANCH);
			stringBuilder.append(SSOConstant.EQUALS_OPERATOR);
			stringBuilder.append(loginBean.getDivisionCode());
			stringBuilder.append(SSOConstant.ENCODED_PARAMETER_SEPARATOR);
			stringBuilder.append(SSOConstant.DEPARTMENT);
			stringBuilder.append(SSOConstant.EQUALS_OPERATOR);
			stringBuilder.append(loginBean.getDepartmentCode());
			stringBuilder.append(SSOConstant.ENCODED_PARAMETER_SEPARATOR);
			stringBuilder.append(SSOConstant.LOCALE);
			stringBuilder.append(SSOConstant.EQUALS_OPERATOR);
			stringBuilder.append(loginBean.getPageLocale());
			
			// Encode parameter string
			//parameterString = ssoEncoder(stringBuilder.toString());
			
		} /*catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/ finally{
			
		}
		
		//return parameterString;
		return stringBuilder.toString();
	}
	
	public String ssoEncoder(String parameters){
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
	
	public String ssoDecoder(String parameters){
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
		SSOHelper helper = new SSOHelper();
		String encoded = helper.ssoEncoder(name);
		System.out.println("Actual  String       : "+name);
		System.out.println("Encoded String       : "+encoded);
		encoded = helper.ssoEncoder(encoded);
		System.out.println("Double Encoded String: "+encoded);
		encoded = helper.ssoDecoder(encoded);
		System.out.println("Decoded String       : "+encoded);
		encoded = helper.ssoDecoder(encoded);
		System.out.println("Double Decoded String: "+encoded);
	}
	
	public void processRequest(HttpServletRequest request){
		String parameters = request.getParameter(SSOConstant.SSO_PARAMS);
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
		parameters = ssoDecoder(parameters);
		tokenizer = new StringTokenizer(parameters, SSOConstant.ENCODED_PARAMETER_SEPARATOR);
		while(tokenizer.hasMoreTokens()){
			token = tokenizer.nextToken();
			equalOperatorIndex = token.indexOf(SSOConstant.EQUALS_OPERATOR);
			key = token.substring(0, equalOperatorIndex);
			value = token.substring(equalOperatorIndex+1);
			if(SSOConstant.USER_NAME.equals(key)){
				loginBean.setUserName(value);
			}else if(SSOConstant.PASSWORD.equals(key)){
				loginBean.setPassword(value);
			}else if(SSOConstant.COMPANY.equals(key)){
				loginBean.setCompanyCode(value);
			}else if(SSOConstant.BRANCH.equals(key)){
				loginBean.setDivisionCode(value);
			}else if(SSOConstant.DEPARTMENT.equals(key)){
				loginBean.setDepartmentCode(value);
			}else if(SSOConstant.LOCALE.equals(key)){
				loginBean.setPageLocale(value);
			}
		}

		// Perform login action
		sessionMap.put("pageLocale", loginBean.getPageLocale());
		loginManagedBean.loginAction();
	}
	
	public boolean processRequestParameters(HttpServletRequest request, LoginManagedBean loginManagedBean){
		/*LoginBean loginBean = null;
		boolean isAutoLoginRequested = false;
		
		if(request.getParameter(SSOConstant.USER_NAME) != null){
			if(loginManagedBean == null){
				loginManagedBean = new LoginManagedBean();
				request.getSession().setAttribute("loginManagedBean", loginManagedBean);
			}
			
			loginBean = loginManagedBean.getLoginBean();
			loginBean.setUserName(request.getParameter(SSOConstant.USER_NAME));
			loginBean.setPassword(request.getParameter(SSOConstant.PASSWORD));
			loginBean.setCompanyCode(request.getParameter(SSOConstant.COMPANY));
			loginBean.setDivisionCode(request.getParameter(SSOConstant.BRANCH));
			loginBean.setDepartmentCode(request.getParameter(SSOConstant.DEPARTMENT));
			loginBean.setPageLocale(request.getParameter(SSOConstant.LOCALE));
			System.out.println("--------8<------------ Broker Session: "+request.getSession().getId());
			
			isAutoLoginRequested = true;
		}
		
		return isAutoLoginRequested;*/
		
		boolean isAutoLoginRequested = false;
		String ssoParams = null;
		String fromAppURL = null;
		
		ssoParams = request.getParameter(SSOConstant.SSO_PARAMS);
		fromAppURL = request.getParameter(SSOConstant.FROM_APP_URL);
		// Set the error message from url
		request.setAttribute(SSOConstant.ERROR_MESSAGE_KEY, request.getParameter(SSOConstant.ERROR_MESSAGE_KEY));
		if(ssoParams != null){
			//if(loginManagedBean == null){
				loginManagedBean = new LoginManagedBean();
				request.getSession().setAttribute("loginManagedBean", loginManagedBean);
			//}
			
			populateLoginBeanFromEncryptedURL(ssoParams, fromAppURL, loginManagedBean.getLoginBean());
			isAutoLoginRequested = true;
		}
		
		return isAutoLoginRequested;
	}
	private void populateLoginBeanFromEncryptedURL(String ssoParams, String fromAppURL, LoginBean loginBean){		
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		StringTokenizer tokenizer = null;
		String token = null;
		String key = null;
		String value = null;
		int equalOperatorIndex = -1;

		ssoParams = ssoDecoder(ssoParams);
		tokenizer = new StringTokenizer(ssoParams, SSOConstant.ENCODED_PARAMETER_SEPARATOR);
		while(tokenizer.hasMoreTokens()){
			token = tokenizer.nextToken();
			equalOperatorIndex = token.indexOf(SSOConstant.EQUALS_OPERATOR);
			key = token.substring(0, equalOperatorIndex);
			value = token.substring(equalOperatorIndex+1);
			if(SSOConstant.USER_NAME.equals(key)){
				loginBean.setUserName(value);
			}else if(SSOConstant.PASSWORD.equals(key)){
				loginBean.setPassword(value);
			}else if(SSOConstant.COMPANY.equals(key)){
				loginBean.setCompanyCode(value);
			}else if(SSOConstant.BRANCH.equals(key)){
				loginBean.setDivisionCode(value);
			}else if(SSOConstant.DEPARTMENT.equals(key)){
				loginBean.setDepartmentCode(value);
			}else if(SSOConstant.LOCALE.equals(key)){
				loginBean.setPageLocale(value);
			}
		}
		
		// Decode from app url, parameters of which is already in a state to redirect (encoded) after decoding
		fromAppURL = ssoDecoder(fromAppURL);
		sessionMap.put(SSOConstant.FROM_APP_URL, fromAppURL);

		// set locale
		sessionMap.put("pageLocale", loginBean.getPageLocale());

	}
	
	public void populateAppDetailListForUser(SSODetails ssoDetails) throws Exception{
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
		SSOAppDetailsBean fromAppDetails = ssoDetails.getFromAppDetails();
		SSOAppDetailsBean toAppDetailBean = null;
		
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
			ssoDetails.getToAppDetailsList().clear();
			// Preparing to app details
			while(resultSet1.next()){
				toAppDetailBean = new SSOAppDetailsBean();
				toAppDetailBean.setAppCode(resultSet1.getString("PAD_APPL_CODE"));
				toAppDetailBean.setAppDescription(resultSet1.getString("PAD_APPL_DESC"));
				toAppDetailBean.setAppHomeURL(resultSet1.getString("PAD_APPL_URL"));
				// User details
				toAppDetailBean.setUserId(resultSet1.getString("PLS_TO_USER_ID"));
				toAppDetailBean.setPassword(SSOCryptograph.decode(resultSet1.getString("PLS_TO_USER_PWD")).trim());
				toAppDetailBean.setCompany(resultSet1.getString("PLS_TO_COMPANY"));
				toAppDetailBean.setBranch(resultSet1.getString("PLS_TO_DIVISION"));
				toAppDetailBean.setDepartment(resultSet1.getString("PLS_TO_DEPARTMENT"));
				toAppDetailBean.setLocale(fromAppDetails.getLocale());
				
				// Set from user password
				fromAppDetails.setPassword(SSOCryptograph.decode(resultSet1.getString("PLS_FM_USER_PWD")));
				
				// Appending user cred. to app URL
				toAppDetailBean.setAppHomeURL(toAppDetailBean.getAppHomeURL() + 
						SSOConstant.URL_PARAMETER_SEPARATOR + 
						SSOConstant.SSO_PARAMS +
						SSOConstant.EQUALS_OPERATOR + 
						prepareParameters(toAppDetailBean.getUserId(),
								toAppDetailBean.getPassword(),
								toAppDetailBean.getCompany(),
								toAppDetailBean.getBranch(),
								toAppDetailBean.getDepartment(),
								fromAppDetails.getLocale(),
								true) + 
						SSOConstant.ENCODED_PARAMETER_SEPARATOR + 
						SSOConstant.FROM_APP_URL + 
						SSOConstant.EQUALS_OPERATOR +
						ssoEncoder(
							fromAppDetails.getAppHomeURL() +
							SSOConstant.URL_PARAMETER_SEPARATOR +
							SSOConstant.SSO_PARAMS + 
							SSOConstant.EQUALS_OPERATOR +
							prepareParameters(fromAppDetails.getUserId(), 
									fromAppDetails.getPassword(), 
									fromAppDetails.getCompany(), 
									fromAppDetails.getBranch(), 
									fromAppDetails.getDepartment(), 
									fromAppDetails.getLocale(),
									true)));	
				
				ssoDetails.getToAppDetailsList().add(toAppDetailBean);
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
		
		stringBuilder.append(SSOConstant.USER_NAME);
		stringBuilder.append(SSOConstant.EQUALS_OPERATOR);
		stringBuilder.append(userName);
		stringBuilder.append(SSOConstant.ENCODED_PARAMETER_SEPARATOR);
		stringBuilder.append(SSOConstant.PASSWORD);
		stringBuilder.append(SSOConstant.EQUALS_OPERATOR);
		stringBuilder.append(password);
		stringBuilder.append(SSOConstant.ENCODED_PARAMETER_SEPARATOR);
		stringBuilder.append(SSOConstant.COMPANY);
		stringBuilder.append(SSOConstant.EQUALS_OPERATOR);
		stringBuilder.append(companyCode);
		stringBuilder.append(SSOConstant.ENCODED_PARAMETER_SEPARATOR);
		stringBuilder.append(SSOConstant.BRANCH);
		stringBuilder.append(SSOConstant.EQUALS_OPERATOR);
		stringBuilder.append(divisionCode);
		stringBuilder.append(SSOConstant.ENCODED_PARAMETER_SEPARATOR);
		stringBuilder.append(SSOConstant.DEPARTMENT);
		stringBuilder.append(SSOConstant.EQUALS_OPERATOR);
		stringBuilder.append(departmentCode);
		stringBuilder.append(SSOConstant.ENCODED_PARAMETER_SEPARATOR);
		stringBuilder.append(SSOConstant.LOCALE);
		stringBuilder.append(SSOConstant.EQUALS_OPERATOR);
		stringBuilder.append(pageLocale);
		
		// Encode parameter string
		if(encodeParameterString){
			parameterString = ssoEncoder(stringBuilder.toString());
		}else{
			parameterString = stringBuilder.toString();
		}
			
		//return parameterString;
		return parameterString;
	}
	
	public String appendFromAppURL(String toAppURL, SSOAppDetailsBean fromAppDetailsBean){
		String completeURL = null;
		
		completeURL = toAppURL + 
			SSOConstant.ENCODED_PARAMETER_SEPARATOR + 
			SSOConstant.FROM_APP_URL + 
			SSOConstant.EQUALS_OPERATOR +
			ssoEncoder(
				fromAppDetailsBean.getAppHomeURL() +
				SSOConstant.URL_PARAMETER_SEPARATOR +
				SSOConstant.SSO_PARAMS + 
				SSOConstant.EQUALS_OPERATOR +
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
		
		bufferErrorMessage.append(SSOConstant.ENCODED_PARAMETER_SEPARATOR);
		bufferErrorMessage.append(SSOConstant.ERROR_MESSAGE_KEY);
		bufferErrorMessage.append(SSOConstant.EQUALS_OPERATOR);
		bufferErrorMessage.append(errorMessage);
		
		//bufferURL.append(ssoEncoder(bufferErrorMessage.toString()));
		bufferURL.append(bufferErrorMessage.toString());
		
		return bufferURL.toString();
	}
}
