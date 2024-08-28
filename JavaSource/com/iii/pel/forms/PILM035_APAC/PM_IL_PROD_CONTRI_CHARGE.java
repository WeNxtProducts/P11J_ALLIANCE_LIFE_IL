package com.iii.pel.forms.PILM035_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;



@Table(name="PM_IL_PROD_CONTRI_CHARGE")
public class PM_IL_PROD_CONTRI_CHARGE  extends BaseValueBean{

	
	@Column(name="PCC_PROD_CODE")
	private String PCC_PROD_CODE;

	@Column(name="PCC_CHRG_CODE")
	private String PCC_CHRG_CODE;

	@Column(name="PCC_CON_LMT_FM")
	private Double PCC_CON_LMT_FM;

	@Column(name="PCC_CON_LMT_TO")
	private Double PCC_CON_LMT_TO;

	@Column(name="PCC_CHRG_TYPE")
	private String PCC_CHRG_TYPE;

	@Column(name="PCC_RATE")
	private Double PCC_RATE;
	
	
	@Column(name="PCC_RATE_PER")
	private Double PCC_RATE_PER;

	@Column(name="PCC_CR_DT")
	private Date PCC_CR_DT;
	
	@Column(name="PCC_CR_UID")
	private String PCC_CR_UID;
	
	@Column(name="PCC_UPD_DT")
	private Date PCC_UPD_DT;
	
	@Column(name="PCC_UPD_UID")
	private String PCC_UPD_UID;
	
	@Column(name="PCC_PREM_TOPUP_FLAG")
	private String PCC_PREM_TOPUP_FLAG;

	
	@Column(name="PCC_MODE_OF_PYMT")
	private String PCC_MODE_OF_PYMT;

	@Column(name="PCC_POL_YR_FM")
	private Integer PCC_POL_YR_FM;
	
	@Column(name="PCC_POL_YR_TO")
	private Integer PCC_POL_YR_TO;
	
	
	@Column(name="PCC_FLEX_01")
	private String PCC_FLEX_01;
	
	@Column(name="PCC_FIXED_AMT")
	private Double PCC_FIXED_AMT;
	
	@Column(name="PCC_SR_NO")
	private Integer PCC_SR_NO;
	
	@Column(name="PCC_APPLIED_ON")
	private String PCC_APPLIED_ON;
	
	@Column(name="PCC_SRC_OF_BUS")
	private String PCC_SRC_OF_BUS;
	
	@Column(name="PCC_EFF_FM_DT")
	private Date PCC_EFF_FM_DT;
	
	@Column(name="PCC_EFF_TO_DT")
	private Date PCC_EFF_TO_DT;
	
	@Column(name="PCC_TYPE")
	private String PCC_TYPE;
	
	private String UI_M_PCC_CHRG_CODE_DESC;
	private String UI_M_PROD_SRC_OF_BUS_DESC;
	private String UI_M_FORMULA_CODE_DESC;

	public String getUI_M_FORMULA_CODE_DESC() {
		return UI_M_FORMULA_CODE_DESC;
	}

	public void setUI_M_FORMULA_CODE_DESC(String ui_m_formula_code_desc) {
		UI_M_FORMULA_CODE_DESC = ui_m_formula_code_desc;
	}

	public String getUI_M_PROD_SRC_OF_BUS_DESC() {
		return UI_M_PROD_SRC_OF_BUS_DESC;
	}

	public void setUI_M_PROD_SRC_OF_BUS_DESC(String ui_m_prod_src_of_bus_desc) {
		UI_M_PROD_SRC_OF_BUS_DESC = ui_m_prod_src_of_bus_desc;
	}

	public String getUI_M_PCC_CHRG_CODE_DESC() {
		return UI_M_PCC_CHRG_CODE_DESC;
	}

	public void setUI_M_PCC_CHRG_CODE_DESC(String ui_m_pcc_chrg_code_desc) {
		UI_M_PCC_CHRG_CODE_DESC = ui_m_pcc_chrg_code_desc;
	}

	public String getPCC_PROD_CODE() {
		return PCC_PROD_CODE;
	}

	public void setPCC_PROD_CODE(String pcc_prod_code) {
		PCC_PROD_CODE = pcc_prod_code;
	}

	public String getPCC_CHRG_CODE() {
		return PCC_CHRG_CODE;
	}

	public void setPCC_CHRG_CODE(String pcc_chrg_code) {
		PCC_CHRG_CODE = pcc_chrg_code;
	}

	

	public String getPCC_CHRG_TYPE() {
		return PCC_CHRG_TYPE;
	}

	public void setPCC_CHRG_TYPE(String pcc_chrg_type) {
		PCC_CHRG_TYPE = pcc_chrg_type;
	}

	

	public Date getPCC_CR_DT() {
		return PCC_CR_DT;
	}

	public void setPCC_CR_DT(Date pcc_cr_dt) {
		PCC_CR_DT = pcc_cr_dt;
	}

	public String getPCC_CR_UID() {
		return PCC_CR_UID;
	}

	public void setPCC_CR_UID(String pcc_cr_uid) {
		PCC_CR_UID = pcc_cr_uid;
	}

	public Date getPCC_UPD_DT() {
		return PCC_UPD_DT;
	}

	public void setPCC_UPD_DT(Date pcc_upd_dt) {
		PCC_UPD_DT = pcc_upd_dt;
	}

