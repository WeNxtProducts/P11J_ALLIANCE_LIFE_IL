package com.iii.pel.forms.PILQ111_APAC;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_RI_PART_CUST_ALLOC")
public class PT_IL_RI_PART_CUST_ALLOC extends BaseValueBean {

	private Double RIPCA_SYS_ID;
	
	private String ROWID;
	
	private Double RIPCA_RIA_SYS_ID;
	
	@Column(name="RIPCA_CUST_CODE")
	private String RIPCA_CUST_CODE;

	@Column(name="RIPCA_SHARE_PERC")
	private Double RIPCA_SHARE_PERC;

	@Column(name="RIPCA_TTY_TYPE")
	private String RIPCA_TTY_TYPE;
	
	private Double RIPCA_SRNO;

	@Column(name="RIPCA_FC_PREMIUM")
	private Double RIPCA_FC_PREMIUM;

	@Column(name="RIPCA_LC_PREMIUM")
	private Double RIPCA_LC_PREMIUM;

	@Column(name="RIPCA_FC_COMMISSION")
	private Double RIPCA_FC_COMMISSION;

	@Column(name="RIPCA_LC_COMMISSION")
	private Double RIPCA_LC_COMMISSION;

	@Column(name="RIPCA_CLM_PAID")
	private Double RIPCA_CLM_PAID;

	@Column(name="RIPCA_CLAIMS_OS")
	private Double RIPCA_CLAIMS_OS;

	private String UI_M_CUST_NAME;

	private boolean selected;

	public String getRIPCA_CUST_CODE() {
		return RIPCA_CUST_CODE;
	}

	public void setRIPCA_CUST_CODE(String RIPCA_CUST_CODE) {
		this.RIPCA_CUST_CODE = RIPCA_CUST_CODE;
	}

	public Double getRIPCA_SHARE_PERC() {
		return RIPCA_SHARE_PERC;
	}

	public void setRIPCA_SHARE_PERC(Double RIPCA_SHARE_PERC) {
		this.RIPCA_SHARE_PERC = RIPCA_SHARE_PERC;
	}

	public String getRIPCA_TTY_TYPE() {
		return RIPCA_TTY_TYPE;
	}

	public void setRIPCA_TTY_TYPE(String RIPCA_TTY_TYPE) {
		this.RIPCA_TTY_TYPE = RIPCA_TTY_TYPE;
	}

	public Double getRIPCA_FC_PREMIUM() {
		return RIPCA_FC_PREMIUM;
	}

	public void setRIPCA_FC_PREMIUM(Double RIPCA_FC_PREMIUM) {
		this.RIPCA_FC_PREMIUM = RIPCA_FC_PREMIUM;
	}

	public Double getRIPCA_LC_PREMIUM() {
		return RIPCA_LC_PREMIUM;
	}

	public void setRIPCA_LC_PREMIUM(Double RIPCA_LC_PREMIUM) {
		this.RIPCA_LC_PREMIUM = RIPCA_LC_PREMIUM;
	}

	public Double getRIPCA_FC_COMMISSION() {
		return RIPCA_FC_COMMISSION;
	}

	public void setRIPCA_FC_COMMISSION(Double RIPCA_FC_COMMISSION) {
		this.RIPCA_FC_COMMISSION = RIPCA_FC_COMMISSION;
	}

	public Double getRIPCA_LC_COMMISSION() {
		return RIPCA_LC_COMMISSION;
	}

	public void setRIPCA_LC_COMMISSION(Double RIPCA_LC_COMMISSION) {
		this.RIPCA_LC_COMMISSION = RIPCA_LC_COMMISSION;
	}

	public Double getRIPCA_CLM_PAID() {
		return RIPCA_CLM_PAID;
	}

	public void setRIPCA_CLM_PAID(Double RIPCA_CLM_PAID) {
		this.RIPCA_CLM_PAID = RIPCA_CLM_PAID;
	}

	public Double getRIPCA_CLAIMS_OS() {
		return RIPCA_CLAIMS_OS;
	}

	public void setRIPCA_CLAIMS_OS(Double RIPCA_CLAIMS_OS) {
		this.RIPCA_CLAIMS_OS = RIPCA_CLAIMS_OS;
	}

	public String getUI_M_CUST_NAME() {
		return UI_M_CUST_NAME;
	}

	public void setUI_M_CUST_NAME(String UI_M_CUST_NAME) {
		this.UI_M_CUST_NAME = UI_M_CUST_NAME;
	}

	public Double getRIPCA_SYS_ID() {
		return RIPCA_SYS_ID;
	}

	public void setRIPCA_SYS_ID(Double ripca_sys_id) {
		RIPCA_SYS_ID = ripca_sys_id;
	}

	public Double getRIPCA_RIA_SYS_ID() {
		return RIPCA_RIA_SYS_ID;
	}

	public void setRIPCA_RIA_SYS_ID(Double ripca_ria_sys_id) {
		RIPCA_RIA_SYS_ID = ripca_ria_sys_id;
	}

	

	public Double getRIPCA_SRNO() {
		return RIPCA_SRNO;
	}

	public void setRIPCA_SRNO(Double ripca_srno) {
		RIPCA_SRNO = ripca_srno;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	
}
