package com.iii.pel.forms.PILM003_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="PM_IL_PLAN")
public class PM_IL_PLAN extends BaseValueBean {

	@Column(name="PLAN_CODE")
	private String PLAN_CODE;

	@Column(name="PLAN_TYPE")
	private String PLAN_TYPE;

	@Column(name="PLAN_PERIOD_FROM")
	private Integer PLAN_PERIOD_FROM;

	@Column(name="PLAN_PERIOD_TO")
	private Integer PLAN_PERIOD_TO;

	@Column(name="PLAN_AGE_FROM")
	private Integer PLAN_AGE_FROM;

	@Column(name="PLAN_AGE_TO")
	private Integer PLAN_AGE_TO;

	@Column(name="PLAN_LOAN_YN")
	private String PLAN_LOAN_YN;

	@Column(name="PLAN_FACIN_YN")
	private String PLAN_FACIN_YN;

	@Column(name="PLAN_PYMT_ON_MAT_YN")
	private String PLAN_PYMT_ON_MAT_YN;

	@Column(name="PLAN_SA_INST_PYMT_YN")
	private String PLAN_SA_INST_PYMT_YN;

	@Column(name="PLAN_REBATE_YN")
	private String PLAN_REBATE_YN;

	@Column(name="PLAN_SURR_YN")
	private String PLAN_SURR_YN;

	@Column(name="PLAN_SURR_YRS")
	private Integer PLAN_SURR_YRS;

	@Column(name="PLAN_RED_SA_BASIS")
	private String PLAN_RED_SA_BASIS;

	@Column(name="PLAN_FRZ_FLAG")
	private String PLAN_FRZ_FLAG;
	
	private boolean UI_PLAN_FRZ_FLAG;

	@Column(name="PLAN_CR_DT")
	private Date PLAN_CR_DT;

	@Column(name="PLAN_CR_UID")
	private String PLAN_CR_UID;

	@Column(name="PLAN_UPD_DT")
	private Date PLAN_UPD_DT;

	@Column(name="PLAN_UPD_UID")
	private String PLAN_UPD_UID;

	@Column(name="PLAN_CREDIT_YN")
	private String PLAN_CREDIT_YN;

	@Column(name="PLAN_MAX_AGE_ON_MAT")
	private Integer PLAN_MAX_AGE_ON_MAT;

	@Column(name="PLAN_MIN_SA")
	private Double PLAN_MIN_SA;

	@Column(name="PLAN_MAX_SA")
	private Double PLAN_MAX_SA;

	@Column(name="PLAN_REVIVAL_YN")
	private String PLAN_REVIVAL_YN;

	@Column(name="PLAN_REVIVAL_YRS")
	private Integer PLAN_REVIVAL_YRS;

	@Column(name="PLAN_SPL_REVIVAL_YN")
	private String PLAN_SPL_REVIVAL_YN;

	@Column(name="PLAN_SPL_REVIVAL_YRS")
	private Integer PLAN_SPL_REVIVAL_YRS;

	@Column(name="PLAN_POL_VALID_AFTER_MAT_YN")
	private String PLAN_POL_VALID_AFTER_MAT_YN;

	@Column(name="PLAN_AGE_TERM_FLAG")
	private String PLAN_AGE_TERM_FLAG;

	@Column(name="PLAN_MIN_AGE_ON_MAT")
	private Integer PLAN_MIN_AGE_ON_MAT;

	@Column(name="PLAN_CALC_TYPE")
	private String PLAN_CALC_TYPE;

