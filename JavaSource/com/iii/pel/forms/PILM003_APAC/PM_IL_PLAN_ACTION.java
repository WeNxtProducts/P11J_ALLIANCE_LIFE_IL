package com.iii.pel.forms.PILM003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_PLAN_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PLAN_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_PLAN_FRZ_FLAG;

	private HtmlOutputLabel COMP_PLAN_CODE_LABEL;

	private HtmlInputText COMP_PLAN_CODE;

	private HtmlOutputLabel COMP_UI_M_PLAN_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PLAN_DESC;

	private HtmlOutputLabel COMP_PLAN_TYPE_LABEL;

	private HtmlInputText COMP_PLAN_TYPE;

	private HtmlOutputLabel COMP_UI_M_PLAN_TYPE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PLAN_TYPE_DESC;

	private HtmlOutputLabel COMP_PLAN_AGE_TERM_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_PLAN_AGE_TERM_FLAG;

	private HtmlOutputLabel COMP_PLAN_PERIOD_FROM_LABEL;

	private HtmlInputText COMP_PLAN_PERIOD_FROM;

	private HtmlOutputLabel COMP_PLAN_PERIOD_TO_LABEL;

	private HtmlInputText COMP_PLAN_PERIOD_TO;

	private HtmlOutputLabel COMP_PLAN_AGE_FROM_LABEL;

	private HtmlInputText COMP_PLAN_AGE_FROM;

	private HtmlOutputLabel COMP_PLAN_AGE_TO_LABEL;

	private HtmlInputText COMP_PLAN_AGE_TO;

	private HtmlOutputLabel COMP_PLAN_MIN_SA_LABEL;

	private HtmlInputText COMP_PLAN_MIN_SA;

	private HtmlOutputLabel COMP_PLAN_MAX_SA_LABEL;

	private HtmlInputText COMP_PLAN_MAX_SA;

	private HtmlOutputLabel COMP_PLAN_PYMT_ON_MAT_YN_LABEL;

	private HtmlSelectOneMenu COMP_PLAN_PYMT_ON_MAT_YN;

	private HtmlOutputLabel COMP_PLAN_SA_INST_PYMT_YN_LABEL;

	private HtmlSelectOneMenu COMP_PLAN_SA_INST_PYMT_YN;

	private HtmlOutputLabel COMP_PLAN_SURR_YN_LABEL;

	private HtmlSelectOneMenu COMP_PLAN_SURR_YN;

	private HtmlOutputLabel COMP_PLAN_SURR_YRS_LABEL;

	private HtmlInputText COMP_PLAN_SURR_YRS;

	private HtmlOutputLabel COMP_PLAN_LOAN_YN_LABEL;

	private HtmlSelectOneMenu COMP_PLAN_LOAN_YN;

	private HtmlOutputLabel COMP_PLAN_REBATE_YN_LABEL;

	private HtmlSelectOneMenu COMP_PLAN_REBATE_YN;

	private HtmlOutputLabel COMP_PLAN_MAX_AGE_ON_MAT_LABEL;

	private HtmlInputText COMP_PLAN_MAX_AGE_ON_MAT;

	private HtmlOutputLabel COMP_PLAN_POL_VALID_AFTER_MAT_YN_LABEL;

	private HtmlSelectOneMenu COMP_PLAN_POL_VALID_AFTER_MAT_YN;

	private HtmlOutputLabel COMP_PLAN_MIN_AGE_ON_MAT_LABEL;

	private HtmlInputText COMP_PLAN_MIN_AGE_ON_MAT;

	private HtmlOutputLabel COMP_PLAN_REVIVAL_YN_LABEL;

	private HtmlSelectOneMenu COMP_PLAN_REVIVAL_YN;

	private HtmlOutputLabel COMP_PLAN_REVIVAL_YRS_LABEL;

	private HtmlInputText COMP_PLAN_REVIVAL_YRS;

	private HtmlOutputLabel COMP_PLAN_SPL_REVIVAL_YN_LABEL;

	private HtmlSelectOneMenu COMP_PLAN_SPL_REVIVAL_YN;

	private HtmlOutputLabel COMP_PLAN_SPL_REVIVAL_YRS_LABEL;

	private HtmlInputText COMP_PLAN_SPL_REVIVAL_YRS;

	private HtmlOutputLabel COMP_PLAN_RED_SA_BASIS_LABEL;

	private HtmlSelectOneMenu COMP_PLAN_RED_SA_BASIS;

	private HtmlOutputLabel COMP_PLAN_CALC_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_PLAN_CALC_TYPE;
	
	private HtmlCommandButton COMP_UI_M_BUT_COPY;
	
	//committed by Dhinesh for SSP call id FALCONQC-1714734
	private HtmlInputText COMP_PLAN_LOAN_PER;
	
	private HtmlOutputLabel COMP_PLAN_PLAN_LOAN_PER_LABEL;
	
	public HtmlInputText getCOMP_PLAN_LOAN_PER() {
		return COMP_PLAN_LOAN_PER;
	}
    public void setCOMP_PLAN_LOAN_PER(HtmlInputText cOMP_PLAN_LOAN_PER) {
		COMP_PLAN_LOAN_PER = cOMP_PLAN_LOAN_PER;
	}
	public HtmlOutputLabel getCOMP_PLAN_PLAN_LOAN_PER_LABEL() {
		return COMP_PLAN_PLAN_LOAN_PER_LABEL;
	}
	public void setCOMP_PLAN_PLAN_LOAN_PER_LABEL(
			HtmlOutputLabel cOMP_PLAN_PLAN_LOAN_PER_LABEL) {
		COMP_PLAN_PLAN_LOAN_PER_LABEL = cOMP_PLAN_PLAN_LOAN_PER_LABEL;
	}

	//END SSP call id FALCONQC-1714734

	private PM_IL_PLAN PM_IL_PLAN_BEAN;
	

	public PILM003_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_PLAN_HELPER helper;
	
	private List<LovBean> lovList = new ArrayList<LovBean>();

	private List<SelectItem> listPLAN_AGE_TERM_FLAG = new ArrayList<SelectItem>();

	private List<SelectItem> listPLAN_PYMT_ON_MAT_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPLAN_SA_INST_PYMT_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPLAN_SURR_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPLAN_LOAN_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPLAN_REBATE_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPLAN_POL_VALID_AFTER_MAT_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPLAN_REVIVAL_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPLAN_SPL_REVIVAL_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPLAN_RED_SA_BASIS = new ArrayList<SelectItem>();

	private List<SelectItem> listPLAN_CALC_TYPE = new ArrayList<SelectItem>();

	public PM_IL_PLAN_ACTION() {

		PM_IL_PLAN_BEAN = new PM_IL_PLAN();
		helper = new PM_IL_PLAN_HELPER();
		prepareDropDownList();
		COMP_PLAN_AGE_TERM_FLAG=new HtmlSelectOneMenu();
	}
	
	
	//for dropdown value..
	public void prepareDropDownList(){
		Connection connection;
		try{
			connection = CommonUtils.getConnection();
			listPLAN_AGE_TERM_FLAG = ListItemUtil.getDropDownListValue(
					connection, "PILM003_APAC", "PM_IL_PLAN",
					"PM_IL_PLAN.PLAN_AGE_TERM_FLAG", "AGE_TERM");
			listPLAN_PYMT_ON_MAT_YN = ListItemUtil.getDropDownListValue(
					connection, "PILM003_APAC", "PM_IL_PLAN",
					"PM_IL_PLAN.PLAN_PYMT_ON_MAT_YN", "YESNO");
			listPLAN_SA_INST_PYMT_YN = ListItemUtil.getDropDownListValue(
					connection, "PILM003_APAC", "PM_IL_PLAN",
					"PM_IL_PLAN.PLAN_SA_INST_PYMT_YN", "YESNO");

			listPLAN_SURR_YN = ListItemUtil.getDropDownListValue(connection,
					"PILM003_APAC", "PM_IL_PLAN", "PM_IL_PLAN.PLAN_SURR_YN",
					"YESNO");

			listPLAN_LOAN_YN = ListItemUtil.getDropDownListValue(connection,
					"PILM003_APAC", "PM_IL_PLAN", "PM_IL_PLAN.PLAN_LOAN_YN",
					"YESNO");
			listPLAN_REBATE_YN = ListItemUtil.getDropDownListValue(connection,
					"PILM003_APAC", "PM_IL_PLAN", "PM_IL_PLAN.PLAN_REBATE_YN",
					"YESNO");
			listPLAN_POL_VALID_AFTER_MAT_YN = ListItemUtil
					.getDropDownListValue(connection, "PILM003_APAC",
							"PM_IL_PLAN",
							"PM_IL_PLAN.PLAN_POL_VALID_AFTER_MAT_YN", "YESNO");
			listPLAN_REVIVAL_YN = ListItemUtil.getDropDownListValue(connection,
					"PILM003_APAC", "PM_IL_PLAN", "PM_IL_PLAN.PLAN_REVIVAL_YN",
					"YESNO");
			listPLAN_SPL_REVIVAL_YN = ListItemUtil.getDropDownListValue(
					connection, "PILM003_APAC", "PM_IL_PLAN",
					"PM_IL_PLAN.PLAN_SPL_REVIVAL_YN", "YESNO");
			listPLAN_RED_SA_BASIS = ListItemUtil.getDropDownListValue(
					connection, "PILM003_APAC", "PM_IL_PLAN",
					"PM_IL_PLAN.PLAN_RED_SA_BASIS", "SABASIS");
			listPLAN_CALC_TYPE = ListItemUtil.getDropDownListValue(connection,
					"PILM003_APAC", "PM_IL_PLAN", "PM_IL_PLAN.PLAN_CALC_TYPE",
					"YESNO");
			
			
			
		}catch (DBException e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("prepareDropDownList", e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_PLAN_FRZ_FLAG_LABEL() {
		return COMP_PLAN_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_PLAN_FRZ_FLAG() {
		return COMP_PLAN_FRZ_FLAG;
	}

	public void setCOMP_PLAN_FRZ_FLAG_LABEL(
			HtmlOutputLabel COMP_PLAN_FRZ_FLAG_LABEL) {
		this.COMP_PLAN_FRZ_FLAG_LABEL = COMP_PLAN_FRZ_FLAG_LABEL;
	}

	public void setCOMP_PLAN_FRZ_FLAG(
			HtmlSelectBooleanCheckbox COMP_PLAN_FRZ_FLAG) {
		this.COMP_PLAN_FRZ_FLAG = COMP_PLAN_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_PLAN_CODE_LABEL() {
		return COMP_PLAN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PLAN_CODE() {
		return COMP_PLAN_CODE;
	}

	public void setCOMP_PLAN_CODE_LABEL(HtmlOutputLabel COMP_PLAN_CODE_LABEL) {
		this.COMP_PLAN_CODE_LABEL = COMP_PLAN_CODE_LABEL;
	}

	public void setCOMP_PLAN_CODE(HtmlInputText COMP_PLAN_CODE) {
		this.COMP_PLAN_CODE = COMP_PLAN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PLAN_DESC_LABEL() {
		return COMP_UI_M_PLAN_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PLAN_DESC() {
		return COMP_UI_M_PLAN_DESC;
	}

	public void setCOMP_UI_M_PLAN_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PLAN_DESC_LABEL) {
		this.COMP_UI_M_PLAN_DESC_LABEL = COMP_UI_M_PLAN_DESC_LABEL;
	}

	public void setCOMP_UI_M_PLAN_DESC(HtmlInputText COMP_UI_M_PLAN_DESC) {
		this.COMP_UI_M_PLAN_DESC = COMP_UI_M_PLAN_DESC;
	}

	public HtmlOutputLabel getCOMP_PLAN_TYPE_LABEL() {
		return COMP_PLAN_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_PLAN_TYPE() {
		return COMP_PLAN_TYPE;
	}

	public void setCOMP_PLAN_TYPE_LABEL(HtmlOutputLabel COMP_PLAN_TYPE_LABEL) {
		this.COMP_PLAN_TYPE_LABEL = COMP_PLAN_TYPE_LABEL;
	}

	public void setCOMP_PLAN_TYPE(HtmlInputText COMP_PLAN_TYPE) {
		this.COMP_PLAN_TYPE = COMP_PLAN_TYPE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PLAN_TYPE_DESC_LABEL() {
		return COMP_UI_M_PLAN_TYPE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PLAN_TYPE_DESC() {
		return COMP_UI_M_PLAN_TYPE_DESC;
	}

	public void setCOMP_UI_M_PLAN_TYPE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PLAN_TYPE_DESC_LABEL) {
		this.COMP_UI_M_PLAN_TYPE_DESC_LABEL = COMP_UI_M_PLAN_TYPE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PLAN_TYPE_DESC(
			HtmlInputText COMP_UI_M_PLAN_TYPE_DESC) {
		this.COMP_UI_M_PLAN_TYPE_DESC = COMP_UI_M_PLAN_TYPE_DESC;
	}

	public HtmlOutputLabel getCOMP_PLAN_AGE_TERM_FLAG_LABEL() {
		return COMP_PLAN_AGE_TERM_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PLAN_AGE_TERM_FLAG() {
		return COMP_PLAN_AGE_TERM_FLAG;
	}

	public void setCOMP_PLAN_AGE_TERM_FLAG_LABEL(
			HtmlOutputLabel COMP_PLAN_AGE_TERM_FLAG_LABEL) {
		this.COMP_PLAN_AGE_TERM_FLAG_LABEL = COMP_PLAN_AGE_TERM_FLAG_LABEL;
	}

	public void setCOMP_PLAN_AGE_TERM_FLAG(
			HtmlSelectOneMenu COMP_PLAN_AGE_TERM_FLAG) {
		this.COMP_PLAN_AGE_TERM_FLAG = COMP_PLAN_AGE_TERM_FLAG;
	}

	public HtmlOutputLabel getCOMP_PLAN_PERIOD_FROM_LABEL() {
		return COMP_PLAN_PERIOD_FROM_LABEL;
	}

	public HtmlInputText getCOMP_PLAN_PERIOD_FROM() {
		return COMP_PLAN_PERIOD_FROM;
	}

	public void setCOMP_PLAN_PERIOD_FROM_LABEL(
			HtmlOutputLabel COMP_PLAN_PERIOD_FROM_LABEL) {
		this.COMP_PLAN_PERIOD_FROM_LABEL = COMP_PLAN_PERIOD_FROM_LABEL;
	}

	public void setCOMP_PLAN_PERIOD_FROM(HtmlInputText COMP_PLAN_PERIOD_FROM) {
		this.COMP_PLAN_PERIOD_FROM = COMP_PLAN_PERIOD_FROM;
	}

	public HtmlOutputLabel getCOMP_PLAN_PERIOD_TO_LABEL() {
		return COMP_PLAN_PERIOD_TO_LABEL;
	}

	public HtmlInputText getCOMP_PLAN_PERIOD_TO() {
		return COMP_PLAN_PERIOD_TO;
	}

	public void setCOMP_PLAN_PERIOD_TO_LABEL(
			HtmlOutputLabel COMP_PLAN_PERIOD_TO_LABEL) {
		this.COMP_PLAN_PERIOD_TO_LABEL = COMP_PLAN_PERIOD_TO_LABEL;
	}

	public void setCOMP_PLAN_PERIOD_TO(HtmlInputText COMP_PLAN_PERIOD_TO) {
		this.COMP_PLAN_PERIOD_TO = COMP_PLAN_PERIOD_TO;
	}

	public HtmlOutputLabel getCOMP_PLAN_AGE_FROM_LABEL() {
		return COMP_PLAN_AGE_FROM_LABEL;
	}

	public HtmlInputText getCOMP_PLAN_AGE_FROM() {
		return COMP_PLAN_AGE_FROM;
	}

	public void setCOMP_PLAN_AGE_FROM_LABEL(
			HtmlOutputLabel COMP_PLAN_AGE_FROM_LABEL) {
		this.COMP_PLAN_AGE_FROM_LABEL = COMP_PLAN_AGE_FROM_LABEL;
	}

	public void setCOMP_PLAN_AGE_FROM(HtmlInputText COMP_PLAN_AGE_FROM) {
		this.COMP_PLAN_AGE_FROM = COMP_PLAN_AGE_FROM;
	}

	public HtmlOutputLabel getCOMP_PLAN_AGE_TO_LABEL() {
		return COMP_PLAN_AGE_TO_LABEL;
	}

	public HtmlInputText getCOMP_PLAN_AGE_TO() {
		return COMP_PLAN_AGE_TO;
	}

	public void setCOMP_PLAN_AGE_TO_LABEL(HtmlOutputLabel COMP_PLAN_AGE_TO_LABEL) {
		this.COMP_PLAN_AGE_TO_LABEL = COMP_PLAN_AGE_TO_LABEL;
	}

	public void setCOMP_PLAN_AGE_TO(HtmlInputText COMP_PLAN_AGE_TO) {
		this.COMP_PLAN_AGE_TO = COMP_PLAN_AGE_TO;
	}

	public HtmlOutputLabel getCOMP_PLAN_MIN_SA_LABEL() {
		return COMP_PLAN_MIN_SA_LABEL;
	}

	public HtmlInputText getCOMP_PLAN_MIN_SA() {
		return COMP_PLAN_MIN_SA;
	}

	public void setCOMP_PLAN_MIN_SA_LABEL(HtmlOutputLabel COMP_PLAN_MIN_SA_LABEL) {
		this.COMP_PLAN_MIN_SA_LABEL = COMP_PLAN_MIN_SA_LABEL;
	}

	public void setCOMP_PLAN_MIN_SA(HtmlInputText COMP_PLAN_MIN_SA) {
		this.COMP_PLAN_MIN_SA = COMP_PLAN_MIN_SA;
	}

	public HtmlOutputLabel getCOMP_PLAN_MAX_SA_LABEL() {
		return COMP_PLAN_MAX_SA_LABEL;
	}

	public HtmlInputText getCOMP_PLAN_MAX_SA() {
		return COMP_PLAN_MAX_SA;
	}

	public void setCOMP_PLAN_MAX_SA_LABEL(HtmlOutputLabel COMP_PLAN_MAX_SA_LABEL) {
		this.COMP_PLAN_MAX_SA_LABEL = COMP_PLAN_MAX_SA_LABEL;
	}

	public void setCOMP_PLAN_MAX_SA(HtmlInputText COMP_PLAN_MAX_SA) {
		this.COMP_PLAN_MAX_SA = COMP_PLAN_MAX_SA;
	}

	public HtmlOutputLabel getCOMP_PLAN_PYMT_ON_MAT_YN_LABEL() {
		return COMP_PLAN_PYMT_ON_MAT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PLAN_PYMT_ON_MAT_YN() {
		return COMP_PLAN_PYMT_ON_MAT_YN;
	}

	public void setCOMP_PLAN_PYMT_ON_MAT_YN_LABEL(
			HtmlOutputLabel COMP_PLAN_PYMT_ON_MAT_YN_LABEL) {
		this.COMP_PLAN_PYMT_ON_MAT_YN_LABEL = COMP_PLAN_PYMT_ON_MAT_YN_LABEL;
	}

	public void setCOMP_PLAN_PYMT_ON_MAT_YN(
			HtmlSelectOneMenu COMP_PLAN_PYMT_ON_MAT_YN) {
		this.COMP_PLAN_PYMT_ON_MAT_YN = COMP_PLAN_PYMT_ON_MAT_YN;
	}

	public HtmlOutputLabel getCOMP_PLAN_SA_INST_PYMT_YN_LABEL() {
		return COMP_PLAN_SA_INST_PYMT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PLAN_SA_INST_PYMT_YN() {
		return COMP_PLAN_SA_INST_PYMT_YN;
	}

	public void setCOMP_PLAN_SA_INST_PYMT_YN_LABEL(
			HtmlOutputLabel COMP_PLAN_SA_INST_PYMT_YN_LABEL) {
		this.COMP_PLAN_SA_INST_PYMT_YN_LABEL = COMP_PLAN_SA_INST_PYMT_YN_LABEL;
	}

	public void setCOMP_PLAN_SA_INST_PYMT_YN(
			HtmlSelectOneMenu COMP_PLAN_SA_INST_PYMT_YN) {
		this.COMP_PLAN_SA_INST_PYMT_YN = COMP_PLAN_SA_INST_PYMT_YN;
	}

	public HtmlOutputLabel getCOMP_PLAN_SURR_YN_LABEL() {
		return COMP_PLAN_SURR_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PLAN_SURR_YN() {
		return COMP_PLAN_SURR_YN;
	}

	public void setCOMP_PLAN_SURR_YN_LABEL(
			HtmlOutputLabel COMP_PLAN_SURR_YN_LABEL) {
		this.COMP_PLAN_SURR_YN_LABEL = COMP_PLAN_SURR_YN_LABEL;
	}

	public void setCOMP_PLAN_SURR_YN(HtmlSelectOneMenu COMP_PLAN_SURR_YN) {
		this.COMP_PLAN_SURR_YN = COMP_PLAN_SURR_YN;
	}

	public HtmlOutputLabel getCOMP_PLAN_SURR_YRS_LABEL() {
		return COMP_PLAN_SURR_YRS_LABEL;
	}

	public HtmlInputText getCOMP_PLAN_SURR_YRS() {
		return COMP_PLAN_SURR_YRS;
	}

	public void setCOMP_PLAN_SURR_YRS_LABEL(
			HtmlOutputLabel COMP_PLAN_SURR_YRS_LABEL) {
		this.COMP_PLAN_SURR_YRS_LABEL = COMP_PLAN_SURR_YRS_LABEL;
	}

	public void setCOMP_PLAN_SURR_YRS(HtmlInputText COMP_PLAN_SURR_YRS) {
		this.COMP_PLAN_SURR_YRS = COMP_PLAN_SURR_YRS;
	}

	public HtmlOutputLabel getCOMP_PLAN_LOAN_YN_LABEL() {
		return COMP_PLAN_LOAN_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PLAN_LOAN_YN() {
		return COMP_PLAN_LOAN_YN;
	}

	public void setCOMP_PLAN_LOAN_YN_LABEL(
			HtmlOutputLabel COMP_PLAN_LOAN_YN_LABEL) {
		this.COMP_PLAN_LOAN_YN_LABEL = COMP_PLAN_LOAN_YN_LABEL;
	}

	public void setCOMP_PLAN_LOAN_YN(HtmlSelectOneMenu COMP_PLAN_LOAN_YN) {
		this.COMP_PLAN_LOAN_YN = COMP_PLAN_LOAN_YN;
	}

	public HtmlOutputLabel getCOMP_PLAN_REBATE_YN_LABEL() {
		return COMP_PLAN_REBATE_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PLAN_REBATE_YN() {
		return COMP_PLAN_REBATE_YN;
	}

	public void setCOMP_PLAN_REBATE_YN_LABEL(
			HtmlOutputLabel COMP_PLAN_REBATE_YN_LABEL) {
		this.COMP_PLAN_REBATE_YN_LABEL = COMP_PLAN_REBATE_YN_LABEL;
	}

	public void setCOMP_PLAN_REBATE_YN(HtmlSelectOneMenu COMP_PLAN_REBATE_YN) {
		this.COMP_PLAN_REBATE_YN = COMP_PLAN_REBATE_YN;
	}

	public HtmlOutputLabel getCOMP_PLAN_MAX_AGE_ON_MAT_LABEL() {
		return COMP_PLAN_MAX_AGE_ON_MAT_LABEL;
	}

	public HtmlInputText getCOMP_PLAN_MAX_AGE_ON_MAT() {
		return COMP_PLAN_MAX_AGE_ON_MAT;
	}

	public void setCOMP_PLAN_MAX_AGE_ON_MAT_LABEL(
			HtmlOutputLabel COMP_PLAN_MAX_AGE_ON_MAT_LABEL) {
		this.COMP_PLAN_MAX_AGE_ON_MAT_LABEL = COMP_PLAN_MAX_AGE_ON_MAT_LABEL;
	}

	public void setCOMP_PLAN_MAX_AGE_ON_MAT(
			HtmlInputText COMP_PLAN_MAX_AGE_ON_MAT) {
		this.COMP_PLAN_MAX_AGE_ON_MAT = COMP_PLAN_MAX_AGE_ON_MAT;
	}

	public HtmlOutputLabel getCOMP_PLAN_POL_VALID_AFTER_MAT_YN_LABEL() {
		return COMP_PLAN_POL_VALID_AFTER_MAT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PLAN_POL_VALID_AFTER_MAT_YN() {
		return COMP_PLAN_POL_VALID_AFTER_MAT_YN;
	}

	public void setCOMP_PLAN_POL_VALID_AFTER_MAT_YN_LABEL(
			HtmlOutputLabel COMP_PLAN_POL_VALID_AFTER_MAT_YN_LABEL) {
		this.COMP_PLAN_POL_VALID_AFTER_MAT_YN_LABEL = COMP_PLAN_POL_VALID_AFTER_MAT_YN_LABEL;
	}

	public void setCOMP_PLAN_POL_VALID_AFTER_MAT_YN(
			HtmlSelectOneMenu COMP_PLAN_POL_VALID_AFTER_MAT_YN) {
		this.COMP_PLAN_POL_VALID_AFTER_MAT_YN = COMP_PLAN_POL_VALID_AFTER_MAT_YN;
	}

	public HtmlOutputLabel getCOMP_PLAN_MIN_AGE_ON_MAT_LABEL() {
		return COMP_PLAN_MIN_AGE_ON_MAT_LABEL;
	}

	public HtmlInputText getCOMP_PLAN_MIN_AGE_ON_MAT() {
		return COMP_PLAN_MIN_AGE_ON_MAT;
	}

	public void setCOMP_PLAN_MIN_AGE_ON_MAT_LABEL(
			HtmlOutputLabel COMP_PLAN_MIN_AGE_ON_MAT_LABEL) {
		this.COMP_PLAN_MIN_AGE_ON_MAT_LABEL = COMP_PLAN_MIN_AGE_ON_MAT_LABEL;
	}

	public void setCOMP_PLAN_MIN_AGE_ON_MAT(
			HtmlInputText COMP_PLAN_MIN_AGE_ON_MAT) {
		this.COMP_PLAN_MIN_AGE_ON_MAT = COMP_PLAN_MIN_AGE_ON_MAT;
	}

	public HtmlOutputLabel getCOMP_PLAN_REVIVAL_YN_LABEL() {
		return COMP_PLAN_REVIVAL_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PLAN_REVIVAL_YN() {
		return COMP_PLAN_REVIVAL_YN;
	}

	public void setCOMP_PLAN_REVIVAL_YN_LABEL(
			HtmlOutputLabel COMP_PLAN_REVIVAL_YN_LABEL) {
		this.COMP_PLAN_REVIVAL_YN_LABEL = COMP_PLAN_REVIVAL_YN_LABEL;
	}

	public void setCOMP_PLAN_REVIVAL_YN(HtmlSelectOneMenu COMP_PLAN_REVIVAL_YN) {
		this.COMP_PLAN_REVIVAL_YN = COMP_PLAN_REVIVAL_YN;
	}

	public HtmlOutputLabel getCOMP_PLAN_REVIVAL_YRS_LABEL() {
		return COMP_PLAN_REVIVAL_YRS_LABEL;
	}

	public HtmlInputText getCOMP_PLAN_REVIVAL_YRS() {
		return COMP_PLAN_REVIVAL_YRS;
	}

	public void setCOMP_PLAN_REVIVAL_YRS_LABEL(
			HtmlOutputLabel COMP_PLAN_REVIVAL_YRS_LABEL) {
		this.COMP_PLAN_REVIVAL_YRS_LABEL = COMP_PLAN_REVIVAL_YRS_LABEL;
	}

	public void setCOMP_PLAN_REVIVAL_YRS(HtmlInputText COMP_PLAN_REVIVAL_YRS) {
		this.COMP_PLAN_REVIVAL_YRS = COMP_PLAN_REVIVAL_YRS;
	}

	public HtmlOutputLabel getCOMP_PLAN_SPL_REVIVAL_YN_LABEL() {
		return COMP_PLAN_SPL_REVIVAL_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PLAN_SPL_REVIVAL_YN() {
		return COMP_PLAN_SPL_REVIVAL_YN;
	}

	public void setCOMP_PLAN_SPL_REVIVAL_YN_LABEL(
			HtmlOutputLabel COMP_PLAN_SPL_REVIVAL_YN_LABEL) {
		this.COMP_PLAN_SPL_REVIVAL_YN_LABEL = COMP_PLAN_SPL_REVIVAL_YN_LABEL;
	}

	public void setCOMP_PLAN_SPL_REVIVAL_YN(
			HtmlSelectOneMenu COMP_PLAN_SPL_REVIVAL_YN) {
		this.COMP_PLAN_SPL_REVIVAL_YN = COMP_PLAN_SPL_REVIVAL_YN;
	}

	public HtmlOutputLabel getCOMP_PLAN_SPL_REVIVAL_YRS_LABEL() {
		return COMP_PLAN_SPL_REVIVAL_YRS_LABEL;
	}

	public HtmlInputText getCOMP_PLAN_SPL_REVIVAL_YRS() {
		return COMP_PLAN_SPL_REVIVAL_YRS;
	}

	public void setCOMP_PLAN_SPL_REVIVAL_YRS_LABEL(
			HtmlOutputLabel COMP_PLAN_SPL_REVIVAL_YRS_LABEL) {
		this.COMP_PLAN_SPL_REVIVAL_YRS_LABEL = COMP_PLAN_SPL_REVIVAL_YRS_LABEL;
	}

	public void setCOMP_PLAN_SPL_REVIVAL_YRS(
			HtmlInputText COMP_PLAN_SPL_REVIVAL_YRS) {
		this.COMP_PLAN_SPL_REVIVAL_YRS = COMP_PLAN_SPL_REVIVAL_YRS;
	}

	public HtmlOutputLabel getCOMP_PLAN_RED_SA_BASIS_LABEL() {
		return COMP_PLAN_RED_SA_BASIS_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PLAN_RED_SA_BASIS() {
		return COMP_PLAN_RED_SA_BASIS;
	}

	public void setCOMP_PLAN_RED_SA_BASIS_LABEL(
			HtmlOutputLabel COMP_PLAN_RED_SA_BASIS_LABEL) {
		this.COMP_PLAN_RED_SA_BASIS_LABEL = COMP_PLAN_RED_SA_BASIS_LABEL;
	}

	public void setCOMP_PLAN_RED_SA_BASIS(
			HtmlSelectOneMenu COMP_PLAN_RED_SA_BASIS) {
		this.COMP_PLAN_RED_SA_BASIS = COMP_PLAN_RED_SA_BASIS;
	}

	public HtmlOutputLabel getCOMP_PLAN_CALC_TYPE_LABEL() {
		return COMP_PLAN_CALC_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PLAN_CALC_TYPE() {
		return COMP_PLAN_CALC_TYPE;
	}

	public void setCOMP_PLAN_CALC_TYPE_LABEL(
			HtmlOutputLabel COMP_PLAN_CALC_TYPE_LABEL) {
		this.COMP_PLAN_CALC_TYPE_LABEL = COMP_PLAN_CALC_TYPE_LABEL;
	}

	public void setCOMP_PLAN_CALC_TYPE(HtmlSelectOneMenu COMP_PLAN_CALC_TYPE) {
		this.COMP_PLAN_CALC_TYPE = COMP_PLAN_CALC_TYPE;
	}

	

	public PM_IL_PLAN getPM_IL_PLAN_BEAN() {
		return PM_IL_PLAN_BEAN;
	}

	public void setPM_IL_PLAN_BEAN(PM_IL_PLAN PM_IL_PLAN_BEAN) {
		this.PM_IL_PLAN_BEAN = PM_IL_PLAN_BEAN;
	}

	public void validatePLAN_FRZ_FLAG(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {

		PM_IL_PLAN_BEAN.setPLAN_FRZ_FLAG(CommonUtils.booleanToStriingConvertor((Boolean) value));
	}
	//committed by Dhinesh for SSP call id FALCONQC-1714734
	
	public void validatePLAN_LOAN_YN(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
        System.out.println("Enter into Plan_loan_y/n");
		PM_IL_PLAN_BEAN.setPLAN_LOAN_YN((String) value);
		String Plan_loan=PM_IL_PLAN_BEAN.getPLAN_LOAN_YN();
        System.out.println("Plan_loan_y/n   ::"+Plan_loan);
        if("N".equals(Plan_loan))
        {
        	System.out.println("inside if");
        	COMP_PLAN_LOAN_PER.setDisabled(true);
        	COMP_PLAN_LOAN_PER.resetValue();
        }
        else
		 {
        	System.out.println("inside else");
			 COMP_PLAN_LOAN_PER.setDisabled(false); 
			 COMP_PLAN_LOAN_PER.resetValue();
		 }
	}
	public void validatePLAN_LOAN_PERCENT(FacesContext fc, UIComponent component,
			Object value) throws Exception {
         
		try{
			 int user_data=((Integer) value);
			  PM_IL_PLAN_BEAN.setPLAN_LOAN_PER((Integer) value);
		
		if(user_data>100)
		{
			throw new ValidatorException(new FacesMessage("Value should not be greater than 100"));
			}
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	//end SSP call id FALCONQC-1714734
	public void saveRecord() {
		String message = null;
		try {
			if (getPM_IL_PLAN_BEAN().getROWID() != null) {
				if(isUPDATE_ALLOWED()){
				helper.PRE_UPDATE(PM_IL_PLAN_BEAN);
				new CRUDHandler().executeUpdate(getPM_IL_PLAN_BEAN(),
						CommonUtils.getConnection());
				getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
				getWarningMap().put("togle", Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
				}
			} else {
				if(isINSERT_ALLOWED()){
				helper.PRE_INSERT(PM_IL_PLAN_BEAN);
				new CRUDHandler().executeInsert(getPM_IL_PLAN_BEAN(),
						CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(
					PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
				getWarningMap().put("togle",Messages.getString(
						PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
				message = Messages.getString("messageProperties","errorPanel$message$save");

				}
			}
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	
	public void deleteRow() {
	    CommonUtils.clearMaps(this);
		try {
			if (isDELETE_ALLOWED()) {
			    
			    helper.ON_CHECK_DELETE_MASTER(PM_IL_PLAN_BEAN);
			    helper.PRE_DELETE(PM_IL_PLAN_BEAN.getPLAN_CODE());
				new CRUDHandler().executeDelete(PM_IL_PLAN_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$delete"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$delete"));
				PM_IL_PLAN_BEAN=new PM_IL_PLAN();
			} else {

				getErrorMap().put("deleteRow", Messages.getString(
						PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$deletenotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$deletenotallowed"));
			}
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}
	
	}
	

	public List<SelectItem> getListPLAN_AGE_TERM_FLAG() {
		if (listPLAN_AGE_TERM_FLAG.size() == 0) {
			listPLAN_AGE_TERM_FLAG.clear();
			try {
				listPLAN_AGE_TERM_FLAG = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPLAN_AGE_TERM_FLAG;
	}

	public void setListPLAN_AGE_TERM_FLAG(
			List<SelectItem> listPLAN_AGE_TERM_FLAG) {
		this.listPLAN_AGE_TERM_FLAG = listPLAN_AGE_TERM_FLAG;
	}

	public List<SelectItem> getListPLAN_PYMT_ON_MAT_YN() {
		if (listPLAN_PYMT_ON_MAT_YN.size() == 0) {
			listPLAN_PYMT_ON_MAT_YN.clear();
			try {
				listPLAN_PYMT_ON_MAT_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPLAN_PYMT_ON_MAT_YN;
	}

	public void setListPLAN_PYMT_ON_MAT_YN(
			List<SelectItem> listPLAN_PYMT_ON_MAT_YN) {
		this.listPLAN_PYMT_ON_MAT_YN = listPLAN_PYMT_ON_MAT_YN;
	}

	public List<SelectItem> getListPLAN_SA_INST_PYMT_YN() {
		if (listPLAN_SA_INST_PYMT_YN.size() == 0) {
			listPLAN_SA_INST_PYMT_YN.clear();
			try {
				listPLAN_SA_INST_PYMT_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPLAN_SA_INST_PYMT_YN;
	}

	public void setListPLAN_SA_INST_PYMT_YN(
			List<SelectItem> listPLAN_SA_INST_PYMT_YN) {
		this.listPLAN_SA_INST_PYMT_YN = listPLAN_SA_INST_PYMT_YN;
	}

	public List<SelectItem> getListPLAN_SURR_YN() {
		if (listPLAN_SURR_YN.size() == 0) {
			listPLAN_SURR_YN.clear();
			try {
				listPLAN_SURR_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPLAN_SURR_YN;
	}

	public void setListPLAN_SURR_YN(List<SelectItem> listPLAN_SURR_YN) {
		this.listPLAN_SURR_YN = listPLAN_SURR_YN;
	}

	public List<SelectItem> getListPLAN_LOAN_YN() {
		if (listPLAN_LOAN_YN.size() == 0) {
			listPLAN_LOAN_YN.clear();
			try {
				listPLAN_LOAN_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPLAN_LOAN_YN;
	}

	public void setListPLAN_LOAN_YN(List<SelectItem> listPLAN_LOAN_YN) {
		this.listPLAN_LOAN_YN = listPLAN_LOAN_YN;
	}

	public List<SelectItem> getListPLAN_REBATE_YN() {
		if (listPLAN_REBATE_YN.size() == 0) {
			listPLAN_REBATE_YN.clear();
			try {
				listPLAN_REBATE_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPLAN_REBATE_YN;
	}

	public void setListPLAN_REBATE_YN(List<SelectItem> listPLAN_REBATE_YN) {
		this.listPLAN_REBATE_YN = listPLAN_REBATE_YN;
	}

	public List<SelectItem> getListPLAN_POL_VALID_AFTER_MAT_YN() {
		if (listPLAN_POL_VALID_AFTER_MAT_YN.size() == 0) {
			listPLAN_POL_VALID_AFTER_MAT_YN.clear();
			try {
				listPLAN_POL_VALID_AFTER_MAT_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPLAN_POL_VALID_AFTER_MAT_YN;
	}

	public void setListPLAN_POL_VALID_AFTER_MAT_YN(
			List<SelectItem> listPLAN_POL_VALID_AFTER_MAT_YN) {
		this.listPLAN_POL_VALID_AFTER_MAT_YN = listPLAN_POL_VALID_AFTER_MAT_YN;
	}

	public List<SelectItem> getListPLAN_REVIVAL_YN() {
		if (listPLAN_REVIVAL_YN.size() == 0) {
			listPLAN_REVIVAL_YN.clear();
			try {
				listPLAN_REVIVAL_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPLAN_REVIVAL_YN;
	}

	public void setListPLAN_REVIVAL_YN(List<SelectItem> listPLAN_REVIVAL_YN) {
		this.listPLAN_REVIVAL_YN = listPLAN_REVIVAL_YN;
	}

	public List<SelectItem> getListPLAN_SPL_REVIVAL_YN() {
		if (listPLAN_SPL_REVIVAL_YN.size() == 0) {
			listPLAN_SPL_REVIVAL_YN.clear();
			try {
				listPLAN_SPL_REVIVAL_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPLAN_SPL_REVIVAL_YN;
	}

	public void setListPLAN_SPL_REVIVAL_YN(
			List<SelectItem> listPLAN_SPL_REVIVAL_YN) {
		this.listPLAN_SPL_REVIVAL_YN = listPLAN_SPL_REVIVAL_YN;
	}

	public List<SelectItem> getListPLAN_RED_SA_BASIS() {
		if (listPLAN_RED_SA_BASIS.size() == 0) {
			listPLAN_RED_SA_BASIS.clear();
			try {
				listPLAN_RED_SA_BASIS = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPLAN_RED_SA_BASIS;
	}

	public void setListPLAN_RED_SA_BASIS(List<SelectItem> listPLAN_RED_SA_BASIS) {
		this.listPLAN_RED_SA_BASIS = listPLAN_RED_SA_BASIS;
	}

	public List<SelectItem> getListPLAN_CALC_TYPE() {
		if (listPLAN_CALC_TYPE.size() == 0) {
			listPLAN_CALC_TYPE.clear();
			try {
				listPLAN_CALC_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPLAN_CALC_TYPE;
	}

	public void setListPLAN_CALC_TYPE(List<SelectItem> listPLAN_CALC_TYPE) {
		this.listPLAN_CALC_TYPE = listPLAN_CALC_TYPE;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			if(PM_IL_PLAN_BEAN.getROWID() != null){
				COMP_PLAN_CODE.setDisabled(true);
			}
			helper.WHEN_NEW_BLOCK_INSTANCE(compositeAction);
			if (isBlockFlag()) {
				helper.PRE_QUERY(PM_IL_PLAN_BEAN, compositeAction.
						getCOPY_PLAN_ACTION_BEAN().getCOPY_PLAN_BEAN());
				helper.executeQuery(compositeAction);
				if(PM_IL_PLAN_BEAN.getROWID() != null){
					helper.POST_QUERY(compositeAction);
				}else{
					helper.WHEN_CREATE_RECORD(PM_IL_PLAN_BEAN);
				}
				helper.WHEN_NEW_RECORD_INSTANCE(compositeAction);
				/*commited by Dhinesh for SSP call id FALCONQC-1714734*/
				String Plan_loan=PM_IL_PLAN_BEAN.getPLAN_LOAN_YN();
				System.out.println("Plan_loan_y/n   ::"+Plan_loan);
				 if("N".equals(Plan_loan))
			        {
			        	COMP_PLAN_LOAN_PER.setDisabled(true);
			        	COMP_PLAN_LOAN_PER.resetValue();
			        }
				 else
				 {
					 COMP_PLAN_LOAN_PER.setDisabled(false); 
				 }
				 //end	
				 
				 
				 /*added by raja on 18-04-2017*/
				 /*if(PM_IL_PLAN_BEAN.getPLAN_TYPE()!=null && PM_IL_PLAN_BEAN.getPLAN_TYPE().equalsIgnoreCase("L"))*/
				/* Modified condition by saritha on 13-07-2017 for ssp call id ZBILQC-1731682*/
				 if((PM_IL_PLAN_BEAN.getPLAN_TYPE()!=null)&&(PM_IL_PLAN_BEAN.getPLAN_TYPE().equalsIgnoreCase("L"))||
				   (PM_IL_PLAN_BEAN.getPLAN_TYPE()!=null)&&(PM_IL_PLAN_BEAN.getPLAN_TYPE().equalsIgnoreCase("H")))
				 {
					 COMP_PLAN_MAX_DEP_COUNT.setDisabled(false);
				 }
				 else
				 {
					 COMP_PLAN_MAX_DEP_COUNT.setDisabled(true);
				 }
				 /*End*/
				setBlockFlag(false);
			}
			 //String PLAN_SURR_YN =PM_IL_PLAN_BEAN.getPLAN_SURR_YN();
			 if(("Y").equalsIgnoreCase(CommonUtils.nvl(PM_IL_PLAN_BEAN.getPLAN_SURR_YN(), "N"))){
					CommonUtils.setGlobalVariable("GLOBAL.SURR","TRUE");	
				}
			disableRegTopup();
			/*added by gopi for RM018T - FSD_IL_ZB Life_010-Maximum Funeral  Benefit Limit COMMENTS on 30/12/16*/
			String plan_type=PM_IL_PLAN_BEAN.getPLAN_TYPE();	
			/*
			 * cOMMENTED BY SANKARA NARAYANAN ON 21/04/2017
			 * if((plan_type!=null && plan_type.equalsIgnoreCase("L")))*/
			if((plan_type!=null && plan_type.equalsIgnoreCase("L")||"H".equalsIgnoreCase(plan_type)))
			{
				compositeAction.getWizard().enableWizardItem("PILM003_APAC_PM_IL_PLAN_MEMBERS");
			}else{
				compositeAction.getWizard().disableWizardItem("PILM003_APAC_PM_IL_PLAN_MEMBERS");
			}
			
			/*END*/
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	
	public List<LovBean> preparePLAN_CODE(Object value) {
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			lovList = itemUtil.P_CALL_LOV("PILM003_APAC", "PM_IL_PLAN",
					"PLAN_CODE", "S", null, null, null, null,
					(String) value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("PLAN_CODE_SUGGESTION", e.getMessage());
		}
		return lovList;
	}
	
	public List<LovBean> preparePLAN_TYPE(Object value) {
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			lovList = itemUtil.P_CALL_LOV("PILM003_APAC", "PM_IL_PLAN",
					"PLAN_TYPE", "ILPLANTYPE", null, null, null, null,
					(String) value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("ILPLANTYPE_SUGGESTION", e.getMessage());
		}
		return lovList;
	}
	
	public void validatePLAN_RED_SA_BASIS(FacesContext context,UIComponent component,Object value){
		try{
			String saValue = (String)value;
			PM_IL_PLAN_BEAN.setPLAN_RED_SA_BASIS(saValue);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void validatePLAN_SA_INST_PYMT_YN(FacesContext context,UIComponent component,Object value){
		try{
			String saValue = (String)value;
			PM_IL_PLAN_BEAN.setPLAN_SA_INST_PYMT_YN(saValue);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	// calling red SA on list change of PLAN_RED_SA_BASIS
	public void whenListChange_PLAN_RED_SA_BASIS(ActionEvent event){
		String outcome = null;
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		if(CommonUtils.nvl(PM_IL_PLAN_BEAN.getPLAN_RED_SA_BASIS(), "T").equals("T")){
			try {
				//compositeAction.getTabbedBar().setTabEnabled(2);
				compositeAction.getWizard().enableWizardItemForId("1");
				//compositeAction.getTabbedBar().callNextEnabledTab(1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(PM_IL_PLAN_BEAN.getROWID() == null){
				outcome = "PILM003_APAC_PM_IL_RED_SA";
			}
		}else{
			//compositeAction.getTabbedBar().setTabDisabled(2);
			compositeAction.getWizard().disableWizardItemForId("1");
		}
		//return outcome;
		
	}

	
	public void validatePLAN_CODE(FacesContext context,
			UIComponent component, Object value){
		try{
			String PLAN_CODE = (String)value;
			PM_IL_PLAN_BEAN.setPLAN_CODE(PLAN_CODE);
			helper.whenValidate_PLAN_CODE(PM_IL_PLAN_BEAN, compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			COMP_UI_M_PLAN_DESC.resetValue();
			COMP_PLAN_MIN_SA.resetValue();
			COMP_PLAN_MAX_SA.resetValue();
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*public void validatePLAN_TYPE(FacesContext context,
			UIComponent component, Object value){
		try{
			System.out.println("validatePLAN_TYPE--------------------------->");
			String PLAN_TYPE = (String)value;
			PM_IL_PLAN_BEAN.setPLAN_TYPE(PLAN_TYPE);
			helper.whenValidate_PLAN_TYPE(PM_IL_PLAN_BEAN, compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			if(("T".equalsIgnoreCase(compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().getPLAN_TYPE()))||("M".equalsIgnoreCase(compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().getPLAN_TYPE())))
			{
				compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().setPLAN_PYMT_ON_MAT_YN("N");
				COMP_PLAN_PYMT_ON_MAT_YN.setDisabled(true);
				compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().setPLAN_SURR_YN("N");
				COMP_PLAN_SURR_YN.setDisabled(true);
				compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().setPLAN_LOAN_YN("N");
				COMP_PLAN_LOAN_YN.setDisabled(true);
				compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().setPLAN_SA_INST_PYMT_YN("N");
				COMP_PLAN_SA_INST_PYMT_YN.setDisabled(true);
				compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().setPLAN_CALC_TYPE("N");
				COMP_PLAN_CALC_TYPE.setDisabled(true);
				compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().setPLAN_SURR_YRS(0);
				COMP_PLAN_SURR_YRS.setDisabled(true);
			}
			else if(("U".equalsIgnoreCase(compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().getPLAN_TYPE())))
			{
				compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().setPLAN_SURR_YN("N");
				COMP_PLAN_SURR_YN.setDisabled(true);
				compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().setPLAN_LOAN_YN("N");
				COMP_PLAN_LOAN_YN.setDisabled(true);
				compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().setPLAN_SURR_YRS(0);
				COMP_PLAN_SURR_YRS.setDisabled(true);
			}
			else
			{
				compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().setPLAN_PYMT_ON_MAT_YN("Y");
				COMP_PLAN_PYMT_ON_MAT_YN.setDisabled(false);
				compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().setPLAN_SURR_YN("Y");
				COMP_PLAN_SURR_YN.setDisabled(false);
				compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().setPLAN_LOAN_YN("Y");
				COMP_PLAN_LOAN_YN.setDisabled(false);
			//	compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().setPLAN_SA_INST_PYMT_YN("N");
				COMP_PLAN_SA_INST_PYMT_YN.setDisabled(false);
				compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().setPLAN_CALC_TYPE("N");
				COMP_PLAN_CALC_TYPE.setDisabled(false);
				COMP_PLAN_SURR_YRS.setDisabled(false);
			}
			COMP_PLAN_PYMT_ON_MAT_YN.resetValue();
			COMP_PLAN_SURR_YN.resetValue();
			COMP_PLAN_LOAN_YN.resetValue();
			COMP_PLAN_SA_INST_PYMT_YN.resetValue();
			COMP_PLAN_CALC_TYPE.resetValue();
			COMP_PLAN_SURR_YRS.resetValue();
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}*/
	
	
	/*added by gopi for RM018T - FSD_IL_ZB Life_010-Maximum Funeral  Benefit Limit COMMENTS on 30/12/16*/
	public void validatePLAN_TYPE(FacesContext context,
			UIComponent component, Object value){
		try{
			System.out.println("validatePLAN_TYPE--------------------------->");
			String PLAN_TYPE = (String)value;
			PM_IL_PLAN_BEAN.setPLAN_TYPE(PLAN_TYPE);
			if(("L".equalsIgnoreCase(compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().getPLAN_TYPE())))
			{
				compositeAction.getWizard().enableWizardItem("PILM003_APAC_PM_IL_PLAN_MEMBERS");
			}else{
				compositeAction.getWizard().disableWizardItem("PILM003_APAC_PM_IL_PLAN_MEMBERS");
			}
			
		
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	/*end*/
	
	
	
	
	public void validatePLAN_AGE_TERM_FLAG(FacesContext context,
			UIComponent component, Object value){
		try{
			String PLAN_AGE_TERM_FLAG = (String)value;
			PM_IL_PLAN_BEAN.setPLAN_AGE_TERM_FLAG(PLAN_AGE_TERM_FLAG);
			helper.whenValidate_PLAN_AGE_TERM_FLAG(compositeAction);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePLAN_PERIOD_FROM(FacesContext context,
			UIComponent component, Object value){
		try{
			Integer PLAN_PERIOD_FROM = (Integer)value;
			PM_IL_PLAN_BEAN.setPLAN_PERIOD_FROM(PLAN_PERIOD_FROM);
			helper.whenValidate_PLAN_PERIOD_FROM(PM_IL_PLAN_BEAN, PLAN_PERIOD_FROM);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePLAN_PERIOD_TO(FacesContext context,
			UIComponent component, Object value){
		try{
			Integer PLAN_PERIOD_TO = (Integer)value;
			PM_IL_PLAN_BEAN.setPLAN_PERIOD_TO(PLAN_PERIOD_TO);
			helper.whenValiadate_PLAN_PERIOD_TO(PM_IL_PLAN_BEAN, PLAN_PERIOD_TO);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePLAN_AGE_FROM(FacesContext context,
			UIComponent component, Object value){
		try{
			Integer PLAN_AGE_FROM = (Integer)value;
			PM_IL_PLAN_BEAN.setPLAN_AGE_FROM(PLAN_AGE_FROM);
			helper.whenValidate_PLAN_AGE_FROM(PM_IL_PLAN_BEAN, PLAN_AGE_FROM);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePLAN_AGE_TO(FacesContext context,
			UIComponent component, Object value){
		try{
			Integer PLAN_AGE_TO = (Integer)value;
			PM_IL_PLAN_BEAN.setPLAN_AGE_TO(PLAN_AGE_TO);
			helper.whenValidate_PLAN_AGE_TO(PM_IL_PLAN_BEAN, PLAN_AGE_TO);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePLAN_MIN_SA(FacesContext context,
			UIComponent component, Object value){
		try{
			Double PLAN_MIN_SA = (Double)value;
			PM_IL_PLAN_BEAN.setPLAN_MIN_SA(PLAN_MIN_SA);
			helper.whenValidate_PLAN_MIN_SA(PM_IL_PLAN_BEAN, PLAN_MIN_SA);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePLAN_MAX_SA(FacesContext context,
			UIComponent component, Object value){
		try{
			getErrorMap().clear();
			Double PLAN_MAX_SA = (Double)value;
			PM_IL_PLAN_BEAN.setPLAN_MAX_SA(PLAN_MAX_SA);
			helper.whenValidate_PLAN_MAX_SA(PM_IL_PLAN_BEAN, PLAN_MAX_SA);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePLAN_PYMT_ON_MAT_YN(FacesContext context,
			UIComponent component, Object value){
		try{
			String PLAN_PYMT_ON_MAT_YN = (String)value;
			PM_IL_PLAN_BEAN.setPLAN_PYMT_ON_MAT_YN(PLAN_PYMT_ON_MAT_YN);
			helper.whenValidate_PLAN_PYMT_ON_MAT_YN(this, PLAN_PYMT_ON_MAT_YN);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePLAN_SURR_YN(FacesContext context,
			UIComponent component, Object value){
		try{
			String PLAN_SURR_YN = (String)value;
			PM_IL_PLAN_BEAN.setPLAN_SURR_YN(PLAN_SURR_YN);
			if(("Y").equalsIgnoreCase(PLAN_SURR_YN)){
				CommonUtils.setGlobalVariable("GLOBAL.SURR","TRUE");	
			}
			
			helper.whenValidate_PLAN_SURR_YN(compositeAction, PLAN_SURR_YN);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePLAN_SURR_YRS(FacesContext context,
			UIComponent component, Object value){
		    getErrorMap().clear();
		    getWarningMap().clear();
		try{
			Integer PLAN_SURR_YRS = (Integer)value;
			PM_IL_PLAN_BEAN.setPLAN_SURR_YRS(PLAN_SURR_YRS);
			helper.whenValidate_PLAN_SURR_YRS(PM_IL_PLAN_BEAN, PLAN_SURR_YRS);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePLAN_MIN_AGE_ON_MAT(FacesContext context,
			UIComponent component, Object value){
		try{
			Integer PLAN_MIN_AGE_ON_MAT = (Integer)value;
			PM_IL_PLAN_BEAN.setPLAN_MIN_AGE_ON_MAT(PLAN_MIN_AGE_ON_MAT);
			helper.whenValidate_PLAN_MIN_AGE_ON_MAT(PM_IL_PLAN_BEAN, PLAN_MIN_AGE_ON_MAT);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePLAN_MAX_AGE_ON_MAT(FacesContext context,
			UIComponent component, Object value){
		try{
			Integer PLAN_MAX_AGE_ON_MAT = (Integer)value;
			PM_IL_PLAN_BEAN.setPLAN_MAX_AGE_ON_MAT(PLAN_MAX_AGE_ON_MAT);
			helper.whenValidate_PLAN_MAX_AGE_ON_MAT(PM_IL_PLAN_BEAN, PLAN_MAX_AGE_ON_MAT);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePLAN_REVIVAL_YN(FacesContext context,
			UIComponent component, Object value){
		try{
			String PLAN_REVIVAL_YN = (String)value;
			PM_IL_PLAN_BEAN.setPLAN_REVIVAL_YN(PLAN_REVIVAL_YN);
			helper.whenValidate_PLAN_REVIVAL_YN(this, PLAN_REVIVAL_YN);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePLAN_REVIVAL_YRS(FacesContext context,
			UIComponent component, Object value){
		try{
			Integer PLAN_REVIVAL_YRS = (Integer)value;
			PM_IL_PLAN_BEAN.setPLAN_REVIVAL_YRS(PLAN_REVIVAL_YRS);
			helper.whenValidate_PLAN_REVIVAL_YRS(PLAN_REVIVAL_YRS);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePLAN_SPL_REVIVAL_YN(FacesContext context,
			UIComponent component, Object value){
		try{
			String PLAN_SPL_REVIVAL_YN = (String)value;
			PM_IL_PLAN_BEAN.setPLAN_SPL_REVIVAL_YN(PLAN_SPL_REVIVAL_YN);
			helper.whenValidate_PLAN_SPL_REVIVAL_YN(this, PLAN_SPL_REVIVAL_YN);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePLAN_SPL_REVIVAL_YRS(FacesContext context,
			UIComponent component, Object value){
		try{
			Integer PLAN_SPL_REVIVAL_YRS = (Integer)value;
			PM_IL_PLAN_BEAN.setPLAN_SPL_REVIVAL_YRS(PLAN_SPL_REVIVAL_YRS);
			helper.whenValidate_PLAN_SPL_REVIVAL_YRS(PLAN_SPL_REVIVAL_YRS);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}


	public String copyAction(){
		compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN().setUI_M_PLAN_CODE(PM_IL_PLAN_BEAN.getPLAN_CODE());
		compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN().setUI_M_PLAN_DESC(PM_IL_PLAN_BEAN.getUI_M_PLAN_DESC());
		compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN().setUI_M_NEW_PLAN_CODE(null);
		compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN().setUI_M_NEW_PLAN_DESC(null);
		if(compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN().getUI_M_PLAN_CODE() != null){
		
		}
			return "PILM003_APAC_COPY_PLAN";
		
		
	}
	
	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
    }


	public PILM003_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}


	public void setCompositeAction(PILM003_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}


	public PM_IL_PLAN_HELPER getHelper() {
		return helper;
	}


	public void setHelper(PM_IL_PLAN_HELPER helper) {
		this.helper = helper;
	}


	public List<LovBean> getLovList() {
		return lovList;
	}


	public void setLovList(List<LovBean> lovList) {
		this.lovList = lovList;
	}


	public HtmlCommandButton getCOMP_UI_M_BUT_COPY() {
		return COMP_UI_M_BUT_COPY;
	}


	public void setCOMP_UI_M_BUT_COPY(HtmlCommandButton comp_ui_m_but_copy) {
		COMP_UI_M_BUT_COPY = comp_ui_m_but_copy;
	}
	
	
	public void disableRegTopup() throws Exception{
		String C1=" SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_CODE='IL_CALC_MTHD'";
		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler=new CRUDHandler();
		ResultSet result=null;
		String ps_value=null;
		try{
		
		result = handler.executeSelectStatement(C1, connection);
		if(result.next()){
			ps_value = result.getString(1);
		}
	 if("1".equalsIgnoreCase(ps_value)){
		 COMP_PLAN_CALC_TYPE_LABEL.setRendered(true);
		 COMP_PLAN_CALC_TYPE.setRendered(true); 
	 }else if("2".equalsIgnoreCase(ps_value)){
		 COMP_PLAN_CALC_TYPE_LABEL.setRendered(false);
		 COMP_PLAN_CALC_TYPE.setRendered(false); 
	 }
			
	 
	 } catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} 
		finally{
			try {CommonUtils.closeCursor(result);} catch (Exception e) {e.printStackTrace();}
		}
	
	}
	
	/*Added by saritha on 07-Jan-2017 for RM018T - DEV_IL_ZB Life_012b_Claim waiting period*/
	
	private HtmlOutputLabel COMP_PLAN_CONT_PERIOD_LABEL;
	private HtmlInputText COMP_PLAN_CONT_PERIOD;
	
	public HtmlOutputLabel getCOMP_PLAN_CONT_PERIOD_LABEL() {
		return COMP_PLAN_CONT_PERIOD_LABEL;
	}
	public void setCOMP_PLAN_CONT_PERIOD_LABEL(
			HtmlOutputLabel cOMP_PLAN_CONT_PERIOD_LABEL) {
		COMP_PLAN_CONT_PERIOD_LABEL = cOMP_PLAN_CONT_PERIOD_LABEL;
	}
	
	public HtmlInputText getCOMP_PLAN_CONT_PERIOD() {
		return COMP_PLAN_CONT_PERIOD;
	}
	public void setCOMP_PLAN_CONT_PERIOD(HtmlInputText cOMP_PLAN_CONT_PERIOD) {
		COMP_PLAN_CONT_PERIOD = cOMP_PLAN_CONT_PERIOD;
	}
	
	public void instantiateAllComponent() {
		
	COMP_PLAN_CONT_PERIOD_LABEL=new HtmlOutputLabel();
	COMP_PLAN_CONT_PERIOD=new HtmlInputText();	
	}
	
	
	
	public void disableAllComponent(boolean disabled) {
		
	COMP_PLAN_CONT_PERIOD.setDisabled(disabled);
		
		
	}
	
	public void validatePLAN_CONT_PERIOD(FacesContext context,
			UIComponent component, Object value){
		try{
			Integer PLAN_CONT_PERIOD = (Integer)value;
			PM_IL_PLAN_BEAN.setPLAN_CONT_PERIOD(PLAN_CONT_PERIOD);
			System.out.println("Contestablity Period::::::::"+PM_IL_PLAN_BEAN.getPLAN_CONT_PERIOD());
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*End*/
	

	/*added by raja on 18-04-2017*/ 
	private HtmlInputText COMP_PLAN_MAX_DEP_COUNT;
	private HtmlOutputLabel COMP_PLAN_MAX_DEP_COUNT_LABEL;

	public HtmlInputText getCOMP_PLAN_MAX_DEP_COUNT() {
		return COMP_PLAN_MAX_DEP_COUNT;
	}
	public void setCOMP_PLAN_MAX_DEP_COUNT(HtmlInputText cOMP_PLAN_MAX_DEP_COUNT) {
		COMP_PLAN_MAX_DEP_COUNT = cOMP_PLAN_MAX_DEP_COUNT;
	}
	public HtmlOutputLabel getCOMP_PLAN_MAX_DEP_COUNT_LABEL() {
		return COMP_PLAN_MAX_DEP_COUNT_LABEL;
	}
	public void setCOMP_PLAN_MAX_DEP_COUNT_LABEL(
			HtmlOutputLabel cOMP_PLAN_MAX_DEP_COUNT_LABEL) {
		COMP_PLAN_MAX_DEP_COUNT_LABEL = cOMP_PLAN_MAX_DEP_COUNT_LABEL;
	}
	
	public void validatePLAN_MAX_DEP_COUNT(FacesContext context,
			UIComponent component, Object value){
		try{
			Integer PLAN_MAX_DEP_COUNT = (Integer)value;
			PM_IL_PLAN_BEAN.setPLAN_MAX_DEP_COUNT(PLAN_MAX_DEP_COUNT);
			System.out.println("Contestablity Period::::::::"+PM_IL_PLAN_BEAN.getPLAN_MAX_DEP_COUNT());
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*end*/
	
	
	/*added by raja on 29-06-2017 fro ZBILQC-1730358*/
	
	private HtmlOutputLabel COMP_PLAN_PROP_AGE_FM_LABEL;

	private HtmlInputText COMP_PLAN_PROP_AGE_FM;
	
	
	private HtmlOutputLabel COMP_PLAN_PROP_AGE_TO_LABEL;

	private HtmlInputText COMP_PLAN_PROP_AGE_TO;

	public HtmlOutputLabel getCOMP_PLAN_PROP_AGE_FM_LABEL() {
		return COMP_PLAN_PROP_AGE_FM_LABEL;
	}
	public void setCOMP_PLAN_PROP_AGE_FM_LABEL(
			HtmlOutputLabel cOMP_PLAN_PROP_AGE_FM_LABEL) {
		COMP_PLAN_PROP_AGE_FM_LABEL = cOMP_PLAN_PROP_AGE_FM_LABEL;
	}
	public HtmlInputText getCOMP_PLAN_PROP_AGE_FM() {
		return COMP_PLAN_PROP_AGE_FM;
	}
	public void setCOMP_PLAN_PROP_AGE_FM(HtmlInputText cOMP_PLAN_PROP_AGE_FM) {
		COMP_PLAN_PROP_AGE_FM = cOMP_PLAN_PROP_AGE_FM;
	}
	public HtmlOutputLabel getCOMP_PLAN_PROP_AGE_TO_LABEL() {
		return COMP_PLAN_PROP_AGE_TO_LABEL;
	}
	public void setCOMP_PLAN_PROP_AGE_TO_LABEL(
			HtmlOutputLabel cOMP_PLAN_PROP_AGE_TO_LABEL) {
		COMP_PLAN_PROP_AGE_TO_LABEL = cOMP_PLAN_PROP_AGE_TO_LABEL;
	}
	public HtmlInputText getCOMP_PLAN_PROP_AGE_TO() {
		return COMP_PLAN_PROP_AGE_TO;
	}
	public void setCOMP_PLAN_PROP_AGE_TO(HtmlInputText cOMP_PLAN_PROP_AGE_TO) {
		COMP_PLAN_PROP_AGE_TO = cOMP_PLAN_PROP_AGE_TO;
	}
	
	public void validatePLAN_PROP_AGE_FM(FacesContext context,
			UIComponent component, Object value){
		try{
			Integer PLAN_MAX_DEP_COUNT = (Integer)value;
			PM_IL_PLAN_BEAN.setPLAN_PROP_AGE_FM(PLAN_MAX_DEP_COUNT);
			System.out.println("Contestablity Period::::::::"+PM_IL_PLAN_BEAN.getPLAN_PROP_AGE_FM());
			
			if(PM_IL_PLAN_BEAN.getPLAN_PROP_AGE_TO()!=null && PM_IL_PLAN_BEAN.getPLAN_PROP_AGE_TO()>0)
			{
				if(PM_IL_PLAN_BEAN.getPLAN_PROP_AGE_FM() > PM_IL_PLAN_BEAN.getPLAN_PROP_AGE_TO()){
					throw new Exception("Minimum Proposer is should be less than Maximum proposer age");
				}
			}
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePLAN_PROP_AGE_TO(FacesContext context,
			UIComponent component, Object value){
		try{ 
			Integer PLAN_MAX_DEP_COUNT = (Integer)value;
			PM_IL_PLAN_BEAN.setPLAN_PROP_AGE_TO(PLAN_MAX_DEP_COUNT);
			
			if(PM_IL_PLAN_BEAN.getPLAN_PROP_AGE_TO() < PM_IL_PLAN_BEAN.getPLAN_PROP_AGE_FM()){
				throw new Exception("Maximum Proposer is should be greater than Minimum proposer age");
			}
			
			System.out.println("Contestablity Period::::::::"+PM_IL_PLAN_BEAN.getPLAN_PROP_AGE_TO());
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/*end*/
}
	
	
	
