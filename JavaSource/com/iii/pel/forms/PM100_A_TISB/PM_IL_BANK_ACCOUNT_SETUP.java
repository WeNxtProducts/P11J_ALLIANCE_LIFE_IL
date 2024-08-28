package com.iii.pel.forms.PM100_A_TISB;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name="PM_IL_BANK_ACCOUNT_SETUP")
public class PM_IL_BANK_ACCOUNT_SETUP {

	@Column(name="BAS_DIVN_FM_CODE")
	private String BAS_DIVN_FM_CODE;

	@Column(name="BAS_DIVN_TO_CODE")
	private String BAS_DIVN_TO_CODE;

	@Column(name="BAS_DEPT_FM_CODE")
	private String BAS_DEPT_FM_CODE;

	@Column(name="BAS_DEPT_TO_CODE")
	private String BAS_DEPT_TO_CODE;

	@Column(name="BAS_SETUP_FOR")
	private String BAS_SETUP_FOR;

	@Column(name="BAS_ASSURED_TYPE")
	private String BAS_ASSURED_TYPE;

	@Column(name="BAS_MAX_PAYEE_CHAR")
	private Double BAS_MAX_PAYEE_CHAR;

	@Column(name="BAS_CUST_BANK_CODE")
	private String BAS_CUST_BANK_CODE;

	@Column(name="BAS_OUR_BANK_CODE")
	private String BAS_OUR_BANK_CODE;

	@Column(name="BAS_MAIN_ACNT_CODE")
	private String BAS_MAIN_ACNT_CODE;

	@Column(name="BAS_SUB_ACNT_CODE")
	private String BAS_SUB_ACNT_CODE;

	@Column(name="BAS_VALUE_FROM")
	private Double BAS_VALUE_FROM;

	@Column(name="BAS_DIVN_CODE")
	private String BAS_DIVN_CODE;

	@Column(name="BAS_DEPT_CODE")
	private String BAS_DEPT_CODE;

	@Column(name="BAS_ANLY_CODE_1")
	private String BAS_ANLY_CODE_1;

	@Column(name="BAS_ANLY_CODE_2")
	private String BAS_ANLY_CODE_2;

	@Column(name="BAS_ACTY_CODE_1")
	private String BAS_ACTY_CODE_1;

	@Column(name="BAS_ACTY_CODE_2")
	private String BAS_ACTY_CODE_2;

	private String UI_M_DEPT_FM_DESC;

	private String UI_M_DEPT_TO_DESC;

	private String UI_M_CUST_BANK_DESC;

	private String UI_M_OUR_BANK_DESC;

	private String UI_M_MAIN_ACNT_DESC;

	private String UI_M_SUB_ACNT_DESC;

	private String UI_M_DIVN_DESC;

	private String UI_M_DEPT_DESC;

	private String UI_M_ANLY_1_DESC;

	private String UI_M_ANLY_2_DESC;

	private String UI_M_ACTY_1_DESC;

	private String UI_M_ACTY_2_DESC;

	@Column(name="BAS_VALUE_TO")
	private Double BAS_VALUE_TO;

	@Column(name="BAS_FRZ_FLAG")
	private String BAS_FRZ_FLAG;



	public String getBAS_DIVN_FM_CODE() {
		return BAS_DIVN_FM_CODE;
	}

	public void setBAS_DIVN_FM_CODE(String BAS_DIVN_FM_CODE) {
		this.BAS_DIVN_FM_CODE = BAS_DIVN_FM_CODE;
	}

	public String getBAS_DIVN_TO_CODE() {
		return BAS_DIVN_TO_CODE;
	}

	public void setBAS_DIVN_TO_CODE(String BAS_DIVN_TO_CODE) {
		this.BAS_DIVN_TO_CODE = BAS_DIVN_TO_CODE;
	}

	public String getBAS_DEPT_FM_CODE() {
		return BAS_DEPT_FM_CODE;
	}

	public void setBAS_DEPT_FM_CODE(String BAS_DEPT_FM_CODE) {
		this.BAS_DEPT_FM_CODE = BAS_DEPT_FM_CODE;
	}

	public String getBAS_DEPT_TO_CODE() {
		return BAS_DEPT_TO_CODE;
	}

