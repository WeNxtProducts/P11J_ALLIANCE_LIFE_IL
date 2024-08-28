package com.iii.pel.forms.PILM035_APAC;

import java.util.Date;

import javax.faces.component.html.HtmlInputText;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_IL_PRODUCT")
public class PM_IL_PRODUCT extends BaseValueBean {

	@Column(name = "PROD_CODE")
	private String PROD_CODE;

	@Column(name = "PROD_DESC")
	private String PROD_DESC;

	@Column(name = "PROD_SHORT_DESC")
	private String PROD_SHORT_DESC;

	@Column(name = "PROD_LONG_DESC")
	private String PROD_LONG_DESC;

	@Column(name = "PROD_BL_DESC")
	private String PROD_BL_DESC;

	@Column(name = "PROD_BL_SHORT_DESC")
	private String PROD_BL_SHORT_DESC;

	@Column(name = "PROD_BL_LONG_DESC")
	private String PROD_BL_LONG_DESC;

	@Column(name = "PROD_PLAN_CODE")
	private String PROD_PLAN_CODE;

	@Column(name = "PROD_PERIOD")
	private Integer PROD_PERIOD;

	@Column(name = "PROD_PREM_PAY_YRS")
	private Integer PROD_PREM_PAY_YRS;

	@Column(name = "PROD_AGE_CALC_FLAG")
	private String PROD_AGE_CALC_FLAG;

	@Column(name = "PROD_JOINT_LIFE_YN")
	private String PROD_JOINT_LIFE_YN;

	@Column(name = "PROD_TARIFF_TERM_FLAG")
	private String PROD_TARIFF_TERM_FLAG;

	@Column(name = "PROD_PERIOD_MULTIPLE")
	private Integer PROD_PERIOD_MULTIPLE;

	@Column(name = "PROD_SA_INST_PYMT_TYPE")
	private String PROD_SA_INST_PYMT_TYPE;

	@Column(name = "PROD_EFF_FM_DT")
	private Date PROD_EFF_FM_DT;

	@Column(name = "PROD_EFF_TO_DT")
	private Date PROD_EFF_TO_DT;

	@Column(name = "PROD_CR_DT")
	private Date PROD_CR_DT;

	@Column(name = "PROD_CR_UID")
	private String PROD_CR_UID;

	@Column(name = "PROD_UPD_DT")
	private Date PROD_UPD_DT;

	@Column(name = "PROD_UPD_UID")
	private String PROD_UPD_UID;

	@Column(name = "PROD_ENDT_VAL_DAYS")
	private Integer PROD_ENDT_VAL_DAYS;

	@Column(name = "PROD_MAX_DEFER_MONTHS")
	private Integer PROD_MAX_DEFER_MONTHS;

	@Column(name = "PROD_COOLOFF_DAYS")
	private Integer PROD_COOLOFF_DAYS;

	@Column(name = "PROD_EXP_LOAD_RATE")
	private Double PROD_EXP_LOAD_RATE;

	@Column(name = "PROD_EXP_LOAD_RATE_PER")
	private Integer PROD_EXP_LOAD_RATE_PER;

	@Column(name = "PROD_CONT_LOAD_RATE")
	private Double PROD_CONT_LOAD_RATE;

	@Column(name = "PROD_CONT_LOAD_RATE_PER")
	private Integer PROD_CONT_LOAD_RATE_PER;

	@Column(name = "PROD_MORT_CODE")
	private String PROD_MORT_CODE;

	@Column(name = "PROD_EMI_TOLERANCE")
	private Integer PROD_EMI_TOLERANCE;

	@Column(name = "PROD_CBC_YN")
	private String PROD_CBC_YN;

	@Column(name = "PROD_AGE_SET_BACK")
	private Integer PROD_AGE_SET_BACK;

	@Column(name = "PROD_WITHDRAW_YN")
	private String PROD_WITHDRAW_YN;

	@Column(name = "PROD_TOPUP_YN")
	private String PROD_TOPUP_YN;

	@Column(name = "PROD_TOPUP_MIN_YRS")
	private Double PROD_TOPUP_MIN_YRS;

	@Column(name = "PROD_BCH_CODE")
	private String PROD_BCH_CODE;

	@Column(name = "PROD_COMM_RND_DEC")
	private Integer PROD_COMM_RND_DEC;

	@Column(name = "PROD_COMM_RND_TYPE")
	private String PROD_COMM_RND_TYPE;

	@Column(name = "PROD_BROK_CALC_MTHD")
	private String PROD_BROK_CALC_MTHD;

	@Column(name = "PROD_PRODUCTION_PERC")
	private Double PROD_PRODUCTION_PERC;

	@Column(name = "PROD_THRESHOLD_PERC")
	private Double PROD_THRESHOLD_PERC;

	@Column(name = "PROD_DS_CODE")
	private String PROD_DS_CODE;

	@Column(name = "PROD_TOPUP_PROD_PERC")
	private Double PROD_TOPUP_PROD_PERC;

	@Column(name = "PROD_PREM_CALC_MTHD")
	private String PROD_PREM_CALC_MTHD;

	@Column(name = "PROD_INST_BASIS")
	private String PROD_INST_BASIS;

	@Column(name = "PROD_INST_PERC")
	private Double PROD_INST_PERC;

	@Column(name = "PROD_AUTO_APPROV")
	private String PROD_AUTO_APPROV;

	@Column(name = "PROD_INST_RATE_PER")
	private Double PROD_INST_RATE_PER;

	@Column(name = "PROD_TOPUP_COMM_CODE")
	private String PROD_TOPUP_COMM_CODE;

	@Column(name = "PROD_ALLOC_TYPE")
	private String PROD_ALLOC_TYPE;

	@Column(name = "PROD_BUY_BASIS")
	private String PROD_BUY_BASIS;

	@Column(name = "PROD_AUTO_UW")
	private String PROD_AUTO_UW;

	@Column(name = "PROD_PREM_TARIFF")
	private String PROD_PREM_TARIFF;

	@Column(name = "PROD_SA_TARIFF")
	private String PROD_SA_TARIFF;

	@Column(name = "PROD_CALC_ALLOC")
	private String PROD_CALC_ALLOC;

	@Column(name = "PROD_SA_FACTOR")
	private String PROD_SA_FACTOR;

	@Column(name = "PROD_ROUND_OPTION")
	private String PROD_ROUND_OPTION;

	@Column(name = "PROD_ROUND_VALUE")
	private Integer PROD_ROUND_VALUE;

	@Column(name = "PROD_MAT_AMT_TYPE")
	private String PROD_MAT_AMT_TYPE;

	@Column(name = "PROD_MAT_RATE")
	private Double PROD_MAT_RATE;

	@Column(name = "PROD_MAT_RATE_PER")
	private Integer PROD_MAT_RATE_PER;

	@Column(name = "PROD_FUND_FEE")
	private Double PROD_FUND_FEE;

	@Column(name = "PROD_FUND_FEE_RATE_PER")
	private Double PROD_FUND_FEE_RATE_PER;

	@Column(name = "PROD_MRTA_RATE_CALC_YN")
	private String PROD_MRTA_RATE_CALC_YN;

	@Column(name = "PROD_TOPUP_CHARGE_TYPE")
	private String PROD_TOPUP_CHARGE_TYPE;

	@Column(name = "PROD_PREM_HOLIDAY_CODE")
	private String PROD_PREM_HOLIDAY_CODE;

	@Column(name = "PROD_LOAD_CHARGE_YN")
	private String PROD_LOAD_CHARGE_YN;

	@Column(name = "PROD_PRODUCT_TYPE")
	private String PROD_PRODUCT_TYPE;

	@Column(name = "PROD_GRP_THRESHOLD_PERC")
	private Double PROD_GRP_THRESHOLD_PERC;

	@Column(name = "PROD_MODE_OF_CALC")
	private String PROD_MODE_OF_CALC;

	@Column(name = "PROD_THR_BASIS")
	private String PROD_THR_BASIS;

	@Column(name = "PROD_SURR_CALC_TYPE")
	private String PROD_SURR_CALC_TYPE;

	@Column(name = "PROD_PRS_YN")
	private String PROD_PRS_YN;

	@Column(name = "PROD_SURR_PLUS_FACTOR")
	private String PROD_SURR_PLUS_FACTOR;

	@Column(name = "PROD_AGENT_HIRE_YN")
	private String PROD_AGENT_HIRE_YN;

	@Column(name = "PROD_MATU_DT")
	private String PROD_MATU_DT;

	@Column(name = "PROD_DEF_PERIOD_FLAG")
	private String PROD_DEF_PERIOD_FLAG;

	@Column(name = "PROD_RSA_CALC_TYP")
	private String PROD_RSA_CALC_TYP;

	@Column(name = "PROD_SURRENDER_FACTOR")
	private String PROD_SURRENDER_FACTOR;

	@Column(name = "PROD_TOLL_LIMIT_YN")
	private String PROD_TOLL_LIMIT_YN;

	@Column(name = "PROD_INTER_FUND_YN")
	private String PROD_INTER_FUND_YN;

	@Column(name = "PROD_WITHDRAW_AMT_MULTIPLE")
	private Double PROD_WITHDRAW_AMT_MULTIPLE;

