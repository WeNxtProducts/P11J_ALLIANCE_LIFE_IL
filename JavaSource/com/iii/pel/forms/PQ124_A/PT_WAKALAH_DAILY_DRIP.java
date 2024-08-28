package com.iii.pel.forms.PQ124_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;


@Table(name="PT_LIFE_WAKALAH_DAILY_DRIP")
public class PT_WAKALAH_DAILY_DRIP extends BaseValueBean {
	
	@Column(name="WAK_DA_PC_SYS_ID")
	private Long WAK_DA_PC_SYS_ID;

	private Double UI_M_TOT_PRIA;

	@Column(name="WAK_DA_POL_COVER_CODE")
	private String WAK_DA_POL_COVER_CODE;
	
	@Column(name="WAK_DA_PRIA_BAL_AFTER_TAP")
	private Double WAK_DA_PRIA_BAL_AFTER_TAP;
	


	//Modified for LIFE_JAVA-1619032 , modified by Jyoti
	@Column(name="WAK_DA_POL_NET_PREMIUM")
	private Double WAK_DA_POL_NET_PREMIUM=0.0;

	@Column(name="WAK_DA_LOAD_AMT")
	private Double WAK_DA_LOAD_AMT;

	private Double UI_M_ROW_TOTAL;

	private Double UI_M_WAK_DA_POL_NET_PREMIUM;

	@Column(name="WAK_DA_POL_TOT_COMM")
	private Double WAK_DA_POL_TOT_COMM;
	

	@Column(name="WAK_DA_COMMISSION")
	private Double WAK_DA_COMMISSION;

	@Column(name="WAK_DA_EXPENSE")
	private Double WAK_DA_EXPENSE;

	@Column(name="WAK_DA_RISK_FUND")
	private Double WAK_DA_RISK_FUND;

	@Column(name="WAK_DA_ACCOUNT_YN")
	private String WAK_DA_ACCOUNT_YN;
	
	@Column(name="WAK_DA_RISK_FC_AMT")
	private Double WAK_DA_RISK_FC_AMT;
	
	@Column(name="WAK_DA_RISK_LC_AMT")
	private Double WAK_DA_RISK_LC_AMT;
	
	@Column(name="WAK_DA_CHARGE_FC_AMT")
	private Double WAK_DA_CHARGE_FC_AMT;
	
	@Column(name="WAK_DA_CHARGE_LC_AMT")
	private Double WAK_DA_CHARGE_LC_AMT;
	
	@Column(name="WAK_DA_PREM_CONTRI_FC_AMT")
	private Double WAK_DA_PREM_CONTRI_FC_AMT;
	
	@Column(name="WAK_DA_PREM_CONTRI_LC_AMT")
	private Double WAK_DA_PREM_CONTRI_LC_AMT ;


	private Double UI_M_SUM_GROSS_CONTR;

	private Double UI_M_SUM_LOAD_AMT;

	private Double UI_M_SUM_ROW_TOTAL;

	private Double UI_M_SUM_WAK_DA_POL_NET_PREMIUM;

	private Double UI_M_TOT_WAK_DA_POL_TOT_COMM;

	private Double UI_M_TOT_WAK_DA_COMMISSION;

	private Double UI_M_TOT_WAK_DA_EXPENSE;

	private Double UI_M_TOT_WAK_DA_RISK_FUND;

	@Column(name="WAK_DA_LC_SUM_RISK")
	private Double WAK_DA_LC_SUM_RISK;

	private String UI_M_WAK_DA_POL_COVER_CODE_DESC;

	@Column(name="WAK_DA_PC_APPRV_DT")
	private Date WAK_DA_PC_APPRV_DT;

	@Column(name="WAK_DA_PC_SCHD_PYMT_DT")
	private Date WAK_DA_PC_SCHD_PYMT_DT;

	@Column(name="WAK_DA_LC_RISK")
	private Double WAK_DA_LC_RISK;

	private Date UI_M_CUR_RISK_DT;

	@Column(name="WAK_DA_DUE_DATE")
	private Date WAK_DA_DUE_DATE;

