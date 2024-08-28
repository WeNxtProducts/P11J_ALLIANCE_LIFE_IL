package com.iii.pel.forms.PILP_WHA;

import java.util.Date;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class DUMMY extends BaseValueBean {
	private String UI_M_AGENT_FM;
	private String UI_M_AGENT_TO;
	private Date UI_M_FM_DT;
	private Date UI_M_TO_DT;
	private String UI_M_WH_TYPE;
	private String UI_M_AGENT_FM_DESC;
	private String UI_M_AGENT_TO_DESC;
	
	public String getUI_M_AGENT_FM_DESC() {
		return UI_M_AGENT_FM_DESC;
	}
	public void setUI_M_AGENT_FM_DESC(String ui_m_AGENT_FM_desc) {
		UI_M_AGENT_FM_DESC = ui_m_AGENT_FM_desc;
	}
	public String getUI_M_AGENT_TO_DESC() {
		return UI_M_AGENT_TO_DESC;
	}
	public void setUI_M_AGENT_TO_DESC(String ui_m_AGENT_TO_desc) {
		UI_M_AGENT_TO_DESC = ui_m_AGENT_TO_desc;
	}
	public String getUI_M_AGENT_FM() {
		return UI_M_AGENT_FM;
	}
	public void setUI_M_AGENT_FM(String ui_m_AGENT_FM) {
		UI_M_AGENT_FM = ui_m_AGENT_FM;
	}
	public String getUI_M_AGENT_TO() {
		return UI_M_AGENT_TO;
	}
	public void setUI_M_AGENT_TO(String ui_m_AGENT_TO) {
		UI_M_AGENT_TO = ui_m_AGENT_TO;
	}
	public Date getUI_M_FM_DT() {
		return UI_M_FM_DT;
	}
	public void setUI_M_FM_DT(Date ui_m_fm_dt) {
		UI_M_FM_DT = ui_m_fm_dt;
	}
	public Date getUI_M_TO_DT() {
		return UI_M_TO_DT;
	}
	public void setUI_M_TO_DT(Date ui_m_to_dt) {
		UI_M_TO_DT = ui_m_to_dt;
	}
	public String getUI_M_WH_TYPE() {
		return UI_M_WH_TYPE;
	}
	public void setUI_M_WH_TYPE(String ui_m_wh_type) {
		UI_M_WH_TYPE = ui_m_wh_type;
	}
	
	
}
