package com.iii.pel.forms.PILM035_APAC;
import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_SA_INST_PYMT")
public class PM_IL_SA_INST_PYMT  extends BaseValueBean{

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

	public void setSIP_PLAN_CODE(String SIP_PLAN_CODE) {
		this.SIP_PLAN_CODE = SIP_PLAN_CODE;
	}

	public Double getSIP_PERC() {
		 return SIP_PERC;
	}

	public void setSIP_PERC(Double SIP_PERC) {
		this.SIP_PERC = SIP_PERC;
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

	public void setSIP_REMARKS(String SIP_REMARKS) {
		this.SIP_REMARKS = SIP_REMARKS;
	}

	public String getSIP_BL_REMARKS() {
		 return SIP_BL_REMARKS;
	}

	public void setSIP_BL_REMARKS(String SIP_BL_REMARKS) {
		this.SIP_BL_REMARKS = SIP_BL_REMARKS;
	}

	public Date getSIP_CR_DT() {
		 return SIP_CR_DT;
	}

	public void setSIP_CR_DT(Date SIP_CR_DT) {
		this.SIP_CR_DT = SIP_CR_DT;
	}

	public String getSIP_CR_UID() {
		 return SIP_CR_UID;
	}

	public void setSIP_CR_UID(String SIP_CR_UID) {
		this.SIP_CR_UID = SIP_CR_UID;
	}

	public Date getSIP_UPD_DT() {
		 return SIP_UPD_DT;
	}

	public void setSIP_UPD_DT(Date SIP_UPD_DT) {
		this.SIP_UPD_DT = SIP_UPD_DT;
	}

	public String getSIP_UPD_UID() {
		 return SIP_UPD_UID;
	}

	public void setSIP_UPD_UID(String SIP_UPD_UID) {
		this.SIP_UPD_UID = SIP_UPD_UID;
	}

	public String getSIP_PROD_CODE() {
		 return SIP_PROD_CODE;
	}

	public void setSIP_PROD_CODE(String SIP_PROD_CODE) {
		this.SIP_PROD_CODE = SIP_PROD_CODE;
	}
}
