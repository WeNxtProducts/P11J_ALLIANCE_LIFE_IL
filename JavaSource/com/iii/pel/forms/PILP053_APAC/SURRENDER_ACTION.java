package com.iii.pel.forms.PILP053_APAC;

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
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import oracle.jdbc.driver.OracleBlobInputStream;

import org.ajax4jsf.component.html.HtmlAjaxRegion;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.apps.tahoe.appbuilder.guidesigner.Common;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class SURRENDER_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_POL_PROD_CODE_LABEL;

	private HtmlInputText COMP_UI_M_POL_PROD_CODE;

	private HtmlOutputLabel COMP_UI_M_POL_PROD_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POL_PROD_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_POL_CUST_CODE_LABEL;

	private HtmlInputText COMP_UI_M_POL_CUST_CODE;

	private HtmlOutputLabel COMP_UI_M_POL_CUST_NAME_LABEL;

	private HtmlInputText COMP_UI_M_POL_CUST_NAME;

	private HtmlOutputLabel COMP_UI_M_POL_PLAN_CODE_LABEL;

	private HtmlInputText COMP_UI_M_POL_PLAN_CODE;

	private HtmlOutputLabel COMP_UI_M_POL_PLAN_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POL_PLAN_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_SMV_REASON_CODE_LABEL;

	private HtmlInputText COMP_UI_M_SMV_REASON_CODE;

	private HtmlOutputLabel COMP_UI_M_SMV_REASON_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_SMV_REASON_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_SMV_REMARKS_LABEL;

	private HtmlInputText COMP_UI_M_SMV_REMARKS;

	private HtmlOutputLabel COMP_UI_M_POL_START_DT_LABEL;

	private HtmlCalendar COMP_UI_M_POL_START_DT;

	private HtmlOutputLabel COMP_UI_M_POL_EXPIRY_DT_LABEL;

	private HtmlCalendar COMP_UI_M_POL_EXPIRY_DT;

	private HtmlOutputLabel COMP_UI_M_PC_SCHD_PYMT_DT_LABEL;

	private HtmlCalendar COMP_UI_M_PC_SCHD_PYMT_DT;

	private HtmlOutputLabel COMP_UI_M_N_PC_SCHD_PYMT_DT_LABEL;

	private HtmlCalendar COMP_UI_M_N_PC_SCHD_PYMT_DT;

	private HtmlOutputLabel COMP_UI_M_PC_SURR_LETTER_DATE_LABEL;

	private HtmlCalendar COMP_UI_M_PC_SURR_LETTER_DATE;

	private HtmlOutputLabel COMP_UI_M_M_PC_SCHD_PYMT_DT_LABEL;

	private HtmlCalendar COMP_UI_M_M_PC_SCHD_PYMT_DT;

	private HtmlOutputLabel COMP_UI_M_ASSURED_CODE_LABEL;

	private HtmlInputText COMP_UI_M_ASSURED_CODE;

	private HtmlOutputLabel COMP_UI_M_ASSURED_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ASSURED_NAME;

	private HtmlOutputLabel COMP_SMV_FC_NET_PAID_AMT_LABEL;

	private HtmlInputText COMP_SMV_FC_NET_PAID_AMT;

	private HtmlOutputLabel COMP_UI_M_R_PC_SCHD_PYMT_DT_LABEL;

	private HtmlCalendar COMP_UI_M_R_PC_SCHD_PYMT_DT;
	
private HtmlOutputLabel COMP_SMV_FC_RED_SA_LABEL;
	
	private HtmlInputText COMP_SMV_FC_RED_SA; 
	
	private HtmlOutputLabel COMP_SMV_LC_RED_SA_LABEL;
	
	private HtmlInputText COMP_SMV_LC_RED_SA;
	boolean region_render_flag;
	private HtmlAjaxRegion COMP_RED_SA;
	private HtmlOutputLabel COMP_SMV_FC_ACC_PROFIT_LABEL;
	
	private HtmlInputText COMP_SMV_FC_ACC_PROFIT; 
	
	private HtmlOutputLabel COMP_SMV_LC_ACC_PROFIT_LABEL;
	
	private HtmlInputText COMP_SMV_LC_ACC_PROFIT;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO_FM;

	private HtmlCommandButton COMP_PUSH_BUTTON685;

	private SURRENDER SURRENDER_BEAN;

	private HtmlCommandButton COMP_UI_M_BUT_OK;

