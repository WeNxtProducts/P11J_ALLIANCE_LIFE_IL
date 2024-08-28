package com.iii.pel.forms.PILT005;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name="PT_IL_PYMT_DTLS")
public class PT_IL_PYMT_DTLS {

	@Column(name="PD_CC_TYPE")
	private String PD_CC_TYPE;

	private String UI_M_BANK_REF_NO;

	private String UI_M_OUR_BANK_CODE_2;

	@Column(name="PD_PO_MO_NO")
	private String PD_PO_MO_NO;

	@Column(name="PD_OUR_BANK_CODE")
	private String PD_OUR_BANK_CODE;

	private String UI_M_OUR_BANK_CODE;

	private String UI_M_BANK_REF_NO_2;

	private String UI_M_PD_CC_TYPE;

	@Column(name="PD_SR_NO")
	private Double PD_SR_NO;

	@Column(name="PD_CC_NO")
	private String PD_CC_NO;

	@Column(name="PD_PAY_MODE")
	private String PD_PAY_MODE;

	@Column(name="PD_ATM_CARD_NO")
	private String PD_ATM_CARD_NO;

	@Column(name="PD_BANK_REF_NO")
	private String PD_BANK_REF_NO;

	private String UI_M_PD_CC_NO;

	@Column(name="PD_DATE_OF_CREDIT")
	private Date PD_DATE_OF_CREDIT;

	@Column(name="PD_PO_MO_DT")
	private Date PD_PO_MO_DT;

	@Column(name="PD_REM_SLIP_GEN_YN")
	private String PD_REM_SLIP_GEN_YN;

	private Date UI_M_DATE_OF_CREDIT_1;

	@Column(name="PD_CC_NAME")
	private String PD_CC_NAME;

	@Column(name="PD_DPD_REF_ID")
	private String PD_DPD_REF_ID;

	private String UI_M_PD_CC_APP_CODE;

	private Date UI_M_DATE_OF_CREDIT;

	private String UI_M_CHQ_NO;

	@Column(name="PD_TT_REF_NO")
	private String PD_TT_REF_NO;

	private String UI_M_REM_SLIP_GEN_YN;

	@Column(name="PD_CR_ADVICE_NO")
	private String PD_CR_ADVICE_NO;

	@Column(name="PD_BANK_NAME")
	private String PD_BANK_NAME;

	@Column(name="PD_BRANCH_NAME")
	private String PD_BRANCH_NAME;

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

	@Column(name="PD_CURR_CODE")
	private String PD_CURR_CODE;

	private String UI_M_PD_CURR_CODE_DESC;

	@Column(name="PD_LC_CHARGE")
	private Double PD_LC_CHARGE;

	@Column(name="PD_FC_CHARGE")
	private Double PD_FC_CHARGE;

	@Column(name="PD_FC_AMT")
	private Double PD_FC_AMT;

	@Column(name="PD_REM_AMT")
	private Double PD_REM_AMT;

	@Column(name="PD_CC_APP_CODE")
	private String PD_CC_APP_CODE;

	private String UI_M_BANK_REF_NO_1;

	@Column(name="PD_TT_CURR_CODE")
	private String PD_TT_CURR_CODE;

	private String UI_M_BANK_NAME_DESC;

	@Column(name="PD_LC_AMT")
	private Double PD_LC_AMT;

	private String UI_M_OUR_BANK_CODE_1;

	private String UI_M_EXP_DT;

	private Date UI_M_DATE_OF_CREDIT_2;

	@Column(name="PD_PAYIN_DATE")
	private Date PD_PAYIN_DATE;

	@Column(name="PD_PAID_FOR")
	private String PD_PAID_FOR;

	@Column(name="PD_CHQ_NO")
	private String PD_CHQ_NO;

	@Column(name="PD_CHQ_DT")
	private Date PD_CHQ_DT;



	public String getPD_CC_TYPE() {
		return PD_CC_TYPE;
	}

	public void setPD_CC_TYPE(String PD_CC_TYPE) {
		this.PD_CC_TYPE = PD_CC_TYPE;
	}

	public String getUI_M_BANK_REF_NO() {
		return UI_M_BANK_REF_NO;
	}

	public void setUI_M_BANK_REF_NO(String UI_M_BANK_REF_NO) {
		this.UI_M_BANK_REF_NO = UI_M_BANK_REF_NO;
	}

	public String getUI_M_OUR_BANK_CODE_2() {
		return UI_M_OUR_BANK_CODE_2;
	}

