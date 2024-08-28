package com.iii.pel.forms.PILQ116_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_PAYVOU_PAY_DTL")
public class PT_IL_PAYVOU_PAY_DTL extends BaseValueBean {

	@Column(name = "PAPD_SYS_ID")
	private Long PAPD_SYS_ID;

	@Column(name = "PAPD_PAH_SYS_ID")
	private Long PAPD_PAH_SYS_ID;

	@Column(name = "PAPD_PAD_SYS_ID")
	private Long PAPD_PAD_SYS_ID;

	@Column(name = "PAPD_CUST_CODE")
	private String PAPD_CUST_CODE;

	@Column(name = "PAPD_PAY_MODE")
	private String PAPD_PAY_MODE;

	@Column(name = "PAPD_PAYEE_NAME")
	private String PAPD_PAYEE_NAME;

	@Column(name = "PAPD_PAYEE_ADDR1")
	private String PAPD_PAYEE_ADDR1;

	@Column(name = "PAPD_PAYEE_ADDR2")
	private String PAPD_PAYEE_ADDR2;

	@Column(name = "PAPD_PAYEE_ADDR3")
	private String PAPD_PAYEE_ADDR3;

	@Column(name = "PAPD_CURR_CODE")
	private String PAPD_CURR_CODE;

	@Column(name = "PAPD_FC_PAY_AMT")
	private Double PAPD_FC_PAY_AMT;

	@Column(name = "PAPD_LC_PAY_AMT")
	private Double PAPD_LC_PAY_AMT;

	@Column(name = "PAPD_BANK_CODE")
	private String PAPD_BANK_CODE;

	@Column(name = "PAPD_BANK_ACC_NO")
	private String PAPD_BANK_ACC_NO;

	@Column(name = "PAPD_CLE_ZONE_CODE")
	private String PAPD_CLE_ZONE_CODE;

	@Column(name = "PAPD_DES_MTD_CODE")
	private String PAPD_DES_MTD_CODE;

	@Column(name = "PAPD_MAIN_ACNT_CODE")
	private String PAPD_MAIN_ACNT_CODE;

	@Column(name = "PAPD_SUB_ACNT_CODE")
	private String PAPD_SUB_ACNT_CODE;

	@Column(name = "PAPD_ANLY_CODE_1")
	private String PAPD_ANLY_CODE_1;

	@Column(name = "PAPD_ANLY_CODE_2")
	private String PAPD_ANLY_CODE_2;

	@Column(name = "PAPD_ACTY_CODE_1")
	private String PAPD_ACTY_CODE_1;

	@Column(name = "PAPD_ACTY_CODE_2")
	private String PAPD_ACTY_CODE_2;

	@Column(name = "PAPD_TXN_CODE")
	private String PAPD_TXN_CODE;

	@Column(name = "PAPD_DOC_NO")
	private Double PAPD_DOC_NO;

	@Column(name = "PAPD_DOC_DT")
	private Date PAPD_DOC_DT;

	@Column(name = "PAPD_ACNT_YEAR")
	private Double PAPD_ACNT_YEAR;

	@Column(name = "PAPD_CR_DT")
	private Date PAPD_CR_DT;

	@Column(name = "PAPD_CR_UID")
	private String PAPD_CR_UID;

	@Column(name = "PAPD_UPD_DT")
	private Date PAPD_UPD_DT;

	@Column(name = "PAPD_UPD_UID")
	private String PAPD_UPD_UID;

	@Column(name = "PAPD_PAYEE_ANLY_CODE_1")
	private String PAPD_PAYEE_ANLY_CODE_1;

	@Column(name = "PAPD_PAYEE_ANLY_CODE_2")
	private String PAPD_PAYEE_ANLY_CODE_2;

	@Column(name = "PAPD_NARRATION")
	private String PAPD_NARRATION;

	@Column(name = "PAPD_PAY_APPRV_CODE")
	private String PAPD_PAY_APPRV_CODE;

	@Column(name = "PAPD_CITY_CODE")
	private String PAPD_CITY_CODE;

