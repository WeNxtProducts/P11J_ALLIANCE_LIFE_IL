package com.iii.pel.forms.PILT016A_APAC;

import java.util.Date;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_DEPOSIT")
public class PT_IL_DEPOSIT extends BaseValueBean {

	@Column(name="DEP_CONT_REF_ID1")   // Search bean field
	private String DEP_CONT_REF_ID1;

	@Column(name="DEP_GROSS_NET_FLAG")
	private String DEP_GROSS_NET_FLAG;

	@Column(name="DEP_CONT_REF_ID2")    // Search bean field
	private String DEP_CONT_REF_ID2;

	@Column(name="DEP_TXN_CODE")
	private String DEP_TXN_CODE;

	@Column(name="DEP_REF_NO")    // Search bean field
	private String DEP_REF_NO;

	@Column(name="DEP_DOC_NO")
	private int DEP_DOC_NO;

	@Column(name="DEP_TEMP_RCPT_NO")
	private String DEP_TEMP_RCPT_NO;

	@Column(name="DEP_DOC_DT")
	private Date DEP_DOC_DT;

	@Column(name="DEP_CUST_CODE")
	private String DEP_CUST_CODE;
	
	@Column(name="DEP_PDC_FLAG")
	private String DEP_PDC_FLAG;
	
	private String UI_M_CUST_NAME;

	@Column(name="DEP_ACNT_YEAR")
	private Integer DEP_ACNT_YEAR;

	@Column(name="DEP_CONT_CODE")
	private String DEP_CONT_CODE;

	private String UI_M_CONT_NAME;

	@Column(name="DEP_REPL_RCPT_YN")
	private String DEP_REPL_RCPT_YN;

	@Column(name="DEP_PROD_CODE")
	private String DEP_PROD_CODE;

	private String UI_M_DEP_PROD_CODE_DESC;

	@Column(name="DEP_REP_BANK_IN_SLIP_NO")
	private String DEP_REP_BANK_IN_SLIP_NO;

	@Column(name="DEP_REPL_TXN_CODE")
	private String DEP_REPL_TXN_CODE;

	@Column(name="DEP_AGENT_CODE")
	private String DEP_AGENT_CODE;

	private String UI_M_DEP_AGENT_CODE_DESC;

	@Column(name="DEP_REPL_DOC_NO")
	private Integer DEP_REPL_DOC_NO;

	@Column(name="DEP_COLL_AGENT_CODE")
	private String DEP_COLL_AGENT_CODE;

	private String UI_M_DEP_COLL_AGENT_CODE_DESC;

	@Column(name="DEP_REPL_ACC_YR")
	private Integer DEP_REPL_ACC_YR;

	private Double UI_M_POL_LC_GROSS_PREM;

	@Column(name="DEP_LC_DEP_AMT")
	private Double DEP_LC_DEP_AMT;

	private Double UI_M_POL_LC_COMMISSION;

	@Column(name="DEP_LC_OTH_AMT")
	private Double DEP_LC_OTH_AMT;

	private Double DEP_LC_TOT_AMT;

	private Double UI_M_POL_LC_NET_PREM;

	@Column(name="DEP_LC_TOTAL_AMT")
	private Double DEP_LC_TOTAL_AMT;

	@Column(name="DEP_BANK_IN_SLIP_NO")
	private String DEP_BANK_IN_SLIP_NO;

	@Column(name="DEP_DIVN_CODE")
	private String DEP_DIVN_CODE;

	private String UI_M_DEP_DIVN_DESC;
	
	private Long DEP_SYS_ID_INTEGER;
	
	@Column(name="DEP_DEPT_CODE")
	private String DEP_DEPT_CODE;

	private String UI_M_DEP_DEPT_DESC;

	@Column(name="DEP_CLASS_CODE")
	private String DEP_CLASS_CODE;

	private String UI_M_DEP_CLASS_CODE_DESC;

	@Column(name="DEP_BANKIN_CODE")
	private String DEP_BANKIN_CODE;

	private String UI_M_BANKIN_NAME;

	@Column(name="DEP_PLAN_CODE")
	private String DEP_PLAN_CODE;

	private String UI_M_DEP_PLAN_CODE_DESC;

	@Column(name="DEP_DS_CODE")
	private String DEP_DS_CODE;

	private String UI_M_DEP_DS_CODE_DESC;

	@Column(name="DEP_SRC_OF_BUS")
	private String DEP_SRC_OF_BUS;

	private String UI_M_DEP_BUS_DESC;

	@Column(name="DEP_REV_REMARKS")
	private String DEP_REV_REMARKS;
	
	@Column(name="DEP_CR_DT")
	private Date DEP_CR_DT;
	
	@Column(name="DEP_CR_UID")
	private String DEP_CR_UID;
	
	@Column(name="DEP_SYS_ID")
	private Long DEP_SYS_ID;
	
	@Column(name="DEP_UPD_DT")
	private Date DEP_UPD_DT;
	
