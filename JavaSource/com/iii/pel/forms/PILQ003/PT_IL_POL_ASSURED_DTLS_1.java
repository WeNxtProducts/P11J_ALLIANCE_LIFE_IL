package com.iii.pel.forms.PILQ003;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POL_ASSURED_DTLS")
public class PT_IL_POL_ASSURED_DTLS_1 extends BaseValueBean {
	

	@Column(name="POAD_SYS_ID")
	private Long POAD_SYS_ID;

	@Column(name="POAD_POL_SYS_ID")
	private Long POAD_POL_SYS_ID;

	@Column(name="POAD_SERIAL_NO")
	private Double POAD_SERIAL_NO;

	@Column(name="POAD_ASSR_CODE")
	private String POAD_ASSR_CODE;

	@Column(name="POAD_ASSURED_NAME")
	private String POAD_ASSURED_NAME;

	@Column(name="POAD_BIRTH_PLACE")
	private String POAD_BIRTH_PLACE;

	@Column(name="POAD_DOB")
	private Date POAD_DOB;

	@Column(name="POAD_AGE")
	private Integer POAD_AGE;

	@Column(name="POAD_NATIONALITY")
	private String POAD_NATIONALITY;

	@Column(name="POAD_MAR_STATUS")
	private String POAD_MAR_STATUS;

	@Column(name="POAD_OCC_CODE")
	private String POAD_OCC_CODE;

	@Column(name="POAD_NATURE_OF_WORK")
	private String POAD_NATURE_OF_WORK;

	@Column(name="POAD_HEALTH_CODE")
	private String POAD_HEALTH_CODE;

	@Column(name="POAD_REMARKS")
	private String POAD_REMARKS;

	@Column(name="POAD_CR_DT")
	private Date POAD_CR_DT;

	@Column(name="POAD_CR_UID")
	private String POAD_CR_UID;

	@Column(name="POAD_UPD_DT")
	private Date POAD_UPD_DT;

	@Column(name="POAD_UPD_UID")
	private String POAD_UPD_UID;

	@Column(name="POAD_FC_SUM_ASSURED")
	private Double POAD_FC_SUM_ASSURED;

	@Column(name="POAD_LC_SUM_ASSURED")
	private Double POAD_LC_SUM_ASSURED;

	@Column(name="POAD_FC_AMAN_PREM")
	private Double POAD_FC_AMAN_PREM;

	@Column(name="POAD_LC_AMAN_PREM")
	private Double POAD_LC_AMAN_PREM;

	@Column(name="POAD_FC_SENABEL_PREM")
	private Double POAD_FC_SENABEL_PREM;

	@Column(name="POAD_LC_SENABEL_PREM")
	private Double POAD_LC_SENABEL_PREM;

	@Column(name="POAD_FC_AMAN_LOAD_PREM")
	private Double POAD_FC_AMAN_LOAD_PREM;

	@Column(name="POAD_LC_AMAN_LOAD_PREM")
	private Double POAD_LC_AMAN_LOAD_PREM;

	@Column(name="POAD_CATG_CODE")
	private String POAD_CATG_CODE;

	@Column(name="POAD_HEALTH_RATE")
	private Double POAD_HEALTH_RATE;

	@Column(name="POAD_HEIGHT")
	private Double POAD_HEIGHT;

	@Column(name="POAD_WEIGHT")
	private Double POAD_WEIGHT;

	@Column(name="POAD_DISC_AGE")
	private Integer POAD_DISC_AGE;

	@Column(name="POAD_ADDL_RISK_CODE")
	private String POAD_ADDL_RISK_CODE;

	@Column(name="POAD_AGE_PROOF_FLAG")
	private String POAD_AGE_PROOF_FLAG;

	@Column(name="POAD_AGE_PROOF_OTHERS")
	private String POAD_AGE_PROOF_OTHERS;

	@Column(name="POAD_REF_ID1")
	private String POAD_REF_ID1;