	@Column(name = "PAPD_STATE_CODE")
	private String PAPD_STATE_CODE;

	@Column(name = "PAPD_OFF_AREA_CODE")
	private String PAPD_OFF_AREA_CODE;

	@Column(name = "PAPD_CHQ_ISSUE_USER_ID")
	private String PAPD_CHQ_ISSUE_USER_ID;

	@Column(name = "PAPD_CHQ_APPR_USER_ID")
	private String PAPD_CHQ_APPR_USER_ID;

	@Column(name = "PAPD_ATTENTION_TO")
	private String PAPD_ATTENTION_TO;

	@Column(name = "PAPD_CHQ_DT")
	private Date PAPD_CHQ_DT;

	@Column(name = "PAPD_CUST_BANK_NAME")
	private String PAPD_CUST_BANK_NAME;

	@Column(name = "PAPD_CUST_BANK_ACC_NO")
	private String PAPD_CUST_BANK_ACC_NO;

	@Column(name = "PAPD_CUST_BANK_CODE")
	private String PAPD_CUST_BANK_CODE;

	@Column(name = "PAPD_CUST_BANK_REF_NO")
	private String PAPD_CUST_BANK_REF_NO;

	@Column(name = "PAPD_SWIFT_CODE")
	private String PAPD_SWIFT_CODE;

	@Column(name = "PAPD_DRAFT_DT")
	private Date PAPD_DRAFT_DT;

	@Column(name = "PAPD_PSD_SYS_ID")
	private Long PAPD_PSD_SYS_ID;

	public void setPAPD_PAYEE_ANLY_CODE_1(String PAPD_PAYEE_ANLY_CODE_1) {
		this.PAPD_PAYEE_ANLY_CODE_1 = PAPD_PAYEE_ANLY_CODE_1;
	}

	public String getPAPD_PAYEE_ANLY_CODE_1() {
		return PAPD_PAYEE_ANLY_CODE_1;
	}

	public void setPAPD_UPD_DT(Date PAPD_UPD_DT) {
		this.PAPD_UPD_DT = PAPD_UPD_DT;
	}

	public Date getPAPD_UPD_DT() {
		return PAPD_UPD_DT;
	}

	public void setPAPD_CR_DT(Date PAPD_CR_DT) {
		this.PAPD_CR_DT = PAPD_CR_DT;
	}

	public Date getPAPD_CR_DT() {
		return PAPD_CR_DT;
	}

	public void setPAPD_PAYEE_NAME(String PAPD_PAYEE_NAME) {
		this.PAPD_PAYEE_NAME = PAPD_PAYEE_NAME;
	}

	public String getPAPD_PAYEE_NAME() {
		return PAPD_PAYEE_NAME;
	}

	public void setPAPD_STATE_CODE(String PAPD_STATE_CODE) {
		this.PAPD_STATE_CODE = PAPD_STATE_CODE;
	}

	public String getPAPD_STATE_CODE() {
		return PAPD_STATE_CODE;
	}

	public void setPAPD_CUST_BANK_ACC_NO(String PAPD_CUST_BANK_ACC_NO) {
		this.PAPD_CUST_BANK_ACC_NO = PAPD_CUST_BANK_ACC_NO;
	}

	public String getPAPD_CUST_BANK_ACC_NO() {
		return PAPD_CUST_BANK_ACC_NO;
	}

	public void setPAPD_OFF_AREA_CODE(String PAPD_OFF_AREA_CODE) {
		this.PAPD_OFF_AREA_CODE = PAPD_OFF_AREA_CODE;
	}

	public String getPAPD_OFF_AREA_CODE() {
		return PAPD_OFF_AREA_CODE;
	}

	public void setPAPD_UPD_UID(String PAPD_UPD_UID) {
		this.PAPD_UPD_UID = PAPD_UPD_UID;
	}

	public String getPAPD_UPD_UID() {
		return PAPD_UPD_UID;
	}

