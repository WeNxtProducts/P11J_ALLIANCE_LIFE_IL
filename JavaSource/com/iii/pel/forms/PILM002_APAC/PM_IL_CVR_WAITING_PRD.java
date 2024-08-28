package com.iii.pel.forms.PILM002_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_CVR_WAITING_PRD")
public class PM_IL_CVR_WAITING_PRD extends BaseValueBean {

	@Column(name="CWP_ILLNESS_TYP")
	private String CWP_ILLNESS_TYP;

	@Column(name="CWP_WAITING_PRD")
	private Double CWP_WAITING_PRD;

	@Column(name="CWP_FREEZE_FLAG")
	private String CWP_FREEZE_FLAG="N";

	@Column(name="CWP_COVER_CODE")
	private String  CWP_COVER_CODE;
	@Column(name="CWP_CR_DT")
	private Date  CWP_CR_DT;
	@Column(name="CWP_CR_UID")
	private String  CWP_CR_UID;
	@Column(name="CWP_UPD_DT")
	private Date  CWP_UPD_DT;
	@Column(name="CWP_UPD_UID")
	private String  CWP_UPD_UID;

	//desc field for suggestion list
	private String UI_CWP_ILLNESS_TYP_DESC;
	//represents the freeze flag on front end
	private boolean UI_CWP_FREEZE_FLAG;
	//contains value if row has been selected
	private boolean rowCheckBox;
	
	
	public PM_IL_CVR_WAITING_PRD() {
		
//		this.CWP_UPD_DT=new Date();
//		this.CWP_CR_DT=new Date();
//		this.CWP_CR_UID="LIFEALL";
//		this.CWP_UPD_UID="LIFEALL";
	}

	public boolean isUI_CWP_FREEZE_FLAG() {
		return UI_CWP_FREEZE_FLAG;
	}

	public void setUI_CWP_FREEZE_FLAG(boolean ui_cwp_freeze_flag) {
		UI_CWP_FREEZE_FLAG = ui_cwp_freeze_flag;
		if(this.UI_CWP_FREEZE_FLAG){
			System.out.println("[In value bean]---->setting value to Y");
			this.CWP_FREEZE_FLAG="Y";
		}else{
			System.out.println("[In value bean]---->setting value to N");
			this.CWP_FREEZE_FLAG="N";
		}
	}

	public boolean isRowCheckBox() {
		return rowCheckBox;
	}

	public void setRowCheckBox(boolean rowCheckBox) {
		this.rowCheckBox = rowCheckBox;
	}

	public String getCWP_ILLNESS_TYP() {
		return CWP_ILLNESS_TYP;
	}

	public void setCWP_ILLNESS_TYP(String CWP_ILLNESS_TYP) {
		this.CWP_ILLNESS_TYP = CWP_ILLNESS_TYP;
	}

	public Double getCWP_WAITING_PRD() {
		return CWP_WAITING_PRD;
	}

	public void setCWP_WAITING_PRD(Double CWP_WAITING_PRD) {
		this.CWP_WAITING_PRD = CWP_WAITING_PRD;
	}

	public String getCWP_FREEZE_FLAG() {
		return CWP_FREEZE_FLAG;
	}

	public void setCWP_FREEZE_FLAG(String CWP_FREEZE_FLAG) {
		this.CWP_FREEZE_FLAG = CWP_FREEZE_FLAG;
		if(this.CWP_FREEZE_FLAG.equals("Y")){
			this.UI_CWP_FREEZE_FLAG=true;
		}else{
			this.UI_CWP_FREEZE_FLAG=false;
		}
	}

	public String getCWP_COVER_CODE() {
		return CWP_COVER_CODE;
	}

	public void setCWP_COVER_CODE(String cwp_cover_code) {
		CWP_COVER_CODE = cwp_cover_code;
	}

	public Date getCWP_CR_DT() {
		return CWP_CR_DT;
	}

	public void setCWP_CR_DT(Date cwp_cr_dt) {
		CWP_CR_DT = cwp_cr_dt;
	}

	public String getCWP_CR_UID() {
		return CWP_CR_UID;
	}

	public void setCWP_CR_UID(String cwp_cr_uid) {
		CWP_CR_UID = cwp_cr_uid;
	}

	public Date getCWP_UPD_DT() {
		return CWP_UPD_DT;
	}

	public void setCWP_UPD_DT(Date cwp_upd_dt) {
		CWP_UPD_DT = cwp_upd_dt;
	}

	public String getCWP_UPD_UID() {
		return CWP_UPD_UID;
	}

	public void setCWP_UPD_UID(String cwp_upd_uid) {
		CWP_UPD_UID = cwp_upd_uid;
	}

	public String getUI_CWP_ILLNESS_TYP_DESC() {
		return UI_CWP_ILLNESS_TYP_DESC;
	}

	public void setUI_CWP_ILLNESS_TYP_DESC(String ui_cwp_illness_typ_desc) {
		UI_CWP_ILLNESS_TYP_DESC = ui_cwp_illness_typ_desc;
	}
}