	@Column(name="DEP_UPD_UID")
	private String DEP_UPD_UID;
	
	@Column(name="DEP_TYPE")
	private String DEP_TYPE;
	
	@Column(name="DEP_REC_REV_YN")
	private String DEP_REC_REV_YN;
	
	@Column(name="DEP_REASON_CODE")
	private String DEP_REASON_CODE;
	
	@Column(name="DEP_FLEX_01")
	private String DEP_FLEX_01;
	
	@Column(name="DEP_FLEX_02")
	private String DEP_FLEX_02;
	
	@Column(name="DEP_FLEX_03")
	private String DEP_FLEX_03;
	
	@Column(name="DEP_FLEX_04")
	private String DEP_FLEX_04;
	
	@Column(name="DEP_CHRG_TXN_CODE")
	private String DEP_CHRG_TXN_CODE;
	
	@Column(name="DEP_CHRG_DOC_NO")
	private Integer DEP_CHRG_DOC_NO;
	
	@Column(name="DEP_ADTH_BATCH_NO")
	private String DEP_ADTH_BATCH_NO;
	
	
	@Column(name="DEP_DUP_PRINT")
	private String DEP_DUP_PRINT;
	
	
	@Column(name="DEP_REV_ACNT_YEAR")
	private Integer DEP_REV_ACNT_YEAR;
	
	
	
	
	
	@Column(name="DEP_REV_CHRG_DOC_NO")
	private Integer DEP_REV_CHRG_DOC_NO;
	
	@Column(name="DEP_MAST_RCPT_YN")
	private String DEP_MAST_RCPT_YN;
	
	
	@Column(name="	DEP_REV_BANK_IN_SLIP_NO")
	private String 	DEP_REV_BANK_IN_SLIP_NO;
	
	@Column(name="DEP_REV_CHRG_TXN_CODE")
	private String DEP_REV_CHRG_TXN_CODE;
	
	@Column(name="DEP_COMM_RECPT_YN")
	private String DEP_COMM_RECPT_YN;

	private String UI_M_DEP_REV_STATUS;
	
	private String UI_M_DEP_UPD_UID;
	
	private String UI_M_APPRV_STATUS;
	
	private String UI_M_POL_STATUS;
	
	private String UI_M_REC_REVERSE;
	
	
//	[BugId:PREMIAGDC-AGENCY- 0055 Amit Gupta 25-Feb-09 Field Added	
	private String UI_M_PDC;
//	BugId:PREMIAGDC-AGENCY- 0055]
	
	private boolean approvalStatus;
	
	private String UI_M_POL_FLAG;
	
	private String UI_M_DEP_GROSS_NET_FLAG;
	
	private boolean insertedStatus;

	public String getUI_M_POL_STATUS() {
		return UI_M_POL_STATUS;
	}

	public void setUI_M_POL_STATUS(String ui_m_pol_status) {
		UI_M_POL_STATUS = ui_m_pol_status;
	}

	public String getDEP_CONT_REF_ID1() {
		return DEP_CONT_REF_ID1;
	}

	public void setDEP_CONT_REF_ID1(String DEP_CONT_REF_ID1) {
		this.DEP_CONT_REF_ID1 = DEP_CONT_REF_ID1;
	}

	public String getDEP_GROSS_NET_FLAG() {
		return DEP_GROSS_NET_FLAG;
	}

	public void setDEP_GROSS_NET_FLAG(String DEP_GROSS_NET_FLAG) {
		this.DEP_GROSS_NET_FLAG = DEP_GROSS_NET_FLAG;
	}

	public String getDEP_CONT_REF_ID2() {
		return DEP_CONT_REF_ID2;
	}

	public void setDEP_CONT_REF_ID2(String DEP_CONT_REF_ID2) {
		this.DEP_CONT_REF_ID2 = DEP_CONT_REF_ID2;
	}

	public String getDEP_TXN_CODE() {
		return DEP_TXN_CODE;
	}

	public void setDEP_TXN_CODE(String DEP_TXN_CODE) {
		this.DEP_TXN_CODE = DEP_TXN_CODE;
	}

	public String getDEP_REF_NO() {
		return DEP_REF_NO;
	}

	public void setDEP_REF_NO(String DEP_REF_NO) {
		this.DEP_REF_NO = DEP_REF_NO;
	}


	/**
	 * @return the dEP_DOC_NO
	 */
	public int getDEP_DOC_NO() {
		return DEP_DOC_NO;
	}

	/**
	 * @param dep_doc_no the dEP_DOC_NO to set
	 */
	public void setDEP_DOC_NO(int dep_doc_no) {
		DEP_DOC_NO = dep_doc_no;
	}

	public String getDEP_TEMP_RCPT_NO() {
		return DEP_TEMP_RCPT_NO;
	}

	public void setDEP_TEMP_RCPT_NO(String DEP_TEMP_RCPT_NO) {
		this.DEP_TEMP_RCPT_NO = DEP_TEMP_RCPT_NO;
	}

