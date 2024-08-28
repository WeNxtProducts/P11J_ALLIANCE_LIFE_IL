package com.iii.pel.forms.PILT012;

import java.util.Date;

import javax.faces.component.html.HtmlSelectBooleanCheckbox;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PS_IL_RI_CLAIM_REG")
public class PS_IL_RI_CLAIM_REG extends BaseValueBean{
	
	@Id
	@Column(name="ROWID")
	private String ROWID;

	@Column(name="RCR_DT")
	private Date RCR_DT;

	@Column(name="RCR_RET_FC_CLM_PAID")
	private Double RCR_RET_FC_CLM_PAID;

	@Column(name="RCR_QS_LC_CLM_PAID")
	private Double RCR_QS_LC_CLM_PAID;

	@Column(name="RCR_1S_FC_CLM_PAID")
	private Double RCR_1S_FC_CLM_PAID;

	@Column(name="RCR_2S_FC_CLM_PAID")
	private Double RCR_2S_FC_CLM_PAID;

	@Column(name="RCR_3S_FC_CLM_PAID")
	private Double RCR_3S_FC_CLM_PAID;

	@Column(name="RCR_CLM_SYS_ID")
	private Double RCR_CLM_SYS_ID;
	
	@Column(name="RCR_TREATY_CODE")
	private String RCR_TREATY_CODE;
	
	@Column(name="RCR_CLASS_CODE")
	private String RCR_CLASS_CODE;
	
	@Column(name="RCR_DIVN_CODE")
	private String RCR_DIVN_CODE;
	
	@Column(name="RCR_PLAN_CODE")
	private String RCR_PLAN_CODE;
	
	@Column(name="RCR_UPD_DT")
	private Date RCR_UPD_DT;
	
	@Column(name="RCR_UPD_UID")
	private String RCR_UPD_UID;
		
	
	private HtmlSelectBooleanCheckbox COMP_RCR_FRZ_FLAG;
	
	
	
	public Date getRCR_DT() {
		 return RCR_DT;
	}

	public void setRCR_DT(Date RCR_DT) {
		this.RCR_DT = RCR_DT;
	}

	public Double getRCR_RET_FC_CLM_PAID() {
		return RCR_RET_FC_CLM_PAID;
	}

	public void setRCR_RET_FC_CLM_PAID(Double RCR_RET_FC_CLM_PAID) {
		this.RCR_RET_FC_CLM_PAID = RCR_RET_FC_CLM_PAID;
	}

	public Double getRCR_QS_LC_CLM_PAID() {
		return RCR_QS_LC_CLM_PAID;
	}

	public void setRCR_QS_LC_CLM_PAID(Double RCR_QS_LC_CLM_PAID) {
		this.RCR_QS_LC_CLM_PAID = RCR_QS_LC_CLM_PAID;
	}

	public Double getRCR_1S_FC_CLM_PAID() {
		return RCR_1S_FC_CLM_PAID;
	}

	public void setRCR_1S_FC_CLM_PAID(Double RCR_1S_FC_CLM_PAID) {
		this.RCR_1S_FC_CLM_PAID = RCR_1S_FC_CLM_PAID;
	}

	public Double getRCR_2S_FC_CLM_PAID() {
		return RCR_2S_FC_CLM_PAID;
	}

	public void setRCR_2S_FC_CLM_PAID(Double RCR_2S_FC_CLM_PAID) {
		this.RCR_2S_FC_CLM_PAID = RCR_2S_FC_CLM_PAID;
	}

	public Double getRCR_3S_FC_CLM_PAID() {
		return RCR_3S_FC_CLM_PAID;
	}

	public void setRCR_3S_FC_CLM_PAID(Double RCR_3S_FC_CLM_PAID) {
		this.RCR_3S_FC_CLM_PAID = RCR_3S_FC_CLM_PAID;
	}

	public Double getRCR_CLM_SYS_ID() {
		return RCR_CLM_SYS_ID;
	}

	public void setRCR_CLM_SYS_ID(Double rcr_clm_sys_id) {
		RCR_CLM_SYS_ID = rcr_clm_sys_id;
	}

	public String getRCR_TREATY_CODE() {
		return RCR_TREATY_CODE;
	}

	public void setRCR_TREATY_CODE(String rcr_treaty_code) {
		RCR_TREATY_CODE = rcr_treaty_code;
	}

	public String getRCR_CLASS_CODE() {
		return RCR_CLASS_CODE;
	}

	public void setRCR_CLASS_CODE(String rcr_class_code) {
		RCR_CLASS_CODE = rcr_class_code;
	}

	public String getRCR_DIVN_CODE() {
		return RCR_DIVN_CODE;
	}

	public void setRCR_DIVN_CODE(String rcr_divn_code) {
		RCR_DIVN_CODE = rcr_divn_code;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	
	public Date getRCR_UPD_DT() {
		return RCR_UPD_DT;
	}

	/**
	 * @param rcr_upd_dt the rCR_UPD_DT to set
	 */
	public void setRCR_UPD_DT(Date rcr_upd_dt) {
		RCR_UPD_DT = rcr_upd_dt;
	}

	/**
	 * @param rcr_upd_uid the rCR_UPD_UID to set
	 */
	public void setRCR_UPD_UID(String rcr_upd_uid) {
		RCR_UPD_UID = rcr_upd_uid;
	}

	

	/**
	 * @return the rCR_PLAN_CODE
	 */
	public String getRCR_PLAN_CODE() {
		return RCR_PLAN_CODE;
	}

	/**
	 * @param rcr_plan_code the rCR_PLAN_CODE to set
	 */
	public void setRCR_PLAN_CODE(String rcr_plan_code) {
		RCR_PLAN_CODE = rcr_plan_code;
	}

	/**
	 * @return the rCR_UPD_UID
	 */
	public String getRCR_UPD_UID() {
		return RCR_UPD_UID;
	}

	
}
