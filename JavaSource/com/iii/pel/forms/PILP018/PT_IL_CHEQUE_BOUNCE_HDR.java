package com.iii.pel.forms.PILP018;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_CHEQUE_BOUNCE_HDR")
public class PT_IL_CHEQUE_BOUNCE_HDR extends BaseValueBean {

	@Column(name="CBH_SYS_ID")
	private Long CBH_SYS_ID;

	@Column(name="CBH_LR_SYS_ID")
	private Long CBH_LR_SYS_ID;

	@Column(name="CBH_PD_SYS_ID")
	private Long CBH_PD_SYS_ID;

	@Column(name="CBH_DEP_SYS_ID")
	private Long CBH_DEP_SYS_ID;

	@Column(name="CBH_PC_SYS_ID")
	private Long CBH_PC_SYS_ID;

	@Column(name="CBH_POL_SYS_ID")
	private Long CBH_POL_SYS_ID;

	@Column(name="CBH_TXN_SYS_ID")
	private Long CBH_TXN_SYS_ID;

	@Column(name="CBH_TXN_TYPE")
	private String CBH_TXN_TYPE;

	@Column(name="CBH_POL_NO")
	private String CBH_POL_NO;

	@Column(name="CBH_POL_CONT_NAME")
	private String CBH_POL_CONT_NAME;

	@Column(name="CBH_POL_ISSUE_DT")
	private Date CBH_POL_ISSUE_DT;

	@Column(name="CBH_POL_START_DT")
	private Date CBH_POL_START_DT;

	@Column(name="CBH_POL_EXPIRY_DT")
	private Date CBH_POL_EXPIRY_DT;

	@Column(name="CBH_POL_PROD_CODE")
	private String CBH_POL_PROD_CODE;

	@Column(name="CBH_PC_SCHD_PYMT_DT")
	private Date CBH_PC_SCHD_PYMT_DT;

	@Column(name="CBH_PC_FC_AVLB_BAL_AMT")
	private Double CBH_PC_FC_AVLB_BAL_AMT;

	@Column(name="CBH_PC_LC_AVLB_BAL_AMT")
	private Double CBH_PC_LC_AVLB_BAL_AMT;

	@Column(name="CBH_PC_FC_PAID_AMT")
	private Double CBH_PC_FC_PAID_AMT;

	@Column(name="CBH_PC_LC_PAID_AMT")
	private Double CBH_PC_LC_PAID_AMT;

	@Column(name="CBH_FC_NET_PREM")
	private Double CBH_FC_NET_PREM;

	@Column(name="CBH_LC_NET_PREM")
	private Double CBH_LC_NET_PREM;

	@Column(name="CBH_LOAN_REF_NO")
	private String CBH_LOAN_REF_NO;

	@Column(name="CBH_LOAN_DT")
	private Date CBH_LOAN_DT;

	@Column(name="CBH_LR_PYMT_DT")
	private Date CBH_LR_PYMT_DT;

	@Column(name="CBH_LR_FC_PYMT_AMT")
	private Double CBH_LR_FC_PYMT_AMT;

	@Column(name="CBH_LR_LC_PYMT_AMT")
	private Double CBH_LR_LC_PYMT_AMT;

	@Column(name="CBH_LR_LC_LOAN_AMT")
	private Double CBH_LR_LC_LOAN_AMT;

	@Column(name="CBH_LR_FC_LOAN_AMT")
	private Double CBH_LR_FC_LOAN_AMT;

	@Column(name="CBH_LR_LC_INT_AMT")
	private Double CBH_LR_LC_INT_AMT;

	@Column(name="CBH_LR_FC_INT_AMT")
	private Double CBH_LR_FC_INT_AMT;

	@Column(name="CBH_DEP_REF_ID")
	private String CBH_DEP_REF_ID;

	@Column(name="CBH_DEP_FC_AMT")
	private Double CBH_DEP_FC_AMT;

	@Column(name="CBH_DEP_LC_AMT")
	private Double CBH_DEP_LC_AMT;

	@Column(name="CBH_REASON_CODE")
	private String CBH_REASON_CODE;

	@Column(name="CBH_REMARKS")
	private String CBH_REMARKS;

	@Column(name="CBH_DRCR_ACNT_YEAR")
	private Double CBH_DRCR_ACNT_YEAR;

	@Column(name="CBH_DRCR_TXN_CODE")
	private String CBH_DRCR_TXN_CODE;

