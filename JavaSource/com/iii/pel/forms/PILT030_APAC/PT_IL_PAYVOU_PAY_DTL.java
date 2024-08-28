package com.iii.pel.forms.PILT030_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_PAYVOU_PAY_DTL")
public class PT_IL_PAYVOU_PAY_DTL extends BaseValueBean {
	
	private boolean selected;

	@Column(name="PAPD_PAY_MODE")
	private String PAPD_PAY_MODE;

	@Column(name="PAPD_CUST_CODE")
	private String PAPD_CUST_CODE;

	@Column(name="PAPD_ATTENTION_TO")
	private String PAPD_ATTENTION_TO;

	@Column(name="PAPD_PAYEE_ADDR1")
	private String PAPD_PAYEE_ADDR1;

	@Column(name="PAPD_PAYEE_ADDR2")
	private String PAPD_PAYEE_ADDR2;

	@Column(name="PAPD_PAYEE_ADDR3")
	private String PAPD_PAYEE_ADDR3;

	@Column(name="PAPD_OFF_AREA_CODE")
	private String PAPD_OFF_AREA_CODE;

	@Column(name="PAPD_CITY_CODE")
	private String PAPD_CITY_CODE;

	@Column(name="PAPD_STATE_CODE")
	private String PAPD_STATE_CODE;

	@Column(name="PAPD_BANK_CODE")
	private String PAPD_BANK_CODE;

	@Column(name="PAPD_CLE_ZONE_CODE")
	private String PAPD_CLE_ZONE_CODE;

	@Column(name="PAPD_DES_MTD_CODE")
	private String PAPD_DES_MTD_CODE;

	@Column(name="PAPD_CHQ_ISSUE_USER_ID")
	private String PAPD_CHQ_ISSUE_USER_ID;

	@Column(name="PAPD_FC_PAY_AMT")
	private Double PAPD_FC_PAY_AMT;

	private String UI_M_POSTAL_DESC;

	private String UI_M_CITY_DESC;

	private String UI_M_STATE_DESC;

	private String UI_M_BANK_DESC;

	private String UI_M_PAPD_CLE_ZONE_DESC;

	private String UI_M_PAPD_DES_MTD_DESC;

	private String UI_M_PAPD_CUST_DESC;

	@Column(name="PAPD_LC_PAY_AMT")
	private Double PAPD_LC_PAY_AMT;

	@Column(name="PAPD_PAYEE_NAME")
	private String PAPD_PAYEE_NAME;

	@Column(name="PAPD_MAIN_ACNT_CODE")
	private String PAPD_MAIN_ACNT_CODE;

	@Column(name="PAPD_SUB_ACNT_CODE")
	private String PAPD_SUB_ACNT_CODE;
	
	private boolean PAPD_SUB_ACNT_CODE_INSERT;
	
	private boolean PAPD_SUB_ACNT_CODE_REQUIRED;

	@Column(name="PAPD_ANLY_CODE_1")
	private String PAPD_ANLY_CODE_1;

	@Column(name="PAPD_ANLY_CODE_2")
	private String PAPD_ANLY_CODE_2;

	@Column(name="PAPD_PAYEE_ANLY_CODE_1")
	private String PAPD_PAYEE_ANLY_CODE_1;

	@Column(name="PAPD_PAYEE_ANLY_CODE_2")
	private String PAPD_PAYEE_ANLY_CODE_2;

	@Column(name="PAPD_ACTY_CODE_1")
	private String PAPD_ACTY_CODE_1;

	@Column(name="PAPD_ACTY_CODE_2")
	private String PAPD_ACTY_CODE_2;

	@Column(name="PAPD_NARRATION")
	private String PAPD_NARRATION;

	private String PAPD_CHQ_APPR_USER_ID;

	@Column(name="PAPD_CURR_CODE")
	private String PAPD_CURR_CODE;

