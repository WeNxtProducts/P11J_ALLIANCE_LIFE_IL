package com.iii.pel.forms.PILT002_APAC_QE;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name = "PM_CUSTOMER")

public class PM_CUSTOMER extends BaseValueBean {
	
		// Dummy variables
		private String UI_M_NGS_CODE;
		private int UI_M_PS_VALUE_1;
		private String UI_M_CUST_CODE_YN;
		private String UI_M_PM_CUSTOMER_CF;
		private String UI_I_PM_CUST_COMM_CF;
		private String UI_I_PM_CUST_SUB_CLASS_CF;
		private String UI_I_PM_CUST_DIVN_CF;
		private String UI_I_PM_CUST_SC_COMM_CF;
		private String UI_I_PM_CUST_CURR_CF;
		private String UI_I_PM_CUST_APPL_AGENT_CF;
		private String UI_I_PM_BROK_LIC_RENEW_DTLS_CF;
		private String UI_M_ADDL_STATUS;
		private String UI_M_CUST_INDV_REQD;
		private String UI_M_CUST_TYPE;

		private String UI_M_SRC_BUS_NAME;
		private String UI_M_LINK_DESC;
		private String UI_M_DFLT_BRK_DESC;
		private String UI_M_CUST_OCC_DESC;
		private String UI_M_CUST_GROUP_DESC;
		private String UI_M_CUST_CCLAS_DESC;
		private String UI_M_CUST_CATG_CODE_DESC;
		private String UI_M_CUST_MAR_STATUS_DESC;
		private String UI_M_CUST_NATIONALITY_CODE_DESC;
		private String UI_M_CUST_RELIGION_DESC;
		private String UI_M_CUST_RACE_DESC;
		private String UI_M_CUST_HANDLER_ID_DESC;
		private String UI_M_CUST_COUNT_CODE_DESC;
		private String UI_M_CUST_POSTAL_CODE_DESC;
		private String UI_M_CUST_CITY_CODE_DESC;
		private String UI_M_CUST_STATE_CODE_DESC;
		private String UI_M_CUST_FREEZE_STATUS;
		
		@Id
		@Column(name = "ROWID")
		private String ROWID;

		@Column(name = "CUST_CODE")
		private String CUST_CODE;
		@Column(name = "CUST_CLASS")
		private String CUST_CLASS;
		@Column(name = "CUST_NAME")
		private String CUST_NAME;
		@Column(name = "CUST_SHORT_NAME")
		private String CUST_SHORT_NAME;
		@Column(name = "CUST_ADDR1")
		private String CUST_ADDR1;
		@Column(name = "CUST_ADDR2")
		private String CUST_ADDR2;
		@Column(name = "CUST_ADDR3")
		private String CUST_ADDR3;
		@Column(name = "CUST_CONTACT")
		private String CUST_CONTACT;
		@Column(name = "CUST_CONTACT2")
		private String CUST_CONTACT2;
		@Column(name = "CUST_PHONE")
		private String CUST_PHONE;
		@Column(name = "CUST_FAX")
		private String CUST_FAX;
		@Column(name = "CUST_AREA")
		private String CUST_AREA;
		@Column(name = "CUST_REGION")
		private String CUST_REGION;
		@Column(name = "CUST_COUNTRY")
		private String CUST_COUNTRY;
		@Column(name = "CUST_DFLT_BRK_CODE")
		private String CUST_DFLT_BRK_CODE;
		@Column(name = "CUST_BL_NAME")
		private String CUST_BL_NAME;
		@Column(name = "CUST_BL_SHORT_NAME")
		private String CUST_BL_SHORT_NAME;
		@Column(name = "CUST_BL_ADDR1")
		private String CUST_BL_ADDR1;
		@Column(name = "CUST_BL_ADDR2")
		private String CUST_BL_ADDR2;
		@Column(name = "CUST_BL_ADDR3")
		private String CUST_BL_ADDR3;
		@Column(name = "CUST_BL_CONTACT")
		private String CUST_BL_CONTACT;
		@Column(name = "CUST_BL_CONTACT2")
		private String CUST_BL_CONTACT2;
		@Column(name = "CUST_BL_AREA")
		private String CUST_BL_AREA;
		@Column(name = "CUST_BL_REGION")
		private String CUST_BL_REGION;
		@Column(name = "CUST_BL_COUNTRY")
		private String CUST_BL_COUNTRY;
		@Column(name = "CUST_FRZ_FLAG")
		private String CUST_FRZ_FLAG;
		
		// added to resolve boolen conversion for selectBooleanCheck
		private boolean CUST_FRZ_FLAG_UI = false;
		
