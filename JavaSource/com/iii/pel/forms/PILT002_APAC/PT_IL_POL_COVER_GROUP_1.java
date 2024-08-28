package com.iii.pel.forms.PILT002_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POL_COVER_GROUP")
public class PT_IL_POL_COVER_GROUP_1 extends BaseValueBean {

	@Column(name="PCG_SYS_ID")
	private Long PCG_SYS_ID;

	@Column(name="PCG_POL_SYS_ID")
	private Long PCG_POL_SYS_ID;

	@Column(name="PCG_POAD_SYS_ID")
	private Long PCG_POAD_SYS_ID;

	@Column(name="PCG_PAPP_SYS_ID")
	private Long PCG_PAPP_SYS_ID;

	@Column(name="PCG_CODE")
	private String PCG_CODE;

	@Column(name="PCG_RATE")
	private Double PCG_RATE;

	@Column(name="PCG_RATE_PER")
	private Double PCG_RATE_PER;

	@Column(name="PCG_FC_PREM")
	private Double PCG_FC_PREM;

	@Column(name="PCG_LC_PREM")
	private Double PCG_LC_PREM;

	@Column(name="PCG_ORG_FC_PREM")
	private Double PCG_ORG_FC_PREM;

	@Column(name="PCG_ORG_LC_PREM")
	private Double PCG_ORG_LC_PREM;

	@Column(name="PCG_DEL_FLAG")
	private String PCG_DEL_FLAG;

	@Column(name="PCG_CR_DT")
	private Date PCG_CR_DT;

	@Column(name="PCG_CR_UID")
	private String PCG_CR_UID;

	@Column(name="PCG_UPD_DT")
	private Date PCG_UPD_DT;

	@Column(name="PCG_UPD_UID")
	private String PCG_UPD_UID;

	private String UI_M_PROD_CODE;
	private String UI_M_PCD_CODE_DESC;
	public void setPCG_RATE(Double PCG_RATE) {
		this.PCG_RATE = PCG_RATE;
	}
	public Double getPCG_RATE() {
		 return PCG_RATE;
	}
	public void setPCG_CR_DT(Date PCG_CR_DT) {
		this.PCG_CR_DT = PCG_CR_DT;
	}
	public Date getPCG_CR_DT() {
		 return PCG_CR_DT;
	}
	public void setPCG_ORG_FC_PREM(Double PCG_ORG_FC_PREM) {
		this.PCG_ORG_FC_PREM = PCG_ORG_FC_PREM;
	}
	public Double getPCG_ORG_FC_PREM() {
		 return PCG_ORG_FC_PREM;
	}
	public void setPCG_FC_PREM(Double PCG_FC_PREM) {
		this.PCG_FC_PREM = PCG_FC_PREM;
	}
	public Double getPCG_FC_PREM() {
		 return PCG_FC_PREM;
	}
	public void setPCG_POL_SYS_ID(Long PCG_POL_SYS_ID) {
		this.PCG_POL_SYS_ID = PCG_POL_SYS_ID;
	}
	public Long getPCG_POL_SYS_ID() {
		 return PCG_POL_SYS_ID;
	}
	public void setPCG_LC_PREM(Double PCG_LC_PREM) {
		this.PCG_LC_PREM = PCG_LC_PREM;
	}
	public Double getPCG_LC_PREM() {
		 return PCG_LC_PREM;
	}
	public void setPCG_RATE_PER(Double PCG_RATE_PER) {
		this.PCG_RATE_PER = PCG_RATE_PER;
	}
	public Double getPCG_RATE_PER() {
		 return PCG_RATE_PER;
	}
	public void setUI_M_PCD_CODE_DESC(String UI_M_PCD_CODE_DESC) {
		this.UI_M_PCD_CODE_DESC = UI_M_PCD_CODE_DESC;
	}
	public String getUI_M_PCD_CODE_DESC() {
		 return UI_M_PCD_CODE_DESC;
	}
	public void setPCG_UPD_UID(String PCG_UPD_UID) {
		this.PCG_UPD_UID = PCG_UPD_UID;
	}
	public String getPCG_UPD_UID() {
		 return PCG_UPD_UID;
	}
	public void setPCG_POAD_SYS_ID(Long PCG_POAD_SYS_ID) {
		this.PCG_POAD_SYS_ID = PCG_POAD_SYS_ID;
	}
	public Long getPCG_POAD_SYS_ID() {
		 return PCG_POAD_SYS_ID;
	}
	public void setPCG_UPD_DT(Date PCG_UPD_DT) {
		this.PCG_UPD_DT = PCG_UPD_DT;
	}
	public Date getPCG_UPD_DT() {
		 return PCG_UPD_DT;
	}
	public void setPCG_SYS_ID(Long PCG_SYS_ID) {
		this.PCG_SYS_ID = PCG_SYS_ID;
	}
	public Long getPCG_SYS_ID() {
		 return PCG_SYS_ID;
	}
	public void setUI_M_PROD_CODE(String UI_M_PROD_CODE) {
		this.UI_M_PROD_CODE = UI_M_PROD_CODE;
	}
	public String getUI_M_PROD_CODE() {
		 return UI_M_PROD_CODE;
	}
	public void setPCG_PAPP_SYS_ID(Long PCG_PAPP_SYS_ID) {
		this.PCG_PAPP_SYS_ID = PCG_PAPP_SYS_ID;
	}
	public Long getPCG_PAPP_SYS_ID() {
		 return PCG_PAPP_SYS_ID;
	}
	public void setPCG_CR_UID(String PCG_CR_UID) {
		this.PCG_CR_UID = PCG_CR_UID;
	}
	public String getPCG_CR_UID() {
		 return PCG_CR_UID;
	}
	public void setPCG_CODE(String PCG_CODE) {
		this.PCG_CODE = PCG_CODE;
	}
	public String getPCG_CODE() {
		 return PCG_CODE;
	}
	public void setPCG_DEL_FLAG(String PCG_DEL_FLAG) {
		this.PCG_DEL_FLAG = PCG_DEL_FLAG;
	}
	public String getPCG_DEL_FLAG() {
		 return PCG_DEL_FLAG;
	}
	public void setPCG_ORG_LC_PREM(Double PCG_ORG_LC_PREM) {
		this.PCG_ORG_LC_PREM = PCG_ORG_LC_PREM;
	}
	public Double getPCG_ORG_LC_PREM() {
		 return PCG_ORG_LC_PREM;
	}

}
