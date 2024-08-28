package com.iii.pel.forms.PILM016_APAC_QE;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_CONTRACTOR") 
public class PM_IL_CONTRACTOR_QE extends BaseValueBean {

	@Column(name="CONT_TEL_AREA_CODE")
	private String CONT_TEL_AREA_CODE;

	@Column(name="CONT_MOBILE_NO")
	private String CONT_MOBILE_NO;

	@Column(name="CONT_POSTAL_CODE")
	private String CONT_POSTAL_CODE;

	@Column(name="CONT_STATE_CODE")
	private String CONT_STATE_CODE;

	@Column(name="CONT_BIRTH_CERT_NO")
	private String CONT_BIRTH_CERT_NO;

	@Column(name="CONT_MAR_STATUS")
	private String CONT_MAR_STATUS;

	@Column(name="CONT_RELIGION")
	private String CONT_RELIGION;

	@Column(name="CONT_AREA")
	private String CONT_AREA;

	@Column(name="CONT_EMPLOYER_YN")
	private String CONT_EMPLOYER_YN;

	@Column(name="CONT_PREFERRED_LANG")
	private String CONT_PREFERRED_LANG;

	@Column(name="CONT_LC_PROP_DEP_AMT")
	private Double CONT_LC_PROP_DEP_AMT;

	@Column(name="CONT_LC_POL_DEP_AMT")
	private Double CONT_LC_POL_DEP_AMT;

	@Column(name="CONT_AD_BANK_CODE")
	private String CONT_AD_BANK_CODE;

	@Column(name="CONT_EFF_FM_DT")
	private Date CONT_EFF_FM_DT;

	@Column(name="CONT_REMARKS")
	private String CONT_REMARKS;

	@Column(name="CONT_BL_ADDR1")
	private String CONT_BL_ADDR1;

	@Column(name="CONT_BL_NAME")
	private String CONT_BL_NAME;

	@Column(name="CONT_BL_ADDR2")
	private String CONT_BL_ADDR2;

	@Column(name="CONT_BL_ADDR3")
	private String CONT_BL_ADDR3;

	@Column(name="CONT_BL_CONTACT")
	private String CONT_BL_CONTACT;

	@Column(name="CONT_PHONE")
	private String CONT_PHONE;

	@Column(name="CONT_STATE")
	private String CONT_STATE;

	
	
	@Column(name="CONT_CODE")
	private String CONT_CODE;

	@Column(name="CONT_REF_ID1")
	private String CONT_REF_ID1;

	@Column(name="CONT_REF_ID2")
	private String CONT_REF_ID2;

	@Column(name="CONT_NAME")
	private String CONT_NAME;

	@Column(name="CONT_ADDR1")
	private String CONT_ADDR1;

	@Column(name="CONT_ADDR2")
	private String CONT_ADDR2;

	@Column(name="CONT_ADDR3")
	private String CONT_ADDR3;

	@Column(name="CONT_CONTACT")
	private String CONT_CONTACT;

	@Column(name="CONT_FAX_AREA_CODE")
	private String CONT_FAX_AREA_CODE;

	@Column(name="CONT_EMAIL_ID")
	private String CONT_EMAIL_ID;

	@Column(name="CONT_CITY_CODE")
	private String CONT_CITY_CODE;

	@Column(name="CONT_COUNT_CODE")
	private String CONT_COUNT_CODE;

	@Column(name="CONT_DOB")
	private Date CONT_DOB;

	@Column(name="CONT_CATG_CODE")
	private String CONT_CATG_CODE;

	@Column(name="CONT_NATIONALITY_CODE")
	private String CONT_NATIONALITY_CODE;

	@Column(name="CONT_RACE")
	private String CONT_RACE;

	@Column(name="CONT_REGION")
	private String CONT_REGION;

	@Column(name="CONT_REF_NO")
	private String CONT_REF_NO;

	@Column(name="CONT_LC_PROP_UTIL_AMT")
	private Double CONT_LC_PROP_UTIL_AMT;

	@Column(name="CONT_LC_POL_UTIL_AMT")
	private Double CONT_LC_POL_UTIL_AMT;

	@Column(name="CONT_AD_ACC_NO")
	private String CONT_AD_ACC_NO;

	@Column(name="CONT_EFF_TO_DT")
	private Date CONT_EFF_TO_DT;

	@Column(name="CONT_FAX")
	private String CONT_FAX;

	@Column(name="CONT_CITY")
	private String CONT_CITY;

	@Column(name="CONT_COUNTRY")
	private String CONT_COUNTRY;
	
	
	
	@Column(name="CONT_UPD_DT")
	private Date CONT_UPD_DT;

	
	@Column(name="CONT_UPD_UID")
	private String CONT_UPD_UID;
	
	
	@Column(name="CONT_PASS_NO")
	private String CONT_PASS_NO;
	
	
	@Column(name="CONT_CUST_CODE")
	private String CONT_CUST_CODE;
	

