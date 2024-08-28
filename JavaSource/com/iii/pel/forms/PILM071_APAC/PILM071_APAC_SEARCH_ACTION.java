package com.iii.pel.forms.PILM071_APAC;

import java.util.ArrayList;

import javax.faces.component.html.HtmlDataTable;

import com.iii.pel.forms.PILM022.PM_IL_PREM_ACCOUNT_SETUP_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PILM071_APAC_SEARCH_ACTION extends CommonAction {
	private String initPrefix;
	private String initSuffix;
	
	private String filterPrefix;
	private String filterSuffix;
	
	private HtmlDataTable dataTable;

	private ArrayList<PM_LIFE_ENDT_NUMBER_SETUP> listValue;
	private int currPage;
	
	int rowCount =10;
	
	private String searchRowId;
	
	public PILM071_APAC_SEARCH_ACTION() {
		currPage = 1;
	}
	
	public HtmlDataTable getDataTable() {
		return dataTable;
	}
	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}
	public ArrayList<PM_LIFE_ENDT_NUMBER_SETUP> getListValue() {
		return listValue;
	}
	public void setListValue(ArrayList<PM_LIFE_ENDT_NUMBER_SETUP> listValue) {
		this.listValue = listValue;
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public String getInitPrefix() {
		return initPrefix;
	}
	public void setInitPrefix(String initPrefix) {
		this.initPrefix = initPrefix;
	}
	public String getInitSuffix() {
		return initSuffix;
	}
	public void setInitSuffix(String initSuffix) {
		this.initSuffix = initSuffix;
	}

	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public String getSearchRowId() {
		return searchRowId;
	}

	public void setSearchRowId(String searchRowId) {
		this.searchRowId = searchRowId;
	}

	public String getFilterPrefix() {
		return filterPrefix;
	}

	public void setFilterPrefix(String filterPrefix) {
		this.filterPrefix = filterPrefix;
	}

	public String getFilterSuffix() {
		return filterSuffix;
	}

	public void setFilterSuffix(String filterSuffix) {
		this.filterSuffix = filterSuffix;
	}
	
	public String fetchList(){
		String value = "gotoMainScreen";
		CommonUtils commonUtils = new CommonUtils();
		PM_LIFE_ENDT_NUMBER_SETUP valueBean = null;
		PM_LIFE_ENDT_NUMBER_SETUP_ACTION action = (PM_LIFE_ENDT_NUMBER_SETUP_ACTION) commonUtils.getMappedBeanFromSession("PILM071_APAC_PM_LIFE_ENDT_NUMBER_SETUP_ACTION");
		action.getWarningMap().clear();
		action.getErrorMap().clear();
		PILM071_APAC_DELEGATE delegate = new PILM071_APAC_DELEGATE();
		String rowId = action.getPM_LIFE_ENDT_NUMBER_SETUP_BEAN().getROWID();
		valueBean = delegate.fetchEndNoDetails(rowId);
		action.setPM_LIFE_ENDT_NUMBER_SETUP_BEAN(valueBean);
		return value;
	}
	
	public String newRecordAction(){
		CommonUtils commonUtils = new CommonUtils();
		commonUtils.clearMappedBeanFromSession("PILM071_APAC_PM_LIFE_ENDT_NUMBER_SETUP_ACTION");
		return "createRecord";
			
	}
	
	public String getSubmitedValue(){
		String value="";
		PILM071_APAC_DELEGATE delegate = new PILM071_APAC_DELEGATE();
		listValue = delegate.fetchListValue(this);
		if (listValue.size() == 0) {
			getWarningMap().put("current",Messages.getString("messageProperties_PILM071_APAC","PILM071_APAC$SEARCHACTION$NORECORD$MESSAGE"));
		} else {
			getWarningMap().clear();
		}
	return value;
	}
	
	public String updateButtonAction(String rowId) throws Exception{
		PM_LIFE_ENDT_NUMBER_SETUP_ACTION action = new PM_LIFE_ENDT_NUMBER_SETUP_ACTION();
		String outcome = null;
		action.getPM_LIFE_ENDT_NUMBER_SETUP_BEAN().setROWID(rowId);
		
		CommonUtils.setGlobalObject("PILM071_APAC_PM_LIFE_ENDT_NUMBER_SETUP_ACTION", action);
		outcome = "PM_LIFE_ENDT_NUMBER_SETUP";
		return outcome;
	}
	
	public String insertButtonAction() throws Exception{
		PM_LIFE_ENDT_NUMBER_SETUP_ACTION action = new PM_LIFE_ENDT_NUMBER_SETUP_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM071_APAC_PM_LIFE_ENDT_NUMBER_SETUP_ACTION", action);
		outcome = "PM_LIFE_ENDT_NUMBER_SETUP";
		return outcome;

		}
	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
	}
}