	public void setPAPD_PAYEE_ANLY_CODE_2(String PAPD_PAYEE_ANLY_CODE_2) {
		this.PAPD_PAYEE_ANLY_CODE_2 = PAPD_PAYEE_ANLY_CODE_2;
	}

	public String getPAPD_PAYEE_ANLY_CODE_2() {
		return PAPD_PAYEE_ANLY_CODE_2;
	}

	public void setPAPD_CUST_BANK_REF_NO(String PAPD_CUST_BANK_REF_NO) {
		this.PAPD_CUST_BANK_REF_NO = PAPD_CUST_BANK_REF_NO;
	}

	public String getPAPD_CUST_BANK_REF_NO() {
		return PAPD_CUST_BANK_REF_NO;
	}

	public void setPAPD_CUST_CODE(String PAPD_CUST_CODE) {
		this.PAPD_CUST_CODE = PAPD_CUST_CODE;
	}

	public String getPAPD_CUST_CODE() {
		return PAPD_CUST_CODE;
	}

	public void setPAPD_DOC_NO(Double PAPD_DOC_NO) {
		this.PAPD_DOC_NO = PAPD_DOC_NO;
	}

	public Double getPAPD_DOC_NO() {
		return PAPD_DOC_NO;
	}

	public void setPAPD_CUST_BANK_CODE(String PAPD_CUST_BANK_CODE) {
		this.PAPD_CUST_BANK_CODE = PAPD_CUST_BANK_CODE;
	}

	public String getPAPD_CUST_BANK_CODE() {
		return PAPD_CUST_BANK_CODE;
	}

	public void setPAPD_PAYEE_ADDR2(String PAPD_PAYEE_ADDR2) {
		this.PAPD_PAYEE_ADDR2 = PAPD_PAYEE_ADDR2;
	}

	public String getPAPD_PAYEE_ADDR2() {
		return PAPD_PAYEE_ADDR2;
	}

	public void setPAPD_PAYEE_ADDR3(String PAPD_PAYEE_ADDR3) {
		this.PAPD_PAYEE_ADDR3 = PAPD_PAYEE_ADDR3;
	}

	public String getPAPD_PAYEE_ADDR3() {
		return PAPD_PAYEE_ADDR3;
	}

	public void setPAPD_CHQ_ISSUE_USER_ID(String PAPD_CHQ_ISSUE_USER_ID) {
		this.PAPD_CHQ_ISSUE_USER_ID = PAPD_CHQ_ISSUE_USER_ID;
	}

	public String getPAPD_CHQ_ISSUE_USER_ID() {
		return PAPD_CHQ_ISSUE_USER_ID;
	}

	public void setPAPD_PAYEE_ADDR1(String PAPD_PAYEE_ADDR1) {
		this.PAPD_PAYEE_ADDR1 = PAPD_PAYEE_ADDR1;
	}

	public String getPAPD_PAYEE_ADDR1() {
		return PAPD_PAYEE_ADDR1;
	}

	public void setPAPD_MAIN_ACNT_CODE(String PAPD_MAIN_ACNT_CODE) {
		this.PAPD_MAIN_ACNT_CODE = PAPD_MAIN_ACNT_CODE;
	}

	public String getPAPD_MAIN_ACNT_CODE() {
		return PAPD_MAIN_ACNT_CODE;
	}

	public void setPAPD_SYS_ID(Long PAPD_SYS_ID) {
		this.PAPD_SYS_ID = PAPD_SYS_ID;
	}

	public Long getPAPD_SYS_ID() {
		return PAPD_SYS_ID;
	}

	public void setPAPD_CHQ_DT(Date PAPD_CHQ_DT) {
		this.PAPD_CHQ_DT = PAPD_CHQ_DT;
	}

	public Date getPAPD_CHQ_DT() {
		return PAPD_CHQ_DT;
	}

	public void setPAPD_CURR_CODE(String PAPD_CURR_CODE) {
		this.PAPD_CURR_CODE = PAPD_CURR_CODE;
	}

	public String getPAPD_CURR_CODE() {
		return PAPD_CURR_CODE;
	}