	/*Added By Raja*/
	private boolean ASSURED_FLAG;
	
	public boolean isASSURED_FLAG() {
		return ASSURED_FLAG;
	}

	public void setASSURED_FLAG(boolean aSSURED_FLAG) {
		ASSURED_FLAG = aSSURED_FLAG;
	}
	
	private boolean ASSURED_NAME_FLAG;
	
	
	public boolean isASSURED_NAME_FLAG() {
		return ASSURED_NAME_FLAG;
	}

	public void setASSURED_NAME_FLAG(boolean aSSURED_NAME_FLAG) {
		ASSURED_NAME_FLAG = aSSURED_NAME_FLAG;
	}
	
	/*End*/
	

	

	

	private String UI_M_CONT_CATG_CODE_DESC;

	private String UI_M_CONT_NATIONALITY_CODE_DESC;

	private String UI_M_CONT_RACE_DESC;
	private String UI_M_CONT_MAR_STATUS_DESC;
	
	private String UI_M_CONT_RELIGION_DESC;
	
	private String UI_M_CONT_AD_BANK_NAME;

	private boolean insertMode=true;
	
	 private String UI_M_CONT_CITY_CODE_DESC;
	 
	 private String UI_M_CONT_STATE_CODE_DESC;
	
	@Column(name="CONT_CR_DT")
	private Date CONT_CR_DT;
	
	@Column(name="CONT_CR_UID")
	private String CONT_CR_UID;
	
	@Column(name="CONT_DFLT_YN")	
	private String CONT_DFLT_YN;
	
	@Column(name="CONT_FRZ_FLAG")
	private String CONT_FRZ_FLAG;
	
	
	//@Column(name="ROWID")
	//private String ROWID;
	
	private boolean checkBox;

	
	public boolean isInsertMode() {
		return insertMode;
	}
	
	public void setInsertMode(boolean insertMode) {
		this.insertMode = insertMode;
	}

	public String getCONT_TEL_AREA_CODE() {
		return CONT_TEL_AREA_CODE;
	}

	public void setCONT_TEL_AREA_CODE(String CONT_TEL_AREA_CODE) {
		this.CONT_TEL_AREA_CODE = CONT_TEL_AREA_CODE;
	}

	public String getCONT_MOBILE_NO() {
		return CONT_MOBILE_NO;
	}

	public void setCONT_MOBILE_NO(String CONT_MOBILE_NO) {
		this.CONT_MOBILE_NO = CONT_MOBILE_NO;
	}

	public String getCONT_POSTAL_CODE() {
		return CONT_POSTAL_CODE;
	}

	public void setCONT_POSTAL_CODE(String CONT_POSTAL_CODE) {
		this.CONT_POSTAL_CODE = CONT_POSTAL_CODE;
	}

	public String getCONT_STATE_CODE() {
		return CONT_STATE_CODE;
	}

	public void setCONT_STATE_CODE(String CONT_STATE_CODE) {
		this.CONT_STATE_CODE = CONT_STATE_CODE;
	}

	public String getCONT_BIRTH_CERT_NO() {
		return CONT_BIRTH_CERT_NO;
	}

	public void setCONT_BIRTH_CERT_NO(String CONT_BIRTH_CERT_NO) {
		this.CONT_BIRTH_CERT_NO = CONT_BIRTH_CERT_NO;
	}

	public String getCONT_MAR_STATUS() {
		return CONT_MAR_STATUS;
	}

	public void setCONT_MAR_STATUS(String CONT_MAR_STATUS) {
		this.CONT_MAR_STATUS = CONT_MAR_STATUS;
	}

	public String getCONT_RELIGION() {
		return CONT_RELIGION;
	}

	public void setCONT_RELIGION(String CONT_RELIGION) {
		this.CONT_RELIGION = CONT_RELIGION;
	}

	public String getCONT_AREA() {
		return CONT_AREA;
	}

	public void setCONT_AREA(String CONT_AREA) {
		this.CONT_AREA = CONT_AREA;
	}

	public String getCONT_EMPLOYER_YN() {
		return CONT_EMPLOYER_YN;
	}

	public void setCONT_EMPLOYER_YN(String CONT_EMPLOYER_YN) {
		this.CONT_EMPLOYER_YN = CONT_EMPLOYER_YN;
	}

	public String getCONT_PREFERRED_LANG() {
		return CONT_PREFERRED_LANG;
	}

	public void setCONT_PREFERRED_LANG(String CONT_PREFERRED_LANG) {
		this.CONT_PREFERRED_LANG = CONT_PREFERRED_LANG;
	}

	public Double getCONT_LC_PROP_DEP_AMT() {
		return CONT_LC_PROP_DEP_AMT;
	}