	@Column(name="PAPD_BANK_ACC_NO")
	private String PAPD_BANK_ACC_NO;

	private String UI_M_MAIN_ACNT_CODE_DESC;

	private String UI_M_SUB_ACNT_DESC;

	private String UI_M_ANLY_DESC1;

	private String UI_M_ANLY_DESC2;

	private String UI_M_PAYEE_ANLY_DESC1;

	private String UI_M_PAYEE_ANLY_DESC2;

	private String UI_M_ACTY_DESC1;

	private String UI_M_ACTY_DESC2;

	@Column(name="PAPD_PAY_APPRV_CODE")
	private String PAPD_PAY_APPRV_CODE;

	@Column(name="PAPD_CHQ_DT")
	private Date PAPD_CHQ_DT;

	@Column(name="PAPD_DOC_NO")
	private Double PAPD_DOC_NO;
	
	@Column(name="PAPD_DOC_DT")
	private Date PAPD_DOC_DT;
	
	@Column(name="PAPD_TXN_CODE")
	private String PAPD_TXN_CODE;
	
	@Column(name="PAPD_SYS_ID")
	private Double PAPD_SYS_ID;
	
	@Column(name="PAPD_PAH_SYS_ID")
	private Double PAPD_PAH_SYS_ID;
	
	@Column(name="PAPD_PAD_SYS_ID")
	private Double PAPD_PAD_SYS_ID;
	
	@Column(name="PAPD_ACNT_YEAR")
	private Double PAPD_ACNT_YEAR;
	
	private Double UI_M_TOT_PAPD_FC_PAY_AMT;
	
	@Column(name="PAPD_CR_UID")
	private String PAPD_CR_UID;
	
	@Column(name="PAPD_CR_DT")
	private Date PAPD_CR_DT;
	
	private boolean PAPD_PAYEE_ADDR1_REQUIRED;
	
	private boolean PAPD_OFF_AREA_CODE_REQUIRED;
	
	private boolean PAPD_BANK_ACC_NO_REQUIRED;
	
	private boolean PAPD_BANK_CODE_REQUIRED;
	
	private boolean PAPD_PAY_APPRV_CODE_DISABLED;
	
	private boolean PAPD_PAY_APPRV_CODE_REQUIRED;
	
	
	private boolean PAPD_CLE_ZONE_CODE_REQUIRED;
	
	private boolean PAPD_DES_MTD_CODE_REQUIRED;
	
	private boolean PAPD_STATE_CODE_REQUIRED; 
	
	public String getPAPD_CR_UID() {
		return PAPD_CR_UID;
	}

	public boolean isPAPD_OFF_AREA_CODE_REQUIRED() {
		return PAPD_OFF_AREA_CODE_REQUIRED;
	}

	public void setPAPD_OFF_AREA_CODE_REQUIRED(boolean papd_off_area_code_required) {
		PAPD_OFF_AREA_CODE_REQUIRED = papd_off_area_code_required;
	}

	public boolean isPAPD_STATE_CODE_REQUIRED() {
		return PAPD_STATE_CODE_REQUIRED;
	}

	public void setPAPD_STATE_CODE_REQUIRED(boolean papd_state_code_required) {
		PAPD_STATE_CODE_REQUIRED = papd_state_code_required;
	}

	public void setPAPD_CR_UID(String papd_cr_uid) {
		PAPD_CR_UID = papd_cr_uid;
	}

	public Date getPAPD_CR_DT() {
		return PAPD_CR_DT;
	}

	public void setPAPD_CR_DT(Date papd_cr_dt) {
		PAPD_CR_DT = papd_cr_dt;
	}

	public Double getUI_M_TOT_PAPD_FC_PAY_AMT() {
		return UI_M_TOT_PAPD_FC_PAY_AMT;
	}

	public void setUI_M_TOT_PAPD_FC_PAY_AMT(Double ui_m_tot_papd_fc_pay_amt) {
		UI_M_TOT_PAPD_FC_PAY_AMT = ui_m_tot_papd_fc_pay_amt;
	}

