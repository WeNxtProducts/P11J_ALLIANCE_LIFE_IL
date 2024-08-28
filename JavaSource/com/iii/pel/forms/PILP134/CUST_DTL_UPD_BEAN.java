package com.iii.pel.forms.PILP134;

import java.util.Date;

import com.iii.apps.persistence.BaseValueBean;
import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name = "PW_IL_CUST_DTL_UPD")
public class CUST_DTL_UPD_BEAN extends BaseValueBean{
	
	private String CUST_CODE;
	private String CDU_CUST_CODE_DESC;
	
	
	private String CDU_CORRES_COUNTRY_DESC;
	private String CDU_BUS_COUNTRY_DESC;
	private String CDU_BUS_CITY_CODE_DESC;
	
	@Column(name="CDU_BUS_FAX_AREA_CODE")
	private String CDU_BUS_FAX_AREA_CODE;

	@Column(name="CDU_BUS_TEL_AREA_CODE")
	private String CDU_BUS_TEL_AREA_CODE;
	
	@Column(name="CDU_BUS_TEL_AREA_CODE2")
	private String CDU_BUS_TEL_AREA_CODE2;
	
	@Column(name="CDU_TEL_AREA_CODE")
	private String CDU_TEL_AREA_CODE;
	
	@Column(name="CDU_TEL_AREA_CODE2")
	private String CDU_TEL_AREA_CODE2;
	
	@Column(name="CDU_FAX_AREA_CODE")
	private String CDU_FAX_AREA_CODE;
	
	@Column(name="CDU_BUS_MOBILE_NO")
	private String CDU_BUS_MOBILE_NO;
	
	private String POL_NO;
	private String POL_STATUS;
	private String POL_PROD_CODE;
	private String CDU_MAR_STATUS_DESC;
	
	public String getCDU_MAR_STATUS_DESC() {
		return CDU_MAR_STATUS_DESC;
	}

	public void setCDU_MAR_STATUS_DESC(String cDU_MAR_STATUS_DESC) {
		CDU_MAR_STATUS_DESC = cDU_MAR_STATUS_DESC;
	}

	public String getPOL_NO() {
		return POL_NO;
	}

	public void setPOL_NO(String pOL_NO) {
		POL_NO = pOL_NO;
	}

	public String getPOL_STATUS() {
		return POL_STATUS;
	}

	public void setPOL_STATUS(String pOL_STATUS) {
		POL_STATUS = pOL_STATUS;
	}

	public String getPOL_PROD_CODE() {
		return POL_PROD_CODE;
	}

	public void setPOL_PROD_CODE(String pOL_PROD_CODE) {
		POL_PROD_CODE = pOL_PROD_CODE;
	}

	public String getCDU_BUS_FAX_AREA_CODE() {
		return CDU_BUS_FAX_AREA_CODE;
	}

	public void setCDU_BUS_FAX_AREA_CODE(String cDU_BUS_FAX_AREA_CODE) {
		CDU_BUS_FAX_AREA_CODE = cDU_BUS_FAX_AREA_CODE;
	}

	public String getCDU_BUS_TEL_AREA_CODE() {
		return CDU_BUS_TEL_AREA_CODE;
	}

	public void setCDU_BUS_TEL_AREA_CODE(String cDU_BUS_TEL_AREA_CODE) {
		CDU_BUS_TEL_AREA_CODE = cDU_BUS_TEL_AREA_CODE;
	}

	public String getCDU_BUS_TEL_AREA_CODE2() {
		return CDU_BUS_TEL_AREA_CODE2;
	}

	public void setCDU_BUS_TEL_AREA_CODE2(String cDU_BUS_TEL_AREA_CODE2) {
		CDU_BUS_TEL_AREA_CODE2 = cDU_BUS_TEL_AREA_CODE2;
	}

	public String getCDU_TEL_AREA_CODE() {
		return CDU_TEL_AREA_CODE;
	}

	public void setCDU_TEL_AREA_CODE(String cDU_TEL_AREA_CODE) {
		CDU_TEL_AREA_CODE = cDU_TEL_AREA_CODE;
	}

	public String getCDU_TEL_AREA_CODE2() {
		return CDU_TEL_AREA_CODE2;
	}