	public void setCONT_LC_PROP_DEP_AMT(Double CONT_LC_PROP_DEP_AMT) {
		this.CONT_LC_PROP_DEP_AMT = CONT_LC_PROP_DEP_AMT;
	}

	public Double getCONT_LC_POL_DEP_AMT() {
		return CONT_LC_POL_DEP_AMT;
	}

	public void setCONT_LC_POL_DEP_AMT(Double CONT_LC_POL_DEP_AMT) {
		this.CONT_LC_POL_DEP_AMT = CONT_LC_POL_DEP_AMT;
	}

	public String getCONT_AD_BANK_CODE() {
		return CONT_AD_BANK_CODE;
	}

	public void setCONT_AD_BANK_CODE(String CONT_AD_BANK_CODE) {
		this.CONT_AD_BANK_CODE = CONT_AD_BANK_CODE;
	}

	public Date getCONT_EFF_FM_DT() {
		 return CONT_EFF_FM_DT;
	}

	public void setCONT_EFF_FM_DT(Date CONT_EFF_FM_DT) {
		this.CONT_EFF_FM_DT = CONT_EFF_FM_DT;
	}

	public String getCONT_REMARKS() {
		return CONT_REMARKS;
	}

	public void setCONT_REMARKS(String CONT_REMARKS) {
		this.CONT_REMARKS = CONT_REMARKS;
	}

	public String getCONT_BL_ADDR1() {
		return CONT_BL_ADDR1;
	}

	public void setCONT_BL_ADDR1(String CONT_BL_ADDR1) {
		this.CONT_BL_ADDR1 = CONT_BL_ADDR1;
	}

	public String getCONT_BL_NAME() {
		return CONT_BL_NAME;
	}

	public void setCONT_BL_NAME(String CONT_BL_NAME) {
		this.CONT_BL_NAME = CONT_BL_NAME;
	}

	public String getCONT_BL_ADDR2() {
		return CONT_BL_ADDR2;
	}

	public void setCONT_BL_ADDR2(String CONT_BL_ADDR2) {
		this.CONT_BL_ADDR2 = CONT_BL_ADDR2;
	}

	public String getCONT_BL_ADDR3() {
		return CONT_BL_ADDR3;
	}

	public void setCONT_BL_ADDR3(String CONT_BL_ADDR3) {
		this.CONT_BL_ADDR3 = CONT_BL_ADDR3;
	}

	public String getCONT_BL_CONTACT() {
		return CONT_BL_CONTACT;
	}

	public void setCONT_BL_CONTACT(String CONT_BL_CONTACT) {
		this.CONT_BL_CONTACT = CONT_BL_CONTACT;
	}

	public String getCONT_PHONE() {
		return CONT_PHONE;
	}

	public void setCONT_PHONE(String CONT_PHONE) {
		this.CONT_PHONE = CONT_PHONE;
	}

	public String getCONT_STATE() {
		return CONT_STATE;
	}

	public void setCONT_STATE(String CONT_STATE) {
		this.CONT_STATE = CONT_STATE;
	}

	public String getUI_M_CONT_MAR_STATUS_DESC() {
		return UI_M_CONT_MAR_STATUS_DESC;
	}

	public void setUI_M_CONT_MAR_STATUS_DESC(String UI_M_CONT_MAR_STATUS_DESC) {
		this.UI_M_CONT_MAR_STATUS_DESC = UI_M_CONT_MAR_STATUS_DESC;
	}

	public String getUI_M_CONT_RELIGION_DESC() {
		return UI_M_CONT_RELIGION_DESC;
	}

	public void setUI_M_CONT_RELIGION_DESC(String UI_M_CONT_RELIGION_DESC) {
		this.UI_M_CONT_RELIGION_DESC = UI_M_CONT_RELIGION_DESC;
	}

	public String getUI_M_CONT_AD_BANK_NAME() {
		return UI_M_CONT_AD_BANK_NAME;
	}

	public void setUI_M_CONT_AD_BANK_NAME(String UI_M_CONT_AD_BANK_NAME) {
		
		this.UI_M_CONT_AD_BANK_NAME = UI_M_CONT_AD_BANK_NAME;
	}

	public String getCONT_CODE() {
		
		return CONT_CODE;
	}

	public void setCONT_CODE(String CONT_CODE) {

		this.CONT_CODE = CONT_CODE;
	}

	public String getCONT_REF_ID1() {
		return CONT_REF_ID1;
	}

	public void setCONT_REF_ID1(String CONT_REF_ID1) {
		this.CONT_REF_ID1 = CONT_REF_ID1;
	}

	public String getCONT_REF_ID2() {
		return CONT_REF_ID2;
	}

	public void setCONT_REF_ID2(String CONT_REF_ID2) {
		this.CONT_REF_ID2 = CONT_REF_ID2;
	}