	@Column(name = "PROD_RI_RECOV_BASIS")
	private String PROD_RI_RECOV_BASIS;

	@Column(name = "PROD_SERVICE_TAX_YN")
	private String PROD_SERVICE_TAX_YN;

	@Column(name = "PROD_DRIP_MTHD")
	private String PROD_DRIP_MTHD;

	@Column(name = "PROD_SA_BY_PLAN_BASIS_YN")
	private String PROD_SA_BY_PLAN_BASIS_YN;

	@Column(name = "PROD_MASTER_CERT_YN")
	private String PROD_MASTER_CERT_YN;

	@Column(name = "PROD_FUND_ALLOWED")
	private String PROD_FUND_ALLOWED;
	
	@Column(name = "PROD_DEF_PERIOD_FM")
	private Integer PROD_DEF_PERIOD_FM;
	
	@Column(name = "PROD_DEF_PERIOD_TO")
	private Integer PROD_DEF_PERIOD_TO;
	

	
	  @Column(name = "PROD_WAKFEE_FACTOR") 
	  private String PROD_WAKFEE_FACTOR;
	 

	 @Column(name = "PROD_WAQAF_PERIOD_FM")
	 private Integer PROD_WAQAF_PERIOD_FM;
	
	 @Column(name = "PROD_WAQAF_PERIOD_TO") 
	 private Integer PROD_WAQAF_PERIOD_TO;
	 

	
	  @Column(name = "PROD_AFTWD_LC_MINBAL") 
	  private Double PROD_AFTWD_LC_MINBAL;
	 

	
	 @Column(name = "PROD_TOPUP_MULTIPLE") 
	 private Double PROD_TOPUP_MULTIPLE;
	 

	
	  @Column(name = "PROD_TOPUP_WAK_CODE") 
	  private String PROD_TOPUP_WAK_CODE;
	 

	
	  @Column(name = "PROD_MIN_SURR_AMT") 
	  private Double PROD_MIN_SURR_AMT;
	 

	
	  @Column(name = "PROD_SA_ADD_FACTOR") 
	  private String PROD_SA_ADD_FACTOR;
	 

	
	  @Column(name = "PROD_DRIP_LIMIT") 
	  private String PROD_DRIP_LIMIT;
	 

	
	  @Column(name = "PROD_TOL_CHK_YN") 
	  private String PROD_TOL_CHK_YN;
	 

	
	 @Column(name = "PROD_TRAN_RATE_YN") 
	 private String PROD_TRAN_RATE_YN;
	 

/*	@Column(name = "PROD_PREM_COMP_EVENT") 
	private String PROD_PREM_COMP_EVENT;
	*/
	@Column(name = "PROD_FLEX_01")
	private String PROD_FLEX_01;
	
	@Column(name = "PROD_REM_YN")
	private String PROD_REM_YN="N";
	
	@Column(name = "PROD_REM_1")
	private Integer PROD_REM_1;
	
	@Column(name = "PROD_REM_2")
	private Integer PROD_REM_2;
	
	@Column(name = "PROD_REM_3")
	private Integer PROD_REM_3;
	
	@Column(name = "PROD_SAL_MULTIPLE")
	private Integer PROD_SAL_MULTIPLE;
	
	@Column(name = "PROD_INC_WEIGHT")
	private Double PROD_INC_WEIGHT;
	
	private String APL_YES_NO;
	
    private int PROD_INS_AGE_FM;
	
	private int PROD_INS_AGE_TO;
	
	private String PROD_INS_SA_FM;
	
	private String PROD_INS_SA_TO;
	
	private String PROD_INS_TM_FM;
	
	private String PROD_INS_TM_TO;
	
	/*added by gopi for RM018T - DEV_IL_ZB Life_022-Automated Premium Loan*/

	@Column(name = "PROD_APL_YN")
	private String PROD_APL_YN;

	private String PROD_MORT_CODE_DESC;

	private String PROD_PREM_TARIFF_DESC;

	private String PROD_SA_TARIFF_DESC;

	private String PROD_SA_FACTOR_DESC;

	private String PROD_PREM_HOLIDAY_CODE_DESC;

	private String PROD_TOPUP_COMM_DESCRIPTION;

	private boolean RecordStatus;
	
	private String PROD_SURRENDER_FACTOR_DESC;
	
	private String UI_M_PROD_PLAN_CODE_DESC;
	
	private String UI_M_PROD_DS_CODE_DESC;
	
	private String UI_M_PAP_SUB_PLAN_CODE;
	
	private String UI_M_PROD_TOPUP_COMM_DESCRIPTION;
	
	private String UI_M_PROD_PREM_HOLIDAY_CODE_DESC;
	
	private int RecordIndex;
	
	private String PROD_POL_VALID_AFTER_MAT_YN;
	
	private Integer PROD_SURR_YRS;
	
	private String PROD_SURR_PLUS_FACTOR_DESC;
	
	private Integer PROD_MIN_SA;
	
	private Integer PROD_MAX_AGE_ON_MAT;
	
	private String PROD_BCH_CODE_DESC;
	
	private Integer PROD_MAX_SA;
	
	private String PROD_WAKFEE_FACTOR_DESC;
	
	private String PROD_SA_ADD_FACTOR_DESC;
	
	private String UI_M_PROD_WAK_CODE_DESC;
	

	public String getUI_M_PROD_WAK_CODE_DESC() {
		return UI_M_PROD_WAK_CODE_DESC;
	}

	public void setUI_M_PROD_WAK_CODE_DESC(String ui_m_prod_wak_code_desc) {
		UI_M_PROD_WAK_CODE_DESC = ui_m_prod_wak_code_desc;
	}

	public String getPROD_WAKFEE_FACTOR_DESC() {
		return PROD_WAKFEE_FACTOR_DESC;
	}

	public void setPROD_WAKFEE_FACTOR_DESC(String prod_wakfee_factor_desc) {
		PROD_WAKFEE_FACTOR_DESC = prod_wakfee_factor_desc;
	}

	public Integer getPROD_MAX_SA() {
		return PROD_MAX_SA;
	}

	public void setPROD_MAX_SA(Integer prod_max_sa) {
		PROD_MAX_SA = prod_max_sa;
	}

	public String getPROD_BCH_CODE_DESC() {
		return PROD_BCH_CODE_DESC;
	}

	public void setPROD_BCH_CODE_DESC(String prod_bch_code_desc) {
		PROD_BCH_CODE_DESC = prod_bch_code_desc;
	}

	public String getPROD_TOPUP_COMM_DESCRIPTION() {
		return PROD_TOPUP_COMM_DESCRIPTION;
	}

	public void setPROD_TOPUP_COMM_DESCRIPTION(
			String prod_topup_comm_description) {
		PROD_TOPUP_COMM_DESCRIPTION = prod_topup_comm_description;
	}

	public String getPROD_PREM_HOLIDAY_CODE_DESC() {
		return PROD_PREM_HOLIDAY_CODE_DESC;
	}

	public void setPROD_PREM_HOLIDAY_CODE_DESC(
			String prod_prem_holiday_code_desc) {
		PROD_PREM_HOLIDAY_CODE_DESC = prod_prem_holiday_code_desc;
	}

	public String getPROD_SA_FACTOR_DESC() {
		return PROD_SA_FACTOR_DESC;
	}

	public void setPROD_SA_FACTOR_DESC(String prod_sa_factor_desc) {
		PROD_SA_FACTOR_DESC = prod_sa_factor_desc;
	}

	public String getPROD_SA_TARIFF_DESC() {
		return PROD_SA_TARIFF_DESC;
	}

	public void setPROD_SA_TARIFF_DESC(String prod_sa_tariff_desc) {
		PROD_SA_TARIFF_DESC = prod_sa_tariff_desc;
	}

	public String getPROD_PREM_TARIFF_DESC() {
		return PROD_PREM_TARIFF_DESC;
	}

	public void setPROD_PREM_TARIFF_DESC(String prod_prem_tariff_desc) {
		PROD_PREM_TARIFF_DESC = prod_prem_tariff_desc;
	}

	public String getPROD_SURR_PLUS_FACTOR_DESC() {
		return PROD_SURR_PLUS_FACTOR_DESC;
	}

	public void setPROD_SURR_PLUS_FACTOR_DESC(String prod_surr_plus_factor_desc) {
		PROD_SURR_PLUS_FACTOR_DESC = prod_surr_plus_factor_desc;
	}

	public String getPROD_MORT_CODE_DESC() {
		return PROD_MORT_CODE_DESC;
	}

	public void setPROD_MORT_CODE_DESC(String prod_mort_code_desc) {
		PROD_MORT_CODE_DESC = prod_mort_code_desc;
	}

	public String getPROD_CODE() {
		return PROD_CODE;
	}

	public void setPROD_CODE(String PROD_CODE) {
		this.PROD_CODE = PROD_CODE;
	}

	public String getPROD_DESC() {
		return PROD_DESC;
	}

	public void setPROD_DESC(String PROD_DESC) {
		this.PROD_DESC = PROD_DESC;
	}

	public String getPROD_SHORT_DESC() {
		return PROD_SHORT_DESC;
	}

