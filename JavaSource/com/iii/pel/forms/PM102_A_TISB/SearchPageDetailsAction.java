package com.iii.pel.forms.PM102_A_TISB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.el.ELResolver;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.SimpleConnectionAgent;

public class SearchPageDetailsAction {
	// Component backing fields
	private HtmlDataTable dataTable;
	// Data list to display in data table
	private ArrayList<PolicyDetails> policyList;
	// Fields to map the initial search criteria
	//private String initPolCustCode;
	
    private String initAPAT_CODE;

	
	private Double initAPAT_RATE;

	//private String initCustbankcode; 
	 
	//private int initPolPeriod;
	//private int initMainaccountcode; 
	// Fields to map the filtered criteria
	private String searchedName;
	
	ServletContext context;
	CRUDHandler handler = new CRUDHandler();
	Connection con ;
	ResultSet rs = null;

	// Fetch details action
	public String fetchPolicyDetails(){
		System.out.println("SearchPageDetailsAction.fetchPolicyDetails()-Inside");
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
	public String BringList() throws Exception{
		System.out.println("---------Bring List In Action-----------------");
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		String code = request.getParameter("ROWID");
		//this.policyList = null;
		ELResolver resolver = context.getApplication().getELResolver();                       
		PM_AGENT_PF_ACNT_TYPE_ACTION actionBean= (PM_AGENT_PF_ACNT_TYPE_ACTION)resolver.getValue(context.getELContext(), null, "PM102_A_TISB_PM_AGENT_PF_ACNT_TYPE_ACTION");
		prepareDetails(code,actionBean);
		String returnStr = "PM102A_openscreen";
		//actionBean.PM_IL_PM_IL_BANK_ACCOUNT_SETUP_POST_QUERY();
		return returnStr;
	}

	private void  prepareDetails(String code,PM_AGENT_PF_ACNT_TYPE_ACTION actionBean) throws Exception {
		System.out.println("<<<<<<<<<<<<<<Inside Prepare Details");
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		if(actionBean == null) {
			System.out.println("bean null");
		}
		session.setAttribute("PM102_A_TISB.PM_AGENT_PF_ACNT_TYPE_ACTION", actionBean);
		PM_AGENT_PF_ACNT_TYPE pm_il_bank_account_setup=actionBean.getPM_AGENT_PF_ACNT_TYPE_BEAN();
		
		
		//String ROWID = getRowId(code);
		String selectQuery  = "SELECT APAT_RATE,APAT_AGE,APAT_CODE,ROWID FROM PM_AGENT_PF_ACNT_TYPE where ROWID= '" +code + "'";
		System.out.println("selectQuery"+selectQuery);
		con = getConnection();
		System.out.println("CODE **********"+code);
		List list = handler.fetch(selectQuery, "com.iii.pel.forms.PM102_A_TISB.PM_AGENT_PF_ACNT_TYPE",con);
		System.out.println("The List Size Is "+list.size());
		/*pm_il_bank_account_setup = (PM_AGENT_PF_ACNT_TYPE)list.get(0);
		actionBean.setPM_AGENT_PF_ACNT_TYPE_BEAN(pm_il_bank_account_setup);
		
		Double PAT_RATE = actionBean.getPM_AGENT_PF_ACNT_TYPE_BEAN().getAPAT_RATE();
		System.out.println("SearchPageDetailsAction.prepareDetails()-PAT_CODE"+PAT_RATE);
		//String OUR_BANK_CODE_DESC =Bring_BAS_OUR_BANK_CODE_DESC(OUR_BANK_CODE);
		pm_il_bank_account_setup.setAPAT_RATE(PAT_RATE);
		actionBean.setPM_AGENT_PF_ACNT_TYPE_BEAN(pm_il_bank_account_setup);*/
		actionBean.setBeanList(list);
		
		
		/*String CUST_BANK_CODE = actionBean.getPM_IL_BANK_ACCOUNT_SETUP_BEAN().getBAS_CUST_BANK_CODE();
		String CUST_BANK_DESC = Bring_BAS_CUST_BANK_CODE_DESC(CUST_BANK_CODE);
		pm_il_bank_account_setup.setUI_M_CUST_BANK_DESC(CUST_BANK_DESC);
		actionBean.setPM_IL_BANK_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		
		String MAIN_ACNT_CODE = actionBean.getPM_IL_BANK_ACCOUNT_SETUP_BEAN().getBAS_MAIN_ACNT_CODE();
		String MAIN_ACNT_DESC = Bring_BAS_MAIN_ACNT_CODE_DESC(MAIN_ACNT_CODE);
		pm_il_bank_account_setup.setUI_M_MAIN_ACNT_DESC(MAIN_ACNT_DESC);
		actionBean.setPM_IL_BANK_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		*/
		
		/*String SUB_ACNT_CODE = actionBean.getPM_IL_BANK_ACCOUNT_SETUP_BEAN().getBAS_SUB_ACNT_CODE();
		String SUB_ACNT_DESC = Bring_BAS_MAIN_ACNT_CODE_DESC(SUB_ACNT_CODE);
		pm_il_bank_account_setup.setUI_M_MAIN_ACNT_DESC(SUB_ACNT_DESC);
		actionBean.setPM_IL_BANK_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		*/
		
	}

	
	
	
	/*private String getRowId(String code) {
		String query = "SELECT ROWID FROM PM_IL_BANK_ACCOUNT_SETUP WHERE  BAS_OUR_BANK_CODE ='" +code + "'";
		return null;
	}*/

	/*public String  Bring_BAS_MAIN_ACNT_CODE_DESC(String main_acnt_code) throws Exception{
		   String desc = null;
		   System.out.println("PM_IL_BANK_ACCOUNT_SETUP_ACTION.BAS_MAIN_ACNT_CODE_when_validateItem()");
		   String Main_account_code = main_acnt_code;
		   if(!"".equals(Main_account_code)){
		   String query = QueryRepository.PM_IL_BANK_ACCOUNT_SETUP_MAIN_ACCOUNT_CODE_LOV+
		   "AND  MAIN_ACNT_CODE ='" + Main_account_code +"'";
		   System.out.println("query Is "+query);
		   Connection con = getConnection();
    	   rs=handler.executeSelectStatement(query,con);
		   while(rs.next()){
			   System.out.println("iNSIDE wHILE");
			   desc = (rs.getString("MAIN_ACNT_NAME"));
			  }
		   rs.close();
		   con.close();
		     }
		   
		   return desc;
	}  
		   */
		   		   
		   
	
/*	public String Bring_BAS_CUST_BANK_CODE_DESC(String cust_bank_code) throws Exception{
		   String desc = null;
		   String CUST_BANK_DESC = cust_bank_code;
		   String query = QueryRepository.PM_IL_BANK_ACCOUNT_SETUP_BANK_LOV + 
		                  " WHERE BANK_CODE = '" + CUST_BANK_DESC + "'";
		   System.out.println("PM_IL_BANK_AC" +
		   		"COUNT_SETUP_ACTION.BAS_CUST_BANK_CODE_when_validateListener()-query"+query);
		   Connection con = getConnection();
		   
		   rs=handler.executeSelectStatement(query,con);
		   while(rs.next()){
			   System.out.println("iNSIDE wHILE");
			   desc =(rs.getString("BANK_NAME"));
		   }
		   rs.close();
		   con.close();
		   return desc;
	   }*/
	
	/* public String  Bring_BAS_OUR_BANK_CODE_DESC(String our_bank_code) throws Exception{
		   System.out.println("PM_IL_BANK_ACCOUNT_SETUP_ACTION.BAS_OUR_BANK_CODE_when_validateListener()");
		   String desc = null;
		   String OUR_BANK_DESC = our_bank_code;
		   String query = QueryRepository.PM_IL_BANK_ACCOUNT_SETUP_BANK_LOV + 
		   " WHERE BANK_CODE = '" + OUR_BANK_DESC + "'";
		   System.out.println("PM_IL_BANK_AC" +
				   "COUNT_SETUP_ACTION.BAS_CUST_BANK_CODE_when_validateListener()-query"+query);
		   Connection con = getConnection();
		   rs=handler.executeSelectStatement(query,con);
		   while(rs.next()){
			   System.out.println("iNSIDE wHILE");
			  desc = rs.getString("BANK_NAME");
	      }	   
		   
		   rs.close();
		  con.close();
		  return desc; 
	   }
	*/
	
	
	public Connection getConnection() throws Exception{
		FacesContext fc = FacesContext.getCurrentInstance();
		ServletContext context = (ServletContext)fc.getExternalContext().getContext();
		SimpleConnectionAgent connectionAgent =  (SimpleConnectionAgent) context.getAttribute("connectionAgent");
		return connectionAgent.getConnection("System.currentTimeMillis()");
	}

	public SearchPageDetailsAction(){
		super();
		policyList = new ArrayList<PolicyDetails>();
	}
	
	public HtmlDataTable getDataTable() {
		return dataTable;
	}
	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public ArrayList<PolicyDetails> getPolicyList() {
		return policyList;
	}

	public void setPolicyList(ArrayList<PolicyDetails> policyList) {
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

	public int getInitMainaccountcode() {
		return initMainaccountcode;
	}

	public void setInitMainaccountcode(int initMainaccountcode) {
		this.initMainaccountcode = initMainaccountcode;
	}*/

	
	public String clearSession() {
		System.out.println("PolicyDetailsAction.clearSession()-Inside");
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		if (session.getAttribute("PM_AGENT_PF_ACNT_TYPE") != null) {
			System.out.println("PolicyDetailsAction.clearSession()-Session Is Active");
			session.removeAttribute("PM_AGENT_PF_ACNT_TYPE");
		}
		return "PM102A_Freshscreen";
	}

	public String getInitAPAT_CODE() {
		return initAPAT_CODE;
	}

	public void setInitAPAT_CODE(String initAPAT_CODE) {
		this.initAPAT_CODE = initAPAT_CODE;
	}

	public Double getInitAPAT_RATE() {
		return initAPAT_RATE;
	}

	public void setInitAPAT_RATE(Double initAPAT_RATE) {
		this.initAPAT_RATE = initAPAT_RATE;
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
