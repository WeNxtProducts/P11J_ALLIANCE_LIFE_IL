package com.iii.pel.forms.PILP018;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_LOAN_REPAYMENT")
public class PT_IL_LOAN_REPAYMENT extends BaseValueBean {

	private String UI_M_LOAN_NO;

	private String UI_M_LOAN_DT;

	@Column(name = "LR_PYMT_DT")
	private Date LR_PYMT_DT;

	private Double LR_FC_PYMT_AMT;

	private Double LR_LC_PYMT_AMT;

	@Column(name = "LR_LC_LOAN_AMT")
	private Double LR_LC_LOAN_AMT;

	@Column(name = "LR_FC_LOAN_AMT")
	private Double LR_FC_LOAN_AMT;

	@Column(name = "LR_FC_INT_AMT")
	private Double LR_FC_INT_AMT;

	@Column(name = "LR_LC_INT_AMT")
	private Double LR_LC_INT_AMT;

	@Column(name = "LR_LOAN_SYS_ID")
	private Long LR_LOAN_SYS_ID;
	
	@Column(name = "LR_SYS_ID")
	private Long LR_SYS_ID;
	
	@Column(name="LR_STATUS")
	private String LR_STATUS;

	@Column(name="LR_CR_DT")
	private Date LR_CR_DT;

	@Column(name="LR_CR_UID")
	private String LR_CR_UID;

	@Column(name="LR_UPD_DT")
	private Date LR_UPD_DT;

	@Column(name="LR_UPD_UID")
	private String LR_UPD_UID;

	@Column(name="LR_FLAG")
	private String LR_FLAG;

	@Column(name="LR_PYMT_REF_NO")
	private String LR_PYMT_REF_NO;


	@Column(name="LR_REVERSAL_FLAG")
	private String LR_REVERSAL_FLAG;

	@Column(name="LR_DRCR_ACNT_YEAR")
	private Double LR_DRCR_ACNT_YEAR;

	@Column(name="LR_DRCR_TXN_CODE")
	private String LR_DRCR_TXN_CODE;

	@Column(name="LR_DRCR_DOC_NO")
	private Double LR_DRCR_DOC_NO;

	@Column(name="LR_DRCR_DOC_DT")
	private Date LR_DRCR_DOC_DT;
 
	private String M_WHERE;

	private boolean CHECK_BOX;

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public String getUI_M_LOAN_NO() {
		return UI_M_LOAN_NO;
	}

	public void setUI_M_LOAN_NO(String UI_M_LOAN_NO) {
		this.UI_M_LOAN_NO = UI_M_LOAN_NO;
	}

	public String getUI_M_LOAN_DT() {
		return UI_M_LOAN_DT;
	}

	public void setUI_M_LOAN_DT(String UI_M_LOAN_DT) {
		this.UI_M_LOAN_DT = UI_M_LOAN_DT;
	}

	public Date getLR_PYMT_DT() {
		return LR_PYMT_DT;
	}

	public void setLR_PYMT_DT(Date LR_PYMT_DT) {
		this.LR_PYMT_DT = LR_PYMT_DT;
	}

	public Double getLR_FC_PYMT_AMT() {
		return LR_FC_PYMT_AMT;
	}

	public void setLR_FC_PYMT_AMT(Double LR_FC_PYMT_AMT) {
		this.LR_FC_PYMT_AMT = LR_FC_PYMT_AMT;
	}

	public Double getLR_LC_PYMT_AMT() {
		return LR_LC_PYMT_AMT;
	}

	public void setLR_LC_PYMT_AMT(Double LR_LC_PYMT_AMT) {
		this.LR_LC_PYMT_AMT = LR_LC_PYMT_AMT;
	}

	public Double getLR_LC_LOAN_AMT() {
		return LR_LC_LOAN_AMT;
	}

	public void setLR_LC_LOAN_AMT(Double LR_LC_LOAN_AMT) {
		this.LR_LC_LOAN_AMT = LR_LC_LOAN_AMT;
	}

	public Double getLR_FC_LOAN_AMT() {
		return LR_FC_LOAN_AMT;
	}

