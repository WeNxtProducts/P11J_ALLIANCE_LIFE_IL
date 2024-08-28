package com.iii.pel.forms.PILT032_APAC;

import java.io.*;
import java.util.*;
import com.iii.apps.persistence.*;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.constants.PELConstants;

@Table(name="PT_IL_RECEIPT_TRANS_DTL")
public class PT_IL_RECEIPT_TRANS_DTL extends BaseValueBean {
	
	/*Added persitance bean by Ganesh on 10.07.2017 for ZBILQC-1719675*/
	
	
	@Column(name="RTD_UPD_UID")
	private String RTD_UPD_UID;
	
	@Column(name="RTD_UPD_DT")
	private Date RTD_UPD_DT;
	
	@Column(name="RTD_CR_DT")
	private Date RTD_CR_DT;
	
	@Column(name="RTD_SYS_ID")
	private Long RTD_SYS_ID;
	
	@Column(name="RTD_CR_UID")
	private String RTD_CR_UID;
	
	@Column(name="RTD_RTH_SYS_ID")
	private Long RTD_RTH_SYS_ID;
	
	private String UI_M_RTD_TXN_CODE;
	
	private String UI_M_DOC_NO;
	
	private Date UI_M_DOC_DT;
	
	private String UI_M_ACC_YEAR;
	
	private Double UI_M_DEP_LC_DEP_AMT;
	
	@Column(name="RTD_DEPOSIT_DEP_LC_AMT")
	private Double RTD_DEPOSIT_DEP_LC_AMT;
	
	@Column(name="RTD_DEPOSIT_OTH_LC_AMT")
	private Double RTD_DEPOSIT_OTH_LC_AMT;
	
	@Column(name="RTD_DES_DEP_SYS_ID")
	private Long RTD_DES_DEP_SYS_ID;
	
	@Column(name="RTD_REV_DOC_NO")
	private String RTD_REV_DOC_NO;
	
	@Column(name="RTD_REV_ACNT_YR")
	private String RTD_REV_ACNT_YR;
	
	@Column(name="RTD_SRC_DEP_SYS_ID")
	private Long RTD_SRC_DEP_SYS_ID;
	
	@Column(name="RTD_REV_TXN_CODE")
	private String RTD_REV_TXN_CODE;
	
	@Column(name="RTD_EXCESS_REFUND")
	private String RTD_EXCESS_REFUND;
	
	@Column(name="RTD_REV_DOC_DT")
	private Date RTD_REV_DOC_DT;
	
	@Column(name="RTD_REASON_CODE")
	private String RTD_REASON_CODE;
	
	private String UI_M_REASON_CODE_DESC;
	
	@Column(name="RTD_DES_POL_NO")
	private String RTD_DES_POL_NO;
	
	private String UI_M_RTD_DES_POL_NO;
	
	@Column(name="RTD_DES_POL_SYS_ID")
	private Long RTD_DES_POL_SYS_ID;
	
	@Column(name="RTD_DEP_LC_AMT")
	private Double RTD_DEP_LC_AMT;
	
	@Column(name="RTD_TRNS_YN")
	private String RTD_TRNS_YN;
	
	@Column(name="RTD_REV_REMARKS")
	private String RTD_REV_REMARKS;
	
	@Column(name="RTD_TXN_CODE")
	private String RTD_TXN_CODE;
	
	@Column(name="RTD_DOC_NO")
	private String RTD_DOC_NO;
	
	@Column(name="RTD_DOC_DT")
	private Date RTD_DOC_DT;
	
	@Column(name="RTD_ACNT_YR")
	private String RTD_ACNT_YR;
	

	public String getRTD_DOC_NO() {
		return RTD_DOC_NO;
	}

	public void setRTD_DOC_NO(String rtd_doc_no) {
		RTD_DOC_NO = rtd_doc_no;
	}

	public String getRTD_TXN_CODE() {
		return RTD_TXN_CODE;
	}

	public void setRTD_TXN_CODE(String rtd_txn_code) {
		RTD_TXN_CODE = rtd_txn_code;
	}

