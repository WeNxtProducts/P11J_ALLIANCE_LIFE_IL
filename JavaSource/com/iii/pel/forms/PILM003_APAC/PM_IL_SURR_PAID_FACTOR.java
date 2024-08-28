package com.iii.pel.forms.PILM003_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_SURR_PAID_FACTOR")
public class PM_IL_SURR_PAID_FACTOR extends BaseValueBean {

	@Column(name="SPF_PLAN_CODE")
	private String SPF_PLAN_CODE;

	@Column(name="SPF_PERIOD")
	private Integer SPF_PERIOD;

	@Column(name="SPF_NO_YRS_PREM_PAID")
	private Integer SPF_NO_YRS_PREM_PAID;

	@Column(name="SPF_POL_SURR_FACTOR")
	private Double SPF_POL_SURR_FACTOR;

	@Column(name="SPF_POL_PAIDUP_FACTOR")
	private Double SPF_POL_PAIDUP_FACTOR;

	@Column(name="SPF_PRO_SURR_FACTOR")
	private Double SPF_PRO_SURR_FACTOR;

	@Column(name="SPF_PRO_PAIDUP_FACTOR")
	private Double SPF_PRO_PAIDUP_FACTOR;

	@Column(name="SPF_FRZ_FLAG")
	private String SPF_FRZ_FLAG;

	@Column(name="SPF_CR_DT")
	private Date SPF_CR_DT;

	@Column(name="SPF_CR_UID")
	private String SPF_CR_UID;

	@Column(name="SPF_UPD_DT")
	private Date SPF_UPD_DT;

	@Column(name="SPF_UPD_UID")
	private String SPF_UPD_UID;

	@Column(name="SPF_UPTO_DAYS")
	private Integer SPF_UPTO_DAYS;

	@Column(name="SPF_RATE_PER")
	private Double SPF_RATE_PER;
	
	
	private boolean UI_SPF_FRZ_FLAG;

	public void setSPF_PRO_PAIDUP_FACTOR(Double SPF_PRO_PAIDUP_FACTOR) {
		this.SPF_PRO_PAIDUP_FACTOR = SPF_PRO_PAIDUP_FACTOR;
	}
	public Double getSPF_PRO_PAIDUP_FACTOR() {
		 return SPF_PRO_PAIDUP_FACTOR;
	}
	public void setSPF_UPD_UID(String SPF_UPD_UID) {
		this.SPF_UPD_UID = SPF_UPD_UID;
	}
	public String getSPF_UPD_UID() {
		 return SPF_UPD_UID;
	}
	public void setSPF_CR_UID(String SPF_CR_UID) {
		this.SPF_CR_UID = SPF_CR_UID;
	}
	public String getSPF_CR_UID() {
		 return SPF_CR_UID;
	}
	public void setSPF_NO_YRS_PREM_PAID(Integer SPF_NO_YRS_PREM_PAID) {
		this.SPF_NO_YRS_PREM_PAID = SPF_NO_YRS_PREM_PAID;
	}
	public Integer getSPF_NO_YRS_PREM_PAID() {
		 return SPF_NO_YRS_PREM_PAID;
	}
	public void setSPF_CR_DT(Date SPF_CR_DT) {
		this.SPF_CR_DT = SPF_CR_DT;
	}
	public Date getSPF_CR_DT() {
		 return SPF_CR_DT;
	}
	public void setSPF_UPD_DT(Date SPF_UPD_DT) {
		this.SPF_UPD_DT = SPF_UPD_DT;
	}
	public Date getSPF_UPD_DT() {
		 return SPF_UPD_DT;
	}
	public void setSPF_PLAN_CODE(String SPF_PLAN_CODE) {
		this.SPF_PLAN_CODE = SPF_PLAN_CODE;
	}
	public String getSPF_PLAN_CODE() {
		 return SPF_PLAN_CODE;
	}
	public void setSPF_FRZ_FLAG(String SPF_FRZ_FLAG) {
		if(SPF_FRZ_FLAG.equals("Y")){
			this.SPF_FRZ_FLAG = "Y" ;
		}else{
			this.SPF_FRZ_FLAG = "N" ;
		}
	}
	public String getSPF_FRZ_FLAG() {
		 return SPF_FRZ_FLAG;
	}
	public void setSPF_PERIOD(Integer SPF_PERIOD) {
		this.SPF_PERIOD = SPF_PERIOD;
	}
	public Integer getSPF_PERIOD() {
		 return SPF_PERIOD;
	}
	public void setSPF_UPTO_DAYS(Integer SPF_UPTO_DAYS) {
		this.SPF_UPTO_DAYS = SPF_UPTO_DAYS;
	}
	public Integer getSPF_UPTO_DAYS() {
		 return SPF_UPTO_DAYS;
	}
	public void setSPF_PRO_SURR_FACTOR(Double SPF_PRO_SURR_FACTOR) {
		this.SPF_PRO_SURR_FACTOR = SPF_PRO_SURR_FACTOR;
	}
	public Double getSPF_PRO_SURR_FACTOR() {
		 return SPF_PRO_SURR_FACTOR;
	}
	public void setSPF_RATE_PER(Double SPF_RATE_PER) {
		this.SPF_RATE_PER = SPF_RATE_PER;
	}
	public Double getSPF_RATE_PER() {
		 return SPF_RATE_PER;
	}
	public void setSPF_POL_SURR_FACTOR(Double SPF_POL_SURR_FACTOR) {
		this.SPF_POL_SURR_FACTOR = SPF_POL_SURR_FACTOR;
	}
	public Double getSPF_POL_SURR_FACTOR() {
		 return SPF_POL_SURR_FACTOR;
	}
	public void setSPF_POL_PAIDUP_FACTOR(Double SPF_POL_PAIDUP_FACTOR) {
		this.SPF_POL_PAIDUP_FACTOR = SPF_POL_PAIDUP_FACTOR;
	}
	public Double getSPF_POL_PAIDUP_FACTOR() {
		 return SPF_POL_PAIDUP_FACTOR;
	}
	public boolean isUI_SPF_FRZ_FLAG() {
		return UI_SPF_FRZ_FLAG;
	}
	public void setUI_SPF_FRZ_FLAG(boolean ui_spf_frz_flag) {
		UI_SPF_FRZ_FLAG = ui_spf_frz_flag;
	}

}
