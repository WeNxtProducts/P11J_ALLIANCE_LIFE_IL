package com.iii.pel.forms.PILM060_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_WDS_CHARGES_SETUP")
public class PM_IL_WDS_CHARGES_SETUP extends BaseValueBean {

	@Column(name="WCS_FRZ_FLAG")
	private String WCS_FRZ_FLAG;

	private String UI_M_PROD_CODE;

	private String UI_M_PROD_CODE_DESC;
	
	@Column(name="WCS_CHARGE_CODE")
	private String WCS_CHARGE_CODE;

	@Column(name="WCS_SETUP_TYPE")
	private String WCS_SETUP_TYPE;

	@Column(name="WCS_EFF_FM_DT")
	private Date WCS_EFF_FM_DT;

	@Column(name="WCS_EFF_TO_DT")
	private Date WCS_EFF_TO_DT;

	@Column(name="WCS_YRS_FM")
	private Integer WCS_YRS_FM;

	@Column(name="WCS_YRS_TO")
	private Integer WCS_YRS_TO;
	
	@Column(name="WCS_AGE_FM")
	private Integer WCS_AGE_FM ;
	
	@Column(name="WCS_AGE_TO")
	private Integer WCS_AGE_TO;

	@Column(name="WCS_NO_OF_TRANS")
	private Integer WCS_NO_OF_TRANS;

	@Column(name="WCS_RATE")
	private Double WCS_RATE;

	@Column(name="WCS_RATE_PER")
	private Double WCS_RATE_PER;

	/*
	 * 
	 * COMMENTED BY DHINESH ON 06-04-2018 
	 * 
	 * @Column(name="WCS_MIN_VALUE")
	private Integer WCS_MIN_VALUE;

	@Column(name="WCS_MAX_VALUE")
	private Integer WCS_MAX_VALUE;*/
	
	@Column(name="WCS_MIN_VALUE")
	private Double WCS_MIN_VALUE;

	@Column(name="WCS_MAX_VALUE")
	private Double WCS_MAX_VALUE;
	
	
	@Column(name="WCS_CR_UID")
	private String WCS_CR_UID;
	
	@Column(name="WCS_CR_DT")
	private Date WCS_CR_DT;
	
	@Column(name="WCS_UPD_UID")
	private String WCS_UPD_UID;
	
	@Column(name="WCS_UPD_DT")
	private Date WCS_UPD_DT;
	
	
	@Column(name="WCS_PROD_CODE")
	private String WCS_PROD_CODE;

	private String UI_M_CHARGE_CODE_DESC;
	
	private boolean selected;
	
	 private boolean CHECK_CGH_FRZ_FLAG;


	public String getWCS_FRZ_FLAG() {
		if(isCHECK_CGH_FRZ_FLAG() == true) {
			setWCS_FRZ_FLAG("Y");
		} else {
			setWCS_FRZ_FLAG("N");
		}
		return WCS_FRZ_FLAG;
	}

	public void setWCS_FRZ_FLAG(String WCS_FRZ_FLAG) {
		if("Y".equalsIgnoreCase(WCS_FRZ_FLAG)) {
			CHECK_CGH_FRZ_FLAG = true;
		} else {
			CHECK_CGH_FRZ_FLAG = false;
		}
		this.WCS_FRZ_FLAG = WCS_FRZ_FLAG;
	    
	}

	public String getUI_M_PROD_CODE() {
		return UI_M_PROD_CODE;
	}

	public void setUI_M_PROD_CODE(String UI_M_PROD_CODE) {
		this.UI_M_PROD_CODE = UI_M_PROD_CODE;
	}

	public String getUI_M_PROD_CODE_DESC() {
		return UI_M_PROD_CODE_DESC;
	}

	public void setUI_M_PROD_CODE_DESC(String UI_M_PROD_CODE_DESC) {
		this.UI_M_PROD_CODE_DESC = UI_M_PROD_CODE_DESC;
	}

	public String getWCS_CHARGE_CODE() {
		return WCS_CHARGE_CODE;
	}

	public void setWCS_CHARGE_CODE(String WCS_CHARGE_CODE) {
		this.WCS_CHARGE_CODE = WCS_CHARGE_CODE;
	}

	public String getWCS_SETUP_TYPE() {
		return WCS_SETUP_TYPE;
	}

	public void setWCS_SETUP_TYPE(String WCS_SETUP_TYPE) {
		this.WCS_SETUP_TYPE = WCS_SETUP_TYPE;
	}

	public Date getWCS_EFF_FM_DT() {
		 return WCS_EFF_FM_DT;
	}

	public void setWCS_EFF_FM_DT(Date WCS_EFF_FM_DT) {
		this.WCS_EFF_FM_DT = WCS_EFF_FM_DT;
	}

	public Date getWCS_EFF_TO_DT() {
		 return WCS_EFF_TO_DT;
	}

	public void setWCS_EFF_TO_DT(Date WCS_EFF_TO_DT) {
		this.WCS_EFF_TO_DT = WCS_EFF_TO_DT;
	}

	

	public Integer getWCS_YRS_FM() {
		return WCS_YRS_FM;
	}

