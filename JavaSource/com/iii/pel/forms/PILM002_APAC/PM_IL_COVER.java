package com.iii.pel.forms.PILM002_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_COVER")
public class PM_IL_COVER extends BaseValueBean {

	@Column(name="COVER_CODE")
	private String COVER_CODE;

	@Column(name="COVER_LONG_DESC")
	private String COVER_LONG_DESC;

	@Column(name="COVER_DESC")
	private String COVER_DESC;

	@Column(name="COVER_BL_LONG_DESC")
	private String COVER_BL_LONG_DESC;

	@Column(name="COVER_BL_DESC")
	private String COVER_BL_DESC;

	@Column(name="COVER_TYPE")
	private String COVER_TYPE;

	@Column(name="COVER_FRZ_FLAG")
	private String COVER_FRZ_FLAG = "N";

	@Column(name="COVER_CR_DT")
	private Date COVER_CR_DT;

	@Column(name="COVER_CR_UID")
	private String COVER_CR_UID;

	@Column(name="COVER_UPD_DT")
	private Date COVER_UPD_DT;

	@Column(name="COVER_UPD_UID")
	private String COVER_UPD_UID;

	@Column(name="COVER_APP_ON_BASIC_RATE")
	private String COVER_APP_ON_BASIC_RATE;

	@Column(name="COVER_EFF_FM_DT")
	private Date COVER_EFF_FM_DT;

	@Column(name="COVER_EFF_TO_DT")
	private Date COVER_EFF_TO_DT;

	@Column(name="COVER_MIN_SA")
	private Double COVER_MIN_SA;

	@Column(name="COVER_MAX_SA")
	private Double COVER_MAX_SA;

	@Column(name="COVER_DISC_AGE_YN")
	private String COVER_DISC_AGE_YN;

	@Column(name="COVER_RATE_APPLIED_ON")
	private String COVER_RATE_APPLIED_ON;

	@Column(name="COVER_SA_PERC")
	private Double COVER_SA_PERC;

	@Column(name="COVER_FUND_TYPE")
	private String COVER_FUND_TYPE;

	@Column(name="COVER_FUND_MTHD")
	private String COVER_FUND_MTHD;

	@Column(name="COVER_FUND_RISK")
	private String COVER_FUND_RISK;

	@Column(name="COVER_CLASS")
	private String COVER_CLASS;

	@Column(name="COVER_SA_CALC")
	private String COVER_SA_CALC;

	@Column(name="COVER_PREM_TYPE")
	private String COVER_PREM_TYPE;

	@Column(name="COVER_VAR_VALUE")
	private Double COVER_VAR_VALUE;

	@Column(name="COVER_MIN_MAX_REQ")
	private String COVER_MIN_MAX_REQ;

	@Column(name="COVER_MIN_UNIT")
	private Double COVER_MIN_UNIT;

	@Column(name="COVER_MAX_UNIT")
	private Double COVER_MAX_UNIT;

	@Column(name="COVER_SA_MULTIPLE")
	private Double COVER_SA_MULTIPLE;

	@Column(name="COVER_MIN_PERC")
	private Double COVER_MIN_PERC;

	@Column(name="COVER_MAX_PERC")
	private Double COVER_MAX_PERC;

	@Column(name="COVER_MIN_TYPE")
	private String COVER_MIN_TYPE;

	@Column(name="COVER_MAX_TYPE")
	private String COVER_MAX_TYPE;

	@Column(name="COVER_SA_BY_PARTS_TARR")
	private String COVER_SA_BY_PARTS_TARR;

	@Column(name="COVER_UNIT_SA_BASIS")
	private String COVER_UNIT_SA_BASIS;

	@Column(name="COVER_UNIT_FIXED_VAL")
	private Double COVER_UNIT_FIXED_VAL;

	@Column(name="COVER_MEDICAL_YN")
	private String COVER_MEDICAL_YN;

	@Column(name="COVER_LIMIT_TYPE")
	private String COVER_LIMIT_TYPE;

	@Column(name="COVER_PER_DAY_LC_AMT")
	private Double COVER_PER_DAY_LC_AMT;

	@Column(name="COVER_LIMIT_DAYS")
	private Double COVER_LIMIT_DAYS;

	@Column(name="COVER_LC_LIMIT")
	private Double COVER_LC_LIMIT;
	
	
    private String COVER_FRZ_FLAG_UI;
    
    private String CREATE_BASIC_COVER;
	
	public String getCOVER_CODE() {
		 return COVER_CODE;
	}