	public String getCONT_NAME() {
		return CONT_NAME;
	}

	public void setCONT_NAME(String CONT_NAME) {
		this.CONT_NAME = CONT_NAME;
	}

	public String getCONT_ADDR1() {
		return CONT_ADDR1;
	}

	public void setCONT_ADDR1(String CONT_ADDR1) {
		this.CONT_ADDR1 = CONT_ADDR1;
	}

	public String getCONT_ADDR2() {
		return CONT_ADDR2;
	}

	public void setCONT_ADDR2(String CONT_ADDR2) {
		this.CONT_ADDR2 = CONT_ADDR2;
	}

	public String getCONT_ADDR3() {
		return CONT_ADDR3;
	}

	public void setCONT_ADDR3(String CONT_ADDR3) {
		this.CONT_ADDR3 = CONT_ADDR3;
	}

	public String getCONT_CONTACT() {
		return CONT_CONTACT;
	}

	public void setCONT_CONTACT(String CONT_CONTACT) {
		this.CONT_CONTACT = CONT_CONTACT;
	}

	public String getCONT_FAX_AREA_CODE() {
		return CONT_FAX_AREA_CODE;
	}

	public void setCONT_FAX_AREA_CODE(String CONT_FAX_AREA_CODE) {
		this.CONT_FAX_AREA_CODE = CONT_FAX_AREA_CODE;
	}

	public String getCONT_EMAIL_ID() {
		return CONT_EMAIL_ID;
	}

	public void setCONT_EMAIL_ID(String CONT_EMAIL_ID) {
		this.CONT_EMAIL_ID = CONT_EMAIL_ID;
	}

	public String getCONT_CITY_CODE() {
		return CONT_CITY_CODE;
	}

	public void setCONT_CITY_CODE(String CONT_CITY_CODE) {
		this.CONT_CITY_CODE = CONT_CITY_CODE;
	}

	public String getCONT_COUNT_CODE() {
		return CONT_COUNT_CODE;
	}

	public void setCONT_COUNT_CODE(String CONT_COUNT_CODE) {
		this.CONT_COUNT_CODE = CONT_COUNT_CODE;
	}

	public Date getCONT_DOB() {
		 return CONT_DOB;
	}

	public void setCONT_DOB(Date CONT_DOB) {
		this.CONT_DOB = CONT_DOB;
	}

	public String getCONT_CATG_CODE() {
		return CONT_CATG_CODE;
	}

	public void setCONT_CATG_CODE(String CONT_CATG_CODE) {
		this.CONT_CATG_CODE = CONT_CATG_CODE;
	}

	public String getCONT_NATIONALITY_CODE() {
		return CONT_NATIONALITY_CODE;
	}

	public void setCONT_NATIONALITY_CODE(String CONT_NATIONALITY_CODE) {
		this.CONT_NATIONALITY_CODE = CONT_NATIONALITY_CODE;
	}

	public String getCONT_RACE() {
		return CONT_RACE;
	}

	public void setCONT_RACE(String CONT_RACE) {
		this.CONT_RACE = CONT_RACE;
	}

	public String getCONT_REGION() {
		return CONT_REGION;
	}

	public void setCONT_REGION(String CONT_REGION) {
		this.CONT_REGION = CONT_REGION;
	}

	public String getCONT_REF_NO() {
		return CONT_REF_NO;
	}

	public void setCONT_REF_NO(String CONT_REF_NO) {
		this.CONT_REF_NO = CONT_REF_NO;
	}

	public Double getCONT_LC_PROP_UTIL_AMT() {
		return CONT_LC_PROP_UTIL_AMT;
	}

	public void setCONT_LC_PROP_UTIL_AMT(Double CONT_LC_PROP_UTIL_AMT) {
		this.CONT_LC_PROP_UTIL_AMT = CONT_LC_PROP_UTIL_AMT;
	}

	public Double getCONT_LC_POL_UTIL_AMT() {
		return CONT_LC_POL_UTIL_AMT;
	}

	public void setCONT_LC_POL_UTIL_AMT(Double CONT_LC_POL_UTIL_AMT) {
		this.CONT_LC_POL_UTIL_AMT = CONT_LC_POL_UTIL_AMT;
	}

	public String getCONT_AD_ACC_NO() {
		return CONT_AD_ACC_NO;
	}

	public void setCONT_AD_ACC_NO(String CONT_AD_ACC_NO) {
		this.CONT_AD_ACC_NO = CONT_AD_ACC_NO;
	}

	public Date getCONT_EFF_TO_DT() {
		 return CONT_EFF_TO_DT;
	}

	public void setCONT_EFF_TO_DT(Date CONT_EFF_TO_DT) {
		this.CONT_EFF_TO_DT = CONT_EFF_TO_DT;
	}

