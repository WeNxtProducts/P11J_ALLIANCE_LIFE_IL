package com.iii.pel.forms.PILT002_APAC_QE;

import java.util.Date;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.iii.apps.persistence.BaseValueBean;
import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name="PW_IL_QUICK_QUOTE")
public class PW_IL_QUICK_QUOTE extends BaseValueBean{

	@Column(name="QUOT_SYS_ID")
	private Long QUOT_SYS_ID;
	
	@Column(name="QUOT_MOP")
	private String QUOT_MOP;
	
	@Column(name="QUOT_NO")
	private String QUOT_NO;
	
	@Column(name="QUOT_IDX_NO")
	private int QUOT_IDX_NO;
	
	@Column(name="QUOT_MAX_AGE")
	private int QUOT_MAX_AGE;
	
	@Column(name="QUOT_EMR_RATE")
	private Double QUOT_EMR_RATE;
	
	public int getQUOT_MAX_AGE() {
		return QUOT_MAX_AGE;
	}
	
	@Column(name="QUOT_COMM_VALUE")
	private Double QUOT_COMM_VALUE ;


	public void setQUOT_MAX_AGE(int qUOT_MAX_AGE) {
		QUOT_MAX_AGE = qUOT_MAX_AGE;
	}

	@Column(name="QUOT_CUST_CURR_CODE")
	private String QUOT_CUST_CURR_CODE;
	
	public String getQUOT_CUST_CURR_CODE() {
		return QUOT_CUST_CURR_CODE;
	}

	public void setQUOT_CUST_CURR_CODE(String qUOT_CUST_CURR_CODE) {
		QUOT_CUST_CURR_CODE = qUOT_CUST_CURR_CODE;
	}

	public Double getQUOT_COMM_VALUE() {
		return QUOT_COMM_VALUE;
	}

	public void setQUOT_COMM_VALUE(Double qUOT_COMM_VALUE) {
		QUOT_COMM_VALUE = qUOT_COMM_VALUE;
	}

	@Column(name="QUOT_PROD_CODE")
	private String QUOT_PROD_CODE;
	
	private String UI_QUOT_PROD_CODE_DESC;
	
	@Column(name="QUOT_CLASS_CODE")
	private String QUOT_CLASS_CODE;
	
	@Column(name="QUOT_DS_TYPE")
	private String QUOT_DS_TYPE;
	
	@Column(name="QUOT_DS_CODE")
	private String QUOT_DS_CODE;
	
	@Column(name="QUOT_ISS_DT")
	private Date QUOT_ISS_DT;
	
	@Column(name="QUOT_PERIOD")
	private Integer QUOT_PERIOD;
	
	@Column(name="QUOT_PREM_PAY_YRS")
	private Integer QUOT_PREM_PAY_YRS;
	
	@Column(name="QUOT_FM_DT")
	private Date QUOT_FM_DT;
	
	@Column(name="QUOT_TO_DT")
	private Date QUOT_TO_DT;
	
	@Column(name="QUOT_VALID_DT")
	private Date QUOT_VALID_DT;
	
	@Column(name="QUOT_CUST_SURNAME")
	private String QUOT_CUST_SURNAME;
	
	@Column(name="QUOT_DIVN_CODE")
	private String QUOT_DIVN_CODE;
	
	
	@Column(name="QUOT_UW_YEAR")
	private String QUOT_UW_YEAR;
	
	@Column(name="QUOT_CONV_YN")
	private String QUOT_CONV_YN;
	
	
	
	
	private String UI_M_APPRV_STATUS;
	
	 

	
	

	@Column(name="QUOT_NEW_CUST_YN")
	private String QUOT_NEW_CUST_YN;
	
	@Column(name="QUOT_CUST_CODE")
	private String QUOT_CUST_CODE;
	
	@Column(name="QUOT_CUST_TITLE")
	private String QUOT_CUST_TITLE;
	
	@Column(name="QUOT_CUST_NAME")
	private String QUOT_CUST_NAME;
	
	@Column(name="QUOT_CUST_ADDR1")
	private String QUOT_CUST_ADDR1;
	
	@Column(name="QUOT_CUST_ADDR2")
	private String QUOT_CUST_ADDR2;
	
	@Column(name="QUOT_CUST_ADDR3")
	private String QUOT_CUST_ADDR3;
	@Column(name="QUOT_CUST_CITY")
	private String QUOT_CUST_CITY;
	
	private String UI_QUOT_CUST_CITY_DESC;
	
	@Column(name="QUOT_CUST_STATE")
	private String QUOT_CUST_STATE;
	
	private String UI_QUOT_CUST_STATE_DESC;
	
	@Column(name="QUOT_CUST_PO")
	private String QUOT_CUST_PO;
	
	@Column(name="QUOT_PLAN_CODE")
	private String QUOT_PLAN_CODE;
	
	@Column(name="QUOT_CUST_PHONE")
	private String QUOT_CUST_PHONE;
	
	@Column(name="QUOT_CUST_CONTACT")
	private String QUOT_CUST_CONTACT;
	
	



