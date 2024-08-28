package com.iii.pel.forms.PILT002_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POL_BROKER_DEDUCTION")
public class PT_IL_POL_BROKER_DEDUCTION extends BaseValueBean {

	@Column(name="PBDED_SYS_ID")
	private Long PBDED_SYS_ID;

	@Column(name="PBDED_POBH_SYS_ID")
	private Long PBDED_POBH_SYS_ID;

	@Column(name="PBDED_CODE")
	private String PBDED_CODE;

	
	@Column(name="PBDED_DEL_FLAG")
	private String PBDED_DEL_FLAG;

	@Column(name="PBDED_CR_DT")
	private Date PBDED_CR_DT;

	@Column(name="PBDED_CR_UID")
	private String PBDED_CR_UID;

	@Column(name="PBDED_UPD_DT")
	private Date PBDED_UPD_DT;

	@Column(name="PBDED_UPD_UID")
	private String PBDED_UPD_UID;

	@Column(name="PBDED_RATE")
	private Double PBDED_RATE;

	@Column(name="PBDED_RATE_PER")
	private Double PBDED_RATE_PER;
	
	private String UI_M_PBDED_CODE_DESC;

	public String getUI_M_PBDED_CODE_DESC() {
		return UI_M_PBDED_CODE_DESC;
	}

	public void setUI_M_PBDED_CODE_DESC(String ui_m_pbded_code_desc) {
		UI_M_PBDED_CODE_DESC = ui_m_pbded_code_desc;
	}

	public Long getPBDED_SYS_ID() {
		return PBDED_SYS_ID;
	}

	public void setPBDED_SYS_ID(Long pbded_sys_id) {
		PBDED_SYS_ID = pbded_sys_id;
	}

	public Long getPBDED_POBH_SYS_ID() {
		return PBDED_POBH_SYS_ID;
	}

	public void setPBDED_POBH_SYS_ID(Long pbded_pobh_sys_id) {
		PBDED_POBH_SYS_ID = pbded_pobh_sys_id;
	}

	public String getPBDED_CODE() {
		return PBDED_CODE;
	}

	public void setPBDED_CODE(String pbded_code) {
		PBDED_CODE = pbded_code;
	}

	public String getPBDED_DEL_FLAG() {
		return PBDED_DEL_FLAG;
	}

	public void setPBDED_DEL_FLAG(String pbded_del_flag) {
		PBDED_DEL_FLAG = pbded_del_flag;
	}

	public Date getPBDED_CR_DT() {
		return PBDED_CR_DT;
	}

	public void setPBDED_CR_DT(Date pbded_cr_dt) {
		PBDED_CR_DT = pbded_cr_dt;
	}

	public String getPBDED_CR_UID() {
		return PBDED_CR_UID;
	}

	public void setPBDED_CR_UID(String pbded_cr_uid) {
		PBDED_CR_UID = pbded_cr_uid;
	}

	public Date getPBDED_UPD_DT() {
		return PBDED_UPD_DT;
	}

	public void setPBDED_UPD_DT(Date pbded_upd_dt) {
		PBDED_UPD_DT = pbded_upd_dt;
	}

	public String getPBDED_UPD_UID() {
		return PBDED_UPD_UID;
	}

	public void setPBDED_UPD_UID(String pbded_upd_uid) {
		PBDED_UPD_UID = pbded_upd_uid;
	}

	public Double getPBDED_RATE() {
		return PBDED_RATE;
	}

	public void setPBDED_RATE(Double pbded_rate) {
		PBDED_RATE = pbded_rate;
	}

	public Double getPBDED_RATE_PER() {
		return PBDED_RATE_PER;
	}

	public void setPBDED_RATE_PER(Double pbded_rate_per) {
		PBDED_RATE_PER = pbded_rate_per;
	}

	//Thhis field is not available in DB
	
	/*@Column(name="POBD_RANK_CODE")
	private String POBD_RANK_CODE;*/

	/*public void setPOBD_RANK_CODE(String POBD_RANK_CODE) {
		this.POBD_RANK_CODE = POBD_RANK_CODE;
	}
	public String getPOBD_RANK_CODE() {
		 return POBD_RANK_CODE;
	}*/


}