	public String getCONT_FAX() {
		return CONT_FAX;
	}

	public void setCONT_FAX(String CONT_FAX) {
		this.CONT_FAX = CONT_FAX;
	}

	public String getCONT_CITY() {
		return CONT_CITY;
	}

	public void setCONT_CITY(String CONT_CITY) {
		this.CONT_CITY = CONT_CITY;
	}

	public String getCONT_COUNTRY() {
		return CONT_COUNTRY;
	}

	public void setCONT_COUNTRY(String CONT_COUNTRY) {
		this.CONT_COUNTRY = CONT_COUNTRY;
	}

	public String getUI_M_CONT_CATG_CODE_DESC() {
		return UI_M_CONT_CATG_CODE_DESC;
	}

	public void setUI_M_CONT_CATG_CODE_DESC(String UI_M_CONT_CATG_CODE_DESC) {
		this.UI_M_CONT_CATG_CODE_DESC = UI_M_CONT_CATG_CODE_DESC;
	}

	public String getUI_M_CONT_NATIONALITY_CODE_DESC() {
		return UI_M_CONT_NATIONALITY_CODE_DESC;
	}

	public void setUI_M_CONT_NATIONALITY_CODE_DESC(String UI_M_CONT_NATIONALITY_CODE_DESC) {
		this.UI_M_CONT_NATIONALITY_CODE_DESC = UI_M_CONT_NATIONALITY_CODE_DESC;
	}

	public String getUI_M_CONT_RACE_DESC() {
		
		return UI_M_CONT_RACE_DESC;
	}

	public void setUI_M_CONT_RACE_DESC(String UI_M_CONT_RACE_DESC) {
	
		this.UI_M_CONT_RACE_DESC = UI_M_CONT_RACE_DESC;
	}

	

	public String getCONT_CR_UID() {
		return CONT_CR_UID;
	}

	public void setCONT_CR_UID(String cont_cr_uid) {
		CONT_CR_UID = cont_cr_uid;
	}

	public Date getCONT_CR_DT() {
		return CONT_CR_DT;
	}

	public void setCONT_CR_DT(Date cont_cr_dt) {
		CONT_CR_DT = cont_cr_dt;
	}

	public String getCONT_DFLT_YN() {
		return CONT_DFLT_YN;
	}

	public void setCONT_DFLT_YN(String cont_dflt_yn) {
		CONT_DFLT_YN = cont_dflt_yn;
	}

	public String getCONT_FRZ_FLAG() {
		return CONT_FRZ_FLAG;
	}

	public void setCONT_FRZ_FLAG(String cont_frz_flag) {
		CONT_FRZ_FLAG = cont_frz_flag;
	}

	/*public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}
*/
	public boolean isCheckBox() {
		return checkBox;
	}

	public void setCheckBox(boolean checkBox) {
		this.checkBox = checkBox;
	}

	public String getUI_M_CONT_CITY_CODE_DESC() {
		return UI_M_CONT_CITY_CODE_DESC;
	}

	public void setUI_M_CONT_CITY_CODE_DESC(String ui_m_cont_city_code_desc) {
		UI_M_CONT_CITY_CODE_DESC = ui_m_cont_city_code_desc;
	}

	public String getUI_M_CONT_STATE_CODE_DESC() {
		return UI_M_CONT_STATE_CODE_DESC;
	}

	public void setUI_M_CONT_STATE_CODE_DESC(String ui_m_cont_state_code_desc) {
		UI_M_CONT_STATE_CODE_DESC = ui_m_cont_state_code_desc;
	}

	public Date getCONT_UPD_DT() {
		return CONT_UPD_DT;
	}

	public void setCONT_UPD_DT(Date cont_upd_dt) {
		CONT_UPD_DT = cont_upd_dt;
	}

	public String getCONT_UPD_UID() {
		return CONT_UPD_UID;
	}

	public void setCONT_UPD_UID(String cont_upd_uid) {
		CONT_UPD_UID = cont_upd_uid;
	}

	public String getCONT_PASS_NO() {
		return CONT_PASS_NO;
	}

	public void setCONT_PASS_NO(String cont_pass_no) {
		CONT_PASS_NO = cont_pass_no;
	}

	public String getCONT_CUST_CODE() {
		return CONT_CUST_CODE;
	}

	public void setCONT_CUST_CODE(String cont_cust_code) {
		CONT_CUST_CODE = cont_cust_code;
	}
	
	/*Added by Janani on 07.06.2017 for SSP id ZBILQC-1726439*/
	
	@Column(name="CONT_MOB_AREA_CODE")
	private String CONT_MOB_AREA_CODE;
	
	private String CONT_SOCIAL_MEDIA_TYPE;
	
	private String CONT_SOCIAL_MEDIA_MAIL_ID;

	public String getCONT_MOB_AREA_CODE() {
		return CONT_MOB_AREA_CODE;
	}

