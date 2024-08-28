package com.iii.pel.forms.PM092_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_AGENT_CONTEST_APPL_RANK")
public class PM_AGENT_CONTEST_APPL_RANK extends BaseValueBean {

	@Column(name="ACAR_ACH_CODE")
	private String  ACAR_ACH_CODE;
	@Column(name="ACAR_RANK_CODE")
	private String  ACAR_RANK_CODE;
	@Column(name="ACAR_CR_DT")
	private Date  ACAR_CR_DT;
	@Column(name="ACAR_CR_UID")
	private String  ACAR_CR_UID;
	@Column(name="ACAR_UPD_DT")
	private Date  ACAR_UPD_DT;
	@Column(name="ACAR_UPD_UID")
	private String  ACAR_UPD_UID;
	
	private String UI_M_ACAR_RANK_CODE_DESC;
	private boolean rowCheckBox;


	
	public PM_AGENT_CONTEST_APPL_RANK() {
	//TODO hard coded values to be removed and handled in preinsert
		this.ACAR_CR_DT=new Date();
		this.ACAR_CR_UID="LIFEALL";
		this.ACAR_UPD_DT=new Date();
		this.ACAR_UPD_UID="LIFEALL";
	}

	public String getACAR_RANK_CODE() {
		return ACAR_RANK_CODE;
	}

	public void setACAR_RANK_CODE(String ACAR_RANK_CODE) {
		this.ACAR_RANK_CODE = ACAR_RANK_CODE;
	}

	public String getUI_M_ACAR_RANK_CODE_DESC() {
		return UI_M_ACAR_RANK_CODE_DESC;
	}

	public void setUI_M_ACAR_RANK_CODE_DESC(String UI_M_ACAR_RANK_CODE_DESC) {
		this.UI_M_ACAR_RANK_CODE_DESC = UI_M_ACAR_RANK_CODE_DESC;
	}

	public String getACAR_ACH_CODE() {
		return ACAR_ACH_CODE;
	}

	public void setACAR_ACH_CODE(String acar_ach_code) {
		ACAR_ACH_CODE = acar_ach_code;
	}

	public Date getACAR_CR_DT() {
		return ACAR_CR_DT;
	}

	public void setACAR_CR_DT(Date acar_cr_dt) {
		ACAR_CR_DT = acar_cr_dt;
	}

	public String getACAR_CR_UID() {
		return ACAR_CR_UID;
	}

	public void setACAR_CR_UID(String acar_cr_uid) {
		ACAR_CR_UID = acar_cr_uid;
	}

	public Date getACAR_UPD_DT() {
		return ACAR_UPD_DT;
	}

	public void setACAR_UPD_DT(Date acar_upd_dt) {
		ACAR_UPD_DT = acar_upd_dt;
	}

	public String getACAR_UPD_UID() {
		return ACAR_UPD_UID;
	}

	public void setACAR_UPD_UID(String acar_upd_uid) {
		ACAR_UPD_UID = acar_upd_uid;
	}

	public boolean isRowCheckBox() {
		return rowCheckBox;
	}

	public void setRowCheckBox(boolean rowCheckBox) {
		this.rowCheckBox = rowCheckBox;
	}
}
