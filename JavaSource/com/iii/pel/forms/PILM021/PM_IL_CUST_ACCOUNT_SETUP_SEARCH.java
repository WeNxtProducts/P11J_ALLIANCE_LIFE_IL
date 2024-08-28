package com.iii.pel.forms.PILM021;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.el.ELResolver;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.SimpleConnectionAgent;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_CUST_ACCOUNT_SETUP_SEARCH extends CommonAction {

	private HtmlDataTable dataTable;
	private PM_IL_CUST_ACCOUNT_SETUP searchBean;
	private ArrayList<PM_IL_CUST_ACCOUNT_SETUP> policyList;
	private String initControlAccountcode; 
	private String initBranchcode;
	private ArrayList<PM_IL_CUST_ACCOUNT_SETUP> detailsList;
	PM_IL_CUST_ACCOUNT_SETUP details = null;
	private String searchedName;
	ServletContext context;
	CRUDHandler handler = new CRUDHandler();
	Connection con ;
	ResultSet rs = null;
	
	// Fetch details action
	public String fetchPolicyDetails(){
		PM_IL_CUST_ACCOUNT_SETUP_DELEGATE delegate = new PM_IL_CUST_ACCOUNT_SETUP_DELEGATE();

		try {
			this.policyList = delegate.fetchPolicyDetails(this);
		} catch (Exception e) {
			// TODO do appropriate settings for  the message to display to the user
			e.printStackTrace();
		}
		
		return null;
	}

	// Clear list in action
	public String clearList() throws Exception{
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		String code = request.getParameter("ROWID");
		//this.policyList = null;
		ELResolver resolver = context.getApplication().getELResolver();
		PM_IL_CUST_ACCOUNT_SETUP_ACTION actionBean= (PM_IL_CUST_ACCOUNT_SETUP_ACTION)resolver.getValue(context.getELContext(), null, "PILM021_PM_IL_CUST_ACCOUNT_SETUP_ACTION");
		//prepareDetails(code,actionBean.getPM_IL_CUST_ACCOUNT_SETUP_BEAN());
		String returnStr = "goCust_AccountMainPage";
		//actionBean.PM_IL_PM_IL_BANK_ACCOUNT_SETUP_POST_QUERY();
		return returnStr;
	}
	
	public void prepareDetails(String rowId)
	{
		PM_IL_CUST_ACCOUNT_SETUP beanClass  = new PM_IL_CUST_ACCOUNT_SETUP();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;
		
		try {
			connection = CommonUtils.getConnection();
			String query = "SELECT CAS_CUST_FM_CLASS,CAS_CUST_TO_CLASS,CAS_DIVN_FM_CODE," +
					"CAS_DIVN_TO_CODE,CAS_DEPT_FM_CODE,CAS_DEPT_TO_CODE,CAS_FORCE_DIVN_YN," +
					"CAS_FORCE_DEPT_YN,CAS_MAIN_ACNT_CODE,CAS_DIVN_CODE,CAS_DEPT_CODE," +
					"CAS_ANLY_CODE_1,CAS_ANLY_CODE_2,CAS_ACTY_CODE_1,CAS_ACTY_CODE_2," +
					"CAS_FRZ_FLAG,CAS_ASSURED_TYPE,CAS_SRC_BUS_FM,CAS_SRC_BUS_TO," +
					"CAS_BUS_TYPE_FM,CAS_BUS_TYPE_TO,ROWID FROM PM_IL_CUST_ACCOUNT_SETUP WHERE ROWID = ?";
			
			System.out.println("Query:::"+query+"   ROWID:::::::"+rowId);
			Object values[] = {rowId};
			resultSet = handler.executeSelectStatement(query, connection, values);
			while(resultSet.next())
			{
				beanClass.setROWID(resultSet.getString("ROWID"));
				beanClass.setCAS_DIVN_FM_CODE(resultSet.getString("CAS_DIVN_FM_CODE"));
				beanClass.setCAS_DIVN_TO_CODE(resultSet.getString("CAS_DIVN_TO_CODE"));
				beanClass.setCAS_CUST_FM_CLASS(resultSet.getString("CAS_CUST_FM_CLASS"));
				beanClass.setCAS_CUST_TO_CLASS(resultSet.getString("CAS_CUST_TO_CLASS"));
				beanClass.setCAS_DEPT_FM_CODE(resultSet.getString("CAS_DEPT_FM_CODE"));
				beanClass.setCAS_DEPT_TO_CODE(resultSet.getString("CAS_DEPT_TO_CODE"));
				beanClass.setCAS_ANLY_CODE_1(resultSet.getString("CAS_ANLY_CODE_1"));
				beanClass.setCAS_ANLY_CODE_2(resultSet.getString("CAS_ANLY_CODE_2"));
				beanClass.setCAS_ACTY_CODE_1(resultSet.getString("CAS_ACTY_CODE_1"));
				beanClass.setCAS_ACTY_CODE_2(resultSet.getString("CAS_ACTY_CODE_2"));
				beanClass.setCAS_SRC_BUS_FM(resultSet.getString("CAS_SRC_BUS_FM"));
				beanClass.setCAS_SRC_BUS_TO(resultSet.getString("CAS_SRC_BUS_TO"));
				beanClass.setCAS_BUS_TYPE_FM(resultSet.getString("CAS_BUS_TYPE_FM"));
				beanClass.setCAS_BUS_TYPE_TO(resultSet.getString("CAS_BUS_TYPE_TO"));
				beanClass.setCAS_ASSURED_TYPE(resultSet.getString("CAS_ASSURED_TYPE"));
				beanClass.setCAS_FORCE_DEPT_YN(resultSet.getString("CAS_FORCE_DEPT_YN"));
				beanClass.setCAS_FORCE_DIVN_YN(resultSet.getString("CAS_FORCE_DIVN_YN"));
				beanClass.setCAS_MAIN_ACNT_CODE(resultSet.getString("CAS_MAIN_ACNT_CODE"));
				beanClass.setCAS_DIVN_CODE(resultSet.getString("CAS_DIVN_CODE"));
				beanClass.setCAS_DEPT_CODE(resultSet.getString("CAS_DEPT_CODE"));
				
				fieldDescription(beanClass);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				new CommonUtils().closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	

	public Connection getConnection() throws Exception{
		context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		con=((SimpleConnectionAgent)context.getAttribute("connectionAgent")).getConnection("123456");
		return con;
 }

	
	public PM_IL_CUST_ACCOUNT_SETUP_SEARCH(){
		super();
		policyList = new ArrayList<PM_IL_CUST_ACCOUNT_SETUP>();
		searchBean = new PM_IL_CUST_ACCOUNT_SETUP();
	}
	
	public HtmlDataTable getDataTable() {
		return dataTable;
	}
	public PM_IL_CUST_ACCOUNT_SETUP getSearchBean() {
		return searchBean;
	}

	public void setSearchBean(PM_IL_CUST_ACCOUNT_SETUP searchBean) {
		this.searchBean = searchBean;
	}

	public ArrayList<PM_IL_CUST_ACCOUNT_SETUP> getPolicyList() {
		return policyList;
	}

	public void setPolicyList(ArrayList<PM_IL_CUST_ACCOUNT_SETUP> policyList) {
		this.policyList = policyList;
	}

	public String getInitControlAccountcode() {
		return initControlAccountcode;
	}

	public void setInitControlAccountcode(String initControlAccountcode) {
		this.initControlAccountcode = initControlAccountcode;
	}

	public String getInitBranchcode() {
		return initBranchcode;
	}

	public void setInitBranchcode(String initBranchcode) {
		this.initBranchcode = initBranchcode;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public String getSearchedName() {
		return searchedName;
	}

	public void setSearchedName(String searchedName) {
		this.searchedName = searchedName;
	}


	public String clearSession() {
		System.out.println("PM_IL_CUST_ACCOUNT_SETUP.clearSession()-Inside");
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		/*if (session.getAttribute("PM_IL_CUST_ACCOUNT_SETUP") != null) {
			System.out.println("PM_IL_CUST_ACCOUNT_SETUP.clearSession()-Session Is Active");
			session.removeAttribute("PM_IL_CUST_ACCOUNT_SETUP");
		}*/
		if (session.getAttribute("PILM021_PM_IL_CUST_ACCOUNT_SETUP_ACTION") != null) {
			System.out.println("PM_IL_CUST_ACCOUNT_SETUP.clearSession()-Session Is Active");
			session.removeAttribute("PILM021_PM_IL_CUST_ACCOUNT_SETUP_ACTION");
		}
		
		
		return "goCust_AccountMainPage";
	}
	public void deleteRow(ActionEvent event) throws Exception{
		System.out.println("SearchPageDetailsAction.DeleteRow()");
		//PolicyDetails valuebean = null;
		
		PM_IL_CUST_ACCOUNT_SETUP valuebean = null;
		int DeletedRecordIndex = 0;
		Connection connection = CommonUtils.getConnection();
		System.out.println("************************");
		System.out.println(policyList.size()); 
		System.out.println("************************");
		if(policyList != null){
			for(int index =0 ;index<policyList.size();){
				valuebean = policyList.get(index);
				System.out.println("ValueBean" +valuebean.toString());
				System.out.println("DataGridAction.deleteRow()-(bean.isCHECK_BOX()"+valuebean.isCHECK_BOX());
				if(valuebean.isCHECK_BOX()){
					policyList.remove(valuebean);
					int n = handler.executeDelete(valuebean, connection);
					System.out.println("PM_IL_CUST_ACCOUNT_SETUP_ACTION.deleteRow()-n"+n);
					connection.commit();
				}else{
					System.out.println("Else_Part_In_Action");
					index++;
				}
			}

		}
	}
	
	 public void fieldDescription(PM_IL_CUST_ACCOUNT_SETUP CustBean)
	 {
		 	String mainAcntDesc = null;
			String divnCodeDesc = null;
			String deptCodeDesc = null;
			String analysisDesc01 = null;
			String analysisDesc02 = null;
			
			String mainAcntQuery = "SELECT MAIN_ACNT_NAME FROM FM_MAIN_ACCOUNT WHERE NVL(MAIN_FRZ_FLAG,'N') = 'N' AND MAIN_ACNT_CODE = ? ";
			//[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DIVISION to FM_DIVISION. Added by : Shankar.B 31-Mar-2009
			//String divnCodeQuery = "select DIVN_NAME from PM_DIVISION where DIVN_COMP_CODE = '001' AND NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND DIVN_CODE = ?";
			String divnCodeQuery = "select DIVN_NAME from FM_DIVISION where DIVN_COMP_CODE = '001' AND NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND DIVN_CODE = ?";
			String deptCodeQuery = "SELECT DEPT_NAME FROM PM_DEPARTMENT WHERE DEPT_FRZ_FLAG  = 'N' AND DEPT_CODE =  ?";
			String analysisQuery01 = "SELECT ANLY_NAME FROM FM_ANALYSIS WHERE ANLY_HEAD_NO = '1' AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND ANLY_CODE = ?";
			String analysisQuery02 = "select ANLY_NAME from FM_ANALYSIS where ANLY_HEAD_NO = '2' AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND ANLY_CODE = ?";
			
			mainAcntDesc = fetchClaimDesc(CustBean.getCAS_MAIN_ACNT_CODE(), mainAcntQuery, "MAIN_ACNT_NAME");
			divnCodeDesc = fetchClaimDesc(CustBean.getCAS_DIVN_CODE(), divnCodeQuery, "DIVN_NAME");
			deptCodeDesc = fetchClaimDesc(CustBean.getCAS_DEPT_CODE(), deptCodeQuery, "DEPT_NAME");
			analysisDesc01 = fetchClaimDesc(CustBean.getCAS_ANLY_CODE_1(), analysisQuery01, "ANLY_NAME");
			analysisDesc02 = fetchClaimDesc(CustBean.getCAS_ANLY_CODE_2(), analysisQuery02, "ANLY_NAME");
			
			CustBean.setUI_M_MAIN_ACNT_NAME(mainAcntDesc);
			CustBean.setUI_M_DIVN_NAME(divnCodeDesc);
			CustBean.setUI_M_DEPT_NAME(deptCodeDesc);
			CustBean.setUI_M_ANLY_NAME(analysisDesc01);
			CustBean.setUI_M_ANLY_NAME_1(analysisDesc02);
	 }
	 
	 public String fetchClaimDesc(String AccountCode,String selectQuery,String filedValue){
			String assignValue = null;
			Connection con = null;
			ResultSet rst = null;
			CRUDHandler handler = null;
			try {
				con = CommonUtils.getConnection();
				if(con!= null){
					handler = new CRUDHandler();
					Object[] values = {AccountCode};
					rst = handler.executeSelectStatement(selectQuery, con, values);
					if(rst.next()){
						assignValue = rst.getString(filedValue);
						assignValue = assignValue == null ? "" : assignValue;
					}
				}
			} catch (DBException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					CommonUtils.closeCursor(rst);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return assignValue;
		}
	 
	 
	 public String updateButtonAction(String rowId) {
		 PM_IL_CUST_ACCOUNT_SETUP_ACTION action = new PM_IL_CUST_ACCOUNT_SETUP_ACTION();
			String outcome = null;
			CommonUtils.setGlobalObject("PILM021_PM_IL_CUST_ACCOUNT_SETUP_ACTION",
					action);
			action.getPM_IL_CUST_ACCOUNT_SETUP_BEAN().setROWID(rowId);
			
			//prepareDetails(rowId);
			outcome = "goCust_AccountMainPage";
			return outcome;

		}

		public String insertButtonAction() {
			PM_IL_CUST_ACCOUNT_SETUP_ACTION action = new PM_IL_CUST_ACCOUNT_SETUP_ACTION();
			String outcome = null;
			CommonUtils.setGlobalObject("PILM021_PM_IL_CUST_ACCOUNT_SETUP_ACTION",
					action);
			outcome = "goCust_AccountMainPage";
			return outcome;

		}

		
}
