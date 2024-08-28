package com.iii.pel.forms.PILQ020;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="PT_IL_DEPOSIT")
public class PT_IL_DEPOSIT1 extends BaseValueBean {

	@Column(name="DEP_SYS_ID")
	private Long DEP_SYS_ID;

	@Column(name="DEP_TYPE")
	private String DEP_TYPE;

	@Column(name="DEP_REF_NO")
	private String DEP_REF_NO;

	@Column(name="DEP_CONT_CODE")
	private String DEP_CONT_CODE;

	@Column(name="DEP_CUST_CODE")
	private String DEP_CUST_CODE;

	@Column(name="DEP_LC_DEP_AMT")
	private Double DEP_LC_DEP_AMT;

	@Column(name="DEP_TXN_CODE")
	private String DEP_TXN_CODE;

	@Column(name="DEP_DOC_NO")
	private Double DEP_DOC_NO;

	@Column(name="DEP_DOC_DT")
	private Date DEP_DOC_DT;

	@Column(name="DEP_CR_UID")
	private String DEP_CR_UID;

	@Column(name="DEP_CR_DT")
	private Date DEP_CR_DT;

	@Column(name="DEP_UPD_UID")
	private String DEP_UPD_UID;

	@Column(name="DEP_UPD_DT")
	private Date DEP_UPD_DT;

	@Column(name="DEP_DIVN_CODE")
	private String DEP_DIVN_CODE;

	@Column(name="DEP_DEPT_CODE")
	private String DEP_DEPT_CODE;

	@Column(name="DEP_GROSS_NET_FLAG")
	private String DEP_GROSS_NET_FLAG;

	@Column(name="DEP_TEMP_RCPT_NO")
	private String DEP_TEMP_RCPT_NO;

	@Column(name="DEP_ACNT_YEAR")
	private Double DEP_ACNT_YEAR;

	@Column(name="DEP_DS_CODE")
	private String DEP_DS_CODE;

	@Column(name="DEP_CLASS_CODE")
	private String DEP_CLASS_CODE;

	@Column(name="DEP_PLAN_CODE")
	private String DEP_PLAN_CODE;

	@Column(name="DEP_PROD_CODE")
	private String DEP_PROD_CODE;

	@Column(name="DEP_AGENT_CODE")
	private String DEP_AGENT_CODE;

	@Column(name="DEP_COLL_AGENT_CODE")
	private String DEP_COLL_AGENT_CODE;

	@Column(name="DEP_CONT_REF_ID1")
	private String DEP_CONT_REF_ID1;

	@Column(name="DEP_CONT_REF_ID2")
	private String DEP_CONT_REF_ID2;

	@Column(name="DEP_REC_REV_YN")
	private String DEP_REC_REV_YN;

	@Column(name="DEP_REASON_CODE")
	private String DEP_REASON_CODE;

	@Column(name="DEP_REV_REMARKS")
	private String DEP_REV_REMARKS;

	@Column(name="DEP_BANKIN_CODE")
	private String DEP_BANKIN_CODE;

	@Column(name="DEP_FLEX_01")
	private String DEP_FLEX_01;

	@Column(name="DEP_FLEX_02")
	private String DEP_FLEX_02;

	@Column(name="DEP_FLEX_03")
	private String DEP_FLEX_03;

	@Column(name="DEP_FLEX_04")
	private String DEP_FLEX_04;

	@Column(name="DEP_SRC_OF_BUS")
	private String DEP_SRC_OF_BUS;

	@Column(name="DEP_CHRG_TXN_CODE")
	private String DEP_CHRG_TXN_CODE;

	@Column(name="DEP_CHRG_DOC_NO")
	private Double DEP_CHRG_DOC_NO;

	@Column(name="DEP_LC_TOTAL_AMT")
	private Double DEP_LC_TOTAL_AMT;

	@Column(name="DEP_LC_OTH_AMT")
	private Double DEP_LC_OTH_AMT;

	@Column(name="DEP_ADTH_BATCH_NO")
	private String DEP_ADTH_BATCH_NO;

	@Column(name="DEP_PDC_FLAG")
	private String DEP_PDC_FLAG;

	@Column(name="DEP_DUP_PRINT")
	private String DEP_DUP_PRINT;

	@Column(name="DEP_BANK_IN_SLIP_NO")
	private String DEP_BANK_IN_SLIP_NO;

