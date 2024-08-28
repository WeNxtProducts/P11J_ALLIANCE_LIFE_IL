package com.iii.pel.forms.PILM203;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_CVR_BNF_LINK")
public class PM_IL_CVR_BNF_LINK extends BaseValueBean {

	@Column(name="CBL_FRZ_FLAG")
	private String CBL_FRZ_FLAG;
	
	private boolean BOOLEAN_CBL_FRZ_FLAG;

	@Column(name="CBL_BNF_CODE")
	private String CBL_BNF_CODE;

	private String UI_M_CBL_BNF_DESC;

	@Column(name="CBL_LIMIT_TYP")
	private String CBL_LIMIT_TYP;

	@Column(name="CBL_PER_DAY_LC_LIMIT")
	private Double CBL_PER_DAY_LC_LIMIT;
	
	private boolean CBL_PER_DAY_LC_LIMIT_DISABLE;
	
	private boolean CBL_PER_DAY_LC_LIMIT_REQUIRED;

	@Column(name="CBL_LIMIT_DAYS")
	private Double CBL_LIMIT_DAYS;
	
	private boolean CBL_LIMIT_DAYS_DISABLE;
	
	private boolean CBL_LIMIT_DAYS_REQUIRED;	
	
	
	@Column(name="CBL_LIMIT_LC_AMT")
	private Double CBL_LIMIT_LC_AMT;
	
	private boolean CBL_LIMIT_LC_AMT_DISABLE;
	
	private boolean CBL_LIMIT_LC_AMT_REQUIRED;	

	
	@Column(name="ROWID")
	private String ROWID;
	
	@Column(name="CBL_UPD_UID")
	private String CBL_UPD_UID;
	
	@Column(name="CBL_UPD_DT")
	private Date CBL_UPD_DT;
	
	@Column(name="CBL_CR_UID")
	private String CBL_CR_UID;
	
	@Column(name="CBL_CR_DT")
	private Date CBL_CR_DT;
	
	@Column(name="CBL_COVER_CODE")
	private String CBL_COVER_CODE;
	
	private String selectedBenefitCode;

	private boolean checkBoxFirst;
	
	public boolean isCheckBoxFirst() {
		return checkBoxFirst;
	}

	public void setCheckBoxFirst(boolean checkBoxFirst) {
		this.checkBoxFirst = checkBoxFirst;
	}

	public String getCBL_FRZ_FLAG() {
		
		if(isBOOLEAN_CBL_FRZ_FLAG() == true) {
			setCBL_FRZ_FLAG("Y");
		} else {
			setCBL_FRZ_FLAG("N");
		}
		return CBL_FRZ_FLAG;
	}

	public void setCBL_FRZ_FLAG(String CBL_FRZ_FLAG) {
		
		if("Y".equalsIgnoreCase(CBL_FRZ_FLAG)) {
			BOOLEAN_CBL_FRZ_FLAG = true;
		} else {
			BOOLEAN_CBL_FRZ_FLAG = false;
		}
		this.CBL_FRZ_FLAG = CBL_FRZ_FLAG;
	}

	public String getCBL_BNF_CODE() {
		return CBL_BNF_CODE;
	}

	public void setCBL_BNF_CODE(String CBL_BNF_CODE) {
		this.CBL_BNF_CODE = CBL_BNF_CODE;
	}

	public String getUI_M_CBL_BNF_DESC() {
		return UI_M_CBL_BNF_DESC;
	}

	public void setUI_M_CBL_BNF_DESC(String UI_M_CBL_BNF_DESC) {
		this.UI_M_CBL_BNF_DESC = UI_M_CBL_BNF_DESC;
	}

	public String getCBL_LIMIT_TYP() {
		return CBL_LIMIT_TYP;
	}

	public void setCBL_LIMIT_TYP(String CBL_LIMIT_TYP) {
		this.CBL_LIMIT_TYP = CBL_LIMIT_TYP;
	}

	public Double getCBL_PER_DAY_LC_LIMIT() {
		return CBL_PER_DAY_LC_LIMIT;
	}

	public void setCBL_PER_DAY_LC_LIMIT(Double CBL_PER_DAY_LC_LIMIT) {
		this.CBL_PER_DAY_LC_LIMIT = CBL_PER_DAY_LC_LIMIT;
	}

	public Double getCBL_LIMIT_DAYS() {
		return CBL_LIMIT_DAYS;
	}

