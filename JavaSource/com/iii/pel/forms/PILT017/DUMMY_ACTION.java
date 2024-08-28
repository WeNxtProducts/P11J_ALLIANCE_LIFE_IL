package com.iii.pel.forms.PILT017;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

import org.richfaces.component.html.HtmlCalendar;



public class DUMMY_ACTION {

	private DUMMY DUMMY_BEAN;
	public COMPOSITE_ACTION_BEAN compositeAction;
	
	private HtmlInputText COMP_UI_M_POL_NO;
	private HtmlOutputLabel COMP_UI_M_POL_NO_LABEL;
	
	private HtmlInputText COMP_UI_M_APPRV_DATE;
	private HtmlOutputLabel COMP_UI_M_APPRV_DATE_LABEL;
	
	private HtmlInputText COMP_UI_M_TRAN_DATE;
	private HtmlOutputLabel COMP_UI_M_TRAN_DATE_LABEL;
	
	private HtmlCalendar COMP_UI_M_CUST_CODE;
	private HtmlOutputLabel COMP_UI_M_CUST_CODE_LABEL;
	
	private HtmlInputText COMP_UI_M_POL_CUST_DESC;
	
	private HtmlInputText COMP_UI_M_FC_AMOUNT;
	private HtmlOutputLabel COMP_UI_M_FC_AMOUNT_LABEL;
	
	private HtmlInputText COMP_UI_M_LC_AMOUNT;
	private HtmlOutputLabel COMP_UI_M_LC_AMOUNT_LABEL;
	
	private HtmlInputText COMP_UI_M_PREM_GEN_YN;
	private HtmlOutputLabel COMP_UI_M_PREM_GEN_YN_LABEL;

	
	private HtmlInputText COMP_UI_M_BROK_GEN_YN;
	private HtmlOutputLabel COMP_UI_M_BROK_GEN_YN_LABEL;
	
	private HtmlCommandButton COMP_UI_M_BUT_PYMT_DTLS;
	private HtmlCommandButton COMP_UI_M_BUT_OK;
	private HtmlCommandButton COMP_UI_M_BUT_CANCEL;
	
	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO() {
	    return COMP_UI_M_POL_NO;
	}