	public void setPROD_SHORT_DESC(String PROD_SHORT_DESC) {
		this.PROD_SHORT_DESC = PROD_SHORT_DESC;
	}

	public String getPROD_LONG_DESC() {
		return PROD_LONG_DESC;
	}

	public void setPROD_LONG_DESC(String PROD_LONG_DESC) {
		this.PROD_LONG_DESC = PROD_LONG_DESC;
	}

	public String getPROD_BL_DESC() {
		return PROD_BL_DESC;
	}

	public void setPROD_BL_DESC(String PROD_BL_DESC) {
		this.PROD_BL_DESC = PROD_BL_DESC;
	}

	public String getPROD_BL_SHORT_DESC() {
		return PROD_BL_SHORT_DESC;
	}

	public void setPROD_BL_SHORT_DESC(String PROD_BL_SHORT_DESC) {
		this.PROD_BL_SHORT_DESC = PROD_BL_SHORT_DESC;
	}

	public String getPROD_BL_LONG_DESC() {
		return PROD_BL_LONG_DESC;
	}

	public void setPROD_BL_LONG_DESC(String PROD_BL_LONG_DESC) {
		this.PROD_BL_LONG_DESC = PROD_BL_LONG_DESC;
	}

	public String getPROD_PLAN_CODE() {
		return PROD_PLAN_CODE;
	}

	public void setPROD_PLAN_CODE(String PROD_PLAN_CODE) {
		this.PROD_PLAN_CODE = PROD_PLAN_CODE;
	}

	public Integer getPROD_PERIOD() {
		return PROD_PERIOD;
	}

	public void setPROD_PERIOD(Integer PROD_PERIOD) {
		this.PROD_PERIOD = PROD_PERIOD;
	}

	public Integer getPROD_PREM_PAY_YRS() {
		return PROD_PREM_PAY_YRS;
	}

	public void setPROD_PREM_PAY_YRS(Integer PROD_PREM_PAY_YRS) {
		this.PROD_PREM_PAY_YRS = PROD_PREM_PAY_YRS;
	}

	public String getPROD_AGE_CALC_FLAG() {
		return PROD_AGE_CALC_FLAG;
	}

	public void setPROD_AGE_CALC_FLAG(String PROD_AGE_CALC_FLAG) {
		this.PROD_AGE_CALC_FLAG = PROD_AGE_CALC_FLAG;
	}

	public String getPROD_JOINT_LIFE_YN() {
		return PROD_JOINT_LIFE_YN;
	}

	public void setPROD_JOINT_LIFE_YN(String PROD_JOINT_LIFE_YN) {
		this.PROD_JOINT_LIFE_YN = PROD_JOINT_LIFE_YN;
	}

	public String getPROD_TARIFF_TERM_FLAG() {
		return PROD_TARIFF_TERM_FLAG;
	}

	public void setPROD_TARIFF_TERM_FLAG(String PROD_TARIFF_TERM_FLAG) {
		this.PROD_TARIFF_TERM_FLAG = PROD_TARIFF_TERM_FLAG;
	}

	public Integer getPROD_PERIOD_MULTIPLE() {
		return PROD_PERIOD_MULTIPLE;
	}

	public void setPROD_PERIOD_MULTIPLE(Integer PROD_PERIOD_MULTIPLE) {
		this.PROD_PERIOD_MULTIPLE = PROD_PERIOD_MULTIPLE;
	}

	public String getPROD_SA_INST_PYMT_TYPE() {
		return PROD_SA_INST_PYMT_TYPE;
	}

	public void setPROD_SA_INST_PYMT_TYPE(String PROD_SA_INST_PYMT_TYPE) {
		this.PROD_SA_INST_PYMT_TYPE = PROD_SA_INST_PYMT_TYPE;
	}

	public Date getPROD_EFF_FM_DT() {
		return PROD_EFF_FM_DT;
	}

	public void setPROD_EFF_FM_DT(Date PROD_EFF_FM_DT) {
		this.PROD_EFF_FM_DT = PROD_EFF_FM_DT;
	}

	public Date getPROD_EFF_TO_DT() {
		return PROD_EFF_TO_DT;
	}

	public void setPROD_EFF_TO_DT(Date PROD_EFF_TO_DT) {
		this.PROD_EFF_TO_DT = PROD_EFF_TO_DT;
	}

	public Date getPROD_CR_DT() {
		return PROD_CR_DT;
	}

	public void setPROD_CR_DT(Date PROD_CR_DT) {
		this.PROD_CR_DT = PROD_CR_DT;
	}

	public String getPROD_CR_UID() {
		return PROD_CR_UID;
	}

	public void setPROD_CR_UID(String PROD_CR_UID) {
		this.PROD_CR_UID = PROD_CR_UID;
	}

	public Date getPROD_UPD_DT() {
		return PROD_UPD_DT;
	}

	public void setPROD_UPD_DT(Date PROD_UPD_DT) {
		this.PROD_UPD_DT = PROD_UPD_DT;
	}

	public String getPROD_UPD_UID() {
		return PROD_UPD_UID;
	}

	public void setPROD_UPD_UID(String PROD_UPD_UID) {
		this.PROD_UPD_UID = PROD_UPD_UID;
	}

	public Integer getPROD_ENDT_VAL_DAYS() {
		return PROD_ENDT_VAL_DAYS;
	}

	public void setPROD_ENDT_VAL_DAYS(Integer prod_endt_val_days) {
		PROD_ENDT_VAL_DAYS = prod_endt_val_days;
	}

	public Integer getPROD_MAX_DEFER_MONTHS() {
		return PROD_MAX_DEFER_MONTHS;
	}

	public void setPROD_MAX_DEFER_MONTHS(Integer prod_max_defer_months) {
		PROD_MAX_DEFER_MONTHS = prod_max_defer_months;
	}

	public Integer getPROD_COOLOFF_DAYS() {
		return PROD_COOLOFF_DAYS;
	}

	public void setPROD_COOLOFF_DAYS(Integer prod_cooloff_days) {
		PROD_COOLOFF_DAYS = prod_cooloff_days;
	}

	public Double getPROD_EXP_LOAD_RATE() {
		return PROD_EXP_LOAD_RATE;
	}

	public void setPROD_EXP_LOAD_RATE(Double PROD_EXP_LOAD_RATE) {
		this.PROD_EXP_LOAD_RATE = PROD_EXP_LOAD_RATE;
	}

	public Integer getPROD_EXP_LOAD_RATE_PER() {
		return PROD_EXP_LOAD_RATE_PER;
	}

	public void setPROD_EXP_LOAD_RATE_PER(Integer prod_exp_load_rate_per) {
		PROD_EXP_LOAD_RATE_PER = prod_exp_load_rate_per;
	}

	public Double getPROD_CONT_LOAD_RATE() {
		return PROD_CONT_LOAD_RATE;
	}

	public void setPROD_CONT_LOAD_RATE(Double PROD_CONT_LOAD_RATE) {
		this.PROD_CONT_LOAD_RATE = PROD_CONT_LOAD_RATE;
	}

	public Integer getPROD_CONT_LOAD_RATE_PER() {
		return PROD_CONT_LOAD_RATE_PER;
	}

	public void setPROD_CONT_LOAD_RATE_PER(Integer prod_cont_load_rate_per) {
		PROD_CONT_LOAD_RATE_PER = prod_cont_load_rate_per;
	}

	public String getPROD_MORT_CODE() {
		return PROD_MORT_CODE;
	}

	public void setPROD_MORT_CODE(String PROD_MORT_CODE) {
		this.PROD_MORT_CODE = PROD_MORT_CODE;
	}

	public Integer getPROD_EMI_TOLERANCE() {
		return PROD_EMI_TOLERANCE;
	}

	public void setPROD_EMI_TOLERANCE(Integer prod_emi_tolerance) {
		PROD_EMI_TOLERANCE = prod_emi_tolerance;
	}

	public String getPROD_CBC_YN() {
		return PROD_CBC_YN;
	}

	public void setPROD_CBC_YN(String PROD_CBC_YN) {
		this.PROD_CBC_YN = PROD_CBC_YN;
	}

	public Integer getPROD_AGE_SET_BACK() {
		return PROD_AGE_SET_BACK;
	}

	public void setPROD_AGE_SET_BACK(Integer prod_age_set_back) {
		PROD_AGE_SET_BACK = prod_age_set_back;
	}

	public String getPROD_WITHDRAW_YN() {
		return PROD_WITHDRAW_YN;
	}

	public void setPROD_WITHDRAW_YN(String PROD_WITHDRAW_YN) {
		this.PROD_WITHDRAW_YN = PROD_WITHDRAW_YN;
	}

	public String getPROD_TOPUP_YN() {
		return PROD_TOPUP_YN;
	}

	public void setPROD_TOPUP_YN(String PROD_TOPUP_YN) {
		this.PROD_TOPUP_YN = PROD_TOPUP_YN;
	}

	public Double getPROD_TOPUP_MIN_YRS() {
		return PROD_TOPUP_MIN_YRS;
	}

	public void setPROD_TOPUP_MIN_YRS(Double PROD_TOPUP_MIN_YRS) {
		this.PROD_TOPUP_MIN_YRS = PROD_TOPUP_MIN_YRS;
	}