	public Date getDEP_DOC_DT() {
		 return DEP_DOC_DT;
	}

	public void setDEP_DOC_DT(Date DEP_DOC_DT) {
		this.DEP_DOC_DT = DEP_DOC_DT;
	}

	public String getDEP_CUST_CODE() {
		return DEP_CUST_CODE;
	}

	public void setDEP_CUST_CODE(String DEP_CUST_CODE) {
		this.DEP_CUST_CODE = DEP_CUST_CODE;
	}

	public String getUI_M_CUST_NAME() {
		return UI_M_CUST_NAME;
	}

	public void setUI_M_CUST_NAME(String UI_M_CUST_NAME) {
		this.UI_M_CUST_NAME = UI_M_CUST_NAME;
	}

	

	public String getDEP_CONT_CODE() {
		return DEP_CONT_CODE;
	}

	public void setDEP_CONT_CODE(String DEP_CONT_CODE) {
		this.DEP_CONT_CODE = DEP_CONT_CODE;
	}

	public String getUI_M_CONT_NAME() {
		return UI_M_CONT_NAME;
	}

	public void setUI_M_CONT_NAME(String UI_M_CONT_NAME) {
		this.UI_M_CONT_NAME = UI_M_CONT_NAME;
	}

	public String getDEP_REPL_RCPT_YN() {
		return DEP_REPL_RCPT_YN;
	}

	public void setDEP_REPL_RCPT_YN(String DEP_REPL_RCPT_YN) {
		this.DEP_REPL_RCPT_YN = DEP_REPL_RCPT_YN;
	}

	public String getDEP_PROD_CODE() {
		return DEP_PROD_CODE;
	}

	public void setDEP_PROD_CODE(String DEP_PROD_CODE) {
		this.DEP_PROD_CODE = DEP_PROD_CODE;
	}

	public String getUI_M_DEP_PROD_CODE_DESC() {
		return UI_M_DEP_PROD_CODE_DESC;
	}

	public void setUI_M_DEP_PROD_CODE_DESC(String UI_M_DEP_PROD_CODE_DESC) {
		this.UI_M_DEP_PROD_CODE_DESC = UI_M_DEP_PROD_CODE_DESC;
	}

	public String getDEP_REP_BANK_IN_SLIP_NO() {
		return DEP_REP_BANK_IN_SLIP_NO;
	}

	public void setDEP_REP_BANK_IN_SLIP_NO(String DEP_REP_BANK_IN_SLIP_NO) {
		this.DEP_REP_BANK_IN_SLIP_NO = DEP_REP_BANK_IN_SLIP_NO;
	}

	public String getDEP_REPL_TXN_CODE() {
		return DEP_REPL_TXN_CODE;
	}

	public void setDEP_REPL_TXN_CODE(String DEP_REPL_TXN_CODE) {
		this.DEP_REPL_TXN_CODE = DEP_REPL_TXN_CODE;
	}

	public String getDEP_AGENT_CODE() {
		return DEP_AGENT_CODE;
	}

	public void setDEP_AGENT_CODE(String DEP_AGENT_CODE) {
		this.DEP_AGENT_CODE = DEP_AGENT_CODE;
	}

	public String getUI_M_DEP_AGENT_CODE_DESC() {
		return UI_M_DEP_AGENT_CODE_DESC;
	}

	public void setUI_M_DEP_AGENT_CODE_DESC(String UI_M_DEP_AGENT_CODE_DESC) {
		this.UI_M_DEP_AGENT_CODE_DESC = UI_M_DEP_AGENT_CODE_DESC;
	}

	public Integer getDEP_REPL_DOC_NO() {
		return DEP_REPL_DOC_NO;
	}

	public void setDEP_REPL_DOC_NO(Integer DEP_REPL_DOC_NO) {
		this.DEP_REPL_DOC_NO = DEP_REPL_DOC_NO;
	}

	public String getDEP_COLL_AGENT_CODE() {
		return DEP_COLL_AGENT_CODE;
	}

	public void setDEP_COLL_AGENT_CODE(String DEP_COLL_AGENT_CODE) {
		this.DEP_COLL_AGENT_CODE = DEP_COLL_AGENT_CODE;
	}

	public String getUI_M_DEP_COLL_AGENT_CODE_DESC() {
		return UI_M_DEP_COLL_AGENT_CODE_DESC;
	}

	public void setUI_M_DEP_COLL_AGENT_CODE_DESC(String UI_M_DEP_COLL_AGENT_CODE_DESC) {
		this.UI_M_DEP_COLL_AGENT_CODE_DESC = UI_M_DEP_COLL_AGENT_CODE_DESC;
	}

	public Integer getDEP_REPL_ACC_YR() {
		return DEP_REPL_ACC_YR;
	}

	public void setDEP_REPL_ACC_YR(Integer DEP_REPL_ACC_YR) {
		this.DEP_REPL_ACC_YR = DEP_REPL_ACC_YR;
	}