	@Column(name="QUOT_CUST_MAIL_ID")
	private String QUOT_CUST_MAIL_ID;
	
	@Column(name="QUOT_SRC_BUS")
	private String QUOT_SRC_BUS;
	
	private String UI_QUOT_SRC_BUS_DESC;
	
	@Column(name="QUOT_SRC_CODE")
	private String QUOT_SRC_CODE;
	
	private String UI_QUOT_SRC_CODE_DESC;
	
	@Column(name="QUOT_FRZ_RATE")
	private String QUOT_FRZ_RATE;
	
	@Column(name="QUOT_STATUS")
	private String QUOT_STATUS;
	
	@Column(name="QUOT_APPR_STS")
	private String QUOT_APPR_STS;
	
	@Column(name="QUOT_APPR_DT")
	private java.util.Date QUOT_APPR_DT;
	
	public String getQUOT_DIVN_CODE() {
		return QUOT_DIVN_CODE;
	}

	public void setQUOT_DIVN_CODE(String qUOT_DIVN_CODE) {
		QUOT_DIVN_CODE = qUOT_DIVN_CODE;
	}

	public String getQUOT_UW_YEAR() {
		return QUOT_UW_YEAR;
	}

	public void setQUOT_UW_YEAR(String qUOT_UW_YEAR) {
		QUOT_UW_YEAR = qUOT_UW_YEAR;
	}




	@Column(name="QUOT_APPR_UID")
	private String QUOT_APPR_UID;
	
	@Column(name="QUOT_FC_SA")
	private Double QUOT_FC_SA;
	
	@Column(name="QUOT_LC_SA")
	private Double QUOT_LC_SA;
	
	@Column(name="QUOT_FC_PREM")
	private Double QUOT_FC_PREM;
	
	@Column(name="QUOT_LC_PREM")
	private Double QUOT_LC_PREM;
	
	



	@Column(name="QUOT_CR_DT")
	private java.util.Date QUOT_CR_DT;
	
	@Column(name="QUOT_CR_UID")
	private String QUOT_CR_UID;
	
	@Column(name="QUOT_UPD_DT")
	private java.util.Date QUOT_UPD_DT;
	
	@Column(name="QUOT_UPD_UID")
	private String QUOT_UPD_UID;
	
	@Column(name="QUOT_ASSRD_REF_ID1")
	private String QUOT_ASSRD_REF_ID1; 
	
	
	/*added by soundarya*/
	
	@Column(name="QUOT_LOAN_TYPE")
	private String QUOT_LOAN_TYPE;
	
	@Column(name="QUOT_BANK_ACNT")
	private String QUOT_BANK_ACNT;
	
	@Column(name="QUOT_BANK_DIVN")
	private String QUOT_BANK_DIVN;
	
	/*@Column(name="QUOT_BANK_CODE")*/
	private String QUOT_BANK_CODE;
	
	@Column(name="QUOT_SM_CODE")
	private String QUOT_SM_CODE;
	
	@Column(name="QUOT_SO_CODE")
	private String QUOT_SO_CODE;
	
	@Column(name="QUOT_ORG_BROK_CODE")
	private String QUOT_ORG_BROK_CODE;
	
	@Column(name="QUOT_ORG_COMM_RATE")
	private Double QUOT_ORG_COMM_RATE;

	public String getQUOT_ORG_BROK_CODE() {
		return QUOT_ORG_BROK_CODE;
	}

	public void setQUOT_ORG_BROK_CODE(String qUOT_ORG_BROK_CODE) {
		QUOT_ORG_BROK_CODE = qUOT_ORG_BROK_CODE;
	}

	
	public Double getQUOT_ORG_COMM_RATE() {
		return QUOT_ORG_COMM_RATE;
	}

	public void setQUOT_ORG_COMM_RATE(Double qUOT_ORG_COMM_RATE) {
		QUOT_ORG_COMM_RATE = qUOT_ORG_COMM_RATE;
	}

	private String UI_NET_PREMIUM;
	
	
	
	public String getQUOT_SO_CODE() {
		return QUOT_SO_CODE;
	}

	public void setQUOT_SO_CODE(String qUOT_SO_CODE) {
		QUOT_SO_CODE = qUOT_SO_CODE;
	}

	public String getQUOT_SM_CODE() {
		return QUOT_SM_CODE;
	}

	public void setQUOT_SM_CODE(String qUOT_SM_CODE) {
		QUOT_SM_CODE = qUOT_SM_CODE;
	}

	public String getQUOT_BANK_ACNT() {
		return QUOT_BANK_ACNT;
	}

	public void setQUOT_BANK_ACNT(String qUOT_BANK_ACNT) {
		QUOT_BANK_ACNT = qUOT_BANK_ACNT;
	}

	public String getQUOT_BANK_DIVN() {
		return QUOT_BANK_DIVN;
	}

	
	public String getQUOT_MOP() {
		return QUOT_MOP;
	}

	public void setQUOT_MOP(String qUOT_MOP) {
		QUOT_MOP = qUOT_MOP;
	}


