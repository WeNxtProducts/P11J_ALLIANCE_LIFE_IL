package com.iii.pel.forms.PM092_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_AGENT_CONTEST_AWARD")
public class PM_AGENT_CONTEST_AWARD extends BaseValueBean {
	
	@Column(name="ACA_ACH_CODE")
	private String  ACA_ACH_CODE;
	@Column(name="ACA_AWARD_CODE")
	private String  ACA_AWARD_CODE;
	@Column(name="ACA_REMARKS")
	private String  ACA_REMARKS;
	@Column(name="ACA_CR_DT")
	private Date  ACA_CR_DT;
	@Column(name="ACA_CR_UID")
	private String  ACA_CR_UID;
	@Column(name="ACA_UPD_DT")
	private Date  ACA_UPD_DT;
	@Column(name="ACA_UPD_UID")
	private String  ACA_UPD_UID;
	
	private String  UI_M_ACA_AWARD_CODE_DESC;

	private boolean rowCheckBox;
	

	public PM_AGENT_CONTEST_AWARD() {
		//TODO hardcoded values to be removed when implementing preinsert trigger
		this.ACA_CR_DT=new Date();
		this.ACA_CR_UID="LIFEALL";
		this.ACA_UPD_DT=new Date();
		this.ACA_UPD_UID="LIFEALL";
	}
	
	public boolean isRowCheckBox() {
		return rowCheckBox;
	}

	public void setRowCheckBox(boolean rowCheckBox) {
		this.rowCheckBox = rowCheckBox;
	}
	
	public String getACA_AWARD_CODE() {
		return ACA_AWARD_CODE;
	}

	public void setACA_AWARD_CODE(String ACA_AWARD_CODE) {
		this.ACA_AWARD_CODE = ACA_AWARD_CODE;
	}

	public String getUI_M_ACA_AWARD_CODE_DESC() {
		return UI_M_ACA_AWARD_CODE_DESC;
	}

	public void setUI_M_ACA_AWARD_CODE_DESC(String UI_M_ACA_AWARD_CODE_DESC) {
		this.UI_M_ACA_AWARD_CODE_DESC = UI_M_ACA_AWARD_CODE_DESC;
	}

	public String getACA_REMARKS() {
		return ACA_REMARKS;
	}

	public void setACA_REMARKS(String ACA_REMARKS) {
		this.ACA_REMARKS = ACA_REMARKS;
	}

	public String getACA_ACH_CODE() {
		return ACA_ACH_CODE;
	}

	public void setACA_ACH_CODE(String aca_ach_code) {
		ACA_ACH_CODE = aca_ach_code;
	}

	public Date getACA_CR_DT() {
		return ACA_CR_DT;
	}

	public void setACA_CR_DT(Date aca_cr_dt) {
		ACA_CR_DT = aca_cr_dt;
	}

	public String getACA_CR_UID() {
		return ACA_CR_UID;
	}

	public void setACA_CR_UID(String aca_cr_uid) {
		ACA_CR_UID = aca_cr_uid;
	}

	public Date getACA_UPD_DT() {
		return ACA_UPD_DT;
	}

	public void setACA_UPD_DT(Date aca_upd_dt) {
		ACA_UPD_DT = aca_upd_dt;
	}

	public String getACA_UPD_UID() {
		return ACA_UPD_UID;
	}

	public void setACA_UPD_UID(String aca_upd_uid) {
		ACA_UPD_UID = aca_upd_uid;
	}
}