	public Double getPAPD_DOC_NO() {
		return PAPD_DOC_NO;
	}

	public void setPAPD_DOC_NO(Double papd_doc_no) {
		PAPD_DOC_NO = papd_doc_no;
	}

	public Date getPAPD_DOC_DT() {
		return PAPD_DOC_DT;
	}

	public void setPAPD_DOC_DT(Date papd_doc_dt) {
		PAPD_DOC_DT = papd_doc_dt;
	}

	public String getPAPD_TXN_CODE() {
		return PAPD_TXN_CODE;
	}

	public void setPAPD_TXN_CODE(String papd_txn_code) {
		PAPD_TXN_CODE = papd_txn_code;
	}

	public String getPAPD_PAY_MODE() {
		return PAPD_PAY_MODE;
	}

	public void setPAPD_PAY_MODE(String PAPD_PAY_MODE) {
		this.PAPD_PAY_MODE = PAPD_PAY_MODE;
	}

	public String getPAPD_CUST_CODE() {
		return PAPD_CUST_CODE;
	}

	public void setPAPD_CUST_CODE(String PAPD_CUST_CODE) {
		this.PAPD_CUST_CODE = PAPD_CUST_CODE;
	}

	public String getPAPD_ATTENTION_TO() {
		return PAPD_ATTENTION_TO;
	}

	public void setPAPD_ATTENTION_TO(String PAPD_ATTENTION_TO) {
		this.PAPD_ATTENTION_TO = PAPD_ATTENTION_TO;
	}

	public String getPAPD_PAYEE_ADDR1() {
		return PAPD_PAYEE_ADDR1;
	}

	public void setPAPD_PAYEE_ADDR1(String PAPD_PAYEE_ADDR1) {
		this.PAPD_PAYEE_ADDR1 = PAPD_PAYEE_ADDR1;
	}

	public String getPAPD_PAYEE_ADDR2() {
		return PAPD_PAYEE_ADDR2;
	}

	public void setPAPD_PAYEE_ADDR2(String PAPD_PAYEE_ADDR2) {
		this.PAPD_PAYEE_ADDR2 = PAPD_PAYEE_ADDR2;
	}

	public String getPAPD_PAYEE_ADDR3() {
		return PAPD_PAYEE_ADDR3;
	}

	public void setPAPD_PAYEE_ADDR3(String PAPD_PAYEE_ADDR3) {
		this.PAPD_PAYEE_ADDR3 = PAPD_PAYEE_ADDR3;
	}

	public String getPAPD_OFF_AREA_CODE() {
		return PAPD_OFF_AREA_CODE;
	}

	public void setPAPD_OFF_AREA_CODE(String PAPD_OFF_AREA_CODE) {
		this.PAPD_OFF_AREA_CODE = PAPD_OFF_AREA_CODE;
	}

	public String getPAPD_CITY_CODE() {
		return PAPD_CITY_CODE;
	}

	public void setPAPD_CITY_CODE(String PAPD_CITY_CODE) {
		this.PAPD_CITY_CODE = PAPD_CITY_CODE;
	}

	public String getPAPD_STATE_CODE() {
		return PAPD_STATE_CODE;
	}

	public void setPAPD_STATE_CODE(String PAPD_STATE_CODE) {
		this.PAPD_STATE_CODE = PAPD_STATE_CODE;
	}

	public String getPAPD_BANK_CODE() {
		return PAPD_BANK_CODE;
	}

	public void setPAPD_BANK_CODE(String PAPD_BANK_CODE) {
		this.PAPD_BANK_CODE = PAPD_BANK_CODE;
	}

	public String getPAPD_CLE_ZONE_CODE() {
		return PAPD_CLE_ZONE_CODE;
	}

