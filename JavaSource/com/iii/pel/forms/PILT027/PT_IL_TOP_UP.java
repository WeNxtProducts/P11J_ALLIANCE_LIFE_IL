package com.iii.pel.forms.PILT027;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_TOP_UP")
public class PT_IL_TOP_UP extends BaseValueBean {

	@Column(name="TU_CUST_REF_ID1")
	private String TU_CUST_REF_ID1;

	@Column(name="TU_CUST_REF_ID2")
	private String TU_CUST_REF_ID2;

	@Column(name="TU_CUST_CODE")
	private String TU_CUST_CODE;

	private String UI_M_TU_CUST_NAME;

	@Column(name="TU_POL_NO")
	private String TU_POL_NO;

	@Column(name="TU_CONTROL_NO")
	private String TU_CONTROL_NO;

	@Column(name="TU_TXN_CODE")
	private String TU_TXN_CODE;

	@Column(name="TU_LC_TOPUP_DEP_AMT")
	private Double TU_LC_TOPUP_DEP_AMT;

	@Column(name="TU_DOC_NO")
	private Integer TU_DOC_NO;

	@Column(name="TU_DATE")
	private Date TU_DATE;

	@Column(name="TU_DOC_DT")
	private Date TU_DOC_DT;

	@Column(name="TU_LC_TOPUP_CHRG_AMT")
	private Double TU_LC_TOPUP_CHRG_AMT;

	@Column(name="TU_LC_TOPUP_NET_AMT")
	private Double TU_LC_TOPUP_NET_AMT;

	@Column(name="TU_BANK_CODE")
	private String TU_BANK_CODE;

	private String UI_M_TU_BANK_NAME;

	@Column(name="TU_REASON_CODE")
	private String TU_REASON_CODE;

	private String UI_M_REASON_DESC;

	@Column(name="TU_REMARKS")
	private String TU_REMARKS;
	
	@Column(name="TU_REVERSE_FLAG")
	private String TU_REVERSE_FLAG;
	
	@Column(name="TU_APPRV_STATUS")
	private String TU_APPRV_STATUS;
	
	@Column(name="TU_PAID_FOR")
	private String TU_PAID_FOR;
	
	@Column(name="TU_CHRG_TXN_CODE")
	private String TU_CHRG_TXN_CODE;
	
	@Column(name="TU_PD_DPD_REF_ID")
	private String TU_PD_DPD_REF_ID;
	
	@Column(name="TU_CHRG_DOC_NO")
	private String TU_CHRG_DOC_NO;
	
	@Column(name="TU_UNIT_YN")
	private String TU_UNIT_YN;
	
	@Column(name="TU_CHRG_FLAG")
	private String TU_CHRG_FLAG;
	
	@Column(name="TU_COMM_FLAG")
	private String TU_COMM_FLAG;
	
	@Column(name="TU_APPRV_UID")
	private String TU_APPRV_UID;
	
	@Column(name="TU_CR_DT")
	private Date TU_CR_DT;
	
	@Column(name="TU_CR_UID")
	private String TU_CR_UID;
	
	@Column(name="TU_UPD_DT")
	private Date TU_UPD_DT;
	
	@Column(name="TU_UPD_UID")
	private String TU_UPD_UID;
	
	@Column(name="TU_APPRV_DT")
	private Date TU_APPRV_DT;
	                                                                                                                                                                              
	@Column(name="TU_WAK_FEE")
	private Integer TU_WAK_FEE;
	
	@Column(name="TU_SYS_ID")
	private Long TU_SYS_ID;
	
	@Column(name="TU_POL_SYS_ID")
	private Integer TU_POL_SYS_ID;
	
	private Date M_POL_START_DATE;
	
	private Double M_PROD_TOPUP_LC_MIN_AMT;
	
	private Double M_PROD_TOPUP_LC_MAX_AMT;
	private Double UI_M_POL_SA_EXCH_RATE;
	private String UI_M_POL_SA_CURR_CODE;
	private String UI_M_POL_PROD_CODE;

	public String getUI_M_POL_SA_CURR_CODE() {
		return UI_M_POL_SA_CURR_CODE;
	}

	public void setUI_M_POL_SA_CURR_CODE(String ui_m_pol_sa_curr_code) {
		UI_M_POL_SA_CURR_CODE = ui_m_pol_sa_curr_code;
	}

	public String getUI_M_POL_PROD_CODE() {
		return UI_M_POL_PROD_CODE;
	}

	public void setUI_M_POL_PROD_CODE(String ui_m_pol_prod_code) {
		UI_M_POL_PROD_CODE = ui_m_pol_prod_code;
	}

	public String getTU_CUST_REF_ID1() {
		return TU_CUST_REF_ID1;
	}

	public void setTU_CUST_REF_ID1(String TU_CUST_REF_ID1) {
		this.TU_CUST_REF_ID1 = TU_CUST_REF_ID1;
	}

	public String getTU_CUST_REF_ID2() {
		return TU_CUST_REF_ID2;
	}

