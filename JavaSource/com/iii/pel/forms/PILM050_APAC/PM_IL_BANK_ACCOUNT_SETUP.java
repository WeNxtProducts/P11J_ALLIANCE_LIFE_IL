package com.iii.pel.forms.PILM050_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_BANK_ACCOUNT_SETUP")
public class PM_IL_BANK_ACCOUNT_SETUP extends BaseValueBean {
	
	
//  The below code is hard coded for customization & generated getters & setters
  
	@Column(name="BAS_CR_DT")
	private Date BAS_CR_DT;

	@Column(name="BAS_CR_UID")
	private String BAS_CR_UID;
	
	@Column(name="BAS_UPD_DT")
	private Date BAS_UPD_DT;

	@Column(name="BAS_UPD_UID")
	private String BAS_UPD_UID;

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
	
	@Column(name="BAS_TXN_TYPE")
	private String BAS_TXN_TYPE;

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
	
	private String DIVN_CODE;
	
	private String DIVN_CODE_DESC;
	
	private String DEPT_CODE;
	
	private String DEPT_CODE_DESC;

	private Boolean CURR_FRZ_FLAG_NUM_VALUE;
	
	private boolean CHECK_BOX;

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

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
		System.out.println("PM_IL_BANK_ACCOUNT_SETUP.getBAS_DEPT_FM_CODE()-BAS_DEPT_FM_CODE"+BAS_DEPT_FM_CODE);
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

	

	public Date getBAS_CR_DT() {
		return BAS_CR_DT;
	}

	public void setBAS_CR_DT(Date bas_cr_dt) {
		BAS_CR_DT = bas_cr_dt;
	}

	public String getBAS_CR_UID() {
		return BAS_CR_UID;
	}

	public void setBAS_CR_UID(String bas_cr_uid) {
		BAS_CR_UID = bas_cr_uid;
	}	

	public String getDIVN_CODE() {
		return DIVN_CODE;
	}

	public void setDIVN_CODE(String divn_code) {
		DIVN_CODE = divn_code;
	}

	public String getDIVN_CODE_DESC() {
		return DIVN_CODE_DESC;
	}

	public void setDIVN_CODE_DESC(String divn_code_desc) {
		DIVN_CODE_DESC = divn_code_desc;
	}

	public String getDEPT_CODE() {
		return DEPT_CODE;
	}

	public void setDEPT_CODE(String dept_code) {
		DEPT_CODE = dept_code;
	}

	public String getDEPT_CODE_DESC() {
		return DEPT_CODE_DESC;
	}

	public void setDEPT_CODE_DESC(String dept_code_desc) {
		DEPT_CODE_DESC = dept_code_desc;
	}

	public String getBAS_TXN_TYPE() {
		return BAS_TXN_TYPE;
	}

	public void setBAS_TXN_TYPE(String n_typebas_txn_type) {
		BAS_TXN_TYPE = n_typebas_txn_type;
	}

	public Date getBAS_UPD_DT() {
		return BAS_UPD_DT;
	}

	public void setBAS_UPD_DT(Date bas_upd_dt) {
		BAS_UPD_DT = bas_upd_dt;
	}

	public String getBAS_UPD_UID() {
		return BAS_UPD_UID;
	}

	public void setBAS_UPD_UID(String bas_upd_uid) {
		BAS_UPD_UID = bas_upd_uid;
	}

	public Boolean getCURR_FRZ_FLAG_NUM_VALUE() {
		if (null!=BAS_FRZ_FLAG&&BAS_FRZ_FLAG.equalsIgnoreCase("Y")) {
			CURR_FRZ_FLAG_NUM_VALUE = true;
		} else {
			CURR_FRZ_FLAG_NUM_VALUE = false;
		}
		return CURR_FRZ_FLAG_NUM_VALUE;
	}

	public void setCURR_FRZ_FLAG_NUM_VALUE(Boolean curr_frz_flag_num_value) {
		CURR_FRZ_FLAG_NUM_VALUE = curr_frz_flag_num_value;
		if (CURR_FRZ_FLAG_NUM_VALUE) {
			BAS_FRZ_FLAG = "Y";
		} else {
			BAS_FRZ_FLAG = "N";
		}
	}
}