	public String getPROD_BCH_CODE() {
		return PROD_BCH_CODE;
	}

	public void setPROD_BCH_CODE(String PROD_BCH_CODE) {
		this.PROD_BCH_CODE = PROD_BCH_CODE;
	}

	public Integer getPROD_COMM_RND_DEC() {
		return PROD_COMM_RND_DEC;
	}

	public void setPROD_COMM_RND_DEC(Integer prod_comm_rnd_dec) {
		PROD_COMM_RND_DEC = prod_comm_rnd_dec;
	}

	public String getPROD_COMM_RND_TYPE() {
		return PROD_COMM_RND_TYPE;
	}

	public void setPROD_COMM_RND_TYPE(String PROD_COMM_RND_TYPE) {
		this.PROD_COMM_RND_TYPE = PROD_COMM_RND_TYPE;
	}

	public String getPROD_BROK_CALC_MTHD() {
		return PROD_BROK_CALC_MTHD;
	}

	public void setPROD_BROK_CALC_MTHD(String PROD_BROK_CALC_MTHD) {
		this.PROD_BROK_CALC_MTHD = PROD_BROK_CALC_MTHD;
	}

	public Double getPROD_PRODUCTION_PERC() {
		return PROD_PRODUCTION_PERC;
	}

	public void setPROD_PRODUCTION_PERC(Double PROD_PRODUCTION_PERC) {
		this.PROD_PRODUCTION_PERC = PROD_PRODUCTION_PERC;
	}

	public Double getPROD_THRESHOLD_PERC() {
		return PROD_THRESHOLD_PERC;
	}

	public void setPROD_THRESHOLD_PERC(Double PROD_THRESHOLD_PERC) {
		this.PROD_THRESHOLD_PERC = PROD_THRESHOLD_PERC;
	}

	public String getPROD_DS_CODE() {
		return PROD_DS_CODE;
	}

	public void setPROD_DS_CODE(String PROD_DS_CODE) {
		this.PROD_DS_CODE = PROD_DS_CODE;
	}

	public Double getPROD_TOPUP_PROD_PERC() {
		return PROD_TOPUP_PROD_PERC;
	}

	public void setPROD_TOPUP_PROD_PERC(Double PROD_TOPUP_PROD_PERC) {
		this.PROD_TOPUP_PROD_PERC = PROD_TOPUP_PROD_PERC;
	}

	public String getPROD_PREM_CALC_MTHD() {
		return PROD_PREM_CALC_MTHD;
	}

	public void setPROD_PREM_CALC_MTHD(String PROD_PREM_CALC_MTHD) {
		this.PROD_PREM_CALC_MTHD = PROD_PREM_CALC_MTHD;
	}

	public String getPROD_INST_BASIS() {
		return PROD_INST_BASIS;
	}

	public void setPROD_INST_BASIS(String PROD_INST_BASIS) {
		this.PROD_INST_BASIS = PROD_INST_BASIS;
	}

	public Double getPROD_INST_PERC() {
		return PROD_INST_PERC;
	}

	public void setPROD_INST_PERC(Double PROD_INST_PERC) {
		this.PROD_INST_PERC = PROD_INST_PERC;
	}

	public String getPROD_AUTO_APPROV() {
		return PROD_AUTO_APPROV;
	}

	public void setPROD_AUTO_APPROV(String PROD_AUTO_APPROV) {
		this.PROD_AUTO_APPROV = PROD_AUTO_APPROV;
	}

	public Double getPROD_INST_RATE_PER() {
		return PROD_INST_RATE_PER;
	}

	public void setPROD_INST_RATE_PER(Double PROD_INST_RATE_PER) {
		this.PROD_INST_RATE_PER = PROD_INST_RATE_PER;
	}

	public String getPROD_TOPUP_COMM_CODE() {
		return PROD_TOPUP_COMM_CODE;
	}

	public void setPROD_TOPUP_COMM_CODE(String PROD_TOPUP_COMM_CODE) {
		this.PROD_TOPUP_COMM_CODE = PROD_TOPUP_COMM_CODE;
	}

	public String getPROD_ALLOC_TYPE() {
		return PROD_ALLOC_TYPE;
	}

	public void setPROD_ALLOC_TYPE(String PROD_ALLOC_TYPE) {
		this.PROD_ALLOC_TYPE = PROD_ALLOC_TYPE;
	}

	public String getPROD_BUY_BASIS() {
		return PROD_BUY_BASIS;
	}

	public void setPROD_BUY_BASIS(String PROD_BUY_BASIS) {
		this.PROD_BUY_BASIS = PROD_BUY_BASIS;
	}

	public String getPROD_AUTO_UW() {
		return PROD_AUTO_UW;
	}

	public void setPROD_AUTO_UW(String PROD_AUTO_UW) {
		this.PROD_AUTO_UW = PROD_AUTO_UW;
	}

	public String getPROD_PREM_TARIFF() {
		return PROD_PREM_TARIFF;
	}

	public void setPROD_PREM_TARIFF(String PROD_PREM_TARIFF) {
		this.PROD_PREM_TARIFF = PROD_PREM_TARIFF;
	}

	public String getPROD_SA_TARIFF() {
		return PROD_SA_TARIFF;
	}

	public void setPROD_SA_TARIFF(String PROD_SA_TARIFF) {
		this.PROD_SA_TARIFF = PROD_SA_TARIFF;
	}

	public String getPROD_CALC_ALLOC() {
		return PROD_CALC_ALLOC;
	}

	public void setPROD_CALC_ALLOC(String PROD_CALC_ALLOC) {
		this.PROD_CALC_ALLOC = PROD_CALC_ALLOC;
	}

	public String getPROD_SA_FACTOR() {
		return PROD_SA_FACTOR;
	}

	public void setPROD_SA_FACTOR(String PROD_SA_FACTOR) {
		this.PROD_SA_FACTOR = PROD_SA_FACTOR;
	}

	public String getPROD_ROUND_OPTION() {
		return PROD_ROUND_OPTION;
	}

	public void setPROD_ROUND_OPTION(String PROD_ROUND_OPTION) {
		this.PROD_ROUND_OPTION = PROD_ROUND_OPTION;
	}

	public Integer getPROD_ROUND_VALUE() {
		return PROD_ROUND_VALUE;
	}

	public void setPROD_ROUND_VALUE(Integer prod_round_value) {
		PROD_ROUND_VALUE = prod_round_value;
	}

	public String getPROD_MAT_AMT_TYPE() {
		return PROD_MAT_AMT_TYPE;
	}

	public void setPROD_MAT_AMT_TYPE(String PROD_MAT_AMT_TYPE) {
		this.PROD_MAT_AMT_TYPE = PROD_MAT_AMT_TYPE;
	}

	public Double getPROD_MAT_RATE() {
		return PROD_MAT_RATE;
	}

	public void setPROD_MAT_RATE(Double PROD_MAT_RATE) {
		this.PROD_MAT_RATE = PROD_MAT_RATE;
	}

	public Integer getPROD_MAT_RATE_PER() {
		return PROD_MAT_RATE_PER;
	}

	public void setPROD_MAT_RATE_PER(Integer prod_mat_rate_per) {
		PROD_MAT_RATE_PER = prod_mat_rate_per;
	}

	public Double getPROD_FUND_FEE() {
		return PROD_FUND_FEE;
	}

	public void setPROD_FUND_FEE(Double PROD_FUND_FEE) {
		this.PROD_FUND_FEE = PROD_FUND_FEE;
	}

	public Double getPROD_FUND_FEE_RATE_PER() {
		return PROD_FUND_FEE_RATE_PER;
	}

	public void setPROD_FUND_FEE_RATE_PER(Double PROD_FUND_FEE_RATE_PER) {
		this.PROD_FUND_FEE_RATE_PER = PROD_FUND_FEE_RATE_PER;
	}

	public String getPROD_MRTA_RATE_CALC_YN() {
		return PROD_MRTA_RATE_CALC_YN;
	}

	public void setPROD_MRTA_RATE_CALC_YN(String PROD_MRTA_RATE_CALC_YN) {
		this.PROD_MRTA_RATE_CALC_YN = PROD_MRTA_RATE_CALC_YN;
	}

	public String getPROD_TOPUP_CHARGE_TYPE() {
		return PROD_TOPUP_CHARGE_TYPE;
	}

	public void setPROD_TOPUP_CHARGE_TYPE(String PROD_TOPUP_CHARGE_TYPE) {
		this.PROD_TOPUP_CHARGE_TYPE = PROD_TOPUP_CHARGE_TYPE;
	}

	public String getPROD_PREM_HOLIDAY_CODE() {
		return PROD_PREM_HOLIDAY_CODE;
	}

	public void setPROD_PREM_HOLIDAY_CODE(String PROD_PREM_HOLIDAY_CODE) {
		this.PROD_PREM_HOLIDAY_CODE = PROD_PREM_HOLIDAY_CODE;
	}

	public String getPROD_LOAD_CHARGE_YN() {
		return PROD_LOAD_CHARGE_YN;
	}

	public void setPROD_LOAD_CHARGE_YN(String PROD_LOAD_CHARGE_YN) {
		this.PROD_LOAD_CHARGE_YN = PROD_LOAD_CHARGE_YN;
	}

