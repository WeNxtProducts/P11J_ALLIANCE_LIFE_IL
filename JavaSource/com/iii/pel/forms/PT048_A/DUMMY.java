package com.iii.pel.forms.PT048_A;

import java.util.Date;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class DUMMY extends BaseValueBean {

	private String UI_M_AGENT_FM_CODE;

	private String UI_M_AGENT_TO_CODE;

	private String UI_M_AGENT_FM_RANK_CODE;

	private String UI_M_AGENT_TO_RANK_CODE;

	private Date UI_M_AGENT_FM_PROCESS_DT;

	private Date UI_M_AGENT_TO_PROCESS_DT;

	private String UI_M_AGENT_FM_NAME;

	private String UI_M_AGENT_TO_NAME;

	private String UI_M_AGENT_FM_RANK_CODE_DESC;

	private String UI_M_AGENT_TO_RANK_CODE_DESC;
	
	private String UI_M_BASE_CURR;
	
	public String focus;

	public String getFocus() {
		return focus;
	}

	public void setFocus(String focus) {
		this.focus = focus;
	}

	public String getUI_M_AGENT_FM_CODE() {
		return UI_M_AGENT_FM_CODE;
	}

	public void setUI_M_AGENT_FM_CODE(String UI_M_AGENT_FM_CODE) {
		this.UI_M_AGENT_FM_CODE = UI_M_AGENT_FM_CODE;
	}

	public String getUI_M_AGENT_TO_CODE() {
		return UI_M_AGENT_TO_CODE;
	}

	public void setUI_M_AGENT_TO_CODE(String UI_M_AGENT_TO_CODE) {
		this.UI_M_AGENT_TO_CODE = UI_M_AGENT_TO_CODE;
	}

	public String getUI_M_AGENT_FM_RANK_CODE() {
		return UI_M_AGENT_FM_RANK_CODE;
	}

	public void setUI_M_AGENT_FM_RANK_CODE(String UI_M_AGENT_FM_RANK_CODE) {
		this.UI_M_AGENT_FM_RANK_CODE = UI_M_AGENT_FM_RANK_CODE;
	}

	public String getUI_M_AGENT_TO_RANK_CODE() {
		return UI_M_AGENT_TO_RANK_CODE;
	}

	public void setUI_M_AGENT_TO_RANK_CODE(String UI_M_AGENT_TO_RANK_CODE) {
		this.UI_M_AGENT_TO_RANK_CODE = UI_M_AGENT_TO_RANK_CODE;
	}

	public Date getUI_M_AGENT_FM_PROCESS_DT() {
		 return UI_M_AGENT_FM_PROCESS_DT;
	}

	public void setUI_M_AGENT_FM_PROCESS_DT(Date UI_M_AGENT_FM_PROCESS_DT) {
		this.UI_M_AGENT_FM_PROCESS_DT = UI_M_AGENT_FM_PROCESS_DT;
	}

	public Date getUI_M_AGENT_TO_PROCESS_DT() {
		 return UI_M_AGENT_TO_PROCESS_DT;
	}

	public void setUI_M_AGENT_TO_PROCESS_DT(Date UI_M_AGENT_TO_PROCESS_DT) {
		this.UI_M_AGENT_TO_PROCESS_DT = UI_M_AGENT_TO_PROCESS_DT;
	}

	public String getUI_M_AGENT_FM_NAME() {
		return UI_M_AGENT_FM_NAME;
	}

	public void setUI_M_AGENT_FM_NAME(String UI_M_AGENT_FM_NAME) {
		this.UI_M_AGENT_FM_NAME = UI_M_AGENT_FM_NAME;
	}

	public String getUI_M_AGENT_TO_NAME() {
		return UI_M_AGENT_TO_NAME;
	}

	public void setUI_M_AGENT_TO_NAME(String UI_M_AGENT_TO_NAME) {
		this.UI_M_AGENT_TO_NAME = UI_M_AGENT_TO_NAME;
	}

	public String getUI_M_AGENT_FM_RANK_CODE_DESC() {
		return UI_M_AGENT_FM_RANK_CODE_DESC;
	}

	public void setUI_M_AGENT_FM_RANK_CODE_DESC(String UI_M_AGENT_FM_RANK_CODE_DESC) {
		this.UI_M_AGENT_FM_RANK_CODE_DESC = UI_M_AGENT_FM_RANK_CODE_DESC;
	}

	public String getUI_M_AGENT_TO_RANK_CODE_DESC() {
		return UI_M_AGENT_TO_RANK_CODE_DESC;
	}

	public void setUI_M_AGENT_TO_RANK_CODE_DESC(String UI_M_AGENT_TO_RANK_CODE_DESC) {
		this.UI_M_AGENT_TO_RANK_CODE_DESC = UI_M_AGENT_TO_RANK_CODE_DESC;
	}

	public String getUI_M_BASE_CURR() {
		return UI_M_BASE_CURR;
	}

	public void setUI_M_BASE_CURR(String ui_m_base_curr) {
		UI_M_BASE_CURR = ui_m_base_curr;
	}
}
