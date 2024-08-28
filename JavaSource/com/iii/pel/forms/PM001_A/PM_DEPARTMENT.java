package com.iii.pel.forms.PM001_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="PM_DEPARTMENT")

public class PM_DEPARTMENT extends BaseValueBean {

	@Column(name="DEPT_CODE")
	private String DEPT_CODE;

	@Column(name="DEPT_DIVN_CODE")
	private String DEPT_DIVN_CODE;

	@Column(name="DEPT_NAME")
	private String DEPT_NAME;

	@Column(name="DEPT_SHORT_NAME")
	private String DEPT_SHORT_NAME;

	@Column(name="DEPT_MGR_NAME")
	private String DEPT_MGR_NAME;

	@Column(name="DEPT_BL_NAME")
	private String DEPT_BL_NAME;

	@Column(name="DEPT_BL_SHORT_NAME")
	private String DEPT_BL_SHORT_NAME;

	@Column(name="DEPT_BL_MGR_NAME")
	private String DEPT_BL_MGR_NAME;

	@Column(name="DEPT_FRZ_FLAG")
	private String DEPT_FRZ_FLAG = "N";

	@Column(name="DEPT_CR_DT")
	private Date DEPT_CR_DT;

	@Column(name="DEPT_CR_UID")
	private String DEPT_CR_UID;

	@Column(name="DEPT_UPD_DT")
	private Date DEPT_UPD_DT;

	@Column(name="DEPT_UPD_UID")
	private String DEPT_UPD_UID;

	@Column(name="DEPT_COMP_CODE")
	private String DEPT_COMP_CODE;
	
	private boolean UI_DEPT_FRZ_FLAG;
	
	public boolean isUI_DEPT_FRZ_FLAG() {
		return UI_DEPT_FRZ_FLAG;
	}
	public void setUI_DEPT_FRZ_FLAG(boolean ui_dept_frz_flag) {
		DEPT_FRZ_FLAG = CommonUtils.booleanToStriingConvertor(ui_dept_frz_flag);
		UI_DEPT_FRZ_FLAG = ui_dept_frz_flag;
	}
	public void setDEPT_BL_MGR_NAME(String DEPT_BL_MGR_NAME) {
		this.DEPT_BL_MGR_NAME = DEPT_BL_MGR_NAME;
	}
	public String getDEPT_BL_MGR_NAME() {
		 return DEPT_BL_MGR_NAME;
	}
	public void setDEPT_UPD_DT(Date DEPT_UPD_DT) {
		this.DEPT_UPD_DT = DEPT_UPD_DT;
	}
	public Date getDEPT_UPD_DT() {
		 return DEPT_UPD_DT;
	}
	public void setDEPT_SHORT_NAME(String DEPT_SHORT_NAME) {
		this.DEPT_SHORT_NAME = DEPT_SHORT_NAME;
	}
	public String getDEPT_SHORT_NAME() {
		 return DEPT_SHORT_NAME;
	}
	public void setDEPT_MGR_NAME(String DEPT_MGR_NAME) {
		this.DEPT_MGR_NAME = DEPT_MGR_NAME;
	}
	public String getDEPT_MGR_NAME() {
		 return DEPT_MGR_NAME;
	}
	public void setDEPT_CODE(String DEPT_CODE) {
		this.DEPT_CODE = DEPT_CODE;
	}
	public String getDEPT_CODE() {
		 return DEPT_CODE;
	}
	public void setDEPT_CR_DT(Date DEPT_CR_DT) {
		this.DEPT_CR_DT = DEPT_CR_DT;
	}
	public Date getDEPT_CR_DT() {
		 return DEPT_CR_DT;
	}
	public void setDEPT_NAME(String DEPT_NAME) {
		this.DEPT_NAME = DEPT_NAME;
	}
	public String getDEPT_NAME() {
		 return DEPT_NAME;
	}
	public void setDEPT_UPD_UID(String DEPT_UPD_UID) {
		this.DEPT_UPD_UID = DEPT_UPD_UID;
	}
	public String getDEPT_UPD_UID() {
		 return DEPT_UPD_UID;
	}
	public void setDEPT_CR_UID(String DEPT_CR_UID) {
		this.DEPT_CR_UID = DEPT_CR_UID;
	}
	public String getDEPT_CR_UID() {
		 return DEPT_CR_UID;
	}
	public void setDEPT_COMP_CODE(String DEPT_COMP_CODE) {
		this.DEPT_COMP_CODE = DEPT_COMP_CODE;
	}
	public String getDEPT_COMP_CODE() {
		 return DEPT_COMP_CODE;
	}
	public void setDEPT_DIVN_CODE(String DEPT_DIVN_CODE) {
		this.DEPT_DIVN_CODE = DEPT_DIVN_CODE;
	}
	public String getDEPT_DIVN_CODE() {
		 return DEPT_DIVN_CODE;
	}
	public void setDEPT_BL_NAME(String DEPT_BL_NAME) {
		this.DEPT_BL_NAME = DEPT_BL_NAME;
	}
	public String getDEPT_BL_NAME() {
		 return DEPT_BL_NAME;
	}
	public void setDEPT_FRZ_FLAG(String DEPT_FRZ_FLAG) {
		UI_DEPT_FRZ_FLAG = CommonUtils.stringToBooleanConvertor(DEPT_FRZ_FLAG);
		this.DEPT_FRZ_FLAG = DEPT_FRZ_FLAG;
	}
	public String getDEPT_FRZ_FLAG() {
		 return DEPT_FRZ_FLAG;
	}
	public void setDEPT_BL_SHORT_NAME(String DEPT_BL_SHORT_NAME) {
		this.DEPT_BL_SHORT_NAME = DEPT_BL_SHORT_NAME;
	}
	public String getDEPT_BL_SHORT_NAME() {
		 return DEPT_BL_SHORT_NAME;
	}

}