	private String UI_M_PLAN_DESC;
	private String UI_M_PLAN_TYPE_DESC;
	public void setPLAN_REVIVAL_YRS(Integer PLAN_REVIVAL_YRS) {
		this.PLAN_REVIVAL_YRS = PLAN_REVIVAL_YRS;
	}
	public Integer getPLAN_REVIVAL_YRS() {
		 return PLAN_REVIVAL_YRS;
	}
	public void setPLAN_SPL_REVIVAL_YRS(Integer PLAN_SPL_REVIVAL_YRS) {
		this.PLAN_SPL_REVIVAL_YRS = PLAN_SPL_REVIVAL_YRS;
	}
	public Integer getPLAN_SPL_REVIVAL_YRS() {
		 return PLAN_SPL_REVIVAL_YRS;
	}
	public void setPLAN_CR_DT(Date PLAN_CR_DT) {
		this.PLAN_CR_DT = PLAN_CR_DT;
	}
	public Date getPLAN_CR_DT() {
		 return PLAN_CR_DT;
	}
	public void setPLAN_UPD_UID(String PLAN_UPD_UID) {
		this.PLAN_UPD_UID = PLAN_UPD_UID;
	}
	public String getPLAN_UPD_UID() {
		 return PLAN_UPD_UID;
	}
	public void setPLAN_POL_VALID_AFTER_MAT_YN(String PLAN_POL_VALID_AFTER_MAT_YN) {
		this.PLAN_POL_VALID_AFTER_MAT_YN = PLAN_POL_VALID_AFTER_MAT_YN;
	}
	public String getPLAN_POL_VALID_AFTER_MAT_YN() {
		 return PLAN_POL_VALID_AFTER_MAT_YN;
	}
	public void setPLAN_SA_INST_PYMT_YN(String PLAN_SA_INST_PYMT_YN) {
		this.PLAN_SA_INST_PYMT_YN = PLAN_SA_INST_PYMT_YN;
	}
	public String getPLAN_SA_INST_PYMT_YN() {
		 return PLAN_SA_INST_PYMT_YN;
	}
	public void setPLAN_UPD_DT(Date PLAN_UPD_DT) {
		this.PLAN_UPD_DT = PLAN_UPD_DT;
	}
	public Date getPLAN_UPD_DT() {
		 return PLAN_UPD_DT;
	}
	public void setPLAN_PERIOD_FROM(Integer PLAN_PERIOD_FROM) {
		this.PLAN_PERIOD_FROM = PLAN_PERIOD_FROM;
	}
	public Integer getPLAN_PERIOD_FROM() {
		 return PLAN_PERIOD_FROM;
	}
	public void setPLAN_TYPE(String PLAN_TYPE) {
		this.PLAN_TYPE = PLAN_TYPE;
	}
	public String getPLAN_TYPE() {
		 return PLAN_TYPE;
	}
	public void setPLAN_MIN_AGE_ON_MAT(Integer PLAN_MIN_AGE_ON_MAT) {
		this.PLAN_MIN_AGE_ON_MAT = PLAN_MIN_AGE_ON_MAT;
	}
	public Integer getPLAN_MIN_AGE_ON_MAT() {
		 return PLAN_MIN_AGE_ON_MAT;
	}
	public void setPLAN_AGE_TERM_FLAG(String PLAN_AGE_TERM_FLAG) {
		this.PLAN_AGE_TERM_FLAG = PLAN_AGE_TERM_FLAG;
	}
	public String getPLAN_AGE_TERM_FLAG() {
		 return PLAN_AGE_TERM_FLAG;
	}
	public void setPLAN_RED_SA_BASIS(String PLAN_RED_SA_BASIS) {
		this.PLAN_RED_SA_BASIS = PLAN_RED_SA_BASIS;
	}
	public String getPLAN_RED_SA_BASIS() {
		 return PLAN_RED_SA_BASIS;
	}
	public void setPLAN_AGE_TO(Integer PLAN_AGE_TO) {
		this.PLAN_AGE_TO = PLAN_AGE_TO;
	}
	public Integer getPLAN_AGE_TO() {
		 return PLAN_AGE_TO;
	}
	public void setUI_M_PLAN_TYPE_DESC(String UI_M_PLAN_TYPE_DESC) {
		this.UI_M_PLAN_TYPE_DESC = UI_M_PLAN_TYPE_DESC;
	}
	public String getUI_M_PLAN_TYPE_DESC() {
		 return UI_M_PLAN_TYPE_DESC;
	}
	public void setPLAN_CR_UID(String PLAN_CR_UID) {
		this.PLAN_CR_UID = PLAN_CR_UID;
	}
	public String getPLAN_CR_UID() {
		 return PLAN_CR_UID;
	}
	public void setPLAN_MAX_SA(Double PLAN_MAX_SA) {
		this.PLAN_MAX_SA = PLAN_MAX_SA;
	}
	public Double getPLAN_MAX_SA() {
		 return PLAN_MAX_SA;
	}
	public void setPLAN_PYMT_ON_MAT_YN(String PLAN_PYMT_ON_MAT_YN) {
		this.PLAN_PYMT_ON_MAT_YN = PLAN_PYMT_ON_MAT_YN;
	}
	public String getPLAN_PYMT_ON_MAT_YN() {
		 return PLAN_PYMT_ON_MAT_YN;
	}
	public void setPLAN_LOAN_YN(String PLAN_LOAN_YN) {
		this.PLAN_LOAN_YN = PLAN_LOAN_YN;
	}
	public String getPLAN_LOAN_YN() {
		 return PLAN_LOAN_YN;
	}
	public void setPLAN_AGE_FROM(Integer PLAN_AGE_FROM) {
		this.PLAN_AGE_FROM = PLAN_AGE_FROM;
	}
	public Integer getPLAN_AGE_FROM() {
		 return PLAN_AGE_FROM;
	}
	public void setPLAN_CALC_TYPE(String PLAN_CALC_TYPE) {
		this.PLAN_CALC_TYPE = PLAN_CALC_TYPE;
	}
	public String getPLAN_CALC_TYPE() {
		 return PLAN_CALC_TYPE;
	}
	public void setPLAN_FRZ_FLAG(String PLAN_FRZ_FLAG) {
		UI_PLAN_FRZ_FLAG = CommonUtils.stringToBooleanConvertor(PLAN_FRZ_FLAG);
		this.PLAN_FRZ_FLAG = PLAN_FRZ_FLAG;
	}
	public String getPLAN_FRZ_FLAG() {
		 return PLAN_FRZ_FLAG;
	}
	public void setPLAN_FACIN_YN(String PLAN_FACIN_YN) {
		this.PLAN_FACIN_YN = PLAN_FACIN_YN;
	}
	public String getPLAN_FACIN_YN() {
		 return PLAN_FACIN_YN;
	}
	public void setPLAN_MIN_SA(Double PLAN_MIN_SA) {
		this.PLAN_MIN_SA = PLAN_MIN_SA;
	}
	public Double getPLAN_MIN_SA() {
		 return PLAN_MIN_SA;
	}
	public void setUI_M_PLAN_DESC(String UI_M_PLAN_DESC) {
		this.UI_M_PLAN_DESC = UI_M_PLAN_DESC;
	}
	public String getUI_M_PLAN_DESC() {
		 return UI_M_PLAN_DESC;
	}
	public void setPLAN_CODE(String PLAN_CODE) {
		this.PLAN_CODE = PLAN_CODE;
	}
	public String getPLAN_CODE() {
		 return PLAN_CODE;
	}
	public void setPLAN_MAX_AGE_ON_MAT(Integer PLAN_MAX_AGE_ON_MAT) {
		this.PLAN_MAX_AGE_ON_MAT = PLAN_MAX_AGE_ON_MAT;
	}
	public Integer getPLAN_MAX_AGE_ON_MAT() {
		 return PLAN_MAX_AGE_ON_MAT;
	}
	public void setPLAN_SPL_REVIVAL_YN(String PLAN_SPL_REVIVAL_YN) {
		this.PLAN_SPL_REVIVAL_YN = PLAN_SPL_REVIVAL_YN;
	}
	public String getPLAN_SPL_REVIVAL_YN() {
		 return PLAN_SPL_REVIVAL_YN;
	}
	public void setPLAN_CREDIT_YN(String PLAN_CREDIT_YN) {
		this.PLAN_CREDIT_YN = PLAN_CREDIT_YN;
	}
	public String getPLAN_CREDIT_YN() {
		 return PLAN_CREDIT_YN;
	}
	public void setPLAN_SURR_YRS(Integer PLAN_SURR_YRS) {
		this.PLAN_SURR_YRS = PLAN_SURR_YRS;
	}
	public Integer getPLAN_SURR_YRS() {
		 return PLAN_SURR_YRS;
	}
	public void setPLAN_PERIOD_TO(Integer PLAN_PERIOD_TO) {
		this.PLAN_PERIOD_TO = PLAN_PERIOD_TO;
	}
	public Integer getPLAN_PERIOD_TO() {
		 return PLAN_PERIOD_TO;
	}
	public void setPLAN_SURR_YN(String PLAN_SURR_YN) {
		this.PLAN_SURR_YN = PLAN_SURR_YN;
	}
	public String getPLAN_SURR_YN() {
		 return PLAN_SURR_YN;
	}
	public void setPLAN_REBATE_YN(String PLAN_REBATE_YN) {
		this.PLAN_REBATE_YN = PLAN_REBATE_YN;
	}
	public String getPLAN_REBATE_YN() {
		 return PLAN_REBATE_YN;
	}
	public void setPLAN_REVIVAL_YN(String PLAN_REVIVAL_YN) {
		this.PLAN_REVIVAL_YN = PLAN_REVIVAL_YN;
	}
	public String getPLAN_REVIVAL_YN() {
		 return PLAN_REVIVAL_YN;
	}
	public boolean isUI_PLAN_FRZ_FLAG() {
		return UI_PLAN_FRZ_FLAG;
	}
	public void setUI_PLAN_FRZ_FLAG(boolean ui_plan_frz_flag) {
		PLAN_FRZ_FLAG = CommonUtils.booleanToStriingConvertor(ui_plan_frz_flag);
		UI_PLAN_FRZ_FLAG = ui_plan_frz_flag;
	}
	//committed by Dhinesh for SSP call id FALCONQC-1714734 
	
