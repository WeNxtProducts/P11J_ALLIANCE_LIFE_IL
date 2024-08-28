package com.iii.pel.forms.PILT032_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_RECEIPT_TRANS_HDR")
public class PT_IL_RECEIPT_TRANS_HDR extends BaseValueBean {
	
	/*MOdified as persistance bean by Ganesh on 10.07.2017 for ZBILQC-1719675*/
	@Column(name="RTH_APPRV_STATUS")
	private String RTH_APPRV_STATUS;
	
	private Date UI_M_RTH_APPRV_DT;
	
	@Column(name="RTH_PROCESS_DT")
	private Date RTH_PROCESS_DT;
	
	@Column(name="RTH_APPRV_DT")
	private Date RTH_APPRV_DT;
	
	 @Column(name="RTH_UPD_DT")
	private Date RTH_UPD_DT;
	
	private String UI_M_BUT_PROCESS;
	
	private String UI_M_BUT_APPROVE;
	
	 @Column(name="RTH_UPD_UID")
	private String RTH_UPD_UID;
	
	 @Column(name="RTH_SYS_ID")
	private Long RTH_SYS_ID;
	
	 @Column(name="RTH_SRC_POL_NO")
	private String RTH_SRC_POL_NO;
	
	 @Column(name="RTH_SRC_POL_SYS_ID")
	private Long RTH_SRC_POL_SYS_ID;
	
	 @Column(name="RTH_SRC_LC_AMT")
	private Double RTH_SRC_LC_AMT;
	
	 @Column(name="RTH_APPRV_USER")
	private String RTH_APPRV_USER;
	
	 @Column(name="RTH_CR_DT")
	private Date RTH_CR_DT;
	
	 @Column(name="RTH_CR_UID")
	private String RTH_CR_UID;
	
	
	
	private String UI_M_STATUS;
	
	public String getUI_M_STATUS() {
		return UI_M_STATUS;
	}

	public void setUI_M_STATUS(String ui_m_status) {
		UI_M_STATUS = ui_m_status;
	}

	public Date getUI_M_RTH_APPRV_DT() {
		return UI_M_RTH_APPRV_DT;
	}

	public void setUI_M_RTH_APPRV_DT(Date ui_m_rth_apprv_dt) {
		UI_M_RTH_APPRV_DT = ui_m_rth_apprv_dt;
	}

	public String getRTH_APPRV_STATUS() {
		return RTH_APPRV_STATUS;
	}

	public void setRTH_APPRV_STATUS(String rth_apprv_status) {
		RTH_APPRV_STATUS = rth_apprv_status;
	}

	public Date getRTH_PROCESS_DT() {
		return RTH_PROCESS_DT;
	}

	public void setRTH_PROCESS_DT(Date rth_process_dt) {
		RTH_PROCESS_DT = rth_process_dt;
	}

	public String getUI_M_BUT_PROCESS() {
		return UI_M_BUT_PROCESS;
	}

	public void setUI_M_BUT_PROCESS(String ui_m_but_process) {
		UI_M_BUT_PROCESS = ui_m_but_process;
	}

	public String getUI_M_BUT_APPROVE() {
		return UI_M_BUT_APPROVE;
	}

	public void setUI_M_BUT_APPROVE(String ui_m_but_approve) {
		UI_M_BUT_APPROVE = ui_m_but_approve;
	}

	public Date getRTH_APPRV_DT() {
		return RTH_APPRV_DT;
	}

	public void setRTH_APPRV_DT(Date rth_apprv_dt) {
		RTH_APPRV_DT = rth_apprv_dt;
	}

	public Date getRTH_UPD_DT() {
		return RTH_UPD_DT;
	}

	public void setRTH_UPD_DT(Date rth_upd_dt) {
		RTH_UPD_DT = rth_upd_dt;
	}

	public String getRTH_UPD_UID() {
		return RTH_UPD_UID;
	}

	public void setRTH_UPD_UID(String rth_upd_uid) {
		RTH_UPD_UID = rth_upd_uid;
	}

	public Long getRTH_SYS_ID() {
		return RTH_SYS_ID;
	}

	public void setRTH_SYS_ID(Long rth_sys_id) {
		RTH_SYS_ID = rth_sys_id;
	}

	public String getRTH_SRC_POL_NO() {
		return RTH_SRC_POL_NO;
	}

	public void setRTH_SRC_POL_NO(String rth_src_pol_no) {
		RTH_SRC_POL_NO = rth_src_pol_no;
	}

	public Long getRTH_SRC_POL_SYS_ID() {
		return RTH_SRC_POL_SYS_ID;
	}

	public void setRTH_SRC_POL_SYS_ID(Long rth_src_pol_sys_id) {
		RTH_SRC_POL_SYS_ID = rth_src_pol_sys_id;
	}

	public Double getRTH_SRC_LC_AMT() {
		return RTH_SRC_LC_AMT;
	}

	public void setRTH_SRC_LC_AMT(Double rth_src_lc_amt) {
		RTH_SRC_LC_AMT = rth_src_lc_amt;
	}

	public String getRTH_APPRV_USER() {
		return RTH_APPRV_USER;
	}

	public void setRTH_APPRV_USER(String rth_apprv_user) {
		RTH_APPRV_USER = rth_apprv_user;
	}

	public Date getRTH_CR_DT() {
		return RTH_CR_DT;
	}

	public void setRTH_CR_DT(Date rth_cr_dt) {
		RTH_CR_DT = rth_cr_dt;
	}

	public String getRTH_CR_UID() {
		return RTH_CR_UID;
	}

	public void setRTH_CR_UID(String rth_cr_uid) {
		RTH_CR_UID = rth_cr_uid;
	}
	
}

