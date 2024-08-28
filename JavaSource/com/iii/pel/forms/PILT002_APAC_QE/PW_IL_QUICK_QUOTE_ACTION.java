package com.iii.pel.forms.PILT002_APAC_QE;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.ajax4jsf.component.html.HtmlAjaxSupport;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlInputTextarea;
import org.richfaces.component.html.HtmlModalPanel;
import org.richfaces.component.html.HtmlSimpleTogglePanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.forms.PILM035_APAC.PILM035_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_CONSTANTS;
import com.iii.pel.forms.PM006_A_APAC.PM006_A_APAC_QUERY_CONSTANTS;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.pel.utils.PCOPK_GENERAL;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil; 

public class PW_IL_QUICK_QUOTE_ACTION extends CommonAction {

	/*	Heade Detail component*/

	private HtmlOutputText COMP_UI_M_APPRV_STATUS;
	private Double netpremium=0.0;
	private HtmlModalPanel COMP_REPORT_MODAL_PANEL;
	private HtmlModalPanel COMP_REPORT_MODAL_PANEL_CONVERT;
	private HtmlAjaxSupport COMP_QUOT_SRC_BUS_A4J;
	private double coversumass;
	private boolean EFlag;
	private boolean CFlag;
	private boolean DISC_LOADING_FLAG;	
	private HtmlInputText COMP_QUOT_COMM_VALUE;
	private HtmlOutputLabel COMP_QUOT_COMM_VALUE_LABLE;




	public boolean isCFlag() {
		return CFlag;
	}


	public void setCFlag(boolean cFlag) {
		CFlag = cFlag;
	}


	public HtmlInputText getCOMP_QUOT_COMM_VALUE() {
		return COMP_QUOT_COMM_VALUE;
	}


	public void setCOMP_QUOT_COMM_VALUE(HtmlInputText cOMP_QUOT_COMM_VALUE) {
		COMP_QUOT_COMM_VALUE = cOMP_QUOT_COMM_VALUE;
	}


	public HtmlOutputLabel getCOMP_QUOT_COMM_VALUE_LABLE() {
		return COMP_QUOT_COMM_VALUE_LABLE;
	}


	public void setCOMP_QUOT_COMM_VALUE_LABLE(
			HtmlOutputLabel cOMP_QUOT_COMM_VALUE_LABLE) {
		COMP_QUOT_COMM_VALUE_LABLE = cOMP_QUOT_COMM_VALUE_LABLE;
	}


	public HtmlAjaxSupport getCOMP_QUOT_SRC_BUS_A4J() {
		return COMP_QUOT_SRC_BUS_A4J;
	}


	public void setCOMP_QUOT_SRC_BUS_A4J(HtmlAjaxSupport cOMP_QUOT_SRC_BUS_A4J) {
		COMP_QUOT_SRC_BUS_A4J = cOMP_QUOT_SRC_BUS_A4J;
	}


	public boolean isDISC_LOADING_FLAG() {
		return DISC_LOADING_FLAG;
	}


	public void setDISC_LOADING_FLAG(boolean dISC_LOADING_FLAG) {
		DISC_LOADING_FLAG = dISC_LOADING_FLAG;
	}


	public boolean isEFlag() {
		return EFlag;
	}


	public void setEFlag(boolean eFlag) {
		EFlag = eFlag;
	}

	public HtmlModalPanel getCOMP_REPORT_MODAL_PANEL() {
		return COMP_REPORT_MODAL_PANEL;
	}


	public HtmlModalPanel getCOMP_REPORT_MODAL_PANEL_CONVERT() {
		return COMP_REPORT_MODAL_PANEL_CONVERT;
	}


	public void setCOMP_REPORT_MODAL_PANEL_CONVERT(
			HtmlModalPanel cOMP_REPORT_MODAL_PANEL_CONVERT) {
		COMP_REPORT_MODAL_PANEL_CONVERT = cOMP_REPORT_MODAL_PANEL_CONVERT;
	}


	public void setCOMP_REPORT_MODAL_PANEL(HtmlModalPanel cOMP_REPORT_MODAL_PANEL) {
		COMP_REPORT_MODAL_PANEL = cOMP_REPORT_MODAL_PANEL;
	}


	public HtmlOutputText getCOMP_UI_M_APPRV_STATUS() {
		return COMP_UI_M_APPRV_STATUS;
	}


	public void setCOMP_UI_M_APPRV_STATUS(HtmlOutputText cOMP_UI_M_APPRV_STATUS) {
		COMP_UI_M_APPRV_STATUS = cOMP_UI_M_APPRV_STATUS;
	}



	private HtmlOutputLabel COMP_QUOT_ISS_DT_LABEL;
	private HtmlCalendar COMP_QUOT_ISS_DT;
	private HtmlOutputLabel COMP_QUOT_PROD_CODE_LABEL;
	private HtmlInputText COMP_QUOT_PROD_CODE;
	private HtmlOutputLabel COMP_QUOT_FM_DT_LABEL;
	private HtmlCalendar COMP_QUOT_FM_DT;
	private HtmlOutputLabel COMP_QUOT_TO_DT_LABEL;
	private HtmlCalendar COMP_QUOT_TO_DT;

	private HtmlOutputLabel COMP_QUOT_CUST_TITLE_LABEL;
	private HtmlSelectOneMenu COMP_QUOT_CUST_TITLE;
	private HtmlOutputLabel COMP_QUOT_CUST_NAME_LABEL;
	private HtmlInputText COMP_QUOT_CUST_NAME;
	private HtmlOutputLabel COMP_QUOT_CUST_LAST_NAME_LABEL;
	private HtmlInputText COMP_QUOT_CUST_LAST_NAME;
	private HtmlOutputLabel COMP_QUOT_CUST_CODE_LABEL;
	private HtmlInputText COMP_QUOT_CUST_CODE;

	private HtmlOutputLabel COMP_QUOT_NEW_IC_LABEL;
	private HtmlInputText COMP_QUOT_NEW_IC;
	private HtmlOutputLabel COMP_QUOT_DOB_LABEL;
	private HtmlCalendar COMP_QUOT_DOB;
	private HtmlOutputLabel COMP_QQOT_AGE_LABEL;
	private HtmlInputText  COMP_QQOT_AGE;
	private HtmlOutputLabel COMP_QQOT_GENDER_LABLE;
	private HtmlSelectOneMenu COMP_QQOT_GENDER;


	private HtmlOutputLabel COMP_QUOT_FC_SA_LABEL;
	private HtmlInputText COMP_QUOT_FC_SA;
	private HtmlOutputLabel COMP_QUOT_PERIOD_LABEL;
	private HtmlInputText COMP_QUOT_PERIOD;
	private HtmlOutputLabel COMP_QUOT_PREM_PAY_YRS_LABEL;
	private HtmlInputText COMP_QUOT_PREM_PAY_YRS;
	private HtmlOutputLabel COMP_QQOT_FREQUENCY_LABLE;
	private HtmlSelectOneMenu COMP_QQOT_FREQUENCY;



	private HtmlOutputLabel COMP_QUOT_SRC_BUS_LABEL;
	private HtmlInputText COMP_QUOT_SRC_BUS;
	private HtmlOutputLabel COMP_QUOT_SRC_CODE_LABEL;
	private HtmlInputText COMP_UI_QUOT_SRC_BUS_DESC;
	private HtmlInputText COMP_QUOT_SRC_CODE;
	private HtmlInputText COMP_UI_QUOT_SRC_CODE_DESC;
	private HtmlOutputLabel COMP_QUOT_NO_LABEL;
	private HtmlInputText COMP_QUOT_NO;
	private HtmlOutputLabel COMP_QUOT_IDX_NO_LABEL;
	private HtmlInputText COMP_QUOT_IDX_NO;

	/*END*/

	/*	Other Details */
	private HtmlOutputLabel COMP_QQOT_ASSR_CODE_LABEL;
	private HtmlInputText COMP_QQOT_ASSR_CODE;
	private HtmlInputText COMP_QQAD_ASSURED_NAME;
	private HtmlOutputLabel COMP_QQAD_ASSURED_NAME_LABEL;






	public HtmlOutputLabel getCOMP_QQAD_ASSURED_NAME_LABEL() {
		return COMP_QQAD_ASSURED_NAME_LABEL;
	}


	public void setCOMP_QQAD_ASSURED_NAME_LABEL(
			HtmlOutputLabel cOMP_QQAD_ASSURED_NAME_LABEL) {
		COMP_QQAD_ASSURED_NAME_LABEL = cOMP_QQAD_ASSURED_NAME_LABEL;
	}



	private HtmlInputText  COMP_QQOT_HEIGHT;
	private HtmlOutputLabel COMP_QQOT_HEIGHT_LABEL;
	private HtmlInputText  COMP_QQOT_WEIGHT;
	private HtmlOutputLabel COMP_QQOT_WEIGHT_LABEL;
	private HtmlInputText  COMP_QQOT_BMI;
	private HtmlOutputLabel COMP_QQOT_BMI_Lable;


	private HtmlInputText  COMP_QQOT_ADDRESS;
	private HtmlOutputLabel COMP_QQOT_ADDRESS_LABLE;


	private HtmlOutputLabel COMP_QQOT_ADDRESS_LABLE2;
	private HtmlInputText COMP_QQOT_ADDRESS2;
	private HtmlOutputLabel COMP_QQOT_ADDRESS_LABLE3;
	private HtmlInputText COMP_QQOT_ADDRESS3;

	private HtmlOutputLabel COMP_QQAT_MEDICAL_YN_LABEL;
	private HtmlSelectOneMenu COMP_QQAT_MEDICAL_YN;

	private HtmlOutputLabel COMP_QQAT_EMR_LABEL;
	private HtmlInputText COMP_EMR;

	/*	END*/







	public HtmlOutputLabel getCOMP_QQAT_EMR_LABEL() {
		return COMP_QQAT_EMR_LABEL;
	}


	public void setCOMP_QQAT_EMR_LABEL(HtmlOutputLabel cOMP_QQAT_EMR_LABEL) {
		COMP_QQAT_EMR_LABEL = cOMP_QQAT_EMR_LABEL;
	}


	public HtmlInputText getCOMP_EMR() {
		return COMP_EMR;
	}


	public void setCOMP_EMR(HtmlInputText cOMP_EMR) {
		COMP_EMR = cOMP_EMR;
	}



	/*	BankDetails*/
	private List<SelectItem> listQQAT_MEDICAL_YN = new ArrayList<SelectItem>();
	public List<SelectItem> getListQQAT_MEDICAL_YN() {
		return listQQAT_MEDICAL_YN;
	}


	public void setListQQAT_MEDICAL_YN(List<SelectItem> listQQAT_MEDICAL_YN) {
		this.listQQAT_MEDICAL_YN = listQQAT_MEDICAL_YN;
	}



	private HtmlSelectOneMenu COMP_QQOT_LOAN;
	public HtmlOutputLabel getCOMP_QQOT_ADDRESS_LABLE2() {
		return COMP_QQOT_ADDRESS_LABLE2;
	}


	public void setCOMP_QQOT_ADDRESS_LABLE2(HtmlOutputLabel cOMP_QQOT_ADDRESS_LABLE2) {
		COMP_QQOT_ADDRESS_LABLE2 = cOMP_QQOT_ADDRESS_LABLE2;
	}


	public HtmlInputText getCOMP_QQOT_ADDRESS2() {
		return COMP_QQOT_ADDRESS2;
	}


	public void setCOMP_QQOT_ADDRESS2(HtmlInputText cOMP_QQOT_ADDRESS2) {
		COMP_QQOT_ADDRESS2 = cOMP_QQOT_ADDRESS2;
	}


	public HtmlOutputLabel getCOMP_QQOT_ADDRESS_LABLE3() {
		return COMP_QQOT_ADDRESS_LABLE3;
	}


	public void setCOMP_QQOT_ADDRESS_LABLE3(HtmlOutputLabel cOMP_QQOT_ADDRESS_LABLE3) {
		COMP_QQOT_ADDRESS_LABLE3 = cOMP_QQOT_ADDRESS_LABLE3;
	}


	public HtmlInputText getCOMP_QQOT_ADDRESS3() {
		return COMP_QQOT_ADDRESS3;
	}


	public void setCOMP_QQOT_ADDRESS3(HtmlInputText cOMP_QQOT_ADDRESS3) {
		COMP_QQOT_ADDRESS3 = cOMP_QQOT_ADDRESS3;
	}



	private HtmlOutputLabel COMP_QQOT_LOAN_LABLE;
	private HtmlOutputLabel COMP_QUOT_BANK_CODE_LABLE;
	private HtmlInputText COMP_QUOT_BANK_CODE;
	private HtmlOutputLabel COMP_QUOT_BANK_DIVN_LABLE;
	private HtmlInputText COMP_QUOT_BANK_DIVN;
	private HtmlOutputLabel COMP_QUOT_BANK_ACNT_LABLE;
	private HtmlInputText COMP_QUOT_BANK_ACNT;

	//	END
	/*COMMISSION DETAILS*/

	private HtmlOutputLabel COMP_QUOT_SO_CODE_LABLE;
	private HtmlInputText COMP_QUOT_SO_CODE;
	private HtmlOutputLabel COMP_QUOT_SM_CODE_LABLE;
	private HtmlInputText COMP_QUOT_SM_CODE;
	private HtmlOutputLabel COMP_QUOT_AGENT_COMM_RATE_LABLE;
	private HtmlInputText COMP_QUOT_AGENT_COMM_RATE;
	private HtmlOutputLabel COMP_QUOT_AGENT_COMM_VALUE_LABLE;
	private HtmlInputText COMP_QUOT_AGENT_COMM_VALUE;

	/*END*/

	/*Datatables*/

	private HtmlSimpleTogglePanel covertoggle;
	private HtmlSimpleTogglePanel debitoggle;
	private HtmlSimpleTogglePanel chargetoggle;
	private HtmlSimpleTogglePanel headertoggle;
	public HtmlSimpleTogglePanel getHeadertoggle() {
		return headertoggle;
	}


	public void setHeadertoggle(HtmlSimpleTogglePanel headertoggle) {
		this.headertoggle = headertoggle;
	}



	private HtmlSimpleTogglePanel customertoggle;
	private HtmlCommandButton COMP_UI_M_BUT_EXPAND;
	private HtmlCommandButton COMP_CANCEL_BUTTON;
	private HtmlCommandButton COMP_CANCEL_BUTTON_CONVERT;


	public HtmlCommandButton getCOMP_CANCEL_BUTTON_CONVERT() {
		return COMP_CANCEL_BUTTON_CONVERT;
	}


	public void setCOMP_CANCEL_BUTTON_CONVERT(
			HtmlCommandButton cOMP_CANCEL_BUTTON_CONVERT) {
		COMP_CANCEL_BUTTON_CONVERT = cOMP_CANCEL_BUTTON_CONVERT;
	}


	public HtmlCommandButton getCOMP_CANCEL_BUTTON() {
		return COMP_CANCEL_BUTTON;
	}


	public void setCOMP_CANCEL_BUTTON(HtmlCommandButton cOMP_CANCEL_BUTTON) {
		COMP_CANCEL_BUTTON = cOMP_CANCEL_BUTTON;
	}



	private HtmlCommandButton COMP_UI_M_BUT_SHRINK;

	private HtmlCommandLink COMP_UI_M_BUT_EXPAND_LINK;
	private HtmlCommandLink COMP_UI_M_BUT_SHRINK_LINK;
	private HtmlCommandLink  COMP_UI_M_BUT_APPROVAL;

	private HtmlCommandLink  COMP_UI_M_CONV_POL;

	private HtmlCommandLink  COMP_UI_M_MAKE_AMMENMENT;
	private HtmlCommandLink COMP_UI_SAVE_UP;
	private HtmlCommandLink COMP_UI_SAVE_DOWN;

	public HtmlCommandLink getCOMP_UI_SAVE_UP() {
		return COMP_UI_SAVE_UP;
	}


	public void setCOMP_UI_SAVE_UP(HtmlCommandLink cOMP_UI_SAVE_UP) {
		COMP_UI_SAVE_UP = cOMP_UI_SAVE_UP;
	}


	public HtmlCommandLink getCOMP_UI_SAVE_DOWN() {
		return COMP_UI_SAVE_DOWN;
	}


	public void setCOMP_UI_SAVE_DOWN(HtmlCommandLink cOMP_UI_SAVE_DOWN) {
		COMP_UI_SAVE_DOWN = cOMP_UI_SAVE_DOWN;
	}



	private HtmlCommandLink COMP_UI_M_CLC_PREMIUM;




	public HtmlCommandLink getCOMP_UI_M_BUT_APPROVAL() {
		return COMP_UI_M_BUT_APPROVAL;
	}


	public void setCOMP_UI_M_BUT_APPROVAL(HtmlCommandLink cOMP_UI_M_BUT_APPROVAL) {
		COMP_UI_M_BUT_APPROVAL = cOMP_UI_M_BUT_APPROVAL;
	}


	public HtmlCommandLink getCOMP_UI_M_CONV_POL() {
		return COMP_UI_M_CONV_POL;
	}


	public void setCOMP_UI_M_CONV_POL(HtmlCommandLink cOMP_UI_M_CONV_POL) {
		COMP_UI_M_CONV_POL = cOMP_UI_M_CONV_POL;
	}


	public HtmlCommandLink getCOMP_UI_M_MAKE_AMMENMENT() {
		return COMP_UI_M_MAKE_AMMENMENT;
	}


	public void setCOMP_UI_M_MAKE_AMMENMENT(HtmlCommandLink cOMP_UI_M_MAKE_AMMENMENT) {
		COMP_UI_M_MAKE_AMMENMENT = cOMP_UI_M_MAKE_AMMENMENT;
	}


	public HtmlCommandLink getCOMP_UI_M_CLC_PREMIUM() {
		return COMP_UI_M_CLC_PREMIUM;
	}


	public void setCOMP_UI_M_CLC_PREMIUM(HtmlCommandLink cOMP_UI_M_CLC_PREMIUM) {
		COMP_UI_M_CLC_PREMIUM = cOMP_UI_M_CLC_PREMIUM;
	}


	public HtmlCommandLink getCOMP_UI_M_BUT_EXPAND_LINK() {
		return COMP_UI_M_BUT_EXPAND_LINK;
	}


	public void setCOMP_UI_M_BUT_EXPAND_LINK(
			HtmlCommandLink cOMP_UI_M_BUT_EXPAND_LINK) {
		COMP_UI_M_BUT_EXPAND_LINK = cOMP_UI_M_BUT_EXPAND_LINK;
	}


	public HtmlCommandLink getCOMP_UI_M_BUT_SHRINK_LINK() {
		return COMP_UI_M_BUT_SHRINK_LINK;
	}


	public void setCOMP_UI_M_BUT_SHRINK_LINK(
			HtmlCommandLink cOMP_UI_M_BUT_SHRINK_LINK) {
		COMP_UI_M_BUT_SHRINK_LINK = cOMP_UI_M_BUT_SHRINK_LINK;
	}



	/*Added by Sankar 29.4.2016*/
	
	private HtmlCommandButton COMP_UI_m_Quick_Brk_Add_cover;
	private HtmlCommandButton COMP_UI_m_Quick_Brk_Add_charge;
	
	private HtmlCommandButton COMP_UI_m_Quick_Brk_Add_debit;
	private HtmlCommandButton COMP_Quick_DELETE_COVER;
	private HtmlCommandButton COMP_Quick_DELETE_DEBIT;
	private HtmlCommandButton COMP_Quick_DELETE_CHARGE;

	
	
	



	//gross premium 
	/*Added by ameen  for ssp call id FALCONLIFE-1349309 on19-10-16*/
    private HtmlAjaxCommandButton COMP_UI_m_Quick_Brk_create_cover;
	
	
	public HtmlAjaxCommandButton getCOMP_UI_m_Quick_Brk_create_cover() {
		return COMP_UI_m_Quick_Brk_create_cover;
	}


	public void setCOMP_UI_m_Quick_Brk_create_cover(
			HtmlAjaxCommandButton cOMP_UI_m_Quick_Brk_create_cover) {
		COMP_UI_m_Quick_Brk_create_cover = cOMP_UI_m_Quick_Brk_create_cover;
	}
	/*end*/
	/*Added by ameen  for ssp call id FALCONLIFE-1349309 on19-10-16*/
   private HtmlAjaxCommandButton COMP_UI_m_Quick_Brk_create_debit;
	
	public HtmlAjaxCommandButton getCOMP_UI_m_Quick_Brk_create_debit() {
		return COMP_UI_m_Quick_Brk_create_debit;
	}


	public void setCOMP_UI_m_Quick_Brk_create_debit(
			HtmlAjaxCommandButton cOMP_UI_m_Quick_Brk_create_debit) {
		COMP_UI_m_Quick_Brk_create_debit = cOMP_UI_m_Quick_Brk_create_debit;
	}
  /*end*/
	/*Added by ameen  for ssp call id FALCONLIFE-1349309 on19-10-16*/
    private HtmlAjaxCommandButton COMP_UI_m_Quick_Brk_CREATE_charge;
	
	public HtmlAjaxCommandButton getCOMP_UI_m_Quick_Brk_CREATE_charge() {
		return COMP_UI_m_Quick_Brk_CREATE_charge;
	}


	public void setCOMP_UI_m_Quick_Brk_CREATE_charge(
			HtmlAjaxCommandButton cOMP_UI_m_Quick_Brk_CREATE_charge) {
		COMP_UI_m_Quick_Brk_CREATE_charge = cOMP_UI_m_Quick_Brk_CREATE_charge;
	}
	/*END*/

	private HtmlOutputLabel COMP_QQAD_GROSS_PREMIUM_LABLE;
	private HtmlInputText COMP_QQAD_GROSS_PREMIUM;



	/*ADDITIONAL COVER*/

	public HtmlOutputLabel getCOMP_QQAD_GROSS_PREMIUM_LABLE() {
		return COMP_QQAD_GROSS_PREMIUM_LABLE;
	}


	public void setCOMP_QQAD_GROSS_PREMIUM_LABLE(
			HtmlOutputLabel cOMP_QQAD_GROSS_PREMIUM_LABLE) {
		COMP_QQAD_GROSS_PREMIUM_LABLE = cOMP_QQAD_GROSS_PREMIUM_LABLE;
	}



	private HtmlOutputLabel  COMP_QQAT_COVER_CODE_LABEL;
	private HtmlInputText COMP_QQAT_COVER_CODE;
	private HtmlInputText COMP_UI_M_QQAT_COVER_DESC;
	private HtmlOutputLabel COMP_QQAC_CHRG_CODE_LABEL;
	private HtmlInputText  COMP_QQAC_CHRG_CODE;
	private HtmlInputText  COMP_QQAC_CHRG_DESC;
	private HtmlOutputText  COMP_QQAT_COVER_CODE_MANDATORY;
	private HtmlOutputText COMP_DIS_TYPE_MANDATORY;
	private HtmlOutputText COMP_DIS_CODE_MANDATORY;
	private HtmlOutputText COMP_CHARGE_CODE_MANDATORY;
	private HtmlInputText  UI_M_CHRG_DESC;
	private HtmlGraphicImage  COMP_UI_M_QQAT_COVER_SUG_IMG;


	public HtmlInputText getCOMP_ADD_QQAC_TERM() {
		return COMP_ADD_QQAC_TERM;
	}


	public void setCOMP_ADD_QQAC_TERM(HtmlInputText cOMP_ADD_QQAC_TERM) {
		COMP_ADD_QQAC_TERM = cOMP_ADD_QQAC_TERM;
	}


	public HtmlOutputLabel getCOMP_ADD_QQAC_TERM_LABEL() {
		return COMP_ADD_QQAC_TERM_LABEL;
	}


	public void setCOMP_ADD_QQAC_TERM_LABEL(HtmlOutputLabel cOMP_ADD_QQAC_TERM_LABEL) {
		COMP_ADD_QQAC_TERM_LABEL = cOMP_ADD_QQAC_TERM_LABEL;
	}


	public HtmlOutputText getCOMP_QQAT_COVER_TERM_MANDATORY() {
		return COMP_QQAT_COVER_TERM_MANDATORY;
	}


	public void setCOMP_QQAT_COVER_TERM_MANDATORY(
			HtmlOutputText cOMP_QQAT_COVER_TERM_MANDATORY) {
		COMP_QQAT_COVER_TERM_MANDATORY = cOMP_QQAT_COVER_TERM_MANDATORY;
	}



	private HtmlInputText  COMP_ADD_QQAC_RATE;
	private HtmlInputText  COMP_ADD_QQAC_RATE_PER;
	private HtmlInputText COMP_ADD_QQAC_TERM;
	private HtmlOutputLabel  COMP_ADD_QQAC_RATE_LABEL;
	private HtmlOutputLabel  COMP_ADD_QQAC_RATE_PER_LABEL;
	private HtmlOutputLabel  COMP_ADD_QQAC_TERM_LABEL;
	private HtmlOutputText COMP_QQAT_COVER_TERM_MANDATORY;
	private HtmlOutputText COMP_QQAT_COVER_RATE_MANDATORY;
	private HtmlOutputText COMP_QQAT_COVER_RATE_PER_MANDATORY;
	private HtmlGraphicImage COMP_UI_M_QQAT_DDEBIT_SUG_IMG;

	private HtmlOutputLabel  COMP_ADD_QQAC_PREMIUM_LABEL;
	private HtmlInputText   COMP_ADD_QQAC_PREMIUM;
	private HtmlOutputText COMP_ADD_QQAC_PREMIUM_MANDATORY;


	private HtmlOutputLabel  COMP_ADD_QQAC_SUM_ASS_LABEL;
	private HtmlOutputText COMP_ADD_QQAC_SUM_ASS_MANDATORY;
	private HtmlInputText COMP_ADD_QQAC_SUM_ASS;
	private HtmlGraphicImage COMP_UI_M_QQAT_GHARGE_SUG_IMG;



	/*Added By jagadeesh For the Field EMR Rate*/

	private HtmlOutputLabel COMP_ADD_QQAC_EMR_RATE_LABEL;
	private HtmlInputText  COMP_ADD_QQAC_EMR_RATE;

	public HtmlOutputLabel getCOMP_ADD_QQAC_EMR_RATE_LABEL() {
		return COMP_ADD_QQAC_EMR_RATE_LABEL;
	}


	public void setCOMP_ADD_QQAC_EMR_RATE_LABEL(
			HtmlOutputLabel cOMP_ADD_QQAC_EMR_RATE_LABEL) {
		COMP_ADD_QQAC_EMR_RATE_LABEL = cOMP_ADD_QQAC_EMR_RATE_LABEL;
	}


	public HtmlInputText getCOMP_ADD_QQAC_EMR_RATE() {
		return COMP_ADD_QQAC_EMR_RATE;
	}


	public void setCOMP_ADD_QQAC_EMR_RATE(HtmlInputText cOMP_ADD_QQAC_EMR_RATE) {
		COMP_ADD_QQAC_EMR_RATE = cOMP_ADD_QQAC_EMR_RATE;
	}

	/*	END*/




	public HtmlGraphicImage getCOMP_UI_M_QQAT_GHARGE_SUG_IMG() {
		return COMP_UI_M_QQAT_GHARGE_SUG_IMG;
	}



	public void setCOMP_UI_M_QQAT_GHARGE_SUG_IMG(
			HtmlGraphicImage cOMP_UI_M_QQAT_GHARGE_SUG_IMG) {
		COMP_UI_M_QQAT_GHARGE_SUG_IMG = cOMP_UI_M_QQAT_GHARGE_SUG_IMG;
	}



	private List<SelectItem> listPDL_APPLIED_ON = new ArrayList<SelectItem>();

	private HtmlOutputLabel  COMP_QQAT_DISC_LOAD_TYPE_LABEL;
	private HtmlSelectOneMenu COMP_QQAT_DISC_LOAD_TYPE;
	private HtmlOutputLabel  COMP_QQAT_DISC_LOAD_CODE_LABEL;
	private HtmlInputText COMP_QQAT_DISC_LOAD_CODE;
	private HtmlInputText COMP_UI_M_DISCLOAD_DESC;	
	private HtmlOutputText COMP_ADD_QQDL_APPLIED_ON_MANDATORY;
	private HtmlOutputText COMP_ADD_QQDL_RATE_MANDATORY;
	private HtmlOutputLabel COMP_ADD_QQDL_APPLIED_ON_LABEL;
	private HtmlOutputLabel COMP_ADD_QQDL_RATE_LABLE;
	private HtmlSelectOneMenu COMP_ADD_QQDL_APPLIED_ON;
	private HtmlInputText COMP_ADD_QQDL_RATE;
	private HtmlOutputLabel COMP_ADD_QQDL_RATE_PER_LABEL;
	private HtmlOutputText COMP_QQDL_RATE_PER_MANDATORY;
	private HtmlInputText COMP_ADD_QQDL_RATE_PER;
	private HtmlOutputLabel COMP_ADD_QQDL_VALUE_LABEL;
	private HtmlOutputText COMP_ADD_QQDL_VALUE_MANDATORY;
	private HtmlInputText COMP_ADD_QQDL_VALUE;

	private HtmlOutputLabel COMP_QQDL_COVER_CODE_LABEL;
	private HtmlOutputText COMP_QQDL_COVER_CODE_MANDATORY;
	private HtmlInputText COMP_QQDL_COVER_CODE;
	private HtmlInputText COMP_UI_M_QQDL_COVER_DESC;






	private List<SelectItem> listPOC_APPLIED_ON = new ArrayList<SelectItem>();

	private List<SelectItem> listPOC_APPLY_PERIOD = new ArrayList<SelectItem>();


	private HtmlOutputLabel COMP_ADD_QQAC_APPLIED_ON_LABEL;
	private HtmlOutputText COMP_ADD_QQAC_APPLIED_ON_MANDATORY;
	private HtmlSelectOneMenu COMP_POC_APPLIED_ON;
	private HtmlOutputLabel COMP_ADD_QQAC_APPLY_PERIOD_LABEL;
	private HtmlOutputText COMP_ADD_QQAC_APPLY_PERIOD_MANDATORY;
	private HtmlSelectOneMenu COMP_ADD_QQAC_APPLY_PERIOD;
	private HtmlOutputLabel COMP_QQAC_RATE_LABEL;
	private HtmlOutputText COMP_QQAC_RATE_MANDATORY;
	private HtmlInputText COMP_QQAC_RATE;
	private HtmlOutputLabel COMP_QQAC_RATE_PER_LABEL;
	private HtmlOutputText COMP_QQAC_RATE_PER_MANDATORY;
	private HtmlInputText COMP_QQAC_RATE_PER;
	private HtmlOutputLabel COMP_QQAC_FC_CHRG_AMT_LABEL;
	private HtmlOutputText COMP_QQAC_FC_CHRG_AMT_MANDATORY;
	private HtmlInputText COMP_QQAC_FC_CHRG_AMT;


	/*END*/

	//class initialisation//
	public PILT002_APAC_QE_COMPOSITE_ACTION compositeAction;
	private PW_IL_QUICK_QUOTE PW_IL_QUICK_QUOTE_BEAN;
	private PM_CUSTOMER PM_CUSTOMER_BEAN;
	private PW_IL_QQUOT_ASSURED_DTLS PW_IL_QUICK_QUOTE_DTLS_BEAN;
	private PW_IL_QUICK_QUOTE_HELPER helper;
	private PW_IL_QUICK_QUOTE_DELEGATE delegate;
	private ArrayList<SelectItem> listQUOT_CUST_TITLE;
	private List<SelectItem> listQUOT_CUST_GENDER = new ArrayList<SelectItem>();
	private List<SelectItem> listQQOT_MODE_OF_PYMT = new ArrayList<SelectItem>();

	//table list
	private List<PW_IL_QQUOT_DISC_LOAD> quickdataList_PT_IL_POL_DISC_LOAD = new ArrayList<PW_IL_QQUOT_DISC_LOAD>();
	private List<PW_IL_QQUOT_APPL_COVER> quickdataList_PM_IL_PROD_APPL_COVER = new ArrayList<PW_IL_QQUOT_APPL_COVER>();
	private List<PW_IL_QQUOT_APPL_CHARGE> quickdataList_PT_IL_POL_CHARGE = new ArrayList<PW_IL_QQUOT_APPL_CHARGE>();
	private PW_IL_QQUOT_DISC_LOAD PW_IL_QQUOT_DISC_LOAD_BEAN;
	private PW_IL_QQUOT_APPL_COVER PW_IL_QQUOT_APPL_COVER_BEAN;
	private PW_IL_QQUOT_APPL_CHARGE PW_IL_QQUOT_APPL_CHARGE_BEAN;

	private PW_IL_QQUOT_BROK_HDR PW_IL_QQUOT_BROK_HDR_BEAN;
	private PW_IL_QQUOT_BROK_DTL PW_IL_QQUOT_BROK_DTL_BEAN;
	private List<SelectItem> listPDL_DISC_LOAD_TYPE = new ArrayList<SelectItem>();

	//PT_IL_POL_ADDL_COVER PM_IL_PROD_APPL_COVER_BEAN;
	//PW_IL_QQUOT_DISC_LOAD PM_IL_PROD_APPL_LOAD_TARIFF_BEAN;
	//PW_IL_QQUOT_APPL_CHARGE PT_IL_POL_CHARGE_BEAN;
	private UIData debitdataTable;
	private UIData chargedataTable;
	private UIData coverdataTable;

	private int Selectedcoverindex=1;
	
  /*added by janani for cursor ssp call id FALCONLIFE-1349309 on 18-10-16*/
   private HtmlInputText sample;
  
   public HtmlInputText getSample() {
		return sample;
	}
   
   public void setSample(HtmlInputText sample) {
		this.sample = sample;
	}
    /*end*/
	private HtmlCommandButton COMP_QUOT_CUST_MORE_INFO;




	public HtmlOutputLabel getCOMP_QQAC_CHRG_CODE_LABEL() {
		return COMP_QQAC_CHRG_CODE_LABEL;
	}


	public HtmlInputText getCOMP_ADD_QQAC_RATE_PER() {
		return COMP_ADD_QQAC_RATE_PER;
	}


	public void setCOMP_ADD_QQAC_RATE_PER(HtmlInputText cOMP_ADD_QQAC_RATE_PER) {
		COMP_ADD_QQAC_RATE_PER = cOMP_ADD_QQAC_RATE_PER;
	}


	public HtmlGraphicImage getCOMP_UI_M_QQAT_COVER_SUG_IMG() {
		return COMP_UI_M_QQAT_COVER_SUG_IMG;
	}


	public void setCOMP_UI_M_QQAT_COVER_SUG_IMG(
			HtmlGraphicImage cOMP_UI_M_QQAT_COVER_SUG_IMG) {
		COMP_UI_M_QQAT_COVER_SUG_IMG = cOMP_UI_M_QQAT_COVER_SUG_IMG;
	}


	public HtmlOutputText getCOMP_CHARGE_CODE_MANDATORY() {
		return COMP_CHARGE_CODE_MANDATORY;
	}


	public HtmlInputText getCOMP_QQAD_GROSS_PREMIUM() {
		return COMP_QQAD_GROSS_PREMIUM;
	}


	public HtmlOutputLabel getCOMP_QQDL_COVER_CODE_LABEL() {
		return COMP_QQDL_COVER_CODE_LABEL;
	}


	public void setCOMP_QQDL_COVER_CODE_LABEL(
			HtmlOutputLabel cOMP_QQDL_COVER_CODE_LABEL) {
		COMP_QQDL_COVER_CODE_LABEL = cOMP_QQDL_COVER_CODE_LABEL;
	}


	public HtmlOutputText getCOMP_QQDL_COVER_CODE_MANDATORY() {
		return COMP_QQDL_COVER_CODE_MANDATORY;
	}


	public void setCOMP_QQDL_COVER_CODE_MANDATORY(
			HtmlOutputText cOMP_QQDL_COVER_CODE_MANDATORY) {
		COMP_QQDL_COVER_CODE_MANDATORY = cOMP_QQDL_COVER_CODE_MANDATORY;
	}


	public HtmlInputText getCOMP_QQDL_COVER_CODE() {
		return COMP_QQDL_COVER_CODE;
	}


	public void setCOMP_QQDL_COVER_CODE(HtmlInputText cOMP_QQDL_COVER_CODE) {
		COMP_QQDL_COVER_CODE = cOMP_QQDL_COVER_CODE;
	}


	public HtmlInputText getCOMP_UI_M_QQDL_COVER_DESC() {
		return COMP_UI_M_QQDL_COVER_DESC;
	}


	public void setCOMP_UI_M_QQDL_COVER_DESC(HtmlInputText cOMP_UI_M_QQDL_COVER_DESC) {
		COMP_UI_M_QQDL_COVER_DESC = cOMP_UI_M_QQDL_COVER_DESC;
	}


	public void setCOMP_QQAD_GROSS_PREMIUM(HtmlInputText cOMP_QQAD_GROSS_PREMIUM) {
		COMP_QQAD_GROSS_PREMIUM = cOMP_QQAD_GROSS_PREMIUM;
	}


	public void setCOMP_CHARGE_CODE_MANDATORY(
			HtmlOutputText cOMP_CHARGE_CODE_MANDATORY) {
		COMP_CHARGE_CODE_MANDATORY = cOMP_CHARGE_CODE_MANDATORY;
	}


	public HtmlGraphicImage getCOMP_UI_M_QQAT_DDEBIT_SUG_IMG() {
		return COMP_UI_M_QQAT_DDEBIT_SUG_IMG;
	}


	public void setCOMP_UI_M_QQAT_DDEBIT_SUG_IMG(
			HtmlGraphicImage cOMP_UI_M_QQAT_DDEBIT_SUG_IMG) {
		COMP_UI_M_QQAT_DDEBIT_SUG_IMG = cOMP_UI_M_QQAT_DDEBIT_SUG_IMG;
	}


	public HtmlOutputLabel getCOMP_ADD_QQAC_PREMIUM_LABEL() {
		return COMP_ADD_QQAC_PREMIUM_LABEL;
	}


	public void setCOMP_ADD_QQAC_PREMIUM_LABEL(
			HtmlOutputLabel cOMP_ADD_QQAC_PREMIUM_LABEL) {
		COMP_ADD_QQAC_PREMIUM_LABEL = cOMP_ADD_QQAC_PREMIUM_LABEL;
	}


	public HtmlInputText getCOMP_ADD_QQAC_PREMIUM() {
		return COMP_ADD_QQAC_PREMIUM;
	}


	public void setCOMP_ADD_QQAC_PREMIUM(HtmlInputText cOMP_ADD_QQAC_PREMIUM) {
		COMP_ADD_QQAC_PREMIUM = cOMP_ADD_QQAC_PREMIUM;
	}


	public HtmlOutputText getCOMP_ADD_QQAC_PREMIUM_MANDATORY() {
		return COMP_ADD_QQAC_PREMIUM_MANDATORY;
	}


	public void setCOMP_ADD_QQAC_PREMIUM_MANDATORY(
			HtmlOutputText cOMP_ADD_QQAC_PREMIUM_MANDATORY) {
		COMP_ADD_QQAC_PREMIUM_MANDATORY = cOMP_ADD_QQAC_PREMIUM_MANDATORY;
	}


	public HtmlInputText getUI_M_CHRG_DESC() {
		return UI_M_CHRG_DESC;
	}


	public void setUI_M_CHRG_DESC(HtmlInputText uI_M_CHRG_DESC) {
		UI_M_CHRG_DESC = uI_M_CHRG_DESC;
	}


	public void setCOMP_QQAC_CHRG_CODE_LABEL(
			HtmlOutputLabel cOMP_QQAC_CHRG_CODE_LABEL) {
		COMP_QQAC_CHRG_CODE_LABEL = cOMP_QQAC_CHRG_CODE_LABEL;
	}





	public HtmlOutputText getCOMP_QQAT_COVER_CODE_MANDATORY() {
		return COMP_QQAT_COVER_CODE_MANDATORY;
	}


	public void setCOMP_QQAT_COVER_CODE_MANDATORY(
			HtmlOutputText cOMP_QQAT_COVER_CODE_MANDATORY) {
		COMP_QQAT_COVER_CODE_MANDATORY = cOMP_QQAT_COVER_CODE_MANDATORY;
	}


	public HtmlOutputText getCOMP_DIS_TYPE_MANDATORY() {
		return COMP_DIS_TYPE_MANDATORY;
	}


	public void setCOMP_DIS_TYPE_MANDATORY(HtmlOutputText cOMP_DIS_TYPE_MANDATORY) {
		COMP_DIS_TYPE_MANDATORY = cOMP_DIS_TYPE_MANDATORY;
	}


	public HtmlOutputText getCOMP_DIS_CODE_MANDATORY() {
		return COMP_DIS_CODE_MANDATORY;
	}


	public void setCOMP_DIS_CODE_MANDATORY(HtmlOutputText cOMP_DIS_CODE_MANDATORY) {
		COMP_DIS_CODE_MANDATORY = cOMP_DIS_CODE_MANDATORY;
	}



	public HtmlInputText getCOMP_QQAC_CHRG_CODE() {
		return COMP_QQAC_CHRG_CODE;
	}


	public void setCOMP_QQAC_CHRG_CODE(HtmlInputText cOMP_QQAC_CHRG_CODE) {
		COMP_QQAC_CHRG_CODE = cOMP_QQAC_CHRG_CODE;
	}


	public HtmlInputText getCOMP_QQAC_CHRG_DESC() {
		return COMP_QQAC_CHRG_DESC;
	}


	public void setCOMP_QQAC_CHRG_DESC(HtmlInputText cOMP_QQAC_CHRG_DESC) {
		COMP_QQAC_CHRG_DESC = cOMP_QQAC_CHRG_DESC;
	}









	/*	Other detail get set*/


	public HtmlInputText getCOMP_UI_M_QQAT_COVER_DESC() {
		return COMP_UI_M_QQAT_COVER_DESC;
	}


	public void setCOMP_UI_M_QQAT_COVER_DESC(HtmlInputText cOMP_UI_M_QQAT_COVER_DESC) {
		COMP_UI_M_QQAT_COVER_DESC = cOMP_UI_M_QQAT_COVER_DESC;
	}



	public HtmlOutputLabel getCOMP_QQAT_DISC_LOAD_TYPE_LABEL() {
		return COMP_QQAT_DISC_LOAD_TYPE_LABEL;
	}


	public void setCOMP_QQAT_DISC_LOAD_TYPE_LABEL(
			HtmlOutputLabel cOMP_QQAT_DISC_LOAD_TYPE_LABEL) {
		COMP_QQAT_DISC_LOAD_TYPE_LABEL = cOMP_QQAT_DISC_LOAD_TYPE_LABEL;
	}


	public HtmlOutputLabel getCOMP_ADD_QQAC_SUM_ASS_LABEL() {
		return COMP_ADD_QQAC_SUM_ASS_LABEL;
	}


	public void setCOMP_ADD_QQAC_SUM_ASS_LABEL(
			HtmlOutputLabel cOMP_ADD_QQAC_SUM_ASS_LABEL) {
		COMP_ADD_QQAC_SUM_ASS_LABEL = cOMP_ADD_QQAC_SUM_ASS_LABEL;
	}


	public HtmlOutputText getCOMP_ADD_QQAC_SUM_ASS_MANDATORY() {
		return COMP_ADD_QQAC_SUM_ASS_MANDATORY;
	}


	public void setCOMP_ADD_QQAC_SUM_ASS_MANDATORY(
			HtmlOutputText cOMP_ADD_QQAC_SUM_ASS_MANDATORY) {
		COMP_ADD_QQAC_SUM_ASS_MANDATORY = cOMP_ADD_QQAC_SUM_ASS_MANDATORY;
	}


	public HtmlInputText getCOMP_ADD_QQAC_SUM_ASS() {
		return COMP_ADD_QQAC_SUM_ASS;
	}


	public void setCOMP_ADD_QQAC_SUM_ASS(HtmlInputText cOMP_ADD_QQAC_SUM_ASS) {
		COMP_ADD_QQAC_SUM_ASS = cOMP_ADD_QQAC_SUM_ASS;
	}


	public HtmlSelectOneMenu getCOMP_QQAT_DISC_LOAD_TYPE() {
		return COMP_QQAT_DISC_LOAD_TYPE;
	}


	public void setCOMP_QQAT_DISC_LOAD_TYPE(
			HtmlSelectOneMenu cOMP_QQAT_DISC_LOAD_TYPE) {
		COMP_QQAT_DISC_LOAD_TYPE = cOMP_QQAT_DISC_LOAD_TYPE;
	}


	public HtmlOutputLabel getCOMP_QQAT_DISC_LOAD_CODE_LABEL() {
		return COMP_QQAT_DISC_LOAD_CODE_LABEL;
	}


	public void setCOMP_QQAT_DISC_LOAD_CODE_LABEL(
			HtmlOutputLabel cOMP_QQAT_DISC_LOAD_CODE_LABEL) {
		COMP_QQAT_DISC_LOAD_CODE_LABEL = cOMP_QQAT_DISC_LOAD_CODE_LABEL;
	}


	public HtmlInputText getCOMP_QQAT_DISC_LOAD_CODE() {
		return COMP_QQAT_DISC_LOAD_CODE;
	}


	public void setCOMP_QQAT_DISC_LOAD_CODE(HtmlInputText cOMP_QQAT_DISC_LOAD_CODE) {
		COMP_QQAT_DISC_LOAD_CODE = cOMP_QQAT_DISC_LOAD_CODE;
	}


	public HtmlInputText getCOMP_UI_M_DISCLOAD_DESC() {
		return COMP_UI_M_DISCLOAD_DESC;
	}


	public void setCOMP_UI_M_DISCLOAD_DESC(HtmlInputText cOMP_UI_M_DISCLOAD_DESC) {
		COMP_UI_M_DISCLOAD_DESC = cOMP_UI_M_DISCLOAD_DESC;
	}


	public HtmlSimpleTogglePanel getCustomertoggle() {
		return customertoggle;
	}


	public void setCustomertoggle(HtmlSimpleTogglePanel customertoggle) {
		this.customertoggle = customertoggle;
	}


	public HtmlCommandButton getCOMP_UI_M_BUT_EXPAND() {
		return COMP_UI_M_BUT_EXPAND;
	}


	public void setCOMP_UI_M_BUT_EXPAND(HtmlCommandButton cOMP_UI_M_BUT_EXPAND) {
		COMP_UI_M_BUT_EXPAND = cOMP_UI_M_BUT_EXPAND;
	}


	public List<SelectItem> getListPOC_APPLIED_ON() {
		return listPOC_APPLIED_ON;
	}


	public void setListPOC_APPLIED_ON(List<SelectItem> listPOC_APPLIED_ON) {
		this.listPOC_APPLIED_ON = listPOC_APPLIED_ON;
	}


	public List<SelectItem> getListPOC_APPLY_PERIOD() {
		return listPOC_APPLY_PERIOD;
	}


	public void setListPOC_APPLY_PERIOD(List<SelectItem> listPOC_APPLY_PERIOD) {
		this.listPOC_APPLY_PERIOD = listPOC_APPLY_PERIOD;
	}


	public HtmlOutputLabel getCOMP_ADD_QQAC_APPLIED_ON_LABEL() {
		return COMP_ADD_QQAC_APPLIED_ON_LABEL;
	}


	public void setCOMP_ADD_QQAC_APPLIED_ON_LABEL(
			HtmlOutputLabel cOMP_ADD_QQAC_APPLIED_ON_LABEL) {
		COMP_ADD_QQAC_APPLIED_ON_LABEL = cOMP_ADD_QQAC_APPLIED_ON_LABEL;
	}


	public HtmlOutputText getCOMP_ADD_QQAC_APPLIED_ON_MANDATORY() {
		return COMP_ADD_QQAC_APPLIED_ON_MANDATORY;
	}


	public void setCOMP_ADD_QQAC_APPLIED_ON_MANDATORY(
			HtmlOutputText cOMP_ADD_QQAC_APPLIED_ON_MANDATORY) {
		COMP_ADD_QQAC_APPLIED_ON_MANDATORY = cOMP_ADD_QQAC_APPLIED_ON_MANDATORY;
	}


	public HtmlSelectOneMenu getCOMP_POC_APPLIED_ON() {
		return COMP_POC_APPLIED_ON;
	}


	public void setCOMP_POC_APPLIED_ON(HtmlSelectOneMenu cOMP_POC_APPLIED_ON) {
		COMP_POC_APPLIED_ON = cOMP_POC_APPLIED_ON;
	}


	public HtmlOutputLabel getCOMP_ADD_QQAC_APPLY_PERIOD_LABEL() {
		return COMP_ADD_QQAC_APPLY_PERIOD_LABEL;
	}


	public void setCOMP_ADD_QQAC_APPLY_PERIOD_LABEL(
			HtmlOutputLabel cOMP_ADD_QQAC_APPLY_PERIOD_LABEL) {
		COMP_ADD_QQAC_APPLY_PERIOD_LABEL = cOMP_ADD_QQAC_APPLY_PERIOD_LABEL;
	}


	public HtmlOutputText getCOMP_ADD_QQAC_APPLY_PERIOD_MANDATORY() {
		return COMP_ADD_QQAC_APPLY_PERIOD_MANDATORY;
	}


	public void setCOMP_ADD_QQAC_APPLY_PERIOD_MANDATORY(
			HtmlOutputText cOMP_ADD_QQAC_APPLY_PERIOD_MANDATORY) {
		COMP_ADD_QQAC_APPLY_PERIOD_MANDATORY = cOMP_ADD_QQAC_APPLY_PERIOD_MANDATORY;
	}


	public HtmlSelectOneMenu getCOMP_ADD_QQAC_APPLY_PERIOD() {
		return COMP_ADD_QQAC_APPLY_PERIOD;
	}


	public void setCOMP_ADD_QQAC_APPLY_PERIOD(
			HtmlSelectOneMenu cOMP_ADD_QQAC_APPLY_PERIOD) {
		COMP_ADD_QQAC_APPLY_PERIOD = cOMP_ADD_QQAC_APPLY_PERIOD;
	}


	public HtmlOutputLabel getCOMP_QQAC_RATE_LABEL() {
		return COMP_QQAC_RATE_LABEL;
	}


	public void setCOMP_QQAC_RATE_LABEL(HtmlOutputLabel cOMP_QQAC_RATE_LABEL) {
		COMP_QQAC_RATE_LABEL = cOMP_QQAC_RATE_LABEL;
	}


	public HtmlOutputText getCOMP_QQAC_RATE_MANDATORY() {
		return COMP_QQAC_RATE_MANDATORY;
	}


	public void setCOMP_QQAC_RATE_MANDATORY(HtmlOutputText cOMP_QQAC_RATE_MANDATORY) {
		COMP_QQAC_RATE_MANDATORY = cOMP_QQAC_RATE_MANDATORY;
	}


	public HtmlInputText getCOMP_QQAC_RATE() {
		return COMP_QQAC_RATE;
	}


	public void setCOMP_QQAC_RATE(HtmlInputText cOMP_QQAC_RATE) {
		COMP_QQAC_RATE = cOMP_QQAC_RATE;
	}


	public HtmlOutputLabel getCOMP_QQAC_RATE_PER_LABEL() {
		return COMP_QQAC_RATE_PER_LABEL;
	}


	public void setCOMP_QQAC_RATE_PER_LABEL(HtmlOutputLabel cOMP_QQAC_RATE_PER_LABEL) {
		COMP_QQAC_RATE_PER_LABEL = cOMP_QQAC_RATE_PER_LABEL;
	}


	public HtmlOutputText getCOMP_QQAC_RATE_PER_MANDATORY() {
		return COMP_QQAC_RATE_PER_MANDATORY;
	}


	public void setCOMP_QQAC_RATE_PER_MANDATORY(
			HtmlOutputText cOMP_QQAC_RATE_PER_MANDATORY) {
		COMP_QQAC_RATE_PER_MANDATORY = cOMP_QQAC_RATE_PER_MANDATORY;
	}


	public HtmlInputText getCOMP_QQAC_RATE_PER() {
		return COMP_QQAC_RATE_PER;
	}


	public void setCOMP_QQAC_RATE_PER(HtmlInputText cOMP_QQAC_RATE_PER) {
		COMP_QQAC_RATE_PER = cOMP_QQAC_RATE_PER;
	}


	public HtmlOutputLabel getCOMP_QQAC_FC_CHRG_AMT_LABEL() {
		return COMP_QQAC_FC_CHRG_AMT_LABEL;
	}


	public void setCOMP_QQAC_FC_CHRG_AMT_LABEL(
			HtmlOutputLabel cOMP_QQAC_FC_CHRG_AMT_LABEL) {
		COMP_QQAC_FC_CHRG_AMT_LABEL = cOMP_QQAC_FC_CHRG_AMT_LABEL;
	}


	public HtmlOutputText getCOMP_QQAC_FC_CHRG_AMT_MANDATORY() {
		return COMP_QQAC_FC_CHRG_AMT_MANDATORY;
	}


	public void setCOMP_QQAC_FC_CHRG_AMT_MANDATORY(
			HtmlOutputText cOMP_QQAC_FC_CHRG_AMT_MANDATORY) {
		COMP_QQAC_FC_CHRG_AMT_MANDATORY = cOMP_QQAC_FC_CHRG_AMT_MANDATORY;
	}


	public HtmlInputText getCOMP_QQAC_FC_CHRG_AMT() {
		return COMP_QQAC_FC_CHRG_AMT;
	}


	public void setCOMP_QQAC_FC_CHRG_AMT(HtmlInputText cOMP_QQAC_FC_CHRG_AMT) {
		COMP_QQAC_FC_CHRG_AMT = cOMP_QQAC_FC_CHRG_AMT;
	}


	public HtmlOutputLabel getCOMP_QQAT_COVER_CODE_LABEL() {
		return COMP_QQAT_COVER_CODE_LABEL;
	}


	public void setCOMP_QQAT_COVER_CODE_LABEL(
			HtmlOutputLabel cOMP_QQAT_COVER_CODE_LABEL) {
		COMP_QQAT_COVER_CODE_LABEL = cOMP_QQAT_COVER_CODE_LABEL;
	}


	public HtmlInputText getCOMP_QQAT_COVER_CODE() {
		return COMP_QQAT_COVER_CODE;
	}


	public void setCOMP_QQAT_COVER_CODE(HtmlInputText cOMP_QQAT_COVER_CODE) {
		COMP_QQAT_COVER_CODE = cOMP_QQAT_COVER_CODE;
	}


	public HtmlCommandButton getCOMP_UI_M_BUT_SHRINK() {
		return COMP_UI_M_BUT_SHRINK;
	}


	public void setCOMP_UI_M_BUT_SHRINK(HtmlCommandButton cOMP_UI_M_BUT_SHRINK) {
		COMP_UI_M_BUT_SHRINK = cOMP_UI_M_BUT_SHRINK;
	}


	public HtmlCommandButton getCOMP_UI_m_Quick_Brk_Add_debit() {
		return COMP_UI_m_Quick_Brk_Add_debit;
	}


	public void setCOMP_UI_m_Quick_Brk_Add_debit(
			HtmlCommandButton cOMP_UI_m_Quick_Brk_Add_debit) {
		COMP_UI_m_Quick_Brk_Add_debit = cOMP_UI_m_Quick_Brk_Add_debit;
	}

	/*Added by ameen  for ssp call id FALCONLIFE-1349309 on19-10-16*/
   private HtmlAjaxCommandButton COMP_UI_m_Quick_Brk_post_debit;
	
	public HtmlAjaxCommandButton getCOMP_UI_m_Quick_Brk_post_debit() {
		return COMP_UI_m_Quick_Brk_post_debit;
	}


	public void setCOMP_UI_m_Quick_Brk_post_debit(
			HtmlAjaxCommandButton cOMP_UI_m_Quick_Brk_post_debit) {
		COMP_UI_m_Quick_Brk_post_debit = cOMP_UI_m_Quick_Brk_post_debit;
	}
   /*end*/

	public HtmlCommandButton getCOMP_UI_m_Quick_Brk_Add_charge() {
		return COMP_UI_m_Quick_Brk_Add_charge;
	}


	public void setCOMP_UI_m_Quick_Brk_Add_charge(
			HtmlCommandButton cOMP_UI_m_Quick_Brk_Add_charge) {
		COMP_UI_m_Quick_Brk_Add_charge = cOMP_UI_m_Quick_Brk_Add_charge;
	}

	/*Added by ameen  for ssp call id FALCONLIFE-1349309 on19-10-16*/
   private HtmlAjaxCommandButton COMP_UI_m_Quick_Brk_post_cover;
	
	public HtmlAjaxCommandButton getCOMP_UI_m_Quick_Brk_post_cover() {
		return COMP_UI_m_Quick_Brk_post_cover;
	}


	public void setCOMP_UI_m_Quick_Brk_post_cover(
			HtmlAjaxCommandButton cOMP_UI_m_Quick_Brk_post_cover) {
		COMP_UI_m_Quick_Brk_post_cover = cOMP_UI_m_Quick_Brk_post_cover;
	}
   private HtmlAjaxCommandButton COMP_UI_m_Quick_Brk_post_charge;
	
	public HtmlAjaxCommandButton getCOMP_UI_m_Quick_Brk_post_charge() {
		return COMP_UI_m_Quick_Brk_post_charge;
	}


	public void setCOMP_UI_m_Quick_Brk_post_charge(
			HtmlAjaxCommandButton cOMP_UI_m_Quick_Brk_post_charge) {
		COMP_UI_m_Quick_Brk_post_charge = cOMP_UI_m_Quick_Brk_post_charge;
	}
	/*end*/

	public HtmlCommandButton getCOMP_UI_m_Quick_Brk_Add_cover() {
		return COMP_UI_m_Quick_Brk_Add_cover;
	}


	public void setCOMP_UI_m_Quick_Brk_Add_cover(
			HtmlCommandButton cOMP_UI_m_Quick_Brk_Add_cover) {
		COMP_UI_m_Quick_Brk_Add_cover = cOMP_UI_m_Quick_Brk_Add_cover;
	}

	/*END*/


	public List<SelectItem> getListPDL_DISC_LOAD_TYPE() {
		return listPDL_DISC_LOAD_TYPE;
	}


	public void setListPDL_DISC_LOAD_TYPE(List<SelectItem> listPDL_DISC_LOAD_TYPE) {
		this.listPDL_DISC_LOAD_TYPE = listPDL_DISC_LOAD_TYPE;
	}


	public void setListQQOT_MODE_OF_PYMT(List<SelectItem> listQQOT_MODE_OF_PYMT) {
		this.listQQOT_MODE_OF_PYMT = listQQOT_MODE_OF_PYMT;
	}


	public List<SelectItem> getListQUOT_CUST_GENDER() {
		return listQUOT_CUST_GENDER;
	}


	public void setListQUOT_CUST_GENDER(List<SelectItem> listQUOT_CUST_GENDER) {
		this.listQUOT_CUST_GENDER = listQUOT_CUST_GENDER;
	}


	public HtmlOutputLabel getCOMP_QUOT_CUST_LAST_NAME_LABEL() {
		return COMP_QUOT_CUST_LAST_NAME_LABEL;
	}

	public void setCOMP_QUOT_CUST_LAST_NAME_LABEL(
			HtmlOutputLabel cOMP_QUOT_CUST_LAST_NAME_LABEL) {
		COMP_QUOT_CUST_LAST_NAME_LABEL = cOMP_QUOT_CUST_LAST_NAME_LABEL;
	}

	public HtmlInputText getCOMP_QUOT_CUST_LAST_NAME() {
		return COMP_QUOT_CUST_LAST_NAME;
	}

	public void setCOMP_QUOT_CUST_LAST_NAME(HtmlInputText cOMP_QUOT_CUST_LAST_NAME) {
		COMP_QUOT_CUST_LAST_NAME = cOMP_QUOT_CUST_LAST_NAME;
	}

	public HtmlOutputLabel getCOMP_QQOT_ASSR_CODE_LABEL() {
		return COMP_QQOT_ASSR_CODE_LABEL;
	}

	public void setCOMP_QQOT_ASSR_CODE_LABEL(
			HtmlOutputLabel cOMP_QQOT_ASSR_CODE_LABEL) {
		COMP_QQOT_ASSR_CODE_LABEL = cOMP_QQOT_ASSR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_QQOT_ASSR_CODE() {
		return COMP_QQOT_ASSR_CODE;
	}

	public void setCOMP_QQOT_ASSR_CODE(HtmlInputText cOMP_QQOT_ASSR_CODE) {
		COMP_QQOT_ASSR_CODE = cOMP_QQOT_ASSR_CODE;
	}


	public HtmlCommandButton getCOMP_Quick_DELETE_COVER() {
		return COMP_Quick_DELETE_COVER;
	}


	public void setCOMP_Quick_DELETE_COVER(HtmlCommandButton cOMP_Quick_DELETE_COVER) {
		COMP_Quick_DELETE_COVER = cOMP_Quick_DELETE_COVER;
	}


	public HtmlCommandButton getCOMP_Quick_DELETE_DEBIT() {
		return COMP_Quick_DELETE_DEBIT;
	}


	public void setCOMP_Quick_DELETE_DEBIT(HtmlCommandButton cOMP_Quick_DELETE_DEBIT) {
		COMP_Quick_DELETE_DEBIT = cOMP_Quick_DELETE_DEBIT;
	}


	public HtmlCommandButton getCOMP_Quick_DELETE_CHARGE() {
		return COMP_Quick_DELETE_CHARGE;
	}


	public void setCOMP_Quick_DELETE_CHARGE(
			HtmlCommandButton cOMP_Quick_DELETE_CHARGE) {
		COMP_Quick_DELETE_CHARGE = cOMP_Quick_DELETE_CHARGE;
	}



	public HtmlInputText getCOMP_QQAD_ASSURED_NAME() {
		return COMP_QQAD_ASSURED_NAME;
	}


	public void setCOMP_QQAD_ASSURED_NAME(HtmlInputText cOMP_QQAD_ASSURED_NAME) {
		COMP_QQAD_ASSURED_NAME = cOMP_QQAD_ASSURED_NAME;
	}


	public HtmlInputText getCOMP_QQOT_HEIGHT() {
		return COMP_QQOT_HEIGHT;
	}

	public void setCOMP_QQOT_HEIGHT(HtmlInputText cOMP_QQOT_HEIGHT) {
		COMP_QQOT_HEIGHT = cOMP_QQOT_HEIGHT;
	}

	public HtmlOutputLabel getCOMP_QQOT_HEIGHT_LABEL() {
		return COMP_QQOT_HEIGHT_LABEL;
	}

	public void setCOMP_QQOT_HEIGHT_LABEL(HtmlOutputLabel cOMP_QQOT_HEIGHT_LABEL) {
		COMP_QQOT_HEIGHT_LABEL = cOMP_QQOT_HEIGHT_LABEL;
	}

	public HtmlInputText getCOMP_QQOT_WEIGHT() {
		return COMP_QQOT_WEIGHT;
	}

	public void setCOMP_QQOT_WEIGHT(HtmlInputText cOMP_QQOT_WEIGHT) {
		COMP_QQOT_WEIGHT = cOMP_QQOT_WEIGHT;
	}

	public HtmlOutputLabel getCOMP_QQOT_WEIGHT_LABEL() {
		return COMP_QQOT_WEIGHT_LABEL;
	}

	public void setCOMP_QQOT_WEIGHT_LABEL(HtmlOutputLabel cOMP_QQOT_WEIGHT_LABEL) {
		COMP_QQOT_WEIGHT_LABEL = cOMP_QQOT_WEIGHT_LABEL;
	}

	public HtmlInputText getCOMP_QQOT_BMI() {
		return COMP_QQOT_BMI;
	}

	public void setCOMP_QQOT_BMI(HtmlInputText cOMP_QQOT_BMI) {
		COMP_QQOT_BMI = cOMP_QQOT_BMI;
	}

	public HtmlOutputLabel getCOMP_QQOT_BMI_Lable() {
		return COMP_QQOT_BMI_Lable;
	}

	public void setCOMP_QQOT_BMI_Lable(HtmlOutputLabel cOMP_QQOT_BMI_Lable) {
		COMP_QQOT_BMI_Lable = cOMP_QQOT_BMI_Lable;
	}

	public HtmlInputText getCOMP_QQOT_ADDRESS() {
		return COMP_QQOT_ADDRESS;
	}

	public void setCOMP_QQOT_ADDRESS(HtmlInputText cOMP_QQOT_ADDRESS) {
		COMP_QQOT_ADDRESS = cOMP_QQOT_ADDRESS;
	}

	public HtmlOutputLabel getCOMP_QQOT_ADDRESS_LABLE() {
		return COMP_QQOT_ADDRESS_LABLE;
	}

	public void setCOMP_QQOT_ADDRESS_LABLE(HtmlOutputLabel cOMP_QQOT_ADDRESS_LABLE) {
		COMP_QQOT_ADDRESS_LABLE = cOMP_QQOT_ADDRESS_LABLE;
	}

	public void setCOMP_QUOT_CUST_MORE_INFO(
			HtmlCommandButton cOMP_QUOT_CUST_MORE_INFO) {
		COMP_QUOT_CUST_MORE_INFO = cOMP_QUOT_CUST_MORE_INFO;
	}

	/*	END*/


	/*	BAnk detail getter setter*/

	public HtmlSelectOneMenu getCOMP_QQOT_LOAN() {
		return COMP_QQOT_LOAN;
	}

	public void setCOMP_QQOT_LOAN(HtmlSelectOneMenu cOMP_QQOT_LOAN) {
		COMP_QQOT_LOAN = cOMP_QQOT_LOAN;
	}

	public HtmlOutputLabel getCOMP_QQOT_LOAN_LABLE() {
		return COMP_QQOT_LOAN_LABLE;
	}

	public void setCOMP_QQOT_LOAN_LABLE(HtmlOutputLabel cOMP_QQOT_LOAN_LABLE) {
		COMP_QQOT_LOAN_LABLE = cOMP_QQOT_LOAN_LABLE;
	}

	public HtmlOutputLabel getCOMP_QUOT_BANK_CODE_LABLE() {
		return COMP_QUOT_BANK_CODE_LABLE;
	}

	public void setCOMP_QUOT_BANK_CODE_LABLE(
			HtmlOutputLabel cOMP_QUOT_BANK_CODE_LABLE) {
		COMP_QUOT_BANK_CODE_LABLE = cOMP_QUOT_BANK_CODE_LABLE;
	}

	public HtmlInputText getCOMP_QUOT_BANK_CODE() {
		return COMP_QUOT_BANK_CODE;
	}

	public void setCOMP_QUOT_BANK_CODE(HtmlInputText cOMP_QUOT_BANK_CODE) {
		COMP_QUOT_BANK_CODE = cOMP_QUOT_BANK_CODE;
	}

	public HtmlOutputLabel getCOMP_QUOT_BANK_DIVN_LABLE() {
		return COMP_QUOT_BANK_DIVN_LABLE;
	}

	public void setCOMP_QUOT_BANK_DIVN_LABLE(
			HtmlOutputLabel cOMP_QUOT_BANK_DIVN_LABLE) {
		COMP_QUOT_BANK_DIVN_LABLE = cOMP_QUOT_BANK_DIVN_LABLE;
	}

	public HtmlInputText getCOMP_QUOT_BANK_DIVN() {
		return COMP_QUOT_BANK_DIVN;
	}

	public void setCOMP_QUOT_BANK_DIVN(HtmlInputText cOMP_QUOT_BANK_DIVN) {
		COMP_QUOT_BANK_DIVN = cOMP_QUOT_BANK_DIVN;
	}

	public HtmlOutputLabel getCOMP_QUOT_BANK_ACNT_LABLE() {
		return COMP_QUOT_BANK_ACNT_LABLE;
	}

	public void setCOMP_QUOT_BANK_ACNT_LABLE(HtmlOutputLabel cOMP_QUOT_BANK_ACNT_LABLE) {
		COMP_QUOT_BANK_ACNT_LABLE = cOMP_QUOT_BANK_ACNT_LABLE;
	}

	public HtmlInputText getCOMP_QUOT_BANK_ACNT() {
		return COMP_QUOT_BANK_ACNT;
	}

	public void setCOMP_QUOT_BANK_ACNT(HtmlInputText cOMP_QUOT_BANK_ACNT) {
		COMP_QUOT_BANK_ACNT = cOMP_QUOT_BANK_ACNT;
	}

	/*END*/


	/*Commission code*/

	public HtmlOutputLabel getCOMP_QUOT_SO_CODE_LABLE() {
		return COMP_QUOT_SO_CODE_LABLE;
	}

	public void setCOMP_QUOT_SO_CODE_LABLE(HtmlOutputLabel cOMP_QUOT_SO_CODE_LABLE) {
		COMP_QUOT_SO_CODE_LABLE = cOMP_QUOT_SO_CODE_LABLE;
	}

	public HtmlInputText getCOMP_QUOT_SO_CODE() {
		return COMP_QUOT_SO_CODE;
	}

	public void setCOMP_QUOT_SO_CODE(HtmlInputText cOMP_QUOT_SO_CODE) {
		COMP_QUOT_SO_CODE = cOMP_QUOT_SO_CODE;
	}

	public HtmlOutputLabel getCOMP_QUOT_SM_CODE_LABLE() {
		return COMP_QUOT_SM_CODE_LABLE;
	}

	public void setCOMP_QUOT_SM_CODE_LABLE(HtmlOutputLabel cOMP_QUOT_SM_CODE_LABLE) {
		COMP_QUOT_SM_CODE_LABLE = cOMP_QUOT_SM_CODE_LABLE;
	}

	public HtmlInputText getCOMP_QUOT_SM_CODE() {
		return COMP_QUOT_SM_CODE;
	}

	public void setCOMP_QUOT_SM_CODE(HtmlInputText cOMP_QUOT_SM_CODE) {
		COMP_QUOT_SM_CODE = cOMP_QUOT_SM_CODE;
	}

	public HtmlOutputLabel getCOMP_QUOT_AGENT_COMM_RATE_LABLE() {
		return COMP_QUOT_AGENT_COMM_RATE_LABLE;
	}

	public void setCOMP_QUOT_AGENT_COMM_RATE_LABLE(
			HtmlOutputLabel cOMP_QUOT_AGENT_COMM_RATE_LABLE) {
		COMP_QUOT_AGENT_COMM_RATE_LABLE = cOMP_QUOT_AGENT_COMM_RATE_LABLE;
	}

	public HtmlInputText getCOMP_QUOT_AGENT_COMM_RATE() {
		return COMP_QUOT_AGENT_COMM_RATE;
	}

	public void setCOMP_QUOT_AGENT_COMM_RATE(HtmlInputText cOMP_QUOT_AGENT_COMM_RATE) {
		COMP_QUOT_AGENT_COMM_RATE = cOMP_QUOT_AGENT_COMM_RATE;
	}

	public HtmlOutputLabel getCOMP_QUOT_AGENT_COMM_VALUE_LABLE() {
		return COMP_QUOT_AGENT_COMM_VALUE_LABLE;
	}

	public void setCOMP_QUOT_AGENT_COMM_VALUE_LABLE(
			HtmlOutputLabel cOMP_QUOT_AGENT_COMM_VALUE_LABLE) {
		COMP_QUOT_AGENT_COMM_VALUE_LABLE = cOMP_QUOT_AGENT_COMM_VALUE_LABLE;
	}

	public HtmlInputText getCOMP_QUOT_AGENT_COMM_VALUE() {
		return COMP_QUOT_AGENT_COMM_VALUE;
	}

	public void setCOMP_QUOT_AGENT_COMM_VALUE(
			HtmlInputText cOMP_QUOT_AGENT_COMM_VALUE) {
		COMP_QUOT_AGENT_COMM_VALUE = cOMP_QUOT_AGENT_COMM_VALUE;
	}



	/*END*/


	public HtmlOutputLabel getCOMP_QQOT_FREQUENCY_LABLE() {
		return COMP_QQOT_FREQUENCY_LABLE;
	}

	public void setCOMP_QQOT_FREQUENCY_LABLE(
			HtmlOutputLabel cOMP_QQOT_FREQUENCY_LABLE) {
		COMP_QQOT_FREQUENCY_LABLE = cOMP_QQOT_FREQUENCY_LABLE;
	}

	public HtmlSelectOneMenu getCOMP_QQOT_FREQUENCY() {
		return COMP_QQOT_FREQUENCY;
	}

	public void setCOMP_QQOT_FREQUENCY(HtmlSelectOneMenu cOMP_QQOT_FREQUENCY) {
		COMP_QQOT_FREQUENCY = cOMP_QQOT_FREQUENCY;
	}


	public HtmlOutputLabel getCOMP_QQOT_GENDER_LABLE() {
		return COMP_QQOT_GENDER_LABLE;
	}

	public void setCOMP_QQOT_GENDER_LABLE(HtmlOutputLabel cOMP_QQOT_GENDER_LABLE) {
		COMP_QQOT_GENDER_LABLE = cOMP_QQOT_GENDER_LABLE;
	}

	public HtmlSelectOneMenu getCOMP_QQOT_GENDER() {
		return COMP_QQOT_GENDER;
	}

	public void setCOMP_QQOT_GENDER(HtmlSelectOneMenu cOMP_QQOT_GENDER) {
		COMP_QQOT_GENDER = cOMP_QQOT_GENDER;
	}

	public HtmlOutputLabel getCOMP_QQOT_AGE_LABEL() {
		return COMP_QQOT_AGE_LABEL;
	}

	public HtmlInputText getCOMP_ADD_QQAC_RATE() {
		return COMP_ADD_QQAC_RATE;
	}


	public void setCOMP_ADD_QQAC_RATE(HtmlInputText cOMP_ADD_QQAC_RATE) {
		COMP_ADD_QQAC_RATE = cOMP_ADD_QQAC_RATE;
	}



	public HtmlOutputLabel getCOMP_ADD_QQAC_RATE_LABEL() {
		return COMP_ADD_QQAC_RATE_LABEL;
	}


	public void setCOMP_ADD_QQAC_RATE_LABEL(HtmlOutputLabel cOMP_ADD_QQAC_RATE_LABEL) {
		COMP_ADD_QQAC_RATE_LABEL = cOMP_ADD_QQAC_RATE_LABEL;
	}


	public HtmlOutputLabel getCOMP_ADD_QQAC_RATE_PER_LABEL() {
		return COMP_ADD_QQAC_RATE_PER_LABEL;
	}


	public void setCOMP_ADD_QQAC_RATE_PER_LABEL(
			HtmlOutputLabel cOMP_ADD_QQAC_RATE_PER_LABEL) {
		COMP_ADD_QQAC_RATE_PER_LABEL = cOMP_ADD_QQAC_RATE_PER_LABEL;
	}


	public HtmlOutputText getCOMP_QQAT_COVER_RATE_MANDATORY() {
		return COMP_QQAT_COVER_RATE_MANDATORY;
	}


	public void setCOMP_QQAT_COVER_RATE_MANDATORY(
			HtmlOutputText cOMP_QQAT_COVER_RATE_MANDATORY) {
		COMP_QQAT_COVER_RATE_MANDATORY = cOMP_QQAT_COVER_RATE_MANDATORY;
	}


	public HtmlOutputText getCOMP_QQAT_COVER_RATE_PER_MANDATORY() {
		return COMP_QQAT_COVER_RATE_PER_MANDATORY;
	}


	public void setCOMP_QQAT_COVER_RATE_PER_MANDATORY(
			HtmlOutputText cOMP_QQAT_COVER_RATE_PER_MANDATORY) {
		COMP_QQAT_COVER_RATE_PER_MANDATORY = cOMP_QQAT_COVER_RATE_PER_MANDATORY;
	}


	public void setCOMP_QQOT_AGE_LABEL(HtmlOutputLabel cOMP_QQOT_AGE_LABEL) {
		COMP_QQOT_AGE_LABEL = cOMP_QQOT_AGE_LABEL;
	}

	public HtmlInputText getCOMP_QQOT_AGE() {
		return COMP_QQOT_AGE;
	}

	public void setCOMP_QQOT_AGE(HtmlInputText cOMP_QQOT_AGE) {
		COMP_QQOT_AGE = cOMP_QQOT_AGE;
	}










	public List<SelectItem> getListPDL_APPLIED_ON() {
		return listPDL_APPLIED_ON;
	}


	public void setListPDL_APPLIED_ON(List<SelectItem> listPDL_APPLIED_ON) {
		this.listPDL_APPLIED_ON = listPDL_APPLIED_ON;
	}


	public HtmlOutputText getCOMP_ADD_QQDL_APPLIED_ON_MANDATORY() {
		return COMP_ADD_QQDL_APPLIED_ON_MANDATORY;
	}


	public void setCOMP_ADD_QQDL_APPLIED_ON_MANDATORY(
			HtmlOutputText cOMP_ADD_QQDL_APPLIED_ON_MANDATORY) {
		COMP_ADD_QQDL_APPLIED_ON_MANDATORY = cOMP_ADD_QQDL_APPLIED_ON_MANDATORY;
	}


	public HtmlOutputText getCOMP_ADD_QQDL_RATE_MANDATORY() {
		return COMP_ADD_QQDL_RATE_MANDATORY;
	}


	public void setCOMP_ADD_QQDL_RATE_MANDATORY(
			HtmlOutputText cOMP_ADD_QQDL_RATE_MANDATORY) {
		COMP_ADD_QQDL_RATE_MANDATORY = cOMP_ADD_QQDL_RATE_MANDATORY;
	}


	public HtmlOutputLabel getCOMP_ADD_QQDL_APPLIED_ON_LABEL() {
		return COMP_ADD_QQDL_APPLIED_ON_LABEL;
	}


	public void setCOMP_ADD_QQDL_APPLIED_ON_LABEL(
			HtmlOutputLabel cOMP_ADD_QQDL_APPLIED_ON_LABEL) {
		COMP_ADD_QQDL_APPLIED_ON_LABEL = cOMP_ADD_QQDL_APPLIED_ON_LABEL;
	}


	public HtmlOutputLabel getCOMP_ADD_QQDL_RATE_LABLE() {
		return COMP_ADD_QQDL_RATE_LABLE;
	}


	public void setCOMP_ADD_QQDL_RATE_LABLE(HtmlOutputLabel cOMP_ADD_QQDL_RATE_LABLE) {
		COMP_ADD_QQDL_RATE_LABLE = cOMP_ADD_QQDL_RATE_LABLE;
	}


	public HtmlSelectOneMenu getCOMP_ADD_QQDL_APPLIED_ON() {
		return COMP_ADD_QQDL_APPLIED_ON;
	}


	public void setCOMP_ADD_QQDL_APPLIED_ON(
			HtmlSelectOneMenu cOMP_ADD_QQDL_APPLIED_ON) {
		COMP_ADD_QQDL_APPLIED_ON = cOMP_ADD_QQDL_APPLIED_ON;
	}


	public HtmlInputText getCOMP_ADD_QQDL_RATE() {
		return COMP_ADD_QQDL_RATE;
	}


	public void setCOMP_ADD_QQDL_RATE(HtmlInputText cOMP_ADD_QQDL_RATE) {
		COMP_ADD_QQDL_RATE = cOMP_ADD_QQDL_RATE;
	}


	public HtmlOutputLabel getCOMP_ADD_QQDL_RATE_PER_LABEL() {
		return COMP_ADD_QQDL_RATE_PER_LABEL;
	}


	public void setCOMP_ADD_QQDL_RATE_PER_LABEL(
			HtmlOutputLabel cOMP_ADD_QQDL_RATE_PER_LABEL) {
		COMP_ADD_QQDL_RATE_PER_LABEL = cOMP_ADD_QQDL_RATE_PER_LABEL;
	}


	public HtmlOutputLabel getCOMP_QQAT_MEDICAL_YN_LABEL() {
		return COMP_QQAT_MEDICAL_YN_LABEL;
	}


	public void setCOMP_QQAT_MEDICAL_YN_LABEL(
			HtmlOutputLabel cOMP_QQAT_MEDICAL_YN_LABEL) {
		COMP_QQAT_MEDICAL_YN_LABEL = cOMP_QQAT_MEDICAL_YN_LABEL;
	}


	public HtmlSelectOneMenu getCOMP_QQAT_MEDICAL_YN() {
		return COMP_QQAT_MEDICAL_YN;
	}


	public void setCOMP_QQAT_MEDICAL_YN(HtmlSelectOneMenu cOMP_QQAT_MEDICAL_YN) {
		COMP_QQAT_MEDICAL_YN = cOMP_QQAT_MEDICAL_YN;
	}


	public HtmlOutputText getCOMP_QQDL_RATE_PER_MANDATORY() {
		return COMP_QQDL_RATE_PER_MANDATORY;
	}


	public void setCOMP_QQDL_RATE_PER_MANDATORY(
			HtmlOutputText cOMP_QQDL_RATE_PER_MANDATORY) {
		COMP_QQDL_RATE_PER_MANDATORY = cOMP_QQDL_RATE_PER_MANDATORY;
	}


	public HtmlInputText getCOMP_ADD_QQDL_RATE_PER() {
		return COMP_ADD_QQDL_RATE_PER;
	}


	public void setCOMP_ADD_QQDL_RATE_PER(HtmlInputText cOMP_ADD_QQDL_RATE_PER) {
		COMP_ADD_QQDL_RATE_PER = cOMP_ADD_QQDL_RATE_PER;
	}


	public HtmlOutputLabel getCOMP_ADD_QQDL_VALUE_LABEL() {
		return COMP_ADD_QQDL_VALUE_LABEL;
	}


	public void setCOMP_ADD_QQDL_VALUE_LABEL(
			HtmlOutputLabel cOMP_ADD_QQDL_VALUE_LABEL) {
		COMP_ADD_QQDL_VALUE_LABEL = cOMP_ADD_QQDL_VALUE_LABEL;
	}


	public HtmlOutputText getCOMP_ADD_QQDL_VALUE_MANDATORY() {
		return COMP_ADD_QQDL_VALUE_MANDATORY;
	}


	public void setCOMP_ADD_QQDL_VALUE_MANDATORY(
			HtmlOutputText cOMP_ADD_QQDL_VALUE_MANDATORY) {
		COMP_ADD_QQDL_VALUE_MANDATORY = cOMP_ADD_QQDL_VALUE_MANDATORY;
	}


	public HtmlInputText getCOMP_ADD_QQDL_VALUE() {
		return COMP_ADD_QQDL_VALUE;
	}


	public void setCOMP_ADD_QQDL_VALUE(HtmlInputText cOMP_ADD_QQDL_VALUE) {
		COMP_ADD_QQDL_VALUE = cOMP_ADD_QQDL_VALUE;
	}


	public HtmlOutputLabel getCOMP_QUOT_DOB_LABEL() {
		return COMP_QUOT_DOB_LABEL;
	}

	public void setCOMP_QUOT_DOB_LABEL(HtmlOutputLabel cOMP_QUOT_DOB_LABEL) {
		COMP_QUOT_DOB_LABEL = cOMP_QUOT_DOB_LABEL;
	}

	public HtmlCalendar getCOMP_QUOT_DOB() {
		return COMP_QUOT_DOB;
	}

	public void setCOMP_QUOT_DOB(HtmlCalendar cOMP_QUOT_DOB) {
		COMP_QUOT_DOB = cOMP_QUOT_DOB;
	}

	public HtmlOutputLabel getCOMP_QUOT_CUST_CODE_LABEL() {
		return COMP_QUOT_CUST_CODE_LABEL;
	}

	public void setCOMP_QUOT_CUST_CODE_LABEL(
			HtmlOutputLabel cOMP_QUOT_CUST_CODE_LABEL) {
		COMP_QUOT_CUST_CODE_LABEL = cOMP_QUOT_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_QUOT_CUST_CODE() {
		return COMP_QUOT_CUST_CODE;
	}

	public void setCOMP_QUOT_CUST_CODE(HtmlInputText cOMP_QUOT_CUST_CODE) {
		COMP_QUOT_CUST_CODE = cOMP_QUOT_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_QUOT_NEW_IC_LABEL() {
		return COMP_QUOT_NEW_IC_LABEL;
	}

	public void setCOMP_QUOT_NEW_IC_LABEL(HtmlOutputLabel cOMP_QUOT_NEW_IC_LABEL) {
		COMP_QUOT_NEW_IC_LABEL = cOMP_QUOT_NEW_IC_LABEL;
	}

	public HtmlInputText getCOMP_QUOT_NEW_IC() {
		return COMP_QUOT_NEW_IC;
	}

	public void setCOMP_QUOT_NEW_IC(HtmlInputText cOMP_QUOT_NEW_IC) {
		COMP_QUOT_NEW_IC = cOMP_QUOT_NEW_IC;
	}



	private HtmlCommandButton COMP_QUOT_CUST_INFO;
	public HtmlCommandButton getCOMP_QUOT_CUST_INFO() {
		return COMP_QUOT_CUST_INFO;
	}

	public void setCOMP_QUOT_CUST_INFO(HtmlCommandButton cOMP_QUOT_CUST_INFO) {
		COMP_QUOT_CUST_INFO = cOMP_QUOT_CUST_INFO;
	}

	private HtmlCommandButton COMP_QUOT_CUST_MORE;
	public HtmlCommandButton getCOMP_QUOT_CUST_MORE() {
		return COMP_QUOT_CUST_MORE;
	}

	public void setCOMP_QUOT_CUST_MORE(HtmlCommandButton cOMP_QUOT_CUST_MORE) {
		COMP_QUOT_CUST_MORE = cOMP_QUOT_CUST_MORE;
	}


	public HtmlSimpleTogglePanel getDebitoggle() {
		return debitoggle;
	}

	public void setDebitoggle(HtmlSimpleTogglePanel debitoggle) {
		this.debitoggle = debitoggle;
	}

	public HtmlSimpleTogglePanel getChargetoggle() {
		return chargetoggle;
	}

	public void setChargetoggle(HtmlSimpleTogglePanel chargetoggle) {
		this.chargetoggle = chargetoggle;
	}




	public HtmlSimpleTogglePanel getCovertoggle() {
		return covertoggle;
	}

	public void setCovertoggle(HtmlSimpleTogglePanel covertoggle) {
		this.covertoggle = covertoggle;
	}







	private HtmlCommandButton COMP_QUOT_MAIN;


	public HtmlCommandButton getCOMP_QUOT_MAIN() {
		return COMP_QUOT_MAIN;
	}

	public void setCOMP_QUOT_MAIN(HtmlCommandButton cOMP_QUOT_MAIN) {
		COMP_QUOT_MAIN = cOMP_QUOT_MAIN;
	}

	public HtmlCommandButton getCOMP_QUOT_CUST_MORE_INFO() {
		return COMP_QUOT_CUST_MORE_INFO;
	}


	/*	public PILM035_APAC_COMPOSITE_ACTION CoverAction;

	public PILT002_APAC_COMPOSITE_ACTION chargeAction;

	public PILT002_APAC_COMPOSITE_ACTION discAction;
	 */




	public List<PW_IL_QQUOT_APPL_COVER> getQuickdataList_PM_IL_PROD_APPL_COVER() {
		return quickdataList_PM_IL_PROD_APPL_COVER;
	}

	public void setQuickdataList_PM_IL_PROD_APPL_COVER(
			List<PW_IL_QQUOT_APPL_COVER> quickdataList_PM_IL_PROD_APPL_COVER) {
		this.quickdataList_PM_IL_PROD_APPL_COVER = quickdataList_PM_IL_PROD_APPL_COVER;
	}


	public List<PW_IL_QQUOT_APPL_CHARGE> getQuickdataList_PT_IL_POL_CHARGE() {
		return quickdataList_PT_IL_POL_CHARGE;
	}

	public void setQuickdataList_PT_IL_POL_CHARGE(
			List<PW_IL_QQUOT_APPL_CHARGE> quickdataList_PT_IL_POL_CHARGE) {
		this.quickdataList_PT_IL_POL_CHARGE = quickdataList_PT_IL_POL_CHARGE;
	}

	public List<PW_IL_QQUOT_DISC_LOAD> getQuickdataList_PT_IL_POL_DISC_LOAD() {
		return quickdataList_PT_IL_POL_DISC_LOAD;
	}

	public void setQuickdataList_PT_IL_POL_DISC_LOAD(
			List<PW_IL_QQUOT_DISC_LOAD> quickdataList_PT_IL_POL_DISC_LOAD) {
		this.quickdataList_PT_IL_POL_DISC_LOAD = quickdataList_PT_IL_POL_DISC_LOAD;
	}





	public UIData getDebitdataTable() {
		return debitdataTable;
	}

	public void setDebitdataTable(UIData debitdataTable) {
		this.debitdataTable = debitdataTable;
	}



	public UIData getCoverdataTable() {
		return coverdataTable;
	}

	public void setCoverdataTable(UIData coverdataTable) {
		this.coverdataTable = coverdataTable;
	}



	public UIData getChargedataTable() {
		return chargedataTable;
	}

	public void setChargedataTable(UIData chargedataTable) {
		this.chargedataTable = chargedataTable;
	}


	/*END*/



	/*	public String custMoreInfo() {


		return "PILT002_APAC_QE_PW_IL_CUST_INFO";


	}

public String custMoreInfo1() {


		return "PW_IL_QUICK_QUOTE";


	}*/

	public void validatorLOAN_TYPE(FacesContext context,
			UIComponent component, Object value) {
		try {

			System.out.println("************ ENTER THE VALIDATORSCHEDULE  METHOD ***********************");
			System.out.println("vALUE    : "+value.toString());
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_LOAN_TYPE((String)value);
			System.out.println("getQUOT_LOAN_TYPE()   : "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_LOAN_TYPE());


		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	private List<SelectItem> listQUOT_LOAN_TYPE = new ArrayList<SelectItem>();

	public List<SelectItem> getListQUOT_LOAN_TYPE() 
	{
		return listQUOT_LOAN_TYPE;
	}



	public void setListQUOT_LOAN_TYPE(List<SelectItem> listQUOT_LOAN_TYPE) {
		this.listQUOT_LOAN_TYPE = listQUOT_LOAN_TYPE;
	}





	public PM_CUSTOMER getPM_CUSTOMER_BEAN() {
		return PM_CUSTOMER_BEAN;
	}


	public void setPM_CUSTOMER_BEAN(PM_CUSTOMER pM_CUSTOMER_BEAN) {
		PM_CUSTOMER_BEAN = pM_CUSTOMER_BEAN;
	}


	public PW_IL_QUICK_QUOTE_ACTION() {

		initializeallcomponent();
		PW_IL_QUICK_QUOTE_BEAN = new PW_IL_QUICK_QUOTE();
		PM_CUSTOMER_BEAN= new PM_CUSTOMER();
		PW_IL_QUICK_QUOTE_DTLS_BEAN= new PW_IL_QQUOT_ASSURED_DTLS();
		PW_IL_QQUOT_DISC_LOAD_BEAN = new PW_IL_QQUOT_DISC_LOAD();
		PW_IL_QQUOT_APPL_COVER_BEAN = new PW_IL_QQUOT_APPL_COVER();
		PW_IL_QQUOT_APPL_CHARGE_BEAN = new PW_IL_QQUOT_APPL_CHARGE();

		PW_IL_QQUOT_BROK_HDR_BEAN= new PW_IL_QQUOT_BROK_HDR();
		PW_IL_QQUOT_BROK_DTL_BEAN= new PW_IL_QQUOT_BROK_DTL();
		helper = new PW_IL_QUICK_QUOTE_HELPER();
		delegate=new PW_IL_QUICK_QUOTE_DELEGATE(); 
		prepareListItems(); // for cus_TITLE

		PILM035_APAC_COMPOSITE_ACTION CoverAction =new PILM035_APAC_COMPOSITE_ACTION();
		try {
			PILT002_APAC_COMPOSITE_ACTION chargeAction =new PILT002_APAC_COMPOSITE_ACTION();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public PW_IL_QQUOT_BROK_HDR getPW_IL_QQUOT_BROK_HDR_BEAN() {
		return PW_IL_QQUOT_BROK_HDR_BEAN;
	}


	public void setPW_IL_QQUOT_BROK_HDR_BEAN(
			PW_IL_QQUOT_BROK_HDR pW_IL_QQUOT_BROK_HDR_BEAN) {
		PW_IL_QQUOT_BROK_HDR_BEAN = pW_IL_QQUOT_BROK_HDR_BEAN;
	}


	public PW_IL_QQUOT_BROK_DTL getPW_IL_QQUOT_BROK_DTL_BEAN() {
		return PW_IL_QQUOT_BROK_DTL_BEAN;
	}


	public void setPW_IL_QQUOT_BROK_DTL_BEAN(
			PW_IL_QQUOT_BROK_DTL pW_IL_QQUOT_BROK_DTL_BEAN) {
		PW_IL_QQUOT_BROK_DTL_BEAN = pW_IL_QQUOT_BROK_DTL_BEAN;
	}


	public PW_IL_QQUOT_DISC_LOAD getPW_IL_QQUOT_DISC_LOAD_BEAN() {
		return PW_IL_QQUOT_DISC_LOAD_BEAN;
	}


	public void setPW_IL_QQUOT_DISC_LOAD_BEAN(
			PW_IL_QQUOT_DISC_LOAD pW_IL_QQUOT_DISC_LOAD_BEAN) {
		PW_IL_QQUOT_DISC_LOAD_BEAN = pW_IL_QQUOT_DISC_LOAD_BEAN;
	}


	public PW_IL_QQUOT_APPL_COVER getPW_IL_QQUOT_APPL_COVER_BEAN() {
		return PW_IL_QQUOT_APPL_COVER_BEAN;
	}


	public void setPW_IL_QQUOT_APPL_COVER_BEAN(
			PW_IL_QQUOT_APPL_COVER pW_IL_QQUOT_APPL_COVER_BEAN) {
		PW_IL_QQUOT_APPL_COVER_BEAN = pW_IL_QQUOT_APPL_COVER_BEAN;
	}


	public PW_IL_QQUOT_APPL_CHARGE getPW_IL_QQUOT_APPL_CHARGE_BEAN() {
		return PW_IL_QQUOT_APPL_CHARGE_BEAN;
	}


	public void setPW_IL_QQUOT_APPL_CHARGE_BEAN(
			PW_IL_QQUOT_APPL_CHARGE pW_IL_QQUOT_APPL_CHARGE_BEAN) {
		PW_IL_QQUOT_APPL_CHARGE_BEAN = pW_IL_QQUOT_APPL_CHARGE_BEAN;
	}


	private void prepareListItems() {
		try {
			listQUOT_CUST_TITLE = (ArrayList<SelectItem>) ListItemUtil
					.getDropDownListValue(CommonUtils.getConnection(),
							"PM006_A_APAC", "PM_CUSTOMER",
							"PM_CUSTOMER.CUST_TITLE", "TITLE");

			setListQQOT_MODE_OF_PYMT(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_MODE_OF_PYMT", "PAYMODE"));

			listPDL_DISC_LOAD_TYPE = ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILT002_APAC", 
					"PT_IL_POL_DISC_LOAD", "PT_IL_POL_DISC_LOAD.PDL_DISC_LOAD_TYPE", "IL_DISCLOAD");

			listPDL_APPLIED_ON = ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILT002_APAC", 
					"PT_IL_POL_DISC_LOAD", "PT_IL_POL_DISC_LOAD.PDL_APPLIED_ON", "IL_APPLIEDON");

			listPOC_APPLIED_ON = ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILT002_APAC", 
					"PT_IL_POL_CHARGE", "PT_IL_POL_CHARGE.POC_APPLIED_ON", "IL_CHGAPPLON");

			listPOC_APPLY_PERIOD = ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILT002_APAC", 
					"PT_IL_POL_CHARGE", "PT_IL_POL_CHARGE.POC_APPLY_PERIOD", "IL_CHG_PRD");

			listQUOT_LOAN_TYPE = ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILT002_APAC_QE", 
					"PW_IL_QUICK_QUOTE", "PW_IL_QUICK_QUOTE.QUOT_LOAN_TYPE", "IL_LOAN_TYPE");

			listQUOT_CUST_GENDER = ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILT002_APAC_QE", 
					"PW_IL_QQUOT_ASSURED_DTLS", "PW_IL_QQUOT_ASSURED_DTLS.QQAD_CATG_CODE", "CTGCODE");

			listQQAT_MEDICAL_YN =ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_JOINT_LIFE_YN", "YESNO");




			getListQUOT_LOAN_TYPE();
		} catch (DBException e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("PREPARE_LIST_ITEMS", e.getMessage());
		}
	}

	public PW_IL_QUICK_QUOTE getPW_IL_QUICK_QUOTE_BEAN() {
		return PW_IL_QUICK_QUOTE_BEAN;
	}

	public void setPW_IL_QUICK_QUOTE_BEAN(
			PW_IL_QUICK_QUOTE pw_il_quick_quote_bean) {
		PW_IL_QUICK_QUOTE_BEAN = pw_il_quick_quote_bean;
	}

	public PW_IL_QUICK_QUOTE_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PW_IL_QUICK_QUOTE_HELPER helper) {
		this.helper = helper;
	}

	public PILT002_APAC_QE_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(
			PILT002_APAC_QE_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}


	public List<SelectItem> getListQQOT_MODE_OF_PYMT() {
		if (listQQOT_MODE_OF_PYMT.size() == 0) {
			listQQOT_MODE_OF_PYMT.clear();
			try {
				listQQOT_MODE_OF_PYMT = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listQQOT_MODE_OF_PYMT;
	}


	public HtmlOutputLabel getCOMP_QUOT_CUST_TITLE_LABEL() {
		return COMP_QUOT_CUST_TITLE_LABEL;
	}

	public void setCOMP_QUOT_CUST_TITLE_LABEL(
			HtmlOutputLabel comp_quot_cust_title_label) {
		COMP_QUOT_CUST_TITLE_LABEL = comp_quot_cust_title_label;
	}

	public HtmlSelectOneMenu getCOMP_QUOT_CUST_TITLE() {
		return COMP_QUOT_CUST_TITLE;
	}

	public void setCOMP_QUOT_CUST_TITLE(HtmlSelectOneMenu comp_quot_cust_title) {
		COMP_QUOT_CUST_TITLE = comp_quot_cust_title;
	}

	public ArrayList<SelectItem> getListQUOT_CUST_TITLE() {
		return listQUOT_CUST_TITLE;
	}


	public void setListQUOT_CUST_TITLE(ArrayList<SelectItem> listQUOT_CUST_TITLE) {
		this.listQUOT_CUST_TITLE = listQUOT_CUST_TITLE;
	}

	public HtmlOutputLabel getCOMP_QUOT_CUST_NAME_LABEL() {
		return COMP_QUOT_CUST_NAME_LABEL;
	}

	public void setCOMP_QUOT_CUST_NAME_LABEL(
			HtmlOutputLabel comp_quot_cust_name_label) {
		COMP_QUOT_CUST_NAME_LABEL = comp_quot_cust_name_label;
	}

	public HtmlInputText getCOMP_QUOT_CUST_NAME() {
		return COMP_QUOT_CUST_NAME;
	}

	public void setCOMP_QUOT_CUST_NAME(HtmlInputText comp_quot_cust_name) {
		COMP_QUOT_CUST_NAME = comp_quot_cust_name;
	}


	public ArrayList<SelectItem> getListQUOT_CUST_SALUTATION() {
		return listQUOT_CUST_TITLE;
	}

	public void setListQUOT_CUST_SALUTATION(
			ArrayList<SelectItem> listQUOT_CUST_SALUTATION) {
		this.listQUOT_CUST_TITLE = listQUOT_CUST_SALUTATION;
	}

	public HtmlOutputLabel getCOMP_QUOT_PROD_CODE_LABEL() {
		return COMP_QUOT_PROD_CODE_LABEL;
	}

	public void setCOMP_QUOT_PROD_CODE_LABEL(
			HtmlOutputLabel comp_quot_prod_code_label) {
		COMP_QUOT_PROD_CODE_LABEL = comp_quot_prod_code_label;
	}

	public HtmlInputText getCOMP_QUOT_PROD_CODE() {
		return COMP_QUOT_PROD_CODE;
	}

	public void setCOMP_QUOT_PROD_CODE(HtmlInputText comp_quot_prod_code) {
		COMP_QUOT_PROD_CODE = comp_quot_prod_code;
	}

	public HtmlOutputLabel getCOMP_QUOT_NO_LABEL() {
		return COMP_QUOT_NO_LABEL;
	}

	public void setCOMP_QUOT_NO_LABEL(HtmlOutputLabel comp_quot_no_label) {
		COMP_QUOT_NO_LABEL = comp_quot_no_label;
	}

	public HtmlInputText getCOMP_QUOT_NO() {
		return COMP_QUOT_NO;
	}

	public void setCOMP_QUOT_NO(HtmlInputText comp_quot_no) {
		COMP_QUOT_NO = comp_quot_no;
	}

	public HtmlOutputLabel getCOMP_QUOT_IDX_NO_LABEL() {
		return COMP_QUOT_IDX_NO_LABEL;
	}

	public void setCOMP_QUOT_IDX_NO_LABEL(HtmlOutputLabel comp_quot_idx_no_label) {
		COMP_QUOT_IDX_NO_LABEL = comp_quot_idx_no_label;
	}

	public HtmlInputText getCOMP_QUOT_IDX_NO() {
		return COMP_QUOT_IDX_NO;
	}

	public void setCOMP_QUOT_IDX_NO(HtmlInputText comp_quot_idx_no) {
		COMP_QUOT_IDX_NO = comp_quot_idx_no;
	}

	public HtmlOutputLabel getCOMP_QUOT_ISS_DT_LABEL() {
		return COMP_QUOT_ISS_DT_LABEL;
	}

	public void setCOMP_QUOT_ISS_DT_LABEL(HtmlOutputLabel comp_quot_iss_dt_label) {
		COMP_QUOT_ISS_DT_LABEL = comp_quot_iss_dt_label;
	}

	public HtmlCalendar getCOMP_QUOT_ISS_DT() {
		return COMP_QUOT_ISS_DT;
	}

	public void setCOMP_QUOT_ISS_DT(HtmlCalendar comp_quot_iss_dt) {
		COMP_QUOT_ISS_DT = comp_quot_iss_dt;
	}

	public HtmlOutputLabel getCOMP_QUOT_FM_DT_LABEL() {
		return COMP_QUOT_FM_DT_LABEL;
	}

	public void setCOMP_QUOT_FM_DT_LABEL(HtmlOutputLabel comp_quot_fm_dt_label) {
		COMP_QUOT_FM_DT_LABEL = comp_quot_fm_dt_label;
	}

	public HtmlCalendar getCOMP_QUOT_FM_DT() {
		return COMP_QUOT_FM_DT;
	}

	public void setCOMP_QUOT_FM_DT(HtmlCalendar comp_quot_fm_dt) {
		COMP_QUOT_FM_DT = comp_quot_fm_dt;
	}

	public HtmlOutputLabel getCOMP_QUOT_TO_DT_LABEL() {
		return COMP_QUOT_TO_DT_LABEL;
	}

	public void setCOMP_QUOT_TO_DT_LABEL(HtmlOutputLabel comp_quot_to_dt_label) {
		COMP_QUOT_TO_DT_LABEL = comp_quot_to_dt_label;
	}

	public HtmlCalendar getCOMP_QUOT_TO_DT() {
		return COMP_QUOT_TO_DT;
	}

	public void setCOMP_QUOT_TO_DT(HtmlCalendar comp_quot_to_dt) {
		COMP_QUOT_TO_DT = comp_quot_to_dt;
	}

	public HtmlOutputLabel getCOMP_QUOT_SRC_BUS_LABEL() {
		return COMP_QUOT_SRC_BUS_LABEL;
	}

	public void setCOMP_QUOT_SRC_BUS_LABEL(
			HtmlOutputLabel comp_quot_src_bus_label) {
		COMP_QUOT_SRC_BUS_LABEL = comp_quot_src_bus_label;
	}

	public HtmlInputText getCOMP_QUOT_SRC_BUS() {
		return COMP_QUOT_SRC_BUS;
	}

	public void setCOMP_QUOT_SRC_BUS(HtmlInputText comp_quot_src_bus) {
		COMP_QUOT_SRC_BUS = comp_quot_src_bus;
	}

	public HtmlOutputLabel getCOMP_QUOT_SRC_CODE_LABEL() {
		return COMP_QUOT_SRC_CODE_LABEL;
	}

	public void setCOMP_QUOT_SRC_CODE_LABEL(
			HtmlOutputLabel comp_quot_src_code_label) {
		COMP_QUOT_SRC_CODE_LABEL = comp_quot_src_code_label;
	}

	public HtmlInputText getCOMP_QUOT_SRC_CODE() {
		return COMP_QUOT_SRC_CODE;
	}

	public void setCOMP_QUOT_SRC_CODE(HtmlInputText comp_quot_src_code) {
		COMP_QUOT_SRC_CODE = comp_quot_src_code;
	}


	public HtmlOutputLabel getCOMP_QUOT_FC_SA_LABEL() {
		return COMP_QUOT_FC_SA_LABEL;
	}

	public void setCOMP_QUOT_FC_SA_LABEL(HtmlOutputLabel comp_quot_fc_sa_label) {
		COMP_QUOT_FC_SA_LABEL = comp_quot_fc_sa_label;
	}

	public HtmlInputText getCOMP_QUOT_FC_SA() {
		return COMP_QUOT_FC_SA;
	}

	public void setCOMP_QUOT_FC_SA(HtmlInputText comp_quot_fc_sa) {
		COMP_QUOT_FC_SA = comp_quot_fc_sa;
	}


	public void covertable(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			CresetSelectedRow();
			quickdataList_PM_IL_PROD_APPL_COVER=delegate.loadeCoverdatatable(compositeAction);
			if (quickdataList_PM_IL_PROD_APPL_COVER != null && quickdataList_PM_IL_PROD_APPL_COVER.size() > 1) {
				PW_IL_QQUOT_APPL_COVER Cover_BEAN = quickdataList_PM_IL_PROD_APPL_COVER
						.get(1);
				PW_IL_QQUOT_APPL_COVER_BEAN=Cover_BEAN;
				Cover_BEAN.setRowSelected(true);
				/*compositeAction.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
						.setPM_IL_PROD_APPL_LOAD_TARIFF_BEAN(
								PM_IL_PROD_APPL_LOAD_TARIFF_BEAN);*/
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void debittable(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction)
			throws Exception {
		CommonUtils.clearMaps(this);
		try {
			DresetSelectedRow();
			quickdataList_PT_IL_POL_DISC_LOAD=delegate.loadediscloaddatatable(compositeAction);
			if (quickdataList_PT_IL_POL_DISC_LOAD != null && quickdataList_PT_IL_POL_DISC_LOAD.size() > 0) {
				PW_IL_QQUOT_DISC_LOAD Tarrif_BEAN = quickdataList_PT_IL_POL_DISC_LOAD
						.get(0);
				PW_IL_QQUOT_DISC_LOAD_BEAN=Tarrif_BEAN;
				Tarrif_BEAN.setRowSelected(true);
				/*compositeAction.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
						.setPM_IL_PROD_APPL_LOAD_TARIFF_BEAN(
								PM_IL_PROD_APPL_LOAD_TARIFF_BEAN);*/
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}




	public void chargetable(PILT002_APAC_QE_COMPOSITE_ACTION compositeAction)
			throws Exception {
		CommonUtils.clearMaps(this);
		try {
			GresetSelectedRow();
			quickdataList_PT_IL_POL_CHARGE=delegate.loadEchargeloaddatatable(compositeAction);
			if (quickdataList_PT_IL_POL_CHARGE != null && quickdataList_PT_IL_POL_CHARGE.size() > 0) {
				PW_IL_QQUOT_APPL_CHARGE CHARGE_BEAN = quickdataList_PT_IL_POL_CHARGE
						.get(0);
				CHARGE_BEAN.setRowSelected(true);
				PW_IL_QQUOT_APPL_CHARGE_BEAN=CHARGE_BEAN;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}



	private void CresetSelectedRow() {

		Iterator<PW_IL_QQUOT_APPL_COVER> PM_IL_PROD_APPL_LOAD_TARIFF_ITR = quickdataList_PM_IL_PROD_APPL_COVER
				.iterator();
		while (PM_IL_PROD_APPL_LOAD_TARIFF_ITR.hasNext()) {
			PM_IL_PROD_APPL_LOAD_TARIFF_ITR.next().setRowSelected(false);
		}
	}


	private void DresetSelectedRow() {
		Iterator<PW_IL_QQUOT_DISC_LOAD> PM_IL_PROD_APPL_LOAD_TARIFF_ITR = quickdataList_PT_IL_POL_DISC_LOAD
				.iterator();
		while (PM_IL_PROD_APPL_LOAD_TARIFF_ITR.hasNext()) {
			PM_IL_PROD_APPL_LOAD_TARIFF_ITR.next().setRowSelected(false);
		}
	}


	private void GresetSelectedRow() {
		Iterator<PW_IL_QQUOT_APPL_CHARGE> PM_IL_PROD_APPL_LOAD_TARIFF_ITR = quickdataList_PT_IL_POL_CHARGE
				.iterator();
		while (PM_IL_PROD_APPL_LOAD_TARIFF_ITR.hasNext()) {
			PM_IL_PROD_APPL_LOAD_TARIFF_ITR.next().setRowSelected(false);
		}
	}


	// datatable cover

	public void coverdisplayRecords() {
		CommonUtils.clearMaps(this);
		try {
			//rendercovercomponent(true,false);
			covertoggle.setOpened(true);
			debitoggle.setOpened(true);
			chargetoggle.setOpened(true);
			CresetSelectedRow();

			Selectedcoverindex =coverdataTable.getRowIndex();
			/*if(Selectedcoverindex!=0){*/
			/*if(Selectedcoverindex==0){
				rendercovercomponent(false,true);
				resetcovercomponent();
			}else{*/
			PW_IL_QQUOT_APPL_COVER_BEAN = (PW_IL_QQUOT_APPL_COVER) coverdataTable.getRowData();

			System.out.println("sankar "+PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_EMR_RATE());
			resetcovercomponent();
			COMP_ADD_QQAC_EMR_RATE.resetValue();
			System.out.println("sankar "+PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_SYS_ID());
			Selectedcoverindex =coverdataTable.getRowIndex();

			PW_IL_QQUOT_APPL_COVER_BEAN.setRowSelected(true);

			/*}*/
			/*}
			else{
				throw new Exception("You cannot able to select this Record");
			}*/
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}



	public void QQAC_COVER_DELETEROW()
	{

		String message = null;
		try {

			if(Selectedcoverindex!=0){
				if(PW_IL_QQUOT_APPL_COVER_BEAN.getUI_M_QQAT_MAND_YN().equals("N")){
					if (isDELETE_ALLOWED()) {
						/*helper.keyDelRec(this, compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), 
							compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN(), 
							compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());*/

						new CRUDHandler().executeDelete(PW_IL_QQUOT_APPL_COVER_BEAN,
								CommonUtils.getConnection());
						CommonUtils.getConnection().commit();
						message = Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete");
						getWarningMap().put("deleteRow", message);
						getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								message);
						quickdataList_PM_IL_PROD_APPL_COVER.remove(PW_IL_QQUOT_APPL_COVER_BEAN);
						if (quickdataList_PM_IL_PROD_APPL_COVER.size() > 0) {

							PW_IL_QQUOT_APPL_COVER_BEAN = quickdataList_PM_IL_PROD_APPL_COVER
									.get(0);
							rendercovercomponent(false,true);
						} else if (quickdataList_PM_IL_PROD_APPL_COVER.size() == 0) {

							getErrorMap().clear();
							getWarningMap().clear();
							PW_IL_QQUOT_APPL_COVER_BEAN = new PW_IL_QQUOT_APPL_COVER();
							rendercovercomponent(false,true);
							covertoggle.setOpened(true);
							headertoggle.setOpened(false);
							customertoggle.setOpened(false);
							debitoggle.setOpened(true);
							chargetoggle.setOpened(true);
							CresetSelectedRow();

						}
						resetcovercomponent();
						PW_IL_QQUOT_APPL_COVER_BEAN.setRowSelected(true);
					} else {
						message = Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed");
						getErrorMap().put("deleteRow", message);
						getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
					}
				} else {
					throw new Exception("Mandatory Cover, Deletion is not allowed");
				}
			} else{
				throw new Exception("Mandatory Cover, Deletion is not allowed");
			}
		}catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}
	}





	public void COVER_ADDROW()
	{
		System.out.println("Add add cover");

		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if(Selectedcoverindex!=0){
				/*Added by Janani on 14.9.2016 for edit functionality*/


				PW_IL_QQUOT_APPL_COVER_BEAN = (PW_IL_QQUOT_APPL_COVER) coverdataTable.getRowData();

				/*end*/

				if("N".equalsIgnoreCase(PW_IL_QQUOT_APPL_COVER_BEAN.getUI_M_QQAT_MAND_YN())){
					setCFlag(true);
					if (isINSERT_ALLOWED()) {
						setEFlag(true);
						rendercovercomponent(true,false);
						covertoggle.setOpened(true);
						debitoggle.setOpened(true);
						chargetoggle.setOpened(true);
						headertoggle.setOpened(false);
						customertoggle.setOpened(false);
						CresetSelectedRow();

						/*Added by Janani on 14.9.2016 for edit functionality*/

						resetcovercomponent();

						/*end*/

					} else {
						
						
						
						getErrorMap().put("addRow",
								Messages.getString(
										PELConstants.pelMessagePropertiesPath,
										"errorPanel$message$insertnotallowed"));
						getErrorMap().put(
								PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								Messages.getString(
										PELConstants.pelMessagePropertiesPath,
										"errorPanel$message$insertnotallowed"));
						covertoggle.setOpened(true);
					}
				} else {
					throw new Exception("Mandatory Cover, Alteration is not allowed");
				}

			} else{
				throw new Exception("Mandatory Cover, Alteration is not allowed");
			}
			PW_IL_QQUOT_APPL_COVER_BEAN.setRowSelected(true);
			covertoggle.setOpened(true);
		}

		catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}


	public void COVER_createROW()
	{
		System.out.println("Add add cover");

		try {
			getErrorMap().clear();
			getWarningMap().clear();


			if (isINSERT_ALLOWED()) {

				PW_IL_QQUOT_APPL_COVER_BEAN = new PW_IL_QQUOT_APPL_COVER();
				Selectedcoverindex=1;
				//	hjkj
				/*helper.whenCreateRecord(PT_IL_POL_ADDL_COVER_BEAN, 
					compositeAction.getPT_IL_POL_COVER_GROUP_ACTION_BEAN().getPT_IL_POL_COVER_GROUP_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), 
						compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN(),compositeAction);*/
				PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_RATE_PER(1);		
				PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_RATE(0.0);
				PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_PREM_FC(0.0);
				PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_EMR_RATE(0.000);
				PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_CR_DT(new CommonUtils().getCurrentDate());
				PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
				PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_QQAD_SYS_ID(PW_IL_QUICK_QUOTE_DTLS_BEAN.getQQAD_SYS_ID());
				setEFlag(true);
				rendercovercomponent(true,false);
				resetcovercomponent();
				covertoggle.setOpened(true);
				debitoggle.setOpened(true);
				chargetoggle.setOpened(true);
				headertoggle.setOpened(false);
				customertoggle.setOpened(false);
				CresetSelectedRow();

			} else {
				getErrorMap().put("addRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				covertoggle.setOpened(true);
			}


		}
		catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}









	/*	public String Debit_InsertRecord()
	{
		System.out.println("ACHARGE_InsertRecordr");

		String message = null;
		try {
			if (PW_IL_QQUOT_DISC_LOAD_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.preInsert(PT_IL_POL_ADDL_COVER_BEAN, compositeAction
						.getPT_IL_POL_COVER_GROUP_ACTION_BEAN()
						.getPT_IL_POL_COVER_GROUP_BEAN(), compositeAction
						.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
						.getPT_IL_POL_ASSURED_DTLS_BEAN(), compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());

				helper.preLoadDebit(compositeAction);
				PW_IL_QQUOT_DISC_LOAD_BEAN.setQQDL_APPLIED_ON("S");

				PW_IL_QQUOT_DISC_LOAD_BEAN.setQQDL_RATE(1.0);
				PW_IL_QQUOT_DISC_LOAD_BEAN.setQQDL_RATE_PER(1.0);
				PW_IL_QQUOT_DISC_LOAD_BEAN.setQQDL_FC_DISC_LOAD_AMT(5.53);
				//PW_IL_QQUOT_APPL_CHARGE_BEAN.setQQAC_CR_DT(new CommonUtils().getCurrentDate());


				new CRUDHandler().executeInsert(PW_IL_QQUOT_DISC_LOAD_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				renderdebitcomponent(false,true);
				covertoggle.setOpened(false);
				debitoggle.setOpened(true);
				chargetoggle.setOpened(false);
				headertoggle.setOpened(false);
				customertoggle.setOpened(false);
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insert");
				quickdataList_PT_IL_POL_DISC_LOAD.add(PW_IL_QQUOT_DISC_LOAD_BEAN);
			} else if (PW_IL_QQUOT_DISC_LOAD_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.preUpdate(PW_IL_QQUOT_APPL_COVER_BEAN, compositeAction
						.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				new CRUDHandler().executeUpdate(PW_IL_QQUOT_DISC_LOAD_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				renderdebitcomponent(false,true);
				covertoggle.setOpened(false);
				debitoggle.setOpened(true);
				chargetoggle.setOpened(false);
				headertoggle.setOpened(false);
				customertoggle.setOpened(false);
				COMP_UI_m_Quick_Brk_post_debit.setRendered(false);
				COMP_UI_m_Quick_Brk_Add_debit.setRendered(true);
				debitoggle.setOpened(true);
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update");

			}
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("postRecord", message);
			PW_IL_QQUOT_DISC_LOAD_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("postRecord", exc.getMessage());
		}
		return "";



	}
	 */


	public String COVER_InsertRecord()
	{
		System.out.println("Add COVER_InsertRecord");


		String message = null;
		try {
			/*Added by ganesh on 05-04-2017 for clearing validations when click post in cover details */
			CommonUtils.clearMaps(this);
			/*end*/
System.out.println("Selectedcoverindex       "+Selectedcoverindex);
System.out.println("PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_PERIOD_COPY()       "+PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_PERIOD_COPY());
System.out.println("PW_IL_QUICK_QUOTE_BEAN.getQUOT_PERIOD()       "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_PERIOD());

			if(Selectedcoverindex!=0){

/*Modified by Ram on 05/11/2016 for term validation in Post entry level*/
				if(PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_PERIOD_COPY()>PW_IL_QUICK_QUOTE_BEAN.getQUOT_PERIOD()){
					
					/*End*/
					//String beanValue = PT_IL_POL_ADDL_COVER_BEAN.getPOAC_COVER_CODE();

					throw new Exception("Cover Term should be Lesser then or Equal to Quotation Term ");

				}else if(PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_FC_SA()>PW_IL_QUICK_QUOTE_BEAN.getQUOT_FC_SA()){
					PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_FC_SA(coversumass);
					COMP_ADD_QQAC_SUM_ASS.resetValue();
					rendercovercomponent(false,true);
					throw new Exception("Cover Sum Assured should be Lesser then or Equal to Quotation Sum Assured ");
				}
				/*Added by ganesh on 05-04-2017, handling the validation in cover details term and emr loading*/
				else if(PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_PERIOD()>PW_IL_QUICK_QUOTE_BEAN.getQUOT_PERIOD()){
					PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_PERIOD(0);
					COMP_ADD_QQAC_TERM.resetValue();
					rendercovercomponent(false,true);
					throw new Exception("Term should be Lesser then or Equal to Quotation Term ");
				}else if(PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_EMR_RATE()>PW_IL_QUICK_QUOTE_BEAN.getQUOT_EMR_RATE()){
					
					/*Commented by Ram on 07/04/2017 
					 * 
					 * PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_EMR_RATE(0.0);
					COMP_ADD_QQAC_EMR_RATE.resetValue();
					
					End
					*/
					
					rendercovercomponent(false,true);
					throw new Exception("EMR rate should be Lesser then or Equal to Quotation EMR rate loading ");
				}
				/*end*/

				else{

					/*Added by Ram on 03/11/2016 for ReviewSheet currency code & Term change issue issue*/
					 if(getChangeTerm() != null && !getChangeTerm().equals("Y"))
					setChangeTerm("N");
					for(int loop=0;loop<getQuickdataList_PM_IL_PROD_APPL_COVER().size();loop++)
					{
						PW_IL_QQUOT_APPL_COVER PW_IL_QQUOT_APPL_COVER_BEAN = getQuickdataList_PM_IL_PROD_APPL_COVER().get(loop);
						
						int period = PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_PERIOD();
						if(period != PW_IL_QUICK_QUOTE_BEAN.getQUOT_PERIOD())
						{
							setChangeTerm("Y");
							break;
						}
					}
					System.out.println("getChangeTerm       "+getChangeTerm());
					/*End*/
					
					PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_CR_DT(new CommonUtils().getCurrentDate());
					PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
					if (PW_IL_QQUOT_APPL_COVER_BEAN.getROWID() == null
							&& isINSERT_ALLOWED()) {

						helper.preLoadcover(compositeAction);

						/*helper.preInsert(PT_IL_POL_ADDL_COVER_BEAN, compositeAction
						.getPT_IL_POL_COVER_GROUP_ACTION_BEAN()
						.getPT_IL_POL_COVER_GROUP_BEAN(), compositeAction
						.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
						.getPT_IL_POL_ASSURED_DTLS_BEAN(), compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());*/
						//PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_COVER_CODE("sankar");
						//PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_SA_FC(10000.0);
						PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_LC_SA(PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_FC_SA());
						helper.IL_UNIQUE_ADDL_COVER_ASSR_CODE(
								CommonUtils.getProcedureValue(PW_IL_QUICK_QUOTE_DTLS_BEAN.getQQAD_SYS_ID()),
								CommonUtils.getProcedureValue(PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID()),
								PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_COVER_CODE());
						new CRUDHandler().executeInsert(PW_IL_QQUOT_APPL_COVER_BEAN,
								CommonUtils.getConnection());

						CommonUtils.getConnection().commit();
						rendercovercomponent(false,true);
						covertoggle.setOpened(true);
						debitoggle.setOpened(true);
						chargetoggle.setOpened(true);
						headertoggle.setOpened(false);
						customertoggle.setOpened(false);
						message = Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert");
						quickdataList_PM_IL_PROD_APPL_COVER.add(PW_IL_QQUOT_APPL_COVER_BEAN);
					} else if (PW_IL_QQUOT_APPL_COVER_BEAN.getROWID() != null
							&& isUPDATE_ALLOWED()) {
						/*helper.preUpdate(PW_IL_QQUOT_APPL_COVER_BEAN, compositeAction
						.getCTRL_ACTION_BEAN().getCTRL_BEAN());*/

						System.out.println("ENTER THE isUPDATE_ALLOWED  BLOCK Start   ********");
						System.out.println("Before QQAC_EFF_FM_DT     " +PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_EFF_FM_DT());
						System.out.println("Before QQAC_EFF_TO_DT     " +PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_EFF_TO_DT());

						PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_EFF_FM_DT(PW_IL_QUICK_QUOTE_BEAN.getQUOT_ISS_DT());
						PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_EFF_TO_DT(PW_IL_QUICK_QUOTE_BEAN.getQUOT_ISS_DT());

						System.out.println("After QQAC_EFF_FM_DT     " +PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_EFF_FM_DT());
						System.out.println("After QQAC_EFF_TO_DT     " +PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_EFF_TO_DT());

						System.out.println("ENTER THE isUPDATE_ALLOWED  BLOCK End  ********");
						PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_LC_SA(PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_FC_SA());
						PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_QQAD_SYS_ID(compositeAction
								.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_SYS_ID());
						new CRUDHandler().executeUpdate(PW_IL_QQUOT_APPL_COVER_BEAN,
								CommonUtils.getConnection());
						CommonUtils.getConnection().commit();
						rendercovercomponent(false,true);
						covertoggle.setOpened(true);
						debitoggle.setOpened(true);
						chargetoggle.setOpened(true);
						headertoggle.setOpened(false);
						customertoggle.setOpened(false);
						COMP_UI_m_Quick_Brk_post_cover.setRendered(false);
						/*
						 * 
						 * COMP_UI_m_Quick_Brk_Add_cover.setRendered(true);
						 * 
						 * */
						COMP_UI_m_Quick_Brk_Add_cover.setRendered(false);
						message = Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update");

					}
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							message);
					getWarningMap().put("postRecord", message);
					PW_IL_QQUOT_APPL_COVER_BEAN.setRowSelected(true);
				}}
			else{
				rendercovercomponent(false,true);
				throw new Exception("Mandatory Cover, Alteration is not allowed");
			}
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("postRecord", exc.getMessage());
		}

		return "";

	}

	//cover end

	//datatable for debit

	public void debitdisplayRecords() {
		CommonUtils.clearMaps(this);
		try {
			//renderdebitcomponent(true,false);
			covertoggle.setOpened(true);
			debitoggle.setOpened(true);
			chargetoggle.setOpened(true);
			DresetSelectedRow();
			PW_IL_QQUOT_DISC_LOAD_BEAN = (PW_IL_QQUOT_DISC_LOAD) debitdataTable.getRowData();

			if ("3".equals(PW_IL_QQUOT_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())
					|| "6".equals(PW_IL_QQUOT_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())
					|| "7".equals(PW_IL_QQUOT_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())
					|| "8".equals(PW_IL_QQUOT_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())
					|| "9".equals(PW_IL_QQUOT_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())
					|| "10".equals(PW_IL_QQUOT_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())) {
				COMP_QQDL_COVER_CODE.setDisabled(false);
				COMP_QQDL_COVER_CODE.setRequired(true);
				/*if (loadBean.getPDL_COVER_CODE() == null) {
					PDL_COVER_CODE(policyBean.getPOL_PLAN_CODE());
				}*/
			} else {
				COMP_QQDL_COVER_CODE.setDisabled(true);
			}



			PW_IL_QQUOT_DISC_LOAD_BEAN.setRowSelected(true);
			resetDiscountcomponent();


		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	public void Debit_create(){

		System.out.println("CHARGE_ADDROW");


		try {
			getErrorMap().clear();
			getWarningMap().clear();
			setDISC_LOADING_FLAG(true);
			if (isINSERT_ALLOWED()) {
				COMP_UI_m_Quick_Brk_post_debit.setRendered(true);
				PW_IL_QQUOT_DISC_LOAD_BEAN = new PW_IL_QQUOT_DISC_LOAD();
				PW_IL_QQUOT_DISC_LOAD_BEAN.setQQDL_DISC_LOAD_TYPE("D");
				PW_IL_QQUOT_DISC_LOAD_BEAN.setQQDL_RATE_PER(100);
				COMP_ADD_QQDL_RATE_PER.setDisabled(true);
				DresetSelectedRow();
				renderdebitcomponent(true,false);
				covertoggle.setOpened(true);
				debitoggle.setOpened(true);
				chargetoggle.setOpened(true);
				headertoggle.setOpened(false);
				customertoggle.setOpened(false);

			} else {
				getErrorMap().put("addRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}


	public void Debit_ADDROW()
	{
		System.out.println("CHARGE_ADDROW");


		try {

			getErrorMap().clear();
			getWarningMap().clear();
			setDISC_LOADING_FLAG(true);
			boolean isInsert = isINSERT_ALLOWED();
			System.out.println("isInsert             "+isInsert);

			/*Added by Janani on 14.9.2016 for edit functionality*/

			PW_IL_QQUOT_DISC_LOAD_BEAN = (PW_IL_QQUOT_DISC_LOAD) debitdataTable.getRowData();

			/*end*/

			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QQUOT_DISC_LOAD_BEAN().setQQDL_RATE_PER(100);
			COMP_ADD_QQDL_RATE_PER.setDisabled(true);
			if (isInsert) {
				COMP_UI_m_Quick_Brk_post_debit.setRendered(true);
				//PW_IL_QQUOT_DISC_LOAD_BEAN = new PW_IL_QQUOT_DISC_LOAD();
				/*helper.whenCreateRecord(PT_IL_POL_ADDL_COVER_BEAN, 
					compositeAction.getPT_IL_POL_COVER_GROUP_ACTION_BEAN().getPT_IL_POL_COVER_GROUP_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), 
						compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN(),compositeAction);*/



				if ("3".equals(PW_IL_QQUOT_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())
						|| "6".equals(PW_IL_QQUOT_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())
						|| "7".equals(PW_IL_QQUOT_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())
						|| "8".equals(PW_IL_QQUOT_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())
						|| "9".equals(PW_IL_QQUOT_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())
						|| "10".equals(PW_IL_QQUOT_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())) {
					COMP_QQDL_COVER_CODE.setDisabled(false);
					COMP_QQDL_COVER_CODE.setRequired(true);
					/*if (loadBean.getPDL_COVER_CODE() == null) {
						PDL_COVER_CODE(policyBean.getPOL_PLAN_CODE());
					}*/
				} else {
					COMP_QQDL_COVER_CODE.setDisabled(true);
				}



				DresetSelectedRow();
				renderdebitcomponent(true,false);
				covertoggle.setOpened(true);
				debitoggle.setOpened(true);
				chargetoggle.setOpened(true);
				headertoggle.setOpened(false);
				customertoggle.setOpened(false);

				/*Added by Janani on 14.9.2016 for edit functionality*/

				resetDiscountcomponent();

				/*end*/

			} else {
				getErrorMap().put("addRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}
			PW_IL_QQUOT_DISC_LOAD_BEAN.setRowSelected(true);
			covertoggle.setOpened(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}

	public void Debit_DELETEROW() {
		String message = null;
		try {
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PW_IL_QQUOT_DISC_LOAD_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"); 
				quickdataList_PT_IL_POL_DISC_LOAD.remove(PW_IL_QQUOT_DISC_LOAD_BEAN);
				if (quickdataList_PT_IL_POL_DISC_LOAD.size() > 0) {
					PW_IL_QQUOT_DISC_LOAD_BEAN = quickdataList_PT_IL_POL_DISC_LOAD.get(0);
					renderdebitcomponent(false,true);
				} else if (quickdataList_PT_IL_POL_DISC_LOAD.size() == 0) {

					PW_IL_QQUOT_DISC_LOAD_BEAN = new PW_IL_QQUOT_DISC_LOAD();
					DresetSelectedRow();
					renderdebitcomponent(false,true);
					covertoggle.setOpened(true);
					debitoggle.setOpened(true);
					chargetoggle.setOpened(true);
					headertoggle.setOpened(false);
					customertoggle.setOpened(false);
				}
				CommonUtils.getConnection().commit();
				resetDiscountcomponent();
				PW_IL_QQUOT_DISC_LOAD_BEAN.setRowSelected(true);
			} else {
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$deletenotallowed"); 
			}

			getWarningMap().put("deleteRow",message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}




	public String Debit_InsertRecord()
	{
		System.out.println("ACHARGE_InsertRecordr");
		setDISC_LOADING_FLAG(false);
		String message = null;
		try {
			if (PW_IL_QQUOT_DISC_LOAD_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {

				if(PW_IL_QQUOT_DISC_LOAD_BEAN.getQQDL_DISC_LOAD_CODE()==null){
					throw new Exception("Discount/Loading: Validation Error: Value is required.");
				}
				helper.preLoadDebit(compositeAction);

				new CRUDHandler().executeInsert(PW_IL_QQUOT_DISC_LOAD_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				renderdebitcomponent(false,true);
				covertoggle.setOpened(true);
				debitoggle.setOpened(true);
				chargetoggle.setOpened(true);
				headertoggle.setOpened(false);
				customertoggle.setOpened(false);
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insert");
				quickdataList_PT_IL_POL_DISC_LOAD.add(PW_IL_QQUOT_DISC_LOAD_BEAN);
			} else if (PW_IL_QQUOT_DISC_LOAD_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				if(PW_IL_QQUOT_DISC_LOAD_BEAN.getQQDL_DISC_LOAD_CODE()==null){
					throw new Exception("Discount/Loading: Validation Error: Value is required.");
				}
				new CRUDHandler().executeUpdate(PW_IL_QQUOT_DISC_LOAD_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				renderdebitcomponent(false,true);
				covertoggle.setOpened(true);
				debitoggle.setOpened(true);
				chargetoggle.setOpened(true);
				headertoggle.setOpened(false);
				customertoggle.setOpened(false);
				COMP_UI_m_Quick_Brk_post_debit.setRendered(false);

				/*
				 * 
				 * COMP_UI_m_Quick_Brk_Add_debit.setRendered(true);
				 * 
				 * */
				COMP_UI_m_Quick_Brk_Add_debit.setRendered(false);
				debitoggle.setOpened(true);
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update");

			}
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("postRecord", message);
			PW_IL_QQUOT_DISC_LOAD_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("postRecord", exc.getMessage());
		}
		return "";



	}









	public void chargedisplayRecords() {
		CommonUtils.clearMaps(this);
		try {
			//renderchargecomponent(true,false);
			covertoggle.setOpened(true);
			debitoggle.setOpened(true);
			chargetoggle.setOpened(true);
			GresetSelectedRow();
			PW_IL_QQUOT_APPL_CHARGE_BEAN = (PW_IL_QQUOT_APPL_CHARGE) chargedataTable.getRowData();

			PW_IL_QQUOT_APPL_CHARGE_BEAN.setRowSelected(true);
			resetchargecomponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}



	public void Charge_createROW(){

		System.out.println("CHARGE_ADDROW");


		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {
				COMP_UI_m_Quick_Brk_post_charge.setRendered(true);


				PW_IL_QQUOT_APPL_CHARGE_BEAN = new PW_IL_QQUOT_APPL_CHARGE();
				PW_IL_QQUOT_APPL_CHARGE_BEAN.setQQAC_CR_DT(new CommonUtils().getCurrentDate());
				PW_IL_QQUOT_APPL_CHARGE_BEAN.setQQAC_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
				PW_IL_QQUOT_APPL_CHARGE_BEAN.setQQAC_APPLIED_ON("2");
				GresetSelectedRow();
				renderchargecomponent(true,false);
				covertoggle.setOpened(true);
				debitoggle.setOpened(true);
				chargetoggle.setOpened(true);
				headertoggle.setOpened(false);
				customertoggle.setOpened(false);
			} else {
				getErrorMap().put("addRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				chargetoggle.setOpened(true);
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}
	}




	public void CHARGE_ADDROW()
	{
		System.out.println("CHARGE_ADDROW");


		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {

				/*Added by Janani on 14.9.2016 for edit functionality*/

				PW_IL_QQUOT_APPL_CHARGE_BEAN = (PW_IL_QQUOT_APPL_CHARGE) chargedataTable.getRowData();

				/*end*/

				COMP_UI_m_Quick_Brk_post_charge.setRendered(true);

				System.out.println("PW_IL_QQUOT_APPL_CHARGE_BEAN    "+PW_IL_QQUOT_APPL_CHARGE_BEAN.getQQAC_CHRG_CODE());
				/*	
				PW_IL_QQUOT_APPL_CHARGE_BEAN = new PW_IL_QQUOT_APPL_CHARGE();

				PW_IL_QQUOT_APPL_CHARGE_BEAN.setQQAC_CR_DT(new CommonUtils().getCurrentDate());
				PW_IL_QQUOT_APPL_CHARGE_BEAN.setQQAC_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			//	PW_IL_QQUOT_APPL_CHARGE_BEAN.setQQAC_RATE(0.0);
			//	PW_IL_QQUOT_APPL_CHARGE_BEAN.setQQAC_RATE_PER(0.0);
				PW_IL_QQUOT_APPL_CHARGE_BEAN.setQQAC_APPLIED_ON("2");
				 *//*helper.whenCreateRecord(PT_IL_POL_ADDL_COVER_BEAN, 
					compositeAction.getPT_IL_POL_COVER_GROUP_ACTION_BEAN().getPT_IL_POL_COVER_GROUP_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), 
						compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN(),compositeAction);*/
				GresetSelectedRow();
				renderchargecomponent(true,false);
				covertoggle.setOpened(true);
				debitoggle.setOpened(true);
				chargetoggle.setOpened(true);
				headertoggle.setOpened(false);
				customertoggle.setOpened(false);

				/*Added by Janani on 14.9.2016 for edit functionality*/

				resetchargecomponent();

				/*end*/

				//GresetSelectedRow();
			} else {
				getErrorMap().put("addRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				chargetoggle.setOpened(true);
			}
			PW_IL_QQUOT_APPL_CHARGE_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}


	}







	public void QQAC_CHARGE_DELETEROW()
	{

		String message = null;
		try {
			if (isDELETE_ALLOWED()) {


				/*helper.keyDelRec(this, compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), 
						compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN(), 
						compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());*/
				new CRUDHandler().executeDelete(PW_IL_QQUOT_APPL_CHARGE_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$delete");
				getWarningMap().put("deleteRow", message);
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
				quickdataList_PT_IL_POL_CHARGE.remove(PW_IL_QQUOT_APPL_CHARGE_BEAN);
				if (quickdataList_PT_IL_POL_CHARGE.size() > 0) {

					PW_IL_QQUOT_APPL_CHARGE_BEAN = quickdataList_PT_IL_POL_CHARGE
							.get(0);
					renderchargecomponent(false,true);
				} else if (quickdataList_PT_IL_POL_CHARGE.size() == 0) {
					getErrorMap().clear();
					getWarningMap().clear();
					renderchargecomponent(false,true);
					PW_IL_QQUOT_APPL_CHARGE_BEAN = new PW_IL_QQUOT_APPL_CHARGE();
					covertoggle.setOpened(true);
					debitoggle.setOpened(true);
					chargetoggle.setOpened(true);
					headertoggle.setOpened(false);
					customertoggle.setOpened(false);
					GresetSelectedRow();
				}
				resetcovercomponent();
				PW_IL_QQUOT_APPL_CHARGE_BEAN.setRowSelected(true);
			} else {
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$deletenotallowed");
				getErrorMap().put("deleteRow", message);
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			}
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}
	}



	public String CHARGE_InsertRecord()
	{
		System.out.println("ACHARGE_InsertRecordr");

		String message = null;
		try {



			if (PW_IL_QQUOT_APPL_CHARGE_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				/*helper.preInsert(PT_IL_POL_ADDL_COVER_BEAN, compositeAction
						.getPT_IL_POL_COVER_GROUP_ACTION_BEAN()
						.getPT_IL_POL_COVER_GROUP_BEAN(), compositeAction
						.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
						.getPT_IL_POL_ASSURED_DTLS_BEAN(), compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());*/

				/*	PW_IL_QQUOT_APPL_CHARGE_BEAN.setQQAC_APPLY_PERIOD("s");
				PW_IL_QQUOT_APPL_CHARGE_BEAN.setQQAC_FC_CHRG_AMT(10000.0);
				PW_IL_QQUOT_APPL_CHARGE_BEAN.setQQAC_APPLIED_ON("Y");
				PW_IL_QQUOT_APPL_CHARGE_BEAN.setQQAC_RATE(1.0);
				PW_IL_QQUOT_APPL_CHARGE_BEAN.setQQAC_RATE_PER(1.0);
				PW_IL_QQUOT_APPL_CHARGE_BEAN.setQQAC_FC_CHRG_AMT(5.53);*/

				helper.preLoadcharge(compositeAction);
				new CRUDHandler().executeInsert(PW_IL_QQUOT_APPL_CHARGE_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				renderchargecomponent(false,true);
				covertoggle.setOpened(true);
				debitoggle.setOpened(true);
				chargetoggle.setOpened(true);
				headertoggle.setOpened(false);
				customertoggle.setOpened(false);

				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insert");
				quickdataList_PT_IL_POL_CHARGE.add(PW_IL_QQUOT_APPL_CHARGE_BEAN);
			} else if (PW_IL_QQUOT_APPL_CHARGE_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				/*helper.preUpdate(PW_IL_QQUOT_APPL_COVER_BEAN, compositeAction
						.getCTRL_ACTION_BEAN().getCTRL_BEAN());*/
				new CRUDHandler().executeUpdate(PW_IL_QQUOT_APPL_CHARGE_BEAN,
						CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				renderchargecomponent(false,true);
				covertoggle.setOpened(true);
				debitoggle.setOpened(true);
				chargetoggle.setOpened(true);
				headertoggle.setOpened(false);
				customertoggle.setOpened(false);

				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update");

			}

			/*   Added By Dhinesh for Edit button disabled   */
			COMP_UI_m_Quick_Brk_Add_charge.setRendered(false);
			/*  End */


			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("postRecord", message);
			PW_IL_QQUOT_APPL_COVER_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("postRecord", exc.getMessage());
		}
		return "";



	}

	//charge end



	public void onload(PhaseEvent event) {
		try {

			
			/*if(isFormFlag()){
				//helper.executeQuery(compositeAction);
				setFormFlag(false);
			}*/
		
			if (isBlockFlag()) {
				
				if(CommonUtils.getGlobalObject("BACKFROM")!=null){
					if((boolean)CommonUtils.getGlobalObject("BACKFROM")==true){
						COMP_UI_M_BUT_EXPAND_LINK.setDisabled(false);
						COMP_UI_M_BUT_EXPAND_LINK.setRendered(true);
						CommonUtils.setGlobalObject("BACKFROM",false);
					}
					
					
				}
				
				
				/*added by janani for cursor issue ssp call id FALCONLIFE-1349309 on 19-10-16*/
				int hidden = -1;
				if(CommonUtils.getGlobalObject("hiddenvalue") != null)
				{
					hidden = (int) CommonUtils.getGlobalObject("hiddenvalue");
				}
							 
							
							System.out.println("hidden               :"+hidden);
				/*end*/
				
							/*Added by Ram on 17/11/2016 for Product Code validation*/
							ListItemUtil listitemutil = new ListItemUtil();
							getPRODUCT_LIST().clear();
							 setPRODUCT_LIST(listitemutil.P_CALL_LOV("PILT002_APAC",
										"PT_IL_POLICY", "POL_PROD_CODE", CommonUtils.getGlobalObject("GLOBAL.M_PARAM_2"), null, null, null,
										null, "%"));
							/*End*/ 
							
				helper.loadcurrency();
				System.out.println("BLOCKFLAG");
				if (PW_IL_QUICK_QUOTE_BEAN.getROWID() != null) {
					delegate.executeQuery(compositeAction);
					COMP_UI_M_BUT_EXPAND_LINK.setDisabled(false);
					
					System.out.println("getPW_IL_QUICK_QUOTE_BEAN().getQUOT_APPR_STS()       "+getPW_IL_QUICK_QUOTE_BEAN().getQUOT_APPR_STS());
					/*Added by Ram on 20/11/2016 for Report issues*/
					if(getPW_IL_QUICK_QUOTE_BEAN().getQUOT_APPR_STS() != null && getPW_IL_QUICK_QUOTE_BEAN().getQUOT_APPR_STS().equals("N"))
					{
						compositeAction.getPRINT_ACTION_BEAN().getCOMP_QQAT_PRINT().setDisabled(true);	
					}
					
					/*End*/
					
					//netpremium =helper.updateGrosspre(compositeAction);
					netpremium=0.0;
					netpremium=netpremium+delegate.calculatenetpremium(compositeAction);

					COMP_UI_M_BUT_APPROVAL.setDisabled(true);
					COMP_UI_M_CONV_POL.setDisabled(true);
					COMP_UI_M_MAKE_AMMENMENT.setDisabled(true);
					COMP_UI_M_CLC_PREMIUM.setDisabled(false);

					/*
					 * Commented By Dhinesh for apply common decimal convert method on 12.10.2016
					 * 
					 * PW_IL_QUICK_QUOTE_BEAN.setUI_NET_PREMIUM(helper.Decimal_Convert(Double.toString(netpremium)));*/
					
					PW_IL_QUICK_QUOTE_BEAN.setUI_NET_PREMIUM(CommonUtils.Decimal_Convert(Double.toString(netpremium)));
					
					if(PW_IL_QUICK_QUOTE_BEAN.getQUOT_SRC_BUS().equals("075")){
						if(Double.valueOf(PW_IL_QUICK_QUOTE_BEAN.getUI_NET_PREMIUM())>0.0){

							System.out.println("PW_IL_QQUOT_BROK_DTL_BEAN.getQQBD_RATE()           "+PW_IL_QQUOT_BROK_DTL_BEAN.getQQBD_RATE());
							System.out.println("PW_IL_QQUOT_BROK_DTL_BEAN.getQQBD_RATE_PER()           "+PW_IL_QQUOT_BROK_DTL_BEAN.getQQBD_RATE_PER());
							System.out.println("PW_IL_QQUOT_BROK_DTL_BEAN.getUI_NET_PREMIUM()           "+PW_IL_QUICK_QUOTE_BEAN.getUI_NET_PREMIUM());

							Double commision= 0.0;
							if(PW_IL_QQUOT_BROK_DTL_BEAN.getQQBD_RATE() != null && PW_IL_QQUOT_BROK_DTL_BEAN.getQQBD_RATE_PER() != null && PW_IL_QUICK_QUOTE_BEAN.getUI_NET_PREMIUM() != null)
							{
								commision = (PW_IL_QQUOT_BROK_DTL_BEAN.getQQBD_RATE()/PW_IL_QQUOT_BROK_DTL_BEAN.getQQBD_RATE_PER())*Double.valueOf(PW_IL_QUICK_QUOTE_BEAN.getUI_NET_PREMIUM());	
							}

							System.out.println("Commission :"+commision);
							COMP_UI_M_BUT_APPROVAL.setDisabled(false);
							/*Added by Ganesh on 11/04/2017*/
							COMP_UI_M_MAKE_DECLINE.setDisabled(false);
							/*End*/
							
							/*
							 * Commented By Dhinesh for apply common decimal convert method on 12.10.2016
							 * 
							 * String uicomm=delegate.Decimal_Convert(Double.toString(commision));*/
							
							String uicomm=CommonUtils.Decimal_Convert(Double.toString(commision));
							
							System.out.println("String Commission  :"+uicomm);
							//PW_IL_QUICK_QUOTE_BEAN.setQUOT_COMM_VALUE(commision);
							/*Added by Janani on 18.10.2016 for IC no length issue ssp call id FALCONLIFE-1344818
							int fieldLength = 0;
							int PS_VALUE= (int) CommonUtils.getGlobalObject("M_PS_VALUE");
							fieldLength = 	(int) CommonUtils.getGlobalObject("FIELD_LENGTH");
							System.out.println("fieldLength         "+fieldLength);

							if(PS_VALUE == 1)
							{
								System.out.println("enters into PS_VALUE == 1");
								//compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_REF_ID1().setMaxlength(12);
								compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_NEW_IC().setMaxlength(fieldLength);
							}
							else if(PS_VALUE == 2)
							{
								System.out.println("enters into PS_VALUE == 2");
								//compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_REF_ID1().setMaxlength(24);
								compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_NEW_IC().setMaxlength(fieldLength);
							}
							
				          end*/
						}
					}else{
						if(Double.valueOf(PW_IL_QUICK_QUOTE_BEAN.getUI_NET_PREMIUM())>0.0){
							COMP_UI_M_BUT_APPROVAL.setDisabled(false);
							/* Added by ganesh on 11-04-2017 for decline functionality */
							COMP_UI_M_MAKE_DECLINE.setDisabled(false);
							/*END*/
						}
					}


					//PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_FC_SA(M_POAC_FC_SA);



					if("A".equalsIgnoreCase(PW_IL_QUICK_QUOTE_BEAN.getQUOT_APPR_STS()))
					{
						disableallcomponent(true);
						getCOMP_UI_M_APPRV_STATUS().setValue("Approved");
						PW_IL_QUICK_QUOTE_BEAN.setUI_M_APPRV_STATUS("Approved");
						COMP_UI_M_CONV_POL.setDisabled(false);
						COMP_UI_M_MAKE_AMMENMENT.setDisabled(false);
						COMP_UI_M_CLC_PREMIUM.setDisabled(true);
						COMP_UI_M_BUT_APPROVAL.setDisabled(true);
						COMP_UI_SAVE_DOWN.setDisabled(true);
						COMP_UI_SAVE_UP.setDisabled(true);

						/* Added by ganesh on 11-04-2017 for decline functionality */
						COMP_UI_M_MAKE_DECLINE.setDisabled(true);
						/*END*/
						
					}

					if("Y".equalsIgnoreCase(PW_IL_QUICK_QUOTE_BEAN.getQUOT_CONV_YN()))
					{
						disableallcomponent(true);
						getCOMP_UI_M_APPRV_STATUS().setValue("You cannot do any change because quotation was already converted to proposal");
						PW_IL_QUICK_QUOTE_BEAN.setUI_M_APPRV_STATUS("You cannot do any change because quotation was already converted to proposal");
						COMP_UI_M_CONV_POL.setDisabled(true);
						COMP_UI_M_CLC_PREMIUM.setDisabled(true);
						COMP_UI_M_MAKE_AMMENMENT.setDisabled(true);
						COMP_UI_M_BUT_APPROVAL.setDisabled(true);
						COMP_UI_SAVE_DOWN.setDisabled(true);
						COMP_UI_SAVE_UP.setDisabled(true);
						
						/* Added by ganesh on 11-04-2017 for decline functionality */
						COMP_UI_M_MAKE_DECLINE.setDisabled(true);
						/*END*/
						
					}


					/*else{
						disableallcomponent(false);
					}*/
					helper.postQuery(PW_IL_QUICK_QUOTE_BEAN);
					if (PW_IL_QUICK_QUOTE_BEAN.getQUOT_FRZ_RATE().equals("Y")) {
						//	disableAllComponent(true);
						//compositeAction.getPW_IL_POL_APPL_PLAN_ACTION_BEAN().disableAllComponent(true);
						//compositeAction.getPW_GL_PLAN_APPL_COVER_ACTION_BEAN().disableAllComponent(true);
						//compositeAction.getPW_GL_PLAN_APPL_EMPL_ACTION_BEAN().disableAllComponent(true);
					}
				}else {
					helper.whenCreateheaderRecord(this);
					helper.whenCreatepayerRecord(this);
					helper.preLoadheader(compositeAction);
					helper.preLoadcustomer(compositeAction);
					helper.preLoadBrocker(compositeAction);
					//	helper.preloadnewcustomer(compositeAction);
					COMP_UI_M_BUT_APPROVAL.setDisabled(true);
					COMP_UI_M_CONV_POL.setDisabled(true);
					COMP_UI_M_MAKE_AMMENMENT.setDisabled(true);
					COMP_UI_M_CLC_PREMIUM.setDisabled(true);
					/* Added by ganesh on 11-04-2017 for decline functionality */
					COMP_UI_M_MAKE_DECLINE.setDisabled(true);
					/*END*/
					/*chargetable(chargeAction);
					covertable(CoverAction);
					debittable(discAction);*/
				}
				setBlockFlag(false);
				//added by saranya for ssp call id FALCONQC-1714511
				headertoggle.setOpened(true);
				customertoggle.setOpened(true);
				//end
			
			
			
			
			 
			/*Added by Janani on 13.8.2016 for IC no length issue*/
			
			
			int fieldLength = 0;
			int PS_VALUE= (int) CommonUtils.getGlobalObject("M_PS_VALUE");
			fieldLength = 	(int) CommonUtils.getGlobalObject("FIELD_LENGTH");
			System.out.println("fieldLength         "+fieldLength);

			if(PS_VALUE == 1)
			{
				System.out.println("enters into PS_VALUE == 1");
				//compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_REF_ID1().setMaxlength(12);
				compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_NEW_IC().setMaxlength(fieldLength);
			}
			else if(PS_VALUE == 2)
			{
				System.out.println("enters into PS_VALUE == 2");
				//compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN().getCOMP_CUST_REF_ID1().setMaxlength(24);
				compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_NEW_IC().setMaxlength(fieldLength);
			}
			
			/*end*/
			/*Added By Dhinesh on 28.9.2016*/
			headertoggle.setOpened(true);
			customertoggle.setOpened(true);
			/*  End */

			/*COMP_QUOT_CUST_CODE.setDisabled(true);
				helper.whenCreateRecord(this);
				setBlockFlag(false);*/
			
			/*Added by Ram on 27/11/2016 for Medical Remarks field value handlling*/
			System.out.println("getPW_IL_QUICK_QUOTE_BEAN().getQUOT_MED_YN()        "+getPW_IL_QUICK_QUOTE_BEAN().getQUOT_MED_YN());
			if(getPW_IL_QUICK_QUOTE_BEAN().getQUOT_MED_YN() != null)
			{
				if(getPW_IL_QUICK_QUOTE_BEAN().getQUOT_MED_YN().equals("Y"))
				{
					COMP_QUOT_MED_REC_YN_CHK.setDisabled(false);
					COMP_QUOT_MED_REMARKS.setDisabled(false);
				}
				else if(getPW_IL_QUICK_QUOTE_BEAN().getQUOT_MED_YN().equals("N"))
				{
					COMP_QUOT_MED_REC_YN_CHK.setDisabled(true);
					COMP_QUOT_MED_REMARKS.setDisabled(true);
				}
			}
			/*End*/
			
			/*Added by Ram on 20/12/2016 for Age Difference Validation*/
			int currentAge = calculateAgeWithCurrentDate(PW_IL_QUICK_QUOTE_BEAN, new Date());
			System.out.println("currentAge in OnLoad    "+currentAge+"     "+getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_AGE());
			if(currentAge > getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_AGE())
			{
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Assured Age has changed.Kindly change the Quotation Start Date.");
			}
			/*End*/
			
			/* Added by ganesh on 11-04-2017 for decline functionality */
			if("D".equalsIgnoreCase(PW_IL_QUICK_QUOTE_BEAN.getQUOT_APPR_STS()))
			{
				disableButtonsWhenDeclined();
			}
			/*END*/
			
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*Added by Ram on 20/12/2016 for Display alert message for Age mismatch with current Quotation*/
	public int calculateAgeWithCurrentDate(PW_IL_QUICK_QUOTE Quick_Bean,
			java.util.Date POAD_DOB) throws Exception
	{
		int currentAge = 0;
		ArrayList<OracleParameter> list1 = new  ArrayList<OracleParameter>();
		CommonUtils commonUtils = new CommonUtils();
		try {
			 
			if (POAD_DOB != null) {


				ResultSet resultSet = null;

				String VALIDATE_QUERY = "SELECT PROD_AGE_CALC_FLAG FROM PM_IL_PRODUCT WHERE PROD_CODE = ?";
				String param_age="";

				resultSet = new CRUDHandler().executeSelectStatement(
						VALIDATE_QUERY, CommonUtils.getConnection(),
						new Object[] { Quick_Bean.getQUOT_PROD_CODE() });
				if (resultSet.next()) {

					param_age=resultSet.getString("PROD_AGE_CALC_FLAG");
				} else {
					param_age="2";
				}
	            
				list1 = PKG_PILT002_APAC_QE.P_CALC_ANB(
						POAD_DOB,
						getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_ASSR_DOB(),
						param_age,
						0);
				//CommonUtils.getProcedureValue(Quick_Dtls.getQQAD_AGE()));
				if (list1 != null && !list1.isEmpty()) {
					if (list1.get(0) != null) {
						if((Integer)list1.get(0).getValueObject()>0){
							currentAge = ((Integer)list1.get(0).getValueObject());
						}
						else{
							throw new Exception("Age Must be Greater Than Zero");
						}
					}

				}

			}

		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

return currentAge;

	}
	/*End*/

	/*Added by Ram on 29/08/2016 for NewIC validation changes in Approve button*/
	private boolean saveClicked;


	public boolean isSaveClicked() {
		return saveClicked;
	}


	public void setSaveClicked(boolean saveClicked) {
		this.saveClicked = saveClicked;
	}


	/*End*/
	
	/*Added by Ram on 03/11/2016 for ReviewSheet currency code issue*/
	private String changeTerm;
	
	public String getChangeTerm() {
		return changeTerm;
	}


	public void setChangeTerm(String changeTerm) {
		this.changeTerm = changeTerm;
	}


	/*End*/
	public void saveAction() {
		CommonUtils.clearMaps(this);
		String message = null;
		String createNew = null;
		try {
			/*Added by Ram on 03/01/2017 for Title default value*/
			 if(PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_TITLE() == null)
			 {
				 PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_TITLE("1");
			 }
			 /*End*/
			System.out.println("PW_IL_QUICK_QUOTE_BEAN.QUOT_MED_YN       "+getPW_IL_QUICK_QUOTE_BEAN().getQUOT_MED_YN());
			System.out.println("PW_IL_QUICK_QUOTE_BEAN  in save    "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_PREM_PAY_YRS());
			System.out.println("QUOT_MED_REC_YN  in save    "+PW_IL_QUICK_QUOTE_BEAN.isQUOT_MED_REC_YN_CHK());
			System.out.println("getQUOT_MED_REMARKS  in save    "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_MED_REMARKS());
			
			/*Added by Ram on 03/11/2016 for ReviewSheet currency code & Term change issue issue*/
			if(getPW_IL_QUICK_QUOTE_BEAN().getQUOT_CUST_CURR_CODE() == null)
			{
				getPW_IL_QUICK_QUOTE_BEAN().setQUOT_CUST_CURR_CODE(CommonUtils.getGlobalVariable("GLOBAL.CURRENCY_CODE"));
			}
			System.out.println("getQuickdataList_PM_IL_PROD_APPL_COVER()       "+getQuickdataList_PM_IL_PROD_APPL_COVER());
			/*End*/
			
			 
			
			/*Added by Ram on 03/11/2016 for FALCONLIFE-1350739*/
			if(compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_PERIOD() < compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN().getQUOT_PREM_PAY_YRS())
			{
				throw new Exception("Premium Paying years must be less than Paying Term");
			}
			/*End*/
			
			 
			/*Commenetd by Ram on 05/11/2016
			 * 
			 * boolean isValid = true;
			for(int loop=1;loop<getQuickdataList_PM_IL_PROD_APPL_COVER().size();loop++)
			{
				PW_IL_QQUOT_APPL_COVER PW_IL_QQUOT_APPL_COVER_BEAN = getQuickdataList_PM_IL_PROD_APPL_COVER().get(loop);
				
				int period = PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_PERIOD();
				if(period > PW_IL_QUICK_QUOTE_BEAN.getQUOT_PERIOD())
				{
					isValid = false;
					break;
				}
			}
			
			if(!isValid)
			{
				throw new Exception("Rider Cover Term should not be greater than Basic Cover Term");
			}*/
			
			if(getChangeTerm() == null)
			{
				setChangeTerm("N");
			}
			System.out.println("getChangeTerm in save      "+getChangeTerm());
			/*End*/
			
			/*Added by Ram on 29/08/2016 for NewIC validation changes in Approve button*/
			setSaveClicked(true);
			/*End*/

			System.out.println("  pay ....."+PW_IL_QUICK_QUOTE_BEAN.getQUOT_PREM_PAY_YRS()+"       height         "+PW_IL_QUICK_QUOTE_DTLS_BEAN.getQQAD_HEIGHT());
			
			/*Added by Ram on 20/11/2016 for Report issues*/
			compositeAction.getPRINT_ACTION_BEAN().getCOMP_QQAT_PRINT().setDisabled(true);
			/*End*/
			
			/*Commented by Ram in 16/11/2016 as per Vinoth discussion 
			helper.QUOT_FC_SUM_ASSURED_WHEN_CLEAR_BLOCK( compositeAction, PW_IL_QUICK_QUOTE_BEAN.getQUOT_LC_SA());
			End
			
            /*Added by Ram on 01/11/2016 for Age Calculation Issue*/
			helper.calculateAge(compositeAction,
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN(),
					getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_ASSR_DOB(),
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN());
			/*End*/

			System.out.println("PW_IL_QUICK_QUOTE_BEAN.QUOT_MED_YN   second    "+getPW_IL_QUICK_QUOTE_BEAN().getQUOT_MED_YN());

			if (PW_IL_QUICK_QUOTE_BEAN.getROWID() == null) {
				createNew = "Y";
				CommonUtils.setGlobalVariable("GLOBAL.CREATE_NEW", createNew);

				String src_code= PW_IL_QUICK_QUOTE_BEAN.getQUOT_SRC_CODE(); 

				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
System.out.println("PW_IL_QUICK_QUOTE_BEAN.getQUOT_CR_UID(    "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_CR_UID()+"  "+CommonUtils.getControlBean().getM_USER_ID()+"     "+
				CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
				/*PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_CR_DT(new CommonUtils().getCurrentDate());

				PW_IL_QUICK_QUOTE_BEAN.setQUOT_FM_DT(new CommonUtils().getCurrentDate());*/
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_TYPE("R");


				if(PW_IL_QUICK_QUOTE_BEAN.getQUOT_SRC_BUS().equalsIgnoreCase("075"))
				{
					if( src_code==null){
						throw new Exception("Source/Agent Code:Validation Error: Value is required.");}
				}

				PW_IL_QUICK_QUOTE_BEAN.setQUOT_MAX_AGE(PW_IL_QUICK_QUOTE_DTLS_BEAN.getQQAD_AGE());
				helper.updateQUOT_MED_YNflag(compositeAction);


				helper.generateQuotationNo(compositeAction);
				System.out.println("PW_IL_QUICK_QUOTE_BEAN.getQUOT_CR_UID( 2ND   "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_CR_UID()+"  "+CommonUtils.getControlBean().getM_USER_ID()+"     ");
				new CRUDHandler().executeInsert(PW_IL_QUICK_QUOTE_BEAN, CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				new CRUDHandler().executeInsert(PW_IL_QUICK_QUOTE_DTLS_BEAN, CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				
				/*Added by Ram on 12/12/2016 for nullable handling*/
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
				new CRUDHandler().executeUpdate(PW_IL_QUICK_QUOTE_BEAN, CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				/*End*/
				
				message = Messages.getString("messageProperties","errorPanel$message$save");
				System.out.println("PW_IL_QUICK_QUOTE_BEAN.getQUOT_CR_UID( 3RD   "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_CR_UID()+"  "+CommonUtils.getControlBean().getM_USER_ID()+"     ");
				/*Modified by Ram on 03/11/2016 for term Change issue*/
				helper.postUpdate(PW_IL_QUICK_QUOTE_BEAN,this);
				/*End*/
				
				chargetable(compositeAction);
				covertable(compositeAction);
				debittable(compositeAction);
				COMP_UI_M_CLC_PREMIUM.setDisabled(false);
				COMP_UI_M_BUT_EXPAND_LINK.setDisabled(false);
				delegate.defaultCommissiondetatil(compositeAction);

			}else if (PW_IL_QUICK_QUOTE_BEAN.getROWID() != null) {
				createNew = "N";
				CommonUtils.setGlobalVariable("GLOBAL.CREATE_NEW", createNew);
				String src_code= PW_IL_QUICK_QUOTE_BEAN.getQUOT_SRC_CODE(); 

				PW_IL_QUICK_QUOTE_BEAN.setQUOT_CR_UID(CommonUtils.getControlBean().getM_USER_ID());

				if(PW_IL_QUICK_QUOTE_BEAN.getQUOT_SRC_BUS().equalsIgnoreCase("075"))
				{
					if( src_code==null)
						throw new Exception("Source/Agent Code:Validation Error: Value is required.");
				}
				System.out.println("PW_IL_QUICK_QUOTE_BEAN.QUOT_MED_YN   third    "+getPW_IL_QUICK_QUOTE_BEAN().getQUOT_MED_YN());
				helper.updateQUOT_MED_YNflag(compositeAction);
				System.out.println("PW_IL_QUICK_QUOTE_BEAN.QUOT_MED_YN   fourth    "+getPW_IL_QUICK_QUOTE_BEAN().getQUOT_MED_YN());
				CommonUtils.getConnection().commit();
				/*	Added by sankaraNarayanan for FALCONLIFE-1345285	*/
				helper.DeleteCoverWhenProductChange(PW_IL_QUICK_QUOTE_BEAN);
				/*	end	*/

				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_CR_DT(new CommonUtils().getCurrentDate());
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
				System.out.println("PW_IL_QUICK_QUOTE_BEAN.QUOT_MED_YN   fifth    "+getPW_IL_QUICK_QUOTE_BEAN().getQUOT_MED_YN());
				System.out.println("dtls uid "+PW_IL_QUICK_QUOTE_DTLS_BEAN.getQQAD_CR_UID());
				new CRUDHandler().executeUpdate(PW_IL_QUICK_QUOTE_BEAN, CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				System.out.println("  pay ....."+PW_IL_QUICK_QUOTE_BEAN.getQUOT_PREM_PAY_YRS()
						+"       height         "+PW_IL_QUICK_QUOTE_DTLS_BEAN.getQQAD_HEIGHT()
						+"     RowId   "+PW_IL_QUICK_QUOTE_DTLS_BEAN.getROWID());
				
				new CRUDHandler().executeUpdate(PW_IL_QUICK_QUOTE_DTLS_BEAN, CommonUtils.getConnection());
				CommonUtils.getConnection().commit();
				/*
				 * Code Commented By Dhinesh 6.8.2016 for delete default cover reset Issues
				 * 
				 * helper.postUpdate(PW_IL_QUICK_QUOTE_BEAN); 
				 * 
				 *   
				 *   */
				
				/*Modified by Ram on 03/11/2016 for term Change issue*/
				helper.postUpdate(PW_IL_QUICK_QUOTE_BEAN,this);
				/*End*/
				
				/*
				 * 
				 *  Code Commented By Dhinesh 16.8.2016 for  reset Charge list Issues
				 * chargetable(compositeAction);
				 *
				 *
				 */
				covertable(compositeAction);
				debittable(compositeAction);
				if(!CommonUtils.nvl(PW_IL_QUICK_QUOTE_BEAN.getQUOT_APPR_STS(), "T").equals("T")){
					if("A".equalsIgnoreCase(PW_IL_QUICK_QUOTE_BEAN.getQUOT_APPR_STS()))
					{

						COMP_UI_M_CLC_PREMIUM.setDisabled(true);
					}else{
						COMP_UI_M_CLC_PREMIUM.setDisabled(false);
					}
				}else{
					COMP_UI_M_CLC_PREMIUM.setDisabled(false);
				}
				delegate.defaultCommissiondetatil(compositeAction);
				message = Messages.getString("messageProperties","errorPanel$message$update");
			}

			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, message);
			CommonUtils.getConnection().commit();



		} catch (Exception e) {
			e.printStackTrace();

			/*String error = ErrorHelpUtil
					.getUserErrorMessageFromDBErrorMessage(e.getMessage());*/
			getErrorMap()
			.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());


		}


	}



	public void fireFieldValidation(ActionEvent event) {
		System.out.println("*************Entered into fireFieldValidation m************");
		UIInput input = (UIInput) event.getComponent().getParent();
		/*
		 * if("QUOT_PROD_CODE".equals(input.getId())){
		 * PW_IL_QUICK_QUOTE_BEAN.setQUOT_PROD_CODE_DESC(null);
		 * COMP_QUOT_PROD_CODE_DESC.resetValue(); }
		 */
		ErrorHelpUtil.validate(input, getErrorMap());

	}

	/*Added by Ram on 08/11/2016 for FALCONLIFE-1349309*/
	public void fireFieldValidationSumAssured(ActionEvent event) {
		System.out.println("*************Entered into fireFieldValidationSumAssured m************");
		UIInput input = (UIInput) event.getComponent().getParent();
		/*
		 * if("QUOT_PROD_CODE".equals(input.getId())){
		 * PW_IL_QUICK_QUOTE_BEAN.setQUOT_PROD_CODE_DESC(null);
		 * COMP_QUOT_PROD_CODE_DESC.resetValue(); }
		 */
		System.out.println("input.getSubmittedValue()       "+input.getSubmittedValue());
		Double currentValue =  Double.parseDouble((String)input.getSubmittedValue());
		if(PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_FC_SA() != currentValue)
		{
			System.out.println("Enter into QQAC_SUM_ASS_WHEN_VALIDATE_ITEM         "+PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_FC_SA()+"        "+input.getSubmittedValue());
			setChangeTerm("Y");
		}
		else
		{
			System.out.println("Npo Changes in Sumassured");
		}
		PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_FC_SA(currentValue);
		PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_PERIOD_COPY(PW_IL_QUICK_QUOTE_BEAN.getQUOT_PERIOD());
		ErrorHelpUtil.validate(input, getErrorMap());

	}
	/*End*/

	//sankar
	public void loadcover (ActionEvent event) throws Exception{

		UIInput input = (UIInput) event.getComponent().getParent();

		Boolean flag=(Boolean)input.getSubmittedValue() ;

		if(flag){
			covertoggle= new HtmlSimpleTogglePanel();
			covertoggle.setRendered(true);
			covertable(compositeAction);

		}
		else{

			System.out.println("before  "+quickdataList_PM_IL_PROD_APPL_COVER);
			quickdataList_PM_IL_PROD_APPL_COVER.clear();

			System.out.println("after  "+quickdataList_PM_IL_PROD_APPL_COVER);
		}

	}

	public void loaddebit (ActionEvent event) throws Exception{

		UIInput input = (UIInput) event.getComponent().getParent();
		Boolean flag=(Boolean)input.getSubmittedValue() ;
		if(flag){
			debitoggle= new HtmlSimpleTogglePanel();
			debitoggle.setRendered(true);
			debittable(compositeAction);
		}else{
			System.out.println("before  "+quickdataList_PT_IL_POL_DISC_LOAD);
			quickdataList_PT_IL_POL_DISC_LOAD.clear();

			System.out.println("after  "+quickdataList_PT_IL_POL_DISC_LOAD);
		}

	}

	public void loadcharge (ActionEvent event) throws Exception{

		UIInput input = (UIInput) event.getComponent().getParent();
		Boolean flag=(Boolean)input.getSubmittedValue() ;
		if(flag){
			chargetoggle= new HtmlSimpleTogglePanel();
			chargetoggle.setRendered(true);
			chargetable(compositeAction);

		}else{

			System.out.println("before  "+quickdataList_PT_IL_POL_CHARGE);
			quickdataList_PT_IL_POL_CHARGE.clear();

			System.out.println("after  "+quickdataList_PT_IL_POL_CHARGE);
		}
	}

	// Validators

	public void validateQUOT_NEW_CUST_YN(FacesContext context,
			UIComponent component, Object object) {

		PW_IL_QUICK_QUOTE_BEAN.setQUOT_EXISTING_CUST_BOOLEAN((Boolean) object);
		try {
			if (PW_IL_QUICK_QUOTE_BEAN.isQUOT_EXISTING_CUST_BOOLEAN()) {
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_NEW_CUST_YN("Y");
				COMP_QUOT_CUST_CODE.setDisabled(false);
			} else {
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_NEW_CUST_YN("N");
				COMP_QUOT_CUST_CODE.setDisabled(true);
				COMP_QUOT_CUST_CODE.resetValue();
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	public void validateQUOT_SO_CODE(FacesContext context,
			UIComponent component, Object object) {


		try {
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_SO_CODE((String) object);
			System.out.println("bean " +PW_IL_QUICK_QUOTE_BEAN.getQUOT_SO_CODE());

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateQUOT_EMR_CODE(FacesContext context,
			UIComponent component, Object object) {


		try {
			Double EMRvalue=((Double) object);
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_EMR_RATE(EMRvalue);
			System.out.println("QUOT_EMR_RATE bean " +PW_IL_QUICK_QUOTE_BEAN.getQUOT_EMR_RATE());

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateQUOT_SM_CODE(FacesContext context,
			UIComponent component, Object object) {


		try {
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_SM_CODE((String) object);
			System.out.println("QUOT_SM_CODE " +PW_IL_QUICK_QUOTE_BEAN.getQUOT_SM_CODE());

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}	




	public void validateQUOT_BANK_CODE(FacesContext context,
			UIComponent component, Object object) {


		try {
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_BANK_CODE((String) object);
			System.out.println("QUOT_SM_CODE " +PW_IL_QUICK_QUOTE_BEAN.getQUOT_BANK_CODE());
			
			/*Modified by Ram on 20/11/2016 for BankCode field value set*/
			helper.L_CHK_BANK(PW_IL_QUICK_QUOTE_BEAN.getQUOT_BANK_CODE().trim(),"E",this);
			/*End*/
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	public void validateQUOT_BANK_DIVN(FacesContext context,
			UIComponent component, Object object) {

		PW_IL_QUICK_QUOTE_BEAN.setQUOT_BANK_DIVN((String) object);
		System.out.println("QUOT_SM_CODE " +PW_IL_QUICK_QUOTE_BEAN.getQUOT_BANK_DIVN());
		try {
			/*if (PW_IL_QUICK_QUOTE_BEAN.isQUOT_EXISTING_CUST_BOOLEAN()) {
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_NEW_CUST_YN("Y");
				COMP_QUOT_CUST_CODE.setDisabled(false);
			} else {
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_NEW_CUST_YN("N");
				COMP_QUOT_CUST_CODE.setDisabled(true);
				COMP_QUOT_CUST_CODE.resetValue();
			}*/

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	public void validateQUOT_BANK_ACNT(FacesContext context,
			UIComponent component, Object object) {

		PW_IL_QUICK_QUOTE_BEAN.setQUOT_BANK_ACNT((String) object);
		System.out.println("QUOT_SM_CODE " +PW_IL_QUICK_QUOTE_BEAN.getQUOT_BANK_ACNT());
		try {
			/*if (PW_IL_QUICK_QUOTE_BEAN.isQUOT_EXISTING_CUST_BOOLEAN()) {
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_NEW_CUST_YN("Y");
				COMP_QUOT_CUST_CODE.setDisabled(false);
			} else {
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_NEW_CUST_YN("N");
				COMP_QUOT_CUST_CODE.setDisabled(true);
				COMP_QUOT_CUST_CODE.resetValue();
			}*/

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	public void validateQUOT_PERIOD(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		//CommonUtils.clearMaps(this);
		try {
			System.out.println("Enter into validateQUOT_PERIOD");
			COMP_QUOT_PERIOD.resetValue();

			COMP_QUOT_PREM_PAY_YRS.resetValue();
			int period=(Integer) value;
			int period1;

		//	PW_IL_QUICK_QUOTE_BEAN.QUOT_PREM_PAY_YRS
			if(period>0){
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_PERIOD((Integer) value);
				//commented by dhinesh for mop term issue on 26-10-2016
				//if (PW_IL_QUICK_QUOTE_BEAN.getROWID() == null){
					System.out.println("PW_IL_QUICK_QUOTE_BEAN.getQUOT_MOP()   : "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_MOP());
					/*					
					 * COMMENTED BY DHINESH ON 12.10.2016 FOR SSP CALL ID 
					 * 
					 * PW_IL_QUICK_QUOTE_BEAN.setQUOT_PREM_PAY_YRS((Integer) value);
					COMP_QUOT_PREM_PAY_YRS.resetValue();*/

					if(!"S".equalsIgnoreCase(PW_IL_QUICK_QUOTE_BEAN.getQUOT_MOP()))
					{
						System.out.println("ENTER QUOT_PREIOD");

						 
						 PW_IL_QUICK_QUOTE_BEAN.setQUOT_PREM_PAY_YRS((Integer) value);
						COMP_QUOT_PREM_PAY_YRS.resetValue(); 
						 
					}
				//}
				//	PW_IL_QUICK_QUOTE_BEAN.setQUOT_PERIOD((Integer) value);
				period1= period*12;
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_TO_DT(new CommonUtils().addMonthsToDate(PW_IL_QUICK_QUOTE_BEAN.getQUOT_FM_DT(),period1));
				System.out.println("PROD CODE  "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_PROD_CODE());

				/*int paying_term =PW_IL_QUICK_QUOTE_BEAN.getQUOT_PREM_PAY_YRS();
				if(paying_term>0){
					if(period>=0 && period>=paying_term)
					{
						PW_IL_QUICK_QUOTE_BEAN.setQUOT_PERIOD((Integer) value);
						PW_IL_QUICK_QUOTE_BEAN.setQUOT_PREM_PAY_YRS(PW_IL_QUICK_QUOTE_BEAN.getQUOT_PERIOD());
						 period1= period*12;
						PW_IL_QUICK_QUOTE_BEAN.setQUOT_TO_DT(new CommonUtils().addMonthsToDate(PW_IL_QUICK_QUOTE_BEAN.getQUOT_FM_DT(),period1));
						System.out.println("PROD CODE  "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_PROD_CODE());
					}
					else
					{
						throw new Exception("Period should be Greater than or Equal to Paying Terms");
					}

				}*/
			}
			else{
				throw new Exception("Period should be Greater than Zero");
			}






		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}


	public void validateQUOT_FC_SA(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		//CommonUtils.clearMaps(this);
		try {
			Double sumvalue=((Double) value);
			System.out.println("value in validateQUOT_FC_SA "+sumvalue);
			
			/*Commented by Ram in 16/11/2016 as per Vinoth discussion 
			helper.QUOT_FC_SUM_ASSURED_WHEN_CLEAR_BLOCK(compositeAction, sumvalue);
			 End*/
			
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_FC_SA(sumvalue);
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_LC_SA(sumvalue);

			System.out.println("123"+PW_IL_QUICK_QUOTE_BEAN.getQUOT_FC_SA());
			
			/*Added by Ram on 27/11/2016 for Medical Remarks field capturing*/
			helper.updateQUOT_MED_YNflag(compositeAction);
			/*End*/
			
			/*if(sumvalue>100000)
			{
				System.out.println("INSIDE IF CONDITION");
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Sum assured exceeded the defined value of 100000 ");


			}*/
			// helper.POL_PERIOD_WHEN_VALIDATE_ITEM(compositeAction,(Integer)
			// value);

			// COMP_QUOT_FM_DT.resetValue();
			// COMP_QUOT_TO_DT.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exception.getMessage());
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));

		}
	}



	public void validateQUOT_PREM_PAY_YRS(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		//CommonUtils.clearMaps(this);

		System.out.println("enter inor paying  years   ");
		try{
			Integer Paying_term = (Integer) value;
			System.out.println("Paying_term      "+Paying_term);
			if(Paying_term>0){
				//PW_IL_QUICK_QUOTE_BEAN.setQUOT_PREM_PAY_YRS((Integer) value);
				int period=PW_IL_QUICK_QUOTE_BEAN.getQUOT_PERIOD();
				System.out.println("period       "+period);
				if(period>0){
					
					/*	ADDED BY SANKARA nARAYANAN fOR pREMIUM PAYING YEAR ISSUE */
					if ("Y".equals(PW_IL_QUICK_QUOTE_BEAN.getQUOT_MOP())
							|| "H".equals(PW_IL_QUICK_QUOTE_BEAN.getQUOT_MOP())
							|| "M".equals(PW_IL_QUICK_QUOTE_BEAN.getQUOT_MOP())
							|| "Q".equals(PW_IL_QUICK_QUOTE_BEAN.getQUOT_MOP())) {
							
				/*	END */
					/*commented by dhinesh for MOP term issue on26-10-2016
					 * if(Paying_term<=period)*/	
						
						/*Modified  by Ram on 05/11/2016 for FALCONLIFE-1350739*/
					if(Paying_term>=period)
					{
						/*if (PW_IL_QUICK_QUOTE_BEAN.getROWID() == null) {*/
						throw new Exception("Premium Paying Term  Should not be greater than Period");
						//}
					}
					else
					{
						PW_IL_QUICK_QUOTE_BEAN.setQUOT_PREM_PAY_YRS((Integer) value);
						//throw new Exception("Premium Paying Term  and period should be same");
						this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getWarningMap().clear();
						this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getWarningMap().put(
								"current", "Premium Paying Term  and period should be same");
						
					}
					/*End*/
					/*	ADDED BY SANKARA nARAYANAN fOR pREMIUM PAYING YEAR ISSUE */
					}else{
						if(Paying_term>1)
						{
							throw new Exception("If Mode of Payment is Single, Premium Paying Term  should be One ");
						}
						
					}
								/*	END */

				}
			}

			else{
				throw new Exception("Premium Paying Term should be Greater Than Zero");
			}
			System.out.println("PW_IL_QUICK_QUOTE_BEAN      "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_PREM_PAY_YRS());
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}



		/*try {



			COMP_QUOT_PREM_PAY_YRS.resetValue();
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_PREM_PAY_YRS((Integer) values);

			System.out.println("  pay ....."+PW_IL_QUICK_QUOTE_BEAN.getQUOT_PREM_PAY_YRS());

			// values =
			// helper.POL_PREM_PAY_YRS_WHEN_VALIDATE_ITEM(compositeAction,
			// values);
			COMP_QUOT_FM_DT.resetValue();
			COMP_QUOT_TO_DT.resetValue();
			//COMP_QUOT_PREM_PAY_YRS.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}*/ finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "POL_PREM_PAY_YRS", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/*HEADER FUN*/
	public void validateQUOT_ISS_DT(FacesContext context,
			UIComponent component, Object value) {
		System.out.println("sankar");

		try {
			COMP_QUOT_FM_DT.resetValue();
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_ISS_DT((Date) value);
			

			System.out.println("ISSUE DATE"+PW_IL_QUICK_QUOTE_BEAN.getQUOT_ISS_DT());
			/*PW_IL_QUICK_QUOTE_BEAN.setQUOT_TO_DT(helper
					.addMonthsToDate(PW_IL_QUICK_QUOTE_BEAN.getQUOT_FM_DT()));
			System.out.println("setQUOT_TO_DT"+PW_IL_QUICK_QUOTE_BEAN.getQUOT_FM_DT());*/

			/*Added By Ramkumar 2.11.2016 */
			//PW_IL_QUICK_QUOTE_BEAN.setQUOT_FM_DT((Date) value);
			if(getPW_IL_QUICK_QUOTE_BEAN().getQUOT_FM_DT() == null)
			{
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_FM_DT((Date) value);
			}

			/* End */

			COMP_QUOT_FM_DT.resetValue();
			COMP_QUOT_TO_DT.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}



	public void validatePOL_PROD_GROUP_CODE(FacesContext facesContext,
			UIComponent component, Object value)  {
		//	CommonUtils.clearMaps(this);
		try {
			//	PW_IL_QUICK_QUOTE_BEAN.setQUOT_OD_CODE((String) value);
			/*helper.POL_PROD_GROUP_CODE_WHEN_VALIDATE_ITEM(this,
					PW_IL_QUICK_QUOTE_BEAN, (String) value);*/
			
			/*Added by Ram on 17/11/2016 for Product code validation*/
			boolean correctProduct = false;
			String productCode = (String) value;
			System.out.println("productCode       "+productCode);
			Iterator<LovBean> prodItr = getPRODUCT_LIST().iterator();
			while(prodItr.hasNext())
			{
				LovBean prodCodeBean = (LovBean)prodItr.next();
				System.out.println("prodCodeBean.getCode()  "+prodCodeBean.getCode()+"    "+productCode);
				if(prodCodeBean.getCode() != null)
				{
					if((prodCodeBean.getCode().equals(productCode)))
					{
						correctProduct = true;
						break;
					}
				}
			}
			System.out.println("correctProduct  "+correctProduct);
			if(!correctProduct)
			{
				throw new ValidatorException(new FacesMessage("Invalid Product Code"));
			}
			/*End*/
			
			helper.QUOT_PROD_CODE_WHEN_VALIDATE_ITEM(PW_IL_QUICK_QUOTE_BEAN,
					(String) value);
			String oldvalue=PW_IL_QUICK_QUOTE_BEAN.getQUOT_PROD_CODE();  // ADDED BY SANKAR for ssp call id FALCONLIFE-1345285 on 13-10-16
			String Currvalue=(String)value;
			System.out.println("sankar");
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_PROD_CODE((String)value);

			COMP_QUOT_PERIOD.resetValue();

			COMP_QUOT_PREM_PAY_YRS.resetValue();

			if (PW_IL_QUICK_QUOTE_BEAN.getROWID() == null || (!(Currvalue.equalsIgnoreCase(oldvalue)))) {   // ADDED BY SANKAR for ssp call id FALCONLIFE-1345285 on 13-10-16

				helper.POL_PROD_CODE_WHEN_VALIDATE_ITEM(compositeAction,(String) value,oldvalue);  // ADDED BY SANKAR for ssp call id FALCONLIFE-1345285 on 13-10-16
				int period=PW_IL_QUICK_QUOTE_BEAN.getQUOT_PERIOD();
				int period1= period*12;
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_TO_DT(new CommonUtils().addMonthsToDate(PW_IL_QUICK_QUOTE_BEAN.getQUOT_FM_DT(),period1));
				System.out.println("PROD CODE  "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_PROD_CODE());

			}

			/*	chargetable(chargeAction);
		covertable(CoverAction);
		debittable(discAction);*/
			// validatePOL_PROD_CODE(facesContext, component, value);
			// validatePOL_PLAN_CODE(facesContext, component, value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "QUOT_PROD_CODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	public void validateQUOT_FM_DT(FacesContext context, UIComponent component,
			Object value) {

		try {
			
/*Added by Ram on 25/11/2016 for Future Date validation*/
			
			Date date1 = new Date();
			System.out.println("date1     : "+date1);
			Date date2=(Date) value;
			System.out.println("datee2    : "+date2);
			 
			 
int difference = date1.compareTo(date2);
				System.out.println(difference + " days, in  validateQUOT_FM_DT "+difference); 
				boolean flag=true;
			 if(difference < 0)
			 {
				 flag = false;
			 }
			System.out.println("flag       "+flag);
			if(!flag)
			{
				throw new Exception("Proposal Start Date is not greater than current Date");
			}
			/*End*/
			
			COMP_QUOT_FM_DT.resetValue();
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_FM_DT((Date) value);
			int period=Integer.parseInt(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_6"));
			System.out.println("FROM DATE  "+period+"sankar"+PW_IL_QUICK_QUOTE_BEAN.getQUOT_FM_DT());


			//int period1= period*12;
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_VALID_DT (new CommonUtils().addDate(PW_IL_QUICK_QUOTE_BEAN.getQUOT_FM_DT(),(period-1)));
			System.out.println("TO DATE "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_TO_DT());
			//System.out.println("PROD CODE  "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_PROD_CODE());


			/*	PW_IL_QUICK_QUOTE_BEAN.setQUOT_TO_DT(helper
					.addMonthsToDate(PW_IL_QUICK_QUOTE_BEAN.getQUOT_FM_DT()));*/
			COMP_QUOT_TO_DT.resetValue();
			
			/*Added by Ram on 20/12/2016 for Age Calculation*/
			if(PW_IL_QUICK_QUOTE_BEAN.getROWID() != null)
			{
				System.out.println("DOB "+getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_ASSR_DOB());
				helper.QUOT_FM_DT_WHEN_VALIDATE_ITEM(compositeAction,compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN(),
						getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_ASSR_DOB(),compositeAction.
						getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN());
 
				COMP_QUOT_DOB.resetValue();
				COMP_QQOT_AGE.resetValue();
	        }
				/*End*/		
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateQUOT_TO_DT(FacesContext context, UIComponent component,
			Object value) {
		Date date = (Date) value;
		COMP_QUOT_TO_DT.resetValue();
		PW_IL_QUICK_QUOTE_BEAN.setQUOT_TO_DT((Date) value);

		System.out.println("FROM DATE  "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_FM_DT());
		System.out.println("to date //// "+	PW_IL_QUICK_QUOTE_BEAN.getQUOT_TO_DT() );
		if (date.before(PW_IL_QUICK_QUOTE_BEAN.getQUOT_FM_DT())) {
			throw new ValidatorException(Messages.getMessage(
					PELConstants.pelErrorMessagePath, "77776"));
		}
	}


	public void fireFieldvalidatePOL_ASSRD_REF_ID1(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		System.out.println("value IN fireFieldvalidatePOL_ASSRD_REF_ID1            "+value);
		if (value == null || "".trim().equals(value)) {

			System.out.println("Value is changed");

			/*COMP_POL_ASSRD_REF_ID2.setRequired(true);*/
			COMP_QUOT_CUST_CODE.setDisabled(true);
			COMP_QUOT_DOB.setDisabled(false);





			/*As per sivaram advise, we had implemented on this*/
			PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_ASSR_CODE("IND000058");
			/*PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_ASSURED_NAME("DUMMY");*/
			//	PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_CATG_CODE(null);
			//	PW_IL_QUICK_QUOTE_BEAN.setQUOT_ASSRD_REF_ID1(null);
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_CODE(null);
			//PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_NAME(null);
			//PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_SURNAME(null);

			COMP_QUOT_CUST_TITLE.setDisabled(false);
			COMP_QUOT_CUST_NAME.setDisabled(false);
			COMP_QUOT_CUST_LAST_NAME.setDisabled(false);

			//COMP_QUOT_CUST_CODE.resetValue();
			//COMP_QUOT_CUST_TITLE.resetValue();
			//COMP_QUOT_CUST_NAME.resetValue();
			//COMP_QUOT_CUST_LAST_NAME.resetValue();
			//COMP_QQOT_GENDER.resetValue();
			System.out.println("PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_CODE    "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_CODE());
			System.out.println("PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_NAME    "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_NAME());
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}


	public void validatePOL_ASSRD_REF_ID1(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			System.out.println("(String) value      "+(String) value);
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_ASSRD_REF_ID1((String) value);

			System.out.println("ic .... "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_ASSRD_REF_ID1());
			//COMP_QQOT_ASSR_CODE.resetValue();
			helper.POL_ASSRD_REF_ID1_WHEN_VALIDATE_ITEM(compositeAction,
					(String) value);



			/*COMP_QQOT_ASSURED_NAME.resetValue();
			PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_ASSURED_NAME((String) value);
			 */
			COMP_QUOT_CUST_CODE.resetValue();
			//COMP_QUOT_CUST_CODE.setDisabled(true);
			COMP_QUOT_CUST_TITLE.resetValue();
			//COMP_QUOT_CUST_TITLE.setDisabled(true);
			COMP_QUOT_CUST_NAME.resetValue();
			//COMP_QUOT_CUST_NAME.setDisabled(true);
			COMP_QUOT_CUST_LAST_NAME.resetValue();
			//COMP_QUOT_CUST_LAST_NAME.setDisabled(true);
			COMP_QQOT_ASSR_CODE.resetValue();
			//COMP_QQOT_ASSR_CODE.setDisabled(true);
			//COMP_QQOT_ASSURED_NAME.resetValue();
			//COMP_QQOT_ASSURED_NAME.setDisabled(true);
			COMP_QUOT_DOB.resetValue();
			//COMP_QUOT_DOB.setDisabled(true);
			COMP_QQOT_AGE.resetValue();
			COMP_QQOT_ADDRESS3.resetValue();
			COMP_QQOT_ADDRESS2.resetValue();
			COMP_QQOT_ADDRESS.resetValue();
			COMP_QQOT_GENDER.resetValue();
			//COMP_QQOT_AGE.setDisabled(true);

			/*helper.POL_ASSRD_REF_ID1_WHEN_VALIDATE_ITEM(compositeAction,
					(String) value);
			 */
		} catch (Exception exception) {
			exception.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exception.getMessage());
			this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getErrorMap().put(
					"current", exception.getMessage());
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "POL_ASSRD_REF_ID1", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}



	/*	public void fireFieldValidationPOL_ASSRD_REF_ID1(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		if (value == null || "".trim().equals(value)) {
			COMP_POL_ASSRD_REF_ID2.setRequired(true);
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_ASSRD_REF_ID1(null);
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	 */

	public void validateQUOT_CUST_CODE(FacesContext context,
			UIComponent component, Object object) {

		try {
			System.out.println("validateQUOT_CUST_CODE");
			Map<String, Object> session = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			String divn=(String)session.get("GLOBAL.M_DIVN_CODE");
			PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
			pkg_pilt002_apac.P_VAL_CLASS_CUST("CUSTOMER",
					(String) object, "",
					PILT002_APAC_CONSTANTS.P_NAME_FLAG,
					PILT002_APAC_CONSTANTS.P_ERR_FLAG,
					divn);

			PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_CODE((String) object);
			//dhinesh
			//	COMP_QQOT_ASSR_CODE.resetValue();
			//COMP_QQOT_ASSURED_NAME.resetValue();
			PW_IL_QUICK_QUOTE_DTLS_BEAN.setQQAD_ASSR_CODE(PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_CODE());
			System.out.println("CUST_CODE "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_CODE());
			//	helper.whenValidatePOL_CUST_CODE(PW_IL_QUICK_QUOTE_BEAN);
			/*	COMP_QUOT_CUST_TITLE.resetValue();
			COMP_QUOT_CUST_NAME.resetValue();
			//COMP_QUOT_CUST_ADDR.resetValue();
			//COMP_QUOT_CUST_CITY.resetValue();
			//COMP_UI_QUOT_CUST_CITY_DESC.resetValue();
			COMP_QUOT_CUST_STATE.resetValue();
			COMP_QUOT_CUST_PO.resetValue();
			COMP_QUOT_CUST_PHONE.resetValue();
			COMP_QUOT_CUST_MAIL_ID.resetValue();*/

		} catch (Exception e) {
			String error = ErrorHelpUtil
					.getUserErrorMessageFromDBErrorMessage(e.getMessage());
			throw new ValidatorException(new FacesMessage(error));
		}
	}





	/*public void ValidationQUOT_CUST_TITLE(ActionEvent event) {
		System.out.println("*************Entered into fireFieldValidation************");
		UIInput input = (UIInput) event.getComponent().getParent();

		PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_TITLE((String)input.getSubmittedValue());


		System.out.println("title "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_TITLE());

		System.out.println("ValidationQUOT_CUST_TITLE......."+ PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_TITLE());

	}

	 */

	
	/*Commentted by saritha on 25-01-2017 for On entering the Salutation,the respective Gender to be defaulted in Quotation Screen*/
	/*public void ValidationQUOT_CUST_TITLE(FacesContext context,
			UIComponent component, Object object) {


		PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_TITLE((String)object);
		System.out.println("title "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_TITLE());


	}*/
	
	/*End*/
	
	
	/*Added by saritha on 25-01-2017 for On entering the Salutation,the respective Gender to be defaulted in Quotation Screen*/
	public void ValidationQUOT_CUST_TITLE(FacesContext context,
			UIComponent component, Object object) {
		try {
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_TITLE((String) COMP_QUOT_CUST_TITLE.getSubmittedValue());
			System.out.println("Quot cust title "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_TITLE());
			helper.when_validate_item_QUOT_CUST_TITLE(PW_IL_QUICK_QUOTE_DTLS_BEAN,PW_IL_QUICK_QUOTE_BEAN);	
			COMP_QQOT_GENDER.resetValue();

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	
	/*End*/
	

	public void ValidationQUOT_MOP(FacesContext context,
			UIComponent component, Object object) {

		String mop = (String)object;
		PW_IL_QUICK_QUOTE_BEAN.setQUOT_MOP((String)object);
		System.out.println("MOB "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_MOP());
		try {
			/*Commented by Ram on 05/11/2016 for FALCONLIFE-1350739
			 * 
			 * helper.QUOT_MODE_OF_PYMT_WHEN_VALIDATE_ITEM(compositeAction,
					(String) object);
			COMP_QUOT_PREM_PAY_YRS.resetValue();
			End
			*/
			/*if(PW_IL_QUICK_QUOTE_BEAN.getQUOT_PROD_CODE() != null && mop != null)
			{
				if(PW_IL_QUICK_QUOTE_BEAN.getQUOT_PROD_CODE().equals("100") && mop.equals("S"))
				{
					throw new Exception("Single Frequency is not Allowed for Product Code "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_PROD_CODE());
				}
			}*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.printStackTrace();
			getErrorMap().put("current",
					e.getMessage());
			getErrorMap().put("date",
					e.getMessage());
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	public void validateQQAT_CUST_NAME(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_NAME((String) value);
			getPW_IL_QUICK_QUOTE_DTLS_BEAN().setQQAD_ASSURED_NAME(PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_NAME());
			COMP_QQAD_ASSURED_NAME.resetValue();

			System.out.println("cust name .... "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_NAME());

			/*helper.POL_ASSRD_REF_ID1_WHEN_VALIDATE_ITEM(compositeAction,
					(String) value);
		COMP_POL_ASSRD_REF_ID1.resetValue();
			COMP_POL_CUST_CODE.resetValue();
			COMP_POL_CONT_CODE.resetValue();
			COMP_POL_ASSURED_NAME.resetValue();
			COMP_POL_RES_ADDRESS_1.resetValue();
			COMP_POL_RES_ADDRESS_2.resetValue();
			COMP_POL_RES_ADDRESS_3.resetValue();
			COMP_POL_RES_PHONE_NO.resetValue();
			COMP_POL_FAX_NO.resetValue();
			COMP_POL_RES_AREA_CODE.resetValue();
			COMP_POL_FAX_AREA_CODE.resetValue();
			COMP_POL_STATE_CODE.resetValue();
			COMP_POL_COUNT_CODE.resetValue();
			COMP_POL_MOBILE_NO.resetValue();
			COMP_UI_M_POL_CITY_NAME.resetValue();
			COMP_UI_M_POL_STATE_NAME.resetValue();
			COMP_UI_M_POL_COUNT_NAME.resetValue();
			COMP_POL_SRC_OF_BUS.resetValue();
			COMP_POL_ASSRD_REF_ID2.resetValue();*/
			/*Added by Ram on 30/12/2016 for Existing customer validation*/
			this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getWarningMap().clear();
			helper.checkExistingUser(compositeAction,compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN(),null,compositeAction.
					getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN());
			if(PW_IL_QUICK_QUOTE_BEAN.getEXISTING_COUNT() > 0)
			{
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"Same customer is already exists in our system. Quotation No is "+PW_IL_QUICK_QUOTE_BEAN.getEXIST_QUOT_NO());
				getWarningMap().put("postRecord", "Same customer is already exists in our system. Quotation No is "+PW_IL_QUICK_QUOTE_BEAN.getEXIST_QUOT_NO());
			}
			/*End*/
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "POL_ASSRD_REF_ID1", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	public void fireFieldValidationQQAT_CUST_NAME(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		if (value == null || "".trim().equals(value)) {
			/*COMP_POL_ASSRD_REF_ID2.setRequired(true);*/
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_NAME(null);
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void fireFieldValidationQQAT_CUST_LAST_NAME(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		if (value == null || "".trim().equals(value)) {
			/*COMP_POL_ASSRD_REF_ID2.setRequired(true);*/
			/*Modified by Ram on 17/01/2017
			 * PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_NAME(null);*/
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_SURNAME(null);
			/*End*/

		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}


	public void validateQUOT_SRC_BUS(FacesContext context,
			UIComponent component, Object object) {
		String Query = "SELECT PC_CODE,PC_DESC  FROM PM_CODES  WHERE  "
				+ " PC_TYPE = 'SRC_BUS_TY' AND PC_CODE = ? ";
		try {

			PW_IL_QUICK_QUOTE_BEAN.setUI_QUOT_SRC_BUS_DESC(helper
					.P_VAL_CODE_CHECK(Query, new Object[] { object }));
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_SRC_BUS((String) object);
			String srcdata=PW_IL_QUICK_QUOTE_BEAN.getQUOT_SRC_BUS();

			if(srcdata.equalsIgnoreCase("075"))
			{
				System.out.println("inside if condtion of validateQUOT_SRC_BUS");
				COMP_QUOT_SRC_CODE.setRequired(true);
				COMP_QUOT_SRC_CODE.setDisabled(false);				
				//COMP_QUOT_SRC_BUS_A4J.setOncomplete("setFocus('PW_IL_POLICY:QUOT_SRC_CODE','PW_IL_POLICY:QUOT_SRC_BUS')");
				System.out.println("Required status  "+COMP_QUOT_SRC_CODE.isRequired());
			}
			else{
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_SRC_CODE(null);
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_SO_CODE(null);
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_SM_CODE(null);
				PW_IL_QQUOT_BROK_DTL_BEAN.setQQBD_RATE(null);
				PW_IL_QQUOT_BROK_DTL_BEAN.setQQBD_RATE_PER(null);
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_COMM_VALUE(null);
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_ORG_BROK_CODE(null);
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_ORG_COMM_RATE(null);

				COMP_QUOT_SO_CODE.resetValue();
				COMP_QUOT_SM_CODE.resetValue();
				COMP_QUOT_AGENT_COMM_RATE.resetValue();
				COMP_QUOT_AGENT_COMM_VALUE.resetValue();
				COMP_QUOT_COMM_VALUE.resetValue();

				COMP_QUOT_SRC_CODE.setRequired(false);
				COMP_QUOT_SRC_CODE.setDisabled(true);


			}

			COMP_QUOT_SRC_CODE.resetValue();
			COMP_UI_QUOT_SRC_BUS_DESC.resetValue();
			if(srcdata.equalsIgnoreCase("001")){
				COMP_QUOT_SRC_BUS_A4J.setOncomplete("");
			}	
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateQUOT_SRC_CODE(FacesContext context,
			UIComponent component, Object object) {

		System.out.println("QUOT_SRC_CODE");
		String Query = "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE = ? ";
		try {		
			PW_IL_QUICK_QUOTE_BEAN.setUI_QUOT_SRC_CODE_DESC(helper
					.P_VAL_CODE_CHECK(Query, new Object[] { object }));
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_SRC_CODE((String) object);
			System.out.println("validateQUOT_SRC_CODE "+	PW_IL_QUICK_QUOTE_BEAN.getQUOT_SRC_CODE());
			COMP_UI_QUOT_SRC_CODE_DESC.resetValue();

			/*System.out.println("getPW_IL_QUICK_QUOTE_BEAN().Rowid          "+getPW_IL_QUICK_QUOTE_BEAN().getROWID());
			if(getPW_IL_QUICK_QUOTE_BEAN().getROWID() == null)
			{*/
			getPW_IL_QUICK_QUOTE_BEAN().setQUOT_SO_CODE(null);
			getPW_IL_QUICK_QUOTE_BEAN().setQUOT_SM_CODE(null);	
			COMP_QUOT_SO_CODE.resetValue();
			COMP_QUOT_SM_CODE.resetValue();
			/*}*/


		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	// Suggestion Lists

	public List<LovBean> lovQUOT_CUST_CITY(Object event) {
		ListItemUtil itemUtil = new ListItemUtil();
		ArrayList<LovBean> suggestionList = null;
		String Query = "SELECT PC_CODE,PC_DESC  FROM PM_CODES WHERE PC_TYPE = 'CITY'  AND (PC_CODE LIKE ? OR PC_DESC LIKE ?) AND  ROWNUM < 25 ORDER BY 1";
		String currentValue = (String) event;

		currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
		try {
			suggestionList = itemUtil.prepareSuggestionList(Query,
					new Object[] { currentValue, currentValue });
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("POL_CITY_SUGGESTIONS", e.getMessage());
		}
		return suggestionList;
	}

	public List<LovBean> lovQUOT_CUST_CODE(Object event) {
		ListItemUtil itemUtil = new ListItemUtil();
		ArrayList<LovBean> suggestionList = null;
		String Query = "SELECT CUST_CODE, CUST_NAME FROM PM_CUSTOMER "
				+ " WHERE    CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS, "
				+ "PP_SYSTEM  WHERE  PS_CODE = 'BROKER' AND PS_TYPE ='LOV_CUST')   "
				+ "AND CUST_FRZ_FLAG = 'N'   AND (CUST_CODE LIKE ? OR CUST_NAME LIKE ?  "
				+ "  )   AND  ROWNUM < 25 order by 1";
		String currentValue = (String) event;

		currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
		try {
			suggestionList = itemUtil.prepareSuggestionList(Query,
					new Object[] { currentValue, currentValue });
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SRC_BUS_SUGGESTIONS", e.getMessage());
		}
		return suggestionList;
	}


	public List<LovBean> lovQUOT_CUST_NAME(Object event) {
		ListItemUtil itemUtil = new ListItemUtil();
		ArrayList<LovBean> suggestionList = null;
		/*
		 * 
		 * commented by ameen for FALCONLIFE-1344105 on 07-10-2016
		 * 
		 * String Query = "SELECT CUST_FIRST_NAME,CUST_SURNAME FROM PM_CUSTOMER "
				+ " WHERE    CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS, "
				+ "PP_SYSTEM  WHERE  PS_CODE = 'BROKER' AND PS_TYPE ='LOV_CUST')   "
				+ "AND CUST_FRZ_FLAG = 'N'   AND (CUST_CODE LIKE ? OR CUST_NAME LIKE ?  "
				+ "  )   AND  ROWNUM < 25 order by 1";*/
		
		/*Added by ameen for FALCONLIFE-1344105 on 07-10-2016*/
		/*String Query = "SELECT CUST_FIRST_NAME, CUST_SURNAME FROM PM_CUSTOMER WHERE CUST_CLASS IN (SELECT CCLAS_CODE "
				+ "FROM PM_CUST_CLASS, PP_SYSTEM  WHERE PS_CODE = 'BROKER' AND PS_TYPE = 'LOV_CUST') "
				+ "AND CUST_FRZ_FLAG = 'N'  AND (upper(CUST_CODE) LIKE upper(?) OR CUST_NAME LIKE upper(?)) "
				+ "AND ROWNUM < 25 order by 1";*/
		/*end*/
		/*Query Changed by Ram on 20/12/2016 for Display Customer name from QuickQuote table also*/
		String Query = " SELECT CUST_FIRST_NAME, CUST_SURNAME FROM PM_CUSTOMER WHERE CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM "
				+ "WHERE PS_CODE = 'BROKER' AND PS_TYPE = 'LOV_CUST') AND CUST_FRZ_FLAG = 'N' AND (upper(CUST_CODE) LIKE upper(?) OR CUST_NAME LIKE upper(?)) "
				+ " AND ROWNUM < 25 UNION SELECT QUOT_CUST_NAME ,QUOT_CUST_SURNAME FROM PW_IL_QUICK_QUOTE WHERE NVL(QUOT_CONV_YN,'N') = 'N' AND (upper(QUOT_CUST_CODE)"
				+ " LIKE upper(?)"
				+ " OR QUOT_CUST_NAME LIKE upper(?)) AND ROWNUM < 25 order by 1";
		/*End*/
		String currentValue = (String) event;

		currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
		try {
			/*Changed by Ram on 20/12/2016 for Display Customer name from QuickQuote table also
			 * 
			 * suggestionList = itemUtil.prepareSuggestionList(Query,
					new Object[] { currentValue, currentValue });*/
			System.out.println("currentValue     "+currentValue);
			suggestionList = itemUtil.prepareSuggestionList(Query,
					new Object[] { currentValue, currentValue, currentValue, currentValue });
			System.out.println("suggestionList           "+suggestionList);
			/*End*/
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SRC_BUS_SUGGESTIONS", e.getMessage());
		}
		return suggestionList;
	}

	public List<LovBean> lovQUOT_CUST_STATE(Object event) {
		ListItemUtil itemUtil = new ListItemUtil();
		ArrayList<LovBean> suggestionList = null;
		String Query = "SELECT PC_CODE,PC_DESC  FROM PM_CODES WHERE PC_TYPE = 'STATE' AND (PC_CODE LIKE ? OR PC_DESC LIKE ?) AND  ROWNUM < 25 ORDER BY 1";
		String currentValue = (String) event;

		currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
		try {
			suggestionList = itemUtil.prepareSuggestionList(Query,
					new Object[] { currentValue, currentValue });
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("POL_CITY_SUGGESTIONS", e.getMessage());
		}
		return suggestionList;
	}

	/*end*/

	public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_PROD_GROUP_CODE(
			Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
					"PT_IL_POLICY", "POL_PROD_GROUP_CODE", null, null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	/*	public List<LovBean> lovQUOT_SRC_CODE(Object event) {
		ListItemUtil itemUtil = new ListItemUtil();
		ArrayList<LovBean> suggestionList = null;
		String Query = "SELECT CUST_CODE, CUST_NAME, CUST_BL_NAME FROM PM_CUSTOMER "
				+ " WHERE    CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS, "
				+ "PP_SYSTEM  WHERE  PS_CODE = 'BROKER' AND PS_TYPE ='LOV_CUST')   "
				+ "AND CUST_FRZ_FLAG = 'N'   AND (CUST_CODE LIKE ? OR CUST_NAME LIKE ?  "
				+ " OR  CUST_BL_NAME LIKE ?)   AND  ROWNUM < 25 order by 1";
		String currentValue = (String) event;

		currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
		try {
			suggestionList = itemUtil.prepareSuggestionList(Query,
					new Object[] { currentValue, currentValue, currentValue });
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SRC_BUS_SUGGESTIONS", e.getMessage());
		}
		return suggestionList;
	}
	 */







	

	public ArrayList<LovBean> prepareSuggestionList_BROKER_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		Connection connection = null;
		ResultSet resultSet = null;
		String currentValue = (String) object;
		String query1value = null;
		String query1 = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'LOV_CUST' "
				+ "AND PS_CODE = 'IL_BROKER'";
		String query2 = null;

		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query1,
					connection);
			if (resultSet.next()) {
				query1value = resultSet.getString(1);
			}
			/*query2 = "SELECT CUST_CODE, CUST_NAME, CUST_BL_NAME FROM PM_CUSTOMER WHERE CUST_CLASS "
					+ "IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM WHERE DECODE "
					+ "(PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE) IN ("
					+ query1value
					+ ") AND PS_CODE = 'IL_BROKER' "
					+ "AND PS_TYPE ='LOV_CUST') AND CUST_FRZ_FLAG = 'N' AND ((CUST_CODE IN (SELECT "
					+ "CDIV_CUST_CODE FROM PM_CUST_DIVN WHERE CDIV_DIVN_CODE = NVL(?, CDIV_DIVN_CODE) AND "
					+ "CUST_APPL_ALL_BRAN_YN = 'N'))OR (CUST_APPL_ALL_BRAN_YN = 'Y')) AND "
					+ "(CUST_CODE LIKE ? OR  CUST_NAME LIKE ? OR  CUST_BL_NAME LIKE ?) AND ROWNUM < 25 ORDER BY 1";*/
			// added by ameen for ssp call id FALCONLIFE-1344105 on 15-10-16
			/*query2 = "SELECT CUST_CODE, CUST_NAME, CUST_BL_NAME FROM PM_CUSTOMER WHERE CUST_CLASS "
					+ "IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM WHERE DECODE "
					+ "(PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE) IN ("
					+ query1value
					+ ") AND PS_CODE = 'IL_BROKER' "
					+ "AND PS_TYPE ='LOV_CUST') AND CUST_FRZ_FLAG = 'N' AND ((CUST_CODE IN (SELECT "
					+ "CDIV_CUST_CODE FROM PM_CUST_DIVN WHERE CDIV_DIVN_CODE = NVL(?, CDIV_DIVN_CODE) AND "
					+ "CUST_APPL_ALL_BRAN_YN = 'N'))OR (CUST_APPL_ALL_BRAN_YN = 'Y')) AND "
					+ "(UPPER(CUST_CODE) LIKE UPPER(?) OR UPPER(CUST_NAME) LIKE UPPER(?) OR UPPER(CUST_BL_NAME) LIKE UPPER(?)) AND ROWNUM < 25 ORDER BY 1";*/
			
			/*Modifiesd by Ram on 03/11/2016 for Agent issue (Only Remove OR (CUST_APPL_ALL_BRAN_YN = 'Y') )*/
			query2 = "SELECT CUST_CODE, CUST_NAME, CUST_BL_NAME FROM PM_CUSTOMER WHERE CUST_CLASS "
					+ "IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM WHERE DECODE "
					+ "(PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE) IN ("
					+ query1value
					+ ") AND PS_CODE = 'IL_BROKER' "
					+ "AND PS_TYPE ='LOV_CUST') AND CUST_FRZ_FLAG = 'N' AND ((CUST_CODE IN (SELECT "
					+ "CDIV_CUST_CODE FROM PM_CUST_DIVN WHERE CDIV_DIVN_CODE = NVL(?, CDIV_DIVN_CODE) AND "
					+ "CUST_APPL_ALL_BRAN_YN = 'N')) ) AND "
					+ "(UPPER(CUST_CODE) LIKE UPPER(?) OR UPPER(CUST_NAME) LIKE UPPER(?) OR UPPER(CUST_BL_NAME) LIKE UPPER(?)) AND ROWNUM < 25 ORDER BY 1";
			/*End*/
			
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = ListItemUtil.prepareSuggestionList(query2, new Object[] {
					CommonUtils
					.getGlobalVariable("GLOBAL.M_DIVN_CODE"),
					currentValue, currentValue, currentValue });
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public List<LovBean> lovQUOT_SRC_BUS(Object event) {
		ListItemUtil itemUtil = new ListItemUtil();
		ArrayList<LovBean> suggestionList = null;

		try {
			suggestionList = itemUtil.P_CALL_LOV("PILT002_APAC",
					"PT_IL_POLICY", "POL_SRC_OF_BUS", "SRC_BUS_TY", null, null,
					null, null, (String) event);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SRC_BUS_SUGGESTIONS", e.getMessage());
		}
		return suggestionList;
	}

	public HtmlOutputLabel getCOMP_QUOT_PERIOD_LABEL() {
		return COMP_QUOT_PERIOD_LABEL;
	}

	public void setCOMP_QUOT_PERIOD_LABEL(HtmlOutputLabel comp_quot_period_label) {
		COMP_QUOT_PERIOD_LABEL = comp_quot_period_label;
	}

	public HtmlInputText getCOMP_QUOT_PERIOD() {
		return COMP_QUOT_PERIOD;
	}

	public void setCOMP_QUOT_PERIOD(HtmlInputText comp_quot_period) {
		COMP_QUOT_PERIOD = comp_quot_period;
	}

	public HtmlOutputLabel getCOMP_QUOT_PREM_PAY_YRS_LABEL() {
		return COMP_QUOT_PREM_PAY_YRS_LABEL;
	}

	public void setCOMP_QUOT_PREM_PAY_YRS_LABEL(
			HtmlOutputLabel comp_quot_prem_pay_yrs_label) {
		COMP_QUOT_PREM_PAY_YRS_LABEL = comp_quot_prem_pay_yrs_label;
	}

	public HtmlInputText getCOMP_QUOT_PREM_PAY_YRS() {
		return COMP_QUOT_PREM_PAY_YRS;
	}

	public void setCOMP_QUOT_PREM_PAY_YRS(HtmlInputText comp_quot_prem_pay_yrs) {
		COMP_QUOT_PREM_PAY_YRS = comp_quot_prem_pay_yrs;
	}


	public HtmlInputText getCOMP_UI_QUOT_SRC_BUS_DESC() {
		return COMP_UI_QUOT_SRC_BUS_DESC;
	}

	public void setCOMP_UI_QUOT_SRC_BUS_DESC(HtmlInputText comp_ui_quot_src_bus_desc) {
		COMP_UI_QUOT_SRC_BUS_DESC = comp_ui_quot_src_bus_desc;
	}

	public HtmlInputText getCOMP_UI_QUOT_SRC_CODE_DESC() {
		return COMP_UI_QUOT_SRC_CODE_DESC;
	}

	public void setCOMP_UI_QUOT_SRC_CODE_DESC(
			HtmlInputText comp_ui_quot_src_code_desc) {
		COMP_UI_QUOT_SRC_CODE_DESC = comp_ui_quot_src_code_desc;
	}



	//class getter setter


	public PW_IL_QQUOT_ASSURED_DTLS getPW_IL_QUICK_QUOTE_DTLS_BEAN() {
		return PW_IL_QUICK_QUOTE_DTLS_BEAN;
	}

	public void setPW_IL_QUICK_QUOTE_DTLS_BEAN(
			PW_IL_QQUOT_ASSURED_DTLS pW_IL_QUICK_QUOTE_DTLS_BEAN) {
		PW_IL_QUICK_QUOTE_DTLS_BEAN = pW_IL_QUICK_QUOTE_DTLS_BEAN;
	}

	//END

	public void validatePOL_PROD_CODE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		/*try {
			// PT_IL_POLICY_BEAN.setPOL_PROD_CODE((String)value);
			helper.POL_PROD_CODE_WHEN_VALIDATE_ITEM(compositeAction,
					(String) value, CommonUtils.nvl(PT_IL_POLICY_BEAN
							.getPOL_PROD_CODE(), ""));

			PT_IL_POLICY_BEAN.setPOL_PROD_CODE((String) value);
			// COMP_POL_PROD_CODE.resetValue();



		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "POL_PROD_CODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
		System.out.println("validation");
	}

	public ArrayList<com.iii.premia.common.bean.LovBean> lovQUOT_PROD_CODE(
			Object currValue) {
		System.out.println("Welcome to lovPOL_PROD_CODE method");
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			/*Changed by Ram on 13/11/2016 for Dynamic Quick Quote Product
			 * 
			 * suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
					"PT_IL_POLICY", "POL_PROD_CODE", null, null, null, null,
					null, (String) currValue);*/
			System.out.println("GLOBAL.M_PARAM_2         "+CommonUtils.getGlobalObject("GLOBAL.M_PARAM_2"));
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
					"PT_IL_POLICY", "POL_PROD_CODE", CommonUtils.getGlobalObject("GLOBAL.M_PARAM_2"), null, null, null,
					null, (String) currValue);
			
			System.out.println("suggestionList     "+suggestionList);
			
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public void POAD_ASSR_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {

		try {
			//COMP_QQOT_ASSR_CODE.resetValue();
			//COMP_QQOT_ASSR_CODE.setDisabled(true);
			//COMP_QQOT_ASSURED_NAME.resetValue();
			getPW_IL_QUICK_QUOTE_DTLS_BEAN().setQQAD_ASSR_CODE((String) value);
			/*helper.POAD_ASSR_CODE_WHEN_VALIDATE_ITEM(compositeAction,
					getPT_IL_POL_ASSURED_DTLS_BEAN());
			COMP_POAD_ASSURED_NAME.resetValue();*/
			System.out.println("bean "+getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_ASSR_CODE());

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}	

	public ArrayList<LovBean> prepareSuggestionList_ASSR_CODE(Object object){
		System.out.println("sankar");
		//public ArrayList<LovBean> prepareSuggestionList_ASSR_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		String query = "SELECT CONT_CODE,CONT_NAME,CONT_CUST_CODE FROM PM_IL_CONTRACTOR  WHERE CONT_FRZ_FLAG = 'N' "
				+ "AND (CONT_CODE LIKE ? OR CONT_NAME LIKE ?) AND ROWNUM < ?";
		Object[] values = null;
		String currentValue = (String) object;

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			values = new Object[] { currentValue, currentValue,
					PELConstants.suggetionRecordSize };
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}


	public void POAD_HEIGHT_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getWarningMap().clear();
		//	compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		Double POAD_HEIGHT = (Double) value;
		try {
			getPW_IL_QUICK_QUOTE_DTLS_BEAN().setQQAD_HEIGHT(POAD_HEIGHT);
			System.out.println("height  "+"POAD_HEIGHT"+POAD_HEIGHT	+getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_HEIGHT());
			COMP_QQOT_BMI.resetValue();
			helper.POAD_HEIGHT_WHEN_VALIDATE_ITEM(POAD_HEIGHT,
					getPW_IL_QUICK_QUOTE_DTLS_BEAN());
			getPW_IL_QUICK_QUOTE_DTLS_BEAN().setQQAD_HEIGHT(POAD_HEIGHT);



		} catch (Exception e) {
			//throw new ValidatorException(new FacesMessage(e.getMessage()));
			this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getWarningMap().put(
					"current", e.getMessage());
		}
	}



	public void QQAD_BMI_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		try{
			System.out.println("****Entered into bmi validation***");
			helper.QQAD_BMI_VALIDATE_ITEM(getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_BMI());

			System.out.println(getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_BMI());
			//helper.POAD_BMI_VALIDATE_ITEM(this);


		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}



	public void POAD_ADDRESS_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		//	compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_ADDR1((String) value);
		try {


			System.out.println("Address"+	getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_ADDRESSS());

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}




	public void POAD_ADDRESS2_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		//	compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_ADDR2((String) value);
		COMP_QQOT_ADDRESS2.resetValue();
		try {


			System.out.println("Address2 scd  "+	PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_ADDR2());

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}




	public void POAD_ADDRESS3_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		//	compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_ADDR3((String) value);
		COMP_QQOT_ADDRESS3.resetValue();
		try {


			System.out.println("Address"+	PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_ADDR3());

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}




	public void QQAD_AGENT_CRATE_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		//	compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		Double AGENTRATE=((Double) value);
		getPW_IL_QQUOT_BROK_DTL_BEAN().setQQBD_RATE(AGENTRATE);
		try {


			System.out.println("AGENTRATE"+		getPW_IL_QQUOT_BROK_DTL_BEAN().getQQBD_RATE());

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void QQAD_AVALUE_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		//	compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		Double AGENTRATEPER=((Double) value);
		getPW_IL_QQUOT_BROK_DTL_BEAN().setQQBD_RATE_PER(AGENTRATEPER);

		try {


			System.out.println("AGENTRATEPER"+	getPW_IL_QQUOT_BROK_DTL_BEAN().getQQBD_RATE_PER());

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	public ArrayList<LovBean> prepareSuggestionList_POAD_OCC_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_ASSURED_DTLS";
		String fieldName = "POAD_OCC_CODE";
		Object param1 = "IL_OCCU";

		try {
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,
					param1, null, null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}


	public void POAD_OCC_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		String POAD_OCC_CODE = (String) value;
		try {

			getPW_IL_QUICK_QUOTE_DTLS_BEAN().setQQAD_ASSR_OCC_CODE(POAD_OCC_CODE);
			/*helper.POAD_OCC_CODE_WHEN_VALIDATE_ITEM(POAD_OCC_CODE,
						PT_IL_POL_ASSURED_DTLS_BEAN);
				COMP_UI_M_POAD_OCC_DESC.resetValue();
				COMP_POAD_OCC_CLASS.resetValue();
				COMP_UI_M_POAD_OCC_CLASS_DESC.resetValue();*/
			System.out.println("code"+getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_ASSR_OCC_CODE());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POAD_WEIGHT_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		System.out.println("weight ");
		this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getWarningMap().clear();
		//compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		Double POAD_WEIGHT = (Double) value;
		getPW_IL_QUICK_QUOTE_DTLS_BEAN().setQQAD_WEIGHT(POAD_WEIGHT);
		System.out.println("weight"+"POAD_WEIGHT"+POAD_WEIGHT+"1111111"+getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_WEIGHT());
		try {
			COMP_QQOT_BMI.resetValue();
			helper.POAD_WEIGHT_WHEN_VALIDATE_ITEM(POAD_WEIGHT,
					getPW_IL_QUICK_QUOTE_DTLS_BEAN());


		} catch (Exception e) {
			/*this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getWarningMap().clear();
			this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getWarningMap().put(
					"current", e.getMessage());*/

			getWarningMap().put("current",e.getMessage());


			//throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}



	public void POAD_AGE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		//compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();

		Integer POAD_AGE = (Integer) value;
		try {
			/*	helper.POAD_AGE_WHEN_VALIDATE_ITEM(compositeAction,POAD_AGE,
						getPT_IL_POL_ASSURED_DTLS_BEAN(), compositeAction
								.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
								.getPT_IL_POL_ASSURED_DTLS_1_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN()
								.getPT_IL_POLICY_BEAN(), compositeAction
								.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
						compositeAction
								.getPT_IL_POL_SA_INST_PYMT_HEAD_ACTION_BEAN()
								.getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN());*/

			getPW_IL_QUICK_QUOTE_DTLS_BEAN().setQQAD_AGE(POAD_AGE);


			System.out.println("age"+getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_AGE());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	public void QQAD_GENDER_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		//compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();

		String QQAD_GEender = (String) value;
		System.out.println("QQAD_GEender        "+QQAD_GEender);
		try {
			/*	helper.POAD_AGE_WHEN_VALIDATE_ITEM(compositeAction,POAD_AGE,
						getPT_IL_POL_ASSURED_DTLS_BEAN(), compositeAction
								.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
								.getPT_IL_POL_ASSURED_DTLS_1_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN()
								.getPT_IL_POLICY_BEAN(), compositeAction
								.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
						compositeAction
								.getPT_IL_POL_SA_INST_PYMT_HEAD_ACTION_BEAN()
								.getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN());*/

			getPW_IL_QUICK_QUOTE_DTLS_BEAN().setQQAD_CATG_CODE(QQAD_GEender);
			/*Added by Ram on 21/01/2017 for Praganancy field capturing*/
			enablePraganacyField();
			if(PW_IL_QUICK_QUOTE_DTLS_BEAN.getQQAD_CATG_CODE() != null && !PW_IL_QUICK_QUOTE_DTLS_BEAN.getQQAD_CATG_CODE().equalsIgnoreCase("2"))
			{
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQUOT_PRAGANENT_YN("N");
			}
			COMP_PRAGANANCY.resetValue();
			/*End*/


			System.out.println("age"+getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_CATG_CODE());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	public void POAD_DOB_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {

		Date POAD_DOB = (Date) value;
		try {
			getPW_IL_QUICK_QUOTE_DTLS_BEAN().setQQAD_ASSR_DOB(POAD_DOB);

			//COMP_QQOT_AGE.resetValue();
			System.out.println("DOB "+getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_ASSR_DOB());
			helper.POAD_DOB_WHEN_VALIDATE_ITEM(compositeAction,compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN(),POAD_DOB,compositeAction.
					getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN());

			//helper.POAD_DOB_WHEN_VALIDATE_ITEM();
			COMP_QUOT_DOB.resetValue();
			COMP_QQOT_AGE.resetValue();
			/*Added by Ram on 30/12/2016 for Existing customer validation*/
			getWarningMap().clear();
			helper.checkExistingUser(compositeAction,compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN(),null,compositeAction.
					getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN());
			if(PW_IL_QUICK_QUOTE_BEAN.getEXISTING_COUNT() > 0)
			{
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"Same customer is already exists in our system. Quotation No is "+PW_IL_QUICK_QUOTE_BEAN.getEXIST_QUOT_NO());
				getWarningMap().put("postRecord", "Same customer is already exists in our system. Quotation No is "+PW_IL_QUICK_QUOTE_BEAN.getEXIST_QUOT_NO());
			}
			/*End*/


		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("postRecord", exc.getMessage());
			throw new ValidatorException(new FacesMessage(exc.getMessage()));
			//getErrorMap().put("", "");
		}
	}



	public void initializeallcomponent()
	{


		COMP_QUOT_ISS_DT_LABEL=new HtmlOutputLabel();
		COMP_QUOT_ISS_DT=new HtmlCalendar();
		COMP_QUOT_PROD_CODE_LABEL=new HtmlOutputLabel();
		COMP_QUOT_PROD_CODE=new HtmlInputText();
		COMP_QUOT_FM_DT_LABEL=new HtmlOutputLabel();
		COMP_QUOT_FM_DT=new HtmlCalendar();
		COMP_QUOT_TO_DT_LABEL=new HtmlOutputLabel();
		COMP_QUOT_TO_DT=new HtmlCalendar();
		COMP_UI_M_APPRV_STATUS= new HtmlOutputText();

		/*private HtmlOutputLabel COMP_QUOT_NEW_CUST_YN_LABEL;
			private HtmlSelectBooleanCheckbox COMP_QUOT_NEW_CUST_YN;*/
		COMP_QUOT_CUST_TITLE_LABEL=new HtmlOutputLabel();
		COMP_QUOT_CUST_TITLE=new HtmlSelectOneMenu();
		COMP_QUOT_CUST_NAME_LABEL=new HtmlOutputLabel();
		COMP_QUOT_CUST_NAME=new HtmlInputText();
		COMP_QUOT_CUST_LAST_NAME_LABEL=new HtmlOutputLabel();
		COMP_QUOT_CUST_LAST_NAME=new HtmlInputText();
		COMP_QUOT_CUST_CODE_LABEL=new HtmlOutputLabel();
		COMP_QUOT_CUST_CODE=new HtmlInputText();

		COMP_QUOT_NEW_IC_LABEL=new HtmlOutputLabel();
		COMP_QUOT_NEW_IC=new HtmlInputText();
		COMP_QUOT_DOB_LABEL=new HtmlOutputLabel();
		COMP_QUOT_DOB=new HtmlCalendar();
		COMP_QQOT_AGE_LABEL=new HtmlOutputLabel();
		COMP_QQOT_AGE=new HtmlInputText();
		COMP_QQOT_GENDER_LABLE=new HtmlOutputLabel();
		COMP_QQOT_GENDER=new HtmlSelectOneMenu();
		COMP_QUOT_FC_SA_LABEL=new HtmlOutputLabel();
		COMP_QUOT_FC_SA=new HtmlInputText();
		COMP_QUOT_PERIOD_LABEL=new HtmlOutputLabel();
		COMP_QUOT_PERIOD=new HtmlInputText();
		COMP_QUOT_PREM_PAY_YRS_LABEL=new HtmlOutputLabel();
		COMP_QUOT_PREM_PAY_YRS=new HtmlInputText();
		COMP_QQOT_FREQUENCY_LABLE=new HtmlOutputLabel();
		COMP_QQOT_FREQUENCY=new HtmlSelectOneMenu();

		COMP_QUOT_SRC_BUS_LABEL=new HtmlOutputLabel();
		COMP_QUOT_SRC_BUS=new HtmlInputText();
		COMP_QUOT_SRC_CODE_LABEL=new HtmlOutputLabel();
		COMP_UI_QUOT_SRC_BUS_DESC=new HtmlInputText();
		COMP_QUOT_SRC_CODE=new HtmlInputText();
		COMP_UI_QUOT_SRC_CODE_DESC=new HtmlInputText();
		COMP_QUOT_NO_LABEL=new HtmlOutputLabel();
		COMP_QUOT_NO=new HtmlInputText();
		COMP_QUOT_IDX_NO_LABEL=new HtmlOutputLabel();
		COMP_QUOT_IDX_NO=new HtmlInputText();
		COMP_QQAT_MEDICAL_YN =new HtmlSelectOneMenu();
		COMP_QQAT_MEDICAL_YN =new HtmlSelectOneMenu();

		/*END*/

		/*	Other Details */
		COMP_QQOT_ASSR_CODE_LABEL=new HtmlOutputLabel() ;
		COMP_QQOT_ASSR_CODE=new HtmlInputText();
		COMP_QQAD_ASSURED_NAME=new HtmlInputText();




		COMP_QQOT_HEIGHT=new HtmlInputText();
		COMP_QQOT_HEIGHT_LABEL=new HtmlOutputLabel();
		COMP_QQOT_WEIGHT=new HtmlInputText();
		COMP_QQOT_WEIGHT_LABEL=new HtmlOutputLabel();
		COMP_QQOT_BMI=new HtmlInputText();
		COMP_QQOT_BMI_Lable=new HtmlOutputLabel();
		COMP_QQOT_ADDRESS=new HtmlInputText();
		COMP_QQOT_ADDRESS_LABLE=new HtmlOutputLabel();

		COMP_QQOT_ADDRESS_LABLE2=new HtmlOutputLabel();
		COMP_QQOT_ADDRESS2=new HtmlInputText();
		COMP_QQOT_ADDRESS_LABLE3=new HtmlOutputLabel();
		COMP_QQOT_ADDRESS3=new HtmlInputText();




		COMP_QQOT_LOAN =new HtmlSelectOneMenu();
		COMP_QQOT_LOAN_LABLE= new HtmlOutputLabel();
		COMP_QUOT_BANK_CODE_LABLE= new HtmlOutputLabel();
		COMP_QUOT_BANK_CODE=new HtmlInputText();
		COMP_QUOT_BANK_DIVN_LABLE= new HtmlOutputLabel();
		COMP_QUOT_BANK_DIVN=new HtmlInputText();
		COMP_QUOT_BANK_ACNT_LABLE= new HtmlOutputLabel();
		COMP_QUOT_BANK_ACNT=new HtmlInputText();

		COMP_QUOT_SO_CODE_LABLE = new HtmlOutputLabel();
		COMP_QUOT_SO_CODE=new HtmlInputText();
		COMP_QUOT_SM_CODE_LABLE= new HtmlOutputLabel();
		COMP_QUOT_SM_CODE=new HtmlInputText();
		COMP_QUOT_AGENT_COMM_RATE_LABLE= new HtmlOutputLabel();
		COMP_QUOT_AGENT_COMM_RATE=new HtmlInputText();
		COMP_QUOT_AGENT_COMM_VALUE_LABLE= new HtmlOutputLabel();
		COMP_QUOT_AGENT_COMM_VALUE=new HtmlInputText();

		COMP_QQAD_GROSS_PREMIUM_LABLE=new HtmlOutputLabel();
		COMP_QQAD_GROSS_PREMIUM=new HtmlInputText(); 

		// data table


		COMP_QQAT_COVER_CODE=new HtmlInputText();
		COMP_UI_M_QQAT_COVER_DESC=new HtmlInputText();
		COMP_ADD_QQAC_RATE=new HtmlInputText();
		COMP_ADD_QQAC_RATE_PER=new HtmlInputText();
		COMP_ADD_QQAC_PREMIUM=new HtmlInputText();
		COMP_ADD_QQAC_SUM_ASS=new HtmlInputText();
		COMP_QQAT_DISC_LOAD_TYPE=new HtmlSelectOneMenu();
		COMP_QQAT_DISC_LOAD_CODE=new HtmlInputText();
		COMP_UI_M_DISCLOAD_DESC=new HtmlInputText();
		COMP_ADD_QQDL_APPLIED_ON=new HtmlSelectOneMenu();
		COMP_ADD_QQDL_RATE=new HtmlInputText();
		COMP_ADD_QQDL_RATE_PER=new HtmlInputText();
		COMP_ADD_QQDL_VALUE=new HtmlInputText();
		COMP_ADD_QQAC_TERM=new HtmlInputText();
		COMP_ADD_QQAC_EMR_RATE_LABEL=new HtmlOutputLabel();
		COMP_ADD_QQAC_EMR_RATE=new HtmlInputText();

		COMP_QQAC_CHRG_CODE=new HtmlInputText();
		UI_M_CHRG_DESC=new HtmlInputText();
		COMP_POC_APPLIED_ON=new HtmlSelectOneMenu();

		COMP_ADD_QQAC_APPLY_PERIOD=new HtmlSelectOneMenu();
		COMP_QQAC_RATE=new HtmlInputText();
		COMP_QQAC_RATE_PER=new HtmlInputText();
		COMP_QQAC_FC_CHRG_AMT=new HtmlInputText();
		COMP_QUOT_COMM_VALUE=new HtmlInputText();
		COMP_QUOT_COMM_VALUE_LABLE=new HtmlOutputLabel();
		HtmlInputText COMP_QQDL_COVER_CODE=new HtmlInputText();
		HtmlInputText COMP_UI_M_QQDL_COVER_DESC=new HtmlInputText();

		COMP_QQAT_EMR_LABEL = new HtmlOutputLabel();
		COMP_EMR = new HtmlInputText();

		/*Added by Ramkumar on 01-08-2016*/
		COMP_SAVE_BUTTON = new HtmlCommandButton();
		/*End*/

		/* Added by ganesh on 11-04-2017 for decline functionality */
		COMP_REPORT_MODAL_PANEL_DECLINE = new HtmlModalPanel();
		COMP_UI_M_MAKE_DECLINE = new HtmlCommandLink();
		/*END*/

		/* Added by ganesh on 14-04-2017 for decline functionality */
		COMP_UI_M_QQT_REMARKS = new HtmlInputTextarea();
		COMP_UI_M_QQS_STATUS = new HtmlInputText();
		/*end*/
	}


	public void Calcpremium()
	{

		String message = null;
		System.out.println("calc premium");
		ArrayList<OracleParameter> pValOrclList = new ArrayList<OracleParameter>();
		try {
			pValOrclList = PKG_PILT002_APAC_QE.P_CALC_PREMIUM(
					CommonUtils.getProcedureValue(PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID()),
					"UI_M_POL_FC_TOT_PREM","getUI_M_POL_LC_TOT_PREM","getUI_M_POL_FC_TOT_LOADING", 
					"getUI_M_POL_LC_TOT_LOADING","UI_M_POL_FC_TOT_DISCOUNT","UI_M_POL_LC_TOT_DISCOUNT",
					"UI_M_FC_PCHARGES_BORNE_CUST","UI_M_LC_PCHARGES_BORNE_CUST","UI_M_FC_PCHARGES_BORNE_COMP",
					"UI_M_LC_PCHARGES_BORNE_COMP","UI_M_FC_SCHARGES_BORNE_CUST","UI_M_LC_SCHARGES_BORNE_CUST",
					"UI_M_FC_SCHARGES_BORNE_COMP","UI_M_LC_SCHARGES_BORNE_COMP","UI_M_POL_FC_NET_PREM",
					"UI_M_POL_LC_NET_PREM","UI_M_POL_INST_FC_PREM","UI_M_POL_INST_LC_PREM","UI_M_POL_FC_MOP",
					"UI_M_POL_LC_MOP","UI_M_POL_FC_GR_ANN_PREM","UI_M_POL_LC_GR_ANN_PREM", "Y");



			//netpremium =helper.updateGrosspre(compositeAction);
			chargetable(compositeAction);
			covertable(compositeAction);
			debittable(compositeAction);
			netpremium=0.0;
			Double commision=0.0;
			String uicomm=null;
			/*
			 * Commented By Dhinesh for apply common decimal convert method on 12.10.2016
			 * 
			 * uicomm=delegate.Decimal_Convert(Double.toString(commision));*/
			
			uicomm=CommonUtils.Decimal_Convert(Double.toString(commision));
			System.out.println("uicomm Value : "+uicomm);

			netpremium=netpremium+delegate.calculatenetpremium(compositeAction);
			System.out.println("After calculatenetpremium  : "+netpremium);
		/*	
		 * 
		 *  Commented By Dhinesh for apply common decimal convert method on 12.10.2016
		 * 
		 * String net_premium = helper.Decimal_Convert(Double.toString(netpremium));
		 */
			String net_premium = CommonUtils.Decimal_Convert(Double.toString(netpremium));
			
			System.out.println();
			PW_IL_QUICK_QUOTE_BEAN.setUI_NET_PREMIUM(net_premium);
			//	PW_IL_QUICK_QUOTE_BEAN.setUI_NET_PREMIUM(netpremium);

			//now
			/*if(PW_IL_QUICK_QUOTE_BEAN.getQUOT_APPR_STS().equalsIgnoreCase("A"))
			{
				COMP_UI_M_BUT_APPROVAL.setDisabled(true);
			}
			else
			{
				COMP_UI_M_BUT_APPROVAL.setDisabled(false);
			}*/


			if (pValOrclList != null && !pValOrclList.isEmpty()) {
				if (pValOrclList.get(0).getValue() != null) {

					PW_IL_QUICK_QUOTE_BEAN.setUI_M_QUOT_FC_TOT_PREM(Double
							.parseDouble(pValOrclList.get(0).getValue()));
				}
				if (pValOrclList.get(1).getValue() != null) {
					PW_IL_QUICK_QUOTE_BEAN.setUI_M_QUOT_LC_TOT_PREM(Double
							.parseDouble(pValOrclList.get(1).getValue()));

				}
				if (pValOrclList.get(2).getValue() != null) {

					PW_IL_QUICK_QUOTE_BEAN.setUI_M_QUOT_FC_TOT_LOADING(Double
							.parseDouble(pValOrclList.get(2).getValue()));
				}
				if (pValOrclList.get(3).getValue() != null) {

					PW_IL_QUICK_QUOTE_BEAN.setUI_M_QUOT_LC_TOT_LOADING(Double
							.parseDouble(pValOrclList.get(3).getValue()));
				}
				if (pValOrclList.get(4).getValue() != null) {

					PW_IL_QUICK_QUOTE_BEAN.setUI_M_QUOT_FC_TOT_DISCOUNT(Double
							.parseDouble(pValOrclList.get(4).getValue()));
				}
				if (pValOrclList.get(5).getValue() != null) {

					PW_IL_QUICK_QUOTE_BEAN.setUI_M_QUOT_LC_TOT_DISCOUNT(Double
							.parseDouble(pValOrclList.get(5).getValue()));
				}
				if (pValOrclList.get(6).getValue() != null) {

					PW_IL_QUICK_QUOTE_BEAN.setUI_M_FC_PCHARGES_BORNE_CUST(Double
							.parseDouble(pValOrclList.get(6).getValue()));
				}
				if (pValOrclList.get(7).getValue() != null) {

					PW_IL_QUICK_QUOTE_BEAN.setUI_M_LC_PCHARGES_BORNE_CUST(Double
							.parseDouble(pValOrclList.get(7).getValue()));
				}
				if (pValOrclList.get(8).getValue() != null) {

					PW_IL_QUICK_QUOTE_BEAN.setUI_M_FC_PCHARGES_BORNE_COMP(Double
							.parseDouble(pValOrclList.get(8).getValue()));
				}
				if (pValOrclList.get(9).getValue() != null) {

					PW_IL_QUICK_QUOTE_BEAN.setUI_M_LC_PCHARGES_BORNE_COMP(Double
							.parseDouble(pValOrclList.get(9).getValue()));
				}
				if (pValOrclList.get(10).getValue() != null) {

					PW_IL_QUICK_QUOTE_BEAN.setUI_M_FC_SCHARGES_BORNE_CUST(Double
							.parseDouble(pValOrclList.get(10).getValue()));
				}
				if (pValOrclList.get(11).getValue() != null) {

					PW_IL_QUICK_QUOTE_BEAN.setUI_M_LC_SCHARGES_BORNE_CUST(Double
							.parseDouble(pValOrclList.get(11).getValue()));
				}
				if (pValOrclList.get(12).getValue() != null) {

					PW_IL_QUICK_QUOTE_BEAN.setUI_M_FC_SCHARGES_BORNE_COMP(Double
							.parseDouble(pValOrclList.get(12).getValue()));
				}
				if (pValOrclList.get(13).getValue() != null) {

					PW_IL_QUICK_QUOTE_BEAN.setUI_M_LC_SCHARGES_BORNE_COMP(Double
							.parseDouble(pValOrclList.get(13).getValue()));
				}
				if (pValOrclList.get(14).getValue() != null) {

					PW_IL_QUICK_QUOTE_BEAN.setUI_M_POL_FC_NET_PREM(Double
							.parseDouble(pValOrclList.get(14).getValue()));
				}
				if (pValOrclList.get(15).getValue() != null) {

					PW_IL_QUICK_QUOTE_BEAN.setUI_M_POL_LC_NET_PREM(Double
							.parseDouble(pValOrclList.get(15).getValue()));
				}
				if (pValOrclList.get(16).getValue() != null) {

					PW_IL_QUICK_QUOTE_BEAN.setUI_M_POL_INST_FC_PREM(Double
							.parseDouble(pValOrclList.get(16).getValue()));
				}
				if (pValOrclList.get(17).getValue() != null) {

					PW_IL_QUICK_QUOTE_BEAN.setUI_M_POL_INST_LC_PREM(Double
							.parseDouble(pValOrclList.get(17).getValue()));
				}
				if (pValOrclList.get(18).getValue() != null) {
					PW_IL_QUICK_QUOTE_BEAN.setUI_M_POL_FC_MOP(Double
							.parseDouble(pValOrclList.get(18).getValue()));
				}
				if (pValOrclList.get(19).getValue() != null) {

					PW_IL_QUICK_QUOTE_BEAN.setUI_M_POL_LC_MOP(Double
							.parseDouble(pValOrclList.get(19).getValue()));
				}
				if (pValOrclList.get(20).getValue() != null) {

					PW_IL_QUICK_QUOTE_BEAN.setUI_M_POL_FC_GR_ANN_PREM(Double
							.parseDouble(pValOrclList.get(20).getValue()));
				}
				if (pValOrclList.get(21).getValue() != null) {

					PW_IL_QUICK_QUOTE_BEAN.setUI_M_POL_LC_GR_ANN_PREM(Double
							.parseDouble(pValOrclList.get(21).getValue()));
				}
				if(PW_IL_QUICK_QUOTE_BEAN.getQUOT_SRC_BUS().equals("075")){
					if(Double.valueOf(PW_IL_QUICK_QUOTE_BEAN.getUI_NET_PREMIUM())>0.0){
						/*Addec by sankar for PREMIUM CALC mgs ISSUE ON 17-10-16 */
						if(PW_IL_QQUOT_BROK_DTL_BEAN.getQQBD_RATE()!=null && PW_IL_QQUOT_BROK_DTL_BEAN.getQQBD_RATE_PER() !=null ){
						/*end*/ 
						commision=(PW_IL_QQUOT_BROK_DTL_BEAN.getQQBD_RATE()/PW_IL_QQUOT_BROK_DTL_BEAN.getQQBD_RATE_PER())*Double.valueOf(PW_IL_QUICK_QUOTE_BEAN.getUI_NET_PREMIUM());
						System.out.println("Commission :"+commision);

						/*
						 *  Commented By Dhinesh for apply common decimal convert method on 12.10.2016
						 *  
						 * uicomm=delegate.Decimal_Convert(Double.toString(commision));*/
						
						uicomm=CommonUtils.Decimal_Convert(Double.toString(commision));
						
						System.out.println("String Commission  :"+uicomm);
						//	PW_IL_QUICK_QUOTE_BEAN.setQUOT_COMM_VALUE(commision);					
					}
					}
				}
				message = "Premium Calculated Successfully";
				this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getWarningMap().put(
						"current", message);
				COMP_UI_M_BUT_APPROVAL.setDisabled(false);

				/*COMP_UI_M_CLC_PREMIUM.setDisabled(true);*/

				/* Added by ganesh on 11-04-2017 for decline functionality */
				COMP_UI_M_MAKE_DECLINE.setDisabled(false);
				/*END*/

				
				try{
					delegate.executeQuery(compositeAction);
				}catch (Exception e) {
					e.printStackTrace();
				}
				//PW_IL_QUICK_QUOTE_BEAN.setQUOT_COMM_VALUE(commision);
				PW_IL_QUICK_QUOTE_BEAN.setUI_NET_PREMIUM(net_premium);

				
				/*Added by Ram on 20/11/2016 for Report issues*/
				compositeAction.getPRINT_ACTION_BEAN().getCOMP_QQAT_PRINT().setDisabled(false);
				/*End*/
				
			}


		} catch (Exception e) {
			
			/*Added by Ameen on 03/04/2017 as per Ajoy Sugestion*/
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());//Ameen
			/*End*/
			
			e.printStackTrace();

			this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getErrorMap().put(
					"current", e.getMessage());

		}finally{
			try {
				CommonUtils.getConnection().commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

	public void Aprovequot() throws SQLException, Exception{
		System.out.println("aprove premium");

		ArrayList<String> pValOrclList = new ArrayList<String>();
		ResultSet agentStatusRS=null;
		ResultSet cust_statusRS=null;
		try {

			
						
			//Added by Ameen for Agent termination scenario on 30-08-2016
			System.out.println("QUOT_SYS_ID    : "+String.valueOf(PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID()));
			String BROKER_CODE_Query="SELECT QUOT_SRC_CODE FROM  PW_IL_QUICK_QUOTE WHERE QUOT_SYS_ID=?";
			agentStatusRS=new CRUDHandler().executeSelectStatement(BROKER_CODE_Query, CommonUtils.getConnection(),new Object[]{
				String.valueOf(PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID())});
			String QUOT_SRC_CODE=null;
			while(agentStatusRS.next()){
				QUOT_SRC_CODE=agentStatusRS.getString("QUOT_SRC_CODE");
			}
			System.out.println("QUOT_SRC_CODE     :   "+QUOT_SRC_CODE);

			String CUST_STATUS_Query="SELECT CUST_STATUS FROM PM_CUSTOMER WHERE CUST_CODE=?";
			cust_statusRS=new CRUDHandler().executeSelectStatement(CUST_STATUS_Query, CommonUtils.getConnection(),new Object[]{
				QUOT_SRC_CODE});
			String CUST_STATUS=null;
			while(cust_statusRS.next()){
				CUST_STATUS=cust_statusRS.getString("CUST_STATUS");
			}
			System.out.println("CUST_STATUS     :   "+CUST_STATUS);

			if(QUOT_SRC_CODE!=null)
			{
				if((CUST_STATUS!=null)&& CUST_STATUS.equalsIgnoreCase("T"))
				{
					throw new Exception("Agent has been terminated, kindly check and proceed");
				}
			}

			///end agent termination scenario

			pValOrclList = PKG_PILT002_APAC_QE.PROP_APPROVAL(String.valueOf(PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID()));
			getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(false);
			COMP_UI_M_MAKE_AMMENMENT.setDisabled(false);
			COMP_UI_M_CONV_POL.setDisabled(false);
			String message = "Your Quotation is Approved Sucessfully";
			disableallcomponent(true);
			
			/*added by Ameen on 31-03-2017 for validation ic.id no. in convert btn issue*/
			COMP_QUOT_NEW_IC.setDisabled(false);
			/*end validation ic.id no. in convert btn issue*/

			
			getCOMP_UI_M_APPRV_STATUS().setValue("Approved");
			PW_IL_QUICK_QUOTE_BEAN.setUI_M_APPRV_STATUS("Approved");
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_APPR_STS("A");
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_UI_M_CLC_PREMIUM().setDisabled(true);
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_UI_M_BUT_APPROVAL().setDisabled(true);
			
			
			/* Added by ganesh on 11-04-2017 for decline functionality */
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_UI_M_MAKE_DECLINE().setDisabled(true);
			/*END*/

			
			COMP_UI_SAVE_DOWN.setDisabled(true);
			COMP_UI_SAVE_UP.setDisabled(true);

			this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getWarningMap().put(
					"current", message);
			/*Added by Ram on 20/11/2016 for Report issues*/
			compositeAction.getPRINT_ACTION_BEAN().getCOMP_QQAT_PRINT().setDisabled(false);	
			/*End*/
		} catch (Exception e) {
			e.printStackTrace();
			getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(false);


			String error = ErrorHelpUtil
					.getUserErrorMessageFromDBErrorMessage(e.getMessage());
			/*getErrorMap()
					.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, error);
			getErrorMap().put("SAVE", error);*/


			this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getErrorMap().put(
					"current", error);

		}

	}

	public void convertquot() throws Exception{



		System.out.println("convert premium");

		try {
			//if(PW_IL_QUICK_QUOTE_BEAN.getQUOT_IDX_NO()==helper.checkmaxammenment(PW_IL_QUICK_QUOTE_BEAN.getQUOT_NO())){
			/*Commented by Ram on 29/08/2016 for Duplicate Entry issue
			 * 
			 * try {*/

			//Added By Dhinesh for 29.8.2016 Start 
			//Added By Dhinesh for convert the quotation after the quotation end date, there is no validation during conversation.
			Date date1=PW_IL_QUICK_QUOTE_BEAN.getQUOT_VALID_DT();
			System.out.println("date1     : "+date1);
			Date date2 = new Date();
			System.out.println("datee2    : "+date2);

			boolean dateGreaterthenOrEqualTo = CommonUtils.dateGreaterthenOrEqualTo(date1,date2);
			System.out.println("dateGreaterthenOrEqualTo     : "+dateGreaterthenOrEqualTo);
			if(!dateGreaterthenOrEqualTo)
			{
				throw new Exception("Unable to convert, Quotation already Expired ");
			}
			//Added By Dhinesh for 29.8.2016 End


			createnewcustomer();

			/*} catch (Exception e1) {
				// TODO Auto-generated catch block
				getCOMP_REPORT_MODAL_PANEL_CONVERT().setShowWhenRendered(false);
				e1.printStackTrace();
			}*/
			String message = null;
			String P_POLICY_NO="";
			ArrayList<OracleParameter> pValOrclList = new ArrayList<OracleParameter>();

			pValOrclList = PKG_PILT002_APAC_QE.P_PROP_CONVERT(String.valueOf(PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID()),
					new CommonUtils().dateToStringFormat(PW_IL_QUICK_QUOTE_BEAN.getQUOT_ISS_DT()),P_POLICY_NO,PW_IL_QUICK_QUOTE_BEAN.getQUOT_NO());


			if (pValOrclList != null && !pValOrclList.isEmpty()) {
				if (pValOrclList.get(0).getValue() != null) {
					getCOMP_REPORT_MODAL_PANEL_CONVERT().setShowWhenRendered(false);
					COMP_UI_M_CONV_POL.setDisabled(true);
					message = "Your Quotation is converted in to Proposal and your Proposal no is :";
					this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getWarningMap().put(
							"current", message +pValOrclList.get(0).getValue());
					COMP_UI_M_BUT_APPROVAL.setDisabled(true);
					COMP_UI_M_CONV_POL.setDisabled(true);
					COMP_UI_M_MAKE_AMMENMENT.setDisabled(true);
					COMP_UI_M_CLC_PREMIUM.setDisabled(true);
					COMP_UI_SAVE_DOWN.setDisabled(true);
					COMP_UI_SAVE_UP.setDisabled(true);
					/* Added by ganesh on 11-04-2017 for decline functionality */
					COMP_UI_M_MAKE_DECLINE.setDisabled(true);
					/*END*/
				}
				else
				{
					getCOMP_REPORT_MODAL_PANEL_CONVERT().setShowWhenRendered(false);
					message = "Your Quotation is cannot able to convert  ";
					this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getErrorMap().put(
							"current", message);
					getCOMP_UI_M_APPRV_STATUS().setValue("You cannot do any change because quotation was already converted to proposal");
					PW_IL_QUICK_QUOTE_BEAN.setUI_M_APPRV_STATUS("You cannot do any change because quotation was already converted to proposal");
				}
			}
			/*}else{

				getCOMP_REPORT_MODAL_PANEL_CONVERT().setShowWhenRendered(false);
				getErrorMap().put("current","Ammendment is already their for this Quotation so you cannot  able to Convert  this Quotation ");

			}*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			getCOMP_REPORT_MODAL_PANEL_CONVERT().setShowWhenRendered(false);
			e.printStackTrace();


			String error = ErrorHelpUtil
					.getUserErrorMessageFromDBErrorMessage(e.getMessage());
			/*getErrorMap()
					.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, error);
			getErrorMap().put("SAVE", error);*/


			this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getErrorMap().put(
					"current", error);

			/*this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getErrorMap().put(
					"current", e.getMessage());*/
		}

	}
	public ArrayList<LovBean> icsuggestionList = null;
	public ArrayList<LovBean> lovPOL_ASSRD_REF_ID1(Object currValue) {
		String code = (String) currValue;

		Object[] object = {};
		String query = null;
		try {
			if ("*".equals(code)) {
				object = new Object[] { PELConstants.suggetionRecordSize };
				query = "SELECT CUST_REF_ID1,CUST_CODE,CUST_NAME FROM PM_CUSTOMER " +
						"WHERE ROWNUM <= ? AND CUST_REF_ID1 IS NOT NULL ORDER BY 1";
			} else {
				object = new Object[] { code + "%", code + "%",
						PELConstants.suggetionRecordSize };
				/*commented and added by ameen for FALCONLIFE-1344105 on 21-10-2016
				 * 
				 * query = "SELECT CUST_REF_ID1,CUST_CODE,CUST_NAME FROM PM_CUSTOMER " +
						"WHERE (CUST_REF_ID1 LIKE ? OR CUST_NAME LIKE ?) AND CUST_REF_ID1 IS NOT NULL AND ROWNUM <= ? ORDER BY 1";*/
				query = "SELECT CUST_REF_ID1,CUST_CODE,CUST_NAME FROM PM_CUSTOMER " +
						"WHERE (CUST_REF_ID1 LIKE ? OR UPPER(CUST_NAME) LIKE UPPER(?)) AND CUST_REF_ID1 IS NOT NULL AND ROWNUM <= ? ORDER BY 1";
			}
			icsuggestionList = ListItemUtil.prepareSuggestionList(query, object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return icsuggestionList;
	}


	/*public ArrayList<LovBean> lovQQAT_CUST_NAME(Object currValue) {
		String code = (String) currValue;
		ArrayList<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		try {
			if ("*".equals(code)) {
				object = new Object[] { PELConstants.suggetionRecordSize };
				query = PT_IL_POLICY_QUERY_CONSTANTS.POL_ASSRD_REF_ID1_QUERY;
			} else {
				object = new Object[] { code + "%", code + "%",
						PELConstants.suggetionRecordSize };
				query = PT_IL_POLICY_QUERY_CONSTANTS.POL_ASSRD_REF_ID1_QUERY_LIKE;
			}
			suggestionList = ListItemUtil.prepareSuggestionList(query, object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	 */


	public ArrayList<LovBean> lovQQAT_CUST_LAST_NAME(Object currValue) {
		ListItemUtil itemUtil = new ListItemUtil();
		ArrayList<LovBean> suggestionList = null;
		/*
		 *commented by ameen for FALCONLIFE-1344105 on 07-10-2016 
		 * 
		 * 
		 * String Query = "SELECT CUST_SURNAME,CUST_LONG_NAME FROM PM_CUSTOMER "
				+ " WHERE    CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS, "
				+ "PP_SYSTEM  WHERE  PS_CODE = 'BROKER' AND PS_TYPE ='LOV_CUST')   "
				+ "AND CUST_FRZ_FLAG = 'N'   AND (CUST_CODE LIKE ? OR CUST_SURNAME LIKE ?  "
				+ "  )   AND  ROWNUM < 25 order by 1";*/
		
		/*Added by ameen for FALCONLIFE-1344105 on 07-10-2016*/
		String Query = "SELECT CUST_SURNAME,CUST_LONG_NAME FROM PM_CUSTOMER "
				+ " WHERE    CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS, "
				+ "PP_SYSTEM  WHERE  PS_CODE = 'BROKER' AND PS_TYPE ='LOV_CUST')   "
				+ "AND CUST_FRZ_FLAG = 'N'   AND (UPPER(CUST_CODE) LIKE UPPER(?) OR CUST_SURNAME LIKE UPPER(?)  "
				+ "  )   AND  ROWNUM < 25 order by 1";
		String currentValue = (String) currValue;

		currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
		try {
			suggestionList = itemUtil.prepareSuggestionList(Query,
					new Object[] { currentValue, currentValue });
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SRC_BUS_SUGGESTIONS", e.getMessage());
		}
		return suggestionList;
	}



	public void validateQQAT_CUST_LAST_NAME(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_CUST_SURNAME((String) value);

			System.out.println("QUOT_CUST_SURNAME .... "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_SURNAME());

			/*helper.POL_ASSRD_REF_ID1_WHEN_VALIDATE_ITEM(compositeAction,
						(String) value);
			COMP_POL_ASSRD_REF_ID1.resetValue();
				COMP_POL_CUST_CODE.resetValue();
				COMP_POL_CONT_CODE.resetValue();
				COMP_POL_ASSURED_NAME.resetValue();
				COMP_POL_RES_ADDRESS_1.resetValue();
				COMP_POL_RES_ADDRESS_2.resetValue();
				COMP_POL_RES_ADDRESS_3.resetValue();
				COMP_POL_RES_PHONE_NO.resetValue();
				COMP_POL_FAX_NO.resetValue();
				COMP_POL_RES_AREA_CODE.resetValue();
				COMP_POL_FAX_AREA_CODE.resetValue();
				COMP_POL_STATE_CODE.resetValue();
				COMP_POL_COUNT_CODE.resetValue();
				COMP_POL_MOBILE_NO.resetValue();
				COMP_UI_M_POL_CITY_NAME.resetValue();
				COMP_UI_M_POL_STATE_NAME.resetValue();
				COMP_UI_M_POL_COUNT_NAME.resetValue();
				COMP_POL_SRC_OF_BUS.resetValue();
				COMP_POL_ASSRD_REF_ID2.resetValue();*/

			/*Added by Ram on 30/12/2016 for Existing customer validation*/
			/*Reverted by Ram on 23/01/2017 for Existing customer validation handle in Save button click*/
			/*getWarningMap().clear();
			helper.checkExistingUser(compositeAction,compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_BEAN(),null,compositeAction.
					getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN());
			if(PW_IL_QUICK_QUOTE_BEAN.getEXISTING_COUNT() > 0)
			{
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						"Same customer is already exists in our system. Quotation No is "+PW_IL_QUICK_QUOTE_BEAN.getEXIST_QUOT_NO());
				getWarningMap().put("postRecord", "Same customer is already exists in our system. Quotation No is "+PW_IL_QUICK_QUOTE_BEAN.getEXIST_QUOT_NO());
			}*/
			/*End*/
			/*End*/
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "POL_ASSRD_REF_ID1", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<LovBean> lovCBAD_BANK_CODE(Object obj) {
		String bchcode = (String) obj;
		List<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		if ("*".equals(bchcode)) {
			object = new Object[] { PELConstants.suggetionRecordSize };
			query = PM006_A_APAC_QUERY_CONSTANTS.CBAD_BANK_CODE_LOV;
		} else {
			object = new Object[] { bchcode + "%", bchcode + "%",
					PELConstants.suggetionRecordSize };
			query = PM006_A_APAC_QUERY_CONSTANTS.CBAD_BANK_CODE_LOV_LIKE;
		}
		suggestionList = delegate.prepareLovList(query, object);
		return suggestionList;
	}






	public void ExpandAllButtonAction()
	{
		System.out.println("Enter the ExpandAllButtonAction");
		//added by saranya for ssp call id FALCONQC-1714511
		headertoggle.setOpened(false);
		customertoggle.setOpened(false);
		/*end*/
		chargetoggle.setOpened(true);
		debitoggle.setOpened(true);
		covertoggle.setOpened(true);

		//COMP_UI_M_BUT_EXPAND.setRendered(false);
		//	COMP_UI_M_BUT_SHRINK.setRendered(true);
		COMP_UI_M_BUT_EXPAND_LINK.setRendered(false);
		COMP_UI_M_BUT_SHRINK_LINK.setRendered(true);

	}

	public void SHRINKAllButtonAction()
	{
		System.out.println("Enter the ExpandAllButtonAction");

		chargetoggle.setOpened(false);
		debitoggle.setOpened(false);
		covertoggle.setOpened(false);
		//COMP_UI_M_BUT_SHRINK.setRendered(false);
		//COMP_UI_M_BUT_EXPAND.setRendered(true);
		COMP_UI_M_BUT_SHRINK_LINK.setRendered(false);
		COMP_UI_M_BUT_EXPAND_LINK.setRendered(true);
		//added by saranya for ssp call id FALCONQC-1714511
		customertoggle.setOpened(true);
		headertoggle.setOpened(true);
		//end
	}

	public void QQAT_COVER_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			Double M_POAC_FC_SA,M_POAC_LC_SA;
			String M_POAC_RATE_APPLIED_ON="";

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String currentValue = (String) value;
			ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();


			helper.QQAT_COVER_CODE_WHEN_VALIDATE_ITEM(currentValue);

			/*   PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_EFF_FM_DT(new CommonUtils().getCurrentDate());   *///Commented by Dhinesh 5-8-2016
			PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_EFF_FM_DT(PW_IL_QUICK_QUOTE_BEAN.getQUOT_ISS_DT());

			String FM = simpleDateFormat.format(PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_EFF_FM_DT());
			COMP_ADD_QQAC_TERM.resetValue();
			PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_PERIOD(PW_IL_QUICK_QUOTE_BEAN.getQUOT_PERIOD());
			
			/*Added by Ram on 08/11/2016 for FALCONLIFE-1349309*/
			PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_PERIOD_COPY(PW_IL_QUICK_QUOTE_BEAN.getQUOT_PERIOD());
/*End*/
			
			System.out.println("PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_PERIOD()    : "+PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_PERIOD());
			//Added by Raja for Rider issue on 26-10-2016
			PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_EMR_RATE(PW_IL_QUICK_QUOTE_BEAN.getQUOT_EMR_RATE());
			COMP_ADD_QQAC_EMR_RATE.resetValue();
			//End




			if((currentValue)!=null){

				PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_COVER_CODE((String) value);
				helper.ADD_QQAT_PROD_CODE_WHEN_VALIDATE_ITEM(compositeAction,currentValue);
				System.out.println("PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_PERIOD()   :  "+PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_PERIOD());
				String mand="SELECT PAC_MANDATORY_YN FROM PM_IL_PROD_APPL_COVER WHERE PAC_PROD_CODE = ? AND PAC_COVER_CODE = ? ";

				Object[] mandvalues = { PW_IL_QUICK_QUOTE_BEAN.getQUOT_PROD_CODE(),PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_COVER_CODE() };

				ResultSet rs2= new CRUDHandler().executeSelectStatement(mand, CommonUtils.getConnection(), mandvalues);

				while (rs2.next()) {
					PW_IL_QQUOT_APPL_COVER_BEAN.setUI_M_QQAT_MAND_YN(rs2.getString("PAC_MANDATORY_YN"));
				}

				list= PKG_PILT002_APAC_QE.P_CALC_COVER_SA(String.valueOf(PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID()),PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_COVER_CODE(),String.valueOf(PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_SYS_ID()),"0","0","0","N");
				System.out.println("list      "+list);
				COMP_ADD_QQAC_SUM_ASS.resetValue();
				if (list != null && !list.isEmpty()) {
					if (list.get(0).getValueObject() != null) {
						M_POAC_RATE_APPLIED_ON =(String)list.get(0).getValueObject();
						PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_RATE_APPLIED_ON(M_POAC_RATE_APPLIED_ON);
					}if (list.get(1).getValueObject() != null) {
						/*M_POAC_FC_SA  =(Double)list.get(1).getValueObject();*/
						M_POAC_FC_SA  =Double.valueOf((String)list.get(1).getValueObject());
						PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_FC_SA(M_POAC_FC_SA);
						PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_LC_SA(M_POAC_FC_SA);
						//PW_IL_QQUOT_APPL_COVER_BEAN.setUI_QQAC_PREM_LC(helper.Decimal_Convert((String)list.get(1).getValueObject()));

					}if (list.get(2).getValueObject() != null) {
						/*M_POAC_LC_SA =(Double)list.get(2).getValueObject();*/
						M_POAC_LC_SA = Double.valueOf((String) list.get(2).getValueObject());

						//PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_LC_SA(M_POAC_LC_SA);
						if(isEFlag()){
							if(PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_FC_SA()==null){
								coversumass=M_POAC_LC_SA;
								PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_FC_SA(M_POAC_LC_SA);
							}
						}
						PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_LC_SA(M_POAC_LC_SA);

					}
				}



				//helper.POL_PROD_CODE_WHEN_VALIDATE_ITEM(compositeAction,(String) value);
				/*
				 * 
				 * Commented By Dhinesh   
				 * 
				 * 
				 * int period=PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_PERIOD();
				PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_PERIOD(period);
				int period1= period*12;
				PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_EFF_TO_DT(new CommonUtils().addMonthsToDate(PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_EFF_FM_DT(),period1));

				 */
				//Added By Dhinesh 5.8.2016

				PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_EFF_TO_DT(PW_IL_QUICK_QUOTE_BEAN.getQUOT_TO_DT());

				System.out.println("QQAC_EFF_FROM_DT     : "+PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_EFF_FM_DT());
				System.out.println("QQAC_EFF_TO_DT       : "+PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_EFF_TO_DT());
				//End


				String TO = simpleDateFormat.format(PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_EFF_TO_DT());

				PW_IL_QQUOT_APPL_COVER_BEAN.setUI_EFF_FM_DT(FM);

				PW_IL_QQUOT_APPL_COVER_BEAN.setUI_EFF_TO_DT(TO);
				System.out.println("PROD CODE  "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_PROD_CODE());


				System.out.println("PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_FC_SA()   : "+PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_FC_SA());
				/*helper.POAC_COVER_CODE_WHEN_VALIDATE_ITEM(compositeAction,this);
			COMP_UI_M_POAC_COVER_DESC.resetValue();
			COMP_POAC_RATE.resetValue(); 	
			COMP_POAC_FC_SA.resetValue();
			COMP_POAC_LC_SA.resetValue();
			//TESTING BY HANEEF
			//COMP_POAC_PERIOD.resetValue();
			COMP_POAC_TARIFF_TERM_FLAG.resetValue();
			COMP_POAC_PREM_PAY_YRS.resetValue();*/
			}
			/*helper.setDefaultWopYN(currentValue,getPT_IL_POL_ADDL_COVER_BEAN());
			COMP_POAC_WOP_FLAG.resetValue();
			 */
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "QQAT_COVER_CODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}



	public void QQAC_ADD_TERM_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			int currentValue=(Integer) value;
			System.out.println("period   currentValue"+    currentValue);

			/*Added by Ram on 05/11/2016 for term validation in Post entry level*/
			PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_PERIOD_COPY(currentValue);
			/*End*/
			
			if(currentValue<=PW_IL_QUICK_QUOTE_BEAN.getQUOT_PERIOD()){
				//String beanValue = PT_IL_POL_ADDL_COVER_BEAN.getPOAC_COVER_CODE();
				if(currentValue>0){
					PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_PERIOD(currentValue);
					PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_PREM_PAY_YRS(currentValue);
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
					//PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_EFF_FM_DT(new CommonUtils().getCurrentDate());

					//String TO = simpleDateFormat.format(PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_EFF_TO_DT());

					/*
					 * 
					 * Commented By Dhinesh   
					 * 
					 * 
					 * int period=PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_PERIOD();
					PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_PERIOD(period);
					int period1= period*12;
					PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_EFF_TO_DT(new CommonUtils().addMonthsToDate(PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_EFF_FM_DT(),period1));

					 */
					//Added By Dhinesh 5.8.2016

					PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_EFF_FM_DT(PW_IL_QUICK_QUOTE_BEAN.getQUOT_ISS_DT());
					String FM = simpleDateFormat.format(PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_EFF_FM_DT());

					PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_EFF_TO_DT(PW_IL_QUICK_QUOTE_BEAN.getQUOT_TO_DT());

					System.out.println("QQAC_EFF_FROM_DT     : "+PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_EFF_FM_DT());
					System.out.println("QQAC_EFF_TO_DT       : "+PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_EFF_TO_DT());



					String TO = simpleDateFormat.format(PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_EFF_TO_DT());

					PW_IL_QQUOT_APPL_COVER_BEAN.setUI_EFF_FM_DT(FM);

					PW_IL_QQUOT_APPL_COVER_BEAN.setUI_EFF_TO_DT(TO);
					System.out.println("PROD CODE  "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_PROD_CODE());
					//End


				}else{
					throw new Exception("Term should greater then zero");
				}

			}else{
				throw new Exception("Cover Term should be Lesser then or Equal to Quotation Term ");
			}
			/*helper.setDefaultWopYN(currentValue,getPT_IL_POL_ADDL_COVER_BEAN());
			COMP_POAC_WOP_FLAG.resetValue();
			 */
		} catch (Exception e) {
			//e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}

	/*Added By jagadeesh For the Field EMR Rate*/


	public void QQAC_ADD_EMR_RATE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			Double currentValue=(Double) value;
			PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_EMR_RATE(currentValue);
			PW_IL_QQUOT_APPL_COVER_BEAN.setUI_QQAC_EMR_RATE(CommonUtils.Decimal_Convert( Double.toString(PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_EMR_RATE())));
		} catch (Exception e) {
			//e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}

	/*END*/	

	public void QQAC_ADD_RATE_PER_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			int currentValue = (Integer) value;
			//String beanValue = PT_IL_POL_ADDL_COVER_BEAN.getPOAC_COVER_CODE();
			if(currentValue>0){
				PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_RATE_PER(currentValue);
			}
			/*helper.setDefaultWopYN(currentValue,getPT_IL_POL_ADDL_COVER_BEAN());
			COMP_POAC_WOP_FLAG.resetValue();
			 */
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void QQAC_PREMIUM_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){
		try {
			Double currentValue = (Double) value;
			//String beanValue = PT_IL_POL_ADDL_COVER_BEAN.getPOAC_COVER_CODE();
			if(((currentValue)!=null)&&currentValue>0){
				PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_PREM_FC(currentValue);
			}
			/*helper.setDefaultWopYN(currentValue,getPT_IL_POL_ADDL_COVER_BEAN());
			COMP_POAC_WOP_FLAG.resetValue();
			 */
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}


	public void QQAC_SUM_ASS_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){
		try {
			Double currentValue = (Double) value;
			PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_FC_SA(currentValue);
			Double M_POAC_LC_SA;
			//String beanValue = PT_IL_POL_ADDL_COVER_BEAN.getPOAC_COVER_CODE();
			if(((currentValue)!=null)&&currentValue>0){
				setEFlag(false);
				if(currentValue<=PW_IL_QUICK_QUOTE_BEAN.getQUOT_FC_SA()){
					coversumass=currentValue;
					ArrayList<OracleParameter> list= PKG_PILT002_APAC_QE.P_CALC_COVER_SA(String.valueOf(PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID()),PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_COVER_CODE(),String.valueOf(PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_SYS_ID()),"0","0","0","N");
					System.out.println("list      "+list);
					if (list.get(2).getValueObject() != null) {						
						M_POAC_LC_SA = Double.valueOf((String) list.get(2).getValueObject());
						if(M_POAC_LC_SA!=currentValue){

							PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_FC_SA(currentValue);
						}
						else{
							PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_FC_SA(currentValue);
						}
					}
				}else{
					throw new Exception("Cover Sum Assured should be Lesser then or Equal to Quotation Sum Assured ");
				}

			}
			/*helper.setDefaultWopYN(currentValue,getPT_IL_POL_ADDL_COVER_BEAN());
			COMP_POAC_WOP_FLAG.resetValue();
			 */
		} catch (Exception e) {
			//e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}



	public void QQAC_ADD_RATE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {
			Double currentValue = (Double) value;
			//String beanValue = PT_IL_POL_ADDL_COVER_BEAN.getPOAC_COVER_CODE();
			if(((currentValue)!=null)&&currentValue>0){
				PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_RATE(currentValue);
			}
			/*helper.setDefaultWopYN(currentValue,getPT_IL_POL_ADDL_COVER_BEAN());
			COMP_POAC_WOP_FLAG.resetValue();
			 */
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}



	public ArrayList<LovBean> prepareSuggestionList_COVER_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_ADDL_COVER";
		String fieldName = "POAC_COVER_CODE";
		Object param1 = PW_IL_QUICK_QUOTE_BEAN.getQUOT_PROD_CODE();
		Object param2 = "R";
		setEFlag(true);

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList =itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1,
					param2, null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	/*	public void QQAT_DISC_LOAD_TYPE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)throws ValidatorException {
		try {
			PW_IL_QQUOT_DISC_LOAD_BEAN.setQQDL_DISC_LOAD_TYPE((String) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}
	 */
	public void QQAT_DISC_LOAD_TYPE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)throws ValidatorException {
		try {
			String currval=(String) value;
			String oldval=PW_IL_QQUOT_DISC_LOAD_BEAN.getQQDL_DISC_LOAD_TYPE(); 
			if(!currval.equalsIgnoreCase(oldval)){
				PW_IL_QQUOT_DISC_LOAD_BEAN.setQQDL_DISC_LOAD_TYPE((String) value);
				if(isDISC_LOADING_FLAG()){

					COMP_QQAT_DISC_LOAD_CODE.resetValue();
					COMP_UI_M_DISCLOAD_DESC.resetValue();
					COMP_QQAT_DISC_LOAD_CODE.setRequired(true);
					PW_IL_QQUOT_DISC_LOAD_BEAN.setQQDL_DISC_LOAD_CODE(null);
					PW_IL_QQUOT_DISC_LOAD_BEAN.setUI_M_DISCLOAD_DESC(null);
				}
			}

		} catch (Exception e) {


			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}

	}


	public ArrayList<LovBean> prepareSuggestionList_PDL_DISC_LOAD_CODE0(
			Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_DISC_LOAD";
		String fieldName = "PDL_DISC_LOAD_CODE";
		Object param1 = "IL_DISC";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
					null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public ArrayList<LovBean> prepareSuggestionList_PDL_DISC_LOAD_CODE1(
			Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_DISC_LOAD";
		String fieldName = "PDL_DISC_LOAD_CODE";
		Object param1 = "IL_LOAD";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
					null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public ArrayList<LovBean> main_prepareSuggestionList_QQAT_DISC_LOAD_CODE(

			Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		try {

			System.out.println("adaboina discounttttttttttttttttt");
			System.out.println(PW_IL_QQUOT_DISC_LOAD_BEAN.getQQDL_DISC_LOAD_TYPE()
					);
			System.out.println("adaboina 2222222222222222222");

			if ("D".equals(PW_IL_QQUOT_DISC_LOAD_BEAN.getQQDL_DISC_LOAD_TYPE())) {
				lovList = prepareSuggestionList_PDL_DISC_LOAD_CODE0(object);
			} else {
				lovList = prepareSuggestionList_PDL_DISC_LOAD_CODE1(object);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}


	public void validateQQAC_CHRG_CODE(FacesContext context,
			UIComponent component, Object value)  {

		try {
			String charge_code=(String) value;
			PW_IL_QQUOT_APPL_CHARGE_BEAN.setQQAC_CHRG_CODE(charge_code);
			System.out.println("valid :: charge_code******"+PW_IL_QQUOT_APPL_CHARGE_BEAN.getQQAC_CHRG_CODE());
			helper.POC_CHRG_CODE_WHEN_VALIDATE_ITEM(PW_IL_QQUOT_APPL_CHARGE_BEAN,PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID());


		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	//CHARGE SUGG. LOV.

	public List<LovBean> prepareSuggestionList_CHRG_CODE(Object event) {
		String code = (String) event;
		List<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		String POC_TYPE = "C";
		System.out.println(POC_TYPE);


		if("C".equalsIgnoreCase(POC_TYPE)){

			if ("*".equals(code)) {

				object = new Object[] { PELConstants.suggetionRecordSize };

				query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE LIKE 'IL_CHARGE' AND NOT EXISTS(SELECT TH_TAX_TYPE FROM PM_LIFE_TAX_HEADER WHERE TH_TAX_TYPE = PC_CODE)AND " +
						" ROWNUM < ? ORDER BY 1";
			} else {
				object = new Object[] { code + "%",
						PELConstants.suggetionRecordSize };
				/*
				 * 
				 * commented by ameen for FALCONLIFE-1344105 on 07-10-2016
				 * 
				 * query =  "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE LIKE 'IL_CHARGE' AND NOT EXISTS(SELECT TH_TAX_TYPE FROM PM_LIFE_TAX_HEADER WHERE TH_TAX_TYPE = PC_CODE) AND"  +
						"(PC_CODE LIKE ? ) " +
						"AND ROWNUM < ? ORDER BY 1";*/
				/*Added by ameen for FALCONLIFE-1344105 on 07-10-2016*/
				query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE UPPER(PC_TYPE) LIKE UPPER('IL_CHARGE') AND NOT EXISTS(SELECT TH_TAX_TYPE FROM PM_LIFE_TAX_HEADER WHERE TH_TAX_TYPE = PC_CODE) AND"  +
						"(UPPER(PC_CODE) LIKE UPPER(?) ) " +
						"AND ROWNUM < ? ORDER BY 1";
				/*end*/
			}
		}else{
			if ("*".equals(code)) {

				object = new Object[] { PELConstants.suggetionRecordSize };

				query = "SELECT TH_TAX_TYPE,TH_TAX_DESC FROM PM_LIFE_TAX_HEADER  WHERE  TH_TAX_TYPE IN (SELECT PC_CODE  FROM PM_CODES WHERE PC_TYPE='IL_CHARGE') AND" +
						" ROWNUM < ? ORDER BY 1";
			} else {
				object = new Object[] { code + "%",
						PELConstants.suggetionRecordSize };
				/*
				 * 
				 * commented by ameen for FALCONLIFE-1344105 on 07-10-2016
				 * 
				 * query ="SELECT TH_TAX_TYPE,TH_TAX_DESC FROM PM_LIFE_TAX_HEADER WHERE TH_TAX_TYPE IN (SELECT PC_CODE  FROM PM_CODES WHERE PC_TYPE='IL_CHARGE') AND" +
						"(TH_TAX_TYPE LIKE ? ) " +
						"AND ROWNUM < ? ORDER BY 1";*/
				/*Added by ameen for FALCONLIFE-1344105 on 07-10-2016*/
				query ="SELECT TH_TAX_TYPE,TH_TAX_DESC FROM PM_LIFE_TAX_HEADER WHERE TH_TAX_TYPE IN (SELECT PC_CODE  FROM PM_CODES WHERE PC_TYPE='IL_CHARGE') AND" +
						"(UPPER(TH_TAX_TYPE) LIKE UPPER(?) ) " +
						"AND ROWNUM < ? ORDER BY 1";
				/*end*/
			}

		}
		try {
			suggestionList = prepareLovList(query, object);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Dept Code Suggestion", e.getMessage());
		}
		return suggestionList;
	}

	public List<LovBean> prepareLovList(String query, Object[] obj) {
		List<LovBean> suggestionList = new ArrayList<LovBean>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {

			resultSet = handler.executeSelectStatement(query, CommonUtils.getConnection(), obj);
			while (resultSet.next()) {
				LovBean bean = new LovBean();
				bean.setLovCode(resultSet.getString(1));
				bean.setLovName(resultSet.getString(2));
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

	public void QQDL_DISC_LOAD_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			String curr=(String) value;
			String M_TYPE ;

			DBProcedures procedures=new DBProcedures();
			//String prev=getPT_IL_POL_DISC_LOAD_BEAN().getPDL_DISC_LOAD_CODE();
			if ("D".equals(PW_IL_QQUOT_DISC_LOAD_BEAN.getQQDL_DISC_LOAD_TYPE())) {
				M_TYPE = "IL_DISC";
			} else {
				M_TYPE = "IL_LOAD";
			}
			procedures.P_VAL_CODES(M_TYPE, curr, "", "N", "E", null);

			PW_IL_QQUOT_DISC_LOAD_BEAN.setQQDL_DISC_LOAD_CODE(curr);
			//added by saranya
			/*	if(curr.equalsIgnoreCase("EMR LOAD")){
				COMP_PDL_EMR_RATE.setDisabled(true);
			}
			else{
				COMP_PDL_EMR_RATE.setDisabled(false);
			}*/
			//end
			/*	if(!curr.equalsIgnoreCase(prev)){
			helper.PDL_DISC_LOAD_CODE_WHEN_VALIDATE_ITEM(
					getPT_IL_POL_DISC_LOAD_BEAN(), compositeAction
					.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN(), compositeAction
					.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_BEAN());

			COMP_UI_M_DISCLOAD_DESC.resetValue();
			COMP_PDL_APPL_PERC.resetValue();
			COMP_PDL_RATE.resetValue();
			COMP_PDL_RATE_PER.resetValue();
			COMP_PDL_APPLIED_ON.resetValue(); 
			COMP_PDL_APPLY_UPTO_SRNO.resetValue();
			}
			 */
		} catch (Exception e) {
			String error = ErrorHelpUtil
					.getUserErrorMessageFromDBErrorMessage(e.getMessage());
			throw new ValidatorException(new FacesMessage(error));
		}
	}


	public void QQDL_APPLIED_ON_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			String curr=(String) value;

			//String prev=getPT_IL_POL_DISC_LOAD_BEAN().getPDL_APPLIED_ON();
			PW_IL_QQUOT_DISC_LOAD_BEAN.setQQDL_APPLIED_ON((String) value);

			PW_IL_QQUOT_DISC_LOAD_BEAN.setUI_M_APPLIED_ON_DESC(helper.getdisappondesc((String) value));

			if ("3".equals(PW_IL_QQUOT_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())
					|| "6".equals(PW_IL_QQUOT_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())
					|| "7".equals(PW_IL_QQUOT_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())
					|| "8".equals(PW_IL_QQUOT_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())
					|| "9".equals(PW_IL_QQUOT_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())
					|| "10".equals(PW_IL_QQUOT_DISC_LOAD_BEAN.getQQDL_APPLIED_ON())) {
				COMP_QQDL_COVER_CODE.setDisabled(false);
				COMP_QQDL_COVER_CODE.setRequired(true);
				/*if (loadBean.getPDL_COVER_CODE() == null) {
					PDL_COVER_CODE(policyBean.getPOL_PLAN_CODE());
				}*/
			} else {
				COMP_QQDL_COVER_CODE.setDisabled(true);
			}


		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	public void QQDL_RATE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		Double currentval=(Double)value;

		try {
			if (currentval < 0) {
				throw new ValidatorException(new FacesMessage(Messages
						.getString(PELConstants.pelErrorMessagePath, "71043")));
			}
			else
			{
				PW_IL_QQUOT_DISC_LOAD_BEAN.setQQDL_RATE(currentval);
				PW_IL_QQUOT_DISC_LOAD_BEAN.setUI_QQDL_RATE(CommonUtils.Decimal_Convert( Double.toString(PW_IL_QQUOT_DISC_LOAD_BEAN.getQQDL_RATE())));
			}

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void QQDL_RATE_PER_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {


		int currentval=(Integer)value;
		Double rate =PW_IL_QQUOT_DISC_LOAD_BEAN.getQQDL_RATE();

		try {
			if (rate == 0) {
				if(currentval!=0)
					throw new ValidatorException(new FacesMessage("Value Should Be Zero"));
			}
			else
			{





				if (currentval <= 0) {
					throw new ValidatorException(new FacesMessage(Messages
							.getString(PELConstants.pelErrorMessagePath, "71043")));
				}
				else
				{
					PW_IL_QQUOT_DISC_LOAD_BEAN.setQQDL_RATE_PER(currentval);

				}




				//PW_IL_QQUOT_DISC_LOAD_BEAN.setUI_QQDL_RATE_PER(helper.Decimal_Convert( Double.toString(PW_IL_QQUOT_DISC_LOAD_BEAN.getQQDL_RATE_PER())));
			}

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}


	}









	public void QQDL_VALUE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {


		Double currentval=(Double)value;

		try {
			if (currentval < 0) {
				throw new ValidatorException(new FacesMessage(Messages
						.getString(PELConstants.pelErrorMessagePath, "71043")));
			}
			else
			{
				PW_IL_QQUOT_DISC_LOAD_BEAN.setQQDL_FC_DISC_LOAD_AMT((Double) value);
			}

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}


	}



	public void QQAC_APPLIED_ON_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {

		try {
			String currval=(String) value;
			PW_IL_QQUOT_APPL_CHARGE_BEAN.setUI_CHARGE_APPLIED_ON(helper.getchargeappondesc(currval));
			//As per Ganesh Requirement when Appied when  value is Fixed then Rate per  Defaulted 1
			PW_IL_QQUOT_APPL_CHARGE_BEAN.setQQAC_APPLIED_ON((String) value);


			/*if ("3".equals(PT_IL_POL_CHARGE_BEAN.getPOC_APPLIED_ON())) {
				PT_IL_POL_CHARGE_BEAN.setPOC_RATE_PER(1.00);
				COMP_POC_RATE_PER.setDisabled(true);
			}else{
				COMP_POC_RATE_PER.setDisabled(false);
			}

			COMP_POC_RATE_PER.resetValue();*/
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void QQAC_APPLY_PERIOD_ON_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {

		try {
			String currval=(String) value;
			//As per Ganesh Requirement when Appied when  value is Fixed then Rate per  Defaulted 1
			PW_IL_QQUOT_APPL_CHARGE_BEAN.setQQAC_APPLY_PERIOD(currval);

			PW_IL_QQUOT_APPL_CHARGE_BEAN.setUI_CHARGE_APPLIED_PERIOD(helper.getchargeappperioddesc(currval));



		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void QQAC_RATE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {

		try {
			Double currval=(Double) value;

			if(currval>0){
				PW_IL_QQUOT_APPL_CHARGE_BEAN.setQQAC_RATE(currval);
				//	PW_IL_QQUOT_APPL_CHARGE_BEAN.setUI_QQAC_RATE(helper.Decimal_Convert( Double.toString(PW_IL_QQUOT_APPL_CHARGE_BEAN.getQQAC_RATE())));
			}else
			{
				throw new ValidatorException(new FacesMessage(Messages
						.getString(PELConstants.pelErrorMessagePath, "71043")));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void QQAC_RATE_PER_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {

		try {
			int currval=(Integer) value;
			if(currval>0){
				//As per Ganesh Requirement when Appied when  value is Fixed then Rate per  Defaulted 1
				PW_IL_QQUOT_APPL_CHARGE_BEAN.setQQAC_RATE_PER(currval);
				//PW_IL_QQUOT_APPL_CHARGE_BEAN.setUI_QQAC_RATE_PER(helper.Decimal_Convert( Double.toString(PW_IL_QQUOT_APPL_CHARGE_BEAN.getQQAC_RATE_PER())));
			}else
			{
				throw new ValidatorException(new FacesMessage(Messages
						.getString(PELConstants.pelErrorMessagePath, "71043")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}



	public void QQAC_FC_CHRG_AMT_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {

		try {
			Double currval=(Double) value;
			if(currval>0){
				//As per Ganesh Requirement when Appied when  value is Fixed then Rate per  Defaulted 1
				PW_IL_QQUOT_APPL_CHARGE_BEAN.setQQAC_FC_CHRG_AMT(currval);
				PW_IL_QQUOT_APPL_CHARGE_BEAN.setUI_QQAC_FC_CHRG_AMT(CommonUtils.Decimal_Convert( Double.toString(PW_IL_QQUOT_APPL_CHARGE_BEAN.getQQAC_FC_CHRG_AMT())));
			}else
			{
				throw new ValidatorException(new FacesMessage(Messages
						.getString(PELConstants.pelErrorMessagePath, "71043")));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}


	}






	public void rendercovercomponent(Boolean tflag,Boolean fflag){
		COMP_UI_m_Quick_Brk_post_cover.setRendered(tflag);
		/*Modified by ganesh on 05-04-2017 to avoid edit button display in cover details*/
		/*COMP_UI_m_Quick_Brk_Add_cover.setRendered(fflag);*/
		COMP_UI_m_Quick_Brk_Add_cover.setRendered(false);
		/*end*/
		COMP_QQAT_COVER_CODE_LABEL.setRendered(tflag);
		COMP_QQAT_COVER_CODE.setRendered(tflag);
		COMP_UI_M_QQAT_COVER_DESC.setRendered(tflag);
		COMP_QQAT_COVER_CODE_MANDATORY.setRendered(tflag);
		COMP_UI_M_QQAT_COVER_SUG_IMG.setRendered(tflag);
		//	COMP_ADD_QQAC_RATE.setRendered(tflag);
		//COMP_ADD_QQAC_RATE_PER.setRendered(tflag);
		//COMP_ADD_QQAC_RATE_LABEL.setRendered(tflag);
		//COMP_ADD_QQAC_RATE_PER_LABEL.setRendered(tflag);
		//COMP_QQAT_COVER_RATE_MANDATORY.setRendered(tflag);
		//COMP_QQAT_COVER_RATE_PER_MANDATORY.setRendered(tflag);
		//COMP_ADD_QQAC_PREMIUM_MANDATORY.setRendered(tflag);
		//COMP_ADD_QQAC_PREMIUM.setRendered(tflag);
		//COMP_ADD_QQAC_PREMIUM_LABEL.setRendered(tflag);
		COMP_ADD_QQAC_SUM_ASS_LABEL.setRendered(tflag);
		COMP_ADD_QQAC_SUM_ASS_MANDATORY.setRendered(tflag);
		COMP_ADD_QQAC_SUM_ASS.setRendered(tflag);
		COMP_ADD_QQAC_EMR_RATE.setRendered(tflag);
		COMP_ADD_QQAC_EMR_RATE_LABEL.setRendered(tflag);
		COMP_ADD_QQAC_TERM.setRendered(tflag);
		COMP_QQAT_COVER_TERM_MANDATORY.setRendered(tflag);
		COMP_ADD_QQAC_TERM_LABEL.setRendered(tflag);
		//covertoggle.setOpened(tflag);

	}
	public void renderdebitcomponent(Boolean tflag,Boolean fflag){
		COMP_UI_m_Quick_Brk_Add_debit.setRendered(fflag);
		COMP_UI_m_Quick_Brk_post_debit.setRendered(tflag);
		COMP_QQAT_DISC_LOAD_TYPE_LABEL.setRendered(tflag);
		COMP_QQAT_DISC_LOAD_TYPE.setRendered(tflag);
		COMP_QQAT_DISC_LOAD_CODE_LABEL.setRendered(tflag);
		COMP_UI_M_QQAT_DDEBIT_SUG_IMG.setRendered(tflag);
		COMP_QQAT_DISC_LOAD_CODE.setRendered(tflag);
		COMP_UI_M_DISCLOAD_DESC.setRendered(tflag);
		COMP_DIS_TYPE_MANDATORY.setRendered(tflag);
		COMP_DIS_CODE_MANDATORY.setRendered(tflag);
		COMP_ADD_QQDL_APPLIED_ON_MANDATORY.setRendered(tflag);
		COMP_ADD_QQDL_RATE_MANDATORY.setRendered(tflag);
		COMP_ADD_QQDL_APPLIED_ON_LABEL.setRendered(tflag);
		COMP_ADD_QQDL_RATE_LABLE.setRendered(tflag);
		COMP_ADD_QQDL_APPLIED_ON.setRendered(tflag);
		COMP_ADD_QQDL_RATE.setRendered(tflag);
		COMP_ADD_QQDL_RATE_PER_LABEL.setRendered(tflag);
		COMP_QQDL_RATE_PER_MANDATORY.setRendered(tflag);
		COMP_ADD_QQDL_RATE_PER.setRendered(tflag);

		COMP_QQDL_COVER_CODE_LABEL.setRendered(tflag);
		COMP_QQDL_COVER_CODE_MANDATORY.setRendered(tflag);

		COMP_QQDL_COVER_CODE.setRendered(tflag);
		COMP_UI_M_QQDL_COVER_DESC.setRendered(tflag);
		//COMP_ADD_QQDL_VALUE_LABEL.setRendered(tflag);
		//COMP_ADD_QQDL_VALUE_MANDATORY.setRendered(tflag);
		//COMP_ADD_QQDL_VALUE.setRendered(tflag);

		//debitoggle.setOpened(tflag);
	}

	public void renderchargecomponent(Boolean tflag,Boolean fflag){
		COMP_UI_m_Quick_Brk_Add_charge.setRendered(fflag);
		COMP_UI_m_Quick_Brk_post_charge.setRendered(tflag);
		COMP_QQAC_CHRG_CODE_LABEL.setRendered(tflag);
		COMP_CHARGE_CODE_MANDATORY.setRendered(tflag);
		COMP_QQAC_CHRG_CODE.setRendered(tflag);
		UI_M_CHRG_DESC.setRendered(tflag);

		COMP_UI_M_QQAT_GHARGE_SUG_IMG.setRendered(tflag);
		COMP_ADD_QQAC_APPLIED_ON_LABEL.setRendered(tflag);
		COMP_ADD_QQAC_APPLIED_ON_MANDATORY.setRendered(tflag);
		COMP_POC_APPLIED_ON.setRendered(tflag);
		COMP_ADD_QQAC_APPLY_PERIOD_LABEL.setRendered(tflag);
		COMP_ADD_QQAC_APPLY_PERIOD_MANDATORY.setRendered(tflag);
		COMP_ADD_QQAC_APPLY_PERIOD.setRendered(tflag);
		COMP_QQAC_RATE_LABEL.setRendered(tflag);
		COMP_QQAC_RATE_MANDATORY.setRendered(tflag);
		COMP_QQAC_RATE.setRendered(tflag);
		COMP_QQAC_RATE_PER_LABEL.setRendered(tflag);
		COMP_QQAC_RATE_PER_MANDATORY.setRendered(tflag);
		COMP_QQAC_RATE_PER.setRendered(tflag);
		COMP_QQAC_FC_CHRG_AMT_LABEL.setRendered(tflag);
		COMP_QQAC_FC_CHRG_AMT_MANDATORY.setRendered(tflag);
		COMP_QQAC_FC_CHRG_AMT.setRendered(tflag);




		//chargetoggle.setOpened(tflag);

	}

	public void resetcovercomponent()
	{
		COMP_QQAT_COVER_CODE.resetValue();
		COMP_UI_M_QQAT_COVER_DESC.resetValue();
		COMP_ADD_QQAC_RATE.resetValue();
		COMP_ADD_QQAC_RATE_PER.resetValue();
		COMP_ADD_QQAC_PREMIUM.resetValue();
		COMP_ADD_QQAC_SUM_ASS.resetValue();
		COMP_UI_M_QQAT_COVER_DESC.resetValue();
		COMP_ADD_QQAC_TERM.resetValue();
		COMP_ADD_QQAC_EMR_RATE.resetValue();
	}
	public void resetDiscountcomponent()
	{

		COMP_QQAT_DISC_LOAD_TYPE.resetValue();
		COMP_QQAT_DISC_LOAD_CODE.resetValue();
		COMP_UI_M_DISCLOAD_DESC.resetValue();
		COMP_ADD_QQDL_APPLIED_ON.resetValue();
		COMP_ADD_QQDL_RATE.resetValue();
		COMP_ADD_QQDL_RATE_PER.resetValue();
		COMP_ADD_QQDL_VALUE.resetValue();
		COMP_QQDL_COVER_CODE.resetValue();
		COMP_UI_M_QQDL_COVER_DESC.resetValue();
	}
	public void resetchargecomponent()
	{
		COMP_QQAC_CHRG_CODE.resetValue();
		UI_M_CHRG_DESC.resetValue();
		COMP_POC_APPLIED_ON.resetValue();
		COMP_ADD_QQAC_APPLY_PERIOD.resetValue();
		COMP_QQAC_RATE.resetValue();
		COMP_QQAC_RATE_PER.resetValue();
		COMP_QQAC_FC_CHRG_AMT.resetValue();

	}

	public String gotoprint()
	{
		compositeAction.getPRINT_ACTION_BEAN().setBlockFlag(true);
		return "PW_IL_QQUOT_PRINT";
	}


	public void  makeAmendment() throws Exception
	{
		ArrayList<OracleParameter> pValOrclList = new ArrayList<OracleParameter>();

		System.out.println("Amendment premium");

		Long quot_no = null;
		int  idx_no=0;
		try {
			//if(PW_IL_QUICK_QUOTE_BEAN.getQUOT_IDX_NO()==helper.checkmaxammenment(PW_IL_QUICK_QUOTE_BEAN.getQUOT_NO())){

			/*Added by Ram on 21/11/2016 for Amendment button issue*/
			COMP_UI_SAVE_UP.setDisabled(false);
/*End*/
			pValOrclList = PKG_PILT002_APAC_QE.COPY_QQUOT_POLICY(String.valueOf(PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID()),PW_IL_QUICK_QUOTE_BEAN.getQUOT_NO(),String.valueOf(helper.checkmaxammenment(PW_IL_QUICK_QUOTE_BEAN.getQUOT_NO())),
					"N","Y","Y","Y","Y","Y",PW_IL_QUICK_QUOTE_BEAN.getQUOT_UW_YEAR(),PW_IL_QUICK_QUOTE_BEAN.getQUOT_FM_DT(),"A","","N");
			if (pValOrclList != null && !pValOrclList.isEmpty()) {
				if (pValOrclList.get(0).getValue() != null) {

					System.out.println(pValOrclList.get(0).getValue());
					quot_no=Long.parseLong(pValOrclList.get(0).getValue());
					//idx_no=PW_IL_QUICK_QUOTE_BEAN.getQUOT_IDX_NO()+1;
					idx_no=helper.checkmaxammenment(PW_IL_QUICK_QUOTE_BEAN.getQUOT_NO());

				}

			}
			
			/*Added by Ram on 23/11/2016 for Remarks field Amendment issue*/
			boolean QUOT_MED_REC_YN_CHK = PW_IL_QUICK_QUOTE_BEAN.isQUOT_MED_REC_YN_CHK();
			String QUOT_MED_REMARKS = PW_IL_QUICK_QUOTE_BEAN.getQUOT_MED_REMARKS();
			/*End*/
			
			System.out.println(QUOT_MED_REC_YN_CHK+"         "+QUOT_MED_REMARKS);
			PW_IL_QUICK_QUOTE_BEAN  =new PW_IL_QUICK_QUOTE();
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_SYS_ID(quot_no);
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_IDX_NO(idx_no);
			
			
			
			compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().setPW_IL_QUICK_QUOTE_BEAN(PW_IL_QUICK_QUOTE_BEAN);
			delegate.executeQuery(compositeAction);
			netpremium=0.0;
			//netpremium =helper.updateGrosspre(compositeAction);
			netpremium=netpremium+delegate.calculatenetpremium(compositeAction);
			PW_IL_QUICK_QUOTE_BEAN.setUI_NET_PREMIUM(CommonUtils.Decimal_Convert(Double.toString(netpremium)));

			if(PW_IL_QUICK_QUOTE_BEAN.getQUOT_SRC_BUS().equals("075")){
				if(Double.valueOf(PW_IL_QUICK_QUOTE_BEAN.getUI_NET_PREMIUM())>0.0){
					Double commision=(PW_IL_QQUOT_BROK_DTL_BEAN.getQQBD_RATE()/PW_IL_QQUOT_BROK_DTL_BEAN.getQQBD_RATE_PER())*Double.valueOf(PW_IL_QUICK_QUOTE_BEAN.getUI_NET_PREMIUM());
					System.out.println("Commission :"+commision);
					COMP_UI_M_BUT_APPROVAL.setDisabled(false);
					
					/* Added by ganesh on 11-04-2017 for decline functionality */
					COMP_UI_M_MAKE_DECLINE.setDisabled(false);
					/*END*/
					
					String uicomm=CommonUtils.Decimal_Convert(Double.toString(commision));
					System.out.println("String Commission  :"+uicomm);
					//PW_IL_QUICK_QUOTE_BEAN.setQUOT_COMM_VALUE(commision);					
				}
			}else{
				if(Double.valueOf(PW_IL_QUICK_QUOTE_BEAN.getUI_NET_PREMIUM())>0.0){
					COMP_UI_M_BUT_APPROVAL.setDisabled(false);
					
					/* Added by ganesh on 11-04-2017 for decline functionality */
					COMP_UI_M_MAKE_DECLINE.setDisabled(false);
					/*END*/

					
				}
			}
			
			/*Added by Ram on 04/12/2016 for Amendment Pop-up display*/
			getCOMP_REPORT_MODAL_PANEL_AMENDMENT().setShowWhenRendered(false);
			System.out.println("Amendment Panel Closed");
			/*End*/
			
			//PW_IL_QUICK_QUOTE_BEAN.setUI_NET_PREMIUM(netpremium);
			disableallcomponent(false);
			COMP_UI_M_CONV_POL.setDisabled(true);
			COMP_UI_M_CLC_PREMIUM.setDisabled(false);
			COMP_UI_M_MAKE_AMMENMENT.setDisabled(true);
			COMP_UI_SAVE_DOWN.setDisabled(false);
			COMP_UI_SAVE_UP.setDisabled(false);
			COMP_UI_M_BUT_APPROVAL.setDisabled(false);

			/* Added by ganesh on 11-04-2017 for decline functionality */
			COMP_UI_M_MAKE_DECLINE.setDisabled(false);
			/*END*/

			
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_MED_REC_YN_CHK(QUOT_MED_REC_YN_CHK);
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_MED_REMARKS(QUOT_MED_REMARKS);
			
			/*}else{


				getErrorMap().put("current","you cannot do Amendment Again");

			}*/
System.out.println("End of Amendment");
		} catch (Exception e) {
			e.printStackTrace();

			this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getErrorMap().put(
					"current", e.getMessage());

		}





	}



	public void disableallcomponent(Boolean tflag){
		/*Added by Ram on 21/01/2017 for Add Praganacy field*/
		COMP_PRAGANANCY.setDisabled(tflag);
		/*End*/

		COMP_QUOT_ISS_DT.setDisabled(tflag);
		COMP_QUOT_PROD_CODE.setDisabled(tflag);
		COMP_QUOT_FM_DT.setDisabled(tflag);
		COMP_QUOT_TO_DT.setDisabled(tflag);

		COMP_QUOT_NEW_IC.setDisabled(tflag);
		COMP_QUOT_CUST_TITLE.setDisabled(tflag);
		COMP_QUOT_CUST_NAME.setDisabled(tflag);
		COMP_QUOT_CUST_LAST_NAME.setDisabled(tflag);
		COMP_QUOT_CUST_CODE.setDisabled(tflag);


		COMP_QUOT_DOB.setDisabled(tflag);
		COMP_QQOT_GENDER.setDisabled(tflag);
		COMP_QUOT_FC_SA.setDisabled(tflag);
		COMP_QUOT_PERIOD.setDisabled(tflag);
		COMP_QUOT_PREM_PAY_YRS.setDisabled(tflag);
		COMP_QQOT_FREQUENCY.setDisabled(tflag);
		COMP_QUOT_SRC_BUS.setDisabled(tflag);
		COMP_QUOT_SRC_CODE.setDisabled(tflag);
		//COMP_QUOT_NO.setDisabled(tflag);
		//	COMP_QUOT_IDX_NO.setDisabled(tflag);



		COMP_QQOT_HEIGHT.setDisabled(tflag);
		COMP_QQOT_WEIGHT.setDisabled(tflag);
		COMP_QQOT_BMI.setDisabled(tflag);
		COMP_QQOT_ADDRESS.setDisabled(tflag);
		COMP_QQOT_ADDRESS2.setDisabled(tflag);
		COMP_QQOT_ADDRESS3.setDisabled(tflag);




		COMP_QQOT_LOAN.setDisabled(tflag);
		COMP_QUOT_BANK_CODE.setDisabled(tflag);
		COMP_QUOT_BANK_DIVN.setDisabled(tflag);
		COMP_QUOT_BANK_ACNT.setDisabled(tflag);

		/*	COMP_QUOT_SO_CODE.setDisabled(tflag);
		COMP_QUOT_SM_CODE.setDisabled(tflag);
		COMP_QUOT_AGENT_COMM_RATE.setDisabled(tflag);
		COMP_QUOT_AGENT_COMM_VALUE.setDisabled(tflag);*/


		COMP_QQAD_GROSS_PREMIUM.setDisabled(tflag);
		// data table


		COMP_QQAT_COVER_CODE.setDisabled(tflag);
		COMP_ADD_QQAC_RATE.setDisabled(tflag);
		COMP_ADD_QQAC_RATE_PER.setDisabled(tflag);
		COMP_ADD_QQAC_PREMIUM.setDisabled(tflag);
		COMP_ADD_QQAC_SUM_ASS.setDisabled(tflag);
		COMP_QQAT_DISC_LOAD_TYPE.setDisabled(tflag);
		COMP_QQAT_DISC_LOAD_CODE.setDisabled(tflag);
		COMP_ADD_QQDL_APPLIED_ON.setDisabled(tflag);
		COMP_ADD_QQDL_RATE.setDisabled(tflag);
		COMP_ADD_QQDL_RATE_PER.setDisabled(tflag);
		COMP_ADD_QQDL_VALUE.setDisabled(tflag);


		COMP_QQAC_CHRG_CODE.setDisabled(tflag);
		COMP_POC_APPLIED_ON.setDisabled(tflag);

		COMP_ADD_QQAC_APPLY_PERIOD.setDisabled(tflag);
		COMP_QQAC_RATE.setDisabled(tflag);
		COMP_QQAC_RATE_PER.setDisabled(tflag);
		COMP_QQAC_FC_CHRG_AMT.setDisabled(tflag);

		COMP_UI_m_Quick_Brk_create_cover.setDisabled(tflag);
		/*Modified by ganesh on 05-04-2017 to avoid edit button display in cover details*/
		/*COMP_UI_m_Quick_Brk_Add_cover.setDisabled(tflag);*/
		COMP_UI_m_Quick_Brk_Add_cover.setDisabled(false);
		/*end*/
		COMP_Quick_DELETE_COVER.setDisabled(tflag);


		COMP_UI_m_Quick_Brk_create_debit.setDisabled(tflag);
		COMP_UI_m_Quick_Brk_Add_debit.setDisabled(tflag);
		COMP_Quick_DELETE_DEBIT.setDisabled(tflag);

		COMP_UI_m_Quick_Brk_CREATE_charge.setDisabled(tflag);
		COMP_UI_m_Quick_Brk_Add_charge.setDisabled(tflag);
		COMP_Quick_DELETE_CHARGE.setDisabled(tflag);
		COMP_EMR.setDisabled(tflag);
		COMP_QQAD_ASSURED_NAME.setDisabled(tflag);

		System.out.println("Save button is disabled         "+tflag);
		/*Added By Ramkumar on 01-08-2016*/
		COMP_SAVE_BUTTON.setDisabled(tflag);
		/*End*/
	}

	/*Added By Ramkumar on 01-08-2016*/
	private HtmlCommandButton COMP_SAVE_BUTTON;

	public HtmlCommandButton getCOMP_SAVE_BUTTON() {
		return COMP_SAVE_BUTTON;
	}


	public void setCOMP_SAVE_BUTTON(HtmlCommandButton cOMP_SAVE_BUTTON) {
		COMP_SAVE_BUTTON = cOMP_SAVE_BUTTON;
	}
	/*End*/

	//cREATING NEW CUSTOMER 


	/*	
	public String customerModalPanel() {
		try {
			System.out.println(" **** customerModalPanel **** ");
			PM006_QE_CUSTOMER_HELPER custHelper = compositeAction
					.getPM006_QE_CUSTOMER_ACTION_BEAN().getHelper();
			PM006_QE_CUSTOMER_DELEGATE custDelegate = compositeAction
					.getPM006_QE_CUSTOMER_ACTION_BEAN().getDelegate();
			CommonUtils.setGlobalVariable("CALL_FORM_FOR_CUST", "PILT002_APAC");
			if (PW_IL_QUICK_QUOTE_BEAN.getQUOT_ASSRD_REF_ID1() != null
					&& !"".equals(PW_IL_QUICK_QUOTE_BEAN.getQUOT_ASSRD_REF_ID1())) {
				System.out.println("TRUE BLOCK");

	 * CommonUtils.setGlobalVariable("GLOBAL.M_POL_ASSRD_REF_ID1",
	 * PT_IL_POLICY_BEAN.getPOL_ASSRD_REF_ID1());

				compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN()
						.getPM006_QE_CUSTOMER_BEAN().setCUST_REF_ID1(
								PW_IL_QUICK_QUOTE_BEAN.getQUOT_ASSRD_REF_ID1());
				custDelegate.executeQuery(compositeAction
						.getPM006_QE_CUSTOMER_ACTION_BEAN());
				if ("A".equalsIgnoreCase(PW_IL_QUICK_QUOTE_BEAN
						.getQUOT_APPR_STS())
						|| "Y".equalsIgnoreCase(PW_IL_QUICK_QUOTE_BEAN
								.getQUOT_FRZ_RATE())) {
					System.out.println(" NESTED TRUE BLOCK");
					compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN()
							.disableAllComponent(true);
				}
			} else {
				System.out.println("ELSE BLOCK");
				compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN()
						.setPM006_QE_CUSTOMER_BEAN(new PM006_QE_CUSTOMER());
				System.out.println("LINE 12439 ");
				custHelper.when_create_record(compositeAction
						.getPM006_QE_CUSTOMER_ACTION_BEAN()
						.getPM006_QE_CUSTOMER_BEAN());
				System.out.println("LINE 12443 ");	
				compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN()
						.disableAllComponent(false);
			}
			System.out.println("LINE 12447 ");	
			compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN()
					.getCOMP_REPORT_MODAL_PANEL_CUSTOMER().setShowWhenRendered(
							true);
			System.out.println("LINE 12451 ");	
			compositeAction.getPM_IL_CONTRACTOR_ACTION_QE_BEAN()
					.getCOMP_REPORT_MODAL_PANEL_ASSURED().setShowWhenRendered(
							false);
			System.out.println("LINE 12455 ");	
			compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN()
					.resetAllComponents();
		} catch (Exception e) {
			compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN()
					.getCOMP_REPORT_MODAL_PANEL_CUSTOMER().setShowWhenRendered(
							false);
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("customerModalPanel", e.getMessage());
		}
		return "";
	}

	 */







	public String custsaveRecord() {
		String message = null;
		CommonUtils.clearMaps(this);

		try {
			//setBeanValue();

			/*	if (PM006_QE_CUSTOMER_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					helper.pre_update(this);
					new CRUDHandler().executeInsert(PM006_QE_CUSTOMER_BEAN,
							CommonUtils.getConnection());
					helper.post_update(PM006_QE_CUSTOMER_BEAN);
					CommonUtils.getConnection().commit();
					getCOMP_REPORT_MODAL_PANEL_CUSTOMER().setShowWhenRendered(false);
					message = Messages.getString("messageProperties",
							"errorPanel$message$update");
					getWarningMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getWarningMap().put("UPDATE", message);
				} else {
					message = Messages.getString("messageProperties",
							"errorPanel$message$updatenotallowed");
					getErrorMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getErrorMap().put("UPDATE", message);
				}
			} else {*/
			if (isINSERT_ALLOWED()) {

				helper.pre_insertnewcustomer(compositeAction);
				new CRUDHandler().executeInsert(PM_CUSTOMER_BEAN,CommonUtils.getConnection());
				helper.post_insert_new_customer(PM_CUSTOMER_BEAN);
				CommonUtils.getConnection().commit();

				//custcodeDefaultInPolicy();

				message = Messages.getString("messageProperties","errorPanel$message$save");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("SAVE", message);
			} else {
				message = Messages.getString("messageProperties","errorPanel$message$insertnotallowed");
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getErrorMap().put("SAVE", message);
			}
			//}
		} catch (Exception e) {
			String message1 =ErrorHelpUtil.getUserErrorMessageFromDBErrorMessage(e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message1);
			e.printStackTrace();
		}

		return null;
	}



	// Added by Yalamanda to implement modal panel for Customer Quick Entry
	// screen.

	/*	public String onclickCancel() {
			// compositeAction.getPT_IL_POLICY_ACTION_BEAN().setFormFlag(true);
			// compositeAction.getPT_IL_POLICY_ACTION_BEAN().setBlockFlag(true);
			CommonUtils.clearMaps(this);

			compositeAction.getPM006_QE_CUSTOMER_ACTION_BEAN()
					.getCOMP_REPORT_MODAL_PANEL_CUSTOMER().setShowWhenRendered(
							false);

			return "PW_IL_QUICK_QUOTE";
		}
	 */


	public void createnewcustomer() throws Exception{


		PM_CUSTOMER_BEAN.setCUST_REF_ID1(PW_IL_QUICK_QUOTE_BEAN.getQUOT_ASSRD_REF_ID1());

		PM_CUSTOMER_BEAN.setCUST_NAME(PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_NAME());

		////altered the condition value from M,F and C to 1,2 and 3 by ganesh on 28-08-2016 suggested by Mr.VinothKumar
		if("1".equalsIgnoreCase(getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_CATG_CODE())){ 

			PM_CUSTOMER_BEAN.setCUST_CATG_CODE("1");
		}else if("2".equalsIgnoreCase(getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_CATG_CODE())){

			PM_CUSTOMER_BEAN.setCUST_CATG_CODE("2");
		}else if("3".equalsIgnoreCase(getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_CATG_CODE())){

			PM_CUSTOMER_BEAN.setCUST_CATG_CODE("3");
		}

		PM_CUSTOMER_BEAN.setCUST_DOB(getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_ASSR_DOB());

		PM_CUSTOMER_BEAN.setCUST_SURNAME(PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_SURNAME());

		PM_CUSTOMER_BEAN.setCUST_ADDR1(PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_ADDR1());
		PM_CUSTOMER_BEAN.setCUST_ADDR2(PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_ADDR2());
		PM_CUSTOMER_BEAN.setCUST_ADDR3(PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_ADDR3());

		/*	System.out.println("PM_CUSTOMER_BEAN.getCUST_ADDR1()   "+PM_CUSTOMER_BEAN.getCUST_ADDR1()+"\nPM_CUSTOMER_BEAN.getCUST_REF_ID1()      "+PM_CUSTOMER_BEAN.getCUST_REF_ID1());

			if(PM_CUSTOMER_BEAN.getCUST_ADDR1().equals(null)){
				throw new Exception("Address is required");
			}*/
		if(PM_CUSTOMER_BEAN.getCUST_REF_ID1()==null &&PM_CUSTOMER_BEAN.getCUST_REF_ID1().equals(" ") && " ".equalsIgnoreCase(PM_CUSTOMER_BEAN.getCUST_REF_ID1())){
			throw new Exception("Ic no is required");
		}

		helper.preloadnewcustomer(compositeAction);
		PM_CUSTOMER_BEAN.setCUST_FIRST_NAME(PM_CUSTOMER_BEAN.getCUST_NAME());

		try {
			if (PM_CUSTOMER_BEAN.getCUST_FIRST_NAME() == null) {
				//actionBean.getCOMP_CUST_FIRST_NAME().setRequired(true);
				throw new Exception("First name required");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}	


		try {

			if(PM_CUSTOMER_BEAN.getCUST_NAME() != null){
				helper.pm006_a_apac_pm_customer_cust_name_when_validate_item(PM_CUSTOMER_BEAN);
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}



		try {
			if (PM_CUSTOMER_BEAN.getCUST_MIDDLE_NAME() == null) {
				PM_CUSTOMER_BEAN.setCUST_MIDDLE_NAME("");
			}
			String fullName = PM_CUSTOMER_BEAN.getCUST_FIRST_NAME().concat(" ")
					+ PM_CUSTOMER_BEAN.getCUST_MIDDLE_NAME().concat(" ")
					+ PM_CUSTOMER_BEAN.getCUST_SURNAME();
			PM_CUSTOMER_BEAN.setCUST_NAME(fullName);
			PM_CUSTOMER_BEAN.setCUST_LONG_NAME(fullName);
			PM_CUSTOMER_BEAN
			.setCUST_SHORT_NAME(CommonUtils.SUBSTR(fullName, 1, 30));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}



		try {

			if(PM_CUSTOMER_BEAN.getCUST_SHORT_NAME() != null){
				helper
				.when_validate_item_CUST_SHORT_NAME(PM_CUSTOMER_BEAN);
				helper.pre_text_item_CUST_SHORT_NAME(PM_CUSTOMER_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}

		String custcode=PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_CODE();
		System.out.println("inside  condtion of validateCOMP_QQOT_ADDRESS    "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_ADDR1());
		if(PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_CODE()==null||custcode=="null"||custcode=="")
		{

			custsaveRecord();
		}
		//now
		/*COMP_QQOT_ASSR_CODE.resetValue();
			COMP_QQOT_ASSR_CODE.setDisabled(false);
			COMP_QQOT_ASSURED_NAME.resetValue();*/


	}







	public void QQDL_COVER_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value){

		try {


			String currentValue = (String) value;
			//String beanValue = PT_IL_POL_ADDL_COVER_BEAN.getPOAC_COVER_CODE();
			if((currentValue)!=null){
				//dfesfsdf
				PW_IL_QQUOT_DISC_LOAD_BEAN.setQQDL_COVER_CODE((String) value);
			}
			/*helper.setDefaultWopYN(currentValue,getPT_IL_POL_ADDL_COVER_BEAN());
				COMP_POAC_WOP_FLAG.resetValue();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			//throw new ValidatorException(new FacesMessage(e.getMessage()));
			this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getErrorMap().put(
					"current", e.getMessage());
		}
	}



	public ArrayList<LovBean> prepareSuggestionList_PDL_COVER_CODE(Object object) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		String currentValue = (String) object;


		try {
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC_QE",
					"PW_IL_QQUOT_DISC_LOAD", "QQDL_COVER_CODE", 
					PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID(), null, null, null,
					null, (String) currentValue);
			System.out.println("suggestionList       "+suggestionList);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return suggestionList;
	}

	public String cancelModalPanel(){
		getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(false);
		return "";
	}


	public String callReportModalPanel(){


		try{

			/*Added by Ram on 13/11/2016 for FALCONLIFE-1353995*/
			
			Date date1 = new Date();
			System.out.println("date1     : "+date1);
			Date date2=PW_IL_QUICK_QUOTE_BEAN.getQUOT_VALID_DT();
			System.out.println("datee2    : "+date2);
			
			

			/*boolean dateGreaterthenOrEqualTo = CommonUtils.dateGreaterthenOrEqualTo(date1,date2);
			System.out.println("dateGreaterthenOrEqualTo     : "+dateGreaterthenOrEqualTo);
			if(!dateGreaterthenOrEqualTo)
			{
				throw new Exception("Unable to Approve, Quotation already Expired ");
			}*/
			/*Added by Ram on 12/01/2017 for Validating AssuredAge concept*/
			  ResultSet rs = new CRUDHandler().executeSelectStatement("SELECT F_VAL_MAX_AGE(?) FROM DUAL", new CommonUtils().getConnection(),new Object[]{PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID()});
			  while(rs.next())
			  {
				  if(rs.getInt(1) == 1)
				  {
					  throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "71260"));
				  }
			  }
			  /*End*/
				long diff = date2.getTime() - date1.getTime();
 
				long diffDays = diff / (24 * 60 * 60 * 1000);

				System.out.print(diffDays + " days, "); 
				boolean flag=true;
			 if(diffDays < 0)
			 {
				 flag = false;
			 }
			System.out.println("flag       "+flag);
			if(!flag)
			{
				throw new Exception("Unable to Approve, Quotation already Expired ");
			}
			/*End*/
			
			System.out.println("saveClicked     "+isSaveClicked()+"     flag      "+flag);
			String address=PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_ADDR1();
			System.out.println("inside  condtion of validateCOMP_QQOT_ADDRESS    "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_ADDR1());
			/*Added by Ram on 29/08/2016 for NewIC validation changes in Approve button*/
			/*
			 * COMMENETD BY AMEEN ON 30-03-2017 TO VALIDATE IN CONVERT BTN
			 * System.out.println("PW_IL_QUICK_QUOTE_BEAN.getQUOT_ASSRD_REF_ID1()       "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_ASSRD_REF_ID1()
					);
			if(PW_IL_QUICK_QUOTE_BEAN.getQUOT_ASSRD_REF_ID1() == null || PW_IL_QUICK_QUOTE_BEAN.getQUOT_ASSRD_REF_ID1() == "")
			{
				COMP_QUOT_NEW_IC.setRequired(true);
				COMP_QUOT_NEW_IC.resetValue();

				System.out.println("Required status  "+COMP_QUOT_NEW_IC.isRequired());
				setSaveClicked(false);
				throw new Exception("New IC No: Validation Error: Value is required.");
			}

			else*/ /*End*/ if(PW_IL_QUICK_QUOTE_BEAN.getQUOT_CUST_ADDR1()==null||address=="null"||address=="")
			{
				System.out.println("inside if condtion of validateCOMP_QQOT_ADDRESS");
				COMP_QQOT_ADDRESS.setRequired(true);
				COMP_QQOT_ADDRESS.setDisabled(false);
				COMP_QQOT_ADDRESS.resetValue();
				/*Added by Ram on 29/08/2016 for NewIC validation changes in Approve button*/
				setSaveClicked(false);
				/*End*/
				System.out.println("Required status  "+COMP_QQOT_ADDRESS.isRequired());

				throw new Exception("Residential Address: Validation Error: Value is required.");
			}
			else{
				COMP_QQOT_ADDRESS.setRequired(false);
				/*Added by Ram on 29/08/2016 for NewIC validation changes in Approve button*/
				COMP_QUOT_NEW_IC.setRequired(false);
				/*End*/

				/*Added by Ram on 29/08/2016 for NewIC validation changes in Approve button*/
				if(isSaveClicked())
				{
					/* Added By Dhinesh for ssp call id  : FALCONLIFE-1352784*/ 
					
					ArrayList<OracleParameter> pValOrclList1 = null;
					String M_PREMIUM_WITHIN_LIMIT_YN = null;
					pValOrclList1 = PKG_PILT002_APAC_QE.CHECK_LC_PREMIUM_LIMIT(
							CommonUtils.getProcedureValue(PW_IL_QUICK_QUOTE_BEAN.getQUOT_SYS_ID()), M_PREMIUM_WITHIN_LIMIT_YN);
					if (!pValOrclList1.isEmpty()) {
						System.out.println("pValOrclList.get(0).getValueObject()--->"+pValOrclList1.get(0)+" "+pValOrclList1);
						if (pValOrclList1.get(0).getValue() != null) {
							M_PREMIUM_WITHIN_LIMIT_YN =  (String)pValOrclList1.get(0).getValue();
						}
					}

					if (CommonUtils.nvl(M_PREMIUM_WITHIN_LIMIT_YN, "X").equals("N")) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91330"));
					}
							
				/* End*/	
					
					getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(true);	
				}
				else
				{
					throw new Exception("Kindly save and Approve Quotation");
				}
				/*End*/
			}

		}catch(Exception e){
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}


		return "";


	}


	public String cancelModalPanelconvert(){
		getCOMP_REPORT_MODAL_PANEL_CONVERT().setShowWhenRendered(false);
		return "";
	}


	public String callReportModalPanel_convert() throws Exception{

		//if(PW_IL_QUICK_QUOTE_BEAN.getQUOT_IDX_NO()==helper.checkmaxammenment(PW_IL_QUICK_QUOTE_BEAN.getQUOT_NO())){
		

		/*ADDED BY AMEEN ON 31-03-2017 TO VALIDATE IC/ID NO. IN CONVERT BTN*/
		System.out.println("PW_IL_QUICK_QUOTE_BEAN.getQUOT_ASSRD_REF_ID1()       "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_ASSRD_REF_ID1()
				);
		try {
		
		if(PW_IL_QUICK_QUOTE_BEAN.getQUOT_ASSRD_REF_ID1() == null || PW_IL_QUICK_QUOTE_BEAN.getQUOT_ASSRD_REF_ID1() == "")
		{
			COMP_QUOT_NEW_IC.setRequired(true);
			COMP_QUOT_NEW_IC.resetValue();

			System.out.println("Required status  "+COMP_QUOT_NEW_IC.isRequired());
			setSaveClicked(false);
			throw new Exception("New IC No: Validation Error: Value is required.");
		}

		else
		/*END VALIDATE IC/ID NO.*/
			
		getCOMP_REPORT_MODAL_PANEL_CONVERT().setShowWhenRendered(true);
		/*/}
		else
		{
			//getCOMP_REPORT_MODAL_PANEL_CONVERT().setShowWhenRendered(false);
			getErrorMap().put("current","Amendment is already their for this Quotation so you cannot  able to Convert  this Quotation ");
		}*/

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return "";

	}


	public void validateQUOT_MEDICAL_YN(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_MED_YN((String) value);
			/*helper.POL_JOINT_LIFE_YN_WHEN_VALIDATE_ITEM(compositeAction,
						(String) value);*/
			System.out.println("PW_IL_QUICK_QUOTE_BEAN.setQUOT_MEDICAL_YN(   "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_MED_YN());
			
			/*Added by Ram on 24/11/2016 for Medical Related Validations*/
			/*if(PW_IL_QUICK_QUOTE_BEAN.getQUOT_MED_YN() != null && PW_IL_QUICK_QUOTE_BEAN.getQUOT_MED_YN().equals("Y"))
			{
				System.out.println("Enable Medical Received and Remarks");
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_MED_REC_YN_CHK(true);
				
				COMP_QUOT_MED_REC_YN_CHK.setDisabled(false);
				COMP_QUOT_MED_REMARKS.setDisabled(false);
				
				COMP_QUOT_MED_REMARKS.resetValue();
				COMP_QUOT_MED_REC_YN_CHK.resetValue();
			}
			else
			{
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_MED_REC_YN_CHK(false);
				
				PW_IL_QUICK_QUOTE_BEAN.setQUOT_MED_REMARKS(null);
				COMP_QUOT_MED_REC_YN_CHK.setDisabled(true);
				COMP_QUOT_MED_REMARKS.setDisabled(true);
				
				COMP_QUOT_MED_REMARKS.resetValue();
				COMP_QUOT_MED_REC_YN_CHK.resetValue();
			}
			COMP_QQAT_MEDICAL_YN.resetValue();
			COMP_QUOT_MED_REMARKS.resetValue();*/
			
			/*End*/

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "QUOT_MEDICAL_YN", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*Added by Ram on 27/11/2016 for Medical Remarks field capturing*/
	public void fireFieldValidationMedicalChk(ActionEvent event) {
		System.out.println("*************Entered into fireFieldValidationMedicalChk************");
		UIInput input = (UIInput) event.getComponent().getParent();
		  
		System.out.println("input.getSubmittedValue()        "+input.getSubmittedValue());
		PW_IL_QUICK_QUOTE_BEAN.setQUOT_MED_REC_YN_CHK((boolean)input.getSubmittedValue());

	}
	
	public void validateQUOT_MED_REMARKS(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			
			PW_IL_QUICK_QUOTE_BEAN.setQUOT_MED_REMARKS((String) value);
			
		}
		catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "QUOT_MEDICAL_YN", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
/*End*/
	/*Added by Janani on 14.9.2016 for delete functionality*/


	private String DEL_ACTION;	
	/*Added by ameen  for ssp call id FALCONLIFE-1349309 on19-10-16*/
	private HtmlAjaxCommandButton COMP_CANCEL_BUTTON_DELETE;


	public HtmlAjaxCommandButton getCOMP_CANCEL_BUTTON_DELETE() {
		return COMP_CANCEL_BUTTON_DELETE;
	}


	public void setCOMP_CANCEL_BUTTON_DELETE(
			HtmlAjaxCommandButton cOMP_CANCEL_BUTTON_DELETE) {
		COMP_CANCEL_BUTTON_DELETE = cOMP_CANCEL_BUTTON_DELETE;
	}
	/*end*/
	


	public String getDEL_ACTION() {
		return DEL_ACTION;
	}


	public void setDEL_ACTION(String dEL_ACTION) {
		DEL_ACTION = dEL_ACTION;
	}



	private HtmlModalPanel COMP_REPORT_MODAL_PANEL_DELETE;




	public HtmlModalPanel getCOMP_REPORT_MODAL_PANEL_DELETE() {
		return COMP_REPORT_MODAL_PANEL_DELETE;
	}


	public void setCOMP_REPORT_MODAL_PANEL_DELETE(
			HtmlModalPanel cOMP_REPORT_MODAL_PANEL_DELETE) {
		COMP_REPORT_MODAL_PANEL_DELETE = cOMP_REPORT_MODAL_PANEL_DELETE;
	}



	public String cancelModalPanelDelete(){
		getCOMP_REPORT_MODAL_PANEL_DELETE().setShowWhenRendered(false);
		return "";
	}


	public String callCoverReportModalPanel_delete() throws Exception{
		System.out.println("PW_IL_QUICK_QUOTE_BEAN.getQUOT_APPR_STS()        "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_APPR_STS());

		if(PW_IL_QUICK_QUOTE_BEAN.getQUOT_APPR_STS() != null && PW_IL_QUICK_QUOTE_BEAN.getQUOT_APPR_STS().equalsIgnoreCase("N")){

			CresetSelectedRow();

			PW_IL_QQUOT_APPL_COVER_BEAN = (PW_IL_QQUOT_APPL_COVER) coverdataTable.getRowData();
			PW_IL_QQUOT_APPL_COVER_BEAN.setRowSelected(true);
			getCOMP_REPORT_MODAL_PANEL_DELETE().setShowWhenRendered(true);
			setDEL_ACTION("Cover");
		}
		else
		{
			//getCOMP_REPORT_MODAL_PANEL_CONVERT().setShowWhenRendered(false);
			getErrorMap().put("current","Quotation is already Approved ");
		}

		return "";

	}

	public String callDisReportModalPanel_delete() throws Exception{
		System.out.println("PW_IL_QUICK_QUOTE_BEAN.getQUOT_APPR_STS()        "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_APPR_STS());
		if(PW_IL_QUICK_QUOTE_BEAN.getQUOT_APPR_STS() != null && PW_IL_QUICK_QUOTE_BEAN.getQUOT_APPR_STS().equalsIgnoreCase("N")){

			DresetSelectedRow();

			PW_IL_QQUOT_DISC_LOAD_BEAN = (PW_IL_QQUOT_DISC_LOAD) debitdataTable.getRowData();
			PW_IL_QQUOT_DISC_LOAD_BEAN.setRowSelected(true);
			getCOMP_REPORT_MODAL_PANEL_DELETE().setShowWhenRendered(true);
			setDEL_ACTION("Discount");
		}
		else
		{
			//getCOMP_REPORT_MODAL_PANEL_CONVERT().setShowWhenRendered(false);
			getErrorMap().put("current","Quotation is already Approved ");
		}

		return "";

	}
	public String callChargeReportModalPanel_delete() throws Exception{
		System.out.println("PW_IL_QUICK_QUOTE_BEAN.getQUOT_APPR_STS()        "+PW_IL_QUICK_QUOTE_BEAN.getQUOT_APPR_STS());
		if(PW_IL_QUICK_QUOTE_BEAN.getQUOT_APPR_STS() != null && PW_IL_QUICK_QUOTE_BEAN.getQUOT_APPR_STS().equalsIgnoreCase("N")){

			GresetSelectedRow();

			PW_IL_QQUOT_APPL_CHARGE_BEAN = (PW_IL_QQUOT_APPL_CHARGE) chargedataTable.getRowData();
			PW_IL_QQUOT_APPL_CHARGE_BEAN.setRowSelected(true);
			getCOMP_REPORT_MODAL_PANEL_DELETE().setShowWhenRendered(true);
			setDEL_ACTION("Charge");

		}
		else
		{
			//getCOMP_REPORT_MODAL_PANEL_CONVERT().setShowWhenRendered(false);
			getErrorMap().put("current","Quotation is already Approved ");
		}

		return "";

	}


	public void Deleterecord()
	{
		if(getDEL_ACTION() != null && getDEL_ACTION().equals("Cover"))
		{
			QQAC_COVER_DELETEROW();
			getCOMP_REPORT_MODAL_PANEL_DELETE().setShowWhenRendered(false);
		covertoggle.setOpened(true);
		
		}
		else if(getDEL_ACTION() != null && getDEL_ACTION().equals("Discount"))
		{
			Debit_DELETEROW();
			getCOMP_REPORT_MODAL_PANEL_DELETE().setShowWhenRendered(false);
			debitoggle.setOpened(true);
			
			
		}
		else if(getDEL_ACTION() != null && getDEL_ACTION().equals("Charge"))
		{
			QQAC_CHARGE_DELETEROW();
			getCOMP_REPORT_MODAL_PANEL_DELETE().setShowWhenRendered(false);
			chargetoggle.setOpened(true);
		}
	}

	/*end*/
	/*added by janaji for cursor issue ssp call id FALCONLIFE-1349309 on 18-10-16*/
	public void fireFieldValidationProductCode(ActionEvent event) {
		System.out.println("*************Entered into fireFieldValidationProductCode fireFieldValidation************");
		UIInput input = (UIInput) event.getComponent().getParent();
		/*
		 * if("QUOT_PROD_CODE".equals(input.getId())){
		 * PW_IL_QUICK_QUOTE_BEAN.setQUOT_PROD_CODE_DESC(null);
		 * COMP_QUOT_PROD_CODE_DESC.resetValue(); }
		 */
		CommonUtils.setGlobalObject("hiddenvalue", 1);
		getPW_IL_QUICK_QUOTE_DTLS_BEAN().setSample_value(1);

		ErrorHelpUtil.validate(input, getErrorMap());

	}
	/*end*/
	
	/*Added by Ram on 05/11/2016 for FALCONLIFE-1350739*/
	public void fireFieldValidationFreq(ActionEvent event) {
		System.out.println("*************Entered into fireFieldValidationFreq************");
		UIInput input = (UIInput) event.getComponent().getParent();
		 

		compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getWarningMap().clear();

		PW_IL_QUICK_QUOTE policyBean = compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN()
				.getPW_IL_QUICK_QUOTE_BEAN();

		Connection connection = null;
		ResultSet  rs_mop = null;
		Object[] values = {};
		policyBean.setQUOT_MOP((String)input.getSubmittedValue());


		String query_mop = " SELECT PROD_PREM_PAY_YRS  FROM    PM_IL_PRODUCT WHERE   PROD_CODE = ? ";

		Integer M_PROD1_PREM_PAY_YRS = null;



		P9ILPK_POLICY p9ilpk_policy = new P9ILPK_POLICY();
		PCOPK_GENERAL pcopk_general = new PCOPK_GENERAL();
		try {
			connection = CommonUtils.getConnection();


			if ("Y".equals(policyBean.getQUOT_MOP())
					|| "H".equals(policyBean.getQUOT_MOP())
					|| "M".equals(policyBean.getQUOT_MOP())
					|| "Q".equals(policyBean.getQUOT_MOP())) {
				rs_mop = new CRUDHandler().executeSelectStatement(query_mop, connection,
						new Object[] { policyBean.getQUOT_PROD_CODE() });

				if (rs_mop.next()) {
					 
					M_PROD1_PREM_PAY_YRS = rs_mop.getInt(1);
					    
					 
					
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_PREM_PAY_YRS().setDisabled(false);
					compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_PREM_PAY_YRS().resetValue();
					
				 
				}
			} else {
				 
				policyBean.setQUOT_PREM_PAY_YRS(1);
				compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_PREM_PAY_YRS().setDisabled(true);
				compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getCOMP_QUOT_PREM_PAY_YRS().resetValue();
			}
			 
		} catch (Exception e) {
			e.printStackTrace();
			 

		} finally {
			try {

				CommonUtils.closeCursor(rs_mop);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	

		ErrorHelpUtil.validate(input, getErrorMap());

	}
	
	/*End*/
	
	/*Added by Ram on 17/11/2016 for Product code validation*/
	private ArrayList<LovBean> PRODUCT_LIST = new ArrayList<LovBean>();




	public ArrayList<LovBean> getPRODUCT_LIST() {
		return PRODUCT_LIST;
	}


	public void setPRODUCT_LIST(ArrayList<LovBean> pRODUCT_LIST) {
		PRODUCT_LIST = pRODUCT_LIST;
	}
	/*End*/
	
	/*Added by Ram on 17/11/2016 for Adding Remarks field */
	private HtmlOutputLabel COMP_QUOT_MED_REC_YN_LABEL;
	private HtmlSelectBooleanCheckbox COMP_QUOT_MED_REC_YN;
	private HtmlOutputLabel COMP_QUOT_MED_REMARKS_LABEL;
	private HtmlInputTextarea COMP_QUOT_MED_REMARKS;
	private HtmlSimpleTogglePanel remarkstoggle;



	public HtmlOutputLabel getCOMP_QUOT_MED_REC_YN_LABEL() {
		return COMP_QUOT_MED_REC_YN_LABEL;
	}


	public void setCOMP_QUOT_MED_REC_YN_LABEL(
			HtmlOutputLabel cOMP_QUOT_MED_REC_YN_LABEL) {
		COMP_QUOT_MED_REC_YN_LABEL = cOMP_QUOT_MED_REC_YN_LABEL;
	}


	public HtmlSelectBooleanCheckbox getCOMP_QUOT_MED_REC_YN() {
		return COMP_QUOT_MED_REC_YN;
	}


	public void setCOMP_QUOT_MED_REC_YN(
			HtmlSelectBooleanCheckbox cOMP_QUOT_MED_REC_YN) {
		COMP_QUOT_MED_REC_YN = cOMP_QUOT_MED_REC_YN;
	}


	public HtmlOutputLabel getCOMP_QUOT_MED_REMARKS_LABEL() {
		return COMP_QUOT_MED_REMARKS_LABEL;
	}


	public void setCOMP_QUOT_MED_REMARKS_LABEL(
			HtmlOutputLabel cOMP_QUOT_MED_REMARKS_LABEL) {
		COMP_QUOT_MED_REMARKS_LABEL = cOMP_QUOT_MED_REMARKS_LABEL;
	}


	public HtmlInputTextarea getCOMP_QUOT_MED_REMARKS() {
		return COMP_QUOT_MED_REMARKS;
	}


	public void setCOMP_QUOT_MED_REMARKS(HtmlInputTextarea cOMP_QUOT_MED_REMARKS) {
		COMP_QUOT_MED_REMARKS = cOMP_QUOT_MED_REMARKS;
	}


	public HtmlSimpleTogglePanel getRemarkstoggle() {
		return remarkstoggle;
	}


	public void setRemarkstoggle(HtmlSimpleTogglePanel remarkstoggle) {
		this.remarkstoggle = remarkstoggle;
	}
	
	/*End*/
	private HtmlSelectBooleanCheckbox COMP_QUOT_MED_REC_YN_CHK;




	public HtmlSelectBooleanCheckbox getCOMP_QUOT_MED_REC_YN_CHK() {
		return COMP_QUOT_MED_REC_YN_CHK;
	}


	public void setCOMP_QUOT_MED_REC_YN_CHK(
			HtmlSelectBooleanCheckbox cOMP_QUOT_MED_REC_YN_CHK) {
		COMP_QUOT_MED_REC_YN_CHK = cOMP_QUOT_MED_REC_YN_CHK;
	}
	
	private HtmlCommandButton CONVERT_BUTTON_COMP;




	public HtmlCommandButton getCONVERT_BUTTON_COMP() {
		return CONVERT_BUTTON_COMP;
	}


	public void setCONVERT_BUTTON_COMP(HtmlCommandButton cONVERT_BUTTON_COMP) {
		CONVERT_BUTTON_COMP = cONVERT_BUTTON_COMP;
	}
	
	private HtmlModalPanel COMP_REPORT_MODAL_PANEL_AMENDMENT;
	
	
	public HtmlModalPanel getCOMP_REPORT_MODAL_PANEL_AMENDMENT() {
		return COMP_REPORT_MODAL_PANEL_AMENDMENT;
	}


	public void setCOMP_REPORT_MODAL_PANEL_AMENDMENT(
			HtmlModalPanel cOMP_REPORT_MODAL_PANEL_AMENDMENT) {
		COMP_REPORT_MODAL_PANEL_AMENDMENT = cOMP_REPORT_MODAL_PANEL_AMENDMENT;
	}

	/*Added by Ram on 04/12/2016 for Amendment Pop-up display*/
	public String cancelModalPanelAmendment(){
		getCOMP_REPORT_MODAL_PANEL_AMENDMENT().setShowWhenRendered(false);
		return "";
	}
	
	public String callReportModalPanel_amendment() throws Exception{
 
		getCOMP_REPORT_MODAL_PANEL_AMENDMENT().setShowWhenRendered(true);
		 
		return "";

	}
	
	private HtmlAjaxCommandButton COMP_CANCEL_BUTTON_AMENDMENT;
 
	public HtmlAjaxCommandButton getCOMP_CANCEL_BUTTON_AMENDMENT() {
		return COMP_CANCEL_BUTTON_AMENDMENT;
	}


	public void setCOMP_CANCEL_BUTTON_AMENDMENT(
			HtmlAjaxCommandButton cOMP_CANCEL_BUTTON_AMENDMENT) {
		COMP_CANCEL_BUTTON_AMENDMENT = cOMP_CANCEL_BUTTON_AMENDMENT;
	}
	/*End*/
	/*Added by Ram on 21/01/2017 for Add Praganacy field*/
	private HtmlOutputLabel COMP_PRAGANANCY_LABEL;
	
	private HtmlSelectOneMenu COMP_PRAGANANCY;
	
	public HtmlOutputLabel getCOMP_PRAGANANCY_LABEL() {
		return COMP_PRAGANANCY_LABEL;
	}


	public void setCOMP_PRAGANANCY_LABEL(HtmlOutputLabel cOMP_PRAGANANCY_LABEL) {
		COMP_PRAGANANCY_LABEL = cOMP_PRAGANANCY_LABEL;
	}


	public HtmlSelectOneMenu getCOMP_PRAGANANCY() {
		return COMP_PRAGANANCY;
	}


	public void setCOMP_PRAGANANCY(HtmlSelectOneMenu cOMP_PRAGANANCY) {
		COMP_PRAGANANCY = cOMP_PRAGANANCY;
	}
	
	public void QUOT_PRAGANENT_YN_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		//compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN();
		String QUOT_PRAGANENT_YN = (String) value;
		System.out.println("QUOT_PRAGANENT_YN        "+QUOT_PRAGANENT_YN);
		try {
			 
			getPW_IL_QUICK_QUOTE_DTLS_BEAN().setQUOT_PRAGANENT_YN(QUOT_PRAGANENT_YN);
 
			System.out.println("QUOT_PRAGANENT_YN      "+getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQUOT_PRAGANENT_YN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void enablePraganacyField()
	{
		System.out.println("compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_CATG_CODE() in enablePraganacyField      "
	+compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_CATG_CODE()+"    "+PW_IL_QUICK_QUOTE_DTLS_BEAN.getQUOT_PRAGANENT_YN());
		 
		if(!("Y".equalsIgnoreCase(PW_IL_QUICK_QUOTE_BEAN.getQUOT_CONV_YN())))
		{ 
		if(compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_CATG_CODE() != null && 
				compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getPW_IL_QUICK_QUOTE_DTLS_BEAN().getQQAD_CATG_CODE().equalsIgnoreCase("2"))
		{
			COMP_PRAGANANCY.setDisabled(false);
			if(PW_IL_QUICK_QUOTE_DTLS_BEAN.getQUOT_PRAGANENT_YN() == null)
			{
				PW_IL_QUICK_QUOTE_DTLS_BEAN.setQUOT_PRAGANENT_YN("N");	
			}
			
		}
		else
		{
			COMP_PRAGANANCY.setDisabled(true);
			PW_IL_QUICK_QUOTE_DTLS_BEAN.setQUOT_PRAGANENT_YN("N");
		}
		}
		else
		{
			COMP_PRAGANANCY.setDisabled(true);
		}
	}
	/*End*/
	

/* Added by ganesh on 04-04-2017, need to set Y flag for procedure P_QQOT_COV_DT_DFT as per Mr. Kuzhandaivel suggestion */
public void fireFieldValidationCoverTerm(ActionEvent event) {
	System.out.println("*************Entered into fireFieldValidationCoverTerm m************");
	UIInput input = (UIInput) event.getComponent().getParent();
	
	System.out.println("input.getSubmittedValue()       "+input.getSubmittedValue());
	Integer currentValue =  Integer.parseInt((String)input.getSubmittedValue());
	if(PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_PERIOD() != currentValue)
	{
		System.out.println("Enter into fireFieldValidationCoverTerm         "+PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_PERIOD()+"        "+input.getSubmittedValue());
		setChangeTerm("Y");
	}
	else
	{
		System.out.println("Npo Changes in Sumassured");
	}
	PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_PERIOD(currentValue);
	PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_PERIOD_COPY(PW_IL_QUICK_QUOTE_BEAN.getQUOT_PERIOD());
	ErrorHelpUtil.validate(input, getErrorMap());

}
public void fireFieldValidationEMR(ActionEvent event) {
	System.out.println("*************Entered into fireFieldValidationEMR m************");
	UIInput input = (UIInput) event.getComponent().getParent();
	
	System.out.println("input.getSubmittedValue()       "+input.getSubmittedValue());
	Double currentValue =  Double.parseDouble((String)input.getSubmittedValue());
	if(PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_EMR_RATE() != currentValue)
	{
		System.out.println("Enter into fireFieldValidationEMR         "+PW_IL_QQUOT_APPL_COVER_BEAN.getQQAC_EMR_RATE()+"        "+input.getSubmittedValue());
		setChangeTerm("Y");
	}
	else
	{
		System.out.println("Npo Changes in Sumassured");
	}
	PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_EMR_RATE(currentValue);
	PW_IL_QQUOT_APPL_COVER_BEAN.setQQAC_PERIOD_COPY(PW_IL_QUICK_QUOTE_BEAN.getQUOT_PERIOD());
	ErrorHelpUtil.validate(input, getErrorMap());

}
/*end*/


/* Added by ganesh on 11-04-2017 for decline functionality */ 
	private HtmlModalPanel COMP_REPORT_MODAL_PANEL_DECLINE;
	public HtmlModalPanel getCOMP_REPORT_MODAL_PANEL_DECLINE() {
		return COMP_REPORT_MODAL_PANEL_DECLINE;
	}


	public void setCOMP_REPORT_MODAL_PANEL_DECLINE(
			HtmlModalPanel cOMP_REPORT_MODAL_PANEL_DECLINE) {
		COMP_REPORT_MODAL_PANEL_DECLINE = cOMP_REPORT_MODAL_PANEL_DECLINE;
	}


	public String callReportModalPanel_Decline() throws Exception {

		getCOMP_REPORT_MODAL_PANEL_DECLINE().setShowWhenRendered(true);

		return "";

	}
	
	public String cancelModalPanelDecline(){
		getCOMP_REPORT_MODAL_PANEL_DECLINE().setShowWhenRendered(false);
		return "";
	}
	
	private HtmlCommandLink COMP_UI_M_MAKE_DECLINE;




	public HtmlCommandLink getCOMP_UI_M_MAKE_DECLINE() {
		return COMP_UI_M_MAKE_DECLINE;
	}


	public void setCOMP_UI_M_MAKE_DECLINE(HtmlCommandLink cOMP_UI_M_MAKE_DECLINE) {
		COMP_UI_M_MAKE_DECLINE = cOMP_UI_M_MAKE_DECLINE;
	}
	
	public void validateSTATUSCODE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {

		try {
			String status = (String)value;
			PW_IL_QUICK_QUOTE_BEAN.setUI_M_QQS_STATUS(status);
			
			} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "Status", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<com.iii.premia.common.bean.LovBean> lovUI_M_QQS_STATUS(
			Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC", "DUMMY",
					"M_PS_REASON_CODE", "IL_REASON", null, null, null, null,
					(String) currValue);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public void makeDecline() {
		
		try{
		System.out.println("decline started");
		getCOMP_REPORT_MODAL_PANEL_DECLINE().setShowWhenRendered(false);
		Connection con = CommonUtils.getConnection();
		PW_IL_QUICK_QUOTE_BEAN.setQUOT_APPR_STS("D");
		
		new CRUDHandler().executeUpdate(PW_IL_QUICK_QUOTE_BEAN,
				con);
		con.commit();
		String message = "Your Quotation is Declined";
		this.compositeAction.getPW_IL_QUICK_QUOTE_ACTION_BEAN().getWarningMap().put(
				"current", message);
		setBlockFlag(true);
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
	
	public void disableButtonsWhenDeclined(){
		
		/*Added by ganesh on 14-04-2017 for decline functionality*/
		disableallcomponent(true);
		/*end*/
		
		COMP_UI_M_BUT_APPROVAL.setDisabled(true);
		COMP_UI_M_CONV_POL.setDisabled(true);
		COMP_UI_M_MAKE_AMMENMENT.setDisabled(true);
		COMP_UI_M_MAKE_DECLINE.setDisabled(true);
		COMP_UI_M_CLC_PREMIUM.setDisabled(true);
		COMP_UI_M_BUT_EXPAND_LINK.setDisabled(true);
		COMP_UI_SAVE_UP.setDisabled(true);
		COMP_UI_SAVE_DOWN.setDisabled(true);
		compositeAction.getPRINT_ACTION_BEAN().getCOMP_QQAT_PRINT().setDisabled(true);
		getCOMP_UI_M_APPRV_STATUS().setValue("You cannot do any change because quotation was already declined");
		PW_IL_QUICK_QUOTE_BEAN.setUI_M_APPRV_STATUS("You cannot do any change because quotation was already declined");		
	}
	/*end*/

	/*Added by ganesh on 14-04-2017 for decline functionality*/
	private HtmlInputTextarea COMP_UI_M_QQT_REMARKS;
	private HtmlInputText COMP_UI_M_QQS_STATUS;




	public HtmlInputTextarea getCOMP_UI_M_QQT_REMARKS() {
		return COMP_UI_M_QQT_REMARKS;
	}


	public void setCOMP_UI_M_QQT_REMARKS(HtmlInputTextarea cOMP_UI_M_QQT_REMARKS) {
		COMP_UI_M_QQT_REMARKS = cOMP_UI_M_QQT_REMARKS;
	}


	public HtmlInputText getCOMP_UI_M_QQS_STATUS() {
		return COMP_UI_M_QQS_STATUS;
	}


	public void setCOMP_UI_M_QQS_STATUS(HtmlInputText cOMP_UI_M_QQS_STATUS) {
		COMP_UI_M_QQS_STATUS = cOMP_UI_M_QQS_STATUS;
	}
	public void validateDEC_REMARKS(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			
			PW_IL_QUICK_QUOTE_BEAN.setUI_M_QQT_REMARKS((String) value);
			
		}
		catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "Remarks", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/*end*/
}