	public void setUI_M_OUR_BANK_CODE_2(String UI_M_OUR_BANK_CODE_2) {
		this.UI_M_OUR_BANK_CODE_2 = UI_M_OUR_BANK_CODE_2;
	}

	public String getPD_PO_MO_NO() {
		return PD_PO_MO_NO;
	}

	public void setPD_PO_MO_NO(String PD_PO_MO_NO) {
		this.PD_PO_MO_NO = PD_PO_MO_NO;
	}

	public String getPD_OUR_BANK_CODE() {
		return PD_OUR_BANK_CODE;
	}

	public void setPD_OUR_BANK_CODE(String PD_OUR_BANK_CODE) {
		this.PD_OUR_BANK_CODE = PD_OUR_BANK_CODE;
	}

	public String getUI_M_OUR_BANK_CODE() {
		return UI_M_OUR_BANK_CODE;
	}

	public void setUI_M_OUR_BANK_CODE(String UI_M_OUR_BANK_CODE) {
		this.UI_M_OUR_BANK_CODE = UI_M_OUR_BANK_CODE;
	}

	public String getUI_M_BANK_REF_NO_2() {
		return UI_M_BANK_REF_NO_2;
	}

	public void setUI_M_BANK_REF_NO_2(String UI_M_BANK_REF_NO_2) {
		this.UI_M_BANK_REF_NO_2 = UI_M_BANK_REF_NO_2;
	}

	public String getUI_M_PD_CC_TYPE() {
		return UI_M_PD_CC_TYPE;
	}

	public void setUI_M_PD_CC_TYPE(String UI_M_PD_CC_TYPE) {
		this.UI_M_PD_CC_TYPE = UI_M_PD_CC_TYPE;
	}

	public Double getPD_SR_NO() {
		return PD_SR_NO;
	}

	public void setPD_SR_NO(Double PD_SR_NO) {
		this.PD_SR_NO = PD_SR_NO;
	}

	public String getPD_CC_NO() {
		return PD_CC_NO;
	}

	public void setPD_CC_NO(String PD_CC_NO) {
		this.PD_CC_NO = PD_CC_NO;
	}

	public String getPD_PAY_MODE() {
		return PD_PAY_MODE;
	}

	public void setPD_PAY_MODE(String PD_PAY_MODE) {
		this.PD_PAY_MODE = PD_PAY_MODE;
	}

	public String getPD_ATM_CARD_NO() {
		return PD_ATM_CARD_NO;
	}

	public void setPD_ATM_CARD_NO(String PD_ATM_CARD_NO) {
		this.PD_ATM_CARD_NO = PD_ATM_CARD_NO;
	}

	public String getPD_BANK_REF_NO() {
		return PD_BANK_REF_NO;
	}

	public void setPD_BANK_REF_NO(String PD_BANK_REF_NO) {
		this.PD_BANK_REF_NO = PD_BANK_REF_NO;
	}

	public String getUI_M_PD_CC_NO() {
		return UI_M_PD_CC_NO;
	}

	public void setUI_M_PD_CC_NO(String UI_M_PD_CC_NO) {
		this.UI_M_PD_CC_NO = UI_M_PD_CC_NO;
	}

	public Date getPD_DATE_OF_CREDIT() {
		 return PD_DATE_OF_CREDIT;
	}

	public void setPD_DATE_OF_CREDIT(Date PD_DATE_OF_CREDIT) {
		this.PD_DATE_OF_CREDIT = PD_DATE_OF_CREDIT;
	}

	public Date getPD_PO_MO_DT() {
		 return PD_PO_MO_DT;
	}

	public void setPD_PO_MO_DT(Date PD_PO_MO_DT) {
		this.PD_PO_MO_DT = PD_PO_MO_DT;
	}

	public String getPD_REM_SLIP_GEN_YN() {
		return PD_REM_SLIP_GEN_YN;
	}

	public void setPD_REM_SLIP_GEN_YN(String PD_REM_SLIP_GEN_YN) {
		this.PD_REM_SLIP_GEN_YN = PD_REM_SLIP_GEN_YN;
	}

	public Date getUI_M_DATE_OF_CREDIT_1() {
		 return UI_M_DATE_OF_CREDIT_1;
	}

	public void setUI_M_DATE_OF_CREDIT_1(Date UI_M_DATE_OF_CREDIT_1) {
		this.UI_M_DATE_OF_CREDIT_1 = UI_M_DATE_OF_CREDIT_1;
	}

