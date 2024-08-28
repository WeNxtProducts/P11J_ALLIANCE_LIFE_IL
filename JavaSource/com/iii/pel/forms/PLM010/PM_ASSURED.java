package com.iii.pel.forms.PLM010;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_ASSURED")
public class PM_ASSURED extends BaseValueBean {
	
	
	@Column(name="ROWID")
	private String ROWID;
	
	private boolean ASSR_FRZ_FLAG_CHECK;

	@Column(name="ASSR_FRZ_FLAG")
	private String ASSR_FRZ_FLAG;

	@Column(name="ASSR_CODE")
	private String ASSR_CODE;

	@Column(name="ASSR_NAME")
	private String ASSR_NAME;

	@Column(name="ASSR_OCC_CODE")
	private String ASSR_OCC_CODE;

	private String UI_M_ASSR_OCC_DESC;

	@Column(name="ASSR_FLOOR")
	private String ASSR_FLOOR;

	@Column(name="ASSR_BUILDING")
	private String ASSR_BUILDING;

	@Column(name="ASSR_STREET")
	private String ASSR_STREET;

	@Column(name="ASSR_ADDR1")
	private String ASSR_ADDR1;

	@Column(name="ASSR_ADDR2")
	private String ASSR_ADDR2;

	@Column(name="ASSR_ADDR3")
	private String ASSR_ADDR3;

	@Column(name="ASSR_CONTACT")
	private String ASSR_CONTACT;

	@Column(name="ASSR_FAX")
	private String ASSR_FAX;

	@Column(name="ASSR_PHONE")
	private String ASSR_PHONE;

	@Column(name="ASSR_OFFICE_PHONE")
	private String ASSR_OFFICE_PHONE;

	@Column(name="ASSR_PIN_NO")
	private String ASSR_PIN_NO;

	@Column(name="ASSR_DOB")
	private Date ASSR_DOB;

	@Column(name="ASSR_ID_NO")
	private String ASSR_ID_NO;

	@Column(name="ASSR_VAT_NO")
	private String ASSR_VAT_NO;

	@Column(name="ASSR_REMARKS")
	private String ASSR_REMARKS;

	@Column(name="ASSR_DFLT_YN")
	private String ASSR_DFLT_YN;

	@Column(name="ASSR_BL_NAME")
	private String ASSR_BL_NAME;

	@Column(name="ASSR_BL_ADDR1")
	private String ASSR_BL_ADDR1;

	@Column(name="ASSR_BL_ADDR2")
	private String ASSR_BL_ADDR2;

	@Column(name="ASSR_BL_ADDR3")
	private String ASSR_BL_ADDR3;

	@Column(name="ASSR_BL_CONTACT")
	private String ASSR_BL_CONTACT;
	
	@Column(name="ASSR_CUST_CODE")
	private String ASSR_CUST_CODE;

	private String PC_CR_UID;
	
	private Date PC_CR_DT;	
	
	private boolean selected;
	
	private String CONT_CODE;
	
	private String CUST_CODE;
	
	private String CUST_NAME;
	
	private boolean freezeFlag;
	
	private boolean valStatus;
	
	private boolean checkBoxSelected;
	
	private boolean insertMode=true;
	
	public boolean isValStatus() {
		return valStatus;
	}

	public void setValStatus(boolean valStatus) {
		this.valStatus = valStatus;
	}

	public boolean isFreezeFlag() {
		return freezeFlag;
	}

	public void setFreezeFlag(boolean freezeFlag) {
		this.freezeFlag = freezeFlag;
	}

	public Date getPC_CR_DT() {
		return PC_CR_DT;
	}

	public void setPC_CR_DT(Date pc_cr_dt) {
		PC_CR_DT = pc_cr_dt;
	}

	public String getPC_CR_UID() {
		return PC_CR_UID;
	}

	public void setPC_CR_UID(String pc_cr_uid) {
		PC_CR_UID = pc_cr_uid;
	}

	public String getASSR_FRZ_FLAG() {
		if(ASSR_FRZ_FLAG_CHECK) {
			ASSR_FRZ_FLAG = "Y";
		} else {
			ASSR_FRZ_FLAG = "N";
		}
		return ASSR_FRZ_FLAG;
	}