	public void setPAPD_CLE_ZONE_CODE(String PAPD_CLE_ZONE_CODE) {
		this.PAPD_CLE_ZONE_CODE = PAPD_CLE_ZONE_CODE;
	}

	public String getPAPD_DES_MTD_CODE() {
		return PAPD_DES_MTD_CODE;
	}

	public void setPAPD_DES_MTD_CODE(String PAPD_DES_MTD_CODE) {
		this.PAPD_DES_MTD_CODE = PAPD_DES_MTD_CODE;
	}

	public String getPAPD_CHQ_ISSUE_USER_ID() {
		return PAPD_CHQ_ISSUE_USER_ID;
	}

	public void setPAPD_CHQ_ISSUE_USER_ID(String PAPD_CHQ_ISSUE_USER_ID) {
		this.PAPD_CHQ_ISSUE_USER_ID = PAPD_CHQ_ISSUE_USER_ID;
	}

	public Double getPAPD_FC_PAY_AMT() {
		return PAPD_FC_PAY_AMT;
	}

	public void setPAPD_FC_PAY_AMT(Double PAPD_FC_PAY_AMT) {
		this.PAPD_FC_PAY_AMT = PAPD_FC_PAY_AMT;
	}

	public String getUI_M_POSTAL_DESC() {
		return UI_M_POSTAL_DESC;
	}

	public void setUI_M_POSTAL_DESC(String UI_M_POSTAL_DESC) {
		this.UI_M_POSTAL_DESC = UI_M_POSTAL_DESC;
	}

	public String getUI_M_CITY_DESC() {
		return UI_M_CITY_DESC;
	}

	public void setUI_M_CITY_DESC(String UI_M_CITY_DESC) {
		this.UI_M_CITY_DESC = UI_M_CITY_DESC;
	}

	public String getUI_M_STATE_DESC() {
		return UI_M_STATE_DESC;
	}

	public void setUI_M_STATE_DESC(String UI_M_STATE_DESC) {
		this.UI_M_STATE_DESC = UI_M_STATE_DESC;
	}

	public String getUI_M_BANK_DESC() {
		return UI_M_BANK_DESC;
	}

	public void setUI_M_BANK_DESC(String UI_M_BANK_DESC) {
		this.UI_M_BANK_DESC = UI_M_BANK_DESC;
	}

	public String getUI_M_PAPD_CLE_ZONE_DESC() {
		return UI_M_PAPD_CLE_ZONE_DESC;
	}

	public void setUI_M_PAPD_CLE_ZONE_DESC(String UI_M_PAPD_CLE_ZONE_DESC) {
		this.UI_M_PAPD_CLE_ZONE_DESC = UI_M_PAPD_CLE_ZONE_DESC;
	}

	public String getUI_M_PAPD_DES_MTD_DESC() {
		return UI_M_PAPD_DES_MTD_DESC;
	}

	public void setUI_M_PAPD_DES_MTD_DESC(String UI_M_PAPD_DES_MTD_DESC) {
		this.UI_M_PAPD_DES_MTD_DESC = UI_M_PAPD_DES_MTD_DESC;
	}

	public String getUI_M_PAPD_CUST_DESC() {
		return UI_M_PAPD_CUST_DESC;
	}

	public void setUI_M_PAPD_CUST_DESC(String UI_M_PAPD_CUST_DESC) {
		this.UI_M_PAPD_CUST_DESC = UI_M_PAPD_CUST_DESC;
	}

	public Double getPAPD_LC_PAY_AMT() {
		return PAPD_LC_PAY_AMT;
	}

	public void setPAPD_LC_PAY_AMT(Double PAPD_LC_PAY_AMT) {
		this.PAPD_LC_PAY_AMT = PAPD_LC_PAY_AMT;
	}

	public String getPAPD_PAYEE_NAME() {
		return PAPD_PAYEE_NAME;
	}

	public void setPAPD_PAYEE_NAME(String PAPD_PAYEE_NAME) {
		this.PAPD_PAYEE_NAME = PAPD_PAYEE_NAME;
	}

