package com.iii.pel.forms.PILM035_APAC;
import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_PROD_WD_PARAM_HDR")
public class PM_IL_PROD_WD_PARAM_HDR extends BaseValueBean{

	@Column(name="PWPH_SYS_ID")
	private Integer PWPH_SYS_ID;

	@Column(name="PWPH_PROD_CODE")
	private String PWPH_PROD_CODE;

	@Column(name="PWPH_WITHDRAW_MIN_YRS")
	private Integer PWPH_WITHDRAW_MIN_YRS;

	@Column(name="PWPH_WITHDRAW_INTERVAL")
	private Integer PWPH_WITHDRAW_INTERVAL;

	@Column(name="PWPH_MAX_NO_WITHDRAW")
	private Integer PWPH_MAX_NO_WITHDRAW;

	@Column(name="PWPH_CR_UID")
	private String PWPH_CR_UID;

	@Column(name="PWPH_CR_DT")
	private Date PWPH_CR_DT;

	@Column(name="PWPH_UPD_UID")
	private String PWPH_UPD_UID;

	@Column(name="PWPH_UPD_DT")
	private Date PWPH_UPD_DT;

	@Column(name="PWPH_TOPUP_MIN_YRS")
	private Integer PWPH_TOPUP_MIN_YRS;



	public Integer getPWPH_SYS_ID() {
		return PWPH_SYS_ID;
	}

	public void setPWPH_SYS_ID(Integer pwph_sys_id) {
		PWPH_SYS_ID = pwph_sys_id;
	}

	public String getPWPH_PROD_CODE() {
		 return PWPH_PROD_CODE;
	}

	public void setPWPH_PROD_CODE(String PWPH_PROD_CODE) {
		this.PWPH_PROD_CODE = PWPH_PROD_CODE;
	}

	public Integer getPWPH_WITHDRAW_MIN_YRS() {
		return PWPH_WITHDRAW_MIN_YRS;
	}

	public void setPWPH_WITHDRAW_MIN_YRS(Integer pwph_withdraw_min_yrs) {
		PWPH_WITHDRAW_MIN_YRS = pwph_withdraw_min_yrs;
	}


	public Integer getPWPH_WITHDRAW_INTERVAL() {
		return PWPH_WITHDRAW_INTERVAL;
	}

	public void setPWPH_WITHDRAW_INTERVAL(Integer pwph_withdraw_interval) {
		PWPH_WITHDRAW_INTERVAL = pwph_withdraw_interval;
	}

	public Integer getPWPH_MAX_NO_WITHDRAW() {
		return PWPH_MAX_NO_WITHDRAW;
	}

	public void setPWPH_MAX_NO_WITHDRAW(Integer pwph_max_no_withdraw) {
		PWPH_MAX_NO_WITHDRAW = pwph_max_no_withdraw;
	}

	public String getPWPH_CR_UID() {
		 return PWPH_CR_UID;
	}

	public void setPWPH_CR_UID(String PWPH_CR_UID) {
		this.PWPH_CR_UID = PWPH_CR_UID;
	}

	public Date getPWPH_CR_DT() {
		 return PWPH_CR_DT;
	}

	public void setPWPH_CR_DT(Date PWPH_CR_DT) {
		this.PWPH_CR_DT = PWPH_CR_DT;
	}

	public String getPWPH_UPD_UID() {
		 return PWPH_UPD_UID;
	}

	public void setPWPH_UPD_UID(String PWPH_UPD_UID) {
		this.PWPH_UPD_UID = PWPH_UPD_UID;
	}

	public Date getPWPH_UPD_DT() {
		 return PWPH_UPD_DT;
	}

	public void setPWPH_UPD_DT(Date PWPH_UPD_DT) {
		this.PWPH_UPD_DT = PWPH_UPD_DT;
	}

	public Integer getPWPH_TOPUP_MIN_YRS() {
		return PWPH_TOPUP_MIN_YRS;
	}

	public void setPWPH_TOPUP_MIN_YRS(Integer pwph_topup_min_yrs) {
		PWPH_TOPUP_MIN_YRS = pwph_topup_min_yrs;
	}
	
	/*added by raja on 12-07-2017 for ZBILQC-1731237*/
	
	@Column(name="PWPH_FULL_WD_PERIOD")
	private Integer PWPH_FULL_WD_PERIOD;
	
	//@Column(name="PWPH_FULL_WD_MIN_AGE")
	private Integer PWPH_FULL_WD_MIN_AGE;



	public Integer getPWPH_FULL_WD_PERIOD() {
		return PWPH_FULL_WD_PERIOD;
	}

	public void setPWPH_FULL_WD_PERIOD(Integer pWPH_FULL_WD_PERIOD) {
		PWPH_FULL_WD_PERIOD = pWPH_FULL_WD_PERIOD;
	}

	public Integer getPWPH_FULL_WD_MIN_AGE() {
		return PWPH_FULL_WD_MIN_AGE;
	}

	public void setPWPH_FULL_WD_MIN_AGE(Integer pWPH_FULL_WD_MIN_AGE) {
		PWPH_FULL_WD_MIN_AGE = pWPH_FULL_WD_MIN_AGE;
	}
	
	
/*end*/
	/*added by raja on 02-08-2017 for ZBILQC-1732436*/
	@Column(name="PWPH_FULL_NO_OF_PREM")
	private Integer PWPH_FULL_NO_OF_PREM;



	public Integer getPWPH_FULL_NO_OF_PREM() {
		return PWPH_FULL_NO_OF_PREM;
	}

	public void setPWPH_FULL_NO_OF_PREM(Integer pWPH_FULL_NO_OF_PREM) {
		PWPH_FULL_NO_OF_PREM = pWPH_FULL_NO_OF_PREM;
	}
/*end*/
	
	
}