		@Column(name = "CUST_CR_DT")
		private Date CUST_CR_DT;
		@Column(name = "CUST_CR_UID")
		private String CUST_CR_UID;
		@Column(name = "CUST_UPD_DT")
		private Date CUST_UPD_DT;
		@Column(name = "CUST_UPD_UID")
		private String CUST_UPD_UID;
		@Column(name = "CUST_CREDIT_LIMIT")
		private Double CUST_CREDIT_LIMIT;
		@Column(name = "CUST_CREDIT_CHECK_YN")
		private String CUST_CREDIT_CHECK_YN;
		@Column(name = "CUST_EMAIL_ID_PER")
		private String CUST_EMAIL_ID_PER;
		@Column(name = "CUST_EMAIL_ID_OFF")
		private String CUST_EMAIL_ID_OFF;
		@Column(name = "CUST_COMP_HOME_PAGE")
		private String CUST_COMP_HOME_PAGE;
		@Column(name = "CUST_ID")
		private String CUST_ID;
		@Column(name = "CUST_PIN_NUMBER")
		private String CUST_PIN_NUMBER;
		@Column(name = "CUST_TAX_STATUS")
		private String CUST_TAX_STATUS;
		@Column(name = "CUST_COMMUN_MODE")
		private String CUST_COMMUN_MODE;
		@Column(name = "CUST_STREET")
		private String CUST_STREET;
		@Column(name = "CUST_BUILDING")
		private String CUST_BUILDING;
		@Column(name = "CUST_FLOOR")
		private String CUST_FLOOR;
		@Column(name = "CUST_OFFICE_PHONE")
		private String CUST_OFFICE_PHONE;
		@Column(name = "CUST_GROUP_CODE")
		private String CUST_GROUP_CODE;
		@Column(name = "CUST_PHY_ADDR1")
		private String CUST_PHY_ADDR1;
		@Column(name = "CUST_PHY_ADDR2")
		private String CUST_PHY_ADDR2;
		@Column(name = "CUST_PHY_ADDR3")
		private String CUST_PHY_ADDR3;
		@Column(name = "CUST_PHY_CONTACT")
		private String CUST_PHY_CONTACT;
		@Column(name = "CUST_PHY_CONTACT2")
		private String CUST_PHY_CONTACT2;
		@Column(name = "CUST_PHY_PHONE")
		private String CUST_PHY_PHONE;
		@Column(name = "CUST_PHY_FAX")
		private String CUST_PHY_FAX;
		@Column(name = "CUST_PHY_AREA")
		private String CUST_PHY_AREA;
		@Column(name = "CUST_PHY_REGION")
		private String CUST_PHY_REGION;
		@Column(name = "CUST_PHY_COUNTRY")
		private String CUST_PHY_COUNTRY;
		@Column(name = "CUST_CREDIT_DAYS")
		private int CUST_CREDIT_DAYS;
		@Column(name = "CUST_OCC_CODE")
		private String CUST_OCC_CODE;
		@Column(name = "CUST_POST_BOX_NO")
		private String CUST_POST_BOX_NO;
		@Column(name = "CUST_BROKER_CASH_BASIS_YN")
		private String CUST_BROKER_CASH_BASIS_YN="N";
		@Column(name = "CUST_SRC_BUS")
		private String CUST_SRC_BUS;
		@Column(name = "CUST_CONTRACTED_YN")
		private String CUST_CONTRACTED_YN;
		@Column(name = "CUST_MEDEX_LIMIT")
		private Double CUST_MEDEX_LIMIT;
		@Column(name = "CUST_LINK_AGENT_CODE")
		private String CUST_LINK_AGENT_CODE;
		@Column(name = "CUST_MOBILE_NO")
		private String CUST_MOBILE_NO;
		@Column(name = "CUST_QUALFN")
		private String CUST_QUALFN;
		@Column(name = "CUST_EFF_FM_DT")
		private Date CUST_EFF_FM_DT;
		@Column(name = "CUST_EFF_TO_DT")
		private Date CUST_EFF_TO_DT;
		@Column(name = "CUST_CR_ASSR_YN")
		private String CUST_CR_ASSR_YN;
		@Column(name = "CUST_TYPE")
		private String CUST_TYPE;
		@Column(name = "CUST_REF_ID1")
		private String CUST_REF_ID1;
		@Column(name = "CUST_REF_ID2")
		private String CUST_REF_ID2;
		@Column(name = "CUST_TEL_AREA_CODE")
		private String CUST_TEL_AREA_CODE;
		@Column(name = "CUST_PHY_TEL_AREA_CODE")
		private String CUST_PHY_TEL_AREA_CODE;
		@Column(name = "CUST_FAX_AREA_CODE")
		private String CUST_FAX_AREA_CODE;
		@Column(name = "CUST_PREFERRED_LANG")
		private String CUST_PREFERRED_LANG;
		@Column(name = "CUST_DOB")
		private Date CUST_DOB;
		@Column(name = "CUST_CATG_CODE")
		private String CUST_CATG_CODE;
		@Column(name = "CUST_NATIONALITY_CODE")
		private String CUST_NATIONALITY_CODE;
		@Column(name = "CUST_RACE")
		private String CUST_RACE;
		@Column(name = "CUST_MAR_STATUS")
		private String CUST_MAR_STATUS;
		@Column(name = "CUST_SALUTATION")
		private String CUST_SALUTATION;
		@Column(name = "CUST_BIRTH_CERT_NO")
		private String CUST_BIRTH_CERT_NO;
		@Column(name = "CUST_BANK_NAME")
		private String CUST_BANK_NAME;
		@Column(name = "CUST_BANK_AC_NO")
		private String CUST_BANK_AC_NO;
		@Column(name = "CUST_RELIGION")
		private String CUST_RELIGION;
		@Column(name = "CUST_POSTAL_CODE")
		private String CUST_POSTAL_CODE;
		@Column(name = "CUST_CITY")
		private String CUST_CITY;
		@Column(name = "CUST_STATE")
		private String CUST_STATE;
		@Column(name = "CUST_TITLE")
		private String CUST_TITLE;
		@Column(name = "CUST_COUNT_CODE")
		private String CUST_COUNT_CODE;
		@Column(name = "CUST_POST_CODE")
		private String CUST_POST_CODE;
		@Column(name = "CUST_CITY_CODE")
		private String CUST_CITY_CODE;
		@Column(name = "CUST_STATE_CODE")
		private String CUST_STATE_CODE;
		@Column(name = "CUST_SPOUSE_NAME")
		private String CUST_SPOUSE_NAME;
		@Column(name = "CUST_QUALFN_2")
		private String CUST_QUALFN_2;
		@Column(name = "CUST_NO_DEPDN")
		private Double CUST_NO_DEPDN;
		@Column(name = "CUST_INCOME_TAX_FILE_NO")
		private String CUST_INCOME_TAX_FILE_NO;
		@Column(name = "CUST_ALT_PAYEE_NAME")
		private String CUST_ALT_PAYEE_NAME;
		@Column(name = "CUST_ALT_PAYEE_AC_NO")
		private String CUST_ALT_PAYEE_AC_NO;
		@Column(name = "CUST_BANK_CODE")
		private String CUST_BANK_CODE;
		@Column(name = "CUST_INSURED_ID")
		private String CUST_INSURED_ID;
		@Column(name = "CUST_ALL_CURR_APPL_YN")
		private String CUST_ALL_CURR_APPL_YN;
		@Column(name = "CUST_MKT_CODE")
		private String CUST_MKT_CODE;
		@Column(name = "CUST_UNIT_CODE")
		private String CUST_UNIT_CODE;
		@Column(name = "CUST_AGENCY_CODE")
		private String CUST_AGENCY_CODE;
		@Column(name = "CUST_AGENCY_BRANCH_CODE")
		private String CUST_AGENCY_BRANCH_CODE;
		@Column(name = "CUST_REGION_CODE")
		private String CUST_REGION_CODE;
		@Column(name = "CUST_AGENCY_NAME")
		private String CUST_AGENCY_NAME;
		@Column(name = "CUST_AGENT_RANK_CODE")
		private String CUST_AGENT_RANK_CODE;
		@Column(name = "CUST_RECRUITER_CODE")
		private String CUST_RECRUITER_CODE;
		@Column(name = "CUST_INTRODUCER_CODE")
		private String CUST_INTRODUCER_CODE;
		@Column(name = "CUST_MIN_NO_OF_POL")
		private Double CUST_MIN_NO_OF_POL;
		@Column(name = "CUST_MIN_LC_PERS_CONT")
		private Double CUST_MIN_LC_PERS_CONT;
		@Column(name = "CUST_BUDGET_LC_PREM")
		private Double CUST_BUDGET_LC_PREM;
		@Column(name = "CUST_LC_SUM_ASSURED")
		private Double CUST_LC_SUM_ASSURED;
		@Column(name = "CUST_FIRST_NAME")
		private String CUST_FIRST_NAME;
		@Column(name = "CUST_SURNAME")
		private String CUST_SURNAME;
		@Column(name = "CUST_MIDDLE_NAME")
		private String CUST_MIDDLE_NAME;
		@Column(name = "CUST_LONG_NAME")
		private String CUST_LONG_NAME;
		@Column(name = "CUST_STATUS")
		private String CUST_STATUS;
		@Column(name = "CUST_INTEREST_RATE")
		private Double CUST_INTEREST_RATE;
		@Column(name = "CUST_AUTO_DEBIT_AVBL_YN")
		private String CUST_AUTO_DEBIT_AVBL_YN;
		@Column(name = "CUST_COMP_REGN_NO")
		private String CUST_COMP_REGN_NO;
		@Column(name = "CUST_PIAM_AGENCY_CODE")
		private String CUST_PIAM_AGENCY_CODE;
		@Column(name = "CUST_PASS_NO")
		private String CUST_PASS_NO;
		@Column(name = "CUST_CPF_NO")
		private String CUST_CPF_NO;
		@Column(name = "CUST_CBC_YN")
		private String CUST_CBC_YN;
		@Column(name = "CUST_ROC_NO")
		private String CUST_ROC_NO;
		@Column(name = "CUST_CLAIM_EXP")
		private String CUST_CLAIM_EXP;
		@Column(name = "CUST_DRV_EXP")
		private Double CUST_DRV_EXP;
		@Column(name = "CUST_GUARANTEE_LIMIT")
		private Double CUST_GUARANTEE_LIMIT;
		@Column(name = "CUST_MATRIX_PROD_APPBL_YN")
		private String CUST_MATRIX_PROD_APPBL_YN;
		private boolean CUST_MATRIX_PROD_APPBL_YN_UI; 
		@Column(name = "CUST_CONTACT3")
		private String CUST_CONTACT3;
		@Column(name = "CUST_CONTACT1_LIC_NO")
		private String CUST_CONTACT1_LIC_NO;
		@Column(name = "CUST_CONTACT2_LIC_NO")
		private String CUST_CONTACT2_LIC_NO;
		@Column(name = "CUST_CONTACT3_LIC_NO")
		private String CUST_CONTACT3_LIC_NO;
		@Column(name = "CUST_CLM_CONTACT")
		private String CUST_CLM_CONTACT;
		@Column(name = "CUST_CLM_CONTACT_LIC_NO")
		private String CUST_CLM_CONTACT_LIC_NO;
		@Column(name = "CUST_ACNT_CONTACT")
		private String CUST_ACNT_CONTACT;
		@Column(name = "CUST_ACNT_CONTACT_LIC_NO")
		private String CUST_ACNT_CONTACT_LIC_NO;
		@Column(name = "CUST_TEL_AREA_CODE2")
		private String CUST_TEL_AREA_CODE2;
		@Column(name = "CUST_TEL_AREA_CODE3")
		private String CUST_TEL_AREA_CODE3;
		@Column(name = "CUST_PHONE2")
		private String CUST_PHONE2;
		@Column(name = "CUST_PHONE3")
		private String CUST_PHONE3;
		@Column(name = "CUST_FAX_AREA_CODE2")
		private String CUST_FAX_AREA_CODE2;
		@Column(name = "CUST_FAX_AREA_CODE3")
		private String CUST_FAX_AREA_CODE3;
		@Column(name = "CUST_FAX2")
		private String CUST_FAX2;
		@Column(name = "CUST_FAX3")
		private String CUST_FAX3;
		@Column(name = "CUST_TRANSFER_TO")
		private String CUST_TRANSFER_TO;
		@Column(name = "CUST_AGENT_TO")
		private String CUST_AGENT_TO;
		@Column(name = "CUST_AGENT_EFF_FM_DT")
		private Date CUST_AGENT_EFF_FM_DT;
		@Column(name = "CUST_AGENT_EFF_TO_DT")
		private Date CUST_AGENT_EFF_TO_DT;
		@Column(name = "CUST_SUPP_COMM_APBL_YN")
		private String CUST_SUPP_COMM_APBL_YN;
		@Column(name = "CUST_LCN_NO")
		private String CUST_LCN_NO;
		@Column(name = "CUST_LIC_START_DT")
		private Date CUST_LIC_START_DT;
		@Column(name = "CUST_LIC_END_DT")
		private Date CUST_LIC_END_DT;
		@Column(name = "CUST_LCN_REG_DT")
		private Date CUST_LCN_REG_DT;
		@Column(name = "CUST_LCN_STATUS")
		private String CUST_LCN_STATUS;
		@Column(name = "CUST_HANDLER_ID")
		private String CUST_HANDLER_ID;
		@Column(name = "CUST_AD_ACC_NO")
		private String CUST_AD_ACC_NO;
		@Column(name = "CUST_AD_BANK_CODE")
		private String CUST_AD_BANK_CODE;
		@Column(name = "CUST_BLACK_LIST_COUNT")
		private Double CUST_BLACK_LIST_COUNT;
		@Column(name = "CUST_CLE_ZONE_CODE")
		private String CUST_CLE_ZONE_CODE;
		@Column(name = "CUST_CONTU_PAYMENT_YN")
		private String CUST_CONTU_PAYMENT_YN;
		@Column(name = "CUST_DES_MTD_CODE")
		private String CUST_DES_MTD_CODE;
		@Column(name = "CUST_INTREST_RATE")
		private Double CUST_INTREST_RATE;
		@Column(name = "CUST_PYMT_TYPE")
		private String CUST_PYMT_TYPE;
		@Column(name = "CUST_IC_TYPE")
		private String CUST_IC_TYPE;
		@Column(name = "CUST_STATE_DESC")
		private String CUST_STATE_DESC;
		@Column(name = "CUST_POSTAL_DESC")
		private String CUST_POSTAL_DESC;
		@Column(name = "CUST_COD_REQD_YN")
		private String CUST_COD_REQD_YN;
		@Column(name = "CUST_APPL_ALL_BRAN_YN")
		private String CUST_APPL_ALL_BRAN_YN;
		private String UI_M_CUST_CUST_SALUTATION_DESC;
		
		
		//FRG flag
		private boolean FRZ_FLAG = false;


