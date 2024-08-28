package com.iii.pel.forms.PILM015_APAC;

import java.sql.SQLException;
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

import org.richfaces.component.html.HtmlCalendar;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROP_TREATY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PT_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_PT_FRZ_FLAG;

	private HtmlOutputLabel COMP_PT_TREATY_CODE_LABEL;

	private HtmlInputText COMP_PT_TREATY_CODE;

	private HtmlOutputLabel COMP_PT_TREATY_DESC_LABEL;

	private HtmlInputText COMP_PT_TREATY_DESC;

	private HtmlOutputLabel COMP_PT_CLASS_CODE_LABEL;

	private HtmlInputText COMP_PT_CLASS_CODE;

	private HtmlOutputLabel COMP_UI_M_CLASS_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CLASS_CODE_DESC;

	private HtmlOutputLabel COMP_PT_UW_YEAR_LABEL;

	private HtmlInputText COMP_PT_UW_YEAR;

	private HtmlOutputLabel COMP_PT_UW_YEAR_DESC_LABEL;

	private HtmlInputText COMP_PT_UW_YEAR_DESC;

	private HtmlOutputLabel COMP_PT_START_DT_LABEL;

	private HtmlCalendar COMP_PT_START_DT;

	private HtmlOutputLabel COMP_PT_END_DT_LABEL;

	private HtmlCalendar COMP_PT_END_DT;

	private HtmlOutputLabel COMP_PT_CURR_CODE_LABEL;

	private HtmlInputText COMP_PT_CURR_CODE;

	private HtmlOutputLabel COMP_UI_M_CURR_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CURR_DESC;

	private HtmlOutputLabel COMP_PT_CURR_RATE_LABEL;

	private HtmlInputText COMP_PT_CURR_RATE;

	private HtmlOutputLabel COMP_PT_CASH_CALL_LC_LIMIT_LABEL;

	private HtmlInputText COMP_PT_CASH_CALL_LC_LIMIT;

	private HtmlOutputLabel COMP_PT_CQS_YN_LABEL;

	private HtmlSelectOneMenu COMP_PT_CQS_YN;

	private HtmlOutputLabel COMP_PT_CASH_CALL_FC_LIMIT_LABEL;

	private HtmlInputText COMP_PT_CASH_CALL_FC_LIMIT;

	private HtmlOutputLabel COMP_PT_RIDER_RI_BASIS_LABEL;

	private HtmlSelectOneMenu COMP_PT_RIDER_RI_BASIS;

	private HtmlOutputLabel COMP_PT_CQS_PERC_LABEL;

	private HtmlInputText COMP_PT_CQS_PERC;

	private HtmlOutputLabel COMP_PT_SURR_CLAIM_YN_LABEL;

	private HtmlSelectOneMenu COMP_PT_SURR_CLAIM_YN;

	private HtmlOutputLabel COMP_PT_CORIDOR_LC_LIMIT_LABEL;

	private HtmlInputText COMP_PT_CORIDOR_LC_LIMIT;

	private HtmlOutputLabel COMP_PT_REALLC_ENDT_YN_LABEL;

	private HtmlSelectOneMenu COMP_PT_REALLC_ENDT_YN;

	private HtmlCommandButton COMP_PUSH_BUTTON537;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_CLASS;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_TREATY_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_CURR;

	private HtmlCommandButton COMP_UI_M_BUT_COPY;

	private PM_IL_PROP_TREATY PM_IL_PROP_TREATY_BEAN;

	private List<SelectItem> PT_CQS_YN_LIST;

	private List<SelectItem> PT_REALLC_ENDT_YN_LIST;

	private List<SelectItem> PT_SURR_CLAIM_YN_LIST;

	private List<SelectItem> PT_RIDER_RI_BASIS_LIST;

	private List classCodeList;

	private List treatyCodeList;

	private List currCodeList;
	
	private boolean update = false;
	
	public PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction;
	
	public PM_IL_PROP_TREATY_MASTER_DELEGATE delegate;
	
	public PM_IL_PROP_TREATY_MASTER_HELPER masterHelper;

	public PM_IL_PROP_TREATY_ACTION() {

		PM_IL_PROP_TREATY_BEAN = new PM_IL_PROP_TREATY();
		masterHelper =  new PM_IL_PROP_TREATY_MASTER_HELPER();
		delegate = new PM_IL_PROP_TREATY_MASTER_DELEGATE();
		try{
			List<SelectItem> itemListCQSYN = delegate
					.getListTreatyMaster(
							PM_IL_PROP_TREATY_CONSTANTS.PILM105_APAC_TREATY_MASTER_ITEM_NAME_CQS_YN,
							PM_IL_PROP_TREATY_CONSTANTS.PILM105_APAC_TREATY_MASTER_SYS_PARAM_CQS_YN);
			setPT_CQS_YN_LIST(itemListCQSYN);
	
			List<SelectItem> itemListENDTYN = delegate
					.getListTreatyMaster(
							PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_TREATY_MASTER_ITEM_NAME_ENDT_YN,
							PM_IL_PROP_TREATY_CONSTANTS.PILM105_APAC_TREATY_MASTER_SYS_PARAM_ENDT_YN);
			setPT_REALLC_ENDT_YN_LIST(itemListENDTYN);
	
			List<SelectItem> itemListClaimYN = delegate
					.getListTreatyMaster(
							PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_TREATY_MASTER_ITEM_NAME_CLAIM_YN,
							PM_IL_PROP_TREATY_CONSTANTS.PILM105_APAC_TREATY_MASTER_SYS_PARAM_CLAIM_YN);
			setPT_SURR_CLAIM_YN_LIST(itemListClaimYN);
	
			List<SelectItem> itemListRIBasis = delegate
					.getListTreatyMaster(
							PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_TREATY_MASTER_ITEM_NAME_RI_BASIS,
							PM_IL_PROP_TREATY_CONSTANTS.PILM105_APAC_TREATY_MASTER_SYS_PARAM_RI_BASIS);
			setPT_RIDER_RI_BASIS_LIST(itemListRIBasis);
		}catch(Exception e){
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
		
	}

	public HtmlOutputLabel getCOMP_PT_FRZ_FLAG_LABEL() {
		return COMP_PT_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_PT_FRZ_FLAG() {
		return COMP_PT_FRZ_FLAG;
	}

	public void setCOMP_PT_FRZ_FLAG_LABEL(HtmlOutputLabel COMP_PT_FRZ_FLAG_LABEL) {
		this.COMP_PT_FRZ_FLAG_LABEL = COMP_PT_FRZ_FLAG_LABEL;
	}

	public void setCOMP_PT_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_PT_FRZ_FLAG) {
		this.COMP_PT_FRZ_FLAG = COMP_PT_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_PT_TREATY_CODE_LABEL() {
		return COMP_PT_TREATY_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PT_TREATY_CODE() {
		return COMP_PT_TREATY_CODE;
	}

	public void setCOMP_PT_TREATY_CODE_LABEL(
			HtmlOutputLabel COMP_PT_TREATY_CODE_LABEL) {
		this.COMP_PT_TREATY_CODE_LABEL = COMP_PT_TREATY_CODE_LABEL;
	}

	public void setCOMP_PT_TREATY_CODE(HtmlInputText COMP_PT_TREATY_CODE) {
		this.COMP_PT_TREATY_CODE = COMP_PT_TREATY_CODE;
	}

	public HtmlOutputLabel getCOMP_PT_TREATY_DESC_LABEL() {
		return COMP_PT_TREATY_DESC_LABEL;
	}

	public HtmlInputText getCOMP_PT_TREATY_DESC() {
		return COMP_PT_TREATY_DESC;
	}

	public void setCOMP_PT_TREATY_DESC_LABEL(
			HtmlOutputLabel COMP_PT_TREATY_DESC_LABEL) {
		this.COMP_PT_TREATY_DESC_LABEL = COMP_PT_TREATY_DESC_LABEL;
	}

	public void setCOMP_PT_TREATY_DESC(HtmlInputText COMP_PT_TREATY_DESC) {
		this.COMP_PT_TREATY_DESC = COMP_PT_TREATY_DESC;
	}

	public HtmlOutputLabel getCOMP_PT_CLASS_CODE_LABEL() {
		return COMP_PT_CLASS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PT_CLASS_CODE() {
		return COMP_PT_CLASS_CODE;
	}

	public void setCOMP_PT_CLASS_CODE_LABEL(
			HtmlOutputLabel COMP_PT_CLASS_CODE_LABEL) {
		this.COMP_PT_CLASS_CODE_LABEL = COMP_PT_CLASS_CODE_LABEL;
	}

	public void setCOMP_PT_CLASS_CODE(HtmlInputText COMP_PT_CLASS_CODE) {
		this.COMP_PT_CLASS_CODE = COMP_PT_CLASS_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CLASS_CODE_DESC_LABEL() {
		return COMP_UI_M_CLASS_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CLASS_CODE_DESC() {
		return COMP_UI_M_CLASS_CODE_DESC;
	}

	public void setCOMP_UI_M_CLASS_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_CLASS_CODE_DESC_LABEL) {
		this.COMP_UI_M_CLASS_CODE_DESC_LABEL = COMP_UI_M_CLASS_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_CLASS_CODE_DESC(
			HtmlInputText COMP_UI_M_CLASS_CODE_DESC) {
		this.COMP_UI_M_CLASS_CODE_DESC = COMP_UI_M_CLASS_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_PT_UW_YEAR_LABEL() {
		return COMP_PT_UW_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_PT_UW_YEAR() {
		return COMP_PT_UW_YEAR;
	}

	public void setCOMP_PT_UW_YEAR_LABEL(HtmlOutputLabel COMP_PT_UW_YEAR_LABEL) {
		this.COMP_PT_UW_YEAR_LABEL = COMP_PT_UW_YEAR_LABEL;
	}

	public void setCOMP_PT_UW_YEAR(HtmlInputText COMP_PT_UW_YEAR) {
		this.COMP_PT_UW_YEAR = COMP_PT_UW_YEAR;
	}

	public HtmlOutputLabel getCOMP_PT_UW_YEAR_DESC_LABEL() {
		return COMP_PT_UW_YEAR_DESC_LABEL;
	}

	public HtmlInputText getCOMP_PT_UW_YEAR_DESC() {
		return COMP_PT_UW_YEAR_DESC;
	}

	public void setCOMP_PT_UW_YEAR_DESC_LABEL(
			HtmlOutputLabel COMP_PT_UW_YEAR_DESC_LABEL) {
		this.COMP_PT_UW_YEAR_DESC_LABEL = COMP_PT_UW_YEAR_DESC_LABEL;
	}

	public void setCOMP_PT_UW_YEAR_DESC(HtmlInputText COMP_PT_UW_YEAR_DESC) {
		this.COMP_PT_UW_YEAR_DESC = COMP_PT_UW_YEAR_DESC;
	}

	public HtmlOutputLabel getCOMP_PT_START_DT_LABEL() {
		return COMP_PT_START_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PT_START_DT() {
		return COMP_PT_START_DT;
	}

	public void setCOMP_PT_START_DT_LABEL(HtmlOutputLabel COMP_PT_START_DT_LABEL) {
		this.COMP_PT_START_DT_LABEL = COMP_PT_START_DT_LABEL;
	}

	public void setCOMP_PT_START_DT(HtmlCalendar COMP_PT_START_DT) {
		this.COMP_PT_START_DT = COMP_PT_START_DT;
	}

	public HtmlOutputLabel getCOMP_PT_END_DT_LABEL() {
		return COMP_PT_END_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PT_END_DT() {
		return COMP_PT_END_DT;
	}

	public void setCOMP_PT_END_DT_LABEL(HtmlOutputLabel COMP_PT_END_DT_LABEL) {
		this.COMP_PT_END_DT_LABEL = COMP_PT_END_DT_LABEL;
	}

	public void setCOMP_PT_END_DT(HtmlCalendar COMP_PT_END_DT) {
		this.COMP_PT_END_DT = COMP_PT_END_DT;
	}

	public HtmlOutputLabel getCOMP_PT_CURR_CODE_LABEL() {
		return COMP_PT_CURR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PT_CURR_CODE() {
		return COMP_PT_CURR_CODE;
	}

	public void setCOMP_PT_CURR_CODE_LABEL(
			HtmlOutputLabel COMP_PT_CURR_CODE_LABEL) {
		this.COMP_PT_CURR_CODE_LABEL = COMP_PT_CURR_CODE_LABEL;
	}

	public void setCOMP_PT_CURR_CODE(HtmlInputText COMP_PT_CURR_CODE) {
		this.COMP_PT_CURR_CODE = COMP_PT_CURR_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CURR_DESC_LABEL() {
		return COMP_UI_M_CURR_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CURR_DESC() {
		return COMP_UI_M_CURR_DESC;
	}

	public void setCOMP_UI_M_CURR_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_CURR_DESC_LABEL) {
		this.COMP_UI_M_CURR_DESC_LABEL = COMP_UI_M_CURR_DESC_LABEL;
	}

	public void setCOMP_UI_M_CURR_DESC(HtmlInputText COMP_UI_M_CURR_DESC) {
		this.COMP_UI_M_CURR_DESC = COMP_UI_M_CURR_DESC;
	}

	public HtmlOutputLabel getCOMP_PT_CURR_RATE_LABEL() {
		return COMP_PT_CURR_RATE_LABEL;
	}

	public HtmlInputText getCOMP_PT_CURR_RATE() {
		return COMP_PT_CURR_RATE;
	}

	public void setCOMP_PT_CURR_RATE_LABEL(
			HtmlOutputLabel COMP_PT_CURR_RATE_LABEL) {
		this.COMP_PT_CURR_RATE_LABEL = COMP_PT_CURR_RATE_LABEL;
	}

	public void setCOMP_PT_CURR_RATE(HtmlInputText COMP_PT_CURR_RATE) {
		this.COMP_PT_CURR_RATE = COMP_PT_CURR_RATE;
	}

	public HtmlOutputLabel getCOMP_PT_CASH_CALL_LC_LIMIT_LABEL() {
		return COMP_PT_CASH_CALL_LC_LIMIT_LABEL;
	}

	public HtmlInputText getCOMP_PT_CASH_CALL_LC_LIMIT() {
		return COMP_PT_CASH_CALL_LC_LIMIT;
	}

	public void setCOMP_PT_CASH_CALL_LC_LIMIT_LABEL(
			HtmlOutputLabel COMP_PT_CASH_CALL_LC_LIMIT_LABEL) {
		this.COMP_PT_CASH_CALL_LC_LIMIT_LABEL = COMP_PT_CASH_CALL_LC_LIMIT_LABEL;
	}

	public void setCOMP_PT_CASH_CALL_LC_LIMIT(
			HtmlInputText COMP_PT_CASH_CALL_LC_LIMIT) {
		this.COMP_PT_CASH_CALL_LC_LIMIT = COMP_PT_CASH_CALL_LC_LIMIT;
	}

	public HtmlOutputLabel getCOMP_PT_CQS_YN_LABEL() {
		return COMP_PT_CQS_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PT_CQS_YN() {
		return COMP_PT_CQS_YN;
	}

	public void setCOMP_PT_CQS_YN_LABEL(HtmlOutputLabel COMP_PT_CQS_YN_LABEL) {
		this.COMP_PT_CQS_YN_LABEL = COMP_PT_CQS_YN_LABEL;
	}

	public void setCOMP_PT_CQS_YN(HtmlSelectOneMenu COMP_PT_CQS_YN) {
		this.COMP_PT_CQS_YN = COMP_PT_CQS_YN;
	}

	public HtmlOutputLabel getCOMP_PT_CASH_CALL_FC_LIMIT_LABEL() {
		return COMP_PT_CASH_CALL_FC_LIMIT_LABEL;
	}

	public HtmlInputText getCOMP_PT_CASH_CALL_FC_LIMIT() {
		return COMP_PT_CASH_CALL_FC_LIMIT;
	}

	public void setCOMP_PT_CASH_CALL_FC_LIMIT_LABEL(
			HtmlOutputLabel COMP_PT_CASH_CALL_FC_LIMIT_LABEL) {
		this.COMP_PT_CASH_CALL_FC_LIMIT_LABEL = COMP_PT_CASH_CALL_FC_LIMIT_LABEL;
	}

	public void setCOMP_PT_CASH_CALL_FC_LIMIT(
			HtmlInputText COMP_PT_CASH_CALL_FC_LIMIT) {
		this.COMP_PT_CASH_CALL_FC_LIMIT = COMP_PT_CASH_CALL_FC_LIMIT;
	}

	public HtmlOutputLabel getCOMP_PT_RIDER_RI_BASIS_LABEL() {
		return COMP_PT_RIDER_RI_BASIS_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PT_RIDER_RI_BASIS() {
		return COMP_PT_RIDER_RI_BASIS;
	}

	public void setCOMP_PT_RIDER_RI_BASIS_LABEL(
			HtmlOutputLabel COMP_PT_RIDER_RI_BASIS_LABEL) {
		this.COMP_PT_RIDER_RI_BASIS_LABEL = COMP_PT_RIDER_RI_BASIS_LABEL;
	}

	public void setCOMP_PT_RIDER_RI_BASIS(
			HtmlSelectOneMenu COMP_PT_RIDER_RI_BASIS) {
		this.COMP_PT_RIDER_RI_BASIS = COMP_PT_RIDER_RI_BASIS;
	}

	public HtmlOutputLabel getCOMP_PT_CQS_PERC_LABEL() {
		return COMP_PT_CQS_PERC_LABEL;
	}

	public HtmlInputText getCOMP_PT_CQS_PERC() {
		return COMP_PT_CQS_PERC;
	}

	public void setCOMP_PT_CQS_PERC_LABEL(HtmlOutputLabel COMP_PT_CQS_PERC_LABEL) {
		this.COMP_PT_CQS_PERC_LABEL = COMP_PT_CQS_PERC_LABEL;
	}

	public void setCOMP_PT_CQS_PERC(HtmlInputText COMP_PT_CQS_PERC) {
		this.COMP_PT_CQS_PERC = COMP_PT_CQS_PERC;
	}

	public HtmlOutputLabel getCOMP_PT_SURR_CLAIM_YN_LABEL() {
		return COMP_PT_SURR_CLAIM_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PT_SURR_CLAIM_YN() {
		return COMP_PT_SURR_CLAIM_YN;
	}

	public void setCOMP_PT_SURR_CLAIM_YN_LABEL(
			HtmlOutputLabel COMP_PT_SURR_CLAIM_YN_LABEL) {
		this.COMP_PT_SURR_CLAIM_YN_LABEL = COMP_PT_SURR_CLAIM_YN_LABEL;
	}

	public void setCOMP_PT_SURR_CLAIM_YN(HtmlSelectOneMenu COMP_PT_SURR_CLAIM_YN) {
		this.COMP_PT_SURR_CLAIM_YN = COMP_PT_SURR_CLAIM_YN;
	}

	public HtmlOutputLabel getCOMP_PT_CORIDOR_LC_LIMIT_LABEL() {
		return COMP_PT_CORIDOR_LC_LIMIT_LABEL;
	}

	public HtmlInputText getCOMP_PT_CORIDOR_LC_LIMIT() {
		return COMP_PT_CORIDOR_LC_LIMIT;
	}

	public void setCOMP_PT_CORIDOR_LC_LIMIT_LABEL(
			HtmlOutputLabel COMP_PT_CORIDOR_LC_LIMIT_LABEL) {
		this.COMP_PT_CORIDOR_LC_LIMIT_LABEL = COMP_PT_CORIDOR_LC_LIMIT_LABEL;
	}

	public void setCOMP_PT_CORIDOR_LC_LIMIT(
			HtmlInputText COMP_PT_CORIDOR_LC_LIMIT) {
		this.COMP_PT_CORIDOR_LC_LIMIT = COMP_PT_CORIDOR_LC_LIMIT;
	}

	public HtmlOutputLabel getCOMP_PT_REALLC_ENDT_YN_LABEL() {
		return COMP_PT_REALLC_ENDT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PT_REALLC_ENDT_YN() {
		return COMP_PT_REALLC_ENDT_YN;
	}

	public void setCOMP_PT_REALLC_ENDT_YN_LABEL(
			HtmlOutputLabel COMP_PT_REALLC_ENDT_YN_LABEL) {
		this.COMP_PT_REALLC_ENDT_YN_LABEL = COMP_PT_REALLC_ENDT_YN_LABEL;
	}

	public void setCOMP_PT_REALLC_ENDT_YN(
			HtmlSelectOneMenu COMP_PT_REALLC_ENDT_YN) {
		this.COMP_PT_REALLC_ENDT_YN = COMP_PT_REALLC_ENDT_YN;
	}

	public HtmlCommandButton getCOMP_PUSH_BUTTON537() {
		return COMP_PUSH_BUTTON537;
	}

	public void setCOMP_PUSH_BUTTON537(HtmlCommandButton COMP_PUSH_BUTTON537) {
		this.COMP_PUSH_BUTTON537 = COMP_PUSH_BUTTON537;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_CLASS() {
		return COMP_UI_M_BUT_LOV_CLASS;
	}

	public void setCOMP_UI_M_BUT_LOV_CLASS(
			HtmlCommandButton COMP_UI_M_BUT_LOV_CLASS) {
		this.COMP_UI_M_BUT_LOV_CLASS = COMP_UI_M_BUT_LOV_CLASS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_TREATY_CODE() {
		return COMP_UI_M_BUT_LOV_TREATY_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_TREATY_CODE(
			HtmlCommandButton COMP_UI_M_BUT_LOV_TREATY_CODE) {
		this.COMP_UI_M_BUT_LOV_TREATY_CODE = COMP_UI_M_BUT_LOV_TREATY_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_CURR() {
		return COMP_UI_M_BUT_LOV_CURR;
	}

	public void setCOMP_UI_M_BUT_LOV_CURR(
			HtmlCommandButton COMP_UI_M_BUT_LOV_CURR) {
		this.COMP_UI_M_BUT_LOV_CURR = COMP_UI_M_BUT_LOV_CURR;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_COPY() {
		return COMP_UI_M_BUT_COPY;
	}

	public void setCOMP_UI_M_BUT_COPY(HtmlCommandButton COMP_UI_M_BUT_COPY) {
		this.COMP_UI_M_BUT_COPY = COMP_UI_M_BUT_COPY;
	}

	public PM_IL_PROP_TREATY getPM_IL_PROP_TREATY_BEAN() {
		return PM_IL_PROP_TREATY_BEAN;
	}

	public void setPM_IL_PROP_TREATY_BEAN(
			PM_IL_PROP_TREATY PM_IL_PROP_TREATY_BEAN) {
		this.PM_IL_PROP_TREATY_BEAN = PM_IL_PROP_TREATY_BEAN;
	}

	public List<SelectItem> getPT_CQS_YN_LIST() {
		return PT_CQS_YN_LIST;
	}

	public void setPT_CQS_YN_LIST(List<SelectItem> pt_cqs_yn_list) {
		PT_CQS_YN_LIST = pt_cqs_yn_list;
	}

	public List<SelectItem> getPT_REALLC_ENDT_YN_LIST() {
		return PT_REALLC_ENDT_YN_LIST;
	}

	public void setPT_REALLC_ENDT_YN_LIST(
			List<SelectItem> pt_reallc_endt_yn_list) {
		PT_REALLC_ENDT_YN_LIST = pt_reallc_endt_yn_list;
	}

	public List<SelectItem> getPT_SURR_CLAIM_YN_LIST() {
		return PT_SURR_CLAIM_YN_LIST;
	}

	public void setPT_SURR_CLAIM_YN_LIST(List<SelectItem> pt_surr_claim_yn_list) {
		PT_SURR_CLAIM_YN_LIST = pt_surr_claim_yn_list;
	}

	public List<SelectItem> getPT_RIDER_RI_BASIS_LIST() {
		return PT_RIDER_RI_BASIS_LIST;
	}

	public void setPT_RIDER_RI_BASIS_LIST(
			List<SelectItem> pt_rider_ri_basis_list) {
		PT_RIDER_RI_BASIS_LIST = pt_rider_ri_basis_list;
	}

	public List getClassCodeList() {
		return classCodeList;
	}

	public void setClassCodeList(List classCodeList) {
		this.classCodeList = classCodeList;
	}

	public List getTreatyCodeList() {
		return treatyCodeList;
	}

	public void setTreatyCodeList(List treatyCodeList) {
		this.treatyCodeList = treatyCodeList;
	}

	public List getCurrCodeList() {
		return currCodeList;
	}

	public void setCurrCodeList(List currCodeList) {
		this.currCodeList = currCodeList;
	}

	/**
	 * Suggestion Action method called for List preparation
	 * 
	 * @param event
	 * @return List
	 */
	public List suggestionActionClassCode(Object event) {
		String classCode = (String) event;
		try {
			classCodeList = new PM_IL_PROP_TREATY_HELPER().prepareClassCodeList(
					classCode, classCodeList);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
		return classCodeList;
	}

	/**
	 * Method Called for Setting Description Field
	 * 
	 * @param event
	 */
	public void getClassCodeDesc(ActionEvent event) {
		COMP_UI_M_CLASS_CODE_DESC.setSubmittedValue(null);
		if (COMP_PT_CLASS_CODE.getSubmittedValue() != null) {
			String classCode = (String) COMP_PT_CLASS_CODE.getSubmittedValue();
			String classCodeDesc = new PM_IL_PROP_TREATY_HELPER()
					.getClassDescforCode(classCode, classCodeList);
			PM_IL_PROP_TREATY_BEAN.setUI_M_CLASS_CODE_DESC(classCodeDesc);
		}
	}

	/**
	 * Suggestion Action method called for List preparation
	 * 
	 * @param event
	 * @return List
	 */
	public List suggestionActionTreatyCode(Object event) {
		String treatyCode = (String) event;
		PM_IL_PROP_TREATY_HELPER helper = new PM_IL_PROP_TREATY_HELPER();
		try {
			treatyCodeList = helper.prepareTreatyCodeList(treatyCode,
					treatyCodeList);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
		return treatyCodeList;
	}

	/**
	 * Method Called for Setting Description Field
	 * 
	 * @param event
	 */
	public void getTreatyCodeDesc(ActionEvent event) {
		COMP_PT_TREATY_DESC.setSubmittedValue(null);
		if (COMP_PT_TREATY_CODE.getSubmittedValue() != null) {
			String treatyCode = (String) COMP_PT_TREATY_CODE
					.getSubmittedValue();
			PM_IL_PROP_TREATY_HELPER helper = new PM_IL_PROP_TREATY_HELPER();
			String treatyCodeDesc = helper.getTreatyDescforCode(treatyCode,
					treatyCodeList);
			PM_IL_PROP_TREATY_BEAN.setPT_TREATY_DESC(treatyCodeDesc);
		}
	}

	/**
	 * Suggestion Action method called for List preparation
	 * 
	 * @param event
	 * @return
	 */
	public List suggestionActionCurrCode(Object event) {
		String currCode = (String) event;
		PM_IL_PROP_TREATY_HELPER helper = new PM_IL_PROP_TREATY_HELPER();
		try {
			currCodeList = helper.prepareCurrCodeList(currCode, currCodeList);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
		return currCodeList;
	}

	/**
	 * Method Called for Setting Description Field
	 * 
	 * @param event
	 */
	public void getCurrCodeDesc(ActionEvent event) {
		COMP_UI_M_CURR_DESC.setSubmittedValue(null);
		if (COMP_PT_CURR_CODE.getSubmittedValue() != null) {
			String currCode = (String) COMP_PT_CURR_CODE.getSubmittedValue();
			PM_IL_PROP_TREATY_HELPER helper = new PM_IL_PROP_TREATY_HELPER();
			String currCodeDesc = helper.getCurrDescforCode(currCode,
					currCodeList);
			COMP_UI_M_CURR_DESC.setSubmittedValue(currCodeDesc);
			PM_IL_PROP_TREATY_BEAN.setUI_M_CURR_DESC(currCodeDesc);
		}
	}
	
	public void insertAction() throws Exception {
		CommonUtils commonUtils = new CommonUtils();
		try {
			if (PM_IL_PROP_TREATY_BEAN.isFRZ_FLAG()) {
				PM_IL_PROP_TREATY_BEAN.setPT_FRZ_FLAG("Y");
			} else {
				PM_IL_PROP_TREATY_BEAN.setPT_FRZ_FLAG("N");
			}
			Double sys_id = null;
			if (PM_IL_PROP_TREATY_BEAN.getROWID() == null) {
				sys_id = masterHelper
						.pilm015_apac_pm_il_prop_treaty_pre_insert(compositeAction);
				PM_IL_PROP_TREATY_BEAN.setPT_SYS_ID(sys_id);
				delegate.executeInsertForTreatyType(PM_IL_PROP_TREATY_BEAN);
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Records Inserted");
				getWarningMap().put("CURRENT", "Records Inserted");
			} else {
				masterHelper
						.pilm015_apac_pm_il_prop_treaty_pre_update(compositeAction);
				
				 /*Commented by Janani on 31.01.2018 for ZBLIFE-1468859*/
				
				//delegate.executeInsertForTreatyType(PM_IL_PROP_TREATY_BEAN);
				
				/*End of ZBLIFE-1468859*/
				
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Records Updated");
				getWarningMap().put("CURRENT", "Records Updated");

			}
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new Exception(exception.getMessage());
		}
	}

	public String saveAction() {
		Double sys_id = null;
		try {
			if (PM_IL_PROP_TREATY_BEAN.isFRZ_FLAG()) {
				PM_IL_PROP_TREATY_BEAN.setPT_FRZ_FLAG("Y");
			} else {
				PM_IL_PROP_TREATY_BEAN.setPT_FRZ_FLAG("N");
			}
			if (PM_IL_PROP_TREATY_BEAN.getROWID() == null) {
				sys_id = masterHelper
						.pilm015_apac_pm_il_prop_treaty_pre_insert(compositeAction);
				PM_IL_PROP_TREATY_BEAN.setPT_SYS_ID(sys_id);
				delegate.executeInsertForTreatyType(PM_IL_PROP_TREATY_BEAN);
				CommonUtils.getConnection().commit();
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Records Inserted");
				getWarningMap().put("CURRENT", "Records Inserted");
			} else {
				masterHelper
						.pilm015_apac_pm_il_prop_treaty_pre_update(compositeAction);
				delegate.executeInsertForTreatyType(PM_IL_PROP_TREATY_BEAN);
				CommonUtils.getConnection().commit();
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Records Updated");
				getWarningMap().put("CURRENT", "Records Updated");
			}
		} catch (Exception exception) {
			String exceptionError = exception.getMessage();
			this.getErrorMap().put("current", exceptionError);
			this.getErrorMap().put("detail", exceptionError);
		}
		return "";
	}

	public void deleteAction(ActionEvent e) {
		try {
			delegate.preDelete(compositeAction, PM_IL_PROP_TREATY_BEAN);
			PM_IL_PROP_TREATY_BEAN = new PM_IL_PROP_TREATY();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Records Deleted Successfully,Please Save it");
			getWarningMap().put("CURRENT", "Records Deleted Successfully,Please Save it");
		} catch (Exception e1) {
			e1.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e1.getMessage());
			getErrorMap().put("CURRENT", e1.getMessage());
		}
	}

	/**
	 * METHOD CALLED ON a4j support onblur actionListener FOR PT_TREATY_CODE
	 * 
	 * @param e
	 */
	public void COMP_PT_TREATY_CODE_WHEN_VALIDATE_ITEM(ActionEvent e) {
		UIInput input = (UIInput) e.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/**
	 * METHOD CALLED ON VALIDATOR FOR COMP_PT_TREATY_CODE
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws Exception
	 */
	public void validatePT_TREATY_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		getErrorMap().clear();
		getWarningMap().clear();
		
		try{
			if(value!=null){
				masterHelper
					.pilm015_apac_pm_il_prop_treaty_pt_treaty_code_when_validate_item(compositeAction);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * METHOD CALLED ON a4j support onblur actionListener FOR PT_CLASS_CODE
	 * 
	 * @param e
	 */
	public void COMP_PT_CLASS_CODE_WHEN_VALIDATE_ITEM(ActionEvent e) {
		UIInput input = (UIInput) e.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		if (inputValue != null) {
			PM_IL_PROP_TREATY_BEAN.setPT_CLASS_CODE(inputValue);
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/**
	 * METHOD CALLED ON VALIDATOR FOR COMP_PT_CLASS_CODE
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws Exception
	 */
	public void validatePT_CLASS_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try{
			if(value != null){
				masterHelper.whenValidateTriggerPTCLASSCODE(compositeAction);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * METHOD CALLED ON a4j support onblur actionListener FOR PT_UW_YEAR
	 * 
	 * @param e
	 */
	public void COMP_PT_UW_YEAR_WHEN_VALIDATE_ITEM(ActionEvent e) {
		UIInput input = (UIInput) e.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		int inputIntgerValue = Integer.parseInt(inputValue);
		PM_IL_PROP_TREATY_BEAN.setPT_UW_YEAR(inputIntgerValue);
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/**
	 * METHOD CALLED ON VALIDATOR FOR COMP_PT_UW_YEAR
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws Exception
	 */
	public void validatePT_UW_YEAR(FacesContext context, UIComponent component,
			Object value) throws ValidatorException, Exception {

		int uwYear = PM_IL_PROP_TREATY_BEAN.getPT_UW_YEAR();
		try{
			if (uwYear >= Integer
					.parseInt(PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_UW_YEAR_MAX_UPTO)
					|| uwYear <= Integer
							.parseInt(PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_UW_YEAR_MIN_UPTO)) {
	
				throw new ValidatorException(
						Messages
								.getMessage(
										"com.iii.premia.common.errorUtil.PELErrorMessages",
										"1035",
										new Object[] {
												PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_UW_YEAR_MIN_UPTO,
												PM_IL_PROP_TREATY_CONSTANTS.PILM015_APAC_PM_IL_PROP_TREATY_UW_YEAR_MAX_UPTO }));
			} else {
	
				masterHelper
						.pilm015_apac_pm_il_prop_treaty_pt_uw_year_when_validate_item(compositeAction);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * METHOD CALLED ON a4j support onblur actionListener FOR PT_START_DT
	 * 
	 * @param e
	 */
	public void COMP_PT_START_DT_WHEN_VALIDATE_ITEM(ActionEvent e) {
		HtmlCalendar input = (HtmlCalendar) e.getComponent().getParent();
		Date inputdate = input.getAsDate(input.getSubmittedValue());
		
		if (inputdate != null) {
			PM_IL_PROP_TREATY_BEAN.setPT_START_DT(inputdate);
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/**
	 * METHOD CALLED ON VALIDATOR FOR COMP_PT_START_DT
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws Exception
	 */
	public void validatePT_START_DT(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		try{
			masterHelper
					.pilm015_apac_pm_il_prop_treaty_pt_start_dt_when_validate_item(compositeAction);
			}catch(Exception e){
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
	}

	/**
	 * METHOD CALLED ON a4j support onblur actionListener FOR PT_END_DT
	 * 
	 * @param e
	 */
	public void COMP_PT_END_DT_WHEN_VALIDATE_ITEM(ActionEvent e) {
		HtmlCalendar input = (HtmlCalendar) e.getComponent().getParent();
		Date inputdate = input.getAsDate(input.getSubmittedValue());
		if (inputdate != null) {
			PM_IL_PROP_TREATY_BEAN.setPT_END_DT(inputdate);
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/**
	 * METHOD CALLED ON VALIDATOR FOR COMP_PT_END_DT
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws Exception
	 */
	public void validatePT_END_DT(FacesContext context, UIComponent component,
			Object value)  {
		try{
			Date startDate = PM_IL_PROP_TREATY_BEAN.getPT_START_DT();
			Date endDate = PM_IL_PROP_TREATY_BEAN.getPT_END_DT();
			/*[BugId:TRACK_PREMIAGDC_GL.10.5-00181: checking both start and end date's are null or not. Added by : Shankar B, 01-Apr-2009 */
			if(startDate!=null && endDate!=null){
				if (startDate.after(endDate)) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71135"));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * METHOD CALLED ON a4j support onblur actionListener FOR PT_CURR_CODE
	 * 
	 * @param e
	 */
	public void COMP_PT_CURR_CODE_WHEN_VALIDATE_ITEM(ActionEvent e) {
		UIInput input = (UIInput) e.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		if (inputValue != null) {
			PM_IL_PROP_TREATY_BEAN.setPT_CURR_CODE(inputValue);
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/**
	 * METHOD CALLED ON VALIDATOR FOR PT_CURR_CODE
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws Exception
	 */
	public void validatePT_CURR_CODE(FacesContext context,
			UIComponent component, Object value)  {
		int errorCode = 0;
		try {
			masterHelper
					.pilm015_apac_pm_il_prop_treaty_pt_curr_code_when_validate_item(compositeAction);
		} catch (SQLException sqle) {
			errorCode = sqle.getErrorCode();
			throw new ValidatorException(new FacesMessage(sqle.getMessage()));
		} catch (Exception exception) {
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			if (errorCode == 20100) {
				try {
					ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
							.getConnection(), context, component
							.getClientId(context), getWarningMap());
				} catch (DBException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * METHOD CALLED ON a4j support onblur actionListener FOR
	 * PT_CASH_CALL_LC_LIMIT
	 * 
	 * @param e
	 */
	public void COMP_PT_CASH_CALL_LC_LIMIT_WHEN_VALIDATE_ITEM(ActionEvent e) {
		UIInput input = (UIInput) e.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/**
	 * METHOD CALLED ON VALIDATOR FOR COMP_PT_CASH_CALL_LC_LIMIT
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws Exception
	 */
	public void validatePT_CASH_CALL_LC_LIMIT(FacesContext context,
			UIComponent component, Object value) {
		CommonUtils commonUtils = new CommonUtils();
		try{
			masterHelper
			.pilm015_apac_pm_il_prop_treaty_pt_cash_call_lc_limit_when_validate_item(compositeAction);
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * METHOD CALLED ON VALIDATOR FOR COMP_PT_CQS_YN
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws Exception
	 */
	public void validatePT_CQS_YN(ActionEvent e) {
		try {
			masterHelper
					.pilm015_apac_pm_il_prop_treaty_pt_cqs_yn_when_validate_item(compositeAction);
		} catch (Exception e1) {
			e1.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e1.getMessage());
			getErrorMap().put("CURRENT", e1.getMessage());
		}
	}

	/**
	 * METHOD CALLED ON a4j support onblur actionListener FOR PT_CQS_PERC
	 * 
	 * @param e
	 */
	public void COMP_PT_CQS_PERC_WHEN_VALIDATE_ITEM(ActionEvent e) {
		UIInput input = (UIInput) e.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/**
	 * METHOD CALLED ON VALIDATOR FOR COMP_PT_CQS_PERC
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws Exception
	 */
	/**
	 * METHOD CALLED ON VALIDATOR FOR COMP_PT_CQS_PERC
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws Exception
	 */
	public void validatePT_CQS_PERC(FacesContext context,
			UIComponent component, Object value)  {
		CommonUtils commonUtils = new CommonUtils();
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		try{
			if (COMP_PT_CQS_PERC.getSubmittedValue() != null) {
				Double cqsPerc = Double.parseDouble((String) COMP_PT_CQS_PERC
						.getSubmittedValue());
					PM_IL_PROP_TREATY_MASTER_HELPER treatyMasterHelper = new PM_IL_PROP_TREATY_MASTER_HELPER();
				treatyMasterHelper
						.pilm015_apac_pm_il_prop_treaty_pt_cqs_perc_when_validate_item(cqsPerc);
				PM_IL_PROP_TREATY_BEAN.setPT_CQS_PERC(cqsPerc);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/*
	 * public void validatePT_RIDER_BASIS_LIST(ActionEvent actionEvent){ UIInput
	 * input = (UIInput) actionEvent.getComponent().getParent(); String
	 * inputValue=(String)input.getSubmittedValue(); System.out.println(">>>>>>>
	 * Selected Value :"+inputValue); CommonUtils commonUtils = new
	 * CommonUtils();
	 * 
	 * PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction =
	 * (PM_IL_PROP_TREATY_COMPOSITE_ACTION) (commonUtils
	 * .getMappedBeanFromSession("PM_IL_PROP_TREATY_COMPOSITE_ACTION"));
	 * if(inputValue.trim().equals("S")){
	 * compositeAction.getPM_IL_PROP_TREATY_TYPE_ACTION().getCOMP_BUTTON_TYPE_TTY_COVER_DETIALS().setDisabled(true);
	 * System.out.println("COMP_BUTTON_TYPE_TTY_COVER_DETIALS : Disabled");
	 * }else if(inputValue.trim().equals("B")){
	 * compositeAction.getPM_IL_PROP_TREATY_TYPE_ACTION().getCOMP_BUTTON_TYPE_TTY_COVER_DETIALS().setDisabled(false); } }
	 */

	public void validatePT_RIDER_BASIS_LIST(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		PM_IL_PROP_TREATY_BEAN.setPT_RIDER_RI_BASIS(inputValue);

		HtmlCommandButton COMP_BUTTON_TYPE_TTY_COVER_DETIALS = new HtmlCommandButton();
		if (inputValue.trim().equals("S")) {

			COMP_BUTTON_TYPE_TTY_COVER_DETIALS.setDisabled(true);
			compositeAction.getPM_IL_PROP_TREATY_TYPE_ACTION()
					.setCOMP_BUTTON_TYPE_TTY_COVER_DETIALS(
							COMP_BUTTON_TYPE_TTY_COVER_DETIALS);
		} else if (inputValue.trim().equals("B")) {
			COMP_BUTTON_TYPE_TTY_COVER_DETIALS.setDisabled(false);
			compositeAction.getPM_IL_PROP_TREATY_TYPE_ACTION()
					.setCOMP_BUTTON_TYPE_TTY_COVER_DETIALS(
							COMP_BUTTON_TYPE_TTY_COVER_DETIALS);

		}

	}
	
	public void corridirLimit(FacesContext facesContext,UIComponent component,Object value) {
		try{
				if((String)value!=null){
				double corridorLimit = Double.parseDouble((String)COMP_PT_CORIDOR_LC_LIMIT.getSubmittedValue());
				PM_IL_PROP_TREATY_BEAN.setPT_CORIDOR_LC_LIMIT(corridorLimit);
				masterHelper.chechForNegative(corridorLimit);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}		
	}

	/* Validation For Cover */

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void riderBasisValidation(FacesContext facesContext,
			UIComponent component, Object object) {
		if (object != null) {
			String riderValue = (String) object;
			PM_IL_PROP_TREATY_BEAN.setPT_RIDER_RI_BASIS(riderValue);
		}
	}

	public void COMP_PT_UW_YEAR_DESC_WHEN_VALIDATE(ActionEvent e) {
		UIInput input = (UIInput) e.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public String copyAction() {
		try{
			compositeAction.setCTRL_1_ACTION(new CTRL_1_ACTION());
			compositeAction.getCTRL_1_ACTION().compositeAction = compositeAction;
			compositeAction.getCTRL_1_ACTION().getErrorMap().clear();
			compositeAction.getCTRL_1_ACTION().getWarningMap().clear();
			compositeAction.getCTRL_1_ACTION().getCTRL_1_BEAN().setUI_M_CP_TREATY_CODE(PM_IL_PROP_TREATY_BEAN.getPT_TREATY_CODE());
			compositeAction.getCTRL_1_ACTION().getCTRL_1_BEAN().setUI_M_CP_TREATY_DESC(PM_IL_PROP_TREATY_BEAN.getPT_TREATY_DESC());
			compositeAction.getCTRL_1_ACTION().getCTRL_1_BEAN().setUI_M_CP_UW_YEAR(PM_IL_PROP_TREATY_BEAN.getPT_UW_YEAR());
		}catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
		
		return "goToCopyPage";
	}

	public void validatorPT_CORIDOR_LC_LIMIT(FacesContext context, UIComponent component, Object value){
        try{
			if(value!=null){
				double corridorLimit = Double.parseDouble((String)COMP_PT_CORIDOR_LC_LIMIT.getSubmittedValue());
				PM_IL_PROP_TREATY_BEAN.setPT_CORIDOR_LC_LIMIT(corridorLimit);
				masterHelper.chechForNegative(corridorLimit);
			}
        }catch(Exception e){
        	e.printStackTrace();
        	throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
	}
	
	public void validatePT_CORIDOR_LC_LIMIT(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void validatePT_TREATY_DESC(ActionEvent event){
		String PT_TREATY_DESC = (String) getCOMP_PT_TREATY_DESC().getSubmittedValue();
		getPM_IL_PROP_TREATY_BEAN().setPT_TREATY_DESC(PT_TREATY_DESC);
	}

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}
	
	public void onLoad(PhaseEvent event){
		try{
			if(isBlockFlag()){
				delegate.executeQuery(compositeAction);
				if(PM_IL_PROP_TREATY_BEAN.getROWID() != null){
					masterHelper.pilm015_apac_pm_il_prop_treaty_post_query(compositeAction);
				}else{
					masterHelper.pilm015_apac_pm_il_prop_treaty_when_create_record(compositeAction);
				}
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

}