	public void setBAS_DEPT_TO_CODE(String BAS_DEPT_TO_CODE) {
		this.BAS_DEPT_TO_CODE = BAS_DEPT_TO_CODE;
	}

	public String getBAS_SETUP_FOR() {
		return BAS_SETUP_FOR;
	}

	public void setBAS_SETUP_FOR(String BAS_SETUP_FOR) {
		this.BAS_SETUP_FOR = BAS_SETUP_FOR;
	}

	public String getBAS_ASSURED_TYPE() {
		return BAS_ASSURED_TYPE;
	}

	public void setBAS_ASSURED_TYPE(String BAS_ASSURED_TYPE) {
		this.BAS_ASSURED_TYPE = BAS_ASSURED_TYPE;
	}

	public Double getBAS_MAX_PAYEE_CHAR() {
		return BAS_MAX_PAYEE_CHAR;
	}

	public void setBAS_MAX_PAYEE_CHAR(Double BAS_MAX_PAYEE_CHAR) {
		this.BAS_MAX_PAYEE_CHAR = BAS_MAX_PAYEE_CHAR;
	}

	public String getBAS_CUST_BANK_CODE() {
		return BAS_CUST_BANK_CODE;
	}

	public void setBAS_CUST_BANK_CODE(String BAS_CUST_BANK_CODE) {
		this.BAS_CUST_BANK_CODE = BAS_CUST_BANK_CODE;
	}

	public String getBAS_OUR_BANK_CODE() {
		return BAS_OUR_BANK_CODE;
	}

	public void setBAS_OUR_BANK_CODE(String BAS_OUR_BANK_CODE) {
		this.BAS_OUR_BANK_CODE = BAS_OUR_BANK_CODE;
	}

	public String getBAS_MAIN_ACNT_CODE() {
		return BAS_MAIN_ACNT_CODE;
	}

	public void setBAS_MAIN_ACNT_CODE(String BAS_MAIN_ACNT_CODE) {
		this.BAS_MAIN_ACNT_CODE = BAS_MAIN_ACNT_CODE;
	}

	public String getBAS_SUB_ACNT_CODE() {
		return BAS_SUB_ACNT_CODE;
	}

	public void setBAS_SUB_ACNT_CODE(String BAS_SUB_ACNT_CODE) {
		this.BAS_SUB_ACNT_CODE = BAS_SUB_ACNT_CODE;
	}

	public Double getBAS_VALUE_FROM() {
		return BAS_VALUE_FROM;
	}

	public void setBAS_VALUE_FROM(Double BAS_VALUE_FROM) {
		this.BAS_VALUE_FROM = BAS_VALUE_FROM;
	}

	public String getBAS_DIVN_CODE() {
		return BAS_DIVN_CODE;
	}

	public void setBAS_DIVN_CODE(String BAS_DIVN_CODE) {
		this.BAS_DIVN_CODE = BAS_DIVN_CODE;
	}

	public String getBAS_DEPT_CODE() {
		return BAS_DEPT_CODE;
	}

	public void setBAS_DEPT_CODE(String BAS_DEPT_CODE) {
		this.BAS_DEPT_CODE = BAS_DEPT_CODE;
	}

	public String getBAS_ANLY_CODE_1() {
		return BAS_ANLY_CODE_1;
	}

	public void setBAS_ANLY_CODE_1(String BAS_ANLY_CODE_1) {
		this.BAS_ANLY_CODE_1 = BAS_ANLY_CODE_1;
	}

	public String getBAS_ANLY_CODE_2() {
		return BAS_ANLY_CODE_2;
	}

	public void setBAS_ANLY_CODE_2(String BAS_ANLY_CODE_2) {
		this.BAS_ANLY_CODE_2 = BAS_ANLY_CODE_2;
	}

	public String getBAS_ACTY_CODE_1() {
		return BAS_ACTY_CODE_1;
	}

	public void setBAS_ACTY_CODE_1(String BAS_ACTY_CODE_1) {
		this.BAS_ACTY_CODE_1 = BAS_ACTY_CODE_1;
	}

	public String getBAS_ACTY_CODE_2() {
		return BAS_ACTY_CODE_2;
	}

	public void setBAS_ACTY_CODE_2(String BAS_ACTY_CODE_2) {
		this.BAS_ACTY_CODE_2 = BAS_ACTY_CODE_2;
	}