	@Column(name="WAK_DA_DUE_SCHD_PYMT_DT")
	private Date WAK_DA_DUE_SCHD_PYMT_DT;

	@Column(name="WAK_DA_DRIP_DT")
	private Date WAK_DA_DRIP_DT;

	private String UI_M_DRIP_STATUS;

	private String WAK_DA_POL_NO;
	
	
	private String WAK_DA_LAP_YN;

	private int WAK_DA_COUNT;
	
	private Double WAK_DA_POL_END_NO_IDX;
	
	private String WAK_DA_POL_ANALYSIS_2;
	
	private Double WAK_DA_SPECIAL_FUND;
	
	private Double UI_M_GROSS_PRIA;
	
	private Double UI_M_GROSS_PIAF;
	
	private Double UI_M_AVAL_BAL;
	
	private Double WAK_DA_SH_COLL_AMT;
	
	private String WAKALAH_DATE;
	
	@Column(name="WAK_DA_DATE")
	private Integer WAK_DA_DATE;
	
	@Column(name="WAK_DA_MON")
	private Integer WAK_DA_MON;
	
	@Column(name="WAK_DA_YEAR")
	private Integer WAK_DA_YEAR;
	
	

	public Integer getWAK_DA_DATE() {
		return WAK_DA_DATE;
	}

	public void setWAK_DA_DATE(Integer wak_da_date) {
		WAK_DA_DATE = wak_da_date;
	}

	public Integer getWAK_DA_MON() {
		return WAK_DA_MON;
	}

	public void setWAK_DA_MON(Integer wak_da_mon) {
		WAK_DA_MON = wak_da_mon;
	}

	public void setWAK_DA_YEAR(Integer wak_da_year) {
		WAK_DA_YEAR = wak_da_year;
	}

	

	

	public String getWAKALAH_DATE() {
		return WAKALAH_DATE;
	}

	public void setWAKALAH_DATE(String wakalah_date) {
		WAKALAH_DATE = wakalah_date;
	}

	/**
	 * @return the wAK_DA_SH_COLL_AMT
	 */
	

	/**
	 * @param wak_da_sh_coll_amt the wAK_DA_SH_COLL_AMT to set
	 */
	public void setWAK_DA_SH_COLL_AMT(Double wak_da_sh_coll_amt) {
		WAK_DA_SH_COLL_AMT = wak_da_sh_coll_amt;
	}

	/**
	 * @return the uI_M_GROSS_PIAF
	 */
	public Double getUI_M_GROSS_PIAF() {
		return UI_M_GROSS_PIAF;
	}

	/**
	 * @param ui_m_gross_piaf the uI_M_GROSS_PIAF to set
	 */
	public void setUI_M_GROSS_PIAF(Double ui_m_gross_piaf) {
		UI_M_GROSS_PIAF = ui_m_gross_piaf;
	}

	/**
	 * @return the uI_M_GROSS_PRIA
	 */
	public Double getUI_M_GROSS_PRIA() {
		return UI_M_GROSS_PRIA;
	}

	/**
	 * @param ui_m_gross_pria the uI_M_GROSS_PRIA to set
	 */
	public void setUI_M_GROSS_PRIA(Double ui_m_gross_pria) {
		UI_M_GROSS_PRIA = ui_m_gross_pria;
	}

	/**
	 * @return the wAK_DA_SPECIAL_FUND
	 */
	public Double getWAK_DA_SPECIAL_FUND() {
		return WAK_DA_SPECIAL_FUND;
	}

	/**
	 * @param wak_da_special_fund the wAK_DA_SPECIAL_FUND to set
	 */
	public void setWAK_DA_SPECIAL_FUND(Double wak_da_special_fund) {
		WAK_DA_SPECIAL_FUND = wak_da_special_fund;
	}

	/**
	 * @return the wAK_DA_POL_ANALYSIS_2
	 */
	public String getWAK_DA_POL_ANALYSIS_2() {
		return WAK_DA_POL_ANALYSIS_2;
	}

