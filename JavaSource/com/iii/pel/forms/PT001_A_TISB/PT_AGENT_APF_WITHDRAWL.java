package com.iii.pel.forms.PT001_A_TISB;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_AGENT_APF_WITHDRAWL")
public class PT_AGENT_APF_WITHDRAWL extends BaseValueBean {

	@Column(name="APW_AGENT_CODE")
	private String APW_AGENT_CODE;

	private String UI_M_AGENT_DESC;

	@Column(name="APW_ACS_TYPE")
	private String APW_ACS_TYPE;

	@Column(name="APW_REASON_CODE")
	private String APW_REASON_CODE;

	private String UI_M_REASON_DESC;

	@Column(name="APW_REMARKS")
	private String APW_REMARKS;

	@Column(name="APW_WD_DT")
	private Date APW_WD_DT;

	@Column(name="APW_ACC_TYPE")
	private String APW_ACC_TYPE;

	@Column(name="APW_PROCESS_DT")
	private Date APW_PROCESS_DT;

	@Column(name="APW_DRCR_DOC_NO")
	private Integer APW_DRCR_DOC_NO;

	@Column(name="APW_APPRV_DT")
	private Date APW_APPRV_DT;

	@Column(name="APW_DRCR_TXN_CODE")
	private String APW_DRCR_TXN_CODE;

	@Column(name="APW_DRCR_ACNT_YEAR")
	private Integer APW_DRCR_ACNT_YEAR;

	@Column(name="APW_DRCR_DOC_DT")
	private Date APW_DRCR_DOC_DT;
	
	@Column(name="APW_CR_DT")
	private Date APW_CR_DT;
	
	@Column(name="APW_CR_UID")
	private String APW_CR_UID;

	@Column(name="APW_SYS_ID")
	private String APW_SYS_ID;

	@Column(name="APW_UPD_DT")
	private Date APW_UPD_DT ;                                                                                                                                                                                                                    
	
	@Column(name="APW_UPD_UID")
	private String APW_UPD_UID;
	

	public String getAPW_AGENT_CODE() {
		return APW_AGENT_CODE;
	}

	public void setAPW_AGENT_CODE(String APW_AGENT_CODE) {
		this.APW_AGENT_CODE = APW_AGENT_CODE;
	}

	public String getUI_M_AGENT_DESC() {
		return UI_M_AGENT_DESC;
	}

	public void setUI_M_AGENT_DESC(String UI_M_AGENT_DESC) {
		this.UI_M_AGENT_DESC = UI_M_AGENT_DESC;
	}

	public String getAPW_ACS_TYPE() {
		return APW_ACS_TYPE;
	}

	public void setAPW_ACS_TYPE(String APW_ACS_TYPE) {
		this.APW_ACS_TYPE = APW_ACS_TYPE;
	}

	public String getAPW_REASON_CODE() {
		return APW_REASON_CODE;
	}

	public void setAPW_REASON_CODE(String APW_REASON_CODE) {
		this.APW_REASON_CODE = APW_REASON_CODE;
	}

	public String getUI_M_REASON_DESC() {
		return UI_M_REASON_DESC;
	}

	public void setUI_M_REASON_DESC(String UI_M_REASON_DESC) {
		this.UI_M_REASON_DESC = UI_M_REASON_DESC;
	}

	public String getAPW_REMARKS() {
		return APW_REMARKS;
	}

	public void setAPW_REMARKS(String APW_REMARKS) {
		this.APW_REMARKS = APW_REMARKS;
	}

	public Date getAPW_WD_DT() {
		 return APW_WD_DT;
	}

	public void setAPW_WD_DT(Date APW_WD_DT) {
		this.APW_WD_DT = APW_WD_DT;
	}

	public String getAPW_ACC_TYPE() {
		return APW_ACC_TYPE;
	}

	public void setAPW_ACC_TYPE(String APW_ACC_TYPE) {
		this.APW_ACC_TYPE = APW_ACC_TYPE;
	}

	public Date getAPW_PROCESS_DT() {
		 return APW_PROCESS_DT;
	}

	public void setAPW_PROCESS_DT(Date APW_PROCESS_DT) {
		this.APW_PROCESS_DT = APW_PROCESS_DT;
	}

	

	public Integer getAPW_DRCR_DOC_NO() {
		return APW_DRCR_DOC_NO;
	}

	public void setAPW_DRCR_DOC_NO(Integer apw_drcr_doc_no) {
		APW_DRCR_DOC_NO = apw_drcr_doc_no;
	}

	public Date getAPW_APPRV_DT() {
		 return APW_APPRV_DT;
	}

	public void setAPW_APPRV_DT(Date APW_APPRV_DT) {
		this.APW_APPRV_DT = APW_APPRV_DT;
	}

	public String getAPW_DRCR_TXN_CODE() {
		return APW_DRCR_TXN_CODE;
	}

	public void setAPW_DRCR_TXN_CODE(String APW_DRCR_TXN_CODE) {
		this.APW_DRCR_TXN_CODE = APW_DRCR_TXN_CODE;
	}

	

	public Integer getAPW_DRCR_ACNT_YEAR() {
		return APW_DRCR_ACNT_YEAR;
	}

	public void setAPW_DRCR_ACNT_YEAR(Integer apw_drcr_acnt_year) {
		APW_DRCR_ACNT_YEAR = apw_drcr_acnt_year;
	}

	public Date getAPW_DRCR_DOC_DT() {
		 return APW_DRCR_DOC_DT;
	}

	public void setAPW_DRCR_DOC_DT(Date APW_DRCR_DOC_DT) {
		this.APW_DRCR_DOC_DT = APW_DRCR_DOC_DT;
	}

	public Date getAPW_CR_DT() {
		return APW_CR_DT;
	}

	public void setAPW_CR_DT(Date apw_cr_dt) {
		APW_CR_DT = apw_cr_dt;
	}

	public String getAPW_CR_UID() {
		return APW_CR_UID;
	}

	public void setAPW_CR_UID(String apw_cr_uid) {
		APW_CR_UID = apw_cr_uid;
	}

	public String getAPW_SYS_ID() {
		return APW_SYS_ID;
	}

	public void setAPW_SYS_ID(String apw_sys_id) {
		APW_SYS_ID = apw_sys_id;
	}

	public Date getAPW_UPD_DT() {
		return APW_UPD_DT;
	}

	public void setAPW_UPD_DT(Date apw_upd_dt) {
		APW_UPD_DT = apw_upd_dt;
	}

	public String getAPW_UPD_UID() {
		return APW_UPD_UID;
	}

	public void setAPW_UPD_UID(String apw_upd_uid) {
		APW_UPD_UID = apw_upd_uid;
	}
}