	@Column(name="CBH_DRCR_DOC_NO")
	private Double CBH_DRCR_DOC_NO;

	@Column(name="CBH_DRCR_DOC_DT")
	private Date CBH_DRCR_DOC_DT;

	@Column(name="CBH_REVERSE_YN")
	private String CBH_REVERSE_YN;

	@Column(name="CBH_CR_DT")
	private Date CBH_CR_DT;

	@Column(name="CBH_CR_UID")
	private String CBH_CR_UID;

	@Column(name="CBH_UPD_DT")
	private Date CBH_UPD_DT;

	@Column(name="CBH_UPD_UID")
	private String CBH_UPD_UID;

	@Column(name="CBH_CHQ_NO")
	private String CBH_CHQ_NO;

	@Column(name="CBH_BANK_CODE")
	private String CBH_BANK_CODE;

	@Column(name="CBH_RH_CONTROL_NO")
	private String CBH_RH_CONTROL_NO;

	private String UI_M_BANK_CODE;
	private String UI_M_BANK_DESC;
	private String UI_M_CHQ_NO;
	private String UI_M_CBH_REASON_CODE;
	private String UI_M_REASON_CODE_DESC;
	private String UI_M_CBH_REMARKS;
	private String UI_M_TXN_TYPE_DESC;
	private String M_WHERE;
	
	
	public void setCBH_DRCR_DOC_DT(Date CBH_DRCR_DOC_DT) {
		this.CBH_DRCR_DOC_DT = CBH_DRCR_DOC_DT;
	}
	public Date getCBH_DRCR_DOC_DT() {
		 return CBH_DRCR_DOC_DT;
	}
	public void setCBH_LR_LC_PYMT_AMT(Double CBH_LR_LC_PYMT_AMT) {
		this.CBH_LR_LC_PYMT_AMT = CBH_LR_LC_PYMT_AMT;
	}
	public Double getCBH_LR_LC_PYMT_AMT() {
		 return CBH_LR_LC_PYMT_AMT;
	}
	public void setCBH_LR_SYS_ID(Long CBH_LR_SYS_ID) {
		this.CBH_LR_SYS_ID = CBH_LR_SYS_ID;
	}
	public Long getCBH_LR_SYS_ID() {
		 return CBH_LR_SYS_ID;
	}
	public void setCBH_PC_FC_AVLB_BAL_AMT(Double CBH_PC_FC_AVLB_BAL_AMT) {
		this.CBH_PC_FC_AVLB_BAL_AMT = CBH_PC_FC_AVLB_BAL_AMT;
	}
	public Double getCBH_PC_FC_AVLB_BAL_AMT() {
		 return CBH_PC_FC_AVLB_BAL_AMT;
	}
	public void setUI_M_REASON_CODE_DESC(String UI_M_REASON_CODE_DESC) {
		this.UI_M_REASON_CODE_DESC = UI_M_REASON_CODE_DESC;
	}
	public String getUI_M_REASON_CODE_DESC() {
		 return UI_M_REASON_CODE_DESC;
	}
	public void setCBH_LR_LC_INT_AMT(Double CBH_LR_LC_INT_AMT) {
		this.CBH_LR_LC_INT_AMT = CBH_LR_LC_INT_AMT;
	}
	public Double getCBH_LR_LC_INT_AMT() {
		 return CBH_LR_LC_INT_AMT;
	}
	public void setCBH_PD_SYS_ID(Long CBH_PD_SYS_ID) {
		this.CBH_PD_SYS_ID = CBH_PD_SYS_ID;
	}
	public Long getCBH_PD_SYS_ID() {
		 return CBH_PD_SYS_ID;
	}
	public void setCBH_POL_SYS_ID(Long CBH_POL_SYS_ID) {
		this.CBH_POL_SYS_ID = CBH_POL_SYS_ID;
	}
	public Long getCBH_POL_SYS_ID() {
		 return CBH_POL_SYS_ID;
	}
	public void setCBH_DEP_FC_AMT(Double CBH_DEP_FC_AMT) {
		this.CBH_DEP_FC_AMT = CBH_DEP_FC_AMT;
	}
	public Double getCBH_DEP_FC_AMT() {
		 return CBH_DEP_FC_AMT;
	}
	public void setUI_M_CBH_REMARKS(String UI_M_CBH_REMARKS) {
		this.UI_M_CBH_REMARKS = UI_M_CBH_REMARKS;
	}
	public String getUI_M_CBH_REMARKS() {
		 return UI_M_CBH_REMARKS;
	}
	public void setCBH_LR_FC_INT_AMT(Double CBH_LR_FC_INT_AMT) {
		this.CBH_LR_FC_INT_AMT = CBH_LR_FC_INT_AMT;
	}
	public Double getCBH_LR_FC_INT_AMT() {
		 return CBH_LR_FC_INT_AMT;
	}
	public void setCBH_REMARKS(String CBH_REMARKS) {
		this.CBH_REMARKS = CBH_REMARKS;
	}
	public String getCBH_REMARKS() {
		 return CBH_REMARKS;
	}
	public void setCBH_TXN_SYS_ID(Long CBH_TXN_SYS_ID) {
		this.CBH_TXN_SYS_ID = CBH_TXN_SYS_ID;
	}
	public Long getCBH_TXN_SYS_ID() {
		 return CBH_TXN_SYS_ID;
	}
	public void setCBH_POL_CONT_NAME(String CBH_POL_CONT_NAME) {
		this.CBH_POL_CONT_NAME = CBH_POL_CONT_NAME;
	}
	public String getCBH_POL_CONT_NAME() {
		 return CBH_POL_CONT_NAME;
	}
	public void setCBH_PC_LC_AVLB_BAL_AMT(Double CBH_PC_LC_AVLB_BAL_AMT) {
		this.CBH_PC_LC_AVLB_BAL_AMT = CBH_PC_LC_AVLB_BAL_AMT;
	}
	public Double getCBH_PC_LC_AVLB_BAL_AMT() {
		 return CBH_PC_LC_AVLB_BAL_AMT;
	}
	public void setCBH_UPD_DT(Date CBH_UPD_DT) {
		this.CBH_UPD_DT = CBH_UPD_DT;
	}
	public Date getCBH_UPD_DT() {
		 return CBH_UPD_DT;
	}
	public void setCBH_CHQ_NO(String CBH_CHQ_NO) {
		this.CBH_CHQ_NO = CBH_CHQ_NO;
	}
	public String getCBH_CHQ_NO() {
		 return CBH_CHQ_NO;
	}
	public void setCBH_REVERSE_YN(String CBH_REVERSE_YN) {
		this.CBH_REVERSE_YN = CBH_REVERSE_YN;
	}
	public String getCBH_REVERSE_YN() {
		 return CBH_REVERSE_YN;
	}
	public void setCBH_PC_FC_PAID_AMT(Double CBH_PC_FC_PAID_AMT) {
		this.CBH_PC_FC_PAID_AMT = CBH_PC_FC_PAID_AMT;
	}
	public Double getCBH_PC_FC_PAID_AMT() {
		 return CBH_PC_FC_PAID_AMT;
	}
	public void setCBH_SYS_ID(Long CBH_SYS_ID) {
		this.CBH_SYS_ID = CBH_SYS_ID;
	}
	public Long getCBH_SYS_ID() {
		 return CBH_SYS_ID;
	}
	public void setUI_M_BANK_DESC(String UI_M_BANK_DESC) {
		this.UI_M_BANK_DESC = UI_M_BANK_DESC;
	}
	public String getUI_M_BANK_DESC() {
		 return UI_M_BANK_DESC;
	}
	public void setUI_M_CBH_REASON_CODE(String UI_M_CBH_REASON_CODE) {
		this.UI_M_CBH_REASON_CODE = UI_M_CBH_REASON_CODE;
	}
	public String getUI_M_CBH_REASON_CODE() {
		 return UI_M_CBH_REASON_CODE;
	}
	public void setCBH_DRCR_TXN_CODE(String CBH_DRCR_TXN_CODE) {
		this.CBH_DRCR_TXN_CODE = CBH_DRCR_TXN_CODE;
	}
	public String getCBH_DRCR_TXN_CODE() {
		 return CBH_DRCR_TXN_CODE;
	}
	public void setCBH_UPD_UID(String CBH_UPD_UID) {
		this.CBH_UPD_UID = CBH_UPD_UID;
	}
	public String getCBH_UPD_UID() {
		 return CBH_UPD_UID;
	}
	public void setCBH_LR_FC_PYMT_AMT(Double CBH_LR_FC_PYMT_AMT) {
		this.CBH_LR_FC_PYMT_AMT = CBH_LR_FC_PYMT_AMT;
	}
	public Double getCBH_LR_FC_PYMT_AMT() {
		 return CBH_LR_FC_PYMT_AMT;
	}
	public void setCBH_LR_FC_LOAN_AMT(Double CBH_LR_FC_LOAN_AMT) {
		this.CBH_LR_FC_LOAN_AMT = CBH_LR_FC_LOAN_AMT;
	}
	public Double getCBH_LR_FC_LOAN_AMT() {
		 return CBH_LR_FC_LOAN_AMT;
	}
	public void setCBH_CR_DT(Date CBH_CR_DT) {
		this.CBH_CR_DT = CBH_CR_DT;
	}
	public Date getCBH_CR_DT() {
		 return CBH_CR_DT;
	}
	public void setCBH_LC_NET_PREM(Double CBH_LC_NET_PREM) {
		this.CBH_LC_NET_PREM = CBH_LC_NET_PREM;
	}
	public Double getCBH_LC_NET_PREM() {
		 return CBH_LC_NET_PREM;
	}
	public void setCBH_POL_ISSUE_DT(Date CBH_POL_ISSUE_DT) {
		this.CBH_POL_ISSUE_DT = CBH_POL_ISSUE_DT;
	}
	public Date getCBH_POL_ISSUE_DT() {
		 return CBH_POL_ISSUE_DT;
	}
	public void setCBH_RH_CONTROL_NO(String CBH_RH_CONTROL_NO) {
		this.CBH_RH_CONTROL_NO = CBH_RH_CONTROL_NO;
	}
	public String getCBH_RH_CONTROL_NO() {
		 return CBH_RH_CONTROL_NO;
	}
	public void setCBH_POL_NO(String CBH_POL_NO) {
		this.CBH_POL_NO = CBH_POL_NO;
	}
	public String getCBH_POL_NO() {
		 return CBH_POL_NO;
	}
	public void setUI_M_TXN_TYPE_DESC(String UI_M_TXN_TYPE_DESC) {
		this.UI_M_TXN_TYPE_DESC = UI_M_TXN_TYPE_DESC;
	}
	public String getUI_M_TXN_TYPE_DESC() {
		 return UI_M_TXN_TYPE_DESC;
	}
	public void setCBH_DEP_REF_ID(String CBH_DEP_REF_ID) {
		this.CBH_DEP_REF_ID = CBH_DEP_REF_ID;
	}
	public String getCBH_DEP_REF_ID() {
		 return CBH_DEP_REF_ID;
	}
	public void setCBH_POL_PROD_CODE(String CBH_POL_PROD_CODE) {
		this.CBH_POL_PROD_CODE = CBH_POL_PROD_CODE;
	}
	public String getCBH_POL_PROD_CODE() {
		 return CBH_POL_PROD_CODE;
	}
	public void setCBH_BANK_CODE(String CBH_BANK_CODE) {
		this.CBH_BANK_CODE = CBH_BANK_CODE;
	}
	public String getCBH_BANK_CODE() {
		 return CBH_BANK_CODE;
	}
	public void setCBH_POL_EXPIRY_DT(Date CBH_POL_EXPIRY_DT) {
		this.CBH_POL_EXPIRY_DT = CBH_POL_EXPIRY_DT;
	}
	public Date getCBH_POL_EXPIRY_DT() {
		 return CBH_POL_EXPIRY_DT;
	}
	public void setCBH_DRCR_ACNT_YEAR(Double CBH_DRCR_ACNT_YEAR) {
		this.CBH_DRCR_ACNT_YEAR = CBH_DRCR_ACNT_YEAR;
	}
	public Double getCBH_DRCR_ACNT_YEAR() {
		 return CBH_DRCR_ACNT_YEAR;
	}
	public void setCBH_PC_SCHD_PYMT_DT(Date CBH_PC_SCHD_PYMT_DT) {
		this.CBH_PC_SCHD_PYMT_DT = CBH_PC_SCHD_PYMT_DT;
	}
	public Date getCBH_PC_SCHD_PYMT_DT() {
		 return CBH_PC_SCHD_PYMT_DT;
	}
	public void setUI_M_CHQ_NO(String UI_M_CHQ_NO) {
		this.UI_M_CHQ_NO = UI_M_CHQ_NO;
	}
	public String getUI_M_CHQ_NO() {
		 return UI_M_CHQ_NO;
	}
	public void setCBH_POL_START_DT(Date CBH_POL_START_DT) {
		this.CBH_POL_START_DT = CBH_POL_START_DT;
	}
	public Date getCBH_POL_START_DT() {
		 return CBH_POL_START_DT;
	}
	public void setCBH_LOAN_DT(Date CBH_LOAN_DT) {
		this.CBH_LOAN_DT = CBH_LOAN_DT;
	}
	public Date getCBH_LOAN_DT() {
		 return CBH_LOAN_DT;
	}
	public void setCBH_REASON_CODE(String CBH_REASON_CODE) {
		this.CBH_REASON_CODE = CBH_REASON_CODE;
	}
	public String getCBH_REASON_CODE() {
		 return CBH_REASON_CODE;
	}
	public void setCBH_LOAN_REF_NO(String CBH_LOAN_REF_NO) {
		this.CBH_LOAN_REF_NO = CBH_LOAN_REF_NO;
	}
	public String getCBH_LOAN_REF_NO() {
		 return CBH_LOAN_REF_NO;
	}
	public void setCBH_DEP_SYS_ID(Long CBH_DEP_SYS_ID) {
		this.CBH_DEP_SYS_ID = CBH_DEP_SYS_ID;
	}
	public Long getCBH_DEP_SYS_ID() {
		 return CBH_DEP_SYS_ID;
	}
	public void setCBH_DRCR_DOC_NO(Double CBH_DRCR_DOC_NO) {
		this.CBH_DRCR_DOC_NO = CBH_DRCR_DOC_NO;
	}
	public Double getCBH_DRCR_DOC_NO() {
		 return CBH_DRCR_DOC_NO;
	}
	public void setCBH_LR_LC_LOAN_AMT(Double CBH_LR_LC_LOAN_AMT) {
		this.CBH_LR_LC_LOAN_AMT = CBH_LR_LC_LOAN_AMT;
	}
	public Double getCBH_LR_LC_LOAN_AMT() {
		 return CBH_LR_LC_LOAN_AMT;
	}
	public void setCBH_CR_UID(String CBH_CR_UID) {
		this.CBH_CR_UID = CBH_CR_UID;
	}
	public String getCBH_CR_UID() {
		 return CBH_CR_UID;
	}
	public void setCBH_DEP_LC_AMT(Double CBH_DEP_LC_AMT) {
		this.CBH_DEP_LC_AMT = CBH_DEP_LC_AMT;
	}
	public Double getCBH_DEP_LC_AMT() {
		 return CBH_DEP_LC_AMT;
	}
	public void setUI_M_BANK_CODE(String UI_M_BANK_CODE) {
		this.UI_M_BANK_CODE = UI_M_BANK_CODE;
	}
	public String getUI_M_BANK_CODE() {
		 return UI_M_BANK_CODE;
	}
	public void setCBH_LR_PYMT_DT(Date CBH_LR_PYMT_DT) {
		this.CBH_LR_PYMT_DT = CBH_LR_PYMT_DT;
	}
	public Date getCBH_LR_PYMT_DT() {
		 return CBH_LR_PYMT_DT;
	}
	public void setCBH_PC_SYS_ID(Long CBH_PC_SYS_ID) {
		this.CBH_PC_SYS_ID = CBH_PC_SYS_ID;
	}
	public Long getCBH_PC_SYS_ID() {
		 return CBH_PC_SYS_ID;
	}
	public void setCBH_FC_NET_PREM(Double CBH_FC_NET_PREM) {
		this.CBH_FC_NET_PREM = CBH_FC_NET_PREM;
	}
	public Double getCBH_FC_NET_PREM() {
		 return CBH_FC_NET_PREM;
	}
	public void setCBH_TXN_TYPE(String CBH_TXN_TYPE) {
		this.CBH_TXN_TYPE = CBH_TXN_TYPE;
	}
	public String getCBH_TXN_TYPE() {
		 return CBH_TXN_TYPE;
	}
	public void setCBH_PC_LC_PAID_AMT(Double CBH_PC_LC_PAID_AMT) {
		this.CBH_PC_LC_PAID_AMT = CBH_PC_LC_PAID_AMT;
	}
	public Double getCBH_PC_LC_PAID_AMT() {
		 return CBH_PC_LC_PAID_AMT;
	}
	public String getM_WHERE() {
	    return M_WHERE;
	}
	public void setM_WHERE(String m_where) {
	    M_WHERE = m_where;
	}

}