	public String getQUOT_PLAN_CODE() {
		return QUOT_PLAN_CODE;
	}

	public void setQUOT_PLAN_CODE(String qUOT_PLAN_CODE) {
		QUOT_PLAN_CODE = qUOT_PLAN_CODE;
	}
	
	public String getQUOT_CONV_YN() {
		return QUOT_CONV_YN;
	}

	public void setQUOT_CONV_YN(String qUOT_CONV_YN) {
		QUOT_CONV_YN = qUOT_CONV_YN;
	}

	public void setQUOT_BANK_DIVN(String qUOT_BANK_DIVN) {
		QUOT_BANK_DIVN = qUOT_BANK_DIVN;
	}

	public String getQUOT_BANK_CODE() {
		return QUOT_BANK_CODE;
	}

	
	public String getUI_NET_PREMIUM() {
		return UI_NET_PREMIUM;
	}

	public void setUI_NET_PREMIUM(String uI_NET_PREMIUM) {
		UI_NET_PREMIUM = uI_NET_PREMIUM;
	}

	public void setQUOT_BANK_CODE(String qUOT_BANK_CODE) {
		QUOT_BANK_CODE = qUOT_BANK_CODE;
	}

	public String getQUOT_LOAN_TYPE() {
		return QUOT_LOAN_TYPE;
	}

	public void setQUOT_LOAN_TYPE(String qUOT_LOAN_TYPE) {
		QUOT_LOAN_TYPE = qUOT_LOAN_TYPE;
	}

	
	
	
	/*end*/
	public String getQUOT_CUST_SURNAME() {
		return QUOT_CUST_SURNAME;
	}

	public void setQUOT_CUST_SURNAME(String qUOT_CUST_SURNAME) {
		QUOT_CUST_SURNAME = qUOT_CUST_SURNAME;
	}

	public Date getQUOT_VALID_DT() {
		return QUOT_VALID_DT;
	}

	public void setQUOT_VALID_DT(Date qUOT_VALID_DT) {
		QUOT_VALID_DT = qUOT_VALID_DT;
	}



	
	
	
	
	
	public String getUI_M_APPRV_STATUS() {
		return UI_M_APPRV_STATUS;
	}

	public void setUI_M_APPRV_STATUS(String uI_M_APPRV_STATUS) {
		UI_M_APPRV_STATUS = uI_M_APPRV_STATUS;
	}




	private boolean QUOT_EXISTING_CUST_BOOLEAN;
	
	public String getQUOT_ASSRD_REF_ID1() {
		return QUOT_ASSRD_REF_ID1;
	}

	public void setQUOT_ASSRD_REF_ID1(String qUOT_ASSRD_REF_ID1) {
		QUOT_ASSRD_REF_ID1 = qUOT_ASSRD_REF_ID1;
	}

	public String getUI_QUOT_PROD_CODE_DESC() {
		return UI_QUOT_PROD_CODE_DESC;
	}

	public void setUI_QUOT_PROD_CODE_DESC(String ui_quot_prod_code_desc) {
		UI_QUOT_PROD_CODE_DESC = ui_quot_prod_code_desc;
	}

	public Long getQUOT_SYS_ID() {
		return QUOT_SYS_ID;
	}

	public void setQUOT_SYS_ID(Long quot_sys_id) {
		QUOT_SYS_ID = quot_sys_id;
	}

	public String getQUOT_NO() {
		return QUOT_NO;
	}

	public void setQUOT_NO(String quot_no) {
		QUOT_NO = quot_no;
	}

	public int getQUOT_IDX_NO() {
		return QUOT_IDX_NO;
	}

	public void setQUOT_IDX_NO(int quot_idx_no) {
		QUOT_IDX_NO = quot_idx_no;
	}

	public String getQUOT_PROD_CODE() {
		return QUOT_PROD_CODE;
	}

	public void setQUOT_PROD_CODE(String quot_prod_code) {
		QUOT_PROD_CODE = quot_prod_code;
	}

	public String getQUOT_CLASS_CODE() {
		return QUOT_CLASS_CODE;
	}

	public void setQUOT_CLASS_CODE(String quot_class_code) {
		QUOT_CLASS_CODE = quot_class_code;
	}

	public String getQUOT_DS_TYPE() {
		return QUOT_DS_TYPE;
	}

	public void setQUOT_DS_TYPE(String quot_ds_type) {
		QUOT_DS_TYPE = quot_ds_type;
	}

	public String getQUOT_DS_CODE() {
		return QUOT_DS_CODE;
	}

	public void setQUOT_DS_CODE(String quot_ds_code) {
		QUOT_DS_CODE = quot_ds_code;
	}

	public String getQUOT_NEW_CUST_YN() {
		return QUOT_NEW_CUST_YN;
	}

	public void setQUOT_NEW_CUST_YN(String quot_new_cust_yn) {
		if ("Y".equals(quot_new_cust_yn)) {
			QUOT_EXISTING_CUST_BOOLEAN = true ;
			
		}else {
			QUOT_EXISTING_CUST_BOOLEAN = true ;
		}
		QUOT_NEW_CUST_YN = quot_new_cust_yn;
	}

