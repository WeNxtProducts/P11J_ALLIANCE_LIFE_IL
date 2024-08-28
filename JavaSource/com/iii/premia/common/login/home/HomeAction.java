package com.iii.premia.common.login.home;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlModalPanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.common.workflow.WORKFLOW_DMS_ACTION;
import com.iii.pel.forms.HIERARCHY_REPORT.HIERARCHY_REPORT_ACTION;
import com.iii.pel.forms.HIERARCHY_REPORT.HIERARCHY_REPORT_HELPER;
import com.iii.pel.login.model.LoginManagedBean;
import com.iii.pel.login.util.PasswordSetupUtility;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.sso.SSOConstant;
import com.iii.premia.common.commonimpl.sso.SSOHelper;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;


public class HomeAction extends CommonAction{
	private HomeBean homeBean;
	WORKFLOW_DMS_ACTION WORKFLOW_DMS_ACTION;
	/*Added by Kavitha for roadmap*/
	HIERARCHY_REPORT_ACTION HIERARCHY_REPORT_ACTION_BEAN;
	 private boolean displayMenu;
		
	public boolean isDisplayMenu() {
		return displayMenu;
	}

	public void setTemp(boolean displayMenu) {
		this.displayMenu = displayMenu;
	}

	/*End*/
	/*added by dhinesh*/
	private Date selectedDate;
	public Date getSelectedDate() {
		return selectedDate;
	}

	public void setSelectedDate(Date selectedDate) {
		this.selectedDate = selectedDate;
	}
	
	/*end*/
	
	
	
	public WORKFLOW_DMS_ACTION getWORKFLOW_DMS_ACTION() {
		return WORKFLOW_DMS_ACTION;
	}

	public void setWORKFLOW_DMS_ACTION(WORKFLOW_DMS_ACTION wORKFLOW_DMS_ACTION) {
		WORKFLOW_DMS_ACTION = wORKFLOW_DMS_ACTION;
	}
	
	public HomeAction(){
		homeBean = new HomeBean();
		WORKFLOW_DMS_ACTION=new WORKFLOW_DMS_ACTION();
		/*Added by Kavitha for roadmap*/
		HIERARCHY_REPORT_ACTION_BEAN = new HIERARCHY_REPORT_ACTION();
		/*End*/
		COMP_STATUS_MODAL_PANEL = new HtmlModalPanel();
	}
	
