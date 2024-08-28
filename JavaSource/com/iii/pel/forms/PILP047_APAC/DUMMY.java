package com.iii.pel.forms.PILP047_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name="")
public class DUMMY {

	private String  UI_M_POL_NO_FM;

	private String UI_M_POL_NO_TO;

	private Date UI_M_PROCESS_DT;
	
	private Date UI_M_PROCESS_TO_DT;

	public String getUI_M_POL_NO_FM() {
		return UI_M_POL_NO_FM;
	}

	public void setUI_M_POL_NO_FM(String ui_m_pol_no_fm) {
		UI_M_POL_NO_FM = ui_m_pol_no_fm;
	}

	public String getUI_M_POL_NO_TO() {
		return UI_M_POL_NO_TO;
	}

	public void setUI_M_POL_NO_TO(String ui_m_pol_no_to) {
		UI_M_POL_NO_TO = ui_m_pol_no_to;
	}

	public Date getUI_M_PROCESS_DT() {
		return UI_M_PROCESS_DT;
	}

	public void setUI_M_PROCESS_DT(Date ui_m_process_dt) {
		UI_M_PROCESS_DT = ui_m_process_dt;
	}

	public Date getUI_M_PROCESS_TO_DT() {
		return UI_M_PROCESS_TO_DT;
	}

	public void setUI_M_PROCESS_TO_DT(Date ui_m_process_to_dt) {
		UI_M_PROCESS_TO_DT = ui_m_process_to_dt;
	}

}
	