	public String getQUOT_CUST_CODE() {
		return QUOT_CUST_CODE;
	}

	public void setQUOT_CUST_CODE(String quot_cust_code) {
		QUOT_CUST_CODE = quot_cust_code;
	}

	public Date getQUOT_ISS_DT() {
		return QUOT_ISS_DT;
	}

	public void setQUOT_ISS_DT(Date _issquot_issquot_iss_dt_dt_iss_dt_dtquot_iss_dt_dt_iss_dt_dt) {
		QUOT_ISS_DT = _issquot_issquot_iss_dt_dt_iss_dt_dtquot_iss_dt_dt_iss_dt_dt;
	}

	public Integer getQUOT_PERIOD() {
		return QUOT_PERIOD;
	}

	public void setQUOT_PERIOD(Integer quot_period) {
		QUOT_PERIOD = quot_period;
	}

	public Integer getQUOT_PREM_PAY_YRS() {
		return QUOT_PREM_PAY_YRS;
	}

	public void setQUOT_PREM_PAY_YRS(Integer quot_prem_pay_yrs) {
		QUOT_PREM_PAY_YRS = quot_prem_pay_yrs;
	}

	public Date getQUOT_FM_DT() {
		return QUOT_FM_DT;
	}

	public void setQUOT_FM_DT(Date quot_fm_dt) {
		QUOT_FM_DT = quot_fm_dt;
	}

	public Date getQUOT_TO_DT() {
		return QUOT_TO_DT;
	}

	public void setQUOT_TO_DT(Date quot_to_dt) {
		QUOT_TO_DT = quot_to_dt;
	}

	public String getQUOT_CUST_TITLE() {
		return QUOT_CUST_TITLE;
	}

	public void setQUOT_CUST_TITLE(String quot_cust_title) {
		QUOT_CUST_TITLE = quot_cust_title;
	}

	public String getQUOT_CUST_NAME() {
		return QUOT_CUST_NAME;
	}

	public void setQUOT_CUST_NAME(String quot_cust_name) {
		QUOT_CUST_NAME = quot_cust_name;
	}


	public String getQUOT_CUST_ADDR1() {
		return QUOT_CUST_ADDR1;
	}

	public void setQUOT_CUST_ADDR1(String qUOT_CUST_ADDR1) {
		QUOT_CUST_ADDR1 = qUOT_CUST_ADDR1;
	}

	public String getQUOT_CUST_ADDR2() {
		return QUOT_CUST_ADDR2;
	}

	public void setQUOT_CUST_ADDR2(String qUOT_CUST_ADDR2) {
		QUOT_CUST_ADDR2 = qUOT_CUST_ADDR2;
	}

	public String getQUOT_CUST_ADDR3() {
		return QUOT_CUST_ADDR3;
	}

	public void setQUOT_CUST_ADDR3(String qUOT_CUST_ADDR3) {
		QUOT_CUST_ADDR3 = qUOT_CUST_ADDR3;
	}

	public String getQUOT_CUST_CITY() {
		return QUOT_CUST_CITY;
	}

	public void setQUOT_CUST_CITY(String quot_cust_city) {
		QUOT_CUST_CITY = quot_cust_city;
	}

	public String getQUOT_CUST_STATE() {
		return QUOT_CUST_STATE;
	}

	public void setQUOT_CUST_STATE(String quot_cust_state) {
		QUOT_CUST_STATE = quot_cust_state;
	}

	public String getQUOT_CUST_PO() {
		return QUOT_CUST_PO;
	}

	public void setQUOT_CUST_PO(String quot_cust_po) {
		QUOT_CUST_PO = quot_cust_po;
	}

	public String getQUOT_CUST_PHONE() {
		return QUOT_CUST_PHONE;
	}

	public void setQUOT_CUST_PHONE(String quot_cust_phone) {
		QUOT_CUST_PHONE = quot_cust_phone;
	}

	public String getQUOT_CUST_CONTACT() {
		return QUOT_CUST_CONTACT;
	}

	public void setQUOT_CUST_CONTACT(String quot_cust_contact) {
		QUOT_CUST_CONTACT = quot_cust_contact;
	}

	public String getQUOT_CUST_MAIL_ID() {
		return QUOT_CUST_MAIL_ID;
	}

	public void setQUOT_CUST_MAIL_ID(String quot_cust_mail_id) {
		QUOT_CUST_MAIL_ID = quot_cust_mail_id;
	}

	public String getQUOT_SRC_BUS() {
		return QUOT_SRC_BUS;
	}

	public void setQUOT_SRC_BUS(String quot_src_bus) {
		QUOT_SRC_BUS = quot_src_bus;
	}

	public String getQUOT_SRC_CODE() {
		return QUOT_SRC_CODE;
	}

	public void setQUOT_SRC_CODE(String quot_src_code) {
		QUOT_SRC_CODE = quot_src_code;
	}

	public String getQUOT_FRZ_RATE() {
		return QUOT_FRZ_RATE;
	}

