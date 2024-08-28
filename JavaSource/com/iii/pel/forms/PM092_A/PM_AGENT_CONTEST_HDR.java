package com.iii.pel.forms.PM092_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_AGENT_CONTEST_HDR")
public class PM_AGENT_CONTEST_HDR extends BaseValueBean {

	@Column(name="ACH_CODE")
	private String  ACH_CODE;
	
	@Column(name="ACH_DESC")
	private String  ACH_DESC;
	
	@Column(name="ACH_SHORT_DESC")
	private String  ACH_SHORT_DESC;
	
	@Column(name="ACH_LONG_DESC")
	private String  ACH_LONG_DESC;
	
	@Column(name="ACH_BL_DESC")
	private String  ACH_BL_DESC;
	
	@Column(name="ACH_BL_SHORT_DESC")
	private String  ACH_BL_SHORT_DESC;
	
	@Column(name="ACH_BL_LONG_DESC")
	private String  ACH_BL_LONG_DESC;
	
	@Column(name="ACH_LEVEL")
	private Double  ACH_LEVEL;
	
	@Column(name="ACH_EFF_FM_DT")
	private Date  ACH_EFF_FM_DT;
	
	@Column(name="ACH_EFF_TO_DT")
	private Date  ACH_EFF_TO_DT;
	
	@Column(name="ACH_CR_DT")
	private Date  ACH_CR_DT;
	
	@Column(name="ACH_CR_UID")
	private String  ACH_CR_UID;
	
	@Column(name="ACH_UPD_DT")
	private Date  ACH_UPD_DT;
	
	@Column(name="ACH_UPD_UID")
	private String  ACH_UPD_UID;


	public PM_AGENT_CONTEST_HDR() {
		
	}

	public Date getACH_CR_DT() {
		return ACH_CR_DT;
	}

	public void setACH_CR_DT(Date ach_cr_dt) {
		ACH_CR_DT = ach_cr_dt;
	}

	public String getACH_CR_UID() {
		return ACH_CR_UID;
	}

	public void setACH_CR_UID(String ach_cr_uid) {
		ACH_CR_UID = ach_cr_uid;
	}

	public Date getACH_UPD_DT() {
		return ACH_UPD_DT;
	}

	public void setACH_UPD_DT(Date ach_upd_dt) {
		ACH_UPD_DT = ach_upd_dt;
	}

	public String getACH_UPD_UID() {
		return ACH_UPD_UID;
	}

	public void setACH_UPD_UID(String ach_upd_uid) {
		ACH_UPD_UID = ach_upd_uid;
	}

	public String getACH_CODE() {
		return ACH_CODE;
	}

	public void setACH_CODE(String ACH_CODE) {
		this.ACH_CODE = ACH_CODE;
	}

	public String getACH_DESC() {
		return ACH_DESC;
	}

	public void setACH_DESC(String ACH_DESC) {
		this.ACH_DESC = ACH_DESC;
	}

	public String getACH_SHORT_DESC() {
		return ACH_SHORT_DESC;
	}

	public void setACH_SHORT_DESC(String ACH_SHORT_DESC) {
		this.ACH_SHORT_DESC = ACH_SHORT_DESC;
	}

	public String getACH_LONG_DESC() {
		return ACH_LONG_DESC;
	}

	public void setACH_LONG_DESC(String ACH_LONG_DESC) {
		this.ACH_LONG_DESC = ACH_LONG_DESC;
	}

	public Double getACH_LEVEL() {
		return ACH_LEVEL;
	}

	public void setACH_LEVEL(Double ACH_LEVEL) {
		this.ACH_LEVEL = ACH_LEVEL;
	}

	public Date getACH_EFF_FM_DT() {
		 return ACH_EFF_FM_DT;
	}

	public void setACH_EFF_FM_DT(Date ACH_EFF_FM_DT) {
		this.ACH_EFF_FM_DT = ACH_EFF_FM_DT;
	}

	public Date getACH_EFF_TO_DT() {
		 return ACH_EFF_TO_DT;
	}

	public void setACH_EFF_TO_DT(Date ACH_EFF_TO_DT) {
		this.ACH_EFF_TO_DT = ACH_EFF_TO_DT;
	}

	public String getACH_BL_DESC() {
		return ACH_BL_DESC;
	}

	public void setACH_BL_DESC(String ACH_BL_DESC) {
		this.ACH_BL_DESC = ACH_BL_DESC;
	}

	public String getACH_BL_SHORT_DESC() {
		return ACH_BL_SHORT_DESC;
	}

	public void setACH_BL_SHORT_DESC(String ACH_BL_SHORT_DESC) {
		this.ACH_BL_SHORT_DESC = ACH_BL_SHORT_DESC;
	}

	public String getACH_BL_LONG_DESC() {
		return ACH_BL_LONG_DESC;
	}

	public void setACH_BL_LONG_DESC(String ACH_BL_LONG_DESC) {
		this.ACH_BL_LONG_DESC = ACH_BL_LONG_DESC;
	}
}
