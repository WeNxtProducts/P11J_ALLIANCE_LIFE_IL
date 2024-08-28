package com.iii.pel.forms.PILP020;

import javax.faces.component.html.HtmlCommandButton;


public class DUMMY_ACTION {

	private DUMMY DUMMY_BEAN;
	
	private HtmlCommandButton COMP_UI_M_BUT_PROCESS;
	
	private HtmlCommandButton COMP_UI_M_BUT_MON_END_PROCESS;

	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PROCESS() {
		return COMP_UI_M_BUT_PROCESS;
	}

	public void setCOMP_UI_M_BUT_PROCESS(HtmlCommandButton comp_ui_m_but_process) {
		COMP_UI_M_BUT_PROCESS = comp_ui_m_but_process;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MON_END_PROCESS() {
		return COMP_UI_M_BUT_MON_END_PROCESS;
	}

	public void setCOMP_UI_M_BUT_MON_END_PROCESS(
			HtmlCommandButton comp_ui_m_but_mon_end_process) {
		COMP_UI_M_BUT_MON_END_PROCESS = comp_ui_m_but_mon_end_process;
	}
}
