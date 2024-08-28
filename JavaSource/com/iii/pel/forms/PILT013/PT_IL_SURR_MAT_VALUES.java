package com.iii.pel.forms.PILT013;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name = "PT_IL_SURR_MAT_VALUES")
public class PT_IL_SURR_MAT_VALUES extends BaseValueBean {

	@Column(name = "SMV_SYS_ID")
	private Long SMV_SYS_ID;

	@Column(name = "SMV_POL_SYS_ID")
	private Long SMV_POL_SYS_ID;

	@Column(name = "SMV_DATE")
	private Date SMV_DATE;

	@Column(name = "SMV_FC_RED_SA")
	private Double SMV_FC_RED_SA;

	@Column(name = "SMV_LC_RED_SA")
	private Double SMV_LC_RED_SA;

	@Column(name = "SMV_FC_ACC_PROFIT")
	private Double SMV_FC_ACC_PROFIT;

	@Column(name = "SMV_LC_ACC_PROFIT")
	private Double SMV_LC_ACC_PROFIT;

	@Column(name = "SMV_FC_GROSS_VALUE")
	private Double SMV_FC_GROSS_VALUE;

	@Column(name = "SMV_LC_GROSS_VALUE")
	private Double SMV_LC_GROSS_VALUE;

	@Column(name = "SMV_FC_UNPAID_PREM")
	private Double SMV_FC_UNPAID_PREM;

	@Column(name = "SMV_LC_UNPAID_PREM")
	private Double SMV_LC_UNPAID_PREM;

	@Column(name = "SMV_FC_BAL_LOAN")
	private Double SMV_FC_BAL_LOAN;

	@Column(name = "SMV_LC_BAL_LOAN")
	private Double SMV_LC_BAL_LOAN;

	@Column(name = "SMV_FC_LOAN_INT")
	private Double SMV_FC_LOAN_INT;

	@Column(name = "SMV_LC_LOAN_INT")
	private Double SMV_LC_LOAN_INT;

	@Column(name = "SMV_TYPE")
	private String SMV_TYPE="N";

	@Column(name = "SMV_DEL_FLAG")
	private String SMV_DEL_FLAG;

	@Column(name = "SMV_CR_DT")
	private Date SMV_CR_DT;

	@Column(name = "SMV_CR_UID")
	private String SMV_CR_UID;

	@Column(name = "SMV_UPD_DT")
	private Date SMV_UPD_DT;

	@Column(name = "SMV_UPD_UID")
	private String SMV_UPD_UID;

	@Column(name = "SMV_FC_NET_PAID_AMT")
	private Double SMV_FC_NET_PAID_AMT;

	@Column(name = "SMV_LC_NET_PAID_AMT")
	private Double SMV_LC_NET_PAID_AMT;

	@Column(name = "SMV_PAID_DT")
	private Date SMV_PAID_DT;

	@Column(name = "SMV_APPRV_FLAG")
	private String SMV_APPRV_FLAG;

	@Column(name = "SMV_UNPAID_PREM_YN")
	private String SMV_UNPAID_PREM_YN;

	@Column(name = "SMV_LOAN_INT_YN")
	private String SMV_LOAN_INT_YN ;

	@Column(name = "SMV_CHARGE_CODE")
	private String SMV_CHARGE_CODE;

	@Column(name = "SMV_FC_CHARGE_AMT")
	private Double SMV_FC_CHARGE_AMT;

	@Column(name = "SMV_LC_CHARGE_AMT")
	private Double SMV_LC_CHARGE_AMT;

	@Column(name = "SMV_REF_NO")
	private String SMV_REF_NO;

	@Column(name = "SMV_UNPAID_PREM_INT_CODE")
	private String SMV_UNPAID_PREM_INT_CODE;

	@Column(name = "SMV_FC_UNPAID_PREM_INT")
	private Double SMV_FC_UNPAID_PREM_INT;

	@Column(name = "SMV_LC_UNPAID_PREM_INT")
	private Double SMV_LC_UNPAID_PREM_INT;

	@Column(name = "SMV_FC_OS_LOAN")
	private Double SMV_FC_OS_LOAN;

	@Column(name = "SMV_LC_OS_LOAN")
	private Double SMV_LC_OS_LOAN;

	@Column(name = "SMV_LOAN_CODE")
	private String SMV_LOAN_CODE;