	public void setPAPD_FC_PAY_AMT(Double PAPD_FC_PAY_AMT) {
		this.PAPD_FC_PAY_AMT = PAPD_FC_PAY_AMT;
	}

	public Double getPAPD_FC_PAY_AMT() {
		return PAPD_FC_PAY_AMT;
	}

	public void setPAPD_PSD_SYS_ID(Long PAPD_PSD_SYS_ID) {
		this.PAPD_PSD_SYS_ID = PAPD_PSD_SYS_ID;
	}

	public Long getPAPD_PSD_SYS_ID() {
		return PAPD_PSD_SYS_ID;
	}

	public void setPAPD_CHQ_APPR_USER_ID(String PAPD_CHQ_APPR_USER_ID) {
		this.PAPD_CHQ_APPR_USER_ID = PAPD_CHQ_APPR_USER_ID;
	}

	public String getPAPD_CHQ_APPR_USER_ID() {
		return PAPD_CHQ_APPR_USER_ID;
	}

	public void setPAPD_PAH_SYS_ID(Long PAPD_PAH_SYS_ID) {
		this.PAPD_PAH_SYS_ID = PAPD_PAH_SYS_ID;
	}

	public Long getPAPD_PAH_SYS_ID() {
		return PAPD_PAH_SYS_ID;
	}

	public void setPAPD_BANK_ACC_NO(String PAPD_BANK_ACC_NO) {
		this.PAPD_BANK_ACC_NO = PAPD_BANK_ACC_NO;
	}

	public String getPAPD_BANK_ACC_NO() {
		return PAPD_BANK_ACC_NO;
	}

	public void setPAPD_PAD_SYS_ID(Long PAPD_PAD_SYS_ID) {
		this.PAPD_PAD_SYS_ID = PAPD_PAD_SYS_ID;
	}

	public Long getPAPD_PAD_SYS_ID() {
		return PAPD_PAD_SYS_ID;
	}

	public void setPAPD_NARRATION(String PAPD_NARRATION) {
		this.PAPD_NARRATION = PAPD_NARRATION;
	}

	public String getPAPD_NARRATION() {
		return PAPD_NARRATION;
	}

	public void setPAPD_CR_UID(String PAPD_CR_UID) {
		this.PAPD_CR_UID = PAPD_CR_UID;
	}

	public String getPAPD_CR_UID() {
		return PAPD_CR_UID;
	}

	public void setPAPD_CLE_ZONE_CODE(String PAPD_CLE_ZONE_CODE) {
		this.PAPD_CLE_ZONE_CODE = PAPD_CLE_ZONE_CODE;
	}

	public String getPAPD_CLE_ZONE_CODE() {
		return PAPD_CLE_ZONE_CODE;
	}

	public void setPAPD_CITY_CODE(String PAPD_CITY_CODE) {
		this.PAPD_CITY_CODE = PAPD_CITY_CODE;
	}

	public String getPAPD_CITY_CODE() {
		return PAPD_CITY_CODE;
	}

	public void setPAPD_PAY_APPRV_CODE(String PAPD_PAY_APPRV_CODE) {
		this.PAPD_PAY_APPRV_CODE = PAPD_PAY_APPRV_CODE;
	}

	public String getPAPD_PAY_APPRV_CODE() {
		return PAPD_PAY_APPRV_CODE;
	}

	public void setPAPD_SUB_ACNT_CODE(String PAPD_SUB_ACNT_CODE) {
		this.PAPD_SUB_ACNT_CODE = PAPD_SUB_ACNT_CODE;
	}

	public String getPAPD_SUB_ACNT_CODE() {
		return PAPD_SUB_ACNT_CODE;
	}

	public void setPAPD_ANLY_CODE_1(String PAPD_ANLY_CODE_1) {
		this.PAPD_ANLY_CODE_1 = PAPD_ANLY_CODE_1;
	}

	public String getPAPD_ANLY_CODE_1() {
		return PAPD_ANLY_CODE_1;
	}

