package com.iii.pel.forms.PILQ116_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_PAYVOU_AMT_DTL")
public class PT_IL_PAYVOU_AMT_DTL extends BaseValueBean {

	@Column(name = "PAD_SYS_ID")
	private Long PAD_SYS_ID;

	@Column(name = "PAD_PAH_SYS_ID")
	private Long PAD_PAH_SYS_ID;

	@Column(name = "PAD_CUST_CODE")
	private String PAD_CUST_CODE;

	@Column(name = "PAD_CURR_CODE")
	private String PAD_CURR_CODE;

	@Column(name = "PAD_FC_CR_TOT_AMT")
	private Double PAD_FC_CR_TOT_AMT;

	@Column(name = "PAD_LC_CR_TOT_AMT")
	private Double PAD_LC_CR_TOT_AMT;

	@Column(name = "PAD_FC_DR_TOT_AMT")
	private Double PAD_FC_DR_TOT_AMT;

	@Column(name = "PAD_LC_DR_TOT_AMT")
	private Double PAD_LC_DR_TOT_AMT;

	@Column(name = "PAD_FC_BAL_AMT")
	private Double PAD_FC_BAL_AMT;

	@Column(name = "PAD_LC_BAL_AMT")
	private Double PAD_LC_BAL_AMT;

	@Column(name = "PAD_LC_INVESTMENT_AMT")
	private Double PAD_LC_INVESTMENT_AMT;

	@Column(name = "PAD_LC_RISK_AMT")
	private Double PAD_LC_RISK_AMT;

	@Column(name = "PAD_CR_DT")
	private Date PAD_CR_DT;

	@Column(name = "PAD_CR_UID")
	private String PAD_CR_UID;

	@Column(name = "PAD_UPD_DT")
	private Date PAD_UPD_DT;

	@Column(name = "PAD_UPD_UID")
	private String PAD_UPD_UID;

	public void setPAD_CR_DT(Date PAD_CR_DT) {
		this.PAD_CR_DT = PAD_CR_DT;
	}

	public Date getPAD_CR_DT() {
		return PAD_CR_DT;
	}

	public void setPAD_LC_BAL_AMT(Double PAD_LC_BAL_AMT) {
		this.PAD_LC_BAL_AMT = PAD_LC_BAL_AMT;
	}

	public Double getPAD_LC_BAL_AMT() {
		return PAD_LC_BAL_AMT;
	}

	public void setPAD_UPD_UID(String PAD_UPD_UID) {
		this.PAD_UPD_UID = PAD_UPD_UID;
	}

	public String getPAD_UPD_UID() {
		return PAD_UPD_UID;
	}

	public void setPAD_FC_CR_TOT_AMT(Double PAD_FC_CR_TOT_AMT) {
		this.PAD_FC_CR_TOT_AMT = PAD_FC_CR_TOT_AMT;
	}

	public Double getPAD_FC_CR_TOT_AMT() {
		return PAD_FC_CR_TOT_AMT;
	}

	public void setPAD_SYS_ID(Long PAD_SYS_ID) {
		this.PAD_SYS_ID = PAD_SYS_ID;
	}

	public Long getPAD_SYS_ID() {
		return PAD_SYS_ID;
	}

	public void setPAD_LC_INVESTMENT_AMT(Double PAD_LC_INVESTMENT_AMT) {
		this.PAD_LC_INVESTMENT_AMT = PAD_LC_INVESTMENT_AMT;
	}

	public Double getPAD_LC_INVESTMENT_AMT() {
		return PAD_LC_INVESTMENT_AMT;
	}

	public void setPAD_CR_UID(String PAD_CR_UID) {
		this.PAD_CR_UID = PAD_CR_UID;
	}

	public String getPAD_CR_UID() {
		return PAD_CR_UID;
	}

	public void setPAD_CURR_CODE(String PAD_CURR_CODE) {
		this.PAD_CURR_CODE = PAD_CURR_CODE;
	}

	public String getPAD_CURR_CODE() {
		return PAD_CURR_CODE;
	}

	public void setPAD_FC_DR_TOT_AMT(Double PAD_FC_DR_TOT_AMT) {
		this.PAD_FC_DR_TOT_AMT = PAD_FC_DR_TOT_AMT;
	}

	public Double getPAD_FC_DR_TOT_AMT() {
		return PAD_FC_DR_TOT_AMT;
	}

	public void setPAD_UPD_DT(Date PAD_UPD_DT) {
		this.PAD_UPD_DT = PAD_UPD_DT;
	}

	public Date getPAD_UPD_DT() {
		return PAD_UPD_DT;
	}

	public void setPAD_CUST_CODE(String PAD_CUST_CODE) {
		this.PAD_CUST_CODE = PAD_CUST_CODE;
	}

	public String getPAD_CUST_CODE() {
		return PAD_CUST_CODE;
	}

	public void setPAD_LC_DR_TOT_AMT(Double PAD_LC_DR_TOT_AMT) {
		this.PAD_LC_DR_TOT_AMT = PAD_LC_DR_TOT_AMT;
	}

	public Double getPAD_LC_DR_TOT_AMT() {
		return PAD_LC_DR_TOT_AMT;
	}

	public void setPAD_LC_CR_TOT_AMT(Double PAD_LC_CR_TOT_AMT) {
		this.PAD_LC_CR_TOT_AMT = PAD_LC_CR_TOT_AMT;
	}

	public Double getPAD_LC_CR_TOT_AMT() {
		return PAD_LC_CR_TOT_AMT;
	}

	public void setPAD_PAH_SYS_ID(Long PAD_PAH_SYS_ID) {
		this.PAD_PAH_SYS_ID = PAD_PAH_SYS_ID;
	}

	public Long getPAD_PAH_SYS_ID() {
		return PAD_PAH_SYS_ID;
	}

	public void setPAD_FC_BAL_AMT(Double PAD_FC_BAL_AMT) {
		this.PAD_FC_BAL_AMT = PAD_FC_BAL_AMT;
	}

	public Double getPAD_FC_BAL_AMT() {
		return PAD_FC_BAL_AMT;
	}

	public void setPAD_LC_RISK_AMT(Double PAD_LC_RISK_AMT) {
		this.PAD_LC_RISK_AMT = PAD_LC_RISK_AMT;
	}

	public Double getPAD_LC_RISK_AMT() {
		return PAD_LC_RISK_AMT;
	}

}