	@Column(name = "SMV_RESERVE_FLAG")
	private String SMV_RESERVE_FLAG;

	@Column(name = "SMV_PREV_SCH_DATE")
	private Date SMV_PREV_SCH_DATE;

	@Column(name = "SMV_LETTER_DATE")
	private Date SMV_LETTER_DATE;

	@Column(name = "SMV_TRAN_DATE")
	private Date SMV_TRAN_DATE;

	@Column(name = "SMV_REASON_CODE")
	private String SMV_REASON_CODE;

	@Column(name = "SMV_REMARKS")
	private String SMV_REMARKS;

	@Column(name = "SMV_AMT1")
	private Double SMV_AMT1;

	@Column(name = "SMV_AMT2")
	private Double SMV_AMT2;

	@Column(name = "SMV_AMT3")
	private Double SMV_AMT3;

	@Column(name = "SMV_AMT4")
	private Double SMV_AMT4;

	@Column(name = "SMV_AMT5")
	private Double SMV_AMT5;

	@Column(name = "SMV_STATUS_CODE")
	private String SMV_STATUS_CODE;

	@Column(name = "SMV_APPRV_UID")
	private String SMV_APPRV_UID;

	@Column(name = "SMV_APPRV_DT")
	private Date SMV_APPRV_DT;

	@Column(name = "SMV_DOC_ID")
	private String SMV_DOC_ID;

	@Column(name = "SMV_PAYTO")
	private String SMV_PAYTO;
	
	@Column(name = "SMV_FLEX01")
	private String SMV_FLEX01;
	
	@Column(name = "SMV_FLEX02")
	private String SMV_FLEX02;

	private Double UI_M_FC_NET_PAID_AMT;
	private Double UI_M_LC_NET_PAID_AMT;
	private String UI_M_CHARGE_DESC;
	@Column(name = "SMV_FLEX04")
	 private String SMV_FLEX04;
	@Column(name = "SMV_FLEX05")
	 private String SMV_FLEX05;
	@Column(name = "SMV_FLEX06")
	 private String SMV_FLEX06;
	
	/*Added by jagadeesh for the SSP Call ID: FALCONQC-1715538*/
	
	private String UI_SMV_FC_RED_SA;
	
	private String UI_SMV_FC_ACC_PROFIT;
	
	private String UI_SMV_FC_GROSS_VALUE;
	
	private String UI_FC_NET_PAID_AMT;
	


	public String getUI_SMV_FC_RED_SA() {
		return UI_SMV_FC_RED_SA;
	}

	public void setUI_SMV_FC_RED_SA(String uI_SMV_FC_RED_SA) {
		UI_SMV_FC_RED_SA = uI_SMV_FC_RED_SA;
	}

	public String getUI_SMV_FC_ACC_PROFIT() {
		return UI_SMV_FC_ACC_PROFIT;
	}

	public void setUI_SMV_FC_ACC_PROFIT(String uI_SMV_FC_ACC_PROFIT) {
		UI_SMV_FC_ACC_PROFIT = uI_SMV_FC_ACC_PROFIT;
	}

	public String getUI_SMV_FC_GROSS_VALUE() {
		return UI_SMV_FC_GROSS_VALUE;
	}

	public void setUI_SMV_FC_GROSS_VALUE(String uI_SMV_FC_GROSS_VALUE) {
		UI_SMV_FC_GROSS_VALUE = uI_SMV_FC_GROSS_VALUE;
	}

	public String getUI_FC_NET_PAID_AMT() {
		return UI_FC_NET_PAID_AMT;
	}

	public void setUI_FC_NET_PAID_AMT(String uI_FC_NET_PAID_AMT) {
		UI_FC_NET_PAID_AMT = uI_FC_NET_PAID_AMT;
	}
	
	
	/*End*/
	

	public void setSMV_POL_SYS_ID(Long SMV_POL_SYS_ID) {
		this.SMV_POL_SYS_ID = SMV_POL_SYS_ID;
	}

	public Long getSMV_POL_SYS_ID() {
		return SMV_POL_SYS_ID;
	}

	public void setSMV_FC_CHARGE_AMT(Double SMV_FC_CHARGE_AMT) {
		this.SMV_FC_CHARGE_AMT = SMV_FC_CHARGE_AMT;
	}