	public Double getUI_M_POL_LC_GROSS_PREM() {
		return UI_M_POL_LC_GROSS_PREM;
	}

	public void setUI_M_POL_LC_GROSS_PREM(Double UI_M_POL_LC_GROSS_PREM) {
		this.UI_M_POL_LC_GROSS_PREM = UI_M_POL_LC_GROSS_PREM;
	}

	public Double getDEP_LC_DEP_AMT() {
		return DEP_LC_DEP_AMT;
	}

	public void setDEP_LC_DEP_AMT(Double DEP_LC_DEP_AMT) {
		this.DEP_LC_DEP_AMT = DEP_LC_DEP_AMT;
	}

	public Double getUI_M_POL_LC_COMMISSION() {
		return UI_M_POL_LC_COMMISSION;
	}

	public void setUI_M_POL_LC_COMMISSION(Double UI_M_POL_LC_COMMISSION) {
		this.UI_M_POL_LC_COMMISSION = UI_M_POL_LC_COMMISSION;
	}

	public Double getDEP_LC_OTH_AMT() {
		return DEP_LC_OTH_AMT;
	}

	public void setDEP_LC_OTH_AMT(Double DEP_LC_OTH_AMT) {
		this.DEP_LC_OTH_AMT = DEP_LC_OTH_AMT;
	}

	public Double getDEP_LC_TOT_AMT() {
		return DEP_LC_TOT_AMT;
	}

	public void setDEP_LC_TOT_AMT(Double DEP_LC_TOT_AMT) {
		this.DEP_LC_TOT_AMT = DEP_LC_TOT_AMT;
	}

	public Double getUI_M_POL_LC_NET_PREM() {
		return UI_M_POL_LC_NET_PREM;
	}

	public void setUI_M_POL_LC_NET_PREM(Double UI_M_POL_LC_NET_PREM) {
		this.UI_M_POL_LC_NET_PREM = UI_M_POL_LC_NET_PREM;
	}

	public Double getDEP_LC_TOTAL_AMT() {
		return DEP_LC_TOTAL_AMT;
	}

	public void setDEP_LC_TOTAL_AMT(Double DEP_LC_TOTAL_AMT) {
		this.DEP_LC_TOTAL_AMT = DEP_LC_TOTAL_AMT;
	}

	public String getDEP_BANK_IN_SLIP_NO() {
		return DEP_BANK_IN_SLIP_NO;
	}

	public void setDEP_BANK_IN_SLIP_NO(String DEP_BANK_IN_SLIP_NO) {
		this.DEP_BANK_IN_SLIP_NO = DEP_BANK_IN_SLIP_NO;
	}

	public String getDEP_DIVN_CODE() {
		return DEP_DIVN_CODE;
	}

	public void setDEP_DIVN_CODE(String DEP_DIVN_CODE) {
		this.DEP_DIVN_CODE = DEP_DIVN_CODE;
	}

	public String getUI_M_DEP_DIVN_DESC() {
		return UI_M_DEP_DIVN_DESC;
	}

	public void setUI_M_DEP_DIVN_DESC(String UI_M_DEP_DIVN_DESC) {
		this.UI_M_DEP_DIVN_DESC = UI_M_DEP_DIVN_DESC;
	}

	public String getDEP_DEPT_CODE() {
		return DEP_DEPT_CODE;
	}

	public void setDEP_DEPT_CODE(String DEP_DEPT_CODE) {
		this.DEP_DEPT_CODE = DEP_DEPT_CODE;
	}

	public String getUI_M_DEP_DEPT_DESC() {
		return UI_M_DEP_DEPT_DESC;
	}

	public void setUI_M_DEP_DEPT_DESC(String UI_M_DEP_DEPT_DESC) {
		this.UI_M_DEP_DEPT_DESC = UI_M_DEP_DEPT_DESC;
	}

	public String getDEP_CLASS_CODE() {
		return DEP_CLASS_CODE;
	}

	public void setDEP_CLASS_CODE(String DEP_CLASS_CODE) {
		this.DEP_CLASS_CODE = DEP_CLASS_CODE;
	}

	public String getUI_M_DEP_CLASS_CODE_DESC() {
		return UI_M_DEP_CLASS_CODE_DESC;
	}

	public void setUI_M_DEP_CLASS_CODE_DESC(String UI_M_DEP_CLASS_CODE_DESC) {
		this.UI_M_DEP_CLASS_CODE_DESC = UI_M_DEP_CLASS_CODE_DESC;
	}

	public String getDEP_BANKIN_CODE() {
		return DEP_BANKIN_CODE;
	}

	public void setDEP_BANKIN_CODE(String DEP_BANKIN_CODE) {
		this.DEP_BANKIN_CODE = DEP_BANKIN_CODE;
	}

	public String getUI_M_BANKIN_NAME() {
		return UI_M_BANKIN_NAME;
	}

