package com.iii.pel.forms.PQ124_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;


@Table(name="PT_IL_POLICY")
public class PT_WAKALAH_DAILY_DRIP_1 extends BaseValueBean {

	private Double UI_M_PA_PROFIT;

	private Double UI_M_ACC_PSA_PROFIT;

	@Column(name="POL_CUST_CODE")
	private String POL_CUST_CODE;

	@Column(name="POL_NO")
	private String POL_NO;

	@Column(name="POL_END_NO")
	private String POL_END_NO;

	private Double UI_M_GFTA_SURP;

	private String UI_M_WAK_DA_MODULE;

	@Column(name="POL_PROD_CODE")
	private String POL_PROD_CODE;

	private Double UI_M_GFTA_SURP_TR;

	@Column(name="POL_DIVN_CODE")
	private String POL_DIVN_CODE;

	@Column(name="POL_DEPT_CODE")
	private String POL_DEPT_CODE;

	private Double UI_M_PA_BAL;

	@Column(name="POL_CLASS_CODE")
	private String POL_CLASS_CODE;

	private String UI_M_WAK_DA_POL_PDS_CODE;

	private Double UI_M_CONT_LC_BALANCE;

	@Column(name="POL_SRC_OF_BUS")
	private String POL_SRC_OF_BUS;
	
	private Double UI_M_GFTA_SURP_AMT;
	
	private Date UI_M_PA_PROFIT_DT;

	private Double UI_M_PSA_YR;

	private String UI_M_WAK_DA_POL_ANALYSIS_1;

	private Date UI_M_GFTA_SURP_DT;

	/**
	 * @return the uI_M_PA_PROFIT
	 */
	public Double getUI_M_PA_PROFIT() {
		return UI_M_PA_PROFIT;
	}

	/**
	 * @param ui_m_pa_profit the uI_M_PA_PROFIT to set
	 */
	public void setUI_M_PA_PROFIT(Double ui_m_pa_profit) {
		UI_M_PA_PROFIT = ui_m_pa_profit;
	}

	/**
	 * @return the uI_M_ACC_PSA_PROFIT
	 */
	public Double getUI_M_ACC_PSA_PROFIT() {
		return UI_M_ACC_PSA_PROFIT;
	}

	/**
	 * @param ui_m_acc_psa_profit the uI_M_ACC_PSA_PROFIT to set
	 */
	public void setUI_M_ACC_PSA_PROFIT(Double ui_m_acc_psa_profit) {
		UI_M_ACC_PSA_PROFIT = ui_m_acc_psa_profit;
	}

	/**
	 * @return the pOL_CUST_CODE
	 */
	public String getPOL_CUST_CODE() {
		return POL_CUST_CODE;
	}

	/**
	 * @param pol_cust_code the pOL_CUST_CODE to set
	 */
	public void setPOL_CUST_CODE(String pol_cust_code) {
		POL_CUST_CODE = pol_cust_code;
	}

	/**
	 * @return the pOL_NO
	 */
	public String getPOL_NO() {
		return POL_NO;
	}

	/**
	 * @param pol_no the pOL_NO to set
	 */
	public void setPOL_NO(String pol_no) {
		POL_NO = pol_no;
	}

	/**
	 * @return the pOL_END_NO
	 */
	public String getPOL_END_NO() {
		return POL_END_NO;
	}

	/**
	 * @param pol_end_no the pOL_END_NO to set
	 */
	public void setPOL_END_NO(String pol_end_no) {
		POL_END_NO = pol_end_no;
	}

	/**
	 * @return the uI_M_GFTA_SURP
	 */
	public Double getUI_M_GFTA_SURP() {
		return UI_M_GFTA_SURP;
	}

	/**
	 * @param ui_m_gfta_surp the uI_M_GFTA_SURP to set
	 */
	public void setUI_M_GFTA_SURP(Double ui_m_gfta_surp) {
		UI_M_GFTA_SURP = ui_m_gfta_surp;
	}

	/**
	 * @return the uI_M_WAK_DA_MODULE
	 */
	public String getUI_M_WAK_DA_MODULE() {
		return UI_M_WAK_DA_MODULE;
	}

	/**
	 * @param ui_m_wak_da_module the uI_M_WAK_DA_MODULE to set
	 */
	public void setUI_M_WAK_DA_MODULE(String ui_m_wak_da_module) {
		UI_M_WAK_DA_MODULE = ui_m_wak_da_module;
	}

	/**
	 * @return the pOL_PROD_CODE
	 */
	public String getPOL_PROD_CODE() {
		return POL_PROD_CODE;
	}

	/**
	 * @param pol_prod_code the pOL_PROD_CODE to set
	 */
	public void setPOL_PROD_CODE(String pol_prod_code) {
		POL_PROD_CODE = pol_prod_code;
	}

	/**
	 * @return the uI_M_GFTA_SURP_TR
	 */
	public Double getUI_M_GFTA_SURP_TR() {
		return UI_M_GFTA_SURP_TR;
	}

	/**
	 * @param ui_m_gfta_surp_tr the uI_M_GFTA_SURP_TR to set
	 */
	public void setUI_M_GFTA_SURP_TR(Double ui_m_gfta_surp_tr) {
		UI_M_GFTA_SURP_TR = ui_m_gfta_surp_tr;
	}

	/**
	 * @return the pOL_DIVN_CODE
	 */
	public String getPOL_DIVN_CODE() {
		return POL_DIVN_CODE;
	}

