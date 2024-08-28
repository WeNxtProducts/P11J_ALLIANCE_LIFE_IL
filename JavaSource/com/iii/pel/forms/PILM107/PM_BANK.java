package com.iii.pel.forms.PILM107;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_BANK")
public class PM_BANK extends BaseValueBean{

	
	@Column(name="BANK_CODE")
	private String BANK_CODE;
	
	@Column(name="BANK_NAME")
	private String BANK_NAME;
	
	@Column(name="BANK_UNIVERSAL_CODE")
	private String BANK_UNIVERSAL_CODE;
	
	@Column(name="BANK_BR_CODE")
	private String BANK_BR_CODE;
	
	@Column(name="BANK_SHORT_NAME")
	private String BANK_SHORT_NAME;
	
	@Column(name="BANK_ADDR1")
	private String BANK_ADDR1;
	
	@Column(name="BANK_ADDR2")
	private String BANK_ADDR2;
	
	@Column(name="BANK_ADDR3")
	private String BANK_ADDR3;
	
	@Column(name="BANK_ZIP")
	private String BANK_ZIP;
	
	@Column(name="BANK_PHONE")
	private String BANK_PHONE;
	
	@Column(name="BANK_FAX")
	private String BANK_FAX;
	
	@Column(name="BANK_EMAIL")
	private String BANK_EMAIL;
	
	@Column(name="BANK_WEB_SITE")
	private String BANK_WEB_SITE;
	
	@Column(name="BANK_SWIFT_CODE")
	private String BANK_SWIFT_CODE;
	
	@Column(name="BANK_FRZ_FLAG_NUM")
	private int BANK_FRZ_FLAG_NUM;
	
	@Column(name="BANK_CLIENT_ID")
	private String BANK_CLIENT_ID;
	
	
	
	private boolean UI_M_FREEZE;
		
	public boolean isUI_M_FREEZE() {
		return UI_M_FREEZE;
	}
	public void setUI_M_FREEZE(boolean uI_M_FREEZE) {
		UI_M_FREEZE = uI_M_FREEZE;
		if(isUI_M_FREEZE())
		{
			setBANK_FRZ_FLAG_NUM(1);
		}
		else
		{
			setBANK_FRZ_FLAG_NUM(2);
		}
	}
	
	
	
	public int getBANK_FRZ_FLAG_NUM() {
		return BANK_FRZ_FLAG_NUM;
	}
	public void setBANK_FRZ_FLAG_NUM(int bANK_FRZ_FLAG_NUM) {
		BANK_FRZ_FLAG_NUM = bANK_FRZ_FLAG_NUM;
	}
	public String getBANK_CLIENT_ID() {
		return BANK_CLIENT_ID;
	}
	public void setBANK_CLIENT_ID(String bANK_CLIENT_ID) {
		BANK_CLIENT_ID = bANK_CLIENT_ID;
	}
	public String getBANK_CODE() {
		return BANK_CODE;
	}
	public void setBANK_CODE(String bANK_CODE) {
		BANK_CODE = bANK_CODE;
	}
	public String getBANK_NAME() {
		return BANK_NAME;
	}
	public void setBANK_NAME(String bANK_NAME) {
		BANK_NAME = bANK_NAME;
	}
	public String getBANK_UNIVERSAL_CODE() {
		return BANK_UNIVERSAL_CODE;
	}
	public void setBANK_UNIVERSAL_CODE(String bANK_UNIVERSAL_CODE) {
		BANK_UNIVERSAL_CODE = bANK_UNIVERSAL_CODE;
	}
	public String getBANK_BR_CODE() {
		return BANK_BR_CODE;
	}
	public void setBANK_BR_CODE(String bANK_BR_CODE) {
		BANK_BR_CODE = bANK_BR_CODE;
	}
	public String getBANK_SHORT_NAME() {
		return BANK_SHORT_NAME;
	}
	public void setBANK_SHORT_NAME(String bANK_SHORT_NAME) {
		BANK_SHORT_NAME = bANK_SHORT_NAME;
	}
	public String getBANK_ADDR1() {
		return BANK_ADDR1;
	}
	public void setBANK_ADDR1(String bANK_ADDR1) {
		BANK_ADDR1 = bANK_ADDR1;
	}
	public String getBANK_ADDR2() {
		return BANK_ADDR2;
	}
	public void setBANK_ADDR2(String bANK_ADDR2) {
		BANK_ADDR2 = bANK_ADDR2;
	}
	public String getBANK_ADDR3() {
		return BANK_ADDR3;
	}
	public void setBANK_ADDR3(String bANK_ADDR3) {
		BANK_ADDR3 = bANK_ADDR3;
	}
	public String getBANK_ZIP() {
		return BANK_ZIP;
	}
	public void setBANK_ZIP(String bANK_ZIP) {
		BANK_ZIP = bANK_ZIP;
	}
	public String getBANK_PHONE() {
		return BANK_PHONE;
	}
	public void setBANK_PHONE(String bANK_PHONE) {
		BANK_PHONE = bANK_PHONE;
	}
	public String getBANK_FAX() {
		return BANK_FAX;
	}
	public void setBANK_FAX(String bANK_FAX) {
		BANK_FAX = bANK_FAX;
	}
	public String getBANK_EMAIL() {
		return BANK_EMAIL;
	}
	public void setBANK_EMAIL(String bANK_EMAIL) {
		BANK_EMAIL = bANK_EMAIL;
	}
	public String getBANK_WEB_SITE() {
		return BANK_WEB_SITE;
	}
	public void setBANK_WEB_SITE(String bANK_WEB_SITE) {
		BANK_WEB_SITE = bANK_WEB_SITE;
	}
	public String getBANK_SWIFT_CODE() {
		return BANK_SWIFT_CODE;
	}
	public void setBANK_SWIFT_CODE(String bANK_SWIFT_CODE) {
		BANK_SWIFT_CODE = bANK_SWIFT_CODE;
	}
	
