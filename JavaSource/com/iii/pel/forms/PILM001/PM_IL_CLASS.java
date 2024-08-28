package com.iii.pel.forms.PILM001;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="PM_IL_CLASS")
public class PM_IL_CLASS extends BaseValueBean 
{

	@Column(name="CLASS_BL_NAME")
	private String CLASS_BL_NAME;

	@Column(name="CLASS_BL_SHORT_NAME")
	private String CLASS_BL_SHORT_NAME;

	@Column(name="CLASS_CODE")
	private String CLASS_CODE;

	@Column(name="CLASS_NAME")
	private String CLASS_NAME;

	@Column(name="CLASS_SHORT_NAME")
	private String CLASS_SHORT_NAME;

	@Column(name="CLASS_FACIN_YN")
	private String CLASS_FACIN_YN;

	@Column(name="CLASS_FRZ_FLAG")
	private String CLASS_FRZ_FLAG = "N";
	
	@Column(name="CLASS_CR_DT")
	private Date CLASS_CR_DT;
	
	@Column(name="CLASS_CR_UID")
	private String CLASS_CR_UID;
	
	@Column(name="CLASS_UPD_DT")
	private Date CLASS_UPD_DT;
	
	@Column(name="CLASS_UPD_UID")
	private String CLASS_UPD_UID;
	
	private boolean rendered=false;

	private boolean insertMode=true;
	
	private boolean UI_CLASS_FRZ_FLAG;
	
	private boolean selected;

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getCLASS_BL_NAME() {
		return CLASS_BL_NAME;
	}

	public void setCLASS_BL_NAME(String CLASS_BL_NAME) {
		this.CLASS_BL_NAME = CLASS_BL_NAME;
	}

	public String getCLASS_BL_SHORT_NAME() {
		return CLASS_BL_SHORT_NAME;
	}

	public void setCLASS_BL_SHORT_NAME(String CLASS_BL_SHORT_NAME) {
		this.CLASS_BL_SHORT_NAME = CLASS_BL_SHORT_NAME;
	}

	public String getCLASS_CODE() {
		return CLASS_CODE;
	}

	public void setCLASS_CODE(String CLASS_CODE) {
		this.CLASS_CODE = CLASS_CODE;
	}

	public String getCLASS_NAME() {
		return CLASS_NAME;
	}

	public void setCLASS_NAME(String CLASS_NAME) {
		this.CLASS_NAME = CLASS_NAME;
	}

	public String getCLASS_SHORT_NAME() {
		return CLASS_SHORT_NAME;
	}

	public void setCLASS_SHORT_NAME(String CLASS_SHORT_NAME) {
		this.CLASS_SHORT_NAME = CLASS_SHORT_NAME;
	}

	public String getCLASS_FACIN_YN() {
		return CLASS_FACIN_YN;
	}

	public void setCLASS_FACIN_YN(String CLASS_FACIN_YN) {
		this.CLASS_FACIN_YN = CLASS_FACIN_YN;
	}

	public String getCLASS_FRZ_FLAG() {
		
		return CLASS_FRZ_FLAG;
	}

	public void setCLASS_FRZ_FLAG(String CLASS_FRZ_FLAG) {
		UI_CLASS_FRZ_FLAG = CommonUtils.stringToBooleanConvertor(CLASS_FRZ_FLAG);
		this.CLASS_FRZ_FLAG = CLASS_FRZ_FLAG;
	}

	
	public String getCLASS_CR_UID() {
		return CLASS_CR_UID;
	}

	public boolean isRendered() {
		return rendered;
	}

	
	public void setCLASS_CR_UID(String class_cr_uid) {
		CLASS_CR_UID = class_cr_uid;
	}

	public void setRendered(boolean rendered) {
		this.rendered = rendered;
	}

	public boolean isInsertMode() {
		return insertMode;
	}

	public void setInsertMode(boolean insertMode) {
		this.insertMode = insertMode;
	}

	public Date getCLASS_CR_DT() {
		return CLASS_CR_DT;
	}

	public void setCLASS_CR_DT(Date class_cr_dt) {
		CLASS_CR_DT = class_cr_dt;
	}

	public Date getCLASS_UPD_DT() {
		return CLASS_UPD_DT;
	}

	public void setCLASS_UPD_DT(Date class_upd_dt) {
		CLASS_UPD_DT = class_upd_dt;
	}

	public String getCLASS_UPD_UID() {
		return CLASS_UPD_UID;
	}

	public void setCLASS_UPD_UID(String class_upd_uid) {
		CLASS_UPD_UID = class_upd_uid;
	}

	public boolean isUI_CLASS_FRZ_FLAG() {
		return UI_CLASS_FRZ_FLAG;
	}

	public void setUI_CLASS_FRZ_FLAG(boolean ui_class_frz_flag) {
		CLASS_FRZ_FLAG = CommonUtils.booleanToStriingConvertor(ui_class_frz_flag);
		UI_CLASS_FRZ_FLAG = ui_class_frz_flag;
	}
}