	/**
	 * @param wak_da_pol_analysis_2 the wAK_DA_POL_ANALYSIS_2 to set
	 */
	public void setWAK_DA_POL_ANALYSIS_2(String wak_da_pol_analysis_2) {
		WAK_DA_POL_ANALYSIS_2 = wak_da_pol_analysis_2;
	}

	

	/**
	 * @return the wAK_DA_POL_NO
	 */
	public String getWAK_DA_POL_NO() {
		return WAK_DA_POL_NO;
	}

	/**
	 * @param wak_da_pol_no the wAK_DA_POL_NO to set
	 */
	public void setWAK_DA_POL_NO(String wak_da_pol_no) {
		WAK_DA_POL_NO = wak_da_pol_no;
	}

	public Double getUI_M_TOT_PRIA() {
		return UI_M_TOT_PRIA;
	}

	public void setUI_M_TOT_PRIA(Double UI_M_TOT_PRIA) {
		this.UI_M_TOT_PRIA = UI_M_TOT_PRIA;
	}

	public String getWAK_DA_POL_COVER_CODE() {
		return WAK_DA_POL_COVER_CODE;
	}

	public void setWAK_DA_POL_COVER_CODE(String WAK_DA_POL_COVER_CODE) {
		this.WAK_DA_POL_COVER_CODE = WAK_DA_POL_COVER_CODE;
	}


	public Double getWAK_DA_POL_NET_PREMIUM() {
		return WAK_DA_POL_NET_PREMIUM;
	}

	public void setWAK_DA_POL_NET_PREMIUM(Double WAK_DA_POL_NET_PREMIUM) {
		this.WAK_DA_POL_NET_PREMIUM = WAK_DA_POL_NET_PREMIUM;
	}

	public Double getWAK_DA_LOAD_AMT() {
		return WAK_DA_LOAD_AMT;
	}

	public void setWAK_DA_LOAD_AMT(Double WAK_DA_LOAD_AMT) {
		this.WAK_DA_LOAD_AMT = WAK_DA_LOAD_AMT;
	}

	public Double getUI_M_ROW_TOTAL() {
		return UI_M_ROW_TOTAL;
	}

	public void setUI_M_ROW_TOTAL(Double UI_M_ROW_TOTAL) {
		this.UI_M_ROW_TOTAL = UI_M_ROW_TOTAL;
	}

	public Double getUI_M_WAK_DA_POL_NET_PREMIUM() {
		return UI_M_WAK_DA_POL_NET_PREMIUM;
	}

	public void setUI_M_WAK_DA_POL_NET_PREMIUM(Double UI_M_WAK_DA_POL_NET_PREMIUM) {
		this.UI_M_WAK_DA_POL_NET_PREMIUM = UI_M_WAK_DA_POL_NET_PREMIUM;
	}

	public Double getWAK_DA_POL_TOT_COMM() {
		return WAK_DA_POL_TOT_COMM;
	}

	public void setWAK_DA_POL_TOT_COMM(Double WAK_DA_POL_TOT_COMM) {
		this.WAK_DA_POL_TOT_COMM = WAK_DA_POL_TOT_COMM;
	}

	public Double getWAK_DA_COMMISSION() {
		return WAK_DA_COMMISSION;
	}

	public void setWAK_DA_COMMISSION(Double WAK_DA_COMMISSION) {
		this.WAK_DA_COMMISSION = WAK_DA_COMMISSION;
	}

	public Double getWAK_DA_EXPENSE() {
		return WAK_DA_EXPENSE;
	}

	public void setWAK_DA_EXPENSE(Double WAK_DA_EXPENSE) {
		this.WAK_DA_EXPENSE = WAK_DA_EXPENSE;
	}

	public Double getWAK_DA_RISK_FUND() {
		return WAK_DA_RISK_FUND;
	}

	public void setWAK_DA_RISK_FUND(Double WAK_DA_RISK_FUND) {
		this.WAK_DA_RISK_FUND = WAK_DA_RISK_FUND;
	}