	public String getPCC_UPD_UID() {
		return PCC_UPD_UID;
	}

	public void setPCC_UPD_UID(String pcc_upd_uid) {
		PCC_UPD_UID = pcc_upd_uid;
	}

	public String getPCC_PREM_TOPUP_FLAG() {
		return PCC_PREM_TOPUP_FLAG;
	}

	public void setPCC_PREM_TOPUP_FLAG(String pcc_prem_topup_flag) {
		PCC_PREM_TOPUP_FLAG = pcc_prem_topup_flag;
	}

	public String getPCC_MODE_OF_PYMT() {
		return PCC_MODE_OF_PYMT;
	}

	public void setPCC_MODE_OF_PYMT(String pcc_mode_of_pymt) {
		PCC_MODE_OF_PYMT = pcc_mode_of_pymt;
	}

	public Integer getPCC_POL_YR_FM() {
		return PCC_POL_YR_FM;
	}

	public void setPCC_POL_YR_FM(Integer pcc_pol_yr_fm) {
		PCC_POL_YR_FM = pcc_pol_yr_fm;
	}

	public Integer getPCC_POL_YR_TO() {
		return PCC_POL_YR_TO;
	}

	public void setPCC_POL_YR_TO(Integer pcc_pol_yr_to) {
		PCC_POL_YR_TO = pcc_pol_yr_to;
	}

	public String getPCC_FLEX_01() {
		return PCC_FLEX_01;
	}

	public void setPCC_FLEX_01(String pcc_flex_01) {
		PCC_FLEX_01 = pcc_flex_01;
	}

	public String getPCC_APPLIED_ON() {
		return PCC_APPLIED_ON;
	}

	public void setPCC_APPLIED_ON(String pcc_applied_on) {
		PCC_APPLIED_ON = pcc_applied_on;
	}

	public String getPCC_SRC_OF_BUS() {
		return PCC_SRC_OF_BUS;
	}

	public void setPCC_SRC_OF_BUS(String pcc_src_of_bus) {
		PCC_SRC_OF_BUS = pcc_src_of_bus;
	}

	public Date getPCC_EFF_FM_DT() {
		return PCC_EFF_FM_DT;
	}

	public void setPCC_EFF_FM_DT(Date pcc_eff_fm_dt) {
		PCC_EFF_FM_DT = pcc_eff_fm_dt;
	}

	public Date getPCC_EFF_TO_DT() {
		return PCC_EFF_TO_DT;
	}

	public void setPCC_EFF_TO_DT(Date pcc_eff_to_dt) {
		PCC_EFF_TO_DT = pcc_eff_to_dt;
	}

	public void setPCC_SR_NO(Integer pcc_sr_no) {
		PCC_SR_NO = pcc_sr_no;
	}

	public Integer getPCC_SR_NO() {
		return PCC_SR_NO;
	}

	

	public Double getPCC_CON_LMT_FM() {
		return PCC_CON_LMT_FM;
	}

	public void setPCC_CON_LMT_FM(Double pcc_con_lmt_fm) {
		PCC_CON_LMT_FM = pcc_con_lmt_fm;
	}

	public Double getPCC_CON_LMT_TO() {
		return PCC_CON_LMT_TO;
	}

	public void setPCC_CON_LMT_TO(Double pcc_con_lmt_to) {
		PCC_CON_LMT_TO = pcc_con_lmt_to;
	}

	public Double getPCC_RATE() {
		return PCC_RATE;
	}

	public void setPCC_RATE(Double pcc_rate) {
		PCC_RATE = pcc_rate;
	}

	public Double getPCC_RATE_PER() {
		return PCC_RATE_PER;
	}

	public void setPCC_RATE_PER(Double pcc_rate_per) {
		PCC_RATE_PER = pcc_rate_per;
	}

	public Double getPCC_FIXED_AMT() {
		return PCC_FIXED_AMT;
	}

	public void setPCC_FIXED_AMT(Double pcc_fixed_amt) {
		PCC_FIXED_AMT = pcc_fixed_amt;
	}

	public String getPCC_TYPE() {
		return PCC_TYPE;
	}

	public void setPCC_TYPE(String pcc_type) {
		PCC_TYPE = pcc_type;
	}
	
	
	/*Added by Janani on 06.06.2017 for Fund allocation issue(204) as per Siva's suggestion*/
	
	@Column(name="PCC_CUST_SHARE_PERC")
	private Double PCC_CUST_SHARE_PERC;

	public Double getPCC_CUST_SHARE_PERC() {
		return PCC_CUST_SHARE_PERC;
	}

	public void setPCC_CUST_SHARE_PERC(Double pCC_CUST_SHARE_PERC) {
		PCC_CUST_SHARE_PERC = pCC_CUST_SHARE_PERC;
	}

	/*End*/
	
	/*Added by saritha on 17-04-2018 for KIC Need to introduce policy fee for GOLDA. 0.2% of initial face amount with max cap of KD 200*/
	
	@Column(name="PCC_APPLY_PERIOD")
	private String PCC_APPLY_PERIOD;

	public String getPCC_APPLY_PERIOD() {
		return PCC_APPLY_PERIOD;
	}

	public void setPCC_APPLY_PERIOD(String pCC_APPLY_PERIOD) {
		PCC_APPLY_PERIOD = pCC_APPLY_PERIOD;
	}
	
	/*End*/
	
	
}
