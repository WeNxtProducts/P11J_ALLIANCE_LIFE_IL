package com.iii.pel.forms.PILM035_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_PROD_APPL_COVER")
public class PM_IL_PROD_APPL_COVER_1 extends BaseValueBean {
	
	
	
	@Column(name="PAC_PROD_CODE")
	private String PAC_PROD_CODE;

	@Column(name="PAC_COVER_CODE")
	private String PAC_COVER_CODE;

	@Column(name="PAC_MANDATORY_YN")
	private String PAC_MANDATORY_YN;

	@Column(name="PAC_DEFAULT_YN")
	private String PAC_DEFAULT_YN;

	@Column(name="PAC_TARIFF_TERM_FLAG")
	private String PAC_TARIFF_TERM_FLAG;

	@Column(name="PAC_CR_DT")
	private Date PAC_CR_DT;

	@Column(name="PAC_CR_UID")
	private String PAC_CR_UID;

	@Column(name="PAC_UPD_DT")
	private Date PAC_UPD_DT;

	@Column(name="PAC_UPD_UID")
	private String PAC_UPD_UID;

	@Column(name="PAC_MAX_AGE_ON_MAT")
	private Integer PAC_MAX_AGE_ON_MAT;

	@Column(name="PAC_PERIOD")
	private Integer PAC_PERIOD;

	@Column(name="PAC_PREM_PAY_YRS")
	private Integer PAC_PREM_PAY_YRS;

	@Column(name="PAC_BCH_CODE")
	private String PAC_BCH_CODE;

	@Column(name="PAC_BCH_TERM")
	private String PAC_BCH_TERM;

	@Column(name="PAC_PRODUCTION_PERC")
	private Double PAC_PRODUCTION_PERC;

	@Column(name="PAC_THRESHOLD_PERC")
	private Double PAC_THRESHOLD_PERC;

	@Column(name="PAC_MED_DAYS")
	private Integer PAC_MED_DAYS;

	@Column(name="PAC_MED_AMT")
	private Double PAC_MED_AMT;

	@Column(name="PAC_MASTER_COVER_CODE")
	private String PAC_MASTER_COVER_CODE;

	@Column(name="PAC_GRP_THRESHOLD_PERC")
	private Double PAC_GRP_THRESHOLD_PERC;

	@Column(name="PAC_RSA_CALC_YN")
	private String PAC_RSA_CALC_YN;

	@Column(name="PAC_SA_FACTOR")
	private String PAC_SA_FACTOR;

	@Column(name="PAC_SA_TARIFF")
	private String PAC_SA_TARIFF;

	@Column(name="PAC_PREM_TARIFF")
	private String PAC_PREM_TARIFF;

	@Column(name="PAC_COVER_ASSR_TYPE")
	private String PAC_COVER_ASSR_TYPE;

	@Column(name="PAC_COVER_START_AGE_VAL_YN")
	private String PAC_COVER_START_AGE_VAL_YN;

	@Column(name="PAC_AGE_BASIS")
	private String PAC_AGE_BASIS;

	@Column(name="PAC_COVER_START_AGE")
	private Integer PAC_COVER_START_AGE;

	@Column(name="PAC_MAT_PAYER_AGE")
	private Integer PAC_MAT_PAYER_AGE;

	@Column(name="PAC_MAT_PAYEE_AGE")
	private Integer PAC_MAT_PAYEE_AGE;

	@Column(name="PAC_SA_ADD_FACTOR")
	private String PAC_SA_ADD_FACTOR;

	@Column(name="PAC_COOL_OF_PD")
	private Integer PAC_COOL_OF_PD;
	
	
	private String UI_M_PAC_BCH_CODE_DESC;
	
	private String UI_M_PAC_COVER_CODE_DESC;
	

	public Integer getPAC_COVER_START_AGE() {
		return PAC_COVER_START_AGE;
	}

	public void setPAC_COVER_START_AGE(Integer pac_cover_start_age) {
		PAC_COVER_START_AGE = pac_cover_start_age;
	}

	

	

	public String getPAC_PROD_CODE() {
		return PAC_PROD_CODE;
	}

	public void setPAC_PROD_CODE(String pac_prod_code) {
		PAC_PROD_CODE = pac_prod_code;
	}