	public void setCDU_TEL_AREA_CODE2(String cDU_TEL_AREA_CODE2) {
		CDU_TEL_AREA_CODE2 = cDU_TEL_AREA_CODE2;
	}

	public String getCDU_FAX_AREA_CODE() {
		return CDU_FAX_AREA_CODE;
	}

	public void setCDU_FAX_AREA_CODE(String cDU_FAX_AREA_CODE) {
		CDU_FAX_AREA_CODE = cDU_FAX_AREA_CODE;
	}

	public String getCDU_CUST_CODE_DESC() {
		return CDU_CUST_CODE_DESC;
	}

	public void setCDU_CUST_CODE_DESC(String cDU_CUST_CODE_DESC) {
		CDU_CUST_CODE_DESC = cDU_CUST_CODE_DESC;
	}


	public String getCDU_BUS_MOBILE_NO() {
		return CDU_BUS_MOBILE_NO;
	}

	public void setCDU_BUS_MOBILE_NO(String cDU_BUS_MOBILE_NO) {
		CDU_BUS_MOBILE_NO = cDU_BUS_MOBILE_NO;
	}

	public String getCDU_BUS_COUNTRY_DESC() {
		return CDU_BUS_COUNTRY_DESC;
	}

	public void setCDU_BUS_COUNTRY_DESC(String cDU_BUS_COUNTRY_DESC) {
		CDU_BUS_COUNTRY_DESC = cDU_BUS_COUNTRY_DESC;
	}

	public String getCDU_CORRES_COUNTRY_DESC() {
		return CDU_CORRES_COUNTRY_DESC;
	}

	public void setCDU_CORRES_COUNTRY_DESC(String cDU_CORRES_COUNTRY_DESC) {
		CDU_CORRES_COUNTRY_DESC = cDU_CORRES_COUNTRY_DESC;
	}

	public String getCUST_CODE() {
		return CUST_CODE;
	}

	public void setCUST_CODE(String cUST_CODE) {
		CUST_CODE = cUST_CODE;
	}
	
	@Column(name="CDU_SYS_ID")
	private long CDU_SYS_ID;

	@Column(name="CDU_CUST_CODE")
	private String CDU_CUST_CODE;
	
	@Column(name="CDU_CORRES_ADDR1")
	private String CDU_CORRES_ADDR1;
	
	@Column(name="CDU_CORRES_ADDR2")
	private String CDU_CORRES_ADDR2;
	
	@Column(name="CDU_CORRES_ADDR3")
	private String CDU_CORRES_ADDR3;
	
	@Column(name="CDU_CORRES_PHONE")
	private String CDU_CORRES_PHONE;
	
	@Column(name="CDU_CORRES_COUNTRY")
	private String CDU_CORRES_COUNTRY;
	
	@Column(name="CDU_CORRES_FAX")
	private String CDU_CORRES_FAX;
	
	@Column(name="CDU_CORRES_CITY_DESC")
	private String CDU_CORRES_CITY_DESC;
	
	@Column(name="CDU_CORRES_CITY_CODE")
	private String CDU_CORRES_CITY_CODE;
	
	@Column(name="CDU_BUS_ADDR1")
	private String CDU_BUS_ADDR1;
	
	@Column(name="CDU_BUS_ADDR2")
	private String CDU_BUS_ADDR2;
	
	@Column(name="CDU_BUS_ADDR3")
	private String CDU_BUS_ADDR3;
	
	@Column(name="CDU_BUS_PHONE")
	private String CDU_BUS_PHONE;
	
	@Column(name="CDU_BUS_FAX")
	private String CDU_BUS_FAX;
	
	@Column(name="CDU_BUS_COUNTRY")
	private String CDU_BUS_COUNTRY;
	
	@Column(name="CDU_MOBILE_NO")
	private String CDU_MOBILE_NO;
	
	@Column(name="CDU_EMAIL_ID_OFF")
	private String CDU_EMAIL_ID_OFF;
	
	@Column(name="CDU_EMAIL_ID_PER")
	private String CDU_EMAIL_ID_PER;
	
	@Column(name="CDU_CR_DT")
	private Date CDU_CR_DT;
	