	@Column(name="POAD_REF_ID2")
	private String POAD_REF_ID2;

	@Column(name="POAD_OCC_CLASS")
	private String POAD_OCC_CLASS;

	@Column(name="POAD_BMI")
	private Double POAD_BMI;

	@Column(name="POAD_RACE")
	private String POAD_RACE;

	@Column(name="POAD_LC_THRESHOLD_LMT")
	private Double POAD_LC_THRESHOLD_LMT;

	@Column(name="POAD_ORG_LC_THRESHOLD_LMT")
	private Double POAD_ORG_LC_THRESHOLD_LMT;

	@Column(name="POAD_RELIGION_CODE")
	private String POAD_RELIGION_CODE;

	@Column(name="POAD_TYPE")
	private String POAD_TYPE;

	@Column(name="POAD_HEIGHT_UNIT")
	private String POAD_HEIGHT_UNIT;

	@Column(name="POAD_WEIGHT_UNIT")
	private String POAD_WEIGHT_UNIT;

	@Column(name="POAD_FC_SALARY")
	private Double POAD_FC_SALARY;

	@Column(name="POAD_LC_SALARY")
	private Double POAD_LC_SALARY;

	@Column(name="POAD_SMOKE_YN")
	private String POAD_SMOKE_YN;

	@Column(name="POAD_NO_OF_CIGAR")
	private Integer POAD_NO_OF_CIGAR;

	private String UI_M_POAD_CATG_DESC;
	
	private String UI_M_POAD_RACE_CODE_DESC;

	private String UI_M_ADDL_RISK_DESC;
	
	private Double UI_M_POAD_LC_THRESOLD_LMT;
	
	private String UI_M_POAD_NATLITY_DESC;
	
	private String UI_M_POAD_MS_DESC;
	
	private String UI_M_POAD_OCC_DESC;
	
	private String UI_M_POAD_OCC_CLASS_DESC;
	
	private String UI_M_POAD_REL_CODE_DESC;
	
	private String UI_M_POAD_HEALTH_DESC;
	
	private Double POAD_OCC_RATE;
	
