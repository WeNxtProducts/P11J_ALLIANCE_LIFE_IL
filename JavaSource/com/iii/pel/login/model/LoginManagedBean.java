package com.iii.pel.login.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.richfaces.component.html.HtmlModalPanel;
import org.richfaces.component.html.HtmlSimpleTogglePanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.ConnectionManager;
import com.iii.apps.persistence.PremiaCryptograph;
import com.iii.apps.persistence.SimpleConnectionAgent;
import com.iii.pel.forms.GNMNF005_A_APAC.GNMNF005_A_APAC_SQL_QUERY_CONSTANTS;
import com.iii.pel.forms.MailManager.MailCreater;
import com.iii.pel.forms.MailManager.MailVO;
import com.iii.pel.login.constant.LangConstants;
import com.iii.pel.login.exception.LoginException;
import com.iii.pel.login.util.PasswordSetupUtility;
import com.iii.pel.util.Email_Procedure_Call;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.PremiaSessionBindingListener;

public class LoginManagedBean extends CommonAction implements Cloneable,
		Serializable {

	/*
	 * Added by Ram on 14/03/2017 for default details fetch process of company
	 * code,division code
	 */
	private static ResourceBundle resourceBundle = ResourceBundle
			.getBundle("Application");
	/* End */

	private static final long serialVersionUID = 1L;
	private HtmlInputText userName;
	private HtmlOutputLabel userNameLabel;
	private HtmlInputSecret password;
	private HtmlOutputLabel passwordLabel;
	private HtmlInputText companyCode;
	private HtmlOutputLabel companyCodeLabel;
	private HtmlInputText companyCodeBox;
	private HtmlOutputLabel divisionCodeLabel;
	private HtmlInputText divisionCode;
	private HtmlInputText divisionCodeBox;
	private HtmlInputText departmentCode;
	private HtmlOutputLabel departmentCodeLabel;
	private HtmlInputText departmentCodeBox;
	private HtmlOutputText loginMessageComp;
	private HtmlSimpleTogglePanel messagePanel;
	private LoginBean loginBean;
	private LangConstants langConst;
	private HtmlOutputText COM_PANEL_VALUE;
	private boolean isLoginConnectionSet = false;
	private static int loginCount = 0;
	private boolean validUserName = false;
	private boolean validPassword = false;
	private boolean validCompCode = false;
	private boolean validDivisionCode = false;
	private boolean validDepartmentCode = false;
	private boolean isUserLock = false;
	private boolean loginError = false;
	private boolean loginforgot = false;
	// [ SelectOneMenu binding added to disable the items, Dated: 13-Oct-2011,
	// Added by: Akash
	private HtmlSelectOneMenu language;
	// [ Button binding added to disable the items, Dated: 13-Oct-2011, Added
	// by: Manoj/Akash
	private HtmlCommandButton loginButton;
	private HtmlCommandButton resetButton;
	private HtmlAjaxCommandButton vcardButton;
	private VcardAction vcardAction = null;
	private LoginVirtualKeyboardAction loginVirtualKeyboardAction = null;
	// Button binding added to disable the items, Dated: 13-Oct-2011, Added by:
	// Manoj/Akash ]

	// [BugId:PREMIAGDC-265740 mmuthu 05-Jan-09 Blocking the application if any
	// browser other than IE Ver 6 and above
	private HtmlCommandButton browserVersion;

	public boolean isLoginforgot() {
		return loginforgot;
	}

	public void setLoginforgot(boolean loginforgot) {
		this.loginforgot = loginforgot;
	}

	public HtmlOutputText getCOM_PANEL_VALUE() {
		return COM_PANEL_VALUE;
	}

	public void setCOM_PANEL_VALUE(HtmlOutputText cOM_PANEL_VALUE) {
		COM_PANEL_VALUE = cOM_PANEL_VALUE;
	}

	public boolean browserType = true;

	public HtmlCommandButton getBrowserVersion() {
		return browserVersion;
	}

	public void setBrowserVersion(HtmlCommandButton browserVersion) {
		this.browserVersion = browserVersion;
	}

	// BugId:PREMIAGDC-265740 mmuthu 05-Jan-09 Blocking the application if any
	// browser other than IE Ver 6 and above ]

	/* added by gopi for forgot password */

	private HtmlCommandButton forgotButton;

	public HtmlCommandButton getForgotButton() {
		return forgotButton;
	}

	public void setForgotButton(HtmlCommandButton forgotButton) {
		this.forgotButton = forgotButton;
	}

	/* end */

	public LoginManagedBean() {
		loginBean = new LoginBean();
		langConst = new LangConstants();
		vcardAction = new VcardAction();
		loginVirtualKeyboardAction = new LoginVirtualKeyboardAction();

		/*
		 * Added by Gopi on 5/3/2016 for set default branch code and Department
		 * Code
		 */
		LoginDelegate_Bean = new LoginDelegate();
		/* End */

		intiantiateAllcomponent();
		setLoginConnection();
		setLoginLocale("en");
	}

	public void intiantiateAllcomponent() {
		userName = new HtmlInputText();
		companyCode = new HtmlInputText();
		divisionCode = new HtmlInputText();
		departmentCode = new HtmlInputText();

	}

	public HtmlOutputText getLoginMessageComp() {
		return loginMessageComp;
	}

	public void setLoginMessageComp(HtmlOutputText loginMessageComp) {
		this.loginMessageComp = loginMessageComp;
	}

	public HtmlInputText getUserName() {
		return userName;
	}

	public void setUserName(HtmlInputText userName) {
		this.userName = userName;
	}

	public HtmlInputSecret getPassword() {
		return password;
	}

	public void setPassword(HtmlInputSecret password) {
		this.password = password;
	}

	public HtmlInputText getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(HtmlInputText companyCode) {
		this.companyCode = companyCode;
	}

	public HtmlInputText getCompanyCodeBox() {
		return companyCodeBox;
	}

	public void setCompanyCodeBox(HtmlInputText companyCodeBox) {
		this.companyCodeBox = companyCodeBox;
	}

	public HtmlInputText getDivisionCode() {
		return divisionCode;
	}

	public void setDivisionCode(HtmlInputText divisionCode) {
		this.divisionCode = divisionCode;
	}

	public HtmlInputText getDivisionCodeBox() {
		return divisionCodeBox;
	}

	public void setDivisionCodeBox(HtmlInputText divisionCodeBox) {
		this.divisionCodeBox = divisionCodeBox;
	}

	public HtmlInputText getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(HtmlInputText departmentCode) {
		this.departmentCode = departmentCode;
	}

	public HtmlInputText getDepartmentCodeBox() {
		return departmentCodeBox;
	}

	public void setDepartmentCodeBox(HtmlInputText departmentCodeBox) {
		this.departmentCodeBox = departmentCodeBox;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public HtmlOutputLabel getUserNameLabel() {
		return userNameLabel;
	}

	public void setUserNameLabel(HtmlOutputLabel userNameLabel) {
		this.userNameLabel = userNameLabel;
	}

	public HtmlOutputLabel getPasswordLabel() {
		return passwordLabel;
	}

	public void setPasswordLabel(HtmlOutputLabel passwordLabel) {
		this.passwordLabel = passwordLabel;
	}

	public HtmlOutputLabel getCompanyCodeLabel() {
		return companyCodeLabel;
	}

	public void setCompanyCodeLabel(HtmlOutputLabel companyCodeLabel) {
		this.companyCodeLabel = companyCodeLabel;
	}

	public HtmlOutputLabel getDivisionCodeLabel() {
		return divisionCodeLabel;
	}

	public void setDivisionCodeLabel(HtmlOutputLabel divisionCodeLabel) {
		this.divisionCodeLabel = divisionCodeLabel;
	}

	public HtmlOutputLabel getDepartmentCodeLabel() {
		return departmentCodeLabel;
	}

	public void setDepartmentCodeLabel(HtmlOutputLabel departmentCodeLabel) {
		this.departmentCodeLabel = departmentCodeLabel;
	}

	public LangConstants getLangConst() {
		return langConst;
	}

	public void setLangConst(LangConstants langConst) {
		this.langConst = langConst;
	}

	// [BugId:PREMIAGDC-265740 mmuthu 05-Jan-09 Blocking the application if any
	// browser other than IE Ver 6 and above
	public void preForm(ActionEvent ae) {
		System.out
				.println("LoginManagedBean.preForm(******************************************)");
		getBrowserVersion().setDisabled(true);
		browserType = false;
		throw new ValidatorException(Messages.getMessage("login", "login1001"));
	}

	// BugId:PREMIAGDC-265740 mmuthu 05-Jan-09 Blocking the application if any
	// browser other than IE Ver 6 and above ]

	public void validateUserName(FacesContext context, UIComponent component,
			Object value) {
		/*
		 * String query = "SELECT * FROM MENU_USER WHERE USER_ID=?"; Map<String,
		 * Object> sessionMap = context.getExternalContext() .getSessionMap();
		 * Connection connection = (Connection)
		 * sessionMap.get("CONNECTION.LOGIN"); LoginManagedBean loginManagedBean
		 * = (LoginManagedBean) context
		 * .getExternalContext().getSessionMap().get("loginManagedBean"); String
		 * userName = (String) value;//
		 * loginManagedBean.getUserName().getSubmittedValue();
		 * loginManagedBean.getLoginBean().setUserName(userName); Object[]
		 * values = { userName }; CRUDHandler handler = new CRUDHandler();
		 * boolean isExist = false; ResultSet rst = null;
		 * 
		 * try { if(value == null || ((String) value).trim().isEmpty()){ throw
		 * new Exception("UserName is required"); } rst =
		 * handler.executeSelectStatement(query, connection, values); if
		 * (rst.next()) { isExist = true; }else{ throw new
		 * Exception("Invalid UserName/Password"); } } catch (Exception e) {
		 * e.printStackTrace(); throw new ValidatorException(new
		 * FacesMessage(e.getMessage())); } finally { try
		 * {CommonUtils.closeCursor(rst);}catch (Exception e) {} }
		 */

		// validate for empty value
		try {
			if (value == null || ((String) value).trim().isEmpty()) {
				throw new Exception("UserName is required");
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/*
	 * Added by Gopi on 5/3/2016 for Default branch code and Department
	 * code(Start)
	 */
	private LoginDelegate LoginDelegate_Bean;

	public LoginDelegate getLoginDelegate_Bean() {
		return LoginDelegate_Bean;
	}

	public void setLoginDelegate_Bean(LoginDelegate loginDelegate_Bean) {
		LoginDelegate_Bean = loginDelegate_Bean;
	}

	/* End */
	/* Changed by Ram on 30-11-2016 for Username onchange issue */

	/*
	 * public void userNameAction(ActionEvent event) {
	 * 
	 * UIInput input = (UIInput) event.getComponent().getParent();
	 * loginBean.setUserName((String) input.getSubmittedValue());
	 */

	/* Modified by Dhinesh on 30/11/2016 for FALCONLIFE-1347884 */
	public void userNameAction(FacesContext context, UIComponent component,
			Object value) {

		/* Added by Ram on 30/11/2016 for Display error Message in label */
		setErrorMessage(null);
		/* End */

		loginBean.setUserName((String) value);

		/* End */
		// ErrorHelpUtil.validate(input, getErrorMap());
		/*
		 * Added by Gopi on 5/3/2016 for Default branch code and Department
		 * code(Start)
		 */

		/* Added by Janani on 05.04.2017 for login_image */

		System.out.println("getUserName              :"
				+ loginBean.getUserName());
		CommonUtils.setGlobalObject("FILEUPLOAD_USERNAME",
				loginBean.getUserName());

		/* End */
		try {

			/* Added by Raja on 05/04/2017 for PasswordReset concept */
			/*
			 * Commented by Raja on 20/04/2017
			 * 
			 * reset_password_validation();
			 */
			// callModelPanel();
			/* End */

			/*
			 * Added by Ram on 14/03/2017 for default details fetch process of
			 * company code,division code
			 */
			System.out
					.println("resourceBundle.getString(isDefaultLogin)        "
							+ resourceBundle.getString("isDefaultLogin"));
			if (resourceBundle.getString("isDefaultLogin") != null
					&& resourceBundle.getString("isDefaultLogin")
							.equalsIgnoreCase("Y")) {
				/* End */

				System.out.println("entering into userNameAction");
				setDefaultCompanyCode();
				String Code = getLoginDelegate_Bean().executeDefaultBranch(
						loginBean.getUserName());
				String arr[] = Code.split(",");
				String divisionCode = arr[0];
				String depCode = arr[1];
				System.out.println(divisionCode);
				System.out.println(depCode);
				getLoginBean().setDivisionCode(divisionCode);
				getLoginBean().setDepartmentCode(depCode);

				/*
				 * cpmmented by R.Raja on 05-01-2017 for ssp call-
				 * ZBILQC-1718814
				 */

				/* Added by Janani on 16.3.2016 for disabling divn & dept code */

				if (getLoginBean().getDivisionCode() != null) {
					System.out.println("divncode !=null");

					divisionCodeBox.setDisabled(true);
				} else {
					System.out.println("divncode =null");
					divisionCodeBox.setDisabled(false);
				}

				if (getLoginBean().getDepartmentCode() != null) {
					System.out.println("deptcode !=null");

					departmentCodeBox.setDisabled(true);
				} else {
					System.out.println("deptcode =null");
					departmentCodeBox.setDisabled(false);
				}
				if (getLoginBean().getCompanyCode() != null) {
					System.out.println("company !=null");
					// companyCodeBox.resetValue();
					companyCodeBox.setDisabled(true);
				} else {
					System.out.println("company =null");
					companyCodeBox.setDisabled(false);
				}

				divisionCodeBox.resetValue();
				departmentCodeBox.resetValue();
				/* end */
				/* end */
				companyCodeBox.setDisabled(false);
				/*
				 * departmentCodeBox.setDisabled(false);
				 * divisionCodeBox.setDisabled(false);
				 */
				companyCodeBox.resetValue();

			}
			/* Added by Raja on 20/04/2017 */
			reset_password_validation();
			/* End */

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			/* Added by Ram on 30/11/2016 for Display error Message in label */
			setErrorMessage(e.getMessage());
			/* End */
		}
		/* End */
	}

	public void setDefaultCompanyCode() throws Exception {
		System.out.println("i m here");
		vcardAction = new VcardAction();

		LoginManagedBean loginManagedBean = (LoginManagedBean) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("loginManagedBean");
		System.out.println("loginManagedBean         " + loginManagedBean);
		String companycode = new LoginDelegate().executeSelectStatement();
		getLoginBean().setCompanyCode(companycode);

	}

	private Connection getConnection() throws Exception {
		Connection connection = null;
		String driver_class = Messages.getString("login",
				"jdbc.datasource.driver");
		String driver_url = Messages.getString("login", "login_db_url");
		String user_name = Messages.getString("login", "login_db_user_name");
		String user_pwd = Messages.getString("login", "login_db_password");

		// [ Added for cryptography in property file, Dated: 21-Oct-2011,
		// implemented by: Yalamanda/Manoj
		driver_class = PremiaCryptograph.decrypt(
				ConnectionManager.ENCRYPTION_KEY, driver_class);
		driver_url = PremiaCryptograph.decrypt(
				ConnectionManager.ENCRYPTION_KEY, driver_url);
		user_name = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY,
				user_name);
		user_pwd = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY,
				user_pwd);
		// Added for cryptography in property file ]

		Class.forName(driver_class);
		System.out.println("driver_url : " + driver_url);
		System.out.println("user_name : " + user_name);
		System.out.println("user_pwd : " + user_pwd);
		connection = DriverManager.getConnection(driver_url, user_name,
				user_pwd);
		connection.setAutoCommit(false);
		return connection;
	}

	private void disabledComponent() throws Exception {
		userName.setDisabled(true);
		password.setDisabled(true);
		companyCodeBox.setDisabled(true);
		divisionCodeBox.setDisabled(true);
		departmentCodeBox.setDisabled(true);
		loginButton.setDisabled(true);
		resetButton.setDisabled(true);
		language.setDisabled(true);
		vcardButton.setDisabled(true);

	}

	// Added by Akash to validate User/Password dated : 12-oct-2011
	public void M_PASSWD_whenValidateItem(LoginManagedBean managedBean)
			throws Exception {
		String M_PASSWD = "L";
		Integer M_LOGIN_COUNT = 0;
		String M_TEMP = null;
		String M_LINE_ID = null;
		String M_OVERRIDE_YN = null;
		String M_USER_GROUP_ID = null;
		String M_DEC_PASSWD = null;
		String M_FSTLOG_FLAG = null;
		String PASSWD = null;
		Integer USER_LOGIN_COUNT = 0;
		ResultSet rst_C1 = null;
		ResultSet rst_C2 = null;
		CRUDHandler handler = null;
		Connection connection = null;
		String M_USER_LOCK_YN = null;
		boolean loginFailFlag = false;
		String lockoutMessage = null;
		MailVO mailVO = null;
		List<String> tolist = null;
		String userEmail = null;
		LoginBean loginBean = managedBean.getLoginBean();
		System.out.println("password value -------" + this.hashCode());
		String M_USER_ID_INPUT = loginBean.getUserName();
		M_PASSWD = loginBean.getPassword();
		String sql_C1 = "SELECT DECRYPT(USER_PASSWD,'3iInfotech') , NVL(USER_LOGIN_COUNT,3), "
				+ "'1','Y', USER_GROUP_ID,USER_LOCKED_YN,USER_EMAIL,USER_NO_OF_FAILED_LOGINS "
				+ "FROM   MENU_USER " + "WHERE  USER_ID = RTRIM(?)";// M_USER_ID_INPUT
		String sql_C2 = "SELECT USER_PASSWD,USER_FSTLOG_FLAG "
				+ "FROM   MENU_USER " + "WHERE  USER_ID = ?";// M_USER_ID_INPUT
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		connection = (Connection) sessionMap.get("CONNECTION.LOGIN");
		String ipAddress = ((HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest())
				.getRemoteAddr();
		int wrongUseridAttemptsAllowed = Integer.parseInt(Messages.getString(
				"login", "premia_login_wrong_user_id_attempts").trim());

		System.out.println("M_USER_ID_INPUT             "+M_USER_ID_INPUT);
		
		try {
			handler = new CRUDHandler();
			rst_C1 = handler.executeSelectStatement(sql_C1, connection,
					new Object[] { M_USER_ID_INPUT });
			if (rst_C1.next()) {
				M_DEC_PASSWD = rst_C1.getString(1);
				USER_LOGIN_COUNT = rst_C1.getInt(2);
				M_LINE_ID = rst_C1.getString(3);
				M_OVERRIDE_YN = rst_C1.getString(4);
				M_USER_GROUP_ID = rst_C1.getString(5);
				M_USER_LOCK_YN = rst_C1.getString(6);
				userEmail = rst_C1.getString(7);
				M_LOGIN_COUNT = rst_C1.getInt(8);
				
				System.out.println("M_LOGIN_COUNT in if         "+M_LOGIN_COUNT);
				
			} else {
				
				System.out.println("getUserLoginCount in else            "+loginBean.getUserLoginCount());
				
				loginFailFlag = false;
				loginBean.setUserLoginCount(loginBean.getUserLoginCount() + 1);
				M_LOGIN_COUNT = loginBean.getUserLoginCount();
				
				System.out.println("M_LOGIN_COUNT in else            "+M_LOGIN_COUNT);
				System.out.println("wrongUseridAttemptsAllowed in else            "+wrongUseridAttemptsAllowed);
				
				if (M_LOGIN_COUNT == wrongUseridAttemptsAllowed - 1) {
					throw new Exception(
							"Invalid User Name/Password. You have only One attempt left.");
				} else if (M_LOGIN_COUNT >= wrongUseridAttemptsAllowed) {
					isUserLock = true;

					/* commented by raja on 07-01-2017 for ZBILQC-1718814 */

					// disabledComponent();

					/* end */
					throw new Exception(
							"Login attempt limit exceeded. Cannot login further.");
				} else {
					throw new Exception("Invalid User Name/Password.");
				}
			}
			sessionMap.put("GLOBAL.M_USER_GROUP", M_USER_GROUP_ID);
			//CommonUtils.closeCursor(rst_C1);
			if (M_USER_LOCK_YN != null && "N".equals(M_USER_LOCK_YN)) {
				if (!M_DEC_PASSWD.equals(M_PASSWD)) {
					loginBean
							.setUserLoginCount(loginBean.getUserLoginCount() + 1);
					M_LOGIN_COUNT = loginBean.getUserLoginCount();
					if (M_LOGIN_COUNT >= USER_LOGIN_COUNT) {
						isUserLock = true;
						loginFailFlag = true;
						handler.executeUpdateStatement(
								"UPDATE MENU_USER SET USER_LOCKED_YN=?,USER_LOCK_REASON=? WHERE USER_ID=?",
								connection,
								new Object[] {
										"Y",
										"User Locked due to failed login attempts",
										M_USER_ID_INPUT });
						sendNotification(M_USER_ID_INPUT, userEmail);

						/* commented by raja on 07-01-2017 for ZBILQC-1718814 */
						// disabledComponent();
						/* end */
						throw new Exception(
								"Login Attempt Limit Exceeded : This User id is Locked Contact Administrator");
					} else if (M_LOGIN_COUNT == USER_LOGIN_COUNT - 1) {
						loginFailFlag = true;
						throw new Exception(
								"Invalid User Name/Password. You have only One attempt Left");
					} else {
						loginFailFlag = true;
						throw new Exception("Invalid User Name/Password.");
					}
				}
				connection.commit();
			} else {
				loginFailFlag = true;
				sendNotification(M_USER_ID_INPUT, userEmail);
				throw new Exception(
						"This User id is Locked Contact Administrator");
			}
		}
		
		/*Commented by Janani on 03.05.2018 for password validation not throwing*/
		/*catch(Exception e){
			e.printStackTrace();
		}*/
		
		/*End*/
		finally {
			if (loginFailFlag) {
				handler.executeUpdateStatement(
						"UPDATE MENU_USER SET USER_NO_OF_FAILED_LOGINS=? WHERE USER_ID=?",
						connection, new Object[] { M_LOGIN_COUNT,
								M_USER_ID_INPUT });
				handler.executeInsertStatement(
						"INSERT INTO USER_FAILED_LOGINS "
								+ "(UFL_USER_ID,UFL_TRIED_PASSWORD,UFL_TIMESTAMP,UFL_IP_ADDRESS) VALUES(?,?,?,?)",
						connection, new Object[] { M_USER_ID_INPUT, M_PASSWD,
								new CommonUtils().getCurrentDateAndTime(),
								ipAddress });
				connection.commit();
			}

			CommonUtils.closeCursor(rst_C1);
			CommonUtils.closeCursor(rst_C2);
		}
	}

	// Added by Akash to send a Notification Mail to a User dated : 12-oct-2011

	private void sendNotification(String userId, String receipientsMailId)
			throws Exception {
		MailVO mailVO = null;
		ArrayList<String> tolist = null;
		try {
			if (receipientsMailId != null) {
				mailVO = new MailVO();
				tolist = new ArrayList<String>();
				tolist.add(receipientsMailId);
				mailVO.setToList(tolist);
				mailVO.setSubject(Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"premia.broker.mail.userlocked.subject"));
				// mailVO.setTitle(Messages.getString(PELConstants.pelMessagePropertiesPath,
				// "premia.broker.mail.userlocked.title");
				mailVO.setFromId(Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"premia.broker.mail.userlocked.from.id"));
				mailVO.setFromName(Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"premia.broker.mail.userlocked.from.name"));
				mailVO.setMessageBody(Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"premia.broker.mail.userlocked.body",
						new Object[] { userId }));
				mailVO.setPriority(Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"premia.broker.mail.userpassword.priority"));

				PasswordSetupUtility.sendNotificationMail(mailVO);
			}
		} catch (Exception e) {
			throw new Exception("Messaging Service not avilable.");
		}
	}

	public void validatePassword(FacesContext context, UIComponent component,
			Object value) {
		try {
			if (value == null || ((String) value).trim().isEmpty()) {
				throw new Exception("Password is required");
			}
			getLoginBean().setPassword((String) value);
			M_PASSWD_whenValidateItem(this);
		} catch (Exception e) {
			/*Added by Janani on 03.05.2018 for password validation not throwing*/
			e.printStackTrace();
			/*End*/
			getLoginBean().setPassword(null);
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void passwordAction(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		loginBean.setPassword((String) input.getSubmittedValue());
		// ErrorHelpUtil.validate(input, getErrorMap());
	}

	public List<LoginBean> getCompCodeList(Object event) {
		String compCode = (String) event;
		List<LoginBean> compCodeList = null;
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		String userName = getLoginBean().getUserName();
		/* commented by raja on 07-01-2017 for ZBILQC-1718814 */
		/*
		 * if(compCode!=null) {
		 */
		/* commented by raja on 07-01-2017 for ZBILQC-1718814 */
		if (compCode.equals("*"))
			compCode = "%";
		else if (compCode.length() > 0)
			compCode += "%";
		Connection connection = (Connection) sessionMap.get("CONNECTION.LOGIN");
		// [BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_COMPANY to
		// FM_COMPANY. Added by : Shankar.B 31-Mar-2009
		String queryString = "SELECT MUC_COMP_CODE, COMP_NAME "
				+ "FROM FM_COMPANY, MENU_USER_COMP "
				+ "WHERE COMP_CODE=MUC_COMP_CODE " + "AND MUC_USER_ID=? "
				+ "AND MUC_COMP_CODE " + "LIKE NVL(?, MUC_COMP_CODE)";
		Object[] values = { userName, compCode };
		CRUDHandler handler = new CRUDHandler();
		LoginBean loginVOB = null;
		ResultSet rst = null;
		try {
			rst = handler.executeSelectStatement(queryString, connection,
					values);
			compCodeList = new ArrayList<LoginBean>();
			loginVOB = new LoginBean();
			while (rst.next()) {
				loginVOB.setCompanyCode(rst.getString("MUC_COMP_CODE"));
				loginVOB.setCompanyCodeDesc(rst.getString("COMP_NAME"));
				compCodeList.add(loginVOB);
			}
			if (compCodeList.size() == 0) {
				getErrorMap().put("current",
						"No company code exists for the user");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/*
		 * }
		 */
		return compCodeList;
	}

	public void compCodeAction(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		loginBean.setCompanyCode((String) input.getSubmittedValue());
		// ErrorHelpUtil.validate(input, getErrorMap());
		System.out.println("loginBean ===> " + loginBean.getCompanyCode());
	}

	public void validateCompCode(FacesContext context, UIComponent component,
			Object value) {

		// [BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_COMPANY to
		// FM_COMPANY. Added by : Shankar.B 31-Mar-2009
		String query = "SELECT 1 FROM FM_COMPANY WHERE COMP_CODE = ? AND COMP_FRZ_FLAG = ? ";
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		Connection connection = (Connection) sessionMap.get("CONNECTION.LOGIN");
		LoginManagedBean loginManagedBean = (LoginManagedBean) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("loginManagedBean");
		String compCode = (String) value;
		Object[] values = { compCode, "N" };
		CRUDHandler handler = new CRUDHandler();
		boolean isExist = false;
		ResultSet rst = null;
		try {
			if (value == null || ((String) value).trim().isEmpty()) {
				throw new Exception("Company Code is required");
			}
			rst = handler.executeSelectStatement(query, connection, values);
			while (rst.next()) {
				isExist = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
			}
		}
		if (!isExist) {
			throw new ValidatorException(Messages.getMessage("login",
					"login1006"));
		}
	}

	public List<LoginBean> getDivCodeList(Object event) {
		String divnCode = (String) event;
		List<LoginBean> divCodeList = null;
		if (divnCode != null) {
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			String userName = getLoginBean().getUserName();
			String compCode = getLoginBean().getCompanyCode();

			/* commented divncode by raja on 07-01-2017 for ZBILQC-1718814 */

			if (/* divnCode != null && */compCode != null) {

				/* end */
				if (divnCode.equals("*"))
					divnCode = "%";
				else if (divnCode.length() > 0)
					divnCode += "%";
				Connection connection = (Connection) sessionMap
						.get("CONNECTION.LOGIN");
				/*
				 * [BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DIVISION to
				 * FM_DIVISION. Added by : Mallika.S, 31-Mar-2009
				 */
				/*Modified by ganesh on 04-04-2018 as suggested by ajoy from onsite*/
				/*String queryString = "SELECT DIVN_CODE, DIVN_NAME FROM FM_DIVISION "
						+ "WHERE DIVN_COMP_CODE = ? "
						+ "AND DIVN_FRZ_FLAG = 'N' AND EXISTS ("
						+ "SELECT 1 FROM PM_APPR_DEPT_SETUP "
						+ "WHERE ADS_DIVN_CODE = DIVN_CODE "
						+ "AND ADS_FRZ_FLAG = 'N' "
						+ "AND ADS_USER_ID = ?) "
						+ "AND DIVN_CODE LIKE NVL(?, DIVN_CODE)";*/
				
				/*
				 * query has been handled inside try by Ameen on 19-07-2018 as per Ajay sugg. for TOI
				 * String queryString = "SELECT DISTINCT DIVN_CODE, DIVN_NAME FROM MENU_USER_COMP_DIVN, FM_DIVISION "
						+ "WHERE DIVN_COMP_CODE = MUCD_COMP_CODE  AND DIVN_CODE = MUCD_DIVN_CODE "
						+ "AND MUCD_COMP_CODE = ?   "
						+ "AND MUCD_USER_ID = ? "
						+ "AND DIVN_CODE LIKE NVL(?, DIVN_CODE)";*/
				/*
				 * String queryString = "SELECT MUCD_DIVN_CODE, DIVN_NAME " +
				 * "FROM MENU_USER_COMP_DIVN, FM_DIVISION " + "WHERE
				 * MUCD_USER_ID=? " + "AND MUCD_COMP_CODE=DIVN_COMP_CODE " +
				 * "AND MUCD_DIVN_CODE=DIVN_CODE " + "AND MUCD_DIVN_CODE LIKE
				 * NVL(?, MUCD_DIVN_CODE) " + "AND MUCD_COMP_CODE=?";
				 */
				Object[] values = { compCode, userName, divnCode };
				CRUDHandler handler = new CRUDHandler();
				LoginBean loginVOB = null;
				String queryString = "";
				ResultSet rst = null;
				/*added by Ameen on 19-07-2018 for TOI as per Ajay sugg.*/
				String divParamQry="SELECT PS_VALUE FROM PP_SYSTEM1 WHERE PS_TYPE='IL_DIV_LOGIN'";
				String divParam="";
				ResultSet divParamRS = null;
				/*end*/
				try {
					divParamRS = handler.executeSelectStatement(divParamQry, connection);
					if(divParamRS.next()){
						divParam = divParamRS.getString("PS_VALUE");
					}
					/*added/modified by Ameen on 19-07-2018 for TOI as per Ajay sugg.*/
					if("1".equals(divParam)){
						queryString = "SELECT DIVN_CODE, DIVN_NAME FROM FM_DIVISION "
						+ "WHERE DIVN_COMP_CODE = ? "
						+ "AND DIVN_FRZ_FLAG = 'N' AND EXISTS ("
						+ "SELECT 1 FROM PM_APPR_DEPT_SETUP "
						+ "WHERE ADS_DIVN_CODE = DIVN_CODE "
						+ "AND ADS_FRZ_FLAG = 'N' "
						+ "AND ADS_USER_ID = ?) "
						+ "AND DIVN_CODE LIKE NVL(?, DIVN_CODE)";
				
					}else{
						queryString = "SELECT DISTINCT DIVN_CODE, DIVN_NAME FROM MENU_USER_COMP_DIVN, FM_DIVISION "
								+ "WHERE DIVN_COMP_CODE = MUCD_COMP_CODE  AND DIVN_CODE = MUCD_DIVN_CODE "
								+ "AND MUCD_COMP_CODE = ?   "
								+ "AND MUCD_USER_ID = ? "
								+ "AND DIVN_CODE LIKE NVL(?, DIVN_CODE)";
					}
					/*end*/
					rst = handler.executeSelectStatement(queryString,
							connection, values);
					divCodeList = new ArrayList<LoginBean>();
					while (rst.next()) {
						loginVOB = new LoginBean();
						loginVOB.setDivisionCode(rst.getString("DIVN_CODE"));
						loginVOB.setDivisionCodeDesc(rst.getString("DIVN_NAME"));
						divCodeList.add(loginVOB);
					}
					if (divCodeList.size() == 0) {
						getErrorMap().put("current",
								"No division code exists for the user");
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						CommonUtils.closeCursor(rst);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return divCodeList;
	}

	public void divnCodeAction(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		loginBean.setDivisionCode((String) input.getSubmittedValue());
		// ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateDivnCode(FacesContext context, UIComponent component,
			Object value) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		LoginManagedBean loginManagedBean = (LoginManagedBean) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("loginManagedBean");
		String divisionCode = (String) value;
		if (divisionCode != null) {

			String compCode = getLoginBean().getCompanyCode();
			/*
			 * [BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DIVISION to
			 * FM_DIVISION. Added by : Mallika.S, 31-Mar-2009
			 */
			String query = "SELECT 1 FROM FM_DIVISION "
					+ "WHERE DIVN_COMP_CODE = ? " + "AND DIVN_CODE = ? "
					+ "AND DIVN_FRZ_FLAG = ? ";
			Object[] values = { compCode, divisionCode, "N" };
			Connection connection = (Connection) sessionMap
					.get("CONNECTION.LOGIN");
			CRUDHandler handler = new CRUDHandler();
			boolean isExist = false;
			ResultSet rst = null;
			try {
				if (value == null || ((String) value).trim().isEmpty()) {
					throw new Exception("Divison Code is required");
				}
				rst = handler.executeSelectStatement(query, connection, values);
				while (rst.next()) {
					isExist = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			} finally {
				try {
					CommonUtils.closeCursor(rst);
				} catch (Exception e) {
				}
			}
			if (!isExist) {
				throw new ValidatorException(Messages.getMessage("login",
						"login1007"));
			}
		}
	}

	public List<LoginBean> getDepartCodeList(Object event) {
		String departCode = (String) event;
		List<LoginBean> deptCodeList = null;
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		LoginManagedBean loginBean = (LoginManagedBean) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("loginManagedBean");
		String userName = loginBean.getLoginBean().getUserName();
		String compCode = loginBean.getLoginBean().getCompanyCode();
		String divnCode = loginBean.getLoginBean().getDivisionCode();
		/* commented by raja on 07-01-2017 for ZBILQC-1718814 */
		/* if (departCode != null) { */
		/* end */
		if (departCode.equals("*")) {
			departCode = "%";
		} else {
			departCode += "%";
		}
		Connection connection = (Connection) sessionMap.get("CONNECTION.LOGIN");
		/*
		 * [BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DEPARTMENT to
		 * FM_DEPARTMENT. Added by : Mallika.S, 31-Mar-2009
		 */
		/*Commented by ganesh on 05-03-2018 as suggested by ajoy 
		 * 
		 * String query = "SELECT DEPT_CODE, DEPT_NAME FROM   FM_DEPARTMENT "
				+ "WHERE DEPT_COMP_CODE = ? " + "AND DEPT_DIVN_CODE = ? "
				+ "AND DEPT_FRZ_FLAG = 'N' AND EXISTS ("
				+ "SELECT 1 FROM PM_APPR_DEPT_SETUP "
				+ "WHERE ADS_DIVN_CODE = DEPT_DIVN_CODE "
				+ "AND ADS_DEPT_CODE = DEPT_CODE " + "AND ADS_FRZ_FLAG = 'N' "
				+ "AND ADS_USER_ID = ?) "
				+ "AND DEPT_CODE LIKE NVL(?, DEPT_CODE)";*/
		/*
		 * String query = "SELECT MUCD_DEPT_CODE,DEPT_NAME " + "FROM
		 * MENU_USER_COMP_DIVN, FM_DEPARTMENT " + "WHERE MUCD_USER_ID=? " +
		 * "AND MUCD_COMP_CODE=DEPT_COMP_CODE " + "AND
		 * MUCD_DIVN_CODE=DEPT_DIVN_CODE " + "AND MUCD_DEPT_CODE LIKE NVL(?,
		 * MUCD_DEPT_CODE)";
		 */
		//Commented by ganesh on 05-03-2018 as suggested by ajoy 
		/*Object[] values = { compCode, divnCode, userName, departCode };*/
		/*Added by ganesh on 05-03-2018 as suggested by ajoy*/
		String query = "SELECT DEPT_CODE, DEPT_NAME FROM "
						+ "MENU_USER_COMP_DIVN, FM_DEPARTMENT "
						+ "WHERE DEPT_COMP_CODE = MUCD_COMP_CODE "
						+ "AND DEPT_DIVN_CODE = MUCD_DIVN_CODE  "
						+ "AND DEPT_CODE = MUCD_DEPT_CODE   "
						+ "AND MUCD_USER_ID = ?   "
						+ "AND MUCD_COMP_CODE = ?   "
						+ "AND MUCD_DIVN_CODE = ?   "
						+ "AND DEPT_CODE LIKE NVL(?, DEPT_CODE)";
		
		Object[] values = { userName, compCode, divnCode, departCode };
		/*end*/
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst = null;
		try {
			rst = handler.executeSelectStatement(query, connection, values);
			deptCodeList = new ArrayList<LoginBean>();
			while (rst.next()) {
				LoginBean loginVOB = new LoginBean();
				loginVOB.setDepartmentCode(rst.getString("DEPT_CODE"));
				loginVOB.setDepartmentCodeDesc(rst.getString("DEPT_NAME"));
				deptCodeList.add(loginVOB);
			}
			if (deptCodeList.size() == 0) {
				getErrorMap().put("current",
						"No department code exists for the user");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/* } */
		return deptCodeList;
	}

	public void deptCodeAction(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		loginBean.setDepartmentCode((String) input.getSubmittedValue());
		// ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateDeptCode(FacesContext context, UIComponent component,
			Object value) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		LoginManagedBean loginBean = (LoginManagedBean) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("loginManagedBean");
		String deptCode = (String) value;
		if (deptCode != null) {
			String userName = loginBean.getLoginBean().getUserName();
			String compCode = loginBean.getLoginBean().getCompanyCode();
			String divCode = loginBean.getLoginBean().getDivisionCode();
			Connection connection = (Connection) sessionMap
					.get("CONNECTION.LOGIN");
			/*
			 * [BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DEPARTMENT to
			 * FM_DEPARTMENT. Added by : Mallika.S, 31-Mar-2009
			 */
			String query = "SELECT 1 FROM FM_DEPARTMENT "
					+ "WHERE DEPT_COMP_CODE = ? " + "AND DEPT_DIVN_CODE = ? "
					+ "AND DEPT_CODE = ? " + "AND DEPT_FRZ_FLAG  = ? ";
			Object[] values = { compCode, divCode, deptCode, "N" };
			CRUDHandler handler = new CRUDHandler();
			boolean isExist = false;
			ResultSet rst = null;
			try {
				if (value == null || ((String) value).trim().isEmpty()) {
					throw new Exception("Department Code is required");
				}
				rst = handler.executeSelectStatement(query, connection, values);
				while (rst.next()) {
					isExist = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			} finally {
				try {
					CommonUtils.closeCursor(rst);
				} catch (Exception e) {
				}
			}
			if (!isExist) {
				throw new ValidatorException(Messages.getMessage("login",
						"login1008"));
			} else {
				String query1 = "SELECT * FROM PM_APPR_DEPT_SETUP "
						+ "WHERE ADS_USER_ID= ? " + "AND ADS_DIVN_CODE  = ? "
						+ "AND ADS_DEPT_CODE = ? " + "AND ADS_FRZ_FLAG= ?";
				Object[] values1 = { userName, divCode, deptCode, "N" };
				handler = new CRUDHandler();
				boolean isExist1 = false;
				try {
					rst = handler.executeSelectStatement(query1, connection,
							values1);
					while (rst.next()) {
						isExist1 = true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						CommonUtils.closeCursor(rst);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (!isExist1) {
					throw new ValidatorException(Messages.getMessage("login",
							"login1009"));
				} else {
					loginBean.getLoginBean().setDepartmentCode(deptCode);
				}
			}
		}
	}

	private boolean login() throws Exception {
		boolean passwordExpired = false;
		String disbaleFlag = null;
		Date passExpDate = null;
		String userEmail = null;
		String USER_PASSWD_EXPIRY_YN = null;
		String userGroup = null;
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		ResultSet rest_c1 = null;
		try {
			LoginManagedBean loginManagedBean = (LoginManagedBean) FacesContext
					.getCurrentInstance().getExternalContext().getSessionMap()
					.get("loginManagedBean");
			System.out.println("Locale: >>>>>>>>>>>>>>>>>>>>"
					+ loginManagedBean.getLoginBean().getPageLocale());
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			String userName = loginManagedBean.getLoginBean().getUserName();
			String compCode = loginManagedBean.getLoginBean().getCompanyCode();
			String divisionCode = loginManagedBean.getLoginBean()
					.getDivisionCode();
			String departCode = loginManagedBean.getLoginBean()
					.getDepartmentCode();
			String userAdmin = loginManagedBean.getLoginBean()
					.getUserAdministrator();
			String userPasswd = loginManagedBean.getLoginBean().getPassword();

			System.out.println("userName       : " + userName);
			System.out.println("compCode       : " + compCode);
			System.out.println("divisionCode   : " + divisionCode);
			System.out.println("departCode     : " + departCode);
			System.out.println("userAdmin      : " + userAdmin);
			System.out.println("userPasswd     : " + userPasswd);

			String selectQuery = "SELECT USER_GROUP_ID FROM MENU_USER_COMP_DIVN, MENU_USER "
					+ "WHERE USER_ID=MUCD_USER_ID "
					+ "AND MUCD_USER_ID = ? "
					+ "AND MUCD_COMP_CODE = ? "
					+ "AND MUCD_DIVN_CODE = ? "
					+ "AND MUCD_DEPT_CODE = ?";
			Object[] values = { userName, compCode, divisionCode, departCode };
			try {
				connection = (Connection) sessionMap.get("CONNECTION.LOGIN");
				handler = new CRUDHandler();
				rst = handler.executeSelectStatement(selectQuery, connection,
						values);
				while (rst.next()) {
					userGroup = rst.getString("USER_GROUP_ID");
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw new LoginException("Invalid Login. Try Again!!!");
			} finally {
				try {
					CommonUtils.closeCursor(rst);
				} catch (Exception e) {
					throw new LoginException(e.getMessage());
				}
			}
			if (userGroup == null) {
				throw new LoginException("Invalid Login. Try Again!!!");
			}
			Map<String, Object> session = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			session.put("pageLocale", loginManagedBean.getLoginBean()
					.getPageLocale());
			session.put("GLOBAL.M_USER_ID", loginManagedBean.getLoginBean()
					.getUserName());
			session.put("GLOBAL.M_COMP_CODE", loginManagedBean.getLoginBean()
					.getCompanyCode());
			session.put("GLOBAL.M_DIVN_CODE", loginManagedBean.getLoginBean()
					.getDivisionCode());
			session.put("GLOBAL.M_DEPT_CODE", loginManagedBean.getLoginBean()
					.getDepartmentCode());
			session.put("GLOBAL.M_USER_GROUP", userGroup);

			// Added By Haneef: to set default currency Format
			session.put(
					"GLOBAL_DECIMAL_FMT",
					getFcLcCurrencyFormat(connection, loginManagedBean
							.getLoginBean().getCompanyCode()));

			// addded by akash date :- 14-oct-2011 to give notification of
			// password expire
			if (userPasswd == null || userPasswd.trim().isEmpty()) {
				throw new Exception("Password - Required");
			}
			L_USER_SECURITY_CHECK(loginManagedBean);
			loginManagedBean.getLoginBean().setUserLoginCount(0);
			/** check for whether user disable or not * */
			rest_c1 = handler.executeSelectStatement(
					"SELECT USER_DISABLE_FLAG,USER_PASS_EXP_DATE,USER_EMAIL,USER_PASSWD_EXPIRY_YN "
							+ " FROM MENU_USER WHERE USER_ID=?", connection,
					new Object[] { userName });
			if (rest_c1.next()) {
				disbaleFlag = rest_c1.getString("USER_DISABLE_FLAG");
				passExpDate = rest_c1.getDate("USER_PASS_EXP_DATE");
				userEmail = rest_c1.getString("USER_EMAIL");
				USER_PASSWD_EXPIRY_YN = rest_c1
						.getString("USER_PASSWD_EXPIRY_YN");
			}
			if (disbaleFlag != null && "Y".equals(disbaleFlag)) {
				throw new Exception(
						"Account disabled kindly contact System Admin.");

			} else if ("Y".equals(USER_PASSWD_EXPIRY_YN)) {

				if (passExpDate != null) {
					if (new CommonUtils().getCurrentDateAndTime().after(
							passExpDate)) {
						passwordExpired = true;
					}
				}
			}
			CommonUtils.closeCursor(rest_c1);
			/** ------------------------------------** */
			String clientId = loginManagedBean.getLoginBean().getUserName()
					+ Calendar.getInstance().getTimeInMillis();
			session.put("CLIENT_ID", clientId);

			// Binding session binding listener for connection close and removal
			// from pool
			// on session timeout, Added by: sujatha, Dated: 13-Mar-2014
			sessionMap
					.put(PremiaSessionBindingListener.SESSION_LISTENER_KEY,
							new PremiaSessionBindingListener(
									"connectionAgent",
									"CLIENT_ID",
									Messages.getString("login",
											"premia_session_listener_enable_logging"),
									Messages.getString("login",
											"premia_session_listener_log_message_prefix")));

			ControlBean ctrlbean = new ControlBean();
			ctrlbean.setM_USER_ID(loginManagedBean.getLoginBean().getUserName());
			ctrlbean.setM_COMMIT_CODE(loginManagedBean.getLoginBean()
					.getCompanyCode());
			ctrlbean.setM_DIVN_CODE(loginManagedBean.getLoginBean()
					.getDivisionCode());
			ctrlbean.setM_DEPT_CODE(loginManagedBean.getLoginBean()
					.getDepartmentCode());
			ctrlbean.setM_COMP_CODE(loginManagedBean.getLoginBean()
					.getCompanyCode());
			session.put("ctrlbean", ctrlbean);
			setConnection();
			Connection connectLife = null;
			try {
				connectLife = CommonUtils.getConnection();
			} catch (DBException e) {
				throw new LoginException(
						"Connection refused by the application. Please contact your admin, if frequent!");
			}
			defaultLangCode(connectLife, session);
			forLangCode(connectLife, session);
			currencyCode(connectLife, session, compCode);
			session.put("GLOBAL.M_PRIVILEGE", "YYY");
			ctrlbean.setM_LANG_CODE((String) session.get("GLOBAL.M_LANG_CODE"));
			ctrlbean.setM_BASE_CURR((String) session.get("GLOBAL.M_BASE_CURR"));
			DBProcedures.PCOPK_SYS_VARS(connectLife);

			CommonUtils.setGlobalVariable("GLOBAL.M_USER_ID", loginManagedBean
					.getLoginBean().getUserName());

			/* Added by saranya for ssp call id ZBILQC-1721041 on 28-03-2017 */
			CommonUtils.setGlobalVariable("GLOBAL.X_DIVN_CODE",
					loginManagedBean.getLoginBean().getDivisionCode());
			/* End */

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return passwordExpired;
	}

	private static String getFcLcCurrencyFormat(Connection con,
			String companyCode) throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;
		String fetchDecimalsQuery = "SELECT CURR_DECIMAL "
				+ "FROM FM_CURRENCY "
				+ "WHERE CURR_CODE IN (SELECT COMP_BASE_CURR_CODE_1 "
				+ "FROM FM_COMPANY " + "WHERE COMP_CODE = ?)";
		Integer noOfDecimals = null;
		String retPattern = "";

		try {
			// connection = getConnection();
			rs = handler.executeSelectStatement(fetchDecimalsQuery, con,
					new Object[] { companyCode });
			if (rs.next()) {
				noOfDecimals = rs.getInt(1);
			}
			if (noOfDecimals != null) {
				if (1 == noOfDecimals.intValue()) {
					retPattern = "###,###.0";
				}
				if (2 == noOfDecimals.intValue()) {
					retPattern = "###,###.00";
				}
				if (3 == noOfDecimals.intValue()) {
					retPattern = "###,###.000";
				}
				if (4 == noOfDecimals.intValue()) {
					retPattern = "###,###.0000";
				}
				if (5 == noOfDecimals.intValue()) {
					retPattern = "###,###.000000";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return retPattern;

	}

	public String loginAction() {

		String navigateto = null;
		boolean passwordExpired = false;
		loginError = false;
		loginforgot = false;
		
		
		/*Added by Janani on 16.10.2017 for Customer service management*/ 
		
		String user_group_check = null;
		
		/*End*/

		try {
			// Clearing old messages
			CommonUtils.clearMaps(this);
			// Perform validations
			if (validateLogin()) {
				// Attempt to login
				passwordExpired = login();
				if (passwordExpired) {
					// throw new
					// Exception("Your Password Is Expired Please Contact System Admin");
					COM_PANEL_VALUE.setValue("Login Error Message");
					loginforgot = true;
					throw new Exception(
							"Your login password has been expired please contact your administrator");
				} else {
					/* Added by Ram on 27/11/2016 for setting Currency Value */
					loadcurrency();
					/* End */
				
					
					
					/*Added by Janani on 05.10.2017 for Customer service management*/ 

					
					user_group_check = getUserGroup();
					
					System.out.println("user_group_check                 "+user_group_check);
					
					FacesContext facesContext = FacesContext.getCurrentInstance();
					HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
					 System.out.println("session id             "+session.getId());
					 
					String userID = null;
					String sessionID = null;
					
					sessionID = session.getId();
					
					Enumeration e = session.getAttributeNames();
					while (e.hasMoreElements())
					{
					  String attr = (String)e.nextElement();
					  ///System.err.println("      attr  = "+ attr);
					  Object value = session.getValue(attr);
					 // System.err.println("      value = "+ value);
					  
					  if(attr.equalsIgnoreCase("GLOBAL.M_USER_ID"))
					  {
						  userID = (String) value;
					  }
					 
						
					}
					
					/*Added by Janani on 14.03.2018 for FSD_FLA_IL_012 */

					CommonUtils.setGlobalVariable("GLOBAL.SESSIONID",sessionID);
					CommonUtils.setGlobalVariable("GLOBAL.USERID",userID);
					CommonUtils.setGlobalVariable("GLOBAL.USERGROUP",user_group_check);
					/*End of FSD_FLA_IL_012*/
					
					
					/*Handled null by ganesh on 15-02-2018*/
					//if(user_group_check.equalsIgnoreCase("CSM USER"))
						if(user_group_check!=null && user_group_check.equalsIgnoreCase(resourceBundle.getString("csm_user")))
					
					
					{
						HttpServletResponse response = null;
						
						response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
						
						System.out.println("csm_url                   "+resourceBundle.getString("csm_url"));
						
						
						
						userLog();
						
						
						
						
						String token_key = getUserSession(sessionID,userID,user_group_check);
						String csm_url = resourceBundle.getString("csm_url")+"?token_key="+token_key;
						
						System.out.println("csm_url              "+csm_url);
												
						response.sendRedirect(csm_url);
						
						
					}
					else
					{
						navigateto = "success";
					}
					
					
					/*End of Customer service management*/
					
					
					
				}
				// Update cookie
				vcardAction.premiaCookie();
				
				
				

				/*
				 * added by R. Raja on 01-03-2017 for RM018T - FSD_IL_ZB
				 * Life_030_PREMIA Security
				 */
				getICNOFieldlength();
				/* end */

				/* added by raja on 13-04-2017 for set Nationality code */
				setNationlity();
				/* end */

			} else {
				loginError = true;
			}

			/*
			 * added by R. Raja on 14-12-2016 for RM018T - FSD_IL_ZB
			 * Life_030_PREMIA Security
			 */
			
			/*Handled null by ganesh on 15-02-2018*/
			if(user_group_check!=null && !user_group_check.equalsIgnoreCase(resourceBundle.getString("csm_user")))
			{
				System.out.println("user_group_check  not csm      "+user_group_check);
				
		userLog();
		
			}
			/* end */

			String uploadPath = CommonUtils.getLoginImagePath();
			System.out.println("uploadPath      " + uploadPath
					+ getLoginBean().getUserName());
			File uploadServerPath = new File(uploadPath);
			/*
			 * if(uploadServerPath.exists() && (img_name != null && tokens[0] ==
			 * login_userid))
			 */
			if (uploadServerPath.exists()) {

				System.out.println("uploadPath IN LOGIN            "
						+ uploadPath);

				CommonUtils.setGlobalVariable("USER_IMAGE",
						"../../../userprofile/" + getLoginBean().getUserName()
								+ ".jpg");

			} else {
				System.out.println("uploadPath in else part ");

				CommonUtils.setGlobalVariable("USER_IMAGE",
						"./../../resources/images/login/usericon.gif");

			}
			getProCode();
		} catch (Exception exc) {
			/*
			 * exc.printStackTrace(); getErrorMap().put("current1",
			 * exc.getMessage());
			 */
			exc.printStackTrace();
			if (isLoginforgot()) {
				loginforgot = true;
				FacesMessage facesMessage = createFacesMessageForString("Dear User,");
				FacesMessage facesMessage1 = createFacesMessageForString(exc
						.getMessage());
				addFacesMessageToJsfMessages(loginButton, facesMessage);
				addFacesMessageToJsfMessages(loginButton, facesMessage1);
			} else {
				loginError = true;
				FacesMessage facesMessage = createFacesMessageForString(exc
						.getMessage());
				addFacesMessageToJsfMessages(loginButton, facesMessage);
			}
		}
		return navigateto;
	}

	/* Added by Ram on 27/11/2016 for setting Currency Value */
	public void loadcurrency() throws DBException, Exception {
		String base_currency = null;

		ArrayList<String> pValList = new ArrayList<String>();

		pValList = DBProcedures.P_VAL_FINAL_PARAMETER(
				CommonUtils.getConnection(), "BASE.CURR", "E");
		// ('BASE.CURR', :DUMMY.M_BASE_CURR, 'E') ;
		if (pValList != null && pValList.size() > 0) {
			base_currency = pValList.get(0);
		}

		CommonUtils.setGlobalVariable("GLOBAL.CURRENCY_CODE", base_currency);
		CommonUtils.setGlobalObject("CURRENCY",
				makeCurrDecimalglobal(base_currency));

		System.out
				.println("********** ENTER THE MAKECURRDECIMALGLOBAL METHOD **********"
						+ CommonUtils.getGlobalObject("CURRENCY"));
	}

	public int makeCurrDecimalglobal(String currcode) {

		System.out
				.println("********** ENTER THE MAKECURRDECIMALGLOBAL METHOD **********");
		System.out.println("currcode    : " + currcode);

		String query = "SELECT CURR_DECIMAL FROM FM_CURRENCY where CURR_CODE= ?";

		int CURR_DECI = 0;

		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection,
					new Object[] { currcode });
			if (resultSet.next()) {
				CURR_DECI = resultSet.getInt("CURR_DECIMAL");
			}

			System.out.println("CURR_DECI    : " + CURR_DECI);
			CommonUtils.setGlobalObject("GLOBAL.CURR_DECIMAL", CURR_DECI);
			System.out.println("Dhinesh------GLOBAL.CURR_DECIMAL    : "
					+ CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL"));

		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return CURR_DECI;
	}

	/* End */

	public void L_USER_SECURITY_CHECK(LoginManagedBean managedBean)
			throws Exception {
		String USERLOCKED_FLAG = null;
		String USER_PASSWD_EXPIRY_YN = null;
		int EXPIRYDAY = 0;
		int PWD_NOTIFY_DAY = 0;
		ResultSet rst_C1 = null;
		ResultSet rst_C2 = null;
		CRUDHandler handler = null;
		Connection connection = null;
		String M_USER_ID_INPUT = managedBean.getLoginBean().getUserName();
		String sql_C1 = "SELECT   NVL(TRUNC(USER_PASS_EXP_DATE)-TRUNC(SYSDATE),0),   USER_LOCKED_YN,USER_PASSWD_EXPIRY_YN,USER_WARNING_DAYS "
				+ "FROM     MENU_USER " + "WHERE    USER_ID = ?";// M_USER_ID_INPUT

		String sql_C2 = "SELECT   NVL(PS_VALUE,3) " + "FROM  PP_SYSTEM "
				+ " WHERE    PS_TYPE ='PNOTN_DAYS'";
		try {
			connection = getConnection();
			handler = new CRUDHandler();
			rst_C1 = handler.executeSelectStatement(sql_C1, connection,
					new Object[] { M_USER_ID_INPUT });
			if (rst_C1.next()) {
				EXPIRYDAY = rst_C1.getInt(1);
				USERLOCKED_FLAG = rst_C1.getString("USER_LOCKED_YN");
				USER_PASSWD_EXPIRY_YN = rst_C1
						.getString("USER_PASSWD_EXPIRY_YN");
				PWD_NOTIFY_DAY = rst_C1.getInt("USER_WARNING_DAYS");

			} else {
				throw new Exception("Invalid User");
			}
			//CommonUtils.closeCursor(rst_C1);
			/*
			 * rst_C2 = handler.executeSelectStatement(sql_C2, connection, new
			 * Object[] {}); while (rst_C2.next()) { PWD_NOTIFY_DAY =
			 * rst_C2.getInt(1); } CommonUtils.closeCursor(rst_C2);
			 */
			PWD_NOTIFY_DAY = (PWD_NOTIFY_DAY == 0 ? 3 : PWD_NOTIFY_DAY);

			if (("Y".equals(USER_PASSWD_EXPIRY_YN))) {
				if ("Y".equals(USERLOCKED_FLAG))
					throw new Exception(
							"This User is Locked. Contact System Administrator");
				if (EXPIRYDAY >= 0) {
					if (EXPIRYDAY <= PWD_NOTIFY_DAY) {
						if (EXPIRYDAY == 0) {
							PasswordSetupUtility
									.setPASS_EXP_MESSAGE_InSession("Today your Password will expire..");
						} else {
							PasswordSetupUtility
									.setPASS_EXP_MESSAGE_InSession("Your Password will expire in "
											+ EXPIRYDAY + " day(s)");
						}
					}
				}
				// sankar
				/*
				 * else{ throw new Exception(
				 * "Your Password  is Expired Please Contact System admin"); }
				 */

			}
		} finally {
			CommonUtils.closeCursor(rst_C1);
			CommonUtils.closeCursor(rst_C2);
			if (!connection.isClosed())
				connection.close();
		}
	}

	public boolean validateUser() throws LoginException {
		// [BugId:PREMIAGDC-264921 mmuthu 04-Jan-09 Hardcoded password for
		// DECRYPT function is removed and getting from DECRYPT function
		String query = "SELECT DECRYPT(USER_PASSWD,'3iInfotech') USER_PASSWORD FROM MENU_USER WHERE USER_ID=?";
		// BugId:PREMIAGDC-264921 mmuthu 04-Jan-09 Hardcoded password for
		// DECRYPT function is removed and getting from DECRYPT function ]
		LoginManagedBean loginManagedBean = (LoginManagedBean) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("loginManagedBean");
		String userId = loginManagedBean.getLoginBean().getUserName();
		String password = loginManagedBean.getLoginBean().getPassword();
		if (userId != null) {
			if (password != null) {
				CRUDHandler handler = new CRUDHandler();
				Connection connection = (Connection) FacesContext
						.getCurrentInstance().getExternalContext()
						.getSessionMap().get("CONNECTION.LOGIN");
				String dbPassword = null;
				ResultSet rst = null;
				try {
					rst = handler.executeSelectStatement(query, connection,
							new Object[] { userId });
					while (rst.next()) {
						dbPassword = rst.getString(1);
					}
				} catch (Exception e) {
					throw new LoginException(Messages.getMessage("login",
							"login1001"));
				} finally {
					try {
						CommonUtils.closeCursor(rst);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (password.equals(dbPassword)) {
					return true;
				}
			}
		}
		return false;
	}

	public void setConnection() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		String userId = (String) sessionMap.get("GLOBAL.M_USER_ID");
		ServletContext context = (ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext();
		String clientId = userId + Calendar.getInstance().getTimeInMillis();
		try {
			((SimpleConnectionAgent) context.getAttribute("connectionAgent"))
					.getConnection(clientId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionMap.put("CLIENT_ID", clientId);
	}

	public void setLoginConnection() {
		Connection connection = null;
		try {
			// [ Updated to avoid duplicate code, Date: 21-Oct-2011, Updated by:
			// Yalamanda/Manoj
			connection = getConnection();
			connection.setAutoCommit(false);
			// Updated to avoid duplicate code, Date: 21-Oct-2011, Updated by:
			// Yalamanda/Manoj ]
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.put("CONNECTION.LOGIN", connection);
		isLoginConnectionSet = true;
	}

	public HtmlSimpleTogglePanel getMessagePanel() {
		return messagePanel;
	}

	public void setMessagePanel(HtmlSimpleTogglePanel messagePanel) {
		this.messagePanel = messagePanel;
	}

	public boolean isValidUserName() {
		return validUserName;
	}

	public void setValidUserName(boolean validUserName) {
		this.validUserName = validUserName;
	}

	public boolean isValidPassword() {
		return validPassword;
	}

	public void setValidPassword(boolean validPassword) {
		this.validPassword = validPassword;
	}

	public boolean isValidCompCode() {
		return validCompCode;
	}

	public void setValidCompCode(boolean validCompCode) {
		this.validCompCode = validCompCode;
	}

	public boolean isValidDivisionCode() {
		return validDivisionCode;
	}

	public void setValidDivisionCode(boolean validDivisionCode) {
		this.validDivisionCode = validDivisionCode;
	}

	public boolean isValidDepartmentCode() {
		return validDepartmentCode;
	}

	public void setValidDepartmentCode(boolean validDepartmentCode) {
		this.validDepartmentCode = validDepartmentCode;
	}

	public void defaultLangCode(Connection connection,
			Map<String, Object> session) {
		String query = "SELECT SUBSTR(P_VALUE,1,3) FROM MENU_PARAMETER WHERE  P_ID = 'DFLT_LANG'";
		String langCode = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst = null;
		try {
			rst = handler.executeSelectStatement(query, connection,
					new Object[] {});
			while (rst.next()) {
				langCode = rst.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		session.put("GLOBAL.M_LANG_CODE", langCode);
	}

	public void forLangCode(Connection connection, Map<String, Object> session) {
		String query = "SELECT SUBSTR(P_VALUE,1,3) FROM   MENU_PARAMETER WHERE  P_ID = 'FOR_LANG'";
		String forLangCode = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst = null;
		try {
			rst = handler.executeSelectStatement(query, connection,
					new Object[] {});
			while (rst.next()) {
				forLangCode = rst.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		session.put("GLOBAL.M_FOR_LANG_CODE", forLangCode);
	}

	public void noOfDec(Connection connection, Map<String, Object> session) {
		String query = "SELECT CURR_DECIMAL FROM FM_CURRENCY WHERE CURR_COMP_CODE=? AND CURR_1_YN='Y' AND CURR_CODE=?";
		String currDec = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst = null;
		try {
			rst = handler.executeSelectStatement(
					query,
					connection,
					new Object[] { session.get("GLOBAL.M_COMP_CODE"),
							session.get("GLOBAL.M_BASE_CURR") });
			while (rst.next()) {
				currDec = rst.getString("CURR_DECIMAL");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		session.put("GLOBAL.M_NOOF_DEC", currDec);
	}

	public void currencyCode(Connection connection,
			Map<String, Object> session, String compCode) throws Exception {
		// String query = "SELECT PARA_VALUE FROM FP_PARAMETER WHERE PARA_ID =
		// 'BASE.CURR'";
		String query = "SELECT PARA_VALUE FROM FP_PARAMETER WHERE PARA_ID = ?";
		// Base_Curr changes PREMIAGDC-0030 helperF_GET_BASE_CURRENCY added
		String P_CURR_CODE = null;
		String P_NAME = null;
		int P_DECIMAL = -1;
		DBProcedures procedures = new DBProcedures();
		String currCode = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst = null;

		// Base_Curr changes PREMIAGDC-0030 helperF_GET_BASE_CURRENCY added

		try {
			ArrayList<String> list = procedures.helperF_GET_BASE_CURRENCY(
					CommonUtils.getGlobalVariable("GLOBAL.M_COMP_CODE"), "N",
					P_CURR_CODE, P_NAME, P_DECIMAL + "", "E");
			if (list != null && list.size() > 0) {
				P_CURR_CODE = list.get(0);
				P_NAME = list.get(1);
				P_DECIMAL = CommonUtils.parseToInt(list.get(2));
				session.put("GLOBAL.M_BASE_CURR", P_CURR_CODE);
			}
			// Commented
			/*
			 * Object[] values = { P_CURR_CODE }; rst =
			 * handler.executeSelectStatement(query, connection, values);
			 * while(rst.next()){ currCode = rst.getString("PARA_VALUE"); }
			 * session.put("GLOBAL.M_BASE_CURR", currCode);
			 */
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void setDefaultUser(PhaseEvent event) {
		// Commented for China patch Nov-17-2008, Commented by: 53057
		getLoginBean().setUserName("LIFEALL");
		getLoginBean().setPassword("PEL");
		getLoginBean().setCompanyCode("001");
		getLoginBean().setDivisionCode("HO");
		getLoginBean().setDepartmentCode("ADM");
		/*
		 * Map<String, Object> sessionMap =
		 * FacesContext.getCurrentInstance().getExternalContext
		 * ().getSessionMap(); sessionMap.put("GLOBAL.M_USER_ID", "LIFEALL");
		 * sessionMap.put("GLOBAL.M_COMP_CODE", "001");
		 * sessionMap.put("GLOBAL.M_DIVN_CODE", "HO");
		 * sessionMap.put("GLOBAL.M_DEPT_CODE", "ADM");
		 * sessionMap.put("GLOBAL.M_DEPT_CODE", "ADM");
		 */
	}

	public static int getLoginCount() {
		return loginCount;
	}

	public static void setLoginCount(int loginCount) {
		LoginManagedBean.loginCount = loginCount;
	}

	public HtmlCommandButton getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(HtmlCommandButton loginButton) {
		this.loginButton = loginButton;
	}

	public HtmlCommandButton getResetButton() {
		return resetButton;
	}

	public void setResetButton(HtmlCommandButton resetButton) {
		this.resetButton = resetButton;
	}

	public boolean isLoginConnectionSet() {
		return isLoginConnectionSet;
	}

	public void setLoginConnectionSet(boolean isLoginConnectionSet) {
		this.isLoginConnectionSet = isLoginConnectionSet;
	}

	public HtmlSelectOneMenu getLanguage() {
		return language;
	}

	public void setLanguage(HtmlSelectOneMenu language) {
		this.language = language;
	}

	public VcardAction getVcardAction() {
		return vcardAction;
	}

	public void setVcardAction(VcardAction vcardAction) {
		this.vcardAction = vcardAction;
	}

	// add to putting the error messages in jsf messages
	private boolean validateLogin() throws Exception {

		System.out.println("  ENTER validateLogin METHOD ");
		boolean isLoginCreadentialsValid = true;

		try {
			System.out.println("UserName    : " + getLoginBean().getUserName());
			validateUserName(FacesContext.getCurrentInstance(), userName,
					getLoginBean().getUserName());
		} catch (ValidatorException ve) {
			isLoginCreadentialsValid = false;
			addValidatorExceptionToJsfMessages(userName, ve);
		}
		try {
			System.out.println("Password    : " + getLoginBean().getPassword());
			validatePassword(FacesContext.getCurrentInstance(), password,
					getLoginBean().getPassword());
		} catch (ValidatorException ve) {
			isLoginCreadentialsValid = false;
			addValidatorExceptionToJsfMessages(password, ve);
		}
		// Other credential check to be suppressed if user is locked
		if (!isUserLock) {
			try {
				System.out.println("CompanyCode    : "
						+ getLoginBean().getCompanyCode());
				validateCompCode(FacesContext.getCurrentInstance(),
						companyCodeBox, getLoginBean().getCompanyCode());
			} catch (ValidatorException ve) {
				ve.printStackTrace();
				isLoginCreadentialsValid = false;
				addValidatorExceptionToJsfMessages(companyCodeBox, ve);
			}
			try {
				System.out.println("DivisionCode    : "
						+ getLoginBean().getDivisionCode());
				validateDivnCode(FacesContext.getCurrentInstance(),
						divisionCodeBox, getLoginBean().getDivisionCode());
			} catch (ValidatorException ve) {
				ve.printStackTrace();
				isLoginCreadentialsValid = false;
				addValidatorExceptionToJsfMessages(divisionCodeBox, ve);
			}
			try {
				System.out.println("DepartmentCode    : "
						+ getLoginBean().getDepartmentCode());
				validateDeptCode(FacesContext.getCurrentInstance(),
						departmentCodeBox, getLoginBean().getDepartmentCode());
			} catch (ValidatorException ve) {
				ve.printStackTrace();
				isLoginCreadentialsValid = false;
				addValidatorExceptionToJsfMessages(departmentCodeBox, ve);
			}
		}
		System.out.println("isLoginCreadentialsValid     "
				+ isLoginCreadentialsValid);
		return isLoginCreadentialsValid;
	}

	private void addValidatorExceptionToJsfMessages(UIInput component,
			ValidatorException exception) {
		String validatorMessageString = component.getValidatorMessage();
		FacesMessage message = null;

		component.setValid(false);
		if (null != validatorMessageString) {
			message = createFacesMessageForString(validatorMessageString);
		} else {
			message = exception.getFacesMessage();
		}
		addFacesMessageToJsfMessages(component, message);
	}

	private void addFacesMessageToJsfMessages(UIComponent component,
			FacesMessage facesMessage) {
		FacesContext facesContext = FacesContext.getCurrentInstance();

		if (facesMessage != null) {
			facesContext.addMessage(component.getClientId(facesContext),
					facesMessage);
		}
	}

	private FacesMessage createFacesMessageForString(String message) {
		FacesMessage facesMessage = null;

		facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message,
				message);
		facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);

		return facesMessage;
	}

	// Method add to reset values...

	public String resetValue() {
		String outcome = "";
		System.out.println("hi this is reset value");
		getLoginBean().setUserName(null);
		getLoginBean().setPassword(null);

		/* commennted R Raja for company code not reset */
		/* getLoginBean().setCompanyCode(null); */
		/* end */
		getLoginBean().setDivisionCode(null);
		getLoginBean().setDepartmentCode(null);
		// userName.resetValue();
		password.resetValue();
		companyCodeBox.resetValue();
		divisionCodeBox.resetValue();
		departmentCodeBox.resetValue();
		loginError = false;
		loginforgot = false;

		return outcome;
	}

	public boolean isUserLock() {
		return isUserLock;
	}

	public void setUserLock(boolean isUserLock) {
		this.isUserLock = isUserLock;
	}

	public LoginVirtualKeyboardAction getLoginVirtualKeyboardAction() {
		return loginVirtualKeyboardAction;
	}

	public void setLoginVirtualKeyboardAction(
			LoginVirtualKeyboardAction loginVirtualKeyboardAction) {
		this.loginVirtualKeyboardAction = loginVirtualKeyboardAction;
	}

	public boolean isLoginError() {
		return loginError;
	}

	public void setLoginError(boolean loginError) {
		this.loginError = loginError;
	}

	public HtmlAjaxCommandButton getVcardButton() {
		return vcardButton;
	}

	public void setVcardButton(HtmlAjaxCommandButton vcardButton) {
		this.vcardButton = vcardButton;
	}

	/*
	 * newly added the following code by sujatha
	 */

	private String loginLocale;

	public String getLoginLocale() {
		return loginLocale;
	}

	public void setLoginLocale(String loginLocale) {
		this.loginLocale = loginLocale;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	// value change event listener
	public void localeChanged(ValueChangeEvent e) {
		String newLocaleValue = e.getNewValue().toString();

		System.out.println("newLocaleValue            :" + newLocaleValue);

		List<SelectItem> list = langConst.getLangCodeList();
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getValue().equals(newLocaleValue)) {
					/*
					 * FacesContext.getCurrentInstance()
					 * .getViewRoot().setLocale((Locale)list.get(i).getValue());
					 */
					setLoginLocale((String) list.get(i).getValue());
				}
			}

		}

	}

	/* added by gopi for forgot password */

	public boolean forgotAction() {
		boolean isLoginCreadentialsValid = true;
		try {
			System.out.println("UserName    : " + getLoginBean().getUserName());
			validateUserName(FacesContext.getCurrentInstance(), userName,
					getLoginBean().getUserName());
		} catch (ValidatorException ve) {
			isLoginCreadentialsValid = false;
			addValidatorExceptionToJsfMessages(userName, ve);
		}
		return isLoginCreadentialsValid;
	}

	public String sendmail() throws Exception {

		System.out.println("**********entering into sendmail**********");
		loginforgot = false;
		String navigateto = null;
		// boolean passwordExpired =
		// logincookie();
		try {
			if (forgotAction()) {
				if ("Y".equals(emailTriggerProcCall("0", "FGP",
						loginBean.getUserName()))) {
					COM_PANEL_VALUE.setValue("Forgot password Message");
					throw new Exception("You will receive a mail shortly");
				} else {
					COM_PANEL_VALUE.setValue("Forgot password Message");
					throw new Exception(
							"Kindly contact your administrator to change your password");
				}
				// getErrorMap().put("current","Dear User kindly contact your administrator to change your password");
				// navigateto = "PM290_RESET_EXPIRED_PASSWORD";
			}

		} catch (Exception exc) {
			/*
			 * exc.printStackTrace(); getErrorMap().put("current1",
			 * exc.getMessage());
			 */
			loginforgot = true;
			loginError = false;
			FacesMessage facesMessage = createFacesMessageForString("Dear User,");
			FacesMessage facesMessage1 = createFacesMessageForString(exc
					.getMessage());

			addFacesMessageToJsfMessages(forgotButton, facesMessage);
			addFacesMessageToJsfMessages(forgotButton, facesMessage1);
		}
		return navigateto;

	}

	public String emailTriggerProcCall(String P_PROD_CODE, String P_MAIL_TYPE,
			String P_USER_ID) throws Exception {
		String subject = "SELECT PMT_PROD_CODE,PMT_MAIL_SUB,PMT_MAIL_TEXT FROM PM_LIFE_MAIL_TEMPLATE WHERE PMT_MAIL_TYPE = 'FGP'";
		String tomail = "SELECT USER_EMAIL_ID FROM MENU_USER WHERE USER_ID= ?";
		String insert = "INSERT INTO PW_LIFE_EMAIL_DATA (PLED_SRNO, PLED_TYPE, PLED_TO, PLED_SUB, PLED_BODY, PLED_STATUS) VALUES (PIL_MAIL_SYS_ID.NEXTVAL,?,?,?,?,?)";
		String out = "N";
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		Object[] values = { P_USER_ID };
		int seqno = 0;
		String productcode = null;
		String sub = null;
		String body = null;
		String mailid = null;
		Connection con = getConnection();
		System.out.println("Connection :" + con);

		rs2 = new CRUDHandler().executeSelectStatement(subject, con);
		rs3 = new CRUDHandler().executeSelectStatement(tomail, con, values);

		if (rs2.next()) {
			productcode = rs2.getString("PMT_PROD_CODE");
			sub = rs2.getString("PMT_MAIL_SUB");
			body = rs2.getString("PMT_MAIL_TEXT");
		}
		if (rs3.next()) {
			mailid = rs3.getString("USER_EMAIL_ID");
			if (mailid != null) {
				out = "Y";
			}
		}
		System.out.println("seqno  :" + seqno);
		System.out.println("mailid  :" + mailid);
		System.out.println("sub  :" + sub);
		System.out.println("body  :" + body);
		Object[] values1 = { "FGP", mailid, sub, body, "N" };
		new CRUDHandler().executeInsertStatement(insert, con, values1);
		con.commit();
		/*
		 * Connection con=CommonUtils.getConnection();
		 * System.out.println("P_MAIL_TYPE-->"+P_MAIL_TYPE); String out="";
		 * ArrayList<OracleParameter> parameterList = new
		 * ArrayList<OracleParameter>(); ArrayList<OracleParameter> outputList =
		 * new ArrayList<OracleParameter>(); OracleParameter param1 = new
		 * OracleParameter("IN1", "STRING", "IN",P_PROD_CODE);
		 * parameterList.add(param1); OracleParameter param2 = new
		 * OracleParameter("IN2", "STRING", "IN",P_MAIL_TYPE);
		 * parameterList.add(param2); OracleParameter param3 = new
		 * OracleParameter("IN3", "STRING", "IN",P_USER_ID);
		 * parameterList.add(param3); OracleParameter param4 = new
		 * OracleParameter("OUT1", "STRING", "OUT",out);
		 * parameterList.add(param4); OracleProcedureHandler procHandler = new
		 * OracleProcedureHandler(); outputList =
		 * procHandler.execute(parameterList, con, "P_MAIL_TEMP");
		 * CommonUtils.doComitt(); Iterator<OracleParameter> iterator =
		 * outputList.iterator(); while (iterator.hasNext()) { OracleParameter
		 * oracleParameter = iterator.next();
		 * System.out.println("Output value:::" + oracleParameter.getValue());
		 * out=(String)oracleParameter.getValue(); }
		 */

		return out;
	}

	private void logincookie() throws Exception {
		boolean passwordExpired = false;
		String disbaleFlag = null;
		Date passExpDate = null;
		String userEmail = null;
		String USER_PASSWD_EXPIRY_YN = null;
		String userGroup = null;
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		ResultSet rest_c1 = null;
		try {
			LoginManagedBean loginManagedBean = (LoginManagedBean) FacesContext
					.getCurrentInstance().getExternalContext().getSessionMap()
					.get("loginManagedBean");
			System.out.println("Locale: >>>>>>>>>>>>>>>>>>>>"
					+ loginManagedBean.getLoginBean().getPageLocale());
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			String userName = loginManagedBean.getLoginBean().getUserName();
			String compCode = loginManagedBean.getLoginBean().getCompanyCode();
			String divisionCode = loginManagedBean.getLoginBean()
					.getDivisionCode();
			String departCode = loginManagedBean.getLoginBean()
					.getDepartmentCode();
			String userAdmin = loginManagedBean.getLoginBean()
					.getUserAdministrator();
			String userPasswd = loginManagedBean.getLoginBean().getPassword();

			System.out.println("userName       : " + userName);
			System.out.println("compCode       : " + compCode);
			System.out.println("divisionCode   : " + divisionCode);
			System.out.println("departCode     : " + departCode);
			System.out.println("userAdmin      : " + userAdmin);
			System.out.println("userPasswd     : " + userPasswd);

			Map<String, Object> session = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			session.put("pageLocale", loginManagedBean.getLoginBean()
					.getPageLocale());
			session.put("GLOBAL.M_USER_ID", loginManagedBean.getLoginBean()
					.getUserName());
			session.put("GLOBAL.M_COMP_CODE", loginManagedBean.getLoginBean()
					.getCompanyCode());
			session.put("GLOBAL.M_DIVN_CODE", loginManagedBean.getLoginBean()
					.getDivisionCode());
			session.put("GLOBAL.M_DEPT_CODE", loginManagedBean.getLoginBean()
					.getDepartmentCode());
			session.put("GLOBAL.M_USER_GROUP", userGroup);

			String clientId = loginManagedBean.getLoginBean().getUserName()
					+ Calendar.getInstance().getTimeInMillis();
			session.put("CLIENT_ID", clientId);

			// Binding session binding listener for connection close and removal
			// from pool
			// on session timeout, Added by: sujatha, Dated: 13-Mar-2014
			sessionMap
					.put(PremiaSessionBindingListener.SESSION_LISTENER_KEY,
							new PremiaSessionBindingListener(
									"connectionAgent",
									"CLIENT_ID",
									Messages.getString("login",
											"premia_session_listener_enable_logging"),
									Messages.getString("login",
											"premia_session_listener_log_message_prefix")));

			ControlBean ctrlbean = new ControlBean();
			ctrlbean.setM_USER_ID(loginManagedBean.getLoginBean().getUserName());
			ctrlbean.setM_COMMIT_CODE(loginManagedBean.getLoginBean()
					.getCompanyCode());
			ctrlbean.setM_DIVN_CODE(loginManagedBean.getLoginBean()
					.getDivisionCode());
			ctrlbean.setM_DEPT_CODE(loginManagedBean.getLoginBean()
					.getDepartmentCode());
			ctrlbean.setM_COMP_CODE(loginManagedBean.getLoginBean()
					.getCompanyCode());
			session.put("ctrlbean", ctrlbean);
			setConnection();
			Connection connectLife = null;
			try {
				connectLife = CommonUtils.getConnection();
			} catch (DBException e) {
				throw new LoginException(
						"Connection refused by the application. Please contact your admin, if frequent!");
			}
			defaultLangCode(connectLife, session);
			forLangCode(connectLife, session);
			currencyCode(connectLife, session, compCode);
			session.put("GLOBAL.M_PRIVILEGE", "YYY");
			ctrlbean.setM_LANG_CODE((String) session.get("GLOBAL.M_LANG_CODE"));
			ctrlbean.setM_BASE_CURR((String) session.get("GLOBAL.M_BASE_CURR"));
			DBProcedures.PCOPK_SYS_VARS(connectLife);

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		// return passwordExpired;
	}

	/* end */

	/* Added by Ram on 30/11/2016 for Display error Message in label */
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	private HtmlOutputLabel COMP_ERROR_MESSAGE;

	public HtmlOutputLabel getCOMP_ERROR_MESSAGE() {
		return COMP_ERROR_MESSAGE;
	}

	public void setCOMP_ERROR_MESSAGE(HtmlOutputLabel cOMP_ERROR_MESSAGE) {
		COMP_ERROR_MESSAGE = cOMP_ERROR_MESSAGE;
	}

	/* End */

	/*
	 * added by R. Raja on 14-12-2016 for RM018T - FSD_IL_ZB Life_030_PREMIA
	 * Security
	 */

	public void userLog() {
		System.out.println("Inside user login");
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) context
					.getExternalContext().getRequest();
			
			String ipaddress = request.getRemoteAddr();
			System.out.println("ipaddress   >" + ipaddress);
			InetAddress addr = InetAddress.getByName(ipaddress);
			String host = addr.getHostName();
			System.out.println("hostname   >" + host);
			loginBean.setMUL_IP_ADD(ipaddress);
			loginBean.setMUL_SESSION_ID(host.toUpperCase());
			
			/*Added by Janani on 19.12.2017 for CSM*/
			System.out.println("getRequestedSessionId                 "+request.getRequestedSessionId());
			loginBean.setMUL_REQ_SESSION_ID(request.getRequestedSessionId());
			
			/*ENd*/
			
			new CRUDHandler().executeInsert(loginBean,
					CommonUtils.getConnection());
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* end */

	/*
	 * Added by raja on 01-03-2017 for IC no length validation ssp call id
	 * FALCONLIFE-1344818
	 */

	public int ICnoLength() {
		System.out.println("enters into ICnoLength");

		int M_PS_VALUE = 0;
		try {
			String query = "SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE = 'CUSTREFFMT'";
			ResultSet resultSet = null;

			CRUDHandler handler = new CRUDHandler();
			CommonUtils commonUtils = new CommonUtils();
			Connection connection = null;

			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection);

			while (resultSet.next()) {
				M_PS_VALUE = resultSet.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		CommonUtils.setGlobalObject("M_PS_VALUE", M_PS_VALUE);

		System.out
				.println("M_PS_VALUE in menutoolbar                           "
						+ CommonUtils.getGlobalObject("M_PS_VALUE"));

		return M_PS_VALUE;
	}

	public void getICNOFieldlength() {
		String query = "SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_CODE LIKE ?";

		int M_PS_VALUE = ICnoLength();

		Object[] values = { M_PS_VALUE };
		CRUDHandler handler = new CRUDHandler();
		ResultSet lengthResultset = null;
		String message = null;
		int fieldLength = 0;
		try {
			Connection conn = CommonUtils.getConnection();
			lengthResultset = handler.executeSelectStatement(query, conn,
					new Object[] { "REF_ID_" + M_PS_VALUE });
			if (lengthResultset.next()) {
				fieldLength = lengthResultset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}

		CommonUtils.setGlobalObject("FIELD_LENGTH", fieldLength);
		System.out
				.println("FIELD_LENGTH in menutoolbar                           "
						+ CommonUtils.getGlobalObject("FIELD_LENGTH"));

	}

	/* end */

	private HtmlCommandButton resetpasswordButton;

	public HtmlCommandButton getResetpasswordButton() {
		return resetpasswordButton;
	}

	public void setResetpasswordButton(HtmlCommandButton resetpasswordButton) {
		this.resetpasswordButton = resetpasswordButton;
	}

	private String expiry_YN;

	public String getExpiry_YN() {
		return expiry_YN;
	}

	public void setExpiry_YN(String expiry_YN) {
		this.expiry_YN = expiry_YN;
	}

	public String resetpasswordsendmail() throws Exception {

		System.out.println("**********entering into sendmail**********");
		loginforgot = false;
		String navigateto = null;
		// boolean passwordExpired =
		// logincookie();

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		Connection connection = (Connection) sessionMap.get("CONNECTION.LOGIN");
		String password_query = null;
		String email_query = null;
		String email = null;
		ResultSet resultset = null;
		try {
			if (resetAction()) {

				String password = generatePassword();
				int login_expiry_days_count = 0;
				System.out.println("password  ====>" + password);
				Date expiry_date = null;
				String encrypt_password = encryptPasswordForSaving(password);

				email_query = "SELECT USER_EMAIL_ID,USER_EXPIRY_DAY_COUNT FROM MENU_USER WHERE USER_ID=?";
				resultset = new CRUDHandler().executeSelectStatement(
						email_query, connection,
						new Object[] { loginBean.getUserName() });

				while (resultset.next()) {
					email = resultset.getString("USER_EMAIL_ID");
					login_expiry_days_count = resultset
							.getInt("USER_EXPIRY_DAY_COUNT");
				}

				expiry_date = CommonUtils.addDate(
						new CommonUtils().getCurrentDate(),
						login_expiry_days_count);

				password_query = "UPDATE MENU_USER SET USER_PASSWD=?,USER_PASS_EXP_DATE=? WHERE USER_ID=?";
				new CRUDHandler().executeUpdateStatement(password_query,
						connection, new Object[] { encrypt_password,
								expiry_date, loginBean.getUserName() });

				if ("Y".equals(Email_Procedure_Call.emailTriggerProcCall("0",
						"RSP", null, "R", loginBean.getUserName(), connection))) {

					getResetpasswordButton().setStyle("display:none");
					getForgotButton().setStyle("display:block");

					COM_PANEL_VALUE.setValue("Reset password Message");
					throw new Exception(
							"Your Password is expired and it has been reseted. Your new password is sent to your email id "
									+ email);
				} else {

					getResetpasswordButton().setStyle("display:none");
					getForgotButton().setStyle("display:block");

					COM_PANEL_VALUE.setValue("Reset password Message");
					throw new Exception(
							"Kindly contact your administrator to change your password");
				}
				// getErrorMap().put("current","Dear User kindly contact your administrator to change your password");
				// navigateto = "PM290_RESET_EXPIRED_PASSWORD";
			}

		} catch (Exception exc) {
			/*
			 * exc.printStackTrace(); getErrorMap().put("current1",
			 * exc.getMessage());
			 */
			loginforgot = true;
			loginError = false;
			FacesMessage facesMessage = createFacesMessageForString("Dear User,");
			FacesMessage facesMessage1 = createFacesMessageForString(exc
					.getMessage());

			addFacesMessageToJsfMessages(forgotButton, facesMessage);
			addFacesMessageToJsfMessages(forgotButton, facesMessage1);
		}
		return navigateto;

	}

	public boolean resetAction() {
		boolean isLoginCreadentialsValid = true;
		try {
			System.out.println("UserName    : " + getLoginBean().getUserName());
			validateUserName(FacesContext.getCurrentInstance(), userName,
					getLoginBean().getUserName());
		} catch (ValidatorException ve) {
			isLoginCreadentialsValid = false;
			addValidatorExceptionToJsfMessages(userName, ve);
		}
		return isLoginCreadentialsValid;
	}

	boolean resetpasswordflag = false;

	public void reset_password_validation() {

		String expiry_YN = null;
		Date Expiry_Date = null;
		try {

			/* added by raja on 13-04-2017 for reset password button */
			getResetpasswordButton().setStyle("display:none");
			getForgotButton().setStyle("display:block");
			/* end */

			Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			Connection connection = (Connection) sessionMap
					.get("CONNECTION.LOGIN");
			ResultSet rest_c1 = null;
			rest_c1 = new CRUDHandler()
					.executeSelectStatement(
							"SELECT USER_PASSWD_EXPIRY_YN,USER_PASS_EXP_DATE FROM MENU_USER WHERE USER_ID=?",
							connection,
							new Object[] { loginBean.getUserName() });
			if (rest_c1.next()) {

				/*
				 * setExpiry_YN(rest_c1 .getString("USER_PASSWD_EXPIRY_YN"));
				 */
				expiry_YN = rest_c1.getString("USER_PASSWD_EXPIRY_YN");
				Expiry_Date = rest_c1.getDate("USER_PASS_EXP_DATE");
			}

			System.out.println("expiry_YN =====> " + expiry_YN
					+ "      ,  Expiry_Date ====>" + Expiry_Date);

			if (resetpasswordflag == false) {
				if (expiry_YN != null && expiry_YN.equalsIgnoreCase("Y")) {
					if (Expiry_Date != null
							&& new CommonUtils().getCurrentDateAndTime().after(
									Expiry_Date)) {
						// getResetpasswordButton().setStyle("display:block");
						// getForgotButton().setStyle("display:none");
						getCOMP_RESET_PASSWORD_MODAL_PANEL()
								.setShowWhenRendered(true);
					} else {
						// getResetpasswordButton().setStyle("display:none");
						// getForgotButton().setStyle("display:block");
						getCOMP_RESET_PASSWORD_MODAL_PANEL()
								.setShowWhenRendered(false);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String callModelPanel() {

		System.out.println("**********entering into sendmail**********");
		loginforgot = false;
		String navigateto = null;
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		Connection connection = (Connection) sessionMap.get("CONNECTION.LOGIN");
		try {
			if (resetAction()) {
				COM_PANEL_VALUE.setValue("Reset password Message");
				throw new Exception(
						"Your password is expired please click the resetpassword button");
			}

		} catch (Exception exc) {

			loginforgot = true;
			loginError = false;
			FacesMessage facesMessage = createFacesMessageForString("Dear User,");
			FacesMessage facesMessage1 = createFacesMessageForString(exc
					.getMessage());

			addFacesMessageToJsfMessages(forgotButton, facesMessage);
			addFacesMessageToJsfMessages(forgotButton, facesMessage1);
		}
		return navigateto;

	}

	public String generatePassword() {

		String passwordChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@#$%&";
		StringBuffer passwordStrBuffer = new StringBuffer();
		java.util.Random rnd = new java.util.Random();
		// build a random captchaLength chars salt
		while (passwordStrBuffer.length() < 8) {
			int index = (int) (rnd.nextFloat() * passwordChars.length());
			passwordStrBuffer.append(passwordChars.substring(index, index + 1));
		}
		return passwordStrBuffer.toString();
	}

	public String encryptPasswordForSaving(String password) throws Exception {

		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;
		String encryptedPassword = null;

		String query = GNMNF005_A_APAC_SQL_QUERY_CONSTANTS.GNMNF005_A_APAC_ENCRYPTING_PASSWORD_QUERY;
		Object[] values = { password };

		try {

			Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			connection = (Connection) sessionMap.get("CONNECTION.LOGIN");

			resultSet = handler.executeSelectStatement(query, connection,
					values);

			if (resultSet.next()) {

				encryptedPassword = resultSet.getString("ENCPT_PWD");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		} finally {

			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return encryptedPassword;

	}

	private HtmlModalPanel COMP_RESET_PASSWORD_MODAL_PANEL;

	private HtmlAjaxCommandButton COMP_CANCEL_BUTTON;
	private HtmlAjaxCommandButton COMP_OK_BUTTON;

	public HtmlAjaxCommandButton getCOMP_CANCEL_BUTTON() {
		return COMP_CANCEL_BUTTON;
	}

	public void setCOMP_CANCEL_BUTTON(HtmlAjaxCommandButton cOMP_CANCEL_BUTTON) {
		COMP_CANCEL_BUTTON = cOMP_CANCEL_BUTTON;
	}

	public HtmlAjaxCommandButton getCOMP_OK_BUTTON() {
		return COMP_OK_BUTTON;
	}

	public void setCOMP_OK_BUTTON(HtmlAjaxCommandButton cOMP_OK_BUTTON) {
		COMP_OK_BUTTON = cOMP_OK_BUTTON;
	}

	public HtmlModalPanel getCOMP_RESET_PASSWORD_MODAL_PANEL() {
		return COMP_RESET_PASSWORD_MODAL_PANEL;
	}

	public void setCOMP_RESET_PASSWORD_MODAL_PANEL(
			HtmlModalPanel cOMP_RESET_PASSWORD_MODAL_PANEL) {
		COMP_RESET_PASSWORD_MODAL_PANEL = cOMP_RESET_PASSWORD_MODAL_PANEL;
	}

	public String CancelPanelDelete() {
		System.out.println("enter into the cancel model panal");
		getCOMP_RESET_PASSWORD_MODAL_PANEL().setShowWhenRendered(false);
		return "";
	}

	public String showresetbutton() {
		System.out.println("enter into the showresetbutton model panal");
		resetpasswordflag = true;

		getResetpasswordButton().setStyle("display:block");
		getForgotButton().setStyle("display:none");

		getCOMP_RESET_PASSWORD_MODAL_PANEL().setShowWhenRendered(false);
		return "";
	}

	/* added by raja on 13-04-2017 for reset passsword button */
	public void fireFieldValidation_resetPassword(ActionEvent actionEvent) {

		try {

			UIInput input = (UIInput) actionEvent.getComponent().getParent();

			loginBean.setUserName((String) input.getSubmittedValue());
			/* Added by Raja on 05/04/2017 for PasswordReset concept */
			reset_password_validation();
			// callModelPanel();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* end */

	/* added by raja on 13-04-2017 for set Nationlity */
	public void setNationlity() {
		try {
			String Nationlity = null;
			String Query = "SELECT COMP_DEF_NATION FROM PM_COMPANY";
			ResultSet resultSet = new CRUDHandler().executeSelectStatement(
					Query, CommonUtils.getConnection());
			while (resultSet.next()) {
				Nationlity = resultSet.getString("COMP_DEF_NATION");
			}
			if (Nationlity != null) {
				CommonUtils.setGlobalVariable("GLOBAL.M_NATIONLITY_CODE",
						Nationlity);
			}
			System.out
					.println("Nationality  ==> "
							+ CommonUtils
									.getGlobalVariable("GLOBAL.M_NATIONLITY_CODE"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/* end */

	/* Addedb by Raja on 29.04.2017 for handson points */

	public String forgotpasswordsendmail() throws Exception {

		System.out.println("**********entering into sendmail**********");
		loginforgot = false;
		String navigateto = null;
		// boolean passwordExpired =
		// logincookie();

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		Connection connection = (Connection) sessionMap.get("CONNECTION.LOGIN");
		String password_query = null;
		String email_query = null;
		String email = null;
		ResultSet resultset = null;
		try {
			if (resetAction()) {

				String password = generatePassword();

				System.out.println("password  ====>" + password);

				String encrypt_password = encryptPasswordForSaving(password);

				email_query = "SELECT USER_EMAIL_ID FROM MENU_USER WHERE USER_ID=?";
				resultset = new CRUDHandler().executeSelectStatement(
						email_query, connection,
						new Object[] { loginBean.getUserName() });

				while (resultset.next()) {
					email = resultset.getString("USER_EMAIL_ID");

				}

				/*Modified by ganesh on 16-02-2018 to junk password in mail*/
				/*password_query = "UPDATE MENU_USER SET USER_PASSWD=? WHERE USER_ID=?";
				new CRUDHandler().executeUpdateStatement(
						password_query,
						connection,
						new Object[] { encrypt_password,
								loginBean.getUserName() });*/
				
				new LoginDelegate().P_USER_PWD_ENCRYPT(loginBean.getUserName(), password, connection);
				
				/*end*/

				if ("Y".equals(Email_Procedure_Call.emailTriggerProcCall("0",
						"FGP", null, "R", loginBean.getUserName(), connection))) {

					getResetpasswordButton().setStyle("display:none");
					getForgotButton().setStyle("display:block");

					COM_PANEL_VALUE.setValue("Forgot password Message");

					throw new Exception(
							"Your temporary password has been generated and it sent to your email id "
									+ email);
				} else {

					getResetpasswordButton().setStyle("display:none");
					getForgotButton().setStyle("display:block");

					COM_PANEL_VALUE.setValue("Forgot password Message");
					throw new Exception(
							"Kindly contact your administrator to change your password");
				}
				// getErrorMap().put("current","Dear User kindly contact your administrator to change your password");
				// navigateto = "PM290_RESET_EXPIRED_PASSWORD";
			}

		} catch (Exception exc) {
			/*
			 * exc.printStackTrace(); getErrorMap().put("current1",
			 * exc.getMessage());
			 */
			loginforgot = true;
			loginError = false;
			FacesMessage facesMessage = createFacesMessageForString("Dear User,");
			FacesMessage facesMessage1 = createFacesMessageForString(exc
					.getMessage());

			addFacesMessageToJsfMessages(forgotButton, facesMessage);
			addFacesMessageToJsfMessages(forgotButton, facesMessage1);
		}
		return navigateto;

	}

	/* End */
	
	/*ADDED BY RAJA ON 10-06-2017 FOR ZBILQC-1718816*/
	
	public void checkFirstLogin()
	{
		try {
			int count=0;
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		Connection connection = (Connection) sessionMap.get("CONNECTION.LOGIN");
		/*Modified by ganesh on 15-02-2018 to display msg for change password
		 * String Query="SELECT * FROM MENU_USER_LOG WHERE MUL_USER_ID=?";
		
			ResultSet firstloginRS=new CRUDHandler().executeSelectStatement(Query, connection, new Object[]{loginBean.getUserName()});
			while(firstloginRS.next())
			{
				count++;
				if(count>1)
				{
					break;
				}
			}
			if(count==1)
			{
				PasswordSetupUtility
				.setPASS_EXP_MESSAGE_InSession("Please Change Your Password..");
			}*/
		
			String Query = "SELECT count(*) FROM MENU_USER_LOG WHERE MUL_USER_ID=?";

			ResultSet firstloginRS = new CRUDHandler()
					.executeSelectStatement(Query, connection,
							new Object[] { loginBean.getUserName() });
			if (firstloginRS.next()) {
				if (1==firstloginRS.getInt(1) && !"Y".equalsIgnoreCase(CommonUtils.getGlobalVariable("PWD_CHG_YN"))) {
					PasswordSetupUtility
							.setPASS_EXP_MESSAGE_InSession("Please Change Your Password..");
				}
			}		
			/*end*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*END*/
	
	
	/*Added by Janani on 16.10.2017 for ZB-CSM*/
	
	public String getUserGroup()
	{
		
		System.out.println("enters into getUserGroup function");
		
		String user_grp = null;
		
		try {
			
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		Connection connection = (Connection) sessionMap.get("CONNECTION.LOGIN");
		
		
		String Query="SELECT USER_GROUP_ID FROM MENU_USER WHERE USER_ID = ?";
		
		System.out.println("getUserName              "+loginBean.getUserName());
		
			ResultSet rs=new CRUDHandler().executeSelectStatement(Query, connection, new Object[]{loginBean.getUserName()});
			while(rs.next())
			{
				user_grp = rs.getString("USER_GROUP_ID");
			}
			
			
			System.out.println("user_grp                 "+user_grp);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user_grp;
	}
	
public String getUserSession(String sessionID,String userID,String userGroup) {
		
		System.out.println("inside getUserSession");
		
		String token_key = null;
		
		
		try
		{

			System.out.println("sessionID                 "+sessionID);
			System.out.println("userID                 "+userID);
			System.out.println("userID                 "+userGroup);

			Map<String, Object> jsonObj = null;
			HttpURLConnection conn = null;
			
			


			String ip_addr = resourceBundle.getString("csm_ip_addr");
String port = resourceBundle.getString("csm_port");
			
			
			//String getPortalStatic =  "http://10.44.12.163:8084/P11JServices/userlogin/"+sessionID+"/"+userID+"/userGroup";	

String getPortalStatic =  "http://"+ip_addr+":"+port+"/P11JServices/userlogin/"+sessionID+"/"+userID+"/"+userGroup;
System.out.println("csm_login_service url            "+getPortalStatic);


			URL url = new URL(getPortalStatic);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			/*	Map<String, String> params = new HashMap<String, String>();
		    params.put("List_type", "PlanProduct");
			conn.setRequestProperty("List_type","PlanProduct");
			 */



			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				/*String[] keyValuePairs = output.split(",");              //split the string to creat key-value pairs
				Map<String,String> map = new HashMap<>();               

				for(String pair : keyValuePairs)                        //iterate over the pairs
				{
					List entry = Arrays.asList(pair.split(":"));  
					System.out.println("entry"+entry);
					System.out.println(entry.get((entry.size()-1))!=null?entry.get((entry.size()-1)):"");
					
					
					//split the pairs to get key and value 
					//map.put(entry[1].trim(), entry[2].trim());          //add them to the hashmap and trim whitespaces
				}*/
				
				LinkedHashMap<String, Object> out=toMap(new JSONObject(output));
				out=toMap(new JSONObject(out.get("responseValue").toString()));
				System.out.println("token key            "+out.get("tokenKey"));
		
				token_key = (String) out.get("tokenKey");
		
				//map.get(tokenKey);
			}

			conn.disconnect();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("e.getMessage()    "+e.getMessage());


		}
		return token_key;

	}
	
	public static LinkedHashMap<String, Object> toMap(JSONObject object) throws JSONException {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();

	    Iterator<String> keysItr = object.keys();
	    while(keysItr.hasNext()) {
	        String key = keysItr.next();
	        Object value = object.get(key);

	        if(value instanceof JSONArray) {
	            value = ((JSONArray) value);
	        }

	        else if(value instanceof JSONObject) {
	            value = toMap((JSONObject) value);
	        }
	        map.put(key, value);
	    }
	    return map;
	}
	/*End*/
	
	public void getProCode() throws Exception {
		String proCodeQry="SELECT PS_CODE FROM PP_SYSTEM WHERE PS_TYPE = 'SITE'";
		ResultSet rs = null;
		String proCode="";
		Connection con = getConnection();
			rs = new CRUDHandler().executeSelectStatement(proCodeQry, con);
			if(rs.next()){
				proCode = rs.getString("PS_CODE");
				if(proCode.equalsIgnoreCase("ZB")){
					proCode="";
				}else{
					proCode +="/" ;
				}
			}
			rs.close();
			
			CommonUtils.setGlobalVariable("GLOBAL.SITE_CODE",proCode);
			//CommonUtils.setGlobalVariable("GLOBAL.KIC_CODE",proCode);
			System.out.println("GLOBAL.SITE_CODE >>>>>> " + CommonUtils.getGlobalVariable("GLOBAL.SITE_CODE"));
	
	}

}
