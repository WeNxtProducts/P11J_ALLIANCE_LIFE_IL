package com.iii.pel.forms.PILT020;

import java.util.Date;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
@Table(name="")
public class DUMMY1 extends BaseValueBean {

	private String UI_M_EMPLOYER_CODE;

	private String UI_M_EMPLOYER_CODE_DESC;

	private String UI_M_CONTRACTOR_CODE;

	private String UI_M_CONTRACTOR_CODE_DESC;

	private Date UI_M_DUE_PERIOD_FM;

	private Date UI_M_DUE_PERIOD_TO;

	private String UI_M_POL_CURR_CODE;

	private String UI_M_CURR_NAME;

	private Date UI_M_PAID_DT;



	public String getUI_M_EMPLOYER_CODE() {
		return UI_M_EMPLOYER_CODE;
	}

	public void setUI_M_EMPLOYER_CODE(String UI_M_EMPLOYER_CODE) {
		this.UI_M_EMPLOYER_CODE = UI_M_EMPLOYER_CODE;
	}

	public String getUI_M_EMPLOYER_CODE_DESC() {
		return UI_M_EMPLOYER_CODE_DESC;
	}

	public void setUI_M_EMPLOYER_CODE_DESC(String UI_M_EMPLOYER_CODE_DESC) {
		this.UI_M_EMPLOYER_CODE_DESC = UI_M_EMPLOYER_CODE_DESC;
	}

	public String getUI_M_CONTRACTOR_CODE() {
		return UI_M_CONTRACTOR_CODE;
	}

	public void setUI_M_CONTRACTOR_CODE(String UI_M_CONTRACTOR_CODE) {
		this.UI_M_CONTRACTOR_CODE = UI_M_CONTRACTOR_CODE;
	}

	public String getUI_M_CONTRACTOR_CODE_DESC() {
		return UI_M_CONTRACTOR_CODE_DESC;
	}

	public void setUI_M_CONTRACTOR_CODE_DESC(String UI_M_CONTRACTOR_CODE_DESC) {
		this.UI_M_CONTRACTOR_CODE_DESC = UI_M_CONTRACTOR_CODE_DESC;
	}

	public Date getUI_M_DUE_PERIOD_FM() {
		 return UI_M_DUE_PERIOD_FM;
	}

	public void setUI_M_DUE_PERIOD_FM(Date UI_M_DUE_PERIOD_FM) {
		this.UI_M_DUE_PERIOD_FM = UI_M_DUE_PERIOD_FM;
	}

	public Date getUI_M_DUE_PERIOD_TO() {
		 return UI_M_DUE_PERIOD_TO;
	}

	public void setUI_M_DUE_PERIOD_TO(Date UI_M_DUE_PERIOD_TO) {
		this.UI_M_DUE_PERIOD_TO = UI_M_DUE_PERIOD_TO;
	}

	public String getUI_M_POL_CURR_CODE() {
		return UI_M_POL_CURR_CODE;
	}

	public void setUI_M_POL_CURR_CODE(String UI_M_POL_CURR_CODE) {
		this.UI_M_POL_CURR_CODE = UI_M_POL_CURR_CODE;
	}

	public String getUI_M_CURR_NAME() {
		return UI_M_CURR_NAME;
	}

	public void setUI_M_CURR_NAME(String UI_M_CURR_NAME) {
		this.UI_M_CURR_NAME = UI_M_CURR_NAME;
	}

	public Date getUI_M_PAID_DT() {
		 return UI_M_PAID_DT;
	}

	public void setUI_M_PAID_DT(Date UI_M_PAID_DT) {
		this.UI_M_PAID_DT = UI_M_PAID_DT;
	}
}
