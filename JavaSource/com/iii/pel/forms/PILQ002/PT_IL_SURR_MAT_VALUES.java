package com.iii.pel.forms.PILQ002;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_SURR_MAT_VALUES")
public class PT_IL_SURR_MAT_VALUES extends BaseValueBean {

	@Column(name="ROWID")
	private String ROWID;
	
	@Column(name="SMV_REF_NO")
	private String SMV_REF_NO;
	
	@Column(name="SMV_FC_GROSS_VALUE")
	private Double SMV_FC_GROSS_VALUE;
	
	@Column(name="SMV_UPD_DT")
	private Date SMV_UPD_DT;
	
	@Column(name="SMV_CR_UID")
	private String SMV_CR_UID;

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public String getSMV_REF_NO() {
		return SMV_REF_NO;
	}

	public void setSMV_REF_NO(String smv_ref_no) {
		SMV_REF_NO = smv_ref_no;
	}

	public Double getSMV_FC_GROSS_VALUE() {
		return SMV_FC_GROSS_VALUE;
	}

	public void setSMV_FC_GROSS_VALUE(Double smv_fc_gross_value) {
		SMV_FC_GROSS_VALUE = smv_fc_gross_value;
	}

	public Date getSMV_UPD_DT() {
		return SMV_UPD_DT;
	}

	public void setSMV_UPD_DT(Date smv_upd_dt) {
		SMV_UPD_DT = smv_upd_dt;
	}

	public String getSMV_CR_UID() {
		return SMV_CR_UID;
	}

	public void setSMV_CR_UID(String smv_cr_uid) {
		SMV_CR_UID = smv_cr_uid;
	}
	
}
