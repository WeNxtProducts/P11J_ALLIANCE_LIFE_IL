package com.iii.pel.forms.PILQ003;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_POL_ADDL_COVER")
public class PT_IL_POL_ADDL_COVER_1 extends BaseValueBean {

	@Column(name = "POAC_SYS_ID")
	private Long POAC_SYS_ID;

	@Column(name = "POAC_POL_SYS_ID")
	private Long POAC_POL_SYS_ID;

	@Column(name = "POAC_COVER_CODE")
	private String POAC_COVER_CODE;

	@Column(name = "POAC_APPL_ALL")
	private String POAC_APPL_ALL;

	@Column(name = "POAC_ASSR_CODE")
	private String POAC_ASSR_CODE;

	@Column(name = "POAC_RATE")
	private Double POAC_RATE;

	@Column(name = "POAC_LC_PREM")
	private Double POAC_LC_PREM;

	@Column(name = "POAC_FC_PREM")
	private Double POAC_FC_PREM;

	@Column(name = "POAC_DEL_FLAG")
	private String POAC_DEL_FLAG;

	@Column(name = "POAC_CR_DT")
	private Date POAC_CR_DT;

	@Column(name = "POAC_CR_UID")
	private String POAC_CR_UID;

	@Column(name = "POAC_UPD_DT")
	private Date POAC_UPD_DT;

	@Column(name = "POAC_UPD_UID")
	private String POAC_UPD_UID;

	@Column(name = "POAC_POAD_SYS_ID")
	private Long POAC_POAD_SYS_ID;

	@Column(name = "POAC_PERIOD")
	private Integer POAC_PERIOD;

	@Column(name = "POAC_PREM_PAY_YRS")
	private Integer POAC_PREM_PAY_YRS;

	@Column(name = "POAC_FM_DT")
	private Date POAC_FM_DT;

	@Column(name = "POAC_TO_DT")
	private Date POAC_TO_DT;

	@Column(name = "POAC_FC_SA")
	private Double POAC_FC_SA;

	@Column(name = "POAC_LC_SA")
	private Double POAC_LC_SA;

	@Column(name = "POAC_RATE_PER")
	private Double POAC_RATE_PER;

	@Column(name = "POAC_TARIFF_TERM_FLAG")
	private String POAC_TARIFF_TERM_FLAG;

	@Column(name = "POAC_RATE_APPLIED_ON")
	private String POAC_RATE_APPLIED_ON;

	@Column(name = "POAC_ORG_RATE")
	private Double POAC_ORG_RATE;

	@Column(name = "POAC_ORG_RATE_PER")
	private Double POAC_ORG_RATE_PER;

	@Column(name = "POAC_ORG_PERIOD")
	private Integer POAC_ORG_PERIOD;

	@Column(name = "POAC_ORG_PREM_PAY_YRS")
	private Integer POAC_ORG_PREM_PAY_YRS;

	@Column(name = "POAC_ORG_FC_SA")
	private Double POAC_ORG_FC_SA;

	@Column(name = "POAC_ORG_LC_SA")
	private Double POAC_ORG_LC_SA;

	@Column(name = "POAC_ORG_LC_PREM")
	private Double POAC_ORG_LC_PREM;

	@Column(name = "POAC_ORG_FC_PREM")
	private Double POAC_ORG_FC_PREM;

	@Column(name = "POAC_WOP_FLAG")
	private String POAC_WOP_FLAG;

	@Column(name = "POAC_MED_DAYS")
	private Integer POAC_MED_DAYS;

	@Column(name = "POAC_LC_MED_AMT")
	private Double POAC_LC_MED_AMT;

	@Column(name = "POAC_ORG_MED_DAYS")
	private Double POAC_ORG_MED_DAYS;

	@Column(name = "POAC_ORG_LC_MED_AMT")
	private Double POAC_ORG_LC_MED_AMT;

	@Column(name = "POAC_MASTER_SYS_ID")
	private Long POAC_MASTER_SYS_ID;

	@Column(name = "POAC_NO_OF_UNIT")
	private Integer POAC_NO_OF_UNIT;

	@Column(name = "POAC_ORG_NO_OF_UNIT")
	private Double POAC_ORG_NO_OF_UNIT;

	@Column(name = "POAC_PCG_SYS_ID")
	private Long POAC_PCG_SYS_ID;

