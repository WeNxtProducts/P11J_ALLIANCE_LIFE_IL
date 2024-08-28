package com.iii.pel.forms.PILM035_APAC;
import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_PROD_APPL_COVER")
public class PM_IL_PROD_APPL_COVER extends BaseValueBean{

	
	@Column(name="PAC_GROUP_CVR_CODE")
	private String PAC_GROUP_CVR_CODE;
	
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
	/*added by gopi for ssp call id ZBILQC-1719437 on 27/01/17*/
	
	@Column(name="PAC_ATT_CVR_YN")
	private String PAC_ATT_CVR_YN;
	
	public String getPAC_ATT_CVR_YN() {
		return PAC_ATT_CVR_YN;
	}
	public void setPAC_ATT_CVR_YN(String pAC_ATT_CVR_YN) {
		PAC_ATT_CVR_YN = pAC_ATT_CVR_YN;
	}
	/*end*/
	
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
	
	private String UI_M_PAC_SA_FACTOR_DESC;
	private String UI_M_PAC_SA_TARIFF_DESC;
	private String UI_M_PAC_PREM_TARIFF_DESC;
	private String UI_M_PAC_SA_ADD_FACTOR_DESC;
	



	public String getUI_M_PAC_SA_ADD_FACTOR_DESC() {
		return UI_M_PAC_SA_ADD_FACTOR_DESC;
	}

	public void setUI_M_PAC_SA_ADD_FACTOR_DESC(String ui_m_pac_sa_add_factor_desc) {
		UI_M_PAC_SA_ADD_FACTOR_DESC = ui_m_pac_sa_add_factor_desc;
	}

	public String getUI_M_PAC_PREM_TARIFF_DESC() {
		return UI_M_PAC_PREM_TARIFF_DESC;
	}

	public void setUI_M_PAC_PREM_TARIFF_DESC(String ui_m_pac_prem_tariff_desc) {
		UI_M_PAC_PREM_TARIFF_DESC = ui_m_pac_prem_tariff_desc;
	}

	public String getUI_M_PAC_SA_TARIFF_DESC() {
		return UI_M_PAC_SA_TARIFF_DESC;
	}

	public void setUI_M_PAC_SA_TARIFF_DESC(String ui_m_pac_sa_tariff_desc) {
		UI_M_PAC_SA_TARIFF_DESC = ui_m_pac_sa_tariff_desc;
	}

	public String getUI_M_PAC_SA_FACTOR_DESC() {
		return UI_M_PAC_SA_FACTOR_DESC;
	}

