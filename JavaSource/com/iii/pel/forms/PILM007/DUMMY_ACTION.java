package com.iii.pel.forms.PILM007;

import javax.faces.component.html.HtmlCommandButton;

public class DUMMY_ACTION extends com.iii.premia.common.action.CommonAction {

	private HtmlCommandButton COMP_UI_M_BUT_CR_LIEN_YN;
	private HtmlCommandButton COMP_UI_M_BUT_LATE_FEE_DTLS;
	private HtmlCommandButton COMP_UI_M_BUT_CR_HIBA_YN;
	private HtmlCommandButton COMP_UI_M_BUT_WAIT_PERIOD;
	public PILM007_COMPOSITE_ACTION compositeAction;
	private DUMMY DUMMY_BEAN;

	public DUMMY_ACTION(){
		DUMMY_BEAN = new DUMMY();
	}
	public HtmlCommandButton getCOMP_UI_M_BUT_CR_LIEN_YN() {
		return COMP_UI_M_BUT_CR_LIEN_YN;
	}

	public void setCOMP_UI_M_BUT_CR_LIEN_YN(HtmlCommandButton m_but_cr_lien_yn) {
		COMP_UI_M_BUT_CR_LIEN_YN = m_but_cr_lien_yn;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY dummy_bean) {
		DUMMY_BEAN = dummy_bean;
	}
	public HtmlCommandButton getCOMP_UI_M_BUT_LATE_FEE_DTLS() {
		return COMP_UI_M_BUT_LATE_FEE_DTLS;
	}
	public void setCOMP_UI_M_BUT_LATE_FEE_DTLS(
			HtmlCommandButton comp_ui_m_but_late_fee_dtls) {
		COMP_UI_M_BUT_LATE_FEE_DTLS = comp_ui_m_but_late_fee_dtls;
	}
	public HtmlCommandButton getCOMP_UI_M_BUT_CR_HIBA_YN() {
		return COMP_UI_M_BUT_CR_HIBA_YN;
	}
	public void setCOMP_UI_M_BUT_CR_HIBA_YN(HtmlCommandButton comp_m_but_cr_hiba_yn) {
		COMP_UI_M_BUT_CR_HIBA_YN = comp_m_but_cr_hiba_yn;
	}
	public HtmlCommandButton getCOMP_UI_M_BUT_WAIT_PERIOD() {
		return COMP_UI_M_BUT_WAIT_PERIOD;
	}
	public void setCOMP_UI_M_BUT_WAIT_PERIOD(
			HtmlCommandButton comp_ui_m_but_wait_period) {
		COMP_UI_M_BUT_WAIT_PERIOD = comp_ui_m_but_wait_period;
	}

}