	public void setCBL_LIMIT_DAYS(Double CBL_LIMIT_DAYS) {
		this.CBL_LIMIT_DAYS = CBL_LIMIT_DAYS;
	}

	public Double getCBL_LIMIT_LC_AMT() {
		return CBL_LIMIT_LC_AMT;
	}

	public void setCBL_LIMIT_LC_AMT(Double CBL_LIMIT_LC_AMT) {
		this.CBL_LIMIT_LC_AMT = CBL_LIMIT_LC_AMT;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public boolean isBOOLEAN_CBL_FRZ_FLAG() {
		return BOOLEAN_CBL_FRZ_FLAG;
	}
	

	public void setBOOLEAN_CBL_FRZ_FLAG(boolean boolean_cbl_frz_flag) {
		BOOLEAN_CBL_FRZ_FLAG = boolean_cbl_frz_flag;
	}

	public String getCBL_UPD_UID() {
		return CBL_UPD_UID;
	}

	public void setCBL_UPD_UID(String cbl_upd_uid) {
		CBL_UPD_UID = cbl_upd_uid;
	}

	public Date getCBL_UPD_DT() {
		return CBL_UPD_DT;
	}

	public void setCBL_UPD_DT(Date cbl_upd_dt) {
		CBL_UPD_DT = cbl_upd_dt;
	}

	public String getCBL_COVER_CODE() {
		return CBL_COVER_CODE;
	}

	public void setCBL_COVER_CODE(String cbl_cover_code) {
		CBL_COVER_CODE = cbl_cover_code;
	}

	public String getCBL_CR_UID() {
		return CBL_CR_UID;
	}

	public void setCBL_CR_UID(String cbl_cr_uid) {
		CBL_CR_UID = cbl_cr_uid;
	}

	public Date getCBL_CR_DT() {
		return CBL_CR_DT;
	}

	public void setCBL_CR_DT(Date cbl_cr_dt) {
		CBL_CR_DT = cbl_cr_dt;
	}

	public boolean isCBL_PER_DAY_LC_LIMIT_DISABLE() {
		return CBL_PER_DAY_LC_LIMIT_DISABLE;
	}

	public void setCBL_PER_DAY_LC_LIMIT_DISABLE(boolean cbl_per_day_lc_limit_disable) {
		CBL_PER_DAY_LC_LIMIT_DISABLE = cbl_per_day_lc_limit_disable;
	}

	public boolean isCBL_PER_DAY_LC_LIMIT_REQUIRED() {
		return CBL_PER_DAY_LC_LIMIT_REQUIRED;
	}

	public void setCBL_PER_DAY_LC_LIMIT_REQUIRED(
			boolean cbl_per_day_lc_limit_required) {
		CBL_PER_DAY_LC_LIMIT_REQUIRED = cbl_per_day_lc_limit_required;
	}

	public boolean isCBL_LIMIT_DAYS_DISABLE() {
		return CBL_LIMIT_DAYS_DISABLE;
	}

	public void setCBL_LIMIT_DAYS_DISABLE(boolean cbl_limit_days_disable) {
		CBL_LIMIT_DAYS_DISABLE = cbl_limit_days_disable;
	}

	public boolean isCBL_LIMIT_DAYS_REQUIRED() {
		return CBL_LIMIT_DAYS_REQUIRED;
	}

	public void setCBL_LIMIT_DAYS_REQUIRED(boolean cbl_limit_days_required) {
		CBL_LIMIT_DAYS_REQUIRED = cbl_limit_days_required;
	}

	public boolean isCBL_LIMIT_LC_AMT_DISABLE() {
		return CBL_LIMIT_LC_AMT_DISABLE;
	}

	public void setCBL_LIMIT_LC_AMT_DISABLE(boolean cbl_limit_lc_amt_disable) {
		CBL_LIMIT_LC_AMT_DISABLE = cbl_limit_lc_amt_disable;
	}

	public boolean isCBL_LIMIT_LC_AMT_REQUIRED() {
		return CBL_LIMIT_LC_AMT_REQUIRED;
	}

	public void setCBL_LIMIT_LC_AMT_REQUIRED(boolean cbl_limit_lc_amt_required) {
		CBL_LIMIT_LC_AMT_REQUIRED = cbl_limit_lc_amt_required;
	}

	public String getSelectedBenefitCode() {
		return selectedBenefitCode;
	}

	public void setSelectedBenefitCode(String selectedBenefitCode) {
		this.selectedBenefitCode = selectedBenefitCode;
	}
}