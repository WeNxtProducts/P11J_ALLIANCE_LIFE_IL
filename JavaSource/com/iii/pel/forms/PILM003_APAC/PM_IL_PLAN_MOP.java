package com.iii.pel.forms.PILM003_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_PLAN_MOP")
public class PM_IL_PLAN_MOP extends BaseValueBean {

	@Column(name="PMOP_PLAN_CODE")
	private String PMOP_PLAN_CODE;

	@Column(name="PMOP_TYPE")
	private String PMOP_TYPE;

	@Column(name="PMOP_RATE")
	private Double PMOP_RATE;

	@Column(name="PMOP_RATE_PER")
	private Double PMOP_RATE_PER;

	@Column(name="PMOP_EFF_FM_DT")
	private Date PMOP_EFF_FM_DT;

	@Column(name="PMOP_EFF_TO_DT")
	private Date PMOP_EFF_TO_DT;

	@Column(name="PMOP_CR_DT")
	private Date PMOP_CR_DT;

	@Column(name="PMOP_CR_UID")
	private String PMOP_CR_UID;

	@Column(name="PMOP_UPD_DT")
	private Date PMOP_UPD_DT;

	@Column(name="PMOP_UPD_UID")
	private String PMOP_UPD_UID;

	@Column(name="PMOP_SHORT_RATE")
	private Double PMOP_SHORT_RATE;

	@Column(name="PMOP_SHORT_RATE_PER")
	private Double PMOP_SHORT_RATE_PER;

	@Column(name="PMOP_TOLL_TYP")
	private String PMOP_TOLL_TYP;

	@Column(name="PMOP_EXCESS_RATE")
	private Double PMOP_EXCESS_RATE;

	@Column(name="PMOP_EXCESS_RATE_PER")
	private Double PMOP_EXCESS_RATE_PER;

	@Column(name="PMOP_EX_TOLL_TYP")
	private String PMOP_EX_TOLL_TYP;

	@Column(name="PMOP_FIXED_PREM_VAL")
	private Double PMOP_FIXED_PREM_VAL;

	public void setPMOP_PLAN_CODE(String PMOP_PLAN_CODE) {
		this.PMOP_PLAN_CODE = PMOP_PLAN_CODE;
	}
	public String getPMOP_PLAN_CODE() {
		 return PMOP_PLAN_CODE;
	}
	public void setPMOP_EXCESS_RATE(Double PMOP_EXCESS_RATE) {
		this.PMOP_EXCESS_RATE = PMOP_EXCESS_RATE;
	}
	public Double getPMOP_EXCESS_RATE() {
		 return PMOP_EXCESS_RATE;
	}
	public void setPMOP_EXCESS_RATE_PER(Double PMOP_EXCESS_RATE_PER) {
		this.PMOP_EXCESS_RATE_PER = PMOP_EXCESS_RATE_PER;
	}
	public Double getPMOP_EXCESS_RATE_PER() {
		 return PMOP_EXCESS_RATE_PER;
	}
	public void setPMOP_EFF_TO_DT(Date PMOP_EFF_TO_DT) {
		this.PMOP_EFF_TO_DT = PMOP_EFF_TO_DT;
	}
	public Date getPMOP_EFF_TO_DT() {
		 return PMOP_EFF_TO_DT;
	}
	public void setPMOP_RATE_PER(Double PMOP_RATE_PER) {
		this.PMOP_RATE_PER = PMOP_RATE_PER;
	}
	public Double getPMOP_RATE_PER() {
		 return PMOP_RATE_PER;
	}
	public void setPMOP_EFF_FM_DT(Date PMOP_EFF_FM_DT) {
		this.PMOP_EFF_FM_DT = PMOP_EFF_FM_DT;
	}
	public Date getPMOP_EFF_FM_DT() {
		 return PMOP_EFF_FM_DT;
	}
	public void setPMOP_CR_DT(Date PMOP_CR_DT) {
		this.PMOP_CR_DT = PMOP_CR_DT;
	}
	public Date getPMOP_CR_DT() {
		 return PMOP_CR_DT;
	}
	public void setPMOP_UPD_UID(String PMOP_UPD_UID) {
		this.PMOP_UPD_UID = PMOP_UPD_UID;
	}
	public String getPMOP_UPD_UID() {
		 return PMOP_UPD_UID;
	}
	public void setPMOP_SHORT_RATE_PER(Double PMOP_SHORT_RATE_PER) {
		this.PMOP_SHORT_RATE_PER = PMOP_SHORT_RATE_PER;
	}
	public Double getPMOP_SHORT_RATE_PER() {
		 return PMOP_SHORT_RATE_PER;
	}
	public void setPMOP_RATE(Double PMOP_RATE) {
		this.PMOP_RATE = PMOP_RATE;
	}
	public Double getPMOP_RATE() {
		 return PMOP_RATE;
	}
	public void setPMOP_FIXED_PREM_VAL(Double PMOP_FIXED_PREM_VAL) {
		this.PMOP_FIXED_PREM_VAL = PMOP_FIXED_PREM_VAL;
	}
	public Double getPMOP_FIXED_PREM_VAL() {
		 return PMOP_FIXED_PREM_VAL;
	}
	public void setPMOP_UPD_DT(Date PMOP_UPD_DT) {
		this.PMOP_UPD_DT = PMOP_UPD_DT;
	}
	public Date getPMOP_UPD_DT() {
		 return PMOP_UPD_DT;
	}
	public void setPMOP_CR_UID(String PMOP_CR_UID) {
		this.PMOP_CR_UID = PMOP_CR_UID;
	}
	public String getPMOP_CR_UID() {
		 return PMOP_CR_UID;
	}
	public void setPMOP_TOLL_TYP(String PMOP_TOLL_TYP) {
		this.PMOP_TOLL_TYP = PMOP_TOLL_TYP;
	}
	public String getPMOP_TOLL_TYP() {
		 return PMOP_TOLL_TYP;
	}
	public void setPMOP_EX_TOLL_TYP(String PMOP_EX_TOLL_TYP) {
		this.PMOP_EX_TOLL_TYP = PMOP_EX_TOLL_TYP;
	}
	public String getPMOP_EX_TOLL_TYP() {
		 return PMOP_EX_TOLL_TYP;
	}
	public void setPMOP_SHORT_RATE(Double PMOP_SHORT_RATE) {
		this.PMOP_SHORT_RATE = PMOP_SHORT_RATE;
	}
	public Double getPMOP_SHORT_RATE() {
		 return PMOP_SHORT_RATE;
	}
	public void setPMOP_TYPE(String PMOP_TYPE) {
		this.PMOP_TYPE = PMOP_TYPE;
	}
	public String getPMOP_TYPE() {
		 return PMOP_TYPE;
	}

}
