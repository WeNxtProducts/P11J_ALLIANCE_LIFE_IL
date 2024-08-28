package com.iii.pel.forms.PILT018;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.el.ELResolver;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT016A_APAC.PILT016A_APAC_COMPOSITE_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

    
public class PT_IL_BROK_ADV_HDR_SEARCH_PAGE_ACTION extends CommonAction{
	
	//private ArrayList<PT_IL_BROK_ADV_HDR> BrokerList;
	private ArrayList<PT_IL_BROK_ADV_HDR> BList;
	Connection con = null;
	CRUDHandler handler = new CRUDHandler();
	
	private String InitBrokerCode;
	private String InitCurrencyCode;
	private String brokerCode;
	private String currencyCode;
	PT_IL_BROK_ADV_HDR searchBean;
	String BAH_CUST_CODE = null;
	private String SearchedName;
	PT_IL_BROK_ADV_HDR details = null;
	PT_IL_BROK_ADV_DTL child = null;
	Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	
	
	
	public PT_IL_BROK_ADV_HDR_SEARCH_PAGE_ACTION(){
		
		super();
		BList = new ArrayList<PT_IL_BROK_ADV_HDR>();
		searchBean = new PT_IL_BROK_ADV_HDR();
		
	}
	
	public String clearList() throws Exception{
		System.out.println("PT_IL_BROK_ADV_HDR_SEARCH_PAGE_ACTION.clearList()-Inside");
		FacesContext context = FacesContext.getCurrentInstance();
		
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		//HttpSession session = request.getSession();
		String code = request.getParameter("ROWID");
		String selectQuery = "Select BAH_CUST_CODE  from PT_IL_BROK_ADV_HDR where ROWID ='"+code+"'";

		System.out.println("PM_IL_FUND_SETUP_SEARCH_PAGE.clearList()-BAH_CUST_CODE"+BAH_CUST_CODE);
		System.out.println("selectQueryselectQueryselectQuery"+selectQuery);
		ELResolver resolver = context.getApplication().getELResolver();
		//[PREMIAGDC-Agent Loan Management-000092:Shankar Bodduluri 03-Mar-09 Internal Fix
		//PT_IL_BROK_ADV_HDR_ACTION actionBean= (PT_IL_BROK_ADV_HDR_ACTION)resolver.getValue(context.getELContext(), null, "PILT018_PT_IL_BROK_ADV_HDR_ACTION");
		PT_IL_BROK_ADV_HDR_ACTION actionBean = new PT_IL_BROK_ADV_HDR_ACTION();
		actionBean.getErrorMap().clear();
		actionBean.getWarningMap().clear();

//      [BugId:PREMIAGDC-AGENCY- 0024 Amit Gupta 04-Feb-09 For handling enabling & disabling of approve buttons 
//		in Header and Detail Block and their respective actions.
		actionBean = prepareDetails(code,actionBean);
		String BAH_PAID_FLAG=actionBean.getPT_IL_BROK_ADV_HDR_BEAN().getBAH_PAID_FLAG();
		String BAH_CONFIRM_FLAG=actionBean.getPT_IL_BROK_ADV_HDR_BEAN().getBAH_CONFIRM_FLAG();
		
		if("Y".equals(BAH_PAID_FLAG) && "Y".equals(BAH_CONFIRM_FLAG)){
			actionBean.setAPPROVE_STATUS(true);
		}else{
			actionBean.setAPPROVE_STATUS(false);
		}
//		String returnStr = "PILT018_goMainPage";
//		actionBean.PM_IL_PM_IL_BANK_ACCOUNT_SETUP_POST_QUERY();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("PILT018_PT_IL_BROK_ADV_HDR_ACTION", actionBean);
//		return returnStr;
		return "PILT018_goMainPage";
// 		BugId:PREMIAGDC-AGENCY- 0024 Amit Gupta 04-Feb-09]

	}
	