	@Column(name="CDU_CORRES_POST_NO")
	private String CDU_CORRES_POST_NO;
	
	@Column(name="CDU_PHY_POST_NO")
	private String CDU_PHY_POST_NO;
	
	@Column(name="CDU_BUS_CITY_CODE")
	private String CDU_BUS_CITY_CODE;
	
	
	
	public String getCDU_CORRES_POST_NO() {
		return CDU_CORRES_POST_NO;
	}

	public void setCDU_CORRES_POST_NO(String cDU_CORRES_POST_NO) {
		CDU_CORRES_POST_NO = cDU_CORRES_POST_NO;
	}

	public String getCDU_PHY_POST_NO() {
		return CDU_PHY_POST_NO;
	}

	public void setCDU_PHY_POST_NO(String cDU_PHY_POST_NO) {
		CDU_PHY_POST_NO = cDU_PHY_POST_NO;
	}

	public String getCDU_BUS_CITY_CODE() {
		return CDU_BUS_CITY_CODE;
	}

	public void setCDU_BUS_CITY_CODE(String cDU_BUS_CITY_CODE) {
		CDU_BUS_CITY_CODE = cDU_BUS_CITY_CODE;
	}

	public String getCDU_BUS_CITY_CODE_DESC() {
		return CDU_BUS_CITY_CODE_DESC;
	}

	public void setCDU_BUS_CITY_CODE_DESC(String cDU_BUS_CITY_CODE_DESC) {
		CDU_BUS_CITY_CODE_DESC = cDU_BUS_CITY_CODE_DESC;
	}

	public long getCDU_SYS_ID() {
		return CDU_SYS_ID;
	}

	public void setCDU_SYS_ID(long cDU_SYS_ID) {
		CDU_SYS_ID = cDU_SYS_ID;
	}

	

	@Column(name="CDU_CR_UID")
	private String CDU_CR_UID;
	
	@Column(name="CDU_MAR_STATUS")
	private String CDU_MAR_STATUS;

	
	public String getCDU_MAR_STATUS() {
		return CDU_MAR_STATUS;
	}

	public void setCDU_MAR_STATUS(String cDU_MAR_STATUS) {
		CDU_MAR_STATUS = cDU_MAR_STATUS;
	}

	public String getCDU_CUST_CODE() {
		return CDU_CUST_CODE;
	}

	public void setCDU_CUST_CODE(String cDU_CUST_CODE) {
		CDU_CUST_CODE = cDU_CUST_CODE;
	}

	public String getCDU_CORRES_ADDR1() {
		return CDU_CORRES_ADDR1;
	}

	public void setCDU_CORRES_ADDR1(String cDU_CORRES_ADDR1) {
		CDU_CORRES_ADDR1 = cDU_CORRES_ADDR1;
	}

	public String getCDU_CORRES_ADDR2() {
		return CDU_CORRES_ADDR2;
	}

	public void setCDU_CORRES_ADDR2(String cDU_CORRES_ADDR2) {
		CDU_CORRES_ADDR2 = cDU_CORRES_ADDR2;
	}

	public String getCDU_CORRES_ADDR3() {
		return CDU_CORRES_ADDR3;
	}

	public void setCDU_CORRES_ADDR3(String cDU_CORRES_ADDR3) {
		CDU_CORRES_ADDR3 = cDU_CORRES_ADDR3;
	}

	public String getCDU_CORRES_PHONE() {
		return CDU_CORRES_PHONE;
	}

	public void setCDU_CORRES_PHONE(String cDU_CORRES_PHONE) {
		CDU_CORRES_PHONE = cDU_CORRES_PHONE;
	}

	public String getCDU_CORRES_COUNTRY() {
		return CDU_CORRES_COUNTRY;
	}

	public void setCDU_CORRES_COUNTRY(String cDU_CORRES_COUNTRY) {
		CDU_CORRES_COUNTRY = cDU_CORRES_COUNTRY;
	}

	public String getCDU_CORRES_FAX() {
		return CDU_CORRES_FAX;
	}

	public void setCDU_CORRES_FAX(String cDU_CORRES_FAX) {
		CDU_CORRES_FAX = cDU_CORRES_FAX;
	}

