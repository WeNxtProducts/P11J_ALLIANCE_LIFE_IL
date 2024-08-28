package com.iii.pel.forms.PT051_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_AGENT_BUDGET_RANK")
public class PT_AGENT_BUDGET_RANK extends BaseValueBean {

	@Column(name="ABGTR_RANK_CODE")
	private String ABGTR_RANK_CODE;

	private String UI_M_ABGTR_RANK_NAME;

	@Column(name="ABGTR_SHARE_PERC")
	private Double ABGTR_SHARE_PERC;

	@Column(name="ABGTR_SYS_ID")
	private Double ABGTR_SYS_ID;
	
	@Column(name="ABGTR_CR_DT")
	private Date ABGTR_CR_DT;

	@Column(name="ABGTR_CR_UID")
	private String ABGTR_CR_UID;
	
	
	@Column(name="ABGTR_ABGT_SYS_ID")
	private Double ABGTR_ABGT_SYS_ID;
	
	@Column(name="ABGTR_UPD_DT")
	private Date ABGTR_UPD_DT;
	
	@Column(name="ABGTR_UPD_UID")
	private String ABGTR_UPD_UID;
	
	private boolean checkBoxSelected;
	

	public String getABGTR_RANK_CODE() {
		return ABGTR_RANK_CODE;
	}

	public void setABGTR_RANK_CODE(String ABGTR_RANK_CODE) {
		this.ABGTR_RANK_CODE = ABGTR_RANK_CODE;
	}

	public String getUI_M_ABGTR_RANK_NAME() {
		return UI_M_ABGTR_RANK_NAME;
	}

	public void setUI_M_ABGTR_RANK_NAME(String UI_M_ABGTR_RANK_NAME) {
		this.UI_M_ABGTR_RANK_NAME = UI_M_ABGTR_RANK_NAME;
	}

	public Double getABGTR_SHARE_PERC() {
		return ABGTR_SHARE_PERC;
	}

	public void setABGTR_SHARE_PERC(Double ABGTR_SHARE_PERC) {
		this.ABGTR_SHARE_PERC = ABGTR_SHARE_PERC;
	}

	public Double getABGTR_SYS_ID() {
		return ABGTR_SYS_ID;
	}

	public void setABGTR_SYS_ID(Double abgtr_sys_id) {
		ABGTR_SYS_ID = abgtr_sys_id;
	}

	public String getABGTR_CR_UID() {
		return ABGTR_CR_UID;
	}

	public void setABGTR_CR_UID(String abgtr_cr_uid) {
		ABGTR_CR_UID = abgtr_cr_uid;
	}

	public Double getABGTR_ABGT_SYS_ID() {
		return ABGTR_ABGT_SYS_ID;
	}

	public void setABGTR_ABGT_SYS_ID(Double abgtr_abgt_sys_id) {
		ABGTR_ABGT_SYS_ID = abgtr_abgt_sys_id;
	}



	public Date getABGTR_CR_DT() {
		return ABGTR_CR_DT;
	}

	public void setABGTR_CR_DT(Date abgtr_cr_dt) {
		ABGTR_CR_DT = abgtr_cr_dt;
	}

	public Date getABGTR_UPD_DT() {
		return ABGTR_UPD_DT;
	}

	public void setABGTR_UPD_DT(Date abgtr_upd_dt) {
		ABGTR_UPD_DT = abgtr_upd_dt;
	}

	public String getABGTR_UPD_UID() {
		return ABGTR_UPD_UID;
	}

	public void setABGTR_UPD_UID(String abgtr_upd_uid) {
		ABGTR_UPD_UID = abgtr_upd_uid;
	}

	public boolean isCheckBoxSelected() {
		return checkBoxSelected;
	}

	public void setCheckBoxSelected(boolean checkBoxSelected) {
		this.checkBoxSelected = checkBoxSelected;
	}


}
