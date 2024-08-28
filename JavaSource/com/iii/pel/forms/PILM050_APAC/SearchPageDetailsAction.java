package com.iii.pel.forms.PILM050_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.el.ELResolver;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class SearchPageDetailsAction {
	// Component backing fields
	private HtmlDataTable dataTable;
	// Data list to display in data table
	//private ArrayList<PolicyDetails> policyList;
	
	private ArrayList<PM_IL_BANK_ACCOUNT_SETUP> policyList;
	
	
	private PM_IL_BANK_ACCOUNT_SETUP POLICY_BEAN;
	// Fields to map the initial search criteria
	//private String initPolCustCode;
	//private String initCustbankcode; 
	private String initBasDivnCode;
	//private int initPolPeriod;
	private String initMainaccountcode; 
	// Fields to map the filtered criteria
	private String searchedName;
	
	//Testing CVS
	
	ServletContext context;
	CRUDHandler handler = new CRUDHandler();
	Connection con ;
	ResultSet rs = null;

	// Fetch details action
	public String fetchPolicyDetails(){
		SearchPageDelegate delegate = new SearchPageDelegate();

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
		PM_IL_BANK_ACCOUNT_SETUP_ACTION actionBean= (PM_IL_BANK_ACCOUNT_SETUP_ACTION)resolver.getValue(context.getELContext(), null, "PILM050_APAC_PM_IL_BANK_ACCOUNT_SETUP_ACTION");
		prepareDetails(code,actionBean);
		String returnStr = "PILM050_APAC_goMainPage";
		//actionBean.PM_IL_PM_IL_BANK_ACCOUNT_SETUP_POST_QUERY();
		return returnStr;
	}

	private void  prepareDetails(String code,PM_IL_BANK_ACCOUNT_SETUP_ACTION actionBean) throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		if(actionBean == null) {
			System.out.println("bean null");
		}
		session.setAttribute("PILM050_APAC_PM_IL_BANK_ACCOUNT_SETUP_ACTION", actionBean);
		PM_IL_BANK_ACCOUNT_SETUP pm_il_bank_account_setup=actionBean.getPM_IL_BANK_ACCOUNT_SETUP_BEAN();
		
		
		//String ROWID = getRowId(code);
		//String selectQuery  = "select ROWID,BAS_CUST_BANK_CODE,BAS_OUR_BANK_CODE,BAS_MAIN_ACNT_CODE,BAS_DIVN_CODE,BAS_VALUE_FROM,BAS_VALUE_TO FROM PM_IL_BANK_ACCOUNT_SETUP where ROWID= '" +code + "'";
		String selectQuery = "select ROWID,PM_IL_BANK_ACCOUNT_SETUP.* FROM PM_IL_BANK_ACCOUNT_SETUP where ROWID= '" +code + "'";
		
		
		System.out.println("selectQuery"+selectQuery);
		con = CommonUtils.getConnection();
		System.out.println("CODE **********"+code);
		List list = handler.fetch(selectQuery, "com.iii.pel.forms.PILM050_APAC.PM_IL_BANK_ACCOUNT_SETUP",con);
		pm_il_bank_account_setup = (PM_IL_BANK_ACCOUNT_SETUP)list.get(0);
		actionBean.setPM_IL_BANK_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String OUR_BANK_CODE = actionBean.getPM_IL_BANK_ACCOUNT_SETUP_BEAN().getBAS_OUR_BANK_CODE();
		String OUR_BANK_CODE_DESC =Bring_BAS_OUR_BANK_CODE_DESC(OUR_BANK_CODE);
		pm_il_bank_account_setup.setUI_M_OUR_BANK_DESC(OUR_BANK_CODE_DESC);
		actionBean.setPM_IL_BANK_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		
		String CUST_BANK_CODE = actionBean.getPM_IL_BANK_ACCOUNT_SETUP_BEAN().getBAS_CUST_BANK_CODE();
		String CUST_BANK_DESC = Bring_BAS_CUST_BANK_CODE_DESC(CUST_BANK_CODE);
		pm_il_bank_account_setup.setUI_M_CUST_BANK_DESC(CUST_BANK_DESC);
		actionBean.setPM_IL_BANK_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String MAIN_ACNT_CODE = actionBean.getPM_IL_BANK_ACCOUNT_SETUP_BEAN().getBAS_MAIN_ACNT_CODE();
		String MAIN_ACNT_DESC = Bring_BAS_MAIN_ACNT_CODE_DESC(MAIN_ACNT_CODE);
		pm_il_bank_account_setup.setUI_M_MAIN_ACNT_DESC(MAIN_ACNT_DESC);
		actionBean.setPM_IL_BANK_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		
		String SUB_ACNT_CODE = actionBean.getPM_IL_BANK_ACCOUNT_SETUP_BEAN().getBAS_SUB_ACNT_CODE();
		String SUB_ACNT_DESC = Bring_BAS_MAIN_ACNT_CODE_DESC(SUB_ACNT_CODE);
		pm_il_bank_account_setup.setUI_M_MAIN_ACNT_DESC(SUB_ACNT_DESC);
		actionBean.setPM_IL_BANK_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		
	}

	public void DeleteRow(ActionEvent ae) throws Exception{
		System.out.println("SearchPageDetailsAction.DeleteRow()");
		//PolicyDetails valuebean = null;
		
		PM_IL_BANK_ACCOUNT_SETUP valuebean = null;
		int DeletedRecordIndex = 0;
		con = CommonUtils.getConnection();
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
					int n = handler.executeDelete(valuebean, con);
					System.out.println("PM_IL_FUND_PRICE_DTL_ACTION.deleteRow()-n"+n);
					con.commit();
				}else{
					System.out.println("Else_Part_In_Action");
					index++;
				}
			}

		}
	}
	
	
	
	/*private String getRowId(String code) {
		String query = "SELECT ROWID FROM PM_IL_BANK_ACCOUNT_SETUP WHERE  BAS_OUR_BANK_CODE ='" +code + "'";
		return null;
	}*/

	public String  Bring_BAS_MAIN_ACNT_CODE_DESC(String main_acnt_code) throws Exception{
		   String desc = null;
		   System.out.println("PM_IL_BANK_ACCOUNT_SETUP_ACTION.BAS_MAIN_ACNT_CODE_when_validateItem()");
		   String Main_account_code = main_acnt_code;
		   if(!"".equals(Main_account_code)){
		   String query = QueryRepository.PM_IL_BANK_ACCOUNT_SETUP_MAIN_ACCOUNT_CODE_LOV+
		   "AND  MAIN_ACNT_CODE ='" + Main_account_code +"'";
		   System.out.println("query Is "+query);
		   Connection con = CommonUtils.getConnection();
    	   rs=handler.executeSelectStatement(query,con);
		   while(rs.next()){
			   System.out.println("iNSIDE wHILE");
			   desc = (rs.getString("MAIN_ACNT_NAME"));
			  }
		   rs.close();
		   //con.close();
		     }
		   
		   return desc;
	}  
		   
		   		   
		   
	
	public String Bring_BAS_CUST_BANK_CODE_DESC(String cust_bank_code) throws Exception{
		   String desc = null;
		   String CUST_BANK_DESC = cust_bank_code;
		   String query = QueryRepository.PM_IL_BANK_ACCOUNT_SETUP_BANK_LOV + 
		                  " WHERE BANK_CODE = '" + CUST_BANK_DESC + "'";
		   System.out.println("PM_IL_BANK_AC" +
		   		"COUNT_SETUP_ACTION.BAS_CUST_BANK_CODE_when_validateListener()-query"+query);
		   Connection con = CommonUtils.getConnection();
		   
		   rs=handler.executeSelectStatement(query,con);
		   while(rs.next()){
			   System.out.println("iNSIDE wHILE");
			   desc =(rs.getString("BANK_NAME"));
		   }
		   rs.close();
		   //con.close();
		   return desc;
	   }
	
	 public String  Bring_BAS_OUR_BANK_CODE_DESC(String our_bank_code) throws Exception{
		   System.out.println("PM_IL_BANK_ACCOUNT_SETUP_ACTION.BAS_OUR_BANK_CODE_when_validateListener()");
		   String desc = null;
		   String OUR_BANK_DESC = our_bank_code;
		   String query = QueryRepository.PM_IL_BANK_ACCOUNT_SETUP_BANK_LOV + 
		   " WHERE BANK_CODE = '" + OUR_BANK_DESC + "'";
		   System.out.println("PM_IL_BANK_AC" +
				   "COUNT_SETUP_ACTION.BAS_CUST_BANK_CODE_when_validateListener()-query"+query);
		   Connection con = CommonUtils.getConnection();
		   rs=handler.executeSelectStatement(query,con);
		   while(rs.next()){
			   System.out.println("iNSIDE wHILE");
			  desc = rs.getString("BANK_NAME");
	      }	   
		   
		   rs.close();
		  //con.close();
		  return desc; 
	   }
	
	
	
