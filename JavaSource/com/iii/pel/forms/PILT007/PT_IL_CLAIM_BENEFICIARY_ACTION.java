package com.iii.pel.forms.PILT007;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POLICY_QUERY_CONSTANTS;
import com.iii.pel.utils.LIFELIB;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_CLAIM_BENEFICIARY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CBEN_BNF_NAME_LABEL;

	private HtmlInputText COMP_CBEN_BNF_NAME;

	private HtmlOutputLabel COMP_CBEN_REF_ID1_LABEL;

	private HtmlInputText COMP_CBEN_REF_ID1;

	private HtmlOutputLabel COMP_CBEN_REF_ID2_LABEL;

	private HtmlInputText COMP_CBEN_REF_ID2;

	private HtmlOutputLabel COMP_CBEN_RELATION_CODE_LABEL;

	private HtmlInputText COMP_CBEN_RELATION_CODE;

	private HtmlOutputLabel COMP_CBEN_BNF_TYPE_LABEL;

	private HtmlInputText COMP_CBEN_BNF_TYPE;

	private HtmlOutputLabel COMP_CBEN_PERC_LABEL;

	private HtmlInputText COMP_CBEN_PERC;

	private HtmlOutputLabel COMP_CBEN_FC_PAID_AMT_LABEL;

	private HtmlInputText COMP_CBEN_FC_PAID_AMT;

	private HtmlOutputLabel COMP_CBEN_LC_PAID_AMT_LABEL;

	private HtmlInputText COMP_CBEN_LC_PAID_AMT;

	private HtmlOutputLabel COMP_CBEN_BANK_CODE_LABEL;

	private HtmlInputText COMP_CBEN_BANK_CODE;

	private HtmlOutputLabel COMP_UI_M_CBEN_BANK_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CBEN_BANK_CODE_DESC;

	private HtmlOutputLabel COMP_CBEN_ACCT_CODE_LABEL;

	private HtmlInputText COMP_CBEN_ACCT_CODE;

	private HtmlOutputLabel COMP_CBEN_ADDRESS1_LABEL;

	private HtmlInputText COMP_CBEN_ADDRESS1;

	private HtmlOutputLabel COMP_UI_M_BNF_DESC_LABEL;

	private HtmlInputText COMP_UI_M_BNF_DESC;

	private HtmlOutputLabel COMP_CBEN_ADDRESS2_LABEL;

	private HtmlInputText COMP_CBEN_ADDRESS2;

	private HtmlOutputLabel COMP_UI_M_CBEN_RELATION_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CBEN_RELATION_DESC;

	private HtmlOutputLabel COMP_CBEN_ADDRESS3_LABEL;

	private HtmlInputText COMP_CBEN_ADDRESS3;

	private HtmlOutputLabel COMP_CBEN_STAT_CODE_LABEL;

	private HtmlInputText COMP_CBEN_STAT_CODE;

	private HtmlOutputLabel COMP_UI_M_CBEN_STAT_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CBEN_STAT_CODE_DESC;

	private HtmlOutputLabel COMP_CBEN_POSTAL_CODE_LABEL;

	private HtmlInputText COMP_CBEN_POSTAL_CODE;

	private HtmlOutputLabel COMP_UI_M_CBEN_POSTAL_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CBEN_POSTAL_CODE_DESC;

	private HtmlOutputLabel COMP_CBEN_CITY_CODE_LABEL;

	private HtmlInputText COMP_CBEN_CITY_CODE;

	private HtmlOutputLabel COMP_UI_M_CBEN_CITY_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CBEN_CITY_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_REL_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_BEN_TYPE;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_STAT_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_POSTAL_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_CITY_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_CBEN_BANK_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_BENF_DTLS_MAIN;

	private HtmlCommandButton COMP_UI_M_ADDROW_BUTTON;
	
	private HtmlCommandButton COMP_UI_M_REMOVE_BUTTON;
	private HtmlInputText COMP_CBEN_ADDRESS4;
	private HtmlInputText COMP_CBEN_ADDRESS5;
	private HtmlInputText COMP_CBEN_REMARKS;
	private HtmlInputText COMP_CBEN_CATG_CODE;
	private HtmlInputText COMP_CBEN_AGE;
	private HtmlInputText COMP_CBEN_GUARDIAN_NAME;
	private HtmlInputText COMP_CBEN_MICR_CODE;
	private HtmlOutputLabel COMP_CBEN_ADDRESS4_LABEL;
	private HtmlOutputLabel COMP_CBEN_ADDRESS5_LABEL;
	private HtmlOutputLabel COMP_CBEN_REMARKS_LABEL;
	private HtmlOutputLabel COMP_CBEN_CATG_CODE_LABEL;
	private HtmlOutputLabel COMP_CBEN_AGE_LABEL;
	private HtmlOutputLabel COMP_CBEN_GUARDIAN_NAME_LABEL;
	private HtmlOutputLabel COMP_CBEN_MICR_CODE_LABEL;
	private HtmlInputText COMP_UI_M_CATG_DESC;
	private HtmlInputText COMP_CBEN_DIVN_CODE;
	private HtmlInputText COMP_UI_M_CBEN_DIVN_CODE;
	private HtmlOutputLabel COMP_CBEN_DIVN_CODE_LABEL;
	private PT_IL_CLAIM_BENEFICIARY PT_IL_CLAIM_BENEFICIARY_BEAN;
	PT_IL_CLAIM_BENEFICIARY_HELPER helper = null;
	/*added by gopi for hands on feed back points,serial no 12 in zb on 02/02/17*/
	private HtmlOutputLabel COMP_PBEN_SR_NO_LABEL;
	
	public HtmlOutputLabel getCOMP_PBEN_SR_NO_LABEL() {
		return COMP_PBEN_SR_NO_LABEL;
	}
	public void setCOMP_PBEN_SR_NO_LABEL(HtmlOutputLabel cOMP_PBEN_SR_NO_LABEL) {
		COMP_PBEN_SR_NO_LABEL = cOMP_PBEN_SR_NO_LABEL;
	}
	private HtmlInputText COMP_PBEN_SR_NO;
	
	public HtmlInputText getCOMP_PBEN_SR_NO() {
		return COMP_PBEN_SR_NO;
	}
	public void setCOMP_PBEN_SR_NO(HtmlInputText cOMP_PBEN_SR_NO) {
		COMP_PBEN_SR_NO = cOMP_PBEN_SR_NO;
	}
	private HtmlOutputLabel COMP_PBEN_DOB_LABEL;
	
	public HtmlOutputLabel getCOMP_PBEN_DOB_LABEL() {
		return COMP_PBEN_DOB_LABEL;
	}
	public void setCOMP_PBEN_DOB_LABEL(HtmlOutputLabel cOMP_PBEN_DOB_LABEL) {
		COMP_PBEN_DOB_LABEL = cOMP_PBEN_DOB_LABEL;
	}
	private HtmlCalendar COMP_PBEN_DOB;
	
	public HtmlCalendar getCOMP_PBEN_DOB() {
		return COMP_PBEN_DOB;
	}
	public void setCOMP_PBEN_DOB(HtmlCalendar cOMP_PBEN_DOB) {
		COMP_PBEN_DOB = cOMP_PBEN_DOB;
	}
	
	private HtmlInputText COMP_CBEN_BNF_CODE;
	
	public HtmlInputText getCOMP_CBEN_BNF_CODE() {
		return COMP_CBEN_BNF_CODE;
	}
	public void setCOMP_CBEN_BNF_CODE(HtmlInputText cOMP_CBEN_BNF_CODE) {
		COMP_CBEN_BNF_CODE = cOMP_CBEN_BNF_CODE;
	}
	/*end*/
	private UIData PT_IL_CLAIM_BENEFICIARY_DATATABLE;

	private List<PT_IL_CLAIM_BENEFICIARY> PT_IL_CLAIM_BENEFICIARY_LIST;

	PILT007_COMPOSITE_ACTION compositeAction;

	//ArrayList<PT_IL_CLAIM_BENEFICIARY> list = new ArrayList<PT_IL_CLAIM_BENEFICIARY>();

	private boolean update = false;

	private boolean onLoadFlag = false;

	private String filterByCBEN_BNF_NAME;

	private String filterByCBEN_REF_ID1;

	private String filterByCBEN_REF_ID2;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;

	/**
	 * @return the filterByCBEN_BNF_NAME
	 */
	public String getFilterByCBEN_BNF_NAME() {
		return filterByCBEN_BNF_NAME;
	}

	/**
	 * @param filterByCBEN_BNF_NAME
	 *            the filterByCBEN_BNF_NAME to set
	 */
	public void setFilterByCBEN_BNF_NAME(String filterByCBEN_BNF_NAME) {
		this.filterByCBEN_BNF_NAME = filterByCBEN_BNF_NAME;
	}

	/**
	 * @return the filterByCBEN_REF_ID1
	 */
	public String getFilterByCBEN_REF_ID1() {
		return filterByCBEN_REF_ID1;
	}

	/**
	 * @param filterByCBEN_REF_ID1
	 *            the filterByCBEN_REF_ID1 to set
	 */
	public void setFilterByCBEN_REF_ID1(String filterByCBEN_REF_ID1) {
		this.filterByCBEN_REF_ID1 = filterByCBEN_REF_ID1;
	}

	/**
	 * @return the filterByCBEN_REF_ID2
	 */
	public String getFilterByCBEN_REF_ID2() {
		return filterByCBEN_REF_ID2;
	}

	/**
	 * @param filterByCBEN_REF_ID2
	 *            the filterByCBEN_REF_ID2 to set
	 */
	public void setFilterByCBEN_REF_ID2(String filterByCBEN_REF_ID2) {
		this.filterByCBEN_REF_ID2 = filterByCBEN_REF_ID2;
	}

	/**
	 * @return the uI_M_BUT_ADD
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	/**
	 * @param ui_m_but_add
	 *            the uI_M_BUT_ADD to set
	 */
	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	/**
	 * @return the uI_M_BUT_DELETE
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_DELETE() {
		return UI_M_BUT_DELETE;
	}

	/**
	 * @param ui_m_but_delete
	 *            the uI_M_BUT_DELETE to set
	 */
	public void setUI_M_BUT_DELETE(HtmlAjaxCommandButton ui_m_but_delete) {
		UI_M_BUT_DELETE = ui_m_but_delete;
	}

	/**
	 * @return the uI_M_BUT_POST
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	/**
	 * @param ui_m_but_post
	 *            the uI_M_BUT_POST to set
	 */
	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	public PT_IL_CLAIM_BENEFICIARY_ACTION() {
		PT_IL_CLAIM_BENEFICIARY_BEAN = new PT_IL_CLAIM_BENEFICIARY();
		instantiateAllComponent();
		PT_IL_CLAIM_BENEFICIARY_LIST = new ArrayList<PT_IL_CLAIM_BENEFICIARY>();
		helper = new PT_IL_CLAIM_BENEFICIARY_HELPER();
	}

	public UIData getPT_IL_CLAIM_BENEFICIARY_DATATABLE() {
		return PT_IL_CLAIM_BENEFICIARY_DATATABLE;
	}

	public void setPT_IL_CLAIM_BENEFICIARY_DATATABLE(
			UIData pt_il_claim_beneficiary_datatable) {
		PT_IL_CLAIM_BENEFICIARY_DATATABLE = pt_il_claim_beneficiary_datatable;
	}

	public List<PT_IL_CLAIM_BENEFICIARY> getPT_IL_CLAIM_BENEFICIARY_LIST() {
		return PT_IL_CLAIM_BENEFICIARY_LIST;
	}

	public void setPT_IL_CLAIM_BENEFICIARY_LIST(
			List<PT_IL_CLAIM_BENEFICIARY> pt_il_claim_beneficiary_list) {
		PT_IL_CLAIM_BENEFICIARY_LIST = pt_il_claim_beneficiary_list;
	}

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	public boolean isOnLoadFlag() {
		return onLoadFlag;
	}

	public void setOnLoadFlag(boolean onLoadFlag) {
		this.onLoadFlag = onLoadFlag;
	}

	public HtmlCommandButton getCOMP_UI_M_ADDROW_BUTTON() {
		return COMP_UI_M_ADDROW_BUTTON;
	}

	public void setCOMP_UI_M_ADDROW_BUTTON(
			HtmlCommandButton comp_ui_m_addrow_button) {
		COMP_UI_M_ADDROW_BUTTON = comp_ui_m_addrow_button;
	}

	public HtmlCommandButton getCOMP_UI_M_REMOVE_BUTTON() {
		return COMP_UI_M_REMOVE_BUTTON;
	}

	public void setCOMP_UI_M_REMOVE_BUTTON(
			HtmlCommandButton comp_ui_m_remove_button) {
		COMP_UI_M_REMOVE_BUTTON = comp_ui_m_remove_button;
	}

	public HtmlOutputLabel getCOMP_CBEN_BNF_NAME_LABEL() {
		return COMP_CBEN_BNF_NAME_LABEL;
	}

	public HtmlInputText getCOMP_CBEN_BNF_NAME() {
		return COMP_CBEN_BNF_NAME;
	}

	public void setCOMP_CBEN_BNF_NAME_LABEL(
			HtmlOutputLabel COMP_CBEN_BNF_NAME_LABEL) {
		this.COMP_CBEN_BNF_NAME_LABEL = COMP_CBEN_BNF_NAME_LABEL;
	}

	public void setCOMP_CBEN_BNF_NAME(HtmlInputText COMP_CBEN_BNF_NAME) {
		this.COMP_CBEN_BNF_NAME = COMP_CBEN_BNF_NAME;
	}

	public HtmlOutputLabel getCOMP_CBEN_REF_ID1_LABEL() {
		return COMP_CBEN_REF_ID1_LABEL;
	}

	public HtmlInputText getCOMP_CBEN_REF_ID1() {
		return COMP_CBEN_REF_ID1;
	}

	public void setCOMP_CBEN_REF_ID1_LABEL(
			HtmlOutputLabel COMP_CBEN_REF_ID1_LABEL) {
		this.COMP_CBEN_REF_ID1_LABEL = COMP_CBEN_REF_ID1_LABEL;
	}

	public void setCOMP_CBEN_REF_ID1(HtmlInputText COMP_CBEN_REF_ID1) {
		this.COMP_CBEN_REF_ID1 = COMP_CBEN_REF_ID1;
	}

	public HtmlOutputLabel getCOMP_CBEN_REF_ID2_LABEL() {
		return COMP_CBEN_REF_ID2_LABEL;
	}

	public HtmlInputText getCOMP_CBEN_REF_ID2() {
		return COMP_CBEN_REF_ID2;
	}

	public void setCOMP_CBEN_REF_ID2_LABEL(
			HtmlOutputLabel COMP_CBEN_REF_ID2_LABEL) {
		this.COMP_CBEN_REF_ID2_LABEL = COMP_CBEN_REF_ID2_LABEL;
	}

	public void setCOMP_CBEN_REF_ID2(HtmlInputText COMP_CBEN_REF_ID2) {
		this.COMP_CBEN_REF_ID2 = COMP_CBEN_REF_ID2;
	}

	public HtmlOutputLabel getCOMP_CBEN_RELATION_CODE_LABEL() {
		return COMP_CBEN_RELATION_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CBEN_RELATION_CODE() {
		return COMP_CBEN_RELATION_CODE;
	}

	public void setCOMP_CBEN_RELATION_CODE_LABEL(
			HtmlOutputLabel COMP_CBEN_RELATION_CODE_LABEL) {
		this.COMP_CBEN_RELATION_CODE_LABEL = COMP_CBEN_RELATION_CODE_LABEL;
	}

	public void setCOMP_CBEN_RELATION_CODE(HtmlInputText COMP_CBEN_RELATION_CODE) {
		this.COMP_CBEN_RELATION_CODE = COMP_CBEN_RELATION_CODE;
	}

	public HtmlOutputLabel getCOMP_CBEN_BNF_TYPE_LABEL() {
		return COMP_CBEN_BNF_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_CBEN_BNF_TYPE() {
		return COMP_CBEN_BNF_TYPE;
	}

	public void setCOMP_CBEN_BNF_TYPE_LABEL(
			HtmlOutputLabel COMP_CBEN_BNF_TYPE_LABEL) {
		this.COMP_CBEN_BNF_TYPE_LABEL = COMP_CBEN_BNF_TYPE_LABEL;
	}

	public void setCOMP_CBEN_BNF_TYPE(HtmlInputText COMP_CBEN_BNF_TYPE) {
		this.COMP_CBEN_BNF_TYPE = COMP_CBEN_BNF_TYPE;
	}

	public HtmlOutputLabel getCOMP_CBEN_PERC_LABEL() {
		return COMP_CBEN_PERC_LABEL;
	}

	public HtmlInputText getCOMP_CBEN_PERC() {
		return COMP_CBEN_PERC;
	}

	public void setCOMP_CBEN_PERC_LABEL(HtmlOutputLabel COMP_CBEN_PERC_LABEL) {
		this.COMP_CBEN_PERC_LABEL = COMP_CBEN_PERC_LABEL;
	}

	public void setCOMP_CBEN_PERC(HtmlInputText COMP_CBEN_PERC) {
		this.COMP_CBEN_PERC = COMP_CBEN_PERC;
	}

	public HtmlOutputLabel getCOMP_CBEN_FC_PAID_AMT_LABEL() {
		return COMP_CBEN_FC_PAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_CBEN_FC_PAID_AMT() {
		return COMP_CBEN_FC_PAID_AMT;
	}

	public void setCOMP_CBEN_FC_PAID_AMT_LABEL(
			HtmlOutputLabel COMP_CBEN_FC_PAID_AMT_LABEL) {
		this.COMP_CBEN_FC_PAID_AMT_LABEL = COMP_CBEN_FC_PAID_AMT_LABEL;
	}

	public void setCOMP_CBEN_FC_PAID_AMT(HtmlInputText COMP_CBEN_FC_PAID_AMT) {
		this.COMP_CBEN_FC_PAID_AMT = COMP_CBEN_FC_PAID_AMT;
	}

	public HtmlOutputLabel getCOMP_CBEN_LC_PAID_AMT_LABEL() {
		return COMP_CBEN_LC_PAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_CBEN_LC_PAID_AMT() {
		return COMP_CBEN_LC_PAID_AMT;
	}

	public void setCOMP_CBEN_LC_PAID_AMT_LABEL(
			HtmlOutputLabel COMP_CBEN_LC_PAID_AMT_LABEL) {
		this.COMP_CBEN_LC_PAID_AMT_LABEL = COMP_CBEN_LC_PAID_AMT_LABEL;
	}

	public void setCOMP_CBEN_LC_PAID_AMT(HtmlInputText COMP_CBEN_LC_PAID_AMT) {
		this.COMP_CBEN_LC_PAID_AMT = COMP_CBEN_LC_PAID_AMT;
	}

	public HtmlOutputLabel getCOMP_CBEN_BANK_CODE_LABEL() {
		return COMP_CBEN_BANK_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CBEN_BANK_CODE() {
		return COMP_CBEN_BANK_CODE;
	}

	public void setCOMP_CBEN_BANK_CODE_LABEL(
			HtmlOutputLabel COMP_CBEN_BANK_CODE_LABEL) {
		this.COMP_CBEN_BANK_CODE_LABEL = COMP_CBEN_BANK_CODE_LABEL;
	}

	public void setCOMP_CBEN_BANK_CODE(HtmlInputText COMP_CBEN_BANK_CODE) {
		this.COMP_CBEN_BANK_CODE = COMP_CBEN_BANK_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CBEN_BANK_CODE_DESC_LABEL() {
		return COMP_UI_M_CBEN_BANK_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CBEN_BANK_CODE_DESC() {
		return COMP_UI_M_CBEN_BANK_CODE_DESC;
	}

	public void setCOMP_UI_M_CBEN_BANK_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_CBEN_BANK_CODE_DESC_LABEL) {
		this.COMP_UI_M_CBEN_BANK_CODE_DESC_LABEL = COMP_UI_M_CBEN_BANK_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_CBEN_BANK_CODE_DESC(
			HtmlInputText COMP_UI_M_CBEN_BANK_CODE_DESC) {
		this.COMP_UI_M_CBEN_BANK_CODE_DESC = COMP_UI_M_CBEN_BANK_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_CBEN_ACCT_CODE_LABEL() {
		return COMP_CBEN_ACCT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CBEN_ACCT_CODE() {
		return COMP_CBEN_ACCT_CODE;
	}

	public void setCOMP_CBEN_ACCT_CODE_LABEL(
			HtmlOutputLabel COMP_CBEN_ACCT_CODE_LABEL) {
		this.COMP_CBEN_ACCT_CODE_LABEL = COMP_CBEN_ACCT_CODE_LABEL;
	}

	public void setCOMP_CBEN_ACCT_CODE(HtmlInputText COMP_CBEN_ACCT_CODE) {
		this.COMP_CBEN_ACCT_CODE = COMP_CBEN_ACCT_CODE;
	}

	public HtmlOutputLabel getCOMP_CBEN_ADDRESS1_LABEL() {
		return COMP_CBEN_ADDRESS1_LABEL;
	}

	public HtmlInputText getCOMP_CBEN_ADDRESS1() {
		return COMP_CBEN_ADDRESS1;
	}

	public void setCOMP_CBEN_ADDRESS1_LABEL(
			HtmlOutputLabel COMP_CBEN_ADDRESS1_LABEL) {
		this.COMP_CBEN_ADDRESS1_LABEL = COMP_CBEN_ADDRESS1_LABEL;
	}

	public void setCOMP_CBEN_ADDRESS1(HtmlInputText COMP_CBEN_ADDRESS1) {
		this.COMP_CBEN_ADDRESS1 = COMP_CBEN_ADDRESS1;
	}

	public HtmlOutputLabel getCOMP_UI_M_BNF_DESC_LABEL() {
		return COMP_UI_M_BNF_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BNF_DESC() {
		return COMP_UI_M_BNF_DESC;
	}

	public void setCOMP_UI_M_BNF_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_BNF_DESC_LABEL) {
		this.COMP_UI_M_BNF_DESC_LABEL = COMP_UI_M_BNF_DESC_LABEL;
	}

	public void setCOMP_UI_M_BNF_DESC(HtmlInputText COMP_UI_M_BNF_DESC) {
		this.COMP_UI_M_BNF_DESC = COMP_UI_M_BNF_DESC;
	}

	public HtmlOutputLabel getCOMP_CBEN_ADDRESS2_LABEL() {
		return COMP_CBEN_ADDRESS2_LABEL;
	}

	public HtmlInputText getCOMP_CBEN_ADDRESS2() {
		return COMP_CBEN_ADDRESS2;
	}

	public void setCOMP_CBEN_ADDRESS2_LABEL(
			HtmlOutputLabel COMP_CBEN_ADDRESS2_LABEL) {
		this.COMP_CBEN_ADDRESS2_LABEL = COMP_CBEN_ADDRESS2_LABEL;
	}

	public void setCOMP_CBEN_ADDRESS2(HtmlInputText COMP_CBEN_ADDRESS2) {
		this.COMP_CBEN_ADDRESS2 = COMP_CBEN_ADDRESS2;
	}

	public HtmlOutputLabel getCOMP_UI_M_CBEN_RELATION_DESC_LABEL() {
		return COMP_UI_M_CBEN_RELATION_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CBEN_RELATION_DESC() {
		return COMP_UI_M_CBEN_RELATION_DESC;
	}

	public void setCOMP_UI_M_CBEN_RELATION_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_CBEN_RELATION_DESC_LABEL) {
		this.COMP_UI_M_CBEN_RELATION_DESC_LABEL = COMP_UI_M_CBEN_RELATION_DESC_LABEL;
	}

	public void setCOMP_UI_M_CBEN_RELATION_DESC(
			HtmlInputText COMP_UI_M_CBEN_RELATION_DESC) {
		this.COMP_UI_M_CBEN_RELATION_DESC = COMP_UI_M_CBEN_RELATION_DESC;
	}

	public HtmlOutputLabel getCOMP_CBEN_ADDRESS3_LABEL() {
		return COMP_CBEN_ADDRESS3_LABEL;
	}

	public HtmlInputText getCOMP_CBEN_ADDRESS3() {
		return COMP_CBEN_ADDRESS3;
	}

	public void setCOMP_CBEN_ADDRESS3_LABEL(
			HtmlOutputLabel COMP_CBEN_ADDRESS3_LABEL) {
		this.COMP_CBEN_ADDRESS3_LABEL = COMP_CBEN_ADDRESS3_LABEL;
	}

	public void setCOMP_CBEN_ADDRESS3(HtmlInputText COMP_CBEN_ADDRESS3) {
		this.COMP_CBEN_ADDRESS3 = COMP_CBEN_ADDRESS3;
	}

	public HtmlOutputLabel getCOMP_CBEN_STAT_CODE_LABEL() {
		return COMP_CBEN_STAT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CBEN_STAT_CODE() {
		return COMP_CBEN_STAT_CODE;
	}

	public void setCOMP_CBEN_STAT_CODE_LABEL(
			HtmlOutputLabel COMP_CBEN_STAT_CODE_LABEL) {
		this.COMP_CBEN_STAT_CODE_LABEL = COMP_CBEN_STAT_CODE_LABEL;
	}

	public void setCOMP_CBEN_STAT_CODE(HtmlInputText COMP_CBEN_STAT_CODE) {
		this.COMP_CBEN_STAT_CODE = COMP_CBEN_STAT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CBEN_STAT_CODE_DESC_LABEL() {
		return COMP_UI_M_CBEN_STAT_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CBEN_STAT_CODE_DESC() {
		return COMP_UI_M_CBEN_STAT_CODE_DESC;
	}

	public void setCOMP_UI_M_CBEN_STAT_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_CBEN_STAT_CODE_DESC_LABEL) {
		this.COMP_UI_M_CBEN_STAT_CODE_DESC_LABEL = COMP_UI_M_CBEN_STAT_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_CBEN_STAT_CODE_DESC(
			HtmlInputText COMP_UI_M_CBEN_STAT_CODE_DESC) {
		this.COMP_UI_M_CBEN_STAT_CODE_DESC = COMP_UI_M_CBEN_STAT_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_CBEN_POSTAL_CODE_LABEL() {
		return COMP_CBEN_POSTAL_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CBEN_POSTAL_CODE() {
		return COMP_CBEN_POSTAL_CODE;
	}

	public void setCOMP_CBEN_POSTAL_CODE_LABEL(
			HtmlOutputLabel COMP_CBEN_POSTAL_CODE_LABEL) {
		this.COMP_CBEN_POSTAL_CODE_LABEL = COMP_CBEN_POSTAL_CODE_LABEL;
	}

	public void setCOMP_CBEN_POSTAL_CODE(HtmlInputText COMP_CBEN_POSTAL_CODE) {
		this.COMP_CBEN_POSTAL_CODE = COMP_CBEN_POSTAL_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CBEN_POSTAL_CODE_DESC_LABEL() {
		return COMP_UI_M_CBEN_POSTAL_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CBEN_POSTAL_CODE_DESC() {
		return COMP_UI_M_CBEN_POSTAL_CODE_DESC;
	}

	public void setCOMP_UI_M_CBEN_POSTAL_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_CBEN_POSTAL_CODE_DESC_LABEL) {
		this.COMP_UI_M_CBEN_POSTAL_CODE_DESC_LABEL = COMP_UI_M_CBEN_POSTAL_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_CBEN_POSTAL_CODE_DESC(
			HtmlInputText COMP_UI_M_CBEN_POSTAL_CODE_DESC) {
		this.COMP_UI_M_CBEN_POSTAL_CODE_DESC = COMP_UI_M_CBEN_POSTAL_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_CBEN_CITY_CODE_LABEL() {
		return COMP_CBEN_CITY_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CBEN_CITY_CODE() {
		return COMP_CBEN_CITY_CODE;
	}

	public void setCOMP_CBEN_CITY_CODE_LABEL(
			HtmlOutputLabel COMP_CBEN_CITY_CODE_LABEL) {
		this.COMP_CBEN_CITY_CODE_LABEL = COMP_CBEN_CITY_CODE_LABEL;
	}

	public void setCOMP_CBEN_CITY_CODE(HtmlInputText COMP_CBEN_CITY_CODE) {
		this.COMP_CBEN_CITY_CODE = COMP_CBEN_CITY_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CBEN_CITY_DESC_LABEL() {
		return COMP_UI_M_CBEN_CITY_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CBEN_CITY_DESC() {
		return COMP_UI_M_CBEN_CITY_DESC;
	}

	public void setCOMP_UI_M_CBEN_CITY_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_CBEN_CITY_DESC_LABEL) {
		this.COMP_UI_M_CBEN_CITY_DESC_LABEL = COMP_UI_M_CBEN_CITY_DESC_LABEL;
	}

	public void setCOMP_UI_M_CBEN_CITY_DESC(
			HtmlInputText COMP_UI_M_CBEN_CITY_DESC) {
		this.COMP_UI_M_CBEN_CITY_DESC = COMP_UI_M_CBEN_CITY_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_REL_CODE() {
		return COMP_UI_M_BUT_LOV_REL_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_REL_CODE(
			HtmlCommandButton COMP_UI_M_BUT_LOV_REL_CODE) {
		this.COMP_UI_M_BUT_LOV_REL_CODE = COMP_UI_M_BUT_LOV_REL_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_BEN_TYPE() {
		return COMP_UI_M_BUT_LOV_BEN_TYPE;
	}

	public void setCOMP_UI_M_BUT_LOV_BEN_TYPE(
			HtmlCommandButton COMP_UI_M_BUT_LOV_BEN_TYPE) {
		this.COMP_UI_M_BUT_LOV_BEN_TYPE = COMP_UI_M_BUT_LOV_BEN_TYPE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_STAT_CODE() {
		return COMP_UI_M_BUT_LOV_STAT_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_STAT_CODE(
			HtmlCommandButton COMP_UI_M_BUT_LOV_STAT_CODE) {
		this.COMP_UI_M_BUT_LOV_STAT_CODE = COMP_UI_M_BUT_LOV_STAT_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_POSTAL_CODE() {
		return COMP_UI_M_BUT_LOV_POSTAL_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_POSTAL_CODE(
			HtmlCommandButton COMP_UI_M_BUT_LOV_POSTAL_CODE) {
		this.COMP_UI_M_BUT_LOV_POSTAL_CODE = COMP_UI_M_BUT_LOV_POSTAL_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_CITY_CODE() {
		return COMP_UI_M_BUT_LOV_CITY_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_CITY_CODE(
			HtmlCommandButton COMP_UI_M_BUT_LOV_CITY_CODE) {
		this.COMP_UI_M_BUT_LOV_CITY_CODE = COMP_UI_M_BUT_LOV_CITY_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CBEN_BANK_CODE_LOV() {
		return COMP_UI_M_BUT_CBEN_BANK_CODE_LOV;
	}

	public void setCOMP_UI_M_BUT_CBEN_BANK_CODE_LOV(
			HtmlCommandButton COMP_UI_M_BUT_CBEN_BANK_CODE_LOV) {
		this.COMP_UI_M_BUT_CBEN_BANK_CODE_LOV = COMP_UI_M_BUT_CBEN_BANK_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BENF_DTLS_MAIN() {
		return COMP_UI_M_BUT_BENF_DTLS_MAIN;
	}

	public void setCOMP_UI_M_BUT_BENF_DTLS_MAIN(
			HtmlCommandButton COMP_UI_M_BUT_BENF_DTLS_MAIN) {
		this.COMP_UI_M_BUT_BENF_DTLS_MAIN = COMP_UI_M_BUT_BENF_DTLS_MAIN;
	}

	public PT_IL_CLAIM_BENEFICIARY getPT_IL_CLAIM_BENEFICIARY_BEAN() {
		return PT_IL_CLAIM_BENEFICIARY_BEAN;
	}

	public void setPT_IL_CLAIM_BENEFICIARY_BEAN(
			PT_IL_CLAIM_BENEFICIARY PT_IL_CLAIM_BENEFICIARY_BEAN) {
		this.PT_IL_CLAIM_BENEFICIARY_BEAN = PT_IL_CLAIM_BENEFICIARY_BEAN;
	}

	public void cbenBnfNameValidator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_CLAIM_BENEFICIARY_BEAN().setCBEN_BNF_NAME((String) value);
			helper.cbenBnfNameWhenValidateItem(compositeAction);
		} catch (Exception e) {
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

	public void validateCbenBnfName(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		// gridtabListener();
	}

	public void cbenRelationCodeValidator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.cbenRelationCodeWhenValidateItem(compositeAction);
		} catch (Exception e) {
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

	public void validateCbenRelationCode(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		String cbenRelationCode = (String) input.getSubmittedValue();
		System.out.println("cbenRelationCode: " + cbenRelationCode);

		try {
			if (cbenRelationCode == null || "".equals(cbenRelationCode)) {
				PT_IL_CLAIM_BENEFICIARY_BEAN.setUI_M_CBEN_RELATION_DESC("");
				getCOMP_UI_M_CBEN_RELATION_DESC().setSubmittedValue("");
				System.out.println("RELATION_dESC: "
						+ PT_IL_CLAIM_BENEFICIARY_BEAN
								.getUI_M_CBEN_RELATION_DESC());
			} else {
				PT_IL_CLAIM_BENEFICIARY_BEAN
						.setCBEN_RELATION_CODE(cbenRelationCode);
				System.out.println("rELATION_dESC1: "
						+ PT_IL_CLAIM_BENEFICIARY_BEAN
								.getUI_M_CBEN_RELATION_DESC());
			}
			ErrorHelpUtil.validate(input, getErrorMap());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void cbenBankCodeValidator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper
					.cbenBankCodeWhenValidateItem((String) value,
							compositeAction);
		} catch (Exception e) {
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

	public void validateCbenBankCode(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		String cbenBankCode = (String) input.getSubmittedValue();
		PT_IL_CLAIM_BENEFICIARY_BEAN.setCBEN_BANK_CODE(cbenBankCode);
		try {
			COMP_UI_M_CBEN_BANK_CODE_DESC
					.setSubmittedValue(PT_IL_CLAIM_BENEFICIARY_BEAN
							.getUI_M_CBEN_BANK_CODE_DESC());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/*public void cbenBnfTypeValidator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {*/
	
	/*changed the validator by raja on 10-03-2017 for ssp-id ZBILQC-1721754 */
	public void cbenBnfTypeValidator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			/*added by gopi for hands on feed back points,serial no 12 in zb on 10/02/17*/
			getErrorMap().clear();
			getWarningMap().clear();
			/*added by raja on 10-03-2017 for ssp-id ZBILQC-1721754 */
			/*UIInput input = (UIInput) actionEvent.getComponent().getParent();
			String cbenBnfType = (String) input.getSubmittedValue();*/
			System.out.println("cbenBnfType: " + value.toString());
			/*if(PT_IL_CLAIM_BENEFICIARY_BEAN.getCBEN_BNF_TYPE()!=null){
				if(!PT_IL_CLAIM_BENEFICIARY_BEAN.getCBEN_BNF_TYPE().equals(COMP_CBEN_BNF_TYPE.getSubmittedValue().toString())){
					PT_IL_CLAIM_BENEFICIARY_BEAN.setCBEN_RELATION_CODE(null);
					PT_IL_CLAIM_BENEFICIARY_BEAN.setUI_M_CBEN_RELATION_DESC(null);
					COMP_CBEN_RELATION_CODE.resetValue();
					COMP_UI_M_CBEN_RELATION_DESC.resetValue();
				}
			}*/

			PT_IL_CLAIM_BENEFICIARY_BEAN.setCBEN_BNF_TYPE(value.toString());
			/*end*/
			helper.cbenBnfTypeWhenValidateItem(value, compositeAction);
			/*added by gopi for hands on feed back points,serial no 12 in zb on 10/02/17*/
			String typefieldvalue=PT_IL_CLAIM_BENEFICIARY_BEAN.getCBEN_BNF_TYPE();
			System.out.println("typefieldvalue        "+typefieldvalue);
			typeValidation(PT_IL_CLAIM_BENEFICIARY_BEAN,typefieldvalue);
			/*END*/

			/*Added by saritha on 12-04-2018 for KIC Claim Beneficiary Screen Issues*/ 

			int benfField = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_BENF_FLDS")).intValue();
			System.out.println("benfField ====>>" +benfField);

			if(benfField == 0)
			{
				if(PT_IL_CLAIM_BENEFICIARY_BEAN.getCBEN_BNF_TYPE() != null && PT_IL_CLAIM_BENEFICIARY_BEAN.getCBEN_BNF_TYPE().equalsIgnoreCase("B"))
				{

					COMP_CBEN_BANK_CODE.setRequired(true);
					COMP_CBEN_DIVN_CODE.setRequired(true);
					COMP_CBEN_ACCT_CODE.setRequired(true);
					COMP_CBEN_FLEX_02.setRequired(true);
					COMP_CBEN_GUARDIAN_NAME.setRequired(true);
					COMP_CBEN_FLEX_01.setRequired(true);
					COMP_CBEN_PERC.setRequired(true);
					COMP_CBEN_REF_ID1.setRequired(false);
					COMP_PBEN_DOB.setRequired(false);
					COMP_CBEN_AGE.setRequired(false);
					COMP_CBEN_RELATION_CODE.setRequired(false);
					COMP_CBEN_BNF_NAME.setRequired(false);
					COMP_PBEN_DOB.setDisabled(false);
					COMP_CBEN_AGE.setDisabled(false);
					COMP_CBEN_GUARDIAN_NAME.setDisabled(false);
					COMP_CBEN_BNF_CODE.setRendered(false);
					COMP_CBEN_BNF_NAME.setDisabled(false);

				}else if(PT_IL_CLAIM_BENEFICIARY_BEAN.getCBEN_BNF_TYPE() != null && PT_IL_CLAIM_BENEFICIARY_BEAN.getCBEN_BNF_TYPE().equalsIgnoreCase("S"))

				{

					COMP_CBEN_REF_ID1.setRequired(false);
					COMP_PBEN_DOB.setRequired(false);
					COMP_CBEN_AGE.setRequired(false);
					COMP_CBEN_FLEX_01.setRequired(false);
					COMP_CBEN_FLEX_02.setRequired(false);
					COMP_PBEN_DOB.setDisabled(false);
					COMP_CBEN_RELATION_CODE.setRequired(true);
					COMP_CBEN_GUARDIAN_NAME.setRequired(true);
					COMP_CBEN_PERC.setRequired(true);
					COMP_PBEN_DOB.setDisabled(false);
					COMP_CBEN_AGE.setDisabled(false);
					COMP_CBEN_GUARDIAN_NAME.setDisabled(false);
					COMP_CBEN_BNF_CODE.setRendered(false);
					COMP_CBEN_BNF_NAME.setDisabled(false);

				}else{

					COMP_CBEN_REF_ID1.setRequired(false);
					COMP_PBEN_DOB.setRequired(false);
					COMP_CBEN_CATG_CODE.setRequired(false);
					COMP_CBEN_AGE.setRequired(false);
					COMP_CBEN_RELATION_CODE.setRequired(false);
					COMP_CBEN_FLEX_01.setRequired(false);
					COMP_CBEN_FLEX_02.setRequired(false);
					COMP_PBEN_DOB.setDisabled(false);
					getCOMP_CBEN_GUARDIAN_NAME().setRequired(false);
					COMP_CBEN_AGE.setDisabled(false);
					COMP_CBEN_GUARDIAN_NAME.setDisabled(false);
					COMP_CBEN_PERC.setRequired(true);
					COMP_CBEN_BNF_CODE.setRendered(false);
					COMP_CBEN_BNF_NAME.setDisabled(false);

				}

			}
			/*End*/

			COMP_UI_M_BNF_DESC.resetValue();
			COMP_CBEN_PERC.resetValue();
			resetAllComponent();

			/*end*/
		} catch (Exception e) {
			e.printStackTrace();
			//getErrorMap().put("current", e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} /*finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(),component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}*/
	}

	public void validateCbenBnfType(ActionEvent event) {
		/*UIInput input = (UIInput) event.getComponent().getParent();
		String cbenBnfType = (String) input.getSubmittedValue();
		PT_IL_CLAIM_BENEFICIARY_BEAN.setCBEN_BNF_TYPE(cbenBnfType);
		input.validate(FacesContext.getCurrentInstance());*/

		UIInput input = (UIInput) event.getComponent().getParent();
		String cbenBnfType = (String) input.getSubmittedValue();
		System.out.println("cbenBnfType: " + cbenBnfType);

		try {
			if (cbenBnfType == null || "".equals(cbenBnfType)) {
				PT_IL_CLAIM_BENEFICIARY_BEAN.setUI_M_BNF_DESC("");
				getCOMP_UI_M_BNF_DESC().setSubmittedValue("");
				System.out.println("BENEFICIARY_dESC: "
						+ PT_IL_CLAIM_BENEFICIARY_BEAN.getUI_M_BNF_DESC());
			} else {
				PT_IL_CLAIM_BENEFICIARY_BEAN.setCBEN_BNF_TYPE(cbenBnfType);

				System.out.println("BENEFICIARY_dESC1: "
						+ PT_IL_CLAIM_BENEFICIARY_BEAN.getUI_M_BNF_DESC());
			}
			ErrorHelpUtil.validate(input, getErrorMap());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void cbenPercValidator(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		PT_IL_CLAIM_BENEFICIARY_BEAN.setCBEN_PERC((Double) value);

		try {
			//helper.checkBenfPer(compositeAction);
			helper.cbenPercWhenValidateItem(compositeAction);
			COMP_CBEN_FC_PAID_AMT.resetValue();
			COMP_CBEN_LC_PAID_AMT.resetValue();

		} catch (Exception e) {
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

	public String validateBeneficiaryPerc() {
		String returnform=null;
		try {
			if(PT_IL_CLAIM_BENEFICIARY_LIST.size()>0)
			{
			helper.validateBeneficiaryPerc(this);
			}
			/* added by raja on 05-08-2017 for ZBILQC-1728228 */
			/*if(CommonUtils.nvl(CommonUtils.getGlobalVariable("M_FORM"), "FALSE").equalsIgnoreCase("CLAIMPAID"))
			{
				
			}*/
			if(CommonUtils.nvl(compositeAction.getReturnString(),"claimPaid").equalsIgnoreCase("claimToBePaid"))
			{
			returnform= "claimToBePaid";
			}
			else
			{
				returnform= "claimPaid";
			}
			
			/*end*/
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			
		}
		return returnform;
		
	}
	
	public void validateCbenPerc(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		input.validate(FacesContext.getCurrentInstance());
	}

	public List<PT_IL_CLAIM_BENEFICIARY> bankCodeLOV(Object value) {
		PT_IL_CLAIM_BENEFICIARY_HELPER helper = new PT_IL_CLAIM_BENEFICIARY_HELPER();
		List<PT_IL_CLAIM_BENEFICIARY> bankCodeList = null;
		try {
			bankCodeList = helper.bankCodeLOV((String) value);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
		}
		return bankCodeList;
	}

	public List<PT_IL_CLAIM_BENEFICIARY> bnfTypeLOV(Object value) {
		PT_IL_CLAIM_BENEFICIARY_HELPER helper = new PT_IL_CLAIM_BENEFICIARY_HELPER();
		List<PT_IL_CLAIM_BENEFICIARY> lovList = null;
		try {
			lovList = helper.bnfTypeLOV((String) value);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		return lovList;
	}

	public List<PT_IL_CLAIM_BENEFICIARY> cityCodeLOV(Object value) {
		PT_IL_CLAIM_BENEFICIARY_HELPER helper = new PT_IL_CLAIM_BENEFICIARY_HELPER();
		List<PT_IL_CLAIM_BENEFICIARY> lovList = null;
		try {
			lovList = helper.cityCodeLOV((String) value);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		return lovList;
	}

	public List<PT_IL_CLAIM_BENEFICIARY> postalCodeLOV(Object value) {
		PT_IL_CLAIM_BENEFICIARY_HELPER helper = new PT_IL_CLAIM_BENEFICIARY_HELPER();
		List<PT_IL_CLAIM_BENEFICIARY> lovList = null;
		try {
			lovList = helper.postalCodeLOV((String) value);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		return lovList;
	}
	/*commented by raja on 10-03-2017 for ssp-id ZBILQC-1721754 */
	/*public List<PT_IL_CLAIM_BENEFICIARY> relationCodeLOV(Object value) {
		PT_IL_CLAIM_BENEFICIARY_HELPER helper = new PT_IL_CLAIM_BENEFICIARY_HELPER();
		List<PT_IL_CLAIM_BENEFICIARY> lovList = null;
		try {
			lovList = helper.relationCodeLOV((String) value);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		return lovList;
	}*/
	/*end*/
	
	/*added by raja on 10-03-2017 for ssp-id ZBILQC-1721754 */
	public ArrayList<LovBean> relationCodeLOV(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();
		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_BENEFICIARY";
		String fieldName = "PBEN_RELATION_CODE";
		Object param1 = "ILBENFREL";

		try {

			/*Added by Raja.Code Edited for Filter Beneficiery Relation on 2/3/2016 (Start)*/

			Object param2;
			String value=compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getPT_IL_CLAIM_BENEFICIARY_BEAN().getCBEN_BNF_TYPE();
			/* changed the if condition by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
			if(value.equals("A") || value.equalsIgnoreCase("S"))
				param2="2";			
			else
				param2="1";
			System.out.println("param2      "+param2);
			System.out.println("value      "+value);
			/*Added by Raja.Code Edited for Filter Beneficiery Relation on 2/3/2016 (End)*/

			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			/*lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
					null, null, null, currentValue);*/
			/*Added by Raja.Code Edited for Filter Beneficiery Relation on 2/3/2016 (Start)*/
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, param2,
					null, null, null, currentValue);
			/*Added by Raja.Code Edited for Filter Beneficiery Relation on 2/3/2016 (End)*/

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
/*end*/

	public List<PT_IL_CLAIM_BENEFICIARY> statCodeLOV(Object value) {
		PT_IL_CLAIM_BENEFICIARY_HELPER helper = new PT_IL_CLAIM_BENEFICIARY_HELPER();
		List<PT_IL_CLAIM_BENEFICIARY> lovList = null;
		try {
			lovList = helper.statCodeLOV((String) value);
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			setErrorMessages(e.getMessage());
		}
		return lovList;
	}

	public void cityCodeValidation(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		String cityCode = (String) input.getSubmittedValue();

		PT_IL_CLAIM_BENEFICIARY_BEAN.setCBEN_CITY_CODE(cityCode);
		COMP_UI_M_CBEN_CITY_DESC.setSubmittedValue(PT_IL_CLAIM_BENEFICIARY_BEAN
				.getUI_M_CBEN_CITY_DESC());
		try {
			helper.cbenCityCodeWhenValidateItem(compositeAction);
			// lastColumnListener();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void postalCodeValidation(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		String postalCode = (String) input.getSubmittedValue();
		PT_IL_CLAIM_BENEFICIARY_BEAN.setCBEN_POSTAL_CODE(postalCode);
		COMP_UI_M_CBEN_POSTAL_CODE_DESC
				.setSubmittedValue(PT_IL_CLAIM_BENEFICIARY_BEAN
						.getUI_M_CBEN_POSTAL_CODE_DESC());
		PT_IL_CLAIM_BENEFICIARY_HELPER helper = new PT_IL_CLAIM_BENEFICIARY_HELPER();
		try {
			helper.cbenPostalCodeWhenValidateItem(compositeAction);
			// gridtabListener();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void statCodeValidation(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		String statCode = (String) input.getSubmittedValue();

		PT_IL_CLAIM_BENEFICIARY_BEAN.setCBEN_STAT_CODE(statCode);
		COMP_UI_M_CBEN_STAT_CODE_DESC
				.setSubmittedValue(PT_IL_CLAIM_BENEFICIARY_BEAN
						.getUI_M_CBEN_STAT_CODE_DESC());
		try {
			helper.cbenStatCodeWhenValidateItem(compositeAction);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		// gridtabListener();
	}

	public void ADD_NEW_ROW() {
		setPT_IL_CLAIM_BENEFICIARY_BEAN(new PT_IL_CLAIM_BENEFICIARY());
		PT_IL_CLAIM_BENEFICIARY_HELPER helper = new PT_IL_CLAIM_BENEFICIARY_HELPER();
		if (PT_IL_CLAIM_BENEFICIARY_LIST != null)
			PT_IL_CLAIM_BENEFICIARY_LIST.add(helper
					.whenCreateRecord(compositeAction));
		else {
			PT_IL_CLAIM_BENEFICIARY_LIST = new ArrayList<PT_IL_CLAIM_BENEFICIARY>();
			PT_IL_CLAIM_BENEFICIARY_LIST.add(helper
					.whenCreateRecord(compositeAction));
		}
	}

	public void REMOVE_ROW() {
		for (PT_IL_CLAIM_BENEFICIARY beneficiaryBean : getPT_IL_CLAIM_BENEFICIARY_LIST()) {
			if (beneficiaryBean.isSelected()) {
				CRUDHandler handler = new CRUDHandler();
				try {
					handler.executeDelete(beneficiaryBean, CommonUtils
							.getConnection());
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		PT_IL_CLAIM_BENEFICIARY_LIST = new ArrayList<PT_IL_CLAIM_BENEFICIARY>();
		PT_IL_CLAIM_BENEFICIARY_HELPER helper = new PT_IL_CLAIM_BENEFICIARY_HELPER();
		//helper.executeQuery(compositeAction);
		getErrorMap().put("current", "Row(s) deleted!");
		setErrorMessages("Row(s) deleted!");
	}

	public void onLoad(PhaseEvent event) {
		if (isBlockFlag()) {
			try {
				
				/*Added by Raja on 08.03.2017*/ 
				getErrorMap().clear();
				getWarningMap().clear();
				helper.executeselectstatement(compositeAction);
				if(PT_IL_CLAIM_BENEFICIARY_BEAN.getROWID()==null){
					helper.whenCreateRecord(compositeAction);
				}
				else
				{
					typeValidation(PT_IL_CLAIM_BENEFICIARY_BEAN,PT_IL_CLAIM_BENEFICIARY_BEAN.getCBEN_BNF_TYPE());
				}
				/*End*/
			//	helper.whenNewBlockInstance(compositeAction);
				/*added by gopi for hands on feed back points,serial no 12 in zb on 03/02/17*/
				//end


				/*Added by saritha on 12-04-2018 for KIC Claim Beneficiary Screen Issues*/ 
				int benfField = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_BENF_FLDS")).intValue();
				System.out.println("benfField ====>>" +benfField);
				
				if(benfField == 0){
					
					COMP_CBEN_CATG_CODE.setRequired(false);
					COMP_CBEN_AGE.setRequired(false);
					COMP_CBEN_BNF_NAME.setDisabled(false);	
					COMP_PBEN_DOB.setDisabled(false);
					COMP_CBEN_CATG_CODE.setDisabled(false);
					COMP_CBEN_AGE.setDisabled(false);
					COMP_CBEN_GUARDIAN_NAME.setDisabled(false);
					COMP_CBEN_BNF_CODE.setRendered(false);
					COMP_PBEN_NAME_IMG.setRendered(false);

					if(PT_IL_CLAIM_BENEFICIARY_BEAN.getCBEN_BNF_TYPE() != null && PT_IL_CLAIM_BENEFICIARY_BEAN.getCBEN_BNF_TYPE().equalsIgnoreCase("B"))
					{

						COMP_CBEN_BANK_CODE.setRequired(true);
						COMP_CBEN_DIVN_CODE.setRequired(true);
						COMP_CBEN_ACCT_CODE.setRequired(true);
						COMP_CBEN_FLEX_02.setRequired(true);
						COMP_CBEN_GUARDIAN_NAME.setRequired(true);
						COMP_CBEN_FLEX_01.setRequired(true);
						COMP_CBEN_PERC.setRequired(true);
						COMP_CBEN_REF_ID1.setRequired(false);
						COMP_PBEN_DOB.setRequired(false);
						COMP_CBEN_AGE.setRequired(false);
						COMP_CBEN_CATG_CODE.setRequired(false);
						COMP_CBEN_RELATION_CODE.setRequired(false);
						COMP_CBEN_BNF_CODE.setRequired(false);
						COMP_PBEN_DOB.setDisabled(false);
						COMP_CBEN_AGE.setDisabled(false);
						COMP_CBEN_BNF_NAME.setDisabled(false);
						COMP_CBEN_GUARDIAN_NAME.setDisabled(false);
						COMP_CBEN_BNF_CODE.setRendered(false);
						COMP_PBEN_NAME_IMG.setRendered(false);

					}else if(PT_IL_CLAIM_BENEFICIARY_BEAN.getCBEN_BNF_TYPE() != null && PT_IL_CLAIM_BENEFICIARY_BEAN.getCBEN_BNF_TYPE().equalsIgnoreCase("S"))

					{

						COMP_CBEN_REF_ID1.setRequired(false);
						COMP_PBEN_DOB.setRequired(false);
						COMP_CBEN_CATG_CODE.setRequired(false);
						COMP_CBEN_AGE.setRequired(false);
						COMP_CBEN_BNF_NAME.setDisabled(false);
						COMP_CBEN_FLEX_01.setRequired(false);
						COMP_CBEN_FLEX_02.setRequired(false);
						COMP_PBEN_DOB.setDisabled(false);
						COMP_CBEN_RELATION_CODE.setRequired(true);
						COMP_CBEN_GUARDIAN_NAME.setRequired(true);
						COMP_CBEN_PERC.setRequired(true);
						COMP_PBEN_DOB.setDisabled(false);
						COMP_CBEN_AGE.setDisabled(false);
						COMP_CBEN_BNF_CODE.setDisabled(false);
						COMP_CBEN_GUARDIAN_NAME.setDisabled(false);
						COMP_CBEN_BNF_CODE.setRendered(false);
						COMP_PBEN_NAME_IMG.setRendered(false);
						
					}else{

						COMP_CBEN_REF_ID1.setRequired(false);
						COMP_PBEN_DOB.setRequired(false);
						COMP_CBEN_BNF_NAME.setDisabled(false);
						COMP_CBEN_AGE.setRequired(false);
						COMP_CBEN_RELATION_CODE.setRequired(false);
						COMP_CBEN_BNF_CODE.setRequired(false);
						COMP_CBEN_FLEX_01.setRequired(false);
						COMP_CBEN_FLEX_02.setRequired(false);
						COMP_PBEN_DOB.setDisabled(false);
						getCOMP_CBEN_GUARDIAN_NAME().setRequired(false);
						COMP_CBEN_PERC.setRequired(true);
						COMP_CBEN_AGE.setDisabled(false);
						COMP_CBEN_BNF_CODE.setDisabled(false);
						COMP_CBEN_GUARDIAN_NAME.setDisabled(false);
						COMP_CBEN_BNF_CODE.setRendered(false);
						COMP_PBEN_NAME_IMG.setRendered(false);
			
					}

				}
				
				/*End*/
				
				resetAllComponent();
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("onLoad", e.getMessage());
			}
			setBlockFlag(false);
		}
		/*Added by Ameen on 30-11-2017 for ZBLIFE-1458892*/
		if("B".equalsIgnoreCase(compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_PAID_TO())){
			COMP_CBEN_BANK_CODE.setRequired(true);
			COMP_CBEN_DIVN_CODE.setRequired(true);
			COMP_CBEN_FLEX_01.setRequired(true);
			COMP_CBEN_FLEX_02.setRequired(true);
			/*Commentted by saritha on 26-12-2017 to avoid enabling this fields in paid screen*/
			/*COMP_CBEN_BANK_CODE.setDisabled(false);
			COMP_CBEN_DIVN_CODE.setDisabled(false);*/
		}
		/*End*/
		
		/*if((compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getPT_IL_CLAIM_PAID_BEAN().getCP_APPR_FLAG() != null) &&
		!(compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getPT_IL_CLAIM_PAID_BEAN().getCP_APPR_FLAG().isEmpty())){
		if("A".equalsIgnoreCase(compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getPT_IL_CLAIM_PAID_BEAN().getCP_APPR_FLAG()) || 
				"R".equalsIgnoreCase(compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getPT_IL_CLAIM_PAID_BEAN().getCP_APPR_FLAG())){
			disableAllComponent(true);
		}
		if("A".equalsIgnoreCase(compositeAction.getPILT007_PT_IL_CLAIM_PAID_1_ACTION().getPT_IL_CLAIM_PAID_1_BEAN().getCP_APPR_FLAG_1()) || 
				"R".equalsIgnoreCase(compositeAction.getPILT007_PT_IL_CLAIM_PAID_1_ACTION().getPT_IL_CLAIM_PAID_1_BEAN().getCP_APPR_FLAG_1())){
			disableAllComponent(true);
		}
		else{
			disableAllComponent(false);
		}
		}*/
		/*commented by raja on 10-03-2017 for ssp-id ZBILQC-1721754 */
		//disableAllComponent(true);
		
		
		/*Added by saritha on 12-04-2018 for KIC Claim Beneficiary Screen Issues*/ 
		try{
			
		int clmBenficiary = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_BENF_FLDS")).intValue();
		System.out.println("clmBenficiary ====>>" +clmBenficiary);
		String Confirmflag = chkFreezConfirmflag(compositeAction);
		
		if(Confirmflag!=null && "Y".equals(Confirmflag)){
		
		if(clmBenficiary == 0){
			System.out.println("SYSTEM PARAM. 1 out blockflag ..");
			
			COMP_CBEN_REF_ID1_NEW.setRendered(true);
			COMP_CBEN_REF_ID1.setRendered(false);
			getCOMP_CBEN_GUARDIAN_NAME().setRequired(false);
			COMP_PBEN_NAME_IMG.setRendered(false);
		
		}else{
			COMP_CBEN_REF_ID1.setRendered(true);
			COMP_PBEN_DOB.setDisabled(true);
			COMP_CBEN_REF_ID1_NEW.setRendered(false);
			COMP_PBEN_NAME_IMG.setRendered(true);
		}
		}else
		{
			if(clmBenficiary == 0){
				System.out.println("SYSTEM PARAM. 1 out blockflag ..");
				
				COMP_CBEN_REF_ID1_NEW.setRendered(true);
				COMP_CBEN_REF_ID1.setRendered(false);
				COMP_PBEN_NAME_IMG.setRendered(false);

			}
		}
		
		/*End*/
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void commit(ActionEvent event) {
		Connection connection = null;
		CommonUtils.clearMaps(this);
		try {
			connection = CommonUtils.getConnection();
			helper.validateBeneficiaryPerc(this);
			connection.commit();
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					"postRecord",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public void REF1(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		String ref1 = (String) input.getSubmittedValue();
		PT_IL_CLAIM_BENEFICIARY_BEAN.setCBEN_REF_ID1(ref1);
	}

	public void REF2(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		String ref2 = (String) input.getSubmittedValue();
		PT_IL_CLAIM_BENEFICIARY_BEAN.setCBEN_REF_ID2(ref2);
	}

	public void validateFcPaidAmt(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		input.validate(FacesContext.getCurrentInstance());
	}

	public void validatorFcPaidAmt(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		Double fcPaidAmt = (Double) value;
		try {
			helper.cbenFcPaidAmtWhenValidateItem(fcPaidAmt, compositeAction);
		} catch (Exception e) {
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

	public void validateLcPaidAmt(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		input.validate(FacesContext.getCurrentInstance());
	}

	public void validatorLcPaidAmt(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		Double lcPaidAmt = (Double) value;
		try {
			helper.cbenLcPaidAmtWhenValidateItem(compositeAction, lcPaidAmt);
		} catch (Exception e) {
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
	
	/*added by raja on 10-03-2017 for ssp-id ZBILQC-1721754 */

	public void validateCBEN_GUARDIAN_NAME(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		String guardian_name = (String) value;
		try {
			PT_IL_CLAIM_BENEFICIARY_BEAN.setCBEN_GUARDIAN_NAME(guardian_name);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}
	
	
	public void validateCBEN_ACCT_CODE(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		String acc_code = (String) value;
		try {
			PT_IL_CLAIM_BENEFICIARY_BEAN.setCBEN_ACCT_CODE(acc_code);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}
	
	
	public void validateCBEN_DIVN_CODE(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		String divi_code = (String) value;
		try {
			PT_IL_CLAIM_BENEFICIARY_BEAN.setCBEN_DIVN_CODE(divi_code);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}
	
	
	/*end*/
	
	public void getDetails() {
		try {
			resetSelectedRow();
			if (PT_IL_CLAIM_BENEFICIARY_LIST.size() != 0) {
				PT_IL_CLAIM_BENEFICIARY_BEAN = (PT_IL_CLAIM_BENEFICIARY) PT_IL_CLAIM_BENEFICIARY_DATATABLE
						.getRowData();
			}
			resetAllComponent();
			typeValidation(PT_IL_CLAIM_BENEFICIARY_BEAN,PT_IL_CLAIM_BENEFICIARY_BEAN.getCBEN_BNF_TYPE());
			PT_IL_CLAIM_BENEFICIARY_BEAN.setRowSelected(true);
			
			/*commented by raja on 10-03-2017 for ssp-id ZBILQC-1721754 */
			//helper.postQuery(PT_IL_CLAIM_BENEFICIARY_BEAN, compositeAction);
			/*end*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void resetSelectedRow() {
		Iterator<PT_IL_CLAIM_BENEFICIARY> iterator = PT_IL_CLAIM_BENEFICIARY_LIST
				.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void resetAllComponent() {
		COMP_CBEN_BNF_NAME.resetValue();
		COMP_CBEN_REF_ID1.resetValue();
		COMP_CBEN_REF_ID2.resetValue();
		COMP_CBEN_RELATION_CODE.resetValue();
		COMP_UI_M_CBEN_RELATION_DESC.resetValue();
		COMP_CBEN_BNF_TYPE.resetValue();
		COMP_CBEN_PERC.resetValue();
		COMP_CBEN_FC_PAID_AMT.resetValue();
		COMP_CBEN_LC_PAID_AMT.resetValue();
		COMP_CBEN_BANK_CODE.resetValue();
		COMP_UI_M_CBEN_BANK_CODE_DESC.resetValue();
		COMP_CBEN_ACCT_CODE.resetValue();
		COMP_CBEN_ADDRESS1.resetValue();
		COMP_CBEN_ADDRESS2.resetValue();
		COMP_CBEN_ADDRESS3.resetValue();
		COMP_CBEN_STAT_CODE.resetValue();
		COMP_UI_M_CBEN_STAT_CODE_DESC.resetValue();
		COMP_CBEN_POSTAL_CODE.resetValue();
		COMP_UI_M_CBEN_POSTAL_CODE_DESC.resetValue();
		COMP_CBEN_CITY_CODE.resetValue();
		COMP_UI_M_CBEN_CITY_DESC.resetValue();
		/*added by gopi for hands on feed back points,serial no 12 in zb on 02/02/17*/
		COMP_PBEN_SR_NO.resetValue();
		COMP_PBEN_DOB.resetValue();
		COMP_CBEN_BNF_CODE.resetValue();
		
		/*added by raja on 10-03-2017 for ssp-id ZBILQC-1721754 */
		COMP_CBEN_CATG_CODE.resetValue();
		COMP_CBEN_DIVN_CODE.resetValue();
		/*end*/
		/*Added by Ameen on 08-12-2017 for ZBLIFE-1458892*/
	  	COMP_CBEN_FLEX_01.resetValue();
		COMP_CBEN_FLEX_02.resetValue();
		COMP_CBEN_FLEX_03.resetValue();
		COMP_CBEN_FLEX_04.resetValue();
		/*End*/
		
		/*Added by saritha on 12-04-2018 for KIC Claim Beneficiary Screen Issues*/ 
		COMP_CBEN_REF_ID1_NEW.resetValue();
		COMP_CBEN_GUARDIAN_NAME.resetValue();
		COMP_CBEN_AGE.resetValue();
		COMP_CBEN_REMARKS.resetValue();
		/*End*/
	}

	/**
	 * Disables all components in PT_IL_CLAIM_BENEFICIARY_ACTION
	 */
	public void disableAllComponent(boolean disabled) {
		// Disabling HtmlInputText
		COMP_CBEN_BNF_NAME.setDisabled(disabled);
		/*commented by gopi for hands on feed back points,serial no 12 in zb on 02/02/17*/
		//COMP_CBEN_REF_ID1.setDisabled(disabled);
		//COMP_CBEN_RELATION_CODE.setDisabled(disabled);
		//COMP_CBEN_BNF_TYPE.setDisabled(disabled);
		//COMP_CBEN_PERC.setDisabled(disabled);
		//COMP_CBEN_ACCT_CODE.setDisabled(disabled);
		//COMP_CBEN_ADDRESS1.setDisabled(disabled);
		//COMP_CBEN_ADDRESS2.setDisabled(disabled);
		//COMP_CBEN_ADDRESS3.setDisabled(disabled);
		/*end*/
		COMP_CBEN_REF_ID2.setDisabled(disabled);
	
		COMP_CBEN_FC_PAID_AMT.setDisabled(disabled);
		COMP_CBEN_LC_PAID_AMT.setDisabled(disabled);
		/*commented by raja on 10-03-2017 for ssp-id ZBILQC-1721754 */
		//COMP_CBEN_BANK_CODE.setDisabled(disabled);
		//COMP_UI_M_CBEN_BANK_CODE_DESC.setDisabled(disabled);
		/*end*/
		//COMP_UI_M_BNF_DESC.setDisabled(disabled);
	
		//COMP_UI_M_CBEN_RELATION_DESC.setDisabled(disabled);
	
		COMP_CBEN_STAT_CODE.setDisabled(disabled);
		COMP_UI_M_CBEN_STAT_CODE_DESC.setDisabled(disabled);
		COMP_CBEN_POSTAL_CODE.setDisabled(disabled);
		COMP_UI_M_CBEN_POSTAL_CODE_DESC.setDisabled(disabled);
		COMP_CBEN_CITY_CODE.setDisabled(disabled);
		COMP_UI_M_CBEN_CITY_DESC.setDisabled(disabled);
		/*commented by gopi for hands on feed back points,serial no 12 in zb on 02/02/17*/
		//UI_M_BUT_POST.setDisabled(disabled);
		 //COMP_CBEN_ADDRESS4.setDisabled(disabled);
		 //COMP_CBEN_ADDRESS5.setDisabled(disabled);
		 //COMP_CBEN_REMARKS.setDisabled(disabled);
		/*uncommented by raja on 10-03-2017 for ssp-id ZBILQC-1721754 */
		 COMP_CBEN_CATG_CODE.setDisabled(disabled);
		  //COMP_CBEN_AGE.setDisabled(disabled);
		  //COMP_CBEN_GUARDIAN_NAME.setDisabled(disabled);
		  //COMP_CBEN_MICR_CODE.setDisabled(disabled);
		/*end*/
		  COMP_UI_M_CATG_DESC.setDisabled(disabled);
		  COMP_CBEN_DIVN_CODE.setDisabled(disabled);
		  COMP_UI_M_CBEN_DIVN_CODE.setDisabled(disabled);
		  

		// Disabling HtmlCommandButton
		//COMP_UI_M_BUT_BENF_DTLS_MAIN.setDisabled(disabled);
		  /*Added by Ameen on 08-12-2017 for ZBLIFE-1458892*/
		  	COMP_CBEN_FLEX_01.setDisabled(disabled);
			COMP_CBEN_FLEX_02.setDisabled(disabled);
			COMP_CBEN_FLEX_03.setDisabled(disabled);
			COMP_CBEN_FLEX_04.setDisabled(disabled);
			/*End*/
			
			/*Added by saritha on 12-04-2018 for KIC Claim Beneficiary Issues*/ 
			COMP_CBEN_REF_ID1_NEW.setDisabled(disabled);
			/*End*/
			
	}

	/*Added by Janani on 16.06.2017 for ZBILQC-1722774*/
	
	public void settlement_disableAllComponent(boolean disabled) {
		
		COMP_CBEN_BNF_TYPE.setDisabled(disabled);
		COMP_UI_M_BNF_DESC.setDisabled(disabled);
		COMP_CBEN_REF_ID1.setDisabled(disabled);
		COMP_PBEN_DOB.setDisabled(disabled);
		COMP_CBEN_AGE.setDisabled(disabled);
		COMP_CBEN_PERC.setDisabled(disabled);
		COMP_CBEN_BNF_CODE.setDisabled(disabled);
		COMP_CBEN_BNF_NAME.setDisabled(disabled);
		COMP_CBEN_LC_PAID_AMT.setDisabled(disabled);
		COMP_CBEN_BANK_CODE.setDisabled(disabled);
		COMP_UI_M_CBEN_BANK_CODE_DESC.setDisabled(disabled);
		COMP_CBEN_REMARKS.setDisabled(disabled);
		COMP_CBEN_CATG_CODE.setDisabled(disabled);
		COMP_UI_M_CATG_DESC.setDisabled(disabled);
		COMP_CBEN_RELATION_CODE.setDisabled(disabled);
		COMP_UI_M_CBEN_RELATION_DESC.setDisabled(disabled);
		COMP_CBEN_GUARDIAN_NAME.setDisabled(disabled);
		COMP_CBEN_FC_PAID_AMT.setDisabled(disabled);
		COMP_CBEN_ACCT_CODE.setDisabled(disabled);
		COMP_CBEN_DIVN_CODE.setDisabled(disabled);
		
		/*Added by Ameen on 08-12-2017 for ZBLIFE-1458892*/
	  	COMP_CBEN_FLEX_01.setDisabled(disabled);
		COMP_CBEN_FLEX_02.setDisabled(disabled);
		COMP_CBEN_FLEX_03.setDisabled(disabled);
		COMP_CBEN_FLEX_04.setDisabled(disabled);
		/*End*/
		/*Added by saritha on 12-04-2018 for KIC Claim Beneficiary Issues*/ 
		COMP_CBEN_REF_ID1_NEW.setDisabled(disabled);
		/*End*/

	}
	
	/*End*/
	
	
	
	public void instantiateAllComponent() {

		COMP_CBEN_BNF_NAME = new HtmlInputText();
		COMP_CBEN_REF_ID1 = new HtmlInputText();
		COMP_CBEN_REF_ID2 = new HtmlInputText();
		COMP_CBEN_RELATION_CODE = new HtmlInputText();
		COMP_CBEN_BNF_TYPE = new HtmlInputText();
		COMP_CBEN_PERC = new HtmlInputText();
		COMP_CBEN_FC_PAID_AMT = new HtmlInputText();
		COMP_CBEN_LC_PAID_AMT = new HtmlInputText();
		COMP_CBEN_BANK_CODE = new HtmlInputText();
		COMP_UI_M_CBEN_BANK_CODE_DESC = new HtmlInputText();
		COMP_CBEN_ACCT_CODE = new HtmlInputText();
		COMP_CBEN_ADDRESS1 = new HtmlInputText();
		COMP_UI_M_BNF_DESC = new HtmlInputText();
		COMP_CBEN_ADDRESS2 = new HtmlInputText();
		COMP_UI_M_CBEN_RELATION_DESC = new HtmlInputText();
		COMP_CBEN_ADDRESS3 = new HtmlInputText();
		COMP_CBEN_STAT_CODE = new HtmlInputText();
		COMP_UI_M_CBEN_STAT_CODE_DESC = new HtmlInputText();
		COMP_CBEN_POSTAL_CODE = new HtmlInputText();
		COMP_UI_M_CBEN_POSTAL_CODE_DESC = new HtmlInputText();
		COMP_CBEN_CITY_CODE = new HtmlInputText();
		COMP_UI_M_CBEN_CITY_DESC = new HtmlInputText();
		/*added by gopi for hands on feed back points,serial no 12 in zb on 02/02/17*/
		COMP_PBEN_SR_NO = new HtmlInputText();
		COMP_PBEN_DOB = new HtmlCalendar();
		COMP_CBEN_BNF_CODE = new HtmlInputText();
		/*end*/
		COMP_UI_M_BUT_BENF_DTLS_MAIN = new HtmlCommandButton();
		UI_M_BUT_POST = new HtmlAjaxCommandButton();
		UI_M_BUT_ADD = new HtmlAjaxCommandButton();
		UI_M_BUT_DELETE = new HtmlAjaxCommandButton();

		
		/*Added by Janani on 16.06.2017 for ZBILQC-1722774*/
		
		COMP_CBEN_AGE = new HtmlInputText();
		COMP_CBEN_REMARKS = new HtmlInputText();
		COMP_CBEN_CATG_CODE = new HtmlInputText();
		COMP_UI_M_CATG_DESC = new HtmlInputText();
		COMP_CBEN_GUARDIAN_NAME = new HtmlInputText();
		COMP_CBEN_DIVN_CODE = new HtmlInputText();
		
		/*End*/
		
		/*Added by Ameen on 08-12-2017 for ZBLIFE-1458892*/
	  	COMP_CBEN_FLEX_01 = new HtmlInputText();
		COMP_CBEN_FLEX_02 = new HtmlInputText();
		COMP_CBEN_FLEX_03 = new HtmlInputText();
		COMP_CBEN_FLEX_04 = new HtmlInputText();
		/*End*/
		/*Added by saritha on 12-04-2018 for KIC Claim Beneficiary Issues*/ 
		COMP_CBEN_REF_ID1_NEW  = new HtmlInputText();
		COMP_PBEN_NAME_IMG     = new HtmlGraphicImage();
		/*End*/

	}

	public void AddRow(ActionEvent event) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			/*if (!helper.checkingBeneficiaryinTx(compositeAction
					.getPILT007_PT_IL_CLAIM_ACTION().getPT_IL_CLAIM_BEAN()
					.getCLAIM_POL_NO())) {*/
			if (isINSERT_ALLOWED()) {
				/*commented by raja on 10-03-2017 for ssp-id ZBILQC-1721754 */
				//disableAllComponent(false);
				/*end*/
				helper.validateBeneficiaryPerc1(this);
				PT_IL_CLAIM_BENEFICIARY_BEAN = new PT_IL_CLAIM_BENEFICIARY();
				/*added by gopi for hands on feed back points,serial no 12 in zb on 02/02/17*/
				int serialNumber = CommonUtils.nvl(compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getPT_IL_CLAIM_BENEFICIARY_LIST().size(), 0);
				PT_IL_CLAIM_BENEFICIARY_BEAN.setCBEN_SR_NO(serialNumber+1);
				helper.whenCreateRecord(compositeAction);
				//end
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
			/*} else {
				getErrorMap().put("somekey",
						"Beneficiary Already available for the policy");
				getErrorMap().put("current",
						"Beneficiary Already available for the policy");
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}

	}

	public void deleteRow(ActionEvent ae) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();
			/*commented by gopi for hands on feed back points,serial no 12 in zb on 07/02/17*/
			/*if (!helper.checkingBeneficiaryinTx(compositeAction
					.getPILT007_PT_IL_CLAIM_ACTION().getPT_IL_CLAIM_BEAN()
					.getCLAIM_POL_NO())) {*/
			/*end*/
				if (isDELETE_ALLOWED()) {
					if (PT_IL_CLAIM_BENEFICIARY_BEAN.getROWID() != null) {
						new CRUDHandler().executeDelete(
								PT_IL_CLAIM_BENEFICIARY_BEAN, CommonUtils
										.getConnection());
						compositeAction
								.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION()
								.getPT_IL_CLAIM_BENEFICIARY_LIST().remove(
										PT_IL_CLAIM_BENEFICIARY_BEAN);
					}
					CommonUtils.getConnection().commit();
					if (compositeAction
							.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION()
							.getPT_IL_CLAIM_BENEFICIARY_LIST().size() > 0) {
						setPT_IL_CLAIM_BENEFICIARY_BEAN(compositeAction
								.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION()
								.getPT_IL_CLAIM_BENEFICIARY_LIST().get(0));
					} else {
						AddRow(ae);
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
					PT_IL_CLAIM_BENEFICIARY_BEAN.setRowSelected(true);
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
				/*commented by gopi for hands on feed back points,serial no 12 in zb on 07/02/17*/
			/*} else {
				getErrorMap().clear();
				getErrorMap()
						.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								"You can not delete the Beneficiary mapped in the policy");
				getErrorMap()
						.put("deleteRow",
								"You can not delete the Beneficiary mapped in the policy");
			}*/
				//end
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}

	}

	public String postRecord() {
		PT_IL_CLAIM_BENEFICIARY_HELPER swissClaimBeneficiry = new PT_IL_CLAIM_BENEFICIARY_HELPER();

		try {
			if (PT_IL_CLAIM_BENEFICIARY_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					swissClaimBeneficiry.preUpdate(
							PT_IL_CLAIM_BENEFICIARY_BEAN, compositeAction);
				
					/*added by raja on 10-03-2017 for ssp-id ZBILQC-1721754 */
					helper.validate_benf_type(compositeAction, PT_IL_CLAIM_BENEFICIARY_BEAN);
					
					/*end*/
					/*added by raja on 10-07-2017 for ZBILQC-1731018*/ 

					LIFELIB lifelib = new LIFELIB();
					 lifelib.P_VAL_CUST(PT_IL_CLAIM_BENEFICIARY_BEAN.getCBEN_BNF_CODE(),
							 PT_IL_CLAIM_BENEFICIARY_BEAN.getCBEN_BNF_NAME(), "N", "N",
							 new CommonUtils().getControlBean().getM_DIVN_CODE());
					 
					/*end*/

					new CRUDHandler().executeUpdate(
							PT_IL_CLAIM_BENEFICIARY_BEAN, CommonUtils
									.getConnection());
					
					/*Added by janani on 09.02.2018 for updating claim fee record claim pay to ,as per Sivaram's sugg*/	
				
					Long clm_sys_id =compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_SYS_ID();
					Long cp_ce_sys_id =compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getPT_IL_CLAIM_PAID_BEAN().getCP_CE_SYS_ID();
					Long cp_sys_id =compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getPT_IL_CLAIM_PAID_BEAN().getCP_SYS_ID();
					String clm_paid_to =compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_PAID_TO();
					
						System.out.println("getCP_SET_FLAG       "+compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getPT_IL_CLAIM_PAID_BEAN().getCP_SET_FLAG());
						System.out.println("getCP_CLM_PAID_STATUS                 "+compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getPT_IL_CLAIM_PAID_BEAN().getCP_CLM_PAID_STATUS());
						System.out.println("CLAIM_SYS_ID in  post        "+clm_sys_id);
						System.out.println("CP_CE_SYS_ID in post             "+cp_ce_sys_id);
						System.out.println("CP_SYS_ID in post             "+cp_sys_id);
						System.out.println("CP_SYS_ID in post             "+clm_paid_to);
						
					new PILT007_PROCEDURE().P_UPD_CLM_BENEFICIARY(clm_sys_id,cp_ce_sys_id,
							cp_sys_id,clm_paid_to);
					
					/*End*/
					
					
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
					
					/*added by raja on 10-07-2017 for ZBILQC-1731018*/ 

					LIFELIB lifelib = new LIFELIB();
					 lifelib.P_VAL_CUST(PT_IL_CLAIM_BENEFICIARY_BEAN.getCBEN_BNF_CODE(),
							 PT_IL_CLAIM_BENEFICIARY_BEAN.getCBEN_BNF_NAME(), "N", "N",
							 new CommonUtils().getControlBean().getM_DIVN_CODE());
					 
					/*end*/

					swissClaimBeneficiry.preInsert(
							PT_IL_CLAIM_BENEFICIARY_BEAN, compositeAction);
					/*added by raja on 10-03-2017 for ssp-id ZBILQC-1721754 */
					helper.validate_benf_type(compositeAction, PT_IL_CLAIM_BENEFICIARY_BEAN);
					/*end*/
					new CRUDHandler().executeInsert(
							PT_IL_CLAIM_BENEFICIARY_BEAN, CommonUtils
									.getConnection());
					
					/*Added by janani on 09.02.2018 for updating claim fee record claim pay to ,as per Sivaram's sugg*/	
					
					Long clm_sys_id =compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_SYS_ID();
					Long cp_ce_sys_id =compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getPT_IL_CLAIM_PAID_BEAN().getCP_CE_SYS_ID();
					Long cp_sys_id =compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getPT_IL_CLAIM_PAID_BEAN().getCP_SYS_ID();
					String clm_paid_to =compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getPT_IL_CLAIM_PAID_BEAN().getCP_CLAIM_PAID_TO();
					
						System.out.println("getCP_SET_FLAG       "+compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getPT_IL_CLAIM_PAID_BEAN().getCP_SET_FLAG());
						System.out.println("getCP_CLM_PAID_STATUS                 "+compositeAction.getPILT007_PT_IL_CLAIM_PAID_ACTION().getPT_IL_CLAIM_PAID_BEAN().getCP_CLM_PAID_STATUS());
						System.out.println("CLAIM_SYS_ID in  post        "+clm_sys_id);
						System.out.println("CP_CE_SYS_ID in post             "+cp_ce_sys_id);
						System.out.println("CP_SYS_ID in post             "+cp_sys_id);
						System.out.println("CP_SYS_ID in post             "+clm_paid_to);
						
					new PILT007_PROCEDURE().P_UPD_CLM_BENEFICIARY(clm_sys_id,cp_ce_sys_id,
							cp_sys_id,clm_paid_to);
					
						
					
					
					/*End*/
					
					
					/*Added by Janani on 19.06.2017 for ZBILQC-1722914*/
					
					/*getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));*/
									
					
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$save"));
					
					
					/*getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));*/
					
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$save"));
					
					/*End*/
					
					
					compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION()
							.getPT_IL_CLAIM_BENEFICIARY_LIST().add(
									PT_IL_CLAIM_BENEFICIARY_BEAN);
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
			/*Added by sankara narayanan for save functionality*/
			CommonUtils
			.getConnection().commit();
			//end
			resetSelectedRow();
			PT_IL_CLAIM_BENEFICIARY_BEAN.setRowSelected(true);
			resetAllComponent();

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
		return null;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public HtmlInputText getCOMP_CBEN_ADDRESS4() {
		return COMP_CBEN_ADDRESS4;
	}

	public void setCOMP_CBEN_ADDRESS4(HtmlInputText comp_cben_address4) {
		COMP_CBEN_ADDRESS4 = comp_cben_address4;
	}

	public HtmlInputText getCOMP_CBEN_ADDRESS5() {
		return COMP_CBEN_ADDRESS5;
	}

	public void setCOMP_CBEN_ADDRESS5(HtmlInputText comp_cben_address5) {
		COMP_CBEN_ADDRESS5 = comp_cben_address5;
	}

	public HtmlInputText getCOMP_CBEN_REMARKS() {
		return COMP_CBEN_REMARKS;
	}

	public void setCOMP_CBEN_REMARKS(HtmlInputText comp_cben_remarks) {
		COMP_CBEN_REMARKS = comp_cben_remarks;
	}

	public HtmlInputText getCOMP_CBEN_CATG_CODE() {
		return COMP_CBEN_CATG_CODE;
	}

	public void setCOMP_CBEN_CATG_CODE(HtmlInputText comp_cben_catg_code) {
		COMP_CBEN_CATG_CODE = comp_cben_catg_code;
	}

	public HtmlInputText getCOMP_CBEN_AGE() {
		return COMP_CBEN_AGE;
	}

	public void setCOMP_CBEN_AGE(HtmlInputText comp_cben_age) {
		COMP_CBEN_AGE = comp_cben_age;
	}

	public HtmlInputText getCOMP_CBEN_GUARDIAN_NAME() {
		return COMP_CBEN_GUARDIAN_NAME;
	}

	public void setCOMP_CBEN_GUARDIAN_NAME(HtmlInputText comp_cben_guardian_name) {
		COMP_CBEN_GUARDIAN_NAME = comp_cben_guardian_name;
	}

	public HtmlInputText getCOMP_CBEN_MICR_CODE() {
		return COMP_CBEN_MICR_CODE;
	}

	public void setCOMP_CBEN_MICR_CODE(HtmlInputText comp_cben_micr_code) {
		COMP_CBEN_MICR_CODE = comp_cben_micr_code;
	}

	public HtmlOutputLabel getCOMP_CBEN_ADDRESS4_LABEL() {
		return COMP_CBEN_ADDRESS4_LABEL;
	}

	public void setCOMP_CBEN_ADDRESS4_LABEL(
			HtmlOutputLabel comp_cben_address4_label) {
		COMP_CBEN_ADDRESS4_LABEL = comp_cben_address4_label;
	}

	public HtmlOutputLabel getCOMP_CBEN_ADDRESS5_LABEL() {
		return COMP_CBEN_ADDRESS5_LABEL;
	}

	public void setCOMP_CBEN_ADDRESS5_LABEL(
			HtmlOutputLabel comp_cben_address5_label) {
		COMP_CBEN_ADDRESS5_LABEL = comp_cben_address5_label;
	}

	public HtmlOutputLabel getCOMP_CBEN_REMARKS_LABEL() {
		return COMP_CBEN_REMARKS_LABEL;
	}

	public void setCOMP_CBEN_REMARKS_LABEL(
			HtmlOutputLabel comp_cben_remarks_label) {
		COMP_CBEN_REMARKS_LABEL = comp_cben_remarks_label;
	}

	public HtmlOutputLabel getCOMP_CBEN_CATG_CODE_LABEL() {
		return COMP_CBEN_CATG_CODE_LABEL;
	}

	public void setCOMP_CBEN_CATG_CODE_LABEL(
			HtmlOutputLabel comp_cben_catg_code_label) {
		COMP_CBEN_CATG_CODE_LABEL = comp_cben_catg_code_label;
	}

	public HtmlOutputLabel getCOMP_CBEN_AGE_LABEL() {
		return COMP_CBEN_AGE_LABEL;
	}

	public void setCOMP_CBEN_AGE_LABEL(HtmlOutputLabel comp_cben_age_label) {
		COMP_CBEN_AGE_LABEL = comp_cben_age_label;
	}

	public HtmlOutputLabel getCOMP_CBEN_GUARDIAN_NAME_LABEL() {
		return COMP_CBEN_GUARDIAN_NAME_LABEL;
	}

	public void setCOMP_CBEN_GUARDIAN_NAME_LABEL(
			HtmlOutputLabel comp_cben_guardian_name_label) {
		COMP_CBEN_GUARDIAN_NAME_LABEL = comp_cben_guardian_name_label;
	}

	public HtmlOutputLabel getCOMP_CBEN_MICR_CODE_LABEL() {
		return COMP_CBEN_MICR_CODE_LABEL;
	}

	public void setCOMP_CBEN_MICR_CODE_LABEL(
			HtmlOutputLabel comp_cben_micr_code_label) {
		COMP_CBEN_MICR_CODE_LABEL = comp_cben_micr_code_label;
	}

	public HtmlInputText getCOMP_UI_M_CATG_DESC() {
		return COMP_UI_M_CATG_DESC;
	}

	public void setCOMP_UI_M_CATG_DESC(HtmlInputText comp_ui_m_catg_desc) {
		COMP_UI_M_CATG_DESC = comp_ui_m_catg_desc;
	}

	public HtmlInputText getCOMP_UI_M_CBEN_DIVN_CODE() {
		return COMP_UI_M_CBEN_DIVN_CODE;
	}

	public void setCOMP_UI_M_CBEN_DIVN_CODE(HtmlInputText comp_ui_m_cben_divn_code) {
		COMP_UI_M_CBEN_DIVN_CODE = comp_ui_m_cben_divn_code;
	}

	public HtmlInputText getCOMP_CBEN_DIVN_CODE() {
		return COMP_CBEN_DIVN_CODE;
	}

	public void setCOMP_CBEN_DIVN_CODE(HtmlInputText comp_cben_divn_code) {
		COMP_CBEN_DIVN_CODE = comp_cben_divn_code;
	}

	public HtmlOutputLabel getCOMP_CBEN_DIVN_CODE_LABEL() {
		return COMP_CBEN_DIVN_CODE_LABEL;
	}

	public void setCOMP_CBEN_DIVN_CODE_LABEL(
			HtmlOutputLabel comp_cben_divn_code_label) {
		COMP_CBEN_DIVN_CODE_LABEL = comp_cben_divn_code_label;
	}
	/*added by gopi for hands on feed back points,serial no 12 in zb on 03/02/17*/
	public ArrayList<LovBean> lovASH_CITIZEN_CODE(Object currValue) {
		String code = (String) currValue;
		ArrayList<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		try {
			if ("*".equals(code)) {
				object = new Object[] { PELConstants.suggetionRecordSize };
				query = PT_IL_POLICY_QUERY_CONSTANTS.POL_ASSRD_REF_ID1_QUERY;
			} else {
				object = new Object[] { code + "%", code + "%",
						PELConstants.suggetionRecordSize };
				query = PT_IL_POLICY_QUERY_CONSTANTS.POL_ASSRD_REF_ID1_QUERY_LIKE;
			}
			suggestionList = ListItemUtil.prepareSuggestionList(query, object);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public void PBEN_REF_ID1_WHEN_VALIDATE_ITEM(ActionEvent actionEvent){
		getErrorMap().clear();
		getWarningMap().clear();
		
		try {
			PT_IL_CLAIM_BENEFICIARY_BEAN.setCBEN_REF_ID1(COMP_CBEN_REF_ID1.getSubmittedValue().toString());
			helper.PBEN_REF_ID1_WHEN_VALIDATE_ITEM(compositeAction,PT_IL_CLAIM_BENEFICIARY_BEAN);
			COMP_CBEN_CATG_CODE.resetValue();
			COMP_UI_M_CATG_DESC.resetValue();
			COMP_CBEN_AGE.resetValue();
			COMP_CBEN_DIVN_CODE.resetValue();
			COMP_CBEN_BNF_CODE.resetValue();
			COMP_CBEN_BNF_NAME.resetValue();
			COMP_PBEN_DOB.resetValue();
			COMP_CBEN_BANK_CODE.resetValue();
			COMP_UI_M_CBEN_BANK_CODE_DESC.resetValue();
			COMP_CBEN_CITY_CODE.resetValue();
			COMP_UI_M_CBEN_CITY_DESC.resetValue();
			COMP_CBEN_ACCT_CODE.resetValue();
			/*Added by Ameen on 30-12-2017 for ZBLIFE-1458892*/
			COMP_CBEN_FLEX_01.resetValue();
			COMP_CBEN_FLEX_02.resetValue();
			COMP_CBEN_FLEX_03.resetValue();	
			COMP_UI_M_CBEN_DIVN_CODE.resetValue();
			/*End*/
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			//throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public ArrayList<LovBean> prepareSuggestionList_CBEN_CATG_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();
		String currentValue = (String) object;
		String moduleName = "PILT007";
		String blockName = "PT_IL_CLAIM_BENEFICIARY";
		String fieldName = "CBEN_CATG_CODE";
		Object param1 = "CATG";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
					null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	
	
	/*added by raja on 10-03-2017 for ssp-id ZBILQC-1721754 */
	public void typeValidation(PT_IL_CLAIM_BENEFICIARY beneficiaryBean,String typefieldvalue) throws Exception
	{
		
		/*Added by Janani on 16.06.2017 for ZBILQC-1721754*/
		
		System.out.println("Enters into typeValidation");
		
		String settlement_sts = null;
		settlement_sts = compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getUI_M_CLAIM_ADDL_STATUS();
		
		System.out.println("settlement_sts       :"+settlement_sts);
		
		if(settlement_sts != null && !settlement_sts.equalsIgnoreCase("closed"))
		{
		
			/*End*/
			
		if(typefieldvalue != null && (typefieldvalue.equals("A") || typefieldvalue.equalsIgnoreCase("S"))){
			COMP_CBEN_DIVN_CODE.setDisabled(false);
			COMP_CBEN_BANK_CODE.setDisabled(false);
			COMP_CBEN_DIVN_CODE.setRequired(true);
			COMP_CBEN_BANK_CODE.setRequired(true);
			COMP_CBEN_ACCT_CODE.setRequired(true);
			COMP_CBEN_ACCT_CODE.setDisabled(false);
			}
		/*
		 * commented by Ameen on 02-12-2017 for ZBLIFE-1458892 
		 * else{
			beneficiaryBean.setCBEN_BANK_CODE(null);
			beneficiaryBean.setUI_M_CBEN_BANK_CODE_DESC(null);
			beneficiaryBean.setCBEN_DIVN_CODE(null);
			beneficiaryBean.setCBEN_ACCT_CODE(null);
			
			COMP_CBEN_DIVN_CODE.setDisabled(true);
			COMP_CBEN_BANK_CODE.setDisabled(true);
			COMP_CBEN_DIVN_CODE.setRequired(false);
			COMP_CBEN_BANK_CODE.setRequired(false);
			COMP_CBEN_ACCT_CODE.setRequired(false);
			COMP_CBEN_ACCT_CODE.setDisabled(true);
		}*/
		
		
		}
		if(beneficiaryBean.getCBEN_AGE()!=null)
		{
			
			ResultSet resultSetage = null;
			int beneficieryMinimumAge = 0;
			String BeneficieryQuery = "SELECT PS_VALUE FROM PP_SYSTEM where PS_TYPE = ?";

			 Connection connection = CommonUtils.getConnection();


			 resultSetage = new CRUDHandler().executeSelectStatement(BeneficieryQuery, connection,new Object[] { "IL_CHILD_AGE" });
			

			while (resultSetage.next()) {
				beneficieryMinimumAge = resultSetage.getInt(1);
			}
			System.out.println("beneficieryMinimumAge      "+beneficieryMinimumAge);
			if(beneficieryMinimumAge == 0)
			{
				throw new Exception("Nominee Minimum age setup is not available.");
			}

			
			if (beneficiaryBean.getCBEN_AGE() <= beneficieryMinimumAge && !("A".equals(beneficiaryBean.getCBEN_BNF_TYPE()) || "S".equals(beneficiaryBean.getCBEN_BNF_TYPE()))) {

				compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getCOMP_CBEN_GUARDIAN_NAME().setDisabled(false);
				compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getCOMP_CBEN_GUARDIAN_NAME().setRequired(true);
				
			} else {

				
				/*Added by saritha on 12-04-2018 for KIC Claim Beneficiary Issues*/ 
				
				//compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getPT_IL_CLAIM_BENEFICIARY_BEAN().setCBEN_GUARDIAN_NAME(null);
				//compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getCOMP_CBEN_GUARDIAN_NAME().setDisabled(true);
				compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getCOMP_CBEN_GUARDIAN_NAME().setRequired(false);

				
			}
			
			//compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getCOMP_CBEN_GUARDIAN_NAME().resetValue();
			
			/*End*/
			
		}
	}
	/*end*/
	
	
	/*added by raja on 04-08-2017 for create the undo button */
	public String navigationEnabled(){
		getErrorMap().clear();
		//	compositeAction.getWizard().setImmediate("true");
		COMP_UI_M_BUT_BENF_DTLS_MAIN.setImmediate(true);
		return "";
	}
	
	
	/*end*/
	
	/*Added by Ameen as per Ajay sugg. to diaplay back dtls fields*/
	private HtmlOutputLabel COMP_CBEN_FLEX_01_LABEL;;
	
	private HtmlInputText COMP_CBEN_FLEX_01;
	
	private HtmlOutputLabel COMP_CBEN_FLEX_02_LABEL;;
	
	private HtmlInputText COMP_CBEN_FLEX_02;
	
	private HtmlOutputLabel COMP_CBEN_FLEX_03_LABEL;;
	
	private HtmlInputText COMP_CBEN_FLEX_03;
	
	private HtmlOutputLabel COMP_CBEN_FLEX_04_LABEL;;
	
	private HtmlInputText COMP_CBEN_FLEX_04;

	public HtmlOutputLabel getCOMP_CBEN_FLEX_01_LABEL() {
		return COMP_CBEN_FLEX_01_LABEL;
	}
	public void setCOMP_CBEN_FLEX_01_LABEL(HtmlOutputLabel cOMP_CBEN_FLEX_01_LABEL) {
		COMP_CBEN_FLEX_01_LABEL = cOMP_CBEN_FLEX_01_LABEL;
	}
	public HtmlInputText getCOMP_CBEN_FLEX_01() {
		return COMP_CBEN_FLEX_01;
	}
	public void setCOMP_CBEN_FLEX_01(HtmlInputText cOMP_CBEN_FLEX_01) {
		COMP_CBEN_FLEX_01 = cOMP_CBEN_FLEX_01;
	}
	public HtmlOutputLabel getCOMP_CBEN_FLEX_02_LABEL() {
		return COMP_CBEN_FLEX_02_LABEL;
	}
	public void setCOMP_CBEN_FLEX_02_LABEL(HtmlOutputLabel cOMP_CBEN_FLEX_02_LABEL) {
		COMP_CBEN_FLEX_02_LABEL = cOMP_CBEN_FLEX_02_LABEL;
	}
	public HtmlInputText getCOMP_CBEN_FLEX_02() {
		return COMP_CBEN_FLEX_02;
	}
	public void setCOMP_CBEN_FLEX_02(HtmlInputText cOMP_CBEN_FLEX_02) {
		COMP_CBEN_FLEX_02 = cOMP_CBEN_FLEX_02;
	}
	public HtmlOutputLabel getCOMP_CBEN_FLEX_03_LABEL() {
		return COMP_CBEN_FLEX_03_LABEL;
	}
	public void setCOMP_CBEN_FLEX_03_LABEL(HtmlOutputLabel cOMP_CBEN_FLEX_03_LABEL) {
		COMP_CBEN_FLEX_03_LABEL = cOMP_CBEN_FLEX_03_LABEL;
	}
	public HtmlInputText getCOMP_CBEN_FLEX_03() {
		return COMP_CBEN_FLEX_03;
	}
	public void setCOMP_CBEN_FLEX_03(HtmlInputText cOMP_CBEN_FLEX_03) {
		COMP_CBEN_FLEX_03 = cOMP_CBEN_FLEX_03;
	}
	public HtmlOutputLabel getCOMP_CBEN_FLEX_04_LABEL() {
		return COMP_CBEN_FLEX_04_LABEL;
	}
	public void setCOMP_CBEN_FLEX_04_LABEL(HtmlOutputLabel cOMP_CBEN_FLEX_04_LABEL) {
		COMP_CBEN_FLEX_04_LABEL = cOMP_CBEN_FLEX_04_LABEL;
	}
	public HtmlInputText getCOMP_CBEN_FLEX_04() {
		return COMP_CBEN_FLEX_04;
	}
	public void setCOMP_CBEN_FLEX_04(HtmlInputText cOMP_CBEN_FLEX_04) {
		COMP_CBEN_FLEX_04 = cOMP_CBEN_FLEX_04;
	}
	
	public void validatorCBEN_FLEX_01(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PT_IL_CLAIM_BENEFICIARY_BEAN.setCBEN_FLEX_01((String) value);
		} catch (Exception e) {
			throw 
				new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}
	
	public void validateCBEN_FLEX_02(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PT_IL_CLAIM_BENEFICIARY_BEAN.setCBEN_FLEX_02((String) value);
		} catch (Exception e) {
			throw 
				new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}
	public void validatorCBEN_FLEX_03(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PT_IL_CLAIM_BENEFICIARY_BEAN.setCBEN_FLEX_03((String) value);
		} catch (Exception e) {
			throw 
				new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}
	public void validateCBEN_FLEX_04(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PT_IL_CLAIM_BENEFICIARY_BEAN.setCBEN_FLEX_04((String) value);
		} catch (Exception e) {
			throw 
				new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}
	
	public ArrayList<LovBean> prepareSuggestionList_UI_M_DIVISION_CODE(Object currValue) {
		String code = (String) currValue;
		ArrayList<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		try {
			if ("*".equals(code)) {
				object = new Object[] { PT_IL_CLAIM_BENEFICIARY_BEAN.getCBEN_BANK_CODE(), PELConstants.suggetionRecordSize };
				
				
				query = "SELECT BR_BANK_SORT_CODE,BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH WHERE BR_BANK_CODE = ? AND ROWNUM <= ? ORDER BY 1";
			} else {
				object = new Object[] { PT_IL_CLAIM_BENEFICIARY_BEAN.getCBEN_BANK_CODE(), code + "%", code + "%",
						PELConstants.suggetionRecordSize };
				
				query = "SELECT BR_BANK_SORT_CODE,BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH WHERE BR_BANK_CODE = ? AND"
						+ "(UPPER(BR_BANK_SORT_CODE) LIKE UPPER(?) OR UPPER(BR_BANK_BRANCH_CODE) LIKE UPPER(?)) AND ROWNUM <= ? ORDER BY 1";
				/*End*/
			}
			suggestionList = ListItemUtil.prepareSuggestionList(query, object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	/*End*/
	
	/*Added by saritha on 12-04-2018 for KIC Claim Beneficiary Issues*/ 
	private HtmlInputText COMP_CBEN_REF_ID1_NEW;

	public HtmlInputText getCOMP_CBEN_REF_ID1_NEW() {
		return COMP_CBEN_REF_ID1_NEW;
	}
	public void setCOMP_CBEN_REF_ID1_NEW(HtmlInputText cOMP_CBEN_REF_ID1_NEW) {
		COMP_CBEN_REF_ID1_NEW = cOMP_CBEN_REF_ID1_NEW;
	}
	
	private HtmlGraphicImage COMP_PBEN_NAME_IMG;
	
	public HtmlGraphicImage getCOMP_PBEN_NAME_IMG() {
		return COMP_PBEN_NAME_IMG;
	}
	public void setCOMP_PBEN_NAME_IMG(HtmlGraphicImage cOMP_PBEN_NAME_IMG) {
		COMP_PBEN_NAME_IMG = cOMP_PBEN_NAME_IMG;
	}
	
	
	public String chkFreezConfirmflag(PILT007_COMPOSITE_ACTION compositeAction) throws Exception{
		 Connection connection = null;
		 ResultSet resultSet = null;
		 String confirm_flag = null;
		 
		 String query = "SELECT CCD_CONFIRM_FLAG FROM PT_IL_CLAIM_COVER_DTLS WHERE CCD_CLAIM_SYS_ID= ? ";
		 try {
			 connection = CommonUtils.getConnection();
			 resultSet = new CRUDHandler().executeSelectStatement(query,
					 connection, new Object[] { compositeAction.getPILT007_PT_IL_CLAIM_BENEFICIARY_ACTION().getPT_IL_CLAIM_BENEFICIARY_BEAN().getCBEN_CLAIM_SYS_ID() });
			 if (resultSet.next()) {
				 confirm_flag = resultSet.getString(1);
				 
			 }
		 } catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
			return confirm_flag;
		}


	public void validatorCBEN_CATG_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PT_IL_CLAIM_BENEFICIARY_BEAN.setCBEN_CATG_CODE((String) value);
			COMP_CBEN_CATG_CODE.resetValue();
		} catch (Exception e) {
			throw 
				new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}
	
	
	public void validateCBEN_DOB(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		Date curDate = (Date) value;
		try {
			PT_IL_CLAIM_BENEFICIARY_BEAN.setCBEN_DOB(curDate);
			COMP_PBEN_DOB.resetValue();
		} catch (Exception e) {
			throw 
			new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}

	public void validateCBEN_AGE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		
		try {
			PT_IL_CLAIM_BENEFICIARY_BEAN.setCBEN_AGE((Integer) value);
			COMP_CBEN_AGE.resetValue();
		} catch (Exception e) {
			throw 
			new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}

	public void validatorCBEN_GUARDIAN_NAME(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PT_IL_CLAIM_BENEFICIARY_BEAN.setCBEN_GUARDIAN_NAME((String) value);
			
		} catch (Exception e) {
			throw 
			new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}

	public void validatorCBEN_REF_ID1_NEW(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PT_IL_CLAIM_BENEFICIARY_BEAN.setCBEN_REF_ID1((String) value);
			COMP_CBEN_REF_ID1_NEW.resetValue();
		
		} catch (Exception e) {
			throw 
			new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}

	public void validatorCBEN_REMARKS(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PT_IL_CLAIM_BENEFICIARY_BEAN.setCBEN_REMARKS((String) value);
			//COMP_CBEN_REMARKS.resetValue();
		
		} catch (Exception e) {
			throw 
			new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}
	
	/*End*/
	
}