	public Double getSMV_FC_CHARGE_AMT() {
		return SMV_FC_CHARGE_AMT;
	}

	public void setSMV_AMT5(Double SMV_AMT5) {
		this.SMV_AMT5 = SMV_AMT5;
	}

	public Double getSMV_AMT5() {
		return SMV_AMT5;
	}

	public void setSMV_FC_ACC_PROFIT(Double SMV_FC_ACC_PROFIT) {
		this.SMV_FC_ACC_PROFIT = SMV_FC_ACC_PROFIT;
	}

	public Double getSMV_FC_ACC_PROFIT() {
		return SMV_FC_ACC_PROFIT;
	}

	public void setSMV_LC_NET_PAID_AMT(Double SMV_LC_NET_PAID_AMT) {
		this.SMV_LC_NET_PAID_AMT = SMV_LC_NET_PAID_AMT;
	}

	public Double getSMV_LC_NET_PAID_AMT() {
		return SMV_LC_NET_PAID_AMT;
	}

	public void setSMV_LOAN_INT_YN(String SMV_LOAN_INT_YN) {
		this.SMV_LOAN_INT_YN = SMV_LOAN_INT_YN;
	}

	public String getSMV_LOAN_INT_YN() {
		return SMV_LOAN_INT_YN;
	}

	public void setSMV_PAID_DT(Date SMV_PAID_DT) {
		this.SMV_PAID_DT = SMV_PAID_DT;
	}

	public Date getSMV_PAID_DT() {
		return SMV_PAID_DT;
	}
	
	public String getUI_SMV_PAID_DT(){
		String UI_SMV_PAID_DT = CommonUtils.dateToPELStringFormatter(SMV_PAID_DT);
		return UI_SMV_PAID_DT;
	}

	public void setSMV_FC_GROSS_VALUE(Double SMV_FC_GROSS_VALUE) {
		this.SMV_FC_GROSS_VALUE = SMV_FC_GROSS_VALUE;
	}

	public Double getSMV_FC_GROSS_VALUE() {
		return SMV_FC_GROSS_VALUE;
	}

	public void setSMV_APPRV_FLAG(String SMV_APPRV_FLAG) {
		this.SMV_APPRV_FLAG = SMV_APPRV_FLAG;
	}

	public String getSMV_APPRV_FLAG() {
		return SMV_APPRV_FLAG;
	}

	public void setSMV_LC_GROSS_VALUE(Double SMV_LC_GROSS_VALUE) {
		this.SMV_LC_GROSS_VALUE = SMV_LC_GROSS_VALUE;
	}

	public Double getSMV_LC_GROSS_VALUE() {
		return SMV_LC_GROSS_VALUE;
	}

	public void setSMV_AMT2(Double SMV_AMT2) {
		this.SMV_AMT2 = SMV_AMT2;
	}

	public Double getSMV_AMT2() {
		return SMV_AMT2;
	}

	public void setSMV_AMT1(Double SMV_AMT1) {
		this.SMV_AMT1 = SMV_AMT1;
	}

	public Double getSMV_AMT1() {
		return SMV_AMT1;
	}

	public void setSMV_AMT4(Double SMV_AMT4) {
		this.SMV_AMT4 = SMV_AMT4;
	}

	public Double getSMV_AMT4() {
		return SMV_AMT4;
	}

	public void setSMV_AMT3(Double SMV_AMT3) {
		this.SMV_AMT3 = SMV_AMT3;
	}

	public Double getSMV_AMT3() {
		return SMV_AMT3;
	}

	public void setSMV_LC_OS_LOAN(Double SMV_LC_OS_LOAN) {
		this.SMV_LC_OS_LOAN = SMV_LC_OS_LOAN;
	}

	public Double getSMV_LC_OS_LOAN() {
		return SMV_LC_OS_LOAN;
	}

	public void setSMV_FC_NET_PAID_AMT(Double SMV_FC_NET_PAID_AMT) {
		this.SMV_FC_NET_PAID_AMT = SMV_FC_NET_PAID_AMT;
	}

	public Double getSMV_FC_NET_PAID_AMT() {
		return SMV_FC_NET_PAID_AMT;
	}

	public void setSMV_UNPAID_PREM_INT_CODE(String SMV_UNPAID_PREM_INT_CODE) {
		this.SMV_UNPAID_PREM_INT_CODE = SMV_UNPAID_PREM_INT_CODE;
	}