	public String getWAK_DA_ACCOUNT_YN() {
		return WAK_DA_ACCOUNT_YN;
	}

	public void setWAK_DA_ACCOUNT_YN(String WAK_DA_ACCOUNT_YN) {
		this.WAK_DA_ACCOUNT_YN = WAK_DA_ACCOUNT_YN;
	}

	public Double getUI_M_SUM_GROSS_CONTR() {
		return UI_M_SUM_GROSS_CONTR;
	}

	public void setUI_M_SUM_GROSS_CONTR(Double UI_M_SUM_GROSS_CONTR) {
		this.UI_M_SUM_GROSS_CONTR = UI_M_SUM_GROSS_CONTR;
	}

	public Double getUI_M_SUM_LOAD_AMT() {
		return UI_M_SUM_LOAD_AMT;
	}

	public void setUI_M_SUM_LOAD_AMT(Double UI_M_SUM_LOAD_AMT) {
		this.UI_M_SUM_LOAD_AMT = UI_M_SUM_LOAD_AMT;
	}

	public Double getUI_M_SUM_ROW_TOTAL() {
		return UI_M_SUM_ROW_TOTAL;
	}

	public void setUI_M_SUM_ROW_TOTAL(Double UI_M_SUM_ROW_TOTAL) {
		this.UI_M_SUM_ROW_TOTAL = UI_M_SUM_ROW_TOTAL;
	}

	public Double getUI_M_SUM_WAK_DA_POL_NET_PREMIUM() {
		return UI_M_SUM_WAK_DA_POL_NET_PREMIUM;
	}

	public void setUI_M_SUM_WAK_DA_POL_NET_PREMIUM(Double UI_M_SUM_WAK_DA_POL_NET_PREMIUM) {
		this.UI_M_SUM_WAK_DA_POL_NET_PREMIUM = UI_M_SUM_WAK_DA_POL_NET_PREMIUM;
	}

	public Double getUI_M_TOT_WAK_DA_POL_TOT_COMM() {
		return UI_M_TOT_WAK_DA_POL_TOT_COMM;
	}

	public void setUI_M_TOT_WAK_DA_POL_TOT_COMM(Double UI_M_TOT_WAK_DA_POL_TOT_COMM) {
		this.UI_M_TOT_WAK_DA_POL_TOT_COMM = UI_M_TOT_WAK_DA_POL_TOT_COMM;
	}

	public Double getUI_M_TOT_WAK_DA_COMMISSION() {
		return UI_M_TOT_WAK_DA_COMMISSION;
	}

	public void setUI_M_TOT_WAK_DA_COMMISSION(Double UI_M_TOT_WAK_DA_COMMISSION) {
		this.UI_M_TOT_WAK_DA_COMMISSION = UI_M_TOT_WAK_DA_COMMISSION;
	}

	public Double getUI_M_TOT_WAK_DA_EXPENSE() {
		return UI_M_TOT_WAK_DA_EXPENSE;
	}

	public void setUI_M_TOT_WAK_DA_EXPENSE(Double UI_M_TOT_WAK_DA_EXPENSE) {
		this.UI_M_TOT_WAK_DA_EXPENSE = UI_M_TOT_WAK_DA_EXPENSE;
	}

	public Double getUI_M_TOT_WAK_DA_RISK_FUND() {
		return UI_M_TOT_WAK_DA_RISK_FUND;
	}

	public void setUI_M_TOT_WAK_DA_RISK_FUND(Double UI_M_TOT_WAK_DA_RISK_FUND) {
		this.UI_M_TOT_WAK_DA_RISK_FUND = UI_M_TOT_WAK_DA_RISK_FUND;
	}

	public Double getWAK_DA_LC_SUM_RISK() {
		return WAK_DA_LC_SUM_RISK;
	}

	public void setWAK_DA_LC_SUM_RISK(Double WAK_DA_LC_SUM_RISK) {
		this.WAK_DA_LC_SUM_RISK = WAK_DA_LC_SUM_RISK;
	}