	public void setPAPD_CUST_BANK_NAME(String PAPD_CUST_BANK_NAME) {
		this.PAPD_CUST_BANK_NAME = PAPD_CUST_BANK_NAME;
	}

	public String getPAPD_CUST_BANK_NAME() {
		return PAPD_CUST_BANK_NAME;
	}

	public void setPAPD_ANLY_CODE_2(String PAPD_ANLY_CODE_2) {
		this.PAPD_ANLY_CODE_2 = PAPD_ANLY_CODE_2;
	}

	public String getPAPD_ANLY_CODE_2() {
		return PAPD_ANLY_CODE_2;
	}

	public void setPAPD_LC_PAY_AMT(Double PAPD_LC_PAY_AMT) {
		this.PAPD_LC_PAY_AMT = PAPD_LC_PAY_AMT;
	}

	public Double getPAPD_LC_PAY_AMT() {
		return PAPD_LC_PAY_AMT;
	}

	public void setPAPD_DES_MTD_CODE(String PAPD_DES_MTD_CODE) {
		this.PAPD_DES_MTD_CODE = PAPD_DES_MTD_CODE;
	}

	public String getPAPD_DES_MTD_CODE() {
		return PAPD_DES_MTD_CODE;
	}

	public void setPAPD_PAY_MODE(String PAPD_PAY_MODE) {
		this.PAPD_PAY_MODE = PAPD_PAY_MODE;
	}

	public String getPAPD_PAY_MODE() {
		return PAPD_PAY_MODE;
	}

	public void setPAPD_TXN_CODE(String PAPD_TXN_CODE) {
		this.PAPD_TXN_CODE = PAPD_TXN_CODE;
	}

	public String getPAPD_TXN_CODE() {
		return PAPD_TXN_CODE;
	}

	public void setPAPD_ACTY_CODE_1(String PAPD_ACTY_CODE_1) {
		this.PAPD_ACTY_CODE_1 = PAPD_ACTY_CODE_1;
	}

	public String getPAPD_ACTY_CODE_1() {
		return PAPD_ACTY_CODE_1;
	}

	public void setPAPD_ACTY_CODE_2(String PAPD_ACTY_CODE_2) {
		this.PAPD_ACTY_CODE_2 = PAPD_ACTY_CODE_2;
	}

	public String getPAPD_ACTY_CODE_2() {
		return PAPD_ACTY_CODE_2;
	}

	public void setPAPD_BANK_CODE(String PAPD_BANK_CODE) {
		this.PAPD_BANK_CODE = PAPD_BANK_CODE;
	}

	public String getPAPD_BANK_CODE() {
		return PAPD_BANK_CODE;
	}

	public void setPAPD_SWIFT_CODE(String PAPD_SWIFT_CODE) {
		this.PAPD_SWIFT_CODE = PAPD_SWIFT_CODE;
	}

	public String getPAPD_SWIFT_CODE() {
		return PAPD_SWIFT_CODE;
	}

	public void setPAPD_DRAFT_DT(Date PAPD_DRAFT_DT) {
		this.PAPD_DRAFT_DT = PAPD_DRAFT_DT;
	}

	public Date getPAPD_DRAFT_DT() {
		return PAPD_DRAFT_DT;
	}

	public void setPAPD_ATTENTION_TO(String PAPD_ATTENTION_TO) {
		this.PAPD_ATTENTION_TO = PAPD_ATTENTION_TO;
	}

	public String getPAPD_ATTENTION_TO() {
		return PAPD_ATTENTION_TO;
	}

	public void setPAPD_ACNT_YEAR(Double PAPD_ACNT_YEAR) {
		this.PAPD_ACNT_YEAR = PAPD_ACNT_YEAR;
	}

	public Double getPAPD_ACNT_YEAR() {
		return PAPD_ACNT_YEAR;
	}

	public void setPAPD_DOC_DT(Date PAPD_DOC_DT) {
		this.PAPD_DOC_DT = PAPD_DOC_DT;
	}

	public Date getPAPD_DOC_DT() {
		return PAPD_DOC_DT;
	}

}