	public void setASSR_FRZ_FLAG(String ASSR_FRZ_FLAG) {
		if("Y".equalsIgnoreCase(ASSR_FRZ_FLAG)) {
			ASSR_FRZ_FLAG_CHECK = true;
		} else {
			ASSR_FRZ_FLAG_CHECK = false;
		}
		this.ASSR_FRZ_FLAG = ASSR_FRZ_FLAG;
	}

	public String getASSR_CODE() {
		return ASSR_CODE;
	}

	public void setASSR_CODE(String ASSR_CODE) {
		this.ASSR_CODE = ASSR_CODE;
	}

	public String getASSR_NAME() {
		return ASSR_NAME;
	}

	public void setASSR_NAME(String ASSR_NAME) {
		this.ASSR_NAME = ASSR_NAME;
	}

	public String getASSR_OCC_CODE() {
		return ASSR_OCC_CODE;
	}

	public void setASSR_OCC_CODE(String ASSR_OCC_CODE) {
		this.ASSR_OCC_CODE = ASSR_OCC_CODE;
	}

	public String getUI_M_ASSR_OCC_DESC() {
		return UI_M_ASSR_OCC_DESC;
	}

	public void setUI_M_ASSR_OCC_DESC(String UI_M_ASSR_OCC_DESC) {
		this.UI_M_ASSR_OCC_DESC = UI_M_ASSR_OCC_DESC;
	}

	public String getASSR_FLOOR() {
		return ASSR_FLOOR;
	}

	public void setASSR_FLOOR(String ASSR_FLOOR) {
		this.ASSR_FLOOR = ASSR_FLOOR;
	}

	public String getASSR_BUILDING() {
		return ASSR_BUILDING;
	}

	public void setASSR_BUILDING(String ASSR_BUILDING) {
		this.ASSR_BUILDING = ASSR_BUILDING;
	}

	public String getASSR_STREET() {
		return ASSR_STREET;
	}

	public void setASSR_STREET(String ASSR_STREET) {
		this.ASSR_STREET = ASSR_STREET;
	}

	public String getASSR_ADDR1() {
		return ASSR_ADDR1;
	}

	public void setASSR_ADDR1(String ASSR_ADDR1) {
		this.ASSR_ADDR1 = ASSR_ADDR1;
	}

	public String getASSR_ADDR2() {
		return ASSR_ADDR2;
	}

	public void setASSR_ADDR2(String ASSR_ADDR2) {
		this.ASSR_ADDR2 = ASSR_ADDR2;
	}

	public String getASSR_ADDR3() {
		return ASSR_ADDR3;
	}

	public void setASSR_ADDR3(String ASSR_ADDR3) {
		this.ASSR_ADDR3 = ASSR_ADDR3;
	}

	public String getASSR_CONTACT() {
		return ASSR_CONTACT;
	}

	public void setASSR_CONTACT(String ASSR_CONTACT) {
		this.ASSR_CONTACT = ASSR_CONTACT;
	}

	public String getASSR_FAX() {
		return ASSR_FAX;
	}

	public void setASSR_FAX(String ASSR_FAX) {
		this.ASSR_FAX = ASSR_FAX;
	}

	public String getASSR_PHONE() {
		return ASSR_PHONE;
	}

	public void setASSR_PHONE(String ASSR_PHONE) {
		this.ASSR_PHONE = ASSR_PHONE;
	}

	public String getASSR_OFFICE_PHONE() {
		return ASSR_OFFICE_PHONE;
	}

	public void setASSR_OFFICE_PHONE(String ASSR_OFFICE_PHONE) {
		this.ASSR_OFFICE_PHONE = ASSR_OFFICE_PHONE;
	}

	public String getASSR_PIN_NO() {
		return ASSR_PIN_NO;
	}

	public void setASSR_PIN_NO(String ASSR_PIN_NO) {
		this.ASSR_PIN_NO = ASSR_PIN_NO;
	}

	public Date getASSR_DOB() {
		 return ASSR_DOB;
	}