	@Column(name="PLAN_LOAN_PER")
	
	private Integer PLAN_LOAN_PER;
	
	public Integer getPLAN_LOAN_PER() {
		return PLAN_LOAN_PER;
	}
	public void setPLAN_LOAN_PER(Integer pLAN_LOAN_PER) {
		PLAN_LOAN_PER = pLAN_LOAN_PER;
	}
	
	
	//end FALCONQC-1714734
	
	/*Added by saritha on 07-Jan-2017 for RM018T - DEV_IL_ZB Life_012b_Claim waiting period*/ 
	
	@Column(name="PLAN_CONT_PERIOD")
	private Integer PLAN_CONT_PERIOD;
	public Integer getPLAN_CONT_PERIOD() {
		return PLAN_CONT_PERIOD;
	}
	public void setPLAN_CONT_PERIOD(Integer pLAN_CONT_PERIOD) {
		PLAN_CONT_PERIOD = pLAN_CONT_PERIOD;
	}
	
	/*End*/
	
	
	/*added by raja 18-04-2017*/
	@Column(name="PLAN_MAX_DEP_COUNT")
	private Integer PLAN_MAX_DEP_COUNT;
	
	public Integer getPLAN_MAX_DEP_COUNT() {
		return PLAN_MAX_DEP_COUNT;
	}
	public void setPLAN_MAX_DEP_COUNT(Integer pLAN_MAX_DEP_COUNT) {
		PLAN_MAX_DEP_COUNT = pLAN_MAX_DEP_COUNT;
	}
/*	end*/
	
	
	/*added by raja 18-04-2017 for ZBILQC-1730358*/
	@Column(name="PLAN_PROP_AGE_FM")
	private Integer PLAN_PROP_AGE_FM;
	
	
	@Column(name="PLAN_PROP_AGE_TO")
	private Integer PLAN_PROP_AGE_TO;
	public Integer getPLAN_PROP_AGE_FM() {
		return PLAN_PROP_AGE_FM;
	}
	public void setPLAN_PROP_AGE_FM(Integer pLAN_PROP_AGE_FM) {
		PLAN_PROP_AGE_FM = pLAN_PROP_AGE_FM;
	}
	public Integer getPLAN_PROP_AGE_TO() {
		return PLAN_PROP_AGE_TO;
	}
	public void setPLAN_PROP_AGE_TO(Integer pLAN_PROP_AGE_TO) {
		PLAN_PROP_AGE_TO = pLAN_PROP_AGE_TO;
	}
	
	/*end*/
}
