package com.iii.pel.forms.PT051_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.richfaces.component.UIDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT051_A_SEARCH_PAGE_ACTION extends CommonAction{

	private HtmlInputText ABGT_AGENT_CODE;
	
	private HtmlInputText UI_M_ABGT_AGENT_NAME;
	
	private ArrayList<PT051_A_SEARCH_PAGE> searchList = new ArrayList<PT051_A_SEARCH_PAGE>();
	
	private UIDataTable searchDataTable;
	
	private PT051_A_SEARCH_PAGE searchBean;
	
	PT_AGENT_BUDGET budgetBean = null;

	public PT051_A_SEARCH_PAGE_ACTION() {
		searchBean = new PT051_A_SEARCH_PAGE();
	}

	public HtmlInputText getABGT_AGENT_CODE() {
		return ABGT_AGENT_CODE;
	}

	public void setABGT_AGENT_CODE(HtmlInputText abgt_agent_code) {
		ABGT_AGENT_CODE = abgt_agent_code;
	}
	
	public HtmlInputText getUI_M_ABGT_AGENT_NAME() {
		return UI_M_ABGT_AGENT_NAME;
	}
	
	public void setUI_M_ABGT_AGENT_NAME(HtmlInputText ui_m_abgt_agent_name) {
		UI_M_ABGT_AGENT_NAME = ui_m_abgt_agent_name;
	}
	
	public ArrayList<PT051_A_SEARCH_PAGE> getSearchList() {
		return searchList;
	}
	
	public void setSearchList(ArrayList<PT051_A_SEARCH_PAGE> searchList) {
		this.searchList = searchList;
	}
	
	public UIDataTable getSearchDataTable() {
		return searchDataTable;
	}
	
	public void setSearchDataTable(UIDataTable searchDataTable) {
		this.searchDataTable = searchDataTable;
	}
	
	public PT051_A_SEARCH_PAGE getSearchBean() {
		return searchBean;
	}
	
	public void setSearchBean(PT051_A_SEARCH_PAGE searchBean) {
		this.searchBean = searchBean;
	}
	
	//navigation
	public String goToPT051_A_AGENT_SEARCH_PAGE(){
		return "NAVIGATE_TO_AGENT_SEARCH_PAGE";
	}

	public void searchButton(ActionEvent event) throws Exception{
		System.out.println("++++++++++++PT051_A_SEARCH_PAGE_ACTION.searchButton()+++++++++++");
		searchList.clear();
		String query1 = "SELECT A.ROWID,A.ABGT_AGENT_CODE,C.CUST_NAME,A.ABGT_FM_DT,A.ABGT_TO_DT " +
		" FROM PT_AGENT_BUDGET A,PM_CUSTOMER C WHERE A.ABGT_AGENT_CODE = C.CUST_CODE AND A.ABGT_AGENT_CODE LIKE '"+searchBean.getABGT_AGENT_CODE()+"%'  AND C.CUST_NAME LIKE '"+searchBean.getUI_M_ABGT_AGENT_NAME()+"%'";

		Connection con = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = handler.executeSelectStatement(query1, con);
		while(rs.next()){
			PT051_A_SEARCH_PAGE page = new PT051_A_SEARCH_PAGE();
			page.setRowId(rs.getString(1));
			page.setABGT_AGENT_CODE(rs.getString(2));
			page.setUI_M_ABGT_AGENT_NAME(rs.getString(3));
			//as two date fileds are added in search page query and bean addition is modified
			page.setABGT_FM_DT(CommonUtils.dateToPELStringFormatter(rs.getDate(4)));
			page.setABGT_TO_DT(CommonUtils.dateToPELStringFormatter(rs.getDate(4)));
			searchList.add(page);
		}
		if (searchList.size() == 0) {
			getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath, "Search$NoRecord$Message"));
		}else{
			getWarningMap().clear();
		}
	}
	
	public String populateBlock() throws Exception{
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		System.out.println("Parameter ROWID = "+req.getParameter("rowID"));
		ResultSet rs1 = null;
		try{
//			Object[] values = {req.getParameter("rowID")};
			String selectQuery1 = "SELECT ROWID, PT_AGENT_BUDGET.* FROM PT_AGENT_BUDGET WHERE ROWID = '"+req.getParameter("rowID")+"'";
//			rs1 = getHandler().executeSelectStatement(selectQuery1, CommonUtils.getConnection(), values);
			/*List<PT_AGENT_BUDGET> list1 = getHandler().fetch(selectQuery1, "com.iii.pel.forms.PT051_A.PT_AGENT_BUDGET", CommonUtils.getConnection());
			if(!list1.isEmpty()){
				compositeAction = new PT051_A_COMPOSITE_ACTION();
				PT_AGENT_BUDGET_ACTION budgetAction =compositeAction.getPT_AGENT_BUDGET_ACTION_BEAN();
				budgetAction.setPT_AGENT_BUDGET_BEAN(list1.get(0));
				System.out.println("The agent code being passed in post query: "+budgetAction.getPT_AGENT_BUDGET_BEAN().getABGT_AGENT_CODE());
				budgetAction.postQuery(budgetAction.getPT_AGENT_BUDGET_BEAN().getABGT_AGENT_CODE());
			}*/
			rs1 = getHandler().executeSelectStatement(selectQuery1, CommonUtils.getConnection());
			PT051_A_COMPOSITE_ACTION compositeAction = new PT051_A_COMPOSITE_ACTION();
			PT_AGENT_BUDGET_ACTION budgetAction = compositeAction.getPT_AGENT_BUDGET_ACTION_BEAN();
			budgetBean = budgetAction.getPT_AGENT_BUDGET_BEAN();
			while(rs1.next()){
				budgetBean.setROWID(rs1.getString("ROWID"));
				budgetBean.setABGT_AGENT_CODE(rs1.getString("ABGT_AGENT_CODE"));
				budgetBean.setABGT_MODULE_ID(rs1.getString("ABGT_MODULE_ID"));
				//budgetBean.setABGT_NO_OF_POL(rs1.getDouble("ABGT_NO_OF_POL"));
				budgetBean.setABGT_LC_PREM(rs1.getDouble("ABGT_LC_PREM"));
				budgetBean.setABGT_FM_DT(rs1.getDate("ABGT_FM_DT"));
				budgetBean.setABGT_TO_DT(rs1.getDate("ABGT_TO_DT"));
				/*budgetBean.setUI_M_ABGT_AGENT_NAME(rs2.getString(8));
				budgetBean.setUI_M_ABGT_AGENCY_CODE(rs2.getString(2));
				budgetBean.setUI_M_ABGT_AGENCY_NAME(rs2.getString(8));*/
				budgetBean.setABGT_SYS_ID(rs1.getDouble("ABGT_SYS_ID"));
				budgetBean.setABGT_CR_DT(rs1.getDate("ABGT_CR_DT"));
				budgetBean.setABGT_CR_UID(rs1.getString("ABGT_CR_UID"));
				//budget.add(budgetBean);
			}
			//budgetAction.postQuery(budgetAction.getPT_AGENT_BUDGET_BEAN().getABGT_AGENT_CODE());
			sessionMap.put("PT051_A_COMPOSITE_ACTION", compositeAction);
			
			CommonUtils.setGlobalVariable("PT051_A_MODE", "QUERY_UPDATE");
		}catch(Exception e){
			e.printStackTrace();
		}
		return "NAVIGATE_TO_AGENT_BUDGET";
	}
	
	public CRUDHandler getHandler(){
		return new CRUDHandler();
	}

	
	/*public String populateBlock() throws Exception{
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = ctx.getExternalContext().getSessionMap();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		System.out.println("Parameter ROWID = "+req.getParameter("rowID"));
		String selectQuery1 = "SELECT ABGT_AGENT_CODE FROM PT_AGENT_BUDGET WHERE ROWID = '"+req.getParameter("rowID")+"'";

		Connection con = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs1 = handler.executeSelectStatement(selectQuery1, con);
		String ABGT_AGENT_CODE = null;
		while(rs1.next()){
			ABGT_AGENT_CODE = rs1.getString(1);
		}
		 POPULATING MAIN BLOCK (PT_AGENT_BUDGET) STARTS HERE
		String selectQuery2 = "SELECT A.ROWID,A.ABGT_AGENT_CODE,A.ABGT_MODULE_ID,A.ABGT_NO_OF_POL,A.ABGT_LC_PREM,A.ABGT_FM_DT,A.ABGT_TO_DT,C.CUST_NAME,A.ABGT_SYS_ID,A.ABGT_CR_DT,A.ABGT_CR_UID " +
		" FROM PT_AGENT_BUDGET A,PM_CUSTOMER C WHERE A.ABGT_AGENT_CODE = C.CUST_CODE AND A.ABGT_AGENT_CODE = '"+ABGT_AGENT_CODE+"'";

		ResultSet rs2 = handler.executeSelectStatement(selectQuery2, con);
		PT051_A_COMPOSITE_ACTION compositeAction = new PT051_A_COMPOSITE_ACTION();
		PT_AGENT_BUDGET_ACTION budgetAction =compositeAction.getPT_AGENT_BUDGET_ACTION_BEAN();
		budgetBean = budgetAction.getPT_AGENT_BUDGET_BEAN();
		//ArrayList<PT_AGENT_BUDGET> budget = new ArrayList<PT_AGENT_BUDGET>(); 
		while(rs2.next()){
			budgetBean.setROWID(rs2.getString(1));
			budgetBean.setABGT_AGENT_CODE(rs2.getString(2));
			budgetBean.setABGT_MODULE_ID(rs2.getString(3));
			budgetBean.setABGT_NO_OF_POL(rs2.getDouble(4));
			budgetBean.setABGT_LC_PREM(rs2.getDouble(5));
			budgetBean.setABGT_FM_DT(rs2.getDate("ABGT_FM_DT"));
			budgetBean.setABGT_TO_DT(rs2.getDate("ABGT_TO_DT"));
			budgetBean.setUI_M_ABGT_AGENT_NAME(rs2.getString(8));
			budgetBean.setUI_M_ABGT_AGENCY_CODE(rs2.getString(2));
			budgetBean.setUI_M_ABGT_AGENCY_NAME(rs2.getString(8));
			budgetBean.setABGT_SYS_ID(rs2.getString(9));
			budgetBean.setABGT_CR_DT(rs2.getDate(10));
			budgetBean.setABGT_CR_UID(rs2.getString(11));
			//budget.add(budgetBean);
		}
		sessionMap.put("PT051_A_COMPOSITE_ACTION", compositeAction);
		 POPULATING MAIN BLOCK (PT_AGENT_BUDGET) ENDS HERE
		
		 POPULATING RANK BLOCK (PT_AGENT_BUDGET_RANK) STARTS HERE
		String selectQuery3="SELECT A.ROWID,A.ABGTR_RANK_CODE,A.ABGTR_SHARE_PERC,A.ABGTR_SYS_ID,B.ABGT_SYS_ID,A.ABGTR_ABGT_SYS_ID,A.ABGTR_CR_DT,A.ABGTR_CR_UID FROM PT_AGENT_BUDGET_RANK A,PT_AGENT_BUDGET B " +
		" where A.ABGTR_ABGT_SYS_ID = B.ABGT_SYS_ID AND B.ABGT_AGENT_CODE='"+ABGT_AGENT_CODE+"'";
		
		ResultSet rs3 = handler.executeSelectStatement(selectQuery3, con);
		PT_AGENT_BUDGET_RANK_ACTION budgetAction1 = compositeAction.getPT_AGENT_BUDGET_RANK_ACTION_BEAN();
		ArrayList<PT_AGENT_BUDGET_RANK> budgetRankList=budgetAction1.getRankList();
		String ABGTR_SYS_ID = "";
		while(rs3.next()){
			PT_AGENT_BUDGET_RANK rank=new PT_AGENT_BUDGET_RANK();
			rank.setROWID(rs3.getString(1));
			rank.setABGTR_RANK_CODE(rs3.getString(2));
			rank.setABGTR_SHARE_PERC(rs3.getDouble(3));
			rank.setABGTR_SYS_ID(rs3.getString(4));
			rank.setUI_M_ABGTR_RANK_NAME(rankName(rs3.getString(2)));
			ABGTR_SYS_ID = rs3.getString(5);
			rank.setABGTR_SYS_ID(ABGTR_SYS_ID);
			rank.setABGTR_ABGT_SYS_ID(rs3.getString(6));
			rank.setABGTR_CR_DT(rs3.getDate(7));
			rank.setABGTR_CR_UID(rs3.getString(8));
			budgetRankList.add(rank);
		}
		sessionMap.put("ABGT_SYS_ID", ABGTR_SYS_ID);
		//sessionMap.put("PT051_A_COMPOSITE_ACTION", compositeAction);
		 POPULATING RANK BLOCK (PT_AGENT_BUDGET_RANK) ENDS HERE
		
		 POPULATING BREAKUP BLOCK (PT_AGENT_BUDGET_BREAKUP) STARTS HERE
		String selectQuery4="SELECT A.ROWID,A.ABGTB_AGENT_CODE,A.ABGTB_SHARE_PERC,A.ABGTB_NO_OF_POL,A.ABGTB_LC_PREM,A.ABGTB_ACT_NO_OF_POL," +
				"A.ABGTB_ACT_LC_PREM,A.ABGTB_SYS_ID,C.CUST_NAME,A.ABGTB_CR_DT,A.ABGTB_CR_UID,A.ABGTB_ABGT_SYS_ID FROM PT_AGENT_BUDGET_BREAKUP A,PT_AGENT_BUDGET B,PM_CUSTOMER C" +
				" where A.ABGTB_ABGT_SYS_ID = B.ABGT_SYS_ID AND C.CUST_CODE ='"+ABGT_AGENT_CODE+"' AND B.ABGT_AGENT_CODE='"+ABGT_AGENT_CODE+"'";
		ResultSet rs4 = handler.executeSelectStatement(selectQuery4, con);
		
		PT_AGENT_BUDGET_BREAKUP_ACTION budgetAction4 = compositeAction.getPT_AGENT_BUDGET_BREAKUP_ACTION_BEAN();
		ArrayList<PT_AGENT_BUDGET_BREAKUP> budgetBreakupList=budgetAction4.getBreakupList();
		while(rs4.next()){
			PT_AGENT_BUDGET_BREAKUP breakup=new PT_AGENT_BUDGET_BREAKUP();
			breakup.setROWID(rs4.getString(1));
			breakup.setABGTB_AGENT_CODE(rs4.getString(2));
			breakup.setABGTB_SHARE_PERC(rs4.getDouble(3));
			breakup.setABGTB_NO_OF_POL(rs4.getDouble(4));
			breakup.setABGTB_LC_PREM(rs4.getDouble(5));
			breakup.setABGTB_ACT_NO_OF_POL(rs4.getDouble(6));
			breakup.setABGTB_ACT_LC_PREM(rs4.getDouble(7));
			breakup.setABGTB_SYS_ID(rs4.getString(8));
			breakup.setUI_M_ABGTB_AGENT_NAME(rs4.getString(9));
			breakup.setABGTB_CR_DT(rs4.getDate(10));
			breakup.setABGTB_CR_UID(rs4.getString(11));
			breakup.setABGTB_ABGT_SYS_ID(rs4.getString(12));
			System.out.println("AGENT NAME---"+breakup.getUI_M_ABGTB_AGENT_NAME());
			System.out.println("BREAK UP SYSID>>>>>>>"+breakup.getABGTB_SYS_ID());
			budgetBreakupList.add(breakup);
		}
		//sessionMap.put("PT051_A_PT_AGENT_BUDGET_BREAKUP_ACTION", budgetAction4);
		 POPULATING BREAKUP BLOCK (PT_AGENT_BUDGET_BREAKUP) ENDS HERE
		
		return "NAVIGATE_TO_AGENT_BUDGET";
	}*/
	
	//HANDLING DELETE BUTTON IN SEARCH PAGE  STARTS HERE
	public void searchPageDelete(ActionEvent event) throws Exception{
		System.out.println("PT051_A_SEARCH_PAGE_ACTION.searchPageDelete()");
			int header = 0;
				for(int index = 0; index < searchList.size();){
					PT051_A_SEARCH_PAGE pageBean = (PT051_A_SEARCH_PAGE)searchList.get(index);
					if(pageBean.isCheckbox())
					{
						int temp = deleteFromSearch(pageBean);
						searchList.remove(pageBean);
						if(temp==1){
							header++;
						}
					}else{
						index++;
					}
				}
		}
	
	public int deleteFromSearch(PT051_A_SEARCH_PAGE bean) throws Exception{
		System.out.println("PT051_A_SEARCH_PAGE_ACTION.deleteFromHeader()");

		CRUDHandler handler = new CRUDHandler();
		Connection connection  = CommonUtils.getConnection();
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = ctx.getExternalContext().getSessionMap();
		
		String agentCode=bean.getABGT_AGENT_CODE();
		String SysId=null;
		System.out.println("PT051_A_SEARCH_PAGE_ACTION.deleteFromHeader()"+agentCode);
		String query ="SELECT ABGT_SYS_ID FROM PT_AGENT_BUDGET WHERE ABGT_AGENT_CODE='"+agentCode+"'";
		ResultSet rs=handler.executeSelectStatement(query, connection);
		if(rs.next())
			SysId=rs.getString(1);
		String query1 = "DELETE FROM PT_AGENT_BUDGET_RANK WHERE ABGTR_ABGT_SYS_ID ='"+SysId+"' ";
		String query2 = "DELETE FROM PT_AGENT_BUDGET_BREAKUP WHERE ABGTB_ABGT_SYS_ID ='"+SysId+"'";
		String query3 = "DELETE FROM PT_AGENT_BUDGET WHERE ABGT_SYS_ID = '"+SysId+"'";
		
		int cust = handler.executeDeleteStatement(query1, connection);
		System.out.println("No. of CUST Fields Deleted = "+cust);
		int prod = handler.executeDeleteStatement(query2, connection);
		System.out.println("No. of PROD Fields Deleted = "+prod);
		int header = handler.executeDeleteStatement(query3, connection);
		System.out.println("No. of HEADER Fields Deleted = "+header);
		connection.commit();
		//connection.close();
		return header;
	}
	//HANDLING DELETE BUTTON IN SEARCH PAGE  ENDS HERE
	
	//TO POPULATE RANK NAME WHILE LOADING
	private String rankName(String str)throws Exception{
		CRUDHandler handler = new CRUDHandler();
		Connection connection  = CommonUtils.getConnection();
		String name=null;
		String Query="SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE='AGNRANK' " +
				" AND PC_FRZ_FLAG='N' AND PC_CLASS_CODE IS NULL AND PC_CODE='"+str+"'";
		ResultSet rs=handler.executeSelectStatement(Query,	connection);
		while(rs.next()) {
			name=rs.getString(2);
			System.out.println("Rank Name Method-"+name);
		}
		return name;
	}
	
	// INSERT NAVIGATION
	public String insertNavigation() throws Exception {
		/*CommonUtils utils = new CommonUtils();
		PT051_A_COMPOSITE_ACTION compositeBean = (PT051_A_COMPOSITE_ACTION) utils.getMappedBeanFromSession("PT051_A_COMPOSITE_ACTION");
		PT_AGENT_BUDGET_ACTION budgetAction = compositeBean.getPT_AGENT_BUDGET_ACTION_BEAN();
		budgetAction.whenCreateRecord();*/
		CommonUtils.setGlobalVariable("PT051_A_MODE", "INSERT");
		HttpSession session=(HttpSession)(FacesContext.getCurrentInstance().getExternalContext().getSession(true));
		PT051_A_COMPOSITE_ACTION compositeAction=new PT051_A_COMPOSITE_ACTION();
		session.setAttribute("PT051_A_COMPOSITE_ACTION",compositeAction);
		return "NAVIGATE_TO_AGENT_BUDGET";
	}

	
	 public String updateButtonAction(String rowId) {
		 PT051_A_COMPOSITE_ACTION compositeAction = new PT051_A_COMPOSITE_ACTION();
			String outcome = null;
			FacesContext context = FacesContext.getCurrentInstance();
			Map requestParameterMap = context.getExternalContext()
				.getRequestParameterMap();
		
			CommonUtils.setGlobalObject("PT051_A_COMPOSITE_ACTION",
				compositeAction);
			compositeAction.getPT_AGENT_BUDGET_ACTION_BEAN().getPT_AGENT_BUDGET_BEAN().setROWID(rowId);
		
			outcome = "agentBudget";
			return outcome;
	    }

	    public String insertButtonAction() {
	    	 PT051_A_COMPOSITE_ACTION compositeAction = new PT051_A_COMPOSITE_ACTION();
			String outcome = null;
			CommonUtils.setGlobalObject("PT051_A_COMPOSITE_ACTION",
				compositeAction);
			outcome = "agentBudget";
			return outcome;
		
		    }
		
	    
		   public String backToSearch() {
				return SearchConstants.BACK_TO_SEARCH_PAGE;
		   }
		 
	
	
}