	public String getPD_CC_NAME() {
		return PD_CC_NAME;
	}

	public void setPD_CC_NAME(String PD_CC_NAME) {
		this.PD_CC_NAME = PD_CC_NAME;
	}

	public String getPD_DPD_REF_ID() {
		return PD_DPD_REF_ID;
	}

	public void setPD_DPD_REF_ID(String PD_DPD_REF_ID) {
		this.PD_DPD_REF_ID = PD_DPD_REF_ID;
	}

	public String getUI_M_PD_CC_APP_CODE() {
		return UI_M_PD_CC_APP_CODE;
	}

	public void setUI_M_PD_CC_APP_CODE(String UI_M_PD_CC_APP_CODE) {
		this.UI_M_PD_CC_APP_CODE = UI_M_PD_CC_APP_CODE;
	}

	public Date getUI_M_DATE_OF_CREDIT() {
		 return UI_M_DATE_OF_CREDIT;
	}

	public void setUI_M_DATE_OF_CREDIT(Date UI_M_DATE_OF_CREDIT) {
		this.UI_M_DATE_OF_CREDIT = UI_M_DATE_OF_CREDIT;
	}

	public String getUI_M_CHQ_NO() {
		return UI_M_CHQ_NO;
	}

	public void setUI_M_CHQ_NO(String UI_M_CHQ_NO) {
		this.UI_M_CHQ_NO = UI_M_CHQ_NO;
	}

	public String getPD_TT_REF_NO() {
		return PD_TT_REF_NO;
	}

	public void setPD_TT_REF_NO(String PD_TT_REF_NO) {
		this.PD_TT_REF_NO = PD_TT_REF_NO;
	}

	public String getUI_M_REM_SLIP_GEN_YN() {
		return UI_M_REM_SLIP_GEN_YN;
	}

	public void setUI_M_REM_SLIP_GEN_YN(String UI_M_REM_SLIP_GEN_YN) {
		this.UI_M_REM_SLIP_GEN_YN = UI_M_REM_SLIP_GEN_YN;
	}

	public String getPD_CR_ADVICE_NO() {
		return PD_CR_ADVICE_NO;
	}

	public void setPD_CR_ADVICE_NO(String PD_CR_ADVICE_NO) {
		this.PD_CR_ADVICE_NO = PD_CR_ADVICE_NO;
	}

	public String getPD_BANK_NAME() {
		return PD_BANK_NAME;
	}

	public void setPD_BANK_NAME(String PD_BANK_NAME) {
		this.PD_BANK_NAME = PD_BANK_NAME;
	}

	public String getPD_BRANCH_NAME() {
		return PD_BRANCH_NAME;
	}

	public void setPD_BRANCH_NAME(String PD_BRANCH_NAME) {
		this.PD_BRANCH_NAME = PD_BRANCH_NAME;
	}

	public String getPD_CUST_NAME() {
		return PD_CUST_NAME;
	}

	public void setPD_CUST_NAME(String PD_CUST_NAME) {
		this.PD_CUST_NAME = PD_CUST_NAME;
	}

	public String getPD_ADDR_01() {
		return PD_ADDR_01;
	}

	public void setPD_ADDR_01(String PD_ADDR_01) {
		this.PD_ADDR_01 = PD_ADDR_01;
	}

	public String getPD_ADDR_02() {
		return PD_ADDR_02;
	}

	public void setPD_ADDR_02(String PD_ADDR_02) {
		this.PD_ADDR_02 = PD_ADDR_02;
	}

	public String getPD_ADDR_03() {
		return PD_ADDR_03;
	}

	public void setPD_ADDR_03(String PD_ADDR_03) {
		this.PD_ADDR_03 = PD_ADDR_03;
	}

	public String getPD_REMARKS() {
		return PD_REMARKS;
	}

	public void setPD_REMARKS(String PD_REMARKS) {
		this.PD_REMARKS = PD_REMARKS;
	}

	public String getPD_CURR_CODE() {
		return PD_CURR_CODE;
	}

	public void setPD_CURR_CODE(String PD_CURR_CODE) {
		this.PD_CURR_CODE = PD_CURR_CODE;
	}

	public String getUI_M_PD_CURR_CODE_DESC() {
		return UI_M_PD_CURR_CODE_DESC;
	}

