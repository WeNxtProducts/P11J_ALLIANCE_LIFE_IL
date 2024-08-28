package com.iii.pel.forms.PILM048_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_BANK_CHARGE_SETUP_HDR")
public class PM_BANK_CHARGE_SETUP_HDR extends BaseValueBean{

	@Column(name="ROWID")
	private String ROWID;
	
	@Column(name="BCSH_BANK_CODE")
	private String BCSH_BANK_CODE;

	@Column(name="BCSH_PAY_MODE")
	private String BCSH_PAY_MODE;

	@Column(name="BCSH_PAY_FOR")
	private String BCSH_PAY_FOR;

	@Column(name="BCSH_CHG_CODE")
	private String BCSH_CHG_CODE;

	@Column(name="BCSH_CHG_APPLIED_ON")
	private String BCSH_CHG_APPLIED_ON;

	@Column(name="BCSH_CHG_AC_DOC_MODE")
	private String BCSH_CHG_AC_DOC_MODE;

	@Column(name="BCSH_PROD_CODE_FM")
	private String BCSH_PROD_CODE_FM;

	@Column(name="BCSH_PROD_CODE_TO")
	private String BCSH_PROD_CODE_TO;

	@Column(name="BCSH_MAIN_ACNT_CODE")
	private String BCSH_MAIN_ACNT_CODE;

	@Column(name="BCSH_SUB_ACNT_CODE")
	private String BCSH_SUB_ACNT_CODE;

	@Column(name="BCSH_DIVN_CODE")
	private String BCSH_DIVN_CODE;

	@Column(name="BCSH_DEPT_CODE")
	private String BCSH_DEPT_CODE;

	@Column(name="BCSH_ANLY_CODE_1")
	private String BCSH_ANLY_CODE_1;

	@Column(name="BCSH_ANLY_CODE_2")
	private String BCSH_ANLY_CODE_2;

	@Column(name="BCSH_ACTY_CODE_1")
	private String BCSH_ACTY_CODE_1;

	@Column(name="BCSH_ACTY_CODE_2")
	private String BCSH_ACTY_CODE_2;

	private String BANK_CODE_DESC;

	private String BCSH_CHG_CODE_DESC;

	private String MAIN_ACNT_DESC;

	private String SUB_ACNT_DESC;

	private String DIVN_CODE_DESC;

	private String DEPT_CODE_DESC;

	private String ANLY_CODE_1_DESC;

	private String ANLY_CODE_2_DESC;

	private String ACTY_CODE_1_DESC;

	private String ACTY_CODE_2_DESC;

	@Column(name="BCSH_TRAN_TYPE")
	private String BCSH_TRAN_TYPE;

	@Column(name="BCSH_CUST_SHARE_PERC")
	private Integer BCSH_CUST_SHARE_PERC;

	@Column(name="BCSH_FRZ_FLAG")
	private String BCSH_FRZ_FLAG;
	
	@Column(name="BCSH_SYS_ID")
	private Double BCSH_SYS_ID;
	
	@Column(name="BCSH_CR_DT")
	private Date BCSH_CR_DT;
	
	@Column(name="BCSH_CR_UID")
	private String BCSH_CR_UID;
	
	private String BCSH_MODULE_ID;

	public Double getBCSH_SYS_ID() {
		return BCSH_SYS_ID;
	}

	public void setBCSH_SYS_ID(Double bcsh_sys_id) {
		BCSH_SYS_ID = bcsh_sys_id;
	}

	
	/**
	 * @return the bCSH_CR_DT
	 */
	public Date getBCSH_CR_DT() {
		return BCSH_CR_DT;
	}

	/**
	 * @param bcsh_cr_dt the bCSH_CR_DT to set
	 */
	public void setBCSH_CR_DT(Date bcsh_cr_dt) {
		BCSH_CR_DT = bcsh_cr_dt;
	}

	public String getBCSH_CR_UID() {
		return BCSH_CR_UID;
	}

	public void setBCSH_CR_UID(String bcsh_cr_uid) {
		BCSH_CR_UID = bcsh_cr_uid;
	}

	public String getBCSH_MODULE_ID() {
		return BCSH_MODULE_ID;
	}

	public void setBCSH_MODULE_ID(String bcsh_module_id) {
		BCSH_MODULE_ID = bcsh_module_id;
	}

	public String getBCSH_BANK_CODE() {
		return BCSH_BANK_CODE;
	}

	public void setBCSH_BANK_CODE(String BCSH_BANK_CODE) {
		this.BCSH_BANK_CODE = BCSH_BANK_CODE;
	}