	@Column(name="DEP_REP_BANK_IN_SLIP_NO")
	private String DEP_REP_BANK_IN_SLIP_NO;

	@Column(name="DEP_REV_BANK_IN_SLIP_NO")
	private String DEP_REV_BANK_IN_SLIP_NO;

	@Column(name="DEP_REV_ACNT_YEAR")
	private Double DEP_REV_ACNT_YEAR;

	@Column(name="DEP_REV_CHRG_TXN_CODE")
	private String DEP_REV_CHRG_TXN_CODE;

	@Column(name="DEP_REV_CHRG_DOC_NO")
	private Double DEP_REV_CHRG_DOC_NO;

	@Column(name="DEP_REPL_RCPT_YN")
	private String DEP_REPL_RCPT_YN;

	@Column(name="DEP_REPL_DOC_NO")
	private Double DEP_REPL_DOC_NO;

	@Column(name="DEP_REPL_TXN_CODE")
	private String DEP_REPL_TXN_CODE;

	@Column(name="DEP_REPL_ACC_YR")
	private Double DEP_REPL_ACC_YR;

	@Column(name="DEP_MAST_RCPT_YN")
	private String DEP_MAST_RCPT_YN;

	@Column(name="DEP_COMM_RECPT_YN")
	private String DEP_COMM_RECPT_YN;
	
	private String UI_DEP_DOC_DT;