	/*Added by ganesh on 30-5-2017, ZBILQC-1724500 */
	@Column(name="BANK_FLEX_01")
	private String BANK_CONTACT_PERSON;
	@Column(name="BANK_FLEX_02")
	private String BANK_MOBILE;
	@Column(name="BANK_FLEX_03")
	private String BANK_SORT_CODE;
	@Column(name="BANK_FLEX_04")
	private String BANK_LEAD_TIME;
	
	public String getBANK_CONTACT_PERSON() {
		return BANK_CONTACT_PERSON;
	}
	public void setBANK_CONTACT_PERSON(String bANK_CONTACT_PERSON) {
		BANK_CONTACT_PERSON = bANK_CONTACT_PERSON;
	}
	public String getBANK_MOBILE() {
		return BANK_MOBILE;
	}
	public void setBANK_MOBILE(String bANK_MOBILE) {
		BANK_MOBILE = bANK_MOBILE;
	}
	public String getBANK_SORT_CODE() {
		return BANK_SORT_CODE;
	}
	public void setBANK_SORT_CODE(String bANK_SORT_CODE) {
		BANK_SORT_CODE = bANK_SORT_CODE;
	}
	public String getBANK_LEAD_TIME() {
		return BANK_LEAD_TIME;
	}
	public void setBANK_LEAD_TIME(String bANK_LEAD_TIME) {
		BANK_LEAD_TIME = bANK_LEAD_TIME;
	}

	
	@Column(name="BANK_FLEX_05")
	private String BANK_ACCOUNT_NO;
	
	@Column(name="BANK_FLEX_06")
	private String BANK_COLLECTION_COMMSN;

	public String getBANK_ACCOUNT_NO() {
		return BANK_ACCOUNT_NO;
	}
	public void setBANK_ACCOUNT_NO(String bANK_ACCOUNT_NO) {
		BANK_ACCOUNT_NO = bANK_ACCOUNT_NO;
	}
	public String getBANK_COLLECTION_COMMSN() {
		return BANK_COLLECTION_COMMSN;
	}
	public void setBANK_COLLECTION_COMMSN(String bANK_COLLECTION_COMMSN) {
		BANK_COLLECTION_COMMSN = bANK_COLLECTION_COMMSN;
	}
	
	@Column(name="BANK_FLEX_07")
	private String BANK_MOBILE_AREA_CODE;
	@Column(name="BANK_FLEX_08")
	private String BANK_PHONE_AREA_CODE;
	@Column(name="BANK_FLEX_09")
	private String BANK_FAX_AREA_CODE;

	public String getBANK_MOBILE_AREA_CODE() {
		return BANK_MOBILE_AREA_CODE;
	}
	public void setBANK_MOBILE_AREA_CODE(String bANK_MOBILE_AREA_CODE) {
		BANK_MOBILE_AREA_CODE = bANK_MOBILE_AREA_CODE;
	}
	public String getBANK_PHONE_AREA_CODE() {
		return BANK_PHONE_AREA_CODE;
	}
	public void setBANK_PHONE_AREA_CODE(String bANK_PHONE_AREA_CODE) {
		BANK_PHONE_AREA_CODE = bANK_PHONE_AREA_CODE;
	}
	public String getBANK_FAX_AREA_CODE() {
		return BANK_FAX_AREA_CODE;
	}
	public void setBANK_FAX_AREA_CODE(String bANK_FAX_AREA_CODE) {
		BANK_FAX_AREA_CODE = bANK_FAX_AREA_CODE;
	}
	
	@Column(name="BANK_FLEX_10")
	private String BANK_CONTACT_TITLE;

	public String getBANK_CONTACT_TITLE() {
		return BANK_CONTACT_TITLE;
	}
	public void setBANK_CONTACT_TITLE(String bANK_CONTACT_TITLE) {
		BANK_CONTACT_TITLE = bANK_CONTACT_TITLE;
	}
}
