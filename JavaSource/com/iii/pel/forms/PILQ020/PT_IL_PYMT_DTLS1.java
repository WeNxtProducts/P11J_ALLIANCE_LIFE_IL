package com.iii.pel.forms.PILQ020;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="PT_IL_PYMT_DTLS")
public class PT_IL_PYMT_DTLS1 extends BaseValueBean {

	@Column(name="PD_SYS_ID")
	private Long PD_SYS_ID;

	@Column(name="PD_SR_NO")
	private Double PD_SR_NO;

	@Column(name="PD_TXN_TYPE")
	private String PD_TXN_TYPE;

	@Column(name="PD_TXN_SYS_ID")
	private Long PD_TXN_SYS_ID;

	@Column(name="PD_PAY_MODE")
	private String PD_PAY_MODE;

	@Column(name="PD_CURR_CODE")
	private String PD_CURR_CODE;

	@Column(name="PD_FC_AMT")
	private Double PD_FC_AMT;

	@Column(name="PD_LC_AMT")
	private Double PD_LC_AMT;

	@Column(name="PD_CHQ_NO")
	private String PD_CHQ_NO;

	@Column(name="PD_CHQ_DT")
	private Date PD_CHQ_DT;

	@Column(name="PD_BANK_NAME")
	private String PD_BANK_NAME;

	@Column(name="PD_BRANCH_NAME")
	private String PD_BRANCH_NAME;

	@Column(name="PD_CC_NO")
	private String PD_CC_NO;

	@Column(name="PD_CC_NAME")
	private String PD_CC_NAME;

	@Column(name="PD_CC_EXP_DT")
	private Date PD_CC_EXP_DT;

	@Column(name="PD_CC_TYPE")
	private String PD_CC_TYPE;

	@Column(name="PD_CUST_NAME")
	private String PD_CUST_NAME;

	@Column(name="PD_ADDR_01")
	private String PD_ADDR_01;

	@Column(name="PD_ADDR_02")
	private String PD_ADDR_02;

	@Column(name="PD_ADDR_03")
	private String PD_ADDR_03;

	@Column(name="PD_REMARKS")
	private String PD_REMARKS;

	@Column(name="PD_CR_UID")
	private String PD_CR_UID;

	@Column(name="PD_CR_DT")
	private Date PD_CR_DT;

	@Column(name="PD_UPD_UID")
	private String PD_UPD_UID;

	@Column(name="PD_UPD_DT")
	private Date PD_UPD_DT;

	@Column(name="PD_DPD_REF_ID")
	private String PD_DPD_REF_ID;

	@Column(name="PD_REV_YN")
	private String PD_REV_YN;

	@Column(name="PD_LC_CHARGE")
	private Double PD_LC_CHARGE;

	@Column(name="PD_FC_CHARGE")
	private Double PD_FC_CHARGE;

	@Column(name="PD_PAID_FOR")
	private String PD_PAID_FOR;

	@Column(name="PD_CC_APP_CODE")
	private String PD_CC_APP_CODE;

	@Column(name="PD_PAYIN_DATE")
	private Date PD_PAYIN_DATE;

	@Column(name="PD_OUR_BANK_CODE")
	private String PD_OUR_BANK_CODE;

	@Column(name="PD_DATE_OF_CREDIT")
	private Date PD_DATE_OF_CREDIT;

	@Column(name="PD_TT_REF_NO")
	private String PD_TT_REF_NO;

	@Column(name="PD_TT_CURR_CODE")
	private String PD_TT_CURR_CODE;

	@Column(name="PD_REM_SLIP_GEN_YN")
	private String PD_REM_SLIP_GEN_YN;

	@Column(name="PD_PO_MO_NO")
	private String PD_PO_MO_NO;

	@Column(name="PD_PO_MO_DT")
	private Date PD_PO_MO_DT;

	@Column(name="PD_REM_AMT")
	private Double PD_REM_AMT;

	@Column(name="PD_BANK_REF_NO")
	private String PD_BANK_REF_NO;

	@Column(name="PD_CR_ADVICE_NO")
	private String PD_CR_ADVICE_NO;

	@Column(name="PD_ATM_CARD_NO")
	private String PD_ATM_CARD_NO;
	
	private String UI_PD_CHQ_DT;

