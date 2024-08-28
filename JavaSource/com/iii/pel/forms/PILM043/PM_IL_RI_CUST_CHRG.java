package com.iii.pel.forms.PILM043;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_RI_CUST_CHRG")
public class PM_IL_RI_CUST_CHRG extends BaseValueBean {

	@Column(name="RCC_RPS_CODE")
	private String RCC_RPS_CODE;
	
	@Column(name="RCC_RPCVR_CODE")
	private String RCC_RPCVR_CODE;

	@Column(name="RCC_RPCUST_CODE")
	private String RCC_RPCUST_CODE;

	@Column(name="RCC_SRNO")
	private Double RCC_SRNO;

	@Column(name="RCC_CHRG_TYPE")
	private String RCC_CHRG_TYPE;

	@Column(name="RCC_CHRG_CODE")
	private String RCC_CHRG_CODE;
	
	private String UI_M_RCC_CHRG_CODE_DESC;

	@Column(name="RCC_RATE")
	private Double RCC_RATE;

	@Column(name="RCC_RATE_PER")
	private Double RCC_RATE_PER;

	@Column(name="RCC_APPLY_PERIOD")
	private String RCC_APPLY_PERIOD;

	@Column(name="RCC_CUST_SHARE_PERC")
	private Double RCC_CUST_SHARE_PERC;
	
	@Column(name="RCC_CR_DT")
	private Date RCC_CR_DT;
	
	@Column(name="RCC_CR_UID")
	private String RCC_CR_UID;

	private boolean CHECKBOX;

	public boolean isCHECKBOX() {
		return CHECKBOX;
	}

	public void setCHECKBOX(boolean checkbox) {
		CHECKBOX = checkbox;
	}

	public String getRCC_RPCVR_CODE() {
		return RCC_RPCVR_CODE;
	}

	public void setRCC_RPCVR_CODE(String RCC_RPCVR_CODE) {
		this.RCC_RPCVR_CODE = RCC_RPCVR_CODE;
	}

	public String getRCC_RPCUST_CODE() {
		return RCC_RPCUST_CODE;
	}

	public void setRCC_RPCUST_CODE(String RCC_RPCUST_CODE) {
		this.RCC_RPCUST_CODE = RCC_RPCUST_CODE;
	}

	public Double getRCC_SRNO() {
		return RCC_SRNO;
	}

	public void setRCC_SRNO(Double RCC_SRNO) {
		this.RCC_SRNO = RCC_SRNO;
	}

	public String getRCC_CHRG_TYPE() {
		return RCC_CHRG_TYPE;
	}

	public void setRCC_CHRG_TYPE(String RCC_CHRG_TYPE) {
		this.RCC_CHRG_TYPE = RCC_CHRG_TYPE;
	}

	public String getRCC_CHRG_CODE() {
		return RCC_CHRG_CODE;
	}

	public void setRCC_CHRG_CODE(String RCC_CHRG_CODE) {
		this.RCC_CHRG_CODE = RCC_CHRG_CODE;
	}

	public Double getRCC_RATE() {
		return RCC_RATE;
	}

	public void setRCC_RATE(Double RCC_RATE) {
		this.RCC_RATE = RCC_RATE;
	}

	public Double getRCC_RATE_PER() {
		return RCC_RATE_PER;
	}

	public void setRCC_RATE_PER(Double RCC_RATE_PER) {
		this.RCC_RATE_PER = RCC_RATE_PER;
	}

	public String getRCC_APPLY_PERIOD() {
		return RCC_APPLY_PERIOD;
	}

	public void setRCC_APPLY_PERIOD(String RCC_APPLY_PERIOD) {
		this.RCC_APPLY_PERIOD = RCC_APPLY_PERIOD;
	}

	public Double getRCC_CUST_SHARE_PERC() {
		return RCC_CUST_SHARE_PERC;
	}

	public void setRCC_CUST_SHARE_PERC(Double RCC_CUST_SHARE_PERC) {
		this.RCC_CUST_SHARE_PERC = RCC_CUST_SHARE_PERC;
	}

	public Date getRCC_CR_DT() {
		return RCC_CR_DT;
	}

	public void setRCC_CR_DT(Date rcc_cr_dt) {
		RCC_CR_DT = rcc_cr_dt;
	}

	public String getRCC_CR_UID() {
		return RCC_CR_UID;
	}

	public void setRCC_CR_UID(String rcc_cr_uid) {
		RCC_CR_UID = rcc_cr_uid;
	}

	public String getRCC_RPS_CODE() {
		return RCC_RPS_CODE;
	}

	public void setRCC_RPS_CODE(String rcc_rps_code) {
		RCC_RPS_CODE = rcc_rps_code;
	}

	public String getUI_M_RCC_CHRG_CODE_DESC() {
		return UI_M_RCC_CHRG_CODE_DESC;
	}

	public void setUI_M_RCC_CHRG_CODE_DESC(String ui_m_rcc_chrg_code_desc) {
		UI_M_RCC_CHRG_CODE_DESC = ui_m_rcc_chrg_code_desc;
	}
}
