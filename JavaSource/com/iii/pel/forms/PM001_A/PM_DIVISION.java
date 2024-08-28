package com.iii.pel.forms.PM001_A;
import java.io.*;
import java.util.*;
import com.iii.apps.persistence.*;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="PM_DIVISION")
public class PM_DIVISION extends BaseValueBean {

	@Column(name="DIVN_CODE")
	private String DIVN_CODE;

	@Column(name="DIVN_NAME")
	private String DIVN_NAME;

	@Column(name="DIVN_SHORT_NAME")
	private String DIVN_SHORT_NAME;

	@Column(name="DIVN_COMP_CODE")
	private String DIVN_COMP_CODE;

	@Column(name="DIVN_ADDR1")
	private String DIVN_ADDR1;

	@Column(name="DIVN_ADDR2")
	private String DIVN_ADDR2;

	@Column(name="DIVN_ADDR3")
	private String DIVN_ADDR3;

	@Column(name="DIVN_MGR_NAME")
	private String DIVN_MGR_NAME;

	@Column(name="DIVN_PHONE")
	private String DIVN_PHONE;

	@Column(name="DIVN_FAX")
	private String DIVN_FAX;

	@Column(name="DIVN_BL_NAME")
	private String DIVN_BL_NAME;

	@Column(name="DIVN_BL_SHORT_NAME")
	private String DIVN_BL_SHORT_NAME;

	@Column(name="DIVN_BL_ADDR1")
	private String DIVN_BL_ADDR1;

	@Column(name="DIVN_BL_ADDR2")
	private String DIVN_BL_ADDR2;

	@Column(name="DIVN_BL_ADDR3")
	private String DIVN_BL_ADDR3;

	@Column(name="DIVN_BL_MGR_NAME")
	private String DIVN_BL_MGR_NAME;

	@Column(name="DIVN_FRZ_FLAG")
	private String DIVN_FRZ_FLAG = "N";

	@Column(name="DIVN_CR_DT")
	private Date DIVN_CR_DT;

	@Column(name="DIVN_CR_UID")
	private String DIVN_CR_UID;

	@Column(name="DIVN_UPD_DT")
	private Date DIVN_UPD_DT;

	@Column(name="DIVN_UPD_UID")
	private String DIVN_UPD_UID;

	@Column(name="DIVN_CONTRA_ACNT_CODE")
	private String DIVN_CONTRA_ACNT_CODE;

	private String UI_M_COMP_NAME;
	
	private String UI_M_CONTRA_ACNT_DESC;
	