		public boolean isFRZ_FLAG() {
			return FRZ_FLAG;
		}

		public void setFRZ_FLAG(boolean frz_flag) {
			FRZ_FLAG = frz_flag;
			
			if(FRZ_FLAG){
				CUST_FRZ_FLAG="Y";
			}else
				CUST_FRZ_FLAG="N";
		}
		
		
		public String getUI_M_CUST_CUST_SALUTATION_DESC() {
			return UI_M_CUST_CUST_SALUTATION_DESC;
		}
		public void setUI_M_CUST_CUST_SALUTATION_DESC(
				String ui_m_cust_cust_salutation_desc) {
			UI_M_CUST_CUST_SALUTATION_DESC = ui_m_cust_cust_salutation_desc;
		}
		public String getUI_M_NGS_CODE() {
			return UI_M_NGS_CODE;
		}
		public void setUI_M_NGS_CODE(String ui_m_ngs_code) {
			UI_M_NGS_CODE = ui_m_ngs_code;
		}
		public int getUI_M_PS_VALUE_1() {
			return UI_M_PS_VALUE_1;
		}
		public void setUI_M_PS_VALUE_1(int ui_m_ps_value_1) {
			UI_M_PS_VALUE_1 = ui_m_ps_value_1;
		}
		public String getUI_M_CUST_CODE_YN() {
			return UI_M_CUST_CODE_YN;
		}
		public void setUI_M_CUST_CODE_YN(String ui_m_cust_code_yn) {
			UI_M_CUST_CODE_YN = ui_m_cust_code_yn;
		}
		public String getUI_M_PM_CUSTOMER_CF() {
			return UI_M_PM_CUSTOMER_CF;
		}
		public void setUI_M_PM_CUSTOMER_CF(String ui_m_pm_customer_cf) {
			UI_M_PM_CUSTOMER_CF = ui_m_pm_customer_cf;
		}
		public String getUI_I_PM_CUST_COMM_CF() {
			return UI_I_PM_CUST_COMM_CF;
		}
		public void setUI_I_PM_CUST_COMM_CF(String ui_i_pm_cust_comm_cf) {
			UI_I_PM_CUST_COMM_CF = ui_i_pm_cust_comm_cf;
		}
		public String getUI_I_PM_CUST_SUB_CLASS_CF() {
			return UI_I_PM_CUST_SUB_CLASS_CF;
		}
		public void setUI_I_PM_CUST_SUB_CLASS_CF(String ui_i_pm_cust_sub_class_cf) {
			UI_I_PM_CUST_SUB_CLASS_CF = ui_i_pm_cust_sub_class_cf;
		}
		public String getUI_I_PM_CUST_DIVN_CF() {
			return UI_I_PM_CUST_DIVN_CF;
		}
		public void setUI_I_PM_CUST_DIVN_CF(String ui_i_pm_cust_divn_cf) {
			UI_I_PM_CUST_DIVN_CF = ui_i_pm_cust_divn_cf;
		}
		public String getUI_I_PM_CUST_SC_COMM_CF() {
			return UI_I_PM_CUST_SC_COMM_CF;
		}
		public void setUI_I_PM_CUST_SC_COMM_CF(String ui_i_pm_cust_sc_comm_cf) {
			UI_I_PM_CUST_SC_COMM_CF = ui_i_pm_cust_sc_comm_cf;
		}
		public String getUI_I_PM_CUST_CURR_CF() {
			return UI_I_PM_CUST_CURR_CF;
		}
		public void setUI_I_PM_CUST_CURR_CF(String ui_i_pm_cust_curr_cf) {
			UI_I_PM_CUST_CURR_CF = ui_i_pm_cust_curr_cf;
		}
		public String getUI_I_PM_CUST_APPL_AGENT_CF() {
			return UI_I_PM_CUST_APPL_AGENT_CF;
		}
		public void setUI_I_PM_CUST_APPL_AGENT_CF(String ui_i_pm_cust_appl_agent_cf) {
			UI_I_PM_CUST_APPL_AGENT_CF = ui_i_pm_cust_appl_agent_cf;
		}
		public String getUI_I_PM_BROK_LIC_RENEW_DTLS_CF() {
			return UI_I_PM_BROK_LIC_RENEW_DTLS_CF;
		}
		public void setUI_I_PM_BROK_LIC_RENEW_DTLS_CF(
				String ui_i_pm_brok_lic_renew_dtls_cf) {
			UI_I_PM_BROK_LIC_RENEW_DTLS_CF = ui_i_pm_brok_lic_renew_dtls_cf;
		}
		public String getUI_M_ADDL_STATUS() {
			return UI_M_ADDL_STATUS;
		}
		public void setUI_M_ADDL_STATUS(String ui_m_addl_status) {
			UI_M_ADDL_STATUS = ui_m_addl_status;
		}
		public String getUI_M_CUST_INDV_REQD() {
			return UI_M_CUST_INDV_REQD;
		}
		public void setUI_M_CUST_INDV_REQD(String ui_m_cust_indv_reqd) {
			UI_M_CUST_INDV_REQD = ui_m_cust_indv_reqd;
		}
		public String getUI_M_SRC_BUS_NAME() {
			return UI_M_SRC_BUS_NAME;
		}
		public void setUI_M_SRC_BUS_NAME(String ui_m_src_bus_name) {
			UI_M_SRC_BUS_NAME = ui_m_src_bus_name;
		}
		public String getUI_M_LINK_DESC() {
			return UI_M_LINK_DESC;
		}
		public void setUI_M_LINK_DESC(String ui_m_link_desc) {
			UI_M_LINK_DESC = ui_m_link_desc;
		}
		public String getUI_M_DFLT_BRK_DESC() {
			return UI_M_DFLT_BRK_DESC;
		}
		public void setUI_M_DFLT_BRK_DESC(String ui_m_dflt_brk_desc) {
			UI_M_DFLT_BRK_DESC = ui_m_dflt_brk_desc;
		}
		public String getUI_M_CUST_OCC_DESC() {
			return UI_M_CUST_OCC_DESC;
		}
		public void setUI_M_CUST_OCC_DESC(String ui_m_cust_occ_desc) {
			UI_M_CUST_OCC_DESC = ui_m_cust_occ_desc;
		}
		public String getUI_M_CUST_GROUP_DESC() {
			return UI_M_CUST_GROUP_DESC;
		}
		public void setUI_M_CUST_GROUP_DESC(String ui_m_cust_group_desc) {
			UI_M_CUST_GROUP_DESC = ui_m_cust_group_desc;
		}
		public String getUI_M_CUST_CCLAS_DESC() {
			return UI_M_CUST_CCLAS_DESC;
		}
		public void setUI_M_CUST_CCLAS_DESC(String ui_m_cust_cclas_desc) {
			UI_M_CUST_CCLAS_DESC = ui_m_cust_cclas_desc;
		}
		public String getUI_M_CUST_CATG_CODE_DESC() {
			return UI_M_CUST_CATG_CODE_DESC;
		}
		public void setUI_M_CUST_CATG_CODE_DESC(String ui_m_cust_catg_code_desc) {
			UI_M_CUST_CATG_CODE_DESC = ui_m_cust_catg_code_desc;
		}
		public String getUI_M_CUST_MAR_STATUS_DESC() {
			return UI_M_CUST_MAR_STATUS_DESC;
		}
		public void setUI_M_CUST_MAR_STATUS_DESC(String ui_m_cust_mar_status_desc) {
			UI_M_CUST_MAR_STATUS_DESC = ui_m_cust_mar_status_desc;
		}
		public String getUI_M_CUST_NATIONALITY_CODE_DESC() {
			return UI_M_CUST_NATIONALITY_CODE_DESC;
		}
		public void setUI_M_CUST_NATIONALITY_CODE_DESC(
				String ui_m_cust_nationality_code_desc) {
			UI_M_CUST_NATIONALITY_CODE_DESC = ui_m_cust_nationality_code_desc;
		}
		public String getUI_M_CUST_RELIGION_DESC() {
			return UI_M_CUST_RELIGION_DESC;
		}
		public void setUI_M_CUST_RELIGION_DESC(String ui_m_cust_religion_desc) {
			UI_M_CUST_RELIGION_DESC = ui_m_cust_religion_desc;
		}
		public String getUI_M_CUST_RACE_DESC() {
			return UI_M_CUST_RACE_DESC;
		}
		public void setUI_M_CUST_RACE_DESC(String ui_m_cust_race_desc) {
			UI_M_CUST_RACE_DESC = ui_m_cust_race_desc;
		}
		public String getUI_M_CUST_HANDLER_ID_DESC() {
			return UI_M_CUST_HANDLER_ID_DESC;
		}
		public void setUI_M_CUST_HANDLER_ID_DESC(String ui_m_cust_handler_id_desc) {
			UI_M_CUST_HANDLER_ID_DESC = ui_m_cust_handler_id_desc;
		}
		public String getROWID() {
			return ROWID;
		}
		public void setROWID(String rowid) {
			ROWID = rowid;
		}
		public String getCUST_CODE() {
			return CUST_CODE;
		}
		public void setCUST_CODE(String cust_code) {
			CUST_CODE = cust_code;
		}
		public String getCUST_CLASS() {
			return CUST_CLASS;
		}
		public void setCUST_CLASS(String cust_class) {
			CUST_CLASS = cust_class;
		}
		public String getCUST_NAME() {
			return CUST_NAME;
		}
		public void setCUST_NAME(String cust_name) {
			CUST_NAME = cust_name;
		}
		public String getCUST_SHORT_NAME() {
			return CUST_SHORT_NAME;
		}
		public void setCUST_SHORT_NAME(String cust_short_name) {
			CUST_SHORT_NAME = cust_short_name;
		}
		public String getCUST_ADDR1() {
			return CUST_ADDR1;
		}
		public void setCUST_ADDR1(String cust_addr1) {
			CUST_ADDR1 = cust_addr1;
		}
		public String getCUST_ADDR2() {
			return CUST_ADDR2;
		}
		public void setCUST_ADDR2(String cust_addr2) {
			CUST_ADDR2 = cust_addr2;
		}
		public String getCUST_ADDR3() {
			return CUST_ADDR3;
		}
		public void setCUST_ADDR3(String cust_addr3) {
			CUST_ADDR3 = cust_addr3;
		}
		public String getCUST_CONTACT() {
			return CUST_CONTACT;
		}
		public void setCUST_CONTACT(String cust_contact) {
			CUST_CONTACT = cust_contact;
		}
		public String getCUST_CONTACT2() {
			return CUST_CONTACT2;
		}
		public void setCUST_CONTACT2(String cust_contact2) {
			CUST_CONTACT2 = cust_contact2;
		}
		public String getCUST_PHONE() {
			return CUST_PHONE;
		}
		public void setCUST_PHONE(String cust_phone) {
			CUST_PHONE = cust_phone;
		}
		public String getCUST_FAX() {
			return CUST_FAX;
		}
		public void setCUST_FAX(String cust_fax) {
			CUST_FAX = cust_fax;
		}
		public String getCUST_AREA() {
			return CUST_AREA;
		}
		public void setCUST_AREA(String cust_area) {
			CUST_AREA = cust_area;
		}
		public String getCUST_REGION() {
			return CUST_REGION;
		}
		public void setCUST_REGION(String cust_region) {
			CUST_REGION = cust_region;
		}
		public String getCUST_COUNTRY() {
			return CUST_COUNTRY;
		}
		public void setCUST_COUNTRY(String cust_country) {
			CUST_COUNTRY = cust_country;
		}
		public String getCUST_DFLT_BRK_CODE() {
			return CUST_DFLT_BRK_CODE;
		}
		public void setCUST_DFLT_BRK_CODE(String cust_dflt_brk_code) {
			CUST_DFLT_BRK_CODE = cust_dflt_brk_code;
		}
		public String getCUST_BL_NAME() {
			return CUST_BL_NAME;
		}
		public void setCUST_BL_NAME(String cust_bl_name) {
			CUST_BL_NAME = cust_bl_name;
		}
		public String getCUST_BL_SHORT_NAME() {
			return CUST_BL_SHORT_NAME;
		}
		public void setCUST_BL_SHORT_NAME(String cust_bl_short_name) {
			CUST_BL_SHORT_NAME = cust_bl_short_name;
		}
		public String getCUST_BL_ADDR1() {
			return CUST_BL_ADDR1;
		}
		public void setCUST_BL_ADDR1(String cust_bl_addr1) {
			CUST_BL_ADDR1 = cust_bl_addr1;
		}
		public String getCUST_BL_ADDR2() {
			return CUST_BL_ADDR2;
		}
		public void setCUST_BL_ADDR2(String cust_bl_addr2) {
			CUST_BL_ADDR2 = cust_bl_addr2;
		}
		public String getCUST_BL_ADDR3() {
			return CUST_BL_ADDR3;
		}
		public void setCUST_BL_ADDR3(String cust_bl_addr3) {
			CUST_BL_ADDR3 = cust_bl_addr3;
		}
		public String getCUST_BL_CONTACT() {
			return CUST_BL_CONTACT;
		}
		public void setCUST_BL_CONTACT(String cust_bl_contact) {
			CUST_BL_CONTACT = cust_bl_contact;
		}
		public String getCUST_BL_CONTACT2() {
			return CUST_BL_CONTACT2;
		}
		public void setCUST_BL_CONTACT2(String cust_bl_contact2) {
			CUST_BL_CONTACT2 = cust_bl_contact2;
		}
		public String getCUST_BL_AREA() {
			return CUST_BL_AREA;
		}
		public void setCUST_BL_AREA(String cust_bl_area) {
			CUST_BL_AREA = cust_bl_area;
		}
		public String getCUST_BL_REGION() {
			return CUST_BL_REGION;
		}
		public void setCUST_BL_REGION(String cust_bl_region) {
			CUST_BL_REGION = cust_bl_region;
		}
		public String getCUST_BL_COUNTRY() {
			return CUST_BL_COUNTRY;
		}
		public void setCUST_BL_COUNTRY(String cust_bl_country) {
			CUST_BL_COUNTRY = cust_bl_country;
		}
		public Date getCUST_CR_DT() {
			return CUST_CR_DT;
		}
		public void setCUST_CR_DT(Date cust_cr_dt) {
			CUST_CR_DT = cust_cr_dt;
		}
		public String getCUST_CR_UID() {
			return CUST_CR_UID;
		}
		public void setCUST_CR_UID(String cust_cr_uid) {
			CUST_CR_UID = cust_cr_uid;
		}
		public Date getCUST_UPD_DT() {
			return CUST_UPD_DT;
		}
		public void setCUST_UPD_DT(Date cust_upd_dt) {
			CUST_UPD_DT = cust_upd_dt;
		}
		public String getCUST_UPD_UID() {
			return CUST_UPD_UID;
		}
		public void setCUST_UPD_UID(String cust_upd_uid) {
			CUST_UPD_UID = cust_upd_uid;
		}
		public Double getCUST_CREDIT_LIMIT() {
			return CUST_CREDIT_LIMIT;
		}
		public void setCUST_CREDIT_LIMIT(Double cust_credit_limit) {
			CUST_CREDIT_LIMIT = cust_credit_limit;
		}
		public String getCUST_CREDIT_CHECK_YN() {
			return CUST_CREDIT_CHECK_YN;
		}
		public void setCUST_CREDIT_CHECK_YN(String cust_credit_check_yn) {
			CUST_CREDIT_CHECK_YN = cust_credit_check_yn;
		}
		public String getCUST_EMAIL_ID_PER() {
			return CUST_EMAIL_ID_PER;
		}
		public void setCUST_EMAIL_ID_PER(String cust_email_id_per) {
			CUST_EMAIL_ID_PER = cust_email_id_per;
		}
		public String getCUST_EMAIL_ID_OFF() {
			return CUST_EMAIL_ID_OFF;
		}
		public void setCUST_EMAIL_ID_OFF(String cust_email_id_off) {
			CUST_EMAIL_ID_OFF = cust_email_id_off;
		}
		public String getCUST_COMP_HOME_PAGE() {
			return CUST_COMP_HOME_PAGE;
		}
		public void setCUST_COMP_HOME_PAGE(String cust_comp_home_page) {
			CUST_COMP_HOME_PAGE = cust_comp_home_page;
		}
		public String getCUST_ID() {
			return CUST_ID;
		}
		public void setCUST_ID(String cust_id) {
			CUST_ID = cust_id;
		}
		public String getCUST_PIN_NUMBER() {
			return CUST_PIN_NUMBER;
		}
		public void setCUST_PIN_NUMBER(String cust_pin_number) {
			CUST_PIN_NUMBER = cust_pin_number;
		}
		public String getCUST_TAX_STATUS() {
			return CUST_TAX_STATUS;
		}
		public void setCUST_TAX_STATUS(String cust_tax_status) {
			CUST_TAX_STATUS = cust_tax_status;
		}
		public String getCUST_COMMUN_MODE() {
			return CUST_COMMUN_MODE;
		}
		public void setCUST_COMMUN_MODE(String cust_commun_mode) {
			CUST_COMMUN_MODE = cust_commun_mode;
		}
		public String getCUST_STREET() {
			return CUST_STREET;
		}
		public void setCUST_STREET(String cust_street) {
			CUST_STREET = cust_street;
		}
		public String getCUST_BUILDING() {
			return CUST_BUILDING;
		}
		public void setCUST_BUILDING(String cust_building) {
			CUST_BUILDING = cust_building;
		}
		public String getCUST_FLOOR() {
			return CUST_FLOOR;
		}
		public void setCUST_FLOOR(String cust_floor) {
			CUST_FLOOR = cust_floor;
		}
		public String getCUST_OFFICE_PHONE() {
			return CUST_OFFICE_PHONE;
		}
		public void setCUST_OFFICE_PHONE(String cust_office_phone) {
			CUST_OFFICE_PHONE = cust_office_phone;
		}
		public String getCUST_GROUP_CODE() {
			return CUST_GROUP_CODE;
		}
		public void setCUST_GROUP_CODE(String cust_group_code) {
			CUST_GROUP_CODE = cust_group_code;
		}
		public String getCUST_PHY_ADDR1() {
			return CUST_PHY_ADDR1;
		}
		public void setCUST_PHY_ADDR1(String cust_phy_addr1) {
			CUST_PHY_ADDR1 = cust_phy_addr1;
		}
		public String getCUST_PHY_ADDR2() {
			return CUST_PHY_ADDR2;
		}
		public void setCUST_PHY_ADDR2(String cust_phy_addr2) {
			CUST_PHY_ADDR2 = cust_phy_addr2;
		}
		public String getCUST_PHY_ADDR3() {
			return CUST_PHY_ADDR3;
		}
		public void setCUST_PHY_ADDR3(String cust_phy_addr3) {
			CUST_PHY_ADDR3 = cust_phy_addr3;
		}
		public String getCUST_PHY_CONTACT() {
			return CUST_PHY_CONTACT;
		}
		public void setCUST_PHY_CONTACT(String cust_phy_contact) {
			CUST_PHY_CONTACT = cust_phy_contact;
		}
		public String getCUST_PHY_CONTACT2() {
			return CUST_PHY_CONTACT2;
		}
		public void setCUST_PHY_CONTACT2(String cust_phy_contact2) {
			CUST_PHY_CONTACT2 = cust_phy_contact2;
		}
		public String getCUST_PHY_PHONE() {
			return CUST_PHY_PHONE;
		}
		public void setCUST_PHY_PHONE(String cust_phy_phone) {
			CUST_PHY_PHONE = cust_phy_phone;
		}
		public String getCUST_PHY_FAX() {
			return CUST_PHY_FAX;
		}
		public void setCUST_PHY_FAX(String cust_phy_fax) {
			CUST_PHY_FAX = cust_phy_fax;
		}
		public String getCUST_PHY_AREA() {
			return CUST_PHY_AREA;
		}
		public void setCUST_PHY_AREA(String cust_phy_area) {
			CUST_PHY_AREA = cust_phy_area;
		}
		public String getCUST_PHY_REGION() {
			return CUST_PHY_REGION;
		}
		public void setCUST_PHY_REGION(String cust_phy_region) {
			CUST_PHY_REGION = cust_phy_region;
		}
		public String getCUST_PHY_COUNTRY() {
			return CUST_PHY_COUNTRY;
		}
		public void setCUST_PHY_COUNTRY(String cust_phy_country) {
			CUST_PHY_COUNTRY = cust_phy_country;
		}
		public int getCUST_CREDIT_DAYS() {
			return CUST_CREDIT_DAYS;
		}
		public void setCUST_CREDIT_DAYS(int cust_credit_days) {
			CUST_CREDIT_DAYS = cust_credit_days;
		}
		public String getCUST_OCC_CODE() {
			return CUST_OCC_CODE;
		}
		public void setCUST_OCC_CODE(String cust_occ_code) {
			CUST_OCC_CODE = cust_occ_code;
		}
		public String getCUST_POST_BOX_NO() {
			return CUST_POST_BOX_NO;
		}
		public void setCUST_POST_BOX_NO(String cust_post_box_no) {
			CUST_POST_BOX_NO = cust_post_box_no;
		}
		public String getCUST_BROKER_CASH_BASIS_YN() {
			return CUST_BROKER_CASH_BASIS_YN;
		}
		public void setCUST_BROKER_CASH_BASIS_YN(String cust_broker_cash_basis_yn) {
			CUST_BROKER_CASH_BASIS_YN = cust_broker_cash_basis_yn;
		}
		public String getCUST_SRC_BUS() {
			return CUST_SRC_BUS;
		}
		public void setCUST_SRC_BUS(String cust_src_bus) {
			CUST_SRC_BUS = cust_src_bus;
		}
		public String getCUST_CONTRACTED_YN() {
			return CUST_CONTRACTED_YN;
		}
		public void setCUST_CONTRACTED_YN(String cust_contracted_yn) {
			CUST_CONTRACTED_YN = cust_contracted_yn;
		}
		public Double getCUST_MEDEX_LIMIT() {
			return CUST_MEDEX_LIMIT;
		}
		public void setCUST_MEDEX_LIMIT(Double cust_medex_limit) {
			CUST_MEDEX_LIMIT = cust_medex_limit;
		}
		public String getCUST_LINK_AGENT_CODE() {
			return CUST_LINK_AGENT_CODE;
		}
		public void setCUST_LINK_AGENT_CODE(String cust_link_agent_code) {
			CUST_LINK_AGENT_CODE = cust_link_agent_code;
		}
		public String getCUST_MOBILE_NO() {
			return CUST_MOBILE_NO;
		}
		public void setCUST_MOBILE_NO(String cust_mobile_no) {
			CUST_MOBILE_NO = cust_mobile_no;
		}
		public String getCUST_QUALFN() {
			return CUST_QUALFN;
		}
		public void setCUST_QUALFN(String cust_qualfn) {
			CUST_QUALFN = cust_qualfn;
		}
		public Date getCUST_EFF_FM_DT() {
			return CUST_EFF_FM_DT;
		}
		public void setCUST_EFF_FM_DT(Date cust_eff_fm_dt) {
			CUST_EFF_FM_DT = cust_eff_fm_dt;
		}
		public Date getCUST_EFF_TO_DT() {
			return CUST_EFF_TO_DT;
		}
		public void setCUST_EFF_TO_DT(Date cust_eff_to_dt) {
			CUST_EFF_TO_DT = cust_eff_to_dt;
		}
		public String getCUST_CR_ASSR_YN() {
			return CUST_CR_ASSR_YN;
		}
		public void setCUST_CR_ASSR_YN(String cust_cr_assr_yn) {
			CUST_CR_ASSR_YN = cust_cr_assr_yn;
		}
		public String getCUST_TYPE() {
			return CUST_TYPE;
		}
		public void setCUST_TYPE(String cust_type) {
			CUST_TYPE = cust_type;
		}
		public String getCUST_REF_ID1() {
			return CUST_REF_ID1;
		}
		public void setCUST_REF_ID1(String cust_ref_id1) {
			CUST_REF_ID1 = cust_ref_id1;
		}
		public String getCUST_REF_ID2() {
			return CUST_REF_ID2;
		}
		public void setCUST_REF_ID2(String cust_ref_id2) {
			CUST_REF_ID2 = cust_ref_id2;
		}
		public String getCUST_TEL_AREA_CODE() {
			return CUST_TEL_AREA_CODE;
		}
		public void setCUST_TEL_AREA_CODE(String cust_tel_area_code) {
			CUST_TEL_AREA_CODE = cust_tel_area_code;
		}
		public String getCUST_PHY_TEL_AREA_CODE() {
			return CUST_PHY_TEL_AREA_CODE;
		}
		public void setCUST_PHY_TEL_AREA_CODE(String cust_phy_tel_area_code) {
			CUST_PHY_TEL_AREA_CODE = cust_phy_tel_area_code;
		}
		public String getCUST_FAX_AREA_CODE() {
			return CUST_FAX_AREA_CODE;
		}
		public void setCUST_FAX_AREA_CODE(String cust_fax_area_code) {
			CUST_FAX_AREA_CODE = cust_fax_area_code;
		}
		public String getCUST_PREFERRED_LANG() {
			return CUST_PREFERRED_LANG;
		}
		public void setCUST_PREFERRED_LANG(String cust_preferred_lang) {
			CUST_PREFERRED_LANG = cust_preferred_lang;
		}
		public Date getCUST_DOB() {
			return CUST_DOB;
		}
		public void setCUST_DOB(Date cust_dob) {
			CUST_DOB = cust_dob;
		}
		public String getCUST_CATG_CODE() {
			return CUST_CATG_CODE;
		}
		public void setCUST_CATG_CODE(String cust_catg_code) {
			CUST_CATG_CODE = cust_catg_code;
		}
		public String getCUST_NATIONALITY_CODE() {
			return CUST_NATIONALITY_CODE;
		}
		public void setCUST_NATIONALITY_CODE(String cust_nationality_code) {
			CUST_NATIONALITY_CODE = cust_nationality_code;
		}
		public String getCUST_RACE() {
			return CUST_RACE;
		}
		public void setCUST_RACE(String cust_race) {
			CUST_RACE = cust_race;
		}
		public String getCUST_MAR_STATUS() {
			return CUST_MAR_STATUS;
		}
		public void setCUST_MAR_STATUS(String cust_mar_status) {
			CUST_MAR_STATUS = cust_mar_status;
		}
		public String getCUST_SALUTATION() {
			return CUST_SALUTATION;
		}
		public void setCUST_SALUTATION(String cust_salutation) {
			CUST_SALUTATION = cust_salutation;
		}
		public String getCUST_BIRTH_CERT_NO() {
			return CUST_BIRTH_CERT_NO;
		}
		public void setCUST_BIRTH_CERT_NO(String cust_birth_cert_no) {
			CUST_BIRTH_CERT_NO = cust_birth_cert_no;
		}
		public String getCUST_BANK_NAME() {
			return CUST_BANK_NAME;
		}
		public void setCUST_BANK_NAME(String cust_bank_name) {
			CUST_BANK_NAME = cust_bank_name;
		}
		public String getCUST_BANK_AC_NO() {
			return CUST_BANK_AC_NO;
		}
		public void setCUST_BANK_AC_NO(String cust_bank_ac_no) {
			CUST_BANK_AC_NO = cust_bank_ac_no;
		}
		public String getCUST_RELIGION() {
			return CUST_RELIGION;
		}
		public void setCUST_RELIGION(String cust_religion) {
			CUST_RELIGION = cust_religion;
		}
		public String getCUST_POSTAL_CODE() {
			return CUST_POSTAL_CODE;
		}
		public void setCUST_POSTAL_CODE(String cust_postal_code) {
			CUST_POSTAL_CODE = cust_postal_code;
		}
		public String getCUST_CITY() {
			return CUST_CITY;
		}
		public void setCUST_CITY(String cust_city) {
			CUST_CITY = cust_city;
		}
		public String getCUST_STATE() {
			return CUST_STATE;
		}
		public void setCUST_STATE(String cust_state) {
			CUST_STATE = cust_state;
		}
		public String getCUST_TITLE() {
			return CUST_TITLE;
		}
		public void setCUST_TITLE(String cust_title) {
			CUST_TITLE = cust_title;
		}
		public String getCUST_COUNT_CODE() {
			return CUST_COUNT_CODE;
		}
		public void setCUST_COUNT_CODE(String cust_count_code) {
			CUST_COUNT_CODE = cust_count_code;
		}
		public String getCUST_POST_CODE() {
			return CUST_POST_CODE;
		}
		public void setCUST_POST_CODE(String cust_post_code) {
			CUST_POST_CODE = cust_post_code;
		}
		public String getCUST_CITY_CODE() {
			return CUST_CITY_CODE;
		}
		public void setCUST_CITY_CODE(String cust_city_code) {
			CUST_CITY_CODE = cust_city_code;
		}
		public String getCUST_STATE_CODE() {
			return CUST_STATE_CODE;
		}
		public void setCUST_STATE_CODE(String cust_state_code) {
			CUST_STATE_CODE = cust_state_code;
		}
		public String getCUST_SPOUSE_NAME() {
			return CUST_SPOUSE_NAME;
		}
		public void setCUST_SPOUSE_NAME(String cust_spouse_name) {
			CUST_SPOUSE_NAME = cust_spouse_name;
		}
		public String getCUST_QUALFN_2() {
			return CUST_QUALFN_2;
		}
		public void setCUST_QUALFN_2(String cust_qualfn_2) {
			CUST_QUALFN_2 = cust_qualfn_2;
		}
		public Double getCUST_NO_DEPDN() {
			return CUST_NO_DEPDN;
		}
		public void setCUST_NO_DEPDN(Double cust_no_depdn) {
			CUST_NO_DEPDN = cust_no_depdn;
		}
		public String getCUST_INCOME_TAX_FILE_NO() {
			return CUST_INCOME_TAX_FILE_NO;
		}
		public void setCUST_INCOME_TAX_FILE_NO(String cust_income_tax_file_no) {
			CUST_INCOME_TAX_FILE_NO = cust_income_tax_file_no;
		}
		public String getCUST_ALT_PAYEE_NAME() {
			return CUST_ALT_PAYEE_NAME;
		}
		public void setCUST_ALT_PAYEE_NAME(String cust_alt_payee_name) {
			CUST_ALT_PAYEE_NAME = cust_alt_payee_name;
		}
		public String getCUST_ALT_PAYEE_AC_NO() {
			return CUST_ALT_PAYEE_AC_NO;
		}
		public void setCUST_ALT_PAYEE_AC_NO(String cust_alt_payee_ac_no) {
			CUST_ALT_PAYEE_AC_NO = cust_alt_payee_ac_no;
		}
		public String getCUST_BANK_CODE() {
			return CUST_BANK_CODE;
		}
		public void setCUST_BANK_CODE(String cust_bank_code) {
			CUST_BANK_CODE = cust_bank_code;
		}
		public String getCUST_INSURED_ID() {
			return CUST_INSURED_ID;
		}
		public void setCUST_INSURED_ID(String cust_insured_id) {
			CUST_INSURED_ID = cust_insured_id;
		}
		public String getCUST_ALL_CURR_APPL_YN() {
			return CUST_ALL_CURR_APPL_YN;
		}
		public void setCUST_ALL_CURR_APPL_YN(String cust_all_curr_appl_yn) {
			CUST_ALL_CURR_APPL_YN = cust_all_curr_appl_yn;
		}
		public String getCUST_MKT_CODE() {
			return CUST_MKT_CODE;
		}
		public void setCUST_MKT_CODE(String cust_mkt_code) {
			CUST_MKT_CODE = cust_mkt_code;
		}
		public String getCUST_UNIT_CODE() {
			return CUST_UNIT_CODE;
		}
		public void setCUST_UNIT_CODE(String cust_unit_code) {
			CUST_UNIT_CODE = cust_unit_code;
		}
		public String getCUST_AGENCY_CODE() {
			return CUST_AGENCY_CODE;
		}
		public void setCUST_AGENCY_CODE(String cust_agency_code) {
			CUST_AGENCY_CODE = cust_agency_code;
		}
		public String getCUST_AGENCY_BRANCH_CODE() {
			return CUST_AGENCY_BRANCH_CODE;
		}
		public void setCUST_AGENCY_BRANCH_CODE(String cust_agency_branch_code) {
			CUST_AGENCY_BRANCH_CODE = cust_agency_branch_code;
		}
		public String getCUST_REGION_CODE() {
			return CUST_REGION_CODE;
		}
		public void setCUST_REGION_CODE(String cust_region_code) {
			CUST_REGION_CODE = cust_region_code;
		}
		public String getCUST_AGENCY_NAME() {
			return CUST_AGENCY_NAME;
		}
		public void setCUST_AGENCY_NAME(String cust_agency_name) {
			CUST_AGENCY_NAME = cust_agency_name;
		}
		public String getCUST_AGENT_RANK_CODE() {
			return CUST_AGENT_RANK_CODE;
		}
		public void setCUST_AGENT_RANK_CODE(String cust_agent_rank_code) {
			CUST_AGENT_RANK_CODE = cust_agent_rank_code;
		}
		public String getCUST_RECRUITER_CODE() {
			return CUST_RECRUITER_CODE;
		}
		public void setCUST_RECRUITER_CODE(String cust_recruiter_code) {
			CUST_RECRUITER_CODE = cust_recruiter_code;
		}
		public String getCUST_INTRODUCER_CODE() {
			return CUST_INTRODUCER_CODE;
		}
		public void setCUST_INTRODUCER_CODE(String cust_introducer_code) {
			CUST_INTRODUCER_CODE = cust_introducer_code;
		}
		public Double getCUST_MIN_NO_OF_POL() {
			return CUST_MIN_NO_OF_POL;
		}
		public void setCUST_MIN_NO_OF_POL(Double cust_min_no_of_pol) {
			CUST_MIN_NO_OF_POL = cust_min_no_of_pol;
		}
		public Double getCUST_MIN_LC_PERS_CONT() {
			return CUST_MIN_LC_PERS_CONT;
		}
		public void setCUST_MIN_LC_PERS_CONT(Double cust_min_lc_pers_cont) {
			CUST_MIN_LC_PERS_CONT = cust_min_lc_pers_cont;
		}
		public Double getCUST_BUDGET_LC_PREM() {
			return CUST_BUDGET_LC_PREM;
		}
		public void setCUST_BUDGET_LC_PREM(Double cust_budget_lc_prem) {
			CUST_BUDGET_LC_PREM = cust_budget_lc_prem;
		}
		public Double getCUST_LC_SUM_ASSURED() {
			return CUST_LC_SUM_ASSURED;
		}
		public void setCUST_LC_SUM_ASSURED(Double cust_lc_sum_assured) {
			CUST_LC_SUM_ASSURED = cust_lc_sum_assured;
		}
		public String getCUST_FIRST_NAME() {
			return CUST_FIRST_NAME;
		}
		public void setCUST_FIRST_NAME(String cust_first_name) {
			CUST_FIRST_NAME = cust_first_name;
		}
		public String getCUST_SURNAME() {
			System.out.println("Getter CUST_SURNAME: -------------------- "+CUST_SURNAME);
			return CUST_SURNAME;
		}
		public void setCUST_SURNAME(String cust_surname) {
			CUST_SURNAME = cust_surname;
			System.out.println("Setter CUST_SURNAME: -------------------- "+CUST_SURNAME);
		}
		public String getCUST_MIDDLE_NAME() {
			return CUST_MIDDLE_NAME;
		}
		public void setCUST_MIDDLE_NAME(String cust_middle_name) {
			CUST_MIDDLE_NAME = cust_middle_name;
		}
		public String getCUST_LONG_NAME() {
			return CUST_LONG_NAME;
		}
		public void setCUST_LONG_NAME(String cust_long_name) {
			CUST_LONG_NAME = cust_long_name;
		}
		public String getCUST_STATUS() {
			return CUST_STATUS;
		}
		public void setCUST_STATUS(String cust_status) {
			CUST_STATUS = cust_status;
		}
		public Double getCUST_INTEREST_RATE() {
			return CUST_INTEREST_RATE;
		}
		public void setCUST_INTEREST_RATE(Double cust_interest_rate) {
			CUST_INTEREST_RATE = cust_interest_rate;
		}
		public String getCUST_AUTO_DEBIT_AVBL_YN() {
			return CUST_AUTO_DEBIT_AVBL_YN;
		}
		public void setCUST_AUTO_DEBIT_AVBL_YN(String cust_auto_debit_avbl_yn) {
			CUST_AUTO_DEBIT_AVBL_YN = cust_auto_debit_avbl_yn;
		}
		public String getCUST_COMP_REGN_NO() {
			return CUST_COMP_REGN_NO;
		}
		public void setCUST_COMP_REGN_NO(String cust_comp_regn_no) {
			CUST_COMP_REGN_NO = cust_comp_regn_no;
		}
		public String getCUST_PIAM_AGENCY_CODE() {
			return CUST_PIAM_AGENCY_CODE;
		}
		public void setCUST_PIAM_AGENCY_CODE(String cust_piam_agency_code) {
			CUST_PIAM_AGENCY_CODE = cust_piam_agency_code;
		}
		public String getCUST_PASS_NO() {
			return CUST_PASS_NO;
		}
		public void setCUST_PASS_NO(String cust_pass_no) {
			CUST_PASS_NO = cust_pass_no;
		}
		public String getCUST_CPF_NO() {
			return CUST_CPF_NO;
		}
		public void setCUST_CPF_NO(String cust_cpf_no) {
			CUST_CPF_NO = cust_cpf_no;
		}
		public String getCUST_CBC_YN() {
			return CUST_CBC_YN;
		}
		public void setCUST_CBC_YN(String cust_cbc_yn) {
			CUST_CBC_YN = cust_cbc_yn;
		}
		public String getCUST_ROC_NO() {
			return CUST_ROC_NO;
		}
		public void setCUST_ROC_NO(String cust_roc_no) {
			CUST_ROC_NO = cust_roc_no;
		}
		public String getCUST_CLAIM_EXP() {
			return CUST_CLAIM_EXP;
		}
		public void setCUST_CLAIM_EXP(String cust_claim_exp) {
			CUST_CLAIM_EXP = cust_claim_exp;
		}
		public Double getCUST_DRV_EXP() {
			return CUST_DRV_EXP;
		}
		public void setCUST_DRV_EXP(Double cust_drv_exp) {
			CUST_DRV_EXP = cust_drv_exp;
		}
		public Double getCUST_GUARANTEE_LIMIT() {
			return CUST_GUARANTEE_LIMIT;
		}
		public void setCUST_GUARANTEE_LIMIT(Double cust_guarantee_limit) {
			CUST_GUARANTEE_LIMIT = cust_guarantee_limit;
		}
		public String getCUST_CONTACT3() {
			return CUST_CONTACT3;
		}
		public void setCUST_CONTACT3(String cust_contact3) {
			CUST_CONTACT3 = cust_contact3;
		}
		public String getCUST_CONTACT1_LIC_NO() {
			return CUST_CONTACT1_LIC_NO;
		}
		public void setCUST_CONTACT1_LIC_NO(String cust_contact1_lic_no) {
			CUST_CONTACT1_LIC_NO = cust_contact1_lic_no;
		}
		public String getCUST_CONTACT2_LIC_NO() {
			return CUST_CONTACT2_LIC_NO;
		}
		public void setCUST_CONTACT2_LIC_NO(String cust_contact2_lic_no) {
			CUST_CONTACT2_LIC_NO = cust_contact2_lic_no;
		}
		public String getCUST_CONTACT3_LIC_NO() {
			return CUST_CONTACT3_LIC_NO;
		}
		public void setCUST_CONTACT3_LIC_NO(String cust_contact3_lic_no) {
			CUST_CONTACT3_LIC_NO = cust_contact3_lic_no;
		}
		public String getCUST_CLM_CONTACT() {
			return CUST_CLM_CONTACT;
		}
		public void setCUST_CLM_CONTACT(String cust_clm_contact) {
			CUST_CLM_CONTACT = cust_clm_contact;
		}
		public String getCUST_CLM_CONTACT_LIC_NO() {
			return CUST_CLM_CONTACT_LIC_NO;
		}
		public void setCUST_CLM_CONTACT_LIC_NO(String cust_clm_contact_lic_no) {
			CUST_CLM_CONTACT_LIC_NO = cust_clm_contact_lic_no;
		}
		public String getCUST_ACNT_CONTACT() {
			return CUST_ACNT_CONTACT;
		}
		public void setCUST_ACNT_CONTACT(String cust_acnt_contact) {
			CUST_ACNT_CONTACT = cust_acnt_contact;
		}
		public String getCUST_ACNT_CONTACT_LIC_NO() {
			return CUST_ACNT_CONTACT_LIC_NO;
		}
		public void setCUST_ACNT_CONTACT_LIC_NO(String cust_acnt_contact_lic_no) {
			CUST_ACNT_CONTACT_LIC_NO = cust_acnt_contact_lic_no;
		}
		public String getCUST_TEL_AREA_CODE2() {
			return CUST_TEL_AREA_CODE2;
		}
		public void setCUST_TEL_AREA_CODE2(String cust_tel_area_code2) {
			CUST_TEL_AREA_CODE2 = cust_tel_area_code2;
		}
		public String getCUST_TEL_AREA_CODE3() {
			return CUST_TEL_AREA_CODE3;
		}
		public void setCUST_TEL_AREA_CODE3(String cust_tel_area_code3) {
			CUST_TEL_AREA_CODE3 = cust_tel_area_code3;
		}
		public String getCUST_PHONE2() {
			return CUST_PHONE2;
		}
		public void setCUST_PHONE2(String cust_phone2) {
			CUST_PHONE2 = cust_phone2;
		}
		public String getCUST_PHONE3() {
			return CUST_PHONE3;
		}
		public void setCUST_PHONE3(String cust_phone3) {
			CUST_PHONE3 = cust_phone3;
		}
		public String getCUST_FAX_AREA_CODE2() {
			return CUST_FAX_AREA_CODE2;
		}
		public void setCUST_FAX_AREA_CODE2(String cust_fax_area_code2) {
			CUST_FAX_AREA_CODE2 = cust_fax_area_code2;
		}
		public String getCUST_FAX_AREA_CODE3() {
			return CUST_FAX_AREA_CODE3;
		}
		public void setCUST_FAX_AREA_CODE3(String cust_fax_area_code3) {
			CUST_FAX_AREA_CODE3 = cust_fax_area_code3;
		}
		public String getCUST_FAX2() {
			return CUST_FAX2;
		}
		public void setCUST_FAX2(String cust_fax2) {
			CUST_FAX2 = cust_fax2;
		}
		public String getCUST_FAX3() {
			return CUST_FAX3;
		}
		public void setCUST_FAX3(String cust_fax3) {
			CUST_FAX3 = cust_fax3;
		}
		public String getCUST_TRANSFER_TO() {
			return CUST_TRANSFER_TO;
		}
		public void setCUST_TRANSFER_TO(String cust_transfer_to) {
			CUST_TRANSFER_TO = cust_transfer_to;
		}
		public String getCUST_AGENT_TO() {
			return CUST_AGENT_TO;
		}
		public void setCUST_AGENT_TO(String cust_agent_to) {
			CUST_AGENT_TO = cust_agent_to;
		}
		public Date getCUST_AGENT_EFF_FM_DT() {
			return CUST_AGENT_EFF_FM_DT;
		}
		public void setCUST_AGENT_EFF_FM_DT(Date cust_agent_eff_fm_dt) {
			CUST_AGENT_EFF_FM_DT = cust_agent_eff_fm_dt;
		}
		public Date getCUST_AGENT_EFF_TO_DT() {
			return CUST_AGENT_EFF_TO_DT;
		}
		public void setCUST_AGENT_EFF_TO_DT(Date cust_agent_eff_to_dt) {
			CUST_AGENT_EFF_TO_DT = cust_agent_eff_to_dt;
		}
		public String getCUST_SUPP_COMM_APBL_YN() {
			return CUST_SUPP_COMM_APBL_YN;
		}
		public void setCUST_SUPP_COMM_APBL_YN(String cust_supp_comm_apbl_yn) {
			CUST_SUPP_COMM_APBL_YN = cust_supp_comm_apbl_yn;
		}
		public String getCUST_LCN_NO() {
			return CUST_LCN_NO;
		}
		public void setCUST_LCN_NO(String cust_lcn_no) {
			CUST_LCN_NO = cust_lcn_no;
		}
		public Date getCUST_LIC_START_DT() {
			return CUST_LIC_START_DT;
		}
		public void setCUST_LIC_START_DT(Date cust_lic_start_dt) {
			CUST_LIC_START_DT = cust_lic_start_dt;
		}
		public Date getCUST_LIC_END_DT() {
			return CUST_LIC_END_DT;
		}
		public void setCUST_LIC_END_DT(Date cust_lic_end_dt) {
			CUST_LIC_END_DT = cust_lic_end_dt;
		}
		public Date getCUST_LCN_REG_DT() {
			return CUST_LCN_REG_DT;
		}
		public void setCUST_LCN_REG_DT(Date cust_lcn_reg_dt) {
			CUST_LCN_REG_DT = cust_lcn_reg_dt;
		}
		public String getCUST_LCN_STATUS() {
			return CUST_LCN_STATUS;
		}
		public void setCUST_LCN_STATUS(String cust_lcn_status) {
			CUST_LCN_STATUS = cust_lcn_status;
		}
		public String getCUST_HANDLER_ID() {
			return CUST_HANDLER_ID;
		}
		public void setCUST_HANDLER_ID(String cust_handler_id) {
			CUST_HANDLER_ID = cust_handler_id;
		}
		public String getCUST_AD_ACC_NO() {
			return CUST_AD_ACC_NO;
		}
		public void setCUST_AD_ACC_NO(String cust_ad_acc_no) {
			CUST_AD_ACC_NO = cust_ad_acc_no;
		}
		public String getCUST_AD_BANK_CODE() {
			return CUST_AD_BANK_CODE;
		}
		public void setCUST_AD_BANK_CODE(String cust_ad_bank_code) {
			CUST_AD_BANK_CODE = cust_ad_bank_code;
		}
		public Double getCUST_BLACK_LIST_COUNT() {
			return CUST_BLACK_LIST_COUNT;
		}
		public void setCUST_BLACK_LIST_COUNT(Double cust_black_list_count) {
			CUST_BLACK_LIST_COUNT = cust_black_list_count;
		}
		public String getCUST_CLE_ZONE_CODE() {
			return CUST_CLE_ZONE_CODE;
		}
		public void setCUST_CLE_ZONE_CODE(String cust_cle_zone_code) {
			CUST_CLE_ZONE_CODE = cust_cle_zone_code;
		}
		public String getCUST_CONTU_PAYMENT_YN() {
			return CUST_CONTU_PAYMENT_YN;
		}
		public void setCUST_CONTU_PAYMENT_YN(String cust_contu_payment_yn) {
			CUST_CONTU_PAYMENT_YN = cust_contu_payment_yn;
		}
		public String getCUST_DES_MTD_CODE() {
			return CUST_DES_MTD_CODE;
		}
		public void setCUST_DES_MTD_CODE(String cust_des_mtd_code) {
			CUST_DES_MTD_CODE = cust_des_mtd_code;
		}
		public Double getCUST_INTREST_RATE() {
			return CUST_INTREST_RATE;
		}
		public void setCUST_INTREST_RATE(Double cust_intrest_rate) {
			CUST_INTREST_RATE = cust_intrest_rate;
		}
		public String getCUST_PYMT_TYPE() {
			return CUST_PYMT_TYPE;
		}
		public void setCUST_PYMT_TYPE(String cust_pymt_type) {
			CUST_PYMT_TYPE = cust_pymt_type;
		}
		public String getCUST_IC_TYPE() {
			return CUST_IC_TYPE;
		}
		public void setCUST_IC_TYPE(String cust_ic_type) {
			CUST_IC_TYPE = cust_ic_type;
		}
		public String getCUST_STATE_DESC() {
			return CUST_STATE_DESC;
		}
		public void setCUST_STATE_DESC(String cust_state_desc) {
			CUST_STATE_DESC = cust_state_desc;
		}
		public String getCUST_POSTAL_DESC() {
			return CUST_POSTAL_DESC;
		}
		public void setCUST_POSTAL_DESC(String cust_postal_desc) {
			CUST_POSTAL_DESC = cust_postal_desc;
		}
		public String getCUST_COD_REQD_YN() {
			return CUST_COD_REQD_YN;
		}
		public void setCUST_COD_REQD_YN(String cust_cod_reqd_yn) {
			CUST_COD_REQD_YN = cust_cod_reqd_yn;
		}
		public String getCUST_APPL_ALL_BRAN_YN() {
			return CUST_APPL_ALL_BRAN_YN;
		}
		public void setCUST_APPL_ALL_BRAN_YN(String cust_appl_all_bran_yn) {
			CUST_APPL_ALL_BRAN_YN = cust_appl_all_bran_yn;
		}
		