	public String getPROD_PRODUCT_TYPE() {
		return PROD_PRODUCT_TYPE;
	}

	public void setPROD_PRODUCT_TYPE(String PROD_PRODUCT_TYPE) {
		this.PROD_PRODUCT_TYPE = PROD_PRODUCT_TYPE;
	}

	public Double getPROD_GRP_THRESHOLD_PERC() {
		return PROD_GRP_THRESHOLD_PERC;
	}

	public void setPROD_GRP_THRESHOLD_PERC(Double PROD_GRP_THRESHOLD_PERC) {
		this.PROD_GRP_THRESHOLD_PERC = PROD_GRP_THRESHOLD_PERC;
	}

	public String getPROD_MODE_OF_CALC() {
		return PROD_MODE_OF_CALC;
	}

	public void setPROD_MODE_OF_CALC(String PROD_MODE_OF_CALC) {
		this.PROD_MODE_OF_CALC = PROD_MODE_OF_CALC;
	}

	public String getPROD_THR_BASIS() {
		return PROD_THR_BASIS;
	}

	public void setPROD_THR_BASIS(String PROD_THR_BASIS) {
		this.PROD_THR_BASIS = PROD_THR_BASIS;
	}

	public String getPROD_SURR_CALC_TYPE() {
		return PROD_SURR_CALC_TYPE;
	}

	public void setPROD_SURR_CALC_TYPE(String PROD_SURR_CALC_TYPE) {
		this.PROD_SURR_CALC_TYPE = PROD_SURR_CALC_TYPE;
	}

	public String getPROD_PRS_YN() {
		return PROD_PRS_YN;
	}

	public void setPROD_PRS_YN(String PROD_PRS_YN) {
		this.PROD_PRS_YN = PROD_PRS_YN;
	}

	public String getPROD_SURR_PLUS_FACTOR() {
		return PROD_SURR_PLUS_FACTOR;
	}

	public void setPROD_SURR_PLUS_FACTOR(String PROD_SURR_PLUS_FACTOR) {
		this.PROD_SURR_PLUS_FACTOR = PROD_SURR_PLUS_FACTOR;
	}

	public String getPROD_AGENT_HIRE_YN() {
		return PROD_AGENT_HIRE_YN;
	}

	public void setPROD_AGENT_HIRE_YN(String PROD_AGENT_HIRE_YN) {
		this.PROD_AGENT_HIRE_YN = PROD_AGENT_HIRE_YN;
	}

	public String getPROD_MATU_DT() {
		return PROD_MATU_DT;
	}

	public void setPROD_MATU_DT(String PROD_MATU_DT) {
		this.PROD_MATU_DT = PROD_MATU_DT;
	}

	public String getPROD_DEF_PERIOD_FLAG() {
		return PROD_DEF_PERIOD_FLAG;
	}

	public void setPROD_DEF_PERIOD_FLAG(String PROD_DEF_PERIOD_FLAG) {
		this.PROD_DEF_PERIOD_FLAG = PROD_DEF_PERIOD_FLAG;
	}

	public String getPROD_RSA_CALC_TYP() {
		return PROD_RSA_CALC_TYP;
	}

	public void setPROD_RSA_CALC_TYP(String PROD_RSA_CALC_TYP) {
		this.PROD_RSA_CALC_TYP = PROD_RSA_CALC_TYP;
	}

	public String getPROD_SURRENDER_FACTOR() {
		return PROD_SURRENDER_FACTOR;
	}

	public void setPROD_SURRENDER_FACTOR(String PROD_SURRENDER_FACTOR) {
		this.PROD_SURRENDER_FACTOR = PROD_SURRENDER_FACTOR;
	}

	public String getPROD_TOLL_LIMIT_YN() {
		return PROD_TOLL_LIMIT_YN;
	}

	public void setPROD_TOLL_LIMIT_YN(String PROD_TOLL_LIMIT_YN) {
		this.PROD_TOLL_LIMIT_YN = PROD_TOLL_LIMIT_YN;
	}

	public String getPROD_INTER_FUND_YN() {
		return PROD_INTER_FUND_YN;
	}

	public void setPROD_INTER_FUND_YN(String PROD_INTER_FUND_YN) {
		this.PROD_INTER_FUND_YN = PROD_INTER_FUND_YN;
	}

	public Double getPROD_WITHDRAW_AMT_MULTIPLE() {
		return PROD_WITHDRAW_AMT_MULTIPLE;
	}

	public void setPROD_WITHDRAW_AMT_MULTIPLE(Double PROD_WITHDRAW_AMT_MULTIPLE) {
		this.PROD_WITHDRAW_AMT_MULTIPLE = PROD_WITHDRAW_AMT_MULTIPLE;
	}

	public String getPROD_RI_RECOV_BASIS() {
		return PROD_RI_RECOV_BASIS;
	}

	public void setPROD_RI_RECOV_BASIS(String PROD_RI_RECOV_BASIS) {
		this.PROD_RI_RECOV_BASIS = PROD_RI_RECOV_BASIS;
	}

	public String getPROD_SERVICE_TAX_YN() {
		return PROD_SERVICE_TAX_YN;
	}

	public void setPROD_SERVICE_TAX_YN(String PROD_SERVICE_TAX_YN) {
		this.PROD_SERVICE_TAX_YN = PROD_SERVICE_TAX_YN;
	}

	public String getPROD_DRIP_MTHD() {
		return PROD_DRIP_MTHD;
	}

	public void setPROD_DRIP_MTHD(String PROD_DRIP_MTHD) {
		this.PROD_DRIP_MTHD = PROD_DRIP_MTHD;
	}

	public String getPROD_SA_BY_PLAN_BASIS_YN() {
		return PROD_SA_BY_PLAN_BASIS_YN;
	}

	public void setPROD_SA_BY_PLAN_BASIS_YN(String PROD_SA_BY_PLAN_BASIS_YN) {
		this.PROD_SA_BY_PLAN_BASIS_YN = PROD_SA_BY_PLAN_BASIS_YN;
	}

	public String getPROD_MASTER_CERT_YN() {
		return PROD_MASTER_CERT_YN;
	}

	public void setPROD_MASTER_CERT_YN(String PROD_MASTER_CERT_YN) {
		this.PROD_MASTER_CERT_YN = PROD_MASTER_CERT_YN;
	}

	public String getPROD_FUND_ALLOWED() {
		return PROD_FUND_ALLOWED;
	}

	public void setPROD_FUND_ALLOWED(String PROD_FUND_ALLOWED) {
		this.PROD_FUND_ALLOWED = PROD_FUND_ALLOWED;
	}

	public boolean isRecordStatus() {
		return RecordStatus;
	}

	public void setRecordStatus(boolean recordStatus) {
		RecordStatus = recordStatus;
	}

	public String getPROD_SURRENDER_FACTOR_DESC() {
		return PROD_SURRENDER_FACTOR_DESC;
	}

	public void setPROD_SURRENDER_FACTOR_DESC(String prod_surrender_factor_desc) {
		PROD_SURRENDER_FACTOR_DESC = prod_surrender_factor_desc;
	}

	public String getUI_M_PROD_PLAN_CODE_DESC() {
		return UI_M_PROD_PLAN_CODE_DESC;
	}

	public void setUI_M_PROD_PLAN_CODE_DESC(String ui_m_prod_plan_code_desc) {
		UI_M_PROD_PLAN_CODE_DESC = ui_m_prod_plan_code_desc;
	}

	public String getUI_M_PAP_SUB_PLAN_CODE() {
		return UI_M_PAP_SUB_PLAN_CODE;
	}

	public void setUI_M_PAP_SUB_PLAN_CODE(String ui_m_pap_sub_plan_code) {
		UI_M_PAP_SUB_PLAN_CODE = ui_m_pap_sub_plan_code;
	}

	public String getUI_M_PROD_TOPUP_COMM_DESCRIPTION() {
		return UI_M_PROD_TOPUP_COMM_DESCRIPTION;
	}

	public void setUI_M_PROD_TOPUP_COMM_DESCRIPTION(
			String ui_m_prod_topup_comm_description) {
		UI_M_PROD_TOPUP_COMM_DESCRIPTION = ui_m_prod_topup_comm_description;
	}

	public String getUI_M_PROD_PREM_HOLIDAY_CODE_DESC() {
		return UI_M_PROD_PREM_HOLIDAY_CODE_DESC;
	}

	public void setUI_M_PROD_PREM_HOLIDAY_CODE_DESC(
			String ui_m_prod_prem_holiday_code_desc) {
		UI_M_PROD_PREM_HOLIDAY_CODE_DESC = ui_m_prod_prem_holiday_code_desc;
	}

	public int getRecordIndex() {
		return RecordIndex;
	}

	public void setRecordIndex(int recordIndex) {
		RecordIndex = recordIndex;
	}

	public String getUI_M_PROD_DS_CODE_DESC() {
		return UI_M_PROD_DS_CODE_DESC;
	}

	public void setUI_M_PROD_DS_CODE_DESC(String ui_m_prod_ds_code_desc) {
		UI_M_PROD_DS_CODE_DESC = ui_m_prod_ds_code_desc;
	}