	public void setQUOT_FRZ_RATE(String quot_frz_rate) {
		QUOT_FRZ_RATE = quot_frz_rate;
	}

	public String getQUOT_STATUS() {
		return QUOT_STATUS;
	}

	public void setQUOT_STATUS(String quot_status) {
		QUOT_STATUS = quot_status;
	}

	public String getQUOT_APPR_STS() {
		return QUOT_APPR_STS;
	}

	public void setQUOT_APPR_STS(String quot_appr_sts) {
		QUOT_APPR_STS = quot_appr_sts;
	}

	

	public String getQUOT_APPR_UID() {
		return QUOT_APPR_UID;
	}

	public void setQUOT_APPR_UID(String quot_appr_uid) {
		QUOT_APPR_UID = quot_appr_uid;
	}

	public Double getQUOT_FC_SA() {
		return QUOT_FC_SA;
	}

	public void setQUOT_FC_SA(Double quot_fc_sa) {
		QUOT_FC_SA = quot_fc_sa;
	}

	public Double getQUOT_LC_SA() {
		return QUOT_LC_SA;
	}

	public void setQUOT_LC_SA(Double quot_lc_sa) {
		QUOT_LC_SA = quot_lc_sa;
	}

	public Double getQUOT_FC_PREM() {
		return QUOT_FC_PREM;
	}

	public void setQUOT_FC_PREM(Double quot_fc_prem) {
		QUOT_FC_PREM = quot_fc_prem;
	}

	public Double getQUOT_LC_PREM() {
		return QUOT_LC_PREM;
	}

	public void setQUOT_LC_PREM(Double quot_lc_prem) {
		QUOT_LC_PREM = quot_lc_prem;
	}

	

	public String getQUOT_CR_UID() {
		return QUOT_CR_UID;
	}

	public void setQUOT_CR_UID(String quot_cr_uid) {
		QUOT_CR_UID = quot_cr_uid;
	}

	public String getQUOT_UPD_UID() {
		return QUOT_UPD_UID;
	}

	public void setQUOT_UPD_UID(String quot_upd_uid) {
		QUOT_UPD_UID = quot_upd_uid;
	}


	public boolean isQUOT_EXISTING_CUST_BOOLEAN() {
		return QUOT_EXISTING_CUST_BOOLEAN;
	}

	public void setQUOT_EXISTING_CUST_BOOLEAN(boolean quot_existing_cust_boolean) {
		if (quot_existing_cust_boolean == false) {
			QUOT_NEW_CUST_YN = "N";
		}else {
			QUOT_NEW_CUST_YN = "Y";
		}
		QUOT_EXISTING_CUST_BOOLEAN = quot_existing_cust_boolean;
	}

	public java.util.Date getQUOT_APPR_DT() {
		return QUOT_APPR_DT;
	}

	public void setQUOT_APPR_DT(java.util.Date quot_appr_dt) {
		QUOT_APPR_DT = quot_appr_dt;
	}

	public java.util.Date getQUOT_CR_DT() {
		return QUOT_CR_DT;
	}

	public void setQUOT_CR_DT(java.util.Date quot_cr_dt) {
		QUOT_CR_DT = quot_cr_dt;
	}

	public java.util.Date getQUOT_UPD_DT() {
		return QUOT_UPD_DT;
	}

	public void setQUOT_UPD_DT(java.util.Date quot_upd_dt) {
		QUOT_UPD_DT = quot_upd_dt;
	}

	public String getUI_QUOT_CUST_CITY_DESC() {
		return UI_QUOT_CUST_CITY_DESC;
	}

	public void setUI_QUOT_CUST_CITY_DESC(String ui_quot_cust_city_desc) {
		UI_QUOT_CUST_CITY_DESC = ui_quot_cust_city_desc;
	}

	public String getUI_QUOT_CUST_STATE_DESC() {
		return UI_QUOT_CUST_STATE_DESC;
	}

	public void setUI_QUOT_CUST_STATE_DESC(String ui_quot_cust_state_desc) {
		UI_QUOT_CUST_STATE_DESC = ui_quot_cust_state_desc;
	}

	public String getUI_QUOT_SRC_BUS_DESC() {
		return UI_QUOT_SRC_BUS_DESC;
	}

	public void setUI_QUOT_SRC_BUS_DESC(String ui_quot_src_bus_desc) {
		UI_QUOT_SRC_BUS_DESC = ui_quot_src_bus_desc;
	}

	public String getUI_QUOT_SRC_CODE_DESC() {
		return UI_QUOT_SRC_CODE_DESC;
	}

	public void setUI_QUOT_SRC_CODE_DESC(String ui_quot_src_code_desc) {
		UI_QUOT_SRC_CODE_DESC = ui_quot_src_code_desc;
	}

	
	