	public void beforePhaseListener(PhaseEvent event){
		WORKFLOW_DMS_ACTION.getWorkFlowDetails();
		WORKFLOW_DMS_ACTION.getWorkFlowUnAssignedDetails();
		HomeHelper homeHelper = null;
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

		try {
			/*if(this.isBlockFlag()){
				// [ Added for auto login
				SSOHelper helper = new SSOHelper();
				boolean autoLoginRequested = false;
				HttpSession session = request.getSession();
				GNMNF002_SERVICE loginService = new GNMNF002_SERVICE();
				LoginManagedBean loginManagedBean = (LoginManagedBean)session.getAttribute("loginManagedBean");
				autoLoginRequested = helper.processRequestParameters(request, loginManagedBean);
				if(autoLoginRequested){
					loginManagedBean = (LoginManagedBean)session.getAttribute("loginManagedBean");
					if(loginManagedBean != null){
						loginManagedBean.onLoad(null);
						// Validate password will validate the password and do user group settings
						try{
							loginService.M_PASSWD_whenValidateItem(loginManagedBean);
						}catch(Exception exc){
							//TODO Invalid password needs to be handled properly here
							exc.printStackTrace();
						}
						// Performing login
						loginManagedBean.loginAction();
					}else{
						// Autologin requested but faild should be handled here
					}
				}
				// Added for auto login ]
				
				// Prepare dash-board for user
				homeHelper = new HomeHelper();
				homeBean.setChartList(homeHelper.prepareChartListForUser(
						CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID")));
				this.setBlockFlag(false);
			}*/
			// [ Added for auto login
			/*SSOHelper helper = new SSOHelper();
			boolean autoLoginRequested = false;
			boolean autoLoginFailed = false;
			HttpSession session = request.getSession();
			GNMNF002_SERVICE loginService = new GNMNF002_SERVICE();
			LoginManagedBean loginManagedBean = new LoginManagedBean();
			 loginManagedBean = (LoginManagedBean)session.getAttribute("loginManagedBean");
			autoLoginRequested = helper.processRequestParameters(request, loginManagedBean);
			
			if(autoLoginRequested){
				try {
					loginManagedBean = (LoginManagedBean)session.getAttribute("loginManagedBean");
					if(loginManagedBean != null){
						// Remove old SSOAction from session
						session.removeAttribute("SSOAction");
						// Perform initial settings
						loginManagedBean.onLoad(null);
						// Validate password will validate the password and do user group settings
						loginManagedBean.M_PASSWD_whenValidateItem(loginManagedBean);
						
						// Performing login
						loginManagedBean.loginAction();

						// Check for login failure
						if(!loginManagedBean.getErrorMap().isEmpty()){
							autoLoginFailed = true;
							response.sendRedirect(helper.prepareRedirectURLForErrorOnAutoLogin(
									(String)session.getAttribute(SSOConstant.FROM_APP_URL), 
									loginManagedBean.getErrorMap().get(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY)));
						}
					}else{
						// Autologin requested but faild should be handled here
						autoLoginFailed = true;
						response.sendRedirect(helper.prepareRedirectURLForErrorOnAutoLogin(
								(String)session.getAttribute(SSOConstant.FROM_APP_URL), 
								loginManagedBean.getErrorMap().get(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY)));
					}
				} catch (IOException e) {
					e.printStackTrace();
					request.setAttribute(SSOConstant.ERROR_MESSAGE_KEY, "Auto login failed! Could not redirect back to the Called application. Application may not perform properly. Please contact to sytem administrator.<br> Caused Exception: "+e.getMessage());
				} catch(Exception exc){
					exc.printStackTrace();
					autoLoginFailed = true;
					response.sendRedirect(helper.prepareRedirectURLForErrorOnAutoLogin(
							(String)session.getAttribute(SSOConstant.FROM_APP_URL), 
							exc.getMessage()));
				}
			}*/
			// Added for auto login ]
			SSOHelper helper = new SSOHelper();
			boolean autoLoginRequested = false;
			boolean autoLoginFailed = false;
			HttpSession session = request.getSession();
			LoginManagedBean loginManagedBean = (LoginManagedBean)session.getAttribute("loginManagedBean");
			autoLoginRequested = helper.processRequestParameters(request, loginManagedBean);
			
			if(autoLoginRequested){
				try {
					loginManagedBean = (LoginManagedBean)session.getAttribute("loginManagedBean");
					if(loginManagedBean != null){
						// Remove old SSOAction from session
						session.removeAttribute("SSOAction");
						// Perform initial settings
						//loginManagedBean.onLoad(null);
						// Validate password will validate the password and do user group settings
						loginManagedBean.M_PASSWD_whenValidateItem(loginManagedBean);
						
						// Performing login
						loginManagedBean.loginAction();

						// Check for login failure
						if(FacesContext.getCurrentInstance().getMessages().hasNext()){
							autoLoginFailed = true;
							response.sendRedirect(helper.prepareRedirectURLForErrorOnAutoLogin(
									(String)session.getAttribute(SSOConstant.FROM_APP_URL), 
									FacesContext.getCurrentInstance().getMessages().next().getSummary()));
						}
					}else{
						// Autologin requested but faild should be handled here
						autoLoginFailed = true;
						response.sendRedirect(helper.prepareRedirectURLForErrorOnAutoLogin(
								(String)session.getAttribute(SSOConstant.FROM_APP_URL), 
								FacesContext.getCurrentInstance().getMessages().next().getSummary()));
					}
				} catch (IOException e) {
					e.printStackTrace();
					request.setAttribute(SSOConstant.ERROR_MESSAGE_KEY, "Auto login failed! Could not redirect back to the Called application. Application may not perform properly. Please contact to sytem administrator.<br> Caused Exception: "+e.getMessage());
				} catch(Exception exc){
					exc.printStackTrace();
					autoLoginFailed = true;
					response.sendRedirect(helper.prepareRedirectURLForErrorOnAutoLogin(
							(String)session.getAttribute(SSOConstant.FROM_APP_URL), 
							exc.getMessage()));
				}
			}
			// Added for auto login ]
			homeHelper = new HomeHelper();
			/*ADDED BY RAJA ON 10-06-2017 FOR ZBILQC-1718816*/
			loginManagedBean.checkFirstLogin();			
			/*end*/
			//Added by rakesh on 27-08-2020 for first time login after reset password
			//Commented by rakesh on 02-09-2020 for orient if needed just uncomment.
			/*String FirstLogin = checkFirstTimeLogin();
			if(FirstLogin != null && FirstLogin.equalsIgnoreCase("Y"))
			{
				getCOMP_STATUS_MODAL_PANEL().setShowWhenRendered(true);
			}
			else
			{
				getCOMP_STATUS_MODAL_PANEL().setShowWhenRendered(false);
			}*/
			
			//END
			if(this.isBlockFlag()){
				
				/*Added by kavitha on 01.11.2018*/
				//Commented by rakesh on 22-06-2020 for orient session lock issue sugg by raja sir
				/*HIERARCHY_REPORT_HELPER HIERARCHY_REPORT_helper= new HIERARCHY_REPORT_HELPER();
				displayMenu = HIERARCHY_REPORT_helper.displayingMenu();	
				End
				// Prepare dash-board for user
				homeBean.setChartList(homeHelper.prepareChartListForUser(
						CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID")));
				homeBean.setReportList(homeHelper.prepareReportListForUser(
						CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID")));*/
				//END
				this.setBlockFlag(false);
			}else{
				//Commented by rakesh on 22-06-2020 for orient session lock issue sugg by raja sir
				//homeHelper.restoreChartsForUser(homeBean.getChartList());
				//END
			}
			/*Added by kavitha on 01.11.2018*/
			//Commented by rakesh on 22-06-2020 for orient session lock issue sugg by raja sir
			//HIERARCHY_REPORT_ACTION_BEAN.onLoad(null);
			//END
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, e.getMessage());
			e.printStackTrace();
		}
	}

	public HomeBean getHomeBean() {
		return homeBean;
	}

	public void setHomeBean(HomeBean homeBean) {
		this.homeBean = homeBean;
	}

	public HIERARCHY_REPORT_ACTION getHIERARCHY_REPORT_ACTION_BEAN() {
		return HIERARCHY_REPORT_ACTION_BEAN;
	}

	public void setHIERARCHY_REPORT_ACTION_BEAN(
			HIERARCHY_REPORT_ACTION hIERARCHY_REPORT_ACTION_BEAN) {
		HIERARCHY_REPORT_ACTION_BEAN = hIERARCHY_REPORT_ACTION_BEAN;
	}
	
	//Added by rakesh on 27-08-2020 for first time login password reset popup
	private HtmlModalPanel COMP_STATUS_MODAL_PANEL;
	
	public HtmlModalPanel getCOMP_STATUS_MODAL_PANEL() {
		return COMP_STATUS_MODAL_PANEL;
	}

	public void setCOMP_STATUS_MODAL_PANEL(HtmlModalPanel cOMP_STATUS_MODAL_PANEL) {
		COMP_STATUS_MODAL_PANEL = cOMP_STATUS_MODAL_PANEL;
	}
	public String ResetAction() {
		String outcome = "";
		try {
			getCOMP_STATUS_MODAL_PANEL().setShowWhenRendered(false);
			outcome="PM290_RESET_EXPIRED_PASSWORD";
		}
		catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}
		return outcome;
	}
	public String cancelAction() {
		Connection con = null;
		String query = "UPDATE MENU_USER SET USER_FIRST_LOGIN_YN = 'N' WHERE USER_ID = ? ";
		try
		{
			con = CommonUtils.getConnection();
			new CRUDHandler().executeUpdateStatement(query, con,
	    			new Object[]{CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID")}); 
			con.commit();
			getCOMP_STATUS_MODAL_PANEL().setShowWhenRendered(false);
		}
		catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}
		return null;
		
	}
	public String checkFirstTimeLogin() {
		Connection con = null;
		ResultSet rs = null;
		String returnval = null;
		String query = "SELECT USER_FIRST_LOGIN_YN FROM MENU_USER WHERE USER_ID = ? ";
		try
		{
			con = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(query, con,
	    			new Object[]{CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID")}); 
			if(rs.next())
			{
				returnval = rs.getString(1);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}
		finally
		{
			try
			{
				CommonUtils.closeCursor(rs);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return returnval;
		
	}
	
}