	public String fetchPolicyDetails() throws Exception{
			PT_IL_BROK_ADV_HDR_DELEGATE delegate = new PT_IL_BROK_ADV_HDR_DELEGATE();
			this.BList = delegate.fetchPolicyDetails(this);
			if(this.BList.size() == 0){
				getWarningMap().put("current",Messages.getString("messageProperties", "Search$NoRecord$Message"));
			}else{
				getWarningMap().clear();
			}
		return null;
	}
	
	public void checkBoxStatus(ActionEvent event){
		
	}
	
	 public String updateButtonAction(String rowId) {
		  	CompositeAction compositeAction = new CompositeAction();
			String outcome = null;
			FacesContext context = FacesContext.getCurrentInstance();
			Map requestParameterMap = context.getExternalContext()
				.getRequestParameterMap();
		
			CommonUtils.setGlobalObject("PILT018_CompositeAction",
				compositeAction);
			compositeAction.getParentAction().getPT_IL_BROK_ADV_HDR_BEAN().setROWID(rowId);
		
			outcome = "PILT018_goMainPage";
			return outcome;
	    }

	    public String insertButtonAction() {
	    	CompositeAction compositeAction = new CompositeAction();
			String outcome = null;
			CommonUtils.setGlobalObject("PILT018_CompositeAction",
				compositeAction);
			outcome = "PILT018_goMainPage";
			return outcome;
		
		    }
		
