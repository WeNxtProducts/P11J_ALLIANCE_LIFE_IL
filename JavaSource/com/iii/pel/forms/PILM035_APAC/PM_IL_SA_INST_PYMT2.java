package com.iii.pel.forms.PILM035_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_IL_SA_INST_PYMT")
public class PM_IL_SA_INST_PYMT2 extends BaseValueBean {
	
	@Column(name="SIP_PLAN_CODE")
	private String SIP_PLAN_CODE;

	@Column(name="SIP_PERC")
	private Double SIP_PERC;

	@Column(name="SIP_NUMR_PERIOD")
	private Integer SIP_NUMR_PERIOD;

	@Column(name="SIP_DEMR_PERIOD")
	private Integer SIP_DEMR_PERIOD;

	@Column(name="SIP_REMARKS")
	private String SIP_REMARKS;

	@Column(name="SIP_BL_REMARKS")
	private String SIP_BL_REMARKS;

	@Column(name="SIP_CR_DT")
	private Date SIP_CR_DT;

	@Column(name="SIP_CR_UID")
	private String SIP_CR_UID;

	@Column(name="SIP_UPD_DT")
	private Date SIP_UPD_DT;

	@Column(name="SIP_UPD_UID")
	private String SIP_UPD_UID;

	@Column(name="SIP_PROD_CODE")
	private String SIP_PROD_CODE;

	public String getSIP_PLAN_CODE() {
		return SIP_PLAN_CODE;
	}

	public void setSIP_PLAN_CODE(String sip_plan_code) {
		SIP_PLAN_CODE = sip_plan_code;
	}

	public Double getSIP_PERC() {
		return SIP_PERC;
	}

	public void setSIP_PERC(Double sip_perc) {
		SIP_PERC = sip_perc;
	}

	public Integer getSIP_NUMR_PERIOD() {
		return SIP_NUMR_PERIOD;
	}

	public void setSIP_NUMR_PERIOD(Integer sip_numr_period) {
		SIP_NUMR_PERIOD = sip_numr_period;
	}

	public Integer getSIP_DEMR_PERIOD() {
		return SIP_DEMR_PERIOD;
	}

	public void setSIP_DEMR_PERIOD(Integer sip_demr_period) {
		SIP_DEMR_PERIOD = sip_demr_period;
	}

	public String getSIP_REMARKS() {
		return SIP_REMARKS;
	}

	public void setSIP_REMARKS(String sip_remarks) {
		SIP_REMARKS = sip_remarks;
	}

	public String getSIP_BL_REMARKS() {
		return SIP_BL_REMARKS;
	}

	public void setSIP_BL_REMARKS(String sip_bl_remarks) {
		SIP_BL_REMARKS = sip_bl_remarks;
	}

	public Date getSIP_CR_DT() {
		return SIP_CR_DT;
	}

	public void setSIP_CR_DT(Date sip_cr_dt) {
		SIP_CR_DT = sip_cr_dt;
	}

	public String getSIP_CR_UID() {
		return SIP_CR_UID;
	}

	public void setSIP_CR_UID(String sip_cr_uid) {
		SIP_CR_UID = sip_cr_uid;
	}

	public Date getSIP_UPD_DT() {
		return SIP_UPD_DT;
	}

	public void setSIP_UPD_DT(Date sip_upd_dt) {
		SIP_UPD_DT = sip_upd_dt;
	}

	public String getSIP_UPD_UID() {
		return SIP_UPD_UID;
	}

	public void setSIP_UPD_UID(String sip_upd_uid) {
		SIP_UPD_UID = sip_upd_uid;
	}

	public String getSIP_PROD_CODE() {
		return SIP_PROD_CODE;
	}

	public void setSIP_PROD_CODE(String sip_prod_code) {
		SIP_PROD_CODE = sip_prod_code;
	}
	
	
}
