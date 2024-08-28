package com.iii.pel.forms.PILM203;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_CVR_SBNF_LINK")
public class PM_IL_CVR_SBNF_LINK extends BaseValueBean {

	@Column(name="BSBL_FRZ_FLAG")
	private String BSBL_FRZ_FLAG;

	@Column(name="BSBL_SBNF_CODE")
	private String BSBL_SBNF_CODE;
	
	private boolean freezSelect;

	private String UI_M_BSBL_BNF_DESC;

	@Column(name="BSBL_LIMIT_TYP")
	private String BSBL_LIMIT_TYP;

	@Column(name="BSBL_PER_DAY_LC_LIMIT")
	private Double BSBL_PER_DAY_LC_LIMIT;
	
	private boolean BSBL_PER_DAY_LC_LIMIT_DISABLE;
	
	private boolean BSBL_PER_DAY_LC_LIMIT_REQUIRED;

	@Column(name="BSBL_LIMIT_DAYS")
	private Double BSBL_LIMIT_DAYS;
	
	private boolean BSBL_LIMIT_DAYS_DISABLE;
	
	private boolean BSBL_LIMIT_DAYS_REQUIRED;	

	@Column(name="BSBL_LIMIT_LC_AMT")
	private Double BSBL_LIMIT_LC_AMT;
	
	private boolean BSBL_LIMIT_LC_AMT_DISABLE;
	
	private boolean BSBL_LIMIT_LC_AMT_REQUIRED;
	
	@Column(name="BSBL_CR_DT")
	private Date BSBL_CR_DT;
	
	@Column(name="BSBL_CR_UID")
	private String BSBL_CR_UID;
	
	@Column(name="BSBL_UPD_DT")
	private Date BSBL_UPD_DT;
	
	@Column(name="BSBL_UPD_UID")
	private String BSBL_UPD_UID;
	
	@Column(name="BSBL_COVER_CODE")
	private String BSBL_COVER_CODE;
	
	@Column(name="BSBL_BNF_CODE")
	private String BSBL_BNF_CODE;	

	private String selectedSubBenefitCode;
	

	
	private boolean CHECK_BOX;


	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public Date getBSBL_UPD_DT() {
		return BSBL_UPD_DT;
	}

	public void setBSBL_UPD_DT(Date bsbl_upd_dt) {
		BSBL_UPD_DT = bsbl_upd_dt;
	}

	public String getBSBL_UPD_UID() {
		return BSBL_UPD_UID;
	}

	public void setBSBL_UPD_UID(String bsbl_upd_uid) {
		BSBL_UPD_UID = bsbl_upd_uid;
	}

	public String getBSBL_FRZ_FLAG() {
		if(isFreezSelect() == true) {
			setBSBL_FRZ_FLAG("Y");
		} else {
			setBSBL_FRZ_FLAG("N");
		}
		return BSBL_FRZ_FLAG;
	}

	public void setBSBL_FRZ_FLAG(String BSBL_FRZ_FLAG) {
		if("Y".equalsIgnoreCase(BSBL_FRZ_FLAG)) {
			freezSelect = true;
		} else {
			freezSelect = false;
		}
		this.BSBL_FRZ_FLAG = BSBL_FRZ_FLAG;
	}

	public String getBSBL_SBNF_CODE() {
		return BSBL_SBNF_CODE;
	}

	public void setBSBL_SBNF_CODE(String BSBL_SBNF_CODE) {
		this.BSBL_SBNF_CODE = BSBL_SBNF_CODE;
	}

	public String getUI_M_BSBL_BNF_DESC() {
		return UI_M_BSBL_BNF_DESC;
	}

	public void setUI_M_BSBL_BNF_DESC(String UI_M_BSBL_BNF_DESC) {
		this.UI_M_BSBL_BNF_DESC = UI_M_BSBL_BNF_DESC;
	}

	public String getBSBL_LIMIT_TYP() {
		return BSBL_LIMIT_TYP;
	}

	public void setBSBL_LIMIT_TYP(String BSBL_LIMIT_TYP) {
		this.BSBL_LIMIT_TYP = BSBL_LIMIT_TYP;
	}

	public Double getBSBL_PER_DAY_LC_LIMIT() {
		return BSBL_PER_DAY_LC_LIMIT;
	}

	public void setBSBL_PER_DAY_LC_LIMIT(Double BSBL_PER_DAY_LC_LIMIT) {
		this.BSBL_PER_DAY_LC_LIMIT = BSBL_PER_DAY_LC_LIMIT;
	}