	public void setCOMP_UI_M_POL_NO(HtmlInputText comp_ui_m_pol_no) {
	    COMP_UI_M_POL_NO = comp_ui_m_pol_no;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_LABEL() {
	    return COMP_UI_M_POL_NO_LABEL;
	}

	public void setCOMP_UI_M_POL_NO_LABEL(HtmlOutputLabel comp_ui_m_pol_no_label) {
	    COMP_UI_M_POL_NO_LABEL = comp_ui_m_pol_no_label;
	}

	public HtmlInputText getCOMP_UI_M_APPRV_DATE() {
	    return COMP_UI_M_APPRV_DATE;
	}

	public void setCOMP_UI_M_APPRV_DATE(HtmlInputText comp_ui_m_apprv_date) {
	    COMP_UI_M_APPRV_DATE = comp_ui_m_apprv_date;
	}

	public HtmlOutputLabel getCOMP_UI_M_APPRV_DATE_LABEL() {
	    return COMP_UI_M_APPRV_DATE_LABEL;
	}

	public void setCOMP_UI_M_APPRV_DATE_LABEL(
		HtmlOutputLabel comp_ui_m_apprv_date_label) {
	    COMP_UI_M_APPRV_DATE_LABEL = comp_ui_m_apprv_date_label;
	}

	public HtmlInputText getCOMP_UI_M_TRAN_DATE() {
	    return COMP_UI_M_TRAN_DATE;
	}

	public void setCOMP_UI_M_TRAN_DATE(HtmlInputText comp_ui_m_tran_date) {
	    COMP_UI_M_TRAN_DATE = comp_ui_m_tran_date;
	}

	public HtmlOutputLabel getCOMP_UI_M_TRAN_DATE_LABEL() {
	    return COMP_UI_M_TRAN_DATE_LABEL;
	}

	public void setCOMP_UI_M_TRAN_DATE_LABEL(
		HtmlOutputLabel comp_ui_m_tran_date_label) {
	    COMP_UI_M_TRAN_DATE_LABEL = comp_ui_m_tran_date_label;
	}

	public HtmlCalendar getCOMP_UI_M_CUST_CODE() {
	    return COMP_UI_M_CUST_CODE;
	}

	public void setCOMP_UI_M_CUST_CODE(HtmlCalendar comp_ui_m_cust_code) {
	    COMP_UI_M_CUST_CODE = comp_ui_m_cust_code;
	}

	public HtmlOutputLabel getCOMP_UI_M_CUST_CODE_LABEL() {
	    return COMP_UI_M_CUST_CODE_LABEL;
	}

	public void setCOMP_UI_M_CUST_CODE_LABEL(
		HtmlOutputLabel comp_ui_m_cust_code_label) {
	    COMP_UI_M_CUST_CODE_LABEL = comp_ui_m_cust_code_label;
	}

	public HtmlInputText getCOMP_UI_M_POL_CUST_DESC() {
	    return COMP_UI_M_POL_CUST_DESC;
	}

	public void setCOMP_UI_M_POL_CUST_DESC(HtmlInputText comp_ui_m_pol_cust_desc) {
	    COMP_UI_M_POL_CUST_DESC = comp_ui_m_pol_cust_desc;
	}

	public HtmlInputText getCOMP_UI_M_FC_AMOUNT() {
	    return COMP_UI_M_FC_AMOUNT;
	}

	public void setCOMP_UI_M_FC_AMOUNT(HtmlInputText comp_ui_m_fc_amount) {
	    COMP_UI_M_FC_AMOUNT = comp_ui_m_fc_amount;
	}

	public HtmlOutputLabel getCOMP_UI_M_FC_AMOUNT_LABEL() {
	    return COMP_UI_M_FC_AMOUNT_LABEL;
	}

	public void setCOMP_UI_M_FC_AMOUNT_LABEL(
		HtmlOutputLabel comp_ui_m_fc_amount_label) {
	    COMP_UI_M_FC_AMOUNT_LABEL = comp_ui_m_fc_amount_label;
	}

	public HtmlInputText getCOMP_UI_M_LC_AMOUNT() {
	    return COMP_UI_M_LC_AMOUNT;
	}

	public void setCOMP_UI_M_LC_AMOUNT(HtmlInputText comp_ui_m_lc_amount) {
	    COMP_UI_M_LC_AMOUNT = comp_ui_m_lc_amount;
	}

	public HtmlOutputLabel getCOMP_UI_M_LC_AMOUNT_LABEL() {
	    return COMP_UI_M_LC_AMOUNT_LABEL;
	}

	public void setCOMP_UI_M_LC_AMOUNT_LABEL(
		HtmlOutputLabel comp_ui_m_lc_amount_label) {
	    COMP_UI_M_LC_AMOUNT_LABEL = comp_ui_m_lc_amount_label;
	}

	public HtmlInputText getCOMP_UI_M_PREM_GEN_YN() {
	    return COMP_UI_M_PREM_GEN_YN;
	}

	public void setCOMP_UI_M_PREM_GEN_YN(HtmlInputText comp_ui_m_prem_gen_yn) {
	    COMP_UI_M_PREM_GEN_YN = comp_ui_m_prem_gen_yn;
	}

	public HtmlOutputLabel getCOMP_UI_M_PREM_GEN_YN_LABEL() {
	    return COMP_UI_M_PREM_GEN_YN_LABEL;
	}

	public void setCOMP_UI_M_PREM_GEN_YN_LABEL(
		HtmlOutputLabel comp_ui_m_prem_gen_yn_label) {
	    COMP_UI_M_PREM_GEN_YN_LABEL = comp_ui_m_prem_gen_yn_label;
	}

	public HtmlInputText getCOMP_UI_M_BROK_GEN_YN() {
	    return COMP_UI_M_BROK_GEN_YN;
	}

	public void setCOMP_UI_M_BROK_GEN_YN(HtmlInputText comp_ui_m_brok_gen_yn) {
	    COMP_UI_M_BROK_GEN_YN = comp_ui_m_brok_gen_yn;
	}

	public HtmlOutputLabel getCOMP_UI_M_BROK_GEN_YN_LABEL() {
	    return COMP_UI_M_BROK_GEN_YN_LABEL;
	}

	public void setCOMP_UI_M_BROK_GEN_YN_LABEL(
		HtmlOutputLabel comp_ui_m_brok_gen_yn_label) {
	    COMP_UI_M_BROK_GEN_YN_LABEL = comp_ui_m_brok_gen_yn_label;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PYMT_DTLS() {
	    return COMP_UI_M_BUT_PYMT_DTLS;
	}

	public void setCOMP_UI_M_BUT_PYMT_DTLS(HtmlCommandButton comp_ui_m_but_pymt_dtls) {
	    COMP_UI_M_BUT_PYMT_DTLS = comp_ui_m_but_pymt_dtls;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_OK() {
	    return COMP_UI_M_BUT_OK;
	}

	public void setCOMP_UI_M_BUT_OK(HtmlCommandButton comp_ui_m_but_ok) {
	    COMP_UI_M_BUT_OK = comp_ui_m_but_ok;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CANCEL() {
	    return COMP_UI_M_BUT_CANCEL;
	}

	public void setCOMP_UI_M_BUT_CANCEL(HtmlCommandButton comp_ui_m_but_cancel) {
	    COMP_UI_M_BUT_CANCEL = comp_ui_m_but_cancel;
	}
}