	public void setTU_CUST_REF_ID2(String TU_CUST_REF_ID2) {
		this.TU_CUST_REF_ID2 = TU_CUST_REF_ID2;
	}

	public String getTU_CUST_CODE() {
		return TU_CUST_CODE;
	}

	public void setTU_CUST_CODE(String TU_CUST_CODE) {
		this.TU_CUST_CODE = TU_CUST_CODE;
	}

	public String getUI_M_TU_CUST_NAME() {
		return UI_M_TU_CUST_NAME;
	}

	public void setUI_M_TU_CUST_NAME(String UI_M_TU_CUST_NAME) {
		this.UI_M_TU_CUST_NAME = UI_M_TU_CUST_NAME;
	}

	public String getTU_POL_NO() {
		return TU_POL_NO;
	}

	public void setTU_POL_NO(String TU_POL_NO) {
		this.TU_POL_NO = TU_POL_NO;
	}

	public String getTU_CONTROL_NO() {
		return TU_CONTROL_NO;
	}

	public void setTU_CONTROL_NO(String TU_CONTROL_NO) {
		this.TU_CONTROL_NO = TU_CONTROL_NO;
	}

	public String getTU_TXN_CODE() {
		return TU_TXN_CODE;
	}

	public void setTU_TXN_CODE(String TU_TXN_CODE) {
		this.TU_TXN_CODE = TU_TXN_CODE;
	}

	public Double getTU_LC_TOPUP_DEP_AMT() {
		return TU_LC_TOPUP_DEP_AMT;
	}

	public void setTU_LC_TOPUP_DEP_AMT(Double TU_LC_TOPUP_DEP_AMT) {
		this.TU_LC_TOPUP_DEP_AMT = TU_LC_TOPUP_DEP_AMT;
	}

	public Integer getTU_DOC_NO() {
		return TU_DOC_NO;
	}

	public void setTU_DOC_NO(Integer TU_DOC_NO) {
		this.TU_DOC_NO = TU_DOC_NO;
	}

	public Date getTU_DATE() {
		 return TU_DATE;
	}

	public void setTU_DATE(Date TU_DATE) {
		this.TU_DATE = TU_DATE;
	}

	public Date getTU_DOC_DT() {
		 return TU_DOC_DT;
	}

	public void setTU_DOC_DT(Date TU_DOC_DT) {
		this.TU_DOC_DT = TU_DOC_DT;
	}

	public Double getTU_LC_TOPUP_CHRG_AMT() {
		return TU_LC_TOPUP_CHRG_AMT;
	}

	public void setTU_LC_TOPUP_CHRG_AMT(Double TU_LC_TOPUP_CHRG_AMT) {
		this.TU_LC_TOPUP_CHRG_AMT = TU_LC_TOPUP_CHRG_AMT;
	}

	public Double getTU_LC_TOPUP_NET_AMT() {
		return TU_LC_TOPUP_NET_AMT;
	}

	public void setTU_LC_TOPUP_NET_AMT(Double TU_LC_TOPUP_NET_AMT) {
		this.TU_LC_TOPUP_NET_AMT = TU_LC_TOPUP_NET_AMT;
	}

	public String getTU_BANK_CODE() {
		return TU_BANK_CODE;
	}

	public void setTU_BANK_CODE(String TU_BANK_CODE) {
		this.TU_BANK_CODE = TU_BANK_CODE;
	}

	public String getUI_M_TU_BANK_NAME() {
		return UI_M_TU_BANK_NAME;
	}

	public void setUI_M_TU_BANK_NAME(String UI_M_TU_BANK_NAME) {
		this.UI_M_TU_BANK_NAME = UI_M_TU_BANK_NAME;
	}

	public String getTU_REASON_CODE() {
		return TU_REASON_CODE;
	}

	public void setTU_REASON_CODE(String TU_REASON_CODE) {
		this.TU_REASON_CODE = TU_REASON_CODE;
	}

	public String getUI_M_REASON_DESC() {
		return UI_M_REASON_DESC;
	}

	public void setUI_M_REASON_DESC(String UI_M_REASON_DESC) {
		this.UI_M_REASON_DESC = UI_M_REASON_DESC;
	}

	public String getTU_REMARKS() {
		return TU_REMARKS;
	}

	public void setTU_REMARKS(String TU_REMARKS) {
		this.TU_REMARKS = TU_REMARKS;
	}

	public Integer getTU_WAK_FEE() {
		return TU_WAK_FEE;
	}

	public void setTU_WAK_FEE(Integer tu_wak_fee) {
		TU_WAK_FEE = tu_wak_fee;
	}

	public Long getTU_SYS_ID() {
		return TU_SYS_ID;
	}

	public void setTU_SYS_ID(Long tu_sys_id) {
		TU_SYS_ID = tu_sys_id;
	}

	public Integer getTU_POL_SYS_ID() {
		return TU_POL_SYS_ID;
	}

