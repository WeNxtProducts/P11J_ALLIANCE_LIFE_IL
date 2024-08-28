package com.iii.pel.forms.PILM036_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_SUB_PLAN")
public class PM_IL_SUB_PLAN extends BaseValueBean{

	@Column(name="SPLAN_CODE")
	private String SPLAN_CODE;

	@Column(name="SPLAN_DESC")
	private String SPLAN_DESC;

	@Column(name="SPLAN_GROUP_YN")
	private String SPLAN_GROUP_YN;
	
	@Column(name="SPLAN_CR_DT")
	private Date SPLAN_CR_DT;

	@Column(name="SPLAN_CR_UID")
	private String SPLAN_CR_UID;

	@Column(name="SPLAN_UPD_DT")
	private Date SPLAN_UPD_DT;

	@Column(name="SPLAN_UPD_UID")
	private String SPLAN_UPD_UID;

	public String getSPLAN_CODE() {
		return SPLAN_CODE;
	}

	public void setSPLAN_CODE(String sPLAN_CODE) {
		SPLAN_CODE = sPLAN_CODE;
	}

	public String getSPLAN_DESC() {
		return SPLAN_DESC;
	}

	public void setSPLAN_DESC(String sPLAN_DESC) {
		SPLAN_DESC = sPLAN_DESC;
	}

	public String getSPLAN_GROUP_YN() {
		return SPLAN_GROUP_YN;
	}

	public void setSPLAN_GROUP_YN(String sPLAN_GROUP_YN) {
		SPLAN_GROUP_YN = sPLAN_GROUP_YN;
	}

	public Date getSPLAN_CR_DT() {
		return SPLAN_CR_DT;
	}

	public void setSPLAN_CR_DT(Date sPLAN_CR_DT) {
		SPLAN_CR_DT = sPLAN_CR_DT;
	}

	public String getSPLAN_CR_UID() {
		return SPLAN_CR_UID;
	}

	public void setSPLAN_CR_UID(String sPLAN_CR_UID) {
		SPLAN_CR_UID = sPLAN_CR_UID;
	}

	public Date getSPLAN_UPD_DT() {
		return SPLAN_UPD_DT;
	}

	public void setSPLAN_UPD_DT(Date sPLAN_UPD_DT) {
		SPLAN_UPD_DT = sPLAN_UPD_DT;
	}

	public String getSPLAN_UPD_UID() {
		return SPLAN_UPD_UID;
	}

	public void setSPLAN_UPD_UID(String sPLAN_UPD_UID) {
		SPLAN_UPD_UID = sPLAN_UPD_UID;
	}
	
	
	
}
