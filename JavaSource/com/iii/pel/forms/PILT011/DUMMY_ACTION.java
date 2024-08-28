package com.iii.pel.forms.PILT011;

import javax.faces.component.html.HtmlCommandButton;


public class DUMMY_ACTION {

	private DUMMY DUMMY_BEAN;
	
	private HtmlCommandButton COMP_UI_M_BUT_ESTIMATE;
	
	private HtmlCommandButton COMP_UI_M_BUT_SETTLEMENT;
	
	private HtmlCommandButton UI_M_BUT_FAC_ESTIMATE;
	
	private HtmlCommandButton COMP_UI_M_BUT_FAC_SETTLEMENT;
	
	public PILT011_COMPOSITE_ACTION compositeAction;

	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
		instantiateAllComponent();
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ESTIMATE() {
		return COMP_UI_M_BUT_ESTIMATE;
	}

	public void setCOMP_UI_M_BUT_ESTIMATE(HtmlCommandButton comp_ui_m_but_estimate) {
		COMP_UI_M_BUT_ESTIMATE = comp_ui_m_but_estimate;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_SETTLEMENT() {
		return COMP_UI_M_BUT_SETTLEMENT;
	}

	public void setCOMP_UI_M_BUT_SETTLEMENT(
			HtmlCommandButton comp_ui_m_but_settlement) {
		COMP_UI_M_BUT_SETTLEMENT = comp_ui_m_but_settlement;
	}

	public HtmlCommandButton getUI_M_BUT_FAC_ESTIMATE() {
		return UI_M_BUT_FAC_ESTIMATE;
	}

	public void setUI_M_BUT_FAC_ESTIMATE(HtmlCommandButton ui_m_but_fac_estimate) {
		UI_M_BUT_FAC_ESTIMATE = ui_m_but_fac_estimate;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_FAC_SETTLEMENT() {
		return COMP_UI_M_BUT_FAC_SETTLEMENT;
	}

	public void setCOMP_UI_M_BUT_FAC_SETTLEMENT(
			HtmlCommandButton comp_ui_m_but_fac_settlement) {
		COMP_UI_M_BUT_FAC_SETTLEMENT = comp_ui_m_but_fac_settlement;
	}
	
	public void instantiateAllComponent(){
		
		COMP_UI_M_BUT_ESTIMATE = new HtmlCommandButton();
		COMP_UI_M_BUT_SETTLEMENT = new HtmlCommandButton();
		UI_M_BUT_FAC_ESTIMATE = new HtmlCommandButton();
		COMP_UI_M_BUT_FAC_SETTLEMENT = new HtmlCommandButton();
	}
}
