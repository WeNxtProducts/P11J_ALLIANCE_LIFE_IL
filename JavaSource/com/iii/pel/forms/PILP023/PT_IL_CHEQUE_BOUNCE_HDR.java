package com.iii.pel.forms.PILP023;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_CHEQUE_BOUNCE_HDR")
public class PT_IL_CHEQUE_BOUNCE_HDR extends BaseValueBean {

	
	private String UI_M_DEP_TXN_CODE;

	/*Modified by Ram on 25/12/2016 for Save or configure DB Columns*/
	@Column(name="CBH_DRCR_DOC_NO")
	private Integer UI_M_DEP_DOC_NO;
	/*End*/

	/*Modified by Ram on 25/12/2016 for Save or configure DB Columns*/
	@Column(name="CBH_DRCR_DOC_DT")
	/*End*/
	private Date UI_M_DEP_DOC_DT;
	
	/*Modified by Ram on 25/12/2016 for Save or configure DB Columns*/
	@Column(name="CBH_REASON_CODE")
	/*End*/
	private String UI_M_CBH_REASON_CODE;

	private String UI_M_REASON_CODE_DESC;

	/*Modified by Ram on 25/12/2016 for Save or configure DB Columns*/
	@Column(name="CBH_LOAN_REF_NO")
	/*End*/
	private String UI_M_CBH_REVERSAL_REF_NO;

	/*Modified by Ram on 25/12/2016 for Save or configure DB Columns*/
	@Column(name="CBH_REMARKS")
	/*End*/
	private String UI_M_CBH_REMARKS;

	@Column(name="CBH_POL_NO")
	private String CBH_POL_NO;

	@Column(name="CBH_POL_CONT_NAME")
	private String CBH_POL_CONT_NAME;

	private String UI_M_TXN_TYPE_DESC;

	@Column(name="CBH_POL_ISSUE_DT")
	private Date CBH_POL_ISSUE_DT;

	@Column(name="CBH_POL_START_DT")
	private Date CBH_POL_START_DT;

	@Column(name="CBH_POL_EXPIRY_DT")
	private Date CBH_POL_EXPIRY_DT;

	@Column(name="CBH_POL_PROD_CODE")
	private String CBH_POL_PROD_CODE;
	
	@Column(name="CBH_TXN_TYPE")
	private String CBH_TXN_TYPE;
	
	@Column(name="CBH_SYS_ID")
	private Double CBH_SYS_ID;
	
	private Double UI_M_DEP_SYS_ID;
	
	@Column(name="CBH_LR_SYS_ID")
	private Double CBH_LR_SYS_ID;
	
	@Column(name="CBH_PC_SYS_ID")
	private Double CBH_PC_SYS_ID;
	
	@Column(name="CBH_POL_SYS_ID")
	private Double CBH_POL_SYS_ID;
	
	@Column(name="CBH_DEP_SYS_ID")
	private Double CBH_DEP_SYS_ID;
	
	private String UI_M_DEP_REASON_CODE;
	
	private String UI_M_REVERSAL_FLAG;
	
	private String UI_M_DEP_REV_REMARKS;
	
	private String UI_M_ACNT_YEAR;
	
	private boolean M_CHECK_FLAG;
	
	private boolean UI_M_CHECK_BOX;
	
	private boolean checkBoxValue;
	
	private String UI_M_REC_AMT;

	public String getUI_M_REC_AMT() {
		return UI_M_REC_AMT;
	}

	public void setUI_M_REC_AMT(String uI_M_REC_AMT) {
		UI_M_REC_AMT = uI_M_REC_AMT;
	}

	public boolean isCheckBoxValue() {
		return checkBoxValue;
	}

	public void setCheckBoxValue(boolean checkBoxValue) {
		this.checkBoxValue = checkBoxValue;
	}

	public boolean isUI_M_CHECK_BOX() {
		return UI_M_CHECK_BOX;
	}

	public void setUI_M_CHECK_BOX(boolean ui_m_check_box) {
		UI_M_CHECK_BOX = ui_m_check_box;
	}

	public boolean isM_CHECK_FLAG() {
		return M_CHECK_FLAG;
	}

	public void setM_CHECK_FLAG(boolean m_check_flag) {
		M_CHECK_FLAG = m_check_flag;
	}

