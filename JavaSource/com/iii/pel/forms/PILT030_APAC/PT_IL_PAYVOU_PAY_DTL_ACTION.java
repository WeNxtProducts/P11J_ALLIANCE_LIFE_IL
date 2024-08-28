package com.iii.pel.forms.PILT030_APAC;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_PAYVOU_PAY_DTL_ACTION extends CommonAction {

	private HtmlAjaxCommandButton UI_M_BUT_ADD;
	private HtmlAjaxCommandButton UI_M_BUT_DEL;
	private HtmlAjaxCommandButton UI_M_BUT_POST;

	private String filterByPAPD_CUST_CODE;
	private String filterPAPD_BANK_CODE;

	private HtmlOutputLabel COMP_PAPD_CUST_CODE_LABEL;

	private HtmlInputText COMP_PAPD_CUST_CODE;

	private HtmlOutputLabel COMP_UI_M_PAPD_CUST_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PAPD_CUST_DESC;

	private HtmlOutputLabel COMP_PAPD_PAY_MODE_LABEL;

	private HtmlSelectOneMenu COMP_PAPD_PAY_MODE;

	private HtmlOutputLabel COMP_PAPD_FC_PAY_AMT_LABEL;

	private HtmlInputText COMP_PAPD_FC_PAY_AMT;

	private HtmlOutputLabel COMP_PAPD_LC_PAY_AMT_LABEL;

	private HtmlInputText COMP_PAPD_LC_PAY_AMT;

	private HtmlOutputLabel COMP_PAPD_PAYEE_NAME_LABEL;

	private HtmlInputText COMP_PAPD_PAYEE_NAME;

	private HtmlOutputLabel COMP_PAPD_CURR_CODE_LABEL;

	private HtmlInputText COMP_PAPD_CURR_CODE;

	private HtmlOutputLabel COMP_PAPD_BANK_ACC_NO_LABEL;

	private HtmlInputText COMP_PAPD_BANK_ACC_NO;

	private HtmlOutputLabel COMP_PAPD_PAY_APPRV_CODE_LABEL;

	private HtmlInputText COMP_PAPD_PAY_APPRV_CODE;

	private HtmlOutputLabel COMP_PAPD_CHQ_DT_LABEL;

	private HtmlCalendar COMP_PAPD_CHQ_DT;

	private HtmlOutputLabel COMP_PAPD_ATTENTION_TO_LABEL;

	private HtmlInputText COMP_PAPD_ATTENTION_TO;

	private HtmlOutputLabel COMP_PAPD_MAIN_ACNT_CODE_LABEL;

	private HtmlInputText COMP_PAPD_MAIN_ACNT_CODE;

	private HtmlOutputLabel COMP_UI_M_MAIN_ACNT_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_MAIN_ACNT_CODE_DESC;

	private HtmlOutputLabel COMP_PAPD_PAYEE_ADDR1_LABEL;

	private HtmlInputText COMP_PAPD_PAYEE_ADDR1;

	private HtmlOutputLabel COMP_PAPD_SUB_ACNT_CODE_LABEL;

	private HtmlInputText COMP_PAPD_SUB_ACNT_CODE;

	private HtmlOutputLabel COMP_UI_M_SUB_ACNT_DESC_LABEL;

	private HtmlInputText COMP_UI_M_SUB_ACNT_DESC;

	private HtmlOutputLabel COMP_PAPD_PAYEE_ADDR2_LABEL;

	private HtmlInputText COMP_PAPD_PAYEE_ADDR2;

	private HtmlOutputLabel COMP_PAPD_ANLY_CODE_1_LABEL;

	private HtmlInputText COMP_PAPD_ANLY_CODE_1;

	private HtmlOutputLabel COMP_UI_M_ANLY_DESC1_LABEL;

	private HtmlInputText COMP_UI_M_ANLY_DESC1;

	private HtmlOutputLabel COMP_PAPD_PAYEE_ADDR3_LABEL;

	private HtmlInputText COMP_PAPD_PAYEE_ADDR3;

	private HtmlOutputLabel COMP_PAPD_ANLY_CODE_2_LABEL;

	private HtmlInputText COMP_PAPD_ANLY_CODE_2;

	private HtmlOutputLabel COMP_UI_M_ANLY_DESC2_LABEL;

	private HtmlInputText COMP_UI_M_ANLY_DESC2;

	private HtmlOutputLabel COMP_PAPD_OFF_AREA_CODE_LABEL;

	private HtmlInputText COMP_PAPD_OFF_AREA_CODE;

	private HtmlOutputLabel COMP_UI_M_POSTAL_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POSTAL_DESC;

	private HtmlOutputLabel COMP_PAPD_PAYEE_ANLY_CODE_1_LABEL;

	private HtmlInputText COMP_PAPD_PAYEE_ANLY_CODE_1;

	private HtmlOutputLabel COMP_UI_M_PAYEE_ANLY_DESC1_LABEL;

	private HtmlInputText COMP_UI_M_PAYEE_ANLY_DESC1;

	private HtmlOutputLabel COMP_PAPD_CITY_CODE_LABEL;

	private HtmlInputText COMP_PAPD_CITY_CODE;

	private HtmlOutputLabel COMP_UI_M_CITY_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CITY_DESC;

	private HtmlOutputLabel COMP_PAPD_PAYEE_ANLY_CODE_2_LABEL;

	private HtmlInputText COMP_PAPD_PAYEE_ANLY_CODE_2;

	private HtmlOutputLabel COMP_UI_M_PAYEE_ANLY_DESC2_LABEL;

	private HtmlInputText COMP_UI_M_PAYEE_ANLY_DESC2;

	private HtmlOutputLabel COMP_PAPD_STATE_CODE_LABEL;

	private HtmlInputText COMP_PAPD_STATE_CODE;

	private HtmlOutputLabel COMP_UI_M_STATE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_STATE_DESC;

	private HtmlOutputLabel COMP_PAPD_ACTY_CODE_1_LABEL;

	private HtmlInputText COMP_PAPD_ACTY_CODE_1;

	private HtmlOutputLabel COMP_UI_M_ACTY_DESC1_LABEL;

	private HtmlInputText COMP_UI_M_ACTY_DESC1;

	private HtmlOutputLabel COMP_PAPD_BANK_CODE_LABEL;

	private HtmlInputText COMP_PAPD_BANK_CODE;

	private HtmlOutputLabel COMP_UI_M_BANK_DESC_LABEL;

	private HtmlInputText COMP_UI_M_BANK_DESC;

	private HtmlOutputLabel COMP_PAPD_ACTY_CODE_2_LABEL;

	private HtmlInputText COMP_PAPD_ACTY_CODE_2;

	private HtmlOutputLabel COMP_UI_M_ACTY_DESC2_LABEL;

	private HtmlInputText COMP_UI_M_ACTY_DESC2;

	private HtmlOutputLabel COMP_UI_M_PAPD_CLE_ZONE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PAPD_CLE_ZONE_DESC;

	private HtmlOutputLabel COMP_PAPD_CLE_ZONE_CODE_LABEL;

	private HtmlInputText COMP_PAPD_CLE_ZONE_CODE;

	private HtmlOutputLabel COMP_PAPD_NARRATION_LABEL;

	private HtmlInputText COMP_PAPD_NARRATION;

	private HtmlOutputLabel COMP_PAPD_DES_MTD_CODE_LABEL;

	private HtmlInputText COMP_PAPD_DES_MTD_CODE;

	private HtmlOutputLabel COMP_UI_M_PAPD_DES_MTD_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PAPD_DES_MTD_DESC;

	private HtmlOutputLabel COMP_PAPD_CHQ_APPR_USER_ID_LABEL;

	private HtmlInputText COMP_PAPD_CHQ_APPR_USER_ID;

	private HtmlOutputLabel COMP_PAPD_CHQ_ISSUE_USER_ID_LABEL;

	private HtmlInputText COMP_PAPD_CHQ_ISSUE_USER_ID;

	private PT_IL_PAYVOU_PAY_DTL PT_IL_PAYVOU_PAY_DTL_BEAN;

	private UIData PT_IL_PAYVOU_PAY_DTL_DT;

	private List<PT_IL_PAYVOU_PAY_DTL> PT_IL_PAYVOU_PAY_DTL_LIST;

	private boolean onLoadFlag = false;

	private List<SelectItem> PAPD_PAY_MODE_LIST;

	public PT_IL_PAYVOU_PAY_DTL_ACTION() {
		PT_IL_PAYVOU_PAY_DTL_BEAN = new PT_IL_PAYVOU_PAY_DTL();
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		PAPD_PAY_MODE_LIST = ListItemUtil.getDropDownListValue(connection,
				"PILT030_APAC", "PT_IL_PAYVOU_PAY_DTL",
				"PT_IL_PAYVOU_PAY_DTL.PAPD_PAY_MODE", "IL_PAY_MODE");
	}

	public String getFilterByPAPD_CUST_CODE() {
		return filterByPAPD_CUST_CODE;
	}

	public void setFilterByPAPD_CUST_CODE(String filterByPAPD_CUST_CODE) {
		this.filterByPAPD_CUST_CODE = filterByPAPD_CUST_CODE;
	}

	public String getFilterPAPD_BANK_CODE() {
		return filterPAPD_BANK_CODE;
	}

	public void setFilterPAPD_BANK_CODE(String filterPAPD_BANK_CODE) {
		this.filterPAPD_BANK_CODE = filterPAPD_BANK_CODE;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_DEL() {
		return UI_M_BUT_DEL;
	}

	public void setUI_M_BUT_DEL(HtmlAjaxCommandButton ui_m_but_del) {
		UI_M_BUT_DEL = ui_m_but_del;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	public List<SelectItem> getPAPD_PAY_MODE_LIST() {
		return PAPD_PAY_MODE_LIST;
	}

	public void setPAPD_PAY_MODE_LIST(List<SelectItem> papd_pay_mode_list) {
		PAPD_PAY_MODE_LIST = papd_pay_mode_list;
	}

	public boolean isOnLoadFlag() {
		return onLoadFlag;
	}

	public void setOnLoadFlag(boolean onLoadFlag) {
		this.onLoadFlag = onLoadFlag;
	}

	public UIData getPT_IL_PAYVOU_PAY_DTL_DT() {
		return PT_IL_PAYVOU_PAY_DTL_DT;
	}

	public void setPT_IL_PAYVOU_PAY_DTL_DT(UIData pt_il_payvou_pay_dtl_dt) {
		PT_IL_PAYVOU_PAY_DTL_DT = pt_il_payvou_pay_dtl_dt;
	}

	public List<PT_IL_PAYVOU_PAY_DTL> getPT_IL_PAYVOU_PAY_DTL_LIST() {
		return PT_IL_PAYVOU_PAY_DTL_LIST;
	}

	public void setPT_IL_PAYVOU_PAY_DTL_LIST(
			List<PT_IL_PAYVOU_PAY_DTL> pt_il_payvou_pay_dtl_list) {
		PT_IL_PAYVOU_PAY_DTL_LIST = pt_il_payvou_pay_dtl_list;
	}

	public HtmlOutputLabel getCOMP_PAPD_CUST_CODE_LABEL() {
		return COMP_PAPD_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_CUST_CODE() {
		return COMP_PAPD_CUST_CODE;
	}

	public void setCOMP_PAPD_CUST_CODE_LABEL(
			HtmlOutputLabel COMP_PAPD_CUST_CODE_LABEL) {
		this.COMP_PAPD_CUST_CODE_LABEL = COMP_PAPD_CUST_CODE_LABEL;
	}

	public void setCOMP_PAPD_CUST_CODE(HtmlInputText COMP_PAPD_CUST_CODE) {
		this.COMP_PAPD_CUST_CODE = COMP_PAPD_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PAPD_CUST_DESC_LABEL() {
		return COMP_UI_M_PAPD_CUST_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PAPD_CUST_DESC() {
		return COMP_UI_M_PAPD_CUST_DESC;
	}

	public void setCOMP_UI_M_PAPD_CUST_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PAPD_CUST_DESC_LABEL) {
		this.COMP_UI_M_PAPD_CUST_DESC_LABEL = COMP_UI_M_PAPD_CUST_DESC_LABEL;
	}

	public void setCOMP_UI_M_PAPD_CUST_DESC(
			HtmlInputText COMP_UI_M_PAPD_CUST_DESC) {
		this.COMP_UI_M_PAPD_CUST_DESC = COMP_UI_M_PAPD_CUST_DESC;
	}

	public HtmlOutputLabel getCOMP_PAPD_PAY_MODE_LABEL() {
		return COMP_PAPD_PAY_MODE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PAPD_PAY_MODE() {
		return COMP_PAPD_PAY_MODE;
	}

	public void setCOMP_PAPD_PAY_MODE_LABEL(
			HtmlOutputLabel COMP_PAPD_PAY_MODE_LABEL) {
		this.COMP_PAPD_PAY_MODE_LABEL = COMP_PAPD_PAY_MODE_LABEL;
	}

	public void setCOMP_PAPD_PAY_MODE(HtmlSelectOneMenu COMP_PAPD_PAY_MODE) {
		this.COMP_PAPD_PAY_MODE = COMP_PAPD_PAY_MODE;
	}

	public HtmlOutputLabel getCOMP_PAPD_FC_PAY_AMT_LABEL() {
		return COMP_PAPD_FC_PAY_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_FC_PAY_AMT() {
		return COMP_PAPD_FC_PAY_AMT;
	}

	public void setCOMP_PAPD_FC_PAY_AMT_LABEL(
			HtmlOutputLabel COMP_PAPD_FC_PAY_AMT_LABEL) {
		this.COMP_PAPD_FC_PAY_AMT_LABEL = COMP_PAPD_FC_PAY_AMT_LABEL;
	}

	public void setCOMP_PAPD_FC_PAY_AMT(HtmlInputText COMP_PAPD_FC_PAY_AMT) {
		this.COMP_PAPD_FC_PAY_AMT = COMP_PAPD_FC_PAY_AMT;
	}

	public HtmlOutputLabel getCOMP_PAPD_LC_PAY_AMT_LABEL() {
		return COMP_PAPD_LC_PAY_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_LC_PAY_AMT() {
		return COMP_PAPD_LC_PAY_AMT;
	}

	public void setCOMP_PAPD_LC_PAY_AMT_LABEL(
			HtmlOutputLabel COMP_PAPD_LC_PAY_AMT_LABEL) {
		this.COMP_PAPD_LC_PAY_AMT_LABEL = COMP_PAPD_LC_PAY_AMT_LABEL;
	}

	public void setCOMP_PAPD_LC_PAY_AMT(HtmlInputText COMP_PAPD_LC_PAY_AMT) {
		this.COMP_PAPD_LC_PAY_AMT = COMP_PAPD_LC_PAY_AMT;
	}

	public HtmlOutputLabel getCOMP_PAPD_PAYEE_NAME_LABEL() {
		return COMP_PAPD_PAYEE_NAME_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_PAYEE_NAME() {
		return COMP_PAPD_PAYEE_NAME;
	}

	public void setCOMP_PAPD_PAYEE_NAME_LABEL(
			HtmlOutputLabel COMP_PAPD_PAYEE_NAME_LABEL) {
		this.COMP_PAPD_PAYEE_NAME_LABEL = COMP_PAPD_PAYEE_NAME_LABEL;
	}

	public void setCOMP_PAPD_PAYEE_NAME(HtmlInputText COMP_PAPD_PAYEE_NAME) {
		this.COMP_PAPD_PAYEE_NAME = COMP_PAPD_PAYEE_NAME;
	}

	public HtmlOutputLabel getCOMP_PAPD_CURR_CODE_LABEL() {
		return COMP_PAPD_CURR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_CURR_CODE() {
		return COMP_PAPD_CURR_CODE;
	}

	public void setCOMP_PAPD_CURR_CODE_LABEL(
			HtmlOutputLabel COMP_PAPD_CURR_CODE_LABEL) {
		this.COMP_PAPD_CURR_CODE_LABEL = COMP_PAPD_CURR_CODE_LABEL;
	}

	public void setCOMP_PAPD_CURR_CODE(HtmlInputText COMP_PAPD_CURR_CODE) {
		this.COMP_PAPD_CURR_CODE = COMP_PAPD_CURR_CODE;
	}

	public HtmlOutputLabel getCOMP_PAPD_BANK_ACC_NO_LABEL() {
		return COMP_PAPD_BANK_ACC_NO_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_BANK_ACC_NO() {
		return COMP_PAPD_BANK_ACC_NO;
	}

	public void setCOMP_PAPD_BANK_ACC_NO_LABEL(
			HtmlOutputLabel COMP_PAPD_BANK_ACC_NO_LABEL) {
		this.COMP_PAPD_BANK_ACC_NO_LABEL = COMP_PAPD_BANK_ACC_NO_LABEL;
	}

	public void setCOMP_PAPD_BANK_ACC_NO(HtmlInputText COMP_PAPD_BANK_ACC_NO) {
		this.COMP_PAPD_BANK_ACC_NO = COMP_PAPD_BANK_ACC_NO;
	}

	public HtmlOutputLabel getCOMP_PAPD_PAY_APPRV_CODE_LABEL() {
		return COMP_PAPD_PAY_APPRV_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_PAY_APPRV_CODE() {
		return COMP_PAPD_PAY_APPRV_CODE;
	}

	public void setCOMP_PAPD_PAY_APPRV_CODE_LABEL(
			HtmlOutputLabel COMP_PAPD_PAY_APPRV_CODE_LABEL) {
		this.COMP_PAPD_PAY_APPRV_CODE_LABEL = COMP_PAPD_PAY_APPRV_CODE_LABEL;
	}

	public void setCOMP_PAPD_PAY_APPRV_CODE(
			HtmlInputText COMP_PAPD_PAY_APPRV_CODE) {
		this.COMP_PAPD_PAY_APPRV_CODE = COMP_PAPD_PAY_APPRV_CODE;
	}

	public HtmlOutputLabel getCOMP_PAPD_CHQ_DT_LABEL() {
		return COMP_PAPD_CHQ_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PAPD_CHQ_DT() {
		return COMP_PAPD_CHQ_DT;
	}

	public void setCOMP_PAPD_CHQ_DT_LABEL(HtmlOutputLabel COMP_PAPD_CHQ_DT_LABEL) {
		this.COMP_PAPD_CHQ_DT_LABEL = COMP_PAPD_CHQ_DT_LABEL;
	}

	public void setCOMP_PAPD_CHQ_DT(HtmlCalendar COMP_PAPD_CHQ_DT) {
		this.COMP_PAPD_CHQ_DT = COMP_PAPD_CHQ_DT;
	}

	public HtmlOutputLabel getCOMP_PAPD_ATTENTION_TO_LABEL() {
		return COMP_PAPD_ATTENTION_TO_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_ATTENTION_TO() {
		return COMP_PAPD_ATTENTION_TO;
	}

	public void setCOMP_PAPD_ATTENTION_TO_LABEL(
			HtmlOutputLabel COMP_PAPD_ATTENTION_TO_LABEL) {
		this.COMP_PAPD_ATTENTION_TO_LABEL = COMP_PAPD_ATTENTION_TO_LABEL;
	}

	public void setCOMP_PAPD_ATTENTION_TO(HtmlInputText COMP_PAPD_ATTENTION_TO) {
		this.COMP_PAPD_ATTENTION_TO = COMP_PAPD_ATTENTION_TO;
	}

	public HtmlOutputLabel getCOMP_PAPD_MAIN_ACNT_CODE_LABEL() {
		return COMP_PAPD_MAIN_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_MAIN_ACNT_CODE() {
		return COMP_PAPD_MAIN_ACNT_CODE;
	}

	public void setCOMP_PAPD_MAIN_ACNT_CODE_LABEL(
			HtmlOutputLabel COMP_PAPD_MAIN_ACNT_CODE_LABEL) {
		this.COMP_PAPD_MAIN_ACNT_CODE_LABEL = COMP_PAPD_MAIN_ACNT_CODE_LABEL;
	}

	public void setCOMP_PAPD_MAIN_ACNT_CODE(
			HtmlInputText COMP_PAPD_MAIN_ACNT_CODE) {
		this.COMP_PAPD_MAIN_ACNT_CODE = COMP_PAPD_MAIN_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_MAIN_ACNT_CODE_DESC_LABEL() {
		return COMP_UI_M_MAIN_ACNT_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_MAIN_ACNT_CODE_DESC() {
		return COMP_UI_M_MAIN_ACNT_CODE_DESC;
	}

	public void setCOMP_UI_M_MAIN_ACNT_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_MAIN_ACNT_CODE_DESC_LABEL) {
		this.COMP_UI_M_MAIN_ACNT_CODE_DESC_LABEL = COMP_UI_M_MAIN_ACNT_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_MAIN_ACNT_CODE_DESC(
			HtmlInputText COMP_UI_M_MAIN_ACNT_CODE_DESC) {
		this.COMP_UI_M_MAIN_ACNT_CODE_DESC = COMP_UI_M_MAIN_ACNT_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_PAPD_PAYEE_ADDR1_LABEL() {
		return COMP_PAPD_PAYEE_ADDR1_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_PAYEE_ADDR1() {
		return COMP_PAPD_PAYEE_ADDR1;
	}

	public void setCOMP_PAPD_PAYEE_ADDR1_LABEL(
			HtmlOutputLabel COMP_PAPD_PAYEE_ADDR1_LABEL) {
		this.COMP_PAPD_PAYEE_ADDR1_LABEL = COMP_PAPD_PAYEE_ADDR1_LABEL;
	}

	public void setCOMP_PAPD_PAYEE_ADDR1(HtmlInputText COMP_PAPD_PAYEE_ADDR1) {
		this.COMP_PAPD_PAYEE_ADDR1 = COMP_PAPD_PAYEE_ADDR1;
	}

	public HtmlOutputLabel getCOMP_PAPD_SUB_ACNT_CODE_LABEL() {
		return COMP_PAPD_SUB_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_SUB_ACNT_CODE() {
		return COMP_PAPD_SUB_ACNT_CODE;
	}

	public void setCOMP_PAPD_SUB_ACNT_CODE_LABEL(
			HtmlOutputLabel COMP_PAPD_SUB_ACNT_CODE_LABEL) {
		this.COMP_PAPD_SUB_ACNT_CODE_LABEL = COMP_PAPD_SUB_ACNT_CODE_LABEL;
	}

	public void setCOMP_PAPD_SUB_ACNT_CODE(HtmlInputText COMP_PAPD_SUB_ACNT_CODE) {
		this.COMP_PAPD_SUB_ACNT_CODE = COMP_PAPD_SUB_ACNT_CODE;
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

	public HtmlOutputLabel getCOMP_PAPD_PAYEE_ADDR2_LABEL() {
		return COMP_PAPD_PAYEE_ADDR2_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_PAYEE_ADDR2() {
		return COMP_PAPD_PAYEE_ADDR2;
	}

	public void setCOMP_PAPD_PAYEE_ADDR2_LABEL(
			HtmlOutputLabel COMP_PAPD_PAYEE_ADDR2_LABEL) {
		this.COMP_PAPD_PAYEE_ADDR2_LABEL = COMP_PAPD_PAYEE_ADDR2_LABEL;
	}

	public void setCOMP_PAPD_PAYEE_ADDR2(HtmlInputText COMP_PAPD_PAYEE_ADDR2) {
		this.COMP_PAPD_PAYEE_ADDR2 = COMP_PAPD_PAYEE_ADDR2;
	}

	public HtmlOutputLabel getCOMP_PAPD_ANLY_CODE_1_LABEL() {
		return COMP_PAPD_ANLY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_ANLY_CODE_1() {
		return COMP_PAPD_ANLY_CODE_1;
	}

	public void setCOMP_PAPD_ANLY_CODE_1_LABEL(
			HtmlOutputLabel COMP_PAPD_ANLY_CODE_1_LABEL) {
		this.COMP_PAPD_ANLY_CODE_1_LABEL = COMP_PAPD_ANLY_CODE_1_LABEL;
	}

	public void setCOMP_PAPD_ANLY_CODE_1(HtmlInputText COMP_PAPD_ANLY_CODE_1) {
		this.COMP_PAPD_ANLY_CODE_1 = COMP_PAPD_ANLY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_ANLY_DESC1_LABEL() {
		return COMP_UI_M_ANLY_DESC1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ANLY_DESC1() {
		return COMP_UI_M_ANLY_DESC1;
	}

	public void setCOMP_UI_M_ANLY_DESC1_LABEL(
			HtmlOutputLabel COMP_UI_M_ANLY_DESC1_LABEL) {
		this.COMP_UI_M_ANLY_DESC1_LABEL = COMP_UI_M_ANLY_DESC1_LABEL;
	}

	public void setCOMP_UI_M_ANLY_DESC1(HtmlInputText COMP_UI_M_ANLY_DESC1) {
		this.COMP_UI_M_ANLY_DESC1 = COMP_UI_M_ANLY_DESC1;
	}

	public HtmlOutputLabel getCOMP_PAPD_PAYEE_ADDR3_LABEL() {
		return COMP_PAPD_PAYEE_ADDR3_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_PAYEE_ADDR3() {
		return COMP_PAPD_PAYEE_ADDR3;
	}

	public void setCOMP_PAPD_PAYEE_ADDR3_LABEL(
			HtmlOutputLabel COMP_PAPD_PAYEE_ADDR3_LABEL) {
		this.COMP_PAPD_PAYEE_ADDR3_LABEL = COMP_PAPD_PAYEE_ADDR3_LABEL;
	}

	public void setCOMP_PAPD_PAYEE_ADDR3(HtmlInputText COMP_PAPD_PAYEE_ADDR3) {
		this.COMP_PAPD_PAYEE_ADDR3 = COMP_PAPD_PAYEE_ADDR3;
	}

	public HtmlOutputLabel getCOMP_PAPD_ANLY_CODE_2_LABEL() {
		return COMP_PAPD_ANLY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_ANLY_CODE_2() {
		return COMP_PAPD_ANLY_CODE_2;
	}

	public void setCOMP_PAPD_ANLY_CODE_2_LABEL(
			HtmlOutputLabel COMP_PAPD_ANLY_CODE_2_LABEL) {
		this.COMP_PAPD_ANLY_CODE_2_LABEL = COMP_PAPD_ANLY_CODE_2_LABEL;
	}

	public void setCOMP_PAPD_ANLY_CODE_2(HtmlInputText COMP_PAPD_ANLY_CODE_2) {
		this.COMP_PAPD_ANLY_CODE_2 = COMP_PAPD_ANLY_CODE_2;
	}

	public HtmlOutputLabel getCOMP_UI_M_ANLY_DESC2_LABEL() {
		return COMP_UI_M_ANLY_DESC2_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ANLY_DESC2() {
		return COMP_UI_M_ANLY_DESC2;
	}

	public void setCOMP_UI_M_ANLY_DESC2_LABEL(
			HtmlOutputLabel COMP_UI_M_ANLY_DESC2_LABEL) {
		this.COMP_UI_M_ANLY_DESC2_LABEL = COMP_UI_M_ANLY_DESC2_LABEL;
	}

	public void setCOMP_UI_M_ANLY_DESC2(HtmlInputText COMP_UI_M_ANLY_DESC2) {
		this.COMP_UI_M_ANLY_DESC2 = COMP_UI_M_ANLY_DESC2;
	}

	public HtmlOutputLabel getCOMP_PAPD_OFF_AREA_CODE_LABEL() {
		return COMP_PAPD_OFF_AREA_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_OFF_AREA_CODE() {
		return COMP_PAPD_OFF_AREA_CODE;
	}

	public void setCOMP_PAPD_OFF_AREA_CODE_LABEL(
			HtmlOutputLabel COMP_PAPD_OFF_AREA_CODE_LABEL) {
		this.COMP_PAPD_OFF_AREA_CODE_LABEL = COMP_PAPD_OFF_AREA_CODE_LABEL;
	}

	public void setCOMP_PAPD_OFF_AREA_CODE(HtmlInputText COMP_PAPD_OFF_AREA_CODE) {
		this.COMP_PAPD_OFF_AREA_CODE = COMP_PAPD_OFF_AREA_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_POSTAL_DESC_LABEL() {
		return COMP_UI_M_POSTAL_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POSTAL_DESC() {
		return COMP_UI_M_POSTAL_DESC;
	}

	public void setCOMP_UI_M_POSTAL_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_POSTAL_DESC_LABEL) {
		this.COMP_UI_M_POSTAL_DESC_LABEL = COMP_UI_M_POSTAL_DESC_LABEL;
	}

	public void setCOMP_UI_M_POSTAL_DESC(HtmlInputText COMP_UI_M_POSTAL_DESC) {
		this.COMP_UI_M_POSTAL_DESC = COMP_UI_M_POSTAL_DESC;
	}

	public HtmlOutputLabel getCOMP_PAPD_PAYEE_ANLY_CODE_1_LABEL() {
		return COMP_PAPD_PAYEE_ANLY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_PAYEE_ANLY_CODE_1() {
		return COMP_PAPD_PAYEE_ANLY_CODE_1;
	}

	public void setCOMP_PAPD_PAYEE_ANLY_CODE_1_LABEL(
			HtmlOutputLabel COMP_PAPD_PAYEE_ANLY_CODE_1_LABEL) {
		this.COMP_PAPD_PAYEE_ANLY_CODE_1_LABEL = COMP_PAPD_PAYEE_ANLY_CODE_1_LABEL;
	}

	public void setCOMP_PAPD_PAYEE_ANLY_CODE_1(
			HtmlInputText COMP_PAPD_PAYEE_ANLY_CODE_1) {
		this.COMP_PAPD_PAYEE_ANLY_CODE_1 = COMP_PAPD_PAYEE_ANLY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_PAYEE_ANLY_DESC1_LABEL() {
		return COMP_UI_M_PAYEE_ANLY_DESC1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PAYEE_ANLY_DESC1() {
		return COMP_UI_M_PAYEE_ANLY_DESC1;
	}

	public void setCOMP_UI_M_PAYEE_ANLY_DESC1_LABEL(
			HtmlOutputLabel COMP_UI_M_PAYEE_ANLY_DESC1_LABEL) {
		this.COMP_UI_M_PAYEE_ANLY_DESC1_LABEL = COMP_UI_M_PAYEE_ANLY_DESC1_LABEL;
	}

	public void setCOMP_UI_M_PAYEE_ANLY_DESC1(
			HtmlInputText COMP_UI_M_PAYEE_ANLY_DESC1) {
		this.COMP_UI_M_PAYEE_ANLY_DESC1 = COMP_UI_M_PAYEE_ANLY_DESC1;
	}

	public HtmlOutputLabel getCOMP_PAPD_CITY_CODE_LABEL() {
		return COMP_PAPD_CITY_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_CITY_CODE() {
		return COMP_PAPD_CITY_CODE;
	}

	public void setCOMP_PAPD_CITY_CODE_LABEL(
			HtmlOutputLabel COMP_PAPD_CITY_CODE_LABEL) {
		this.COMP_PAPD_CITY_CODE_LABEL = COMP_PAPD_CITY_CODE_LABEL;
	}

	public void setCOMP_PAPD_CITY_CODE(HtmlInputText COMP_PAPD_CITY_CODE) {
		this.COMP_PAPD_CITY_CODE = COMP_PAPD_CITY_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CITY_DESC_LABEL() {
		return COMP_UI_M_CITY_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CITY_DESC() {
		return COMP_UI_M_CITY_DESC;
	}

	public void setCOMP_UI_M_CITY_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_CITY_DESC_LABEL) {
		this.COMP_UI_M_CITY_DESC_LABEL = COMP_UI_M_CITY_DESC_LABEL;
	}

	public void setCOMP_UI_M_CITY_DESC(HtmlInputText COMP_UI_M_CITY_DESC) {
		this.COMP_UI_M_CITY_DESC = COMP_UI_M_CITY_DESC;
	}

	public HtmlOutputLabel getCOMP_PAPD_PAYEE_ANLY_CODE_2_LABEL() {
		return COMP_PAPD_PAYEE_ANLY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_PAYEE_ANLY_CODE_2() {
		return COMP_PAPD_PAYEE_ANLY_CODE_2;
	}

	public void setCOMP_PAPD_PAYEE_ANLY_CODE_2_LABEL(
			HtmlOutputLabel COMP_PAPD_PAYEE_ANLY_CODE_2_LABEL) {
		this.COMP_PAPD_PAYEE_ANLY_CODE_2_LABEL = COMP_PAPD_PAYEE_ANLY_CODE_2_LABEL;
	}

	public void setCOMP_PAPD_PAYEE_ANLY_CODE_2(
			HtmlInputText COMP_PAPD_PAYEE_ANLY_CODE_2) {
		this.COMP_PAPD_PAYEE_ANLY_CODE_2 = COMP_PAPD_PAYEE_ANLY_CODE_2;
	}

	public HtmlOutputLabel getCOMP_UI_M_PAYEE_ANLY_DESC2_LABEL() {
		return COMP_UI_M_PAYEE_ANLY_DESC2_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PAYEE_ANLY_DESC2() {
		return COMP_UI_M_PAYEE_ANLY_DESC2;
	}

	public void setCOMP_UI_M_PAYEE_ANLY_DESC2_LABEL(
			HtmlOutputLabel COMP_UI_M_PAYEE_ANLY_DESC2_LABEL) {
		this.COMP_UI_M_PAYEE_ANLY_DESC2_LABEL = COMP_UI_M_PAYEE_ANLY_DESC2_LABEL;
	}

	public void setCOMP_UI_M_PAYEE_ANLY_DESC2(
			HtmlInputText COMP_UI_M_PAYEE_ANLY_DESC2) {
		this.COMP_UI_M_PAYEE_ANLY_DESC2 = COMP_UI_M_PAYEE_ANLY_DESC2;
	}

	public HtmlOutputLabel getCOMP_PAPD_STATE_CODE_LABEL() {
		return COMP_PAPD_STATE_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_STATE_CODE() {
		return COMP_PAPD_STATE_CODE;
	}

	public void setCOMP_PAPD_STATE_CODE_LABEL(
			HtmlOutputLabel COMP_PAPD_STATE_CODE_LABEL) {
		this.COMP_PAPD_STATE_CODE_LABEL = COMP_PAPD_STATE_CODE_LABEL;
	}

	public void setCOMP_PAPD_STATE_CODE(HtmlInputText COMP_PAPD_STATE_CODE) {
		this.COMP_PAPD_STATE_CODE = COMP_PAPD_STATE_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_STATE_DESC_LABEL() {
		return COMP_UI_M_STATE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_STATE_DESC() {
		return COMP_UI_M_STATE_DESC;
	}

	public void setCOMP_UI_M_STATE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_STATE_DESC_LABEL) {
		this.COMP_UI_M_STATE_DESC_LABEL = COMP_UI_M_STATE_DESC_LABEL;
	}

	public void setCOMP_UI_M_STATE_DESC(HtmlInputText COMP_UI_M_STATE_DESC) {
		this.COMP_UI_M_STATE_DESC = COMP_UI_M_STATE_DESC;
	}

	public HtmlOutputLabel getCOMP_PAPD_ACTY_CODE_1_LABEL() {
		return COMP_PAPD_ACTY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_ACTY_CODE_1() {
		return COMP_PAPD_ACTY_CODE_1;
	}

	public void setCOMP_PAPD_ACTY_CODE_1_LABEL(
			HtmlOutputLabel COMP_PAPD_ACTY_CODE_1_LABEL) {
		this.COMP_PAPD_ACTY_CODE_1_LABEL = COMP_PAPD_ACTY_CODE_1_LABEL;
	}

	public void setCOMP_PAPD_ACTY_CODE_1(HtmlInputText COMP_PAPD_ACTY_CODE_1) {
		this.COMP_PAPD_ACTY_CODE_1 = COMP_PAPD_ACTY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACTY_DESC1_LABEL() {
		return COMP_UI_M_ACTY_DESC1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACTY_DESC1() {
		return COMP_UI_M_ACTY_DESC1;
	}

	public void setCOMP_UI_M_ACTY_DESC1_LABEL(
			HtmlOutputLabel COMP_UI_M_ACTY_DESC1_LABEL) {
		this.COMP_UI_M_ACTY_DESC1_LABEL = COMP_UI_M_ACTY_DESC1_LABEL;
	}

	public void setCOMP_UI_M_ACTY_DESC1(HtmlInputText COMP_UI_M_ACTY_DESC1) {
		this.COMP_UI_M_ACTY_DESC1 = COMP_UI_M_ACTY_DESC1;
	}

	public HtmlOutputLabel getCOMP_PAPD_BANK_CODE_LABEL() {
		return COMP_PAPD_BANK_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_BANK_CODE() {
		return COMP_PAPD_BANK_CODE;
	}

	public void setCOMP_PAPD_BANK_CODE_LABEL(
			HtmlOutputLabel COMP_PAPD_BANK_CODE_LABEL) {
		this.COMP_PAPD_BANK_CODE_LABEL = COMP_PAPD_BANK_CODE_LABEL;
	}

	public void setCOMP_PAPD_BANK_CODE(HtmlInputText COMP_PAPD_BANK_CODE) {
		this.COMP_PAPD_BANK_CODE = COMP_PAPD_BANK_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_BANK_DESC_LABEL() {
		return COMP_UI_M_BANK_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BANK_DESC() {
		return COMP_UI_M_BANK_DESC;
	}

	public void setCOMP_UI_M_BANK_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_BANK_DESC_LABEL) {
		this.COMP_UI_M_BANK_DESC_LABEL = COMP_UI_M_BANK_DESC_LABEL;
	}

	public void setCOMP_UI_M_BANK_DESC(HtmlInputText COMP_UI_M_BANK_DESC) {
		this.COMP_UI_M_BANK_DESC = COMP_UI_M_BANK_DESC;
	}

	public HtmlOutputLabel getCOMP_PAPD_ACTY_CODE_2_LABEL() {
		return COMP_PAPD_ACTY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_ACTY_CODE_2() {
		return COMP_PAPD_ACTY_CODE_2;
	}

	public void setCOMP_PAPD_ACTY_CODE_2_LABEL(
			HtmlOutputLabel COMP_PAPD_ACTY_CODE_2_LABEL) {
		this.COMP_PAPD_ACTY_CODE_2_LABEL = COMP_PAPD_ACTY_CODE_2_LABEL;
	}

	public void setCOMP_PAPD_ACTY_CODE_2(HtmlInputText COMP_PAPD_ACTY_CODE_2) {
		this.COMP_PAPD_ACTY_CODE_2 = COMP_PAPD_ACTY_CODE_2;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACTY_DESC2_LABEL() {
		return COMP_UI_M_ACTY_DESC2_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACTY_DESC2() {
		return COMP_UI_M_ACTY_DESC2;
	}

	public void setCOMP_UI_M_ACTY_DESC2_LABEL(
			HtmlOutputLabel COMP_UI_M_ACTY_DESC2_LABEL) {
		this.COMP_UI_M_ACTY_DESC2_LABEL = COMP_UI_M_ACTY_DESC2_LABEL;
	}

	public void setCOMP_UI_M_ACTY_DESC2(HtmlInputText COMP_UI_M_ACTY_DESC2) {
		this.COMP_UI_M_ACTY_DESC2 = COMP_UI_M_ACTY_DESC2;
	}

	public HtmlOutputLabel getCOMP_UI_M_PAPD_CLE_ZONE_DESC_LABEL() {
		return COMP_UI_M_PAPD_CLE_ZONE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PAPD_CLE_ZONE_DESC() {
		return COMP_UI_M_PAPD_CLE_ZONE_DESC;
	}

	public void setCOMP_UI_M_PAPD_CLE_ZONE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PAPD_CLE_ZONE_DESC_LABEL) {
		this.COMP_UI_M_PAPD_CLE_ZONE_DESC_LABEL = COMP_UI_M_PAPD_CLE_ZONE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PAPD_CLE_ZONE_DESC(
			HtmlInputText COMP_UI_M_PAPD_CLE_ZONE_DESC) {
		this.COMP_UI_M_PAPD_CLE_ZONE_DESC = COMP_UI_M_PAPD_CLE_ZONE_DESC;
	}

	public HtmlOutputLabel getCOMP_PAPD_CLE_ZONE_CODE_LABEL() {
		return COMP_PAPD_CLE_ZONE_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_CLE_ZONE_CODE() {
		return COMP_PAPD_CLE_ZONE_CODE;
	}

	public void setCOMP_PAPD_CLE_ZONE_CODE_LABEL(
			HtmlOutputLabel COMP_PAPD_CLE_ZONE_CODE_LABEL) {
		this.COMP_PAPD_CLE_ZONE_CODE_LABEL = COMP_PAPD_CLE_ZONE_CODE_LABEL;
	}

	public void setCOMP_PAPD_CLE_ZONE_CODE(HtmlInputText COMP_PAPD_CLE_ZONE_CODE) {
		this.COMP_PAPD_CLE_ZONE_CODE = COMP_PAPD_CLE_ZONE_CODE;
	}

	public HtmlOutputLabel getCOMP_PAPD_NARRATION_LABEL() {
		return COMP_PAPD_NARRATION_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_NARRATION() {
		return COMP_PAPD_NARRATION;
	}

	public void setCOMP_PAPD_NARRATION_LABEL(
			HtmlOutputLabel COMP_PAPD_NARRATION_LABEL) {
		this.COMP_PAPD_NARRATION_LABEL = COMP_PAPD_NARRATION_LABEL;
	}

	public void setCOMP_PAPD_NARRATION(HtmlInputText COMP_PAPD_NARRATION) {
		this.COMP_PAPD_NARRATION = COMP_PAPD_NARRATION;
	}

	public HtmlOutputLabel getCOMP_PAPD_DES_MTD_CODE_LABEL() {
		return COMP_PAPD_DES_MTD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_DES_MTD_CODE() {
		return COMP_PAPD_DES_MTD_CODE;
	}

	public void setCOMP_PAPD_DES_MTD_CODE_LABEL(
			HtmlOutputLabel COMP_PAPD_DES_MTD_CODE_LABEL) {
		this.COMP_PAPD_DES_MTD_CODE_LABEL = COMP_PAPD_DES_MTD_CODE_LABEL;
	}

	public void setCOMP_PAPD_DES_MTD_CODE(HtmlInputText COMP_PAPD_DES_MTD_CODE) {
		this.COMP_PAPD_DES_MTD_CODE = COMP_PAPD_DES_MTD_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PAPD_DES_MTD_DESC_LABEL() {
		return COMP_UI_M_PAPD_DES_MTD_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PAPD_DES_MTD_DESC() {
		return COMP_UI_M_PAPD_DES_MTD_DESC;
	}

	public void setCOMP_UI_M_PAPD_DES_MTD_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PAPD_DES_MTD_DESC_LABEL) {
		this.COMP_UI_M_PAPD_DES_MTD_DESC_LABEL = COMP_UI_M_PAPD_DES_MTD_DESC_LABEL;
	}

	public void setCOMP_UI_M_PAPD_DES_MTD_DESC(
			HtmlInputText COMP_UI_M_PAPD_DES_MTD_DESC) {
		this.COMP_UI_M_PAPD_DES_MTD_DESC = COMP_UI_M_PAPD_DES_MTD_DESC;
	}

	public HtmlOutputLabel getCOMP_PAPD_CHQ_APPR_USER_ID_LABEL() {
		return COMP_PAPD_CHQ_APPR_USER_ID_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_CHQ_APPR_USER_ID() {
		return COMP_PAPD_CHQ_APPR_USER_ID;
	}

	public void setCOMP_PAPD_CHQ_APPR_USER_ID_LABEL(
			HtmlOutputLabel COMP_PAPD_CHQ_APPR_USER_ID_LABEL) {
		this.COMP_PAPD_CHQ_APPR_USER_ID_LABEL = COMP_PAPD_CHQ_APPR_USER_ID_LABEL;
	}

	public void setCOMP_PAPD_CHQ_APPR_USER_ID(
			HtmlInputText COMP_PAPD_CHQ_APPR_USER_ID) {
		this.COMP_PAPD_CHQ_APPR_USER_ID = COMP_PAPD_CHQ_APPR_USER_ID;
	}

	public HtmlOutputLabel getCOMP_PAPD_CHQ_ISSUE_USER_ID_LABEL() {
		return COMP_PAPD_CHQ_ISSUE_USER_ID_LABEL;
	}

	public HtmlInputText getCOMP_PAPD_CHQ_ISSUE_USER_ID() {
		return COMP_PAPD_CHQ_ISSUE_USER_ID;
	}

	public void setCOMP_PAPD_CHQ_ISSUE_USER_ID_LABEL(
			HtmlOutputLabel COMP_PAPD_CHQ_ISSUE_USER_ID_LABEL) {
		this.COMP_PAPD_CHQ_ISSUE_USER_ID_LABEL = COMP_PAPD_CHQ_ISSUE_USER_ID_LABEL;
	}

	public void setCOMP_PAPD_CHQ_ISSUE_USER_ID(
			HtmlInputText COMP_PAPD_CHQ_ISSUE_USER_ID) {
		this.COMP_PAPD_CHQ_ISSUE_USER_ID = COMP_PAPD_CHQ_ISSUE_USER_ID;
	}

	public PT_IL_PAYVOU_PAY_DTL getPT_IL_PAYVOU_PAY_DTL_BEAN() {
		return PT_IL_PAYVOU_PAY_DTL_BEAN;
	}

	public void setPT_IL_PAYVOU_PAY_DTL_BEAN(
			PT_IL_PAYVOU_PAY_DTL PT_IL_PAYVOU_PAY_DTL_BEAN) {
		this.PT_IL_PAYVOU_PAY_DTL_BEAN = PT_IL_PAYVOU_PAY_DTL_BEAN;
	}

	public void onLoad(PhaseEvent event) {
		if (!isOnLoadFlag()) {
			try {
				PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
				helper.whenNewRecordInstance();
				helper.whenNewBlockInstance();
				setOnLoadFlag(true);
			} catch (Exception e) {
				getErrorMap().put("current", e.getMessage());
				setErrorMessages(e.getMessage());
			}
		}
	}

	public String getCurrentValue(ActionEvent event) {
		String value = null;
		UIInput input = null;

		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
				System.out.println("Value in input field: " + value);
			}
		}
		return value;
	}

	public void addNewRow() {
		PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
		helper.addNewButton();
	}

	public void PAPD_PAY_MODEValidate(ActionEvent event) {

		PT_IL_PAYVOU_PAY_DTL PT_IL_PAYVOU_PAY_DTL_BEAN = getPT_IL_PAYVOU_PAY_DTL_BEAN();
		String inputValue = null;
		UIInput input = (UIInput) event.getComponent().getParent();
		inputValue = getCurrentValue(event);

		// int rowIndex = getPT_IL_PAYVOU_PAY_DTL_DT().getRowIndex();
		// PT_IL_PAYVOU_PAY_DTL_LIST.get(rowIndex).setPAPD_PAY_MODE(inputValue);
		PT_IL_PAYVOU_PAY_DTL_BEAN.setPAPD_PAY_MODE(inputValue);
		ErrorHelpUtil.validate(input, getErrorMap());

		// gridtabListener();
	}

	public void PAPD_PAY_MODEValidator(FacesContext context,
			UIComponent component, Object value)
			throws ValidatorException {
		PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
		helper
				.pilt030_apac_pt_il_payvou_pay_dtl_papd_pay_mode_when_list_changed();
	}

	public void PAPD_FC_PAY_AMTValidator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
		helper
				.pilt030_apac_pt_il_payvou_pay_dtl_papd_fc_pay_amt_when_validate_item();
	}

	public void PAPD_FC_PAY_AMTValidate(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void PAPD_LC_PAY_AMTValidator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
		helper
				.pilt030_apac_pt_il_payvou_pay_dtl_papd_lc_pay_amt_when_validate_item();
	}

	public void PAPD_LC_PAY_AMTValidate(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void PAPD_PAYEE_NAMEValidator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
		helper
				.pilt030_apac_pt_il_payvou_pay_dtl_papd_payee_name_when_validate_item();
	}

	public void PAPD_PAYEE_NAMEValidate(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void PAPD_PAYEE_ADDR1Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
		helper
				.pilt030_apac_pt_il_payvou_pay_dtl_papd_payee_addr1_when_validate_item();
	}

	public void PAPD_PAYEE_ADDR1Validate(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void PAPD_OFF_AREA_CODEValidator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
		helper
				.pilt030_apac_pt_il_payvou_pay_dtl_papd_off_area_code_when_validate_item();
	}

	public void PAPD_OFF_AREA_CODEValidate(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void PAPD_CITY_CODEValidator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
		helper
				.pilt030_apac_pt_il_payvou_pay_dtl_papd_city_code_when_validate_item();
	}

	public void PAPD_CITY_CODEValidate(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void PAPD_STATE_CODEValidator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
		helper
				.pilt030_apac_pt_il_payvou_pay_dtl_papd_state_code_when_validate_item();
	}

	public void PAPD_STATE_CODEValidate(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void PAPD_BANK_CODEValidator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
		helper
				.pilt030_apac_pt_il_payvou_pay_dtl_papd_bank_code_when_validate_item();
	}

	public void PAPD_BANK_CODEValidate(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void PAPD_CLE_ZONE_CODEValidator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
		helper
				.pilt030_apac_pt_il_payvou_pay_dtl_papd_cle_zone_code_when_validate_item();
	}

	public void PAPD_CLE_ZONE_CODEValidate(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void PAPD_DES_MTD_CODEValidator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
		helper
				.pilt030_apac_pt_il_payvou_pay_dtl_papd_des_mtd_code_when_validate_item();
	}

	public void PAPD_DES_MTD_CODEValidate(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void PAPD_MAIN_ACNT_CODEValidator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
		helper
				.pilt030_apac_pt_il_payvou_pay_dtl_papd_main_acnt_code_when_validate_item();
	}

	public void PAPD_MAIN_ACNT_CODEValidate(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void PAPD_SUB_ACNT_CODEValidator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
		helper
				.pilt030_apac_pt_il_payvou_pay_dtl_papd_sub_acnt_code_when_validate_item();
	}

	public void PAPD_SUB_ACNT_CODEValidate(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void PAPD_ANLY_CODE_1Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
		helper
				.pilt030_apac_pt_il_payvou_pay_dtl_papd_anly_code_1_when_validate_item();
	}

	public void PAPD_ANLY_CODE_1Validate(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void PAPD_PAY_APPRV_CODEValidate(ActionEvent event){
		PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
		helper.pilt030_apac_pt_il_payvou_pay_dtl_papd_pay_apprv_code_pre_text_item();
	}

	public void PAPD_ANLY_CODE_2Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
		helper
				.pilt030_apac_pt_il_payvou_pay_dtl_papd_anly_code_2_when_validate_item();
	}

	public void PAPD_ANLY_CODE_2Validate(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void PAPD_PAYEE_ANLY_CODE_1Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
		helper
				.pilt030_apac_pt_il_payvou_pay_dtl_papd_payee_anly_code_1_when_validate_item();
	}

	public void PAPD_PAYEE_ANLY_CODE_1Validate(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void PAPD_PAYEE_ANLY_CODE_2Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
		helper
				.pilt030_apac_pt_il_payvou_pay_dtl_papd_payee_anly_code_2_when_validate_item();
	}

	public void PAPD_PAYEE_ANLY_CODE_2(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void PAPD_ACTY_CODE_1Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
		helper
				.pilt030_apac_pt_il_payvou_pay_dtl_papd_acty_code_1_when_validate_item();
	}

	public void PAPD_ACTY_CODE_1Validate(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void PAPD_ACTY_CODE_2Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
		helper
				.pilt030_apac_pt_il_payvou_pay_dtl_papd_acty_code_2_when_validate_item();
	}

	public void PAPD_ACTY_CODE_2Validate(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public List<PT_IL_PAYVOU_PAY_DTL> PAPD_ACTY_CODE_1(Object value) {
		List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
		try {
			PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
			payDtlList = helper.PAPD_ACTY_CODE_1((String) value);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		return payDtlList;
	}

	public List<PT_IL_PAYVOU_PAY_DTL> PAPD_ACTY_CODE_2(Object value) {
		List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
		try {
			PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
			payDtlList = helper.PAPD_ACTY_CODE_2((String) value);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		return payDtlList;
	}

	public List<PT_IL_PAYVOU_PAY_DTL> PAPD_ANLY_CODE_1(Object value) {
		List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
		try {
			PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
			payDtlList = helper.PAPD_ANLY_CODE_1((String) value);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		return payDtlList;
	}

	public List<PT_IL_PAYVOU_PAY_DTL> PAPD_ANLY_CODE_2(Object value) {
		List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
		try {
			PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
			payDtlList = helper.PAPD_ANLY_CODE_2((String) value);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		return payDtlList;
	}

	public List<PT_IL_PAYVOU_PAY_DTL> PAPD_BANK_CODE(Object value) {
		List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
		try {
			PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
			payDtlList = helper.PAPD_BANK_CODE((String) value);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		return payDtlList;
	}

	public List<PT_IL_PAYVOU_PAY_DTL> PAPD_CITY_CODE(Object value) {
		List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
		try {
			PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
			payDtlList = helper.PAPD_CITY_CODE((String) value);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		return payDtlList;
	}

	public List<PT_IL_PAYVOU_PAY_DTL> PAPD_CLE_ZONE_CODE(Object value) {
		List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
		try {
			PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
			payDtlList = helper.PAPD_CLE_ZONE_CODE((String) value);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		return payDtlList;
	}

	public List<PT_IL_PAYVOU_PAY_DTL> PAPD_DES_MTD_CODE(Object value) {
		List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
		try {
			PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
			payDtlList = helper.PAPD_DES_MTD_CODE((String) value);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		return payDtlList;
	}

	public List<PT_IL_PAYVOU_PAY_DTL> PAPD_MAIN_ACNT_CODE(Object value) {
		List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
		try {
			PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
			payDtlList = helper.PAPD_MAIN_ACNT_CODE((String) value);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		return payDtlList;
	}

	public List<PT_IL_PAYVOU_PAY_DTL> PAPD_OFF_AREA_CODE(Object value) {
		List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
		try {
			PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
			payDtlList = helper.PAPD_OFF_AREA_CODE((String) value);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		return payDtlList;
	}

	public List<PT_IL_PAYVOU_PAY_DTL> PAPD_PAYEE_ANLY_CODE_1(Object value) {
		List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
		try {
			PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
			payDtlList = helper.PAPD_PAYEE_ANLY_CODE_1((String) value);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		return payDtlList;
	}

	public List<PT_IL_PAYVOU_PAY_DTL> PAPD_PAYEE_ANLY_CODE_2(Object value) {
		List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
		try {
			PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
			payDtlList = helper.PAPD_PAYEE_ANLY_CODE_2((String) value);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		return payDtlList;
	}

	public List<PT_IL_PAYVOU_PAY_DTL> PAPD_STATE_CODE(Object value) {
		List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
		try {
			PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
			payDtlList = helper.PAPD_STATE_CODE((String) value);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		return payDtlList;
	}

	public List<PT_IL_PAYVOU_PAY_DTL> PAPD_SUB_ACNT_CODE(Object value) {
		List<PT_IL_PAYVOU_PAY_DTL> payDtlList = null;
		try {
			PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
			payDtlList = helper.PAPD_SUB_ACNT_CODE((String) value);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		return payDtlList;
	}
	
	

	public void saveRecord() {
		try {
			CommonUtils.clearMaps(this);
			CommonUtils.getConnection().commit();
			getWarningMap().put("SAVE",Messages.getString(
					PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void gridtabListener() {

		int currRowIndex = getPT_IL_PAYVOU_PAY_DTL_DT().getRowIndex();
		int rowUpdated = 0;
		PT_IL_PAYVOU_PAY_DTL gridValueBean = null;

		try {
			if (lastUpdatedRowIndex != -1) {
				if (lastUpdatedRowIndex != prevRowIndex) {
					if (currRowIndex != prevRowIndex) {
						// Get the bean based on row index
						gridValueBean = (PT_IL_PAYVOU_PAY_DTL) PT_IL_PAYVOU_PAY_DTL_LIST
								.get(prevRowIndex);

						// Update the record to database
						if (gridValueBean.getROWID() != null) {
							rowUpdated = 0; // dataGridDelegate.updateData(gridValueBean);
							getErrorMap().put("somekey",
									rowUpdated + " record updated.");
							getErrorMap().put("current",
									rowUpdated + " record updated.");
						} else {
							rowUpdated = 0; // dataGridDelegate.updateData(gridValueBean);
							getErrorMap().put("somekey",
									rowUpdated + " record inserted.");
							getErrorMap().put("current",
									rowUpdated + " record inserted.");

						}
						// Update previous row index
						prevRowIndex = currRowIndex;
					}
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return;
	}

	public void lastColumnListener() {
		System.out.println("LAST COLUMN LISTENER...............");
		int currRowIndex = getPT_IL_PAYVOU_PAY_DTL_DT().getRowIndex();
		int rowUpdated = 0;
		PT_IL_PAYVOU_PAY_DTL gridValueBean = null;
		PT_IL_PAYVOU_PAY_DTL_HELPER helper = null;
		try {
			gridValueBean = (PT_IL_PAYVOU_PAY_DTL) PT_IL_PAYVOU_PAY_DTL_LIST
					.get(currRowIndex);
			if (gridValueBean.getROWID() != null) {
				helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
				helper.preUpdate(gridValueBean);
				rowUpdated = helper.saveRecord(gridValueBean);
				getWarningMap().put("somekey", rowUpdated + " record updated.");
				getWarningMap().put("current", rowUpdated + " record updated.");
			} else {
				helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
				helper.preInsert(gridValueBean);
				rowUpdated = helper.saveRecord(gridValueBean);
				getWarningMap()
						.put("somekey", rowUpdated + " record inserted.");
				getWarningMap()
						.put("current", rowUpdated + " record inserted.");
			}
			lastUpdatedRowIndex = currRowIndex;
		} catch (Exception e1) {
			getErrorMap().put("current", e1.getMessage());
			setErrorMessages(e1.getMessage());
		}
	}

	int lastUpdatedRowIndex = 0;
	int prevRowIndex = 0;

	public void getDetails() {
		try {
			if (PT_IL_PAYVOU_PAY_DTL_LIST.size() != 0) {
				PT_IL_PAYVOU_PAY_DTL_BEAN = (PT_IL_PAYVOU_PAY_DTL) PT_IL_PAYVOU_PAY_DTL_DT
						.getRowData();
			}
			resetAllComponent();
			resetSelectedRow();
			PT_IL_PAYVOU_PAY_DTL_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void resetAllComponent() {
		// Reseting HtmlInputText
		COMP_PAPD_CUST_CODE.resetValue();

		COMP_UI_M_PAPD_CUST_DESC.resetValue();

		COMP_PAPD_PAY_MODE.resetValue();

		COMP_PAPD_FC_PAY_AMT.resetValue();

		COMP_PAPD_LC_PAY_AMT.resetValue();

		COMP_PAPD_PAYEE_NAME.resetValue();

		COMP_PAPD_CURR_CODE.resetValue();

		COMP_PAPD_BANK_ACC_NO.resetValue();

		COMP_PAPD_PAY_APPRV_CODE.resetValue();

		COMP_PAPD_CHQ_DT.resetValue();

		COMP_PAPD_ATTENTION_TO.resetValue();

		COMP_PAPD_MAIN_ACNT_CODE.resetValue();

		COMP_UI_M_MAIN_ACNT_CODE_DESC.resetValue();

		COMP_PAPD_PAYEE_ADDR1.resetValue();

		COMP_PAPD_SUB_ACNT_CODE.resetValue();

		COMP_UI_M_SUB_ACNT_DESC.resetValue();

		COMP_PAPD_PAYEE_ADDR2.resetValue();

		COMP_PAPD_ANLY_CODE_1.resetValue();

		COMP_UI_M_ANLY_DESC1.resetValue();

		COMP_PAPD_PAYEE_ADDR3.resetValue();

		COMP_PAPD_ANLY_CODE_2.resetValue();

		COMP_UI_M_ANLY_DESC2.resetValue();

		COMP_PAPD_OFF_AREA_CODE.resetValue();

		COMP_UI_M_POSTAL_DESC.resetValue();

		COMP_PAPD_PAYEE_ANLY_CODE_1.resetValue();

		COMP_UI_M_PAYEE_ANLY_DESC1.resetValue();

		COMP_PAPD_CITY_CODE.resetValue();

		COMP_UI_M_CITY_DESC.resetValue();

		COMP_PAPD_PAYEE_ANLY_CODE_2.resetValue();

		COMP_UI_M_PAYEE_ANLY_DESC2.resetValue();

		COMP_PAPD_STATE_CODE.resetValue();

		COMP_UI_M_STATE_DESC.resetValue();

		COMP_PAPD_ACTY_CODE_1.resetValue();

		COMP_UI_M_ACTY_DESC1.resetValue();

		COMP_PAPD_BANK_CODE.resetValue();

		COMP_UI_M_BANK_DESC.resetValue();

		COMP_PAPD_ACTY_CODE_2.resetValue();

		COMP_UI_M_ACTY_DESC2.resetValue();

		COMP_UI_M_PAPD_CLE_ZONE_DESC.resetValue();

		COMP_PAPD_CLE_ZONE_CODE.resetValue();

		COMP_PAPD_NARRATION.resetValue();

		COMP_PAPD_DES_MTD_CODE.resetValue();

		COMP_UI_M_PAPD_DES_MTD_DESC.resetValue();

		COMP_PAPD_CHQ_APPR_USER_ID.resetValue();

		COMP_PAPD_CHQ_ISSUE_USER_ID.resetValue();
	}

	private void resetSelectedRow() {
		Iterator<PT_IL_PAYVOU_PAY_DTL> iterator = PT_IL_PAYVOU_PAY_DTL_LIST
				.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	/*public void AddRow(ActionEvent event) {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {
				PT_IL_PAYVOU_PAY_DTL_BEAN = new PT_IL_PAYVOU_PAY_DTL();
				resetAllComponent();
			} else {
				getErrorMap().put(
						"somekey",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						"current",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}

	}*/
	
	public void AddRow(ActionEvent event) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isINSERT_ALLOWED()) {
				PT_IL_PAYVOU_PAY_DTL_BEAN = new PT_IL_PAYVOU_PAY_DTL();
				this.setPT_IL_PAYVOU_PAY_DTL_BEAN(PT_IL_PAYVOU_PAY_DTL_BEAN);
				resetAllComponent();
				resetSelectedRow();
			} else {
				getErrorMap().put(
						"somekey",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						"current",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}
	}
	

	public void AddRow1() {
		System.out
				.println(">>>>>>>>>>>>ADDROW METHOD>>>>>>>>>>>>>>>>>>HANEEF>>>>>>>>>>>>");
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {
				PT_IL_PAYVOU_PAY_DTL_BEAN = new PT_IL_PAYVOU_PAY_DTL();
				resetAllComponent();
			} else {
				getErrorMap().put(
						"somekey",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						"current",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}

	}

	/*public String deleteRow(ActionEvent actionEvent) {
		if (getErrorMap().containsKey("current")
				|| getWarningMap().containsKey("current")) {
			getErrorMap().remove("current");
			getWarningMap().remove("current");
		}
		PT_IL_PAYVOU_PAY_DTL bean = null;
		ArrayList<Integer> deletedRecordList = null;
		int deletedRecordIndex = 0;
		if (PT_IL_PAYVOU_PAY_DTL_LIST != null) {
			deletedRecordList = new ArrayList<Integer>();
			for (int index = 0; index < PT_IL_PAYVOU_PAY_DTL_LIST.size();) {
				bean = PT_IL_PAYVOU_PAY_DTL_LIST.get(index);
				System.out.println("bean selected:::");

				if ("dataTableSelectedRow".equalsIgnoreCase(bean
						.getRowSelected())) {
					PT_IL_PAYVOU_PAY_DTL_LIST.remove(bean);
					deletedRecordIndex = this.deleteData(bean);
					deletedRecordList.add(deletedRecordIndex);
				} else {
					index++;
				}
			}

			if (deletedRecordList.size() > 0) {
				getWarningMap().put("current", "Record Deleted");
			}
			lastUpdatedRowIndex = -1;
		}
		return "";
	}*/

	public int deleteData(PT_IL_PAYVOU_PAY_DTL bean) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(bean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}

	public void deleteRow(ActionEvent ae) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isDELETE_ALLOWED()) {
				if (PT_IL_PAYVOU_PAY_DTL_BEAN.getROWID() != null) {
					// executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PT_IL_PAYVOU_PAY_DTL_BEAN,
							CommonUtils.getConnection());
					PT_IL_PAYVOU_PAY_DTL_LIST.remove(PT_IL_PAYVOU_PAY_DTL_BEAN);
				}

				if (PT_IL_PAYVOU_PAY_DTL_LIST.size() > 0) {
					setPT_IL_PAYVOU_PAY_DTL_BEAN(PT_IL_PAYVOU_PAY_DTL_LIST
							.get(0));
					
				} else {
					AddRow(null);
				}

				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				resetAllComponent();
				PT_IL_PAYVOU_PAY_DTL_BEAN.setRowSelected(true);

			} else {
				getErrorMap().clear();
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
	}
	
  public void post(ActionEvent event) {
	PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
		try {
			if (PT_IL_PAYVOU_PAY_DTL_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.preInsert(PT_IL_PAYVOU_PAY_DTL_BEAN);
				new CRUDHandler().executeInsert(PT_IL_PAYVOU_PAY_DTL_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$save"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$save"));
				PT_IL_PAYVOU_PAY_DTL_LIST.add(PT_IL_PAYVOU_PAY_DTL_BEAN);
			} else if (PT_IL_PAYVOU_PAY_DTL_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.preUpdate(PT_IL_PAYVOU_PAY_DTL_BEAN);
				new CRUDHandler().executeUpdate(PT_IL_PAYVOU_PAY_DTL_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update"));
			}

			PT_IL_PAYVOU_PAY_DTL_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}
	}
	
	
	/*public void post(ActionEvent ae) {
		PT_IL_PAYVOU_PAY_DTL_HELPER helper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
		int rowUpdated = 0;
		try {
			if (PT_IL_PAYVOU_PAY_DTL_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					helper.preUpdate(PT_IL_PAYVOU_PAY_DTL_BEAN);
					// new
					// CRUDHandler().executeInsert(PT_IL_PAYVOU_PAY_DTL_BEAN,
					// new CommonUtils().getConnection());
					rowUpdated = helper.saveRecord(PT_IL_PAYVOU_PAY_DTL_BEAN);
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
				}
			} else {

				if (isINSERT_ALLOWED()) {
					helper.preInsert(PT_IL_PAYVOU_PAY_DTL_BEAN);
					// new
					// CRUDHandler().executeInsert(PM_IL_SURR_PAID_FACTOR_BEAN,
					// new CommonUtils().getConnection());
					rowUpdated = helper.saveRecord(PT_IL_PAYVOU_PAY_DTL_BEAN);
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					PT_IL_PAYVOU_PAY_DTL_LIST.add(PT_IL_PAYVOU_PAY_DTL_BEAN);
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
				}
			}
			resetAllComponent();

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}*/

}
