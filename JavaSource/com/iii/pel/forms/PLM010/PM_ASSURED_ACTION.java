package com.iii.pel.forms.PLM010;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_ASSURED_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_ASSR_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_ASSR_FRZ_FLAG;
	
	private HtmlOutputLabel COMP_CUST_CODE_LABEL;

	private HtmlInputText COMP_ASSR_CUST_CODE;

	private HtmlOutputLabel COMP_CUST_NAME_LABEL;

	private HtmlInputText COMP_CUST_NAME;

	private HtmlOutputLabel COMP_ASSR_CODE_LABEL;

	private HtmlInputText COMP_ASSR_CODE;

	private HtmlOutputLabel COMP_ASSR_NAME_LABEL;

	private HtmlInputText COMP_ASSR_NAME;

	private HtmlOutputLabel COMP_ASSR_OCC_CODE_LABEL;

	private HtmlInputText COMP_ASSR_OCC_CODE;

	private HtmlOutputLabel COMP_UI_M_ASSR_OCC_DESC_LABEL;

	private HtmlInputText COMP_UI_M_ASSR_OCC_DESC;

	private HtmlOutputLabel COMP_ASSR_FLOOR_LABEL;

	private HtmlInputText COMP_ASSR_FLOOR;

	private HtmlOutputLabel COMP_ASSR_BUILDING_LABEL;

	private HtmlInputText COMP_ASSR_BUILDING;

	private HtmlOutputLabel COMP_ASSR_STREET_LABEL;

	private HtmlInputText COMP_ASSR_STREET;

	private HtmlOutputLabel COMP_ASSR_ADDR1_LABEL;

	private HtmlInputText COMP_ASSR_ADDR1;

	private HtmlOutputLabel COMP_ASSR_ADDR2_LABEL;

	private HtmlInputText COMP_ASSR_ADDR2;

	private HtmlOutputLabel COMP_ASSR_ADDR3_LABEL;

	private HtmlInputText COMP_ASSR_ADDR3;

	private HtmlOutputLabel COMP_ASSR_CONTACT_LABEL;

	private HtmlInputText COMP_ASSR_CONTACT;

	private HtmlOutputLabel COMP_ASSR_FAX_LABEL;

	private HtmlInputText COMP_ASSR_FAX;

	private HtmlOutputLabel COMP_ASSR_PHONE_LABEL;

	private HtmlInputText COMP_ASSR_PHONE;

	private HtmlOutputLabel COMP_ASSR_OFFICE_PHONE_LABEL;

	private HtmlInputText COMP_ASSR_OFFICE_PHONE;

	private HtmlOutputLabel COMP_ASSR_PIN_NO_LABEL;

	private HtmlInputText COMP_ASSR_PIN_NO;

	private HtmlOutputLabel COMP_ASSR_DOB_LABEL;

	private HtmlCalendar COMP_ASSR_DOB;

	private HtmlOutputLabel COMP_ASSR_ID_NO_LABEL;

	private HtmlInputText COMP_ASSR_ID_NO;

	private HtmlOutputLabel COMP_ASSR_VAT_NO_LABEL;

	private HtmlInputText COMP_ASSR_VAT_NO;

	private HtmlOutputLabel COMP_ASSR_REMARKS_LABEL;

	private HtmlInputText COMP_ASSR_REMARKS;

	private HtmlOutputLabel COMP_ASSR_DFLT_YN_LABEL;

	private HtmlSelectOneMenu COMP_ASSR_DFLT_YN;

	private HtmlOutputLabel COMP_ASSR_BL_NAME_LABEL;

	private HtmlInputText COMP_ASSR_BL_NAME;

	private HtmlOutputLabel COMP_ASSR_BL_ADDR1_LABEL;

	private HtmlInputText COMP_ASSR_BL_ADDR1;

	private HtmlOutputLabel COMP_ASSR_BL_ADDR2_LABEL;

	private HtmlInputText COMP_ASSR_BL_ADDR2;

	private HtmlOutputLabel COMP_ASSR_BL_ADDR3_LABEL;

	private HtmlInputText COMP_ASSR_BL_ADDR3;

	private HtmlOutputLabel COMP_ASSR_BL_CONTACT_LABEL;

	private HtmlInputText COMP_ASSR_BL_CONTACT;

	private HtmlCommandButton COMP_PUSH_BUTTON112;

	private HtmlCommandButton COMP_PUSH_BUTTON110;

	private HtmlCommandButton COMP_PUSH_BUTTON106;

	private HtmlCommandButton COMP_PUSH_BUTTON104;

	private HtmlCommandButton COMP_PUSH_BUTTON102;

	private HtmlCommandButton COMP_PUSH_BUTTON100;

	private HtmlCommandButton COMP_UI_M_BUT_CUST_CLASS_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_CUST_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_LOV_ASSR_OCC;

	private PM_ASSURED PM_ASSURED_BEAN;
	
	private List<SelectItem>  DFLT_YN_LIST  = new  ArrayList<SelectItem>();
	
	private int lastUpdatedRowIndex;
	
	private ArrayList<PM_ASSURED> namesList;
	
	private boolean checkBoxSelected;
	
	String assr_code_validate;
	
	private boolean validate_Error = false;
	
	Map<String, Object> session;
	
	ControlBean ctrlBean = null;
	
	

	public boolean isCheckBoxSelected() {
		return checkBoxSelected;
	}

	public void setCheckBoxSelected(boolean checkBoxSelected) {
		this.checkBoxSelected = checkBoxSelected;
	}

	public PM_ASSURED_ACTION() {
		FORM_PRE_FORM();
		PM_ASSURED_BEAN = new PM_ASSURED();
		COMP_ASSR_CUST_CODE=new HtmlInputText();
		COMP_CUST_NAME=new HtmlInputText();
		COMP_ASSR_CODE=new HtmlInputText();
		
		
	}

	public HtmlOutputLabel getCOMP_ASSR_FRZ_FLAG_LABEL() {
		return COMP_ASSR_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_ASSR_FRZ_FLAG() {
		return COMP_ASSR_FRZ_FLAG;
	}

	public void setCOMP_ASSR_FRZ_FLAG_LABEL(HtmlOutputLabel COMP_ASSR_FRZ_FLAG_LABEL) {
		this.COMP_ASSR_FRZ_FLAG_LABEL = COMP_ASSR_FRZ_FLAG_LABEL;
	}

	public void setCOMP_ASSR_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_ASSR_FRZ_FLAG) {
		this.COMP_ASSR_FRZ_FLAG = COMP_ASSR_FRZ_FLAG;
	}
	
	public HtmlOutputLabel getCOMP_CUST_CODE_LABEL() {
		return COMP_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ASSR_CUST_CODE() {
		return COMP_ASSR_CUST_CODE;
	}

	public void setCOMP_CUST_CODE_LABEL(HtmlOutputLabel COMP_CUST_CODE_LABEL) {
		this.COMP_CUST_CODE_LABEL = COMP_CUST_CODE_LABEL;
	}

	public void setCOMP_ASSR_CUST_CODE(HtmlInputText COMP_ASSR_CUST_CODE) {
		this.COMP_ASSR_CUST_CODE = COMP_ASSR_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_CUST_NAME_LABEL() {
		return COMP_CUST_NAME_LABEL;
	}

	public HtmlInputText getCOMP_CUST_NAME() {
		return COMP_CUST_NAME;
	}

	public void setCOMP_CUST_NAME_LABEL(HtmlOutputLabel COMP_CUST_NAME_LABEL) {
		this.COMP_CUST_NAME_LABEL = COMP_CUST_NAME_LABEL;
	}

	public void setCOMP_CUST_NAME(HtmlInputText COMP_CUST_NAME) {
		this.COMP_CUST_NAME = COMP_CUST_NAME;
	}

	public HtmlOutputLabel getCOMP_ASSR_CODE_LABEL() {
		return COMP_ASSR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ASSR_CODE() {
		return COMP_ASSR_CODE;
	}

	public void setCOMP_ASSR_CODE_LABEL(HtmlOutputLabel COMP_ASSR_CODE_LABEL) {
		this.COMP_ASSR_CODE_LABEL = COMP_ASSR_CODE_LABEL;
	}

	public void setCOMP_ASSR_CODE(HtmlInputText COMP_ASSR_CODE) {
		this.COMP_ASSR_CODE = COMP_ASSR_CODE;
	}

	public HtmlOutputLabel getCOMP_ASSR_NAME_LABEL() {
		return COMP_ASSR_NAME_LABEL;
	}

	public HtmlInputText getCOMP_ASSR_NAME() {
		return COMP_ASSR_NAME;
	}

	public void setCOMP_ASSR_NAME_LABEL(HtmlOutputLabel COMP_ASSR_NAME_LABEL) {
		this.COMP_ASSR_NAME_LABEL = COMP_ASSR_NAME_LABEL;
	}

	public void setCOMP_ASSR_NAME(HtmlInputText COMP_ASSR_NAME) {
		this.COMP_ASSR_NAME = COMP_ASSR_NAME;
	}

	public HtmlOutputLabel getCOMP_ASSR_OCC_CODE_LABEL() {
		return COMP_ASSR_OCC_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ASSR_OCC_CODE() {
		return COMP_ASSR_OCC_CODE;
	}

	public void setCOMP_ASSR_OCC_CODE_LABEL(HtmlOutputLabel COMP_ASSR_OCC_CODE_LABEL) {
		this.COMP_ASSR_OCC_CODE_LABEL = COMP_ASSR_OCC_CODE_LABEL;
	}

	public void setCOMP_ASSR_OCC_CODE(HtmlInputText COMP_ASSR_OCC_CODE) {
		this.COMP_ASSR_OCC_CODE = COMP_ASSR_OCC_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ASSR_OCC_DESC_LABEL() {
		return COMP_UI_M_ASSR_OCC_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ASSR_OCC_DESC() {
		return COMP_UI_M_ASSR_OCC_DESC;
	}

	public void setCOMP_UI_M_ASSR_OCC_DESC_LABEL(HtmlOutputLabel COMP_UI_M_ASSR_OCC_DESC_LABEL) {
		this.COMP_UI_M_ASSR_OCC_DESC_LABEL = COMP_UI_M_ASSR_OCC_DESC_LABEL;
	}

	public void setCOMP_UI_M_ASSR_OCC_DESC(HtmlInputText COMP_UI_M_ASSR_OCC_DESC) {
		this.COMP_UI_M_ASSR_OCC_DESC = COMP_UI_M_ASSR_OCC_DESC;
	}

	public HtmlOutputLabel getCOMP_ASSR_FLOOR_LABEL() {
		return COMP_ASSR_FLOOR_LABEL;
	}

	public HtmlInputText getCOMP_ASSR_FLOOR() {
		return COMP_ASSR_FLOOR;
	}

	public void setCOMP_ASSR_FLOOR_LABEL(HtmlOutputLabel COMP_ASSR_FLOOR_LABEL) {
		this.COMP_ASSR_FLOOR_LABEL = COMP_ASSR_FLOOR_LABEL;
	}

	public void setCOMP_ASSR_FLOOR(HtmlInputText COMP_ASSR_FLOOR) {
		this.COMP_ASSR_FLOOR = COMP_ASSR_FLOOR;
	}

	public HtmlOutputLabel getCOMP_ASSR_BUILDING_LABEL() {
		return COMP_ASSR_BUILDING_LABEL;
	}

	public HtmlInputText getCOMP_ASSR_BUILDING() {
		return COMP_ASSR_BUILDING;
	}

	public void setCOMP_ASSR_BUILDING_LABEL(HtmlOutputLabel COMP_ASSR_BUILDING_LABEL) {
		this.COMP_ASSR_BUILDING_LABEL = COMP_ASSR_BUILDING_LABEL;
	}

	public void setCOMP_ASSR_BUILDING(HtmlInputText COMP_ASSR_BUILDING) {
		this.COMP_ASSR_BUILDING = COMP_ASSR_BUILDING;
	}

	public HtmlOutputLabel getCOMP_ASSR_STREET_LABEL() {
		return COMP_ASSR_STREET_LABEL;
	}

	public HtmlInputText getCOMP_ASSR_STREET() {
		return COMP_ASSR_STREET;
	}

	public void setCOMP_ASSR_STREET_LABEL(HtmlOutputLabel COMP_ASSR_STREET_LABEL) {
		this.COMP_ASSR_STREET_LABEL = COMP_ASSR_STREET_LABEL;
	}

	public void setCOMP_ASSR_STREET(HtmlInputText COMP_ASSR_STREET) {
		this.COMP_ASSR_STREET = COMP_ASSR_STREET;
	}

	public HtmlOutputLabel getCOMP_ASSR_ADDR1_LABEL() {
		return COMP_ASSR_ADDR1_LABEL;
	}

	public HtmlInputText getCOMP_ASSR_ADDR1() {
		return COMP_ASSR_ADDR1;
	}

	public void setCOMP_ASSR_ADDR1_LABEL(HtmlOutputLabel COMP_ASSR_ADDR1_LABEL) {
		this.COMP_ASSR_ADDR1_LABEL = COMP_ASSR_ADDR1_LABEL;
	}

	public void setCOMP_ASSR_ADDR1(HtmlInputText COMP_ASSR_ADDR1) {
		this.COMP_ASSR_ADDR1 = COMP_ASSR_ADDR1;
	}

	public HtmlOutputLabel getCOMP_ASSR_ADDR2_LABEL() {
		return COMP_ASSR_ADDR2_LABEL;
	}

	public HtmlInputText getCOMP_ASSR_ADDR2() {
		return COMP_ASSR_ADDR2;
	}

	public void setCOMP_ASSR_ADDR2_LABEL(HtmlOutputLabel COMP_ASSR_ADDR2_LABEL) {
		this.COMP_ASSR_ADDR2_LABEL = COMP_ASSR_ADDR2_LABEL;
	}

	public void setCOMP_ASSR_ADDR2(HtmlInputText COMP_ASSR_ADDR2) {
		this.COMP_ASSR_ADDR2 = COMP_ASSR_ADDR2;
	}

	public HtmlOutputLabel getCOMP_ASSR_ADDR3_LABEL() {
		return COMP_ASSR_ADDR3_LABEL;
	}

	public HtmlInputText getCOMP_ASSR_ADDR3() {
		return COMP_ASSR_ADDR3;
	}

	public void setCOMP_ASSR_ADDR3_LABEL(HtmlOutputLabel COMP_ASSR_ADDR3_LABEL) {
		this.COMP_ASSR_ADDR3_LABEL = COMP_ASSR_ADDR3_LABEL;
	}

	public void setCOMP_ASSR_ADDR3(HtmlInputText COMP_ASSR_ADDR3) {
		this.COMP_ASSR_ADDR3 = COMP_ASSR_ADDR3;
	}

	public HtmlOutputLabel getCOMP_ASSR_CONTACT_LABEL() {
		return COMP_ASSR_CONTACT_LABEL;
	}

	public HtmlInputText getCOMP_ASSR_CONTACT() {
		return COMP_ASSR_CONTACT;
	}

	public void setCOMP_ASSR_CONTACT_LABEL(HtmlOutputLabel COMP_ASSR_CONTACT_LABEL) {
		this.COMP_ASSR_CONTACT_LABEL = COMP_ASSR_CONTACT_LABEL;
	}

	public void setCOMP_ASSR_CONTACT(HtmlInputText COMP_ASSR_CONTACT) {
		this.COMP_ASSR_CONTACT = COMP_ASSR_CONTACT;
	}

	public HtmlOutputLabel getCOMP_ASSR_FAX_LABEL() {
		return COMP_ASSR_FAX_LABEL;
	}

	public HtmlInputText getCOMP_ASSR_FAX() {
		return COMP_ASSR_FAX;
	}

	public void setCOMP_ASSR_FAX_LABEL(HtmlOutputLabel COMP_ASSR_FAX_LABEL) {
		this.COMP_ASSR_FAX_LABEL = COMP_ASSR_FAX_LABEL;
	}

	public void setCOMP_ASSR_FAX(HtmlInputText COMP_ASSR_FAX) {
		this.COMP_ASSR_FAX = COMP_ASSR_FAX;
	}

	public HtmlOutputLabel getCOMP_ASSR_PHONE_LABEL() {
		return COMP_ASSR_PHONE_LABEL;
	}

	public HtmlInputText getCOMP_ASSR_PHONE() {
		return COMP_ASSR_PHONE;
	}

	public void setCOMP_ASSR_PHONE_LABEL(HtmlOutputLabel COMP_ASSR_PHONE_LABEL) {
		this.COMP_ASSR_PHONE_LABEL = COMP_ASSR_PHONE_LABEL;
	}

	public void setCOMP_ASSR_PHONE(HtmlInputText COMP_ASSR_PHONE) {
		this.COMP_ASSR_PHONE = COMP_ASSR_PHONE;
	}

	public HtmlOutputLabel getCOMP_ASSR_OFFICE_PHONE_LABEL() {
		return COMP_ASSR_OFFICE_PHONE_LABEL;
	}

	public HtmlInputText getCOMP_ASSR_OFFICE_PHONE() {
		return COMP_ASSR_OFFICE_PHONE;
	}

	public void setCOMP_ASSR_OFFICE_PHONE_LABEL(HtmlOutputLabel COMP_ASSR_OFFICE_PHONE_LABEL) {
		this.COMP_ASSR_OFFICE_PHONE_LABEL = COMP_ASSR_OFFICE_PHONE_LABEL;
	}

	public void setCOMP_ASSR_OFFICE_PHONE(HtmlInputText COMP_ASSR_OFFICE_PHONE) {
		this.COMP_ASSR_OFFICE_PHONE = COMP_ASSR_OFFICE_PHONE;
	}

	public HtmlOutputLabel getCOMP_ASSR_PIN_NO_LABEL() {
		return COMP_ASSR_PIN_NO_LABEL;
	}

	public HtmlInputText getCOMP_ASSR_PIN_NO() {
		return COMP_ASSR_PIN_NO;
	}

	public void setCOMP_ASSR_PIN_NO_LABEL(HtmlOutputLabel COMP_ASSR_PIN_NO_LABEL) {
		this.COMP_ASSR_PIN_NO_LABEL = COMP_ASSR_PIN_NO_LABEL;
	}

	public void setCOMP_ASSR_PIN_NO(HtmlInputText COMP_ASSR_PIN_NO) {
		this.COMP_ASSR_PIN_NO = COMP_ASSR_PIN_NO;
	}

	public HtmlOutputLabel getCOMP_ASSR_DOB_LABEL() {
		return COMP_ASSR_DOB_LABEL;
	}

	public HtmlCalendar getCOMP_ASSR_DOB() {
		return COMP_ASSR_DOB;
	}

	public void setCOMP_ASSR_DOB_LABEL(HtmlOutputLabel COMP_ASSR_DOB_LABEL) {
		this.COMP_ASSR_DOB_LABEL = COMP_ASSR_DOB_LABEL;
	}

	public void setCOMP_ASSR_DOB(HtmlCalendar COMP_ASSR_DOB) {
		this.COMP_ASSR_DOB = COMP_ASSR_DOB;
	}

	public HtmlOutputLabel getCOMP_ASSR_ID_NO_LABEL() {
		return COMP_ASSR_ID_NO_LABEL;
	}

	public HtmlInputText getCOMP_ASSR_ID_NO() {
		return COMP_ASSR_ID_NO;
	}

	public void setCOMP_ASSR_ID_NO_LABEL(HtmlOutputLabel COMP_ASSR_ID_NO_LABEL) {
		this.COMP_ASSR_ID_NO_LABEL = COMP_ASSR_ID_NO_LABEL;
	}

	public void setCOMP_ASSR_ID_NO(HtmlInputText COMP_ASSR_ID_NO) {
		this.COMP_ASSR_ID_NO = COMP_ASSR_ID_NO;
	}

	public HtmlOutputLabel getCOMP_ASSR_VAT_NO_LABEL() {
		return COMP_ASSR_VAT_NO_LABEL;
	}

	public HtmlInputText getCOMP_ASSR_VAT_NO() {
		return COMP_ASSR_VAT_NO;
	}

	public void setCOMP_ASSR_VAT_NO_LABEL(HtmlOutputLabel COMP_ASSR_VAT_NO_LABEL) {
		this.COMP_ASSR_VAT_NO_LABEL = COMP_ASSR_VAT_NO_LABEL;
	}

	public void setCOMP_ASSR_VAT_NO(HtmlInputText COMP_ASSR_VAT_NO) {
		this.COMP_ASSR_VAT_NO = COMP_ASSR_VAT_NO;
	}

	public HtmlOutputLabel getCOMP_ASSR_REMARKS_LABEL() {
		return COMP_ASSR_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_ASSR_REMARKS() {
		return COMP_ASSR_REMARKS;
	}

	public void setCOMP_ASSR_REMARKS_LABEL(HtmlOutputLabel COMP_ASSR_REMARKS_LABEL) {
		this.COMP_ASSR_REMARKS_LABEL = COMP_ASSR_REMARKS_LABEL;
	}

	public void setCOMP_ASSR_REMARKS(HtmlInputText COMP_ASSR_REMARKS) {
		this.COMP_ASSR_REMARKS = COMP_ASSR_REMARKS;
	}

	public HtmlOutputLabel getCOMP_ASSR_DFLT_YN_LABEL() {
		return COMP_ASSR_DFLT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ASSR_DFLT_YN() {
		return COMP_ASSR_DFLT_YN;
	}

	public void setCOMP_ASSR_DFLT_YN_LABEL(HtmlOutputLabel COMP_ASSR_DFLT_YN_LABEL) {
		this.COMP_ASSR_DFLT_YN_LABEL = COMP_ASSR_DFLT_YN_LABEL;
	}

	public void setCOMP_ASSR_DFLT_YN(HtmlSelectOneMenu COMP_ASSR_DFLT_YN) {
		this.COMP_ASSR_DFLT_YN = COMP_ASSR_DFLT_YN;
	}

	public HtmlOutputLabel getCOMP_ASSR_BL_NAME_LABEL() {
		return COMP_ASSR_BL_NAME_LABEL;
	}

	public HtmlInputText getCOMP_ASSR_BL_NAME() {
		return COMP_ASSR_BL_NAME;
	}

	public void setCOMP_ASSR_BL_NAME_LABEL(HtmlOutputLabel COMP_ASSR_BL_NAME_LABEL) {
		this.COMP_ASSR_BL_NAME_LABEL = COMP_ASSR_BL_NAME_LABEL;
	}

	public void setCOMP_ASSR_BL_NAME(HtmlInputText COMP_ASSR_BL_NAME) {
		this.COMP_ASSR_BL_NAME = COMP_ASSR_BL_NAME;
	}

	public HtmlOutputLabel getCOMP_ASSR_BL_ADDR1_LABEL() {
		return COMP_ASSR_BL_ADDR1_LABEL;
	}

	public HtmlInputText getCOMP_ASSR_BL_ADDR1() {
		return COMP_ASSR_BL_ADDR1;
	}

	public void setCOMP_ASSR_BL_ADDR1_LABEL(HtmlOutputLabel COMP_ASSR_BL_ADDR1_LABEL) {
		this.COMP_ASSR_BL_ADDR1_LABEL = COMP_ASSR_BL_ADDR1_LABEL;
	}

	public void setCOMP_ASSR_BL_ADDR1(HtmlInputText COMP_ASSR_BL_ADDR1) {
		this.COMP_ASSR_BL_ADDR1 = COMP_ASSR_BL_ADDR1;
	}

	public HtmlOutputLabel getCOMP_ASSR_BL_ADDR2_LABEL() {
		return COMP_ASSR_BL_ADDR2_LABEL;
	}

	public HtmlInputText getCOMP_ASSR_BL_ADDR2() {
		return COMP_ASSR_BL_ADDR2;
	}

	public void setCOMP_ASSR_BL_ADDR2_LABEL(HtmlOutputLabel COMP_ASSR_BL_ADDR2_LABEL) {
		this.COMP_ASSR_BL_ADDR2_LABEL = COMP_ASSR_BL_ADDR2_LABEL;
	}

	public void setCOMP_ASSR_BL_ADDR2(HtmlInputText COMP_ASSR_BL_ADDR2) {
		this.COMP_ASSR_BL_ADDR2 = COMP_ASSR_BL_ADDR2;
	}

	public HtmlOutputLabel getCOMP_ASSR_BL_ADDR3_LABEL() {
		return COMP_ASSR_BL_ADDR3_LABEL;
	}

	public HtmlInputText getCOMP_ASSR_BL_ADDR3() {
		return COMP_ASSR_BL_ADDR3;
	}

	public void setCOMP_ASSR_BL_ADDR3_LABEL(HtmlOutputLabel COMP_ASSR_BL_ADDR3_LABEL) {
		this.COMP_ASSR_BL_ADDR3_LABEL = COMP_ASSR_BL_ADDR3_LABEL;
	}

	public void setCOMP_ASSR_BL_ADDR3(HtmlInputText COMP_ASSR_BL_ADDR3) {
		this.COMP_ASSR_BL_ADDR3 = COMP_ASSR_BL_ADDR3;
	}

	public HtmlOutputLabel getCOMP_ASSR_BL_CONTACT_LABEL() {
		return COMP_ASSR_BL_CONTACT_LABEL;
	}

	public HtmlInputText getCOMP_ASSR_BL_CONTACT() {
		return COMP_ASSR_BL_CONTACT;
	}

	public void setCOMP_ASSR_BL_CONTACT_LABEL(HtmlOutputLabel COMP_ASSR_BL_CONTACT_LABEL) {
		this.COMP_ASSR_BL_CONTACT_LABEL = COMP_ASSR_BL_CONTACT_LABEL;
	}

	public void setCOMP_ASSR_BL_CONTACT(HtmlInputText COMP_ASSR_BL_CONTACT) {
		this.COMP_ASSR_BL_CONTACT = COMP_ASSR_BL_CONTACT;
	}

	public HtmlCommandButton getCOMP_PUSH_BUTTON112() {
		return COMP_PUSH_BUTTON112;
	}

	public void setCOMP_PUSH_BUTTON112(HtmlCommandButton COMP_PUSH_BUTTON112) {
		this.COMP_PUSH_BUTTON112 = COMP_PUSH_BUTTON112;
	}

	public HtmlCommandButton getCOMP_PUSH_BUTTON110() {
		return COMP_PUSH_BUTTON110;
	}

	public void setCOMP_PUSH_BUTTON110(HtmlCommandButton COMP_PUSH_BUTTON110) {
		this.COMP_PUSH_BUTTON110 = COMP_PUSH_BUTTON110;
	}

	public HtmlCommandButton getCOMP_PUSH_BUTTON106() {
		return COMP_PUSH_BUTTON106;
	}

	public void setCOMP_PUSH_BUTTON106(HtmlCommandButton COMP_PUSH_BUTTON106) {
		this.COMP_PUSH_BUTTON106 = COMP_PUSH_BUTTON106;
	}

	public HtmlCommandButton getCOMP_PUSH_BUTTON104() {
		return COMP_PUSH_BUTTON104;
	}

	public void setCOMP_PUSH_BUTTON104(HtmlCommandButton COMP_PUSH_BUTTON104) {
		this.COMP_PUSH_BUTTON104 = COMP_PUSH_BUTTON104;
	}

	public HtmlCommandButton getCOMP_PUSH_BUTTON102() {
		return COMP_PUSH_BUTTON102;
	}

	public void setCOMP_PUSH_BUTTON102(HtmlCommandButton COMP_PUSH_BUTTON102) {
		this.COMP_PUSH_BUTTON102 = COMP_PUSH_BUTTON102;
	}

	public HtmlCommandButton getCOMP_PUSH_BUTTON100() {
		return COMP_PUSH_BUTTON100;
	}

	public void setCOMP_PUSH_BUTTON100(HtmlCommandButton COMP_PUSH_BUTTON100) {
		this.COMP_PUSH_BUTTON100 = COMP_PUSH_BUTTON100;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CUST_CLASS_LOV() {
		return COMP_UI_M_BUT_CUST_CLASS_LOV;
	}

	public void setCOMP_UI_M_BUT_CUST_CLASS_LOV(HtmlCommandButton COMP_UI_M_BUT_CUST_CLASS_LOV) {
		this.COMP_UI_M_BUT_CUST_CLASS_LOV = COMP_UI_M_BUT_CUST_CLASS_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CUST_CODE_LOV() {
		return COMP_UI_M_BUT_CUST_CODE_LOV;
	}

	public void setCOMP_UI_M_BUT_CUST_CODE_LOV(HtmlCommandButton COMP_UI_M_BUT_CUST_CODE_LOV) {
		this.COMP_UI_M_BUT_CUST_CODE_LOV = COMP_UI_M_BUT_CUST_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_LOV_ASSR_OCC() {
		return COMP_UI_M_LOV_ASSR_OCC;
	}

	public void setCOMP_UI_M_LOV_ASSR_OCC(HtmlCommandButton COMP_UI_M_LOV_ASSR_OCC) {
		this.COMP_UI_M_LOV_ASSR_OCC = COMP_UI_M_LOV_ASSR_OCC;
	}

	public PM_ASSURED getPM_ASSURED_BEAN() {
		return PM_ASSURED_BEAN;
	}

	public void setPM_ASSURED_BEAN(PM_ASSURED PM_ASSURED_BEAN) {
		this.PM_ASSURED_BEAN = PM_ASSURED_BEAN;
	}
	
	public String goto_PM_CUSTOMER_ACTION(){
		System.out.println("PM_CUSTOMER_ACTION.goto_PM_CUSTOMER_ACTION()");
		String return_string = "PLM010_goParentBlock";
		return return_string;
	}
	
	
	public String goto_PM_ASSURED_ACTION(){
		System.out.println("PM_CUSTOMER_ACTION.goto_PM_ASSURED_ACTION()");
		String return_string = "PLM010_goChildBlock";
		return return_string;
	}
	
	public ControlBean getCtrlBean(){
		return (ControlBean) getSession().get("ctrlbean");
	}
	public void putCtrlBean(ControlBean bean){
		getSession().put("ctrlbean", bean);
	}
	
	public void createCtrlBean(){
		ControlBean bean = new ControlBean();
		getSession().put("ctrlbean", bean);
	}
	Map sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	DBProcedures procedure=new DBProcedures();
	
	public void FORM_PRE_FORM(){
		try{
		System.out.println("PM_IL_BANK_ACCOUNT_SETUP_ACTION.preForm()-Inside");
		FacesContext facecon = FacesContext.getCurrentInstance();
		Connection connection= null;
		System.out.println("PM_IL_BANK_ACCOUNT_SETUP_ACTION.preForm()");
		// SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,WINDOW_STATE,MAXIMIZE);	
		session= FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		session.put("GLOBAL.M_PRIVILEGE", "YYY");
		session.put("GLOBAL.M_FAILURE", "FALSE");
		session.put("GLOBAL.M_USER_ID", "PREMIA");
		session.put("GLOBAL.M_NAME", "COMPANY NAME..................PROGRAM NAME");
		session.put("GLOBAL.M_LANG_CODE", "ENG");
		session.put("GLOBAL.M_DFLT_VALUES", "00101    01");
		session.put("GLOBAL.M_PARA_1", " ");
		session.put("GLOBAL.M_FOR_LANG_CODE", "ARBR1");
		session.put("GLOBAL.M_MODULE_NAME", "PLM010");
		if(Integer.parseInt(((String)session.get("GLOBAL.M_FOR_LANG_CODE")).substring(4,5))== 1 ){
         System.out.println("PT_IL_POLICY_ACTION.preForm()-NULL");
		}
		connection =CommonUtils.getConnection();
		ctrlBean = getCtrlBean();
		String M_TITLE = ctrlBean.getM_USER_ID()+" "+ctrlBean.getM_SCR_NAME()+" "+new Date();
		P_VAL_SYSTEM.P_VAL_SYSTEM(connection, "ASSRCDGEN", "AUTOMANUAL", "M_CODE_DESC", "E", 1);
	}catch(Exception e){
		e.printStackTrace();
	}
	}
	
	
	public void POST_QUERY(){
		try{
		procedure.helperPKG_PILT002$P_VAL_CODES("OCCUPATION", PM_ASSURED_BEAN.getASSR_OCC_CODE(), PM_ASSURED_BEAN.getUI_M_ASSR_OCC_DESC(), "N","N", null);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	Connection connection=null;
	ResultSet resultSet;
	CommonUtils util=new CommonUtils();
	CRUDHandler handler=new CRUDHandler();
	
	public List getUnitCode_ASSR_OCC_CODE(Object obj) throws Exception{
		List suggestionList = new ArrayList();
		getCOMP_ASSR_OCC_CODE().setSubmittedValue(null);
		String query = null;
		if(obj.toString().equals("*")){
			query = "SELECT ROWID,PC_CODE,PC_DESC,PC_BL_DESC FROM PM_CODES WHERE PC_TYPE = 'OCCUPATION' AND PC_FRZ_FLAG = 'N' and rownum < 50 order by PC_CODE asc";
		}else{
			query = "SELECT ROWID,PC_CODE,PC_DESC,PC_BL_DESC FROM PM_CODES WHERE PC_TYPE = 'OCCUPATION' AND PC_FRZ_FLAG = 'N' and PC_CODE like '"+obj.toString()+"%' and rownum < 50 order by PC_CODE asc";
		}
		connection = util.getConnection();
		resultSet = handler.executeSelectStatement(query, connection);
		resultSet.setFetchSize(25);
		while(resultSet.next()){
			CustomerBean cbean = new CustomerBean();
			cbean.setASSR_OCC_CODE(resultSet.getString("PC_CODE"));
			cbean.setUI_M_ASSR_OCC_DESC(resultSet.getString("PC_DESC"));
			suggestionList.add(cbean);
		}
		resultSet.close();
		return suggestionList;
	}
	
	public void onclickASSR_FRZ_FLAG(ActionEvent event) {
		UIInput component = (UIInput) event.getComponent().getParent();
		String ASSR_FRZ_FLAG = (String) component.getSubmittedValue();
System.out.println("PM_ASSURED_ACTION.onclickASSR_FRZ_FLAG() ASSR_FRZ_FLAG: "+ASSR_FRZ_FLAG);		
		if("true".equals(ASSR_FRZ_FLAG)) {
			PM_ASSURED_BEAN.setASSR_FRZ_FLAG("Y");
		} else {
			PM_ASSURED_BEAN.setASSR_FRZ_FLAG("N");
		}
	}
	
	 public void M_ASSR_OCC_DESC_when_validateListener(ActionEvent ae) throws Exception{
		 
		 PM_ASSURED_BEAN.setASSR_OCC_CODE(getCOMP_ASSR_OCC_CODE().getSubmittedValue().toString().trim());
		 
		 DBProcedures procedures = new DBProcedures();
		 if(PM_ASSURED_BEAN.getASSR_OCC_CODE() != null ){
			 if(PM_ASSURED_BEAN.getASSR_OCC_CODE().equals("")){
				 PM_ASSURED_BEAN.setUI_M_ASSR_OCC_DESC("");
			 }else{
				 if(checkASSR_OCC_CODE(PM_ASSURED_BEAN.getASSR_OCC_CODE())){
					 validate_Error=false;
					 getErrorMap().clear();
					 PM_ASSURED_BEAN.setUI_M_ASSR_OCC_DESC(procedures.P_VAL_CODES_PM_CHARGER("OCCUPATION", PM_ASSURED_BEAN.getASSR_OCC_CODE(), PM_ASSURED_BEAN.getUI_M_ASSR_OCC_DESC(),"N","E",null).get(0));
				 }else{
					 validate_Error=true;
					 getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "80302").getDetail());
				 }
			 }
		 }else{
			 PM_ASSURED_BEAN.setUI_M_ASSR_OCC_DESC(null);
		 }
	 }
	 
	 public boolean checkASSR_OCC_CODE(String assr_Code){
		 ResultSet rs =  null;
		 boolean status = false;
		 String query = "select * from PM_CODES WHERE PC_TYPE = 'OCCUPATION' AND PC_FRZ_FLAG = 'N' and PC_CODE = '"+assr_Code+"'";
		 System.out.println("Select Query >. "+query);
		 try{
			 rs =  handler.executeSelectStatement(query, CommonUtils.getConnection());
			 if(rs.next()){
				 status = true;
			 }
		 }catch (Exception e) {
			 e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		 return status;
	 }
	 
	 
	
	/*public List<SelectItem> getCOMP_PROD_PRODUCTION_BASIS_YN_LIST() {
		if (COMP_PROD_PRODUCTION_BASIS_YN_LIST.size() ==0)
		  { 
			COMP_PROD_PRODUCTION_BASIS_YN_LIST.clear();
			COMP_PROD_PRODUCTION_BASIS_YN_LIST = ListItemUtil.getDropDownListValue(getConnection(),"PGLM025","PM_GL_PRODUCT","PM_GL_PRODUCT.PROD_PRODUCTION_BASIS_YN","YESNO");
		  }
		return COMP_PROD_PRODUCTION_BASIS_YN_LIST;
	}*/
	 
	 
	 DUMMY dummy=new DUMMY();
	public void PRE_INSERT(){
		System.out.println("PM_ASSURED_ACTION.PRE_INSERT()");
		 try{
		PM_ASSURED_BEAN.setPC_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		PM_ASSURED_BEAN.setPC_CR_DT(util.getCurrentDate());
		
		if(dummy.getM_AUTOMANUAL()==1){
			getCOMP_ASSR_CODE().setDisabled(false);
			getCOMP_ASSR_CODE().setRequired(true);
			 String sql_query3="SELECT TO_CHAR(P_ASSR_CODE.NEXTVAL) FROM DUAL";
			 ResultSet rs2;
			 rs2=handler.executeSelectStatement(sql_query3, util.getConnection());
			 if(rs2.next()){
				 PM_ASSURED_BEAN.setASSR_CODE(rs2.getString(1));
			 }
			 
		}else{
			//L_UNIQUE_CODE;
		}
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}
	
	
	public void WHEN_NEW_RECORD_INSTANCE(){
		if(dummy.getM_AUTOMANUAL()==1){
			getCOMP_ASSR_CODE().setDisabled(true);
		}else{
				if(!(getCOMP_ASSR_CODE().isDisabled())==true){
					
					getCOMP_ASSR_CODE().setDisabled(false);
					getCOMP_ASSR_CODE().setRequired(true);
				}
		}
	}
	
	public void PRE_UPDATE(){
		System.out.println("PM_ASSURED_ACTION.PRE_UPDATE()");
		try{
		PM_ASSURED_BEAN.setPC_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		PM_ASSURED_BEAN.setPC_CR_DT(util.getCurrentDate());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public List<SelectItem> getDFLT_YN_LIST() {
		
		if (DFLT_YN_LIST.size() ==0)
		  { 
			try {
				DFLT_YN_LIST = ListItemUtil.getDropDownListValue(util.getConnection(),"PLM010","PM_ASSURED","PM_ASSURED.ASSR_DFLT_YN","YESNO");
			} catch (DBException e) {
				e.printStackTrace();
			}
		  }
		return DFLT_YN_LIST;
	} 

	public void setDFLT_YN_LIST(List<SelectItem> dflt_yn_list) {
		DFLT_YN_LIST = dflt_yn_list;
	}
	
	
	public List getUnitCode_M_CUST_CODE(Object obj) throws Exception{
		List suggestionList = new ArrayList();
		getCOMP_ASSR_CUST_CODE().setSubmittedValue(null);
		String query = null;
		if(obj.toString().equals("*")){  
			query = "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER WHERE CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS WHERE CCLAS_TYPE IN ('005','001','002','003','004','006'))AND CUST_FRZ_FLAG ='N' and rownum < 50 order by CUST_CODE asc";
		}else{
			query = "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER WHERE CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS WHERE CCLAS_TYPE IN ('005','001','002','003','004','006'))AND CUST_FRZ_FLAG ='N' and CUST_CODE like '"+obj.toString()+"%' and rownum < 50 order by CUST_CODE asc";
		}
		connection = CommonUtils.getConnection();
		resultSet = handler.executeSelectStatement(query, connection);
		resultSet.setFetchSize(25);
		while(resultSet.next()){
			CustomerBean cbean = new CustomerBean();
			cbean.setCUST_CODE(resultSet.getString("CUST_CODE"));
			cbean.setCUST_NAME(resultSet.getString("CUST_NAME"));
			suggestionList.add(cbean);
		}
		System.out.println("Bean"+PM_ASSURED_BEAN.getASSR_CUST_CODE());
		resultSet.close();
		return suggestionList;
	}
	
	public void M_CUST_CLASS_DESC_when_validateListener(ActionEvent ae) throws Exception{
		System.out.println("Submitted value"+COMP_ASSR_CUST_CODE.getSubmittedValue());
		String CCLAS_CLASS_DESC = getCOMP_ASSR_CUST_CODE().getSubmittedValue().toString().trim();
		if(!CCLAS_CLASS_DESC.equals("")){
			String query = "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER WHERE CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS WHERE CCLAS_TYPE IN ('005','001','002','003','004','006'))AND CUST_FRZ_FLAG ='N' " +
			"AND CUST_CODE ='"+CCLAS_CLASS_DESC+"'";
			System.out.println("the query is "+query);
			Connection con = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, con);
			if(resultSet.next()){
				System.out.println("Inside while Loop");
				validate_Error=false;
				getErrorMap().clear();
				PM_ASSURED_BEAN.setCUST_NAME(resultSet.getString("CUST_NAME"));
			}else{
				validate_Error=true;
				getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "80302").getDetail());
			}
			resultSet.close();  
		}else{
				PM_ASSURED_BEAN.setCUST_NAME("");
				getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "1007").getDetail());				
		}
	}
	
	/*public boolean checkCUST_CLASS_CODE(String cust_Code){
		 ResultSet rs =  null;
		 boolean status = false;
		 
		 String query = "SELECT * FROM PM_CUSTOMER WHERE CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS WHERE " +
		 				"CCLAS_TYPE IN ('005','001','002','003','004','006'))AND CUST_FRZ_FLAG ='N' " +
		 				"and CUST_CODE = '"+cust_Code+"'";
		 System.out.println("Select Query >. "+query);
		 try{
			 rs =  handler.executeSelectStatement(query, CommonUtils.getConnection());
			 if(rs.next()){
				 status = true;
			 }
		 }catch (Exception e) {
			 e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("status is "+status);
		return status;
	 }*/
	
	/*public void saveRecord(ActionEvent event){
		System.out.println("PM_CUSTOMER_ACTION.SaveRecord()");
		  
		try{ 
			if(PM_ASSURED_BEAN.getROWID() == null){
				handler.executeInsert(PM_ASSURED_BEAN, util.getConnection());	
			}else{
				handler.executeUpdate(PM_ASSURED_BEAN, util.getConnection());
			}
		 
		 connection.commit();
		 connection.close();
		
		}
		catch(Exception e){
		  e.printStackTrace();	
		}
		
	}*/
	
	public void saveRecord(ActionEvent event)
	{
		if(PM_ASSURED_BEAN.getROWID()==null){
			PRE_INSERT();
		}else{
			PRE_UPDATE();
		}
		System.out.println("size of warrning map"+getWarningMap().size());
		if(getWarningMap().size()==0 && !validate_Error){
			System.out.println("Flag in insert .... " +!validate_Error);
			PM_ASSURED custClass=getPM_ASSURED_BEAN();
			if(custClass.isInsertMode()){
				System.out.println("freeze is "+custClass.getASSR_FRZ_FLAG());
				System.out.println("y/n is "+custClass.getASSR_DFLT_YN());
				int i=executeInsert(custClass);
				if(i>0)
				{
					getPM_ASSURED_BEAN().setInsertMode(false);	
					getWarningMap().put("current","Record Inserted");
				}
			}
			else
			{
				int i=executeUpdate(custClass);
				getWarningMap().put("current","Record Updated");
			}
			POST_QUERY();
		}
		else{
			System.out.println("Flag in insert .Else Part ... " +!validate_Error);
			System.out.println("Size is not empty............");
		}
	}
	
	/*public void deleteRecord(ActionEvent event){
		System.out.println("PM_ASSURED_ACTION.deleteRecord()");
		try{
			connection=CommonUtils.getConnection();
			PM_ASSURED custClass=getPM_ASSURED_BEAN();
			int n = handler.executeDelete(custClass, connection);
			connection.commit();
			getWarningMap().put("current","Record Deleted");
			connection.close(); 
			PM_ASSURED_BEAN =new PM_ASSURED();
		}
		catch(Exception e){
		  e.printStackTrace();	
		}
		
	}*/
	
	/*public String deleteRow()
	{
		PM_ASSURED bean = null;
		ArrayList deletedRecordList = null;
		int deletedRecordIndex = 0;
		if(namesList!=null)
		{
			deletedRecordList = new ArrayList();
			for(int index =0; index<namesList.size();)
			{
				bean = namesList.get(index);
				if(bean.isCheckBoxSelected()){
					deletedRecordList.add(bean);
					namesList.remove(bean); 
					
				}else
				{
					index++;
				}
			}
			if(deletedRecordList.size()>0)
			{
				executeDelete(deletedRecordList);
				deletedRecordList.clear();
			}
			
			lastUpdatedRowIndex = -1;
		}
		deletedRecordList.clear();
		return "";
}*/
	
	public int executeInsert(Object object)
	{
		Connection connection=null;
		int recordCount=0;
		try 
		{
			//connection=ConnectionAgent.getCurrentInstance().getConnection();
			connection=CommonUtils.getConnection();
			CRUDHandler handler=new CRUDHandler();
			recordCount=handler.executeInsert(object,connection);
			connection.commit();
			
		} catch (Exception e)
		{
			try{
			connection.rollback();}catch(Exception ae){ae.printStackTrace();}
			e.printStackTrace();
		}
		return recordCount;
	}
	
	public int executeUpdate(Object object)
	{
		
		Connection connection=null;
		int updateRecords=0;
		try 
		{
			
			//connection=ConnectionAgent.getCurrentInstance().getConnection();
			connection=CommonUtils.getConnection();
			CRUDHandler handler=new CRUDHandler();
			//String updateQuery="UPDATE  PM_CUST_CLASS SET CCLAS_CLASS_DESC='"+pm_cust_class.getCCLAS_CLASS_DESC()+"',CCLAS_SHORT_CLASS_DESC='"+pm_cust_class.getCCLAS_SHORT_CLASS_DESC()+"',CCLAS_FRZ_FLAG='"+pm_cust_class.getCCLAS_FRZ_FLAG()+"',CCLAS_NGS_CODE='"+pm_cust_class.getCCLAS_NGS_CODE()+"',CCLAS_VAL_IC_YN='"+pm_cust_class.getCCLAS_VAL_IC_YN()+"',CCLAS_BROK_AGENT_YN='"+pm_cust_class.getCCLAS_BROK_AGENT_YN()+"' WHERE CCLAS_CODE='"+pm_cust_class.getCCLAS_CODE()+"'";
			updateRecords=handler.executeUpdate(object, connection);
			//updateRecords=handler.executeUpdateStatement(PM020_A_TISB_QUERY_CONSTANT.CUSTOMER_APPL_UPDATE_QUERY,connection,new Object[]{pm_cust_class.getCCLAS_CLASS_DESC(),pm_cust_class.getCCLAS_SHORT_CLASS_DESC(),pm_cust_class.getCCLAS_NGS_CODE(),pm_cust_class.getCCLAS_VAL_IC_YN(),pm_cust_class.getCCLAS_BROK_AGENT_YN(),pm_cust_class.getCCLAS_CODE()});
			if(updateRecords>0)
			{
				connection.commit();
			}
		} 
		catch (Exception e)
		{
			try {
				connection.rollback();
			} catch (Exception se) {
				// TODO: handle exception
			}
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				//connection.close();
			} catch (Exception se) {
				
			}
		}
		
		return updateRecords;
		
	}
	
	/*public int executeDelete(List<PM_ASSURED> deleteList)
	{
		CRUDHandler handler=new CRUDHandler();
		Connection connection=null;
		int recordDeleted=0;
		try{
		connection=CommonUtils.getConnection();
		for(int listidx=0;listidx<deleteList.size();listidx++)
		{
			PM_ASSURED pm_cust_class=deleteList.get(listidx);
			recordDeleted=handler.executeDelete(pm_cust_class, connection);
		}
		deleteList=null;
		connection.commit();
		}
		catch(Exception e){e.printStackTrace();try {
			connection.rollback();
		} catch (Exception se) {
			se.printStackTrace();
		}}
		return recordDeleted;
	}*/
	
	public void agentYNEvent(ActionEvent event)
	{
		UIInput input=(UIInput)event.getComponent().getParent();
		String agentValue=(String)input.getSubmittedValue();
		getPM_ASSURED_BEAN().setASSR_DFLT_YN(agentValue);
		ErrorHelpUtil.validate(input,getErrorMap());
	}

	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}

	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	}

	public ArrayList<PM_ASSURED> getNamesList() {
		return namesList;
	}

	public void setNamesList(ArrayList<PM_ASSURED> namesList) {
		this.namesList = namesList;
	}
	
	public void when_validate_assr_code(ActionEvent actionEvent){
		System.out.println("PT_IL_POLICY_ACTION.when_validate_rein_code()");
		String mappedBeanName="PLM010_PM_ASSURED_ACTION";
		PM_ASSURED_ACTION actionBean=(PM_ASSURED_ACTION)util.getMappedBeanFromSession(mappedBeanName);
		Map<String, String> errMap = actionBean.getErrorMap();
		try{
		ResultSet rs_validate;
		PM_ASSURED_BEAN.setASSR_CUST_CODE(getCOMP_ASSR_CUST_CODE().getSubmittedValue().toString());
		PM_ASSURED_BEAN.setASSR_CODE(getCOMP_ASSR_CODE().getSubmittedValue().toString());
		
		String assr_cust_codevalidate=PM_ASSURED_BEAN.getASSR_CUST_CODE();
		String assr_codevalidate=PM_ASSURED_BEAN.getASSR_CODE().trim();
		String sql_validate="SELECT 'X' FROM PM_ASSURED WHERE ASSR_CUST_CODE = '"+assr_cust_codevalidate+"' " +
				"AND ASSR_CODE ='"+assr_codevalidate+"'";
		System.out.println("sql_validate is "+sql_validate);
		rs_validate =handler.executeSelectStatement(sql_validate, util.getConnection());
		
		if(rs_validate.next()){
			validate_Error=true;
			
			System.out.println("Duplicate Value Found..... Flag is " + validate_Error);
			getWarningMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "1235",new Object[]{assr_cust_codevalidate}).getDetail());
		}else{
			validate_Error=false;
			
			System.out.println("..... Flag is..set to True !!!!.. " + validate_Error);
			
		}
		if(assr_codevalidate==null || assr_codevalidate=="" ||assr_codevalidate.length()==0 ){
			getWarningMap().put("current","Assured Code Should Not Empty");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	} 

	public void when_validate_assr_code_validator(FacesContext context, UIComponent component,Object value) throws ValidatorException,Exception{
		System.out.println("PT_IL_POLICY_ACTION.when_validate_rein_code()");
		String mappedBeanName="PLM010_PM_ASSURED_ACTION";
		PM_ASSURED_ACTION actionBean=(PM_ASSURED_ACTION)util.getMappedBeanFromSession(mappedBeanName);
		Map<String, String> errMap = actionBean.getErrorMap();
		try{
		ResultSet rs_validate;
		String assr_cust_codevalidate=PM_ASSURED_BEAN.getASSR_CUST_CODE();
		String assr_codevalidate=PM_ASSURED_BEAN.getASSR_CODE().trim();
		String sql_validate="SELECT 'X' FROM PM_ASSURED WHERE ASSR_CUST_CODE = '"+assr_cust_codevalidate+"' " +
				"AND ASSR_CODE ='"+assr_codevalidate+"'";
		System.out.println("sql_validate is "+sql_validate);
		rs_validate =handler.executeSelectStatement(sql_validate, util.getConnection());
		
		if(rs_validate.next()){
			validate_Error=true;
			getWarningMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "1235").getDetail());
		}else{
			validate_Error=false;
			getWarningMap().clear();
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	} 

	public void when_validate_cust_code(ActionEvent actionEvent){
		System.out.println("PM_ASSURED_ACTION.when_validate_cust_code()");
		String mappedBeanName="PLM010_PM_ASSURED_ACTION";
		PM_ASSURED_ACTION actionBean=(PM_ASSURED_ACTION)util.getMappedBeanFromSession(mappedBeanName);
		Map<String, String> errMap = actionBean.getErrorMap();
		try{
		String cust_code=getCOMP_ASSR_CUST_CODE().getSubmittedValue().toString();
		System.out.println("cust_code is"+cust_code);
		PM_ASSURED_BEAN.setASSR_CUST_CODE(cust_code);
		System.out.println("From The Besn"+ PM_ASSURED_BEAN.getASSR_CUST_CODE());
		if(cust_code==null ||cust_code==""){
			System.out.println("inside if condition");
			getWarningMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "1007").getDetail());
		}else{
			getWarningMap().clear();
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public void when_validate_assr_name(ActionEvent actionEvent){
		
		try{
		String assr_name=getCOMP_ASSR_NAME().getSubmittedValue().toString().trim();
		System.out.println("cust_code is"+assr_name);
		System.out.println("Lenght of Assr Name" + assr_name.length());
		PM_ASSURED_BEAN.setASSR_NAME(assr_name);
		if(assr_name==null ||assr_name=="" || assr_name.length()==0 ){
			System.out.println("inside if condition");
			getWarningMap().put("current", "Assured Name Should Not Empty");
		}else{
			getWarningMap().clear();
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void when_validate_assr_addr(ActionEvent actionEvent){
		
		try{
		String assr_addr=getCOMP_ASSR_ADDR1().getSubmittedValue().toString().trim();
		System.out.println("cust_code is"+assr_addr);
		PM_ASSURED_BEAN.setASSR_ADDR1(assr_addr);
		System.out.println("From The Besn"+ PM_ASSURED_BEAN.getASSR_CUST_CODE());
		if(assr_addr==null ||assr_addr=="" || assr_addr.length()==0){
			System.out.println("inside if condition");
			getWarningMap().put("current", "Assured Address Should Not Empty");
		}else{
			getWarningMap().clear();
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
/*public void when_validate_assr_occu_code(ActionEvent actionEvent){
		
		try{
		String assr_occu_code=getCOMP_ASSR_OCC_CODE().getSubmittedValue().toString();
		System.out.println("cust_code is"+assr_occu_code);
		PM_ASSURED_BEAN.setASSR_OCC_CODE(assr_occu_code);
		System.out.println("From The Besn"+ PM_ASSURED_BEAN.getASSR_CUST_CODE());
		if(assr_occu_code==null ||assr_occu_code==""){
			System.out.println("Desc Clearing");
			getCOMP_UI_M_ASSR_OCC_DESC().setValue("");
			getCOMP_UI_M_ASSR_OCC_DESC().setSubmittedValue("");
			PM_ASSURED_BEAN.setUI_M_ASSR_OCC_DESC(""); 
		}		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}*/
	
	
	public String searchPage()
	{
		String actionString=null;
		CommonUtils util=new CommonUtils();
		util.callRetaintion("PLM010_SEARCH_ACTION", "fetchCustomerDetails");
		
		return "PLM010_SearchPage";
	}
	
	public void when_validate_dob(ActionEvent actionEvent){
		System.out.println("PM_ASSURED_ACTION.when_validate_dob()");
		try{
		Date dob=(Date)getCOMP_ASSR_DOB().getSubmittedValue();
		System.out.println("from jsp "+dob);
		Date currentDate=util.getCurrentDate();
		System.out.println("from util"+currentDate);
		if(dob.after(currentDate)){
			getWarningMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "2181").getDetail());
		}else{
			getWarningMap().clear();	
		}	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void dob_dt_when_validate_item(ActionEvent actionEvent) {
		String mappedBeanName="PLM010_PM_ASSURED_ACTION";
		System.out.println("in helper");
		CommonUtils utility=new CommonUtils();
		PM_ASSURED_ACTION actionBean=(PM_ASSURED_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		Map<String, String> errMap = actionBean.getErrorMap(); 
		Date dobDate=actionBean.getCOMP_ASSR_DOB().getAsDate(actionBean.getCOMP_ASSR_DOB().getSubmittedValue());
		actionBean.getPM_ASSURED_BEAN().setASSR_DOB(dobDate);
		try {
			Date currentDate=utility.getCurrentDate();
			System.out.println(dobDate+"**"+currentDate);
			if(dobDate.after(currentDate)){
				validate_Error=true;
				getWarningMap().put("current", "DOB Should Not Be Greater Than Current Date");
			
			}else{
				validate_Error=false;
				getWarningMap().clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	public void UI_M_DOB_DT_whenValidateItem(ActionEvent actionEvent){
			
			System.out.println("when validate from date on blur");
			HtmlCalendar fromCalendarComponent=(HtmlCalendar)(actionEvent.getComponent().getParent());
			
			System.out.println(fromCalendarComponent.getAsDate(fromCalendarComponent.getSubmittedValue().toString()));
			this.PM_ASSURED_BEAN.setASSR_DOB(fromCalendarComponent.getAsDate(fromCalendarComponent.getSubmittedValue().toString()));
		}
		
	public void assr_code_save(){
		System.out.println("PT_IL_POLICY_ACTION.when_validate_rein_code()");
		String mappedBeanName="PLM010_PM_ASSURED_ACTION";
		PM_ASSURED_ACTION actionBean=(PM_ASSURED_ACTION)util.getMappedBeanFromSession(mappedBeanName);
		Map<String, String> errMap = actionBean.getErrorMap();
		try{
		ResultSet rs_validate;
		String assr_cust_codevalidate=PM_ASSURED_BEAN.getASSR_CUST_CODE();
		String assr_codevalidate=PM_ASSURED_BEAN.getASSR_CODE().toString().trim();
		String sql_validate="SELECT 'X' FROM PM_ASSURED WHERE ASSR_CUST_CODE = '"+assr_cust_codevalidate+"' " +
				"AND ASSR_CODE ='"+assr_codevalidate+"'";
		System.out.println("sql_validate is "+sql_validate);
		rs_validate =handler.executeSelectStatement(sql_validate, util.getConnection());
		
		if(rs_validate.next()){
			getWarningMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "1235").getDetail());
		}else{
			getWarningMap().clear();
		}
		if(assr_codevalidate==null || assr_codevalidate=="" ||assr_codevalidate.length()==0 ){
			getWarningMap().put("current","Assured Code Should Not Empty");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
}
