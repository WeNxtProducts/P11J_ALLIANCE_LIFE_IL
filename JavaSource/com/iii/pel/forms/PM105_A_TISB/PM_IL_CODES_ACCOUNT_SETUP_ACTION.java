package com.iii.pel.forms.PM105_A_TISB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;
import com.vembu.plsql.runtime.functions.MigratingFunctions;
import com.vembu.plsql.runtime.functions.StringFunctions;

public class PM_IL_CODES_ACCOUNT_SETUP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CACS_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_CACS_FRZ_FLAG;

	private HtmlOutputLabel COMP_CACS_SRC_BUS_FM_LABEL;

	private HtmlInputText COMP_CACS_SRC_BUS_FM;

	private HtmlOutputLabel COMP_CACS_SRC_BUS_TO_LABEL;

	private HtmlInputText COMP_CACS_SRC_BUS_TO;

	private HtmlOutputLabel COMP_CACS_BUS_FM_CODE_LABEL;

	private HtmlInputText COMP_CACS_BUS_FM_CODE;

	private HtmlOutputLabel COMP_CACS_BUS_TO_CODE_LABEL;

	private HtmlInputText COMP_CACS_BUS_TO_CODE;

	private HtmlOutputLabel COMP_CACS_DIVN_FM_CODE_LABEL;

	private HtmlInputText COMP_CACS_DIVN_FM_CODE;

	private HtmlOutputLabel COMP_CACS_DIVN_TO_CODE_LABEL;

	private HtmlInputText COMP_CACS_DIVN_TO_CODE;

	private HtmlOutputLabel COMP_CACS_DEPT_FM_CODE_LABEL;

	private HtmlInputText COMP_CACS_DEPT_FM_CODE;

	private HtmlOutputLabel COMP_CACS_DEPT_TO_CODE_LABEL;

	private HtmlInputText COMP_CACS_DEPT_TO_CODE;

	private HtmlOutputLabel COMP_CACS_SETUP_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_CACS_SETUP_TYPE;

	private HtmlOutputLabel COMP_CACS_FORCE_DIVN_YN_LABEL;

	private HtmlSelectOneMenu COMP_CACS_FORCE_DIVN_YN;

	private HtmlOutputLabel COMP_CACS_FORCE_DEPT_YN_LABEL;

	private HtmlSelectOneMenu COMP_CACS_FORCE_DEPT_YN;

	private HtmlOutputLabel COMP_CACS_MAIN_ACNT_CODE_LABEL;

	private HtmlInputText COMP_CACS_MAIN_ACNT_CODE;

	private HtmlOutputLabel COMP_UI_M_MAIN_ACNT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_MAIN_ACNT_NAME;

	private HtmlOutputLabel COMP_CACS_SUB_ACNT_CODE_LABEL;

	private HtmlInputText COMP_CACS_SUB_ACNT_CODE;

	private HtmlOutputLabel COMP_UI_M_SUB_ACNT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_SUB_ACNT_NAME;

	private HtmlOutputLabel COMP_CACS_DIVN_CODE_LABEL;

	private HtmlInputText COMP_CACS_DIVN_CODE;

	private HtmlOutputLabel COMP_UI_M_DIVN_NAME_LABEL;

	private HtmlInputText COMP_UI_M_DIVN_NAME;

	private HtmlOutputLabel COMP_CACS_DEPT_CODE_LABEL;

	private HtmlInputText COMP_CACS_DEPT_CODE;

	private HtmlOutputLabel COMP_UI_M_DEPT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_DEPT_NAME;

	private HtmlOutputLabel COMP_CACS_ANLY_CODE_1_LABEL;

	private HtmlInputText COMP_CACS_ANLY_CODE_1;

	private HtmlOutputLabel COMP_UI_M_ANLY_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ANLY_NAME;

	private HtmlOutputLabel COMP_CACS_ANLY_CODE_2_LABEL;

	private HtmlInputText COMP_CACS_ANLY_CODE_2;

	private HtmlOutputLabel COMP_UI_M_ANLY_NAME_1_LABEL;

	private HtmlInputText COMP_UI_M_ANLY_NAME_1;

	private HtmlOutputLabel COMP_CACS_ACTY_CODE_1_LABEL;

	private HtmlInputText COMP_CACS_ACTY_CODE_1;

	private HtmlOutputLabel COMP_UI_M_ACTY_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ACTY_NAME;

	private HtmlOutputLabel COMP_CACS_ACTY_CODE_2_LABEL;

	private HtmlInputText COMP_CACS_ACTY_CODE_2;

	private HtmlOutputLabel COMP_UI_M_ACTY_NAME_1_LABEL;

	private HtmlInputText COMP_UI_M_ACTY_NAME_1;

	private HtmlCommandButton COMP_UI_M_BUT_DEPT;

	private HtmlCommandButton COMP_UI_M_BUT_DIVN;

	private HtmlCommandButton COMP_UI_M_BUT_SUB_ACNT;

	private HtmlCommandButton COMP_UI_M_BUT_CACS_SRC_BUS_FM;

	private HtmlCommandButton COMP_UI_M_BUT_CACS_SRC_BUS_TO;

	private HtmlCommandButton COMP_UI_M_BUT_CACS_BUS_FM_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_CACS_BUS_TO_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_ACTY_2;

	private HtmlCommandButton COMP_UI_M_BUT_ACTY_1;

	private HtmlCommandButton COMP_UI_M_BUT_ANAL_1;

	private HtmlCommandButton COMP_UI_M_BUT_ANAL_2;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN_ACNT;

	private HtmlCommandButton COMP_UI_M_BUT_DEPT_TO;

	private HtmlCommandButton COMP_UI_M_BUT_DEPT_FM;

	private HtmlCommandButton COMP_UI_M_BUT_DIVN_TO;

	private HtmlCommandButton COMP_UI_M_BUT_DIVN_FM;

	private PM_IL_CODES_ACCOUNT_SETUP PM_IL_CODES_ACCOUNT_SETUP_BEAN;
	
	private ArrayList<SelectItem> setupTypeList;
	private List<SelectItem> divisionTypeList = new ArrayList<SelectItem>();
	private List<SelectItem> departmentTypeList = new ArrayList<SelectItem>();
	
	CRUDHandler handler = new CRUDHandler();
	ResultSet rs= null;
	private Connection connection = null;
	private String errMsg;
	DUMMY DUMMY_BEAN;
	BP BP_BEAN;
	

	public PM_IL_CODES_ACCOUNT_SETUP_ACTION() throws Exception {
		DUMMY_BEAN = new DUMMY();
		BP_BEAN = new BP();
		PM_IL_CODES_ACCOUNT_SETUP_BEAN = new PM_IL_CODES_ACCOUNT_SETUP();
		
		setupTypeList = selectValueForComboBox("PM105_A_APAC",
				"PM_IL_CODES_ACCOUNT_SETUP", "PM_IL_CODES_ACCOUNT_SETUP.CACS_SETUP_TYPE");
		//preForm();
			prepareDropDowns();
	}

	private void prepareDropDowns(){
		try{
			Connection connection = CommonUtils.getConnection();
			setDivisionTypeList(ListItemUtil.getDropDownListValue_1(connection, "PM105_A_APAC", 
					"PM_IL_CODES_ACCOUNT_SETUP", "PM_IL_CODES_ACCOUNT_SETUP.CACS_FORCE_DIVN_YN", null));
			setDepartmentTypeList(ListItemUtil.getDropDownListValue_1(connection, "PM105_A_APAC", "PM_IL_CODES_ACCOUNT_SETUP",
					"PM_IL_CODES_ACCOUNT_SETUP.CACS_FORCE_DEPT_YN", null));
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public HtmlOutputLabel getCOMP_CACS_FRZ_FLAG_LABEL() {
		return COMP_CACS_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_CACS_FRZ_FLAG() {
		return COMP_CACS_FRZ_FLAG;
	}

	public void setCOMP_CACS_FRZ_FLAG_LABEL(HtmlOutputLabel COMP_CACS_FRZ_FLAG_LABEL) {
		this.COMP_CACS_FRZ_FLAG_LABEL = COMP_CACS_FRZ_FLAG_LABEL;
	}

	public void setCOMP_CACS_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_CACS_FRZ_FLAG) {
		this.COMP_CACS_FRZ_FLAG = COMP_CACS_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_CACS_SRC_BUS_FM_LABEL() {
		return COMP_CACS_SRC_BUS_FM_LABEL;
	}

	public HtmlInputText getCOMP_CACS_SRC_BUS_FM() {
		return COMP_CACS_SRC_BUS_FM;
	}

	public void setCOMP_CACS_SRC_BUS_FM_LABEL(HtmlOutputLabel COMP_CACS_SRC_BUS_FM_LABEL) {
		this.COMP_CACS_SRC_BUS_FM_LABEL = COMP_CACS_SRC_BUS_FM_LABEL;
	}

	public void setCOMP_CACS_SRC_BUS_FM(HtmlInputText COMP_CACS_SRC_BUS_FM) {
		this.COMP_CACS_SRC_BUS_FM = COMP_CACS_SRC_BUS_FM;
	}

	public HtmlOutputLabel getCOMP_CACS_SRC_BUS_TO_LABEL() {
		return COMP_CACS_SRC_BUS_TO_LABEL;
	}

	public HtmlInputText getCOMP_CACS_SRC_BUS_TO() {
		return COMP_CACS_SRC_BUS_TO;
	}

	public void setCOMP_CACS_SRC_BUS_TO_LABEL(HtmlOutputLabel COMP_CACS_SRC_BUS_TO_LABEL) {
		this.COMP_CACS_SRC_BUS_TO_LABEL = COMP_CACS_SRC_BUS_TO_LABEL;
	}

	public void setCOMP_CACS_SRC_BUS_TO(HtmlInputText COMP_CACS_SRC_BUS_TO) {
		this.COMP_CACS_SRC_BUS_TO = COMP_CACS_SRC_BUS_TO;
	}

	public HtmlOutputLabel getCOMP_CACS_BUS_FM_CODE_LABEL() {
		return COMP_CACS_BUS_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CACS_BUS_FM_CODE() {
		return COMP_CACS_BUS_FM_CODE;
	}

	public void setCOMP_CACS_BUS_FM_CODE_LABEL(HtmlOutputLabel COMP_CACS_BUS_FM_CODE_LABEL) {
		this.COMP_CACS_BUS_FM_CODE_LABEL = COMP_CACS_BUS_FM_CODE_LABEL;
	}

	public void setCOMP_CACS_BUS_FM_CODE(HtmlInputText COMP_CACS_BUS_FM_CODE) {
		this.COMP_CACS_BUS_FM_CODE = COMP_CACS_BUS_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_CACS_BUS_TO_CODE_LABEL() {
		return COMP_CACS_BUS_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CACS_BUS_TO_CODE() {
		return COMP_CACS_BUS_TO_CODE;
	}

	public void setCOMP_CACS_BUS_TO_CODE_LABEL(HtmlOutputLabel COMP_CACS_BUS_TO_CODE_LABEL) {
		this.COMP_CACS_BUS_TO_CODE_LABEL = COMP_CACS_BUS_TO_CODE_LABEL;
	}

	public void setCOMP_CACS_BUS_TO_CODE(HtmlInputText COMP_CACS_BUS_TO_CODE) {
		this.COMP_CACS_BUS_TO_CODE = COMP_CACS_BUS_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_CACS_DIVN_FM_CODE_LABEL() {
		return COMP_CACS_DIVN_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CACS_DIVN_FM_CODE() {
		return COMP_CACS_DIVN_FM_CODE;
	}

	public void setCOMP_CACS_DIVN_FM_CODE_LABEL(HtmlOutputLabel COMP_CACS_DIVN_FM_CODE_LABEL) {
		this.COMP_CACS_DIVN_FM_CODE_LABEL = COMP_CACS_DIVN_FM_CODE_LABEL;
	}

	public void setCOMP_CACS_DIVN_FM_CODE(HtmlInputText COMP_CACS_DIVN_FM_CODE) {
		this.COMP_CACS_DIVN_FM_CODE = COMP_CACS_DIVN_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_CACS_DIVN_TO_CODE_LABEL() {
		return COMP_CACS_DIVN_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CACS_DIVN_TO_CODE() {
		return COMP_CACS_DIVN_TO_CODE;
	}

	public void setCOMP_CACS_DIVN_TO_CODE_LABEL(HtmlOutputLabel COMP_CACS_DIVN_TO_CODE_LABEL) {
		this.COMP_CACS_DIVN_TO_CODE_LABEL = COMP_CACS_DIVN_TO_CODE_LABEL;
	}

	public void setCOMP_CACS_DIVN_TO_CODE(HtmlInputText COMP_CACS_DIVN_TO_CODE) {
		this.COMP_CACS_DIVN_TO_CODE = COMP_CACS_DIVN_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_CACS_DEPT_FM_CODE_LABEL() {
		return COMP_CACS_DEPT_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CACS_DEPT_FM_CODE() {
		return COMP_CACS_DEPT_FM_CODE;
	}

	public void setCOMP_CACS_DEPT_FM_CODE_LABEL(HtmlOutputLabel COMP_CACS_DEPT_FM_CODE_LABEL) {
		this.COMP_CACS_DEPT_FM_CODE_LABEL = COMP_CACS_DEPT_FM_CODE_LABEL;
	}

	public void setCOMP_CACS_DEPT_FM_CODE(HtmlInputText COMP_CACS_DEPT_FM_CODE) {
		this.COMP_CACS_DEPT_FM_CODE = COMP_CACS_DEPT_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_CACS_DEPT_TO_CODE_LABEL() {
		return COMP_CACS_DEPT_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CACS_DEPT_TO_CODE() {
		return COMP_CACS_DEPT_TO_CODE;
	}

	public void setCOMP_CACS_DEPT_TO_CODE_LABEL(HtmlOutputLabel COMP_CACS_DEPT_TO_CODE_LABEL) {
		this.COMP_CACS_DEPT_TO_CODE_LABEL = COMP_CACS_DEPT_TO_CODE_LABEL;
	}

	public void setCOMP_CACS_DEPT_TO_CODE(HtmlInputText COMP_CACS_DEPT_TO_CODE) {
		this.COMP_CACS_DEPT_TO_CODE = COMP_CACS_DEPT_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_CACS_SETUP_TYPE_LABEL() {
		return COMP_CACS_SETUP_TYPE_LABEL;
	}

	
	public void setCOMP_CACS_SETUP_TYPE_LABEL(HtmlOutputLabel COMP_CACS_SETUP_TYPE_LABEL) {
		this.COMP_CACS_SETUP_TYPE_LABEL = COMP_CACS_SETUP_TYPE_LABEL;
	}

	

	public HtmlSelectOneMenu getCOMP_CACS_SETUP_TYPE() {
		return COMP_CACS_SETUP_TYPE;
	}

	public void setCOMP_CACS_SETUP_TYPE(HtmlSelectOneMenu comp_cacs_setup_type) {
		COMP_CACS_SETUP_TYPE = comp_cacs_setup_type;
	}

	public HtmlOutputLabel getCOMP_CACS_FORCE_DIVN_YN_LABEL() {
		return COMP_CACS_FORCE_DIVN_YN_LABEL;
	}



	public HtmlSelectOneMenu getCOMP_CACS_FORCE_DIVN_YN() {
		return COMP_CACS_FORCE_DIVN_YN;
	}

	public void setCOMP_CACS_FORCE_DIVN_YN(HtmlSelectOneMenu comp_cacs_force_divn_yn) {
		COMP_CACS_FORCE_DIVN_YN = comp_cacs_force_divn_yn;
	}

	public HtmlOutputLabel getCOMP_CACS_FORCE_DEPT_YN_LABEL() {
		return COMP_CACS_FORCE_DEPT_YN_LABEL;
	}

	public void setCOMP_CACS_FORCE_DEPT_YN_LABEL(
			HtmlOutputLabel comp_cacs_force_dept_yn_label) {
		COMP_CACS_FORCE_DEPT_YN_LABEL = comp_cacs_force_dept_yn_label;
	}

	public HtmlSelectOneMenu getCOMP_CACS_FORCE_DEPT_YN() {
		return COMP_CACS_FORCE_DEPT_YN;
	}

	public void setCOMP_CACS_FORCE_DEPT_YN(HtmlSelectOneMenu comp_cacs_force_dept_yn) {
		COMP_CACS_FORCE_DEPT_YN = comp_cacs_force_dept_yn;
	}

	public void setCOMP_CACS_FORCE_DIVN_YN_LABEL(HtmlOutputLabel COMP_CACS_FORCE_DIVN_YN_LABEL) {
		this.COMP_CACS_FORCE_DIVN_YN_LABEL = COMP_CACS_FORCE_DIVN_YN_LABEL;
	}

	
	public HtmlOutputLabel getCOMP_CACS_MAIN_ACNT_CODE_LABEL() {
		return COMP_CACS_MAIN_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CACS_MAIN_ACNT_CODE() {
		return COMP_CACS_MAIN_ACNT_CODE;
	}

	public void setCOMP_CACS_MAIN_ACNT_CODE_LABEL(HtmlOutputLabel COMP_CACS_MAIN_ACNT_CODE_LABEL) {
		this.COMP_CACS_MAIN_ACNT_CODE_LABEL = COMP_CACS_MAIN_ACNT_CODE_LABEL;
	}

	public void setCOMP_CACS_MAIN_ACNT_CODE(HtmlInputText COMP_CACS_MAIN_ACNT_CODE) {
		this.COMP_CACS_MAIN_ACNT_CODE = COMP_CACS_MAIN_ACNT_CODE;
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

	public HtmlOutputLabel getCOMP_CACS_SUB_ACNT_CODE_LABEL() {
		return COMP_CACS_SUB_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CACS_SUB_ACNT_CODE() {
		return COMP_CACS_SUB_ACNT_CODE;
	}

	public void setCOMP_CACS_SUB_ACNT_CODE_LABEL(HtmlOutputLabel COMP_CACS_SUB_ACNT_CODE_LABEL) {
		this.COMP_CACS_SUB_ACNT_CODE_LABEL = COMP_CACS_SUB_ACNT_CODE_LABEL;
	}

	public void setCOMP_CACS_SUB_ACNT_CODE(HtmlInputText COMP_CACS_SUB_ACNT_CODE) {
		this.COMP_CACS_SUB_ACNT_CODE = COMP_CACS_SUB_ACNT_CODE;
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

	public HtmlOutputLabel getCOMP_CACS_DIVN_CODE_LABEL() {
		return COMP_CACS_DIVN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CACS_DIVN_CODE() {
		return COMP_CACS_DIVN_CODE;
	}

	public void setCOMP_CACS_DIVN_CODE_LABEL(HtmlOutputLabel COMP_CACS_DIVN_CODE_LABEL) {
		this.COMP_CACS_DIVN_CODE_LABEL = COMP_CACS_DIVN_CODE_LABEL;
	}

	public void setCOMP_CACS_DIVN_CODE(HtmlInputText COMP_CACS_DIVN_CODE) {
		this.COMP_CACS_DIVN_CODE = COMP_CACS_DIVN_CODE;
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

	public HtmlOutputLabel getCOMP_CACS_DEPT_CODE_LABEL() {
		return COMP_CACS_DEPT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CACS_DEPT_CODE() {
		return COMP_CACS_DEPT_CODE;
	}

	public void setCOMP_CACS_DEPT_CODE_LABEL(HtmlOutputLabel COMP_CACS_DEPT_CODE_LABEL) {
		this.COMP_CACS_DEPT_CODE_LABEL = COMP_CACS_DEPT_CODE_LABEL;
	}

	public void setCOMP_CACS_DEPT_CODE(HtmlInputText COMP_CACS_DEPT_CODE) {
		this.COMP_CACS_DEPT_CODE = COMP_CACS_DEPT_CODE;
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

	public HtmlOutputLabel getCOMP_CACS_ANLY_CODE_1_LABEL() {
		return COMP_CACS_ANLY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_CACS_ANLY_CODE_1() {
		return COMP_CACS_ANLY_CODE_1;
	}

	public void setCOMP_CACS_ANLY_CODE_1_LABEL(HtmlOutputLabel COMP_CACS_ANLY_CODE_1_LABEL) {
		this.COMP_CACS_ANLY_CODE_1_LABEL = COMP_CACS_ANLY_CODE_1_LABEL;
	}

	public void setCOMP_CACS_ANLY_CODE_1(HtmlInputText COMP_CACS_ANLY_CODE_1) {
		this.COMP_CACS_ANLY_CODE_1 = COMP_CACS_ANLY_CODE_1;
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

	public HtmlOutputLabel getCOMP_CACS_ANLY_CODE_2_LABEL() {
		return COMP_CACS_ANLY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_CACS_ANLY_CODE_2() {
		return COMP_CACS_ANLY_CODE_2;
	}

	public void setCOMP_CACS_ANLY_CODE_2_LABEL(HtmlOutputLabel COMP_CACS_ANLY_CODE_2_LABEL) {
		this.COMP_CACS_ANLY_CODE_2_LABEL = COMP_CACS_ANLY_CODE_2_LABEL;
	}

	public void setCOMP_CACS_ANLY_CODE_2(HtmlInputText COMP_CACS_ANLY_CODE_2) {
		this.COMP_CACS_ANLY_CODE_2 = COMP_CACS_ANLY_CODE_2;
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

	public HtmlOutputLabel getCOMP_CACS_ACTY_CODE_1_LABEL() {
		return COMP_CACS_ACTY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_CACS_ACTY_CODE_1() {
		return COMP_CACS_ACTY_CODE_1;
	}

	public void setCOMP_CACS_ACTY_CODE_1_LABEL(HtmlOutputLabel COMP_CACS_ACTY_CODE_1_LABEL) {
		this.COMP_CACS_ACTY_CODE_1_LABEL = COMP_CACS_ACTY_CODE_1_LABEL;
	}

	public void setCOMP_CACS_ACTY_CODE_1(HtmlInputText COMP_CACS_ACTY_CODE_1) {
		this.COMP_CACS_ACTY_CODE_1 = COMP_CACS_ACTY_CODE_1;
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

	public HtmlOutputLabel getCOMP_CACS_ACTY_CODE_2_LABEL() {
		return COMP_CACS_ACTY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_CACS_ACTY_CODE_2() {
		return COMP_CACS_ACTY_CODE_2;
	}

	public void setCOMP_CACS_ACTY_CODE_2_LABEL(HtmlOutputLabel COMP_CACS_ACTY_CODE_2_LABEL) {
		this.COMP_CACS_ACTY_CODE_2_LABEL = COMP_CACS_ACTY_CODE_2_LABEL;
	}

	public void setCOMP_CACS_ACTY_CODE_2(HtmlInputText COMP_CACS_ACTY_CODE_2) {
		this.COMP_CACS_ACTY_CODE_2 = COMP_CACS_ACTY_CODE_2;
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

	public HtmlCommandButton getCOMP_UI_M_BUT_DEPT() {
		return COMP_UI_M_BUT_DEPT;
	}

	public void setCOMP_UI_M_BUT_DEPT(HtmlCommandButton COMP_UI_M_BUT_DEPT) {
		this.COMP_UI_M_BUT_DEPT = COMP_UI_M_BUT_DEPT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DIVN() {
		return COMP_UI_M_BUT_DIVN;
	}

	public void setCOMP_UI_M_BUT_DIVN(HtmlCommandButton COMP_UI_M_BUT_DIVN) {
		this.COMP_UI_M_BUT_DIVN = COMP_UI_M_BUT_DIVN;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_SUB_ACNT() {
		return COMP_UI_M_BUT_SUB_ACNT;
	}

	public void setCOMP_UI_M_BUT_SUB_ACNT(HtmlCommandButton COMP_UI_M_BUT_SUB_ACNT) {
		this.COMP_UI_M_BUT_SUB_ACNT = COMP_UI_M_BUT_SUB_ACNT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CACS_SRC_BUS_FM() {
		return COMP_UI_M_BUT_CACS_SRC_BUS_FM;
	}

	public void setCOMP_UI_M_BUT_CACS_SRC_BUS_FM(HtmlCommandButton COMP_UI_M_BUT_CACS_SRC_BUS_FM) {
		this.COMP_UI_M_BUT_CACS_SRC_BUS_FM = COMP_UI_M_BUT_CACS_SRC_BUS_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CACS_SRC_BUS_TO() {
		return COMP_UI_M_BUT_CACS_SRC_BUS_TO;
	}

	public void setCOMP_UI_M_BUT_CACS_SRC_BUS_TO(HtmlCommandButton COMP_UI_M_BUT_CACS_SRC_BUS_TO) {
		this.COMP_UI_M_BUT_CACS_SRC_BUS_TO = COMP_UI_M_BUT_CACS_SRC_BUS_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CACS_BUS_FM_CODE() {
		return COMP_UI_M_BUT_CACS_BUS_FM_CODE;
	}

	public void setCOMP_UI_M_BUT_CACS_BUS_FM_CODE(HtmlCommandButton COMP_UI_M_BUT_CACS_BUS_FM_CODE) {
		this.COMP_UI_M_BUT_CACS_BUS_FM_CODE = COMP_UI_M_BUT_CACS_BUS_FM_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CACS_BUS_TO_CODE() {
		return COMP_UI_M_BUT_CACS_BUS_TO_CODE;
	}

	public void setCOMP_UI_M_BUT_CACS_BUS_TO_CODE(HtmlCommandButton COMP_UI_M_BUT_CACS_BUS_TO_CODE) {
		this.COMP_UI_M_BUT_CACS_BUS_TO_CODE = COMP_UI_M_BUT_CACS_BUS_TO_CODE;
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

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN_ACNT() {
		return COMP_UI_M_BUT_MAIN_ACNT;
	}

	public void setCOMP_UI_M_BUT_MAIN_ACNT(HtmlCommandButton COMP_UI_M_BUT_MAIN_ACNT) {
		this.COMP_UI_M_BUT_MAIN_ACNT = COMP_UI_M_BUT_MAIN_ACNT;
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

	public PM_IL_CODES_ACCOUNT_SETUP getPM_IL_CODES_ACCOUNT_SETUP_BEAN() {
		return PM_IL_CODES_ACCOUNT_SETUP_BEAN;
	}

	public void setPM_IL_CODES_ACCOUNT_SETUP_BEAN(PM_IL_CODES_ACCOUNT_SETUP PM_IL_CODES_ACCOUNT_SETUP_BEAN) {
		this.PM_IL_CODES_ACCOUNT_SETUP_BEAN = PM_IL_CODES_ACCOUNT_SETUP_BEAN;
	}
	public String insertNavigation() throws Exception{
		return "GO_TO_PM105_A_TISB_PM_IL_CODES_ACCOUNT_SETUP";
	}
	
	public String goSearch(){
		System.out.println("+++++++++++++++++++++++++goSearch()++++++++++++++++++++++");
		return"GO_TO_PM105_A_TISB_PM_IL_CODES_ACCOUNT_SETUP_SEARCH_PAGE";
	}

	//lov for - Source of Business Range
	public List CACS_SRC_BUS_FM_lovAction(Object obj)throws Exception {
		System.out.println("PM_IL_CODES_ACCOUNT_SETUP_ACTION.CACS_SRC_BUS_FM_lovAction()");
		List lovList = new ArrayList();
		System.out.println("OBJECT VLAUE"+obj.toString());
		String query =null;
		if(obj.toString().equals("*")){
			query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE='SRC_BUS_TY' AND NVL(PC_FRZ_FLAG,'N') = 'N'";
		}else{
			query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE='SRC_BUS_TY' AND NVL(PC_FRZ_FLAG,'N') = 'N' AND (PC_CODE LIKE('"+obj.toString()+"%') OR  PC_DESC LIKE('"+obj.toString()+"%')) ";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CACS_SRC_BUS_FM_LOV lovBox = new CACS_SRC_BUS_FM_LOV(); 
			lovBox.setPC_CODE(rs.getString("PC_CODE"));
			lovBox.setPC_DESC(rs.getString("PC_DESC"));
			lovList.add(lovBox);
		}
		System.out.println("list size-----CACS_SRC_BUS_FM--------"+lovList.size());
		rs.close();
		//connection.close();
		//CommonUtils.getConnection().close();
		return lovList;
	}
	
	//lov for - Business Range
	public List CACS_BUS_FM_lovAction(Object obj)throws Exception {
		System.out.println("PM_IL_CODES_ACCOUNT_SETUP_ACTION.CACS_BUS_FM_lovAction()");
		List lovList = new ArrayList();
		System.out.println("OBJECT VLAUE"+obj.toString());
		String query =null;
		if(obj.toString().equals("*")){
			query = "SELECT PS_CODE,PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE='IL_BUSINES'";
		}else{
			query = "SELECT PS_CODE,PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE='IL_BUSINES' AND (PS_CODE LIKE('"+obj.toString()+"%') OR  PS_CODE_DESC LIKE('"+obj.toString()+"%')) ";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CACS_BUS_FM_LOV lovBox = new CACS_BUS_FM_LOV(); 
			lovBox.setPC_CODE(rs.getString("PS_CODE"));
			lovBox.setPC_DESC(rs.getString("PS_CODE_DESC"));
			lovList.add(lovBox);
		}
		System.out.println("list size-----CACS_BUS_FM_--------"+lovList.size());
		rs.close();
		//connection.close();
		return lovList;
	}
	//lov for - Branch Range
	public List CACS_DIVN_FM_CODE_lovAction(Object obj)throws Exception {
		System.out.println("PM_IL_CODES_ACCOUNT_SETUP_ACTION.CACS_DIVN_FM_CODE_lovAction()");
		List lovList = new ArrayList();
		String query =null;
		/*[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DIVISION to FM_DIVISION. Added by : Mallika.S, 31-Mar-2009 */
		if(obj.toString().equals("*")){
			query = "select DIVN_CODE,DIVN_NAME from FM_DIVISION where DIVN_COMP_CODE ='001' AND NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND" +
			" EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DIVN_CODE AND ADS_USER_ID = ADS_USER_ID AND ADS_FRZ_FLAG = 'N')";
		}else{
			query = "select DIVN_CODE,DIVN_NAME from FM_DIVISION where DIVN_COMP_CODE ='001' AND NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND" +
			" EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DIVN_CODE AND ADS_USER_ID = ADS_USER_ID AND ADS_FRZ_FLAG = 'N') AND (DIVN_CODE LIKE('"+obj.toString()+"%') OR DIVN_NAME LIKE('"+obj.toString()+"%'))";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CACS_DIVN_FM_CODE_LOV lovBox = new CACS_DIVN_FM_CODE_LOV(); 
			lovBox.setDIVN_CODE(rs.getString("DIVN_CODE"));
			lovBox.setDIVN_NAME(rs.getString("DIVN_NAME"));
			lovList.add(lovBox);
		}
		System.out.println("list size-----CACS_DIVN_FM_CODE--------"+lovList.size());
		rs.close();
		return lovList;
	}
	//lov for - Department Range
	public List CACS_DEPT_FM_CODE_lovAction(Object obj)throws Exception {
		String query =null;
		List lovList = new ArrayList();
		System.out.println("PM_IL_CODES_ACCOUNT_SETUP_ACTION.CACS_DEPT_FM_CODE_lovAction()3-"+getCOMP_CACS_DIVN_FM_CODE().getValue());
		/*[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DEPARTMENT to FM_DEPARTMENT. Added by : Mallika.S, 31-Mar-2009 */
		if(obj.toString().equals("*")){
			query = "select DEPT_CODE,DEPT_NAME from FM_DEPARTMENT where DEPT_COMP_CODE = '001' AND " +
			" DEPT_DIVN_CODE = '"+getCOMP_CACS_DIVN_FM_CODE().getValue()+"' AND DEPT_FRZ_FLAG  = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE" +
			" ADS_DIVN_CODE = DEPT_DIVN_CODE AND ADS_DEPT_CODE = DEPT_CODE AND ADS_USER_ID = ADS_USER_ID AND" +
			" ADS_FRZ_FLAG = 'N')";
		}else{
			query = "select DEPT_CODE,DEPT_NAME from FM_DEPARTMENT where DEPT_COMP_CODE = '001' AND " +
			" DEPT_DIVN_CODE = '"+getCOMP_CACS_DIVN_FM_CODE().getValue()+"' AND DEPT_FRZ_FLAG  = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE" +
			" ADS_DIVN_CODE = DEPT_DIVN_CODE AND ADS_DEPT_CODE = DEPT_CODE AND ADS_USER_ID = ADS_USER_ID AND" +
			" ADS_FRZ_FLAG = 'N') AND (DEPT_CODE LIKE('"+obj.toString()+"%')OR DEPT_NAME LIKE('"+obj.toString()+"%'))";
		}
		System.out.println("PM_IL_CODES_ACCOUNT_SETUP_A----------CTION.CACS_DEPT_FM_CODE_lovAction()");
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CACS_DEPT_FM_CODE_LOV lovBox = new CACS_DEPT_FM_CODE_LOV(); 
			lovBox.setDEPT_CODE(rs.getString("DEPT_CODE"));
			lovBox.setDEPT_NAME(rs.getString("DEPT_NAME"));
			lovList.add(lovBox);
		}
		System.out.println("list size-----CACS_DEPT_FM_CODE--------"+lovList.size());
		rs.close();
		return lovList;
	}
	//lov for - Main/Control a/c 
	public List CACS_MAIN_ACNT_CODE_lovAction(Object obj)throws Exception {
		List lovList = new ArrayList();
		String query =null;
		if(obj.toString().equals("*")){
			query = "select MAIN_ACNT_CODE,MAIN_ACNT_NAME from FM_MAIN_ACCOUNT where NVL(MAIN_FRZ_FLAG,'N') = 'N' AND ROWNUM<25";
		}else{
			query = "select MAIN_ACNT_CODE,MAIN_ACNT_NAME from FM_MAIN_ACCOUNT where NVL(MAIN_FRZ_FLAG,'N') = 'N' AND (MAIN_ACNT_CODE LIKE('"+obj.toString()+"%') OR MAIN_ACNT_NAME LIKE('"+obj.toString()+"%')) AND ROWNUM<25 ";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){

			CACS_MAIN_ACNT_CODE_LOV lovBox = new CACS_MAIN_ACNT_CODE_LOV(); 
			lovBox.setMAIN_ACNT_CODE(rs.getString("MAIN_ACNT_CODE"));
			lovBox.setMAIN_ACNT_NAME(rs.getString("MAIN_ACNT_NAME"));
			lovList.add(lovBox);
		}
		System.out.println("list size-----CACS_MAIN_ACNT_CODE--------"+lovList.size());
		rs.close();
		return lovList;
	}
	
	
	//lov for - sub a/c
	public List CACS_SUB_ACNT_CODE_lovAction(Object obj)throws Exception {
		System.out.println("111111111111 MAIN ACNT CODE 111111111---"+getCOMP_CACS_MAIN_ACNT_CODE().getSubmittedValue());
		System.out.println("main value::::::::::::::::::::"+getPM_IL_CODES_ACCOUNT_SETUP_BEAN().getCACS_MAIN_ACNT_CODE());
		String mainAccoutCode = PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_MAIN_ACNT_CODE();
		List lovList = new ArrayList();
		String query =null;
		if(obj.toString().equals("*")){
			query =  "SELECT sub_acnt_code, sub_acnt_name FROM fm_sub_account WHERE SUB_ACNT_CODE IN (SELECT MS_SUB_ACNT_CODE " +
			" FROM  FM_MAIN_SUB WHERE MS_MAIN_ACNT_CODE = '"+mainAccoutCode+"') AND	NVL(SUB_FRZ_FLAG,'N') = 'N' AND ROWNUM<25";
		}else{
			query =  "SELECT sub_acnt_code, sub_acnt_name FROM fm_sub_account WHERE SUB_ACNT_CODE IN (SELECT MS_SUB_ACNT_CODE " +
			" FROM  FM_MAIN_SUB WHERE MS_MAIN_ACNT_CODE = '"+mainAccoutCode+"') AND	NVL(SUB_FRZ_FLAG,'N') = 'N' AND (sub_acnt_code LIKE('"+obj.toString()+"%') OR sub_acnt_name LIKE('"+obj.toString()+"%')) AND ROWNUM<25";
		}
		System.out.println("sub act query>>>>>>>>>>"+query);
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){

			CACS_SUB_ACNT_CODE_LOV lovBox = new CACS_SUB_ACNT_CODE_LOV(); 
			lovBox.setSUB_ACNT_CODE(rs.getString("SUB_ACNT_CODE"));
			lovBox.setSUB_ACNT_NAME(rs.getString("SUB_ACNT_NAME"));
			lovList.add(lovBox);
		}
		System.out.println("list size-----CACS_SUB_ACNT_CODE--------"+lovList.size());
		rs.close();
		return lovList;
	}
	//lov for - Branch
	public List CACS_DIV_CODE_lovAction(Object obj)throws Exception {
		List lovList = new ArrayList();
		String query =null;
		/*[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DIVISION to FM_DIVISION. Added by : Mallika.S, 31-Mar-2009 */
		if(obj.toString().equals("*")){
			query =  "select DIVN_CODE,DIVN_NAME from FM_DIVISION where DIVN_COMP_CODE = '001' AND " +
			" NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DIVN_CODE" +
			" AND ADS_USER_ID = ADS_USER_ID AND ADS_FRZ_FLAG = 'N') AND ROWNUM<25 ";
		}else{
			query =  "select DIVN_CODE,DIVN_NAME from FM_DIVISION where DIVN_COMP_CODE = '001' AND " +
			" NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DIVN_CODE" +
			" AND ADS_USER_ID = ADS_USER_ID AND ADS_FRZ_FLAG = 'N') AND (DIVN_CODE LIKE('"+obj.toString()+"%') OR DIVN_NAME LIKE('"+obj.toString()+"%')) AND ROWNUM<25 ";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CACS_DIVN_FM_CODE_LOV lovBox = new CACS_DIVN_FM_CODE_LOV(); 
			lovBox.setDIVN_CODE(rs.getString("DIVN_CODE"));
			lovBox.setDIVN_NAME(rs.getString("DIVN_NAME"));
			lovList.add(lovBox);
		}
		System.out.println("list size-----CACS_DIV_CODE--------"+lovList.size());
		rs.close();
		return lovList;
	}
	//lov for - Departmsss
	public List CACS_DEPT_CODE_lovAction(Object obj)throws Exception {
		List lovList = new ArrayList();
		String query =null;
		/*[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DEPARTMENT to FM_DEPARTMENT. Added by : Mallika.S, 31-Mar-2009 */
		if(obj.toString().equals("*")){
			query =  "select DEPT_CODE,DEPT_NAME from FM_DEPARTMENT where DEPT_COMP_CODE = '001' AND DEPT_DIVN_CODE = '"+PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DIVN_CODE()+"' AND" +
			" DEPT_FRZ_FLAG  = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DEPT_DIVN_CODE AND" +
			" ADS_DEPT_CODE = DEPT_CODE AND ADS_USER_ID = ADS_USER_ID AND ADS_FRZ_FLAG = 'N') AND ROWNUM<25 ";
		}else{
			query =  "select DEPT_CODE,DEPT_NAME from FM_DEPARTMENT where DEPT_COMP_CODE = '001' AND DEPT_DIVN_CODE = '"+PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DIVN_CODE()+"' AND" +
			" DEPT_FRZ_FLAG  = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DEPT_DIVN_CODE AND" +
			" ADS_DEPT_CODE = DEPT_CODE AND ADS_USER_ID = ADS_USER_ID AND ADS_FRZ_FLAG = 'N') AND (DEPT_CODE LIKE('"+obj.toString()+"%') OR DEPT_NAME LIKE('"+obj.toString()+"%')) AND ROWNUM<25";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CACS_DEPT_FM_CODE_LOV lovBox = new CACS_DEPT_FM_CODE_LOV(); 
			lovBox.setDEPT_CODE(rs.getString("DEPT_CODE"));
			lovBox.setDEPT_NAME(rs.getString("DEPT_NAME"));
			lovList.add(lovBox);
		}
		System.out.println("list size------CACS_DEPT_CODE-------"+lovList.size());
		rs.close();
		return lovList;
	}
	//lov for - t.Analysi
	public List CACS_ANLY_CODE_1_lovAction(Object obj)throws Exception {
		List lovList = new ArrayList();
		String query =null;
		if(obj.toString().equals("*")){
			query = "select ANLY_CODE,ANLY_NAME from FM_ANALYSIS where ANLY_HEAD_NO = '1' AND NVL(ANLY_FRZ_FLAG,'N') = 'N'AND ROWNUM<25 ";
		}else{
			query = "select ANLY_CODE,ANLY_NAME from FM_ANALYSIS where ANLY_HEAD_NO = '1' AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND (ANLY_CODE LIKE('"+obj.toString()+"%') OR ANLY_NAME LIKE('"+obj.toString()+"%')) AND ROWNUM<25 ";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CAS_ANLY_CODE_LOV lovBox = new CAS_ANLY_CODE_LOV(); 
			lovBox.setANLY_CODE(rs.getString("ANLY_CODE"));
			lovBox.setANLY_NAME(rs.getString("ANLY_NAME"));
			lovList.add(lovBox);
		}
		System.out.println("list size-----CACS_ANLY_CODE_1--------"+lovList.size());
		rs.close();
		return lovList;
	}
	//lov for - |-1Analysi
	public List CACS_ANLY_CODE_2_lovAction(Object obj)throws Exception {
		List lovList = new ArrayList();
		String query =null;
		if(obj.toString().equals("*")){
			query = "select ANLY_CODE,ANLY_NAME from FM_ANALYSIS where ANLY_HEAD_NO = '2' AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND ROWNUM<25 ";
		}else{
			query = "select ANLY_CODE,ANLY_NAME from FM_ANALYSIS where ANLY_HEAD_NO = '2' AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND (ANLY_CODE LIKE('"+obj.toString()+"%') OR ANLY_NAME LIKE('"+obj.toString()+"%')) AND ROWNUM<25 ";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CAS_ANLY_CODE_LOV lovBox = new CAS_ANLY_CODE_LOV(); 
			lovBox.setANLY_CODE(rs.getString("ANLY_CODE"));
			lovBox.setANLY_NAME(rs.getString("ANLY_NAME"));
			lovList.add(lovBox);
		}
		System.out.println("list size-----CACS_ANLY_CODE_2--------"+lovList.size());
		rs.close();
		return lovList;
	}
	//CACS_ACTY_CODE_1
	public List CACS_ACTY_CODE_1_lovAction(Object obj)throws Exception {
		System.out.println("activity 1 sugg........................................"+obj);
		List lovList = new ArrayList();
		String query =null;
		if(obj.toString().equals("*")){
			System.out.println("DUMMY_BEAN.getM_ACTY_HEAD_1()"+DUMMY_BEAN.getM_ACTY_HEAD_1());
			query = "select AVAL_CODE,AVAL_VALUE_NAME from FM_ACTY_VALUE where AVAL_ACTY_CODE='"+DUMMY_BEAN.getM_ACTY_HEAD_1()+"' AND ROWNUM<25";
		}else{
			query = "select AVAL_CODE,AVAL_VALUE_NAME from FM_ACTY_VALUE where AVAL_ACTY_CODE='"+DUMMY_BEAN.getM_ACTY_HEAD_1()+"' AND (AVAL_CODE LIKE('"+obj.toString()+"%') OR AVAL_VALUE_NAME LIKE('"+obj.toString()+"%')) AND ROWNUM<25 ";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CACS_ACTY_CODE_LOV lovBox = new CACS_ACTY_CODE_LOV(); 
			lovBox.setAVAL_CODE(rs.getString("AVAL_CODE"));
			lovBox.setAVAL_VALUE_NAME(rs.getString("AVAL_VALUE_NAME"));
			lovList.add(lovBox);
		}
		System.out.println("list size------CACS_ACTY_CODE_1-------"+lovList.size());
		rs.close();
		return lovList;
	}
	//CACS_ACTY_CODE_2
	public List CACS_ACTY_CODE_2_lovAction(Object obj)throws Exception {
		List lovList = new ArrayList();
		String query =null;
		if(obj.toString().equals("*")){
			System.out.println("DUMMY_BEAN.getM_ACTY_HEAD_1()"+DUMMY_BEAN.getM_ACTY_HEAD_1());
			query = "select AVAL_CODE,AVAL_VALUE_NAME from FM_ACTY_VALUE where AVAL_ACTY_CODE='"+DUMMY_BEAN.getM_ACTY_HEAD_2()+"' AND ROWNUM<25 ";
		}else{
			query = "select AVAL_CODE,AVAL_VALUE_NAME from FM_ACTY_VALUE where AVAL_ACTY_CODE='"+DUMMY_BEAN.getM_ACTY_HEAD_1()+"' AND (AVAL_CODE LIKE('"+obj.toString()+"%') OR AVAL_VALUE_NAME LIKE('"+obj.toString()+"%')) AND ROWNUM<25 ";
		}
		connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			CACS_ACTY_CODE_LOV lovBox = new CACS_ACTY_CODE_LOV(); 
			lovBox.setAVAL_CODE(rs.getString("AVAL_CODE"));
			lovBox.setAVAL_VALUE_NAME(rs.getString("AVAL_VALUE_NAME"));
			lovList.add(lovBox);
		}
		System.out.println("list size------CACS_ACTY_CODE_2-------"+lovList.size());
		rs.close();
		return lovList;
	}
	
	
/************************** BLOCK TRIGGERS **********************************/	
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void CACS_SRC_BUS_FM_WhenValidateItem(ActionEvent ae)
	{
		System.out.println("CACS_SRC_BUS_FM: "+ COMP_CACS_SRC_BUS_FM.getSubmittedValue());
		if("".equals(getCOMP_CACS_SRC_BUS_FM().getSubmittedValue().toString().trim())){
			getCOMP_CACS_SRC_BUS_FM().setSubmittedValue("0");
			getCOMP_CACS_SRC_BUS_FM().updateModel(FacesContext.getCurrentInstance());
		}else{
			UIInput input = (UIInput) ae.getComponent().getParent(); // Ajax4jsf comp
			ErrorHelpUtil.validate(input, getErrorMap());
		}
	}
	
	public void CACS_SRC_BUS_TO_WhenValidateItem(ActionEvent ae)
	{
		System.out.println("PM_IL_CODES_ACCOUNT_SETUP_ACTION.CACS_SRC_BUS_TO_WhenValidateItem()");
		if(COMP_CACS_SRC_BUS_TO.getSubmittedValue().toString().isEmpty())
		{
			if(COMP_CACS_SRC_BUS_FM.getSubmittedValue().toString().equals("0"))
			{
				System.out.println("Input given is '0'");
				if(P_SET_SECOND_FIELD(getCOMP_CACS_SRC_BUS_FM(),getCOMP_CACS_SRC_BUS_TO()))
					L_VAL_FROM_TO(getCOMP_CACS_SRC_BUS_FM(),getCOMP_CACS_SRC_BUS_TO());
			}else{
				System.out.println("in else part...!!!!");
					COMP_CACS_SRC_BUS_TO.setSubmittedValue(COMP_CACS_SRC_BUS_FM.getSubmittedValue());
			}
		}
	}
	
	public void CACS_BUS_FM_CODE_WhenValidateItem(ActionEvent ae){
		System.out.println("PM_IL_CODES_ACCOUNT_SETUP_ACTION.CACS_BUS_FM_CODE_WhenValidateItem()");
		if("".equals(((String)getCOMP_CACS_BUS_FM_CODE().getSubmittedValue()).trim()) || getCOMP_CACS_BUS_FM_CODE().getSubmittedValue() == null){
			getCOMP_CACS_BUS_FM_CODE().setSubmittedValue("0");
			getCOMP_CACS_BUS_FM_CODE().updateModel(FacesContext.getCurrentInstance());
		}else{
				UIInput input = (UIInput) ae.getComponent().getParent(); // Ajax4jsf comp
				ErrorHelpUtil.validate(input, getErrorMap());
			}
	}

	public void CACS_BUS_TO_CODE_WhenValidateItem(ActionEvent ae){
		System.out.println("PM_IL_CODES_ACCOUNT_SETUP_ACTION.CACS_BUS_TO_CODE_WhenValidateItem()");
		if(COMP_CACS_BUS_TO_CODE.getSubmittedValue().toString().isEmpty())
		{
			if(COMP_CACS_BUS_FM_CODE.getSubmittedValue().toString().equals("0"))
			{
				System.out.println("Input given is '0'");
				if(P_SET_SECOND_FIELD(getCOMP_CACS_BUS_FM_CODE(),getCOMP_CACS_BUS_TO_CODE()))
					L_VAL_FROM_TO(getCOMP_CACS_BUS_FM_CODE(),getCOMP_CACS_BUS_TO_CODE());
			}else{
				System.out.println("in else part...!!!!");
				COMP_CACS_BUS_TO_CODE.setSubmittedValue(COMP_CACS_BUS_FM_CODE.getSubmittedValue());
					
			}
		}
		
	}
	
	public void CACS_DIVN_FM_CODE_WhenValidateItem(ActionEvent ae) {
		System.out.println("PM_IL_CODES_ACCOUNT_SETUP_ACTION.CACS_DIVN_FM_CODE_WhenValidateItem()");
		if("".equals(((String)getCOMP_CACS_DIVN_FM_CODE().getSubmittedValue()).trim()) || getCOMP_CACS_DIVN_FM_CODE().getSubmittedValue() == null){
			getCOMP_CACS_DIVN_FM_CODE().setSubmittedValue("0");
			getCOMP_CACS_DIVN_FM_CODE().updateModel(FacesContext.getCurrentInstance());
		}else{
			UIInput input = (UIInput) ae.getComponent().getParent(); // Ajax4jsf comp
			ErrorHelpUtil.validate(input, getErrorMap());
		}
		
	}
	
	public void CACS_DIVN_TO_CODE_WhenValidateItem(ActionEvent ae){
		System.out.println("PM_IL_CODES_ACCOUNT_SETUP_ACTION.CACS_DIVN_TO_CODE_WhenValidateItem()");
		if(COMP_CACS_DIVN_TO_CODE.getSubmittedValue().toString().isEmpty())
		{
			if(COMP_CACS_DIVN_FM_CODE.getSubmittedValue().toString().equals("0"))
			{
				System.out.println("Input given is '0'");
				if(P_SET_SECOND_FIELD(getCOMP_CACS_DIVN_FM_CODE(),getCOMP_CACS_DIVN_TO_CODE()))
					L_VAL_FROM_TO(getCOMP_CACS_DIVN_FM_CODE(),getCOMP_CACS_DIVN_TO_CODE());
			}else{
				System.out.println("in else part...!!!!");
				COMP_CACS_DIVN_TO_CODE.setSubmittedValue(COMP_CACS_DIVN_FM_CODE.getSubmittedValue());
			}
		}
	}
	
	public void CACS_DEPT_FM_CODE_WhenValidateItem(ActionEvent ae){
		System.out.println("PM_IL_CODES_ACCOUNT_SETUP_ACTION.CACS_DEPT_FM_CODE_WhenValidateItem()");
		if("".equals(((String)getCOMP_CACS_DEPT_FM_CODE().getSubmittedValue()).trim()) || getCOMP_CACS_DEPT_FM_CODE().getSubmittedValue() == null){
			getCOMP_CACS_DEPT_FM_CODE().setSubmittedValue("0");
			getCOMP_CACS_DEPT_FM_CODE().updateModel(FacesContext.getCurrentInstance());
		}else{
			UIInput input = (UIInput) ae.getComponent().getParent(); // Ajax4jsf comp
			ErrorHelpUtil.validate(input, getErrorMap());
		}
	}

	public void CACS_DEPT_TO_CODE_WhenValidateItem(ActionEvent ae){
		System.out.println("PM_IL_CODES_ACCOUNT_SETUP_ACTION.CACS_DEPT_TO_CODE_WhenValidateItem()");
		if(COMP_CACS_DEPT_TO_CODE.getSubmittedValue().toString().isEmpty())
		{
			if(COMP_CACS_DEPT_FM_CODE.getSubmittedValue().toString().equals("0"))
			{
				System.out.println("Input given is '0'");
				if(P_SET_SECOND_FIELD(getCOMP_CACS_DEPT_FM_CODE(),getCOMP_CACS_DEPT_TO_CODE()))
					L_VAL_FROM_TO(getCOMP_CACS_DEPT_FM_CODE(),getCOMP_CACS_DEPT_TO_CODE());
			}else{
				System.out.println("in else part...!!!!");
				COMP_CACS_DEPT_TO_CODE.setSubmittedValue(COMP_CACS_DEPT_FM_CODE.getSubmittedValue());

			}
		}

		
	}
	
	public void CACS_MAIN_ACNT_CODE_WhenValidateItem(FacesContext context,
			UIComponent component, Object value) throws Exception 
	{
		System.out.println("PM_IL_CODES_ACCOUNT_SETUP_ACTION.CACS_MAIN_ACNT_CODE_WhenValidateItem()-"+getCOMP_CACS_MAIN_ACNT_CODE().getSubmittedValue());
		/*UIInput input = (UIInput) ae.getComponent().getParent(); // Ajax4jsf
    	ErrorHelpUtil.validate(input, getErrorMap());*/
		connection = CommonUtils.getConnection();
		String MAIN_ACNT_CODE= COMP_CACS_MAIN_ACNT_CODE.getSubmittedValue().toString();
		getPM_IL_CODES_ACCOUNT_SETUP_BEAN().setCACS_MAIN_ACNT_CODE(MAIN_ACNT_CODE);
		System.out.println("Main Account code>>>>>>>>"+MAIN_ACNT_CODE);
		try
		{
			String sql_C1="SELECT MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2 FROM  FM_MAIN_ACCOUNT  WHERE  MAIN_ACNT_CODE  = '"+MAIN_ACNT_CODE+"' ";
			ResultSet rs_C1=null;
			Statement stmt_C1=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String sql_C2="SELECT ACTY_NAME FROM  FM_ACTIVITY  WHERE  ACTY_CODE  = '"+DUMMY_BEAN.getM_ACTY_1()+"' ";
			ResultSet vembu_C2=null;
			Statement stmt_C2=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String sql_C3="SELECT ACTY_NAME FROM  FM_ACTIVITY  WHERE  ACTY_CODE  = '"+DUMMY_BEAN.getM_ACTY_2()+"' ";
			ResultSet vembu_C3=null;
			Statement stmt_C3=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String M_TEMP1=null;
			String M_TEMP2=null;
			String Desc = null;
			
			Desc = new DBProcedures().P_VAL_MAIN_ACNT(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_MAIN_ACNT_CODE(),
	                                  PM_IL_CODES_ACCOUNT_SETUP_BEAN.getUI_M_MAIN_ACNT_NAME(),
	                                  "N",
	                				  "E");
			if(Desc != null){
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_MAIN_ACNT_NAME(Desc);
			}
			L_VAL_MAIN_ACTIVITY();
			if(rs_C1!=null)
			{
			}
			rs_C1=stmt_C1.executeQuery(sql_C1);
			if( rs_C1 != null){
				if(rs_C1.next())
				{
					DUMMY_BEAN.setM_ACTY_1(rs_C1.getString(1));
					DUMMY_BEAN.setM_ACTY_2(rs_C1.getString(2));
				}
			if(DUMMY_BEAN.getM_ACTY_1() != null)
			{
				vembu_C2=stmt_C2.executeQuery(sql_C2);
				if(vembu_C2.next())
				{
					M_TEMP1=vembu_C2.getString(1);
				}
				//BP_BEAN.setB_CACS_ACTY_CODE_1(StringFunctions.initcap(M_TEMP1));
			}
			else
			{
				//BP_BEAN.setB_CACS_ACTY_CODE_1("ACTIVITY CODE1");
			}
			if(DUMMY_BEAN.getM_ACTY_2() != null)
			{
				vembu_C3=stmt_C3.executeQuery(sql_C3);
				if(vembu_C3.next())
				{
					M_TEMP2=vembu_C3.getString(1);
				}
				//BP_BEAN.setB_CACS_ACTY_CODE_2(StringFunctions.initcap(M_TEMP2));
			}
			else
			{
				//BP_BEAN.setB_CACS_ACTY_CODE_2("ACTIVITY CODE2");
			}
		}
			
				COMP_UI_M_MAIN_ACNT_NAME.resetValue();
				COMP_CACS_SUB_ACNT_CODE.resetValue();
		        COMP_UI_M_SUB_ACNT_NAME.resetValue();
		        COMP_CACS_ACTY_CODE_1.resetValue();
		        COMP_UI_M_ACTY_NAME.resetValue();
		        COMP_CACS_ACTY_CODE_2.resetValue();
		        COMP_UI_M_ACTY_NAME_1.resetValue();
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void keyPressedEvent(ActionEvent event)
	{
		UIInput input = (UIInput)event.getComponent().getParent();
		System.out.println("MAIN ACT CODE:::::::"+input.getSubmittedValue());
		if(input.getSubmittedValue()==null)
		{
			getPM_IL_CODES_ACCOUNT_SETUP_BEAN().setCACS_MAIN_ACNT_CODE("");
			getCOMP_CACS_MAIN_ACNT_CODE().resetValue();
		}
	}
		
	public void CACS_SUB_ACNT_CODE_WhenValidateItem(FacesContext context,
			UIComponent component, Object value) throws Exception {
		System.out.println("PM_IL_CODES_ACCOUNT_SETUP_ACTION.CACS_SUB_ACNT_CODE_WhenValidateItem()");
		/*UIInput input = (UIInput) ae.getComponent().getParent(); 
    	ErrorHelpUtil.validate(input, getErrorMap());*/
    	ArrayList<String> returnList = new ArrayList<String>();
    	PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_SUB_ACNT_CODE((String)value);
		try
        {
			connection = CommonUtils.getConnection();
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_SUB_ACNT_NAME(null);
			if(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_SUB_ACNT_CODE() != null){
			returnList = new DBProcedures().P_VAL_SUB_ACNT(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_MAIN_ACNT_CODE(),
                    PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_SUB_ACNT_CODE(),
                    "N",
                    "E");
            if(!returnList.isEmpty() && returnList.get(0) != null){
            	PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_SUB_ACNT_NAME(returnList.get(0));
            }
			}
			COMP_UI_M_SUB_ACNT_NAME.resetValue();
        }catch(Exception e)
        {
        	e.printStackTrace();
        	throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
	}
	
	public void CACS_DIVN_CODE_WhenValidateItem(FacesContext context,
			UIComponent component, Object value) throws Exception {
		System.out.println("PM_IL_CODES_ACCOUNT_SETUP_ACTION.CACS_DIVN_CODE_WhenValidateItem()");
		/*UIInput input = (UIInput) ae.getComponent().getParent(); // Ajax4jsf
    	ErrorHelpUtil.validate(input, getErrorMap());*/
		connection = CommonUtils.getConnection();
		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DIVN_CODE((String) getCOMP_CACS_DIVN_CODE().getSubmittedValue());
		ArrayList<OracleParameter> returnList = new ArrayList<OracleParameter>();
		try
        {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_DIVN_NAME(null);
			if(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DIVN_CODE() == null){
	        	System.out.println("Bean Has Null");
	        }
            if(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DIVN_CODE() != null)
            {
            	returnList = new DBProcedures().P_VAL_DIVN(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DIVN_CODE(),
            			PM_IL_CODES_ACCOUNT_SETUP_BEAN.getUI_M_DIVN_NAME(),
            				"N",
                            "E");
            	if(!returnList.isEmpty() && returnList.get(0) != null){
            		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_DIVN_NAME(returnList.get(0).getValue());
            	}
            }
            if("N".equals(CommonUtils.nvl(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_FORCE_DIVN_YN(),"N")))
            {
                COMP_CACS_DIVN_CODE.setRequired(true);
            }
            L_SET_DEPT_ATTR();
            	PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DEPT_CODE(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DIVN_CODE());
            	COMP_UI_M_DIVN_NAME.resetValue();

        }catch(Exception e)
        {
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
	}
	
	public void CACS_DEPT_CODE_WhenValidateItem(FacesContext context,
			UIComponent component, Object value) throws Exception {
		System.out.println("PM_IL_CODES_ACCOUNT_SETUP_ACTION.CACS_DEPT_CODE_WhenValidateItem()");
		connection = CommonUtils.getConnection();
		 /*UIInput input = (UIInput) ae.getComponent().getParent(); // Ajax4jsf
	    	ErrorHelpUtil.validate(input, getErrorMap());*/
	    	ArrayList<String> returnList = new ArrayList<String>();
	    	PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DEPT_CODE((String) getCOMP_CACS_DEPT_CODE().getSubmittedValue());
		    try
	        {
		    	PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_DEPT_NAME(null);
		    	returnList = new DBProcedures().callP_VAL_DEPT(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DIVN_CODE(),
		                   PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DEPT_CODE(),
		                   "N",
		                   "E");	
		    	if(!returnList.isEmpty() && returnList.get(0) != null){
		    		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_DEPT_NAME(returnList.get(0));
		    	}
	            if("N".equals(CommonUtils.nvl(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_FORCE_DEPT_YN(),"N")))
	            {
	                COMP_CACS_DEPT_CODE.setRequired(true);
	            }
	            	COMP_UI_M_DEPT_NAME.resetValue();
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	            throw new ValidatorException(new FacesMessage(e.getMessage()));
	        }
	}
	
	public void CACS_ANLY_CODE_1_WhenValidateItem(ActionEvent ae) throws Exception {
		System.out.println("PM_IL_CODES_ACCOUNT_SETUP_ACTION.CACS_ANLY_CODE_1_WhenValidateItem()");
		connection = CommonUtils.getConnection();
		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_ANLY_CODE_1((String) getCOMP_CACS_ANLY_CODE_1().getSubmittedValue());
		ArrayList<String> returnList = new ArrayList<String>();
		try
        {
            PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_ANLY_NAME(null);
            if(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_ANLY_CODE_1() !=null)
            {
            	returnList = new DBProcedures().P_VAL_ANLY("1",
            									PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_ANLY_CODE_1(), 
            									"N", 
            			                      "E");
            	if(!returnList.isEmpty() && returnList.get(0) != null){
            		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_ANLY_NAME(returnList.get(0));
            	}
            }
        L_SET_ANALYSIS_ATTR();
        	COMP_UI_M_ANLY_NAME.resetValue();
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
	}
	
	public void CACS_ANLY_CODE_2_WhenValidateItem(FacesContext context,
			UIComponent component, Object value) throws Exception {
		System.out.println("PM_IL_CODES_ACCOUNT_SETUP_ACTION.CACS_ANLY_CODE_2_WhenValidateItem()");
		connection = CommonUtils.getConnection();
		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_ANLY_CODE_2((String) getCOMP_CACS_ANLY_CODE_2().getSubmittedValue());
		ArrayList<String> returnList = new ArrayList<String>();
		try
        {
            PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_ANLY_NAME_1(null);
 
            returnList = new DBProcedures().P_VAL_ANLY("2",
            		PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_ANLY_CODE_2(), 
            		"N",
            		"E");
            if(!returnList.isEmpty() && returnList.get(0) != null){
            	PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_ANLY_NAME_1(returnList.get(0));
            }
            COMP_UI_M_ANLY_NAME_1.resetValue();
        }catch(Exception e)
        {
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
	}
	
	public void CACS_ACTY_CODE_1_WhenValidateItem(FacesContext context,
			UIComponent component, Object value) throws Exception {
		System.out.println("PM_IL_CODES_ACCOUNT_SETUP_ACTION.CACS_ACTY_CODE_1_WhenValidateItem()");
		connection = CommonUtils.getConnection();
		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_ACTY_CODE_1((String) getCOMP_CACS_ACTY_CODE_1().getSubmittedValue());
		ArrayList<String> returnList = new ArrayList<String>();
		try
        {
        	PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_NAME(null);
        	if(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_ACTY_CODE_1() != null){
        		returnList = DBProcedures.P_VAL_ACTY(DUMMY_BEAN.getM_ACTY_1(),
                        PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_ACTY_CODE_1(),
                        "N",
                        "E");
        		if(!returnList.isEmpty() && returnList.get(0) != null){
        			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_NAME(returnList.get(0));
        		}
        	}
        		COMP_UI_M_ACTY_NAME.resetValue();
        }catch(Exception e)
        {
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
	}
	
	public void CACS_ACTY_CODE_2_WhenValidateItem(FacesContext context,
			UIComponent component, Object value) throws Exception {
		System.out.println("PM_IL_CODES_ACCOUNT_SETUP_ACTION.CACS_ACTY_CODE_2_WhenValidateItem()");
		connection = CommonUtils.getConnection();
		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_ACTY_CODE_2((String) getCOMP_CACS_ACTY_CODE_2().getSubmittedValue());
		ArrayList<String> returnList = new ArrayList<String>();
		try
        {
        	PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_NAME_1(null);
        	if(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_ACTY_CODE_2() != null){
        		returnList = DBProcedures.P_VAL_ACTY(DUMMY_BEAN.getM_ACTY_2(),
                        PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_ACTY_CODE_2(),
                        "N",
                        "E");
        		if(!returnList.isEmpty() && returnList.get(0) != null){
        			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_NAME_1(returnList.get(0));
        		}
        	}
                    	COMP_UI_M_ACTY_NAME_1.resetValue();
        }catch(Exception e)
        {
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
	}
	public void CACS_FORCE_DIVN_YN_WhenValidateItem(FacesContext context,UIComponent component,Object value) throws Exception {
		try{
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_FORCE_DIVN_YN((String) value);
			if("Y".equalsIgnoreCase(CommonUtils.nvl(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_FORCE_DIVN_YN(),"N"))){
			   getCOMP_CACS_DIVN_CODE().setDisabled(true);
			   getCOMP_CACS_DEPT_CODE().setDisabled(true);
			   getCOMP_CACS_DIVN_CODE().setRequired(false);
			   getCOMP_CACS_DEPT_CODE().setRequired(false);
			}
			if("N".equalsIgnoreCase(CommonUtils.nvl(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_FORCE_DIVN_YN(),"N"))){
				getCOMP_CACS_DIVN_CODE().setDisabled(false);
				 getCOMP_CACS_DEPT_CODE().setDisabled(false);
				getCOMP_CACS_DIVN_CODE().setRequired(true);
				getCOMP_CACS_DEPT_CODE().setRequired(true);
			}
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_FORCE_DEPT_YN(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_FORCE_DIVN_YN());
			COMP_CACS_FORCE_DEPT_YN.resetValue();
			COMP_CACS_DIVN_CODE.resetValue();
			COMP_CACS_DEPT_CODE.resetValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void CACS_FORCE_DIVN_YN_WhenValidateItem(ActionEvent ae) throws Exception {
		try{
			if("Y".equalsIgnoreCase(CommonUtils.nvl(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_FORCE_DIVN_YN(),"N"))){
			   getCOMP_CACS_DIVN_CODE().setDisabled(true);
			   getCOMP_CACS_DIVN_CODE().setRequired(false);
			   getCOMP_CACS_DEPT_CODE().setRequired(false);
			}
			if("N".equalsIgnoreCase(CommonUtils.nvl(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_FORCE_DIVN_YN(),"N"))){
				getCOMP_CACS_DIVN_CODE().setDisabled(true);
				getCOMP_CACS_DIVN_CODE().setRequired(false);
				getCOMP_CACS_DEPT_CODE().setRequired(false);
			}
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_FORCE_DEPT_YN(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_FORCE_DIVN_YN());
			COMP_CACS_DIVN_CODE.resetValue();
			COMP_CACS_DEPT_CODE.resetValue();
			COMP_CACS_FORCE_DEPT_YN.resetValue();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public void CACS_FORCE_DEPT_YN_WhenValidateItem(ActionEvent ae) throws Exception {
		try{
			if("Y".equalsIgnoreCase(CommonUtils.nvl(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_FORCE_DEPT_YN(),"N"))){
				   getCOMP_CACS_DEPT_CODE().setDisabled(true);
				   getCOMP_CACS_DEPT_CODE().setRequired(false);
				}
				if("N".equalsIgnoreCase(CommonUtils.nvl(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_FORCE_DEPT_YN(),"N"))){
					getCOMP_CACS_DEPT_CODE().setDisabled(true);
					getCOMP_CACS_DEPT_CODE().setRequired(false);
				}
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_FORCE_DEPT_YN(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_FORCE_DIVN_YN());
				COMP_CACS_DEPT_CODE.resetValue();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public void L_VAL_MAIN_ACTIVITY() throws SQLException,Exception
	{
		System.out.println("L_VAL_MAIN_ACTIVITY");
		connection = CommonUtils.getConnection();
		try
		{
			String sql_C1="SELECT   MAIN_CTL_ACNT_FLAG, MAIN_ACTY_CODE_1,    " +
					" MAIN_ACTY_CODE_2 FROM  FM_MAIN_ACCOUNT  WHERE  MAIN_ACNT_CODE  = '"+PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_MAIN_ACNT_CODE()+"'";
			ResultSet vembu_C1=null;
			Statement stmt_C1=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String   M_ACTY_HEAD_1=null;
			String   M_ACTY_HEAD_2=null;
			String M_FLAG = null;
			
			vembu_C1=stmt_C1.executeQuery(sql_C1);
			if(vembu_C1.next())
			{
				M_FLAG = vembu_C1.getString(1);
				M_ACTY_HEAD_1=vembu_C1.getString(2);
				M_ACTY_HEAD_2=vembu_C1.getString(3);
			}
			if(vembu_C1.isAfterLast() || vembu_C1.isBeforeFirst())
			{
			}
			if(!"C".equals(M_FLAG)){
				getCOMP_CACS_SUB_ACNT_CODE().setRendered(false);
				getCOMP_CACS_SUB_ACNT_CODE().setDisabled(true);
				 if(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_SUB_ACNT_CODE() != null){
		          PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_SUB_ACNT_CODE(null);
		          PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_SUB_ACNT_NAME(null);    
				 }
			}else{
				getCOMP_CACS_SUB_ACNT_CODE().setRendered(true);
				getCOMP_CACS_SUB_ACNT_CODE().setDisabled(false);
			}
			if(M_ACTY_HEAD_1 == null)
			{
				COMP_CACS_ACTY_CODE_1.setRequired(false);
				COMP_CACS_ACTY_CODE_1.setDisabled(true);
				if(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_ACTY_CODE_1() != null)
				{
					PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_ACTY_CODE_1(null);
					PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_NAME(null);
				}
			}
			else
			{
				COMP_CACS_ACTY_CODE_1.setDisabled(false);
				COMP_CACS_ACTY_CODE_1.setRequired(true);

				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_ACTY_CODE_1(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_ACTY_CODE_1());
			}
			if(M_ACTY_HEAD_2== null)
			{
				COMP_CACS_ACTY_CODE_2.setReadonly(true);
				COMP_CACS_ACTY_CODE_2.setDisabled(true);
				if(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_ACTY_CODE_2() != null)
				{
					PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_ACTY_CODE_2(null);
					PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_NAME_1(null);
				}
			}
			else
			{
				COMP_CACS_ACTY_CODE_2.setDisabled(false);
				COMP_CACS_ACTY_CODE_2.setRequired(true);
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_ACTY_CODE_2(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_ACTY_CODE_2());
			}
			DUMMY_BEAN.setM_ACTY_HEAD_1(M_ACTY_HEAD_1);
			DUMMY_BEAN.setM_ACTY_HEAD_2(M_ACTY_HEAD_2);
		}catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	public void L_SET_ANALYSIS_ATTR() throws SQLException,Exception
    {
		connection = CommonUtils.getConnection();
		try
        {
            if(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_ANLY_CODE_1()== null)
            {
                COMP_CACS_ANLY_CODE_2.setDisabled(true);
            }
            else
            {
            	COMP_CACS_ANLY_CODE_2.setDisabled(false);
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
		connection = CommonUtils.getConnection();
        try
        {
            if(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DIVN_CODE()== null)
            {
                COMP_CACS_DEPT_CODE.setRequired(false);
                COMP_CACS_DEPT_CODE.setDisabled(true);
                if(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DEPT_CODE() != null)
                {
                	PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DEPT_CODE(null);
                	PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_DEPT_NAME(null);
                }
            }
            else
            {
                COMP_CACS_DEPT_CODE.setRequired(true);
                COMP_CACS_DEPT_CODE.setDisabled(false);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }
	public boolean P_SET_SECOND_FIELD(HtmlInputText fromText,HtmlInputText toText){
		boolean status = true;
		if("".equals(toText.getSubmittedValue().toString().trim())){
			if(fromText.getSubmittedValue().toString().equals("0") && "".equals(toText.getSubmittedValue().toString().trim())){
				toText.setSubmittedValue("zzzzzzzzzz");
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

//	L_VAL_FROM_TO Method for WHEN VALIDATE
	public void L_VAL_FROM_TO(HtmlInputText fromText,HtmlInputText toText){
		System.out.println("I'm In Error Message L_VAL_FROM....");
		System.out.println("U Typed Field is "+fromText.getSubmittedValue());
		if("".equals(fromText.getSubmittedValue().toString().trim())){
			errMsg = STD_MESSAGE_ROUTINE("ENG","80033");
			System.out.println("from field value is empty....");
		}else {
			try{
				if(Integer.parseInt(toText.getSubmittedValue().toString().trim()) < Integer.parseInt(fromText.getSubmittedValue().toString().trim())){
					errMsg = STD_MESSAGE_ROUTINE("ENG","80034");
					System.out.println("This is at number area");
				}
			}catch(NumberFormatException e){
				if((toText.getSubmittedValue().toString().trim().compareTo(fromText.getSubmittedValue().toString().trim()) < 0)){
					errMsg = STD_MESSAGE_ROUTINE("ENG","80034");
					System.out.println("catch area.......");
					getErrorMap().put("current", errMsg);
				}
			}
		}
		System.out.println("Error Message : "+errMsg);
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
	
	
	/************************** FORM TRIGGERS **********************************/	
	
	
	/*public void preForm() throws Exception{
			FacesContext context=FacesContext.getCurrentInstance();
			context.getExternalContext().getSessionMap();
			session = (HttpSession)context.getExternalContext().getSession(true);
			session.setAttribute("GLOBAL.M_FAILURE", "FALSE");
	 		STD_PRE_FORM();
			ControlBean ctrlbean = CommonUtils.getControlBean();
			String M_TITLE = ctrlbean.getM_USER_ID()+" "+ctrlbean.getM_SCR_NAME()+" "+new Date();
			System.out.println("DUMMYACTION.preForm()---->> "+M_TITLE);
			try {
				connection = CommonUtils.getConnection();
			} catch (Exception exp) {
				exp.printStackTrace();
			}
			System.out.println("++++++++++++++++++++++ WELCOME ++++++++++++++++++++++++++++++++++");
	}
	public void STD_PRE_FORM(){
		ControlBean ctrlBean = CommonUtils.getControlBean();
		session.setAttribute("GLOBAL.M_FAILURE", "FALSE");
		ctrlBean.setM_GOFLD_NAME("NULL");
	}*/
	
	public void whenNewFormInstance() {
		System.out.println("PM_IL_CODES_ACCOUNT_SETUP_ACTION.whenNewFormInstance()");
		//NULL;
	}
	
	public void postFormsCommit(){
		System.out.println("PM_IL_CODES_ACCOUNT_SETUP_ACTION.postFormsCommit()");
		//NULL;
	}
	
	/*****************************************************/
	public void createRecord(){
		String message = null;
		try {
			if(getPM_IL_CODES_ACCOUNT_SETUP_BEAN().getROWID() == null){
				getPM_IL_CODES_ACCOUNT_SETUP_BEAN().setCACS_CR_DT(new Date());
				getPM_IL_CODES_ACCOUNT_SETUP_BEAN().setCACS_CR_UID( CommonUtils.getControlBean().getM_USER_ID());
				create_New_Record();
				message = Messages.getString("messageProperties","errorPanel$message$save");
			}else if(getPM_IL_CODES_ACCOUNT_SETUP_BEAN().getROWID() != null){
				preUpdate();
				create_New_Record();
				getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
    	    	message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
			}
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("SAVE_RECORD",message);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	public void create_New_Record(){
		System.out.println("New Record >> Save This");
		try {
			handler.executeInsert(PM_IL_CODES_ACCOUNT_SETUP_BEAN, connection);
		    CommonUtils.doComitt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void preUpdate()throws Exception{
		String C1 = "   SELECT 'X'  FROM   PM_IL_CODES_ACCOUNT_SETUP " +
				"  WHERE  (   ? BETWEEN  CACS_BUS_FM_CODE AND CACS_BUS_TO_CODE" +
				"  OR ? BETWEEN  CACS_BUS_FM_CODE AND CACS_BUS_TO_CODE" +
				"  OR CACS_BUS_FM_CODE  BETWEEN ? AND ?" +
				"  OR CACS_BUS_TO_CODE  BETWEEN ? AND ?)" +
				"  AND    (? BETWEEN CACS_DIVN_FM_CODE   AND CACS_DIVN_TO_CODE" +
				" OR ? BETWEEN CACS_DIVN_FM_CODE   AND CACS_DIVN_TO_CODE" +
				" OR CACS_DIVN_FM_CODE  BETWEEN ?  AND ?" +
				" OR CACS_DIVN_TO_CODE  BETWEEN ?  AND ?)" +
				"  AND    (?  BETWEEN CACS_DEPT_FM_CODE   AND CACS_DEPT_TO_CODE" +
				" OR ? BETWEEN CACS_DEPT_FM_CODE   AND CACS_DEPT_TO_CODE" +
				" OR CACS_DEPT_FM_CODE BETWEEN ?  AND ?" +
				" OR CACS_DEPT_TO_CODE BETWEEN ?   AND ?)" +
				"  AND    (? = CACS_SETUP_TYPE)" +
				"  AND    (?  BETWEEN CACS_SRC_BUS_FM   AND CACS_SRC_BUS_TO  " +
				" OR ? BETWEEN CACS_SRC_BUS_FM   AND CACS_SRC_BUS_TO" +
				" OR CACS_SRC_BUS_FM  BETWEEN ?  AND ?" +
				" OR CACS_SRC_BUS_TO  BETWEEN ?  AND ?)" +
				"		   AND    ROWID != ?";
		String M_DUMMY = null;
		Object[] values = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet c1_ResultSet = null;
		try{
				connection = CommonUtils.getConnection();
			   PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
			   PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_UPD_DT(new CommonUtils().getCurrentDate());
			   values = new Object[]{PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_BUS_FM_CODE(),PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_BUS_TO_CODE(),
					   PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_BUS_FM_CODE(),PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_BUS_TO_CODE(),
					   PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_BUS_FM_CODE(),PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_BUS_TO_CODE(),
					   PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DIVN_FM_CODE(),PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DIVN_TO_CODE(),
					   PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DIVN_FM_CODE(),PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DIVN_TO_CODE(),
					   PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DIVN_FM_CODE(),PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DIVN_TO_CODE(),
					   PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DEPT_FM_CODE(),PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DEPT_TO_CODE(),
					   PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DEPT_FM_CODE(),PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DEPT_TO_CODE(),
					   PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DEPT_FM_CODE(),PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DEPT_TO_CODE(),
					   PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_SETUP_TYPE(),PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_SRC_BUS_FM(),
					   PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_SRC_BUS_TO(),PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_SRC_BUS_FM(),
					   PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_SRC_BUS_TO(),PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_SRC_BUS_FM(),
					   PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_SRC_BUS_TO(),PM_IL_CODES_ACCOUNT_SETUP_BEAN.getROWID()};
			   c1_ResultSet = handler.executeSelectStatement(C1, connection,values);
			   if(c1_ResultSet.next()){
				   M_DUMMY = c1_ResultSet.getString(1);
				   throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "80031"));
			   }
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	public ArrayList<SelectItem> getSetupTypeList() {
		return setupTypeList;
	}

	public void setSetupTypeList(ArrayList<SelectItem> setupTypeList) {
		this.setupTypeList = setupTypeList;
	}
	
	
	public ArrayList<SelectItem> selectValueForComboBox(String formName,
			String blockName, String fieldName) {
		
		ArrayList<SelectItem> drpDwn = null;
		String queryString = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			queryString = "SELECT LIV_CODE,LIV_CODE_DESC FROM PP_LIST_ITEM,PP_LIST_ITEM_VALUES WHERE LI_SYS_PARAM = LIV_SYS_PARAM AND LI_MODULE_NAME = '{0}' AND LI_BLOCK_NAME = '{1}' AND LI_ITEM_NAME = '{2}'";
			queryString = queryString.replace("{0}", formName);
			queryString = queryString.replace("{1}", blockName);
			queryString = queryString.replace("{2}", fieldName);

			resultSet = handler.executeSelectStatement(queryString, connection);
			drpDwn = new ArrayList<SelectItem>();
			while (resultSet.next()) {
				SelectItem selectItem = new SelectItem();
				selectItem.setValue(resultSet.getString(1));
				selectItem.setLabel(resultSet.getString(2));
				drpDwn.add(selectItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				new CommonUtils().closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return drpDwn;
	}
	
	
	public void populateBlock() throws Exception {
		String str= this.PM_IL_CODES_ACCOUNT_SETUP_BEAN.getROWID();
		String query1="SELECT ROWNUM,PM_IL_CODES_ACCOUNT_SETUP.ROWID," +
		"CACS_SRC_BUS_FM,CACS_SRC_BUS_TO,CACS_DIVN_FM_CODE,CACS_DIVN_TO_CODE,CACS_DEPT_FM_CODE," +
		"CACS_DEPT_TO_CODE,CACS_BUS_FM_CODE,CACS_BUS_TO_CODE," +
		"CACS_MAIN_ACNT_CODE,CACS_SUB_ACNT_CODE," +
		"CACS_DIVN_CODE,CACS_DEPT_CODE,CACS_ANLY_CODE_1,CACS_ANLY_CODE_2,CACS_ACTY_CODE_1," +
		"CACS_ACTY_CODE_2,CACS_FORCE_DIVN_YN,CACS_FORCE_DEPT_YN,CACS_FRZ_FLAG  FROM PM_IL_CODES_ACCOUNT_SETUP " +
		"WHERE PM_IL_CODES_ACCOUNT_SETUP.ROWID LIKE '"+str+"'";
		Connection con = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = handler.executeSelectStatement(query1, con);

		PM_IL_CODES_ACCOUNT_SETUP budgetBean = this.getPM_IL_CODES_ACCOUNT_SETUP_BEAN();
		while(rs.next()){
			budgetBean.setROWID(rs.getString(2));
			budgetBean.setCACS_SRC_BUS_FM(rs.getString(3));
			budgetBean.setCACS_SRC_BUS_TO(rs.getString(4));
			budgetBean.setCACS_DIVN_FM_CODE(rs.getString(5));
			budgetBean.setCACS_DIVN_TO_CODE(rs.getString(6));
			budgetBean.setCACS_DEPT_FM_CODE(rs.getString(7));
			budgetBean.setCACS_DEPT_TO_CODE(rs.getString(8));
			budgetBean.setCACS_BUS_FM_CODE(rs.getString(9));
			budgetBean.setCACS_BUS_TO_CODE(rs.getString(10));
			budgetBean.setCACS_MAIN_ACNT_CODE(rs.getString(11));
			budgetBean.setCACS_SUB_ACNT_CODE(rs.getString(12));
			budgetBean.setCACS_DIVN_CODE(rs.getString(13));
			budgetBean.setCACS_DEPT_CODE(rs.getString(14));
			budgetBean.setCACS_ANLY_CODE_1(rs.getString(15));
			budgetBean.setCACS_ANLY_CODE_2(rs.getString(16));
			budgetBean.setCACS_ACTY_CODE_1(rs.getString(17));
			budgetBean.setCACS_ACTY_CODE_2(rs.getString(18));
			budgetBean.setCACS_FORCE_DIVN_YN(rs.getString(19));
			budgetBean.setCACS_FORCE_DEPT_YN(rs.getString(20));
			budgetBean.setCACS_FRZ_FLAG(rs.getString(21));

			budgetBean.setUI_M_MAIN_ACNT_NAME(mainAcntName(rs.getString(11)));
			}
		//CACS_SETUP_TYPE,CACS_FORCE_DIVN_YN,CACS_FORCE_DEPT_YN---CACS_FRZ_FLAG
		
		
		//UI_M_SUB_ACNT_NAME
		String subQuery =  "SELECT sub_acnt_name FROM fm_sub_account WHERE SUB_ACNT_CODE IN (SELECT MS_SUB_ACNT_CODE " +
		" FROM  FM_MAIN_SUB WHERE MS_MAIN_ACNT_CODE = '"+budgetBean.getCACS_MAIN_ACNT_CODE()+"') " +
		"AND NVL(SUB_FRZ_FLAG,'N') = 'N' AND SUB_ACNT_CODE='"+budgetBean.getCACS_SUB_ACNT_CODE()+"'";
		Connection subCon=CommonUtils.getConnection();
		ResultSet subrs=handler.executeSelectStatement(subQuery, subCon);
		while(subrs.next()){
			budgetBean.setUI_M_SUB_ACNT_NAME(subrs.getString(1));
			System.out.println("UI_M_SUB_ACNT_NAME-------------"+subrs.getString(1));
		}
		//UI_M_DIVN_NAME
		/*[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DIVISION to FM_DIVISION. Added by : Mallika.S, 31-Mar-2009 */
		String divQuery =  "select DIVN_NAME from FM_DIVISION where DIVN_CODE='"+budgetBean.getCACS_DIVN_CODE()+"'" +
				" AND DIVN_COMP_CODE = '001' AND " +
		" NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DIVN_CODE" +
		" AND ADS_USER_ID = ADS_USER_ID AND ADS_FRZ_FLAG = 'N')";
		Connection divCon=CommonUtils.getConnection();
		ResultSet drs=handler.executeSelectStatement(divQuery, divCon); 
		while(drs.next()){
			budgetBean.setUI_M_DIVN_NAME(drs.getString(1));
			System.out.println("UI_M_DIVN_NAME-------------"+drs.getString(1));
		}
		//UI_M_DEPT_NAME
		/*[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DEPARTMENT to FM_DEPARTMENT. Added by : Mallika.S, 31-Mar-2009 */
		String depQuery =  "select DEPT_NAME from FM_DEPARTMENT where DEPT_CODE='"+budgetBean.getCACS_DEPT_CODE()+"'" +
				" AND DEPT_COMP_CODE = '001' AND DEPT_DIVN_CODE = '"+budgetBean.getCACS_DIVN_CODE()+"' AND" +
		" DEPT_FRZ_FLAG  = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DEPT_DIVN_CODE AND" +
		" ADS_DEPT_CODE = DEPT_CODE AND ADS_USER_ID = ADS_USER_ID AND ADS_FRZ_FLAG = 'N')";
		Connection depCon=CommonUtils.getConnection();
		ResultSet ders=handler.executeSelectStatement(depQuery, depCon);
		while(ders.next()) {
			budgetBean.setUI_M_DEPT_NAME(ders.getString(1));
			System.out.println("UI_M_DEPT_NAME---------------"+ders.getString(1));
		}
		//UI_M_ANLY_NAME_1
		String anl1Query = "select ANLY_NAME from FM_ANALYSIS where  ANLY_CODE='"+budgetBean.getCACS_ANLY_CODE_1()+"'" +
				" AND ANLY_HEAD_NO = '1' AND NVL(ANLY_FRZ_FLAG,'N') = 'N'";
		Connection anl1Con=CommonUtils.getConnection();
		ResultSet anl1rs=handler.executeSelectStatement(anl1Query, anl1Con);
		while(anl1rs.next()){
			budgetBean.setUI_M_ANLY_NAME(anl1rs.getString(1));
			System.out.println("UI_M_ANLY_NAME_1---------------"+anl1rs.getString(1));
		}
		//UI_M_ANLY_NAME_2
		String anl2Query = "select ANLY_NAME from FM_ANALYSIS where  ANLY_CODE='"+budgetBean.getCACS_ANLY_CODE_2()+"'" +
		" AND ANLY_HEAD_NO = '2' AND NVL(ANLY_FRZ_FLAG,'N') = 'N'";
		Connection anl2Con=CommonUtils.getConnection();
		ResultSet anl2rs=handler.executeSelectStatement(anl2Query, anl2Con);
		while(anl2rs.next()){
			budgetBean.setUI_M_ANLY_NAME_1(anl2rs.getString(1));
			System.out.println("UI_M_ANLY_NAME_2-------------"+anl2rs.getString(1));
		}
		//UI_M_ACTY_NAME_1
		String a1Query = "select AVAL_VALUE_NAME from FM_ACTY_VALUE where AVAL_CODE='"+budgetBean.getCACS_ACTY_CODE_1()+"'" +
					" AND AVAL_ACTY_CODE='1'";
		Connection a1Con=CommonUtils.getConnection();
		ResultSet a1rs=handler.executeSelectStatement(a1Query, a1Con);
		while(a1rs.next()){
			budgetBean.setUI_M_ACTY_NAME(a1rs.getString(1));
			System.out.println("UI_M_ACTY_NAME_1-----------"+a1rs.getShort(1));;
		}
		//UI_M_ACTY_NAME_2
		String a2query =  "select AVAL_VALUE_NAME from FM_ACTY_VALUE where AVAL_CODE='"+budgetBean.getCACS_ACTY_CODE_2()+"'" +
					" AND AVAL_ACTY_CODE='2'";
		Connection a2Con=CommonUtils.getConnection();
		ResultSet a2rs=handler.executeSelectStatement(a2query, a2Con);
		while(a1rs.next()){
			budgetBean.setUI_M_ACTY_NAME_1(a2rs.getString(1));
			System.out.println("UI_M_ACTY_NAME_2-----------"+a2rs.getShort(1));;
		}
		
	}
	
	//UI_M_MAIN_ACNT_NAME
	private String mainAcntName(String str) throws Exception{
		Connection connection  = null;
		String name=null;
		try {
			connection  = CommonUtils.getConnection();
			String mainQuery = "select MAIN_ACNT_NAME from FM_MAIN_ACCOUNT where NVL(MAIN_FRZ_FLAG,'N') = 'N'" +
								" AND MAIN_ACNT_CODE='"+str+"'";
			ResultSet rs=handler.executeSelectStatement(mainQuery,	connection);
			while(rs.next()) {
				name=rs.getString(1);
				System.out.println("UI_M_MAIN_ACNT_NAME-----"+name);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}
	
	public void onLoad(PhaseEvent event){
		try {
			if(isFormFlag()){
				//preForm();
				whenNewFormInstance();
				setFormFlag(false);
			}
			if(isBlockFlag()){
				if(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getROWID() != null){
					populateBlock();
				}else{
					when_create_record();
				}
				when_new_record_instance();
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
	}

	public List<SelectItem> getDivisionTypeList() {
		return divisionTypeList;
	}

	public void setDivisionTypeList(List<SelectItem> divisionTypeList) {
		this.divisionTypeList = divisionTypeList;
	}

	public List<SelectItem> getDepartmentTypeList() {
		return departmentTypeList;
	}

	public void setDepartmentTypeList(List<SelectItem> departmentTypeList) {
		this.departmentTypeList = departmentTypeList;
	}

	public void when_create_record(){
		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_SETUP_TYPE("A");
		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_FORCE_DIVN_YN("N");
		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_FORCE_DEPT_YN("N");
		this.getCOMP_CACS_DIVN_CODE().setRequired(true);
		this.getCOMP_CACS_DEPT_CODE().setRequired(true);
		this.getCOMP_CACS_FORCE_DEPT_YN().setDisabled(true);
	}
	
	public void when_new_record_instance(){
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values = null;
		ResultSet c1_ResultSet = null;
		ResultSet c2_ResultSet = null;
		ResultSet c3_ResultSet = null;
		ResultSet c4_ResultSet = null;
		String M_TEMP1 = null;
		String M_TEMP2 = null;
		String M_DESC = null;
		String M_VALUE = null;
		String C1 = "  SELECT MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2" +
				"	    FROM   FM_MAIN_ACCOUNT" +
				"	    WHERE  MAIN_ACNT_CODE = ?";
		String C2 = "  SELECT ACTY_NAME" +
				"	    FROM   FM_ACTIVITY" +
				"	    WHERE  ACTY_CODE = ?";
		String C3 = "  SELECT ACTY_NAME" +
				"	    FROM   FM_ACTIVITY" +
				"	    WHERE  ACTY_CODE = ?";
		String C4 = "  SELECT PS_CODE_DESC,PS_VALUE" +
				"	    FROM   PP_SYSTEM" +
				"	    WHERE  PS_TYPE = 'IL_MISC_SET'" +
				"	    AND    PS_CODE = ?";
		try{
			connection = CommonUtils.getConnection();
			values = new Object[]{PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_MAIN_ACNT_CODE()};
			c1_ResultSet = handler.executeSelectStatement(C1, connection,values);
			if(c1_ResultSet.next()){
				DUMMY_BEAN.setM_ACTY_1(c1_ResultSet.getString(1));
				DUMMY_BEAN.setM_ACTY_2(c2_ResultSet.getString(2));
			if(DUMMY_BEAN.getM_ACTY_1() != null){
				values = new Object[]{DUMMY_BEAN.getM_ACTY_1()};
				c2_ResultSet = handler.executeSelectStatement(C2, connection,values);
				if(c2_ResultSet.next()){
					M_TEMP1 = c2_ResultSet.getString(1);
				}
			}
			if(DUMMY_BEAN.getM_ACTY_2() != null){
				values = new Object[]{DUMMY_BEAN.getM_ACTY_2()};
				c3_ResultSet = handler.executeSelectStatement(C3, connection,values);
				if(c3_ResultSet.next()){
					M_TEMP2 = c3_ResultSet.getString(1);
				}
			}
		  }
			values = new Object[]{PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_SETUP_TYPE()};
			c4_ResultSet = handler.executeSelectStatement(C4, connection,values);
			if(c4_ResultSet.next()){
				M_DESC = c4_ResultSet.getString(1);
				M_VALUE = c4_ResultSet.getString(2);
			}
			   this.getCOMP_CACS_FORCE_DEPT_YN().setDisabled(true);
			   if("Y".equals(CommonUtils.nvl(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_FORCE_DIVN_YN(),"N"))){
			     this.getCOMP_CACS_DIVN_CODE().setDisabled(true);
			      this.getCOMP_CACS_DIVN_CODE().setRequired(false);
			   }
			   if("N".equals(CommonUtils.nvl(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_FORCE_DIVN_YN(),"N"))){
				  this.getCOMP_CACS_DIVN_CODE().setDisabled(false);
			      this.getCOMP_CACS_DIVN_CODE().setRequired(true);
			   }
			   if("Y".equals(CommonUtils.nvl(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_FORCE_DEPT_YN(),"N"))){
			      this.getCOMP_CACS_DEPT_CODE().setDisabled(true);
			      this.getCOMP_CACS_DEPT_CODE().setRequired(false);
			   }
			   if("N".equals(CommonUtils.nvl(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_FORCE_DEPT_YN(),"N"))){
			      this.getCOMP_CACS_DEPT_CODE().setDisabled(false);
			      this.getCOMP_CACS_DEPT_CODE().setRequired(true);
			   }
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
