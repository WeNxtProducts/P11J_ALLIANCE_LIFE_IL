package com.iii.pel.forms.PM010_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.constants.PELConstants;

@Table(name="PM_COMPANY")
public class PM010_A_COMPANY extends BaseValueBean{
	
	@Column(name="COMP_CODE")
	private String COMP_CODE;
	
	@Column(name="COMP_NAME")
	private String COMP_NAME;
	
	@Column(name="COMP_SHORT_NAME")
	private String COMP_SHORT_NAME;
	
	@Column(name="COMP_ADDR1")
	private String COMP_ADDR1;

	@Column(name="COMP_ADDR2")
	private String COMP_ADDR2;
	
	@Column(name="COMP_ADDR3")
	private String COMP_ADDR3;

	@Column(name="COMP_DFLT_DIVN")
	private String COMP_DFLT_DIVN;
	
	private String COMP_DFLT_DIVN_NAME;
	
	@Column(name="COMP_DFLT_DEPT")
	private String COMP_DFLT_DEPT;
	
	private String COMP_DFLT_DEPT_NAME;

	@Column(name="COMP_CEO_NAME")
	private String COMP_CEO_NAME;
	
	@Column(name="COMP_BL_NAME")
	private String COMP_BL_NAME;

	@Column(name="COMP_BL_SHORT_NAME")
	private String COMP_BL_SHORT_NAME;
	
	@Column(name="COMP_BL_ADDR1")
	private String COMP_BL_ADDR1;

	@Column(name="COMP_BL_ADDR2")
	private String COMP_BL_ADDR2;
	
	@Column(name="COMP_BL_ADDR3")
	private String COMP_BL_ADDR3;

	@Column(name="COMP_BL_CEO_NAME")
	private String COMP_BL_CEO_NAME;
	
	@Column(name="COMP_PHONE")
	private String COMP_PHONE;
	
	@Column(name="COMP_FAX")
	private String COMP_FAX;
	
	@Column(name="COMP_FRZ_FLAG")
	private String COMP_FRZ_FLAG;
	
	@Column(name="COMP_CR_DT")
	private Date COMP_CR_DT;
	
	@Column(name="COMP_EMAIL")
	private String COMP_EMAIL;
	
	@Column(name="COMP_WEB_SITE")
	private String COMP_WEB_SITE;
	
	@Column(name="COMP_UPD_UID")
	private String COMP_UPD_UID;
	
	@Column(name="COMP_UPD_DT")
	private Date COMP_UPD_DT;
	
	@Column(name="COMP_CR_UID")
	private String COMP_CR_UID;
	
	private boolean FRZ_FLAG;
	
	public String getCOMP_CODE() {
		return COMP_CODE;
	}

	public void setCOMP_CODE(String cOMP_CODE) {
		COMP_CODE = cOMP_CODE;
	}

	public String getCOMP_NAME() {
		return COMP_NAME;
	}

	public void setCOMP_NAME(String cOMP_NAME) {
		COMP_NAME = cOMP_NAME;
	}

	public String getCOMP_SHORT_NAME() {
		return COMP_SHORT_NAME;
	}

	public void setCOMP_SHORT_NAME(String cOMP_SHORT_NAME) {
		COMP_SHORT_NAME = cOMP_SHORT_NAME;
	}

	public String getCOMP_ADDR1() {
		return COMP_ADDR1;
	}

	public void setCOMP_ADDR1(String cOMP_ADDR1) {
		COMP_ADDR1 = cOMP_ADDR1;
	}

	public String getCOMP_ADDR2() {
		return COMP_ADDR2;
	}

	public void setCOMP_ADDR2(String cOMP_ADDR2) {
		COMP_ADDR2 = cOMP_ADDR2;
	}

	public String getCOMP_ADDR3() {
		return COMP_ADDR3;
	}

	public void setCOMP_ADDR3(String cOMP_ADDR3) {
		COMP_ADDR3 = cOMP_ADDR3;
	}

	public String getCOMP_DFLT_DIVN() {
		return COMP_DFLT_DIVN;
	}

	public void setCOMP_DFLT_DIVN(String cOMP_DFLT_DIVN) {
		COMP_DFLT_DIVN = cOMP_DFLT_DIVN;
	}

	public String getCOMP_DFLT_DEPT() {
		return COMP_DFLT_DEPT;
	}

	public void setCOMP_DFLT_DEPT(String cOMP_DFLT_DEPT) {
		COMP_DFLT_DEPT = cOMP_DFLT_DEPT;
	}

	public String getCOMP_CEO_NAME() {
		return COMP_CEO_NAME;
	}

	public void setCOMP_CEO_NAME(String cOMP_CEO_NAME) {
		COMP_CEO_NAME = cOMP_CEO_NAME;
	}

	public String getCOMP_BL_NAME() {
		return COMP_BL_NAME;
	}

	public void setCOMP_BL_NAME(String cOMP_BL_NAME) {
		COMP_BL_NAME = cOMP_BL_NAME;
	}

	public String getCOMP_BL_SHORT_NAME() {
		return COMP_BL_SHORT_NAME;
	}

