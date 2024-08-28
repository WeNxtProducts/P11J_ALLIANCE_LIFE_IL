package com.iii.pel.forms.PILM007;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
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

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM011.PM_CODES_ACTION;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_CLM_REPAY_ACTION extends com.iii.premia.common.action.CommonAction {

	private HtmlOutputLabel COMP_CR_COVER_CODE_LABEL;

	private HtmlInputText COMP_CR_COVER_CODE;

	private HtmlOutputLabel COMP_UI_M_COVER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_COVER_DESC;

	private HtmlOutputLabel COMP_CR_LOSS_TYPE_LABEL;

	private HtmlInputText COMP_CR_LOSS_TYPE;

	private HtmlOutputLabel COMP_UI_M_LOSS_DESC_LABEL;

	private HtmlInputText COMP_UI_M_LOSS_DESC;

	private HtmlOutputLabel COMP_CR_DISABLE_TYPE_LABEL;

	private HtmlInputText COMP_CR_DISABLE_TYPE;

	private HtmlOutputLabel COMP_UI_M_DISABLE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DISABLE_DESC;

	private HtmlOutputLabel COMP_CR_RESERVE_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_CR_RESERVE_TYPE;

	private HtmlOutputLabel COMP_CR_RESERVE_OPTIONS_LABEL;

	private HtmlSelectOneMenu COMP_CR_RESERVE_OPTIONS;

	private HtmlOutputLabel COMP_CR_NO_OF_YEARS_LABEL;

	private HtmlInputText COMP_CR_NO_OF_YEARS;

	private HtmlOutputLabel COMP_CR_RESERVE_CR_BASIS_LABEL;

	private HtmlSelectOneMenu COMP_CR_RESERVE_CR_BASIS;

	private HtmlOutputLabel COMP_CR_RATE_LABEL;

	private HtmlInputText COMP_CR_RATE;

	private HtmlOutputLabel COMP_CR_RATE_PER_LABEL;

	private HtmlInputText COMP_CR_RATE_PER;

	private HtmlOutputLabel COMP_CR_APPLIED_ON_LABEL;

	private HtmlSelectOneMenu COMP_CR_APPLIED_ON;

	private HtmlOutputLabel COMP_CR_UNIT_PRICE_LABEL;

	private HtmlSelectOneMenu COMP_CR_UNIT_PRICE;

	private HtmlOutputLabel COMP_CR_PREM_DED_LABEL;

	private HtmlSelectOneMenu COMP_CR_PREM_DED;

	private HtmlOutputLabel COMP_CR_PERIOD_UNIT_LABEL;

	private HtmlSelectOneMenu COMP_CR_PERIOD_UNIT;

	private HtmlOutputLabel COMP_CR_PERIOD_FROM_LABEL;

	private HtmlInputText COMP_CR_PERIOD_FROM;
 
	private HtmlOutputLabel COMP_CR_PERIOD_TO_LABEL;

	private HtmlInputText COMP_CR_PERIOD_TO;

	private HtmlOutputLabel COMP_CR_MIN_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_CR_MIN_TYPE;

	private HtmlOutputLabel COMP_CR_MIN_VALUE_LABEL;

	private HtmlInputText COMP_CR_MIN_VALUE;

	private HtmlOutputLabel COMP_CR_MAX_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_CR_MAX_TYPE;

	private HtmlOutputLabel COMP_CR_MAX_VALUE_LABEL;

	private HtmlInputText COMP_CR_MAX_VALUE;

	private HtmlOutputLabel COMP_CR_PAY_TO_LABEL;

	private HtmlSelectOneMenu COMP_CR_PAY_TO;

	private HtmlOutputLabel COMP_CR_PAY_MODE_LABEL;

	private HtmlSelectOneMenu COMP_CR_PAY_MODE;

	private HtmlOutputLabel COMP_CR_PREM_PAYABLE_YN_LABEL;

	private HtmlSelectOneMenu COMP_CR_PREM_PAYABLE_YN;

	private HtmlOutputLabel COMP_CR_POLICY_VALID_YN_LABEL;

	private HtmlSelectOneMenu COMP_CR_POLICY_VALID_YN;

	private HtmlOutputLabel COMP_CR_LATE_FEE_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_CR_LATE_FEE_TYPE;

	private HtmlOutputLabel COMP_CR_LATE_FEE_YN_LABEL;

	private HtmlSelectOneMenu COMP_CR_LATE_FEE_YN;

	private HtmlOutputLabel COMP_CR_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_CR_EFF_TO_DT;

	private HtmlOutputLabel COMP_CR_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_CR_EFF_FM_DT;

	private HtmlOutputLabel COMP_CR_LIEN_YN_LABEL;

	private HtmlSelectOneMenu COMP_CR_LIEN_YN;

	private HtmlOutputLabel COMP_CR_WAITING_YN_LABEL;

	private HtmlSelectOneMenu COMP_CR_WAITING_YN;

	private HtmlOutputLabel COMP_CR_HIBAH_FEE_AMT_LABEL;

	private HtmlInputText COMP_CR_HIBAH_FEE_AMT;

	private HtmlOutputLabel COMP_CR_HIBAH_YN_LABEL;

	private HtmlSelectOneMenu COMP_CR_HIBAH_YN;
	
	private HtmlOutputLabel COMP_CR_FORMULA_LABEL;
	
	private HtmlInputText COMP_CR_FORMULA;
	
	private HtmlInputText COMP_CR_FORMULA_DESC;

	private HtmlCommandButton COMP_UI_M_LOV_PAY_COVER_CODE;

	private HtmlCommandButton COMP_UI_M_LOV_PAY_LOSS_CODE;

	private HtmlCommandButton COMP_UI_M_LOV_PAY_DISABLE_CODE;

	private HtmlCommandButton COMP_UI_M_COVER_DESC_EDITOR;

	private HtmlCommandButton COMP_UI_M_LOV_COVER_CODE;

	private HtmlCommandButton COMP_UI_M_LOV_LOSS_CODE;

	private HtmlCommandButton COMP_UI_M_LOSS_EDITOR;

	private HtmlCommandButton COMP_UI_M_DISABLE_EDITOR;

	private HtmlCommandButton COMP_UI_M_BUT_LATE_FEE_DTLS;

	private HtmlCommandButton COMP_UI_M_LOV_DISABLE_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_WAIT_PERIOD;

	private HtmlCommandButton COMP_UI_M_BUT_CR_LIEN_YN;

	private HtmlCommandButton COMP_UI_M_BUT_CR_HIBA_YN;

	private PM_IL_CLM_REPAY PM_IL_CLM_REPAY_BEAN;

	public PILM007_COMPOSITE_ACTION compositeAction;

	private PM_IL_CLM_REPAY_HELPER helper;

	private List<SelectItem> listCR_RESERVE_TYPE;

	private List<SelectItem> listCR_RESERVE_OPTIONS;

	private List<SelectItem> listCR_RESERVE_CR_BASIS;

	private List<SelectItem> listCR_APPLIED_ON;

	private List<SelectItem> listCR_UNIT_PRICE;

	private List<SelectItem> listCR_PREM_DED;

	private List<SelectItem> listCR_PERIOD_UNIT;

	private List<SelectItem> listCR_MIN_TYPE ;

	private List<SelectItem> listCR_MAX_TYPE ;

	private List<SelectItem> listCR_PAY_TO;

	private List<SelectItem> listCR_PAY_MODE;

	private List<SelectItem> listCR_PREM_PAYABLE_YN;

	private List<SelectItem> listCR_POLICY_VALID_YN;

	private List<SelectItem> listCR_LATE_FEE_TYPE;

	private List<SelectItem> listCR_LATE_FEE_YN;

	private List<SelectItem> listCR_LIEN_YN;

	private List<SelectItem> listCR_WAITING_YN;

	private List<SelectItem> listCR_HIBAH_YN;
	
	private List<SelectItem> listCLM_PER_DAY;
	
	private List<LovBean> listCLM_FORMULA_LIST;
	
	private HtmlOutputLabel COMP_CLM_MEDICINE_LABEL;

	private HtmlSelectOneMenu COMP_CLM_MEDICINE_DROP;
	
	private HtmlOutputLabel COMP_CLM_DAY_LABEL;

	private HtmlInputText COMP_CLM_DAY;

	public PM_IL_CLM_REPAY_ACTION() {

		PM_IL_CLM_REPAY_BEAN = new PM_IL_CLM_REPAY();
		helper = new PM_IL_CLM_REPAY_HELPER();
		
		// Preparing list item values
		prepareListItemValues();
	}

	public HtmlOutputLabel getCOMP_CR_COVER_CODE_LABEL() {
		return COMP_CR_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CR_COVER_CODE() {
		return COMP_CR_COVER_CODE;
	}

	public void setCOMP_CR_COVER_CODE_LABEL(
			HtmlOutputLabel COMP_CR_COVER_CODE_LABEL) {
		this.COMP_CR_COVER_CODE_LABEL = COMP_CR_COVER_CODE_LABEL;
	}

	public void setCOMP_CR_COVER_CODE(HtmlInputText COMP_CR_COVER_CODE) {
		this.COMP_CR_COVER_CODE = COMP_CR_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_COVER_DESC_LABEL() {
		return COMP_UI_M_COVER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_COVER_DESC() {
		return COMP_UI_M_COVER_DESC;
	}

	public void setCOMP_UI_M_COVER_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_COVER_DESC_LABEL) {
		this.COMP_UI_M_COVER_DESC_LABEL = COMP_UI_M_COVER_DESC_LABEL;
	}

	public void setCOMP_UI_M_COVER_DESC(HtmlInputText COMP_UI_M_COVER_DESC) {
		this.COMP_UI_M_COVER_DESC = COMP_UI_M_COVER_DESC;
	}

	public HtmlOutputLabel getCOMP_CR_LOSS_TYPE_LABEL() {
		return COMP_CR_LOSS_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_CR_LOSS_TYPE() {
		return COMP_CR_LOSS_TYPE;
	}

	public void setCOMP_CR_LOSS_TYPE_LABEL(
			HtmlOutputLabel COMP_CR_LOSS_TYPE_LABEL) {
		this.COMP_CR_LOSS_TYPE_LABEL = COMP_CR_LOSS_TYPE_LABEL;
	}

	public void setCOMP_CR_LOSS_TYPE(HtmlInputText COMP_CR_LOSS_TYPE) {
		this.COMP_CR_LOSS_TYPE = COMP_CR_LOSS_TYPE;
	}

	public HtmlOutputLabel getCOMP_UI_M_LOSS_DESC_LABEL() {
		return COMP_UI_M_LOSS_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LOSS_DESC() {
		return COMP_UI_M_LOSS_DESC;
	}

	public void setCOMP_UI_M_LOSS_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_LOSS_DESC_LABEL) {
		this.COMP_UI_M_LOSS_DESC_LABEL = COMP_UI_M_LOSS_DESC_LABEL;
	}

	public void setCOMP_UI_M_LOSS_DESC(HtmlInputText COMP_UI_M_LOSS_DESC) {
		this.COMP_UI_M_LOSS_DESC = COMP_UI_M_LOSS_DESC;
	}

	public HtmlOutputLabel getCOMP_CR_DISABLE_TYPE_LABEL() {
		return COMP_CR_DISABLE_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_CR_DISABLE_TYPE() {
		return COMP_CR_DISABLE_TYPE;
	}

	public void setCOMP_CR_DISABLE_TYPE_LABEL(
			HtmlOutputLabel COMP_CR_DISABLE_TYPE_LABEL) {
		this.COMP_CR_DISABLE_TYPE_LABEL = COMP_CR_DISABLE_TYPE_LABEL;
	}

	public void setCOMP_CR_DISABLE_TYPE(HtmlInputText COMP_CR_DISABLE_TYPE) {
		this.COMP_CR_DISABLE_TYPE = COMP_CR_DISABLE_TYPE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DISABLE_DESC_LABEL() {
		return COMP_UI_M_DISABLE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DISABLE_DESC() {
		return COMP_UI_M_DISABLE_DESC;
	}

	public void setCOMP_UI_M_DISABLE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DISABLE_DESC_LABEL) {
		this.COMP_UI_M_DISABLE_DESC_LABEL = COMP_UI_M_DISABLE_DESC_LABEL;
	}

	public void setCOMP_UI_M_DISABLE_DESC(HtmlInputText COMP_UI_M_DISABLE_DESC) {
		this.COMP_UI_M_DISABLE_DESC = COMP_UI_M_DISABLE_DESC;
	}

	public HtmlOutputLabel getCOMP_CR_RESERVE_TYPE_LABEL() {
		return COMP_CR_RESERVE_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CR_RESERVE_TYPE() {
		return COMP_CR_RESERVE_TYPE;
	}

	public void setCOMP_CR_RESERVE_TYPE_LABEL(
			HtmlOutputLabel COMP_CR_RESERVE_TYPE_LABEL) {
		this.COMP_CR_RESERVE_TYPE_LABEL = COMP_CR_RESERVE_TYPE_LABEL;
	}

	public void setCOMP_CR_RESERVE_TYPE(HtmlSelectOneMenu COMP_CR_RESERVE_TYPE) {
		this.COMP_CR_RESERVE_TYPE = COMP_CR_RESERVE_TYPE;
	}

	public HtmlOutputLabel getCOMP_CR_RESERVE_OPTIONS_LABEL() {
		return COMP_CR_RESERVE_OPTIONS_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CR_RESERVE_OPTIONS() {
		return COMP_CR_RESERVE_OPTIONS;
	}

	public void setCOMP_CR_RESERVE_OPTIONS_LABEL(
			HtmlOutputLabel COMP_CR_RESERVE_OPTIONS_LABEL) {
		this.COMP_CR_RESERVE_OPTIONS_LABEL = COMP_CR_RESERVE_OPTIONS_LABEL;
	}

	public void setCOMP_CR_RESERVE_OPTIONS(
			HtmlSelectOneMenu COMP_CR_RESERVE_OPTIONS) {
		this.COMP_CR_RESERVE_OPTIONS = COMP_CR_RESERVE_OPTIONS;
	}

	public HtmlOutputLabel getCOMP_CR_NO_OF_YEARS_LABEL() {
		return COMP_CR_NO_OF_YEARS_LABEL;
	}

	public HtmlInputText getCOMP_CR_NO_OF_YEARS() {
		return COMP_CR_NO_OF_YEARS;
	}

	public void setCOMP_CR_NO_OF_YEARS_LABEL(
			HtmlOutputLabel COMP_CR_NO_OF_YEARS_LABEL) {
		this.COMP_CR_NO_OF_YEARS_LABEL = COMP_CR_NO_OF_YEARS_LABEL;
	}

	public void setCOMP_CR_NO_OF_YEARS(HtmlInputText COMP_CR_NO_OF_YEARS) {
		this.COMP_CR_NO_OF_YEARS = COMP_CR_NO_OF_YEARS;
	}

	public HtmlOutputLabel getCOMP_CR_RESERVE_CR_BASIS_LABEL() {
		return COMP_CR_RESERVE_CR_BASIS_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CR_RESERVE_CR_BASIS() {
		return COMP_CR_RESERVE_CR_BASIS;
	}

	public void setCOMP_CR_RESERVE_CR_BASIS_LABEL(
			HtmlOutputLabel COMP_CR_RESERVE_CR_BASIS_LABEL) {
		this.COMP_CR_RESERVE_CR_BASIS_LABEL = COMP_CR_RESERVE_CR_BASIS_LABEL;
	}

	public void setCOMP_CR_RESERVE_CR_BASIS(
			HtmlSelectOneMenu COMP_CR_RESERVE_CR_BASIS) {
		this.COMP_CR_RESERVE_CR_BASIS = COMP_CR_RESERVE_CR_BASIS;
	}

	public HtmlOutputLabel getCOMP_CR_RATE_LABEL() {
		return COMP_CR_RATE_LABEL;
	}

	public HtmlInputText getCOMP_CR_RATE() {
		return COMP_CR_RATE;
	}

	public void setCOMP_CR_RATE_LABEL(HtmlOutputLabel COMP_CR_RATE_LABEL) {
		this.COMP_CR_RATE_LABEL = COMP_CR_RATE_LABEL;
	}

	public void setCOMP_CR_RATE(HtmlInputText COMP_CR_RATE) {
		this.COMP_CR_RATE = COMP_CR_RATE;
	}

	public HtmlOutputLabel getCOMP_CR_RATE_PER_LABEL() {
		return COMP_CR_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_CR_RATE_PER() {
		return COMP_CR_RATE_PER;
	}

	public void setCOMP_CR_RATE_PER_LABEL(HtmlOutputLabel COMP_CR_RATE_PER_LABEL) {
		this.COMP_CR_RATE_PER_LABEL = COMP_CR_RATE_PER_LABEL;
	}

	public void setCOMP_CR_RATE_PER(HtmlInputText COMP_CR_RATE_PER) {
		this.COMP_CR_RATE_PER = COMP_CR_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_CR_APPLIED_ON_LABEL() {
		return COMP_CR_APPLIED_ON_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CR_APPLIED_ON() {
		return COMP_CR_APPLIED_ON;
	}

	public void setCOMP_CR_APPLIED_ON_LABEL(
			HtmlOutputLabel COMP_CR_APPLIED_ON_LABEL) {
		this.COMP_CR_APPLIED_ON_LABEL = COMP_CR_APPLIED_ON_LABEL;
	}

	public void setCOMP_CR_APPLIED_ON(HtmlSelectOneMenu COMP_CR_APPLIED_ON) {
		this.COMP_CR_APPLIED_ON = COMP_CR_APPLIED_ON;
	}

	public HtmlOutputLabel getCOMP_CR_UNIT_PRICE_LABEL() {
		return COMP_CR_UNIT_PRICE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CR_UNIT_PRICE() {
		return COMP_CR_UNIT_PRICE;
	}

	public void setCOMP_CR_UNIT_PRICE_LABEL(
			HtmlOutputLabel COMP_CR_UNIT_PRICE_LABEL) {
		this.COMP_CR_UNIT_PRICE_LABEL = COMP_CR_UNIT_PRICE_LABEL;
	}

	public void setCOMP_CR_UNIT_PRICE(HtmlSelectOneMenu COMP_CR_UNIT_PRICE) {
		this.COMP_CR_UNIT_PRICE = COMP_CR_UNIT_PRICE;
	}

	public HtmlOutputLabel getCOMP_CR_PREM_DED_LABEL() {
		return COMP_CR_PREM_DED_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CR_PREM_DED() {
		return COMP_CR_PREM_DED;
	}

	public void setCOMP_CR_PREM_DED_LABEL(HtmlOutputLabel COMP_CR_PREM_DED_LABEL) {
		this.COMP_CR_PREM_DED_LABEL = COMP_CR_PREM_DED_LABEL;
	}

	public void setCOMP_CR_PREM_DED(HtmlSelectOneMenu COMP_CR_PREM_DED) {
		this.COMP_CR_PREM_DED = COMP_CR_PREM_DED;
	}

	public HtmlOutputLabel getCOMP_CR_PERIOD_UNIT_LABEL() {
		return COMP_CR_PERIOD_UNIT_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CR_PERIOD_UNIT() {
		return COMP_CR_PERIOD_UNIT;
	}

	public void setCOMP_CR_PERIOD_UNIT_LABEL(
			HtmlOutputLabel COMP_CR_PERIOD_UNIT_LABEL) {
		this.COMP_CR_PERIOD_UNIT_LABEL = COMP_CR_PERIOD_UNIT_LABEL;
	}

	public void setCOMP_CR_PERIOD_UNIT(HtmlSelectOneMenu COMP_CR_PERIOD_UNIT) {
		this.COMP_CR_PERIOD_UNIT = COMP_CR_PERIOD_UNIT;
	}

	public HtmlOutputLabel getCOMP_CR_PERIOD_FROM_LABEL() {
		return COMP_CR_PERIOD_FROM_LABEL;
	}

	public HtmlInputText getCOMP_CR_PERIOD_FROM() {
		return COMP_CR_PERIOD_FROM;
	}

	public void setCOMP_CR_PERIOD_FROM_LABEL(
			HtmlOutputLabel COMP_CR_PERIOD_FROM_LABEL) {
		this.COMP_CR_PERIOD_FROM_LABEL = COMP_CR_PERIOD_FROM_LABEL;
	}

	public void setCOMP_CR_PERIOD_FROM(HtmlInputText COMP_CR_PERIOD_FROM) {
		this.COMP_CR_PERIOD_FROM = COMP_CR_PERIOD_FROM;
	}

	public HtmlOutputLabel getCOMP_CR_PERIOD_TO_LABEL() {
		return COMP_CR_PERIOD_TO_LABEL;
	}

	public HtmlInputText getCOMP_CR_PERIOD_TO() {
		return COMP_CR_PERIOD_TO;
	}

	public void setCOMP_CR_PERIOD_TO_LABEL(
			HtmlOutputLabel COMP_CR_PERIOD_TO_LABEL) {
		this.COMP_CR_PERIOD_TO_LABEL = COMP_CR_PERIOD_TO_LABEL;
	}

	public void setCOMP_CR_PERIOD_TO(HtmlInputText COMP_CR_PERIOD_TO) {
		this.COMP_CR_PERIOD_TO = COMP_CR_PERIOD_TO;
	}

	public HtmlOutputLabel getCOMP_CR_MIN_TYPE_LABEL() {
		return COMP_CR_MIN_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CR_MIN_TYPE() {
		return COMP_CR_MIN_TYPE;
	}

	public void setCOMP_CR_MIN_TYPE_LABEL(HtmlOutputLabel COMP_CR_MIN_TYPE_LABEL) {
		this.COMP_CR_MIN_TYPE_LABEL = COMP_CR_MIN_TYPE_LABEL;
	}

	public void setCOMP_CR_MIN_TYPE(HtmlSelectOneMenu COMP_CR_MIN_TYPE) {
		this.COMP_CR_MIN_TYPE = COMP_CR_MIN_TYPE;
	}

	public HtmlOutputLabel getCOMP_CR_MIN_VALUE_LABEL() {
		return COMP_CR_MIN_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_CR_MIN_VALUE() {
		return COMP_CR_MIN_VALUE;
	}

	public void setCOMP_CR_MIN_VALUE_LABEL(
			HtmlOutputLabel COMP_CR_MIN_VALUE_LABEL) {
		this.COMP_CR_MIN_VALUE_LABEL = COMP_CR_MIN_VALUE_LABEL;
	}

	public void setCOMP_CR_MIN_VALUE(HtmlInputText COMP_CR_MIN_VALUE) {
		this.COMP_CR_MIN_VALUE = COMP_CR_MIN_VALUE;
	}

	public HtmlOutputLabel getCOMP_CR_MAX_TYPE_LABEL() {
		return COMP_CR_MAX_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CR_MAX_TYPE() {
		return COMP_CR_MAX_TYPE;
	}

	public void setCOMP_CR_MAX_TYPE_LABEL(HtmlOutputLabel COMP_CR_MAX_TYPE_LABEL) {
		this.COMP_CR_MAX_TYPE_LABEL = COMP_CR_MAX_TYPE_LABEL;
	}

	public void setCOMP_CR_MAX_TYPE(HtmlSelectOneMenu COMP_CR_MAX_TYPE) {
		this.COMP_CR_MAX_TYPE = COMP_CR_MAX_TYPE;
	}

	public HtmlOutputLabel getCOMP_CR_MAX_VALUE_LABEL() {
		return COMP_CR_MAX_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_CR_MAX_VALUE() {
		return COMP_CR_MAX_VALUE;
	}

	public void setCOMP_CR_MAX_VALUE_LABEL(
			HtmlOutputLabel COMP_CR_MAX_VALUE_LABEL) {
		this.COMP_CR_MAX_VALUE_LABEL = COMP_CR_MAX_VALUE_LABEL;
	}

	public void setCOMP_CR_MAX_VALUE(HtmlInputText COMP_CR_MAX_VALUE) {
		this.COMP_CR_MAX_VALUE = COMP_CR_MAX_VALUE;
	}

	public HtmlOutputLabel getCOMP_CR_PAY_TO_LABEL() {
		return COMP_CR_PAY_TO_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CR_PAY_TO() {
		return COMP_CR_PAY_TO;
	}

	public void setCOMP_CR_PAY_TO_LABEL(HtmlOutputLabel COMP_CR_PAY_TO_LABEL) {
		this.COMP_CR_PAY_TO_LABEL = COMP_CR_PAY_TO_LABEL;
	}

	public void setCOMP_CR_PAY_TO(HtmlSelectOneMenu COMP_CR_PAY_TO) {
		this.COMP_CR_PAY_TO = COMP_CR_PAY_TO;
	}

	public HtmlOutputLabel getCOMP_CR_PAY_MODE_LABEL() {
		return COMP_CR_PAY_MODE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CR_PAY_MODE() {
		return COMP_CR_PAY_MODE;
	}

	public void setCOMP_CR_PAY_MODE_LABEL(HtmlOutputLabel COMP_CR_PAY_MODE_LABEL) {
		this.COMP_CR_PAY_MODE_LABEL = COMP_CR_PAY_MODE_LABEL;
	}

	public void setCOMP_CR_PAY_MODE(HtmlSelectOneMenu COMP_CR_PAY_MODE) {
		this.COMP_CR_PAY_MODE = COMP_CR_PAY_MODE;
	}

	public HtmlOutputLabel getCOMP_CR_PREM_PAYABLE_YN_LABEL() {
		return COMP_CR_PREM_PAYABLE_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CR_PREM_PAYABLE_YN() {
		return COMP_CR_PREM_PAYABLE_YN;
	}

	public void setCOMP_CR_PREM_PAYABLE_YN_LABEL(
			HtmlOutputLabel COMP_CR_PREM_PAYABLE_YN_LABEL) {
		this.COMP_CR_PREM_PAYABLE_YN_LABEL = COMP_CR_PREM_PAYABLE_YN_LABEL;
	}

	public void setCOMP_CR_PREM_PAYABLE_YN(
			HtmlSelectOneMenu COMP_CR_PREM_PAYABLE_YN) {
		this.COMP_CR_PREM_PAYABLE_YN = COMP_CR_PREM_PAYABLE_YN;
	}

	public HtmlOutputLabel getCOMP_CR_POLICY_VALID_YN_LABEL() {
		return COMP_CR_POLICY_VALID_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CR_POLICY_VALID_YN() {
		return COMP_CR_POLICY_VALID_YN;
	}

	public void setCOMP_CR_POLICY_VALID_YN_LABEL(
			HtmlOutputLabel COMP_CR_POLICY_VALID_YN_LABEL) {
		this.COMP_CR_POLICY_VALID_YN_LABEL = COMP_CR_POLICY_VALID_YN_LABEL;
	}

	public void setCOMP_CR_POLICY_VALID_YN(
			HtmlSelectOneMenu COMP_CR_POLICY_VALID_YN) {
		this.COMP_CR_POLICY_VALID_YN = COMP_CR_POLICY_VALID_YN;
	}

	public HtmlOutputLabel getCOMP_CR_LATE_FEE_TYPE_LABEL() {
		return COMP_CR_LATE_FEE_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CR_LATE_FEE_TYPE() {
		return COMP_CR_LATE_FEE_TYPE;
	}

	public void setCOMP_CR_LATE_FEE_TYPE_LABEL(
			HtmlOutputLabel COMP_CR_LATE_FEE_TYPE_LABEL) {
		this.COMP_CR_LATE_FEE_TYPE_LABEL = COMP_CR_LATE_FEE_TYPE_LABEL;
	}

	public void setCOMP_CR_LATE_FEE_TYPE(HtmlSelectOneMenu COMP_CR_LATE_FEE_TYPE) {
		this.COMP_CR_LATE_FEE_TYPE = COMP_CR_LATE_FEE_TYPE;
	}

	public HtmlOutputLabel getCOMP_CR_LATE_FEE_YN_LABEL() {
		return COMP_CR_LATE_FEE_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CR_LATE_FEE_YN() {
		return COMP_CR_LATE_FEE_YN;
	}

	public void setCOMP_CR_LATE_FEE_YN_LABEL(
			HtmlOutputLabel COMP_CR_LATE_FEE_YN_LABEL) {
		this.COMP_CR_LATE_FEE_YN_LABEL = COMP_CR_LATE_FEE_YN_LABEL;
	}

	public void setCOMP_CR_LATE_FEE_YN(HtmlSelectOneMenu COMP_CR_LATE_FEE_YN) {
		this.COMP_CR_LATE_FEE_YN = COMP_CR_LATE_FEE_YN;
	}

	public HtmlOutputLabel getCOMP_CR_EFF_TO_DT_LABEL() {
		return COMP_CR_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_CR_EFF_TO_DT() {
		return COMP_CR_EFF_TO_DT;
	}

	public void setCOMP_CR_EFF_TO_DT_LABEL(
			HtmlOutputLabel COMP_CR_EFF_TO_DT_LABEL) {
		this.COMP_CR_EFF_TO_DT_LABEL = COMP_CR_EFF_TO_DT_LABEL;
	}

	public void setCOMP_CR_EFF_TO_DT(HtmlCalendar COMP_CR_EFF_TO_DT) {
		this.COMP_CR_EFF_TO_DT = COMP_CR_EFF_TO_DT;
	}

	public HtmlOutputLabel getCOMP_CR_EFF_FM_DT_LABEL() {
		return COMP_CR_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_CR_EFF_FM_DT() {
		return COMP_CR_EFF_FM_DT;
	}

	public void setCOMP_CR_EFF_FM_DT_LABEL(
			HtmlOutputLabel COMP_CR_EFF_FM_DT_LABEL) {
		this.COMP_CR_EFF_FM_DT_LABEL = COMP_CR_EFF_FM_DT_LABEL;
	}

	public void setCOMP_CR_EFF_FM_DT(HtmlCalendar COMP_CR_EFF_FM_DT) {
		this.COMP_CR_EFF_FM_DT = COMP_CR_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_CR_LIEN_YN_LABEL() {
		return COMP_CR_LIEN_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CR_LIEN_YN() {
		return COMP_CR_LIEN_YN;
	}

	public void setCOMP_CR_LIEN_YN_LABEL(HtmlOutputLabel COMP_CR_LIEN_YN_LABEL) {
		this.COMP_CR_LIEN_YN_LABEL = COMP_CR_LIEN_YN_LABEL;
	}

	public void setCOMP_CR_LIEN_YN(HtmlSelectOneMenu COMP_CR_LIEN_YN) {
		this.COMP_CR_LIEN_YN = COMP_CR_LIEN_YN;
	}

	public HtmlOutputLabel getCOMP_CR_WAITING_YN_LABEL() {
		return COMP_CR_WAITING_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CR_WAITING_YN() {
		return COMP_CR_WAITING_YN;
	}

	public void setCOMP_CR_WAITING_YN_LABEL(
			HtmlOutputLabel COMP_CR_WAITING_YN_LABEL) {
		this.COMP_CR_WAITING_YN_LABEL = COMP_CR_WAITING_YN_LABEL;
	}

	public void setCOMP_CR_WAITING_YN(HtmlSelectOneMenu COMP_CR_WAITING_YN) {
		this.COMP_CR_WAITING_YN = COMP_CR_WAITING_YN;
	}

	public HtmlOutputLabel getCOMP_CR_HIBAH_FEE_AMT_LABEL() {
		return COMP_CR_HIBAH_FEE_AMT_LABEL;
	}

	public HtmlInputText getCOMP_CR_HIBAH_FEE_AMT() {
		return COMP_CR_HIBAH_FEE_AMT;
	}

	public void setCOMP_CR_HIBAH_FEE_AMT_LABEL(
			HtmlOutputLabel COMP_CR_HIBAH_FEE_AMT_LABEL) {
		this.COMP_CR_HIBAH_FEE_AMT_LABEL = COMP_CR_HIBAH_FEE_AMT_LABEL;
	}

	public void setCOMP_CR_HIBAH_FEE_AMT(HtmlInputText COMP_CR_HIBAH_FEE_AMT) {
		this.COMP_CR_HIBAH_FEE_AMT = COMP_CR_HIBAH_FEE_AMT;
	}

	public HtmlOutputLabel getCOMP_CR_HIBAH_YN_LABEL() {
		return COMP_CR_HIBAH_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CR_HIBAH_YN() {
		return COMP_CR_HIBAH_YN;
	}

	public void setCOMP_CR_HIBAH_YN_LABEL(HtmlOutputLabel COMP_CR_HIBAH_YN_LABEL) {
		this.COMP_CR_HIBAH_YN_LABEL = COMP_CR_HIBAH_YN_LABEL;
	}

	public void setCOMP_CR_HIBAH_YN(HtmlSelectOneMenu COMP_CR_HIBAH_YN) {
		this.COMP_CR_HIBAH_YN = COMP_CR_HIBAH_YN;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_PAY_COVER_CODE() {
		return COMP_UI_M_LOV_PAY_COVER_CODE;
	}

	public void setCOMP_UI_M_LOV_PAY_COVER_CODE(
			HtmlCommandButton COMP_UI_M_LOV_PAY_COVER_CODE) {
		this.COMP_UI_M_LOV_PAY_COVER_CODE = COMP_UI_M_LOV_PAY_COVER_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_PAY_LOSS_CODE() {
		return COMP_UI_M_LOV_PAY_LOSS_CODE;
	}

	public void setCOMP_UI_M_LOV_PAY_LOSS_CODE(
			HtmlCommandButton COMP_UI_M_LOV_PAY_LOSS_CODE) {
		this.COMP_UI_M_LOV_PAY_LOSS_CODE = COMP_UI_M_LOV_PAY_LOSS_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_PAY_DISABLE_CODE() {
		return COMP_UI_M_LOV_PAY_DISABLE_CODE;
	}

	public void setCOMP_UI_M_LOV_PAY_DISABLE_CODE(
			HtmlCommandButton COMP_UI_M_LOV_PAY_DISABLE_CODE) {
		this.COMP_UI_M_LOV_PAY_DISABLE_CODE = COMP_UI_M_LOV_PAY_DISABLE_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_COVER_DESC_EDITOR() {
		return COMP_UI_M_COVER_DESC_EDITOR;
	}

	public void setCOMP_UI_M_COVER_DESC_EDITOR(
			HtmlCommandButton COMP_UI_M_COVER_DESC_EDITOR) {
		this.COMP_UI_M_COVER_DESC_EDITOR = COMP_UI_M_COVER_DESC_EDITOR;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_COVER_CODE() {
		return COMP_UI_M_LOV_COVER_CODE;
	}

	public void setCOMP_UI_M_LOV_COVER_CODE(
			HtmlCommandButton COMP_UI_M_LOV_COVER_CODE) {
		this.COMP_UI_M_LOV_COVER_CODE = COMP_UI_M_LOV_COVER_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_LOSS_CODE() {
		return COMP_UI_M_LOV_LOSS_CODE;
	}

	public void setCOMP_UI_M_LOV_LOSS_CODE(
			HtmlCommandButton COMP_UI_M_LOV_LOSS_CODE) {
		this.COMP_UI_M_LOV_LOSS_CODE = COMP_UI_M_LOV_LOSS_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_LOSS_EDITOR() {
		return COMP_UI_M_LOSS_EDITOR;
	}

	public void setCOMP_UI_M_LOSS_EDITOR(HtmlCommandButton COMP_UI_M_LOSS_EDITOR) {
		this.COMP_UI_M_LOSS_EDITOR = COMP_UI_M_LOSS_EDITOR;
	}

	public HtmlCommandButton getCOMP_UI_M_DISABLE_EDITOR() {
		return COMP_UI_M_DISABLE_EDITOR;
	}

	public void setCOMP_UI_M_DISABLE_EDITOR(
			HtmlCommandButton COMP_UI_M_DISABLE_EDITOR) {
		this.COMP_UI_M_DISABLE_EDITOR = COMP_UI_M_DISABLE_EDITOR;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LATE_FEE_DTLS() {
		return COMP_UI_M_BUT_LATE_FEE_DTLS;
	}

	public void setCOMP_UI_M_BUT_LATE_FEE_DTLS(
			HtmlCommandButton COMP_UI_M_BUT_LATE_FEE_DTLS) {
		this.COMP_UI_M_BUT_LATE_FEE_DTLS = COMP_UI_M_BUT_LATE_FEE_DTLS;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_DISABLE_CODE() {
		return COMP_UI_M_LOV_DISABLE_CODE;
	}

	public void setCOMP_UI_M_LOV_DISABLE_CODE(
			HtmlCommandButton COMP_UI_M_LOV_DISABLE_CODE) {
		this.COMP_UI_M_LOV_DISABLE_CODE = COMP_UI_M_LOV_DISABLE_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_WAIT_PERIOD() {
		return COMP_UI_M_BUT_WAIT_PERIOD;
	}

	public void setCOMP_UI_M_BUT_WAIT_PERIOD(
			HtmlCommandButton COMP_UI_M_BUT_WAIT_PERIOD) {
		this.COMP_UI_M_BUT_WAIT_PERIOD = COMP_UI_M_BUT_WAIT_PERIOD;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CR_LIEN_YN() {
		return COMP_UI_M_BUT_CR_LIEN_YN;
	}

	public void setCOMP_UI_M_BUT_CR_LIEN_YN(
			HtmlCommandButton COMP_UI_M_BUT_CR_LIEN_YN) {
		this.COMP_UI_M_BUT_CR_LIEN_YN = COMP_UI_M_BUT_CR_LIEN_YN;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CR_HIBA_YN() {
		return COMP_UI_M_BUT_CR_HIBA_YN;
	}

	public void setCOMP_UI_M_BUT_CR_HIBA_YN(
			HtmlCommandButton COMP_UI_M_BUT_CR_HIBA_YN) {
		this.COMP_UI_M_BUT_CR_HIBA_YN = COMP_UI_M_BUT_CR_HIBA_YN;
	}

	public PM_IL_CLM_REPAY getPM_IL_CLM_REPAY_BEAN() {
		return PM_IL_CLM_REPAY_BEAN;
	}

	public void setPM_IL_CLM_REPAY_BEAN(PM_IL_CLM_REPAY PM_IL_CLM_REPAY_BEAN) {
		this.PM_IL_CLM_REPAY_BEAN = PM_IL_CLM_REPAY_BEAN;
	}

	public void saveRecord() {
		try {
			String message ="";
			if (getPM_IL_CLM_REPAY_BEAN().getROWID() != null) {
				new CRUDHandler().executeInsert(getPM_IL_CLM_REPAY_BEAN(),
						CommonUtils.getConnection());
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update");
			} else {
				new CRUDHandler().executeInsert(getPM_IL_CLM_REPAY_BEAN(),
						CommonUtils.getConnection());
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$save");
			}
			CommonUtils.getConnection().commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public List<SelectItem> getListCR_RESERVE_TYPE() {
		return listCR_RESERVE_TYPE;
	}

	public void setListCR_RESERVE_TYPE(List<SelectItem> listCR_RESERVE_TYPE) {
		this.listCR_RESERVE_TYPE = listCR_RESERVE_TYPE;
	}

	public List<SelectItem> getListCR_RESERVE_OPTIONS() {
		return listCR_RESERVE_OPTIONS;
	}

	public void setListCR_RESERVE_OPTIONS(
			List<SelectItem> listCR_RESERVE_OPTIONS) {
		this.listCR_RESERVE_OPTIONS = listCR_RESERVE_OPTIONS;
	}

	public List<SelectItem> getListCR_RESERVE_CR_BASIS() {
		return listCR_RESERVE_CR_BASIS;
	}

	public void setListCR_RESERVE_CR_BASIS(
			List<SelectItem> listCR_RESERVE_CR_BASIS) {
		this.listCR_RESERVE_CR_BASIS = listCR_RESERVE_CR_BASIS;
	}

	public List<SelectItem> getListCR_APPLIED_ON() {
		return listCR_APPLIED_ON;
	}

	public void setListCR_APPLIED_ON(List<SelectItem> listCR_APPLIED_ON) {
		this.listCR_APPLIED_ON = listCR_APPLIED_ON;
	}

	public List<SelectItem> getListCR_UNIT_PRICE() {
		return listCR_UNIT_PRICE;
	}

	public void setListCR_UNIT_PRICE(List<SelectItem> listCR_UNIT_PRICE) {
		this.listCR_UNIT_PRICE = listCR_UNIT_PRICE;
	}

	public List<SelectItem> getListCR_PREM_DED() {
		return listCR_PREM_DED;
	}

	public void setListCR_PREM_DED(List<SelectItem> listCR_PREM_DED) {
		this.listCR_PREM_DED = listCR_PREM_DED;
	}

	public List<SelectItem> getListCR_PERIOD_UNIT() {
		return listCR_PERIOD_UNIT;
	}

	public void setListCR_PERIOD_UNIT(List<SelectItem> listCR_PERIOD_UNIT) {
		this.listCR_PERIOD_UNIT = listCR_PERIOD_UNIT;
	}

	public List<SelectItem> getListCR_MIN_TYPE() {
		return listCR_MIN_TYPE;
	}

	public void setListCR_MIN_TYPE(List<SelectItem> listCR_MIN_TYPE) {
		this.listCR_MIN_TYPE = listCR_MIN_TYPE;
	}

	public List<SelectItem> getListCR_MAX_TYPE() {
		return listCR_MAX_TYPE;
	}

	public void setListCR_MAX_TYPE(List<SelectItem> listCR_MAX_TYPE) {
		this.listCR_MAX_TYPE = listCR_MAX_TYPE;
	}

	public List<SelectItem> getListCR_PAY_TO() {
		return listCR_PAY_TO;
	}

	public void setListCR_PAY_TO(List<SelectItem> listCR_PAY_TO) {
		this.listCR_PAY_TO = listCR_PAY_TO;
	}

	public List<SelectItem> getListCR_PAY_MODE() {
		return listCR_PAY_MODE;
	}

	public void setListCR_PAY_MODE(List<SelectItem> listCR_PAY_MODE) {
		this.listCR_PAY_MODE = listCR_PAY_MODE;
	}

	public List<SelectItem> getListCR_PREM_PAYABLE_YN() {
		return listCR_PREM_PAYABLE_YN;
	}

	public void setListCR_PREM_PAYABLE_YN(
			List<SelectItem> listCR_PREM_PAYABLE_YN) {
		this.listCR_PREM_PAYABLE_YN = listCR_PREM_PAYABLE_YN;
	}

	public List<SelectItem> getListCR_POLICY_VALID_YN() {
		return listCR_POLICY_VALID_YN;
	}

	public void setListCR_POLICY_VALID_YN(
			List<SelectItem> listCR_POLICY_VALID_YN) {
		this.listCR_POLICY_VALID_YN = listCR_POLICY_VALID_YN;
	}

	public List<SelectItem> getListCR_LATE_FEE_TYPE() {
		return listCR_LATE_FEE_TYPE;
	}

	public void setListCR_LATE_FEE_TYPE(List<SelectItem> listCR_LATE_FEE_TYPE) {
		this.listCR_LATE_FEE_TYPE = listCR_LATE_FEE_TYPE;
	}

	public List<SelectItem> getListCR_LATE_FEE_YN() {
		return listCR_LATE_FEE_YN;
	}

	public void setListCR_LATE_FEE_YN(List<SelectItem> listCR_LATE_FEE_YN) {
		this.listCR_LATE_FEE_YN = listCR_LATE_FEE_YN;
	}

	public List<SelectItem> getListCR_LIEN_YN() {
		return listCR_LIEN_YN;
	}

	public void setListCR_LIEN_YN(List<SelectItem> listCR_LIEN_YN) {
		this.listCR_LIEN_YN = listCR_LIEN_YN;
	}

	public List<SelectItem> getListCR_WAITING_YN() {
		return listCR_WAITING_YN;
	}

	public void setListCR_WAITING_YN(List<SelectItem> listCR_WAITING_YN) {
		this.listCR_WAITING_YN = listCR_WAITING_YN;
	}

	public List<SelectItem> getListCR_HIBAH_YN() {
		return listCR_HIBAH_YN;
	}

	public void setListCR_HIBAH_YN(List<SelectItem> listCR_HIBAH_YN) {
		this.listCR_HIBAH_YN = listCR_HIBAH_YN;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void CR_COVER_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.CR_COVER_CODE_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_IL_CLM_REPAY_BEAN().setCR_COVER_CODE((String) value);
			COMP_UI_M_COVER_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void CR_LOSS_TYPE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.CR_LOSS_TYPE_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_IL_CLM_REPAY_BEAN().setCR_LOSS_TYPE((String) value);
			COMP_UI_M_LOSS_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void CR_DISABLE_TYPE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.CR_DISABLE_TYPE_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_IL_CLM_REPAY_BEAN().setCR_DISABLE_TYPE((String) value);
			COMP_UI_M_DISABLE_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void CR_APPLIED_ON_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.CR_APPLIED_ON_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_IL_CLM_REPAY_BEAN().setCR_APPLIED_ON((String) value);
			CR_APPLIED_ON_Validator(null);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	
	public void CR_PREM_PAYABLE_YN_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			String currValue = (String) value;
			helper.CR_PREM_PAYABLE_YN_WHEN_VALIDATE_ITEM(PM_IL_CLM_REPAY_BEAN, currValue,this);
			getPM_IL_CLM_REPAY_BEAN().setCR_PREM_PAYABLE_YN((String) value);
			COMP_CR_POLICY_VALID_YN.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	

	public void CR_POLICY_VALID_YN_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
		      PM_IL_CLM_REPAY_BEAN.setCR_POLICY_VALID_YN((String) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	
	
	public void CR_APPLIED_ON_Validator(ActionEvent actionEvent) throws ValidatorException {
		try {
			String appliedOn = (String)COMP_CR_APPLIED_ON.getSubmittedValue();
			
			if("F".equalsIgnoreCase(appliedOn)){
				COMP_CR_FORMULA.setDisabled(false);
				
				//COMP_CR_FORMULA.setRendered(true);
			}else{
				COMP_CR_FORMULA.setDisabled(true);
				this.getPM_IL_CLM_REPAY_BEAN().setCR_FM_CODE(null);
				this.getPM_IL_CLM_REPAY_BEAN().setCR_FORMULA_DESC(null);
			//	COMP_CR_FORMULA.setRendered(false);
			}
			COMP_CR_FORMULA.resetValue();
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}

	public void CR_MAX_VALUE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.CR_MAX_VALUE_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_IL_CLM_REPAY_BEAN().setCR_MAX_VALUE((Double) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void CR_PAY_MODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_CLM_REPAY_BEAN().setCR_PAY_MODE((String)value);
			
			/*Added by Janani on 19.07.2017 for ZBILQC-1732278*/
			
			System.out.println("getCR_PAY_MODE                  "+getPM_IL_CLM_REPAY_BEAN().getCR_PAY_MODE());
			
			getPM_IL_CLM_REPAY_BEAN().setCR_PERIOD_UNIT(getPM_IL_CLM_REPAY_BEAN().getCR_PAY_MODE());
			
			System.out.println("getCR_PERIOD_UNIT                  "+getPM_IL_CLM_REPAY_BEAN().getCR_PERIOD_UNIT());
			/*End*/
			
			if("S".equalsIgnoreCase(getPM_IL_CLM_REPAY_BEAN().getCR_PAY_MODE())){
				getPM_IL_CLM_REPAY_BEAN().setCR_PERIOD_FROM(1);
				COMP_CR_PERIOD_FROM.setDisabled(true);
			}else{
				//getPM_IL_CLM_REPAY_BEAN().setCR_PERIOD_FROM(null);
				COMP_CR_PERIOD_FROM.setDisabled(false);
			}
			COMP_CR_PERIOD_FROM.resetValue();
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	
	public void CR_MIN_VALUE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.CR_MIN_VALUE_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_IL_CLM_REPAY_BEAN().setCR_MIN_VALUE((Double) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void CR_EFF_TO_DT_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.CR_EFF_TO_DT_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_IL_CLM_REPAY_BEAN().setCR_EFF_TO_DT((Date) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void CR_EFF_FM_DT_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.CR_EFF_FM_DT_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_IL_CLM_REPAY_BEAN().setCR_EFF_FM_DT((Date) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void CR_LIEN_YN_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.CR_LIEN_YN_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_IL_CLM_REPAY_BEAN().setCR_LIEN_YN((String) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void CR_WAITING_YN_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.CR_WAITING_YN_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_IL_CLM_REPAY_BEAN().setCR_WAITING_YN((String) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	public void COMP_CR_PERIOD_FROM_Validator(FacesContext context,
			UIComponent component, Object value) {
		try {
			Integer fromValue = (Integer)value;
			/*if(getPM_IL_CLM_REPAY_BEAN().getCR_PERIOD_TO() != null){
				if(getPM_IL_CLM_REPAY_BEAN().getCR_PERIOD_TO() < fromValue){
					throw new Exception("Minimum period cannot be greater than Maximum Period ");
				}
			}*/
			getPM_IL_CLM_REPAY_BEAN().setCR_PERIOD_FROM(fromValue);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void COMP_CR_PERIOD_TO_Validator(FacesContext context,
			UIComponent component, Object value)  {
		try {
			Integer toValue = (Integer)value;
			if(getPM_IL_CLM_REPAY_BEAN().getCR_PERIOD_FROM() != null){
				if(getPM_IL_CLM_REPAY_BEAN().getCR_PERIOD_FROM() > toValue){
					throw new Exception("Maximum period cannot be lesser than Minimum Period ");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void CR_HIBAH_FEE_AMT_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.CR_HIBAH_FEE_AMT_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPM_IL_CLM_REPAY_BEAN().setCR_HIBAH_FEE_AMT((Double) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void CR_CLM_MEDICINE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PM_IL_CLM_REPAY_BEAN.setCR_ALLOWANCE((String)value);
			if(PM_IL_CLM_REPAY_BEAN.getCR_ALLOWANCE()!=null && "D".equalsIgnoreCase(PM_IL_CLM_REPAY_BEAN.getCR_ALLOWANCE())){
				COMP_CLM_DAY.setDisabled(true);
			}else{
				COMP_CLM_DAY.setDisabled(false);
			}
			COMP_CLM_DAY.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	
	public void CR_HIBAH_YN_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.CR_HIBAH_YN_WHEN_LIST_CHANGED(compositeAction, value);
			getPM_IL_CLM_REPAY_BEAN().setCR_HIBAH_YN((String) value);
			COMP_CR_HIBAH_FEE_AMT.resetValue();
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void CR_MIN_TYPE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.CR_MIN_TYPE_WHEN_LIST_CHANGED(compositeAction, value);
			COMP_CR_MIN_VALUE.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void CR_MAX_TYPE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.CR_MAX_TYPE_WHEN_LIST_CHANGED(compositeAction, value);
			COMP_CR_MAX_VALUE.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	

	
	
	
	
	public void CR_LATE_FEE_YN_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.CR_LATE_FEE_YN_WHEN_LIST_CHANGED(compositeAction, value);
			COMP_CR_LATE_FEE_TYPE.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isFormFlag()) {
				helper.PILM007_PRE_FORM();
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				CommonUtils.clearMaps(this);
				if (compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN().getROWID() == null){
					helper.WHEN_CREATE_RECORD(compositeAction);
				}
				helper.executeQuery(compositeAction);
				helper.POST_QUERY(compositeAction);
				helper.WHEN_NEW_RECORD_INSTANCE(compositeAction);
				setBlockFlag(false);
			}
			if((null != PM_IL_CLM_REPAY_BEAN.getCR_APPLIED_ON()) &&
					"F".equalsIgnoreCase(PM_IL_CLM_REPAY_BEAN.getCR_APPLIED_ON())){
				COMP_CR_FORMULA.setDisabled(false);
			}
			else{
				COMP_CR_FORMULA.setDisabled(true);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public List<LovBean> lovCOVER_CODE(Object obj) throws Exception {
		String coverCode = (String) obj;
		List<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		if ("*".equals(coverCode)) {
			object = new Object[] {PELConstants.suggetionRecordSize};
			query = PILM007_QUERYCONSTANTS.COVER_CODE_LOV;
		} else {
			object = new Object[] {
			// CommonUtils.getGlobalVariable("GLOBAL.M_DFLT_VALUES"),
					coverCode + "%",coverCode + "%" ,PELConstants.suggetionRecordSize};
			query = PILM007_QUERYCONSTANTS.COVER_CODE_LOV_LIKE;
		}
		suggestionList = new PM_IL_CLM_REPAY_HELPER().callLov(query, object);
		return suggestionList;
	}
	
	public List<LovBean> lovLOSS_TYPE(Object obj) throws Exception {
		String lossType = (String) obj;
		List<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		if ("*".equals(lossType)) {
			object = new Object[] {};
			query = PILM007_QUERYCONSTANTS.LOSS_TYPE_LOV;
		} else {
			object = new Object[] {
			// CommonUtils.getGlobalVariable("GLOBAL.M_DFLT_VALUES"),
					lossType + "%",lossType + "%" };
			query = PILM007_QUERYCONSTANTS.LOSS_TYPE_LOV_LIKE;
		}
		suggestionList = new PM_IL_CLM_REPAY_HELPER().callLov(query, object);
		return suggestionList;
	}

	public List<LovBean> lovDISABLE_TYPE(Object obj) throws Exception {
		String disableType = (String) obj;
		List<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		if ("*".equals(disableType)) {
			object = new Object[] {PELConstants.suggetionRecordSize};
			query = PILM007_QUERYCONSTANTS.DISABLE_TYPE_LOV;
		} else {
			object = new Object[] {
			// CommonUtils.getGlobalVariable("GLOBAL.M_DFLT_VALUES"),
					disableType + "%",disableType + "%" ,PELConstants.suggetionRecordSize};
			query = PILM007_QUERYCONSTANTS.DISABLE_TYPE_LOV_LIKE;
		}
		suggestionList = new PM_IL_CLM_REPAY_HELPER().callLov(query, object);
		return suggestionList;
	}
	private void prepareListItemValues(){
		Connection connection = null;
		
		try {
			connection = CommonUtils.getConnection();
			listCR_PERIOD_UNIT = ListItemUtil.getDropDownListValue_1(connection, 
					"PILM007", "PM_IL_CLM_REPAY", "PM_IL_CLM_REPAY.CR_PERIOD_UNIT", null);
			listCR_APPLIED_ON = ListItemUtil.getDropDownListValue_1(connection, 
					"PILM007", "PM_IL_CLM_REPAY", "PM_IL_CLM_REPAY.CR_APPLIED_ON", null);
			listCR_HIBAH_YN =	ListItemUtil.getDropDownListValue_1(connection, 
					"PILM007", "PM_IL_CLM_REPAY", "PM_IL_CLM_REPAY.CR_HIBAH_YN", null);
			
			listCR_LATE_FEE_TYPE =	ListItemUtil.getDropDownListValue_1(connection, 
					"PILM007", "PM_IL_CLM_REPAY", "PM_IL_CLM_REPAY.CR_LATE_FEE_TYPE", null);
		
			listCR_LATE_FEE_YN =	ListItemUtil.getDropDownListValue_1(connection, 
					"PILM007", "PM_IL_CLM_REPAY", "PM_IL_CLM_REPAY.CR_LATE_FEE_YN", null);
			
			listCR_LIEN_YN =	ListItemUtil.getDropDownListValue_1(connection, 
					"PILM007", "PM_IL_CLM_REPAY", "PM_IL_CLM_REPAY.CR_LIEN_YN", null);

			listCR_MAX_TYPE =	ListItemUtil.getDropDownListValue_1(connection, 
					"PILM007", "PM_IL_CLM_REPAY", "PM_IL_CLM_REPAY.CR_MAX_TYPE", null);
			
			listCR_MIN_TYPE =	ListItemUtil.getDropDownListValue_1(connection, 
					"PILM007", "PM_IL_CLM_REPAY", "PM_IL_CLM_REPAY.CR_MIN_TYPE", null);
			
			listCR_PAY_MODE =	ListItemUtil.getDropDownListValue_1(connection, 
					"PILM007", "PM_IL_CLM_REPAY", "PM_IL_CLM_REPAY.CR_PAY_MODE", null);

			listCR_PAY_TO =	ListItemUtil.getDropDownListValue_1(connection, 
					"PILM007", "PM_IL_CLM_REPAY", "PM_IL_CLM_REPAY.CR_PAY_TO", null);
			
			listCR_PERIOD_UNIT =	ListItemUtil.getDropDownListValue_1(connection, 
					"PILM007", "PM_IL_CLM_REPAY", "PM_IL_CLM_REPAY.CR_PERIOD_UNIT", null);
			
			listCR_POLICY_VALID_YN =	ListItemUtil.getDropDownListValue_1(connection, 
					"PILM007", "PM_IL_CLM_REPAY", "PM_IL_CLM_REPAY.CR_POLICY_VALID_YN", null);
			
			listCR_PREM_DED =	ListItemUtil.getDropDownListValue_1(connection, 
					"PILM007", "PM_IL_CLM_REPAY", "PM_IL_CLM_REPAY.CR_PREM_DED", null);

			listCR_PREM_PAYABLE_YN =	ListItemUtil.getDropDownListValue_1(connection, 
					"PILM007", "PM_IL_CLM_REPAY", "PM_IL_CLM_REPAY.CR_PREM_PAYABLE_YN", null);
			
			listCR_RESERVE_CR_BASIS =	ListItemUtil.getDropDownListValue_1(connection, 
					"PILM007", "PM_IL_CLM_REPAY", "PM_IL_CLM_REPAY.CR_RESERVE_CR_BASIS", null);

			listCR_RESERVE_OPTIONS =	ListItemUtil.getDropDownListValue_1(connection, 
					"PILM007", "PM_IL_CLM_REPAY", "PM_IL_CLM_REPAY.CR_RESERVE_OPTIONS", null);
			
			listCR_RESERVE_TYPE =	ListItemUtil.getDropDownListValue_1(connection, 
					"PILM007", "PM_IL_CLM_REPAY", "PM_IL_CLM_REPAY.CR_RESERVE_TYPE", null);
			
			listCR_UNIT_PRICE =	ListItemUtil.getDropDownListValue_1(connection, 
					"PILM007", "PM_IL_CLM_REPAY", "PM_IL_CLM_REPAY.CR_UNIT_PRICE", null);

			listCR_WAITING_YN =	ListItemUtil.getDropDownListValue_1(connection, 
					"PILM007", "PM_IL_CLM_REPAY", "PM_IL_CLM_REPAY.CR_WAITING_YN", null);
			List<SelectItem> list = new ArrayList<SelectItem>();
			list.add(new SelectItem("D","Per Days"));
			list.add(new SelectItem("T","Treatment"));
			
			listCLM_PER_DAY =	list;
			
			/*Added by sankara narayanan for Hospital cash plan on 26/04/2017*/
			listCR_PRE_CLM_YN=ListItemUtil.getDropDownListValue_1(connection, 
					"PILM007", "PM_IL_CLM_REPAY", "PM_IL_CLM_REPAY.CR_PRE_CLM_YN", null);
			/*end*/

		} catch (DBException e) {
			
			e.printStackTrace();
		}
		
	}
	

	/**
	 * Instantiates all components in PM_IL_CLM_REPAY_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_CR_COVER_CODE				 = new HtmlInputText();
		COMP_UI_M_COVER_DESC				 = new HtmlInputText();
		COMP_CR_LOSS_TYPE				 = new HtmlInputText();
		COMP_UI_M_LOSS_DESC				 = new HtmlInputText();
		COMP_CR_DISABLE_TYPE				 = new HtmlInputText();
		COMP_UI_M_DISABLE_DESC				 = new HtmlInputText();
		COMP_CR_NO_OF_YEARS				 = new HtmlInputText();
		COMP_CR_RATE					 = new HtmlInputText();
		COMP_CR_RATE_PER				 = new HtmlInputText();
		COMP_CR_PERIOD_FROM				 = new HtmlInputText();
		COMP_CR_PERIOD_TO				 = new HtmlInputText();
		COMP_CR_MIN_VALUE				 = new HtmlInputText();
		COMP_CR_MAX_VALUE				 = new HtmlInputText();
		COMP_CR_HIBAH_FEE_AMT				 = new HtmlInputText();

		// Instantiating HtmlSelectOneMenu
		COMP_CR_RESERVE_TYPE				 = new HtmlSelectOneMenu();
		COMP_CR_RESERVE_OPTIONS				 = new HtmlSelectOneMenu();
		COMP_CR_RESERVE_CR_BASIS			 = new HtmlSelectOneMenu();
		COMP_CR_APPLIED_ON				 = new HtmlSelectOneMenu();
		COMP_CR_UNIT_PRICE				 = new HtmlSelectOneMenu();
		COMP_CR_PREM_DED				 = new HtmlSelectOneMenu();
		COMP_CR_PERIOD_UNIT				 = new HtmlSelectOneMenu();
		COMP_CR_MIN_TYPE				 = new HtmlSelectOneMenu();
		COMP_CR_MAX_TYPE				 = new HtmlSelectOneMenu();
		COMP_CR_PAY_TO					 = new HtmlSelectOneMenu();
		COMP_CR_PAY_MODE				 = new HtmlSelectOneMenu();
		COMP_CR_PREM_PAYABLE_YN				 = new HtmlSelectOneMenu();
		COMP_CR_POLICY_VALID_YN				 = new HtmlSelectOneMenu();
		COMP_CR_LATE_FEE_TYPE				 = new HtmlSelectOneMenu();
		COMP_CR_LATE_FEE_YN				 = new HtmlSelectOneMenu();
		COMP_CR_LIEN_YN					 = new HtmlSelectOneMenu();
		COMP_CR_WAITING_YN				 = new HtmlSelectOneMenu();
		COMP_CR_HIBAH_YN				 = new HtmlSelectOneMenu();

		// Instantiating HtmlCalendar
		COMP_CR_EFF_TO_DT				 = new HtmlCalendar();
		COMP_CR_EFF_FM_DT				 = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_LOV_PAY_COVER_CODE			 = new HtmlCommandButton();
		COMP_UI_M_LOV_PAY_LOSS_CODE			 = new HtmlCommandButton();
		COMP_UI_M_LOV_PAY_DISABLE_CODE			 = new HtmlCommandButton();
		COMP_UI_M_COVER_DESC_EDITOR			 = new HtmlCommandButton();
		COMP_UI_M_LOV_COVER_CODE			 = new HtmlCommandButton();
		COMP_UI_M_LOV_LOSS_CODE				 = new HtmlCommandButton();
		COMP_UI_M_LOSS_EDITOR				 = new HtmlCommandButton();
		COMP_UI_M_DISABLE_EDITOR			 = new HtmlCommandButton();
		COMP_UI_M_BUT_LATE_FEE_DTLS			 = new HtmlCommandButton();
		COMP_UI_M_LOV_DISABLE_CODE			 = new HtmlCommandButton();
		COMP_UI_M_BUT_WAIT_PERIOD			 = new HtmlCommandButton();
		COMP_UI_M_BUT_CR_LIEN_YN			 = new HtmlCommandButton();
		COMP_UI_M_BUT_CR_HIBA_YN			 = new HtmlCommandButton();

	}

	/**
	 * Resets all components in PM_IL_CLM_REPAY_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_CR_COVER_CODE.resetValue();
		COMP_UI_M_COVER_DESC.resetValue();
		COMP_CR_LOSS_TYPE.resetValue();
		COMP_UI_M_LOSS_DESC.resetValue();
		COMP_CR_DISABLE_TYPE.resetValue();
		COMP_UI_M_DISABLE_DESC.resetValue();
		COMP_CR_NO_OF_YEARS.resetValue();
		COMP_CR_RATE.resetValue();
		COMP_CR_RATE_PER.resetValue();
		COMP_CR_PERIOD_FROM.resetValue();
		COMP_CR_PERIOD_TO.resetValue();
		COMP_CR_MIN_VALUE.resetValue();
		COMP_CR_MAX_VALUE.resetValue();
		COMP_CR_HIBAH_FEE_AMT.resetValue();

		// Reseting HtmlSelectOneMenu
		COMP_CR_RESERVE_TYPE.resetValue();
		COMP_CR_RESERVE_OPTIONS.resetValue();
		COMP_CR_RESERVE_CR_BASIS.resetValue();
		COMP_CR_APPLIED_ON.resetValue();
		COMP_CR_UNIT_PRICE.resetValue();
		COMP_CR_PREM_DED.resetValue();
		COMP_CR_PERIOD_UNIT.resetValue();
		COMP_CR_MIN_TYPE.resetValue();
		COMP_CR_MAX_TYPE.resetValue();
		COMP_CR_PAY_TO.resetValue();
		COMP_CR_PAY_MODE.resetValue();
		COMP_CR_PREM_PAYABLE_YN.resetValue();
		COMP_CR_POLICY_VALID_YN.resetValue();
		COMP_CR_LATE_FEE_TYPE.resetValue();
		COMP_CR_LATE_FEE_YN.resetValue();
		COMP_CR_LIEN_YN.resetValue();
		COMP_CR_WAITING_YN.resetValue();
		COMP_CR_HIBAH_YN.resetValue();

		// Reseting HtmlCalendar
		COMP_CR_EFF_TO_DT.resetValue();
		COMP_CR_EFF_FM_DT.resetValue();


	}




	
	
	public String actionM_BUT_LATE_FEE_DTLS(){
		setFormFlag(true);
		setBlockFlag(true);
		return "PILM007_PM_IL_CLM_LATE_FEE";
	}
	public String actionM_BUT_WAIT_PERIOD(){
		setFormFlag(true);
		setBlockFlag(true);
		return "PILM007_PM_IL_CLM_WAIT_PERIOD";
	}
	public String actionM_BUT_CR_LIEN_YN(){
		setFormFlag(true);
		setBlockFlag(true);
		CommonUtils.setGlobalVariable("GLOBAL.M_CL_BASIS","L");
		
//		compositeAction.getPM_IL_CLM_LIEN_ACTION_BEAN().getCOMP_CL_APPLIED_ON().setRendered(true);
//		SET_BLOCK_PROPERTY('PM_IL_CLM_LIEN',DEFAULT_WHERE,'CL_BASIS=''L''');
//		SET_WINDOW_PROPERTY('PM_IL_CLM_LIEN',TITLE,'Lien Details');
//		GO_ITEM('PM_IL_CLM_LIEN.CL_FM_AGE');
		return "PILM007_PM_IL_CLM_LIEN";
	}
	public String actionM_BUT_CR_HIBA_YN(){
		setFormFlag(true);
		setBlockFlag(true);
		CommonUtils.setGlobalVariable("GLOBAL.M_CL_BASIS","H");
//		compositeAction.getPM_IL_CLM_LIEN_ACTION_BEAN().getCOMP_CL_APPLIED_ON().setRendered(false);
//		SET_BLOCK_PROPERTY('PM_IL_CLM_LIEN',DEFAULT_WHERE,'CL_BASIS=''H''');
//		SET_WINDOW_PROPERTY('PM_IL_CLM_LIEN',TITLE,'Hibah Details');
//		GO_ITEM('PM_IL_CLM_LIEN.CL_FM_AGE');
		return "PILM007_PM_IL_CLM_LATE_FEE";
	}

	/**
	 * @return the cOMP_CLM_MEDICINE_LABEL
	 */
	public HtmlOutputLabel getCOMP_CLM_MEDICINE_LABEL() {
		return COMP_CLM_MEDICINE_LABEL;
	}

	/**
	 * @param comp_clm_medicine_label the cOMP_CLM_MEDICINE_LABEL to set
	 */
	public void setCOMP_CLM_MEDICINE_LABEL(HtmlOutputLabel comp_clm_medicine_label) {
		COMP_CLM_MEDICINE_LABEL = comp_clm_medicine_label;
	}

	/**
	 * @return the cOMP_CLM_MEDICINE_DROP
	 */
	public HtmlSelectOneMenu getCOMP_CLM_MEDICINE_DROP() {
		return COMP_CLM_MEDICINE_DROP;
	}

	/**
	 * @param comp_clm_medicine_drop the cOMP_CLM_MEDICINE_DROP to set
	 */
	public void setCOMP_CLM_MEDICINE_DROP(HtmlSelectOneMenu comp_clm_medicine_drop) {
		COMP_CLM_MEDICINE_DROP = comp_clm_medicine_drop;
	}

	/**
	 * @return the cOMP_CLM_DAY_LABEL
	 */
	public HtmlOutputLabel getCOMP_CLM_DAY_LABEL() {
		return COMP_CLM_DAY_LABEL;
	}

	/**
	 * @param comp_clm_day_label the cOMP_CLM_DAY_LABEL to set
	 */
	public void setCOMP_CLM_DAY_LABEL(HtmlOutputLabel comp_clm_day_label) {
		COMP_CLM_DAY_LABEL = comp_clm_day_label;
	}

	/**
	 * @return the cOMP_CLM_DAY
	 */
	public HtmlInputText getCOMP_CLM_DAY() {
		return COMP_CLM_DAY;
	}

	/**
	 * @param comp_clm_day the cOMP_CLM_DAY to set
	 */
	public void setCOMP_CLM_DAY(HtmlInputText comp_clm_day) {
		COMP_CLM_DAY = comp_clm_day;
	}

	/**
	 * @return the listCLM_PER_DAY
	 */
	public List<SelectItem> getListCLM_PER_DAY() {
		return listCLM_PER_DAY;
	}

	/**
	 * @param listCLM_PER_DAY the listCLM_PER_DAY to set
	 */
	public void setListCLM_PER_DAY(List<SelectItem> listCLM_PER_DAY) {
		this.listCLM_PER_DAY = listCLM_PER_DAY;
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validateAllowPerDay(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PM_IL_CLM_REPAY_BEAN.setCR_ALLOWANCE_PER_DAY((Integer)value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}
	
	
	public void validateCR_FORMULA(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PM_IL_CLM_REPAY_BEAN.setCR_FM_CODE((String)value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}
	

	/**
	 * @return the cOMP_CR_FORMULA_LABEL
	 */
	public HtmlOutputLabel getCOMP_CR_FORMULA_LABEL() {
		return COMP_CR_FORMULA_LABEL;
	}

	/**
	 * @param comp_cr_formula_label the cOMP_CR_FORMULA_LABEL to set
	 */
	public void setCOMP_CR_FORMULA_LABEL(HtmlOutputLabel comp_cr_formula_label) {
		COMP_CR_FORMULA_LABEL = comp_cr_formula_label;
	}

	/**
	 * @return the cOMP_CR_FORMULA
	 */
	public HtmlInputText getCOMP_CR_FORMULA() {
		return COMP_CR_FORMULA;
	}

	/**
	 * @param comp_cr_formula the cOMP_CR_FORMULA to set
	 */
	public void setCOMP_CR_FORMULA(HtmlInputText comp_cr_formula) {
		COMP_CR_FORMULA = comp_cr_formula;
	}

	/**
	 * @return the cOMP_CR_FORMULA_DESC
	 */
	public HtmlInputText getCOMP_CR_FORMULA_DESC() {
		return COMP_CR_FORMULA_DESC;
	}

	/**
	 * @param comp_cr_formula_desc the cOMP_CR_FORMULA_DESC to set
	 */
	public void setCOMP_CR_FORMULA_DESC(HtmlInputText comp_cr_formula_desc) {
		COMP_CR_FORMULA_DESC = comp_cr_formula_desc;
	}

	
	
	/**
	 * @return the listCLM_FORMULA_LIST
	 */
	public List<LovBean> getListCLM_FORMULA_LIST() {
		return listCLM_FORMULA_LIST;
	}

	/**
	 * @param listCLM_FORMULA_LIST the listCLM_FORMULA_LIST to set
	 */
	public void setListCLM_FORMULA_LIST(List<LovBean> listCLM_FORMULA_LIST) {
		this.listCLM_FORMULA_LIST = listCLM_FORMULA_LIST;
	}
	
	/**
	 * 
	 * @param formula
	 * @return
	 * @throws Exception
	 */
	public List<LovBean> lovFORMULA_LIST(Object obj) throws Exception {
		String formula = PM_IL_CLM_REPAY_BEAN.getCR_APPLIED_ON();
		
		System.out.println("formula===========>"+formula);
		Object[] object = {};
		String query = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet C1_REC = null;
		LovBean lovBean = null;
		List<LovBean> list =new ArrayList<LovBean>();
		
		try{
		if ("F".equalsIgnoreCase(formula)) {
			object = new Object[] {PELConstants.suggetionRecordSize};
			query = PILM007_QUERYCONSTANTS.FORMULA_LOV;
			connection = CommonUtils.getConnection();
			C1_REC = handler.executeSelectStatement(query, connection,object);
			while(C1_REC.next()){
				lovBean = new LovBean();
				lovBean.setCode(C1_REC.getString(1));
				lovBean.setName(C1_REC.getString(2));
				list.add(lovBean);
			}
		} 
			setListCLM_FORMULA_LIST(list);
			
		}catch(Exception exception){
			exception.printStackTrace();
			getErrorMap().put("current", exception.getMessage());
		}finally{
			CommonUtils.closeCursor(C1_REC);
		}

		return listCLM_FORMULA_LIST;
	}
	
	
	public String  deleteRecords(){
		CRUDHandler handler=new CRUDHandler();
		Connection connection = null;
		
		
		try {
		if(isDELETE_ALLOWED()){
	
			connection = CommonUtils.getConnection();
		 handler.executeDelete(PM_IL_CLM_REPAY_BEAN, connection);
			connection.commit();
			
			compositeAction= new PILM007_COMPOSITE_ACTION();
			
			CommonUtils.setGlobalObject("PILM007_COMPOSITE_ACTION", compositeAction);

			// Assigning message to new action class
			compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN().getWarningMap().put(
					"deleteRow",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$delete"));
			compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN().getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$delete"));
		}	else {

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
	return null;
}


/*Added by saranya for RM018T - FSD_IL_ZB Life_001-Education Endowment Plan COMMENTS on 13-04-2017*/
	public void CR_RESERVE_TYPE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			String CR_RESERVE_TYPE=((String) value);
			if("A".equalsIgnoreCase(CR_RESERVE_TYPE)){
			getCOVER_CODE_VALUE();
			if(CommonUtils.nvl(getCOVER_CODE(),"XXX").equalsIgnoreCase(PM_IL_CLM_REPAY_BEAN.getCR_COVER_CODE())){
				getPM_IL_CLM_REPAY_BEAN().setCR_RESERVE_TYPE((String) value);
				}else{
					throw new Exception("Annual only applicable for WOP Covers ");
				}

			}else{
				getPM_IL_CLM_REPAY_BEAN().setCR_RESERVE_TYPE((String) value);
			}
			
			/* Newly Added By Dhinehs on 14-8-2017 for ssp call id : ZBILQC-1730139 */
			helper.CR_RESERVE_TYPE_WHEN_VALIDATE_ITEM(compositeAction, CR_RESERVE_TYPE);
			/* End */
			
			/*if(flag==false){
				
					throw new Exception("Annual only applicable for WOP Covers ");
				}

			}else{
				getPM_IL_CLM_REPAY_BEAN().setCR_COVER_CODE((String) value);
			}*/
			COMP_CR_COVER_CODE.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	public String COVER_CODE;
	
	public String COVER_CLASS;
	
	public String getCOVER_CLASS() {
		return COVER_CLASS;
	}

	public void setCOVER_CLASS(String cOVER_CLASS) {
		COVER_CLASS = cOVER_CLASS;
	}

	public String getCOVER_CODE() {
		return COVER_CODE;
	}

	public void setCOVER_CODE(String cOVER_CODE) {
		COVER_CODE = cOVER_CODE;
	}

	
	boolean flag=false;
	public void getCOVER_CODE_VALUE() throws Exception {
		
		String CURSOR_C1 = "SELECT DISTINCT(COVER_CODE),COVER_CLASS FROM PM_IL_COVER,PM_IL_CLM_REPAY WHERE COVER_CLASS='W' AND COVER_CODE=?";
		ResultSet resultSet = null;
		Connection connection = null;
		String COVER_CODE1=null;
		String COVER_CLASS1=null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			/*System.out.println("Annuity Amount   :"+PT_IL_POLICY_BEAN.getPOL_ANN_BNF_AMT());
			System.out.println("policy_term  :"+PT_IL_POLICY_BEAN.getPOL_PERIOD());*/
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] {PM_IL_CLM_REPAY_BEAN.getCR_COVER_CODE()});
			while (resultSet.next()) {
				COVER_CODE1= resultSet.getString("COVER_CODE");
				COVER_CLASS1=resultSet.getString("COVER_CLASS");
				/*
				if(COVER_CODE1!=null && COVER_CODE1.equalsIgnoreCase(PM_IL_CLM_REPAY_BEAN.getCR_COVER_CODE()))
				{
					//setCOVER_CLASS_NEW(COVER_CLASS1);
					flag=true;
				}*/
				setCOVER_CODE(COVER_CODE1);
				setCOVER_CLASS(COVER_CLASS1);
				System.out.println("COVER_CODE :"+getCOVER_CODE()+"COVER_CLASS   :"+getCOVER_CLASS());
			}
			} catch (DBException e) {
			throw new Exception(e.getMessage());
		}
		
		}
	
	/*End*/
		
	
	/*Added by sankara narayanan for Hospital cash plan on 26/04/2017*/
	private List<SelectItem> listCR_PRE_CLM_YN;
	private HtmlInputText COMP_CR_PRE_WAIT_MNTHS;
	private HtmlOutputLabel COMP_CR_PRE_WAIT_MNTHS_LABEL;
	private HtmlOutputLabel COMP_CR_PRE_CLM_YN_LABEL;
	private HtmlSelectOneMenu COMP_CR_PRE_CLM_YN;

	public List<SelectItem> getListCR_PRE_CLM_YN() {
		return listCR_PRE_CLM_YN;
	}

	public void setListCR_PRE_CLM_YN(List<SelectItem> listCR_PRE_CLM_YN) {
		this.listCR_PRE_CLM_YN = listCR_PRE_CLM_YN;
	}

	public HtmlInputText getCOMP_CR_PRE_WAIT_MNTHS() {
		return COMP_CR_PRE_WAIT_MNTHS;
	}

	public void setCOMP_CR_PRE_WAIT_MNTHS(HtmlInputText cOMP_CR_PRE_WAIT_MNTHS) {
		COMP_CR_PRE_WAIT_MNTHS = cOMP_CR_PRE_WAIT_MNTHS;
	}

	public HtmlOutputLabel getCOMP_CR_PRE_WAIT_MNTHS_LABEL() {
		return COMP_CR_PRE_WAIT_MNTHS_LABEL;
	}

	public void setCOMP_CR_PRE_WAIT_MNTHS_LABEL(
			HtmlOutputLabel cOMP_CR_PRE_WAIT_MNTHS_LABEL) {
		COMP_CR_PRE_WAIT_MNTHS_LABEL = cOMP_CR_PRE_WAIT_MNTHS_LABEL;
	}

	public HtmlOutputLabel getCOMP_CR_PRE_CLM_YN_LABEL() {
		return COMP_CR_PRE_CLM_YN_LABEL;
	}

	public void setCOMP_CR_PRE_CLM_YN_LABEL(HtmlOutputLabel cOMP_CR_PRE_CLM_YN_LABEL) {
		COMP_CR_PRE_CLM_YN_LABEL = cOMP_CR_PRE_CLM_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CR_PRE_CLM_YN() {
		return COMP_CR_PRE_CLM_YN;
	}

	public void setCOMP_CR_PRE_CLM_YN(HtmlSelectOneMenu cOMP_CR_PRE_CLM_YN) {
		COMP_CR_PRE_CLM_YN = cOMP_CR_PRE_CLM_YN;
	}
	
	
	public void CR_PRE_CLM_YN_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			String currValue = (String) value;

			getPM_IL_CLM_REPAY_BEAN().setCR_PRE_CLM_YN(currValue);
			if("Y".equalsIgnoreCase(currValue)){
				COMP_CR_PRE_WAIT_MNTHS.setDisabled(false);
				
			}else{
				COMP_CR_PRE_WAIT_MNTHS.setDisabled(true);
			}
			COMP_CR_PRE_CLM_YN.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void validate_CR_PRE_WAIT_MNTHS(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			int currValue = (int) value;

			getPM_IL_CLM_REPAY_BEAN().setCR_PRE_WAIT_MNTHS(currValue);
			COMP_CR_PRE_WAIT_MNTHS.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context,component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	
	
	
	/*end*/
		
	/*added by raja on 28-04-2017 for Hospital cash plan*/
	private HtmlOutputLabel COMP_CR_MAX_VISITS_LABEL;

	private HtmlInputText COMP_CR_MAX_VISITS;

	public HtmlOutputLabel getCOMP_CR_MAX_VISITS_LABEL() {
		return COMP_CR_MAX_VISITS_LABEL;
	}

	public void setCOMP_CR_MAX_VISITS_LABEL(HtmlOutputLabel cOMP_CR_MAX_VISITS_LABEL) {
		COMP_CR_MAX_VISITS_LABEL = cOMP_CR_MAX_VISITS_LABEL;
	}

	public HtmlInputText getCOMP_CR_MAX_VISITS() {
		return COMP_CR_MAX_VISITS;
	}

	public void setCOMP_CR_MAX_VISITS(HtmlInputText cOMP_CR_MAX_VISITS) {
		COMP_CR_MAX_VISITS = cOMP_CR_MAX_VISITS;
	}
	
	
	/*end*/
	/*added by raja on 05-05-2017 for Hospital cash plan*/
	
	private HtmlOutputLabel COMP_CR_WAIT_HRS_LABEL;
	
	private HtmlInputText COMP_CR_WAIT_HRS;

	public HtmlOutputLabel getCOMP_CR_WAIT_HRS_LABEL() {
		return COMP_CR_WAIT_HRS_LABEL;
	}

	public void setCOMP_CR_WAIT_HRS_LABEL(HtmlOutputLabel cOMP_CR_WAIT_HRS_LABEL) {
		COMP_CR_WAIT_HRS_LABEL = cOMP_CR_WAIT_HRS_LABEL;
	}

	public HtmlInputText getCOMP_CR_WAIT_HRS() {
		return COMP_CR_WAIT_HRS;
	}

	public void setCOMP_CR_WAIT_HRS(HtmlInputText cOMP_CR_WAIT_HRS) {
		COMP_CR_WAIT_HRS = cOMP_CR_WAIT_HRS;
	}
	
	/*end*/
	
}
