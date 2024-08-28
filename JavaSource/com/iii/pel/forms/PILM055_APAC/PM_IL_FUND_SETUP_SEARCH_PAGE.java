package com.iii.pel.forms.PILM055_APAC;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.el.ELResolver;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_FUND_SETUP_SEARCH_PAGE extends CommonAction {

	private HtmlDataTable dataTable;
	private ArrayList<PM_IL_FUND_SETUP>Fundlist;
	private String InitFundCode;
	private String InitFundDescription;
	private String SearchedName;
	PM_IL_FUND_SETUP searchBean;
	CRUDHandler handler = new CRUDHandler();
	private ResultSet resultSet;
	Connection con = null;
	ServletContext context;
	PM_IL_FUND_SETUP details = null;
	PM_IL_FUND_PRICE_DTL child = null;
	
	String FS_CODE = null;
	Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	
	// Clear list in action
	public String clearList() throws Exception{
		FacesContext context = FacesContext.getCurrentInstance();
		
		HttpServletRequest request = (HttpServletRequest) context		.getExternalContext().getRequest();
		//HttpSession session = request.getSession();
		String code = request.getParameter("ROWID");
		String selectQuery = "Select FS_CODE  from PM_IL_FUND_SETUP where ROWID ='"+code+"'";

		System.out.println("PM_IL_FUND_SETUP_SEARCH_PAGE.clearList()-FS_CODE"+FS_CODE); 
		//session.put("FS_CODE",FS_CODE);
		/*System.out.println("66666666666666666666666666666666");
		System.out.println(session.get("FS_CODE"));*/
		
		//this.policyList = null;
		ELResolver resolver = context.getApplication().getELResolver();
		PM_IL_FUND_SETUP_ACTION actionBean= (PM_IL_FUND_SETUP_ACTION)resolver.getValue(context.getELContext(), null, "PILM055_APAC_PM_IL_FUND_SETUP_ACTION");
		prepareDetails(code,actionBean);
		String returnStr = "PILM055_APAC_goMainPage";
		//actionBean.PM_IL_PM_IL_BANK_ACCOUNT_SETUP_POST_QUERY();
		return returnStr;
	}
	
	

	
	public String fetchPolicyDetails(){
		
		PM_IL_FUND_SETUP_DELEGATE delegate = new PM_IL_FUND_SETUP_DELEGATE();
		setINSERT_ALLOWED(false);
		setUPDATE_ALLOWED(true);
		setDELETE_ALLOWED(true);
		try {
			this.Fundlist = delegate.fetchPolicyDetails(this);
		} catch (Exception e) {
			// TODO do appropriate settings for  the message to display to the user
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void checkBoxStatus(ActionEvent event){
		
		
		
	}
	
	
	public void DeleteRow(ActionEvent ae) throws Exception{
		System.out.println("SearchPageDetailsAction.DeleteRow()");
		//PolicyDetails valuebean = null;
		
		PM_IL_FUND_SETUP valuebean = null;
		int DeletedRecordIndex = 0;
		con = CommonUtils.getConnection();
		System.out.println("************************");
		System.out.println(Fundlist.size()); 
		System.out.println("************************");
		if(Fundlist != null){
			for(int index =0 ;index<Fundlist.size();){
				valuebean = Fundlist.get(index);
				System.out.println("ValueBean" +valuebean.toString());
				System.out.println("DataGridAction.deleteRow()-(bean.isCHECK_BOX()"+valuebean.isCHECK_BOX());
				if(valuebean.isCHECK_BOX()){
					Fundlist.remove(valuebean);
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
	
	
	
	private void  prepareDetails(String code,PM_IL_FUND_SETUP_ACTION actionBean) throws Exception {
		String link_code = null;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		if(actionBean == null) {
			System.out.println("bean null");
		}
		session.setAttribute("PILM055_APAC_PM_IL_FUND_SETUP_ACTION", actionBean);
		PM_IL_FUND_SETUP pm_il_fund_setup=actionBean.getPM_IL_FUND_SETUP_BEAN();
		
		
		//String ROWID = getRowId(code);
		String selectQuery  = "select ROWID,PM_IL_FUND_SETUP.* FROM PM_IL_FUND_SETUP where ROWID= '" +code + "'";
		System.out.println("selectQuery"+selectQuery);
		con = CommonUtils.getConnection();
		System.out.println("CODE **********"+code);
		List list = handler.fetch(selectQuery, "com.iii.pel.forms.PILM055_APAC.PM_IL_FUND_SETUP",con);
		
		pm_il_fund_setup = (PM_IL_FUND_SETUP)list.get(0);
		actionBean.setPM_IL_FUND_SETUP_BEAN(pm_il_fund_setup);
		
		
		
		
		/*String FS_CODE = actionBean.getPM_IL_FUND_SETUP_BEAN().getFS_CODE();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>FS_CODE"+FS_CODE);
		pm_il_fund_setup.setFS_CODE(FS_CODE);
		actionBean.setPM_IL_FUND_SETUP_BEAN(pm_il_fund_setup);
		
		String FS_DESC = actionBean.getPM_IL_FUND_SETUP_BEAN().getFS_DESC();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>FS_DESC"+FS_DESC);
		pm_il_fund_setup.setFS_DESC(FS_DESC);
		actionBean.setPM_IL_FUND_SETUP_BEAN(pm_il_fund_setup);
		*/
		/*Double WAITING_PERIOD = actionBean.getPM_IL_FUND_SETUP_BEAN().getFS_SW_WAIT_PERIOD();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>WAITING_PERIOD"+WAITING_PERIOD);
		pm_il_fund_setup.setFS_SW_WAIT_PERIOD(WAITING_PERIOD);
		actionBean.setPM_IL_FUND_SETUP_BEAN(pm_il_fund_setup);*/
		//String sqlQuery = "SELECT ROWID,PM_IL_CLM_ACCOUNT_SETUP.* FROM PM_IL_CLM_ACCOUNT_SETUP";
		//String sqlQuery = "SELECT ROWID,FS_CODE,PM_IL_FUND_SETUP.* FROM PM_IL_FUND_SETUP";
		
		
		
		if(con != null){
			try {
			 	java.sql.Statement statement = con.createStatement();
				ResultSet resultSet = statement.executeQuery(selectQuery);
				ArrayList<PM_IL_FUND_SETUP> detailsList = new ArrayList<PM_IL_FUND_SETUP>();
				while (resultSet.next()) {
					details = new PM_IL_FUND_SETUP();
					details.setFS_CODE(resultSet.getString("FS_CODE"));
					link_code = resultSet.getString("FS_CODE");
					System.out.println("PM_IL_FUND_SETUP_SEARCH_PAGE.prepareDetails()-Link_code Is"+link_code);
					//details.setFS_DESC(resultSet.getString("FS_DESC"));
					//details.setFS_SW_WAIT_PERIOD(resultSet.getDouble("FS_SW_WAIT_PERIOD"));
					details.setROWID(resultSet.getString("ROWID"));
					details.setFS_FRZ_YN(resultSet.getString("FS_FRZ_YN"));
					System.out.println("RS>>>>>>>>"+resultSet.getString("FS_FRZ_YN"));
					System.out.println("setFS_FRZ_YN>>>>"+details.getFS_FRZ_YN());
					System.out.println("getFS_BL_DESC"+details.getFS_BL_DESC());
					/*details.setFS_BL_DESC(resultSet.getString("FS_BL_DESC"));
					System.out.println("getFS_BL_DESC"+details.getFS_BL_DESC());
					details.setFS_BL_SHORT_DESC(resultSet.getString("FS_BL_SHORT_DESC"));*/
					detailsList.add(details);
				}
				
				
				
				//String sqlQuery1 = "SELECT * FROM PM_IL_FUND_PRICE_DTL where FPD_FS_CODE ='" + link_code +" '";
				
				
				String sqlQuery1 = "SELECT * FROM PM_IL_FUND_PRICE_DTL where FPD_FS_CODE ='"+FS_CODE+"'";
				System.out.println("------------sqlQuery1"+sqlQuery1);
								
				ArrayList<PM_IL_FUND_PRICE_DTL> childList = new ArrayList<PM_IL_FUND_PRICE_DTL>();
				ResultSet resultset1 = statement.executeQuery(sqlQuery1);
				
				
				while(resultset1.next()){
					child = new PM_IL_FUND_PRICE_DTL();
					System.out.println("*************************************************");
					child.setROWID(resultset1.getString("ROWID"));
					
					System.out.println(resultset1.getDouble("FPD_BUY_UNIT_RATE"));
					child.setFPD_BUY_UNIT_RATE(resultset1.getDouble("FPD_BUY_UNIT_RATE"));
					System.out.println(resultset1.getString("FPD_SELL_UNIT_RATE"));
					System.out.println(resultset1.getString("FPD_EFF_FM_DT"));
					System.out.println(resultset1.getString("FPD_EFF_TO_DT"));
					//System.out.println(resultset1.getString("ROWID"));
					
					/*Added by saritha on 29-03-2018 for KIC Rates to be captured under unit details to be Bid price(buy), Offer price(sell) and unit price. 
					 *The Unit price rate capturing provision to be required. This will be revised whenever buy and sell rate change
					 *
					 */
					child.setFPD_UNIT_PRICE_RATE(resultset1.getDouble("FPD_UNIT_PRICE_RATE"));
					/*End*/

					
					
					System.out.println("ROW"+child.getROWID());
					System.out.println("BUY"+child.getFPD_BUY_UNIT_RATE());
					System.out.println("SELL"+child.getFPD_SELL_UNIT_RATE());
					System.out.println("FROM"+child.getFPD_EFF_FM_DT());
                    System.out.println("TO"+child.getFPD_EFF_TO_DT());
                    
                    
					System.out.println("*************************************************");
					childList.add(child);
				}
				
			}catch (SQLException e) {
				e.printStackTrace();
				//throw new Exception(e.getMessage());
			}finally{
				//connection.close();
			}
		
		}
		/*String FS_BL_DESC = details.getFS_BL_DESC();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>FS_BL_DESC"+FS_BL_DESC);
		pm_il_fund_setup.setFS_BL_DESC(FS_BL_DESC);
		actionBean.setPM_IL_FUND_SETUP_BEAN(pm_il_fund_setup);
		
		String FS_BL_SHORT_DESC = details.getFS_BL_SHORT_DESC();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>FS_BL_SHORT_DESC"+FS_BL_SHORT_DESC);
		pm_il_fund_setup.setFS_BL_SHORT_DESC(FS_BL_SHORT_DESC);
		actionBean.setPM_IL_FUND_SETUP_BEAN(pm_il_fund_setup);
		
		String FS_LONG_DESC = details.getFS_LONG_DESC();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>FS_LONG_DESC"+FS_LONG_DESC);
		pm_il_fund_setup.setFS_LONG_DESC(FS_LONG_DESC);
		actionBean.setPM_IL_FUND_SETUP_BEAN(pm_il_fund_setup);
		
		String FS_FRAC_UNIT_YN = details.getFS_FRAC_UNIT_YN();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>FS_FRAC_UNIT_YN"+FS_FRAC_UNIT_YN);
		pm_il_fund_setup.setFS_FRAC_UNIT_YN(FS_FRAC_UNIT_YN);
		actionBean.setPM_IL_FUND_SETUP_BEAN(pm_il_fund_setup);
		
		String FS_FUND_TYPE = details.getFS_FUND_TYPE();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>FS_FUND_TYPE"+FS_FUND_TYPE);
		pm_il_fund_setup.setFS_FUND_TYPE(FS_FUND_TYPE);
		actionBean.setPM_IL_FUND_SETUP_BEAN(pm_il_fund_setup);
		
				
		String FS_ROUND_OPTION = details.getFS_ROUND_OPTION();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>FS_ROUND_OPTION"+FS_ROUND_OPTION);
		pm_il_fund_setup.setFS_ROUND_OPTION(FS_ROUND_OPTION);
		actionBean.setPM_IL_FUND_SETUP_BEAN(pm_il_fund_setup);
		
		String FS_ROUND_VALUE = details.getFS_ROUND_VALUE();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>FS_ROUND_VALUE"+FS_ROUND_VALUE);
		pm_il_fund_setup.setFS_ROUND_VALUE(FS_ROUND_VALUE);	
		actionBean.setPM_IL_FUND_SETUP_BEAN(pm_il_fund_setup);*/
		
		String FS_FREEZE_VALUE = details.getFS_FRZ_YN();
		System.out.println("++++++++++++++++++"+details.getFS_CODE());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>FS_FREEZE_VALUE"+FS_FREEZE_VALUE);
		pm_il_fund_setup.setFS_FRZ_YN_VALUE(getFlag_Status(pm_il_fund_setup));	
		actionBean.setPM_IL_FUND_SETUP_BEAN(pm_il_fund_setup);
		
	}
	
	public boolean getFlag_Status(PM_IL_FUND_SETUP valueBean){
		System.out.println("PM_IL_FUND_SETUP_SEARCH_PAGE.getFlag_Status()*************");
		System.out.println(valueBean.getFS_FRZ_YN());
		System.out.println("PM_IL_FUND_SETUP_SEARCH_PAGE.getFlag_Status()*************");
		boolean status = false;
		if(valueBean.getFS_FRZ_YN()!=null){
			if(valueBean.getFS_FRZ_YN().equals("Y")){
			status = true;
			}else{
			status=false;
		  }
	    }
    	return status;
   }
	
	/*public Connection getConnection() throws Exception{
		context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		con=((SimpleConnectionAgent)context.getAttribute("connectionAgent")).getConnection("123456");
		
		return con;
   }*/

	



	

	public PM_IL_FUND_SETUP_SEARCH_PAGE() {
		super();
		Fundlist = new ArrayList<PM_IL_FUND_SETUP>();
		searchBean = new PM_IL_FUND_SETUP();
	
    	}


	public String clearSession() {
		System.out.println("PM_IL_FUND_SETUP.clearSession()-Inside");
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
			.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		System.out.println("SESSSSSSSSSIIIII"+session.getAttribute("PM_IL_FUND_SETUP"));
		if (session.getAttribute("PILM055_APAC_PM_IL_FUND_SETUP_ACTION") != null) {
			System.out.println("PM_IL_FUND_SETUP.clearSession()-Session Is Active");
			session.removeAttribute("PILM055_APAC_PM_IL_FUND_SETUP_ACTION");
		}
		setINSERT_ALLOWED(true);
		setUPDATE_ALLOWED(true);
		return "PILM055_APAC_goMainPage";
	}

	
	public String goInsert(){
		System.out.println("PM_IL_FUND_SETUP_SEARCH_PAGE.goInsert()-Inside");
		FacesContext context = FacesContext.getCurrentInstance();
    	HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		if (session.getAttribute("PM_IL_FUND_SETUP") != null) {
			System.out.println("PM_IL_FUND_SETUP.clearSession()-Session Is Active");
			session.removeAttribute("PM_IL_FUND_SETUP");
		}
		return "PILM055_APAC_goNewRecord";
	}
	
	public PM_IL_FUND_SETUP getSearchBean() {
		return searchBean;
	}




	public void setSearchBean(PM_IL_FUND_SETUP searchBean) {
		this.searchBean = searchBean;
	}




	public String getInitFundCode() {
		return InitFundCode;
	}




	public void setInitFundCode(String initFundCode) {
		InitFundCode = initFundCode;
	}




	public String getInitFundDescription() {
		return InitFundDescription;
	}




	public void setInitFundDescription(String initFundDescription) {
		InitFundDescription = initFundDescription;
	}




	


	public String getSearchedName() {
		return SearchedName;
	}




	public void setSearchedName(String searchedName) {
		SearchedName = searchedName;
	}




	public HtmlDataTable getDataTable() {
		return dataTable;
	}




	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}




	public ArrayList<PM_IL_FUND_SETUP> getFundlist() {
		return Fundlist;
	}




	public void setFundlist(ArrayList<PM_IL_FUND_SETUP> fundlist) {
		Fundlist = fundlist;
	}




	




	/*public String getInitWaitingPeriod() {
		return InitWaitingPeriod;
	}




	public void setInitWaitingPeriod(String initWaitingPeriod) {
		InitWaitingPeriod = initWaitingPeriod;
	}*/
	}