	private Double UI_M_QUOT_FC_TOT_PREM;
	private Double UI_M_QUOT_LC_TOT_PREM;
	private Double UI_M_QUOT_FC_TOT_LOADING;
	private Double UI_M_QUOT_LC_TOT_LOADING;
	private Double UI_M_QUOT_FC_TOT_DISCOUNT;
	private Double UI_M_QUOT_LC_TOT_DISCOUNT;
	private Double UI_M_FC_PCHARGES_BORNE_CUST;
	private Double UI_M_LC_PCHARGES_BORNE_CUST;
	private Double UI_M_POL_LC_GR_ANN_PREM;
	private Double UI_M_POL_FC_GR_ANN_PREM;
	private Double UI_M_POL_LC_MOP;
	private Double UI_M_POL_FC_MOP;
	private Double UI_M_POL_INST_LC_PREM;
	private Double UI_M_POL_INST_FC_PREM;
	private Double UI_M_POL_LC_NET_PREM;
	private Double UI_M_POL_FC_NET_PREM;
	private Double UI_M_LC_SCHARGES_BORNE_COMP;
	private Double UI_M_FC_SCHARGES_BORNE_COMP;
	private Double UI_M_LC_SCHARGES_BORNE_CUST;
	private Double UI_M_FC_SCHARGES_BORNE_CUST;
	private Double UI_M_FC_PCHARGES_BORNE_COMP;
	private Double UI_M_LC_PCHARGES_BORNE_COMP;
	


	public Double getUI_M_FC_PCHARGES_BORNE_COMP() {
		return UI_M_FC_PCHARGES_BORNE_COMP;
	}

	public void setUI_M_FC_PCHARGES_BORNE_COMP(Double uI_M_FC_PCHARGES_BORNE_COMP) {
		UI_M_FC_PCHARGES_BORNE_COMP = uI_M_FC_PCHARGES_BORNE_COMP;
	}

	public Double getUI_M_LC_PCHARGES_BORNE_COMP() {
		return UI_M_LC_PCHARGES_BORNE_COMP;
	}

	public void setUI_M_LC_PCHARGES_BORNE_COMP(Double uI_M_LC_PCHARGES_BORNE_COMP) {
		UI_M_LC_PCHARGES_BORNE_COMP = uI_M_LC_PCHARGES_BORNE_COMP;
	}

	public Double getUI_M_QUOT_FC_TOT_PREM() {
		return UI_M_QUOT_FC_TOT_PREM;
	}

	public void setUI_M_QUOT_FC_TOT_PREM(Double uI_M_QUOT_FC_TOT_PREM) {
		UI_M_QUOT_FC_TOT_PREM = uI_M_QUOT_FC_TOT_PREM;
	}

	public Double getUI_M_QUOT_LC_TOT_PREM() {
		return UI_M_QUOT_LC_TOT_PREM;
	}

	public void setUI_M_QUOT_LC_TOT_PREM(Double uI_M_QUOT_LC_TOT_PREM) {
		UI_M_QUOT_LC_TOT_PREM = uI_M_QUOT_LC_TOT_PREM;
	}

	public Double getUI_M_QUOT_FC_TOT_LOADING() {
		return UI_M_QUOT_FC_TOT_LOADING;
	}

	public void setUI_M_QUOT_FC_TOT_LOADING(Double uI_M_QUOT_FC_TOT_LOADING) {
		UI_M_QUOT_FC_TOT_LOADING = uI_M_QUOT_FC_TOT_LOADING;
	}

	public Double getUI_M_QUOT_LC_TOT_LOADING() {
		return UI_M_QUOT_LC_TOT_LOADING;
	}

	public void setUI_M_QUOT_LC_TOT_LOADING(Double uI_M_QUOT_LC_TOT_LOADING) {
		UI_M_QUOT_LC_TOT_LOADING = uI_M_QUOT_LC_TOT_LOADING;
	}

	public Double getUI_M_QUOT_FC_TOT_DISCOUNT() {
		return UI_M_QUOT_FC_TOT_DISCOUNT;
	}

	public void setUI_M_QUOT_FC_TOT_DISCOUNT(Double uI_M_QUOT_FC_TOT_DISCOUNT) {
		UI_M_QUOT_FC_TOT_DISCOUNT = uI_M_QUOT_FC_TOT_DISCOUNT;
	}

	public Double getUI_M_QUOT_LC_TOT_DISCOUNT() {
		return UI_M_QUOT_LC_TOT_DISCOUNT;
	}

	public void setUI_M_QUOT_LC_TOT_DISCOUNT(Double uI_M_QUOT_LC_TOT_DISCOUNT) {
		UI_M_QUOT_LC_TOT_DISCOUNT = uI_M_QUOT_LC_TOT_DISCOUNT;
	}

	public Double getUI_M_FC_PCHARGES_BORNE_CUST() {
		return UI_M_FC_PCHARGES_BORNE_CUST;
	}

	public void setUI_M_FC_PCHARGES_BORNE_CUST(Double uI_M_FC_PCHARGES_BORNE_CUST) {
		UI_M_FC_PCHARGES_BORNE_CUST = uI_M_FC_PCHARGES_BORNE_CUST;
	}

	public Double getUI_M_LC_PCHARGES_BORNE_CUST() {
		return UI_M_LC_PCHARGES_BORNE_CUST;
	}