	public void setASSR_DOB(Date ASSR_DOB) {
		this.ASSR_DOB = ASSR_DOB;
	}

	public String getASSR_ID_NO() {
		return ASSR_ID_NO;
	}

	public void setASSR_ID_NO(String ASSR_ID_NO) {
		this.ASSR_ID_NO = ASSR_ID_NO;
	}

	public String getASSR_VAT_NO() {
		return ASSR_VAT_NO;
	}

	public void setASSR_VAT_NO(String ASSR_VAT_NO) {
		this.ASSR_VAT_NO = ASSR_VAT_NO;
	}

	public String getASSR_REMARKS() {
		return ASSR_REMARKS;
	}

	public void setASSR_REMARKS(String ASSR_REMARKS) {
		this.ASSR_REMARKS = ASSR_REMARKS;
	}

	public String getASSR_DFLT_YN() {
		return ASSR_DFLT_YN;
	}

	public void setASSR_DFLT_YN(String ASSR_DFLT_YN) {
		this.ASSR_DFLT_YN = ASSR_DFLT_YN;
		System.out.println("Assured default" + this.ASSR_DFLT_YN);
	}

	public String getASSR_BL_NAME() {
		return ASSR_BL_NAME;
	}

	public void setASSR_BL_NAME(String ASSR_BL_NAME) {
		this.ASSR_BL_NAME = ASSR_BL_NAME;
	}

	public String getASSR_BL_ADDR1() {
		return ASSR_BL_ADDR1;
	}

	public void setASSR_BL_ADDR1(String ASSR_BL_ADDR1) {
		this.ASSR_BL_ADDR1 = ASSR_BL_ADDR1;
	}

	public String getASSR_BL_ADDR2() {
		return ASSR_BL_ADDR2;
	}

	public void setASSR_BL_ADDR2(String ASSR_BL_ADDR2) {
		this.ASSR_BL_ADDR2 = ASSR_BL_ADDR2;
	}

	public String getASSR_BL_ADDR3() {
		return ASSR_BL_ADDR3;
	}

	public void setASSR_BL_ADDR3(String ASSR_BL_ADDR3) {
		this.ASSR_BL_ADDR3 = ASSR_BL_ADDR3;
	}

	public String getASSR_BL_CONTACT() {
		return ASSR_BL_CONTACT;
	}

	public void setASSR_BL_CONTACT(String ASSR_BL_CONTACT) {
		this.ASSR_BL_CONTACT = ASSR_BL_CONTACT;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public String getCONT_CODE() {
		return CONT_CODE;
	}

	public void setCONT_CODE(String cont_code) {
		CONT_CODE = cont_code;
	}

	public String getCUST_CODE() {
		return CUST_CODE;
	}

	public void setCUST_CODE(String cust_code) {
		CUST_CODE = cust_code;
	}

	public String getCUST_NAME() {
		return CUST_NAME;
	}

	public void setCUST_NAME(String cust_name) {
		CUST_NAME = cust_name;
	}

	public String getASSR_CUST_CODE() {
		return ASSR_CUST_CODE;
	}

	public void setASSR_CUST_CODE(String assr_cust_code) {
		ASSR_CUST_CODE = assr_cust_code;
	}

	public boolean isInsertMode() {
		return insertMode;
	}

	public void setInsertMode(boolean insertMode) {
		this.insertMode = insertMode;
	}

	public boolean isCheckBoxSelected() {
		return checkBoxSelected;
	}

	public void setCheckBoxSelected(boolean checkBoxSelected) {
		this.checkBoxSelected = checkBoxSelected;
	}

	public boolean isASSR_FRZ_FLAG_CHECK() {
		if("Y".equals(ASSR_FRZ_FLAG)) {
			ASSR_FRZ_FLAG_CHECK = true;
		} else {
			ASSR_FRZ_FLAG_CHECK = false;
		}
		return ASSR_FRZ_FLAG_CHECK;
	}

	public void setASSR_FRZ_FLAG_CHECK(boolean assr_frz_flag_check) {
		ASSR_FRZ_FLAG_CHECK = assr_frz_flag_check;
	}
}
