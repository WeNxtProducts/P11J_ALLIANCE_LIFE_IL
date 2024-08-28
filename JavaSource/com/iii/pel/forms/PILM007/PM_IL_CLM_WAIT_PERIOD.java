package com.iii.pel.forms.PILM007;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_IL_CLM_WAIT_PERIOD")
public class PM_IL_CLM_WAIT_PERIOD extends BaseValueBean {

	@Column(name = "CWP_COVER_CODE")
	private String CWP_COVER_CODE;

	@Column(name = "CWP_LOSS_CODE")
	private String CWP_LOSS_CODE;

	@Column(name = "CWP_DISABLE_TYPE")
	private String CWP_DISABLE_TYPE;

	@Column(name = "CWP_FM_DAYS")
	private Integer CWP_FM_DAYS;

	@Column(name = "CWP_TO_DAYS")
	private Integer CWP_TO_DAYS;

	@Column(name = "CWP_RATE")
	private Double CWP_RATE;

	@Column(name = "CWP_RATE_PER")
	private Double CWP_RATE_PER;

	@Column(name = "CWP_APPLIED_ON")
	private String CWP_APPLIED_ON;

	@Column(name = "CWP_CR_UID")
	private String CWP_CR_UID;

	@Column(name = "CWP_CR_DT")
	private Date CWP_CR_DT;

	@Column(name = "CWP_UPD_UID")
	private String CWP_UPD_UID;

	@Column(name = "CWP_UPD_DT")
	private Date CWP_UPD_DT;

	public String getCWP_COVER_CODE() {
		return CWP_COVER_CODE;
	}

	public void setCWP_COVER_CODE(String CWP_COVER_CODE) {
		this.CWP_COVER_CODE = CWP_COVER_CODE;
	}

	public String getCWP_LOSS_CODE() {
		return CWP_LOSS_CODE;
	}

	public void setCWP_LOSS_CODE(String CWP_LOSS_CODE) {
		this.CWP_LOSS_CODE = CWP_LOSS_CODE;
	}

	public String getCWP_DISABLE_TYPE() {
		return CWP_DISABLE_TYPE;
	}

	public void setCWP_DISABLE_TYPE(String CWP_DISABLE_TYPE) {
		this.CWP_DISABLE_TYPE = CWP_DISABLE_TYPE;
	}

	public Integer getCWP_FM_DAYS() {
		return CWP_FM_DAYS;
	}

	public void setCWP_FM_DAYS(Integer CWP_FM_DAYS) {
		this.CWP_FM_DAYS = CWP_FM_DAYS;
	}

	public Integer getCWP_TO_DAYS() {
		return CWP_TO_DAYS;
	}

	public void setCWP_TO_DAYS(Integer CWP_TO_DAYS) {
		this.CWP_TO_DAYS = CWP_TO_DAYS;
	}

	public Double getCWP_RATE() {
		return CWP_RATE;
	}

	public void setCWP_RATE(Double CWP_RATE) {
		this.CWP_RATE = CWP_RATE;
	}

	public Double getCWP_RATE_PER() {
		return CWP_RATE_PER;
	}

	public void setCWP_RATE_PER(Double CWP_RATE_PER) {
		this.CWP_RATE_PER = CWP_RATE_PER;
	}

	public String getCWP_APPLIED_ON() {
		return CWP_APPLIED_ON;
	}

	public void setCWP_APPLIED_ON(String CWP_APPLIED_ON) {
		this.CWP_APPLIED_ON = CWP_APPLIED_ON;
	}

	public String getCWP_CR_UID() {
		return CWP_CR_UID;
	}

	public void setCWP_CR_UID(String CWP_CR_UID) {
		this.CWP_CR_UID = CWP_CR_UID;
	}

	public Date getCWP_CR_DT() {
		return CWP_CR_DT;
	}

	public void setCWP_CR_DT(Date CWP_CR_DT) {
		this.CWP_CR_DT = CWP_CR_DT;
	}

	public String getCWP_UPD_UID() {
		return CWP_UPD_UID;
	}

	public void setCWP_UPD_UID(String CWP_UPD_UID) {
		this.CWP_UPD_UID = CWP_UPD_UID;
	}

	public Date getCWP_UPD_DT() {
		return CWP_UPD_DT;
	}

	public void setCWP_UPD_DT(Date CWP_UPD_DT) {
		this.CWP_UPD_DT = CWP_UPD_DT;
	}
}
