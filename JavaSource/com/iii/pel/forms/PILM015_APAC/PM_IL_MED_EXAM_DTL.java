package com.iii.pel.forms.PILM015_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

/**
 * This Class contains setter And getter methods to take values From the
 * component Fields
 * 
 * @author Rajesh Kundala Id-50180
 * 
 */
@Table(name = "PM_IL_MED_EXAM_DTL")
public class PM_IL_MED_EXAM_DTL extends BaseValueBean {

	@Column(name = "MED_EXAM_CODE")
	private String MED_EXAM_CODE;

	private String UI_M_MED_EXAM_CODE_DESC;

	@Column(name = "MED_MEH_SYS_ID")
	private double MED_MEH_SYS_ID;

	@Column(name = "MED_CR_UID")
	private String MED_CR_UID;

	@Column(name = "MED_CR_DT")
	private Date MED_CR_DT;

	@Column(name = "MED_UPD_UID")
	private String MED_UPD_UID;

	@Column(name = "MED_UPD_DT")
	private Date MED_UPD_DT;

	private boolean check;


	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public String getMED_EXAM_CODE() {
		return MED_EXAM_CODE;
	}

	public void setMED_EXAM_CODE(String MED_EXAM_CODE) {
		this.MED_EXAM_CODE = MED_EXAM_CODE;
	}

	public String getUI_M_MED_EXAM_CODE_DESC() {
		return UI_M_MED_EXAM_CODE_DESC;
	}

	public void setUI_M_MED_EXAM_CODE_DESC(String UI_M_MED_EXAM_CODE_DESC) {
		this.UI_M_MED_EXAM_CODE_DESC = UI_M_MED_EXAM_CODE_DESC;
	}

	public double getMED_MEH_SYS_ID() {
		return MED_MEH_SYS_ID;
	}

	public void setMED_MEH_SYS_ID(double med_meh_sys_id) {
		MED_MEH_SYS_ID = med_meh_sys_id;
		System.out.println("<-------Sys id------->" + MED_MEH_SYS_ID);
	}

	public String getMED_CR_UID() {
		return MED_CR_UID;
	}

	public void setMED_CR_UID(String med_cr_uid) {
		MED_CR_UID = med_cr_uid;
	}

	public Date getMED_CR_DT() {
		return MED_CR_DT;
	}

	public void setMED_CR_DT(Date med_cr_dt) {
		MED_CR_DT = med_cr_dt;
	}

	public String getMED_UPD_UID() {
		return MED_UPD_UID;
	}

	public void setMED_UPD_UID(String med_upd_uid) {
		MED_UPD_UID = med_upd_uid;
	}

	public Date getMED_UPD_DT() {
		return MED_UPD_DT;
	}

	public void setMED_UPD_DT(Date med_upd_dt) {
		MED_UPD_DT = med_upd_dt;
	}

}