	public String getCDU_CORRES_CITY_DESC() {
		return CDU_CORRES_CITY_DESC;
	}

	public void setCDU_CORRES_CITY_DESC(String cDU_CORRES_CITY_DESC) {
		CDU_CORRES_CITY_DESC = cDU_CORRES_CITY_DESC;
	}

	public String getCDU_CORRES_CITY_CODE() {
		return CDU_CORRES_CITY_CODE;
	}

	public void setCDU_CORRES_CITY_CODE(String cDU_CORRES_CITY_CODE) {
		CDU_CORRES_CITY_CODE = cDU_CORRES_CITY_CODE;
	}

	public String getCDU_BUS_ADDR1() {
		return CDU_BUS_ADDR1;
	}

	public void setCDU_BUS_ADDR1(String cDU_BUS_ADDR1) {
		CDU_BUS_ADDR1 = cDU_BUS_ADDR1;
	}

	public String getCDU_BUS_ADDR2() {
		return CDU_BUS_ADDR2;
	}

	public void setCDU_BUS_ADDR2(String cDU_BUS_ADDR2) {
		CDU_BUS_ADDR2 = cDU_BUS_ADDR2;
	}

	public String getCDU_BUS_ADDR3() {
		return CDU_BUS_ADDR3;
	}

	public void setCDU_BUS_ADDR3(String cDU_BUS_ADDR3) {
		CDU_BUS_ADDR3 = cDU_BUS_ADDR3;
	}

	public String getCDU_BUS_PHONE() {
		return CDU_BUS_PHONE;
	}

	public void setCDU_BUS_PHONE(String cDU_BUS_PHONE) {
		CDU_BUS_PHONE = cDU_BUS_PHONE;
	}

	public String getCDU_BUS_FAX() {
		return CDU_BUS_FAX;
	}

	public void setCDU_BUS_FAX(String cDU_BUS_FAX) {
		CDU_BUS_FAX = cDU_BUS_FAX;
	}

	public String getCDU_BUS_COUNTRY() {
		return CDU_BUS_COUNTRY;
	}

	public void setCDU_BUS_COUNTRY(String cDU_BUS_COUNTRY) {
		CDU_BUS_COUNTRY = cDU_BUS_COUNTRY;
	}

	public String getCDU_MOBILE_NO() {
		return CDU_MOBILE_NO;
	}

	public void setCDU_MOBILE_NO(String cDU_MOBILE_NO) {
		CDU_MOBILE_NO = cDU_MOBILE_NO;
	}

	public String getCDU_EMAIL_ID_OFF() {
		return CDU_EMAIL_ID_OFF;
	}

	public void setCDU_EMAIL_ID_OFF(String cDU_EMAIL_ID_OFF) {
		CDU_EMAIL_ID_OFF = cDU_EMAIL_ID_OFF;
	}

	public String getCDU_EMAIL_ID_PER() {
		return CDU_EMAIL_ID_PER;
	}

	public void setCDU_EMAIL_ID_PER(String cDU_EMAIL_ID_PER) {
		CDU_EMAIL_ID_PER = cDU_EMAIL_ID_PER;
	}

	

	public Date getCDU_CR_DT() {
		return CDU_CR_DT;
	}

	public void setCDU_CR_DT(Date cDU_CR_DT) {
		CDU_CR_DT = cDU_CR_DT;
	}

	public String getCDU_CR_UID() {
		return CDU_CR_UID;
	}

	public void setCDU_CR_UID(String cDU_CR_UID) {
		CDU_CR_UID = cDU_CR_UID;
	}
	
	/*added by raja on 31-05-2017 for ZBILQC-1724387*/
	@Column(name="CDU_CUST_REF_ID1")
	private String CDU_CUST_REF_ID1;

	public String getCDU_CUST_REF_ID1() {
		return CDU_CUST_REF_ID1;
	}

	public void setCDU_CUST_REF_ID1(String cDU_CUST_REF_ID1) {
		CDU_CUST_REF_ID1 = cDU_CUST_REF_ID1;
	}

	@Column(name="CDU_CUST_NAME")
	private String CDU_CUST_NAME;

	public String getCDU_CUST_NAME() {
		return CDU_CUST_NAME;
	}