	public String getBCSH_PAY_MODE() {
		return BCSH_PAY_MODE;
	}

	public void setBCSH_PAY_MODE(String BCSH_PAY_MODE) {
		this.BCSH_PAY_MODE = BCSH_PAY_MODE;
	}

	public String getBCSH_PAY_FOR() {
		return BCSH_PAY_FOR;
	}

	public void setBCSH_PAY_FOR(String BCSH_PAY_FOR) {
		this.BCSH_PAY_FOR = BCSH_PAY_FOR;
	}

	public String getBCSH_CHG_CODE() {
		return BCSH_CHG_CODE;
	}

	public void setBCSH_CHG_CODE(String BCSH_CHG_CODE) {
		this.BCSH_CHG_CODE = BCSH_CHG_CODE;
	}

	public String getBCSH_CHG_APPLIED_ON() {
		return BCSH_CHG_APPLIED_ON;
	}

	public void setBCSH_CHG_APPLIED_ON(String BCSH_CHG_APPLIED_ON) {
		this.BCSH_CHG_APPLIED_ON = BCSH_CHG_APPLIED_ON;
	}

	public String getBCSH_CHG_AC_DOC_MODE() {
		return BCSH_CHG_AC_DOC_MODE;
	}

	public void setBCSH_CHG_AC_DOC_MODE(String BCSH_CHG_AC_DOC_MODE) {
		this.BCSH_CHG_AC_DOC_MODE = BCSH_CHG_AC_DOC_MODE;
	}

	public String getBCSH_PROD_CODE_FM() {
		return BCSH_PROD_CODE_FM;
	}

	public void setBCSH_PROD_CODE_FM(String BCSH_PROD_CODE_FM) {
		this.BCSH_PROD_CODE_FM = BCSH_PROD_CODE_FM;
	}

	public String getBCSH_PROD_CODE_TO() {
		return BCSH_PROD_CODE_TO;
	}

	public void setBCSH_PROD_CODE_TO(String BCSH_PROD_CODE_TO) {
		this.BCSH_PROD_CODE_TO = BCSH_PROD_CODE_TO;
	}

	public String getBCSH_MAIN_ACNT_CODE() {
		return BCSH_MAIN_ACNT_CODE;
	}

	public void setBCSH_MAIN_ACNT_CODE(String BCSH_MAIN_ACNT_CODE) {
		this.BCSH_MAIN_ACNT_CODE = BCSH_MAIN_ACNT_CODE;
	}

	public String getBCSH_SUB_ACNT_CODE() {
		return BCSH_SUB_ACNT_CODE;
	}

	public void setBCSH_SUB_ACNT_CODE(String BCSH_SUB_ACNT_CODE) {
		this.BCSH_SUB_ACNT_CODE = BCSH_SUB_ACNT_CODE;
	}

	public String getBCSH_DIVN_CODE() {
		return BCSH_DIVN_CODE;
	}

	public void setBCSH_DIVN_CODE(String BCSH_DIVN_CODE) {
		this.BCSH_DIVN_CODE = BCSH_DIVN_CODE;
	}

	public String getBCSH_DEPT_CODE() {
		return BCSH_DEPT_CODE;
	}

	public void setBCSH_DEPT_CODE(String BCSH_DEPT_CODE) {
		this.BCSH_DEPT_CODE = BCSH_DEPT_CODE;
	}

	public String getBCSH_ANLY_CODE_1() {
		return BCSH_ANLY_CODE_1;
	}

	public void setBCSH_ANLY_CODE_1(String BCSH_ANLY_CODE_1) {
		this.BCSH_ANLY_CODE_1 = BCSH_ANLY_CODE_1;
	}

	public String getBCSH_ANLY_CODE_2() {
		return BCSH_ANLY_CODE_2;
	}

	public void setBCSH_ANLY_CODE_2(String BCSH_ANLY_CODE_2) {
		this.BCSH_ANLY_CODE_2 = BCSH_ANLY_CODE_2;
	}

	public String getBCSH_ACTY_CODE_1() {
		return BCSH_ACTY_CODE_1;
	}

	public void setBCSH_ACTY_CODE_1(String BCSH_ACTY_CODE_1) {
		this.BCSH_ACTY_CODE_1 = BCSH_ACTY_CODE_1;
	}

	public String getBCSH_ACTY_CODE_2() {
		return BCSH_ACTY_CODE_2;
	}