	public String getSMV_UNPAID_PREM_INT_CODE() {
		return SMV_UNPAID_PREM_INT_CODE;
	}

	public void setSMV_FC_UNPAID_PREM_INT(Double SMV_FC_UNPAID_PREM_INT) {
		this.SMV_FC_UNPAID_PREM_INT = SMV_FC_UNPAID_PREM_INT;
	}

	public Double getSMV_FC_UNPAID_PREM_INT() {
		return SMV_FC_UNPAID_PREM_INT;
	}

	public void setSMV_LC_RED_SA(Double SMV_LC_RED_SA) {
		this.SMV_LC_RED_SA = SMV_LC_RED_SA;
	}

	public Double getSMV_LC_RED_SA() {
		return SMV_LC_RED_SA;
	}

	public void setSMV_APPRV_DT(Date SMV_APPRV_DT) {
		this.SMV_APPRV_DT = SMV_APPRV_DT;
	}

	public Date getSMV_APPRV_DT() {
		return SMV_APPRV_DT;
	}

	public void setSMV_LC_ACC_PROFIT(Double SMV_LC_ACC_PROFIT) {
		this.SMV_LC_ACC_PROFIT = SMV_LC_ACC_PROFIT;
	}

	public Double getSMV_LC_ACC_PROFIT() {
		return SMV_LC_ACC_PROFIT;
	}

	public void setSMV_DATE(Date SMV_DATE) {
		
		this.SMV_DATE = SMV_DATE;
	}

	public Date getSMV_DATE() {
		return SMV_DATE;
	}

	public String getUI_SMV_DATE(){
		String UI_SMV_DATE  =  CommonUtils.dateToPELStringFormatter(SMV_DATE);
		return UI_SMV_DATE;
	}
	
	public void setSMV_UPD_DT(Date SMV_UPD_DT) {
		this.SMV_UPD_DT = SMV_UPD_DT;
	}

	public Date getSMV_UPD_DT() {
		return SMV_UPD_DT;
	}

	public void setSMV_LC_UNPAID_PREM_INT(Double SMV_LC_UNPAID_PREM_INT) {
		this.SMV_LC_UNPAID_PREM_INT = SMV_LC_UNPAID_PREM_INT;
	}

	public Double getSMV_LC_UNPAID_PREM_INT() {
		return SMV_LC_UNPAID_PREM_INT;
	}

	public void setSMV_APPRV_UID(String SMV_APPRV_UID) {
		this.SMV_APPRV_UID = SMV_APPRV_UID;
	}

	public String getSMV_APPRV_UID() {
		return SMV_APPRV_UID;
	}

	public void setUI_M_FC_NET_PAID_AMT(Double UI_M_FC_NET_PAID_AMT) {
		this.UI_M_FC_NET_PAID_AMT = UI_M_FC_NET_PAID_AMT;
	}

	public Double getUI_M_FC_NET_PAID_AMT() {
		return UI_M_FC_NET_PAID_AMT;
	}

	public void setSMV_FC_UNPAID_PREM(Double SMV_FC_UNPAID_PREM) {
		this.SMV_FC_UNPAID_PREM = SMV_FC_UNPAID_PREM;
	}

	public Double getSMV_FC_UNPAID_PREM() {
		return SMV_FC_UNPAID_PREM;
	}

	public void setSMV_LC_LOAN_INT(Double SMV_LC_LOAN_INT) {
		this.SMV_LC_LOAN_INT = SMV_LC_LOAN_INT;
	}

	public Double getSMV_LC_LOAN_INT() {
		return SMV_LC_LOAN_INT;
	}

	public void setSMV_LETTER_DATE(Date SMV_LETTER_DATE) {
		this.SMV_LETTER_DATE = SMV_LETTER_DATE;
	}

	public Date getSMV_LETTER_DATE() {
		return SMV_LETTER_DATE;
	}

	public void setSMV_PAYTO(String SMV_PAYTO) {
		this.SMV_PAYTO = SMV_PAYTO;
	}

	public String getSMV_PAYTO() {
		return SMV_PAYTO;
	}

	public void setSMV_LC_BAL_LOAN(Double SMV_LC_BAL_LOAN) {
		this.SMV_LC_BAL_LOAN = SMV_LC_BAL_LOAN;
	}

