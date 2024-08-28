package com.iii.pel.forms.PILT042_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.UICalendar;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT006_APAC.PT_IL_CLAIM;
import com.iii.pel.forms.PILT006_APAC.PT_IL_CLAIM_HELPER;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_PRE_CLAIMS_INFO_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PCI_ASSRD_REF_ID2_LABEL;

	private HtmlInputText COMP_PCI_ASSRD_REF_ID2;

	private HtmlOutputLabel COMP_PCI_ASSRD_REF_ID1_LABEL;

	private HtmlInputText COMP_PCI_ASSRD_REF_ID1;

	private HtmlOutputLabel COMP_PCI_POL_NO_LABEL;

	private HtmlInputText COMP_PCI_POL_NO;

	private HtmlOutputLabel COMP_PCI_CLAIM_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_PCI_CLAIM_TYPE;

	private HtmlOutputLabel COMP_PCI_LOSS_DT_LABEL;

	private HtmlCalendar COMP_PCI_LOSS_DT;

	private HtmlOutputLabel COMP_PCI_REPORT_DT_LABEL;

	private HtmlCalendar COMP_PCI_REPORT_DT;

	private HtmlOutputLabel COMP_PCI_INTIMATION_MODE_LABEL;

	private HtmlInputText COMP_PCI_INTIMATION_MODE;

	private HtmlOutputLabel COMP_UI_M_PCI_INTIMATION_MODE_LABEL;

	private HtmlInputText COMP_UI_M_PCI_INTIMATION_MODE;

	private HtmlOutputLabel COMP_PCI_REF_NO_LABEL;

	private HtmlInputText COMP_PCI_REF_NO;

	private HtmlOutputLabel COMP_PCI_RES_ADDRESS_1_LABEL;

	private HtmlInputText COMP_PCI_RES_ADDRESS_1;

	private HtmlOutputLabel COMP_PCI_RES_ADDRESS_2_LABEL;

	private HtmlInputText COMP_PCI_RES_ADDRESS_2;

	private HtmlOutputLabel COMP_PCI_RES_ADDRESS_3_LABEL;

	private HtmlInputText COMP_PCI_RES_ADDRESS_3;

	private HtmlOutputLabel COMP_UI_M_RES_AREA_NAME_LABEL;

	private HtmlInputText COMP_UI_M_RES_AREA_NAME;

	private HtmlOutputLabel COMP_PCI_RES_AREA_CODE_LABEL;

	private HtmlInputText COMP_PCI_RES_AREA_CODE;

	private HtmlOutputLabel COMP_UI_M_PCI_CITY_NAME_LABEL;

	private HtmlInputText COMP_UI_M_PCI_CITY_NAME;

	private HtmlOutputLabel COMP_PCI_CITY_CODE_LABEL;

	private HtmlInputText COMP_PCI_CITY_CODE;

	private HtmlOutputLabel COMP_PCI_COUNTRY_CODE_LABEL;

	private HtmlInputText COMP_PCI_COUNTRY_CODE;

	private HtmlOutputLabel COMP_UI_M_PCI_COUNTRY_CODE_LABEL;

	private HtmlInputText COMP_UI_M_PCI_COUNTRY_CODE;

	private HtmlOutputLabel COMP_PCI_STATE_CODE_LABEL;

	private HtmlInputText COMP_PCI_STATE_CODE;

	private HtmlOutputLabel COMP_UI_M_PCI_STATE_CODE_LABEL;

	private HtmlInputText COMP_UI_M_PCI_STATE_CODE;

	private HtmlOutputLabel COMP_PCI_ACTION_TAKEN_LABEL;

	/*
	 * Commented by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 22-03-2017
	 * private HtmlInputText COMP_PCI_ACTION_TAKEN;*/

	private HtmlOutputLabel COMP_PCI_REMARKS_LABEL;

	// added by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 16/03/2017

	public HtmlInputTextarea getCOMP_PCI_REMARKS() {
		return COMP_PCI_REMARKS;
	}

	public void setCOMP_PCI_REMARKS(HtmlInputTextarea cOMP_PCI_REMARKS) {
		COMP_PCI_REMARKS = cOMP_PCI_REMARKS;
	}
	private HtmlOutputLabel COMP_UI_M_PCI_CUST_NAME_LABEL;

	private HtmlInputText COMP_UI_M_PCI_CUST_NAME;
	
	// added by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 16/03/2017
	private HtmlInputText COMP_UI_M_PCI_CUST_CODE;
	private HtmlInputTextarea COMP_PCI_REMARKS;
	
	private HtmlInputTextarea COMP_PCI_ACTION_TAKEN;
	
	
	public HtmlInputTextarea getCOMP_PCI_ACTION_TAKEN() {
		return COMP_PCI_ACTION_TAKEN;
	}

	public void setCOMP_PCI_ACTION_TAKEN(HtmlInputTextarea cOMP_PCI_ACTION_TAKEN) {
		COMP_PCI_ACTION_TAKEN = cOMP_PCI_ACTION_TAKEN;
	}

	
	
	/*End*/
	
	private List<PT_IL_CLAIM> suggestionList = null;
		
	public HtmlInputText getCOMP_UI_M_PCI_CUST_CODE() {
		return COMP_UI_M_PCI_CUST_CODE;
	}

	public void setCOMP_UI_M_PCI_CUST_CODE(HtmlInputText cOMP_UI_M_PCI_CUST_CODE) {
		COMP_UI_M_PCI_CUST_CODE = cOMP_UI_M_PCI_CUST_CODE;
	}
	//end
	private HtmlOutputLabel COMP_PCI_ASSRD_CODE_LABEL;

	private HtmlInputText COMP_PCI_ASSRD_CODE;
	
	private HtmlInputText COMP_UI_M_PCI_ASSRD_NAME;

	private PT_IL_PRE_CLAIMS_INFO PT_IL_PRE_CLAIMS_INFO_BEAN;

	private List<PT_IL_PRE_CLAIMS_INFO> lovListValue = null;

	List<SelectItem> itemListPCI_CLAIM_TYPE=null;

	private ControlBean controlBean = null;

	private boolean CHECKDOCNO;
	
	private PILT042_APAC_HELPER helper;

	public PT_IL_PRE_CLAIMS_INFO_ACTION() {
		PT_IL_PRE_CLAIMS_INFO_BEAN = new PT_IL_PRE_CLAIMS_INFO();
		helper = new PILT042_APAC_HELPER();
		try {
			itemListPCI_CLAIM_TYPE = PILT042_APAC_DELEGATE.getDropDownListValue("PILT042_APAC", "PT_IL_PRE_CLAIMS_INFO", "PT_IL_PRE_CLAIMS_INFO.PCI_CLAIM_TYPE", "CLMTYPE");
		} catch (Exception e) {
			e.printStackTrace();
		}
		controlBean = (ControlBean) CommonUtils.getControlBean().clone();
		
/* Added by Janani on 25.05.2017 for  ZBILQC-1727100*/
		
		instantiateAllcomponent();
		setListItemValues();
		/*End*/
	}

	public HtmlOutputLabel getCOMP_PCI_ASSRD_REF_ID2_LABEL() {
		return COMP_PCI_ASSRD_REF_ID2_LABEL;
	}

	public HtmlInputText getCOMP_PCI_ASSRD_REF_ID2() {
		return COMP_PCI_ASSRD_REF_ID2;
	}

	public void setCOMP_PCI_ASSRD_REF_ID2_LABEL(HtmlOutputLabel COMP_PCI_ASSRD_REF_ID2_LABEL) {
		this.COMP_PCI_ASSRD_REF_ID2_LABEL = COMP_PCI_ASSRD_REF_ID2_LABEL;
	}

	public void setCOMP_PCI_ASSRD_REF_ID2(HtmlInputText COMP_PCI_ASSRD_REF_ID2) {
		this.COMP_PCI_ASSRD_REF_ID2 = COMP_PCI_ASSRD_REF_ID2;
	}

	public HtmlOutputLabel getCOMP_PCI_ASSRD_REF_ID1_LABEL() {
		return COMP_PCI_ASSRD_REF_ID1_LABEL;
	}

	public HtmlInputText getCOMP_PCI_ASSRD_REF_ID1() {
		return COMP_PCI_ASSRD_REF_ID1;
	}

	public void setCOMP_PCI_ASSRD_REF_ID1_LABEL(HtmlOutputLabel COMP_PCI_ASSRD_REF_ID1_LABEL) {
		this.COMP_PCI_ASSRD_REF_ID1_LABEL = COMP_PCI_ASSRD_REF_ID1_LABEL;
	}

	public void setCOMP_PCI_ASSRD_REF_ID1(HtmlInputText COMP_PCI_ASSRD_REF_ID1) {
		this.COMP_PCI_ASSRD_REF_ID1 = COMP_PCI_ASSRD_REF_ID1;
	}

	public HtmlOutputLabel getCOMP_PCI_POL_NO_LABEL() {
		return COMP_PCI_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_PCI_POL_NO() {
		return COMP_PCI_POL_NO;
	}

	public void setCOMP_PCI_POL_NO_LABEL(HtmlOutputLabel COMP_PCI_POL_NO_LABEL) {
		this.COMP_PCI_POL_NO_LABEL = COMP_PCI_POL_NO_LABEL;
	}

	public void setCOMP_PCI_POL_NO(HtmlInputText COMP_PCI_POL_NO) {
		this.COMP_PCI_POL_NO = COMP_PCI_POL_NO;
	}

	public HtmlOutputLabel getCOMP_PCI_CLAIM_TYPE_LABEL() {
		return COMP_PCI_CLAIM_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PCI_CLAIM_TYPE() {
		return COMP_PCI_CLAIM_TYPE;
	}

	public void setCOMP_PCI_CLAIM_TYPE_LABEL(HtmlOutputLabel COMP_PCI_CLAIM_TYPE_LABEL) {
		this.COMP_PCI_CLAIM_TYPE_LABEL = COMP_PCI_CLAIM_TYPE_LABEL;
	}

	public void setCOMP_PCI_CLAIM_TYPE(HtmlSelectOneMenu COMP_PCI_CLAIM_TYPE) {
		this.COMP_PCI_CLAIM_TYPE = COMP_PCI_CLAIM_TYPE;
	}

	public HtmlOutputLabel getCOMP_PCI_LOSS_DT_LABEL() {
		return COMP_PCI_LOSS_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PCI_LOSS_DT() {
		return COMP_PCI_LOSS_DT;
	}

	public void setCOMP_PCI_LOSS_DT_LABEL(HtmlOutputLabel COMP_PCI_LOSS_DT_LABEL) {
		this.COMP_PCI_LOSS_DT_LABEL = COMP_PCI_LOSS_DT_LABEL;
	}

	public void setCOMP_PCI_LOSS_DT(HtmlCalendar COMP_PCI_LOSS_DT) {
		this.COMP_PCI_LOSS_DT = COMP_PCI_LOSS_DT;
	}

	public HtmlOutputLabel getCOMP_PCI_REPORT_DT_LABEL() {
		return COMP_PCI_REPORT_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PCI_REPORT_DT() {
		return COMP_PCI_REPORT_DT;
	}

	public void setCOMP_PCI_REPORT_DT_LABEL(HtmlOutputLabel COMP_PCI_REPORT_DT_LABEL) {
		this.COMP_PCI_REPORT_DT_LABEL = COMP_PCI_REPORT_DT_LABEL;
	}

	public void setCOMP_PCI_REPORT_DT(HtmlCalendar COMP_PCI_REPORT_DT) {
		this.COMP_PCI_REPORT_DT = COMP_PCI_REPORT_DT;
	}

	public HtmlOutputLabel getCOMP_PCI_INTIMATION_MODE_LABEL() {
		return COMP_PCI_INTIMATION_MODE_LABEL;
	}

	public HtmlInputText getCOMP_PCI_INTIMATION_MODE() {
		return COMP_PCI_INTIMATION_MODE;
	}

	public void setCOMP_PCI_INTIMATION_MODE_LABEL(HtmlOutputLabel COMP_PCI_INTIMATION_MODE_LABEL) {
		this.COMP_PCI_INTIMATION_MODE_LABEL = COMP_PCI_INTIMATION_MODE_LABEL;
	}

	public void setCOMP_PCI_INTIMATION_MODE(HtmlInputText COMP_PCI_INTIMATION_MODE) {
		this.COMP_PCI_INTIMATION_MODE = COMP_PCI_INTIMATION_MODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PCI_INTIMATION_MODE_LABEL() {
		return COMP_UI_M_PCI_INTIMATION_MODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PCI_INTIMATION_MODE() {
		return COMP_UI_M_PCI_INTIMATION_MODE;
	}

	public void setCOMP_UI_M_PCI_INTIMATION_MODE_LABEL(HtmlOutputLabel COMP_UI_M_PCI_INTIMATION_MODE_LABEL) {
		this.COMP_UI_M_PCI_INTIMATION_MODE_LABEL = COMP_UI_M_PCI_INTIMATION_MODE_LABEL;
	}

	public void setCOMP_UI_M_PCI_INTIMATION_MODE(HtmlInputText COMP_UI_M_PCI_INTIMATION_MODE) {
		this.COMP_UI_M_PCI_INTIMATION_MODE = COMP_UI_M_PCI_INTIMATION_MODE;
	}

	public HtmlOutputLabel getCOMP_PCI_REF_NO_LABEL() {
		return COMP_PCI_REF_NO_LABEL;
	}

	public HtmlInputText getCOMP_PCI_REF_NO() {
		return COMP_PCI_REF_NO;
	}

	public void setCOMP_PCI_REF_NO_LABEL(HtmlOutputLabel COMP_PCI_REF_NO_LABEL) {
		this.COMP_PCI_REF_NO_LABEL = COMP_PCI_REF_NO_LABEL;
	}

	public void setCOMP_PCI_REF_NO(HtmlInputText COMP_PCI_REF_NO) {
		this.COMP_PCI_REF_NO = COMP_PCI_REF_NO;
	}

	public HtmlOutputLabel getCOMP_PCI_RES_ADDRESS_1_LABEL() {
		return COMP_PCI_RES_ADDRESS_1_LABEL;
	}

	public HtmlInputText getCOMP_PCI_RES_ADDRESS_1() {
		return COMP_PCI_RES_ADDRESS_1;
	}

	public void setCOMP_PCI_RES_ADDRESS_1_LABEL(HtmlOutputLabel COMP_PCI_RES_ADDRESS_1_LABEL) {
		this.COMP_PCI_RES_ADDRESS_1_LABEL = COMP_PCI_RES_ADDRESS_1_LABEL;
	}

	public void setCOMP_PCI_RES_ADDRESS_1(HtmlInputText COMP_PCI_RES_ADDRESS_1) {
		this.COMP_PCI_RES_ADDRESS_1 = COMP_PCI_RES_ADDRESS_1;
	}

	public HtmlOutputLabel getCOMP_PCI_RES_ADDRESS_2_LABEL() {
		return COMP_PCI_RES_ADDRESS_2_LABEL;
	}

	public HtmlInputText getCOMP_PCI_RES_ADDRESS_2() {
		return COMP_PCI_RES_ADDRESS_2;
	}

	public void setCOMP_PCI_RES_ADDRESS_2_LABEL(HtmlOutputLabel COMP_PCI_RES_ADDRESS_2_LABEL) {
		this.COMP_PCI_RES_ADDRESS_2_LABEL = COMP_PCI_RES_ADDRESS_2_LABEL;
	}

	public void setCOMP_PCI_RES_ADDRESS_2(HtmlInputText COMP_PCI_RES_ADDRESS_2) {
		this.COMP_PCI_RES_ADDRESS_2 = COMP_PCI_RES_ADDRESS_2;
	}

	public HtmlOutputLabel getCOMP_PCI_RES_ADDRESS_3_LABEL() {
		return COMP_PCI_RES_ADDRESS_3_LABEL;
	}

	public HtmlInputText getCOMP_PCI_RES_ADDRESS_3() {
		return COMP_PCI_RES_ADDRESS_3;
	}

	public void setCOMP_PCI_RES_ADDRESS_3_LABEL(HtmlOutputLabel COMP_PCI_RES_ADDRESS_3_LABEL) {
		this.COMP_PCI_RES_ADDRESS_3_LABEL = COMP_PCI_RES_ADDRESS_3_LABEL;
	}

	public void setCOMP_PCI_RES_ADDRESS_3(HtmlInputText COMP_PCI_RES_ADDRESS_3) {
		this.COMP_PCI_RES_ADDRESS_3 = COMP_PCI_RES_ADDRESS_3;
	}

	public HtmlOutputLabel getCOMP_UI_M_RES_AREA_NAME_LABEL() {
		return COMP_UI_M_RES_AREA_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_RES_AREA_NAME() {
		return COMP_UI_M_RES_AREA_NAME;
	}

	public void setCOMP_UI_M_RES_AREA_NAME_LABEL(HtmlOutputLabel COMP_UI_M_RES_AREA_NAME_LABEL) {
		this.COMP_UI_M_RES_AREA_NAME_LABEL = COMP_UI_M_RES_AREA_NAME_LABEL;
	}

	public void setCOMP_UI_M_RES_AREA_NAME(HtmlInputText COMP_UI_M_RES_AREA_NAME) {
		this.COMP_UI_M_RES_AREA_NAME = COMP_UI_M_RES_AREA_NAME;
	}

	public HtmlOutputLabel getCOMP_PCI_RES_AREA_CODE_LABEL() {
		return COMP_PCI_RES_AREA_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PCI_RES_AREA_CODE() {
		return COMP_PCI_RES_AREA_CODE;
	}

	public void setCOMP_PCI_RES_AREA_CODE_LABEL(HtmlOutputLabel COMP_PCI_RES_AREA_CODE_LABEL) {
		this.COMP_PCI_RES_AREA_CODE_LABEL = COMP_PCI_RES_AREA_CODE_LABEL;
	}

	public void setCOMP_PCI_RES_AREA_CODE(HtmlInputText COMP_PCI_RES_AREA_CODE) {
		this.COMP_PCI_RES_AREA_CODE = COMP_PCI_RES_AREA_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PCI_CITY_NAME_LABEL() {
		return COMP_UI_M_PCI_CITY_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PCI_CITY_NAME() {
		return COMP_UI_M_PCI_CITY_NAME;
	}

	public void setCOMP_UI_M_PCI_CITY_NAME_LABEL(HtmlOutputLabel COMP_UI_M_PCI_CITY_NAME_LABEL) {
		this.COMP_UI_M_PCI_CITY_NAME_LABEL = COMP_UI_M_PCI_CITY_NAME_LABEL;
	}

	public void setCOMP_UI_M_PCI_CITY_NAME(HtmlInputText COMP_UI_M_PCI_CITY_NAME) {
		this.COMP_UI_M_PCI_CITY_NAME = COMP_UI_M_PCI_CITY_NAME;
	}

	public HtmlOutputLabel getCOMP_PCI_CITY_CODE_LABEL() {
		return COMP_PCI_CITY_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PCI_CITY_CODE() {
		return COMP_PCI_CITY_CODE;
	}

	public void setCOMP_PCI_CITY_CODE_LABEL(HtmlOutputLabel COMP_PCI_CITY_CODE_LABEL) {
		this.COMP_PCI_CITY_CODE_LABEL = COMP_PCI_CITY_CODE_LABEL;
	}

	public void setCOMP_PCI_CITY_CODE(HtmlInputText COMP_PCI_CITY_CODE) {
		this.COMP_PCI_CITY_CODE = COMP_PCI_CITY_CODE;
	}

	public HtmlOutputLabel getCOMP_PCI_COUNTRY_CODE_LABEL() {
		return COMP_PCI_COUNTRY_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PCI_COUNTRY_CODE() {
		return COMP_PCI_COUNTRY_CODE;
	}

	public void setCOMP_PCI_COUNTRY_CODE_LABEL(HtmlOutputLabel COMP_PCI_COUNTRY_CODE_LABEL) {
		this.COMP_PCI_COUNTRY_CODE_LABEL = COMP_PCI_COUNTRY_CODE_LABEL;
	}

	public void setCOMP_PCI_COUNTRY_CODE(HtmlInputText COMP_PCI_COUNTRY_CODE) {
		this.COMP_PCI_COUNTRY_CODE = COMP_PCI_COUNTRY_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PCI_COUNTRY_CODE_LABEL() {
		return COMP_UI_M_PCI_COUNTRY_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PCI_COUNTRY_CODE() {
		return COMP_UI_M_PCI_COUNTRY_CODE;
	}

	public void setCOMP_UI_M_PCI_COUNTRY_CODE_LABEL(HtmlOutputLabel COMP_UI_M_PCI_COUNTRY_CODE_LABEL) {
		this.COMP_UI_M_PCI_COUNTRY_CODE_LABEL = COMP_UI_M_PCI_COUNTRY_CODE_LABEL;
	}

	public void setCOMP_UI_M_PCI_COUNTRY_CODE(HtmlInputText COMP_UI_M_PCI_COUNTRY_CODE) {
		this.COMP_UI_M_PCI_COUNTRY_CODE = COMP_UI_M_PCI_COUNTRY_CODE;
	}

	public HtmlOutputLabel getCOMP_PCI_STATE_CODE_LABEL() {
		return COMP_PCI_STATE_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PCI_STATE_CODE() {
		return COMP_PCI_STATE_CODE;
	}

	public void setCOMP_PCI_STATE_CODE_LABEL(HtmlOutputLabel COMP_PCI_STATE_CODE_LABEL) {
		this.COMP_PCI_STATE_CODE_LABEL = COMP_PCI_STATE_CODE_LABEL;
	}

	public void setCOMP_PCI_STATE_CODE(HtmlInputText COMP_PCI_STATE_CODE) {
		this.COMP_PCI_STATE_CODE = COMP_PCI_STATE_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PCI_STATE_CODE_LABEL() {
		return COMP_UI_M_PCI_STATE_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PCI_STATE_CODE() {
		return COMP_UI_M_PCI_STATE_CODE;
	}

	public void setCOMP_UI_M_PCI_STATE_CODE_LABEL(HtmlOutputLabel COMP_UI_M_PCI_STATE_CODE_LABEL) {
		this.COMP_UI_M_PCI_STATE_CODE_LABEL = COMP_UI_M_PCI_STATE_CODE_LABEL;
	}

	public void setCOMP_UI_M_PCI_STATE_CODE(HtmlInputText COMP_UI_M_PCI_STATE_CODE) {
		this.COMP_UI_M_PCI_STATE_CODE = COMP_UI_M_PCI_STATE_CODE;
	}

	public HtmlOutputLabel getCOMP_PCI_ACTION_TAKEN_LABEL() {
		return COMP_PCI_ACTION_TAKEN_LABEL;
	}

	/*
	 * Commented by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 22-03-2017
	 * 
		public HtmlInputText getCOMP_PCI_ACTION_TAKEN() {
		return COMP_PCI_ACTION_TAKEN;
	}

	 public void setCOMP_PCI_ACTION_TAKEN(HtmlInputText COMP_PCI_ACTION_TAKEN) {
		this.COMP_PCI_ACTION_TAKEN = COMP_PCI_ACTION_TAKEN;
	}*/

	public void setCOMP_PCI_ACTION_TAKEN_LABEL(HtmlOutputLabel COMP_PCI_ACTION_TAKEN_LABEL) {
		this.COMP_PCI_ACTION_TAKEN_LABEL = COMP_PCI_ACTION_TAKEN_LABEL;
	}

	

	public HtmlOutputLabel getCOMP_PCI_REMARKS_LABEL() {
		return COMP_PCI_REMARKS_LABEL;
	}

	

	public void setCOMP_PCI_REMARKS_LABEL(HtmlOutputLabel COMP_PCI_REMARKS_LABEL) {
		this.COMP_PCI_REMARKS_LABEL = COMP_PCI_REMARKS_LABEL;
	}

	

	public PT_IL_PRE_CLAIMS_INFO getPT_IL_PRE_CLAIMS_INFO_BEAN() {
		return this.PT_IL_PRE_CLAIMS_INFO_BEAN;
	}

	public void setPT_IL_PRE_CLAIMS_INFO_BEAN(PT_IL_PRE_CLAIMS_INFO PT_IL_PRE_CLAIMS_INFO_BEAN) {
		this.PT_IL_PRE_CLAIMS_INFO_BEAN = PT_IL_PRE_CLAIMS_INFO_BEAN;
	}

	public List<PT_IL_PRE_CLAIMS_INFO> getPolNoLov(Object string){
		PILT042_APAC_DELEGATE delegate = new PILT042_APAC_DELEGATE();
		/*Commented by saranya for hands on point num 11 on 07-02-2017*/
		//PT_IL_PRE_CLAIMS_INFO localBean = getPT_IL_PRE_CLAIMS_INFO_BEAN();
		/*End*/
		try {
			System.out.println("National Id  ====  >"+getPT_IL_PRE_CLAIMS_INFO_BEAN().getPCI_ASSRD_REF_ID1());
			lovListValue = (List)delegate.getLovForPolNo(string,PT_IL_PRE_CLAIMS_INFO_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lovListValue;
	}
	public void renderPolNo(ActionEvent event){
		Iterator<PT_IL_PRE_CLAIMS_INFO> iterator = null;
		PT_IL_PRE_CLAIMS_INFO bean = null;
		boolean keepLooking = true;
		String classCode = null;
		// try and catch added by  by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 16/03/2017
		try{
		classCode = (String) COMP_PCI_POL_NO.getSubmittedValue();
		if(classCode != null && !classCode.trim().isEmpty()){
			if(lovListValue != null){
				iterator = lovListValue.iterator();
				while(iterator.hasNext() && keepLooking){
					bean = iterator.next();
					String polNo = bean.getPCI_POL_NO();
					if(polNo.equalsIgnoreCase(classCode)){
						getCOMP_PCI_POL_NO().setSubmittedValue(polNo);
						getPT_IL_PRE_CLAIMS_INFO_BEAN().setPCI_POL_NO(polNo);
						keepLooking = false;
					}
				}
			}
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<PT_IL_PRE_CLAIMS_INFO> getIntimateModeLov(Object string){
		PILT042_APAC_DELEGATE delegate = new PILT042_APAC_DELEGATE();
		try {
			lovListValue = (List)delegate.getLovForIntimateMode(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lovListValue;
	}
	public void renderIntimateMode(ActionEvent event){
		Iterator<PT_IL_PRE_CLAIMS_INFO> iterator = null;
		PT_IL_PRE_CLAIMS_INFO bean = null;
		boolean keepLooking = true;
		String classCode = null;
		String codeDesc = null;
		String code = null;
		// try and catch added by  by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 16/03/2017
		try{
		classCode = (String) COMP_PCI_INTIMATION_MODE.getSubmittedValue();
		if(classCode != null && !classCode.trim().isEmpty()){
			if(lovListValue != null){
				iterator = lovListValue.iterator();
				while(iterator.hasNext() && keepLooking){
					bean = iterator.next();
					code = bean.getPCI_INTIMATION_MODE();
					if(code.equalsIgnoreCase(classCode)){
						codeDesc = bean.getUI_M_PCI_INTIMATION_MODE();
						getCOMP_PCI_INTIMATION_MODE().setSubmittedValue(code);
						getPT_IL_PRE_CLAIMS_INFO_BEAN().setPCI_INTIMATION_MODE(code);
						getCOMP_UI_M_PCI_INTIMATION_MODE().setSubmittedValue(codeDesc);
						getPT_IL_PRE_CLAIMS_INFO_BEAN().setUI_M_PCI_INTIMATION_MODE(codeDesc);
						keepLooking = false;
					}
				}
			}
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<PT_IL_PRE_CLAIMS_INFO> getPostalLov(Object string){
		PILT042_APAC_DELEGATE delegate = new PILT042_APAC_DELEGATE();
		try {
			lovListValue = (List)delegate.getLovPostal(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lovListValue;
	}
	public void renderPostalCode(ActionEvent event){
		Iterator<PT_IL_PRE_CLAIMS_INFO> iterator = null;
		PT_IL_PRE_CLAIMS_INFO bean = null;
		boolean keepLooking = true;
		String classCode = null;
		String codeDesc = null;
		// try and catch added by  by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 16/03/2017
		try{
		classCode = (String) COMP_PCI_RES_AREA_CODE.getSubmittedValue();
		if(classCode != null && !classCode.trim().isEmpty()){
			if(lovListValue != null){
				iterator = lovListValue.iterator();
				while(iterator.hasNext() && keepLooking){
					bean = iterator.next();
					String code = bean.getPCI_RES_AREA_CODE();
					if(code.equalsIgnoreCase(classCode)){
						codeDesc = bean.getUI_M_RES_AREA_NAME();
						getCOMP_PCI_RES_AREA_CODE().setSubmittedValue(code);
						getPT_IL_PRE_CLAIMS_INFO_BEAN().setPCI_RES_AREA_CODE(code);
						getCOMP_UI_M_RES_AREA_NAME().setSubmittedValue(codeDesc);
						getPT_IL_PRE_CLAIMS_INFO_BEAN().setUI_M_RES_AREA_NAME(codeDesc);
						keepLooking = false;
					}
				}
			}
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<PT_IL_PRE_CLAIMS_INFO> getCityCodeLov(Object string){
		PILT042_APAC_DELEGATE delegate = new PILT042_APAC_DELEGATE();
		try {
			lovListValue = (List)delegate.getLovCityCode(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lovListValue;
	}
	public void renderCityCode(ActionEvent event){
		Iterator<PT_IL_PRE_CLAIMS_INFO> iterator = null;
		PT_IL_PRE_CLAIMS_INFO bean = null;
		boolean keepLooking = true;
		String classCode = null;
		String codeDesc = null;
		// try and catch added by  by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 16/03/2017
		try{
		classCode = (String) COMP_PCI_CITY_CODE.getSubmittedValue();
		if(classCode != null && !classCode.trim().isEmpty()){
			if(lovListValue != null){
				iterator = lovListValue.iterator();
				while(iterator.hasNext() && keepLooking){
					bean = iterator.next();
					String code = bean.getPCI_CITY_CODE();
					if(code.equalsIgnoreCase(classCode)){
						codeDesc = bean.getUI_M_PCI_CITY_NAME();
						getCOMP_PCI_CITY_CODE().setSubmittedValue(code);
						getPT_IL_PRE_CLAIMS_INFO_BEAN().setPCI_CITY_CODE(code);
						getCOMP_UI_M_PCI_CITY_NAME().setSubmittedValue(codeDesc);
						getPT_IL_PRE_CLAIMS_INFO_BEAN().setUI_M_PCI_CITY_NAME(codeDesc);
						keepLooking = false;
					}
				}
			}
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<PT_IL_PRE_CLAIMS_INFO> getCountryLov(Object string){
		PILT042_APAC_DELEGATE delegate = new PILT042_APAC_DELEGATE();
		try {
			lovListValue = (List)delegate.getCountryCode(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lovListValue;
	}
	public void renderCountryCode(ActionEvent event){
		Iterator<PT_IL_PRE_CLAIMS_INFO> iterator = null;
		PT_IL_PRE_CLAIMS_INFO bean = null;
		boolean keepLooking = true;
		String classCode = null;
		String codeDesc = null;
		// try and catch added by  by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 16/03/2017
		try{
		classCode = (String) COMP_PCI_COUNTRY_CODE.getSubmittedValue();
		if(classCode != null && !classCode.trim().isEmpty()){
			if(lovListValue != null){
				iterator = lovListValue.iterator();
				while(iterator.hasNext() && keepLooking){
					bean = iterator.next();
					String code = bean.getPCI_COUNTRY_CODE();
					if(code.equalsIgnoreCase(classCode)){
						codeDesc = bean.getUI_M_PCI_COUNTRY_CODE();
						getCOMP_PCI_COUNTRY_CODE().setSubmittedValue(code);
						getPT_IL_PRE_CLAIMS_INFO_BEAN().setPCI_COUNTRY_CODE(code);
						getCOMP_UI_M_PCI_COUNTRY_CODE().setSubmittedValue(codeDesc);
						getPT_IL_PRE_CLAIMS_INFO_BEAN().setUI_M_PCI_COUNTRY_CODE(codeDesc);
						keepLooking = false;
					}
				}
			}
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<PT_IL_PRE_CLAIMS_INFO> getStateLov(Object string){
		PILT042_APAC_DELEGATE delegate = new PILT042_APAC_DELEGATE();
		try {
			lovListValue = (List)delegate.getStateCode(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lovListValue;
	}
	public void renderStateCode(ActionEvent event){
		Iterator<PT_IL_PRE_CLAIMS_INFO> iterator = null;
		PT_IL_PRE_CLAIMS_INFO bean = null;
		boolean keepLooking = true;
		String classCode = null;
		String codeDesc = null;
		// try and catch added by  by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 16/03/2017
		try{
		classCode = (String) COMP_PCI_STATE_CODE.getSubmittedValue();
		if(classCode != null && !classCode.trim().isEmpty()){
			if(lovListValue != null){
				iterator = lovListValue.iterator();
				while(iterator.hasNext() && keepLooking){
					bean = iterator.next();
					String code = bean.getPCI_STATE_CODE();
					if(code.equalsIgnoreCase(classCode)){
						codeDesc = bean.getUI_M_PCI_STATE_CODE();
						getCOMP_PCI_STATE_CODE().setSubmittedValue(code);
						getPT_IL_PRE_CLAIMS_INFO_BEAN().setPCI_STATE_CODE(code);
						getCOMP_UI_M_PCI_STATE_CODE().setSubmittedValue(codeDesc);
						getPT_IL_PRE_CLAIMS_INFO_BEAN().setUI_M_PCI_STATE_CODE(codeDesc);
						keepLooking = false;
					}
				}
			}
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<SelectItem> getItemListPCI_CLAIM_TYPE() {
		return itemListPCI_CLAIM_TYPE;
	}

	public void setItemListPCI_CLAIM_TYPE(List<SelectItem> itemListPCI_CLAIM_TYPE) {
		this.itemListPCI_CLAIM_TYPE = itemListPCI_CLAIM_TYPE;
	}

	public void validaterefId(ActionEvent event){
		UIInput inputValue = (UIInput) event.getComponent().getParent();
		
		// added by  by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 16/03/2017
		String value = inputValue.getSubmittedValue().toString();

		PILT042_APAC_HELPER helper = new PILT042_APAC_HELPER();
		PILT042_APAC_DELEGATE delegate = new PILT042_APAC_DELEGATE();
		try {
			PT_IL_PRE_CLAIMS_INFO bean = getPT_IL_PRE_CLAIMS_INFO_BEAN(); 

			String id1 = bean.getPCI_ASSRD_REF_ID1();
			String id2 = bean.getPCI_ASSRD_REF_ID2();
			
			System.out.println("id1 =========>"+id1);
			if(id1== null){
				id1 = "";
			}
			if(id2== null){
				id2 = "";
			}
			/*Commented by saranya for hands on point num11 on 07-02-2017*/
			/*bean.setPCI_ASSRD_REF_ID1(id1);
			bean.setPCI_ASSRD_REF_ID2(id2);*/
			/*End*/
			bean.setPCI_POL_NO(value);
			/*Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
			String currValue =  value;
			//helper.PCI_POL_NO_when_validate(getPT_IL_PRE_CLAIMS_INFO_BEAN(),currValue);
			/*End*/
			/*
			 * 
			 * cOMMENTED BY SANKARA NARAYANAN CUSTOMER CODE AND DESCRIPTION WAS ALREADY SET IN HELPER CLASS
			 * 
			 * String customerNameQuery = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE IN(SELECT POL_CUST_CODE FROM PT_IL_POLICY WHERE POL_NO = ? )";
			String customerName = delegate.fetcgDesc(customerNameQuery, "CUST_NAME", bean.getPCI_POL_NO());
			getCOMP_UI_M_PCI_CUST_NAME().setSubmittedValue(customerName);
			getPT_IL_PRE_CLAIMS_INFO_BEAN().setUI_M_PCI_CUST_NAME(customerName);*/
			getCOMP_PCI_ASSRD_REF_ID2().resetValue();
			COMP_UI_M_PCI_CUST_CODE.resetValue();
			COMP_UI_M_PCI_CUST_NAME.resetValue();
			COMP_UI_M_PCI_ASSRD_NAME.resetValue();
			COMP_PCI_ASSRD_CODE.resetValue();
			COMP_PCI_RES_ADDRESS_1.resetValue();
			COMP_PCI_RES_ADDRESS_2.resetValue();
			COMP_PCI_RES_ADDRESS_3.resetValue();
			delegate.fetchPolicyAddress(bean,"POL_NO",bean.getPCI_POL_NO());
			if("".equals(getCOMP_PCI_RES_ADDRESS_1().getSubmittedValue())){
				getCOMP_PCI_RES_ADDRESS_1().resetValue();
				}
			if("".equals(getCOMP_PCI_RES_ADDRESS_2().getSubmittedValue())){getCOMP_PCI_RES_ADDRESS_2().resetValue();}
			if("".equals(getCOMP_PCI_RES_ADDRESS_3().getSubmittedValue())){getCOMP_PCI_RES_ADDRESS_3().resetValue();}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("someKey", e.getMessage());
			getErrorMap().put("current", e.getMessage());
			//throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	
		//end
		
		
		
		//ErrorHelpUtil.validate(inputValue, getErrorMap());
	}

	public void validateDate(ActionEvent event){
		UICalendar inputValue = (UICalendar) event.getComponent().getParent();
	   ErrorHelpUtil.validate(inputValue, getErrorMap());
	}

	public void refId1(FacesContext context, UIComponent component,Object value){
		PILT042_APAC_HELPER helper = new PILT042_APAC_HELPER();
		PILT042_APAC_DELEGATE delegate = new PILT042_APAC_DELEGATE();
		PT_IL_PRE_CLAIMS_INFO localBean = getPT_IL_PRE_CLAIMS_INFO_BEAN();
		try {
			String stringValue = (String) value;
			/*Added by saranya for handson Pont num 11 on 05-02-2017*/
			if(!stringValue.equalsIgnoreCase(localBean.getPCI_ASSRD_REF_ID1()))
			{
				localBean.setPCI_POL_NO(null);
				localBean.setPCI_ASSRD_CODE(null);
				localBean.setUI_M_PCI_ASSRD_NAME(null);
				COMP_PCI_POL_NO.resetValue();
				COMP_PCI_ASSRD_CODE.resetValue();
				COMP_UI_M_PCI_ASSRD_NAME.resetValue();
			}
			/*End*/
			if (stringValue == null || stringValue.trim().isEmpty()) {
				localBean.setPCI_ASSRD_REF_ID1(null);
				getCOMP_PCI_ASSRD_REF_ID1().resetValue();
			}else{
				localBean.setPCI_ASSRD_REF_ID1(stringValue);
				String id2Value = localBean.getPCI_ASSRD_REF_ID2();
				localBean.setPCI_ASSRD_REF_ID2(id2Value);
				helper.pci_assrd_ref_id1_when_validate(localBean);
				getCOMP_PCI_ASSRD_REF_ID1().resetValue();
				getCOMP_PCI_ASSRD_REF_ID2().resetValue();

				/*
				 * cOMMENTED BY SANKARA NARAYANAN FOR ZBILQC-1720515 & ZBILQC-1719141 ON 19-03-2017
				 * aDDRESS ARE DEFAULTED WHILE POLICY NO TABING 
				 * 
				 * delegate.fetchPolicyAddress(localBean,"POL_ASSRD_REF_ID1",localBean.getPCI_ASSRD_REF_ID1());
				if("".equals(getCOMP_PCI_RES_ADDRESS_1().getSubmittedValue())){getCOMP_PCI_RES_ADDRESS_1().resetValue();}
				if("".equals(getCOMP_PCI_RES_ADDRESS_2().getSubmittedValue())){getCOMP_PCI_RES_ADDRESS_2().resetValue();}
				if("".equals(getCOMP_PCI_RES_ADDRESS_3().getSubmittedValue())){getCOMP_PCI_RES_ADDRESS_3().resetValue();}*/
			}
			System.out.println("id1--------------"+localBean.getPCI_ASSRD_REF_ID1());
			System.out.println("id2--------------"+localBean.getPCI_ASSRD_REF_ID2());
			/*Added by saranya for hands on point num 11 on 07-02-2017*/
			setPT_IL_PRE_CLAIMS_INFO_BEAN(localBean);
			System.out.println("id1 base new--------------"+ getPT_IL_PRE_CLAIMS_INFO_BEAN().getPCI_ASSRD_REF_ID1());
		/*End*/
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("someKey", e.getMessage());
			getErrorMap().put("current", e.getMessage());
		//	throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void refId2(FacesContext context, UIComponent component,Object value){
		PILT042_APAC_HELPER helper = new PILT042_APAC_HELPER();
		PILT042_APAC_DELEGATE delegate = new PILT042_APAC_DELEGATE();
		PT_IL_PRE_CLAIMS_INFO localBean = getPT_IL_PRE_CLAIMS_INFO_BEAN();
		try {
			String stringValue = (String) value;
			if (stringValue == null || stringValue.trim().isEmpty()){
				localBean.setPCI_ASSRD_REF_ID2(null);
				getCOMP_PCI_ASSRD_REF_ID2().resetValue();
			}else{
				localBean.setPCI_ASSRD_REF_ID2((String) stringValue);
				System.out.println("valuevaluevaluevalue"+localBean.getPCI_ASSRD_REF_ID2());
				helper.pci_assrd_ref_id2_when_validate(localBean, COMP_PCI_ASSRD_REF_ID2.getMaxlength());
				getCOMP_PCI_ASSRD_REF_ID1().resetValue();
				getCOMP_PCI_ASSRD_REF_ID2().resetValue();

				delegate.fetchPolicyAddress(localBean,"POL_ASSRD_REF_ID2",localBean.getPCI_ASSRD_REF_ID2());
				if("".equals(getCOMP_PCI_RES_ADDRESS_1().getSubmittedValue())){getCOMP_PCI_RES_ADDRESS_1().resetValue();}
				if("".equals(getCOMP_PCI_RES_ADDRESS_2().getSubmittedValue())){getCOMP_PCI_RES_ADDRESS_2().resetValue();}
				if("".equals(getCOMP_PCI_RES_ADDRESS_3().getSubmittedValue())){getCOMP_PCI_RES_ADDRESS_3().resetValue();}
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("someKey", e.getMessage());
			getErrorMap().put("current", e.getMessage());
			//throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validatePolNo(FacesContext context, UIComponent component,Object value){
		PILT042_APAC_HELPER helper = new PILT042_APAC_HELPER();
		PILT042_APAC_DELEGATE delegate = new PILT042_APAC_DELEGATE();
		try {
			PT_IL_PRE_CLAIMS_INFO bean = getPT_IL_PRE_CLAIMS_INFO_BEAN(); 
		
			String id1 = bean.getPCI_ASSRD_REF_ID1();
			String id2 = bean.getPCI_ASSRD_REF_ID2();
			
			System.out.println("id1 =========>"+id1);
			if(id1== null){
				id1 = "";
			}
			if(id2== null){
				id2 = "";
			}
			/*Commented by saranya for hands on point num11 on 07-02-2017*/
			/*bean.setPCI_ASSRD_REF_ID1(id1);
			bean.setPCI_ASSRD_REF_ID2(id2);*/
			/*End*/
			bean.setPCI_POL_NO((String) value);
			/*Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
			String currValue = (String) value;
			helper.PCI_POL_NO_when_validate(getPT_IL_PRE_CLAIMS_INFO_BEAN(),currValue,this);
			/*End*/
			/*
			 * 
			 * cOMMENTED BY SANKARA NARAYANAN CUSTOMER CODE AND DESCRIPTION WAS ALREADY SET IN HELPER CLASS
			 * 
			 * String customerNameQuery = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE IN(SELECT POL_CUST_CODE FROM PT_IL_POLICY WHERE POL_NO = ? )";
			String customerName = delegate.fetcgDesc(customerNameQuery, "CUST_NAME", bean.getPCI_POL_NO());
			getCOMP_UI_M_PCI_CUST_NAME().setSubmittedValue(customerName);
			getPT_IL_PRE_CLAIMS_INFO_BEAN().setUI_M_PCI_CUST_NAME(customerName);
			
			delegate.fetchPolicyAddress(bean,"POL_NO",bean.getPCI_POL_NO());
			if("".equals(getCOMP_PCI_RES_ADDRESS_1().getSubmittedValue())){
				getCOMP_PCI_RES_ADDRESS_1().resetValue();
				}
			if("".equals(getCOMP_PCI_RES_ADDRESS_2().getSubmittedValue())){getCOMP_PCI_RES_ADDRESS_2().resetValue();}
			if("".equals(getCOMP_PCI_RES_ADDRESS_3().getSubmittedValue())){getCOMP_PCI_RES_ADDRESS_3().resetValue();}
						*/
			delegate.fetchPolicyAddress(bean,"POL_NO",bean.getPCI_POL_NO());
			getCOMP_PCI_ASSRD_REF_ID2().resetValue();
			COMP_UI_M_PCI_CUST_CODE.resetValue();
			COMP_UI_M_PCI_CUST_NAME.resetValue();
			COMP_UI_M_PCI_ASSRD_NAME.resetValue();
			COMP_PCI_ASSRD_CODE.resetValue();
			COMP_PCI_RES_ADDRESS_1.resetValue();
			COMP_PCI_RES_ADDRESS_2.resetValue();
			COMP_PCI_RES_ADDRESS_3.resetValue();
			COMP_UI_M_PCI_COUNTRY_CODE.resetValue();
			COMP_PCI_COUNTRY_CODE.resetValue();
			COMP_PCI_CITY_CODE.resetValue();
			
			

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("someKey", e.getMessage());
			getErrorMap().put("current", e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	
	public void validatePCI_ASSRD_CODE(FacesContext context, UIComponent component,Object value){
		String currValue = (String) value;
		try {
		PT_IL_PRE_CLAIMS_INFO_BEAN.setPCI_ASSRD_CODE(currValue);
		helper.validAssuredCode(getPT_IL_PRE_CLAIMS_INFO_BEAN());
		}
		catch (Exception e) {
			e.printStackTrace();
			//getErrorMap().put("assrCode", e.getMessage());
			getErrorMap().put("current", e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
	}
	
	public void validatePCI_TYPE(ActionEvent actionEvent){
		PILT042_APAC_HELPER helper = new PILT042_APAC_HELPER();
		try {
			helper.L_CLAIM_VALID_POL_NO(getPT_IL_PRE_CLAIMS_INFO_BEAN());
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("someKey", e.getMessage());
			getErrorMap().put("current", e.getMessage());
			//throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePCI_TYPE(FacesContext context, UIComponent component,Object value){
		try {
			helper.whenValidatePCI_TYPE(getPT_IL_PRE_CLAIMS_INFO_BEAN(),(String) value);
			PT_IL_PRE_CLAIMS_INFO_BEAN.setPCI_CLAIM_TYPE((String) value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("someKey", e.getMessage());
			getErrorMap().put("current", e.getMessage());
			//throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validatelAIMtYPE(FacesContext context, UIComponent component,Object value){
		PILT042_APAC_HELPER helper = new PILT042_APAC_HELPER();
		Date issuedDate = null;
		try {
			String policyNo = getPT_IL_PRE_CLAIMS_INFO_BEAN().getPCI_POL_NO();
			Date assignDate = (Date) value;
			getPT_IL_PRE_CLAIMS_INFO_BEAN().setPCI_LOSS_DT((Date) value);
			Date intomateDate = getPT_IL_PRE_CLAIMS_INFO_BEAN().getPCI_LOSS_DT();
			issuedDate = helper.getPolicyIssuedDate(policyNo);
			Date sysdate =new CommonUtils().getCurrentDate();
			// try and catch added by  by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 16/03/2017
			//getErrorMap().clear();
		//	if(policyNo!=null || policyNo.trim().isEmpty()){  // commented by sankara narayanan 
			if(policyNo!=null){ //end
				//[Modified for issue MQC82
				
				
				
				/*Modified by Janani on 30.08.2017 for ZBILQC-1733746*/
				/*if  (!((assignDate.after(issuedDate) || assignDate.equals(issuedDate)) && (assignDate.before(sysdate) || assignDate.equals(sysdate))))*/
				
				System.out.println("assignDate     "+assignDate+"        issuedDate        "+issuedDate+"       sysdate       "+sysdate);
				
				if  ((assignDate != null && issuedDate != null && sysdate != null) && !((assignDate.after(issuedDate) || assignDate.equals(issuedDate)) &&
						(assignDate.before(sysdate) || assignDate.equals(sysdate))))
					
				/*End*/	
					
					//Modified for issue MQC82 ]					  
				{
					//[Commented for issue MQC82	  
					//if  (   assignDate.after(issuedDate) ||   sysdate.before(assignDate)){
					//Commented for issue MQC82]
					String errorMessage = Messages.getString("messageProperties_PILT042_APAC", "PILT042_APAC$PT_IL_PRE_CLAIMS_INFO$ERROR$MESSAGE$LOSSDATE");
					throw new Exception(errorMessage);
				}
				else{
					if(intomateDate!= null){
						helper.PCI_LOSS_DT_when_validate(getPT_IL_PRE_CLAIMS_INFO_BEAN());
						String P_DISABLE_YN = PT_IL_PRE_CLAIMS_INFO_BEAN.getM_DISABLE_YN();
						if("N".equals(P_DISABLE_YN)){
							setCHECKDOCNO(true);
						}else{
							setCHECKDOCNO(false);
						}
					}
				}
			}
		} catch (SQLException exc) {
			exc.printStackTrace();
			try{
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils.getConnection(),FacesContext.getCurrentInstance(),"PT_IL_PRE_CLAIMS_INFO", getWarningMap());
			}catch(ValidatorException vexc){
				vexc.printStackTrace();
				getErrorMap().put("current", vexc.getFacesMessage().getSummary());
				throw new ValidatorException(new FacesMessage(vexc.getMessage()));
			} catch (DBException e) {
				e.printStackTrace();
			}
		}catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("someKey", e.getMessage());
			getErrorMap().put("current", e.getMessage());
			//throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateREPORT(FacesContext context, UIComponent component,Object value){
		try {
			Date sysdate = new CommonUtils().getCurrentDate();
			Date assignDate = (Date) value;
			getErrorMap().clear();
			if(sysdate.before(assignDate)){
				String errorMessage = Messages.getString("messageProperties_PILT042_APAC", "PILT042_APAC$PT_IL_PRE_CLAIMS_INFO$ERROR$MESSAGE$INTIMATE");
				throw new Exception(errorMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("someKey", e.getMessage());
			getErrorMap().put("current", e.getMessage());
			//throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateIntimationCode(ActionEvent actionEvent){
		PILT042_APAC_HELPER helper = new PILT042_APAC_HELPER();
		try {
			helper.PCI_INTIMATION_MODE_when_validate(getPT_IL_PRE_CLAIMS_INFO_BEAN());
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("someKey", e.getMessage());
			getErrorMap().put("current", e.getMessage());
			//throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateAreaCode(FacesContext fc, UIComponent component,
			Object value){
		PILT042_APAC_HELPER helper = new PILT042_APAC_HELPER();
		try {
			helper.PCI_RES_AREA_CODE_when_validate(this);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("someKey", e.getMessage());
			getErrorMap().put("current", e.getMessage());
			//throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void AREA_CODE_WHEN_VALIDATE(ActionEvent event){
		UIInput inputValue = (UIInput) event.getComponent().getParent();
		//ErrorHelpUtil.validate(inputValue, getErrorMap());
	}

	public void validateCityCode(FacesContext fc, UIComponent component,
			Object value){
		PILT042_APAC_HELPER helper = new PILT042_APAC_HELPER();
		try {
			helper.PCI_CITY_CODE_when_validate(this);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("someKey", e.getMessage());
			getErrorMap().put("current", e.getMessage());
			//throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void CITY_CODE_WHEN_VALIDATE(ActionEvent event){
		UIInput inputValue = (UIInput) event.getComponent().getParent();
		//ErrorHelpUtil.validate(inputValue, getErrorMap());
	}

	public void validateCountryCode(FacesContext fc, UIComponent component,
			Object value){
		PILT042_APAC_HELPER helper = new PILT042_APAC_HELPER();
		try {
			helper.PCI_COUNTRY_CODE_when_validate(this);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("someKey", e.getMessage());
			getErrorMap().put("current", e.getMessage());
			//throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void COUNTRY_CODE_WHEN_VALIDATE(ActionEvent event){
		UIInput inputValue = (UIInput) event.getComponent().getParent();
		//ErrorHelpUtil.validate(inputValue, getErrorMap());
	}

	public void validateStateCode(FacesContext fc, UIComponent component,
			Object value){
		PILT042_APAC_HELPER helper = new PILT042_APAC_HELPER();
		try {
			helper.PCI_STATE_CODE_when_validate(this);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("someKey", e.getMessage());
			getErrorMap().put("current", e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void STATE_CODE_WHEN_VALIDATE(ActionEvent event){
		UIInput inputValue = (UIInput) event.getComponent().getParent();
		//ErrorHelpUtil.validate(inputValue, getErrorMap());
	}
/*Modified by saranya for hands on point num 11 on 07-02-2017*/
	//public String saveRecord(){
	public void saveRecord(){
		String rowId = null;
		PT_IL_PRE_CLAIMS_INFO claimsBean = getPT_IL_PRE_CLAIMS_INFO_BEAN();
		PILT042_APAC_HELPER helper = new PILT042_APAC_HELPER();
		PILT042_APAC_DELEGATE delegate = new PILT042_APAC_DELEGATE();
		rowId = claimsBean.getROWID();
		CommonUtils commonUtils = new CommonUtils();
		String message = null;
		getErrorMap().clear();
		getWarningMap().clear();
		try {
			if (rowId == null) {
				helper.PILT042_APAC_pre_insert(claimsBean,getControlBean());
				COMP_PCI_REF_NO.resetValue();
				message = Messages.getString("messageProperties", "errorPanel$message$save");;
			}else{
				helper.pre_update(claimsBean);
				message = Messages.getString("messageProperties", "errorPanel$message$update");;
			}
			delegate.claimsUpdate(claimsBean);

			
			commonUtils.doComitt();
			getWarningMap().put("current", message);
			getWarningMap().put("save", message);
			
			/*Added by Janani on 24.05.2017 for ZBILQC-1719141*/
			
			disableAllComponent(true);
			
			/*End*/
			
		} catch (SQLException exc) {
			exc.printStackTrace();
			try{
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils.getConnection(),FacesContext.getCurrentInstance(),"PT_IL_PRE_CLAIMS_INFO", getWarningMap());
			}catch(ValidatorException vexc){
				vexc.printStackTrace();
				getErrorMap().put("current", vexc.getFacesMessage().getSummary());
				getErrorMap().put("save", vexc.getFacesMessage().getSummary());
				//throw new ValidatorException(new FacesMessage(vexc.getMessage()));
			} catch (DBException e) {
				e.printStackTrace();	
			}
		}catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("errorKey", e.getMessage());
			getErrorMap().put("current", e.getMessage());
		//}
		//return "";
	}
		
	}
		
		
		/*ENd*/

	public void onLoad(PhaseEvent event) {
		try {
			
			if (isBlockFlag()) {
				// try and catch added by  by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 16/03/2017
				getErrorMap().clear();
				getWarningMap().clear();
				//end
				helper.pre_query(PT_IL_PRE_CLAIMS_INFO_BEAN);
				if(PT_IL_PRE_CLAIMS_INFO_BEAN.getROWID() != null){
					helper.executeQuery(PT_IL_PRE_CLAIMS_INFO_BEAN);
					helper.PILT042_APAC_post_query(PT_IL_PRE_CLAIMS_INFO_BEAN);
				}else{
					helper.PILT042_APAC_when_create_record(PT_IL_PRE_CLAIMS_INFO_BEAN);
				}
				helper.when_new_record_instance(PT_IL_PRE_CLAIMS_INFO_BEAN);
				if(PT_IL_PRE_CLAIMS_INFO_BEAN.getPCI_REPORT_DT() == null){
					PT_IL_PRE_CLAIMS_INFO_BEAN.setPCI_REPORT_DT(new CommonUtils().getCurrentDate());
				}
				setBlockFlag(false);
			}
			
			
			
			/*Added by Janani on 24.05.2017 for ZBILQC-1719141*/
			
			System.out.println("getPCI_REF_NO           "+PT_IL_PRE_CLAIMS_INFO_BEAN.getPCI_REF_NO());
			
			if(PT_IL_PRE_CLAIMS_INFO_BEAN.getPCI_REF_NO() !=null)
			{
			
				 System.out.println("getPCI_REF_NO is !null");
				disableAllComponent(true);
			}
			
			
			/*End*/
			
			
			String callingForm = CommonUtils.getGlobalVariable("CALLING_FORM_POL");
				if(null != callingForm  && callingForm.equalsIgnoreCase("PILT002_APAC")){
				disableAllComponent(true);
				}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	public String backToSearch(){
		String outcome =  null;
		if (!(CommonUtils.getGlobalVariable("CALLING_FORM") ==  null)) {
			if(!(CommonUtils.getGlobalVariable("CALLING_FORM_OUTCOME") == null)){
			outcome = CommonUtils.getGlobalVariable("CALLING_FORM_OUTCOME");
			CommonUtils.setGlobalVariable("CALLING_FORM",null);
			CommonUtils.setGlobalVariable("CALLING_FORM_OUTCOME",null);
			}else {
			 outcome = SearchConstants.BACK_TO_SEARCH_PAGE;
			}
		}
			
		
		return outcome; 

	}
	public HtmlOutputLabel getCOMP_UI_M_PCI_CUST_NAME_LABEL() {
		return COMP_UI_M_PCI_CUST_NAME_LABEL;
	}

	public void setCOMP_UI_M_PCI_CUST_NAME_LABEL(
			HtmlOutputLabel comp_ui_m_pci_cust_name_label) {
		COMP_UI_M_PCI_CUST_NAME_LABEL = comp_ui_m_pci_cust_name_label;
	}

	public HtmlInputText getCOMP_UI_M_PCI_CUST_NAME() {
		return COMP_UI_M_PCI_CUST_NAME;
	}

	public void setCOMP_UI_M_PCI_CUST_NAME(HtmlInputText comp_ui_m_pci_cust_name) {
		COMP_UI_M_PCI_CUST_NAME = comp_ui_m_pci_cust_name;
	}

	public ControlBean getControlBean() {
		return controlBean;
	}

	public void setControlBean(ControlBean controlBean) {
		this.controlBean = controlBean;
	}

	public boolean isCHECKDOCNO() {
		return CHECKDOCNO;
	}

	public void setCHECKDOCNO(boolean checkdocno) {
		CHECKDOCNO = checkdocno;
	}

	public List<PT_IL_PRE_CLAIMS_INFO> getLovListValue() {
		return lovListValue;
	}

	public void setLovListValue(List<PT_IL_PRE_CLAIMS_INFO> lovListValue) {
		this.lovListValue = lovListValue;
	}
	 
	public void instantiateAllcomponent(){
		
		  COMP_PCI_ASSRD_REF_ID2 = new HtmlInputText();

		COMP_PCI_ASSRD_REF_ID1 = new HtmlInputText();

		COMP_PCI_POL_NO = new HtmlInputText();

		COMP_PCI_CLAIM_TYPE = new HtmlSelectOneMenu();

		COMP_PCI_LOSS_DT = new HtmlCalendar();

		COMP_PCI_REPORT_DT = new HtmlCalendar();

		COMP_PCI_INTIMATION_MODE = new HtmlInputText();

		COMP_UI_M_PCI_INTIMATION_MODE = new HtmlInputText();

		COMP_PCI_REF_NO = new HtmlInputText();

		COMP_PCI_RES_ADDRESS_1 = new HtmlInputText();

		COMP_PCI_RES_ADDRESS_2 = new HtmlInputText();

		COMP_PCI_RES_ADDRESS_3 = new HtmlInputText();

		COMP_UI_M_RES_AREA_NAME = new HtmlInputText();

		COMP_PCI_RES_AREA_CODE = new HtmlInputText();

		COMP_UI_M_PCI_CITY_NAME = new HtmlInputText();

		COMP_PCI_CITY_CODE = new HtmlInputText();

		COMP_PCI_COUNTRY_CODE = new HtmlInputText();

		COMP_UI_M_PCI_COUNTRY_CODE = new HtmlInputText();

		COMP_PCI_STATE_CODE = new HtmlInputText();

		COMP_UI_M_PCI_STATE_CODE = new HtmlInputText();

		
		// added by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 16/03/2017
			
		//COMP_PCI_ACTION_TAKEN = new HtmlInputText();
		
		COMP_PCI_REMARKS = new HtmlInputTextarea();
				COMP_PCI_ACTION_TAKEN = new HtmlInputTextarea();

				COMP_UI_M_PCI_CUST_NAME = new HtmlInputText();
				
				COMP_UI_M_PCI_CUST_CODE = new HtmlInputText();
				/*end*/
				
				/*Added by Janani on 25.05.2017 for  ZBILQC-1727100*/

				COMP_PCI_INTIMATION_SRC_LABEL = new HtmlOutputLabel();
				COMP_PCI_INTIMATOR_NAME_LABEL = new HtmlOutputLabel();
				COMP_PCI_INTIMATOR_MOBILE_LABEL = new HtmlOutputLabel();
				COMP_PCI_INTIMATOR_EMAIL_LABEL = new HtmlOutputLabel();


				COMP_PCI_INTIMATION_SRC = new HtmlSelectOneMenu();
				COMP_PCI_INTIMATOR_NAME = new HtmlInputText();
				COMP_PCI_INTIMATOR_MOBILE = new HtmlInputText();
				COMP_PCI_INTIMATOR_EMAIL = new HtmlInputText();

				/*End*/
		
	}
	public void disableAllComponent(boolean disabled) {
		
		// added by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 16/03/2017
		COMP_UI_M_PCI_CUST_CODE.setDisabled(disabled);
		//end
		  COMP_PCI_ASSRD_REF_ID2.setDisabled(disabled);

		COMP_PCI_ASSRD_REF_ID1 .setDisabled(disabled);

		COMP_PCI_POL_NO .setDisabled(disabled);

		COMP_PCI_CLAIM_TYPE .setDisabled(disabled);

		COMP_PCI_LOSS_DT .setDisabled(disabled);

		COMP_PCI_REPORT_DT .setDisabled(disabled);

		COMP_PCI_INTIMATION_MODE.setDisabled(disabled);

		COMP_UI_M_PCI_INTIMATION_MODE .setDisabled(disabled);

		COMP_PCI_REF_NO .setDisabled(disabled);

		COMP_PCI_RES_ADDRESS_1.setDisabled(disabled);

		COMP_PCI_RES_ADDRESS_2.setDisabled(disabled);

		COMP_PCI_RES_ADDRESS_3.setDisabled(disabled);

		COMP_UI_M_RES_AREA_NAME .setDisabled(disabled);

		COMP_PCI_RES_AREA_CODE.setDisabled(disabled);

		COMP_UI_M_PCI_CITY_NAME .setDisabled(disabled);

		COMP_PCI_CITY_CODE.setDisabled(disabled);

		COMP_PCI_COUNTRY_CODE .setDisabled(disabled);

		COMP_UI_M_PCI_COUNTRY_CODE.setDisabled(disabled);

		COMP_PCI_STATE_CODE .setDisabled(disabled);

		COMP_UI_M_PCI_STATE_CODE .setDisabled(disabled);

		COMP_PCI_ACTION_TAKEN.setDisabled(disabled);

		COMP_PCI_REMARKS .setDisabled(disabled);

		COMP_UI_M_PCI_CUST_NAME.setDisabled(disabled);
		
	
		
		
/*Added by Janani on 25.05.2017 for ZBILQC-1719141*/
		
		COMP_PCI_ASSRD_CODE.setDisabled(disabled);
		
		/*eND*/

		/*Added by Janani on 25.05.2017 for  ZBILQC-1727100*/

		COMP_PCI_INTIMATION_SRC.setDisabled(disabled);
		COMP_PCI_INTIMATOR_NAME.setDisabled(disabled);
		COMP_PCI_INTIMATOR_MOBILE.setDisabled(disabled);
		COMP_PCI_INTIMATOR_EMAIL.setDisabled(disabled);

		/*End*/
		
	}
	
	
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	public List<LovBean> lovCLAIM_ASSR_CODE(Object event) {
		
		System.out.println("lovCLAIM_ASSR_CODE  x ");
		String code = (String) event;
		List<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		
		// added by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 16/03/2017
				String pol_sys_id  = null;
				String Plan_code =null; //end
		try {
			//pol_sys_id = helper.getPolSysId(getPT_IL_PRE_CLAIMS_INFO_BEAN().getPCI_POL_NO());
			// added by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 16/03/2017
			Plan_code=CommonUtils.getGlobalVariable("PCI_POL_PLAN_CODE");
			pol_sys_id=CommonUtils.getGlobalVariable("PCI_POL_SYS_ID");
			// added by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 16/03/2017
			
			/*Modified by saritha on 26-10-2017 for ssp call id ZBLIFE-1445282 as per thiag sir sugg.*/ 
			if(null != pol_sys_id&&"207".equalsIgnoreCase(Plan_code)||"210".equalsIgnoreCase(Plan_code)||
									"211".equalsIgnoreCase(Plan_code)||"212".equalsIgnoreCase(Plan_code)){
				suggestionList = new ListItemUtil().P_CALL_LOV("PILT006_APAC", "PT_IL_CLAIM",
						"CLAIM_MEMB_CODE",pol_sys_id, null, null, null, null,
						code);
				
			/*End*/
			}else{

				if ("*".equals(code)) {
					object = new Object[] {pol_sys_id, PELConstants.suggetionRecordSize };
					query = "SELECT POAD_ASSR_CODE,POAD_ASSURED_NAME  FROM PT_IL_POL_ASSURED_DTLS "
							+ "WHERE  POAD_POL_SYS_ID = ?  AND " +					
							"ROWNUM < ? ORDER BY 1";
				} else {
					object = new Object[] {pol_sys_id, code + "%",
							PELConstants.suggetionRecordSize };
					/*commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016
					 * 
					 * 
					 * query = "SELECT POAD_ASSR_CODE,POAD_ASSURED_NAME  FROM PT_IL_POL_ASSURED_DTLS  "
				+ "WHERE  POAD_POL_SYS_ID = ?  AND " +				
					"(POAD_ASSR_CODE  LIKE ? ) " +
					"AND ROWNUM < ? ORDER BY 1";*/
					/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016*/
					query = "SELECT POAD_ASSR_CODE,POAD_ASSURED_NAME  FROM PT_IL_POL_ASSURED_DTLS  "
							+ "WHERE  POAD_POL_SYS_ID = ?  AND " +				
							"(UPPER(POAD_ASSR_CODE)  LIKE UPPER(?) ) " +
							"AND ROWNUM < ? ORDER BY 1";
					/*end*/


				}
				suggestionList = prepareLovList(query, object);
			}



		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("POAD_ASSR_CODE", e.getMessage());
		}
		return suggestionList;
	}
	
	public List<LovBean> prepareLovList(String query, Object[] obj) {
		List<LovBean> suggestionList = new ArrayList<LovBean>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, obj);
			while (resultSet.next()) {
				LovBean bean = new LovBean();
				bean.setCode(resultSet.getString(1));
				bean.setName(resultSet.getString(2));
				suggestionList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return suggestionList;
	}

	public HtmlOutputLabel getCOMP_PCI_ASSRD_CODE_LABEL() {
		return COMP_PCI_ASSRD_CODE_LABEL;
	}

	public void setCOMP_PCI_ASSRD_CODE_LABEL(
			HtmlOutputLabel comp_pci_assrd_code_label) {
		COMP_PCI_ASSRD_CODE_LABEL = comp_pci_assrd_code_label;
	}

	public HtmlInputText getCOMP_PCI_ASSRD_CODE() {
		return COMP_PCI_ASSRD_CODE;
	}

	public void setCOMP_PCI_ASSRD_CODE(HtmlInputText comp_pci_assrd_code) {
		COMP_PCI_ASSRD_CODE = comp_pci_assrd_code;
	}

	public HtmlInputText getCOMP_UI_M_PCI_ASSRD_NAME() {
		return COMP_UI_M_PCI_ASSRD_NAME;
	}

	public void setCOMP_UI_M_PCI_ASSRD_NAME(HtmlInputText comp_ui_m_pci_assrd_name) {
		COMP_UI_M_PCI_ASSRD_NAME = comp_ui_m_pci_assrd_name;
	}
	/*Added by saranya for HAnds on point no 11 on 04-02-2017*/
public ArrayList<LovBean> lovPCI_ASSRD_REF_ID1(Object currValue) {
		String code = (String) currValue;
		ArrayList<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		try {
			if ("*".equals(code)) {
				object = new Object[] { PELConstants.suggetionRecordSize };
				query = "SELECT CUST_REF_ID1,CUST_NAME FROM PM_CUSTOMER " +
			    		"WHERE ROWNUM <= ? AND CUST_REF_ID1 IS NOT NULL ORDER BY 1";
			} else {
				object = new Object[] { code + "%", code + "%",
						PELConstants.suggetionRecordSize };
				query =  "SELECT CUST_REF_ID1,CUST_NAME FROM PM_CUSTOMER " +
			    		"WHERE (UPPER(CUST_REF_ID1) LIKE UPPER(?) OR UPPER(CUST_NAME) LIKE UPPER(?))"
			    		+ "AND CUST_REF_ID1 IS NOT NULL AND ROWNUM <= ? ORDER BY 1";
			}
			suggestionList = ListItemUtil.prepareSuggestionList(query, object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	/*End*/
	
//added by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 16/03/2017
public List<PT_IL_CLAIM> CUST_CODE_SUGGESTION_LIST(Object event) {
	PILT042_APAC_HELPER helper = new PILT042_APAC_HELPER();
	suggestionList = helper.lovCustCode(FacesContext.getCurrentInstance(),
			(String) event);
	return suggestionList;
}
//end



/*Added by Janani on 25.05.2017 for ZBILQC-1727100*/

private HtmlOutputLabel COMP_PCI_INTIMATION_SRC_LABEL;

private HtmlSelectOneMenu COMP_PCI_INTIMATION_SRC;

private HtmlOutputLabel COMP_PCI_INTIMATOR_NAME_LABEL;

private HtmlInputText COMP_PCI_INTIMATOR_NAME;

private HtmlOutputLabel COMP_PCI_INTIMATOR_MOBILE_LABEL;

private HtmlInputText COMP_PCI_INTIMATOR_MOBILE;

private HtmlOutputLabel COMP_PCI_INTIMATOR_EMAIL_LABEL;

private HtmlInputText COMP_PCI_INTIMATOR_EMAIL;

private List<SelectItem> listPCI_INTIMATION_SRC = new ArrayList<SelectItem>();

public HtmlOutputLabel getCOMP_PCI_INTIMATION_SRC_LABEL() {
	return COMP_PCI_INTIMATION_SRC_LABEL;
}

public void setCOMP_PCI_INTIMATION_SRC_LABEL(
		HtmlOutputLabel cOMP_PCI_INTIMATION_SRC_LABEL) {
	COMP_PCI_INTIMATION_SRC_LABEL = cOMP_PCI_INTIMATION_SRC_LABEL;
}

public HtmlSelectOneMenu getCOMP_PCI_INTIMATION_SRC() {
	return COMP_PCI_INTIMATION_SRC;
}

public void setCOMP_PCI_INTIMATION_SRC(HtmlSelectOneMenu cOMP_PCI_INTIMATION_SRC) {
	COMP_PCI_INTIMATION_SRC = cOMP_PCI_INTIMATION_SRC;
}

public HtmlOutputLabel getCOMP_PCI_INTIMATOR_NAME_LABEL() {
	return COMP_PCI_INTIMATOR_NAME_LABEL;
}

public void setCOMP_PCI_INTIMATOR_NAME_LABEL(
		HtmlOutputLabel cOMP_PCI_INTIMATOR_NAME_LABEL) {
	COMP_PCI_INTIMATOR_NAME_LABEL = cOMP_PCI_INTIMATOR_NAME_LABEL;
}

public HtmlInputText getCOMP_PCI_INTIMATOR_NAME() {
	return COMP_PCI_INTIMATOR_NAME;
}

public void setCOMP_PCI_INTIMATOR_NAME(HtmlInputText cOMP_PCI_INTIMATOR_NAME) {
	COMP_PCI_INTIMATOR_NAME = cOMP_PCI_INTIMATOR_NAME;
}

public HtmlOutputLabel getCOMP_PCI_INTIMATOR_MOBILE_LABEL() {
	return COMP_PCI_INTIMATOR_MOBILE_LABEL;
}

public void setCOMP_PCI_INTIMATOR_MOBILE_LABEL(
		HtmlOutputLabel cOMP_PCI_INTIMATOR_MOBILE_LABEL) {
	COMP_PCI_INTIMATOR_MOBILE_LABEL = cOMP_PCI_INTIMATOR_MOBILE_LABEL;
}

public HtmlInputText getCOMP_PCI_INTIMATOR_MOBILE() {
	return COMP_PCI_INTIMATOR_MOBILE;
}

public void setCOMP_PCI_INTIMATOR_MOBILE(HtmlInputText cOMP_PCI_INTIMATOR_MOBILE) {
	COMP_PCI_INTIMATOR_MOBILE = cOMP_PCI_INTIMATOR_MOBILE;
}

public HtmlOutputLabel getCOMP_PCI_INTIMATOR_EMAIL_LABEL() {
	return COMP_PCI_INTIMATOR_EMAIL_LABEL;
}

public void setCOMP_PCI_INTIMATOR_EMAIL_LABEL(
		HtmlOutputLabel cOMP_PCI_INTIMATOR_EMAIL_LABEL) {
	COMP_PCI_INTIMATOR_EMAIL_LABEL = cOMP_PCI_INTIMATOR_EMAIL_LABEL;
}

public HtmlInputText getCOMP_PCI_INTIMATOR_EMAIL() {
	return COMP_PCI_INTIMATOR_EMAIL;
}

public void setCOMP_PCI_INTIMATOR_EMAIL(HtmlInputText cOMP_PCI_INTIMATOR_EMAIL) {
	COMP_PCI_INTIMATOR_EMAIL = cOMP_PCI_INTIMATOR_EMAIL;
}




public List<SelectItem> getListPCI_INTIMATION_SRC() {
	return listPCI_INTIMATION_SRC;
}

public void setListPCI_INTIMATION_SRC(List<SelectItem> listPCI_INTIMATION_SRC) {
	this.listPCI_INTIMATION_SRC = listPCI_INTIMATION_SRC;
}

public void resetAllComponent(){
	// Reseting HtmlInputText

	COMP_PCI_INTIMATION_SRC.resetValue();
	COMP_PCI_INTIMATOR_NAME.resetValue();
	COMP_PCI_INTIMATOR_MOBILE.resetValue();
	COMP_PCI_INTIMATOR_EMAIL.resetValue();
}

public void validatePCI_INTIMATION_SRC(FacesContext context,UIComponent component,Object object){
	String value = (String) object;
	
	try{
		
		if(value!=null){
		
		PT_IL_PRE_CLAIMS_INFO_BEAN.setPCI_INTIMATION_SRC(value);
		
		}
	//helper.validateCUST_TYPE(this);
	}catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	}
}

 public void setListItemValues() {
    	Connection connection = null;
    	
    	System.out.println("enters into setListItemValues");
    	try {
    	    connection = CommonUtils.getConnection();
    	    
    	    setListPCI_INTIMATION_SRC(ListItemUtil.getDropDownListValue(
    		    connection, "PILT042_APAC", "PT_IL_PRE_CLAIMS_INFO",
    		    "PT_IL_PRE_CLAIMS_INFO.PCI_INTIMATION_SRC", "INTIMATE_SRC"));
    	}catch (Exception e) {
    	    e.printStackTrace();
    	    // TODO: handle exception
    	}
 }

 public void validatePCI_INTIMATOR_NAME(FacesContext context,UIComponent component,Object object){
		String value = (String) object;
		
		try{
			
			if(value!=null){
			PT_IL_PRE_CLAIMS_INFO_BEAN.setPCI_INTIMATOR_NAME(value);
			
			}
		//helper.validateCUST_TYPE(this);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
 
 

 public void validatePCI_INTIMATOR_MOBILE(FacesContext context,UIComponent component,Object object){
	 String value = (String) object;
		
		try{
			
			if(value!=null){
			
				PT_IL_PRE_CLAIMS_INFO_BEAN.setPCI_INTIMATOR_MOBILE(value);
			helper.vaildateValues(value);
			
			}
		//helper.validateCUST_TYPE(this);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
 
 
 public void validatePCI_INTIMATOR_EMAIL(FacesContext context,UIComponent component,Object object){
		String value = (String) object;
		
		try{
			
			if(value!=null){
			PT_IL_PRE_CLAIMS_INFO_BEAN.setPCI_INTIMATOR_EMAIL(value);
			
			}
		//helper.validateCUST_TYPE(this);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
 
 
 /*End*/



}


