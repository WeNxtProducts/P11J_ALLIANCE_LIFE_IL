package com.iii.pel.forms.PILM200;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_PROD_GROUP_HDR")
public class PM_IL_PROD_GROUP_HDR extends BaseValueBean {

	@Column(name="PGH_FRZ_FLAG")
	private String PGH_FRZ_FLAG;

	@Column(name="PGH_GROUP_CODE")
	private String PGH_GROUP_CODE;

	@Column(name="PGH_DESC")
	private String PGH_DESC;

	@Column(name="PGH_SHORT_DESC")
	private String PGH_SHORT_DESC;

	@Column(name="PGH_APPL_PLAN_CODE")
	private String PGH_APPL_PLAN_CODE;

	private String UI_M_APPL_PLAN_DESC;

	@Column(name="PGH_LONG_DESC")
	private String PGH_LONG_DESC;

	@Column(name="PGH_BL_DESC")
	private String PGH_BL_DESC;

	@Column(name="PGH_BL_SHORT_DESC")
	private String PGH_BL_SHORT_DESC;

	@Column(name="PGH_BL_LONG_DESC")
	private String PGH_BL_LONG_DESC;

	@Column(name="PGH_CR_DT")
	private Date PGH_CR_DT;
	
	@Column(name="PGH_CR_UID")
	private String PGH_CR_UID;

	private String UI_M_PLAN_TYPE;
	
	@Column(name="PGH_UPD_DT")
	private Date PGH_UPD_DT;
	
	@Column(name="PGH_UPD_UID")
	private String PGH_UPD_UID;
	
	private boolean PGH_FREEZE_FLAG;
	

	public String getPGH_FRZ_FLAG() {
		return PGH_FRZ_FLAG;
	}

	public void setPGH_FRZ_FLAG(String PGH_FRZ_FLAG) {
		this.PGH_FRZ_FLAG = PGH_FRZ_FLAG;
		if("Y".equals(PGH_FRZ_FLAG))
			PGH_FREEZE_FLAG = true;
		else
			PGH_FREEZE_FLAG = false;
	}

	public String getPGH_GROUP_CODE() {
		return PGH_GROUP_CODE;
	}

	public void setPGH_GROUP_CODE(String PGH_GROUP_CODE) {
		this.PGH_GROUP_CODE = PGH_GROUP_CODE;
	}

	public String getPGH_DESC() {
		return PGH_DESC;
	}

	public void setPGH_DESC(String PGH_DESC) {
		this.PGH_DESC = PGH_DESC;
	}

	public String getPGH_SHORT_DESC() {
		return PGH_SHORT_DESC;
	}

	public void setPGH_SHORT_DESC(String PGH_SHORT_DESC) {
		this.PGH_SHORT_DESC = PGH_SHORT_DESC;
	}

	public String getPGH_APPL_PLAN_CODE() {
		return PGH_APPL_PLAN_CODE;
	}

	public void setPGH_APPL_PLAN_CODE(String PGH_APPL_PLAN_CODE) {
		this.PGH_APPL_PLAN_CODE = PGH_APPL_PLAN_CODE;
	}

	public String getUI_M_APPL_PLAN_DESC() {
		return UI_M_APPL_PLAN_DESC;
	}

	public void setUI_M_APPL_PLAN_DESC(String UI_M_APPL_PLAN_DESC) {
		this.UI_M_APPL_PLAN_DESC = UI_M_APPL_PLAN_DESC;
	}

	public String getPGH_LONG_DESC() {
		return PGH_LONG_DESC;
	}

	public void setPGH_LONG_DESC(String PGH_LONG_DESC) {
		this.PGH_LONG_DESC = PGH_LONG_DESC;
	}

	public String getPGH_BL_DESC() {
		return PGH_BL_DESC;
	}

	public void setPGH_BL_DESC(String PGH_BL_DESC) {
		this.PGH_BL_DESC = PGH_BL_DESC;
	}

	public String getPGH_BL_SHORT_DESC() {
		return PGH_BL_SHORT_DESC;
	}

	public void setPGH_BL_SHORT_DESC(String PGH_BL_SHORT_DESC) {
		this.PGH_BL_SHORT_DESC = PGH_BL_SHORT_DESC;
	}

	public String getPGH_BL_LONG_DESC() {
		return PGH_BL_LONG_DESC;
	}

	public void setPGH_BL_LONG_DESC(String PGH_BL_LONG_DESC) {
		this.PGH_BL_LONG_DESC = PGH_BL_LONG_DESC;
	}

	public Date getPGH_CR_DT() {
		return PGH_CR_DT;
	}

	public void setPGH_CR_DT(Date pgh_cr_dt) {
		PGH_CR_DT = pgh_cr_dt;
	}

	public String getPGH_CR_UID() {
		return PGH_CR_UID;
	}

	public void setPGH_CR_UID(String pgh_cr_uid) {
		PGH_CR_UID = pgh_cr_uid;
	}

	public boolean isPGH_FREEZE_FLAG() {
		return PGH_FREEZE_FLAG;
	}

	public void setPGH_FREEZE_FLAG(boolean pgh_freeze_flag) {
		this.PGH_FREEZE_FLAG = pgh_freeze_flag;
		if(pgh_freeze_flag)
			this.PGH_FRZ_FLAG="Y";
		else
			this.PGH_FRZ_FLAG="N";
	}

	public Date getPGH_UPD_DT() {
		return PGH_UPD_DT;
	}

	public void setPGH_UPD_DT(Date pgh_upd_dt) {
		PGH_UPD_DT = pgh_upd_dt;
	}

	public String getPGH_UPD_UID() {
		return PGH_UPD_UID;
	}

	public void setPGH_UPD_UID(String pgh_upd_uid) {
		PGH_UPD_UID = pgh_upd_uid;
	}

	public String getUI_M_PLAN_TYPE() {
		return UI_M_PLAN_TYPE;
	}

	public void setUI_M_PLAN_TYPE(String ui_m_plan_type) {
		UI_M_PLAN_TYPE = ui_m_plan_type;
	}

}