	public void setBCSH_ACTY_CODE_2(String BCSH_ACTY_CODE_2) {
		this.BCSH_ACTY_CODE_2 = BCSH_ACTY_CODE_2;
	}

	public String getBANK_CODE_DESC() {
		return BANK_CODE_DESC;
	}

	public void setBANK_CODE_DESC(String BANK_CODE_DESC) {
		this.BANK_CODE_DESC = BANK_CODE_DESC;
	}

	public String getBCSH_CHG_CODE_DESC() {
		return BCSH_CHG_CODE_DESC;
	}

	public void setBCSH_CHG_CODE_DESC(String BCSH_CHG_CODE_DESC) {
		this.BCSH_CHG_CODE_DESC = BCSH_CHG_CODE_DESC;
	}

	public String getMAIN_ACNT_DESC() {
		return MAIN_ACNT_DESC;
	}

	public void setMAIN_ACNT_DESC(String MAIN_ACNT_DESC) {
		this.MAIN_ACNT_DESC = MAIN_ACNT_DESC;
	}

	public String getSUB_ACNT_DESC() {
		return SUB_ACNT_DESC;
	}

	public void setSUB_ACNT_DESC(String SUB_ACNT_DESC) {
		this.SUB_ACNT_DESC = SUB_ACNT_DESC;
	}

	public String getDIVN_CODE_DESC() {
		return DIVN_CODE_DESC;
	}

	public void setDIVN_CODE_DESC(String DIVN_CODE_DESC) {
		this.DIVN_CODE_DESC = DIVN_CODE_DESC;
	}

	public String getDEPT_CODE_DESC() {
		return DEPT_CODE_DESC;
	}

	public void setDEPT_CODE_DESC(String DEPT_CODE_DESC) {
		this.DEPT_CODE_DESC = DEPT_CODE_DESC;
	}

	public String getANLY_CODE_1_DESC() {
		return ANLY_CODE_1_DESC;
	}

	public void setANLY_CODE_1_DESC(String ANLY_CODE_1_DESC) {
		this.ANLY_CODE_1_DESC = ANLY_CODE_1_DESC;
	}

	public String getANLY_CODE_2_DESC() {
		return ANLY_CODE_2_DESC;
	}

	public void setANLY_CODE_2_DESC(String ANLY_CODE_2_DESC) {
		this.ANLY_CODE_2_DESC = ANLY_CODE_2_DESC;
	}

	public String getACTY_CODE_1_DESC() {
		return ACTY_CODE_1_DESC;
	}

	public void setACTY_CODE_1_DESC(String ACTY_CODE_1_DESC) {
		this.ACTY_CODE_1_DESC = ACTY_CODE_1_DESC;
	}

	public String getACTY_CODE_2_DESC() {
		return ACTY_CODE_2_DESC;
	}

	public void setACTY_CODE_2_DESC(String ACTY_CODE_2_DESC) {
		this.ACTY_CODE_2_DESC = ACTY_CODE_2_DESC;
	}

	public String getBCSH_TRAN_TYPE() {
		return BCSH_TRAN_TYPE;
	}

	public void setBCSH_TRAN_TYPE(String BCSH_TRAN_TYPE) {
		this.BCSH_TRAN_TYPE = BCSH_TRAN_TYPE;
	}

	public String getBCSH_FRZ_FLAG() {
		return BCSH_FRZ_FLAG;
	}
	
	private boolean FS_FRZ_YN_VALUE;

	public void setBCSH_FRZ_FLAG(String BCSH_FRZ_FLAG) {
		if("Y".equalsIgnoreCase(BCSH_FRZ_FLAG)){
			FS_FRZ_YN_VALUE = true;
		} else {
			FS_FRZ_YN_VALUE = false;
		}
		this.BCSH_FRZ_FLAG = BCSH_FRZ_FLAG;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	/**
	 * @return the bCSH_CUST_SHARE_PERC
	 */
	public Integer getBCSH_CUST_SHARE_PERC() {
		return BCSH_CUST_SHARE_PERC;
	}

	/**
	 * @param bcsh_cust_share_perc the bCSH_CUST_SHARE_PERC to set
	 */
	public void setBCSH_CUST_SHARE_PERC(Integer bcsh_cust_share_perc) {
		BCSH_CUST_SHARE_PERC = bcsh_cust_share_perc;
	}

	public boolean isFS_FRZ_YN_VALUE() {
		return FS_FRZ_YN_VALUE;
	}

	public void setFS_FRZ_YN_VALUE(boolean fs_frz_yn_value) {
		FS_FRZ_YN_VALUE = fs_frz_yn_value;
	}
}
