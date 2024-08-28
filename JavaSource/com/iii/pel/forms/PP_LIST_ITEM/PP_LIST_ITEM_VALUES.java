package com.iii.pel.forms.PP_LIST_ITEM;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PP_LIST_ITEM_VALUES")
public class PP_LIST_ITEM_VALUES extends BaseValueBean{
	
	@Column(name="LIV_SYS_PARAM")
	private String LIV_SYS_PARAM;
	
	@Column(name="LIV_DESC")
	private String LIV_DESC;
	
	@Column(name="LIV_CODE")
	private String LIV_CODE;
	
	@Column(name="LIV_CODE_DESC")
	private String LIV_CODE_DESC;
	
	@Column(name="LIV_BL_CODE_DESC")
	private String LIV_BL_CODE_DESC;
	
	@Column(name="LIV_CR_DT")
	private Date LIV_CR_DT;
	
	@Column(name="LIV_CR_UID")
	private String LIV_CR_UID;
	
	@Column(name="LIV_UPD_DT")
	private Date LIV_UPD_DT;
	
	@Column(name="LIV_UPD_UID")
	private String LIV_UPD_UID;
	
	@Column(name="LIV_REQD_YN")
	private String LIV_REQD_YN;
	
	private String ROWID;
	
	private boolean checkBoxSelected = false;
	
	public String getLIV_SYS_PARAM() {
		return LIV_SYS_PARAM;
	}

	public void setLIV_SYS_PARAM(String liv_sys_param) {
		LIV_SYS_PARAM = liv_sys_param;
	}

	public String getLIV_DESC() {
		return LIV_DESC;
	}

	public void setLIV_DESC(String liv_desc) {
		LIV_DESC = liv_desc;
	}

	public String getLIV_CODE() {
		return LIV_CODE;
	}

	public void setLIV_CODE(String liv_code) {
		LIV_CODE = liv_code;
	}

	public String getLIV_CODE_DESC() {
		return LIV_CODE_DESC;
	}

	public void setLIV_CODE_DESC(String liv_code_desc) {
		LIV_CODE_DESC = liv_code_desc;
	}

	public String getLIV_BL_CODE_DESC() {
		return LIV_BL_CODE_DESC;
	}

	public void setLIV_BL_CODE_DESC(String liv_bl_code_desc) {
		LIV_BL_CODE_DESC = liv_bl_code_desc;
	}
	public Date getLIV_CR_DT() {
		return LIV_CR_DT;
	}

	public void setLIV_CR_DT(Date liv_cr_dt) {
		LIV_CR_DT = liv_cr_dt;
	}

	public String getLIV_CR_UID() {
		return LIV_CR_UID;
	}

	public void setLIV_CR_UID(String liv_cr_uid) {
		LIV_CR_UID = liv_cr_uid;
	}

	public Date getLIV_UPD_DT() {
		return LIV_UPD_DT;
	}

	public void setLIV_UPD_DT(Date liv_upd_dt) {
		LIV_UPD_DT = liv_upd_dt;
	}

	public String getLIV_UPD_UID() {
		return LIV_UPD_UID;
	}

	public void setLIV_UPD_UID(String liv_upd_uid) {
		LIV_UPD_UID = liv_upd_uid;
	}

	public String getLIV_REQD_YN() {
		return LIV_REQD_YN;
	}

	public void setLIV_REQD_YN(String liv_reqd_yn) {
		LIV_REQD_YN = liv_reqd_yn;
	}

	public boolean isCheckBoxSelected() {
		return checkBoxSelected;
	}

	public void setCheckBoxSelected(boolean checkBoxSelected) {
		this.checkBoxSelected = checkBoxSelected;
	}

	/**
	 * @return the rOWID
	 */
	public String getROWID() {
		return ROWID;
	}

	/**
	 * @param rowid the rOWID to set
	 */
	public void setROWID(String rowid) {
		ROWID = rowid;
	}
}