	/**
	 * @param pol_divn_code the pOL_DIVN_CODE to set
	 */
	public void setPOL_DIVN_CODE(String pol_divn_code) {
		POL_DIVN_CODE = pol_divn_code;
	}

	/**
	 * @return the pOL_DEPT_CODE
	 */
	public String getPOL_DEPT_CODE() {
		return POL_DEPT_CODE;
	}

	/**
	 * @param pol_dept_code the pOL_DEPT_CODE to set
	 */
	public void setPOL_DEPT_CODE(String pol_dept_code) {
		POL_DEPT_CODE = pol_dept_code;
	}

	/**
	 * @return the uI_M_PA_BAL
	 */
	public Double getUI_M_PA_BAL() {
		return UI_M_PA_BAL;
	}

	/**
	 * @param ui_m_pa_bal the uI_M_PA_BAL to set
	 */
	public void setUI_M_PA_BAL(Double ui_m_pa_bal) {
		UI_M_PA_BAL = ui_m_pa_bal;
	}

	/**
	 * @return the pOL_CLASS_CODE
	 */
	public String getPOL_CLASS_CODE() {
		return POL_CLASS_CODE;
	}

	/**
	 * @param pol_class_code the pOL_CLASS_CODE to set
	 */
	public void setPOL_CLASS_CODE(String pol_class_code) {
		POL_CLASS_CODE = pol_class_code;
	}

	/**
	 * @return the uI_M_WAK_DA_POL_PDS_CODE
	 */
	public String getUI_M_WAK_DA_POL_PDS_CODE() {
		return UI_M_WAK_DA_POL_PDS_CODE;
	}

	/**
	 * @param ui_m_wak_da_pol_pds_code the uI_M_WAK_DA_POL_PDS_CODE to set
	 */
	public void setUI_M_WAK_DA_POL_PDS_CODE(String ui_m_wak_da_pol_pds_code) {
		UI_M_WAK_DA_POL_PDS_CODE = ui_m_wak_da_pol_pds_code;
	}

	/**
	 * @return the uI_M_CONT_LC_BALANCE
	 */
	public Double getUI_M_CONT_LC_BALANCE() {
		return UI_M_CONT_LC_BALANCE;
	}

	/**
	 * @param ui_m_cont_lc_balance the uI_M_CONT_LC_BALANCE to set
	 */
	public void setUI_M_CONT_LC_BALANCE(Double ui_m_cont_lc_balance) {
		UI_M_CONT_LC_BALANCE = ui_m_cont_lc_balance;
	}

	/**
	 * @return the pOL_SRC_OF_BUS
	 */
	public String getPOL_SRC_OF_BUS() {
		return POL_SRC_OF_BUS;
	}

	/**
	 * @param pol_src_of_bus the pOL_SRC_OF_BUS to set
	 */
	public void setPOL_SRC_OF_BUS(String pol_src_of_bus) {
		POL_SRC_OF_BUS = pol_src_of_bus;
	}

	/**
	 * @return the uI_M_GFTA_SURP_AMT
	 */
	public Double getUI_M_GFTA_SURP_AMT() {
		return UI_M_GFTA_SURP_AMT;
	}

	/**
	 * @param ui_m_gfta_surp_amt the uI_M_GFTA_SURP_AMT to set
	 */
	public void setUI_M_GFTA_SURP_AMT(Double ui_m_gfta_surp_amt) {
		UI_M_GFTA_SURP_AMT = ui_m_gfta_surp_amt;
	}

	/**
	 * @return the uI_M_PA_PROFIT_DT
	 */
	public Date getUI_M_PA_PROFIT_DT() {
		return UI_M_PA_PROFIT_DT;
	}

	/**
	 * @param ui_m_pa_profit_dt the uI_M_PA_PROFIT_DT to set
	 */
	public void setUI_M_PA_PROFIT_DT(Date ui_m_pa_profit_dt) {
		UI_M_PA_PROFIT_DT = ui_m_pa_profit_dt;
	}

	/**
	 * @return the uI_M_PSA_YR
	 */
	public Double getUI_M_PSA_YR() {
		return UI_M_PSA_YR;
	}

	/**
	 * @param ui_m_psa_yr the uI_M_PSA_YR to set
	 */
	public void setUI_M_PSA_YR(Double ui_m_psa_yr) {
		UI_M_PSA_YR = ui_m_psa_yr;
	}

	/**
	 * @return the uI_M_WAK_DA_POL_ANALYSIS_1
	 */
	public String getUI_M_WAK_DA_POL_ANALYSIS_1() {
		return UI_M_WAK_DA_POL_ANALYSIS_1;
	}

	/**
	 * @param ui_m_wak_da_pol_analysis_1 the uI_M_WAK_DA_POL_ANALYSIS_1 to set
	 */
	public void setUI_M_WAK_DA_POL_ANALYSIS_1(String ui_m_wak_da_pol_analysis_1) {
		UI_M_WAK_DA_POL_ANALYSIS_1 = ui_m_wak_da_pol_analysis_1;
	}

	/**
	 * @return the uI_M_GFTA_SURP_DT
	 */
	public Date getUI_M_GFTA_SURP_DT() {
		return UI_M_GFTA_SURP_DT;
	}

	/**
	 * @param ui_m_gfta_surp_dt the uI_M_GFTA_SURP_DT to set
	 */
	public void setUI_M_GFTA_SURP_DT(Date ui_m_gfta_surp_dt) {
		UI_M_GFTA_SURP_DT = ui_m_gfta_surp_dt;
	}
	

}
