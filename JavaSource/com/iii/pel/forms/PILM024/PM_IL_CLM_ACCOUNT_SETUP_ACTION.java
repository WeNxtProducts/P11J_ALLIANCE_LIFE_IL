package com.iii.pel.forms.PILM024;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;
import com.vembu.plsql.runtime.functions.MigratingFunctions;
import com.vembu.plsql.runtime.functions.StringFunctions;


public class PM_IL_CLM_ACCOUNT_SETUP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CLMAS_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_CLMAS_FRZ_FLAG;

	private HtmlOutputLabel COMP_CLMAS_SRC_BUS_TO_LABEL;

	private HtmlInputText COMP_CLMAS_SRC_BUS_TO;

	private HtmlOutputLabel COMP_CLMAS_SRC_BUS_FM_LABEL;

	private HtmlInputText COMP_CLMAS_SRC_BUS_FM;

	private HtmlOutputLabel COMP_CLMAS_BUS_TO_CODE_LABEL;

	private HtmlInputText COMP_CLMAS_BUS_TO_CODE;

	private HtmlOutputLabel COMP_CLMAS_BUS_FM_CODE_LABEL;

	private HtmlInputText COMP_CLMAS_BUS_FM_CODE;

	private HtmlOutputLabel COMP_CLMAS_DIVN_TO_CODE_LABEL;

	private HtmlInputText COMP_CLMAS_DIVN_TO_CODE;

	private HtmlOutputLabel COMP_CLMAS_DIVN_FM_CODE_LABEL;

	private HtmlInputText COMP_CLMAS_DIVN_FM_CODE;

	private HtmlOutputLabel COMP_CLMAS_DEPT_TO_CODE_LABEL;

	private HtmlInputText COMP_CLMAS_DEPT_TO_CODE;

	private HtmlOutputLabel COMP_CLMAS_DEPT_FM_CODE_LABEL;

	private HtmlInputText COMP_CLMAS_DEPT_FM_CODE;

	private HtmlOutputLabel COMP_CLMAS_DOC_TO_TYPE_LABEL;

	private HtmlInputText COMP_CLMAS_DOC_TO_TYPE;

	private HtmlOutputLabel COMP_CLMAS_DOC_FM_TYPE_LABEL;

	private HtmlInputText COMP_CLMAS_DOC_FM_TYPE;

	private HtmlOutputLabel COMP_CLMAS_CLM_TYPE_TO_CODE_LABEL;

	private HtmlInputText COMP_CLMAS_CLM_TYPE_TO_CODE;

	private HtmlOutputLabel COMP_CLMAS_CLM_TYPE_FM_CODE_LABEL;

	private HtmlInputText COMP_CLMAS_CLM_TYPE_FM_CODE;

	private HtmlOutputLabel COMP_CLMAS_PROD_CODE_TO_LABEL;

	private HtmlInputText COMP_CLMAS_PROD_CODE_TO;

	private HtmlOutputLabel COMP_CLMAS_PROD_CODE_FM_LABEL;

	private HtmlInputText COMP_CLMAS_PROD_CODE_FM;

	private HtmlOutputLabel COMP_CLMAS_COVER_CODE_TO_LABEL;

	private HtmlInputText COMP_CLMAS_COVER_CODE_TO;

	private HtmlOutputLabel COMP_CLMAS_COVER_CODE_FM_LABEL;

	private HtmlInputText COMP_CLMAS_COVER_CODE_FM;

	private HtmlOutputLabel COMP_CLMAS_CUST_CLS_TO_CODE_LABEL;

	private HtmlInputText COMP_CLMAS_CUST_CLS_TO_CODE;

	private HtmlOutputLabel COMP_CLMAS_CUST_CLS_FM_CODE_LABEL;

	private HtmlInputText COMP_CLMAS_CUST_CLS_FM_CODE;

	private HtmlOutputLabel COMP_CLMAS_ASSURED_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_CLMAS_ASSURED_TYPE;

	private HtmlOutputLabel COMP_CLMAS_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_CLMAS_TYPE;

	private HtmlOutputLabel COMP_CLMAS_FORCE_DIVN_YN_LABEL;

	private HtmlSelectOneMenu COMP_CLMAS_FORCE_DIVN_YN;

	private HtmlOutputLabel COMP_CLMAS_FORCE_DEPT_YN_LABEL;

	private HtmlSelectOneMenu COMP_CLMAS_FORCE_DEPT_YN;

	private HtmlOutputLabel COMP_CLMAS_MAIN_ACNT_CODE_LABEL;

	private HtmlInputText COMP_CLMAS_MAIN_ACNT_CODE;

	private HtmlOutputLabel COMP_UI_M_MAIN_ACNT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_MAIN_ACNT_NAME;

	private HtmlOutputLabel COMP_CLMAS_SUB_ACNT_CODE_LABEL;

	private HtmlInputText COMP_CLMAS_SUB_ACNT_CODE;

	private HtmlOutputLabel COMP_UI_M_SUB_ACNT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_SUB_ACNT_NAME;

	private HtmlOutputLabel COMP_CLMAS_DIVN_CODE_LABEL;

	private HtmlInputText COMP_CLMAS_DIVN_CODE;

	private HtmlOutputLabel COMP_UI_M_DIVN_NAME_LABEL;

	private HtmlInputText COMP_UI_M_DIVN_NAME;

	private HtmlOutputLabel COMP_CLMAS_DEPT_CODE_LABEL;

	private HtmlInputText COMP_CLMAS_DEPT_CODE;

	private HtmlOutputLabel COMP_UI_M_DEPT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_DEPT_NAME;

	private HtmlOutputLabel COMP_CLMAS_ANLY_CODE_1_LABEL;

	private HtmlInputText COMP_CLMAS_ANLY_CODE_1;

	private HtmlOutputLabel COMP_UI_M_ANLY_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ANLY_NAME;

	private HtmlOutputLabel COMP_CLMAS_ANLY_CODE_2_LABEL;

	private HtmlInputText COMP_CLMAS_ANLY_CODE_2;

	private HtmlOutputLabel COMP_UI_M_ANLY_NAME_1_LABEL;

	private HtmlInputText COMP_UI_M_ANLY_NAME_1;

	private HtmlOutputLabel COMP_CLMAS_ACTY_CODE_1_LABEL;

	private HtmlInputText COMP_CLMAS_ACTY_CODE_1;

	private HtmlOutputLabel COMP_UI_M_ACTY_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ACTY_NAME;

	private HtmlOutputLabel COMP_CLMAS_ACTY_CODE_2_LABEL;

	private HtmlInputText COMP_CLMAS_ACTY_CODE_2;

	private HtmlOutputLabel COMP_UI_M_ACTY_NAME_1_LABEL;

	private HtmlInputText COMP_UI_M_ACTY_NAME_1;

	private HtmlCommandButton COMP_UI_M_BUT_SUB_ACNT;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN_ACNT;

	private HtmlCommandButton COMP_UI_M_BUT_DOC_TYPE_FM_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_CLMAS_PROD_CODE_FM;

	private HtmlCommandButton COMP_UI_M_BUT_DOC_TYPE_TO_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_CLMAS_PROD_CODE_TO;

	private HtmlCommandButton COMP_UI_M_BUT_DEPT_TO;

	private HtmlCommandButton COMP_UI_M_BUT_DEPT_FM;

	private HtmlCommandButton COMP_UI_M_BUT_DIVN_TO;

	private HtmlCommandButton COMP_UI_M_BUT_DIVN_FM;

	private HtmlCommandButton COMP_UI_M_BUT_CUST_CODE_FM_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_CUST_CODE_TO_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_DIVN;

	private HtmlCommandButton COMP_UI_M_BUT_CLMAS_SRC_BUS_FM;

	private HtmlCommandButton COMP_UI_M_BUT_CLMAS_SRC_BUS_TO;

	private HtmlCommandButton COMP_UI_M_BUT_CLMAS_BUS_TO_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_CLMAS_BUS_FM_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_CLMAS_CLM_TYPE_TO_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_CLMAS_COVER_CODE_TO;

	private HtmlCommandButton COMP_UI_M_BUT_CLMAS_CLM_TYPE_FM_LOV;

	private HtmlCommandButton COMP_B_BUT_CLMAS_COVER_CODE_FM;

	private HtmlCommandButton COMP_UI_M_BUT_ACTY_2;

	private HtmlCommandButton COMP_UI_M_BUT_ACTY_1;

	private HtmlCommandButton COMP_UI_M_BUT_ANAL_1;

	private HtmlCommandButton COMP_UI_M_BUT_ANAL_2;

	private HtmlCommandButton COMP_UI_M_BUT_DEPT;

	//Changes made
	
	PILM024_COMPOSITE_ACTION compositeAction;
	
	private HtmlCommandButton test;

	private String errMsg;
	
	ResultSet rs= null;
	
	String warningmessage;
	
	ControlBean ctrlBean  = null;
	
	int rowIndex = 0;
	
	List<SelectItem> UI_M_CLAIM_SETUP_LIST = new ArrayList<SelectItem>();
	
	List<SelectItem> CLMAS_FORCE_DIVN_YN_LIST = new ArrayList<SelectItem>();
	
	List<SelectItem> CLMAS_FORCE_DEPT_YN_LIST = new ArrayList<SelectItem>();
	
	List<SelectItem> CLMAS_ASSURED_TYPE_LIST = new ArrayList<SelectItem>();
	
	CRUDHandler handler = new CRUDHandler();
	
	HttpSession session = null; 
	
	ArrayList<PM_IL_CLM_ACCOUNT_SETUP> detailsList;

	private Connection connection = null;
	
	DUMMY DUMMY_BEAN;
	
	BP BP_BEAN;

	private PM_IL_CLM_ACCOUNT_SETUP PM_IL_CLM_ACCOUNT_SETUP_BEAN;
	
	OracleProcedureHandler ora_Handler = new OracleProcedureHandler();



	public PM_IL_CLM_ACCOUNT_SETUP_ACTION() {
		DUMMY_BEAN = new DUMMY();
		BP_BEAN = new BP();
		PM_IL_CLM_ACCOUNT_SETUP_BEAN = new PM_IL_CLM_ACCOUNT_SETUP();
		COMP_CLMAS_SUB_ACNT_CODE = new HtmlInputText();
		COMP_CLMAS_ACTY_CODE_1 = new HtmlInputText();
		COMP_CLMAS_ACTY_CODE_2 = new HtmlInputText();
		COMP_CLMAS_MAIN_ACNT_CODE = new HtmlInputText();
		COMP_CLMAS_FORCE_DEPT_YN = new HtmlSelectOneMenu ();
		COMP_CLMAS_DIVN_CODE= new HtmlInputText();
		COMP_CLMAS_DEPT_CODE= new HtmlInputText();
		COMP_CLMAS_FORCE_DIVN_YN= new HtmlSelectOneMenu ();
		COMP_CLMAS_FORCE_DEPT_YN= new HtmlSelectOneMenu ();
		COMP_UI_M_MAIN_ACNT_NAME= new HtmlInputText();
		getWarningMap().clear();
	}

	public HtmlOutputLabel getCOMP_CLMAS_FRZ_FLAG_LABEL() {
		return COMP_CLMAS_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_CLMAS_FRZ_FLAG() {
		return COMP_CLMAS_FRZ_FLAG;
	}

	public void setCOMP_CLMAS_FRZ_FLAG_LABEL(HtmlOutputLabel COMP_CLMAS_FRZ_FLAG_LABEL) {
		this.COMP_CLMAS_FRZ_FLAG_LABEL = COMP_CLMAS_FRZ_FLAG_LABEL;
	}

	public void setCOMP_CLMAS_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_CLMAS_FRZ_FLAG) {
		this.COMP_CLMAS_FRZ_FLAG = COMP_CLMAS_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_CLMAS_SRC_BUS_TO_LABEL() {
		return COMP_CLMAS_SRC_BUS_TO_LABEL;
	}

	public HtmlInputText getCOMP_CLMAS_SRC_BUS_TO() {
		return COMP_CLMAS_SRC_BUS_TO;
	}

	public void setCOMP_CLMAS_SRC_BUS_TO_LABEL(HtmlOutputLabel COMP_CLMAS_SRC_BUS_TO_LABEL) {
		this.COMP_CLMAS_SRC_BUS_TO_LABEL = COMP_CLMAS_SRC_BUS_TO_LABEL;
	}

	public void setCOMP_CLMAS_SRC_BUS_TO(HtmlInputText COMP_CLMAS_SRC_BUS_TO) {
		this.COMP_CLMAS_SRC_BUS_TO = COMP_CLMAS_SRC_BUS_TO;
	}

	public HtmlOutputLabel getCOMP_CLMAS_SRC_BUS_FM_LABEL() {
		return COMP_CLMAS_SRC_BUS_FM_LABEL;
	}

	public HtmlInputText getCOMP_CLMAS_SRC_BUS_FM() {
		return COMP_CLMAS_SRC_BUS_FM;
	}

	public void setCOMP_CLMAS_SRC_BUS_FM_LABEL(HtmlOutputLabel COMP_CLMAS_SRC_BUS_FM_LABEL) {
		this.COMP_CLMAS_SRC_BUS_FM_LABEL = COMP_CLMAS_SRC_BUS_FM_LABEL;
	}

	public void setCOMP_CLMAS_SRC_BUS_FM(HtmlInputText COMP_CLMAS_SRC_BUS_FM) {
		this.COMP_CLMAS_SRC_BUS_FM = COMP_CLMAS_SRC_BUS_FM;
	}

	public HtmlOutputLabel getCOMP_CLMAS_BUS_TO_CODE_LABEL() {
		return COMP_CLMAS_BUS_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CLMAS_BUS_TO_CODE() {
		return COMP_CLMAS_BUS_TO_CODE;
	}

	public void setCOMP_CLMAS_BUS_TO_CODE_LABEL(HtmlOutputLabel COMP_CLMAS_BUS_TO_CODE_LABEL) {
		this.COMP_CLMAS_BUS_TO_CODE_LABEL = COMP_CLMAS_BUS_TO_CODE_LABEL;
	}

	public void setCOMP_CLMAS_BUS_TO_CODE(HtmlInputText COMP_CLMAS_BUS_TO_CODE) {
		this.COMP_CLMAS_BUS_TO_CODE = COMP_CLMAS_BUS_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_CLMAS_BUS_FM_CODE_LABEL() {
		return COMP_CLMAS_BUS_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CLMAS_BUS_FM_CODE() {
		return COMP_CLMAS_BUS_FM_CODE;
	}

	public void setCOMP_CLMAS_BUS_FM_CODE_LABEL(HtmlOutputLabel COMP_CLMAS_BUS_FM_CODE_LABEL) {
		this.COMP_CLMAS_BUS_FM_CODE_LABEL = COMP_CLMAS_BUS_FM_CODE_LABEL;
	}

	public void setCOMP_CLMAS_BUS_FM_CODE(HtmlInputText COMP_CLMAS_BUS_FM_CODE) {
		this.COMP_CLMAS_BUS_FM_CODE = COMP_CLMAS_BUS_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_CLMAS_DIVN_TO_CODE_LABEL() {
		return COMP_CLMAS_DIVN_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CLMAS_DIVN_TO_CODE() {
		return COMP_CLMAS_DIVN_TO_CODE;
	}

	public void setCOMP_CLMAS_DIVN_TO_CODE_LABEL(HtmlOutputLabel COMP_CLMAS_DIVN_TO_CODE_LABEL) {
		this.COMP_CLMAS_DIVN_TO_CODE_LABEL = COMP_CLMAS_DIVN_TO_CODE_LABEL;
	}

	public void setCOMP_CLMAS_DIVN_TO_CODE(HtmlInputText COMP_CLMAS_DIVN_TO_CODE) {
		this.COMP_CLMAS_DIVN_TO_CODE = COMP_CLMAS_DIVN_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_CLMAS_DIVN_FM_CODE_LABEL() {
		return COMP_CLMAS_DIVN_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CLMAS_DIVN_FM_CODE() {
		return COMP_CLMAS_DIVN_FM_CODE;
	}

	public void setCOMP_CLMAS_DIVN_FM_CODE_LABEL(HtmlOutputLabel COMP_CLMAS_DIVN_FM_CODE_LABEL) {
		this.COMP_CLMAS_DIVN_FM_CODE_LABEL = COMP_CLMAS_DIVN_FM_CODE_LABEL;
	}

	public void setCOMP_CLMAS_DIVN_FM_CODE(HtmlInputText COMP_CLMAS_DIVN_FM_CODE) {
		this.COMP_CLMAS_DIVN_FM_CODE = COMP_CLMAS_DIVN_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_CLMAS_DEPT_TO_CODE_LABEL() {
		return COMP_CLMAS_DEPT_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CLMAS_DEPT_TO_CODE() {
		return COMP_CLMAS_DEPT_TO_CODE;
	}

	public void setCOMP_CLMAS_DEPT_TO_CODE_LABEL(HtmlOutputLabel COMP_CLMAS_DEPT_TO_CODE_LABEL) {
		this.COMP_CLMAS_DEPT_TO_CODE_LABEL = COMP_CLMAS_DEPT_TO_CODE_LABEL;
	}

	public void setCOMP_CLMAS_DEPT_TO_CODE(HtmlInputText COMP_CLMAS_DEPT_TO_CODE) {
		this.COMP_CLMAS_DEPT_TO_CODE = COMP_CLMAS_DEPT_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_CLMAS_DEPT_FM_CODE_LABEL() {
		return COMP_CLMAS_DEPT_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CLMAS_DEPT_FM_CODE() {
		return COMP_CLMAS_DEPT_FM_CODE;
	}

	public void setCOMP_CLMAS_DEPT_FM_CODE_LABEL(HtmlOutputLabel COMP_CLMAS_DEPT_FM_CODE_LABEL) {
		this.COMP_CLMAS_DEPT_FM_CODE_LABEL = COMP_CLMAS_DEPT_FM_CODE_LABEL;
	}

	public void setCOMP_CLMAS_DEPT_FM_CODE(HtmlInputText COMP_CLMAS_DEPT_FM_CODE) {
		this.COMP_CLMAS_DEPT_FM_CODE = COMP_CLMAS_DEPT_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_CLMAS_DOC_TO_TYPE_LABEL() {
		return COMP_CLMAS_DOC_TO_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_CLMAS_DOC_TO_TYPE() {
		return COMP_CLMAS_DOC_TO_TYPE;
	}

	public void setCOMP_CLMAS_DOC_TO_TYPE_LABEL(HtmlOutputLabel COMP_CLMAS_DOC_TO_TYPE_LABEL) {
		this.COMP_CLMAS_DOC_TO_TYPE_LABEL = COMP_CLMAS_DOC_TO_TYPE_LABEL;
	}

	public void setCOMP_CLMAS_DOC_TO_TYPE(HtmlInputText COMP_CLMAS_DOC_TO_TYPE) {
		this.COMP_CLMAS_DOC_TO_TYPE = COMP_CLMAS_DOC_TO_TYPE;
	}

	public HtmlOutputLabel getCOMP_CLMAS_DOC_FM_TYPE_LABEL() {
		return COMP_CLMAS_DOC_FM_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_CLMAS_DOC_FM_TYPE() {
		return COMP_CLMAS_DOC_FM_TYPE;
	}

	public void setCOMP_CLMAS_DOC_FM_TYPE_LABEL(HtmlOutputLabel COMP_CLMAS_DOC_FM_TYPE_LABEL) {
		this.COMP_CLMAS_DOC_FM_TYPE_LABEL = COMP_CLMAS_DOC_FM_TYPE_LABEL;
	}

	public void setCOMP_CLMAS_DOC_FM_TYPE(HtmlInputText COMP_CLMAS_DOC_FM_TYPE) {
		this.COMP_CLMAS_DOC_FM_TYPE = COMP_CLMAS_DOC_FM_TYPE;
	}

	public HtmlOutputLabel getCOMP_CLMAS_CLM_TYPE_TO_CODE_LABEL() {
		return COMP_CLMAS_CLM_TYPE_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CLMAS_CLM_TYPE_TO_CODE() {
		return COMP_CLMAS_CLM_TYPE_TO_CODE;
	}

	public void setCOMP_CLMAS_CLM_TYPE_TO_CODE_LABEL(HtmlOutputLabel COMP_CLMAS_CLM_TYPE_TO_CODE_LABEL) {
		this.COMP_CLMAS_CLM_TYPE_TO_CODE_LABEL = COMP_CLMAS_CLM_TYPE_TO_CODE_LABEL;
	}

	public void setCOMP_CLMAS_CLM_TYPE_TO_CODE(HtmlInputText COMP_CLMAS_CLM_TYPE_TO_CODE) {
		this.COMP_CLMAS_CLM_TYPE_TO_CODE = COMP_CLMAS_CLM_TYPE_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_CLMAS_CLM_TYPE_FM_CODE_LABEL() {
		return COMP_CLMAS_CLM_TYPE_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CLMAS_CLM_TYPE_FM_CODE() {
		return COMP_CLMAS_CLM_TYPE_FM_CODE;
	}

	public void setCOMP_CLMAS_CLM_TYPE_FM_CODE_LABEL(HtmlOutputLabel COMP_CLMAS_CLM_TYPE_FM_CODE_LABEL) {
		this.COMP_CLMAS_CLM_TYPE_FM_CODE_LABEL = COMP_CLMAS_CLM_TYPE_FM_CODE_LABEL;
	}

	public void setCOMP_CLMAS_CLM_TYPE_FM_CODE(HtmlInputText COMP_CLMAS_CLM_TYPE_FM_CODE) {
		this.COMP_CLMAS_CLM_TYPE_FM_CODE = COMP_CLMAS_CLM_TYPE_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_CLMAS_PROD_CODE_TO_LABEL() {
		return COMP_CLMAS_PROD_CODE_TO_LABEL;
	}

	public HtmlInputText getCOMP_CLMAS_PROD_CODE_TO() {
		return COMP_CLMAS_PROD_CODE_TO;
	}

	public void setCOMP_CLMAS_PROD_CODE_TO_LABEL(HtmlOutputLabel COMP_CLMAS_PROD_CODE_TO_LABEL) {
		this.COMP_CLMAS_PROD_CODE_TO_LABEL = COMP_CLMAS_PROD_CODE_TO_LABEL;
	}

	public void setCOMP_CLMAS_PROD_CODE_TO(HtmlInputText COMP_CLMAS_PROD_CODE_TO) {
		this.COMP_CLMAS_PROD_CODE_TO = COMP_CLMAS_PROD_CODE_TO;
	}

	public HtmlOutputLabel getCOMP_CLMAS_PROD_CODE_FM_LABEL() {
		return COMP_CLMAS_PROD_CODE_FM_LABEL;
	}

	public HtmlInputText getCOMP_CLMAS_PROD_CODE_FM() {
		return COMP_CLMAS_PROD_CODE_FM;
	}

	public void setCOMP_CLMAS_PROD_CODE_FM_LABEL(HtmlOutputLabel COMP_CLMAS_PROD_CODE_FM_LABEL) {
		this.COMP_CLMAS_PROD_CODE_FM_LABEL = COMP_CLMAS_PROD_CODE_FM_LABEL;
	}

	public void setCOMP_CLMAS_PROD_CODE_FM(HtmlInputText COMP_CLMAS_PROD_CODE_FM) {
		this.COMP_CLMAS_PROD_CODE_FM = COMP_CLMAS_PROD_CODE_FM;
	}

	public HtmlOutputLabel getCOMP_CLMAS_COVER_CODE_TO_LABEL() {
		return COMP_CLMAS_COVER_CODE_TO_LABEL;
	}

	public HtmlInputText getCOMP_CLMAS_COVER_CODE_TO() {
		return COMP_CLMAS_COVER_CODE_TO;
	}

	public void setCOMP_CLMAS_COVER_CODE_TO_LABEL(HtmlOutputLabel COMP_CLMAS_COVER_CODE_TO_LABEL) {
		this.COMP_CLMAS_COVER_CODE_TO_LABEL = COMP_CLMAS_COVER_CODE_TO_LABEL;
	}

	public void setCOMP_CLMAS_COVER_CODE_TO(HtmlInputText COMP_CLMAS_COVER_CODE_TO) {
		this.COMP_CLMAS_COVER_CODE_TO = COMP_CLMAS_COVER_CODE_TO;
	}

	public HtmlOutputLabel getCOMP_CLMAS_COVER_CODE_FM_LABEL() {
		return COMP_CLMAS_COVER_CODE_FM_LABEL;
	}

	public HtmlInputText getCOMP_CLMAS_COVER_CODE_FM() {
		return COMP_CLMAS_COVER_CODE_FM;
	}

	public void setCOMP_CLMAS_COVER_CODE_FM_LABEL(HtmlOutputLabel COMP_CLMAS_COVER_CODE_FM_LABEL) {
		this.COMP_CLMAS_COVER_CODE_FM_LABEL = COMP_CLMAS_COVER_CODE_FM_LABEL;
	}

	public void setCOMP_CLMAS_COVER_CODE_FM(HtmlInputText COMP_CLMAS_COVER_CODE_FM) {
		this.COMP_CLMAS_COVER_CODE_FM = COMP_CLMAS_COVER_CODE_FM;
	}

	public HtmlOutputLabel getCOMP_CLMAS_CUST_CLS_TO_CODE_LABEL() {
		return COMP_CLMAS_CUST_CLS_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CLMAS_CUST_CLS_TO_CODE() {
		return COMP_CLMAS_CUST_CLS_TO_CODE;
	}

	public void setCOMP_CLMAS_CUST_CLS_TO_CODE_LABEL(HtmlOutputLabel COMP_CLMAS_CUST_CLS_TO_CODE_LABEL) {
		this.COMP_CLMAS_CUST_CLS_TO_CODE_LABEL = COMP_CLMAS_CUST_CLS_TO_CODE_LABEL;
	}

	public void setCOMP_CLMAS_CUST_CLS_TO_CODE(HtmlInputText COMP_CLMAS_CUST_CLS_TO_CODE) {
		this.COMP_CLMAS_CUST_CLS_TO_CODE = COMP_CLMAS_CUST_CLS_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_CLMAS_CUST_CLS_FM_CODE_LABEL() {
		return COMP_CLMAS_CUST_CLS_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CLMAS_CUST_CLS_FM_CODE() {
		return COMP_CLMAS_CUST_CLS_FM_CODE;
	}

	public void setCOMP_CLMAS_CUST_CLS_FM_CODE_LABEL(HtmlOutputLabel COMP_CLMAS_CUST_CLS_FM_CODE_LABEL) {
		this.COMP_CLMAS_CUST_CLS_FM_CODE_LABEL = COMP_CLMAS_CUST_CLS_FM_CODE_LABEL;
	}

	public void setCOMP_CLMAS_CUST_CLS_FM_CODE(HtmlInputText COMP_CLMAS_CUST_CLS_FM_CODE) {
		this.COMP_CLMAS_CUST_CLS_FM_CODE = COMP_CLMAS_CUST_CLS_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_CLMAS_ASSURED_TYPE_LABEL() {
		return COMP_CLMAS_ASSURED_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CLMAS_ASSURED_TYPE() {
		return COMP_CLMAS_ASSURED_TYPE;
	}

	public void setCOMP_CLMAS_ASSURED_TYPE_LABEL(HtmlOutputLabel COMP_CLMAS_ASSURED_TYPE_LABEL) {
		this.COMP_CLMAS_ASSURED_TYPE_LABEL = COMP_CLMAS_ASSURED_TYPE_LABEL;
	}

	public void setCOMP_CLMAS_ASSURED_TYPE(HtmlSelectOneMenu COMP_CLMAS_ASSURED_TYPE) {
		this.COMP_CLMAS_ASSURED_TYPE = COMP_CLMAS_ASSURED_TYPE;
	}

	public HtmlOutputLabel getCOMP_CLMAS_TYPE_LABEL() {
		return COMP_CLMAS_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CLMAS_TYPE() {
		return COMP_CLMAS_TYPE;
	}

	public void setCOMP_CLMAS_TYPE_LABEL(HtmlOutputLabel COMP_CLMAS_TYPE_LABEL) {
		this.COMP_CLMAS_TYPE_LABEL = COMP_CLMAS_TYPE_LABEL;
	}

	public void setCOMP_CLMAS_TYPE(HtmlSelectOneMenu COMP_CLMAS_TYPE) {
		this.COMP_CLMAS_TYPE = COMP_CLMAS_TYPE;
	}

	public HtmlOutputLabel getCOMP_CLMAS_FORCE_DIVN_YN_LABEL() {
		return COMP_CLMAS_FORCE_DIVN_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CLMAS_FORCE_DIVN_YN() {
		return COMP_CLMAS_FORCE_DIVN_YN;
	}

	public void setCOMP_CLMAS_FORCE_DIVN_YN_LABEL(HtmlOutputLabel COMP_CLMAS_FORCE_DIVN_YN_LABEL) {
		this.COMP_CLMAS_FORCE_DIVN_YN_LABEL = COMP_CLMAS_FORCE_DIVN_YN_LABEL;
	}

	public void setCOMP_CLMAS_FORCE_DIVN_YN(HtmlSelectOneMenu COMP_CLMAS_FORCE_DIVN_YN) {
		this.COMP_CLMAS_FORCE_DIVN_YN = COMP_CLMAS_FORCE_DIVN_YN;
	}

	public HtmlOutputLabel getCOMP_CLMAS_FORCE_DEPT_YN_LABEL() {
		return COMP_CLMAS_FORCE_DEPT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CLMAS_FORCE_DEPT_YN() {
		return COMP_CLMAS_FORCE_DEPT_YN;
	}

	public void setCOMP_CLMAS_FORCE_DEPT_YN_LABEL(HtmlOutputLabel COMP_CLMAS_FORCE_DEPT_YN_LABEL) {
		this.COMP_CLMAS_FORCE_DEPT_YN_LABEL = COMP_CLMAS_FORCE_DEPT_YN_LABEL;
	}

	public void setCOMP_CLMAS_FORCE_DEPT_YN(HtmlSelectOneMenu COMP_CLMAS_FORCE_DEPT_YN) {
		this.COMP_CLMAS_FORCE_DEPT_YN = COMP_CLMAS_FORCE_DEPT_YN;
	}

	public HtmlOutputLabel getCOMP_CLMAS_MAIN_ACNT_CODE_LABEL() {
		return COMP_CLMAS_MAIN_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CLMAS_MAIN_ACNT_CODE() {
		return COMP_CLMAS_MAIN_ACNT_CODE;
	}

	public void setCOMP_CLMAS_MAIN_ACNT_CODE_LABEL(HtmlOutputLabel COMP_CLMAS_MAIN_ACNT_CODE_LABEL) {
		this.COMP_CLMAS_MAIN_ACNT_CODE_LABEL = COMP_CLMAS_MAIN_ACNT_CODE_LABEL;
	}

	public void setCOMP_CLMAS_MAIN_ACNT_CODE(HtmlInputText COMP_CLMAS_MAIN_ACNT_CODE) {
		this.COMP_CLMAS_MAIN_ACNT_CODE = COMP_CLMAS_MAIN_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_MAIN_ACNT_NAME_LABEL() {
		return COMP_UI_M_MAIN_ACNT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_MAIN_ACNT_NAME() {
		return COMP_UI_M_MAIN_ACNT_NAME;
	}

	public void setCOMP_UI_M_MAIN_ACNT_NAME_LABEL(HtmlOutputLabel COMP_UI_M_MAIN_ACNT_NAME_LABEL) {
		this.COMP_UI_M_MAIN_ACNT_NAME_LABEL = COMP_UI_M_MAIN_ACNT_NAME_LABEL;
	}

	public void setCOMP_UI_M_MAIN_ACNT_NAME(HtmlInputText COMP_UI_M_MAIN_ACNT_NAME) {
		this.COMP_UI_M_MAIN_ACNT_NAME = COMP_UI_M_MAIN_ACNT_NAME;
	}

	public HtmlOutputLabel getCOMP_CLMAS_SUB_ACNT_CODE_LABEL() {
		return COMP_CLMAS_SUB_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CLMAS_SUB_ACNT_CODE() {
		return COMP_CLMAS_SUB_ACNT_CODE;
	}

	public void setCOMP_CLMAS_SUB_ACNT_CODE_LABEL(HtmlOutputLabel COMP_CLMAS_SUB_ACNT_CODE_LABEL) {
		this.COMP_CLMAS_SUB_ACNT_CODE_LABEL = COMP_CLMAS_SUB_ACNT_CODE_LABEL;
	}

	public void setCOMP_CLMAS_SUB_ACNT_CODE(HtmlInputText COMP_CLMAS_SUB_ACNT_CODE) {
		this.COMP_CLMAS_SUB_ACNT_CODE = COMP_CLMAS_SUB_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_SUB_ACNT_NAME_LABEL() {
		return COMP_UI_M_SUB_ACNT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_SUB_ACNT_NAME() {
		return COMP_UI_M_SUB_ACNT_NAME;
	}

	public void setCOMP_UI_M_SUB_ACNT_NAME_LABEL(HtmlOutputLabel COMP_UI_M_SUB_ACNT_NAME_LABEL) {
		this.COMP_UI_M_SUB_ACNT_NAME_LABEL = COMP_UI_M_SUB_ACNT_NAME_LABEL;
	}

	public void setCOMP_UI_M_SUB_ACNT_NAME(HtmlInputText COMP_UI_M_SUB_ACNT_NAME) {
		this.COMP_UI_M_SUB_ACNT_NAME = COMP_UI_M_SUB_ACNT_NAME;
	}

	public HtmlOutputLabel getCOMP_CLMAS_DIVN_CODE_LABEL() {
		return COMP_CLMAS_DIVN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CLMAS_DIVN_CODE() {
		return COMP_CLMAS_DIVN_CODE;
	}

	public void setCOMP_CLMAS_DIVN_CODE_LABEL(HtmlOutputLabel COMP_CLMAS_DIVN_CODE_LABEL) {
		this.COMP_CLMAS_DIVN_CODE_LABEL = COMP_CLMAS_DIVN_CODE_LABEL;
	}

	public void setCOMP_CLMAS_DIVN_CODE(HtmlInputText COMP_CLMAS_DIVN_CODE) {
		this.COMP_CLMAS_DIVN_CODE = COMP_CLMAS_DIVN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DIVN_NAME_LABEL() {
		return COMP_UI_M_DIVN_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DIVN_NAME() {
		return COMP_UI_M_DIVN_NAME;
	}

	public void setCOMP_UI_M_DIVN_NAME_LABEL(HtmlOutputLabel COMP_UI_M_DIVN_NAME_LABEL) {
		this.COMP_UI_M_DIVN_NAME_LABEL = COMP_UI_M_DIVN_NAME_LABEL;
	}

	public void setCOMP_UI_M_DIVN_NAME(HtmlInputText COMP_UI_M_DIVN_NAME) {
		this.COMP_UI_M_DIVN_NAME = COMP_UI_M_DIVN_NAME;
	}

	public HtmlOutputLabel getCOMP_CLMAS_DEPT_CODE_LABEL() {
		return COMP_CLMAS_DEPT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CLMAS_DEPT_CODE() {
		return COMP_CLMAS_DEPT_CODE;
	}

	public void setCOMP_CLMAS_DEPT_CODE_LABEL(HtmlOutputLabel COMP_CLMAS_DEPT_CODE_LABEL) {
		this.COMP_CLMAS_DEPT_CODE_LABEL = COMP_CLMAS_DEPT_CODE_LABEL;
	}

	public void setCOMP_CLMAS_DEPT_CODE(HtmlInputText COMP_CLMAS_DEPT_CODE) {
		this.COMP_CLMAS_DEPT_CODE = COMP_CLMAS_DEPT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEPT_NAME_LABEL() {
		return COMP_UI_M_DEPT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEPT_NAME() {
		return COMP_UI_M_DEPT_NAME;
	}

	public void setCOMP_UI_M_DEPT_NAME_LABEL(HtmlOutputLabel COMP_UI_M_DEPT_NAME_LABEL) {
		this.COMP_UI_M_DEPT_NAME_LABEL = COMP_UI_M_DEPT_NAME_LABEL;
	}

	public void setCOMP_UI_M_DEPT_NAME(HtmlInputText COMP_UI_M_DEPT_NAME) {
		this.COMP_UI_M_DEPT_NAME = COMP_UI_M_DEPT_NAME;
	}

	public HtmlOutputLabel getCOMP_CLMAS_ANLY_CODE_1_LABEL() {
		return COMP_CLMAS_ANLY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_CLMAS_ANLY_CODE_1() {
		return COMP_CLMAS_ANLY_CODE_1;
	}

	public void setCOMP_CLMAS_ANLY_CODE_1_LABEL(HtmlOutputLabel COMP_CLMAS_ANLY_CODE_1_LABEL) {
		this.COMP_CLMAS_ANLY_CODE_1_LABEL = COMP_CLMAS_ANLY_CODE_1_LABEL;
	}

	public void setCOMP_CLMAS_ANLY_CODE_1(HtmlInputText COMP_CLMAS_ANLY_CODE_1) {
		this.COMP_CLMAS_ANLY_CODE_1 = COMP_CLMAS_ANLY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_ANLY_NAME_LABEL() {
		return COMP_UI_M_ANLY_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ANLY_NAME() {
		return COMP_UI_M_ANLY_NAME;
	}

	public void setCOMP_UI_M_ANLY_NAME_LABEL(HtmlOutputLabel COMP_UI_M_ANLY_NAME_LABEL) {
		this.COMP_UI_M_ANLY_NAME_LABEL = COMP_UI_M_ANLY_NAME_LABEL;
	}

	public void setCOMP_UI_M_ANLY_NAME(HtmlInputText COMP_UI_M_ANLY_NAME) {
		this.COMP_UI_M_ANLY_NAME = COMP_UI_M_ANLY_NAME;
	}

	public HtmlOutputLabel getCOMP_CLMAS_ANLY_CODE_2_LABEL() {
		return COMP_CLMAS_ANLY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_CLMAS_ANLY_CODE_2() {
		return COMP_CLMAS_ANLY_CODE_2;
	}

	public void setCOMP_CLMAS_ANLY_CODE_2_LABEL(HtmlOutputLabel COMP_CLMAS_ANLY_CODE_2_LABEL) {
		this.COMP_CLMAS_ANLY_CODE_2_LABEL = COMP_CLMAS_ANLY_CODE_2_LABEL;
	}

	public void setCOMP_CLMAS_ANLY_CODE_2(HtmlInputText COMP_CLMAS_ANLY_CODE_2) {
		this.COMP_CLMAS_ANLY_CODE_2 = COMP_CLMAS_ANLY_CODE_2;
	}

	public HtmlOutputLabel getCOMP_UI_M_ANLY_NAME_1_LABEL() {
		return COMP_UI_M_ANLY_NAME_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ANLY_NAME_1() {
		return COMP_UI_M_ANLY_NAME_1;
	}

	public void setCOMP_UI_M_ANLY_NAME_1_LABEL(HtmlOutputLabel COMP_UI_M_ANLY_NAME_1_LABEL) {
		this.COMP_UI_M_ANLY_NAME_1_LABEL = COMP_UI_M_ANLY_NAME_1_LABEL;
	}

	public void setCOMP_UI_M_ANLY_NAME_1(HtmlInputText COMP_UI_M_ANLY_NAME_1) {
		this.COMP_UI_M_ANLY_NAME_1 = COMP_UI_M_ANLY_NAME_1;
	}

	public HtmlOutputLabel getCOMP_CLMAS_ACTY_CODE_1_LABEL() {
		return COMP_CLMAS_ACTY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_CLMAS_ACTY_CODE_1() {
		return COMP_CLMAS_ACTY_CODE_1;
	}

	public void setCOMP_CLMAS_ACTY_CODE_1_LABEL(HtmlOutputLabel COMP_CLMAS_ACTY_CODE_1_LABEL) {
		this.COMP_CLMAS_ACTY_CODE_1_LABEL = COMP_CLMAS_ACTY_CODE_1_LABEL;
	}

	public void setCOMP_CLMAS_ACTY_CODE_1(HtmlInputText COMP_CLMAS_ACTY_CODE_1) {
		this.COMP_CLMAS_ACTY_CODE_1 = COMP_CLMAS_ACTY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACTY_NAME_LABEL() {
		return COMP_UI_M_ACTY_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACTY_NAME() {
		return COMP_UI_M_ACTY_NAME;
	}

	public void setCOMP_UI_M_ACTY_NAME_LABEL(HtmlOutputLabel COMP_UI_M_ACTY_NAME_LABEL) {
		this.COMP_UI_M_ACTY_NAME_LABEL = COMP_UI_M_ACTY_NAME_LABEL;
	}

	public void setCOMP_UI_M_ACTY_NAME(HtmlInputText COMP_UI_M_ACTY_NAME) {
		this.COMP_UI_M_ACTY_NAME = COMP_UI_M_ACTY_NAME;
	}

	public HtmlOutputLabel getCOMP_CLMAS_ACTY_CODE_2_LABEL() {
		return COMP_CLMAS_ACTY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_CLMAS_ACTY_CODE_2() {
		return COMP_CLMAS_ACTY_CODE_2;
	}

	public void setCOMP_CLMAS_ACTY_CODE_2_LABEL(HtmlOutputLabel COMP_CLMAS_ACTY_CODE_2_LABEL) {
		this.COMP_CLMAS_ACTY_CODE_2_LABEL = COMP_CLMAS_ACTY_CODE_2_LABEL;
	}

	public void setCOMP_CLMAS_ACTY_CODE_2(HtmlInputText COMP_CLMAS_ACTY_CODE_2) {
		this.COMP_CLMAS_ACTY_CODE_2 = COMP_CLMAS_ACTY_CODE_2;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACTY_NAME_1_LABEL() {
		return COMP_UI_M_ACTY_NAME_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACTY_NAME_1() {
		return COMP_UI_M_ACTY_NAME_1;
	}

	public void setCOMP_UI_M_ACTY_NAME_1_LABEL(HtmlOutputLabel COMP_UI_M_ACTY_NAME_1_LABEL) {
		this.COMP_UI_M_ACTY_NAME_1_LABEL = COMP_UI_M_ACTY_NAME_1_LABEL;
	}

	public void setCOMP_UI_M_ACTY_NAME_1(HtmlInputText COMP_UI_M_ACTY_NAME_1) {
		this.COMP_UI_M_ACTY_NAME_1 = COMP_UI_M_ACTY_NAME_1;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_SUB_ACNT() {
		return COMP_UI_M_BUT_SUB_ACNT;
	}

	public void setCOMP_UI_M_BUT_SUB_ACNT(HtmlCommandButton COMP_UI_M_BUT_SUB_ACNT) {
		this.COMP_UI_M_BUT_SUB_ACNT = COMP_UI_M_BUT_SUB_ACNT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN_ACNT() {
		return COMP_UI_M_BUT_MAIN_ACNT;
	}

	public void setCOMP_UI_M_BUT_MAIN_ACNT(HtmlCommandButton COMP_UI_M_BUT_MAIN_ACNT) {
		this.COMP_UI_M_BUT_MAIN_ACNT = COMP_UI_M_BUT_MAIN_ACNT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DOC_TYPE_FM_CODE() {
		return COMP_UI_M_BUT_DOC_TYPE_FM_CODE;
	}

	public void setCOMP_UI_M_BUT_DOC_TYPE_FM_CODE(HtmlCommandButton COMP_UI_M_BUT_DOC_TYPE_FM_CODE) {
		this.COMP_UI_M_BUT_DOC_TYPE_FM_CODE = COMP_UI_M_BUT_DOC_TYPE_FM_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CLMAS_PROD_CODE_FM() {
		return COMP_UI_M_BUT_CLMAS_PROD_CODE_FM;
	}

	public void setCOMP_UI_M_BUT_CLMAS_PROD_CODE_FM(HtmlCommandButton COMP_UI_M_BUT_CLMAS_PROD_CODE_FM) {
		this.COMP_UI_M_BUT_CLMAS_PROD_CODE_FM = COMP_UI_M_BUT_CLMAS_PROD_CODE_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DOC_TYPE_TO_CODE() {
		return COMP_UI_M_BUT_DOC_TYPE_TO_CODE;
	}

	public void setCOMP_UI_M_BUT_DOC_TYPE_TO_CODE(HtmlCommandButton COMP_UI_M_BUT_DOC_TYPE_TO_CODE) {
		this.COMP_UI_M_BUT_DOC_TYPE_TO_CODE = COMP_UI_M_BUT_DOC_TYPE_TO_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CLMAS_PROD_CODE_TO() {
		return COMP_UI_M_BUT_CLMAS_PROD_CODE_TO;
	}

	public void setCOMP_UI_M_BUT_CLMAS_PROD_CODE_TO(HtmlCommandButton COMP_UI_M_BUT_CLMAS_PROD_CODE_TO) {
		this.COMP_UI_M_BUT_CLMAS_PROD_CODE_TO = COMP_UI_M_BUT_CLMAS_PROD_CODE_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DEPT_TO() {
		return COMP_UI_M_BUT_DEPT_TO;
	}

	public void setCOMP_UI_M_BUT_DEPT_TO(HtmlCommandButton COMP_UI_M_BUT_DEPT_TO) {
		this.COMP_UI_M_BUT_DEPT_TO = COMP_UI_M_BUT_DEPT_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DEPT_FM() {
		return COMP_UI_M_BUT_DEPT_FM;
	}

	public void setCOMP_UI_M_BUT_DEPT_FM(HtmlCommandButton COMP_UI_M_BUT_DEPT_FM) {
		this.COMP_UI_M_BUT_DEPT_FM = COMP_UI_M_BUT_DEPT_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DIVN_TO() {
		return COMP_UI_M_BUT_DIVN_TO;
	}

	public void setCOMP_UI_M_BUT_DIVN_TO(HtmlCommandButton COMP_UI_M_BUT_DIVN_TO) {
		this.COMP_UI_M_BUT_DIVN_TO = COMP_UI_M_BUT_DIVN_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DIVN_FM() {
		return COMP_UI_M_BUT_DIVN_FM;
	}

	public void setCOMP_UI_M_BUT_DIVN_FM(HtmlCommandButton COMP_UI_M_BUT_DIVN_FM) {
		this.COMP_UI_M_BUT_DIVN_FM = COMP_UI_M_BUT_DIVN_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CUST_CODE_FM_LOV() {
		return COMP_UI_M_BUT_CUST_CODE_FM_LOV;
	}

	public void setCOMP_UI_M_BUT_CUST_CODE_FM_LOV(HtmlCommandButton COMP_UI_M_BUT_CUST_CODE_FM_LOV) {
		this.COMP_UI_M_BUT_CUST_CODE_FM_LOV = COMP_UI_M_BUT_CUST_CODE_FM_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CUST_CODE_TO_LOV() {
		return COMP_UI_M_BUT_CUST_CODE_TO_LOV;
	}

	public void setCOMP_UI_M_BUT_CUST_CODE_TO_LOV(HtmlCommandButton COMP_UI_M_BUT_CUST_CODE_TO_LOV) {
		this.COMP_UI_M_BUT_CUST_CODE_TO_LOV = COMP_UI_M_BUT_CUST_CODE_TO_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DIVN() {
		return COMP_UI_M_BUT_DIVN;
	}

	public void setCOMP_UI_M_BUT_DIVN(HtmlCommandButton COMP_UI_M_BUT_DIVN) {
		this.COMP_UI_M_BUT_DIVN = COMP_UI_M_BUT_DIVN;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CLMAS_SRC_BUS_FM() {
		return COMP_UI_M_BUT_CLMAS_SRC_BUS_FM;
	}

	public void setCOMP_UI_M_BUT_CLMAS_SRC_BUS_FM(HtmlCommandButton COMP_UI_M_BUT_CLMAS_SRC_BUS_FM) {
		this.COMP_UI_M_BUT_CLMAS_SRC_BUS_FM = COMP_UI_M_BUT_CLMAS_SRC_BUS_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CLMAS_SRC_BUS_TO() {
		return COMP_UI_M_BUT_CLMAS_SRC_BUS_TO;
	}

	public void setCOMP_UI_M_BUT_CLMAS_SRC_BUS_TO(HtmlCommandButton COMP_UI_M_BUT_CLMAS_SRC_BUS_TO) {
		this.COMP_UI_M_BUT_CLMAS_SRC_BUS_TO = COMP_UI_M_BUT_CLMAS_SRC_BUS_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CLMAS_BUS_TO_CODE_LOV() {
		return COMP_UI_M_BUT_CLMAS_BUS_TO_CODE_LOV;
	}

	public void setCOMP_UI_M_BUT_CLMAS_BUS_TO_CODE_LOV(HtmlCommandButton COMP_UI_M_BUT_CLMAS_BUS_TO_CODE_LOV) {
		this.COMP_UI_M_BUT_CLMAS_BUS_TO_CODE_LOV = COMP_UI_M_BUT_CLMAS_BUS_TO_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CLMAS_BUS_FM_CODE_LOV() {
		return COMP_UI_M_BUT_CLMAS_BUS_FM_CODE_LOV;
	}

	public void setCOMP_UI_M_BUT_CLMAS_BUS_FM_CODE_LOV(HtmlCommandButton COMP_UI_M_BUT_CLMAS_BUS_FM_CODE_LOV) {
		this.COMP_UI_M_BUT_CLMAS_BUS_FM_CODE_LOV = COMP_UI_M_BUT_CLMAS_BUS_FM_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CLMAS_CLM_TYPE_TO_LOV() {
		return COMP_UI_M_BUT_CLMAS_CLM_TYPE_TO_LOV;
	}

	public void setCOMP_UI_M_BUT_CLMAS_CLM_TYPE_TO_LOV(HtmlCommandButton COMP_UI_M_BUT_CLMAS_CLM_TYPE_TO_LOV) {
		this.COMP_UI_M_BUT_CLMAS_CLM_TYPE_TO_LOV = COMP_UI_M_BUT_CLMAS_CLM_TYPE_TO_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CLMAS_COVER_CODE_TO() {
		return COMP_UI_M_BUT_CLMAS_COVER_CODE_TO;
	}

	public void setCOMP_UI_M_BUT_CLMAS_COVER_CODE_TO(HtmlCommandButton COMP_UI_M_BUT_CLMAS_COVER_CODE_TO) {
		this.COMP_UI_M_BUT_CLMAS_COVER_CODE_TO = COMP_UI_M_BUT_CLMAS_COVER_CODE_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CLMAS_CLM_TYPE_FM_LOV() {
		return COMP_UI_M_BUT_CLMAS_CLM_TYPE_FM_LOV;
	}

	public void setCOMP_UI_M_BUT_CLMAS_CLM_TYPE_FM_LOV(HtmlCommandButton COMP_UI_M_BUT_CLMAS_CLM_TYPE_FM_LOV) {
		this.COMP_UI_M_BUT_CLMAS_CLM_TYPE_FM_LOV = COMP_UI_M_BUT_CLMAS_CLM_TYPE_FM_LOV;
	}

	public HtmlCommandButton getCOMP_B_BUT_CLMAS_COVER_CODE_FM() {
		return COMP_B_BUT_CLMAS_COVER_CODE_FM;
	}

	public void setCOMP_B_BUT_CLMAS_COVER_CODE_FM(HtmlCommandButton COMP_B_BUT_CLMAS_COVER_CODE_FM) {
		this.COMP_B_BUT_CLMAS_COVER_CODE_FM = COMP_B_BUT_CLMAS_COVER_CODE_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ACTY_2() {
		return COMP_UI_M_BUT_ACTY_2;
	}

	public void setCOMP_UI_M_BUT_ACTY_2(HtmlCommandButton COMP_UI_M_BUT_ACTY_2) {
		this.COMP_UI_M_BUT_ACTY_2 = COMP_UI_M_BUT_ACTY_2;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ACTY_1() {
		return COMP_UI_M_BUT_ACTY_1;
	}

	public void setCOMP_UI_M_BUT_ACTY_1(HtmlCommandButton COMP_UI_M_BUT_ACTY_1) {
		this.COMP_UI_M_BUT_ACTY_1 = COMP_UI_M_BUT_ACTY_1;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ANAL_1() {
		return COMP_UI_M_BUT_ANAL_1;
	}

	public void setCOMP_UI_M_BUT_ANAL_1(HtmlCommandButton COMP_UI_M_BUT_ANAL_1) {
		this.COMP_UI_M_BUT_ANAL_1 = COMP_UI_M_BUT_ANAL_1;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ANAL_2() {
		return COMP_UI_M_BUT_ANAL_2;
	}

	public void setCOMP_UI_M_BUT_ANAL_2(HtmlCommandButton COMP_UI_M_BUT_ANAL_2) {
		this.COMP_UI_M_BUT_ANAL_2 = COMP_UI_M_BUT_ANAL_2;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DEPT() {
		return COMP_UI_M_BUT_DEPT;
	}

	public void setCOMP_UI_M_BUT_DEPT(HtmlCommandButton COMP_UI_M_BUT_DEPT) {
		this.COMP_UI_M_BUT_DEPT = COMP_UI_M_BUT_DEPT;
	}

	public PM_IL_CLM_ACCOUNT_SETUP getPM_IL_CLM_ACCOUNT_SETUP_BEAN() {
		return PM_IL_CLM_ACCOUNT_SETUP_BEAN;
	}

	public void setPM_IL_CLM_ACCOUNT_SETUP_BEAN(PM_IL_CLM_ACCOUNT_SETUP PM_IL_CLM_ACCOUNT_SETUP_BEAN) {
		this.PM_IL_CLM_ACCOUNT_SETUP_BEAN = PM_IL_CLM_ACCOUNT_SETUP_BEAN;
	}
	
	public HtmlCommandButton getTest() {
		return test;
	}

	public void setTest(HtmlCommandButton test) {
		this.test = test;
	}

	public ControlBean getCtrlBean()
	{
		FacesContext context=FacesContext.getCurrentInstance();
		session=(HttpSession)context.getExternalContext().getSession(false);
		return (ControlBean)session.getAttribute("ctrlbean");
	}

	public void saveRecord(){
		String message = "";
		try{
		if(PM_IL_CLM_ACCOUNT_SETUP_BEAN.getROWID() == null){
				if(isINSERT_ALLOWED()){
				pilm024_pm_il_clm_account_setup_pre_insert();
				
				if(PM_IL_CLM_ACCOUNT_SETUP_BEAN.isFRZ_FLAG()==false){
					PM_IL_CLM_ACCOUNT_SETUP_BEAN.setCLMAS_FRZ_FLAG("N");
				}else{
					PM_IL_CLM_ACCOUNT_SETUP_BEAN.setCLMAS_FRZ_FLAG("Y");
				}
				new CRUDHandler().executeInsert(PM_IL_CLM_ACCOUNT_SETUP_BEAN,CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				message = Messages.getString("messageProperties","errorPanel$message$save");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("SAVE", message);
			}else{
				message = Messages.getString("messageProperties","errorPanel$message$insertnotallowed");
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getErrorMap().put("SAVE", message);
			}
		}else{
				if(isUPDATE_ALLOWED()){
					pilm024_pm_il_clm_account_setup_pre_update();
				if(PM_IL_CLM_ACCOUNT_SETUP_BEAN.isFRZ_FLAG()==false)
				{
					PM_IL_CLM_ACCOUNT_SETUP_BEAN.setCLMAS_FRZ_FLAG("N");
				}else{
					PM_IL_CLM_ACCOUNT_SETUP_BEAN.setCLMAS_FRZ_FLAG("Y");
				}
				new CRUDHandler().executeUpdate(PM_IL_CLM_ACCOUNT_SETUP_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				message = Messages.getString("messageProperties",
						"errorPanel$message$update");
				getWarningMap()
						.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								message);
				getWarningMap().put("UPDATE", message);
			} else{
				message = Messages.getString("messageProperties",
				"errorPanel$message$updatenotallowed");
		getErrorMap()
				.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
		getErrorMap().put("UPDATE", message);
			}
		}
		}catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}finally{
			try{
				CommonUtils utils = new CommonUtils();
				utils.doComitt();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
}
	
	public void create_New_Record(){
		int i =0;
		try {
			i = handler.executeInsert(PM_IL_CLM_ACCOUNT_SETUP_BEAN, connection);
				getWarningMap().put("current",(i+warningmessage));
				if(i>0){
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void onFocusField(ActionEvent event){
		getCOMP_CLMAS_SRC_BUS_FM().setSubmittedValue("");
	}

	public List CLMAS_SRC_BUS_FM_lovAction(Object obj)throws Exception {
		List lovList = new ArrayList();
		String query =null;
		if(obj.toString().equals("*")){
			query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE='SRC_BUS_TY' AND NVL(PC_FRZ_FLAG,'N') = 'N'";
		}else{
			query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE='SRC_BUS_TY' AND NVL(PC_FRZ_FLAG,'N') = 'N' AND PC_CODE LIKE('"+obj.toString()+"%') ";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CLMAS_SRC_BUS_FM_LOV lovBox = new CLMAS_SRC_BUS_FM_LOV(); 
			lovBox.setPC_CODE(rs.getString("PC_CODE"));
			lovBox.setPC_DESC(rs.getString("PC_DESC"));
			lovList.add(lovBox);
		}
		rs.close();
		return lovList;

	}

	public void Bring_CLMAS_SRC_BUS_TO(ActionEvent ae) throws Exception {
		if(getCOMP_CLMAS_SRC_BUS_TO().getSubmittedValue().equals("")){
			UIInput input = (UIInput) ae.getComponent().getParent(); 
			ErrorHelpUtil.validate(input, input.getId(), getErrorMap());
		}
		System.out.println("Bring_CLMAS_SRC_BUS_TO>>>>>>>INSIDE");
		ResultSet rs = null;
		String query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE='SRC_BUS_TY' AND NVL(PC_FRZ_FLAG,'N') = 'N'";
		String CLMAS_SRC_BUS_TO = getCOMP_CLMAS_SRC_BUS_TO().getSubmittedValue().toString();
		System.out.println("CLMAS_SRC_BUS_TO>>>>>>>>>>>>>>>>>>"+CLMAS_SRC_BUS_TO);
		query = query + " AND PC_CODE ='" + CLMAS_SRC_BUS_TO+"'";

		System.out.println("PC_CODE>>>>>>>>()-query" + query);
		Connection con = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query, con);
		while(rs.next()){
			System.out.println("Inside while Loop");
			COMP_CLMAS_BUS_TO_CODE.setSubmittedValue(rs.getString("PC_DESC"));

		}
		rs.close();
	}

	public List CLMAS_BUS_FM_CODE_lovAction(Object obj) {
		List lovList = new ArrayList();
		System.out.println(obj);
		if (obj.toString().equals("*")) {
			String query = "SELECT PS_CODE,PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE='IL_BUSINES'";
			lovList = CLMAS_BUS_FM_CODEsuggestionList(query);
		}
		return lovList;
	}

	public List CLMAS_BUS_FM_CODEsuggestionList(String query) {
		Statement stmt = null;
		List list = new ArrayList();
		ResultSet rs;
		try {
			FacesContext fc = FacesContext.getCurrentInstance();
			ServletContext context = (ServletContext) fc.getExternalContext()
			.getContext();
			Connection con = CommonUtils.getConnection();

			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				CLMAS_BUS_FM_CODE_LOV lovBox = new CLMAS_BUS_FM_CODE_LOV(); 
				lovBox.setPS_CODE(rs.getString("PS_CODE"));
				lovBox.setPS_CODE_DESC(rs.getString("PS_CODE_DESC"));
				list.add(lovBox);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List CLMAS_DIVN_FM_CODE_lovAction(Object obj)throws Exception {
		List lovList = new ArrayList();
		String query =null;
		if(obj.toString().equals("*")){
			query = "select DIVN_CODE,DIVN_NAME from PM_DIVISION where DIVN_COMP_CODE ='001' AND NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND" +
			" EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DIVN_CODE AND ADS_USER_ID = ADS_USER_ID AND ADS_FRZ_FLAG = 'N')";
		}else{
			query = "select DIVN_CODE,DIVN_NAME from PM_DIVISION where DIVN_COMP_CODE ='001' AND NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND" +
			" EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DIVN_CODE AND ADS_USER_ID = ADS_USER_ID AND ADS_FRZ_FLAG = 'N') AND DIVN_CODE LIKE('"+obj.toString()+"%')";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CLMAS_DIVN_FM_CODE_LOV lovBox = new CLMAS_DIVN_FM_CODE_LOV(); 
			lovBox.setDIVN_CODE(rs.getString("DIVN_CODE"));
			lovBox.setDIVN_NAME(rs.getString("DIVN_NAME"));
			lovList.add(lovBox);
		}
		rs.close();
		return lovList;
	}

	public List CLMAS_DEPT_FM_CODE_lovAction(Object obj)throws Exception {
		List lovList = new ArrayList();
		String query =null;
		if(obj.toString().equals("*")){
			//[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DEPARTMENT to FM_DEPARTMENT. Added by : Shankar.B 31-Mar-2009
			query = "SELECT DEPT_CODE,DEPT_NAME from FM_DEPARTMENT where DEPT_COMP_CODE = '001' AND " +
			" DEPT_DIVN_CODE = '"+getCOMP_CLMAS_DIVN_FM_CODE().getValue()+"' AND DEPT_FRZ_FLAG  = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE" +
			" ADS_DIVN_CODE = DEPT_DIVN_CODE AND ADS_DEPT_CODE = DEPT_CODE AND ADS_USER_ID = ADS_USER_ID AND" +
			" ADS_FRZ_FLAG = 'N')";
		}else{
			//[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DEPARTMENT to FM_DEPARTMENT. Added by : Shankar.B 31-Mar-2009
			query = "SELECT DEPT_CODE,DEPT_NAME from FM_DEPARTMENT where DEPT_COMP_CODE = '001' AND " +
			" DEPT_DIVN_CODE = '"+getCOMP_CLMAS_DIVN_FM_CODE().getValue()+"' AND DEPT_FRZ_FLAG  = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE" +
			" ADS_DIVN_CODE = DEPT_DIVN_CODE AND ADS_DEPT_CODE = DEPT_CODE AND ADS_USER_ID = ADS_USER_ID AND" +
			" ADS_FRZ_FLAG = 'N') AND DEPT_CODE LIKE('"+obj.toString()+"%')";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CLMAS_DEPT_FM_CODE_LOV lovBox = new CLMAS_DEPT_FM_CODE_LOV(); 
			lovBox.setDEPT_CODE(rs.getString("DEPT_CODE"));
			lovBox.setDEPT_NAME(rs.getString("DEPT_NAME"));
			lovList.add(lovBox);
		}
		rs.close();
		return lovList;
	}
	
	public List CLMAS_DOC_FM_TYPE_lovAction(Object obj)throws Exception {
		List lovList = new ArrayList();
		String query =null;
		if(obj.toString().equals("*")){
			query = "SELECT DS_CODE,DS_DESC from PM_IL_DOC_SETUP where DS_TYPE = '4' OR DS_TYPE = '4'  AND  NVL(DS_FRZ_FLAG ,'N') ='N'";
		}else{
			query = "SELECT DS_CODE,DS_DESC from PM_IL_DOC_SETUP where DS_TYPE = '4' OR DS_TYPE = '4'  AND  NVL(DS_FRZ_FLAG ,'N') ='N' AND DS_CODE LIKE('"+obj.toString()+"%')";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CLMAS_DOC_FM_TYPE_LOV lovBox = new CLMAS_DOC_FM_TYPE_LOV(); 
			lovBox.setDS_CODE(rs.getString("DS_CODE"));
			lovBox.setDS_DESC(rs.getString("DS_DESC"));
			lovList.add(lovBox);
		}
		rs.close();
		return lovList;
	}
	
	public List CLM_TYPE_FM_CODE_lovAction(Object obj) {
		List lovList = new ArrayList();
		if (obj.toString().equals("*")) {
			String query = "select PS_CODE,PS_CODE_DESC from PP_SYSTEM where PS_TYPE = 'IL_CLM_TYP'";
			lovList = CLM_TYPE_FM_CODE_suggestionList(query);
		}
		return lovList;
	}

	public List CLM_TYPE_FM_CODE_suggestionList(String query) {
		Statement stmt = null;
		List list = new ArrayList();
		ResultSet rs;
		try {
			FacesContext fc = FacesContext.getCurrentInstance();
			ServletContext context = (ServletContext) fc.getExternalContext().getContext();
			connection = CommonUtils.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				CLM_TYPE_FM_CODE_LOV lovBox = new CLM_TYPE_FM_CODE_LOV(); 
				lovBox.setPS_CODE(rs.getString("PS_CODE"));
				lovBox.setPS_CODE_DESC(rs.getString("PS_CODE_DESC"));
				list.add(lovBox);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List CLMAS_PROD_CODE_FM_lovAction(Object obj) {
		List lovList = new ArrayList();
		if (obj.toString().equals("*")) {
			String query = "select PROD_CODE,PROD_DESC from PM_IL_PRODUCT where PROD_CODE IS NOT NULL";
			lovList = CLMAS_PROD_CODE_FM_suggestionList(query);
		}
		return lovList;
	}

	public List CLMAS_PROD_CODE_FM_suggestionList(String query) {
		Statement stmt = null;
		List list = new ArrayList();
		ResultSet rs;
		try {
			FacesContext fc = FacesContext.getCurrentInstance();
			ServletContext context = (ServletContext) fc.getExternalContext()
			.getContext();
			connection = CommonUtils.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				CLMAS_PROD_CODE_FM_LOV lovBox = new CLMAS_PROD_CODE_FM_LOV(); 
				lovBox.setPROD_CODE(rs.getString("PROD_CODE"));
				lovBox.setPROD_DESC(rs.getString("PROD_DESC"));
				list.add(lovBox);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List CLMAS_COVER_CODE_FM_lovAction(Object obj) {
		List lovList = new ArrayList();
		if (obj.toString().equals("*")) {
			String query = "select COVER_CODE,COVER_DESC from PM_IL_COVER where COVER_FRZ_FLAG='N'";
			lovList = CLMAS_COVER_CODE_FM_suggestionList(query);
		}
		return lovList;
	}

	public List CLMAS_COVER_CODE_FM_suggestionList(String query) {
		Statement stmt = null;
		List list = new ArrayList();
		ResultSet rs;
		try {
			FacesContext fc = FacesContext.getCurrentInstance();
			ServletContext context = (ServletContext) fc.getExternalContext()
			.getContext();
			connection = CommonUtils.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				CLMAS_COVER_CODE_FM_LOV lovBox = new CLMAS_COVER_CODE_FM_LOV(); 
				lovBox.setCOVER_CODE(rs.getString("COVER_CODE"));
				lovBox.setCOVER_DESC(rs.getString("COVER_DESC"));
				list.add(lovBox);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List CLMAS_CUST_CLS_FM_CODE_lovAction(Object obj)throws Exception {
		List lovList = new ArrayList();
		String query =null;
		if(obj.toString().equals("*")){
			query = "SELECT CCLAS_CODE,CCLAS_CLASS_DESC FROM PM_CUST_CLASS WHERE PM_CUST_CLASS.CCLAS_FRZ_FLAG = 'N'";
		}else{
			query = "SELECT CCLAS_CODE,CCLAS_CLASS_DESC FROM PM_CUST_CLASS WHERE PM_CUST_CLASS.CCLAS_FRZ_FLAG = 'N' AND CCLAS_CODE LIKE('"+obj.toString()+"%') AND ROWNUM<25 ";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while (rs.next()) {
			CLMAS_CUST_CLS_FM_CODE_LOV lovBox = new CLMAS_CUST_CLS_FM_CODE_LOV(); 
			lovBox.setCCLAS_CODE(rs.getString("CCLAS_CODE"));
			lovBox.setCCLAS_CLASS_DESC(rs.getString("CCLAS_CLASS_DESC"));
			lovList.add(lovBox);
		}
		rs.close();
		return lovList;
	}
	
	public List CLMAS_MAIN_ACNT_CODE_lovAction(Object obj)throws Exception {
		List lovList = new ArrayList();
		String query =null;
		if(obj.toString().equals("*")){
			query = "select MAIN_ACNT_CODE,MAIN_ACNT_NAME from FM_MAIN_ACCOUNT where NVL(MAIN_FRZ_FLAG,'N') = 'N' AND ROWNUM<25";
		}else{
			query = "select MAIN_ACNT_CODE,MAIN_ACNT_NAME from FM_MAIN_ACCOUNT where NVL(MAIN_FRZ_FLAG,'N') = 'N' AND MAIN_ACNT_CODE LIKE('"+obj.toString()+"%') AND ROWNUM<25 ";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){

			CLMAS_MAIN_ACNT_CODE_LOV lovBox = new CLMAS_MAIN_ACNT_CODE_LOV(); 
			lovBox.setMAIN_ACNT_CODE(rs.getString("MAIN_ACNT_CODE"));
			lovBox.setMAIN_ACNT_NAME(rs.getString("MAIN_ACNT_NAME"));
			lovList.add(lovBox);
		}
		rs.close();
		return lovList;
	}

	public List CLMAS_SUB_ACNT_CODE_lovAction(Object obj)throws Exception {
		List lovList = new ArrayList();
		String query =null;
		if(obj.toString().equals("*")){
			query =  "SELECT sub_acnt_code, sub_acnt_name FROM fm_sub_account WHERE SUB_ACNT_CODE IN (SELECT MS_SUB_ACNT_CODE " +
			" FROM  FM_MAIN_SUB WHERE MS_MAIN_ACNT_CODE = '"+COMP_CLMAS_MAIN_ACNT_CODE.getValue()+"') AND	NVL(SUB_FRZ_FLAG,'N') = 'N' AND ROWNUM<25";
		}else{
			query =  "SELECT sub_acnt_code, sub_acnt_name FROM fm_sub_account WHERE SUB_ACNT_CODE IN (SELECT MS_SUB_ACNT_CODE " +
			" FROM  FM_MAIN_SUB WHERE MS_MAIN_ACNT_CODE = '"+COMP_CLMAS_MAIN_ACNT_CODE.getValue()+"') AND	NVL(SUB_FRZ_FLAG,'N') = 'N' AND sub_acnt_code LIKE('"+obj.toString()+"%') AND ROWNUM<25";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){

			CLMAS_SUB_ACNT_CODE_LOV lovBox = new CLMAS_SUB_ACNT_CODE_LOV(); 
			lovBox.setSUB_ACNT_CODE(rs.getString("SUB_ACNT_CODE"));
			lovBox.setSUB_ACNT_NAME(rs.getString("SUB_ACNT_NAME"));
			lovList.add(lovBox);
		}
		rs.close();
		return lovList;
	}
	
	public List CLMAS_DIV_COMP_CODE_lovAction(Object obj)throws Exception {
		List lovList = new ArrayList();
		String query =null;
		if(obj.toString().equals("*")){
			query =  "select DIVN_CODE,DIVN_NAME from PM_DIVISION where DIVN_COMP_CODE = '001' AND " +
			" NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DIVN_CODE" +
			" AND ADS_USER_ID = ADS_USER_ID AND ADS_FRZ_FLAG = 'N')";
		}else{
			query =  "select DIVN_CODE,DIVN_NAME from PM_DIVISION where DIVN_COMP_CODE = '001' AND " +
			" NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DIVN_CODE" +
			" AND ADS_USER_ID = ADS_USER_ID AND ADS_FRZ_FLAG = 'N') AND DIVN_CODE LIKE('"+obj.toString()+"%') ";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CLMAS_DIVN_FM_CODE_LOV lovBox = new CLMAS_DIVN_FM_CODE_LOV(); 
			lovBox.setDIVN_CODE(rs.getString("DIVN_CODE"));
			lovBox.setDIVN_NAME(rs.getString("DIVN_NAME"));
			lovList.add(lovBox);
		}
		rs.close();
		return lovList;
	}

	public List CLMAS_DEPT_COMP_CODE_lovAction(Object obj)throws Exception {
		List lovList = new ArrayList();
		String query =null;
		if(obj.toString().equals("*")){
			//[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DEPARTMENT to FM_DEPARTMENT. Added by : Shankar.B 31-Mar-2009
			query =  "SELECT DEPT_CODE,DEPT_NAME from FM_DEPARTMENT WHERE DEPT_COMP_CODE = '001' AND DEPT_DIVN_CODE = '"+ PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DIVN_CODE()+"' AND" +
			" DEPT_FRZ_FLAG  = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DEPT_DIVN_CODE AND" +
			" ADS_DEPT_CODE = DEPT_CODE AND ADS_USER_ID = ADS_USER_ID AND ADS_FRZ_FLAG = 'N')";
		}else{
			//[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DEPARTMENT to FM_DEPARTMENT. Added by : Shankar.B 31-Mar-2009
			query =  "SELECT DEPT_CODE,DEPT_NAME from FM_DEPARTMENT WHERE DEPT_COMP_CODE = '001' AND DEPT_DIVN_CODE = '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DIVN_CODE()+"' AND" +
			" DEPT_FRZ_FLAG  = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DEPT_DIVN_CODE AND" +
			" ADS_DEPT_CODE = DEPT_CODE AND ADS_USER_ID = ADS_USER_ID AND ADS_FRZ_FLAG = 'N') AND DEPT_CODE LIKE('"+obj.toString()+"%') ";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CLMAS_DEPT_CODE_LOV lovBox = new CLMAS_DEPT_CODE_LOV(); 
			lovBox.setDEPT_CODE(rs.getString("DEPT_CODE"));
			lovBox.setDEPT_NAME(rs.getString("DEPT_NAME"));
			lovList.add(lovBox);
		}
		rs.close();
		return lovList;
	}

	public List CLMAS_FM_ANALYSIS1_lovAction(Object obj)throws Exception {
		List lovList = new ArrayList();
		String query =null;
		if(obj.toString().equals("*")){
			query = "select ANLY_CODE,ANLY_NAME from FM_ANALYSIS where ANLY_HEAD_NO = '1' AND NVL(ANLY_FRZ_FLAG,'N') = 'N'";
		}else{
			query = "select ANLY_CODE,ANLY_NAME from FM_ANALYSIS where ANLY_HEAD_NO = '1' AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND ANLY_CODE LIKE('"+obj.toString()+"%') ";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CLMAS_FM_ANALYSIS_LOV lovBox = new CLMAS_FM_ANALYSIS_LOV(); 
			lovBox.setANLY_CODE(rs.getString("ANLY_CODE"));
			lovBox.setANLY_NAME(rs.getString("ANLY_NAME"));
			lovList.add(lovBox);
		}
		rs.close();
		return lovList;
	}
	
	
	public List CLMAS_FM_ANALYSIS2_lovAction(Object obj)throws Exception {
		List lovList = new ArrayList();
		String query =null;
		if(obj.toString().equals("*")){
			query = "select ANLY_CODE,ANLY_NAME from FM_ANALYSIS where ANLY_HEAD_NO = '2' AND NVL(ANLY_FRZ_FLAG,'N') = 'N'";
		}else{
			query = "select ANLY_CODE,ANLY_NAME from FM_ANALYSIS where ANLY_HEAD_NO = '2' AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND ANLY_CODE LIKE('"+obj.toString()+"%') ";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CLMAS_FM_ANALYSIS_LOV lovBox = new CLMAS_FM_ANALYSIS_LOV(); 
			lovBox.setANLY_CODE(rs.getString("ANLY_CODE"));
			lovBox.setANLY_NAME(rs.getString("ANLY_NAME"));
			lovList.add(lovBox);
		}
		rs.close();
		return lovList;
	}
	
	public List CLMAS_ACTY_CODE_lovAction(Object obj)throws Exception {
		List lovList = new ArrayList();
		String query =null;
		if(obj.toString().equals("*")){
			query = "select AVAL_CODE,AVAL_VALUE_NAME from FM_ACTY_VALUE WHERE ROWNUM <20 ";
		}else{
			query = "select AVAL_CODE,AVAL_VALUE_NAME from FM_ACTY_VALUE WHERE AVAL_CODE LIKE('"+obj.toString()+"%') AND ROWNUM<20 ";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CLMAS_ACTY_CODE_LOV lovBox = new CLMAS_ACTY_CODE_LOV(); 
			lovBox.setAVAL_CODE(rs.getString("AVAL_CODE"));
			lovBox.setAVAL_VALUE_NAME(rs.getString("AVAL_VALUE_NAME"));
			lovList.add(lovBox);
		}
		rs.close();
		return lovList;
	}

	public String WHEN_VALIDATE_CLMAS_SRC_BUS_FM(ActionEvent ae)
	{
		if("".equals(getCOMP_CLMAS_SRC_BUS_FM().getSubmittedValue().toString().trim())){
			getCOMP_CLMAS_SRC_BUS_FM().setSubmittedValue("0");
			getCOMP_CLMAS_SRC_BUS_FM().updateModel(FacesContext.getCurrentInstance());
		}else{
			UIInput input = (UIInput) ae.getComponent().getParent(); // Ajax4jsf comp
			ErrorHelpUtil.validate(input, getErrorMap());
		}
		return "";
	}


	public void WHEN_VALIDATE_CLMAS_SRC_BUS_TO(ActionEvent ae)
	{
		if(COMP_CLMAS_SRC_BUS_TO.getSubmittedValue().toString().isEmpty())
		{
			if(COMP_CLMAS_SRC_BUS_FM.getSubmittedValue().toString().equals("0"))
			{
				if(P_SET_SECOND_FIELD(getCOMP_CLMAS_SRC_BUS_FM(),getCOMP_CLMAS_SRC_BUS_TO()))
					L_VAL_FROM_TO(getCOMP_CLMAS_SRC_BUS_FM(),getCOMP_CLMAS_SRC_BUS_TO());
			}else{
					COMP_CLMAS_SRC_BUS_TO.setSubmittedValue(COMP_CLMAS_SRC_BUS_FM.getSubmittedValue());
			}
		}
	}

	public void WHEN_VALIDATE_CLMAS_BUS_FM_CODE(ActionEvent ae){
		if("".equals(((String)getCOMP_CLMAS_BUS_FM_CODE().getSubmittedValue()).trim()) || getCOMP_CLMAS_BUS_FM_CODE().getSubmittedValue() == null){
			getCOMP_CLMAS_BUS_FM_CODE().setSubmittedValue("0");
			getCOMP_CLMAS_BUS_FM_CODE().updateModel(FacesContext.getCurrentInstance());
		}else{
				UIInput input = (UIInput) ae.getComponent().getParent(); // Ajax4jsf comp
				ErrorHelpUtil.validate(input, getErrorMap());
			}
	}

	public void WHEN_VALIDATE_CLMAS_BUS_TO_CODE(ActionEvent ae){
		if(COMP_CLMAS_BUS_TO_CODE.getSubmittedValue().toString().isEmpty())
		{
			if(COMP_CLMAS_BUS_FM_CODE.getSubmittedValue().toString().equals("0"))
			{
				if(P_SET_SECOND_FIELD(getCOMP_CLMAS_BUS_FM_CODE(),getCOMP_CLMAS_BUS_TO_CODE()))
					L_VAL_FROM_TO(getCOMP_CLMAS_BUS_FM_CODE(),getCOMP_CLMAS_BUS_TO_CODE());
			}else{
				COMP_CLMAS_BUS_TO_CODE.setSubmittedValue(COMP_CLMAS_BUS_FM_CODE.getSubmittedValue());
			}
		}
	}

	public void WHEN_VALIDATE_CLMAS_DIVN_FM_CODE(ActionEvent ae){
		if("".equals(((String)getCOMP_CLMAS_DIVN_FM_CODE().getSubmittedValue()).trim()) || getCOMP_CLMAS_DIVN_FM_CODE().getSubmittedValue() == null){
			getCOMP_CLMAS_DIVN_FM_CODE().setSubmittedValue("0");
			getCOMP_CLMAS_DIVN_FM_CODE().updateModel(FacesContext.getCurrentInstance());
		}else{
			UIInput input = (UIInput) ae.getComponent().getParent(); // Ajax4jsf comp
			ErrorHelpUtil.validate(input, getErrorMap());
		}
	}

	public void WHEN_VALIDATE_CLMAS_DIVN_TO_CODE(ActionEvent ae){
		if(COMP_CLMAS_DIVN_TO_CODE.getSubmittedValue().toString().isEmpty())
		{
			if(COMP_CLMAS_DIVN_FM_CODE.getSubmittedValue().toString().equals("0"))
			{
				if(P_SET_SECOND_FIELD(getCOMP_CLMAS_DIVN_FM_CODE(),getCOMP_CLMAS_DIVN_TO_CODE()))
					L_VAL_FROM_TO(getCOMP_CLMAS_DIVN_FM_CODE(),getCOMP_CLMAS_DIVN_TO_CODE());
			}else{
				COMP_CLMAS_DIVN_TO_CODE.setSubmittedValue(COMP_CLMAS_DIVN_FM_CODE.getSubmittedValue());
			}
		}
	}

	public void WHEN_VALIDATE_CLMAS_DEPT_FM_CODE(ActionEvent ae){
		if("".equals(((String)getCOMP_CLMAS_DEPT_FM_CODE().getSubmittedValue()).trim()) || getCOMP_CLMAS_DEPT_FM_CODE().getSubmittedValue() == null){
			getCOMP_CLMAS_DEPT_FM_CODE().setSubmittedValue("0");
			getCOMP_CLMAS_DEPT_FM_CODE().updateModel(FacesContext.getCurrentInstance());
		}else{
			UIInput input = (UIInput) ae.getComponent().getParent(); // Ajax4jsf comp
			ErrorHelpUtil.validate(input, getErrorMap());
		}
	}

	public void WHEN_VALIDATE_CLMAS_DEPT_TO_CODE(ActionEvent ae){
		if(COMP_CLMAS_DEPT_TO_CODE.getSubmittedValue().toString().isEmpty())
		{
			if(COMP_CLMAS_DEPT_FM_CODE.getSubmittedValue().toString().equals("0"))
			{
				if(P_SET_SECOND_FIELD(getCOMP_CLMAS_DEPT_FM_CODE(),getCOMP_CLMAS_DEPT_TO_CODE()))
					L_VAL_FROM_TO(getCOMP_CLMAS_DEPT_FM_CODE(),getCOMP_CLMAS_DEPT_TO_CODE());
			}else{
				COMP_CLMAS_DEPT_TO_CODE.setSubmittedValue(COMP_CLMAS_DEPT_FM_CODE.getSubmittedValue());
			}
		}
	}

	public void WHEN_VALIDATE_CLMAS_DOC_FM_TYPE(ActionEvent ae){
		if("".equals(((String)getCOMP_CLMAS_DOC_FM_TYPE().getSubmittedValue()).trim()) || getCOMP_CLMAS_DOC_FM_TYPE().getSubmittedValue() == null){
			getCOMP_CLMAS_DOC_FM_TYPE().setSubmittedValue("0");
			getCOMP_CLMAS_DOC_FM_TYPE().updateModel(FacesContext.getCurrentInstance());
		}else{
			UIInput input = (UIInput) ae.getComponent().getParent(); // Ajax4jsf comp
			ErrorHelpUtil.validate(input, getErrorMap());
		}
	}

	public void WHEN_VALIDATE_CLMAS_DOC_TO_TYPE(ActionEvent ae){
		if(COMP_CLMAS_DOC_TO_TYPE.getSubmittedValue().toString().isEmpty())
		{
			if(COMP_CLMAS_DOC_FM_TYPE.getSubmittedValue().toString().equals("0"))
			{
				if(P_SET_SECOND_FIELD(getCOMP_CLMAS_DOC_FM_TYPE(),getCOMP_CLMAS_DOC_TO_TYPE()))
					L_VAL_FROM_TO(getCOMP_CLMAS_DOC_FM_TYPE(),getCOMP_CLMAS_DOC_TO_TYPE());
			}else{
				COMP_CLMAS_DOC_TO_TYPE.setSubmittedValue(COMP_CLMAS_DOC_FM_TYPE.getSubmittedValue());
			}
		}
	}

	public void WHEN_VALIDATE_CLMAS_CLM_TYPE_FM_CODE(ActionEvent ae){
		if("".equals(((String)getCOMP_CLMAS_CLM_TYPE_FM_CODE().getSubmittedValue()).trim()) || getCOMP_CLMAS_CLM_TYPE_FM_CODE().getSubmittedValue() == null){
			getCOMP_CLMAS_CLM_TYPE_FM_CODE().setSubmittedValue("0");
			getCOMP_CLMAS_CLM_TYPE_FM_CODE().updateModel(FacesContext.getCurrentInstance());
		}
	}

	public void WHEN_VALIDATE_CLMAS_CLM_TYPE_TO_CODE(ActionEvent ae){
		if(COMP_CLMAS_CLM_TYPE_TO_CODE.getSubmittedValue().toString().isEmpty())
		{
			if(COMP_CLMAS_CLM_TYPE_FM_CODE.getSubmittedValue().toString().equals("0"))
			{
				if(P_SET_SECOND_FIELD(getCOMP_CLMAS_CLM_TYPE_FM_CODE(),getCOMP_CLMAS_CLM_TYPE_TO_CODE()))
					L_VAL_FROM_TO(getCOMP_CLMAS_CLM_TYPE_FM_CODE(),getCOMP_CLMAS_CLM_TYPE_TO_CODE());
			}else{
				COMP_CLMAS_CLM_TYPE_TO_CODE.setSubmittedValue(COMP_CLMAS_CLM_TYPE_FM_CODE.getSubmittedValue());
			}
		}
	}

	public void WHEN_VALIDATE_CLMAS_PROD_CODE_FM(ActionEvent ae){
		if("".equals(((String)getCOMP_CLMAS_PROD_CODE_FM().getSubmittedValue()).trim()) || getCOMP_CLMAS_PROD_CODE_FM().getSubmittedValue() == null){
			getCOMP_CLMAS_PROD_CODE_FM().setSubmittedValue("0");
			getCOMP_CLMAS_PROD_CODE_FM().updateModel(FacesContext.getCurrentInstance());
		}
	}

	public void WHEN_VALIDATE_CLMAS_PROD_CODE_TO(ActionEvent ae){
		if(COMP_CLMAS_PROD_CODE_TO.getSubmittedValue().toString().isEmpty())
		{
			if(COMP_CLMAS_PROD_CODE_FM.getSubmittedValue().toString().equals("0"))
			{
				if(P_SET_SECOND_FIELD(getCOMP_CLMAS_PROD_CODE_FM(),getCOMP_CLMAS_PROD_CODE_TO()))
					L_VAL_FROM_TO(getCOMP_CLMAS_PROD_CODE_FM(),getCOMP_CLMAS_PROD_CODE_TO());
			}else{
				COMP_CLMAS_PROD_CODE_TO.setSubmittedValue(COMP_CLMAS_PROD_CODE_FM.getSubmittedValue());
			}
		}
	}

	public void WHEN_VALIDATE_CLMAS_COVER_CODE_FM(ActionEvent ae){
		if("".equals(((String)getCOMP_CLMAS_COVER_CODE_FM().getSubmittedValue()).trim()) || getCOMP_CLMAS_COVER_CODE_FM().getSubmittedValue() == null){
			getCOMP_CLMAS_COVER_CODE_FM().setSubmittedValue("0");
			getCOMP_CLMAS_COVER_CODE_FM().updateModel(FacesContext.getCurrentInstance());
		}
	}

	public void WHEN_VALIDATE_CLMAS_COVER_CODE_TO(ActionEvent ae){
		if(COMP_CLMAS_COVER_CODE_TO.getSubmittedValue().toString().isEmpty())
		{
			if(COMP_CLMAS_COVER_CODE_FM.getSubmittedValue().toString().equals("0"))
			{
				if(P_SET_SECOND_FIELD(getCOMP_CLMAS_COVER_CODE_FM(),getCOMP_CLMAS_COVER_CODE_TO()))
					L_VAL_FROM_TO(getCOMP_CLMAS_COVER_CODE_FM(),getCOMP_CLMAS_COVER_CODE_TO());
			}else{
				COMP_CLMAS_COVER_CODE_TO.setSubmittedValue(COMP_CLMAS_COVER_CODE_FM.getSubmittedValue());
			}
		}
	}

	public void WHEN_VALIDATE_CLMAS_CUST_CLS_FM_CODE(ActionEvent ae){
		if("".equals(((String)getCOMP_CLMAS_CUST_CLS_FM_CODE().getSubmittedValue()).trim()) || getCOMP_CLMAS_CUST_CLS_FM_CODE().getSubmittedValue() == null){
			getCOMP_CLMAS_CUST_CLS_FM_CODE().setSubmittedValue("0");
			getCOMP_CLMAS_CUST_CLS_FM_CODE().updateModel(FacesContext.getCurrentInstance());
		}
	}

	public void WHEN_VALIDATE_CLMAS_CUST_CLS_TO_CODE(ActionEvent ae){
		if(COMP_CLMAS_CUST_CLS_TO_CODE.getSubmittedValue().toString().isEmpty())
		{
			if(COMP_CLMAS_CUST_CLS_FM_CODE.getSubmittedValue().toString().equals("0"))
			{
				if(P_SET_SECOND_FIELD(getCOMP_CLMAS_CUST_CLS_FM_CODE(),getCOMP_CLMAS_CUST_CLS_TO_CODE()))
					L_VAL_FROM_TO(getCOMP_CLMAS_CUST_CLS_FM_CODE(),getCOMP_CLMAS_CUST_CLS_TO_CODE());
			}else{
				COMP_CLMAS_CUST_CLS_TO_CODE.setSubmittedValue(COMP_CLMAS_CUST_CLS_FM_CODE.getSubmittedValue());
			}
		}
	}

	public boolean P_SET_SECOND_FIELD(HtmlInputText fromText,HtmlInputText toText){
		boolean status = true;
		if("".equals(toText.getSubmittedValue().toString().trim())){
			if(fromText.getSubmittedValue().toString().equals("0") && "".equals(toText.getSubmittedValue().toString().trim())){
				toText.setSubmittedValue("zzzzzz");
				toText.updateModel(FacesContext.getCurrentInstance());
				status = false;
			}
		}else{
			if((fromText.getSubmittedValue().toString().compareTo(toText.getSubmittedValue().toString()) > 0)){
				errMsg = STD_MESSAGE_ROUTINE("ENG","10064");
				System.out.println("Error Message :::::::::::::::::: "+errMsg);
				status = false;
			}
		}
		return status;
	}

	public void L_VAL_FROM_TO(HtmlInputText fromText,HtmlInputText toText){
		if("".equals(fromText.getSubmittedValue().toString().trim())){
			errMsg = STD_MESSAGE_ROUTINE("ENG","80033");
		}else {
			try{
				if(Integer.parseInt(toText.getSubmittedValue().toString().trim()) < Integer.parseInt(fromText.getSubmittedValue().toString().trim())){
					errMsg = STD_MESSAGE_ROUTINE("ENG","80034");
				}
			}catch(NumberFormatException e){
				if((toText.getSubmittedValue().toString().trim().compareTo(fromText.getSubmittedValue().toString().trim()) < 0)){
					errMsg = STD_MESSAGE_ROUTINE("ENG","80034");
					getErrorMap().put("current", errMsg);
				}
			}
		}
	}
	
	public String STD_MESSAGE_ROUTINE(String P_LANG_CODE,String errorCode){
		try {
			String query = "SELECT DECODE('"+P_LANG_CODE+"', 'ENG', EM_ENG_MSG, EM_FOR_MSG),EM_ERR_FLAG FROM PP_ERROR_MESSAGE WHERE EM_ERR_NO = '"+errorCode+"'";
			ResultSet resultSet = handler.executeSelectStatement(query, CommonUtils.getConnection());
			while(resultSet.next()){
				errMsg = resultSet.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return errMsg;
	}

	public List<SelectItem> getUI_M_CLAIM_SETUP_LIST() {
		if (UI_M_CLAIM_SETUP_LIST.size() ==0)
		  { 
			UI_M_CLAIM_SETUP_LIST.clear();
			UI_M_CLAIM_SETUP_LIST = ListItemUtil.getDropDownListValue(getConnection(),"PILM024","PM_IL_CLM_ACCOUNT_SETUP","PM_IL_CLM_ACCOUNT_SETUP.CLMAS_TYPE","CLMASTYP");
			
		  }
		return UI_M_CLAIM_SETUP_LIST;
	}

	public void setUI_M_CLAIM_SETUP_LIST(List<SelectItem> ui_m_claim_setup_list) {
		UI_M_CLAIM_SETUP_LIST = ui_m_claim_setup_list;
	}

	public List<SelectItem> getCLMAS_FORCE_DIVN_YN_LIST() {
		if (CLMAS_FORCE_DIVN_YN_LIST.size() ==0)
		  { 
			CLMAS_FORCE_DIVN_YN_LIST.clear();
			CLMAS_FORCE_DIVN_YN_LIST = ListItemUtil.getDropDownListValue(getConnection(),"PILM024","PM_IL_CLM_ACCOUNT_SETUP","PM_IL_CLM_ACCOUNT_SETUP.CLMAS_FORCE_DIVN_YN","YESNO");
		  }
		return CLMAS_FORCE_DIVN_YN_LIST;
	}

	public void setCLMAS_FORCE_DIVN_YN_LIST(
			List<SelectItem> clmas_force_divn_yn_list) {
		CLMAS_FORCE_DIVN_YN_LIST = clmas_force_divn_yn_list;
	}

	public List<SelectItem> getCLMAS_FORCE_DEPT_YN_LIST() {
		if (CLMAS_FORCE_DEPT_YN_LIST.size() ==0)
		  { 
			CLMAS_FORCE_DEPT_YN_LIST.clear();
			CLMAS_FORCE_DEPT_YN_LIST = ListItemUtil.getDropDownListValue(getConnection(),"PILM024","PM_IL_CLM_ACCOUNT_SETUP","PM_IL_CLM_ACCOUNT_SETUP.CLMAS_FORCE_DEPT_YN","YESNO");
		  }
		return CLMAS_FORCE_DEPT_YN_LIST;
	}

	public void setCLMAS_FORCE_DEPT_YN_LIST(
			List<SelectItem> clmas_force_dept_yn_list) {
		CLMAS_FORCE_DEPT_YN_LIST = clmas_force_dept_yn_list;
	}

	public List<SelectItem> getCLMAS_ASSURED_TYPE_LIST() {
		if (CLMAS_ASSURED_TYPE_LIST.size() ==0)
		  { 
			CLMAS_ASSURED_TYPE_LIST.clear();
			CLMAS_ASSURED_TYPE_LIST = ListItemUtil.getDropDownListValue(getConnection(),"PILM024","PM_IL_CLM_ACCOUNT_SETUP","PM_IL_CLM_ACCOUNT_SETUP.CLMAS_ASSURED_TYPE","ASSRTYPE");
		  }
		return CLMAS_ASSURED_TYPE_LIST;
	}

	public void setCLMAS_ASSURED_TYPE_LIST(List<SelectItem> clmas_assured_type_list) {
		CLMAS_ASSURED_TYPE_LIST = clmas_assured_type_list;
	}

	public void shortName(ActionEvent e)
	{
		UIInput input = (UIInput) e.getComponent() // Ajax4jsf comp
		.getParent(); 
		System.out.println("PM_IL_CLM_SETUP>>>>.shortName()"+input.getSubmittedValue());
		ErrorHelpUtil.validate(input, input.getId(), getErrorMap());
	}
	
	public void validateNullValues(ActionEvent ae)
	{
		UIInput input = (UIInput) ae.getComponent() // Ajax4jsf comp
				.getParent(); 
		ErrorHelpUtil.validate(input, input.getId(), getErrorMap());
	}

	public Connection getConnection(){
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
		} catch (DBException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void L_SET_SUB_ACCOUNT() throws SQLException,Exception
    {
        connection = CommonUtils.getConnection();
        try
        {
            String sql_C1="SELECT    MAIN_CTL_ACNT_FLAG,    MAIN_ACTY_CODE_1,    MAIN_ACTY_CODE_2 FROM  FM_MAIN_ACCOUNT  WHERE  MAIN_ACNT_CODE  = '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_MAIN_ACNT_CODE()+"'";
            ResultSet rs=null;
            Statement stmt_C1=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String M_FLAG=null;
            String M_ACTY_HEAD_1=null;
            String M_ACTY_HEAD_2=null;
            rs=stmt_C1.executeQuery(sql_C1);
            if(rs.next())
            {
                M_FLAG=rs.getString(1);
                M_ACTY_HEAD_1=rs.getString(2);
                M_ACTY_HEAD_2=rs.getString(3);
            }
            if(rs.isAfterLast() || rs.isBeforeFirst())
            {
                M_FLAG="X";
            }
            rs.close();
            if(!("C".equalsIgnoreCase(M_FLAG)))
            {
            	COMP_CLMAS_SUB_ACNT_CODE.setRequired(false);
                COMP_CLMAS_SUB_ACNT_CODE.setReadonly(true);
            }
            else
            {
            	COMP_CLMAS_SUB_ACNT_CODE.setRequired(true);
                COMP_CLMAS_SUB_ACNT_CODE.setReadonly(false);
            }
            if(M_ACTY_HEAD_1== null)
            {
            	COMP_CLMAS_ACTY_CODE_1.setRequired(false);
                COMP_CLMAS_ACTY_CODE_1.setReadonly(true);
            }
            else
            {
            	COMP_CLMAS_ACTY_CODE_1.setRequired(true);
                COMP_CLMAS_ACTY_CODE_1.setReadonly(false);
            }
            if(M_ACTY_HEAD_2== null)
            {
            	COMP_CLMAS_ACTY_CODE_2.setRequired(false);
                COMP_CLMAS_ACTY_CODE_2.setReadonly(true);
            }
            else
            {
            	COMP_CLMAS_ACTY_CODE_2.setRequired(true);
                COMP_CLMAS_ACTY_CODE_2.setReadonly(false);
            }
            
            
            DUMMY_BEAN.setM_ACTY_HEAD_1(M_ACTY_HEAD_1);
            DUMMY_BEAN.setM_ACTY_HEAD_2(M_ACTY_HEAD_2);
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }
	
	//PRE-INSERT
	public void pilm024_pm_il_clm_account_setup_pre_insert()throws ValidatorException
    {
       
            PM_IL_CLM_ACCOUNT_SETUP_BEAN.setCLMAS_CR_UID(ctrlBean.getM_USER_ID());
            PM_IL_CLM_ACCOUNT_SETUP_BEAN.setCLMAS_CR_DT(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            String M_DUMMY =  L_OVERLAP_CHECK();
	           if(M_DUMMY!=null)
	           {
	        	   throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"80031"));
	           }
       
    }
	
	public void pilm024_pm_il_clm_account_setup_pre_block() throws SQLException,Exception
    {
		connection = CommonUtils.getConnection();
        try
        {
        	ctrlBean.setM_DELETE_MSG_FLAG("Y");
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }
	
	//PREUPDATE
	public void pilm024_pm_il_clm_account_setup_pre_update() throws SQLException,Exception
    {
		System.out.println("pilm024_pm_il_clm_account_setup_pre_update");
		connection = CommonUtils.getConnection();
       try
        {
            //final dbms_output dbms_output1=new dbms_output();
           /* String sql_C1="SELECT 'X' FROM  PM_IL_CLM_ACCOUNT_SETUP  WHERE  ('"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_BUS_FM_CODE()+"' BETWEEN CLMAS_BUS_FM_CODE  AND  CLMAS_BUS_TO_CODE  " +
            " OR '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_BUS_TO_CODE()+"' BETWEEN CLMAS_BUS_FM_CODE  AND  CLMAS_BUS_TO_CODE  OR CLMAS_BUS_FM_CODE " +
            " BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_BUS_FM_CODE()+"'  AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_BUS_TO_CODE()+"' OR CLMAS_BUS_TO_CODE " +
            " BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_BUS_FM_CODE()+"' AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_BUS_TO_CODE()+"')  " +
            " AND ('"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DIVN_FM_CODE()+"' BETWEEN CLMAS_DIVN_FM_CODE  AND  CLMAS_DIVN_TO_CODE " +
            " OR '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DIVN_TO_CODE()+"' BETWEEN CLMAS_DIVN_FM_CODE  AND  CLMAS_DIVN_TO_CODE  OR CLMAS_DIVN_FM_CODE " +
            " BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DIVN_FM_CODE()+"' AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DIVN_TO_CODE()+"' OR CLMAS_DIVN_TO_CODE " +
            " BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DIVN_FM_CODE()+"'  AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DIVN_TO_CODE()+"') " +
            " AND ('"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DEPT_FM_CODE()+"' BETWEEN CLMAS_DEPT_FM_CODE  AND  CLMAS_DEPT_TO_CODE  OR '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DEPT_TO_CODE()+"' " +
            " BETWEEN CLMAS_DEPT_FM_CODE  AND  CLMAS_DEPT_TO_CODE  OR CLMAS_DEPT_FM_CODE  BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DEPT_FM_CODE()+"' " +
            " AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DEPT_TO_CODE()+"'  OR CLMAS_DEPT_TO_CODE  BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DEPT_FM_CODE()+"' AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DEPT_TO_CODE()+"') " +
            " AND ('"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DOC_FM_TYPE()+"' BETWEEN CLMAS_DOC_FM_TYPE  AND  CLMAS_DOC_TO_TYPE  OR '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DOC_TO_TYPE()+"' BETWEEN CLMAS_DOC_FM_TYPE  AND  CLMAS_DOC_TO_TYPE " +
            " OR CLMAS_DOC_FM_TYPE  BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DOC_FM_TYPE()+"'  AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DOC_TO_TYPE()+"' OR CLMAS_DOC_TO_TYPE " +
            " BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DOC_FM_TYPE()+"' AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DOC_TO_TYPE()+"') " +
            " AND ('"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_CLM_TYPE_FM_CODE()+"' BETWEEN CLMAS_CLM_TYPE_FM_CODE  AND  CLMAS_CLM_TYPE_TO_CODE  OR '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_CLM_TYPE_TO_CODE()+"' BETWEEN CLMAS_CLM_TYPE_FM_CODE " +
            " AND  CLMAS_CLM_TYPE_TO_CODE  OR CLMAS_CLM_TYPE_FM_CODE  BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_CLM_TYPE_FM_CODE()+"' AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_CLM_TYPE_TO_CODE()+"' OR CLMAS_CLM_TYPE_TO_CODE  BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_CLM_TYPE_FM_CODE()+"' " +
            " AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_CLM_TYPE_TO_CODE()+"')  AND ('"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_SRC_BUS_FM()+"' BETWEEN CLMAS_SRC_BUS_FM  AND  CLMAS_SRC_BUS_TO " +
            " OR '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_SRC_BUS_TO()+"' BETWEEN CLMAS_SRC_BUS_FM  AND  CLMAS_SRC_BUS_TO  OR CLMAS_SRC_BUS_FM  BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_SRC_BUS_FM()+"' AND " +
            " '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_SRC_BUS_TO()+"' OR CLMAS_DIVN_TO_CODE  BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_SRC_BUS_FM()+"' AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_SRC_BUS_TO()+"') " +
            " AND ('"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_PROD_CODE_FM()+"' BETWEEN CLMAS_PROD_CODE_FM  AND  CLMAS_PROD_CODE_TO  OR '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_PROD_CODE_TO()+"'  BETWEEN CLMAS_PROD_CODE_FM " +
            " AND  CLMAS_PROD_CODE_TO  OR CLMAS_PROD_CODE_FM  BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_PROD_CODE_FM()+"' AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_PROD_CODE_TO()+"' OR CLMAS_PROD_CODE_TO " +
            " BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_PROD_CODE_FM()+"' AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_PROD_CODE_TO()+"' AND ('"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_COVER_CODE_FM()+"' BETWEEN CLMAS_COVER_CODE_FM " +
            " AND  CLMAS_COVER_CODE_TO  OR '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_COVER_CODE_TO()+"' BETWEEN CLMAS_COVER_CODE_FM  AND  CLMAS_COVER_CODE_TO  OR CLMAS_COVER_CODE_FM " +
            " BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_COVER_CODE_FM()+"' AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_COVER_CODE_TO()+"' OR CLMAS_COVER_CODE_TO " +
            " BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_COVER_CODE_FM()+"' AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_COVER_CODE_TO()+"')  AND ('"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_CUST_CLS_FM_CODE()+"' " +
            " BETWEEN CLMAS_CUST_CLS_FM_CODE  AND  CLMAS_CUST_CLS_TO_CODE  OR '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_CUST_CLS_TO_CODE()+"' BETWEEN CLMAS_CUST_CLS_FM_CODE  AND  CLMAS_CUST_CLS_TO_CODE  OR CLMAS_CUST_CLS_FM_CODE " +
            " BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_CUST_CLS_FM_CODE()+"' AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_CUST_CLS_TO_CODE()+"' OR CLMAS_CUST_CLS_TO_CODE  BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_CUST_CLS_FM_CODE()+"' AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_CUST_CLS_TO_CODE()+"') " +
            " AND ('"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_TYPE()+"' = CLMAS_TYPE  OR CLMAS_TYPE  = '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_TYPE()+"')  AND CLMAS_ASSURED_TYPE  = '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_ASSURED_TYPE()+"' AND ROWID  != '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getROWID()+"'";
            ResultSet rs=null;
            Statement stmt_C1=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String M_DUMMY=null;*/
            
            PM_IL_CLM_ACCOUNT_SETUP_BEAN.setCLMAS_UPD_UID(ctrlBean.getM_USER_ID());
            PM_IL_CLM_ACCOUNT_SETUP_BEAN.setCLMAS_UPD_DT(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            //rs=stmt_C1.executeQuery(sql_C1);
            //System.out.println("QUERY :::::"+sql_C1);
            /*if(rs.next())
            {
                //M_DUMMY=rs.getString(1);
            }
            if(!rs.isLast())
            {
                //STD_MESSAGE_ROUTINE(80031,ctrlBean.getM_LANG_CODE());
                throw new Exception();
            }
            rs.close();*/
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }
	
	//WHEN-CREATE-RECORD
	
	 public void pilm024_pm_il_clm_account_setup_when_create_record() throws SQLException,Exception
	    {
		 connection = CommonUtils.getConnection();
	        try
	        {
	            //final dbms_output dbms_output1=new dbms_output();
	            PM_IL_CLM_ACCOUNT_SETUP_BEAN.setCLMAS_TYPE("C");
	            PM_IL_CLM_ACCOUNT_SETUP_BEAN.setCLMAS_FORCE_DIVN_YN("N");
	            PM_IL_CLM_ACCOUNT_SETUP_BEAN.setCLMAS_FORCE_DEPT_YN("N");
	            PM_IL_CLM_ACCOUNT_SETUP_BEAN.setCLMAS_ASSURED_TYPE("R");
	            COMP_CLMAS_DIVN_CODE.setRequired(true);
	            COMP_CLMAS_DEPT_CODE.setRequired(true);
	            COMP_CLMAS_FORCE_DEPT_YN.setDisabled(true);
	            //SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_CLM_ACCOUNT_SETUP.CLMAS_DIVN_CODE",REQUIRED,PROPERTY_TRUE);
	            //SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_CLM_ACCOUNT_SETUP.CLMAS_DEPT_CODE",REQUIRED,PROPERTY_TRUE);
	            //SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_CLM_ACCOUNT_SETUP.CLMAS_FORCE_DEPT_YN",ENABLED,PROPERTY_FALSE);
	            //SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_CLM_ACCOUNT_SETUP.CLMAS_FORCE_DEPT_YN",NAVIGABLE,PROPERTY_FALSE);
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	            throw e;
	        }
	    }
	
	// L_OVERLAP_CHECK FOR PRE_INSERT
	
	 public String L_OVERLAP_CHECK() 
	    {
		 System.out.println("L_OVERLAP_CHECK");
		 String M_DUMMY = null;
	        try
	        {
	        	connection = CommonUtils.getConnection();
	            //final dbms_output dbms_output1=new dbms_output();
	            String sql_C1="SELECT 'X' FROM  PM_IL_CLM_ACCOUNT_SETUP  WHERE  ('"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_BUS_FM_CODE()+"'" +
	            " BETWEEN CLMAS_BUS_FM_CODE  AND  CLMAS_BUS_TO_CODE  OR '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_BUS_TO_CODE()+"'"+
	            " BETWEEN CLMAS_BUS_FM_CODE  AND  CLMAS_BUS_TO_CODE  OR CLMAS_BUS_FM_CODE" +
	            " BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_BUS_FM_CODE()+"'  AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_BUS_TO_CODE()+"'  OR CLMAS_BUS_TO_CODE" +
	            " BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_BUS_FM_CODE()+"'  AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_BUS_TO_CODE()+"')  AND ('"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DIVN_FM_CODE()+"'"+
	            " BETWEEN CLMAS_DIVN_FM_CODE  AND  CLMAS_DIVN_TO_CODE  OR '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DIVN_TO_CODE()+"'"+
	            " BETWEEN CLMAS_DIVN_FM_CODE  AND  CLMAS_DIVN_TO_CODE  OR CLMAS_DIVN_FM_CODE  " +
	            " BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DIVN_FM_CODE()+"'  AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DIVN_TO_CODE()+"'  OR CLMAS_DIVN_TO_CODE  " +
	            " BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DIVN_FM_CODE()+"'  AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DIVN_TO_CODE()+"')  AND ('"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DEPT_FM_CODE()+"'"+
	            " BETWEEN CLMAS_DEPT_FM_CODE  AND  CLMAS_DEPT_TO_CODE  OR '"+ PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DEPT_TO_CODE()+"'"+
	            " BETWEEN CLMAS_DEPT_FM_CODE  AND  CLMAS_DEPT_TO_CODE  OR CLMAS_DEPT_FM_CODE  " +
	            " BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DEPT_FM_CODE()+"'  AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DEPT_TO_CODE()+"'  OR CLMAS_DEPT_TO_CODE"+
	            " BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DEPT_FM_CODE()+"'  AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DEPT_TO_CODE()+"')  AND ('"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DOC_FM_TYPE()+"'"+
	            " BETWEEN CLMAS_DOC_FM_TYPE  AND  CLMAS_DOC_TO_TYPE  OR '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DOC_TO_TYPE()+"'"+
	            " BETWEEN CLMAS_DOC_FM_TYPE  AND  CLMAS_DOC_TO_TYPE  OR CLMAS_DOC_FM_TYPE  " +
	            " BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DOC_FM_TYPE()+"'  AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DOC_TO_TYPE()+"'  OR CLMAS_DOC_TO_TYPE  " +
	            " BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DOC_FM_TYPE()+"'  AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DOC_TO_TYPE()+"')  AND ('"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_CLM_TYPE_FM_CODE()+"'" +
	            " BETWEEN CLMAS_CLM_TYPE_FM_CODE  AND  CLMAS_CLM_TYPE_TO_CODE  OR '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_CLM_TYPE_FM_CODE()+"'"+
	            " BETWEEN CLMAS_CLM_TYPE_FM_CODE  AND  CLMAS_CLM_TYPE_TO_CODE  OR CLMAS_CLM_TYPE_FM_CODE  " +
	            " BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_CLM_TYPE_FM_CODE()+"'  AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_CLM_TYPE_TO_CODE()+"' OR CLMAS_CLM_TYPE_TO_CODE  " +
	            " BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_CLM_TYPE_FM_CODE()+"'  AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_CLM_TYPE_TO_CODE()+"')  AND ('"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_TYPE()+"' = CLMAS_TYPE"+
	            " OR CLMAS_TYPE  = '"+ PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_TYPE()+"')  AND ('"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_SRC_BUS_FM()+"'" +
	            " BETWEEN CLMAS_SRC_BUS_FM  AND  CLMAS_SRC_BUS_TO  OR '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_SRC_BUS_TO()+"'"+
	            " BETWEEN CLMAS_SRC_BUS_FM  AND  CLMAS_SRC_BUS_TO  OR CLMAS_SRC_BUS_FM  " +
	            " BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_SRC_BUS_FM()+"'   AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_SRC_BUS_TO()+"'  OR CLMAS_SRC_BUS_TO  " +
	            " BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_SRC_BUS_FM()+"' AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_SRC_BUS_TO()+"')  AND ('"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_PROD_CODE_FM()+"'"+
	            " BETWEEN CLMAS_PROD_CODE_FM  AND  CLMAS_PROD_CODE_TO  OR '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_PROD_CODE_TO()+"'" +
	            " BETWEEN CLMAS_PROD_CODE_FM  AND  CLMAS_PROD_CODE_TO  OR CLMAS_PROD_CODE_FM " +
	            " BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_PROD_CODE_FM()+"'  AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_PROD_CODE_TO()+"'  OR CLMAS_PROD_CODE_TO " +
	            " BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_PROD_CODE_FM()+"'  AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_PROD_CODE_TO()+"')  AND ('"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_COVER_CODE_FM()+"'  " +
	            " BETWEEN CLMAS_COVER_CODE_FM  AND  CLMAS_COVER_CODE_TO  OR '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_COVER_CODE_TO()+"'  " +
	            " BETWEEN CLMAS_COVER_CODE_FM  AND  CLMAS_COVER_CODE_TO  OR CLMAS_COVER_CODE_FM  " +
	            " BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_COVER_CODE_FM()+"'  AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_COVER_CODE_TO()+"'  OR CLMAS_COVER_CODE_TO " +
	            " BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_COVER_CODE_FM()+"'  AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_COVER_CODE_TO()+"')  AND ('"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_CUST_CLS_FM_CODE()+"'" +
	            " BETWEEN CLMAS_CUST_CLS_FM_CODE  AND  CLMAS_CUST_CLS_TO_CODE  OR '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_CUST_CLS_FM_CODE()+"'  " +
	            " BETWEEN CLMAS_CUST_CLS_FM_CODE  AND  CLMAS_CUST_CLS_TO_CODE  OR CLMAS_CUST_CLS_FM_CODE" +
	            " BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_CUST_CLS_FM_CODE()+"'  AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_CUST_CLS_TO_CODE()+"'  OR CLMAS_CUST_CLS_TO_CODE  " +
	            " BETWEEN '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_CUST_CLS_FM_CODE()+"'  AND  '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_CUST_CLS_TO_CODE()+"')  AND CLMAS_ASSURED_TYPE  = '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_ASSURED_TYPE()+"'";
	            System.out.println("QUERY >>>>"+sql_C1);
	            ResultSet rs=null;
	            Statement stmt_C1=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	            rs=stmt_C1.executeQuery(sql_C1);
	            if(rs.next())
	            {
	                M_DUMMY=rs.getString(1);
	            }
	            /*if(!rs.isLast())
	            {
	            	
	            	//getErrorMap().put("current", Messages.getMessage(PELConstants.pelErrorMessagePath,"80031").getDetail());
	            	//getErrorMap().put("showValue", Messages.getMessage(PELConstants.pelErrorMessagePath,"80031").getDetail());
	    			throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"80031"));
	            }*/
	            rs.close();
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	           
	        }
	        return M_DUMMY;
	    }
	 
	 //WHEN-NEW-RECORD-INSTANCE
	 public void pilm024_pm_il_clm_account_setup_when_new_record_instance() throws SQLException,Exception
	    {
		 connection = CommonUtils.getConnection();
		 ResultSet rs_C1=null;
		 ResultSet rs_C2=null;
		 ResultSet rs_C3=null;
		 String M_TEMP1=null;
		 String M_TEMP2=null;
		 String sql_C1="SELECT MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2 FROM FM_MAIN_ACCOUNT WHERE MAIN_ACNT_CODE = ? ";
		 String sql_C2="SELECT ACTY_NAME FROM  FM_ACTIVITY  WHERE  ACTY_CODE  = ? ";
		 String sql_C3="SELECT ACTY_NAME FROM  FM_ACTIVITY  WHERE  ACTY_CODE  = ? ";
		 Object[] obj= {PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_MAIN_ACNT_CODE()};
		 
	     	try
	        {
	            //final dbms_output dbms_output1=new dbms_output();
	            Statement stmt_C1=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	            Statement stmt_C2=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	            Statement stmt_C3=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	            rs_C1 = handler.executeSelectStatement(sql_C1,connection,obj);
	            if(rs_C1.next())
	            { 
	            	DUMMY_BEAN.setM_ACTY_1(rs_C1.getString(1));
	            	DUMMY_BEAN.setM_ACTY_2(rs_C1.getString(2));
	            }
	            if(DUMMY_BEAN.getM_ACTY_1()!= null)
	            {
	            	rs_C2=handler.executeSelectStatement(sql_C2, connection, new Object[]{DUMMY_BEAN.getM_ACTY_1()});
	                if(rs_C2.next())
	                {
	                    M_TEMP1=rs_C2.getString(1);
	                   // BP_BEAN.setB_CLMAS_ACTY_CODE_1(StringFunctions.initcap(M_TEMP1));
	                    getCOMP_CLMAS_ACTY_CODE_1_LABEL().setValue(StringFunctions.initcap(M_TEMP1));
	                }
	            }
	            else
	            {
	               // BP_BEAN.setB_CLMAS_ACTY_CODE_1("Activity Code1");
	            	getCOMP_CLMAS_ACTY_CODE_1_LABEL().setValue("Activity Code1");
	            }
	            if(DUMMY_BEAN.getM_ACTY_2() != null)
	            {
	                rs_C3=handler.executeSelectStatement(sql_C3,connection,new Object[]{DUMMY_BEAN.getM_ACTY_2()});
	                if(rs_C3.next())
	                {
	                    M_TEMP2=rs_C3.getString(1);
	                    //BP_BEAN.setB_CLMAS_ACTY_CODE_2(StringFunctions.initcap(M_TEMP2));
	                    getCOMP_CLMAS_ACTY_CODE_2_LABEL().setValue(StringFunctions.initcap(M_TEMP2));
	                }
	            }
	            else
	            {
	              //  BP_BEAN.setB_CLMAS_ACTY_CODE_2("Activity Code2");
	            	 getCOMP_CLMAS_ACTY_CODE_2_LABEL().setValue("Activity Code2");
	            }
	           
	           // SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_CLM_ACCOUNT_SETUP.CLMAS_FORCE_DEPT_YN",ENABLED,PROPERTY_FALSE);
	            //SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_CLM_ACCOUNT_SETUP.CLMAS_FORCE_DEPT_YN",NAVIGABLE,PROPERTY_FALSE);
		        COMP_CLMAS_FORCE_DEPT_YN.setDisabled(true);
	            if(MigratingFunctions.nvl(PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_FORCE_DIVN_YN(),"N")=="Y")
	            {
	            	COMP_CLMAS_DIVN_CODE.setRequired(false);
	                COMP_CLMAS_DIVN_CODE.setReadonly(true);
	            	//SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_CLM_ACCOUNT_SETUP.CLMAS_DIVN_CODE",UPDATE_ALLOWED,PROPERTY_FALSE);
	                //SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_CLM_ACCOUNT_SETUP.CLMAS_DIVN_CODE",INSERT_ALLOWED,PROPERTY_FALSE);
	               // SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_CLM_ACCOUNT_SETUP.CLMAS_DIVN_CODE",NAVIGABLE,PROPERTY_FALSE);
	                //SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_CLM_ACCOUNT_SETUP.CLMAS_DIVN_CODE",REQUIRED,PROPERTY_FALSE);

	            }
	            if(MigratingFunctions.nvl(PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_FORCE_DIVN_YN(),"N")=="N")
	            {
	            	COMP_CLMAS_DIVN_CODE.setRequired(true);
	                COMP_CLMAS_DIVN_CODE.setReadonly(false);
	            	//SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_CLM_ACCOUNT_SETUP.CLMAS_DIVN_CODE",UPDATE_ALLOWED,PROPERTY_TRUE);
	                //SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_CLM_ACCOUNT_SETUP.CLMAS_DIVN_CODE",INSERT_ALLOWED,PROPERTY_TRUE);
	                //SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_CLM_ACCOUNT_SETUP.CLMAS_DIVN_CODE",NAVIGABLE,PROPERTY_TRUE);
	                //SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_CLM_ACCOUNT_SETUP.CLMAS_DIVN_CODE",REQUIRED,PROPERTY_TRUE);
	            }
	            if(MigratingFunctions.nvl(PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_FORCE_DEPT_YN(),"N")=="Y")
	            {
	            	COMP_CLMAS_DEPT_CODE.setRequired(false);
	                COMP_CLMAS_DEPT_CODE.setReadonly(true);
	            	//SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_CLM_ACCOUNT_SETUP.CLMAS_DEPT_CODE",UPDATE_ALLOWED,PROPERTY_FALSE);
	                //SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_CLM_ACCOUNT_SETUP.CLMAS_DEPT_CODE",INSERT_ALLOWED,PROPERTY_FALSE);
	                //SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_CLM_ACCOUNT_SETUP.CLMAS_DEPT_CODE",NAVIGABLE,PROPERTY_FALSE);
	                //SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_CLM_ACCOUNT_SETUP.CLMAS_DEPT_CODE",REQUIRED,PROPERTY_FALSE);
	            }
	            if(MigratingFunctions.nvl(PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_FORCE_DEPT_YN(),"N")=="N")
	            {
	            	COMP_CLMAS_DEPT_CODE.setRequired(true);
	                COMP_CLMAS_DEPT_CODE.setReadonly(false);
	            	// SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_CLM_ACCOUNT_SETUP.CLMAS_DEPT_CODE",UPDATE_ALLOWED,PROPERTY_TRUE);
	               // SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_CLM_ACCOUNT_SETUP.CLMAS_DEPT_CODE",INSERT_ALLOWED,PROPERTY_TRUE);
	               // SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_CLM_ACCOUNT_SETUP.CLMAS_DEPT_CODE",NAVIGABLE,PROPERTY_TRUE);
	               // SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PM_IL_CLM_ACCOUNT_SETUP.CLMAS_DEPT_CODE",REQUIRED,PROPERTY_TRUE);
	            }
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	            throw e;
	        }finally{
	        	try{
	        		if(rs_C1!=null)
	        			rs_C1.close();
	        	}catch(SQLException e){
	        		e.printStackTrace();
	        	}try{
	        		if(rs_C2!=null)
	        			rs_C2.close();
	        	}catch(SQLException e){
	        		e.printStackTrace();
	        	}try{
	        		if(rs_C3!=null)
	        			rs_C3.close();
	        	}catch(SQLException e){
	        		e.printStackTrace();
	        	}

	        }
	    }
	 
	 //POST-QUERY
	 public void pilm024_pm_il_clm_account_setup_post_query() throws SQLException,Exception
	    {
		 connection = CommonUtils.getConnection();
	        try
	        {
	            //final dbms_output dbms_output1=new dbms_output();
	            //P_VAL_ACTY(:DUMMY.M_ACTY_1,:PM_IL_CLM_ACCOUNT_SETUP.CLMAS_ACTY_CODE_1,:PM_IL_CLM_ACCOUNT_SETUP.M_ACTY_NAME,"N","N");
	            //P_VAL_ACTY.P_VAL_ACTY(:DUMMY.M_ACTY_2,:PM_IL_CLM_ACCOUNT_SETUP.CLMAS_ACTY_CODE_2,:PM_IL_CLM_ACCOUNT_SETUP.M_ACTY_NAME_1,"N","N");
	            //P_VAL_MAIN_ACNT.P_VAL_MAIN_ACNT(:PM_IL_CLM_ACCOUNT_SETUP.CLMAS_MAIN_ACNT_CODE,:PM_IL_CLM_ACCOUNT_SETUP.M_MAIN_ACNT_NAME,"N","N");
	            //P_VAL_SUB_ACNT.P_VAL_SUB_ACNT(:PM_IL_CLM_ACCOUNT_SETUP.CLMAS_MAIN_ACNT_CODE,:PM_IL_CLM_ACCOUNT_SETUP.CLMAS_SUB_ACNT_CODE,:PM_IL_CLM_ACCOUNT_SETUP.M_SUB_ACNT_NAME,"N","N");
	            L_GET_ACTY_DETAILS();
	            //P_VAL_ANLY.P_VAL_ANLY("1",:PM_IL_CLM_ACCOUNT_SETUP.CLMAS_ANLY_CODE_1,:PM_IL_CLM_ACCOUNT_SETUP.M_ANLY_NAME,"N","N");
	            //P_VAL_ANLY.P_VAL_ANLY("2",:PM_IL_CLM_ACCOUNT_SETUP.CLMAS_ANLY_CODE_2,:PM_IL_CLM_ACCOUNT_SETUP.M_ANLY_NAME_1,"N","N");
	            //F_VAL_DIVN.F_VAL_DIVN(:PM_IL_CLM_ACCOUNT_SETUP.CLMAS_DIVN_CODE,:PM_IL_CLM_ACCOUNT_SETUP.M_DIVN_NAME,"N","N");
	           // F_VAL_DEPT.F_VAL_DEPT(:PM_IL_CLM_ACCOUNT_SETUP.CLMAS_DIVN_CODE,:PM_IL_CLM_ACCOUNT_SETUP.CLMAS_DEPT_CODE,:PM_IL_CLM_ACCOUNT_SETUP.M_DEPT_NAME,"N","N");
	            
	            
	            /*Commented by saranya  on 21-04-2017 as suggested by sivaram
	             * 
	             * COMP_CLMAS_MAIN_ACNT_CODE.setReadonly(true);
	             * 
	             * End*/
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	            throw e;
	        }
	    }
	 
	 //L_GET_ACTY_DETAILS FOR POST-QUERY
	 
	 public void L_GET_ACTY_DETAILS() throws SQLException,Exception
	    {
		 
		 connection = CommonUtils.getConnection();
	        try
	        {
	            String sql_C1="SELECT    MAIN_ACTY_CODE_1, MAIN_ACTY_CODE_2 FROM  FM_MAIN_ACCOUNT  WHERE  MAIN_ACNT_CODE  = '"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_MAIN_ACNT_CODE()+"' ";
	            ResultSet rs_C1=null;
	            Statement stmt_C1=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	            String M_ACTY_HEAD_1=null;
	            String M_ACTY_HEAD_2=null;
	            rs_C1=stmt_C1.executeQuery(sql_C1);
	            if(rs_C1.next())
	            {
	                M_ACTY_HEAD_1=rs_C1.getString(1);
	                M_ACTY_HEAD_2=rs_C1.getString(2);
	            }
	            if(rs_C1.isAfterLast() || rs_C1.isBeforeFirst())
	            {
	            }
	            rs_C1.close();
	            DUMMY_BEAN.setM_ACTY_HEAD_1(M_ACTY_HEAD_1);
	            DUMMY_BEAN.setM_ACTY_HEAD_2(M_ACTY_HEAD_2);
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	            throw e;
	        }
	    }
	 
	 
	
	 //PREFORM CALLING......
	 
	 public void preForm(PhaseEvent event) throws Exception{
		 System.out.println("INSIDE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>preForm()");
				//ArrayList<OracleParameter> list =null;
				FacesContext context=FacesContext.getCurrentInstance();
				context.getExternalContext().getSessionMap();
				session = (HttpSession)context.getExternalContext().getSession(true);
				session.setAttribute("GLOBAL.M_PRIVILEGE", "YYY");
				session.setAttribute("GLOBAL.M_FAILURE", "FALSE");
				session.setAttribute("GLOBAL.M_USER_ID", "PREMIA");
				session.setAttribute("GLOBAL.M_NAME", "COMPANY NAME..................PROGRAM NAME");
				session.setAttribute("GLOBAL.M_LANG_CODE", "ENG");
				session.setAttribute("GLOBAL.M_DFLT_VALUES", "00101    01");
				session.setAttribute("GLOBAL.M_PARA_1", " ");
				session.setAttribute("GLOBAL.M_FOR_LANG_CODE", "ARBR1");
			//				values should take from GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),FORM_NAME)
//				Developing purpose hard coded it.
				//session.put("GLOBAL.M_MODULE_NAME", "PILP014_A");
				session.setAttribute("GLOBAL.M_MODULE_NAME", "PILM024");
				
		 
//				calling STD_PRE_FORM PLL
		 		STD_PRE_FORM();

				if(Integer.parseInt(((String)session.getAttribute("GLOBAL.M_FOR_LANG_CODE")).substring(4,5))== 1 ){
		 System.out.println("DUMMYACTION.preForm()NULLLLLLLLLLLLLLLLL");
				}
				ControlBean ctrlbean = getCtrlBean();
				String M_TITLE = ctrlbean.getM_USER_ID()+" "+ctrlbean.getM_SCR_NAME()+" "+new Date();
		 System.out.println("DUMMYACTION.preForm()---->> "+M_TITLE);
				try {
					connection = CommonUtils.getConnection();
				} catch (Exception exp) {
					exp.printStackTrace();
				}
		 System.out.println("DUMMYACTION.callProc()\n-------------"+session+"\n------");
				
				//getTest().setDisabled(true);
				//return null;
			}

			public void STD_PRE_FORM(){
				
				System.out.println("INSIDE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>STD_PRE_FORM()");
				System.out.println("DUMMY_ACTION.STD_PRE_FORM()------createCtrlBean");
				ctrlBean = getCtrlBean();
		System.out.println("DUMMYACTION.STD_PRE_FORM()\n---------->\n"+session.toString()+"\n----------");
				ctrlBean.setM_PARA_1((String)session.getAttribute("GLOBAL.M_PARA_1"));
				ctrlBean.setM_USER_ID((String)session.getAttribute("GLOBAL.M_USER_ID"));
				ctrlBean.setM_PROG_NAME("PIL014_A");
		 System.out.println("DUMMYACTION.STD_PRE_FORM(------)" +(String)session.getAttribute("GLOBAL.M_NAME"));
				ctrlBean.setM_SCR_NAME(((String)session.getAttribute("GLOBAL.M_NAME")).substring(30, 42));
				session.setAttribute("GLOBAL.M_FAILURE", "FALSE");
				ctrlBean.setM_GOFLD_NAME("NULL");
				ctrlBean.setM_LANG_CODE((String)session.getAttribute("GLOBAL.M_LANG_CODE"));
				ctrlBean.setM_COMP_CODE(((String)session.getAttribute("GLOBAL.M_DFLT_VALUES")).substring(0,3));
				ctrlBean.setM_DIVN_CODE(((String)session.getAttribute("GLOBAL.M_DFLT_VALUES")).substring(3,6));
		 System.out.println("DUMMYACTION.STD_PRE_FORM(!!!! ) "+(String)session.getAttribute("GLOBAL.M_DFLT_VALUES"));
				ctrlBean.setM_DEPT_CODE(((String)session.getAttribute("GLOBAL.M_DFLT_VALUES")).substring(9,11));
		 System.out.println("DUMMYACTION.STD_PRE_FORM()--- \n "+ctrlBean.getM_LANG_CODE()+"\t"+ctrlBean.getM_COMP_CODE()+"\t"+ctrlBean.getM_PARA_1());
			}

			
			
			public String checkBoxStatus(ActionEvent actionEvent){
				return "";
			}

			public void checkBoxValidation(ActionEvent event){
				System.out.println("PM_IL_CLM_ACCOUNT_SETUP.checkBoxValidation()");
			}

			public void ForceBranchChange(ActionEvent ae){
				String value = getCOMP_CLMAS_FORCE_DIVN_YN().getSubmittedValue().toString();
				if(value.equals("Y")){
					getCOMP_CLMAS_DIVN_CODE().setDisabled(true);
					getCOMP_CLMAS_DIVN_CODE().setRequired(false);
				}else{
					getCOMP_CLMAS_DIVN_CODE().setDisabled(false);
					getCOMP_CLMAS_DIVN_CODE().setRequired(true);
				}
				getCOMP_CLMAS_FORCE_DEPT_YN().setSubmittedValue(value);
				CLMAS_FORCE_DEPT_YN_WHEN_LIST_CHANGED(value);
				/*if(COMP_CLMAS_FORCE_DIVN_YN.getSubmittedValue().equals("Y")){
					COMP_CLMAS_FORCE_DEPT_YN.setSubmittedValue("Y");
					getCOMP_CLMAS_DIVN_CODE().setRendered(true);
					getCOMP_CLMAS_DIVN_CODE().setDisabled(true);
					getCOMP_CLMAS_DEPT_CODE().setRendered(true);
					getCOMP_CLMAS_DEPT_CODE().setDisabled(true);
				}
				else if(COMP_CLMAS_FORCE_DIVN_YN.getSubmittedValue().equals("N")){
					COMP_CLMAS_FORCE_DEPT_YN.setSubmittedValue("N");
					getCOMP_CLMAS_DIVN_CODE().setRendered(true);
					getCOMP_CLMAS_DIVN_CODE().setDisabled(false);
					getCOMP_CLMAS_DEPT_CODE().setRendered(true);
					getCOMP_CLMAS_DEPT_CODE().setDisabled(false);
				}*/
			 }
			public void CLMAS_FORCE_DEPT_YN_WHEN_LIST_CHANGED(String value){
				if(value.equals("Y")){
					getCOMP_CLMAS_DEPT_CODE().setDisabled(true);
					getCOMP_CLMAS_DEPT_CODE().setRequired(false);
				}else{
					getCOMP_CLMAS_DEPT_CODE().setDisabled(false);
					getCOMP_CLMAS_DEPT_CODE().setRequired(true);
				}
			}
			
			public void pilm024_pm_il_clm_account_setup_clmas_main_acnt_code_when_validate_item(PM_IL_CLM_ACCOUNT_SETUP PM_IL_CLM_ACCOUNT_SETUP_BEAN) throws Exception 
			{
				System.out.println("pilm024_pm_il_clm_account_setup_clmas_main_acnt_code_when_validate_item");
				ResultSet rs_C1=null;
				ResultSet vembu_C2=null;
				ResultSet vembu_C3=null;
				String M_TEMP1=null;
				String M_TEMP2=null;
		
				Connection connection =null;
				String sql_C1="SELECT MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2 FROM  FM_MAIN_ACCOUNT  WHERE  MAIN_ACNT_CODE  = ? ";
				String sql_C2="SELECT ACTY_NAME FROM  FM_ACTIVITY  WHERE  ACTY_CODE  = ? ";
				String sql_C3="SELECT ACTY_NAME FROM  FM_ACTIVITY  WHERE  ACTY_CODE  = ? ";
				try{
					connection = CommonUtils.getConnection();
	           		String DESC = new DBProcedures().P_VAL_MAIN_ACNT(PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_MAIN_ACNT_CODE(),null, "N", "E");
	            	getPM_IL_CLM_ACCOUNT_SETUP_BEAN().setUI_M_MAIN_ACNT_NAME(DESC);
	            	getCOMP_UI_M_MAIN_ACNT_NAME().setSubmittedValue(DESC);
	            	L_VAL_MAIN_ACTIVITY();
		
					rs_C1 = new CRUDHandler().executeSelectStatement(sql_C1, connection,new Object[]{PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_MAIN_ACNT_CODE()});
					if(rs_C1.next()){
						DUMMY_BEAN.setM_ACTY_1(rs_C1.getString(1));
						DUMMY_BEAN.setM_ACTY_2(rs_C1.getString(2));
					}
					
					if(DUMMY_BEAN.getM_ACTY_1() != null){
						vembu_C2=handler.executeSelectStatement(sql_C2, connection,new Object[]{DUMMY_BEAN.getM_ACTY_1()}); 
						if(vembu_C2.next()){
							M_TEMP1=vembu_C2.getString(1);
						}
						COMP_CLMAS_ACTY_CODE_1_LABEL.setValue(M_TEMP1);
					}else{
						COMP_CLMAS_ACTY_CODE_1_LABEL.setValue("Activity Code1");
					}
					
					if(DUMMY_BEAN.getM_ACTY_2() != null){
						vembu_C3=handler.executeSelectStatement(sql_C3, connection,new Object[]{DUMMY_BEAN.getM_ACTY_2()});

						if(vembu_C3.next()){
							M_TEMP2=vembu_C3.getString(1);
						}
						COMP_CLMAS_ACTY_CODE_2_LABEL.setValue(M_TEMP2);
					}else{
						COMP_CLMAS_ACTY_CODE_2_LABEL.setValue("Activity Code2");
					}
				}catch(Exception e){
					e.printStackTrace();
					throw e;
				}finally{
					try{CommonUtils.closeCursor(vembu_C2);}catch(Exception e){}
					try{CommonUtils.closeCursor(vembu_C3);}catch(Exception e){}
					try{CommonUtils.closeCursor(rs_C1);}catch(Exception e){}
				}
			}

			public void L_VAL_MAIN_ACTIVITY() throws SQLException,Exception{
				
				connection = getConnection();
				try{
					String sql_C1="SELECT    MAIN_ACTY_CODE_1,    MAIN_ACTY_CODE_2 FROM  FM_MAIN_ACCOUNT  WHERE  MAIN_ACNT_CODE  = '"+COMP_CLMAS_MAIN_ACNT_CODE.getSubmittedValue()+"'";
					ResultSet vembu_C1=null;
					Statement stmt_C1=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
					String   M_ACTY_HEAD_1=null;
					String  M_ACTY_HEAD_2=null;
					vembu_C1=stmt_C1.executeQuery(sql_C1);
					if(vembu_C1.next()){
						M_ACTY_HEAD_1=vembu_C1.getString(1);
						M_ACTY_HEAD_2=vembu_C1.getString(2);
					}
					
					if(M_ACTY_HEAD_1== null){
						COMP_CLMAS_ACTY_CODE_1.setRequired(false);
						COMP_CLMAS_ACTY_CODE_1.setReadonly(true);
						if(PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_ACTY_CODE_1() != null){
							PM_IL_CLM_ACCOUNT_SETUP_BEAN.setCLMAS_ACTY_CODE_1(null);
							PM_IL_CLM_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_NAME(null);
						}
					}else{
						COMP_CLMAS_ACTY_CODE_1.setReadonly(false);
						COMP_CLMAS_ACTY_CODE_1.setRequired(true);
						PM_IL_CLM_ACCOUNT_SETUP_BEAN.setCLMAS_ACTY_CODE_1(PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_ACTY_CODE_1());
					}
					if(M_ACTY_HEAD_2== null){
						COMP_CLMAS_ACTY_CODE_2.setReadonly(true);
						COMP_CLMAS_ACTY_CODE_2.setRequired(false);
						if(PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_ACTY_CODE_2() != null){
							PM_IL_CLM_ACCOUNT_SETUP_BEAN.setCLMAS_ACTY_CODE_2(null);
							PM_IL_CLM_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_NAME_1(null);
						}
					}else{
						COMP_CLMAS_ACTY_CODE_2.setReadonly(false);
						COMP_CLMAS_ACTY_CODE_2.setRequired(true);
						PM_IL_CLM_ACCOUNT_SETUP_BEAN.setCLMAS_ACTY_CODE_2(PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_ACTY_CODE_2());
					}
					M_ACTY_HEAD_1=M_ACTY_HEAD_1;
					M_ACTY_HEAD_2=M_ACTY_HEAD_2;
				}catch(Exception e){
					e.printStackTrace();
					throw e;
				}
			}

			public void pilm024_pm_il_clm_account_setup_clmas_sub_acnt_code_when_validate_item(PM_IL_CLM_ACCOUNT_SETUP PM_IL_CLM_ACCOUNT_SETUP_BEAN ) throws SQLException,Exception{
				try{
				if(PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_SUB_ACNT_CODE() != null){
							ArrayList<String> List = new DBProcedures().P_VAL_SUB_ACNT(PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_MAIN_ACNT_CODE(),
									PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_SUB_ACNT_CODE(), "N", "E");
		         
							getPM_IL_CLM_ACCOUNT_SETUP_BEAN().setUI_M_SUB_ACNT_NAME(List.get(0));
				}
				}catch(Exception e){
					e.printStackTrace();
					throw e;
				}
			}
	        			
			
			public void pilm024_pm_il_clm_account_setup_clmas_divn_code_when_validate_item(PM_IL_CLM_ACCOUNT_SETUP PM_IL_CLM_ACCOUNT_SETUP_BEAN) throws SQLException,Exception
		    {
				try
		        {
					PM_IL_CLM_ACCOUNT_SETUP_BEAN.setUI_M_DIVN_NAME(null);
					if(PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DIVN_CODE() == null){
			        	System.out.println("Bean Has Null");
			        }
		            if(PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DIVN_CODE() != null)
		            {
		            	
		            	ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		            	ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
		           		paramList.add(new OracleParameter("in1","STRING","IN",PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DIVN_CODE()));
		           		paramList.add(new OracleParameter("in2","STRING","IN OUT",""));
		           		paramList.add(new OracleParameter("in3","STRING","IN","N"));
		           		paramList.add(new OracleParameter("in4","STRING","IN","E"));

	        			/*[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified F_VAL_DIVN to P_VAL_DIVN. Added by : Mallika.S, 02-Apr-2009 */
	        			list = ora_Handler.execute(paramList, connection, "P_VAL_DIVN");
	        			OracleParameter P_DIVN_NAME = list.get(0);
	        			getPM_IL_CLM_ACCOUNT_SETUP_BEAN().setUI_M_DIVN_NAME(P_DIVN_NAME.getValue());
		            }
		            if(MigratingFunctions.nvl(PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_FORCE_DIVN_YN(),"N")=="N")
		            {
		                COMP_CLMAS_DIVN_CODE.setRequired(true);
		            }
		            L_SET_DEPT_ATTR();
		        }catch(Exception e)
		        {
		            e.printStackTrace();
		            throw e;
		        }
		        
		    }

			public void fireFieldValidation(ActionEvent actionEvent) {
				UIInput input = (UIInput) actionEvent.getComponent().getParent();
				ErrorHelpUtil.validate(input, getErrorMap());
			}

			
			public void CLMAS_MAIN_ACNT_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
					UIComponent component, Object value)  {
				try {
					getPM_IL_CLM_ACCOUNT_SETUP_BEAN().setCLMAS_MAIN_ACNT_CODE((String)value);
					pilm024_pm_il_clm_account_setup_clmas_main_acnt_code_when_validate_item(PM_IL_CLM_ACCOUNT_SETUP_BEAN);
					COMP_UI_M_MAIN_ACNT_NAME.resetValue();
				} catch (Exception e) {
					throw new ValidatorException(new FacesMessage(e.getMessage()));
				}finally {
					try {

						ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
								.getConnection(), context,component.getParent().getId(),
								getWarningMap());
					} catch (Exception e) {
						throw new ValidatorException(new FacesMessage(e.getMessage()));
					}
				}
			}
			public void CLMAS_SUB_ACNT_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
					UIComponent component, Object value)  {
				CommonUtils.clearMaps(this);
				try {
					getPM_IL_CLM_ACCOUNT_SETUP_BEAN().setCLMAS_SUB_ACNT_CODE((String)value);
					pilm024_pm_il_clm_account_setup_clmas_sub_acnt_code_when_validate_item(PM_IL_CLM_ACCOUNT_SETUP_BEAN);
					COMP_UI_M_SUB_ACNT_NAME.resetValue();

				} catch (Exception e) {
					throw new ValidatorException(new FacesMessage(e.getMessage()));
				}finally {
					try {

						ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
								.getConnection(), context,component.getParent().getId(),
								getWarningMap());
					} catch (Exception e) {
						throw new ValidatorException(new FacesMessage(e.getMessage()));
					}
				}
			}

			public void CLMAS_DIVN_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
					UIComponent component, Object value)  {
				CommonUtils.clearMaps(this);
				try {
					getPM_IL_CLM_ACCOUNT_SETUP_BEAN().setCLMAS_DIVN_CODE((String)value);
					pilm024_pm_il_clm_account_setup_clmas_divn_code_when_validate_item(PM_IL_CLM_ACCOUNT_SETUP_BEAN);
					COMP_UI_M_DIVN_NAME.resetValue();

				} catch (Exception e) {
					throw new ValidatorException(new FacesMessage(e.getMessage()));
				}finally {
					try {

						ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
								.getConnection(), context,component.getParent().getId(),
								getWarningMap());
					} catch (Exception e) {
						throw new ValidatorException(new FacesMessage(e.getMessage()));
					}
				}
			}
			
			public void CLMAS_DEPT_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
					UIComponent component, Object value)  {
				CommonUtils.clearMaps(this);
				try {
					getPM_IL_CLM_ACCOUNT_SETUP_BEAN().setCLMAS_DEPT_CODE((String)value);
					pilm024_pm_il_clm_account_setup_clmas_dept_code_when_validate_item(PM_IL_CLM_ACCOUNT_SETUP_BEAN);
					COMP_UI_M_DEPT_NAME.resetValue();

				} catch (Exception e) {
					throw new ValidatorException(new FacesMessage(e.getMessage()));
				}finally {
					try {

						ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
								.getConnection(), context,component.getParent().getId(),
								getWarningMap());
					} catch (Exception e) {
						throw new ValidatorException(new FacesMessage(e.getMessage()));
					}
				}
			}
			
			public void CLMAS_ANLY_CODE_1_WHEN_VALIDATE_ITEM(FacesContext context,
					UIComponent component, Object value)  {
				CommonUtils.clearMaps(this);
				try {
					getPM_IL_CLM_ACCOUNT_SETUP_BEAN().setCLMAS_ANLY_CODE_1((String)value);
					pilm024_pm_il_clm_account_setup_clmas_anly_code_1_when_validate_item(PM_IL_CLM_ACCOUNT_SETUP_BEAN);
					COMP_UI_M_ANLY_NAME.resetValue();

				} catch (Exception e) {
					throw new ValidatorException(new FacesMessage(e.getMessage()));
				}finally {
					try {

						ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
								.getConnection(), context,component.getParent().getId(),
								getWarningMap());
					} catch (Exception e) {
						throw new ValidatorException(new FacesMessage(e.getMessage()));
					}
				}
			}
			
			public void validateCLMAS_ANLY_CODE_1(ActionEvent actionEvent){
				try {
					UIInput input = (UIInput) actionEvent.getComponent().getParent();
					String value= input.getSubmittedValue().toString();
					if("".equalsIgnoreCase(value)){
						PM_IL_CLM_ACCOUNT_SETUP_BEAN.setUI_M_ANLY_NAME(null);
						COMP_CLMAS_ACTY_CODE_1.setSubmittedValue("");
						COMP_CLMAS_ACTY_CODE_1.resetValue();
					}else{
						getPM_IL_CLM_ACCOUNT_SETUP_BEAN().setCLMAS_ANLY_CODE_1((String)value);
						pilm024_pm_il_clm_account_setup_clmas_anly_code_1_when_validate_item(PM_IL_CLM_ACCOUNT_SETUP_BEAN);
						COMP_UI_M_ANLY_NAME.resetValue();
					}
					} catch (Exception e) {
					getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							e.getMessage());
					getErrorMap().put("Master Policy Number Suggestion", e.getMessage());
				}
			}
			
			public void CLMAS_ANLY_CODE_2_WHEN_VALIDATE_ITEM(FacesContext context,
					UIComponent component, Object value)  {
				CommonUtils.clearMaps(this);
				try {
					getPM_IL_CLM_ACCOUNT_SETUP_BEAN().setCLMAS_ANLY_CODE_2((String)value);
					pilm024_pm_il_clm_account_setup_clmas_anly_code_2_when_validate_item(PM_IL_CLM_ACCOUNT_SETUP_BEAN);
					COMP_UI_M_ANLY_NAME_1.resetValue();

				} catch (Exception e) {
					throw new ValidatorException(new FacesMessage(e.getMessage()));
				}finally {
					try {

						ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
								.getConnection(), context,component.getParent().getId(),
								getWarningMap());
					} catch (Exception e) {
						throw new ValidatorException(new FacesMessage(e.getMessage()));
					}
				}
			}			
			
			
			public void CLMAS_ACTY_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
					UIComponent component, Object value)  {
				CommonUtils.clearMaps(this);
				try {
					getPM_IL_CLM_ACCOUNT_SETUP_BEAN().setCLMAS_ACTY_CODE_1((String)value);
					pilm024_pm_il_clm_account_setup_clmas_acty_code_1_when_validate_item(PM_IL_CLM_ACCOUNT_SETUP_BEAN);
					COMP_UI_M_ACTY_NAME.resetValue();

				} catch (Exception e) {
					throw new ValidatorException(new FacesMessage(e.getMessage()));
				}finally {
					try {

						ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
								.getConnection(), context,component.getParent().getId(),
								getWarningMap());
					} catch (Exception e) {
						throw new ValidatorException(new FacesMessage(e.getMessage()));
					}
				}
			}	
			public void CLMAS_ACTY_CODE_1_WHEN_VALIDATE_ITEM(FacesContext context,
					UIComponent component, Object value)  {
				CommonUtils.clearMaps(this);
				try {
					getPM_IL_CLM_ACCOUNT_SETUP_BEAN().setCLMAS_ACTY_CODE_2((String)value);
					pilm024_pm_il_clm_account_setup_clmas_acty_code_2_when_validate_item(PM_IL_CLM_ACCOUNT_SETUP_BEAN);
					COMP_UI_M_ACTY_NAME_1.resetValue();

				} catch (Exception e) {
					throw new ValidatorException(new FacesMessage(e.getMessage()));
				}finally {
					try {

						ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
								.getConnection(), context,component.getParent().getId(),
								getWarningMap());
					} catch (Exception e) {
						throw new ValidatorException(new FacesMessage(e.getMessage()));
					}
				}
			}	
			
			public void pilm024_pm_il_clm_account_setup_clmas_dept_code_when_validate_item(PM_IL_CLM_ACCOUNT_SETUP PM_IL_CLM_ACCOUNT_SETUP_BEAN) throws SQLException,Exception
		    {
			    try
		        {
		            if(PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DEPT_CODE() != null)
		            {
		            	ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		            	ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
		           		paramList.add(new OracleParameter("in1","STRING","IN",PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DIVN_CODE()));
		           		paramList.add(new OracleParameter("in2","STRING","IN",PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DEPT_CODE()));
		           		paramList.add(new OracleParameter("in3","STRING","IN OUT",""));
		           		paramList.add(new OracleParameter("in4","STRING","IN","N"));
		           		paramList.add(new OracleParameter("in5","STRING","IN","E"));
		           		
            			list = ora_Handler.execute(paramList, connection, "P_VAL_DEPT");
            			OracleParameter P_DEPT_NAME = list.get(0);
            			System.out.println("Dept Name = "+P_DEPT_NAME.getValue());
            			getPM_IL_CLM_ACCOUNT_SETUP_BEAN().setUI_M_DEPT_NAME(P_DEPT_NAME.getValue());
            			getCOMP_UI_M_DEPT_NAME().setSubmittedValue(P_DEPT_NAME.getValue());
		            }
		            if(MigratingFunctions.nvl(PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_FORCE_DEPT_YN(),"N")=="N")
		            {
		                COMP_CLMAS_DEPT_CODE.setRequired(true);
		            }
		        }catch(Exception e)
		        {
		            e.printStackTrace();
		            throw e;
		        }
		    }
			
			public void L_SET_DEPT_ATTR() throws SQLException,Exception
		    {
				System.out.println("L_SET_DEPT_ATTR");
				connection = getConnection();
		        try
		        {
		            if(PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DIVN_CODE()== null)
		            {
		                COMP_CLMAS_DEPT_CODE.setRequired(false);
		                COMP_CLMAS_DEPT_CODE.setReadonly(true);
		                if(PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DEPT_CODE() != null)
		                {
		                	PM_IL_CLM_ACCOUNT_SETUP_BEAN.setCLMAS_DEPT_CODE(null);
		                	PM_IL_CLM_ACCOUNT_SETUP_BEAN.setUI_M_DEPT_NAME(null);
		                    System.out.println("L_SET_DEPT_ATTRPM_IL_CLM_ACCOUNT_SETUP_BEAN.setCAS_DEPT_CODE()"+PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_DEPT_CODE());
		                    System.out.println("L_SET_DEPT_ATTR Submitted "+getCOMP_CLMAS_DEPT_CODE().getSubmittedValue());
		                }
		            }
		            else
		            {
		                COMP_CLMAS_DEPT_CODE.setRequired(true);
		                COMP_CLMAS_DEPT_CODE.setReadonly(false);
		            }
		        }catch(Exception e)
		        {
		            e.printStackTrace();
		            throw e;
		        }
		    }
			
			public void pilm024_pm_il_clm_account_setup_clmas_anly_code_1_when_validate_item(PM_IL_CLM_ACCOUNT_SETUP PM_IL_CLM_ACCOUNT_SETUP_BEAN) throws SQLException,Exception
		    {
				try
		        {
		            if(PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_ANLY_CODE_1() != null)
		            {
		            	ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		            	ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
		           		paramList.add(new OracleParameter("in1","STRING","IN","1"));
		           		paramList.add(new OracleParameter("in2","STRING","IN",PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_ANLY_CODE_1()));
		           		paramList.add(new OracleParameter("in3","STRING","IN OUT",""));
		           		paramList.add(new OracleParameter("in4","STRING","IN","N"));
		           		paramList.add(new OracleParameter("in5","STRING","IN","E"));
		           		
		    			list = ora_Handler.execute(paramList, connection, "P_VAL_ANLY");
		    			OracleParameter ANLY_CODE_1 = list.get(0);
		    			System.out.println("Dept Name = "+ANLY_CODE_1.getValue());
		    			getPM_IL_CLM_ACCOUNT_SETUP_BEAN().setUI_M_ANLY_NAME(ANLY_CODE_1.getValue());
		            }
		            L_SET_ANALYSIS_ATTR();
		        }catch(Exception e)
		        {
		            e.printStackTrace();
		            throw e;
		        }
		    }
			
			public void pilm024_pm_il_clm_account_setup_clmas_anly_code_2_when_validate_item(PM_IL_CLM_ACCOUNT_SETUP PM_IL_CLM_ACCOUNT_SETUP_BEAN) throws SQLException,Exception
		    {
				try
		        {
		            if(PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_ANLY_CODE_2() != null)
		            {
		            	ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		            	ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
		           		paramList.add(new OracleParameter("in1","STRING","IN","1"));
		           		paramList.add(new OracleParameter("in2","STRING","IN",PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_ANLY_CODE_1()));
		           		paramList.add(new OracleParameter("in3","STRING","IN OUT",""));
		           		paramList.add(new OracleParameter("in4","STRING","IN","N"));
		           		paramList.add(new OracleParameter("in5","STRING","IN","E"));
		           		
		    			list = ora_Handler.execute(paramList, connection, "P_VAL_ANLY");
		    			OracleParameter ANLY_CODE_1 = list.get(0);
		    			System.out.println("Dept Name = "+ANLY_CODE_1.getValue());
		    			getPM_IL_CLM_ACCOUNT_SETUP_BEAN().setUI_M_ANLY_NAME_1(ANLY_CODE_1.getValue());
		            }
		            L_SET_ANALYSIS_ATTR();
		        }catch(Exception e)
		        {
		            e.printStackTrace();
		            throw e;
		        }
		    }
			public void L_SET_ANALYSIS_ATTR() throws SQLException,Exception
		    {
				connection = getConnection();
				try
		        {
		            if(PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_ANLY_CODE_1()== null)
		            {
		                COMP_CLMAS_ANLY_CODE_2.setReadonly(true);
		            }
		            else
		            {
		            	COMP_CLMAS_ANLY_CODE_2.setReadonly(false);
		            }
		        }catch(Exception e)
		        {
		            e.printStackTrace();
		            throw e;
		        }
		    }
			public void pilm024_pm_il_clm_account_setup_clmas_acty_code_2_when_validate_item(PM_IL_CLM_ACCOUNT_SETUP PM_IL_CLM_ACCOUNT_SETUP_BEAN) throws SQLException,Exception
		    {
				try
		        {
		            if(PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_ACTY_CODE_2() != null)
		            {
		            	ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		            	ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
		           		paramList.add(new OracleParameter("in1","STRING","IN","2"));
		           		paramList.add(new OracleParameter("in2","STRING","IN",PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_ACTY_CODE_2()));
		           		paramList.add(new OracleParameter("in3","STRING","IN OUT",""));
		           		paramList.add(new OracleParameter("in4","STRING","IN","N"));
		           		paramList.add(new OracleParameter("in5","STRING","IN","E"));
		           		
            			list = ora_Handler.execute(paramList, connection, "P_VAL_ANLY");
            			OracleParameter ANLY_CODE_2 = list.get(0);
            			System.out.println("Acty Name 2 = "+ANLY_CODE_2.getValue());
            			getCOMP_UI_M_ANLY_NAME_1().setSubmittedValue(ANLY_CODE_2.getValue());
            			COMP_UI_M_ANLY_NAME_1.resetValue();
		            }
		        }catch(Exception e)
		        {
		            e.printStackTrace();
		            throw e;
		        }
		    }
			public void pilm024_pm_il_clm_account_setup_clmas_acty_code_1_when_validate_item(PM_IL_CLM_ACCOUNT_SETUP PM_IL_CLM_ACCOUNT_SETUP_BEAN) throws SQLException,Exception
		    {
				try
		        {
		            if(PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_ACTY_CODE_1() != null
		            		&&!PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_ACTY_CODE_1().equalsIgnoreCase("*"))
		            {
		            	ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		            	ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
		           		paramList.add(new OracleParameter("in1","STRING","IN",DUMMY_BEAN.getM_ACTY_1()));
		           		paramList.add(new OracleParameter("in2","STRING","IN",PM_IL_CLM_ACCOUNT_SETUP_BEAN.getCLMAS_ACTY_CODE_1()));
		           		paramList.add(new OracleParameter("in3","STRING","IN OUT",""));
		           		paramList.add(new OracleParameter("in4","STRING","IN","N"));
		           		paramList.add(new OracleParameter("in5","STRING","IN","E"));
		           		
            			list = ora_Handler.execute(paramList, connection, "P_VAL_ACTY");
            			OracleParameter ACTY_CODE_1 = list.get(0); 
            			System.out.println("Dept Name = "+ACTY_CODE_1.getValue());
            			getCOMP_UI_M_ACTY_NAME().setSubmittedValue(ACTY_CODE_1.getValue());
		            }
		        }catch(Exception e)
		        {
		            e.printStackTrace();
		            throw e;
		        }
		    }
			public String PreviousPage(){
				CommonUtils utils = new CommonUtils();
				PM_IL_CLM_ACCOUNT_SETUP_SEARCH searchAction = (PM_IL_CLM_ACCOUNT_SETUP_SEARCH) utils.getMappedBeanFromSession("PILM024_PM_IL_CLM_ACCOUNT_SETUP_SEARCH");
				searchAction.fetchPolicyDetails();
				return "PILM024PreviousPage";
			}
						
			public void onLoad(PhaseEvent event) {
				try {
					if(isFormFlag()){
						//	PRE FORM 
						preForm(event);
						setFormFlag(false);
					}
					if (isBlockFlag()) {
							PM_IL_CLM_ACCOUNT_SETUP_SEARCH searchAction = new PM_IL_CLM_ACCOUNT_SETUP_SEARCH(); 
							searchAction.prepareDetails(compositeAction.getPM_IL_CLM_ACCOUNT_SETUP_ACTION_BEAN().getPM_IL_CLM_ACCOUNT_SETUP_BEAN().getROWID(), compositeAction.getPM_IL_CLM_ACCOUNT_SETUP_ACTION_BEAN().getPM_IL_CLM_ACCOUNT_SETUP_BEAN());
							if(PM_IL_CLM_ACCOUNT_SETUP_BEAN.getROWID()!=null){
								L_SET_SUB_ACCOUNT();
								pilm024_pm_il_clm_account_setup_post_query();
							} else {
								pilm024_pm_il_clm_account_setup_when_create_record();
							}
							pilm024_pm_il_clm_account_setup_when_new_record_instance();
						setBlockFlag(false);
					}
				} catch (Exception e) {
					e.printStackTrace();
					getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							e.getMessage());
					getErrorMap().put("onLoad", e.getMessage());
				}
			}
			
}