	public String getRTD_REV_REMARKS() {
		return RTD_REV_REMARKS;
	}

	public void setRTD_REV_REMARKS(String rtd_rev_remarks) {
		RTD_REV_REMARKS = rtd_rev_remarks;
	}

	public String getRTD_TRNS_YN() {
		return RTD_TRNS_YN;
	}

	public void setRTD_TRNS_YN(String rtd_trns_yn) {
		RTD_TRNS_YN = rtd_trns_yn;
	}

	 

	public Date getRTD_CR_DT() {
		return RTD_CR_DT;
	}

	public void setRTD_CR_DT(Date rtd_cr_dt) {
		RTD_CR_DT = rtd_cr_dt;
	}

	public Long getRTD_SYS_ID() {
		return RTD_SYS_ID;
	}

	public void setRTD_SYS_ID(Long rtd_sys_id) {
		RTD_SYS_ID = rtd_sys_id;
	}

	public String getRTD_CR_UID() {
		return RTD_CR_UID;
	}

	public void setRTD_CR_UID(String rtd_cr_uid) {
		RTD_CR_UID = rtd_cr_uid;
	}

	public Long getRTD_RTH_SYS_ID() {
		return RTD_RTH_SYS_ID;
	}

	public void setRTD_RTH_SYS_ID(Long rtd_rth_sys_id) {
		RTD_RTH_SYS_ID = rtd_rth_sys_id;
	}

	public Double getRTD_DEP_LC_AMT() {
		return RTD_DEP_LC_AMT;
	}

	public void setRTD_DEP_LC_AMT(Double rtd_dep_lc_amt) {
		RTD_DEP_LC_AMT = rtd_dep_lc_amt;
	}

	public Long getRTD_DES_POL_SYS_ID() {
		return RTD_DES_POL_SYS_ID;
	}

	public void setRTD_DES_POL_SYS_ID(Long rtd_des_pol_sys_id) {
		RTD_DES_POL_SYS_ID = rtd_des_pol_sys_id;
	}

	public String getRTD_DES_POL_NO() {
		return RTD_DES_POL_NO;
	}

	public void setRTD_DES_POL_NO(String rtd_des_pol_no) {
		RTD_DES_POL_NO = rtd_des_pol_no;
	}

	public Date getRTD_DOC_DT() {
		return RTD_DOC_DT;
	}

	public void setRTD_DOC_DT(Date rtd_doc_dt) {
		RTD_DOC_DT = rtd_doc_dt;
	}

	public String getRTD_ACNT_YR() {
		return RTD_ACNT_YR;
	}

	public void setRTD_ACNT_YR(String rtd_acnt_yr) {
		RTD_ACNT_YR = rtd_acnt_yr;
	}

	public String getUI_M_REASON_CODE_DESC() {
		return UI_M_REASON_CODE_DESC;
	}

	public void setUI_M_REASON_CODE_DESC(String ui_m_reason_code_desc) {
		UI_M_REASON_CODE_DESC = ui_m_reason_code_desc;
	}

	public String getRTD_REASON_CODE() {
		return RTD_REASON_CODE;
	}

	public void setRTD_REASON_CODE(String rtd_reason_code) {
		RTD_REASON_CODE = rtd_reason_code;
	}

	public Long getRTD_SRC_DEP_SYS_ID() {
		return RTD_SRC_DEP_SYS_ID;
	}

	public void setRTD_SRC_DEP_SYS_ID(Long rtd_src_dep_sys_id) {
		RTD_SRC_DEP_SYS_ID = rtd_src_dep_sys_id;
	}

	public String getUI_M_RTD_TXN_CODE() {
		return UI_M_RTD_TXN_CODE;
	}

	public void setUI_M_RTD_TXN_CODE(String ui_m_rtd_txn_code) {
		UI_M_RTD_TXN_CODE = ui_m_rtd_txn_code;
	}

	public String getRTD_UPD_UID() {
		return RTD_UPD_UID;
	}

	public void setRTD_UPD_UID(String rtd_upd_uid) {
		RTD_UPD_UID = rtd_upd_uid;
	}

