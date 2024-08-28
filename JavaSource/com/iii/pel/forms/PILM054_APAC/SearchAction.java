package com.iii.pel.forms.PILM054_APAC;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class SearchAction extends CommonAction{
	
	private String mainAcctCode;
	private String subAcctCode;
	private String divisionCode; 
	private HtmlInputText COMP_RAS_MAIN_ACNT_CODE;
	private HtmlInputText COMP_RAS_SUB_ACNT_CODE;
	private HtmlInputText COMP_RAS_DIVN_CODE;
	private UIData dataTable;
	private ArrayList<PM_IL_RI_ACCOUNT_SETUP> acctCodeList = new ArrayList<PM_IL_RI_ACCOUNT_SETUP>();
	
	public String getMainAcctCode() {
		return mainAcctCode;
	}

	public void setMainAcctCode(String mainAcctCode) {
		this.mainAcctCode = mainAcctCode;
	}

	public String getSubAcctCode() {
		return subAcctCode;
	}

	public void setSubAcctCode(String subAcctCode) {
		this.subAcctCode = subAcctCode;
	}

	public String getDivisionCode() {
		return divisionCode;
	}

	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}

	public HtmlInputText getCOMP_RAS_MAIN_ACNT_CODE() {
		return COMP_RAS_MAIN_ACNT_CODE;
	}

	public void setCOMP_RAS_MAIN_ACNT_CODE(HtmlInputText comp_ras_main_acnt_code) {
		COMP_RAS_MAIN_ACNT_CODE = comp_ras_main_acnt_code;
	}

	public HtmlInputText getCOMP_RAS_SUB_ACNT_CODE() {
		return COMP_RAS_SUB_ACNT_CODE;
	}

	public void setCOMP_RAS_SUB_ACNT_CODE(HtmlInputText comp_ras_sub_acnt_code) {
		COMP_RAS_SUB_ACNT_CODE = comp_ras_sub_acnt_code;
	}

	public HtmlInputText getCOMP_RAS_DIVN_CODE() {
		return COMP_RAS_DIVN_CODE;
	}

	public void setCOMP_RAS_DIVN_CODE(HtmlInputText comp_ras_divn_code) {
		COMP_RAS_DIVN_CODE = comp_ras_divn_code;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	
	public ArrayList<PM_IL_RI_ACCOUNT_SETUP> getAcctCodeList() {
		return acctCodeList;
	}

	public void setAcctCodeList(ArrayList<PM_IL_RI_ACCOUNT_SETUP> acctCodeList) {
		this.acctCodeList = acctCodeList;
	}

	public String insertData(){
		return "success";
	}
	
	public String clearList() {
		String mnAcctCode = null;
		String subAcctCode = null;
		String divnCode = null;
		String rowid = null;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) context
				.getExternalContext().getRequest();
		try {
			//mnAcctCode = req.getParameter("mainAcctCode");
			//subAcctCode = req.getParameter("subAcctCode");
			//divnCode = req.getParameter("divisionCode");
			// Modified Fetching query : Added by Shankar Bodduluri : 31-Mar-2009
			rowid = req.getParameter("rowid");
			DelegateDb dbHelper = new DelegateDb();
			PILM054_APAC_COMPOSITE_ACTION pilm054_apac_composite_action = new PILM054_APAC_COMPOSITE_ACTION();
			PM_IL_RI_ACCOUNT_SETUP_ACTION pm_il_ri_account_setup_action = new PM_IL_RI_ACCOUNT_SETUP_ACTION();
			//PM_IL_RI_ACCOUNT_SETUP pm_il_ri_account_setup = dbHelper.dataBaseCallForAcctCode(rowid);
			//pm_il_ri_account_setup_action.setPM_IL_RI_ACCOUNT_SETUP_BEAN(pm_il_ri_account_setup);
			//pilm054_apac_composite_action.setActionBean(pm_il_ri_account_setup_action);
			CommonUtils.setGlobalObject("PILM054_APAC_COMPOSITE_ACTION", pilm054_apac_composite_action);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		return "success";
	}

	public String fetchAcctCodeDetails() {
		String typedmAcctCode = getMainAcctCode();
		String typedsAcctCode = getSubAcctCode();
		String typedDivnCode = getDivisionCode();
		DelegateDb dbHelper = new DelegateDb();
		acctCodeList = dbHelper.populateCodeDetails(typedmAcctCode,
				typedsAcctCode, typedDivnCode);
		if(acctCodeList.size() == 0){
			getWarningMap().put("current", Messages.getString("messageProperties_PILM054_APAC", "PILM054_APAC$PM_IL_RI_ACCOUNT_SETUPSEARCH$NORECORD$MESSAGE"));
		}else{
			getWarningMap().clear();
		}

		return null;
	}

	
	/**
	 * 
	 * @param rowId
	 * @return
	 */
	public String updateButtonAction(String rowId){
		PILM054_APAC_COMPOSITE_ACTION compositeAction = new PILM054_APAC_COMPOSITE_ACTION();
		String outcome = null;
		FacesContext context =FacesContext.getCurrentInstance();
		Map requestParameterMap=context.getExternalContext().getRequestParameterMap();
		
		CommonUtils.setGlobalObject("PILM054_APAC_COMPOSITE_ACTION",compositeAction);
		compositeAction.getActionBean().getPM_IL_RI_ACCOUNT_SETUP_BEAN().setROWID(rowId);
		outcome = "PILM054_SETUP";
		return outcome;
	}
	
	public String insertButtonAction(){
		PILM054_APAC_COMPOSITE_ACTION compositeAction = new PILM054_APAC_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM054_APAC_COMPOSITE_ACTION",compositeAction);
		outcome = "PILM054_SETUP";
		return outcome;

	}
	
	public String backToSearch(){
		return  SearchConstants.BACK_TO_SEARCH_PAGE;
		
	}
	
}
