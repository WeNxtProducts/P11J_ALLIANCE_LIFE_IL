package com.iii.pel.forms.PILM202;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_AGE_SLAB")
public class PM_IL_AGE_SLAB extends BaseValueBean {

	
	
	@Column(name="AS_FRZ_FLAG")
	private String AS_FRZ_FLAG;

	@Column(name="AS_CODE")
	private String AS_CODE;

	@Column(name="AS_DESC")
	private String AS_DESC;

	@Column(name="AS_SHORT_DESC")
	private String AS_SHORT_DESC;

	@Column(name="AS_LONG_DESC")
	private String AS_LONG_DESC;

	@Column(name="AS_BL_DESC")
	private String AS_BL_DESC;

	@Column(name="AS_BL_SHORT_DESC")
	private String AS_BL_SHORT_DESC;

	@Column(name="AS_BL_LONG_DESC")
	private String AS_BL_LONG_DESC;

	@Column(name="AS_MIN_AGE")
	private int AS_MIN_AGE;

	@Column(name="AS_MAX_AGE")
	private int AS_MAX_AGE;
	
	@Column(name="AS_CR_DT")
	private Date AS_CR_DT;
	
	@Column(name="AS_CR_UID")
	private String AS_CR_UID;
	
	@Column(name="AS_UPD_DT")
	private Date AS_UPD_DT;
	
	@Column(name="AS_UPD_UID")
	private String AS_UPD_UID;
	
	@Id
	@Column(name="ROWID")
	private String ROWID;
	
	private String focusTest;
	
	private boolean CHECK_BOX;
	
	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public String getFocusTest() {
		return focusTest;
	}

	public void setFocusTest(String focusTest) {
		this.focusTest = focusTest;
	}

	public String getAS_FRZ_FLAG() {
		return AS_FRZ_FLAG;
	}

	public void setAS_FRZ_FLAG(String AS_FRZ_FLAG) {
		this.AS_FRZ_FLAG = AS_FRZ_FLAG;
	}

	public String getAS_CODE() {
		return AS_CODE;
	}

	public void setAS_CODE(String AS_CODE) {
		this.AS_CODE = AS_CODE;
	}

	public String getAS_DESC() {
		return AS_DESC;
	}

	public void setAS_DESC(String AS_DESC) {
		this.AS_DESC = AS_DESC;
	}

	public String getAS_SHORT_DESC() {
		return AS_SHORT_DESC;
	}

	public void setAS_SHORT_DESC(String AS_SHORT_DESC) {
		this.AS_SHORT_DESC = AS_SHORT_DESC;
	}

	public String getAS_LONG_DESC() {
		return AS_LONG_DESC;
	}

	public void setAS_LONG_DESC(String AS_LONG_DESC) {
		this.AS_LONG_DESC = AS_LONG_DESC;
	}

	public String getAS_BL_DESC() {
		return AS_BL_DESC;
	}

	public void setAS_BL_DESC(String AS_BL_DESC) {
		this.AS_BL_DESC = AS_BL_DESC;
	}

	public String getAS_BL_SHORT_DESC() {
		return AS_BL_SHORT_DESC;
	}

	public void setAS_BL_SHORT_DESC(String AS_BL_SHORT_DESC) {
		this.AS_BL_SHORT_DESC = AS_BL_SHORT_DESC;
	}

	public String getAS_BL_LONG_DESC() {
		return AS_BL_LONG_DESC;
	}

	public void setAS_BL_LONG_DESC(String AS_BL_LONG_DESC) {
		this.AS_BL_LONG_DESC = AS_BL_LONG_DESC;
	}

	public Date getAS_CR_DT() {
		return AS_CR_DT;
	}

	public void setAS_CR_DT(Date as_cr_dt) {
		AS_CR_DT = as_cr_dt;
	}

	public String getAS_CR_UID() {
		return AS_CR_UID;
	}

	public void setAS_CR_UID(String as_cr_uid) {
		AS_CR_UID = as_cr_uid;
	}

	public Date getAS_UPD_DT() {
		return AS_UPD_DT;
	}

	public void setAS_UPD_DT(Date as_upd_dt) {
		AS_UPD_DT = as_upd_dt;
	}

	public String getAS_UPD_UID() {
		return AS_UPD_UID;
	}

	public void setAS_UPD_UID(String as_upd_uid) {
		AS_UPD_UID = as_upd_uid;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public int getAS_MIN_AGE() {
		return AS_MIN_AGE;
	}

	public void setAS_MIN_AGE(int as_min_age) {
		AS_MIN_AGE = as_min_age;
	}

	public int getAS_MAX_AGE() {
		return AS_MAX_AGE;
	}

	public void setAS_MAX_AGE(int as_max_age) {
		AS_MAX_AGE = as_max_age;
	}
}