	public Double getSMV_LC_BAL_LOAN() {
		return SMV_LC_BAL_LOAN;
	}

	public void setSMV_TYPE(String SMV_TYPE) {
		this.SMV_TYPE = SMV_TYPE;
	}

	public String getSMV_TYPE() {
		return SMV_TYPE;
	}

	public void setSMV_FC_LOAN_INT(Double SMV_FC_LOAN_INT) {
		this.SMV_FC_LOAN_INT = SMV_FC_LOAN_INT;
	}

	public Double getSMV_FC_LOAN_INT() {
		return SMV_FC_LOAN_INT;
	}

	public void setSMV_FC_OS_LOAN(Double SMV_FC_OS_LOAN) {
		this.SMV_FC_OS_LOAN = SMV_FC_OS_LOAN;
	}

	public Double getSMV_FC_OS_LOAN() {
		return SMV_FC_OS_LOAN;
	}

	public void setSMV_CR_UID(String SMV_CR_UID) {
		this.SMV_CR_UID = SMV_CR_UID;
	}

	public String getSMV_CR_UID() {
		return SMV_CR_UID;
	}

	public void setSMV_CR_DT(Date SMV_CR_DT) {
		this.SMV_CR_DT = SMV_CR_DT;
	}

	public Date getSMV_CR_DT() {
		return SMV_CR_DT;
	}

	public void setSMV_FC_RED_SA(Double SMV_FC_RED_SA) {
		this.SMV_FC_RED_SA = SMV_FC_RED_SA;
	}

	public Double getSMV_FC_RED_SA() {
		return SMV_FC_RED_SA;
	}

	public void setUI_M_LC_NET_PAID_AMT(Double UI_M_LC_NET_PAID_AMT) {
		this.UI_M_LC_NET_PAID_AMT = UI_M_LC_NET_PAID_AMT;
	}

	public Double getUI_M_LC_NET_PAID_AMT() {
		return UI_M_LC_NET_PAID_AMT;
	}

	public void setSMV_LC_CHARGE_AMT(Double SMV_LC_CHARGE_AMT) {
		this.SMV_LC_CHARGE_AMT = SMV_LC_CHARGE_AMT;
	}

	public Double getSMV_LC_CHARGE_AMT() {
		return SMV_LC_CHARGE_AMT;
	}

	public void setSMV_REASON_CODE(String SMV_REASON_CODE) {
		this.SMV_REASON_CODE = SMV_REASON_CODE;
	}

	public String getSMV_REASON_CODE() {
		return SMV_REASON_CODE;
	}

	public void setSMV_PREV_SCH_DATE(Date SMV_PREV_SCH_DATE) {
		this.SMV_PREV_SCH_DATE = SMV_PREV_SCH_DATE;
	}

	public Date getSMV_PREV_SCH_DATE() {
		return SMV_PREV_SCH_DATE;
	}

	public void setSMV_CHARGE_CODE(String SMV_CHARGE_CODE) {
		this.SMV_CHARGE_CODE = SMV_CHARGE_CODE;
	}

	public String getSMV_CHARGE_CODE() {
		return SMV_CHARGE_CODE;
	}

	public void setSMV_UNPAID_PREM_YN(String SMV_UNPAID_PREM_YN) {
		this.SMV_UNPAID_PREM_YN = SMV_UNPAID_PREM_YN;
	}

	public String getSMV_UNPAID_PREM_YN() {
		return SMV_UNPAID_PREM_YN;
	}

	public void setSMV_SYS_ID(Long SMV_SYS_ID) {
		this.SMV_SYS_ID = SMV_SYS_ID;
	}

	public Long getSMV_SYS_ID() {
		return SMV_SYS_ID;
	}

	public void setSMV_DOC_ID(String SMV_DOC_ID) {
		this.SMV_DOC_ID = SMV_DOC_ID;
	}

	public String getSMV_DOC_ID() {
		return SMV_DOC_ID;
	}

	public void setSMV_REMARKS(String SMV_REMARKS) {
		this.SMV_REMARKS = SMV_REMARKS;
	}

	public String getSMV_REMARKS() {
		return SMV_REMARKS;
	}

	public void setSMV_UPD_UID(String SMV_UPD_UID) {
		this.SMV_UPD_UID = SMV_UPD_UID;
	}

	public String getSMV_UPD_UID() {
		return SMV_UPD_UID;
	}