	public void setLR_FC_LOAN_AMT(Double LR_FC_LOAN_AMT) {
		this.LR_FC_LOAN_AMT = LR_FC_LOAN_AMT;
	}

	public Double getLR_FC_INT_AMT() {
		return LR_FC_INT_AMT;
	}

	public void setLR_FC_INT_AMT(Double LR_FC_INT_AMT) {
		this.LR_FC_INT_AMT = LR_FC_INT_AMT;
	}

	public Double getLR_LC_INT_AMT() {
		return LR_LC_INT_AMT;
	}

	public void setLR_LC_INT_AMT(Double LR_LC_INT_AMT) {
		this.LR_LC_INT_AMT = LR_LC_INT_AMT;
	}

	public String getM_WHERE() {
	    return M_WHERE;
	}

	public void setM_WHERE(String m_where) {
	    M_WHERE = m_where;
	}

	public void setLR_LOAN_SYS_ID(Long lr_loan_sys_id) {
	    LR_LOAN_SYS_ID = lr_loan_sys_id;
	}

	public void setLR_SYS_ID(Long lr_sys_id) {
	    LR_SYS_ID = lr_sys_id;
	}

	public Long getLR_LOAN_SYS_ID() {
	    return LR_LOAN_SYS_ID;
	}

	public Long getLR_SYS_ID() {
	    return LR_SYS_ID;
	}

	public String getLR_STATUS() {
	    return LR_STATUS;
	}

	public void setLR_STATUS(String lr_status) {
	    LR_STATUS = lr_status;
	}

	public Date getLR_CR_DT() {
	    return LR_CR_DT;
	}

	public void setLR_CR_DT(Date lr_cr_dt) {
	    LR_CR_DT = lr_cr_dt;
	}

	public String getLR_CR_UID() {
	    return LR_CR_UID;
	}

	public void setLR_CR_UID(String lr_cr_uid) {
	    LR_CR_UID = lr_cr_uid;
	}

	public Date getLR_UPD_DT() {
	    return LR_UPD_DT;
	}

	public void setLR_UPD_DT(Date lr_upd_dt) {
	    LR_UPD_DT = lr_upd_dt;
	}

	public String getLR_UPD_UID() {
	    return LR_UPD_UID;
	}

	public void setLR_UPD_UID(String lr_upd_uid) {
	    LR_UPD_UID = lr_upd_uid;
	}

	public String getLR_FLAG() {
	    return LR_FLAG;
	}

	public void setLR_FLAG(String lr_flag) {
	    LR_FLAG = lr_flag;
	}

	public String getLR_PYMT_REF_NO() {
	    return LR_PYMT_REF_NO;
	}

	public void setLR_PYMT_REF_NO(String lr_pymt_ref_no) {
	    LR_PYMT_REF_NO = lr_pymt_ref_no;
	}

	public String getLR_REVERSAL_FLAG() {
	    return LR_REVERSAL_FLAG;
	}

	public void setLR_REVERSAL_FLAG(String lr_reversal_flag) {
	    LR_REVERSAL_FLAG = lr_reversal_flag;
	}

	public Double getLR_DRCR_ACNT_YEAR() {
	    return LR_DRCR_ACNT_YEAR;
	}

	public void setLR_DRCR_ACNT_YEAR(Double lr_drcr_acnt_year) {
	    LR_DRCR_ACNT_YEAR = lr_drcr_acnt_year;
	}

	public String getLR_DRCR_TXN_CODE() {
	    return LR_DRCR_TXN_CODE;
	}

	public void setLR_DRCR_TXN_CODE(String lr_drcr_txn_code) {
	    LR_DRCR_TXN_CODE = lr_drcr_txn_code;
	}

	public Double getLR_DRCR_DOC_NO() {
	    return LR_DRCR_DOC_NO;
	}

	public void setLR_DRCR_DOC_NO(Double lr_drcr_doc_no) {
	    LR_DRCR_DOC_NO = lr_drcr_doc_no;
	}

	public Date getLR_DRCR_DOC_DT() {
	    return LR_DRCR_DOC_DT;
	}

	public void setLR_DRCR_DOC_DT(Date lr_drcr_doc_dt) {
	    LR_DRCR_DOC_DT = lr_drcr_doc_dt;
	}
 
}
