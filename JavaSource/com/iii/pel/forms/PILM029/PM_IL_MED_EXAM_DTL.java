package com.iii.pel.forms.PILM029;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

/**
 * @author 50180
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

	PM_IL_MED_EXAM_HDR_ACTION pm_il_med_exam_hdr_action = new PM_IL_MED_EXAM_HDR_ACTION();
	private boolean selected;

	public boolean isSelected() {
		return selected;
	}

	public PM_IL_MED_EXAM_DTL(int MED_MEH_SYS_ID) {
		this.MED_MEH_SYS_ID = MED_MEH_SYS_ID;
	}

	public PM_IL_MED_EXAM_DTL() {

	}

	public void setSelected(boolean selected) {
		this.selected = selected;
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
	
	
	/*added by R. Raja on 15-12-2016 for RM018T - FSD_IL_ZB Life_017-Medical Report Validity Period*/ 

	@Column(name = "MED_NO_OF_VALID_DAYS")
	private int MED_NO_OF_VALID_DAYS;
	
	@Column(name = "MED_SA_CONS_MONTHS")
	private int MED_SA_CONS_MONTHS;

	public int getMED_NO_OF_VALID_DAYS() {
		return MED_NO_OF_VALID_DAYS;
	}

	public void setMED_NO_OF_VALID_DAYS(int mED_NO_OF_VALID_DAYS) {
		MED_NO_OF_VALID_DAYS = mED_NO_OF_VALID_DAYS;
	}

	public int getMED_SA_CONS_MONTHS() {
		return MED_SA_CONS_MONTHS;
	}

	public void setMED_SA_CONS_MONTHS(int mED_SA_CONS_MONTHS) {
		MED_SA_CONS_MONTHS = mED_SA_CONS_MONTHS;
	}

	

/*end*/

	/* Added by ganesh on 02-06-2017, ZBILQC-1719236 suggested by Arunkumar G */
	@Column(name = "MED_SA_FM")
	private Double MEDL_SUM_ASSURED_FM;
	
	@Column(name = "MED_SA_TO")
	private Double MEDL_SUM_ASSURED_TO;
	
	public Double getMEDL_SUM_ASSURED_FM() {
		return MEDL_SUM_ASSURED_FM;
	}

	public void setMEDL_SUM_ASSURED_FM(Double mEDL_SUM_ASSURED_FM) {
		MEDL_SUM_ASSURED_FM = mEDL_SUM_ASSURED_FM;
	}

	public Double getMEDL_SUM_ASSURED_TO() {
		return MEDL_SUM_ASSURED_TO;
	}

	public void setMEDL_SUM_ASSURED_TO(Double mEDL_SUM_ASSURED_TO) {
		MEDL_SUM_ASSURED_TO = mEDL_SUM_ASSURED_TO;
	}

	/*end*/

}
