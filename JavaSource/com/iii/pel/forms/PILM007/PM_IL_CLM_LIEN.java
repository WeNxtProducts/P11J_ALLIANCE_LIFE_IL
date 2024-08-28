package com.iii.pel.forms.PILM007;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_CLM_LIEN")
public class PM_IL_CLM_LIEN extends BaseValueBean {

	@Column(name="CL_COVER_CODE")
	private String CL_COVER_CODE;

	@Column(name="CL_LOSS_CODE")
	private String CL_LOSS_CODE;

	@Column(name="CL_DISABLE_TYPE")
	private String CL_DISABLE_TYPE;

	@Column(name="CL_FM_AGE")
	private Integer CL_FM_AGE;

	@Column(name="CL_TO_AGE")
	private Integer CL_TO_AGE;

	@Column(name="CL_RATE")
	private Double CL_RATE;

	@Column(name="CL_RATE_PER")
	private Double CL_RATE_PER;

	@Column(name="CL_APPLIED_ON")
	private String CL_APPLIED_ON;

	@Column(name="CL_CR_UID")
	private String CL_CR_UID;

	@Column(name="CL_CR_DT")
	private Date CL_CR_DT;

	@Column(name="CL_UPD_UID")
	private String CL_UPD_UID;

	@Column(name="CL_UPD_DT")
	private Date CL_UPD_DT;

	@Column(name="CL_BASIS")
	private String CL_BASIS;



	public String getCL_COVER_CODE() {
		 return CL_COVER_CODE;
	}

	public void setCL_COVER_CODE(String CL_COVER_CODE) {
		this.CL_COVER_CODE = CL_COVER_CODE;
	}

	public String getCL_LOSS_CODE() {
		 return CL_LOSS_CODE;
	}

	public void setCL_LOSS_CODE(String CL_LOSS_CODE) {
		this.CL_LOSS_CODE = CL_LOSS_CODE;
	}

	public String getCL_DISABLE_TYPE() {
		 return CL_DISABLE_TYPE;
	}

	public void setCL_DISABLE_TYPE(String CL_DISABLE_TYPE) {
		this.CL_DISABLE_TYPE = CL_DISABLE_TYPE;
	}

	public Integer getCL_FM_AGE() {
		 return CL_FM_AGE;
	}

	public void setCL_FM_AGE(Integer CL_FM_AGE) {
		this.CL_FM_AGE = CL_FM_AGE;
	}

	public Integer getCL_TO_AGE() {
		 return CL_TO_AGE;
	}

	public void setCL_TO_AGE(Integer CL_TO_AGE) {
		this.CL_TO_AGE = CL_TO_AGE;
	}

	public Double getCL_RATE() {
		 return CL_RATE;
	}

	public void setCL_RATE(Double CL_RATE) {
		this.CL_RATE = CL_RATE;
	}

	public Double getCL_RATE_PER() {
		 return CL_RATE_PER;
	}

	public void setCL_RATE_PER(Double CL_RATE_PER) {
		this.CL_RATE_PER = CL_RATE_PER;
	}

	public String getCL_APPLIED_ON() {
		 return CL_APPLIED_ON;
	}

	public void setCL_APPLIED_ON(String CL_APPLIED_ON) {
		this.CL_APPLIED_ON = CL_APPLIED_ON;
	}

	public String getCL_CR_UID() {
		 return CL_CR_UID;
	}

	public void setCL_CR_UID(String CL_CR_UID) {
		this.CL_CR_UID = CL_CR_UID;
	}

	public Date getCL_CR_DT() {
		 return CL_CR_DT;
	}

	public void setCL_CR_DT(Date CL_CR_DT) {
		this.CL_CR_DT = CL_CR_DT;
	}

	public String getCL_UPD_UID() {
		 return CL_UPD_UID;
	}

	public void setCL_UPD_UID(String CL_UPD_UID) {
		this.CL_UPD_UID = CL_UPD_UID;
	}

	public Date getCL_UPD_DT() {
		 return CL_UPD_DT;
	}

	public void setCL_UPD_DT(Date CL_UPD_DT) {
		this.CL_UPD_DT = CL_UPD_DT;
	}

	public String getCL_BASIS() {
		 return CL_BASIS;
	}

	public void setCL_BASIS(String CL_BASIS) {
		this.CL_BASIS = CL_BASIS;
	}
}