	public String getPAPD_MAIN_ACNT_CODE() {
		return PAPD_MAIN_ACNT_CODE;
	}

	public void setPAPD_MAIN_ACNT_CODE(String PAPD_MAIN_ACNT_CODE) {
		this.PAPD_MAIN_ACNT_CODE = PAPD_MAIN_ACNT_CODE;
	}

	public String getPAPD_SUB_ACNT_CODE() {
		return PAPD_SUB_ACNT_CODE;
	}

	public void setPAPD_SUB_ACNT_CODE(String PAPD_SUB_ACNT_CODE) {
		this.PAPD_SUB_ACNT_CODE = PAPD_SUB_ACNT_CODE;
	}

	public String getPAPD_ANLY_CODE_1() {
		return PAPD_ANLY_CODE_1;
	}

	public void setPAPD_ANLY_CODE_1(String PAPD_ANLY_CODE_1) {
		this.PAPD_ANLY_CODE_1 = PAPD_ANLY_CODE_1;
	}

	public String getPAPD_ANLY_CODE_2() {
		return PAPD_ANLY_CODE_2;
	}

	public void setPAPD_ANLY_CODE_2(String PAPD_ANLY_CODE_2) {
		this.PAPD_ANLY_CODE_2 = PAPD_ANLY_CODE_2;
	}

	public String getPAPD_PAYEE_ANLY_CODE_1() {
		return PAPD_PAYEE_ANLY_CODE_1;
	}

	public void setPAPD_PAYEE_ANLY_CODE_1(String PAPD_PAYEE_ANLY_CODE_1) {
		this.PAPD_PAYEE_ANLY_CODE_1 = PAPD_PAYEE_ANLY_CODE_1;
	}

	public String getPAPD_PAYEE_ANLY_CODE_2() {
		return PAPD_PAYEE_ANLY_CODE_2;
	}

	public void setPAPD_PAYEE_ANLY_CODE_2(String PAPD_PAYEE_ANLY_CODE_2) {
		this.PAPD_PAYEE_ANLY_CODE_2 = PAPD_PAYEE_ANLY_CODE_2;
	}

	public String getPAPD_ACTY_CODE_1() {
		return PAPD_ACTY_CODE_1;
	}

	public void setPAPD_ACTY_CODE_1(String PAPD_ACTY_CODE_1) {
		this.PAPD_ACTY_CODE_1 = PAPD_ACTY_CODE_1;
	}

	public String getPAPD_ACTY_CODE_2() {
		return PAPD_ACTY_CODE_2;
	}

	public void setPAPD_ACTY_CODE_2(String PAPD_ACTY_CODE_2) {
		this.PAPD_ACTY_CODE_2 = PAPD_ACTY_CODE_2;
	}

	public String getPAPD_NARRATION() {
		return PAPD_NARRATION;
	}

	public void setPAPD_NARRATION(String PAPD_NARRATION) {
		this.PAPD_NARRATION = PAPD_NARRATION;
	}

	public String getPAPD_CHQ_APPR_USER_ID() {
		return PAPD_CHQ_APPR_USER_ID;
	}

	public void setPAPD_CHQ_APPR_USER_ID(String PAPD_CHQ_APPR_USER_ID) {
		this.PAPD_CHQ_APPR_USER_ID = PAPD_CHQ_APPR_USER_ID;
	}

	public String getPAPD_CURR_CODE() {
		return PAPD_CURR_CODE;
	}

	public void setPAPD_CURR_CODE(String PAPD_CURR_CODE) {
		this.PAPD_CURR_CODE = PAPD_CURR_CODE;
	}

	public String getPAPD_BANK_ACC_NO() {
		return PAPD_BANK_ACC_NO;
	}

	public void setPAPD_BANK_ACC_NO(String PAPD_BANK_ACC_NO) {
		this.PAPD_BANK_ACC_NO = PAPD_BANK_ACC_NO;
	}