	public void setUI_M_LC_PCHARGES_BORNE_CUST(Double uI_M_LC_PCHARGES_BORNE_CUST) {
		UI_M_LC_PCHARGES_BORNE_CUST = uI_M_LC_PCHARGES_BORNE_CUST;
	}

	public Double getUI_M_POL_LC_GR_ANN_PREM() {
		return UI_M_POL_LC_GR_ANN_PREM;
	}

	public void setUI_M_POL_LC_GR_ANN_PREM(Double uI_M_POL_LC_GR_ANN_PREM) {
		UI_M_POL_LC_GR_ANN_PREM = uI_M_POL_LC_GR_ANN_PREM;
	}

	public Double getUI_M_POL_FC_GR_ANN_PREM() {
		return UI_M_POL_FC_GR_ANN_PREM;
	}

	public void setUI_M_POL_FC_GR_ANN_PREM(Double uI_M_POL_FC_GR_ANN_PREM) {
		UI_M_POL_FC_GR_ANN_PREM = uI_M_POL_FC_GR_ANN_PREM;
	}

	public Double getUI_M_POL_LC_MOP() {
		return UI_M_POL_LC_MOP;
	}

	public void setUI_M_POL_LC_MOP(Double uI_M_POL_LC_MOP) {
		UI_M_POL_LC_MOP = uI_M_POL_LC_MOP;
	}

	public Double getUI_M_POL_FC_MOP() {
		return UI_M_POL_FC_MOP;
	}

	public void setUI_M_POL_FC_MOP(Double uI_M_POL_FC_MOP) {
		UI_M_POL_FC_MOP = uI_M_POL_FC_MOP;
	}

	public Double getUI_M_POL_INST_LC_PREM() {
		return UI_M_POL_INST_LC_PREM;
	}

	public void setUI_M_POL_INST_LC_PREM(Double uI_M_POL_INST_LC_PREM) {
		UI_M_POL_INST_LC_PREM = uI_M_POL_INST_LC_PREM;
	}

	public Double getUI_M_POL_INST_FC_PREM() {
		return UI_M_POL_INST_FC_PREM;
	}

	public void setUI_M_POL_INST_FC_PREM(Double uI_M_POL_INST_FC_PREM) {
		UI_M_POL_INST_FC_PREM = uI_M_POL_INST_FC_PREM;
	}

	public Double getUI_M_POL_LC_NET_PREM() {
		return UI_M_POL_LC_NET_PREM;
	}

	public void setUI_M_POL_LC_NET_PREM(Double uI_M_POL_LC_NET_PREM) {
		UI_M_POL_LC_NET_PREM = uI_M_POL_LC_NET_PREM;
	}

	public Double getUI_M_POL_FC_NET_PREM() {
		return UI_M_POL_FC_NET_PREM;
	}

	public void setUI_M_POL_FC_NET_PREM(Double uI_M_POL_FC_NET_PREM) {
		UI_M_POL_FC_NET_PREM = uI_M_POL_FC_NET_PREM;
	}

	public Double getUI_M_LC_SCHARGES_BORNE_COMP() {
		return UI_M_LC_SCHARGES_BORNE_COMP;
	}

	public void setUI_M_LC_SCHARGES_BORNE_COMP(Double uI_M_LC_SCHARGES_BORNE_COMP) {
		UI_M_LC_SCHARGES_BORNE_COMP = uI_M_LC_SCHARGES_BORNE_COMP;
	}

	public Double getUI_M_FC_SCHARGES_BORNE_COMP() {
		return UI_M_FC_SCHARGES_BORNE_COMP;
	}

	public void setUI_M_FC_SCHARGES_BORNE_COMP(Double uI_M_FC_SCHARGES_BORNE_COMP) {
		UI_M_FC_SCHARGES_BORNE_COMP = uI_M_FC_SCHARGES_BORNE_COMP;
	}

	public Double getUI_M_LC_SCHARGES_BORNE_CUST() {
		return UI_M_LC_SCHARGES_BORNE_CUST;
	}

	public void setUI_M_LC_SCHARGES_BORNE_CUST(Double uI_M_LC_SCHARGES_BORNE_CUST) {
		UI_M_LC_SCHARGES_BORNE_CUST = uI_M_LC_SCHARGES_BORNE_CUST;
	}

	public Double getUI_M_FC_SCHARGES_BORNE_CUST() {
		return UI_M_FC_SCHARGES_BORNE_CUST;
	}

	public void setUI_M_FC_SCHARGES_BORNE_CUST(Double uI_M_FC_SCHARGES_BORNE_CUST) {
		UI_M_FC_SCHARGES_BORNE_CUST = uI_M_FC_SCHARGES_BORNE_CUST;
	}
	
	
	
	
	
	@Column(name="QUOT_MED_YN")
	private String QUOT_MED_YN;
	
	Boolean QUOT_MEDICAL_YN_FLAG;

	
	public String getQUOT_MED_YN() {
		return QUOT_MED_YN;
	}

	public void setQUOT_MED_YN(String qUOT_MED_YN) {
		QUOT_MED_YN = qUOT_MED_YN;
	}