	public void setCDU_CUST_NAME(String cDU_CUST_NAME) {
		CDU_CUST_NAME = cDU_CUST_NAME;
	}
	
	/*end*/
	
	/*Added by saritha on 27-06-2017 for ssp call id ZBILQC-1730055*/
	@Column(name="CDU_FIRST_NAME")
	private String CDU_FIRST_NAME;

	public String getCDU_FIRST_NAME() {
		return CDU_FIRST_NAME;
	}

	public void setCDU_FIRST_NAME(String cDU_FIRST_NAME) {
		CDU_FIRST_NAME = cDU_FIRST_NAME;
	}
	
	@Column(name="CDU_MIDDLE_NAME")
	private String CDU_MIDDLE_NAME;

	public String getCDU_MIDDLE_NAME() {
		return CDU_MIDDLE_NAME;
	}

	public void setCDU_MIDDLE_NAME(String cDU_MIDDLE_NAME) {
		CDU_MIDDLE_NAME = cDU_MIDDLE_NAME;
	}
	
	@Column(name="CDU_SURNAME")
	private String CDU_SURNAME;

	public String getCDU_SURNAME() {
		return CDU_SURNAME;
	}

	public void setCDU_SURNAME(String cDU_SURNAME) {
		CDU_SURNAME = cDU_SURNAME;
	}
	
	/*End*/	
	
	
	private String CUST_TYPE;

	public String getCUST_TYPE() {
		return CUST_TYPE;
	}

	public void setCUST_TYPE(String cUST_TYPE) {
		CUST_TYPE = cUST_TYPE;
	}
	//added by gopi
	@Column(name="CDU_AGE_ADMITTED")
	private String CDU_AGE_ADMITTED;

	public String getCDU_AGE_ADMITTED() {
		return CDU_AGE_ADMITTED;
	}

	public void setCDU_AGE_ADMITTED(String cDU_AGE_ADMITTED) {
		CDU_AGE_ADMITTED = cDU_AGE_ADMITTED;
	}
	
/*	@Column(name="CDU_BUS_AGE_ADMITTED")
	private String CDU_BUS_AGE_ADMITTED;

	public String getCDU_BUS_AGE_ADMITTED() {
		return CDU_BUS_AGE_ADMITTED;
	}

	public void setCDU_BUS_AGE_ADMITTED(String cDU_BUS_AGE_ADMITTED) {
		CDU_BUS_AGE_ADMITTED = cDU_BUS_AGE_ADMITTED;
	}*/
	@Column(name="CDU_AGE_PROOF_OTHERS")
	
	private String CDU_AGE_PROOF_OTHERS;

	public String getCDU_AGE_PROOF_OTHERS() {
		return CDU_AGE_PROOF_OTHERS;
	}

	public void setCDU_AGE_PROOF_OTHERS(String cDU_AGE_PROOF_OTHERS) {
		CDU_AGE_PROOF_OTHERS = cDU_AGE_PROOF_OTHERS;
	}
	@Column(name="CDU_AGE_PROOF_FLAG")
	
	private String CDU_AGE_PROOF_FLAG;

	public String getCDU_AGE_PROOF_FLAG() {
		return CDU_AGE_PROOF_FLAG;
	}

	public void setCDU_AGE_PROOF_FLAG(String cDU_AGE_PROOF_FLAG) {
		CDU_AGE_PROOF_FLAG = cDU_AGE_PROOF_FLAG;
	}
/*	@Column(name="CDU_BUS_AGE_PROOF_FLAG")
	
	private String CDU_BUS_AGE_PROOF_FLAG;

	public String getCDU_BUS_AGE_PROOF_FLAG() {
		return CDU_BUS_AGE_PROOF_FLAG;
	}

	public void setCDU_BUS_AGE_PROOF_FLAG(String cDU_BUS_AGE_PROOF_FLAG) {
		CDU_BUS_AGE_PROOF_FLAG = cDU_BUS_AGE_PROOF_FLAG;
	}*/
	/*@Column(name="CDU_BUS_AGE_PROOF_OTHERS")
	
	private String CDU_BUS_AGE_PROOF_OTHERS;
	//end

	public String getCDU_BUS_AGE_PROOF_OTHERS() {
		return CDU_BUS_AGE_PROOF_OTHERS;
	}

	public void setCDU_BUS_AGE_PROOF_OTHERS(String cDU_BUS_AGE_PROOF_OTHERS) {
		CDU_BUS_AGE_PROOF_OTHERS = cDU_BUS_AGE_PROOF_OTHERS;
	}*/
	