	public void setUI_M_PAC_SA_FACTOR_DESC(String ui_m_pac_sa_factor_desc) {
		UI_M_PAC_SA_FACTOR_DESC = ui_m_pac_sa_factor_desc;
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

	public String getPAC_PROD_CODE() {
		 return PAC_PROD_CODE;
	}

	public void setPAC_PROD_CODE(String PAC_PROD_CODE) {
		this.PAC_PROD_CODE = PAC_PROD_CODE;
	}

	public String getPAC_COVER_CODE() {
		 return PAC_COVER_CODE;
	}

	public void setPAC_COVER_CODE(String PAC_COVER_CODE) {
		this.PAC_COVER_CODE = PAC_COVER_CODE;
	}

	public String getPAC_MANDATORY_YN() {
		 return PAC_MANDATORY_YN;
	}

	public void setPAC_MANDATORY_YN(String PAC_MANDATORY_YN) {
		this.PAC_MANDATORY_YN = PAC_MANDATORY_YN;
	}

	public String getPAC_DEFAULT_YN() {
		 return PAC_DEFAULT_YN;
	}

	public void setPAC_DEFAULT_YN(String PAC_DEFAULT_YN) {
		this.PAC_DEFAULT_YN = PAC_DEFAULT_YN;
	}

	public String getPAC_TARIFF_TERM_FLAG() {
		 return PAC_TARIFF_TERM_FLAG;
	}

	public void setPAC_TARIFF_TERM_FLAG(String PAC_TARIFF_TERM_FLAG) {
		this.PAC_TARIFF_TERM_FLAG = PAC_TARIFF_TERM_FLAG;
	}

	public Date getPAC_CR_DT() {
		 return PAC_CR_DT;
	}

	public void setPAC_CR_DT(Date PAC_CR_DT) {
		this.PAC_CR_DT = PAC_CR_DT;
	}

	public String getPAC_CR_UID() {
		 return PAC_CR_UID;
	}

	public void setPAC_CR_UID(String PAC_CR_UID) {
		this.PAC_CR_UID = PAC_CR_UID;
	}

	public Date getPAC_UPD_DT() {
		 return PAC_UPD_DT;
	}

	public void setPAC_UPD_DT(Date PAC_UPD_DT) {
		this.PAC_UPD_DT = PAC_UPD_DT;
	}

	public String getPAC_UPD_UID() {
		 return PAC_UPD_UID;
	}

	public void setPAC_UPD_UID(String PAC_UPD_UID) {
		this.PAC_UPD_UID = PAC_UPD_UID;
	}

	

	public Integer getPAC_MAX_AGE_ON_MAT() {
		return PAC_MAX_AGE_ON_MAT;
	}

	public void setPAC_MAX_AGE_ON_MAT(Integer pac_max_age_on_mat) {
		PAC_MAX_AGE_ON_MAT = pac_max_age_on_mat;
	}

	
	public Integer getPAC_PERIOD() {
		return PAC_PERIOD;
	}

	public void setPAC_PERIOD(Integer pac_period) {
		PAC_PERIOD = pac_period;
	}


	public Integer getPAC_PREM_PAY_YRS() {
		return PAC_PREM_PAY_YRS;
	}

	public void setPAC_PREM_PAY_YRS(Integer pac_prem_pay_yrs) {
		PAC_PREM_PAY_YRS = pac_prem_pay_yrs;
	}

	public String getPAC_BCH_CODE() {
		 return PAC_BCH_CODE;
	}

	public void setPAC_BCH_CODE(String PAC_BCH_CODE) {
		this.PAC_BCH_CODE = PAC_BCH_CODE;
	}

	public String getPAC_BCH_TERM() {
		 return PAC_BCH_TERM;
	}

	public void setPAC_BCH_TERM(String PAC_BCH_TERM) {
		this.PAC_BCH_TERM = PAC_BCH_TERM;
	}

	public Double getPAC_PRODUCTION_PERC() {
		 return PAC_PRODUCTION_PERC;
	}

	public void setPAC_PRODUCTION_PERC(Double PAC_PRODUCTION_PERC) {
		this.PAC_PRODUCTION_PERC = PAC_PRODUCTION_PERC;
	}

	public Double getPAC_THRESHOLD_PERC() {
		 return PAC_THRESHOLD_PERC;
	}

	public void setPAC_THRESHOLD_PERC(Double PAC_THRESHOLD_PERC) {
		this.PAC_THRESHOLD_PERC = PAC_THRESHOLD_PERC;
	}

	
	public Integer getPAC_MED_DAYS() {
		return PAC_MED_DAYS;
	}

	public void setPAC_MED_DAYS(Integer pac_med_days) {
		PAC_MED_DAYS = pac_med_days;
	}

	public Double getPAC_MED_AMT() {
		 return PAC_MED_AMT;
	}

	public void setPAC_MED_AMT(Double PAC_MED_AMT) {
		this.PAC_MED_AMT = PAC_MED_AMT;
	}

	public String getPAC_MASTER_COVER_CODE() {
		 return PAC_MASTER_COVER_CODE;
	}

	public void setPAC_MASTER_COVER_CODE(String PAC_MASTER_COVER_CODE) {
		this.PAC_MASTER_COVER_CODE = PAC_MASTER_COVER_CODE;
	}

	public Double getPAC_GRP_THRESHOLD_PERC() {
		 return PAC_GRP_THRESHOLD_PERC;
	}

	public void setPAC_GRP_THRESHOLD_PERC(Double PAC_GRP_THRESHOLD_PERC) {
		this.PAC_GRP_THRESHOLD_PERC = PAC_GRP_THRESHOLD_PERC;
	}

	public String getPAC_RSA_CALC_YN() {
		 return PAC_RSA_CALC_YN;
	}

	public void setPAC_RSA_CALC_YN(String PAC_RSA_CALC_YN) {
		this.PAC_RSA_CALC_YN = PAC_RSA_CALC_YN;
	}

	public String getPAC_SA_FACTOR() {
		 return PAC_SA_FACTOR;
	}

	public void setPAC_SA_FACTOR(String PAC_SA_FACTOR) {
		this.PAC_SA_FACTOR = PAC_SA_FACTOR;
	}

	public String getPAC_SA_TARIFF() {
		 return PAC_SA_TARIFF;
	}

	public void setPAC_SA_TARIFF(String PAC_SA_TARIFF) {
		this.PAC_SA_TARIFF = PAC_SA_TARIFF;
	}

	public String getPAC_PREM_TARIFF() {
		 return PAC_PREM_TARIFF;
	}

	public void setPAC_PREM_TARIFF(String PAC_PREM_TARIFF) {
		this.PAC_PREM_TARIFF = PAC_PREM_TARIFF;
	}

	public String getPAC_COVER_ASSR_TYPE() {
		 return PAC_COVER_ASSR_TYPE;
	}

	public void setPAC_COVER_ASSR_TYPE(String PAC_COVER_ASSR_TYPE) {
		this.PAC_COVER_ASSR_TYPE = PAC_COVER_ASSR_TYPE;
	}

	public String getPAC_COVER_START_AGE_VAL_YN() {
		 return PAC_COVER_START_AGE_VAL_YN;
	}

	public void setPAC_COVER_START_AGE_VAL_YN(String PAC_COVER_START_AGE_VAL_YN) {
		this.PAC_COVER_START_AGE_VAL_YN = PAC_COVER_START_AGE_VAL_YN;
	}

	public String getPAC_AGE_BASIS() {
		 return PAC_AGE_BASIS;
	}

	public void setPAC_AGE_BASIS(String PAC_AGE_BASIS) {
		this.PAC_AGE_BASIS = PAC_AGE_BASIS;
	}

	
	public Integer getPAC_COVER_START_AGE() {
		return PAC_COVER_START_AGE;
	}

	public void setPAC_COVER_START_AGE(Integer pac_cover_start_age) {
		PAC_COVER_START_AGE = pac_cover_start_age;
	}

	public Integer getPAC_MAT_PAYER_AGE() {
		return PAC_MAT_PAYER_AGE;
	}

	public void setPAC_MAT_PAYER_AGE(Integer pac_mat_payer_age) {
		PAC_MAT_PAYER_AGE = pac_mat_payer_age;
	}

	public Integer getPAC_MAT_PAYEE_AGE() {
		return PAC_MAT_PAYEE_AGE;
	}

	public void setPAC_MAT_PAYEE_AGE(Integer pac_mat_payee_age) {
		PAC_MAT_PAYEE_AGE = pac_mat_payee_age;
	}

	public String getPAC_SA_ADD_FACTOR() {
		 return PAC_SA_ADD_FACTOR;
	}

	public void setPAC_SA_ADD_FACTOR(String PAC_SA_ADD_FACTOR) {
		this.PAC_SA_ADD_FACTOR = PAC_SA_ADD_FACTOR;
	}

	public Integer getPAC_COOL_OF_PD() {
		return PAC_COOL_OF_PD;
	}

	public void setPAC_COOL_OF_PD(Integer pac_cool_of_pd) {
		PAC_COOL_OF_PD = pac_cool_of_pd;
	}

	public String getPAC_GROUP_CVR_CODE() {
		return PAC_GROUP_CVR_CODE;
	}

	public void setPAC_GROUP_CVR_CODE(String pac_group_cvr_code) {
		PAC_GROUP_CVR_CODE = pac_group_cvr_code;
	}

	/*Added by Ram on 19/11/2016 for Product Cover Attached field addition*/
	@Column(name="PAC_ATT_CVR_CODE")
	private String PAC_ATT_CVR_CODE;
	private String PAC_ATTACHED_COVER_DESC;

 

	public String getPAC_ATT_CVR_CODE() {
		return PAC_ATT_CVR_CODE;
	}

	public void setPAC_ATT_CVR_CODE(String pAC_ATT_CVR_CODE) {
		PAC_ATT_CVR_CODE = pAC_ATT_CVR_CODE;
	}

	public String getPAC_ATTACHED_COVER_DESC() {
		return PAC_ATTACHED_COVER_DESC;
	}

	public void setPAC_ATTACHED_COVER_DESC(String pAC_ATTACHED_COVER_DESC) {
		PAC_ATTACHED_COVER_DESC = pAC_ATTACHED_COVER_DESC;
	}
	/*End*/
}