	public String getPAC_MASTER_COVER_CODE() {
		return PAC_MASTER_COVER_CODE;
	}

	public void setPAC_MASTER_COVER_CODE(String pac_master_cover_code) {
		PAC_MASTER_COVER_CODE = pac_master_cover_code;
	}

	public String getPAC_RSA_CALC_YN() {
		return PAC_RSA_CALC_YN;
	}

	public void setPAC_RSA_CALC_YN(String pac_rsa_calc_yn) {
		PAC_RSA_CALC_YN = pac_rsa_calc_yn;
	}

	public String getPAC_SA_FACTOR() {
		return PAC_SA_FACTOR;
	}

	public void setPAC_SA_FACTOR(String pac_sa_factor) {
		PAC_SA_FACTOR = pac_sa_factor;
	}

	public String getPAC_SA_TARIFF() {
		return PAC_SA_TARIFF;
	}

	public void setPAC_SA_TARIFF(String pac_sa_tariff) {
		PAC_SA_TARIFF = pac_sa_tariff;
	}

	public String getPAC_PREM_TARIFF() {
		return PAC_PREM_TARIFF;
	}

	public void setPAC_PREM_TARIFF(String pac_prem_tariff) {
		PAC_PREM_TARIFF = pac_prem_tariff;
	}

	public String getPAC_SA_ADD_FACTOR() {
		return PAC_SA_ADD_FACTOR;
	}

	public void setPAC_SA_ADD_FACTOR(String pac_sa_add_factor) {
		PAC_SA_ADD_FACTOR = pac_sa_add_factor;
	}

	public Integer getPAC_COOL_OF_PD() {
		return PAC_COOL_OF_PD;
	}

	public void setPAC_COOL_OF_PD(Integer pac_cool_of_pd) {
		PAC_COOL_OF_PD = pac_cool_of_pd;
	}

	public Integer getPAC_MAT_PAYEE_AGE() {
		return PAC_MAT_PAYEE_AGE;
	}

	public void setPAC_MAT_PAYEE_AGE(Integer pac_mat_payee_age) {
		PAC_MAT_PAYEE_AGE = pac_mat_payee_age;
	}

	public Integer getPAC_MAT_PAYER_AGE() {
		return PAC_MAT_PAYER_AGE;
	}

	public void setPAC_MAT_PAYER_AGE(Integer pac_mat_payer_age) {
		PAC_MAT_PAYER_AGE = pac_mat_payer_age;
	}

	public Integer getPAC_MED_DAYS() {
		return PAC_MED_DAYS;
	}

	public void setPAC_MED_DAYS(Integer pac_med_days) {
		PAC_MED_DAYS = pac_med_days;
	}

	public Date getPAC_UPD_DT() {
		return PAC_UPD_DT;
	}

	public void setPAC_UPD_DT(Date pac_upd_dt) {
		PAC_UPD_DT = pac_upd_dt;
	}

	public String getPAC_UPD_UID() {
		return PAC_UPD_UID;
	}

	public void setPAC_UPD_UID(String pac_upd_uid) {
		PAC_UPD_UID = pac_upd_uid;
	}

	

	
	public String getPAC_CR_UID() {
		return PAC_CR_UID;
	}

	public void setPAC_CR_UID(String pac_cr_uid) {
		PAC_CR_UID = pac_cr_uid;
	}

	public String getPAC_COVER_CODE() {
		return PAC_COVER_CODE;
	}

	public void setPAC_COVER_CODE(String pac_cover_code) {
		PAC_COVER_CODE = pac_cover_code;
	}

	public String getPAC_COVER_ASSR_TYPE() {
		return PAC_COVER_ASSR_TYPE;
	}

	public void setPAC_COVER_ASSR_TYPE(String pac_cover_assr_type) {
		PAC_COVER_ASSR_TYPE = pac_cover_assr_type;
	}

	public String getPAC_BCH_CODE() {
		return PAC_BCH_CODE;
	}

	public void setPAC_BCH_CODE(String pac_bch_code) {
		PAC_BCH_CODE = pac_bch_code;
	}


	public String getPAC_BCH_TERM() {
		return PAC_BCH_TERM;
	}

	public void setPAC_BCH_TERM(String pac_bch_term) {
		PAC_BCH_TERM = pac_bch_term;
	}

