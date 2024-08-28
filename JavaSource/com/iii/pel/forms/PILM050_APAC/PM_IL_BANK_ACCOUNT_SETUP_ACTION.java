package com.iii.pel.forms.PILM050_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_BANK_ACCOUNT_SETUP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_BAS_DIVN_FM_CODE_LABEL;

	private HtmlInputText COMP_BAS_DIVN_FM_CODE;

	private HtmlOutputLabel COMP_BAS_DIVN_TO_CODE_LABEL;

	private HtmlInputText COMP_BAS_DIVN_TO_CODE;

	private HtmlOutputLabel COMP_BAS_DEPT_FM_CODE_LABEL;

	private HtmlInputText COMP_BAS_DEPT_FM_CODE;

	private HtmlOutputLabel COMP_BAS_DEPT_TO_CODE_LABEL;

	private HtmlInputText COMP_BAS_DEPT_TO_CODE;

	private HtmlOutputLabel COMP_BAS_SETUP_FOR_LABEL;

	private HtmlSelectOneMenu COMP_BAS_SETUP_FOR;

	private HtmlOutputLabel COMP_BAS_ASSURED_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_BAS_ASSURED_TYPE;

	private HtmlOutputLabel COMP_BAS_MAX_PAYEE_CHAR_LABEL;

	private HtmlInputText COMP_BAS_MAX_PAYEE_CHAR;

	private HtmlOutputLabel COMP_BAS_CUST_BANK_CODE_LABEL;

	private HtmlInputText COMP_BAS_CUST_BANK_CODE;

	private HtmlOutputLabel COMP_BAS_OUR_BANK_CODE_LABEL;

	private HtmlInputText COMP_BAS_OUR_BANK_CODE;

	private HtmlOutputLabel COMP_BAS_MAIN_ACNT_CODE_LABEL;

	private HtmlInputText COMP_BAS_MAIN_ACNT_CODE;

	private HtmlOutputLabel COMP_BAS_SUB_ACNT_CODE_LABEL;

	private HtmlInputText COMP_BAS_SUB_ACNT_CODE;

	private HtmlOutputLabel COMP_BAS_VALUE_FROM_LABEL;

	private HtmlInputText COMP_BAS_VALUE_FROM;

	private HtmlOutputLabel COMP_BAS_DIVN_CODE_LABEL;

	private HtmlInputText COMP_BAS_DIVN_CODE;

	private HtmlOutputLabel COMP_BAS_DEPT_CODE_LABEL;

	private HtmlInputText COMP_BAS_DEPT_CODE;

	private HtmlOutputLabel COMP_BAS_ANLY_CODE_1_LABEL;

	private HtmlInputText COMP_BAS_ANLY_CODE_1;

	private HtmlOutputLabel COMP_BAS_ANLY_CODE_2_LABEL;

	private HtmlInputText COMP_BAS_ANLY_CODE_2;

	private HtmlOutputLabel COMP_BAS_ACTY_CODE_1_LABEL;

	private HtmlInputText COMP_BAS_ACTY_CODE_1;

	private HtmlOutputLabel COMP_BAS_ACTY_CODE_2_LABEL;

	private HtmlInputText COMP_BAS_ACTY_CODE_2;

	private HtmlOutputLabel COMP_UI_M_DEPT_FM_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DEPT_FM_DESC;

	private HtmlOutputLabel COMP_UI_M_DEPT_TO_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DEPT_TO_DESC;

	private HtmlOutputLabel COMP_UI_M_CUST_BANK_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CUST_BANK_DESC;

	private HtmlOutputLabel COMP_UI_M_OUR_BANK_DESC_LABEL;

	private HtmlInputText COMP_UI_M_OUR_BANK_DESC;

	private HtmlOutputLabel COMP_UI_M_MAIN_ACNT_DESC_LABEL;

	private HtmlInputText COMP_UI_M_MAIN_ACNT_DESC;

	private HtmlOutputLabel COMP_UI_M_SUB_ACNT_DESC_LABEL;

	private HtmlInputText COMP_UI_M_SUB_ACNT_DESC;

	private HtmlOutputLabel COMP_UI_M_DIVN_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DIVN_DESC;

	private HtmlOutputLabel COMP_UI_M_DEPT_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DEPT_DESC;

	private HtmlOutputLabel COMP_UI_M_ANLY_1_DESC_LABEL;

	private HtmlInputText COMP_UI_M_ANLY_1_DESC;

	private HtmlOutputLabel COMP_UI_M_ANLY_2_DESC_LABEL;

	private HtmlInputText COMP_UI_M_ANLY_2_DESC;

	private HtmlOutputLabel COMP_UI_M_ACTY_1_DESC_LABEL;

	private HtmlInputText COMP_UI_M_ACTY_1_DESC;

	private HtmlOutputLabel COMP_UI_M_ACTY_2_DESC_LABEL;

	private HtmlInputText COMP_UI_M_ACTY_2_DESC;

	private HtmlOutputLabel COMP_BAS_VALUE_TO_LABEL;

	private HtmlInputText COMP_BAS_VALUE_TO;

	private HtmlOutputLabel COMP_BAS_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_BAS_FRZ_FLAG;

	private PM_IL_BANK_ACCOUNT_SETUP PM_IL_BANK_ACCOUNT_SETUP_BEAN;

	private HtmlCommandButton testButton;

	private HtmlCommandButton homeButton;

	private HtmlOutputLabel COMP_BAS_TXN_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_BAS_TXN_TYPE;

	private List<SelectItem> BAS_SETUP_FOR_LIST = new ArrayList<SelectItem>();

	private List<SelectItem> BAS_ASSURED_TYPE_LIST = new ArrayList<SelectItem>();

	private List<SelectItem> BAS_TXN_TYPE_LIST = new ArrayList<SelectItem>();

	private List Divisionlist;

	private List DepartmentList;
	
	private PM_IL_BANK_ACCOUNT_SETUP_HELPER helper;
	
	private ResultSet rs = null;

	ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
	ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
	
	ArrayList<LovBean> listLov = new ArrayList<LovBean>();



	public PM_IL_BANK_ACCOUNT_SETUP_ACTION() {
		PM_IL_BANK_ACCOUNT_SETUP_BEAN = new PM_IL_BANK_ACCOUNT_SETUP();
        helper=new PM_IL_BANK_ACCOUNT_SETUP_HELPER();
        COMP_BAS_FRZ_FLAG=new HtmlSelectBooleanCheckbox();
		Connection con = null;
		try {
			con = CommonUtils.getConnection();

		BAS_SETUP_FOR_LIST = ListItemUtil.
							getDropDownListValue(con,"PILM050_APAC", "PM_IL_BANK_ACCOUNT_SETUP",
												 "PM_IL_BANK_ACCOUNT_SETUP.BAS_SETUP_FOR", "IL_PAY_MODE");
		BAS_ASSURED_TYPE_LIST = ListItemUtil.
								getDropDownListValue(con,"PILM050_APAC", "PM_IL_BANK_ACCOUNT_SETUP",
													"PM_IL_BANK_ACCOUNT_SETUP.BAS_ASSURED_TYPE", "IL_ASSR_TYP");
		BAS_TXN_TYPE_LIST.add(new SelectItem("", "--Select--"));
		BAS_TXN_TYPE_LIST.add(new SelectItem(Messages.getString("messageProperties_PILM050_APAC",
											 "PILM050_APAC$PM_IL_BANK_ACCOUNT_SETUP$BANK_VALUE$caption"),
											 Messages.getString("messageProperties_PILM050_APAC",
										     "PILM050_APAC$PM_IL_BANK_ACCOUNT_SETUP$BANK_LABLE$caption")));
		BAS_TXN_TYPE_LIST.add(new SelectItem(Messages.getString("messageProperties_PILM050_APAC",
											 "PILM050_APAC$PM_IL_BANK_ACCOUNT_SETUP$PAYMENT_VALUE$caption"),
											 Messages.getString("messageProperties_PILM050_APAC",
											 "PILM050_APAC$PM_IL_BANK_ACCOUNT_SETUP$PAYMENT_LABLE$caption")));
		
		instantiateAllComponent();
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

	public List<SelectItem> getBAS_TXN_TYPE_LIST() {
		return BAS_TXN_TYPE_LIST;
	}

	public void setBAS_TXN_TYPE_LIST(List<SelectItem> bas_txn_type_list) {
		BAS_TXN_TYPE_LIST = bas_txn_type_list;
	}

	public HtmlOutputLabel getCOMP_BAS_DIVN_FM_CODE_LABEL() {
		return COMP_BAS_DIVN_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BAS_DIVN_FM_CODE() {
		return COMP_BAS_DIVN_FM_CODE;
	}

	public void setCOMP_BAS_DIVN_FM_CODE_LABEL(
			HtmlOutputLabel COMP_BAS_DIVN_FM_CODE_LABEL) {
		this.COMP_BAS_DIVN_FM_CODE_LABEL = COMP_BAS_DIVN_FM_CODE_LABEL;
	}

	public void setCOMP_BAS_DIVN_FM_CODE(HtmlInputText COMP_BAS_DIVN_FM_CODE) {
		this.COMP_BAS_DIVN_FM_CODE = COMP_BAS_DIVN_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_BAS_DIVN_TO_CODE_LABEL() {
		return COMP_BAS_DIVN_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BAS_DIVN_TO_CODE() {
		return COMP_BAS_DIVN_TO_CODE;
	}

	public void setCOMP_BAS_DIVN_TO_CODE_LABEL(
			HtmlOutputLabel COMP_BAS_DIVN_TO_CODE_LABEL) {
		this.COMP_BAS_DIVN_TO_CODE_LABEL = COMP_BAS_DIVN_TO_CODE_LABEL;
	}

	public void setCOMP_BAS_DIVN_TO_CODE(HtmlInputText COMP_BAS_DIVN_TO_CODE) {
		this.COMP_BAS_DIVN_TO_CODE = COMP_BAS_DIVN_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_BAS_DEPT_FM_CODE_LABEL() {
		return COMP_BAS_DEPT_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BAS_DEPT_FM_CODE() {
		return COMP_BAS_DEPT_FM_CODE;
	}

	public void setCOMP_BAS_DEPT_FM_CODE_LABEL(
			HtmlOutputLabel COMP_BAS_DEPT_FM_CODE_LABEL) {
		this.COMP_BAS_DEPT_FM_CODE_LABEL = COMP_BAS_DEPT_FM_CODE_LABEL;
	}

	public void setCOMP_BAS_DEPT_FM_CODE(HtmlInputText COMP_BAS_DEPT_FM_CODE) {
		this.COMP_BAS_DEPT_FM_CODE = COMP_BAS_DEPT_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_BAS_DEPT_TO_CODE_LABEL() {
		return COMP_BAS_DEPT_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BAS_DEPT_TO_CODE() {
		return COMP_BAS_DEPT_TO_CODE;
	}

	public void setCOMP_BAS_DEPT_TO_CODE_LABEL(
			HtmlOutputLabel COMP_BAS_DEPT_TO_CODE_LABEL) {
		this.COMP_BAS_DEPT_TO_CODE_LABEL = COMP_BAS_DEPT_TO_CODE_LABEL;
	}

	public void setCOMP_BAS_DEPT_TO_CODE(HtmlInputText COMP_BAS_DEPT_TO_CODE) {
		this.COMP_BAS_DEPT_TO_CODE = COMP_BAS_DEPT_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_BAS_SETUP_FOR_LABEL() {
		return COMP_BAS_SETUP_FOR_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_BAS_SETUP_FOR() {
		return COMP_BAS_SETUP_FOR;
	}

	public void setCOMP_BAS_SETUP_FOR_LABEL(
			HtmlOutputLabel COMP_BAS_SETUP_FOR_LABEL) {
		this.COMP_BAS_SETUP_FOR_LABEL = COMP_BAS_SETUP_FOR_LABEL;
	}

	public void setCOMP_BAS_SETUP_FOR(HtmlSelectOneMenu COMP_BAS_SETUP_FOR) {
		this.COMP_BAS_SETUP_FOR = COMP_BAS_SETUP_FOR;
	}

	public HtmlOutputLabel getCOMP_BAS_ASSURED_TYPE_LABEL() {
		return COMP_BAS_ASSURED_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_BAS_ASSURED_TYPE() {
		return COMP_BAS_ASSURED_TYPE;
	}

	public void setCOMP_BAS_ASSURED_TYPE_LABEL(
			HtmlOutputLabel COMP_BAS_ASSURED_TYPE_LABEL) {
		this.COMP_BAS_ASSURED_TYPE_LABEL = COMP_BAS_ASSURED_TYPE_LABEL;
	}

	public void setCOMP_BAS_ASSURED_TYPE(HtmlSelectOneMenu COMP_BAS_ASSURED_TYPE) {
		this.COMP_BAS_ASSURED_TYPE = COMP_BAS_ASSURED_TYPE;
	}

	public HtmlOutputLabel getCOMP_BAS_MAX_PAYEE_CHAR_LABEL() {
		return COMP_BAS_MAX_PAYEE_CHAR_LABEL;
	}

	public HtmlInputText getCOMP_BAS_MAX_PAYEE_CHAR() {
		return COMP_BAS_MAX_PAYEE_CHAR;
	}

	public void setCOMP_BAS_MAX_PAYEE_CHAR_LABEL(
			HtmlOutputLabel COMP_BAS_MAX_PAYEE_CHAR_LABEL) {
		this.COMP_BAS_MAX_PAYEE_CHAR_LABEL = COMP_BAS_MAX_PAYEE_CHAR_LABEL;
	}

	public void setCOMP_BAS_MAX_PAYEE_CHAR(HtmlInputText COMP_BAS_MAX_PAYEE_CHAR) {
		this.COMP_BAS_MAX_PAYEE_CHAR = COMP_BAS_MAX_PAYEE_CHAR;
	}

	public HtmlOutputLabel getCOMP_BAS_CUST_BANK_CODE_LABEL() {
		return COMP_BAS_CUST_BANK_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BAS_CUST_BANK_CODE() {
		return COMP_BAS_CUST_BANK_CODE;
	}

	public void setCOMP_BAS_CUST_BANK_CODE_LABEL(
			HtmlOutputLabel COMP_BAS_CUST_BANK_CODE_LABEL) {
		this.COMP_BAS_CUST_BANK_CODE_LABEL = COMP_BAS_CUST_BANK_CODE_LABEL;
	}

	public void setCOMP_BAS_CUST_BANK_CODE(HtmlInputText COMP_BAS_CUST_BANK_CODE) {
		this.COMP_BAS_CUST_BANK_CODE = COMP_BAS_CUST_BANK_CODE;
	}

	public HtmlOutputLabel getCOMP_BAS_OUR_BANK_CODE_LABEL() {
		return COMP_BAS_OUR_BANK_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BAS_OUR_BANK_CODE() {
		return COMP_BAS_OUR_BANK_CODE;
	}

	public void setCOMP_BAS_OUR_BANK_CODE_LABEL(
			HtmlOutputLabel COMP_BAS_OUR_BANK_CODE_LABEL) {
		this.COMP_BAS_OUR_BANK_CODE_LABEL = COMP_BAS_OUR_BANK_CODE_LABEL;
	}

	public void setCOMP_BAS_OUR_BANK_CODE(HtmlInputText COMP_BAS_OUR_BANK_CODE) {
		this.COMP_BAS_OUR_BANK_CODE = COMP_BAS_OUR_BANK_CODE;
	}

	public HtmlOutputLabel getCOMP_BAS_MAIN_ACNT_CODE_LABEL() {
		return COMP_BAS_MAIN_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BAS_MAIN_ACNT_CODE() {
		return COMP_BAS_MAIN_ACNT_CODE;
	}

	public void setCOMP_BAS_MAIN_ACNT_CODE_LABEL(
			HtmlOutputLabel COMP_BAS_MAIN_ACNT_CODE_LABEL) {
		this.COMP_BAS_MAIN_ACNT_CODE_LABEL = COMP_BAS_MAIN_ACNT_CODE_LABEL;
	}

	public void setCOMP_BAS_MAIN_ACNT_CODE(HtmlInputText COMP_BAS_MAIN_ACNT_CODE) {
		this.COMP_BAS_MAIN_ACNT_CODE = COMP_BAS_MAIN_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_BAS_SUB_ACNT_CODE_LABEL() {
		return COMP_BAS_SUB_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BAS_SUB_ACNT_CODE() {
		return COMP_BAS_SUB_ACNT_CODE;
	}

	public void setCOMP_BAS_SUB_ACNT_CODE_LABEL(
			HtmlOutputLabel COMP_BAS_SUB_ACNT_CODE_LABEL) {
		this.COMP_BAS_SUB_ACNT_CODE_LABEL = COMP_BAS_SUB_ACNT_CODE_LABEL;
	}

	public void setCOMP_BAS_SUB_ACNT_CODE(HtmlInputText COMP_BAS_SUB_ACNT_CODE) {
		this.COMP_BAS_SUB_ACNT_CODE = COMP_BAS_SUB_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_BAS_VALUE_FROM_LABEL() {
		return COMP_BAS_VALUE_FROM_LABEL;
	}

	public HtmlInputText getCOMP_BAS_VALUE_FROM() {
		return COMP_BAS_VALUE_FROM;
	}

	public void setCOMP_BAS_VALUE_FROM_LABEL(
			HtmlOutputLabel COMP_BAS_VALUE_FROM_LABEL) {
		this.COMP_BAS_VALUE_FROM_LABEL = COMP_BAS_VALUE_FROM_LABEL;
	}

	public void setCOMP_BAS_VALUE_FROM(HtmlInputText COMP_BAS_VALUE_FROM) {
		this.COMP_BAS_VALUE_FROM = COMP_BAS_VALUE_FROM;
	}

	public HtmlOutputLabel getCOMP_BAS_DIVN_CODE_LABEL() {
		return COMP_BAS_DIVN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BAS_DIVN_CODE() {
		return COMP_BAS_DIVN_CODE;
	}

	public void setCOMP_BAS_DIVN_CODE_LABEL(
			HtmlOutputLabel COMP_BAS_DIVN_CODE_LABEL) {
		this.COMP_BAS_DIVN_CODE_LABEL = COMP_BAS_DIVN_CODE_LABEL;
	}

	public void setCOMP_BAS_DIVN_CODE(HtmlInputText COMP_BAS_DIVN_CODE) {
		this.COMP_BAS_DIVN_CODE = COMP_BAS_DIVN_CODE;
	}

	public HtmlOutputLabel getCOMP_BAS_DEPT_CODE_LABEL() {
		return COMP_BAS_DEPT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BAS_DEPT_CODE() {
		return COMP_BAS_DEPT_CODE;
	}

	public void setCOMP_BAS_DEPT_CODE_LABEL(
			HtmlOutputLabel COMP_BAS_DEPT_CODE_LABEL) {
		this.COMP_BAS_DEPT_CODE_LABEL = COMP_BAS_DEPT_CODE_LABEL;
	}

	public void setCOMP_BAS_DEPT_CODE(HtmlInputText COMP_BAS_DEPT_CODE) {
		this.COMP_BAS_DEPT_CODE = COMP_BAS_DEPT_CODE;
	}

	public HtmlOutputLabel getCOMP_BAS_ANLY_CODE_1_LABEL() {
		return COMP_BAS_ANLY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_BAS_ANLY_CODE_1() {
		return COMP_BAS_ANLY_CODE_1;
	}

	public void setCOMP_BAS_ANLY_CODE_1_LABEL(
			HtmlOutputLabel COMP_BAS_ANLY_CODE_1_LABEL) {
		this.COMP_BAS_ANLY_CODE_1_LABEL = COMP_BAS_ANLY_CODE_1_LABEL;
	}

	public void setCOMP_BAS_ANLY_CODE_1(HtmlInputText COMP_BAS_ANLY_CODE_1) {
		this.COMP_BAS_ANLY_CODE_1 = COMP_BAS_ANLY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_BAS_ANLY_CODE_2_LABEL() {
		return COMP_BAS_ANLY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_BAS_ANLY_CODE_2() {
		return COMP_BAS_ANLY_CODE_2;
	}

	public void setCOMP_BAS_ANLY_CODE_2_LABEL(
			HtmlOutputLabel COMP_BAS_ANLY_CODE_2_LABEL) {
		this.COMP_BAS_ANLY_CODE_2_LABEL = COMP_BAS_ANLY_CODE_2_LABEL;
	}

	public void setCOMP_BAS_ANLY_CODE_2(HtmlInputText COMP_BAS_ANLY_CODE_2) {
		this.COMP_BAS_ANLY_CODE_2 = COMP_BAS_ANLY_CODE_2;
	}

	public HtmlOutputLabel getCOMP_BAS_ACTY_CODE_1_LABEL() {
		return COMP_BAS_ACTY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_BAS_ACTY_CODE_1() {
		return COMP_BAS_ACTY_CODE_1;
	}

	public void setCOMP_BAS_ACTY_CODE_1_LABEL(
			HtmlOutputLabel COMP_BAS_ACTY_CODE_1_LABEL) {
		this.COMP_BAS_ACTY_CODE_1_LABEL = COMP_BAS_ACTY_CODE_1_LABEL;
	}

	public void setCOMP_BAS_ACTY_CODE_1(HtmlInputText COMP_BAS_ACTY_CODE_1) {
		this.COMP_BAS_ACTY_CODE_1 = COMP_BAS_ACTY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_BAS_ACTY_CODE_2_LABEL() {
		return COMP_BAS_ACTY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_BAS_ACTY_CODE_2() {
		return COMP_BAS_ACTY_CODE_2;
	}

	public void setCOMP_BAS_ACTY_CODE_2_LABEL(
			HtmlOutputLabel COMP_BAS_ACTY_CODE_2_LABEL) {
		this.COMP_BAS_ACTY_CODE_2_LABEL = COMP_BAS_ACTY_CODE_2_LABEL;
	}

	public void setCOMP_BAS_ACTY_CODE_2(HtmlInputText COMP_BAS_ACTY_CODE_2) {
		this.COMP_BAS_ACTY_CODE_2 = COMP_BAS_ACTY_CODE_2;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEPT_FM_DESC_LABEL() {
		return COMP_UI_M_DEPT_FM_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEPT_FM_DESC() {
		return COMP_UI_M_DEPT_FM_DESC;
	}

	public void setCOMP_UI_M_DEPT_FM_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DEPT_FM_DESC_LABEL) {
		this.COMP_UI_M_DEPT_FM_DESC_LABEL = COMP_UI_M_DEPT_FM_DESC_LABEL;
	}

	public void setCOMP_UI_M_DEPT_FM_DESC(HtmlInputText COMP_UI_M_DEPT_FM_DESC) {
		this.COMP_UI_M_DEPT_FM_DESC = COMP_UI_M_DEPT_FM_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEPT_TO_DESC_LABEL() {
		return COMP_UI_M_DEPT_TO_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEPT_TO_DESC() {
		return COMP_UI_M_DEPT_TO_DESC;
	}

	public void setCOMP_UI_M_DEPT_TO_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DEPT_TO_DESC_LABEL) {
		this.COMP_UI_M_DEPT_TO_DESC_LABEL = COMP_UI_M_DEPT_TO_DESC_LABEL;
	}

	public void setCOMP_UI_M_DEPT_TO_DESC(HtmlInputText COMP_UI_M_DEPT_TO_DESC) {
		this.COMP_UI_M_DEPT_TO_DESC = COMP_UI_M_DEPT_TO_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_CUST_BANK_DESC_LABEL() {
		return COMP_UI_M_CUST_BANK_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CUST_BANK_DESC() {
		return COMP_UI_M_CUST_BANK_DESC;
	}

	public void setCOMP_UI_M_CUST_BANK_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_CUST_BANK_DESC_LABEL) {
		this.COMP_UI_M_CUST_BANK_DESC_LABEL = COMP_UI_M_CUST_BANK_DESC_LABEL;
	}

	public void setCOMP_UI_M_CUST_BANK_DESC(
			HtmlInputText COMP_UI_M_CUST_BANK_DESC) {
		this.COMP_UI_M_CUST_BANK_DESC = COMP_UI_M_CUST_BANK_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_OUR_BANK_DESC_LABEL() {
		return COMP_UI_M_OUR_BANK_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_OUR_BANK_DESC() {
		return COMP_UI_M_OUR_BANK_DESC;
	}

	public void setCOMP_UI_M_OUR_BANK_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_OUR_BANK_DESC_LABEL) {
		this.COMP_UI_M_OUR_BANK_DESC_LABEL = COMP_UI_M_OUR_BANK_DESC_LABEL;
	}

	public void setCOMP_UI_M_OUR_BANK_DESC(HtmlInputText COMP_UI_M_OUR_BANK_DESC) {
		this.COMP_UI_M_OUR_BANK_DESC = COMP_UI_M_OUR_BANK_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_MAIN_ACNT_DESC_LABEL() {
		return COMP_UI_M_MAIN_ACNT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_MAIN_ACNT_DESC() {
		return COMP_UI_M_MAIN_ACNT_DESC;
	}

	public void setCOMP_UI_M_MAIN_ACNT_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_MAIN_ACNT_DESC_LABEL) {
		this.COMP_UI_M_MAIN_ACNT_DESC_LABEL = COMP_UI_M_MAIN_ACNT_DESC_LABEL;
	}

	public void setCOMP_UI_M_MAIN_ACNT_DESC(
			HtmlInputText COMP_UI_M_MAIN_ACNT_DESC) {
		this.COMP_UI_M_MAIN_ACNT_DESC = COMP_UI_M_MAIN_ACNT_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_SUB_ACNT_DESC_LABEL() {
		return COMP_UI_M_SUB_ACNT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_SUB_ACNT_DESC() {
		return COMP_UI_M_SUB_ACNT_DESC;
	}

	public void setCOMP_UI_M_SUB_ACNT_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_SUB_ACNT_DESC_LABEL) {
		this.COMP_UI_M_SUB_ACNT_DESC_LABEL = COMP_UI_M_SUB_ACNT_DESC_LABEL;
	}

	public void setCOMP_UI_M_SUB_ACNT_DESC(HtmlInputText COMP_UI_M_SUB_ACNT_DESC) {
		this.COMP_UI_M_SUB_ACNT_DESC = COMP_UI_M_SUB_ACNT_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_DIVN_DESC_LABEL() {
		return COMP_UI_M_DIVN_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DIVN_DESC() {
		return COMP_UI_M_DIVN_DESC;
	}

	public void setCOMP_UI_M_DIVN_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DIVN_DESC_LABEL) {
		this.COMP_UI_M_DIVN_DESC_LABEL = COMP_UI_M_DIVN_DESC_LABEL;
	}

	public void setCOMP_UI_M_DIVN_DESC(HtmlInputText COMP_UI_M_DIVN_DESC) {
		this.COMP_UI_M_DIVN_DESC = COMP_UI_M_DIVN_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEPT_DESC_LABEL() {
		return COMP_UI_M_DEPT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEPT_DESC() {
		return COMP_UI_M_DEPT_DESC;
	}

	public void setCOMP_UI_M_DEPT_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DEPT_DESC_LABEL) {
		this.COMP_UI_M_DEPT_DESC_LABEL = COMP_UI_M_DEPT_DESC_LABEL;
	}

	public void setCOMP_UI_M_DEPT_DESC(HtmlInputText COMP_UI_M_DEPT_DESC) {
		this.COMP_UI_M_DEPT_DESC = COMP_UI_M_DEPT_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_ANLY_1_DESC_LABEL() {
		return COMP_UI_M_ANLY_1_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ANLY_1_DESC() {
		return COMP_UI_M_ANLY_1_DESC;
	}

	public void setCOMP_UI_M_ANLY_1_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_ANLY_1_DESC_LABEL) {
		this.COMP_UI_M_ANLY_1_DESC_LABEL = COMP_UI_M_ANLY_1_DESC_LABEL;
	}

	public void setCOMP_UI_M_ANLY_1_DESC(HtmlInputText COMP_UI_M_ANLY_1_DESC) {
		this.COMP_UI_M_ANLY_1_DESC = COMP_UI_M_ANLY_1_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_ANLY_2_DESC_LABEL() {
		return COMP_UI_M_ANLY_2_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ANLY_2_DESC() {
		return COMP_UI_M_ANLY_2_DESC;
	}

	public void setCOMP_UI_M_ANLY_2_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_ANLY_2_DESC_LABEL) {
		this.COMP_UI_M_ANLY_2_DESC_LABEL = COMP_UI_M_ANLY_2_DESC_LABEL;
	}

	public void setCOMP_UI_M_ANLY_2_DESC(HtmlInputText COMP_UI_M_ANLY_2_DESC) {
		this.COMP_UI_M_ANLY_2_DESC = COMP_UI_M_ANLY_2_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACTY_1_DESC_LABEL() {
		return COMP_UI_M_ACTY_1_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACTY_1_DESC() {
		return COMP_UI_M_ACTY_1_DESC;
	}

	public void setCOMP_UI_M_ACTY_1_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_ACTY_1_DESC_LABEL) {
		this.COMP_UI_M_ACTY_1_DESC_LABEL = COMP_UI_M_ACTY_1_DESC_LABEL;
	}

	public void setCOMP_UI_M_ACTY_1_DESC(HtmlInputText COMP_UI_M_ACTY_1_DESC) {
		this.COMP_UI_M_ACTY_1_DESC = COMP_UI_M_ACTY_1_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACTY_2_DESC_LABEL() {
		return COMP_UI_M_ACTY_2_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACTY_2_DESC() {
		return COMP_UI_M_ACTY_2_DESC;
	}

	public void setCOMP_UI_M_ACTY_2_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_ACTY_2_DESC_LABEL) {
		this.COMP_UI_M_ACTY_2_DESC_LABEL = COMP_UI_M_ACTY_2_DESC_LABEL;
	}

	public void setCOMP_UI_M_ACTY_2_DESC(HtmlInputText COMP_UI_M_ACTY_2_DESC) {
		this.COMP_UI_M_ACTY_2_DESC = COMP_UI_M_ACTY_2_DESC;
	}

	public HtmlOutputLabel getCOMP_BAS_VALUE_TO_LABEL() {
		return COMP_BAS_VALUE_TO_LABEL;
	}

	public HtmlInputText getCOMP_BAS_VALUE_TO() {
		return COMP_BAS_VALUE_TO;
	}

	public void setCOMP_BAS_VALUE_TO_LABEL(
			HtmlOutputLabel COMP_BAS_VALUE_TO_LABEL) {
		this.COMP_BAS_VALUE_TO_LABEL = COMP_BAS_VALUE_TO_LABEL;
	}

	public void setCOMP_BAS_VALUE_TO(HtmlInputText COMP_BAS_VALUE_TO) {
		this.COMP_BAS_VALUE_TO = COMP_BAS_VALUE_TO;
	}

	public HtmlOutputLabel getCOMP_BAS_FRZ_FLAG_LABEL() {
		return COMP_BAS_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_BAS_FRZ_FLAG() {
		return COMP_BAS_FRZ_FLAG;
	}

	public void setCOMP_BAS_FRZ_FLAG_LABEL(
			HtmlOutputLabel COMP_BAS_FRZ_FLAG_LABEL) {
		this.COMP_BAS_FRZ_FLAG_LABEL = COMP_BAS_FRZ_FLAG_LABEL;
	}

	public void setCOMP_BAS_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_BAS_FRZ_FLAG) {
		this.COMP_BAS_FRZ_FLAG = COMP_BAS_FRZ_FLAG;
	}

	public PM_IL_BANK_ACCOUNT_SETUP getPM_IL_BANK_ACCOUNT_SETUP_BEAN() {
		return PM_IL_BANK_ACCOUNT_SETUP_BEAN;
	}

	public void setPM_IL_BANK_ACCOUNT_SETUP_BEAN(
			PM_IL_BANK_ACCOUNT_SETUP PM_IL_BANK_ACCOUNT_SETUP_BEAN) {
		this.PM_IL_BANK_ACCOUNT_SETUP_BEAN = PM_IL_BANK_ACCOUNT_SETUP_BEAN;
	}

	public void VALIDATE_BAS_DIVN_FM_CODE(ActionEvent ae) {
		if (("".equals(getCOMP_BAS_DIVN_FM_CODE().getSubmittedValue()
				.toString().trim()))
				|| getCOMP_BAS_DIVN_FM_CODE().getSubmittedValue().equals(null)) {
			getCOMP_BAS_DIVN_FM_CODE().setSubmittedValue("0");
			PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_DIVN_FM_CODE("0");
			getCOMP_BAS_DIVN_FM_CODE().updateModel(
					FacesContext.getCurrentInstance());
		} else {
			if (getCOMP_BAS_DIVN_FM_CODE().getSubmittedValue() != null) {
				getCOMP_BAS_DIVN_FM_CODE().setSubmittedValue(
						getCOMP_BAS_DIVN_FM_CODE().getSubmittedValue());
				PM_IL_BANK_ACCOUNT_SETUP_BEAN
						.setBAS_DIVN_FM_CODE(getCOMP_BAS_DIVN_FM_CODE()
								.getSubmittedValue().toString());
			}
		}
	}

	public void SET_REP_FIRST_FIELD(HtmlInputText M_FIELD_NAME,
			HtmlInputText M_FIELD_NAME2) {
		if ("".equals(M_FIELD_NAME.getSubmittedValue().toString())) {
		}
	}


	public void BAS_DIVN_FM_CODE_WHEN_NEW_RECORD_INSTANCE() {}

	public void VALIDATE_BAS_DIVN_TO_CODE(ActionEvent ae) {

		if (("".equals(getCOMP_BAS_DIVN_TO_CODE().getSubmittedValue()
				.toString().trim()))
				|| getCOMP_BAS_DIVN_TO_CODE().getSubmittedValue().equals(null)) {
			getCOMP_BAS_DIVN_TO_CODE().setSubmittedValue("zzzzzz");
		} else {
			String BAS_DIVN_TO_CODE = (String) getCOMP_BAS_DIVN_TO_CODE().getSubmittedValue();

			String BAS_DIVN_FM_CODE = (String )getCOMP_BAS_DIVN_FM_CODE().getSubmittedValue();


			int Comp_Value = BAS_DIVN_TO_CODE.compareTo(BAS_DIVN_FM_CODE);
			
			if (Comp_Value < 0) {
				getErrorMap().put("current",Messages.getString(PELConstants.pelErrorMessagePath,"71043"));
			}
		}
	}
			
			

	public String FORM_PRE_FORM() throws Exception {
		FacesContext facecon = FacesContext.getCurrentInstance();
		Connection connection = null;

		ControlBean ctrlBean = CommonUtils.getControlBean();
		String M_TITLE = ctrlBean.getM_USER_ID() + " "
				+ ctrlBean.getM_SCR_NAME() + " " + new Date();
		try {
			connection = CommonUtils.getConnection();
			Test_PreForm();
			STD_PRE_FORM();
			FORM_WHEN_CREATE_RECORD();
			PM_IL_BANK_ACCOUNT_SETUP_WHEN_CREATE_RECORD();
			PM_IL_BANK_ACCOUNT_SETUP_PRE_BLOCK();
			PM_IL_BANK_ACCOUNT_SETUP_WHEN_NEW_RECORD_INSTANCE();
			// PM_IL_PM_IL_BANK_ACCOUNT_SETUP_POST_QUERY();
			// WhenNewRecordInstance();
			getTestButton().setDisabled(true);
		} catch (Exception exp) {
			exp.printStackTrace();
		}

		return null;
	}

	public void PM_IL_BANK_ACCOUNT_SETUP_WHEN_NEW_RECORD_INSTANCE()
			throws Exception {
		Connection con = CommonUtils.getConnection();
		try {
			String M_PC_VALUE = null; // ** METADATA NOT FOUND *********//*
			String selectQuery = QueryRepository.sql_C1
					+ getCOMP_BAS_SETUP_FOR().getValue().toString() + "'"
					+ "AND PC_TYPE  = 'IL_CPAY_MODE' ";
			ResultSet rs = new CRUDHandler().executeSelectStatement(selectQuery, con);
			if (rs.next()) {
				M_PC_VALUE = rs.getString(1);
			}
			rs.close();
			int s = 0;

			if (nvl(M_PC_VALUE, 0).equals("1")
					|| nvl(M_PC_VALUE, 0).equals("2")) {
				getCOMP_BAS_CUST_BANK_CODE().setDisabled(false);
				getCOMP_BAS_CUST_BANK_CODE().setReadonly(false);
				getCOMP_BAS_OUR_BANK_CODE().setDisabled(false);
				getCOMP_BAS_OUR_BANK_CODE().setReadonly(false);
			} else {
				getCOMP_BAS_CUST_BANK_CODE().setDisabled(true);

			}
			if (nvl(M_PC_VALUE, 0).equals("0")) {
				getCOMP_BAS_OUR_BANK_CODE().setRequired(false);
			} else {
				getCOMP_BAS_OUR_BANK_CODE().setRequired(true);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	public String nvl(String value1, int value2) {
		if ("".equals(value1)) {
			value1 = "" + value2;
		}
		return value1;

	}

	public String nvl(String value1, String value2) {
		if ("".equals(value1)) {
			value1 = "" + value2;
		}
		return value1;
	}

	public void PM_IL_BANK_ACCOUNT_SETUP_WHEN_CREATE_RECORD() {
		Map<String, Object> session = new CommonUtils().getSessionMap();
		String global = (String) session.get("GLOBAL.M_PARAM_1");
		PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_TXN_TYPE((String) session
				.get("GLOBAL.M_PARAM_1"));
		PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_SETUP_FOR("C");
		PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_ASSURED_TYPE("R");
	}

	public void FORM_PRE_COMMIT() {
		STD_PRE_COMMIT();
	}

	private void STD_PRE_COMMIT() {
		ControlBean ctrlBean = CommonUtils.getControlBean();
		String M_COMM_DEL = ctrlBean.getM_COMM_DEL().toString();
		String N_COMM_DEL = nvl(M_COMM_DEL, "X");
		if (N_COMM_DEL.equals("C") || N_COMM_DEL.equals("P")
				|| N_COMM_DEL.equals("D")) {
		}
	}

	public void Test_PreForm() {
	}


	public void STD_PRE_FORM() {
		ControlBean ctrlBean = CommonUtils.getControlBean();
		ctrlBean = CommonUtils.getControlBean();
		ctrlBean.setM_PARA_1( CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"));
		ctrlBean.setM_PROG_NAME("PILM050_APAC");
		ctrlBean.setM_GOFLD_NAME("NULL");
		
	}

	public void FORM_WHEN_WINDOW_ACTIVATED() {
	}

	public void FORM_WHEN_NEW_ITEM_INSTANCE() {
		// LOAD_ITEM_HINT Being Called -

	}

	public void FORM_WHEN_NEW_BLOCK_INSTNCE() {
		// CHECK_BLK_NAVG -BEING Called -

	}

	public void FORM_WHEN_CREATE_RECORD() {
		// LOAD_DFLT_VALUES Is Being Called

	}

	public void FORM_WHEN_NEW_RECORD_INSTANCE() {
		// contains Null
	}

	public void FORM_WHEN_NEW_FORM_INSTANCE() {
		// Contains Null
	}

	/*
	 * public String preMethod(){ System.out.println("Muthu the
	 * Great..........."); getTestButton().setDisabled(true); return ""; }
	 */

	public void FORM_POST_DATABASE_COMMIT() {
		// :GLOBAL.M_FAILURE := 'FALSE' ;

	}

	public void FORM_POST_FORMS_COMMIT() {
		// :GLOBAL.M_FAILURE := 'FALSE' ;
	}

	public void WHEN_NEW_FORM_INSTANCE() {
		// CONTAINS NULL
	}

	public HtmlCommandButton getTestButton() {
		return testButton;
	}

	public void setTestButton(HtmlCommandButton testButton) {
		this.testButton = testButton;
	}
	
	public ArrayList<LovBean> lovBAS_DIVN_FM_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM050_APAC","PM_IL_BANK_ACCOUNT_SETUP","BAS_DIVN_FM_CODE",
					CommonUtils.getControlBean().getM_COMP_CODE(),null,null,null,null,(String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}


	public ArrayList<LovBean> lovBAS_DIVN_TO_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM050_APAC","PM_IL_BANK_ACCOUNT_SETUP","BAS_DIVN_TO_CODE",
					CommonUtils.getControlBean().getM_COMP_CODE(),null,	null,null,	null,(String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	
	public List<LovBean>DepartmentSuggestionBox(Object event) {
        String code = (String) event;
		List<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		if ("*".equals(code)) {
			
			object = new Object[] { this.getPM_IL_BANK_ACCOUNT_SETUP_BEAN().getBAS_DIVN_FM_CODE(),this.getPM_IL_BANK_ACCOUNT_SETUP_BEAN().getBAS_DIVN_TO_CODE(),PELConstants.suggetionRecordSize };
	
			//	object = new Object[] { PELConstants.suggetionRecordSize };
			
			
			query = "SELECT DEPT_CODE,DEPT_NAME FROM PM_DEPARTMENT WHERE (DEPT_DIVN_CODE BETWEEN ? AND ? )AND " +
					" ROWNUM < ? ORDER BY 1";
		} else {
			object = new Object[] { this.getPM_IL_BANK_ACCOUNT_SETUP_BEAN().getBAS_DIVN_FM_CODE(),this.getPM_IL_BANK_ACCOUNT_SETUP_BEAN().getBAS_DIVN_TO_CODE(),code + "%",
					PELConstants.suggetionRecordSize };
			query =  "SELECT DEPT_CODE,DEPT_NAME FROM PM_DEPARTMENT WHERE (DEPT_DIVN_CODE BETWEEN ? AND ? )AND "  +
				"(DEPT_CODE LIKE ? ) " +
					"AND ROWNUM < ? ORDER BY 1";
		}
		try {
			suggestionList = prepareLovList(query, object);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Dept Code Suggestion", e.getMessage());
		}
		return suggestionList;
	}

	
	public List<LovBean> prepareLovList(String query, Object[] obj) {
		List<LovBean> suggestionList = new ArrayList<LovBean>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, obj);
			while (resultSet.next()) {
				LovBean bean = new LovBean();
				bean.setLovCode(resultSet.getString(1));
				bean.setLovName(resultSet.getString(2));
				suggestionList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return suggestionList;
	}
	
	
	/*
	public List<LovBean> DepartmentSuggestionBox(Object obj) throws Exception {
		ListItemUtil listItemUtil = null;
		try {
			listItemUtil = new ListItemUtil();
			listLov = listItemUtil.P_CALL_LOV("PILM050_APAC", "PM_IL_BANK_ACCOUNT_SETUP", "BAS_DEPT_FM_CODE", 
					"IL_PVOU_DTYP", null, null, null, null, (String)obj);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("DepartmentSuggestionBox",e.getMessage());
		}
		return listLov;
	}
*/
	public ArrayList<LovBean> lovBAS_CUST_BANK_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV( "PILM050_APAC","PM_IL_BANK_ACCOUNT_SETUP","BAS_CUST_BANK_CODE",
			           null,null, null,null, null,(String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public ArrayList<LovBean> lovBAS_OUR_BANK_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV( "PILM050_APAC","PM_IL_BANK_ACCOUNT_SETUP","BAS_OUR_BANK_CODE",
			             null,null, null,null, null,(String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
 
	public ArrayList<LovBean> lovBAS_MAIN_ACNT_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV( "PILM050_APAC","PM_IL_BANK_ACCOUNT_SETUP","BAS_MAIN_ACNT_CODE",
			             null,null, null,null, null,(String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	
	public ArrayList<LovBean> lovBAS_DIVN_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV( "PILM050_APAC","PM_IL_BANK_ACCOUNT_SETUP","BAS_DIVN_CODE",
			             CommonUtils.getControlBean().getM_COMP_CODE(),null, null,null, null,(String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public ArrayList<LovBean> lovBAS_DEPT_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			
			suggestionList = listitemutil.P_CALL_LOV( "PILM050_APAC","PM_IL_BANK_ACCOUNT_SETUP","BAS_DEPT_CODE",
			             CommonUtils.getControlBean().getM_COMP_CODE(),PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_DIVN_CODE(), null,null, null,(String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public ArrayList<LovBean> lovBAS_ANLY_CODE_1(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV( "PILM050_APAC","PM_IL_BANK_ACCOUNT_SETUP","BAS_ANLY_CODE_1","1",null, null,
			             null, null,(String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	
	public ArrayList<LovBean> lovBAS_ANLY_CODE_2(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV( "PILM050_APAC","PM_IL_BANK_ACCOUNT_SETUP",
					"BAS_ANLY_CODE_2","2",null, null,null, null,(String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public ArrayList<LovBean> lovBAS_ACTY_CODE_1(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			/*suggestionList = listitemutil.P_CALL_LOV( "PILM050_APAC","PM_IL_BANK_ACCOUNT_SETUP","BAS_ACTY_CODE_1",
					PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_MAIN_ACNT_CODE(),null, null,null, null,(String) currValue);*/
			suggestionList = helper.getActivityCodeLov((String)currValue, PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_MAIN_ACNT_CODE());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public ArrayList<LovBean> lovBAS_ACTY_CODE_2(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			/*suggestionList = listitemutil.P_CALL_LOV( "PILM050_APAC","PM_IL_BANK_ACCOUNT_SETUP","BAS_ACTY_CODE_2", 
					PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_MAIN_ACNT_CODE(),null, null,null, null,(String) currValue);*/
			suggestionList = helper.getActivityCodeLov((String)currValue, PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_MAIN_ACNT_CODE());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	
	public void BAS_DEPT_FM_CODE_when_validateListener(ActionEvent ae){

	String FM_CODE_FROM = null;
	try {
	    if (getCOMP_BAS_DEPT_FM_CODE().getSubmittedValue() != null) {
		FM_CODE_FROM = getCOMP_BAS_DEPT_FM_CODE().getSubmittedValue().toString().trim();
	    }
	    if ("".equals(FM_CODE_FROM) || FM_CODE_FROM.equals(null)) {
		getCOMP_BAS_DEPT_FM_CODE().setSubmittedValue("0");
		PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_DEPT_FM_CODE("0");
		PM_IL_BANK_ACCOUNT_SETUP_BEAN.setUI_M_DEPT_FM_DESC("");
	    } else {
		PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_DEPT_FM_CODE(FM_CODE_FROM);
		PM_IL_BANK_ACCOUNT_SETUP_BEAN.setUI_M_DEPT_FM_DESC((DBProcedures.callP_VAL_CODES(
				"IL_PVOU_DTYP", FM_CODE_FROM, "L", "E", null).get(0)));
	    }
	    COMP_UI_M_DEPT_FM_DESC.resetValue();
	} catch (Exception e) {
	    e.printStackTrace();
	   getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
	   getErrorMap().put("COMP_UI_M_DEPT_FM", e.getMessage());
	} finally {
	    try {ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(),
	    		"BAS_DEPT_FM_CODE", getWarningMap());
	    } catch (Exception e) {e.printStackTrace();}
	}
    }

	public void Bring_BAS_DEPT_FM_CODE_DESC() throws Exception{
		String FM_CODE_DESC =(String) getCOMP_BAS_DEPT_FM_CODE().getSubmittedValue();
		String query = "SELECT DEPT_NAME FROM FM_DEPARTMENT WHERE  DEPT_CODE = ? ";
		try {
			Connection con = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(query, con);
			while (rs.next()) {
				COMP_UI_M_DEPT_FM_DESC.setSubmittedValue(rs.getString("DEPT_NAME"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void Bring_BAS_DIVN_FM_CODE_DESC() throws Exception {
		String FM_DESC = (String)getCOMP_BAS_DIVN_FM_CODE().getValue();
		String query = QueryRepository.PM_IL_BANK_ACCOUNT_SETUP_DIVISION_LOV
				+ "AND DIVN_CODE = '" + FM_DESC + "'";
		Connection con = CommonUtils.getConnection();
		try {
			rs = new CRUDHandler().executeSelectStatement(query, con);
			while (rs.next()) {
				String DESCRIPTION = rs.getString("DIVN_NAME");
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

    	public void BAS_DEPT_TO_CODE_when_validateListener(ActionEvent ae){
    	String FM_CODE_TO = null;
        	try {
        	    if (getCOMP_BAS_DEPT_TO_CODE().getSubmittedValue() != null) {
        		FM_CODE_TO = (String)getCOMP_BAS_DEPT_TO_CODE().getSubmittedValue();
        	    }
        	    if ("".equals(FM_CODE_TO) || FM_CODE_TO.equals(null)) {
        		getCOMP_BAS_DEPT_TO_CODE().setSubmittedValue("zzzzzz");
        		PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_DEPT_TO_CODE("zzzzzz");
        		PM_IL_BANK_ACCOUNT_SETUP_BEAN.setUI_M_DEPT_TO_DESC("");
        	    } else {
        		PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_DEPT_TO_CODE(FM_CODE_TO);
        		PM_IL_BANK_ACCOUNT_SETUP_BEAN
        			.setUI_M_DEPT_TO_DESC((DBProcedures.callP_VAL_CODES(
        				"IL_PVOU_DTYP", FM_CODE_TO, "L", "E", null)
        				.get(0)));
        	    }
        	    COMP_UI_M_DEPT_TO_DESC.resetValue();
        	} catch (Exception e) {
        	    e.printStackTrace();
        	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
        	    getErrorMap().put("BAS_DEPT_TO_CODE", e.getMessage());
        	    
        	} finally {
        	    try {
        		ErrorHelpUtil.getWarningForProcedure(CommonUtils
        			.getConnection(), "BAS_DEPT_TO_CODE", getWarningMap());
        	    } catch (Exception e) {
        		e.printStackTrace();
        	    }
        	}
    
        }

	public void Bring_BAS_DEPT_TO_CODE_DESC() throws Exception {
		String FM_CODE_DESC =(String) getCOMP_BAS_DEPT_TO_CODE().getSubmittedValue();
		String query = "SELECT DEPT_NAME FROM FM_DEPARTMENT WHERE  DEPT_CODE = ? ";
		try {
			Connection con = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(query, con, new Object[] {FM_CODE_DESC});
			while (rs.next()) {
				COMP_UI_M_DEPT_TO_DESC.setSubmittedValue(rs.getString("DEPT_NAME"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	 
	public void VALIDATE_BAS_VALUE_FROM(ActionEvent ae) {
	    try{
		Integer BAS_VALUE_TO = Integer.parseInt((String)getCOMP_BAS_VALUE_TO().getSubmittedValue());
		Integer BAS_VALUE_FROM =  Integer.parseInt((String)getCOMP_BAS_VALUE_FROM().getSubmittedValue());

		if (BAS_VALUE_FROM < 0) {
			// STD_MESSAGE_ROUTINE(91018,:CTRL.M_LANG_CODE);
			// RAISE FORM_TRIGGER_FAILURE;
		}

		if (BAS_VALUE_FROM > BAS_VALUE_TO) {
			// STD_MESSAGE_ROUTINE(91032,:CTRL.M_LANG_CODE);
			// RAISE FORM_TRIGGER_FAILURE;
		}
    	} catch (Exception exception) {
    	    exception.printStackTrace();
    	    throw new ValidatorException(new FacesMessage(exception
    		    .getMessage()));
    	} finally {
    	    try {
    		ErrorHelpUtil.getWarningForProcedure(CommonUtils
    			.getConnection(), "BAS_VALUE_FROM", getWarningMap());
    	    } catch (Exception e) {
    		e.printStackTrace();
    	    }
    	}	
	}

	public void VALIDATE_BAS_VALUE_TO(ActionEvent ae) {
		
		int BAS_VALUE_TO = Integer.parseInt(getCOMP_BAS_VALUE_TO().getValue()
				.toString());
		int BAS_VALUE_FROM = Integer.parseInt(getCOMP_BAS_VALUE_FROM()
				.getValue().toString());
		try{
    		if (BAS_VALUE_TO < 0) {
    			// STD_MESSAGE_ROUTINE(91018,:CTRL.M_LANG_CODE);
    			// RAISE FORM_TRIGGER_FAILURE;
    		}
    
    		if (BAS_VALUE_TO < BAS_VALUE_FROM) {
    			// STD_MESSAGE_ROUTINE(91032,:CTRL.M_LANG_CODE);
    			// RAISE FORM_TRIGGER_FAILURE;
    		}
        	} catch (Exception exception) {
            	    exception.printStackTrace();
            	    throw new ValidatorException(new FacesMessage(exception
            		    .getMessage()));
            	} finally {
            	    try {
            		ErrorHelpUtil.getWarningForProcedure(CommonUtils
            			.getConnection(), "BAS_VALUE_TO", getWarningMap());
            	    } catch (Exception e) {
            		e.printStackTrace();
            	    }
            	}	

		// P_SET_SECOND_FIELD('PM_IL_BANK_ACCOUNT_SETUP.BAS_VALUE_FROM','PM_IL_BANK_ACCOUNT_SETUP.BAS_VALUE_TO');
	}
  
	public ArrayList<LovBean> lovBAS_SUB_ACNT_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV( "PILM050_APAC","PM_IL_BANK_ACCOUNT_SETUP","BAS_SUB_ACNT_CODE",
			             PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_MAIN_ACNT_CODE(),null, null,null, null,(String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	 

 
	public String createRecord() throws Exception {
		return null;
	}

	public void saveRecord() {
		CRUDHandler handler = new CRUDHandler();
		String message = null;
		try {
			Connection con = CommonUtils.getConnection();
			if (!"".equals(PM_IL_BANK_ACCOUNT_SETUP_BEAN.getROWID())
					&& PM_IL_BANK_ACCOUNT_SETUP_BEAN.getROWID() != null) {
				handler.executeInsert(PM_IL_BANK_ACCOUNT_SETUP_BEAN, con);
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
			} else {
				PM_IL_BANK_ACCOUNT_SETUP_WHEN_CREATE_RECORD();
				PM_IL_BANK_ACCOUNT_SETUP_PRE_INSERT();
				handler.executeInsert(PM_IL_BANK_ACCOUNT_SETUP_BEAN, con);
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
			}
			getWarningMap().put("current", message);
			getWarningMap().put("CURRENT", message);
			CommonUtils.doComitt();
		} catch (Exception er) {
			er.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, er.getMessage());
			getErrorMap().put("saveRecord", er.getMessage());
		}
	}

	public void DeleteRecord() {
		try {
			Connection con = CommonUtils.getConnection();
			new CRUDHandler().executeDelete(PM_IL_BANK_ACCOUNT_SETUP_BEAN, con);
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void UpdateRecord() {
		try {
			Connection con = CommonUtils.getConnection();
			new CRUDHandler().executeUpdate(PM_IL_BANK_ACCOUNT_SETUP_BEAN, con);
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ReadRecord() {
		try {
			String selectQuery = "SELECT  BAS_DIVN_FM_CODE,BAS_DIVN_TO_CODE FROM  PM_IL_BANK_ACCOUNT_SETUP WHERE BAS_DIVN_FM_CODE = 'VIJAY' ";
			Connection con = CommonUtils.getConnection();
			List datalist = new CRUDHandler().fetch(selectQuery,
					"com.iii.pel.forms.PILM050_APAC.PM_IL_BANK_ACCOUNT_SETUP",
					con);
			for (Iterator<PM_IL_BANK_ACCOUNT_SETUP> iterator = datalist
					.iterator(); iterator.hasNext();) {
				PM_IL_BANK_ACCOUNT_SETUP name = (PM_IL_BANK_ACCOUNT_SETUP) iterator
						.next();
				PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_DIVN_FM_CODE(name
						.getBAS_DIVN_FM_CODE());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void PM_IL_BANK_ACCOUNT_SETUP_PRE_INSERT() throws Exception {
		Connection con = CommonUtils.getConnection();
		try {
			String CUST_BANK_CODE = PM_IL_BANK_ACCOUNT_SETUP_BEAN
					.getBAS_CUST_BANK_CODE();
			String OUR_BANK_CODE = PM_IL_BANK_ACCOUNT_SETUP_BEAN
					.getBAS_OUR_BANK_CODE();
			double M_TEMP = -1;
			CRUDHandler handler = new CRUDHandler();
			// String
			// selectQuery1=QueryRepository.PM_IL_BANK_ACCOUNT_SETUP_PRE_INSERT_sql_C1;
			String selectQuery1 = "SELECT 1 FROM  PM_IL_BANK_ACCOUNT_SETUP  WHERE"
					+ "  BAS_DIVN_FM_CODE  = '"
					+ getCOMP_BAS_DIVN_FM_CODE().getValue().toString()
					+ "' AND"
					+ " BAS_DIVN_TO_CODE  = '"
					+ getCOMP_BAS_DIVN_TO_CODE().getValue().toString()
					+ "' AND "
					+ " BAS_DEPT_FM_CODE  = '"
					+ getCOMP_BAS_DEPT_FM_CODE().getValue().toString()
					+ "' AND"
					+ " BAS_DEPT_TO_CODE  = '"
					+ getCOMP_BAS_DEPT_TO_CODE().getValue().toString()
					+ "' AND"
					+ " BAS_TXN_TYPE  =  '"
					+ PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_TXN_TYPE()
					+ "' AND"
					+ " BAS_SETUP_FOR  = '"
					+ getCOMP_BAS_SETUP_FOR().getValue().toString()
					+ "' AND"
					+ " BAS_ASSURED_TYPE  = '"
					+ getCOMP_BAS_ASSURED_TYPE().getValue().toString()
					+ "' AND"
					+ " NVL(BAS_CUST_BANK_CODE, 'X')  =  NVL("
					+ "'"
					+ CUST_BANK_CODE
					+ "'"
					+ ","
					+ "'X'"
					+ ")"
					+ "  AND"
					+ " NVL(BAS_OUR_BANK_CODE, 'X')  = NVL("
					+ "'"
					+ OUR_BANK_CODE + "'" + "," + "'X'" + ")";
			System.out.println("The selectQuery1 Is --------------->>>>>>"
					+ selectQuery1);

			// ResultSet rs=null;
			// Statement
			// stmt_C1=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String selectQuery2 = QueryRepository.PM_IL_BANK_ACCOUNT_SETUP_PRE_INSERT_sql_C2;
			// ResultSet rs1=null;
			// Statement
			// stmt_C2=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			// if(isInsert())
			System.out
					.println("PM_IL_BANK_ACCOUNT_SETUP_ACTION.PM_IL_BANK_ACCOUNT_SETUP_PRE_INSERT()-11");

			ResultSet rs = handler.executeSelectStatement(selectQuery1, con);
			/*
			 * if(rs!=null) { rs.close(); }
			 */
			// rs=stmt_C1.executeQuery(sql_C1);
			if (rs.next()) {
				M_TEMP = rs.getDouble(1);
				System.out
						.println("PM_IL_BANK_ACCOUNT_SETUP_ACTION.PM_IL_BANK_ACCOUNT_SETUP_PRE_INSERT()-M_TEMP"
								+ M_TEMP);
			}
			/*
			 * if(!rs.isLast()) { //
			 * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(1033,:CTRL.M_LANG_CODE);
			 * rs.close(); //throw new FORM_TRIGGER_FAILURE(); }
			 */
			rs.close();
		}
		/*
		 * else {
		 * System.out.println("PM_IL_BANK_ACCOUNT_SETUP_ACTION.PM_IL_BANK_ACCOUNT_SETUP_PRE_INSERT()-ELSE-INSIDE");
		 * 
		 * 
		 * ResultSet rs1 = handler.executeSelectStatement(selectQuery2, con);
		 * if(rs1!=null) { rs1.close(); } if(rs1.next()) {
		 * M_TEMP=rs1.getDouble(1); } if(!rs1.isLast()) {
		 * //STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(1033,:CTRL.M_LANG_CODE);
		 * rs1.close(); //throw new FORM_TRIGGER_FAILURE(); } rs1.close(); }
		 */
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null) {
				// SwisSqlConnection.getInstance().closeConnection(con);
				// con.close();
			}
		}

		// ctrlBean = new ControlBean();
		ControlBean ctrlBean = CommonUtils.getControlBean();
		PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_CR_DT(new java.sql.Date(Calendar
				.getInstance().getTimeInMillis()));
		PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_CR_UID(ctrlBean.getM_USER_ID());
	}

	public void PM_IL_BANK_ACCOUNT_SETUP_PRE_BLOCK() {
		System.out
				.println("PM_IL_BANK_ACCOUNT_SETUP_ACTION.PM_IL_BANK_ACCOUNT_SETUP_PRE_BLOCK()-Inside");
		ControlBean ctrlBean = CommonUtils.getControlBean();
		ctrlBean = CommonUtils.getControlBean();
		ctrlBean.setM_DELETE_MSG_FLAG("Y");
		// :CTRL.M_DELETE_MSG_FLAG := 'Y';
	}

	public void PM_IL_BANK_ACCOUNT_SETUP_PRE_UPDATE() throws Exception {

		// Similar to PRE-INSERT the codes are copied from there

		System.out
				.println("PM_IL_BANK_ACCOUNT_SETUP_ACTION.PM_IL_BANK_ACCOUNT_SETUP_PRE_INSERT()-Inside");
		Connection con = CommonUtils.getConnection();
		try {
			String CUST_BANK_CODE = getCOMP_BAS_CUST_BANK_CODE().getValue()
					.toString();
			String OUR_BANK_CODE = getCOMP_BAS_OUR_BANK_CODE().getValue()
					.toString();
			double M_TEMP = -1;
			// String
			// selectQuery1=QueryRepository.PM_IL_BANK_ACCOUNT_SETUP_PRE_INSERT_sql_C1;
			String selectQuery1 = "SELECT 1 FROM  PM_IL_BANK_ACCOUNT_SETUP  WHERE"
					+ "  BAS_DIVN_FM_CODE  = '"
					+ getCOMP_BAS_DIVN_FM_CODE().getValue().toString()
					+ "' AND"
					+ " BAS_DIVN_TO_CODE  = '"
					+ getCOMP_BAS_DIVN_TO_CODE().getValue().toString()
					+ "' AND "
					+ " BAS_DEPT_FM_CODE  = '"
					+ getCOMP_BAS_DEPT_FM_CODE().getValue().toString()
					+ "' AND"
					+ " BAS_DEPT_TO_CODE  = '"
					+ getCOMP_BAS_DEPT_TO_CODE().getValue().toString()
					+ "' AND"
					+ " BAS_TXN_TYPE  =  '"
					+ PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_TXN_TYPE()
					+ "' AND"
					+ " BAS_SETUP_FOR  = '"
					+ getCOMP_BAS_SETUP_FOR().getValue().toString()
					+ "' AND"
					+ " BAS_ASSURED_TYPE  = '"
					+ getCOMP_BAS_ASSURED_TYPE().getValue().toString()
					+ "' AND"
					+ " NVL(BAS_CUST_BANK_CODE, 'X')  =  NVL("
					+ "'"
					+ CUST_BANK_CODE
					+ "'"
					+ ","
					+ "'X'"
					+ ")"
					+ "  AND"
					+ " NVL(BAS_OUR_BANK_CODE, 'X')  = NVL("
					+ "'"
					+ OUR_BANK_CODE + "'" + "," + "'X'" + ")";
			System.out.println("The selectQuery1 Is --------------->>>>>>"
					+ selectQuery1);

			// ResultSet rs=null;
			// Statement
			// stmt_C1=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String selectQuery2 = QueryRepository.PM_IL_BANK_ACCOUNT_SETUP_PRE_INSERT_sql_C2;
			// ResultSet rs1=null;
			// Statement
			// stmt_C2=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			// if(isInsert())
			System.out
					.println("PM_IL_BANK_ACCOUNT_SETUP_ACTION.PM_IL_BANK_ACCOUNT_SETUP_PRE_INSERT()-11");

			ResultSet rs = new CRUDHandler().executeSelectStatement(selectQuery1, con);
			/*
			 * if(rs!=null) { rs.close(); }
			 */
			// rs=stmt_C1.executeQuery(sql_C1);
			if (rs.next()) {
				M_TEMP = rs.getDouble(1);
				System.out
						.println("PM_IL_BANK_ACCOUNT_SETUP_ACTION.PM_IL_BANK_ACCOUNT_SETUP_PRE_INSERT()-M_TEMP"
								+ M_TEMP);
			}
			/*
			 * if(!rs.isLast()) { //
			 * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(1033,:CTRL.M_LANG_CODE);
			 * rs.close(); //throw new FORM_TRIGGER_FAILURE(); }
			 */
			rs.close();
			//[ Removed Hard coded user id: added by: Shankar bodduluri Dated: 19-Mar-2009 ]
			ControlBean ctrlBean = CommonUtils.getControlBean();
			PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_UPD_DT(new CommonUtils().getCurrentDate());
			PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_UPD_UID(ctrlBean.getM_USER_ID());
		}
		 
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null) {
				// SwisSqlConnection.getInstance().closeConnection(con);
				// on.close();
			}
		}

		// ctrlBean = new ControlBean();

	}

	public void PM_IL_PM_IL_BANK_ACCOUNT_SETUP_POST_QUERY() throws Exception {
		Connection con = CommonUtils.getConnection();
		try {

			String selectQuery1 = QueryRepository.PM_IL_PM_IL_BANK_ACCOUNT_SETUP_POST_QUERY_sql_C1
					+ getCOMP_BAS_CUST_BANK_CODE().getValue().toString() + "'";
			String selectQuery2 = QueryRepository.PM_IL_PM_IL_BANK_ACCOUNT_SETUP_POST_QUERY_sql_C2
					+ getCOMP_BAS_OUR_BANK_CODE().getValue().toString() + "'";

			ResultSet rs = new CRUDHandler().executeSelectStatement(selectQuery1, con);
			ResultSet rs1 = new CRUDHandler().executeSelectStatement(selectQuery2, con);
			String /** METADATA NOT FOUND ******** */
			M_BANK_NAME = null;
			String /** METADATA NOT FOUND ******** */
			M_DESC = null;
			String /** METADATA NOT FOUND ******** */
			M_DESC1 = null;
			String /** METADATA NOT FOUND ******** */
			M_DESC3 = null;
			String /** METADATA NOT FOUND ******** */
			M_DESC4 = null;
			String /** METADATA NOT FOUND ******** */
			M_PC_VALUE = null;

			if (PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_DIVN_FM_CODE() != null) {
				/*
				 * To Be Called In BackEnd
				 * 
				 * P_VAL_DIVN.P_VAL_DIVN(:PM_IL_BANK_ACCOUNT_SETUP.BAS_DIVN_FM_CODE,M_DESC,"N","N");
				 */

			}
			if (PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_DIVN_TO_CODE() != null) {
				/*
				 * To be Called In BackEnd
				 * 
				 * P_VAL_DIVN.P_VAL_DIVN(:PM_IL_BANK_ACCOUNT_SETUP.BAS_DIVN_TO_CODE,M_DESC1,"N","N");
				 */

			}
			if (PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_DEPT_FM_CODE() != null) {
				Bring_BAS_DEPT_FM_CODE_DESC();
				// Alternative to Calling P_VAL_DEPT
			}
			if (PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_DEPT_TO_CODE() != null) {

				Bring_BAS_DEPT_TO_CODE_DESC();
			}

			if (PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_MAIN_ACNT_CODE() != null) {

				//Bring_BAS_MAIN_ACNT_CODE_DESC();
				/*
				 * Alternative To Calling P_VAL_MAIN_ACNT To be Called In
				 * BackEnd
				 * P_VAL_MAIN_ACNT.P_VAL_MAIN_ACNT(:PM_IL_BANK_ACCOUNT_SETUP.BAS_MAIN_ACNT_CODE,:PM_IL_BANK_ACCOUNT_SETUP.M_MAIN_ACNT_DESC,"N","N");
				 */

			}
			if (PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_SUB_ACNT_CODE() != null) {

				//Bring_BAS_SUB_ACNT_CODE_DESC();

				/*
				 * To be Called In BackEnd
				 * P_VAL_SUB_ACNT.P_VAL_SUB_ACNT(:PM_IL_BANK_ACCOUNT_SETUP.BAS_MAIN_ACNT_CODE,:PM_IL_BANK_ACCOUNT_SETUP.BAS_SUB_ACNT_CODE,:PM_IL_BANK_ACCOUNT_SETUP.M_SUB_ACNT_DESC,"N","N");
				 */

			}
			if (PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_DIVN_CODE() != null) {

				//Bring_BAS_DIVN_CODE_DESC();
				/*
				 * To be Called In BackEnd
				 * F_VAL_DIVN.F_VAL_DIVN(:PM_IL_BANK_ACCOUNT_SETUP.BAS_DIVN_CODE,:PM_IL_BANK_ACCOUNT_SETUP.M_DIVN_DESC,"N","N");
				 */

			}
			if (PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_DEPT_CODE() != null) {

				//Bring_BAS_DEPT_CODE_DESC();
				/*
				 * To be Called In BackEnd
				 * F_VAL_DEPT.F_VAL_DEPT(:PM_IL_BANK_ACCOUNT_SETUP.BAS_DIVN_CODE,:PM_IL_BANK_ACCOUNT_SETUP.BAS_DEPT_CODE,:PM_IL_BANK_ACCOUNT_SETUP.M_DEPT_DESC,"N","N");
				 */

			}
			if (PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_ANLY_CODE_1() != null) {

				//Bring_BAS_ANLY_CODE_1_DESC();
				// P_VAL_ANLY.P_VAL_ANLY("1",:PM_IL_BANK_ACCOUNT_SETUP.BAS_ANLY_CODE_1,:PM_IL_BANK_ACCOUNT_SETUP.M_ANLY_1_DESC,"N","N");
			}
			if (PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_ANLY_CODE_2() != null) {
				//Bring_BAS_ANLY_CODE_2_DESC();
				// P_VAL_ANLY.P_VAL_ANLY(2,:PM_IL_BANK_ACCOUNT_SETUP.BAS_ANLY_CODE_2,:PM_IL_BANK_ACCOUNT_SETUP.M_ANLY_2_DESC,"N","N");
			}
			if (PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_ACTY_CODE_1() != null) {
				// P_VAL_ACTY.P_VAL_ACTY(:PM_IL_BANK_ACCOUNT_SETUP.BAS_MAIN_ACNT_CODE,:PM_IL_BANK_ACCOUNT_SETUP.BAS_ACTY_CODE_1,:PM_IL_BANK_ACCOUNT_SETUP.M_ACTY_1_DESC,"N","N");
			}
			if (PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_ACTY_CODE_2() != null) {
				// P_VAL_ACTY.P_VAL_ACTY(:PM_IL_BANK_ACCOUNT_SETUP.BAS_MAIN_ACNT_CODE,:PM_IL_BANK_ACCOUNT_SETUP.BAS_ACTY_CODE_2,:PM_IL_BANK_ACCOUNT_SETUP.M_ACTY_2_DESC,"N","N");
			}
			if (PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_DEPT_FM_CODE() != null) {
				/*
				 * 
				 * P_VAL_CODES.P_VAL_CODES("IL_PVOU_DTYP",:PM_IL_BANK_ACCOUNT_SETUP.BAS_DEPT_FM_CODE,:PM_IL_BANK_ACCOUNT_SETUP.M_DEPT_FM_DESC,"N","N",M_PC_VALUE);
				 */
			}
			if (PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_DEPT_TO_CODE() != null) {
				/*
				 * 
				 * P_VAL_CODES.P_VAL_CODES("IL_PVOU_DTYP",:PM_IL_BANK_ACCOUNT_SETUP.BAS_DEPT_TO_CODE,:PM_IL_BANK_ACCOUNT_SETUP.M_DEPT_TO_DESC,"N","N",M_PC_VALUE);
				 */

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	private String L_CHK_BANK(String cust_bank_code, String P_ERR_FLAG,String cust_bank_desc) throws Exception {
		String CURSOR_C1 = "SELECT BANK_NAME FROM   FM_BANK WHERE  BANK_CODE = ?  " ;
		ResultSet resultSet = null;
		try {
			resultSet = new CRUDHandler().executeSelectStatement(CURSOR_C1,
					CommonUtils.getConnection() ,
					new Object[] {cust_bank_code});
			
			if (resultSet.next()) {
				cust_bank_desc = resultSet.getString(1);
			}else {
				if ("E".equals(P_ERR_FLAG)) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "80611"));
				}else if("N".equals(P_ERR_FLAG)) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "80611"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return cust_bank_desc;
	}

	public List getDivisionlist() {
		return Divisionlist;
	}

	public void setDivisionlist(List divisionlist) {
		Divisionlist = divisionlist;
	}

	public List getDepartmentList() {
		return DepartmentList;
	}

	public void setDepartmentList(List departmentList) {
		DepartmentList = departmentList;
	}
 

	public void setBAS_SETUP_FOR_LIST(List<SelectItem> bas_setup_for_list) {
		BAS_SETUP_FOR_LIST = bas_setup_for_list;
	}

 
	public void setBAS_ASSURED_TYPE_LIST(List<SelectItem> bas_assured_type_list) {
		BAS_ASSURED_TYPE_LIST = bas_assured_type_list;
	}

	 

	public void BAS_CUST_BANK_CODE_when_validate_Item(){
		try {
			String CUST_BANK_CODE = (String ) getCOMP_BAS_CUST_BANK_CODE().getValue();
			String CUST_BANK_DESC = (String) getCOMP_UI_M_CUST_BANK_DESC().getValue();
			L_CHK_BANK(CUST_BANK_CODE, "E", CUST_BANK_DESC);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("BAS_CUST_BANK_CODE", e.getMessage());
		}
	}
 
	public void BAS_MAX_PAYEE_CHAR_when_validate_Item() {
		String BAS_MAX_PAYEE_CHAR = null;
		BAS_MAX_PAYEE_CHAR = getCOMP_BAS_MAX_PAYEE_CHAR().getValue().toString();
		int payeechar = Integer.parseInt(BAS_MAX_PAYEE_CHAR);
		if (payeechar < 0) {
			// STD_MESSAGE_ROUTINE(91341,:CTRL.M_LANG_CODE);
			// RAISE FORM_TRIGGER_FAILURE;
		} else if ((payeechar % 1) != 0) {

			// STD_MESSAGE_ROUTINE(91929,:CTRL.M_LANG_CODE);
			// RAISE FORM_TRIGGER_FAILURE;
		}

	}
 
	public HtmlCommandButton getHomeButton() {
		return homeButton;
	}

	public void setHomeButton(HtmlCommandButton homeButton) {
		this.homeButton = homeButton;
	}

	public HtmlOutputLabel getCOMP_BAS_TXN_TYPE_LABEL() {
		return COMP_BAS_TXN_TYPE_LABEL;
	}

	public void setCOMP_BAS_TXN_TYPE_LABEL(
			HtmlOutputLabel comp_bas_txn_type_label) {
		COMP_BAS_TXN_TYPE_LABEL = comp_bas_txn_type_label;
	}

	public HtmlSelectOneMenu getCOMP_BAS_TXN_TYPE() {
		return COMP_BAS_TXN_TYPE;
	}

	public void setCOMP_BAS_TXN_TYPE(HtmlSelectOneMenu comp_bas_txn_type) {
		COMP_BAS_TXN_TYPE = comp_bas_txn_type;
	}

	public List<SelectItem> getBAS_SETUP_FOR_LIST() {
		return BAS_SETUP_FOR_LIST;
	}

	public List<SelectItem> getBAS_ASSURED_TYPE_LIST() {
		return BAS_ASSURED_TYPE_LIST;
	}

	
	private List<PM_IL_BANK_ACCOUNT_SETUP> custClassList = null;
	public List<PM_IL_BANK_ACCOUNT_SETUP> DependencyDepartmentSuggestionBox(Object string){
		custClassList = getDepartmenForSuggitionList(string);
		return custClassList;
	}

	
	public ArrayList<PM_IL_BANK_ACCOUNT_SETUP> getDepartmenForSuggitionList(Object string) {
		String selectQuery = " SELECT DEPT_CODE, DEPT_NAME FROM FM_DEPARTMENT "+
							 " WHERE DEPT_COMP_CODE = ? AND DEPT_DIVN_CODE = ? "+
							 " AND DEPT_FRZ_FLAG  = 'N' AND EXISTS ( SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE"+ 
							 " ADS_DIVN_CODE = DEPT_DIVN_CODE AND  ADS_DEPT_CODE = DEPT_CODE AND "+
							 " ADS_USER_ID = NVL(?,ADS_USER_ID) AND ADS_FRZ_FLAG = 'N') {0}";
		ArrayList<PM_IL_BANK_ACCOUNT_SETUP> custClassList = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values;
		String M_COMP_CODE = CommonUtils.getControlBean().getM_COMP_CODE();
		String M_DIVN_NAME = CommonUtils.getControlBean().getM_DIVN_CODE();
		String M_USER_NAME = CommonUtils.getControlBean().getM_USER_ID();
		if ("*".equals(string)) {
			selectQuery = selectQuery.replace("{0}", "ORDER BY 1 ASC");
			values = new Object[3];
			values[0] = M_COMP_CODE;
			values[1] = M_DIVN_NAME;
			values[2] = M_USER_NAME;
		} else {
			values = new Object[4];
			selectQuery = selectQuery.replace("{0}", "AND DEPT_CODE LIKE ? ORDER BY 1 ASC");
			values[0] = M_COMP_CODE;
			values[1] = M_DIVN_NAME;
			values[2] = M_USER_NAME;
			values[3] = string + "%";
		}
		ResultSet resultSet = null;
		PM_IL_BANK_ACCOUNT_SETUP classBean = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(selectQuery, connection,values);
			custClassList = new ArrayList<PM_IL_BANK_ACCOUNT_SETUP>();
			while (resultSet.next()) {
				classBean = new PM_IL_BANK_ACCOUNT_SETUP();
				classBean.setBAS_DEPT_CODE(resultSet.getString("DEPT_CODE"));
				classBean.setUI_M_DEPT_DESC(resultSet.getString("DEPT_NAME"));
				custClassList.add(classBean);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return custClassList;
	}
	
	
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.executeQuery(this);
				 postQuery();
				setBlockFlag(false);
			}
			
			if (PM_IL_BANK_ACCOUNT_SETUP_BEAN.getCURR_FRZ_FLAG_NUM_VALUE() == true) {
			//	COMP_DEL_BUT.setRendered(false);
				disableAllComponent(true);
//				PM_IL_BANK_ACCOUNT_SETUP_BEAN.setFRZLABEL("Freeze");
			} else {
				//COMP_DEL_BUT.setRendered(false);
				disableAllComponent(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	
	private void postQuery() throws Exception{ 
		try {
			
			if (PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_CUST_BANK_CODE() != null) {
				PM_IL_BANK_ACCOUNT_SETUP_BEAN.setUI_M_CUST_BANK_DESC(Bring_BAS_CUST_BANK_CODE_DESC(
						PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_CUST_BANK_CODE()));
			}
			
			if (PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_OUR_BANK_CODE() != null) {
				PM_IL_BANK_ACCOUNT_SETUP_BEAN.setUI_M_OUR_BANK_DESC(Bring_BAS_OUR_BANK_CODE_DESC(
						PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_OUR_BANK_CODE()));
				
			}
			
			if (PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_MAIN_ACNT_CODE() != null) {
				PM_IL_BANK_ACCOUNT_SETUP_BEAN.setUI_M_MAIN_ACNT_DESC(Bring_BAS_MAIN_ACNT_CODE_DESC(
						PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_MAIN_ACNT_CODE()));
				
			}
			
			if (PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_SUB_ACNT_CODE() != null) {
			/*	PM_IL_BANK_ACCOUNT_SETUP_BEAN.setUI_M_SUB_ACNT_DESC(Bring_BAS_SUB_ACNT_CODE_DESC(
						PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_SUB_ACNT_CODE()));*/
				helper.BAS_SUB_ACNT_CODE_WHEN_VALIDATE_ITEM( PM_IL_BANK_ACCOUNT_SETUP_BEAN,this );
			}
			
			if (PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_DIVN_CODE() != null) {
				PM_IL_BANK_ACCOUNT_SETUP_BEAN.setUI_M_DIVN_DESC(Bring_BAS_DIVN_CODE_DESC(
						PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_DIVN_CODE()));
			}
			
			if (PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_DEPT_CODE() != null) {
				PM_IL_BANK_ACCOUNT_SETUP_BEAN.setUI_M_DEPT_DESC(Bring_BAS_DEPT_DESC(
						PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_DEPT_CODE()));
			}	
			
			if (PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_ANLY_CODE_1() != null) {
				PM_IL_BANK_ACCOUNT_SETUP_BEAN.setUI_M_ANLY_1_DESC(Bring_BAS_ANLY_CODE_1_DESC(
						PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_ANLY_CODE_1()));
			}
			
			if (PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_ANLY_CODE_2() != null) {
				PM_IL_BANK_ACCOUNT_SETUP_BEAN.setUI_M_ANLY_2_DESC(Bring_BAS_ANLY_CODE_2_DESC(
						PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_ANLY_CODE_2()));
			}
			
			if (PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_ACTY_CODE_1() != null) {
				PM_IL_BANK_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_1_DESC(Bring_BAS_ANLY_CODE_1_DESC(
						PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_ACTY_CODE_1()));
			}
			
			if (PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_ACTY_CODE_2() != null) {
				PM_IL_BANK_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_2_DESC(Bring_BAS_ANLY_CODE_2_DESC(
						PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_ACTY_CODE_2()));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	  
	    
	    
	
	public String Bring_BAS_CUST_BANK_CODE_DESC(String code)  throws Exception{
		   String desc = null;
		   String query = QueryRepository.PM_IL_BANK_ACCOUNT_SETUP_BANK_LOV +" WHERE BANK_CODE = ? ";
		   try {
			   Connection con = CommonUtils.getConnection();
			   rs=new CRUDHandler().executeSelectStatement(query,con, new Object[] {code});
			   while(rs.next()){
				   desc =(rs.getString("BANK_NAME"));
			   }
			   rs.close();
		   } catch (Exception e) {
			   e.printStackTrace();
			   throw new Exception(e.getMessage());
		}
		   return desc;
	   }
	
	
	
	 public String  Bring_BAS_OUR_BANK_CODE_DESC(String our_bank_code) throws Exception{
		   String desc = null;
		   String OUR_BANK_DESC = our_bank_code;
		   String query = QueryRepository.PM_IL_BANK_ACCOUNT_SETUP_BANK_LOV + " WHERE BANK_CODE = ? ";
		   Connection con = CommonUtils.getConnection();
		   rs=new CRUDHandler().executeSelectStatement(query,con , new Object[] {OUR_BANK_DESC});
		   while(rs.next()){
			  desc = rs.getString("BANK_NAME");
	      }	   
		   
		   rs.close();
		  return desc; 
	   }

	 
	 
	 public String  Bring_BAS_MAIN_ACNT_CODE_DESC(String main_acnt_code) throws Exception{
		   String desc = null;
		   String Main_account_code = main_acnt_code;
		   try {
			   if(!"".equals(Main_account_code)){
				   String query = QueryRepository.PM_IL_BANK_ACCOUNT_SETUP_MAIN_ACCOUNT_CODE_LOV +" AND  MAIN_ACNT_CODE = ? ";
				   Connection con = CommonUtils.getConnection();
				   rs=new CRUDHandler().executeSelectStatement(query,con , new Object[] {main_acnt_code});
				   while(rs.next()){
					   desc = (rs.getString("MAIN_ACNT_NAME"));
				   }
				   rs.close();
			   }
			   
		   } catch (Exception e) {
			   e.printStackTrace();
			   throw new Exception(e.getMessage());
		}
		   return desc;
	 }  
			

	 
	 
	 
	 public String Bring_BAS_SUB_ACNT_CODE_DESC(String code) throws Exception {
		
		 String desc = null;
			String query = "SELECT SUB_ACNT_CODE,SUB_ACNT_NAME,SUB_BL_ACNT_NAME FROM FM_SUB_ACCOUNT WHERE SUB_ACNT_CODE IN"
					+ "( SELECT MS_SUB_ACNT_CODE"
					+ " FROM  FM_MAIN_SUB"
					+ " WHERE MS_MAIN_ACNT_CODE = +'"
					+ code
					+ "'"
					+ " ) AND" + " NVL(SUB_FRZ_FLAG,'N') = 'N'";
			try {
				Connection con = CommonUtils.getConnection();
				rs = new CRUDHandler().executeSelectStatement(query, con);
				while (rs.next()) {
					desc = (rs.getString("SUB_ACNT_NAME"));
				}
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			return desc;
		}

	 
	 
	 public String Bring_BAS_DIVN_CODE_DESC(String code) throws Exception { 
		 String desc = null;
		 try {
			 if (!"".equals(code)) {
				 String query = QueryRepository.PM_IL_BANK_ACCOUNT_SETUP_BRANCH_LOV + "  AND DIVN_CODE  = ? ";
				 Connection con = CommonUtils.getConnection();
				 rs = new CRUDHandler().executeSelectStatement(query, con , new Object[] {code});
				 while (rs.next()) {
					 desc =(rs.getString("DIVN_NAME"));
				 }
				 rs.close();
			 }
			 
		 } catch (Exception e) {
			 e.printStackTrace();
			 throw new Exception(e.getMessage());
		}
		 return desc;
	 }

	 
	 
	 
	 public String Bring_BAS_DEPT_DESC(String code) {
			
		 String desc = null;
		 String selectQuery = " SELECT DEPT_CODE, DEPT_NAME FROM FM_DEPARTMENT "+
								 " WHERE DEPT_COMP_CODE = ? AND DEPT_DIVN_CODE = ? "+
								 " AND DEPT_FRZ_FLAG  = 'N' AND EXISTS ( SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE"+ 
								 " ADS_DIVN_CODE = DEPT_DIVN_CODE AND  ADS_DEPT_CODE = DEPT_CODE AND "+
								 " ADS_USER_ID = NVL(?,ADS_USER_ID) AND ADS_FRZ_FLAG = 'N') {0}";
			Connection connection = null;
			CRUDHandler handler = new CRUDHandler();
			Object[] values;
			String M_COMP_CODE = CommonUtils.getControlBean().getM_COMP_CODE();
			String M_DIVN_NAME = CommonUtils.getControlBean().getM_DIVN_CODE();
			String M_USER_NAME = CommonUtils.getControlBean().getM_USER_ID();
			values = new Object[4];
			selectQuery = selectQuery.replace("{0}", "AND DEPT_CODE LIKE ? ORDER BY 1 ASC");
			values[0] = M_COMP_CODE;
			values[1] = M_DIVN_NAME;
			values[2] = M_USER_NAME;
			values[3] = code + "%";
			ResultSet resultSet = null;
			try {
				connection = CommonUtils.getConnection();
				resultSet = handler.executeSelectStatement(selectQuery, connection,values);
				while (resultSet.next()) {
					
					desc=(resultSet.getString("DEPT_NAME"));
				}
			} catch (DBException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}}

			return desc;
		}
	 
	 
		public String Bring_BAS_ANLY_CODE_1_DESC(String code) throws Exception {
			String desc = null;
			String query = QueryRepository.PM_IL_BANK_ACCOUNT_SETUP_ANLY_CODE_1 + " AND ANLY_CODE =  ? ";
			try {
				Connection con = CommonUtils.getConnection();
				rs = new CRUDHandler().executeSelectStatement(query, con , new Object[]{code});
				while (rs.next()) {
					desc =(rs.getString("ANLY_NAME"));
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			return desc;
		}

		public String Bring_BAS_ANLY_CODE_2_DESC(String code) throws Exception {
			String desc = null;
			String query = QueryRepository.PM_IL_BANK_ACCOUNT_SETUP_ANLY_CODE_2+ " AND ANLY_CODE = ? ";
			try {
				Connection con = CommonUtils.getConnection();
				rs = new CRUDHandler().executeSelectStatement(query,con , new Object[] {code});
				while (rs.next()) {
					desc =(rs.getString("ANLY_NAME"));
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			return desc;
		}

		public void validateFRZ_FLAG(ActionEvent event) {
			String value = null;
			UIInput input = (UIInput) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
			}
			PM_IL_BANK_ACCOUNT_SETUP_BEAN.setCURR_FRZ_FLAG_NUM_VALUE(Boolean.parseBoolean(value));
			if (PM_IL_BANK_ACCOUNT_SETUP_BEAN.getCURR_FRZ_FLAG_NUM_VALUE() == false) {
				PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_FRZ_FLAG("N");
			} else {
				PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_FRZ_FLAG("Y");
			}
		}
	
		public void BAS_SUB_ACNT_CODE_WHEN_VALIDATE_ITEM(FacesContext fc,UIComponent component,Object value){
		CommonUtils.clearMaps(this);
		String SUB_ACC_CODE = (String) value;
		try {
		    PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_SUB_ACNT_CODE(SUB_ACC_CODE);
			if (SUB_ACC_CODE != null) {
				helper.BAS_SUB_ACNT_CODE_WHEN_VALIDATE_ITEM( PM_IL_BANK_ACCOUNT_SETUP_BEAN,this);
			}
		} catch (Exception e) {
		    e.printStackTrace();
		    throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {try {ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "BAS_SUB_ACNT_CODE",getErrorMap());
			} catch (Exception e) {e.printStackTrace();}}
	}
	
	public void actionListenerBAS_DIVN_FM(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		if (inputValue.isEmpty()) {
			COMP_BAS_DIVN_FM_CODE.setSubmittedValue("0");
			PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_DIVN_FM_CODE("0");
		} else {
			PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_DIVN_FM_CODE(inputValue);
		}
		fireFieldValidation(actionEvent);
	}

	public void actionListenerBAS_DIVN_TO(ActionEvent actionEvent) {
		HtmlInputText inputText = (HtmlInputText) actionEvent.getComponent().getParent();
		String inputTextString = (String) inputText.getSubmittedValue();
		if (inputTextString.isEmpty()) {
			if (!COMP_BAS_DIVN_FM_CODE.getSubmittedValue().equals("0")) {
				COMP_BAS_DIVN_TO_CODE.setSubmittedValue(PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_DIVN_FM_CODE());
				PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_DIVN_TO_CODE(PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_DIVN_FM_CODE());
			} else {
				COMP_BAS_DIVN_TO_CODE.setSubmittedValue("ZZZZZZ");
				PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_DIVN_TO_CODE("ZZZZZZ");
			}
		} else {
		    PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_DIVN_TO_CODE(inputTextString);
		}
		fireFieldValidation(actionEvent);
	}

	public void actionListenerBAS_DEPT_TO(ActionEvent actionEvent) {
		HtmlInputText inputText = (HtmlInputText) actionEvent.getComponent().getParent();
		String inputTextString = (String) inputText.getSubmittedValue();
		if (inputTextString.isEmpty()) {
			if (!COMP_BAS_DEPT_FM_CODE.getSubmittedValue().equals("0")) {
				COMP_BAS_DEPT_TO_CODE.setSubmittedValue(PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_DEPT_FM_CODE());
				PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_DEPT_TO_CODE(PM_IL_BANK_ACCOUNT_SETUP_BEAN.getBAS_DEPT_FM_CODE());
			} else {
				COMP_BAS_DEPT_TO_CODE.setSubmittedValue("ZZZZZZ");
				PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_DEPT_TO_CODE("ZZZZZZ");
			}
		} else {
			PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_DEPT_TO_CODE(inputTextString);
		}
	}

	public void actionListenerBAS_DEPT_FM(ActionEvent actionEvent) {
		HtmlInputText inputText = (HtmlInputText) actionEvent.getComponent().getParent();
		String inputValue = (String) inputText.getSubmittedValue();
		if (inputValue.isEmpty()) {
			COMP_BAS_DEPT_FM_CODE.setSubmittedValue("0");
			PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_DEPT_FM_CODE("0");
		} else {
		    PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_DEPT_FM_CODE(inputValue);
		}
		 fireFieldValidation(actionEvent);
	}
	
	 
	public void BAS_DIVN_FM_CODE_WHEN_VALIDATE_ITEM(FacesContext fc,UIComponent component,Object value){
	    CommonUtils.clearMaps(this);
	    String currValue = (String) value;
	    try {
		if (currValue != null) {
		    PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_DIVN_FM_CODE(currValue);
		    helper.BAS_DIVN_FM_CODE_WHEN_VALIDATE_ITEM( PM_IL_BANK_ACCOUNT_SETUP_BEAN,this);
		    COMP_BAS_DIVN_FM_CODE.resetValue();
		}
	    } catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	    } finally {try {ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "BAS_DIVN_FM_CODE",getErrorMap());
	    } catch (Exception e) {e.printStackTrace();}}
	}
	
	public void BAS_DIVN_TO_CODE_WHEN_VALIDATE_ITEM(FacesContext fc,UIComponent component,Object value){
	    CommonUtils.clearMaps(this);
	    String currValue = (String) value;
	    try {
		if (currValue != null) {
		    PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_DIVN_TO_CODE(currValue);
		    helper.BAS_DIVN_TO_CODE_WHEN_VALIDATE_ITEM( PM_IL_BANK_ACCOUNT_SETUP_BEAN,this);
		    COMP_BAS_DIVN_TO_CODE.resetValue();
		}
	    } catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	    } finally {try {ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "BAS_DIVN_TO_CODE",getErrorMap());
	    } catch (Exception e) {e.printStackTrace();}}
	}
	
	public void BAS_DEPT_FM_CODE_WHEN_VALIDATE_ITEM(FacesContext fc,UIComponent component,Object value){
	    CommonUtils.clearMaps(this);
	    String currValue = (String) value;
	    try {
		if (!currValue.equals("0")) {
		    PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_DEPT_FM_CODE(currValue);
		    helper.BAS_DEPT_FM_CODE_WHEN_VALIDATE_ITEM( PM_IL_BANK_ACCOUNT_SETUP_BEAN,this);
		    COMP_BAS_DEPT_FM_CODE.resetValue();
		}
	    } catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	    } finally {try {ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "BAS_DEPT_FM_CODE",getErrorMap());
	    } catch (Exception e) {e.printStackTrace();}}
	}
	
	public void BAS_DEPT_TO_CODE_WHEN_VALIDATE_ITEM(FacesContext fc,UIComponent component,Object value){
	    CommonUtils.clearMaps(this);
	    
	    String currValue = (String) value;
	    try {
		if (!currValue.equals("zzzzzzzzzz")) {
		    PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_DEPT_TO_CODE(currValue);
		    helper.BAS_DEPT_TO_CODE_WHEN_VALIDATE_ITEM( PM_IL_BANK_ACCOUNT_SETUP_BEAN,this);
		    COMP_BAS_DEPT_TO_CODE.resetValue();
		}
	    } catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	    } finally {try {ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "BAS_DEPT_TO_CODE",getErrorMap());
	    } catch (Exception e) {e.printStackTrace();}}
	}
	
	public void BAS_SETUP_FOR_WHEN_VALIDATE_ITEM(FacesContext fc,UIComponent component,Object value){
	    CommonUtils.clearMaps(this);
	    String currValue = (String) value;
	    try {
		if (currValue != null) {
		    PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_SETUP_FOR(currValue);
		    helper.BAS_SETUP_FOR_WHEN_VALIDATE_ITEM( PM_IL_BANK_ACCOUNT_SETUP_BEAN,this);
		    COMP_BAS_CUST_BANK_CODE.resetValue();
		    COMP_BAS_OUR_BANK_CODE.resetValue();
		}
	    } catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	    } finally {try {ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "BAS_SETUP_FOR",getErrorMap());
	    } catch (Exception e) {e.printStackTrace();}}
	}
	
	public void BAS_CUST_BANK_CODE_WHEN_VALIDATE_ITEM(FacesContext fc,UIComponent component,Object value){
	    CommonUtils.clearMaps(this);
	    String currValue = (String) value;
	    try {
		if (currValue != null) {
		    PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_CUST_BANK_CODE(currValue);
		    helper.BAS_CUST_BANK_CODE_WHEN_VALIDATE_ITEM( PM_IL_BANK_ACCOUNT_SETUP_BEAN);
		    COMP_UI_M_CUST_BANK_DESC.resetValue();
		}
	    } catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	    } finally {try {ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "BAS_CUST_BANK_CODE",getErrorMap());
	    } catch (Exception e) {e.printStackTrace();}}
	}

	public void BAS_OUR_BANK_CODE_WHEN_VALIDATE_ITEM(FacesContext fc,UIComponent component,Object value){
	    CommonUtils.clearMaps(this);
	    String currValue = (String) value;
	    try {
		if (currValue != null) {
		    PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_OUR_BANK_CODE(currValue);
		    helper.BAS_OUR_BANK_CODE_WHEN_VALIDATE_ITEM( PM_IL_BANK_ACCOUNT_SETUP_BEAN);
		    COMP_UI_M_OUR_BANK_DESC.resetValue();
		}
	    } catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	    } finally {try {ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "BAS_OUR_BANK_CODE",getErrorMap());
	    } catch (Exception e) {e.printStackTrace();}}
	}
	
	public void BAS_MAIN_ACNT_CODE_WHEN_VALIDATE_ITEM(FacesContext fc,UIComponent component,Object value){
	    CommonUtils.clearMaps(this);
	    String currValue = (String) value;
	    try {
		PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_MAIN_ACNT_CODE(currValue);
		if (currValue != null) {
		    helper.BAS_MAIN_ACNT_CODE_WHEN_VALIDATE_ITEM( PM_IL_BANK_ACCOUNT_SETUP_BEAN,this);
		}
		COMP_BAS_MAIN_ACNT_CODE.resetValue();
		COMP_UI_M_MAIN_ACNT_DESC.resetValue();
	    } catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	    } finally {try {ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "BAS_MAIN_ACNT_CODE",getErrorMap());
	    } catch (Exception e) {e.printStackTrace();}}
	}
	
	public void BAS_DIVN_CODE_WHEN_VALIDATE_ITEM(FacesContext fc,UIComponent component,Object value){
	    CommonUtils.clearMaps(this);
	    String currValue = (String) value;
	    try {
		if (currValue != null) {
		    PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_DIVN_CODE(currValue);
		    helper.BAS_DIVN_CODE_WHEN_VALIDATE_ITEM( PM_IL_BANK_ACCOUNT_SETUP_BEAN );
		    COMP_UI_M_DIVN_DESC.resetValue();
		}
	    } catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	    } finally {try {ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "BAS_DIVN_CODE",getErrorMap());
	    } catch (Exception e) {e.printStackTrace();}}
	}

	public void BAS_DEPT_CODE_WHEN_VALIDATE_ITEM(FacesContext fc,UIComponent component,Object value){
	    CommonUtils.clearMaps(this);
	    String currValue = (String) value;
	    try {
		if (currValue != null) {
		    PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_DEPT_CODE(currValue);
		    helper.BAS_DEPT_CODE_WHEN_VALIDATE_ITEM( PM_IL_BANK_ACCOUNT_SETUP_BEAN );
		    COMP_UI_M_DEPT_DESC.resetValue();
		}
	    } catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	    } finally {try {ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "BAS_DEPT_CODE",getErrorMap());
	    } catch (Exception e) {e.printStackTrace();}}
	}
	
	public void BAS_ANLY_CODE_1_WHEN_VALIDATE_ITEM(FacesContext fc,UIComponent component,Object value){
	    CommonUtils.clearMaps(this);
	    String currValue = (String) value;
	    try {
		if (currValue != null) {
		    PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_ANLY_CODE_1(currValue);
		    helper.BAS_ANLY_CODE1_WHEN_VALIDATE_ITEM( PM_IL_BANK_ACCOUNT_SETUP_BEAN );
		    COMP_UI_M_ANLY_1_DESC.resetValue();
		}
	    } catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	    } finally {try {ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "BAS_ANLY_CODE_1",getErrorMap());
	    } catch (Exception e) {e.printStackTrace();}}
	}
	
	public void BAS_ANLY_CODE_2_WHEN_VALIDATE_ITEM(FacesContext fc,UIComponent component,Object value){
	    CommonUtils.clearMaps(this);
	    String currValue = (String) value;
	    try {
		if (currValue != null) {
		    PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_ANLY_CODE_2(currValue);
		    helper.BAS_ANLY_CODE2_WHEN_VALIDATE_ITEM( PM_IL_BANK_ACCOUNT_SETUP_BEAN );
		    COMP_UI_M_ANLY_2_DESC.resetValue();
		    
		}
	    } catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	    } finally {try {ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "BAS_ANLY_CODE_2",getErrorMap());
	    } catch (Exception e) {e.printStackTrace();}}
	}
	
	public void BAS_ACTY_CODE_1_WHEN_VALIDATE_ITEM(FacesContext fc,UIComponent component,Object value){
	    CommonUtils.clearMaps(this);
	    String currValue = (String) value;
	    try {
		if (currValue != null) {
		    PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_ACTY_CODE_1(currValue);
		    helper.BAS_ACTY_CODE1_WHEN_VALIDATE_ITEM( PM_IL_BANK_ACCOUNT_SETUP_BEAN );
		    COMP_UI_M_ACTY_1_DESC.resetValue();
		}
	    } catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	    } finally {try {ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "BAS_ACTY_CODE_1",getErrorMap());
	    } catch (Exception e) {e.printStackTrace();}}
	}
	
	public void BAS_ACTY_CODE_2_WHEN_VALIDATE_ITEM(FacesContext fc,UIComponent component,Object value){
	    CommonUtils.clearMaps(this);
	    String currValue = (String) value;
	    try {
		if (currValue != null) {
		    PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_ACTY_CODE_2(currValue);
		    helper.BAS_ACTY_CODE2_WHEN_VALIDATE_ITEM( PM_IL_BANK_ACCOUNT_SETUP_BEAN );
		}
	    } catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	    } finally {try {ErrorHelpUtil.getWarningForProcedure(CommonUtils.getConnection(), "BAS_ACTY_CODE_2",getErrorMap());
	    } catch (Exception e) {e.printStackTrace();}}
	}
	
	public void fireFieldValidation(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}


	/**
	 * Disables all components in PM_IL_BANK_ACCOUNT_SETUP_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_BAS_DIVN_FM_CODE.setDisabled(disabled);
		COMP_BAS_DIVN_TO_CODE.setDisabled(disabled);
		COMP_BAS_DEPT_FM_CODE.setDisabled(disabled);
		COMP_BAS_DEPT_TO_CODE.setDisabled(disabled);
		COMP_BAS_MAX_PAYEE_CHAR.setDisabled(disabled);
		COMP_BAS_CUST_BANK_CODE.setDisabled(disabled);
		COMP_BAS_OUR_BANK_CODE.setDisabled(disabled);
		COMP_BAS_MAIN_ACNT_CODE.setDisabled(disabled);
		COMP_BAS_SUB_ACNT_CODE.setDisabled(disabled);
		COMP_BAS_VALUE_FROM.setDisabled(disabled);
		COMP_BAS_DIVN_CODE.setDisabled(disabled);
		COMP_BAS_DEPT_CODE.setDisabled(disabled);
		COMP_BAS_ANLY_CODE_1.setDisabled(disabled);
		COMP_BAS_ANLY_CODE_2.setDisabled(disabled);
		COMP_BAS_ACTY_CODE_1.setDisabled(disabled);
		COMP_BAS_ACTY_CODE_2.setDisabled(disabled);
		/*COMP_UI_M_DEPT_FM_DESC.setDisabled(disabled);
		COMP_UI_M_DEPT_TO_DESC.setDisabled(disabled);
		COMP_UI_M_CUST_BANK_DESC.setDisabled(disabled);
		COMP_UI_M_OUR_BANK_DESC.setDisabled(disabled);
		COMP_UI_M_MAIN_ACNT_DESC.setDisabled(disabled);
		COMP_UI_M_SUB_ACNT_DESC.setDisabled(disabled);
		COMP_UI_M_DIVN_DESC.setDisabled(disabled);
		COMP_UI_M_DEPT_DESC.setDisabled(disabled);
		COMP_UI_M_ANLY_1_DESC.setDisabled(disabled);
		COMP_UI_M_ANLY_2_DESC.setDisabled(disabled);
		COMP_UI_M_ACTY_1_DESC.setDisabled(disabled);
		COMP_UI_M_ACTY_2_DESC.setDisabled(disabled);*/
		COMP_BAS_VALUE_TO.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_BAS_SETUP_FOR.setDisabled(disabled);
		COMP_BAS_ASSURED_TYPE.setDisabled(disabled);
		COMP_BAS_TXN_TYPE.setDisabled(disabled);

		// Disabling HtmlCommandButton
	//	testButton.setDisabled(disabled);
	//	homeButton.setDisabled(disabled);

	}


	/**
	 * Instantiates all components in PM_IL_BANK_ACCOUNT_SETUP_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_BAS_DIVN_FM_CODE				 = new HtmlInputText();
		COMP_BAS_DIVN_TO_CODE				 = new HtmlInputText();
		COMP_BAS_DEPT_FM_CODE				 = new HtmlInputText();
		COMP_BAS_DEPT_TO_CODE				 = new HtmlInputText();
		COMP_BAS_MAX_PAYEE_CHAR				 = new HtmlInputText();
		COMP_BAS_CUST_BANK_CODE				 = new HtmlInputText();
		COMP_BAS_OUR_BANK_CODE				 = new HtmlInputText();
		COMP_BAS_MAIN_ACNT_CODE				 = new HtmlInputText();
		COMP_BAS_SUB_ACNT_CODE				 = new HtmlInputText();
		COMP_BAS_VALUE_FROM				 = new HtmlInputText();
		COMP_BAS_DIVN_CODE				 = new HtmlInputText();
		COMP_BAS_DEPT_CODE				 = new HtmlInputText();
		COMP_BAS_ANLY_CODE_1				 = new HtmlInputText();
		COMP_BAS_ANLY_CODE_2				 = new HtmlInputText();
		COMP_BAS_ACTY_CODE_1				 = new HtmlInputText();
		COMP_BAS_ACTY_CODE_2				 = new HtmlInputText();
		COMP_UI_M_DEPT_FM_DESC				 = new HtmlInputText();
		COMP_UI_M_DEPT_TO_DESC				 = new HtmlInputText();
		COMP_UI_M_CUST_BANK_DESC			 = new HtmlInputText();
		COMP_UI_M_OUR_BANK_DESC				 = new HtmlInputText();
		COMP_UI_M_MAIN_ACNT_DESC			 = new HtmlInputText();
		COMP_UI_M_SUB_ACNT_DESC				 = new HtmlInputText();
		COMP_UI_M_DIVN_DESC				 = new HtmlInputText();
		COMP_UI_M_DEPT_DESC				 = new HtmlInputText();
		COMP_UI_M_ANLY_1_DESC				 = new HtmlInputText();
		COMP_UI_M_ANLY_2_DESC				 = new HtmlInputText();
		COMP_UI_M_ACTY_1_DESC				 = new HtmlInputText();
		COMP_UI_M_ACTY_2_DESC				 = new HtmlInputText();
		COMP_BAS_VALUE_TO				 = new HtmlInputText();

		// Instantiating HtmlSelectOneMenu
		COMP_BAS_SETUP_FOR				 = new HtmlSelectOneMenu();
		COMP_BAS_ASSURED_TYPE				 = new HtmlSelectOneMenu();
		COMP_BAS_TXN_TYPE				 = new HtmlSelectOneMenu();

		// Instantiating HtmlCommandButton
		testButton					 = new HtmlCommandButton();
		homeButton					 = new HtmlCommandButton();

	}


}