		public String getCUST_FRZ_FLAG() {
			return CUST_FRZ_FLAG;
		}
		/*public void setCUST_FRZ_FLAG(String CUST_FRZ_FLAG) {
			CommonUtils commonUtils = new CommonUtils();
			CUST_FRZ_FLAG_UI =commonUtils.stringToBooleanConvertor(CUST_FRZ_FLAG);
			CUST_FRZ_FLAG = CUST_FRZ_FLAG;
		}*/
		
		public void setCUST_FRZ_FLAG(String CUST_FRZ_FLAG) {
			this.CUST_FRZ_FLAG = CUST_FRZ_FLAG;
			FRZ_FLAG = CUST_FRZ_FLAG.equals("Y");
		}
		
		public boolean isCUST_FRZ_FLAG_UI() {
			return CUST_FRZ_FLAG_UI;
		}
		public void setCUST_FRZ_FLAG_UI(boolean cust_frz_flag_ui) {
			CommonUtils commonUtils = new CommonUtils();
			CUST_FRZ_FLAG = commonUtils.booleanToStriingConvertor(cust_frz_flag_ui);
			CUST_FRZ_FLAG_UI = cust_frz_flag_ui;
		}
		public boolean isCUST_MATRIX_PROD_APPBL_YN_UI() {
			return CUST_MATRIX_PROD_APPBL_YN_UI;
		}
		public void setCUST_MATRIX_PROD_APPBL_YN_UI(boolean cust_matrix_prod_appbl_yn_ui) {
			CommonUtils commonUtils = new CommonUtils();
			CUST_MATRIX_PROD_APPBL_YN = commonUtils.booleanToStriingConvertor(cust_matrix_prod_appbl_yn_ui);
			CUST_MATRIX_PROD_APPBL_YN_UI = cust_matrix_prod_appbl_yn_ui;
		}
		public String getCUST_MATRIX_PROD_APPBL_YN() {
			return CUST_MATRIX_PROD_APPBL_YN;
		}
		public void setCUST_MATRIX_PROD_APPBL_YN(String cust_matrix_prod_appbl_yn) {
			CommonUtils commonUtils = new CommonUtils();
			CUST_MATRIX_PROD_APPBL_YN_UI =commonUtils.stringToBooleanConvertor(cust_matrix_prod_appbl_yn);
			CUST_MATRIX_PROD_APPBL_YN = cust_matrix_prod_appbl_yn;
		}
		public String getUI_M_CUST_TYPE() {
			return UI_M_CUST_TYPE;
		}
		public void setUI_M_CUST_TYPE(String ui_m_cust_type) {
			UI_M_CUST_TYPE = ui_m_cust_type;
		}