	public void setCOVER_CODE(String COVER_CODE) {
		this.COVER_CODE = COVER_CODE;
	}

	public String getCOVER_LONG_DESC() {
		 return COVER_LONG_DESC;
	}

	public void setCOVER_LONG_DESC(String COVER_LONG_DESC) {
		this.COVER_LONG_DESC = COVER_LONG_DESC;
	}

	public String getCOVER_DESC() {
		 return COVER_DESC;
	}

	public void setCOVER_DESC(String COVER_DESC) {
		this.COVER_DESC = COVER_DESC;
	}

	public String getCOVER_BL_LONG_DESC() {
		 return COVER_BL_LONG_DESC;
	}

	public void setCOVER_BL_LONG_DESC(String COVER_BL_LONG_DESC) {
		this.COVER_BL_LONG_DESC = COVER_BL_LONG_DESC;
	}

	public String getCOVER_BL_DESC() {
		 return COVER_BL_DESC;
	}

	public void setCOVER_BL_DESC(String COVER_BL_DESC) {
		this.COVER_BL_DESC = COVER_BL_DESC;
	}

	public String getCOVER_TYPE() {
		 return COVER_TYPE;
	}

	public void setCOVER_TYPE(String COVER_TYPE) {
		this.COVER_TYPE = COVER_TYPE;
	}

	public String getCOVER_FRZ_FLAG() {
		
		 return this.COVER_FRZ_FLAG;
	}

	public void setCOVER_FRZ_FLAG(String COVER_FRZ_FLAG) {
		this.COVER_FRZ_FLAG = COVER_FRZ_FLAG;
	}
	public Date getCOVER_CR_DT() {
		 return COVER_CR_DT;
	}

	public void setCOVER_CR_DT(Date COVER_CR_DT) {
		this.COVER_CR_DT = COVER_CR_DT;
	}

	public String getCOVER_CR_UID() {
		 return COVER_CR_UID;
	}

	public void setCOVER_CR_UID(String COVER_CR_UID) {
		this.COVER_CR_UID = COVER_CR_UID;
	}

	public Date getCOVER_UPD_DT() {
		 return COVER_UPD_DT;
	}

	public void setCOVER_UPD_DT(Date COVER_UPD_DT) {
		this.COVER_UPD_DT = COVER_UPD_DT;
	}

	public String getCOVER_UPD_UID() {
		 return COVER_UPD_UID;
	}

	public void setCOVER_UPD_UID(String COVER_UPD_UID) {
		this.COVER_UPD_UID = COVER_UPD_UID;
	}

	public String getCOVER_APP_ON_BASIC_RATE() {
		 return COVER_APP_ON_BASIC_RATE;
	}

	public void setCOVER_APP_ON_BASIC_RATE(String COVER_APP_ON_BASIC_RATE) {
		this.COVER_APP_ON_BASIC_RATE = COVER_APP_ON_BASIC_RATE;
	}

	public Date getCOVER_EFF_FM_DT() {
		 return COVER_EFF_FM_DT;
	}

	public void setCOVER_EFF_FM_DT(Date COVER_EFF_FM_DT) {
		this.COVER_EFF_FM_DT = COVER_EFF_FM_DT;
	}

	public Date getCOVER_EFF_TO_DT() {
		 return COVER_EFF_TO_DT;
	}

	public void setCOVER_EFF_TO_DT(Date COVER_EFF_TO_DT) {
		this.COVER_EFF_TO_DT = COVER_EFF_TO_DT;
	}

	public Double getCOVER_MIN_SA() {
		 return COVER_MIN_SA;
	}

	public void setCOVER_MIN_SA(Double COVER_MIN_SA) {
		this.COVER_MIN_SA = COVER_MIN_SA;
	}

	public Double getCOVER_MAX_SA() {
		 return COVER_MAX_SA;
	}

	public void setCOVER_MAX_SA(Double COVER_MAX_SA) {
		this.COVER_MAX_SA = COVER_MAX_SA;
	}

	public String getCOVER_DISC_AGE_YN() {
		 return COVER_DISC_AGE_YN;
	}

	public void setCOVER_DISC_AGE_YN(String COVER_DISC_AGE_YN) {
		this.COVER_DISC_AGE_YN = COVER_DISC_AGE_YN;
	}

	public String getCOVER_RATE_APPLIED_ON() {
		 return COVER_RATE_APPLIED_ON;
	}