	public String getUI_M_WAK_DA_POL_COVER_CODE_DESC() {
		return UI_M_WAK_DA_POL_COVER_CODE_DESC;
	}

	public void setUI_M_WAK_DA_POL_COVER_CODE_DESC(String UI_M_WAK_DA_POL_COVER_CODE_DESC) {
		this.UI_M_WAK_DA_POL_COVER_CODE_DESC = UI_M_WAK_DA_POL_COVER_CODE_DESC;
	}

	public Date getWAK_DA_PC_APPRV_DT() {
		 return WAK_DA_PC_APPRV_DT;
	}

	public void setWAK_DA_PC_APPRV_DT(Date WAK_DA_PC_APPRV_DT) {
		this.WAK_DA_PC_APPRV_DT = WAK_DA_PC_APPRV_DT;
	}

	public Date getWAK_DA_PC_SCHD_PYMT_DT() {
		 return WAK_DA_PC_SCHD_PYMT_DT;
	}

	public void setWAK_DA_PC_SCHD_PYMT_DT(Date WAK_DA_PC_SCHD_PYMT_DT) {
		this.WAK_DA_PC_SCHD_PYMT_DT = WAK_DA_PC_SCHD_PYMT_DT;
	}

	public Double getWAK_DA_LC_RISK() {
		return WAK_DA_LC_RISK;
	}

	public void setWAK_DA_LC_RISK(Double WAK_DA_LC_RISK) {
		this.WAK_DA_LC_RISK = WAK_DA_LC_RISK;
	}

	public Date getUI_M_CUR_RISK_DT() {
		 return UI_M_CUR_RISK_DT;
	}

	public void setUI_M_CUR_RISK_DT(Date UI_M_CUR_RISK_DT) {
		this.UI_M_CUR_RISK_DT = UI_M_CUR_RISK_DT;
	}

	public Date getWAK_DA_DUE_DATE() {
		 return WAK_DA_DUE_DATE;
	}

	public void setWAK_DA_DUE_DATE(Date WAK_DA_DUE_DATE) {
		this.WAK_DA_DUE_DATE = WAK_DA_DUE_DATE;
	}

	public Date getWAK_DA_DUE_SCHD_PYMT_DT() {
		 return WAK_DA_DUE_SCHD_PYMT_DT;
	}

	public void setWAK_DA_DUE_SCHD_PYMT_DT(Date WAK_DA_DUE_SCHD_PYMT_DT) {
		this.WAK_DA_DUE_SCHD_PYMT_DT = WAK_DA_DUE_SCHD_PYMT_DT;
	}

	public Date getWAK_DA_DRIP_DT() {
		 return WAK_DA_DRIP_DT;
	}

	public void setWAK_DA_DRIP_DT(Date WAK_DA_DRIP_DT) {
		this.WAK_DA_DRIP_DT = WAK_DA_DRIP_DT;
	}

	public String getUI_M_DRIP_STATUS() {
		return UI_M_DRIP_STATUS;
	}

	public void setUI_M_DRIP_STATUS(String UI_M_DRIP_STATUS) {
		this.UI_M_DRIP_STATUS = UI_M_DRIP_STATUS;
	}

	/**
	 * @return the wAK_DA_LAP_YN
	 */
	public String getWAK_DA_LAP_YN() {
		return WAK_DA_LAP_YN;
	}

	/**
	 * @param wak_da_lap_yn the wAK_DA_LAP_YN to set
	 */
	public void setWAK_DA_LAP_YN(String wak_da_lap_yn) {
		WAK_DA_LAP_YN = wak_da_lap_yn;
	}

	/**
	 * @return the wAK_DA_COUNT
	 */
	public int getWAK_DA_COUNT() {
		return WAK_DA_COUNT;
	}

	/**
	 * @param wak_da_count the wAK_DA_COUNT to set
	 */
	public void setWAK_DA_COUNT(int wak_da_count) {
		WAK_DA_COUNT = wak_da_count;
	}

	/**
	 * @return the wAK_DA_PC_SYS_ID
	 */
	public Long getWAK_DA_PC_SYS_ID() {
		return WAK_DA_PC_SYS_ID;
	}