	@Column(name = "POAC_PAPP_SYS_ID")
	private Long POAC_PAPP_SYS_ID;

	@Column(name = "POAC_LIMIT_TYPE")
	private String POAC_LIMIT_TYPE;

	@Column(name = "POAC_PER_DAY_LC_AMT")
	private Double POAC_PER_DAY_LC_AMT;

	@Column(name = "POAC_LIMIT_DAYS")
	private Integer POAC_LIMIT_DAYS;

	@Column(name = "POAC_LC_LIMIT")
	private Double POAC_LC_LIMIT;

	private String UI_M_POAC_ASSR_NAME;

	private String UI_M_POAC_COVER_DESC;
	private String UI_M_PROD_CODE;
	private String UI_M_PCG_CODE;

	private String UI_M_POAC_ASSR_CODE;
	private String UI_M_PROD_CODE_1;
	private String UI_M_PCG_CODE_1;
	private String UI_M_POAC_COVER_CODE_PAYEE_1;

	private Double UI_M_POAC_FC_PREM;

	private Double UI_M_POAC_LC_PREM;

	private String UI_M_POAC_COVER_CODE_PAYEE_2;
	private String UI_M_POAC_COVER_DESC_2;

	public void setPOAC_PCG_SYS_ID(Long POAC_PCG_SYS_ID) {
		this.POAC_PCG_SYS_ID = POAC_PCG_SYS_ID;
	}

	public Long getPOAC_PCG_SYS_ID() {
		return POAC_PCG_SYS_ID;
	}

	public void setUI_M_POAC_FC_PREM(Double UI_M_POAC_FC_PREM) {
		this.UI_M_POAC_FC_PREM = UI_M_POAC_FC_PREM;
	}

	public Double getUI_M_POAC_FC_PREM() {
		return UI_M_POAC_FC_PREM;
	}

	public void setUI_M_POAC_ASSR_CODE(String UI_M_POAC_ASSR_CODE) {
		this.UI_M_POAC_ASSR_CODE = UI_M_POAC_ASSR_CODE;
	}

	public String getUI_M_POAC_ASSR_CODE() {
		return UI_M_POAC_ASSR_CODE;
	}

	public void setPOAC_ORG_LC_MED_AMT(Double POAC_ORG_LC_MED_AMT) {
		this.POAC_ORG_LC_MED_AMT = POAC_ORG_LC_MED_AMT;
	}

	public Double getPOAC_ORG_LC_MED_AMT() {
		return POAC_ORG_LC_MED_AMT;
	}

	public void setPOAC_LC_SA(Double POAC_LC_SA) {
		this.POAC_LC_SA = POAC_LC_SA;
	}

	public Double getPOAC_LC_SA() {
		return POAC_LC_SA;
	}

	public void setPOAC_PER_DAY_LC_AMT(Double POAC_PER_DAY_LC_AMT) {
		this.POAC_PER_DAY_LC_AMT = POAC_PER_DAY_LC_AMT;
	}

	public Double getPOAC_PER_DAY_LC_AMT() {
		return POAC_PER_DAY_LC_AMT;
	}

	public void setPOAC_PAPP_SYS_ID(Long POAC_PAPP_SYS_ID) {
		this.POAC_PAPP_SYS_ID = POAC_PAPP_SYS_ID;
	}

	public Long getPOAC_PAPP_SYS_ID() {
		return POAC_PAPP_SYS_ID;
	}

	public void setPOAC_CR_DT(Date POAC_CR_DT) {
		this.POAC_CR_DT = POAC_CR_DT;
	}

	public Date getPOAC_CR_DT() {
		return POAC_CR_DT;
	}

	public void setPOAC_ORG_RATE_PER(Double POAC_ORG_RATE_PER) {
		this.POAC_ORG_RATE_PER = POAC_ORG_RATE_PER;
	}

	public Double getPOAC_ORG_RATE_PER() {
		return POAC_ORG_RATE_PER;
	}

	public void setPOAC_APPL_ALL(String POAC_APPL_ALL) {
		this.POAC_APPL_ALL = POAC_APPL_ALL;
	}

	public String getPOAC_APPL_ALL() {
		return POAC_APPL_ALL;
	}

	public void setPOAC_ORG_MED_DAYS(Double POAC_ORG_MED_DAYS) {
		this.POAC_ORG_MED_DAYS = POAC_ORG_MED_DAYS;
	}

