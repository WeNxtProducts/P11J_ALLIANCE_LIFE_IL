package com.iii.pel.forms.PILT003_APAC;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

import org.richfaces.component.html.HtmlCalendar;

public class DUMMY_ACTION {

	private HtmlOutputLabel COMP_UI_M_REINS_DATE_LABEL;
	
	private HtmlInputText COMP_UI_M_BUT_LOAN_IN;

	private HtmlCalendar COMP_UI_M_REINS_DATE;

	private HtmlCommandButton COMP_UI_M_BUT_OK;

	private HtmlCommandButton COMP_UI_M_BUT_CANCEL;
	
	private HtmlCommandButton COMP_UI_M_BUT_FAC;
	
	private HtmlCommandButton COMP_UI_M_BUT_APPROVE;
	
	private HtmlCommandButton COMP_UI_M_BUT_BROKER_DTLS;
	
	private HtmlCommandButton COMP_UI_M_BUT_PYMT_DTLS;
	
	private HtmlCommandButton COMP_UI_M_BUT_REINSTATE;

	private DUMMY DUMMY_BEAN;
	
	public PILT003_APAC_COMPOSITE_ACTION compositeAction;

	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_UI_M_REINS_DATE_LABEL() {
		return COMP_UI_M_REINS_DATE_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_REINS_DATE() {
		return COMP_UI_M_REINS_DATE;
	}

	public void setCOMP_UI_M_REINS_DATE_LABEL(HtmlOutputLabel COMP_UI_M_REINS_DATE_LABEL) {
		this.COMP_UI_M_REINS_DATE_LABEL = COMP_UI_M_REINS_DATE_LABEL;
	}

	public void setCOMP_UI_M_REINS_DATE(HtmlCalendar COMP_UI_M_REINS_DATE) {
		this.COMP_UI_M_REINS_DATE = COMP_UI_M_REINS_DATE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_OK() {
		return COMP_UI_M_BUT_OK;
	}

	public void setCOMP_UI_M_BUT_OK(HtmlCommandButton COMP_UI_M_BUT_OK) {
		this.COMP_UI_M_BUT_OK = COMP_UI_M_BUT_OK;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CANCEL() {
		return COMP_UI_M_BUT_CANCEL;
	}

	public void setCOMP_UI_M_BUT_CANCEL(HtmlCommandButton COMP_UI_M_BUT_CANCEL) {
		this.COMP_UI_M_BUT_CANCEL = COMP_UI_M_BUT_CANCEL;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_FAC() {
		return COMP_UI_M_BUT_FAC;
	}

	public void setCOMP_UI_M_BUT_FAC(HtmlCommandButton comp_ui_m_but_fac) {
		COMP_UI_M_BUT_FAC = comp_ui_m_but_fac;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_APPROVE() {
		return COMP_UI_M_BUT_APPROVE;
	}

	public void setCOMP_UI_M_BUT_APPROVE(HtmlCommandButton comp_ui_m_but_approve) {
		COMP_UI_M_BUT_APPROVE = comp_ui_m_but_approve;
	}

	public HtmlInputText getCOMP_UI_M_BUT_LOAN_IN() {
		return COMP_UI_M_BUT_LOAN_IN;
	}

	public void setCOMP_UI_M_BUT_LOAN_IN(HtmlInputText comp_ui_m_but_loan_in) {
		COMP_UI_M_BUT_LOAN_IN = comp_ui_m_but_loan_in;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BROKER_DTLS() {
		return COMP_UI_M_BUT_BROKER_DTLS;
	}

	public void setCOMP_UI_M_BUT_BROKER_DTLS(
			HtmlCommandButton comp_ui_m_but_broker_dtls) {
		COMP_UI_M_BUT_BROKER_DTLS = comp_ui_m_but_broker_dtls;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PYMT_DTLS() {
		return COMP_UI_M_BUT_PYMT_DTLS;
	}

	public void setCOMP_UI_M_BUT_PYMT_DTLS(HtmlCommandButton comp_ui_m_but_pymt_dtls) {
		COMP_UI_M_BUT_PYMT_DTLS = comp_ui_m_but_pymt_dtls;
	}
	

	/**
	 * Instantiates all components in DUMMY_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_UI_M_BUT_LOAN_IN				 = new HtmlInputText();

		// Instantiating HtmlCalendar
		COMP_UI_M_REINS_DATE				 = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_OK				 = new HtmlCommandButton();
		COMP_UI_M_BUT_CANCEL				 = new HtmlCommandButton();
		COMP_UI_M_BUT_FAC				 = new HtmlCommandButton();
		COMP_UI_M_BUT_APPROVE				 = new HtmlCommandButton();
		COMP_UI_M_BUT_BROKER_DTLS			 = new HtmlCommandButton();
		COMP_UI_M_BUT_PYMT_DTLS				 = new HtmlCommandButton();
		COMP_UI_M_BUT_REINSTATE              = new HtmlCommandButton();

	}

	public HtmlCommandButton getCOMP_UI_M_BUT_REINSTATE() {
		return COMP_UI_M_BUT_REINSTATE;
	}

	public void setCOMP_UI_M_BUT_REINSTATE(HtmlCommandButton comp_ui_m_but_reinstate) {
		COMP_UI_M_BUT_REINSTATE = comp_ui_m_but_reinstate;
	}


}
