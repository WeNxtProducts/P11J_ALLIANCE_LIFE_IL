package com.iii.pel.forms.PILT013;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlModalPanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_SURR_MAT_VALUES_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_SMV_DATE_LABEL;

	private HtmlCalendar COMP_SMV_DATE;

	private HtmlOutputLabel COMP_SMV_FC_RED_SA_LABEL;

	private HtmlInputText COMP_SMV_FC_RED_SA;

	private HtmlOutputLabel COMP_SMV_FC_ACC_PROFIT_LABEL;

	private HtmlInputText COMP_SMV_FC_ACC_PROFIT;

	private HtmlOutputLabel COMP_SMV_FC_GROSS_VALUE_LABEL;

	private HtmlInputText COMP_SMV_FC_GROSS_VALUE;

	private HtmlOutputLabel COMP_UI_M_FC_NET_PAID_AMT_LABEL;

	private HtmlInputText COMP_UI_M_FC_NET_PAID_AMT;

	private HtmlOutputLabel COMP_SMV_PAID_DT_LABEL;

	private HtmlCalendar COMP_SMV_PAID_DT;

	private HtmlOutputLabel COMP_SMV_FC_NET_PAID_AMT_LABEL;

	private HtmlInputText COMP_SMV_FC_NET_PAID_AMT;

	private HtmlOutputLabel COMP_SMV_LC_RED_SA_LABEL;

	private HtmlInputText COMP_SMV_LC_RED_SA;

	private HtmlOutputLabel COMP_SMV_LC_ACC_PROFIT_LABEL;

	private HtmlInputText COMP_SMV_LC_ACC_PROFIT;

	private HtmlOutputLabel COMP_SMV_LC_GROSS_VALUE_LABEL;

	private HtmlInputText COMP_SMV_LC_GROSS_VALUE;

	private HtmlOutputLabel COMP_UI_M_LC_NET_PAID_AMT_LABEL;

	private HtmlInputText COMP_UI_M_LC_NET_PAID_AMT;

	private HtmlOutputLabel COMP_SMV_LC_NET_PAID_AMT_LABEL;

	private HtmlInputText COMP_SMV_LC_NET_PAID_AMT;

	private HtmlOutputLabel COMP_SMV_REF_NO_LABEL;

	private HtmlInputText COMP_SMV_REF_NO;

	private HtmlOutputLabel COMP_SMV_FC_OS_LOAN_LABEL;

	private HtmlInputText COMP_SMV_FC_OS_LOAN;

	private HtmlOutputLabel COMP_SMV_LC_OS_LOAN_LABEL;

	private HtmlInputText COMP_SMV_LC_OS_LOAN;

	private HtmlOutputLabel COMP_SMV_FC_CHARGE_AMT_LABEL;

	private HtmlInputText COMP_SMV_FC_CHARGE_AMT;

	private HtmlOutputLabel COMP_SMV_FC_BAL_LOAN_LABEL;

	private HtmlInputText COMP_SMV_FC_BAL_LOAN;

	private HtmlOutputLabel COMP_SMV_LC_BAL_LOAN_LABEL;

	private HtmlInputText COMP_SMV_LC_BAL_LOAN;

	private HtmlOutputLabel COMP_SMV_LOAN_INT_YN_LABEL;

	private HtmlSelectOneMenu COMP_SMV_LOAN_INT_YN;

	private HtmlOutputLabel COMP_SMV_LC_CHARGE_AMT_LABEL;

	private HtmlInputText COMP_SMV_LC_CHARGE_AMT;

	private HtmlOutputLabel COMP_SMV_FC_LOAN_INT_LABEL;

	private HtmlInputText COMP_SMV_FC_LOAN_INT;

	private HtmlOutputLabel COMP_SMV_LC_LOAN_INT_LABEL;

	private HtmlInputText COMP_SMV_LC_LOAN_INT;

	private HtmlOutputLabel COMP_SMV_PAYTO_LABEL;

	private HtmlSelectOneMenu COMP_SMV_PAYTO;

	private HtmlOutputLabel COMP_SMV_FC_UNPAID_PREM_LABEL;

	private HtmlInputText COMP_SMV_FC_UNPAID_PREM;

	private HtmlOutputLabel COMP_SMV_LC_UNPAID_PREM_LABEL;

	private HtmlInputText COMP_SMV_LC_UNPAID_PREM;

	private HtmlOutputLabel COMP_SMV_UNPAID_PREM_YN_LABEL;

	private HtmlSelectOneMenu COMP_SMV_UNPAID_PREM_YN;

	private HtmlOutputLabel COMP_SMV_UNPAID_PREM_INT_CODE_LABEL;

	private HtmlInputText COMP_SMV_UNPAID_PREM_INT_CODE;

	private HtmlOutputLabel COMP_SMV_FC_UNPAID_PREM_INT_LABEL;

	private HtmlInputText COMP_SMV_FC_UNPAID_PREM_INT;

	private HtmlOutputLabel COMP_SMV_LC_UNPAID_PREM_INT_LABEL;

	private HtmlInputText COMP_SMV_LC_UNPAID_PREM_INT;
	
	private HtmlOutputLabel COMP_FTR_SMV_LC_RED_SA_LABEL;
	
	private HtmlInputText COMP_FTR_SMV_LC_RED_SA;
	
	private HtmlOutputText COMP_UI_B_SMV_FLAG;
	
	private HtmlOutputText COMP_UI_B_SMV_FLAG1;
	
	private PT_IL_SURR_MAT_VALUES PT_IL_SURR_MAT_VALUES_BEAN;

	public PILT013_COMPOSITE_ACTION compositeAction;

	private PT_IL_SURR_MAT_VALUES_HELPER helper;

	private List<PT_IL_SURR_MAT_VALUES> dataList_PT_IL_SURR_MAT_VALUES = new ArrayList<PT_IL_SURR_MAT_VALUES>();

	private UIData dataTable;

	private List<SelectItem> listSMV_LOAN_INT_YN;

	private List<SelectItem> listSMV_PAYTO;

	private List<SelectItem> listSMV_UNPAID_PREM_YN;
	private HtmlSelectOneMenu COMP_TYPE;
	private HtmlInputText COMP_MICR_CODE;
	private HtmlInputText COMP_ACC_NO;
	private HtmlOutputLabel COMP_TYPE_LABEL;
	private HtmlOutputLabel COMP_MICR_CODE_LABEL;
	private HtmlOutputLabel COMP_ACC_NO_LABEL;
	
	private List<SelectItem> listLOAN_FLEX_04 = new ArrayList<SelectItem>();

	public PT_IL_SURR_MAT_VALUES_ACTION() {

		PT_IL_SURR_MAT_VALUES_BEAN = new PT_IL_SURR_MAT_VALUES();
		helper = new PT_IL_SURR_MAT_VALUES_HELPER();
		
		
		/*
		 * Commented by Janani on 28.06.2017 for ZBILQC-1724475
		 * 
		 * COMP_SMV_FC_LOAN_INT = new HtmlInputText();
		COMP_SMV_LC_LOAN_INT = new HtmlInputText();
		COMP_SMV_FC_UNPAID_PREM = new HtmlInputText();
		COMP_SMV_LC_UNPAID_PREM = new HtmlInputText();
		COMP_SMV_UNPAID_PREM_YN = new HtmlSelectOneMenu();
		COMP_SMV_LOAN_INT_YN = new HtmlSelectOneMenu();
		COMP_SMV_DATE_LABEL = new HtmlOutputLabel();
		COMP_SMV_FC_NET_PAID_AMT_LABEL = new HtmlOutputLabel();
		COMP_SMV_PAID_DT_LABEL = new HtmlOutputLabel();
		COMP_SMV_UNPAID_PREM_INT_CODE = new HtmlInputText();
		COMP_SMV_LC_UNPAID_PREM_INT = new HtmlInputText();
		COMP_SMV_FC_UNPAID_PREM_INT = new HtmlInputText();
		COMP_SMV_LC_NET_PAID_AMT = new HtmlInputText();*/
		
		/*Added by Janani on 28.06.2017 for ZBILQC-1724475*/
		
		initializeAllComponent();
				
		/*End*/
		
		prepareListItemValues();
		setListItemValues();
		
	}
	public void setListItemValues(){
		List<SelectItem> listStandard = new ArrayList<SelectItem>();
		/*listStandard.add(new SelectItem("OTHERS", "OTHERS"));
		
		Added and modified by Raja on 03.05.2017 for hands-on-feedback point
		listStandard.add(new SelectItem("EFT", "EFT"));
		listStandard.add(new SelectItem("EFT", "Paynet"));
		listStandard.add(new SelectItem("CHK", "Cheque"));*/
		/*End*/
		
		/*Commentted &Modified by saritha on 02-01-2017 for ssp call id : ZBLIFE-1464439*/
		listStandard.add(new SelectItem("CHK", "Cheque"));
		listStandard.add(new SelectItem("OTHERS", "RTGS"));
		listStandard.add(new SelectItem("EFT", "Bank Transfer"));
		listStandard.add(new SelectItem("ECO", "Ecocash"));
		listStandard.add(new SelectItem("WAL", "One Wallet"));
		listStandard.add(new SelectItem("TEL", "Telecash"));
		/*End*/
		
		setListLOAN_FLEX_04(listStandard);

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
	public List<SelectItem> getListLOAN_FLEX_04() {
		return listLOAN_FLEX_04;
	}
	public void setListLOAN_FLEX_04(List<SelectItem> listLOAN_FLEX_04) {
		this.listLOAN_FLEX_04 = listLOAN_FLEX_04;
	}
	public HtmlOutputLabel getCOMP_SMV_DATE_LABEL() {
		return COMP_SMV_DATE_LABEL;
	}

	public HtmlCalendar getCOMP_SMV_DATE() {
		return COMP_SMV_DATE;
	}

	public void setCOMP_SMV_DATE_LABEL(HtmlOutputLabel COMP_SMV_DATE_LABEL) {
		this.COMP_SMV_DATE_LABEL = COMP_SMV_DATE_LABEL;
	}

	public void setCOMP_SMV_DATE(HtmlCalendar COMP_SMV_DATE) {
		this.COMP_SMV_DATE = COMP_SMV_DATE;
	}

	public HtmlOutputLabel getCOMP_SMV_FC_RED_SA_LABEL() {
		return COMP_SMV_FC_RED_SA_LABEL;
	}

	public HtmlInputText getCOMP_SMV_FC_RED_SA() {
		return COMP_SMV_FC_RED_SA;
	}

	public void setCOMP_SMV_FC_RED_SA_LABEL(
			HtmlOutputLabel COMP_SMV_FC_RED_SA_LABEL) {
		this.COMP_SMV_FC_RED_SA_LABEL = COMP_SMV_FC_RED_SA_LABEL;
	}

	public void setCOMP_SMV_FC_RED_SA(HtmlInputText COMP_SMV_FC_RED_SA) {
		this.COMP_SMV_FC_RED_SA = COMP_SMV_FC_RED_SA;
	}

	public HtmlOutputLabel getCOMP_SMV_FC_ACC_PROFIT_LABEL() {
		return COMP_SMV_FC_ACC_PROFIT_LABEL;
	}

	public HtmlInputText getCOMP_SMV_FC_ACC_PROFIT() {
		return COMP_SMV_FC_ACC_PROFIT;
	}

	public void setCOMP_SMV_FC_ACC_PROFIT_LABEL(
			HtmlOutputLabel COMP_SMV_FC_ACC_PROFIT_LABEL) {
		this.COMP_SMV_FC_ACC_PROFIT_LABEL = COMP_SMV_FC_ACC_PROFIT_LABEL;
	}

	public void setCOMP_SMV_FC_ACC_PROFIT(HtmlInputText COMP_SMV_FC_ACC_PROFIT) {
		this.COMP_SMV_FC_ACC_PROFIT = COMP_SMV_FC_ACC_PROFIT;
	}

	public HtmlOutputLabel getCOMP_SMV_FC_GROSS_VALUE_LABEL() {
		return COMP_SMV_FC_GROSS_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_SMV_FC_GROSS_VALUE() {
		return COMP_SMV_FC_GROSS_VALUE;
	}

	public void setCOMP_SMV_FC_GROSS_VALUE_LABEL(
			HtmlOutputLabel COMP_SMV_FC_GROSS_VALUE_LABEL) {
		this.COMP_SMV_FC_GROSS_VALUE_LABEL = COMP_SMV_FC_GROSS_VALUE_LABEL;
	}

	public void setCOMP_SMV_FC_GROSS_VALUE(HtmlInputText COMP_SMV_FC_GROSS_VALUE) {
		this.COMP_SMV_FC_GROSS_VALUE = COMP_SMV_FC_GROSS_VALUE;
	}

	public HtmlOutputLabel getCOMP_UI_M_FC_NET_PAID_AMT_LABEL() {
		return COMP_UI_M_FC_NET_PAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FC_NET_PAID_AMT() {
		return COMP_UI_M_FC_NET_PAID_AMT;
	}

	public void setCOMP_UI_M_FC_NET_PAID_AMT_LABEL(
			HtmlOutputLabel COMP_UI_M_FC_NET_PAID_AMT_LABEL) {
		this.COMP_UI_M_FC_NET_PAID_AMT_LABEL = COMP_UI_M_FC_NET_PAID_AMT_LABEL;
	}

	public void setCOMP_UI_M_FC_NET_PAID_AMT(
			HtmlInputText COMP_UI_M_FC_NET_PAID_AMT) {
		this.COMP_UI_M_FC_NET_PAID_AMT = COMP_UI_M_FC_NET_PAID_AMT;
	}

	public HtmlOutputLabel getCOMP_SMV_PAID_DT_LABEL() {
		return COMP_SMV_PAID_DT_LABEL;
	}

	public HtmlCalendar getCOMP_SMV_PAID_DT() {
		return COMP_SMV_PAID_DT;
	}

	public void setCOMP_SMV_PAID_DT_LABEL(HtmlOutputLabel COMP_SMV_PAID_DT_LABEL) {
		this.COMP_SMV_PAID_DT_LABEL = COMP_SMV_PAID_DT_LABEL;
	}

	public void setCOMP_SMV_PAID_DT(HtmlCalendar COMP_SMV_PAID_DT) {
		this.COMP_SMV_PAID_DT = COMP_SMV_PAID_DT;
	}

	public HtmlOutputLabel getCOMP_SMV_FC_NET_PAID_AMT_LABEL() {
		return COMP_SMV_FC_NET_PAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_SMV_FC_NET_PAID_AMT() {
		return COMP_SMV_FC_NET_PAID_AMT;
	}

	public void setCOMP_SMV_FC_NET_PAID_AMT_LABEL(
			HtmlOutputLabel COMP_SMV_FC_NET_PAID_AMT_LABEL) {
		this.COMP_SMV_FC_NET_PAID_AMT_LABEL = COMP_SMV_FC_NET_PAID_AMT_LABEL;
	}

	public void setCOMP_SMV_FC_NET_PAID_AMT(
			HtmlInputText COMP_SMV_FC_NET_PAID_AMT) {
		this.COMP_SMV_FC_NET_PAID_AMT = COMP_SMV_FC_NET_PAID_AMT;
	}

	public HtmlOutputLabel getCOMP_SMV_LC_RED_SA_LABEL() {
		return COMP_SMV_LC_RED_SA_LABEL;
	}

	public HtmlInputText getCOMP_SMV_LC_RED_SA() {
		return COMP_SMV_LC_RED_SA;
	}

	public void setCOMP_SMV_LC_RED_SA_LABEL(
			HtmlOutputLabel COMP_SMV_LC_RED_SA_LABEL) {
		this.COMP_SMV_LC_RED_SA_LABEL = COMP_SMV_LC_RED_SA_LABEL;
	}

	public void setCOMP_SMV_LC_RED_SA(HtmlInputText COMP_SMV_LC_RED_SA) {
		this.COMP_SMV_LC_RED_SA = COMP_SMV_LC_RED_SA;
	}

	public HtmlOutputLabel getCOMP_SMV_LC_ACC_PROFIT_LABEL() {
		return COMP_SMV_LC_ACC_PROFIT_LABEL;
	}

	public HtmlInputText getCOMP_SMV_LC_ACC_PROFIT() {
		return COMP_SMV_LC_ACC_PROFIT;
	}

	public void setCOMP_SMV_LC_ACC_PROFIT_LABEL(
			HtmlOutputLabel COMP_SMV_LC_ACC_PROFIT_LABEL) {
		this.COMP_SMV_LC_ACC_PROFIT_LABEL = COMP_SMV_LC_ACC_PROFIT_LABEL;
	}

	public void setCOMP_SMV_LC_ACC_PROFIT(HtmlInputText COMP_SMV_LC_ACC_PROFIT) {
		this.COMP_SMV_LC_ACC_PROFIT = COMP_SMV_LC_ACC_PROFIT;
	}

	public HtmlOutputLabel getCOMP_SMV_LC_GROSS_VALUE_LABEL() {
		return COMP_SMV_LC_GROSS_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_SMV_LC_GROSS_VALUE() {
		return COMP_SMV_LC_GROSS_VALUE;
	}

	public void setCOMP_SMV_LC_GROSS_VALUE_LABEL(
			HtmlOutputLabel COMP_SMV_LC_GROSS_VALUE_LABEL) {
		this.COMP_SMV_LC_GROSS_VALUE_LABEL = COMP_SMV_LC_GROSS_VALUE_LABEL;
	}

	public void setCOMP_SMV_LC_GROSS_VALUE(HtmlInputText COMP_SMV_LC_GROSS_VALUE) {
		this.COMP_SMV_LC_GROSS_VALUE = COMP_SMV_LC_GROSS_VALUE;
	}

	public HtmlOutputLabel getCOMP_UI_M_LC_NET_PAID_AMT_LABEL() {
		return COMP_UI_M_LC_NET_PAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LC_NET_PAID_AMT() {
		return COMP_UI_M_LC_NET_PAID_AMT;
	}

	public void setCOMP_UI_M_LC_NET_PAID_AMT_LABEL(
			HtmlOutputLabel COMP_UI_M_LC_NET_PAID_AMT_LABEL) {
		this.COMP_UI_M_LC_NET_PAID_AMT_LABEL = COMP_UI_M_LC_NET_PAID_AMT_LABEL;
	}

	public void setCOMP_UI_M_LC_NET_PAID_AMT(
			HtmlInputText COMP_UI_M_LC_NET_PAID_AMT) {
		this.COMP_UI_M_LC_NET_PAID_AMT = COMP_UI_M_LC_NET_PAID_AMT;
	}

	public HtmlOutputLabel getCOMP_SMV_LC_NET_PAID_AMT_LABEL() {
		return COMP_SMV_LC_NET_PAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_SMV_LC_NET_PAID_AMT() {
		return COMP_SMV_LC_NET_PAID_AMT;
	}

	public void setCOMP_SMV_LC_NET_PAID_AMT_LABEL(
			HtmlOutputLabel COMP_SMV_LC_NET_PAID_AMT_LABEL) {
		this.COMP_SMV_LC_NET_PAID_AMT_LABEL = COMP_SMV_LC_NET_PAID_AMT_LABEL;
	}

	public void setCOMP_SMV_LC_NET_PAID_AMT(
			HtmlInputText COMP_SMV_LC_NET_PAID_AMT) {
		this.COMP_SMV_LC_NET_PAID_AMT = COMP_SMV_LC_NET_PAID_AMT;
	}

	public HtmlOutputLabel getCOMP_SMV_REF_NO_LABEL() {
		return COMP_SMV_REF_NO_LABEL;
	}

	public HtmlInputText getCOMP_SMV_REF_NO() {
		return COMP_SMV_REF_NO;
	}

	public void setCOMP_SMV_REF_NO_LABEL(HtmlOutputLabel COMP_SMV_REF_NO_LABEL) {
		this.COMP_SMV_REF_NO_LABEL = COMP_SMV_REF_NO_LABEL;
	}

	public void setCOMP_SMV_REF_NO(HtmlInputText COMP_SMV_REF_NO) {
		this.COMP_SMV_REF_NO = COMP_SMV_REF_NO;
	}

	public HtmlOutputLabel getCOMP_SMV_FC_OS_LOAN_LABEL() {
		return COMP_SMV_FC_OS_LOAN_LABEL;
	}

	public HtmlInputText getCOMP_SMV_FC_OS_LOAN() {
		return COMP_SMV_FC_OS_LOAN;
	}

	public void setCOMP_SMV_FC_OS_LOAN_LABEL(
			HtmlOutputLabel COMP_SMV_FC_OS_LOAN_LABEL) {
		this.COMP_SMV_FC_OS_LOAN_LABEL = COMP_SMV_FC_OS_LOAN_LABEL;
	}

	public void setCOMP_SMV_FC_OS_LOAN(HtmlInputText COMP_SMV_FC_OS_LOAN) {
		this.COMP_SMV_FC_OS_LOAN = COMP_SMV_FC_OS_LOAN;
	}

	public HtmlOutputLabel getCOMP_SMV_LC_OS_LOAN_LABEL() {
		return COMP_SMV_LC_OS_LOAN_LABEL;
	}

	public HtmlInputText getCOMP_SMV_LC_OS_LOAN() {
		return COMP_SMV_LC_OS_LOAN;
	}

	public void setCOMP_SMV_LC_OS_LOAN_LABEL(
			HtmlOutputLabel COMP_SMV_LC_OS_LOAN_LABEL) {
		this.COMP_SMV_LC_OS_LOAN_LABEL = COMP_SMV_LC_OS_LOAN_LABEL;
	}

	public void setCOMP_SMV_LC_OS_LOAN(HtmlInputText COMP_SMV_LC_OS_LOAN) {
		this.COMP_SMV_LC_OS_LOAN = COMP_SMV_LC_OS_LOAN;
	}

	public HtmlOutputLabel getCOMP_SMV_FC_CHARGE_AMT_LABEL() {
		return COMP_SMV_FC_CHARGE_AMT_LABEL;
	}

	public HtmlInputText getCOMP_SMV_FC_CHARGE_AMT() {
		return COMP_SMV_FC_CHARGE_AMT;
	}

	public void setCOMP_SMV_FC_CHARGE_AMT_LABEL(
			HtmlOutputLabel COMP_SMV_FC_CHARGE_AMT_LABEL) {
		this.COMP_SMV_FC_CHARGE_AMT_LABEL = COMP_SMV_FC_CHARGE_AMT_LABEL;
	}

	public void setCOMP_SMV_FC_CHARGE_AMT(HtmlInputText COMP_SMV_FC_CHARGE_AMT) {
		this.COMP_SMV_FC_CHARGE_AMT = COMP_SMV_FC_CHARGE_AMT;
	}

	public HtmlOutputLabel getCOMP_SMV_FC_BAL_LOAN_LABEL() {
		return COMP_SMV_FC_BAL_LOAN_LABEL;
	}

	public HtmlInputText getCOMP_SMV_FC_BAL_LOAN() {
		return COMP_SMV_FC_BAL_LOAN;
	}

	public void setCOMP_SMV_FC_BAL_LOAN_LABEL(
			HtmlOutputLabel COMP_SMV_FC_BAL_LOAN_LABEL) {
		this.COMP_SMV_FC_BAL_LOAN_LABEL = COMP_SMV_FC_BAL_LOAN_LABEL;
	}

	public void setCOMP_SMV_FC_BAL_LOAN(HtmlInputText COMP_SMV_FC_BAL_LOAN) {
		this.COMP_SMV_FC_BAL_LOAN = COMP_SMV_FC_BAL_LOAN;
	}

	public HtmlOutputLabel getCOMP_SMV_LC_BAL_LOAN_LABEL() {
		return COMP_SMV_LC_BAL_LOAN_LABEL;
	}

	public HtmlInputText getCOMP_SMV_LC_BAL_LOAN() {
		return COMP_SMV_LC_BAL_LOAN;
	}

	public void setCOMP_SMV_LC_BAL_LOAN_LABEL(
			HtmlOutputLabel COMP_SMV_LC_BAL_LOAN_LABEL) {
		this.COMP_SMV_LC_BAL_LOAN_LABEL = COMP_SMV_LC_BAL_LOAN_LABEL;
	}

	public void setCOMP_SMV_LC_BAL_LOAN(HtmlInputText COMP_SMV_LC_BAL_LOAN) {
		this.COMP_SMV_LC_BAL_LOAN = COMP_SMV_LC_BAL_LOAN;
	}

	public HtmlOutputLabel getCOMP_SMV_LOAN_INT_YN_LABEL() {
		return COMP_SMV_LOAN_INT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_SMV_LOAN_INT_YN() {
		return COMP_SMV_LOAN_INT_YN;
	}

	public void setCOMP_SMV_LOAN_INT_YN_LABEL(
			HtmlOutputLabel COMP_SMV_LOAN_INT_YN_LABEL) {
		this.COMP_SMV_LOAN_INT_YN_LABEL = COMP_SMV_LOAN_INT_YN_LABEL;
	}

	public void setCOMP_SMV_LOAN_INT_YN(HtmlSelectOneMenu COMP_SMV_LOAN_INT_YN) {
		this.COMP_SMV_LOAN_INT_YN = COMP_SMV_LOAN_INT_YN;
	}

	public HtmlOutputLabel getCOMP_SMV_LC_CHARGE_AMT_LABEL() {
		return COMP_SMV_LC_CHARGE_AMT_LABEL;
	}

	public HtmlInputText getCOMP_SMV_LC_CHARGE_AMT() {
		return COMP_SMV_LC_CHARGE_AMT;
	}

	public void setCOMP_SMV_LC_CHARGE_AMT_LABEL(
			HtmlOutputLabel COMP_SMV_LC_CHARGE_AMT_LABEL) {
		this.COMP_SMV_LC_CHARGE_AMT_LABEL = COMP_SMV_LC_CHARGE_AMT_LABEL;
	}

	public void setCOMP_SMV_LC_CHARGE_AMT(HtmlInputText COMP_SMV_LC_CHARGE_AMT) {
		this.COMP_SMV_LC_CHARGE_AMT = COMP_SMV_LC_CHARGE_AMT;
	}

	public HtmlOutputLabel getCOMP_SMV_FC_LOAN_INT_LABEL() {
		return COMP_SMV_FC_LOAN_INT_LABEL;
	}

	public HtmlInputText getCOMP_SMV_FC_LOAN_INT() {
		return COMP_SMV_FC_LOAN_INT;
	}

	public void setCOMP_SMV_FC_LOAN_INT_LABEL(
			HtmlOutputLabel COMP_SMV_FC_LOAN_INT_LABEL) {
		this.COMP_SMV_FC_LOAN_INT_LABEL = COMP_SMV_FC_LOAN_INT_LABEL;
	}

	public void setCOMP_SMV_FC_LOAN_INT(HtmlInputText COMP_SMV_FC_LOAN_INT) {
		this.COMP_SMV_FC_LOAN_INT = COMP_SMV_FC_LOAN_INT;
	}

	public HtmlOutputLabel getCOMP_SMV_LC_LOAN_INT_LABEL() {
		return COMP_SMV_LC_LOAN_INT_LABEL;
	}

	public HtmlInputText getCOMP_SMV_LC_LOAN_INT() {
		return COMP_SMV_LC_LOAN_INT;
	}

	public void setCOMP_SMV_LC_LOAN_INT_LABEL(
			HtmlOutputLabel COMP_SMV_LC_LOAN_INT_LABEL) {
		this.COMP_SMV_LC_LOAN_INT_LABEL = COMP_SMV_LC_LOAN_INT_LABEL;
	}

	public void setCOMP_SMV_LC_LOAN_INT(HtmlInputText COMP_SMV_LC_LOAN_INT) {
		this.COMP_SMV_LC_LOAN_INT = COMP_SMV_LC_LOAN_INT;
	}

	public HtmlOutputLabel getCOMP_SMV_PAYTO_LABEL() {
		return COMP_SMV_PAYTO_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_SMV_PAYTO() {
		return COMP_SMV_PAYTO;
	}

	public void setCOMP_SMV_PAYTO_LABEL(HtmlOutputLabel COMP_SMV_PAYTO_LABEL) {
		this.COMP_SMV_PAYTO_LABEL = COMP_SMV_PAYTO_LABEL;
	}

	public void setCOMP_SMV_PAYTO(HtmlSelectOneMenu COMP_SMV_PAYTO) {
		this.COMP_SMV_PAYTO = COMP_SMV_PAYTO;
	}

	public HtmlOutputLabel getCOMP_SMV_FC_UNPAID_PREM_LABEL() {
		return COMP_SMV_FC_UNPAID_PREM_LABEL;
	}

	public HtmlInputText getCOMP_SMV_FC_UNPAID_PREM() {
		return COMP_SMV_FC_UNPAID_PREM;
	}

	public void setCOMP_SMV_FC_UNPAID_PREM_LABEL(
			HtmlOutputLabel COMP_SMV_FC_UNPAID_PREM_LABEL) {
		this.COMP_SMV_FC_UNPAID_PREM_LABEL = COMP_SMV_FC_UNPAID_PREM_LABEL;
	}

	public void setCOMP_SMV_FC_UNPAID_PREM(HtmlInputText COMP_SMV_FC_UNPAID_PREM) {
		this.COMP_SMV_FC_UNPAID_PREM = COMP_SMV_FC_UNPAID_PREM;
	}

	public HtmlOutputLabel getCOMP_SMV_LC_UNPAID_PREM_LABEL() {
		return COMP_SMV_LC_UNPAID_PREM_LABEL;
	}

	public HtmlInputText getCOMP_SMV_LC_UNPAID_PREM() {
		return COMP_SMV_LC_UNPAID_PREM;
	}

	public void setCOMP_SMV_LC_UNPAID_PREM_LABEL(
			HtmlOutputLabel COMP_SMV_LC_UNPAID_PREM_LABEL) {
		this.COMP_SMV_LC_UNPAID_PREM_LABEL = COMP_SMV_LC_UNPAID_PREM_LABEL;
	}

	public void setCOMP_SMV_LC_UNPAID_PREM(HtmlInputText COMP_SMV_LC_UNPAID_PREM) {
		this.COMP_SMV_LC_UNPAID_PREM = COMP_SMV_LC_UNPAID_PREM;
	}

	public HtmlOutputLabel getCOMP_SMV_UNPAID_PREM_YN_LABEL() {
		return COMP_SMV_UNPAID_PREM_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_SMV_UNPAID_PREM_YN() {
		return COMP_SMV_UNPAID_PREM_YN;
	}

	public void setCOMP_SMV_UNPAID_PREM_YN_LABEL(
			HtmlOutputLabel COMP_SMV_UNPAID_PREM_YN_LABEL) {
		this.COMP_SMV_UNPAID_PREM_YN_LABEL = COMP_SMV_UNPAID_PREM_YN_LABEL;
	}

	public void setCOMP_SMV_UNPAID_PREM_YN(
			HtmlSelectOneMenu COMP_SMV_UNPAID_PREM_YN) {
		this.COMP_SMV_UNPAID_PREM_YN = COMP_SMV_UNPAID_PREM_YN;
	}

	public HtmlOutputLabel getCOMP_SMV_UNPAID_PREM_INT_CODE_LABEL() {
		return COMP_SMV_UNPAID_PREM_INT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_SMV_UNPAID_PREM_INT_CODE() {
		return COMP_SMV_UNPAID_PREM_INT_CODE;
	}

	public void setCOMP_SMV_UNPAID_PREM_INT_CODE_LABEL(
			HtmlOutputLabel COMP_SMV_UNPAID_PREM_INT_CODE_LABEL) {
		this.COMP_SMV_UNPAID_PREM_INT_CODE_LABEL = COMP_SMV_UNPAID_PREM_INT_CODE_LABEL;
	}

	public void setCOMP_SMV_UNPAID_PREM_INT_CODE(
			HtmlInputText COMP_SMV_UNPAID_PREM_INT_CODE) {
		this.COMP_SMV_UNPAID_PREM_INT_CODE = COMP_SMV_UNPAID_PREM_INT_CODE;
	}

	public HtmlOutputLabel getCOMP_SMV_FC_UNPAID_PREM_INT_LABEL() {
		return COMP_SMV_FC_UNPAID_PREM_INT_LABEL;
	}

	public HtmlInputText getCOMP_SMV_FC_UNPAID_PREM_INT() {
		return COMP_SMV_FC_UNPAID_PREM_INT;
	}

	public void setCOMP_SMV_FC_UNPAID_PREM_INT_LABEL(
			HtmlOutputLabel COMP_SMV_FC_UNPAID_PREM_INT_LABEL) {
		this.COMP_SMV_FC_UNPAID_PREM_INT_LABEL = COMP_SMV_FC_UNPAID_PREM_INT_LABEL;
	}

	public void setCOMP_SMV_FC_UNPAID_PREM_INT(
			HtmlInputText COMP_SMV_FC_UNPAID_PREM_INT) {
		this.COMP_SMV_FC_UNPAID_PREM_INT = COMP_SMV_FC_UNPAID_PREM_INT;
	}

	public HtmlOutputLabel getCOMP_SMV_LC_UNPAID_PREM_INT_LABEL() {
		return COMP_SMV_LC_UNPAID_PREM_INT_LABEL;
	}

	public HtmlInputText getCOMP_SMV_LC_UNPAID_PREM_INT() {
		return COMP_SMV_LC_UNPAID_PREM_INT;
	}

	public void setCOMP_SMV_LC_UNPAID_PREM_INT_LABEL(
			HtmlOutputLabel COMP_SMV_LC_UNPAID_PREM_INT_LABEL) {
		this.COMP_SMV_LC_UNPAID_PREM_INT_LABEL = COMP_SMV_LC_UNPAID_PREM_INT_LABEL;
	}

	public void setCOMP_SMV_LC_UNPAID_PREM_INT(
			HtmlInputText COMP_SMV_LC_UNPAID_PREM_INT) {
		this.COMP_SMV_LC_UNPAID_PREM_INT = COMP_SMV_LC_UNPAID_PREM_INT;
	}

	public PT_IL_SURR_MAT_VALUES getPT_IL_SURR_MAT_VALUES_BEAN() {
		return PT_IL_SURR_MAT_VALUES_BEAN;
	}

	public void setPT_IL_SURR_MAT_VALUES_BEAN(
			PT_IL_SURR_MAT_VALUES PT_IL_SURR_MAT_VALUES_BEAN) {
		this.PT_IL_SURR_MAT_VALUES_BEAN = PT_IL_SURR_MAT_VALUES_BEAN;
	}

	public List<PT_IL_SURR_MAT_VALUES> getDataList_PT_IL_SURR_MAT_VALUES() {
		return dataList_PT_IL_SURR_MAT_VALUES;
	}

	public void setDataListPT_IL_SURR_MAT_VALUES(
			List<PT_IL_SURR_MAT_VALUES> dataList_PT_IL_SURR_MAT_VALUES) {
		this.dataList_PT_IL_SURR_MAT_VALUES = dataList_PT_IL_SURR_MAT_VALUES;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PT_IL_SURR_MAT_VALUES_BEAN = new PT_IL_SURR_MAT_VALUES();
				helper.WHEN_CREATE_RECORD(compositeAction);
				resetAllComponent();
				resetSelectedRow();
			} else {

				throw new Exception(Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insertnotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}

	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PT_IL_SURR_MAT_VALUES_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				dataList_PT_IL_SURR_MAT_VALUES
						.remove(PT_IL_SURR_MAT_VALUES_BEAN);
				if (dataList_PT_IL_SURR_MAT_VALUES.size() > 0) {

					PT_IL_SURR_MAT_VALUES_BEAN = dataList_PT_IL_SURR_MAT_VALUES
							.get(0);
				} else if (dataList_PT_IL_SURR_MAT_VALUES.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PT_IL_SURR_MAT_VALUES_BEAN.setRowSelected(true);
			} else {

				throw new Exception(Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	public void postRecord(ActionEvent event) {
		try {
			if (PT_IL_SURR_MAT_VALUES_BEAN.getROWID() == null) {

				if(isINSERT_ALLOWED()){
					new CRUDHandler().executeInsert(PT_IL_SURR_MAT_VALUES_BEAN,
							CommonUtils.getConnection());
					//helper.chkMICRCode(getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_FLEX05());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
					getWarningMap().put(
							"postRecord",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
					dataList_PT_IL_SURR_MAT_VALUES.add(PT_IL_SURR_MAT_VALUES_BEAN);
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insertnotallowed"));
				}
			} else if (PT_IL_SURR_MAT_VALUES_BEAN.getROWID() != null) {

				if(isUPDATE_ALLOWED()){
					//helper.chkMICRCode(getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_FLEX05());
					new CRUDHandler().executeUpdate(PT_IL_SURR_MAT_VALUES_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$update"));
					getWarningMap().put(
							"postRecord",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$update"));
					
				}else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$updatenotallowed"));
				}
			}

/*added by raja on 28-04-2017 for hide the save button*/
			
			CommonUtils.getConnection().commit();
			
			/*end*/
			
			
			PT_IL_SURR_MAT_VALUES_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_SURR_MAT_VALUES_BEAN = (PT_IL_SURR_MAT_VALUES) dataTable
					.getRowData();
			//added by gopi for ssp call id ZBLIFE-1465513
			if ("S".equals(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_TYPE())){
				compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN().setDTG_DS_TYPE("8");
			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().setUI_M_STATUS_CODE("Surrender");
			}
			else if ("M".equals(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_TYPE())
					/*|| "R".equals(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_TYPE())*/){
				compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN().setDTG_DS_TYPE("M");
			compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().setUI_M_STATUS_CODE("Maturity");
			}
			else if ("R".equals(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_TYPE())){
				compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN().setDTG_DS_TYPE("R");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().setUI_M_STATUS_CODE("Cashback");
			}
			else if ("P".equals(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_TYPE())){
				compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN().setDTG_DS_TYPE("P");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().setUI_M_STATUS_CODE("PaidUp");
			}
			
			
			compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getHelper().executeQuery(compositeAction);
			compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getHelper().POST_QUERY(compositeAction);
			//end
			helper.POST_QUERY(compositeAction);
			//added by gopi for ssp call id ZBLIFE-1465513
			compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getHelper().executeQuery1(compositeAction);
			//end
			PT_IL_SURR_MAT_VALUES_BEAN.setRowSelected(true);
			/*added by gopi for ssp call id ZBLIFE-1465513 on 06/01/18*/
			System.out.println("*********display record smv_sys_id*********"+PT_IL_SURR_MAT_VALUES_BEAN.getSMV_SYS_ID());
			SURRMAT_ENABLE_DISABLE(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_POL_SYS_ID(),PT_IL_SURR_MAT_VALUES_BEAN.getSMV_SYS_ID());
			//end
			//added by gopi for ssp call id ZBLIFE-1465513
			
			/*Commentted by saritha on 12-02-2018 for All records PolicyHolder(P) displaying*/
			//PT_IL_SURR_MAT_VALUES_BEAN.setSMV_PAYTO("P");
			//end
			resetAllComponent();
			
			
			
			
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	
	private void resetSelectedRow() {
		Iterator<PT_IL_SURR_MAT_VALUES> PT_IL_SURR_MAT_VALUES_ITR = dataList_PT_IL_SURR_MAT_VALUES
				.iterator();
		while (PT_IL_SURR_MAT_VALUES_ITR.hasNext()) {
			PT_IL_SURR_MAT_VALUES_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_SMV_DATE.resetValue();
		COMP_SMV_FC_RED_SA.resetValue();
		COMP_SMV_FC_ACC_PROFIT.resetValue();
		COMP_SMV_FC_GROSS_VALUE.resetValue();
		COMP_UI_M_FC_NET_PAID_AMT.resetValue();
		COMP_SMV_PAID_DT.resetValue();
		COMP_SMV_FC_NET_PAID_AMT.resetValue();
		COMP_SMV_LC_RED_SA.resetValue();
		COMP_SMV_LC_ACC_PROFIT.resetValue();
		COMP_SMV_LC_GROSS_VALUE.resetValue();
		COMP_UI_M_LC_NET_PAID_AMT.resetValue();
		COMP_SMV_LC_NET_PAID_AMT.resetValue();
		COMP_SMV_REF_NO.resetValue();
		COMP_SMV_FC_OS_LOAN.resetValue();
		COMP_SMV_LC_OS_LOAN.resetValue();
		COMP_SMV_FC_CHARGE_AMT.resetValue();
		COMP_SMV_FC_BAL_LOAN.resetValue();
		COMP_SMV_LC_BAL_LOAN.resetValue();
		COMP_SMV_LOAN_INT_YN.resetValue();
		COMP_SMV_LC_CHARGE_AMT.resetValue();
		COMP_SMV_FC_LOAN_INT.resetValue();
		COMP_SMV_LC_LOAN_INT.resetValue();
		COMP_SMV_PAYTO.resetValue();
		COMP_SMV_FC_UNPAID_PREM.resetValue();
		COMP_SMV_LC_UNPAID_PREM.resetValue();
		COMP_SMV_UNPAID_PREM_YN.resetValue();
		COMP_SMV_UNPAID_PREM_INT_CODE.resetValue();
		COMP_SMV_FC_UNPAID_PREM_INT.resetValue();
		COMP_SMV_LC_UNPAID_PREM_INT.resetValue();
		
		/*Added by Janani on 28.06.2017 for ZBILQC-1724475*/
		
		COMP_SMV_REMARKS.resetValue();
		
		/*End*/
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
		try {
			CommonUtils.getConnection().commit();
			getWarningMap().put("SAVE",Messages.getString(
					PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public List<SelectItem> getListSMV_LOAN_INT_YN() {
		return listSMV_LOAN_INT_YN;
	}

	public void setListSMV_LOAN_INT_YN(List<SelectItem> listSMV_LOAN_INT_YN) {
		this.listSMV_LOAN_INT_YN = listSMV_LOAN_INT_YN;
	}

	public List<SelectItem> getListSMV_PAYTO() {
		return listSMV_PAYTO;
	}

	public void setListSMV_PAYTO(List<SelectItem> listSMV_PAYTO) {
		this.listSMV_PAYTO = listSMV_PAYTO;
	}

	public List<SelectItem> getListSMV_UNPAID_PREM_YN() {
		return listSMV_UNPAID_PREM_YN;
	}

	public void setListSMV_UNPAID_PREM_YN(
			List<SelectItem> listSMV_UNPAID_PREM_YN) {
		this.listSMV_UNPAID_PREM_YN = listSMV_UNPAID_PREM_YN;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	
	/*Added by Janani on 15.07.2017 for ZBILQC-1724475*/
	String UI_M_FC_NET_PAID_AMT= null;
	Double UI_M_LC_NET_PAID_AMT= 0.0;
	
	
	public void M_FC_NET_PAID_AMT_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			
			
			/*Added by Janani on 28.06.2017 for ZBILQC-1724475*/
			
			System.out.println("Enters into M_FC_NET_PAID_AMT_Validator               ");
			
					
			/*if((Double.compare(PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_FC_NET_PAID_AMT().doubleValue(),Double.parseDouble(value.toString()))!=0))
			{*/
			Double number_amount=validate_asd_num_value();
			Double net_paid_amt=PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_FC_NET_PAID_AMT();
			
			Double curr_value = Double.valueOf(value.toString());
			
			System.out.println("net_paid_amt               "+net_paid_amt);
			
			
			
			/*if(number_amount!=null && net_paid_amt!=null){
			if(net_paid_amt>number_amount){
				throw new Exception("Net payable amount of "+net_paid_amt +" is greater than the ex-gratia limit  of " +number_amount +" for this User");                   
			}*/
			

			
			if((Double.compare(PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_FC_NET_PAID_AMT().doubleValue(),Double.parseDouble(value.toString()))!=0))
			{
			
			if(number_amount!=null && curr_value!=null){
			if(curr_value>number_amount){
				throw new Exception("Net payable amount of "+curr_value +" is greater than the ex-gratia limit  of " +number_amount +" for this User");                   
			}
			
			}
			}
			
			/*End*/
			
			
			//PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_FC_NET_PAID_AMT((Double) value);
			helper.M_FC_NET_PAID_AMT_WHEN_VALIDATE_ITEM(compositeAction, value);
			
			/*Modified by Janani on 28.06.2017 for ZBILQC-1724475*/
			
			System.out.println("getSMV_FC_GROSS_VALUE           "+getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_FC_GROSS_VALUE());
			System.out.println("getSMV_LC_CHARGE_AMT           "+getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_LC_CHARGE_AMT());
			
			
			/*getPT_IL_SURR_MAT_VALUES_BEAN().setUI_M_FC_NET_PAID_AMT(
					(Double) value);*/
			
			PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_FC_NET_PAID_AMT(getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_FC_GROSS_VALUE()- 
					getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_LC_CHARGE_AMT());
			
			
			System.out.println("getUI_M_FC_NET_PAID_AMT           "+PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_FC_NET_PAID_AMT());
			
			
			/*End*/
			
			UI_M_FC_NET_PAID_AMT=Double.toString(PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_FC_NET_PAID_AMT());
			PT_IL_SURR_MAT_VALUES_BEAN.setUI_FC_NET_PAID_AMT(CommonUtils.Decimal_Convert(UI_M_FC_NET_PAID_AMT));
			
			
			
			
			
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void SMV_FC_GROSS_VALUE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_GROSS_VALUE((Double) value);
			helper.SMV_FC_GROSS_VALUE_Validator_WHEN_VALIDATE_ITEM(compositeAction, value);
			String SMV_FC_GROSS_VALUE=Double.toString(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_GROSS_VALUE());
			PT_IL_SURR_MAT_VALUES_BEAN.setUI_SMV_FC_GROSS_VALUE(CommonUtils.Decimal_Convert(SMV_FC_GROSS_VALUE));
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}
	
	public void SMV_FC_ACC_PROFIT_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_ACC_PROFIT((Double) value);
			String SMV_FC_ACC_PROFIT=Double.toString(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_ACC_PROFIT());
			PT_IL_SURR_MAT_VALUES_BEAN.setUI_SMV_FC_ACC_PROFIT(CommonUtils.Decimal_Convert(SMV_FC_ACC_PROFIT));
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void M_LC_NET_PAID_AMT_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			helper.M_LC_NET_PAID_AMT_WHEN_VALIDATE_ITEM(compositeAction, value);
			getPT_IL_SURR_MAT_VALUES_BEAN().setUI_M_LC_NET_PAID_AMT(
					(Double) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	
	public void SMV_UNPAID_PREM_YN_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			String val = (String)value;
			helper.SMV_UNPAID_PREM_YN_WHEN_VALIDATE_ITEM(compositeAction,val);
			getPT_IL_SURR_MAT_VALUES_BEAN().setSMV_UNPAID_PREM_YN(val);
			COMP_SMV_FC_UNPAID_PREM_INT.resetValue();
			COMP_SMV_LC_UNPAID_PREM_INT.resetValue();
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	

	public void SMV_UNPAID_PREM_INT_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_UNPAID_PREM_INT_CODE((String)  value);
			helper.when_validate_item_smv_unpaid_prem_int_code(this);
			COMP_SMV_FC_UNPAID_PREM_INT.resetValue();
			COMP_SMV_LC_UNPAID_PREM_INT.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
 
	
	public void onLoad(PhaseEvent event) {
		try {
			helper.loadcurrency();
			/*Added  by Raja on 03.05.2017 for hands-on-feedback point*/
			disableButtons();
			/*End*/
			
			if (isBlockFlag()) {
				//added by gopi for ssp call id ZBLIFE-1465513
				getErrorMap().clear();
				getWarningMap().clear();
				//end
				/*commented by agalya for Maturity Payout on 08/07/2016,ssp call no- FALCONQC-1714914*/
				//CommonUtils.clearMaps(this);
				helper.PRE_QUERY(compositeAction);
				helper.executeQuery(compositeAction);
				//added by gopi for ssp call id ZBLIFE-1465513
				compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().setBlockFlag(true);
				compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().onLoad(null);
				//end
				/*added  by raja on 03-04-2017*/
				setNetValue();
				/*end*/
				
				/*Added by Janani on 25.07.2017 for ZBILQC-1731997*/

				/*Added by Janani on 27.07.2017 for ZBILQC-1731997*/
			/*	FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest request = (HttpServletRequest) context
						.getExternalContext().getRequest();
				HttpSession session = request.getSession();
				Double getcashback_tot_amt = (Double) session.getAttribute("getUI_POL_TOTAL");
				
				System.out.println("getcashback_tot_amt                 "+getcashback_tot_amt);*/
				
				helper.P_CASHBACK_AMT(compositeAction);
				
				/*End*/
				
				
				//compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().setCashback_amt(getcashback_tot_amt);
				
				System.out.println("getCashback_amt                "+compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN()
						.getCashback_amt());

				/*End*/
				
				
				if(compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().getROWID()!=null){
					helper.POST_QUERY(compositeAction);

				}
				helper.WHEN_NEW_RECORD_INSTANCE(compositeAction);
				
			    /*end*/
				/*Commented by Janani on 15.07.2017 for ZBILQC-1724475*/
				
				/*String UI_M_FC_NET_PAID_AMT=Double.toString(PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_FC_NET_PAID_AMT());
				PT_IL_SURR_MAT_VALUES_BEAN.setUI_FC_NET_PAID_AMT(CommonUtils.Decimal_Convert(UI_M_FC_NET_PAID_AMT));*/
				
				/*End*/
				if (!"A".equals(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_APPRV_FLAG()))
				{
				if(CommonUtils.nvl(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_INT_VALUE(),0)==0)
				{
					helper.P_VALIDATE_SMV_INT_VALUE(compositeAction);
				}
				}
				/* End */
				System.out.println("Before NetPAid Amt  : "+PT_IL_SURR_MAT_VALUES_BEAN.getUI_FC_NET_PAID_AMT());  
				
				
				/*
				 * Added by dhinesh for ZBILQC-1720021
				 * 
				 * commented by Janani on 19.07.2017 for ZBILQC-1731896
				 * 
				 * String UI_M_FC_NET_PAID_AMT=Double.toString(PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_FC_NET_PAID_AMT() +  compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_INT_VALUE());
				PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_FC_NET_PAID_AMT(Double.valueOf(CommonUtils.Decimal_Convert(UI_M_FC_NET_PAID_AMT)));
				PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_LC_NET_PAID_AMT(Double.valueOf(CommonUtils.Decimal_Convert(UI_M_FC_NET_PAID_AMT)));*/
				
			
				/*Added by Janani on 15.07.2017 for ZBILQC-1724475 & ZBILQC-1731896*/
				
				Double cash_back_interest = compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_INT_VALUE();
				
				System.out.println("cash_back_interest                      "+cash_back_interest);
				System.out.println("getSMV_FC_GROSS_VALUE in onload          "+getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_FC_GROSS_VALUE());
				System.out.println("getSMV_LC_CHARGE_AMT in onload           "+getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_LC_CHARGE_AMT());
				
				/*Commented and modified by pidug uraj dt: 18-12-2020 as suggested by Sitrarasan and Manoj for Alliance IL
				 * PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_FC_NET_PAID_AMT((getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_FC_GROSS_VALUE() + CommonUtils.nvl(cash_back_interest, 0.0))- 
						getPT_IL_SURR_MAT_VALUES_BEAN().getUI_M_TOTAL_FC_AMT() - getPT_IL_SURR_MAT_VALUES_BEAN().getCashback_amt());
				
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_NET_PAID_AMT((getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_FC_GROSS_VALUE() + CommonUtils.nvl(cash_back_interest, 0.0))- 
						getPT_IL_SURR_MAT_VALUES_BEAN().getUI_M_TOTAL_FC_AMT() - getPT_IL_SURR_MAT_VALUES_BEAN().getCashback_amt());*/
				
				
				PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_FC_NET_PAID_AMT((getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_FC_GROSS_VALUE() + CommonUtils.nvl(cash_back_interest, 0.0))- 
				getPT_IL_SURR_MAT_VALUES_BEAN().getUI_M_TOTAL_FC_AMT() - CommonUtils.nvl(getPT_IL_SURR_MAT_VALUES_BEAN().getCashback_amt(),0));
				
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_NET_PAID_AMT((getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_FC_GROSS_VALUE() + CommonUtils.nvl(cash_back_interest, 0.0))- 
				getPT_IL_SURR_MAT_VALUES_BEAN().getUI_M_TOTAL_FC_AMT() - CommonUtils.nvl(getPT_IL_SURR_MAT_VALUES_BEAN().getCashback_amt(),0));
				
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_NET_PAID_AMT((getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_LC_GROSS_VALUE() + CommonUtils.nvl(cash_back_interest, 0.0))- 
				getPT_IL_SURR_MAT_VALUES_BEAN().getUI_M_TOTAL_LC_AMT() - CommonUtils.nvl(getPT_IL_SURR_MAT_VALUES_BEAN().getCashback_amt(),0));
				/*End Commented and modified by pidug uraj dt: 18-12-2020 as suggested by Sitrarasan and Manoj for Alliance IL*/
				
				System.out.println("getUI_M_FC_NET_PAID_AMT in onload           "+PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_FC_NET_PAID_AMT());
				System.out.println("getSMV_LC_NET_PAID_AMT in onload           "+PT_IL_SURR_MAT_VALUES_BEAN.getSMV_LC_NET_PAID_AMT());
				
				//UI_M_FC_NET_PAID_AMT=Double.toString(PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_FC_NET_PAID_AMT());
				UI_M_LC_NET_PAID_AMT=PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_FC_NET_PAID_AMT();
				//PT_IL_SURR_MAT_VALUES_BEAN.setUI_FC_NET_PAID_AMT(CommonUtils.Decimal_Convert(UI_M_FC_NET_PAID_AMT));
				PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_LC_NET_PAID_AMT(UI_M_LC_NET_PAID_AMT);
				
				/*End*/
				
				
				/*Added by Janani on 27.07.2017 for ZBILQC-1731997*/
				
				//PT_IL_SURR_MAT_VALUES_BEAN.setCust_total_amt(Double.valueOf(getcust_tot_amt()));
				
				/*End*/
				//added by gopi ZBLIFE-1465513 on 04/01/18
				SURRMAT_ENABLE_DISABLE(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_POL_SYS_ID(),PT_IL_SURR_MAT_VALUES_BEAN.getSMV_SYS_ID());
				setBlockFlag(false);
				
				
				/*Added by Janani on 17.07.2017 for ZBILQC-1724475*/
				
				/*if(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_APPRV_FLAG() != null && PT_IL_SURR_MAT_VALUES_BEAN.getSMV_APPRV_FLAG().equalsIgnoreCase("a"))
				{
					disableAllComponent(true);
				}*/
				
				/*End*/
				
				/*Added by saritha on 25-07-2017 for ssp call id ZBILQC-1732436*/
				String busRuleQuery  = "SELECT BREM_ERR_FLAG FROM PT_BUS_RULE_ERROR_MSG WHERE BREM_POL_SYS_ID = ? AND BREM_APPLY_LEVEL = ? AND "
						               + "BREM_GRP_ID = 'IL' AND BREM_APL_SCREEN ='S'";
				Object[] values  = new Object[] { PT_IL_SURR_MAT_VALUES_BEAN.getSMV_POL_SYS_ID(), "T" };
				ResultSet rs1 = new CRUDHandler().executeSelectStatement(busRuleQuery, CommonUtils.getConnection(), values);
				if (rs1.next()) {

					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUS_RUL().setDisabled(false); 	 

				} else {
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUS_RUL().setDisabled(true);

				}
	            /*End*/	
				
				/*Added by saritha on 10-08-2017 for ssp call id ZBILQC-1728303*/
				
				/*Commentted by saritha on 12-02-2018 for Surrender/Maturity Payment Bank Details Issues*/
				
				/*if("OTHERS".equalsIgnoreCase(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FLEX04())){
				COMP_UI_M_BANK_CODE.setDisabled(true);
				COMP_UI_M_BRANCH_CODE.setDisabled(true);
				COMP_ACC_NO.setDisabled(true);
				Added by Ameen on 01-12-2017
				COMP_SMV_FLEX10.setDisabled(true);
				End
				}
				else{
					COMP_UI_M_BANK_CODE.setDisabled(false);
					COMP_UI_M_BRANCH_CODE.setDisabled(false);
					COMP_ACC_NO.setDisabled(false);
					Added by Ameen on 01-12-2017
					COMP_SMV_FLEX10.setDisabled(false);
					End
				}*/
				/*End*/
				
				/*Added by saritha on 09-11-2017 for Surrender/Maturity(To modify the Gross Surrender Value/Gross Maturity Value) 
			        * to be calculated Net payable amount. as per siva sir sugg*/
				
				if(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_TYPE()!=null && PT_IL_SURR_MAT_VALUES_BEAN.getSMV_TYPE().equalsIgnoreCase("S")||
						(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_TYPE()!=null && PT_IL_SURR_MAT_VALUES_BEAN.getSMV_TYPE().equalsIgnoreCase("M")))
				{
					getFlag_Check();
				}
				
				/*End*/
				/*Added by Ameen on 01-12-2017 for ZBLIFE-1458892*/
				//commented by gopi for ssp call id ZBLIFE-1465513
				/*if(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FLEX04() == null){
				    PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX04("EFT");
				}*/
				   if(PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_BANK_CODE() == null){
					 
				       /*Commentted &Modified by saritha on 12-02-2018 for Surrender Maturity Payment Bank Details Issues*/
					   
					   /*if("A".equalsIgnoreCase(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_PAYTO())){*/
						   
						   if(CommonUtils.isIN(CommonUtils.nvl(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_PAYTO(),""),"A","P") &&
								   (CommonUtils.isIN(CommonUtils.nvl(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FLEX04(),""),"EFT","OTHERS")))				
							{   
						   
					    /*End*/
						   
						COMP_UI_M_BANK_CODE.setRequired(false);
						COMP_ACC_NO.setRequired(false);
						COMP_SMV_FLEX10.setRequired(false);
						COMP_UI_M_BRANCH_CODE.setRequired(false);
						COMP_SMV_FLEX11.setDisabled(false);
						COMP_SMV_FLEX12.setDisabled(false);
						COMP_UI_M_BANK_CODE.setDisabled(false);
						COMP_ACC_NO.setDisabled(false);
						COMP_UI_M_BRANCH_CODE.setDisabled(false);
						COMP_SMV_FLEX10.setDisabled(false);
						//commented by gopi for ssp call id ZBLIFE-1465513
						/*String query = "SELECT CBAD_CUST_BANK_CODE, CBAD_BANK_NAME, CBAD_ACNT_NAME, CBAD_ACNT_NO, CBAD_DIVISION, "
								+ "(CUST_TEL_AREA_CODE2 || '-' || CUST_PHONE2) CUST_MOBILE, BANK_NAME,CUST_CODE,POAD_POL_SYS_ID "
								+ "FROM PM_CUST_BANK_ACNT_DTLS,PM_CUSTOMER,FM_BANK,PT_IL_POL_ASSURED_DTLS WHERE CUST_CODE = "
								+ "CBAD_CUST_CODE AND NVL(CBAD_PREF_ACNT_YN, 'N') = 'Y' AND BANK_CODE = CBAD_CUST_BANK_CODE "
								+ "AND POAD_ASSR_CODE = CBAD_CUST_CODE AND POAD_POL_SYS_ID IN (SELECT POL_SYS_ID FROM "
								+ "PT_IL_POLICY WHERE POL_NO = ?)";
						ResultSet rs = null;
						rs = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(),
									new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO()});
						if(rs.next()){
								PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BANK_CODE(rs.getString("CBAD_CUST_BANK_CODE"));
								PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BANK_NAME(rs.getString("BANK_NAME"));
								PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BRANCH_CODE(rs.getString("CBAD_DIVISION"));
								if(PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_BRANCH_CODE()!=null){
									String sortCodeQry = "SELECT BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH where BR_BANK_CODE = ? AND BR_BANK_SORT_CODE = ?";
									ResultSet sortCodeRS = null;
									sortCodeRS = new CRUDHandler().executeSelectStatement
											(sortCodeQry, CommonUtils.getConnection(),new Object[]{PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_BANK_CODE(),PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_BRANCH_CODE()});
									if(sortCodeRS.next()){
									PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_DIVN_CODE(sortCodeRS.getString("BR_BANK_BRANCH_CODE"));
									}
								}
								PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX06(rs.getString("CBAD_ACNT_NO"));
							    PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX10(rs.getString("CBAD_ACNT_NAME"));
								PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX11(rs.getString("CUST_MOBILE"));
								
						}*/
						//end
					}else{
						COMP_UI_M_BANK_CODE.setRequired(false);
						COMP_UI_M_BRANCH_CODE.setRequired(false);
						COMP_ACC_NO.setRequired(false);
						COMP_SMV_FLEX10.setRequired(false);
						COMP_SMV_FLEX11.setDisabled(false);
						COMP_SMV_FLEX12.setDisabled(false);
						COMP_UI_M_BANK_CODE.setDisabled(true);
						COMP_ACC_NO.setDisabled(true);
						COMP_UI_M_BRANCH_CODE.setDisabled(true);
						COMP_SMV_FLEX10.setDisabled(true);
						//commented by gopi for ssp call id ZBLIFE-1465513
						/*String query = "SELECT CBAD_CUST_BANK_CODE,CBAD_BANK_NAME,CBAD_ACNT_NAME,CBAD_ACNT_NO,CBAD_DIVISION,"
								+ "(CUST_TEL_AREA_CODE2||'-'||CUST_PHONE2) CUST_MOBILE,BANK_NAME FROM PM_CUST_BANK_ACNT_DTLS,"
								+ "PM_CUSTOMER,FM_BANK,PT_IL_POLICY WHERE CUST_CODE = CBAD_CUST_CODE AND NVL(CBAD_PREF_ACNT_YN,'N') = 'Y' "
								+ "AND CBAD_CUST_CODE = POL_CUST_CODE AND BANK_CODE = CBAD_CUST_BANK_CODE AND POL_NO = ?";
						ResultSet rs = null;
						rs = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(),
									new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO()});
						if(rs.next()){
								PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BANK_CODE(rs.getString("CBAD_CUST_BANK_CODE"));
							    PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BANK_NAME(rs.getString("BANK_NAME"));
							    PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BRANCH_CODE(rs.getString("CBAD_DIVISION"));
								if(PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_BRANCH_CODE()!=null){
									String sortCodeQry = "SELECT BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH where BR_BANK_CODE = ? AND BR_BANK_SORT_CODE = ?";
									ResultSet sortCodeRS = null;
									sortCodeRS = new CRUDHandler().executeSelectStatement
											(sortCodeQry, CommonUtils.getConnection(),new Object[]{PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_BANK_CODE(),PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_BRANCH_CODE()});
									if(sortCodeRS.next()){
										PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_DIVN_CODE(sortCodeRS.getString("BR_BANK_BRANCH_CODE"));
									}
								}
								PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX06(rs.getString("CBAD_ACNT_NO"));
							    PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX10(rs.getString("CBAD_ACNT_NAME"));
							    PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX11(rs.getString("CUST_MOBILE"));
								
						}
					*/
					//end	
					}
					}
					/*End*/
				   
				   /*New field added by saritha on 14-02-2018 for Surrender/Maturity Payment Bank Details Issues as per thiag sir sugg.*/
				   if("CHK".equalsIgnoreCase(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FLEX04())){
					   COMP_SMV_PAYEE_NAME.setDisabled(false);
					   COMP_SMV_PAYEE_NAME.resetValue();
					}else{
						COMP_SMV_PAYEE_NAME.setDisabled(true);
						COMP_SMV_PAYEE_NAME.resetValue();
					}
				   
				   /*End*/
				   
			}
			/*commented by agalya for Maturity Payout on 08/07/2016,ssp call no- FALCONQC-1714914*/
			//if(("A".equalsIgnoreCase(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_APPRV_FLAG()))||("R".equalsIgnoreCase(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_APPRV_FLAG()))){
			 /*	 COMMENTED below code on 28.2.2017 by DHIENSH
				CompositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_APPROVE().setDisabled(true);
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_RESERVE().setDisabled(true);
			  	*/
			
			
			/*changed  by raja on 03-04-2017*/
			  //disableButtons();
			  /*end*/

			  
			//}
			//added by gopi for ssp call id ZBLIFE-1465513
			PT_IL_SURR_MAT_VALUES_BEAN.setCust_total_amt(Double.valueOf(getcust_tot_amt()));
			/*Added by Janani on 17.07.2017 for ZBILQC-1724475*/
			//modified BY GOPI ZBLIFE-1465513 ON 04/01/18
			if(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_APPRV_FLAG() != null && PT_IL_SURR_MAT_VALUES_BEAN.getSMV_APPRV_FLAG().equalsIgnoreCase("a"))
			{
				disableAllComponent(true);
				if(compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().
						getSMV_TYPE() != null && compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().
						getSMV_TYPE().equalsIgnoreCase("R")){
					
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().disableAllComponent(true);
				}
			}else {
				if(compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().
						getSMV_TYPE() != null && compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().
						getSMV_TYPE().equalsIgnoreCase("R")){
					
					disableAllComponent(false);
					disableAllComponent_Cash_back(true);
					if ((compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getPT_IL_SURR_MAT_VALUES_BEAN()
							.getSMV_RESERVE_FLAG() != null && compositeAction
							.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
							.getPT_IL_SURR_MAT_VALUES_BEAN()
							.getSMV_RESERVE_FLAG().equalsIgnoreCase("Y"))
							) {
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_UI_M_BUT_RESERVE().setDisabled(true);
					}else{
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_UI_M_BUT_RESERVE().setDisabled(false);

						
					}
				}
				//end
			}
			
			/*End*/
			if(compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().
					getSMV_TYPE() != null && compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().
					getSMV_TYPE().equalsIgnoreCase("R")){
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().setUI_M_STATUS_CODE("Cashback");
			}else if(compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().
					getSMV_TYPE() != null && compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().
					getSMV_TYPE().equalsIgnoreCase("S")){
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().setUI_M_STATUS_CODE("Surrender");
			}else if(compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().
					getSMV_TYPE() != null && compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().
					getSMV_TYPE().equalsIgnoreCase("M")){
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().setUI_M_STATUS_CODE("Maturity");
			}else if(compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().
					getSMV_TYPE() != null && compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().
					getSMV_TYPE().equalsIgnoreCase("P")){
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().setUI_M_STATUS_CODE("PaidUp");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	private void prepareListItemValues(){
		Connection connection = null;
		
		try {
			connection = CommonUtils.getConnection();
			listSMV_LOAN_INT_YN = ListItemUtil.getDropDownListValue_1(connection, 
					"PILT013", "PT_IL_SURR_MAT_VALUES", "PT_IL_SURR_MAT_VALUES.SMV_LOAN_INT_YN", null);
			listSMV_PAYTO = ListItemUtil.getDropDownListValue_1(connection, 
					"PILT013", "PT_IL_SURR_MAT_VALUES", "PT_IL_SURR_MAT_VALUES.SMV_PAYTO", null);
			listSMV_UNPAID_PREM_YN = ListItemUtil.getDropDownListValue_1(connection, 
					"PILT013", "PT_IL_SURR_MAT_VALUES", "PT_IL_SURR_MAT_VALUES.SMV_UNPAID_PREM_YN", null);

		} catch (DBException e) {
			
			e.printStackTrace();
		}
		
	}
	
//	------------------------------Newly added below code on 28.2.2017 by DHIENSH ----START------------------------------	
	
	public void disableButtons(){
		  if("P".equalsIgnoreCase(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_APPRV_FLAG())){
			  
			 // compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_RESERVE().setDisabled(true);
			  compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_APPROVE().setDisabled(false);
		  }
		  
		  
		  if("Y".equalsIgnoreCase(CommonUtils.nvl(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_RESERVE_FLAG(),"N"))){
			  compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_APPROVE().setDisabled(false);
			  compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_RESERVE().setDisabled(true);
		  }
		  else
		  {
			  //compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_APPROVE().setDisabled(true);
		  }
			  
		  if(("A".equalsIgnoreCase(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_APPRV_FLAG()))||("R".equalsIgnoreCase(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_APPRV_FLAG()))){
			  compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_APPROVE().setDisabled(true);
			  compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_RESERVE().setDisabled(true);
			  compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_UI_M_STATUS().setDisabled(true);
		  }
		  
		  
		  /*added  by raja on 03-05-2017*/
		 // compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_UI_M_BUT_BONUS().setRendered(false);
		  compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_UI_M_BUT_BONUS().setRendered(true);

			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_UI_M_BUT_RESERVE().setRendered(false);
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_UI_M_BUT_REP_POLICY().setRendered(false);
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_M_BUT_INT_TRANSFER().setRendered(false);
		  if(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_TYPE()!=null && PT_IL_SURR_MAT_VALUES_BEAN.getSMV_TYPE().equalsIgnoreCase("S"))
		  {
			  compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_APPROVE().setDisabled(false);
		  }
		  else if(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_TYPE()!=null && PT_IL_SURR_MAT_VALUES_BEAN.getSMV_TYPE().equalsIgnoreCase("M"))
		  {
			 // compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_UI_M_BUT_RESERVE().setRendered(true);
			  compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_UI_M_BUT_RESERVE().setRendered(false);

		  }
		  /*Added by Janani for FActory testing feedback point on 24.05.2017*/ 
		  else if(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_TYPE()!=null && PT_IL_SURR_MAT_VALUES_BEAN.getSMV_TYPE().equalsIgnoreCase("R"))
		  {
			//  compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_UI_M_BUT_RESERVE().setRendered(true);
			//  compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_M_BUT_INT_TRANSFER().setRendered(true);
			  compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_UI_M_BUT_RESERVE().setRendered(false);
			  compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_M_BUT_INT_TRANSFER().setRendered(false);
			  
		  }
		  
		  /*End*/
		  /*end*/
		  
		  if(!"A".equalsIgnoreCase(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_APPRV_FLAG()))
		  {
			  compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_REJECT().setDisabled(false);
		  }else
		  {
			  compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_REJECT().setDisabled(true);
		  }

		  
		  
	}
	

	public HtmlOutputLabel getCOMP_FTR_SMV_LC_RED_SA_LABEL() {
		return COMP_FTR_SMV_LC_RED_SA_LABEL;
	}

	public void setCOMP_FTR_SMV_LC_RED_SA_LABEL(
			HtmlOutputLabel comp_ftr_smv_lc_red_sa_label) {
		COMP_FTR_SMV_LC_RED_SA_LABEL = comp_ftr_smv_lc_red_sa_label;
	}

	public HtmlInputText getCOMP_FTR_SMV_LC_RED_SA() {
		return COMP_FTR_SMV_LC_RED_SA;
	}

	public void setCOMP_FTR_SMV_LC_RED_SA(HtmlInputText comp_ftr_smv_lc_red_sa) {
		COMP_FTR_SMV_LC_RED_SA = comp_ftr_smv_lc_red_sa;
	}

	public HtmlOutputText getCOMP_UI_B_SMV_FLAG() {
		return COMP_UI_B_SMV_FLAG;
	}

	public void setCOMP_UI_B_SMV_FLAG(HtmlOutputText comp_ui_b_smv_flag) {
		COMP_UI_B_SMV_FLAG = comp_ui_b_smv_flag;
	}

	public HtmlOutputText getCOMP_UI_B_SMV_FLAG1() {
		return COMP_UI_B_SMV_FLAG1;
	}

	public void setCOMP_UI_B_SMV_FLAG1(HtmlOutputText comp_ui_b_smv_flag1) {
		COMP_UI_B_SMV_FLAG1 = comp_ui_b_smv_flag1;
	}

	
	public List<LovBean> lovSMV_UNPAID_PREM_INT_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			System.out.println("Lov is Working");
			suggestionList = listitemutil.P_CALL_LOV("PILT013",
					"PT_IL_SURR_MAT_VALUES", "SMV_UNPAID_PREM_INT_CODE",
					"IL_PRM_INT", null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	/*Commentted by saritha on 10-08-2017 for ssp call id ZBILQC-1728303*/
	/*public void validateSMV_FLEX04(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		//CommonUtils.clearMaps(this);
		try {
			
			getPT_IL_SURR_MAT_VALUES_BEAN().setSMV_FLEX04((String)value);
			
			
				Modified by saritha on 09-08-2017 for ssp call id ZBILQC-1728303
				if("EFT".equalsIgnoreCase(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FLEX04())){
				if(("EFT".equalsIgnoreCase(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FLEX04()))||("CHK".equalsIgnoreCase(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FLEX04()))){
				End	
				
				this.getCOMP_ACC_NO().setRequired(true);
				//this.getCOMP_MICR_CODE().setRequired(true);
				
				added by raja on 03-05-2017
				String policyquery="select POL_CONT_CODE from pt_il_policy where pol_no=?";
				ResultSet resultset=new CRUDHandler().executeSelectStatement(policyquery, CommonUtils.getConnection(), 
						new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO()});
						String Custcode=null;
						while(resultset.next())
						{
							Custcode=resultset.getString("POL_CONT_CODE");
						}
				String Bankquery="SELECT CBAD_BANK_CODE,CBAD_BANK_NAME,CBAD_ACNT_NO,CBAD_DIVISION FROM PM_CUST_BANK_ACNT_DTLS WHERE CBAD_CUST_CODE=?";
				ResultSet resultsetbank=new CRUDHandler().executeSelectStatement(
						Bankquery, CommonUtils.getConnection(), new Object[]{Custcode});
				while(resultsetbank.next())
				{
					PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BANK_CODE(resultsetbank.getString("CBAD_BANK_CODE"));
					PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BANK_NAME(resultsetbank.getString("CBAD_BANK_NAME"));
					PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX06(resultsetbank.getString("CBAD_ACNT_NO"));
					PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BRANCH_CODE(resultsetbank.getString("CBAD_DIVISION"));
				}
				end
				
				
			}else{
				this.getCOMP_ACC_NO().setRequired(false);
				this.getCOMP_MICR_CODE().setRequired(false);
				Added by saritha on 09-08-2017 for ssp call id ZBILQC-1728303
				COMP_UI_M_BANK_CODE.setDisabled(true);
				COMP_UI_M_BRANCH_CODE.setDisabled(true);
				COMP_ACC_NO.setDisabled(true);
				End
				
				added by raja on 03-05-2017
				PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BANK_CODE(null);
				PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BANK_NAME(null);
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX06(null);
				PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BRANCH_CODE(null);
				end
				
			}
			//COMP_TYPE.resetValue();
			COMP_MICR_CODE.resetValue();
			COMP_ACC_NO.resetValue();
			
			added by raja on 03-05-2017
			COMP_UI_M_BANK_CODE.resetValue();
			COMP_UI_M_BANK_NAME.resetValue();
			COMP_UI_M_BRANCH_CODE.resetValue();
			end
			
			
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
	}*/
	
	/*Added by saritha on 10-08-2017 for ssp call id ZBILQC-1730887*/
	public void actionListenerSMV_FLEX04(ActionEvent event) {
		getErrorMap().clear();
		getWarningMap().clear();
		try {	
			UIInput input = (UIInput) event.getComponent().getParent();
			String inputvalue= (String)input.getSubmittedValue();
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX04((String) inputvalue);
			System.out.println("inputvalue------"+inputvalue);
			
			/*Commentted &Modified by saritha on 12-02-2018 for Surrender Maturity Payment Bank Details Issues*/
			
			/*if(("EFT".equalsIgnoreCase(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FLEX04()))||("CHK".equalsIgnoreCase(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FLEX04()))){*/	
			if(("EFT".equalsIgnoreCase(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FLEX04()))||("OTHERS".equalsIgnoreCase(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FLEX04()))){
			/*End*/
				
			this.getCOMP_ACC_NO().setRequired(true);
			
			String policyquery="select POL_CONT_CODE from pt_il_policy where pol_no=?";
			ResultSet resultset=new CRUDHandler().executeSelectStatement(policyquery, CommonUtils.getConnection(), 
					new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO()});
					String Custcode=null;
					while(resultset.next())
					{
						Custcode=resultset.getString("POL_CONT_CODE");
					}
			//String Bankquery="SELECT CBAD_BANK_CODE,CBAD_BANK_NAME,CBAD_ACNT_NO,CBAD_DIVISION FROM PM_CUST_BANK_ACNT_DTLS WHERE CBAD_CUST_CODE=?";
			/*
			 * modified by Ameen on 08-12-2017 for ZBLIFE-1458892
			 * String Bankquery="SELECT CBAD_CUST_BANK_CODE,BANK_NAME, CBAD_ACNT_NO, CBAD_DIVISION FROM PM_CUST_BANK_ACNT_DTLS,FM_BANK WHERE "
					+ "BANK_CODE = CBAD_CUST_BANK_CODE AND CBAD_CUST_CODE = ?";*/
					
			String Bankquery="SELECT CBAD_CUST_BANK_CODE,BANK_NAME, CBAD_ACNT_NO, CBAD_DIVISION,CBAD_ACNT_NAME FROM PM_CUST_BANK_ACNT_DTLS,FM_BANK WHERE "
					+ "BANK_CODE = CBAD_CUST_BANK_CODE AND CBAD_CUST_CODE = ?";
			ResultSet resultsetbank=new CRUDHandler().executeSelectStatement(
					Bankquery, CommonUtils.getConnection(), new Object[]{Custcode});
			while(resultsetbank.next())
			{
				/*
				 * modified by Ameen on 19-09-2017 to get the bank code from the cust. master bank code field
				 * PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BANK_CODE(resultsetbank.getString("CBAD_BANK_CODE"));
				PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BANK_NAME(resultsetbank.getString("CBAD_BANK_NAME"));*/
				PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BANK_CODE(resultsetbank.getString("CBAD_CUST_BANK_CODE"));
				PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BANK_NAME(resultsetbank.getString("BANK_NAME"));
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX06(resultsetbank.getString("CBAD_ACNT_NO"));
				PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BRANCH_CODE(resultsetbank.getString("CBAD_DIVISION"));
				/*Added by Ameen on 08-12-2017 for ZBLIFE-1458892 */
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX10(resultsetbank.getString("CBAD_ACNT_NAME"));
				/*End*/
			}
			//added by gopi for ssp call id ZBLIFE-1465513
			if(PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_BRANCH_CODE()!=null){
				String sortCodeQry = "SELECT BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH where BR_BANK_CODE = ? AND BR_BANK_SORT_CODE = ?";
				ResultSet sortCodeRS = null;
				sortCodeRS = new CRUDHandler().executeSelectStatement
						(sortCodeQry, CommonUtils.getConnection(),new Object[]{PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_BANK_CODE(),PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_BRANCH_CODE()});
				if(sortCodeRS.next()){
					PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_DIVN_CODE(sortCodeRS.getString("BR_BANK_BRANCH_CODE"));
				}
			}
			//end
			COMP_UI_M_BANK_CODE.setDisabled(false);
			COMP_UI_M_BRANCH_CODE.setDisabled(false);
			COMP_ACC_NO.setDisabled(false);
			/*Added by Ameen on 01-12-2017 ZBLIFE-1458892*/
			COMP_SMV_FLEX10.setDisabled(false);
			/*End*/
		}else{
			this.getCOMP_ACC_NO().setRequired(false);
			this.getCOMP_MICR_CODE().setRequired(false);
			COMP_UI_M_BANK_CODE.setDisabled(true);
			COMP_UI_M_BRANCH_CODE.setDisabled(true);
			COMP_ACC_NO.setDisabled(true);
			/*Added by Ameen on 01-12-2017*/
			COMP_SMV_FLEX10.setDisabled(true);
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX10(null);
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX11(null);
			/*End*/
			
			PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BANK_CODE(null);
			PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BANK_NAME(null);
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX06(null);
			PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BRANCH_CODE(null);
			//added by gopi for ssp call id ZBLIFE-1465513
			PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_DIVN_CODE(null);
			//end
		}
			
			/*New field added by saritha on 14-02-2018 for Surrender/Maturity Payment Bank Details Issues as per thiag sir sugg.*/

			if("CHK".equalsIgnoreCase(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FLEX04())){
				COMP_SMV_PAYEE_NAME.setDisabled(false);

			}else{
				COMP_SMV_PAYEE_NAME.setDisabled(true);
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_PAYEE_NAME(null);

			}

			/*End*/
			
		COMP_MICR_CODE.resetValue();
		COMP_ACC_NO.resetValue();
		
		COMP_UI_M_BANK_CODE.resetValue();
		COMP_UI_M_BANK_NAME.resetValue();
		COMP_UI_M_BRANCH_CODE.resetValue();
		COMP_SMV_FLEX10.resetValue();
		//added by gopi for ssp call id ZBLIFE-1465513
		COMP_UI_M_DIVN_CODE.resetValue();
		COMP_SMV_PAYEE_NAME.resetValue();
		
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
/*End*/	
	
	public void validateSMV_FLEX05(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		//CommonUtils.clearMaps(this);
		try {
			/*helper.POL_OCC_RATE_WHEN_VALIDATE_ITEM(compositeAction,
					(Double) value);
			PT_IL_POLICY_BEAN.setPOL_OCC_RATE((Double) value);*/
			String value_1=(String)value;
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX05((String)value);
			helper.chkMICRCode(value_1);
			
			//COMP_MICR_CODE.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}
	
	public void validateSMV_FLEX06(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		//CommonUtils.clearMaps(this);
		try {
			
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX06((String)value);
			
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

	
	
	
	/*added by raja on 03-05-2017*/
	private HtmlOutputLabel COMP_UI_M_BANK_CODE_LABEL;
	private HtmlInputText COMP_UI_M_BANK_CODE;

	private HtmlOutputLabel COMP_UI_M_BRANCH_CODE_LABEL;
	private HtmlInputText COMP_UI_M_BRANCH_CODE;

	private HtmlOutputLabel COMP_UI_M_TOTAL_FC_AMT_LABEL;
	private HtmlInputText COMP_UI_M_TOTAL_FC_AMT;

	private HtmlOutputLabel COMP_UI_M_TOTAL_LC_AMT_LABEL;
	private HtmlInputText COMP_UI_M_TOTAL_LC_AMT;
	
	private HtmlInputText COMP_UI_M_BANK_NAME;
	
	

	public HtmlInputText getCOMP_UI_M_BANK_NAME() {
		return COMP_UI_M_BANK_NAME;
	}
	public void setCOMP_UI_M_BANK_NAME(HtmlInputText cOMP_UI_M_BANK_NAME) {
		COMP_UI_M_BANK_NAME = cOMP_UI_M_BANK_NAME;
	}
	public HtmlOutputLabel getCOMP_UI_M_BANK_CODE_LABEL() {
		return COMP_UI_M_BANK_CODE_LABEL;
	}
	public void setCOMP_UI_M_BANK_CODE_LABEL(
			HtmlOutputLabel cOMP_UI_M_BANK_CODE_LABEL) {
		COMP_UI_M_BANK_CODE_LABEL = cOMP_UI_M_BANK_CODE_LABEL;
	}
	public HtmlInputText getCOMP_UI_M_BANK_CODE() {
		return COMP_UI_M_BANK_CODE;
	}
	public void setCOMP_UI_M_BANK_CODE(HtmlInputText cOMP_UI_M_BANK_CODE) {
		COMP_UI_M_BANK_CODE = cOMP_UI_M_BANK_CODE;
	}
	public HtmlOutputLabel getCOMP_UI_M_BRANCH_CODE_LABEL() {
		return COMP_UI_M_BRANCH_CODE_LABEL;
	}
	public void setCOMP_UI_M_BRANCH_CODE_LABEL(
			HtmlOutputLabel cOMP_UI_M_BRANCH_CODE_LABEL) {
		COMP_UI_M_BRANCH_CODE_LABEL = cOMP_UI_M_BRANCH_CODE_LABEL;
	}
	public HtmlInputText getCOMP_UI_M_BRANCH_CODE() {
		return COMP_UI_M_BRANCH_CODE;
	}
	public void setCOMP_UI_M_BRANCH_CODE(HtmlInputText cOMP_UI_M_BRANCH_CODE) {
		COMP_UI_M_BRANCH_CODE = cOMP_UI_M_BRANCH_CODE;
	}
	public HtmlOutputLabel getCOMP_UI_M_TOTAL_FC_AMT_LABEL() {
		return COMP_UI_M_TOTAL_FC_AMT_LABEL;
	}
	public void setCOMP_UI_M_TOTAL_FC_AMT_LABEL(
			HtmlOutputLabel cOMP_UI_M_TOTAL_FC_AMT_LABEL) {
		COMP_UI_M_TOTAL_FC_AMT_LABEL = cOMP_UI_M_TOTAL_FC_AMT_LABEL;
	}
	public HtmlInputText getCOMP_UI_M_TOTAL_FC_AMT() {
		return COMP_UI_M_TOTAL_FC_AMT;
	}
	public void setCOMP_UI_M_TOTAL_FC_AMT(HtmlInputText cOMP_UI_M_TOTAL_FC_AMT) {
		COMP_UI_M_TOTAL_FC_AMT = cOMP_UI_M_TOTAL_FC_AMT;
	}
	public HtmlOutputLabel getCOMP_UI_M_TOTAL_LC_AMT_LABEL() {
		return COMP_UI_M_TOTAL_LC_AMT_LABEL;
	}
	public void setCOMP_UI_M_TOTAL_LC_AMT_LABEL(
			HtmlOutputLabel cOMP_UI_M_TOTAL_LC_AMT_LABEL) {
		COMP_UI_M_TOTAL_LC_AMT_LABEL = cOMP_UI_M_TOTAL_LC_AMT_LABEL;
	}
	public HtmlInputText getCOMP_UI_M_TOTAL_LC_AMT() {
		return COMP_UI_M_TOTAL_LC_AMT;
	}
	public void setCOMP_UI_M_TOTAL_LC_AMT(HtmlInputText cOMP_UI_M_TOTAL_LC_AMT) {
		COMP_UI_M_TOTAL_LC_AMT = cOMP_UI_M_TOTAL_LC_AMT;
	}
	
	public void setNetValue()
	{
		PT_IL_SURR_MAT_VALUES_BEAN
		.setUI_M_TOTAL_FC_AMT(CommonUtils.nvl(
				PT_IL_SURR_MAT_VALUES_BEAN
						.getSMV_FC_CHARGE_AMT(), 0)
				+ CommonUtils
						.nvl(PT_IL_SURR_MAT_VALUES_BEAN
								.getSMV_FC_OS_LOAN(), 0)
				+ CommonUtils
						.nvl(
								PT_IL_SURR_MAT_VALUES_BEAN
										.getSMV_FC_BAL_LOAN(),
								0)
				+ CommonUtils.nvl(
						PT_IL_SURR_MAT_VALUES_BEAN
								.getSMV_FC_UNPAID_PREM(), 0));
		PT_IL_SURR_MAT_VALUES_BEAN
		.setUI_M_TOTAL_LC_AMT(CommonUtils.nvl(
				PT_IL_SURR_MAT_VALUES_BEAN
						.getSMV_LC_CHARGE_AMT(), 0)
				+ CommonUtils
						.nvl(PT_IL_SURR_MAT_VALUES_BEAN
								.getSMV_LC_OS_LOAN(), 0)
				+ CommonUtils
						.nvl(
								PT_IL_SURR_MAT_VALUES_BEAN
										.getSMV_LC_BAL_LOAN(),
								0)
				+ CommonUtils.nvl(
						PT_IL_SURR_MAT_VALUES_BEAN
								.getSMV_LC_UNPAID_PREM(), 0));
		
		
	}
	/*end*/
	

	private HtmlOutputText COMP_SMV_DATE_TEXT;
	private HtmlOutputText COMP_SMV_PAID_DT_TEXT;
	private HtmlOutputText COMP_SMV_FC_GROSS_VALUE_TEXT;
	
	private HtmlOutputText COMP_UI_M_STATUS_CODE;

	public HtmlOutputText getCOMP_UI_M_STATUS_CODE() {
		return COMP_UI_M_STATUS_CODE;
	}
	public void setCOMP_UI_M_STATUS_CODE(HtmlOutputText cOMP_UI_M_STATUS_CODE) {
		COMP_UI_M_STATUS_CODE = cOMP_UI_M_STATUS_CODE;
	}
	public HtmlOutputText getCOMP_SMV_DATE_TEXT() {
		return COMP_SMV_DATE_TEXT;
	}
	public void setCOMP_SMV_DATE_TEXT(HtmlOutputText cOMP_SMV_DATE_TEXT) {
		COMP_SMV_DATE_TEXT = cOMP_SMV_DATE_TEXT;
	}
	public HtmlOutputText getCOMP_SMV_PAID_DT_TEXT() {
		return COMP_SMV_PAID_DT_TEXT;
	}
	public void setCOMP_SMV_PAID_DT_TEXT(HtmlOutputText cOMP_SMV_PAID_DT_TEXT) {
		COMP_SMV_PAID_DT_TEXT = cOMP_SMV_PAID_DT_TEXT;
	}
	public HtmlOutputText getCOMP_SMV_FC_GROSS_VALUE_TEXT() {
		return COMP_SMV_FC_GROSS_VALUE_TEXT;
	}
	public void setCOMP_SMV_FC_GROSS_VALUE_TEXT(
			HtmlOutputText cOMP_SMV_FC_GROSS_VALUE_TEXT) {
		COMP_SMV_FC_GROSS_VALUE_TEXT = cOMP_SMV_FC_GROSS_VALUE_TEXT;
	}
	
	
	
	/*Added by Janani on 28.06.2017 for ZBILQC-1724475*/
	
	
	private HtmlInputTextarea COMP_SMV_REMARKS;
	
	private HtmlOutputLabel COMP_SMV_REMARKS_LABEL;
	
	public HtmlInputTextarea getCOMP_SMV_REMARKS() {
		return COMP_SMV_REMARKS;
	}
	public void setCOMP_SMV_REMARKS(HtmlInputTextarea cOMP_SMV_REMARKS) {
		COMP_SMV_REMARKS = cOMP_SMV_REMARKS;
	}
	
	
	public HtmlOutputLabel getCOMP_SMV_REMARKS_LABEL() {
		return COMP_SMV_REMARKS_LABEL;
	}
	public void setCOMP_SMV_REMARKS_LABEL(HtmlOutputLabel cOMP_SMV_REMARKS_LABEL) {
		COMP_SMV_REMARKS_LABEL = cOMP_SMV_REMARKS_LABEL;
	}
	public Double validate_asd_num_value()
				throws Exception {
		  System.out.println("*******enter into validate_asd_num_value***");
		
			String C1 ="SELECT ASD_NUM_VALUE FROM PM_IL_APPR_SETUP_DET WHERE ASD_CODE = 'CLM_EXGR_AMT' AND ASD_USER_ID =? "
					+ "AND ? BETWEEN NVL(ASD_FM_PROD_CODE,'0') AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz')";
			ResultSet C1_REC = null;
			Double num_value=null;
			try {
				Connection connection = CommonUtils.getConnection();
				CRUDHandler handler = new CRUDHandler();
				String productCode=getprod_code();
				C1_REC = handler.executeSelectStatement(C1, connection,
						new Object[] {CommonUtils.getControlBean().getUSER_ID(),productCode});
				if (C1_REC.next()) {
					num_value =C1_REC.getDouble(1);
				}
				} 
			catch (SQLException e) {
				throw new Exception(e.getMessage());
			} 
			System.out.println("**************value of num_value***"+num_value);
			return num_value;
			
		}
	 
	 
	 
	 public String getprod_code()
				throws Exception {
		  System.out.println("*******enter into getprod_code***");
		
			String C1 ="select pol_prod_code from pt_il_policy where pol_no=?";
			ResultSet C1_REC = null;
			String product_code=null;
			try {
				Connection connection = CommonUtils.getConnection();
				CRUDHandler handler = new CRUDHandler();
				C1_REC = handler.executeSelectStatement(C1, connection,
						new Object[] {compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO()});
				if (C1_REC.next()) {
					product_code =C1_REC.getString(1);
				}
				} catch (SQLException e) {
				throw new Exception(e.getMessage());
			} 
			System.out.println("**************value of product_code***"+product_code);
			return product_code;
			
		}
	 
	 
	 
	 public void validatorSMV_Remarks(FacesContext context,
				UIComponent component, Object value) {
			try {
				System.out.println("*************enter into validatorSMV_Remarks***");
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_REMARKS((String) value);
				System.out.println("*************value of SMV_REMARKS***"+PT_IL_SURR_MAT_VALUES_BEAN.getSMV_REMARKS());
				//COMP_SMV_REMARKS.resetValue();
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	 
	 
	 private void initializeAllComponent() {
			COMP_SMV_DATE = new HtmlCalendar();
			COMP_SMV_FC_RED_SA = new HtmlInputText();
			COMP_SMV_FC_ACC_PROFIT = new HtmlInputText();
			COMP_SMV_FC_GROSS_VALUE = new HtmlInputText();
			COMP_UI_M_FC_NET_PAID_AMT= new HtmlInputText();
			COMP_SMV_PAID_DT = new HtmlCalendar();
			COMP_SMV_FC_NET_PAID_AMT = new HtmlInputText();
			COMP_SMV_LC_RED_SA = new HtmlInputText();
			COMP_SMV_LC_ACC_PROFIT = new HtmlInputText();
			COMP_SMV_LC_GROSS_VALUE = new HtmlInputText();
			COMP_UI_M_LC_NET_PAID_AMT = new HtmlInputText();
			COMP_SMV_LC_NET_PAID_AMT = new HtmlInputText();
			COMP_SMV_REF_NO = new HtmlInputText();
			COMP_SMV_FC_OS_LOAN = new HtmlInputText();
			COMP_SMV_LC_OS_LOAN = new HtmlInputText();
			COMP_SMV_FC_CHARGE_AMT = new HtmlInputText();
			COMP_SMV_FC_BAL_LOAN = new HtmlInputText();
			COMP_SMV_LC_BAL_LOAN = new HtmlInputText();
			COMP_SMV_LOAN_INT_YN = new HtmlSelectOneMenu();
			COMP_SMV_LC_CHARGE_AMT = new HtmlInputText();
			COMP_SMV_FC_LOAN_INT = new HtmlInputText();
			COMP_SMV_LC_LOAN_INT = new HtmlInputText();
			COMP_SMV_PAYTO = new HtmlSelectOneMenu();
			COMP_SMV_FC_UNPAID_PREM = new HtmlInputText();
			COMP_SMV_LC_UNPAID_PREM = new HtmlInputText();
			COMP_SMV_UNPAID_PREM_YN = new HtmlSelectOneMenu();
			COMP_SMV_UNPAID_PREM_INT_CODE = new HtmlInputText();
			COMP_SMV_FC_UNPAID_PREM_INT = new HtmlInputText();
			COMP_SMV_LC_UNPAID_PREM_INT = new HtmlInputText();
			
			/*Added by Janani on 28.06.2017 for ZBILQC-1724475*/
			
			COMP_SMV_REMARKS_LABEL = new HtmlOutputLabel();
			COMP_SMV_REMARKS = new HtmlInputTextarea();
			
			/*End*/
			
			/*Added  by Janani on 17.07.2017 for ZBILQC-1724475*/
			
			COMP_SMV_DATE_LABEL = new HtmlOutputLabel();
			COMP_SMV_FC_NET_PAID_AMT_LABEL = new HtmlOutputLabel();
			COMP_SMV_PAID_DT_LABEL = new HtmlOutputLabel();
			COMP_SMV_DATE_TEXT = new HtmlOutputText();
			COMP_SMV_FC_GROSS_VALUE_TEXT = new HtmlOutputText();
			COMP_SMV_PAID_DT_TEXT = new HtmlOutputText();	
			COMP_SMV_FC_GROSS_VALUE_LABEL = new HtmlOutputLabel();
			COMP_TYPE = new HtmlSelectOneMenu();
			COMP_SMV_INT_VALUE_LABEL = new HtmlOutputLabel();
			COMP_SMV_INT_VALUE = new HtmlInputText();
			COMP_SMV_SAVE_BUT = new HtmlAjaxCommandButton();
			
			/*End*/
			
			/*New field added by saritha on 14-02-2018 for Surrender/Maturity Payment Bank Details Issues as per thiag sir sugg.*/
			COMP_SMV_PAYEE_NAME_LABEL = new HtmlOutputLabel();
			COMP_SMV_PAYEE_NAME       = new HtmlInputText();
			/*End*/
			
		}
	 
	 
	 
	 
	 /*End*/
	 
	 
	 /*Added  by Janani on 17.07.2017 for ZBILQC-1724475*/

	 private HtmlOutputLabel COMP_SMV_INT_VALUE_LABEL;

	 private HtmlInputText COMP_SMV_INT_VALUE;
	 
	 private HtmlAjaxCommandButton COMP_SMV_SAVE_BUT;
	 
	 

	 public HtmlAjaxCommandButton getCOMP_SMV_SAVE_BUT() {
		return COMP_SMV_SAVE_BUT;
	}
	public void setCOMP_SMV_SAVE_BUT(HtmlAjaxCommandButton cOMP_SMV_SAVE_BUT) {
		COMP_SMV_SAVE_BUT = cOMP_SMV_SAVE_BUT;
	}
	public HtmlInputText getCOMP_SMV_INT_VALUE() {
		 return COMP_SMV_INT_VALUE;
	 }
	 public void setCOMP_SMV_INT_VALUE(HtmlInputText cOMP_SMV_INT_VALUE) {
		 COMP_SMV_INT_VALUE = cOMP_SMV_INT_VALUE;
	 }
	 public HtmlOutputLabel getCOMP_SMV_INT_VALUE_LABEL() {
		 return COMP_SMV_INT_VALUE_LABEL;
	 }
	 public void setCOMP_SMV_INT_VALUE_LABEL(HtmlOutputLabel cOMP_SMV_INT_VALUE_LABEL) {
		 COMP_SMV_INT_VALUE_LABEL = cOMP_SMV_INT_VALUE_LABEL;
	 }
	 
	 public void disableAllComponent(boolean disabled) {
			COMP_SMV_DATE.setDisabled(disabled);
			COMP_SMV_FC_RED_SA.setDisabled(disabled);
			COMP_SMV_FC_ACC_PROFIT.setDisabled(disabled);
			COMP_SMV_FC_GROSS_VALUE.setDisabled(disabled);
			COMP_UI_M_FC_NET_PAID_AMT.setDisabled(disabled);
			COMP_SMV_PAID_DT.setDisabled(disabled);
			COMP_SMV_FC_NET_PAID_AMT.setDisabled(disabled);
			COMP_SMV_LC_RED_SA.setDisabled(disabled);
			COMP_SMV_LC_ACC_PROFIT.setDisabled(disabled);
			COMP_SMV_LC_GROSS_VALUE.setDisabled(disabled);
			COMP_UI_M_LC_NET_PAID_AMT.setDisabled(disabled);
			COMP_SMV_LC_NET_PAID_AMT.setDisabled(disabled);
			COMP_SMV_REF_NO.setDisabled(disabled);
			COMP_SMV_FC_OS_LOAN.setDisabled(disabled);
			COMP_SMV_LC_OS_LOAN.setDisabled(disabled);
			COMP_SMV_FC_CHARGE_AMT.setDisabled(disabled);
			COMP_SMV_FC_BAL_LOAN.setDisabled(disabled);
			COMP_SMV_LC_BAL_LOAN.setDisabled(disabled);
			COMP_SMV_LOAN_INT_YN.setDisabled(disabled);
			COMP_SMV_LC_CHARGE_AMT.setDisabled(disabled);
			COMP_SMV_FC_LOAN_INT.setDisabled(disabled);
			COMP_SMV_LC_LOAN_INT.setDisabled(disabled);
			COMP_SMV_PAYTO.setDisabled(disabled);
			COMP_SMV_FC_UNPAID_PREM.setDisabled(disabled);
			COMP_SMV_LC_UNPAID_PREM.setDisabled(disabled);
			COMP_SMV_UNPAID_PREM_YN.setDisabled(disabled);
			COMP_SMV_UNPAID_PREM_INT_CODE.setDisabled(disabled);
			COMP_SMV_FC_UNPAID_PREM_INT.setDisabled(disabled);
			COMP_SMV_LC_UNPAID_PREM_INT.setDisabled(disabled);
			COMP_SMV_REMARKS.setDisabled(disabled);
			COMP_TYPE.setDisabled(disabled);
			COMP_SMV_INT_VALUE.setDisabled(disabled);
			COMP_SMV_SAVE_BUT.setDisabled(disabled);
			/*Added by saritha on 10-08-2017 for ssp call id ZBILQC-1728303*/
			COMP_UI_M_BANK_CODE.setDisabled(disabled);
			COMP_UI_M_BRANCH_CODE.setDisabled(disabled);
			COMP_ACC_NO.setDisabled(disabled);
			/*End*/
			/*Added by Ameen on 08-12-2017 for ZBLIFE-1458892 */
			 COMP_SMV_FLEX10.setDisabled(disabled);
			 COMP_SMV_FLEX11.setDisabled(disabled);
			 COMP_SMV_FLEX12.setDisabled(disabled);
			 /*End*/
			
			 /*New field added by saritha on 14-02-2018 for Surrender/Maturity Payment Bank Details Issues as per thiag sir sugg.*/
			 COMP_SMV_PAYEE_NAME.setDisabled(disabled);
		    /*End*/
			 
			 
		}
	 /*End*/
	 
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
			
			new PT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_DELEGATE()
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
			
			 setBlockFlag(true);				 
			 if(compositeAction.getPT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_ACTION_BEAN().getDataList_PT_IL_SURR_MAT_BUS_RULE_ERROR_MSG().size()>0)
			 {
			 compositeAction.getPT_IL_SURR_MAT_BUS_RULE_ERROR_MSG_ACTION_BEAN().onLoad(null); 
			 compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_BUS_REPORT_MODAL_PANEL().setShowWhenRendered(true);
		 }
       
		 }catch (Exception e) {
			 e.printStackTrace();
			 getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					 e.getMessage());
			 getErrorMap().put("SurrModalPanel", e.getMessage());
		 }
		 return "";
	 }
	
	public String closeBusinessModalPanel() {
		 try {
			 compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_BUS_REPORT_MODAL_PANEL().setShowWhenRendered(false);
		 } catch (Exception e) {
			 e.printStackTrace();
			 getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					 e.getMessage());
			 getErrorMap().put("SurrModalPanel1", e.getMessage());
		 }
		 return "";
	 }
	/*End*/
	 
	 /*Added by Janani on 25.07.2017 for ZBILQC-1731997*/
	 
	 public int getcashback_tot_amt()
				throws Exception {
		  System.out.println("*******enter into getcashback_tot_amt***");
		
			String C1 ="SELECT AH_FC_AMOUNT FROM PT_IL_ADJ_HEAD,PT_IL_SURR_MAT_VALUES WHERE SMV_SYS_ID = AH_REF_SYS_ID AND AH_REF_NO = ?";
			ResultSet C1_REC = null;
			int cahsback_total=0;
			try {
				Connection connection = CommonUtils.getConnection();
				CRUDHandler handler = new CRUDHandler();
				C1_REC = handler.executeSelectStatement(C1, connection,
						new Object[] {compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO()});
				if (C1_REC.next()) {
					cahsback_total =C1_REC.getInt("AH_FC_AMOUNT");
				}
				} catch (SQLException e) {
				throw new Exception(e.getMessage());
			} 
			System.out.println("**************value of cahsback_total***"+cahsback_total);
			return cahsback_total;
			
		}
	 
	 /*End*/
	 
/*Added by Janani on 27.07.2017 for ZBILQC-1731997*/
	 
	 public Double getcust_tot_amt()
				throws Exception {
		  System.out.println("*******enter into getcust_tot_amt***");
		
			String C1 ="SELECT SMV_FC_GROSS_VALUE,SMV_INT_VALUE FROM PT_IL_SURR_MAT_VALUES WHERE SMV_POL_SYS_ID = ?";
			ResultSet C1_REC = null;
			
			Double surr_amt = 0.0;
			Double cashback_int = 0.0;
			Double cust_tot_amt=0.0;
			
			
			System.out.println("getSMV_POL_SYS_ID           "+compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().
					getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_POL_SYS_ID());
			try {
				Connection connection = CommonUtils.getConnection();
				CRUDHandler handler = new CRUDHandler();
				C1_REC = handler.executeSelectStatement(C1, connection,
						new Object[] {compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_POL_SYS_ID()});
				if (C1_REC.next()) {
					surr_amt = C1_REC.getDouble("SMV_FC_GROSS_VALUE");
					cashback_int = C1_REC.getDouble("SMV_INT_VALUE");
				}
				
				cust_tot_amt = (surr_amt + cashback_int);
				
				System.out.println("surr_amt         "+surr_amt+"     cashback_int         "+cashback_int);
				
				} catch (SQLException e) {
				throw new Exception(e.getMessage());
			} 
			System.out.println("**************value of cust_tot_amt***"+cust_tot_amt);
			return cust_tot_amt;
			
		}
	 
	 /*End*/
	 
	 /*Added by saritha on 10-08-2017 for ssp call id ZBILQC-1728303*/
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
	 	 
	 public void UI_M_BANK_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
				UIComponent component, Object value){

			try {
				PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BANK_CODE((String) value);
				System.out.println("value-----"+value);
						
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		} 
	    /*End*/
	 
	 
	 /*Added by saritha on 09-11-2017 for Surrender/Maturity(To modify the Gross Surrender Value/Gross Maturity Value) 
	        * to be calculated Net payable amount. as per siva sir sugg*/
	 
	 public String getFlag_Check() throws Exception {
		 
		 ResultSet C1_REC = null;
		 String ASD_CHAR_VALUE=null;
		 
		 String C1 ="SELECT ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET WHERE ASD_USER_ID =? "
				 + "AND ASD_CODE = 'CLM_EXGR_YN' AND ? BETWEEN NVL(ASD_FM_PROD_CODE,'0') AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz')";

		 try {
			 Connection connection = CommonUtils.getConnection();
			 CRUDHandler handler = new CRUDHandler();
			 String productCode=compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE();
			 C1_REC = handler.executeSelectStatement(C1, connection,
					 new Object[] {CommonUtils.getControlBean().getUSER_ID(),productCode});
			 if (C1_REC.next()) {
				 ASD_CHAR_VALUE =C1_REC.getString(1);
				 System.out.println("Flag value" +ASD_CHAR_VALUE);

			 }

			 if("Y".equalsIgnoreCase(ASD_CHAR_VALUE)){
				 compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_FC_GROSS_VALUE().setDisabled(false);

			 }

			 else{
				 compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_FC_GROSS_VALUE().setDisabled(true);

			 }

		 } catch (SQLException e) {
			 throw new Exception(e.getMessage());
		 } finally{
			 CommonUtils.closeCursor(C1_REC);
		 }

		 return ASD_CHAR_VALUE;

	 }
	 
	 /*End*/
	 
	 /*Added by Ameen on 01-12-2017 for ZBLIFE-1458892*/
	 private HtmlOutputLabel COMP_SMV_FLEX10_LABEL;
	 
	 private HtmlInputText COMP_SMV_FLEX10;
	 
	 private HtmlOutputLabel COMP_SMV_FLEX11_LABEL;
	 
	 private HtmlInputText COMP_SMV_FLEX11;
	 
	 private HtmlOutputLabel COMP_SMV_FLEX12_LABEL;
	 
	 private HtmlInputText COMP_SMV_FLEX12;
	 
	 private HtmlInputText COMP_UI_M_DIVN_CODE;

	public HtmlOutputLabel getCOMP_SMV_FLEX10_LABEL() {
		return COMP_SMV_FLEX10_LABEL;
	}
	public void setCOMP_SMV_FLEX10_LABEL(HtmlOutputLabel cOMP_SMV_FLEX10_LABEL) {
		COMP_SMV_FLEX10_LABEL = cOMP_SMV_FLEX10_LABEL;
	}
	public HtmlInputText getCOMP_SMV_FLEX10() {
		return COMP_SMV_FLEX10;
	}
	public void setCOMP_SMV_FLEX10(HtmlInputText cOMP_SMV_FLEX10) {
		COMP_SMV_FLEX10 = cOMP_SMV_FLEX10;
	}
	public HtmlOutputLabel getCOMP_SMV_FLEX11_LABEL() {
		return COMP_SMV_FLEX11_LABEL;
	}
	public void setCOMP_SMV_FLEX11_LABEL(HtmlOutputLabel cOMP_SMV_FLEX11_LABEL) {
		COMP_SMV_FLEX11_LABEL = cOMP_SMV_FLEX11_LABEL;
	}
	public HtmlInputText getCOMP_SMV_FLEX11() {
		return COMP_SMV_FLEX11;
	}
	public void setCOMP_SMV_FLEX11(HtmlInputText cOMP_SMV_FLEX11) {
		COMP_SMV_FLEX11 = cOMP_SMV_FLEX11;
	}
	public HtmlOutputLabel getCOMP_SMV_FLEX12_LABEL() {
		return COMP_SMV_FLEX12_LABEL;
	}
	public void setCOMP_SMV_FLEX12_LABEL(HtmlOutputLabel cOMP_SMV_FLEX12_LABEL) {
		COMP_SMV_FLEX12_LABEL = cOMP_SMV_FLEX12_LABEL;
	}
	public HtmlInputText getCOMP_SMV_FLEX12() {
		return COMP_SMV_FLEX12;
	}
	public void setCOMP_SMV_FLEX12(HtmlInputText cOMP_SMV_FLEX12) {
		COMP_SMV_FLEX12 = cOMP_SMV_FLEX12;
	}
	
	public HtmlInputText getCOMP_UI_M_DIVN_CODE() {
		return COMP_UI_M_DIVN_CODE;
	}
	public void setCOMP_UI_M_DIVN_CODE(HtmlInputText cOMP_UI_M_DIVN_CODE) {
		COMP_UI_M_DIVN_CODE = cOMP_UI_M_DIVN_CODE;
	}
	
	public void validateSMV_PAYTO(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_PAYTO((String) value);
			
			/*Commentted &Modified by saritha on 12-02-2018 for Surrender/Maturity Payment Bank Details Issues*/
			
			/*if(PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_BANK_CODE() == null && PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_BRANCH_CODE() == null &&
					PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FLEX06() == null && PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FLEX10() == null){*/
				
				/*if("A".equalsIgnoreCase(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_PAYTO())){*/

				if("A".equalsIgnoreCase(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_PAYTO()) && "EFT".equalsIgnoreCase(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FLEX04()) 
						|| "OTHERS".equalsIgnoreCase(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FLEX04())){

					COMP_UI_M_BANK_CODE.setRequired(false);
					COMP_ACC_NO.setRequired(false);
					COMP_SMV_FLEX10.setRequired(false);
					COMP_UI_M_BRANCH_CODE.setRequired(false);
					COMP_SMV_FLEX11.setDisabled(false);
					COMP_SMV_FLEX12.setDisabled(false);
					COMP_UI_M_BANK_CODE.setDisabled(false);
					COMP_ACC_NO.setDisabled(false);
					COMP_UI_M_BRANCH_CODE.setDisabled(false);
					COMP_SMV_FLEX10.setDisabled(false);

					String query = "SELECT CBAD_CUST_BANK_CODE, CBAD_BANK_NAME, CBAD_ACNT_NAME, CBAD_ACNT_NO, CBAD_DIVISION, "
							+ "(CUST_TEL_AREA_CODE2 || '-' || CUST_PHONE2) CUST_MOBILE, BANK_NAME,CUST_CODE,POAD_POL_SYS_ID "
							+ "FROM PM_CUST_BANK_ACNT_DTLS,PM_CUSTOMER,FM_BANK,PT_IL_POL_ASSURED_DTLS WHERE CUST_CODE = "
							+ "CBAD_CUST_CODE AND NVL(CBAD_PREF_ACNT_YN, 'N') = 'Y' AND BANK_CODE = CBAD_CUST_BANK_CODE "
							+ "AND POAD_ASSR_CODE = CBAD_CUST_CODE AND POAD_POL_SYS_ID IN (SELECT POL_SYS_ID FROM "
							+ "PT_IL_POLICY WHERE POL_NO = ?)";
					ResultSet rs = null;
					rs = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(),
							new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO()});
					if(rs.next()){
						if(rs.getString("CBAD_CUST_BANK_CODE")==null || rs.getString("CBAD_ACNT_NAME")==null || 
								rs.getString("CBAD_ACNT_NO")==null || rs.getString("CBAD_DIVISION")==null){
						//	throw new Exception("Enter the Bank Details in Customer Master");
						}else{
							if(PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_BANK_CODE() == null && PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_BRANCH_CODE() == null &&
									PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FLEX06() == null && PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FLEX10() == null){
							PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BANK_CODE(rs.getString("CBAD_CUST_BANK_CODE"));
							PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BANK_NAME(rs.getString("BANK_NAME"));
							PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BRANCH_CODE(rs.getString("CBAD_DIVISION"));
							if(PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_BRANCH_CODE()!=null){
								String sortCodeQry = "SELECT BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH where BR_BANK_CODE = ? AND BR_BANK_SORT_CODE = ?";
								ResultSet sortCodeRS = null;
								sortCodeRS = new CRUDHandler().executeSelectStatement
										(sortCodeQry, CommonUtils.getConnection(),new Object[]{PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_BANK_CODE(),PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_BRANCH_CODE()});
								if(sortCodeRS.next()){
									PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_DIVN_CODE(sortCodeRS.getString("BR_BANK_BRANCH_CODE"));
								}
							}
							PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX06(rs.getString("CBAD_ACNT_NO"));
							PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX10(rs.getString("CBAD_ACNT_NAME"));
							PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX11(rs.getString("CUST_MOBILE"));

							COMP_UI_M_BANK_CODE.resetValue();
							COMP_UI_M_BANK_NAME.resetValue();
							COMP_UI_M_BRANCH_CODE.resetValue();
							COMP_UI_M_DIVN_CODE.resetValue();
							COMP_ACC_NO.resetValue();
							COMP_SMV_FLEX10.resetValue();
							COMP_SMV_FLEX11.resetValue();
							}
						}
					}/*else{
						throw new Exception("Enter the Bank Details in Customer Master");
					}*/

				}
				
				else if("P".equalsIgnoreCase(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_PAYTO()) && "EFT".equalsIgnoreCase(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FLEX04()) 
							|| "OTHERS".equalsIgnoreCase(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FLEX04())){
						
					COMP_UI_M_BANK_CODE.setRequired(false);
					COMP_UI_M_BRANCH_CODE.setRequired(false);
					COMP_ACC_NO.setRequired(false);
					COMP_SMV_FLEX10.setRequired(false);
					COMP_SMV_FLEX11.setDisabled(false);
					COMP_SMV_FLEX12.setDisabled(false);
					/*COMP_UI_M_BANK_CODE.setDisabled(true);
					COMP_ACC_NO.setDisabled(true);
					COMP_UI_M_BRANCH_CODE.setDisabled(true);
					COMP_SMV_FLEX10.setDisabled(true);*/
					COMP_UI_M_BANK_CODE.setDisabled(false);
					COMP_ACC_NO.setDisabled(false);
					COMP_UI_M_BRANCH_CODE.setDisabled(false);
					COMP_SMV_FLEX10.setDisabled(false);
					

					String query = "SELECT CBAD_CUST_BANK_CODE,CBAD_BANK_NAME,CBAD_ACNT_NAME,CBAD_ACNT_NO,CBAD_DIVISION,"
							+ "(CUST_TEL_AREA_CODE2||'-'||CUST_PHONE2) CUST_MOBILE,BANK_NAME FROM PM_CUST_BANK_ACNT_DTLS,"
							+ "PM_CUSTOMER,FM_BANK,PT_IL_POLICY WHERE CUST_CODE = CBAD_CUST_CODE AND NVL(CBAD_PREF_ACNT_YN,'N') = 'Y' "
							+ "AND CBAD_CUST_CODE = POL_CUST_CODE AND BANK_CODE = CBAD_CUST_BANK_CODE AND POL_NO = ?";
					ResultSet rs = null;
					rs = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(),
							new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO()});
					if(rs.next()){
						if(rs.getString("CBAD_CUST_BANK_CODE")==null || rs.getString("CBAD_ACNT_NAME")==null || 
								rs.getString("CBAD_ACNT_NO")==null || rs.getString("CBAD_DIVISION")==null){
						//	throw new Exception("Enter the Bank Details in Customer Master");
						}else{
							
							if(PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_BANK_CODE() == null && PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_BRANCH_CODE() == null &&
									PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FLEX06() == null && PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FLEX10() == null){
							PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BANK_CODE(rs.getString("CBAD_CUST_BANK_CODE"));
							PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BANK_NAME(rs.getString("BANK_NAME"));
							PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BRANCH_CODE(rs.getString("CBAD_DIVISION"));
							if(PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_BRANCH_CODE()!=null){
								String sortCodeQry = "SELECT BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH where BR_BANK_CODE = ? AND BR_BANK_SORT_CODE = ?";
								ResultSet sortCodeRS = null;
								sortCodeRS = new CRUDHandler().executeSelectStatement
										(sortCodeQry, CommonUtils.getConnection(),new Object[]{PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_BANK_CODE(),PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_BRANCH_CODE()});
								if(sortCodeRS.next()){
									PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_DIVN_CODE(sortCodeRS.getString("BR_BANK_BRANCH_CODE"));
								}
							}
							PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX06(rs.getString("CBAD_ACNT_NO"));
							PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX10(rs.getString("CBAD_ACNT_NAME"));
							PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX11(rs.getString("CUST_MOBILE"));

							COMP_UI_M_BANK_CODE.resetValue();
							COMP_UI_M_BANK_NAME.resetValue();
							COMP_UI_M_BRANCH_CODE.resetValue();
							COMP_UI_M_DIVN_CODE.resetValue();
							COMP_ACC_NO.resetValue();
							COMP_SMV_FLEX10.resetValue();
							COMP_SMV_FLEX11.resetValue();
						}
							
						}
					}/*else{
						throw new Exception("Enter the Bank Details in Customer Master");
					}*/
				}
			/*}*/
				
			/*End*/
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}
	
	public void validateSMV_FLEX10(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX10((String) value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}
	
	public void validateSMV_FLEX11(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX11((String) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}
	
	public void validateSMV_FLEX12(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FLEX12((String) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}
	
	public ArrayList<LovBean> prepareSuggestionList_UI_M_DIVISION_CODE(Object currValue) {
		String code = (String) currValue;
		ArrayList<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		try {
			if ("*".equals(code)) {
				object = new Object[] { PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_BANK_CODE(), PELConstants.suggetionRecordSize };
				
				
				query = "SELECT BR_BANK_SORT_CODE,BR_BANK_BRANCH_CODE FROM PM_BANK_BRANCH WHERE BR_BANK_CODE = ? AND ROWNUM <= ? ORDER BY 1";
			} else {
				object = new Object[] { PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_BANK_CODE(), code + "%", code + "%",
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
	
	public void validatorUI_M_BRANCH_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BRANCH_CODE((String) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}
	
	public void validatorUI_M_BANK_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PT_IL_SURR_MAT_VALUES_BEAN.setUI_M_BANK_CODE((String) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}
	 
	 /*End*/
	
	//added by gopi ZBLIFE-1465513 on 04/01/18
	public void SURRMAT_ENABLE_DISABLE(Object smv_Pol_sys_id,Object smv_sys_id) {
	
		
		try {	
			String smv_apprv_flag=null;
			String smv_type=null;
			String query="SELECT SMV_APPRV_FLAG,SMV_TYPE FROM PT_IL_SURR_MAT_VALUES WHERE SMV_POL_SYS_ID = ? AND SMV_SYS_ID = ? AND SMV_TYPE IN ('S', 'R', 'M', 'P')";
			ResultSet resultset=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(), 
					new Object[]{smv_Pol_sys_id,smv_sys_id});
					String Custcode=null;
					while(resultset.next())
					{
						smv_apprv_flag=resultset.getString("SMV_APPRV_FLAG");
						smv_type=resultset.getString("SMV_TYPE");
				    }
		/*
		 * if(smv_apprv_flag!=null && smv_apprv_flag.equalsIgnoreCase("A")){
			disableAllComponent(true);
		}
		*/
		
	//	if (smv_type!=null&& "R".equals(smv_type)){
			if (smv_apprv_flag!=null && "A".equalsIgnoreCase(smv_apprv_flag)){
				//MODIFIED BYGOPI FOR KIC MATURITY PROCESS AS SUGGESTED BY VIJAY SIR ON 19/03/2019
				/*compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.setUI_B_SMV_FLAG1("Approved");*/
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_UI_B_POL_STATUS().setValue("Approved");
			}else if(smv_apprv_flag!=null && "R".equalsIgnoreCase(smv_apprv_flag)){
				/*compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.setUI_B_SMV_FLAG1("Rejected");*/
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_UI_B_POL_STATUS().setValue("Rejected");
			}else{
				/*compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.setUI_B_SMV_FLAG1("Not Approved");*/
				//compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_UI_B_POL_STATUS().setValue("Not Approved");
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_UI_B_POL_STATUS().setValue("Pending");
			}
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_UI_B_POL_STATUS().setRendered(true);
			/*}else{
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getCOMP_UI_B_POL_STATUS().setRendered(false);
			}*/
		}
	 catch (Exception e) {
		e.printStackTrace();
	} 
}
	
	 public void disableAllComponent_Cash_back(boolean disabled) {
			
			COMP_SMV_FC_GROSS_VALUE.setDisabled(disabled);
			COMP_UI_M_FC_NET_PAID_AMT.setDisabled(disabled);
			COMP_SMV_PAID_DT.setDisabled(disabled);
			COMP_SMV_FC_CHARGE_AMT.setDisabled(disabled);
			COMP_SMV_LC_CHARGE_AMT.setDisabled(disabled);
			COMP_UI_M_BANK_CODE.setDisabled(disabled);
			COMP_UI_M_BRANCH_CODE.setDisabled(disabled);
			COMP_ACC_NO.setDisabled(disabled);
			COMP_SMV_FLEX10.setDisabled(disabled);
			COMP_SMV_INT_VALUE.setDisabled(disabled);
		}
	
	//end
	 	//addded by gopi on 10/01/18
	 public void ins_sur_dolist(PILT013_COMPOSITE_ACTION compositeAction)
				throws Exception {
		PM_IL_DOC_TODO_GROUP pm_il_doc_todo_group_bean = compositeAction
				.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
				.getPM_IL_DOC_TODO_GROUP_BEAN();
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
		.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN();
		String DTG_GROUP_CODE = null;
		Connection con = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		String query = "SELECT DISTINCT DTG_GROUP_CODE FROM PT_IL_DOC_TODO_LIST_STATUS, PM_IL_DOC_TODO_GROUP WHERE DTLS_GROUP_CODE = DTG_GROUP_CODE "
				+ "AND DTG_DS_TYPE =? AND DTLS_SMV_SYS_ID =? ";
		String query2 = "SELECT 'X' FROM PT_IL_DOC_TODO_LIST_STATUS WHERE DTLS_SMV_SYS_ID = ? ";
		CRUDHandler handler = new CRUDHandler();
		try {
			con = CommonUtils.getConnection();

			rs1 = handler.executeSelectStatement(query,con,
					new Object[]{pm_il_doc_todo_group_bean.getDTG_DS_TYPE(),pt_il_surr_mat_values_bean.getSMV_SYS_ID()});
			System.out.println("**********getDTG_DS_TYPE***********"+pm_il_doc_todo_group_bean.getDTG_DS_TYPE());
			while (rs1.next()) {
				DTG_GROUP_CODE = rs1.getString("DTG_GROUP_CODE");
			}
			
			// added for check list 
			rs2 = handler.executeSelectStatement(query2,con, new Object[]{pt_il_surr_mat_values_bean.getSMV_SYS_ID()});
			if(!(rs2.next())){
				P_INS_SUR_DOLIST(pm_il_doc_todo_group_bean.getDTG_DS_TYPE(),
						DTG_GROUP_CODE,
						new CommonUtils().getCurrentDate(),
						pt_il_surr_mat_values_bean.getSMV_SYS_ID(), CommonUtils
								.getControlBean().getM_USER_ID());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			CommonUtils.closeCursor(rs1);
		}
	}
	 public ArrayList<OracleParameter> P_INS_SUR_DOLIST(String M_POL_DS_TYPE,
				String M_POL_DS_CODE, Date P_EFF_DT, Long P_SMV_SYS_ID,
				String CTRL_M_USER_ID) throws ProcedureException {
			Connection connection = null;
			ArrayList<OracleParameter> parameterList = null;
			ArrayList<OracleParameter> outputList = null;
			try {
				connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
				OracleParameter param1 = new OracleParameter("IN1",
						OracleParameter.DATA_TYPE.STRING,
						OracleParameter.DIRECTION_TYPE.IN, M_POL_DS_TYPE);
				parameterList.add(param1);
				OracleParameter param2 = new OracleParameter("IN2",
						OracleParameter.DATA_TYPE.STRING,
						OracleParameter.DIRECTION_TYPE.IN, M_POL_DS_CODE);
				parameterList.add(param2);
				OracleParameter param3 = new OracleParameter("IN3",
						OracleParameter.DATA_TYPE.DATE,
						OracleParameter.DIRECTION_TYPE.IN, P_EFF_DT);
				parameterList.add(param3);
				OracleParameter param4 = new OracleParameter("IN4",
						OracleParameter.DATA_TYPE.LONG,
						OracleParameter.DIRECTION_TYPE.IN, P_SMV_SYS_ID);
				parameterList.add(param4);
				OracleParameter param5 = new OracleParameter("IN5",
						OracleParameter.DATA_TYPE.STRING,
						OracleParameter.DIRECTION_TYPE.IN, CTRL_M_USER_ID);
				parameterList.add(param5);

				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				outputList = procHandler.executeProc(parameterList, connection,
						"P_INS_SUR_DOLIST");
			} catch (Exception e) {
				ErrorHelpUtil.getErrorForProcedure(connection);
				throw new ProcedureException(e.getMessage());
			}
			return outputList;
		}
	 	 
	 //end
	 
	 /*New field added by saritha on 14-02-2018 for Surrender/Maturity Payment Bank Details Issues as per thiag sir sugg.*/
	 
	 private HtmlOutputLabel COMP_SMV_PAYEE_NAME_LABEL;
	 private HtmlInputText   COMP_SMV_PAYEE_NAME;

	 public HtmlOutputLabel getCOMP_SMV_PAYEE_NAME_LABEL() {
		 return COMP_SMV_PAYEE_NAME_LABEL;
	 }
	 public void setCOMP_SMV_PAYEE_NAME_LABEL(
			 HtmlOutputLabel cOMP_SMV_PAYEE_NAME_LABEL) {
		 COMP_SMV_PAYEE_NAME_LABEL = cOMP_SMV_PAYEE_NAME_LABEL;
	 }

	 public HtmlInputText getCOMP_SMV_PAYEE_NAME() {
		 return COMP_SMV_PAYEE_NAME;
	 }
	 public void setCOMP_SMV_PAYEE_NAME(HtmlInputText cOMP_SMV_PAYEE_NAME) {
		 COMP_SMV_PAYEE_NAME = cOMP_SMV_PAYEE_NAME;
	 }
	
	 public void validateSMV_PAYEE_NAME(FacesContext context,
				UIComponent component, Object value) throws ValidatorException {
			try {
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_PAYEE_NAME((String) value);
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			} 
		}
	 
	/*End*/ 
	 
	 
	 
	 public void onClickReject() {
			String output = null;
			try {
				helper.PAYOUT_REJECTION(compositeAction);
				/*Added by ganesh on 26-04-2018 suggested by ajoy to clearing existing values after clicking rejection button */
				/*compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,	"Transaction Rejected Successfully");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, "Transaction Rejected Successfully");*/
				/*Added by ganesh on 03-05-2018 to reset the values once the rejection button clicked*/
				helper.executeQuery(compositeAction);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().setPT_IL_SURR_MAT_VALUES_BEAN(new PT_IL_SURR_MAT_VALUES());
				resetAllComponent();				
				COMP_SMV_SAVE_BUT.setDisabled(true);
				/*end*/
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_APPROVE().setDisabled(true);
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,	"Transaction Rejected Successfully");
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, "Transaction Rejected Successfully");
				/*end*/
			} catch (Exception e) {
				
				String error =ErrorHelpUtil.getUserErrorMessageFromDBErrorMessage(e.getMessage());
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,error);
				e.printStackTrace();
				compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getErrorMap().put("onClickReject", e.getMessage());
				
			}
		}		
	 
	 public String printButtonAction()
		{

			System.out.println("***************** ENTER THE PT_IL_POLICY_ACTION *****************");
			System.out.println("***************** printButtonAction  *******************");

			String outcome = null;
			try {
				/*added by gopi for dynamic report config on 03/04/2017*/
				PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN();
				CommonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID",
						policyBean.getPOL_SYS_ID().toString());
				//end
				outcome="PILT013_PRINT";
			} catch (Exception e) {
				// TODO: handle exception
			}

			return outcome;
		}

	 
}
