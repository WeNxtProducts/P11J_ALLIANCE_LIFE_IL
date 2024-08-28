package com.iii.pel.forms.PILT021;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletResponse;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlModalPanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.common.dms.DMSUtil;
import com.iii.pel.forms.PILT016A_APAC.IP_REP_INFO;
import com.iii.pel.utils.P9ILPK_WITHDRAWAL_PROCESS;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
import com.iii.premia.common.utils.ReportUtils;

public class PT_IL_WITHDRAWAL_ACTION extends CommonReportAction {

	private HtmlOutputLabel COMP_UI_M_POL_NO_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO;

	private HtmlOutputLabel COMP_UI_M_APPRV_STATUS;

	private HtmlOutputLabel COMP_UI_M_APPRV_DT_LABEL;

	private HtmlCalendar COMP_UI_M_APPRV_DT;

	private HtmlOutputLabel COMP_UI_M_POL_ISSUE_DT_LABEL;

	private HtmlCalendar COMP_UI_M_POL_ISSUE_DT;

	private HtmlOutputLabel COMP_UI_M_STATUS_DESC;

	private HtmlOutputLabel COMP_UI_M_POL_CUST_CODE_LABEL;

	private HtmlInputText COMP_UI_M_POL_CUST_CODE;

	private HtmlOutputLabel COMP_UI_M_POL_CUST_NAME_LABEL;

	private HtmlInputText COMP_UI_M_POL_CUST_NAME;

	private HtmlOutputLabel COMP_WD_DATE_LABEL;

	private HtmlCalendar COMP_WD_DATE;

	private HtmlOutputLabel COMP_WD_FLEX_01_LABEL;

	private HtmlInputText COMP_WD_FLEX_01;

	private HtmlOutputLabel COMP_WD_DOC_NO_LABEL;

	private HtmlInputText COMP_WD_DOC_NO;

	private HtmlOutputLabel COMP_WD_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_WD_TYPE;

	private HtmlOutputLabel COMP_WD_FULL_YN_LABEL;

	private HtmlSelectOneMenu COMP_WD_FULL_YN;

	private HtmlOutputLabel COMP_WD_AMOUNT_YN_LABEL;

	private HtmlSelectOneMenu COMP_WD_AMOUNT_YN;

	private HtmlOutputLabel COMP_WD_NUMBER_LABEL;

	private HtmlInputText COMP_WD_NUMBER;

	private HtmlOutputLabel COMP_WD_PREM_TXN_CODE_LABEL;

	private HtmlInputText COMP_WD_PREM_TXN_CODE;

	private HtmlOutputLabel COMP_WD_RATE_LABEL;

	private HtmlInputText COMP_WD_RATE;

	private HtmlOutputLabel COMP_WD_RATE_PER_LABEL;

	private HtmlInputText COMP_WD_RATE_PER;

	private HtmlOutputLabel COMP_WD_PREM_DOC_NO_LABEL;

	private HtmlInputText COMP_WD_PREM_DOC_NO;

	private HtmlOutputLabel COMP_WD_GROSS_FC_VALUE_LABEL;

	private HtmlInputText COMP_WD_GROSS_FC_VALUE;

	private HtmlOutputLabel COMP_WD_GROSS_LC_VALUE_LABEL;

	private HtmlInputText COMP_WD_GROSS_LC_VALUE;

	private HtmlOutputLabel COMP_WD_TOP_UP_TXN_CODE_LABEL;

	private HtmlInputText COMP_WD_TOP_UP_TXN_CODE;

	private HtmlOutputLabel COMP_WD_NET_FC_VALUE_LABEL;

	private HtmlInputText COMP_WD_NET_FC_VALUE;

	private HtmlOutputLabel COMP_WD_NET_LC_VALUE_LABEL;

	private HtmlInputText COMP_WD_NET_LC_VALUE;

	private HtmlOutputLabel COMP_WD_TOP_UP_DOC_NO_LABEL;

	private HtmlInputText COMP_WD_TOP_UP_DOC_NO;

	private HtmlOutputLabel COMP_WD_TOPUP_FC_AMT_LABEL;

	private HtmlInputText COMP_WD_TOPUP_FC_AMT;

	private HtmlOutputLabel COMP_WD_TOPUP_LC_AMT_LABEL;

	private HtmlInputText COMP_WD_TOPUP_LC_AMT;

	private HtmlOutputLabel COMP_WD_DOC_DT_LABEL;

	private HtmlCalendar COMP_WD_DOC_DT;

	private HtmlOutputLabel COMP_UI_M_RED_SUM_ASSURED_LABEL;

	private HtmlInputText COMP_UI_M_RED_SUM_ASSURED;

	private HtmlOutputLabel COMP_WD_NET_TOP_UP_FC_VALUE_LABEL;

	private HtmlInputText COMP_WD_NET_TOP_UP_FC_VALUE;

	private HtmlOutputLabel COMP_WD_NET_TOP_UP_LC_VALUE_LABEL;

	private HtmlInputText COMP_WD_NET_TOP_UP_LC_VALUE;

	private HtmlOutputLabel COMP_WD_PAY_TO_LABEL;

	private HtmlSelectOneMenu COMP_WD_PAY_TO;

	private HtmlOutputLabel COMP_WD_TOPUP_INT_FC_AMT_LABEL;

	private HtmlInputText COMP_WD_TOPUP_INT_FC_AMT;

	private HtmlOutputLabel COMP_WD_TOPUP_INT_LC_AMT_LABEL;

	private HtmlInputText COMP_WD_TOPUP_INT_LC_AMT;

	private HtmlCommandButton COMP_UI_M_BUT_APPROVE;

	private HtmlCommandButton COMP_PUSH_BUTTON214;

	private HtmlCommandButton COMP_UI_M_BUT_REP_POLICY;

	private HtmlCommandButton COMP_UI_M_WITHDRAWAL_STATUS;

	private HtmlCommandButton COMP_UI_M_BUT_POL_HIST;

	private HtmlCommandButton COMP_UI_M_BUT_FUND_ALLOC;
	
	private HtmlCommandButton COMP_UI_M_BUT_KEY_COMMIT;

	private PT_IL_WITHDRAWAL PT_IL_WITHDRAWAL_BEAN;

	public PILT021_COMPOSITE_ACTION compositeAction;
	
	private IP_REP_INFO IP_REP_INFO_BEAN;
 	
	private HtmlCommandButton COMP_UI_M_BUT_REPORT;

	private PT_IL_WITHDRAWAL_HELPER helper;

	private List<SelectItem> listWD_TYPE = new ArrayList<SelectItem>();

	private List<SelectItem> listWD_FULL_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listWD_AMOUNT_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listWD_PAY_TO = new ArrayList<SelectItem>();
	
	P9ILPK_WITHDRAWAL_PROCESS p9ilpk_withdrawal=new P9ILPK_WITHDRAWAL_PROCESS();

	ArrayList<LovBean> lovList = new ArrayList<LovBean>();

	Connection connection = null;

	DUMMY dummy = null;

	String DEFAULT_WHERE;
	
	private HtmlOutputLabel COMP_WD_APPROVAL_LABEL;
	
	//ADDED FOR EFT DETAILS
	private HtmlSelectOneMenu COMP_TYPE;
	private HtmlInputText COMP_MICR_CODE;
	private HtmlInputText COMP_ACC_NO;
	private HtmlOutputLabel COMP_TYPE_LABEL;
	private HtmlOutputLabel COMP_MICR_CODE_LABEL;
	private HtmlOutputLabel COMP_ACC_NO_LABEL;
	private HtmlAjaxCommandButton COMP_EFT_BUT;
	private List<SelectItem> listLOAN_FLEX_04 = new ArrayList<SelectItem>();

	

	public HtmlOutputLabel getCOMP_WD_APPROVAL_LABEL() {
		return COMP_WD_APPROVAL_LABEL;
	}

	public void setCOMP_WD_APPROVAL_LABEL(HtmlOutputLabel comp_wd_approval_label) {
		COMP_WD_APPROVAL_LABEL = comp_wd_approval_label;
	}

	public PT_IL_WITHDRAWAL_ACTION() {
		PT_IL_WITHDRAWAL_BEAN = new PT_IL_WITHDRAWAL();
		helper = new PT_IL_WITHDRAWAL_HELPER();
		IP_REP_INFO_BEAN =  new IP_REP_INFO();
		COMP_UI_M_APPRV_DT = new HtmlCalendar();
		instantiateAllComponent();
		populateDropDowns();
		setListItemValues();

		
	}
	public void setListItemValues(){
		List<SelectItem> listStandard = new ArrayList<SelectItem>();
		
		/*listStandard.add(new SelectItem("OTHERS", "OTHERS"));
		listStandard.add(new SelectItem("EFT", "EFT"));*/
		
		/*Commentted &Modified by saritha on 28-12-2017 for ssp call id : ZBLIFE-1464439*/ 
		
		/*NEWLY ADDED BY DHINESH ON 6-6-2017*/ 
		/*listStandard.add(new SelectItem("OTHERS", "OTHERS"));
		listStandard.add(new SelectItem("EFT", "Paynet"));
		listStandard.add(new SelectItem("CHK", "Cheque"));*/
		/*End*/
		listStandard.add(new SelectItem("CHK", "Cheque"));
		listStandard.add(new SelectItem("OTHERS", "RTGS"));
		listStandard.add(new SelectItem("EFT", "Bank Transfer"));
		listStandard.add(new SelectItem("ECO", "Ecocash"));
		listStandard.add(new SelectItem("WAL", "One Wallet"));
		listStandard.add(new SelectItem("TEL", "Telecash"));
		/*End*/
		
		setListLOAN_FLEX_04(listStandard);

	}


