package com.iii.pel.forms.PILQ003;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POL_CHARGE")
public class PT_IL_POL_CHARGE extends BaseValueBean {

	@Column(name="POC_SYS_ID")
	private Long POC_SYS_ID;

	@Column(name="POC_POL_SYS_ID")
	private Long POC_POL_SYS_ID;

	@Column(name="POC_CHRG_CODE")
	private String POC_CHRG_CODE;

	@Column(name="POC_LC_VALUE")
	private Double POC_LC_VALUE;

	@Column(name="POC_FC_VALUE")
	private Double POC_FC_VALUE;

	@Column(name="POC_ORG_LC_VALUE")
	private Double POC_ORG_LC_VALUE;

	@Column(name="POC_ORG_FC_VALUE")
	private Double POC_ORG_FC_VALUE;

	@Column(name="POC_DEL_FLAG")
	private String POC_DEL_FLAG;

	@Column(name="POC_CR_DT")
	private Date POC_CR_DT;

	@Column(name="POC_CR_UID")
	private String POC_CR_UID;

	@Column(name="POC_UPD_DT")
	private Date POC_UPD_DT;

	@Column(name="POC_UPD_UID")
	private String POC_UPD_UID;

	@Column(name="POC_RATE")
	private Double POC_RATE;

	@Column(name="POC_RATE_PER")
	private Double POC_RATE_PER;

	@Column(name="POC_APPLIED_ON")
	private String POC_APPLIED_ON;

	@Column(name="POC_CUST_SHARE_PERC")
	private Double POC_CUST_SHARE_PERC;

	@Column(name="POC_APPLY_PERIOD")
	private String POC_APPLY_PERIOD;

	@Column(name="POC_TYPE")
	private String POC_TYPE;

	private String UI_M_POC_CHARGE_DESC;
	
	public void setPOC_CUST_SHARE_PERC(Double POC_CUST_SHARE_PERC) {
		this.POC_CUST_SHARE_PERC = POC_CUST_SHARE_PERC;
	}
	public Double getPOC_CUST_SHARE_PERC() {
		 return POC_CUST_SHARE_PERC;
	}
	public void setPOC_UPD_UID(String POC_UPD_UID) {
		this.POC_UPD_UID = POC_UPD_UID;
	}
	public String getPOC_UPD_UID() {
		 return POC_UPD_UID;
	}
	public void setPOC_LC_VALUE(Double POC_LC_VALUE) {
		this.POC_LC_VALUE = POC_LC_VALUE;
	}
	public Double getPOC_LC_VALUE() {
		 return POC_LC_VALUE;
	}
	public void setPOC_CR_DT(Date POC_CR_DT) {
		this.POC_CR_DT = POC_CR_DT;
	}
	public Date getPOC_CR_DT() {
		 return POC_CR_DT;
	}
	public void setPOC_APPLIED_ON(String POC_APPLIED_ON) {
		this.POC_APPLIED_ON = POC_APPLIED_ON;
	}
	public String getPOC_APPLIED_ON() {
		 return POC_APPLIED_ON;
	}
	public void setPOC_SYS_ID(Long POC_SYS_ID) {
		this.POC_SYS_ID = POC_SYS_ID;
	}
	public Long getPOC_SYS_ID() {
		 return POC_SYS_ID;
	}
	public void setPOC_ORG_LC_VALUE(Double POC_ORG_LC_VALUE) {
		this.POC_ORG_LC_VALUE = POC_ORG_LC_VALUE;
	}
	public Double getPOC_ORG_LC_VALUE() {
		 return POC_ORG_LC_VALUE;
	}
	public void setPOC_ORG_FC_VALUE(Double POC_ORG_FC_VALUE) {
		this.POC_ORG_FC_VALUE = POC_ORG_FC_VALUE;
	}
	public Double getPOC_ORG_FC_VALUE() {
		 return POC_ORG_FC_VALUE;
	}
	public void setPOC_CHRG_CODE(String POC_CHRG_CODE) {
		this.POC_CHRG_CODE = POC_CHRG_CODE;
	}
	public String getPOC_CHRG_CODE() {
		 return POC_CHRG_CODE;
	}
	public void setPOC_FC_VALUE(Double POC_FC_VALUE) {
		this.POC_FC_VALUE = POC_FC_VALUE;
	}
	public Double getPOC_FC_VALUE() {
		 return POC_FC_VALUE;
	}
	public void setPOC_RATE_PER(Double POC_RATE_PER) {
		this.POC_RATE_PER = POC_RATE_PER;
	}
	public Double getPOC_RATE_PER() {
		 return POC_RATE_PER;
	}
	public void setUI_M_POC_CHARGE_DESC(String UI_M_POC_CHARGE_DESC) {
		this.UI_M_POC_CHARGE_DESC = UI_M_POC_CHARGE_DESC;
	}
	public String getUI_M_POC_CHARGE_DESC() {
		 return UI_M_POC_CHARGE_DESC;
	}
	public void setPOC_TYPE(String POC_TYPE) {
		this.POC_TYPE = POC_TYPE;
	}
	public String getPOC_TYPE() {
		 return POC_TYPE;
	}
	public void setPOC_POL_SYS_ID(Long POC_POL_SYS_ID) {
		this.POC_POL_SYS_ID = POC_POL_SYS_ID;
	}
	public Long getPOC_POL_SYS_ID() {
		 return POC_POL_SYS_ID;
	}
	public void setPOC_UPD_DT(Date POC_UPD_DT) {
		this.POC_UPD_DT = POC_UPD_DT;
	}
	public Date getPOC_UPD_DT() {
		 return POC_UPD_DT;
	}
	public void setPOC_CR_UID(String POC_CR_UID) {
		this.POC_CR_UID = POC_CR_UID;
	}
	public String getPOC_CR_UID() {
		 return POC_CR_UID;
	}
	public void setPOC_APPLY_PERIOD(String POC_APPLY_PERIOD) {
		this.POC_APPLY_PERIOD = POC_APPLY_PERIOD;
	}
	public String getPOC_APPLY_PERIOD() {
		 return POC_APPLY_PERIOD;
	}
	public void setPOC_RATE(Double POC_RATE) {
		this.POC_RATE = POC_RATE;
	}
	public Double getPOC_RATE() {
		 return POC_RATE;
	}
	public void setPOC_DEL_FLAG(String POC_DEL_FLAG) {
		this.POC_DEL_FLAG = POC_DEL_FLAG;
	}
	public String getPOC_DEL_FLAG() {
		 return POC_DEL_FLAG;
	}

}