	/*Added by Ameen 02-05-2018 fro KIC enabling 3rd address fields*/
	
	@Column(name="CDU_OTH_ADDR1")
	private String CDU_OTH_ADDR1;

	@Column(name="CDU_OTH_ADDR2")
	private String CDU_OTH_ADDR2;
	
	@Column(name="CDU_OTH_ADDR3")
	private String CDU_OTH_ADDR3;
	
	@Column(name="CDU_OTH_CITY_CODE")
	private String CDU_OTH_CITY_CODE;
	
	@Column(name="CDU_OTH_CITY_DESC")
	private String CDU_OTH_CITY_DESC;
	
	@Column(name="CDU_OTH_COUNTRY")
	private String CDU_OTH_COUNTRY;
	
	private String UI_M_CDU_OTH_COUNTRY_DESC;
	
	@Column(name="CDU_OTH_POST_NO")
	private String CDU_OTH_POST_NO;
	
	@Column(name="CDU_OTH_TEL_AREA_CODE")
	private String CDU_OTH_TEL_AREA_CODE;
	
	@Column(name="CDU_OTH_MOBILE_NO")
	private String CDU_OTH_MOBILE_NO;
	
	@Column(name="CDU_OTH_TEL_AREA_CODE2")
	private String CDU_OTH_TEL_AREA_CODE2;
	
	@Column(name="CDU_OTH_PHONE")
	private String CDU_OTH_PHONE;
	
	@Column(name="CDU_OTH_FAX_AREA_CODE")
	private String CDU_OTH_FAX_AREA_CODE;
	
	@Column(name="CDU_OTH_FAX")
	private String CDU_OTH_FAX;
	
	@Column(name="CDU_EMAIL_ID_OTH")
	private String CDU_EMAIL_ID_OTH;
	
	@Column(name="CDU_CUST_REMARKS")
	private String CDU_CUST_REMARKS;
	
	@Column(name="CDU_CUST_OCC_CODE")
	private String CDU_CUST_OCC_CODE;
	
	private String UI_M_CDU_CUST_OCC_CODE_DESC;
	
	@Column(name="CDU_CUST_NATIONALITY_CODE")
	private String CDU_CUST_NATIONALITY_CODE;
	
	@Column(name="CDU_CUST_COMM_ADDR_FLG")
	private String CDU_CUST_COMM_ADDR_FLG;
	
	private boolean UI_M_CDU_COMM_RES_ADDR_FLG;
	
	private boolean UI_M_CDU_COMM_OFF_ADDR_FLG;
	
	private boolean UI_M_CDU_COMM_COR_ADDR_FLG;
	
	private String UI_M_CDU_CUST_NATIONALITY_CODE_DESC;
	
	public String getUI_M_CDU_CUST_OCC_CODE_DESC() {
		return UI_M_CDU_CUST_OCC_CODE_DESC;
	}

	public void setUI_M_CDU_CUST_OCC_CODE_DESC(String uI_M_CDU_CUST_OCC_CODE_DESC) {
		UI_M_CDU_CUST_OCC_CODE_DESC = uI_M_CDU_CUST_OCC_CODE_DESC;
	}

	public String getUI_M_CDU_CUST_NATIONALITY_CODE_DESC() {
		return UI_M_CDU_CUST_NATIONALITY_CODE_DESC;
	}

	public void setUI_M_CDU_CUST_NATIONALITY_CODE_DESC(
			String uI_M_CDU_CUST_NATIONALITY_CODE_DESC) {
		UI_M_CDU_CUST_NATIONALITY_CODE_DESC = uI_M_CDU_CUST_NATIONALITY_CODE_DESC;
	}

	public String getCDU_CUST_REMARKS() {
		return CDU_CUST_REMARKS;
	}

