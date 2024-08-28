package com.iii.pel.forms.PILP084_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class JOBS_SCHD extends BaseValueBean {

	private String UI_M_PRCSS_NAME;

	private String UI_M_PRCSS_NAME_DESC;

	private Date UI_M_SCHD_INSTANCE;

	private Double UI_M_SCHD_INTERVAL;

	@Column(name="UI_M_SCHD_JOB_YN")
	private String UI_M_SCHD_JOB_YN;



	public String getUI_M_PRCSS_NAME() {
		return UI_M_PRCSS_NAME;
	}

	public void setUI_M_PRCSS_NAME(String UI_M_PRCSS_NAME) {
		this.UI_M_PRCSS_NAME = UI_M_PRCSS_NAME;
	}

	public String getUI_M_PRCSS_NAME_DESC() {
		return UI_M_PRCSS_NAME_DESC;
	}

	public void setUI_M_PRCSS_NAME_DESC(String UI_M_PRCSS_NAME_DESC) {
		this.UI_M_PRCSS_NAME_DESC = UI_M_PRCSS_NAME_DESC;
	}

	public Date getUI_M_SCHD_INSTANCE() {
		 return UI_M_SCHD_INSTANCE;
	}

	public void setUI_M_SCHD_INSTANCE(Date UI_M_SCHD_INSTANCE) {
		this.UI_M_SCHD_INSTANCE = UI_M_SCHD_INSTANCE;
	}

	public Double getUI_M_SCHD_INTERVAL() {
		return UI_M_SCHD_INTERVAL;
	}

	public void setUI_M_SCHD_INTERVAL(Double UI_M_SCHD_INTERVAL) {
		this.UI_M_SCHD_INTERVAL = UI_M_SCHD_INTERVAL;
	}

	public String getUI_M_SCHD_JOB_YN() {
		return UI_M_SCHD_JOB_YN;
	}

	public void setUI_M_SCHD_JOB_YN(String UI_M_SCHD_JOB_YN) {
		this.UI_M_SCHD_JOB_YN = UI_M_SCHD_JOB_YN;
	}
}