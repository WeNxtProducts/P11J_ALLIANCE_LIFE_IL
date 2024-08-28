package com.iii.pel.forms.PILM061_APAC;

import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
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
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_FUND_ACCOUNT_SETUP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_FAS_SRC_BUS_FM_LABEL;

	private HtmlInputText COMP_FAS_SRC_BUS_FM;

	private HtmlOutputLabel COMP_FAS_SRC_BUS_TO_LABEL;

	private HtmlInputText COMP_FAS_SRC_BUS_TO;

	private HtmlOutputLabel COMP_FAS_DIVN_FM_CODE_LABEL;

	private HtmlInputText COMP_FAS_DIVN_FM_CODE;

	private HtmlOutputLabel COMP_FAS_DIVN_TO_CODE_LABEL;

	private HtmlInputText COMP_FAS_DIVN_TO_CODE;

	private HtmlOutputLabel COMP_FAS_DEPT_FM_CODE_LABEL;

	private HtmlInputText COMP_FAS_DEPT_FM_CODE;

	private HtmlOutputLabel COMP_FAS_DEPT_TO_CODE_LABEL;

	private HtmlInputText COMP_FAS_DEPT_TO_CODE;

	private HtmlOutputLabel COMP_FAS_DOC_FM_TYPE_LABEL;

	private HtmlInputText COMP_FAS_DOC_FM_TYPE;

	private HtmlOutputLabel COMP_FAS_DOC_TO_TYPE_LABEL;

	private HtmlInputText COMP_FAS_DOC_TO_TYPE;

	private HtmlOutputLabel COMP_FAS_PROD_CODE_FM_LABEL;

	private HtmlInputText COMP_FAS_PROD_CODE_FM;

	private HtmlOutputLabel COMP_FAS_PROD_CODE_TO_LABEL;

	private HtmlInputText COMP_FAS_PROD_CODE_TO;

	private HtmlOutputLabel COMP_FAS_FUND_CODE_FM_LABEL;

	private HtmlInputText COMP_FAS_FUND_CODE_FM;

	private HtmlOutputLabel COMP_FAS_FUND_CODE_TO_LABEL;

	private HtmlInputText COMP_FAS_FUND_CODE_TO;

	private HtmlOutputLabel COMP_FAS_POL_YR_FM_LABEL;

	private HtmlInputText COMP_FAS_POL_YR_FM;

	private HtmlOutputLabel COMP_FAS_POL_YR_TO_LABEL;

	private HtmlInputText COMP_FAS_POL_YR_TO;

	private HtmlOutputLabel COMP_FAS_SETUP_FOR_LABEL;

	private HtmlSelectOneMenu COMP_FAS_SETUP_FOR;

	private HtmlOutputLabel COMP_FAS_DRCR_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_FAS_DRCR_FLAG;

	private HtmlOutputLabel COMP_FAS_SEQ_NO_LABEL;

	private HtmlInputText COMP_FAS_SEQ_NO;

	private HtmlOutputLabel COMP_FAS_NARRATION_CODE_LABEL;

	private HtmlInputText COMP_FAS_NARRATION_CODE;

	private HtmlOutputLabel COMP_FAS_FORCE_DIVN_YN_LABEL;

	private HtmlSelectOneMenu COMP_FAS_FORCE_DIVN_YN;

	private HtmlOutputLabel COMP_FAS_FORCE_DEPT_YN_LABEL;

	private HtmlSelectOneMenu COMP_FAS_FORCE_DEPT_YN;

	private HtmlOutputLabel COMP_FAS_MAIN_ACNT_CODE_LABEL;

	private HtmlInputText COMP_FAS_MAIN_ACNT_CODE;

	private HtmlOutputLabel COMP_UI_M_MAIN_ACNT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_MAIN_ACNT_NAME;

	private HtmlOutputLabel COMP_FAS_SUB_ACNT_CODE_LABEL;

	private HtmlInputText COMP_FAS_SUB_ACNT_CODE;

	private HtmlOutputLabel COMP_UI_M_SUB_ACNT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_SUB_ACNT_NAME;

	private HtmlOutputLabel COMP_FAS_DIVN_CODE_LABEL;

	private HtmlInputText COMP_FAS_DIVN_CODE;

	private HtmlOutputLabel COMP_UI_M_DIVN_NAME_LABEL;

	private HtmlInputText COMP_UI_M_DIVN_NAME;

	private HtmlOutputLabel COMP_FAS_DEPT_CODE_LABEL;

	private HtmlInputText COMP_FAS_DEPT_CODE;

	private HtmlOutputLabel COMP_UI_M_DEPT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_DEPT_NAME;

	private HtmlOutputLabel COMP_FAS_ANLY_CODE_1_LABEL;

	private HtmlInputText COMP_FAS_ANLY_CODE_1;

	private HtmlOutputLabel COMP_UI_M_ANLY_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ANLY_NAME;

	private HtmlOutputLabel COMP_FAS_ANLY_CODE_2_LABEL;

	private HtmlInputText COMP_FAS_ANLY_CODE_2;

	private HtmlOutputLabel COMP_UI_M_ANLY_NAME_1_LABEL;

	private HtmlInputText COMP_UI_M_ANLY_NAME_1;

	private HtmlOutputLabel COMP_FAS_ACTY_CODE_1_LABEL;

	private HtmlInputText COMP_FAS_ACTY_CODE_1;

	private HtmlOutputLabel COMP_UI_M_ACTY_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ACTY_NAME;

	private HtmlOutputLabel COMP_FAS_ACTY_CODE_2_LABEL;

	private HtmlInputText COMP_FAS_ACTY_CODE_2;

	private HtmlOutputLabel COMP_UI_M_ACTY_NAME_1_LABEL;

	private HtmlInputText COMP_UI_M_ACTY_NAME_1;

	private HtmlOutputLabel COMP_FAS_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_FAS_FRZ_FLAG;

	private HtmlCommandButton COMP_UI_M_FAS_DEPT_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_FAS_ANLY_CODE_1_LOV;

	private HtmlCommandButton COMP_UI_M_FAS_ANLY_CODE_2_LOV;

	private HtmlCommandButton COMP_UI_M_FAS_ACTY_CODE_1_LOV;

	private HtmlCommandButton COMP_UI_M_FAS_ACTY_CODE_2_LOV;

	private HtmlCommandButton COMP_UI_M_FAS_NARRATION_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_SRC_BUS_FM_LOV;

	private HtmlCommandButton COMP_UI_M_SRC_BUS_TO_LOV;

	private HtmlCommandButton COMP_UI_M_FAS_DIVN_FM_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_FAS_DOC_TO_TYPE_LOV;

	private HtmlCommandButton COMP_UI_M_FAS_DIVN_TO_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_FAS_DEPT_FM_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_FAS_DEPT_TO_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_FAS_DOC_FM_TYPE_LOV;

	private HtmlCommandButton COMP_UI_M_FAS_PROD_CODE_FM_LOV;

	private HtmlCommandButton COMP_UI_M_FAS_PROD_CODE_TO_LOV;

	private HtmlCommandButton COMP_UI_M_FAS_FUND_CODE_FM_LOV;

	private HtmlCommandButton COMP_UI_M_FAS_FUND_CODE_TO_LOV;

	private HtmlCommandButton COMP_UI_M_FAS_MAIN_ACNT_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_FAS_SUB_ACNT_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_FAS_DIVN_CODE_LOV;

	private HtmlCommandButton PREFORMBUTTON;

	private PM_IL_FUND_ACCOUNT_SETUP PM_IL_FUND_ACCOUNT_SETUP_BEAN;

	private PM_IL_FUND_ACCOUNT_SETUP_DELEGATE PM_IL_FUND_ACCOUNT_SETUP_DELEGATE_METHOD;

	Map<String, Object> session = null;

	Map<String, Object> attributes;

	private List<SelectItem> listFAS_SETUP_FOR;

	private List<SelectItem> listFAS_DRCR_FLAG;

	private List<SelectItem> listFAS_FORCE_DIVN_YN;

	private List<SelectItem> listFAS_FORCE_DEPT_YN;

	public String COMP_CODE;
	
	PM_IL_FUND_ACCOUNT_SETUP_HELPER helper = new PM_IL_FUND_ACCOUNT_SETUP_HELPER();

	public PM_IL_FUND_ACCOUNT_SETUP_ACTION() throws Exception {
		PM_IL_FUND_ACCOUNT_SETUP_BEAN = new PM_IL_FUND_ACCOUNT_SETUP();
		PM_IL_FUND_ACCOUNT_SETUP_DELEGATE_METHOD = new PM_IL_FUND_ACCOUNT_SETUP_DELEGATE();
		COMP_CODE="00101    01    ".substring(0,3);
		setListFAS_SETUP_FOR(ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILM061_APAC", "PM_IL_FUND_ACCOUNT_SETUP", "PM_IL_FUND_ACCOUNT_SETUP.FAS_SETUP_FOR", "FUND_SETUP"));
		setListFAS_DRCR_FLAG(ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILM061_APAC", "PM_IL_FUND_ACCOUNT_SETUP", "PM_IL_FUND_ACCOUNT_SETUP.FAS_DRCR_FLAG", "DEB_CRE"));
		setListFAS_FORCE_DIVN_YN(ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILM061_APAC", "PM_IL_FUND_ACCOUNT_SETUP", "PM_IL_FUND_ACCOUNT_SETUP.FAS_FORCE_DIVN_YN", "YESNO"));
		setListFAS_FORCE_DEPT_YN(ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILM061_APAC", "PM_IL_FUND_ACCOUNT_SETUP", "PM_IL_FUND_ACCOUNT_SETUP.FAS_FORCE_DEPT_YN", "YESNO"));
	}

	public HtmlOutputLabel getCOMP_FAS_SRC_BUS_FM_LABEL() {
		return COMP_FAS_SRC_BUS_FM_LABEL;
	}

	public HtmlInputText getCOMP_FAS_SRC_BUS_FM() {
		return COMP_FAS_SRC_BUS_FM;
	}

	public void setCOMP_FAS_SRC_BUS_FM_LABEL(HtmlOutputLabel COMP_FAS_SRC_BUS_FM_LABEL) {
		this.COMP_FAS_SRC_BUS_FM_LABEL = COMP_FAS_SRC_BUS_FM_LABEL;
	}

	public void setCOMP_FAS_SRC_BUS_FM(HtmlInputText COMP_FAS_SRC_BUS_FM) {
		this.COMP_FAS_SRC_BUS_FM = COMP_FAS_SRC_BUS_FM;
	}

	public HtmlOutputLabel getCOMP_FAS_SRC_BUS_TO_LABEL() {
		return COMP_FAS_SRC_BUS_TO_LABEL;
	}

	public HtmlInputText getCOMP_FAS_SRC_BUS_TO() {
		return COMP_FAS_SRC_BUS_TO;
	}

	public void setCOMP_FAS_SRC_BUS_TO_LABEL(HtmlOutputLabel COMP_FAS_SRC_BUS_TO_LABEL) {
		this.COMP_FAS_SRC_BUS_TO_LABEL = COMP_FAS_SRC_BUS_TO_LABEL;
	}

	public void setCOMP_FAS_SRC_BUS_TO(HtmlInputText COMP_FAS_SRC_BUS_TO) {
		this.COMP_FAS_SRC_BUS_TO = COMP_FAS_SRC_BUS_TO;
	}

	public HtmlOutputLabel getCOMP_FAS_DIVN_FM_CODE_LABEL() {
		return COMP_FAS_DIVN_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_FAS_DIVN_FM_CODE() {
		return COMP_FAS_DIVN_FM_CODE;
	}

	public void setCOMP_FAS_DIVN_FM_CODE_LABEL(HtmlOutputLabel COMP_FAS_DIVN_FM_CODE_LABEL) {
		this.COMP_FAS_DIVN_FM_CODE_LABEL = COMP_FAS_DIVN_FM_CODE_LABEL;
	}

	public void setCOMP_FAS_DIVN_FM_CODE(HtmlInputText COMP_FAS_DIVN_FM_CODE) {
		this.COMP_FAS_DIVN_FM_CODE = COMP_FAS_DIVN_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_FAS_DIVN_TO_CODE_LABEL() {
		return COMP_FAS_DIVN_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_FAS_DIVN_TO_CODE() {
		return COMP_FAS_DIVN_TO_CODE;
	}

	public void setCOMP_FAS_DIVN_TO_CODE_LABEL(HtmlOutputLabel COMP_FAS_DIVN_TO_CODE_LABEL) {
		this.COMP_FAS_DIVN_TO_CODE_LABEL = COMP_FAS_DIVN_TO_CODE_LABEL;
	}

	public void setCOMP_FAS_DIVN_TO_CODE(HtmlInputText COMP_FAS_DIVN_TO_CODE) {
		this.COMP_FAS_DIVN_TO_CODE = COMP_FAS_DIVN_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_FAS_DEPT_FM_CODE_LABEL() {
		return COMP_FAS_DEPT_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_FAS_DEPT_FM_CODE() {
		return COMP_FAS_DEPT_FM_CODE;
	}

	public void setCOMP_FAS_DEPT_FM_CODE_LABEL(HtmlOutputLabel COMP_FAS_DEPT_FM_CODE_LABEL) {
		this.COMP_FAS_DEPT_FM_CODE_LABEL = COMP_FAS_DEPT_FM_CODE_LABEL;
	}

	public void setCOMP_FAS_DEPT_FM_CODE(HtmlInputText COMP_FAS_DEPT_FM_CODE) {
		this.COMP_FAS_DEPT_FM_CODE = COMP_FAS_DEPT_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_FAS_DEPT_TO_CODE_LABEL() {
		return COMP_FAS_DEPT_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_FAS_DEPT_TO_CODE() {
		return COMP_FAS_DEPT_TO_CODE;
	}

	public void setCOMP_FAS_DEPT_TO_CODE_LABEL(HtmlOutputLabel COMP_FAS_DEPT_TO_CODE_LABEL) {
		this.COMP_FAS_DEPT_TO_CODE_LABEL = COMP_FAS_DEPT_TO_CODE_LABEL;
	}

	public void setCOMP_FAS_DEPT_TO_CODE(HtmlInputText COMP_FAS_DEPT_TO_CODE) {
		this.COMP_FAS_DEPT_TO_CODE = COMP_FAS_DEPT_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_FAS_DOC_FM_TYPE_LABEL() {
		return COMP_FAS_DOC_FM_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_FAS_DOC_FM_TYPE() {
		return COMP_FAS_DOC_FM_TYPE;
	}

	public void setCOMP_FAS_DOC_FM_TYPE_LABEL(HtmlOutputLabel COMP_FAS_DOC_FM_TYPE_LABEL) {
		this.COMP_FAS_DOC_FM_TYPE_LABEL = COMP_FAS_DOC_FM_TYPE_LABEL;
	}

	public void setCOMP_FAS_DOC_FM_TYPE(HtmlInputText COMP_FAS_DOC_FM_TYPE) {
		this.COMP_FAS_DOC_FM_TYPE = COMP_FAS_DOC_FM_TYPE;
	}

	public HtmlOutputLabel getCOMP_FAS_DOC_TO_TYPE_LABEL() {
		return COMP_FAS_DOC_TO_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_FAS_DOC_TO_TYPE() {
		return COMP_FAS_DOC_TO_TYPE;
	}

	public void setCOMP_FAS_DOC_TO_TYPE_LABEL(HtmlOutputLabel COMP_FAS_DOC_TO_TYPE_LABEL) {
		this.COMP_FAS_DOC_TO_TYPE_LABEL = COMP_FAS_DOC_TO_TYPE_LABEL;
	}

	public void setCOMP_FAS_DOC_TO_TYPE(HtmlInputText COMP_FAS_DOC_TO_TYPE) {
		this.COMP_FAS_DOC_TO_TYPE = COMP_FAS_DOC_TO_TYPE;
	}

	public HtmlOutputLabel getCOMP_FAS_PROD_CODE_FM_LABEL() {
		return COMP_FAS_PROD_CODE_FM_LABEL;
	}

	public HtmlInputText getCOMP_FAS_PROD_CODE_FM() {
		return COMP_FAS_PROD_CODE_FM;
	}

	public void setCOMP_FAS_PROD_CODE_FM_LABEL(HtmlOutputLabel COMP_FAS_PROD_CODE_FM_LABEL) {
		this.COMP_FAS_PROD_CODE_FM_LABEL = COMP_FAS_PROD_CODE_FM_LABEL;
	}

	public void setCOMP_FAS_PROD_CODE_FM(HtmlInputText COMP_FAS_PROD_CODE_FM) {
		this.COMP_FAS_PROD_CODE_FM = COMP_FAS_PROD_CODE_FM;
	}

	public HtmlOutputLabel getCOMP_FAS_PROD_CODE_TO_LABEL() {
		return COMP_FAS_PROD_CODE_TO_LABEL;
	}

	public HtmlInputText getCOMP_FAS_PROD_CODE_TO() {
		return COMP_FAS_PROD_CODE_TO;
	}

	public void setCOMP_FAS_PROD_CODE_TO_LABEL(HtmlOutputLabel COMP_FAS_PROD_CODE_TO_LABEL) {
		this.COMP_FAS_PROD_CODE_TO_LABEL = COMP_FAS_PROD_CODE_TO_LABEL;
	}

	public void setCOMP_FAS_PROD_CODE_TO(HtmlInputText COMP_FAS_PROD_CODE_TO) {
		this.COMP_FAS_PROD_CODE_TO = COMP_FAS_PROD_CODE_TO;
	}

	public HtmlOutputLabel getCOMP_FAS_FUND_CODE_FM_LABEL() {
		return COMP_FAS_FUND_CODE_FM_LABEL;
	}

	public HtmlInputText getCOMP_FAS_FUND_CODE_FM() {
		return COMP_FAS_FUND_CODE_FM;
	}

	public void setCOMP_FAS_FUND_CODE_FM_LABEL(HtmlOutputLabel COMP_FAS_FUND_CODE_FM_LABEL) {
		this.COMP_FAS_FUND_CODE_FM_LABEL = COMP_FAS_FUND_CODE_FM_LABEL;
	}

	public void setCOMP_FAS_FUND_CODE_FM(HtmlInputText COMP_FAS_FUND_CODE_FM) {
		this.COMP_FAS_FUND_CODE_FM = COMP_FAS_FUND_CODE_FM;
	}

	public HtmlOutputLabel getCOMP_FAS_FUND_CODE_TO_LABEL() {
		return COMP_FAS_FUND_CODE_TO_LABEL;
	}

	public HtmlInputText getCOMP_FAS_FUND_CODE_TO() {
		return COMP_FAS_FUND_CODE_TO;
	}

	public void setCOMP_FAS_FUND_CODE_TO_LABEL(HtmlOutputLabel COMP_FAS_FUND_CODE_TO_LABEL) {
		this.COMP_FAS_FUND_CODE_TO_LABEL = COMP_FAS_FUND_CODE_TO_LABEL;
	}

	public void setCOMP_FAS_FUND_CODE_TO(HtmlInputText COMP_FAS_FUND_CODE_TO) {
		this.COMP_FAS_FUND_CODE_TO = COMP_FAS_FUND_CODE_TO;
	}

	public HtmlOutputLabel getCOMP_FAS_POL_YR_FM_LABEL() {
		return COMP_FAS_POL_YR_FM_LABEL;
	}

	public HtmlInputText getCOMP_FAS_POL_YR_FM() {
		return COMP_FAS_POL_YR_FM;
	}

	public void setCOMP_FAS_POL_YR_FM_LABEL(HtmlOutputLabel COMP_FAS_POL_YR_FM_LABEL) {
		this.COMP_FAS_POL_YR_FM_LABEL = COMP_FAS_POL_YR_FM_LABEL;
	}

	public void setCOMP_FAS_POL_YR_FM(HtmlInputText COMP_FAS_POL_YR_FM) {
		this.COMP_FAS_POL_YR_FM = COMP_FAS_POL_YR_FM;
	}

	public HtmlOutputLabel getCOMP_FAS_POL_YR_TO_LABEL() {
		return COMP_FAS_POL_YR_TO_LABEL;
	}

	public HtmlInputText getCOMP_FAS_POL_YR_TO() {
		return COMP_FAS_POL_YR_TO;
	}

	public void setCOMP_FAS_POL_YR_TO_LABEL(HtmlOutputLabel COMP_FAS_POL_YR_TO_LABEL) {
		this.COMP_FAS_POL_YR_TO_LABEL = COMP_FAS_POL_YR_TO_LABEL;
	}

	public void setCOMP_FAS_POL_YR_TO(HtmlInputText COMP_FAS_POL_YR_TO) {
		this.COMP_FAS_POL_YR_TO = COMP_FAS_POL_YR_TO;
	}

	public HtmlOutputLabel getCOMP_FAS_SETUP_FOR_LABEL() {
		return COMP_FAS_SETUP_FOR_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_FAS_SETUP_FOR() {
		return COMP_FAS_SETUP_FOR;
	}

	public void setCOMP_FAS_SETUP_FOR_LABEL(HtmlOutputLabel COMP_FAS_SETUP_FOR_LABEL) {
		this.COMP_FAS_SETUP_FOR_LABEL = COMP_FAS_SETUP_FOR_LABEL;
	}

	public void setCOMP_FAS_SETUP_FOR(HtmlSelectOneMenu COMP_FAS_SETUP_FOR) {
		this.COMP_FAS_SETUP_FOR = COMP_FAS_SETUP_FOR;
	}

	public HtmlOutputLabel getCOMP_FAS_DRCR_FLAG_LABEL() {
		return COMP_FAS_DRCR_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_FAS_DRCR_FLAG() {
		return COMP_FAS_DRCR_FLAG;
	}

	public void setCOMP_FAS_DRCR_FLAG_LABEL(HtmlOutputLabel COMP_FAS_DRCR_FLAG_LABEL) {
		this.COMP_FAS_DRCR_FLAG_LABEL = COMP_FAS_DRCR_FLAG_LABEL;
	}

	public void setCOMP_FAS_DRCR_FLAG(HtmlSelectOneMenu COMP_FAS_DRCR_FLAG) {
		this.COMP_FAS_DRCR_FLAG = COMP_FAS_DRCR_FLAG;
	}

	public HtmlOutputLabel getCOMP_FAS_SEQ_NO_LABEL() {
		return COMP_FAS_SEQ_NO_LABEL;
	}

	public HtmlInputText getCOMP_FAS_SEQ_NO() {
		return COMP_FAS_SEQ_NO;
	}

	public void setCOMP_FAS_SEQ_NO_LABEL(HtmlOutputLabel COMP_FAS_SEQ_NO_LABEL) {
		this.COMP_FAS_SEQ_NO_LABEL = COMP_FAS_SEQ_NO_LABEL;
	}

	public void setCOMP_FAS_SEQ_NO(HtmlInputText COMP_FAS_SEQ_NO) {
		this.COMP_FAS_SEQ_NO = COMP_FAS_SEQ_NO;
	}

	public HtmlOutputLabel getCOMP_FAS_NARRATION_CODE_LABEL() {
		return COMP_FAS_NARRATION_CODE_LABEL;
	}

	public HtmlInputText getCOMP_FAS_NARRATION_CODE() {
		return COMP_FAS_NARRATION_CODE;
	}

	public void setCOMP_FAS_NARRATION_CODE_LABEL(HtmlOutputLabel COMP_FAS_NARRATION_CODE_LABEL) {
		this.COMP_FAS_NARRATION_CODE_LABEL = COMP_FAS_NARRATION_CODE_LABEL;
	}

	public void setCOMP_FAS_NARRATION_CODE(HtmlInputText COMP_FAS_NARRATION_CODE) {
		this.COMP_FAS_NARRATION_CODE = COMP_FAS_NARRATION_CODE;
	}

	public HtmlOutputLabel getCOMP_FAS_FORCE_DIVN_YN_LABEL() {
		return COMP_FAS_FORCE_DIVN_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_FAS_FORCE_DIVN_YN() {
		return COMP_FAS_FORCE_DIVN_YN;
	}

	public void setCOMP_FAS_FORCE_DIVN_YN_LABEL(HtmlOutputLabel COMP_FAS_FORCE_DIVN_YN_LABEL) {
		this.COMP_FAS_FORCE_DIVN_YN_LABEL = COMP_FAS_FORCE_DIVN_YN_LABEL;
	}

	public void setCOMP_FAS_FORCE_DIVN_YN(HtmlSelectOneMenu COMP_FAS_FORCE_DIVN_YN) {
		this.COMP_FAS_FORCE_DIVN_YN = COMP_FAS_FORCE_DIVN_YN;
	}

	public HtmlOutputLabel getCOMP_FAS_FORCE_DEPT_YN_LABEL() {
		return COMP_FAS_FORCE_DEPT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_FAS_FORCE_DEPT_YN() {
		return COMP_FAS_FORCE_DEPT_YN;
	}

	public void setCOMP_FAS_FORCE_DEPT_YN_LABEL(HtmlOutputLabel COMP_FAS_FORCE_DEPT_YN_LABEL) {
		this.COMP_FAS_FORCE_DEPT_YN_LABEL = COMP_FAS_FORCE_DEPT_YN_LABEL;
	}

	public void setCOMP_FAS_FORCE_DEPT_YN(HtmlSelectOneMenu COMP_FAS_FORCE_DEPT_YN) {
		this.COMP_FAS_FORCE_DEPT_YN = COMP_FAS_FORCE_DEPT_YN;
	}

	public HtmlOutputLabel getCOMP_FAS_MAIN_ACNT_CODE_LABEL() {
		return COMP_FAS_MAIN_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_FAS_MAIN_ACNT_CODE() {
		return COMP_FAS_MAIN_ACNT_CODE;
	}

	public void setCOMP_FAS_MAIN_ACNT_CODE_LABEL(HtmlOutputLabel COMP_FAS_MAIN_ACNT_CODE_LABEL) {
		this.COMP_FAS_MAIN_ACNT_CODE_LABEL = COMP_FAS_MAIN_ACNT_CODE_LABEL;
	}

	public void setCOMP_FAS_MAIN_ACNT_CODE(HtmlInputText COMP_FAS_MAIN_ACNT_CODE) {
		this.COMP_FAS_MAIN_ACNT_CODE = COMP_FAS_MAIN_ACNT_CODE;
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

	public HtmlOutputLabel getCOMP_FAS_SUB_ACNT_CODE_LABEL() {
		return COMP_FAS_SUB_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_FAS_SUB_ACNT_CODE() {
		return COMP_FAS_SUB_ACNT_CODE;
	}

	public void setCOMP_FAS_SUB_ACNT_CODE_LABEL(HtmlOutputLabel COMP_FAS_SUB_ACNT_CODE_LABEL) {
		this.COMP_FAS_SUB_ACNT_CODE_LABEL = COMP_FAS_SUB_ACNT_CODE_LABEL;
	}

	public void setCOMP_FAS_SUB_ACNT_CODE(HtmlInputText COMP_FAS_SUB_ACNT_CODE) {
		this.COMP_FAS_SUB_ACNT_CODE = COMP_FAS_SUB_ACNT_CODE;
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

	public HtmlOutputLabel getCOMP_FAS_DIVN_CODE_LABEL() {
		return COMP_FAS_DIVN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_FAS_DIVN_CODE() {
		return COMP_FAS_DIVN_CODE;
	}

	public void setCOMP_FAS_DIVN_CODE_LABEL(HtmlOutputLabel COMP_FAS_DIVN_CODE_LABEL) {
		this.COMP_FAS_DIVN_CODE_LABEL = COMP_FAS_DIVN_CODE_LABEL;
	}

	public void setCOMP_FAS_DIVN_CODE(HtmlInputText COMP_FAS_DIVN_CODE) {
		this.COMP_FAS_DIVN_CODE = COMP_FAS_DIVN_CODE;
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

	public HtmlOutputLabel getCOMP_FAS_DEPT_CODE_LABEL() {
		return COMP_FAS_DEPT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_FAS_DEPT_CODE() {
		return COMP_FAS_DEPT_CODE;
	}

	public void setCOMP_FAS_DEPT_CODE_LABEL(HtmlOutputLabel COMP_FAS_DEPT_CODE_LABEL) {
		this.COMP_FAS_DEPT_CODE_LABEL = COMP_FAS_DEPT_CODE_LABEL;
	}

	public void setCOMP_FAS_DEPT_CODE(HtmlInputText COMP_FAS_DEPT_CODE) {
		this.COMP_FAS_DEPT_CODE = COMP_FAS_DEPT_CODE;
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

	public HtmlOutputLabel getCOMP_FAS_ANLY_CODE_1_LABEL() {
		return COMP_FAS_ANLY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_FAS_ANLY_CODE_1() {
		return COMP_FAS_ANLY_CODE_1;
	}

	public void setCOMP_FAS_ANLY_CODE_1_LABEL(HtmlOutputLabel COMP_FAS_ANLY_CODE_1_LABEL) {
		this.COMP_FAS_ANLY_CODE_1_LABEL = COMP_FAS_ANLY_CODE_1_LABEL;
	}

	public void setCOMP_FAS_ANLY_CODE_1(HtmlInputText COMP_FAS_ANLY_CODE_1) {
		this.COMP_FAS_ANLY_CODE_1 = COMP_FAS_ANLY_CODE_1;
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

	public HtmlOutputLabel getCOMP_FAS_ANLY_CODE_2_LABEL() {
		return COMP_FAS_ANLY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_FAS_ANLY_CODE_2() {
		return COMP_FAS_ANLY_CODE_2;
	}

	public void setCOMP_FAS_ANLY_CODE_2_LABEL(HtmlOutputLabel COMP_FAS_ANLY_CODE_2_LABEL) {
		this.COMP_FAS_ANLY_CODE_2_LABEL = COMP_FAS_ANLY_CODE_2_LABEL;
	}

	public void setCOMP_FAS_ANLY_CODE_2(HtmlInputText COMP_FAS_ANLY_CODE_2) {
		this.COMP_FAS_ANLY_CODE_2 = COMP_FAS_ANLY_CODE_2;
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

	public HtmlOutputLabel getCOMP_FAS_ACTY_CODE_1_LABEL() {
		return COMP_FAS_ACTY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_FAS_ACTY_CODE_1() {
		return COMP_FAS_ACTY_CODE_1;
	}

	public void setCOMP_FAS_ACTY_CODE_1_LABEL(HtmlOutputLabel COMP_FAS_ACTY_CODE_1_LABEL) {
		this.COMP_FAS_ACTY_CODE_1_LABEL = COMP_FAS_ACTY_CODE_1_LABEL;
	}

	public void setCOMP_FAS_ACTY_CODE_1(HtmlInputText COMP_FAS_ACTY_CODE_1) {
		this.COMP_FAS_ACTY_CODE_1 = COMP_FAS_ACTY_CODE_1;
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

	public HtmlOutputLabel getCOMP_FAS_ACTY_CODE_2_LABEL() {
		return COMP_FAS_ACTY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_FAS_ACTY_CODE_2() {
		return COMP_FAS_ACTY_CODE_2;
	}

	public void setCOMP_FAS_ACTY_CODE_2_LABEL(HtmlOutputLabel COMP_FAS_ACTY_CODE_2_LABEL) {
		this.COMP_FAS_ACTY_CODE_2_LABEL = COMP_FAS_ACTY_CODE_2_LABEL;
	}

	public void setCOMP_FAS_ACTY_CODE_2(HtmlInputText COMP_FAS_ACTY_CODE_2) {
		this.COMP_FAS_ACTY_CODE_2 = COMP_FAS_ACTY_CODE_2;
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

	public HtmlOutputLabel getCOMP_FAS_FRZ_FLAG_LABEL() {
		return COMP_FAS_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_FAS_FRZ_FLAG() {
		return COMP_FAS_FRZ_FLAG;
	}

	public void setCOMP_FAS_FRZ_FLAG_LABEL(HtmlOutputLabel COMP_FAS_FRZ_FLAG_LABEL) {
		this.COMP_FAS_FRZ_FLAG_LABEL = COMP_FAS_FRZ_FLAG_LABEL;
	}

	public void setCOMP_FAS_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_FAS_FRZ_FLAG) {
		this.COMP_FAS_FRZ_FLAG = COMP_FAS_FRZ_FLAG;
	}

	public HtmlCommandButton getCOMP_UI_M_FAS_DEPT_CODE_LOV() {
		return COMP_UI_M_FAS_DEPT_CODE_LOV;
	}

	public void setCOMP_UI_M_FAS_DEPT_CODE_LOV(HtmlCommandButton COMP_UI_M_FAS_DEPT_CODE_LOV) {
		this.COMP_UI_M_FAS_DEPT_CODE_LOV = COMP_UI_M_FAS_DEPT_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_FAS_ANLY_CODE_1_LOV() {
		return COMP_UI_M_FAS_ANLY_CODE_1_LOV;
	}

	public void setCOMP_UI_M_FAS_ANLY_CODE_1_LOV(HtmlCommandButton COMP_UI_M_FAS_ANLY_CODE_1_LOV) {
		this.COMP_UI_M_FAS_ANLY_CODE_1_LOV = COMP_UI_M_FAS_ANLY_CODE_1_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_FAS_ANLY_CODE_2_LOV() {
		return COMP_UI_M_FAS_ANLY_CODE_2_LOV;
	}

	public void setCOMP_UI_M_FAS_ANLY_CODE_2_LOV(HtmlCommandButton COMP_UI_M_FAS_ANLY_CODE_2_LOV) {
		this.COMP_UI_M_FAS_ANLY_CODE_2_LOV = COMP_UI_M_FAS_ANLY_CODE_2_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_FAS_ACTY_CODE_1_LOV() {
		return COMP_UI_M_FAS_ACTY_CODE_1_LOV;
	}

	public void setCOMP_UI_M_FAS_ACTY_CODE_1_LOV(HtmlCommandButton COMP_UI_M_FAS_ACTY_CODE_1_LOV) {
		this.COMP_UI_M_FAS_ACTY_CODE_1_LOV = COMP_UI_M_FAS_ACTY_CODE_1_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_FAS_ACTY_CODE_2_LOV() {
		return COMP_UI_M_FAS_ACTY_CODE_2_LOV;
	}

	public void setCOMP_UI_M_FAS_ACTY_CODE_2_LOV(HtmlCommandButton COMP_UI_M_FAS_ACTY_CODE_2_LOV) {
		this.COMP_UI_M_FAS_ACTY_CODE_2_LOV = COMP_UI_M_FAS_ACTY_CODE_2_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_FAS_NARRATION_CODE_LOV() {
		return COMP_UI_M_FAS_NARRATION_CODE_LOV;
	}

	public void setCOMP_UI_M_FAS_NARRATION_CODE_LOV(HtmlCommandButton COMP_UI_M_FAS_NARRATION_CODE_LOV) {
		this.COMP_UI_M_FAS_NARRATION_CODE_LOV = COMP_UI_M_FAS_NARRATION_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_SRC_BUS_FM_LOV() {
		return COMP_UI_M_SRC_BUS_FM_LOV;
	}

	public void setCOMP_UI_M_SRC_BUS_FM_LOV(HtmlCommandButton COMP_UI_M_SRC_BUS_FM_LOV) {
		this.COMP_UI_M_SRC_BUS_FM_LOV = COMP_UI_M_SRC_BUS_FM_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_SRC_BUS_TO_LOV() {
		return COMP_UI_M_SRC_BUS_TO_LOV;
	}

	public void setCOMP_UI_M_SRC_BUS_TO_LOV(HtmlCommandButton COMP_UI_M_SRC_BUS_TO_LOV) {
		this.COMP_UI_M_SRC_BUS_TO_LOV = COMP_UI_M_SRC_BUS_TO_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_FAS_DIVN_FM_CODE_LOV() {
		return COMP_UI_M_FAS_DIVN_FM_CODE_LOV;
	}

	public void setCOMP_UI_M_FAS_DIVN_FM_CODE_LOV(HtmlCommandButton COMP_UI_M_FAS_DIVN_FM_CODE_LOV) {
		this.COMP_UI_M_FAS_DIVN_FM_CODE_LOV = COMP_UI_M_FAS_DIVN_FM_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_FAS_DOC_TO_TYPE_LOV() {
		return COMP_UI_M_FAS_DOC_TO_TYPE_LOV;
	}

	public void setCOMP_UI_M_FAS_DOC_TO_TYPE_LOV(HtmlCommandButton COMP_UI_M_FAS_DOC_TO_TYPE_LOV) {
		this.COMP_UI_M_FAS_DOC_TO_TYPE_LOV = COMP_UI_M_FAS_DOC_TO_TYPE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_FAS_DIVN_TO_CODE_LOV() {
		return COMP_UI_M_FAS_DIVN_TO_CODE_LOV;
	}

	public void setCOMP_UI_M_FAS_DIVN_TO_CODE_LOV(HtmlCommandButton COMP_UI_M_FAS_DIVN_TO_CODE_LOV) {
		this.COMP_UI_M_FAS_DIVN_TO_CODE_LOV = COMP_UI_M_FAS_DIVN_TO_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_FAS_DEPT_FM_CODE_LOV() {
		return COMP_UI_M_FAS_DEPT_FM_CODE_LOV;
	}

	public void setCOMP_UI_M_FAS_DEPT_FM_CODE_LOV(HtmlCommandButton COMP_UI_M_FAS_DEPT_FM_CODE_LOV) {
		this.COMP_UI_M_FAS_DEPT_FM_CODE_LOV = COMP_UI_M_FAS_DEPT_FM_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_FAS_DEPT_TO_CODE_LOV() {
		return COMP_UI_M_FAS_DEPT_TO_CODE_LOV;
	}

	public void setCOMP_UI_M_FAS_DEPT_TO_CODE_LOV(HtmlCommandButton COMP_UI_M_FAS_DEPT_TO_CODE_LOV) {
		this.COMP_UI_M_FAS_DEPT_TO_CODE_LOV = COMP_UI_M_FAS_DEPT_TO_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_FAS_DOC_FM_TYPE_LOV() {
		return COMP_UI_M_FAS_DOC_FM_TYPE_LOV;
	}

	public void setCOMP_UI_M_FAS_DOC_FM_TYPE_LOV(HtmlCommandButton COMP_UI_M_FAS_DOC_FM_TYPE_LOV) {
		this.COMP_UI_M_FAS_DOC_FM_TYPE_LOV = COMP_UI_M_FAS_DOC_FM_TYPE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_FAS_PROD_CODE_FM_LOV() {
		return COMP_UI_M_FAS_PROD_CODE_FM_LOV;
	}

	public void setCOMP_UI_M_FAS_PROD_CODE_FM_LOV(HtmlCommandButton COMP_UI_M_FAS_PROD_CODE_FM_LOV) {
		this.COMP_UI_M_FAS_PROD_CODE_FM_LOV = COMP_UI_M_FAS_PROD_CODE_FM_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_FAS_PROD_CODE_TO_LOV() {
		return COMP_UI_M_FAS_PROD_CODE_TO_LOV;
	}

	public void setCOMP_UI_M_FAS_PROD_CODE_TO_LOV(HtmlCommandButton COMP_UI_M_FAS_PROD_CODE_TO_LOV) {
		this.COMP_UI_M_FAS_PROD_CODE_TO_LOV = COMP_UI_M_FAS_PROD_CODE_TO_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_FAS_FUND_CODE_FM_LOV() {
		return COMP_UI_M_FAS_FUND_CODE_FM_LOV;
	}

	public void setCOMP_UI_M_FAS_FUND_CODE_FM_LOV(HtmlCommandButton COMP_UI_M_FAS_FUND_CODE_FM_LOV) {
		this.COMP_UI_M_FAS_FUND_CODE_FM_LOV = COMP_UI_M_FAS_FUND_CODE_FM_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_FAS_FUND_CODE_TO_LOV() {
		return COMP_UI_M_FAS_FUND_CODE_TO_LOV;
	}

	public void setCOMP_UI_M_FAS_FUND_CODE_TO_LOV(HtmlCommandButton COMP_UI_M_FAS_FUND_CODE_TO_LOV) {
		this.COMP_UI_M_FAS_FUND_CODE_TO_LOV = COMP_UI_M_FAS_FUND_CODE_TO_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_FAS_MAIN_ACNT_CODE_LOV() {
		return COMP_UI_M_FAS_MAIN_ACNT_CODE_LOV;
	}

	public void setCOMP_UI_M_FAS_MAIN_ACNT_CODE_LOV(HtmlCommandButton COMP_UI_M_FAS_MAIN_ACNT_CODE_LOV) {
		this.COMP_UI_M_FAS_MAIN_ACNT_CODE_LOV = COMP_UI_M_FAS_MAIN_ACNT_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_FAS_SUB_ACNT_CODE_LOV() {
		return COMP_UI_M_FAS_SUB_ACNT_CODE_LOV;
	}

	public void setCOMP_UI_M_FAS_SUB_ACNT_CODE_LOV(HtmlCommandButton COMP_UI_M_FAS_SUB_ACNT_CODE_LOV) {
		this.COMP_UI_M_FAS_SUB_ACNT_CODE_LOV = COMP_UI_M_FAS_SUB_ACNT_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_FAS_DIVN_CODE_LOV() {
		return COMP_UI_M_FAS_DIVN_CODE_LOV;
	}

	public void setCOMP_UI_M_FAS_DIVN_CODE_LOV(HtmlCommandButton COMP_UI_M_FAS_DIVN_CODE_LOV) {
		this.COMP_UI_M_FAS_DIVN_CODE_LOV = COMP_UI_M_FAS_DIVN_CODE_LOV;
	}

	public PM_IL_FUND_ACCOUNT_SETUP getPM_IL_FUND_ACCOUNT_SETUP_BEAN() {
		return PM_IL_FUND_ACCOUNT_SETUP_BEAN;
	}

	public void setPM_IL_FUND_ACCOUNT_SETUP_BEAN(PM_IL_FUND_ACCOUNT_SETUP PM_IL_FUND_ACCOUNT_SETUP_BEAN) {
		this.PM_IL_FUND_ACCOUNT_SETUP_BEAN = PM_IL_FUND_ACCOUNT_SETUP_BEAN;
	}

	public String preForm(PhaseEvent event){
		String M_FILE=null, M_TITLE=null;

		session = getSessionMap();
		session.put("GLOBAL.M_FAILURE", "FALSE");

		session.put("GLOBAL.M_MODULE_NAME","PILM061_APAC");
		STD_PRE_FORM();

		return "";
	}

	public void STD_PRE_FORM(){
		String CUR_FORM=null, M_FIRST_BLOCK=null, M_MODULE_NAME=null, M_TITLE=null; 
		int M_QUERY_OK;
		ControlBean ctrlBean = CommonUtils.getControlBean();
		ctrlBean.setM_PARA_1((String)session.get("GLOBAL.M_PARA_1"));
		ctrlBean.setM_PROG_NAME("PILT010");
		session.put("GLOBAL.M_FAILURE", "FALSE");
		ctrlBean.setM_GOFLD_NAME("NULL");
		}

	public String preCommit(){
		return "";
	}

	public String postFormsCommit(){
		getSessionMap().put("GLOBAL.M_FAILURE", "FALSE");
		return "";
	}

	public String postDatabaseCommit(){
		getSessionMap().put("GLOBAL.M_FAILURE", "FALSE");
		return "";
	}

	

	public Map<String, Object> getSessionMap(){
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getSessionMap();
	}

	public List<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN> getSourceBusFromTo(Object obj) throws Exception{
		return  PM_IL_FUND_ACCOUNT_SETUP_DELEGATE_METHOD.getFAS_SRC_BUS_FM_TO(this, obj);
	}

	public void sourceBusFromwhenValidate(ActionEvent ae){
		P_SET_FIRST_FIELD(getCOMP_FAS_SRC_BUS_FM(), getCOMP_FAS_SRC_BUS_TO());
		getPM_IL_FUND_ACCOUNT_SETUP_BEAN().setFAS_SRC_BUS_TO((String)getCOMP_FAS_SRC_BUS_TO().getSubmittedValue());
	}

	public void P_SET_FIRST_FIELD(UIInput comp1, UIInput comp2){
		String M_FIELD_DATA="", M_DATA_TYPE=comp1.getSubmittedValue().getClass().getSimpleName();
		if("".equalsIgnoreCase((String) comp1.getSubmittedValue())){
			if(M_DATA_TYPE.equalsIgnoreCase("String") || M_DATA_TYPE.equalsIgnoreCase("Integer")){
				M_FIELD_DATA="0";
			}
			comp1.setSubmittedValue("0");
		}
		if(!M_DATA_TYPE.equalsIgnoreCase("Date")){
			comp2.setSubmittedValue(comp2.getSubmittedValue());
		}
	}

	public void sourceBusTowhenValidate(ActionEvent ae){
		int M_FIELD_LENGTH=0;
		String M_FIELD_DATA="", M_FIELD_DATA_1="", M_DATA_TYPE=getCOMP_FAS_SRC_BUS_FM().getSubmittedValue().getClass().getSimpleName();
		if("".equalsIgnoreCase(getCOMP_FAS_SRC_BUS_TO().getSubmittedValue().toString())){
			attributes=getCOMP_FAS_SRC_BUS_FM().getAttributes();
			M_FIELD_LENGTH = ((Integer)attributes.get("maxlength"));
			if(M_DATA_TYPE.equalsIgnoreCase("String") || M_DATA_TYPE.equalsIgnoreCase("Integer")){
				M_FIELD_DATA="0";
			}
			if(M_DATA_TYPE.equalsIgnoreCase("String")){
				if(getCOMP_FAS_SRC_BUS_FM().getSubmittedValue().toString().equalsIgnoreCase(M_FIELD_DATA)){
					M_FIELD_DATA= "zzzzzzzzzzzzzzzzzzzzzz".substring(0, M_FIELD_LENGTH);
					getCOMP_FAS_SRC_BUS_TO().setSubmittedValue(M_FIELD_DATA);
				}else{
					if(M_DATA_TYPE.equalsIgnoreCase("String")){
						getCOMP_FAS_SRC_BUS_TO().setSubmittedValue(getCOMP_FAS_SRC_BUS_FM().getSubmittedValue());
					}
				}
			}else{
				if(M_DATA_TYPE.equalsIgnoreCase("Integer")){
					if(getCOMP_FAS_SRC_BUS_FM().getSubmittedValue()==M_FIELD_DATA){
						M_FIELD_DATA="9999999999999999999999".substring(0, M_FIELD_LENGTH);
						getCOMP_FAS_SRC_BUS_TO().setSubmittedValue(M_FIELD_DATA);
					}else{
						getCOMP_FAS_SRC_BUS_TO().setSubmittedValue(getCOMP_FAS_SRC_BUS_FM().getSubmittedValue());
					}
				}
			}
		}
		UIInput input = (UIInput) ae.getComponent().getParent();
		ErrorHelpUtil.validate(input, input.getId(), getErrorMap());
	}

	public void validator_sourceBusTo(FacesContext context, UIComponent component,Object value) 
	throws ValidatorException,ParseException {
		if(getCOMP_FAS_SRC_BUS_FM().getSubmittedValue() != null && getCOMP_FAS_SRC_BUS_TO().getSubmittedValue() !=null){
			try{
				P_SET_SECOND_FIELD(getCOMP_FAS_SRC_BUS_FM(), getCOMP_FAS_SRC_BUS_TO());
				L_VAL_FROM_TO(getCOMP_FAS_SRC_BUS_FM(), getCOMP_FAS_SRC_BUS_TO());
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public void P_SET_SECOND_FIELD(UIInput comp1, UIInput comp2){
		String M_DATA_TYPE=comp1.getSubmittedValue().getClass().getSimpleName();
		if(M_DATA_TYPE.equals("String")){
			if(comp2.getSubmittedValue().toString().compareTo(comp1.getSubmittedValue().toString()) < 0 ){
				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "10064"));
			}
		}else{
			if(M_DATA_TYPE.equalsIgnoreCase("Integer") || M_DATA_TYPE.equalsIgnoreCase("Double")){
				if(Integer.parseInt(comp1.getSubmittedValue().toString()) > Integer.parseInt(comp2.getSubmittedValue().toString())){
					throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "10064"));
				}
			}
		}
	}

	public void L_VAL_FROM_TO(UIInput comp1, UIInput comp2){
		try{
			if("".equalsIgnoreCase(comp1.getSubmittedValue().toString())){
				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "80033"));
			}if(!"".equals(comp2.getSubmittedValue().toString())){
				if(comp2.getSubmittedValue().toString().compareTo(comp1.getSubmittedValue().toString()) < 0){
					throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "80034"));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "80034"));
		}
	}

	public List<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN> getDivisionRangeFromTo(Object obj) throws Exception{
		return  PM_IL_FUND_ACCOUNT_SETUP_DELEGATE_METHOD.getFAS_DIVN_FM_TO_CODE(this, obj);
	}

	public void divisionFromwhenValidate(ActionEvent ae){
		getPM_IL_FUND_ACCOUNT_SETUP_BEAN().setFAS_DIVN_TO_CODE((String)getCOMP_FAS_DIVN_TO_CODE().getSubmittedValue());
		P_SET_FIRST_FIELD(getCOMP_FAS_DIVN_FM_CODE(), getCOMP_FAS_DIVN_TO_CODE());
		getPM_IL_FUND_ACCOUNT_SETUP_BEAN().setFAS_DIVN_FM_CODE((String)getCOMP_FAS_DIVN_FM_CODE().getSubmittedValue());
	}

	public void divisionTowhenValidate(ActionEvent ae){
		int M_FIELD_LENGTH=0;
		String M_FIELD_DATA="", M_FIELD_DATA_1="", M_DATA_TYPE=getCOMP_FAS_DIVN_FM_CODE().getSubmittedValue().getClass().getSimpleName();
		if("".equalsIgnoreCase(getCOMP_FAS_DIVN_TO_CODE().getSubmittedValue().toString())){
			attributes=getCOMP_FAS_DIVN_FM_CODE().getAttributes();
			M_FIELD_LENGTH = ((Integer)attributes.get("maxlength"));
			if(M_DATA_TYPE.equalsIgnoreCase("String") || M_DATA_TYPE.equalsIgnoreCase("Integer")){
				M_FIELD_DATA="0";
			}
			if(M_DATA_TYPE.equalsIgnoreCase("String")){
				if(getCOMP_FAS_DIVN_FM_CODE().getSubmittedValue().toString().equalsIgnoreCase(M_FIELD_DATA)){
					M_FIELD_DATA= "zzzzzzzzzzzzzzzzzzzzzz".substring(0, M_FIELD_LENGTH);
					getCOMP_FAS_DIVN_TO_CODE().setSubmittedValue(M_FIELD_DATA);
				}else{
					if(M_DATA_TYPE.equalsIgnoreCase("String")){
						getCOMP_FAS_DIVN_TO_CODE().setSubmittedValue(getCOMP_FAS_DIVN_FM_CODE().getSubmittedValue());
					}
				}
			}else{
				if(M_DATA_TYPE.equalsIgnoreCase("Integer")){
					if(getCOMP_FAS_DIVN_FM_CODE().getSubmittedValue()==M_FIELD_DATA){
						M_FIELD_DATA="9999999999999999999999".substring(0, M_FIELD_LENGTH);
						getCOMP_FAS_DIVN_TO_CODE().setSubmittedValue(M_FIELD_DATA);
					}else{
						getCOMP_FAS_DIVN_TO_CODE().setSubmittedValue(getCOMP_FAS_DIVN_FM_CODE().getSubmittedValue());
					}
				}
			}
		}
		UIInput input = (UIInput) ae.getComponent().getParent();
		ErrorHelpUtil.validate(input, input.getId(), getErrorMap());
	}

	public void validator_divisionTo(FacesContext context, UIComponent component,Object value) 
	throws ValidatorException,ParseException {
		if(getCOMP_FAS_DIVN_FM_CODE().getSubmittedValue() != null && getCOMP_FAS_DIVN_TO_CODE().getSubmittedValue() != null){
			P_SET_SECOND_FIELD(getCOMP_FAS_DIVN_FM_CODE(), getCOMP_FAS_DIVN_TO_CODE());
			L_VAL_FROM_TO(getCOMP_FAS_DIVN_FM_CODE(), getCOMP_FAS_DIVN_TO_CODE());
		}
	}

	public List<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN> getDepartmentRangeFrom(Object obj) throws Exception{

		List<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN> suggestionList1 = new ArrayList<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN>();
		String query = null;
		if(obj.toString().equals("*")){
			System.out.println("I am in if ");
			query = "select DEPT_CODE, DEPT_NAME from FM_DEPARTMENT where DEPT_COMP_CODE = '"+COMP_CODE+"' " +
			"AND DEPT_DIVN_CODE = '"+getPM_IL_FUND_ACCOUNT_SETUP_BEAN().getFAS_DIVN_FM_CODE()+"' AND DEPT_FRZ_FLAG  = 'N' " +
			"AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DEPT_DIVN_CODE " +
			"AND ADS_DEPT_CODE = DEPT_CODE AND ADS_USER_ID = NVL('',ADS_USER_ID) " +
			"AND ADS_FRZ_FLAG = 'N') AND ROWNUM<=25";
		}else{
			System.out.println("I am in else ");
			query = "select DEPT_CODE, DEPT_NAME from FM_DEPARTMENT where DEPT_COMP_CODE = '"+COMP_CODE+"' " +
			"AND DEPT_DIVN_CODE = '"+getPM_IL_FUND_ACCOUNT_SETUP_BEAN().getFAS_DIVN_FM_CODE()+"' AND DEPT_FRZ_FLAG  = 'N' " +
			"AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DEPT_DIVN_CODE " +
			"AND ADS_DEPT_CODE = DEPT_CODE AND ADS_USER_ID = NVL('',ADS_USER_ID) " +
			"AND ADS_FRZ_FLAG = 'N') AND ROWNUM<=25 AND DEPT_CODE LIKE '"+obj.toString().toUpperCase()+"%'";
		}
		System.out.println("The query is: "+query);
		ResultSet rs = getHandler().executeSelectStatement(query, CommonUtils.getConnection());
		rs.setFetchSize(25);
		while(rs.next()){
			PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN fundAccountSetupLov = new PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN();
			fundAccountSetupLov.setFAS_DEPT_FM_CODE(rs.getString("DEPT_CODE"));
			fundAccountSetupLov.setFAS_DEPT_FM_CODE_DESC(rs.getString("DEPT_NAME"));
			suggestionList1.add(fundAccountSetupLov);
		}
		rs.close();
		return suggestionList1;

	}

	public void departmentFromwhenValidate(ActionEvent ae){
		getPM_IL_FUND_ACCOUNT_SETUP_BEAN().setFAS_DEPT_TO_CODE((String)getCOMP_FAS_DEPT_TO_CODE().getSubmittedValue());
		P_SET_FIRST_FIELD(getCOMP_FAS_DEPT_FM_CODE(), getCOMP_FAS_DEPT_TO_CODE());
	}
	public List<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN> getDepartmentRangeTo(Object obj) throws Exception{
		return  PM_IL_FUND_ACCOUNT_SETUP_DELEGATE_METHOD.getFAS_DEPT_TO_CODE(this,obj);
	}

	public void departmentTowhenValidate(ActionEvent ae){
		int M_FIELD_LENGTH=0;
		String M_FIELD_DATA="", M_FIELD_DATA_1="", M_DATA_TYPE=getCOMP_FAS_DEPT_FM_CODE().getSubmittedValue().getClass().getSimpleName();
		if("".equalsIgnoreCase(getCOMP_FAS_DEPT_TO_CODE().getSubmittedValue().toString())){
			attributes=getCOMP_FAS_DEPT_FM_CODE().getAttributes();
			M_FIELD_LENGTH = ((Integer)attributes.get("maxlength"));
			if(M_DATA_TYPE.equalsIgnoreCase("String") || M_DATA_TYPE.equalsIgnoreCase("Integer")){
				M_FIELD_DATA="0";
			}
			if(M_DATA_TYPE.equalsIgnoreCase("String")){
				if(getCOMP_FAS_DEPT_FM_CODE().getSubmittedValue().toString().equalsIgnoreCase(M_FIELD_DATA)){
					M_FIELD_DATA= "zzzzzzzzzzzzzzzzzzzzzz".substring(0, M_FIELD_LENGTH);
					getCOMP_FAS_DEPT_TO_CODE().setSubmittedValue(M_FIELD_DATA);
				}else{
					if(M_DATA_TYPE.equalsIgnoreCase("String")){
						getCOMP_FAS_DEPT_TO_CODE().setSubmittedValue(getCOMP_FAS_DEPT_FM_CODE().getSubmittedValue());
					}
				}
			}else{
				if(M_DATA_TYPE.equalsIgnoreCase("Integer")){
					if(getCOMP_FAS_DEPT_FM_CODE().getSubmittedValue()==M_FIELD_DATA){
						M_FIELD_DATA="9999999999999999999999".substring(0, M_FIELD_LENGTH);
						getCOMP_FAS_DEPT_TO_CODE().setSubmittedValue(M_FIELD_DATA);
					}else{
						getCOMP_FAS_DEPT_TO_CODE().setSubmittedValue(getCOMP_FAS_DEPT_FM_CODE().getSubmittedValue());
					}
				}
			}
		}
		UIInput input = (UIInput) ae.getComponent().getParent();
		ErrorHelpUtil.validate(input, input.getId(), getErrorMap());
	}

	public void validator_departmentTo(FacesContext context, UIComponent component,Object value) 
	throws ValidatorException,ParseException {
		if(getCOMP_FAS_DEPT_FM_CODE().getSubmittedValue() != null && getCOMP_FAS_DEPT_TO_CODE().getSubmittedValue() != null){
			L_VAL_FROM_TO(getCOMP_FAS_DEPT_FM_CODE(), getCOMP_FAS_DEPT_TO_CODE());
			P_SET_SECOND_FIELD(getCOMP_FAS_DEPT_FM_CODE(), getCOMP_FAS_DEPT_TO_CODE());
		}
	}

	public List<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN> getDocCodeFromTo(Object obj) throws Exception{
		return  PM_IL_FUND_ACCOUNT_SETUP_DELEGATE_METHOD.getFAS_DOC_CODE_FM_TO(this, obj);
	}

	public void docNoFromwhenValidate(ActionEvent ae){
		getPM_IL_FUND_ACCOUNT_SETUP_BEAN().setFAS_DOC_TO_TYPE((String)getCOMP_FAS_DOC_TO_TYPE().getSubmittedValue());
		P_SET_FIRST_FIELD(getCOMP_FAS_DOC_FM_TYPE(), getCOMP_FAS_DOC_TO_TYPE());
	}

	public void docNoTowhenValidate(ActionEvent ae){
		int M_FIELD_LENGTH=0;
		String M_FIELD_DATA="", M_FIELD_DATA_1="", M_DATA_TYPE=getCOMP_FAS_DOC_FM_TYPE().getSubmittedValue().getClass().getSimpleName();
		if("".equalsIgnoreCase(getCOMP_FAS_DOC_TO_TYPE().getSubmittedValue().toString())){
			attributes=getCOMP_FAS_DOC_FM_TYPE().getAttributes();
			M_FIELD_LENGTH = ((Integer)attributes.get("maxlength"));
			if(M_DATA_TYPE.equalsIgnoreCase("String") || M_DATA_TYPE.equalsIgnoreCase("Integer")){
				M_FIELD_DATA="0";
			}
			if(M_DATA_TYPE.equalsIgnoreCase("String")){
				if(getCOMP_FAS_DOC_FM_TYPE().getSubmittedValue().toString().equalsIgnoreCase(M_FIELD_DATA)){
					M_FIELD_DATA= "zzzzzzzzzzzzzzzzzzzzzz".substring(0, M_FIELD_LENGTH);
					getCOMP_FAS_DOC_TO_TYPE().setSubmittedValue(M_FIELD_DATA);
				}else{
					if(M_DATA_TYPE.equalsIgnoreCase("String")){
						getCOMP_FAS_DOC_TO_TYPE().setSubmittedValue(getCOMP_FAS_DOC_FM_TYPE().getSubmittedValue());
					}
				}
			}else{
				if(M_DATA_TYPE.equalsIgnoreCase("Integer")){
					if(getCOMP_FAS_DOC_FM_TYPE().getSubmittedValue()==M_FIELD_DATA){
						M_FIELD_DATA="9999999999999999999999".substring(0, M_FIELD_LENGTH);
						getCOMP_FAS_DOC_TO_TYPE().setSubmittedValue(M_FIELD_DATA);
					}else{
						getCOMP_FAS_DOC_TO_TYPE().setSubmittedValue(getCOMP_FAS_DOC_FM_TYPE().getSubmittedValue());
					}
				}
			}
		}
		UIInput input = (UIInput) ae.getComponent().getParent();
		ErrorHelpUtil.validate(input, input.getId(), getErrorMap());
	}

	public void validator_docNoTo(FacesContext context, UIComponent component,Object value) 
	throws ValidatorException,ParseException {
		if(getCOMP_FAS_DOC_FM_TYPE().getSubmittedValue() != null && getCOMP_FAS_DOC_TO_TYPE().getSubmittedValue() != null){
			L_VAL_FROM_TO(getCOMP_FAS_DOC_FM_TYPE(), getCOMP_FAS_DOC_TO_TYPE());
			P_SET_SECOND_FIELD(getCOMP_FAS_DOC_FM_TYPE(), getCOMP_FAS_DOC_TO_TYPE());
		}
	}

	public List<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN> getProdCodeFromTo(Object obj) throws Exception{
		return  PM_IL_FUND_ACCOUNT_SETUP_DELEGATE_METHOD.getFAS_PROD_CODE_FM_TO(this, obj);
	}

	public void prodCodeFromwhenValidate(ActionEvent ae){
		String M_FIELD_DATA="", M_DATA_TYPE=getCOMP_FAS_PROD_CODE_FM().getSubmittedValue().getClass().getSimpleName();
		if("".equalsIgnoreCase((String) getCOMP_FAS_PROD_CODE_FM().getSubmittedValue())){
			if(M_DATA_TYPE.equalsIgnoreCase("String") || M_DATA_TYPE.equalsIgnoreCase("Integer")){
				M_FIELD_DATA="0";
			}
			getCOMP_FAS_PROD_CODE_FM().setSubmittedValue("0");
		}
		if(!M_DATA_TYPE.equalsIgnoreCase("Date")){
			getCOMP_FAS_PROD_CODE_TO().setSubmittedValue(getCOMP_FAS_PROD_CODE_TO().getSubmittedValue());
		}
		UIInput input = (UIInput) ae.getComponent().getParent();
		ErrorHelpUtil.validate(input, input.getId(), getErrorMap());
	}

	public void validator_prodCodeFrom(FacesContext context, UIComponent component,Object value) 
	throws ValidatorException,ParseException {
		if(getCOMP_FAS_PROD_CODE_FM().getSubmittedValue() != null && getCOMP_FAS_PROD_CODE_TO().getSubmittedValue()!=null){
			L_VAL_FROM_TO(getCOMP_FAS_PROD_CODE_FM(), getCOMP_FAS_PROD_CODE_TO());
		}
	}

	public void prodCodeTowhenValidate(ActionEvent ae){
		int M_FIELD_LENGTH=0;
		String M_FIELD_DATA="", M_FIELD_DATA_1="", M_DATA_TYPE=getCOMP_FAS_PROD_CODE_FM().getSubmittedValue().getClass().getSimpleName();
		if("".equalsIgnoreCase(getCOMP_FAS_PROD_CODE_TO().getSubmittedValue().toString())){
			attributes=getCOMP_FAS_PROD_CODE_FM().getAttributes();
			M_FIELD_LENGTH = ((Integer)attributes.get("maxlength"));
			if(M_DATA_TYPE.equalsIgnoreCase("String") || M_DATA_TYPE.equalsIgnoreCase("Integer")){
				System.out.println("In if state 111111111");
				M_FIELD_DATA="0";
			}
			if(M_DATA_TYPE.equalsIgnoreCase("String")){
				if(getCOMP_FAS_PROD_CODE_FM().getSubmittedValue().toString().equalsIgnoreCase(M_FIELD_DATA)){
					System.out.println("In if 222222222222");
					M_FIELD_DATA= "zzzzzzzzzzzzzzzzzzzzzz".substring(0, M_FIELD_LENGTH);
					getCOMP_FAS_PROD_CODE_TO().setSubmittedValue(M_FIELD_DATA);
				}else{
					if(M_DATA_TYPE.equalsIgnoreCase("String")){
						getCOMP_FAS_PROD_CODE_TO().setSubmittedValue(getCOMP_FAS_PROD_CODE_FM().getSubmittedValue());
					}
				}
			}else{
				if(M_DATA_TYPE.equalsIgnoreCase("Integer")){
					if(getCOMP_FAS_PROD_CODE_FM().getSubmittedValue()==M_FIELD_DATA){
						M_FIELD_DATA="9999999999999999999999".substring(0, M_FIELD_LENGTH);
						getCOMP_FAS_PROD_CODE_TO().setSubmittedValue(M_FIELD_DATA);
					}else{
						getCOMP_FAS_PROD_CODE_TO().setSubmittedValue(getCOMP_FAS_PROD_CODE_FM().getSubmittedValue());
					}
				}
			}
		}
		UIInput input = (UIInput) ae.getComponent().getParent();
		ErrorHelpUtil.validate(input, input.getId(), getErrorMap());
	}

	public void validator_prodCodeTo(FacesContext context, UIComponent component,Object value) 
	throws ValidatorException,ParseException {
		if(getCOMP_FAS_PROD_CODE_FM().getSubmittedValue()!=null && getCOMP_FAS_PROD_CODE_TO().getSubmittedValue()!=null){
			L_VAL_FROM_TO(getCOMP_FAS_PROD_CODE_FM(), getCOMP_FAS_PROD_CODE_TO());
		}
	}

	public List<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN> getFundCodeFromTo(Object obj) throws Exception{
		return  PM_IL_FUND_ACCOUNT_SETUP_DELEGATE_METHOD.getFAS_FUND_CODE_FM_TO(this, obj);
	}

	public void fundCodeFromwhenValidate(ActionEvent ae){
		String M_FIELD_DATA="", M_DATA_TYPE=getCOMP_FAS_FUND_CODE_FM().getSubmittedValue().getClass().getSimpleName();
		if("".equalsIgnoreCase((String) getCOMP_FAS_FUND_CODE_FM().getSubmittedValue())){
			if(M_DATA_TYPE.equalsIgnoreCase("String") || M_DATA_TYPE.equalsIgnoreCase("Integer")){
				M_FIELD_DATA="0";
			}
			getCOMP_FAS_FUND_CODE_FM().setSubmittedValue("0");
		}
		if(!M_DATA_TYPE.equalsIgnoreCase("Date")){
			getCOMP_FAS_FUND_CODE_TO().setSubmittedValue(getCOMP_FAS_FUND_CODE_TO().getSubmittedValue());
		}
		UIInput input = (UIInput) ae.getComponent().getParent();
		ErrorHelpUtil.validate(input, input.getId(), getErrorMap());
	}

	public void validator_fundCodeFrom(FacesContext context, UIComponent component,Object value) 
	throws ValidatorException,ParseException {
		if(getCOMP_FAS_FUND_CODE_FM().getSubmittedValue()!=null && getCOMP_FAS_FUND_CODE_TO().getSubmittedValue()!=null){
			L_VAL_FROM_TO(getCOMP_FAS_FUND_CODE_FM(), getCOMP_FAS_FUND_CODE_TO());
		}
	}

	public void fundCodeTowhenValidate(ActionEvent ae){
		int M_FIELD_LENGTH=0;
		String M_FIELD_DATA="", M_FIELD_DATA_1="", M_DATA_TYPE=getCOMP_FAS_FUND_CODE_FM().getSubmittedValue().getClass().getSimpleName();
		if("".equalsIgnoreCase(getCOMP_FAS_FUND_CODE_TO().getSubmittedValue().toString())){
			attributes=getCOMP_FAS_FUND_CODE_FM().getAttributes();
			M_FIELD_LENGTH = ((Integer)attributes.get("maxlength"));
			if(M_DATA_TYPE.equalsIgnoreCase("String") || M_DATA_TYPE.equalsIgnoreCase("Integer")){
				System.out.println("In if state 111111111");
				M_FIELD_DATA="0";
			}
			if(M_DATA_TYPE.equalsIgnoreCase("String")){
				if(getCOMP_FAS_FUND_CODE_FM().getSubmittedValue().toString().equalsIgnoreCase(M_FIELD_DATA)){
					System.out.println("In if 222222222222");
					M_FIELD_DATA= "zzzzzzzzzzzzzzzzzzzzzz".substring(0, M_FIELD_LENGTH);
					getCOMP_FAS_FUND_CODE_TO().setSubmittedValue(M_FIELD_DATA);
				}else{
					if(M_DATA_TYPE.equalsIgnoreCase("String")){
						getCOMP_FAS_FUND_CODE_TO().setSubmittedValue(getCOMP_FAS_FUND_CODE_FM().getSubmittedValue());
					}
				}
			}else{
				if(M_DATA_TYPE.equalsIgnoreCase("Integer")){
					if(getCOMP_FAS_FUND_CODE_FM().getSubmittedValue()==M_FIELD_DATA){
						M_FIELD_DATA="9999999999999999999999".substring(0, M_FIELD_LENGTH);
						getCOMP_FAS_FUND_CODE_TO().setSubmittedValue(M_FIELD_DATA);
					}else{
						getCOMP_FAS_FUND_CODE_TO().setSubmittedValue(getCOMP_FAS_FUND_CODE_FM().getSubmittedValue());
					}
				}
			}
		}
		UIInput input = (UIInput) ae.getComponent().getParent();
		ErrorHelpUtil.validate(input, input.getId(), getErrorMap());
	}

	public void validator_fundCodeTo(FacesContext context, UIComponent component,Object value) 
	throws ValidatorException,ParseException {
		if(getCOMP_FAS_FUND_CODE_FM().getSubmittedValue()!=null && getCOMP_FAS_FUND_CODE_TO().getSubmittedValue()!=null){
			L_VAL_FROM_TO(getCOMP_FAS_FUND_CODE_FM(), getCOMP_FAS_FUND_CODE_TO());
		}
	}

	
	public void actionFAS_POL_YR_FM(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		getErrorMap().clear();
		if (inputValue.isEmpty()) {
			getCOMP_FAS_POL_YR_FM().setSubmittedValue("0");
			PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_POL_YR_FM(0);
		} else {
			PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_POL_YR_FM(Integer
					.parseInt(inputValue));

		}

		if (inputValue != null && !inputValue.isEmpty()) {
			Integer yrsFm = PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_POL_YR_FM();
			Integer yrsTo = PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_POL_YR_TO();
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

	public void actionCACS_YRS_TO(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		Integer yrsFm = PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_POL_YR_FM();
		if (inputValue.isEmpty()) {
			if (yrsFm != 0) {
				getCOMP_FAS_POL_YR_TO().setSubmittedValue(yrsFm.toString());
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_POL_YR_TO(yrsFm);
			} else {
				getCOMP_FAS_POL_YR_TO().setSubmittedValue("99");
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_POL_YR_TO(Integer
						.parseInt("9999"));
			}
		} 
	}
	
	public void validator_policyYearsFrom(FacesContext context, UIComponent component,Object value) 
	throws ValidatorException,ParseException {
		PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_POL_YR_FM((Integer) value);
		if(PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_POL_YR_FM() != null && PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_POL_YR_TO() != null){
			try{
				if(PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_POL_YR_FM() < 0){
					throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91018"));
				}
				if(PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_POL_YR_TO() < PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_POL_YR_FM()){
					throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91031"));
				}

			}catch(NumberFormatException e){
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	

	public void validator_policyYearsTo(FacesContext context, UIComponent component,Object value) 
	throws ValidatorException,ParseException {
		PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_POL_YR_TO((Integer) value);
		if(PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_POL_YR_FM() !=null && PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_POL_YR_TO() !=null){
			try{
				if(PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_POL_YR_TO() < 0){
					throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91018"));
				}
				if(PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_POL_YR_TO() < PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_POL_YR_FM()){
					throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91032"));
				}
			}catch(NumberFormatException e){
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void seqNowhenValidate(ActionEvent ae){
		UIInput input = (UIInput) ae.getComponent().getParent();
		ErrorHelpUtil.validate(input, input.getId(), getErrorMap());
	}

	public void validator_sequenceNo(FacesContext context, UIComponent component,Object value) 
	throws ValidatorException,ParseException, Exception {
		PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_SEQ_NO((Long) value);
		if(PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_SEQ_NO() != null){
			try{
				helper.L_CHECK_SEQ_NO(this);
			}catch(ValidatorException ve){
				getErrorMap().put("current", ve.getFacesMessage().getSummary());
				throw ve;
			}catch(Exception e){
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	

	public List<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN> getNarration(Object obj) throws Exception{
		return  PM_IL_FUND_ACCOUNT_SETUP_DELEGATE_METHOD.getFAS_NARRATION_CODE(this, obj);
	}

	public List<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN> getMainAccount(Object obj) throws Exception{
		return  PM_IL_FUND_ACCOUNT_SETUP_DELEGATE_METHOD.getFAS_MAIN_ACNT_CODE(this, obj);
	}

	public void validatorFAS_MAIN_ACNT_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_MAIN_ACNT_CODE((String) value);
			helper.mainAccountValidation(this);
			COMP_UI_M_MAIN_ACNT_NAME.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorFAS_SUB_ACNT_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_SUB_ACNT_CODE((String) value);
			helper.subAccountValidation(this);
			COMP_UI_M_SUB_ACNT_NAME.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorFAS_DIVN_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_DIVN_CODE((String) value);
			PM_IL_FUND_ACCOUNT_SETUP_DELEGATE_METHOD.branchValidation(this);
			COMP_UI_M_DIVN_NAME.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorFAS_DEPT_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_DEPT_CODE((String) value);
			PM_IL_FUND_ACCOUNT_SETUP_DELEGATE_METHOD.departmentValidation(this);
			COMP_UI_M_DEPT_NAME.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorFAS_ANLY_CODE_1(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_ANLY_CODE_1((String) value);
			PM_IL_FUND_ACCOUNT_SETUP_DELEGATE_METHOD.analysisCode1Validation(this);
			COMP_UI_M_ANLY_NAME.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorFAS_ANLY_CODE_2(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_ANLY_CODE_2((String) value);
			PM_IL_FUND_ACCOUNT_SETUP_DELEGATE_METHOD.analysisCode2Validation(this);
			COMP_UI_M_ANLY_NAME_1.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorFAS_FORCE_DEPT_YN(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_FORCE_DEPT_YN((String) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorFAS_ACTY_CODE_1(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_ACTY_CODE_1((String) value);
			helper.when_validate_item_FAS_ACTY_CODE_1(PM_IL_FUND_ACCOUNT_SETUP_BEAN);
			COMP_UI_M_ACTY_NAME.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorFAS_ACTY_CODE_2(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_ACTY_CODE_2((String) value);
			helper.when_validate_item_FAS_ACTY_CODE_2(PM_IL_FUND_ACCOUNT_SETUP_BEAN);
			COMP_UI_M_ACTY_NAME_1.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public List<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN> getSubAccount(Object obj) throws Exception{
		return  PM_IL_FUND_ACCOUNT_SETUP_DELEGATE_METHOD.getFAS_SUB_ACNT_CODE(this, obj);
	}

	public List<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN> getBranch(Object obj) throws Exception{
		return  PM_IL_FUND_ACCOUNT_SETUP_DELEGATE_METHOD.getFAS_BRANCH(this, obj);
	}
	
	public List<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN> getAnlyCode1(Object obj) throws Exception{
		return  PM_IL_FUND_ACCOUNT_SETUP_DELEGATE_METHOD.getFAS_ANLY_CODE_1(this, obj);
	}

	

	public List<PM_IL_FUND_ACCOUNT_SETUP_LOV_BEAN> getAnlyCode2(Object obj) throws Exception{
		return  PM_IL_FUND_ACCOUNT_SETUP_DELEGATE_METHOD.getFAS_ANLY_CODE_2(this, obj);
	}


	public void saveRecord(ActionEvent ae) throws Exception {
		String message = null;
		try {
			if (getPM_IL_FUND_ACCOUNT_SETUP_BEAN().getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					helper.preUpdate(this);
					new CRUDHandler().executeInsert(
							PM_IL_FUND_ACCOUNT_SETUP_BEAN, CommonUtils
									.getConnection());
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
					helper.preInsert(this);
					new CRUDHandler().executeInsert(
							PM_IL_FUND_ACCOUNT_SETUP_BEAN, CommonUtils
									.getConnection());
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
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public String delete(ActionEvent event) {
		getErrorMap().clear();
		CRUDHandler handler = new CRUDHandler();
		try {
			handler.executeDelete(PM_IL_FUND_ACCOUNT_SETUP_BEAN,
					CommonUtils.getConnection());
			CommonUtils.getConnection().commit();
			PM_IL_FUND_ACCOUNT_SETUP_BEAN = new PM_IL_FUND_ACCOUNT_SETUP();
			resetAllComponent();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record Deleted Successfully");
		} catch (Exception er) {
			er.printStackTrace();
		}
		return "";
	}

	public String back(){
		return PM_IL_FUND_ACCOUNT_SETUP_DELEGATE_METHOD.backToSearch();
	}

	public CRUDHandler getHandler(){
		return new CRUDHandler();
	}

	public HtmlCommandButton getPREFORMBUTTON() {
		return PREFORMBUTTON;
	}

	public void setPREFORMBUTTON(HtmlCommandButton preformbutton) {
		PREFORMBUTTON = preformbutton;
	}

	
	
	public void FAS_FORCE_DIVN_YN_WHEN_VALIDATE_ITEM(FacesContext context,UIComponent component,Object value){
		PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_FORCE_DIVN_YN((String) value);
		if("Y".equals(PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_FORCE_DIVN_YN())){
			getCOMP_FAS_DIVN_CODE().setDisabled(true);
			getCOMP_FAS_DIVN_CODE().setRequired(false);
		}else{
			getCOMP_FAS_DIVN_CODE().setDisabled(false);
			getCOMP_FAS_DIVN_CODE().setRequired(true);
		}
		PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_FORCE_DEPT_YN(PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_FORCE_DIVN_YN());
		FAS_FORCE_DEPT_YN_WHEN_LIST_CHANGED(PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_FORCE_DIVN_YN());
	}
	
	public void FAS_FORCE_DEPT_YN_WHEN_LIST_CHANGED(String value){
		if(value.equals("Y")){
			getCOMP_FAS_DEPT_CODE().setDisabled(true);
			getCOMP_FAS_DEPT_CODE().setRequired(false);
		}else{
			getCOMP_FAS_DEPT_CODE().setDisabled(false);
			getCOMP_FAS_DEPT_CODE().setRequired(true);
		}
	}
	
	public void onLoad(PhaseEvent event){
		PM_IL_FUND_ACCOUNT_SETUP_DELEGATE delegate = new PM_IL_FUND_ACCOUNT_SETUP_DELEGATE();
		try{
			if(isBlockFlag()){
			delegate.executeSelectStatement(this);
			if(PM_IL_FUND_ACCOUNT_SETUP_BEAN.getROWID() != null){
				COMP_FAS_SEQ_NO.setDisabled(true);
				helper.postQuery(PM_IL_FUND_ACCOUNT_SETUP_BEAN);
				}else{
					helper.when_craete_record(this);
				}
				helper.when_new_record_instance(this);
				setBlockFlag(false);
			}
		}catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
    }

	public List<SelectItem> getListFAS_SETUP_FOR() {
		return listFAS_SETUP_FOR;
	}

	public void setListFAS_SETUP_FOR(List<SelectItem> listFAS_SETUP_FOR) {
		this.listFAS_SETUP_FOR = listFAS_SETUP_FOR;
	}

	public List<SelectItem> getListFAS_DRCR_FLAG() {
		return listFAS_DRCR_FLAG;
	}

	public void setListFAS_DRCR_FLAG(List<SelectItem> listFAS_DRCR_FLAG) {
		this.listFAS_DRCR_FLAG = listFAS_DRCR_FLAG;
	}

	public List<SelectItem> getListFAS_FORCE_DIVN_YN() {
		return listFAS_FORCE_DIVN_YN;
	}

	public void setListFAS_FORCE_DIVN_YN(List<SelectItem> listFAS_FORCE_DIVN_YN) {
		this.listFAS_FORCE_DIVN_YN = listFAS_FORCE_DIVN_YN;
	}

	public List<SelectItem> getListFAS_FORCE_DEPT_YN() {
		return listFAS_FORCE_DEPT_YN;
	}

	public void setListFAS_FORCE_DEPT_YN(List<SelectItem> listFAS_FORCE_DEPT_YN) {
		this.listFAS_FORCE_DEPT_YN = listFAS_FORCE_DEPT_YN;
	}
	
	public List<LovBean> lovFAS_ACTY_CODE_1(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM061_APAC",
					"PM_IL_FUND_ACCOUNT_SETUP", "FAS_ACTY_CODE_1",
					PM_IL_FUND_ACCOUNT_SETUP_BEAN.getUI_M_ACTY_HEAD_1(), null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovFAS_ACTY_CODE_2(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM061_APAC",
					"PM_IL_FUND_ACCOUNT_SETUP", "FAS_ACTY_CODE_2",
					PM_IL_FUND_ACCOUNT_SETUP_BEAN.getUI_M_ACTY_HEAD_2(), null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	/**
	 * Resets all components in PM_IL_FUND_ACCOUNT_SETUP_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_FAS_SRC_BUS_FM.resetValue();
		COMP_FAS_SRC_BUS_TO.resetValue();
		COMP_FAS_DIVN_FM_CODE.resetValue();
		COMP_FAS_DIVN_TO_CODE.resetValue();
		COMP_FAS_DEPT_FM_CODE.resetValue();
		COMP_FAS_DEPT_TO_CODE.resetValue();
		COMP_FAS_DOC_FM_TYPE.resetValue();
		COMP_FAS_DOC_TO_TYPE.resetValue();
		COMP_FAS_PROD_CODE_FM.resetValue();
		COMP_FAS_PROD_CODE_TO.resetValue();
		COMP_FAS_FUND_CODE_FM.resetValue();
		COMP_FAS_FUND_CODE_TO.resetValue();
		COMP_FAS_POL_YR_FM.resetValue();
		COMP_FAS_POL_YR_TO.resetValue();
		COMP_FAS_SEQ_NO.resetValue();
		COMP_FAS_NARRATION_CODE.resetValue();
		COMP_FAS_MAIN_ACNT_CODE.resetValue();
		COMP_UI_M_MAIN_ACNT_NAME.resetValue();
		COMP_FAS_SUB_ACNT_CODE.resetValue();
		COMP_UI_M_SUB_ACNT_NAME.resetValue();
		COMP_FAS_DIVN_CODE.resetValue();
		COMP_UI_M_DIVN_NAME.resetValue();
		COMP_FAS_DEPT_CODE.resetValue();
		COMP_UI_M_DEPT_NAME.resetValue();
		COMP_FAS_ANLY_CODE_1.resetValue();
		COMP_UI_M_ANLY_NAME.resetValue();
		COMP_FAS_ANLY_CODE_2.resetValue();
		COMP_UI_M_ANLY_NAME_1.resetValue();
		COMP_FAS_ACTY_CODE_1.resetValue();
		COMP_UI_M_ACTY_NAME.resetValue();
		COMP_FAS_ACTY_CODE_2.resetValue();
		COMP_UI_M_ACTY_NAME_1.resetValue();

		// Reseting HtmlSelectOneMenu
		COMP_FAS_SETUP_FOR.resetValue();
		COMP_FAS_DRCR_FLAG.resetValue();
		COMP_FAS_FORCE_DIVN_YN.resetValue();
		COMP_FAS_FORCE_DEPT_YN.resetValue();

	}

}

