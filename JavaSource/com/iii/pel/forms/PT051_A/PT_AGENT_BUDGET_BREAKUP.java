package com.iii.pel.forms.PT051_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_AGENT_BUDGET_BREAKUP")
public class PT_AGENT_BUDGET_BREAKUP extends BaseValueBean {

	@Column(name="ABGTB_AGENT_CODE")
	private String ABGTB_AGENT_CODE;

	private String UI_M_ABGTB_AGENT_NAME;

	@Column(name="ABGTB_SHARE_PERC")
	private Double ABGTB_SHARE_PERC;

	@Column(name="ABGTB_NO_OF_POL")
	private Double ABGTB_NO_OF_POL;

	@Column(name="ABGTB_LC_PREM")
	private Double ABGTB_LC_PREM;

	@Column(name="ABGTB_ACT_NO_OF_POL")
	private Double ABGTB_ACT_NO_OF_POL;

	@Column(name="ABGTB_ACT_LC_PREM")
	private Double ABGTB_ACT_LC_PREM;

	@Column(name="ABGTB_SYS_ID")
	private Double ABGTB_SYS_ID;

	@Column(name="ABGTB_CR_DT")
	private Date ABGTB_CR_DT;

	@Column(name="ABGTB_CR_UID")
	private String ABGTB_CR_UID;
	
	
	@Column(name="ABGTB_ABGT_SYS_ID")
	private Double ABGTB_ABGT_SYS_ID;
	
	@Column(name="ABGTB_UPD_DT")
	private Date ABGTB_UPD_DT;
	
	@Column(name="ABGTB_UPD_UID")
	private String ABGTB_UPD_UID;
	
	private boolean checkBoxSelected;

	public String getABGTB_AGENT_CODE() {
		return ABGTB_AGENT_CODE;
	}

	public void setABGTB_AGENT_CODE(String ABGTB_AGENT_CODE) {
		this.ABGTB_AGENT_CODE = ABGTB_AGENT_CODE;
	}

	public String getUI_M_ABGTB_AGENT_NAME() {
		return UI_M_ABGTB_AGENT_NAME;
	}

	public void setUI_M_ABGTB_AGENT_NAME(String UI_M_ABGTB_AGENT_NAME) {
		this.UI_M_ABGTB_AGENT_NAME = UI_M_ABGTB_AGENT_NAME;
	}

	public Double getABGTB_SHARE_PERC() {
		return ABGTB_SHARE_PERC;
	}

	public void setABGTB_SHARE_PERC(Double ABGTB_SHARE_PERC) {
		this.ABGTB_SHARE_PERC = ABGTB_SHARE_PERC;
	}

	public Double getABGTB_NO_OF_POL() {
		return ABGTB_NO_OF_POL;
	}

	public void setABGTB_NO_OF_POL(Double ABGTB_NO_OF_POL) {
		this.ABGTB_NO_OF_POL = ABGTB_NO_OF_POL;
	}

	public Double getABGTB_LC_PREM() {
		return ABGTB_LC_PREM;
	}

	public void setABGTB_LC_PREM(Double ABGTB_LC_PREM) {
		this.ABGTB_LC_PREM = ABGTB_LC_PREM;
	}

	public Double getABGTB_ACT_NO_OF_POL() {
		return ABGTB_ACT_NO_OF_POL;
	}

	public void setABGTB_ACT_NO_OF_POL(Double ABGTB_ACT_NO_OF_POL) {
		this.ABGTB_ACT_NO_OF_POL = ABGTB_ACT_NO_OF_POL;
	}

	public Double getABGTB_ACT_LC_PREM() {
		return ABGTB_ACT_LC_PREM;
	}

	public void setABGTB_ACT_LC_PREM(Double ABGTB_ACT_LC_PREM) {
		this.ABGTB_ACT_LC_PREM = ABGTB_ACT_LC_PREM;
	}

	public Double getABGTB_SYS_ID() {
		return ABGTB_SYS_ID;
	}

	public void setABGTB_SYS_ID(Double abgtb_sys_id) {
		ABGTB_SYS_ID = abgtb_sys_id;
	}

	public Date getABGTB_CR_DT() {
		return ABGTB_CR_DT;
	}

	public void setABGTB_CR_DT(Date abgtb_cr_dt) {
		ABGTB_CR_DT = abgtb_cr_dt;
	}

	public String getABGTB_CR_UID() {
		return ABGTB_CR_UID;
	}

	public void setABGTB_CR_UID(String abgtb_cr_uid) {
		ABGTB_CR_UID = abgtb_cr_uid;
	}

	public Double getABGTB_ABGT_SYS_ID() {
		return ABGTB_ABGT_SYS_ID;
	}

	public void setABGTB_ABGT_SYS_ID(Double abgtb_abgt_sys_id) {
		ABGTB_ABGT_SYS_ID = abgtb_abgt_sys_id;
	}

	public Date getABGTB_UPD_DT() {
		return ABGTB_UPD_DT;
	}

	public void setABGTB_UPD_DT(Date abgtb_upd_dt) {
		ABGTB_UPD_DT = abgtb_upd_dt;
	}

	public String getABGTB_UPD_UID() {
		return ABGTB_UPD_UID;
	}

	public void setABGTB_UPD_UID(String abgtb_upd_uid) {
		ABGTB_UPD_UID = abgtb_upd_uid;
	}

	public boolean isCheckBoxSelected() {
		return checkBoxSelected;
	}

	public void setCheckBoxSelected(boolean checkBoxSelected) {
		this.checkBoxSelected = checkBoxSelected;
	}
}
