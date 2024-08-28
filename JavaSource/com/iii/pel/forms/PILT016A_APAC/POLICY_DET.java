package com.iii.pel.forms.PILT016A_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class POLICY_DET extends BaseValueBean {

	@Column(name="UI_M_POL_NO")
	private String UI_M_POL_NO;

	@Column(name="UI_M_MODE_OF_PYMT")
	private String UI_M_MODE_OF_PYMT;

	@Column(name="UI_M_PAY_DUE_DT")
	private Date UI_M_PAY_DUE_DT;

	@Column(name="UI_M_AGENT_CODE")
	private String UI_M_AGENT_CODE;

	@Column(name="UI_M_AGENT_NAME")
	private String UI_M_AGENT_NAME;

	@Column(name="UI_M_MODAL_PREM")
	private Double UI_M_MODAL_PREM;



	public String getUI_M_POL_NO() {
		return UI_M_POL_NO;
	}

	public void setUI_M_POL_NO(String UI_M_POL_NO) {
		this.UI_M_POL_NO = UI_M_POL_NO;
	}

	public String getUI_M_MODE_OF_PYMT() {
		return UI_M_MODE_OF_PYMT;
	}

	public void setUI_M_MODE_OF_PYMT(String UI_M_MODE_OF_PYMT) {
		this.UI_M_MODE_OF_PYMT = UI_M_MODE_OF_PYMT;
	}

	public Date getUI_M_PAY_DUE_DT() {
		 return UI_M_PAY_DUE_DT;
	}

	public void setUI_M_PAY_DUE_DT(Date UI_M_PAY_DUE_DT) {
		this.UI_M_PAY_DUE_DT = UI_M_PAY_DUE_DT;
	}

	public String getUI_M_AGENT_CODE() {
		return UI_M_AGENT_CODE;
	}

	public void setUI_M_AGENT_CODE(String UI_M_AGENT_CODE) {
		this.UI_M_AGENT_CODE = UI_M_AGENT_CODE;
	}

	public String getUI_M_AGENT_NAME() {
		return UI_M_AGENT_NAME;
	}

	public void setUI_M_AGENT_NAME(String UI_M_AGENT_NAME) {
		this.UI_M_AGENT_NAME = UI_M_AGENT_NAME;
	}

	public Double getUI_M_MODAL_PREM() {
		return UI_M_MODAL_PREM;
	}

	public void setUI_M_MODAL_PREM(Double UI_M_MODAL_PREM) {
		this.UI_M_MODAL_PREM = UI_M_MODAL_PREM;
	}
}