	public void setUI_M_PD_CURR_CODE_DESC(String UI_M_PD_CURR_CODE_DESC) {
		this.UI_M_PD_CURR_CODE_DESC = UI_M_PD_CURR_CODE_DESC;
	}

	public Double getPD_LC_CHARGE() {
		return PD_LC_CHARGE;
	}

	public void setPD_LC_CHARGE(Double PD_LC_CHARGE) {
		this.PD_LC_CHARGE = PD_LC_CHARGE;
	}

	public Double getPD_FC_CHARGE() {
		return PD_FC_CHARGE;
	}

	public void setPD_FC_CHARGE(Double PD_FC_CHARGE) {
		this.PD_FC_CHARGE = PD_FC_CHARGE;
	}

	public Double getPD_FC_AMT() {
		return PD_FC_AMT;
	}

	public void setPD_FC_AMT(Double PD_FC_AMT) {
		this.PD_FC_AMT = PD_FC_AMT;
	}

	public Double getPD_REM_AMT() {
		return PD_REM_AMT;
	}

	public void setPD_REM_AMT(Double PD_REM_AMT) {
		this.PD_REM_AMT = PD_REM_AMT;
	}

	public String getPD_CC_APP_CODE() {
		return PD_CC_APP_CODE;
	}

	public void setPD_CC_APP_CODE(String PD_CC_APP_CODE) {
		this.PD_CC_APP_CODE = PD_CC_APP_CODE;
	}

	public String getUI_M_BANK_REF_NO_1() {
		return UI_M_BANK_REF_NO_1;
	}

	public void setUI_M_BANK_REF_NO_1(String UI_M_BANK_REF_NO_1) {
		this.UI_M_BANK_REF_NO_1 = UI_M_BANK_REF_NO_1;
	}

	public String getPD_TT_CURR_CODE() {
		return PD_TT_CURR_CODE;
	}

	public void setPD_TT_CURR_CODE(String PD_TT_CURR_CODE) {
		this.PD_TT_CURR_CODE = PD_TT_CURR_CODE;
	}

	public String getUI_M_BANK_NAME_DESC() {
		return UI_M_BANK_NAME_DESC;
	}

	public void setUI_M_BANK_NAME_DESC(String UI_M_BANK_NAME_DESC) {
		this.UI_M_BANK_NAME_DESC = UI_M_BANK_NAME_DESC;
	}

	public Double getPD_LC_AMT() {
		return PD_LC_AMT;
	}

	public void setPD_LC_AMT(Double PD_LC_AMT) {
		this.PD_LC_AMT = PD_LC_AMT;
	}

	public String getUI_M_OUR_BANK_CODE_1() {
		return UI_M_OUR_BANK_CODE_1;
	}

	public void setUI_M_OUR_BANK_CODE_1(String UI_M_OUR_BANK_CODE_1) {
		this.UI_M_OUR_BANK_CODE_1 = UI_M_OUR_BANK_CODE_1;
	}

	public String getUI_M_EXP_DT() {
		return UI_M_EXP_DT;
	}

	public void setUI_M_EXP_DT(String UI_M_EXP_DT) {
		this.UI_M_EXP_DT = UI_M_EXP_DT;
	}

	public Date getUI_M_DATE_OF_CREDIT_2() {
		 return UI_M_DATE_OF_CREDIT_2;
	}

	public void setUI_M_DATE_OF_CREDIT_2(Date UI_M_DATE_OF_CREDIT_2) {
		this.UI_M_DATE_OF_CREDIT_2 = UI_M_DATE_OF_CREDIT_2;
	}

	public Date getPD_PAYIN_DATE() {
		 return PD_PAYIN_DATE;
	}

	public void setPD_PAYIN_DATE(Date PD_PAYIN_DATE) {
		this.PD_PAYIN_DATE = PD_PAYIN_DATE;
	}

	public String getPD_PAID_FOR() {
		return PD_PAID_FOR;
	}

	public void setPD_PAID_FOR(String PD_PAID_FOR) {
		this.PD_PAID_FOR = PD_PAID_FOR;
	}

	public String getPD_CHQ_NO() {
		return PD_CHQ_NO;
	}

	public void setPD_CHQ_NO(String PD_CHQ_NO) {
		this.PD_CHQ_NO = PD_CHQ_NO;
	}

	public Date getPD_CHQ_DT() {
		 return PD_CHQ_DT;
	}

	public void setPD_CHQ_DT(Date PD_CHQ_DT) {
		this.PD_CHQ_DT = PD_CHQ_DT;
	}
}