	private String UI_M_REVERSE_YN;
	public void setDEP_COLL_AGENT_CODE(String DEP_COLL_AGENT_CODE) {
		this.DEP_COLL_AGENT_CODE = DEP_COLL_AGENT_CODE;
	}
	public String getDEP_COLL_AGENT_CODE() {
		 return DEP_COLL_AGENT_CODE;
	}
	public void setDEP_DS_CODE(String DEP_DS_CODE) {
		this.DEP_DS_CODE = DEP_DS_CODE;
	}
	public String getDEP_DS_CODE() {
		 return DEP_DS_CODE;
	}
	public void setDEP_MAST_RCPT_YN(String DEP_MAST_RCPT_YN) {
		this.DEP_MAST_RCPT_YN = DEP_MAST_RCPT_YN;
	}
	public String getDEP_MAST_RCPT_YN() {
		 return DEP_MAST_RCPT_YN;
	}
	public void setDEP_AGENT_CODE(String DEP_AGENT_CODE) {
		this.DEP_AGENT_CODE = DEP_AGENT_CODE;
	}
	public String getDEP_AGENT_CODE() {
		 return DEP_AGENT_CODE;
	}
	public void setDEP_CR_UID(String DEP_CR_UID) {
		this.DEP_CR_UID = DEP_CR_UID;
	}
	public String getDEP_CR_UID() {
		 return DEP_CR_UID;
	}
	public void setDEP_PDC_FLAG(String DEP_PDC_FLAG) {
		this.DEP_PDC_FLAG = DEP_PDC_FLAG;
	}
	public String getDEP_PDC_FLAG() {
		 return DEP_PDC_FLAG;
	}
	public void setDEP_TXN_CODE(String DEP_TXN_CODE) {
		this.DEP_TXN_CODE = DEP_TXN_CODE;
	}
	public String getDEP_TXN_CODE() {
		 return DEP_TXN_CODE;
	}
	public void setDEP_REV_BANK_IN_SLIP_NO(String DEP_REV_BANK_IN_SLIP_NO) {
		this.DEP_REV_BANK_IN_SLIP_NO = DEP_REV_BANK_IN_SLIP_NO;
	}
	public String getDEP_REV_BANK_IN_SLIP_NO() {
		 return DEP_REV_BANK_IN_SLIP_NO;
	}
	public void setDEP_ACNT_YEAR(Double DEP_ACNT_YEAR) {
		this.DEP_ACNT_YEAR = DEP_ACNT_YEAR;
	}
	public Double getDEP_ACNT_YEAR() {
		 return DEP_ACNT_YEAR;
	}
	public void setDEP_DIVN_CODE(String DEP_DIVN_CODE) {
		this.DEP_DIVN_CODE = DEP_DIVN_CODE;
	}
	public String getDEP_DIVN_CODE() {
		 return DEP_DIVN_CODE;
	}
	public void setDEP_UPD_DT(Date DEP_UPD_DT) {
		this.DEP_UPD_DT = DEP_UPD_DT;
	}
	public Date getDEP_UPD_DT() {
		 return DEP_UPD_DT;
	}
	public void setDEP_CHRG_DOC_NO(Double DEP_CHRG_DOC_NO) {
		this.DEP_CHRG_DOC_NO = DEP_CHRG_DOC_NO;
	}
	public Double getDEP_CHRG_DOC_NO() {
		 return DEP_CHRG_DOC_NO;
	}
	public void setDEP_CONT_CODE(String DEP_CONT_CODE) {
		this.DEP_CONT_CODE = DEP_CONT_CODE;
	}
	public String getDEP_CONT_CODE() {
		 return DEP_CONT_CODE;
	}
	public void setDEP_LC_DEP_AMT(Double DEP_LC_DEP_AMT) {
		this.DEP_LC_DEP_AMT = DEP_LC_DEP_AMT;
	}
	public Double getDEP_LC_DEP_AMT() {
		 return DEP_LC_DEP_AMT;
	}
	public void setDEP_REPL_RCPT_YN(String DEP_REPL_RCPT_YN) {
		this.DEP_REPL_RCPT_YN = DEP_REPL_RCPT_YN;
	}
	public String getDEP_REPL_RCPT_YN() {
		 return DEP_REPL_RCPT_YN;
	}
	public void setDEP_CHRG_TXN_CODE(String DEP_CHRG_TXN_CODE) {
		this.DEP_CHRG_TXN_CODE = DEP_CHRG_TXN_CODE;
	}
	public String getDEP_CHRG_TXN_CODE() {
		 return DEP_CHRG_TXN_CODE;
	}
	public void setDEP_PROD_CODE(String DEP_PROD_CODE) {
		this.DEP_PROD_CODE = DEP_PROD_CODE;
	}
	public String getDEP_PROD_CODE() {
		 return DEP_PROD_CODE;
	}
	public void setDEP_REPL_TXN_CODE(String DEP_REPL_TXN_CODE) {
		this.DEP_REPL_TXN_CODE = DEP_REPL_TXN_CODE;
	}
	public String getDEP_REPL_TXN_CODE() {
		 return DEP_REPL_TXN_CODE;
	}
	public void setDEP_CUST_CODE(String DEP_CUST_CODE) {
		this.DEP_CUST_CODE = DEP_CUST_CODE;
	}
	public String getDEP_CUST_CODE() {
		 return DEP_CUST_CODE;
	}
	public void setDEP_CLASS_CODE(String DEP_CLASS_CODE) {
		this.DEP_CLASS_CODE = DEP_CLASS_CODE;
	}
	public String getDEP_CLASS_CODE() {
		 return DEP_CLASS_CODE;
	}
	public void setDEP_COMM_RECPT_YN(String DEP_COMM_RECPT_YN) {
		this.DEP_COMM_RECPT_YN = DEP_COMM_RECPT_YN;
	}
	public String getDEP_COMM_RECPT_YN() {
		 return DEP_COMM_RECPT_YN;
	}
	public void setDEP_GROSS_NET_FLAG(String DEP_GROSS_NET_FLAG) {
		this.DEP_GROSS_NET_FLAG = DEP_GROSS_NET_FLAG;
	}
	public String getDEP_GROSS_NET_FLAG() {
		 return DEP_GROSS_NET_FLAG;
	}
	public void setDEP_DUP_PRINT(String DEP_DUP_PRINT) {
		this.DEP_DUP_PRINT = DEP_DUP_PRINT;
	}
	public String getDEP_DUP_PRINT() {
		 return DEP_DUP_PRINT;
	}
	public void setDEP_BANK_IN_SLIP_NO(String DEP_BANK_IN_SLIP_NO) {
		this.DEP_BANK_IN_SLIP_NO = DEP_BANK_IN_SLIP_NO;
	}
	public String getDEP_BANK_IN_SLIP_NO() {
		 return DEP_BANK_IN_SLIP_NO;
	}
	public void setDEP_LC_OTH_AMT(Double DEP_LC_OTH_AMT) {
		this.DEP_LC_OTH_AMT = DEP_LC_OTH_AMT;
	}
	public Double getDEP_LC_OTH_AMT() {
		 return DEP_LC_OTH_AMT;
	}
	public void setDEP_REP_BANK_IN_SLIP_NO(String DEP_REP_BANK_IN_SLIP_NO) {
		this.DEP_REP_BANK_IN_SLIP_NO = DEP_REP_BANK_IN_SLIP_NO;
	}
	public String getDEP_REP_BANK_IN_SLIP_NO() {
		 return DEP_REP_BANK_IN_SLIP_NO;
	}
	public void setDEP_REV_CHRG_DOC_NO(Double DEP_REV_CHRG_DOC_NO) {
		this.DEP_REV_CHRG_DOC_NO = DEP_REV_CHRG_DOC_NO;
	}
	public Double getDEP_REV_CHRG_DOC_NO() {
		 return DEP_REV_CHRG_DOC_NO;
	}
	public void setDEP_CONT_REF_ID2(String DEP_CONT_REF_ID2) {
		this.DEP_CONT_REF_ID2 = DEP_CONT_REF_ID2;
	}
	public String getDEP_CONT_REF_ID2() {
		 return DEP_CONT_REF_ID2;
	}
	public void setDEP_CONT_REF_ID1(String DEP_CONT_REF_ID1) {
		this.DEP_CONT_REF_ID1 = DEP_CONT_REF_ID1;
	}
	public String getDEP_CONT_REF_ID1() {
		 return DEP_CONT_REF_ID1;
	}
	public void setDEP_REV_ACNT_YEAR(Double DEP_REV_ACNT_YEAR) {
		this.DEP_REV_ACNT_YEAR = DEP_REV_ACNT_YEAR;
	}
	public Double getDEP_REV_ACNT_YEAR() {
		 return DEP_REV_ACNT_YEAR;
	}
	public void setDEP_REASON_CODE(String DEP_REASON_CODE) {
		this.DEP_REASON_CODE = DEP_REASON_CODE;
	}
	public String getDEP_REASON_CODE() {
		 return DEP_REASON_CODE;
	}
	public void setDEP_LC_TOTAL_AMT(Double DEP_LC_TOTAL_AMT) {
		this.DEP_LC_TOTAL_AMT = DEP_LC_TOTAL_AMT;
	}
	public Double getDEP_LC_TOTAL_AMT() {
		 return DEP_LC_TOTAL_AMT;
	}
	public void setDEP_SYS_ID(Long DEP_SYS_ID) {
		this.DEP_SYS_ID = DEP_SYS_ID;
	}
	public Long getDEP_SYS_ID() {
		 return DEP_SYS_ID;
	}
	public void setDEP_REV_REMARKS(String DEP_REV_REMARKS) {
		this.DEP_REV_REMARKS = DEP_REV_REMARKS;
	}
	public String getDEP_REV_REMARKS() {
		 return DEP_REV_REMARKS;
	}
	public void setDEP_DOC_NO(Double DEP_DOC_NO) {
		this.DEP_DOC_NO = DEP_DOC_NO;
	}
	public Double getDEP_DOC_NO() {
		 return DEP_DOC_NO;
	}
	public void setDEP_CR_DT(Date DEP_CR_DT) {
		this.DEP_CR_DT = DEP_CR_DT;
	}
	public Date getDEP_CR_DT() {
		 return DEP_CR_DT;
	}
	public void setDEP_BANKIN_CODE(String DEP_BANKIN_CODE) {
		this.DEP_BANKIN_CODE = DEP_BANKIN_CODE;
	}
	public String getDEP_BANKIN_CODE() {
		 return DEP_BANKIN_CODE;
	}
	public void setDEP_FLEX_04(String DEP_FLEX_04) {
		this.DEP_FLEX_04 = DEP_FLEX_04;
	}
	public String getDEP_FLEX_04() {
		 return DEP_FLEX_04;
	}
	public void setDEP_FLEX_02(String DEP_FLEX_02) {
		this.DEP_FLEX_02 = DEP_FLEX_02;
	}
	public String getDEP_FLEX_02() {
		 return DEP_FLEX_02;
	}
	public void setDEP_FLEX_03(String DEP_FLEX_03) {
		this.DEP_FLEX_03 = DEP_FLEX_03;
	}
	public String getDEP_FLEX_03() {
		 return DEP_FLEX_03;
	}
	public void setDEP_REPL_ACC_YR(Double DEP_REPL_ACC_YR) {
		this.DEP_REPL_ACC_YR = DEP_REPL_ACC_YR;
	}
	public Double getDEP_REPL_ACC_YR() {
		 return DEP_REPL_ACC_YR;
	}
	public void setDEP_DEPT_CODE(String DEP_DEPT_CODE) {
		this.DEP_DEPT_CODE = DEP_DEPT_CODE;
	}
	public String getDEP_DEPT_CODE() {
		 return DEP_DEPT_CODE;
	}
	public void setDEP_DOC_DT(Date DEP_DOC_DT) {
		this.DEP_DOC_DT = DEP_DOC_DT;
	}
	public Date getDEP_DOC_DT() {
		 return DEP_DOC_DT;
	}
	public void setDEP_SRC_OF_BUS(String DEP_SRC_OF_BUS) {
		this.DEP_SRC_OF_BUS = DEP_SRC_OF_BUS;
	}
	public String getDEP_SRC_OF_BUS() {
		 return DEP_SRC_OF_BUS;
	}
	public void setDEP_FLEX_01(String DEP_FLEX_01) {
		this.DEP_FLEX_01 = DEP_FLEX_01;
	}
	public String getDEP_FLEX_01() {
		 return DEP_FLEX_01;
	}
	public void setDEP_ADTH_BATCH_NO(String DEP_ADTH_BATCH_NO) {
		this.DEP_ADTH_BATCH_NO = DEP_ADTH_BATCH_NO;
	}
	public String getDEP_ADTH_BATCH_NO() {
		 return DEP_ADTH_BATCH_NO;
	}
	public void setDEP_REF_NO(String DEP_REF_NO) {
		this.DEP_REF_NO = DEP_REF_NO;
	}
	public String getDEP_REF_NO() {
		 return DEP_REF_NO;
	}
	public void setDEP_TEMP_RCPT_NO(String DEP_TEMP_RCPT_NO) {
		this.DEP_TEMP_RCPT_NO = DEP_TEMP_RCPT_NO;
	}
	public String getDEP_TEMP_RCPT_NO() {
		 return DEP_TEMP_RCPT_NO;
	}
	public void setDEP_TYPE(String DEP_TYPE) {
		this.DEP_TYPE = DEP_TYPE;
	}
	public String getDEP_TYPE() {
		 return DEP_TYPE;
	}
	public void setDEP_UPD_UID(String DEP_UPD_UID) {
		this.DEP_UPD_UID = DEP_UPD_UID;
	}
	public String getDEP_UPD_UID() {
		 return DEP_UPD_UID;
	}
	public void setDEP_REV_CHRG_TXN_CODE(String DEP_REV_CHRG_TXN_CODE) {
		this.DEP_REV_CHRG_TXN_CODE = DEP_REV_CHRG_TXN_CODE;
	}
	public String getDEP_REV_CHRG_TXN_CODE() {
		 return DEP_REV_CHRG_TXN_CODE;
	}
	public void setDEP_REPL_DOC_NO(Double DEP_REPL_DOC_NO) {
		this.DEP_REPL_DOC_NO = DEP_REPL_DOC_NO;
	}
	public Double getDEP_REPL_DOC_NO() {
		 return DEP_REPL_DOC_NO;
	}
	public void setDEP_PLAN_CODE(String DEP_PLAN_CODE) {
		this.DEP_PLAN_CODE = DEP_PLAN_CODE;
	}
	public String getDEP_PLAN_CODE() {
		 return DEP_PLAN_CODE;
	}
	public void setDEP_REC_REV_YN(String DEP_REC_REV_YN) {
		this.DEP_REC_REV_YN = DEP_REC_REV_YN;
	}
	public String getDEP_REC_REV_YN() {
		 return DEP_REC_REV_YN;
	}
	public void setUI_M_REVERSE_YN(String UI_M_REVERSE_YN) {
		this.UI_M_REVERSE_YN = UI_M_REVERSE_YN;
	}
	public String getUI_M_REVERSE_YN() {
		 return UI_M_REVERSE_YN;
	}
	public String getUI_DEP_DOC_DT() {
		UI_DEP_DOC_DT = CommonUtils.dateToPELStringFormatter(DEP_DOC_DT);
		return UI_DEP_DOC_DT;
	}
	public void setUI_DEP_DOC_DT(String ui_dep_doc_dt) {
		UI_DEP_DOC_DT = ui_dep_doc_dt;
	}

}