	public String getPROD_POL_VALID_AFTER_MAT_YN() {
		return PROD_POL_VALID_AFTER_MAT_YN;
	}

	public void setPROD_POL_VALID_AFTER_MAT_YN(String prod_pol_valid_after_mat_yn) {
		PROD_POL_VALID_AFTER_MAT_YN = prod_pol_valid_after_mat_yn;
	}

	public Integer getPROD_SURR_YRS() {
		return PROD_SURR_YRS;
	}

	public void setPROD_SURR_YRS(Integer prod_surr_yrs) {
		PROD_SURR_YRS = prod_surr_yrs;
	}

	public Integer getPROD_MIN_SA() {
		return PROD_MIN_SA;
	}

	public void setPROD_MIN_SA(Integer prod_min_sa) {
		PROD_MIN_SA = prod_min_sa;
	}

	public Integer getPROD_MAX_AGE_ON_MAT() {
		return PROD_MAX_AGE_ON_MAT;
	}

	public void setPROD_MAX_AGE_ON_MAT(Integer prod_max_age_on_mat) {
		PROD_MAX_AGE_ON_MAT = prod_max_age_on_mat;
	}

	public Integer getPROD_DEF_PERIOD_FM() {
		return PROD_DEF_PERIOD_FM;
	}

	public void setPROD_DEF_PERIOD_FM(Integer prod_def_period_fm) {
		PROD_DEF_PERIOD_FM = prod_def_period_fm;
	}

	public Integer getPROD_DEF_PERIOD_TO() {
		return PROD_DEF_PERIOD_TO;
	}

	public void setPROD_DEF_PERIOD_TO(Integer prod_def_period_to) {
		PROD_DEF_PERIOD_TO = prod_def_period_to;
	}

	public String getPROD_WAKFEE_FACTOR() {
		return PROD_WAKFEE_FACTOR;
	}

	public void setPROD_WAKFEE_FACTOR(String prod_wakfee_factor) {
		PROD_WAKFEE_FACTOR = prod_wakfee_factor;
	}

	public Integer getPROD_WAQAF_PERIOD_FM() {
		return PROD_WAQAF_PERIOD_FM;
	}

	public void setPROD_WAQAF_PERIOD_FM(Integer prod_waqaf_period_fm) {
		PROD_WAQAF_PERIOD_FM = prod_waqaf_period_fm;
	}
	
	public Integer getPROD_WAQAF_PERIOD_TO() {
		return PROD_WAQAF_PERIOD_TO;
	}

	public void setPROD_WAQAF_PERIOD_TO(Integer prod_waqaf_period_to) {
		PROD_WAQAF_PERIOD_TO = prod_waqaf_period_to;
	}

	public Double getPROD_AFTWD_LC_MINBAL() {
		return PROD_AFTWD_LC_MINBAL;
	}

	public void setPROD_AFTWD_LC_MINBAL(Double prod_aftwd_lc_minbal) {
		PROD_AFTWD_LC_MINBAL = prod_aftwd_lc_minbal;
	}

	public Double getPROD_TOPUP_MULTIPLE() {
		return PROD_TOPUP_MULTIPLE;
	}

	public void setPROD_TOPUP_MULTIPLE(Double prod_topup_multiple) {
		PROD_TOPUP_MULTIPLE = prod_topup_multiple;
	}

	public String getPROD_TOPUP_WAK_CODE() {
		return PROD_TOPUP_WAK_CODE;
	}

	public void setPROD_TOPUP_WAK_CODE(String prod_topup_wak_code) {
		PROD_TOPUP_WAK_CODE = prod_topup_wak_code;
	}

	public Double getPROD_MIN_SURR_AMT() {
		return PROD_MIN_SURR_AMT;
	}

	public void setPROD_MIN_SURR_AMT(Double prod_min_surr_amt) {
		PROD_MIN_SURR_AMT = prod_min_surr_amt;
	}

	public String getPROD_SA_ADD_FACTOR() {
		return PROD_SA_ADD_FACTOR;
	}

	public void setPROD_SA_ADD_FACTOR(String prod_sa_add_factor) {
		PROD_SA_ADD_FACTOR = prod_sa_add_factor;
	}

	public String getPROD_DRIP_LIMIT() {
		return PROD_DRIP_LIMIT;
	}

	public void setPROD_DRIP_LIMIT(String prod_drip_limit) {
		PROD_DRIP_LIMIT = prod_drip_limit;
	}

	public String getPROD_TOL_CHK_YN() {
		return PROD_TOL_CHK_YN;
	}

	public void setPROD_TOL_CHK_YN(String prod_tol_chk_yn) {
		PROD_TOL_CHK_YN = prod_tol_chk_yn;
	}

	public String getPROD_TRAN_RATE_YN() {
		return PROD_TRAN_RATE_YN;
	}

	public void setPROD_TRAN_RATE_YN(String prod_tran_rate_yn) {
		PROD_TRAN_RATE_YN = prod_tran_rate_yn;
	}

	/*public String getPROD_PREM_COMP_EVENT() {
		return PROD_PREM_COMP_EVENT;
	}

	public void setPROD_PREM_COMP_EVENT(String prod_prem_comp_event) {
		PROD_PREM_COMP_EVENT = prod_prem_comp_event;
	}*/

	/*public String getPROD_CLM_LOS_DT_YN() {
		return PROD_CLM_LOS_DT_YN;
	}

	public void setPROD_CLM_LOS_DT_YN(String prod_clm_los_dt_yn) {
		PROD_CLM_LOS_DT_YN = prod_clm_los_dt_yn;
	}*/

	/*public Double getPROD_MAX_COOLOFF_ENB_DAYS() {
		return PROD_MAX_COOLOFF_ENB_DAYS;
	}

	public void setPROD_MAX_COOLOFF_ENB_DAYS(Double prod_max_cooloff_enb_days) {
		PROD_MAX_COOLOFF_ENB_DAYS = prod_max_cooloff_enb_days;
	}*/

	public String getPROD_SA_ADD_FACTOR_DESC() {
		return PROD_SA_ADD_FACTOR_DESC;
	}

	public void setPROD_SA_ADD_FACTOR_DESC(String prod_sa_add_factor_desc) {
		PROD_SA_ADD_FACTOR_DESC = prod_sa_add_factor_desc;
	}

	/**
	 * @return the pROD_INS_AGE_FM
	 */
	public int getPROD_INS_AGE_FM() {
		return PROD_INS_AGE_FM;
	}

	/**
	 * @param prod_ins_age_fm the pROD_INS_AGE_FM to set
	 */
	public void setPROD_INS_AGE_FM(int prod_ins_age_fm) {
		PROD_INS_AGE_FM = prod_ins_age_fm;
	}

	/**
	 * @return the pROD_INS_AGE_TO
	 */
	public int getPROD_INS_AGE_TO() {
		return PROD_INS_AGE_TO;
	}

	/**
	 * @param prod_ins_age_to the pROD_INS_AGE_TO to set
	 */
	public void setPROD_INS_AGE_TO(int prod_ins_age_to) {
		PROD_INS_AGE_TO = prod_ins_age_to;
	}

	/**
	 * @return the pROD_INS_SA_FM
	 */
	public String getPROD_INS_SA_FM() {
		return PROD_INS_SA_FM;
	}

	/**
	 * @param prod_ins_sa_fm the pROD_INS_SA_FM to set
	 */
	public void setPROD_INS_SA_FM(String prod_ins_sa_fm) {
		PROD_INS_SA_FM = prod_ins_sa_fm;
	}

	/**
	 * @return the pROD_INS_SA_TO
	 */
	public String getPROD_INS_SA_TO() {
		return PROD_INS_SA_TO;
	}

	/**
	 * @param prod_ins_sa_to the pROD_INS_SA_TO to set
	 */
	public void setPROD_INS_SA_TO(String prod_ins_sa_to) {
		PROD_INS_SA_TO = prod_ins_sa_to;
	}

	/**
	 * @return the pROD_INS_TM_FM
	 */
	public String getPROD_INS_TM_FM() {
		return PROD_INS_TM_FM;
	}

	/**
	 * @param prod_ins_tm_fm the pROD_INS_TM_FM to set
	 */
	public void setPROD_INS_TM_FM(String prod_ins_tm_fm) {
		PROD_INS_TM_FM = prod_ins_tm_fm;
	}

	/**
	 * @return the pROD_INS_TM_TO
	 */
	public String getPROD_INS_TM_TO() {
		return PROD_INS_TM_TO;
	}

	/**
	 * @param prod_ins_tm_to the pROD_INS_TM_TO to set
	 */
	public void setPROD_INS_TM_TO(String prod_ins_tm_to) {
		PROD_INS_TM_TO = prod_ins_tm_to;
	}

	/**
	 * @return the aPL_YES_NO
	 */
	public String getAPL_YES_NO() {
		return APL_YES_NO;
	}

	/**
	 * @param apl_yes_no the aPL_YES_NO to set
	 */
	public void setAPL_YES_NO(String apl_yes_no) {
		APL_YES_NO = apl_yes_no;
	}

	/**
	 * @return the pROD_APL_YN
	 */
	public String getPROD_APL_YN() {
		return PROD_APL_YN;
	}