	public String getCBH_TXN_TYPE() {
		return CBH_TXN_TYPE;
	}

	public void setCBH_TXN_TYPE(String cbh_txn_type) {
		CBH_TXN_TYPE = cbh_txn_type;
	}

	public String getUI_M_DEP_TXN_CODE() {
		return UI_M_DEP_TXN_CODE;
	}

	public void setUI_M_DEP_TXN_CODE(String UI_M_DEP_TXN_CODE) {
		this.UI_M_DEP_TXN_CODE = UI_M_DEP_TXN_CODE;
	}


	public Integer getUI_M_DEP_DOC_NO() {
		return UI_M_DEP_DOC_NO;
	}

	public void setUI_M_DEP_DOC_NO(Integer ui_m_dep_doc_no) {
		UI_M_DEP_DOC_NO = ui_m_dep_doc_no;
	}

	public Date getUI_M_DEP_DOC_DT() {
		 return UI_M_DEP_DOC_DT;
	}

	public void setUI_M_DEP_DOC_DT(Date UI_M_DEP_DOC_DT) {
		this.UI_M_DEP_DOC_DT = UI_M_DEP_DOC_DT;
	}

	public String getUI_M_CBH_REASON_CODE() {
		return UI_M_CBH_REASON_CODE;
	}

	public void setUI_M_CBH_REASON_CODE(String UI_M_CBH_REASON_CODE) {
		this.UI_M_CBH_REASON_CODE = UI_M_CBH_REASON_CODE;
	}

	public String getUI_M_REASON_CODE_DESC() {
		return UI_M_REASON_CODE_DESC;
	}

	public void setUI_M_REASON_CODE_DESC(String UI_M_REASON_CODE_DESC) {
		this.UI_M_REASON_CODE_DESC = UI_M_REASON_CODE_DESC;
	}

	public String getUI_M_CBH_REVERSAL_REF_NO() {
		return UI_M_CBH_REVERSAL_REF_NO;
	}

	public void setUI_M_CBH_REVERSAL_REF_NO(String UI_M_CBH_REVERSAL_REF_NO) {
		this.UI_M_CBH_REVERSAL_REF_NO = UI_M_CBH_REVERSAL_REF_NO;
	}

	public String getUI_M_CBH_REMARKS() {
		return UI_M_CBH_REMARKS;
	}

	public void setUI_M_CBH_REMARKS(String UI_M_CBH_REMARKS) {
		this.UI_M_CBH_REMARKS = UI_M_CBH_REMARKS;
	}

	public String getCBH_POL_NO() {
		return CBH_POL_NO;
	}

	public void setCBH_POL_NO(String CBH_POL_NO) {
		this.CBH_POL_NO = CBH_POL_NO;
	}

	public String getCBH_POL_CONT_NAME() {
		return CBH_POL_CONT_NAME;
	}

	public void setCBH_POL_CONT_NAME(String CBH_POL_CONT_NAME) {
		this.CBH_POL_CONT_NAME = CBH_POL_CONT_NAME;
	}

	public String getUI_M_TXN_TYPE_DESC() {
		return UI_M_TXN_TYPE_DESC;
	}

	public void setUI_M_TXN_TYPE_DESC(String UI_M_TXN_TYPE_DESC) {
		this.UI_M_TXN_TYPE_DESC = UI_M_TXN_TYPE_DESC;
	}

	public Date getCBH_POL_ISSUE_DT() {
		 return CBH_POL_ISSUE_DT;
	}

	public void setCBH_POL_ISSUE_DT(Date CBH_POL_ISSUE_DT) {
		this.CBH_POL_ISSUE_DT = CBH_POL_ISSUE_DT;
	}

	public Date getCBH_POL_START_DT() {
		 return CBH_POL_START_DT;
	}

	public void setCBH_POL_START_DT(Date CBH_POL_START_DT) {
		this.CBH_POL_START_DT = CBH_POL_START_DT;
	}

	public Date getCBH_POL_EXPIRY_DT() {
		 return CBH_POL_EXPIRY_DT;
	}

	public void setCBH_POL_EXPIRY_DT(Date CBH_POL_EXPIRY_DT) {
		this.CBH_POL_EXPIRY_DT = CBH_POL_EXPIRY_DT;
	}

