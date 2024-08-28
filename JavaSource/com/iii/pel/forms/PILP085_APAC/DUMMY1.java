package com.iii.pel.forms.PILP085_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "")
public class DUMMY1 extends BaseValueBean {

	@Column(name = "HFH_POL_NO_FM")
	private String HFH_POL_NO_FM;

	@Column(name = "HFH_POL_NO_TO")
	private String HFH_POL_NO_TO;

	@Column(name = "HFH_ACNT_YEAR")
	private Double HFH_ACNT_YEAR;

	@Column(name = "HFH_DATE_FM")
	private Date HFH_DATE_FM;

	@Column(name = "HFH_DATE_TO")
	private Date HFH_DATE_TO;

	public String getHFH_POL_NO_FM() {
		return HFH_POL_NO_FM;
	}

	public void setHFH_POL_NO_FM(String HFH_POL_NO_FM) {
		this.HFH_POL_NO_FM = HFH_POL_NO_FM;
	}

	public String getHFH_POL_NO_TO() {
		return HFH_POL_NO_TO;
	}

	public void setHFH_POL_NO_TO(String HFH_POL_NO_TO) {
		this.HFH_POL_NO_TO = HFH_POL_NO_TO;
	}

	public Double getHFH_ACNT_YEAR() {
		return HFH_ACNT_YEAR;
	}

	public void setHFH_ACNT_YEAR(Double HFH_ACNT_YEAR) {
		this.HFH_ACNT_YEAR = HFH_ACNT_YEAR;
	}

	public Date getHFH_DATE_FM() {
		return HFH_DATE_FM;
	}

	public void setHFH_DATE_FM(Date HFH_DATE_FM) {
		this.HFH_DATE_FM = HFH_DATE_FM;
	}

	public Date getHFH_DATE_TO() {
		return HFH_DATE_TO;
	}

	public void setHFH_DATE_TO(Date HFH_DATE_TO) {
		this.HFH_DATE_TO = HFH_DATE_TO;
	}
}