		public String getUI_M_CUST_COUNT_CODE_DESC() {
			return UI_M_CUST_COUNT_CODE_DESC;
		}

		public void setUI_M_CUST_COUNT_CODE_DESC(String ui_m_cust_count_code_desc) {
			UI_M_CUST_COUNT_CODE_DESC = ui_m_cust_count_code_desc;
		}

		public String getUI_M_CUST_POSTAL_CODE_DESC() {
			return UI_M_CUST_POSTAL_CODE_DESC;
		}

		public void setUI_M_CUST_POSTAL_CODE_DESC(String ui_m_cust_postal_code_desc) {
			UI_M_CUST_POSTAL_CODE_DESC = ui_m_cust_postal_code_desc;
		}

		public String getUI_M_CUST_CITY_CODE_DESC() {
			return UI_M_CUST_CITY_CODE_DESC;
		}

		public void setUI_M_CUST_CITY_CODE_DESC(String ui_m_cust_city_code_desc) {
			UI_M_CUST_CITY_CODE_DESC = ui_m_cust_city_code_desc;
		}

		public String getUI_M_CUST_STATE_CODE_DESC() {
			return UI_M_CUST_STATE_CODE_DESC;
		}

		public void setUI_M_CUST_STATE_CODE_DESC(String ui_m_cust_state_code_desc) {
			UI_M_CUST_STATE_CODE_DESC = ui_m_cust_state_code_desc;
		}

		public String getUI_M_CUST_FREEZE_STATUS() {
			return UI_M_CUST_FREEZE_STATUS;
		}

		public void setUI_M_CUST_FREEZE_STATUS(String ui_m_cust_freeze_status) {
			UI_M_CUST_FREEZE_STATUS = ui_m_cust_freeze_status;
		}

	
	
	

}