	public String getCBH_POL_PROD_CODE() {
		return CBH_POL_PROD_CODE;
	}

	public void setCBH_POL_PROD_CODE(String CBH_POL_PROD_CODE) {
		this.CBH_POL_PROD_CODE = CBH_POL_PROD_CODE;
	}

	public Double getCBH_SYS_ID() {
		return CBH_SYS_ID;
	}

	public void setCBH_SYS_ID(Double cbh_sys_id) {
		CBH_SYS_ID = cbh_sys_id;
	}

	public Double getUI_M_DEP_SYS_ID() {
		return UI_M_DEP_SYS_ID;
	}

	public void setUI_M_DEP_SYS_ID(Double ui_m_dep_sys_id) {
		UI_M_DEP_SYS_ID = ui_m_dep_sys_id;
	}

	public String getUI_M_DEP_REASON_CODE() {
		return UI_M_DEP_REASON_CODE;
	}

	public void setUI_M_DEP_REASON_CODE(String ui_m_dep_reason_code) {
		UI_M_DEP_REASON_CODE = ui_m_dep_reason_code;
	}

	public String getUI_M_REVERSAL_FLAG() {
		return UI_M_REVERSAL_FLAG;
	}

	public void setUI_M_REVERSAL_FLAG(String ui_m_reversal_flag) {
		UI_M_REVERSAL_FLAG = ui_m_reversal_flag;
	}

	public String getUI_M_DEP_REV_REMARKS() {
		return UI_M_DEP_REV_REMARKS;
	}

	public void setUI_M_DEP_REV_REMARKS(String ui_m_dep_rev_remarks) {
		UI_M_DEP_REV_REMARKS = ui_m_dep_rev_remarks;
	}

	public String getUI_M_ACNT_YEAR() {
		return UI_M_ACNT_YEAR;
	}

	public void setUI_M_ACNT_YEAR(String ui_m_acnt_year) {
		UI_M_ACNT_YEAR = ui_m_acnt_year;
	}

	public Double getCBH_LR_SYS_ID() {
		return CBH_LR_SYS_ID;
	}

	public void setCBH_LR_SYS_ID(Double cbh_lr_sys_id) {
		CBH_LR_SYS_ID = cbh_lr_sys_id;
	}

	public Double getCBH_PC_SYS_ID() {
		return CBH_PC_SYS_ID;
	}

	public void setCBH_PC_SYS_ID(Double cbh_pc_sys_id) {
		CBH_PC_SYS_ID = cbh_pc_sys_id;
	}

	public Double getCBH_POL_SYS_ID() {
		return CBH_POL_SYS_ID;
	}

	public void setCBH_POL_SYS_ID(Double cbh_pol_sys_id) {
		CBH_POL_SYS_ID = cbh_pol_sys_id;
	}

	public Double getCBH_DEP_SYS_ID() {
		return CBH_DEP_SYS_ID;
	}

	public void setCBH_DEP_SYS_ID(Double cbh_dep_sys_id) {
		CBH_DEP_SYS_ID = cbh_dep_sys_id;
	}

/*Added by Ram on 25/12/2016 for Save Record Function*/
	@Column(name="CBH_CR_DT")
	private Date  CBH_CR_DT;
	
	@Column(name="CBH_CR_UID")
	private String  CBH_CR_UID;

	public Date getCBH_CR_DT() {
		return CBH_CR_DT;
	}

	public void setCBH_CR_DT(Date cBH_CR_DT) {
		CBH_CR_DT = cBH_CR_DT;
	}

	public String getCBH_CR_UID() {
		return CBH_CR_UID;
	}

	public void setCBH_CR_UID(String cBH_CR_UID) {
		CBH_CR_UID = cBH_CR_UID;
	}
/*End*/
	
	private String UI_M_CBH_POL_ISSUE_DT;

	public String getUI_M_CBH_POL_ISSUE_DT() {
		return UI_M_CBH_POL_ISSUE_DT;
	}

	public void setUI_M_CBH_POL_ISSUE_DT(String uI_M_CBH_POL_ISSUE_DT) {
		UI_M_CBH_POL_ISSUE_DT = uI_M_CBH_POL_ISSUE_DT;
	}
	
}
