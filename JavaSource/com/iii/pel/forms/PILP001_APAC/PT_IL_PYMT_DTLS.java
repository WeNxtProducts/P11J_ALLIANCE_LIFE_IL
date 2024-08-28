package com.iii.pel.forms.PILP001_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name="PT_IL_PYMT_DTLS")
public class PT_IL_PYMT_DTLS {

	@Column(name="PD_SR_NO")
	private Double PD_SR_NO;

	@Column(name="PD_PAY_MODE")
	private String PD_PAY_MODE;

	@Column(name="PD_FC_AMT")
	private Double PD_FC_AMT;

	@Column(name="PD_LC_AMT")
	private Double PD_LC_AMT;

	@Column(name="PD_PAID_FOR")
	private String PD_PAID_FOR;

	@Column(name="PD_CHQ_NO")
	private String PD_CHQ_NO;

	@Column(name="PD_CHQ_DT")
	private Date PD_CHQ_DT;

	@Column(name="PD_DPD_REF_ID")
	private String PD_DPD_REF_ID;

	@Column(name="PD_CR_ADVICE_NO")
	private String PD_CR_ADVICE_NO;

	@Column(name="PD_PAYIN_DATE")
	private Date PD_PAYIN_DATE;

	@Column(name="PD_BANK_NAME")
	private String PD_BANK_NAME;

	private String UI_M_BANK_NAME_DESC;

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

//  The below code is hard coded for customization
	@Column(name="PD_CR_DT")
	private Date PD_CR_DT;

	@Column(name="PD_CR_UID")
	private String PD_CR_UID;


	public Double getPD_SR_NO() {
		return PD_SR_NO;
	}

	public void setPD_SR_NO(Double PD_SR_NO) {
		this.PD_SR_NO = PD_SR_NO;
	}

	public String getPD_PAY_MODE() {
		return PD_PAY_MODE;
	}

	public void setPD_PAY_MODE(String PD_PAY_MODE) {
		this.PD_PAY_MODE = PD_PAY_MODE;
	}

	public Double getPD_FC_AMT() {
		return PD_FC_AMT;
	}

	public void setPD_FC_AMT(Double PD_FC_AMT) {
		this.PD_FC_AMT = PD_FC_AMT;
	}

	public Double getPD_LC_AMT() {
		return PD_LC_AMT;
	}

	public void setPD_LC_AMT(Double PD_LC_AMT) {
		this.PD_LC_AMT = PD_LC_AMT;
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

	public String getPD_DPD_REF_ID() {
		return PD_DPD_REF_ID;
	}

	public void setPD_DPD_REF_ID(String PD_DPD_REF_ID) {
		this.PD_DPD_REF_ID = PD_DPD_REF_ID;
	}

	public String getPD_CR_ADVICE_NO() {
		return PD_CR_ADVICE_NO;
	}

	public void setPD_CR_ADVICE_NO(String PD_CR_ADVICE_NO) {
		this.PD_CR_ADVICE_NO = PD_CR_ADVICE_NO;
	}

	public Date getPD_PAYIN_DATE() {
		 return PD_PAYIN_DATE;
	}

	public void setPD_PAYIN_DATE(Date PD_PAYIN_DATE) {
		this.PD_PAYIN_DATE = PD_PAYIN_DATE;
	}

	public String getPD_BANK_NAME() {
		return PD_BANK_NAME;
	}

	public void setPD_BANK_NAME(String PD_BANK_NAME) {
		this.PD_BANK_NAME = PD_BANK_NAME;
	}

	public String getUI_M_BANK_NAME_DESC() {
		return UI_M_BANK_NAME_DESC;
	}

	public void setUI_M_BANK_NAME_DESC(String UI_M_BANK_NAME_DESC) {
		this.UI_M_BANK_NAME_DESC = UI_M_BANK_NAME_DESC;
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

	public Date getPD_CR_DT() {
		return PD_CR_DT;
	}

	public void setPD_CR_DT(Date pd_cr_dt) {
		PD_CR_DT = pd_cr_dt;
	}

	public String getPD_CR_UID() {
		return PD_CR_UID;
	}

	public void setPD_CR_UID(String pd_cr_uid) {
		PD_CR_UID = pd_cr_uid;
	}
}
