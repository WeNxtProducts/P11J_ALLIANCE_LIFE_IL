package com.iii.pel.forms.PILP032_TISB;

import java.util.Date;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class DUMMY extends BaseValueBean {

	private String UI_M_FM_AGENT_CODE;

	private String UI_M_FM_AGENT_DESC;

	private String UI_M_TO_AGENT_CODE;

	private String UI_M_TO_AGENT_DESC;

	private Date UI_M_FM_DATE;

	private Date UI_M_TO_DATE;

	private Date UI_M_PROCESS_DATE;
	
	private String labelCaption;



	public String getUI_M_FM_AGENT_CODE() {
		return UI_M_FM_AGENT_CODE;
	}

	public void setUI_M_FM_AGENT_CODE(String UI_M_FM_AGENT_CODE) {
		this.UI_M_FM_AGENT_CODE = UI_M_FM_AGENT_CODE;
	}

	public String getUI_M_FM_AGENT_DESC() {
		return UI_M_FM_AGENT_DESC;
	}

	public void setUI_M_FM_AGENT_DESC(String UI_M_FM_AGENT_DESC) {
		this.UI_M_FM_AGENT_DESC = UI_M_FM_AGENT_DESC;
	}

	public String getUI_M_TO_AGENT_CODE() {
		return UI_M_TO_AGENT_CODE;
	}

	public void setUI_M_TO_AGENT_CODE(String UI_M_TO_AGENT_CODE) {
		this.UI_M_TO_AGENT_CODE = UI_M_TO_AGENT_CODE;
	}

	public String getUI_M_TO_AGENT_DESC() {
		return UI_M_TO_AGENT_DESC;
	}

	public void setUI_M_TO_AGENT_DESC(String UI_M_TO_AGENT_DESC) {
		this.UI_M_TO_AGENT_DESC = UI_M_TO_AGENT_DESC;
	}

	public Date getUI_M_FM_DATE() {
		 return UI_M_FM_DATE;
	}

	public void setUI_M_FM_DATE(Date UI_M_FM_DATE) {
		this.UI_M_FM_DATE = UI_M_FM_DATE;
	}

	public Date getUI_M_TO_DATE() {
		 return UI_M_TO_DATE;
	}

	public void setUI_M_TO_DATE(Date UI_M_TO_DATE) {
		this.UI_M_TO_DATE = UI_M_TO_DATE;
	}

	public Date getUI_M_PROCESS_DATE() {
		 return UI_M_PROCESS_DATE;
	}

	public void setUI_M_PROCESS_DATE(Date UI_M_PROCESS_DATE) {
		this.UI_M_PROCESS_DATE = UI_M_PROCESS_DATE;
	}

	public String getLabelCaption() {
		return labelCaption;
	}

	public void setLabelCaption(String labelCaption) {
		this.labelCaption = labelCaption;
	}
}