	public void setUI_M_BANKIN_NAME(String UI_M_BANKIN_NAME) {
		this.UI_M_BANKIN_NAME = UI_M_BANKIN_NAME;
	}

	public String getDEP_PLAN_CODE() {
		return DEP_PLAN_CODE;
	}

	public void setDEP_PLAN_CODE(String DEP_PLAN_CODE) {
		this.DEP_PLAN_CODE = DEP_PLAN_CODE;
	}

	public String getUI_M_DEP_PLAN_CODE_DESC() {
		return UI_M_DEP_PLAN_CODE_DESC;
	}

	public void setUI_M_DEP_PLAN_CODE_DESC(String UI_M_DEP_PLAN_CODE_DESC) {
		this.UI_M_DEP_PLAN_CODE_DESC = UI_M_DEP_PLAN_CODE_DESC;
	}

	public String getDEP_DS_CODE() {
		return DEP_DS_CODE;
	}

	public void setDEP_DS_CODE(String DEP_DS_CODE) {
		this.DEP_DS_CODE = DEP_DS_CODE;
	}

	public String getUI_M_DEP_DS_CODE_DESC() {
		return UI_M_DEP_DS_CODE_DESC;
	}

	public void setUI_M_DEP_DS_CODE_DESC(String UI_M_DEP_DS_CODE_DESC) {
		this.UI_M_DEP_DS_CODE_DESC = UI_M_DEP_DS_CODE_DESC;
	}

	public String getDEP_SRC_OF_BUS() {
		return DEP_SRC_OF_BUS;
	}

	public void setDEP_SRC_OF_BUS(String DEP_SRC_OF_BUS) {
		this.DEP_SRC_OF_BUS = DEP_SRC_OF_BUS;
	}

	public String getUI_M_DEP_BUS_DESC() {
		return UI_M_DEP_BUS_DESC;
	}

	public void setUI_M_DEP_BUS_DESC(String UI_M_DEP_BUS_DESC) {
		this.UI_M_DEP_BUS_DESC = UI_M_DEP_BUS_DESC;
	}

	public String getDEP_REV_REMARKS() {
		return DEP_REV_REMARKS;
	}

	public void setDEP_REV_REMARKS(String DEP_REV_REMARKS) {
		this.DEP_REV_REMARKS = DEP_REV_REMARKS;
	}

	public String getUI_M_APPRV_STATUS() {
		return UI_M_APPRV_STATUS;
	}

	public void setUI_M_APPRV_STATUS(String ui_m_apprv_status) {
		UI_M_APPRV_STATUS = ui_m_apprv_status;
	}

	public Date getDEP_CR_DT() {
		return DEP_CR_DT;
	}

	public void setDEP_CR_DT(Date dep_cr_dt) {
		DEP_CR_DT = dep_cr_dt;
	}

	public String getDEP_CR_UID() {
		return DEP_CR_UID;
	}

	public void setDEP_CR_UID(String dep_cr_uid) {
		DEP_CR_UID = dep_cr_uid;
	}

	public Long getDEP_SYS_ID() {
		return DEP_SYS_ID;
	}

	public void setDEP_SYS_ID(Long dep_sys_id) {
		DEP_SYS_ID = dep_sys_id;
	}

	public Date getDEP_UPD_DT() {
		return DEP_UPD_DT;
	}

	public void setDEP_UPD_DT(Date dep_upd_dt) {
		DEP_UPD_DT = dep_upd_dt;
	}

	public String getDEP_UPD_UID() {
		return DEP_UPD_UID;
	}

	public void setDEP_UPD_UID(String dep_upd_uid) {
		DEP_UPD_UID = dep_upd_uid;
	}

	public String getDEP_TYPE() {
		return DEP_TYPE;
	}

	public void setDEP_TYPE(String dep_type) {
		DEP_TYPE = dep_type;
	}

	public Long getDEP_SYS_ID_INTEGER() {
		return DEP_SYS_ID_INTEGER;
	}

	public void setDEP_SYS_ID_INTEGER(Long dep_sys_id_integer) {
		DEP_SYS_ID_INTEGER = dep_sys_id_integer;
	}

	public String getDEP_PDC_FLAG() {
		return DEP_PDC_FLAG;
	}

	public void setDEP_PDC_FLAG(String dep_pdc_flag) {
		DEP_PDC_FLAG = dep_pdc_flag;
	}