	public String getPAC_COVER_START_AGE_VAL_YN() {
		return PAC_COVER_START_AGE_VAL_YN;
	}

	public void setPAC_COVER_START_AGE_VAL_YN(String pac_cover_start_age_val_yn) {
		PAC_COVER_START_AGE_VAL_YN = pac_cover_start_age_val_yn;
	}

	public String getPAC_AGE_BASIS() {
		return PAC_AGE_BASIS;
	}

	public void setPAC_AGE_BASIS(String pac_age_basis) {
		PAC_AGE_BASIS = pac_age_basis;
	}

	public String getPAC_TARIFF_TERM_FLAG() {
		return PAC_TARIFF_TERM_FLAG;
	}

	public void setPAC_TARIFF_TERM_FLAG(String pac_tariff_term_flag) {
		PAC_TARIFF_TERM_FLAG = pac_tariff_term_flag;
	}

	public Double getPAC_PRODUCTION_PERC() {
		return PAC_PRODUCTION_PERC;
	}

	public void setPAC_PRODUCTION_PERC(Double pac_production_perc) {
		PAC_PRODUCTION_PERC = pac_production_perc;
	}

	public Double getPAC_THRESHOLD_PERC() {
		return PAC_THRESHOLD_PERC;
	}

	public void setPAC_THRESHOLD_PERC(Double pac_threshold_perc) {
		PAC_THRESHOLD_PERC = pac_threshold_perc;
	}

	public Integer getPAC_PREM_PAY_YRS() {
		return PAC_PREM_PAY_YRS;
	}

	public void setPAC_PREM_PAY_YRS(Integer pac_prem_pay_yrs) {
		PAC_PREM_PAY_YRS = pac_prem_pay_yrs;
	}

	public Integer getPAC_MAX_AGE_ON_MAT() {
		return PAC_MAX_AGE_ON_MAT;
	}

	public void setPAC_MAX_AGE_ON_MAT(Integer pac_max_age_on_mat) {
		PAC_MAX_AGE_ON_MAT = pac_max_age_on_mat;
	}

	public Double getPAC_GRP_THRESHOLD_PERC() {
		return PAC_GRP_THRESHOLD_PERC;
	}

	public void setPAC_GRP_THRESHOLD_PERC(Double pac_grp_threshold_perc) {
		PAC_GRP_THRESHOLD_PERC = pac_grp_threshold_perc;
	}

	public Integer getPAC_PERIOD() {
		return PAC_PERIOD;
	}

	public void setPAC_PERIOD(Integer pac_period) {
		PAC_PERIOD = pac_period;
	}

	public String getPAC_MANDATORY_YN() {
		return PAC_MANDATORY_YN;
	}

	public void setPAC_MANDATORY_YN(String pac_mandatory_yn) {
		PAC_MANDATORY_YN = pac_mandatory_yn;
	}

	public String getPAC_DEFAULT_YN() {
		return PAC_DEFAULT_YN;
	}

	public void setPAC_DEFAULT_YN(String pac_default_yn) {
		PAC_DEFAULT_YN = pac_default_yn;
	}


	public Date getPAC_CR_DT() {
		return PAC_CR_DT;
	}

	public void setPAC_CR_DT(Date pac_cr_dt) {
		PAC_CR_DT = pac_cr_dt;
	}


	public Double getPAC_MED_AMT() {
		return PAC_MED_AMT;
	}

	public void setPAC_MED_AMT(Double pac_med_amt) {
		PAC_MED_AMT = pac_med_amt;
	}

	public String getUI_M_PAC_COVER_CODE_DESC() {
		return UI_M_PAC_COVER_CODE_DESC;
	}

	public void setUI_M_PAC_COVER_CODE_DESC(String ui_m_pac_cover_code_desc) {
		UI_M_PAC_COVER_CODE_DESC = ui_m_pac_cover_code_desc;
	}

	public String getUI_M_PAC_BCH_CODE_DESC() {
		return UI_M_PAC_BCH_CODE_DESC;
	}

	public void setUI_M_PAC_BCH_CODE_DESC(String ui_m_pac_bch_code_desc) {
		UI_M_PAC_BCH_CODE_DESC = ui_m_pac_bch_code_desc;
	}

	
	
	
	
}


