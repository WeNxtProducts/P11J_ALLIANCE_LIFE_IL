	package com.iii.pel.forms.PILM064_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
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
import com.iii.pel.forms.PILM023.PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS;
import com.iii.pel.forms.PILM023.PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;
import com.vembu.plsql.runtime.functions.MigratingFunctions;

public class PM_MISC_ITEM_SETUP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_MIS_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_MIS_FRZ_FLAG;

	private HtmlOutputLabel COMP_MIS_SRC_BUS_FM_LABEL;

	private HtmlInputText COMP_MIS_SRC_BUS_FM;

	private HtmlOutputLabel COMP_MIS_SRC_BUS_TO_LABEL;

	private HtmlInputText COMP_MIS_SRC_BUS_TO;

	private HtmlOutputLabel COMP_MIS_BUS_FM_CODE_LABEL;

	private HtmlInputText COMP_MIS_BUS_FM_CODE;

	private HtmlOutputLabel COMP_MIS_BUS_TO_CODE_LABEL;

	private HtmlInputText COMP_MIS_BUS_TO_CODE;

	private HtmlOutputLabel COMP_MIS_DIVN_FM_CODE_LABEL;

	private HtmlInputText COMP_MIS_DIVN_FM_CODE;

	private HtmlOutputLabel COMP_MIS_DIVN_TO_CODE_LABEL;

	private HtmlInputText COMP_MIS_DIVN_TO_CODE;

	private HtmlOutputLabel COMP_MIS_DEPT_FM_CODE_LABEL;

	private HtmlInputText COMP_MIS_DEPT_FM_CODE;

	private HtmlOutputLabel COMP_MIS_DEPT_TO_CODE_LABEL;

	private HtmlInputText COMP_MIS_DEPT_TO_CODE;

	private HtmlOutputLabel COMP_MIS_DOC_FM_TYPE_LABEL;

	private HtmlInputText COMP_MIS_DOC_FM_TYPE;

	private HtmlOutputLabel COMP_MIS_DOC_TO_TYPE_LABEL;

	private HtmlInputText COMP_MIS_DOC_TO_TYPE;

	private HtmlOutputLabel COMP_MIS_SETUP_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_MIS_SETUP_TYPE;

	private HtmlOutputLabel COMP_MIS_SETUP_FOR_LABEL;

	private HtmlSelectOneMenu COMP_MIS_SETUP_FOR;

	private HtmlOutputLabel COMP_MIS_PROD_CODE_FM_LABEL;

	private HtmlInputText COMP_MIS_PROD_CODE_FM;

	private HtmlOutputLabel COMP_MIS_PROD_CODE_TO_LABEL;

	private HtmlInputText COMP_MIS_PROD_CODE_TO;

	private HtmlOutputLabel COMP_MIS_COVER_CODE_FM_LABEL;

	private HtmlInputText COMP_MIS_COVER_CODE_FM;

	private HtmlOutputLabel COMP_MIS_COVER_CODE_TO_LABEL;

	private HtmlInputText COMP_MIS_COVER_CODE_TO;

	private HtmlOutputLabel COMP_MIS_ASSURED_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_MIS_ASSURED_TYPE;

	private HtmlOutputLabel COMP_MIS_TYPE_FM_CODE_LABEL;

	private HtmlInputText COMP_MIS_TYPE_FM_CODE;

	private HtmlOutputLabel COMP_MIS_TYPE_TO_CODE_LABEL;

	private HtmlInputText COMP_MIS_TYPE_TO_CODE;

	private HtmlOutputLabel COMP_MIS_YRS_FM_LABEL;

	private HtmlInputText COMP_MIS_YRS_FM;

	private HtmlOutputLabel COMP_MIS_YRS_TO_LABEL;

	private HtmlInputText COMP_MIS_YRS_TO;

	private HtmlOutputLabel COMP_MIS_FORCE_DIVN_YN_LABEL;

	private HtmlSelectOneMenu COMP_MIS_FORCE_DIVN_YN;

	private HtmlOutputLabel COMP_MIS_FORCE_DEPT_YN_LABEL;

	private HtmlSelectOneMenu COMP_MIS_FORCE_DEPT_YN;

	private HtmlOutputLabel COMP_MIS_MAIN_ACNT_CODE_LABEL;

	private HtmlInputText COMP_MIS_MAIN_ACNT_CODE;

	private HtmlOutputLabel COMP_UI_M_MAIN_ACNT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_MAIN_ACNT_NAME;

	private HtmlOutputLabel COMP_MIS_SUB_ACNT_CODE_LABEL;

	private HtmlInputText COMP_MIS_SUB_ACNT_CODE;

	private HtmlOutputLabel COMP_UI_M_SUB_ACNT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_SUB_ACNT_NAME;

	private HtmlOutputLabel COMP_MIS_DIVN_CODE_LABEL;

	private HtmlInputText COMP_MIS_DIVN_CODE;

	private HtmlOutputLabel COMP_UI_M_DIVN_NAME_LABEL;

	private HtmlInputText COMP_UI_M_DIVN_NAME;

	private HtmlOutputLabel COMP_MIS_DEPT_CODE_LABEL;

	private HtmlInputText COMP_MIS_DEPT_CODE;

	private HtmlOutputLabel COMP_UI_M_DEPT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_DEPT_NAME;

	private HtmlOutputLabel COMP_MIS_ANLY_CODE_1_LABEL;

	private HtmlInputText COMP_MIS_ANLY_CODE_1;

	private HtmlOutputLabel COMP_UI_M_ANLY_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ANLY_NAME;

	private HtmlOutputLabel COMP_MIS_ANLY_CODE_2_LABEL;

	private HtmlInputText COMP_MIS_ANLY_CODE_2;

	private HtmlOutputLabel COMP_UI_M_ANLY_NAME_1_LABEL;

	private HtmlInputText COMP_UI_M_ANLY_NAME_1;

	private HtmlOutputLabel COMP_MIS_ACTY_CODE_1_LABEL;

	private HtmlInputText COMP_MIS_ACTY_CODE_1;

	private HtmlOutputLabel COMP_UI_M_ACTY_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ACTY_NAME;

	private HtmlOutputLabel COMP_MIS_ACTY_CODE_2_LABEL;

	private HtmlInputText COMP_MIS_ACTY_CODE_2;

	private HtmlOutputLabel COMP_UI_M_ACTY_NAME_1_LABEL;

	private HtmlInputText COMP_UI_M_ACTY_NAME_1;

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

	private PM_MISC_ITEM_SETUP PM_MISC_ITEM_SETUP_BEAN;

	public PILM064_APAC_COMPOSITE_ACTION compositeAction;

	private PM_MISC_ITEM_SETUP_HELPER helper;

	private List<SelectItem> listMIS_SETUP_TYPE = new ArrayList<SelectItem>();

	private List<SelectItem> listMIS_SETUP_FOR = new ArrayList<SelectItem>();

	private List<SelectItem> listMIS_ASSURED_TYPE = new ArrayList<SelectItem>();

	private List<SelectItem> listMIS_FORCE_DIVN_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listMIS_FORCE_DEPT_YN = new ArrayList<SelectItem>();

	public PM_MISC_ITEM_SETUP_ACTION() {

		PM_MISC_ITEM_SETUP_BEAN = new PM_MISC_ITEM_SETUP();
		helper = new PM_MISC_ITEM_SETUP_HELPER();
		prepareDropDowns();
	}

	public void prepareDropDowns(){
		try {
			Connection connection = CommonUtils.getConnection();
			setListMIS_SETUP_TYPE(ListItemUtil.getDropDownListValue_1(
					connection, "PILM064_APAC", "PM_MISC_ITEM_SETUP",
					"PM_MISC_ITEM_SETUP.MIS_SETUP_TYPE", null));
			setListMIS_SETUP_FOR(ListItemUtil.getDropDownListValue_1(
					connection, "PILM064_APAC", "PM_MISC_ITEM_SETUP",
					"PM_MISC_ITEM_SETUP.MIS_SETUP_FOR", null));
			setListMIS_ASSURED_TYPE(ListItemUtil.getDropDownListValue_1(
					connection, "PILM064_APAC", "PM_MISC_ITEM_SETUP",
					"PM_MISC_ITEM_SETUP.MIS_ASSURED_TYPE", null));
			setListMIS_FORCE_DIVN_YN(ListItemUtil.getDropDownListValue_1(
					connection, "PILM064_APAC", "PM_MISC_ITEM_SETUP",
					"PM_MISC_ITEM_SETUP.MIS_FORCE_DIVN_YN", null));
			setListMIS_FORCE_DEPT_YN(ListItemUtil.getDropDownListValue_1(
					connection, "PILM064_APAC", "PM_MISC_ITEM_SETUP",
					"PM_MISC_ITEM_SETUP.MIS_FORCE_DEPT_YN", null));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public HtmlOutputLabel getCOMP_MIS_FRZ_FLAG_LABEL() {
		return COMP_MIS_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_MIS_FRZ_FLAG() {
		return COMP_MIS_FRZ_FLAG;
	}

	public void setCOMP_MIS_FRZ_FLAG_LABEL(
			HtmlOutputLabel COMP_MIS_FRZ_FLAG_LABEL) {
		this.COMP_MIS_FRZ_FLAG_LABEL = COMP_MIS_FRZ_FLAG_LABEL;
	}

	public void setCOMP_MIS_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_MIS_FRZ_FLAG) {
		this.COMP_MIS_FRZ_FLAG = COMP_MIS_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_MIS_SRC_BUS_FM_LABEL() {
		return COMP_MIS_SRC_BUS_FM_LABEL;
	}

	public HtmlInputText getCOMP_MIS_SRC_BUS_FM() {
		return COMP_MIS_SRC_BUS_FM;
	}

	public void setCOMP_MIS_SRC_BUS_FM_LABEL(
			HtmlOutputLabel COMP_MIS_SRC_BUS_FM_LABEL) {
		this.COMP_MIS_SRC_BUS_FM_LABEL = COMP_MIS_SRC_BUS_FM_LABEL;
	}

	public void setCOMP_MIS_SRC_BUS_FM(HtmlInputText COMP_MIS_SRC_BUS_FM) {
		this.COMP_MIS_SRC_BUS_FM = COMP_MIS_SRC_BUS_FM;
	}

	public HtmlOutputLabel getCOMP_MIS_SRC_BUS_TO_LABEL() {
		return COMP_MIS_SRC_BUS_TO_LABEL;
	}

	public HtmlInputText getCOMP_MIS_SRC_BUS_TO() {
		return COMP_MIS_SRC_BUS_TO;
	}

	public void setCOMP_MIS_SRC_BUS_TO_LABEL(
			HtmlOutputLabel COMP_MIS_SRC_BUS_TO_LABEL) {
		this.COMP_MIS_SRC_BUS_TO_LABEL = COMP_MIS_SRC_BUS_TO_LABEL;
	}

	public void setCOMP_MIS_SRC_BUS_TO(HtmlInputText COMP_MIS_SRC_BUS_TO) {
		this.COMP_MIS_SRC_BUS_TO = COMP_MIS_SRC_BUS_TO;
	}

	public HtmlOutputLabel getCOMP_MIS_BUS_FM_CODE_LABEL() {
		return COMP_MIS_BUS_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_MIS_BUS_FM_CODE() {
		return COMP_MIS_BUS_FM_CODE;
	}

	public void setCOMP_MIS_BUS_FM_CODE_LABEL(
			HtmlOutputLabel COMP_MIS_BUS_FM_CODE_LABEL) {
		this.COMP_MIS_BUS_FM_CODE_LABEL = COMP_MIS_BUS_FM_CODE_LABEL;
	}

	public void setCOMP_MIS_BUS_FM_CODE(HtmlInputText COMP_MIS_BUS_FM_CODE) {
		this.COMP_MIS_BUS_FM_CODE = COMP_MIS_BUS_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_MIS_BUS_TO_CODE_LABEL() {
		return COMP_MIS_BUS_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_MIS_BUS_TO_CODE() {
		return COMP_MIS_BUS_TO_CODE;
	}

	public void setCOMP_MIS_BUS_TO_CODE_LABEL(
			HtmlOutputLabel COMP_MIS_BUS_TO_CODE_LABEL) {
		this.COMP_MIS_BUS_TO_CODE_LABEL = COMP_MIS_BUS_TO_CODE_LABEL;
	}

	public void setCOMP_MIS_BUS_TO_CODE(HtmlInputText COMP_MIS_BUS_TO_CODE) {
		this.COMP_MIS_BUS_TO_CODE = COMP_MIS_BUS_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_MIS_DIVN_FM_CODE_LABEL() {
		return COMP_MIS_DIVN_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_MIS_DIVN_FM_CODE() {
		return COMP_MIS_DIVN_FM_CODE;
	}

	public void setCOMP_MIS_DIVN_FM_CODE_LABEL(
			HtmlOutputLabel COMP_MIS_DIVN_FM_CODE_LABEL) {
		this.COMP_MIS_DIVN_FM_CODE_LABEL = COMP_MIS_DIVN_FM_CODE_LABEL;
	}

	public void setCOMP_MIS_DIVN_FM_CODE(HtmlInputText COMP_MIS_DIVN_FM_CODE) {
		this.COMP_MIS_DIVN_FM_CODE = COMP_MIS_DIVN_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_MIS_DIVN_TO_CODE_LABEL() {
		return COMP_MIS_DIVN_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_MIS_DIVN_TO_CODE() {
		return COMP_MIS_DIVN_TO_CODE;
	}

	public void setCOMP_MIS_DIVN_TO_CODE_LABEL(
			HtmlOutputLabel COMP_MIS_DIVN_TO_CODE_LABEL) {
		this.COMP_MIS_DIVN_TO_CODE_LABEL = COMP_MIS_DIVN_TO_CODE_LABEL;
	}

	public void setCOMP_MIS_DIVN_TO_CODE(HtmlInputText COMP_MIS_DIVN_TO_CODE) {
		this.COMP_MIS_DIVN_TO_CODE = COMP_MIS_DIVN_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_MIS_DEPT_FM_CODE_LABEL() {
		return COMP_MIS_DEPT_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_MIS_DEPT_FM_CODE() {
		return COMP_MIS_DEPT_FM_CODE;
	}

	public void setCOMP_MIS_DEPT_FM_CODE_LABEL(
			HtmlOutputLabel COMP_MIS_DEPT_FM_CODE_LABEL) {
		this.COMP_MIS_DEPT_FM_CODE_LABEL = COMP_MIS_DEPT_FM_CODE_LABEL;
	}

	public void setCOMP_MIS_DEPT_FM_CODE(HtmlInputText COMP_MIS_DEPT_FM_CODE) {
		this.COMP_MIS_DEPT_FM_CODE = COMP_MIS_DEPT_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_MIS_DEPT_TO_CODE_LABEL() {
		return COMP_MIS_DEPT_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_MIS_DEPT_TO_CODE() {
		return COMP_MIS_DEPT_TO_CODE;
	}

	public void setCOMP_MIS_DEPT_TO_CODE_LABEL(
			HtmlOutputLabel COMP_MIS_DEPT_TO_CODE_LABEL) {
		this.COMP_MIS_DEPT_TO_CODE_LABEL = COMP_MIS_DEPT_TO_CODE_LABEL;
	}

	public void setCOMP_MIS_DEPT_TO_CODE(HtmlInputText COMP_MIS_DEPT_TO_CODE) {
		this.COMP_MIS_DEPT_TO_CODE = COMP_MIS_DEPT_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_MIS_DOC_FM_TYPE_LABEL() {
		return COMP_MIS_DOC_FM_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_MIS_DOC_FM_TYPE() {
		return COMP_MIS_DOC_FM_TYPE;
	}

	public void setCOMP_MIS_DOC_FM_TYPE_LABEL(
			HtmlOutputLabel COMP_MIS_DOC_FM_TYPE_LABEL) {
		this.COMP_MIS_DOC_FM_TYPE_LABEL = COMP_MIS_DOC_FM_TYPE_LABEL;
	}

	public void setCOMP_MIS_DOC_FM_TYPE(HtmlInputText COMP_MIS_DOC_FM_TYPE) {
		this.COMP_MIS_DOC_FM_TYPE = COMP_MIS_DOC_FM_TYPE;
	}

	public HtmlOutputLabel getCOMP_MIS_DOC_TO_TYPE_LABEL() {
		return COMP_MIS_DOC_TO_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_MIS_DOC_TO_TYPE() {
		return COMP_MIS_DOC_TO_TYPE;
	}

	public void setCOMP_MIS_DOC_TO_TYPE_LABEL(
			HtmlOutputLabel COMP_MIS_DOC_TO_TYPE_LABEL) {
		this.COMP_MIS_DOC_TO_TYPE_LABEL = COMP_MIS_DOC_TO_TYPE_LABEL;
	}

	public void setCOMP_MIS_DOC_TO_TYPE(HtmlInputText COMP_MIS_DOC_TO_TYPE) {
		this.COMP_MIS_DOC_TO_TYPE = COMP_MIS_DOC_TO_TYPE;
	}

	public HtmlOutputLabel getCOMP_MIS_SETUP_TYPE_LABEL() {
		return COMP_MIS_SETUP_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_MIS_SETUP_TYPE() {
		return COMP_MIS_SETUP_TYPE;
	}

	public void setCOMP_MIS_SETUP_TYPE_LABEL(
			HtmlOutputLabel COMP_MIS_SETUP_TYPE_LABEL) {
		this.COMP_MIS_SETUP_TYPE_LABEL = COMP_MIS_SETUP_TYPE_LABEL;
	}

	public void setCOMP_MIS_SETUP_TYPE(HtmlSelectOneMenu COMP_MIS_SETUP_TYPE) {
		this.COMP_MIS_SETUP_TYPE = COMP_MIS_SETUP_TYPE;
	}

	public HtmlOutputLabel getCOMP_MIS_SETUP_FOR_LABEL() {
		return COMP_MIS_SETUP_FOR_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_MIS_SETUP_FOR() {
		return COMP_MIS_SETUP_FOR;
	}

	public void setCOMP_MIS_SETUP_FOR_LABEL(
			HtmlOutputLabel COMP_MIS_SETUP_FOR_LABEL) {
		this.COMP_MIS_SETUP_FOR_LABEL = COMP_MIS_SETUP_FOR_LABEL;
	}

	public void setCOMP_MIS_SETUP_FOR(HtmlSelectOneMenu COMP_MIS_SETUP_FOR) {
		this.COMP_MIS_SETUP_FOR = COMP_MIS_SETUP_FOR;
	}

	public HtmlOutputLabel getCOMP_MIS_PROD_CODE_FM_LABEL() {
		return COMP_MIS_PROD_CODE_FM_LABEL;
	}

	public HtmlInputText getCOMP_MIS_PROD_CODE_FM() {
		return COMP_MIS_PROD_CODE_FM;
	}

	public void setCOMP_MIS_PROD_CODE_FM_LABEL(
			HtmlOutputLabel COMP_MIS_PROD_CODE_FM_LABEL) {
		this.COMP_MIS_PROD_CODE_FM_LABEL = COMP_MIS_PROD_CODE_FM_LABEL;
	}

	public void setCOMP_MIS_PROD_CODE_FM(HtmlInputText COMP_MIS_PROD_CODE_FM) {
		this.COMP_MIS_PROD_CODE_FM = COMP_MIS_PROD_CODE_FM;
	}

	public HtmlOutputLabel getCOMP_MIS_PROD_CODE_TO_LABEL() {
		return COMP_MIS_PROD_CODE_TO_LABEL;
	}

	public HtmlInputText getCOMP_MIS_PROD_CODE_TO() {
		return COMP_MIS_PROD_CODE_TO;
	}

	public void setCOMP_MIS_PROD_CODE_TO_LABEL(
			HtmlOutputLabel COMP_MIS_PROD_CODE_TO_LABEL) {
		this.COMP_MIS_PROD_CODE_TO_LABEL = COMP_MIS_PROD_CODE_TO_LABEL;
	}

	public void setCOMP_MIS_PROD_CODE_TO(HtmlInputText COMP_MIS_PROD_CODE_TO) {
		this.COMP_MIS_PROD_CODE_TO = COMP_MIS_PROD_CODE_TO;
	}

	public HtmlOutputLabel getCOMP_MIS_COVER_CODE_FM_LABEL() {
		return COMP_MIS_COVER_CODE_FM_LABEL;
	}

	public HtmlInputText getCOMP_MIS_COVER_CODE_FM() {
		return COMP_MIS_COVER_CODE_FM;
	}

	public void setCOMP_MIS_COVER_CODE_FM_LABEL(
			HtmlOutputLabel COMP_MIS_COVER_CODE_FM_LABEL) {
		this.COMP_MIS_COVER_CODE_FM_LABEL = COMP_MIS_COVER_CODE_FM_LABEL;
	}

	public void setCOMP_MIS_COVER_CODE_FM(HtmlInputText COMP_MIS_COVER_CODE_FM) {
		this.COMP_MIS_COVER_CODE_FM = COMP_MIS_COVER_CODE_FM;
	}

	public HtmlOutputLabel getCOMP_MIS_COVER_CODE_TO_LABEL() {
		return COMP_MIS_COVER_CODE_TO_LABEL;
	}

	public HtmlInputText getCOMP_MIS_COVER_CODE_TO() {
		return COMP_MIS_COVER_CODE_TO;
	}

	public void setCOMP_MIS_COVER_CODE_TO_LABEL(
			HtmlOutputLabel COMP_MIS_COVER_CODE_TO_LABEL) {
		this.COMP_MIS_COVER_CODE_TO_LABEL = COMP_MIS_COVER_CODE_TO_LABEL;
	}

	public void setCOMP_MIS_COVER_CODE_TO(HtmlInputText COMP_MIS_COVER_CODE_TO) {
		this.COMP_MIS_COVER_CODE_TO = COMP_MIS_COVER_CODE_TO;
	}

	public HtmlOutputLabel getCOMP_MIS_ASSURED_TYPE_LABEL() {
		return COMP_MIS_ASSURED_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_MIS_ASSURED_TYPE() {
		return COMP_MIS_ASSURED_TYPE;
	}

	public void setCOMP_MIS_ASSURED_TYPE_LABEL(
			HtmlOutputLabel COMP_MIS_ASSURED_TYPE_LABEL) {
		this.COMP_MIS_ASSURED_TYPE_LABEL = COMP_MIS_ASSURED_TYPE_LABEL;
	}

	public void setCOMP_MIS_ASSURED_TYPE(HtmlSelectOneMenu COMP_MIS_ASSURED_TYPE) {
		this.COMP_MIS_ASSURED_TYPE = COMP_MIS_ASSURED_TYPE;
	}

	public HtmlOutputLabel getCOMP_MIS_TYPE_FM_CODE_LABEL() {
		return COMP_MIS_TYPE_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_MIS_TYPE_FM_CODE() {
		return COMP_MIS_TYPE_FM_CODE;
	}

	public void setCOMP_MIS_TYPE_FM_CODE_LABEL(
			HtmlOutputLabel COMP_MIS_TYPE_FM_CODE_LABEL) {
		this.COMP_MIS_TYPE_FM_CODE_LABEL = COMP_MIS_TYPE_FM_CODE_LABEL;
	}

	public void setCOMP_MIS_TYPE_FM_CODE(HtmlInputText COMP_MIS_TYPE_FM_CODE) {
		this.COMP_MIS_TYPE_FM_CODE = COMP_MIS_TYPE_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_MIS_TYPE_TO_CODE_LABEL() {
		return COMP_MIS_TYPE_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_MIS_TYPE_TO_CODE() {
		return COMP_MIS_TYPE_TO_CODE;
	}

	public void setCOMP_MIS_TYPE_TO_CODE_LABEL(
			HtmlOutputLabel COMP_MIS_TYPE_TO_CODE_LABEL) {
		this.COMP_MIS_TYPE_TO_CODE_LABEL = COMP_MIS_TYPE_TO_CODE_LABEL;
	}

	public void setCOMP_MIS_TYPE_TO_CODE(HtmlInputText COMP_MIS_TYPE_TO_CODE) {
		this.COMP_MIS_TYPE_TO_CODE = COMP_MIS_TYPE_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_MIS_YRS_FM_LABEL() {
		return COMP_MIS_YRS_FM_LABEL;
	}

	public HtmlInputText getCOMP_MIS_YRS_FM() {
		return COMP_MIS_YRS_FM;
	}

	public void setCOMP_MIS_YRS_FM_LABEL(HtmlOutputLabel COMP_MIS_YRS_FM_LABEL) {
		this.COMP_MIS_YRS_FM_LABEL = COMP_MIS_YRS_FM_LABEL;
	}

	public void setCOMP_MIS_YRS_FM(HtmlInputText COMP_MIS_YRS_FM) {
		this.COMP_MIS_YRS_FM = COMP_MIS_YRS_FM;
	}

	public HtmlOutputLabel getCOMP_MIS_YRS_TO_LABEL() {
		return COMP_MIS_YRS_TO_LABEL;
	}

	public HtmlInputText getCOMP_MIS_YRS_TO() {
		return COMP_MIS_YRS_TO;
	}

	public void setCOMP_MIS_YRS_TO_LABEL(HtmlOutputLabel COMP_MIS_YRS_TO_LABEL) {
		this.COMP_MIS_YRS_TO_LABEL = COMP_MIS_YRS_TO_LABEL;
	}

	public void setCOMP_MIS_YRS_TO(HtmlInputText COMP_MIS_YRS_TO) {
		this.COMP_MIS_YRS_TO = COMP_MIS_YRS_TO;
	}

	public HtmlOutputLabel getCOMP_MIS_FORCE_DIVN_YN_LABEL() {
		return COMP_MIS_FORCE_DIVN_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_MIS_FORCE_DIVN_YN() {
		return COMP_MIS_FORCE_DIVN_YN;
	}

	public void setCOMP_MIS_FORCE_DIVN_YN_LABEL(
			HtmlOutputLabel COMP_MIS_FORCE_DIVN_YN_LABEL) {
		this.COMP_MIS_FORCE_DIVN_YN_LABEL = COMP_MIS_FORCE_DIVN_YN_LABEL;
	}

	public void setCOMP_MIS_FORCE_DIVN_YN(
			HtmlSelectOneMenu COMP_MIS_FORCE_DIVN_YN) {
		this.COMP_MIS_FORCE_DIVN_YN = COMP_MIS_FORCE_DIVN_YN;
	}

	public HtmlOutputLabel getCOMP_MIS_FORCE_DEPT_YN_LABEL() {
		return COMP_MIS_FORCE_DEPT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_MIS_FORCE_DEPT_YN() {
		return COMP_MIS_FORCE_DEPT_YN;
	}

	public void setCOMP_MIS_FORCE_DEPT_YN_LABEL(
			HtmlOutputLabel COMP_MIS_FORCE_DEPT_YN_LABEL) {
		this.COMP_MIS_FORCE_DEPT_YN_LABEL = COMP_MIS_FORCE_DEPT_YN_LABEL;
	}

	public void setCOMP_MIS_FORCE_DEPT_YN(
			HtmlSelectOneMenu COMP_MIS_FORCE_DEPT_YN) {
		this.COMP_MIS_FORCE_DEPT_YN = COMP_MIS_FORCE_DEPT_YN;
	}

	public HtmlOutputLabel getCOMP_MIS_MAIN_ACNT_CODE_LABEL() {
		return COMP_MIS_MAIN_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_MIS_MAIN_ACNT_CODE() {
		return COMP_MIS_MAIN_ACNT_CODE;
	}

	public void setCOMP_MIS_MAIN_ACNT_CODE_LABEL(
			HtmlOutputLabel COMP_MIS_MAIN_ACNT_CODE_LABEL) {
		this.COMP_MIS_MAIN_ACNT_CODE_LABEL = COMP_MIS_MAIN_ACNT_CODE_LABEL;
	}

	public void setCOMP_MIS_MAIN_ACNT_CODE(HtmlInputText COMP_MIS_MAIN_ACNT_CODE) {
		this.COMP_MIS_MAIN_ACNT_CODE = COMP_MIS_MAIN_ACNT_CODE;
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

	public HtmlOutputLabel getCOMP_MIS_SUB_ACNT_CODE_LABEL() {
		return COMP_MIS_SUB_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_MIS_SUB_ACNT_CODE() {
		return COMP_MIS_SUB_ACNT_CODE;
	}

	public void setCOMP_MIS_SUB_ACNT_CODE_LABEL(
			HtmlOutputLabel COMP_MIS_SUB_ACNT_CODE_LABEL) {
		this.COMP_MIS_SUB_ACNT_CODE_LABEL = COMP_MIS_SUB_ACNT_CODE_LABEL;
	}

	public void setCOMP_MIS_SUB_ACNT_CODE(HtmlInputText COMP_MIS_SUB_ACNT_CODE) {
		this.COMP_MIS_SUB_ACNT_CODE = COMP_MIS_SUB_ACNT_CODE;
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

	public HtmlOutputLabel getCOMP_MIS_DIVN_CODE_LABEL() {
		return COMP_MIS_DIVN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_MIS_DIVN_CODE() {
		return COMP_MIS_DIVN_CODE;
	}

	public void setCOMP_MIS_DIVN_CODE_LABEL(
			HtmlOutputLabel COMP_MIS_DIVN_CODE_LABEL) {
		this.COMP_MIS_DIVN_CODE_LABEL = COMP_MIS_DIVN_CODE_LABEL;
	}

	public void setCOMP_MIS_DIVN_CODE(HtmlInputText COMP_MIS_DIVN_CODE) {
		this.COMP_MIS_DIVN_CODE = COMP_MIS_DIVN_CODE;
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

	public HtmlOutputLabel getCOMP_MIS_DEPT_CODE_LABEL() {
		return COMP_MIS_DEPT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_MIS_DEPT_CODE() {
		return COMP_MIS_DEPT_CODE;
	}

	public void setCOMP_MIS_DEPT_CODE_LABEL(
			HtmlOutputLabel COMP_MIS_DEPT_CODE_LABEL) {
		this.COMP_MIS_DEPT_CODE_LABEL = COMP_MIS_DEPT_CODE_LABEL;
	}

	public void setCOMP_MIS_DEPT_CODE(HtmlInputText COMP_MIS_DEPT_CODE) {
		this.COMP_MIS_DEPT_CODE = COMP_MIS_DEPT_CODE;
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

	public HtmlOutputLabel getCOMP_MIS_ANLY_CODE_1_LABEL() {
		return COMP_MIS_ANLY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_MIS_ANLY_CODE_1() {
		return COMP_MIS_ANLY_CODE_1;
	}

	public void setCOMP_MIS_ANLY_CODE_1_LABEL(
			HtmlOutputLabel COMP_MIS_ANLY_CODE_1_LABEL) {
		this.COMP_MIS_ANLY_CODE_1_LABEL = COMP_MIS_ANLY_CODE_1_LABEL;
	}

	public void setCOMP_MIS_ANLY_CODE_1(HtmlInputText COMP_MIS_ANLY_CODE_1) {
		this.COMP_MIS_ANLY_CODE_1 = COMP_MIS_ANLY_CODE_1;
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

	public HtmlOutputLabel getCOMP_MIS_ANLY_CODE_2_LABEL() {
		return COMP_MIS_ANLY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_MIS_ANLY_CODE_2() {
		return COMP_MIS_ANLY_CODE_2;
	}

	public void setCOMP_MIS_ANLY_CODE_2_LABEL(
			HtmlOutputLabel COMP_MIS_ANLY_CODE_2_LABEL) {
		this.COMP_MIS_ANLY_CODE_2_LABEL = COMP_MIS_ANLY_CODE_2_LABEL;
	}

	public void setCOMP_MIS_ANLY_CODE_2(HtmlInputText COMP_MIS_ANLY_CODE_2) {
		this.COMP_MIS_ANLY_CODE_2 = COMP_MIS_ANLY_CODE_2;
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

	public HtmlOutputLabel getCOMP_MIS_ACTY_CODE_1_LABEL() {
		return COMP_MIS_ACTY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_MIS_ACTY_CODE_1() {
		return COMP_MIS_ACTY_CODE_1;
	}

	public void setCOMP_MIS_ACTY_CODE_1_LABEL(
			HtmlOutputLabel COMP_MIS_ACTY_CODE_1_LABEL) {
		this.COMP_MIS_ACTY_CODE_1_LABEL = COMP_MIS_ACTY_CODE_1_LABEL;
	}

	public void setCOMP_MIS_ACTY_CODE_1(HtmlInputText COMP_MIS_ACTY_CODE_1) {
		this.COMP_MIS_ACTY_CODE_1 = COMP_MIS_ACTY_CODE_1;
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

	public HtmlOutputLabel getCOMP_MIS_ACTY_CODE_2_LABEL() {
		return COMP_MIS_ACTY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_MIS_ACTY_CODE_2() {
		return COMP_MIS_ACTY_CODE_2;
	}

	public void setCOMP_MIS_ACTY_CODE_2_LABEL(
			HtmlOutputLabel COMP_MIS_ACTY_CODE_2_LABEL) {
		this.COMP_MIS_ACTY_CODE_2_LABEL = COMP_MIS_ACTY_CODE_2_LABEL;
	}

	public void setCOMP_MIS_ACTY_CODE_2(HtmlInputText COMP_MIS_ACTY_CODE_2) {
		this.COMP_MIS_ACTY_CODE_2 = COMP_MIS_ACTY_CODE_2;
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

	public PM_MISC_ITEM_SETUP getPM_MISC_ITEM_SETUP_BEAN() {
		return PM_MISC_ITEM_SETUP_BEAN;
	}

	public void setPM_MISC_ITEM_SETUP_BEAN(
			PM_MISC_ITEM_SETUP PM_MISC_ITEM_SETUP_BEAN) {
		this.PM_MISC_ITEM_SETUP_BEAN = PM_MISC_ITEM_SETUP_BEAN;
	}

	/*public void validateMIS_FRZ_FLAG(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		try {
			if ((Boolean) value) {
				PM_MISC_ITEM_SETUP_BEAN
						.setMIS_FRZ_FLAG(PELConstants.CHECKBOX_CHECKED);
			} else {
				PM_MISC_ITEM_SETUP_BEAN
						.setMIS_FRZ_FLAG(PELConstants.CHECKBOX_UNCHECKED);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}*/
	public String backToSearch() {
    	return SearchConstants.BACK_TO_SEARCH_PAGE;
    }

	public void saveRecord(){
		String message = "";
		try{
			CommonUtils.clearMaps(this);
		if(getPM_MISC_ITEM_SETUP_BEAN().getROWID() == null){
				if(isINSERT_ALLOWED()){
					helper.preInsert(PM_MISC_ITEM_SETUP_BEAN);
				
				/*if(getPM_MISC_ITEM_SETUP_BEAN().isFRZ_FLAG()==false)
				{
					getPM_MISC_ITEM_SETUP_BEAN().setCACS_FRZ_FLAG("N");
				}else{
					getPM_MISC_ITEM_SETUP_BEAN().setCACS_FRZ_FLAG("Y");
				}*/
				new CRUDHandler().executeInsert(getPM_MISC_ITEM_SETUP_BEAN(),CommonUtils.getConnection());
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
					helper.preUpdate(PM_MISC_ITEM_SETUP_BEAN);
				/*if(getPM_MISC_ITEM_SETUP_BEAN().isFRZ_FLAG()==false)
				{
					getPM_MISC_ITEM_SETUP_BEAN().setCACS_FRZ_FLAG("N");
				}else{
					getPM_MISC_ITEM_SETUP_BEAN().setCACS_FRZ_FLAG("Y");
				}*/
				new CRUDHandler().executeInsert(getPM_MISC_ITEM_SETUP_BEAN(),
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

	public String getFreezeValue(){
		String freeze_Value = "N";
		if(PM_MISC_ITEM_SETUP_BEAN.isMIS_FRZ_FLAG_VALUE()){
			freeze_Value = "Y";
		}
	return freeze_Value;
	}
	
		public void validateMIS_FRZ_FLAG(FacesContext fc, UIComponent component,
				Object value) throws ValidatorException, Exception {
			try {
				if ((Boolean) value) {
					PM_MISC_ITEM_SETUP_BEAN
							.setMIS_FRZ_FLAG(PELConstants.CHECKBOX_CHECKED);
				} else {
					PM_MISC_ITEM_SETUP_BEAN
							.setMIS_FRZ_FLAG(PELConstants.CHECKBOX_UNCHECKED);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}

	public static final String z_Constant = "zzzzzzzzzz";
	public static final Integer int_Constant = 9999;

	public List<SelectItem> getListMIS_SETUP_TYPE() {
		if (listMIS_SETUP_TYPE.size() == 0) {
			listMIS_SETUP_TYPE.clear();
			try {
				listMIS_SETUP_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listMIS_SETUP_TYPE;
	}

	public void setListMIS_SETUP_TYPE(List<SelectItem> listMIS_SETUP_TYPE) {
		this.listMIS_SETUP_TYPE = listMIS_SETUP_TYPE;
	}

	public List<SelectItem> getListMIS_SETUP_FOR() {
		if (listMIS_SETUP_FOR.size() == 0) {
			listMIS_SETUP_FOR.clear();
			try {
				listMIS_SETUP_FOR = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listMIS_SETUP_FOR;
	}

	public void setListMIS_SETUP_FOR(List<SelectItem> listMIS_SETUP_FOR) {
		this.listMIS_SETUP_FOR = listMIS_SETUP_FOR;
	}

	public List<SelectItem> getListMIS_ASSURED_TYPE() {
		if (listMIS_ASSURED_TYPE.size() == 0) {
			listMIS_ASSURED_TYPE.clear();
			try {
				listMIS_ASSURED_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listMIS_ASSURED_TYPE;
	}

	public void setListMIS_ASSURED_TYPE(List<SelectItem> listMIS_ASSURED_TYPE) {
		this.listMIS_ASSURED_TYPE = listMIS_ASSURED_TYPE;
	}

	public List<SelectItem> getListMIS_FORCE_DIVN_YN() {
		if (listMIS_FORCE_DIVN_YN.size() == 0) {
			listMIS_FORCE_DIVN_YN.clear();
			try {
				listMIS_FORCE_DIVN_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listMIS_FORCE_DIVN_YN;
	}

	public void setListMIS_FORCE_DIVN_YN(List<SelectItem> listMIS_FORCE_DIVN_YN) {
		this.listMIS_FORCE_DIVN_YN = listMIS_FORCE_DIVN_YN;
	}

	public List<SelectItem> getListMIS_FORCE_DEPT_YN() {
		if (listMIS_FORCE_DEPT_YN.size() == 0) {
			listMIS_FORCE_DEPT_YN.clear();
			try {
				listMIS_FORCE_DEPT_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listMIS_FORCE_DEPT_YN;
	}

	public void setListMIS_FORCE_DEPT_YN(List<SelectItem> listMIS_FORCE_DEPT_YN) {
		this.listMIS_FORCE_DEPT_YN = listMIS_FORCE_DEPT_YN;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		PM_MISC_ITEM_SETUP_DELEGATE delegate = new PM_MISC_ITEM_SETUP_DELEGATE();
		try {
			if (isBlockFlag()) {
				delegate.executeSelectStatement(compositeAction);
				//L_SET_SUB_ACCOUNT
				if(PM_MISC_ITEM_SETUP_BEAN.getROWID() != null){
					helper.postQuery(this);
				}else{
					helper.whenCreateRecord(this);
				}
				helper.whenNewRecordInstance(this);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public void actionListenerMIS_SRC_BUS_FM(ActionEvent actionEvent) {

		try {
			UIInput Input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) Input.getSubmittedValue();
			System.out.println("Input Value: " + inputValue);
			if (inputValue.isEmpty()) {
				getCOMP_MIS_SRC_BUS_FM().setSubmittedValue("0");
				PM_MISC_ITEM_SETUP_BEAN.setMIS_SRC_BUS_FM("0");
			} else {
				PM_MISC_ITEM_SETUP_BEAN.setMIS_SRC_BUS_FM(inputValue);
			}
			ErrorHelpUtil.validate(Input, getErrorMap());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void actionListenerMIS_SRC_BUS_TO(ActionEvent actionEvent) {
		try {
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) input.getSubmittedValue();
			String misSrcBusFm = PM_MISC_ITEM_SETUP_BEAN.getMIS_SRC_BUS_FM();
			if (inputValue.isEmpty()) {
				if (misSrcBusFm.equals("0")) {
					getCOMP_MIS_SRC_BUS_TO().setSubmittedValue(z_Constant);
					PM_MISC_ITEM_SETUP_BEAN.setMIS_SRC_BUS_TO(z_Constant);
				} else {
					getCOMP_MIS_SRC_BUS_TO().setSubmittedValue(misSrcBusFm);
					PM_MISC_ITEM_SETUP_BEAN.setMIS_SRC_BUS_TO(misSrcBusFm);
				}
			} else if (inputValue.compareTo(misSrcBusFm) > 0) {
				getCOMP_MIS_SRC_BUS_TO().setSubmittedValue(inputValue);
				PM_MISC_ITEM_SETUP_BEAN.setMIS_SRC_BUS_TO(inputValue);
			} else {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"Enter Greater value than From ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}

	public void validateMIS_SRC_BUS_TO(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_MISC_ITEM_SETUP_BEAN.setMIS_SRC_BUS_TO((String) value);
		String P_FROM_CODE = PM_MISC_ITEM_SETUP_BEAN.getMIS_SRC_BUS_FM();
		String P_TO_CODE = PM_MISC_ITEM_SETUP_BEAN.getMIS_SRC_BUS_TO();
		try {
			if (!z_Constant.equals(value)) {
				helper.L_VAL_FROM_TO(P_FROM_CODE, P_TO_CODE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}

	public void actionListenerMIS_BUS_FM_CODE(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput htmlInputText = (UIInput) actionEvent.getComponent()
					.getParent();
			String inputValue = (String) htmlInputText.getSubmittedValue();
			if (inputValue.isEmpty()) {
				getCOMP_MIS_BUS_FM_CODE().setSubmittedValue("0");
				PM_MISC_ITEM_SETUP_BEAN.setMIS_BUS_FM_CODE("0");
			} else {
				PM_MISC_ITEM_SETUP_BEAN.setMIS_BUS_FM_CODE(inputValue);
				ErrorHelpUtil.validate(htmlInputText, getErrorMap());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}

	public void actionListenerMIS_BUS_TO_CODE(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) input.getSubmittedValue();
			if (inputValue.isEmpty()) {
				String misBusFmCode = PM_MISC_ITEM_SETUP_BEAN
						.getMIS_BUS_FM_CODE();
				if (!misBusFmCode.trim().equals("0")) {
					getCOMP_MIS_BUS_TO_CODE().setSubmittedValue(misBusFmCode);
					PM_MISC_ITEM_SETUP_BEAN.setMIS_BUS_TO_CODE(misBusFmCode);
				} else {
					getCOMP_MIS_BUS_TO_CODE().setSubmittedValue(z_Constant);
					PM_MISC_ITEM_SETUP_BEAN.setMIS_BUS_TO_CODE(z_Constant);
				}
			} else {
				getCOMP_MIS_BUS_TO_CODE().setSubmittedValue(inputValue);
				PM_MISC_ITEM_SETUP_BEAN.setMIS_BUS_TO_CODE(inputValue);
				ErrorHelpUtil.validate(input, getErrorMap());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}

	public void validateMIS_BUS_TO_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_MISC_ITEM_SETUP_BEAN.setMIS_SRC_BUS_TO((String) value);
		String P_FROM_CODE = PM_MISC_ITEM_SETUP_BEAN.getMIS_BUS_FM_CODE();
		String P_TO_CODE = PM_MISC_ITEM_SETUP_BEAN.getMIS_BUS_TO_CODE();
		try {
			if (!z_Constant.equals(value)) {
				helper.L_VAL_FROM_TO(P_FROM_CODE, P_TO_CODE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void actionListenerMIS_DIVN_FM_CODE(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput htmlInputText = (UIInput) actionEvent.getComponent()
					.getParent();
			String inputValue = (String) htmlInputText.getSubmittedValue();
			if (inputValue.isEmpty()) {
				getCOMP_MIS_DIVN_FM_CODE().setSubmittedValue("0");
				PM_MISC_ITEM_SETUP_BEAN.setMIS_DIVN_FM_CODE("0");
			} else {
				PM_MISC_ITEM_SETUP_BEAN.setMIS_DIVN_FM_CODE(inputValue);
				ErrorHelpUtil.validate(htmlInputText, getErrorMap());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}

	public void actionListenerMIS_DIVN_TO_CODE(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) input.getSubmittedValue();
			if (inputValue.isEmpty()) {
				String misDivnFmCode = PM_MISC_ITEM_SETUP_BEAN
						.getMIS_DIVN_FM_CODE();
				if (!misDivnFmCode.trim().equals("0")) {
					getCOMP_MIS_DIVN_TO_CODE().setSubmittedValue(misDivnFmCode);
					PM_MISC_ITEM_SETUP_BEAN.setMIS_DIVN_TO_CODE(misDivnFmCode);
				} else {
					getCOMP_MIS_DIVN_TO_CODE().setSubmittedValue(z_Constant);
					PM_MISC_ITEM_SETUP_BEAN.setMIS_DIVN_TO_CODE(z_Constant);
				}
			} else {
				PM_MISC_ITEM_SETUP_BEAN.setMIS_DIVN_TO_CODE(inputValue);
				ErrorHelpUtil.validate(input, getErrorMap());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}

	public void validateMIS_DIVN_TO_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_MISC_ITEM_SETUP_BEAN.setMIS_SRC_BUS_TO((String) value);
		String P_FROM_CODE = PM_MISC_ITEM_SETUP_BEAN.getMIS_DIVN_FM_CODE();
		String P_TO_CODE = PM_MISC_ITEM_SETUP_BEAN.getMIS_DIVN_TO_CODE();
		try {
			if (!z_Constant.equals(value)) {
				helper.L_VAL_FROM_TO(P_FROM_CODE, P_TO_CODE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void actionListenerMIS_DEPT_FM_CODE(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput htmlInputText = (UIInput) actionEvent.getComponent()
					.getParent();
			String inputValue = (String) htmlInputText.getSubmittedValue();
			if (inputValue.isEmpty()) {
				getCOMP_MIS_DEPT_FM_CODE().setSubmittedValue("0");
				PM_MISC_ITEM_SETUP_BEAN.setMIS_DEPT_FM_CODE("0");
			} else {
				PM_MISC_ITEM_SETUP_BEAN.setMIS_DEPT_FM_CODE(inputValue);
				ErrorHelpUtil.validate(htmlInputText, getErrorMap());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}

	public void actionListenerMIS_DEPT_TO_CODE(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) input.getSubmittedValue();
			if (inputValue.isEmpty()) {
				String misDeptFmCode = PM_MISC_ITEM_SETUP_BEAN
						.getMIS_DEPT_FM_CODE();
				if (!misDeptFmCode.trim().equals("0")) {
					getCOMP_MIS_DEPT_TO_CODE().setSubmittedValue(misDeptFmCode);
					PM_MISC_ITEM_SETUP_BEAN.setMIS_DEPT_TO_CODE(misDeptFmCode);
				} else {
					getCOMP_MIS_DEPT_TO_CODE().setSubmittedValue(z_Constant);
					PM_MISC_ITEM_SETUP_BEAN.setMIS_DEPT_TO_CODE(z_Constant);
				}
			} else {
				PM_MISC_ITEM_SETUP_BEAN.setMIS_DEPT_TO_CODE(inputValue);
				ErrorHelpUtil.validate(input, getErrorMap());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}

	public void validateMIS_DEPT_TO_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_MISC_ITEM_SETUP_BEAN.setMIS_SRC_BUS_TO((String) value);
		String P_FROM_CODE = PM_MISC_ITEM_SETUP_BEAN.getMIS_DEPT_FM_CODE();
		String P_TO_CODE = PM_MISC_ITEM_SETUP_BEAN.getMIS_DEPT_TO_CODE();
		try {
			if (!z_Constant.equals(value)) {
				helper.L_VAL_FROM_TO(P_FROM_CODE, P_TO_CODE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}

	public void actionListenerMIS_DOC_FM_TYPE(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput htmlInputText = (UIInput) actionEvent.getComponent()
					.getParent();
			String inputValue = (String) htmlInputText.getSubmittedValue();

			if (inputValue.isEmpty()) {
				getCOMP_MIS_DOC_FM_TYPE().setSubmittedValue("0");
				PM_MISC_ITEM_SETUP_BEAN.setMIS_DOC_FM_TYPE("0");
			} else {
				PM_MISC_ITEM_SETUP_BEAN.setMIS_DOC_FM_TYPE(inputValue);
				ErrorHelpUtil.validate(htmlInputText, getErrorMap());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}

	public void actionListenerMIS_DOC_TO_TYPE(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) input.getSubmittedValue();
			if (inputValue.isEmpty()) {
				String misDocFmType = PM_MISC_ITEM_SETUP_BEAN
						.getMIS_DOC_FM_TYPE();
				if (!misDocFmType.trim().equals("0")) {
					getCOMP_MIS_DOC_TO_TYPE().setSubmittedValue(misDocFmType);
					PM_MISC_ITEM_SETUP_BEAN.setMIS_DOC_TO_TYPE(misDocFmType);
				} else {
					getCOMP_MIS_DOC_TO_TYPE().setSubmittedValue(z_Constant);
					PM_MISC_ITEM_SETUP_BEAN.setMIS_DOC_TO_TYPE(z_Constant);
				}
			} else {
				PM_MISC_ITEM_SETUP_BEAN.setMIS_DOC_TO_TYPE(inputValue);
				ErrorHelpUtil.validate(input, getErrorMap());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}

	public void validateMIS_DOC_TO_TYPE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_MISC_ITEM_SETUP_BEAN.setMIS_SRC_BUS_TO((String) value);
		String P_FROM_CODE = PM_MISC_ITEM_SETUP_BEAN.getMIS_DOC_FM_TYPE();
		String P_TO_CODE = PM_MISC_ITEM_SETUP_BEAN.getMIS_DOC_TO_TYPE();
		try {
			if (!z_Constant.equals(value)) {
				helper.L_VAL_FROM_TO(P_FROM_CODE, P_TO_CODE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}

	public void validateMIS_SETUP_TYPE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_MISC_ITEM_SETUP_BEAN.setMIS_SETUP_TYPE((String) value);
		try {
			helper.whenValidateMIS_Setup_Type(this);
			COMP_MIS_SETUP_FOR.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}

	public void actionListenerMIS_Setup_Type(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) input.getSubmittedValue();
			PM_MISC_ITEM_SETUP_BEAN.setMIS_SETUP_TYPE((String) inputValue);
			helper.whenValidateMIS_Setup_TypeOnChange(this);
			ErrorHelpUtil.validate(input, getErrorMap());
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
		}
	}

	public void validateMIS_SETUP_FOR(FacesContext context,
			UIComponent component, Object value) {

		PM_MISC_ITEM_SETUP_BEAN.setMIS_SETUP_FOR((String) value);
		try {
			if (PM_MISC_ITEM_SETUP_BEAN.getMIS_SETUP_FOR().isEmpty()) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91022"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}

	public void actionListenerMIS_PROD_CODE_FM(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput htmlInputText = (UIInput) actionEvent.getComponent()
					.getParent();
			String inputValue = (String) htmlInputText.getSubmittedValue();

			if (inputValue.isEmpty()) {
				getCOMP_MIS_PROD_CODE_FM().setSubmittedValue("0");
				PM_MISC_ITEM_SETUP_BEAN.setMIS_PROD_CODE_FM("0");
			} else {
				PM_MISC_ITEM_SETUP_BEAN.setMIS_PROD_CODE_FM(inputValue);
				ErrorHelpUtil.validate(htmlInputText, getErrorMap());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}

	/*public void validateMIS_COVER_CODE_TO(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_MISC_ITEM_SETUP_BEAN.setMIS_PROD_CODE_FM((String) value);
		String P_FROM_CODE = PM_MISC_ITEM_SETUP_BEAN.getMIS_COVER_CODE_FM();
		String P_TO_CODE = PM_MISC_ITEM_SETUP_BEAN.getMIS_COVER_CODE_TO();
		try {
			if (!z_Constant.equals(value)) {
				helper.L_VAL_FROM_TO(P_FROM_CODE, P_TO_CODE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
*/
	public void actionListenerMIS_PROD_CODE_TO(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) input.getSubmittedValue();
			if (inputValue.isEmpty()) {
				String misProdFmType = PM_MISC_ITEM_SETUP_BEAN
						.getMIS_PROD_CODE_FM();
				if (!misProdFmType.trim().equals("0")) {
					getCOMP_MIS_PROD_CODE_TO().setSubmittedValue(misProdFmType);
					PM_MISC_ITEM_SETUP_BEAN.setMIS_PROD_CODE_TO(misProdFmType);
				} else {
					getCOMP_MIS_PROD_CODE_TO().setSubmittedValue(z_Constant);
					PM_MISC_ITEM_SETUP_BEAN.setMIS_PROD_CODE_TO(z_Constant);
				}
			} else {
				PM_MISC_ITEM_SETUP_BEAN.setMIS_PROD_CODE_TO(inputValue);
				ErrorHelpUtil.validate(input, getErrorMap());
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new ValidatorException(new FacesMessage(exc.getMessage()));

		}
	}

	public void validateMIS_PROD_CODE_TO(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_MISC_ITEM_SETUP_BEAN.setMIS_PROD_CODE_TO((String) value);
		String P_FROM_CODE = PM_MISC_ITEM_SETUP_BEAN.getMIS_PROD_CODE_FM();
		String P_TO_CODE = PM_MISC_ITEM_SETUP_BEAN.getMIS_PROD_CODE_TO();
		try {
			if (!z_Constant.equals(value)) {
				helper.L_VAL_FROM_TO(P_FROM_CODE, P_TO_CODE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void actionListenerMIS_COVER_CODE_FM(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput htmlInputText = (UIInput) actionEvent.getComponent()
					.getParent();
			String inputValue = (String) htmlInputText.getSubmittedValue();

			if (inputValue.isEmpty()) {
				getCOMP_MIS_COVER_CODE_FM().setSubmittedValue("0");
				PM_MISC_ITEM_SETUP_BEAN.setMIS_COVER_CODE_FM("0");
			} else {
				PM_MISC_ITEM_SETUP_BEAN.setMIS_COVER_CODE_FM(inputValue);
				ErrorHelpUtil.validate(htmlInputText, getErrorMap());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}

	public void validateMIS_COVER_CODE_FM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_MISC_ITEM_SETUP_BEAN.setMIS_COVER_CODE_FM((String) value);
		String P_FROM_CODE = PM_MISC_ITEM_SETUP_BEAN.getMIS_COVER_CODE_FM();
		String P_TO_CODE = PM_MISC_ITEM_SETUP_BEAN.getMIS_COVER_CODE_TO();
		try {
			if (!"0".equals(PM_MISC_ITEM_SETUP_BEAN.getMIS_COVER_CODE_FM())) {
				helper.L_VAL_FROM_TO(P_FROM_CODE, P_TO_CODE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void actionListenerMIS_COVER_CODE_TO(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) input.getSubmittedValue();
			if (inputValue.isEmpty()) {
				String misCoverFm = PM_MISC_ITEM_SETUP_BEAN
						.getMIS_COVER_CODE_FM();
				if (!misCoverFm.trim().equals("0")) {
					getCOMP_MIS_COVER_CODE_TO().setSubmittedValue(misCoverFm);
					PM_MISC_ITEM_SETUP_BEAN.setMIS_COVER_CODE_TO(misCoverFm);
				} else {
					getCOMP_MIS_COVER_CODE_TO().setSubmittedValue(z_Constant);
					PM_MISC_ITEM_SETUP_BEAN.setMIS_COVER_CODE_TO(z_Constant);
				}
			} else {
				PM_MISC_ITEM_SETUP_BEAN.setMIS_COVER_CODE_TO(inputValue);
				ErrorHelpUtil.validate(input, getErrorMap());
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new ValidatorException(new FacesMessage(exc.getMessage()));

		}
	}

	public void validateMIS_COVER_CODE_TO(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_MISC_ITEM_SETUP_BEAN.setMIS_COVER_CODE_TO((String) value);
		String P_FROM_CODE = PM_MISC_ITEM_SETUP_BEAN.getMIS_COVER_CODE_FM();
		String P_TO_CODE = PM_MISC_ITEM_SETUP_BEAN.getMIS_COVER_CODE_TO();
		try {
			if (!z_Constant.equals(value)) {
				helper.L_VAL_FROM_TO(P_FROM_CODE, P_TO_CODE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateMIS_ASSURED_TYPE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_MISC_ITEM_SETUP_BEAN.setMIS_ASSURED_TYPE((String) value);
		try {
			if (PM_MISC_ITEM_SETUP_BEAN.getMIS_ASSURED_TYPE().isEmpty()) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91022"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateMIS_TYPE_FM_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PM_MISC_ITEM_SETUP_BEAN.setMIS_TYPE_FM_CODE((String) value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateMIS_TYPE_TO_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		PM_MISC_ITEM_SETUP_BEAN.setMIS_TYPE_TO_CODE((String) value);
		try {
			if (PM_MISC_ITEM_SETUP_BEAN.getMIS_TYPE_TO_CODE() != null) {
				helper.L_VAL_FROM_TO(PM_MISC_ITEM_SETUP_BEAN
						.getMIS_TYPE_FM_CODE(), PM_MISC_ITEM_SETUP_BEAN
						.getMIS_TYPE_TO_CODE());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void actionListenerMIS_YRS_FM(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput htmlInputText = (UIInput) actionEvent.getComponent()
					.getParent();
			String inputValue = (String) htmlInputText.getSubmittedValue();

			if (inputValue.isEmpty()) {
				getCOMP_MIS_YRS_FM().setSubmittedValue("0");
				PM_MISC_ITEM_SETUP_BEAN.setMIS_YRS_FM(0);
			} else {
				PM_MISC_ITEM_SETUP_BEAN.setMIS_YRS_FM(Integer
						.parseInt(inputValue));
				ErrorHelpUtil.validate(htmlInputText, getErrorMap());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}

	public void validateMIS_YRS_FM(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try {
			PM_MISC_ITEM_SETUP_BEAN.setMIS_YRS_FM((Integer) value);
			if (PM_MISC_ITEM_SETUP_BEAN.getMIS_YRS_FM() < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91018"));
			}
			if (PM_MISC_ITEM_SETUP_BEAN.getMIS_YRS_FM() > PM_MISC_ITEM_SETUP_BEAN
					.getMIS_YRS_TO()) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91031"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void actionListenerMIS_YRS_TO(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) input.getSubmittedValue();
			if (inputValue.isEmpty()|| inputValue==null) {
				Integer misYrsFm = PM_MISC_ITEM_SETUP_BEAN.getMIS_YRS_FM();
				if (misYrsFm != 0) {
					getCOMP_MIS_YRS_TO().setSubmittedValue(misYrsFm.toString());
					PM_MISC_ITEM_SETUP_BEAN.setMIS_YRS_TO(misYrsFm);
				} else {
					getCOMP_MIS_YRS_TO().setSubmittedValue(int_Constant.toString());
					PM_MISC_ITEM_SETUP_BEAN.setMIS_YRS_TO(int_Constant);
				}
			} else {
				PM_MISC_ITEM_SETUP_BEAN.setMIS_YRS_TO(Integer
						.parseInt(inputValue));
				ErrorHelpUtil.validate(input, getErrorMap());
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new ValidatorException(new FacesMessage(exc.getMessage()));

		}
	}

	public void validateMIS_YRS_TO(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

		PM_MISC_ITEM_SETUP_BEAN.setMIS_YRS_TO((Integer)value);
		try {
			if (!int_Constant.equals(value)) {
				if (PM_MISC_ITEM_SETUP_BEAN.getMIS_YRS_TO() < 0) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91018"));
				}
				if (PM_MISC_ITEM_SETUP_BEAN.getMIS_YRS_TO() < PM_MISC_ITEM_SETUP_BEAN
						.getMIS_YRS_FM()) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91032"));
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateMIS_FORCE_DIVN_YN(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try{
			PM_MISC_ITEM_SETUP_BEAN.setMIS_FORCE_DIVN_YN((String)value);
			helper.whenValidateMIS_FORCE_DIVN_YN(this);
		}
		 catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}

		}
	
	public void validateMIS_FORCE_DEPT_YN(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try{
			PM_MISC_ITEM_SETUP_BEAN.setMIS_FORCE_DEPT_YN((String)value);
			helper.whenValidateMIS_FORCE_DEPT_YN(this);
		}
		 catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}

		}
	public void validateMIS_MAIN_ACNT_CODE(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try{
			PM_MISC_ITEM_SETUP_BEAN.setMIS_MAIN_ACNT_CODE((String)value);
			helper.whenValidateMIS_MAIN_ACNT_CODE(this);
			COMP_UI_M_MAIN_ACNT_NAME.resetValue();
			COMP_MIS_SUB_ACNT_CODE.resetValue();
			COMP_UI_M_SUB_ACNT_NAME.resetValue();
			COMP_MIS_ACTY_CODE_1.resetValue();
			COMP_UI_M_ACTY_NAME.resetValue();
			COMP_MIS_ACTY_CODE_2.resetValue();
			COMP_UI_M_ACTY_NAME_1.resetValue();
		}
		 catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}

		}
	public void validateMIS_SUB_ACNT_CODE(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try{
			PM_MISC_ITEM_SETUP_BEAN.setMIS_SUB_ACNT_CODE((String)value);
			helper.whenValidateMIS_SUB_ACNT_CODE(this);
		}
		 catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}

		}
	public void validateMIS_DIVN_CODE(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try{
			PM_MISC_ITEM_SETUP_BEAN.setMIS_DIVN_CODE((String)value);
			helper.whenValidateMIS_DIVN_CODE(this);
		}
		 catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}

		}
	public void validateMIS_DEPT_CODE(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try{
			PM_MISC_ITEM_SETUP_BEAN.setMIS_DEPT_CODE((String)value);
			helper.whenValidateMIS_DEPT_CODE(this);
			helper.whenNewItemInstanceMIS_DEPT_CODE(this);
		}
		 catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}

		}
	public void validateMIS_ANLY_CODE_1(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try{
			PM_MISC_ITEM_SETUP_BEAN.setMIS_ANLY_CODE_1((String)value);
			helper.whenValidateMIS_ANLY_CODE_1(this);
		}
		 catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}

		}	
	public void ValidateMIS_ANLY_CODE_2(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try{
			PM_MISC_ITEM_SETUP_BEAN.setMIS_ANLY_CODE_2((String)value);
			helper.whenValidateMIS_ANLY_CODE_2(this);
			helper.whenNewItemInstanceMIS_ANLY_CODE_2(this);
		}
		 catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}

		}
	public void validateMIS_ACTY_CODE_1(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try{
			PM_MISC_ITEM_SETUP_BEAN.setMIS_ACTY_CODE_1((String)value);
			helper.whenValidateMIS_ACTY_CODE_1(this);
		}
		 catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}

		}	
	public void ValidateMIS_ACTY_CODE_2(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try{
			PM_MISC_ITEM_SETUP_BEAN.setMIS_ACTY_CODE_2((String)value);
			helper.whenValidateMIS_ACTY_CODE_2(this);
		}
		 catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}

		}
	
	
	public List<LovBean> lovMIS_SRC_BUS_FM(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM064_APAC",
					"PM_MISC_ITEM_SETUP", "MIS_SRC_BUS_FM",
					"SRC_BUS_TY", null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovMIS_SRC_BUS_TO(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM064_APAC",
					"PM_MISC_ITEM_SETUP", "MIS_SRC_BUS_TO",
					"SRC_BUS_TY", null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public List<LovBean> lovMIS_BUS_FM_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM064_APAC",
					"PM_MISC_ITEM_SETUP", "MIS_BUS_FM_CODE",
					"IL_BUSINES", null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public List<LovBean> lovMIS_BUS_TO_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM064_APAC",
					"PM_MISC_ITEM_SETUP", "MIS_BUS_TO_CODE",
					"IL_BUSINES", null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public List<LovBean> lovMIS_DIVN_FM_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM064_APAC",
					"PM_MISC_ITEM_SETUP", "MIS_DIVN_FM_CODE",
					CommonUtils.getControlBean().getM_COMP_CODE(), null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public List<LovBean> lovMIS_DIVN_TO_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM064_APAC",
					"PM_MISC_ITEM_SETUP", "MIS_DIVN_TO_CODE",
					CommonUtils.getControlBean().getM_COMP_CODE(), null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public List<LovBean> lovMIS_DEPT_FM_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM064_APAC",
					"PM_MISC_ITEM_SETUP", "MIS_DEPT_FM_CODE",
					CommonUtils.getControlBean().getM_COMP_CODE(),PM_MISC_ITEM_SETUP_BEAN.getMIS_DIVN_FM_CODE(),
					null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public List<LovBean> lovMIS_DEPT_TO_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM064_APAC",
					"PM_MISC_ITEM_SETUP","MIS_DEPT_TO_CODE",
					CommonUtils.getControlBean().getM_COMP_CODE(),PM_MISC_ITEM_SETUP_BEAN.getMIS_DIVN_TO_CODE(),
					null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public List<LovBean> lovMIS_DOC_FM_TYPE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM064_APAC",
					"PM_MISC_ITEM_SETUP", "MIS_DOC_FM_TYPE",
					"2", null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
		
	public List<LovBean> lovMIS_DOC_TO_TYPE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM064_APAC",
					"PM_MISC_ITEM_SETUP", "MIS_DOC_TO_TYPE",
					"2", null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public List<LovBean> lovMIS_PROD_CODE_FM(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM064_APAC",
					"PM_MISC_ITEM_SETUP", "MIS_PROD_CODE_FM",
					null, null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public List<LovBean> lovMIS_PROD_CODE_TO(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM064_APAC",
					"PM_MISC_ITEM_SETUP", "MIS_PROD_CODE_TO",
					null, null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public List<LovBean> lovMIS_COVER_CODE_FM(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM064_APAC",
					"PM_MISC_ITEM_SETUP", "MIS_COVER_CODE_FM",
					"A", "S", "B",
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public List<LovBean> lovMIS_COVER_CODE_TO(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM064_APAC",
					"PM_MISC_ITEM_SETUP", "MIS_COVER_CODE_TO",
					"A", "S", "B",
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovMIS_TYPE_FM_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		String M_TYPE =null;
		String M_PS_DESC =null;
		String M_PS_VALUE =null;
		ArrayList<String> list = new ArrayList<String>();
		try {
/*			suggestionList = listitemutil.P_CALL_LOV("PILM064_APAC",
					"PM_MISC_ITEM_SETUP", "MIS_DOC_TO_TYPE",
					"2", null, null,
					null, null, (String) currValue);*/
			

			   if("D".equals(PM_MISC_ITEM_SETUP_BEAN.getMIS_SETUP_TYPE())){
			      M_TYPE = "IL_DEF_DIS";
			   }
			   else if("C".equals(PM_MISC_ITEM_SETUP_BEAN.getMIS_SETUP_TYPE())) {
				   M_TYPE = "IL_DEF_CHG";
			   }
			   else if("B".equals(PM_MISC_ITEM_SETUP_BEAN.getMIS_SETUP_TYPE())) {
				   M_TYPE = "COMM_TAX";
			   }
			   else if("T".equals(PM_MISC_ITEM_SETUP_BEAN.getMIS_SETUP_TYPE())) {
			      M_TYPE = "COMM_TAX";
			   }
			   else if("MF".equals(PM_MISC_ITEM_SETUP_BEAN.getMIS_SETUP_TYPE())) {
			      M_TYPE = "IL_MED_EXM";
			   }
			   /**
			    * CHECK BROKER CALC METHOD
			    * IF THE BROKER CALC METHOD INDICATES AGENCY MODULE THEN THE LOV SHOULD BE FROM 
			    * THE AGENCY MODULE
			    */
			   
			   list=new DBProcedures().P_VAL_SYSTEM("IL_BROK_CALC", "IL_BROK_CALC", "E") ;
			   if (list != null && !(list.isEmpty())) {
				   M_PS_DESC=list.get(0);
				   M_PS_VALUE=list.get(1);
				} 
			   if(CommonUtils.isIN(PM_MISC_ITEM_SETUP_BEAN.getMIS_SETUP_TYPE(),"B","O" ) &&
					   ("2".equals(CommonUtils.nvl(M_PS_VALUE,"1")))){
						   //STD_CALL_LOV('PILH005','PM_MISC_ITEM_SETUP.MIS_TYPE_FM_CODE');
				   System.out.println("TEST");
			   }
			else if("FB".equals(CommonUtils.nvl(PM_MISC_ITEM_SETUP_BEAN.getMIS_SETUP_TYPE(),"N"))){
						   //STD_CALL_LOV('PH560_A','PM_MISC_ITEM_SETUP.MIS_TYPE_FM_CODE');
				System.out.println("TEST");		
			}
			else if("AB".equals(CommonUtils.nvl(PM_MISC_ITEM_SETUP_BEAN.getMIS_SETUP_TYPE(),"N"))){		   
			   	    //STD_CALL_LOV('PH571_A','PM_MISC_ITEM_SETUP.MIS_TYPE_FM_CODE');
				System.out.println("TEST");
			}
			   else	{
				   suggestionList = listitemutil.P_CALL_LOV("PILM064_APAC",
							"PM_MISC_ITEM_SETUP", "MIS_TYPE_FM_CODE",
							M_TYPE, null, null,
							null, null, (String) currValue);
			   }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public List<LovBean> lovMIS_TYPE_TO_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		String M_TYPE =null;
		String M_PS_DESC =null;
		String M_PS_VALUE =null;
		ArrayList<String> list = new ArrayList<String>();
		try {
			   if("D".equals(PM_MISC_ITEM_SETUP_BEAN.getMIS_SETUP_TYPE())){
			      M_TYPE = "IL_DEF_DIS";
			   }
			   else if("C".equals(PM_MISC_ITEM_SETUP_BEAN.getMIS_SETUP_TYPE())) {
				   M_TYPE = "IL_DEF_CHG";
			   }
			   else if("B".equals(PM_MISC_ITEM_SETUP_BEAN.getMIS_SETUP_TYPE())) {
				   M_TYPE = "COMM_TAX";
			   }
			   else if("T".equals(PM_MISC_ITEM_SETUP_BEAN.getMIS_SETUP_TYPE())) {
			      M_TYPE = "COMM_TAX";
			   }
			   else if("MF".equals(PM_MISC_ITEM_SETUP_BEAN.getMIS_SETUP_TYPE())) {
			      M_TYPE = "IL_MED_EXM";
			   }
			   /**
			    * CHECK BROKER CALC METHOD
			    * IF THE BROKER CALC METHOD INDICATES AGENCY MODULE THEN THE LOV SHOULD BE FROM 
			    * THE AGENCY MODULE
			    */
			   
			   list=new DBProcedures().P_VAL_SYSTEM("IL_BROK_CALC", "IL_BROK_CALC", "E") ;
			   if (list != null && !(list.isEmpty())) {
				   M_PS_DESC=list.get(0);
				   M_PS_VALUE=list.get(1);
				} 
			   if(CommonUtils.isIN(PM_MISC_ITEM_SETUP_BEAN.getMIS_SETUP_TYPE(),"B","O" ) &&
					   ("2".equals(CommonUtils.nvl(M_PS_VALUE,"1")))){
				   //STD_CALL_LOV('PILH005','PM_MISC_ITEM_SETUP.MIS_TYPE_TO_CODE');
			   }
			else if("FB".equals(CommonUtils.nvl(PM_MISC_ITEM_SETUP_BEAN.getMIS_SETUP_TYPE(),"N"))){
				//STD_CALL_LOV('PH560_A','PM_MISC_ITEM_SETUP.MIS_TYPE_TO_CODE');
					   }
			else if("AB".equals(CommonUtils.nvl(PM_MISC_ITEM_SETUP_BEAN.getMIS_SETUP_TYPE(),"N"))){		   
				//STD_CALL_LOV('PH571_A','PM_MISC_ITEM_SETUP.MIS_TYPE_TO_CODE');
			}
			   else	{
				   suggestionList = listitemutil.P_CALL_LOV("PILM064_APAC",
							"PM_MISC_ITEM_SETUP", "MIS_TYPE_TO_CODE",
							M_TYPE, null, null,
							null, null, (String) currValue);
			   }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public List<LovBean> lovMIS_MAIN_ACNT_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM064_APAC",
					"PM_MISC_ITEM_SETUP", "MIS_MAIN_ACNT_CODE",null,null,null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public List<LovBean> lovMIS_SUB_ACNT_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM064_APAC",
					"PM_MISC_ITEM_SETUP", "MIS_SUB_ACNT_CODE",
					PM_MISC_ITEM_SETUP_BEAN.getMIS_MAIN_ACNT_CODE(),null, null, 
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public List<LovBean> lovMIS_DIVN_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM064_APAC",
					"PM_MISC_ITEM_SETUP", "MIS_DIVN_CODE",
					CommonUtils.getControlBean().getM_COMP_CODE(), null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public List<LovBean> lovMIS_DEPT_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM064_APAC",
					"PM_MISC_ITEM_SETUP", "MIS_DEPT_CODE",
					CommonUtils.getControlBean().getM_COMP_CODE(),PM_MISC_ITEM_SETUP_BEAN.getMIS_DIVN_CODE(),
					null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public List<LovBean> lovMIS_ANLY_CODE_1(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM064_APAC",
					"PM_MISC_ITEM_SETUP", "MIS_ANLY_CODE_1",
					"1",null, null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

    
    
	public List<LovBean> lovMIS_ANLY_CODE_2(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM064_APAC",
					"PM_MISC_ITEM_SETUP", "MIS_ANLY_CODE_2",
					"2",null, null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public List<LovBean> lovMIS_ACTY_CODE_1(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM064_APAC",
					"PM_MISC_ITEM_SETUP", "MIS_ACTY_CODE_1",
					PM_MISC_ITEM_SETUP_BEAN.getUI_M_ACTY_1(),null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public List<LovBean> lovMIS_ACTY_CODE_2(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM064_APAC",
					"PM_MISC_ITEM_SETUP", "MIS_ACTY_CODE_2",
					PM_MISC_ITEM_SETUP_BEAN.getUI_M_ACTY_2(),null, null, 
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public List preparemisTypeCodeFmList(String misTypeCodeFm,
			List misTypeCodeFmList,PM_MISC_ITEM_SETUP PM_MISC_ITEM_SETUP_BEAN)
			throws Exception {

		String query = null;
		String setUpType = PM_MISC_ITEM_SETUP_BEAN.getMIS_SETUP_TYPE();
		System.out.println("setUp Type :" + setUpType);
		String M_TYPE = null;
		String M_PS_DESC = null;
		int M_PS_VALUE = -1;

		if (setUpType != null) {

			if (setUpType.equals("D")) {
				M_TYPE = "IL_DEF_DIS";
			} else if (setUpType.equals("C")) {
				M_TYPE = "IL_CHARGE";
			} else if (setUpType.equals("B")) {
				M_TYPE = "COMMISSION";
			} else if (setUpType.equals("T")) {
				M_TYPE = "TAX";
			} else if (setUpType.equals("MF")) {
				M_TYPE = "IL_MED_EXM";
			}
			System.out.println("M_type" + M_TYPE);
			ArrayList valSystemList = DBProcedures.P_VAL_SYSTEM("IL_BROK_CALC","IL_BROK_CALC",null,"E",null);
			// P_VAL_SYSTEM('IL_BROK_CALC', 'IL_BROK_CALC', M_PS_DESC, 'E',
			// M_PS_VALUE) ;
			if (valSystemList != null && valSystemList.size() != 0) {
				M_PS_DESC = valSystemList.get(0).toString();
				M_PS_VALUE = Integer.parseInt(valSystemList.get(1).toString());
			}
			if (M_PS_VALUE != -1) {
				System.out.println("M_PS_VALUE :" + M_PS_VALUE);
				if (setUpType.equals("B") || setUpType.equals("O")
						&& MigratingFunctions.nvl(M_PS_VALUE, 1) == 2) {
					if ("*".equalsIgnoreCase(misTypeCodeFm)) {
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_TYPE_LOV_PILH005;
						Object[] object = { PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN };
						misTypeCodeFmList = misTypeCodeFmLOV(query, object);
					} else {
						query ="SELECT POL_PROP_NO,TO_CHAR(POL_ISSUE_DT) FROM PT_IL_POLICY WHERE "+
							" NVL(POL_APPRV_STATUS,'N') = 'N' AND POL_NO IS NOT NULL AND POL_DS_TYPE = '1'" +
							" AND POL_PROP_NO LIKE ? AND ROWNUM<? ORDER BY 1 ASC";
			Object[] object = {misTypeCodeFm,
								PM_IL_CODES_ACCOUNT_SETUP_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_ROW_NUM_TO_DIPLAY_LESS_THEN };
				misTypeCodeFmList = misTypeCodeFmLOV(query, object);
					}
				}
				if (setUpType.equals("FB")) {
					// TODO QURIES NOT AVAILABLE
				}
				if (setUpType.equals("AB")) {
					// TODO QURIES NOT AVAILABLE
				} else {
					if ("*".equalsIgnoreCase(misTypeCodeFm)) {
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_TYPE_FM_LOV_PGLH044;
						Object[] object = { M_TYPE, M_TYPE };
						misTypeCodeFmList = misTypeCodeFmLOV(query, object);
					} else {
						query = PM_IL_CODES_ACCOUNT_SETUP_QUERY_CONSTANTS.PILM023_PM_IL_CODES_ACCOUNT_SETUP_CACS_TYPE_FM_LOV_PGLH044_LIKE;
						Object[] object = { misTypeCodeFm, M_TYPE, M_TYPE };
						misTypeCodeFmList = misTypeCodeFmLOV(query, object);
					}
				}

			}
		}
		System.out.println("Query :" + query);
		return misTypeCodeFmList;
	}

	public List<PM_MISC_ITEM_SETUP> misTypeCodeFmLOV(String query,
			Object[] object) {
		List<PM_MISC_ITEM_SETUP> cacsTypeCodeFmList = new ArrayList<PM_MISC_ITEM_SETUP>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();

			resultSet = handler.executeSelectStatement(query, connection,
					object);
			while (resultSet.next()) {
				PM_MISC_ITEM_SETUP PM_MISC_ITEM_SETUP_BEAN = new PM_MISC_ITEM_SETUP();
				PM_MISC_ITEM_SETUP_BEAN.setMIS_TYPE_FM_CODE(resultSet
						.getString(1));
				PM_MISC_ITEM_SETUP_BEAN.setMIS_TYPE_FM_CODE_DESC(resultSet.getString(2));
				cacsTypeCodeFmList.add(PM_MISC_ITEM_SETUP_BEAN);
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
		return cacsTypeCodeFmList;
	}	
}
