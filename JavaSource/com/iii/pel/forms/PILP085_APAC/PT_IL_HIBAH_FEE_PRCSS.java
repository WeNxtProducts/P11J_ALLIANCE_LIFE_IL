package com.iii.pel.forms.PILP085_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_HIBAH_FEE_PRCSS")
public class PT_IL_HIBAH_FEE_PRCSS extends BaseValueBean {

	@Column(name = "HFP_SYS_ID")
	private Long HFP_SYS_ID;

	@Column(name = "HFP_HFH_SYS_ID")
	private Long HFP_HFH_SYS_ID;

	@Column(name = "HFP_POL_NO")
	private String HFP_POL_NO;

	@Column(name = "HFP_ACNT_YEAR")
	private Integer HFP_ACNT_YEAR;

	@Column(name = "HFP_ACNT_YN")
	private String HFP_ACNT_YN;

	@Column(name = "HFP_CR_DT")
	private Date HFP_CR_DT;

	@Column(name = "HFP_CR_UID")
	private String HFP_CR_UID;

	@Column(name = "HFP_UPD_DT")
	private Date HFP_UPD_DT;

	@Column(name = "HFP_UPD_UID")
	private String HFP_UPD_UID;

	@Column(name = "HFP_HIBAH_FEE_AMT")
	private Double HFP_HIBAH_FEE_AMT;

	@Column(name = "HFP_PRCSS_YN")
	private String HFP_PRCSS_YN;

	@Column(name = "HFP_HIBAH_REPAY_AMT")
	private Double HFP_HIBAH_REPAY_AMT;

	@Column(name = "HFP_AGE")
	private Double HFP_AGE;

	@Column(name = "HFH_POL_NO_FM")
	private String HFH_POL_NO_FM;

	@Column(name = "HFH_POL_NO_TO")
	private String HFH_POL_NO_TO;

	@Column(name = "HFH_ACNT_YEAR")
	private Integer HFH_ACNT_YEAR;

	@Column(name = "HFH_DATE_FM")
	private Date HFH_DATE_FM;

	@Column(name = "HFH_DATE_TO")
	private Date HFH_DATE_TO;

	public String getHFH_POL_NO_FM() {
		return HFH_POL_NO_FM;
	}

	public void setHFH_POL_NO_FM(String HFH_POL_NO_FM) {
		this.HFH_POL_NO_FM = HFH_POL_NO_FM;
	}

	public String getHFH_POL_NO_TO() {
		return HFH_POL_NO_TO;
	}

	public void setHFH_POL_NO_TO(String HFH_POL_NO_TO) {
		this.HFH_POL_NO_TO = HFH_POL_NO_TO;
	}

	public Integer getHFH_ACNT_YEAR() {
		return HFH_ACNT_YEAR;
	}

	public void setHFH_ACNT_YEAR(Integer HFH_ACNT_YEAR) {
		this.HFH_ACNT_YEAR = HFH_ACNT_YEAR;
	}

	public Date getHFH_DATE_FM() {
		return HFH_DATE_FM;
	}

	public void setHFH_DATE_FM(Date HFH_DATE_FM) {
		this.HFH_DATE_FM = HFH_DATE_FM;
	}

	public Date getHFH_DATE_TO() {
		return HFH_DATE_TO;
	}

	public void setHFH_DATE_TO(Date HFH_DATE_TO) {
		this.HFH_DATE_TO = HFH_DATE_TO;
	}

	public void setHFP_UPD_UID(String HFP_UPD_UID) {
		this.HFP_UPD_UID = HFP_UPD_UID;
	}

	public String getHFP_UPD_UID() {
		return HFP_UPD_UID;
	}

	public void setHFP_SYS_ID(Long HFP_SYS_ID) {
		this.HFP_SYS_ID = HFP_SYS_ID;
	}

	public Long getHFP_SYS_ID() {
		return HFP_SYS_ID;
	}

	public void setHFP_ACNT_YEAR(Integer HFP_ACNT_YEAR) {
		this.HFP_ACNT_YEAR = HFP_ACNT_YEAR;
	}

	public Integer getHFP_ACNT_YEAR() {
		return HFP_ACNT_YEAR;
	}

	public void setHFP_ACNT_YN(String HFP_ACNT_YN) {
		this.HFP_ACNT_YN = HFP_ACNT_YN;
	}

	public String getHFP_ACNT_YN() {
		return HFP_ACNT_YN;
	}

	public void setHFP_HFH_SYS_ID(Long HFP_HFH_SYS_ID) {
		this.HFP_HFH_SYS_ID = HFP_HFH_SYS_ID;
	}

	public Long getHFP_HFH_SYS_ID() {
		return HFP_HFH_SYS_ID;
	}

	public void setHFP_HIBAH_FEE_AMT(Double HFP_HIBAH_FEE_AMT) {
		this.HFP_HIBAH_FEE_AMT = HFP_HIBAH_FEE_AMT;
	}

	public Double getHFP_HIBAH_FEE_AMT() {
		return HFP_HIBAH_FEE_AMT;
	}

	public void setHFP_PRCSS_YN(String HFP_PRCSS_YN) {
		this.HFP_PRCSS_YN = HFP_PRCSS_YN;
	}

	public String getHFP_PRCSS_YN() {
		return HFP_PRCSS_YN;
	}

	public void setHFP_AGE(Double HFP_AGE) {
		this.HFP_AGE = HFP_AGE;
	}

	public Double getHFP_AGE() {
		return HFP_AGE;
	}

	public void setHFP_POL_NO(String HFP_POL_NO) {
		this.HFP_POL_NO = HFP_POL_NO;
	}

	public String getHFP_POL_NO() {
		return HFP_POL_NO;
	}

	public void setHFP_CR_DT(Date HFP_CR_DT) {
		this.HFP_CR_DT = HFP_CR_DT;
	}

	public Date getHFP_CR_DT() {
		return HFP_CR_DT;
	}

	public void setHFP_UPD_DT(Date HFP_UPD_DT) {
		this.HFP_UPD_DT = HFP_UPD_DT;
	}

	public Date getHFP_UPD_DT() {
		return HFP_UPD_DT;
	}

	public void setHFP_HIBAH_REPAY_AMT(Double HFP_HIBAH_REPAY_AMT) {
		this.HFP_HIBAH_REPAY_AMT = HFP_HIBAH_REPAY_AMT;
	}

	public Double getHFP_HIBAH_REPAY_AMT() {
		return HFP_HIBAH_REPAY_AMT;
	}

	public void setHFP_CR_UID(String HFP_CR_UID) {
		this.HFP_CR_UID = HFP_CR_UID;
	}

	public String getHFP_CR_UID() {
		return HFP_CR_UID;
	}

}