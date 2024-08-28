package com.iii.pel.forms.PILM048_APAC;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.richfaces.component.UIDataTable;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_BANK_CHARGE_SETUP_HDRSEARCHACTION extends CommonAction{

	private HtmlOutputLabel COMP_BCSH_BANK_CODE_LABEL;

	private HtmlInputText COMP_BCSH_BANK_CODE;

	private HtmlOutputLabel COMP_BCSH_CHG_CODE_LABEL;

	private HtmlInputText COMP_BCSH_CHG_CODE;

	private HtmlOutputLabel COMP_BCSH_MAIN_ACNT_CODE_LABEL;

	private HtmlInputText COMP_BCSH_MAIN_ACNT_CODE;

	private HtmlOutputLabel COMP_BCSH_SUB_ACNT_CODE_LABEL;

	private HtmlInputText COMP_BCSH_SUB_ACNT_CODE;

	private HtmlOutputLabel COMP_BCSH_DIVN_CODE_LABEL;

	private HtmlInputText COMP_BCSH_DIVN_CODE;

	private HtmlOutputLabel COMP_BCSH_DEPT_CODE_LABEL;

	private HtmlInputText COMP_BCSH_DEPT_CODE;
	UIDataTable table = null;
	
	private PM_BANK_CHARGE_SETUP_HDRSEARCHBEAN searchValue = null;

	ArrayList<PM_BANK_CHARGE_SETUP_HDRSEARCHBEAN> searchList = new ArrayList<PM_BANK_CHARGE_SETUP_HDRSEARCHBEAN>();

	public PM_BANK_CHARGE_SETUP_HDRSEARCHACTION(){
		searchValue = new PM_BANK_CHARGE_SETUP_HDRSEARCHBEAN();
	}
	
	public HtmlOutputLabel getCOMP_BCSH_BANK_CODE_LABEL() {
		return COMP_BCSH_BANK_CODE_LABEL;
	}

	public void setCOMP_BCSH_BANK_CODE_LABEL(
			HtmlOutputLabel comp_bcsh_bank_code_label) {
		COMP_BCSH_BANK_CODE_LABEL = comp_bcsh_bank_code_label;
	}

	public HtmlInputText getCOMP_BCSH_BANK_CODE() {
		return COMP_BCSH_BANK_CODE;
	}

	public void setCOMP_BCSH_BANK_CODE(HtmlInputText comp_bcsh_bank_code) {
		COMP_BCSH_BANK_CODE = comp_bcsh_bank_code;
	}

	public HtmlOutputLabel getCOMP_BCSH_CHG_CODE_LABEL() {
		return COMP_BCSH_CHG_CODE_LABEL;
	}

	public void setCOMP_BCSH_CHG_CODE_LABEL(HtmlOutputLabel comp_bcsh_chg_code_label) {
		COMP_BCSH_CHG_CODE_LABEL = comp_bcsh_chg_code_label;
	}

	public HtmlInputText getCOMP_BCSH_CHG_CODE() {
		return COMP_BCSH_CHG_CODE;
	}

	public void setCOMP_BCSH_CHG_CODE(HtmlInputText comp_bcsh_chg_code) {
		COMP_BCSH_CHG_CODE = comp_bcsh_chg_code;
	}

	public HtmlOutputLabel getCOMP_BCSH_MAIN_ACNT_CODE_LABEL() {
		return COMP_BCSH_MAIN_ACNT_CODE_LABEL;
	}

	public void setCOMP_BCSH_MAIN_ACNT_CODE_LABEL(
			HtmlOutputLabel comp_bcsh_main_acnt_code_label) {
		COMP_BCSH_MAIN_ACNT_CODE_LABEL = comp_bcsh_main_acnt_code_label;
	}

	public HtmlInputText getCOMP_BCSH_MAIN_ACNT_CODE() {
		return COMP_BCSH_MAIN_ACNT_CODE;
	}

	public void setCOMP_BCSH_MAIN_ACNT_CODE(HtmlInputText comp_bcsh_main_acnt_code) {
		COMP_BCSH_MAIN_ACNT_CODE = comp_bcsh_main_acnt_code;
	}

	public HtmlOutputLabel getCOMP_BCSH_SUB_ACNT_CODE_LABEL() {
		return COMP_BCSH_SUB_ACNT_CODE_LABEL;
	}

	public void setCOMP_BCSH_SUB_ACNT_CODE_LABEL(
			HtmlOutputLabel comp_bcsh_sub_acnt_code_label) {
		COMP_BCSH_SUB_ACNT_CODE_LABEL = comp_bcsh_sub_acnt_code_label;
	}

	public HtmlInputText getCOMP_BCSH_SUB_ACNT_CODE() {
		return COMP_BCSH_SUB_ACNT_CODE;
	}

	public void setCOMP_BCSH_SUB_ACNT_CODE(HtmlInputText comp_bcsh_sub_acnt_code) {
		COMP_BCSH_SUB_ACNT_CODE = comp_bcsh_sub_acnt_code;
	}

	public HtmlOutputLabel getCOMP_BCSH_DIVN_CODE_LABEL() {
		return COMP_BCSH_DIVN_CODE_LABEL;
	}

	public void setCOMP_BCSH_DIVN_CODE_LABEL(
			HtmlOutputLabel comp_bcsh_divn_code_label) {
		COMP_BCSH_DIVN_CODE_LABEL = comp_bcsh_divn_code_label;
	}

	public HtmlInputText getCOMP_BCSH_DIVN_CODE() {
		return COMP_BCSH_DIVN_CODE;
	}

	public void setCOMP_BCSH_DIVN_CODE(HtmlInputText comp_bcsh_divn_code) {
		COMP_BCSH_DIVN_CODE = comp_bcsh_divn_code;
	}

	public HtmlOutputLabel getCOMP_BCSH_DEPT_CODE_LABEL() {
		return COMP_BCSH_DEPT_CODE_LABEL;
	}

	public void setCOMP_BCSH_DEPT_CODE_LABEL(
			HtmlOutputLabel comp_bcsh_dept_code_label) {
		COMP_BCSH_DEPT_CODE_LABEL = comp_bcsh_dept_code_label;
	}

	public HtmlInputText getCOMP_BCSH_DEPT_CODE() {
		return COMP_BCSH_DEPT_CODE;
	}

	public void setCOMP_BCSH_DEPT_CODE(HtmlInputText comp_bcsh_dept_code) {
		COMP_BCSH_DEPT_CODE = comp_bcsh_dept_code;
	}

	public ArrayList<PM_BANK_CHARGE_SETUP_HDRSEARCHBEAN> getSearchList() {
		return searchList;
	}

	public void setSearchList(
			ArrayList<PM_BANK_CHARGE_SETUP_HDRSEARCHBEAN> searchList) {
		this.searchList = searchList;
	}
	public Connection getConnection() throws Exception{
		return CommonUtils.getConnection();
	}
	
	public String fetchData(ActionEvent ae) throws SQLException, Exception{
		PM_BANK_CHARGE_SETUP_DELEGATE delegate = new PM_BANK_CHARGE_SETUP_DELEGATE();
		searchList = delegate.fetchSearchValue(this);
		if(searchList.size() == 0){
			getWarningMap().put("current",Messages.getString("messageProperties-PILM048_APAC", "PILM048_APAC$SEARCH$NORECORD$MESSAGE"));
		}else{
			getWarningMap().clear();
		}
		return "";
	}

	public PM_BANK_CHARGE_SETUP_HDRSEARCHBEAN getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(PM_BANK_CHARGE_SETUP_HDRSEARCHBEAN searchValue) {
		this.searchValue = searchValue;
	}
	

	public UIDataTable getTable() {
		return table;
	}

	public void setTable(UIDataTable table) {
		this.table = table;
	}
	
	public String executeInsert(){
		System.out.println("PM_BANK_CHARGE_SETUP_HDRSEARCHACTION.executeInsert()");
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getExternalContext().getSessionMap().put("modestatus", "executeInsert");
		PM_BANK_CHARGE_SETUP_HDR_ACTION action = (PM_BANK_CHARGE_SETUP_HDR_ACTION) fc.getExternalContext().getSessionMap().get("PILM048_APAC_PM_BANK_CHARGE_SETUP_HDR_ACTION");
		SearchUtility.clearSession();
		return "insert";
	}
	
	/**
	 * 
	 * @param rowId
	 * @return
	 */
	public String updateButtonAction(String rowId){
		PM_BANK_CHARGE_SETUP_HDR_ACTION hdrAction = new PM_BANK_CHARGE_SETUP_HDR_ACTION();
		String outcome = null;
		FacesContext context =FacesContext.getCurrentInstance();
		Map requestParameterMap=context.getExternalContext().getRequestParameterMap();
		
		CommonUtils.setGlobalObject("PILM048_APAC_PM_BANK_CHARGE_SETUP_HDR_ACTION",hdrAction);
		hdrAction.getPM_BANK_CHARGE_SETUP_HDR_BEAN().setROWID(rowId);
		outcome = "header";
		return outcome;
	}
	
	public String insertButtonAction(){
		PM_BANK_CHARGE_SETUP_HDR_ACTION hdrAction = new PM_BANK_CHARGE_SETUP_HDR_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM048_APAC_PM_BANK_CHARGE_SETUP_HDR_ACTION",hdrAction);
		outcome = "header";
		return outcome;

	}
	
	public String backToSearch(){
		return  SearchConstants.BACK_TO_SEARCH_PAGE;
		
	}
}
