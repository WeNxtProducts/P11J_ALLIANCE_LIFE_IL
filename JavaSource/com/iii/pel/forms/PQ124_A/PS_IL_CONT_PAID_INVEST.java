package com.iii.pel.forms.PQ124_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;


@Table(name="PS_IL_CONT_PAID_INVEST")
public class PS_IL_CONT_PAID_INVEST extends BaseValueBean {

	@Column(name="CPI_ACNT_YEAR")
	private Double CPI_ACNT_YEAR;
	
	private Long CPI_SYS_ID;
	
	private Long CPI_POL_SYS_ID;
	
	private Long CPI_WAK_DA_SYS_ID;

	private Date UI_M_YR_END_DT;

	private Double UI_M_ACC_PA_END_BAL;

	@Column(name="CPI_TXN_DT")
	private Date CPI_TXN_DT;

	@Column(name="CPI_RCPT_AMT")
	private Double CPI_RCPT_AMT;

	@Column(name="CPI_MATCHED_AMT")
	private Double CPI_MATCHED_AMT;

	@Column(name="CPI_PROFIT")
	private Double CPI_PROFIT;

	@Column(name="CPI_DAY_EXP")
	private Double CPI_DAY_EXP;

	@Column(name="CPI_PA_BAL")
	private Double CPI_PA_BAL;

	@Column(name="CPI_RATE")
	private Double CPI_RATE;

	@Column(name="CPI_PA_PROFIT")
	private Double CPI_PA_PROFIT;

	@Column(name="CPI_GFTA_PROFIT")
	private Double CPI_GFTA_PROFIT;

	@Column(name="CPI_COVER_CODE")
	private String CPI_COVER_CODE;

	@Column(name="CPI_PSA_PROFIT")
	private Double CPI_PSA_PROFIT;

	@Column(name="CPI_GFTA_RATE")
	private Double CPI_GFTA_RATE;

	@Column(name="CPI_PSA_RATE")
	private Double CPI_PSA_RATE;

	@Column(name="CPI_SUSPENSE_RATE")
	private Double CPI_SUSPENSE_RATE;

	@Column(name="CPI_RISK_FUND")
	private Double CPI_RISK_FUND;

	private Double UI_M_PA_PROFIT_COVERWISE;

	@Column(name="CPI_WD_AMT")
	private Double CPI_WD_AMT;

	@Column(name="CPI_MAT_AMT")
	private Double CPI_MAT_AMT;

	private Double UI_M_RISK_FUND;

	private Double UI_M_PA_PROFIT;

	@Column(name="CPI_WAK_DUE_DATE")
	private Date CPI_WAK_DUE_DATE;

	private Double UI_M_ACC_PA_PRFT;
	
	public Double getCPI_ACNT_YEAR() {
		return CPI_ACNT_YEAR;
	}

	public void setCPI_ACNT_YEAR(Double CPI_ACNT_YEAR) {
		this.CPI_ACNT_YEAR = CPI_ACNT_YEAR;
	}

	public Date getUI_M_YR_END_DT() {
		 return UI_M_YR_END_DT;
	}

	public void setUI_M_YR_END_DT(Date UI_M_YR_END_DT) {
		this.UI_M_YR_END_DT = UI_M_YR_END_DT;
	}

	public Double getUI_M_ACC_PA_END_BAL() {
		return UI_M_ACC_PA_END_BAL;
	}

	public void setUI_M_ACC_PA_END_BAL(Double UI_M_ACC_PA_END_BAL) {
		this.UI_M_ACC_PA_END_BAL = UI_M_ACC_PA_END_BAL;
	}

	public Date getCPI_TXN_DT() {
		 return CPI_TXN_DT;
	}

	public void setCPI_TXN_DT(Date CPI_TXN_DT) {
		this.CPI_TXN_DT = CPI_TXN_DT;
	}

	public Double getCPI_RCPT_AMT() {
		return CPI_RCPT_AMT;
	}

	public void setCPI_RCPT_AMT(Double CPI_RCPT_AMT) {
		this.CPI_RCPT_AMT = CPI_RCPT_AMT;
	}

	public Double getCPI_MATCHED_AMT() {
		return CPI_MATCHED_AMT;
	}

	public void setCPI_MATCHED_AMT(Double CPI_MATCHED_AMT) {
		this.CPI_MATCHED_AMT = CPI_MATCHED_AMT;
	}

	public Double getCPI_PROFIT() {
		return CPI_PROFIT;
	}

	public void setCPI_PROFIT(Double CPI_PROFIT) {
		this.CPI_PROFIT = CPI_PROFIT;
	}

	public Double getCPI_DAY_EXP() {
		return CPI_DAY_EXP;
	}

	public void setCPI_DAY_EXP(Double CPI_DAY_EXP) {
		this.CPI_DAY_EXP = CPI_DAY_EXP;
	}

	public Double getCPI_PA_BAL() {
		return CPI_PA_BAL;
	}

	public void setCPI_PA_BAL(Double CPI_PA_BAL) {
		this.CPI_PA_BAL = CPI_PA_BAL;
	}

	public Double getCPI_RATE() {
		return CPI_RATE;
	}

	public void setCPI_RATE(Double CPI_RATE) {
		this.CPI_RATE = CPI_RATE;
	}

	public Double getCPI_PA_PROFIT() {
		return CPI_PA_PROFIT;
	}

