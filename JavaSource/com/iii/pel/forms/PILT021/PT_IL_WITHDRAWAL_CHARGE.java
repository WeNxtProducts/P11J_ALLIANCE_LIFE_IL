package com.iii.pel.forms.PILT021;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_WITHDRAWAL_CHARGE")
public class PT_IL_WITHDRAWAL_CHARGE extends BaseValueBean {

	@Column(name="WDC_SYS_ID")
	private Long WDC_SYS_ID;

	@Column(name="WDC_WD_SYS_ID")
	private Long WDC_WD_SYS_ID;

	@Column(name="WDC_CHRG_CODE")
	private String WDC_CHRG_CODE;

	@Column(name="WDC_RATE")
	private Double WDC_RATE;

	@Column(name="WDC_RATE_PER")
	private Double WDC_RATE_PER;

	@Column(name="WDC_CUST_SHARE_PERC")
	private Double WDC_CUST_SHARE_PERC;

	@Column(name="WDC_LC_VALUE")
	private Double WDC_LC_VALUE;

	@Column(name="WDC_FC_VALUE")
	private Double WDC_FC_VALUE;

	@Column(name="WDC_CR_DT")
	private Date WDC_CR_DT;

	@Column(name="WDC_CR_UID")
	private String WDC_CR_UID;

	@Column(name="WDC_UPD_DT")
	private Date WDC_UPD_DT;

	@Column(name="WDC_UPD_UID")
	private String WDC_UPD_UID;

	@Column(name="WDC_PREM_LC_VALUE")
	private Double WDC_PREM_LC_VALUE;

	@Column(name="WDC_PREM_FC_VALUE")
	private Double WDC_PREM_FC_VALUE;

	@Column(name="WDC_TOP_UP_LC_VALUE")
	private Double WDC_TOP_UP_LC_VALUE;

	@Column(name="WDC_TOP_UP_FC_VALUE")
	private Double WDC_TOP_UP_FC_VALUE;

	private String UI_M_WDC_CHARGE_DESC;
	public void setWDC_CHRG_CODE(String WDC_CHRG_CODE) {
		this.WDC_CHRG_CODE = WDC_CHRG_CODE;
	}
	public String getWDC_CHRG_CODE() {
		 return WDC_CHRG_CODE;
	}
	public void setWDC_TOP_UP_FC_VALUE(Double WDC_TOP_UP_FC_VALUE) {
		this.WDC_TOP_UP_FC_VALUE = WDC_TOP_UP_FC_VALUE;
	}
	public Double getWDC_TOP_UP_FC_VALUE() {
		 return WDC_TOP_UP_FC_VALUE;
	}
	public void setWDC_RATE_PER(Double WDC_RATE_PER) {
		this.WDC_RATE_PER = WDC_RATE_PER;
	}
	public Double getWDC_RATE_PER() {
		 return WDC_RATE_PER;
	}
	public void setUI_M_WDC_CHARGE_DESC(String UI_M_WDC_CHARGE_DESC) {
		this.UI_M_WDC_CHARGE_DESC = UI_M_WDC_CHARGE_DESC;
	}
	public String getUI_M_WDC_CHARGE_DESC() {
		 return UI_M_WDC_CHARGE_DESC;
	}
	public void setWDC_CR_DT(Date WDC_CR_DT) {
		this.WDC_CR_DT = WDC_CR_DT;
	}
	public Date getWDC_CR_DT() {
		 return WDC_CR_DT;
	}
	public void setWDC_PREM_FC_VALUE(Double WDC_PREM_FC_VALUE) {
		this.WDC_PREM_FC_VALUE = WDC_PREM_FC_VALUE;
	}
	public Double getWDC_PREM_FC_VALUE() {
		 return WDC_PREM_FC_VALUE;
	}
	public void setWDC_RATE(Double WDC_RATE) {
		this.WDC_RATE = WDC_RATE;
	}
	public Double getWDC_RATE() {
		 return WDC_RATE;
	}
	public void setWDC_CUST_SHARE_PERC(Double WDC_CUST_SHARE_PERC) {
		this.WDC_CUST_SHARE_PERC = WDC_CUST_SHARE_PERC;
	}
	public Double getWDC_CUST_SHARE_PERC() {
		 return WDC_CUST_SHARE_PERC;
	}
	public void setWDC_UPD_UID(String WDC_UPD_UID) {
		this.WDC_UPD_UID = WDC_UPD_UID;
	}
	public String getWDC_UPD_UID() {
		 return WDC_UPD_UID;
	}
	public void setWDC_CR_UID(String WDC_CR_UID) {
		this.WDC_CR_UID = WDC_CR_UID;
	}
	public String getWDC_CR_UID() {
		 return WDC_CR_UID;
	}
	public void setWDC_SYS_ID(Long WDC_SYS_ID) {
		this.WDC_SYS_ID = WDC_SYS_ID;
	}
	public Long getWDC_SYS_ID() {
		 return WDC_SYS_ID;
	}
	public void setWDC_WD_SYS_ID(Long WDC_WD_SYS_ID) {
		this.WDC_WD_SYS_ID = WDC_WD_SYS_ID;
	}
	public Long getWDC_WD_SYS_ID() {
		 return WDC_WD_SYS_ID;
	}
	public void setWDC_PREM_LC_VALUE(Double WDC_PREM_LC_VALUE) {
		this.WDC_PREM_LC_VALUE = WDC_PREM_LC_VALUE;
	}
	public Double getWDC_PREM_LC_VALUE() {
		 return WDC_PREM_LC_VALUE;
	}
	public void setWDC_TOP_UP_LC_VALUE(Double WDC_TOP_UP_LC_VALUE) {
		this.WDC_TOP_UP_LC_VALUE = WDC_TOP_UP_LC_VALUE;
	}
	public Double getWDC_TOP_UP_LC_VALUE() {
		 return WDC_TOP_UP_LC_VALUE;
	}
	public void setWDC_FC_VALUE(Double WDC_FC_VALUE) {
		this.WDC_FC_VALUE = WDC_FC_VALUE;
	}
	public Double getWDC_FC_VALUE() {
		 return WDC_FC_VALUE;
	}
	public void setWDC_LC_VALUE(Double WDC_LC_VALUE) {
		this.WDC_LC_VALUE = WDC_LC_VALUE;
	}
	public Double getWDC_LC_VALUE() {
		 return WDC_LC_VALUE;
	}
	public void setWDC_UPD_DT(Date WDC_UPD_DT) {
		this.WDC_UPD_DT = WDC_UPD_DT;
	}
	public Date getWDC_UPD_DT() {
		 return WDC_UPD_DT;
	}

}