	public Boolean getQUOT_MEDICAL_YN_FLAG() {
		return QUOT_MEDICAL_YN_FLAG;
	}

	public void setQUOT_MEDICAL_YN_FLAG(Boolean qUOT_MEDICAL_YN_FLAG) {
		QUOT_MEDICAL_YN_FLAG = qUOT_MEDICAL_YN_FLAG;
	}

	public Double getQUOT_EMR_RATE() {
		return QUOT_EMR_RATE;
	}

	public void setQUOT_EMR_RATE(Double qUOT_EMR_RATE) {
		QUOT_EMR_RATE = qUOT_EMR_RATE;
	}
	
	/*Added by Ram on 20/11/2016 for BankCode value setting*/
	@Column(name="QUOT_BANK_CODE")
	private String QUOT_BANK_CODE_ORI;

	public String getQUOT_BANK_CODE_ORI() {
		return QUOT_BANK_CODE_ORI;
	}

	public void setQUOT_BANK_CODE_ORI(String qUOT_BANK_CODE_ORI) {
		QUOT_BANK_CODE_ORI = qUOT_BANK_CODE_ORI;
	}
	
	/*End*/
	
	
	
	
	/*Added by Ram on 17/11/2016 for Adding Remarks field */
	private boolean QUOT_MED_REC_YN_CHK;
	
	@Column(name="QUOT_MED_REMARKS")
	private String QUOT_MED_REMARKS;
	
	@Column(name="QUOT_MED_REC_YN")
	private int QUOT_MED_REC_YN;
 
	public boolean isQUOT_MED_REC_YN_CHK() {
		return QUOT_MED_REC_YN_CHK;
	}

	public void setQUOT_MED_REC_YN_CHK(boolean qUOT_MED_REC_YN_CHK) {
		QUOT_MED_REC_YN_CHK = qUOT_MED_REC_YN_CHK;
		if(qUOT_MED_REC_YN_CHK)
		{
			setQUOT_MED_REC_YN(1);
		}
		else
		{
			setQUOT_MED_REC_YN(0);
		}
	}

	public String getQUOT_MED_REMARKS() {
		return QUOT_MED_REMARKS;
	}

	public void setQUOT_MED_REMARKS(String qUOT_MED_REMARKS) {
		QUOT_MED_REMARKS = qUOT_MED_REMARKS;
	}

	public int getQUOT_MED_REC_YN() {
		return QUOT_MED_REC_YN;
	}

	public void setQUOT_MED_REC_YN(int qUOT_MED_REC_YN) {
		QUOT_MED_REC_YN = qUOT_MED_REC_YN;
		 
	}
	
	/*End*/
	/*Added by Ram on 30/12/2016 for Existing customer validation*/
	private int EXISTING_COUNT;
	private String EXIST_QUOT_NO;
	
	public int getEXISTING_COUNT() {
		return EXISTING_COUNT;
	}

	public void setEXISTING_COUNT(int eXISTING_COUNT) {
		EXISTING_COUNT = eXISTING_COUNT;
	}

	public String getEXIST_QUOT_NO() {
		return EXIST_QUOT_NO;
	}

	public void setEXIST_QUOT_NO(String eXIST_QUOT_NO) {
		EXIST_QUOT_NO = eXIST_QUOT_NO;
	}
	/*End*/
	
	
	/* Added by ganesh on 11-04-2017 for decline functionality */
	@Column(name="QUOT_DEC_RSN_CODE")
	private String UI_M_QQS_STATUS;

	public String getUI_M_QQS_STATUS() {
		return UI_M_QQS_STATUS;
	}

	public void setUI_M_QQS_STATUS(String uI_M_QQS_STATUS) {
		UI_M_QQS_STATUS = uI_M_QQS_STATUS;
	} 
	
	public String getUI_M_QQT_ADDL_STATUS_DESC() {
		return UI_M_QQT_ADDL_STATUS_DESC;
	}

	public void setUI_M_QQT_ADDL_STATUS_DESC(String uI_M_QQT_ADDL_STATUS_DESC) {
		UI_M_QQT_ADDL_STATUS_DESC = uI_M_QQT_ADDL_STATUS_DESC;
	}

	
	private String UI_M_QQT_ADDL_STATUS_DESC;
	
	@Column(name="QUOT_DEC_REMARKS")
	private String UI_M_QQT_REMARKS;

	public String getUI_M_QQT_REMARKS() {
		return UI_M_QQT_REMARKS;
	}

	public void setUI_M_QQT_REMARKS(String uI_M_QQT_REMARKS) {
		UI_M_QQT_REMARKS = uI_M_QQT_REMARKS;
	}
	
	@Column(name="QUOT_DEC_DATE")
	private String QUOT_DEC_DATE;

	public String getQUOT_DEC_DATE() {
		return QUOT_DEC_DATE;
	}

	public void setQUOT_DEC_DATE(String qUOT_DEC_DATE) {
		QUOT_DEC_DATE = qUOT_DEC_DATE;
	}
	
/*	END*/


	}


