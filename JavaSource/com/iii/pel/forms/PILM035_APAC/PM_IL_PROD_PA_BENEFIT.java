package com.iii.pel.forms.PILM035_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_IL_PROD_PA_BENEFIT")
public class PM_IL_PROD_PA_BENEFIT extends BaseValueBean {
	
	@Column(name="PPB_COVER_CODE")
	private String PPB_COVER_CODE;
	
	@Column(name="PPB_PROD_CODE")
	private String PPB_PROD_CODE;
	
	@Column(name="PPB_BUSN_TYPE")
	private String PPB_BUSN_TYPE;
	
	@Column(name="PPB_ACNT_YEAR")
	private Integer PPB_ACNT_YEAR;
	
	@Column(name="PPB_MORT_CODE")
	private String PPB_MORT_CODE;
	
	@Column(name="PPB_CR_DATE")
	private Date PPB_CR_DATE;
	
	@Column(name="PPB_CR_UID")
	private String PPB_CR_UID;
	
	@Column(name="PPB_UPD_DATE")
	private Date PPB_UPD_DATE;
	
	@Column(name="PPB_UPD_UID")
	private String PPB_UPD_UID;
	
	@Column(name="PPB_BEN_CALC_YN")
	private String PPB_BEN_CALC_YN;

	public String getPPB_COVER_CODE() {
		return PPB_COVER_CODE;
	}

	public void setPPB_COVER_CODE(String ppb_cover_code) {
		PPB_COVER_CODE = ppb_cover_code;
	}

	public String getPPB_PROD_CODE() {
		return PPB_PROD_CODE;
	}

	public void setPPB_PROD_CODE(String ppb_prod_code) {
		PPB_PROD_CODE = ppb_prod_code;
	}

	public String getPPB_BUSN_TYPE() {
		return PPB_BUSN_TYPE;
	}

	public void setPPB_BUSN_TYPE(String ppb_busn_type) {
		PPB_BUSN_TYPE = ppb_busn_type;
	}

	public Integer getPPB_ACNT_YEAR() {
		return PPB_ACNT_YEAR;
	}

	public void setPPB_ACNT_YEAR(Integer ppb_acnt_year) {
		PPB_ACNT_YEAR = ppb_acnt_year;
	}

	public String getPPB_MORT_CODE() {
		return PPB_MORT_CODE;
	}

	public void setPPB_MORT_CODE(String ppb_mort_code) {
		PPB_MORT_CODE = ppb_mort_code;
	}

	public Date getPPB_CR_DATE() {
		return PPB_CR_DATE;
	}

	public void setPPB_CR_DATE(Date ppb_cr_date) {
		PPB_CR_DATE = ppb_cr_date;
	}

	public String getPPB_CR_UID() {
		return PPB_CR_UID;
	}

	public void setPPB_CR_UID(String ppb_cr_uid) {
		PPB_CR_UID = ppb_cr_uid;
	}

	public Date getPPB_UPD_DATE() {
		return PPB_UPD_DATE;
	}

	public void setPPB_UPD_DATE(Date ppb_upd_date) {
		PPB_UPD_DATE = ppb_upd_date;
	}

	public String getPPB_UPD_UID() {
		return PPB_UPD_UID;
	}

	public void setPPB_UPD_UID(String ppb_upd_uid) {
		PPB_UPD_UID = ppb_upd_uid;
	}

	public String getPPB_BEN_CALC_YN() {
		return PPB_BEN_CALC_YN;
	}

	public void setPPB_BEN_CALC_YN(String ppb_ben_calc_yn) {
		PPB_BEN_CALC_YN = ppb_ben_calc_yn;
	}
	
	
	
	
}
