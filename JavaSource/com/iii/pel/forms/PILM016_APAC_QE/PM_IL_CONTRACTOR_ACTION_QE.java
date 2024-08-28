package com.iii.pel.forms.PILM016_APAC_QE;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.jsp.tagext.TryCatchFinally;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.ajax4jsf.taglib.html.jsp.AjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlModalPanel;
import org.richfaces.component.html.HtmlTogglePanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
import com.vembu.b.a4;

public class PM_IL_CONTRACTOR_ACTION_QE extends CommonAction{

	private HtmlOutputLabel COMP_CONT_CODE_LABEL;
	private HtmlInputText COMP_CONT_CODE;
	private HtmlOutputLabel COMP_CONT_NAME_LABEL;
	private HtmlInputText COMP_CONT_NAME;
	private HtmlOutputLabel COMP_CONT_REF_ID1_LABEL;
	private HtmlInputText COMP_CONT_REF_ID1;
	private HtmlOutputLabel COMP_CONT_REF_ID2_LABEL;
	private HtmlInputText COMP_CONT_REF_ID2;
	private HtmlOutputLabel COMP_CONT_DOB_LABEL;
	private HtmlCalendar COMP_CONT_DOB;
	private HtmlOutputLabel COMP_CONT_CATG_CODE_LABEL;
	private HtmlInputText COMP_CONT_CATG_CODE;
	private HtmlInputText COMP_UI_M_CONT_CATG_CODE_DESC;
	private HtmlOutputLabel COMP_CONT_ADDR1_LABEL;
	private HtmlInputText COMP_CONT_ADDR1;
	private HtmlOutputLabel COMP_CONT_ADDR2_LABEL;
	private HtmlInputText COMP_CONT_ADDR2;
	private HtmlOutputLabel COMP_CONT_POSTAL_CODE_LABEL;
	private HtmlInputText COMP_CONT_POSTAL_CODE;
	private HtmlOutputLabel COMP_CONT_EMAIL_ID_LABEL;
	private HtmlInputText COMP_CONT_EMAIL_ID;
	
	private HtmlModalPanel COMP_REPORT_MODAL_PANEL_ASSURED;
	
	/* Newly Added By Dhinesh on 13-04-2018 */
	
	private HtmlAjaxCommandButton COMP_ASSURD_SAVE_BUT_OK;
	
	public HtmlAjaxCommandButton getCOMP_ASSURD_SAVE_BUT_OK() {
		return COMP_ASSURD_SAVE_BUT_OK;
	}

	public void setCOMP_ASSURD_SAVE_BUT_OK(
			HtmlAjaxCommandButton cOMP_ASSURD_SAVE_BUT_OK) {
		COMP_ASSURD_SAVE_BUT_OK = cOMP_ASSURD_SAVE_BUT_OK;
	}
	
	/* End */
	

	public PM_IL_CONTRACTOR_QE PM_IL_CONTRACTOR_QE_BEAN;
	public PM_IL_CONTRACTOR_HELPER_QE helper;
	public PM_IL_CONTRACTOR_DELEGATE_QE delegate;
	public PILT002_APAC_COMPOSITE_ACTION compositeAction;
	
	public PILT002_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	private List catgCodeList;
	
	public List getCatgCodeList() {
		return catgCodeList;
	}

	public void setCatgCodeList(List catgCodeList) {
		this.catgCodeList = catgCodeList;
	}

	public PM_IL_CONTRACTOR_ACTION_QE(){
		PM_IL_CONTRACTOR_QE_BEAN = new PM_IL_CONTRACTOR_QE();
		helper = new PM_IL_CONTRACTOR_HELPER_QE();
		delegate = new PM_IL_CONTRACTOR_DELEGATE_QE();
		/*try {
			compositeAction=new PILT002_APAC_COMPOSITE_ACTION();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		/*Added by Janani on 07.06.2017 for SSP id ZBILQC-1726439*/
		itemListCONT_SOCIAL_MEDIA_TYPE=delegate
				.getDropDownListValue("PM006_A_APAC", "PM_CUSTOMER",
						"PM_CUSTOMER.CUST_SOCIAL_MEDIA_TYPE", "MEDIA_TYPE");
		
		instantiateAllComponent();
		/*eND*/
			
	}

	public PM_IL_CONTRACTOR_QE getPM_IL_CONTRACTOR_QE_BEAN() {
		return PM_IL_CONTRACTOR_QE_BEAN;
	}

	public void setPM_IL_CONTRACTOR_QE_BEAN(
			PM_IL_CONTRACTOR_QE pm_il_contractor_qe_bean) {
		PM_IL_CONTRACTOR_QE_BEAN = pm_il_contractor_qe_bean;
	}

	public PM_IL_CONTRACTOR_HELPER_QE getHelper() {
		return helper;
	}

	public void setHelper(PM_IL_CONTRACTOR_HELPER_QE helper) {
		this.helper = helper;
	}

	public PM_IL_CONTRACTOR_DELEGATE_QE getDelegate() {
		return delegate;
	}

	public void setDelegate(PM_IL_CONTRACTOR_DELEGATE_QE delegate) {
		this.delegate = delegate;
	}


	/**
	 * Instantiates all components in PM_IL_CONTRACTOR_ACTION_QE
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_CONT_CODE					 = new HtmlInputText();
		COMP_CONT_NAME					 = new HtmlInputText();
		COMP_CONT_REF_ID1				 = new HtmlInputText();
		COMP_CONT_REF_ID2				 = new HtmlInputText();
		COMP_CONT_DOB					 = new HtmlCalendar();
		COMP_CONT_CATG_CODE				 = new HtmlInputText();
		COMP_UI_M_CONT_CATG_CODE_DESC			 = new HtmlInputText();
		COMP_CONT_ADDR1					 = new HtmlInputText();
		COMP_CONT_ADDR2					 = new HtmlInputText();
		COMP_CONT_POSTAL_CODE				 = new HtmlInputText();
		COMP_CONT_EMAIL_ID				 = new HtmlInputText();
	
		/*Added by Janani on 07.06.2017 for SSP id ZBILQC-1726439*/
	
		COMP_CONT_ADDR3					 = new HtmlInputText();
		COMP_CONT_CITY_CODE               = new HtmlInputText();
		COMP_CONT_CITY                    = new HtmlInputText();
		COMP_CONT_STATE                    = new HtmlInputText();
		COMP_UI_M_CONT_STATE_CODE_DESC      = new HtmlInputText();
		COMP_CONT_COUNT_CODE                = new HtmlInputText();
		COMP_CONT_COUNTRY                   = new HtmlInputText();
		COMP_CONT_TEL_AREA_CODE2              = new HtmlInputText();
		COMP_CONT_PHONE2                     = new HtmlInputText();
		COMP_CONT_TEL_AREA_CODE               = new HtmlInputText();
		COMP_CONT_PHONE                       = new HtmlInputText();
		COMP_CONT_FAX_AREA_CODE                = new HtmlInputText();
		COMP_CONT_FAX                          = new HtmlInputText();
		COMP_CONT_EMAIL_ID_PER                  = new HtmlInputText();
		COMP_CONT_SOCIAL_MEDIA_TYPE              = new HtmlSelectOneMenu();
		COMP_CONT_SOCIAL_MEDIA_MAIL_ID            = new HtmlInputText();
		
		COMP_ASSURD_SAVE_BUT_OK              = new HtmlAjaxCommandButton();                
		
		/*End*/
		
		/*Added by Janani on 23.03.2018 for KIC assured dtls screen */
		COMP_CONT_TOGGLE = new HtmlTogglePanel();
		COMP_CONT_PHY_ADDR1_LABEL = new HtmlOutputLabel();
		COMP_CONT_PHY_ADDR1 = new HtmlInputText();
		COMP_CONT_PHY_ADDR2_LABEL = new HtmlOutputLabel();
		COMP_CONT_PHY_ADDR2 = new HtmlInputText();
		COMP_CONT_PHY_ADDR3_LABEL = new HtmlOutputLabel();
		COMP_CONT_PHY_ADDR3 = new HtmlInputText();
		COMP_CONT_PHY_ADDR3 = new HtmlInputText();
		COMP_CONT_PHY_CITY_CODE = new HtmlInputText();
		COMP_CONT_PHY_CITY = new HtmlInputText();
		COMP_CONT_PHY_COUNTRY_LABEL = new HtmlOutputLabel();
		COMP_CONT_PHY_COUNT_CODE = new HtmlInputText();
		COMP_CONT_PHY_COUNTRY = new HtmlInputText();
		COMP_CONT_PHY_POSTAL_CODE_LABEL = new HtmlOutputLabel();
		COMP_CONT_PHY_POSTAL_CODE = new HtmlInputText();
		COMP_CONT_PHY_MOBILE_NO_LABEL = new HtmlOutputLabel();
		COMP_CONT_PHY_MOB_AREA_CODE = new HtmlInputText();
		COMP_CONT_PHY_MOBILE_NO = new HtmlInputText();
		COMP_CONT_PHY_PHONE_LABEL = new HtmlOutputLabel();
		COMP_CONT_PHY_TEL_AREA_CODE = new HtmlInputText();
		COMP_CONT_PHY_PHONE = new HtmlInputText();
		COMP_CONT_PHY_FAX_LABEL = new HtmlOutputLabel();
		COMP_CONT_PHY_FAX_AREA_CODE = new HtmlInputText();
		COMP_CONT_PHY_FAX = new HtmlInputText();
		COMP_CONT_PHY_EMAIL_ID_LABEL = new HtmlOutputLabel();
		COMP_CONT_PHY_EMAIL_ID = new HtmlInputText();
		COMP_CONT_CORR_ADDR1_LABEL = new HtmlOutputLabel();
		COMP_CONT_CORR_ADDR1 = new HtmlInputText();
		COMP_CONT_CORR_ADDR2_LABEL = new HtmlOutputLabel();
		COMP_CONT_CORR_ADDR2 = new HtmlInputText();
		COMP_CONT_CORR_ADDR3_LABEL = new HtmlOutputLabel();
		COMP_CONT_CORR_ADDR3 = new HtmlInputText();
		COMP_CONT_CORR_CITY_LABEL = new HtmlOutputLabel();
		COMP_CONT_CORR_CITY_CODE = new HtmlInputText();
		COMP_CONT_CORR_CITY = new HtmlInputText();
		COMP_CONT_CORR_COUNTRY_LABEL = new HtmlOutputLabel();
		COMP_CONT_CORR_COUNT_CODE = new HtmlInputText();
		COMP_CONT_CORR_COUNTRY = new HtmlInputText();
		COMP_CONT_CORR_POSTAL_CODE_LABEL = new HtmlOutputLabel();
		COMP_CONT_CORR_POSTAL_CODE = new HtmlInputText();
		COMP_CONT_CORR_MOBILE_NO_LABEL = new HtmlOutputLabel();
		COMP_CONT_CORR_MOB_CODE = new HtmlInputText();
		COMP_CONT_CORR_MOBILE_NO = new HtmlInputText();
		COMP_CONT_CORR_PHONE_LABEL = new HtmlOutputLabel();
		COMP_CONT_CORR_TEL_AREA_CODE = new HtmlInputText();
		COMP_CONT_CORR_PHONE = new HtmlInputText();
		COMP_CONT_CORR_FAX_LABEL = new HtmlOutputLabel();
		COMP_CONT_CORR_FAX_AREA_CODE = new HtmlInputText();
		COMP_CONT_CORR_FAX = new HtmlInputText();
		COMP_CONT_CORR_EMAIL_ID_LABEL = new HtmlOutputLabel();
		COMP_CONT_CORR_EMAIL_ID = new HtmlInputText();
		
