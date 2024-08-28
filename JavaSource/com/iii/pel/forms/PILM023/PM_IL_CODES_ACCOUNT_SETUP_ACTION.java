package com.iii.pel.forms.PILM023;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlGraphicImage;
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
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;

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

	private HtmlOutputLabel COMP_CACS_DOC_FM_TYPE_LABEL;

	private HtmlInputText COMP_CACS_DOC_FM_TYPE;

	private HtmlOutputLabel COMP_CACS_DOC_TO_TYPE_LABEL;

	private HtmlInputText COMP_CACS_DOC_TO_TYPE;

	private HtmlOutputLabel COMP_CACS_CUST_CLS_FM_CODE_LABEL;

	private HtmlInputText COMP_CACS_CUST_CLS_FM_CODE;

	private HtmlOutputLabel COMP_CACS_CUST_CLS_TO_CODE_LABEL;

	private HtmlInputText COMP_CACS_CUST_CLS_TO_CODE;

	private HtmlOutputLabel COMP_CACS_SETUP_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_CACS_SETUP_TYPE;

	private HtmlOutputLabel COMP_CACS_SETUP_FOR_LABEL;

	private HtmlSelectOneMenu COMP_CACS_SETUP_FOR;

	private HtmlOutputLabel COMP_CACS_PROD_CODE_FM_LABEL;

	private HtmlInputText COMP_CACS_PROD_CODE_FM;

	private HtmlOutputLabel COMP_CACS_PROD_CODE_TO_LABEL;

	private HtmlInputText COMP_CACS_PROD_CODE_TO;

	private HtmlOutputLabel COMP_CACS_COVER_CODE_FM_LABEL;

	private HtmlInputText COMP_CACS_COVER_CODE_FM;

	private HtmlOutputLabel COMP_CACS_COVER_CODE_TO_LABEL;

	private HtmlInputText COMP_CACS_COVER_CODE_TO;

	private HtmlOutputLabel COMP_CACS_ASSURED_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_CACS_ASSURED_TYPE;

	private HtmlOutputLabel COMP_CACS_TYPE_FM_CODE_LABEL;

	private HtmlInputText COMP_CACS_TYPE_FM_CODE;

	private HtmlOutputLabel COMP_CACS_TYPE_TO_CODE_LABEL;

	private HtmlInputText COMP_CACS_TYPE_TO_CODE;

	private HtmlOutputLabel COMP_CACS_FIRST_PREM_YN_LABEL;

	private HtmlSelectOneMenu COMP_CACS_FIRST_PREM_YN;

	private HtmlOutputLabel COMP_CACS_YRS_FM_LABEL;

	private HtmlInputText COMP_CACS_YRS_FM;

	private HtmlOutputLabel COMP_CACS_YRS_TO_LABEL;

	private HtmlInputText COMP_CACS_YRS_TO;

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

	private HtmlGraphicImage COMP_CACS_SUB_ACNT_CODE_IMG;
	
	private HtmlCommandButton COMP_UI_M_BUT_CUST_CLS_FM_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_CUST_CLS_TO_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_CACS_SRC_BUS_FM;

	private HtmlCommandButton COMP_UI_M_BUT_CACS_SRC_BUS_TO;

	private HtmlCommandButton COMP_UI_M_BUT_CACS_BUS_FM_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_CACS_BUS_TO_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_ACTY_2;

	private HtmlCommandButton COMP_UI_M_BUT_ACTY_1;

	private HtmlCommandButton COMP_UI_M_BUT_ANAL_1;

	private HtmlCommandButton COMP_UI_M_BUT_ANAL_2;

	private HtmlCommandButton COMP_UI_M_BUT_DEPT;

	private HtmlCommandButton COMP_UI_M_BUT_DIVN;

	private HtmlCommandButton COMP_UI_M_BUT_SUB_ACNT;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN_ACNT;

	private HtmlCommandButton COMP_UI_M_BUT_TYPE_TO;

	private HtmlCommandButton COMP_UI_M_BUT_TYPE_FM;

	private HtmlCommandButton COMP_UI_M_BUT_DOC_TYPE_FM_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_CACS_PROD_CODE_FM;

	private HtmlCommandButton COMP_UI_M_BUT_CACS_COVER_CODE_FM;

	private HtmlCommandButton COMP_UI_M_BUT_DOC_TYPE_TO_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_CACS_PROD_CODE_TO;

	private HtmlCommandButton COMP_UI_M_BUT_CACS_COVER_CODE_TO;

	private HtmlCommandButton COMP_UI_M_BUT_DEPT_TO;

	private HtmlCommandButton COMP_UI_M_BUT_DEPT_FM;

	private HtmlCommandButton COMP_UI_M_BUT_DIVN_TO;

	private HtmlCommandButton COMP_UI_M_BUT_DIVN_FM;

	private PM_IL_CODES_ACCOUNT_SETUP PM_IL_CODES_ACCOUNT_SETUP_BEAN;

	private List<SelectItem> CACS_SETUP_TYPE_LIST;

	private List<SelectItem> CACS_SETUP_FOR_LIST;

	private List<SelectItem> CACS_ASSURED_TYPE_LIST;

	private List<SelectItem> CACS_FIRST_PREM_YN_LIST;

	private List<SelectItem> CACS_FORCE_DIVN_YN_LIST;

	private List<SelectItem> CACS_FORCE_DEPT_YN_LIST;

	private List cacsSrcBusFmList;

	private List cacsSrcBusToList;

	private List cacsBusFmCodeList;

	private List cacsBusToCodeList;

	private List cacsDivnFmList;

	private List cacsDivnToList;
	
	private List cacsDeptFmList;

	private List cacsDeptToList;

	private List cacsDocFmList;

	private List cacsDocToList;

	private List cacsCustClsFmList;

	private List cacsCustClsToList;

	private List cacsProdFmList;

	private List cacsProdToList;

	private List cacsCoverFmList;

	private List cacsCoverToList;

	private List cacsTypeCodeFmList;

	private List cacsTypeCodeToList;

	private List cacsMainAcntList;

	private List cacsSubAcntList;

	private List cacsDivnCodeList;

	private List cacsDeptCodeList;

	private List cacsAnlyCodeList;

	private List cacsAnly1CodeList;

	private List cacsActyCodeList;

	private List cacsActy1CodeList;

	private PM_IL_CODES_ACCOUNT_SETUP_HELPER helper = null;

	public PM_IL_CODES_ACCOUNT_SETUP_ACTION() {
		PM_IL_CODES_ACCOUNT_SETUP_BEAN = new PM_IL_CODES_ACCOUNT_SETUP();
		helper = new PM_IL_CODES_ACCOUNT_SETUP_HELPER();
		instantiateAllComponent();

		PM_IL_CODES_ACCOUNT_SETUP_DELEGATE acntSetupDelegate = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE();
		List<SelectItem> itemListCacsSetupType = acntSetupDelegate
				.getList(
						PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ITEM_NAME_CACS_SETUP_TYPE,
						PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_SYS_PARAM_CACS_SETUP_TYPE);
		setCACS_SETUP_TYPE_LIST(itemListCacsSetupType);

		List<SelectItem> itemListCacsSetupForList = acntSetupDelegate
				.getList(
						PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ITEM_NAME_CACS_SETUP_FOR,
						PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_SYS_PARAM_CACS_SETUP_FOR);

		setCACS_SETUP_FOR_LIST(itemListCacsSetupForList);

		List<SelectItem> itemListCacsAssuredType = acntSetupDelegate
				.getList(
						PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ITEM_NAME_CACS_ASSURED_TYPE,
						PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_SYS_PARAM_CACS_ASSURED_TYPE);
		setCACS_ASSURED_TYPE_LIST(itemListCacsAssuredType);

		List<SelectItem> itemListCacsFirstPremYN = acntSetupDelegate
				.getList(
						PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ITEM_NAME_CACS_FIRST_PREM_YN,
						PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_SYS_PARAM_CACS_FIRST_PREM_YN);

		setCACS_FIRST_PREM_YN_LIST(itemListCacsFirstPremYN);

		List<SelectItem> itemListCacsForceDivn = acntSetupDelegate
				.getList(
						PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ITEM_NAME_CACS_FORCE_DIVN_YN,
						PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_SYS_PARAM_CACS_FORCE_DIVN_YN);
		setCACS_FORCE_DIVN_YN_LIST(itemListCacsForceDivn);

		List<SelectItem> itemListCacsDeptYN = acntSetupDelegate
				.getList(
						PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ITEM_NAME_CACS_FORCE_DEPT_YN,
						PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_SYS_PARAM_CACS_FORCE_DEPT_YN);
		setCACS_FORCE_DEPT_YN_LIST(itemListCacsDeptYN);

	}

	public HtmlOutputLabel getCOMP_CACS_FRZ_FLAG_LABEL() {
		return COMP_CACS_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_CACS_FRZ_FLAG() {
		return COMP_CACS_FRZ_FLAG;
	}

	public void setCOMP_CACS_FRZ_FLAG_LABEL(
			HtmlOutputLabel COMP_CACS_FRZ_FLAG_LABEL) {
		this.COMP_CACS_FRZ_FLAG_LABEL = COMP_CACS_FRZ_FLAG_LABEL;
	}

	public void setCOMP_CACS_FRZ_FLAG(
			HtmlSelectBooleanCheckbox COMP_CACS_FRZ_FLAG) {
		this.COMP_CACS_FRZ_FLAG = COMP_CACS_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_CACS_SRC_BUS_FM_LABEL() {
		return COMP_CACS_SRC_BUS_FM_LABEL;
	}

	public HtmlInputText getCOMP_CACS_SRC_BUS_FM() {
		return COMP_CACS_SRC_BUS_FM;
	}

	public void setCOMP_CACS_SRC_BUS_FM_LABEL(
			HtmlOutputLabel COMP_CACS_SRC_BUS_FM_LABEL) {
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

	public void setCOMP_CACS_SRC_BUS_TO_LABEL(
			HtmlOutputLabel COMP_CACS_SRC_BUS_TO_LABEL) {
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

	public void setCOMP_CACS_BUS_FM_CODE_LABEL(
			HtmlOutputLabel COMP_CACS_BUS_FM_CODE_LABEL) {
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

	public void setCOMP_CACS_BUS_TO_CODE_LABEL(
			HtmlOutputLabel COMP_CACS_BUS_TO_CODE_LABEL) {
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

	public void setCOMP_CACS_DIVN_FM_CODE_LABEL(
			HtmlOutputLabel COMP_CACS_DIVN_FM_CODE_LABEL) {
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

	public void setCOMP_CACS_DIVN_TO_CODE_LABEL(
			HtmlOutputLabel COMP_CACS_DIVN_TO_CODE_LABEL) {
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

	public void setCOMP_CACS_DEPT_FM_CODE_LABEL(
			HtmlOutputLabel COMP_CACS_DEPT_FM_CODE_LABEL) {
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

	public void setCOMP_CACS_DEPT_TO_CODE_LABEL(
			HtmlOutputLabel COMP_CACS_DEPT_TO_CODE_LABEL) {
		this.COMP_CACS_DEPT_TO_CODE_LABEL = COMP_CACS_DEPT_TO_CODE_LABEL;
	}

	public void setCOMP_CACS_DEPT_TO_CODE(HtmlInputText COMP_CACS_DEPT_TO_CODE) {
		this.COMP_CACS_DEPT_TO_CODE = COMP_CACS_DEPT_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_CACS_DOC_FM_TYPE_LABEL() {
		return COMP_CACS_DOC_FM_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_CACS_DOC_FM_TYPE() {
		return COMP_CACS_DOC_FM_TYPE;
	}

	public void setCOMP_CACS_DOC_FM_TYPE_LABEL(
			HtmlOutputLabel COMP_CACS_DOC_FM_TYPE_LABEL) {
		this.COMP_CACS_DOC_FM_TYPE_LABEL = COMP_CACS_DOC_FM_TYPE_LABEL;
	}

	public void setCOMP_CACS_DOC_FM_TYPE(HtmlInputText COMP_CACS_DOC_FM_TYPE) {
		this.COMP_CACS_DOC_FM_TYPE = COMP_CACS_DOC_FM_TYPE;
	}

	public HtmlOutputLabel getCOMP_CACS_DOC_TO_TYPE_LABEL() {
		return COMP_CACS_DOC_TO_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_CACS_DOC_TO_TYPE() {
		return COMP_CACS_DOC_TO_TYPE;
	}

	public void setCOMP_CACS_DOC_TO_TYPE_LABEL(
			HtmlOutputLabel COMP_CACS_DOC_TO_TYPE_LABEL) {
		this.COMP_CACS_DOC_TO_TYPE_LABEL = COMP_CACS_DOC_TO_TYPE_LABEL;
	}

	public void setCOMP_CACS_DOC_TO_TYPE(HtmlInputText COMP_CACS_DOC_TO_TYPE) {
		this.COMP_CACS_DOC_TO_TYPE = COMP_CACS_DOC_TO_TYPE;
	}

	public HtmlOutputLabel getCOMP_CACS_CUST_CLS_FM_CODE_LABEL() {
		return COMP_CACS_CUST_CLS_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CACS_CUST_CLS_FM_CODE() {
		return COMP_CACS_CUST_CLS_FM_CODE;
	}

	public void setCOMP_CACS_CUST_CLS_FM_CODE_LABEL(
			HtmlOutputLabel COMP_CACS_CUST_CLS_FM_CODE_LABEL) {
		this.COMP_CACS_CUST_CLS_FM_CODE_LABEL = COMP_CACS_CUST_CLS_FM_CODE_LABEL;
	}

	public void setCOMP_CACS_CUST_CLS_FM_CODE(
			HtmlInputText COMP_CACS_CUST_CLS_FM_CODE) {
		this.COMP_CACS_CUST_CLS_FM_CODE = COMP_CACS_CUST_CLS_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_CACS_CUST_CLS_TO_CODE_LABEL() {
		return COMP_CACS_CUST_CLS_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CACS_CUST_CLS_TO_CODE() {
		return COMP_CACS_CUST_CLS_TO_CODE;
	}

	public void setCOMP_CACS_CUST_CLS_TO_CODE_LABEL(
			HtmlOutputLabel COMP_CACS_CUST_CLS_TO_CODE_LABEL) {
		this.COMP_CACS_CUST_CLS_TO_CODE_LABEL = COMP_CACS_CUST_CLS_TO_CODE_LABEL;
	}

	public void setCOMP_CACS_CUST_CLS_TO_CODE(
			HtmlInputText COMP_CACS_CUST_CLS_TO_CODE) {
		this.COMP_CACS_CUST_CLS_TO_CODE = COMP_CACS_CUST_CLS_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_CACS_SETUP_TYPE_LABEL() {
		return COMP_CACS_SETUP_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CACS_SETUP_TYPE() {
		return COMP_CACS_SETUP_TYPE;
	}

	public void setCOMP_CACS_SETUP_TYPE_LABEL(
			HtmlOutputLabel COMP_CACS_SETUP_TYPE_LABEL) {
		this.COMP_CACS_SETUP_TYPE_LABEL = COMP_CACS_SETUP_TYPE_LABEL;
	}

	public void setCOMP_CACS_SETUP_TYPE(HtmlSelectOneMenu COMP_CACS_SETUP_TYPE) {
		this.COMP_CACS_SETUP_TYPE = COMP_CACS_SETUP_TYPE;
	}

	public HtmlOutputLabel getCOMP_CACS_SETUP_FOR_LABEL() {
		return COMP_CACS_SETUP_FOR_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CACS_SETUP_FOR() {
		return COMP_CACS_SETUP_FOR;
	}

	public void setCOMP_CACS_SETUP_FOR_LABEL(
			HtmlOutputLabel COMP_CACS_SETUP_FOR_LABEL) {
		this.COMP_CACS_SETUP_FOR_LABEL = COMP_CACS_SETUP_FOR_LABEL;
	}

	public void setCOMP_CACS_SETUP_FOR(HtmlSelectOneMenu COMP_CACS_SETUP_FOR) {
		this.COMP_CACS_SETUP_FOR = COMP_CACS_SETUP_FOR;
	}

	public HtmlOutputLabel getCOMP_CACS_PROD_CODE_FM_LABEL() {
		return COMP_CACS_PROD_CODE_FM_LABEL;
	}

	public HtmlInputText getCOMP_CACS_PROD_CODE_FM() {
		return COMP_CACS_PROD_CODE_FM;
	}

	public void setCOMP_CACS_PROD_CODE_FM_LABEL(
			HtmlOutputLabel COMP_CACS_PROD_CODE_FM_LABEL) {
		this.COMP_CACS_PROD_CODE_FM_LABEL = COMP_CACS_PROD_CODE_FM_LABEL;
	}

	public void setCOMP_CACS_PROD_CODE_FM(HtmlInputText COMP_CACS_PROD_CODE_FM) {
		this.COMP_CACS_PROD_CODE_FM = COMP_CACS_PROD_CODE_FM;
	}

	public HtmlOutputLabel getCOMP_CACS_PROD_CODE_TO_LABEL() {
		return COMP_CACS_PROD_CODE_TO_LABEL;
	}

	public HtmlInputText getCOMP_CACS_PROD_CODE_TO() {
		return COMP_CACS_PROD_CODE_TO;
	}

	public void setCOMP_CACS_PROD_CODE_TO_LABEL(
			HtmlOutputLabel COMP_CACS_PROD_CODE_TO_LABEL) {
		this.COMP_CACS_PROD_CODE_TO_LABEL = COMP_CACS_PROD_CODE_TO_LABEL;
	}

	public void setCOMP_CACS_PROD_CODE_TO(HtmlInputText COMP_CACS_PROD_CODE_TO) {
		this.COMP_CACS_PROD_CODE_TO = COMP_CACS_PROD_CODE_TO;
	}

	public HtmlOutputLabel getCOMP_CACS_COVER_CODE_FM_LABEL() {
		return COMP_CACS_COVER_CODE_FM_LABEL;
	}

	public HtmlInputText getCOMP_CACS_COVER_CODE_FM() {
		return COMP_CACS_COVER_CODE_FM;
	}

	public void setCOMP_CACS_COVER_CODE_FM_LABEL(
			HtmlOutputLabel COMP_CACS_COVER_CODE_FM_LABEL) {
		this.COMP_CACS_COVER_CODE_FM_LABEL = COMP_CACS_COVER_CODE_FM_LABEL;
	}

	public void setCOMP_CACS_COVER_CODE_FM(HtmlInputText COMP_CACS_COVER_CODE_FM) {
		this.COMP_CACS_COVER_CODE_FM = COMP_CACS_COVER_CODE_FM;
	}

	public HtmlOutputLabel getCOMP_CACS_COVER_CODE_TO_LABEL() {
		return COMP_CACS_COVER_CODE_TO_LABEL;
	}

	public HtmlInputText getCOMP_CACS_COVER_CODE_TO() {
		return COMP_CACS_COVER_CODE_TO;
	}

	public void setCOMP_CACS_COVER_CODE_TO_LABEL(
			HtmlOutputLabel COMP_CACS_COVER_CODE_TO_LABEL) {
		this.COMP_CACS_COVER_CODE_TO_LABEL = COMP_CACS_COVER_CODE_TO_LABEL;
	}

	public void setCOMP_CACS_COVER_CODE_TO(HtmlInputText COMP_CACS_COVER_CODE_TO) {
		this.COMP_CACS_COVER_CODE_TO = COMP_CACS_COVER_CODE_TO;
	}

	public HtmlOutputLabel getCOMP_CACS_ASSURED_TYPE_LABEL() {
		return COMP_CACS_ASSURED_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CACS_ASSURED_TYPE() {
		return COMP_CACS_ASSURED_TYPE;
	}

	public void setCOMP_CACS_ASSURED_TYPE_LABEL(
			HtmlOutputLabel COMP_CACS_ASSURED_TYPE_LABEL) {
		this.COMP_CACS_ASSURED_TYPE_LABEL = COMP_CACS_ASSURED_TYPE_LABEL;
	}

	public void setCOMP_CACS_ASSURED_TYPE(
			HtmlSelectOneMenu COMP_CACS_ASSURED_TYPE) {
		this.COMP_CACS_ASSURED_TYPE = COMP_CACS_ASSURED_TYPE;
	}

	public HtmlOutputLabel getCOMP_CACS_TYPE_FM_CODE_LABEL() {
		return COMP_CACS_TYPE_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CACS_TYPE_FM_CODE() {
		return COMP_CACS_TYPE_FM_CODE;
	}

	public void setCOMP_CACS_TYPE_FM_CODE_LABEL(
			HtmlOutputLabel COMP_CACS_TYPE_FM_CODE_LABEL) {
		this.COMP_CACS_TYPE_FM_CODE_LABEL = COMP_CACS_TYPE_FM_CODE_LABEL;
	}

	public void setCOMP_CACS_TYPE_FM_CODE(HtmlInputText COMP_CACS_TYPE_FM_CODE) {
		this.COMP_CACS_TYPE_FM_CODE = COMP_CACS_TYPE_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_CACS_TYPE_TO_CODE_LABEL() {
		return COMP_CACS_TYPE_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CACS_TYPE_TO_CODE() {
		return COMP_CACS_TYPE_TO_CODE;
	}

	public void setCOMP_CACS_TYPE_TO_CODE_LABEL(
			HtmlOutputLabel COMP_CACS_TYPE_TO_CODE_LABEL) {
		this.COMP_CACS_TYPE_TO_CODE_LABEL = COMP_CACS_TYPE_TO_CODE_LABEL;
	}

	public void setCOMP_CACS_TYPE_TO_CODE(HtmlInputText COMP_CACS_TYPE_TO_CODE) {
		this.COMP_CACS_TYPE_TO_CODE = COMP_CACS_TYPE_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_CACS_FIRST_PREM_YN_LABEL() {
		return COMP_CACS_FIRST_PREM_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CACS_FIRST_PREM_YN() {
		return COMP_CACS_FIRST_PREM_YN;
	}

	public void setCOMP_CACS_FIRST_PREM_YN_LABEL(
			HtmlOutputLabel COMP_CACS_FIRST_PREM_YN_LABEL) {
		this.COMP_CACS_FIRST_PREM_YN_LABEL = COMP_CACS_FIRST_PREM_YN_LABEL;
	}

	public void setCOMP_CACS_FIRST_PREM_YN(
			HtmlSelectOneMenu COMP_CACS_FIRST_PREM_YN) {
		this.COMP_CACS_FIRST_PREM_YN = COMP_CACS_FIRST_PREM_YN;
	}

	public HtmlOutputLabel getCOMP_CACS_YRS_FM_LABEL() {
		return COMP_CACS_YRS_FM_LABEL;
	}

	public HtmlInputText getCOMP_CACS_YRS_FM() {
		return COMP_CACS_YRS_FM;
	}

	public void setCOMP_CACS_YRS_FM_LABEL(HtmlOutputLabel COMP_CACS_YRS_FM_LABEL) {
		this.COMP_CACS_YRS_FM_LABEL = COMP_CACS_YRS_FM_LABEL;
	}

	public void setCOMP_CACS_YRS_FM(HtmlInputText COMP_CACS_YRS_FM) {
		this.COMP_CACS_YRS_FM = COMP_CACS_YRS_FM;
	}

	public HtmlOutputLabel getCOMP_CACS_YRS_TO_LABEL() {
		return COMP_CACS_YRS_TO_LABEL;
	}

	public HtmlInputText getCOMP_CACS_YRS_TO() {
		return COMP_CACS_YRS_TO;
	}

	public void setCOMP_CACS_YRS_TO_LABEL(HtmlOutputLabel COMP_CACS_YRS_TO_LABEL) {
		this.COMP_CACS_YRS_TO_LABEL = COMP_CACS_YRS_TO_LABEL;
	}

	public void setCOMP_CACS_YRS_TO(HtmlInputText COMP_CACS_YRS_TO) {
		this.COMP_CACS_YRS_TO = COMP_CACS_YRS_TO;
	}

	public HtmlOutputLabel getCOMP_CACS_FORCE_DIVN_YN_LABEL() {
		return COMP_CACS_FORCE_DIVN_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CACS_FORCE_DIVN_YN() {
		return COMP_CACS_FORCE_DIVN_YN;
	}

	public void setCOMP_CACS_FORCE_DIVN_YN_LABEL(
			HtmlOutputLabel COMP_CACS_FORCE_DIVN_YN_LABEL) {
		this.COMP_CACS_FORCE_DIVN_YN_LABEL = COMP_CACS_FORCE_DIVN_YN_LABEL;
	}

	public void setCOMP_CACS_FORCE_DIVN_YN(
			HtmlSelectOneMenu COMP_CACS_FORCE_DIVN_YN) {
		this.COMP_CACS_FORCE_DIVN_YN = COMP_CACS_FORCE_DIVN_YN;
	}

	public HtmlOutputLabel getCOMP_CACS_FORCE_DEPT_YN_LABEL() {
		return COMP_CACS_FORCE_DEPT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CACS_FORCE_DEPT_YN() {
		return COMP_CACS_FORCE_DEPT_YN;
	}

	public void setCOMP_CACS_FORCE_DEPT_YN_LABEL(
			HtmlOutputLabel COMP_CACS_FORCE_DEPT_YN_LABEL) {
		this.COMP_CACS_FORCE_DEPT_YN_LABEL = COMP_CACS_FORCE_DEPT_YN_LABEL;
	}

	public void setCOMP_CACS_FORCE_DEPT_YN(
			HtmlSelectOneMenu COMP_CACS_FORCE_DEPT_YN) {
		this.COMP_CACS_FORCE_DEPT_YN = COMP_CACS_FORCE_DEPT_YN;
	}

	public HtmlOutputLabel getCOMP_CACS_MAIN_ACNT_CODE_LABEL() {
		return COMP_CACS_MAIN_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CACS_MAIN_ACNT_CODE() {
		return COMP_CACS_MAIN_ACNT_CODE;
	}

	public void setCOMP_CACS_MAIN_ACNT_CODE_LABEL(
			HtmlOutputLabel COMP_CACS_MAIN_ACNT_CODE_LABEL) {
		this.COMP_CACS_MAIN_ACNT_CODE_LABEL = COMP_CACS_MAIN_ACNT_CODE_LABEL;
	}

	public void setCOMP_CACS_MAIN_ACNT_CODE(
			HtmlInputText COMP_CACS_MAIN_ACNT_CODE) {
		this.COMP_CACS_MAIN_ACNT_CODE = COMP_CACS_MAIN_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_MAIN_ACNT_NAME_LABEL() {
		return COMP_UI_M_MAIN_ACNT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_MAIN_ACNT_NAME() {
		return COMP_UI_M_MAIN_ACNT_NAME;
	}

	public void setCOMP_UI_M_MAIN_ACNT_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_MAIN_ACNT_NAME_LABEL) {
		this.COMP_UI_M_MAIN_ACNT_NAME_LABEL = COMP_UI_M_MAIN_ACNT_NAME_LABEL;
	}

	public void setCOMP_UI_M_MAIN_ACNT_NAME(
			HtmlInputText COMP_UI_M_MAIN_ACNT_NAME) {
		this.COMP_UI_M_MAIN_ACNT_NAME = COMP_UI_M_MAIN_ACNT_NAME;
	}

	public HtmlOutputLabel getCOMP_CACS_SUB_ACNT_CODE_LABEL() {
		return COMP_CACS_SUB_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CACS_SUB_ACNT_CODE() {
		return COMP_CACS_SUB_ACNT_CODE;
	}

	public void setCOMP_CACS_SUB_ACNT_CODE_LABEL(
			HtmlOutputLabel COMP_CACS_SUB_ACNT_CODE_LABEL) {
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

	public void setCOMP_UI_M_SUB_ACNT_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_SUB_ACNT_NAME_LABEL) {
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

	public void setCOMP_CACS_DIVN_CODE_LABEL(
			HtmlOutputLabel COMP_CACS_DIVN_CODE_LABEL) {
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

	public void setCOMP_UI_M_DIVN_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_DIVN_NAME_LABEL) {
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

	public void setCOMP_CACS_DEPT_CODE_LABEL(
			HtmlOutputLabel COMP_CACS_DEPT_CODE_LABEL) {
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

	public void setCOMP_UI_M_DEPT_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_DEPT_NAME_LABEL) {
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

	public void setCOMP_CACS_ANLY_CODE_1_LABEL(
			HtmlOutputLabel COMP_CACS_ANLY_CODE_1_LABEL) {
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

	public void setCOMP_UI_M_ANLY_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_ANLY_NAME_LABEL) {
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

	public void setCOMP_CACS_ANLY_CODE_2_LABEL(
			HtmlOutputLabel COMP_CACS_ANLY_CODE_2_LABEL) {
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

	public void setCOMP_UI_M_ANLY_NAME_1_LABEL(
			HtmlOutputLabel COMP_UI_M_ANLY_NAME_1_LABEL) {
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

	public void setCOMP_CACS_ACTY_CODE_1_LABEL(
			HtmlOutputLabel COMP_CACS_ACTY_CODE_1_LABEL) {
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

	public void setCOMP_UI_M_ACTY_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_ACTY_NAME_LABEL) {
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

	public void setCOMP_CACS_ACTY_CODE_2_LABEL(
			HtmlOutputLabel COMP_CACS_ACTY_CODE_2_LABEL) {
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

	public void setCOMP_UI_M_ACTY_NAME_1_LABEL(
			HtmlOutputLabel COMP_UI_M_ACTY_NAME_1_LABEL) {
		this.COMP_UI_M_ACTY_NAME_1_LABEL = COMP_UI_M_ACTY_NAME_1_LABEL;
	}

	public void setCOMP_UI_M_ACTY_NAME_1(HtmlInputText COMP_UI_M_ACTY_NAME_1) {
		this.COMP_UI_M_ACTY_NAME_1 = COMP_UI_M_ACTY_NAME_1;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CUST_CLS_FM_LOV() {
		return COMP_UI_M_BUT_CUST_CLS_FM_LOV;
	}

	public void setCOMP_UI_M_BUT_CUST_CLS_FM_LOV(
			HtmlCommandButton COMP_UI_M_BUT_CUST_CLS_FM_LOV) {
		this.COMP_UI_M_BUT_CUST_CLS_FM_LOV = COMP_UI_M_BUT_CUST_CLS_FM_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CUST_CLS_TO_LOV() {
		return COMP_UI_M_BUT_CUST_CLS_TO_LOV;
	}

	public void setCOMP_UI_M_BUT_CUST_CLS_TO_LOV(
			HtmlCommandButton COMP_UI_M_BUT_CUST_CLS_TO_LOV) {
		this.COMP_UI_M_BUT_CUST_CLS_TO_LOV = COMP_UI_M_BUT_CUST_CLS_TO_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CACS_SRC_BUS_FM() {
		return COMP_UI_M_BUT_CACS_SRC_BUS_FM;
	}

	public void setCOMP_UI_M_BUT_CACS_SRC_BUS_FM(
			HtmlCommandButton COMP_UI_M_BUT_CACS_SRC_BUS_FM) {
		this.COMP_UI_M_BUT_CACS_SRC_BUS_FM = COMP_UI_M_BUT_CACS_SRC_BUS_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CACS_SRC_BUS_TO() {
		return COMP_UI_M_BUT_CACS_SRC_BUS_TO;
	}

	public void setCOMP_UI_M_BUT_CACS_SRC_BUS_TO(
			HtmlCommandButton COMP_UI_M_BUT_CACS_SRC_BUS_TO) {
		this.COMP_UI_M_BUT_CACS_SRC_BUS_TO = COMP_UI_M_BUT_CACS_SRC_BUS_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CACS_BUS_FM_CODE() {
		return COMP_UI_M_BUT_CACS_BUS_FM_CODE;
	}

	public void setCOMP_UI_M_BUT_CACS_BUS_FM_CODE(
			HtmlCommandButton COMP_UI_M_BUT_CACS_BUS_FM_CODE) {
		this.COMP_UI_M_BUT_CACS_BUS_FM_CODE = COMP_UI_M_BUT_CACS_BUS_FM_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CACS_BUS_TO_CODE() {
		return COMP_UI_M_BUT_CACS_BUS_TO_CODE;
	}

	public void setCOMP_UI_M_BUT_CACS_BUS_TO_CODE(
			HtmlCommandButton COMP_UI_M_BUT_CACS_BUS_TO_CODE) {
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

	public void setCOMP_UI_M_BUT_SUB_ACNT(
			HtmlCommandButton COMP_UI_M_BUT_SUB_ACNT) {
		this.COMP_UI_M_BUT_SUB_ACNT = COMP_UI_M_BUT_SUB_ACNT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN_ACNT() {
		return COMP_UI_M_BUT_MAIN_ACNT;
	}

	public void setCOMP_UI_M_BUT_MAIN_ACNT(
			HtmlCommandButton COMP_UI_M_BUT_MAIN_ACNT) {
		this.COMP_UI_M_BUT_MAIN_ACNT = COMP_UI_M_BUT_MAIN_ACNT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_TYPE_TO() {
		return COMP_UI_M_BUT_TYPE_TO;
	}

	public void setCOMP_UI_M_BUT_TYPE_TO(HtmlCommandButton COMP_UI_M_BUT_TYPE_TO) {
		this.COMP_UI_M_BUT_TYPE_TO = COMP_UI_M_BUT_TYPE_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_TYPE_FM() {
		return COMP_UI_M_BUT_TYPE_FM;
	}

	public void setCOMP_UI_M_BUT_TYPE_FM(HtmlCommandButton COMP_UI_M_BUT_TYPE_FM) {
		this.COMP_UI_M_BUT_TYPE_FM = COMP_UI_M_BUT_TYPE_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DOC_TYPE_FM_CODE() {
		return COMP_UI_M_BUT_DOC_TYPE_FM_CODE;
	}

	public void setCOMP_UI_M_BUT_DOC_TYPE_FM_CODE(
			HtmlCommandButton COMP_UI_M_BUT_DOC_TYPE_FM_CODE) {
		this.COMP_UI_M_BUT_DOC_TYPE_FM_CODE = COMP_UI_M_BUT_DOC_TYPE_FM_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CACS_PROD_CODE_FM() {
		return COMP_UI_M_BUT_CACS_PROD_CODE_FM;
	}

	public void setCOMP_UI_M_BUT_CACS_PROD_CODE_FM(
			HtmlCommandButton COMP_UI_M_BUT_CACS_PROD_CODE_FM) {
		this.COMP_UI_M_BUT_CACS_PROD_CODE_FM = COMP_UI_M_BUT_CACS_PROD_CODE_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CACS_COVER_CODE_FM() {
		return COMP_UI_M_BUT_CACS_COVER_CODE_FM;
	}

	public void setCOMP_UI_M_BUT_CACS_COVER_CODE_FM(
			HtmlCommandButton COMP_UI_M_BUT_CACS_COVER_CODE_FM) {
		this.COMP_UI_M_BUT_CACS_COVER_CODE_FM = COMP_UI_M_BUT_CACS_COVER_CODE_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DOC_TYPE_TO_CODE() {
		return COMP_UI_M_BUT_DOC_TYPE_TO_CODE;
	}

	public void setCOMP_UI_M_BUT_DOC_TYPE_TO_CODE(
			HtmlCommandButton COMP_UI_M_BUT_DOC_TYPE_TO_CODE) {
		this.COMP_UI_M_BUT_DOC_TYPE_TO_CODE = COMP_UI_M_BUT_DOC_TYPE_TO_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CACS_PROD_CODE_TO() {
		return COMP_UI_M_BUT_CACS_PROD_CODE_TO;
	}

	public void setCOMP_UI_M_BUT_CACS_PROD_CODE_TO(
			HtmlCommandButton COMP_UI_M_BUT_CACS_PROD_CODE_TO) {
		this.COMP_UI_M_BUT_CACS_PROD_CODE_TO = COMP_UI_M_BUT_CACS_PROD_CODE_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CACS_COVER_CODE_TO() {
		return COMP_UI_M_BUT_CACS_COVER_CODE_TO;
	}

	public void setCOMP_UI_M_BUT_CACS_COVER_CODE_TO(
			HtmlCommandButton COMP_UI_M_BUT_CACS_COVER_CODE_TO) {
		this.COMP_UI_M_BUT_CACS_COVER_CODE_TO = COMP_UI_M_BUT_CACS_COVER_CODE_TO;
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

	public void setPM_IL_CODES_ACCOUNT_SETUP_BEAN(
			PM_IL_CODES_ACCOUNT_SETUP PM_IL_CODES_ACCOUNT_SETUP_BEAN) {
		this.PM_IL_CODES_ACCOUNT_SETUP_BEAN = PM_IL_CODES_ACCOUNT_SETUP_BEAN;
	}

	public List<SelectItem> getCACS_SETUP_TYPE_LIST() {
		return CACS_SETUP_TYPE_LIST;
	}

	public void setCACS_SETUP_TYPE_LIST(List<SelectItem> cacs_setup_type_list) {
		CACS_SETUP_TYPE_LIST = cacs_setup_type_list;
	}

	public List<SelectItem> getCACS_SETUP_FOR_LIST() {
		return CACS_SETUP_FOR_LIST;
	}

	public void setCACS_SETUP_FOR_LIST(List<SelectItem> cacs_setup_for_list) {
		CACS_SETUP_FOR_LIST = cacs_setup_for_list;
	}

	public List<SelectItem> getCACS_ASSURED_TYPE_LIST() {
		return CACS_ASSURED_TYPE_LIST;
	}

	public void setCACS_ASSURED_TYPE_LIST(
			List<SelectItem> cacs_assured_type_list) {
		CACS_ASSURED_TYPE_LIST = cacs_assured_type_list;
	}

	public List<SelectItem> getCACS_FIRST_PREM_YN_LIST() {
		return CACS_FIRST_PREM_YN_LIST;
	}

	public void setCACS_FIRST_PREM_YN_LIST(
			List<SelectItem> cacs_first_prem_yn_list) {
		CACS_FIRST_PREM_YN_LIST = cacs_first_prem_yn_list;
	}

	public List<SelectItem> getCACS_FORCE_DIVN_YN_LIST() {
		return CACS_FORCE_DIVN_YN_LIST;
	}

	public void setCACS_FORCE_DIVN_YN_LIST(
			List<SelectItem> cacs_force_divn_yn_list) {
		CACS_FORCE_DIVN_YN_LIST = cacs_force_divn_yn_list;
	}

	public List<SelectItem> getCACS_FORCE_DEPT_YN_LIST() {
		return CACS_FORCE_DEPT_YN_LIST;
	}

	public void setCACS_FORCE_DEPT_YN_LIST(
			List<SelectItem> cacs_force_dept_yn_list) {
		CACS_FORCE_DEPT_YN_LIST = cacs_force_dept_yn_list;
	}

	public List getCacsSrcBusFmList() {
		return cacsSrcBusFmList;
	}

	public void setCacsSrcBusFmList(List cacsSrcBusFmList) {
		this.cacsSrcBusFmList = cacsSrcBusFmList;
	}

	public List getCacsSrcBusToList() {
		return cacsSrcBusToList;
	}

	public void setCacsSrcBusToList(List cacsSrcBusToList) {
		this.cacsSrcBusToList = cacsSrcBusToList;
	}

	public List getCacsBusFmCodeList() {
		return cacsBusFmCodeList;
	}

	public void setCacsBusFmCodeList(List cacsBusFmCodeList) {
		this.cacsBusFmCodeList = cacsBusFmCodeList;
	}

	public List getCacsBusToCodeList() {
		return cacsBusToCodeList;
	}

	public void setCacsBusToCodeList(List cacsBusToCodeList) {
		this.cacsBusToCodeList = cacsBusToCodeList;
	}

	public List getCacsDivnFmList() {
		return cacsDivnFmList;
	}

	public void setCacsDivnFmList(List cacsDivnFmList) {
		this.cacsDivnFmList = cacsDivnFmList;
	}

	public List getCacsDivnToList() {
		return cacsDivnToList;
	}

	public void setCacsDivnToList(List cacsDivnToList) {
		this.cacsDivnToList = cacsDivnToList;
	}

	public List getCacsDeptFmList() {
		return cacsDeptFmList;
	}

	public void setCacsDeptFmList(List cacsDeptFmList) {
		this.cacsDeptFmList = cacsDeptFmList;
	}

	public List getCacsDeptToList() {
		return cacsDeptToList;
	}

	public void setCacsDeptToList(List cacsDeptToList) {
		this.cacsDeptToList = cacsDeptToList;
	}

	public List getCacsDocFmList() {
		return cacsDocFmList;
	}

	public void setCacsDocFmList(List cacsDocFmList) {
		this.cacsDocFmList = cacsDocFmList;
	}

	public List getCacsDocToList() {
		return cacsDocToList;
	}

	public void setCacsDocToList(List cacsDocToList) {
		this.cacsDocToList = cacsDocToList;
	}

	public List getCacsCustClsFmList() {
		return cacsCustClsFmList;
	}

	public void setCacsCustClsFmList(List cacsCustClsFmList) {
		this.cacsCustClsFmList = cacsCustClsFmList;
	}

	public List getCacsCustClsToList() {
		return cacsCustClsToList;
	}

	public void setCacsCustClsToList(List cacsCustClsToList) {
		this.cacsCustClsToList = cacsCustClsToList;
	}

	public List getCacsProdFmList() {
		return cacsProdFmList;
	}

	public void setCacsProdFmList(List cacsProdFmList) {
		this.cacsProdFmList = cacsProdFmList;
	}

	public List getCacsProdToList() {
		return cacsProdToList;
	}

	public void setCacsProdToList(List cacsProdToList) {
		this.cacsProdToList = cacsProdToList;
	}

	public List getCacsCoverFmList() {
		return cacsCoverFmList;
	}

	public void setCacsCoverFmList(List cacsCoverFmList) {
		this.cacsCoverFmList = cacsCoverFmList;
	}

	public List getCacsCoverToList() {
		return cacsCoverToList;
	}

	public void setCacsCoverToList(List cacsCoverToList) {
		this.cacsCoverToList = cacsCoverToList;
	}

	public List getCacsTypeCodeFmList() {
		return cacsTypeCodeFmList;
	}

	public void setCacsTypeCodeFmList(List cacsTypeCodeFmList) {
		this.cacsTypeCodeFmList = cacsTypeCodeFmList;
	}

	public List getCacsTypeCodeToList() {
		return cacsTypeCodeToList;
	}

	public void setCacsTypeCodeToList(List cacsTypeCodeToList) {
		this.cacsTypeCodeToList = cacsTypeCodeToList;
	}

	public String executeInsertion() {

		PM_IL_CODES_ACCOUNT_SETUP_DELEGATE delegate = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE();

		try {
			CommonUtils commonUtils = new CommonUtils();
			if (PM_IL_CODES_ACCOUNT_SETUP_BEAN.isFRZ_FLAG()) {
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_FRZ_FLAG("Y");
			} else {
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_FRZ_FLAG("N");
			}

			if (PM_IL_CODES_ACCOUNT_SETUP_BEAN.getROWID() == null) {
				helper.pilm023_pm_il_codes_account_setup_pre_insert(this);
				new CRUDHandler().executeInsert(PM_IL_CODES_ACCOUNT_SETUP_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put("current", "Records Saved Successfully");
			} else {
				helper.pilm023_pm_il_codes_account_setup_pre_update(this);
				new CRUDHandler().executeUpdate(PM_IL_CODES_ACCOUNT_SETUP_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put("current", "Records Updated Successfully");
			}

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("current", e.getMessage());
		}

		return "";
	}

	public void saveRecord(){
		String message = "";
		try{
			CommonUtils.clearMaps(this);
		if(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getROWID() == null){
				if(isINSERT_ALLOWED()){
					helper.pilm023_pm_il_codes_account_setup_pre_insert(this);
				
				if(PM_IL_CODES_ACCOUNT_SETUP_BEAN.isFRZ_FLAG()==false)
				{
					PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_FRZ_FLAG("N");
				}else{
					PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_FRZ_FLAG("Y");
				}
				new CRUDHandler().executeInsert(PM_IL_CODES_ACCOUNT_SETUP_BEAN,CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				message = Messages.getString("messageProperties","errorPanel$message$save");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("detail", message);
			}else{
				message = Messages.getString("messageProperties","errorPanel$message$insertnotallowed");
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getErrorMap().put("SAVE", message);
			}
		}else{
				if(isUPDATE_ALLOWED()){
					helper.pilm023_pm_il_codes_account_setup_pre_update(this);
				if(PM_IL_CODES_ACCOUNT_SETUP_BEAN.isFRZ_FLAG()==false)
				{
					PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_FRZ_FLAG("N");
				}else{
					PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_FRZ_FLAG("Y");
				}
				new CRUDHandler().executeInsert(PM_IL_CODES_ACCOUNT_SETUP_BEAN,
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
	
	
	
	
	
	
	
	public List suggestionActionCacsSrcBusFm(Object event) {
		String cacsSrcBusFm = (String) event;
		cacsSrcBusFmList = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
				.prepareCacsSrcBusFmList(cacsSrcBusFm, cacsSrcBusFmList);
		for (int i = 0; i < cacsSrcBusFmList.size(); i++) {
			PM_IL_CODES_ACCOUNT_SETUP pm_il_codes_account_setup = (PM_IL_CODES_ACCOUNT_SETUP) cacsSrcBusFmList
					.get(i);
			System.out.println("VALUES:"
					+ pm_il_codes_account_setup.getCACS_BUS_FM_CODE() + "   "
					+ pm_il_codes_account_setup.getUI_M_CACS_SRC_BUS_FM_DESC());
		}
		return cacsSrcBusFmList;
	}

	public List suggestionActionCacsSrcBusTO(Object event) {
		String cacsSrcBusTO = (String) event;
		System.out.println("Eha Hain   >>>>>");
		cacsSrcBusToList = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
				.prepareCacsSrcBusToList(cacsSrcBusTO, cacsSrcBusToList);
		return cacsSrcBusToList;
	}

	public List suggestionActionCacsBusFm(Object event) {
		String cacsBusFm = (String) event;
		System.out.println("Eha Hain   >>>>>");
		cacsBusFmCodeList = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
				.prepareCacsBusFmList(cacsBusFm, cacsBusFmCodeList);

		return cacsBusFmCodeList;
	}

	public List suggestionActionCacsBusTo(Object event) {
		String cacsBusTo = (String) event;
		System.out.println("Eha Hain   >>>>>");
		cacsBusToCodeList = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
				.prepareCacsBusToList(cacsBusTo, cacsBusToCodeList);

		return cacsBusToCodeList;
	}

	public List suggestionActionCacsDivnFm(Object event) {
		String cacsDivnFm = (String) event;
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction = (PM_IL_CODES_ACCOUNT_SETUP_ACTION) (commonUtils
				.getMappedBeanFromSession("PILM023_PM_IL_CODES_ACCOUNT_SETUP_ACTION"));
		cacsDivnFmList = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
				.prepareCacsDivnFmList(cacsDivnFm, cacsDivnFmList);
		return cacsDivnFmList;
	}

	public List suggestionActionCacsDivnTo(Object event) {
		String cacsDivnTo = (String) event;

		cacsDivnToList = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
				.prepareCacsDivnToList(cacsDivnTo, cacsDivnToList);

		return cacsDivnToList;
	}

	public List suggestionActionCacsDeptFm(Object event) {
		String cacsDeptFm = (String) event;

		String divisionFmCode = PM_IL_CODES_ACCOUNT_SETUP_BEAN
				.getCACS_DIVN_FM_CODE();
		System.out.println("Division Fm Code :" + divisionFmCode);
		cacsDeptFmList = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
				.prepareCacsDeptFmList(divisionFmCode, cacsDeptFm,
						cacsDeptFmList);

		return cacsDeptFmList;
	}

	public List suggestionActionCacsDeptTo(Object event) {
		String cacsDeptTo = (String) event;

		String divisionToCode = PM_IL_CODES_ACCOUNT_SETUP_BEAN
				.getCACS_DIVN_TO_CODE();
		System.out.println("Division Fm Code :" + divisionToCode);
		cacsDeptToList = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
				.prepareCacsDeptToList(divisionToCode, cacsDeptTo,
						cacsDeptToList);

		return cacsDeptToList;
	}

	public void setDivnFmCode(ActionEvent event) {
		System.out.println("IN>>>>>:"
				+ COMP_CACS_DIVN_FM_CODE.getSubmittedValue());
		if (COMP_CACS_DIVN_FM_CODE.getSubmittedValue() != null) {
			String divnCode = (String) COMP_CACS_DIVN_FM_CODE
					.getSubmittedValue();
			System.out.println("Division Code*********** " + divnCode);
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DIVN_FM_CODE(divnCode);
		}
	}

	public void setDivnToCode(ActionEvent event) {
		System.out.println("IN>>>>>:"
				+ COMP_CACS_DIVN_TO_CODE.getSubmittedValue());
		if (COMP_CACS_DIVN_TO_CODE.getSubmittedValue() != null) {
			String divnCode = (String) COMP_CACS_DIVN_TO_CODE
					.getSubmittedValue();
			System.out.println("Division Code*********** " + divnCode);
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DIVN_TO_CODE(divnCode);
		}
	}

	public List suggestionActionCacsDocFm(Object event) {

		String cacsDocFm = (String) event;
		System.out.println("cacsDocFm :" + cacsDocFm);
		cacsDocFmList = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
				.prepareCacsDocFmList(cacsDocFm, cacsDocFmList);

		return cacsDocFmList;
	}

	public List suggestionActionCacsDocTo(Object event) {

		String cacsDocTo = (String) event;
		System.out.println("cacsDocTo :" + cacsDocTo);
		cacsDocToList = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
				.prepareCacsDocToList(cacsDocTo, cacsDocToList);

		return cacsDocToList;
	}

	public List suggestionActionCacsCustClsFm(Object event) {
		// CACS_CUST_CLS_FM_CODE
		String cacsCustClsFm = (String) event;
		System.out.println("cacsCustFm :" + cacsCustClsFm);
		cacsCustClsFmList = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
				.prepareCacsCustFmList(cacsCustClsFm, cacsCustClsFmList);

		return cacsCustClsFmList;
	}

	public List suggestionActionCacsCustClsTo(Object event) {
		// CACS_CUST_CLS_FM_CODE
		String cacsCustClsTo = (String) event;
		System.out.println("cacsCustTo :" + cacsCustClsTo);
		cacsCustClsToList = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
				.prepareCacsCustToList(cacsCustClsTo, cacsCustClsToList);

		return cacsCustClsToList;
	}

	public List suggestionActionCacsProdFm(Object event) {
		// CACS_PROD_CODE_FM
		String cacsProdFm = (String) event;
		System.out.println("cacsCustTo :" + cacsProdFm);
		cacsProdFmList = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
				.prepareCacsProdFmList(cacsProdFm, cacsProdFmList);

		return cacsProdFmList;
	}

	public List suggestionActionCacsProdTo(Object event) {
		// CACS_PROD_CODE_FM
		String cacsProdTo = (String) event;
		System.out.println("cacsProdTo :" + cacsProdTo);
		cacsProdToList = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
				.prepareCacsProdToList(cacsProdTo, cacsProdToList);

		return cacsProdToList;
	}

	public List suggestionActionCacsCoverCodeFm(Object event) {
		// CACS_COVER_CODE_FM
		String cacsCoverFm = (String) event;
		System.out.println("cacsCoverFm :" + cacsCoverFm);
		cacsCoverFmList = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
				.prepareCacsCoverFmList(cacsCoverFm, cacsCoverFmList);

		return cacsCoverFmList;
	}

	public List suggestionActionCacsCoverCodeTo(Object event) {
		// CACS_COVER_CODE_FM
		String cacsCoverTo = (String) event;
		System.out.println("cacsCoverTo :" + cacsCoverTo);
		cacsCoverToList = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
				.prepareCacsCoverToList(cacsCoverTo, cacsCoverToList);

		return cacsCoverToList;
	}

	public List suggestionActionCacsTypeFmCode(Object event) {

		String cacsTypeFm = (String) event;
		System.out.println("cacsTypeFm :" + cacsTypeFm);
		try {
			cacsTypeCodeFmList = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()

			.prepareCacsTypeCodeFmList(cacsTypeFm, cacsTypeCodeFmList,
					PM_IL_CODES_ACCOUNT_SETUP_BEAN);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cacsTypeCodeFmList;
	}

	public List suggestionActionCacsTypeToCode(Object event) {

		String cacsTypeTo = (String) event;
		System.out.println("cacsTypeto :" + cacsTypeTo);
		try {
			cacsTypeCodeToList = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()

			.prepareCacsTypeCodeToList(cacsTypeTo, cacsTypeCodeToList,
					PM_IL_CODES_ACCOUNT_SETUP_BEAN);
		} catch (DBException e) {
			e.printStackTrace();
		}
		return cacsTypeCodeToList;
	}

	public List suggestionActionCacsMainAcnt(Object event) {
		String cacsMainAcnt = (String) event;
		System.out.println("cacsMainAcnt :" + cacsMainAcnt);
		cacsMainAcntList = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
				.prepareCacsMainAcntList(cacsMainAcnt, cacsMainAcntList);
		return cacsMainAcntList;
	}

	public void getMainAcntName(ActionEvent event) {

		if (COMP_CACS_MAIN_ACNT_CODE.getSubmittedValue() != null) {
			String mainAcntCode = (String) COMP_CACS_MAIN_ACNT_CODE
					.getSubmittedValue();
			System.out.println("mainAcntCode*********** " + mainAcntCode);

			String mainAcntName = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
					.getMainAcntNameForCode(mainAcntCode, cacsMainAcntList);
			// COMP_UI_M_CONT_CATG_CODE_DESC.setSubmittedValue(catgCodeDesc);
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_MAIN_ACNT_NAME(mainAcntName);
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_MAIN_ACNT_CODE(mainAcntCode);
		}
	}

	public List getCacsMainAcntList() {
		return cacsMainAcntList;
	}

	public void setCacsMainAcntList(List cacsMainAcntList) {
		this.cacsMainAcntList = cacsMainAcntList;
	}

	public List suggestionActionCacsSubAcnt(Object event) {
		String cacsSubAcnt = (String) event;
		System.out.println("cacsSubAcnt :" + cacsSubAcnt);
		String mainAcntCode = PM_IL_CODES_ACCOUNT_SETUP_BEAN
				.getCACS_MAIN_ACNT_CODE();
		System.out.println("mainAcntCode :" + mainAcntCode);
		cacsSubAcntList = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
				.prepareCacsSubAcntList(mainAcntCode, cacsSubAcnt,
						cacsSubAcntList);
		return cacsSubAcntList;
	}

	public List getCacsSubAcntList() {
		return cacsSubAcntList;
	}

	public void setCacsSubAcntList(List cacsSubAcntList) {
		this.cacsSubAcntList = cacsSubAcntList;
	}

	public void getSubAcntName(ActionEvent event) {

		if (COMP_CACS_SUB_ACNT_CODE.getSubmittedValue() != null) {
			String subAcntCode = (String) COMP_CACS_SUB_ACNT_CODE
					.getSubmittedValue();
			System.out.println("subAcntCode*********** " + subAcntCode);

			String subAcntName = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
					.getMainAcntNameForCode(subAcntCode, cacsSubAcntList);
			// COMP_UI_M_CONT_CATG_CODE_DESC.setSubmittedValue(catgCodeDesc);
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_SUB_ACNT_NAME(subAcntName);
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_SUB_ACNT_CODE(subAcntCode);
		}
	}

	public List getCacsDivnCodeList() {
		return cacsDivnCodeList;
	}

	public void setCacsDivnCodeList(List cacsDivnCodeList) {
		this.cacsDivnCodeList = cacsDivnCodeList;
	}

	public List suggestionActionCacsDivn(Object event) {
		String cacsDivnCode = (String) event;
		System.out.println("cacsDivnCode :" + cacsDivnCode);
		cacsDivnCodeList = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
				.prepareCacsDivnCodeList(cacsDivnCode, cacsDivnCodeList);
		return cacsDivnCodeList;
	}

	public void getDivnName(ActionEvent event) {

		if (COMP_CACS_DIVN_CODE.getSubmittedValue() != null) {
			String divnCode = (String) COMP_CACS_DIVN_CODE.getSubmittedValue();
			System.out.println("divnCode*********** " + divnCode);

			String divnName = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
					.getDivnNameForCode(divnCode, cacsDivnCodeList);
			// COMP_UI_M_CONT_CATG_CODE_DESC.setSubmittedValue(catgCodeDesc);
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_DIVN_NAME(divnName);
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DIVN_CODE(divnCode);
		}
	}

	public List getCacsDeptCodeList() {
		return cacsDeptCodeList;
	}

	public void setCacsDeptCodeList(List cacsDeptCodeList) {
		this.cacsDeptCodeList = cacsDeptCodeList;
	}

	public List suggestionActionCacsDept(Object event) {
		String cacsDeptCode = (String) event;
		System.out.println("cacsDeptCode :" + cacsDeptCode);
		String divisionCode = PM_IL_CODES_ACCOUNT_SETUP_BEAN
				.getCACS_DIVN_CODE();
		System.out.println("Division Code :" + divisionCode);
		cacsDeptCodeList = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
				.prepareCacsDeptCodeList(divisionCode, cacsDeptCode,
						cacsDeptCodeList);
		return cacsDeptCodeList;
	}

	public void getDeptName(ActionEvent event) {

		if (COMP_CACS_DEPT_CODE.getSubmittedValue() != null) {
			String deptCode = (String) COMP_CACS_DEPT_CODE.getSubmittedValue();
			System.out.println("deptCode*********** " + deptCode);

			String deptName = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
					.getDeptNameForCode(deptCode, cacsDeptCodeList);
			// COMP_UI_M_CONT_CATG_CODE_DESC.setSubmittedValue(catgCodeDesc);
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_DEPT_NAME(deptName);

		}
	}

	public List getCacsAnlyCodeList() {
		return cacsAnlyCodeList;
	}

	public void setCacsAnlyCodeList(List cacsAnlyCodeList) {
		this.cacsAnlyCodeList = cacsAnlyCodeList;
	}

	public List suggestionActionCacsAnly(Object event) {
		String cacsAnlyCode = (String) event;
		System.out.println("cacsAnlyCode :" + cacsAnlyCode);
		cacsAnlyCodeList = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
				.prepareCacsAnlyCodeList(cacsAnlyCode, cacsAnlyCodeList);
		return cacsAnlyCodeList;
	}

	public void getAnlyName(ActionEvent event) {

		if (COMP_CACS_ANLY_CODE_1.getSubmittedValue() != null) {
			String anlyCode = (String) COMP_CACS_ANLY_CODE_1
					.getSubmittedValue();
			System.out.println("anlyCode*********** " + anlyCode);

			String anlyName = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
					.getAnlyNameForCode(anlyCode, cacsAnlyCodeList);
			// COMP_UI_M_CONT_CATG_CODE_DESC.setSubmittedValue(catgCodeDesc);
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_ANLY_NAME(anlyName);

		}
	}

	public List suggestionActionCacsAnly1(Object event) {
		String cacsAnlyCode = (String) event;
		System.out.println("cacsAnly1Code :" + cacsAnlyCode);
		cacsAnly1CodeList = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
				.prepareCacsAnlyCodeList(cacsAnlyCode, cacsAnly1CodeList);
		return cacsAnly1CodeList;
	}

	public void getAnly1Name(ActionEvent event) {

		if (COMP_CACS_ANLY_CODE_2.getSubmittedValue() != null) {
			String anly1Code = (String) COMP_CACS_ANLY_CODE_2
					.getSubmittedValue();
			System.out.println("anlyCode*********** " + anly1Code);

			String deptName = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
					.getAnly1NameForCode(anly1Code, cacsAnly1CodeList);
			// COMP_UI_M_CONT_CATG_CODE_DESC.setSubmittedValue(catgCodeDesc);
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_ANLY_NAME_1(deptName);

		}
	}

	public List getCacsAnly1CodeList() {
		return cacsAnly1CodeList;
	}

	public void setCacsAnly1CodeList(List cacsAnly1CodeList) {
		this.cacsAnly1CodeList = cacsAnly1CodeList;
	}

	public List getCacsActyCodeList() {
		return cacsActyCodeList;
	}

	public void setCacsActyCodeList(List cacsActyCodeList) {
		this.cacsActyCodeList = cacsActyCodeList;
	}

	public List getCacsActy1CodeList() {
		return cacsActy1CodeList;
	}

	public void setCacsActy1CodeList(List cacsActy1CodeList) {
		this.cacsActy1CodeList = cacsActy1CodeList;
	}

	public List suggestionActionCacsActy(Object event) {
		String cacsActyCode = (String) event;
		String m_acty_1 = PM_IL_CODES_ACCOUNT_SETUP_BEAN.getUI_M_ACTY_HEAD_1();
		cacsActyCodeList = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
				.prepareCacsActyCodeList(m_acty_1, cacsActyCode,
						cacsActyCodeList);
		return cacsActyCodeList;
	}

	public List suggestionActionCacsActy1(Object event) {
		String cacsActy1Code = (String) event;
		String m_acty_2 = PM_IL_CODES_ACCOUNT_SETUP_BEAN.getUI_M_ACTY_2();
		cacsActy1CodeList = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
				.prepareCacsActyCodeList(m_acty_2, cacsActy1Code,
						cacsActy1CodeList);
		return cacsActy1CodeList;
	}

	public void getActyName(ActionEvent event) {

		if (COMP_CACS_ACTY_CODE_1.getSubmittedValue() != null) {
			String acty1Code = (String) COMP_CACS_ACTY_CODE_1
					.getSubmittedValue();
			String acty1Name = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
					.getActyNameForCode(acty1Code, cacsAnlyCodeList);
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_NAME(acty1Name);
		}
	}

	public void getActy1Name(ActionEvent event) {
		if (COMP_CACS_ACTY_CODE_1.getSubmittedValue() != null) {
			String acty2Code = (String) COMP_CACS_ACTY_CODE_2
					.getSubmittedValue();
			String acty2Name = new PM_IL_CODES_ACCOUNT_SETUP_DELEGATE()
					.getActyNameForCode(acty2Code, cacsAnly1CodeList);
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_NAME_1(acty2Name);
		}
	}

	public void setErrorMessagesInMap(ActionEvent event) {
		getCurrentValue(event);
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public String getCurrentValue(ActionEvent event) {
		String value = null;
		UIInput input = null;
		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
			}
		}
		return value;
	}

	public void CACS_SRC_BUS_TO_WHEN_VALIDATE_ITEM(ActionEvent e) {
		UIInput input = (UIInput) e.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		String cacsSrcBusFm = PM_IL_CODES_ACCOUNT_SETUP_BEAN
				.getCACS_SRC_BUS_FM();
		if (inputValue.isEmpty()) {
			if (cacsSrcBusFm.equals("0")) {
				getCOMP_CACS_SRC_BUS_TO().setSubmittedValue(z_Constant);
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_SRC_BUS_TO(z_Constant);
			} else {
				getCOMP_CACS_SRC_BUS_TO().setSubmittedValue(cacsSrcBusFm);
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_SRC_BUS_TO(cacsSrcBusFm);
			}
		} else if (inputValue.compareTo(cacsSrcBusFm) > 0) {
			getCOMP_CACS_SRC_BUS_TO().setSubmittedValue(inputValue);
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_SRC_BUS_TO(inputValue);
		} else {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Enter Greatere value than From ");
		}
	}

	public void validateCACS_SRC_BUS_FM(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput htmlInputText = (UIInput) actionEvent.getComponent()
				.getParent();
		String inputValue = (String) htmlInputText.getSubmittedValue();
		System.out.println("Input Value: " + inputValue);
		if (inputValue.isEmpty()) {
			getCOMP_CACS_SRC_BUS_FM().setSubmittedValue("0");
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_SRC_BUS_FM("0");
		} else {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_SRC_BUS_FM(inputValue);
		}
		ErrorHelpUtil.validate(htmlInputText, getErrorMap());
	}

	public void validateCACS_SRC_BUS_FM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_SRC_BUS_FM((String) value);
		try {
			if (!"0".equals(value)) {
				String query = "SELECT 'X' FROM PM_CODES WHERE PC_TYPE= 'SRC_BUS_TY' AND PC_CODE = ? ";
				Boolean flag = null;
				flag = isValidateLovCode(query, new Object[] { value });
				if (flag == false) {
					throw new Exception("Code does not Exists.Please Re-enter");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCACS_SRC_BUS_TO(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_SRC_BUS_TO((String) value);
		String P_FROM_CODE = PM_IL_CODES_ACCOUNT_SETUP_BEAN
				.getCACS_SRC_BUS_FM();
		String P_TO_CODE = PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_SRC_BUS_TO();
		try {
			if (!z_Constant.equals(value)) {
				String query = "SELECT   'X'  FROM PM_CODES WHERE PC_TYPE= 'SRC_BUS_TY' AND PC_CODE = ? ";
				Boolean flag = null;
				flag = isValidateLovCode(query, new Object[] { value });
				if (flag == false) {
					throw new Exception("Code does not Exists.Please Re-enter");
				}
			}
			if (P_FROM_CODE == null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80033"));
			}
			if (P_TO_CODE.compareTo(P_FROM_CODE) < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80034"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}

	public void validateCACS_BUS_FM_CODE(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput htmlInputText = (UIInput) actionEvent.getComponent()
				.getParent();
		String inputValue = (String) htmlInputText.getSubmittedValue();
		if (inputValue.isEmpty()) {
			getCOMP_CACS_BUS_FM_CODE().setSubmittedValue("0");
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_BUS_FM_CODE("0");
		} else {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_BUS_FM_CODE(inputValue);
			ErrorHelpUtil.validate(htmlInputText, getErrorMap());
		}
	}

	public void validateCACS_BUS_FM_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_BUS_FM_CODE((String) value);
			if (!"0".equals(value)) {
				String query = "SELECT 'X' FROM PP_SYSTEM WHERE PS_TYPE = 'IL_BUSINES'  AND PS_CODE = ?";
				Boolean flag = null;
				flag = isValidateLovCode(query, new Object[] { value });
				if (flag == false) {
					throw new Exception("Code does not Exists.Please Re-enter");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCACS_BUS_TO_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_BUS_TO_CODE((String) value);
			String P_FROM_CODE = PM_IL_CODES_ACCOUNT_SETUP_BEAN
					.getCACS_BUS_FM_CODE();
			String P_TO_CODE = PM_IL_CODES_ACCOUNT_SETUP_BEAN
					.getCACS_BUS_TO_CODE();
			if (!z_Constant.equals(value)) {
				String query = "SELECT 'X' FROM PP_SYSTEM WHERE PS_TYPE = 'IL_BUSINES'  AND PS_CODE = ? ";
				Boolean flag = null;
				flag = isValidateLovCode(query, new Object[] { value });
				if (flag == false) {
					throw new Exception("Code does not Exists.Please Re-enter");
				}
			}
			if (P_FROM_CODE == null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80033"));
			}
			if (P_TO_CODE.compareTo(P_FROM_CODE) < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80034"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void CACS_BUS_TO_CODE_WHEN_VALIDATE_ITEM(ActionEvent e) {
		getWarningMap().clear();
		UIInput input = (UIInput) e.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		if (inputValue.isEmpty()) {
			String cacsBusFmCode = PM_IL_CODES_ACCOUNT_SETUP_BEAN
					.getCACS_BUS_FM_CODE();
			if (!cacsBusFmCode.trim().equals("0")) {
				getCOMP_CACS_BUS_TO_CODE().setSubmittedValue(cacsBusFmCode);
				PM_IL_CODES_ACCOUNT_SETUP_BEAN
						.setCACS_BUS_TO_CODE(cacsBusFmCode);
			} else {
				getCOMP_CACS_BUS_TO_CODE().setSubmittedValue(z_Constant);
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_BUS_TO_CODE(z_Constant);
			}
		} else {
			getCOMP_CACS_BUS_TO_CODE().setSubmittedValue(inputValue);
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_BUS_TO_CODE(inputValue);
			ErrorHelpUtil.validate(input, getErrorMap());
		}
	}

	public void validateCACS_DIVN_FM_CODE(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput htmlInputText = (UIInput) actionEvent.getComponent()
				.getParent();
		String inputValue = (String) htmlInputText.getSubmittedValue();
		if (inputValue.isEmpty()) {
			getCOMP_CACS_DIVN_FM_CODE().setSubmittedValue("0");
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DIVN_FM_CODE("0");
		} else {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DIVN_FM_CODE(inputValue);
			ErrorHelpUtil.validate(htmlInputText, getErrorMap());
		}
	}

	public void validateCACS_DIVN_FM_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DIVN_FM_CODE((String) value);
		try {
			if (!"0".equals(value)) {
				String query = "SELECT  'X' FROM FM_DIVISION WHERE DIVN_CODE = ?    ";
				Boolean flag = null;
				flag = isValidateLovCode(query, new Object[] {value});
				if (flag == false) {
					throw new Exception("Code does not Exists.Please Re-enter");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCACS_DIVN_TO_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DIVN_TO_CODE((String) value);
		String P_FROM_CODE = PM_IL_CODES_ACCOUNT_SETUP_BEAN
				.getCACS_DIVN_FM_CODE();
		String P_TO_CODE = PM_IL_CODES_ACCOUNT_SETUP_BEAN
				.getCACS_DIVN_TO_CODE();
		try {
			if (!z_Constant.equals(value)) {
				String query = "SELECT  'X' FROM FM_DIVISION WHERE DIVN_CODE = ?    ";
				Boolean flag = null;
				flag = isValidateLovCode(query, new Object[] {value});
				if (flag == false) {
					throw new Exception("Code does not Exists.Please Re-enter");
				}
			}
			if (P_FROM_CODE == null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80033"));
			}
			if (P_TO_CODE.compareTo(P_FROM_CODE) < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80034"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void CACS_DIVN_TO_CODE_WHEN_VALIDATE_ITEM(ActionEvent e) {
		getWarningMap().clear();
		UIInput input = (UIInput) e.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		if (inputValue.isEmpty()) {
			String cacsDivnFmCode = PM_IL_CODES_ACCOUNT_SETUP_BEAN
					.getCACS_DIVN_FM_CODE();
			if (!cacsDivnFmCode.trim().equals("0")) {
				getCOMP_CACS_DIVN_TO_CODE().setSubmittedValue(cacsDivnFmCode);
				PM_IL_CODES_ACCOUNT_SETUP_BEAN
						.setCACS_DIVN_TO_CODE(cacsDivnFmCode);
			} else {
				getCOMP_CACS_DIVN_TO_CODE().setSubmittedValue(z_Constant);
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DIVN_TO_CODE(z_Constant);
			}
		} else {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DIVN_TO_CODE(inputValue);
			ErrorHelpUtil.validate(input, getErrorMap());
		}
	}

	public void validateCACS_DEPT_FM_CODE(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput htmlInputText = (UIInput) actionEvent.getComponent()
				.getParent();
		String inputValue = (String) htmlInputText.getSubmittedValue();
		if (inputValue.isEmpty()) {
			getCOMP_CACS_DEPT_FM_CODE().setSubmittedValue("0");
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DEPT_FM_CODE("0");
		} else {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DEPT_FM_CODE(inputValue);
			ErrorHelpUtil.validate(htmlInputText, getErrorMap());
		}
	}

	public void validateCACS_DEPT_FM_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DEPT_FM_CODE((String) value);
		try {
			if (!"0".equals(value)) {
				String query = "SELECT 'X' FROM FM_DEPARTMENT WHERE DEPT_CODE = ? ";
				Boolean flag = null;
				flag = isValidateLovCode(query, new Object[] { value });
				if (flag == false) {
					throw new Exception("Code does not Exists.Please Re-enter");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCACS_DEPT_TO_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DEPT_TO_CODE((String) value);
		String P_FROM_CODE = PM_IL_CODES_ACCOUNT_SETUP_BEAN
				.getCACS_DEPT_FM_CODE();
		String P_TO_CODE = PM_IL_CODES_ACCOUNT_SETUP_BEAN
				.getCACS_DEPT_TO_CODE();
		try {
			if (!z_Constant.equals(value)) {
				String query = "SELECT 'X' FROM FM_DEPARTMENT WHERE DEPT_CODE = ? ";
				Boolean flag = null;
				flag = isValidateLovCode(query, new Object[] { value });
				if (flag == false) {
					throw new Exception("Code does not Exists.Please Re-enter");
				}
			}

			if (P_FROM_CODE == null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80033"));
			}
			if (P_TO_CODE.compareTo(P_FROM_CODE) < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80034"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void CACS_DEPT_TO_CODE_WHEN_VALIDATE_ITEM(ActionEvent e) {
		getWarningMap().clear();
		UIInput input = (UIInput) e.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		if (inputValue.isEmpty()) {
			String cacsDeptFmCode = PM_IL_CODES_ACCOUNT_SETUP_BEAN
					.getCACS_DEPT_FM_CODE();
			if (!cacsDeptFmCode.trim().equals("0")) {
				getCOMP_CACS_DEPT_TO_CODE().setSubmittedValue(cacsDeptFmCode);
				PM_IL_CODES_ACCOUNT_SETUP_BEAN
						.setCACS_DEPT_TO_CODE(cacsDeptFmCode);
			} else {
				getCOMP_CACS_DEPT_TO_CODE().setSubmittedValue(z_Constant);
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DEPT_TO_CODE(z_Constant);
			}
		} else {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DEPT_TO_CODE(inputValue);
			ErrorHelpUtil.validate(input, getErrorMap());
		}
	}

	public void validateCACS_DOC_FM_TYPE(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput htmlInputText = (UIInput) actionEvent.getComponent()
				.getParent();
		String inputValue = (String) htmlInputText.getSubmittedValue();

		if (inputValue.isEmpty()) {
			getCOMP_CACS_DOC_FM_TYPE().setSubmittedValue("0");
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DOC_FM_TYPE("0");
		} else {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DOC_FM_TYPE(inputValue);
			ErrorHelpUtil.validate(htmlInputText, getErrorMap());
		}
	}

	public void validateCACS_DOC_FM_TYPE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DOC_FM_TYPE((String) value);
		try {
			if (!"0".equals(value)) {
				String query = "SELECT  'X' FROM  PM_IL_DOC_SETUP WHERE DS_CODE = ? ";
				Boolean flag = null;
				flag = isValidateLovCode(query, new Object[] { value });
				if (flag == false) {
					throw new Exception("Code does not Exists.Please Re-enter");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCACS_DOC_TO_TYPE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DOC_TO_TYPE((String) value);
		String P_FROM_CODE = PM_IL_CODES_ACCOUNT_SETUP_BEAN
				.getCACS_DOC_FM_TYPE();
		String P_TO_CODE = PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DOC_TO_TYPE();
		try {
			if (!z_Constant.equals(value)) {
				String query = "SELECT  'X' FROM  PM_IL_DOC_SETUP WHERE DS_CODE = ? ";
				Boolean flag = null;
				flag = isValidateLovCode(query, new Object[] { value });
				if (flag == false) {
					throw new Exception("Code does not Exists.Please Re-enter");
				}
			}

			if (P_FROM_CODE == null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80033"));
			}
			if (P_TO_CODE.compareTo(P_FROM_CODE) < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80034"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void CACS_DOC_TO_TYPE_WHEN_VALIDATE_ITEM(ActionEvent e) {
		getWarningMap().clear();
		UIInput input = (UIInput) e.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		if (inputValue.isEmpty()) {
			String cacsDocFmType = PM_IL_CODES_ACCOUNT_SETUP_BEAN
					.getCACS_DOC_FM_TYPE();
			if (!cacsDocFmType.trim().equals("0")) {
				getCOMP_CACS_DOC_TO_TYPE().setSubmittedValue(cacsDocFmType);
				PM_IL_CODES_ACCOUNT_SETUP_BEAN
						.setCACS_DOC_TO_TYPE(cacsDocFmType);
			} else {
				getCOMP_CACS_DOC_TO_TYPE().setSubmittedValue(z_Constant);
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DOC_TO_TYPE(z_Constant);
			}
		} else {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DOC_TO_TYPE(inputValue);
			ErrorHelpUtil.validate(input, getErrorMap());
		}
	}

	public void validateCACS_CUST_CLS_FM_CODE(ActionEvent actionEvent) {
		
		getWarningMap().clear();
		UIInput htmlInputText = (UIInput) actionEvent.getComponent()
				.getParent();
		String inputValue = (String) htmlInputText.getSubmittedValue();
		System.out.println("Input Value: " + inputValue);
		if (inputValue.isEmpty()) {
			getCOMP_CACS_CUST_CLS_FM_CODE().setSubmittedValue("0");
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_CUST_CLS_FM_CODE("0");
		} else {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_CUST_CLS_FM_CODE(inputValue);
			ErrorHelpUtil.validate(htmlInputText, getErrorMap());
		}
	}

	public void validateCACS_CUST_CLS_FM_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_CUST_CLS_FM_CODE((String) value);
		try {
			if (!"0".equals(value)) {
				String query = "SELECT  'X' FROM PM_CUST_CLASS WHERE CCLAS_CODE = ? ";
				Boolean flag = null;
				flag = isValidateLovCode(query, new Object[] { value });
				if (flag == false) {
					throw new Exception("Code does not Exists.Please Re-enter");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCACS_CUST_CLS_TO_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_CUST_CLS_TO_CODE((String) value);
		String P_FROM_CODE = PM_IL_CODES_ACCOUNT_SETUP_BEAN
				.getCACS_CUST_CLS_FM_CODE();
		String P_TO_CODE = PM_IL_CODES_ACCOUNT_SETUP_BEAN
				.getCACS_CUST_CLS_TO_CODE();
		try {
			if (!z_Constant.equals(value)) {
				String query = "SELECT  'X' FROM PM_CUST_CLASS WHERE CCLAS_CODE = ? ";
				Boolean flag = null;
				flag = isValidateLovCode(query, new Object[] { value });
				if (flag == false) {
					throw new Exception("Code does not Exists.Please Re-enter");
				}
			}

			if (P_FROM_CODE == null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80033"));
			}
			if (P_TO_CODE.compareTo(P_FROM_CODE) < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80034"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void CACS_CUST_CLS_TO_CODE_WHEN_VALIDATE_ITEM(ActionEvent e) {
		getWarningMap().clear();
		UIInput input = (UIInput) e.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		System.out.println("");
		if (inputValue.isEmpty()) {
			String cacsClsfmCode = PM_IL_CODES_ACCOUNT_SETUP_BEAN
					.getCACS_CUST_CLS_FM_CODE();
			if (!cacsClsfmCode.trim().equals("0")) {
				getCOMP_CACS_CUST_CLS_TO_CODE()
						.setSubmittedValue(cacsClsfmCode);
				PM_IL_CODES_ACCOUNT_SETUP_BEAN
						.setCACS_CUST_CLS_TO_CODE(cacsClsfmCode);
			} else {
				getCOMP_CACS_CUST_CLS_TO_CODE().setSubmittedValue(z_Constant);
				PM_IL_CODES_ACCOUNT_SETUP_BEAN
						.setCACS_CUST_CLS_TO_CODE(z_Constant);
			}
		} else {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_CUST_CLS_TO_CODE(inputValue);
			ErrorHelpUtil.validate(input, getErrorMap());
		}
	}

	public void validateCACS_COVER_CODE_FM(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput htmlInputText = (UIInput) actionEvent.getComponent()
				.getParent();
		String inputValue = (String) htmlInputText.getSubmittedValue();
		if (inputValue.isEmpty()) {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_COVER_CODE_FM("0");
			getCOMP_CACS_COVER_CODE_FM().setSubmittedValue("0");
		} else {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_COVER_CODE_FM(inputValue);
			ErrorHelpUtil.validate(htmlInputText, getErrorMap());
		}
	}

	public void validateCACS_COVER_CODE_FM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_COVER_CODE_FM((String) value);
		try {
			if (!"0".equals(value)) {
				String query = "SELECT 'X'  FROM PM_IL_COVER WHERE COVER_CODE = ? ";
				Boolean flag = null;
				flag = isValidateLovCode(query, new Object[] { value });
				if (flag == false) {
					throw new Exception("Code does not Exists.Please Re-enter");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCACS_COVER_CODE_TO(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_COVER_CODE_TO((String) value);
		String P_FROM_CODE = PM_IL_CODES_ACCOUNT_SETUP_BEAN
				.getCACS_COVER_CODE_FM();
		String P_TO_CODE = PM_IL_CODES_ACCOUNT_SETUP_BEAN
				.getCACS_COVER_CODE_TO();
		try {
			if (!z_Constant.equals(value)) {
				String query = "SELECT 'X'  FROM PM_IL_COVER WHERE COVER_CODE = ? ";
				Boolean flag = null;
				flag = isValidateLovCode(query, new Object[] { value });
				if (flag == false) {
					throw new Exception("Code does not Exists.Please Re-enter");
				}
			}
			if (P_FROM_CODE == null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80033"));
			}
			if (P_TO_CODE.compareTo(P_FROM_CODE) < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80034"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public static final String z_Constant = "zzzzzzzzzz";

	public void CACS_COVER_CODE_TO_WHEN_VALIDATE_ITEM(ActionEvent e) {
		getWarningMap().clear();
		UIInput input = (UIInput) e.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		if (inputValue.isEmpty()) {
			String cacsCoverCodeFm = PM_IL_CODES_ACCOUNT_SETUP_BEAN
					.getCACS_COVER_CODE_FM();
			if (!cacsCoverCodeFm.trim().equals("0")) {
				getCOMP_CACS_COVER_CODE_TO().setSubmittedValue(cacsCoverCodeFm);
				PM_IL_CODES_ACCOUNT_SETUP_BEAN
						.setCACS_COVER_CODE_TO(cacsCoverCodeFm);
			} else {
				getCOMP_CACS_COVER_CODE_TO().setSubmittedValue(z_Constant);
				PM_IL_CODES_ACCOUNT_SETUP_BEAN
						.setCACS_COVER_CODE_TO(z_Constant);
			}
		} else {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_COVER_CODE_TO(inputValue);
			ErrorHelpUtil.validate(input, getErrorMap());
		}
	}

	public void validateCACS_PROD_CODE_FM(ActionEvent actionEvent)
			throws ValidatorException {
		getWarningMap().clear();
		UIInput htmlInputText = (UIInput) actionEvent.getComponent()
				.getParent();
		String inputValue = (String) htmlInputText.getSubmittedValue();
		if (inputValue.isEmpty()) {
			getCOMP_CACS_PROD_CODE_FM().setSubmittedValue("0");
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_PROD_CODE_FM("0");
		} else {

			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_PROD_CODE_FM(inputValue);
			ErrorHelpUtil.validate(htmlInputText, getErrorMap());
		}
	}

	public void validateCACS_PROD_CODE_FM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_PROD_CODE_FM((String) value);
		try {
			if (!"0".equals(value)) {

				String query = "SELECT 'X' FROM PM_IL_PRODUCT WHERE PROD_CODE = ? ";
				Boolean flag = null;
				flag = isValidateLovCode(query, new Object[] { value });
				if (flag == false) {
					throw new Exception("Code does not Exists.Please Re-enter");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCACS_PROD_CODE_TO(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_PROD_CODE_TO((String) value);
		String P_FROM_CODE = PM_IL_CODES_ACCOUNT_SETUP_BEAN
				.getCACS_PROD_CODE_FM();
		String P_TO_CODE = PM_IL_CODES_ACCOUNT_SETUP_BEAN
				.getCACS_PROD_CODE_TO();
		try {
			if (!z_Constant.equals(value)) {
				String query = "SELECT 'X' FROM PM_IL_PRODUCT WHERE PROD_CODE = ? ";
				Boolean flag = null;
				flag = isValidateLovCode(query, new Object[] { value });
				if (flag == false) {
					throw new Exception("Code does not Exists.Please Re-enter");
				}
			}
			if (P_FROM_CODE == null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80033"));
			}
			if (P_TO_CODE.compareTo(P_FROM_CODE) < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80034"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void CACS_PROD_CODE_TO_WHEN_VALIDATE_ITEM(ActionEvent e) {
		getWarningMap().clear();
		UIInput input = (UIInput) e.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		String cacsProdCodeFm = PM_IL_CODES_ACCOUNT_SETUP_BEAN
				.getCACS_PROD_CODE_FM();
		if (inputValue.isEmpty()) {
			if (!cacsProdCodeFm.trim().equals("0")) {
				getCOMP_CACS_PROD_CODE_TO().setSubmittedValue(cacsProdCodeFm);
				PM_IL_CODES_ACCOUNT_SETUP_BEAN
						.setCACS_PROD_CODE_TO(cacsProdCodeFm);
			} else {
				getCOMP_CACS_PROD_CODE_TO().setSubmittedValue(z_Constant);
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_PROD_CODE_TO(z_Constant);
			}
		} else {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_PROD_CODE_TO(inputValue);
			ErrorHelpUtil.validate(input, getErrorMap());
		}
	}

	public void validateCACS_SETUP_TYPE(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_SETUP_TYPE(inputValue);
		PM_IL_CODES_ACCOUNT_SETUP_HELPER helper = new PM_IL_CODES_ACCOUNT_SETUP_HELPER();
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction = (PM_IL_CODES_ACCOUNT_SETUP_ACTION) (commonUtils
				.getMappedBeanFromSession("PILM023_PM_IL_CODES_ACCOUNT_SETUP_ACTION"));
		try {
			helper.validateCACS_SETUP(accountSetupAction);
			ErrorHelpUtil.validate(input, getErrorMap());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateCACS_SETUP_FOR(ActionEvent actionEvent) {
		
		getWarningMap().clear();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		System.out.println("Selected Value :" + inputValue);
		try {
			if (inputValue == null) {
				throw new ValidatorException(Messages.getMessage(
						"com.iii.errorUtil.PELErrorMessages", "91022"));
			} else {
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_SETUP_FOR(inputValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateCACS_ASSURED_TYPE(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		System.out.println("Selected Value :" + inputValue);
		try {
			if (inputValue == null) {
				throw new ValidatorException(Messages.getMessage(
						"com.iii.errorUtil.PELErrorMessages", "91022"));
			} else {
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_ASSURED_TYPE(inputValue);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateCACS_TYPE_FM_CODE(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		System.out.println("Selected Value :" + inputValue);
		if (inputValue != null) {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_TYPE_FM_CODE(inputValue);
		}
	}

	public void validateCACS_TYPE_TO_CODE(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		String P_FROM_CODE = PM_IL_CODES_ACCOUNT_SETUP_BEAN
				.getCACS_TYPE_FM_CODE();

		if (inputValue.isEmpty()) {
			if ("0".equals(P_FROM_CODE)) {
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_TYPE_TO_CODE(z_Constant);
			} else {
				PM_IL_CODES_ACCOUNT_SETUP_BEAN
						.setCACS_TYPE_TO_CODE(P_FROM_CODE);
			}
		} else {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_TYPE_TO_CODE(inputValue);
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_TYPE_TO_CODE(inputValue);
			ErrorHelpUtil.validate(input, getErrorMap());
		}
	}

	public void validateCACS_FIRST_PREM_YN(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();

		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_FIRST_PREM_YN(inputValue);
		if (inputValue.equals("Y")) {
			COMP_CACS_YRS_FM.setSubmittedValue("1.0");
			COMP_CACS_YRS_TO.setSubmittedValue("1.0");
			PM_IL_CODES_ACCOUNT_SETUP_BEAN
					.setCACS_YRS_FM(Integer.parseInt("1"));
			PM_IL_CODES_ACCOUNT_SETUP_BEAN
					.setCACS_YRS_TO(Integer.parseInt("1"));
			COMP_CACS_YRS_FM.setReadonly(true);
			COMP_CACS_YRS_TO.setReadonly(true);
		} else if (inputValue.equals("N")) {
			COMP_CACS_YRS_FM.setReadonly(false);
			COMP_CACS_YRS_TO.setReadonly(false);
		}
	}

	public void validateCACS_YRS_FM(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		getErrorMap().clear();
		if (inputValue.isEmpty()) {
			getCOMP_CACS_YRS_FM().setSubmittedValue("0");
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_YRS_FM(0);
		} else {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_YRS_FM(Integer
					.parseInt(inputValue));

		}

		if (inputValue != null && !inputValue.isEmpty()) {
			Integer yrsFm = PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_YRS_FM();
			Integer yrsTo = PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_YRS_TO();
			if (yrsFm < 0) {
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "91018"));
			}
			if (yrsTo != null) {
				if (yrsFm > yrsTo) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91031"));
				}
			}
		}
	}

	public void validateCACS_YRS_TO(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		Integer yrsFm = PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_YRS_FM();
		if (inputValue.isEmpty()) {
			if (yrsFm != 0) {
				getCOMP_CACS_YRS_TO().setSubmittedValue(yrsFm.toString());
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_YRS_TO(yrsFm);
			} else {
				getCOMP_CACS_YRS_TO().setSubmittedValue("9999");
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_YRS_TO(Integer
						.parseInt("9999"));
			}
		} else {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_PROD_CODE_TO(inputValue);
			ErrorHelpUtil.validate(input, getErrorMap());
		}

	}

	public void validateCACS_FORCE_DIVN_YN(FacesContext context,UIComponent component,
			Object value) {
		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_FORCE_DIVN_YN((String) value);
			String cacsForceDivnYn = PM_IL_CODES_ACCOUNT_SETUP_BEAN
					.getCACS_FORCE_DIVN_YN();

			if (cacsForceDivnYn.equals("Y")) {
				getCOMP_CACS_DIVN_CODE().setDisabled(true);
				PM_IL_CODES_ACCOUNT_SETUP_BEAN
						.setCACS_FORCE_DEPT_YN(cacsForceDivnYn);
				getCOMP_CACS_DEPT_CODE().setDisabled(true);
				getCOMP_CACS_DIVN_CODE().setRequired(false);
				getCOMP_CACS_DEPT_CODE().setRequired(false);
			} else if (cacsForceDivnYn.equals("N")) {
				getCOMP_CACS_DIVN_CODE().setDisabled(false);
				getCOMP_CACS_DIVN_CODE().setRequired(true);
				COMP_CACS_FORCE_DEPT_YN.setSubmittedValue(cacsForceDivnYn);
				PM_IL_CODES_ACCOUNT_SETUP_BEAN
						.setCACS_FORCE_DEPT_YN(cacsForceDivnYn);
				getCOMP_CACS_DEPT_CODE().setDisabled(false);
				getCOMP_CACS_DEPT_CODE().setRequired(true);
			}

				/*COMP_CACS_DEPT_CODE.resetValue();
				COMP_CACS_DIVN_CODE.resetValue();
				COMP_UI_M_DEPT_NAME.resetValue();
				COMP_UI_M_DIVN_NAME.resetValue();*/
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateCACS_FORCE_DEPT_YN(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		if (inputValue != null) {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_FORCE_DEPT_YN(inputValue);
			String cacsForceDeptYn = PM_IL_CODES_ACCOUNT_SETUP_BEAN
					.getCACS_FORCE_DEPT_YN();
			if (cacsForceDeptYn.equals("Y")) {
				getCOMP_CACS_DEPT_CODE().setDisabled(true);
				COMP_CACS_FORCE_DEPT_YN
						.setSubmittedValue(PM_IL_CODES_ACCOUNT_SETUP_BEAN
								.getCACS_FORCE_DIVN_YN());
			} else if (cacsForceDeptYn.equals("N")) {
				getCOMP_CACS_DEPT_CODE().setDisabled(false);
				COMP_CACS_FORCE_DEPT_YN
						.setSubmittedValue(PM_IL_CODES_ACCOUNT_SETUP_BEAN
								.getCACS_FORCE_DIVN_YN());
			}
		}
	}

	public void whenValidateCACS_FORCE_DEPT_YN(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		if (inputValue != null) {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_FORCE_DEPT_YN(inputValue);
			String cacsForceDeptYn = PM_IL_CODES_ACCOUNT_SETUP_BEAN
					.getCACS_FORCE_DEPT_YN();
			if (cacsForceDeptYn.equals("Y")) {
				getCOMP_CACS_DEPT_CODE().setDisabled(true);
			} else if (cacsForceDeptYn.equals("N")) {
				getCOMP_CACS_DEPT_CODE().setDisabled(false);
			}
		}
	}

	public void CACS_MAIN_ACNT_CODE_WHEN_VALIDATE(ActionEvent e) {
		getWarningMap().clear();
		UIInput input = (UIInput) e.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		if (inputValue != null) {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_MAIN_ACNT_CODE(inputValue);
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateCACS_MAIN_ACNT_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction = (PM_IL_CODES_ACCOUNT_SETUP_ACTION) (commonUtils
				.getMappedBeanFromSession("PILM023_PM_IL_CODES_ACCOUNT_SETUP_ACTION"));
		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_MAIN_ACNT_CODE((String) value);
		try {

			String query = "SELECT 'X' FROM FM_MAIN_ACCOUNT WHERE MAIN_ACNT_CODE = ?";
			Boolean flag = null;
			flag = isValidateLovCode(query, new Object[] { value });
			if (flag == false) {
				throw new Exception("Code does not Exists.Please Re-enter");
			}
			helper.validateCACS_MAIN_ACNT_CODE(accountSetupAction);
			/*COMP_UI_M_MAIN_ACNT_NAME.resetValue();
			//COMP_CACS_SUB_ACNT_CODE.resetValue();
			COMP_UI_M_SUB_ACNT_NAME.resetValue();
			COMP_CACS_ACTY_CODE_1.resetValue();
			COMP_UI_M_ACTY_NAME.resetValue();
			COMP_CACS_ACTY_CODE_2.resetValue();
			COMP_UI_M_ACTY_NAME_1.resetValue();*/
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void CACS_SUB_ACNT_CODE_WHEN_VALIDATE(ActionEvent e) {
		
		getWarningMap().clear();
		UIInput input = (UIInput) e.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateCACS_SUB_ACNT_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_SUB_ACNT_CODE((String) value);
		PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction = (PM_IL_CODES_ACCOUNT_SETUP_ACTION) (commonUtils
				.getMappedBeanFromSession("PILM023_PM_IL_CODES_ACCOUNT_SETUP_ACTION"));
		PM_IL_CODES_ACCOUNT_SETUP_HELPER helper = new PM_IL_CODES_ACCOUNT_SETUP_HELPER();
		try {
			String query = "SELECT 'X' FROM FM_SUB_ACCOUNT WHERE SUB_ACNT_CODE = ? ";
			Boolean flag = null;
			flag = isValidateLovCode(query, new Object[] { value });
			if (flag == false) {
				throw new Exception("Code does not Exists.Please Re-enter");
			}
			helper.validateCACS_SUB_ACNT_CODE(accountSetupAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void CACS_DIVN_CODE_WHEN_VALIDATE(ActionEvent e) {
	
		getWarningMap().clear();
		UIInput input = (UIInput) e.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		if (inputValue != null) {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DIVN_CODE(inputValue);
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public void CACS_DEPT_CODE_WHEN_VALIDATE(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateCACS_DIVN_CODE(FacesContext context,
			UIComponent component, Object value) {
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DIVN_CODE((String) value);
		PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction = (PM_IL_CODES_ACCOUNT_SETUP_ACTION) (commonUtils
				.getMappedBeanFromSession("PILM023_PM_IL_CODES_ACCOUNT_SETUP_ACTION"));

		try {
			String query = "SELECT 'X' FROM FM_DIVISION WHERE DIVN_CODE = ? ";
			Boolean flag = null;
			flag = isValidateLovCode(query, new Object[] { value });
			if (flag == false) {
				throw new Exception("Code does not Exists.Please Re-enter");
			}
			helper.validateCACS_DIVN_CODE(accountSetupAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCACS_DEPT_CODE(FacesContext context,
			UIComponent component, Object value) {
		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DEPT_CODE((String) value);
	try {
		//PM_IL_CODES_ACCOUNT_SETUP_BEAN.getUI_M_DEPT_NAME(null);
		if(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DEPT_CODE() !=null){
			
		 ArrayList<String> list   =new DBProcedures().F_VAL_DEPT(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DIVN_CODE(),
		                PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DEPT_CODE(),"N","E");
		 if(!list.isEmpty() && list.size() > 0) {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_DEPT_NAME(list.get(0));
		 }
		if ("N".equals(CommonUtils.nvl(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_FORCE_DEPT_YN(), "N")))
		{
			getCOMP_CACS_DEPT_CODE().setRequired(true);
		}
		}
		}catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void CACS_ANLY_CODE_1_WHEN_VALIDATE(ActionEvent e) {
		getWarningMap().clear();
		UIInput input = (UIInput) e.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		if (inputValue != null) {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_ANLY_CODE_1(inputValue);
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateCACS_ANLY_CODE_1(FacesContext context,
			UIComponent component, Object value) {
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_ANLY_CODE_1((String) value);
		PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction = (PM_IL_CODES_ACCOUNT_SETUP_ACTION) (commonUtils
				.getMappedBeanFromSession("PILM023_PM_IL_CODES_ACCOUNT_SETUP_ACTION"));
		PM_IL_CODES_ACCOUNT_SETUP_HELPER helper = new PM_IL_CODES_ACCOUNT_SETUP_HELPER();
		try {
			String query = "SELECT  'X' FROM   FM_ANALYSIS   WHERE  ANLY_CODE  = ? ";
			Boolean flag = null;
			flag = isValidateLovCode(query, new Object[] { value });
			if (flag == false) {
				throw new Exception("Code does not Exists.Please Re-enter");
			}
			helper.validateCACS_ANLY_CODE_1(accountSetupAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void CACS_ANLY_CODE_2_WHEN_VALIDATE(ActionEvent e) {
		getWarningMap().clear();
		UIInput input = (UIInput) e.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		if (inputValue != null) {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_ANLY_CODE_2(inputValue);
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateCACS_ANLY_CODE_2(FacesContext context,
			UIComponent component, Object value) {
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_ANLY_CODE_2((String) value);
		PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction = (PM_IL_CODES_ACCOUNT_SETUP_ACTION) (commonUtils
				.getMappedBeanFromSession("PILM023_PM_IL_CODES_ACCOUNT_SETUP_ACTION"));

		try {
			String query = "SELECT  'X' FROM   FM_ANALYSIS   WHERE  ANLY_CODE  = ? ";
			Boolean flag = null;
			flag = isValidateLovCode(query, new Object[] { value });
			if (flag == false) {
				throw new Exception("Code does not Exists.Please Re-enter");
			}
			helper.validateCACS_ANLY_CODE_2(accountSetupAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void CACS_ACTY_CODE_1_WHEN_VALIDATE(ActionEvent e) {
		getWarningMap().clear();
		UIInput input = (UIInput) e.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		if (inputValue != null) {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_ACTY_CODE_1(inputValue);
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateCACS_ACTY_CODE_1(FacesContext context,
			UIComponent component, Object value) {
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_ACTY_CODE_1((String) value);
		PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction = (PM_IL_CODES_ACCOUNT_SETUP_ACTION) (commonUtils
				.getMappedBeanFromSession("PILM023_PM_IL_CODES_ACCOUNT_SETUP_ACTION"));

		try {
			String query = "SELECT 'X' FROM   FM_ACTY_VALUE WHERE  AVAL_CODE =  ?";
			Boolean flag = null;
			flag = isValidateLovCode(query, new Object[] { value });
			if (flag == false) {
				throw new Exception("Code does not Exists.Please Re-enter");
			}
			helper.validateCACS_ACTY_CODE_1(accountSetupAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void CACS_ACTY_CODE_2_WHEN_VALIDATE(ActionEvent e) {
		getWarningMap().clear();
		UIInput input = (UIInput) e.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		if (inputValue != null) {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_ACTY_CODE_2(inputValue);
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateCACS_ACTY_CODE_2(FacesContext context,
			UIComponent component, Object value) {
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_ACTY_CODE_2((String) value);
		PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction = (PM_IL_CODES_ACCOUNT_SETUP_ACTION) (commonUtils
				.getMappedBeanFromSession("PILM023_PM_IL_CODES_ACCOUNT_SETUP_ACTION"));

		try {
			String query = "SELECT 'X' FROM   FM_ACTY_VALUE WHERE  AVAL_CODE =  ?";
			Boolean flag = null;
			flag = isValidateLovCode(query, new Object[] { value });
			if (flag == false) {
				throw new Exception("Code does not Exists.Please Re-enter");
			}
			helper.Validatecacs_acty_code_2(accountSetupAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void setFreezeFlag(ActionEvent event) {
		getWarningMap().clear();
		UIInput input = (UIInput) event.getComponent().getParent();
		String freezeFlagValue = (String) input.getSubmittedValue();
		if ("TRUE".equalsIgnoreCase(freezeFlagValue)) {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setFRZ_FLAG(true);
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_FRZ_FLAG("Y");
		} else {
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setFRZ_FLAG(false);
			PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_FRZ_FLAG("N");
		}
	}

	public void postQuery(PM_IL_CODES_ACCOUNT_SETUP PM_IL_CODES_ACCOUNT_SETUP_BEAN) throws Exception {
		String CURSOR_C1 = "SELECT MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2 FROM   FM_MAIN_ACCOUNT WHERE  MAIN_ACNT_CODE  = ? ";
		ResultSet resultSet = null;
		String M_ACTY_1 = null;
		String M_ACTY_2 = null;

		try {
			if (PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_MAIN_ACNT_CODE() != null) {

				resultSet = new CRUDHandler().executeSelectStatement(CURSOR_C1,
						CommonUtils.getConnection(), new Object[] { PM_IL_CODES_ACCOUNT_SETUP_BEAN
								.getCACS_MAIN_ACNT_CODE() });
				if (resultSet.next()) {
					M_ACTY_1 = resultSet.getString(1);
					M_ACTY_2 = resultSet.getString(2);
				}

				ArrayList<OracleParameter> list = P_VAL_MAIN_ACNT(PM_IL_CODES_ACCOUNT_SETUP_BEAN
						.getCACS_MAIN_ACNT_CODE(), PM_IL_CODES_ACCOUNT_SETUP_BEAN
						.getUI_M_MAIN_ACNT_NAME(), "N", "N");
				if (list != null && !list.isEmpty()) {
					PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_MAIN_ACNT_NAME((String) list.get(0)
							.getValueObject());
				}
			}

			if (PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_SUB_ACNT_CODE() != null) {
				ArrayList<OracleParameter> list1 = P_VAL_SUB_ACNT(PM_IL_CODES_ACCOUNT_SETUP_BEAN
						.getCACS_MAIN_ACNT_CODE(), PM_IL_CODES_ACCOUNT_SETUP_BEAN
						.getCACS_SUB_ACNT_CODE(), PM_IL_CODES_ACCOUNT_SETUP_BEAN
						.getUI_M_SUB_ACNT_NAME(), "N", "N");
				if (list1 != null && !list1.isEmpty()) {
					PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_SUB_ACNT_NAME((String) list1.get(0)
							.getValueObject());
				}
			}

			if (PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_ANLY_CODE_1() != null) {
				ArrayList<String> list2 = new DBProcedures().P_VAL_ANLY1("1",
						PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_ANLY_CODE_1(), "N", "N");
				if (list2 != null && !list2.isEmpty()) {
					PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_ANLY_NAME(list2.get(0));
				}
			}

			if (PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_ANLY_CODE_2() != null) {
				ArrayList<String> list3 = new DBProcedures().P_VAL_ANLY1("2",
						PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_ANLY_CODE_2(), "N", "N");
				if (list3 != null && !list3.isEmpty()) {
					PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_ANLY_NAME_1(list3.get(0));
				}
			}

			if (PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_ACTY_CODE_1() != null) {
				ArrayList<String> list4 = new DBProcedures().P_VAL_ACTY(
						M_ACTY_1, PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_ACTY_CODE_1(), "N", "N");
				if (list4 != null && !list4.isEmpty()) {
					PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_1(list4.get(0));
				}
			}

			if (PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_ACTY_CODE_2() != null) {
				ArrayList<String> list5 = new DBProcedures().P_VAL_ACTY(
						M_ACTY_2, PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_ACTY_CODE_2(), "N", "N");
				if (list5 != null && !list5.isEmpty()) {
					PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_2(list5.get(0));
				}
			}

			if (PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DIVN_CODE() != null) {
				ArrayList<OracleParameter> list6 = new DBProcedures().P_VAL_DIVN(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DIVN_CODE(),null,"N", "N");
				
				/*ArrayList<String> list6 = new GLCommonProcedures.F_VAL_DIVN(String P_DIVN_COMP_CODE,
						String P_DIVN_CODE, String P_INDIC, String P_LANG_CODE,
						String P_ERR_FLAG);*/
				if (list6 != null && !list6.isEmpty()) {
					PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_DIVN_NAME(list6.get(0).getValue());
				}
			}

			if (PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DEPT_CODE() != null) {
				String list7 = new DBProcedures().P_VAL_DEPT(PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DIVN_CODE(),
						 PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_DEPT_CODE(), "N", "N");
				if (list7 != null && !list7.isEmpty()) {
					PM_IL_CODES_ACCOUNT_SETUP_BEAN.setUI_M_DEPT_NAME(list7);
				}
			}

			CommonUtils.closeCursor(resultSet);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	/**
	 * 
	 * @param P_MAIN_ACNT_CODE-IN
	 * @param P_MAIN_ACNT_NAME-IN
	 *            OUT
	 * @param P_NAME_FLAG-IN
	 * @param P_ERR_FLAG-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> P_VAL_MAIN_ACNT(Object P_MAIN_ACNT_CODE,
			Object P_MAIN_ACNT_NAME, Object P_NAME_FLAG, Object P_ERR_FLAG)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_MAIN_ACNT_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN OUT2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN_OUT, P_MAIN_ACNT_NAME);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_NAME_FLAG);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_ERR_FLAG);
			parameterList.add(param4);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P_VAL_MAIN_ACNT");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 * 
	 * @param P_MAIN_ACNT_CODE-IN
	 * @param P_SUB_ACNT_CODE-IN
	 * @param P_SUB_ACNT_NAME-IN
	 *            OUT
	 * @param P_NAME_FLAG-IN
	 * @param P_ERR_FLAG-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> P_VAL_SUB_ACNT(Object P_MAIN_ACNT_CODE,
			Object P_SUB_ACNT_CODE, Object P_SUB_ACNT_NAME, Object P_NAME_FLAG,
			Object P_ERR_FLAG) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_MAIN_ACNT_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_SUB_ACNT_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN OUT3",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN_OUT, P_SUB_ACNT_NAME);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_NAME_FLAG);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_ERR_FLAG);
			parameterList.add(param5);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P_VAL_SUB_ACNT");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 * Instantiates all components in PM_IL_CODES_ACCOUNT_SETUP_ACTION
	 */
	public void instantiateAllComponent() {
		// Instantiating HtmlInputText
		COMP_CACS_SRC_BUS_FM = new HtmlInputText();
		COMP_CACS_SRC_BUS_TO = new HtmlInputText();
		COMP_CACS_BUS_FM_CODE = new HtmlInputText();
		COMP_CACS_BUS_TO_CODE = new HtmlInputText();
		COMP_CACS_DIVN_FM_CODE = new HtmlInputText();
		COMP_CACS_DIVN_TO_CODE = new HtmlInputText();
		COMP_CACS_DEPT_FM_CODE = new HtmlInputText();
		COMP_CACS_DEPT_TO_CODE = new HtmlInputText();
		COMP_CACS_DOC_FM_TYPE = new HtmlInputText();
		COMP_CACS_DOC_TO_TYPE = new HtmlInputText();
		COMP_CACS_CUST_CLS_FM_CODE = new HtmlInputText();
		COMP_CACS_CUST_CLS_TO_CODE = new HtmlInputText();
		COMP_CACS_PROD_CODE_FM = new HtmlInputText();
		COMP_CACS_PROD_CODE_TO = new HtmlInputText();
		COMP_CACS_COVER_CODE_FM = new HtmlInputText();
		COMP_CACS_COVER_CODE_TO = new HtmlInputText();
		COMP_CACS_TYPE_FM_CODE = new HtmlInputText();
		COMP_CACS_TYPE_TO_CODE = new HtmlInputText();
		COMP_CACS_YRS_FM = new HtmlInputText();
		COMP_CACS_YRS_TO = new HtmlInputText();
		COMP_CACS_MAIN_ACNT_CODE = new HtmlInputText();
		COMP_UI_M_MAIN_ACNT_NAME = new HtmlInputText();
		COMP_CACS_SUB_ACNT_CODE = new HtmlInputText();
		COMP_UI_M_SUB_ACNT_NAME = new HtmlInputText();
		COMP_CACS_DIVN_CODE = new HtmlInputText();
		COMP_UI_M_DIVN_NAME = new HtmlInputText();
		COMP_CACS_DEPT_CODE = new HtmlInputText();
		COMP_UI_M_DEPT_NAME = new HtmlInputText();
		COMP_CACS_ANLY_CODE_1 = new HtmlInputText();
		COMP_UI_M_ANLY_NAME = new HtmlInputText();
		COMP_CACS_ANLY_CODE_2 = new HtmlInputText();
		COMP_UI_M_ANLY_NAME_1 = new HtmlInputText();
		COMP_CACS_ACTY_CODE_1 = new HtmlInputText();
		COMP_UI_M_ACTY_NAME = new HtmlInputText();
		COMP_CACS_ACTY_CODE_2 = new HtmlInputText();
		COMP_UI_M_ACTY_NAME_1 = new HtmlInputText();

		// Instantiating HtmlSelectOneMenu
		COMP_CACS_SETUP_TYPE = new HtmlSelectOneMenu();
		COMP_CACS_SETUP_FOR = new HtmlSelectOneMenu();
		COMP_CACS_ASSURED_TYPE = new HtmlSelectOneMenu();
		COMP_CACS_FIRST_PREM_YN = new HtmlSelectOneMenu();
		COMP_CACS_FORCE_DIVN_YN = new HtmlSelectOneMenu();
		COMP_CACS_FORCE_DEPT_YN = new HtmlSelectOneMenu();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_CUST_CLS_FM_LOV = new HtmlCommandButton();
		COMP_UI_M_BUT_CUST_CLS_TO_LOV = new HtmlCommandButton();
		COMP_UI_M_BUT_CACS_SRC_BUS_FM = new HtmlCommandButton();
		COMP_UI_M_BUT_CACS_SRC_BUS_TO = new HtmlCommandButton();
		COMP_UI_M_BUT_CACS_BUS_FM_CODE = new HtmlCommandButton();
		COMP_UI_M_BUT_CACS_BUS_TO_CODE = new HtmlCommandButton();
		COMP_UI_M_BUT_ACTY_2 = new HtmlCommandButton();
		COMP_UI_M_BUT_ACTY_1 = new HtmlCommandButton();
		COMP_UI_M_BUT_ANAL_1 = new HtmlCommandButton();
		COMP_UI_M_BUT_ANAL_2 = new HtmlCommandButton();
		COMP_UI_M_BUT_DEPT = new HtmlCommandButton();
		COMP_UI_M_BUT_DIVN = new HtmlCommandButton();
		COMP_UI_M_BUT_SUB_ACNT = new HtmlCommandButton();
		COMP_UI_M_BUT_MAIN_ACNT = new HtmlCommandButton();
		COMP_UI_M_BUT_TYPE_TO = new HtmlCommandButton();
		COMP_UI_M_BUT_TYPE_FM = new HtmlCommandButton();
		COMP_UI_M_BUT_DOC_TYPE_FM_CODE = new HtmlCommandButton();
		COMP_UI_M_BUT_CACS_PROD_CODE_FM = new HtmlCommandButton();
		COMP_UI_M_BUT_CACS_COVER_CODE_FM = new HtmlCommandButton();
		COMP_UI_M_BUT_DOC_TYPE_TO_CODE = new HtmlCommandButton();
		COMP_UI_M_BUT_CACS_PROD_CODE_TO = new HtmlCommandButton();
		COMP_UI_M_BUT_CACS_COVER_CODE_TO = new HtmlCommandButton();
		COMP_UI_M_BUT_DEPT_TO = new HtmlCommandButton();
		COMP_UI_M_BUT_DEPT_FM = new HtmlCommandButton();
		COMP_UI_M_BUT_DIVN_TO = new HtmlCommandButton();
		COMP_UI_M_BUT_DIVN_FM = new HtmlCommandButton();

	}

	/**
	 * Resets all components in PM_IL_CODES_ACCOUNT_SETUP_ACTION
	 */
	public void resetAllComponent() {
		// Reseting HtmlInputText
		COMP_CACS_SRC_BUS_FM.resetValue();
		COMP_CACS_SRC_BUS_TO.resetValue();
		COMP_CACS_BUS_FM_CODE.resetValue();
		COMP_CACS_BUS_TO_CODE.resetValue();
		COMP_CACS_DIVN_FM_CODE.resetValue();
		COMP_CACS_DIVN_TO_CODE.resetValue();
		COMP_CACS_DEPT_FM_CODE.resetValue();
		COMP_CACS_DEPT_TO_CODE.resetValue();
		COMP_CACS_DOC_FM_TYPE.resetValue();
		COMP_CACS_DOC_TO_TYPE.resetValue();
		COMP_CACS_CUST_CLS_FM_CODE.resetValue();
		COMP_CACS_CUST_CLS_TO_CODE.resetValue();
		COMP_CACS_PROD_CODE_FM.resetValue();
		COMP_CACS_PROD_CODE_TO.resetValue();
		COMP_CACS_COVER_CODE_FM.resetValue();
		COMP_CACS_COVER_CODE_TO.resetValue();
		COMP_CACS_TYPE_FM_CODE.resetValue();
		COMP_CACS_TYPE_TO_CODE.resetValue();
		COMP_CACS_YRS_FM.resetValue();
		COMP_CACS_YRS_TO.resetValue();
		COMP_CACS_MAIN_ACNT_CODE.resetValue();
		COMP_UI_M_MAIN_ACNT_NAME.resetValue();
		COMP_CACS_SUB_ACNT_CODE.resetValue();
		COMP_UI_M_SUB_ACNT_NAME.resetValue();
		COMP_CACS_DIVN_CODE.resetValue();
		COMP_UI_M_DIVN_NAME.resetValue();
		COMP_CACS_DEPT_CODE.resetValue();
		COMP_UI_M_DEPT_NAME.resetValue();
		COMP_CACS_ANLY_CODE_1.resetValue();
		COMP_UI_M_ANLY_NAME.resetValue();
		COMP_CACS_ANLY_CODE_2.resetValue();
		COMP_UI_M_ANLY_NAME_1.resetValue();
		COMP_CACS_ACTY_CODE_1.resetValue();
		COMP_UI_M_ACTY_NAME.resetValue();
		COMP_CACS_ACTY_CODE_2.resetValue();
		COMP_UI_M_ACTY_NAME_1.resetValue();

		// Reseting HtmlSelectOneMenu
		COMP_CACS_SETUP_TYPE.resetValue();
		COMP_CACS_SETUP_FOR.resetValue();
		COMP_CACS_ASSURED_TYPE.resetValue();
		COMP_CACS_FIRST_PREM_YN.resetValue();
		COMP_CACS_FORCE_DIVN_YN.resetValue();
		COMP_CACS_FORCE_DEPT_YN.resetValue();

	}

	/**
	 * Disables all components in PM_IL_CODES_ACCOUNT_SETUP_ACTION
	 */
	public void disableAllComponent(boolean disabled) {
		// Disabling HtmlInputText
		COMP_CACS_SRC_BUS_FM.setDisabled(disabled);
		COMP_CACS_SRC_BUS_TO.setDisabled(disabled);
		COMP_CACS_BUS_FM_CODE.setDisabled(disabled);
		COMP_CACS_BUS_TO_CODE.setDisabled(disabled);
		COMP_CACS_DIVN_FM_CODE.setDisabled(disabled);
		COMP_CACS_DIVN_TO_CODE.setDisabled(disabled);
		COMP_CACS_DEPT_FM_CODE.setDisabled(disabled);
		COMP_CACS_DEPT_TO_CODE.setDisabled(disabled);
		COMP_CACS_DOC_FM_TYPE.setDisabled(disabled);
		COMP_CACS_DOC_TO_TYPE.setDisabled(disabled);
		COMP_CACS_CUST_CLS_FM_CODE.setDisabled(disabled);
		COMP_CACS_CUST_CLS_TO_CODE.setDisabled(disabled);
		COMP_CACS_PROD_CODE_FM.setDisabled(disabled);
		COMP_CACS_PROD_CODE_TO.setDisabled(disabled);
		COMP_CACS_COVER_CODE_FM.setDisabled(disabled);
		COMP_CACS_COVER_CODE_TO.setDisabled(disabled);
		COMP_CACS_TYPE_FM_CODE.setDisabled(disabled);
		COMP_CACS_TYPE_TO_CODE.setDisabled(disabled);
		COMP_CACS_YRS_FM.setDisabled(disabled);
		COMP_CACS_YRS_TO.setDisabled(disabled);
		COMP_CACS_MAIN_ACNT_CODE.setDisabled(disabled);
		COMP_UI_M_MAIN_ACNT_NAME.setDisabled(disabled);
		COMP_CACS_SUB_ACNT_CODE.setDisabled(disabled);
		COMP_UI_M_SUB_ACNT_NAME.setDisabled(disabled);
		COMP_CACS_DIVN_CODE.setDisabled(disabled);
		COMP_UI_M_DIVN_NAME.setDisabled(disabled);
		COMP_CACS_DEPT_CODE.setDisabled(disabled);
		COMP_UI_M_DEPT_NAME.setDisabled(disabled);
		COMP_CACS_ANLY_CODE_1.setDisabled(disabled);
		COMP_UI_M_ANLY_NAME.setDisabled(disabled);
		COMP_CACS_ANLY_CODE_2.setDisabled(disabled);
		COMP_UI_M_ANLY_NAME_1.setDisabled(disabled);
		COMP_CACS_ACTY_CODE_1.setDisabled(disabled);
		COMP_UI_M_ACTY_NAME.setDisabled(disabled);
		COMP_CACS_ACTY_CODE_2.setDisabled(disabled);
		COMP_UI_M_ACTY_NAME_1.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_CACS_SETUP_TYPE.setDisabled(disabled);
		COMP_CACS_SETUP_FOR.setDisabled(disabled);
		COMP_CACS_ASSURED_TYPE.setDisabled(disabled);
		COMP_CACS_FIRST_PREM_YN.setDisabled(disabled);
		COMP_CACS_FORCE_DIVN_YN.setDisabled(disabled);
		COMP_CACS_FORCE_DEPT_YN.setDisabled(disabled);

		// Disabling HtmlCommandButton
		COMP_UI_M_BUT_CUST_CLS_FM_LOV.setDisabled(disabled);
		COMP_UI_M_BUT_CUST_CLS_TO_LOV.setDisabled(disabled);
		COMP_UI_M_BUT_CACS_SRC_BUS_FM.setDisabled(disabled);
		COMP_UI_M_BUT_CACS_SRC_BUS_TO.setDisabled(disabled);
		COMP_UI_M_BUT_CACS_BUS_FM_CODE.setDisabled(disabled);
		COMP_UI_M_BUT_CACS_BUS_TO_CODE.setDisabled(disabled);
		COMP_UI_M_BUT_ACTY_2.setDisabled(disabled);
		COMP_UI_M_BUT_ACTY_1.setDisabled(disabled);
		COMP_UI_M_BUT_ANAL_1.setDisabled(disabled);
		COMP_UI_M_BUT_ANAL_2.setDisabled(disabled);
		COMP_UI_M_BUT_DEPT.setDisabled(disabled);
		COMP_UI_M_BUT_DIVN.setDisabled(disabled);
		COMP_UI_M_BUT_SUB_ACNT.setDisabled(disabled);
		COMP_UI_M_BUT_MAIN_ACNT.setDisabled(disabled);
		COMP_UI_M_BUT_TYPE_TO.setDisabled(disabled);
		COMP_UI_M_BUT_TYPE_FM.setDisabled(disabled);
		COMP_UI_M_BUT_DOC_TYPE_FM_CODE.setDisabled(disabled);
		COMP_UI_M_BUT_CACS_PROD_CODE_FM.setDisabled(disabled);
		COMP_UI_M_BUT_CACS_COVER_CODE_FM.setDisabled(disabled);
		COMP_UI_M_BUT_DOC_TYPE_TO_CODE.setDisabled(disabled);
		COMP_UI_M_BUT_CACS_PROD_CODE_TO.setDisabled(disabled);
		COMP_UI_M_BUT_CACS_COVER_CODE_TO.setDisabled(disabled);
		COMP_UI_M_BUT_DEPT_TO.setDisabled(disabled);
		COMP_UI_M_BUT_DEPT_FM.setDisabled(disabled);
		COMP_UI_M_BUT_DIVN_TO.setDisabled(disabled);
		COMP_UI_M_BUT_DIVN_FM.setDisabled(disabled);

	}

	public void onLoad(PhaseEvent event) {
		PM_IL_CODES_ACCOUNT_SETUP_LOCAL_PROCEDURES localProcedures=new PM_IL_CODES_ACCOUNT_SETUP_LOCAL_PROCEDURES();
		try {
			if (isBlockFlag()) {
				fetchAccountSetupDetails();
				localProcedures.L_SET_SUB_ACCOUNT(this);
				
			if (PM_IL_CODES_ACCOUNT_SETUP_BEAN.getROWID() != null) {
				postQuery(PM_IL_CODES_ACCOUNT_SETUP_BEAN);
			} else {
				helper.pilm023_pm_il_codes_account_setup_when_create_record(this);
			}
				helper.WHEN_NEW_RECORD_INSTANCE(this);
			setBlockFlag(false);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void fetchAccountSetupDetails() throws DBException {

		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;
		connection = CommonUtils.getConnection();
		try {
			String query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_NAVIGATE_TO_MAIN_QUERY;
			resultSet = handler.executeSelectStatement(query, connection,
					new Object[] { PM_IL_CODES_ACCOUNT_SETUP_BEAN.getROWID() });
			while (resultSet.next()) {
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_SETUP_TYPE(resultSet
						.getString("CACS_SETUP_TYPE"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_BUS_FM_CODE(resultSet
						.getString("CACS_BUS_FM_CODE"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_BUS_TO_CODE(resultSet
						.getString("CACS_BUS_TO_CODE"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DIVN_FM_CODE(resultSet
						.getString("CACS_DIVN_FM_CODE"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DIVN_TO_CODE(resultSet
						.getString("CACS_DIVN_TO_CODE"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DEPT_FM_CODE(resultSet
						.getString("CACS_DEPT_FM_CODE"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DEPT_TO_CODE(resultSet
						.getString("CACS_DEPT_TO_CODE"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DOC_FM_TYPE(resultSet
						.getString("CACS_DOC_FM_TYPE"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DOC_TO_TYPE(resultSet
						.getString("CACS_DOC_TO_TYPE"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_TYPE_FM_CODE(resultSet
						.getString("CACS_TYPE_FM_CODE"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_TYPE_TO_CODE(resultSet
						.getString("CACS_TYPE_TO_CODE"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_FORCE_DIVN_YN(resultSet
						.getString("CACS_FORCE_DIVN_YN"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_FORCE_DEPT_YN(resultSet
						.getString("CACS_FORCE_DEPT_YN"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_MAIN_ACNT_CODE(resultSet
						.getString("CACS_MAIN_ACNT_CODE"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_SUB_ACNT_CODE(resultSet
						.getString("CACS_SUB_ACNT_CODE"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DIVN_CODE(resultSet
						.getString("CACS_DIVN_CODE"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_DEPT_CODE(resultSet
						.getString("CACS_DEPT_CODE"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_ANLY_CODE_1(resultSet
						.getString("CACS_ANLY_CODE_1"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_ANLY_CODE_2(resultSet
						.getString("CACS_ANLY_CODE_2"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_ACTY_CODE_1(resultSet
						.getString("CACS_ACTY_CODE_1"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_ACTY_CODE_2(resultSet
						.getString("CACS_ACTY_CODE_2"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_FRZ_FLAG(resultSet
						.getString("CACS_FRZ_FLAG"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_SETUP_FOR(resultSet
						.getString("CACS_SETUP_FOR"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_ASSURED_TYPE(resultSet
						.getString("CACS_ASSURED_TYPE"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_SRC_BUS_FM(resultSet
						.getString("CACS_SRC_BUS_FM"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_SRC_BUS_TO(resultSet
						.getString("CACS_SRC_BUS_TO"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_PROD_CODE_FM(resultSet
						.getString("CACS_PROD_CODE_FM"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_PROD_CODE_TO(resultSet
						.getString("CACS_PROD_CODE_TO"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_COVER_CODE_FM(resultSet
						.getString("CACS_COVER_CODE_FM"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_COVER_CODE_TO(resultSet
						.getString("CACS_COVER_CODE_TO"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_FIRST_PREM_YN(resultSet
						.getString("CACS_FIRST_PREM_YN"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN
						.setCACS_CUST_CLS_FM_CODE(resultSet
								.getString("CACS_CUST_CLS_FM_CODE"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN
						.setCACS_CUST_CLS_TO_CODE(resultSet
								.getString("CACS_CUST_CLS_TO_CODE"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_YRS_FM(resultSet
						.getInt("CACS_YRS_FM"));
				PM_IL_CODES_ACCOUNT_SETUP_BEAN.setCACS_YRS_TO(resultSet
						.getInt("CACS_YRS_TO"));

				if (PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_FRZ_FLAG().equals(
						"Y")) {
					PM_IL_CODES_ACCOUNT_SETUP_BEAN.setFRZ_FLAG(true);
					System.out.println("frz falg is true");
				} else if (PM_IL_CODES_ACCOUNT_SETUP_BEAN.getCACS_FRZ_FLAG()
						.equals("N")) {
					PM_IL_CODES_ACCOUNT_SETUP_BEAN.setFRZ_FLAG(false);
					System.out.println("frz falg is false");
				}
				postQuery(PM_IL_CODES_ACCOUNT_SETUP_BEAN);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// method to validate lov code by 55943 13-feb-2012.
	public static Boolean isValidateLovCode(String qry, Object[] values) {
		Boolean exists = false;
		Connection conn = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			conn = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(qry, conn, values);
			System.out.println(resultSet);
			if (resultSet.next()) {
				exists = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return exists;

	}

	public HtmlGraphicImage getCOMP_CACS_SUB_ACNT_CODE_IMG() {
		return COMP_CACS_SUB_ACNT_CODE_IMG;
	}

	public void setCOMP_CACS_SUB_ACNT_CODE_IMG(
			HtmlGraphicImage comp_cacs_sub_acnt_code_img) {
		COMP_CACS_SUB_ACNT_CODE_IMG = comp_cacs_sub_acnt_code_img;
	}
	
	public List<LovBean> lovCACS_ACTY_CODE_1(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			 
			suggestionList = listitemutil.P_CALL_LOV("PILM023",
					"PM_IL_CODES_ACCOUNT_SETUP", "CACS_ACTY_CODE_1",
					 PM_IL_CODES_ACCOUNT_SETUP_BEAN.getUI_M_ACTY_HEAD_1(), null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovCACS_ACTY_CODE_2(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			
			suggestionList = listitemutil.P_CALL_LOV("PILM023",
					"PM_IL_CODES_ACCOUNT_SETUP", "CACS_ACTY_CODE_2",
					 PM_IL_CODES_ACCOUNT_SETUP_BEAN.getUI_M_ACTY_HEAD_2(), null,
										null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

}