	public void setCONT_MOB_AREA_CODE(String cONT_MOB_AREA_CODE) {
		CONT_MOB_AREA_CODE = cONT_MOB_AREA_CODE;
	}

	public String getCONT_SOCIAL_MEDIA_TYPE() {
		return CONT_SOCIAL_MEDIA_TYPE;
	}

	public void setCONT_SOCIAL_MEDIA_TYPE(String cONT_SOCIAL_MEDIA_TYPE) {
		CONT_SOCIAL_MEDIA_TYPE = cONT_SOCIAL_MEDIA_TYPE;
	}

	public String getCONT_SOCIAL_MEDIA_MAIL_ID() {
		return CONT_SOCIAL_MEDIA_MAIL_ID;
	}

	public void setCONT_SOCIAL_MEDIA_MAIL_ID(String cONT_SOCIAL_MEDIA_MAIL_ID) {
		CONT_SOCIAL_MEDIA_MAIL_ID = cONT_SOCIAL_MEDIA_MAIL_ID;
	}
	
	
	
	
	
	/*eND*/
	
	/*Added by Ameen on 01-03-2018 for KIC*/
	@Column(name="CONT_PHY_ADDR1")
	private String CONT_PHY_ADDR1;
	
	@Column(name="CONT_PHY_ADDR2")
	private String CONT_PHY_ADDR2;
	
	@Column(name="CONT_PHY_ADDR3")
	private String CONT_PHY_ADDR3;
	
	@Column(name="CONT_PHY_CITY_CODE")
	private String CONT_PHY_CITY_CODE;
	
	@Column(name="CONT_PHY_CITY")
	private String CONT_PHY_CITY;
	
	@Column(name="CONT_PHY_COUNT_CODE")
	private String CONT_PHY_COUNT_CODE;
	
	@Column(name="CONT_PHY_COUNTRY")
	private String CONT_PHY_COUNTRY;
	
	@Column(name="CONT_PHY_POSTAL_CODE")
	private String CONT_PHY_POSTAL_CODE;
	
	@Column(name="CONT_PHY_MOB_AREA_CODE")
	private String CONT_PHY_MOB_AREA_CODE;
	
	@Column(name="CONT_PHY_MOBILE_NO")
	private String CONT_PHY_MOBILE_NO;
	
	@Column(name="CONT_PHY_TEL_AREA_CODE")
	private String CONT_PHY_TEL_AREA_CODE;
	
	@Column(name="CONT_PHY_PHONE")
	private String CONT_PHY_PHONE;
	
	@Column(name="CONT_PHY_FAX_AREA_CODE")
	private String CONT_PHY_FAX_AREA_CODE;
	
	@Column(name="CONT_PHY_FAX")
	private String CONT_PHY_FAX;
	
	@Column(name="CONT_PHY_EMAIL_ID")
	private String CONT_PHY_EMAIL_ID;
	
	@Column(name="CONT_CORR_ADDR1")
	private String CONT_CORR_ADDR1;
	
	@Column(name="CONT_CORR_ADDR2")
	private String CONT_CORR_ADDR2;
	
	@Column(name="CONT_CORR_ADDR3")
	private String CONT_CORR_ADDR3;
	
	@Column(name="CONT_CORR_CITY_CODE")
	private String CONT_CORR_CITY_CODE;
	
	@Column(name="CONT_CORR_CITY")
	private String CONT_CORR_CITY;
	
	@Column(name="CONT_CORR_COUNT_CODE")
	private String CONT_CORR_COUNT_CODE;
	
	@Column(name="CONT_CORR_COUNTRY")
	private String CONT_CORR_COUNTRY;
	
	@Column(name="CONT_CORR_POSTAL_CODE")
	private String CONT_CORR_POSTAL_CODE;
	
	@Column(name="CONT_CORR_MOB_CODE")
	private String CONT_CORR_MOB_CODE;
	
	@Column(name="CONT_CORR_MOBILE_NO")
	private String CONT_CORR_MOBILE_NO;
	
	@Column(name="CONT_CORR_TEL_AREA_CODE")
	private String CONT_CORR_TEL_AREA_CODE;
	
	@Column(name="CONT_CORR_PHONE")
	private String CONT_CORR_PHONE;
	
	@Column(name="CONT_CORR_FAX_AREA_CODE")
	private String CONT_CORR_FAX_AREA_CODE;
	
	@Column(name="CONT_CORR_FAX")
	private String CONT_CORR_FAX;
	
	@Column(name="CONT_CORR_EMAIL_ID")
	private String CONT_CORR_EMAIL_ID;

	public String getCONT_PHY_ADDR1() {
		return CONT_PHY_ADDR1;
	}

	public void setCONT_PHY_ADDR1(String cONT_PHY_ADDR1) {
		CONT_PHY_ADDR1 = cONT_PHY_ADDR1;
	}