	public String getUI_M_MAIN_ACNT_CODE_DESC() {
		return UI_M_MAIN_ACNT_CODE_DESC;
	}

	public void setUI_M_MAIN_ACNT_CODE_DESC(String UI_M_MAIN_ACNT_CODE_DESC) {
		this.UI_M_MAIN_ACNT_CODE_DESC = UI_M_MAIN_ACNT_CODE_DESC;
	}

	public String getUI_M_SUB_ACNT_DESC() {
		return UI_M_SUB_ACNT_DESC;
	}

	public void setUI_M_SUB_ACNT_DESC(String UI_M_SUB_ACNT_DESC) {
		this.UI_M_SUB_ACNT_DESC = UI_M_SUB_ACNT_DESC;
	}

	public String getUI_M_ANLY_DESC1() {
		return UI_M_ANLY_DESC1;
	}

	public void setUI_M_ANLY_DESC1(String UI_M_ANLY_DESC1) {
		this.UI_M_ANLY_DESC1 = UI_M_ANLY_DESC1;
	}

	public String getUI_M_ANLY_DESC2() {
		return UI_M_ANLY_DESC2;
	}

	public void setUI_M_ANLY_DESC2(String UI_M_ANLY_DESC2) {
		this.UI_M_ANLY_DESC2 = UI_M_ANLY_DESC2;
	}

	public String getUI_M_PAYEE_ANLY_DESC1() {
		return UI_M_PAYEE_ANLY_DESC1;
	}

	public void setUI_M_PAYEE_ANLY_DESC1(String UI_M_PAYEE_ANLY_DESC1) {
		this.UI_M_PAYEE_ANLY_DESC1 = UI_M_PAYEE_ANLY_DESC1;
	}

	public String getUI_M_PAYEE_ANLY_DESC2() {
		return UI_M_PAYEE_ANLY_DESC2;
	}

	public void setUI_M_PAYEE_ANLY_DESC2(String UI_M_PAYEE_ANLY_DESC2) {
		this.UI_M_PAYEE_ANLY_DESC2 = UI_M_PAYEE_ANLY_DESC2;
	}

	public String getUI_M_ACTY_DESC1() {
		return UI_M_ACTY_DESC1;
	}

	public void setUI_M_ACTY_DESC1(String UI_M_ACTY_DESC1) {
		this.UI_M_ACTY_DESC1 = UI_M_ACTY_DESC1;
	}

	public String getUI_M_ACTY_DESC2() {
		return UI_M_ACTY_DESC2;
	}

	public void setUI_M_ACTY_DESC2(String UI_M_ACTY_DESC2) {
		this.UI_M_ACTY_DESC2 = UI_M_ACTY_DESC2;
	}

	public String getPAPD_PAY_APPRV_CODE() {
		return PAPD_PAY_APPRV_CODE;
	}

	public void setPAPD_PAY_APPRV_CODE(String PAPD_PAY_APPRV_CODE) {
		this.PAPD_PAY_APPRV_CODE = PAPD_PAY_APPRV_CODE;
	}

	public Date getPAPD_CHQ_DT() {
		 return PAPD_CHQ_DT;
	}

	public void setPAPD_CHQ_DT(Date PAPD_CHQ_DT) {
		this.PAPD_CHQ_DT = PAPD_CHQ_DT;
	}

	public Double getPAPD_SYS_ID() {
		return PAPD_SYS_ID;
	}

	public void setPAPD_SYS_ID(Double papd_sys_id) {
		PAPD_SYS_ID = papd_sys_id;
	}

	public Double getPAPD_PAH_SYS_ID() {
		return PAPD_PAH_SYS_ID;
	}

	public void setPAPD_PAH_SYS_ID(Double papd_pah_sys_id) {
		PAPD_PAH_SYS_ID = papd_pah_sys_id;
	}