	public void setCDU_CUST_REMARKS(String cDU_CUST_REMARKS) {
		CDU_CUST_REMARKS = cDU_CUST_REMARKS;
	}

	public String getCDU_CUST_OCC_CODE() {
		return CDU_CUST_OCC_CODE;
	}

	public void setCDU_CUST_OCC_CODE(String cDU_CUST_OCC_CODE) {
		CDU_CUST_OCC_CODE = cDU_CUST_OCC_CODE;
	}

	public String getCDU_CUST_NATIONALITY_CODE() {
		return CDU_CUST_NATIONALITY_CODE;
	}

	public void setCDU_CUST_NATIONALITY_CODE(String cDU_CUST_NATIONALITY_CODE) {
		CDU_CUST_NATIONALITY_CODE = cDU_CUST_NATIONALITY_CODE;
	}

	public String getCDU_OTH_ADDR1() {
		return CDU_OTH_ADDR1;
	}

	public void setCDU_OTH_ADDR1(String cDU_OTH_ADDR1) {
		CDU_OTH_ADDR1 = cDU_OTH_ADDR1;
	}

	public String getCDU_OTH_ADDR2() {
		return CDU_OTH_ADDR2;
	}

	public void setCDU_OTH_ADDR2(String cDU_OTH_ADDR2) {
		CDU_OTH_ADDR2 = cDU_OTH_ADDR2;
	}

	public String getCDU_OTH_ADDR3() {
		return CDU_OTH_ADDR3;
	}

	public void setCDU_OTH_ADDR3(String cDU_OTH_ADDR3) {
		CDU_OTH_ADDR3 = cDU_OTH_ADDR3;
	}

	public String getCDU_OTH_CITY_CODE() {
		return CDU_OTH_CITY_CODE;
	}

	public void setCDU_OTH_CITY_CODE(String cDU_OTH_CITY_CODE) {
		CDU_OTH_CITY_CODE = cDU_OTH_CITY_CODE;
	}

	public String getCDU_OTH_CITY_DESC() {
		return CDU_OTH_CITY_DESC;
	}

	public void setCDU_OTH_CITY_DESC(String cDU_OTH_CITY_DESC) {
		CDU_OTH_CITY_DESC = cDU_OTH_CITY_DESC;
	}

	public String getCDU_OTH_COUNTRY() {
		return CDU_OTH_COUNTRY;
	}

	public void setCDU_OTH_COUNTRY(String cDU_OTH_COUNTRY) {
		CDU_OTH_COUNTRY = cDU_OTH_COUNTRY;
	}

	public String getUI_M_CDU_OTH_COUNTRY_DESC() {
		return UI_M_CDU_OTH_COUNTRY_DESC;
	}

	public void setUI_M_CDU_OTH_COUNTRY_DESC(String uI_M_CDU_OTH_COUNTRY_DESC) {
		UI_M_CDU_OTH_COUNTRY_DESC = uI_M_CDU_OTH_COUNTRY_DESC;
	}

	public String getCDU_OTH_POST_NO() {
		return CDU_OTH_POST_NO;
	}

	public void setCDU_OTH_POST_NO(String cDU_OTH_POST_NO) {
		CDU_OTH_POST_NO = cDU_OTH_POST_NO;
	}

	public String getCDU_OTH_TEL_AREA_CODE() {
		return CDU_OTH_TEL_AREA_CODE;
	}

	public void setCDU_OTH_TEL_AREA_CODE(String cDU_OTH_TEL_AREA_CODE) {
		CDU_OTH_TEL_AREA_CODE = cDU_OTH_TEL_AREA_CODE;
	}

	public String getCDU_OTH_MOBILE_NO() {
		return CDU_OTH_MOBILE_NO;
	}

	public void setCDU_OTH_MOBILE_NO(String cDU_OTH_MOBILE_NO) {
		CDU_OTH_MOBILE_NO = cDU_OTH_MOBILE_NO;
	}

	public String getCDU_OTH_TEL_AREA_CODE2() {
		return CDU_OTH_TEL_AREA_CODE2;
	}

	public void setCDU_OTH_TEL_AREA_CODE2(String cDU_OTH_TEL_AREA_CODE2) {
		CDU_OTH_TEL_AREA_CODE2 = cDU_OTH_TEL_AREA_CODE2;
	}