	public Double getBSBL_LIMIT_DAYS() {
		return BSBL_LIMIT_DAYS;
	}

	public void setBSBL_LIMIT_DAYS(Double BSBL_LIMIT_DAYS) {
		this.BSBL_LIMIT_DAYS = BSBL_LIMIT_DAYS;
	}

	public Double getBSBL_LIMIT_LC_AMT() {
		return BSBL_LIMIT_LC_AMT;
	}

	public void setBSBL_LIMIT_LC_AMT(Double BSBL_LIMIT_LC_AMT) {
		this.BSBL_LIMIT_LC_AMT = BSBL_LIMIT_LC_AMT;
	}

	public Date getBSBL_CR_DT() {
		return BSBL_CR_DT;
	}

	public void setBSBL_CR_DT(Date bsbl_cr_dt) {
		BSBL_CR_DT = bsbl_cr_dt;
	}

	public String getBSBL_CR_UID() {
		return BSBL_CR_UID;
	}

	public void setBSBL_CR_UID(String bsbl_cr_uid) {
		BSBL_CR_UID = bsbl_cr_uid;
	}

	public String getBSBL_COVER_CODE() {
		return BSBL_COVER_CODE;
	}

	public void setBSBL_COVER_CODE(String bsbl_cover_code) {
		BSBL_COVER_CODE = bsbl_cover_code;
	}

	public String getBSBL_BNF_CODE() {
		return BSBL_BNF_CODE;
	}

	public void setBSBL_BNF_CODE(String bsbl_bnf_code) {
		BSBL_BNF_CODE = bsbl_bnf_code;
	}

	public boolean isFreezSelect() {
		return freezSelect;
	}

	public void setFreezSelect(boolean freezSelect) {
		this.freezSelect = freezSelect;
	}

	public boolean isBSBL_PER_DAY_LC_LIMIT_DISABLE() {
		return BSBL_PER_DAY_LC_LIMIT_DISABLE;
	}

	public void setBSBL_PER_DAY_LC_LIMIT_DISABLE(boolean bsbl_per_day_lc_limit_disable) {
		BSBL_PER_DAY_LC_LIMIT_DISABLE = bsbl_per_day_lc_limit_disable;
	}

	public boolean isBSBL_LIMIT_DAYS_DISABLE() {
		return BSBL_LIMIT_DAYS_DISABLE;
	}

	public void setBSBL_LIMIT_DAYS_DISABLE(boolean bsbl_limit_days_disable) {
		BSBL_LIMIT_DAYS_DISABLE = bsbl_limit_days_disable;
	}

	public boolean isBSBL_LIMIT_LC_AMT_DISABLE() {
		return BSBL_LIMIT_LC_AMT_DISABLE;
	}

	public void setBSBL_LIMIT_LC_AMT_DISABLE(boolean bsbl_limit_lc_amt_disable) {
		BSBL_LIMIT_LC_AMT_DISABLE = bsbl_limit_lc_amt_disable;
	}

	public boolean isBSBL_PER_DAY_LC_LIMIT_REQUIRED() {
		return BSBL_PER_DAY_LC_LIMIT_REQUIRED;
	}

	public void setBSBL_PER_DAY_LC_LIMIT_REQUIRED(
			boolean bsbl_per_day_lc_limit_required) {
		BSBL_PER_DAY_LC_LIMIT_REQUIRED = bsbl_per_day_lc_limit_required;
	}

	public boolean isBSBL_LIMIT_DAYS_REQUIRED() {
		return BSBL_LIMIT_DAYS_REQUIRED;
	}

	public void setBSBL_LIMIT_DAYS_REQUIRED(boolean bsbl_limit_days_required) {
		BSBL_LIMIT_DAYS_REQUIRED = bsbl_limit_days_required;
	}

	public boolean isBSBL_LIMIT_LC_AMT_REQUIRED() {
		return BSBL_LIMIT_LC_AMT_REQUIRED;
	}

	public void setBSBL_LIMIT_LC_AMT_REQUIRED(boolean bsbl_limit_lc_amt_required) {
		BSBL_LIMIT_LC_AMT_REQUIRED = bsbl_limit_lc_amt_required;
	}

	public String getSelectedSubBenefitCode() {
		return selectedSubBenefitCode;
	}

	public void setSelectedSubBenefitCode(String selectedSubBenefitCode) {
		this.selectedSubBenefitCode = selectedSubBenefitCode;
	}
}