	public void setWCS_YRS_FM(Integer wcs_yrs_fm) {
		WCS_YRS_FM = wcs_yrs_fm;
	}

	public Integer getWCS_YRS_TO() {
		return WCS_YRS_TO;
	}

	public void setWCS_YRS_TO(Integer wcs_yrs_to) {
		WCS_YRS_TO = wcs_yrs_to;
	}

	public Integer getWCS_NO_OF_TRANS() {
		return WCS_NO_OF_TRANS;
	}

	public void setWCS_NO_OF_TRANS(Integer WCS_NO_OF_TRANS) {
		this.WCS_NO_OF_TRANS = WCS_NO_OF_TRANS;
	}

	public Double getWCS_RATE() {
		return WCS_RATE;
	}

	public void setWCS_RATE(Double WCS_RATE) {
		this.WCS_RATE = WCS_RATE;
	}

	public Double getWCS_RATE_PER() {
		return WCS_RATE_PER;
	}

	public void setWCS_RATE_PER(Double WCS_RATE_PER) {
		this.WCS_RATE_PER = WCS_RATE_PER;
	}
	
	public Double getWCS_MIN_VALUE() {
		return WCS_MIN_VALUE;
	}

	public void setWCS_MIN_VALUE(Double wCS_MIN_VALUE) {
		WCS_MIN_VALUE = wCS_MIN_VALUE;
	}

	public Double getWCS_MAX_VALUE() {
		return WCS_MAX_VALUE;
	}

	public void setWCS_MAX_VALUE(Double wCS_MAX_VALUE) {
		WCS_MAX_VALUE = wCS_MAX_VALUE;
	}

	public String getUI_M_CHARGE_CODE_DESC() {
		return UI_M_CHARGE_CODE_DESC;
	}

	public void setUI_M_CHARGE_CODE_DESC(String UI_M_CHARGE_CODE_DESC) {
		this.UI_M_CHARGE_CODE_DESC = UI_M_CHARGE_CODE_DESC;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getWCS_PROD_CODE() {
		return WCS_PROD_CODE;
	}

	public void setWCS_PROD_CODE(String wcs_prod_code) {
		WCS_PROD_CODE = wcs_prod_code;
	}

	public String getWCS_CR_UID() {
		return WCS_CR_UID;
	}

	public void setWCS_CR_UID(String wcs_cr_uid) {
		WCS_CR_UID = wcs_cr_uid;
	}

	public Date getWCS_CR_DT() {
		return WCS_CR_DT;
	}

	public void setWCS_CR_DT(Date wcs_cr_dt) {
		WCS_CR_DT = wcs_cr_dt;
	}

	public String getWCS_UPD_UID() {
		return WCS_UPD_UID;
	}

	public void setWCS_UPD_UID(String wcs_upd_uid) {
		WCS_UPD_UID = wcs_upd_uid;
	}

	public Date getWCS_UPD_DT() {
		return WCS_UPD_DT;
	}

	public void setWCS_UPD_DT(Date wcs_upd_dt) {
		WCS_UPD_DT = wcs_upd_dt;
	}

	public boolean isCHECK_CGH_FRZ_FLAG() {
		return CHECK_CGH_FRZ_FLAG;
	}

	public void setCHECK_CGH_FRZ_FLAG(boolean check_cgh_frz_flag) {
		CHECK_CGH_FRZ_FLAG = check_cgh_frz_flag;
	}

	public Integer getWCS_AGE_FM() {
		return WCS_AGE_FM;
	}

	public void setWCS_AGE_FM(Integer wcs_age_fm) {
		WCS_AGE_FM = wcs_age_fm;
	}

	public Integer getWCS_AGE_TO() {
		return WCS_AGE_TO;
	}

	public void setWCS_AGE_TO(Integer wcs_age_to) {
		WCS_AGE_TO = wcs_age_to;
	}



	@Column(name="WCS_APPLIED_ON")
	private String WCS_APPLIED_ON;


	public String getWCS_APPLIED_ON() {
		return WCS_APPLIED_ON;
	}

	public void setWCS_APPLIED_ON(String wCS_APPLIED_ON) {
		WCS_APPLIED_ON = wCS_APPLIED_ON;
	}
	
	/*Newly added by pidugu raj dt: 12-10-2018 as suggested by srinivas reddy and sivaraman for surrender value*/
	@Column(name="WCS_FORMULA_CODE")
	private String WCS_FORMULA_CODE;
	
	public String getWCS_FORMULA_CODE() {
		return WCS_FORMULA_CODE;
	}

	public void setWCS_FORMULA_CODE(String wCS_FORMULA_CODE) {
		WCS_FORMULA_CODE = wCS_FORMULA_CODE;
	}
	
	public String getUI_M_FORMULA_CODE_DESC() {
		return UI_M_FORMULA_CODE_DESC;
	}

	public void setUI_M_FORMULA_CODE_DESC(String uI_M_FORMULA_CODE_DESC) {
		UI_M_FORMULA_CODE_DESC = uI_M_FORMULA_CODE_DESC;
	}



	private String UI_M_FORMULA_CODE_DESC;

	/*End Newly added by pidugu raj dt: 12-10-2018 as suggested by srinivas reddy and sivaraman for surrender value*/


	
	
	
}