	public Date getRTD_UPD_DT() {
		return RTD_UPD_DT;
	}

	public void setRTD_UPD_DT(Date rtd_upd_dt) {
		RTD_UPD_DT = rtd_upd_dt;
	}

	public String getUI_M_DOC_NO() {
		return UI_M_DOC_NO;
	}

	public void setUI_M_DOC_NO(String ui_m_doc_no) {
		UI_M_DOC_NO = ui_m_doc_no;
	}

	public Date getUI_M_DOC_DT() {
		return UI_M_DOC_DT;
	}

	public void setUI_M_DOC_DT(Date ui_m_doc_dt) {
		UI_M_DOC_DT = ui_m_doc_dt;
	}

	public String getUI_M_ACC_YEAR() {
		return UI_M_ACC_YEAR;
	}

	public void setUI_M_ACC_YEAR(String ui_m_acc_year) {
		UI_M_ACC_YEAR = ui_m_acc_year;
	}

	public Double getUI_M_DEP_LC_DEP_AMT() {
		return UI_M_DEP_LC_DEP_AMT;
	}

	public void setUI_M_DEP_LC_DEP_AMT(Double ui_m_dep_lc_dep_amt) {
		UI_M_DEP_LC_DEP_AMT = ui_m_dep_lc_dep_amt;
	}

	public Double getRTD_DEPOSIT_DEP_LC_AMT() {
		return RTD_DEPOSIT_DEP_LC_AMT;
	}

	public void setRTD_DEPOSIT_DEP_LC_AMT(Double rtd_deposit_dep_lc_amt) {
		RTD_DEPOSIT_DEP_LC_AMT = rtd_deposit_dep_lc_amt;
	}

	public Double getRTD_DEPOSIT_OTH_LC_AMT() {
		return RTD_DEPOSIT_OTH_LC_AMT;
	}

	public void setRTD_DEPOSIT_OTH_LC_AMT(Double rtd_deposit_oth_lc_amt) {
		RTD_DEPOSIT_OTH_LC_AMT = rtd_deposit_oth_lc_amt;
	}

	public Long getRTD_DES_DEP_SYS_ID() {
		return RTD_DES_DEP_SYS_ID;
	}

	public void setRTD_DES_DEP_SYS_ID(Long rtd_des_dep_sys_id) {
		RTD_DES_DEP_SYS_ID = rtd_des_dep_sys_id;
	}

	public String getRTD_REV_DOC_NO() {
		return RTD_REV_DOC_NO;
	}

	public void setRTD_REV_DOC_NO(String rtd_rev_doc_no) {
		RTD_REV_DOC_NO = rtd_rev_doc_no;
	}

	public String getRTD_REV_TXN_CODE() {
		return RTD_REV_TXN_CODE;
	}

	public void setRTD_REV_TXN_CODE(String rtd_rev_txn_code) {
		RTD_REV_TXN_CODE = rtd_rev_txn_code;
	}

	public String getRTD_EXCESS_REFUND() {
		return RTD_EXCESS_REFUND;
	}

	public void setRTD_EXCESS_REFUND(String rtd_excess_refund) {
		RTD_EXCESS_REFUND = rtd_excess_refund;
	}

	public Date getRTD_REV_DOC_DT() {
		return RTD_REV_DOC_DT;
	}

	public void setRTD_REV_DOC_DT(Date rtd_rev_doc_dt) {
		RTD_REV_DOC_DT = rtd_rev_doc_dt;
	}

	public String getRTD_REV_ACNT_YR() {
		return RTD_REV_ACNT_YR;
	}

	public void setRTD_REV_ACNT_YR(String rtd_rev_acnt_yr) {
		RTD_REV_ACNT_YR = rtd_rev_acnt_yr;
	}

	public String getUI_M_RTD_DES_POL_NO() {
		return UI_M_RTD_DES_POL_NO;
	}

	public void setUI_M_RTD_DES_POL_NO(String ui_m_rtd_des_pol_no) {
		UI_M_RTD_DES_POL_NO = ui_m_rtd_des_pol_no;
	}
	
	
}