	public Double getPOAD_OCC_RATE() {
		return POAD_OCC_RATE;
	}
	public void setPOAD_OCC_RATE(Double poad_occ_rate) {
		POAD_OCC_RATE = poad_occ_rate;
	}
	public void setPOAD_LC_AMAN_LOAD_PREM(Double POAD_LC_AMAN_LOAD_PREM) {
		this.POAD_LC_AMAN_LOAD_PREM = POAD_LC_AMAN_LOAD_PREM;
	}
	public Double getPOAD_LC_AMAN_LOAD_PREM() {
		 return POAD_LC_AMAN_LOAD_PREM;
	}
	public void setUI_M_POAD_LC_THRESOLD_LMT(Double UI_M_POAD_LC_THRESOLD_LMT) {
		this.UI_M_POAD_LC_THRESOLD_LMT = UI_M_POAD_LC_THRESOLD_LMT;
	}
	public Double getUI_M_POAD_LC_THRESOLD_LMT() {
		 return UI_M_POAD_LC_THRESOLD_LMT;
	}
	public void setPOAD_AGE_PROOF_FLAG(String POAD_AGE_PROOF_FLAG) {
		this.POAD_AGE_PROOF_FLAG = POAD_AGE_PROOF_FLAG;
	}
	public String getPOAD_AGE_PROOF_FLAG() {
		 return POAD_AGE_PROOF_FLAG;
	}
	public void setPOAD_UPD_UID(String POAD_UPD_UID) {
		this.POAD_UPD_UID = POAD_UPD_UID;
	}
	public String getPOAD_UPD_UID() {
		 return POAD_UPD_UID;
	}
	public void setPOAD_MAR_STATUS(String POAD_MAR_STATUS) {
		this.POAD_MAR_STATUS = POAD_MAR_STATUS;
	}
	public String getPOAD_MAR_STATUS() {
		 return POAD_MAR_STATUS;
	}
	public void setPOAD_UPD_DT(Date POAD_UPD_DT) {
		this.POAD_UPD_DT = POAD_UPD_DT;
	}
	public Date getPOAD_UPD_DT() {
		 return POAD_UPD_DT;
	}
	public void setPOAD_REMARKS(String POAD_REMARKS) {
		this.POAD_REMARKS = POAD_REMARKS;
	}
	public String getPOAD_REMARKS() {
		 return POAD_REMARKS;
	}
	public void setPOAD_ORG_LC_THRESHOLD_LMT(Double POAD_ORG_LC_THRESHOLD_LMT) {
		this.POAD_ORG_LC_THRESHOLD_LMT = POAD_ORG_LC_THRESHOLD_LMT;
	}
	public Double getPOAD_ORG_LC_THRESHOLD_LMT() {
		 return POAD_ORG_LC_THRESHOLD_LMT;
	}
	public void setUI_M_POAD_OCC_CLASS_DESC(String UI_M_POAD_OCC_CLASS_DESC) {
		this.UI_M_POAD_OCC_CLASS_DESC = UI_M_POAD_OCC_CLASS_DESC;
	}
	public String getUI_M_POAD_OCC_CLASS_DESC() {
		 return UI_M_POAD_OCC_CLASS_DESC;
	}
	public void setPOAD_LC_THRESHOLD_LMT(Double POAD_LC_THRESHOLD_LMT) {
		this.POAD_LC_THRESHOLD_LMT = POAD_LC_THRESHOLD_LMT;
	}
	public Double getPOAD_LC_THRESHOLD_LMT() {
		 return POAD_LC_THRESHOLD_LMT;
	}
	public void setPOAD_SYS_ID(Long POAD_SYS_ID) {
		this.POAD_SYS_ID = POAD_SYS_ID;
	}
	public Long getPOAD_SYS_ID() {
		 return POAD_SYS_ID;
	}
	public void setPOAD_CR_UID(String POAD_CR_UID) {
		this.POAD_CR_UID = POAD_CR_UID;
	}
	public String getPOAD_CR_UID() {
		 return POAD_CR_UID;
	}
	public void setPOAD_ADDL_RISK_CODE(String POAD_ADDL_RISK_CODE) {
		this.POAD_ADDL_RISK_CODE = POAD_ADDL_RISK_CODE;
	}
	public String getPOAD_ADDL_RISK_CODE() {
		 return POAD_ADDL_RISK_CODE;
	}
	public void setPOAD_AGE_PROOF_OTHERS(String POAD_AGE_PROOF_OTHERS) {
		this.POAD_AGE_PROOF_OTHERS = POAD_AGE_PROOF_OTHERS;
	}
	public String getPOAD_AGE_PROOF_OTHERS() {
		 return POAD_AGE_PROOF_OTHERS;
	}
	public void setPOAD_FC_SALARY(Double POAD_FC_SALARY) {
		this.POAD_FC_SALARY = POAD_FC_SALARY;
	}
	public Double getPOAD_FC_SALARY() {
		 return POAD_FC_SALARY;
	}
	public void setPOAD_SERIAL_NO(Double POAD_SERIAL_NO) {
		this.POAD_SERIAL_NO = POAD_SERIAL_NO;
	}
	public Double getPOAD_SERIAL_NO() {
		 return POAD_SERIAL_NO;
	}
	public void setPOAD_BMI(Double POAD_BMI) {
		this.POAD_BMI = POAD_BMI;
	}
	public Double getPOAD_BMI() {
		 return POAD_BMI;
	}
	public void setPOAD_HEALTH_CODE(String POAD_HEALTH_CODE) {
		this.POAD_HEALTH_CODE = POAD_HEALTH_CODE;
	}
	public String getPOAD_HEALTH_CODE() {
		 return POAD_HEALTH_CODE;
	}
	public void setPOAD_CR_DT(Date POAD_CR_DT) {
		this.POAD_CR_DT = POAD_CR_DT;
	}
	public Date getPOAD_CR_DT() {
		 return POAD_CR_DT;
	}
	public void setPOAD_HEIGHT_UNIT(String POAD_HEIGHT_UNIT) {
		this.POAD_HEIGHT_UNIT = POAD_HEIGHT_UNIT;
	}
	public String getPOAD_HEIGHT_UNIT() {
		 return POAD_HEIGHT_UNIT;
	}
	public void setPOAD_SMOKE_YN(String POAD_SMOKE_YN) {
		this.POAD_SMOKE_YN = POAD_SMOKE_YN;
	}
	public String getPOAD_SMOKE_YN() {
		 return POAD_SMOKE_YN;
	}
	public void setUI_M_POAD_MS_DESC(String UI_M_POAD_MS_DESC) {
		this.UI_M_POAD_MS_DESC = UI_M_POAD_MS_DESC;
	}
	public String getUI_M_POAD_MS_DESC() {
		 return UI_M_POAD_MS_DESC;
	}
	public void setPOAD_DISC_AGE(Integer POAD_DISC_AGE) {
		this.POAD_DISC_AGE = POAD_DISC_AGE;
	}
	public Integer getPOAD_DISC_AGE() {
		 return POAD_DISC_AGE;
	}
	public void setUI_M_POAD_OCC_DESC(String UI_M_POAD_OCC_DESC) {
		this.UI_M_POAD_OCC_DESC = UI_M_POAD_OCC_DESC;
	}
	public String getUI_M_POAD_OCC_DESC() {
		 return UI_M_POAD_OCC_DESC;
	}
	public void setPOAD_FC_AMAN_LOAD_PREM(Double POAD_FC_AMAN_LOAD_PREM) {
		this.POAD_FC_AMAN_LOAD_PREM = POAD_FC_AMAN_LOAD_PREM;
	}
	public Double getPOAD_FC_AMAN_LOAD_PREM() {
		 return POAD_FC_AMAN_LOAD_PREM;
	}
	public void setPOAD_REF_ID2(String POAD_REF_ID2) {
		this.POAD_REF_ID2 = POAD_REF_ID2;
	}
	public String getPOAD_REF_ID2() {
		 return POAD_REF_ID2;
	}
	public void setPOAD_REF_ID1(String POAD_REF_ID1) {
		this.POAD_REF_ID1 = POAD_REF_ID1;
	}
	public String getPOAD_REF_ID1() {
		 return POAD_REF_ID1;
	}
	public void setPOAD_CATG_CODE(String POAD_CATG_CODE) {
		this.POAD_CATG_CODE = POAD_CATG_CODE;
	}
	public String getPOAD_CATG_CODE() {
		 return POAD_CATG_CODE;
	}
	public void setPOAD_OCC_CODE(String POAD_OCC_CODE) {
		this.POAD_OCC_CODE = POAD_OCC_CODE;
	}
	public String getPOAD_OCC_CODE() {
		 return POAD_OCC_CODE;
	}
	public void setUI_M_POAD_RACE_CODE_DESC(String UI_M_POAD_RACE_CODE_DESC) {
		this.UI_M_POAD_RACE_CODE_DESC = UI_M_POAD_RACE_CODE_DESC;
	}
	public String getUI_M_POAD_RACE_CODE_DESC() {
		 return UI_M_POAD_RACE_CODE_DESC;
	}
	public void setPOAD_FC_SUM_ASSURED(Double POAD_FC_SUM_ASSURED) {
		this.POAD_FC_SUM_ASSURED = POAD_FC_SUM_ASSURED;
	}
	public Double getPOAD_FC_SUM_ASSURED() {
		 return POAD_FC_SUM_ASSURED;
	}
	public void setPOAD_WEIGHT_UNIT(String POAD_WEIGHT_UNIT) {
		this.POAD_WEIGHT_UNIT = POAD_WEIGHT_UNIT;
	}
	public String getPOAD_WEIGHT_UNIT() {
		 return POAD_WEIGHT_UNIT;
	}
	public void setPOAD_POL_SYS_ID(Long POAD_POL_SYS_ID) {
		this.POAD_POL_SYS_ID = POAD_POL_SYS_ID;
	}
	public Long getPOAD_POL_SYS_ID() {
		 return POAD_POL_SYS_ID;
	}
	public void setPOAD_FC_AMAN_PREM(Double POAD_FC_AMAN_PREM) {
		this.POAD_FC_AMAN_PREM = POAD_FC_AMAN_PREM;
	}
	public Double getPOAD_FC_AMAN_PREM() {
		 return POAD_FC_AMAN_PREM;
	}
	public void setPOAD_AGE(Integer POAD_AGE) {
		this.POAD_AGE = POAD_AGE;
	}
	public Integer getPOAD_AGE() {
		 return POAD_AGE;
	}
	public void setPOAD_RACE(String POAD_RACE) {
		this.POAD_RACE = POAD_RACE;
	}
	public String getPOAD_RACE() {
		 return POAD_RACE;
	}
	public void setUI_M_ADDL_RISK_DESC(String UI_M_ADDL_RISK_DESC) {
		this.UI_M_ADDL_RISK_DESC = UI_M_ADDL_RISK_DESC;
	}
	public String getUI_M_ADDL_RISK_DESC() {
		 return UI_M_ADDL_RISK_DESC;
	}
	public void setPOAD_DOB(Date POAD_DOB) {
		this.POAD_DOB = POAD_DOB;
	}
	public Date getPOAD_DOB() {
		 return POAD_DOB;
	}
	public void setPOAD_LC_SALARY(Double POAD_LC_SALARY) {
		this.POAD_LC_SALARY = POAD_LC_SALARY;
	}
	public Double getPOAD_LC_SALARY() {
		 return POAD_LC_SALARY;
	}
	public void setUI_M_POAD_HEALTH_DESC(String UI_M_POAD_HEALTH_DESC) {
		this.UI_M_POAD_HEALTH_DESC = UI_M_POAD_HEALTH_DESC;
	}
	public String getUI_M_POAD_HEALTH_DESC() {
		 return UI_M_POAD_HEALTH_DESC;
	}
	public void setPOAD_HEIGHT(Double POAD_HEIGHT) {
		this.POAD_HEIGHT = POAD_HEIGHT;
	}
	public Double getPOAD_HEIGHT() {
		 return POAD_HEIGHT;
	}
	public void setPOAD_OCC_CLASS(String POAD_OCC_CLASS) {
		this.POAD_OCC_CLASS = POAD_OCC_CLASS;
	}
	public String getPOAD_OCC_CLASS() {
		 return POAD_OCC_CLASS;
	}
	public void setPOAD_LC_SENABEL_PREM(Double POAD_LC_SENABEL_PREM) {
		this.POAD_LC_SENABEL_PREM = POAD_LC_SENABEL_PREM;
	}
	public Double getPOAD_LC_SENABEL_PREM() {
		 return POAD_LC_SENABEL_PREM;
	}
	public void setPOAD_NATIONALITY(String POAD_NATIONALITY) {
		this.POAD_NATIONALITY = POAD_NATIONALITY;
	}
	public String getPOAD_NATIONALITY() {
		 return POAD_NATIONALITY;
	}
	public void setPOAD_NATURE_OF_WORK(String POAD_NATURE_OF_WORK) {
		this.POAD_NATURE_OF_WORK = POAD_NATURE_OF_WORK;
	}
	public String getPOAD_NATURE_OF_WORK() {
		 return POAD_NATURE_OF_WORK;
	}
	public void setPOAD_WEIGHT(Double POAD_WEIGHT) {
		this.POAD_WEIGHT = POAD_WEIGHT;
	}
	public Double getPOAD_WEIGHT() {
		 return POAD_WEIGHT;
	}
	public void setPOAD_ASSR_CODE(String POAD_ASSR_CODE) {
		this.POAD_ASSR_CODE = POAD_ASSR_CODE;
	}
	public String getPOAD_ASSR_CODE() {
		 return POAD_ASSR_CODE;
	}
	public void setPOAD_RELIGION_CODE(String POAD_RELIGION_CODE) {
		this.POAD_RELIGION_CODE = POAD_RELIGION_CODE;
	}
	public String getPOAD_RELIGION_CODE() {
		 return POAD_RELIGION_CODE;
	}
	public void setPOAD_TYPE(String POAD_TYPE) {
		this.POAD_TYPE = POAD_TYPE;
	}
	public String getPOAD_TYPE() {
		 return POAD_TYPE;
	}
	public void setPOAD_LC_SUM_ASSURED(Double POAD_LC_SUM_ASSURED) {
		this.POAD_LC_SUM_ASSURED = POAD_LC_SUM_ASSURED;
	}
	public Double getPOAD_LC_SUM_ASSURED() {
		 return POAD_LC_SUM_ASSURED;
	}
	public void setPOAD_FC_SENABEL_PREM(Double POAD_FC_SENABEL_PREM) {
		this.POAD_FC_SENABEL_PREM = POAD_FC_SENABEL_PREM;
	}
	public Double getPOAD_FC_SENABEL_PREM() {
		 return POAD_FC_SENABEL_PREM;
	}
	public void setPOAD_ASSURED_NAME(String POAD_ASSURED_NAME) {
		this.POAD_ASSURED_NAME = POAD_ASSURED_NAME;
	}
	public String getPOAD_ASSURED_NAME() {
		 return POAD_ASSURED_NAME;
	}
	public void setPOAD_BIRTH_PLACE(String POAD_BIRTH_PLACE) {
		this.POAD_BIRTH_PLACE = POAD_BIRTH_PLACE;
	}
	public String getPOAD_BIRTH_PLACE() {
		 return POAD_BIRTH_PLACE;
	}
	public void setUI_M_POAD_REL_CODE_DESC(String UI_M_POAD_REL_CODE_DESC) {
		this.UI_M_POAD_REL_CODE_DESC = UI_M_POAD_REL_CODE_DESC;
	}
	public String getUI_M_POAD_REL_CODE_DESC() {
		 return UI_M_POAD_REL_CODE_DESC;
	}
	public void setUI_M_POAD_NATLITY_DESC(String UI_M_POAD_NATLITY_DESC) {
		this.UI_M_POAD_NATLITY_DESC = UI_M_POAD_NATLITY_DESC;
	}
	public String getUI_M_POAD_NATLITY_DESC() {
		 return UI_M_POAD_NATLITY_DESC;
	}
	public void setUI_M_POAD_CATG_DESC(String UI_M_POAD_CATG_DESC) {
		this.UI_M_POAD_CATG_DESC = UI_M_POAD_CATG_DESC;
	}
	public String getUI_M_POAD_CATG_DESC() {
		 return UI_M_POAD_CATG_DESC;
	}
	public void setPOAD_LC_AMAN_PREM(Double POAD_LC_AMAN_PREM) {
		this.POAD_LC_AMAN_PREM = POAD_LC_AMAN_PREM;
	}
	public Double getPOAD_LC_AMAN_PREM() {
		 return POAD_LC_AMAN_PREM;
	}
	public void setPOAD_HEALTH_RATE(Double POAD_HEALTH_RATE) {
		this.POAD_HEALTH_RATE = POAD_HEALTH_RATE;
	}
	public Double getPOAD_HEALTH_RATE() {
		 return POAD_HEALTH_RATE;
	}
	public void setPOAD_NO_OF_CIGAR(Integer POAD_NO_OF_CIGAR) {
		this.POAD_NO_OF_CIGAR = POAD_NO_OF_CIGAR;
	}
	public Integer getPOAD_NO_OF_CIGAR() {
		 return POAD_NO_OF_CIGAR;
	}

}
