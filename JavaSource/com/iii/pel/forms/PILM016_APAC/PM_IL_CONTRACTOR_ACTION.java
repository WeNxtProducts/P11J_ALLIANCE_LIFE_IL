package com.iii.pel.forms.PILM016_APAC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.vembu.plsql.runtime.functions.ConvertFunctions;
import com.vembu.plsql.runtime.functions.DateFunctions;
import com.vembu.plsql.runtime.functions.MigratingFunctions;
import com.vembu.plsql.runtime.functions.StringFunctions;

public class PM_IL_CONTRACTOR_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CONT_TEL_AREA_CODE_LABEL;

	private HtmlInputText COMP_CONT_TEL_AREA_CODE;

	private HtmlOutputLabel COMP_CONT_MOBILE_NO_LABEL;

	private HtmlInputText COMP_CONT_MOBILE_NO;

	private HtmlOutputLabel COMP_CONT_POSTAL_CODE_LABEL;

	private HtmlInputText COMP_CONT_POSTAL_CODE;

	private HtmlOutputLabel COMP_CONT_STATE_CODE_LABEL;

	private HtmlInputText COMP_CONT_STATE_CODE;

	private HtmlOutputLabel COMP_CONT_BIRTH_CERT_NO_LABEL;

	private HtmlInputText COMP_CONT_BIRTH_CERT_NO;

	private HtmlOutputLabel COMP_CONT_MAR_STATUS_LABEL;

	private HtmlInputText COMP_CONT_MAR_STATUS;

	private HtmlOutputLabel COMP_CONT_RELIGION_LABEL;

	private HtmlInputText COMP_CONT_RELIGION;

	private HtmlOutputLabel COMP_CONT_AREA_LABEL;

	private HtmlInputText COMP_CONT_AREA;

	private HtmlOutputLabel COMP_CONT_EMPLOYER_YN_LABEL;

	private HtmlSelectOneMenu COMP_CONT_EMPLOYER_YN;

	private HtmlOutputLabel COMP_CONT_PREFERRED_LANG_LABEL;

	private HtmlSelectOneMenu COMP_CONT_PREFERRED_LANG;

	private HtmlOutputLabel COMP_CONT_LC_PROP_DEP_AMT_LABEL;

	private HtmlInputText COMP_CONT_LC_PROP_DEP_AMT;

	private HtmlOutputLabel COMP_CONT_LC_POL_DEP_AMT_LABEL;

	private HtmlInputText COMP_CONT_LC_POL_DEP_AMT;

	private HtmlOutputLabel COMP_CONT_AD_BANK_CODE_LABEL;

	private HtmlInputText COMP_CONT_AD_BANK_CODE;

	private HtmlOutputLabel COMP_CONT_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_CONT_EFF_FM_DT;

	private HtmlOutputLabel COMP_CONT_REMARKS_LABEL;

	private HtmlInputText COMP_CONT_REMARKS;

	private HtmlOutputLabel COMP_CONT_BL_ADDR1_LABEL;

	private HtmlInputText COMP_CONT_BL_ADDR1;

	private HtmlOutputLabel COMP_CONT_BL_NAME_LABEL;

	private HtmlInputText COMP_CONT_BL_NAME;

	private HtmlOutputLabel COMP_CONT_BL_ADDR2_LABEL;

	private HtmlInputText COMP_CONT_BL_ADDR2;

	private HtmlOutputLabel COMP_CONT_BL_ADDR3_LABEL;

	private HtmlInputText COMP_CONT_BL_ADDR3;

	private HtmlOutputLabel COMP_CONT_BL_CONTACT_LABEL;

	private HtmlInputText COMP_CONT_BL_CONTACT;

	private HtmlOutputLabel COMP_CONT_PHONE_LABEL;

	private HtmlInputText COMP_CONT_PHONE;

	private HtmlOutputLabel COMP_CONT_STATE_LABEL;

	private HtmlInputText COMP_CONT_STATE;

	private HtmlOutputLabel COMP_UI_M_CONT_MAR_STATUS_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CONT_MAR_STATUS_DESC;

	private HtmlOutputLabel COMP_UI_M_CONT_RELIGION_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CONT_RELIGION_DESC;

	private HtmlOutputLabel COMP_UI_M_CONT_AD_BANK_NAME_LABEL;

	private HtmlInputText COMP_UI_M_CONT_AD_BANK_NAME;

	private HtmlOutputLabel COMP_CONT_CODE_LABEL;

	private HtmlInputText COMP_CONT_CODE;

	private HtmlOutputLabel COMP_CONT_REF_ID1_LABEL;

	private HtmlInputText COMP_CONT_REF_ID1;

	private HtmlOutputLabel COMP_CONT_REF_ID2_LABEL;

	private HtmlInputText COMP_CONT_REF_ID2;

	private HtmlOutputLabel COMP_CONT_NAME_LABEL;

	private HtmlInputText COMP_CONT_NAME;

	private HtmlOutputLabel COMP_CONT_ADDR1_LABEL;

	private HtmlInputText COMP_CONT_ADDR1;

	private HtmlOutputLabel COMP_CONT_ADDR2_LABEL;

	private HtmlInputText COMP_CONT_ADDR2;

	private HtmlOutputLabel COMP_CONT_ADDR3_LABEL;

	private HtmlInputText COMP_CONT_ADDR3;

	private HtmlOutputLabel COMP_CONT_CONTACT_LABEL;

	private HtmlInputText COMP_CONT_CONTACT;

	private HtmlOutputLabel COMP_CONT_FAX_AREA_CODE_LABEL;

	private HtmlInputText COMP_CONT_FAX_AREA_CODE;

	private HtmlOutputLabel COMP_CONT_EMAIL_ID_LABEL;

	private HtmlInputText COMP_CONT_EMAIL_ID;

	private HtmlOutputLabel COMP_CONT_CITY_CODE_LABEL;

	private HtmlInputText COMP_CONT_CITY_CODE;

	private HtmlOutputLabel COMP_CONT_COUNT_CODE_LABEL;

	private HtmlInputText COMP_CONT_COUNT_CODE;

	private HtmlOutputLabel COMP_CONT_DOB_LABEL;

	private HtmlCalendar COMP_CONT_DOB;

	private HtmlOutputLabel COMP_CONT_CATG_CODE_LABEL;

	private HtmlInputText COMP_CONT_CATG_CODE;

	private HtmlOutputLabel COMP_CONT_NATIONALITY_CODE_LABEL;

	private HtmlInputText COMP_CONT_NATIONALITY_CODE;

	private HtmlOutputLabel COMP_CONT_RACE_LABEL;

	private HtmlInputText COMP_CONT_RACE;

	private HtmlOutputLabel COMP_CONT_REGION_LABEL;

	private HtmlInputText COMP_CONT_REGION;

	private HtmlOutputLabel COMP_CONT_REF_NO_LABEL;

	private HtmlInputText COMP_CONT_REF_NO;

	private HtmlOutputLabel COMP_CONT_LC_PROP_UTIL_AMT_LABEL;

	private HtmlInputText COMP_CONT_LC_PROP_UTIL_AMT;

	private HtmlOutputLabel COMP_CONT_LC_POL_UTIL_AMT_LABEL;

	private HtmlInputText COMP_CONT_LC_POL_UTIL_AMT;

	private HtmlOutputLabel COMP_CONT_AD_ACC_NO_LABEL;

	private HtmlInputText COMP_CONT_AD_ACC_NO;

	private HtmlOutputLabel COMP_CONT_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_CONT_EFF_TO_DT;

	private HtmlOutputLabel COMP_CONT_FAX_LABEL;

	private HtmlInputText COMP_CONT_FAX;

	private HtmlOutputLabel COMP_CONT_CITY_LABEL;

	private HtmlInputText COMP_CONT_CITY;

	private HtmlOutputLabel COMP_CONT_COUNTRY_LABEL;

	private HtmlInputText COMP_CONT_COUNTRY;

	private HtmlOutputLabel COMP_UI_M_CONT_CATG_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CONT_CATG_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_CONT_NATIONALITY_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CONT_NATIONALITY_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_CONT_RACE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CONT_RACE_DESC;

	private HtmlCommandButton COMP_PUSH_BUTTON208;

	private HtmlInputText COMP_UI_M_CONT_CITY_CODE_DESC;

	private HtmlInputText COMP_UI_M_CONT_STATE_CODE_DESC;

	private HtmlInputText COMP_CONT_MOB_AREA_CODE;

	private HtmlCommandButton COMP_ITEM158;

	private PM_IL_CONTRACTOR PM_IL_CONTRACTOR_BEAN;

	// Newly Added
	private HtmlOutputText COMP_CONT_CODE_ERROR;

	private HtmlOutputText ACCOUNT_NO_ERROR;

	private HtmlOutputText EFF_FM_DT_ERROR;

	private HtmlOutputText EFF_TO_DT_ERROR;

	private HtmlOutputText ERROR_IC_NUMBER;

	private HtmlCommandButton COMP_UI_M_M_BUT_UPDATE;

	private HtmlCommandButton COMP_UI_M_M_BUT_DELETE;
	
	private HtmlCommandLink COMP_BUT_DELETE;
	
	private HtmlCommandLink COMP_BUT_SAVE;
	
	private HtmlCommandLink COMP_BUT_SAVE2;
	
	private HtmlCommandButton COMP_IMG_DEL;
	
	private HtmlCommandButton COMP_IMG_SAVE;
	
	private HtmlCommandButton COMP_IMG_SAVE2;

	private List marStausCodeList;

	private List catgCodeList;

	private List stateCodeList;

	private List cityCodelist;

	private List religionCodeList;

	private List raceCodeList;

	private List countryCodeList;

	private List receiptBankCodeList;

	private List nationalityCodeList;

	private ArrayList<SelectItem> employerYNCheck;

	private ArrayList<SelectItem> preferredLanguage;

	String bundleName = "com.iii.premia.common.errorUtil.PELErrorMessages";

	// [ BugId:Fix101 MMuthu 17-Dec-2008 Button provision for generating
	// Contractor code
	private HtmlAjaxCommandButton COMP_CONT_GEN_NO;

	public HtmlAjaxCommandButton getCOMP_CONT_GEN_NO() {
		return COMP_CONT_GEN_NO;
	}

	public void setCOMP_CONT_GEN_NO(HtmlAjaxCommandButton comp_cont_gen_no) {
		COMP_CONT_GEN_NO = comp_cont_gen_no;
	}

	// BugId:Fix101 MMuthu 17-Dec-2008 Button provision for generating
	// Contractor code ]

	public ArrayList<SelectItem> getPreferredLanguage() {
		return preferredLanguage;
	}

	public void setPreferredLanguage(ArrayList<SelectItem> preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}

	public ArrayList<SelectItem> getEmployerYNCheck() {
		return employerYNCheck;
	}

	public void setEmployerYNCheck(ArrayList<SelectItem> employerYNCheck) {
		this.employerYNCheck = employerYNCheck;
	}

	public PM_IL_CONTRACTOR_ACTION() {
		PM_IL_CONTRACTOR_BEAN = new PM_IL_CONTRACTOR();
		System.out.println("**********************jhjhfjh");
		employerYNCheck = selectValueForComboBox(
				PILM016_PM_IL_CONTRACTOR_CONSTANTS.FORMNAME,
				PILM016_PM_IL_CONTRACTOR_CONSTANTS.BLOCKNAME,
				PILM016_PM_IL_CONTRACTOR_CONSTANTS.ITEM1);
		preferredLanguage = selectValueForComboBox(
				PILM016_PM_IL_CONTRACTOR_CONSTANTS.FORMNAME,
				PILM016_PM_IL_CONTRACTOR_CONSTANTS.BLOCKNAME,
				PILM016_PM_IL_CONTRACTOR_CONSTANTS.ITEM2);
		when_new_form_instance();
		validation = new PM_IL_CONTRACTOR_ACTION_VALIDATION();
		instantiateAllComponent();
	}

	private PM_IL_CONTRACTOR_ACTION_VALIDATION validation;

	public HtmlOutputLabel getCOMP_CONT_TEL_AREA_CODE_LABEL() {
		return COMP_CONT_TEL_AREA_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CONT_TEL_AREA_CODE() {
		return COMP_CONT_TEL_AREA_CODE;
	}

	public void setCOMP_CONT_TEL_AREA_CODE_LABEL(
			HtmlOutputLabel COMP_CONT_TEL_AREA_CODE_LABEL) {
		this.COMP_CONT_TEL_AREA_CODE_LABEL = COMP_CONT_TEL_AREA_CODE_LABEL;
	}

	public void setCOMP_CONT_TEL_AREA_CODE(HtmlInputText COMP_CONT_TEL_AREA_CODE) {
		this.COMP_CONT_TEL_AREA_CODE = COMP_CONT_TEL_AREA_CODE;
	}

	public HtmlOutputLabel getCOMP_CONT_MOBILE_NO_LABEL() {
		return COMP_CONT_MOBILE_NO_LABEL;
	}

	public HtmlInputText getCOMP_CONT_MOBILE_NO() {
		return COMP_CONT_MOBILE_NO;
	}

	public void setCOMP_CONT_MOBILE_NO_LABEL(
			HtmlOutputLabel COMP_CONT_MOBILE_NO_LABEL) {
		this.COMP_CONT_MOBILE_NO_LABEL = COMP_CONT_MOBILE_NO_LABEL;
	}

	public void setCOMP_CONT_MOBILE_NO(HtmlInputText COMP_CONT_MOBILE_NO) {
		this.COMP_CONT_MOBILE_NO = COMP_CONT_MOBILE_NO;
	}

	public HtmlOutputLabel getCOMP_CONT_POSTAL_CODE_LABEL() {
		return COMP_CONT_POSTAL_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CONT_POSTAL_CODE() {
		return COMP_CONT_POSTAL_CODE;
	}

	public void setCOMP_CONT_POSTAL_CODE_LABEL(
			HtmlOutputLabel COMP_CONT_POSTAL_CODE_LABEL) {
		this.COMP_CONT_POSTAL_CODE_LABEL = COMP_CONT_POSTAL_CODE_LABEL;
	}

	public void setCOMP_CONT_POSTAL_CODE(HtmlInputText COMP_CONT_POSTAL_CODE) {
		this.COMP_CONT_POSTAL_CODE = COMP_CONT_POSTAL_CODE;
	}

	public HtmlOutputLabel getCOMP_CONT_STATE_CODE_LABEL() {
		return COMP_CONT_STATE_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CONT_STATE_CODE() {
		return COMP_CONT_STATE_CODE;
	}

	public void setCOMP_CONT_STATE_CODE_LABEL(
			HtmlOutputLabel COMP_CONT_STATE_CODE_LABEL) {
		this.COMP_CONT_STATE_CODE_LABEL = COMP_CONT_STATE_CODE_LABEL;
	}

	public void setCOMP_CONT_STATE_CODE(HtmlInputText COMP_CONT_STATE_CODE) {
		this.COMP_CONT_STATE_CODE = COMP_CONT_STATE_CODE;
	}

	public HtmlOutputLabel getCOMP_CONT_BIRTH_CERT_NO_LABEL() {
		return COMP_CONT_BIRTH_CERT_NO_LABEL;
	}

	public HtmlInputText getCOMP_CONT_BIRTH_CERT_NO() {
		return COMP_CONT_BIRTH_CERT_NO;
	}

	public void setCOMP_CONT_BIRTH_CERT_NO_LABEL(
			HtmlOutputLabel COMP_CONT_BIRTH_CERT_NO_LABEL) {
		this.COMP_CONT_BIRTH_CERT_NO_LABEL = COMP_CONT_BIRTH_CERT_NO_LABEL;
	}

	public void setCOMP_CONT_BIRTH_CERT_NO(HtmlInputText COMP_CONT_BIRTH_CERT_NO) {
		this.COMP_CONT_BIRTH_CERT_NO = COMP_CONT_BIRTH_CERT_NO;
	}

	public HtmlOutputLabel getCOMP_CONT_MAR_STATUS_LABEL() {
		return COMP_CONT_MAR_STATUS_LABEL;
	}

	public HtmlInputText getCOMP_CONT_MAR_STATUS() {
		return COMP_CONT_MAR_STATUS;
	}

	public void setCOMP_CONT_MAR_STATUS_LABEL(
			HtmlOutputLabel COMP_CONT_MAR_STATUS_LABEL) {
		this.COMP_CONT_MAR_STATUS_LABEL = COMP_CONT_MAR_STATUS_LABEL;
	}

	public void setCOMP_CONT_MAR_STATUS(HtmlInputText COMP_CONT_MAR_STATUS) {
		this.COMP_CONT_MAR_STATUS = COMP_CONT_MAR_STATUS;
	}

	public HtmlOutputLabel getCOMP_CONT_RELIGION_LABEL() {
		return COMP_CONT_RELIGION_LABEL;
	}

	public HtmlInputText getCOMP_CONT_RELIGION() {
		return COMP_CONT_RELIGION;
	}

	public void setCOMP_CONT_RELIGION_LABEL(
			HtmlOutputLabel COMP_CONT_RELIGION_LABEL) {
		this.COMP_CONT_RELIGION_LABEL = COMP_CONT_RELIGION_LABEL;
	}

	public void setCOMP_CONT_RELIGION(HtmlInputText COMP_CONT_RELIGION) {
		this.COMP_CONT_RELIGION = COMP_CONT_RELIGION;
	}

	public HtmlOutputLabel getCOMP_CONT_AREA_LABEL() {
		return COMP_CONT_AREA_LABEL;
	}

	public HtmlInputText getCOMP_CONT_AREA() {
		return COMP_CONT_AREA;
	}

	public void setCOMP_CONT_AREA_LABEL(HtmlOutputLabel COMP_CONT_AREA_LABEL) {
		this.COMP_CONT_AREA_LABEL = COMP_CONT_AREA_LABEL;
	}

	public void setCOMP_CONT_AREA(HtmlInputText COMP_CONT_AREA) {
		this.COMP_CONT_AREA = COMP_CONT_AREA;
	}

	public HtmlOutputLabel getCOMP_CONT_EMPLOYER_YN_LABEL() {
		return COMP_CONT_EMPLOYER_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CONT_EMPLOYER_YN() {
		return COMP_CONT_EMPLOYER_YN;
	}

	public void setCOMP_CONT_EMPLOYER_YN_LABEL(
			HtmlOutputLabel COMP_CONT_EMPLOYER_YN_LABEL) {
		this.COMP_CONT_EMPLOYER_YN_LABEL = COMP_CONT_EMPLOYER_YN_LABEL;
	}

	public void setCOMP_CONT_EMPLOYER_YN(HtmlSelectOneMenu COMP_CONT_EMPLOYER_YN) {
		this.COMP_CONT_EMPLOYER_YN = COMP_CONT_EMPLOYER_YN;
	}

	public HtmlOutputLabel getCOMP_CONT_PREFERRED_LANG_LABEL() {
		return COMP_CONT_PREFERRED_LANG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CONT_PREFERRED_LANG() {
		return COMP_CONT_PREFERRED_LANG;
	}

	public void setCOMP_CONT_PREFERRED_LANG_LABEL(
			HtmlOutputLabel COMP_CONT_PREFERRED_LANG_LABEL) {
		this.COMP_CONT_PREFERRED_LANG_LABEL = COMP_CONT_PREFERRED_LANG_LABEL;
	}

	public void setCOMP_CONT_PREFERRED_LANG(
			HtmlSelectOneMenu COMP_CONT_PREFERRED_LANG) {
		this.COMP_CONT_PREFERRED_LANG = COMP_CONT_PREFERRED_LANG;
	}

	public HtmlOutputLabel getCOMP_CONT_LC_PROP_DEP_AMT_LABEL() {
		return COMP_CONT_LC_PROP_DEP_AMT_LABEL;
	}

	public HtmlInputText getCOMP_CONT_LC_PROP_DEP_AMT() {
		return COMP_CONT_LC_PROP_DEP_AMT;
	}

	public void setCOMP_CONT_LC_PROP_DEP_AMT_LABEL(
			HtmlOutputLabel COMP_CONT_LC_PROP_DEP_AMT_LABEL) {
		this.COMP_CONT_LC_PROP_DEP_AMT_LABEL = COMP_CONT_LC_PROP_DEP_AMT_LABEL;
	}

	public void setCOMP_CONT_LC_PROP_DEP_AMT(
			HtmlInputText COMP_CONT_LC_PROP_DEP_AMT) {
		this.COMP_CONT_LC_PROP_DEP_AMT = COMP_CONT_LC_PROP_DEP_AMT;
	}

	public HtmlOutputLabel getCOMP_CONT_LC_POL_DEP_AMT_LABEL() {
		return COMP_CONT_LC_POL_DEP_AMT_LABEL;
	}

	public HtmlInputText getCOMP_CONT_LC_POL_DEP_AMT() {
		return COMP_CONT_LC_POL_DEP_AMT;
	}

	public void setCOMP_CONT_LC_POL_DEP_AMT_LABEL(
			HtmlOutputLabel COMP_CONT_LC_POL_DEP_AMT_LABEL) {
		this.COMP_CONT_LC_POL_DEP_AMT_LABEL = COMP_CONT_LC_POL_DEP_AMT_LABEL;
	}

	public void setCOMP_CONT_LC_POL_DEP_AMT(
			HtmlInputText COMP_CONT_LC_POL_DEP_AMT) {
		this.COMP_CONT_LC_POL_DEP_AMT = COMP_CONT_LC_POL_DEP_AMT;
	}

	public HtmlOutputLabel getCOMP_CONT_AD_BANK_CODE_LABEL() {
		return COMP_CONT_AD_BANK_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CONT_AD_BANK_CODE() {
		return COMP_CONT_AD_BANK_CODE;
	}

	public void setCOMP_CONT_AD_BANK_CODE_LABEL(
			HtmlOutputLabel COMP_CONT_AD_BANK_CODE_LABEL) {
		this.COMP_CONT_AD_BANK_CODE_LABEL = COMP_CONT_AD_BANK_CODE_LABEL;
	}

	public void setCOMP_CONT_AD_BANK_CODE(HtmlInputText COMP_CONT_AD_BANK_CODE) {
		this.COMP_CONT_AD_BANK_CODE = COMP_CONT_AD_BANK_CODE;
	}

	public HtmlOutputLabel getCOMP_CONT_EFF_FM_DT_LABEL() {
		return COMP_CONT_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_CONT_EFF_FM_DT() {
		return COMP_CONT_EFF_FM_DT;
	}

	public void setCOMP_CONT_EFF_FM_DT_LABEL(
			HtmlOutputLabel COMP_CONT_EFF_FM_DT_LABEL) {
		this.COMP_CONT_EFF_FM_DT_LABEL = COMP_CONT_EFF_FM_DT_LABEL;
	}

	public void setCOMP_CONT_EFF_FM_DT(HtmlCalendar COMP_CONT_EFF_FM_DT) {
		this.COMP_CONT_EFF_FM_DT = COMP_CONT_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_CONT_REMARKS_LABEL() {
		return COMP_CONT_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_CONT_REMARKS() {
		return COMP_CONT_REMARKS;
	}

	public void setCOMP_CONT_REMARKS_LABEL(
			HtmlOutputLabel COMP_CONT_REMARKS_LABEL) {
		this.COMP_CONT_REMARKS_LABEL = COMP_CONT_REMARKS_LABEL;
	}

	public void setCOMP_CONT_REMARKS(HtmlInputText COMP_CONT_REMARKS) {
		this.COMP_CONT_REMARKS = COMP_CONT_REMARKS;
	}

	public HtmlOutputLabel getCOMP_CONT_BL_ADDR1_LABEL() {
		return COMP_CONT_BL_ADDR1_LABEL;
	}

	public HtmlInputText getCOMP_CONT_BL_ADDR1() {
		return COMP_CONT_BL_ADDR1;
	}

	public void setCOMP_CONT_BL_ADDR1_LABEL(
			HtmlOutputLabel COMP_CONT_BL_ADDR1_LABEL) {
		this.COMP_CONT_BL_ADDR1_LABEL = COMP_CONT_BL_ADDR1_LABEL;
	}

	public void setCOMP_CONT_BL_ADDR1(HtmlInputText COMP_CONT_BL_ADDR1) {
		this.COMP_CONT_BL_ADDR1 = COMP_CONT_BL_ADDR1;
	}

	public HtmlOutputLabel getCOMP_CONT_BL_NAME_LABEL() {
		return COMP_CONT_BL_NAME_LABEL;
	}

	public HtmlInputText getCOMP_CONT_BL_NAME() {
		return COMP_CONT_BL_NAME;
	}

	public void setCOMP_CONT_BL_NAME_LABEL(
			HtmlOutputLabel COMP_CONT_BL_NAME_LABEL) {
		this.COMP_CONT_BL_NAME_LABEL = COMP_CONT_BL_NAME_LABEL;
	}

	public void setCOMP_CONT_BL_NAME(HtmlInputText COMP_CONT_BL_NAME) {
		this.COMP_CONT_BL_NAME = COMP_CONT_BL_NAME;
	}

	public HtmlOutputLabel getCOMP_CONT_BL_ADDR2_LABEL() {
		return COMP_CONT_BL_ADDR2_LABEL;
	}

	public HtmlInputText getCOMP_CONT_BL_ADDR2() {
		return COMP_CONT_BL_ADDR2;
	}

	public void setCOMP_CONT_BL_ADDR2_LABEL(
			HtmlOutputLabel COMP_CONT_BL_ADDR2_LABEL) {
		this.COMP_CONT_BL_ADDR2_LABEL = COMP_CONT_BL_ADDR2_LABEL;
	}

	public void setCOMP_CONT_BL_ADDR2(HtmlInputText COMP_CONT_BL_ADDR2) {
		this.COMP_CONT_BL_ADDR2 = COMP_CONT_BL_ADDR2;
	}

	public HtmlOutputLabel getCOMP_CONT_BL_ADDR3_LABEL() {
		return COMP_CONT_BL_ADDR3_LABEL;
	}

	public HtmlInputText getCOMP_CONT_BL_ADDR3() {
		return COMP_CONT_BL_ADDR3;
	}

	public void setCOMP_CONT_BL_ADDR3_LABEL(
			HtmlOutputLabel COMP_CONT_BL_ADDR3_LABEL) {
		this.COMP_CONT_BL_ADDR3_LABEL = COMP_CONT_BL_ADDR3_LABEL;
	}

	public void setCOMP_CONT_BL_ADDR3(HtmlInputText COMP_CONT_BL_ADDR3) {
		this.COMP_CONT_BL_ADDR3 = COMP_CONT_BL_ADDR3;
	}

	public HtmlOutputLabel getCOMP_CONT_BL_CONTACT_LABEL() {
		return COMP_CONT_BL_CONTACT_LABEL;
	}

	public HtmlInputText getCOMP_CONT_BL_CONTACT() {
		return COMP_CONT_BL_CONTACT;
	}

	public void setCOMP_CONT_BL_CONTACT_LABEL(
			HtmlOutputLabel COMP_CONT_BL_CONTACT_LABEL) {
		this.COMP_CONT_BL_CONTACT_LABEL = COMP_CONT_BL_CONTACT_LABEL;
	}

	public void setCOMP_CONT_BL_CONTACT(HtmlInputText COMP_CONT_BL_CONTACT) {
		this.COMP_CONT_BL_CONTACT = COMP_CONT_BL_CONTACT;
	}

	public HtmlOutputLabel getCOMP_CONT_PHONE_LABEL() {
		return COMP_CONT_PHONE_LABEL;
	}

	public HtmlInputText getCOMP_CONT_PHONE() {
		return COMP_CONT_PHONE;
	}

	public void setCOMP_CONT_PHONE_LABEL(HtmlOutputLabel COMP_CONT_PHONE_LABEL) {
		this.COMP_CONT_PHONE_LABEL = COMP_CONT_PHONE_LABEL;
	}

	public void setCOMP_CONT_PHONE(HtmlInputText COMP_CONT_PHONE) {
		this.COMP_CONT_PHONE = COMP_CONT_PHONE;
	}

	public HtmlOutputLabel getCOMP_CONT_STATE_LABEL() {
		return COMP_CONT_STATE_LABEL;
	}

	public HtmlInputText getCOMP_CONT_STATE() {
		return COMP_CONT_STATE;
	}

	public void setCOMP_CONT_STATE_LABEL(HtmlOutputLabel COMP_CONT_STATE_LABEL) {
		this.COMP_CONT_STATE_LABEL = COMP_CONT_STATE_LABEL;
	}

	public void setCOMP_CONT_STATE(HtmlInputText COMP_CONT_STATE) {
		this.COMP_CONT_STATE = COMP_CONT_STATE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CONT_MAR_STATUS_DESC_LABEL() {
		return COMP_UI_M_CONT_MAR_STATUS_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CONT_MAR_STATUS_DESC() {
		return COMP_UI_M_CONT_MAR_STATUS_DESC;
	}

	public void setCOMP_UI_M_CONT_MAR_STATUS_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_CONT_MAR_STATUS_DESC_LABEL) {
		this.COMP_UI_M_CONT_MAR_STATUS_DESC_LABEL = COMP_UI_M_CONT_MAR_STATUS_DESC_LABEL;
	}

	public void setCOMP_UI_M_CONT_MAR_STATUS_DESC(
			HtmlInputText COMP_UI_M_CONT_MAR_STATUS_DESC) {
		this.COMP_UI_M_CONT_MAR_STATUS_DESC = COMP_UI_M_CONT_MAR_STATUS_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_CONT_RELIGION_DESC_LABEL() {
		return COMP_UI_M_CONT_RELIGION_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CONT_RELIGION_DESC() {
		return COMP_UI_M_CONT_RELIGION_DESC;
	}

	public void setCOMP_UI_M_CONT_RELIGION_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_CONT_RELIGION_DESC_LABEL) {
		this.COMP_UI_M_CONT_RELIGION_DESC_LABEL = COMP_UI_M_CONT_RELIGION_DESC_LABEL;
	}

	public void setCOMP_UI_M_CONT_RELIGION_DESC(
			HtmlInputText COMP_UI_M_CONT_RELIGION_DESC) {
		this.COMP_UI_M_CONT_RELIGION_DESC = COMP_UI_M_CONT_RELIGION_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_CONT_AD_BANK_NAME_LABEL() {
		return COMP_UI_M_CONT_AD_BANK_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CONT_AD_BANK_NAME() {
		return COMP_UI_M_CONT_AD_BANK_NAME;
	}

	public void setCOMP_UI_M_CONT_AD_BANK_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_CONT_AD_BANK_NAME_LABEL) {
		this.COMP_UI_M_CONT_AD_BANK_NAME_LABEL = COMP_UI_M_CONT_AD_BANK_NAME_LABEL;
	}

	public void setCOMP_UI_M_CONT_AD_BANK_NAME(
			HtmlInputText COMP_UI_M_CONT_AD_BANK_NAME) {
		this.COMP_UI_M_CONT_AD_BANK_NAME = COMP_UI_M_CONT_AD_BANK_NAME;
	}

	public HtmlOutputLabel getCOMP_CONT_CODE_LABEL() {
		return COMP_CONT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CONT_CODE() {
		return COMP_CONT_CODE;
	}

	public void setCOMP_CONT_CODE_LABEL(HtmlOutputLabel COMP_CONT_CODE_LABEL) {
		this.COMP_CONT_CODE_LABEL = COMP_CONT_CODE_LABEL;
	}

	public void setCOMP_CONT_CODE(HtmlInputText COMP_CONT_CODE) {
		this.COMP_CONT_CODE = COMP_CONT_CODE;
	}

	public HtmlOutputLabel getCOMP_CONT_REF_ID1_LABEL() {
		return COMP_CONT_REF_ID1_LABEL;
	}

	public HtmlInputText getCOMP_CONT_REF_ID1() {
		return COMP_CONT_REF_ID1;
	}

	public void setCOMP_CONT_REF_ID1_LABEL(
			HtmlOutputLabel COMP_CONT_REF_ID1_LABEL) {
		this.COMP_CONT_REF_ID1_LABEL = COMP_CONT_REF_ID1_LABEL;
	}

	public void setCOMP_CONT_REF_ID1(HtmlInputText COMP_CONT_REF_ID1) {
		this.COMP_CONT_REF_ID1 = COMP_CONT_REF_ID1;
	}

	public HtmlOutputLabel getCOMP_CONT_REF_ID2_LABEL() {
		return COMP_CONT_REF_ID2_LABEL;
	}

	public HtmlInputText getCOMP_CONT_REF_ID2() {
		return COMP_CONT_REF_ID2;
	}

	public void setCOMP_CONT_REF_ID2_LABEL(
			HtmlOutputLabel COMP_CONT_REF_ID2_LABEL) {
		this.COMP_CONT_REF_ID2_LABEL = COMP_CONT_REF_ID2_LABEL;
	}

	public void setCOMP_CONT_REF_ID2(HtmlInputText COMP_CONT_REF_ID2) {
		this.COMP_CONT_REF_ID2 = COMP_CONT_REF_ID2;
	}

	public HtmlOutputLabel getCOMP_CONT_NAME_LABEL() {
		return COMP_CONT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_CONT_NAME() {
		return COMP_CONT_NAME;
	}

	public void setCOMP_CONT_NAME_LABEL(HtmlOutputLabel COMP_CONT_NAME_LABEL) {
		this.COMP_CONT_NAME_LABEL = COMP_CONT_NAME_LABEL;
	}

	public void setCOMP_CONT_NAME(HtmlInputText COMP_CONT_NAME) {
		this.COMP_CONT_NAME = COMP_CONT_NAME;
	}

	public HtmlOutputLabel getCOMP_CONT_ADDR1_LABEL() {
		return COMP_CONT_ADDR1_LABEL;
	}

	public HtmlInputText getCOMP_CONT_ADDR1() {
		return COMP_CONT_ADDR1;
	}

	public void setCOMP_CONT_ADDR1_LABEL(HtmlOutputLabel COMP_CONT_ADDR1_LABEL) {
		this.COMP_CONT_ADDR1_LABEL = COMP_CONT_ADDR1_LABEL;
	}

	public void setCOMP_CONT_ADDR1(HtmlInputText COMP_CONT_ADDR1) {
		this.COMP_CONT_ADDR1 = COMP_CONT_ADDR1;
	}

	public HtmlOutputLabel getCOMP_CONT_ADDR2_LABEL() {
		return COMP_CONT_ADDR2_LABEL;
	}

	public HtmlInputText getCOMP_CONT_ADDR2() {
		return COMP_CONT_ADDR2;
	}

	public void setCOMP_CONT_ADDR2_LABEL(HtmlOutputLabel COMP_CONT_ADDR2_LABEL) {
		this.COMP_CONT_ADDR2_LABEL = COMP_CONT_ADDR2_LABEL;
	}

	public void setCOMP_CONT_ADDR2(HtmlInputText COMP_CONT_ADDR2) {
		this.COMP_CONT_ADDR2 = COMP_CONT_ADDR2;
	}

	public HtmlOutputLabel getCOMP_CONT_ADDR3_LABEL() {
		return COMP_CONT_ADDR3_LABEL;
	}

	public HtmlInputText getCOMP_CONT_ADDR3() {
		return COMP_CONT_ADDR3;
	}

	public void setCOMP_CONT_ADDR3_LABEL(HtmlOutputLabel COMP_CONT_ADDR3_LABEL) {
		this.COMP_CONT_ADDR3_LABEL = COMP_CONT_ADDR3_LABEL;
	}

	public void setCOMP_CONT_ADDR3(HtmlInputText COMP_CONT_ADDR3) {
		this.COMP_CONT_ADDR3 = COMP_CONT_ADDR3;
	}

	public HtmlOutputLabel getCOMP_CONT_CONTACT_LABEL() {
		return COMP_CONT_CONTACT_LABEL;
	}

	public HtmlInputText getCOMP_CONT_CONTACT() {
		return COMP_CONT_CONTACT;
	}

	public void setCOMP_CONT_CONTACT_LABEL(
			HtmlOutputLabel COMP_CONT_CONTACT_LABEL) {
		this.COMP_CONT_CONTACT_LABEL = COMP_CONT_CONTACT_LABEL;
	}

	public void setCOMP_CONT_CONTACT(HtmlInputText COMP_CONT_CONTACT) {
		this.COMP_CONT_CONTACT = COMP_CONT_CONTACT;
	}

	public HtmlOutputLabel getCOMP_CONT_FAX_AREA_CODE_LABEL() {
		return COMP_CONT_FAX_AREA_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CONT_FAX_AREA_CODE() {
		return COMP_CONT_FAX_AREA_CODE;
	}

	public void setCOMP_CONT_FAX_AREA_CODE_LABEL(
			HtmlOutputLabel COMP_CONT_FAX_AREA_CODE_LABEL) {
		this.COMP_CONT_FAX_AREA_CODE_LABEL = COMP_CONT_FAX_AREA_CODE_LABEL;
	}

	public void setCOMP_CONT_FAX_AREA_CODE(HtmlInputText COMP_CONT_FAX_AREA_CODE) {
		this.COMP_CONT_FAX_AREA_CODE = COMP_CONT_FAX_AREA_CODE;
	}

	public HtmlOutputLabel getCOMP_CONT_EMAIL_ID_LABEL() {
		return COMP_CONT_EMAIL_ID_LABEL;
	}

	public HtmlInputText getCOMP_CONT_EMAIL_ID() {
		return COMP_CONT_EMAIL_ID;
	}

	public void setCOMP_CONT_EMAIL_ID_LABEL(
			HtmlOutputLabel COMP_CONT_EMAIL_ID_LABEL) {
		this.COMP_CONT_EMAIL_ID_LABEL = COMP_CONT_EMAIL_ID_LABEL;
	}

	public void setCOMP_CONT_EMAIL_ID(HtmlInputText COMP_CONT_EMAIL_ID) {
		this.COMP_CONT_EMAIL_ID = COMP_CONT_EMAIL_ID;
	}

	public HtmlOutputLabel getCOMP_CONT_CITY_CODE_LABEL() {
		return COMP_CONT_CITY_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CONT_CITY_CODE() {
		return COMP_CONT_CITY_CODE;
	}

	public void setCOMP_CONT_CITY_CODE_LABEL(
			HtmlOutputLabel COMP_CONT_CITY_CODE_LABEL) {
		this.COMP_CONT_CITY_CODE_LABEL = COMP_CONT_CITY_CODE_LABEL;
	}

	public void setCOMP_CONT_CITY_CODE(HtmlInputText COMP_CONT_CITY_CODE) {
		this.COMP_CONT_CITY_CODE = COMP_CONT_CITY_CODE;
	}

	public HtmlOutputLabel getCOMP_CONT_COUNT_CODE_LABEL() {
		return COMP_CONT_COUNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CONT_COUNT_CODE() {
		return COMP_CONT_COUNT_CODE;
	}

	public void setCOMP_CONT_COUNT_CODE_LABEL(
			HtmlOutputLabel COMP_CONT_COUNT_CODE_LABEL) {
		this.COMP_CONT_COUNT_CODE_LABEL = COMP_CONT_COUNT_CODE_LABEL;
	}

	public void setCOMP_CONT_COUNT_CODE(HtmlInputText COMP_CONT_COUNT_CODE) {
		this.COMP_CONT_COUNT_CODE = COMP_CONT_COUNT_CODE;
	}

	public HtmlOutputLabel getCOMP_CONT_DOB_LABEL() {
		return COMP_CONT_DOB_LABEL;
	}

	public HtmlCalendar getCOMP_CONT_DOB() {
		return COMP_CONT_DOB;
	}

	public void setCOMP_CONT_DOB_LABEL(HtmlOutputLabel COMP_CONT_DOB_LABEL) {
		this.COMP_CONT_DOB_LABEL = COMP_CONT_DOB_LABEL;
	}

	public void setCOMP_CONT_DOB(HtmlCalendar COMP_CONT_DOB) {
		this.COMP_CONT_DOB = COMP_CONT_DOB;
	}

	public HtmlOutputLabel getCOMP_CONT_CATG_CODE_LABEL() {
		return COMP_CONT_CATG_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CONT_CATG_CODE() {
		return COMP_CONT_CATG_CODE;
	}

	public void setCOMP_CONT_CATG_CODE_LABEL(
			HtmlOutputLabel COMP_CONT_CATG_CODE_LABEL) {
		this.COMP_CONT_CATG_CODE_LABEL = COMP_CONT_CATG_CODE_LABEL;
	}

	public void setCOMP_CONT_CATG_CODE(HtmlInputText COMP_CONT_CATG_CODE) {
		this.COMP_CONT_CATG_CODE = COMP_CONT_CATG_CODE;
	}

	public HtmlOutputLabel getCOMP_CONT_NATIONALITY_CODE_LABEL() {
		return COMP_CONT_NATIONALITY_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CONT_NATIONALITY_CODE() {
		return COMP_CONT_NATIONALITY_CODE;
	}

	public void setCOMP_CONT_NATIONALITY_CODE_LABEL(
			HtmlOutputLabel COMP_CONT_NATIONALITY_CODE_LABEL) {
		this.COMP_CONT_NATIONALITY_CODE_LABEL = COMP_CONT_NATIONALITY_CODE_LABEL;
	}

	public void setCOMP_CONT_NATIONALITY_CODE(
			HtmlInputText COMP_CONT_NATIONALITY_CODE) {
		this.COMP_CONT_NATIONALITY_CODE = COMP_CONT_NATIONALITY_CODE;
	}

	public HtmlOutputLabel getCOMP_CONT_RACE_LABEL() {
		return COMP_CONT_RACE_LABEL;
	}

	public HtmlInputText getCOMP_CONT_RACE() {
		return COMP_CONT_RACE;
	}

	public void setCOMP_CONT_RACE_LABEL(HtmlOutputLabel COMP_CONT_RACE_LABEL) {
		this.COMP_CONT_RACE_LABEL = COMP_CONT_RACE_LABEL;
	}

	public void setCOMP_CONT_RACE(HtmlInputText COMP_CONT_RACE) {
		this.COMP_CONT_RACE = COMP_CONT_RACE;
	}

	public HtmlOutputLabel getCOMP_CONT_REGION_LABEL() {
		return COMP_CONT_REGION_LABEL;
	}

	public HtmlInputText getCOMP_CONT_REGION() {
		return COMP_CONT_REGION;
	}

	public void setCOMP_CONT_REGION_LABEL(HtmlOutputLabel COMP_CONT_REGION_LABEL) {
		this.COMP_CONT_REGION_LABEL = COMP_CONT_REGION_LABEL;
	}

	public void setCOMP_CONT_REGION(HtmlInputText COMP_CONT_REGION) {
		this.COMP_CONT_REGION = COMP_CONT_REGION;
	}

	public HtmlOutputLabel getCOMP_CONT_REF_NO_LABEL() {
		return COMP_CONT_REF_NO_LABEL;
	}

	public HtmlInputText getCOMP_CONT_REF_NO() {
		return COMP_CONT_REF_NO;
	}

	public void setCOMP_CONT_REF_NO_LABEL(HtmlOutputLabel COMP_CONT_REF_NO_LABEL) {
		this.COMP_CONT_REF_NO_LABEL = COMP_CONT_REF_NO_LABEL;
	}

	public void setCOMP_CONT_REF_NO(HtmlInputText COMP_CONT_REF_NO) {
		this.COMP_CONT_REF_NO = COMP_CONT_REF_NO;
	}

	public HtmlOutputLabel getCOMP_CONT_LC_PROP_UTIL_AMT_LABEL() {
		return COMP_CONT_LC_PROP_UTIL_AMT_LABEL;
	}

	public HtmlInputText getCOMP_CONT_LC_PROP_UTIL_AMT() {
		return COMP_CONT_LC_PROP_UTIL_AMT;
	}

	public void setCOMP_CONT_LC_PROP_UTIL_AMT_LABEL(
			HtmlOutputLabel COMP_CONT_LC_PROP_UTIL_AMT_LABEL) {
		this.COMP_CONT_LC_PROP_UTIL_AMT_LABEL = COMP_CONT_LC_PROP_UTIL_AMT_LABEL;
	}

	public void setCOMP_CONT_LC_PROP_UTIL_AMT(
			HtmlInputText COMP_CONT_LC_PROP_UTIL_AMT) {
		this.COMP_CONT_LC_PROP_UTIL_AMT = COMP_CONT_LC_PROP_UTIL_AMT;
	}

	public HtmlOutputLabel getCOMP_CONT_LC_POL_UTIL_AMT_LABEL() {
		return COMP_CONT_LC_POL_UTIL_AMT_LABEL;
	}

	public HtmlInputText getCOMP_CONT_LC_POL_UTIL_AMT() {
		return COMP_CONT_LC_POL_UTIL_AMT;
	}

	public void setCOMP_CONT_LC_POL_UTIL_AMT_LABEL(
			HtmlOutputLabel COMP_CONT_LC_POL_UTIL_AMT_LABEL) {
		this.COMP_CONT_LC_POL_UTIL_AMT_LABEL = COMP_CONT_LC_POL_UTIL_AMT_LABEL;
	}

	public void setCOMP_CONT_LC_POL_UTIL_AMT(
			HtmlInputText COMP_CONT_LC_POL_UTIL_AMT) {
		this.COMP_CONT_LC_POL_UTIL_AMT = COMP_CONT_LC_POL_UTIL_AMT;
	}

	public HtmlOutputLabel getCOMP_CONT_AD_ACC_NO_LABEL() {
		return COMP_CONT_AD_ACC_NO_LABEL;
	}

	public HtmlInputText getCOMP_CONT_AD_ACC_NO() {
		return COMP_CONT_AD_ACC_NO;
	}

	public void setCOMP_CONT_AD_ACC_NO_LABEL(
			HtmlOutputLabel COMP_CONT_AD_ACC_NO_LABEL) {
		this.COMP_CONT_AD_ACC_NO_LABEL = COMP_CONT_AD_ACC_NO_LABEL;
	}

	public void setCOMP_CONT_AD_ACC_NO(HtmlInputText COMP_CONT_AD_ACC_NO) {
		this.COMP_CONT_AD_ACC_NO = COMP_CONT_AD_ACC_NO;
	}

	public HtmlOutputLabel getCOMP_CONT_EFF_TO_DT_LABEL() {
		return COMP_CONT_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_CONT_EFF_TO_DT() {
		return COMP_CONT_EFF_TO_DT;
	}

	public void setCOMP_CONT_EFF_TO_DT_LABEL(
			HtmlOutputLabel COMP_CONT_EFF_TO_DT_LABEL) {
		this.COMP_CONT_EFF_TO_DT_LABEL = COMP_CONT_EFF_TO_DT_LABEL;
	}

	public void setCOMP_CONT_EFF_TO_DT(HtmlCalendar COMP_CONT_EFF_TO_DT) {
		this.COMP_CONT_EFF_TO_DT = COMP_CONT_EFF_TO_DT;
	}

	public HtmlOutputLabel getCOMP_CONT_FAX_LABEL() {
		return COMP_CONT_FAX_LABEL;
	}

	public HtmlInputText getCOMP_CONT_FAX() {
		return COMP_CONT_FAX;
	}

	public void setCOMP_CONT_FAX_LABEL(HtmlOutputLabel COMP_CONT_FAX_LABEL) {
		this.COMP_CONT_FAX_LABEL = COMP_CONT_FAX_LABEL;
	}

	public void setCOMP_CONT_FAX(HtmlInputText COMP_CONT_FAX) {
		this.COMP_CONT_FAX = COMP_CONT_FAX;
	}

	public HtmlOutputLabel getCOMP_CONT_CITY_LABEL() {
		return COMP_CONT_CITY_LABEL;
	}

	public HtmlInputText getCOMP_CONT_CITY() {
		return COMP_CONT_CITY;
	}

	public void setCOMP_CONT_CITY_LABEL(HtmlOutputLabel COMP_CONT_CITY_LABEL) {
		this.COMP_CONT_CITY_LABEL = COMP_CONT_CITY_LABEL;
	}

	public void setCOMP_CONT_CITY(HtmlInputText COMP_CONT_CITY) {
		this.COMP_CONT_CITY = COMP_CONT_CITY;
	}

	public HtmlOutputLabel getCOMP_CONT_COUNTRY_LABEL() {
		return COMP_CONT_COUNTRY_LABEL;
	}

	public HtmlInputText getCOMP_CONT_COUNTRY() {
		return COMP_CONT_COUNTRY;
	}

	public void setCOMP_CONT_COUNTRY_LABEL(
			HtmlOutputLabel COMP_CONT_COUNTRY_LABEL) {
		this.COMP_CONT_COUNTRY_LABEL = COMP_CONT_COUNTRY_LABEL;
	}

	public void setCOMP_CONT_COUNTRY(HtmlInputText COMP_CONT_COUNTRY) {
		this.COMP_CONT_COUNTRY = COMP_CONT_COUNTRY;
	}

	public HtmlOutputLabel getCOMP_UI_M_CONT_CATG_CODE_DESC_LABEL() {
		return COMP_UI_M_CONT_CATG_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CONT_CATG_CODE_DESC() {
		return COMP_UI_M_CONT_CATG_CODE_DESC;
	}

	public void setCOMP_UI_M_CONT_CATG_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_CONT_CATG_CODE_DESC_LABEL) {
		this.COMP_UI_M_CONT_CATG_CODE_DESC_LABEL = COMP_UI_M_CONT_CATG_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_CONT_CATG_CODE_DESC(
			HtmlInputText COMP_UI_M_CONT_CATG_CODE_DESC) {
		this.COMP_UI_M_CONT_CATG_CODE_DESC = COMP_UI_M_CONT_CATG_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_CONT_NATIONALITY_CODE_DESC_LABEL() {
		return COMP_UI_M_CONT_NATIONALITY_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CONT_NATIONALITY_CODE_DESC() {
		return COMP_UI_M_CONT_NATIONALITY_CODE_DESC;
	}

	public void setCOMP_UI_M_CONT_NATIONALITY_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_CONT_NATIONALITY_CODE_DESC_LABEL) {
		this.COMP_UI_M_CONT_NATIONALITY_CODE_DESC_LABEL = COMP_UI_M_CONT_NATIONALITY_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_CONT_NATIONALITY_CODE_DESC(
			HtmlInputText COMP_UI_M_CONT_NATIONALITY_CODE_DESC) {
		this.COMP_UI_M_CONT_NATIONALITY_CODE_DESC = COMP_UI_M_CONT_NATIONALITY_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_CONT_RACE_DESC_LABEL() {
		return COMP_UI_M_CONT_RACE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CONT_RACE_DESC() {
		return COMP_UI_M_CONT_RACE_DESC;
	}

	public void setCOMP_UI_M_CONT_RACE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_CONT_RACE_DESC_LABEL) {
		this.COMP_UI_M_CONT_RACE_DESC_LABEL = COMP_UI_M_CONT_RACE_DESC_LABEL;
	}

	public void setCOMP_UI_M_CONT_RACE_DESC(
			HtmlInputText COMP_UI_M_CONT_RACE_DESC) {
		this.COMP_UI_M_CONT_RACE_DESC = COMP_UI_M_CONT_RACE_DESC;
	}

	public HtmlCommandButton getCOMP_PUSH_BUTTON208() {
		return COMP_PUSH_BUTTON208;
	}

	public void setCOMP_PUSH_BUTTON208(HtmlCommandButton COMP_PUSH_BUTTON208) {
		this.COMP_PUSH_BUTTON208 = COMP_PUSH_BUTTON208;
	}

	public HtmlCommandButton getCOMP_ITEM158() {
		return COMP_ITEM158;
	}

	public void setCOMP_ITEM158(HtmlCommandButton COMP_ITEM158) {
		this.COMP_ITEM158 = COMP_ITEM158;
	}

	public PM_IL_CONTRACTOR getPM_IL_CONTRACTOR_BEAN() {
		return PM_IL_CONTRACTOR_BEAN;
	}

	public void setPM_IL_CONTRACTOR_BEAN(PM_IL_CONTRACTOR PM_IL_CONTRACTOR_BEAN) {
		this.PM_IL_CONTRACTOR_BEAN = PM_IL_CONTRACTOR_BEAN;
	}

	public void onFocusField(ActionEvent event) {
		System.out.println("ONFOCUS<>>>>>>>");
		getCOMP_CONT_NAME().setSubmittedValue("");
	}

	public void saveRecord(ActionEvent event) {
		CommonUtils.clearMaps(this);
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String message = null;
		try {
			connection = CommonUtils.getConnection();
			if (PM_IL_CONTRACTOR_BEAN.getROWID() == null) {
				if (PM_IL_CONTRACTOR_BEAN.getCONT_CODE() == null) {
					getCOMP_CONT_GEN_NO().setDisabled(false);
					P_CREATE_NUMBER();
				}
				pilm016_apac_pm_il_contractor_pre_insert();
				handler.executeInsert(PM_IL_CONTRACTOR_BEAN, connection);
				message = Messages.getString("messageProperties",
						"errorPanel$message$save");
			} else if (PM_IL_CONTRACTOR_BEAN.getROWID() != null) {
				pilm016_apac_pm_il_contractor_pre_update();
				handler.executeUpdate(PM_IL_CONTRACTOR_BEAN, connection);
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update");
			}
			checkemployerYN();
			connection.commit();
			getWarningMap().put("current", message);
			getWarningMap().put("detail", message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void assuredCodeIsExists(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		PM_IL_CONTRACTOR_ACTION_VALIDATION pm_il_contractor_action_validation = new PM_IL_CONTRACTOR_ACTION_VALIDATION();
		Connection connection = null;
		String contCode = COMP_CONT_CODE.getSubmittedValue().toString();
		System.out.println("contCode :" + contCode);
		PM_IL_CONTRACTOR_BEAN.setCONT_CODE(contCode);
		try {
			connection = CommonUtils.getConnection();
			if (contCode != null) {
				pm_il_contractor_action_validation
						.uniqueCode(PM_IL_CONTRACTOR_BEAN);
				
			}

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void nullValueChecking(ActionEvent event) {
		if (new PM_IL_CONTRACTOR_ACTION_VALIDATION().nullValue(
				(String) COMP_CONT_AD_BANK_CODE.getSubmittedValue(),
				(String) COMP_CONT_AD_ACC_NO.getSubmittedValue())) {
			ACCOUNT_NO_ERROR.setValue("Account Number cannot be null");
		} else {
			ACCOUNT_NO_ERROR.setValue(null);
		}
	}

	public void fireFieldValidation(ActionEvent event) {
		getWarningMap().clear();
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateCONT_DOB(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());

	}

	public void validateCONT_DOB(FacesContext context, UIComponent component,
			Object object) {
		try {
			Date dob = (Date) object;
			PM_IL_CONTRACTOR_BEAN.setCONT_DOB(dob);
			if (dob.after(new CommonUtils().getCurrentDate())) {
				throw new Exception("Date of birth less than Current Date");
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void effectiveFrom_DateValidation(ActionEvent event) {
		System.out.println("PM_IL_CONTRACTOR_ACTION.dateComparison()");
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void effectiveTo_DateValidation(ActionEvent event) {
		System.out.println("PM_IL_CONTRACTOR_ACTION.dateComparison()");
		UIInput input = (UIInput) event.getComponent().getParent();
	}

	public void cont_city_code_when_validate_item(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
	}

	public void validateCONT_EFF_TO_DT(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		Date toDate = (Date) value;
		Date fromDate = PM_IL_CONTRACTOR_BEAN.getCONT_EFF_FM_DT();
		try {
			if (fromDate != null && toDate != null) {
				if (fromDate.after(toDate)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91014",
							new Object[] { "Effective From Date", "<=",
									"Effective To Date" }));
				}
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCONT_EFF_FROM_DT(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		Date fromDate = (Date) value;
		try {
			PM_IL_CONTRACTOR_BEAN.setCONT_EFF_FM_DT(fromDate);
			if (PM_IL_CONTRACTOR_BEAN.getCONT_EFF_FM_DT() != null
					&& PM_IL_CONTRACTOR_BEAN.getCONT_EFF_TO_DT() != null) {
				if (PM_IL_CONTRACTOR_BEAN.getCONT_EFF_FM_DT().after(
						PM_IL_CONTRACTOR_BEAN.getCONT_EFF_TO_DT())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91014",
							new Object[] { "Effective From Date", "<=",
									"Effective To Date" }));
				}
			}

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void dateComparison(ActionEvent event) {
		System.out.println("PM_IL_CONTRACTOR_ACTION.dateComparison()");
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public String refIdFieldLengthValidation() throws Exception {
		CRUDHandler handler = new CRUDHandler();
		String message = null;
		String errorDisplay = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_ERROR_MESSAGE_REF_ID;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			ResultSet resultSet = handler.executeSelectStatement(errorDisplay,
					connection);
			while (resultSet.next()) {
				message = resultSet.getString(1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return message;
	}

	public void ICNumberValidation(ActionEvent event) throws Exception {
		String RECORD_STATUS = "INSERT";

		List<Object> resultList = new ArrayList<Object>();
		Connection connection = null;

		try {
			connection = CommonUtils.getConnection();
			if (COMP_CONT_REF_ID1.getSubmittedValue() != null) {
				if (RECORD_STATUS != "CHANGED") {
					resultList = new PM_IL_CONTRACTOR_ACTION_VALIDATION()
							.isExist(connection, (String) COMP_CONT_REF_ID1
									.getSubmittedValue());
					setComponentValue(resultList);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}

	}

	public void OldIcNumberValidation(ActionEvent ae) {
		// procedure call
		Connection connection = null;

		String RECORD_STATUS = "INSERT";
		int M_OLD_IC_NO_LENGTH = 5;
		int M_REF_ID2_LENGTH = COMP_CONT_REF_ID2.getMaxlength();
		int M_LENGTH_2 = 0;
		int M_IND_REQ = 1;

		try {
			connection = CommonUtils.getConnection();

			if (M_REF_ID2_LENGTH < M_OLD_IC_NO_LENGTH) {
				M_LENGTH_2 = M_REF_ID2_LENGTH;
			} else {
				M_LENGTH_2 = M_REF_ID2_LENGTH;
			}

			if (COMP_CONT_REF_ID2.getSubmittedValue().toString().length() > M_LENGTH_2) {
				ERROR_IC_NUMBER
						.setValue("Field length exceeded!. Permitted is ERR1");
			}

			if (M_IND_REQ == 1) {
				if (COMP_CONT_REF_ID1.getSubmittedValue() == null
						&& COMP_CONT_REF_ID2.getSubmittedValue() == null) {
					ERROR_IC_NUMBER.setValue("Enter Atleast one IC Number");
				}
				if (COMP_CONT_REF_ID1.getSubmittedValue() != null
						|| COMP_CONT_REF_ID1.getSubmittedValue() == null
						&& COMP_CONT_REF_ID2.getSubmittedValue() != null) {
					if (!RECORD_STATUS.equalsIgnoreCase("CHANGED")) {
						List resultList = new PM_IL_CONTRACTOR_ACTION_VALIDATION()
								.isExist(connection, COMP_CONT_REF_ID2
										.getSubmittedValue().toString());
						setComponentValue(resultList);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}
	}

	// September-10
	public String updateAction() throws Exception {

		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			handler.executeUpdate(PM_IL_CONTRACTOR_BEAN, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// September-10
	public String deleteAction() {
		try {
			PM_IL_CONTRACTOR_SERACH_DELEGATE delegate = new PM_IL_CONTRACTOR_SERACH_DELEGATE();
			int deletedRow = delegate.deleteData(PM_IL_CONTRACTOR_BEAN);
			if (deletedRow > 0) {
				String message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$delete");
				HttpSession session = CommonUtils.getSession();
				session.removeAttribute("PILM016_APAC_PM_IL_CONTRACTOR_ACTION");
				PM_IL_CONTRACTOR_ACTION action = new PM_IL_CONTRACTOR_ACTION();
				session.setAttribute("PILM016_APAC_PM_IL_CONTRACTOR_ACTION",
						action);
				action.getWarningMap().put("current", message);
				action.getWarningMap().put("detail", message);

			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("DELETE", e.getMessage());
		}
		return "";
	}

	public void setComponentValue(List resultList) {
		if (!resultList.isEmpty()) {
			PM_IL_CONTRACTOR pm_il_contractor = (PM_IL_CONTRACTOR) resultList
					.get(0);
			COMP_CONT_CODE.setSubmittedValue(pm_il_contractor.getCONT_CODE());
			COMP_CONT_REF_ID2.setSubmittedValue(pm_il_contractor
					.getCONT_REF_ID2());
			COMP_CONT_NAME.setSubmittedValue(pm_il_contractor.getCONT_NAME());
			COMP_CONT_ADDR1.setSubmittedValue(pm_il_contractor.getCONT_ADDR1());
			COMP_CONT_ADDR2.setSubmittedValue(pm_il_contractor.getCONT_ADDR2());
			COMP_CONT_ADDR3.setSubmittedValue(pm_il_contractor.getCONT_ADDR3());
			COMP_CONT_CONTACT.setSubmittedValue(pm_il_contractor
					.getCONT_CONTACT());
			COMP_CONT_PHONE.setSubmittedValue(pm_il_contractor.getCONT_PHONE());
			COMP_CONT_FAX.setSubmittedValue(pm_il_contractor.getCONT_FAX());
			COMP_CONT_REMARKS.setSubmittedValue(pm_il_contractor
					.getCONT_REMARKS());
			COMP_CONT_EMPLOYER_YN.setSubmittedValue(pm_il_contractor
					.getCONT_EMPLOYER_YN());
			COMP_CONT_EFF_FM_DT.setSubmittedValue(pm_il_contractor
					.getCONT_EFF_FM_DT());
			COMP_CONT_EFF_TO_DT.setSubmittedValue(pm_il_contractor
					.getCONT_EFF_TO_DT());
			COMP_CONT_REF_NO.setSubmittedValue(pm_il_contractor
					.getCONT_REF_NO());
			COMP_CONT_REF_ID1.setSubmittedValue(pm_il_contractor
					.getCONT_REF_ID1());
			COMP_CONT_REF_ID2.setSubmittedValue(pm_il_contractor
					.getCONT_REF_ID2());
			COMP_CONT_MOBILE_NO.setSubmittedValue(pm_il_contractor
					.getCONT_MOBILE_NO());
			COMP_CONT_TEL_AREA_CODE.setSubmittedValue(pm_il_contractor
					.getCONT_TEL_AREA_CODE());
			COMP_CONT_FAX_AREA_CODE.setSubmittedValue(pm_il_contractor
					.getCONT_FAX_AREA_CODE());
			COMP_CONT_PREFERRED_LANG.setSubmittedValue(pm_il_contractor
					.getCONT_PREFERRED_LANG());
			COMP_CONT_EMAIL_ID.setSubmittedValue(pm_il_contractor
					.getCONT_EMAIL_ID());
			COMP_CONT_POSTAL_CODE.setSubmittedValue(pm_il_contractor
					.getCONT_POSTAL_CODE());
			COMP_CONT_STATE.setSubmittedValue(pm_il_contractor.getCONT_STATE());
			COMP_CONT_STATE_CODE.setSubmittedValue(pm_il_contractor
					.getCONT_STATE_CODE());
			COMP_CONT_CITY.setSubmittedValue(pm_il_contractor.getCONT_CITY());
			COMP_CONT_CITY_CODE.setSubmittedValue(pm_il_contractor
					.getCONT_CITY_CODE());
			COMP_CONT_COUNTRY.setSubmittedValue(pm_il_contractor
					.getCONT_COUNTRY());
			COMP_CONT_BIRTH_CERT_NO.setSubmittedValue(pm_il_contractor
					.getCONT_BIRTH_CERT_NO());
			COMP_CONT_MAR_STATUS.setSubmittedValue(pm_il_contractor
					.getCONT_MAR_STATUS());
			COMP_CONT_DOB.setSubmittedValue(pm_il_contractor.getCONT_DOB());
			COMP_CONT_RELIGION.setSubmittedValue(pm_il_contractor
					.getCONT_RELIGION());
			COMP_CONT_AREA.setSubmittedValue(pm_il_contractor.getCONT_AREA());
			COMP_CONT_RACE.setSubmittedValue(pm_il_contractor.getCONT_RACE());
			COMP_CONT_REGION.setSubmittedValue(pm_il_contractor
					.getCONT_REGION());
			COMP_CONT_EMPLOYER_YN.setSubmittedValue(pm_il_contractor
					.getCONT_EMPLOYER_YN());
			COMP_CONT_PREFERRED_LANG.setSubmittedValue(pm_il_contractor
					.getCONT_PREFERRED_LANG());
			COMP_CONT_AD_BANK_CODE.setSubmittedValue(pm_il_contractor
					.getCONT_AD_BANK_CODE());
			COMP_CONT_AD_ACC_NO.setSubmittedValue(pm_il_contractor
					.getCONT_AD_ACC_NO());
			COMP_CONT_LC_POL_DEP_AMT.setSubmittedValue(pm_il_contractor
					.getCONT_LC_POL_DEP_AMT());
			COMP_CONT_LC_POL_UTIL_AMT.setSubmittedValue(pm_il_contractor
					.getCONT_LC_POL_UTIL_AMT());
			COMP_CONT_LC_PROP_DEP_AMT.setSubmittedValue(pm_il_contractor
					.getCONT_LC_PROP_DEP_AMT());
			COMP_CONT_LC_PROP_UTIL_AMT.setSubmittedValue(pm_il_contractor
					.getCONT_LC_PROP_UTIL_AMT());

		}
	}

	public HtmlCommandButton getCOMP_UI_M_M_BUT_UPDATE() {
		return COMP_UI_M_M_BUT_UPDATE;
	}

	public void setCOMP_UI_M_M_BUT_UPDATE(
			HtmlCommandButton comp_ui_m_m_but_update) {
		COMP_UI_M_M_BUT_UPDATE = comp_ui_m_m_but_update;
	}

	public HtmlCommandButton getCOMP_UI_M_M_BUT_DELETE() {
		return COMP_UI_M_M_BUT_DELETE;
	}

	public void setCOMP_UI_M_M_BUT_DELETE(
			HtmlCommandButton comp_ui_m_m_but_delete) {
		COMP_UI_M_M_BUT_DELETE = comp_ui_m_m_but_delete;
	}

	public void pilm_apac_pm_il_contractor_cont_ref_id2_when_validate_item(
			ActionEvent actionEvent) {
		System.out.println("PM_IL_CONTRACTOR_ACTION.REF ID2()");
		getPM_IL_CONTRACTOR_BEAN().setCONT_REF_ID2(
				(String) getCOMP_CONT_REF_ID2().getSubmittedValue());
		PM_IL_CONTRACTOR_ACTION_VALIDATION validation = new PM_IL_CONTRACTOR_ACTION_VALIDATION();

		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet resultset1 = null;
		ResultSet resultset2 = null;
		int errorCode = -1;

		String M_DUMMY = null;
		String M_CONT_NAME = null;
		String M_CONT_ADDR1 = null;
		String M_CONT_ADDR2 = null;
		String M_CONT_ADDR3 = null;
		String M_CONT_CONTACT = null;
		String M_CONT_PHONE = null;
		String M_CONT_FAX = null;
		String M_CONT_REMARKS = null;
		String M_CONT_DFLT_YN = null;
		String M_CONT_CUST_CODE = null;
		String M_CONT_FRZ_FLAG = null;
		String M_CONT_BL_NAME = null;
		String M_CONT_BL_ADDR1 = null;
		String M_CONT_BL_ADDR2 = null;
		String M_CONT_BL_ADDR3 = null;
		String M_CONT_BL_CONTACT = null;
		String M_CONT_EMPLOYER_YN = null;
		String M_CONT_EFF_FM_DT = null;
		String M_CONT_EFF_TO_DT = null;
		String M_CONT_REF_NO = null;
		String M_CONT_REF_ID1 = null;
		String M_CONT_REF_ID2 = null;
		String M_CONT_TEL_AREA_CODE = null;
		String M_CONT_MOBILE_NO = null;
		String M_CONT_FAX_AREA_CODE = null;
		String M_CONT_PREFERRED_LANG = null;
		String M_CONT_EMAIL_ID = null;
		String M_CONT_POSTAL_CODE = null;
		String M_CONT_CITY = null;
		String M_CONT_STATE = null;
		Date M_CONT_DOB = null;
		String M_CONT_BIRTH_CERT_NO = null;
		String M_CONT_CATG_CODE = null;
		String M_CONT_MAR_STATUS = null;
		String M_CONT_NATIONALITY_CODE = null;
		String M_CONT_RACE = null;
		String M_CONT_RELIGION = null;
		String M_CONT_AREA = null;
		String M_CONT_REGION = null;
		String M_CODE_DESC = null;
		String M_IND_REQ = null;
		String M_CONT_AD_BANK_CODE = null;
		String M_CONT_AD_ACC_NO = null;
		String M_CONT_CITY_CODE = null;
		String M_CONT_COUNT_CODE = null;
		String M_CONT_COUNTRY = null;
		String M_VALUE = null;
		String M_CODE_DESC_1 = null;
		String M_PC_CODE = null;
		double M_LENGTH_2 = -1;
		double M_OLD_IC_NO_LENGTH = -1;

		try {
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			ErrorHelpUtil.validate(input, getErrorMap());
			if (!PM_IL_CONTRACTOR_BEAN.getCONT_REF_ID2().isEmpty()) {

				connection = CommonUtils.getConnection();
				String sqlQuery1 = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_QUERY_REFID2_DETAIL;
				Object[] object1 = { getPM_IL_CONTRACTOR_BEAN()
						.getCONT_REF_ID2() };

				String sqlQuery2 = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_QUERY_PCCODE_SELECT;
				Object[] object2 = {};

				double M_REF_ID2_LENGTH = COMP_CONT_REF_ID2.getMaxlength();

				/* P_VAL_SYSTEM procedure calling */
				ArrayList resultList = P_VAL_SYSTEM
						.P_VAL_SYSTEM(
								connection,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_REF_ID2_TYPE,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_REF_ID2_CODE,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_ERRORFLAG);
				M_CODE_DESC = resultList.get(0).toString();
				M_OLD_IC_NO_LENGTH = Double.parseDouble(resultList.get(1)
						.toString());

				M_LENGTH_2 = Double.parseDouble(least(""
						+ (MigratingFunctions.nvl(M_OLD_IC_NO_LENGTH,
								M_REF_ID2_LENGTH)), "" + M_REF_ID2_LENGTH));

				if (PM_IL_CONTRACTOR_BEAN.getCONT_REF_ID2().length() > M_LENGTH_2) {
					throw new ValidatorException(new FacesMessage(Messages
							.getString(bundleName, "91240",
									new Object[] { M_LENGTH_2 })));
				}

				ArrayList returnList1 = P_VAL_SYSTEM
						.P_VAL_SYSTEM(
								connection,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_REF_ID2_TYPE1,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_REF_ID2_CODE1,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_ERRORFLAG1);

				M_CODE_DESC = returnList1.get(0).toString();
				M_IND_REQ = returnList1.get(1).toString();

				if ("1".equals(M_IND_REQ)) {
					if (PM_IL_CONTRACTOR_BEAN.getCONT_REF_ID1() == null
							&& PM_IL_CONTRACTOR_BEAN.getCONT_REF_ID2() == null) {
						throw new ValidatorException(new FacesMessage(
								"Enter Atleast one IC Number"));
					}

					if (PM_IL_CONTRACTOR_BEAN.getCONT_REF_ID1() == ""
							|| PM_IL_CONTRACTOR_BEAN.getCONT_REF_ID1() == null
							&& PM_IL_CONTRACTOR_BEAN.getCONT_REF_ID2() != null) {
						if (PM_IL_CONTRACTOR_BEAN.getROWID() == null) {

							resultset1 = handler.executeSelectStatement(
									sqlQuery1, connection, object1);

							if (resultset1.next()) {
								M_DUMMY = resultset1.getString(1);
								M_CONT_NAME = resultset1.getString(2);
								M_CONT_ADDR1 = resultset1.getString(3);
								M_CONT_ADDR2 = resultset1.getString(4);
								M_CONT_ADDR3 = resultset1.getString(5);
								M_CONT_CONTACT = resultset1.getString(6);
								M_CONT_PHONE = resultset1.getString(7);
								M_CONT_FAX = resultset1.getString(8);
								M_CONT_REMARKS = resultset1.getString(9);
								M_CONT_DFLT_YN = resultset1.getString(10);
								M_CONT_CUST_CODE = resultset1.getString(11);
								M_CONT_FRZ_FLAG = resultset1.getString(12);
								M_CONT_BL_NAME = resultset1.getString(13);
								M_CONT_BL_ADDR1 = resultset1.getString(14);
								M_CONT_BL_ADDR2 = resultset1.getString(15);
								M_CONT_BL_ADDR3 = resultset1.getString(16);
								M_CONT_BL_CONTACT = resultset1.getString(17);
								M_CONT_EMPLOYER_YN = resultset1.getString(18);
								M_CONT_EFF_FM_DT = resultset1.getString(19);
								M_CONT_EFF_TO_DT = resultset1.getString(20);
								M_CONT_REF_NO = resultset1.getString(21);
								M_CONT_REF_ID1 = resultset1.getString(22);
								M_CONT_REF_ID2 = resultset1.getString(23);
								M_CONT_TEL_AREA_CODE = resultset1.getString(24);
								M_CONT_MOBILE_NO = resultset1.getString(25);
								M_CONT_FAX_AREA_CODE = resultset1.getString(26);
								M_CONT_PREFERRED_LANG = resultset1
										.getString(27);
								M_CONT_EMAIL_ID = resultset1.getString(28);
								M_CONT_POSTAL_CODE = resultset1.getString(29);
								M_CONT_CITY = resultset1.getString(30);
								M_CONT_STATE = resultset1.getString(31);
								M_CONT_DOB = resultset1.getDate(32);
								M_CONT_BIRTH_CERT_NO = resultset1.getString(33);
								M_CONT_CATG_CODE = resultset1.getString(34);
								M_CONT_MAR_STATUS = resultset1.getString(35);
								M_CONT_NATIONALITY_CODE = resultset1
										.getString(36);
								M_CONT_RACE = resultset1.getString(37);
								M_CONT_RELIGION = resultset1.getString(38);
								M_CONT_AREA = resultset1.getString(39);
								M_CONT_REGION = resultset1.getString(40);
								M_CONT_AD_BANK_CODE = resultset1.getString(41);
								M_CONT_AD_ACC_NO = resultset1.getString(42);
								M_CONT_CITY_CODE = resultset1.getString(43);
								M_CONT_COUNT_CODE = resultset1.getString(44);
								M_CONT_COUNTRY = resultset1.getString(45);
							}
							resultset1.close();

							if (CommonUtils.nvl(M_DUMMY, "Y").equals("X")) {

								PM_IL_CONTRACTOR_BEAN.setCONT_NAME(M_CONT_NAME);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_ADDR1(M_CONT_ADDR1);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_ADDR2(M_CONT_ADDR2);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_ADDR3(M_CONT_ADDR3);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_CONTACT(M_CONT_CONTACT);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_PHONE(M_CONT_PHONE);
								PM_IL_CONTRACTOR_BEAN.setCONT_FAX(M_CONT_FAX);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_REMARKS(M_CONT_REMARKS);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_EMPLOYER_YN(M_CONT_EMPLOYER_YN);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_BL_NAME(M_CONT_BL_NAME);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_BL_ADDR1(M_CONT_BL_ADDR1);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_BL_ADDR2(M_CONT_BL_ADDR2);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_BL_ADDR3(M_CONT_BL_ADDR3);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_BL_CONTACT(M_CONT_BL_CONTACT);

								PM_IL_CONTRACTOR_BEAN
										.setCONT_REF_ID1(M_CONT_REF_ID1);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_REF_NO(M_CONT_REF_NO);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_REF_ID1(M_CONT_REF_ID1);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_REF_ID2(M_CONT_REF_ID2);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_TEL_AREA_CODE(M_CONT_TEL_AREA_CODE);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_MOBILE_NO(M_CONT_MOBILE_NO);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_FAX_AREA_CODE(M_CONT_FAX_AREA_CODE);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_PREFERRED_LANG(M_CONT_PREFERRED_LANG);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_CITY_CODE(M_CONT_CITY_CODE);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_COUNT_CODE(M_CONT_COUNT_CODE);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_COUNTRY(M_CONT_COUNTRY);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_STATE_CODE(M_CONT_STATE);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_CATG_CODE(M_CONT_CATG_CODE);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_MAR_STATUS(M_CONT_MAR_STATUS);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_NATIONALITY_CODE(M_CONT_NATIONALITY_CODE);
								PM_IL_CONTRACTOR_BEAN.setCONT_RACE(M_CONT_RACE);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_RELIGION(M_CONT_RELIGION);
								PM_IL_CONTRACTOR_BEAN.setCONT_AREA(M_CONT_AREA);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_REGION(M_CONT_REGION);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_AD_BANK_CODE(M_CONT_AD_BANK_CODE);
								PM_IL_CONTRACTOR_BEAN
										.setCONT_AD_ACC_NO(M_CONT_AD_ACC_NO);
								PM_IL_CONTRACTOR_BEAN.setCONT_DOB(M_CONT_DOB);

								COMP_CONT_NAME.setSubmittedValue(M_CONT_NAME);
								COMP_CONT_ADDR1.setSubmittedValue(M_CONT_ADDR1);
								COMP_CONT_ADDR2.setSubmittedValue(M_CONT_ADDR2);
								COMP_CONT_ADDR3.setSubmittedValue(M_CONT_ADDR3);
								COMP_CONT_CONTACT
										.setSubmittedValue(M_CONT_CONTACT);
								COMP_CONT_PHONE.setSubmittedValue(M_CONT_PHONE);
								COMP_CONT_FAX.setSubmittedValue(M_CONT_FAX);
								COMP_CONT_REMARKS
										.setSubmittedValue(M_CONT_REMARKS);
								COMP_CONT_EMPLOYER_YN
										.setSubmittedValue(M_CONT_EMPLOYER_YN);
								COMP_CONT_BL_NAME
										.setSubmittedValue(M_CONT_BL_NAME);
								COMP_CONT_BL_ADDR1
										.setSubmittedValue(M_CONT_BL_ADDR1);
								COMP_CONT_BL_ADDR2
										.setSubmittedValue(M_CONT_BL_ADDR2);
								COMP_CONT_BL_ADDR3
										.setSubmittedValue(M_CONT_BL_ADDR3);
								COMP_CONT_BL_CONTACT
										.setSubmittedValue(M_CONT_BL_CONTACT);
								COMP_CONT_EFF_FM_DT
										.setSubmittedValue(M_CONT_EFF_FM_DT);
								COMP_CONT_EFF_TO_DT
										.setSubmittedValue(M_CONT_EFF_TO_DT);
								COMP_CONT_REF_NO
										.setSubmittedValue(M_CONT_REF_NO);
								COMP_CONT_REF_ID1
										.setSubmittedValue(M_CONT_REF_ID1);
								COMP_CONT_REF_ID2
										.setSubmittedValue(M_CONT_REF_ID2);
								COMP_CONT_TEL_AREA_CODE
										.setSubmittedValue(M_CONT_TEL_AREA_CODE);
								COMP_CONT_MOBILE_NO
										.setSubmittedValue(M_CONT_MOBILE_NO);
								COMP_CONT_FAX_AREA_CODE
										.setSubmittedValue(M_CONT_FAX_AREA_CODE);
								COMP_CONT_PREFERRED_LANG
										.setSubmittedValue(M_CONT_PREFERRED_LANG);
								COMP_CONT_EMAIL_ID
										.setSubmittedValue(M_CONT_EMAIL_ID);
								COMP_CONT_POSTAL_CODE
										.setSubmittedValue(M_CONT_POSTAL_CODE);
								COMP_CONT_CITY_CODE
										.setSubmittedValue(M_CONT_CITY_CODE);

								COMP_CONT_COUNT_CODE
										.setSubmittedValue(M_CONT_COUNT_CODE);
								COMP_CONT_COUNTRY
										.setSubmittedValue(M_CONT_COUNTRY);
								COMP_CONT_STATE_CODE
										.setSubmittedValue(M_CONT_STATE);
								COMP_CONT_DOB.setSubmittedValue(M_CONT_DOB);
								COMP_CONT_BIRTH_CERT_NO
										.setSubmittedValue(M_CONT_BIRTH_CERT_NO);
								COMP_CONT_CATG_CODE
										.setSubmittedValue(M_CONT_CATG_CODE);
								COMP_CONT_MAR_STATUS
										.setSubmittedValue(M_CONT_MAR_STATUS);
								COMP_CONT_NATIONALITY_CODE
										.setSubmittedValue(M_CONT_NATIONALITY_CODE);
								COMP_CONT_RACE.setSubmittedValue(M_CONT_RACE);
								COMP_CONT_RELIGION
										.setSubmittedValue(M_CONT_RELIGION);
								COMP_CONT_AREA.setSubmittedValue(M_CONT_AREA);
								COMP_CONT_REGION
										.setSubmittedValue(M_CONT_REGION);
								COMP_CONT_AD_BANK_CODE
										.setSubmittedValue(M_CONT_AD_BANK_CODE);
								COMP_CONT_AD_ACC_NO
										.setSubmittedValue(M_CONT_AD_ACC_NO);

								// all description fetch by post_query
								pilm016_apac_pm_il_contractor_post_query();
							}
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Calls When Validate Trigger for CONT_REF_ID2
	 * 
	 * @param event
	 * @throws SQLException
	 * @throws Exception
	 */
	// Sep-11 added
	public void validateCONT_REF_ID2(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException {
		PM_IL_CONTRACTOR_BEAN.setCONT_REF_ID2((String) value);
		try {
			if (PM_IL_CONTRACTOR_BEAN.getCONT_REF_ID1() == null
					&& PM_IL_CONTRACTOR_BEAN.getCONT_REF_ID2() == null) {
				throw new ValidatorException(new FacesMessage(
						"Enter Atleast one IC Number"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * public String least(String vembu0, String M_REF_ID2_LENGTH) throws
	 * SQLException, Exception { String least_list0[] = new String[2];
	 * least_list0[0] = vembu0; least_list0[1] = M_REF_ID2_LENGTH; return new
	 * PM_IL_CONTRACTOR_ACTION_VALIDATION().least(least_list0); }
	 */

	public String least(String vembu0, String M_REF_ID_1_LENGTH)
			throws SQLException, Exception {
		String least_list0[] = new String[2];
		least_list0[0] = vembu0;
		least_list0[1] = M_REF_ID_1_LENGTH;
		return MigratingFunctions.least(least_list0);
	}

	public void pilm_apac_pm_il_contractor_cont_ref_id1_when_validate_item(
			ActionEvent actionEvent) {
		System.out.println("PM_IL_CONTRACTOR_ACTION.Reference ID1()");
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		/* Modified by Janani on 07.08.2017 for ZBILQC-1732979*/
		HashMap<String, String> dynamicLabelMap = new HashMap<String, String>();		
		dynamicLabelMap.put(input.getId(), COMP_CONT_REF_ID1_LABEL.getValue().toString());
		ErrorHelpUtil.validate(input, getErrorMap(),dynamicLabelMap);
		/*end*/
		String RECORD_STATUS = "INSERT";
		PM_IL_CONTRACTOR_ACTION_VALIDATION validation = new PM_IL_CONTRACTOR_ACTION_VALIDATION();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String refId1 = (String) getCOMP_CONT_REF_ID1().getSubmittedValue();
		if (!refId1.isEmpty()) {
			PM_IL_CONTRACTOR_BEAN.setCONT_REF_ID1(refId1);
			String sqlQuery1 = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_QUERY_REFID1_DETAIL;
			String sqlQuery3 = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_SELECT_X_FOR_REF_ID_1_AND_ROW_ID;
			String sqlQuery4 = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_QUERY_PCCODE_SELECT;
			ResultSet resultset1 = null;
			ResultSet resultset3 = null;
			ResultSet resultset4 = null;
			String M_DUMMY = null;
			String M_DATE_CHAR = null;
			Long M_GENDER = null;
			String M_VALUE = null;
			String M_CONT_NAME = null;
			String M_CONT_ADDR1 = null;
			String M_CONT_ADDR2 = null;
			String M_CONT_ADDR3 = null;
			String M_CONT_CONTACT = null;
			String M_CONT_PHONE = null;
			String M_CONT_FAX = null;
			String M_CONT_REMARKS = null;
			String M_CONT_DFLT_YN = null;
			String M_CONT_CUST_CODE = null;
			String M_CONT_FRZ_FLAG = null;
			String M_CONT_BL_NAME = null;
			String M_CONT_BL_ADDR1 = null;
			String M_CONT_BL_ADDR2 = null;
			String M_CONT_BL_ADDR3 = null;
			String M_CONT_BL_CONTACT = null;
			String M_CONT_EMPLOYER_YN = null;
			String M_CONT_EFF_FM_DT = null;
			String M_CONT_EFF_TO_DT = null;
			String M_CONT_REF_NO = null;
			String M_CONT_REF_ID1 = null;
			String M_CONT_REF_ID2 = null;
			String M_CONT_TEL_AREA_CODE = null;
			String M_CONT_MOBILE_NO = null;
			String M_CONT_FAX_AREA_CODE = null;
			String M_CONT_PREFERRED_LANG = null;
			String M_CONT_EMAIL_ID = null;
			String M_CONT_POSTAL_CODE = null;
			String M_CONT_CITY = null;
			String M_CONT_CITY_CODE = null;
			String M_CONT_STATE = null;
			Date M_CONT_DOB = null;
			String M_CONT_BIRTH_CERT_NO = null;
			String M_CONT_CATG_CODE = null;
			String M_CONT_MAR_STATUS = null;
			String M_CONT_NATIONALITY_CODE = null;
			String M_CONT_RACE = null;
			String M_CONT_RELIGION = null;
			String M_CONT_AREA = null;
			String M_CONT_REGION = null;
			String M_CONT_AD_BANK_CODE = null;
			String M_CONT_AD_ACC_NO = null;
			String M_CONT_COUNT_CODE = null;
			String M_CONT_COUNTRY = null;
			String M_CODE_DESC = null;
			String M_CONT_DOB_1 = null;
			String M_PS_VALUE_1 = null;
			String M_CODE_DESC_1 = null;
			String M_PC_CODE = null;
			double M_LENGTH_1 = -1;
			double M_NEW_IC_NO_LENGTH = -1;
			double M_REF_ID_1_LENGTH = COMP_CONT_REF_ID1.getMaxlength();
			int errorCode = -1;

			Object[] object1 = { refId1 };
			Object[] object3 = { refId1, PM_IL_CONTRACTOR_BEAN.getROWID() };
			Object[] object4 = {};

			try {
				connection = CommonUtils.getConnection();
				if (refId1.length() > 1) {

					if (PM_IL_CONTRACTOR_BEAN.getROWID() == null) {
						System.out.println("ENTER COND 1");
						if (resultset1 != null) {
							resultset1.close();
						}
						resultset1 = handler.executeSelectStatement(sqlQuery1,
								connection, object1);
						if (resultset1.next()) {
							M_DUMMY = resultset1.getString(1);
							M_CONT_NAME = resultset1.getString(2);
							M_CONT_ADDR1 = resultset1.getString(3);
							M_CONT_ADDR2 = resultset1.getString(4);
							M_CONT_ADDR3 = resultset1.getString(5);
							M_CONT_CONTACT = resultset1.getString(6);
							M_CONT_PHONE = resultset1.getString(7);
							M_CONT_FAX = resultset1.getString(8);
							M_CONT_REMARKS = resultset1.getString(9);
							M_CONT_DFLT_YN = resultset1.getString(10);
							M_CONT_CUST_CODE = resultset1.getString(11);
							M_CONT_FRZ_FLAG = resultset1.getString(12);
							M_CONT_BL_NAME = resultset1.getString(13);
							M_CONT_BL_ADDR1 = resultset1.getString(14);
							M_CONT_BL_ADDR2 = resultset1.getString(15);
							M_CONT_BL_ADDR3 = resultset1.getString(16);
							M_CONT_BL_CONTACT = resultset1.getString(17);
							M_CONT_EMPLOYER_YN = resultset1.getString(18);
							M_CONT_EFF_FM_DT = resultset1.getString(19);
							M_CONT_EFF_TO_DT = resultset1.getString(20);
							M_CONT_REF_NO = resultset1.getString(21);
							M_CONT_REF_ID1 = resultset1.getString(22);
							M_CONT_REF_ID2 = resultset1.getString(23);
							M_CONT_TEL_AREA_CODE = resultset1.getString(24);
							M_CONT_MOBILE_NO = resultset1.getString(25);
							M_CONT_FAX_AREA_CODE = resultset1.getString(26);
							M_CONT_PREFERRED_LANG = resultset1.getString(27);
							M_CONT_EMAIL_ID = resultset1.getString(28);
							M_CONT_POSTAL_CODE = resultset1.getString(29);
							M_CONT_CITY = resultset1.getString(30);
							M_CONT_STATE = resultset1.getString(31);
							M_CONT_DOB = resultset1.getDate(32);
							M_CONT_BIRTH_CERT_NO = resultset1.getString(33);
							M_CONT_CATG_CODE = resultset1.getString(34);
							M_CONT_MAR_STATUS = resultset1.getString(35);
							M_CONT_NATIONALITY_CODE = resultset1.getString(36);
							M_CONT_RACE = resultset1.getString(37);
							M_CONT_RELIGION = resultset1.getString(38);
							M_CONT_AREA = resultset1.getString(39);
							M_CONT_REGION = resultset1.getString(40);
							M_CONT_AD_BANK_CODE = resultset1.getString(41);
							M_CONT_AD_ACC_NO = resultset1.getString(42);
							M_CONT_CITY_CODE = resultset1.getString(43);
							M_CONT_COUNT_CODE = resultset1.getString(44);
							M_CONT_COUNTRY = resultset1.getString(45);
						}

						resultset1.close();
						String sqlQuery2 = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_SELECT_REF_ID_1;
						ResultSet resultset2 = null;
						Object[] object2 = { M_CONT_REF_ID1 };
						if (MigratingFunctions.nvl(M_DUMMY, "Y")
								.equalsIgnoreCase("X")) {
							System.out.println("RESULT SET VALUES :"
									+ M_CONT_NAME);
							PM_IL_CONTRACTOR_BEAN.setCONT_NAME(M_CONT_NAME);
							PM_IL_CONTRACTOR_BEAN.setCONT_ADDR1(M_CONT_ADDR1);
							PM_IL_CONTRACTOR_BEAN.setCONT_ADDR2(M_CONT_ADDR2);
							PM_IL_CONTRACTOR_BEAN.setCONT_ADDR3(M_CONT_ADDR3);
							PM_IL_CONTRACTOR_BEAN
									.setCONT_CONTACT(M_CONT_CONTACT);
							PM_IL_CONTRACTOR_BEAN.setCONT_PHONE(M_CONT_PHONE);
							PM_IL_CONTRACTOR_BEAN.setCONT_FAX(M_CONT_FAX);
							PM_IL_CONTRACTOR_BEAN
									.setCONT_REMARKS(M_CONT_REMARKS);
							PM_IL_CONTRACTOR_BEAN
									.setCONT_EMPLOYER_YN(M_CONT_EMPLOYER_YN);
							PM_IL_CONTRACTOR_BEAN
									.setCONT_BL_NAME(M_CONT_BL_NAME);
							PM_IL_CONTRACTOR_BEAN
									.setCONT_BL_ADDR1(M_CONT_BL_ADDR1);
							PM_IL_CONTRACTOR_BEAN
									.setCONT_BL_ADDR2(M_CONT_BL_ADDR2);
							PM_IL_CONTRACTOR_BEAN
									.setCONT_BL_ADDR3(M_CONT_BL_ADDR3);
							PM_IL_CONTRACTOR_BEAN
									.setCONT_BL_CONTACT(M_CONT_BL_CONTACT);
							// PM_IL_CONTRACTOR_BEAN.setCONT_EFF_FM_DT(M_CONT_EFF_FM_DT);
							PM_IL_CONTRACTOR_BEAN
									.setCONT_REF_ID1(M_CONT_REF_ID1);
							PM_IL_CONTRACTOR_BEAN.setCONT_REF_NO(M_CONT_REF_NO);
							PM_IL_CONTRACTOR_BEAN
									.setCONT_REF_ID2(M_CONT_REF_ID2);
							PM_IL_CONTRACTOR_BEAN
									.setCONT_TEL_AREA_CODE(M_CONT_TEL_AREA_CODE);
							PM_IL_CONTRACTOR_BEAN
									.setCONT_MOBILE_NO(M_CONT_MOBILE_NO);
							PM_IL_CONTRACTOR_BEAN
									.setCONT_FAX_AREA_CODE(M_CONT_FAX_AREA_CODE);
							PM_IL_CONTRACTOR_BEAN
									.setCONT_PREFERRED_LANG(M_CONT_PREFERRED_LANG);
							PM_IL_CONTRACTOR_BEAN
									.setCONT_CITY_CODE(M_CONT_CITY_CODE);
							PM_IL_CONTRACTOR_BEAN
									.setCONT_COUNT_CODE(M_CONT_COUNT_CODE);
							PM_IL_CONTRACTOR_BEAN
									.setCONT_COUNTRY(M_CONT_COUNTRY);
							PM_IL_CONTRACTOR_BEAN
									.setCONT_STATE_CODE(M_CONT_STATE);
							PM_IL_CONTRACTOR_BEAN
									.setCONT_CATG_CODE(M_CONT_CATG_CODE);
							PM_IL_CONTRACTOR_BEAN
									.setCONT_MAR_STATUS(M_CONT_MAR_STATUS);
							PM_IL_CONTRACTOR_BEAN
									.setCONT_NATIONALITY_CODE(M_CONT_NATIONALITY_CODE);
							PM_IL_CONTRACTOR_BEAN.setCONT_RACE(M_CONT_RACE);
							PM_IL_CONTRACTOR_BEAN
									.setCONT_RELIGION(M_CONT_RELIGION);
							PM_IL_CONTRACTOR_BEAN.setCONT_AREA(M_CONT_AREA);
							PM_IL_CONTRACTOR_BEAN.setCONT_REGION(M_CONT_REGION);
							PM_IL_CONTRACTOR_BEAN
									.setCONT_AD_BANK_CODE(M_CONT_AD_BANK_CODE);
							PM_IL_CONTRACTOR_BEAN
									.setCONT_AD_ACC_NO(M_CONT_AD_ACC_NO);
							PM_IL_CONTRACTOR_BEAN.setCONT_DOB(M_CONT_DOB);
							CommonUtils.objectSysout(PM_IL_CONTRACTOR_BEAN);
							COMP_CONT_NAME.setSubmittedValue(M_CONT_NAME);
							COMP_CONT_ADDR1.setSubmittedValue(M_CONT_ADDR1);
							COMP_CONT_ADDR2.setSubmittedValue(M_CONT_ADDR2);
							COMP_CONT_ADDR3.setSubmittedValue(M_CONT_ADDR3);
							COMP_CONT_CONTACT.setSubmittedValue(M_CONT_CONTACT);
							COMP_CONT_PHONE.setSubmittedValue(M_CONT_PHONE);
							COMP_CONT_FAX.setSubmittedValue(M_CONT_FAX);
							COMP_CONT_REMARKS.setSubmittedValue(M_CONT_REMARKS);
							COMP_CONT_EMPLOYER_YN
									.setSubmittedValue(M_CONT_EMPLOYER_YN);
							/*
							 * :PM_IL_CONTRACTOR.CONT_DFLT_YN=M_CONT_DFLT_YN;
							 * :PM_IL_CONTRACTOR.CONT_FRZ_FLAG=M_CONT_FRZ_FLAG;
							 */
							System.out
									.println("********  1111111111 **********");
							COMP_CONT_BL_NAME.setSubmittedValue(M_CONT_BL_NAME);
							COMP_CONT_BL_ADDR1
									.setSubmittedValue(M_CONT_BL_ADDR1);
							COMP_CONT_BL_ADDR2
									.setSubmittedValue(M_CONT_BL_ADDR2);
							COMP_CONT_BL_ADDR3
									.setSubmittedValue(M_CONT_BL_ADDR3);
							COMP_CONT_BL_CONTACT
									.setSubmittedValue(M_CONT_BL_CONTACT);
							COMP_CONT_EFF_FM_DT
									.setSubmittedValue(M_CONT_EFF_FM_DT);
							COMP_CONT_EFF_TO_DT
									.setSubmittedValue(M_CONT_EFF_TO_DT);
							COMP_CONT_REF_NO.setSubmittedValue(M_CONT_REF_NO);
							COMP_CONT_REF_ID1.setSubmittedValue(M_CONT_REF_ID1);
							COMP_CONT_REF_ID2.setSubmittedValue(M_CONT_REF_ID2);
							COMP_CONT_TEL_AREA_CODE
									.setSubmittedValue(M_CONT_TEL_AREA_CODE);
							COMP_CONT_MOBILE_NO
									.setSubmittedValue(M_CONT_MOBILE_NO);
							COMP_CONT_FAX_AREA_CODE
									.setSubmittedValue(M_CONT_FAX_AREA_CODE);
							COMP_CONT_PREFERRED_LANG
									.setSubmittedValue(M_CONT_PREFERRED_LANG);
							COMP_CONT_EMAIL_ID
									.setSubmittedValue(M_CONT_EMAIL_ID);
							COMP_CONT_POSTAL_CODE
									.setSubmittedValue(M_CONT_POSTAL_CODE);
							COMP_CONT_CITY_CODE
									.setSubmittedValue(M_CONT_CITY_CODE);
							// COMP_CONT_CITY.setSubmittedValue(M_CONT_CITY);
							COMP_CONT_COUNT_CODE
									.setSubmittedValue(M_CONT_COUNT_CODE);
							COMP_CONT_COUNTRY.setSubmittedValue(M_CONT_COUNTRY);
							COMP_CONT_STATE_CODE
									.setSubmittedValue(M_CONT_STATE);
							// COMP_CONT_DOB.setSubmittedValue(M_CONT_DOB);
							COMP_CONT_BIRTH_CERT_NO
									.setSubmittedValue(M_CONT_BIRTH_CERT_NO);
							COMP_CONT_CATG_CODE
									.setSubmittedValue(M_CONT_CATG_CODE);
							COMP_CONT_MAR_STATUS
									.setSubmittedValue(M_CONT_MAR_STATUS);
							System.out
									.println("********  222222222222 **********");
							COMP_CONT_NATIONALITY_CODE
									.setSubmittedValue(M_CONT_NATIONALITY_CODE);
							COMP_CONT_RACE.setSubmittedValue(M_CONT_RACE);
							COMP_CONT_RELIGION
									.setSubmittedValue(M_CONT_RELIGION);
							COMP_CONT_AREA.setSubmittedValue(M_CONT_AREA);
							COMP_CONT_REGION.setSubmittedValue(M_CONT_REGION);
							COMP_CONT_AD_BANK_CODE
									.setSubmittedValue(M_CONT_AD_BANK_CODE);
							COMP_CONT_AD_ACC_NO
									.setSubmittedValue(M_CONT_AD_ACC_NO);

							System.out
									.println("BEFORE PROCEDURE CALLING P_VAL_SYSTEM:  "
											+ PM_IL_CONTRACTOR_BEAN
													.getCONT_CATG_CODE());

							ArrayList categoryList = P_VAL_SYSTEM
									.P_VAL_SYSTEM(
											connection,
											PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_REF_ID1_TYPE,
											// COMP_CONT_CATG_CODE.getSubmittedValue().toString(),
											PM_IL_CONTRACTOR_BEAN
													.getCONT_CATG_CODE(),
											PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_REF_ID1_ERRORFLAG);
							System.out.println(" CategoryDesc : "
									+ categoryList.get(0));
							PM_IL_CONTRACTOR_BEAN
									.setUI_M_CONT_CATG_CODE_DESC(categoryList
											.get(0).toString());
							// COMP_UI_M_CONT_CATG_CODE_DESC.setSubmittedValue(categoryList.get(0).toString());
							System.out.println("Category List : "
									+ categoryList);
							System.out.println(" M_Vaue ::"
									+ categoryList.get(1));
							M_VALUE = categoryList.get(1).toString();

							if (PM_IL_CONTRACTOR_BEAN.getCONT_MAR_STATUS() != null) {

								ArrayList maritalStatusList = P_VAL_SYSTEM
										.P_VAL_SYSTEM(
												connection,
												PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_REF_ID1_TYPE1,
												COMP_CONT_MAR_STATUS
														.getSubmittedValue()
														.toString(),
												PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_REF_ID1_ERRORFLAG);
								COMP_UI_M_CONT_MAR_STATUS_DESC
										.setSubmittedValue(maritalStatusList
												.get(0).toString());
								M_VALUE = maritalStatusList.get(1).toString();
							}

							// P_VAL_SYSTEM.P_VAL_SYSTEM("CATG",COMP_CONT_CATG_CODE.getSubmittedValue().toString(),PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_REF_ID1_ERRORFLAG);
							// P_VAL_SYSTEM.P_VAL_SYSTEM("MARI_STAT",:PM_IL_CONTRACTOR.CONT_MAR_STATUS,:DUMMY.M_CONT_MAR_STATUS_DESC,"N",M_VALUE);
							if (PM_IL_CONTRACTOR_BEAN
									.getCONT_NATIONALITY_CODE() == null) {
								if (resultset4 != null) {
									resultset4.close();
								}
								resultset4 = handler.executeSelectStatement(
										sqlQuery4, connection, object4);
								if (resultset4.next()) {
									M_PC_CODE = resultset4.getString(1);
								}
								COMP_CONT_NATIONALITY_CODE
										.setSubmittedValue(M_PC_CODE);
								// :PM_IL_CONTRACTOR.CONT_NATIONALITY_CODE=M_PC_CODE;

								String nationalityCodeDescription = P_VAL_CODES
										.P_VAL_CODES(
												connection,
												PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_P_VAL_CODES_TYPE,
												PM_IL_CONTRACTOR_BEAN
														.getCONT_NATIONALITY_CODE(),
												PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG,
												PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG);
								COMP_UI_M_CONT_NATIONALITY_CODE_DESC
										.setSubmittedValue(nationalityCodeDescription);
								// P_VAL_CODES.P_VAL_CODES("NATLITY",:PM_IL_CONTRACTOR.CONT_NATIONALITY_CODE,:DUMMY.M_CONT_NATIONALITY_CODE_DESC,"N","N",null);
								resultset4.close();
								M_PC_CODE = null;
							}
							if (PM_IL_CONTRACTOR_BEAN.getCONT_RELIGION() != null) {

								String religionDescription = P_VAL_CODES
										.P_VAL_CODES(
												connection,
												PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_P_VAL_CODES_TYPE1,
												PM_IL_CONTRACTOR_BEAN
														.getCONT_RELIGION(),
												PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG,
												PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG);
								COMP_UI_M_CONT_RELIGION_DESC
										.setSubmittedValue(religionDescription);
							}

							String raceDescription = P_VAL_CODES
									.P_VAL_CODES(
											connection,
											PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_P_VAL_CODES_TYPE2,
											PM_IL_CONTRACTOR_BEAN
													.getCONT_RACE(),
											PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG,
											PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG);
							COMP_UI_M_CONT_RACE_DESC
									.setSubmittedValue(raceDescription);
							// P_VAL_CODES.P_VAL_CODES("RELIGION",:PM_IL_CONTRACTOR.CONT_RELIGION,:DUMMY.M_CONT_RELIGION_DESC,"N","N",null);
							// P_VAL_CODES.P_VAL_CODES("RACE",:PM_IL_CONTRACTOR.CONT_RACE,:DUMMY.M_CONT_RACE_DESC,"N","N",null);
							// L_AD_BANK_NAME.L_AD_BANK_NAME();

							/* Bank name */
							if (PM_IL_CONTRACTOR_BEAN.getCONT_AD_BANK_CODE() != null) {
								String bankName = validation.loadBankName(
										connection, PM_IL_CONTRACTOR_BEAN
												.getCONT_AD_BANK_CODE());
								COMP_UI_M_CONT_AD_BANK_NAME
										.setSubmittedValue(bankName);

							} else {
								COMP_CONT_AD_BANK_CODE.setSubmittedValue(null);
							}

						}
					}

					ArrayList lengthList = P_VAL_SYSTEM
							.P_VAL_SYSTEM(
									connection,
									PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_REF_ID1_TYPE2,
									PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_REF_ID1_CODE,
									PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_ERRORFLAG);
					System.out.println("LengthList ::" + lengthList);
					M_CODE_DESC = lengthList.get(0).toString();
					M_NEW_IC_NO_LENGTH = Double.parseDouble(lengthList.get(1)
							.toString());

					try {
						M_LENGTH_1 = Double.parseDouble(least(""
								+ (MigratingFunctions.nvl(M_NEW_IC_NO_LENGTH,
										M_REF_ID_1_LENGTH)), ""
								+ M_REF_ID_1_LENGTH));
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("M_LENGTH_1 ::" + M_LENGTH_1);

					if (refId1.length() > M_LENGTH_1) {
						throw new ValidatorException(Messages.getMessage(
								bundleName, "91240",
								new Object[] { M_LENGTH_1 }));
					}

					ArrayList ps_valueList = P_VAL_SYSTEM.P_VAL_SYSTEM(
							connection, "CUSTREFFMT", "CUSTREFFMT", "N");
					M_CODE_DESC_1 = ps_valueList.get(0).toString();
					M_PS_VALUE_1 = ps_valueList.get(1).toString();

					if (M_PS_VALUE_1.equals("1")) {

						String value1 = (String) refId1;
						String query = "SELECT TO_CHAR(TO_DATE(?,'RRMMDD'),'dd/MM/RRRR') FROM DUAL";
						ResultSet resultSet1 = handler.executeSelectStatement(
								query, connection, new Object[] { CommonUtils
										.SUBSTR(value1, 1, 6) });
						if (resultSet1.next()) {
							M_DATE_CHAR = resultSet1.getString(1);
						}
						Date date = CommonUtils
								.stringToPelUtilDate(M_DATE_CHAR);
						CommonUtils.closeCursor(resultSet1);
						PM_IL_CONTRACTOR_BEAN.setCONT_DOB(date);
						M_GENDER = Long.parseLong(value1);
					}

					if ((M_GENDER % 2) == 0) {

						COMP_CONT_CATG_CODE
								.setSubmittedValue(PILM016_PM_IL_CONTRACTOR_CONSTANTS.CATEGORY_CODE_2);
					} else {
						COMP_CONT_CATG_CODE
								.setSubmittedValue(PILM016_PM_IL_CONTRACTOR_CONSTANTS.CATEGORY_CODE_1);
					}

					if (PM_IL_CONTRACTOR_BEAN.getCONT_CATG_CODE() != null) {

						ArrayList categoryList = P_VAL_SYSTEM
								.P_VAL_SYSTEM(
										connection,
										PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_REF_ID1_TYPE,
										PM_IL_CONTRACTOR_BEAN
												.getCONT_CATG_CODE(),
										PILM016_PM_IL_CONTRACTOR_CONSTANTS.E_Flag);
						COMP_UI_M_CONT_CATG_CODE_DESC
								.setSubmittedValue(categoryList.get(0)
										.toString());
						M_VALUE = categoryList.get(1).toString();
						System.out.println("M_VALUE :" + M_VALUE);
					}

				} else {

					if (refId1 != null) {
						COMP_CONT_DOB.setSubmittedValue(null);
						COMP_CONT_CATG_CODE.setSubmittedValue(null);
						COMP_UI_M_CONT_CATG_CODE_DESC.setSubmittedValue(null);

					}

				}
			} catch (Exception exception) {
				exception.getStackTrace();

			}

			String contCode = PM_IL_CONTRACTOR_BEAN.getCONT_STATE_CODE();
			if (contCode != null) {

				String stateDescription = validation
						.P_VAL_CODES(
								connection,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_P_VAL_CODES_TYPE3,
								contCode);

				PM_IL_CONTRACTOR_BEAN.setCONT_STATE(stateDescription);

			} else {
				System.out.println("COMP_CONT_STATE :"
						+ PM_IL_CONTRACTOR_BEAN.getCONT_STATE());
				PM_IL_CONTRACTOR_BEAN.setCONT_STATE(null);

			}

		}
	}

	/**
	 * Calls When Validate Item Trigger on CONT_REF_ID1
	 * 
	 * @param actionEvent
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public void validateCONT_REF_ID1(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException {

	}

	/**
	 * 
	 * @param P_CONT_REF_ID1
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public String L_VALIDATE_ICNO_DOB(String P_CONT_REF_ID1)
			throws ValidatorException {

		String YR = null;
		String MTH = null;
		String DD = null;
		String RTN_VAL = null;
		java.sql.Date M_TEMP_DATE = null;
		System.out.println("IN L_VALIDATE_ICNO_DOB ");

		YR = StringFunctions.substr(P_CONT_REF_ID1, 1, 2);
		MTH = StringFunctions.substr(P_CONT_REF_ID1, 3, 2);
		DD = StringFunctions.substr(P_CONT_REF_ID1, 5, 2);
		if ((Integer.parseInt(DD) > 31) || (Integer.parseInt(DD) < 0)) {
			// STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91173,:CTRL.M_LANG_CODE);
			// throw new FORM_TRIGGER_FAILURE();
			System.out.println("Not a Valid IC Number.Please Re-enter!");
		}
		if ((Integer.parseInt(MTH) > 12) || (Integer.parseInt(MTH) < 0)) {
			// STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91173,:CTRL.M_LANG_CODE);
			// throw new FORM_TRIGGER_FAILURE();
			System.out.println("Not a Valid IC Number.Please Re-enter!");
			throw new ValidatorException(Messages.getMessage(
					PELConstants.pelErrorMessagePath, "91173"));
		}
		// RTN_VAL=(ConvertFunctions.to_date(DD+"-"+MTH+"-"+YR,"DD/MM/RR"));
		RTN_VAL = (ConvertFunctions.to_date(DD + "-" + MTH + "-" + YR,
				"DD/MM/RR").toString());
		M_TEMP_DATE = ConvertFunctions.to_date(RTN_VAL, "DD/MM/RRRR");
		if (ConvertFunctions.to_number(ConvertFunctions.to_char(M_TEMP_DATE,
				"RRRR")) > ConvertFunctions.to_number(ConvertFunctions.to_char(
				new java.sql.Date(Calendar.getInstance().getTimeInMillis()),
				"RRRR"))) {
			M_TEMP_DATE = DateFunctions.add_months(M_TEMP_DATE, -1200);
			RTN_VAL = ConvertFunctions.to_char(M_TEMP_DATE, "DD/MM/RRRR");
		}

		return (RTN_VAL);

	}

	/**
	 * Called on Save(insert) of the form to generate automatically Contractor
	 * Code or Assured Code
	 * 
	 * @throws SQLException
	 * @throws Exception
	 */
	public String P_CREATE_NUMBER() throws ValidatorException {

		ResultSet resultSetPSVALUE = null;
		ResultSet resultSetPSCODE = null;
		ResultSet resultSetNGSYN = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String M_PS_CODE = null;
		String M_TITLE = null;
		String M_FILE = null;
		String M_CODE_DESC = null;
		int M_PS_VALUE = -1;
		String M_TEMP = null;
		String M_NGS_DISABLE_YN = null;
		String CURSOR_C1 = "SELECT PS_VALUE FROM  PP_SYSTEM  WHERE  PS_TYPE  = 'NUM_GEN_YN'  AND PS_CODE  = 'CONTRACTOR' ";
		String cursor_c2 = "SELECT PS_CODE FROM  PP_SYSTEM  WHERE  PS_TYPE  = 'IL_CONT_NUM' ";
		String cursor_c3 = "SELECT    'X',NGS_DISABLE_YN FROM  PM_NUMBER_GEN_SETUP  WHERE  NGS_CODE  = ? ";

		try {
			String divnCode = CommonUtils.getControlBean().getM_DIVN_CODE();
			connection = CommonUtils.getConnection();

			resultSetPSVALUE = handler.executeSelectStatement(CURSOR_C1,
					connection);
			if (resultSetPSVALUE.next()) {
				M_PS_VALUE = Integer.parseInt(resultSetPSVALUE.getString(1));
			}
			resultSetPSVALUE.close();

			if (CommonUtils.nvl(M_PS_VALUE, 2) != 1) {
				COMP_CONT_CODE.setDisabled(false);
				COMP_CONT_CODE.setRequired(true);
			} else {
				resultSetPSCODE = handler.executeSelectStatement(cursor_c2,
						connection);
				if (resultSetPSCODE.next()) {
					M_PS_CODE = resultSetPSCODE.getString(1);
				} else {
					getErrorMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelErrorMessagePath, "91176"));
				}

				resultSetNGSYN = handler.executeSelectStatement(cursor_c3,
						connection, new Object[] { M_PS_CODE });
				if (resultSetNGSYN.next()) {
					M_TEMP = resultSetNGSYN.getString(1);
					M_NGS_DISABLE_YN = resultSetNGSYN.getString(2);
				}
				resultSetNGSYN.close();

				if (!"X".equalsIgnoreCase(M_TEMP)) {

					getErrorMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelErrorMessagePath, "91177"));
				} else if (CommonUtils.nvl(M_NGS_DISABLE_YN, "N")
						.equalsIgnoreCase("N")) {
					COMP_CONT_CODE.setDisabled(false);
					PM_IL_CONTRACTOR_BEAN.setCONT_CODE(P_GEN_AUTO_NO(M_PS_CODE,
							"N"));
					getCOMP_CONT_GEN_NO().setDisabled(true);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		return "";

	}

	/**
	 * Method Which generates the Assured Code or Contractor Code Format also
	 * calls trigger P9ILPR_GEN_CHECK_DIGIT
	 * 
	 * @param P_CCLAS_CODE
	 * @param P_DUMMY_YN
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * @throws Exception
	 */
	public String P_GEN_AUTO_NO(String P_CCLAS_CODE, String P_DUMMY_YN)
			throws Exception {
		String P_CUST_CODE = null;
		ResultSet resultSetNGSValues = null;
		ResultSet resultSetNGSCURRNO = null;
		int rowCount = -1;
		PM_IL_CONTRACTOR_ACTION_VALIDATION validation = new PM_IL_CONTRACTOR_ACTION_VALIDATION();

		Connection connection = null;

		try {
			connection = CommonUtils.getConnection();
			String M_NGS_CODE = null;
			String M_NGS_PREFIX_YN = null;
			String M_NGS_PREFIX = null;
			String M_NGS_SUFFIX_YN = null;
			String /** METADATA NOT FOUND ******** */
			M_NGS_SUFFIX = null;
			String /** METADATA NOT FOUND ******** */
			M_NGS_PAD_YN = null;
			Integer M_NGS_PAD_LENGTH = null;
			String /** METADATA NOT FOUND ******** */
			M_NGS_CHK_DIGIT_YN = null;

			Long M_NGS_FIRST_NO = null;

			Long M_NGS_CURR_NO = null;

			Long M_NGS_LAST_NO = null;
			String /** METADATA NOT FOUND ******** */
			M_NGS_DISABLE_YN = null;
			double M_SEQ_CHK = -1;
			String CURSOR_C1 = PM_IL_CONTRACTOR_SQL_CONSTANTS.PM_IL_CONTRACTOR_P_GEN_AUTO_NO_SELECT_NGS_VALUES;
			String CURSOR_C2 = PM_IL_CONTRACTOR_SQL_CONSTANTS.PM_IL_CONTRACTOR_P_GEN_AUTO_NO_SELECT_NGS_CURRNO;

			resultSetNGSValues = new CRUDHandler().executeSelectStatement(
					CURSOR_C1, CommonUtils.getConnection(),
					new Object[] { P_CCLAS_CODE });
			if (resultSetNGSValues.next()) {
				M_NGS_CODE = resultSetNGSValues.getString(1);
				M_NGS_PREFIX_YN = resultSetNGSValues.getString(2);
				M_NGS_PREFIX = resultSetNGSValues.getString(3);
				M_NGS_SUFFIX_YN = resultSetNGSValues.getString(4);
				M_NGS_SUFFIX = resultSetNGSValues.getString(5);
				M_NGS_PAD_YN = resultSetNGSValues.getString(6);
				M_NGS_PAD_LENGTH = resultSetNGSValues.getInt(7);
				M_NGS_CHK_DIGIT_YN = resultSetNGSValues.getString(8);
				M_NGS_FIRST_NO = resultSetNGSValues.getLong(9);
				M_NGS_CURR_NO = resultSetNGSValues.getLong(10);
				M_NGS_LAST_NO = resultSetNGSValues.getLong(11);
				M_NGS_DISABLE_YN = resultSetNGSValues.getString(12);
			}
			if (resultSetNGSValues.isAfterLast()
					|| resultSetNGSValues.isBeforeFirst()) {
				return P_CUST_CODE;
			}
			resultSetNGSValues.close();

			if (MigratingFunctions.nvl(M_NGS_PREFIX_YN, "N").equalsIgnoreCase(
					"Y")) {
				P_CUST_CODE = M_NGS_PREFIX;
			} else {
				P_CUST_CODE = null;
			}

			resultSetNGSCURRNO = new CRUDHandler().executeSelectStatement(
					CURSOR_C2, CommonUtils.getConnection(),
					new Object[] { P_CCLAS_CODE });
			if (resultSetNGSCURRNO.next()) {
				M_NGS_CURR_NO = resultSetNGSCURRNO.getLong(1);
			}
			resultSetNGSCURRNO.close();

			if (MigratingFunctions.nvl(M_NGS_PAD_YN, "N").equalsIgnoreCase("Y")) {
				P_CUST_CODE = P_CUST_CODE
						+ StringFunctions.lPad(M_NGS_CURR_NO.toString(),
								M_NGS_PAD_LENGTH, "0");
			} else {
				P_CUST_CODE = P_CUST_CODE + M_NGS_CURR_NO;
			}

			if (MigratingFunctions.nvl(M_NGS_CHK_DIGIT_YN, "N")
					.equalsIgnoreCase("Y")) {
				ArrayList seqChkList = validation.P9ILPR_GEN_CHECK_DIGIT(
						connection, P_CUST_CODE, M_SEQ_CHK);
				M_SEQ_CHK = Double.parseDouble(seqChkList.get(1).toString());
				P_CUST_CODE = P_CUST_CODE + M_SEQ_CHK;
			}

			if (MigratingFunctions.nvl(M_NGS_SUFFIX_YN, "N").equalsIgnoreCase(
					"Y")) {
				P_CUST_CODE = P_CUST_CODE + M_NGS_SUFFIX;
			}

			if (P_DUMMY_YN.equals("N")) {
				String CURSOR_C3 = PM_IL_CONTRACTOR_SQL_CONSTANTS.PM_IL_CONTRACTOR_P_GEN_AUTO_NO_UPDATE_PM_NOGENSETUP;
				rowCount = new CRUDHandler().executeUpdateStatement(CURSOR_C3,
						CommonUtils.getConnection(), new Object[] {
								M_NGS_CURR_NO + 1, M_NGS_CODE });
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return P_CUST_CODE;

	}

	public void pilm016_apac_pm_il_contractor_cont_ad_acc_no_key_next_item(
			ActionEvent actionEvent) {
		System.out
				.println("PM_IL_CONTRACTOR_ACTION.pilm016_apac_pm_il_contractor_cont_ad_acc_no_key_next_item()");
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateCONT_AD_ACC_NO(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {

		PM_IL_CONTRACTOR_BEAN.setCONT_AD_ACC_NO((String) value);

		String bankCode = PM_IL_CONTRACTOR_BEAN.getCONT_AD_BANK_CODE();
		if (bankCode != null) {
			if (PM_IL_CONTRACTOR_BEAN.getCONT_AD_ACC_NO() == null) {
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "91375"));
			}
		}
	}

	public List getMarStausCodeList() {
		return marStausCodeList;
	}

	public void setMarStausCodeList(List marStausCodeList) {
		this.marStausCodeList = marStausCodeList;
	}

	public List getCatgCodeList() {
		return catgCodeList;
	}

	public void setCatgCodeList(List catgCodeList) {
		this.catgCodeList = catgCodeList;
	}

	public List getStateCodeList() {
		return stateCodeList;
	}

	public void setStateCodeList(List stateCodeList) {
		this.stateCodeList = stateCodeList;
	}

	public List getCityCodelist() {
		return cityCodelist;
	}

	public void setCityCodelist(List cityCodelist) {
		this.cityCodelist = cityCodelist;
	}

	public List getReligionCodeList() {
		return religionCodeList;
	}

	public void setReligionCodeList(List religionCodeList) {
		this.religionCodeList = religionCodeList;
	}

	public List getRaceCodeList() {
		return raceCodeList;
	}

	public void setRaceCodeList(List raceCodeList) {
		this.raceCodeList = raceCodeList;
	}

	public List getReceiptBankCodeList() {
		return receiptBankCodeList;
	}

	public void setReceiptBankCodeList(List receiptBankCodeList) {
		this.receiptBankCodeList = receiptBankCodeList;
	}

	public List getNationalityCodeList() {
		return nationalityCodeList;
	}

	public void setNationalityCodeList(List nationalityCodeList) {
		this.nationalityCodeList = nationalityCodeList;
	}

	/**
	 * Called on SuggestionBox for Martial Code
	 * 
	 * @param event
	 * @return
	 */
	public List suggestionActionMaritalStatus(Object event) {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();

			String marStatusCode = (String) event;
			System.out.println("Marital status code :" + marStatusCode);
			marStausCodeList = new PM_IL_CONTRACTOR_ACTION_VALIDATION()
					.prepareMarStatusCodeList(connection, marStatusCode,
							marStausCodeList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return marStausCodeList;
	}

	/**
	 * Called on SuggestionBox Column to display description to a code
	 * 
	 * @param event
	 */
	public void getMaritalSatusDesc(ActionEvent event) {

		if (COMP_CONT_MAR_STATUS.getSubmittedValue() != null) {
			String marStatusCode = (String) COMP_CONT_MAR_STATUS
					.getSubmittedValue();
			PM_IL_CONTRACTOR_BEAN.setCONT_MAR_STATUS(marStatusCode);
			String marStatusDesc = new PM_IL_CONTRACTOR_ACTION_VALIDATION()
					.getMarStatusDescforCode(marStatusCode, marStausCodeList);
			PM_IL_CONTRACTOR_BEAN.setUI_M_CONT_MAR_STATUS_DESC(marStatusDesc);
			COMP_UI_M_CONT_MAR_STATUS_DESC.setSubmittedValue(marStatusDesc);
			PM_IL_CONTRACTOR_BEAN.setUI_M_CONT_MAR_STATUS_DESC(marStatusDesc);
		}
	}

	/**
	 * 
	 * @param event
	 * @return
	 */
	public List suggestionActionCatgCode(Object event) {
		String catgCode = (String) event;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();

			catgCodeList = new PM_IL_CONTRACTOR_ACTION_VALIDATION()
					.prepareCatgCodeList(connection, catgCode, catgCodeList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return catgCodeList;
	}

	/**
	 * 
	 * @param event
	 */
	public void getCatgCodeDesc(ActionEvent event) {
		COMP_UI_M_CONT_CATG_CODE_DESC.setSubmittedValue(null);
		if (COMP_CONT_CATG_CODE.getSubmittedValue() != null) {
			String catgCode = (String) COMP_CONT_CATG_CODE.getSubmittedValue();
			System.out.println("Categ Code*********** " + catgCode);
			String catgCodeDesc = new PM_IL_CONTRACTOR_ACTION_VALIDATION()
					.getCatgDescforCode(catgCode, catgCodeList);
			COMP_UI_M_CONT_CATG_CODE_DESC.setSubmittedValue(catgCodeDesc);
			PM_IL_CONTRACTOR_BEAN.setUI_M_CONT_CATG_CODE_DESC(catgCodeDesc);
		}
	}

	/**
	 * Called on SuggestionBox for State Code
	 * 
	 * @param event
	 * @return
	 */
	public List suggestionActionStateCode(Object event) {
		String stateCode = (String) event;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();

			stateCodeList = new PM_IL_CONTRACTOR_ACTION_VALIDATION()
					.prepareStateCodeList(connection, stateCode, stateCodeList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stateCodeList;
	}

	/**
	 * Called on State SuggestionBox Column to display description to a code
	 * 
	 * @param event
	 */
	public void getStateCodeDesc(ActionEvent event) {
		// COMP_UI_M_CONT_MAR_STATUS_DESC.setSubmittedValue(null);
		// COMP_CONT_STATE.setSubmittedValue(null);
		if (COMP_CONT_STATE_CODE.getSubmittedValue() != null) {
			String stateCode = (String) COMP_CONT_STATE_CODE
					.getSubmittedValue();
			String stateDesc = new PM_IL_CONTRACTOR_ACTION_VALIDATION()
					.getStateDescforCode(stateCode, stateCodeList);
			System.out.println("STATE DESC :" + stateDesc);
			// COMP_UI_M_CONT_MAR_STATUS_DESC.setSubmittedValue(stateDesc);
			COMP_UI_M_CONT_STATE_CODE_DESC.setSubmittedValue(stateDesc);
			PM_IL_CONTRACTOR_BEAN.setCONT_STATE(stateDesc);
		}
	}

	/**
	 * Called on SuggestionBox for City Code
	 * 
	 * @param event
	 * @return
	 */
	public List suggestionActionCityCode(Object event) {
		String cityCode = (String) event;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();

			cityCodelist = new PM_IL_CONTRACTOR_ACTION_VALIDATION()
					.prepareCityCodeList(connection, cityCode, cityCodelist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cityCodelist;
	}

	/**
	 * Called on City SuggestionBox Column to display description to a code
	 * 
	 * @param event
	 */
	public void getCityCodeDesc(ActionEvent event) {
		// COMP_UI_M_CONT_MAR_STATUS_DESC.setSubmittedValue(null);
		// COMP_CONT_CITY_CODE.setSubmittedValue(null);
		if (COMP_CONT_CITY_CODE.getSubmittedValue() != null) {
			String cityCode = (String) COMP_CONT_CITY_CODE.getSubmittedValue();
			System.out.println("city Code ::" + cityCode);
			String cityDesc = new PM_IL_CONTRACTOR_ACTION_VALIDATION()
					.getCityDescforCode(cityCode, cityCodelist);
			System.out.println("CITY CODE DESC :" + cityDesc);
			// COMP_UI_M_CONT_MAR_STATUS_DESC.setSubmittedValue(stateDesc);
			// COMP_UI_M_BUT_CITY_CODE
			COMP_UI_M_CONT_CITY_CODE_DESC.setSubmittedValue(cityDesc);
			PM_IL_CONTRACTOR_BEAN.setCONT_CITY(cityDesc);
		}
	}

	/**
	 * Called on SuggestionBox for Religion Code
	 * 
	 * @param event
	 * @return
	 */
	public List suggestionActionRelegionCode(Object event) {
		String religionCode = (String) event;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();

			religionCodeList = new PM_IL_CONTRACTOR_ACTION_VALIDATION()
					.prepareRelegionCodeList(connection, religionCode,
							religionCodeList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return religionCodeList;
	}

	/**
	 * Called on Religion SuggestionBox Column to display description to a code
	 * 
	 * @param event
	 */
	public void getRelegionCodeDesc(ActionEvent event) {
		COMP_UI_M_CONT_RELIGION_DESC.setSubmittedValue(null);
		if (COMP_CONT_RELIGION.getSubmittedValue() != null) {
			String relegionCode = (String) COMP_CONT_RELIGION
					.getSubmittedValue();
			System.out.println("Relegion Code ::" + relegionCode);
			String relegionDesc = new PM_IL_CONTRACTOR_ACTION_VALIDATION()
					.getRelegionDescforCode(relegionCode, religionCodeList);
			COMP_UI_M_CONT_RELIGION_DESC.setSubmittedValue(relegionDesc);
			PM_IL_CONTRACTOR_BEAN.setUI_M_CONT_RELIGION_DESC(relegionDesc);
		}
	}

	/**
	 * Called on SuggestionBox for Race Code
	 * 
	 * @param event
	 * @return
	 */
	public List suggestionActionRaceCode(Object event) {
		String raceCode = (String) event;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();

			raceCodeList = new PM_IL_CONTRACTOR_ACTION_VALIDATION()
					.prepareRaceCodeList(connection, raceCode, raceCodeList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return raceCodeList;
	}

	/**
	 * Called on Race SuggestionBox Column to display description to a code
	 * 
	 * @param event
	 */
	public void getRaceCodeDesc(ActionEvent event) {
		COMP_UI_M_CONT_RACE_DESC.setSubmittedValue(null);
		if (COMP_CONT_RACE.getSubmittedValue() != null) {
			String raceCode = (String) COMP_CONT_RACE.getSubmittedValue();
			String raceDesc = new PM_IL_CONTRACTOR_ACTION_VALIDATION()
					.getRaceDescforCode(raceCode, raceCodeList);
			COMP_UI_M_CONT_RACE_DESC.setSubmittedValue(raceDesc);
			PM_IL_CONTRACTOR_BEAN.setUI_M_CONT_RACE_DESC(raceDesc);
		}
	}

	/**
	 * Called on SuggestionBox for Country Code
	 * 
	 * @param event
	 * @return
	 */
	public List suggestionActionCountryCode(Object event) {
		String countryCode = (String) event;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();

			countryCodeList = new PM_IL_CONTRACTOR_ACTION_VALIDATION()
					.prepareCountryCodeList(connection, countryCode,
							countryCodeList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return countryCodeList;
	}

	/**
	 * Called on Country SuggestionBox Column to display description to a code
	 * 
	 * @param event
	 */
	public void getCountryCodeDesc(ActionEvent event) {
		COMP_CONT_COUNTRY.setSubmittedValue(null);
		if (COMP_CONT_COUNT_CODE.getSubmittedValue() != null) {
			String countryCode = (String) COMP_CONT_COUNT_CODE
					.getSubmittedValue();
			String countryDesc = new PM_IL_CONTRACTOR_ACTION_VALIDATION()
					.getCountryDescforCode(countryCode, countryCodeList);
			COMP_CONT_COUNTRY.setSubmittedValue(countryDesc);
			PM_IL_CONTRACTOR_BEAN.setCONT_COUNTRY(countryDesc);
		}
	}

	/**
	 * Called on SuggestionBox for Receipt Bank Code
	 * 
	 * @param event
	 * @return
	 */
	public List suggestionActionReceiptBankCode(Object event) {
		String receiptBankCode = (String) event;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();

			receiptBankCodeList = new PM_IL_CONTRACTOR_ACTION_VALIDATION()
					.prepareReceiptBankCodeList(connection, receiptBankCode,
							receiptBankCodeList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return receiptBankCodeList;
	}

	/**
	 * Called on Receipt Bank SuggestionBox Column to display description to a
	 * code
	 * 
	 * @param event
	 */
	public void getReceiptBankCodeDesc(ActionEvent event) {
		COMP_UI_M_CONT_AD_BANK_NAME.setSubmittedValue(null);
		if (COMP_CONT_AD_BANK_CODE.getSubmittedValue() != null) {
			String receiptBankCode = (String) COMP_CONT_AD_BANK_CODE
					.getSubmittedValue();
			getPM_IL_CONTRACTOR_BEAN().setCONT_AD_BANK_CODE(receiptBankCode);
			String receiptBankDesc = new PM_IL_CONTRACTOR_ACTION_VALIDATION()
					.getReceiptBankDescforCode(receiptBankCode,
							receiptBankCodeList);
			getPM_IL_CONTRACTOR_BEAN().setUI_M_CONT_AD_BANK_NAME(
					receiptBankDesc);
			COMP_UI_M_CONT_AD_BANK_NAME.setSubmittedValue(receiptBankDesc);
		}
	}

	/**
	 * Called on SuggestionBox for Nationality Code
	 * 
	 * @param event
	 * @return
	 */
	public List suggestionActionNationalityCode(Object event) {
		String nationalityCode = (String) event;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			nationalityCodeList = new PM_IL_CONTRACTOR_ACTION_VALIDATION()
					.prepareNationalityCodeList(connection, nationalityCode,
							nationalityCodeList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nationalityCodeList;
	}

	/**
	 * Called on Nationality SuggestionBox Column to display description to a
	 * code
	 * 
	 * @param event
	 */
	public void getNationalityCodeDesc(ActionEvent event) {
		COMP_UI_M_CONT_NATIONALITY_CODE_DESC.setSubmittedValue(null);
		if (COMP_CONT_NATIONALITY_CODE.getSubmittedValue() != null) {
			String nationalityCode = (String) COMP_CONT_NATIONALITY_CODE
					.getSubmittedValue();
			String nationalityDesc = new PM_IL_CONTRACTOR_ACTION_VALIDATION()
					.getNationalityDescforCode(nationalityCode,
							nationalityCodeList);
			COMP_UI_M_CONT_NATIONALITY_CODE_DESC
					.setSubmittedValue(nationalityDesc);
			PM_IL_CONTRACTOR_BEAN
					.setUI_M_CONT_NATIONALITY_CODE_DESC(nationalityDesc);
		}
	}

	public ArrayList<SelectItem> selectValueForComboBox(String formName,
			String blackName, String filedName) {
		// ConnectionAgent agent = new ConnectionAgent();

		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		ArrayList<SelectItem> drpDwn = null;
		String queryString = null;
		Object[] object = { formName, blackName, filedName };

		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			queryString = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_EMPLOYER_YN;

			resultSet = handler.executeSelectStatement(queryString, connection,
					object);
			drpDwn = new ArrayList<SelectItem>();
			while (resultSet.next()) {
				SelectItem selectItem = new SelectItem();
				selectItem.setValue(resultSet.getString(1));
				selectItem.setLabel(resultSet.getString(2));
				drpDwn.add(selectItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return drpDwn;
	}

	/**
	 * Block Level Pre-Insert Trigger Called Before Execute Insert
	 * 
	 * @throws Exception
	 */
	public void pilm016_apac_pm_il_contractor_pre_insert() throws Exception {

		PM_IL_CONTRACTOR_ACTION_VALIDATION validation = new PM_IL_CONTRACTOR_ACTION_VALIDATION();
		Connection connection = null;
		CommonUtils commonUtils = new CommonUtils();
		try {
			connection = CommonUtils.getConnection();
			String M_CODE_DESC = null;
			Integer M_IND_REQ = -1;
			ArrayList indReqList = P_VAL_SYSTEM
					.P_VAL_SYSTEM(
							connection,
							PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_CST_INDREQ,
							PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_CST_INDREQ,
							PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG);

			M_CODE_DESC = indReqList.get(0).toString();
			M_IND_REQ = Integer.parseInt(indReqList.get(1).toString());

			if (M_IND_REQ == 1) {
				if (PM_IL_CONTRACTOR_BEAN.getCONT_REF_ID1() == null
						&& PM_IL_CONTRACTOR_BEAN.getCONT_REF_ID2() == null) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91152"));
				}
			}

			if (PM_IL_CONTRACTOR_BEAN.getCONT_AD_BANK_CODE() != null) {
				if (PM_IL_CONTRACTOR_BEAN.getCONT_AD_ACC_NO() == null) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91375"));
				}
			}

			PM_IL_CONTRACTOR_BEAN.setCONT_CR_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
			PM_IL_CONTRACTOR_BEAN.setCONT_CR_DT(commonUtils.getCurrentDate());
			PM_IL_CONTRACTOR_BEAN
					.setCONT_DFLT_YN(PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG);
			PM_IL_CONTRACTOR_BEAN
					.setCONT_FRZ_FLAG(PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG);
			if (PM_IL_CONTRACTOR_BEAN.getCONT_CODE() != null) {
				validation.uniqueCode(PM_IL_CONTRACTOR_BEAN);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * PRE UPDATE Trigger
	 * 
	 * @throws SQLException
	 * @throws Exception
	 */
	public void pilm016_apac_pm_il_contractor_pre_update() throws Exception {
		try {
			if (PM_IL_CONTRACTOR_BEAN.getCONT_AD_BANK_CODE() != null) {
				if (PM_IL_CONTRACTOR_BEAN.getCONT_AD_ACC_NO() == null) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91375"));
				}
			}
			PM_IL_CONTRACTOR_BEAN.setCONT_UPD_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
			PM_IL_CONTRACTOR_BEAN.setCONT_UPD_DT(new CommonUtils()
					.getCurrentDate());
			PM_IL_CONTRACTOR_BEAN
					.setCONT_DFLT_YN(PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG);
			PM_IL_CONTRACTOR_BEAN.setCONT_FRZ_FLAG("N");
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Post-Query Trigger
	 * 
	 * @throws SQLException
	 * @throws Exception
	 */
	public void pilm016_apac_pm_il_contractor_post_query() throws Exception {

		String bankName = null;
		PM_IL_CONTRACTOR_ACTION_VALIDATION validation = new PM_IL_CONTRACTOR_ACTION_VALIDATION();
		Connection connection = null;
		String M_VALUE = null;

		try {
			connection = CommonUtils.getConnection();
			if (PM_IL_CONTRACTOR_BEAN.getCONT_CATG_CODE() != null) {
				ArrayList categoryList = P_VAL_SYSTEM
						.P_VAL_SYSTEM(
								connection,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_REF_ID1_TYPE,
								PM_IL_CONTRACTOR_BEAN.getCONT_CATG_CODE(),
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG);
				if (categoryList != null || !categoryList.isEmpty()) {
					PM_IL_CONTRACTOR_BEAN
							.setUI_M_CONT_CATG_CODE_DESC(categoryList.get(0)
									.toString());
				}
			}

			if (PM_IL_CONTRACTOR_BEAN.getCONT_MAR_STATUS() != null) {
				ArrayList maritialStatusList = P_VAL_SYSTEM
						.P_VAL_SYSTEM(
								connection,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_REF_ID1_TYPE1,
								PM_IL_CONTRACTOR_BEAN.getCONT_MAR_STATUS(),
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG);

				PM_IL_CONTRACTOR_BEAN
						.setUI_M_CONT_MAR_STATUS_DESC((String) maritialStatusList
								.get(0));
			}

			if (PM_IL_CONTRACTOR_BEAN.getCONT_NATIONALITY_CODE() != null) {
				String nationalityDesc = P_VAL_CODES
						.P_VAL_CODES(
								connection,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_P_VAL_CODES_TYPE,
								PM_IL_CONTRACTOR_BEAN
										.getCONT_NATIONALITY_CODE(),
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG);
				PM_IL_CONTRACTOR_BEAN
						.setUI_M_CONT_NATIONALITY_CODE_DESC(nationalityDesc);
			}

			if (PM_IL_CONTRACTOR_BEAN.getCONT_RELIGION() != null) {
				String relegionDesc = P_VAL_CODES
						.P_VAL_CODES(
								connection,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_P_VAL_CODES_TYPE1,
								PM_IL_CONTRACTOR_BEAN.getCONT_RELIGION(),
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG);
				PM_IL_CONTRACTOR_BEAN.setUI_M_CONT_RELIGION_DESC(relegionDesc);
			}

			if (PM_IL_CONTRACTOR_BEAN.getCONT_RACE() != null) {

				String raceDesc = P_VAL_CODES
						.P_VAL_CODES(
								connection,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_P_VAL_CODES_TYPE2,
								PM_IL_CONTRACTOR_BEAN.getCONT_RACE(),
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG);
				PM_IL_CONTRACTOR_BEAN.setUI_M_CONT_RACE_DESC(raceDesc);

			}

			if (PM_IL_CONTRACTOR_BEAN.getCONT_AD_BANK_CODE() != null) {
				bankName = validation.loadBankName(connection,
						PM_IL_CONTRACTOR_BEAN.getCONT_AD_BANK_CODE());
				PM_IL_CONTRACTOR_BEAN.setUI_M_CONT_AD_BANK_NAME(bankName);

			}

			if (PM_IL_CONTRACTOR_BEAN.getCONT_CITY_CODE() != null) {
				String cityDesc = P_VAL_CODES
						.P_VAL_CODES(
								connection,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_P_VAL_CODES_TYPE4,
								PM_IL_CONTRACTOR_BEAN.getCONT_CITY_CODE(),
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.E_Flag);

				PM_IL_CONTRACTOR_BEAN.setCONT_CITY(cityDesc);

			}

			if (PM_IL_CONTRACTOR_BEAN.getCONT_STATE_CODE() != null) {
				String stateDesc = P_VAL_CODES
						.P_VAL_CODES(
								connection,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_P_VAL_CODES_TYPE3,
								PM_IL_CONTRACTOR_BEAN.getCONT_STATE_CODE(),
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.E_Flag);

				PM_IL_CONTRACTOR_BEAN.setCONT_STATE(stateDesc);
			}

			if (PM_IL_CONTRACTOR_BEAN.getCONT_COUNT_CODE() != null) {
				String countryDesc = P_VAL_CODES
						.P_VAL_CODES(
								connection,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_P_VAL_CODES_TYPE5,
								PM_IL_CONTRACTOR_BEAN.getCONT_COUNT_CODE(),
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG,
								PILM016_PM_IL_CONTRACTOR_CONSTANTS.E_Flag);

				PM_IL_CONTRACTOR_BEAN.setCONT_COUNTRY(countryDesc);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	/**
	 * When Create Record
	 * 
	 * @throws SQLException
	 * @throws Exception
	 */
	public void pilm016_apac_pm_il_contractor_when_create_record()
			throws SQLException, Exception {

		PreparedStatement selectRelgionPCCodePreparedStatement = null;
		PreparedStatement selectRacePCCodePreparedStatement = null;
		PreparedStatement selectNationalityPCCodePreparedStatement = null;
		ResultSet resultSetRelgionCode = null;
		ResultSet resultSetRaceCode = null;
		ResultSet resultSetNationalityCode = null;
		String M_PC_CODE = null;
		String relegionDesc = null;
		String raceDesc = null;
		String nationalityDesc = null;
		String bankName = null;

		PM_IL_CONTRACTOR_ACTION_VALIDATION validation = new PM_IL_CONTRACTOR_ACTION_VALIDATION();
		Connection connection = null;

		try {
			connection = CommonUtils.getConnection();

			selectRelgionPCCodePreparedStatement = connection
					.prepareStatement(PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_WHEN_CREATE_RECORD_SELECT_PC_CODE_FOR_RELIGION);
			selectRacePCCodePreparedStatement = connection
					.prepareStatement(PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_WHEN_CREATE_RECORD_SELECT_PC_CODE_FOR_RACE);
			selectNationalityPCCodePreparedStatement = connection
					.prepareStatement(PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_WHEN_CREATE_RECORD_SELECT_PC_CODE_FOR_NATIONALITY);

			resultSetRelgionCode = selectRelgionPCCodePreparedStatement
					.executeQuery();
			if (resultSetRelgionCode.next()) {
				M_PC_CODE = resultSetRelgionCode.getString(1);
			}

			PM_IL_CONTRACTOR_BEAN.setCONT_RELIGION(M_PC_CODE);

			relegionDesc = P_VAL_CODES
					.P_VAL_CODES(
							connection,
							PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_P_VAL_CODES_TYPE1,
							PM_IL_CONTRACTOR_BEAN.getCONT_RELIGION(),
							PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG,
							PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG);

			PM_IL_CONTRACTOR_BEAN.setUI_M_CONT_RELIGION_DESC(relegionDesc);

			M_PC_CODE = null;

			resultSetNationalityCode = selectNationalityPCCodePreparedStatement
					.executeQuery();
			if (resultSetNationalityCode.next()) {
				M_PC_CODE = resultSetNationalityCode.getString(1);
			}

			PM_IL_CONTRACTOR_BEAN.setCONT_NATIONALITY_CODE(M_PC_CODE);

			nationalityDesc = P_VAL_CODES
					.P_VAL_CODES(
							connection,
							PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_P_VAL_CODES_TYPE,
							PM_IL_CONTRACTOR_BEAN.getCONT_NATIONALITY_CODE(),
							PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG,
							PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG);

			PM_IL_CONTRACTOR_BEAN
					.setUI_M_CONT_NATIONALITY_CODE_DESC(nationalityDesc);

			M_PC_CODE = null;

			resultSetRaceCode = selectRacePCCodePreparedStatement
					.executeQuery();
			if (resultSetRaceCode.next()) {
				M_PC_CODE = resultSetRaceCode.getString(1);
			}
			PM_IL_CONTRACTOR_BEAN.setCONT_RACE(M_PC_CODE);
			raceDesc = P_VAL_CODES
					.P_VAL_CODES(
							connection,
							PILM016_PM_IL_CONTRACTOR_CONSTANTS.PM_IL_CONTRACTOR_P_VAL_CODES_TYPE2,
							PM_IL_CONTRACTOR_BEAN.getCONT_RACE(),
							PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG,
							PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG);

			PM_IL_CONTRACTOR_BEAN.setUI_M_CONT_RACE_DESC(raceDesc);

			PM_IL_CONTRACTOR_BEAN
					.setCONT_EMPLOYER_YN(PILM016_PM_IL_CONTRACTOR_CONSTANTS.EMPLOYEER_YN_N);
			PM_IL_CONTRACTOR_BEAN
					.setCONT_PREFERRED_LANG(PILM016_PM_IL_CONTRACTOR_CONSTANTS.PREFERRED_LANG_E);

			bankName = validation.loadBankName(connection,
					PM_IL_CONTRACTOR_BEAN.getCONT_AD_BANK_CODE());
			PM_IL_CONTRACTOR_BEAN.setUI_M_CONT_AD_BANK_NAME(bankName);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		finally {
			try {

				CommonUtils.closeCursor(resultSetRelgionCode);
				CommonUtils.closeCursor(resultSetRaceCode);
				CommonUtils.closeCursor(resultSetNationalityCode);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Pre-Form Trigger
	 */
	public void pilm016_apac_pre_form() throws ValidatorException {
		Connection connection = null;

		ResultSet resultSetForNumGenYNandContractor = null;
		ResultSet resultSetForNGSDisableYN = null;
		ResultSet resultSetForQuery = null;

		PM_IL_CONTRACTOR_ACTION contractorActionBean = (PM_IL_CONTRACTOR_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PILM016_APAC_PM_IL_CONTRACTOR_ACTION");

		if (getCOMP_CONT_CODE() == null) {
			setCOMP_CONT_CODE(new HtmlInputText());
		}
		// [BugId:Fix Shankar Bodduluri 19-03-09 divisoon code form session
		String divCode = CommonUtils.getControlBean().getM_DIVN_CODE();
		try {
			connection = CommonUtils.getConnection();

			CRUDHandler handler = new CRUDHandler();
			String queryForNumGenYNandContractor = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_SELECT_PS_VALUE;
			Object[] object = {};

			String queryForNGSDisableYN = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_SELECT_X_AND_DISABLE_YN;
			Object[] objects1 = { divCode };

			String query = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_SELECT_X_FROM_PP_SYSTEM;
			Object[] objects2 = { divCode };

			String M_FILE = null;
			String M_TITLE = null;
			String M_CODE_DESC = null;
			int M_PS_VALUE = -1;
			String M_PS_CODE = null;
			String M_TEMP = null;
			String M_TEMP_1 = null;
			String M_NGS_DISABLE_YN = null;

			// createControlBean();
			// setControlBeanValues();
			FacesContext facesContext = FacesContext.getCurrentInstance();
			Map<String, Object> session = facesContext.getExternalContext()
					.getSessionMap();
			// session.put("GLOBAL.M_PRIVILEGE", "YYY");
			session.put("GLOBAL.M_FAILURE", "FALSE");
			// session.put("GLOBAL.M_USER_ID", "RAGHU");
			/*
			 * session.put("GLOBAL.M_NAME", "COMPANY
			 * NAME..................PROGRAM NAME");
			 */
			// session.put("GLOBAL.M_LANG_CODE", "ENG");
			// session.put("GLOBAL.M_PARA_1", " ");
			// session.put("M_FOR_LANG_CODE", "ARBR2");
			// session.put("GLOBAL.M_DFLT_VALUES", "00101 01 ");
			session.put("GLOBAL.M_MODULE_NAME", "PM_IL_CONTRACTOR");

			if (resultSetForNumGenYNandContractor != null) {
				resultSetForNumGenYNandContractor.close();
			}
			resultSetForNumGenYNandContractor = handler.executeSelectStatement(
					queryForNumGenYNandContractor, connection, object);

			if (resultSetForNumGenYNandContractor.next()) {
				M_PS_VALUE = Integer.parseInt(resultSetForNumGenYNandContractor
						.getString(1));

			}
			resultSetForNumGenYNandContractor.close();
			if (MigratingFunctions.nvl(M_PS_VALUE, 2) == 2) {
				System.out.println("**** VALUE *****" + M_PS_VALUE);
				getCOMP_CONT_CODE().setDisabled(false);
				getCOMP_CONT_CODE().setRequired(true);
			} else if (MigratingFunctions.nvl(M_PS_VALUE, 2) == 1) {
				resultSetForQuery = handler.executeSelectStatement(query,
						connection, objects2);
				if (resultSetForQuery.next()) {
					M_TEMP_1 = resultSetForQuery.getString(1);
				}
				resultSetForQuery.close();
				if (M_TEMP_1 == null) {
					System.out
							.println("Number Generation Code not defined for the Contractor!");
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91176"));
				} else if (MigratingFunctions.nvl(M_TEMP_1,
						PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG).equals(
						PILM016_PM_IL_CONTRACTOR_CONSTANTS.X_FLAG)) {
					resultSetForNGSDisableYN = handler.executeSelectStatement(
							queryForNGSDisableYN, connection, objects1);
					if (resultSetForNGSDisableYN.next()) {
						M_TEMP = resultSetForNGSDisableYN.getString(1);
						M_NGS_DISABLE_YN = resultSetForNGSDisableYN
								.getString(2);
					}
					resultSetForNGSDisableYN.close();
					if (MigratingFunctions.nvl(M_TEMP,
							PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG).equals(
							PILM016_PM_IL_CONTRACTOR_CONSTANTS.X_FLAG)) {
						if (!MigratingFunctions
								.nvl(
										M_NGS_DISABLE_YN,
										PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG)
								.equals(
										PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG)) {
							getCOMP_CONT_CODE().setDisabled(false);
							getCOMP_CONT_CODE().setRequired(true);
						} else {
							getCOMP_CONT_CODE().setDisabled(true);
						}
					} else {
						System.out
								.println("Number Generation Code not defined in the setup!");
						throw new ValidatorException(Messages.getMessage(
								PELConstants.pelErrorMessagePath, "91177"));
					}
				}
			} else {
				System.out
						.println("Number Generation Code not defined for the Contractor!");
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "91176"));
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				CommonUtils.closeCursor(resultSetForNGSDisableYN);
				CommonUtils.closeCursor(resultSetForNumGenYNandContractor);
				CommonUtils.closeCursor(resultSetForQuery);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/*
	 * public void createControlBean() { FacesContext context =
	 * FacesContext.getCurrentInstance(); ControlBean bean = new ControlBean();
	 * Map<String, Object> session = context.getExternalContext()
	 * .getSessionMap(); session = context.getExternalContext().getSessionMap();
	 * session.put("ctrlbean", bean); }
	 * 
	 * public void setControlBeanValues() { new
	 * CommonUtils().getControlBean().setM_USER_ID("LIFEALL"); }
	 * 
	 * public ControlBean getCtrlBean() { FacesContext context =
	 * FacesContext.getCurrentInstance(); Map<String, Object> session =
	 * context.getExternalContext() .getSessionMap(); return (ControlBean)
	 * session.get("ctrlbean"); }
	 */

	public HtmlInputText getCOMP_UI_M_CONT_CITY_CODE_DESC() {
		return COMP_UI_M_CONT_CITY_CODE_DESC;
	}

	public void setCOMP_UI_M_CONT_CITY_CODE_DESC(
			HtmlInputText comp_ui_m_cont_city_desc) {
		COMP_UI_M_CONT_CITY_CODE_DESC = comp_ui_m_cont_city_desc;
	}

	public HtmlInputText getCOMP_UI_M_CONT_STATE_CODE_DESC() {
		return COMP_UI_M_CONT_STATE_CODE_DESC;
	}

	public void setCOMP_UI_M_CONT_STATE_CODE_DESC(
			HtmlInputText comp_ui_m_cont_state_code_desc) {
		COMP_UI_M_CONT_STATE_CODE_DESC = comp_ui_m_cont_state_code_desc;
	}

	/*
	 * public void loadingBaseValues(PhaseEvent e ) { FacesContext fc =
	 * FacesContext.getCurrentInstance(); System.out.println("ENTERE PHASE
	 * EVENT");
	 * 
	 * Map<String, Object> session = fc.getExternalContext().getSessionMap();
	 * if(session.get("PM_IL_CONTRACTOR_ACTION_FORM") == null) { try {
	 * System.out.println("BEFORE PHASE EVENT");
	 * COMP_CONT_CODE.setDisabled(true); pilm016_apac_pre_form();
	 * System.out.println("AFTER PHASE EVENT"); } catch (SQLException e1) { //
	 * TODO Auto-generated catch block e1.printStackTrace(); } catch (Exception
	 * e1) { // TODO Auto-generated catch block e1.printStackTrace(); }
	 * session.put("PM_IL_CONTRACTOR_ACTION_FORM","true"); } }
	 */
	public void when_new_form_instance() throws ValidatorException {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		int M_PS_VALUE = -1;
		String M_TEMP = null;
		String M_NGS_DISABLE_YN = null;

		if (getCOMP_CONT_CODE() == null) {
			setCOMP_CONT_CODE(new HtmlInputText());
		}
		try {
			connection = CommonUtils.getConnection();

			String sqlQuery1 = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_SELECT_PS_VALUE;
			Object[] objects = {};
			System.out.println("sqlQuery1 :" + sqlQuery1);
			resultSet1 = handler.executeSelectStatement(sqlQuery1, connection,
					objects);
			if (resultSet1.next()) {
				M_PS_VALUE = resultSet1.getInt(1);
				System.out.println("resultSet1 :" + resultSet1.getString(1));
				System.out.println("M_PS_VALUE :" + M_PS_VALUE);
			}

			if (M_PS_VALUE != -1) {
				if (MigratingFunctions.nvl(M_PS_VALUE, 2) == 2) {
					getCOMP_CONT_CODE().setDisabled(false);
					getCOMP_CONT_CODE().setRequired(true);
				} else if (MigratingFunctions.nvl(M_PS_VALUE, 2) == 1) {

					String sqlQuery2 = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_WHEN_NEW_FORM_INSTANCE_SELECT_X_FOR_PS_TYPE;
					Object[] objects1 = {};
					resultSet2 = handler.executeSelectStatement(sqlQuery2,
							connection, objects1);
					if (resultSet2.next()) {
						M_TEMP = resultSet2.getString(1);
					}
					if (M_TEMP == null) {
						throw new ValidatorException(Messages.getMessage(
								PELConstants.pelErrorMessagePath, "91176"));
					} else if (MigratingFunctions.nvl(M_TEMP,
							PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG).equals(
							PILM016_PM_IL_CONTRACTOR_CONSTANTS.X_FLAG)) {
						String sqlQuery3 = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS.PM_IL_CONTRACTOR_WHEN_NEW_FORM_INSTANCE_SELECT_DETAILS_FROM_NUM_SETUP;
						Object[] objects2 = {};
						resultSet3 = handler.executeSelectStatement(sqlQuery3,
								connection, objects2);
						if (resultSet3.next()) {
							M_TEMP = resultSet3.getString(1);
							M_NGS_DISABLE_YN = resultSet3.getString(2);
						}
						if (MigratingFunctions
								.nvl(
										M_TEMP,
										PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG)
								.equals(
										PILM016_PM_IL_CONTRACTOR_CONSTANTS.X_FLAG)) {
							if (!MigratingFunctions
									.nvl(
											M_NGS_DISABLE_YN,
											PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG)
									.equals(
											PILM016_PM_IL_CONTRACTOR_CONSTANTS.N_FLAG)) {
								getCOMP_CONT_CODE().setDisabled(false);
								getCOMP_CONT_CODE().setRequired(true);
							} else {

								getCOMP_CONT_CODE().setDisabled(true);
							}
						} else {
							throw new ValidatorException(Messages.getMessage(
									PELConstants.pelErrorMessagePath, "91177"));
						}

					}
				} else {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91176"));
				}
			}

		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void fireFieldValidationContCode(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void fetchMasterDetails() {
		/*Added by saritha on 16-05-2017 for ssp call id ZBILQC-1720645*/ 
		PM_IL_CONTRACTOR_ACTION contractorActionBean = (PM_IL_CONTRACTOR_ACTION) new CommonUtils()
		.getMappedBeanFromSession("PILM016_APAC_PM_IL_CONTRACTOR_ACTION");
		/*End*/
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			String selectQuery = "SELECT PM_IL_CONTRACTOR.* ,PM_IL_CONTRACTOR.ROWID FROM PM_IL_CONTRACTOR  WHERE ROWID = ?  ";
			String selectQuery1 = "SELECT PM_IL_CONTRACTOR.* ,PM_IL_CONTRACTOR.ROWID FROM PM_IL_CONTRACTOR  WHERE CONT_CODE = ?  ";
			String contCode = CommonUtils
					.getGlobalVariable("GLOBAL.M_CONT_CODE");
			if (contCode != null) {
				resultSet = handler.executeSelectStatement(selectQuery1,
						connection, new Object[] { contCode });
			} else if (PM_IL_CONTRACTOR_BEAN.getROWID() != null) {
				resultSet = handler.executeSelectStatement(selectQuery,
						connection, new Object[] { PM_IL_CONTRACTOR_BEAN
								.getROWID() });
			}
			while (resultSet.next()) {
				PM_IL_CONTRACTOR_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_IL_CONTRACTOR_BEAN.setCONT_CODE(resultSet
						.getString("CONT_CODE"));
				PM_IL_CONTRACTOR_BEAN.setCONT_NAME(resultSet
						.getString("CONT_NAME"));
				PM_IL_CONTRACTOR_BEAN.setCONT_ADDR1(resultSet
						.getString("CONT_ADDR1"));
				PM_IL_CONTRACTOR_BEAN.setCONT_ADDR2(resultSet
						.getString("CONT_ADDR2"));
				PM_IL_CONTRACTOR_BEAN.setCONT_ADDR3(resultSet
						.getString("CONT_ADDR3"));
				PM_IL_CONTRACTOR_BEAN.setCONT_CONTACT(resultSet
						.getString("CONT_CONTACT"));
				PM_IL_CONTRACTOR_BEAN.setCONT_PHONE(resultSet
						.getString("CONT_PHONE"));
				PM_IL_CONTRACTOR_BEAN.setCONT_FAX(resultSet
						.getString("CONT_FAX"));
				PM_IL_CONTRACTOR_BEAN.setCONT_REMARKS(resultSet
						.getString("CONT_REMARKS"));
				PM_IL_CONTRACTOR_BEAN.setCONT_DFLT_YN(resultSet
						.getString("CONT_DFLT_YN"));
				PM_IL_CONTRACTOR_BEAN.setCONT_CUST_CODE(resultSet
						.getString("CONT_CUST_CODE"));
				PM_IL_CONTRACTOR_BEAN.setCONT_FRZ_FLAG(resultSet
						.getString("CONT_FRZ_FLAG"));
				PM_IL_CONTRACTOR_BEAN.setCONT_BL_NAME(resultSet
						.getString("CONT_BL_NAME"));
				PM_IL_CONTRACTOR_BEAN.setCONT_BL_ADDR1(resultSet
						.getString("CONT_BL_ADDR1"));
				PM_IL_CONTRACTOR_BEAN.setCONT_BL_ADDR2(resultSet
						.getString("CONT_BL_ADDR2"));
				PM_IL_CONTRACTOR_BEAN.setCONT_BL_ADDR3(resultSet
						.getString("CONT_BL_ADDR3"));
				PM_IL_CONTRACTOR_BEAN.setCONT_BL_CONTACT(resultSet
						.getString("CONT_BL_CONTACT"));
				PM_IL_CONTRACTOR_BEAN.setCONT_CR_DT(resultSet
						.getDate("CONT_CR_DT"));
				PM_IL_CONTRACTOR_BEAN.setCONT_CR_UID(resultSet
						.getString("CONT_CR_UID"));
				PM_IL_CONTRACTOR_BEAN.setCONT_UPD_DT(resultSet
						.getDate("CONT_UPD_DT"));
				PM_IL_CONTRACTOR_BEAN.setCONT_UPD_UID(resultSet
						.getString("CONT_UPD_UID"));
				PM_IL_CONTRACTOR_BEAN.setCONT_EMPLOYER_YN(resultSet
						.getString("CONT_EMPLOYER_YN"));
				PM_IL_CONTRACTOR_BEAN.setCONT_LC_PROP_DEP_AMT(resultSet
						.getDouble("CONT_LC_PROP_DEP_AMT"));
				PM_IL_CONTRACTOR_BEAN.setCONT_LC_PROP_UTIL_AMT(resultSet
						.getDouble("CONT_LC_PROP_UTIL_AMT"));
				PM_IL_CONTRACTOR_BEAN.setCONT_LC_POL_DEP_AMT(resultSet
						.getDouble("CONT_LC_POL_DEP_AMT"));
				PM_IL_CONTRACTOR_BEAN.setCONT_LC_POL_UTIL_AMT(resultSet
						.getDouble("CONT_LC_POL_UTIL_AMT"));
				PM_IL_CONTRACTOR_BEAN.setCONT_EFF_FM_DT(resultSet
						.getDate("CONT_EFF_FM_DT"));
				PM_IL_CONTRACTOR_BEAN.setCONT_EFF_TO_DT(resultSet
						.getDate("CONT_EFF_TO_DT"));
				PM_IL_CONTRACTOR_BEAN.setCONT_REF_NO(resultSet
						.getString("CONT_REF_NO"));
				PM_IL_CONTRACTOR_BEAN.setCONT_REF_ID1(resultSet
						.getString("CONT_REF_ID1"));
				PM_IL_CONTRACTOR_BEAN.setCONT_REF_ID2(resultSet
						.getString("CONT_REF_ID2"));
				PM_IL_CONTRACTOR_BEAN.setCONT_TEL_AREA_CODE(resultSet
						.getString("CONT_TEL_AREA_CODE"));
				PM_IL_CONTRACTOR_BEAN.setCONT_MOBILE_NO(resultSet
						.getString("CONT_MOBILE_NO"));
				PM_IL_CONTRACTOR_BEAN.setCONT_FAX_AREA_CODE(resultSet
						.getString("CONT_FAX_AREA_CODE"));
				PM_IL_CONTRACTOR_BEAN.setCONT_PREFERRED_LANG(resultSet
						.getString("CONT_PREFERRED_LANG"));
				PM_IL_CONTRACTOR_BEAN.setCONT_EMAIL_ID(resultSet
						.getString("CONT_EMAIL_ID"));
				PM_IL_CONTRACTOR_BEAN.setCONT_POSTAL_CODE(resultSet
						.getString("CONT_POSTAL_CODE"));
				PM_IL_CONTRACTOR_BEAN.setCONT_CITY(resultSet
						.getString("CONT_CITY"));
				PM_IL_CONTRACTOR_BEAN.setCONT_STATE(resultSet
						.getString("CONT_STATE"));
				PM_IL_CONTRACTOR_BEAN
						.setCONT_DOB(resultSet.getDate("CONT_DOB"));
				PM_IL_CONTRACTOR_BEAN.setCONT_BIRTH_CERT_NO(resultSet
						.getString("CONT_BIRTH_CERT_NO"));
				PM_IL_CONTRACTOR_BEAN.setCONT_CATG_CODE(resultSet
						.getString("CONT_CATG_CODE"));
				PM_IL_CONTRACTOR_BEAN.setCONT_MAR_STATUS(resultSet
						.getString("CONT_MAR_STATUS"));
				PM_IL_CONTRACTOR_BEAN.setCONT_NATIONALITY_CODE(resultSet
						.getString("CONT_NATIONALITY_CODE"));
				PM_IL_CONTRACTOR_BEAN.setCONT_RACE(resultSet
						.getString("CONT_RACE"));
				PM_IL_CONTRACTOR_BEAN.setCONT_RELIGION(resultSet
						.getString("CONT_RELIGION"));
				PM_IL_CONTRACTOR_BEAN.setCONT_AREA(resultSet
						.getString("CONT_AREA"));
				PM_IL_CONTRACTOR_BEAN.setCONT_REGION(resultSet
						.getString("CONT_REGION"));
				PM_IL_CONTRACTOR_BEAN.setCONT_AD_BANK_CODE(resultSet
						.getString("CONT_AD_BANK_CODE"));
				PM_IL_CONTRACTOR_BEAN.setCONT_AD_ACC_NO(resultSet
						.getString("CONT_AD_ACC_NO"));
				PM_IL_CONTRACTOR_BEAN.setCONT_CITY_CODE(resultSet
						.getString("CONT_CITY_CODE"));
				PM_IL_CONTRACTOR_BEAN.setCONT_STATE_CODE(resultSet
						.getString("CONT_STATE_CODE"));
				PM_IL_CONTRACTOR_BEAN.setCONT_COUNT_CODE(resultSet
						.getString("CONT_COUNT_CODE"));
				PM_IL_CONTRACTOR_BEAN.setCONT_COUNTRY(resultSet
						.getString("CONT_COUNTRY"));
				PM_IL_CONTRACTOR_BEAN.setCONT_PASS_NO(resultSet
						.getString("CONT_PASS_NO"));
				PM_IL_CONTRACTOR_BEAN.setCONT_MOB_AREA_CODE(resultSet
						.getString("CONT_MOB_AREA_CODE"));
				pilm016_apac_pm_il_contractor_post_query();

				/*Added by saritha on 16-05-2017 for ssp call id ZBILQC-1720645*/ 
				
				//Proposal Suspense Amt
				
				Double PROP_DEP_AMT = PM_IL_CONTRACTOR_BEAN.getCONT_LC_PROP_DEP_AMT();
				System.out.println("PROP_DEP_AMT------------->"+PROP_DEP_AMT);
				Double PROP_UTIL_AMT = PM_IL_CONTRACTOR_BEAN.getCONT_LC_PROP_UTIL_AMT();
				System.out.println("PROP_UTIL_AMT------------->"+PROP_UTIL_AMT);
				Double PROP_SUS_AMT = PROP_DEP_AMT - PROP_UTIL_AMT; 
				PM_IL_CONTRACTOR_BEAN.setCONT_LC_PROP_SUS_AMT(PROP_SUS_AMT);
				System.out.println("PROP_SUS_AMT                  "+ contractorActionBean.getPM_IL_CONTRACTOR_BEAN().getCONT_LC_PROP_SUS_AMT());
				contractorActionBean.getCOMP_CONT_LC_PROP_SUS_AMT().resetValue();
				
				//Policy Suspense Amt
				
				Double POL_DEP_AMT = PM_IL_CONTRACTOR_BEAN.getCONT_LC_POL_DEP_AMT();
				System.out.println("POL_DEP_AMT------------->"+POL_DEP_AMT);
				Double POL_UTIL_AMT = PM_IL_CONTRACTOR_BEAN.getCONT_LC_POL_UTIL_AMT();
				System.out.println("POL_UTIL_AMT------------->"+POL_UTIL_AMT);
				Double POL_SUS_AMT = POL_DEP_AMT - POL_UTIL_AMT; 
				PM_IL_CONTRACTOR_BEAN.setCONT_LC_POL_SUS_AMT(POL_SUS_AMT);
				System.out.println("POL_SUS_AMT                  "+ contractorActionBean.getPM_IL_CONTRACTOR_BEAN().getCONT_LC_POL_SUS_AMT());
				contractorActionBean.getCOMP_CONT_LC_POL_SUS_AMT().resetValue();
				
				/*End*/
				
				
			}

			resultSet.getStatement().close();
			resultSet.close();

		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	public String preBack() {
		return "PILM016_APAC_PM_IL_CONTRACTOR_SEARCH";
	}

	public HtmlOutputText getCOMP_CONT_CODE_ERROR() {
		return COMP_CONT_CODE_ERROR;
	}

	public void setCOMP_CONT_CODE_ERROR(HtmlOutputText comp_cont_code_error) {
		COMP_CONT_CODE_ERROR = comp_cont_code_error;
	}

	public HtmlOutputText getACCOUNT_NO_ERROR() {
		return ACCOUNT_NO_ERROR;
	}

	public void setACCOUNT_NO_ERROR(HtmlOutputText account_no_error) {
		ACCOUNT_NO_ERROR = account_no_error;
	}

	public HtmlOutputText getEFF_FM_DT_ERROR() {
		return EFF_FM_DT_ERROR;
	}

	public void setEFF_FM_DT_ERROR(HtmlOutputText eff_fm_dt_error) {
		EFF_FM_DT_ERROR = eff_fm_dt_error;
	}

	public HtmlOutputText getEFF_TO_DT_ERROR() {
		return EFF_TO_DT_ERROR;
	}

	public void setEFF_TO_DT_ERROR(HtmlOutputText eff_to_dt_error) {
		EFF_TO_DT_ERROR = eff_to_dt_error;
	}

	public HtmlOutputText getERROR_IC_NUMBER() {
		return ERROR_IC_NUMBER;
	}

	public void setERROR_IC_NUMBER(HtmlOutputText error_ic_number) {
		ERROR_IC_NUMBER = error_ic_number;
	}

	public void validateCONT_CITY_CODE(FacesContext context,
			UIComponent component, Object object) {
		try {
			String query = "SELECT  'X' FROM PM_CODES WHERE PC_TYPE = 'CITY' AND PC_CODE = ? ";
			Boolean flag = isValidateLovCode(query, new Object[] { object });
			if (flag == false) {
				throw new Exception("Code does not Exists.Please Re-enter");
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCONT_STATE_CODE(FacesContext context,
			UIComponent component, Object object) {
		try {
			String query = "SELECT  'X' FROM PM_CODES WHERE PC_TYPE = 'STATE' AND PC_CODE = ? ";
			Boolean flag = isValidateLovCode(query, new Object[] { object });
			if (flag == false) {
				throw new Exception("Code does not Exists.Please Re-enter");
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCONT_COUNTRY_CODE(FacesContext context,
			UIComponent component, Object object) {
		try {
			String query = "SELECT  'X' FROM PM_CODES WHERE PC_TYPE = 'COUNTRY' AND PC_CODE = ? ";
			Boolean flag = isValidateLovCode(query, new Object[] { object });
			if (flag == false) {
				throw new Exception("Code does not Exists.Please Re-enter");
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCONT_NATIONALITY_CODE(FacesContext context,
			UIComponent component, Object object) {
		try {
			String query = "SELECT  'X' FROM PM_CODES WHERE PC_TYPE = 'NATLITY' AND PC_CODE = ? ";
			Boolean flag = isValidateLovCode(query, new Object[] { object });
			if (flag == false) {
				throw new Exception("Code does not Exists.Please Re-enter");
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCONT_MARITAL_STAT_CODE(FacesContext context,
			UIComponent component, Object object) {
		try {
			String query = "SELECT 'X' FROM PP_SYSTEM WHERE PS_TYPE = 'MARI_STAT' AND PS_CODE = ?";
			Boolean flag = isValidateLovCode(query, new Object[] { object });
			if (flag == false) {
				throw new Exception("Code does not Exists.Please Re-enter");
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCONT_RELIGION_CODE(FacesContext context,
			UIComponent component, Object object) {
		try {
			String query = "SELECT  'X' FROM PM_CODES WHERE PC_TYPE = 'RELIGION' AND PC_CODE = ? ";
			Boolean flag = isValidateLovCode(query, new Object[] { object });
			if (flag == false) {
				throw new Exception("Code does not Exists.Please Re-enter");
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCONT_RACE_CODE(FacesContext context,
			UIComponent component, Object object) {
		try {
			String query = "SELECT  'X' FROM PM_CODES WHERE PC_TYPE = 'RACE' AND PC_CODE = ? ";
			Boolean flag = isValidateLovCode(query, new Object[] { object });
			if (flag == false) {
				throw new Exception("Code does not Exists.Please Re-enter");
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCONT_BANK_CODE(FacesContext context,
			UIComponent component, Object object) {
		try {
			String query = "SELECT 'X' FROM FM_BANK WHERE BANK_CODE = ? ";
			Boolean flag = isValidateLovCode(query, new Object[] { object });
			if (flag == false) {
				throw new Exception("Code does not Exists.Please Re-enter");
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCONT_CATEGORY_CODE(FacesContext context,
			UIComponent component, Object object) {
		try {
			String query = "SELECT PS_CODE,PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'CATG' AND PS_CODE = ?";
			Boolean flag = isValidateLovCode(query, new Object[] { object });
			if (flag == false) {
				throw new Exception("Code does not Exists.Please Re-enter");
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	// method to validate lov code by 55943 13-feb-2012.
	private Boolean isValidateLovCode(String qry, Object[] values) {
		Boolean exists = false;
		Connection conn = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			conn = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(qry, conn, values);
			if (resultSet.next()) {
				exists = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return exists;

	}

	public void onLoad(PhaseEvent event) {
		if (isBlockFlag()) {
			String form = CommonUtils.getGlobalVariable("CALLING_FORM");
			fetchMasterDetails();
			if(PM_IL_CONTRACTOR_BEAN.getROWID() != null){
				getBankdetails();
			}
			else{
				whenCreateRecord();
			}
			//Added to disable delete and save option
			if("PILT016A_APAC".equalsIgnoreCase(form)){
				COMP_BUT_DELETE.setRendered(false);
				COMP_BUT_SAVE.setRendered(false);
				COMP_BUT_SAVE2.setRendered(false);
				COMP_IMG_DEL.setRendered(false);
				COMP_IMG_SAVE.setRendered(false);
				COMP_IMG_SAVE2.setRendered(false);
				disableAllComponent(true);
			}
			

			
			/*Added by Janani on 03.04.2017 as part of factory testing feedback Customer Master - Validation point*/
			try {
				
				
				/* Added by Janani on 25.07.2017 for ZBILQC-1732979*/
				
				getCustType();
				
				/*End*/
				
				//getNationalityID();
				
				System.out.println("PM_IL_CONTRACTOR_BEAN in assured master above                     :"+PM_IL_CONTRACTOR_BEAN.getROWID());
								
								if(PM_IL_CONTRACTOR_BEAN.getROWID() == null)
								{
									
									System.out.println("inside assured dtls bean                      :");
									
									
									/*added by raja on 13-04-2017 for nationality default*/
									PM_IL_CONTRACTOR_BEAN.setCONT_NATIONALITY_CODE(CommonUtils.getGlobalVariable("GLOBAL.M_NATIONLITY_CODE"));
									
									System.out.println("Nationality in assured dtls screen  ==> "+CommonUtils.getGlobalVariable("GLOBAL.M_NATIONLITY_CODE"));
									
									PM_IL_CONTRACTOR_BEAN.setUI_M_CONT_NATIONALITY_CODE_DESC(CommonUtils.nationalityDisc(
											PM_IL_CONTRACTOR_BEAN.getCONT_NATIONALITY_CODE().toString()));
									
									
									System.out.println("Nationality desc in assured dtls screen  ==> "+PM_IL_CONTRACTOR_BEAN.getUI_M_CONT_NATIONALITY_CODE_DESC());
									
									/*end*/
								}
								
								
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*End*/
			
			setBlockFlag(false);
		}
	}
	
	public void whenCreateRecord(){
		PM_IL_CONTRACTOR_BEAN.setCONT_PREFERRED_LANG("E");
	}

	public HtmlInputText getCOMP_CONT_MOB_AREA_CODE() {
		return COMP_CONT_MOB_AREA_CODE;
	}

	public void setCOMP_CONT_MOB_AREA_CODE(HtmlInputText comp_cont_mob_area_code) {
		COMP_CONT_MOB_AREA_CODE = comp_cont_mob_area_code;
	}

	public void checkemployerYN(){
		ResultSet resultSet = null;
		String exists=null;
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			String selectQuery = "SELECT POL_NO FROM PT_IL_POLICY WHERE POL_NO =?";
			
		if("Y".equalsIgnoreCase(PM_IL_CONTRACTOR_BEAN.getCONT_EMPLOYER_YN())){
			resultSet = handler.executeSelectStatement(selectQuery, connection, new Object[]{PM_IL_CONTRACTOR_BEAN.getCONT_CODE()});
			if (resultSet.next()) {
				exists ="TRUE";
			}
			else{
				dummy_insert_policy(PM_IL_CONTRACTOR_BEAN.getCONT_CODE());
		}
		
	}
		}catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {

			CommonUtils.closeCursor(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		
		}
	
	 public ArrayList<OracleParameter> dummy_insert_policy(
             Object P_ORG_VALUE
  ) throws ProcedureException, com.iii.premia.common.exception.ProcedureException {
Connection connection = null;
ArrayList<OracleParameter> parameterList = null;
ArrayList<OracleParameter> outputList = null;
try {
	connection = CommonUtils.getConnection();
	parameterList = new ArrayList<OracleParameter>();
	outputList = new ArrayList<OracleParameter>();
   OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_ORG_VALUE);
   parameterList.add(param1);
  

  OracleProcedureHandler procHandler = new OracleProcedureHandler();
   outputList = procHandler.executeProc(parameterList, connection,
          "DUMMY_POL_INSERT");
} catch(Exception e) {
	ErrorHelpUtil.getErrorForProcedure(connection);
       throw new ProcedureException(e.getMessage());
}
return outputList;
}
	
	 public void getBankdetails(){
			ResultSet resultSet = null;
			String bankcode=null;
			String micrcode=null;
			String accno=null;
			
			try {
				Connection connection = CommonUtils.getConnection();
				CRUDHandler handler = new CRUDHandler();
				String selectQuery = "SELECT CBAD_MICR_CODE,CBAD_ACNT_NO FROM PM_CUST_BANK_ACNT_DTLS WHERE CBAD_CUST_CODE= ?";
				
				resultSet = handler.executeSelectStatement(selectQuery, connection, new Object[]{PM_IL_CONTRACTOR_BEAN.getCONT_CODE()});
				if (resultSet.next()) {
					micrcode=resultSet.getString(1);
					accno=resultSet.getString(2);
					//bankcode=micrcode.substring(3, 6); commented by Janani on 25.07.2017 for ZBILQC-1732979
				}
				
				/*Added by Janani on 25.07.2017 for ZBILQC-1732979*/
				if(micrcode != null)
				{
					bankcode=micrcode.substring(3, 6);
				}
			
				/*End*/
				
				PM_IL_CONTRACTOR_BEAN.setCONT_AD_ACC_NO(accno);
				PM_IL_CONTRACTOR_BEAN.setCONT_AD_BANK_CODE(bankcode);
				PM_IL_CONTRACTOR_BEAN.setUI_M_CONT_AD_BANK_NAME(getBankDesc(bankcode));
				
				
				COMP_CONT_AD_ACC_NO.resetValue();
				COMP_CONT_AD_BANK_CODE.resetValue();
				COMP_UI_M_CONT_AD_BANK_NAME.resetValue();
			}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
			
			} 
	 
		public String getBankDesc(String bankCode) throws Exception{
			Connection connection = null;
			ResultSet resultSet =null;
			String desc = null;
			String query ="SELECT PMD_BANK_NAME  FROM PM_BANK_DTLS WHERE PMD_BANK_CODE = ?";
			try {
				connection = CommonUtils.getConnection();
				resultSet =  new CRUDHandler().executeSelectStatement(query, connection,new Object[]{bankCode});
				if(resultSet.next()){
					desc = resultSet.getString(1);
				}
			} catch (DBException e) {
				e.printStackTrace();
				throw e;
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}catch (Exception e) {
				e.printStackTrace();
				throw e;
			}finally{
				CommonUtils.closeCursor(resultSet);
			}
			return desc;
		}

		public HtmlCommandLink getCOMP_BUT_DELETE() {
			return COMP_BUT_DELETE;
		}

		public void setCOMP_BUT_DELETE(HtmlCommandLink comp_but_delete) {
			COMP_BUT_DELETE = comp_but_delete;
		}

		public HtmlCommandLink getCOMP_BUT_SAVE() {
			return COMP_BUT_SAVE;
		}

		public void setCOMP_BUT_SAVE(HtmlCommandLink comp_but_save) {
			COMP_BUT_SAVE = comp_but_save;
		}

		public HtmlCommandLink getCOMP_BUT_SAVE2() {
			return COMP_BUT_SAVE2;
		}

		public void setCOMP_BUT_SAVE2(HtmlCommandLink comp_but_save2) {
			COMP_BUT_SAVE2 = comp_but_save2;
		}

		public HtmlCommandButton getCOMP_IMG_DEL() {
			return COMP_IMG_DEL;
		}

		public void setCOMP_IMG_DEL(HtmlCommandButton comp_img_del) {
			COMP_IMG_DEL = comp_img_del;
		}

		public HtmlCommandButton getCOMP_IMG_SAVE() {
			return COMP_IMG_SAVE;
		}

		public void setCOMP_IMG_SAVE(HtmlCommandButton comp_img_save) {
			COMP_IMG_SAVE = comp_img_save;
		}

		public HtmlCommandButton getCOMP_IMG_SAVE2() {
			return COMP_IMG_SAVE2;
		}

		public void setCOMP_IMG_SAVE2(HtmlCommandButton comp_img_save2) {
			COMP_IMG_SAVE2 = comp_img_save2;
		}
		public void disableAllComponent(boolean disabled){
			// Disabling HtmlInputText
			COMP_CONT_TEL_AREA_CODE.setDisabled(disabled);
			COMP_CONT_MOBILE_NO.setDisabled(disabled);
			COMP_CONT_POSTAL_CODE.setDisabled(disabled);
			COMP_CONT_STATE_CODE.setDisabled(disabled);
			COMP_CONT_BIRTH_CERT_NO.setDisabled(disabled);
			COMP_CONT_MAR_STATUS.setDisabled(disabled);
			COMP_CONT_RELIGION.setDisabled(disabled);
			COMP_CONT_AREA.setDisabled(disabled);
			COMP_CONT_LC_PROP_DEP_AMT.setDisabled(disabled);
			COMP_CONT_LC_POL_DEP_AMT.setDisabled(disabled);
			COMP_CONT_AD_BANK_CODE.setDisabled(disabled);
			COMP_CONT_REMARKS.setDisabled(disabled);
			COMP_CONT_BL_ADDR1.setDisabled(disabled);
			COMP_CONT_BL_NAME.setDisabled(disabled);
			COMP_CONT_BL_ADDR2.setDisabled(disabled);
			COMP_CONT_BL_ADDR3.setDisabled(disabled);
			COMP_CONT_BL_CONTACT.setDisabled(disabled);
			COMP_CONT_PHONE.setDisabled(disabled);
			COMP_CONT_STATE.setDisabled(disabled);
			COMP_UI_M_CONT_MAR_STATUS_DESC.setDisabled(disabled);
			COMP_UI_M_CONT_RELIGION_DESC.setDisabled(disabled);
			COMP_UI_M_CONT_AD_BANK_NAME.setDisabled(disabled);
			COMP_CONT_CODE.setDisabled(disabled);
			COMP_CONT_REF_ID1.setDisabled(disabled);
			COMP_CONT_REF_ID2.setDisabled(disabled);
			COMP_CONT_NAME.setDisabled(disabled);
			COMP_CONT_ADDR1.setDisabled(disabled);
			COMP_CONT_ADDR2.setDisabled(disabled);
			COMP_CONT_ADDR3.setDisabled(disabled);
			COMP_CONT_CONTACT.setDisabled(disabled);
			COMP_CONT_FAX_AREA_CODE.setDisabled(disabled);
			COMP_CONT_EMAIL_ID.setDisabled(disabled);
			COMP_CONT_CITY_CODE.setDisabled(disabled);
			COMP_CONT_COUNT_CODE.setDisabled(disabled);
			COMP_CONT_CATG_CODE.setDisabled(disabled);
			COMP_CONT_NATIONALITY_CODE.setDisabled(disabled);
			COMP_CONT_RACE.setDisabled(disabled);
			COMP_CONT_REGION.setDisabled(disabled);
			COMP_CONT_REF_NO.setDisabled(disabled);
			COMP_CONT_LC_PROP_UTIL_AMT.setDisabled(disabled);
			COMP_CONT_LC_POL_UTIL_AMT.setDisabled(disabled);
			COMP_CONT_AD_ACC_NO.setDisabled(disabled);
			COMP_CONT_FAX.setDisabled(disabled);
			COMP_CONT_CITY.setDisabled(disabled);
			COMP_CONT_COUNTRY.setDisabled(disabled);
			COMP_UI_M_CONT_CATG_CODE_DESC.setDisabled(disabled);
			COMP_UI_M_CONT_NATIONALITY_CODE_DESC.setDisabled(disabled);
			COMP_UI_M_CONT_RACE_DESC.setDisabled(disabled);
			COMP_UI_M_CONT_CITY_CODE_DESC.setDisabled(disabled);
			COMP_UI_M_CONT_STATE_CODE_DESC.setDisabled(disabled);
			COMP_CONT_MOB_AREA_CODE.setDisabled(disabled);

			// Disabling HtmlSelectOneMenu
			COMP_CONT_EMPLOYER_YN.setDisabled(disabled);
			COMP_CONT_PREFERRED_LANG.setDisabled(disabled);

			// Disabling HtmlCalendar
			COMP_CONT_EFF_FM_DT.setDisabled(disabled);
			COMP_CONT_DOB.setDisabled(disabled);
			COMP_CONT_EFF_TO_DT.setDisabled(disabled);

			// Disabling HtmlCommandButton
			COMP_PUSH_BUTTON208.setDisabled(disabled);
			COMP_ITEM158.setDisabled(disabled);
			COMP_UI_M_M_BUT_UPDATE.setDisabled(disabled);
			COMP_UI_M_M_BUT_DELETE.setDisabled(disabled);
			
			/*Added by saritha on 16-May-2017 for ssp call id ZBILQC-1720645*/
			COMP_CONT_LC_PROP_SUS_AMT.setDisabled(disabled);
			COMP_CONT_LC_POL_SUS_AMT.setDisabled(disabled);
			/*End*/

		}
		public void instantiateAllComponent(){
			// Instantiating HtmlInputText
			COMP_CONT_TEL_AREA_CODE				 = new HtmlInputText();
			COMP_CONT_MOBILE_NO				 = new HtmlInputText();
			COMP_CONT_POSTAL_CODE				 = new HtmlInputText();
			COMP_CONT_STATE_CODE				 = new HtmlInputText();
			COMP_CONT_BIRTH_CERT_NO				 = new HtmlInputText();
			COMP_CONT_MAR_STATUS				 = new HtmlInputText();
			COMP_CONT_RELIGION				 = new HtmlInputText();
			COMP_CONT_AREA					 = new HtmlInputText();
			COMP_CONT_LC_PROP_DEP_AMT			 = new HtmlInputText();
			COMP_CONT_LC_POL_DEP_AMT			 = new HtmlInputText();
			COMP_CONT_AD_BANK_CODE				 = new HtmlInputText();
			COMP_CONT_REMARKS				 = new HtmlInputText();
			COMP_CONT_BL_ADDR1				 = new HtmlInputText();
			COMP_CONT_BL_NAME				 = new HtmlInputText();
			COMP_CONT_BL_ADDR2				 = new HtmlInputText();
			COMP_CONT_BL_ADDR3				 = new HtmlInputText();
			COMP_CONT_BL_CONTACT				 = new HtmlInputText();
			COMP_CONT_PHONE					 = new HtmlInputText();
			COMP_CONT_STATE					 = new HtmlInputText();
			COMP_UI_M_CONT_MAR_STATUS_DESC			 = new HtmlInputText();
			COMP_UI_M_CONT_RELIGION_DESC			 = new HtmlInputText();
			COMP_UI_M_CONT_AD_BANK_NAME			 = new HtmlInputText();
			COMP_CONT_CODE					 = new HtmlInputText();
			COMP_CONT_REF_ID1				 = new HtmlInputText();
			COMP_CONT_REF_ID2				 = new HtmlInputText();
			COMP_CONT_NAME					 = new HtmlInputText();
			COMP_CONT_ADDR1					 = new HtmlInputText();
			COMP_CONT_ADDR2					 = new HtmlInputText();
			COMP_CONT_ADDR3					 = new HtmlInputText();
			COMP_CONT_CONTACT				 = new HtmlInputText();
			COMP_CONT_FAX_AREA_CODE				 = new HtmlInputText();
			COMP_CONT_EMAIL_ID				 = new HtmlInputText();
			COMP_CONT_CITY_CODE				 = new HtmlInputText();
			COMP_CONT_COUNT_CODE				 = new HtmlInputText();
			COMP_CONT_CATG_CODE				 = new HtmlInputText();
			COMP_CONT_NATIONALITY_CODE			 = new HtmlInputText();
			COMP_CONT_RACE					 = new HtmlInputText();
			COMP_CONT_REGION				 = new HtmlInputText();
			COMP_CONT_REF_NO				 = new HtmlInputText();
			COMP_CONT_LC_PROP_UTIL_AMT			 = new HtmlInputText();
			COMP_CONT_LC_POL_UTIL_AMT			 = new HtmlInputText();
			COMP_CONT_AD_ACC_NO				 = new HtmlInputText();
			COMP_CONT_FAX					 = new HtmlInputText();
			COMP_CONT_CITY					 = new HtmlInputText();
			COMP_CONT_COUNTRY				 = new HtmlInputText();
			COMP_UI_M_CONT_CATG_CODE_DESC			 = new HtmlInputText();
			COMP_UI_M_CONT_NATIONALITY_CODE_DESC		 = new HtmlInputText();
			COMP_UI_M_CONT_RACE_DESC			 = new HtmlInputText();
			COMP_UI_M_CONT_CITY_CODE_DESC			 = new HtmlInputText();
			COMP_UI_M_CONT_STATE_CODE_DESC			 = new HtmlInputText();
			COMP_CONT_MOB_AREA_CODE				 = new HtmlInputText();

			// Instantiating HtmlSelectOneMenu
			COMP_CONT_EMPLOYER_YN				 = new HtmlSelectOneMenu();
			COMP_CONT_PREFERRED_LANG			 = new HtmlSelectOneMenu();

			// Instantiating HtmlCalendar
			COMP_CONT_EFF_FM_DT				 = new HtmlCalendar();
			COMP_CONT_DOB					 = new HtmlCalendar();
			COMP_CONT_EFF_TO_DT				 = new HtmlCalendar();

			// Instantiating HtmlCommandButton
			COMP_PUSH_BUTTON208				 = new HtmlCommandButton();
			COMP_ITEM158					 = new HtmlCommandButton();
			COMP_UI_M_M_BUT_UPDATE				 = new HtmlCommandButton();
			COMP_UI_M_M_BUT_DELETE				 = new HtmlCommandButton();
			COMP_IMG_DEL					 = new HtmlCommandButton();
			COMP_IMG_SAVE					 = new HtmlCommandButton();
			COMP_IMG_SAVE2					 = new HtmlCommandButton();

			// Instantiating HtmlCommandLink
			COMP_BUT_DELETE					 = new HtmlCommandLink();
			COMP_BUT_SAVE					 = new HtmlCommandLink();
			COMP_BUT_SAVE2					 = new HtmlCommandLink();

			/*Added by saritha on 16-May-2017 for ssp call id ZBILQC-1720645*/
			COMP_CONT_LC_PROP_SUS_AMT_LABEL  = new HtmlOutputLabel();
			COMP_CONT_LC_POL_SUS_AMT_LABEL   = new HtmlOutputLabel();
			COMP_CONT_LC_PROP_SUS_AMT        = new HtmlInputText();
			COMP_CONT_LC_POL_SUS_AMT         = new HtmlInputText();
			/*End*/
		}

		
		
		/*Added by Janani on 03.04.2017 as part of factory testing feedback Customer Master - Validation point*/
			
			private void getNationalityID() throws Exception {
				
				System.out.println("enters into getNationalityID in assured dtls screen");
				
				String query = "select PC_CODE,PC_DESC from PM_CODES WHERE PC_TYPE = 'NATLITY' and PC_CODE='A00001'";
				Connection con = null;
				CRUDHandler handler = new CRUDHandler();
				ResultSet rs = null;
				String idCode = null;
				String idDesc = null;

				try {
					con = CommonUtils.getConnection();
					rs = handler.executeSelectStatement(query, con,
							new Object[] {});
					if (rs.next()) {
						
						idCode = rs.getString("PC_CODE");
						PM_IL_CONTRACTOR_BEAN.setCONT_NATIONALITY_CODE(idCode);
						
						System.out.println("idCode             :"+idCode+"    getPOAD_NATIONALITY           "+PM_IL_CONTRACTOR_BEAN.getCONT_NATIONALITY_CODE());
						
						
						idDesc = rs.getString("PC_DESC");
						PM_IL_CONTRACTOR_BEAN.setUI_M_CONT_NATIONALITY_CODE_DESC(idDesc);
						
						
						System.out.println("idDesc             :"+idDesc+"    getUI_M_POAD_NATIONALITY_DESC           "+PM_IL_CONTRACTOR_BEAN.getUI_M_CONT_NATIONALITY_CODE_DESC());
						
						
					} 

				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}

				
			}
			
			/*End*/
			
			/*Added by saritha on 16-May-2017 for ssp call id ZBILQC-1720645*/
			private HtmlOutputLabel COMP_CONT_LC_PROP_SUS_AMT_LABEL;
			private HtmlOutputLabel COMP_CONT_LC_POL_SUS_AMT_LABEL;
			private HtmlInputText COMP_CONT_LC_PROP_SUS_AMT;
			private HtmlInputText COMP_CONT_LC_POL_SUS_AMT;
			public HtmlOutputLabel getCOMP_CONT_LC_PROP_SUS_AMT_LABEL() {
				return COMP_CONT_LC_PROP_SUS_AMT_LABEL;
			}

			public void setCOMP_CONT_LC_PROP_SUS_AMT_LABEL(
					HtmlOutputLabel cOMP_CONT_LC_PROP_SUS_AMT_LABEL) {
				COMP_CONT_LC_PROP_SUS_AMT_LABEL = cOMP_CONT_LC_PROP_SUS_AMT_LABEL;
			}

			public HtmlOutputLabel getCOMP_CONT_LC_POL_SUS_AMT_LABEL() {
				return COMP_CONT_LC_POL_SUS_AMT_LABEL;
			}

			public void setCOMP_CONT_LC_POL_SUS_AMT_LABEL(
					HtmlOutputLabel cOMP_CONT_LC_POL_SUS_AMT_LABEL) {
				COMP_CONT_LC_POL_SUS_AMT_LABEL = cOMP_CONT_LC_POL_SUS_AMT_LABEL;
			}

			public HtmlInputText getCOMP_CONT_LC_PROP_SUS_AMT() {
				return COMP_CONT_LC_PROP_SUS_AMT;
			}

			public void setCOMP_CONT_LC_PROP_SUS_AMT(HtmlInputText cOMP_CONT_LC_PROP_SUS_AMT) {
				COMP_CONT_LC_PROP_SUS_AMT = cOMP_CONT_LC_PROP_SUS_AMT;
			}

			public HtmlInputText getCOMP_CONT_LC_POL_SUS_AMT() {
				return COMP_CONT_LC_POL_SUS_AMT;
			}

			public void setCOMP_CONT_LC_POL_SUS_AMT(HtmlInputText cOMP_CONT_LC_POL_SUS_AMT) {
				COMP_CONT_LC_POL_SUS_AMT = cOMP_CONT_LC_POL_SUS_AMT;
			}
			
			/*End*/

			
			/* Added by Janani on 25.07.2017 for ZBILQC-1732979*/
			
			public void getCustType() throws Exception{

				
				System.out.println("enters into getCustType");
				
				String cust_code = PM_IL_CONTRACTOR_BEAN.getCONT_CODE();

				String C1 ="SELECT CUST_TYPE FROM PM_CUSTOMER WHERE CUST_CODE = ? ";
				ResultSet C1_REC = null;
				String custType= null;
				try {
					Connection connection = CommonUtils.getConnection();
					CRUDHandler handler = new CRUDHandler();
					C1_REC = handler.executeSelectStatement(C1, connection,
							new Object[] {cust_code});
					if (C1_REC.next()) {
						custType =C1_REC.getString("CUST_TYPE");
						/* Added by Janani on 07.08.2017 for ZBILQC-1732979*/
						setCustTypeFlag(custType);
						/*end*/
					}

					System.out.println("**************value of custType***"+custType);

					if(custType != null && (custType.equalsIgnoreCase("C") 
							|| custType.equalsIgnoreCase("G") 
							|| custType.equalsIgnoreCase("O")))
					{
						
						/* Modified by Janani on 07.08.2017 for ZBILQC-1732979*/
						
						//COMP_CONT_REF_ID1.setRequired(false);
						COMP_CONT_REF_ID1_LABEL.setValue("ROC Number");
						COMP_CONT_REF_ID1.setRequired(true);
						
						/*End*/

					}
					else
					{
						COMP_CONT_REF_ID1_LABEL.setValue("National ID");
						
						/* Modified by Janani on 07.08.2017 for ZBILQC-1732979*/
						COMP_CONT_REF_ID1.setRequired(true);
						/*End*/
					}

				}				catch (SQLException e)
				{
					throw new Exception(e.getMessage());
				} 



			}
			
			
			/*End*/
			
			/* Added by Janani on 07.08.2017 for ZBILQC-1732979*/
			private String custTypeFlag = "X";

			public String getCustTypeFlag() {
				return custTypeFlag;
			}

			public void setCustTypeFlag(String custTypeFlag) {
				this.custTypeFlag = custTypeFlag;
			}
			/*end*/

}