	public Double getPAPD_PAD_SYS_ID() {
		return PAPD_PAD_SYS_ID;
	}

	public void setPAPD_PAD_SYS_ID(Double papd_pad_sys_id) {
		PAPD_PAD_SYS_ID = papd_pad_sys_id;
	}

	public Double getPAPD_ACNT_YEAR() {
		return PAPD_ACNT_YEAR;
	}

	public void setPAPD_ACNT_YEAR(Double papd_acnt_year) {
		PAPD_ACNT_YEAR = papd_acnt_year;
	}

	public boolean isPAPD_PAYEE_ADDR1_REQUIRED() {
		return PAPD_PAYEE_ADDR1_REQUIRED;
	}

	public void setPAPD_PAYEE_ADDR1_REQUIRED(boolean papd_payee_addr1_required) {
		PAPD_PAYEE_ADDR1_REQUIRED = papd_payee_addr1_required;
	}

	public boolean isPAPD_BANK_ACC_NO_REQUIRED() {
		return PAPD_BANK_ACC_NO_REQUIRED;
	}

	public void setPAPD_BANK_ACC_NO_REQUIRED(boolean papd_bank_acc_no_required) {
		PAPD_BANK_ACC_NO_REQUIRED = papd_bank_acc_no_required;
	}

	public boolean isPAPD_BANK_CODE_REQUIRED() {
		return PAPD_BANK_CODE_REQUIRED;
	}

	public void setPAPD_BANK_CODE_REQUIRED(boolean papd_bank_code_required) {
		PAPD_BANK_CODE_REQUIRED = papd_bank_code_required;
	}

	public boolean isPAPD_PAY_APPRV_CODE_DISABLED() {
		return PAPD_PAY_APPRV_CODE_DISABLED;
	}

	public void setPAPD_PAY_APPRV_CODE_DISABLED(boolean papd_pay_apprv_code_disabled) {
		PAPD_PAY_APPRV_CODE_DISABLED = papd_pay_apprv_code_disabled;
	}

	public boolean isPAPD_CLE_ZONE_CODE_REQUIRED() {
		return PAPD_CLE_ZONE_CODE_REQUIRED;
	}

	public void setPAPD_CLE_ZONE_CODE_REQUIRED(boolean papd_cle_zone_code_required) {
		PAPD_CLE_ZONE_CODE_REQUIRED = papd_cle_zone_code_required;
	}

	public boolean isPAPD_DES_MTD_CODE_REQUIRED() {
		return PAPD_DES_MTD_CODE_REQUIRED;
	}

	public void setPAPD_DES_MTD_CODE_REQUIRED(boolean papd_des_mtd_code_required) {
		PAPD_DES_MTD_CODE_REQUIRED = papd_des_mtd_code_required;
	}

	public boolean isPAPD_PAY_APPRV_CODE_REQUIRED() {
		return PAPD_PAY_APPRV_CODE_REQUIRED;
	}

	public void setPAPD_PAY_APPRV_CODE_REQUIRED(boolean papd_pay_apprv_code_required) {
		PAPD_PAY_APPRV_CODE_REQUIRED = papd_pay_apprv_code_required;
	}

	public boolean isPAPD_SUB_ACNT_CODE_INSERT() {
		return PAPD_SUB_ACNT_CODE_INSERT;
	}

	public void setPAPD_SUB_ACNT_CODE_INSERT(boolean papd_sub_acnt_code_insert) {
		PAPD_SUB_ACNT_CODE_INSERT = papd_sub_acnt_code_insert;
	}

	public boolean isPAPD_SUB_ACNT_CODE_REQUIRED() {
		return PAPD_SUB_ACNT_CODE_REQUIRED;
	}

	public void setPAPD_SUB_ACNT_CODE_REQUIRED(boolean papd_sub_acnt_code_required) {
		PAPD_SUB_ACNT_CODE_REQUIRED = papd_sub_acnt_code_required;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
