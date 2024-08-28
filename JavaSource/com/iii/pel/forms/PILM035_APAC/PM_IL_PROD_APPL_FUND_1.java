package com.iii.pel.forms.PILM035_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_PROD_APPL_FUND")
public class PM_IL_PROD_APPL_FUND_1 extends BaseValueBean {
	@Column(name="PAF_PROD_CODE")
	private String PAF_PROD_CODE;

	@Column(name="PAF_FUND_CODE")
	private String PAF_FUND_CODE;

	@Column(name="PAF_FUND_PERC")
	private Double PAF_FUND_PERC;

	@Column(name="PAF_DEFAULT_YN")
	private String PAF_DEFAULT_YN;

	@Column(name="PAF_CR_DT")
	private Date PAF_CR_DT;

	@Column(name="PAF_CR_UID")
	private String PAF_CR_UID;

	@Column(name="PAF_UPD_DT")
	private Date PAF_UPD_DT;

	@Column(name="PAF_UPD_UID")
	private String PAF_UPD_UID;

	@Column(name="PAF_FUND_DIR_TYPE")
	private String PAF_FUND_DIR_TYPE;
	
	private String UI_M_FUND_DESC;
	
	private Double UI_M_ALLOC_PERC;
	
	private double UI_M_SUM_FUND_PERC;
	

	public double getUI_M_SUM_FUND_PERC() {
		return UI_M_SUM_FUND_PERC;
	}

	public void setUI_M_SUM_FUND_PERC(double ui_m_sum_fund_perc) {
		UI_M_SUM_FUND_PERC = ui_m_sum_fund_perc;
	}

	public Double getUI_M_ALLOC_PERC() {
		return UI_M_ALLOC_PERC;
	}

	public void setUI_M_ALLOC_PERC(Double ui_m_alloc_perc) {
		UI_M_ALLOC_PERC = ui_m_alloc_perc;
	}

	public String getUI_M_FUND_DESC() {
		return UI_M_FUND_DESC;
	}

	public void setUI_M_FUND_DESC(String ui_m_fund_desc) {
		UI_M_FUND_DESC = ui_m_fund_desc;
	}

	public String getPAF_PROD_CODE() {
		 return PAF_PROD_CODE;
	}

	public void setPAF_PROD_CODE(String PAF_PROD_CODE) {
		this.PAF_PROD_CODE = PAF_PROD_CODE;
	}

	public String getPAF_FUND_CODE() {
		 return PAF_FUND_CODE;
	}

	public void setPAF_FUND_CODE(String PAF_FUND_CODE) {
		this.PAF_FUND_CODE = PAF_FUND_CODE;
	}

	public Double getPAF_FUND_PERC() {
		 return PAF_FUND_PERC;
	}

	public void setPAF_FUND_PERC(Double PAF_FUND_PERC) {
		this.PAF_FUND_PERC = PAF_FUND_PERC;
	}

	public String getPAF_DEFAULT_YN() {
		 return PAF_DEFAULT_YN;
	}

	public void setPAF_DEFAULT_YN(String PAF_DEFAULT_YN) {
		this.PAF_DEFAULT_YN = PAF_DEFAULT_YN;
	}

	public Date getPAF_CR_DT() {
		 return PAF_CR_DT;
	}

	public void setPAF_CR_DT(Date PAF_CR_DT) {
		this.PAF_CR_DT = PAF_CR_DT;
	}

	public String getPAF_CR_UID() {
		 return PAF_CR_UID;
	}

	public void setPAF_CR_UID(String PAF_CR_UID) {
		this.PAF_CR_UID = PAF_CR_UID;
	}

	public Date getPAF_UPD_DT() {
		 return PAF_UPD_DT;
	}

	public void setPAF_UPD_DT(Date PAF_UPD_DT) {
		this.PAF_UPD_DT = PAF_UPD_DT;
	}

	public String getPAF_UPD_UID() {
		 return PAF_UPD_UID;
	}

	public void setPAF_UPD_UID(String PAF_UPD_UID) {
		this.PAF_UPD_UID = PAF_UPD_UID;
	}

	public String getPAF_FUND_DIR_TYPE() {
		 return PAF_FUND_DIR_TYPE;
	}

	public void setPAF_FUND_DIR_TYPE(String PAF_FUND_DIR_TYPE) {
		this.PAF_FUND_DIR_TYPE = PAF_FUND_DIR_TYPE;
	}
	
}