	public void setCOMP_BL_SHORT_NAME(String cOMP_BL_SHORT_NAME) {
		COMP_BL_SHORT_NAME = cOMP_BL_SHORT_NAME;
	}

	public String getCOMP_BL_ADDR1() {
		return COMP_BL_ADDR1;
	}

	public void setCOMP_BL_ADDR1(String cOMP_BL_ADDR1) {
		COMP_BL_ADDR1 = cOMP_BL_ADDR1;
	}

	public String getCOMP_BL_ADDR2() {
		return COMP_BL_ADDR2;
	}

	public void setCOMP_BL_ADDR2(String cOMP_BL_ADDR2) {
		COMP_BL_ADDR2 = cOMP_BL_ADDR2;
	}

	public String getCOMP_BL_ADDR3() {
		return COMP_BL_ADDR3;
	}

	public void setCOMP_BL_ADDR3(String cOMP_BL_ADDR3) {
		COMP_BL_ADDR3 = cOMP_BL_ADDR3;
	}

	public String getCOMP_BL_CEO_NAME() {
		return COMP_BL_CEO_NAME;
	}

	public void setCOMP_BL_CEO_NAME(String cOMP_BL_CEO_NAME) {
		COMP_BL_CEO_NAME = cOMP_BL_CEO_NAME;
	}

	public String getCOMP_PHONE() {
		return COMP_PHONE;
	}

	public void setCOMP_PHONE(String cOMP_PHONE) {
		COMP_PHONE = cOMP_PHONE;
	}

	public String getCOMP_FAX() {
		return COMP_FAX;
	}

	public void setCOMP_FAX(String cOMP_FAX) {
		COMP_FAX = cOMP_FAX;
	}

	public String getCOMP_FRZ_FLAG() {
		return COMP_FRZ_FLAG;
	}

	public void setCOMP_FRZ_FLAG(String cOMP_FRZ_FLAG) {
		COMP_FRZ_FLAG = cOMP_FRZ_FLAG;
	}

	public Date getCOMP_CR_DT() {
		return COMP_CR_DT;
	}

	public void setCOMP_CR_DT(Date cOMP_CR_DT) {
		COMP_CR_DT = cOMP_CR_DT;
	}

	public String getCOMP_EMAIL() {
		return COMP_EMAIL;
	}

	public void setCOMP_EMAIL(String cOMP_EMAIL) {
		COMP_EMAIL = cOMP_EMAIL;
	}

	public String getCOMP_WEB_SITE() {
		return COMP_WEB_SITE;
	}

	public void setCOMP_WEB_SITE(String cOMP_WEB_SITE) {
		COMP_WEB_SITE = cOMP_WEB_SITE;
	}

	public String getCOMP_UPD_UID() {
		return COMP_UPD_UID;
	}

	public void setCOMP_UPD_UID(String cOMP_UPD_UID) {
		COMP_UPD_UID = cOMP_UPD_UID;
	}

	public Date getCOMP_UPD_DT() {
		return COMP_UPD_DT;
	}

	public void setCOMP_UPD_DT(Date cOMP_UPD_DT) {
		COMP_UPD_DT = cOMP_UPD_DT;
	}

	public String getCOMP_CR_UID() {
		return COMP_CR_UID;
	}

	public void setCOMP_CR_UID(String cOMP_CR_UID) {
		COMP_CR_UID = cOMP_CR_UID;
	}

	public String getCOMP_DFLT_DIVN_NAME() {
		return COMP_DFLT_DIVN_NAME;
	}

	public void setCOMP_DFLT_DIVN_NAME(String cOMP_DFLT_DIVN_NAME) {
		COMP_DFLT_DIVN_NAME = cOMP_DFLT_DIVN_NAME;
	}

	public String getCOMP_DFLT_DEPT_NAME() {
		return COMP_DFLT_DEPT_NAME;
	}

	public void setCOMP_DFLT_DEPT_NAME(String cOMP_DFLT_DEPT_NAME) {
		COMP_DFLT_DEPT_NAME = cOMP_DFLT_DEPT_NAME;
	}

	public boolean isFRZ_FLAG() {
		return FRZ_FLAG;
	}

	public void setFRZ_FLAG(boolean fRZ_FLAG) {
		FRZ_FLAG = fRZ_FLAG;
	}
	
	
	/*Added by Janani for factory testing feedback changes on 12.04.2017*/
	
	@Column(name="COMP_DEF_NATION")
	private String COMP_DEF_NATION;

	private String UI_M_COMP_DEF_NATION_DESC;
	
	
	public String getCOMP_DEF_NATION() {
		return COMP_DEF_NATION;
	}

	public void setCOMP_DEF_NATION(String cOMP_DEF_NATION) {
		COMP_DEF_NATION = cOMP_DEF_NATION;
	}

	public String getUI_M_COMP_DEF_NATION_DESC() {
		return UI_M_COMP_DEF_NATION_DESC;
	}

	public void setUI_M_COMP_DEF_NATION_DESC(String uI_M_COMP_DEF_NATION_DESC) {
		UI_M_COMP_DEF_NATION_DESC = uI_M_COMP_DEF_NATION_DESC;
	}
	
	
	
	/*End*/
	
	

	
}