/*	public Connection getConnection() throws Exception{
		context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		con=((SimpleConnectionAgent)context.getAttribute("connectionAgent")).getConnection("123456");
		return con;
 }*/

	public SearchPageDetailsAction(){
		super();
		policyList = new ArrayList<PM_IL_BANK_ACCOUNT_SETUP>();
		POLICY_BEAN = new PM_IL_BANK_ACCOUNT_SETUP();
	}
	
	public HtmlDataTable getDataTable() {
		return dataTable;
	}
	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public ArrayList<PM_IL_BANK_ACCOUNT_SETUP> getPolicyList() {
		return policyList;
	}

	public void setPolicyList(ArrayList<PM_IL_BANK_ACCOUNT_SETUP> policyList) {
		this.policyList = policyList;
	}

	public String getSearchedName() {
		return searchedName;
	}

	public void setSearchedName(String searchedName) {
		this.searchedName = searchedName;
	}

	/*public String getInitCustbankcode() {
		return initCustbankcode;
	}

	public void setInitCustbankcode(String initCustbankcode) {
		this.initCustbankcode = initCustbankcode;
	}
*/
	public String getInitMainaccountcode() {
		return initMainaccountcode;
	}

	public void setInitMainaccountcode(String initMainaccountcode) {
		this.initMainaccountcode = initMainaccountcode;
	}

	
	public String clearSession() {
		System.out.println("PolicyDetailsAction.clearSession()-Inside");
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		if (session.getAttribute("PM_IL_BANK_ACCOUNT_SETUP") != null) {
			System.out.println("PolicyDetailsAction.clearSession()-Session Is Active");
			session.removeAttribute("PM_IL_BANK_ACCOUNT_SETUP");
		}
		return "PILM050_APAC_openscreen";
	}

	public String getInitBasDivnCode() {
		return initBasDivnCode;
	}

	public void setInitBasDivnCode(String initBasDivnCode) {
		this.initBasDivnCode = initBasDivnCode;
	}
	
	
	public String checkBoxStatus(ActionEvent actionEvent)
	{
		//System.out.println("<<<<<<<<<<"+((UIInput)actionEvent.getComponent().getParent()).getSubmittedValue());
		return "";
	}

	public PM_IL_BANK_ACCOUNT_SETUP getPOLICY_BEAN() {
		return POLICY_BEAN;
	}

	public void setPOLICY_BEAN(PM_IL_BANK_ACCOUNT_SETUP policy_bean) {
		POLICY_BEAN = policy_bean;
	}
	
	
	
	/*public String getInitPolCustCode() {
		return initPolCustCode;
	}

	public void setInitPolCustCode(String initPolCustCode) {
		this.initPolCustCode = initPolCustCode;
	}

	public int getInitPolPeriod() {
		return initPolPeriod;
	}

	public void setInitPolPeriod(int initPolPeriod) {
		this.initPolPeriod = initPolPeriod;
	}*/
}