	public Double getPOAC_ORG_MED_DAYS() {
		return POAC_ORG_MED_DAYS;
	}

	public void setPOAC_FC_PREM(Double POAC_FC_PREM) {
		this.POAC_FC_PREM = POAC_FC_PREM;
	}

	public Double getPOAC_FC_PREM() {
		return POAC_FC_PREM;
	}

	public void setPOAC_LC_LIMIT(Double POAC_LC_LIMIT) {
		this.POAC_LC_LIMIT = POAC_LC_LIMIT;
	}

	public Double getPOAC_LC_LIMIT() {
		return POAC_LC_LIMIT;
	}

	public void setPOAC_TO_DT(Date POAC_TO_DT) {
		this.POAC_TO_DT = POAC_TO_DT;
	}

	public Date getPOAC_TO_DT() {
		return POAC_TO_DT;
	}

	public void setPOAC_TARIFF_TERM_FLAG(String POAC_TARIFF_TERM_FLAG) {
		this.POAC_TARIFF_TERM_FLAG = POAC_TARIFF_TERM_FLAG;
	}

	public String getPOAC_TARIFF_TERM_FLAG() {
		return POAC_TARIFF_TERM_FLAG;
	}



	public void setPOAC_FC_SA(Double POAC_FC_SA) {
		this.POAC_FC_SA = POAC_FC_SA;
	}

	public Double getPOAC_FC_SA() {
		return POAC_FC_SA;
	}

	public void setPOAC_LIMIT_TYPE(String POAC_LIMIT_TYPE) {
		this.POAC_LIMIT_TYPE = POAC_LIMIT_TYPE;
	}

	public String getPOAC_LIMIT_TYPE() {
		return POAC_LIMIT_TYPE;
	}

	public void setPOAC_UPD_UID(String POAC_UPD_UID) {
		this.POAC_UPD_UID = POAC_UPD_UID;
	}

	public String getPOAC_UPD_UID() {
		return POAC_UPD_UID;
	}

	public void setPOAC_ORG_LC_SA(Double POAC_ORG_LC_SA) {
		this.POAC_ORG_LC_SA = POAC_ORG_LC_SA;
	}

	public Double getPOAC_ORG_LC_SA() {
		return POAC_ORG_LC_SA;
	}

	public void setPOAC_RATE_PER(Double POAC_RATE_PER) {
		this.POAC_RATE_PER = POAC_RATE_PER;
	}

	public Double getPOAC_RATE_PER() {
		return POAC_RATE_PER;
	}

	public void setPOAC_ORG_LC_PREM(Double POAC_ORG_LC_PREM) {
		this.POAC_ORG_LC_PREM = POAC_ORG_LC_PREM;
	}

	public Double getPOAC_ORG_LC_PREM() {
		return POAC_ORG_LC_PREM;
	}

	public void setUI_M_PCG_CODE_1(String UI_M_PCG_CODE_1) {
		this.UI_M_PCG_CODE_1 = UI_M_PCG_CODE_1;
	}

	public String getUI_M_PCG_CODE_1() {
		return UI_M_PCG_CODE_1;
	}

	public void setPOAC_SYS_ID(Long POAC_SYS_ID) {
		this.POAC_SYS_ID = POAC_SYS_ID;
	}

	public Long getPOAC_SYS_ID() {
		return POAC_SYS_ID;
	}

	public void setPOAC_ORG_FC_SA(Double POAC_ORG_FC_SA) {
		this.POAC_ORG_FC_SA = POAC_ORG_FC_SA;
	}

	public Double getPOAC_ORG_FC_SA() {
		return POAC_ORG_FC_SA;
	}

	

	public void setPOAC_CR_UID(String POAC_CR_UID) {
		this.POAC_CR_UID = POAC_CR_UID;
	}

	public String getPOAC_CR_UID() {
		return POAC_CR_UID;
	}

	public void setPOAC_MASTER_SYS_ID(Long POAC_MASTER_SYS_ID) {
		this.POAC_MASTER_SYS_ID = POAC_MASTER_SYS_ID;
	}

	public Long getPOAC_MASTER_SYS_ID() {
		return POAC_MASTER_SYS_ID;
	}

	public void setUI_M_POAC_COVER_CODE_PAYEE_1(
			String UI_M_POAC_COVER_CODE_PAYEE_1) {
		this.UI_M_POAC_COVER_CODE_PAYEE_1 = UI_M_POAC_COVER_CODE_PAYEE_1;
	}