	public void setSMV_RESERVE_FLAG(String SMV_RESERVE_FLAG) {
		this.SMV_RESERVE_FLAG = SMV_RESERVE_FLAG;
	}

	public String getSMV_RESERVE_FLAG() {
		return SMV_RESERVE_FLAG;
	}

	public void setSMV_DEL_FLAG(String SMV_DEL_FLAG) {
		this.SMV_DEL_FLAG = SMV_DEL_FLAG;
	}

	public String getSMV_DEL_FLAG() {
		return SMV_DEL_FLAG;
	}

	public void setSMV_FC_BAL_LOAN(Double SMV_FC_BAL_LOAN) {
		this.SMV_FC_BAL_LOAN = SMV_FC_BAL_LOAN;
	}

	public Double getSMV_FC_BAL_LOAN() {
		return SMV_FC_BAL_LOAN;
	}

	public void setSMV_REF_NO(String SMV_REF_NO) {
		this.SMV_REF_NO = SMV_REF_NO;
	}

	public String getSMV_REF_NO() {
		return SMV_REF_NO;
	}

	public void setSMV_TRAN_DATE(Date SMV_TRAN_DATE) {
		this.SMV_TRAN_DATE = SMV_TRAN_DATE;
	}

	public Date getSMV_TRAN_DATE() {
		return SMV_TRAN_DATE;
	}

	public void setSMV_LC_UNPAID_PREM(Double SMV_LC_UNPAID_PREM) {
		this.SMV_LC_UNPAID_PREM = SMV_LC_UNPAID_PREM;
	}

	public Double getSMV_LC_UNPAID_PREM() {
		return SMV_LC_UNPAID_PREM;
	}

	public void setSMV_STATUS_CODE(String SMV_STATUS_CODE) {
		this.SMV_STATUS_CODE = SMV_STATUS_CODE;
	}

	public String getSMV_STATUS_CODE() {
		return SMV_STATUS_CODE;
	}

	public void setSMV_LOAN_CODE(String SMV_LOAN_CODE) {
		this.SMV_LOAN_CODE = SMV_LOAN_CODE;
	}

	public String getSMV_LOAN_CODE() {
		return SMV_LOAN_CODE;
	}

	public String getUI_M_CHARGE_DESC() {
		return UI_M_CHARGE_DESC;
	}

	public void setUI_M_CHARGE_DESC(String ui_m_charge_desc) {
		UI_M_CHARGE_DESC = ui_m_charge_desc;
	}

	public String getSMV_FLEX01() {
		return SMV_FLEX01;
	}

	public void setSMV_FLEX01(String smv_flex01) {
		SMV_FLEX01 = smv_flex01;
	}

	public String getSMV_FLEX02() {
		return SMV_FLEX02;
	}

	public void setSMV_FLEX02(String smv_flex02) {
		SMV_FLEX02 = smv_flex02;
	}

	public String getSMV_FLEX04() {
		return SMV_FLEX04;
	}

	public void setSMV_FLEX04(String smv_flex04) {
		SMV_FLEX04 = smv_flex04;
	}

	public String getSMV_FLEX05() {
		return SMV_FLEX05;
	}

	public void setSMV_FLEX05(String smv_flex05) {
		SMV_FLEX05 = smv_flex05;
	}

	public String getSMV_FLEX06() {
		return SMV_FLEX06;
	}

	public void setSMV_FLEX06(String smv_flex06) {
		SMV_FLEX06 = smv_flex06;
	}

	
	
	/*added by raja on 03-05-2017*/
	
	@Column(name = "SMV_FLEX07")
private String UI_M_BANK_CODE;
	
	@Column(name = "SMV_FLEX08")
	private String UI_M_BRANCH_CODE;
	
	private Double UI_M_TOTAL_FC_AMT;
	
	private Double UI_M_TOTAL_LC_AMT;

	@Column(name = "SMV_FLEX09")
	private String UI_M_BANK_NAME;
	
	

	public String getUI_M_BANK_NAME() {
		return UI_M_BANK_NAME;
	}

	public void setUI_M_BANK_NAME(String uI_M_BANK_NAME) {
		UI_M_BANK_NAME = uI_M_BANK_NAME;
	}

	public String getUI_M_BANK_CODE() {
		return UI_M_BANK_CODE;
	}