	public void setCPI_PA_PROFIT(Double CPI_PA_PROFIT) {
		this.CPI_PA_PROFIT = CPI_PA_PROFIT;
	}

	public Double getCPI_GFTA_PROFIT() {
		return CPI_GFTA_PROFIT;
	}

	public void setCPI_GFTA_PROFIT(Double CPI_GFTA_PROFIT) {
		this.CPI_GFTA_PROFIT = CPI_GFTA_PROFIT;
	}

	public String getCPI_COVER_CODE() {
		return CPI_COVER_CODE;
	}

	public void setCPI_COVER_CODE(String CPI_COVER_CODE) {
		this.CPI_COVER_CODE = CPI_COVER_CODE;
	}

	public Double getCPI_PSA_PROFIT() {
		return CPI_PSA_PROFIT;
	}

	public void setCPI_PSA_PROFIT(Double CPI_PSA_PROFIT) {
		this.CPI_PSA_PROFIT = CPI_PSA_PROFIT;
	}

	public Double getCPI_GFTA_RATE() {
		return CPI_GFTA_RATE;
	}

	public void setCPI_GFTA_RATE(Double CPI_GFTA_RATE) {
		this.CPI_GFTA_RATE = CPI_GFTA_RATE;
	}

	public Double getCPI_PSA_RATE() {
		return CPI_PSA_RATE;
	}

	public void setCPI_PSA_RATE(Double CPI_PSA_RATE) {
		this.CPI_PSA_RATE = CPI_PSA_RATE;
	}

	public Double getCPI_SUSPENSE_RATE() {
		return CPI_SUSPENSE_RATE;
	}

	public void setCPI_SUSPENSE_RATE(Double CPI_SUSPENSE_RATE) {
		this.CPI_SUSPENSE_RATE = CPI_SUSPENSE_RATE;
	}

	public Double getCPI_RISK_FUND() {
		return CPI_RISK_FUND;
	}

	public void setCPI_RISK_FUND(Double CPI_RISK_FUND) {
		this.CPI_RISK_FUND = CPI_RISK_FUND;
	}

	public Double getUI_M_PA_PROFIT_COVERWISE() {
		return UI_M_PA_PROFIT_COVERWISE;
	}

	public void setUI_M_PA_PROFIT_COVERWISE(Double UI_M_PA_PROFIT_COVERWISE) {
		this.UI_M_PA_PROFIT_COVERWISE = UI_M_PA_PROFIT_COVERWISE;
	}

	public Double getCPI_WD_AMT() {
		return CPI_WD_AMT;
	}

	public void setCPI_WD_AMT(Double CPI_WD_AMT) {
		this.CPI_WD_AMT = CPI_WD_AMT;
	}

	public Double getCPI_MAT_AMT() {
		return CPI_MAT_AMT;
	}

	public void setCPI_MAT_AMT(Double CPI_MAT_AMT) {
		this.CPI_MAT_AMT = CPI_MAT_AMT;
	}

	public Double getUI_M_RISK_FUND() {
		return UI_M_RISK_FUND;
	}

	public void setUI_M_RISK_FUND(Double UI_M_RISK_FUND) {
		this.UI_M_RISK_FUND = UI_M_RISK_FUND;
	}

	public Double getUI_M_PA_PROFIT() {
		return UI_M_PA_PROFIT;
	}

	public void setUI_M_PA_PROFIT(Double UI_M_PA_PROFIT) {
		this.UI_M_PA_PROFIT = UI_M_PA_PROFIT;
	}

	public Date getCPI_WAK_DUE_DATE() {
		 return CPI_WAK_DUE_DATE;
	}

	public void setCPI_WAK_DUE_DATE(Date CPI_WAK_DUE_DATE) {
		this.CPI_WAK_DUE_DATE = CPI_WAK_DUE_DATE;
	}

	public Double getUI_M_ACC_PA_PRFT() {
		return UI_M_ACC_PA_PRFT;
	}

	public void setUI_M_ACC_PA_PRFT(Double UI_M_ACC_PA_PRFT) {
		this.UI_M_ACC_PA_PRFT = UI_M_ACC_PA_PRFT;
	}

	/**
	 * @return the cPI_POL_SYS_ID
	 */
	public Long getCPI_POL_SYS_ID() {
		return CPI_POL_SYS_ID;
	}

	/**
	 * @param cpi_pol_sys_id the cPI_POL_SYS_ID to set
	 */
	public void setCPI_POL_SYS_ID(Long cpi_pol_sys_id) {
		CPI_POL_SYS_ID = cpi_pol_sys_id;
	}

	/**
	 * @return the cPI_WAK_DA_SYS_ID
	 */
	public Long getCPI_WAK_DA_SYS_ID() {
		return CPI_WAK_DA_SYS_ID;
	}

	/**
	 * @param cpi_wak_da_sys_id the cPI_WAK_DA_SYS_ID to set
	 */
	public void setCPI_WAK_DA_SYS_ID(Long cpi_wak_da_sys_id) {
		CPI_WAK_DA_SYS_ID = cpi_wak_da_sys_id;
	}

	/**
	 * @return the cPI_SYS_ID
	 */
	public Long getCPI_SYS_ID() {
		return CPI_SYS_ID;
	}

	/**
	 * @param cpi_sys_id the cPI_SYS_ID to set
	 */
	public void setCPI_SYS_ID(Long cpi_sys_id) {
		CPI_SYS_ID = cpi_sys_id;
	}

	
}