	public HtmlOutputLabel getCOMP_UI_M_POL_NO_LABEL() {
		return COMP_UI_M_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO() {
		return COMP_UI_M_POL_NO;
	}

	public void setCOMP_UI_M_POL_NO_LABEL(HtmlOutputLabel COMP_UI_M_POL_NO_LABEL) {
		this.COMP_UI_M_POL_NO_LABEL = COMP_UI_M_POL_NO_LABEL;
	}

	public void setCOMP_UI_M_POL_NO(HtmlInputText COMP_UI_M_POL_NO) {
		this.COMP_UI_M_POL_NO = COMP_UI_M_POL_NO;
	}

	public HtmlOutputLabel getCOMP_UI_M_APPRV_STATUS() {
		return COMP_UI_M_APPRV_STATUS;
	}

	public void setCOMP_UI_M_APPRV_STATUS(HtmlOutputLabel COMP_UI_M_APPRV_STATUS) {
		this.COMP_UI_M_APPRV_STATUS = COMP_UI_M_APPRV_STATUS;
	}

	public HtmlOutputLabel getCOMP_UI_M_APPRV_DT_LABEL() {
		return COMP_UI_M_APPRV_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_APPRV_DT() {
		return COMP_UI_M_APPRV_DT;
	}

	public void setCOMP_UI_M_APPRV_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_APPRV_DT_LABEL) {
		this.COMP_UI_M_APPRV_DT_LABEL = COMP_UI_M_APPRV_DT_LABEL;
	}

	public void setCOMP_UI_M_APPRV_DT(HtmlCalendar COMP_UI_M_APPRV_DT) {
		this.COMP_UI_M_APPRV_DT = COMP_UI_M_APPRV_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_ISSUE_DT_LABEL() {
		return COMP_UI_M_POL_ISSUE_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_POL_ISSUE_DT() {
		return COMP_UI_M_POL_ISSUE_DT;
	}

	public void setCOMP_UI_M_POL_ISSUE_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_ISSUE_DT_LABEL) {
		this.COMP_UI_M_POL_ISSUE_DT_LABEL = COMP_UI_M_POL_ISSUE_DT_LABEL;
	}

	public void setCOMP_UI_M_POL_ISSUE_DT(HtmlCalendar COMP_UI_M_POL_ISSUE_DT) {
		this.COMP_UI_M_POL_ISSUE_DT = COMP_UI_M_POL_ISSUE_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_STATUS_DESC() {
		return COMP_UI_M_STATUS_DESC;
	}

	public void setCOMP_UI_M_STATUS_DESC(HtmlOutputLabel COMP_UI_M_STATUS_DESC) {
		this.COMP_UI_M_STATUS_DESC = COMP_UI_M_STATUS_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_CUST_CODE_LABEL() {
		return COMP_UI_M_POL_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_CUST_CODE() {
		return COMP_UI_M_POL_CUST_CODE;
	}

	public void setCOMP_UI_M_POL_CUST_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_CUST_CODE_LABEL) {
		this.COMP_UI_M_POL_CUST_CODE_LABEL = COMP_UI_M_POL_CUST_CODE_LABEL;
	}

	public void setCOMP_UI_M_POL_CUST_CODE(HtmlInputText COMP_UI_M_POL_CUST_CODE) {
		this.COMP_UI_M_POL_CUST_CODE = COMP_UI_M_POL_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_CUST_NAME_LABEL() {
		return COMP_UI_M_POL_CUST_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_CUST_NAME() {
		return COMP_UI_M_POL_CUST_NAME;
	}

	public void setCOMP_UI_M_POL_CUST_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_CUST_NAME_LABEL) {
		this.COMP_UI_M_POL_CUST_NAME_LABEL = COMP_UI_M_POL_CUST_NAME_LABEL;
	}

	public void setCOMP_UI_M_POL_CUST_NAME(HtmlInputText COMP_UI_M_POL_CUST_NAME) {
		this.COMP_UI_M_POL_CUST_NAME = COMP_UI_M_POL_CUST_NAME;
	}

	public HtmlOutputLabel getCOMP_WD_DATE_LABEL() {
		return COMP_WD_DATE_LABEL;
	}

	public HtmlCalendar getCOMP_WD_DATE() {
		return COMP_WD_DATE;
	}

	public void setCOMP_WD_DATE_LABEL(HtmlOutputLabel COMP_WD_DATE_LABEL) {
		this.COMP_WD_DATE_LABEL = COMP_WD_DATE_LABEL;
	}

	public void setCOMP_WD_DATE(HtmlCalendar COMP_WD_DATE) {
		this.COMP_WD_DATE = COMP_WD_DATE;
	}

	public HtmlOutputLabel getCOMP_WD_FLEX_01_LABEL() {
		return COMP_WD_FLEX_01_LABEL;
	}

	public HtmlInputText getCOMP_WD_FLEX_01() {
		return COMP_WD_FLEX_01;
	}

	public void setCOMP_WD_FLEX_01_LABEL(HtmlOutputLabel COMP_WD_FLEX_01_LABEL) {
		this.COMP_WD_FLEX_01_LABEL = COMP_WD_FLEX_01_LABEL;
	}

	public void setCOMP_WD_FLEX_01(HtmlInputText COMP_WD_FLEX_01) {
		this.COMP_WD_FLEX_01 = COMP_WD_FLEX_01;
	}

	public HtmlOutputLabel getCOMP_WD_DOC_NO_LABEL() {
		return COMP_WD_DOC_NO_LABEL;
	}

	public HtmlInputText getCOMP_WD_DOC_NO() {
		return COMP_WD_DOC_NO;
	}

	public void setCOMP_WD_DOC_NO_LABEL(HtmlOutputLabel COMP_WD_DOC_NO_LABEL) {
		this.COMP_WD_DOC_NO_LABEL = COMP_WD_DOC_NO_LABEL;
	}

	public void setCOMP_WD_DOC_NO(HtmlInputText COMP_WD_DOC_NO) {
		this.COMP_WD_DOC_NO = COMP_WD_DOC_NO;
	}

	public HtmlOutputLabel getCOMP_WD_TYPE_LABEL() {
		return COMP_WD_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_WD_TYPE() {
		return COMP_WD_TYPE;
	}

	public void setCOMP_WD_TYPE_LABEL(HtmlOutputLabel COMP_WD_TYPE_LABEL) {
		this.COMP_WD_TYPE_LABEL = COMP_WD_TYPE_LABEL;
	}

	public void setCOMP_WD_TYPE(HtmlSelectOneMenu COMP_WD_TYPE) {
		this.COMP_WD_TYPE = COMP_WD_TYPE;
	}

	public HtmlOutputLabel getCOMP_WD_FULL_YN_LABEL() {
		return COMP_WD_FULL_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_WD_FULL_YN() {
		return COMP_WD_FULL_YN;
	}

	public void setCOMP_WD_FULL_YN_LABEL(HtmlOutputLabel COMP_WD_FULL_YN_LABEL) {
		this.COMP_WD_FULL_YN_LABEL = COMP_WD_FULL_YN_LABEL;
	}

	public void setCOMP_WD_FULL_YN(HtmlSelectOneMenu COMP_WD_FULL_YN) {
		this.COMP_WD_FULL_YN = COMP_WD_FULL_YN;
	}

	public HtmlOutputLabel getCOMP_WD_AMOUNT_YN_LABEL() {
		return COMP_WD_AMOUNT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_WD_AMOUNT_YN() {
		return COMP_WD_AMOUNT_YN;
	}

	public void setCOMP_WD_AMOUNT_YN_LABEL(
			HtmlOutputLabel COMP_WD_AMOUNT_YN_LABEL) {
		this.COMP_WD_AMOUNT_YN_LABEL = COMP_WD_AMOUNT_YN_LABEL;
	}

	public void setCOMP_WD_AMOUNT_YN(HtmlSelectOneMenu COMP_WD_AMOUNT_YN) {
		this.COMP_WD_AMOUNT_YN = COMP_WD_AMOUNT_YN;
	}

	public HtmlOutputLabel getCOMP_WD_NUMBER_LABEL() {
		return COMP_WD_NUMBER_LABEL;
	}

	public HtmlInputText getCOMP_WD_NUMBER() {
		return COMP_WD_NUMBER;
	}

	public void setCOMP_WD_NUMBER_LABEL(HtmlOutputLabel COMP_WD_NUMBER_LABEL) {
		this.COMP_WD_NUMBER_LABEL = COMP_WD_NUMBER_LABEL;
	}

	public void setCOMP_WD_NUMBER(HtmlInputText COMP_WD_NUMBER) {
		this.COMP_WD_NUMBER = COMP_WD_NUMBER;
	}

	public HtmlOutputLabel getCOMP_WD_PREM_TXN_CODE_LABEL() {
		return COMP_WD_PREM_TXN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_WD_PREM_TXN_CODE() {
		return COMP_WD_PREM_TXN_CODE;
	}

	public void setCOMP_WD_PREM_TXN_CODE_LABEL(
			HtmlOutputLabel COMP_WD_PREM_TXN_CODE_LABEL) {
		this.COMP_WD_PREM_TXN_CODE_LABEL = COMP_WD_PREM_TXN_CODE_LABEL;
	}

	public void setCOMP_WD_PREM_TXN_CODE(HtmlInputText COMP_WD_PREM_TXN_CODE) {
		this.COMP_WD_PREM_TXN_CODE = COMP_WD_PREM_TXN_CODE;
	}

	public HtmlOutputLabel getCOMP_WD_RATE_LABEL() {
		return COMP_WD_RATE_LABEL;
	}

	public HtmlInputText getCOMP_WD_RATE() {
		return COMP_WD_RATE;
	}

	public void setCOMP_WD_RATE_LABEL(HtmlOutputLabel COMP_WD_RATE_LABEL) {
		this.COMP_WD_RATE_LABEL = COMP_WD_RATE_LABEL;
	}

	public void setCOMP_WD_RATE(HtmlInputText COMP_WD_RATE) {
		this.COMP_WD_RATE = COMP_WD_RATE;
	}

	public HtmlOutputLabel getCOMP_WD_RATE_PER_LABEL() {
		return COMP_WD_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_WD_RATE_PER() {
		return COMP_WD_RATE_PER;
	}

	public void setCOMP_WD_RATE_PER_LABEL(HtmlOutputLabel COMP_WD_RATE_PER_LABEL) {
		this.COMP_WD_RATE_PER_LABEL = COMP_WD_RATE_PER_LABEL;
	}

	public void setCOMP_WD_RATE_PER(HtmlInputText COMP_WD_RATE_PER) {
		this.COMP_WD_RATE_PER = COMP_WD_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_WD_PREM_DOC_NO_LABEL() {
		return COMP_WD_PREM_DOC_NO_LABEL;
	}

	public HtmlInputText getCOMP_WD_PREM_DOC_NO() {
		return COMP_WD_PREM_DOC_NO;
	}

	public void setCOMP_WD_PREM_DOC_NO_LABEL(
			HtmlOutputLabel COMP_WD_PREM_DOC_NO_LABEL) {
		this.COMP_WD_PREM_DOC_NO_LABEL = COMP_WD_PREM_DOC_NO_LABEL;
	}

	public void setCOMP_WD_PREM_DOC_NO(HtmlInputText COMP_WD_PREM_DOC_NO) {
		this.COMP_WD_PREM_DOC_NO = COMP_WD_PREM_DOC_NO;
	}

	public HtmlOutputLabel getCOMP_WD_GROSS_FC_VALUE_LABEL() {
		return COMP_WD_GROSS_FC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_WD_GROSS_FC_VALUE() {
		return COMP_WD_GROSS_FC_VALUE;
	}

	public void setCOMP_WD_GROSS_FC_VALUE_LABEL(
			HtmlOutputLabel COMP_WD_GROSS_FC_VALUE_LABEL) {
		this.COMP_WD_GROSS_FC_VALUE_LABEL = COMP_WD_GROSS_FC_VALUE_LABEL;
	}

	public void setCOMP_WD_GROSS_FC_VALUE(HtmlInputText COMP_WD_GROSS_FC_VALUE) {
		this.COMP_WD_GROSS_FC_VALUE = COMP_WD_GROSS_FC_VALUE;
	}

	public HtmlOutputLabel getCOMP_WD_GROSS_LC_VALUE_LABEL() {
		return COMP_WD_GROSS_LC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_WD_GROSS_LC_VALUE() {
		return COMP_WD_GROSS_LC_VALUE;
	}

	public void setCOMP_WD_GROSS_LC_VALUE_LABEL(
			HtmlOutputLabel COMP_WD_GROSS_LC_VALUE_LABEL) {
		this.COMP_WD_GROSS_LC_VALUE_LABEL = COMP_WD_GROSS_LC_VALUE_LABEL;
	}

	public void setCOMP_WD_GROSS_LC_VALUE(HtmlInputText COMP_WD_GROSS_LC_VALUE) {
		this.COMP_WD_GROSS_LC_VALUE = COMP_WD_GROSS_LC_VALUE;
	}

	public HtmlOutputLabel getCOMP_WD_TOP_UP_TXN_CODE_LABEL() {
		return COMP_WD_TOP_UP_TXN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_WD_TOP_UP_TXN_CODE() {
		return COMP_WD_TOP_UP_TXN_CODE;
	}

	public void setCOMP_WD_TOP_UP_TXN_CODE_LABEL(
			HtmlOutputLabel COMP_WD_TOP_UP_TXN_CODE_LABEL) {
		this.COMP_WD_TOP_UP_TXN_CODE_LABEL = COMP_WD_TOP_UP_TXN_CODE_LABEL;
	}

	public void setCOMP_WD_TOP_UP_TXN_CODE(HtmlInputText COMP_WD_TOP_UP_TXN_CODE) {
		this.COMP_WD_TOP_UP_TXN_CODE = COMP_WD_TOP_UP_TXN_CODE;
	}

	public HtmlOutputLabel getCOMP_WD_NET_FC_VALUE_LABEL() {
		return COMP_WD_NET_FC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_WD_NET_FC_VALUE() {
		return COMP_WD_NET_FC_VALUE;
	}

	public void setCOMP_WD_NET_FC_VALUE_LABEL(
			HtmlOutputLabel COMP_WD_NET_FC_VALUE_LABEL) {
		this.COMP_WD_NET_FC_VALUE_LABEL = COMP_WD_NET_FC_VALUE_LABEL;
	}

	public void setCOMP_WD_NET_FC_VALUE(HtmlInputText COMP_WD_NET_FC_VALUE) {
		this.COMP_WD_NET_FC_VALUE = COMP_WD_NET_FC_VALUE;
	}

	public HtmlOutputLabel getCOMP_WD_NET_LC_VALUE_LABEL() {
		return COMP_WD_NET_LC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_WD_NET_LC_VALUE() {
		return COMP_WD_NET_LC_VALUE;
	}

	public void setCOMP_WD_NET_LC_VALUE_LABEL(
			HtmlOutputLabel COMP_WD_NET_LC_VALUE_LABEL) {
		this.COMP_WD_NET_LC_VALUE_LABEL = COMP_WD_NET_LC_VALUE_LABEL;
	}

	public void setCOMP_WD_NET_LC_VALUE(HtmlInputText COMP_WD_NET_LC_VALUE) {
		this.COMP_WD_NET_LC_VALUE = COMP_WD_NET_LC_VALUE;
	}

	public HtmlOutputLabel getCOMP_WD_TOP_UP_DOC_NO_LABEL() {
		return COMP_WD_TOP_UP_DOC_NO_LABEL;
	}

	public HtmlInputText getCOMP_WD_TOP_UP_DOC_NO() {
		return COMP_WD_TOP_UP_DOC_NO;
	}

	public void setCOMP_WD_TOP_UP_DOC_NO_LABEL(
			HtmlOutputLabel COMP_WD_TOP_UP_DOC_NO_LABEL) {
		this.COMP_WD_TOP_UP_DOC_NO_LABEL = COMP_WD_TOP_UP_DOC_NO_LABEL;
	}

	public void setCOMP_WD_TOP_UP_DOC_NO(HtmlInputText COMP_WD_TOP_UP_DOC_NO) {
		this.COMP_WD_TOP_UP_DOC_NO = COMP_WD_TOP_UP_DOC_NO;
	}

	public HtmlOutputLabel getCOMP_WD_TOPUP_FC_AMT_LABEL() {
		return COMP_WD_TOPUP_FC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_WD_TOPUP_FC_AMT() {
		return COMP_WD_TOPUP_FC_AMT;
	}

	public void setCOMP_WD_TOPUP_FC_AMT_LABEL(
			HtmlOutputLabel COMP_WD_TOPUP_FC_AMT_LABEL) {
		this.COMP_WD_TOPUP_FC_AMT_LABEL = COMP_WD_TOPUP_FC_AMT_LABEL;
	}

	public void setCOMP_WD_TOPUP_FC_AMT(HtmlInputText COMP_WD_TOPUP_FC_AMT) {
		this.COMP_WD_TOPUP_FC_AMT = COMP_WD_TOPUP_FC_AMT;
	}

	public HtmlOutputLabel getCOMP_WD_TOPUP_LC_AMT_LABEL() {
		return COMP_WD_TOPUP_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_WD_TOPUP_LC_AMT() {
		return COMP_WD_TOPUP_LC_AMT;
	}

	public void setCOMP_WD_TOPUP_LC_AMT_LABEL(
			HtmlOutputLabel COMP_WD_TOPUP_LC_AMT_LABEL) {
		this.COMP_WD_TOPUP_LC_AMT_LABEL = COMP_WD_TOPUP_LC_AMT_LABEL;
	}

	public void setCOMP_WD_TOPUP_LC_AMT(HtmlInputText COMP_WD_TOPUP_LC_AMT) {
		this.COMP_WD_TOPUP_LC_AMT = COMP_WD_TOPUP_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_WD_DOC_DT_LABEL() {
		return COMP_WD_DOC_DT_LABEL;
	}

	public HtmlCalendar getCOMP_WD_DOC_DT() {
		return COMP_WD_DOC_DT;
	}

	public void setCOMP_WD_DOC_DT_LABEL(HtmlOutputLabel COMP_WD_DOC_DT_LABEL) {
		this.COMP_WD_DOC_DT_LABEL = COMP_WD_DOC_DT_LABEL;
	}

	public void setCOMP_WD_DOC_DT(HtmlCalendar COMP_WD_DOC_DT) {
		this.COMP_WD_DOC_DT = COMP_WD_DOC_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_RED_SUM_ASSURED_LABEL() {
		return COMP_UI_M_RED_SUM_ASSURED_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_RED_SUM_ASSURED() {
		return COMP_UI_M_RED_SUM_ASSURED;
	}

	public void setCOMP_UI_M_RED_SUM_ASSURED_LABEL(
			HtmlOutputLabel COMP_UI_M_RED_SUM_ASSURED_LABEL) {
		this.COMP_UI_M_RED_SUM_ASSURED_LABEL = COMP_UI_M_RED_SUM_ASSURED_LABEL;
	}

	public void setCOMP_UI_M_RED_SUM_ASSURED(
			HtmlInputText COMP_UI_M_RED_SUM_ASSURED) {
		this.COMP_UI_M_RED_SUM_ASSURED = COMP_UI_M_RED_SUM_ASSURED;
	}

	public HtmlOutputLabel getCOMP_WD_NET_TOP_UP_FC_VALUE_LABEL() {
		return COMP_WD_NET_TOP_UP_FC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_WD_NET_TOP_UP_FC_VALUE() {
		return COMP_WD_NET_TOP_UP_FC_VALUE;
	}

	public void setCOMP_WD_NET_TOP_UP_FC_VALUE_LABEL(
			HtmlOutputLabel COMP_WD_NET_TOP_UP_FC_VALUE_LABEL) {
		this.COMP_WD_NET_TOP_UP_FC_VALUE_LABEL = COMP_WD_NET_TOP_UP_FC_VALUE_LABEL;
	}

	public void setCOMP_WD_NET_TOP_UP_FC_VALUE(
			HtmlInputText COMP_WD_NET_TOP_UP_FC_VALUE) {
		this.COMP_WD_NET_TOP_UP_FC_VALUE = COMP_WD_NET_TOP_UP_FC_VALUE;
	}

	public HtmlOutputLabel getCOMP_WD_NET_TOP_UP_LC_VALUE_LABEL() {
		return COMP_WD_NET_TOP_UP_LC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_WD_NET_TOP_UP_LC_VALUE() {
		return COMP_WD_NET_TOP_UP_LC_VALUE;
	}

	public void setCOMP_WD_NET_TOP_UP_LC_VALUE_LABEL(
			HtmlOutputLabel COMP_WD_NET_TOP_UP_LC_VALUE_LABEL) {
		this.COMP_WD_NET_TOP_UP_LC_VALUE_LABEL = COMP_WD_NET_TOP_UP_LC_VALUE_LABEL;
	}

	public void setCOMP_WD_NET_TOP_UP_LC_VALUE(
			HtmlInputText COMP_WD_NET_TOP_UP_LC_VALUE) {
		this.COMP_WD_NET_TOP_UP_LC_VALUE = COMP_WD_NET_TOP_UP_LC_VALUE;
	}

	public HtmlOutputLabel getCOMP_WD_PAY_TO_LABEL() {
		return COMP_WD_PAY_TO_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_WD_PAY_TO() {
		return COMP_WD_PAY_TO;
	}

	public void setCOMP_WD_PAY_TO_LABEL(HtmlOutputLabel COMP_WD_PAY_TO_LABEL) {
		this.COMP_WD_PAY_TO_LABEL = COMP_WD_PAY_TO_LABEL;
	}

	public void setCOMP_WD_PAY_TO(HtmlSelectOneMenu COMP_WD_PAY_TO) {
		this.COMP_WD_PAY_TO = COMP_WD_PAY_TO;
	}

	public HtmlOutputLabel getCOMP_WD_TOPUP_INT_FC_AMT_LABEL() {
		return COMP_WD_TOPUP_INT_FC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_WD_TOPUP_INT_FC_AMT() {
		return COMP_WD_TOPUP_INT_FC_AMT;
	}

	public void setCOMP_WD_TOPUP_INT_FC_AMT_LABEL(
			HtmlOutputLabel COMP_WD_TOPUP_INT_FC_AMT_LABEL) {
		this.COMP_WD_TOPUP_INT_FC_AMT_LABEL = COMP_WD_TOPUP_INT_FC_AMT_LABEL;
	}

	public void setCOMP_WD_TOPUP_INT_FC_AMT(
			HtmlInputText COMP_WD_TOPUP_INT_FC_AMT) {
		this.COMP_WD_TOPUP_INT_FC_AMT = COMP_WD_TOPUP_INT_FC_AMT;
	}

	public HtmlOutputLabel getCOMP_WD_TOPUP_INT_LC_AMT_LABEL() {
		return COMP_WD_TOPUP_INT_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_WD_TOPUP_INT_LC_AMT() {
		return COMP_WD_TOPUP_INT_LC_AMT;
	}

	public void setCOMP_WD_TOPUP_INT_LC_AMT_LABEL(
			HtmlOutputLabel COMP_WD_TOPUP_INT_LC_AMT_LABEL) {
		this.COMP_WD_TOPUP_INT_LC_AMT_LABEL = COMP_WD_TOPUP_INT_LC_AMT_LABEL;
	}

	public void setCOMP_WD_TOPUP_INT_LC_AMT(
			HtmlInputText COMP_WD_TOPUP_INT_LC_AMT) {
		this.COMP_WD_TOPUP_INT_LC_AMT = COMP_WD_TOPUP_INT_LC_AMT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_APPROVE() {
		return COMP_UI_M_BUT_APPROVE;
	}

	public void setCOMP_UI_M_BUT_APPROVE(HtmlCommandButton COMP_UI_M_BUT_APPROVE) {
		this.COMP_UI_M_BUT_APPROVE = COMP_UI_M_BUT_APPROVE;
	}

	public HtmlCommandButton getCOMP_PUSH_BUTTON214() {
		return COMP_PUSH_BUTTON214;
	}

	public void setCOMP_PUSH_BUTTON214(HtmlCommandButton COMP_PUSH_BUTTON214) {
		this.COMP_PUSH_BUTTON214 = COMP_PUSH_BUTTON214;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_REP_POLICY() {
		return COMP_UI_M_BUT_REP_POLICY;
	}

	public void setCOMP_UI_M_BUT_REP_POLICY(
			HtmlCommandButton COMP_UI_M_BUT_REP_POLICY) {
		this.COMP_UI_M_BUT_REP_POLICY = COMP_UI_M_BUT_REP_POLICY;
	}

	public HtmlCommandButton getCOMP_UI_M_WITHDRAWAL_STATUS() {
		return COMP_UI_M_WITHDRAWAL_STATUS;
	}

	public void setCOMP_UI_M_WITHDRAWAL_STATUS(
			HtmlCommandButton COMP_UI_M_WITHDRAWAL_STATUS) {
		this.COMP_UI_M_WITHDRAWAL_STATUS = COMP_UI_M_WITHDRAWAL_STATUS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_POL_HIST() {
		return COMP_UI_M_BUT_POL_HIST;
	}

	public void setCOMP_UI_M_BUT_POL_HIST(
			HtmlCommandButton COMP_UI_M_BUT_POL_HIST) {
		this.COMP_UI_M_BUT_POL_HIST = COMP_UI_M_BUT_POL_HIST;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_FUND_ALLOC() {
		return COMP_UI_M_BUT_FUND_ALLOC;
	}

	public void setCOMP_UI_M_BUT_FUND_ALLOC(
			HtmlCommandButton COMP_UI_M_BUT_FUND_ALLOC) {
		this.COMP_UI_M_BUT_FUND_ALLOC = COMP_UI_M_BUT_FUND_ALLOC;
	}

	public PT_IL_WITHDRAWAL getPT_IL_WITHDRAWAL_BEAN() {
		return PT_IL_WITHDRAWAL_BEAN;
	}

	public void setPT_IL_WITHDRAWAL_BEAN(PT_IL_WITHDRAWAL PT_IL_WITHDRAWAL_BEAN) {
		this.PT_IL_WITHDRAWAL_BEAN = PT_IL_WITHDRAWAL_BEAN;
	}

	public void saveRecord() {
		try {
			
			CommonUtils.clearMaps(this);
		//	helper.whenValidateWD_FULL_YN(compositeAction);
			
			/*Commentted &Modified by saritha on 16-12-2017 for ssp call id : ZBLIFE-1457793*/
			/*Added by ganesh on 01-12-2017 as suggested by siva*/
			/*if(getPT_IL_WITHDRAWAL_BEAN().getWD_GROSS_FC_VALUE()==null && getCOMP_WD_GROSS_FC_VALUE().isRequired()){
				throw new Exception("Gross FC Value:Validation Error: Value is required.");
			}*/
			/*end*/	
			
			/*added by gopi*/
			/*if(getPT_IL_WITHDRAWAL_BEAN().getWD_TOPUP_FC_AMT()==null && getCOMP_WD_TOPUP_FC_AMT().isRequired()){
				throw new Exception("Top Up FC Value:Validation Error: Value is required.");
			}
			if (getPT_IL_WITHDRAWAL_BEAN().getWD_TOPUP_FC_AMT()!=null && getPT_IL_WITHDRAWAL_BEAN().getWD_TOPUP_FC_AMT() <= 0) {
				throw new Exception("Top Up FC Value:Value Should Be Greater Than Zero !");
			}*/
			//end
			 /*Modified by Janani on 11.08.2017 for ZBILQC-1727639*/
			
			/*Modified by ganesh on 01-12-2017 as suggested by siva*/
			/*if (getPT_IL_WITHDRAWAL_BEAN().getWD_FULL_YN().equals("N") && getPT_IL_WITHDRAWAL_BEAN().getWD_GROSS_FC_VALUE()!=null && getPT_IL_WITHDRAWAL_BEAN().getWD_GROSS_FC_VALUE() <= 0) {
				throw new Exception("Gross FC Value:Value Should Be Greater Than Zero !");
			}*/
/*			end*/
			/*End*/
			
	/*Added by Janani on 16.01.2018 as per Gaurav's sugges.*/
			
			if(PT_IL_WITHDRAWAL_BEAN.getPlanType() != null && "H".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getPlanType()) &&
					PT_IL_WITHDRAWAL_BEAN.getProdIntrSavingsYN() !=null && "Y".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getProdIntrSavingsYN()))
			{
				
				System.out.println("getWD_TYPE in save        "+PT_IL_WITHDRAWAL_BEAN.getWD_TYPE());

				if(PT_IL_WITHDRAWAL_BEAN.getWD_TYPE() != null && !PT_IL_WITHDRAWAL_BEAN.getWD_TYPE().equalsIgnoreCase("I"))			

				{
					throw new Exception("Withdrawal type should be Interest");

				}
				
			}
					
					/*End*/	
			
			
			
			
			handlingNullZeroValidation();
			/*End*/
			
			if (getPT_IL_WITHDRAWAL_BEAN().getROWID() != null) {
				helper.preUpdate(PT_IL_WITHDRAWAL_BEAN);
				/*if("T".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getWD_TYPE()))
				{
					helper.topupNetFc(compositeAction);
					COMP_WD_NET_FC_VALUE.resetValue();
					COMP_WD_NET_LC_VALUE.resetValue();
				}*/
				new CRUDHandler().executeUpdate(getPT_IL_WITHDRAWAL_BEAN(),
						CommonUtils.getConnection());
				
				/*Added by Janani on 21.12.2018 as suggested by Anbarasi for Surrender partial withdrawal*/
				
				helper.postUpdateCharge(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
						compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN(),compositeAction);
				
				/*End*/
				
				//DELETE DATA INTO TRANSCTON TABLE BASED WD_SYS_ID
				//CALL postInsertFund
				deleteQuery();
				/*if(helper.getRowid(compositeAction))
				{
					helper.checkListCheck(compositeAction);
				}*/
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelErrorMessagePath, "UPDATE_MESSAGE"));
				
			} else {
				
				helper.preInsert(PT_IL_WITHDRAWAL_BEAN);
				/*if("T".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getWD_TYPE()))
						{
				helper.topupNetFc(compositeAction);
				COMP_WD_NET_FC_VALUE.resetValue();
				COMP_WD_NET_LC_VALUE.resetValue();
						}*/
				/*if(helper.getRowid(compositeAction))
				{
					helper.checkListCheck(compositeAction);
				}*/
				new CRUDHandler().executeInsert(getPT_IL_WITHDRAWAL_BEAN(),
						CommonUtils.getConnection());
				
				helper.postInsertFund(PT_IL_WITHDRAWAL_BEAN,dummy.getUI_M_POL_SYS_ID(),compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN());
				helper.postInsert(PT_IL_WITHDRAWAL_BEAN.getWD_DATE(), PT_IL_WITHDRAWAL_BEAN.getWD_SYS_ID());
				
				/*Newly added by saritha on 16-12-2017 for ssp call id : ZBLIFE-1457793*/
				helper.postInsertCharge(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
						compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN(),compositeAction);
				/*End*/
				
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelErrorMessagePath, "SAVE_MESSAGE"));
				getWarningMap().put("CURRENT",Messages.getString(PELConstants.pelErrorMessagePath, "SAVE_MESSAGE"));
			}
			///p9ilpk_withdrawal.DO_WITHDRAWAL_PROCESS(:PT_IL_WITHDRAWAL.WD_POL_SYS_ID, :PT_IL_WITHDRAWAL.WD_NUMBER);
			CommonUtils.getConnection().commit();
			//COMP_UI_M_POL_NO.setDisabled(true);
			
			/*Added by ganesh on 02-12-2017 to requery the data suggested by chandramohan*/
			helper.executeQuery(compositeAction);
			
			/*Added by saritha on 02-Jan-2018 for on save button click customer code &name,Issue date null coming*/
			helper.postQuery(compositeAction);
			/*End*/
			
		} catch (Exception e) {e.printStackTrace();
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	
	public void deleteQuery() throws Exception{
		String deleteQuery = "DELETE FROM PT_IL_FUND_TRAN_DTL WHERE FTD_TRAN_SYS_ID =? ";
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		/*Added by saritha on 06-12-2017 for Save button click null error coming*/
		dummy = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		/*End*/
		try{
			Connection connection = CommonUtils.getConnection();
			handler.executeDeleteStatement(deleteQuery, connection, new Object[]{ PT_IL_WITHDRAWAL_BEAN.getWD_SYS_ID()});
			helper.postInsertFund(PT_IL_WITHDRAWAL_BEAN,dummy.getUI_M_POL_SYS_ID(),compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN());
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	public List<SelectItem> getListWD_TYPE() {
		if (listWD_TYPE.size() == 0) {
			listWD_TYPE.clear();
			try {
				listWD_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {e.printStackTrace();
				e.printStackTrace();
			}
		}
		return listWD_TYPE;
	}

	public void setListWD_TYPE(List<SelectItem> listWD_TYPE) {
		this.listWD_TYPE = listWD_TYPE;
	}

	public List<SelectItem> getListWD_FULL_YN() {
		if (listWD_FULL_YN.size() == 0) {
			listWD_FULL_YN.clear();
			try {
				listWD_FULL_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {e.printStackTrace();
				e.printStackTrace();
			}
		}
		return listWD_FULL_YN;
	}

	public void setListWD_FULL_YN(List<SelectItem> listWD_FULL_YN) {
		this.listWD_FULL_YN = listWD_FULL_YN;
	}

	public List<SelectItem> getListWD_AMOUNT_YN() {
		if (listWD_AMOUNT_YN.size() == 0) {
			listWD_AMOUNT_YN.clear();
			try {
				listWD_AMOUNT_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {e.printStackTrace();
				e.printStackTrace();
			}
		}
		return listWD_AMOUNT_YN;
	}

	public void setListWD_AMOUNT_YN(List<SelectItem> listWD_AMOUNT_YN) {
		this.listWD_AMOUNT_YN = listWD_AMOUNT_YN;
	}

	public List<SelectItem> getListWD_PAY_TO() {
		if (listWD_PAY_TO.size() == 0) {
			listWD_PAY_TO.clear();
			try {
				listWD_PAY_TO = new ArrayList<SelectItem>();
			} catch (Exception e) {e.printStackTrace();
				e.printStackTrace();
			}
		}
		return listWD_PAY_TO;
	}

	public void setListWD_PAY_TO(List<SelectItem> listWD_PAY_TO) {
		this.listWD_PAY_TO = listWD_PAY_TO;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			//getErrorMap().clear();
			//getWarningMap().clear();
			
			if (isBlockFlag()) {
				getErrorMap().clear();
				getWarningMap().clear();
				helper.preBlock(this);
				helper.executeQuery(compositeAction);
				/*added by saritha for ssp call id ZBLIFE-1457793 on 07-12-2017*/
				compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getHelper().executeQuery(compositeAction);
				//end
				if(PT_IL_WITHDRAWAL_BEAN.getROWID() != null){
					disableAllComponent(true);
					helper.postQuery(compositeAction);
				}else{
					helper.WHEN_CREATE_RECORD(PT_IL_WITHDRAWAL_BEAN);
				}
				helper.WHEN_NEW_RECORD_INSTANCE(compositeAction);
				/*Modified by ganesh on 22-05-2017 */
				/*Added by Janani for hands-on-points feedback on 09.05.2017*/
				if(PT_IL_WITHDRAWAL_BEAN.getROWID() != null){
					disableRate();
				}

				/*End*/
				/*End*/
				setBlockFlag(false);
				if("N".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"))){
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PROCESS().setRendered(true);
				}else{
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PROCESS().setRendered(false);
					//COMP_UI_M_BUT_PROCESS.setDisabled(true);
				}
				
				/*Added by saritha on 25-07-2017 for ssp call id ZBILQC-1732436*/
				String busRuleQuery  = "SELECT BREM_ERR_FLAG FROM PT_BUS_RULE_ERROR_MSG WHERE BREM_POL_SYS_ID = ? AND BREM_APPLY_LEVEL = ? AND "
						               + "BREM_GRP_ID = 'IL' AND BREM_APL_SCREEN ='W'";
				Object[] values  = new Object[] { PT_IL_WITHDRAWAL_BEAN.getWD_POL_SYS_ID(), "T" };
				ResultSet rs1 = new CRUDHandler().executeSelectStatement(busRuleQuery, CommonUtils.getConnection(), values);
				if (rs1.next()) {
					
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUS_RUL().setDisabled(false); 	 
					
				} else {
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUS_RUL().setDisabled(true);
						
				}
				/*End*/
				
				/*added by gopi on 27/01/18*/
				if("CHK".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getWD_FLEX_04())){
					COMP_WD_FLEX_03.setDisabled(false);
					COMP_WD_FLEX_03.resetValue();
				}else{
					COMP_WD_FLEX_03.setDisabled(true);
					COMP_WD_FLEX_03.resetValue();
				}
				/*End*/
				
				
				/*Added by saritha on 13-02-2018 for Withdrawal Bank Details Issues*/
				
				if(CommonUtils.isIN(CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_PAY_TO(),""),"A","C") &&
						(CommonUtils.isIN(CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_FLEX_04(),""),"EFT","OTHERS")))				
				{   

					COMP_WD_FLEX_07.setRequired(true);
					COMP_WD_FLEX_08.setRequired(true);
					COMP_WD_FLEX_09.setRequired(true);
					COMP_WD_FLEX_10.setRequired(true);
					COMP_WD_FLEX_07.setDisabled(false);
					COMP_WD_FLEX_08.setDisabled(false);
					COMP_WD_FLEX_09.setDisabled(false);
					COMP_WD_FLEX_10.setDisabled(false);

				}else{

					COMP_WD_FLEX_07.setRequired(false);
					COMP_WD_FLEX_08.setRequired(false);
					COMP_WD_FLEX_09.setRequired(false);
					COMP_WD_FLEX_10.setRequired(false);
					COMP_WD_FLEX_07.setDisabled(true);
					COMP_WD_FLEX_08.setDisabled(true);
					COMP_UI_M_DIVN_CODE.setDisabled(true);
					COMP_WD_FLEX_09.setDisabled(true);
					COMP_WD_FLEX_10.setDisabled(true);
					PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_07(null);
					PT_IL_WITHDRAWAL_BEAN.setUI_M_BANK_NAME(null);
					PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_08(null);
					PT_IL_WITHDRAWAL_BEAN.setUI_M_DIVN_CODE(null);
					PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_09(null);
					PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_10(null);

				}
			
		       /*End*/					 	
					
			}
			
			
			if("Y".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getWD_FULL_YN())){
				   this.getCOMP_WD_GROSS_FC_VALUE().setRequired(false);
				   this.getCOMP_WD_TOPUP_FC_AMT().setRequired(false);
				   /*Added by Janani on 04.08.2017 for ZBILQC-1731624*/
				   this.getCOMP_WD_GROSS_FC_VALUE().setDisabled(true);
				   this.getCOMP_WD_TOPUP_FC_AMT().setDisabled(true);
				   /*End*/
				   
				   /*Added by Janani on 10.08.2017 for ZBILQC-1727639*/
					this.getCOMP_WD_TYPE().setDisabled(true);
					
					/*Added by Janani on 16.01.2018 as per Gaurav's sugges.*/
					chk_planType();
					
					if(PT_IL_WITHDRAWAL_BEAN.getPlanType() != null && "H".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getPlanType()) &&
							PT_IL_WITHDRAWAL_BEAN.getProdIntrSavingsYN() !=null && "Y".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getProdIntrSavingsYN()))
						{
							PT_IL_WITHDRAWAL_BEAN.setWD_TYPE("I");
						}else
						{
					/*End*/		
							PT_IL_WITHDRAWAL_BEAN.setWD_TYPE("B");		
						}
					
					this.getCOMP_WD_RATE().setDisabled(true);
					this.getCOMP_WD_RATE_PER().setDisabled(true);
					/*End*/	
				   
				}
				else{
					//this.getCOMP_WD_GROSS_FC_VALUE().setRequired(true);
					 /*Added by Janani on 04.08.2017 for ZBILQC-1731624*/
					  // this.getCOMP_WD_GROSS_FC_VALUE().setDisabled(false);
					   /*End*/
					/*Added by ganesh on 01-12-2017 as suggested by siva*/
					if("B".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getWD_TYPE()))
					{
						this.getCOMP_WD_TOPUP_FC_AMT().setDisabled(false);
						this.getCOMP_WD_GROSS_FC_VALUE().setDisabled(false);
						
					}else if("P".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getWD_TYPE())){
						this.getCOMP_WD_GROSS_FC_VALUE().setDisabled(false);
						this.getCOMP_WD_TOPUP_FC_AMT().setDisabled(true);
						
					}else if("T".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getWD_TYPE())){
						this.getCOMP_WD_GROSS_FC_VALUE().setDisabled(true);
						this.getCOMP_WD_TOPUP_FC_AMT().setDisabled(false);
					}
					this.getCOMP_WD_GROSS_FC_VALUE().setRequired(!getCOMP_WD_GROSS_FC_VALUE().isDisabled());
					this.getCOMP_WD_TOPUP_FC_AMT().setRequired(!getCOMP_WD_TOPUP_FC_AMT().isDisabled());
					
					/*end*/
					   
					   /*Added by Janani on 10.08.2017 for ZBILQC-1727639*/
					this.getCOMP_WD_TYPE().setDisabled(false);
					this.getCOMP_WD_RATE().setDisabled(false);
					this.getCOMP_WD_RATE_PER().setDisabled(false);
						/*End*/	
					   
				}
			
			/*Added by saritha on 27-07-2017 for withdrawal screen status Approved &Not Approved &On-Hold*/  
			if("A".equals(PT_IL_WITHDRAWAL_BEAN.getWD_APPRV_STATUS())){
				COMP_WD_APPROVAL_LABEL.setValue("Approved");
				disableAllComponentApproved(true);
			}else if("H".equals(PT_IL_WITHDRAWAL_BEAN.getWD_APPRV_STATUS())){
				COMP_WD_APPROVAL_LABEL.setValue("On - Hold");
			}
			else{
				COMP_WD_APPROVAL_LABEL.setValue("Not Approved");
				
			}
			/*End*/
		
			if("N".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getWD_FRZ_FLAG())){
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
				
			}else {
				if("N".equals(PT_IL_WITHDRAWAL_BEAN.getWD_APPRV_STATUS())){
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_APPROVE().setDisabled(false);
				}
			}
					
		} catch (Exception e) {e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			//getErrorMap().put("onLoad", e.getMessage());
		}
	}

	/*Commented by ganesh on 22-05-2017 for small modification in queries */
	/*Added by Janani for hands-on-points feedback on 09.05.2017*/

	/*public void disableRate()

	{
		System.out.println("enters into disableRate");

		String flag = null;
		Connection connection = null;
		ResultSet resultSet = null;
		String query_1,query_2 = null;
		String prod_code= null;
		try
		{

			query_1 = "SELECT POL_PROD_CODE FROM PT_IL_POLICY,PT_IL_WITHDRAWAL WHERE WD_POL_SYS_ID=POL_SYS_ID AND WD_POL_NO= ? ";

			query_2 = "SELECT ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET TAB1 WHERE "+
					" ASD_FLAG = '2' AND ASD_CODE='WD_RATE_OVR' AND "+
					" ASD_USER_ID = ? AND ASD_FM_PROD_CODE = '201' AND "+
					" ASD_TO_PROD_CODE = '211'";


			connection = CommonUtils.getConnection();

			System.out.println("user_id                    "+CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
			//System.out.println("getWD_POL_NO                    "+PT_IL_WITHDRAWAL_BEAN.getWD_POL_NO());

			resultSet = new CRUDHandler().executeSelectStatement(
					query_1, connection, new Object[]{PT_IL_WITHDRAWAL_BEAN.getWD_POL_NO()});

			 while (resultSet.next()) {
			
			prod_code = resultSet.getString("POL_PROD_CODE");

			 }
			resultSet = new CRUDHandler().executeSelectStatement(
					query_2, connection, new Object[]{CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID")});

			 while (resultSet.next()) {
				 
				 flag = resultSet.getString("ASD_CHAR_VALUE");
			 }
			

			System.out.println("flag                    "+flag);

			if(flag.equalsIgnoreCase("N"))
			{
				COMP_WD_RATE.setDisabled(true);
			}else
			{
				COMP_WD_RATE.setDisabled(false);
			}

		}catch (Exception e) {

			e.printStackTrace();
		}

	}*/
	/*end*/
	private void populateDropDowns() {
		try {
			connection = CommonUtils.getConnection();

			listWD_TYPE = ListItemUtil.getDropDownListValue(connection,
					"PILT021", "PT_IL_WITHDRAWAL", "PT_IL_WITHDRAWAL.WD_TYPE",
			"IL_WD_TYPE");
			listWD_AMOUNT_YN = ListItemUtil.getDropDownListValue(connection,
					"PILT021", "PT_IL_WITHDRAWAL",
					"PT_IL_WITHDRAWAL.WD_AMOUNT_YN", "YESNO");
			listWD_FULL_YN = ListItemUtil.getDropDownListValue(connection,
					"PILT021", "PT_IL_WITHDRAWAL",
					"PT_IL_WITHDRAWAL.WD_FULL_YN", "YESNO");
			listWD_PAY_TO = ListItemUtil.getDropDownListValue(connection,
					"PILT021", "PT_IL_WITHDRAWAL",
					"PT_IL_WITHDRAWAL.WD_PAY_TO", "IL_WDL_PAYTO");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

	public void validatePOL_NO(FacesContext context, UIComponent component,
			Object value)throws ValidatorException,Exception {
		/*Added by Ameen on 23-05-2017 as per gaurav sugg.*/
		Connection con=null;
		String planQry = "SELECT PLAN_TYPE,PROD_INTR_SAVINGS_YN FROM PT_IL_POLICY,PM_IL_PRODUCT,PM_IL_PLAN "
				+ "WHERE PLAN_CODE = POL_PLAN_CODE AND PROD_CODE = POL_PROD_CODE AND POL_NO = ?";
		ResultSet rs = null;
		String planType = null;
		String prodIntrSavingsYN = null;  
		/*End*/
		try {
			con = CommonUtils.getConnection();
			String CurrValue = (String)value;
			String prevValue = PT_IL_WITHDRAWAL_BEAN.getUI_M_POL_NO();
			//if(!(CurrValue.equalsIgnoreCase(prevValue))){
				PT_IL_WITHDRAWAL_BEAN.setUI_M_POL_NO((String) value);
				helper.WHEN_VALIDATE_POL_NO(compositeAction);
				COMP_UI_M_POL_CUST_CODE.resetValue();
				COMP_UI_M_POL_CUST_NAME.resetValue();
				COMP_WD_DATE.resetValue();
				COMP_UI_M_POL_ISSUE_DT.resetValue();
				COMP_WD_AMOUNT_YN.resetValue();
				COMP_WD_NUMBER.resetValue();
			//}
				/*Added by Ameen on 23-05-2017 as per gaurav sugg.*/
				rs = new CRUDHandler().executeSelectStatement(planQry, con, new Object[]{PT_IL_WITHDRAWAL_BEAN.getUI_M_POL_NO()});
				if(rs.next()){
					planType = rs.getString("PLAN_TYPE");
					prodIntrSavingsYN = rs.getString("PROD_INTR_SAVINGS_YN");
					
					/*Added by Janani on 16.01.2018 as per Gaurav's sugges.*/
					
					PT_IL_WITHDRAWAL_BEAN.setPlanType(planType);
					PT_IL_WITHDRAWAL_BEAN.setProdIntrSavingsYN(prodIntrSavingsYN);
					
					/*End*/
				}
				if(planType != null && "H".equalsIgnoreCase(planType) && prodIntrSavingsYN !=null && "Y".equalsIgnoreCase(prodIntrSavingsYN)){
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_FUND_ALLOC().setDisabled(true);
				}else{
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_FUND_ALLOC().setDisabled(false);
				}
				/*End*/
		} catch (Exception e) {e.printStackTrace();
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void onWD_AMOUNT_YNListChange(ActionEvent event) {
		//CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public void validateWD_AMOUNT_YN(FacesContext context, UIComponent component,
			Object value)throws ValidatorException,Exception {
		try {
			PT_IL_WITHDRAWAL_BEAN.setWD_AMOUNT_YN((String) value);
			helper.WHEN_VALIDATE_WD_AMOUNT_YN(this);
			COMP_WD_GROSS_FC_VALUE.resetValue();
			COMP_WD_GROSS_LC_VALUE.resetValue();
			COMP_WD_TOPUP_FC_AMT.resetValue();
			COMP_WD_TOPUP_LC_AMT.resetValue();
			COMP_WD_NET_FC_VALUE.resetValue();
			COMP_WD_NET_LC_VALUE.resetValue();
			COMP_WD_NET_TOP_UP_FC_VALUE.resetValue();
			COMP_WD_NET_TOP_UP_LC_VALUE.resetValue();
		} catch (Exception e) {e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void listnerWD_DATE(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateWD_DATE(FacesContext context, UIComponent component,
			Object value)throws ValidatorException,Exception {
		try {
			PT_IL_WITHDRAWAL_BEAN.setWD_DATE((Date) value);
			dummy = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
			helper.WHEN_VALIDATE_WD_DATE(compositeAction,(Date) value, PT_IL_WITHDRAWAL_BEAN.getWD_DOC_NO(), 
					dummy.getUI_M_POL_START_DT(), dummy.getUI_M_POL_SYS_ID(), 
					PT_IL_WITHDRAWAL_BEAN.getROWID());
		} catch (Exception e) {e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateWD_DOC_NO(FacesContext context, UIComponent component,
			Object value)throws ValidatorException,Exception {
		try {
			
			String CurrValue = (String)value;
			String prevValue = PT_IL_WITHDRAWAL_BEAN.getWD_DOC_NO();
			if(!(CurrValue.equalsIgnoreCase(prevValue))){
				PT_IL_WITHDRAWAL_BEAN.setWD_DOC_NO((String) value);
				helper.WHEN_VALIDATE_WD_DOC_NO((String) value);
			}
		} catch (Exception e) {e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateWD_GROSS_FC_VALUE(FacesContext context, UIComponent component,
			Object value)throws ValidatorException,Exception {
		try {
			PT_IL_WITHDRAWAL_BEAN.setWD_GROSS_FC_VALUE((Double) value);
			dummy = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
			helper.WHEN_VALIDATE_WD_GROSS_FC_VALUE(this, dummy);
			COMP_WD_GROSS_LC_VALUE.resetValue();
        } catch (Exception e) {e.printStackTrace();
		    throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateWD_GROSS_LC_VALUE(FacesContext context, UIComponent component,
			Object value)throws ValidatorException,Exception {
		try {
		//	CommonUtils.clearMaps(this);
			PT_IL_WITHDRAWAL_BEAN.setWD_GROSS_LC_VALUE((Double) value);
			dummy = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
			helper.WHEN_VALIDATE_WD_GROSS_LC_VALUE(PT_IL_WITHDRAWAL_BEAN, dummy.getUI_M_BASE_CURR(), 
					dummy.getUI_M_POL_CUST_EXCH_RATE());
		} catch (Exception e) {e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateWD_NET_FC_VALUE(FacesContext context, UIComponent component,
			Object value)throws ValidatorException,Exception {
		try {
		//	CommonUtils.clearMaps(this);
			PT_IL_WITHDRAWAL_BEAN.setWD_NET_FC_VALUE((Double) value);
			dummy = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
			helper.WHEN_VALIDATE_WD_NET_FC_VALUE(PT_IL_WITHDRAWAL_BEAN, (Double) value, 
				CommonUtils.nvl(dummy.getUI_M_BASE_CURR(),CommonUtils.getControlBean().getM_BASE_CURR()), dummy.getUI_M_POL_CUST_EXCH_RATE());

		} catch (Exception e) {e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateWD_NET_LC_VALUE(FacesContext context, UIComponent component,
			Object value)throws ValidatorException,Exception {
		try {
			PT_IL_WITHDRAWAL_BEAN.setWD_NET_LC_VALUE((Double) value);
			dummy = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
			helper.WHEN_VALIDATE_WD_NET_LC_VALUE(this, dummy);

		} catch (Exception e) {e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateWD_NET_TOP_UP_FC_VALUE(FacesContext context, UIComponent component,
			Object value) {
		try {
			PT_IL_WITHDRAWAL_BEAN.setWD_NET_TOP_UP_FC_VALUE((Double) value);
			dummy = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
			helper.WHEN_VALIDATE_WD_NET_TOP_UP_FC_VALUE((Double) value, dummy, PT_IL_WITHDRAWAL_BEAN);
			COMP_WD_NET_TOP_UP_LC_VALUE.resetValue();
		} catch (Exception e) {e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateWD_RATE(FacesContext context, UIComponent component,
			Object value)throws ValidatorException,
			Exception {
		try {
			
			System.out.println("inside validateWD_RATE.....");
			PT_IL_WITHDRAWAL_BEAN.setWD_RATE((Double) value);
			helper.WHEN_VALIDATE_WD_RATE(this);
			COMP_WD_FULL_YN.resetValue();
		} catch (Exception e) {e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateWD_RATE_PER(FacesContext context, UIComponent component,
			Object value) {
		try {
			PT_IL_WITHDRAWAL_BEAN.setWD_RATE_PER((Double) value);
			helper.WHEN_VALIDATE_WD_RATE_PER(PT_IL_WITHDRAWAL_BEAN);
			COMP_WD_FULL_YN.resetValue();
		} catch (Exception e) {e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateWD_TOPUP_FC_AMT(FacesContext context, UIComponent component,
			Object value) {
		try {
			PT_IL_WITHDRAWAL_BEAN.setWD_TOPUP_FC_AMT((Double) value);
			dummy = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
			helper.WHEN_VALIDATE_WD_TOPUP_FC_AMT(PT_IL_WITHDRAWAL_BEAN.getWD_POL_SYS_ID(), 
					this, PT_IL_WITHDRAWAL_BEAN.getWD_TOPUP_FC_AMT(), dummy);
			COMP_WD_TOPUP_LC_AMT.resetValue();

		} catch (Exception e) {e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateWD_TYPE(FacesContext context, UIComponent component,
			Object value) {
		/*Modified by ganesh on 01-12-2017 as suggested by siva*/
		CommonUtils.clearMaps(this);		
		/*end*/
		try {
			String prevValue=CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_TYPE(),"N");
			PT_IL_WITHDRAWAL_BEAN.setWD_TYPE((String) value);
			dummy = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
			if(!prevValue.equals((String) value))
			{
				PT_IL_WITHDRAWAL_BEAN.setWD_RATE(null);
				PT_IL_WITHDRAWAL_BEAN.setWD_RATE_PER(null);
				helper.WHEN_VALIDATE_WD_TYPE(this, dummy);
			}
			COMP_WD_RATE_PER.resetValue();
			COMP_WD_RATE.resetValue();
			COMP_WD_FULL_YN.resetValue();
			COMP_WD_TOPUP_FC_AMT.resetValue();
			COMP_WD_TOPUP_INT_FC_AMT.resetValue();
			COMP_WD_TOPUP_LC_AMT.resetValue();
			COMP_WD_TOPUP_INT_LC_AMT.resetValue();
			COMP_WD_FLEX_01.resetValue();
			if("P".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getWD_TYPE())||"B".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getWD_TYPE()))
			{
				COMP_WD_NET_FC_VALUE.setDisabled(true);
				COMP_WD_NET_LC_VALUE.setDisabled(true);
			}
			/*Modified by ganesh on 01-12-2017 as suggested by siva*/
			if("B".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getWD_TYPE()))
					{
				COMP_WD_TOPUP_FC_AMT.setDisabled(false);
				COMP_WD_GROSS_FC_VALUE.setDisabled(false);
					}else if("P".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getWD_TYPE())){
						COMP_WD_GROSS_FC_VALUE.setDisabled(false);
						COMP_WD_TOPUP_FC_AMT.setDisabled(true);
						
					}else if("T".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getWD_TYPE())){
						COMP_WD_GROSS_FC_VALUE.setDisabled(true);
						COMP_WD_TOPUP_FC_AMT.setDisabled(false);
					}
			COMP_WD_GROSS_FC_VALUE.setRequired(!getCOMP_WD_GROSS_FC_VALUE().isDisabled());
			COMP_WD_TOPUP_FC_AMT.setRequired(!getCOMP_WD_TOPUP_FC_AMT().isDisabled());
			/*end*/
			helper.validateforMature(compositeAction);
		} catch (Exception e) {e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validateWD_FLEX_01(FacesContext context, UIComponent component,
			Object value)throws ValidatorException, Exception {
		try {
			
			/*Modified by Janani on 27.07.2017 on ZBILQC-1733254 */
			//PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_01((String) value);
			
			PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_01(String.valueOf(value));
			
			/*End*/
			
			dummy = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
			
			/*Modified by Janani on 27.07.2017 on ZBILQC-1733254 */
			
			//helper.WHEN_VALIDATE_WD_FLEX_01((String) value, dummy, PT_IL_WITHDRAWAL_BEAN);
			helper.WHEN_VALIDATE_WD_FLEX_01(String.valueOf(value), dummy, PT_IL_WITHDRAWAL_BEAN);
			
			/*End*/
			
		} catch (Exception e) {e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void onWD_TYPEListChange(ActionEvent event) {
		try {
			
			String prevValue=CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_TYPE(),"N");
			UIInput input = (UIInput) event.getComponent().getParent();
			String inputData = input.getSubmittedValue() != null?input.getSubmittedValue().toString() : "";
			
			
			/*Added by Janani on 16.01.2018 as per Gaurav's sugges.*/
			
			if(PT_IL_WITHDRAWAL_BEAN.getPlanType() != null && "H".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getPlanType()) &&
					PT_IL_WITHDRAWAL_BEAN.getProdIntrSavingsYN() !=null && "Y".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getProdIntrSavingsYN()))
			{

				if(!PT_IL_WITHDRAWAL_BEAN.getWD_TYPE().equalsIgnoreCase("I") && inputData != null && !inputData.equalsIgnoreCase("i"))			

				{
					throw new Exception("Withdrawal type should be Interest");

				}
				
			}		
					/*End*/	
				
				
				
				PT_IL_WITHDRAWAL_BEAN.setWD_TYPE(inputData);
				if(!prevValue.equalsIgnoreCase(inputData))
				{
					/*Commented by Janani on 11.08.2017 for ZBILQC-1727639*/
					
					/*PT_IL_WITHDRAWAL_BEAN.setWD_RATE(null);
					PT_IL_WITHDRAWAL_BEAN.setWD_RATE_PER(null);*/
					
					/*End*/
				}
				/*Modified by ganesh on 01-12-2017 as suggested by siva*/
				if ("P".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getWD_TYPE())) {				
					PT_IL_WITHDRAWAL_BEAN.setWD_TOPUP_FC_AMT(null);
					PT_IL_WITHDRAWAL_BEAN.setWD_TOPUP_LC_AMT(null);
					/*Added by saritha on on 12-12-2017 for ssp call id ZBLIFE-1457793*/
					PT_IL_WITHDRAWAL_BEAN.setWD_NET_TOP_UP_FC_VALUE(null);
					PT_IL_WITHDRAWAL_BEAN.setWD_NET_TOP_UP_LC_VALUE(null);
					/*End*/

				} else if ("T".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getWD_TYPE())) {
					PT_IL_WITHDRAWAL_BEAN.setWD_GROSS_FC_VALUE(null);
					PT_IL_WITHDRAWAL_BEAN.setWD_GROSS_LC_VALUE(null);
					PT_IL_WITHDRAWAL_BEAN.setWD_NET_FC_VALUE(null);
					PT_IL_WITHDRAWAL_BEAN.setWD_NET_LC_VALUE(null);
					COMP_WD_NET_LC_VALUE.resetValue();
					COMP_WD_NET_LC_VALUE.resetValue();
					COMP_WD_GROSS_FC_VALUE.resetValue();
					COMP_WD_GROSS_LC_VALUE.resetValue();
				}
				/*end*/
				helper.WHEN_WD_TYPE_LIST_CHANGED(compositeAction);
				COMP_WD_RATE_PER.resetValue();
				COMP_WD_RATE.resetValue();
				COMP_WD_FULL_YN.resetValue();
				COMP_WD_TOPUP_FC_AMT.resetValue();
				COMP_WD_TOPUP_INT_FC_AMT.resetValue();
				COMP_WD_TOPUP_LC_AMT.resetValue();
				COMP_WD_TOPUP_INT_LC_AMT.resetValue();
				COMP_WD_FLEX_01.resetValue();
				COMP_WD_NET_TOP_UP_FC_VALUE.resetValue();
				COMP_WD_NET_TOP_UP_LC_VALUE.resetValue();
				ErrorHelpUtil.validate(input, getErrorMap());
				
			
		} catch (Exception e) {e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}
	}

	public void onWD_FULL_YNListChange(ActionEvent event) {
		try {
			UIInput input = (UIInput) event.getComponent().getParent();
			String inputData = input.getSubmittedValue().toString();
			PT_IL_WITHDRAWAL_BEAN.setWD_FULL_YN(inputData);
			helper.WHEN_LIST_CHANGED_WD_FULL_YN(compositeAction);
			COMP_WD_RATE.resetValue();
			COMP_WD_RATE_PER.resetValue();
			//COMP_WD_FULL_YN.resetValue();
			ErrorHelpUtil.validate(input, getErrorMap());
		} catch (Exception e) {e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}
	}
	
	public String keyCOmmittAction(){
		try {
			helper.key_Commit(compositeAction);
		} catch (Exception e) {e.printStackTrace();
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("keycommit", e.getMessage());
		}
		return "";
	}
	/*public List<LovBean> prepareLOV(Object value) {
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			lovList = itemUtil.P_CALL_LOV("PILT021", "PT_IL_WITHDRAWAL",
					"M_POL_NO", "A", null, null, null, null, (String) value);
		} catch (Exception e) {e.printStackTrace();
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		return lovList;
	}*/
	
	
	
	public ArrayList<LovBean> prepareLOV(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		/*modified by Ameen on 24-05-2017 as per Gaurav sugg. to change PLAN_TYPE IN ('U', 'I', 'H')*/
		String query = "SELECT POL_NO,POL_CUST_CODE  FROM PT_IL_POLICY, PM_IL_PLAN  WHERE POL_PLAN_CODE = PLAN_CODE " +
						"    AND POL_APPRV_STATUS = 'A'  AND PLAN_TYPE IN ('U', 'I','H')  AND POL_DS_TYPE='2' "
				+ "AND (POL_NO LIKE ? OR POL_CUST_CODE LIKE ?  ) AND ROWNUM < ?";
		Object[] values = null;
		String currentValue = (String) object;

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			values = new Object[] { currentValue, currentValue, 
					PELConstants.suggetionRecordSize };
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {e.printStackTrace();
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}


	public String getDEFAULT_WHERE() {
		return DEFAULT_WHERE;
	}

	public void setDEFAULT_WHERE(String default_where) {
		DEFAULT_WHERE = default_where;
	}
	
	
	public void setErrorMessagesInMap(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_KEY_COMMIT() {
		return COMP_UI_M_BUT_KEY_COMMIT;
	}

	public void setCOMP_UI_M_BUT_KEY_COMMIT(
			HtmlCommandButton comp_ui_m_but_key_commit) {
		COMP_UI_M_BUT_KEY_COMMIT = comp_ui_m_but_key_commit;
	}
	
	/**
	 * Disables all components in PT_IL_WITHDRAWAL_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		//COMP_UI_M_POL_NO.setDisabled(disabled);
		/*COMP_UI_M_POL_CUST_CODE.setDisabled(disabled);
		COMP_UI_M_POL_CUST_NAME.setDisabled(disabled);
		COMP_WD_FLEX_01.setDisabled(disabled);
		COMP_WD_DOC_NO.setDisabled(disabled);
		COMP_WD_NUMBER.setDisabled(disabled);
		COMP_WD_PREM_TXN_CODE.setDisabled(disabled);
		COMP_WD_RATE.setDisabled(disabled);
		COMP_WD_RATE_PER.setDisabled(disabled);
		COMP_WD_PREM_DOC_NO.setDisabled(disabled);
		COMP_WD_GROSS_FC_VALUE.setDisabled(disabled);
		COMP_WD_GROSS_LC_VALUE.setDisabled(disabled);
		COMP_WD_TOP_UP_TXN_CODE.setDisabled(disabled);
		COMP_WD_NET_FC_VALUE.setDisabled(disabled);
		COMP_WD_NET_LC_VALUE.setDisabled(disabled);
		COMP_WD_TOP_UP_DOC_NO.setDisabled(disabled);
		COMP_WD_TOPUP_FC_AMT.setDisabled(disabled);
		COMP_WD_TOPUP_LC_AMT.setDisabled(disabled);
		COMP_UI_M_RED_SUM_ASSURED.setDisabled(disabled);
		COMP_WD_NET_TOP_UP_FC_VALUE.setDisabled(disabled);
		COMP_WD_NET_TOP_UP_LC_VALUE.setDisabled(disabled);
		COMP_WD_TOPUP_INT_FC_AMT.setDisabled(disabled);
		COMP_WD_TOPUP_INT_LC_AMT.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_WD_TYPE.setDisabled(disabled);
		COMP_WD_FULL_YN.setDisabled(disabled);
		COMP_WD_AMOUNT_YN.setDisabled(disabled);
		COMP_WD_PAY_TO.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_UI_M_APPRV_DT.setDisabled(disabled);
		COMP_UI_M_POL_ISSUE_DT.setDisabled(disabled);
		COMP_WD_DATE.setDisabled(disabled);
		COMP_WD_DOC_DT.setDisabled(disabled);*/

	}
	
	
	public void disableAllComponentApproved(boolean disabled){
		// Disabling HtmlInputText
		COMP_UI_M_POL_NO.setDisabled(disabled);
		COMP_UI_M_POL_CUST_CODE.setDisabled(disabled);
		COMP_UI_M_POL_CUST_NAME.setDisabled(disabled);
		COMP_WD_FLEX_01.setDisabled(disabled);
		COMP_WD_DOC_NO.setDisabled(disabled);
		//COMP_WD_NUMBER.setDisabled(disabled);
		//COMP_WD_PREM_TXN_CODE.setDisabled(disabled);
		COMP_WD_RATE.setDisabled(disabled);
		COMP_WD_RATE_PER.setDisabled(disabled);
		//COMP_WD_PREM_DOC_NO.setDisabled(disabled);
		COMP_WD_GROSS_FC_VALUE.setDisabled(disabled);
		COMP_WD_GROSS_LC_VALUE.setDisabled(disabled);
		COMP_WD_TOP_UP_TXN_CODE.setDisabled(disabled);
		/*COMP_WD_NET_FC_VALUE.setDisabled(disabled);
		COMP_WD_NET_LC_VALUE.setDisabled(disabled);
		COMP_WD_TOP_UP_DOC_NO.setDisabled(disabled);
		COMP_WD_TOPUP_FC_AMT.setDisabled(disabled);
		COMP_WD_TOPUP_LC_AMT.setDisabled(disabled);
		COMP_UI_M_RED_SUM_ASSURED.setDisabled(disabled);
		COMP_WD_NET_TOP_UP_FC_VALUE.setDisabled(disabled);
		COMP_WD_NET_TOP_UP_LC_VALUE.setDisabled(disabled);
		COMP_WD_TOPUP_INT_FC_AMT.setDisabled(disabled);
		COMP_WD_TOPUP_INT_LC_AMT.setDisabled(disabled);*/

		// Disabling HtmlSelectOneMenu
		/*Added by janani on 10.05.2017 for factory testing feedback*/
		COMP_WD_TYPE.setDisabled(disabled);
		/*end*/
		COMP_WD_FULL_YN.setDisabled(disabled);
		/*COMP_WD_AMOUNT_YN.setDisabled(disabled);*/
		COMP_WD_PAY_TO.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_UI_M_APPRV_DT.setDisabled(disabled);
		COMP_UI_M_POL_ISSUE_DT.setDisabled(disabled);
		COMP_WD_DATE.setDisabled(disabled);
		//COMP_WD_DOC_DT.setDisabled(disabled);
		
/*Added by janani on 10.05.2017 for factory testing feedback*/
		
		COMP_TYPE.setDisabled(disabled);
		COMP_MICR_CODE.setDisabled(disabled);
		COMP_ACC_NO.setDisabled(disabled);
		
		/*End*/
		
		/*Added by ganesh on 11.05.2017 for factory testing feedback*/
		COMP_WD_SAVE.setDisabled(disabled);
		COMP_WD_SAVE_DOWN.setDisabled(disabled);
		COMP_WD_TOPUP_FC_AMT.setDisabled(disabled);
		/*end*/
		/*Added by saritha on 08-12-2017 for ssp call id : ZBLIFE-1458892*/
		COMP_WD_FLEX_07.setDisabled(disabled);
		COMP_UI_M_BANK_NAME.setDisabled(disabled);
		COMP_WD_FLEX_08.setDisabled(disabled);
		COMP_UI_M_DIVN_CODE.setDisabled(disabled);
		COMP_WD_FLEX_09.setDisabled(disabled);
		COMP_WD_FLEX_10.setDisabled(disabled);
		COMP_WD_FLEX_11.setDisabled(disabled);
		COMP_WD_FLEX_12.setDisabled(disabled);
		
		COMP_WD_FLEX_03.setDisabled(disabled);
		
		/*Newly Added By Dhinesh on 20-03-2018*/
		compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_REJECT().setDisabled(disabled);
		/*End*/
		
		COMP_WD_FRZ_FLAG.setDisabled(disabled);
	}
	
	public void resetAllComponent() {

		COMP_WD_FLEX_07.resetValue();
		COMP_WD_FLEX_08.resetValue();
		COMP_WD_FLEX_09.resetValue();
		COMP_WD_FLEX_10.resetValue();
		COMP_WD_FLEX_11.resetValue();
		COMP_WD_FLEX_12.resetValue();
		/*Added by ganesh to reset the value after
		 *  clicking rejection button on 03-05-2018*/
		COMP_UI_M_POL_NO.resetValue();
		COMP_WD_DATE.resetValue();
		COMP_WD_FLEX_01.resetValue();
		COMP_WD_RATE_PER.resetValue();
		COMP_WD_RATE.resetValue();
		COMP_WD_GROSS_FC_VALUE.resetValue();
		COMP_WD_GROSS_LC_VALUE.resetValue();
		/*end*/

	}
	/*End*/

	public HtmlCommandButton getCOMP_UI_M_BUT_REPORT() {
		return COMP_UI_M_BUT_REPORT;
	}

	public void setCOMP_UI_M_BUT_REPORT(HtmlCommandButton comp_ui_m_but_report) {
		COMP_UI_M_BUT_REPORT = comp_ui_m_but_report;
	}

	public IP_REP_INFO getIP_REP_INFO_BEAN() {
		return IP_REP_INFO_BEAN;
	}

	public void setIP_REP_INFO_BEAN(IP_REP_INFO ip_rep_info_bean) {
		IP_REP_INFO_BEAN = ip_rep_info_bean;
	}

	
	
//added by akash for report ...
	
	
	
	
	public String runActionDMS() {
		String redirectDMSUrl=null;
		CommonUtils.clearMaps(this);
 		setRedirectUrl(null);
		HttpServletResponse response=null;
		Connection connection=null;
		String repid=null;
		//IP_REP_INFO_BEAN.setREP_ID("PILR_LET_FN");
		Map<String, String> map = new HashMap<String, String>();
		try {
			
			if (IP_REP_INFO_BEAN.getROWID() == null) {
				PRE_INSERT(IP_REP_INFO_BEAN);
			} else {
				PRE_UPDATE(this.IP_REP_INFO_BEAN);
			}

			//delegate.executeSaveAction(this.IP_REP_INFO_BEAN);
			connection=CommonUtils.getConnection();
			response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
																				.getResponse();
			System.out.println("0---->"+PT_IL_WITHDRAWAL_BEAN.getUI_M_POL_NO());
			map.put("P_POL_SYS_ID",String.valueOf(getSysId(PT_IL_WITHDRAWAL_BEAN.getUI_M_POL_NO())));
			/*redirectUrl = ReportUtils.getReportRedirectString(
					IP_REP_INFO_BEAN.getREP_KEY_NO(),"PILR_REC001",
					repid,IP_REP_INFO_BEAN.getSelectedFileTyp(), map);*/
			redirectDMSUrl = ReportUtils.getReportRedirectString(
					IP_REP_INFO_BEAN.getREP_KEY_NO(), IP_REP_INFO_BEAN.getREP_ID(), 
					IP_REP_INFO_BEAN.getREP_ID(),
					IP_REP_INFO_BEAN.getSelectedFileTyp(),map);
			// response.sendRedirect(redirectUrl);
			
			setRedirectUrl(redirectDMSUrl);
			
	} catch (Exception e) {e.printStackTrace();
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		getErrorMap().put("RunAction", e.getMessage());
	}
	return redirectDMSUrl;
 }
	
	public Long getSysId(String polNo){
		Connection connection = null;
		ResultSet resultSet = null;
		Long polsysId = null;
		String query = "SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO = ? ";
		try {
			connection =  CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query, connection,new Object[]{polNo});
			if(resultSet.next()){
				polsysId = resultSet.getLong(1);
			}
		} catch (Exception e) {e.printStackTrace();
			e.printStackTrace();
		}
		return polsysId;
		
	}
	
	
	public void PRE_INSERT(IP_REP_INFO iP_REP_INFO_BEAN) {

		try {

			iP_REP_INFO_BEAN.setREP_ID(CommonUtils.getGlobalVariable("GLOBAL.M_MODULE_ID")); // changed by sankara narayanan for print 16-02-2017
			iP_REP_INFO_BEAN.setREP_ID(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_3"));
			iP_REP_INFO_BEAN.setREP_VALUE_20(CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"));
			iP_REP_INFO_BEAN.setREP_VALUE_21(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			iP_REP_INFO_BEAN.setREP_CR_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			iP_REP_INFO_BEAN.setREP_CR_DT(new CommonUtils().getCurrentDate());

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public void PRE_UPDATE(IP_REP_INFO IP_REP_INFO_BEAN) {

		try {
			IP_REP_INFO_BEAN.setREP_ID(CommonUtils.getGlobalVariable("GLOBAL.M_MODULE_ID")); // changed by sankara narayanan for print 16-02-2017
			IP_REP_INFO_BEAN.setREP_VALUE_20(CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"));
			IP_REP_INFO_BEAN.setREP_VALUE_21(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			IP_REP_INFO_BEAN.setREP_UPD_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			IP_REP_INFO_BEAN.setREP_UPD_DT(new CommonUtils().getCurrentDate());

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public HtmlSelectOneMenu getCOMP_TYPE() {
		return COMP_TYPE;
	}

	public void setCOMP_TYPE(HtmlSelectOneMenu comp_type) {
		COMP_TYPE = comp_type;
	}

	public HtmlInputText getCOMP_MICR_CODE() {
		return COMP_MICR_CODE;
	}

	public void setCOMP_MICR_CODE(HtmlInputText comp_micr_code) {
		COMP_MICR_CODE = comp_micr_code;
	}

	public HtmlInputText getCOMP_ACC_NO() {
		return COMP_ACC_NO;
	}

	public void setCOMP_ACC_NO(HtmlInputText comp_acc_no) {
		COMP_ACC_NO = comp_acc_no;
	}

	public HtmlOutputLabel getCOMP_TYPE_LABEL() {
		return COMP_TYPE_LABEL;
	}

	public void setCOMP_TYPE_LABEL(HtmlOutputLabel comp_type_label) {
		COMP_TYPE_LABEL = comp_type_label;
	}

	public HtmlOutputLabel getCOMP_MICR_CODE_LABEL() {
		return COMP_MICR_CODE_LABEL;
	}

	public void setCOMP_MICR_CODE_LABEL(HtmlOutputLabel comp_micr_code_label) {
		COMP_MICR_CODE_LABEL = comp_micr_code_label;
	}

	public HtmlOutputLabel getCOMP_ACC_NO_LABEL() {
		return COMP_ACC_NO_LABEL;
	}

	public void setCOMP_ACC_NO_LABEL(HtmlOutputLabel comp_acc_no_label) {
		COMP_ACC_NO_LABEL = comp_acc_no_label;
	}

	public HtmlAjaxCommandButton getCOMP_EFT_BUT() {
		return COMP_EFT_BUT;
	}

	public void setCOMP_EFT_BUT(HtmlAjaxCommandButton comp_eft_but) {
		COMP_EFT_BUT = comp_eft_but;
	}

	public List<SelectItem> getListLOAN_FLEX_04() {
		return listLOAN_FLEX_04;
	}

	public void setListLOAN_FLEX_04(List<SelectItem> listLOAN_FLEX_04) {
		this.listLOAN_FLEX_04 = listLOAN_FLEX_04;
	}
	public void validateWD_FLEX_04(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		//CommonUtils.clearMaps(this);
		try {
			/*helper.POL_OCC_RATE_WHEN_VALIDATE_ITEM(compositeAction,
					(Double) value);
			PT_IL_POLICY_BEAN.setPOL_OCC_RATE((Double) value);*/
			getPT_IL_WITHDRAWAL_BEAN().setWD_FLEX_04((String)value);
			/*if((PT_IL_CLAIM_PAID_BEAN.getCP_FLEX_05()==null)&&(PT_IL_CLAIM_PAID_BEAN.getCP_FLEX_06()==null)){
			helper.fetchDetails(compositeAction);
			}*/
			/*if((PT_IL_LOAN_BEAN.getLOAN_FLEX_04().equalsIgnoreCase("EFT"))){*/
			
			/*Commentted by saritha on 28-12-2017 for ssp call id : ZBLIFE-1464439*/
			/*if("EFT".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getWD_FLEX_04())){
				this.getCOMP_ACC_NO().setRequired(true);
				this.getCOMP_MICR_CODE().setRequired(true);
			}else{
				this.getCOMP_ACC_NO().setRequired(false);
				this.getCOMP_MICR_CODE().setRequired(false);
			}*/
			/*End*/
			
			//COMP_TYPE.resetValue();
			
			
			/*Added by saritha on 13-02-2018 for Withdrawal Bank Details Issues*/
			
			if(CommonUtils.isIN(CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_PAY_TO(),""),"A","C") &&
					(CommonUtils.isIN(CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_FLEX_04(),""),"EFT","OTHERS")))				
			{  

				COMP_WD_FLEX_07.setRequired(true);
				COMP_WD_FLEX_08.setRequired(true);
				COMP_WD_FLEX_09.setRequired(true);
				COMP_WD_FLEX_10.setRequired(true);
				COMP_WD_FLEX_07.setDisabled(false);
				COMP_WD_FLEX_08.setDisabled(false);
				COMP_WD_FLEX_09.setDisabled(false);
				COMP_WD_FLEX_10.setDisabled(false);

			}else{

				COMP_WD_FLEX_07.setRequired(false);
				COMP_WD_FLEX_08.setRequired(false);
				COMP_WD_FLEX_09.setRequired(false);
				COMP_WD_FLEX_10.setRequired(false);
				COMP_WD_FLEX_07.setDisabled(true);
				COMP_WD_FLEX_08.setDisabled(true);
				COMP_WD_FLEX_09.setDisabled(true);
				COMP_WD_FLEX_10.setDisabled(true);
				PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_07(null);
				PT_IL_WITHDRAWAL_BEAN.setUI_M_BANK_NAME(null);
				PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_08(null);
				PT_IL_WITHDRAWAL_BEAN.setUI_M_DIVN_CODE(null);
				PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_09(null);
				PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_10(null);

				COMP_WD_FLEX_07.resetValue();
				COMP_UI_M_BANK_NAME.resetValue();
				COMP_WD_FLEX_08.resetValue();
				COMP_UI_M_DIVN_CODE.resetValue();
				COMP_WD_FLEX_09.resetValue();
				COMP_WD_FLEX_10.resetValue();

			}
			
			/*End*/
			
			
			/*added by gopi on 27/01/18*/
			if("CHK".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getWD_FLEX_04())){
				COMP_WD_FLEX_03.setDisabled(false);
			}else{
				PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_03(null);
				COMP_WD_FLEX_03.setSubmittedValue(null);
				COMP_WD_FLEX_03.setValue(null);
				COMP_WD_FLEX_03.setDisabled(true);
			}
			//end
			COMP_WD_FLEX_03.resetValue();
			COMP_MICR_CODE.resetValue();
			COMP_ACC_NO.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "WD_FLEX_04", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void validateWD_FLEX_05(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		//CommonUtils.clearMaps(this);
		try {
			/*helper.POL_OCC_RATE_WHEN_VALIDATE_ITEM(compositeAction,
					(Double) value);
			PT_IL_POLICY_BEAN.setPOL_OCC_RATE((Double) value);*/
			String value_1=(String)value;
			PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_05((String)value);
			helper.chkMICRCode(value_1);
			
			//COMP_MICR_CODE.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}
	
	public void validateWD_FLEX_06(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		//CommonUtils.clearMaps(this);
		try {
			
			PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_06((String)value);
			
			//COMP_ACC_NO.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "POL_OCC_RATE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateWD_FULL_YN(FacesContext facesContext,
			UIComponent component, Object value) {
		//CommonUtils.clearMaps(this);
		try {
			
			/*Added by ganesh on 01-Feb-18 as per siva suggestion. Partial withdrawl is not applicable for paid up */
			helper.validatePaidUpPolicy((String)value,compositeAction);
			/*end*/
			
				/*added by raja on 12-07-2017 for ZBILQC-1731237*/
			//if(PT_IL_WITHDRAWAL_BEAN.getWD_FULL_YN()==null || PT_IL_WITHDRAWAL_BEAN.getWD_FULL_YN().equalsIgnoreCase(value.toString()))
			
			if(!value.toString().equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getWD_FULL_YN()))
			{
			
				/*MOdified by Janani on 10.08.2017 for ZBILQC-1727639*/
				PT_IL_WITHDRAWAL_BEAN.setWD_FULL_YN((String)value);
				
				/*End*/
				helper.whenValidateWD_FULL_YN(compositeAction); 
						
				
			}
			

			
			//PT_IL_WITHDRAWAL_BEAN.setWD_FULL_YN((String)value); Commented by Janani on 10.08.2017 for ZBILQC-1727639
			
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN()
			.getCOMP_WD_GROSS_FC_VALUE().resetValue();
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getCOMP_WD_RATE().resetValue();
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getCOMP_WD_RATE_PER().resetValue();
			compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN()
			.getCOMP_WD_GROSS_LC_VALUE().resetValue();
			/*end*/
			
			
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	
	
	 /*Added By Janani on 3.01.2017 for DMS Integration*/
	
	private HtmlModalPanel COMP_REPORT_MODAL_PANEL_DMS;
		
	 public HtmlModalPanel getCOMP_REPORT_MODAL_PANEL_DMS() {
		return COMP_REPORT_MODAL_PANEL_DMS;
	}

	public void setCOMP_REPORT_MODAL_PANEL_DMS(
			HtmlModalPanel cOMP_REPORT_MODAL_PANEL_DMS) {
		COMP_REPORT_MODAL_PANEL_DMS = cOMP_REPORT_MODAL_PANEL_DMS;
	}

	public void callReportDMSModalPanel(ActionEvent event) {
		 String input = event.getComponent().getId();
		 runAction_DMS();
		 try {
		
				 String dmsUrl = new DMSUtil().getDmsUrl();
				 System.out.println("PT_IL_CLAIM_ACTION.invokeDMS()" + dmsUrl);
				 setRedirectUrl(dmsUrl);
			
						

/*			 if (getRedirectUrl() != null) {
				 getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(true);
			 } else {
				 getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(false);
			 }
*/
			 
				 if (getRedirectUrl() != null) {
					 getCOMP_REPORT_MODAL_PANEL_DMS().setShowWhenRendered(true);
				 } else {
					 getCOMP_REPORT_MODAL_PANEL_DMS().setShowWhenRendered(false);
				 }
			 
			 
		 } catch (Exception e) {
			 e.printStackTrace();
		 }

	 }

	
	 public String runAction_DMS() {
		 System.out.println("PT_IL_CLAIM_ACTION.invokeDMS()");
		 try {

		 } catch (Exception e) {
			
		 }
		 return "";

	 }
	 
	 
	 public String cancelModalPanel(){
		 getCOMP_REPORT_MODAL_PANEL_DMS().setShowWhenRendered(false);
			return "";
		}
	 
	 
	 /*End*/
	
	 /* Added by ganesh on 11-05-2017 for handson feedback*/
		
		private HtmlCommandLink COMP_WD_SAVE;
		private HtmlCommandLink COMP_WD_SAVE_DOWN;



		public HtmlCommandLink getCOMP_WD_SAVE() {
			return COMP_WD_SAVE;
		}
		
		public void setCOMP_WD_SAVE(HtmlCommandLink cOMP_WD_SAVE) {
			COMP_WD_SAVE = cOMP_WD_SAVE;
		}

		public HtmlCommandLink getCOMP_WD_SAVE_DOWN() {
			return COMP_WD_SAVE_DOWN;
		}

		public void setCOMP_WD_SAVE_DOWN(HtmlCommandLink cOMP_WD_SAVE_DOWN) {
			COMP_WD_SAVE_DOWN = cOMP_WD_SAVE_DOWN;
		}
		
		
		/*end*/
		
		/*Modified by ganesh on 22-05-2017 */
		public void disableRate()

		{
			System.out.println("enters into disableRate");

			String flag = null;
			Connection connection = null;
			ResultSet rsProdCode = null;
			ResultSet rsFlagYN = null;
			String fetchProductCodeQuery,fetchFlagValueYNQuery = null;
			String productCode= null;
			try
			{

				connection = CommonUtils.getConnection();
				fetchProductCodeQuery = "SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_NO= ? ";			
				fetchFlagValueYNQuery = "SELECT ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET TAB1 WHERE "+
							"ASD_FLAG = '2' AND ASD_CODE='WD_RATE_OVR' AND "+
							"ASD_USER_ID = ? AND ? BETWEEN ASD_FM_PROD_CODE AND ASD_TO_PROD_CODE";
				
							

				rsProdCode = new CRUDHandler().executeSelectStatement(
						fetchProductCodeQuery, connection, new Object[]{PT_IL_WITHDRAWAL_BEAN.getUI_M_POL_NO()});

				 if (rsProdCode.next()) {			
					 productCode = rsProdCode.getString("POL_PROD_CODE");
				 }
				 System.out.println("Product Code-->"+productCode);
				 
				 System.out.println("user_id                    "+CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID")); 
				rsFlagYN = new CRUDHandler().executeSelectStatement(
						fetchFlagValueYNQuery, connection, new Object[]{CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"), productCode});

				 if (rsFlagYN.next()) {
					 flag = rsFlagYN.getString("ASD_CHAR_VALUE");
				 }
				System.out.println("ASD flag-->"+flag);

			
				if(flag!=null && flag.equalsIgnoreCase("N"))
				{
					COMP_WD_RATE.setDisabled(true);
				}else
				{
					COMP_WD_RATE.setDisabled(false);
				}

				/*end*/
			}catch (Exception e) {

				e.printStackTrace();
			}

		}
		/*end*/
		/*Added by gopi for partial withdrawal process on 01/07/17*/
		public String callPrint(){
			String outcome="";
			outcome = "PILT021_PT_IL_POLICY_PRINT";
			
			return outcome;
		}
		
		//end
		
		/*Added by saritha on 25-07-2017 for ssp call id ZBILQC-1732436*/
		private HtmlModalPanel COMP_BUS_REPORT_MODAL_PANEL;

		public HtmlModalPanel getCOMP_BUS_REPORT_MODAL_PANEL() {
			return COMP_BUS_REPORT_MODAL_PANEL;
		}

		public void setCOMP_BUS_REPORT_MODAL_PANEL(
				HtmlModalPanel cOMP_BUS_REPORT_MODAL_PANEL) {
			COMP_BUS_REPORT_MODAL_PANEL = cOMP_BUS_REPORT_MODAL_PANEL;
		}
			
		public String busRulButtonAction() {

			CommonUtils.clearMaps(this);

			String returnValue = null;
			try
			{
				
				new PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_DELEGATE()
				.executeSelectStatement(compositeAction);
				returnValue = businessModalPanel();

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return returnValue;
		}
		
		
		public String businessModalPanel() {
			 try {
				
				 System.out.println("inside businessModalPanel call------------------------");
				 setBlockFlag(true);				 
				 if(compositeAction.getPT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_ACTION_BEAN().getDataList_PT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG().size()>0)
				 {
				 compositeAction.getPT_IL_WITHDRAWAL_BUS_RULE_ERROR_MSG_ACTION_BEAN().onLoad(null);
				 compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getCOMP_BUS_REPORT_MODAL_PANEL().setShowWhenRendered(true);
			 }
			 }catch (Exception e) {
				 e.printStackTrace();
				 getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						 e.getMessage());
				 getErrorMap().put("ClaimModalPanel", e.getMessage());
			 }
			 return "";
		 }
		
		public String closeBusinessModalPanel() {
			 try {
				 
				 compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getCOMP_BUS_REPORT_MODAL_PANEL().setShowWhenRendered(false);
			 } catch (Exception e) {
				
				 e.printStackTrace();
				 getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						 e.getMessage());
				 getErrorMap().put("ModalPanel", e.getMessage());
			 }
			 return "";
		 }
		
		 /*End*/
		
		/*Added by Ameen on 01-12-2017 for ZBLIFE-1458892*/
		
		private HtmlOutputLabel COMP_WD_FLEX_07_LABEL;
		
		private HtmlInputText COMP_WD_FLEX_07;
		
		private HtmlOutputLabel COMP_WD_FLEX_08_LABEL;
		
		private HtmlInputText COMP_WD_FLEX_08;
		
		private HtmlOutputLabel COMP_WD_FLEX_09_LABEL;
		
		private HtmlInputText COMP_WD_FLEX_09;
		
		private HtmlOutputLabel COMP_WD_FLEX_10_LABEL;
		
		private HtmlInputText COMP_WD_FLEX_10;
		
		private HtmlOutputLabel COMP_WD_FLEX_11_LABEL;
		
		private HtmlInputText COMP_WD_FLEX_11;
		
		private HtmlOutputLabel COMP_WD_FLEX_12_LABEL;
		
		private HtmlInputText COMP_WD_FLEX_12;
		
		private HtmlInputText COMP_UI_M_BANK_NAME;
		
		private HtmlInputText COMP_UI_M_DIVN_CODE;


		public HtmlOutputLabel getCOMP_WD_FLEX_07_LABEL() {
			return COMP_WD_FLEX_07_LABEL;
		}

		public void setCOMP_WD_FLEX_07_LABEL(HtmlOutputLabel cOMP_WD_FLEX_07_LABEL) {
			COMP_WD_FLEX_07_LABEL = cOMP_WD_FLEX_07_LABEL;
		}

		public HtmlInputText getCOMP_WD_FLEX_07() {
			return COMP_WD_FLEX_07;
		}

		public void setCOMP_WD_FLEX_07(HtmlInputText cOMP_WD_FLEX_07) {
			COMP_WD_FLEX_07 = cOMP_WD_FLEX_07;
		}

		public HtmlOutputLabel getCOMP_WD_FLEX_08_LABEL() {
			return COMP_WD_FLEX_08_LABEL;
		}

		public void setCOMP_WD_FLEX_08_LABEL(HtmlOutputLabel cOMP_WD_FLEX_08_LABEL) {
			COMP_WD_FLEX_08_LABEL = cOMP_WD_FLEX_08_LABEL;
		}

		public HtmlInputText getCOMP_WD_FLEX_08() {
			return COMP_WD_FLEX_08;
		}

		public void setCOMP_WD_FLEX_08(HtmlInputText cOMP_WD_FLEX_08) {
			COMP_WD_FLEX_08 = cOMP_WD_FLEX_08;
		}

		public HtmlOutputLabel getCOMP_WD_FLEX_09_LABEL() {
			return COMP_WD_FLEX_09_LABEL;
		}

		public void setCOMP_WD_FLEX_09_LABEL(HtmlOutputLabel cOMP_WD_FLEX_09_LABEL) {
			COMP_WD_FLEX_09_LABEL = cOMP_WD_FLEX_09_LABEL;
		}

		public HtmlInputText getCOMP_WD_FLEX_09() {
			return COMP_WD_FLEX_09;
		}

		public void setCOMP_WD_FLEX_09(HtmlInputText cOMP_WD_FLEX_09) {
			COMP_WD_FLEX_09 = cOMP_WD_FLEX_09;
		}

		public HtmlOutputLabel getCOMP_WD_FLEX_10_LABEL() {
			return COMP_WD_FLEX_10_LABEL;
		}

		public void setCOMP_WD_FLEX_10_LABEL(HtmlOutputLabel cOMP_WD_FLEX_10_LABEL) {
			COMP_WD_FLEX_10_LABEL = cOMP_WD_FLEX_10_LABEL;
		}

		public HtmlInputText getCOMP_WD_FLEX_10() {
			return COMP_WD_FLEX_10;
		}

		public void setCOMP_WD_FLEX_10(HtmlInputText cOMP_WD_FLEX_10) {
			COMP_WD_FLEX_10 = cOMP_WD_FLEX_10;
		}

		public HtmlOutputLabel getCOMP_WD_FLEX_11_LABEL() {
			return COMP_WD_FLEX_11_LABEL;
		}

		public void setCOMP_WD_FLEX_11_LABEL(HtmlOutputLabel cOMP_WD_FLEX_11_LABEL) {
			COMP_WD_FLEX_11_LABEL = cOMP_WD_FLEX_11_LABEL;
		}

		public HtmlInputText getCOMP_WD_FLEX_11() {
			return COMP_WD_FLEX_11;
		}

		public void setCOMP_WD_FLEX_11(HtmlInputText cOMP_WD_FLEX_11) {
			COMP_WD_FLEX_11 = cOMP_WD_FLEX_11;
		}

		public HtmlOutputLabel getCOMP_WD_FLEX_12_LABEL() {
			return COMP_WD_FLEX_12_LABEL;
		}

		public void setCOMP_WD_FLEX_12_LABEL(HtmlOutputLabel cOMP_WD_FLEX_12_LABEL) {
			COMP_WD_FLEX_12_LABEL = cOMP_WD_FLEX_12_LABEL;
		}

		public HtmlInputText getCOMP_WD_FLEX_12() {
			return COMP_WD_FLEX_12;
		}

		public void setCOMP_WD_FLEX_12(HtmlInputText cOMP_WD_FLEX_12) {
			COMP_WD_FLEX_12 = cOMP_WD_FLEX_12;
		}
		
		public HtmlInputText getCOMP_UI_M_BANK_NAME() {
			return COMP_UI_M_BANK_NAME;
		}

		public void setCOMP_UI_M_BANK_NAME(HtmlInputText cOMP_UI_M_BANK_NAME) {
			COMP_UI_M_BANK_NAME = cOMP_UI_M_BANK_NAME;
		}

		public HtmlInputText getCOMP_UI_M_DIVN_CODE() {
			return COMP_UI_M_DIVN_CODE;
		}

		public void setCOMP_UI_M_DIVN_CODE(HtmlInputText cOMP_UI_M_DIVN_CODE) {
			COMP_UI_M_DIVN_CODE = cOMP_UI_M_DIVN_CODE;
		}

		
		/*Modified by Ganesh on 07-Feb-2018 for Bank details that is defaulted from Customer Master can be modified 
	     * before Approval of settlement as per thiag sir sugg.*/
		
		public void validateWD_PAY_TO(FacesContext context, UIComponent component,
				Object value)throws ValidatorException,Exception {
			ResultSet rs = null;
			try {
				PT_IL_WITHDRAWAL_BEAN.setWD_PAY_TO((String)value);
			if (CommonUtils.isIN(
					CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_FLEX_04(), ""),
					"EFT", "OTHERS")) {
				rs = validateBankDetails();
				if (rs != null && rs.next()) {
					if (rs.getString("CBAD_CUST_BANK_CODE") == null
							|| rs.getString("CBAD_ACNT_NAME") == null
							|| rs.getString("CBAD_ACNT_NO") == null
							|| rs.getString("CBAD_DIVISION") == null) {
						throw new Exception(
								"Enter the Bank Details in Customer Master");
					}
				} else {
					throw new Exception(
							"Enter the Bank Details in Customer Master");
				}
			}

			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
				throw new ValidatorException(new FacesMessage(e.getMessage()));

			}finally{
				 try {
					 CommonUtils.closeCursor(rs);
				 } catch (Exception e) {
					 // TODO Auto-generated catch block
					 e.printStackTrace();
				 }

			 }
		}

		/*End*/
		
		/*Added by saritha on 07-Feb-2018 for Bank details that is defaulted from Customer Master can be modified 
	     * before Approval of settlement as per thiag sir sugg.*/
		
		public void actionListenerWD_PAY_TO(ActionEvent event) {
			getErrorMap().clear();
			getWarningMap().clear();

			Connection con=null;
			String sortCodeQry = "SELECT BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH where BR_BANK_CODE = ? AND BR_BANK_SORT_CODE = ?";
			ResultSet sortCodeRS = null;
			ResultSet rs = null;
			try {

				UIInput input = (UIInput) event.getComponent().getParent();
				String inputvalue= (String)input.getSubmittedValue();
				PT_IL_WITHDRAWAL_BEAN.setWD_PAY_TO((String) inputvalue);
				System.out.println("inputvalue------"+inputvalue);
				con = CommonUtils.getConnection();
				
				if (CommonUtils.isIN(
						CommonUtils.nvl(PT_IL_WITHDRAWAL_BEAN.getWD_FLEX_04(), ""),
						"EFT", "OTHERS")) {
				rs = validateBankDetails();

				if(rs!=null && rs.next()){					
					PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_07(rs.getString("CBAD_CUST_BANK_CODE"));
					PT_IL_WITHDRAWAL_BEAN.setUI_M_BANK_NAME(rs.getString("BANK_NAME"));
					PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_08(rs.getString("CBAD_DIVISION"));
					if(PT_IL_WITHDRAWAL_BEAN.getWD_FLEX_08()!=null){
						sortCodeRS = new CRUDHandler().executeSelectStatement(sortCodeQry, con,new Object[]{PT_IL_WITHDRAWAL_BEAN.getWD_FLEX_07(),PT_IL_WITHDRAWAL_BEAN.getWD_FLEX_08()});
						if(sortCodeRS.next()){
							PT_IL_WITHDRAWAL_BEAN.setUI_M_DIVN_CODE(sortCodeRS.getString("BR_BANK_BRANCH_CODE"));
						}
					}
					PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_09(rs.getString("CBAD_ACNT_NO"));
					PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_10(rs.getString("CBAD_ACNT_NAME"));
					PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_11(rs.getString("CUST_MOBILE"));

				}

				COMP_WD_FLEX_07.resetValue();
				COMP_UI_M_BANK_NAME.resetValue();
				COMP_WD_FLEX_08.resetValue();
				COMP_UI_M_DIVN_CODE.resetValue();
				COMP_WD_FLEX_09.resetValue();
				COMP_WD_FLEX_10.resetValue();
				COMP_WD_FLEX_11.resetValue();
				}

			} catch (Exception exception) {
				exception.printStackTrace();

				throw new ValidatorException(new FacesMessage(exception
						.getMessage()));
			} finally {
				try {
					CommonUtils.closeCursor(rs);
					ErrorHelpUtil.getWarningForProcedure(CommonUtils
							.getConnection(), "WD_PAY_TO", getWarningMap());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		/*End*/
		
		public void validateWD_FLEX_07(FacesContext context, UIComponent component,
				Object value)throws ValidatorException,Exception {
			
			try {
				PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_07((String)value);
			
			} catch (Exception e) {e.printStackTrace();
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		 public ArrayList<LovBean> prepareSuggestionList_UI_M_BANK_CODE(Object object){
				
				ArrayList<LovBean> lovList = new ArrayList<LovBean>();
				ListItemUtil itemUtil = new ListItemUtil();
				String currentValue = (String) object;
				String moduleName = "PM006_A_APAC";
				String blockName = "PM_CUST_BANK_ACNT_DTLS";
				String fieldName = "CBAD_CUST_BANK_CODE";
				

				try {
					currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
					lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,null, 

							null,
							null, null, null, currentValue);
				} catch (Exception e) {
					e.printStackTrace();
					getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							e.getMessage());
					getErrorMap().put("SUGGETION", e.getMessage());
				}
				return lovList;
			}
		 
		 public ArrayList<LovBean> prepareSuggestionList_UI_M_DIVISION_CODE(Object currValue) {
				String code = (String) currValue;
				ArrayList<LovBean> suggestionList = null;
				Object[] object = {};
				String query = null;
				try {
					if ("*".equals(code)) {
						object = new Object[] { PT_IL_WITHDRAWAL_BEAN.getWD_FLEX_07(), PELConstants.suggetionRecordSize };
						
						
						query = "SELECT BR_BANK_SORT_CODE,BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH WHERE BR_BANK_CODE = ? AND ROWNUM <= ? ORDER BY 1";
					} else {
						object = new Object[] { PT_IL_WITHDRAWAL_BEAN.getWD_FLEX_07(), code + "%", code + "%",
								PELConstants.suggetionRecordSize };
						
						query = "SELECT BR_BANK_SORT_CODE,BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH WHERE BR_BANK_CODE = ? AND"
								+ "(UPPER(BR_BANK_SORT_CODE) LIKE UPPER(?) OR UPPER(BR_BANK_BRANCH_CODE) LIKE UPPER(?)) AND ROWNUM <= ? ORDER BY 1";
						/*End*/
					}
					suggestionList = ListItemUtil.prepareSuggestionList(query, object);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return suggestionList;
			}
		
		/*End*/
		 
		 /*Added by saritha on 16-12-2017 for ssp call id : ZBLIFE-1457793*/
		 
		 public void handlingNullZeroValidation() throws Exception {
			 
			 if(!"B".equalsIgnoreCase(getPT_IL_WITHDRAWAL_BEAN().getWD_TYPE())){
				if(getPT_IL_WITHDRAWAL_BEAN().getWD_GROSS_FC_VALUE()==null && getCOMP_WD_GROSS_FC_VALUE().isRequired()){
					throw new Exception("Gross FC Value:Validation Error: Value is required.");
				}
				
				if(getPT_IL_WITHDRAWAL_BEAN().getWD_TOPUP_FC_AMT()==null && getCOMP_WD_TOPUP_FC_AMT().isRequired() && !"B".equalsIgnoreCase(getPT_IL_WITHDRAWAL_BEAN().getWD_TYPE())){
					throw new Exception("Top Up FC Value:Validation Error: Value is required.");
				}
				if (getPT_IL_WITHDRAWAL_BEAN().getWD_TOPUP_FC_AMT()!=null && getPT_IL_WITHDRAWAL_BEAN().getWD_TOPUP_FC_AMT() <= 0 && !"B".equalsIgnoreCase(getPT_IL_WITHDRAWAL_BEAN().getWD_TYPE())) {
					throw new Exception("Top Up FC Value:Value Should Be Greater Than Zero !");
				}				
				
				 /*Modified by Janani on 16.01.2018 as per Gaurav's sugges.*/
				//if (getPT_IL_WITHDRAWAL_BEAN().getWD_GROSS_FC_VALUE()!=null && getPT_IL_WITHDRAWAL_BEAN().getWD_GROSS_FC_VALUE() <= 0 && !"B".equalsIgnoreCase(getPT_IL_WITHDRAWAL_BEAN().getWD_TYPE())) 
				
				if (getPT_IL_WITHDRAWAL_BEAN().getWD_GROSS_FC_VALUE()!=null && getPT_IL_WITHDRAWAL_BEAN().getWD_GROSS_FC_VALUE() <= 0 && 
						(!"B".equalsIgnoreCase(getPT_IL_WITHDRAWAL_BEAN().getWD_TYPE()) && !"I".equalsIgnoreCase(getPT_IL_WITHDRAWAL_BEAN().getWD_TYPE()))) {
				
				/*End*/	
					
				{
					throw new Exception("Gross FC Value:Value Should Be Greater Than Zero !");
				}
			 }else if("B".equalsIgnoreCase(getPT_IL_WITHDRAWAL_BEAN().getWD_TYPE())){
				 if(("N").equals(getPT_IL_WITHDRAWAL_BEAN().getWD_FULL_YN())){
					 if(CommonUtils.nvl(getPT_IL_WITHDRAWAL_BEAN().getWD_GROSS_FC_VALUE(),0) <= 0 && CommonUtils.nvl(getPT_IL_WITHDRAWAL_BEAN().getWD_TOPUP_FC_AMT(),0) <= 0){
						throw new Exception("Gross FC Value or Top Up FC Value is required.");
					}

				 }
			 }
			 }
		 }
		 
		 /*End*/
		 
		 /*Added by Janani on 16.01.2018 as per Gaurav's sugges.*/
		 public void chk_planType()
		 {
			 
			 System.out.println("enters into chk_planType");
		 
			 String planQry = "SELECT PLAN_TYPE,PROD_INTR_SAVINGS_YN FROM PT_IL_POLICY,PM_IL_PRODUCT,PM_IL_PLAN "
					 + "WHERE PLAN_CODE = POL_PLAN_CODE AND PROD_CODE = POL_PROD_CODE AND POL_NO = ?";
			 ResultSet rs = null;
			 String planType = null;
			 String prodIntrSavingsYN = null;
			 Connection con = null;
			 try
			 {
				 con = CommonUtils.getConnection();

				 rs = new CRUDHandler().executeSelectStatement(planQry, con, new Object[]{PT_IL_WITHDRAWAL_BEAN.getUI_M_POL_NO()});
				 if(rs.next()){
					 planType = rs.getString("PLAN_TYPE");
					 prodIntrSavingsYN = rs.getString("PROD_INTR_SAVINGS_YN");

					 PT_IL_WITHDRAWAL_BEAN.setPlanType(planType);
					 PT_IL_WITHDRAWAL_BEAN.setProdIntrSavingsYN(prodIntrSavingsYN);

					
				 }
				 
				 System.out.println("PLAN_TYPE               "+PT_IL_WITHDRAWAL_BEAN.getPlanType()+"      PROD_INTR_SAVINGS_YN      "+
				 PT_IL_WITHDRAWAL_BEAN.getProdIntrSavingsYN());
			 }
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			
		 }
		 
		 /*End*/
		 
		 /*Newly Field Added by saritha on 25-Jan-2018*/  
		 
		 private HtmlOutputLabel COMP_WD_FLEX_03_LABEL;
		 private HtmlInputText COMP_WD_FLEX_03;

		 public HtmlOutputLabel getCOMP_WD_FLEX_03_LABEL() {
			 return COMP_WD_FLEX_03_LABEL;
		 }

		 public void setCOMP_WD_FLEX_03_LABEL(HtmlOutputLabel cOMP_WD_FLEX_03_LABEL) {
			 COMP_WD_FLEX_03_LABEL = cOMP_WD_FLEX_03_LABEL;
		 }

		 public HtmlInputText getCOMP_WD_FLEX_03() {
			 return COMP_WD_FLEX_03;
		 }

		 public void setCOMP_WD_FLEX_03(HtmlInputText cOMP_WD_FLEX_03) {
			 COMP_WD_FLEX_03 = cOMP_WD_FLEX_03;
		 }

		 public void validateWD_FLEX_03(FacesContext context, UIComponent component,
				 Object value)throws ValidatorException,Exception {

			 try {
				 PT_IL_WITHDRAWAL_BEAN.setWD_FLEX_03((String)value);

			 } catch (Exception e) {
				 e.printStackTrace();
				 throw new ValidatorException(new FacesMessage(e.getMessage()));
			 }
		 }

		 public void instantiateAllComponent() { 
			 COMP_WD_FLEX_03_LABEL = new HtmlOutputLabel();
			 COMP_WD_FLEX_03       = new HtmlInputText();
			 COMP_UI_M_BUT_APPROVE = new HtmlCommandButton();
			 COMP_WD_FRZ_FLAG = new HtmlSelectBooleanCheckbox();

		 }

		/*End*/

		 
		 /*Added by Ganesh on 07-Feb-2018 for Bank details that is defaulted from Customer Master can be modified 
		     * before Approval of settlement as per thiag sir sugg.*/
		 
		 public ResultSet validateBankDetails(){
			 ResultSet rsBankDetails = null;
			 String bankDtlQuery = null;
			 Object[] bankDtlParams = null;
			 Connection con = null;
			 try{
				 con = CommonUtils.getConnection();	

				 if("A".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getWD_PAY_TO()) && ("EFT".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getWD_FLEX_04())||"OTHERS".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getWD_FLEX_04()))){
					 bankDtlQuery = "SELECT CBAD_CUST_BANK_CODE, CBAD_BANK_NAME, CBAD_ACNT_NAME, CBAD_ACNT_NO, CBAD_DIVISION, "
							 + "(CUST_TEL_AREA_CODE2 || '-' || CUST_PHONE2) CUST_MOBILE, BANK_NAME,CUST_CODE,POAD_POL_SYS_ID "
							 + "FROM PM_CUST_BANK_ACNT_DTLS,PM_CUSTOMER,FM_BANK,PT_IL_POL_ASSURED_DTLS WHERE CUST_CODE = "
							 + "CBAD_CUST_CODE AND NVL(CBAD_PREF_ACNT_YN, 'N') = 'Y' AND BANK_CODE = CBAD_CUST_BANK_CODE "
							 + "AND POAD_ASSR_CODE = CBAD_CUST_CODE AND POAD_POL_SYS_ID IN (SELECT POL_SYS_ID FROM "
							 + "PT_IL_POLICY WHERE POL_NO = ?)";
					 bankDtlParams = new Object[]{PT_IL_WITHDRAWAL_BEAN.getUI_M_POL_NO()};
					 rsBankDetails = new CRUDHandler().executeSelectStatement(bankDtlQuery, con,bankDtlParams);

				 }else if("C".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getWD_PAY_TO()) && ("EFT".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getWD_FLEX_04())||"OTHERS".equalsIgnoreCase(PT_IL_WITHDRAWAL_BEAN.getWD_FLEX_04()))){

					 bankDtlQuery ="SELECT CBAD_CUST_BANK_CODE,CBAD_BANK_NAME,CBAD_ACNT_NAME,CBAD_ACNT_NO,CBAD_DIVISION,"
							 + "(CUST_TEL_AREA_CODE2||'-'||CUST_PHONE2) CUST_MOBILE,BANK_NAME FROM PM_CUST_BANK_ACNT_DTLS,"
							 + "PM_CUSTOMER,FM_BANK WHERE CUST_CODE = CBAD_CUST_CODE AND NVL(CBAD_PREF_ACNT_YN,'N') = 'Y' "
							 + "AND CBAD_CUST_CODE = ? AND BANK_CODE = CBAD_CUST_BANK_CODE";
					 bankDtlParams = new Object[]{PT_IL_WITHDRAWAL_BEAN.getUI_M_POL_CUST_CODE()};
					 rsBankDetails = new CRUDHandler().executeSelectStatement(bankDtlQuery, con,bankDtlParams);
				 } 

			 }catch(Exception e){
				 e.printStackTrace();
			 }

			 return rsBankDetails;

		 }
		 
		 /*End*/
		 /*Added by ganesh on 09-04-2018 for freeze flag*/
		 public void validateWD_FRZ_FLAG(FacesContext fc, UIComponent component,
					Object value) throws ValidatorException, Exception {
				try {
					if ((Boolean) value) {
						PT_IL_WITHDRAWAL_BEAN.setWD_FRZ_FLAG("Y");
						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
					} else {
						PT_IL_WITHDRAWAL_BEAN.setWD_FRZ_FLAG("N");
						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_APPROVE().setDisabled(false);
						}
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
			}
		 
		private HtmlSelectBooleanCheckbox COMP_WD_FRZ_FLAG;



		public HtmlSelectBooleanCheckbox getCOMP_WD_FRZ_FLAG() {
			return COMP_WD_FRZ_FLAG;
		}

		public void setCOMP_WD_FRZ_FLAG(HtmlSelectBooleanCheckbox cOMP_WD_FRZ_FLAG) {
			COMP_WD_FRZ_FLAG = cOMP_WD_FRZ_FLAG;
		}
}