	public String getCONT_PHY_ADDR2() {
		return CONT_PHY_ADDR2;
	}

	public void setCONT_PHY_ADDR2(String cONT_PHY_ADDR2) {
		CONT_PHY_ADDR2 = cONT_PHY_ADDR2;
	}

	public String getCONT_PHY_ADDR3() {
		return CONT_PHY_ADDR3;
	}

	public void setCONT_PHY_ADDR3(String cONT_PHY_ADDR3) {
		CONT_PHY_ADDR3 = cONT_PHY_ADDR3;
	}

	public String getCONT_PHY_CITY_CODE() {
		return CONT_PHY_CITY_CODE;
	}

	public void setCONT_PHY_CITY_CODE(String cONT_PHY_CITY_CODE) {
		CONT_PHY_CITY_CODE = cONT_PHY_CITY_CODE;
	}

	public String getCONT_PHY_CITY() {
		return CONT_PHY_CITY;
	}

	public void setCONT_PHY_CITY(String cONT_PHY_CITY) {
		CONT_PHY_CITY = cONT_PHY_CITY;
	}

	public String getCONT_PHY_COUNT_CODE() {
		return CONT_PHY_COUNT_CODE;
	}

	public void setCONT_PHY_COUNT_CODE(String cONT_PHY_COUNT_CODE) {
		CONT_PHY_COUNT_CODE = cONT_PHY_COUNT_CODE;
	}

	public String getCONT_PHY_COUNTRY() {
		return CONT_PHY_COUNTRY;
	}

	public void setCONT_PHY_COUNTRY(String cONT_PHY_COUNTRY) {
		CONT_PHY_COUNTRY = cONT_PHY_COUNTRY;
	}

	public String getCONT_PHY_POSTAL_CODE() {
		return CONT_PHY_POSTAL_CODE;
	}

	public void setCONT_PHY_POSTAL_CODE(String cONT_PHY_POSTAL_CODE) {
		CONT_PHY_POSTAL_CODE = cONT_PHY_POSTAL_CODE;
	}

	public String getCONT_PHY_MOB_AREA_CODE() {
		return CONT_PHY_MOB_AREA_CODE;
	}

	public void setCONT_PHY_MOB_AREA_CODE(String cONT_PHY_MOB_AREA_CODE) {
		CONT_PHY_MOB_AREA_CODE = cONT_PHY_MOB_AREA_CODE;
	}

	public String getCONT_PHY_MOBILE_NO() {
		return CONT_PHY_MOBILE_NO;
	}

	public void setCONT_PHY_MOBILE_NO(String cONT_PHY_MOBILE_NO) {
		CONT_PHY_MOBILE_NO = cONT_PHY_MOBILE_NO;
	}

	public String getCONT_PHY_TEL_AREA_CODE() {
		return CONT_PHY_TEL_AREA_CODE;
	}

	public void setCONT_PHY_TEL_AREA_CODE(String cONT_PHY_TEL_AREA_CODE) {
		CONT_PHY_TEL_AREA_CODE = cONT_PHY_TEL_AREA_CODE;
	}

	public String getCONT_PHY_PHONE() {
		return CONT_PHY_PHONE;
	}

	public void setCONT_PHY_PHONE(String cONT_PHY_PHONE) {
		CONT_PHY_PHONE = cONT_PHY_PHONE;
	}

	public String getCONT_PHY_FAX_AREA_CODE() {
		return CONT_PHY_FAX_AREA_CODE;
	}

	public void setCONT_PHY_FAX_AREA_CODE(String cONT_PHY_FAX_AREA_CODE) {
		CONT_PHY_FAX_AREA_CODE = cONT_PHY_FAX_AREA_CODE;
	}

	public String getCONT_PHY_FAX() {
		return CONT_PHY_FAX;
	}

	public void setCONT_PHY_FAX(String cONT_PHY_FAX) {
		CONT_PHY_FAX = cONT_PHY_FAX;
	}

	public String getCONT_PHY_EMAIL_ID() {
		return CONT_PHY_EMAIL_ID;
	}

	public void setCONT_PHY_EMAIL_ID(String cONT_PHY_EMAIL_ID) {
		CONT_PHY_EMAIL_ID = cONT_PHY_EMAIL_ID;
	}

	public String getCONT_CORR_ADDR1() {
		return CONT_CORR_ADDR1;
	}

	public void setCONT_CORR_ADDR1(String cONT_CORR_ADDR1) {
		CONT_CORR_ADDR1 = cONT_CORR_ADDR1;
	}

	public String getCONT_CORR_ADDR2() {
		return CONT_CORR_ADDR2;
	}

	public void setCONT_CORR_ADDR2(String cONT_CORR_ADDR2) {
		CONT_CORR_ADDR2 = cONT_CORR_ADDR2;
	}

