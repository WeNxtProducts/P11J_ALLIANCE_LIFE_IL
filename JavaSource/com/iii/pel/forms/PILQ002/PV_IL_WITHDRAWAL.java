package com.iii.pel.forms.PILQ002;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PV_IL_WITHDRAWAL")
public class PV_IL_WITHDRAWAL extends BaseValueBean{
	
	@Column(name="ROWID")
	private String ROWID;

	@Column(name="WD_NUMBER")
	private Integer WD_NUMBER;

	@Column(name="WD_DATE")
	private Date WD_DATE;

	@Column(name="WD_NET_FC_VALUE")
	private Double WD_NET_FC_VALUE;

	@Column(name="WD_NET_LC_VALUE")
	private Double WD_NET_LC_VALUE;

	@Column(name="WDC_RATE")
	private Double WDC_RATE;

	@Column(name="WDC_RATE_PER")
	private Double WDC_RATE_PER;

	@Column(name="WDC_FC_VALUE")
	private Double WDC_FC_VALUE;

	@Column(name="WDC_LC_VALUE")
	private Double WDC_LC_VALUE;



	public Integer getWD_NUMBER() {
		return WD_NUMBER;
	}

	public void setWD_NUMBER(Integer WD_NUMBER) {
		this.WD_NUMBER = WD_NUMBER;
	}

	public Date getWD_DATE() {
		 return WD_DATE;
	}

	public void setWD_DATE(Date WD_DATE) {
		this.WD_DATE = WD_DATE;
	}

	public Double getWD_NET_FC_VALUE() {
		return WD_NET_FC_VALUE;
	}

	public void setWD_NET_FC_VALUE(Double WD_NET_FC_VALUE) {
		this.WD_NET_FC_VALUE = WD_NET_FC_VALUE;
	}

	public Double getWD_NET_LC_VALUE() {
		return WD_NET_LC_VALUE;
	}

	public void setWD_NET_LC_VALUE(Double WD_NET_LC_VALUE) {
		this.WD_NET_LC_VALUE = WD_NET_LC_VALUE;
	}

	public Double getWDC_RATE() {
		return WDC_RATE;
	}

	public void setWDC_RATE(Double WDC_RATE) {
		this.WDC_RATE = WDC_RATE;
	}

	public Double getWDC_RATE_PER() {
		return WDC_RATE_PER;
	}

	public void setWDC_RATE_PER(Double WDC_RATE_PER) {
		this.WDC_RATE_PER = WDC_RATE_PER;
	}

	public Double getWDC_FC_VALUE() {
		return WDC_FC_VALUE;
	}

	public void setWDC_FC_VALUE(Double WDC_FC_VALUE) {
		this.WDC_FC_VALUE = WDC_FC_VALUE;
	}

	public Double getWDC_LC_VALUE() {
		return WDC_LC_VALUE;
	}

	public void setWDC_LC_VALUE(Double WDC_LC_VALUE) {
		this.WDC_LC_VALUE = WDC_LC_VALUE;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}
}