	public String getUI_M_POAC_COVER_CODE_PAYEE_1() {
		return UI_M_POAC_COVER_CODE_PAYEE_1;
	}

	public void setUI_M_POAC_COVER_CODE_PAYEE_2(
			String UI_M_POAC_COVER_CODE_PAYEE_2) {
		this.UI_M_POAC_COVER_CODE_PAYEE_2 = UI_M_POAC_COVER_CODE_PAYEE_2;
	}

	public String getUI_M_POAC_COVER_CODE_PAYEE_2() {
		return UI_M_POAC_COVER_CODE_PAYEE_2;
	}

	
	public void setPOAC_RATE(Double POAC_RATE) {
		this.POAC_RATE = POAC_RATE;
	}

	public Double getPOAC_RATE() {
		return POAC_RATE;
	}

	public void setPOAC_ORG_FC_PREM(Double POAC_ORG_FC_PREM) {
		this.POAC_ORG_FC_PREM = POAC_ORG_FC_PREM;
	}

	public Double getPOAC_ORG_FC_PREM() {
		return POAC_ORG_FC_PREM;
	}

	public void setPOAC_FM_DT(Date POAC_FM_DT) {
		this.POAC_FM_DT = POAC_FM_DT;
	}

	public Date getPOAC_FM_DT() {
		return POAC_FM_DT;
	}

	public void setPOAC_LC_PREM(Double POAC_LC_PREM) {
		this.POAC_LC_PREM = POAC_LC_PREM;
	}

	public Double getPOAC_LC_PREM() {
		return POAC_LC_PREM;
	}

	
	public void setPOAC_COVER_CODE(String POAC_COVER_CODE) {
		this.POAC_COVER_CODE = POAC_COVER_CODE;
	}

	public String getPOAC_COVER_CODE() {
		return POAC_COVER_CODE;
	}

	

	public Integer getPOAC_LIMIT_DAYS() {
		return POAC_LIMIT_DAYS;
	}

	public void setPOAC_LIMIT_DAYS(Integer poac_limit_days) {
		POAC_LIMIT_DAYS = poac_limit_days;
	}

	public void setUI_M_POAC_COVER_DESC(String UI_M_POAC_COVER_DESC) {
		this.UI_M_POAC_COVER_DESC = UI_M_POAC_COVER_DESC;
	}

	public String getUI_M_POAC_COVER_DESC() {
		return UI_M_POAC_COVER_DESC;
	}

	public void setPOAC_WOP_FLAG(String POAC_WOP_FLAG) {
		this.POAC_WOP_FLAG = POAC_WOP_FLAG;
	}

	public String getPOAC_WOP_FLAG() {
		return POAC_WOP_FLAG;
	}

	public void setPOAC_DEL_FLAG(String POAC_DEL_FLAG) {
		this.POAC_DEL_FLAG = POAC_DEL_FLAG;
	}

	public String getPOAC_DEL_FLAG() {
		return POAC_DEL_FLAG;
	}

	public void setUI_M_PCG_CODE(String UI_M_PCG_CODE) {
		this.UI_M_PCG_CODE = UI_M_PCG_CODE;
	}

	public String getUI_M_PCG_CODE() {
		return UI_M_PCG_CODE;
	}

	public void setPOAC_RATE_APPLIED_ON(String POAC_RATE_APPLIED_ON) {
		this.POAC_RATE_APPLIED_ON = POAC_RATE_APPLIED_ON;
	}

	public String getPOAC_RATE_APPLIED_ON() {
		return POAC_RATE_APPLIED_ON;
	}

	public void setUI_M_POAC_ASSR_NAME(String UI_M_POAC_ASSR_NAME) {
		this.UI_M_POAC_ASSR_NAME = UI_M_POAC_ASSR_NAME;
	}

	public String getUI_M_POAC_ASSR_NAME() {
		return UI_M_POAC_ASSR_NAME;
	}

	public void setUI_M_POAC_LC_PREM(Double UI_M_POAC_LC_PREM) {
		this.UI_M_POAC_LC_PREM = UI_M_POAC_LC_PREM;
	}

	public Double getUI_M_POAC_LC_PREM() {
		return UI_M_POAC_LC_PREM;
	}

	

	public Integer getPOAC_ORG_PERIOD() {
		return POAC_ORG_PERIOD;
	}

