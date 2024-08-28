package com.iii.pel.forms.PILP022;

import java.util.Date;

import com.iii.apps.persistence.Table;

@Table(name="")
public class PT_AGENT {

	private String UI_M_AGENT_CODE_FM;

	private String UI_M_UNIT_CODE_FM;

	private String UI_M_AGENCY_CODE_FM;

	private Date UI_M_FM_DT;

	private String UI_M_AGENT_CODE_TO;

	private String UI_M_UNIT_CODE_TO;

	private String UI_M_AGENCY_CODE_TO;

	private Date UI_M_TO_DT;
	
	private String sendFocus;

	public String getSendFocus() {
		return sendFocus;
	}

	public void setSendFocus(String sendFocus) {
		this.sendFocus = sendFocus;
	}

	public String getUI_M_AGENT_CODE_FM() {
		return UI_M_AGENT_CODE_FM;
	}

	public void setUI_M_AGENT_CODE_FM(String UI_M_AGENT_CODE_FM) {
		this.UI_M_AGENT_CODE_FM = UI_M_AGENT_CODE_FM;
	}

	public String getUI_M_UNIT_CODE_FM() {
		return UI_M_UNIT_CODE_FM;
	}

	public void setUI_M_UNIT_CODE_FM(String UI_M_UNIT_CODE_FM) {
		this.UI_M_UNIT_CODE_FM = UI_M_UNIT_CODE_FM;
	}

	public String getUI_M_AGENCY_CODE_FM() {
		return UI_M_AGENCY_CODE_FM;
	}

	public void setUI_M_AGENCY_CODE_FM(String UI_M_AGENCY_CODE_FM) {
		this.UI_M_AGENCY_CODE_FM = UI_M_AGENCY_CODE_FM;
	}

	public Date getUI_M_FM_DT() {
		 return UI_M_FM_DT;
	}

	public void setUI_M_FM_DT(Date UI_M_FM_DT) {
		this.UI_M_FM_DT = UI_M_FM_DT;
	}

	public String getUI_M_AGENT_CODE_TO() {
		return UI_M_AGENT_CODE_TO;
	}

	public void setUI_M_AGENT_CODE_TO(String UI_M_AGENT_CODE_TO) {
		this.UI_M_AGENT_CODE_TO = UI_M_AGENT_CODE_TO;
	}

	public String getUI_M_UNIT_CODE_TO() {
		return UI_M_UNIT_CODE_TO;
	}

	public void setUI_M_UNIT_CODE_TO(String UI_M_UNIT_CODE_TO) {
		this.UI_M_UNIT_CODE_TO = UI_M_UNIT_CODE_TO;
	}

	public String getUI_M_AGENCY_CODE_TO() {
		return UI_M_AGENCY_CODE_TO;
	}

	public void setUI_M_AGENCY_CODE_TO(String UI_M_AGENCY_CODE_TO) {
		this.UI_M_AGENCY_CODE_TO = UI_M_AGENCY_CODE_TO;
	}

	public Date getUI_M_TO_DT() {
		 return UI_M_TO_DT;
	}

	public void setUI_M_TO_DT(Date UI_M_TO_DT) {
		this.UI_M_TO_DT = UI_M_TO_DT;
	}
}