		    public String backToSearch() {
		    
			return SearchConstants.BACK_TO_SEARCH_PAGE;
	    }
	
//      [BugId:PREMIAGDC-AGENCY- 0024 Amit Gupta 04-Feb-09 For handling enabling & disabling of approve buttons 
//		in Header and Detail Block and their respective actions.	
	private PT_IL_BROK_ADV_HDR_ACTION prepareDetails(String code,PT_IL_BROK_ADV_HDR_ACTION actionBean) throws Exception {
// 		BugId:PREMIAGDC-AGENCY- 0024 Amit Gupta 04-Feb-09]
		String link_code = null;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
		.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		if(actionBean == null) {
			System.out.println("bean null");
		}
		session.setAttribute("PILT018_PT_IL_BROK_ADV_HDR_ACTION", actionBean);
		PT_IL_BROK_ADV_HDR pm_il_fund_setup=actionBean.getPT_IL_BROK_ADV_HDR_BEAN();
		actionBean.getWarningMap().clear();
		actionBean.getErrorMap().clear();
		//String ROWID = getRowId(code);
		String selectQuery  = "select ROWID,PT_IL_BROK_ADV_HDR.* FROM PT_IL_BROK_ADV_HDR where ROWID= '" +code + "'";
		System.out.println("selectQuery"+selectQuery);
		con = CommonUtils.getConnection();
		System.out.println("CODE **********"+code);
		List list = handler.fetch(selectQuery, "com.iii.pel.forms.PILT018.PT_IL_BROK_ADV_HDR",con);
		pm_il_fund_setup = (PT_IL_BROK_ADV_HDR)list.get(0);

//		post query added by Amit Gupta - 36077 
		/*pm_il_fund_setup = actionBean.postQuery(pm_il_fund_setup);
		actionBean.setPT_IL_BROK_ADV_HDR_BEAN(pm_il_fund_setup);*/

		String BAH_CUST_CODE = actionBean.getPT_IL_BROK_ADV_HDR_BEAN().getBAH_CUST_CODE();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>BAH_CUST_CODE"+BAH_CUST_CODE);
		pm_il_fund_setup.setBAH_CUST_CODE(BAH_CUST_CODE);
		actionBean.setPT_IL_BROK_ADV_HDR_BEAN(pm_il_fund_setup);

		String BAH_CURR_CODE = actionBean.getPT_IL_BROK_ADV_HDR_BEAN().getBAH_CURR_CODE();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>BAH_CURR_CODE"+BAH_CURR_CODE);
		pm_il_fund_setup.setBAH_CURR_CODE(BAH_CURR_CODE);
		actionBean.setPT_IL_BROK_ADV_HDR_BEAN(pm_il_fund_setup);

		/*Double WAITING_PERIOD = actionBean.getPM_IL_FUND_SETUP_BEAN().getFS_SW_WAIT_PERIOD();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>WAITING_PERIOD"+WAITING_PERIOD);
		pm_il_fund_setup.setFS_SW_WAIT_PERIOD(WAITING_PERIOD);
		actionBean.setPM_IL_FUND_SETUP_BEAN(pm_il_fund_setup);*/
		//String sqlQuery = "SELECT ROWID,PM_IL_CLM_ACCOUNT_SETUP.* FROM PM_IL_CLM_ACCOUNT_SETUP";
		String sqlQuery = "SELECT ROWID,PT_IL_BROK_ADV_HDR.* FROM PT_IL_BROK_ADV_HDR";
		System.out.println("PT_IL_BROK_ADV_HDR_SEARCH_PAGE_ACTION.prepareDetails()-sqlQuery"+sqlQuery);

		Connection connection = CommonUtils.getConnection();
		if(connection != null){
			try {
				java.sql.Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sqlQuery);

				ArrayList<PT_IL_BROK_ADV_HDR> detailsList = new ArrayList<PT_IL_BROK_ADV_HDR>();
				while (resultSet.next()) {
					details = new PT_IL_BROK_ADV_HDR();
					details.setBAH_CUST_CODE(resultSet.getString("BAH_CUST_CODE"));
					//link_code = resultSet.getString("FS_CODE");
					//System.out.println("PM_IL_FUND_SETUP_SEARCH_PAGE.prepareDetails()-Link_code Is"+link_code);
					//details.setFS_DESC(resultSet.getString("FS_DESC"));
					//details.setFS_SW_WAIT_PERIOD(resultSet.getDouble("FS_SW_WAIT_PERIOD"));
					details.setROWID(resultSet.getString("ROWID"));
					System.out.println("getFS_BL_DESC"+details.getBAH_CURR_CODE());
					/*details.setFS_BL_DESC(resultSet.getString("FS_BL_DESC"));
					System.out.println("getFS_BL_DESC"+details.getFS_BL_DESC());
					details.setFS_BL_SHORT_DESC(resultSet.getString("FS_BL_SHORT_DESC"));*/
					detailsList.add(details);
				}



				//String sqlQuery1 = "SELECT * FROM PM_IL_FUND_PRICE_DTL where FPD_FS_CODE ='" + link_code +" '";


				//String sqlQuery1 = "SELECT * FROM PT_IL_BROK_ADV_DTL where BAD_BAH_SYS_ID ='"+BAH_CUST_CODE+"'";
				//System.out.println("------------sqlQuery1"+sqlQuery1);

				//ArrayList<PT_IL_BROK_ADV_DTL> childList = new ArrayList<PT_IL_BROK_ADV_DTL>();
				//ResultSet resultset1 = statement.executeQuery(sqlQuery1);

				//while(resultset1.next()){


				/*
					child = new PM_IL_FUND_PRICE_DTL();
					System.out.println("*************************************************");
					//child.setROWID(resultset1.getString("ROWID"));

					System.out.println(resultset1.getDouble("FPD_BUY_UNIT_RATE"));
					child.setFPD_BUY_UNIT_RATE(resultset1.getDouble("FPD_BUY_UNIT_RATE"));
					System.out.println(resultset1.getString("FPD_SELL_UNIT_RATE"));
					System.out.println(resultset1.getString("FPD_EFF_FM_DT"));
					System.out.println(resultset1.getString("FPD_EFF_TO_DT"));
					//System.out.println(resultset1.getString("ROWID"));





					System.out.println("ROW"+child.getROWID());
					System.out.println("BUY"+child.getFPD_BUY_UNIT_RATE());
					System.out.println("SELL"+child.getFPD_SELL_UNIT_RATE());
					System.out.println("FROM"+child.getFPD_EFF_FM_DT());
                    System.out.println("TO"+child.getFPD_EFF_TO_DT());


					System.out.println("*************************************************");
					childList.add(child);
				 */}catch (SQLException e) {
					 //e.printStackTrace();
					 //throw new Exception(e.getMessage());
				 }
		}
//      [BugId:PREMIAGDC-AGENCY- 0024 Amit Gupta 04-Feb-09 For handling enabling & disabling of approve buttons 
//		in Header and Detail Block and their respective actions.
		return actionBean;
// 		BugId:PREMIAGDC-AGENCY- 0024 Amit Gupta 04-Feb-09]		
	}
			
		//}	
		
		//}
	
	public String PILT018_goInsert(){
		FacesContext context = FacesContext.getCurrentInstance();
		ELResolver resolver = context.getApplication().getELResolver();
		//[PREMIAGDC-Agent Loan Management-000092:Shankar Bodduluri 03-Mar-09 Internal Fix
		//PT_IL_BROK_ADV_HDR_ACTION hdrAction= (PT_IL_BROK_ADV_HDR_ACTION)resolver.getValue(context.getELContext(), null, "PILT018_PT_IL_BROK_ADV_HDR_ACTION");
		PT_IL_BROK_ADV_HDR_ACTION hdrAction = new PT_IL_BROK_ADV_HDR_ACTION();
		//hdrAction.when_create_record();
		hdrAction.setAPPROVE_STATUS(false);
		
//      [BugId:PREMIAGDC-AGENCY- 0024 Amit Gupta 04-Feb-09 For handling enabling & disabling of approve buttons 
//		 in Header and Detail Block and their respective actions.
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("PILT018_PT_IL_BROK_ADV_HDR_ACTION", hdrAction);
//      BugId:PREMIAGDC-AGENCY- 0024 Amit Gupta 04-Feb-09]		
		return "PILT018_goNewRecord";
	}
	
	public void DeleteRow(ActionEvent ae) throws Exception{
		System.out.println("SearchPageDetailsAction.DeleteRow()");
		//PolicyDetails valuebean = null;
		
		PT_IL_BROK_ADV_HDR valuebean = null;
		int DeletedRecordIndex = 0;
		con = CommonUtils.getConnection();
		System.out.println("************************");
		System.out.println(BList.size()); 
		System.out.println("************************");
		if(BList != null){
			for(int index =0 ;index<BList.size();){
				valuebean = BList.get(index);
				System.out.println("ValueBean" +valuebean.toString());
				System.out.println("DataGridAction.deleteRow()-(bean.isCHECK_BOX()"+valuebean.isCHECK_BOX());
				if(valuebean.isCHECK_BOX()){
					BList.remove(valuebean);
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
	
	
	

	public String getInitBrokerCode() {
		return InitBrokerCode;
	}

	public void setInitBrokerCode(String initBrokerCode) {
		InitBrokerCode = initBrokerCode;
	}

	public String getInitCurrencyCode() {
		return InitCurrencyCode;
	}

	public void setInitCurrencyCode(String initCurrencyCode) {
		InitCurrencyCode = initCurrencyCode;
	}

	
	public String getSearchedName() {
		return SearchedName;
	}

	public void setSearchedName(String searchedName) {
		SearchedName = searchedName;
	}


	public PT_IL_BROK_ADV_HDR getSearchBean() {
		return searchBean;
	}


	public void setSearchBean(PT_IL_BROK_ADV_HDR searchBean) {
		this.searchBean = searchBean;
	}


	public String getBrokerCode() {
		return brokerCode;
	}


	public void setBrokerCode(String brokerCode) {
		this.brokerCode = brokerCode;
	}


	public String getCurrencyCode() {
		return currencyCode;
	}


	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}


	public ArrayList<PT_IL_BROK_ADV_HDR> getBList() {
		return BList;
	}


	public void setBList(ArrayList<PT_IL_BROK_ADV_HDR> list) {
		BList = list;
	}


 }
