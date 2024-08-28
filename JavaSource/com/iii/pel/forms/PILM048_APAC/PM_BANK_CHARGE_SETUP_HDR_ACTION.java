package com.iii.pel.forms.PILM048_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.richfaces.component.UIDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_BANK_CHARGE_SETUP_HDR_ACTION  extends CommonAction{
	
	private static final Log logger = LogFactory.getLog(PM_BANK_CHARGE_SETUP_HDR_ACTION.class);

	private HtmlOutputLabel COMP_BCSH_BANK_CODE_LABEL;

	private HtmlInputText COMP_BCSH_BANK_CODE;

	private HtmlOutputLabel COMP_BCSH_PAY_MODE_LABEL;

	private HtmlSelectOneMenu COMP_BCSH_PAY_MODE;

	private HtmlOutputLabel COMP_BCSH_PAY_FOR_LABEL;

	private HtmlSelectOneMenu COMP_BCSH_PAY_FOR;

	private HtmlOutputLabel COMP_BCSH_CHG_CODE_LABEL;

	private HtmlInputText COMP_BCSH_CHG_CODE;

	private HtmlOutputLabel COMP_BCSH_CHG_APPLIED_ON_LABEL;

	private HtmlSelectOneMenu COMP_BCSH_CHG_APPLIED_ON;

	private HtmlOutputLabel COMP_BCSH_CHG_AC_DOC_MODE_LABEL;

	private HtmlSelectOneMenu COMP_BCSH_CHG_AC_DOC_MODE;

	private HtmlOutputLabel COMP_BCSH_PROD_CODE_FM_LABEL;

	private HtmlInputText COMP_BCSH_PROD_CODE_FM;

	private HtmlOutputLabel COMP_BCSH_PROD_CODE_TO_LABEL;

	private HtmlInputText COMP_BCSH_PROD_CODE_TO;

	private HtmlOutputLabel COMP_BCSH_MAIN_ACNT_CODE_LABEL;

	private HtmlInputText COMP_BCSH_MAIN_ACNT_CODE;

	private HtmlOutputLabel COMP_BCSH_SUB_ACNT_CODE_LABEL;

	private HtmlInputText COMP_BCSH_SUB_ACNT_CODE;

	private HtmlOutputLabel COMP_BCSH_DIVN_CODE_LABEL;

	private HtmlInputText COMP_BCSH_DIVN_CODE;

	private HtmlOutputLabel COMP_BCSH_DEPT_CODE_LABEL;

	private HtmlInputText COMP_BCSH_DEPT_CODE;

	private HtmlOutputLabel COMP_BCSH_ANLY_CODE_1_LABEL;

	private HtmlInputText COMP_BCSH_ANLY_CODE_1;

	private HtmlOutputLabel COMP_BCSH_ANLY_CODE_2_LABEL;

	private HtmlInputText COMP_BCSH_ANLY_CODE_2;

	private HtmlOutputLabel COMP_BCSH_ACTY_CODE_1_LABEL;

	private HtmlInputText COMP_BCSH_ACTY_CODE_1;

	private HtmlOutputLabel COMP_BCSH_ACTY_CODE_2_LABEL;

	private HtmlInputText COMP_BCSH_ACTY_CODE_2;

	private HtmlOutputLabel COMP_BANK_CODE_DESC_LABEL;

	private HtmlInputText COMP_BANK_CODE_DESC;

	private HtmlOutputLabel COMP_BCSH_CHG_CODE_DESC_LABEL;

	private HtmlInputText COMP_BCSH_CHG_CODE_DESC;

	private HtmlOutputLabel COMP_MAIN_ACNT_DESC_LABEL;

	private HtmlInputText COMP_MAIN_ACNT_DESC;

	private HtmlOutputLabel COMP_SUB_ACNT_DESC_LABEL;

	private HtmlInputText COMP_SUB_ACNT_DESC;

	private HtmlOutputLabel COMP_DIVN_CODE_DESC_LABEL;

	private HtmlInputText COMP_DIVN_CODE_DESC;

	private HtmlOutputLabel COMP_DEPT_CODE_DESC_LABEL;

	private HtmlInputText COMP_DEPT_CODE_DESC;

	private HtmlOutputLabel COMP_ANLY_CODE_1_DESC_LABEL;

	private HtmlInputText COMP_ANLY_CODE_1_DESC;

	private HtmlOutputLabel COMP_ANLY_CODE_2_DESC_LABEL;

	private HtmlInputText COMP_ANLY_CODE_2_DESC;

	private HtmlOutputLabel COMP_ACTY_CODE_1_DESC_LABEL;

	private HtmlInputText COMP_ACTY_CODE_1_DESC;

	private HtmlOutputLabel COMP_ACTY_CODE_2_DESC_LABEL;

	private HtmlInputText COMP_ACTY_CODE_2_DESC;

	private HtmlOutputLabel COMP_BCSH_TRAN_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_BCSH_TRAN_TYPE;

	private HtmlOutputLabel COMP_BCSH_CUST_SHARE_PERC_LABEL;

	private HtmlInputText COMP_BCSH_CUST_SHARE_PERC;

	private HtmlOutputLabel COMP_BCSH_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_BCSH_FRZ_FLAG;

	private HtmlInputText COMP_BCSH_SYS_ID;
	private HtmlInputText COMP_BCSH_CR_DT;
	private HtmlInputText COMP_BCSH_CR_UID;
	private HtmlInputText COMP_BCSH_MODULE_ID;
	
	List<LovBean> suggestionList = null;
	
	private PM_BANK_CHARGE_SETUP_HDR PM_BANK_CHARGE_SETUP_HDR_BEAN;
	
	private DUMMY DUMMY_BEAN=null; 
	
	Connection connection = null;	
	Map<String, Object> session = null;
	CRUDHandler handler = null;
	UIDataTable table = null;
	
	List<SelectItem> payModeList = null;
	List<SelectItem> payForList = null;
	List<SelectItem> chrgAppOn = null;
	List<SelectItem> acDocGen = null;
	List<SelectItem> transType = null;
	
	List<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION> bankCodeLOV = new ArrayList<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION>();
	List<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION> mainAccCodeLOV = new ArrayList<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION>();
	List<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION> branchCodeLOV = new ArrayList<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION>();
	List<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION> subAccCodeLOV = new ArrayList<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION>();
	List<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION> chargeCodeLOV = new ArrayList<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION>();
	List<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION> activity1LOV = new ArrayList<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION>();
	List<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION> activity2LOV = new ArrayList<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION>();
	List<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION> analysis1LOV = new ArrayList<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION>();
	List<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION> analysis2LOV = new ArrayList<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION>();
	
	
	
	private TabbedBar tabbedBar;
	
	public PM_BANK_CHARGE_SETUP_DTL_ACTION DTL_ACTION;
	
	private List<PM_BANK_CHARGE_SETUP_DTL> dtlList = new ArrayList<PM_BANK_CHARGE_SETUP_DTL>();
	String code = null;

	public List<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION> getBankCodeLOV() {
		return bankCodeLOV;
	}

	public void setBankCodeLOV(List<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION> bankCodeLOV) {
		this.bankCodeLOV = bankCodeLOV;
	}

	public PM_BANK_CHARGE_SETUP_HDR_ACTION() {
		PM_BANK_CHARGE_SETUP_HDR_BEAN = new PM_BANK_CHARGE_SETUP_HDR();
		handler = new CRUDHandler();
		this.tabbedBar = new TabbedBar();
		instantiateAllComponent();
		DUMMY_BEAN = new DUMMY();
		try{
			/*changed by raja on 23-06-2017 for ZBILQC-1729814*/
			/*this.tabbedBar.addTab(1, "#{PILM048_APAC_PM_BANK_CHARGE_SETUP_DTL_ACTION.goHDRBlock}", "Bank Charge Setup", false);*/
			this.tabbedBar.addTab(1, "#{PILM048_APAC_PM_BANK_CHARGE_SETUP_DTL_ACTION.goHDRBlock}", "Bank/Employer Charge Setup", false);
			this.tabbedBar.addTab(2, "#{PILM048_APAC_PM_BANK_CHARGE_SETUP_HDR_ACTION.PM_BANK_CHARGE_SETUP_DTLInsert}", "Rate Setup", false);
			/*end*/
			//
			payForList = new ArrayList<SelectItem>();
			payForList.add(new SelectItem("Receipts","Receipts"));
			payForList.add(new SelectItem("Payment","Payment"));
			setPayForList(payForList);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HtmlOutputLabel getCOMP_BCSH_BANK_CODE_LABEL() {
		return COMP_BCSH_BANK_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BCSH_BANK_CODE() {
		return COMP_BCSH_BANK_CODE;
	}

	public void setCOMP_BCSH_BANK_CODE_LABEL(HtmlOutputLabel COMP_BCSH_BANK_CODE_LABEL) {
		this.COMP_BCSH_BANK_CODE_LABEL = COMP_BCSH_BANK_CODE_LABEL;
	}

	public void setCOMP_BCSH_BANK_CODE(HtmlInputText COMP_BCSH_BANK_CODE) {
		this.COMP_BCSH_BANK_CODE = COMP_BCSH_BANK_CODE;
	}

	public HtmlOutputLabel getCOMP_BCSH_PAY_MODE_LABEL() {
		return COMP_BCSH_PAY_MODE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_BCSH_PAY_MODE() {
		return COMP_BCSH_PAY_MODE;
	}

	public void setCOMP_BCSH_PAY_MODE_LABEL(HtmlOutputLabel COMP_BCSH_PAY_MODE_LABEL) {
		this.COMP_BCSH_PAY_MODE_LABEL = COMP_BCSH_PAY_MODE_LABEL;
	}

	public void setCOMP_BCSH_PAY_MODE(HtmlSelectOneMenu COMP_BCSH_PAY_MODE) {
		this.COMP_BCSH_PAY_MODE = COMP_BCSH_PAY_MODE;
	}

	public HtmlOutputLabel getCOMP_BCSH_PAY_FOR_LABEL() {
		return COMP_BCSH_PAY_FOR_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_BCSH_PAY_FOR() {
		return COMP_BCSH_PAY_FOR;
	}

	public void setCOMP_BCSH_PAY_FOR_LABEL(HtmlOutputLabel COMP_BCSH_PAY_FOR_LABEL) {
		this.COMP_BCSH_PAY_FOR_LABEL = COMP_BCSH_PAY_FOR_LABEL;
	}

	public void setCOMP_BCSH_PAY_FOR(HtmlSelectOneMenu COMP_BCSH_PAY_FOR) {
		this.COMP_BCSH_PAY_FOR = COMP_BCSH_PAY_FOR;
	}

	public HtmlOutputLabel getCOMP_BCSH_CHG_CODE_LABEL() {
		return COMP_BCSH_CHG_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BCSH_CHG_CODE() {
		return COMP_BCSH_CHG_CODE;
	}

	public void setCOMP_BCSH_CHG_CODE_LABEL(HtmlOutputLabel COMP_BCSH_CHG_CODE_LABEL) {
		this.COMP_BCSH_CHG_CODE_LABEL = COMP_BCSH_CHG_CODE_LABEL;
	}

	public void setCOMP_BCSH_CHG_CODE(HtmlInputText COMP_BCSH_CHG_CODE) {
		this.COMP_BCSH_CHG_CODE = COMP_BCSH_CHG_CODE;
	}

	public HtmlOutputLabel getCOMP_BCSH_CHG_APPLIED_ON_LABEL() {
		return COMP_BCSH_CHG_APPLIED_ON_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_BCSH_CHG_APPLIED_ON() {
		return COMP_BCSH_CHG_APPLIED_ON;
	}

	public void setCOMP_BCSH_CHG_APPLIED_ON_LABEL(HtmlOutputLabel COMP_BCSH_CHG_APPLIED_ON_LABEL) {
		this.COMP_BCSH_CHG_APPLIED_ON_LABEL = COMP_BCSH_CHG_APPLIED_ON_LABEL;
	}

	public void setCOMP_BCSH_CHG_APPLIED_ON(HtmlSelectOneMenu COMP_BCSH_CHG_APPLIED_ON) {
		this.COMP_BCSH_CHG_APPLIED_ON = COMP_BCSH_CHG_APPLIED_ON;
	}

	public HtmlOutputLabel getCOMP_BCSH_CHG_AC_DOC_MODE_LABEL() {
		return COMP_BCSH_CHG_AC_DOC_MODE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_BCSH_CHG_AC_DOC_MODE() {
		return COMP_BCSH_CHG_AC_DOC_MODE;
	}

	public void setCOMP_BCSH_CHG_AC_DOC_MODE_LABEL(HtmlOutputLabel COMP_BCSH_CHG_AC_DOC_MODE_LABEL) {
		this.COMP_BCSH_CHG_AC_DOC_MODE_LABEL = COMP_BCSH_CHG_AC_DOC_MODE_LABEL;
	}

	public void setCOMP_BCSH_CHG_AC_DOC_MODE(HtmlSelectOneMenu COMP_BCSH_CHG_AC_DOC_MODE) {
		this.COMP_BCSH_CHG_AC_DOC_MODE = COMP_BCSH_CHG_AC_DOC_MODE;
	}

	public HtmlOutputLabel getCOMP_BCSH_PROD_CODE_FM_LABEL() {
		return COMP_BCSH_PROD_CODE_FM_LABEL;
	}

	public HtmlInputText getCOMP_BCSH_PROD_CODE_FM() {
		return COMP_BCSH_PROD_CODE_FM;
	}

	public void setCOMP_BCSH_PROD_CODE_FM_LABEL(HtmlOutputLabel COMP_BCSH_PROD_CODE_FM_LABEL) {
		this.COMP_BCSH_PROD_CODE_FM_LABEL = COMP_BCSH_PROD_CODE_FM_LABEL;
	}

	public void setCOMP_BCSH_PROD_CODE_FM(HtmlInputText COMP_BCSH_PROD_CODE_FM) {
		this.COMP_BCSH_PROD_CODE_FM = COMP_BCSH_PROD_CODE_FM;
	}

	public HtmlOutputLabel getCOMP_BCSH_PROD_CODE_TO_LABEL() {
		return COMP_BCSH_PROD_CODE_TO_LABEL;
	}

	public HtmlInputText getCOMP_BCSH_PROD_CODE_TO() {
		return COMP_BCSH_PROD_CODE_TO;
	}

	public void setCOMP_BCSH_PROD_CODE_TO_LABEL(HtmlOutputLabel COMP_BCSH_PROD_CODE_TO_LABEL) {
		this.COMP_BCSH_PROD_CODE_TO_LABEL = COMP_BCSH_PROD_CODE_TO_LABEL;
	}

	public void setCOMP_BCSH_PROD_CODE_TO(HtmlInputText COMP_BCSH_PROD_CODE_TO) {
		this.COMP_BCSH_PROD_CODE_TO = COMP_BCSH_PROD_CODE_TO;
	}

	public HtmlOutputLabel getCOMP_BCSH_MAIN_ACNT_CODE_LABEL() {
		return COMP_BCSH_MAIN_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BCSH_MAIN_ACNT_CODE() {
		return COMP_BCSH_MAIN_ACNT_CODE;
	}

	public void setCOMP_BCSH_MAIN_ACNT_CODE_LABEL(HtmlOutputLabel COMP_BCSH_MAIN_ACNT_CODE_LABEL) {
		this.COMP_BCSH_MAIN_ACNT_CODE_LABEL = COMP_BCSH_MAIN_ACNT_CODE_LABEL;
	}

	public void setCOMP_BCSH_MAIN_ACNT_CODE(HtmlInputText COMP_BCSH_MAIN_ACNT_CODE) {
		this.COMP_BCSH_MAIN_ACNT_CODE = COMP_BCSH_MAIN_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_BCSH_SUB_ACNT_CODE_LABEL() {
		return COMP_BCSH_SUB_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BCSH_SUB_ACNT_CODE() {
		return COMP_BCSH_SUB_ACNT_CODE;
	}

	public void setCOMP_BCSH_SUB_ACNT_CODE_LABEL(HtmlOutputLabel COMP_BCSH_SUB_ACNT_CODE_LABEL) {
		this.COMP_BCSH_SUB_ACNT_CODE_LABEL = COMP_BCSH_SUB_ACNT_CODE_LABEL;
	}

	public void setCOMP_BCSH_SUB_ACNT_CODE(HtmlInputText COMP_BCSH_SUB_ACNT_CODE) {
		this.COMP_BCSH_SUB_ACNT_CODE = COMP_BCSH_SUB_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_BCSH_DIVN_CODE_LABEL() {
		return COMP_BCSH_DIVN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BCSH_DIVN_CODE() {
		return COMP_BCSH_DIVN_CODE;
	}

	public void setCOMP_BCSH_DIVN_CODE_LABEL(HtmlOutputLabel COMP_BCSH_DIVN_CODE_LABEL) {
		this.COMP_BCSH_DIVN_CODE_LABEL = COMP_BCSH_DIVN_CODE_LABEL;
	}

	public void setCOMP_BCSH_DIVN_CODE(HtmlInputText COMP_BCSH_DIVN_CODE) {
		this.COMP_BCSH_DIVN_CODE = COMP_BCSH_DIVN_CODE;
	}

	public HtmlOutputLabel getCOMP_BCSH_DEPT_CODE_LABEL() {
		return COMP_BCSH_DEPT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BCSH_DEPT_CODE() {
		return COMP_BCSH_DEPT_CODE;
	}

	public void setCOMP_BCSH_DEPT_CODE_LABEL(HtmlOutputLabel COMP_BCSH_DEPT_CODE_LABEL) {
		this.COMP_BCSH_DEPT_CODE_LABEL = COMP_BCSH_DEPT_CODE_LABEL;
	}

	public void setCOMP_BCSH_DEPT_CODE(HtmlInputText COMP_BCSH_DEPT_CODE) {
		this.COMP_BCSH_DEPT_CODE = COMP_BCSH_DEPT_CODE;
	}

	public HtmlOutputLabel getCOMP_BCSH_ANLY_CODE_1_LABEL() {
		return COMP_BCSH_ANLY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_BCSH_ANLY_CODE_1() {
		return COMP_BCSH_ANLY_CODE_1;
	}

	public void setCOMP_BCSH_ANLY_CODE_1_LABEL(HtmlOutputLabel COMP_BCSH_ANLY_CODE_1_LABEL) {
		this.COMP_BCSH_ANLY_CODE_1_LABEL = COMP_BCSH_ANLY_CODE_1_LABEL;
	}

	public void setCOMP_BCSH_ANLY_CODE_1(HtmlInputText COMP_BCSH_ANLY_CODE_1) {
		this.COMP_BCSH_ANLY_CODE_1 = COMP_BCSH_ANLY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_BCSH_ANLY_CODE_2_LABEL() {
		return COMP_BCSH_ANLY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_BCSH_ANLY_CODE_2() {
		return COMP_BCSH_ANLY_CODE_2;
	}

	public void setCOMP_BCSH_ANLY_CODE_2_LABEL(HtmlOutputLabel COMP_BCSH_ANLY_CODE_2_LABEL) {
		this.COMP_BCSH_ANLY_CODE_2_LABEL = COMP_BCSH_ANLY_CODE_2_LABEL;
	}

	public void setCOMP_BCSH_ANLY_CODE_2(HtmlInputText COMP_BCSH_ANLY_CODE_2) {
		this.COMP_BCSH_ANLY_CODE_2 = COMP_BCSH_ANLY_CODE_2;
	}

	public HtmlOutputLabel getCOMP_BCSH_ACTY_CODE_1_LABEL() {
		return COMP_BCSH_ACTY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_BCSH_ACTY_CODE_1() {
		return COMP_BCSH_ACTY_CODE_1;
	}

	public void setCOMP_BCSH_ACTY_CODE_1_LABEL(HtmlOutputLabel COMP_BCSH_ACTY_CODE_1_LABEL) {
		this.COMP_BCSH_ACTY_CODE_1_LABEL = COMP_BCSH_ACTY_CODE_1_LABEL;
	}

	public void setCOMP_BCSH_ACTY_CODE_1(HtmlInputText COMP_BCSH_ACTY_CODE_1) {
		this.COMP_BCSH_ACTY_CODE_1 = COMP_BCSH_ACTY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_BCSH_ACTY_CODE_2_LABEL() {
		return COMP_BCSH_ACTY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_BCSH_ACTY_CODE_2() {
		return COMP_BCSH_ACTY_CODE_2;
	}

	public void setCOMP_BCSH_ACTY_CODE_2_LABEL(HtmlOutputLabel COMP_BCSH_ACTY_CODE_2_LABEL) {
		this.COMP_BCSH_ACTY_CODE_2_LABEL = COMP_BCSH_ACTY_CODE_2_LABEL;
	}

	public void setCOMP_BCSH_ACTY_CODE_2(HtmlInputText COMP_BCSH_ACTY_CODE_2) {
		this.COMP_BCSH_ACTY_CODE_2 = COMP_BCSH_ACTY_CODE_2;
	}

	public HtmlOutputLabel getCOMP_BANK_CODE_DESC_LABEL() {
		return COMP_BANK_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_BANK_CODE_DESC() {
		return COMP_BANK_CODE_DESC;
	}

	public void setCOMP_BANK_CODE_DESC_LABEL(HtmlOutputLabel COMP_BANK_CODE_DESC_LABEL) {
		this.COMP_BANK_CODE_DESC_LABEL = COMP_BANK_CODE_DESC_LABEL;
	}

	public void setCOMP_BANK_CODE_DESC(HtmlInputText COMP_BANK_CODE_DESC) {
		this.COMP_BANK_CODE_DESC = COMP_BANK_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_BCSH_CHG_CODE_DESC_LABEL() {
		return COMP_BCSH_CHG_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_BCSH_CHG_CODE_DESC() {
		return COMP_BCSH_CHG_CODE_DESC;
	}

	public void setCOMP_BCSH_CHG_CODE_DESC_LABEL(HtmlOutputLabel COMP_BCSH_CHG_CODE_DESC_LABEL) {
		this.COMP_BCSH_CHG_CODE_DESC_LABEL = COMP_BCSH_CHG_CODE_DESC_LABEL;
	}

	public void setCOMP_BCSH_CHG_CODE_DESC(HtmlInputText COMP_BCSH_CHG_CODE_DESC) {
		this.COMP_BCSH_CHG_CODE_DESC = COMP_BCSH_CHG_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_MAIN_ACNT_DESC_LABEL() {
		return COMP_MAIN_ACNT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_MAIN_ACNT_DESC() {
		return COMP_MAIN_ACNT_DESC;
	}

	public void setCOMP_MAIN_ACNT_DESC_LABEL(HtmlOutputLabel COMP_MAIN_ACNT_DESC_LABEL) {
		this.COMP_MAIN_ACNT_DESC_LABEL = COMP_MAIN_ACNT_DESC_LABEL;
	}

	public void setCOMP_MAIN_ACNT_DESC(HtmlInputText COMP_MAIN_ACNT_DESC) {
		this.COMP_MAIN_ACNT_DESC = COMP_MAIN_ACNT_DESC;
	}

	public HtmlOutputLabel getCOMP_SUB_ACNT_DESC_LABEL() {
		return COMP_SUB_ACNT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_SUB_ACNT_DESC() {
		return COMP_SUB_ACNT_DESC;
	}

	public void setCOMP_SUB_ACNT_DESC_LABEL(HtmlOutputLabel COMP_SUB_ACNT_DESC_LABEL) {
		this.COMP_SUB_ACNT_DESC_LABEL = COMP_SUB_ACNT_DESC_LABEL;
	}

	public void setCOMP_SUB_ACNT_DESC(HtmlInputText COMP_SUB_ACNT_DESC) {
		this.COMP_SUB_ACNT_DESC = COMP_SUB_ACNT_DESC;
	}

	public HtmlOutputLabel getCOMP_DIVN_CODE_DESC_LABEL() {
		return COMP_DIVN_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_DIVN_CODE_DESC() {
		return COMP_DIVN_CODE_DESC;
	}

	public void setCOMP_DIVN_CODE_DESC_LABEL(HtmlOutputLabel COMP_DIVN_CODE_DESC_LABEL) {
		this.COMP_DIVN_CODE_DESC_LABEL = COMP_DIVN_CODE_DESC_LABEL;
	}

	public void setCOMP_DIVN_CODE_DESC(HtmlInputText COMP_DIVN_CODE_DESC) {
		this.COMP_DIVN_CODE_DESC = COMP_DIVN_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_DEPT_CODE_DESC_LABEL() {
		return COMP_DEPT_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_DEPT_CODE_DESC() {
		return COMP_DEPT_CODE_DESC;
	}

	public void setCOMP_DEPT_CODE_DESC_LABEL(HtmlOutputLabel COMP_DEPT_CODE_DESC_LABEL) {
		this.COMP_DEPT_CODE_DESC_LABEL = COMP_DEPT_CODE_DESC_LABEL;
	}

	public void setCOMP_DEPT_CODE_DESC(HtmlInputText COMP_DEPT_CODE_DESC) {
		this.COMP_DEPT_CODE_DESC = COMP_DEPT_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_ANLY_CODE_1_DESC_LABEL() {
		return COMP_ANLY_CODE_1_DESC_LABEL;
	}

	public HtmlInputText getCOMP_ANLY_CODE_1_DESC() {
		return COMP_ANLY_CODE_1_DESC;
	}

	public void setCOMP_ANLY_CODE_1_DESC_LABEL(HtmlOutputLabel COMP_ANLY_CODE_1_DESC_LABEL) {
		this.COMP_ANLY_CODE_1_DESC_LABEL = COMP_ANLY_CODE_1_DESC_LABEL;
	}

	public void setCOMP_ANLY_CODE_1_DESC(HtmlInputText COMP_ANLY_CODE_1_DESC) {
		this.COMP_ANLY_CODE_1_DESC = COMP_ANLY_CODE_1_DESC;
	}

	public HtmlOutputLabel getCOMP_ANLY_CODE_2_DESC_LABEL() {
		return COMP_ANLY_CODE_2_DESC_LABEL;
	}

	public HtmlInputText getCOMP_ANLY_CODE_2_DESC() {
		return COMP_ANLY_CODE_2_DESC;
	}

	public void setCOMP_ANLY_CODE_2_DESC_LABEL(HtmlOutputLabel COMP_ANLY_CODE_2_DESC_LABEL) {
		this.COMP_ANLY_CODE_2_DESC_LABEL = COMP_ANLY_CODE_2_DESC_LABEL;
	}

	public void setCOMP_ANLY_CODE_2_DESC(HtmlInputText COMP_ANLY_CODE_2_DESC) {
		this.COMP_ANLY_CODE_2_DESC = COMP_ANLY_CODE_2_DESC;
	}

	public HtmlOutputLabel getCOMP_ACTY_CODE_1_DESC_LABEL() {
		return COMP_ACTY_CODE_1_DESC_LABEL;
	}

	public HtmlInputText getCOMP_ACTY_CODE_1_DESC() {
		return COMP_ACTY_CODE_1_DESC;
	}

	public void setCOMP_ACTY_CODE_1_DESC_LABEL(HtmlOutputLabel COMP_ACTY_CODE_1_DESC_LABEL) {
		this.COMP_ACTY_CODE_1_DESC_LABEL = COMP_ACTY_CODE_1_DESC_LABEL;
	}

	public void setCOMP_ACTY_CODE_1_DESC(HtmlInputText COMP_ACTY_CODE_1_DESC) {
		this.COMP_ACTY_CODE_1_DESC = COMP_ACTY_CODE_1_DESC;
	}

	public HtmlOutputLabel getCOMP_ACTY_CODE_2_DESC_LABEL() {
		return COMP_ACTY_CODE_2_DESC_LABEL;
	}

	public HtmlInputText getCOMP_ACTY_CODE_2_DESC() {
		return COMP_ACTY_CODE_2_DESC;
	}

	public void setCOMP_ACTY_CODE_2_DESC_LABEL(HtmlOutputLabel COMP_ACTY_CODE_2_DESC_LABEL) {
		this.COMP_ACTY_CODE_2_DESC_LABEL = COMP_ACTY_CODE_2_DESC_LABEL;
	}

	public void setCOMP_ACTY_CODE_2_DESC(HtmlInputText COMP_ACTY_CODE_2_DESC) {
		this.COMP_ACTY_CODE_2_DESC = COMP_ACTY_CODE_2_DESC;
	}

	public HtmlOutputLabel getCOMP_BCSH_TRAN_TYPE_LABEL() {
		return COMP_BCSH_TRAN_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_BCSH_TRAN_TYPE() {
		return COMP_BCSH_TRAN_TYPE;
	}

	public void setCOMP_BCSH_TRAN_TYPE_LABEL(HtmlOutputLabel COMP_BCSH_TRAN_TYPE_LABEL) {
		this.COMP_BCSH_TRAN_TYPE_LABEL = COMP_BCSH_TRAN_TYPE_LABEL;
	}

	public void setCOMP_BCSH_TRAN_TYPE(HtmlSelectOneMenu COMP_BCSH_TRAN_TYPE) {
		this.COMP_BCSH_TRAN_TYPE = COMP_BCSH_TRAN_TYPE;
	}

	public HtmlOutputLabel getCOMP_BCSH_CUST_SHARE_PERC_LABEL() {
		return COMP_BCSH_CUST_SHARE_PERC_LABEL;
	}

	public HtmlInputText getCOMP_BCSH_CUST_SHARE_PERC() {
		return COMP_BCSH_CUST_SHARE_PERC;
	}

	public void setCOMP_BCSH_CUST_SHARE_PERC_LABEL(HtmlOutputLabel COMP_BCSH_CUST_SHARE_PERC_LABEL) {
		this.COMP_BCSH_CUST_SHARE_PERC_LABEL = COMP_BCSH_CUST_SHARE_PERC_LABEL;
	}

	public void setCOMP_BCSH_CUST_SHARE_PERC(HtmlInputText COMP_BCSH_CUST_SHARE_PERC) {
		this.COMP_BCSH_CUST_SHARE_PERC = COMP_BCSH_CUST_SHARE_PERC;
	}

	public HtmlOutputLabel getCOMP_BCSH_FRZ_FLAG_LABEL() {
		return COMP_BCSH_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_BCSH_FRZ_FLAG() {
		return COMP_BCSH_FRZ_FLAG;
	}

	public void setCOMP_BCSH_FRZ_FLAG_LABEL(HtmlOutputLabel COMP_BCSH_FRZ_FLAG_LABEL) {
		this.COMP_BCSH_FRZ_FLAG_LABEL = COMP_BCSH_FRZ_FLAG_LABEL;
	}

	public void setCOMP_BCSH_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_BCSH_FRZ_FLAG) {
		this.COMP_BCSH_FRZ_FLAG = COMP_BCSH_FRZ_FLAG;
	}

	public PM_BANK_CHARGE_SETUP_HDR getPM_BANK_CHARGE_SETUP_HDR_BEAN() {
		return PM_BANK_CHARGE_SETUP_HDR_BEAN;
	}

	public void setPM_BANK_CHARGE_SETUP_HDR_BEAN(PM_BANK_CHARGE_SETUP_HDR PM_BANK_CHARGE_SETUP_HDR_BEAN) {
		this.PM_BANK_CHARGE_SETUP_HDR_BEAN = PM_BANK_CHARGE_SETUP_HDR_BEAN;
	}
	public UIDataTable getTable() {
		return table;
	}

	public void setTable(UIDataTable table) {
		this.table = table;
	}
	public HtmlInputText getCOMP_BCSH_SYS_ID() {
		return COMP_BCSH_SYS_ID;
	}

	public void setCOMP_BCSH_SYS_ID(HtmlInputText comp_bcsh_sys_id) {
		COMP_BCSH_SYS_ID = comp_bcsh_sys_id;
	}
	public HtmlInputText getCOMP_BCSH_CR_DT() {
		return COMP_BCSH_CR_DT;
	}

	public void setCOMP_BCSH_CR_DT(HtmlInputText comp_bcsh_cr_dt) {
		COMP_BCSH_CR_DT = comp_bcsh_cr_dt;
	}

	public HtmlInputText getCOMP_BCSH_CR_UID() {
		return COMP_BCSH_CR_UID;
	}

	public void setCOMP_BCSH_CR_UID(HtmlInputText comp_bcsh_cr_uid) {
		COMP_BCSH_CR_UID = comp_bcsh_cr_uid;
	}

	public HtmlInputText getCOMP_BCSH_MODULE_ID() {
		return COMP_BCSH_MODULE_ID;
	}

	public void setCOMP_BCSH_MODULE_ID(HtmlInputText comp_bcsh_module_id) {
		COMP_BCSH_MODULE_ID = comp_bcsh_module_id;
	}
	public List<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION> getChargeCodeLOV() {
		return chargeCodeLOV;
	}

	public void setChargeCodeLOV(
			List<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION> chargeCodeLOV) {
		this.chargeCodeLOV = chargeCodeLOV;
	}

	public List<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION> getActivity1LOV() {
		return activity1LOV;
	}

	public void setActivity1LOV(
			List<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION> activity1LOV) {
		this.activity1LOV = activity1LOV;
	}

	public List<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION> getActivity2LOV() {
		return activity2LOV;
	}

	public void setActivity2LOV(
			List<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION> activity2LOV) {
		this.activity2LOV = activity2LOV;
	}

	public List<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION> getAnalysis1LOV() {
		return analysis1LOV;
	}

	public void setAnalysis1LOV(
			List<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION> analysis1LOV) {
		this.analysis1LOV = analysis1LOV;
	}

	public List<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION> getAnalysis2LOV() {
		return analysis2LOV;
	}

	public void setAnalysis2LOV(
			List<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION> analysis2LOV) {
		this.analysis2LOV = analysis2LOV;
	}
	public List<SelectItem> getChrgAppOn() {
		try {
			chrgAppOn = ListItemUtil.getDropDownListValue(getConnection(), "PILM048_APAC", "PM_BANK_CHARGE_SETUP_HDR", "PM_BANK_CHARGE_SETUP_HDR.BCSH_CHG_APPLIED_ON", "CHG_APP_ON");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chrgAppOn;
	}

	public void setChrgAppOn(List<SelectItem> chrgAppOn) {
		this.chrgAppOn = chrgAppOn;
	}

	public List<SelectItem> getAcDocGen() {
		try {
			acDocGen = ListItemUtil.getDropDownListValue(getConnection(), "PILM048_APAC", "PM_BANK_CHARGE_SETUP_HDR", "PM_BANK_CHARGE_SETUP_HDR.BCSH_CHG_AC_DOC_MODE", "CHG_APP_ON");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return acDocGen;
	}

	public void setAcDocGen(List<SelectItem> acDocGen) {
		this.acDocGen = acDocGen;
	}

	public List<SelectItem> getTransType() {
		try {
			transType = ListItemUtil.getDropDownListValue(getConnection(), "PILM048_APAC", "PM_BANK_CHARGE_SETUP_HDR", "PM_BANK_CHARGE_SETUP_HDR.BCSH_TRAN_TYPE", "SUCCFAIL");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transType;
	}

	public void setTransType(List<SelectItem> transType) {
		this.transType = transType;
	}

	public List<SelectItem> getPayForList() {
		/*try {
			payForList = ListItemUtil.getDropDownListValue(getConnection(), "PILM048_APAC", "PM_BANK_CHARGE_SETUP_HDR", "PM_BANK_CHARGE_SETUP_HDR.BCSH_PAY_FOR", "RECEIPTPAY");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		return payForList;
	}

	

	public void setPayModeList(List<SelectItem> payModeList) {
		this.payModeList = payModeList;
	}
	public Map<String, Object> getSession(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		return ctx.getExternalContext().getSessionMap();
	}

	public void preForm(ActionEvent ae){
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.preForm()");
		session = getSession();
		session.put("GLOBAL.M_FAILURE", "FALSE");
		STD_PRE_FORM();
		session.put("GLOBAL.M_ENG_LANG", "N");
		session.put("GLOBAL.M_PREV_ITEM", "NULL");
		session.put("GLOBAL.CUST_BRK_EQL_YN", "NULL");
		session.put("GLOBAL.M_PRE_QRY_RPH_SYS_ID", "NULL");
	}
	public void STD_PRE_FORM(){
		Map<String, Object> session = getSession();
		ControlBean ctrlBean = CommonUtils.getControlBean();

		System.out.println("PT_IL_RI_DETL_ACTION.STD_PRE_FORM()\n---------->\n"+session.toString()+"\n----------");
		ctrlBean.setM_PARA_1((String)session.get("GLOBAL.M_PARA_1"));
		System.out.println("PT_IL_RI_DETL_ACTION.STD_PRE_FORM(------)" +(String)session.get("GLOBAL.M_NAME"));
//		COPY('10','SYSTEM.MESSAGE_LEVEL');
		session.put("GLOBAL.M_FAILURE", "FALSE");
		ctrlBean.setM_GOFLD_NAME("NULL");
		System.out.println("PT_IL_RI_DETL_ACTION.STD_PRE_FORM()--- \n "+ctrlBean.getM_LANG_CODE()+"\t"+ctrlBean.getM_COMP_CODE()+"\t"+ctrlBean.getM_PARA_1());
	}
	public ArrayList<OracleParameter> prepareOracleParam(Map<String, Object> session){
		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		System.out.println("PT_IL_RI_DETL_ACTION.prepareOracleParam()\n------------! \n"+session.toString());
		OracleParameter param1 = new OracleParameter("in1","STRING","IN",(String)session.get("GLOBAL.M_LANG_CODE"));
		OracleParameter param2 = new OracleParameter("in2","STRING","IN",(String)session.get("GLOBAL.M_FOR_LANG_CODE"));
		OracleParameter param3 = new OracleParameter("in3","STRING","IN",CommonUtils.getControlBean().getM_USER_ID());
		OracleParameter param4 = new OracleParameter("in4","STRING","IN", CommonUtils.getControlBean().getM_COMP_CODE());
		OracleParameter param5 = new OracleParameter("in5","STRING","IN",(CommonUtils.getControlBean().getM_COMP_CODE()));
		System.out.println("PT_IL_RI_DETL_ACTION.prepareOracleParam(.....) "+(String)session.get("GLOBAL.M_DFLT_VALUES"));
		OracleParameter param6 = new OracleParameter("in6","STRING","IN",(CommonUtils.getControlBean().getM_COMP_CODE()));
		OracleParameter param7 = new OracleParameter("in7","STRING","IN",CommonUtils.getControlBean().getM_BASE_CURR());
		OracleParameter param8 = new OracleParameter("in8","STRING","IN","2");
		OracleParameter param9 = new OracleParameter("in9","STRING","IN","PILT010");
		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);
		paramList.add(param5);
		paramList.add(param6);
		paramList.add(param7);
		paramList.add(param8);
		paramList.add(param9);
		return paramList;
	}
	public void whenNewFormInstance(){
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.whenNewFormInstance()");
//		SET_WINDOW_PROPERTY('PM_BANK_CHARGE_SETUP_HDR', TITLE, 'BANK CHARGE SETUP');
	}
	public void whenNewBlkInstance(){
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.whenNewBlkInstance()");
//		CHECK_BLK_NAVG ;
	}
	
	//Modified by Jyoti on 20th Jun'12
	public void whenCreateRecord() throws Exception {
		String M_DUMMY = null;
		String C1 = "SELECT 'X' FROM PP_SYSTEM WHERE PS_TYPE = 'IL_AUTO_DEBT' "
				+ "AND PS_CODE = ?";
		ResultSet C1_REC = null;
		Connection connection = null;
		CRUDHandler handler = null;
		try {
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_PAY_MODE("C");
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_CHG_APPLIED_ON("1");
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_CHG_AC_DOC_MODE("1");
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_TRAN_TYPE("S");
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_CUST_SHARE_PERC(0);
			C1_REC = handler.executeSelectStatement(C1, connection,
					new Object[] { PM_BANK_CHARGE_SETUP_HDR_BEAN
							.getBCSH_PAY_MODE() });
			if (C1_REC.next()) {
				M_DUMMY = C1_REC.getString(1);
			}
			if ("X".equals(M_DUMMY)) {
				COMP_BCSH_TRAN_TYPE.setDisabled(false);
			} else {
				COMP_BCSH_TRAN_TYPE.setDisabled(true);
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	public Connection getConnection() throws Exception{
		return CommonUtils.getConnection();
	}
	public String redirect() throws Exception, Exception{
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.redirect()");
		PM_BANK_CHARGE_SETUP_HDRSEARCHBEAN bean = (PM_BANK_CHARGE_SETUP_HDRSEARCHBEAN) table.getRowData();
		code = bean.getBCSH_BANK_CODE();
//		executeQuery(null);
		return "header";
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validateBankCode(FacesContext context, UIComponent component,
			Object value) throws ValidatorException{
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.validate()");
		PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_BANK_CODE((String)value);
		try{
			PILM048_APAC_PROCEDURES pilm048_apac_procedures = new PILM048_APAC_PROCEDURES();
			/*Modifed by ganesh on 20-06-2017 */
			/*pilm048_apac_procedures.L_CHK_BANK((String)value, "E");*/
			pilm048_apac_procedures.L_CHK_BANK_EMPLOYER((String)value, "E");
		}catch(Exception exception){
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	/**
	 * 
	 * @param event
	 * @throws ValidatorException
	 */
	public void validateBankCode(ActionEvent event) throws ValidatorException{
		try{
			UIInput input = (UIInput)event.getComponent().getParent();
			String inputValue = (String)input.getSubmittedValue();
			if(inputValue!=null && !"".equalsIgnoreCase(inputValue)){
				fireFieldValidation(event);
			}else{
				/*COMP_BANK_CODE_DESC.setSubmittedValue(null);
				PM_BANK_CHARGE_SETUP_HDR_BEAN.setBANK_CODE_DESC("");
				COMP_BANK_CODE_DESC.resetValue();*/
			}
			
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}/*finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}*/
	}

	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void listChangePayMode(ActionEvent event) throws ValidatorException{
		PIML048_APAC_Helper helper = new PIML048_APAC_Helper();
		UIInput input = (UIInput)event.getComponent().getParent();
		
		String inputValue = (String)input.getSubmittedValue();
		PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_PAY_MODE(inputValue);
		try {
			helper.listChangePayMode(this);
			COMP_BCSH_TRAN_TYPE.resetValue();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("listChangePayMode", e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validateChargeCode(FacesContext context, UIComponent component,
			Object value) throws ValidatorException{
		System.out.println("Charge Code.validate()");
		try{
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_CHG_CODE((String)value);
			
			DBProcedures procedures = new DBProcedures();
			procedures.helperP_VAL_CODES("IL_CHARGE", PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_CHG_CODE(), null, "E", null);
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void validateChargeCode(ActionEvent event) throws ValidatorException{
		try{
			UIInput input = (UIInput)event.getComponent().getParent();
			String inputValue = (String)input.getSubmittedValue();
			if(inputValue!=null && !"".equalsIgnoreCase(inputValue)){
				fireFieldValidation(event);
			}else{
				/*COMP_BCSH_CHG_CODE_DESC.setSubmittedValue(null);
				PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_CHG_CODE_DESC("");
				COMP_BCSH_CHG_CODE_DESC.resetValue();*/
			}
			
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}/*finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}*/
	}
	
	public String executeQuery() throws Exception , ValidatorException{
		System.out.println("RowID"+PM_BANK_CHARGE_SETUP_HDR_BEAN.getROWID());
		preForm(null);
		PM_BANK_CHARGE_SETUP_DELEGATE delegate = new PM_BANK_CHARGE_SETUP_DELEGATE();
		if(PM_BANK_CHARGE_SETUP_HDR_BEAN!=null){
			delegate.loadBankChargesDts(PM_BANK_CHARGE_SETUP_HDR_BEAN);
		}
		/*FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String query = "SELECT ROWID,PM_BANK_CHARGE_SETUP_HDR.* FROM PM_BANK_CHARGE_SETUP_HDR WHERE ROWID LIKE '%"+req.getParameter("rowID")+"%'";
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.executeQuery() query > "+query );
		List<PM_BANK_CHARGE_SETUP_HDR> rs = handler.fetch(query, "com.iii.pel.forms.PILM048_APAC.PM_BANK_CHARGE_SETUP_HDR", getConnection());
		PM_BANK_CHARGE_SETUP_HDR value = rs.get(0);
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.executeQuery()"+value.getBCSH_CHG_CODE());
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.executeQuery()--: --"+value.getBCSH_SYS_ID());
		PM_BANK_CHARGE_SETUP_HDR_ACTION action = (PM_BANK_CHARGE_SETUP_HDR_ACTION) getSession().get("PILM048_APAC_PM_BANK_CHARGE_SETUP_HDR_ACTION");
		action.setPM_BANK_CHARGE_SETUP_HDR_BEAN(value);
		System.out.println("BCSH_SYS_ID : :- "+getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_SYS_ID());*/
		

			/*bankCodeDesc();
			mainAccCodeDesc();
			subAccCodeDesc();
			branchCodeDesc();
			chargeCodeDesc();
			analysis1Desc();
			analysis2Desc();
			activity1Desc();
			activity2Desc();*/
//			PM_BANK_CHARGE_SETUP_HDRPostQuery();
		//	ctx.getExternalContext().getSessionMap().put("modestatus", "executequery");
			return "header";
	}
	
	/**
	 * 
	 * @param event
	 */
	public void onLoad(PhaseEvent event) {
		try {
			
			if (isFormFlag()) {
				preForm(null);
				whenNewFormInstance();
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				executeQuery();
				if (PM_BANK_CHARGE_SETUP_HDR_BEAN.getROWID() != null) {
					postQuery();
				} else {
					whenCreateRecord();
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	private void postQuery(){
		try{
		bankCodeDesc();
		mainAccCodeDesc();
		subAccCodeDesc();
		branchCodeDesc();
		chargeCodeDesc();
		analysis1Desc();
		analysis2Desc();
		activity1Desc();
		activity2Desc();
		departmentDesc(PM_BANK_CHARGE_SETUP_HDR_BEAN);
		//PM_BANK_CHARGE_SETUP_HDRPostQuery();
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
	
	public List suggesion1(Object obj) throws Exception{
		String suggestQuery = null;
		/*Added by ganesh on 16-06-2017, to avoid duplicates */
		bankCodeLOV.clear();
		getCOMP_BCSH_BANK_CODE().setSubmittedValue(null);
		/*Modified by ganesh on 16-06-2017, ZBILQC-1719874 as suggested by girish */
		/*if(obj.toString().equals("*")){
			suggestQuery="SELECT BANK_CODE,BANK_NAME FROM FM_BANK WHERE NVL(BANK_FRZ_FLAG_NUM,0) = 2 ORDER BY 1 ASC";
		}else{
			suggestQuery="SELECT BANK_CODE,BANK_NAME FROM FM_BANK WHERE NVL(BANK_FRZ_FLAG_NUM,0) = 2 AND BANK_CODE LIKE '"+obj.toString()+"%' ORDER BY 1 ASC";
		}
		ResultSet rsSug1 = handler.executeSelectStatement(suggestQuery, getConnection());*/
		
		Object[] object = {};
		String empBankCode = (String) obj;
		if(obj.equals("*")){
			suggestQuery="SELECT CONT_CODE, CONT_NAME  FROM PM_IL_CONTRACTOR WHERE CONT_EMPLOYER_YN ='Y' AND ROWNUM < ? UNION SELECT BANK_CODE,BANK_NAME FROM FM_BANK WHERE NVL(BANK_FRZ_FLAG_NUM,0) = '2' AND ROWNUM < ?";
			object = new Object[] { PELConstants.suggetionRecordSize,PELConstants.suggetionRecordSize };
		}else{
			suggestQuery="SELECT CONT_CODE, CONT_NAME  FROM PM_IL_CONTRACTOR WHERE CONT_EMPLOYER_YN ='Y' AND (UPPER(CONT_CODE) LIKE ? OR UPPER(CONT_NAME) LIKE ?) AND ROWNUM < ? UNION SELECT BANK_CODE,BANK_NAME FROM FM_BANK WHERE (UPPER(BANK_CODE) LIKE ? OR UPPER(BANK_NAME) LIKE ?) AND NVL(BANK_FRZ_FLAG_NUM,0) = '2' AND ROWNUM < ?";
			object = new Object[] { empBankCode + "%", empBankCode + "%",
					PELConstants.suggetionRecordSize, empBankCode + "%", empBankCode + "%",
					PELConstants.suggetionRecordSize };
		}
		ResultSet rsSug1 = handler.executeSelectStatement(suggestQuery, getConnection(),object);
		
/*		end*/
		while(rsSug1.next()){
			PM_BANK_CHARGE_SETUP_HDR_SUGGESSION sug1bean = new PM_BANK_CHARGE_SETUP_HDR_SUGGESSION();
			sug1bean.setBankCode(rsSug1.getString(1));
			sug1bean.setBankName(rsSug1.getString(2));
			bankCodeLOV.add(sug1bean);
		}
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.suggesion1()\n "+bankCodeLOV.toString());
		CommonUtils.closeCursor(rsSug1);
		return bankCodeLOV;
	}
	public String bankCodeDesc(){
		
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.bankCodeDesc()");
		String desc = "SELECT CONT_NAME FROM PM_IL_CONTRACTOR WHERE CONT_EMPLOYER_YN = 'Y' AND CONT_CODE=? UNION SELECT BANK_NAME FROM FM_BANK WHERE NVL(BANK_FRZ_FLAG_NUM, 0) = '2' AND BANK_CODE=?";
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.bankCodeDesc()DescQry "+desc);
		ResultSet rs;
		try {
			rs = handler.executeSelectStatement(desc, getConnection(),new Object[]{PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_BANK_CODE(),
					PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_BANK_CODE()});
			if(rs.next()){
				PM_BANK_CHARGE_SETUP_HDR_BEAN.setBANK_CODE_DESC(rs.getString(1));
			}
			CommonUtils.closeCursor(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void validateBankCodeDesc(ActionEvent ae){
		UIInput input = (UIInput)ae.getComponent().getParent();		
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.bankCodeDesc()"+input.getSubmittedValue());
		String desc = "SELECT BANK_NAME FROM FM_BANK WHERE NVL(BANK_FRZ_FLAG_NUM,0) = 0 " +
		"AND BANK_CODE='" +input.getSubmittedValue()+ "'";
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.bankCodeDesc()DescQry "+desc);
		ResultSet rs = null;
		try {
			rs = handler.executeSelectStatement(desc, getConnection());
			if(rs.next()){
				getCOMP_BANK_CODE_DESC().setSubmittedValue(rs.getString(1));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//ErrorHelpUtil.validate(input,errorMap);

	}
	public List chargeCodeLOV(Object obj) throws Exception{
		String suggestQuery = null;
		/*Added by ganesh on 16-06-2017, to avoid duplicates */
		chargeCodeLOV.clear();
		getCOMP_BCSH_CHG_CODE().setSubmittedValue(null);
		if(obj.toString().equals("*")){
			suggestQuery="SELECT PC_CODE,PC_DESC,PC_CODE FROM PM_CODES WHERE PC_TYPE = 'IL_CHARGE' AND NVL(PC_FRZ_FLAG,'N') = 'N' ORDER BY 1 ASC";
		}else{
			suggestQuery="SELECT PC_CODE,PC_DESC,PC_CODE FROM PM_CODES WHERE PC_TYPE = 'IL_CHARGE' AND NVL(PC_FRZ_FLAG,'N') = 'N' AND PC_CODE LIKE '"+obj.toString()+"%' ORDER BY 1 ASC";
		}
		ResultSet rsSug1 = handler.executeSelectStatement(suggestQuery, getConnection());
		while(rsSug1.next()){
			PM_BANK_CHARGE_SETUP_HDR_SUGGESSION sug1bean = new PM_BANK_CHARGE_SETUP_HDR_SUGGESSION();
			sug1bean.setChargeCode(rsSug1.getString(1));
			sug1bean.setChargeName(rsSug1.getString(2));
			chargeCodeLOV.add(sug1bean);
		}
		CommonUtils.closeCursor(rsSug1);
		return chargeCodeLOV;
	}
	public String chargeCodeDesc() throws Exception{
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.bankCodeDesc()");
		String desc = "SELECT PC_DESC,PC_CODE FROM PM_CODES WHERE PC_TYPE = 'IL_CHARGE' " +
				"AND NVL(PC_FRZ_FLAG,'N') = 'N' AND PC_CODE = '"+PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_CHG_CODE()+"'";
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.bankCodeDesc()DescQry "+desc);
		ResultSet rs = handler.executeSelectStatement(desc, getConnection());
		if(rs.next()){
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_CHG_CODE_DESC(rs.getString(1));
		}
		CommonUtils.closeCursor(rs);
		return null;
	}
	public List mainAccLovCode(Object obj) throws Exception{
		String suggestQuery = null;
		if(mainAccCodeLOV!=null){
			mainAccCodeLOV.clear();
		}
		getCOMP_BCSH_MAIN_ACNT_CODE().setSubmittedValue(null);
		if(obj.toString().equals("*")){
			suggestQuery="SELECT MAIN_ACNT_CODE,MAIN_ACNT_NAME FROM FM_MAIN_ACCOUNT WHERE MAIN_FRZ_FLAG = 'N' AND ROWNUM < 26 ORDER BY 1 ASC";
		}else{
			suggestQuery="SELECT MAIN_ACNT_CODE,MAIN_ACNT_NAME FROM FM_MAIN_ACCOUNT WHERE MAIN_FRZ_FLAG = 'N' AND MAIN_ACNT_CODE LIKE '%"+obj.toString()+"%' AND ROWNUM < 20 ORDER BY 1 ASC";
		}
		ResultSet rsSug1 = handler.executeSelectStatement(suggestQuery, getConnection());
		while(rsSug1.next()){
			PM_BANK_CHARGE_SETUP_HDR_SUGGESSION sug1bean = new PM_BANK_CHARGE_SETUP_HDR_SUGGESSION();
			sug1bean.setMainAccCode(rsSug1.getString(1));
			sug1bean.setMainAccName(rsSug1.getString(2));
			mainAccCodeLOV.add(sug1bean);
		}
		CommonUtils.closeCursor(rsSug1);
		return mainAccCodeLOV;
	}
	public String mainAccCodeDesc() throws Exception{
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.bankCodeDesc()");
		String desc = "SELECT MAIN_ACNT_NAME FROM FM_MAIN_ACCOUNT WHERE MAIN_FRZ_FLAG = 'N' " +
				"AND MAIN_ACNT_CODE='"+PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_MAIN_ACNT_CODE()+"'";
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.bankCodeDesc()DescQry "+desc);
		ResultSet rs = handler.executeSelectStatement(desc, getConnection());
		if(rs.next()){
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setMAIN_ACNT_DESC(rs.getString(1));
		}
		CommonUtils.closeCursor(rs);
		return null;
	}
	public List subAccLovCode(Object obj) throws Exception{
		String suggestQuery = null;
		if(subAccCodeLOV!=null){
			subAccCodeLOV.clear();
		}
		if(obj.toString().equals("*")){
			suggestQuery=" SELECT SUB_ACNT_CODE,SUB_ACNT_NAME FROM FM_SUB_ACCOUNT WHERE SUB_ACNT_CODE IN " +
					"( SELECT MS_SUB_ACNT_CODE FROM FM_MAIN_SUB WHERE MS_MAIN_ACNT_CODE = '"+PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_MAIN_ACNT_CODE() +"') " +
					"AND FM_SUB_ACCOUNT.SUB_FRZ_FLAG = 'N' AND ROWNUM < 20 ORDER BY 1 ASC";
		}else{
			/*suggestQuery="select sub_acnt_code,sub_acnt_name from fm_sub_account where sub_frz_flag='N' " +
					"AND sub_acnt_code LIKE '"+obj.toString()+"%' ORDER BY 1 ASC";*/
			suggestQuery=" SELECT SUB_ACNT_CODE,SUB_ACNT_NAME FROM FM_SUB_ACCOUNT WHERE SUB_ACNT_CODE IN " +
			"( SELECT MS_SUB_ACNT_CODE FROM FM_MAIN_SUB WHERE MS_MAIN_ACNT_CODE = '"+PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_MAIN_ACNT_CODE() +"') " +
			"AND FM_SUB_ACCOUNT.SUB_FRZ_FLAG = 'N' AND FM_SUB_ACCOUNT.SUB_ACNT_CODE LIKE '%"+obj.toString()+"%'AND ROWNUM < 20 ORDER BY 1 ASC";
		}
		System.out.println(suggestQuery);
		ResultSet rsSug1 = handler.executeSelectStatement(suggestQuery, getConnection());
		while(rsSug1.next()){
			PM_BANK_CHARGE_SETUP_HDR_SUGGESSION sug1bean = new PM_BANK_CHARGE_SETUP_HDR_SUGGESSION();
			sug1bean.setSubAccCode(rsSug1.getString(1));
			sug1bean.setSubAccName(rsSug1.getString(2));
			subAccCodeLOV.add(sug1bean);
		}
		CommonUtils.closeCursor(rsSug1);
		return subAccCodeLOV;
	}
	public String subAccCodeDesc() throws Exception{
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.bankCodeDesc()");
		String desc = "select sub_acnt_name from fm_sub_account where sub_frz_flag='N' " +
					"AND sub_acnt_code='"+PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_SUB_ACNT_CODE()+"'";
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.bankCodeDesc()DescQry "+desc);
		ResultSet rs = handler.executeSelectStatement(desc, getConnection());
		if(rs.next()){
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setSUB_ACNT_DESC(rs.getString(1));
		}
		CommonUtils.closeCursor(rs);
		return null;
	}
	public List branchLovCode(Object obj) throws Exception{
		String suggestQuery = null;
		getCOMP_BCSH_DIVN_CODE().setSubmittedValue(null);
		if(branchCodeLOV!=null){
			branchCodeLOV.clear();
		}
		/*[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DIVISION to FM_DIVISION. Added by : Mallika.S, 31-Mar-2009 */
		if(obj.toString().equals("*")){
			suggestQuery="SELECT DIVN_CODE,DIVN_NAME FROM PM_DIVISION WHERE DIVN_FRZ_FLAG = 'N' AND DIVN_COMP_CODE = '001' AND ROWNUM < 20 ORDER BY 1 ASC";
		}else{
			suggestQuery="SELECT DIVN_CODE,DIVN_NAME FROM PM_DIVISION WHERE DIVN_FRZ_FLAG = 'N' AND DIVN_COMP_CODE = '001' AND DIVN_CODE LIKE '"+obj.toString()+"%' AND ROWNUM < 20 ORDER BY 1 ASC";
		}
		ResultSet rsSug1 = handler.executeSelectStatement(suggestQuery, getConnection());
		while(rsSug1.next()){
			PM_BANK_CHARGE_SETUP_HDR_SUGGESSION sug1bean = new PM_BANK_CHARGE_SETUP_HDR_SUGGESSION();
			sug1bean.setBranchCode(rsSug1.getString(1));
			sug1bean.setBranchName(rsSug1.getString(2));
			branchCodeLOV.add(sug1bean);
		}
		CommonUtils.closeCursor(rsSug1);
		return branchCodeLOV;
	}
	public String branchCodeDesc() throws Exception{
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.bankCodeDesc()");
		/*[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DIVISION to FM_DIVISION. Added by : Mallika.S, 31-Mar-2009 */
		String desc = "SELECT DIVN_NAME FROM FM_DIVISION WHERE DIVN_FRZ_FLAG = 'N' " +
				"AND DIVN_CODE='"+PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_DIVN_CODE()+"'";
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.bankCodeDesc()DescQry "+desc);
		ResultSet rs = handler.executeSelectStatement(desc, getConnection());
		if(rs.next()){
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setDIVN_CODE_DESC(rs.getString(1));
		}
		CommonUtils.closeCursor(rs);
		return null;
	}
	
	public List<LovBean> departmentSuggestion(Object event) {
		suggestionList = new ArrayList<LovBean>();
		/*ListItemUtil itemUtil = new ListItemUtil();
		suggestionList = new ArrayList<LovBean>();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILM048_APAC", "PM_BANK_CHARGE_SETUP_HDR",
					"BCSH_DEPT_CODE", null, null, null, null, null,
					(String) event);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}*/
		try {
		String suggestQuery = null;
		getCOMP_BCSH_DIVN_CODE().setSubmittedValue(null);
		if(event.toString().equals("*")){
			suggestQuery="SELECT DEPT_CODE,DEPT_NAME FROM PM_DEPARTMENT " +
					"WHERE DEPT_DIVN_CODE = '"+PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_DIVN_CODE() +"' AND " +
					"DEPT_FRZ_FLAG='N' AND ROWNUM<20 ORDER BY 1 ASC";
		}else{
			
			suggestQuery="SELECT DEPT_CODE,DEPT_NAME FROM PM_DEPARTMENT " +
			"WHERE DEPT_DIVN_CODE = '"+PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_DIVN_CODE() +"' " +
			"AND DEPT_FRZ_FLAG='N' AND PM_DEPARTMENT.DEPT_CODE LIKE '%"+event.toString()+"%'AND ROWNUM < 20 ORDER BY 1 ASC";
		}
		System.out.println(suggestQuery);
		ResultSet rsSug1 = handler.executeSelectStatement(suggestQuery, getConnection());
		while(rsSug1.next()){
			LovBean lovBean = new LovBean();
			lovBean.setCode(rsSug1.getString(1));
			lovBean.setName(rsSug1.getString(2));
			suggestionList.add(lovBean);
		}
		CommonUtils.closeCursor(rsSug1);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggestionList;
	}
	
	public void departmentDesc(PM_BANK_CHARGE_SETUP_HDR PM_BANK_CHARGE_SETUP_HDR_BEAN) {
		try {
		String suggestQuery = "SELECT DEPT_CODE,DEPT_NAME FROM PM_DEPARTMENT WHERE DEPT_CODE = ? AND DEPT_DIVN_CODE = ? AND DEPT_FRZ_FLAG='N'";
		ResultSet rsSug1 = handler
					.executeSelectStatement(suggestQuery, getConnection(),
							new Object[] {
									PM_BANK_CHARGE_SETUP_HDR_BEAN
											.getBCSH_DEPT_CODE(),
									PM_BANK_CHARGE_SETUP_HDR_BEAN
											.getBCSH_DIVN_CODE() });
		while(rsSug1.next()){
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setDEPT_CODE_DESC(rsSug1.getString(2));
		}
		CommonUtils.closeCursor(rsSug1);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
	}

	
	public List<LovBean>  analysis1LOV(Object event) throws Exception{
		ListItemUtil itemUtil = new ListItemUtil();
		suggestionList = new ArrayList<LovBean>();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILM048_APAC", "PM_BANK_CHARGE_SETUP_HDR",
					"BCSH_ANLY_CODE_1", "1", null, null, null, null,
					(String) event);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}

		return suggestionList;
	}
	public String analysis1Desc() throws Exception{
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.bankCodeDesc()");
		String desc = "SELECT ANLY_NAME,ANLY_CODE FROM FM_ANALYSIS WHERE ANLY_HEAD_NO = '1'" +
				" AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND ANLY_CODE ='"+PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_ANLY_CODE_1()+"'";
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.bankCodeDesc()DescQry "+desc);
		ResultSet rs = handler.executeSelectStatement(desc, getConnection());
		if(rs.next()){
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setANLY_CODE_1_DESC(rs.getString(1));
		}
		CommonUtils.closeCursor(rs);
		return null;
	}
	public List<LovBean>  analysis2LOV(Object event) throws Exception{
		ListItemUtil itemUtil = new ListItemUtil();
		suggestionList = new ArrayList<LovBean>();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILM048_APAC", "PM_BANK_CHARGE_SETUP_HDR",
					"BCSH_ANLY_CODE_1", "2", null, null, null, null,
					(String) event);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggestionList;
	}
	public String analysis2Desc() throws Exception{
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.bankCodeDesc()");
		String desc = "SELECT ANLY_NAME,ANLY_CODE FROM FM_ANALYSIS WHERE ANLY_HEAD_NO = '2' AND NVL(ANLY_FRZ_FLAG,'N') = 'N' " +
				"AND ANLY_CODE = '"+PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_ANLY_CODE_2()+"'";
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.bankCodeDesc()DescQry "+desc);
		ResultSet rs = handler.executeSelectStatement(desc, getConnection());
		if(rs.next()){
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setANLY_CODE_2_DESC(rs.getString(1));
		}
		CommonUtils.closeCursor(rs);
		return null;
	}
	public List<LovBean> activity1LOV(Object obj) throws Exception{
		ListItemUtil itemUtil = new ListItemUtil();
		suggestionList = new ArrayList<LovBean>();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILM048_APAC", "PM_BANK_CHARGE_SETUP_HDR",
					"BCSH_ACTY_CODE_1", "001", null, null, null, null,
					(String) obj);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggestionList;
	}
	public String activity1Desc() throws Exception{
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.bankCodeDesc()");
		String desc = "SELECT AVAL_VALUE_NAME,AVAL_CODE FROM FM_ACTY_VALUE WHERE AVAL_ACTY_CODE='001' " +
				"AND AVAL_CODE = '"+PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_ACTY_CODE_1()+"'";
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.bankCodeDesc()DescQry "+desc);
		ResultSet rs = handler.executeSelectStatement(desc, getConnection());
		if(rs.next()){
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setACTY_CODE_1_DESC(rs.getString(1));
		}
		CommonUtils.closeCursor(rs);
		return null;
	}
	public List<LovBean> activity2LOV(Object obj) throws Exception{
		ListItemUtil itemUtil = new ListItemUtil();
		suggestionList = new ArrayList<LovBean>();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILM048_APAC", "PM_BANK_CHARGE_SETUP_HDR",
					"BCSH_ACTY_CODE_2", "001", null, null, null, null,
					(String) obj);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}
		return suggestionList;
	}
	public String activity2Desc() throws Exception{
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.bankCodeDesc()");
		String desc = "SELECT AVAL_CODE,AVAL_VALUE_NAME,AVAL_CODE FROM FM_ACTY_VALUE WHERE AVAL_ACTY_CODE='001'" +
				" AND AVAL_CODE = '"+PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_ACTY_CODE_2()+"'";
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.bankCodeDesc()DescQry "+desc);
		ResultSet rs = handler.executeSelectStatement(desc, getConnection());
		if(rs.next()){
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_ACTY_CODE_2(rs.getString(1));
		}
		CommonUtils.closeCursor(rs);
		return null;
	}
	
	public List<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION> getMainAccCodeLOV() {
		return mainAccCodeLOV;
	}

	public void setMainAccCodeLOV(
			List<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION> mainAccCodeLOV) {
		this.mainAccCodeLOV = mainAccCodeLOV;
	}

	public List<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION> getBranchCodeLOV() {
		return branchCodeLOV;
	}

	public void setBranchCodeLOV(
			List<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION> branchCodeLOV) {
		this.branchCodeLOV = branchCodeLOV;
	}

	public List<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION> getSubAccCodeLOV() {
		return subAccCodeLOV;
	}

	public void setSubAccCodeLOV(
			List<PM_BANK_CHARGE_SETUP_HDR_SUGGESSION> subAccCodeLOV) {
		this.subAccCodeLOV = subAccCodeLOV;
	}
	
	public void prepareOracleParameter(){
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.prepareOracleParameter()");
		OracleProcedureHandler callProc = new OracleProcedureHandler();
		ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN","IL_CHARGE");
		OracleParameter param2 = new OracleParameter("in2","STRING","IN",getCOMP_BCSH_CHG_CODE().getSubmittedValue().toString());
		OracleParameter param3 = new OracleParameter("inout1","STRING","IN OUT",getCOMP_BCSH_CHG_CODE_DESC().getSubmittedValue().toString());
		OracleParameter param4 = new OracleParameter("in3","STRING","IN","-1");
		OracleParameter param5 = new OracleParameter("in4","STRING","IN","E");
		OracleParameter param6 = new OracleParameter("in5","STRING","IN","null");
		list.add(param1);
		list.add(param2);
		list.add(param3);
		list.add(param4);
		list.add(param5);
		list.add(param6);
		try {
			callProc.execute(list, getConnection(), "PCOPK_GENERAL.P_VAL_CODES");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void preInsert() throws Exception, Exception{
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.preInsert()");
		String  M_P_BCSH_SYS_ID=null;
        String M_DUMMY=null;
        String M_DUMMY_1=null;
        String preQuery1 = " SELECT P_BCSH_SYS_ID.NEXTVAL FROM DUAL";
        System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.preInsert() preQuery1 > "+preQuery1);
        ResultSet prq1rs = handler.executeSelectStatement(preQuery1, getConnection());
        if(prq1rs.next()){
        	M_P_BCSH_SYS_ID = prq1rs.getString(1);
        	System.out.println("M_P_BCSH_SYS_ID:" + M_P_BCSH_SYS_ID);
        }
        CommonUtils.closeCursor(prq1rs);
        PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_SYS_ID(CommonUtils.parseToDouble(M_P_BCSH_SYS_ID));
		String preQuery2 = "SELECT 'X' FROM PM_BANK_CHARGE_SETUP_HDR" +
				"	 WHERE  BCSH_BANK_CODE    = '" +PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_BANK_CODE()+"'"+
				"    AND BCSH_PAY_MODE        = '" +PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_PAY_MODE()+"'"+
				"	 AND BCSH_PAY_FOR         = '" +PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_PAY_FOR()+"'"+
				"    AND BCSH_TRAN_TYPE       = '" +PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_TRAN_TYPE()+"'"+
				"    AND BCSH_CHG_AC_DOC_MODE = '" +PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_CHG_AC_DOC_MODE()+"'"+"" +
				"    AND('"+PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_PROD_CODE_FM()+"' BETWEEN  BCSH_PROD_CODE_FM   AND BCSH_PROD_CODE_TO" +
				"    OR '"+PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_PROD_CODE_TO()+"' BETWEEN BCSH_PROD_CODE_FM AND BCSH_PROD_CODE_TO" +
				"    OR BCSH_PROD_CODE_FM BETWEEN '"+PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_PROD_CODE_FM()+"' AND '"+PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_PROD_CODE_TO()+"'" +
				"    OR BCSH_PROD_CODE_TO BETWEEN '"+PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_PROD_CODE_TO()+"' AND '"+PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_PROD_CODE_TO()+"')";
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.preInsert() preQuery [ "+preQuery2+" ]");
		ResultSet prq2rs = handler.executeSelectStatement(preQuery2, getConnection());
		if(prq2rs.next()){
			M_DUMMY = prq2rs.getString(1);
			throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "91368"));
		}
		CommonUtils.closeCursor(prq2rs);
		String preQuery3 = " SELECT 'X' FROM PM_BANK_CHARGE_SETUP_HDR" +
				"	 WHERE  BCSH_BANK_CODE    = '" +PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_BANK_CODE()+"'" +
				" 	 AND BCSH_PAY_MODE        = '" +PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_PAY_MODE()+"'" +
				"	 AND BCSH_PAY_FOR         = '" +PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_PAY_FOR()+"'" +
				"	 AND BCSH_TRAN_TYPE       = '" +PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_TRAN_TYPE()+"'" +
				"    AND BCSH_PROD_CODE_FM    = '" +PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_PROD_CODE_FM()+"'" +
				"	 AND BCSH_PROD_CODE_TO    = '" +PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_PROD_CODE_TO()+"'"; 
		ResultSet prq3rs = handler.executeSelectStatement(preQuery3, getConnection());
		if(prq3rs.next()){
			M_DUMMY_1 = prq3rs.getString(1);
			throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "3206",
					new Object[] { "Different Document Generation Type has been set for this Bank Code"
							}));
		}
		CommonUtils.closeCursor(prq3rs);
		Date sysdate = new Date();
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.preInsert() "+sysdate);
		PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_CR_DT(new CommonUtils().getCurrentDate());
		PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_MODULE_ID("IL");
	}
	
	public void PM_BANK_CHARGE_SETUP_HDR_WhenCreateRecord() throws Exception{
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.PM_BANK_CHARGE_SETUP_HDR_WhenCreateRecord()");
		preForm(null);
		whenNewFormInstance();
		whenNewBlkInstance();
		
		String M_DFLT_VAL1 = null;
		String M_DFLT_VAL2 = null; 
		String M_DFLT_VAL3 = null;
		String  M_DUMMY = null;
		String query = "	SELECT 'X' FROM PP_SYSTEM WHERE	PS_TYPE = 'IL_AUTO_DEBT' " +
				"AND PS_CODE = '" +getCOMP_BCSH_PAY_MODE().getSubmittedValue()+"'";
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_WhenCreateRecord() - "+query);
		ResultSet rs = handler.executeSelectStatement(query, getConnection());
		if(rs.next()){
			M_DUMMY = rs.getString(1);
		}
		CommonUtils.closeCursor(rs);
//		 IF C1%FOUND  THEN
//	   	  SET_ITEM_PROPERTY('PM_BANK_CHARGE_SETUP_HDR.BCSH_TRAN_TYPE',ENABLED, PROPERTY_TRUE);
//	   	 ELSE
//	   	 SET_ITEM_PROPERTY('PM_BANK_CHARGE_SETUP_HDR.BCSH_TRAN_TYPE',ENABLED, PROPERTY_FALSE);
//	   	 END IF;  
		getCOMP_BCSH_PAY_MODE().setSubmittedValue("C");
		getCOMP_BCSH_CHG_APPLIED_ON().setSubmittedValue("1");
		getCOMP_BCSH_CHG_AC_DOC_MODE().setSubmittedValue("1");
		getCOMP_BCSH_TRAN_TYPE().setSubmittedValue("S");
		getCOMP_BCSH_CUST_SHARE_PERC().setSubmittedValue("1");
		preInsert();
	}
	
	public String PM_BANK_CHARGE_SETUP_HDR_Insert() throws Exception{
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.PM_BANK_CHARGE_SETUP_HDR_Insert()");
		preInsert();
		int status = handler.executeInsert(PM_BANK_CHARGE_SETUP_HDR_BEAN, getConnection());
		getConnection().commit();
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.PM_BANK_CHARGE_SETUP_HDR_Insert() "+status);
		return "saveandnext";
	}
	
	/**
	 * Save the current instance record.
	 */
	public String saveRecord() {
		String message = null;

		try {
			if (PM_BANK_CHARGE_SETUP_HDR_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					PM_BANK_CHARGE_SETUP_HDR_PreUpdate();
					new CRUDHandler().executeInsert(PM_BANK_CHARGE_SETUP_HDR_BEAN,
							CommonUtils.getConnection());
					CommonUtils.getConnection().commit();

					message = Messages.getString("messageProperties",
							"errorPanel$message$update");
					getWarningMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getWarningMap().put("UPDATE", message);
				} else {
					message = Messages.getString("messageProperties",
							"errorPanel$message$updatenotallowed");
					getErrorMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getErrorMap().put("UPDATE", message);
				}
			} else {
				if (isINSERT_ALLOWED()) {
					preInsert();
					new CRUDHandler().executeInsert(PM_BANK_CHARGE_SETUP_HDR_BEAN,
							CommonUtils.getConnection());
					CommonUtils.getConnection().commit();

					message = Messages.getString("messageProperties",
							"errorPanel$message$save");
					getWarningMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getWarningMap().put("SAVE", message);
				} else {
					message = Messages.getString("messageProperties",
							"errorPanel$message$insertnotallowed");
					getErrorMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getErrorMap().put("SAVE", message);
				}
			}

	

		} catch (Exception e) {
			e.printStackTrace();
			try {
				CommonUtils.getConnection().commit();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (DBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}

		return null;
	}
	
	
	
	public void saveAndCommit(ActionEvent ae) throws SQLException, Exception{
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.saveAndCommit()");
		getConnection().commit();
	}
	public void PM_BANK_CHARGE_SETUP_HDR_PreUpdate() throws SQLException, Exception{
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_PreUpdate()");
		String preUpdQry1 = "SELECT 'X'	FROM PM_BANK_CHARGE_SETUP_HDR" +
				" WHERE  BCSH_BANK_CODE = '" +getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_BANK_CODE()+"'"+
				" AND BCSH_PAY_MODE     = '" +getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_PAY_MODE()+"'"+
				" AND BCSH_PAY_FOR      = '" +getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_PAY_FOR()+"'"+
				" AND BCSH_SYS_ID       <> '" +getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_SYS_ID()+"'" +
				" AND BCSH_TRAN_TYPE      = '" +getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_TRAN_TYPE()+"'" +
				" AND BCSH_CHG_AC_DOC_MODE = '" +getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_CHG_AC_DOC_MODE()+"'";
		System.out.println("query 1 > "+preUpdQry1);
		ResultSet uprs1 = handler.executeSelectStatement(preUpdQry1, getConnection());
		if(uprs1.next()){
//			STD_MESSAGE_ROUTINE(91368,:CTRL.M_LANG_CODE);
		}
		CommonUtils.closeCursor(uprs1);
		String preUpdQry2 = "SELECT 'X'	 FROM PM_BANK_CHARGE_SETUP_HDR" +
				" WHERE  BCSH_BANK_CODE    = '" +getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_BANK_CODE()+"'" +
				" AND BCSH_PAY_MODE        = '" +getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_PAY_MODE()+"'" +
				" AND BCSH_PAY_FOR         = '" +getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_PAY_FOR()+"'" +
				" AND BCSH_TRAN_TYPE       = '" +getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_TRAN_TYPE()+"'" +
				" AND BCSH_PROD_CODE_FM    = '"+getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_PROD_CODE_FM()+"'" +
				" AND BCSH_PROD_CODE_TO    = '"+getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_PROD_CODE_TO()+"'";
		System.out.println("query 2 > "+preUpdQry2);
		ResultSet uprs2 = handler.executeSelectStatement(preUpdQry2, getConnection());
//		IF :SYSTEM.RECORD_STATUS = 'INSERT' THEN
		if(uprs2.next()){
//			STD_MESSAGE_ROUTINE(3206,:CTRL.M_LANG_CODE,'Diffrent Document Generation Type has been set for this Bank Code');
		}
		CommonUtils.closeCursor(uprs2);
		String preUpdQry3 = "SELECT 'X' FROM PM_BANK_CHARGE_SETUP_HDR" +
				" WHERE  BCSH_BANK_CODE    = '" +getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_BANK_CODE()+"'" +
				" AND BCSH_PAY_MODE        = '" +getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_PAY_MODE()+"'" +
				" AND BCSH_PAY_FOR         = '" +getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_PAY_FOR()+"'" +
				" AND BCSH_TRAN_TYPE       = '" +getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_TRAN_TYPE()+"'" +
				" AND BCSH_PROD_CODE_FM    = '"+getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_PROD_CODE_FM()+"'" +
				" AND BCSH_PROD_CODE_TO    = '"+getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_PROD_CODE_TO()+"'" ;
		System.out.println("query 3 > "+preUpdQry3);
		ResultSet uprs3 = handler.executeSelectStatement(preUpdQry3, getConnection());
		if(uprs3.next()){
//			STD_MESSAGE_ROUTINE(3206,:CTRL.M_LANG_CODE,'Diffrent Document Generation Type has been set for this Bank Code');
		}
		CommonUtils.closeCursor(uprs3);
		Date sysdate = new Date();
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.preInsert() "+sysdate);
		getCOMP_BCSH_CR_DT().setSubmittedValue(sysdate.toString());
		getCOMP_BCSH_CR_UID().setSubmittedValue(getSession().get("GLOBAL.M_USER_ID").toString());
	}
	
	public void PM_BANK_CHARGE_SETUP_HDR_Delete(ActionEvent ae) throws Exception{
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.PM_BANK_CHARGE_SETUP_HDR_Delete()");
		String query = "DELETE FROM PM_BANK_CHARGE_SETUP_HDR WHERE BCSH_BANK_CODE=?";
		Object[] obj = new Object[1];
		obj[0]=getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_BANK_CODE();
		int status = handler.executeDeleteStatement(query, getConnection(), obj);
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_Delete() >  "+status);
	}
	
	public String PM_BANK_CHARGE_SETUP_DTLSelect() throws  Exception{
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.PM_BANK_CHARGE_SETUP_DTL()");
		
//		String query = "SELECT * FROM PM_BANK_CHARGE_SETUP_DTL " +
//				"WHERE BCSD_BCSH_SYS_ID = "+getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_SYS_ID();
//		System.out.println("query : > "+query);
//		ResultSet rs = handler.executeSelectStatement(query, getConnection());
		/*while(rs.next()){
			System.out.println("..");
			dtlList.add(new PM_BANK_CHARGE_SETUP_DTL(rs.getDouble("BCSD_AMT_LC_FM"),rs.getDouble("BCSD_AMT_LC_TO"),
					rs.getDouble("BCSD_RATE"),rs.getDouble("BCSD_RATE_PER"),rs.getDouble("BCSD_MIN_CHG_LC"),
					rs.getDouble("BCSD_MAX_CHG_LC"),rs.getString("BCSD_EFF_FM_DT"),rs.getString("BCSD_EFF_TO_DT")));
		}*/
		System.out.println("PM_BANK_CHARGE_SETUP_DTL(...................)");
		return "";
	}
	
	public String PM_BANK_CHARGE_SETUP_DTLInsert(){
		System.out.println("PM_BANK_CHARGE_SETUP_DTLInsert()");
		System.out.println("BCSH_SYS_ID :- "+getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_SYS_ID());
		int i = 0;
		PM_BANK_CHARGE_SETUP_DTL_ACTION dtlAction = (PM_BANK_CHARGE_SETUP_DTL_ACTION) new CommonUtils().getMappedBeanFromSession("PILM048_APAC_PM_BANK_CHARGE_SETUP_DTL_ACTION");
		PM_BANK_CHARGE_SETUP_DTL dtlBean = null;
		ArrayList<PM_BANK_CHARGE_SETUP_DTL> dtlList = new  ArrayList<PM_BANK_CHARGE_SETUP_DTL>();
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		PM_BANK_CHARGE_SETUP_DTL pm_bank_charge_setup_dtl = null;
		try{
			if(dtlAction == null){
				dtlAction = new PM_BANK_CHARGE_SETUP_DTL_ACTION();
				CommonUtils.setGlobalObject("PILM048_APAC_PM_BANK_CHARGE_SETUP_DTL_ACTION", dtlAction);
			}else{
				pm_bank_charge_setup_dtl = new PM_BANK_CHARGE_SETUP_DTL();
				dtlAction.setPM_BANK_CHARGE_SETUP_DTL_BEAN(pm_bank_charge_setup_dtl);
			}
			connection = CommonUtils.getConnection();
			String query = "select PM_BANK_CHARGE_SETUP_DTL.ROWID, PM_BANK_CHARGE_SETUP_DTL.* from PM_BANK_CHARGE_SETUP_DTL where BCSD_BCSH_SYS_ID = ?";
			Object[] values = {getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_SYS_ID()};
			resultSet = handler.executeSelectStatement(query, connection, values);
			while(resultSet.next()){
				dtlBean = new PM_BANK_CHARGE_SETUP_DTL();
				dtlBean.setBCSD_SYS_ID(resultSet.getDouble("BCSD_SYS_ID"));
				dtlBean.setBCSD_BCSH_SYS_ID(resultSet.getDouble("BCSD_BCSH_SYS_ID"));
				dtlBean.setBCSD_AMT_LC_FM(resultSet.getDouble("BCSD_AMT_LC_FM"));
				dtlBean.setBCSD_AMT_LC_TO(resultSet.getDouble("BCSD_AMT_LC_TO"));
				dtlBean.setBCSD_RATE_PER(resultSet.getDouble("BCSD_RATE_PER"));
				dtlBean.setBCSD_RATE(resultSet.getDouble("BCSD_RATE"));
				dtlBean.setBCSD_MAX_CHG_LC(resultSet.getDouble("BCSD_MAX_CHG_LC"));
				dtlBean.setBCSD_MIN_CHG_LC(resultSet.getDouble("BCSD_MIN_CHG_LC"));
				dtlBean.setBCSD_EFF_FM_DT(resultSet.getDate("BCSD_EFF_FM_DT"));
				dtlBean.setBCSD_EFF_TO_DT(resultSet.getDate("BCSD_EFF_TO_DT"));
				dtlBean.setROWID(resultSet.getString("ROWID"));
				dtlList.add(dtlBean);
			}
			dtlAction.setDataList(dtlList);
			if(dtlAction.getDataList()!=null){
				for(int j =0;j<dtlAction.getDataList().size();j++){
					PM_BANK_CHARGE_SETUP_DTL pm_bank_charge_setup_dtl2 = dtlAction.getDataList().get(j);
					if(j==0){
						pm_bank_charge_setup_dtl2.setRowSelected(true);
						dtlAction.setPM_BANK_CHARGE_SETUP_DTL_BEAN(pm_bank_charge_setup_dtl2);
					}else{
						pm_bank_charge_setup_dtl2.setRowSelected(false);					
					}
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		/*while(i<5){
			dtlList.add(new PM_BANK_CHARGE_SETUP_DTL(Double.valueOf("0"),Double.valueOf("0"),Double.valueOf("0"),Double.valueOf("0"),
					Double.valueOf("0"),Double.valueOf("0"),"",""));
			System.out.println(i);
			i++;
		}*/
		return "PILM048_DETAIL";
	}

	public List<PM_BANK_CHARGE_SETUP_DTL> getDtlList() {
		return dtlList;
	}

	public void setDtlList(List<PM_BANK_CHARGE_SETUP_DTL> dtlList) {
		this.dtlList = dtlList;
	}

	
	public String preButtonPressed(){
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.preButtonPressed()");
		SearchUtility.preBack();
		return "previous";
	}

	public TabbedBar getTabbedBar() {
		return tabbedBar;
	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}
	
	
		/**
		 * Resets all components in PM_BANK_CHARGE_SETUP_HDR_ACTION
		 */
		public void resetAllComponent(){
			// Reseting HtmlInputText
			COMP_BCSH_BANK_CODE.resetValue();
			COMP_BCSH_CHG_CODE.resetValue();
			COMP_BCSH_PROD_CODE_FM.resetValue();
			COMP_BCSH_PROD_CODE_TO.resetValue();
			COMP_BCSH_MAIN_ACNT_CODE.resetValue();
			COMP_BCSH_SUB_ACNT_CODE.resetValue();
			COMP_BCSH_DIVN_CODE.resetValue();
			COMP_BCSH_DEPT_CODE.resetValue();
			COMP_BCSH_ANLY_CODE_1.resetValue();
			COMP_BCSH_ANLY_CODE_2.resetValue();
			COMP_BCSH_ACTY_CODE_1.resetValue();
			COMP_BCSH_ACTY_CODE_2.resetValue();
			COMP_BANK_CODE_DESC.resetValue();
			COMP_BCSH_CHG_CODE_DESC.resetValue();
			COMP_MAIN_ACNT_DESC.resetValue();
			COMP_SUB_ACNT_DESC.resetValue();
			COMP_DIVN_CODE_DESC.resetValue();
			COMP_DEPT_CODE_DESC.resetValue();
			COMP_ANLY_CODE_1_DESC.resetValue();
			COMP_ANLY_CODE_2_DESC.resetValue();
			COMP_ACTY_CODE_1_DESC.resetValue();
			COMP_ACTY_CODE_2_DESC.resetValue();
			COMP_BCSH_CUST_SHARE_PERC.resetValue();
			COMP_BCSH_SYS_ID.resetValue();
			COMP_BCSH_CR_DT.resetValue();
			COMP_BCSH_CR_UID.resetValue();
			COMP_BCSH_MODULE_ID.resetValue();

			// Reseting HtmlSelectOneMenu
			COMP_BCSH_PAY_MODE.resetValue();
			COMP_BCSH_PAY_FOR.resetValue();
			COMP_BCSH_CHG_APPLIED_ON.resetValue();
			COMP_BCSH_CHG_AC_DOC_MODE.resetValue();
			COMP_BCSH_TRAN_TYPE.resetValue();

		}
	

	/**
	 * Instantiates all components in PM_BANK_CHARGE_SETUP_HDR_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_BCSH_BANK_CODE				 = new HtmlInputText();
		COMP_BCSH_CHG_CODE				 = new HtmlInputText();
		COMP_BCSH_PROD_CODE_FM				 = new HtmlInputText();
		COMP_BCSH_PROD_CODE_TO				 = new HtmlInputText();
		COMP_BCSH_MAIN_ACNT_CODE			 = new HtmlInputText();
		COMP_BCSH_SUB_ACNT_CODE				 = new HtmlInputText();
		COMP_BCSH_DIVN_CODE				 = new HtmlInputText();
		COMP_BCSH_DEPT_CODE				 = new HtmlInputText();
		COMP_BCSH_ANLY_CODE_1				 = new HtmlInputText();
		COMP_BCSH_ANLY_CODE_2				 = new HtmlInputText();
		COMP_BCSH_ACTY_CODE_1				 = new HtmlInputText();
		COMP_BCSH_ACTY_CODE_2				 = new HtmlInputText();
		COMP_BANK_CODE_DESC				 = new HtmlInputText();
		COMP_BCSH_CHG_CODE_DESC				 = new HtmlInputText();
		COMP_MAIN_ACNT_DESC				 = new HtmlInputText();
		COMP_SUB_ACNT_DESC				 = new HtmlInputText();
		COMP_DIVN_CODE_DESC				 = new HtmlInputText();
		COMP_DEPT_CODE_DESC				 = new HtmlInputText();
		COMP_ANLY_CODE_1_DESC				 = new HtmlInputText();
		COMP_ANLY_CODE_2_DESC				 = new HtmlInputText();
		COMP_ACTY_CODE_1_DESC				 = new HtmlInputText();
		COMP_ACTY_CODE_2_DESC				 = new HtmlInputText();
		COMP_BCSH_CUST_SHARE_PERC			 = new HtmlInputText();
		COMP_BCSH_SYS_ID				 = new HtmlInputText();
		COMP_BCSH_CR_DT					 = new HtmlInputText();
		COMP_BCSH_CR_UID				 = new HtmlInputText();
		COMP_BCSH_MODULE_ID				 = new HtmlInputText();

		// Instantiating HtmlSelectOneMenu
		COMP_BCSH_PAY_MODE				 = new HtmlSelectOneMenu();
		COMP_BCSH_PAY_FOR				 = new HtmlSelectOneMenu();
		COMP_BCSH_CHG_APPLIED_ON			 = new HtmlSelectOneMenu();
		COMP_BCSH_CHG_AC_DOC_MODE			 = new HtmlSelectOneMenu();
		COMP_BCSH_TRAN_TYPE				 = new HtmlSelectOneMenu();

	}

	/**
	 * 
	 * @param event
	 * @return
	 */
	public List<LovBean> productCodeFromSuggestion(Object event) {
		ListItemUtil itemUtil = new ListItemUtil();
		suggestionList = new ArrayList<LovBean>();
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILM048_APAC", "PM_BANK_CHARGE_SETUP_HDR",
					"BCSH_PROD_CODE_FM", null, null, null, null, null,
					(String) event);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}

		return suggestionList;
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validateProdCodeFm(FacesContext context, UIComponent component,
			Object value){
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.validate()");
		PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_PROD_CODE_FM((String)value);
		try{
			PIML048_APAC_Helper helper = new PIML048_APAC_Helper();
			helper.validateProdFm(PM_BANK_CHARGE_SETUP_HDR_BEAN);
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	
	public void validateProdCodeFm(ActionEvent event){
		UIInput input = (UIInput)event.getComponent().getParent();
		String inputValue = (String)input.getSubmittedValue();
		if(inputValue!=null && !"".equalsIgnoreCase(inputValue)){
			fireFieldValidation(event);
		}else{
			/*COMP_MAIN_ACNT_DESC.setSubmittedValue(null);
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setMAIN_ACNT_DESC("");
			COMP_MAIN_ACNT_DESC.resetValue();*/
		}
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validateMainAcctCode(FacesContext context, UIComponent component,
			Object value) throws Exception{
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.validate()");
		PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_MAIN_ACNT_CODE((String)value);
		try{
			PIML048_APAC_Helper helper = new PIML048_APAC_Helper();
			helper.validateMainAcctCode(this);
			COMP_BCSH_SUB_ACNT_CODE.resetValue();
			COMP_SUB_ACNT_DESC.resetValue();
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(CommonUtils.getConnection(),
					FacesContext.getCurrentInstance(), component
							.getClientId(FacesContext.getCurrentInstance()),
					getErrorMap(), getWarningMap());
		}
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validateMainAcctCode(ActionEvent event){
		UIInput input = (UIInput)event.getComponent().getParent();
		String inputValue = (String)input.getSubmittedValue();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validateSubAcctCode(FacesContext context, UIComponent component,
			Object value) throws Exception{
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.validate()");
		PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_SUB_ACNT_CODE((String)value);
		try{
			PIML048_APAC_Helper helper = new PIML048_APAC_Helper();
			helper.validateSubAcctCode(PM_BANK_CHARGE_SETUP_HDR_BEAN);
			
			/*if(PM_BANK_CHARGE_SETUP_HDR_BEAN.getSUB_ACNT_DESC()!=null){
				COMP_SUB_ACNT_DESC.setSubmittedValue(PM_BANK_CHARGE_SETUP_HDR_BEAN.getSUB_ACNT_DESC());
			}*/
			COMP_SUB_ACNT_DESC.resetValue();
			
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(CommonUtils.getConnection(),
					FacesContext.getCurrentInstance(), component
							.getClientId(FacesContext.getCurrentInstance()),
					getErrorMap(), getWarningMap());
		}
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validateSubAcctCode(ActionEvent event){
		UIInput input = (UIInput)event.getComponent().getParent();
		String inputValue = (String)input.getSubmittedValue();
		/*if(inputValue!=null && !"".equalsIgnoreCase(inputValue)){
			fireFieldValidation(event);
		}else{
			COMP_SUB_ACNT_DESC.setSubmittedValue(null);
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setSUB_ACNT_DESC("");
			COMP_SUB_ACNT_DESC.resetValue();
		}*/
		fireFieldValidation(event);
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validateDivnCode(FacesContext context, UIComponent component,
			Object value) throws Exception{
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.validate()");
		PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_DIVN_CODE((String)value);
		getErrorMap().clear();
		setErrorMessages(null);
		try{
			PIML048_APAC_Helper helper = new PIML048_APAC_Helper();
			helper.validateDivnCode(PM_BANK_CHARGE_SETUP_HDR_BEAN);
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(CommonUtils.getConnection(),
					FacesContext.getCurrentInstance(), component
							.getClientId(FacesContext.getCurrentInstance()),
					getErrorMap(), getWarningMap());
		}
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validateDivnCode(ActionEvent event){
		UIInput input = (UIInput)event.getComponent().getParent();
		String inputValue = (String)input.getSubmittedValue();
		/*if(inputValue!=null && !"".equalsIgnoreCase(inputValue)){
			fireFieldValidation(event);
		}else{
			COMP_DIVN_CODE_DESC.setSubmittedValue(null);
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setDIVN_CODE_DESC("");
			COMP_DIVN_CODE_DESC.resetValue();
		}*/
		fireFieldValidation(event);
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validateDeptCode(FacesContext context, UIComponent component,
			Object value) throws Exception{
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.validate()");
		PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_DEPT_CODE((String)value);
		getErrorMap().clear();
		setErrorMessages(null);
		try{
			PIML048_APAC_Helper helper = new PIML048_APAC_Helper();
			helper.validateDeptCode(PM_BANK_CHARGE_SETUP_HDR_BEAN);
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(CommonUtils.getConnection(),
					FacesContext.getCurrentInstance(), component
							.getClientId(FacesContext.getCurrentInstance()),
					getErrorMap(), getWarningMap());
		}
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validateDeptCode(ActionEvent event){
		UIInput input = (UIInput)event.getComponent().getParent();
		String inputValue = (String)input.getSubmittedValue();
		/*if(inputValue!=null && !"".equalsIgnoreCase(inputValue)){
			fireFieldValidation(event);
		}else{
			COMP_DEPT_CODE_DESC.setSubmittedValue(null);
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setDEPT_CODE_DESC("");
			COMP_DEPT_CODE_DESC.resetValue();
		}*/
		fireFieldValidation(event);
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validateAnly_1Code(FacesContext context, UIComponent component,
			Object value) throws Exception{
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.validate()");
		PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_ANLY_CODE_1((String)value);
		try{
			PIML048_APAC_Helper helper = new PIML048_APAC_Helper();
			helper.validateAnly_1Code(PM_BANK_CHARGE_SETUP_HDR_BEAN);
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(CommonUtils.getConnection(),
					FacesContext.getCurrentInstance(), component
							.getClientId(FacesContext.getCurrentInstance()),
					getErrorMap(), getWarningMap());
		}
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validateAnly_1Code(ActionEvent event){
		UIInput input = (UIInput)event.getComponent().getParent();
		String inputValue = (String)input.getSubmittedValue();
		/*if(inputValue!=null && !"".equalsIgnoreCase(inputValue)){
			fireFieldValidation(event);
		}else{
			COMP_ANLY_CODE_1_DESC.setSubmittedValue(null);
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setANLY_CODE_1_DESC("");
			COMP_ANLY_CODE_1_DESC.resetValue();
		}*/
		fireFieldValidation(event);
	}

	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validateAnly_2Code(FacesContext context, UIComponent component,
			Object value) throws Exception{
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.validate()");
		PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_ANLY_CODE_2((String)value);
		try{
			PIML048_APAC_Helper helper = new PIML048_APAC_Helper();
			helper.validateAnly_2Code(PM_BANK_CHARGE_SETUP_HDR_BEAN);
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(CommonUtils.getConnection(),
					FacesContext.getCurrentInstance(), component
							.getClientId(FacesContext.getCurrentInstance()),
					getErrorMap(), getWarningMap());
		}
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validateAnly_2Code(ActionEvent event){
		UIInput input = (UIInput)event.getComponent().getParent();
		String inputValue = (String)input.getSubmittedValue();
		/*if(inputValue!=null && !"".equalsIgnoreCase(inputValue)){
			fireFieldValidation(event);
		}else{
			COMP_ANLY_CODE_2_DESC.setSubmittedValue(null);
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setANLY_CODE_2_DESC("");
			COMP_ANLY_CODE_2_DESC.resetValue();
		}*/
		fireFieldValidation(event);
	}

	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validateACTY_1Code(FacesContext context, UIComponent component,
			Object value) throws Exception{
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.validate()");
		PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_ACTY_CODE_1((String)value);
		try{
			PIML048_APAC_Helper helper = new PIML048_APAC_Helper();
			helper.validateACTY_1Code(this);
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(CommonUtils.getConnection(),
					FacesContext.getCurrentInstance(), component
							.getClientId(FacesContext.getCurrentInstance()),
					getErrorMap(), getWarningMap());
		}
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validateACTY_1Code(ActionEvent event){
		UIInput input = (UIInput)event.getComponent().getParent();
		String inputValue = (String)input.getSubmittedValue();
		/*if(inputValue!=null && !"".equalsIgnoreCase(inputValue)){
			fireFieldValidation(event);
		}else{
			COMP_ACTY_CODE_1_DESC.setSubmittedValue(null);
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setACTY_CODE_1_DESC("");
			COMP_ACTY_CODE_1_DESC.resetValue();
		}*/
		fireFieldValidation(event);
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validateACTY_2Code(FacesContext context, UIComponent component,
			Object value) throws Exception{
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.validate()");
		PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_ACTY_CODE_2((String)value);
		try{
			PIML048_APAC_Helper helper = new PIML048_APAC_Helper();
			helper.validateACTY_2Code(this);
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(CommonUtils.getConnection(),
					FacesContext.getCurrentInstance(), component
							.getClientId(FacesContext.getCurrentInstance()),
					getErrorMap(), getWarningMap());
		}
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validateACTY_2Code(ActionEvent event){
		UIInput input = (UIInput)event.getComponent().getParent();
		String inputValue = (String)input.getSubmittedValue();
		/*if(inputValue!=null && !"".equalsIgnoreCase(inputValue)){
			fireFieldValidation(event);
		}else{
			COMP_ACTY_CODE_2_DESC.setSubmittedValue(null);
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setACTY_CODE_2_DESC("");
			COMP_ACTY_CODE_2_DESC.resetValue();
		}*/
		fireFieldValidation(event);
	}
	
	/**
	 * 
	 * @param event
	 * @return
	 */
	public List<LovBean> productCodeToSuggestion(Object event) {
		ListItemUtil itemUtil = new ListItemUtil();
		
		try {
			suggestionList = itemUtil.P_CALL_LOV("PILM048_APAC", "PM_BANK_CHARGE_SETUP_HDR",
					"BCSH_PROD_CODE_TO", null, null, null, null, null,
					(String) event);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Product Code Suggestion", e.getMessage());
		}

		return suggestionList;
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validateProdCodeTo(FacesContext context, UIComponent component,
			Object value){
		System.out.println("PM_BANK_CHARGE_SETUP_HDR_ACTION.validate()");
		try{
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_PROD_CODE_TO((String)value);
			
			PIML048_APAC_Helper helper = new PIML048_APAC_Helper();
			helper.validateProdTo(PM_BANK_CHARGE_SETUP_HDR_BEAN);
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validateProdCodeTo(ActionEvent value){
		UIInput input = (UIInput)value.getComponent().getParent();
		String inputValue = (String)input.getSubmittedValue();
		if(inputValue!=null && !"".equalsIgnoreCase(inputValue)){
			fireFieldValidation(value);
		}else{
			/*COMP_MAIN_ACNT_DESC.setSubmittedValue(null);
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setMAIN_ACNT_DESC("");
			COMP_MAIN_ACNT_DESC.resetValue();*/
		}
	}

	/**
	 * @return the dUMMY_BEAN
	 */
	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	/**
	 * @param dummy_bean the dUMMY_BEAN to set
	 */
	public void setDUMMY_BEAN(DUMMY dummy_bean) {
		DUMMY_BEAN = dummy_bean;
	}

	public String backToSearch(){
		return  SearchConstants.BACK_TO_SEARCH_PAGE;
		
	}

	public List<SelectItem> getPayModeList() {
		try {
			payModeList = ListItemUtil.getDropDownListValue(getConnection(), "PILM048_APAC", "PM_BANK_CHARGE_SETUP_HDR", "PM_BANK_CHARGE_SETUP_HDR.BCSH_PAY_MODE", "IL_PAY_MODE");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return payModeList;
	}

	/**
	 * @param payForList the payForList to set
	 */
	public void setPayForList(List<SelectItem> payForList) {
		this.payForList = payForList;
	}
	
	
	public String goHDRBlock(){
		return "header";
	}
	
	public void listenerBCSH_PROD_CODE_FM(ActionEvent event) {
		String currentValue = (String) COMP_BCSH_PROD_CODE_FM.getSubmittedValue();

		try {
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_PROD_CODE_FM((String) new CommonUtils()
					.SET_REP_FIRST_FIELD(currentValue, "String"));
			COMP_BCSH_PROD_CODE_FM.resetValue();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("BCSH_PROD_CODE_FM", e.getMessage());
		}
	}

	public void listenerBCSH_PROD_CODE_TO(ActionEvent event) {
		String currentValue = (String) COMP_BCSH_PROD_CODE_TO.getSubmittedValue();
		try {
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_PROD_CODE_TO((String) new CommonUtils()
					.SET_REP_SECOND_FIELD(PM_BANK_CHARGE_SETUP_HDR_BEAN.getBCSH_PROD_CODE_FM(),
							currentValue, "String"));
			COMP_BCSH_PROD_CODE_TO.resetValue();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("BCSH_PROD_CODE_TO", e.getMessage());
		}
	}
	
	public void CheckFreeze(ActionEvent event) {
		String checkValue = (String) ((UIInput)event.getComponent().getParent()).getSubmittedValue();
		if("true".equals(checkValue)) {
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_FRZ_FLAG("Y");
		} else {
			PM_BANK_CHARGE_SETUP_HDR_BEAN.setBCSH_FRZ_FLAG("N");
		}
	}

}