	public void setCOVER_RATE_APPLIED_ON(String COVER_RATE_APPLIED_ON) {
		this.COVER_RATE_APPLIED_ON = COVER_RATE_APPLIED_ON;
	}

	public Double getCOVER_SA_PERC() {
		 return COVER_SA_PERC;
	}

	public void setCOVER_SA_PERC(Double COVER_SA_PERC) {
		this.COVER_SA_PERC = COVER_SA_PERC;
	}

	public String getCOVER_FUND_TYPE() {
		 return COVER_FUND_TYPE;
	}

	public void setCOVER_FUND_TYPE(String COVER_FUND_TYPE) {
		this.COVER_FUND_TYPE = COVER_FUND_TYPE;
	}

	public String getCOVER_FUND_MTHD() {
		 return COVER_FUND_MTHD;
	}

	public void setCOVER_FUND_MTHD(String COVER_FUND_MTHD) {
		this.COVER_FUND_MTHD = COVER_FUND_MTHD;
	}

	public String getCOVER_FUND_RISK() {
		 return COVER_FUND_RISK;
	}

	public void setCOVER_FUND_RISK(String COVER_FUND_RISK) {
		this.COVER_FUND_RISK = COVER_FUND_RISK;
	}

	public String getCOVER_CLASS() {
		 return COVER_CLASS;
	}

	public void setCOVER_CLASS(String COVER_CLASS) {
		this.COVER_CLASS = COVER_CLASS;
	}

	public String getCOVER_SA_CALC() {
		 return COVER_SA_CALC;
	}

	public void setCOVER_SA_CALC(String COVER_SA_CALC) {
		this.COVER_SA_CALC = COVER_SA_CALC;
	}

	public String getCOVER_PREM_TYPE() {
		 return COVER_PREM_TYPE;
	}

	public void setCOVER_PREM_TYPE(String COVER_PREM_TYPE) {
		this.COVER_PREM_TYPE = COVER_PREM_TYPE;
	}

	public Double getCOVER_VAR_VALUE() {
		 return COVER_VAR_VALUE;
	}

	public void setCOVER_VAR_VALUE(Double COVER_VAR_VALUE) {
		this.COVER_VAR_VALUE = COVER_VAR_VALUE;
	}

	public String getCOVER_MIN_MAX_REQ() {
		 return COVER_MIN_MAX_REQ;
	}

	public void setCOVER_MIN_MAX_REQ(String COVER_MIN_MAX_REQ) {
		this.COVER_MIN_MAX_REQ = COVER_MIN_MAX_REQ;
	}

	public Double getCOVER_MIN_UNIT() {
		 return COVER_MIN_UNIT;
	}

	public void setCOVER_MIN_UNIT(Double COVER_MIN_UNIT) {
		this.COVER_MIN_UNIT = COVER_MIN_UNIT;
	}

	public Double getCOVER_MAX_UNIT() {
		 return COVER_MAX_UNIT;
	}

	public void setCOVER_MAX_UNIT(Double COVER_MAX_UNIT) {
		this.COVER_MAX_UNIT = COVER_MAX_UNIT;
	}

	public Double getCOVER_SA_MULTIPLE() {
		 return COVER_SA_MULTIPLE;
	}

	public void setCOVER_SA_MULTIPLE(Double COVER_SA_MULTIPLE) {
		this.COVER_SA_MULTIPLE = COVER_SA_MULTIPLE;
	}

	public Double getCOVER_MIN_PERC() {
		 return COVER_MIN_PERC;
	}

	public void setCOVER_MIN_PERC(Double COVER_MIN_PERC) {
		this.COVER_MIN_PERC = COVER_MIN_PERC;
	}

	public Double getCOVER_MAX_PERC() {
		 return COVER_MAX_PERC;
	}

	public void setCOVER_MAX_PERC(Double COVER_MAX_PERC) {
		this.COVER_MAX_PERC = COVER_MAX_PERC;
	}

	public String getCOVER_MIN_TYPE() {
		 return COVER_MIN_TYPE;
	}

	public void setCOVER_MIN_TYPE(String COVER_MIN_TYPE) {
		this.COVER_MIN_TYPE = COVER_MIN_TYPE;
	}

	public String getCOVER_MAX_TYPE() {
		 return COVER_MAX_TYPE;
	}

	public void setCOVER_MAX_TYPE(String COVER_MAX_TYPE) {
		this.COVER_MAX_TYPE = COVER_MAX_TYPE;
	}

	public String getCOVER_SA_BY_PARTS_TARR() {
		 return COVER_SA_BY_PARTS_TARR;
	}