		COMP_CONT_OCC_CODE_LABEL = new HtmlOutputLabel();
		COMP_CONT_OCC_CODE = new HtmlInputText();
		COMP_UI_M_CONT_OCC_DESC = new HtmlInputText();
		/*End*/
		
		/*added by Ameen on 09-04-2018 for KIC nationality adding field*/
		COMP_CONT_NATIONALITY_CODE =  new HtmlInputText();
		COMP_UI_M_CONT_NATIONALITY_CODE_DESC = new HtmlInputText();
		COMP_CONT_REMARKS = new HtmlInputText();
		/*End*/

	}

	/**
	 * Resets all components in PM_IL_CONTRACTOR_ACTION_QE
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_CONT_CODE.resetValue();
		COMP_CONT_NAME.resetValue();
		COMP_CONT_REF_ID1.resetValue();
		COMP_CONT_REF_ID2.resetValue();
		COMP_CONT_DOB.resetValue();
		COMP_CONT_CATG_CODE.resetValue();
		COMP_UI_M_CONT_CATG_CODE_DESC.resetValue();
		COMP_CONT_ADDR1.resetValue();
		COMP_CONT_ADDR2.resetValue();
		COMP_CONT_POSTAL_CODE.resetValue();
		COMP_CONT_EMAIL_ID.resetValue();
		
		
		/*Added by Janani on 07.06.2017 for SSP id ZBILQC-1726439*/
		COMP_CONT_ADDR3.resetValue();
		COMP_CONT_CITY_CODE.resetValue();
		COMP_CONT_CITY.resetValue();
		COMP_CONT_STATE.resetValue();
		COMP_UI_M_CONT_STATE_CODE_DESC.resetValue();
		COMP_CONT_COUNT_CODE.resetValue();
		COMP_CONT_COUNTRY.resetValue();
		COMP_CONT_TEL_AREA_CODE2.resetValue();
		COMP_CONT_PHONE2.resetValue();
		COMP_CONT_TEL_AREA_CODE.resetValue();
		COMP_CONT_PHONE.resetValue();
		COMP_CONT_FAX_AREA_CODE.resetValue();
		COMP_CONT_FAX.resetValue();
		COMP_CONT_EMAIL_ID_PER.resetValue();
		COMP_CONT_SOCIAL_MEDIA_TYPE.resetValue();
		COMP_CONT_SOCIAL_MEDIA_MAIL_ID.resetValue();
		
		/*End*/

		/*Added by Janani on 23.03.2018 for KIC assured dtls screen */
		COMP_CONT_TOGGLE.resetValue();
		COMP_CONT_PHY_ADDR1.resetValue();
		COMP_CONT_PHY_ADDR2.resetValue();
		COMP_CONT_PHY_ADDR3.resetValue();
		COMP_CONT_PHY_ADDR3.resetValue();
		COMP_CONT_PHY_CITY_CODE.resetValue();
		COMP_CONT_PHY_CITY.resetValue();
		COMP_CONT_PHY_COUNT_CODE.resetValue();
		COMP_CONT_PHY_COUNTRY.resetValue();
		COMP_CONT_PHY_POSTAL_CODE.resetValue();
		COMP_CONT_PHY_MOB_AREA_CODE.resetValue();
		COMP_CONT_PHY_MOBILE_NO.resetValue();
		COMP_CONT_PHY_TEL_AREA_CODE.resetValue();
		COMP_CONT_PHY_PHONE.resetValue();
		COMP_CONT_PHY_FAX_AREA_CODE.resetValue();
		COMP_CONT_PHY_FAX.resetValue();
		COMP_CONT_PHY_EMAIL_ID.resetValue();
		COMP_CONT_CORR_ADDR1.resetValue();
		COMP_CONT_CORR_ADDR2.resetValue();
		COMP_CONT_CORR_ADDR3.resetValue();
		COMP_CONT_CORR_CITY_CODE.resetValue();
		COMP_CONT_CORR_CITY.resetValue();
		COMP_CONT_CORR_COUNT_CODE.resetValue();
		COMP_CONT_CORR_COUNTRY.resetValue();
		COMP_CONT_CORR_POSTAL_CODE.resetValue();
		COMP_CONT_CORR_MOB_CODE.resetValue();
		COMP_CONT_CORR_MOBILE_NO.resetValue();
		COMP_CONT_CORR_TEL_AREA_CODE.resetValue();
		COMP_CONT_CORR_PHONE.resetValue();
		COMP_CONT_CORR_FAX_AREA_CODE.resetValue();
		COMP_CONT_CORR_FAX.resetValue();
		COMP_CONT_CORR_EMAIL_ID.resetValue();
		
		
		COMP_CONT_OCC_CODE.resetValue();
		COMP_UI_M_CONT_OCC_DESC.resetValue();
		/*End*/
		
		/*added by Ameen on 09-04-2018 for KIC nationality adding field*/
		COMP_CONT_NATIONALITY_CODE.resetValue();
		COMP_UI_M_CONT_NATIONALITY_CODE_DESC.resetValue();
		COMP_CONT_REMARKS.resetValue();
		/*End*/

	}

	/**
	 * Disables all components in PM_IL_CONTRACTOR_ACTION_QE
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_CONT_CODE.setDisabled(disabled);
		COMP_CONT_NAME.setDisabled(disabled);
		COMP_CONT_REF_ID1.setDisabled(disabled);
		COMP_CONT_REF_ID2.setDisabled(disabled);
		COMP_CONT_DOB.setDisabled(disabled);
		COMP_CONT_CATG_CODE.setDisabled(disabled);
		COMP_UI_M_CONT_CATG_CODE_DESC.setDisabled(disabled);
		COMP_CONT_ADDR1.setDisabled(disabled);
		COMP_CONT_ADDR2.setDisabled(disabled);
		COMP_CONT_POSTAL_CODE.setDisabled(disabled);
		//COMP_CONT_EMAIL_ID.setDisabled(disabled);
		
		/*Added by Janani on 07.06.2017 for SSP id ZBILQC-1726439*/
		
		COMP_CONT_ADDR3.setDisabled(disabled);
		COMP_CONT_CITY_CODE.setDisabled(disabled);
		COMP_CONT_CITY.setDisabled(disabled);
		COMP_CONT_STATE.setDisabled(disabled);
		COMP_UI_M_CONT_STATE_CODE_DESC.setDisabled(disabled);
		COMP_CONT_COUNT_CODE.setDisabled(disabled);
		COMP_CONT_COUNTRY.setDisabled(disabled);
		COMP_CONT_TEL_AREA_CODE2.setDisabled(disabled);
		COMP_CONT_PHONE2.setDisabled(disabled);
		COMP_CONT_TEL_AREA_CODE.setDisabled(disabled);
		COMP_CONT_PHONE.setDisabled(disabled);
		COMP_CONT_FAX_AREA_CODE.setDisabled(disabled);
		COMP_CONT_FAX.setDisabled(disabled);
		COMP_CONT_EMAIL_ID_PER.setDisabled(disabled);
		COMP_CONT_SOCIAL_MEDIA_TYPE.setDisabled(disabled);
		COMP_CONT_SOCIAL_MEDIA_MAIL_ID.setDisabled(disabled);
		
		/*End*/
		
		/*Added by Janani on 23.03.2018 for KIC*/
		
		COMP_CONT_PHY_ADDR1.setDisabled(disabled);
		COMP_CONT_PHY_ADDR2.setDisabled(disabled);
		COMP_CONT_PHY_ADDR3.setDisabled(disabled);
		COMP_CONT_PHY_ADDR3.setDisabled(disabled);
		COMP_CONT_PHY_CITY_CODE.setDisabled(disabled);
		COMP_CONT_PHY_CITY.setDisabled(disabled);
		COMP_CONT_PHY_COUNT_CODE.setDisabled(disabled);
		COMP_CONT_PHY_COUNTRY.setDisabled(disabled);
		COMP_CONT_PHY_POSTAL_CODE.setDisabled(disabled);
		COMP_CONT_PHY_MOB_AREA_CODE.setDisabled(disabled);
		COMP_CONT_PHY_MOBILE_NO.setDisabled(disabled);
		COMP_CONT_PHY_TEL_AREA_CODE.setDisabled(disabled);
		COMP_CONT_PHY_PHONE.setDisabled(disabled);
		COMP_CONT_PHY_FAX_AREA_CODE.setDisabled(disabled);
		COMP_CONT_PHY_FAX.setDisabled(disabled);
		COMP_CONT_PHY_EMAIL_ID.setDisabled(disabled);
		COMP_CONT_CORR_ADDR1.setDisabled(disabled);
		COMP_CONT_CORR_ADDR2.setDisabled(disabled);
		COMP_CONT_CORR_ADDR3.setDisabled(disabled);
		COMP_CONT_CORR_CITY_CODE.setDisabled(disabled);
		COMP_CONT_CORR_CITY.setDisabled(disabled);
		COMP_CONT_CORR_COUNT_CODE.setDisabled(disabled);
		COMP_CONT_CORR_COUNTRY.setDisabled(disabled);
		COMP_CONT_CORR_POSTAL_CODE.setDisabled(disabled);
		COMP_CONT_CORR_MOB_CODE.setDisabled(disabled);
		COMP_CONT_CORR_MOBILE_NO.setDisabled(disabled);
		COMP_CONT_CORR_TEL_AREA_CODE.setDisabled(disabled);
		COMP_CONT_CORR_PHONE.setDisabled(disabled);
		COMP_CONT_CORR_FAX_AREA_CODE.setDisabled(disabled);
		COMP_CONT_CORR_FAX.setDisabled(disabled);
		COMP_CONT_CORR_EMAIL_ID.setDisabled(disabled);
		
		COMP_CONT_OCC_CODE.setDisabled(disabled);
		COMP_UI_M_CONT_OCC_DESC.setDisabled(disabled);
		
		/*End*/
		
		/*added by Ameen on 09-04-2018 for KIC nationality adding field*/
		COMP_CONT_NATIONALITY_CODE.setDisabled(disabled);
		COMP_UI_M_CONT_NATIONALITY_CODE_DESC.setDisabled(disabled);
		COMP_CONT_REMARKS.setDisabled(disabled);
		/*End*/
		
		
		/* Newly Added By Dhinesh on 13-04-2018 */
		COMP_ASSURD_SAVE_BUT_OK.setDisabled(disabled);
		/* End */
		
	}

	public HtmlOutputLabel getCOMP_CONT_CODE_LABEL() {
		return COMP_CONT_CODE_LABEL;
	}

	public void setCOMP_CONT_CODE_LABEL(HtmlOutputLabel comp_cont_code_label) {
		COMP_CONT_CODE_LABEL = comp_cont_code_label;
	}

	public HtmlInputText getCOMP_CONT_CODE() {
		return COMP_CONT_CODE;
	}

	public void setCOMP_CONT_CODE(HtmlInputText comp_cont_code) {
		COMP_CONT_CODE = comp_cont_code;
	}

	public HtmlOutputLabel getCOMP_CONT_NAME_LABEL() {
		return COMP_CONT_NAME_LABEL;
	}

	public void setCOMP_CONT_NAME_LABEL(HtmlOutputLabel comp_cont_name_label) {
		COMP_CONT_NAME_LABEL = comp_cont_name_label;
	}

	public HtmlInputText getCOMP_CONT_NAME() {
		return COMP_CONT_NAME;
	}

	public void setCOMP_CONT_NAME(HtmlInputText comp_cont_name) {
		COMP_CONT_NAME = comp_cont_name;
	}

	public HtmlOutputLabel getCOMP_CONT_REF_ID1_LABEL() {
		return COMP_CONT_REF_ID1_LABEL;
	}

	public void setCOMP_CONT_REF_ID1_LABEL(HtmlOutputLabel comp_cont_ref_id1_label) {
		COMP_CONT_REF_ID1_LABEL = comp_cont_ref_id1_label;
	}

	public HtmlInputText getCOMP_CONT_REF_ID1() {
		return COMP_CONT_REF_ID1;
	}

	public void setCOMP_CONT_REF_ID1(HtmlInputText comp_cont_ref_id1) {
		COMP_CONT_REF_ID1 = comp_cont_ref_id1;
	}

	public HtmlOutputLabel getCOMP_CONT_REF_ID2_LABEL() {
		return COMP_CONT_REF_ID2_LABEL;
	}

	public void setCOMP_CONT_REF_ID2_LABEL(HtmlOutputLabel comp_cont_ref_id2_label) {
		COMP_CONT_REF_ID2_LABEL = comp_cont_ref_id2_label;
	}

	public HtmlInputText getCOMP_CONT_REF_ID2() {
		return COMP_CONT_REF_ID2;
	}

	public void setCOMP_CONT_REF_ID2(HtmlInputText comp_cont_ref_id2) {
		COMP_CONT_REF_ID2 = comp_cont_ref_id2;
	}

	public HtmlOutputLabel getCOMP_CONT_DOB_LABEL() {
		return COMP_CONT_DOB_LABEL;
	}

	public void setCOMP_CONT_DOB_LABEL(HtmlOutputLabel comp_cont_dob_label) {
		COMP_CONT_DOB_LABEL = comp_cont_dob_label;
	}
	
	public HtmlCalendar getCOMP_CONT_DOB() {
		return COMP_CONT_DOB;
	}

	public void setCOMP_CONT_DOB(HtmlCalendar comp_cont_dob) {
		COMP_CONT_DOB = comp_cont_dob;
	}

	public HtmlOutputLabel getCOMP_CONT_CATG_CODE_LABEL() {
		return COMP_CONT_CATG_CODE_LABEL;
	}

	public void setCOMP_CONT_CATG_CODE_LABEL(
			HtmlOutputLabel comp_cont_catg_code_label) {
		COMP_CONT_CATG_CODE_LABEL = comp_cont_catg_code_label;
	}

	public HtmlInputText getCOMP_CONT_CATG_CODE() {
		return COMP_CONT_CATG_CODE;
	}

	public void setCOMP_CONT_CATG_CODE(HtmlInputText comp_cont_catg_code) {
		COMP_CONT_CATG_CODE = comp_cont_catg_code;
	}

	public HtmlInputText getCOMP_UI_M_CONT_CATG_CODE_DESC() {
		return COMP_UI_M_CONT_CATG_CODE_DESC;
	}

	public void setCOMP_UI_M_CONT_CATG_CODE_DESC(
			HtmlInputText comp_ui_m_cont_catg_code_desc) {
		COMP_UI_M_CONT_CATG_CODE_DESC = comp_ui_m_cont_catg_code_desc;
	}

	public HtmlOutputLabel getCOMP_CONT_ADDR1_LABEL() {
		return COMP_CONT_ADDR1_LABEL;
	}

	public void setCOMP_CONT_ADDR1_LABEL(HtmlOutputLabel comp_cont_addr1_label) {
		COMP_CONT_ADDR1_LABEL = comp_cont_addr1_label;
	}

	public HtmlInputText getCOMP_CONT_ADDR1() {
		return COMP_CONT_ADDR1;
	}

	public void setCOMP_CONT_ADDR1(HtmlInputText comp_cont_addr1) {
		COMP_CONT_ADDR1 = comp_cont_addr1;
	}

	public HtmlOutputLabel getCOMP_CONT_ADDR2_LABEL() {
		return COMP_CONT_ADDR2_LABEL;
	}

	public void setCOMP_CONT_ADDR2_LABEL(HtmlOutputLabel comp_cont_addr2_label) {
		COMP_CONT_ADDR2_LABEL = comp_cont_addr2_label;
	}

	public HtmlInputText getCOMP_CONT_ADDR2() {
		return COMP_CONT_ADDR2;
	}

	public void setCOMP_CONT_ADDR2(HtmlInputText comp_cont_addr2) {
		COMP_CONT_ADDR2 = comp_cont_addr2;
	}

	public HtmlOutputLabel getCOMP_CONT_POSTAL_CODE_LABEL() {
		return COMP_CONT_POSTAL_CODE_LABEL;
	}

	public void setCOMP_CONT_POSTAL_CODE_LABEL(
			HtmlOutputLabel comp_cont_postal_code_label) {
		COMP_CONT_POSTAL_CODE_LABEL = comp_cont_postal_code_label;
	}

	public HtmlInputText getCOMP_CONT_POSTAL_CODE() {
		return COMP_CONT_POSTAL_CODE;
	}

	public void setCOMP_CONT_POSTAL_CODE(HtmlInputText comp_cont_postal_code) {
		COMP_CONT_POSTAL_CODE = comp_cont_postal_code;
	}

	public HtmlOutputLabel getCOMP_CONT_EMAIL_ID_LABEL() {
		return COMP_CONT_EMAIL_ID_LABEL;
	}

	public void setCOMP_CONT_EMAIL_ID_LABEL(HtmlOutputLabel comp_cont_email_id_label) {
		COMP_CONT_EMAIL_ID_LABEL = comp_cont_email_id_label;
	}

	public HtmlInputText getCOMP_CONT_EMAIL_ID() {
		return COMP_CONT_EMAIL_ID;
	}

	public void setCOMP_CONT_EMAIL_ID(HtmlInputText comp_cont_email_id) {
		COMP_CONT_EMAIL_ID = comp_cont_email_id;
	}
	
	public void fireFieldValidation(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public String assuredsaveRecord(){
		CommonUtils.clearMaps(this); 
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String message = null;
		try {
			connection = CommonUtils.getConnection();
			if (PM_IL_CONTRACTOR_QE_BEAN.getROWID() == null) {
				/*Added by saritha on 06-04-2018 for KIC CIVIL ID to be numeric field.validation to be there.*/
				validateIdentificationNumber(PM_IL_CONTRACTOR_QE_BEAN.getCONT_REF_ID1());
				/*End*/
				if(PM_IL_CONTRACTOR_QE_BEAN.getCONT_CODE()== null){
					helper.P_CREATE_NUMBER(this);
				}
				helper.pre_insert(PM_IL_CONTRACTOR_QE_BEAN);
				handler.executeInsert(PM_IL_CONTRACTOR_QE_BEAN, connection);
				if(PM_IL_CONTRACTOR_QE_BEAN.getCONT_CODE() != null){
				CommonUtils.setGlobalVariable("GLOBAL.CONT_CODE", PM_IL_CONTRACTOR_QE_BEAN.getCONT_CODE());
				}
				/*Added by Ameen on 20-04-2018 for KIC ,customer and assrd. same scenario*/
				if(PM_IL_CONTRACTOR_QE_BEAN.getCONT_REF_ID1()!=null){
				CommonUtils.setGlobalVariable("GLOBAL.REFID2", PM_IL_CONTRACTOR_QE_BEAN.getCONT_REF_ID1());
				CommonUtils.setGlobalVariable("GLOBAL.FLAGCUST", "TRUE");
				}
				/*End*/
				/*added by raja*/
				
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_ASSURED_NAME().setDisabled(false);
				System.out.println("PM_IL_CONTRACTOR_QE_BEAN.getCONT_CODE()=========="+PM_IL_CONTRACTOR_QE_BEAN.getCONT_CODE());
				System.out.println("PM_IL_CONTRACTOR_QE_BEAN.getCONT_NAME()==========="+PM_IL_CONTRACTOR_QE_BEAN.getCONT_NAME());
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setPOL_CONT_CODE(PM_IL_CONTRACTOR_QE_BEAN.getCONT_CODE());
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setPOL_ASSURED_NAME(PM_IL_CONTRACTOR_QE_BEAN.getCONT_NAME());
				
				/* Newly Added By Dhinesh on 12-04-2018 */
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setPOL_ASSRD_REF_ID2(PM_IL_CONTRACTOR_QE_BEAN.getCONT_REF_ID1());
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_ASSRD_REF_ID2().setDisabled(false);
				/* End */
				
				System.out.println("after setting the value==="+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_CONT_CODE());
				System.out.println("cont name =========="+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_ASSURED_NAME());
				
				PM_IL_CONTRACTOR_QE_BEAN.setASSURED_FLAG(true);
				
				System.out.println("Flag value +_+_+_+_+"+PM_IL_CONTRACTOR_QE_BEAN.isASSURED_FLAG());
	
				/*Added by Janani on 23.03.2018 for KIC*/
				compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_CONT_CODE().setDisabled(true);
				compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getCOMP_CONT_CODE().setValue(PM_IL_CONTRACTOR_QE_BEAN.getCONT_CODE());
				/*End*/
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_CONT_CODE().resetValue();
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_ASSURED_NAME().resetValue();
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_POL_ASSURED_NAME().setDisabled(true);
				/*end*/
				/* Newly added By Dhinesh on 13-04-2018 */
				new PKG_PILT002_APAC().P_INS_CUST_ASSR_DTLS(PM_IL_CONTRACTOR_QE_BEAN.getCONT_CODE());
				/* End */
				message = Messages.getString("messageProperties","errorPanel$message$save");
				
				
			} else if(PM_IL_CONTRACTOR_QE_BEAN.getROWID() != null) {
				helper.pre_update(PM_IL_CONTRACTOR_QE_BEAN);
				handler.executeUpdate(PM_IL_CONTRACTOR_QE_BEAN, connection);
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
			}
			getCOMP_REPORT_MODAL_PANEL_ASSURED().setShowWhenRendered(false);
			connection.commit();
		
			getWarningMap().put("current",message);
			getWarningMap().put("detail",message);
		}catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("AssuredPanel", e.getMessage());
		}
		return "";
	}
	
	public void assuredCodeIsExists(FacesContext context, UIComponent component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_CODE((String)value);
			if(PM_IL_CONTRACTOR_QE_BEAN.getCONT_CODE() !=null){
				helper.uniqueCode(PM_IL_CONTRACTOR_QE_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateCONT_NAME(FacesContext fc, UIComponent component,Object value) throws ValidatorException{
		try{
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_NAME((String) value);
		
		/*Added By Raja 29.6.2016*/
			
			if(!(PM_IL_CONTRACTOR_QE_BEAN.getCONT_NAME().equals(null)))
			{
				PM_IL_CONTRACTOR_QE_BEAN.setASSURED_NAME_FLAG(true);
			}
			else{
				PM_IL_CONTRACTOR_QE_BEAN.setASSURED_NAME_FLAG(false);
			}
			
			/*End*/
		
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateCONT_ADDR1(FacesContext fc, UIComponent component,Object value) throws ValidatorException{
		try{
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_ADDR1((String) value);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateCONT_REF_ID1(FacesContext fc, UIComponent component,Object value){

		try{

			/*Added by saritha on 02-04-2018 for KIC CIVIL ID to be numeric field.validation to be there.*/

			String current =(String) value;
			//int numericField = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_CUST_ICVL")).intValue();
			//System.out.println("numericField ====>>" +numericField);


			//throw new Exception("my own exception");
			if(PM_IL_CONTRACTOR_QE_BEAN.getROWID()==null){

				/*duplicateID = RefIdDuplicate((String) value);

				if(numericField!= 2){

					helper.vaildateValues(current);

					if(duplicateID!=true){


					}else{
						throw new Exception("");

					}

				}

				PM_IL_CONTRACTOR_QE_BEAN.setCONT_REF_ID1((String) value);	*/
				
				validateIdentificationNumber(current);				
				PM_IL_CONTRACTOR_QE_BEAN.setCONT_REF_ID1((String) value);

			}

			/*End*/

			helper.pilm_apac_pm_il_contractor_cont_ref_id1_when_validate_item(this);
			resetAllComponent();

		}catch (Exception e) {
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN().getErrorMap()
			.put("current",e.getMessage());

			/*Added by saritha on 03-04-2018 for KIC Pop up message that the customer/Assured is already exist once ID is entered is required*/

			/*if(duplicateID)
				COMP_REPORT_MODAL_PANEL_DELETE.setShowWhenRendered(true);*/

			/*End*/
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void validateCONT_REF_ID2(FacesContext fc, UIComponent component,Object value) throws ValidatorException{
		try{
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_REF_ID2((String) value);
			helper.pilm_apac_pm_il_contractor_cont_ref_id2_when_validate_item(this);
			resetAllComponent();
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void listener_CONT_REF_ID2(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		String inputData = input.getSubmittedValue().toString();
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_REF_ID2(inputData);
			if (PM_IL_CONTRACTOR_QE_BEAN.getCONT_REF_ID1() == null
					&& PM_IL_CONTRACTOR_QE_BEAN.getCONT_REF_ID2() == null) {
				throw new ValidatorException(new FacesMessage(
						"Enter Atleast one IC Number"));
			}
			ErrorHelpUtil.validate(input, getErrorMap());
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
		}
	}
	
	/*public void validateCONT_CATEGORY_CODE(FacesContext context,UIComponent component,Object object){
		try {
			String query = "SELECT PS_CODE,PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'CATG' AND PS_CODE = ?";
			 Boolean flag = isValidateLovCode(query, new  Object[]{object});
			 if (flag == false) {
				throw new Exception("Code does not Exists.Please Re-enter");
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}*/
	
	//method to validate lov code by 55943  13-feb-2012.
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
	
	public List suggestionActionCatgCode(Object event) {
		String catgCode = (String) event;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();

			catgCodeList = prepareCatgCodeList(connection, catgCode, catgCodeList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return catgCodeList;
	}
	
	 public List prepareCatgCodeList(Connection connection,String catgCode, List catgCodeList) {

			String query = null;
			if ("*".equalsIgnoreCase(catgCode)) {
				query = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS_QE.PM_IL_CONTRACTOR_PREPARE_CATG_CODE_LIST;
					Object[] object={};
					catgCodeList = catgLOV(connection, query,object);

			} else {
					catgCode=catgCode+PILM016_PM_IL_CONTRACTOR_CONSTANTS_QE.PERCENTILE_FOR_SELECT_LIKE;
					Object[] object={catgCode};
					query = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS_QE.PM_IL_CONTRACTOR_PREPARE_CATG_CODE_LIST_LIKE;
					catgCodeList = catgLOV(connection, query,object);
			}
			return catgCodeList;
		}
	 
	 public List<PM_IL_CONTRACTOR_QE> catgLOV(Connection connection,String query,Object[] object)
		{
		List<PM_IL_CONTRACTOR_QE> catgCodeList = new ArrayList<PM_IL_CONTRACTOR_QE>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
			try
			{

			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				PM_IL_CONTRACTOR_QE pm_il_contractor = new PM_IL_CONTRACTOR_QE();
				pm_il_contractor.setCONT_CATG_CODE(resultSet.getString(1));
				pm_il_contractor.setUI_M_CONT_CATG_CODE_DESC(resultSet.getString(2));
				catgCodeList.add(pm_il_contractor);
			}
			}
			catch (Exception e) {
			e.printStackTrace();
		}
		return catgCodeList;
	}

	public HtmlModalPanel getCOMP_REPORT_MODAL_PANEL_ASSURED() {
		return COMP_REPORT_MODAL_PANEL_ASSURED;
	}

	public void setCOMP_REPORT_MODAL_PANEL_ASSURED(
			HtmlModalPanel comp_report_modal_panel_assured) {
		COMP_REPORT_MODAL_PANEL_ASSURED = comp_report_modal_panel_assured;
	}
	 
	 
	
/*Added by Janani on 07.06.2017 for SSP id ZBILQC-1726439*/
	
	
	
	private HtmlOutputLabel COMP_CONT_ADDR3_LABEL;
	
	private HtmlInputText COMP_CONT_ADDR3;
	
private HtmlOutputLabel COMP_CONT_CITY_CODE_LABEL;
	
	private HtmlInputText COMP_CONT_CITY_CODE;
	
	private HtmlInputText COMP_CONT_CITY;	
	
private HtmlOutputLabel COMP_CONT_STATE_LABEL;
	
	private HtmlInputText COMP_CONT_STATE;
	
	private HtmlInputText COMP_UI_M_CONT_STATE_CODE_DESC;
	
	
private HtmlOutputLabel COMP_CONT_COUNTRY_LABEL;
	
	private HtmlInputText COMP_CONT_COUNT_CODE;
	
	private HtmlInputText COMP_CONT_COUNTRY;
	
private HtmlOutputLabel COMP_CONT_PHONE2_LABEL;
	
	private HtmlInputText COMP_CONT_TEL_AREA_CODE2;
	
	private HtmlInputText COMP_CONT_PHONE2;	

private HtmlOutputLabel COMP_CONT_PHONE_LABEL;
	
	private HtmlInputText COMP_CONT_TEL_AREA_CODE;
	
	private HtmlInputText COMP_CONT_PHONE;	
	
	
private HtmlOutputLabel COMP_CONT_FAX_AREA_CODE_LABEL;
	
	private HtmlInputText COMP_CONT_FAX_AREA_CODE;	
	
	private HtmlInputText COMP_CONT_FAX;
	
	
private HtmlOutputLabel COMP_CONT_EMAIL_ID_PER_LABEL;
	
	private HtmlInputText COMP_CONT_EMAIL_ID_PER;	
	
	
private HtmlOutputLabel COMP_CONT_SOCIAL_MEDIA_TYPE_LABEL;
	
	private HtmlSelectOneMenu COMP_CONT_SOCIAL_MEDIA_TYPE;	
	
private HtmlOutputLabel COMP_CONT_SOCIAL_MEDIA_MAIL_ID_LABEL;
	
	private HtmlInputText COMP_CONT_SOCIAL_MEDIA_MAIL_ID;		
	
		
	List<SelectItem> itemListCONT_SOCIAL_MEDIA_TYPE = null;
	
	
	public HtmlOutputLabel getCOMP_CONT_ADDR3_LABEL() {
		return COMP_CONT_ADDR3_LABEL;
	}

	public void setCOMP_CONT_ADDR3_LABEL(HtmlOutputLabel cOMP_CONT_ADDR3_LABEL) {
		COMP_CONT_ADDR3_LABEL = cOMP_CONT_ADDR3_LABEL;
	}

	public HtmlInputText getCOMP_CONT_ADDR3() {
		return COMP_CONT_ADDR3;
	}

	public void setCOMP_CONT_ADDR3(HtmlInputText cOMP_CONT_ADDR3) {
		COMP_CONT_ADDR3 = cOMP_CONT_ADDR3;
	}

	public HtmlOutputLabel getCOMP_CONT_CITY_CODE_LABEL() {
		return COMP_CONT_CITY_CODE_LABEL;
	}

	public void setCOMP_CONT_CITY_CODE_LABEL(
			HtmlOutputLabel cOMP_CONT_CITY_CODE_LABEL) {
		COMP_CONT_CITY_CODE_LABEL = cOMP_CONT_CITY_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CONT_CITY_CODE() {
		return COMP_CONT_CITY_CODE;
	}

	public void setCOMP_CONT_CITY_CODE(HtmlInputText cOMP_CONT_CITY_CODE) {
		COMP_CONT_CITY_CODE = cOMP_CONT_CITY_CODE;
	}

	public HtmlInputText getCOMP_CONT_CITY() {
		return COMP_CONT_CITY;
	}

	public void setCOMP_CONT_CITY(HtmlInputText cOMP_CONT_CITY) {
		COMP_CONT_CITY = cOMP_CONT_CITY;
	}

	public HtmlOutputLabel getCOMP_CONT_STATE_LABEL() {
		return COMP_CONT_STATE_LABEL;
	}

	public void setCOMP_CONT_STATE_LABEL(HtmlOutputLabel cOMP_CONT_STATE_LABEL) {
		COMP_CONT_STATE_LABEL = cOMP_CONT_STATE_LABEL;
	}

	public HtmlInputText getCOMP_CONT_STATE() {
		return COMP_CONT_STATE;
	}

	public void setCOMP_CONT_STATE(HtmlInputText cOMP_CONT_STATE) {
		COMP_CONT_STATE = cOMP_CONT_STATE;
	}

	public HtmlInputText getCOMP_UI_M_CONT_STATE_CODE_DESC() {
		return COMP_UI_M_CONT_STATE_CODE_DESC;
	}

	public void setCOMP_UI_M_CONT_STATE_CODE_DESC(
			HtmlInputText cOMP_UI_M_CONT_STATE_CODE_DESC) {
		COMP_UI_M_CONT_STATE_CODE_DESC = cOMP_UI_M_CONT_STATE_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_CONT_COUNTRY_LABEL() {
		return COMP_CONT_COUNTRY_LABEL;
	}

	public void setCOMP_CONT_COUNTRY_LABEL(HtmlOutputLabel cOMP_CONT_COUNTRY_LABEL) {
		COMP_CONT_COUNTRY_LABEL = cOMP_CONT_COUNTRY_LABEL;
	}

	public HtmlInputText getCOMP_CONT_COUNT_CODE() {
		return COMP_CONT_COUNT_CODE;
	}

	public void setCOMP_CONT_COUNT_CODE(HtmlInputText cOMP_CONT_COUNT_CODE) {
		COMP_CONT_COUNT_CODE = cOMP_CONT_COUNT_CODE;
	}

	public HtmlInputText getCOMP_CONT_COUNTRY() {
		return COMP_CONT_COUNTRY;
	}

	public void setCOMP_CONT_COUNTRY(HtmlInputText cOMP_CONT_COUNTRY) {
		COMP_CONT_COUNTRY = cOMP_CONT_COUNTRY;
	}

	public HtmlOutputLabel getCOMP_CONT_PHONE2_LABEL() {
		return COMP_CONT_PHONE2_LABEL;
	}

	public void setCOMP_CONT_PHONE2_LABEL(HtmlOutputLabel cOMP_CONT_PHONE2_LABEL) {
		COMP_CONT_PHONE2_LABEL = cOMP_CONT_PHONE2_LABEL;
	}

	public HtmlInputText getCOMP_CONT_TEL_AREA_CODE2() {
		return COMP_CONT_TEL_AREA_CODE2;
	}

	public void setCOMP_CONT_TEL_AREA_CODE2(HtmlInputText cOMP_CONT_TEL_AREA_CODE2) {
		COMP_CONT_TEL_AREA_CODE2 = cOMP_CONT_TEL_AREA_CODE2;
	}

	public HtmlInputText getCOMP_CONT_PHONE2() {
		return COMP_CONT_PHONE2;
	}

	public void setCOMP_CONT_PHONE2(HtmlInputText cOMP_CONT_PHONE2) {
		COMP_CONT_PHONE2 = cOMP_CONT_PHONE2;
	}

	public HtmlOutputLabel getCOMP_CONT_PHONE_LABEL() {
		return COMP_CONT_PHONE_LABEL;
	}

	public void setCOMP_CONT_PHONE_LABEL(HtmlOutputLabel cOMP_CONT_PHONE_LABEL) {
		COMP_CONT_PHONE_LABEL = cOMP_CONT_PHONE_LABEL;
	}

	public HtmlInputText getCOMP_CONT_TEL_AREA_CODE() {
		return COMP_CONT_TEL_AREA_CODE;
	}

	public void setCOMP_CONT_TEL_AREA_CODE(HtmlInputText cOMP_CONT_TEL_AREA_CODE) {
		COMP_CONT_TEL_AREA_CODE = cOMP_CONT_TEL_AREA_CODE;
	}

	public HtmlInputText getCOMP_CONT_PHONE() {
		return COMP_CONT_PHONE;
	}

	public void setCOMP_CONT_PHONE(HtmlInputText cOMP_CONT_PHONE) {
		COMP_CONT_PHONE = cOMP_CONT_PHONE;
	}

	public HtmlOutputLabel getCOMP_CONT_FAX_AREA_CODE_LABEL() {
		return COMP_CONT_FAX_AREA_CODE_LABEL;
	}

	public void setCOMP_CONT_FAX_AREA_CODE_LABEL(
			HtmlOutputLabel cOMP_CONT_FAX_AREA_CODE_LABEL) {
		COMP_CONT_FAX_AREA_CODE_LABEL = cOMP_CONT_FAX_AREA_CODE_LABEL;
	}

	

	public HtmlInputText getCOMP_CONT_FAX_AREA_CODE() {
		return COMP_CONT_FAX_AREA_CODE;
	}

	public void setCOMP_CONT_FAX_AREA_CODE(HtmlInputText cOMP_CONT_FAX_AREA_CODE) {
		COMP_CONT_FAX_AREA_CODE = cOMP_CONT_FAX_AREA_CODE;
	}

	public HtmlInputText getCOMP_CONT_FAX() {
		return COMP_CONT_FAX;
	}

	public void setCOMP_CONT_FAX(HtmlInputText cOMP_CONT_FAX) {
		COMP_CONT_FAX = cOMP_CONT_FAX;
	}

	public HtmlOutputLabel getCOMP_CONT_EMAIL_ID_PER_LABEL() {
		return COMP_CONT_EMAIL_ID_PER_LABEL;
	}

	public void setCOMP_CONT_EMAIL_ID_PER_LABEL(
			HtmlOutputLabel cOMP_CONT_EMAIL_ID_PER_LABEL) {
		COMP_CONT_EMAIL_ID_PER_LABEL = cOMP_CONT_EMAIL_ID_PER_LABEL;
	}

	public HtmlInputText getCOMP_CONT_EMAIL_ID_PER() {
		return COMP_CONT_EMAIL_ID_PER;
	}

	public void setCOMP_CONT_EMAIL_ID_PER(HtmlInputText cOMP_CONT_EMAIL_ID_PER) {
		COMP_CONT_EMAIL_ID_PER = cOMP_CONT_EMAIL_ID_PER;
	}

	public HtmlOutputLabel getCOMP_CONT_SOCIAL_MEDIA_TYPE_LABEL() {
		return COMP_CONT_SOCIAL_MEDIA_TYPE_LABEL;
	}

	public void setCOMP_CONT_SOCIAL_MEDIA_TYPE_LABEL(
			HtmlOutputLabel cOMP_CONT_SOCIAL_MEDIA_TYPE_LABEL) {
		COMP_CONT_SOCIAL_MEDIA_TYPE_LABEL = cOMP_CONT_SOCIAL_MEDIA_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CONT_SOCIAL_MEDIA_TYPE() {
		return COMP_CONT_SOCIAL_MEDIA_TYPE;
	}

	public void setCOMP_CONT_SOCIAL_MEDIA_TYPE(
			HtmlSelectOneMenu cOMP_CONT_SOCIAL_MEDIA_TYPE) {
		COMP_CONT_SOCIAL_MEDIA_TYPE = cOMP_CONT_SOCIAL_MEDIA_TYPE;
	}

	public HtmlOutputLabel getCOMP_CONT_SOCIAL_MEDIA_MAIL_ID_LABEL() {
		return COMP_CONT_SOCIAL_MEDIA_MAIL_ID_LABEL;
	}

	public void setCOMP_CONT_SOCIAL_MEDIA_MAIL_ID_LABEL(
			HtmlOutputLabel cOMP_CONT_SOCIAL_MEDIA_MAIL_ID_LABEL) {
		COMP_CONT_SOCIAL_MEDIA_MAIL_ID_LABEL = cOMP_CONT_SOCIAL_MEDIA_MAIL_ID_LABEL;
	}

	public HtmlInputText getCOMP_CONT_SOCIAL_MEDIA_MAIL_ID() {
		return COMP_CONT_SOCIAL_MEDIA_MAIL_ID;
	}

	public void setCOMP_CONT_SOCIAL_MEDIA_MAIL_ID(
			HtmlInputText cOMP_CONT_SOCIAL_MEDIA_MAIL_ID) {
		COMP_CONT_SOCIAL_MEDIA_MAIL_ID = cOMP_CONT_SOCIAL_MEDIA_MAIL_ID;
	}


	public List<SelectItem> getItemListCONT_SOCIAL_MEDIA_TYPE() {
		return itemListCONT_SOCIAL_MEDIA_TYPE;
	}

	public void setItemListCONT_SOCIAL_MEDIA_TYPE(
			List<SelectItem> itemListCONT_SOCIAL_MEDIA_TYPE) {
		this.itemListCONT_SOCIAL_MEDIA_TYPE = itemListCONT_SOCIAL_MEDIA_TYPE;
	}

	public ArrayList<LovBean> lovCONT_CITY_CODE(
		    Object object) {

		ArrayList<LovBean> suggestionList = null;
		String query1 = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'CITY' AND  " +
				"PC_FRZ_FLAG = 'N' AND  (PC_CODE LIKE ? OR PC_DESC LIKE ? ) AND ROWNUM < ? ORDER BY 1";
		try {

		    String currentValue = (String) object;
		    currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
		  
		    	 suggestionList = ListItemUtil.prepareSuggestionList(query1,new Object[]{currentValue,currentValue,PELConstants.suggetionRecordSize});

		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		return suggestionList;
	    }
	
	
	/* Newly Added By Dhinesh on 16-04-2018 */
	
	public ArrayList<LovBean> lovCONT_CATG_CODE(
		    Object object) {

		ArrayList<LovBean> suggestionList = null;
		String query1 = PILM016_PM_IL_CONTRACTOR_QUERY_CONSTANTS_QE.PM_IL_CONTRACTOR_PREPARE_CATG_CODE_LIST_LIKE;
		try {

		    String currentValue = (String) object;
		    currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
		  
		    	 suggestionList = ListItemUtil.prepareSuggestionList(query1,new Object[]{currentValue});

		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		return suggestionList;
	    }
	
	/* End */
	
	public ArrayList<LovBean> lovCONT_STATE_CODE(
		    Object object) {
		ArrayList<LovBean> suggestionList = null;
		String query1 = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'STATE' AND  " +
				"PC_FRZ_FLAG = 'N' AND  (PC_CODE LIKE ? OR PC_DESC LIKE ? ) AND ROWNUM < ? ORDER BY 1";
		try {

		    String currentValue = (String) object;
		    currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
		  
		    	 suggestionList = ListItemUtil.prepareSuggestionList(query1,new Object[]{currentValue,currentValue,PELConstants.suggetionRecordSize});

		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		return suggestionList;
	    }
	
	
	public ArrayList<LovBean> lovCONT_COUNT_CODE(Object object) {

		ArrayList<LovBean> suggestionList = null;

		String query1 = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'COUNTRY' AND  "
				+ "PC_FRZ_FLAG = 'N' AND  (PC_CODE LIKE ? OR PC_DESC LIKE ? ) AND ROWNUM < ? ORDER BY 1";
		try {

			String currentValue = (String) object;
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			suggestionList = ListItemUtil.prepareSuggestionList(query1,
					new Object[] { currentValue, currentValue,
							PELConstants.suggetionRecordSize });

		} catch (Exception e) {
			e.printStackTrace();
		}

		return suggestionList;
	}
	
	
	
	
	public void validatorCONT_COUNT_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_COUNT_CODE((String) value);
			//helper.when_validate_itemCONT_COUNT_CODE(PM_IL_CONTRACTOR_QE_BEAN, this);
			COMP_CONT_COUNTRY.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void validatorCONT_STATE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_STATE((String) value);
			/*helper.when_validate_itemCONT_STATE(PM_IL_CONTRACTOR_QE_BEAN);
			helper.pre_text_item_CONT_STATE(PM_IL_CONTRACTOR_QE_BEAN);*/
			COMP_UI_M_CONT_STATE_CODE_DESC.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorCONT_CITY_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_CITY_CODE((String) value);
			/*helper.when_validate_itemCONT_CITY_CODE(
					PM_IL_CONTRACTOR_QE_BEAN);
			helper.pre_text_item_CONT_CITY_CODE(PM_IL_CONTRACTOR_QE_BEAN);*/
			COMP_CONT_CITY.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void validatorCONT_POSTAL_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_POSTAL_CODE((String) value);
			/*helper.when_validate_itemCONT_POSTAL_CODE(PM_IL_CONTRACTOR_QE_BEAN);
			helper.pre_text_item_CONT_POSTAL_CODE(PM_IL_CONTRACTOR_QE_BEAN);*/
			COMP_CONT_CITY_CODE.resetValue();
			COMP_CONT_STATE.resetValue();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	/*End*/
	/*Added by Ameen on 27-02-2018 for KIC*/
	public void validatorCONT_TEL_AREA_CODE(FacesContext context, UIComponent component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_TEL_AREA_CODE((String)value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorCONT_FAX_AREA_CODE(FacesContext context, UIComponent component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_FAX_AREA_CODE((String)value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorCONT_EMAIL_ID(FacesContext context, UIComponent component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_EMAIL_ID((String)value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorCONT_PHONE(FacesContext context, UIComponent component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_PHONE((String)value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateCONT_DOB(FacesContext context, UIComponent component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_DOB((Date)value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCONT_ADDR2(FacesContext context, UIComponent component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_ADDR2((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorCONT_ADDR3(FacesContext context, UIComponent component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_ADDR3((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateCONT_TEL_AREA_CODE(FacesContext context, UIComponent component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_TEL_AREA_CODE((String)value);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateCONT_PHONE(FacesContext context, UIComponent component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_PHONE((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateCONT_EMAIL_ID(FacesContext context, UIComponent component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_EMAIL_ID((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void validateCONT_SOCIAL_MEDIA_MAIL_ID(FacesContext context, UIComponent component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_SOCIAL_MEDIA_MAIL_ID((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateCONT_SOCIAL_MEDIA_TYPE(FacesContext context, UIComponent component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_SOCIAL_MEDIA_TYPE((String)value);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateCONT_FAX_AREA_CODE(FacesContext context, UIComponent component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_PHONE((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorCONT_MOB_AREA_CODE(FacesContext context, UIComponent component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_MOB_AREA_CODE((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateCONT_ADDR3(FacesContext context, UIComponent component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_ADDR3((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	private HtmlOutputLabel COMP_CONT_PHY_ADDR1_LABEL;
	
	private HtmlInputText COMP_CONT_PHY_ADDR1;
	
	private HtmlOutputLabel COMP_CONT_PHY_ADDR2_LABEL;
	
	private HtmlInputText COMP_CONT_PHY_ADDR2;
	
	private HtmlOutputLabel COMP_CONT_PHY_ADDR3_LABEL;
	
	private HtmlInputText COMP_CONT_PHY_ADDR3;
	
	private HtmlOutputLabel COMP_CONT_PHY_CITY_CODE_LABEL;
	
	private HtmlInputText COMP_CONT_PHY_CITY_CODE;
	
	private HtmlInputText COMP_CONT_PHY_CITY;

	private HtmlOutputLabel COMP_CONT_PHY_COUNTRY_LABEL;
	
	private HtmlInputText COMP_CONT_PHY_COUNT_CODE;
	
	private HtmlInputText COMP_CONT_PHY_COUNTRY;
	
	private HtmlOutputLabel COMP_CONT_PHY_POSTAL_CODE_LABEL;
	
	private HtmlInputText COMP_CONT_PHY_POSTAL_CODE;
	
	private HtmlOutputLabel COMP_CONT_PHY_MOBILE_NO_LABEL;
	
	private HtmlInputText COMP_CONT_PHY_MOB_AREA_CODE;
	
	private HtmlInputText COMP_CONT_PHY_MOBILE_NO;
	
	private HtmlOutputLabel COMP_CONT_PHY_PHONE_LABEL;
	
	private HtmlInputText COMP_CONT_PHY_TEL_AREA_CODE;
	
	private HtmlInputText COMP_CONT_PHY_PHONE;
	
	private HtmlOutputLabel COMP_CONT_PHY_FAX_LABEL;
	
	private HtmlInputText COMP_CONT_PHY_FAX_AREA_CODE;

	private HtmlInputText COMP_CONT_PHY_FAX;
	
	private HtmlOutputLabel COMP_CONT_PHY_EMAIL_ID_LABEL;
	
	private HtmlInputText COMP_CONT_PHY_EMAIL_ID;
	
	private HtmlOutputLabel COMP_CONT_CORR_ADDR1_LABEL;
	
	private HtmlInputText COMP_CONT_CORR_ADDR1;
	
	private HtmlOutputLabel COMP_CONT_CORR_ADDR2_LABEL;
	
	private HtmlInputText COMP_CONT_CORR_ADDR2;

	private HtmlOutputLabel COMP_CONT_CORR_ADDR3_LABEL;
	
	private HtmlInputText COMP_CONT_CORR_ADDR3;
	
	private HtmlOutputLabel COMP_CONT_CORR_CITY_LABEL;
	
	private HtmlInputText COMP_CONT_CORR_CITY_CODE;
	
	private HtmlInputText COMP_CONT_CORR_CITY;
	
	private HtmlOutputLabel COMP_CONT_CORR_COUNTRY_LABEL;
	
	private HtmlInputText COMP_CONT_CORR_COUNT_CODE;
	
	private HtmlInputText COMP_CONT_CORR_COUNTRY;
	
	private HtmlOutputLabel COMP_CONT_CORR_POSTAL_CODE_LABEL;
	
	private HtmlInputText COMP_CONT_CORR_POSTAL_CODE;
	
	private HtmlOutputLabel COMP_CONT_CORR_MOBILE_NO_LABEL;
	
	private HtmlInputText COMP_CONT_CORR_MOB_CODE;
	
	private HtmlInputText COMP_CONT_CORR_MOBILE_NO;
	
	private HtmlOutputLabel COMP_CONT_CORR_PHONE_LABEL;
	
	private HtmlInputText COMP_CONT_CORR_TEL_AREA_CODE;
	
	private HtmlInputText COMP_CONT_CORR_PHONE;
	
	private HtmlOutputLabel COMP_CONT_CORR_FAX_LABEL;
	
	private HtmlInputText COMP_CONT_CORR_FAX_AREA_CODE;
	
	private HtmlInputText COMP_CONT_CORR_FAX;
	
	private HtmlOutputLabel COMP_CONT_CORR_EMAIL_ID_LABEL;
	
	private HtmlInputText COMP_CONT_CORR_EMAIL_ID;

	
	public HtmlOutputLabel getCOMP_CONT_PHY_ADDR1_LABEL() {
		return COMP_CONT_PHY_ADDR1_LABEL;
	}

	public void setCOMP_CONT_PHY_ADDR1_LABEL(
			HtmlOutputLabel cOMP_CONT_PHY_ADDR1_LABEL) {
		COMP_CONT_PHY_ADDR1_LABEL = cOMP_CONT_PHY_ADDR1_LABEL;
	}

	public HtmlInputText getCOMP_CONT_PHY_ADDR1() {
		return COMP_CONT_PHY_ADDR1;
	}

	public void setCOMP_CONT_PHY_ADDR1(HtmlInputText cOMP_CONT_PHY_ADDR1) {
		COMP_CONT_PHY_ADDR1 = cOMP_CONT_PHY_ADDR1;
	}

	public HtmlOutputLabel getCOMP_CONT_PHY_ADDR2_LABEL() {
		return COMP_CONT_PHY_ADDR2_LABEL;
	}

	public void setCOMP_CONT_PHY_ADDR2_LABEL(
			HtmlOutputLabel cOMP_CONT_PHY_ADDR2_LABEL) {
		COMP_CONT_PHY_ADDR2_LABEL = cOMP_CONT_PHY_ADDR2_LABEL;
	}

	public HtmlInputText getCOMP_CONT_PHY_ADDR2() {
		return COMP_CONT_PHY_ADDR2;
	}

	public void setCOMP_CONT_PHY_ADDR2(HtmlInputText cOMP_CONT_PHY_ADDR2) {
		COMP_CONT_PHY_ADDR2 = cOMP_CONT_PHY_ADDR2;
	}

	public HtmlOutputLabel getCOMP_CONT_PHY_ADDR3_LABEL() {
		return COMP_CONT_PHY_ADDR3_LABEL;
	}

	public void setCOMP_CONT_PHY_ADDR3_LABEL(
			HtmlOutputLabel cOMP_CONT_PHY_ADDR3_LABEL) {
		COMP_CONT_PHY_ADDR3_LABEL = cOMP_CONT_PHY_ADDR3_LABEL;
	}

	public HtmlInputText getCOMP_CONT_PHY_ADDR3() {
		return COMP_CONT_PHY_ADDR3;
	}

	public void setCOMP_CONT_PHY_ADDR3(HtmlInputText cOMP_CONT_PHY_ADDR3) {
		COMP_CONT_PHY_ADDR3 = cOMP_CONT_PHY_ADDR3;
	}

	public HtmlOutputLabel getCOMP_CONT_PHY_CITY_CODE_LABEL() {
		return COMP_CONT_PHY_CITY_CODE_LABEL;
	}

	public void setCOMP_CONT_PHY_CITY_CODE_LABEL(
			HtmlOutputLabel cOMP_CONT_PHY_CITY_CODE_LABEL) {
		COMP_CONT_PHY_CITY_CODE_LABEL = cOMP_CONT_PHY_CITY_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CONT_PHY_CITY_CODE() {
		return COMP_CONT_PHY_CITY_CODE;
	}

	public void setCOMP_CONT_PHY_CITY_CODE(HtmlInputText cOMP_CONT_PHY_CITY_CODE) {
		COMP_CONT_PHY_CITY_CODE = cOMP_CONT_PHY_CITY_CODE;
	}

	public HtmlInputText getCOMP_CONT_PHY_CITY() {
		return COMP_CONT_PHY_CITY;
	}

	public void setCOMP_CONT_PHY_CITY(HtmlInputText cOMP_CONT_PHY_CITY) {
		COMP_CONT_PHY_CITY = cOMP_CONT_PHY_CITY;
	}

	public HtmlOutputLabel getCOMP_CONT_PHY_COUNTRY_LABEL() {
		return COMP_CONT_PHY_COUNTRY_LABEL;
	}

	public void setCOMP_CONT_PHY_COUNTRY_LABEL(
			HtmlOutputLabel cOMP_CONT_PHY_COUNTRY_LABEL) {
		COMP_CONT_PHY_COUNTRY_LABEL = cOMP_CONT_PHY_COUNTRY_LABEL;
	}

	public HtmlInputText getCOMP_CONT_PHY_COUNT_CODE() {
		return COMP_CONT_PHY_COUNT_CODE;
	}

	public void setCOMP_CONT_PHY_COUNT_CODE(HtmlInputText cOMP_CONT_PHY_COUNT_CODE) {
		COMP_CONT_PHY_COUNT_CODE = cOMP_CONT_PHY_COUNT_CODE;
	}

	public HtmlInputText getCOMP_CONT_PHY_COUNTRY() {
		return COMP_CONT_PHY_COUNTRY;
	}

	public void setCOMP_CONT_PHY_COUNTRY(HtmlInputText cOMP_CONT_PHY_COUNTRY) {
		COMP_CONT_PHY_COUNTRY = cOMP_CONT_PHY_COUNTRY;
	}

	public HtmlOutputLabel getCOMP_CONT_PHY_POSTAL_CODE_LABEL() {
		return COMP_CONT_PHY_POSTAL_CODE_LABEL;
	}

	public void setCOMP_CONT_PHY_POSTAL_CODE_LABEL(
			HtmlOutputLabel cOMP_CONT_PHY_POSTAL_CODE_LABEL) {
		COMP_CONT_PHY_POSTAL_CODE_LABEL = cOMP_CONT_PHY_POSTAL_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CONT_PHY_POSTAL_CODE() {
		return COMP_CONT_PHY_POSTAL_CODE;
	}

	public void setCOMP_CONT_PHY_POSTAL_CODE(HtmlInputText cOMP_CONT_PHY_POSTAL_CODE) {
		COMP_CONT_PHY_POSTAL_CODE = cOMP_CONT_PHY_POSTAL_CODE;
	}

	public HtmlOutputLabel getCOMP_CONT_PHY_MOBILE_NO_LABEL() {
		return COMP_CONT_PHY_MOBILE_NO_LABEL;
	}

	public void setCOMP_CONT_PHY_MOBILE_NO_LABEL(
			HtmlOutputLabel cOMP_CONT_PHY_MOBILE_NO_LABEL) {
		COMP_CONT_PHY_MOBILE_NO_LABEL = cOMP_CONT_PHY_MOBILE_NO_LABEL;
	}

	public HtmlInputText getCOMP_CONT_PHY_MOB_AREA_CODE() {
		return COMP_CONT_PHY_MOB_AREA_CODE;
	}

	public void setCOMP_CONT_PHY_MOB_AREA_CODE(
			HtmlInputText cOMP_CONT_PHY_MOB_AREA_CODE) {
		COMP_CONT_PHY_MOB_AREA_CODE = cOMP_CONT_PHY_MOB_AREA_CODE;
	}

	public HtmlInputText getCOMP_CONT_PHY_MOBILE_NO() {
		return COMP_CONT_PHY_MOBILE_NO;
	}

	public void setCOMP_CONT_PHY_MOBILE_NO(HtmlInputText cOMP_CONT_PHY_MOBILE_NO) {
		COMP_CONT_PHY_MOBILE_NO = cOMP_CONT_PHY_MOBILE_NO;
	}

	public HtmlOutputLabel getCOMP_CONT_PHY_PHONE_LABEL() {
		return COMP_CONT_PHY_PHONE_LABEL;
	}

	public void setCOMP_CONT_PHY_PHONE_LABEL(
			HtmlOutputLabel cOMP_CONT_PHY_PHONE_LABEL) {
		COMP_CONT_PHY_PHONE_LABEL = cOMP_CONT_PHY_PHONE_LABEL;
	}

	public HtmlInputText getCOMP_CONT_PHY_TEL_AREA_CODE() {
		return COMP_CONT_PHY_TEL_AREA_CODE;
	}

	public void setCOMP_CONT_PHY_TEL_AREA_CODE(
			HtmlInputText cOMP_CONT_PHY_TEL_AREA_CODE) {
		COMP_CONT_PHY_TEL_AREA_CODE = cOMP_CONT_PHY_TEL_AREA_CODE;
	}

	public HtmlInputText getCOMP_CONT_PHY_PHONE() {
		return COMP_CONT_PHY_PHONE;
	}

	public void setCOMP_CONT_PHY_PHONE(HtmlInputText cOMP_CONT_PHY_PHONE) {
		COMP_CONT_PHY_PHONE = cOMP_CONT_PHY_PHONE;
	}

	public HtmlOutputLabel getCOMP_CONT_PHY_FAX_LABEL() {
		return COMP_CONT_PHY_FAX_LABEL;
	}

	public void setCOMP_CONT_PHY_FAX_LABEL(HtmlOutputLabel cOMP_CONT_PHY_FAX_LABEL) {
		COMP_CONT_PHY_FAX_LABEL = cOMP_CONT_PHY_FAX_LABEL;
	}

	public HtmlInputText getCOMP_CONT_PHY_FAX_AREA_CODE() {
		return COMP_CONT_PHY_FAX_AREA_CODE;
	}

	public void setCOMP_CONT_PHY_FAX_AREA_CODE(
			HtmlInputText cOMP_CONT_PHY_FAX_AREA_CODE) {
		COMP_CONT_PHY_FAX_AREA_CODE = cOMP_CONT_PHY_FAX_AREA_CODE;
	}

	public HtmlInputText getCOMP_CONT_PHY_FAX() {
		return COMP_CONT_PHY_FAX;
	}

	public void setCOMP_CONT_PHY_FAX(HtmlInputText cOMP_CONT_PHY_FAX) {
		COMP_CONT_PHY_FAX = cOMP_CONT_PHY_FAX;
	}

	public HtmlOutputLabel getCOMP_CONT_PHY_EMAIL_ID_LABEL() {
		return COMP_CONT_PHY_EMAIL_ID_LABEL;
	}

	public void setCOMP_CONT_PHY_EMAIL_ID_LABEL(
			HtmlOutputLabel cOMP_CONT_PHY_EMAIL_ID_LABEL) {
		COMP_CONT_PHY_EMAIL_ID_LABEL = cOMP_CONT_PHY_EMAIL_ID_LABEL;
	}

	public HtmlInputText getCOMP_CONT_PHY_EMAIL_ID() {
		return COMP_CONT_PHY_EMAIL_ID;
	}

	public void setCOMP_CONT_PHY_EMAIL_ID(HtmlInputText cOMP_CONT_PHY_EMAIL_ID) {
		COMP_CONT_PHY_EMAIL_ID = cOMP_CONT_PHY_EMAIL_ID;
	}

	public HtmlOutputLabel getCOMP_CONT_CORR_ADDR1_LABEL() {
		return COMP_CONT_CORR_ADDR1_LABEL;
	}

	public void setCOMP_CONT_CORR_ADDR1_LABEL(
			HtmlOutputLabel cOMP_CONT_CORR_ADDR1_LABEL) {
		COMP_CONT_CORR_ADDR1_LABEL = cOMP_CONT_CORR_ADDR1_LABEL;
	}

	public HtmlInputText getCOMP_CONT_CORR_ADDR1() {
		return COMP_CONT_CORR_ADDR1;
	}

	public void setCOMP_CONT_CORR_ADDR1(HtmlInputText cOMP_CONT_CORR_ADDR1) {
		COMP_CONT_CORR_ADDR1 = cOMP_CONT_CORR_ADDR1;
	}

	public HtmlOutputLabel getCOMP_CONT_CORR_ADDR2_LABEL() {
		return COMP_CONT_CORR_ADDR2_LABEL;
	}

	public void setCOMP_CONT_CORR_ADDR2_LABEL(
			HtmlOutputLabel cOMP_CONT_CORR_ADDR2_LABEL) {
		COMP_CONT_CORR_ADDR2_LABEL = cOMP_CONT_CORR_ADDR2_LABEL;
	}

	public HtmlInputText getCOMP_CONT_CORR_ADDR2() {
		return COMP_CONT_CORR_ADDR2;
	}

	public void setCOMP_CONT_CORR_ADDR2(HtmlInputText cOMP_CONT_CORR_ADDR2) {
		COMP_CONT_CORR_ADDR2 = cOMP_CONT_CORR_ADDR2;
	}

	public HtmlOutputLabel getCOMP_CONT_CORR_ADDR3_LABEL() {
		return COMP_CONT_CORR_ADDR3_LABEL;
	}

	public void setCOMP_CONT_CORR_ADDR3_LABEL(
			HtmlOutputLabel cOMP_CONT_CORR_ADDR3_LABEL) {
		COMP_CONT_CORR_ADDR3_LABEL = cOMP_CONT_CORR_ADDR3_LABEL;
	}

	public HtmlInputText getCOMP_CONT_CORR_ADDR3() {
		return COMP_CONT_CORR_ADDR3;
	}

	public void setCOMP_CONT_CORR_ADDR3(HtmlInputText cOMP_CONT_CORR_ADDR3) {
		COMP_CONT_CORR_ADDR3 = cOMP_CONT_CORR_ADDR3;
	}

	public HtmlOutputLabel getCOMP_CONT_CORR_CITY_LABEL() {
		return COMP_CONT_CORR_CITY_LABEL;
	}

	public void setCOMP_CONT_CORR_CITY_LABEL(
			HtmlOutputLabel cOMP_CONT_CORR_CITY_LABEL) {
		COMP_CONT_CORR_CITY_LABEL = cOMP_CONT_CORR_CITY_LABEL;
	}

	public HtmlInputText getCOMP_CONT_CORR_CITY_CODE() {
		return COMP_CONT_CORR_CITY_CODE;
	}

	public void setCOMP_CONT_CORR_CITY_CODE(HtmlInputText cOMP_CONT_CORR_CITY_CODE) {
		COMP_CONT_CORR_CITY_CODE = cOMP_CONT_CORR_CITY_CODE;
	}

	public HtmlInputText getCOMP_CONT_CORR_CITY() {
		return COMP_CONT_CORR_CITY;
	}

	public void setCOMP_CONT_CORR_CITY(HtmlInputText cOMP_CONT_CORR_CITY) {
		COMP_CONT_CORR_CITY = cOMP_CONT_CORR_CITY;
	}

	public HtmlOutputLabel getCOMP_CONT_CORR_COUNTRY_LABEL() {
		return COMP_CONT_CORR_COUNTRY_LABEL;
	}

	public void setCOMP_CONT_CORR_COUNTRY_LABEL(
			HtmlOutputLabel cOMP_CONT_CORR_COUNTRY_LABEL) {
		COMP_CONT_CORR_COUNTRY_LABEL = cOMP_CONT_CORR_COUNTRY_LABEL;
	}

	public HtmlInputText getCOMP_CONT_CORR_COUNT_CODE() {
		return COMP_CONT_CORR_COUNT_CODE;
	}

	public void setCOMP_CONT_CORR_COUNT_CODE(HtmlInputText cOMP_CONT_CORR_COUNT_CODE) {
		COMP_CONT_CORR_COUNT_CODE = cOMP_CONT_CORR_COUNT_CODE;
	}

	public HtmlInputText getCOMP_CONT_CORR_COUNTRY() {
		return COMP_CONT_CORR_COUNTRY;
	}

	public void setCOMP_CONT_CORR_COUNTRY(HtmlInputText cOMP_CONT_CORR_COUNTRY) {
		COMP_CONT_CORR_COUNTRY = cOMP_CONT_CORR_COUNTRY;
	}

	public HtmlOutputLabel getCOMP_CONT_CORR_POSTAL_CODE_LABEL() {
		return COMP_CONT_CORR_POSTAL_CODE_LABEL;
	}

	public void setCOMP_CONT_CORR_POSTAL_CODE_LABEL(
			HtmlOutputLabel cOMP_CONT_CORR_POSTAL_CODE_LABEL) {
		COMP_CONT_CORR_POSTAL_CODE_LABEL = cOMP_CONT_CORR_POSTAL_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CONT_CORR_POSTAL_CODE() {
		return COMP_CONT_CORR_POSTAL_CODE;
	}

	public void setCOMP_CONT_CORR_POSTAL_CODE(
			HtmlInputText cOMP_CONT_CORR_POSTAL_CODE) {
		COMP_CONT_CORR_POSTAL_CODE = cOMP_CONT_CORR_POSTAL_CODE;
	}

	public HtmlOutputLabel getCOMP_CONT_CORR_MOBILE_NO_LABEL() {
		return COMP_CONT_CORR_MOBILE_NO_LABEL;
	}

	public void setCOMP_CONT_CORR_MOBILE_NO_LABEL(
			HtmlOutputLabel cOMP_CONT_CORR_MOBILE_NO_LABEL) {
		COMP_CONT_CORR_MOBILE_NO_LABEL = cOMP_CONT_CORR_MOBILE_NO_LABEL;
	}

	public HtmlInputText getCOMP_CONT_CORR_MOB_CODE() {
		return COMP_CONT_CORR_MOB_CODE;
	}

	public void setCOMP_CONT_CORR_MOB_CODE(HtmlInputText cOMP_CONT_CORR_MOB_CODE) {
		COMP_CONT_CORR_MOB_CODE = cOMP_CONT_CORR_MOB_CODE;
	}

	public HtmlInputText getCOMP_CONT_CORR_MOBILE_NO() {
		return COMP_CONT_CORR_MOBILE_NO;
	}

	public void setCOMP_CONT_CORR_MOBILE_NO(HtmlInputText cOMP_CONT_CORR_MOBILE_NO) {
		COMP_CONT_CORR_MOBILE_NO = cOMP_CONT_CORR_MOBILE_NO;
	}

	public HtmlOutputLabel getCOMP_CONT_CORR_PHONE_LABEL() {
		return COMP_CONT_CORR_PHONE_LABEL;
	}

	public void setCOMP_CONT_CORR_PHONE_LABEL(
			HtmlOutputLabel cOMP_CONT_CORR_PHONE_LABEL) {
		COMP_CONT_CORR_PHONE_LABEL = cOMP_CONT_CORR_PHONE_LABEL;
	}

	public HtmlInputText getCOMP_CONT_CORR_TEL_AREA_CODE() {
		return COMP_CONT_CORR_TEL_AREA_CODE;
	}

	public void setCOMP_CONT_CORR_TEL_AREA_CODE(
			HtmlInputText cOMP_CONT_CORR_TEL_AREA_CODE) {
		COMP_CONT_CORR_TEL_AREA_CODE = cOMP_CONT_CORR_TEL_AREA_CODE;
	}

	public HtmlInputText getCOMP_CONT_CORR_PHONE() {
		return COMP_CONT_CORR_PHONE;
	}

	public void setCOMP_CONT_CORR_PHONE(HtmlInputText cOMP_CONT_CORR_PHONE) {
		COMP_CONT_CORR_PHONE = cOMP_CONT_CORR_PHONE;
	}

	public HtmlOutputLabel getCOMP_CONT_CORR_FAX_LABEL() {
		return COMP_CONT_CORR_FAX_LABEL;
	}

	public void setCOMP_CONT_CORR_FAX_LABEL(HtmlOutputLabel cOMP_CONT_CORR_FAX_LABEL) {
		COMP_CONT_CORR_FAX_LABEL = cOMP_CONT_CORR_FAX_LABEL;
	}

	public HtmlInputText getCOMP_CONT_CORR_FAX_AREA_CODE() {
		return COMP_CONT_CORR_FAX_AREA_CODE;
	}

	public void setCOMP_CONT_CORR_FAX_AREA_CODE(
			HtmlInputText cOMP_CONT_CORR_FAX_AREA_CODE) {
		COMP_CONT_CORR_FAX_AREA_CODE = cOMP_CONT_CORR_FAX_AREA_CODE;
	}

	public HtmlInputText getCOMP_CONT_CORR_FAX() {
		return COMP_CONT_CORR_FAX;
	}

	public void setCOMP_CONT_CORR_FAX(HtmlInputText cOMP_CONT_CORR_FAX) {
		COMP_CONT_CORR_FAX = cOMP_CONT_CORR_FAX;
	}

	public HtmlOutputLabel getCOMP_CONT_CORR_EMAIL_ID_LABEL() {
		return COMP_CONT_CORR_EMAIL_ID_LABEL;
	}

	public void setCOMP_CONT_CORR_EMAIL_ID_LABEL(
			HtmlOutputLabel cOMP_CONT_CORR_EMAIL_ID_LABEL) {
		COMP_CONT_CORR_EMAIL_ID_LABEL = cOMP_CONT_CORR_EMAIL_ID_LABEL;
	}

	public HtmlInputText getCOMP_CONT_CORR_EMAIL_ID() {
		return COMP_CONT_CORR_EMAIL_ID;
	}

	public void setCOMP_CONT_CORR_EMAIL_ID(HtmlInputText cOMP_CONT_CORR_EMAIL_ID) {
		COMP_CONT_CORR_EMAIL_ID = cOMP_CONT_CORR_EMAIL_ID;
	}

	public void validateCONT_PHY_ADDR1(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_PHY_ADDR1((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateCONT_PHY_ADDR2(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_PHY_ADDR2((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateCONT_PHY_ADDR3(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_PHY_ADDR3((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorCONT_PHY_CITY_CODE(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_PHY_CITY_CODE((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorCONT_PHY_COUNT_CODE(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_PHY_COUNT_CODE((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorCONT_PHY_POSTAL_CODE(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_PHY_POSTAL_CODE((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorCONT_PHY_MOB_AREA_CODE(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_PHY_MOB_AREA_CODE((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorCONT_PHY_MOBILE_NO(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_PHY_MOBILE_NO((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorCONT_PHY_TEL_AREA_CODE(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_PHY_TEL_AREA_CODE((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorCONT_PHY_PHONE(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_PHY_PHONE((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorCONT_PHY_FAX_AREA_CODE(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_PHY_FAX_AREA_CODE((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorCONT_PHY_FAX(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_PHY_FAX((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorCONT_PHY_EMAIL_ID(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_PHY_EMAIL_ID((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateCONT_CORR_ADDR1(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_CORR_ADDR1((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateCONT_CORR_ADDR2(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_CORR_ADDR2((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorCONT_CORR_ADDR3(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_CORR_ADDR3((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorCONT_CORR_CITY_CODE(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_CORR_CITY_CODE((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorCONT_CORR_COUNT_CODE(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_CORR_COUNT_CODE((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorCONT_CORR_POSTAL_CODE(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_CORR_POSTAL_CODE((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorCONT_CORR_MOB_CODE(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_CORR_MOB_CODE((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void validatorCONT_CORR_MOBILE_NO(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_CORR_MOBILE_NO((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorCONT_CORR_TEL_AREA_CODE(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_CORR_TEL_AREA_CODE((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorCONT_CORR_PHONE(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_CORR_PHONE((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void validatorCONT_CORR_FAX_AREA_CODE(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_CORR_FAX_AREA_CODE((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorCONT_CORR_FAX(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_CORR_FAX((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorCONT_CORR_EMAIL_ID(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_CORR_EMAIL_ID((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	/*End*/

	
	/*Added by Janani on 23.03.2018 for KIC assured dtls screen */
	
	private HtmlTogglePanel COMP_CONT_TOGGLE;

	public HtmlTogglePanel getCOMP_CONT_TOGGLE() {
		return COMP_CONT_TOGGLE;
	}

	public void setCOMP_CONT_TOGGLE(HtmlTogglePanel cOMP_CONT_TOGGLE) {
		COMP_CONT_TOGGLE = cOMP_CONT_TOGGLE;
	}
	
	/*End*/
	
   /*Added by saritha on 03-04-2018 for KIC Pop up message that the customer/Assured is already exist once ID is entered is required*/
	
	private HtmlModalPanel COMP_REPORT_MODAL_PANEL_DELETE;

	public HtmlModalPanel getCOMP_REPORT_MODAL_PANEL_DELETE() {
		return COMP_REPORT_MODAL_PANEL_DELETE;
	}

	public void setCOMP_REPORT_MODAL_PANEL_DELETE(
			HtmlModalPanel cOMP_REPORT_MODAL_PANEL_DELETE) {
		COMP_REPORT_MODAL_PANEL_DELETE = cOMP_REPORT_MODAL_PANEL_DELETE;
	}
	
	public void onLoad(PhaseEvent event) throws Exception{
		if(isBlockFlag()){
			getErrorMap().clear();
			getWarningMap().clear();
			try {
			
				if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getROWID() != null)
				{
					helper.executeQuery(this);	
					resetAllComponent();
					disableAllComponent(true);
					
				}
				
				getCOMP_REPORT_MODAL_PANEL_DELETE().setShowWhenRendered(false);
				setBlockFlag(false);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}
	}
	
	public void validateIdentificationNumber(String current) throws Exception{
		int numericField = ((BigDecimal)CommonUtils.getPPSystemParameterValue("IL_CUST_ICVL")).intValue();
		boolean duplicateID = false;
		if(numericField != 2){

			if(helper.vaildateValues(current)){

				duplicateID = RefIdDuplicate(current);
				if(duplicateID){							
					COMP_REPORT_MODAL_PANEL_DELETE.setShowWhenRendered(true);
					throw new Exception("Assured Already Exist");
				}else{
					COMP_REPORT_MODAL_PANEL_DELETE.setShowWhenRendered(false);
				}


			}else{
				throw new Exception("Civil ID Should be Numeric. ");
			}
		}

	}
	
	
	public void OkModalPanel() throws Exception{
		System.out.println("enter into the ok model panal");
		getCOMP_REPORT_MODAL_PANEL_DELETE().setShowWhenRendered(false);
			
	}
	
    /*Added by saritha on 03-04-2018 for KIC Pop up message that the customer/Assured is already exist once ID is entered is required*/
	
	private boolean RefIdDuplicate(String value) throws Exception {

		String C1 = "SELECT 'X' FROM PM_IL_CONTRACTOR WHERE CONT_REF_ID1 = ?";
		ResultSet resultSet = null; 
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		boolean civilIDflag = false;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection,new Object[]{value});

			if(resultSet.next()){

				civilIDflag  = true;
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
		return civilIDflag;

	}
	
	/*End*/
	
/*Added by Janani on 05.04.2018 for KIC  assured dtls screen*/
	
	private HtmlOutputLabel COMP_CONT_OCC_CODE_LABEL;
	private HtmlInputText COMP_CONT_OCC_CODE;
	private HtmlInputText COMP_UI_M_CONT_OCC_DESC;

	public HtmlOutputLabel getCOMP_CONT_OCC_CODE_LABEL() {
		return COMP_CONT_OCC_CODE_LABEL;
	}

	public void setCOMP_CONT_OCC_CODE_LABEL(HtmlOutputLabel cOMP_CONT_OCC_CODE_LABEL) {
		COMP_CONT_OCC_CODE_LABEL = cOMP_CONT_OCC_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CONT_OCC_CODE() {
		return COMP_CONT_OCC_CODE;
	}

	public void setCOMP_CONT_OCC_CODE(HtmlInputText cOMP_CONT_OCC_CODE) {
		COMP_CONT_OCC_CODE = cOMP_CONT_OCC_CODE;
	}

	public HtmlInputText getCOMP_UI_M_CONT_OCC_DESC() {
		return COMP_UI_M_CONT_OCC_DESC;
	}

	public void setCOMP_UI_M_CONT_OCC_DESC(HtmlInputText cOMP_UI_M_CONT_OCC_DESC) {
		COMP_UI_M_CONT_OCC_DESC = cOMP_UI_M_CONT_OCC_DESC;
	}

	public void validatorCONT_OCC_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_OCC_CODE((String) value);
			COMP_CONT_OCC_CODE.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public ArrayList<LovBean> lovCONT_OCC_CODE(Object object) {
		ArrayList<LovBean> suggestionList = null;
		String query1 = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'IL_OCCU' "
				+ " AND (PC_CODE LIKE ? OR PC_DESC LIKE ? ) AND ROWNUM < ? ORDER BY 1";
		try {

			String currentValue = (String) object;
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			suggestionList = ListItemUtil.prepareSuggestionList(query1,
					new Object[] { currentValue, currentValue,
					PELConstants.suggetionRecordSize });

		} catch (Exception e) {
			e.printStackTrace();
		}

		return suggestionList;
	}
	/*End*/
	
	/*added by Ameen on 09-04-2018 for KIC*/
	private HtmlOutputLabel COMP_CONT_NATIONALITY_CODE_LABEL;
	
	private HtmlInputText COMP_CONT_NATIONALITY_CODE;
	
	private HtmlInputText COMP_UI_M_CONT_NATIONALITY_CODE_DESC;

	public HtmlOutputLabel getCOMP_CONT_NATIONALITY_CODE_LABEL() {
		return COMP_CONT_NATIONALITY_CODE_LABEL;
	}

	public void setCOMP_CONT_NATIONALITY_CODE_LABEL(
			HtmlOutputLabel cOMP_CONT_NATIONALITY_CODE_LABEL) {
		COMP_CONT_NATIONALITY_CODE_LABEL = cOMP_CONT_NATIONALITY_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CONT_NATIONALITY_CODE() {
		return COMP_CONT_NATIONALITY_CODE;
	}

	public void setCOMP_CONT_NATIONALITY_CODE(
			HtmlInputText cOMP_CONT_NATIONALITY_CODE) {
		COMP_CONT_NATIONALITY_CODE = cOMP_CONT_NATIONALITY_CODE;
	}
	
	public HtmlInputText getCOMP_UI_M_CONT_NATIONALITY_CODE_DESC() {
		return COMP_UI_M_CONT_NATIONALITY_CODE_DESC;
	}

	public void setCOMP_UI_M_CONT_NATIONALITY_CODE_DESC(
			HtmlInputText cOMP_UI_M_CONT_NATIONALITY_CODE_DESC) {
		COMP_UI_M_CONT_NATIONALITY_CODE_DESC = cOMP_UI_M_CONT_NATIONALITY_CODE_DESC;
	}

	public ArrayList<LovBean> lovCUST_NATIONALITY_CODE(Object object) {
		ArrayList<LovBean> suggestionList = null;
		String query1 = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'NATLITY' AND	NVL(PC_FRZ_FLAG,'N') = 'N'  "
				+ " AND (PC_CODE LIKE ? OR PC_DESC LIKE ? ) AND ROWNUM < ? ORDER BY 1";
		try {

			String currentValue = (String) object;
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			suggestionList = ListItemUtil.prepareSuggestionList(query1,
					new Object[] { currentValue, currentValue,
					PELConstants.suggetionRecordSize });

		} catch (Exception e) {
			e.printStackTrace();
		}

		return suggestionList;
	}
	
	public void validateCONT_CATEGORY_CODE(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_CATG_CODE((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorCONT_NATIONALITY_CODE(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_NATIONALITY_CODE((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	private HtmlOutputLabel COMP_CONT_REMARKS_LABEL;
	
	private HtmlInputText COMP_CONT_REMARKS;

	public HtmlOutputLabel getCOMP_CONT_REMARKS_LABEL() {
		return COMP_CONT_REMARKS_LABEL;
	}

	public void setCOMP_CONT_REMARKS_LABEL(HtmlOutputLabel cOMP_CONT_REMARKS_LABEL) {
		COMP_CONT_REMARKS_LABEL = cOMP_CONT_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_CONT_REMARKS() {
		return COMP_CONT_REMARKS;
	}

	public void setCOMP_CONT_REMARKS(HtmlInputText cOMP_CONT_REMARKS) {
		COMP_CONT_REMARKS = cOMP_CONT_REMARKS;
	}
	
	public void validatorCONT_REMARKS(FacesContext context, UIComponent 
			component,Object value)throws ValidatorException {
		try {
			PM_IL_CONTRACTOR_QE_BEAN.setCONT_REMARKS((String)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	/*End*/
	
}