	/**
	 * @param prod_apl_yn the pROD_APL_YN to set
	 */
	public void setPROD_APL_YN(String prod_apl_yn) {
		PROD_APL_YN = prod_apl_yn;
	}

	/**
	 * @return the pROD_FLEX_01
	 */
	public String getPROD_FLEX_01() {
		return PROD_FLEX_01;
	}

	/**
	 * @param prod_flex_01 the pROD_FLEX_01 to set
	 */
	public void setPROD_FLEX_01(String prod_flex_01) {
		PROD_FLEX_01 = prod_flex_01;
	}

	public String getPROD_REM_YN() {
		return PROD_REM_YN;
	}

	public void setPROD_REM_YN(String prod_rem_yn) {
		PROD_REM_YN = prod_rem_yn;
	}

	public Integer getPROD_REM_1() {
		return PROD_REM_1;
	}

	public void setPROD_REM_1(Integer prod_rem_1) {
		PROD_REM_1 = prod_rem_1;
	}

	public Integer getPROD_REM_2() {
		return PROD_REM_2;
	}

	public void setPROD_REM_2(Integer prod_rem_2) {
		PROD_REM_2 = prod_rem_2;
	}

	public Integer getPROD_REM_3() {
		return PROD_REM_3;
	}

	public void setPROD_REM_3(Integer prod_rem_3) {
		PROD_REM_3 = prod_rem_3;
	}

	public Integer getPROD_SAL_MULTIPLE() {
		return PROD_SAL_MULTIPLE;
	}

	public void setPROD_SAL_MULTIPLE(Integer prod_sal_multiple) {
		PROD_SAL_MULTIPLE = prod_sal_multiple;
	}

	public Double getPROD_INC_WEIGHT() {
		return PROD_INC_WEIGHT;
	}

	public void setPROD_INC_WEIGHT(Double prod_inc_weight) {
		PROD_INC_WEIGHT = prod_inc_weight;
	}
   //added by saranya 
	@Column(name = "PROD_FORMULA_SURR")
	private String PROD_FORMULA_SURR;

	@Column(name = "PROD_PAIDUP_FORMULA")
	private String PROD_PAIDUP_FORMULA;
	
	private String UI_PROD_FORMULA_SURR_DESC;
	
	private String UI_PROD_PAIDUP_FORMULA_DESC;

	public String getPROD_FORMULA_SURR() {
		return PROD_FORMULA_SURR;
	}

	public void setPROD_FORMULA_SURR(String pROD_FORMULA_SURR) {
		PROD_FORMULA_SURR = pROD_FORMULA_SURR;
	}
	
	public String getPROD_PAIDUP_FORMULA() {
		return PROD_PAIDUP_FORMULA;
	}

	public void setPROD_PAIDUP_FORMULA(String pROD_PAIDUP_FORMULA) {
		PROD_PAIDUP_FORMULA = pROD_PAIDUP_FORMULA;
	}
	
	public String getUI_PROD_FORMULA_SURR_DESC() {
		return UI_PROD_FORMULA_SURR_DESC;
	}

	public void setUI_PROD_FORMULA_SURR_DESC(String uI_PROD_FORMULA_SURR_DESC) {
		UI_PROD_FORMULA_SURR_DESC = uI_PROD_FORMULA_SURR_DESC;
	}
	
	public String getUI_PROD_PAIDUP_FORMULA_DESC() {
		return UI_PROD_PAIDUP_FORMULA_DESC;
	}

	public void setUI_PROD_PAIDUP_FORMULA_DESC(String uI_PROD_PAIDUP_FORMULA_DESC) {
		UI_PROD_PAIDUP_FORMULA_DESC = uI_PROD_PAIDUP_FORMULA_DESC;
	}
	
	//end
	
	/*Added by saranya on 30/12/2016 for RM018T - FSD_IL_ZB Life_028-Cash Back*/
	@Column(name = "PROD_CASHBACK_YN")
	private String PROD_CASHBACK_YN;

	public String getPROD_CASHBACK_YN() {
		return PROD_CASHBACK_YN;
	}

	public void setPROD_CASHBACK_YN(String pROD_CASHBACK_YN) {
		PROD_CASHBACK_YN = pROD_CASHBACK_YN;
	}


	/*End*/
	/*Added by saranya on 13/02/2017 for Unit Link Product as per the Girish Suggessted*/
	@Column(name = "PROD_RISK_FACTOR_YN")
	private String PROD_RISK_FACTOR_YN;

	public String getPROD_RISK_FACTOR_YN() {
		return PROD_RISK_FACTOR_YN;
	}

	public void setPROD_RISK_FACTOR_YN(String pROD_RISK_FACTOR_YN) {
		PROD_RISK_FACTOR_YN = pROD_RISK_FACTOR_YN;
	}

	/*End*/
	
	/*Added saranya for RM018T - FSD_IL_ZB Life_001-Education Endowment Plan COMMENTS on 13-03-2017*/
	
	@Column(name = "PROD_UNIT_LINK_TYPE")
	private String PROD_UNIT_LINK_TYPE;


	public String getPROD_UNIT_LINK_TYPE() {
		return PROD_UNIT_LINK_TYPE;
	}

	public void setPROD_UNIT_LINK_TYPE(String pROD_UNIT_LINK_TYPE) {
		PROD_UNIT_LINK_TYPE = pROD_UNIT_LINK_TYPE;
	}
	
	/*End*/
	/*Added  by saranya for Hands on point num 23 on 14/02/2017
	@Column(name = "PROD_CLM_PROC_FEE")
	private Double PROD_CLM_PROC_FEE;

	public Double getPROD_CLM_PROC_FEE() {
		return PROD_CLM_PROC_FEE;
	}

	public void setPROD_CLM_PROC_FEE(Double pROD_CLM_PROC_FEE) {
		PROD_CLM_PROC_FEE = pROD_CLM_PROC_FEE;
	}
	End*/

	/*Added sankaranarayanan for hospitalcashplan  on 21-04-2017*/
	@Column(name = "PROD_INTR_SAVINGS_YN")
	private String PROD_INTR_SAVINGS_YN;


	public String getPROD_INTR_SAVINGS_YN() {
		return PROD_INTR_SAVINGS_YN;
	}

	public void setPROD_INTR_SAVINGS_YN(String pROD_INTR_SAVINGS_YN) {
		PROD_INTR_SAVINGS_YN = pROD_INTR_SAVINGS_YN;
	}
	
	
	
	/*end*/
	
	/*added by Ameen on 31-10-2017 to add PROD_RI_SA_CALC_TYP as per Chandramohan sugg.*/
	@Column(name="PROD_RI_SA_CALC_TYP")
	private String PROD_RI_SA_CALC_TYP;
	
	private String UI_M_PROD_RI_SA_CALC_TYP_DESC;

	public String getPROD_RI_SA_CALC_TYP() {
		return PROD_RI_SA_CALC_TYP;
	}

	public void setPROD_RI_SA_CALC_TYP(String pROD_RI_SA_CALC_TYP) {
		PROD_RI_SA_CALC_TYP = pROD_RI_SA_CALC_TYP;
	}

	public String getUI_M_PROD_RI_SA_CALC_TYP_DESC() {
		return UI_M_PROD_RI_SA_CALC_TYP_DESC;
	}

	public void setUI_M_PROD_RI_SA_CALC_TYP_DESC(
			String uI_M_PROD_RI_SA_CALC_TYP_DESC) {
		UI_M_PROD_RI_SA_CALC_TYP_DESC = uI_M_PROD_RI_SA_CALC_TYP_DESC;
	}
	/*end*/
	
	
	
	/*Added by Janani on 04.01.2018 for ZBLIFE-1459615*/
	
	@Column(name="PROD_PUP_YN")
	private String PROD_PUP_YN;
	

	@Column(name="PROD_MIN_PUP_AMT")
	private Double PROD_MIN_PUP_AMT;

	@Column(name="PROD_DRIP_AMT")
	private Double PROD_DRIP_AMT;
	

	public String getPROD_PUP_YN() {
		return PROD_PUP_YN;
	}
	
	public Double getPROD_MIN_PUP_AMT() {
		return PROD_MIN_PUP_AMT;
	}

	public void setPROD_MIN_PUP_AMT(Double pROD_MIN_PUP_AMT) {
		PROD_MIN_PUP_AMT = pROD_MIN_PUP_AMT;
	}

	public void setPROD_PUP_YN(String pROD_PUP_YN) {
		PROD_PUP_YN = pROD_PUP_YN;
	}

	public Double getPROD_DRIP_AMT() {
		return PROD_DRIP_AMT;
	}

	public void setPROD_DRIP_AMT(Double pROD_DRIP_AMT) {
		PROD_DRIP_AMT = pROD_DRIP_AMT;
	}
	
	
	
	/*End*/
	
	/*added BY Ameen on 15-02-2018 for KIC*/
	@Column(name="PROD_MAT_RET_PREM_YN")
	private String PROD_RET_PREM_YN;

	public String getPROD_RET_PREM_YN() {
		return PROD_RET_PREM_YN;
	}

	public void setPROD_RET_PREM_YN(String pROD_RET_PREM_YN) {
		PROD_RET_PREM_YN = pROD_RET_PREM_YN;
	}
	