	public boolean isApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(boolean approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public boolean isInsertedStatus() {
		return insertedStatus;
	}

	public void setInsertedStatus(boolean insertedStatus) {
		this.insertedStatus = insertedStatus;
	}

	public String getUI_M_PDC() {
		return UI_M_PDC;
	}

	public void setUI_M_PDC(String ui_m_pdc) {
		UI_M_PDC = ui_m_pdc;
	}

	public String getUI_M_POL_FLAG() {
		return UI_M_POL_FLAG;
	}

	public void setUI_M_POL_FLAG(String ui_m_pol_flag) {
		UI_M_POL_FLAG = ui_m_pol_flag;
	}

	public String getUI_M_DEP_GROSS_NET_FLAG() {
		return UI_M_DEP_GROSS_NET_FLAG;
	}

	public void setUI_M_DEP_GROSS_NET_FLAG(String ui_m_dep_gross_net_flag) {
		UI_M_DEP_GROSS_NET_FLAG = ui_m_dep_gross_net_flag;
	}

	public Integer getDEP_ACNT_YEAR() {
		return DEP_ACNT_YEAR;
	}

	public void setDEP_ACNT_YEAR(Integer dep_acnt_year) {
		DEP_ACNT_YEAR = dep_acnt_year;
	}

	public String getDEP_REC_REV_YN() {
		return DEP_REC_REV_YN;
	}

	public void setDEP_REC_REV_YN(String dep_rec_rev_yn) {
		DEP_REC_REV_YN = dep_rec_rev_yn;
	}

	public String getDEP_REASON_CODE() {
		return DEP_REASON_CODE;
	}

	public void setDEP_REASON_CODE(String dep_reason_code) {
		DEP_REASON_CODE = dep_reason_code;
	}

	public String getDEP_FLEX_02() {
		return DEP_FLEX_02;
	}

	public void setDEP_FLEX_02(String dep_flex_02) {
		DEP_FLEX_02 = dep_flex_02;
	}

	public String getDEP_FLEX_03() {
		return DEP_FLEX_03;
	}

	public void setDEP_FLEX_03(String dep_flex_03) {
		DEP_FLEX_03 = dep_flex_03;
	}

	public String getDEP_FLEX_04() {
		return DEP_FLEX_04;
	}

	public void setDEP_FLEX_04(String dep_flex_04) {
		DEP_FLEX_04 = dep_flex_04;
	}

	public String getDEP_CHRG_TXN_CODE() {
		return DEP_CHRG_TXN_CODE;
	}

	public void setDEP_CHRG_TXN_CODE(String dep_chrg_txn_code) {
		DEP_CHRG_TXN_CODE = dep_chrg_txn_code;
	}

	public Integer getDEP_CHRG_DOC_NO() {
		return DEP_CHRG_DOC_NO;
	}

	public void setDEP_CHRG_DOC_NO(Integer dep_chrg_doc_no) {
		DEP_CHRG_DOC_NO = dep_chrg_doc_no;
	}

	public String getDEP_ADTH_BATCH_NO() {
		return DEP_ADTH_BATCH_NO;
	}

	public void setDEP_ADTH_BATCH_NO(String dep_adth_batch_no) {
		DEP_ADTH_BATCH_NO = dep_adth_batch_no;
	}

	public String getDEP_DUP_PRINT() {
		return DEP_DUP_PRINT;
	}

	public void setDEP_DUP_PRINT(String dep_dup_print) {
		DEP_DUP_PRINT = dep_dup_print;
	}

	public Integer getDEP_REV_ACNT_YEAR() {
		return DEP_REV_ACNT_YEAR;
	}

	public void setDEP_REV_ACNT_YEAR(Integer dep_rev_acnt_year) {
		DEP_REV_ACNT_YEAR = dep_rev_acnt_year;
	}

	public Integer getDEP_REV_CHRG_DOC_NO() {
		return DEP_REV_CHRG_DOC_NO;
	}

	public void setDEP_REV_CHRG_DOC_NO(Integer dep_rev_chrg_doc_no) {
		DEP_REV_CHRG_DOC_NO = dep_rev_chrg_doc_no;
	}

	public String getDEP_MAST_RCPT_YN() {
		return DEP_MAST_RCPT_YN;
	}

	public void setDEP_MAST_RCPT_YN(String dep_mast_rcpt_yn) {
		DEP_MAST_RCPT_YN = dep_mast_rcpt_yn;
	}

	public String getDEP_FLEX_01() {
		return DEP_FLEX_01;
	}

	public void setDEP_FLEX_01(String dep_flex_01) {
		DEP_FLEX_01 = dep_flex_01;
	}

	public String getDEP_REV_BANK_IN_SLIP_NO() {
		return DEP_REV_BANK_IN_SLIP_NO;
	}

	public void setDEP_REV_BANK_IN_SLIP_NO(String dep_rev_bank_in_slip_no) {
		DEP_REV_BANK_IN_SLIP_NO = dep_rev_bank_in_slip_no;
	}

	public String getDEP_REV_CHRG_TXN_CODE() {
		return DEP_REV_CHRG_TXN_CODE;
	}

	public void setDEP_REV_CHRG_TXN_CODE(String dep_rev_chrg_txn_code) {
		DEP_REV_CHRG_TXN_CODE = dep_rev_chrg_txn_code;
	}

	public String getDEP_COMM_RECPT_YN() {
		return DEP_COMM_RECPT_YN;
	}

	public void setDEP_COMM_RECPT_YN(String dep_comm_recpt_yn) {
		DEP_COMM_RECPT_YN = dep_comm_recpt_yn;
	}

	/**
	 * @return the uI_M_DEP_REV_STATUS
	 */
	public String getUI_M_DEP_REV_STATUS() {
		return UI_M_DEP_REV_STATUS;
	}

	/**
	 * @param ui_m_dep_rev_status the uI_M_DEP_REV_STATUS to set
	 */
	public void setUI_M_DEP_REV_STATUS(String ui_m_dep_rev_status) {
		UI_M_DEP_REV_STATUS = ui_m_dep_rev_status;
	}

	/**
	 * @return the uI_M_DEP_UPD_UID
	 */
	public String getUI_M_DEP_UPD_UID() {
		return UI_M_DEP_UPD_UID;
	}

	/**
	 * @param ui_m_dep_upd_uid the uI_M_DEP_UPD_UID to set
	 */
	public void setUI_M_DEP_UPD_UID(String ui_m_dep_upd_uid) {
		UI_M_DEP_UPD_UID = ui_m_dep_upd_uid;
	}

	public String getUI_M_REC_REVERSE() {
		return UI_M_REC_REVERSE;
	}

	public void setUI_M_REC_REVERSE(String ui_m_rec_reverse) {
		UI_M_REC_REVERSE = ui_m_rec_reverse;
	}
	/*Added by Ram on 23/12/2016 for Credit Business field*/
	@Column(name="DEP_CREDIT_BUS_YN")
private String DEP_CREDIT_BUS_YN;

public String getDEP_CREDIT_BUS_YN() {
	return DEP_CREDIT_BUS_YN;
}

public void setDEP_CREDIT_BUS_YN(String dEP_CREDIT_BUS_YN) {
	DEP_CREDIT_BUS_YN = dEP_CREDIT_BUS_YN;
}
/*End*/

	/*Added by Ameen on 03-07-2017 for ZBILQC-1729834*/
	private String UI_M_DEP_LC_DEP_AMT;
	
	private String UI_M_DEP_FLEX_01;
	
	private String UI_M_DEP_FLEX_02;
	
	private String UI_M_DEP_FLEX_03;
	
	private String UI_M_DEP_FLEX_04;
	
	private String UI_M_REASON_CODE;
	
	private String UI_M_REASON_CODE_DESC;
	
	public String getUI_M_DEP_LC_DEP_AMT() {
		return UI_M_DEP_LC_DEP_AMT;
	}

	public void setUI_M_DEP_LC_DEP_AMT(String uI_M_DEP_LC_DEP_AMT) {
		UI_M_DEP_LC_DEP_AMT = uI_M_DEP_LC_DEP_AMT;
	}

	public String getUI_M_DEP_FLEX_01() {
		return UI_M_DEP_FLEX_01;
	}
	
	public void setUI_M_DEP_FLEX_01(String uI_M_DEP_FLEX_01) {
		UI_M_DEP_FLEX_01 = uI_M_DEP_FLEX_01;
	}
	
	public String getUI_M_DEP_FLEX_02() {
		return UI_M_DEP_FLEX_02;
	}
	
	public void setUI_M_DEP_FLEX_02(String uI_M_DEP_FLEX_02) {
		UI_M_DEP_FLEX_02 = uI_M_DEP_FLEX_02;
	}
	
	public String getUI_M_DEP_FLEX_03() {
		return UI_M_DEP_FLEX_03;
	}
	
	public void setUI_M_DEP_FLEX_03(String uI_M_DEP_FLEX_03) {
		UI_M_DEP_FLEX_03 = uI_M_DEP_FLEX_03;
	}
	
	public String getUI_M_DEP_FLEX_04() {
		return UI_M_DEP_FLEX_04;
	}
	
	public void setUI_M_DEP_FLEX_04(String uI_M_DEP_FLEX_04) {
		UI_M_DEP_FLEX_04 = uI_M_DEP_FLEX_04;
	}
	
	public String getUI_M_REASON_CODE() {
		return UI_M_REASON_CODE;
	}
	
	public void setUI_M_REASON_CODE(String uI_M_REASON_CODE) {
		UI_M_REASON_CODE = uI_M_REASON_CODE;
	}
	
	public String getUI_M_REASON_CODE_DESC() {
		return UI_M_REASON_CODE_DESC;
	}
	
	public void setUI_M_REASON_CODE_DESC(String uI_M_REASON_CODE_DESC) {
		UI_M_REASON_CODE_DESC = uI_M_REASON_CODE_DESC;
	}
	
	
	/*End*/
	
	
	/*added by raja on 16-08-2017 for direct depit disscused with siva sir*/ 
	@Column(name="DEP_AMT_PAYOR_NAME")
	private String DEP_AMT_PAYOR_NAME;

	
	@Column(name="DEP_AMT_PAYOR_CONTACT")
	private String DEP_AMT_PAYOR_CONTACT;

	public String getDEP_AMT_PAYOR_NAME() {
		return DEP_AMT_PAYOR_NAME;
	}

	public void setDEP_AMT_PAYOR_NAME(String dEP_AMT_PAYOR_NAME) {
		DEP_AMT_PAYOR_NAME = dEP_AMT_PAYOR_NAME;
	}

	public String getDEP_AMT_PAYOR_CONTACT() {
		return DEP_AMT_PAYOR_CONTACT;
	}

	public void setDEP_AMT_PAYOR_CONTACT(String dEP_AMT_PAYOR_CONTACT) {
		DEP_AMT_PAYOR_CONTACT = dEP_AMT_PAYOR_CONTACT;
	}
	
	
	/*end*/
	
	/*Added by saritha on 11-10-2017 for Premium Collection Issues*/
	@Column(name="DEP_COMM_YN")
	private String DEP_COMM_YN;

	public String getDEP_COMM_YN() {
		return DEP_COMM_YN;
	}

	public void setDEP_COMM_YN(String dEP_COMM_YN) {
		DEP_COMM_YN = dEP_COMM_YN;
	}
	/*End*/
	
	 /*Added by kavitha on 13.08.2018 for FLALIFEQC-1761039*/ 
	
		private double UI_M_DEP_SUS_AMT;
		
		private double UI_M_DEP_DEPOSIT_AMT;
		
		private double UI_M_DEP_UTIL_AMT;
		
		public double getUI_M_DEP_SUS_AMT() {
			return UI_M_DEP_SUS_AMT;
		}

		public void setUI_M_DEP_SUS_AMT(double uI_M_DEP_SUS_AMT) {
			UI_M_DEP_SUS_AMT = uI_M_DEP_SUS_AMT;
		}
		

		public double getUI_M_DEP_DEPOSIT_AMT() {
			return UI_M_DEP_DEPOSIT_AMT;
		}

		public void setUI_M_DEP_DEPOSIT_AMT(double uI_M_DEP_DEPOSIT_AMT) {
			UI_M_DEP_DEPOSIT_AMT = uI_M_DEP_DEPOSIT_AMT;
		}

		public double getUI_M_DEP_UTIL_AMT() {
			return UI_M_DEP_UTIL_AMT;
		}

		public void setUI_M_DEP_UTIL_AMT(double uI_M_DEP_UTIL_AMT) {
			UI_M_DEP_UTIL_AMT = uI_M_DEP_UTIL_AMT;
		}
		/*End*/
		
		/*Newly added by Pidugu raj dt: 06-07-2020 for Alliance-ACD_IL_037 */
		@Column(name="DEP_LC_AMT")
		private Double DEP_LC_AMT;

		public Double getDEP_LC_AMT() {
			return DEP_LC_AMT;
		}

		public void setDEP_LC_AMT(Double dEP_LC_AMT) {
			DEP_LC_AMT = dEP_LC_AMT;
		}

		
		
		/*End*/
		/*Added by rakesh on 06-03-2020 for orient uat issue*/
		@Column(name="DEP_CURR_CODE")
		public String DEP_CURR_CODE;

		public String getDEP_CURR_CODE() {
			return DEP_CURR_CODE;
		}

		public void setDEP_CURR_CODE(String dEP_CURR_CODE) {
			DEP_CURR_CODE = dEP_CURR_CODE;
		}

		private String UI_M_DEP_CURR_DESC;
		
		public String getUI_M_DEP_CURR_DESC() {
			return UI_M_DEP_CURR_DESC;
		}

		public void setUI_M_DEP_CURR_DESC(String uI_M_DEP_CURR_DESC) {
			UI_M_DEP_CURR_DESC = uI_M_DEP_CURR_DESC;
		}
		
		//END
		
		
//		@Column(name="POL_CUST_EXCH_RATE")
		private Double DEP_CUST_EXCH_RATE;

		public Double getDEP_CUST_EXCH_RATE() {
			return DEP_CUST_EXCH_RATE;
		}

		public void setDEP_CUST_EXCH_RATE(Double dEP_CUST_EXCH_RATE) {
			DEP_CUST_EXCH_RATE = dEP_CUST_EXCH_RATE;
		}
		
		@Column(name="DEP_FC_DEP_AMT")
		private Double DEP_FC_DEP_AMT;

		public Double getDEP_FC_DEP_AMT() {
			return DEP_FC_DEP_AMT;
		}

		public void setDEP_FC_DEP_AMT(Double dEP_FC_DEP_AMT) {
			DEP_FC_DEP_AMT = dEP_FC_DEP_AMT;
		}
		
		
		@Column(name="DEP_FC_TOTAL_AMT")
		private Double DEP_FC_TOTAL_AMT;

		public Double getDEP_FC_TOTAL_AMT() {
			return DEP_FC_TOTAL_AMT;
		}

		public void setDEP_FC_TOTAL_AMT(Double dEP_FC_TOTAL_AMT) {
			DEP_FC_TOTAL_AMT = dEP_FC_TOTAL_AMT;
		}
		
}