	public void setUI_M_BANK_CODE(String uI_M_BANK_CODE) {
		UI_M_BANK_CODE = uI_M_BANK_CODE;
	}

	public String getUI_M_BRANCH_CODE() {
		return UI_M_BRANCH_CODE;
	}

	public void setUI_M_BRANCH_CODE(String uI_M_BRANCH_CODE) {
		UI_M_BRANCH_CODE = uI_M_BRANCH_CODE;
	}

	public Double getUI_M_TOTAL_FC_AMT() {
		return UI_M_TOTAL_FC_AMT;
	}

	public void setUI_M_TOTAL_FC_AMT(Double uI_M_TOTAL_FC_AMT) {
		UI_M_TOTAL_FC_AMT = uI_M_TOTAL_FC_AMT;
	}

	public Double getUI_M_TOTAL_LC_AMT() {
		return UI_M_TOTAL_LC_AMT;
	}

	public void setUI_M_TOTAL_LC_AMT(Double uI_M_TOTAL_LC_AMT) {
		UI_M_TOTAL_LC_AMT = uI_M_TOTAL_LC_AMT;
	}

	
	
	
	/*end*/

	/* Newly added By Dhinesh on 17-7-2017 for ssp call id  : */
	
	@Column(name = "SMV_INT_VALUE")
	private Double SMV_INT_VALUE;

	public Double getSMV_INT_VALUE() {
		return SMV_INT_VALUE;
	}

	public void setSMV_INT_VALUE(Double sMV_INT_VALUE) {
		SMV_INT_VALUE = sMV_INT_VALUE;
	}

	
	/*End*/

	
	/*Added by Janani on 25.07.2017 for ZBILQC-1731997*/
	
	private Double cashback_amt;
	
	public Double getCashback_amt() {
		return cashback_amt;
	}

	public void setCashback_amt(Double cashback_amt) {
		this.cashback_amt = cashback_amt;
	}


	private Double cust_total_amt;



	public Double getCust_total_amt() {
		return cust_total_amt;
	}

	public void setCust_total_amt(Double cust_total_amt) {
		this.cust_total_amt = cust_total_amt;
	}

	
	
	
	
	/*End*/
	
	/*Added by Ameen on 01-12-2017 for ZBLIFE-1458892*/
	@Column(name="SMV_FLEX10")
	private String SMV_FLEX10;
	 
	@Column(name="SMV_FLEX11")
	private String SMV_FLEX11;

	@Column(name="SMV_FLEX12")
	private String SMV_FLEX12;
	
	private String UI_M_DIVN_CODE;

	public String getSMV_FLEX10() {
		return SMV_FLEX10;
	}

	public void setSMV_FLEX10(String sMV_FLEX10) {
		SMV_FLEX10 = sMV_FLEX10;
	}

	public String getSMV_FLEX11() {
		return SMV_FLEX11;
	}

	public void setSMV_FLEX11(String sMV_FLEX11) {
		SMV_FLEX11 = sMV_FLEX11;
	}

	public String getSMV_FLEX12() {
		return SMV_FLEX12;
	}

	public void setSMV_FLEX12(String sMV_FLEX12) {
		SMV_FLEX12 = sMV_FLEX12;
	}

	public String getUI_M_DIVN_CODE() {
		return UI_M_DIVN_CODE;
	}

	public void setUI_M_DIVN_CODE(String uI_M_DIVN_CODE) {
		UI_M_DIVN_CODE = uI_M_DIVN_CODE;
	}
	 
	/*End*/
	
	
	/*New field added by saritha on 14-02-2018 for Surrender/Maturity Payment Bank Details Issues as per thiag sir sugg.*/
	
	@Column(name="SMV_PAYEE_NAME")
	private String SMV_PAYEE_NAME;

	public String getSMV_PAYEE_NAME() {
		return SMV_PAYEE_NAME;
	}

	public void setSMV_PAYEE_NAME(String sMV_PAYEE_NAME) {
		SMV_PAYEE_NAME = sMV_PAYEE_NAME;
	}
	
	/*End*/
	private String UI_M_STATUS_CODE;

	public String getUI_M_STATUS_CODE() {
		return UI_M_STATUS_CODE;
	}

	public void setUI_M_STATUS_CODE(String uI_M_STATUS_CODE) {
		UI_M_STATUS_CODE = uI_M_STATUS_CODE;
	}
	
}

