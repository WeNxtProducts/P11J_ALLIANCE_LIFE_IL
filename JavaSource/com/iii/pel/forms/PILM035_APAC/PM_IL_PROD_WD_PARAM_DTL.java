package com.iii.pel.forms.PILM035_APAC;
import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_PROD_WD_PARAM_DTL")
public class PM_IL_PROD_WD_PARAM_DTL  extends BaseValueBean{

	@Column(name="PWPD_SYS_ID")
	private Integer PWPD_SYS_ID;

	@Column(name="PWPD_PWPH_SYS_ID")
	private Integer PWPD_PWPH_SYS_ID;

	@Column(name="PWPD_FM_PREM_PAY_YRS")
	private Double PWPD_FM_PREM_PAY_YRS;

	@Column(name="PWPD_TO_PREM_PAY_YRS")
	private Double PWPD_TO_PREM_PAY_YRS;

	@Column(name="PWPD_LIMIT_RATE")
	private Double PWPD_LIMIT_RATE;

	@Column(name="PWPD_LIMIT_RATE_PER")
	private Integer PWPD_LIMIT_RATE_PER;

	@Column(name="PWPD_TOPUP_LIMIT_RATE")
	private Double PWPD_TOPUP_LIMIT_RATE;

	@Column(name="PWPD_TOPUP_LIMIT_RATE_PER")
	private Integer PWPD_TOPUP_LIMIT_RATE_PER;

	@Column(name="PWPD_NO_OF_TRANS")
	private Integer PWPD_NO_OF_TRANS;

	@Column(name="PWPD_LC_MIN_AMT")
	private Double PWPD_LC_MIN_AMT;

	@Column(name="PWPD_LC_MAX_AMT")
	private Double PWPD_LC_MAX_AMT;

	@Column(name="PWPD_CR_UID")
	private String PWPD_CR_UID;

	@Column(name="PWPD_CR_DT")
	private Date PWPD_CR_DT;

	@Column(name="PWPD_UPD_UID")
	private String PWPD_UPD_UID;

	@Column(name="PWPD_UPD_DT")
	private Date PWPD_UPD_DT;



	
	public void setPWPD_SYS_ID(Integer pwpd_sys_id) {
		PWPD_SYS_ID = pwpd_sys_id;
	}


	public Integer getPWPD_SYS_ID() {
		return PWPD_SYS_ID;
	}

	
	

	public Integer getPWPD_PWPH_SYS_ID() {
		return PWPD_PWPH_SYS_ID;
	}


	public void setPWPD_PWPH_SYS_ID(Integer pwpd_pwph_sys_id) {
		PWPD_PWPH_SYS_ID = pwpd_pwph_sys_id;
	}


	public Double getPWPD_FM_PREM_PAY_YRS() {
		 return PWPD_FM_PREM_PAY_YRS;
	}

	public void setPWPD_FM_PREM_PAY_YRS(Double PWPD_FM_PREM_PAY_YRS) {
		this.PWPD_FM_PREM_PAY_YRS = PWPD_FM_PREM_PAY_YRS;
	}

	public Double getPWPD_TO_PREM_PAY_YRS() {
		 return PWPD_TO_PREM_PAY_YRS;
	}

	public void setPWPD_TO_PREM_PAY_YRS(Double PWPD_TO_PREM_PAY_YRS) {
		this.PWPD_TO_PREM_PAY_YRS = PWPD_TO_PREM_PAY_YRS;
	}

	public Double getPWPD_LIMIT_RATE() {
		 return PWPD_LIMIT_RATE;
	}

	public void setPWPD_LIMIT_RATE(Double PWPD_LIMIT_RATE) {
		this.PWPD_LIMIT_RATE = PWPD_LIMIT_RATE;
	}

	

	public Integer getPWPD_LIMIT_RATE_PER() {
		return PWPD_LIMIT_RATE_PER;
	}


	public void setPWPD_LIMIT_RATE_PER(Integer pwpd_limit_rate_per) {
		PWPD_LIMIT_RATE_PER = pwpd_limit_rate_per;
	}


	public Double getPWPD_TOPUP_LIMIT_RATE() {
		 return PWPD_TOPUP_LIMIT_RATE;
	}

	public void setPWPD_TOPUP_LIMIT_RATE(Double PWPD_TOPUP_LIMIT_RATE) {
		this.PWPD_TOPUP_LIMIT_RATE = PWPD_TOPUP_LIMIT_RATE;
	}



	public Integer getPWPD_TOPUP_LIMIT_RATE_PER() {
		return PWPD_TOPUP_LIMIT_RATE_PER;
	}


	public void setPWPD_TOPUP_LIMIT_RATE_PER(Integer pwpd_topup_limit_rate_per) {
		PWPD_TOPUP_LIMIT_RATE_PER = pwpd_topup_limit_rate_per;
	}


	public Integer getPWPD_NO_OF_TRANS() {
		return PWPD_NO_OF_TRANS;
	}


	public void setPWPD_NO_OF_TRANS(Integer pwpd_no_of_trans) {
		PWPD_NO_OF_TRANS = pwpd_no_of_trans;
	}


	public Double getPWPD_LC_MIN_AMT() {
		 return PWPD_LC_MIN_AMT;
	}

	public void setPWPD_LC_MIN_AMT(Double PWPD_LC_MIN_AMT) {
		this.PWPD_LC_MIN_AMT = PWPD_LC_MIN_AMT;
	}

	public Double getPWPD_LC_MAX_AMT() {
		 return PWPD_LC_MAX_AMT;
	}

	public void setPWPD_LC_MAX_AMT(Double PWPD_LC_MAX_AMT) {
		this.PWPD_LC_MAX_AMT = PWPD_LC_MAX_AMT;
	}

	public String getPWPD_CR_UID() {
		 return PWPD_CR_UID;
	}

	public void setPWPD_CR_UID(String PWPD_CR_UID) {
		this.PWPD_CR_UID = PWPD_CR_UID;
	}

	public Date getPWPD_CR_DT() {
		 return PWPD_CR_DT;
	}

	public void setPWPD_CR_DT(Date PWPD_CR_DT) {
		this.PWPD_CR_DT = PWPD_CR_DT;
	}

	public String getPWPD_UPD_UID() {
		 return PWPD_UPD_UID;
	}

	public void setPWPD_UPD_UID(String PWPD_UPD_UID) {
		this.PWPD_UPD_UID = PWPD_UPD_UID;
	}

	public Date getPWPD_UPD_DT() {
		 return PWPD_UPD_DT;
	}

	public void setPWPD_UPD_DT(Date PWPD_UPD_DT) {
		this.PWPD_UPD_DT = PWPD_UPD_DT;
	}
}
