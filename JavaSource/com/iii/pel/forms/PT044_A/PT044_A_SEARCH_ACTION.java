package com.iii.pel.forms.PT044_A;

import java.util.ArrayList;

import javax.faces.component.html.HtmlDataTable;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT044_A_SEARCH_ACTION extends CommonAction {
	private HtmlDataTable dataTable;
	private ArrayList<PT_AGENT_TRAN_HDR> listValue;
	private int currPage;
	private String initAgent_Code;
	private String initpParent_Code;

	private String filterNewAgentCode;
	private String filterAgentRank;
	private String filterTERMINATION_TYPE;
	private String filterAgent_Code;
	private String filterParent_Code;
	private String searchAgentRowId;
	int rowCount = 10;

	public PT044_A_SEARCH_ACTION() {
		currPage = 1;
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public ArrayList<PT_AGENT_TRAN_HDR> getListValue() {
		return listValue;
	}

	public void setListValue(ArrayList<PT_AGENT_TRAN_HDR> listValue) {
		this.listValue = listValue;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public String getInitAgent_Code() {
		return initAgent_Code;
	}

	public void setInitAgent_Code(String initAgent_Code) {
		this.initAgent_Code = initAgent_Code;
	}

	public String getFilterAgent_Code() {
		return filterAgent_Code;
	}

	public void setFilterAgent_Code(String filterAgent_Code) {
		this.filterAgent_Code = filterAgent_Code;
	}

	public String getSearchAgentRowId() {
		return searchAgentRowId;
	}

	public void setSearchAgentRowId(String searchAgentRowId) {
		this.searchAgentRowId = searchAgentRowId;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public String getInitpParent_Code() {
		return initpParent_Code;
	}

	public void setInitpParent_Code(String initpParent_Code) {
		this.initpParent_Code = initpParent_Code;
	}

	public String getFilterParent_Code() {
		return filterParent_Code;
	}

	public void setFilterParent_Code(String filterParent_Code) {
		this.filterParent_Code = filterParent_Code;
	}

	public String getFilterTERMINATION_TYPE() {
		return filterTERMINATION_TYPE;
	}

	public void setFilterTERMINATION_TYPE(String filterTERMINATION_TYPE) {
		this.filterTERMINATION_TYPE = filterTERMINATION_TYPE;
	}

	public String getFilterAgentRank() {
		return filterAgentRank;
	}

	public void setFilterAgentRank(String filterAgentRank) {
		this.filterAgentRank = filterAgentRank;
	}

	public String getFilterNewAgentCode() {
		return filterNewAgentCode;
	}

	public void setFilterNewAgentCode(String filterNewAgentCode) {
		this.filterNewAgentCode = filterNewAgentCode;
	}

	public String getAgentDetails() {
		PT044_A_DELEGATE delegate = new PT044_A_DELEGATE();
		PT044_A_COMPOSITE_ACTION compositeAction = null;
		DUMMY dummy = delegate.dummyValues();
		listValue = delegate.fetchSearchDetails(this);

		compositeAction = new PT044_A_COMPOSITE_ACTION();

		if (listValue.size() == 0) {
			getWarningMap().put("current",Messages.getString("messageProperties-PM006_A_APAC","PM006_A_APAC$PM_CUSTOMER_SEARCH$NORECORD$MESSAGE"));
		} else {
			getWarningMap().clear();
		}
		compositeAction.setDUMMY_BEAN(dummy);
		CommonUtils.setGlobalObject("PT044_A_COMPOSITE_ACTION", compositeAction);
		return null;
	}

	public String clearList() {
		String returnStr = "headerMainPage";
		PT044_A_DELEGATE delegate = new PT044_A_DELEGATE();
		PT044_A_COMPOSITE_ACTION compositeAction = null;
		PT_AGENT_TRAN_HDR_ACTION headerAction = null;
		PT_AGENT_TRAN_HDR localBean = null;
		compositeAction = new PT044_A_COMPOSITE_ACTION();
		headerAction = new PT_AGENT_TRAN_HDR_ACTION();
		localBean = delegate.fetchHeaderBeanValues(searchAgentRowId);
		if (localBean == null) {
			localBean = new PT_AGENT_TRAN_HDR();
		}
		delegate.pt_agent_tran_hdr_pre_query(localBean);
		headerAction.setPT_AGENT_TRAN_HDR_BEAN(localBean);
		delegate.pt_agent_tran_hdr_when_new_record_instance(compositeAction);

		//if record is approved then all details block fields and buttons are disabled--Varun[50663]
		if("A".equals(headerAction.getPT_AGENT_TRAN_HDR_BEAN().getATH_APPRV_FLAG())){
			compositeAction.setDisableOnApprovalFlag(true);
		}else{
			compositeAction.setDisableOnApprovalFlag(false);
		}
		compositeAction.setPT_AGENT_TRAN_HDR_ACTION_BEAN(headerAction);
		//compositeAction.checkApproveRecord();
		CommonUtils.setGlobalObject("PT044_A_COMPOSITE_ACTION", compositeAction);
//		Added by Amit Gupta
		CommonUtils.setGlobalVariable("PT044_A_Mode", "Query");
		this.listValue = null;
		return returnStr;
	}

	public String newRecordAction() {
		String returnStr = "headerMainPage";
		PT044_A_COMPOSITE_ACTION compositeAction = null;
		PT044_A_DELEGATE delegate = new PT044_A_DELEGATE(); 
		PT_AGENT_TRAN_HDR_ACTION action = new PT_AGENT_TRAN_HDR_ACTION();
		PT_AGENT_TRAN_HDR headerBan = new PT_AGENT_TRAN_HDR();
		compositeAction = new PT044_A_COMPOSITE_ACTION();

		DUMMY dummy = delegate.dummyValues();

		delegate.pt_agent_tran_hdr_when_create_record(headerBan);
		delegate.pt_agent_tran_hdr_when_new_record_instance(compositeAction);
		action.setPT_AGENT_TRAN_HDR_BEAN(headerBan);
		//	[Bug id -PREMIAGDC-000151 : disabling approve button when creating new record: added by: Shankar bodduluri Dated: 17-Mar-2009 ]
		action.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
		compositeAction.setPT_AGENT_TRAN_HDR_ACTION_BEAN(action);
		//NOT NEEDED AS COMPOSITE ACTION IS INSTANTIATED [Varun-50663]//
		/*compositeAction.setPT_AGENT_TRAN_DTLS_ACTION_BEAN(new PT_AGENT_TRAN_DTLS_ACTION());
		compositeAction.setPT_AGENT_POL_DTLS_ACTION_BEAN(new PT_AGENT_POL_DTLS_ACTION());
		compositeAction.setPT_AGENT_CHKLST_STATUS_ACTION_BEAN(new PT_AGENT_CHKLST_STATUS_ACTION());*/

		compositeAction.setDUMMY_BEAN(dummy);

		CommonUtils.setGlobalObject("PT044_A_COMPOSITE_ACTION", compositeAction);
//		Added by Amit Gupta
		CommonUtils.setGlobalVariable("PT044_A_Mode", "Insert");
		return returnStr;
	}
	public String updateButtonAction(String rowId){
		PT044_A_COMPOSITE_ACTION compositeAction = new PT044_A_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PT044_A_COMPOSITE_ACTION",compositeAction);
		compositeAction.getPT_AGENT_TRAN_HDR_ACTION_BEAN().getPT_AGENT_TRAN_HDR_BEAN().setROWID(rowId);
		outcome = "headerMainPage";
		return outcome;
		
	}
	public String insertButtonAction(){
		PT044_A_COMPOSITE_ACTION compositeAction = new PT044_A_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PT044_A_COMPOSITE_ACTION",compositeAction);
		CommonUtils.setGlobalVariable("PT044_A_Mode", "Insert");
		outcome = "headerMainPage";
		return outcome;
		
	}
	
	/*Added by Jagadeesh on 25-4-2016 for TISB POC*/
	 public StringBuffer customizeQuery(StringBuffer query, ArrayList<Object> valueList){
		 System.out.println("Enter into customizeQuery for Agent processing");
	    	int whereIndex = query.indexOf("WHERE")+6;
	    	query.insert(whereIndex, " ATH_TYPE=? AND ");
	    	valueList.add(CommonUtils.getGlobalObject("GLOBAL.M_PARAM_1"));   		    	
	    	return query;
	    }
	 /*End*/
	 
}