	public String getUI_PD_CHQ_DT() {
		UI_PD_CHQ_DT = CommonUtils.dateToPELStringFormatter(PD_CHQ_DT);
		return UI_PD_CHQ_DT;
	}
	public void setUI_PD_CHQ_DT(String ui_pd_chq_dt) {
		UI_PD_CHQ_DT = ui_pd_chq_dt;
	}
	public void setPD_SR_NO(Double PD_SR_NO) {
		this.PD_SR_NO = PD_SR_NO;
	}
	public Double getPD_SR_NO() {
		 return PD_SR_NO;
	}
	public void setPD_CC_APP_CODE(String PD_CC_APP_CODE) {
		this.PD_CC_APP_CODE = PD_CC_APP_CODE;
	}
	public String getPD_CC_APP_CODE() {
		 return PD_CC_APP_CODE;
	}
	public void setPD_TT_REF_NO(String PD_TT_REF_NO) {
		this.PD_TT_REF_NO = PD_TT_REF_NO;
	}
	public String getPD_TT_REF_NO() {
		 return PD_TT_REF_NO;
	}
	public void setPD_DATE_OF_CREDIT(Date PD_DATE_OF_CREDIT) {
		this.PD_DATE_OF_CREDIT = PD_DATE_OF_CREDIT;
	}
	public Date getPD_DATE_OF_CREDIT() {
		 return PD_DATE_OF_CREDIT;
	}
	public void setPD_CC_TYPE(String PD_CC_TYPE) {
		this.PD_CC_TYPE = PD_CC_TYPE;
	}
	public String getPD_CC_TYPE() {
		 return PD_CC_TYPE;
	}
	public void setPD_UPD_UID(String PD_UPD_UID) {
		this.PD_UPD_UID = PD_UPD_UID;
	}
	public String getPD_UPD_UID() {
		 return PD_UPD_UID;
	}
	public void setPD_LC_AMT(Double PD_LC_AMT) {
		this.PD_LC_AMT = PD_LC_AMT;
	}
	public Double getPD_LC_AMT() {
		 return PD_LC_AMT;
	}
	public void setPD_ATM_CARD_NO(String PD_ATM_CARD_NO) {
		this.PD_ATM_CARD_NO = PD_ATM_CARD_NO;
	}
	public String getPD_ATM_CARD_NO() {
		 return PD_ATM_CARD_NO;
	}
	public void setPD_LC_CHARGE(Double PD_LC_CHARGE) {
		this.PD_LC_CHARGE = PD_LC_CHARGE;
	}
	public Double getPD_LC_CHARGE() {
		 return PD_LC_CHARGE;
	}
	public void setPD_BRANCH_NAME(String PD_BRANCH_NAME) {
		this.PD_BRANCH_NAME = PD_BRANCH_NAME;
	}
	public String getPD_BRANCH_NAME() {
		 return PD_BRANCH_NAME;
	}
	public void setPD_CC_NO(String PD_CC_NO) {
		this.PD_CC_NO = PD_CC_NO;
	}
	public String getPD_CC_NO() {
		 return PD_CC_NO;
	}
	public void setPD_REM_AMT(Double PD_REM_AMT) {
		this.PD_REM_AMT = PD_REM_AMT;
	}
	public Double getPD_REM_AMT() {
		 return PD_REM_AMT;
	}
	public void setPD_PAY_MODE(String PD_PAY_MODE) {
		this.PD_PAY_MODE = PD_PAY_MODE;
	}
	public String getPD_PAY_MODE() {
		 return PD_PAY_MODE;
	}
	public void setPD_DPD_REF_ID(String PD_DPD_REF_ID) {
		this.PD_DPD_REF_ID = PD_DPD_REF_ID;
	}
	public String getPD_DPD_REF_ID() {
		 return PD_DPD_REF_ID;
	}
	public void setPD_TT_CURR_CODE(String PD_TT_CURR_CODE) {
		this.PD_TT_CURR_CODE = PD_TT_CURR_CODE;
	}
	public String getPD_TT_CURR_CODE() {
		 return PD_TT_CURR_CODE;
	}
	public void setPD_CURR_CODE(String PD_CURR_CODE) {
		this.PD_CURR_CODE = PD_CURR_CODE;
	}
	public String getPD_CURR_CODE() {
		 return PD_CURR_CODE;
	}
	public void setPD_PO_MO_DT(Date PD_PO_MO_DT) {
		this.PD_PO_MO_DT = PD_PO_MO_DT;
	}
	public Date getPD_PO_MO_DT() {
		 return PD_PO_MO_DT;
	}
	public void setPD_FC_AMT(Double PD_FC_AMT) {
		this.PD_FC_AMT = PD_FC_AMT;
	}
	public Double getPD_FC_AMT() {
		 return PD_FC_AMT;
	}
	public void setPD_BANK_REF_NO(String PD_BANK_REF_NO) {
		this.PD_BANK_REF_NO = PD_BANK_REF_NO;
	}
	public String getPD_BANK_REF_NO() {
		 return PD_BANK_REF_NO;
	}
	public void setPD_CC_NAME(String PD_CC_NAME) {
		this.PD_CC_NAME = PD_CC_NAME;
	}
	public String getPD_CC_NAME() {
		 return PD_CC_NAME;
	}
	public void setPD_ADDR_02(String PD_ADDR_02) {
		this.PD_ADDR_02 = PD_ADDR_02;
	}
	public String getPD_ADDR_02() {
		 return PD_ADDR_02;
	}
	public void setPD_ADDR_01(String PD_ADDR_01) {
		this.PD_ADDR_01 = PD_ADDR_01;
	}
	public String getPD_ADDR_01() {
		 return PD_ADDR_01;
	}
	public void setPD_ADDR_03(String PD_ADDR_03) {
		this.PD_ADDR_03 = PD_ADDR_03;
	}
	public String getPD_ADDR_03() {
		 return PD_ADDR_03;
	}
	public void setPD_REMARKS(String PD_REMARKS) {
		this.PD_REMARKS = PD_REMARKS;
	}
	public String getPD_REMARKS() {
		 return PD_REMARKS;
	}
	public void setPD_SYS_ID(Long PD_SYS_ID) {
		this.PD_SYS_ID = PD_SYS_ID;
	}
	public Long getPD_SYS_ID() {
		 return PD_SYS_ID;
	}
	public void setPD_UPD_DT(Date PD_UPD_DT) {
		this.PD_UPD_DT = PD_UPD_DT;
	}
	public Date getPD_UPD_DT() {
		 return PD_UPD_DT;
	}
	public void setPD_PO_MO_NO(String PD_PO_MO_NO) {
		this.PD_PO_MO_NO = PD_PO_MO_NO;
	}
	public String getPD_PO_MO_NO() {
		 return PD_PO_MO_NO;
	}
	public void setPD_PAYIN_DATE(Date PD_PAYIN_DATE) {
		this.PD_PAYIN_DATE = PD_PAYIN_DATE;
	}
	public Date getPD_PAYIN_DATE() {
		 return PD_PAYIN_DATE;
	}
	public void setPD_TXN_SYS_ID(Long PD_TXN_SYS_ID) {
		this.PD_TXN_SYS_ID = PD_TXN_SYS_ID;
	}
	public Long getPD_TXN_SYS_ID() {
		 return PD_TXN_SYS_ID;
	}
	public void setPD_OUR_BANK_CODE(String PD_OUR_BANK_CODE) {
		this.PD_OUR_BANK_CODE = PD_OUR_BANK_CODE;
	}
	public String getPD_OUR_BANK_CODE() {
		 return PD_OUR_BANK_CODE;
	}
	public void setPD_CR_DT(Date PD_CR_DT) {
		this.PD_CR_DT = PD_CR_DT;
	}
	public Date getPD_CR_DT() {
		 return PD_CR_DT;
	}
	public void setPD_REV_YN(String PD_REV_YN) {
		this.PD_REV_YN = PD_REV_YN;
	}
	public String getPD_REV_YN() {
		 return PD_REV_YN;
	}
	public void setPD_REM_SLIP_GEN_YN(String PD_REM_SLIP_GEN_YN) {
		this.PD_REM_SLIP_GEN_YN = PD_REM_SLIP_GEN_YN;
	}
	public String getPD_REM_SLIP_GEN_YN() {
		 return PD_REM_SLIP_GEN_YN;
	}
	public void setPD_BANK_NAME(String PD_BANK_NAME) {
		this.PD_BANK_NAME = PD_BANK_NAME;
	}
	public String getPD_BANK_NAME() {
		 return PD_BANK_NAME;
	}
	public void setPD_CR_UID(String PD_CR_UID) {
		this.PD_CR_UID = PD_CR_UID;
	}
	public String getPD_CR_UID() {
		 return PD_CR_UID;
	}
	public void setPD_CHQ_DT(Date PD_CHQ_DT) {
		this.PD_CHQ_DT = PD_CHQ_DT;
	}
	public Date getPD_CHQ_DT() {
		 return PD_CHQ_DT;
	}
	public void setPD_TXN_TYPE(String PD_TXN_TYPE) {
		this.PD_TXN_TYPE = PD_TXN_TYPE;
	}
	public String getPD_TXN_TYPE() {
		 return PD_TXN_TYPE;
	}
	public void setPD_CUST_NAME(String PD_CUST_NAME) {
		this.PD_CUST_NAME = PD_CUST_NAME;
	}
	public String getPD_CUST_NAME() {
		 return PD_CUST_NAME;
	}
	public void setPD_CR_ADVICE_NO(String PD_CR_ADVICE_NO) {
		this.PD_CR_ADVICE_NO = PD_CR_ADVICE_NO;
	}
	public String getPD_CR_ADVICE_NO() {
		 return PD_CR_ADVICE_NO;
	}
	public void setPD_CHQ_NO(String PD_CHQ_NO) {
		this.PD_CHQ_NO = PD_CHQ_NO;
	}
	public String getPD_CHQ_NO() {
		 return PD_CHQ_NO;
	}
	public void setPD_PAID_FOR(String PD_PAID_FOR) {
		this.PD_PAID_FOR = PD_PAID_FOR;
	}
	public String getPD_PAID_FOR() {
		 return PD_PAID_FOR;
	}
	public void setPD_FC_CHARGE(Double PD_FC_CHARGE) {
		this.PD_FC_CHARGE = PD_FC_CHARGE;
	}
	public Double getPD_FC_CHARGE() {
		 return PD_FC_CHARGE;
	}
	public void setPD_CC_EXP_DT(Date PD_CC_EXP_DT) {
		this.PD_CC_EXP_DT = PD_CC_EXP_DT;
	}
	public Date getPD_CC_EXP_DT() {
		 return PD_CC_EXP_DT;
	}

}