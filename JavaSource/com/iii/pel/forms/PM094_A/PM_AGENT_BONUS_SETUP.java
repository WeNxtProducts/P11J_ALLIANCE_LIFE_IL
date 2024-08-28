package com.iii.pel.forms.PM094_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_AGENT_BONUS_SETUP")
public class PM_AGENT_BONUS_SETUP extends BaseValueBean {

	@Column(name="ABS_CODE")
	private String ABS_CODE;

	@Column(name="ABS_DESC")
	private String ABS_DESC;

	@Column(name="ABS_SHORT_DESC")
	private String ABS_SHORT_DESC;

	@Column(name="ABS_LONG_DESC")
	private String ABS_LONG_DESC;

	@Column(name="ABS_BONUS_TYPE")
	private String ABS_BONUS_TYPE;

	private String UI_M_ABS_BONUS_TYPE_DESC;

	@Column(name="ABS_YRS_FM")
	private Integer ABS_YRS_FM;

	@Column(name="ABS_YRS_TO")
	private Integer ABS_YRS_TO;

	@Column(name="ABS_BONUS_FREQ")
	private String ABS_BONUS_FREQ;

	@Column(name="ABS_PRORATA_YN")
	private String ABS_PRORATA_YN;

	@Column(name="ABS_POL_RENEWAL_YR")
	private Double ABS_POL_RENEWAL_YR;

	@Column(name="ABS_EFF_FM_DT")
	private Date ABS_EFF_FM_DT;

	@Column(name="ABS_EFF_TO_DT")
	private Date ABS_EFF_TO_DT;

	@Column(name="ABS_TAXABLE_YN")
	private String ABS_TAXABLE_YN;

	@Column(name="ABS_BL_DESC")
	private String ABS_BL_DESC;

	@Column(name="ABS_BL_SHORT_DESC")
	private String ABS_BL_SHORT_DESC;

	@Column(name="ABS_BL_LONG_DESC")
	private String ABS_BL_LONG_DESC;

	@Column(name="ABS_CR_DT")
	private Date ABS_CR_DT;
	
	@Column(name="ABS_CR_UID")
	private String ABS_CR_UID;
	
	@Column(name="ABS_UPD_DT")
	private Date ABS_UPD_DT;
	
	@Column(name="ABS_UPD_UID")
	private String ABS_UPD_UID;

	public String getABS_CODE() {
		return ABS_CODE;
	}

	public void setABS_CODE(String ABS_CODE) {
		this.ABS_CODE = ABS_CODE;
	}

	public String getABS_DESC() {
		return ABS_DESC;
	}

	public void setABS_DESC(String ABS_DESC) {
		this.ABS_DESC = ABS_DESC;
	}

	public String getABS_SHORT_DESC() {
		return ABS_SHORT_DESC;
	}

	public void setABS_SHORT_DESC(String ABS_SHORT_DESC) {
		this.ABS_SHORT_DESC = ABS_SHORT_DESC;
	}

	public String getABS_LONG_DESC() {
		return ABS_LONG_DESC;
	}

	public void setABS_LONG_DESC(String ABS_LONG_DESC) {
		this.ABS_LONG_DESC = ABS_LONG_DESC;
	}

	public String getABS_BONUS_TYPE() {
		return ABS_BONUS_TYPE;
	}

	public void setABS_BONUS_TYPE(String ABS_BONUS_TYPE) {
		this.ABS_BONUS_TYPE = ABS_BONUS_TYPE;
	}

	public String getUI_M_ABS_BONUS_TYPE_DESC() {
		return UI_M_ABS_BONUS_TYPE_DESC;
	}

	public void setUI_M_ABS_BONUS_TYPE_DESC(String UI_M_ABS_BONUS_TYPE_DESC) {
		this.UI_M_ABS_BONUS_TYPE_DESC = UI_M_ABS_BONUS_TYPE_DESC;
	}

	public Integer getABS_YRS_FM() {
		return ABS_YRS_FM;
	}

	public void setABS_YRS_FM(Integer abs_yrs_fm) {
		ABS_YRS_FM = abs_yrs_fm;
	}

	public Integer getABS_YRS_TO() {
		return ABS_YRS_TO;
	}

	public void setABS_YRS_TO(Integer abs_yrs_to) {
		ABS_YRS_TO = abs_yrs_to;
	}

	public String getABS_BONUS_FREQ() {
		return ABS_BONUS_FREQ;
	}

	public void setABS_BONUS_FREQ(String ABS_BONUS_FREQ) {
		this.ABS_BONUS_FREQ = ABS_BONUS_FREQ;
	}

	public String getABS_PRORATA_YN() {
		return ABS_PRORATA_YN;
	}

	public void setABS_PRORATA_YN(String ABS_PRORATA_YN) {
		this.ABS_PRORATA_YN = ABS_PRORATA_YN;
	}

	public Double getABS_POL_RENEWAL_YR() {
		return ABS_POL_RENEWAL_YR;
	}

	public void setABS_POL_RENEWAL_YR(Double ABS_POL_RENEWAL_YR) {
		this.ABS_POL_RENEWAL_YR = ABS_POL_RENEWAL_YR;
	}

	public Date getABS_EFF_FM_DT() {
		 return ABS_EFF_FM_DT;
	}

	public void setABS_EFF_FM_DT(Date ABS_EFF_FM_DT) {
		this.ABS_EFF_FM_DT = ABS_EFF_FM_DT;
	}

	public Date getABS_EFF_TO_DT() {
		 return ABS_EFF_TO_DT;
	}

	public void setABS_EFF_TO_DT(Date ABS_EFF_TO_DT) {
		this.ABS_EFF_TO_DT = ABS_EFF_TO_DT;
	}

	public String getABS_TAXABLE_YN() {
		return ABS_TAXABLE_YN;
	}

	public void setABS_TAXABLE_YN(String ABS_TAXABLE_YN) {
		this.ABS_TAXABLE_YN = ABS_TAXABLE_YN;
	}

	public String getABS_BL_DESC() {
		return ABS_BL_DESC;
	}

	public void setABS_BL_DESC(String ABS_BL_DESC) {
		this.ABS_BL_DESC = ABS_BL_DESC;
	}

	public String getABS_BL_SHORT_DESC() {
		return ABS_BL_SHORT_DESC;
	}

	public void setABS_BL_SHORT_DESC(String ABS_BL_SHORT_DESC) {
		this.ABS_BL_SHORT_DESC = ABS_BL_SHORT_DESC;
	}

	public String getABS_BL_LONG_DESC() {
		return ABS_BL_LONG_DESC;
	}

	public void setABS_BL_LONG_DESC(String ABS_BL_LONG_DESC) {
		this.ABS_BL_LONG_DESC = ABS_BL_LONG_DESC;
	}

	public Date getABS_CR_DT() {
		return ABS_CR_DT;
	}

	public void setABS_CR_DT(Date abs_cr_dt) {
		ABS_CR_DT = abs_cr_dt;
	}

	public String getABS_CR_UID() {
		return ABS_CR_UID;
	}

	public void setABS_CR_UID(String abs_cr_uid) {
		ABS_CR_UID = abs_cr_uid;
	}

	public Date getABS_UPD_DT() {
		return ABS_UPD_DT;
	}

	public void setABS_UPD_DT(Date abs_upd_dt) {
		ABS_UPD_DT = abs_upd_dt;
	}

	public String getABS_UPD_UID() {
		return ABS_UPD_UID;
	}

	public void setABS_UPD_UID(String abs_upd_uid) {
		ABS_UPD_UID = abs_upd_uid;
	}

}
