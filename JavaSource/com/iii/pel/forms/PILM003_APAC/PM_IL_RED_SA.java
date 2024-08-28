package com.iii.pel.forms.PILM003_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_RED_SA")
public class PM_IL_RED_SA extends BaseValueBean {

	@Column(name="RSA_PLAN_CODE")
	private String RSA_PLAN_CODE;

	@Column(name="RSA_PERIOD_FROM")
	private Integer RSA_PERIOD_FROM;

	@Column(name="RSA_PERIOD_TO")
	private Integer RSA_PERIOD_TO;

	@Column(name="RSA_YEAR_FROM")
	private Integer RSA_YEAR_FROM;

	@Column(name="RSA_YEAR_TO")
	private Integer RSA_YEAR_TO;

	@Column(name="RSA_CR_DT")
	private Date RSA_CR_DT;

	@Column(name="RSA_CR_UID")
	private String RSA_CR_UID;

	@Column(name="RSA_UPD_DT")
	private Date RSA_UPD_DT;

	@Column(name="RSA_UPD_UID")
	private String RSA_UPD_UID;

	@Column(name="RSA_RATE_PER")
	private Integer RSA_RATE_PER;

	@Column(name="RSA_RI_RATE")
	private Double RSA_RI_RATE;

	@Column(name="RSA_CQS_RATE")
	private Double RSA_CQS_RATE;

	public void setRSA_UPD_DT(Date RSA_UPD_DT) {
		this.RSA_UPD_DT = RSA_UPD_DT;
	}
	public Date getRSA_UPD_DT() {
		 return RSA_UPD_DT;
	}
	public void setRSA_CR_UID(String RSA_CR_UID) {
		this.RSA_CR_UID = RSA_CR_UID;
	}
	public String getRSA_CR_UID() {
		 return RSA_CR_UID;
	}
	public Integer getRSA_RATE_PER() {
		return RSA_RATE_PER;
	}
	public void setRSA_RATE_PER(Integer rsa_rate_per) {
		RSA_RATE_PER = rsa_rate_per;
	}
	public void setRSA_PERIOD_TO(Integer RSA_PERIOD_TO) {
		this.RSA_PERIOD_TO = RSA_PERIOD_TO;
	}
	public Integer getRSA_PERIOD_TO() {
		 return RSA_PERIOD_TO;
	}
	public void setRSA_CR_DT(Date RSA_CR_DT) {
		this.RSA_CR_DT = RSA_CR_DT;
	}
	public Date getRSA_CR_DT() {
		 return RSA_CR_DT;
	}
	public void setRSA_YEAR_TO(Integer RSA_YEAR_TO) {
		this.RSA_YEAR_TO = RSA_YEAR_TO;
	}
	public Integer getRSA_YEAR_TO() {
		 return RSA_YEAR_TO;
	}
	public void setRSA_CQS_RATE(Double RSA_CQS_RATE) {
		this.RSA_CQS_RATE = RSA_CQS_RATE;
	}
	public Double getRSA_CQS_RATE() {
		 return RSA_CQS_RATE;
	}
	public void setRSA_YEAR_FROM(Integer RSA_YEAR_FROM) {
		this.RSA_YEAR_FROM = RSA_YEAR_FROM;
	}
	public Integer getRSA_YEAR_FROM() {
		 return RSA_YEAR_FROM;
	}
	public void setRSA_PERIOD_FROM(Integer RSA_PERIOD_FROM) {
		this.RSA_PERIOD_FROM = RSA_PERIOD_FROM;
	}
	public Integer getRSA_PERIOD_FROM() {
		 return RSA_PERIOD_FROM;
	}
	public void setRSA_RI_RATE(Double RSA_RI_RATE) {
		this.RSA_RI_RATE = RSA_RI_RATE;
	}
	public Double getRSA_RI_RATE() {
		 return RSA_RI_RATE;
	}
	public void setRSA_UPD_UID(String RSA_UPD_UID) {
		this.RSA_UPD_UID = RSA_UPD_UID;
	}
	public String getRSA_UPD_UID() {
		 return RSA_UPD_UID;
	}
	public void setRSA_PLAN_CODE(String RSA_PLAN_CODE) {
		this.RSA_PLAN_CODE = RSA_PLAN_CODE;
	}
	public String getRSA_PLAN_CODE() {
		 return RSA_PLAN_CODE;
	}

}