/*	added by ram*/

	
	private List<SelectItem> listSURRENDER_CHRG = new ArrayList<SelectItem>();
	
	
	public List<SelectItem> getListSURRENDER_CHRG() {
		return listSURRENDER_CHRG;
	}

	public void setListSURRENDER_CHRG(List<SelectItem> listSURRENDER_CHRG) {
		this.listSURRENDER_CHRG = listSURRENDER_CHRG;
	}


	/*end*/
	public HtmlCommandButton getCOMP_UI_M_BUT_OK() {
		return COMP_UI_M_BUT_OK;
	}

	public void setCOMP_UI_M_BUT_OK(HtmlCommandButton cOMP_UI_M_BUT_OK) {
		COMP_UI_M_BUT_OK = cOMP_UI_M_BUT_OK;
	}

	public SURRENDER_HELPER getHelper() {
		return helper;
	}

	public void setHelper(SURRENDER_HELPER helper) {
		this.helper = helper;
	}

	public PILP053_APAC_COMPOSITE_ACTION compositeAction;

	private SURRENDER_HELPER helper;

	public SURRENDER_ACTION() {

		SURRENDER_BEAN = new SURRENDER();
		helper = new SURRENDER_HELPER();
	}

	public void resetAllComponents() {

		COMP_UI_M_POL_PROD_CODE.resetValue();
		COMP_UI_M_POL_PROD_CODE_DESC.resetValue();
		COMP_UI_M_POL_CUST_CODE.resetValue();
		COMP_UI_M_POL_CUST_NAME.resetValue();
		COMP_UI_M_POL_PLAN_CODE.resetValue();
		COMP_UI_M_POL_PLAN_CODE_DESC.resetValue();
		COMP_UI_M_SMV_REASON_CODE.resetValue();
		COMP_UI_M_SMV_REASON_CODE_DESC.resetValue();
		COMP_UI_M_SMV_REMARKS.resetValue();
		COMP_UI_M_POL_START_DT.resetValue();
		COMP_UI_M_POL_EXPIRY_DT.resetValue();
		COMP_UI_M_PC_SCHD_PYMT_DT.resetValue();
		COMP_UI_M_N_PC_SCHD_PYMT_DT.resetValue();
		COMP_UI_M_PC_SURR_LETTER_DATE.resetValue();
		COMP_UI_M_M_PC_SCHD_PYMT_DT.resetValue();
		COMP_UI_M_ASSURED_CODE.resetValue();
		COMP_UI_M_ASSURED_NAME.resetValue();
		COMP_SMV_FC_NET_PAID_AMT.resetValue();
		COMP_UI_M_R_PC_SCHD_PYMT_DT.resetValue();
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_PROD_CODE_LABEL() {
		return COMP_UI_M_POL_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_PROD_CODE() {
		return COMP_UI_M_POL_PROD_CODE;
	}

	public void setCOMP_UI_M_POL_PROD_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_PROD_CODE_LABEL) {
		this.COMP_UI_M_POL_PROD_CODE_LABEL = COMP_UI_M_POL_PROD_CODE_LABEL;
	}

	public void setCOMP_UI_M_POL_PROD_CODE(HtmlInputText COMP_UI_M_POL_PROD_CODE) {
		this.COMP_UI_M_POL_PROD_CODE = COMP_UI_M_POL_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_PROD_CODE_DESC_LABEL() {
		return COMP_UI_M_POL_PROD_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_PROD_CODE_DESC() {
		return COMP_UI_M_POL_PROD_CODE_DESC;
	}

	public void setCOMP_UI_M_POL_PROD_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_PROD_CODE_DESC_LABEL) {
		this.COMP_UI_M_POL_PROD_CODE_DESC_LABEL = COMP_UI_M_POL_PROD_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_POL_PROD_CODE_DESC(
			HtmlInputText COMP_UI_M_POL_PROD_CODE_DESC) {
		this.COMP_UI_M_POL_PROD_CODE_DESC = COMP_UI_M_POL_PROD_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_CUST_CODE_LABEL() {
		return COMP_UI_M_POL_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_CUST_CODE() {
		return COMP_UI_M_POL_CUST_CODE;
	}

	public void setCOMP_UI_M_POL_CUST_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_CUST_CODE_LABEL) {
		this.COMP_UI_M_POL_CUST_CODE_LABEL = COMP_UI_M_POL_CUST_CODE_LABEL;
	}

	public void setCOMP_UI_M_POL_CUST_CODE(HtmlInputText COMP_UI_M_POL_CUST_CODE) {
		this.COMP_UI_M_POL_CUST_CODE = COMP_UI_M_POL_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_CUST_NAME_LABEL() {
		return COMP_UI_M_POL_CUST_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_CUST_NAME() {
		return COMP_UI_M_POL_CUST_NAME;
	}

	public void setCOMP_UI_M_POL_CUST_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_CUST_NAME_LABEL) {
		this.COMP_UI_M_POL_CUST_NAME_LABEL = COMP_UI_M_POL_CUST_NAME_LABEL;
	}

	public void setCOMP_UI_M_POL_CUST_NAME(HtmlInputText COMP_UI_M_POL_CUST_NAME) {
		this.COMP_UI_M_POL_CUST_NAME = COMP_UI_M_POL_CUST_NAME;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_PLAN_CODE_LABEL() {
		return COMP_UI_M_POL_PLAN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_PLAN_CODE() {
		return COMP_UI_M_POL_PLAN_CODE;
	}

	public void setCOMP_UI_M_POL_PLAN_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_PLAN_CODE_LABEL) {
		this.COMP_UI_M_POL_PLAN_CODE_LABEL = COMP_UI_M_POL_PLAN_CODE_LABEL;
	}

	public void setCOMP_UI_M_POL_PLAN_CODE(HtmlInputText COMP_UI_M_POL_PLAN_CODE) {
		this.COMP_UI_M_POL_PLAN_CODE = COMP_UI_M_POL_PLAN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_PLAN_CODE_DESC_LABEL() {
		return COMP_UI_M_POL_PLAN_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_PLAN_CODE_DESC() {
		return COMP_UI_M_POL_PLAN_CODE_DESC;
	}

	public void setCOMP_UI_M_POL_PLAN_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_PLAN_CODE_DESC_LABEL) {
		this.COMP_UI_M_POL_PLAN_CODE_DESC_LABEL = COMP_UI_M_POL_PLAN_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_POL_PLAN_CODE_DESC(
			HtmlInputText COMP_UI_M_POL_PLAN_CODE_DESC) {
		this.COMP_UI_M_POL_PLAN_CODE_DESC = COMP_UI_M_POL_PLAN_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_SMV_REASON_CODE_LABEL() {
		return COMP_UI_M_SMV_REASON_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_SMV_REASON_CODE() {
		return COMP_UI_M_SMV_REASON_CODE;
	}

	public void setCOMP_UI_M_SMV_REASON_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_SMV_REASON_CODE_LABEL) {
		this.COMP_UI_M_SMV_REASON_CODE_LABEL = COMP_UI_M_SMV_REASON_CODE_LABEL;
	}

	public void setCOMP_UI_M_SMV_REASON_CODE(
			HtmlInputText COMP_UI_M_SMV_REASON_CODE) {
		this.COMP_UI_M_SMV_REASON_CODE = COMP_UI_M_SMV_REASON_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_SMV_REASON_CODE_DESC_LABEL() {
		return COMP_UI_M_SMV_REASON_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_SMV_REASON_CODE_DESC() {
		return COMP_UI_M_SMV_REASON_CODE_DESC;
	}

	public void setCOMP_UI_M_SMV_REASON_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_SMV_REASON_CODE_DESC_LABEL) {
		this.COMP_UI_M_SMV_REASON_CODE_DESC_LABEL = COMP_UI_M_SMV_REASON_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_SMV_REASON_CODE_DESC(
			HtmlInputText COMP_UI_M_SMV_REASON_CODE_DESC) {
		this.COMP_UI_M_SMV_REASON_CODE_DESC = COMP_UI_M_SMV_REASON_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_SMV_REMARKS_LABEL() {
		return COMP_UI_M_SMV_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_SMV_REMARKS() {
		return COMP_UI_M_SMV_REMARKS;
	}

	public void setCOMP_UI_M_SMV_REMARKS_LABEL(
			HtmlOutputLabel COMP_UI_M_SMV_REMARKS_LABEL) {
		this.COMP_UI_M_SMV_REMARKS_LABEL = COMP_UI_M_SMV_REMARKS_LABEL;
	}

	public void setCOMP_UI_M_SMV_REMARKS(HtmlInputText COMP_UI_M_SMV_REMARKS) {
		this.COMP_UI_M_SMV_REMARKS = COMP_UI_M_SMV_REMARKS;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_START_DT_LABEL() {
		return COMP_UI_M_POL_START_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_POL_START_DT() {
		return COMP_UI_M_POL_START_DT;
	}

	public void setCOMP_UI_M_POL_START_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_START_DT_LABEL) {
		this.COMP_UI_M_POL_START_DT_LABEL = COMP_UI_M_POL_START_DT_LABEL;
	}

	public void setCOMP_UI_M_POL_START_DT(HtmlCalendar COMP_UI_M_POL_START_DT) {
		this.COMP_UI_M_POL_START_DT = COMP_UI_M_POL_START_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_EXPIRY_DT_LABEL() {
		return COMP_UI_M_POL_EXPIRY_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_POL_EXPIRY_DT() {
		return COMP_UI_M_POL_EXPIRY_DT;
	}

	public void setCOMP_UI_M_POL_EXPIRY_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_EXPIRY_DT_LABEL) {
		this.COMP_UI_M_POL_EXPIRY_DT_LABEL = COMP_UI_M_POL_EXPIRY_DT_LABEL;
	}

	public void setCOMP_UI_M_POL_EXPIRY_DT(HtmlCalendar COMP_UI_M_POL_EXPIRY_DT) {
		this.COMP_UI_M_POL_EXPIRY_DT = COMP_UI_M_POL_EXPIRY_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_SCHD_PYMT_DT_LABEL() {
		return COMP_UI_M_PC_SCHD_PYMT_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_PC_SCHD_PYMT_DT() {
		return COMP_UI_M_PC_SCHD_PYMT_DT;
	}

	public void setCOMP_UI_M_PC_SCHD_PYMT_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_SCHD_PYMT_DT_LABEL) {
		this.COMP_UI_M_PC_SCHD_PYMT_DT_LABEL = COMP_UI_M_PC_SCHD_PYMT_DT_LABEL;
	}

	public void setCOMP_UI_M_PC_SCHD_PYMT_DT(
			HtmlCalendar COMP_UI_M_PC_SCHD_PYMT_DT) {
		this.COMP_UI_M_PC_SCHD_PYMT_DT = COMP_UI_M_PC_SCHD_PYMT_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_N_PC_SCHD_PYMT_DT_LABEL() {
		return COMP_UI_M_N_PC_SCHD_PYMT_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_N_PC_SCHD_PYMT_DT() {
		return COMP_UI_M_N_PC_SCHD_PYMT_DT;
	}

	public void setCOMP_UI_M_N_PC_SCHD_PYMT_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_N_PC_SCHD_PYMT_DT_LABEL) {
		this.COMP_UI_M_N_PC_SCHD_PYMT_DT_LABEL = COMP_UI_M_N_PC_SCHD_PYMT_DT_LABEL;
	}

	public void setCOMP_UI_M_N_PC_SCHD_PYMT_DT(
			HtmlCalendar COMP_UI_M_N_PC_SCHD_PYMT_DT) {
		this.COMP_UI_M_N_PC_SCHD_PYMT_DT = COMP_UI_M_N_PC_SCHD_PYMT_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_SURR_LETTER_DATE_LABEL() {
		return COMP_UI_M_PC_SURR_LETTER_DATE_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_PC_SURR_LETTER_DATE() {
		return COMP_UI_M_PC_SURR_LETTER_DATE;
	}

	public void setCOMP_UI_M_PC_SURR_LETTER_DATE_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_SURR_LETTER_DATE_LABEL) {
		this.COMP_UI_M_PC_SURR_LETTER_DATE_LABEL = COMP_UI_M_PC_SURR_LETTER_DATE_LABEL;
	}

	public void setCOMP_UI_M_PC_SURR_LETTER_DATE(
			HtmlCalendar COMP_UI_M_PC_SURR_LETTER_DATE) {
		this.COMP_UI_M_PC_SURR_LETTER_DATE = COMP_UI_M_PC_SURR_LETTER_DATE;
	}

	public HtmlOutputLabel getCOMP_UI_M_M_PC_SCHD_PYMT_DT_LABEL() {
		return COMP_UI_M_M_PC_SCHD_PYMT_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_M_PC_SCHD_PYMT_DT() {
		return COMP_UI_M_M_PC_SCHD_PYMT_DT;
	}

	public void setCOMP_UI_M_M_PC_SCHD_PYMT_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_M_PC_SCHD_PYMT_DT_LABEL) {
		this.COMP_UI_M_M_PC_SCHD_PYMT_DT_LABEL = COMP_UI_M_M_PC_SCHD_PYMT_DT_LABEL;
	}

	public void setCOMP_UI_M_M_PC_SCHD_PYMT_DT(
			HtmlCalendar COMP_UI_M_M_PC_SCHD_PYMT_DT) {
		this.COMP_UI_M_M_PC_SCHD_PYMT_DT = COMP_UI_M_M_PC_SCHD_PYMT_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_ASSURED_CODE_LABEL() {
		return COMP_UI_M_ASSURED_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ASSURED_CODE() {
		return COMP_UI_M_ASSURED_CODE;
	}

	public void setCOMP_UI_M_ASSURED_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_ASSURED_CODE_LABEL) {
		this.COMP_UI_M_ASSURED_CODE_LABEL = COMP_UI_M_ASSURED_CODE_LABEL;
	}

	public void setCOMP_UI_M_ASSURED_CODE(HtmlInputText COMP_UI_M_ASSURED_CODE) {
		this.COMP_UI_M_ASSURED_CODE = COMP_UI_M_ASSURED_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ASSURED_NAME_LABEL() {
		return COMP_UI_M_ASSURED_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ASSURED_NAME() {
		return COMP_UI_M_ASSURED_NAME;
	}

	public void setCOMP_UI_M_ASSURED_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_ASSURED_NAME_LABEL) {
		this.COMP_UI_M_ASSURED_NAME_LABEL = COMP_UI_M_ASSURED_NAME_LABEL;
	}

	public void setCOMP_UI_M_ASSURED_NAME(HtmlInputText COMP_UI_M_ASSURED_NAME) {
		this.COMP_UI_M_ASSURED_NAME = COMP_UI_M_ASSURED_NAME;
	}

	public HtmlOutputLabel getCOMP_SMV_FC_NET_PAID_AMT_LABEL() {
		return COMP_SMV_FC_NET_PAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_SMV_FC_NET_PAID_AMT() {
		return COMP_SMV_FC_NET_PAID_AMT;
	}

	public void setCOMP_SMV_FC_NET_PAID_AMT_LABEL(
			HtmlOutputLabel COMP_SMV_FC_NET_PAID_AMT_LABEL) {
		this.COMP_SMV_FC_NET_PAID_AMT_LABEL = COMP_SMV_FC_NET_PAID_AMT_LABEL;
	}

	public void setCOMP_SMV_FC_NET_PAID_AMT(
			HtmlInputText COMP_SMV_FC_NET_PAID_AMT) {
		this.COMP_SMV_FC_NET_PAID_AMT = COMP_SMV_FC_NET_PAID_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_R_PC_SCHD_PYMT_DT_LABEL() {
		return COMP_UI_M_R_PC_SCHD_PYMT_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_R_PC_SCHD_PYMT_DT() {
		return COMP_UI_M_R_PC_SCHD_PYMT_DT;
	}

	public void setCOMP_UI_M_R_PC_SCHD_PYMT_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_R_PC_SCHD_PYMT_DT_LABEL) {
		this.COMP_UI_M_R_PC_SCHD_PYMT_DT_LABEL = COMP_UI_M_R_PC_SCHD_PYMT_DT_LABEL;
	}

	public void setCOMP_UI_M_R_PC_SCHD_PYMT_DT(
			HtmlCalendar COMP_UI_M_R_PC_SCHD_PYMT_DT) {
		this.COMP_UI_M_R_PC_SCHD_PYMT_DT = COMP_UI_M_R_PC_SCHD_PYMT_DT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_POL_NO_FM() {
		return COMP_UI_M_BUT_LOV_POL_NO_FM;
	}

	public void setCOMP_UI_M_BUT_LOV_POL_NO_FM(
			HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO_FM) {
		this.COMP_UI_M_BUT_LOV_POL_NO_FM = COMP_UI_M_BUT_LOV_POL_NO_FM;
	}

	public HtmlCommandButton getCOMP_PUSH_BUTTON685() {
		return COMP_PUSH_BUTTON685;
	}

	public void setCOMP_PUSH_BUTTON685(HtmlCommandButton COMP_PUSH_BUTTON685) {
		this.COMP_PUSH_BUTTON685 = COMP_PUSH_BUTTON685;
	}

	public SURRENDER getSURRENDER_BEAN() {
		return SURRENDER_BEAN;
	}

	public void setSURRENDER_BEAN(SURRENDER SURRENDER_BEAN) {
		this.SURRENDER_BEAN = SURRENDER_BEAN;
	}

	public void saveRecord() {
		try {
			if (getSURRENDER_BEAN().getROWID() != null) {
				new CRUDHandler().executeInsert(getSURRENDER_BEAN(),
						CommonUtils.getConnection());
			} else {
				new CRUDHandler().executeInsert(getSURRENDER_BEAN(),
						CommonUtils.getConnection());
			}
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				HideDetails();
				 
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	public void HideDetails()throws Exception{
		Connection con=null;
		CRUDHandler handler=null;
		ResultSet rs=null;
		int val=0;
		try{
			String c1="SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE LIKE'IL_CALC_MTHD'";
			handler=new CRUDHandler();
			rs=handler.executeSelectStatement(c1, con);
			while(rs.next()){
				val=rs.getInt(1);
			}
			if(val==1){
				region_render_flag=false;
			}else if(val==2){
				region_render_flag=true;
			}
					}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
			
		}finally{
			CommonUtils.closeCursor(rs);
		}
	}

	public List<LovBean> lovUI_M_SMV_REASON_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILP053_APAC",
					"SURRENDER", "M_SMV_REASON_CODE", "IL_REASON", "6", null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public void UI_M_SMV_REASON_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getSURRENDER_BEAN().setUI_M_SMV_REASON_CODE((String) value);
			helper.WHEN_VALIDATE_ITEM_M_SMV_REASON_CODE(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	

	public String processButAction() {
		SURRENDER surrender_bean = compositeAction.getSURRENDER_ACTION_BEAN()
				.getSURRENDER_BEAN();
		String M_PROD_SURR_CALC_TYPE = null;
	
		PT_IL_SUR_MAT_VALUES pt_il_sur_mat_values_bean = compositeAction
				.getPT_IL_SUR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SUR_MAT_VALUES_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		String M_COMP_CODE = CommonUtils
				.getGlobalVariable("GLOBAL.M_COMP_CODE");
		String CTRL_M_USER_ID = CommonUtils
				.getGlobalVariable("GLOBAL.M_USER_ID");
		String GLOBAL_M_PARA_2 = CommonUtils
				.getGlobalVariable("GLOBAL.M_PARAM_2");
		
		ResultSet rs1=null,rs2=null;
		Connection connection=null;
		String query2=" SELECT SMV_FC_RED_SA,SMV_LC_RED_SA,SMV_FC_ACC_PROFIT,SMV_LC_ACC_PROFIT FROM PT_IL_SURR_MAT_VALUES WHERE SMV_POL_SYS_ID = ?";
		String query1="SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO=?";
		String Smv_Pol_Sys_id=null;
		try {
			
			/*String MENUPARAM = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1");
			if(pt_il_sur_mat_values_bean.getUI_M_DOC_NO() == null || pt_il_sur_mat_values_bean.getUI_M_DOC_NO().isEmpty()){
				ArrayList<OracleParameter> stringValue = P_GEN_DOC_NO("8", MENUPARAM,surrender_bean.getUI_M_POL_DIVN_CODE(), 
						surrender_bean.getUI_M_POL_CLASS_CODE(),surrender_bean.getUI_M_POL_PLAN_CODE(), 
						surrender_bean.getUI_M_POL_PROD_CODE(),CommonUtils.integerToString(surrender_bean.getUI_M_POL_UW_YEAR()), 
						"","PT_IL_PRE_CLAIMS_INFO", 
						"N",CommonUtils.getProcedureValue(new CommonUtils().getCurrentDate()),"S", 
						CommonUtils.getProcedureValue(new CommonUtils().getCurrentDate()));
				pt_il_sur_mat_values_bean.setUI_M_DOC_NO((String)stringValue.get(0).getValue());
			}
			*/
			
			/*added by ram*/

			System.out.println("getUI_M_SURRENDER_CHRG     "+
			compositeAction.getSURRENDER_ACTION_BEAN().getSURRENDER_BEAN().getUI_M_SURRENDER_CHRG());
			
			/*end*/
			
			ArrayList<String> returnList = helper.WHEN_M_OK_BUTTON_PRESSED(
					surrender_bean.getUI_M_POL_NO(), surrender_bean
							.getUI_M_POL_PROD_CODE(), pt_il_sur_mat_values_bean
							.getUI_M_DOC_NO(), M_COMP_CODE,
					pt_il_sur_mat_values_bean.getPOL_NO(), CommonUtils
							.getProcedureValue(surrender_bean
									.getUI_M_R_PC_SCHD_PYMT_DT()), CommonUtils
							.getProcedureValue(surrender_bean
									.getUI_M_POL_START_DT()), CommonUtils
							.getProcedureValue(surrender_bean
									.getUI_M_POL_EXPIRY_DT()), CommonUtils
							.getProcedureValue(dummy_bean.getUI_M_POL_SYS_ID()
									.longValue()), dummy_bean
							.getUI_M_BASE_CURR(), CommonUtils
							.getProcedureValue(dummy_bean
									.getUI_M_POL_CUST_EXCH_RATE()),
					surrender_bean.getUI_M_POL_PLAN_CODE(), surrender_bean
							.getUI_M_POL_CUST_CODE(), dummy_bean
							.getUI_M_POL_SA_CURR_CODE(), dummy_bean
							.getUI_M_POL_CUST_CURR_CODE(), CommonUtils
							.getProcedureValue(dummy_bean
									.getUI_M_POL_SA_EXCH_RATE()),
					CTRL_M_USER_ID, GLOBAL_M_PARA_2, CommonUtils
							.getProcedureValue(surrender_bean
									.getUI_M_PC_SCHD_PYMT_DT()), CommonUtils
							.getProcedureValue(surrender_bean
									.getUI_M_PC_SURR_LETTER_DATE()),
					CommonUtils.getProcedureValue(surrender_bean
							.getUI_M_N_PC_SCHD_PYMT_DT()), surrender_bean
							.getUI_M_SMV_REASON_CODE(), surrender_bean
							.getUI_M_SMV_REMARKS(), M_PROD_SURR_CALC_TYPE,
							compositeAction.getSURRENDER_ACTION_BEAN().getSURRENDER_BEAN().getUI_M_SURRENDER_CHRG());
			M_PROD_SURR_CALC_TYPE = returnList.get(0);
			if ("U".equalsIgnoreCase(M_PROD_SURR_CALC_TYPE)) {
				return "PILP053_APAC_PW_IL_REVIEW_MED_DTL";
			} else {
				CommonUtils.setGlobalVariable("GLOBAL.M_ENABLE", "1");
				String message = Messages.getString(
						PELConstants.pelErrorMessagePath, "60315");
				compositeAction.getPT_IL_SUR_MAT_VALUES_ACTION_BEAN()
						.getWarningMap().put(
								PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								message);
				
				compositeAction.getPT_IL_SUR_MAT_VALUES_ACTION_BEAN()
				.getWarningMap().put(
						"PROCESS",
						message);
				
				compositeAction.getPT_IL_SUR_MAT_VALUES_ACTION_BEAN().getPT_IL_SUR_MAT_VALUES_BEAN().setUI_PROCESS_YN("Y");
				
				
				//compositeAction.getPT_IL_SUR_MAT_VALUES_ACTION_BEAN().setBlockFlag(true);
				
				// [Added by Vinoj to fix P11JLIFEQC-1677716] 
				connection=CommonUtils.getConnection();
				Object[] val=new Object[] {pt_il_sur_mat_values_bean.getPOL_NO()};
				rs1=new CRUDHandler().executeSelectStatement(query1,connection, val);
				if(rs1.next()){
					Smv_Pol_Sys_id	=rs1.getString(1);
				}
				rs2=new CRUDHandler().executeSelectStatement(query2, connection,new Object[] {Smv_Pol_Sys_id});
				if(rs2.next()){
					surrender_bean.setSMV_FC_RED_SA(rs2.getDouble(1));
					surrender_bean.setSMV_LC_RED_SA(rs2.getDouble(2));
					surrender_bean.setSMV_FC_ACC_PROFIT(rs2.getDouble(3));
					surrender_bean.setSMV_LC_ACC_PROFIT(rs2.getDouble(4));
				}
				COMP_SMV_FC_RED_SA.resetValue();
				COMP_SMV_FC_ACC_PROFIT.resetValue();
				COMP_SMV_LC_RED_SA.resetValue();
				COMP_SMV_LC_ACC_PROFIT.resetValue();
			}
			//compositeAction.getPT_IL_SUR_MAT_VALUES_ACTION_BEAN().setBlockFlag(true);
			
		} catch (Exception e) {
			e.printStackTrace();
			compositeAction.getPT_IL_SUR_MAT_VALUES_ACTION_BEAN().getErrorMap()
				.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			compositeAction.getPT_IL_SUR_MAT_VALUES_ACTION_BEAN().getErrorMap()
				.put("processButAction", e.getMessage());
		}
		
		return "PILP053_APAC_PT_IL_SUR_MAT_VALUES";
	}
	
	 public ArrayList<OracleParameter> P_GEN_DOC_NO(String P_DOC_TYPE,
				String P_DOC_CODE, String P_DIVN_CODE, String P_CLASS_CODE,
				String P_PLAN_CODE, String P_PROD_CODE, String P_UW_YEAR,
				String P_DOC_NO_FN, String P_BLOCK_NAME, String P_DUMMY_YN,
				String P_DATE, String P_CLAIM_TYPE, String P_REG_DATE,
				
				/*Added by Janani on 21.05.2018 for Fidelity endorsement setup issue*/
				String P_POL_NO
				/*End*/
			 )
				throws ProcedureException {
			Connection connection = null;
			ArrayList<OracleParameter> parameterList = null;
			ArrayList<OracleParameter> outputList = null;
			try {
				connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
				OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
						P_DOC_TYPE);
				parameterList.add(param1);
				OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
						P_DOC_CODE);
				parameterList.add(param2);
				OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
						P_DIVN_CODE);
				parameterList.add(param3);
				OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
						P_CLASS_CODE);
				parameterList.add(param4);
				OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",
						P_PLAN_CODE);
				parameterList.add(param5);
				OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",
						P_PROD_CODE);
				parameterList.add(param6);
				OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",
						P_UW_YEAR);
				parameterList.add(param7);
				OracleParameter param8 = new OracleParameter("IN OUT8", "STRING",
						"IN OUT", P_DOC_NO_FN);
				parameterList.add(param8);
				OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",
						P_BLOCK_NAME);
				parameterList.add(param9);
				OracleParameter param10 = new OracleParameter("IN10", "STRING",
						"IN", P_DUMMY_YN);
				parameterList.add(param10);
				OracleParameter param11 = new OracleParameter("IN11", "STRING",
						"IN", P_DATE);
				parameterList.add(param11);
				OracleParameter param12 = new OracleParameter("IN12", "STRING",
						"IN", P_CLAIM_TYPE);
				parameterList.add(param12);
				OracleParameter param13 = new OracleParameter("IN13", "STRING",
						"IN", P_REG_DATE);
				parameterList.add(param13);
				
				
				 /*Added by Janani on 21.05.2018 for Fidelity endorsement setup issue*/
		        
		        OracleParameter param14 = new OracleParameter("IN14", "STRING", "IN",P_POL_NO);
		        parameterList.add(param14);
		       	        
		        /*End*/

				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				outputList = procHandler.execute(parameterList, connection,
						"LIFELIB.P_GEN_DOC_NO");
			} catch (Exception e) {
				ErrorHelpUtil.getErrorForProcedure(connection);
				throw new ProcedureException(e.getMessage());
			}
			return outputList;
		}

	public HtmlOutputLabel getCOMP_SMV_FC_RED_SA_LABEL() {
		return COMP_SMV_FC_RED_SA_LABEL;
	}

	public void setCOMP_SMV_FC_RED_SA_LABEL(HtmlOutputLabel comp_smv_fc_red_sa_label) {
		COMP_SMV_FC_RED_SA_LABEL = comp_smv_fc_red_sa_label;
	}

	public HtmlInputText getCOMP_SMV_FC_RED_SA() {
		return COMP_SMV_FC_RED_SA;
	}

	public void setCOMP_SMV_FC_RED_SA(HtmlInputText comp_smv_fc_red_sa) {
		COMP_SMV_FC_RED_SA = comp_smv_fc_red_sa;
	}

	public HtmlOutputLabel getCOMP_SMV_LC_RED_SA_LABEL() {
		return COMP_SMV_LC_RED_SA_LABEL;
	}

	public void setCOMP_SMV_LC_RED_SA_LABEL(HtmlOutputLabel comp_smv_lc_red_sa_label) {
		COMP_SMV_LC_RED_SA_LABEL = comp_smv_lc_red_sa_label;
	}

	public HtmlInputText getCOMP_SMV_LC_RED_SA() {
		return COMP_SMV_LC_RED_SA;
	}

	public void setCOMP_SMV_LC_RED_SA(HtmlInputText comp_smv_lc_red_sa) {
		COMP_SMV_LC_RED_SA = comp_smv_lc_red_sa;
	}

	public HtmlOutputLabel getCOMP_SMV_FC_ACC_PROFIT_LABEL() {
		return COMP_SMV_FC_ACC_PROFIT_LABEL;
	}

	public void setCOMP_SMV_FC_ACC_PROFIT_LABEL(
			HtmlOutputLabel comp_smv_fc_acc_profit_label) {
		COMP_SMV_FC_ACC_PROFIT_LABEL = comp_smv_fc_acc_profit_label;
	}

	public HtmlInputText getCOMP_SMV_FC_ACC_PROFIT() {
		return COMP_SMV_FC_ACC_PROFIT;
	}

	public void setCOMP_SMV_FC_ACC_PROFIT(HtmlInputText comp_smv_fc_acc_profit) {
		COMP_SMV_FC_ACC_PROFIT = comp_smv_fc_acc_profit;
	}

	public HtmlOutputLabel getCOMP_SMV_LC_ACC_PROFIT_LABEL() {
		return COMP_SMV_LC_ACC_PROFIT_LABEL;
	}

	public void setCOMP_SMV_LC_ACC_PROFIT_LABEL(
			HtmlOutputLabel comp_smv_lc_acc_profit_label) {
		COMP_SMV_LC_ACC_PROFIT_LABEL = comp_smv_lc_acc_profit_label;
	}

	public HtmlInputText getCOMP_SMV_LC_ACC_PROFIT() {
		return COMP_SMV_LC_ACC_PROFIT;
	}

	public void setCOMP_SMV_LC_ACC_PROFIT(HtmlInputText comp_smv_lc_acc_profit) {
		COMP_SMV_LC_ACC_PROFIT = comp_smv_lc_acc_profit;
	}

	public boolean isRegion_render_flag() {
		return region_render_flag;
	}

	public void setRegion_render_flag(boolean region_render_flag) {
		this.region_render_flag = region_render_flag;
	}

	public HtmlAjaxRegion getCOMP_RED_SA() {
		return COMP_RED_SA;
	}

	public void setCOMP_RED_SA(HtmlAjaxRegion comp_red_sa) {
		COMP_RED_SA = comp_red_sa;
	}
	
/*	added by ram*/


	
	private HtmlOutputLabel COMP_SURRENDER_CHARGE_LABEL;
	private HtmlSelectOneMenu COMP_UI_M_SURRENDER_CHRG;
	
	public HtmlOutputLabel getCOMP_SURRENDER_CHARGE_LABEL() {
		return COMP_SURRENDER_CHARGE_LABEL;
	}

	public void setCOMP_SURRENDER_CHARGE_LABEL(
			HtmlOutputLabel cOMP_SURRENDER_CHARGE_LABEL) {
		COMP_SURRENDER_CHARGE_LABEL = cOMP_SURRENDER_CHARGE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_SURRENDER_CHRG() {
		return COMP_UI_M_SURRENDER_CHRG;
	}

	public void setCOMP_UI_M_SURRENDER_CHRG(
			HtmlSelectOneMenu cOMP_UI_M_SURRENDER_CHRG) {
		COMP_UI_M_SURRENDER_CHRG = cOMP_UI_M_SURRENDER_CHRG;
	}
	
	
	
	/*end*/
}