	public String getCONT_CORR_ADDR3() {
		return CONT_CORR_ADDR3;
	}

	public void setCONT_CORR_ADDR3(String cONT_CORR_ADDR3) {
		CONT_CORR_ADDR3 = cONT_CORR_ADDR3;
	}

	public String getCONT_CORR_CITY_CODE() {
		return CONT_CORR_CITY_CODE;
	}

	public void setCONT_CORR_CITY_CODE(String cONT_CORR_CITY_CODE) {
		CONT_CORR_CITY_CODE = cONT_CORR_CITY_CODE;
	}

	public String getCONT_CORR_CITY() {
		return CONT_CORR_CITY;
	}

	public void setCONT_CORR_CITY(String cONT_CORR_CITY) {
		CONT_CORR_CITY = cONT_CORR_CITY;
	}

	public String getCONT_CORR_COUNT_CODE() {
		return CONT_CORR_COUNT_CODE;
	}

	public void setCONT_CORR_COUNT_CODE(String cONT_CORR_COUNT_CODE) {
		CONT_CORR_COUNT_CODE = cONT_CORR_COUNT_CODE;
	}

	public String getCONT_CORR_COUNTRY() {
		return CONT_CORR_COUNTRY;
	}

	public void setCONT_CORR_COUNTRY(String cONT_CORR_COUNTRY) {
		CONT_CORR_COUNTRY = cONT_CORR_COUNTRY;
	}

	public String getCONT_CORR_POSTAL_CODE() {
		return CONT_CORR_POSTAL_CODE;
	}

	public void setCONT_CORR_POSTAL_CODE(String cONT_CORR_POSTAL_CODE) {
		CONT_CORR_POSTAL_CODE = cONT_CORR_POSTAL_CODE;
	}

	public String getCONT_CORR_MOB_CODE() {
		return CONT_CORR_MOB_CODE;
	}

	public void setCONT_CORR_MOB_CODE(String cONT_CORR_MOB_CODE) {
		CONT_CORR_MOB_CODE = cONT_CORR_MOB_CODE;
	}

	public String getCONT_CORR_MOBILE_NO() {
		return CONT_CORR_MOBILE_NO;
	}

	public void setCONT_CORR_MOBILE_NO(String cONT_CORR_MOBILE_NO) {
		CONT_CORR_MOBILE_NO = cONT_CORR_MOBILE_NO;
	}

	public String getCONT_CORR_TEL_AREA_CODE() {
		return CONT_CORR_TEL_AREA_CODE;
	}

	public void setCONT_CORR_TEL_AREA_CODE(String cONT_CORR_TEL_AREA_CODE) {
		CONT_CORR_TEL_AREA_CODE = cONT_CORR_TEL_AREA_CODE;
	}

	public String getCONT_CORR_PHONE() {
		return CONT_CORR_PHONE;
	}

	public void setCONT_CORR_PHONE(String cONT_CORR_PHONE) {
		CONT_CORR_PHONE = cONT_CORR_PHONE;
	}

	public String getCONT_CORR_FAX_AREA_CODE() {
		return CONT_CORR_FAX_AREA_CODE;
	}

	public void setCONT_CORR_FAX_AREA_CODE(String cONT_CORR_FAX_AREA_CODE) {
		CONT_CORR_FAX_AREA_CODE = cONT_CORR_FAX_AREA_CODE;
	}

	public String getCONT_CORR_FAX() {
		return CONT_CORR_FAX;
	}

	public void setCONT_CORR_FAX(String cONT_CORR_FAX) {
		CONT_CORR_FAX = cONT_CORR_FAX;
	}

	public String getCONT_CORR_EMAIL_ID() {
		return CONT_CORR_EMAIL_ID;
	}

	public void setCONT_CORR_EMAIL_ID(String cONT_CORR_EMAIL_ID) {
		CONT_CORR_EMAIL_ID = cONT_CORR_EMAIL_ID;
	}
	
	
	/*End*/
	
	/*Added by Janani on 05.04.2018 for KIC  assured dtls screen*/

	@Column(name="CONT_OCC_CODE")
	private String CONT_OCC_CODE;
	
	private String UI_M_CONT_OCC_DESC;

	public String getCONT_OCC_CODE() {
		return CONT_OCC_CODE;
	}

	public void setCONT_OCC_CODE(String cONT_OCC_CODE) {
		CONT_OCC_CODE = cONT_OCC_CODE;
	}

	public String getUI_M_CONT_OCC_DESC() {
		return UI_M_CONT_OCC_DESC;
	}

	public void setUI_M_CONT_OCC_DESC(String uI_M_CONT_OCC_DESC) {
		UI_M_CONT_OCC_DESC = uI_M_CONT_OCC_DESC;
	}
	
	
	/*End*/
}