	public void setCOVER_SA_BY_PARTS_TARR(String COVER_SA_BY_PARTS_TARR) {
		this.COVER_SA_BY_PARTS_TARR = COVER_SA_BY_PARTS_TARR;
	}

	public String getCOVER_UNIT_SA_BASIS() {
		 return COVER_UNIT_SA_BASIS;
	}

	public void setCOVER_UNIT_SA_BASIS(String COVER_UNIT_SA_BASIS) {
		this.COVER_UNIT_SA_BASIS = COVER_UNIT_SA_BASIS;
	}

	public Double getCOVER_UNIT_FIXED_VAL() {
		 return COVER_UNIT_FIXED_VAL;
	}

	public void setCOVER_UNIT_FIXED_VAL(Double COVER_UNIT_FIXED_VAL) {
		this.COVER_UNIT_FIXED_VAL = COVER_UNIT_FIXED_VAL;
	}

	public String getCOVER_MEDICAL_YN() {
		 return COVER_MEDICAL_YN;
	}

	public void setCOVER_MEDICAL_YN(String COVER_MEDICAL_YN) {
		this.COVER_MEDICAL_YN = COVER_MEDICAL_YN;
	}

	public String getCOVER_LIMIT_TYPE() {
		 return COVER_LIMIT_TYPE;
	}

	public void setCOVER_LIMIT_TYPE(String COVER_LIMIT_TYPE) {
		this.COVER_LIMIT_TYPE = COVER_LIMIT_TYPE;
	}

	public Double getCOVER_PER_DAY_LC_AMT() {
		 return COVER_PER_DAY_LC_AMT;
	}

	public void setCOVER_PER_DAY_LC_AMT(Double COVER_PER_DAY_LC_AMT) {
		this.COVER_PER_DAY_LC_AMT = COVER_PER_DAY_LC_AMT;
	}

	public Double getCOVER_LIMIT_DAYS() {
		 return COVER_LIMIT_DAYS;
	}

	public void setCOVER_LIMIT_DAYS(Double COVER_LIMIT_DAYS) {
		this.COVER_LIMIT_DAYS = COVER_LIMIT_DAYS;
	}

	public Double getCOVER_LC_LIMIT() {
		 return COVER_LC_LIMIT;
	}

	public void setCOVER_LC_LIMIT(Double COVER_LC_LIMIT) {
		this.COVER_LC_LIMIT = COVER_LC_LIMIT;
	}

	public String getCOVER_FRZ_FLAG_UI() {
		return COVER_FRZ_FLAG_UI;
	}

	public void setCOVER_FRZ_FLAG_UI(String cover_frz_flag_ui) {
		COVER_FRZ_FLAG_UI = cover_frz_flag_ui;
	}

	public String getCREATE_BASIC_COVER() {
		return CREATE_BASIC_COVER;
	}

	public void setCREATE_BASIC_COVER(String create_basic_cover) {
		CREATE_BASIC_COVER = create_basic_cover;
	}
	
	/*Added by saritha on 15/12/2017*/
	@Column(name="COVER_FUNERAL_CVR_YN")
	private String COVER_FUNERAL_CVR_YN;

	public String getCOVER_FUNERAL_CVR_YN() {
		return COVER_FUNERAL_CVR_YN;
	}

	public void setCOVER_FUNERAL_CVR_YN(String cOVER_FUNERAL_CVR_YN) {
		COVER_FUNERAL_CVR_YN = cOVER_FUNERAL_CVR_YN;
	}
	/*End*/

	/*Added by Janani on 24.04.2018 for Fidelity money tree cover validation*/
	
	@Column(name="COVER_VALIDATE_YN")
	private String COVER_VALIDATE_YN;

	public String getCOVER_VALIDATE_YN() {
		return COVER_VALIDATE_YN;
	}

	public void setCOVER_VALIDATE_YN(String cOVER_VALIDATE_YN) {
		COVER_VALIDATE_YN = cOVER_VALIDATE_YN;
	}
	
	/*End*/
	
	/*added by gopi for toi 24/05/18*/
	@Column(name="COVER_SA_FIXED")
	private Double COVER_SA_FIXED;

	public Double getCOVER_SA_FIXED() {
		return COVER_SA_FIXED;
	}

	public void setCOVER_SA_FIXED(Double cOVER_SA_FIXED) {
		COVER_SA_FIXED = cOVER_SA_FIXED;
	}
	
	
	/*end*/
	
}