	public void setTU_POL_SYS_ID(Integer tu_pol_sys_id) {
		TU_POL_SYS_ID = tu_pol_sys_id;
	}

	public Date getM_POL_START_DATE() {
		return M_POL_START_DATE;
	}

	public void setM_POL_START_DATE(Date m_pol_start_date) {
		M_POL_START_DATE = m_pol_start_date;
	}

	public Double getM_PROD_TOPUP_LC_MIN_AMT() {
		return M_PROD_TOPUP_LC_MIN_AMT;
	}

	public void setM_PROD_TOPUP_LC_MIN_AMT(Double m_prod_topup_lc_min_amt) {
		M_PROD_TOPUP_LC_MIN_AMT = m_prod_topup_lc_min_amt;
	}

	public Double getM_PROD_TOPUP_LC_MAX_AMT() {
		return M_PROD_TOPUP_LC_MAX_AMT;
	}

	public void setM_PROD_TOPUP_LC_MAX_AMT(Double m_prod_topup_lc_max_amt) {
		M_PROD_TOPUP_LC_MAX_AMT = m_prod_topup_lc_max_amt;
	}

	public String getTU_REVERSE_FLAG() {
		return TU_REVERSE_FLAG;
	}

	public void setTU_REVERSE_FLAG(String tu_reverse_flag) {
		TU_REVERSE_FLAG = tu_reverse_flag;
	}

	public String getTU_APPRV_STATUS() {
		return TU_APPRV_STATUS;
	}

	public void setTU_APPRV_STATUS(String tu_apprv_status) {
		TU_APPRV_STATUS = tu_apprv_status;
	}

	public String getTU_PAID_FOR() {
		return TU_PAID_FOR;
	}

	public void setTU_PAID_FOR(String tu_paid_for) {
		TU_PAID_FOR = tu_paid_for;
	}

	public String getTU_CHRG_TXN_CODE() {
		return TU_CHRG_TXN_CODE;
	}

	public void setTU_CHRG_TXN_CODE(String tu_chrg_txn_code) {
		TU_CHRG_TXN_CODE = tu_chrg_txn_code;
	}

	public String getTU_PD_DPD_REF_ID() {
		return TU_PD_DPD_REF_ID;
	}

	public void setTU_PD_DPD_REF_ID(String tu_pd_dpd_ref_id) {
		TU_PD_DPD_REF_ID = tu_pd_dpd_ref_id;
	}

	public String getTU_CHRG_DOC_NO() {
		return TU_CHRG_DOC_NO;
	}

	public void setTU_CHRG_DOC_NO(String tu_chrg_doc_no) {
		TU_CHRG_DOC_NO = tu_chrg_doc_no;
	}

	public String getTU_UNIT_YN() {
		return TU_UNIT_YN;
	}

	public void setTU_UNIT_YN(String tu_unit_yn) {
		TU_UNIT_YN = tu_unit_yn;
	}

	public String getTU_CHRG_FLAG() {
		return TU_CHRG_FLAG;
	}

	public void setTU_CHRG_FLAG(String tu_chrg_flag) {
		TU_CHRG_FLAG = tu_chrg_flag;
	}

	public String getTU_COMM_FLAG() {
		return TU_COMM_FLAG;
	}

	public void setTU_COMM_FLAG(String tu_comm_flag) {
		TU_COMM_FLAG = tu_comm_flag;
	}

	public String getTU_APPRV_UID() {
		return TU_APPRV_UID;
	}

	public void setTU_APPRV_UID(String tu_apprv_uid) {
		TU_APPRV_UID = tu_apprv_uid;
	}

	public Date getTU_CR_DT() {
		return TU_CR_DT;
	}

	public void setTU_CR_DT(Date tu_cr_dt) {
		TU_CR_DT = tu_cr_dt;
	}

	public String getTU_CR_UID() {
		return TU_CR_UID;
	}

	public void setTU_CR_UID(String tu_cr_uid) {
		TU_CR_UID = tu_cr_uid;
	}

	public Date getTU_APPRV_DT() {
		return TU_APPRV_DT;
	}

	public void setTU_APPRV_DT(Date tu_apprv_dt) {
		TU_APPRV_DT = tu_apprv_dt;
	}

	public Date getTU_UPD_DT() {
		return TU_UPD_DT;
	}

	public void setTU_UPD_DT(Date tu_upd_dt) {
		TU_UPD_DT = tu_upd_dt;
	}

	public String getTU_UPD_UID() {
		return TU_UPD_UID;
	}

	public void setTU_UPD_UID(String tu_upd_uid) {
		TU_UPD_UID = tu_upd_uid;
	}

	public Double getUI_M_POL_SA_EXCH_RATE() {
		return UI_M_POL_SA_EXCH_RATE;
	}

	public void setUI_M_POL_SA_EXCH_RATE(Double ui_m_pol_sa_exch_rate) {
		UI_M_POL_SA_EXCH_RATE = ui_m_pol_sa_exch_rate;
	}
 
}
