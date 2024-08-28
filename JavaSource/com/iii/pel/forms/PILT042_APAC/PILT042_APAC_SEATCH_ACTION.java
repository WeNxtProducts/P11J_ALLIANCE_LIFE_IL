package com.iii.pel.forms.PILT042_APAC;

import java.util.ArrayList;

import javax.faces.component.html.HtmlDataTable;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PILT042_APAC_SEATCH_ACTION extends CommonAction{
	private HtmlDataTable dataTable;
	private ArrayList<PT_IL_PRE_CLAIMS_INFO> listValue;
	private String searchClaimRowId;
	private int currPage;
	int rowCount =10;
	
	private String initPol_NO;
	private String initREF_ID;
	private String initNew_IC_No;
	private String initOld_IC_No;
	
	private String filterPol_NO;
	private String filterREF_ID;
	private String filterNew_IC_No;
	private String filterOld_IC_No;
	
	
	public PILT042_APAC_SEATCH_ACTION() {
		currPage = 1;
	}
	public HtmlDataTable getDataTable() {
		return dataTable;
	}
	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}
	public ArrayList<PT_IL_PRE_CLAIMS_INFO> getListValue() {
		return listValue;
	}
	public void setListValue(ArrayList<PT_IL_PRE_CLAIMS_INFO> listValue) {
		this.listValue = listValue;
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public String getInitPol_NO() {
		return initPol_NO;
	}
	public void setInitPol_NO(String initPol_NO) {
		this.initPol_NO = initPol_NO;
	}
	public String getInitNew_IC_No() {
		return initNew_IC_No;
	}
	public void setInitNew_IC_No(String initNew_IC_No) {
		this.initNew_IC_No = initNew_IC_No;
	}
	public String getInitOld_IC_No() {
		return initOld_IC_No;
	}
	public void setInitOld_IC_No(String initOld_IC_No) {
		this.initOld_IC_No = initOld_IC_No;
	}
	public String getInitREF_ID() {
		return initREF_ID;
	}
	public void setInitREF_ID(String initREF_ID) {
		this.initREF_ID = initREF_ID;
	}
	public String getFilterPol_NO() {
		return filterPol_NO;
	}
	public void setFilterPol_NO(String filterPol_NO) {
		this.filterPol_NO = filterPol_NO;
	}
	public String getFilterNew_IC_No() {
		return filterNew_IC_No;
	}
	public void setFilterNew_IC_No(String filterNew_IC_No) {
		this.filterNew_IC_No = filterNew_IC_No;
	}
	public String getFilterOld_IC_No() {
		return filterOld_IC_No;
	}
	public void setFilterOld_IC_No(String filterOld_IC_No) {
		this.filterOld_IC_No = filterOld_IC_No;
	}
	public String getFilterREF_ID() {
		return filterREF_ID;
	}
	public void setFilterREF_ID(String filterREF_ID) {
		this.filterREF_ID = filterREF_ID;
	}
	public String getSearchClaimRowId() {
		return searchClaimRowId;
	}
	public void setSearchClaimRowId(String searchClaimRowId) {
		this.searchClaimRowId = searchClaimRowId;
	}
	public String getSearchClaimlValues() throws Exception{
		String returnString=null;
		PILT042_APAC_DELEGATE delegate = new PILT042_APAC_DELEGATE();
		try {
			listValue = delegate.fetchClaimValues(this);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		if (listValue.size() == 0) {
			getWarningMap().put("current",Messages.getString("messageProperties-PM006_A_APAC","PM006_A_APAC$PM_CUSTOMER_SEARCH$NORECORD$MESSAGE"));
		} else {
			getWarningMap().clear();
		}
		return returnString;
	}
	public String clearList() throws Exception{
		String returnStr = "PILT042_APAC_MAIN_PAGE";
		String sessionValue="PILT042_APAC_PT_IL_PRE_CLAIMS_INFO_ACTION";
		PILT042_APAC_DELEGATE delegate = new PILT042_APAC_DELEGATE();
		PT_IL_PRE_CLAIMS_INFO claimBean = null;
		PT_IL_PRE_CLAIMS_INFO_ACTION claimAction = new PT_IL_PRE_CLAIMS_INFO_ACTION();;
		claimAction.setPT_IL_PRE_CLAIMS_INFO_BEAN(new PT_IL_PRE_CLAIMS_INFO());
		// Missing Pre-Query added for integration
		try {
			delegate.preQuery(claimAction.getPT_IL_PRE_CLAIMS_INFO_BEAN());
			claimAction.getPT_IL_PRE_CLAIMS_INFO_BEAN().setROWID(searchClaimRowId);
			claimBean = delegate.fetchAllCLaimsDetails(claimAction.getPT_IL_PRE_CLAIMS_INFO_BEAN());
			if (claimBean == null) {
				claimBean = new PT_IL_PRE_CLAIMS_INFO();
			}
			claimAction.setPT_IL_PRE_CLAIMS_INFO_BEAN(claimBean);
			CommonUtils.setGlobalObject(sessionValue, claimAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return returnStr;
	}
	public String newRecordAction(){
		PT_IL_PRE_CLAIMS_INFO_ACTION claimAction = new PT_IL_PRE_CLAIMS_INFO_ACTION();;
		claimAction.setPT_IL_PRE_CLAIMS_INFO_BEAN(new PT_IL_PRE_CLAIMS_INFO());
		
		return "PILT042_APAC_MAIN_PAGE";
	}
	
	public String updateButtonAction(String rowId){
		PT_IL_PRE_CLAIMS_INFO_ACTION claimAction = new PT_IL_PRE_CLAIMS_INFO_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILT042_APAC_PT_IL_PRE_CLAIMS_INFO_ACTION",claimAction);
		claimAction.getPT_IL_PRE_CLAIMS_INFO_BEAN().setROWID(rowId);
		outcome = "PILT042_APAC_MAIN_PAGE";
		return outcome;
		
	}
	public String insertButtonAction(){
		PT_IL_PRE_CLAIMS_INFO_ACTION claimAction = new PT_IL_PRE_CLAIMS_INFO_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILT042_APAC_PT_IL_PRE_CLAIMS_INFO_ACTION",claimAction);
		outcome = "PILT042_APAC_MAIN_PAGE";
		return outcome;
	}
}
