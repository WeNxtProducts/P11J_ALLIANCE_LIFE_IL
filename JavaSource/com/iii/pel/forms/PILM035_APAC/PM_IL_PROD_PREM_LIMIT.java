package com.iii.pel.forms.PILM035_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_IL_PROD_PREM_LIMIT")
public class PM_IL_PROD_PREM_LIMIT extends BaseValueBean {

	@Column(name = "PPL_PROD_CODE")
	private String PPL_PROD_CODE;

	@Column(name = "PPL_MODE_OF_PYMT")
	private String PPL_MODE_OF_PYMT;

	@Column(name = "PPL_LC_MIN_PREM")
	private Double PPL_LC_MIN_PREM;

	@Column(name = "PPL_LC_MAX_PREM")
	private Double PPL_LC_MAX_PREM;

	@Column(name = "PPL_CR_DT")
	private Date PPL_CR_DT;

	@Column(name = "PPL_CR_UID")
	private String PPL_CR_UID;

	@Column(name = "PPL_UPD_DT")
	private Date PPL_UPD_DT;

	@Column(name = "PPL_UPD_UID")
	private String PPL_UPD_UID;

	@Column(name = "PPL_CHECK_BASIS")
	private String PPL_CHECK_BASIS;

	@Column(name = "PPL_FM_TERM")
	private Integer PPL_FM_TERM;

	@Column(name = "PPL_TO_TERM")
	private Integer PPL_TO_TERM;

	public String getPPL_PROD_CODE() {
		return PPL_PROD_CODE;
	}

	public void setPPL_PROD_CODE(String PPL_PROD_CODE) {
		this.PPL_PROD_CODE = PPL_PROD_CODE;
	}

	public String getPPL_MODE_OF_PYMT() {
		return PPL_MODE_OF_PYMT;
	}

	public void setPPL_MODE_OF_PYMT(String PPL_MODE_OF_PYMT) {
		this.PPL_MODE_OF_PYMT = PPL_MODE_OF_PYMT;
	}

	public Double getPPL_LC_MIN_PREM() {
		return PPL_LC_MIN_PREM;
	}

	public void setPPL_LC_MIN_PREM(Double PPL_LC_MIN_PREM) {
		this.PPL_LC_MIN_PREM = PPL_LC_MIN_PREM;
	}

	public Double getPPL_LC_MAX_PREM() {
		return PPL_LC_MAX_PREM;
	}

	public void setPPL_LC_MAX_PREM(Double PPL_LC_MAX_PREM) {
		this.PPL_LC_MAX_PREM = PPL_LC_MAX_PREM;
	}

	public Date getPPL_CR_DT() {
		return PPL_CR_DT;
	}

	public void setPPL_CR_DT(Date PPL_CR_DT) {
		this.PPL_CR_DT = PPL_CR_DT;
	}

	public String getPPL_CR_UID() {
		return PPL_CR_UID;
	}

	public void setPPL_CR_UID(String PPL_CR_UID) {
		this.PPL_CR_UID = PPL_CR_UID;
	}

	public Date getPPL_UPD_DT() {
		return PPL_UPD_DT;
	}

	public void setPPL_UPD_DT(Date PPL_UPD_DT) {
		this.PPL_UPD_DT = PPL_UPD_DT;
	}

	public String getPPL_UPD_UID() {
		return PPL_UPD_UID;
	}

	public void setPPL_UPD_UID(String PPL_UPD_UID) {
		this.PPL_UPD_UID = PPL_UPD_UID;
	}

	public String getPPL_CHECK_BASIS() {
		return PPL_CHECK_BASIS;
	}

	public void setPPL_CHECK_BASIS(String PPL_CHECK_BASIS) {
		this.PPL_CHECK_BASIS = PPL_CHECK_BASIS;
	}

	public Integer getPPL_FM_TERM() {
		return PPL_FM_TERM;
	}

	public void setPPL_FM_TERM(Integer ppl_fm_term) {
		PPL_FM_TERM = ppl_fm_term;
	}

	public Integer getPPL_TO_TERM() {
		return PPL_TO_TERM;
	}

	public void setPPL_TO_TERM(Integer ppl_to_term) {
		PPL_TO_TERM = ppl_to_term;
	}

}