	public String getCDU_OTH_PHONE() {
		return CDU_OTH_PHONE;
	}

	public void setCDU_OTH_PHONE(String cDU_OTH_PHONE) {
		CDU_OTH_PHONE = cDU_OTH_PHONE;
	}

	public String getCDU_OTH_FAX_AREA_CODE() {
		return CDU_OTH_FAX_AREA_CODE;
	}

	public void setCDU_OTH_FAX_AREA_CODE(String cDU_OTH_FAX_AREA_CODE) {
		CDU_OTH_FAX_AREA_CODE = cDU_OTH_FAX_AREA_CODE;
	}

	public String getCDU_OTH_FAX() {
		return CDU_OTH_FAX;
	}

	public void setCDU_OTH_FAX(String cDU_OTH_FAX) {
		CDU_OTH_FAX = cDU_OTH_FAX;
	}

	public String getCDU_EMAIL_ID_OTH() {
		return CDU_EMAIL_ID_OTH;
	}

	public void setCDU_EMAIL_ID_OTH(String cDU_EMAIL_ID_OTH) {
		CDU_EMAIL_ID_OTH = cDU_EMAIL_ID_OTH;
	}

	public String getCDU_CUST_COMM_ADDR_FLG() {
		return CDU_CUST_COMM_ADDR_FLG;
	}

	public void setCDU_CUST_COMM_ADDR_FLG(String cDU_CUST_COMM_ADDR_FLG) {
		CDU_CUST_COMM_ADDR_FLG = cDU_CUST_COMM_ADDR_FLG;
	}

	public boolean isUI_M_CDU_COMM_RES_ADDR_FLG() {
		return UI_M_CDU_COMM_RES_ADDR_FLG;
	}

	public void setUI_M_CDU_COMM_RES_ADDR_FLG(boolean uI_M_CDU_COMM_RES_ADDR_FLG) {
		UI_M_CDU_COMM_RES_ADDR_FLG = uI_M_CDU_COMM_RES_ADDR_FLG;
	}

	public boolean isUI_M_CDU_COMM_OFF_ADDR_FLG() {
		return UI_M_CDU_COMM_OFF_ADDR_FLG;
	}

	public void setUI_M_CDU_COMM_OFF_ADDR_FLG(boolean uI_M_CDU_COMM_OFF_ADDR_FLG) {
		UI_M_CDU_COMM_OFF_ADDR_FLG = uI_M_CDU_COMM_OFF_ADDR_FLG;
	}

	public boolean isUI_M_CDU_COMM_COR_ADDR_FLG() {
		return UI_M_CDU_COMM_COR_ADDR_FLG;
	}

	public void setUI_M_CDU_COMM_COR_ADDR_FLG(boolean uI_M_CDU_COMM_COR_ADDR_FLG) {
		UI_M_CDU_COMM_COR_ADDR_FLG = uI_M_CDU_COMM_COR_ADDR_FLG;
	}
	
	/*End*/
	/*Added by kavitha on 27.07.2018 for KICLIFEQC-1759654*/
	@Column(name="CDU_CATG_CODE")
	private String CDU_CATG_CODE;
	
	@Column(name = "CDU_TITLE")
	private String CDU_TITLE;
	
	private String UI_M_CDU_CATG_CODE_DESC;

	public String getCDU_CATG_CODE() {
		return CDU_CATG_CODE;
	}

	public void setCDU_CATG_CODE(String cDU_CATG_CODE) {
		CDU_CATG_CODE = cDU_CATG_CODE;
	}

	public String getUI_M_CDU_CATG_CODE_DESC() {
		return UI_M_CDU_CATG_CODE_DESC;
	}

	public void setUI_M_CDU_CATG_CODE_DESC(String uI_M_CDU_CATG_CODE_DESC) {
		UI_M_CDU_CATG_CODE_DESC = uI_M_CDU_CATG_CODE_DESC;
	}

	public String getCDU_TITLE() {
		return CDU_TITLE;
	}

	public void setCDU_TITLE(String cDU_TITLE) {
		CDU_TITLE = cDU_TITLE;
	}
	
	
	/*End*/
	
}
