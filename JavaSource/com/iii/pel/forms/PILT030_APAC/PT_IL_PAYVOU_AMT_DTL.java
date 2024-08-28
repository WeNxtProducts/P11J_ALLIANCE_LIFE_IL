package com.iii.pel.forms.PILT030_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_PAYVOU_AMT_DTL")
public class PT_IL_PAYVOU_AMT_DTL extends BaseValueBean {
	
	//private boolean selected = false;
	
	//private String rowSelected;

	@Column(name="PAD_CUST_CODE")
	private String PAD_CUST_CODE;

	private String UI_M_PAD_CUST_DESC;

	@Column(name="PAD_FC_DR_TOT_AMT")
	private Double PAD_FC_DR_TOT_AMT;

	@Column(name="PAD_CURR_CODE")
	private String PAD_CURR_CODE;

	@Column(name="PAD_FC_BAL_AMT")
	private Double PAD_FC_BAL_AMT;

	@Column(name="PAD_LC_BAL_AMT")
	private Double PAD_LC_BAL_AMT;

	@Column(name="PAD_LC_DR_TOT_AMT")
	private Double PAD_LC_DR_TOT_AMT;

	@Column(name="PAD_FC_CR_TOT_AMT")
	private Double PAD_FC_CR_TOT_AMT;

	@Column(name="PAD_LC_CR_TOT_AMT")
	private Double PAD_LC_CR_TOT_AMT;

	private String UI_M_M_PAPD_CUST_DESC;
	
	@Column(name="PAD_SYS_ID")
	private Integer PAD_SYS_ID;
	
	@Column(name="PAD_PAH_SYS_ID")
	private Integer PAD_PAH_SYS_ID;
	
	private Double PAD_LC_RISK_AMT;
	
	private Double PAD_LC_INVESTMENT_AMT;
	
	@Column(name="PAD_CR_UID")
	private String PAD_CR_UID;
	
	@Column(name="PAD_CR_DT")
	private Date PAD_CR_DT;
	
	private String UI_M_APPRV_STATUS;
	
	public String getUI_M_APPRV_STATUS() {
		return UI_M_APPRV_STATUS;
	}

	public void setUI_M_APPRV_STATUS(String ui_m_apprv_status) {
		UI_M_APPRV_STATUS = ui_m_apprv_status;
	}

	public String getPAD_CR_UID() {
		return PAD_CR_UID;
	}

	public void setPAD_CR_UID(String pad_cr_uid) {
		PAD_CR_UID = pad_cr_uid;
	}

	public Date getPAD_CR_DT() {
		return PAD_CR_DT;
	}

	public void setPAD_CR_DT(Date pad_cr_dt) {
		PAD_CR_DT = pad_cr_dt;
	}

	public Double getPAD_LC_RISK_AMT() {
		return PAD_LC_RISK_AMT;
	}

	public void setPAD_LC_RISK_AMT(Double pad_lc_risk_amt) {
		PAD_LC_RISK_AMT = pad_lc_risk_amt;
	}

	public Double getPAD_LC_INVESTMENT_AMT() {
		return PAD_LC_INVESTMENT_AMT;
	}

	public void setPAD_LC_INVESTMENT_AMT(Double pad_lc_investment_amt) {
		PAD_LC_INVESTMENT_AMT = pad_lc_investment_amt;
	}

	public Integer getPAD_PAH_SYS_ID() {
		return PAD_PAH_SYS_ID;
	}

	public void setPAD_PAH_SYS_ID(Integer pad_pah_sys_id) {
		PAD_PAH_SYS_ID = pad_pah_sys_id;
	}

	public String getUI_M_M_PAPD_CUST_DESC() {
		return UI_M_M_PAPD_CUST_DESC;
	}

	public void setUI_M_M_PAPD_CUST_DESC(String ui_m_m_papd_cust_desc) {
		UI_M_M_PAPD_CUST_DESC = ui_m_m_papd_cust_desc;
	}

	public String getPAD_CUST_CODE() {
		return PAD_CUST_CODE;
	}

	public void setPAD_CUST_CODE(String PAD_CUST_CODE) {
		this.PAD_CUST_CODE = PAD_CUST_CODE;
	}

	public String getUI_M_PAD_CUST_DESC() {
		return UI_M_PAD_CUST_DESC;
	}

	public void setUI_M_PAD_CUST_DESC(String UI_M_PAD_CUST_DESC) {
		this.UI_M_PAD_CUST_DESC = UI_M_PAD_CUST_DESC;
	}

	public Double getPAD_FC_DR_TOT_AMT() {
		return PAD_FC_DR_TOT_AMT;
	}

	public void setPAD_FC_DR_TOT_AMT(Double PAD_FC_DR_TOT_AMT) {
		this.PAD_FC_DR_TOT_AMT = PAD_FC_DR_TOT_AMT;
	}

	public String getPAD_CURR_CODE() {
		return PAD_CURR_CODE;
	}

	public void setPAD_CURR_CODE(String PAD_CURR_CODE) {
		this.PAD_CURR_CODE = PAD_CURR_CODE;
	}

	public Double getPAD_FC_BAL_AMT() {
		return PAD_FC_BAL_AMT;
	}

	public void setPAD_FC_BAL_AMT(Double PAD_FC_BAL_AMT) {
		this.PAD_FC_BAL_AMT = PAD_FC_BAL_AMT;
	}

	public Double getPAD_LC_BAL_AMT() {
		return PAD_LC_BAL_AMT;
	}

	public void setPAD_LC_BAL_AMT(Double PAD_LC_BAL_AMT) {
		this.PAD_LC_BAL_AMT = PAD_LC_BAL_AMT;
	}

	public Double getPAD_LC_DR_TOT_AMT() {
		return PAD_LC_DR_TOT_AMT;
	}

	public void setPAD_LC_DR_TOT_AMT(Double PAD_LC_DR_TOT_AMT) {
		this.PAD_LC_DR_TOT_AMT = PAD_LC_DR_TOT_AMT;
	}

	public Double getPAD_FC_CR_TOT_AMT() {
		return PAD_FC_CR_TOT_AMT;
	}

	public void setPAD_FC_CR_TOT_AMT(Double PAD_FC_CR_TOT_AMT) {
		this.PAD_FC_CR_TOT_AMT = PAD_FC_CR_TOT_AMT;
	}

	public Double getPAD_LC_CR_TOT_AMT() {
		return PAD_LC_CR_TOT_AMT;
	}

	public void setPAD_LC_CR_TOT_AMT(Double PAD_LC_CR_TOT_AMT) {
		this.PAD_LC_CR_TOT_AMT = PAD_LC_CR_TOT_AMT;
	}

	public Integer getPAD_SYS_ID() {
		return PAD_SYS_ID;
	}

	public void setPAD_SYS_ID(Integer pad_sys_id) {
		PAD_SYS_ID = pad_sys_id;
	}

	 
}