	/**
	 * @param wak_da_pc_sys_id the wAK_DA_PC_SYS_ID to set
	 */
	public void setWAK_DA_PC_SYS_ID(Long wak_da_pc_sys_id) {
		WAK_DA_PC_SYS_ID = wak_da_pc_sys_id;
	}

	/**
	 * @return the wAK_DA_POL_END_NO_IDX
	 */
	public Double getWAK_DA_POL_END_NO_IDX() {
		return WAK_DA_POL_END_NO_IDX;
	}

	/**
	 * @param wak_da_pol_end_no_idx the wAK_DA_POL_END_NO_IDX to set
	 */
	public void setWAK_DA_POL_END_NO_IDX(Double wak_da_pol_end_no_idx) {
		WAK_DA_POL_END_NO_IDX = wak_da_pol_end_no_idx;
	}

	/**
	 * @return the uI_M_AVAL_BAL
	 */
	public Double getUI_M_AVAL_BAL() {
		return UI_M_AVAL_BAL;
	}

	/**
	 * @param ui_m_aval_bal the uI_M_AVAL_BAL to set
	 */
	public void setUI_M_AVAL_BAL(Double ui_m_aval_bal) {
		UI_M_AVAL_BAL = ui_m_aval_bal;
	}

	public Integer getWAK_DA_YEAR() {
		return WAK_DA_YEAR;
	}

	public Double getWAK_DA_SH_COLL_AMT() {
		return WAK_DA_SH_COLL_AMT;
	}

	public Double getWAK_DA_PRIA_BAL_AFTER_TAP() {
		return WAK_DA_PRIA_BAL_AFTER_TAP;
	}

	public void setWAK_DA_PRIA_BAL_AFTER_TAP(Double wak_da_pria_bal_after_tap) {
		WAK_DA_PRIA_BAL_AFTER_TAP = wak_da_pria_bal_after_tap;
	}

	public Double getWAK_DA_RISK_FC_AMT() {
		return WAK_DA_RISK_FC_AMT;
	}

	public void setWAK_DA_RISK_FC_AMT(Double wak_da_risk_fc_amt) {
		WAK_DA_RISK_FC_AMT = wak_da_risk_fc_amt;
	}

	public Double getWAK_DA_RISK_LC_AMT() {
		return WAK_DA_RISK_LC_AMT;
	}

	public void setWAK_DA_RISK_LC_AMT(Double wak_da_risk_lc_amt) {
		WAK_DA_RISK_LC_AMT = wak_da_risk_lc_amt;
	}

	public Double getWAK_DA_CHARGE_FC_AMT() {
		return WAK_DA_CHARGE_FC_AMT;
	}

	public void setWAK_DA_CHARGE_FC_AMT(Double wak_da_charge_fc_amt) {
		WAK_DA_CHARGE_FC_AMT = wak_da_charge_fc_amt;
	}

	public Double getWAK_DA_CHARGE_LC_AMT() {
		return WAK_DA_CHARGE_LC_AMT;
	}

	public void setWAK_DA_CHARGE_LC_AMT(Double wak_da_charge_lc_amt) {
		WAK_DA_CHARGE_LC_AMT = wak_da_charge_lc_amt;
	}

	public Double getWAK_DA_PREM_CONTRI_FC_AMT() {
		return WAK_DA_PREM_CONTRI_FC_AMT;
	}

	public void setWAK_DA_PREM_CONTRI_FC_AMT(Double wak_da_prem_contri_fc_amt) {
		WAK_DA_PREM_CONTRI_FC_AMT = wak_da_prem_contri_fc_amt;
	}

	public Double getWAK_DA_PREM_CONTRI_LC_AMT() {
		return WAK_DA_PREM_CONTRI_LC_AMT;
	}

	public void setWAK_DA_PREM_CONTRI_LC_AMT(Double wak_da_prem_contri_lc_amt) {
		WAK_DA_PREM_CONTRI_LC_AMT = wak_da_prem_contri_lc_amt;
	}
}