	private boolean UI_DIVN_FRZ_FLAG;
	
	
	public boolean isUI_DIVN_FRZ_FLAG() {
		return UI_DIVN_FRZ_FLAG;
	}
	public void setUI_DIVN_FRZ_FLAG(boolean ui_divn_frz_flag) {
		DIVN_FRZ_FLAG = CommonUtils.booleanToStriingConvertor(ui_divn_frz_flag);
		UI_DIVN_FRZ_FLAG = ui_divn_frz_flag;
	}
	public void setDIVN_CONTRA_ACNT_CODE(String DIVN_CONTRA_ACNT_CODE) {
		this.DIVN_CONTRA_ACNT_CODE = DIVN_CONTRA_ACNT_CODE;
	}
	public String getDIVN_CONTRA_ACNT_CODE() {
		 return DIVN_CONTRA_ACNT_CODE;
	}
	public void setDIVN_CR_UID(String DIVN_CR_UID) {
		this.DIVN_CR_UID = DIVN_CR_UID;
	}
	public String getDIVN_CR_UID() {
		 return DIVN_CR_UID;
	}
	public void setDIVN_ADDR2(String DIVN_ADDR2) {
		this.DIVN_ADDR2 = DIVN_ADDR2;
	}
	public String getDIVN_ADDR2() {
		 return DIVN_ADDR2;
	}
	public void setDIVN_CODE(String DIVN_CODE) {
		this.DIVN_CODE = DIVN_CODE;
	}
	public String getDIVN_CODE() {
		 return DIVN_CODE;
	}
	public void setDIVN_ADDR1(String DIVN_ADDR1) {
		this.DIVN_ADDR1 = DIVN_ADDR1;
	}
	public String getDIVN_ADDR1() {
		 return DIVN_ADDR1;
	}
	public void setDIVN_FAX(String DIVN_FAX) {
		this.DIVN_FAX = DIVN_FAX;
	}
	public String getDIVN_FAX() {
		 return DIVN_FAX;
	}
	public void setDIVN_UPD_UID(String DIVN_UPD_UID) {
		this.DIVN_UPD_UID = DIVN_UPD_UID;
	}
	public String getDIVN_UPD_UID() {
		 return DIVN_UPD_UID;
	}
	public void setDIVN_BL_MGR_NAME(String DIVN_BL_MGR_NAME) {
		this.DIVN_BL_MGR_NAME = DIVN_BL_MGR_NAME;
	}
	public String getDIVN_BL_MGR_NAME() {
		 return DIVN_BL_MGR_NAME;
	}
	public void setDIVN_BL_NAME(String DIVN_BL_NAME) {
		this.DIVN_BL_NAME = DIVN_BL_NAME;
	}
	public String getDIVN_BL_NAME() {
		 return DIVN_BL_NAME;
	}
	public void setDIVN_BL_SHORT_NAME(String DIVN_BL_SHORT_NAME) {
		this.DIVN_BL_SHORT_NAME = DIVN_BL_SHORT_NAME;
	}
	public String getDIVN_BL_SHORT_NAME() {
		 return DIVN_BL_SHORT_NAME;
	}
	public void setUI_M_CONTRA_ACNT_DESC(String UI_M_CONTRA_ACNT_DESC) {
		this.UI_M_CONTRA_ACNT_DESC = UI_M_CONTRA_ACNT_DESC;
	}
	public String getUI_M_CONTRA_ACNT_DESC() {
		 return UI_M_CONTRA_ACNT_DESC;
	}
	public void setDIVN_FRZ_FLAG(String DIVN_FRZ_FLAG) {
		UI_DIVN_FRZ_FLAG = CommonUtils.stringToBooleanConvertor(DIVN_FRZ_FLAG);
		this.DIVN_FRZ_FLAG = DIVN_FRZ_FLAG;
	}
	public String getDIVN_FRZ_FLAG() {
		 return DIVN_FRZ_FLAG;
	}
	public void setDIVN_BL_ADDR2(String DIVN_BL_ADDR2) {
		this.DIVN_BL_ADDR2 = DIVN_BL_ADDR2;
	}
	public String getDIVN_BL_ADDR2() {
		 return DIVN_BL_ADDR2;
	}
	public void setDIVN_BL_ADDR3(String DIVN_BL_ADDR3) {
		this.DIVN_BL_ADDR3 = DIVN_BL_ADDR3;
	}
	public String getDIVN_BL_ADDR3() {
		 return DIVN_BL_ADDR3;
	}
	public void setUI_M_COMP_NAME(String UI_M_COMP_NAME) {
		this.UI_M_COMP_NAME = UI_M_COMP_NAME;
	}
	public String getUI_M_COMP_NAME() {
		 return UI_M_COMP_NAME;
	}
	public void setDIVN_UPD_DT(Date DIVN_UPD_DT) {
		this.DIVN_UPD_DT = DIVN_UPD_DT;
	}
	public Date getDIVN_UPD_DT() {
		 return DIVN_UPD_DT;
	}
	public void setDIVN_ADDR3(String DIVN_ADDR3) {
		this.DIVN_ADDR3 = DIVN_ADDR3;
	}
	public String getDIVN_ADDR3() {
		 return DIVN_ADDR3;
	}
	public void setDIVN_MGR_NAME(String DIVN_MGR_NAME) {
		this.DIVN_MGR_NAME = DIVN_MGR_NAME;
	}
	public String getDIVN_MGR_NAME() {
		 return DIVN_MGR_NAME;
	}
	public void setDIVN_PHONE(String DIVN_PHONE) {
		this.DIVN_PHONE = DIVN_PHONE;
	}
	public String getDIVN_PHONE() {
		 return DIVN_PHONE;
	}
	public void setDIVN_CR_DT(Date DIVN_CR_DT) {
		this.DIVN_CR_DT = DIVN_CR_DT;
	}
	public Date getDIVN_CR_DT() {
		 return DIVN_CR_DT;
	}
	public void setDIVN_BL_ADDR1(String DIVN_BL_ADDR1) {
		this.DIVN_BL_ADDR1 = DIVN_BL_ADDR1;
	}
	public String getDIVN_BL_ADDR1() {
		 return DIVN_BL_ADDR1;
	}
	public void setDIVN_COMP_CODE(String DIVN_COMP_CODE) {
		this.DIVN_COMP_CODE = DIVN_COMP_CODE;
	}
	public String getDIVN_COMP_CODE() {
		 return DIVN_COMP_CODE;
	}
	public void setDIVN_NAME(String DIVN_NAME) {
		this.DIVN_NAME = DIVN_NAME;
	}
	public String getDIVN_NAME() {
		 return DIVN_NAME;
	}
	public void setDIVN_SHORT_NAME(String DIVN_SHORT_NAME) {
		this.DIVN_SHORT_NAME = DIVN_SHORT_NAME;
	}
	public String getDIVN_SHORT_NAME() {
		 return DIVN_SHORT_NAME;
	}

}