	/*End*/
	
	/*added BY Ameen on 15-02-2018 for KIC*/
	@Column(name="PROD_REG_EXCESS_APP_YN")
	private String PROD_REG_EXCESS_APP_YN;
	
	@Column(name="PROD_MAT_AMT_LEVEL")
	private String PROD_MAT_AMT_LEVEL;

	public String getPROD_REG_EXCESS_APP_YN() {
		return PROD_REG_EXCESS_APP_YN;
	}

	public void setPROD_REG_EXCESS_APP_YN(String pROD_REG_EXCESS_APP_YN) {
		PROD_REG_EXCESS_APP_YN = pROD_REG_EXCESS_APP_YN;
	}
	
	public String getPROD_MAT_AMT_LEVEL() {
		return PROD_MAT_AMT_LEVEL;
	}

	public void setPROD_MAT_AMT_LEVEL(String pROD_MAT_AMT_LEVEL) {
		PROD_MAT_AMT_LEVEL = pROD_MAT_AMT_LEVEL;
	}
	/*End*/	
	
	/*added by Ameen on 25-03-2018 for KIC part payment*/
	@Column(name="PROD_CBC_LIMIT")
	private Integer PROD_CBC_LIMIT;


	public Integer getPROD_CBC_LIMIT() {
		return PROD_CBC_LIMIT;
	}

	public void setPROD_CBC_LIMIT(Integer pROD_CBC_LIMIT) {
		PROD_CBC_LIMIT = pROD_CBC_LIMIT;
	}
	
	/*End*/	
	
	/*Added by Janani on 18.04.2018 for Fidelity period calc*/
	@Column(name="PROD_CALC_TERM_YN")
	private String PROD_CALC_TERM_YN;

	public String getPROD_CALC_TERM_YN() {
		return PROD_CALC_TERM_YN;
	}

	public void setPROD_CALC_TERM_YN(String pROD_CALC_TERM_YN) {
		PROD_CALC_TERM_YN = pROD_CALC_TERM_YN;
	}
	
	
	/*End*/	
	
	/*Added by Janani on 12.05.2018 for Fidelity as suggested by Sivaram for Funeral,hospital cash rider*/
	@Column(name="PROD_RIDER_APPL_YN")
	private String PROD_RIDER_APPL_YN;


	public String getPROD_RIDER_APPL_YN() {
		return PROD_RIDER_APPL_YN;
	}

	public void setPROD_RIDER_APPL_YN(String pROD_RIDER_APPL_YN) {
		PROD_RIDER_APPL_YN = pROD_RIDER_APPL_YN;
	}
	
	
	/*End*/	
	//added by gopi for toi on 25/05/18
	@Column(name="PROD_BENF_AS_CUST_YN")
	private String PROD_BENF_AS_CUST_YN;


	public String getPROD_BENF_AS_CUST_YN() {
		return PROD_BENF_AS_CUST_YN;
	}

	public void setPROD_BENF_AS_CUST_YN(String pROD_BENF_AS_CUST_YN) {
		PROD_BENF_AS_CUST_YN = pROD_BENF_AS_CUST_YN;
	}
	
	
	@Column(name="PROD_POL_APPROVAL_YN")
	private String PROD_POL_APPROVAL_YN;


	public String getPROD_POL_APPROVAL_YN() {
		return PROD_POL_APPROVAL_YN;
	}

	public void setPROD_POL_APPROVAL_YN(String pROD_POL_APPROVAL_YN) {
		PROD_POL_APPROVAL_YN = pROD_POL_APPROVAL_YN;
	}
	
	
	//end
	
	/*Added by Janani on 15.06.2018 for KIC*/
	
	@Column(name="PROD_NGTV_SUS_YN")
	private String PROD_NGTV_SUS_YN;


	public String getPROD_NGTV_SUS_YN() {
		return PROD_NGTV_SUS_YN;
	}

	public void setPROD_NGTV_SUS_YN(String pROD_NGTV_SUS_YN) {
		PROD_NGTV_SUS_YN = pROD_NGTV_SUS_YN;
	}
	
	/*End*/
	
	/*Added by Janani on 25.06.2018 for  FSD_IL_FLA_006_Monetary Endorsement Module*/
	
	@Column(name="PROD_AGENT_PREM_TYPE")
	private String PROD_AGENT_PREM_TYPE;


	public String getPROD_AGENT_PREM_TYPE() {
		return PROD_AGENT_PREM_TYPE;
	}

	public void setPROD_AGENT_PREM_TYPE(String pROD_AGENT_PREM_TYPE) {
		PROD_AGENT_PREM_TYPE = pROD_AGENT_PREM_TYPE;
	}
	
	/*End*/
	
	/*Added by Janani on 05.07.2018 for FLALIFEQC-1512859 */
	
	@Column(name="PROD_PREM_PAYING_YRS")
	private String PROD_PREM_PAYING_YRS;


	public String getPROD_PREM_PAYING_YRS() {
		return PROD_PREM_PAYING_YRS;
	}

	public void setPROD_PREM_PAYING_YRS(String pROD_PREM_PAYING_YRS) {
		PROD_PREM_PAYING_YRS = pROD_PREM_PAYING_YRS;
	}
	
	
	
	
	/*End*/
	
	/*Added by kavitha on 08.01.2019 as per siva sir sugg */
	@Column(name = "PROD_FORMULA_MAT")
	private String PROD_FORMULA_MAT;

	
	private String UI_PROD_FORMULA_MAT_DESC;


	public String getPROD_FORMULA_MAT() {
		return PROD_FORMULA_MAT;
	}

	public void setPROD_FORMULA_MAT(String pROD_FORMULA_MAT) {
		PROD_FORMULA_MAT = pROD_FORMULA_MAT;
	}

	public String getUI_PROD_FORMULA_MAT_DESC() {
		return UI_PROD_FORMULA_MAT_DESC;
	}

	public void setUI_PROD_FORMULA_MAT_DESC(String uI_PROD_FORMULA_MAT_DESC) {
		UI_PROD_FORMULA_MAT_DESC = uI_PROD_FORMULA_MAT_DESC;
	}
	
	
	
	
	/*End*/
	
	/*Newly added by pidugu raj dt: 09-07-2020 as suggested by kk and sitrasan for Alliance IL*/
	
	@Column(name = "PROD_SUB_DT_YN")
	private String PROD_SUB_DT_YN;


	public String getPROD_SUB_DT_YN() {
		return PROD_SUB_DT_YN;
	}

	public void setPROD_SUB_DT_YN(String pROD_SUB_DT_YN) {
		PROD_SUB_DT_YN = pROD_SUB_DT_YN;
	}
	
	/*End Newly added by pidugu raj dt: 09-07-2020 as suggested by kk and sitrasan for Alliance IL*/
	/*Newly added by pidugu raj dt: 16-09-2020 as suggested by kk and sitrasan for Alliance IL*/
	@Column(name = "PROD_DEFAULT_CURR_CODE")
	private String PROD_DEFAULT_CURR_CODE;
	
	public String getPROD_DEFAULT_CURR_CODE() {
		return PROD_DEFAULT_CURR_CODE;
	}

	public void setPROD_DEFAULT_CURR_CODE(String pROD_DEFAULT_CURR_CODE) {
		PROD_DEFAULT_CURR_CODE = pROD_DEFAULT_CURR_CODE;
	}
	private String UI_M_PROD_DEFAULT_CURR_CODE_DESC;
	public String getUI_M_PROD_DEFAULT_CURR_CODE_DESC() {
		return UI_M_PROD_DEFAULT_CURR_CODE_DESC;
	}

	public void setUI_M_PROD_DEFAULT_CURR_CODE_DESC(
			String uI_M_PROD_DEFAULT_CURR_CODE_DESC) {
		UI_M_PROD_DEFAULT_CURR_CODE_DESC = uI_M_PROD_DEFAULT_CURR_CODE_DESC;
	}
	/*End Newly added by pidugu raj dt: 16-09-2020 as suggested by kk and sitrasan for Alliance IL*/
	
	/*Added by senthilnathan for Alliance_IL ON 05.02.2021 as suggested by sivaram and abhilash*/
	@Column(name = "PROD_RI_FORMULA_CODE")
	private String PROD_RI_FORMULA_CODE;
	
	private String UI_M_PROD_RI_FORMULA_CODE_DESC;


	public String getPROD_RI_FORMULA_CODE() {
		return PROD_RI_FORMULA_CODE;
	}

	public void setPROD_RI_FORMULA_CODE(String pROD_RI_FORMULA_CODE) {
		PROD_RI_FORMULA_CODE = pROD_RI_FORMULA_CODE;
	}

	public String getUI_M_PROD_RI_FORMULA_CODE_DESC() {
		return UI_M_PROD_RI_FORMULA_CODE_DESC;
	}

	public void setUI_M_PROD_RI_FORMULA_CODE_DESC(
			String uI_M_PROD_RI_FORMULA_CODE_DESC) {
		UI_M_PROD_RI_FORMULA_CODE_DESC = uI_M_PROD_RI_FORMULA_CODE_DESC;
	}
	
	
	
	
	
	
	/*end*/
	
}