	public String getUI_M_DEPT_FM_DESC() {
		return UI_M_DEPT_FM_DESC;
	}

	public void setUI_M_DEPT_FM_DESC(String UI_M_DEPT_FM_DESC) {
		this.UI_M_DEPT_FM_DESC = UI_M_DEPT_FM_DESC;
	}

	public String getUI_M_DEPT_TO_DESC() {
		return UI_M_DEPT_TO_DESC;
	}

	public void setUI_M_DEPT_TO_DESC(String UI_M_DEPT_TO_DESC) {
		this.UI_M_DEPT_TO_DESC = UI_M_DEPT_TO_DESC;
	}

	public String getUI_M_CUST_BANK_DESC() {
		return UI_M_CUST_BANK_DESC;
	}

	public void setUI_M_CUST_BANK_DESC(String UI_M_CUST_BANK_DESC) {
		this.UI_M_CUST_BANK_DESC = UI_M_CUST_BANK_DESC;
	}

	public String getUI_M_OUR_BANK_DESC() {
		return UI_M_OUR_BANK_DESC;
	}

	public void setUI_M_OUR_BANK_DESC(String UI_M_OUR_BANK_DESC) {
		this.UI_M_OUR_BANK_DESC = UI_M_OUR_BANK_DESC;
	}

	public String getUI_M_MAIN_ACNT_DESC() {
		return UI_M_MAIN_ACNT_DESC;
	}

	public void setUI_M_MAIN_ACNT_DESC(String UI_M_MAIN_ACNT_DESC) {
		this.UI_M_MAIN_ACNT_DESC = UI_M_MAIN_ACNT_DESC;
	}

	public String getUI_M_SUB_ACNT_DESC() {
		return UI_M_SUB_ACNT_DESC;
	}

	public void setUI_M_SUB_ACNT_DESC(String UI_M_SUB_ACNT_DESC) {
		this.UI_M_SUB_ACNT_DESC = UI_M_SUB_ACNT_DESC;
	}

	public String getUI_M_DIVN_DESC() {
		return UI_M_DIVN_DESC;
	}

	public void setUI_M_DIVN_DESC(String UI_M_DIVN_DESC) {
		this.UI_M_DIVN_DESC = UI_M_DIVN_DESC;
	}

	public String getUI_M_DEPT_DESC() {
		return UI_M_DEPT_DESC;
	}

	public void setUI_M_DEPT_DESC(String UI_M_DEPT_DESC) {
		this.UI_M_DEPT_DESC = UI_M_DEPT_DESC;
	}

	public String getUI_M_ANLY_1_DESC() {
		return UI_M_ANLY_1_DESC;
	}

	public void setUI_M_ANLY_1_DESC(String UI_M_ANLY_1_DESC) {
		this.UI_M_ANLY_1_DESC = UI_M_ANLY_1_DESC;
	}

	public String getUI_M_ANLY_2_DESC() {
		return UI_M_ANLY_2_DESC;
	}

	public void setUI_M_ANLY_2_DESC(String UI_M_ANLY_2_DESC) {
		this.UI_M_ANLY_2_DESC = UI_M_ANLY_2_DESC;
	}

	public String getUI_M_ACTY_1_DESC() {
		return UI_M_ACTY_1_DESC;
	}

	public void setUI_M_ACTY_1_DESC(String UI_M_ACTY_1_DESC) {
		this.UI_M_ACTY_1_DESC = UI_M_ACTY_1_DESC;
	}

	public String getUI_M_ACTY_2_DESC() {
		return UI_M_ACTY_2_DESC;
	}

	public void setUI_M_ACTY_2_DESC(String UI_M_ACTY_2_DESC) {
		this.UI_M_ACTY_2_DESC = UI_M_ACTY_2_DESC;
	}

	public Double getBAS_VALUE_TO() {
		return BAS_VALUE_TO;
	}

	public void setBAS_VALUE_TO(Double BAS_VALUE_TO) {
		this.BAS_VALUE_TO = BAS_VALUE_TO;
	}

	public String getBAS_FRZ_FLAG() {
		return BAS_FRZ_FLAG;
	}

	public void setBAS_FRZ_FLAG(String BAS_FRZ_FLAG) {
		this.BAS_FRZ_FLAG = BAS_FRZ_FLAG;
	}
}