	public void setPOAC_ORG_PERIOD(Integer poac_org_period) {
		POAC_ORG_PERIOD = poac_org_period;
	}

	public Integer getPOAC_ORG_PREM_PAY_YRS() {
		return POAC_ORG_PREM_PAY_YRS;
	}

	public void setPOAC_ORG_PREM_PAY_YRS(Integer poac_org_prem_pay_yrs) {
		POAC_ORG_PREM_PAY_YRS = poac_org_prem_pay_yrs;
	}

	public Integer getPOAC_MED_DAYS() {
		return POAC_MED_DAYS;
	}

	public void setPOAC_MED_DAYS(Integer poac_med_days) {
		POAC_MED_DAYS = poac_med_days;
	}

	public Integer getPOAC_NO_OF_UNIT() {
		return POAC_NO_OF_UNIT;
	}

	public void setPOAC_NO_OF_UNIT(Integer poac_no_of_unit) {
		POAC_NO_OF_UNIT = poac_no_of_unit;
	}

	public void setPOAC_POAD_SYS_ID(Long POAC_POAD_SYS_ID) {
		this.POAC_POAD_SYS_ID = POAC_POAD_SYS_ID;
	}

	public Long getPOAC_POAD_SYS_ID() {
		return POAC_POAD_SYS_ID;
	}

	public void setUI_M_POAC_COVER_DESC_2(String UI_M_POAC_COVER_DESC_2) {
		this.UI_M_POAC_COVER_DESC_2 = UI_M_POAC_COVER_DESC_2;
	}

	public String getUI_M_POAC_COVER_DESC_2() {
		return UI_M_POAC_COVER_DESC_2;
	}

	public void setPOAC_ASSR_CODE(String POAC_ASSR_CODE) {
		this.POAC_ASSR_CODE = POAC_ASSR_CODE;
	}

	public String getPOAC_ASSR_CODE() {
		return POAC_ASSR_CODE;
	}

	public void setPOAC_LC_MED_AMT(Double POAC_LC_MED_AMT) {
		this.POAC_LC_MED_AMT = POAC_LC_MED_AMT;
	}

	public Double getPOAC_LC_MED_AMT() {
		return POAC_LC_MED_AMT;
	}

	public void setPOAC_UPD_DT(Date POAC_UPD_DT) {
		this.POAC_UPD_DT = POAC_UPD_DT;
	}

	public Date getPOAC_UPD_DT() {
		return POAC_UPD_DT;
	}

	public void setUI_M_PROD_CODE(String UI_M_PROD_CODE) {
		this.UI_M_PROD_CODE = UI_M_PROD_CODE;
	}

	public String getUI_M_PROD_CODE() {
		return UI_M_PROD_CODE;
	}

	public void setPOAC_ORG_NO_OF_UNIT(Double POAC_ORG_NO_OF_UNIT) {
		this.POAC_ORG_NO_OF_UNIT = POAC_ORG_NO_OF_UNIT;
	}

	public Double getPOAC_ORG_NO_OF_UNIT() {
		return POAC_ORG_NO_OF_UNIT;
	}

	public void setPOAC_ORG_RATE(Double POAC_ORG_RATE) {
		this.POAC_ORG_RATE = POAC_ORG_RATE;
	}

	public Double getPOAC_ORG_RATE() {
		return POAC_ORG_RATE;
	}

	public void setUI_M_PROD_CODE_1(String UI_M_PROD_CODE_1) {
		this.UI_M_PROD_CODE_1 = UI_M_PROD_CODE_1;
	}

	public String getUI_M_PROD_CODE_1() {
		return UI_M_PROD_CODE_1;
	}

	public void setPOAC_POL_SYS_ID(Long POAC_POL_SYS_ID) {
		this.POAC_POL_SYS_ID = POAC_POL_SYS_ID;
	}

	public Long getPOAC_POL_SYS_ID() {
		return POAC_POL_SYS_ID;
	}

	public Integer getPOAC_PERIOD() {
		return POAC_PERIOD;
	}

	public void setPOAC_PERIOD(Integer poac_period) {
		POAC_PERIOD = poac_period;
	}

	public Integer getPOAC_PREM_PAY_YRS() {
		return POAC_PREM_PAY_YRS;
	}

	public void setPOAC_PREM_PAY_YRS(Integer poac_prem_pay_yrs) {
		POAC_PREM_PAY_YRS = poac_prem_pay_yrs;
	}

}
