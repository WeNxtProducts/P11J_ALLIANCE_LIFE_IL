package com.iii.pel.forms.PT044_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_AGENT_CHKLST_STATUS")
public class PT_AGENT_CHKLST_STATUS extends BaseValueBean {

	private static final long serialVersionUID = 1L;

	@Column(name="ACS_SR_NO")
	private Double ACS_SR_NO;

	@Column(name="ACS_TODO_LIST_ITEM")
	private String ACS_TODO_LIST_ITEM;

	@Column(name="ACS_MANDATORY_YN")
	private String ACS_MANDATORY_YN;

	@Column(name="ACS_APPR_STS")
	private String ACS_APPR_STS;

	@Column(name="ACS_REMARKS")
	private String ACS_REMARKS;

	@Column(name="ACS_SYS_ID")
	private int ACS_SYS_ID;

	@Column(name="ACS_ATH_SYS_ID")
	private int ACS_ATH_SYS_ID;

	@Column(name="ACS_CR_DT")
	private Date ACS_CR_DT;

	@Column(name="ACS_CR_UID")
	private String ACS_CR_UID;

	@Column(name="ACS_UPD_DT")
	private Date ACS_UPD_DT;

	@Column(name="ACS_UPD_UID")
	private String ACS_UPD_UID;
	
	private boolean CHECK_BOX;
	
	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public Double getACS_SR_NO() {
		return ACS_SR_NO;
	}

	public void setACS_SR_NO(Double ACS_SR_NO) {
		this.ACS_SR_NO = ACS_SR_NO;
	}

	public String getACS_TODO_LIST_ITEM() {
		return ACS_TODO_LIST_ITEM;
	}

	public void setACS_TODO_LIST_ITEM(String ACS_TODO_LIST_ITEM) {
		this.ACS_TODO_LIST_ITEM = ACS_TODO_LIST_ITEM;
	}

	public String getACS_MANDATORY_YN() {
		return ACS_MANDATORY_YN;
	}

	public void setACS_MANDATORY_YN(String ACS_MANDATORY_YN) {
		this.ACS_MANDATORY_YN = ACS_MANDATORY_YN;
	}

	public String getACS_APPR_STS() {
		return ACS_APPR_STS;
	}

	public void setACS_APPR_STS(String ACS_APPR_STS) {
		this.ACS_APPR_STS = ACS_APPR_STS;
	}

	public String getACS_REMARKS() {
		return ACS_REMARKS;
	}

	public void setACS_REMARKS(String ACS_REMARKS) {
		this.ACS_REMARKS = ACS_REMARKS;
	}

	public int getACS_SYS_ID() {
		return ACS_SYS_ID;
	}

	public void setACS_SYS_ID(int acs_sys_id) {
		ACS_SYS_ID = acs_sys_id;
	}

	public int getACS_ATH_SYS_ID() {
		return ACS_ATH_SYS_ID;
	}

	public void setACS_ATH_SYS_ID(int acs_ath_sys_id) {
		ACS_ATH_SYS_ID = acs_ath_sys_id;
	}

	public Date getACS_CR_DT() {
		return ACS_CR_DT;
	}

	public void setACS_CR_DT(Date acs_cr_dt) {
		ACS_CR_DT = acs_cr_dt;
	}

	public String getACS_CR_UID() {
		return ACS_CR_UID;
	}

	public void setACS_CR_UID(String acs_cr_uid) {
		ACS_CR_UID = acs_cr_uid;
	}

	public Date getACS_UPD_DT() {
		return ACS_UPD_DT;
	}

	public void setACS_UPD_DT(Date acs_upd_dt) {
		ACS_UPD_DT = acs_upd_dt;
	}

	public String getACS_UPD_UID() {
		return ACS_UPD_UID;
	}

	public void setACS_UPD_UID(String acs_upd_uid) {
		ACS_UPD_UID = acs_upd_uid;
	}
}
