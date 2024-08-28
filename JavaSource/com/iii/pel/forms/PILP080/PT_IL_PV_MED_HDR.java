package com.iii.pel.forms.PILP080;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_PV_MED_HDR")
public class PT_IL_PV_MED_HDR extends BaseValueBean {
	@Column (name="PMH_CLINIC_CODE")
	private String PMH_CLINIC_CODE;
	@Column (name="PMH_POL_NO")
	private String PMH_POL_NO;
	@Column (name="PMH_PROD_CODE")
	private String PMH_PROD_CODE;
	@Column (name="PMH_CR_DT")
	private Date PMH_CR_DT;
	@Column (name="PMH_CR_UID")
	private String PMH_CR_UID;
	@Column (name="PMH_SYS_ID")
	private Long PMH_SYS_ID;
	@Column (name="PMH_UPD_DT")
	private Date PMH_UPD_DT;
	@Column (name="PMH_UPD_UID")
	private String PMH_UPD_UID;
	@Column (name="PMH_PROCESS_DT")
	private Date PMH_PROCESS_DT;
	private String	 UI_M_PMH_PROD_NAME;
	private String UI_M_CLINIC_NAME;
	@Column (name="PMH_APPRV_STATUS")
	private String PMH_APPRV_STATUS;
	@Column (name="PMH_VOUCH_NO")
	private String PMH_VOUCH_NO;
	@Column (name="PMH_DOC_NO")
	private Integer PMH_DOC_NO;
	@Column (name="PMH_ACNT_YEAR")
	private Integer PMH_ACNT_YEAR;
	@Column (name="PMH_TRAN_CODE")
	private String PMH_TRAN_CODE;
	
	@Column (name="PMH_FM_PAID_DT")
	private Date PMH_FM_PAID_DT;
	@Column (name="PMH_TO_PAID_DT")
	private Date PMH_TO_PAID_DT;
	
	
	public String getPMH_VOUCH_NO() {
		return PMH_VOUCH_NO;
	}

	public void setPMH_VOUCH_NO(String pmh_vouch_no) {
		PMH_VOUCH_NO = pmh_vouch_no;
	}

	public String getPMH_APPRV_STATUS() {
		return PMH_APPRV_STATUS;
	}

	public void setPMH_APPRV_STATUS(String pmh_apprv_status) {
		PMH_APPRV_STATUS = pmh_apprv_status;
	}

	public String getUI_M_CLINIC_NAME() {
		return UI_M_CLINIC_NAME;
	}

	public void setUI_M_CLINIC_NAME(String ui_m_clinic_name) {
		UI_M_CLINIC_NAME = ui_m_clinic_name;
	}

	public Date getPMH_UPD_DT() {
		return PMH_UPD_DT;
	}

	public void setPMH_UPD_DT(Date pmh_upd_dt) {
		PMH_UPD_DT = pmh_upd_dt;
	}

	public String getPMH_UPD_UID() {
		return PMH_UPD_UID;
	}

	public void setPMH_UPD_UID(String pmh_upd_uid) {
		PMH_UPD_UID = pmh_upd_uid;
	}

	public Date getPMH_CR_DT() {
		return PMH_CR_DT;
	}

	public void setPMH_CR_DT(Date pmh_cr_dt) {
		PMH_CR_DT = pmh_cr_dt;
	}

	public String getPMH_CR_UID() {
		return PMH_CR_UID;
	}

	public void setPMH_CR_UID(String pmh_cr_uid) {
		PMH_CR_UID = pmh_cr_uid;
	}

	public Long getPMH_SYS_ID() {
		return PMH_SYS_ID;
	}

	public void setPMH_SYS_ID(Long pmh_sys_id) {
		PMH_SYS_ID = pmh_sys_id;
	}

	public String getPMH_CLINIC_CODE() {
		return PMH_CLINIC_CODE;
	}

	public void setPMH_CLINIC_CODE(String pmh_clinic_code) {
		PMH_CLINIC_CODE = pmh_clinic_code;
	}

	public Date getPMH_PROCESS_DT() {
		return PMH_PROCESS_DT;
	}

	public void setPMH_PROCESS_DT(Date pmh_process_dt) {
		PMH_PROCESS_DT = pmh_process_dt;
	}

	public String getPMH_PROD_CODE() {
		return PMH_PROD_CODE;
	}

	public void setPMH_PROD_CODE(String pmh_prod_code) {
		PMH_PROD_CODE = pmh_prod_code;
	}

	public String getPMH_POL_NO() {
		return PMH_POL_NO;
	}

	public void setPMH_POL_NO(String pmh_pol_no) {
		PMH_POL_NO = pmh_pol_no;
	}

	public String getUI_M_PMH_PROD_NAME() {
		return UI_M_PMH_PROD_NAME;
	}

	public void setUI_M_PMH_PROD_NAME(String ui_m_pmh_prod_name) {
		UI_M_PMH_PROD_NAME = ui_m_pmh_prod_name;
	}

	public Integer getPMH_DOC_NO() {
		return PMH_DOC_NO;
	}

	public void setPMH_DOC_NO(Integer pmh_doc_no) {
		PMH_DOC_NO = pmh_doc_no;
	}

	public Integer getPMH_ACNT_YEAR() {
		return PMH_ACNT_YEAR;
	}

	public void setPMH_ACNT_YEAR(Integer pmh_acnt_year) {
		PMH_ACNT_YEAR = pmh_acnt_year;
	}

	public String getPMH_TRAN_CODE() {
		return PMH_TRAN_CODE;
	}

	public void setPMH_TRAN_CODE(String pmh_tran_code) {
		PMH_TRAN_CODE = pmh_tran_code;
	}

	public Date getPMH_FM_PAID_DT() {
		return PMH_FM_PAID_DT;
	}

	public void setPMH_FM_PAID_DT(Date pmh_fm_paid_dt) {
		PMH_FM_PAID_DT = pmh_fm_paid_dt;
	}

	public Date getPMH_TO_PAID_DT() {
		return PMH_TO_PAID_DT;
	}

	public void setPMH_TO_PAID_DT(Date pmh_to_paid_dt) {
		PMH_TO_PAID_DT = pmh_to_paid_dt;
	}

}
