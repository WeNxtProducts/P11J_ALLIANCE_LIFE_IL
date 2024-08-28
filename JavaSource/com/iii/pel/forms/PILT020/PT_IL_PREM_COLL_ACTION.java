package com.iii.pel.forms.PILT020;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT017.PT_IL_PYMT_DTLS;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_PREM_COLL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PC_SCHD_PYMT_DT_LABEL;

	private HtmlCalendar COMP_PC_SCHD_PYMT_DT;

	private HtmlOutputLabel COMP_PC_PAID_DT_LABEL;

	private HtmlCalendar COMP_PC_PAID_DT;

	private HtmlOutputLabel COMP_UI_M_FC_NET_PREM_LABEL;

	private HtmlInputText COMP_UI_M_FC_NET_PREM;

	private HtmlOutputLabel COMP_PC_FC_AVLB_BAL_AMT_LABEL;

	private HtmlInputText COMP_PC_FC_AVLB_BAL_AMT;

	private HtmlOutputLabel COMP_PC_FC_PAID_AMT_LABEL;

	private HtmlInputText COMP_PC_FC_PAID_AMT;

	private HtmlOutputLabel COMP_PC_LC_PAID_AMT_LABEL;

	private HtmlInputText COMP_PC_LC_PAID_AMT;

	private HtmlOutputLabel COMP_PC_PAID_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_PC_PAID_FLAG;

	private HtmlSelectBooleanCheckbox COMP_CHECK_BOX;

	private HtmlOutputLabel COMP_PC_REF_NO_LABEL;

	private HtmlInputText COMP_PC_REF_NO;

	private HtmlOutputLabel COMP_UI_M_POL_CUST_EXCH_RATE_LABEL;

	private HtmlInputText COMP_UI_M_POL_CUST_EXCH_RATE;

	private HtmlOutputLabel COMP_UI_M_POL_CUST_CURR_CODE_LABEL;

	private HtmlInputText COMP_UI_M_POL_CUST_CURR_CODE;

	private HtmlOutputLabel COMP_PC_FC_BASIC_PREM_LABEL;

	private HtmlInputText COMP_PC_FC_BASIC_PREM;

	private HtmlOutputLabel COMP_PC_LC_BASIC_PREM_LABEL;

	private HtmlInputText COMP_PC_LC_BASIC_PREM;

	private HtmlOutputLabel COMP_PC_FC_CHARGE_AMT_LABEL;

	private HtmlInputText COMP_PC_FC_CHARGE_AMT;

	private HtmlOutputLabel COMP_PC_LC_CHARGE_AMT_LABEL;

	private HtmlInputText COMP_PC_LC_CHARGE_AMT;

	private HtmlOutputLabel COMP_PC_FC_ADDL_PREM_LABEL;

	private HtmlInputText COMP_PC_FC_ADDL_PREM;

	private HtmlOutputLabel COMP_PC_LC_ADDL_PREM_LABEL;

	private HtmlInputText COMP_PC_LC_ADDL_PREM;

	private HtmlOutputLabel COMP_PC_FC_CHARGE_LABEL;

	private HtmlInputText COMP_PC_FC_CHARGE;

	private HtmlOutputLabel COMP_PC_LC_CHARGE_LABEL;

	private HtmlInputText COMP_PC_LC_CHARGE;

	private HtmlOutputLabel COMP_PC_FC_LOAD_AMT_LABEL;

	private HtmlInputText COMP_PC_FC_LOAD_AMT;

	private HtmlOutputLabel COMP_PC_LC_LOAD_AMT_LABEL;

	private HtmlInputText COMP_PC_LC_LOAD_AMT;

	private HtmlOutputLabel COMP_PC_FC_DISCOUNT_LABEL;

	private HtmlInputText COMP_PC_FC_DISCOUNT;

	private HtmlOutputLabel COMP_PC_LC_DISCOUNT_LABEL;

	private HtmlInputText COMP_PC_LC_DISCOUNT;

	private HtmlOutputLabel COMP_PC_FC_GROSS_PREM_LABEL;

	private HtmlInputText COMP_PC_FC_GROSS_PREM;

	private HtmlOutputLabel COMP_PC_LC_GROSS_PREM_LABEL;

	private HtmlInputText COMP_PC_LC_GROSS_PREM;

	private HtmlOutputLabel COMP_UI_M_FC_LOAN_INT_LABEL;

	private HtmlInputText COMP_UI_M_FC_LOAN_INT;

	private HtmlOutputLabel COMP_UI_M_LC_LOAN_INT_LABEL;

	private HtmlInputText COMP_UI_M_LC_LOAN_INT;

	private HtmlOutputLabel COMP_PC_FC_UNPAID_PREM_INT_LABEL;

	private HtmlInputText COMP_PC_FC_UNPAID_PREM_INT;

	private HtmlOutputLabel COMP_PC_LC_UNPAID_PREM_INT_LABEL;

	private HtmlInputText COMP_PC_LC_UNPAID_PREM_INT;

	private HtmlOutputLabel COMP_UI_M_LC_NET_PREM_LABEL;

	private HtmlInputText COMP_UI_M_LC_NET_PREM;

	private HtmlOutputLabel COMP_PC_LC_AVLB_BAL_AMT_LABEL;

	private HtmlInputText COMP_PC_LC_AVLB_BAL_AMT;

	private HtmlOutputLabel COMP_UI_M_PC_POL_NO_LABEL;

	private HtmlInputText COMP_UI_M_PC_POL_NO;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_EMPLOYER_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_CONTRACTOR_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_POL_CUST_CURR_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_REINSTATE;

	private HtmlCommandButton COMP_UI_M_BUT_INT_DTLS;

	private HtmlCommandButton COMP_UI_M_BUT_BROKER_DTLS;

	private HtmlCommandButton COMP_UI_M_BUT_PYMT_DTLS;

	private HtmlCommandButton COMP_UI_M_BUT_CHG_DTL;

	private HtmlCommandButton COMP_UI_M_BUT_FAC;

	private HtmlCommandButton COMP_UI_M_BUT_LOAN_INT;

	private HtmlCommandButton COMP_UI_M_BUT_APPROVE;

	private HtmlAjaxCommandButton COMP_POPUP;

	private PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN;

	private List<SelectItem> PL_STATUS = new ArrayList<SelectItem>();

	private UIData dataTable;

	private List<PT_IL_PREM_COLL> fetchList = new ArrayList<PT_IL_PREM_COLL>();

	// //////////////////////////////////////////////////////////////

	private HtmlOutputLabel COMP_PL_STATUS_LABEL;
	private HtmlSelectOneMenu COMP_PL_STATUS;

	public List<PT_IL_PREM_COLL> getFetchList() {
		return fetchList;
	}

	public void setFetchList(List<PT_IL_PREM_COLL> fetchList) {
		this.fetchList = fetchList;
	}

	public PT_IL_PREM_COLL_ACTION() {
		PT_IL_PREM_COLL_BEAN = new PT_IL_PREM_COLL();
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_PC_SCHD_PYMT_DT_LABEL() {
		return COMP_PC_SCHD_PYMT_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PC_SCHD_PYMT_DT() {
		return COMP_PC_SCHD_PYMT_DT;
	}

	public void setCOMP_PC_SCHD_PYMT_DT_LABEL(
			HtmlOutputLabel COMP_PC_SCHD_PYMT_DT_LABEL) {
		this.COMP_PC_SCHD_PYMT_DT_LABEL = COMP_PC_SCHD_PYMT_DT_LABEL;
	}

	public void setCOMP_PC_SCHD_PYMT_DT(HtmlCalendar COMP_PC_SCHD_PYMT_DT) {
		this.COMP_PC_SCHD_PYMT_DT = COMP_PC_SCHD_PYMT_DT;
	}

	public HtmlOutputLabel getCOMP_PC_PAID_DT_LABEL() {
		return COMP_PC_PAID_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PC_PAID_DT() {
		return COMP_PC_PAID_DT;
	}

	public void setCOMP_PC_PAID_DT_LABEL(HtmlOutputLabel COMP_PC_PAID_DT_LABEL) {
		this.COMP_PC_PAID_DT_LABEL = COMP_PC_PAID_DT_LABEL;
	}

	public void setCOMP_PC_PAID_DT(HtmlCalendar COMP_PC_PAID_DT) {
		this.COMP_PC_PAID_DT = COMP_PC_PAID_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_FC_NET_PREM_LABEL() {
		return COMP_UI_M_FC_NET_PREM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FC_NET_PREM() {
		return COMP_UI_M_FC_NET_PREM;
	}

	public void setCOMP_UI_M_FC_NET_PREM_LABEL(
			HtmlOutputLabel COMP_UI_M_FC_NET_PREM_LABEL) {
		this.COMP_UI_M_FC_NET_PREM_LABEL = COMP_UI_M_FC_NET_PREM_LABEL;
	}

	public void setCOMP_UI_M_FC_NET_PREM(HtmlInputText COMP_UI_M_FC_NET_PREM) {
		this.COMP_UI_M_FC_NET_PREM = COMP_UI_M_FC_NET_PREM;
	}

	public HtmlOutputLabel getCOMP_PC_FC_AVLB_BAL_AMT_LABEL() {
		return COMP_PC_FC_AVLB_BAL_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_AVLB_BAL_AMT() {
		return COMP_PC_FC_AVLB_BAL_AMT;
	}

	public void setCOMP_PC_FC_AVLB_BAL_AMT_LABEL(
			HtmlOutputLabel COMP_PC_FC_AVLB_BAL_AMT_LABEL) {
		this.COMP_PC_FC_AVLB_BAL_AMT_LABEL = COMP_PC_FC_AVLB_BAL_AMT_LABEL;
	}

	public void setCOMP_PC_FC_AVLB_BAL_AMT(HtmlInputText COMP_PC_FC_AVLB_BAL_AMT) {
		this.COMP_PC_FC_AVLB_BAL_AMT = COMP_PC_FC_AVLB_BAL_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_FC_PAID_AMT_LABEL() {
		return COMP_PC_FC_PAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_PAID_AMT() {
		return COMP_PC_FC_PAID_AMT;
	}

	public void setCOMP_PC_FC_PAID_AMT_LABEL(
			HtmlOutputLabel COMP_PC_FC_PAID_AMT_LABEL) {
		this.COMP_PC_FC_PAID_AMT_LABEL = COMP_PC_FC_PAID_AMT_LABEL;
	}

	public void setCOMP_PC_FC_PAID_AMT(HtmlInputText COMP_PC_FC_PAID_AMT) {
		this.COMP_PC_FC_PAID_AMT = COMP_PC_FC_PAID_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_LC_PAID_AMT_LABEL() {
		return COMP_PC_LC_PAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_PAID_AMT() {
		return COMP_PC_LC_PAID_AMT;
	}

	public void setCOMP_PC_LC_PAID_AMT_LABEL(
			HtmlOutputLabel COMP_PC_LC_PAID_AMT_LABEL) {
		this.COMP_PC_LC_PAID_AMT_LABEL = COMP_PC_LC_PAID_AMT_LABEL;
	}

	public void setCOMP_PC_LC_PAID_AMT(HtmlInputText COMP_PC_LC_PAID_AMT) {
		this.COMP_PC_LC_PAID_AMT = COMP_PC_LC_PAID_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_PAID_FLAG_LABEL() {
		return COMP_PC_PAID_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PC_PAID_FLAG() {
		return COMP_PC_PAID_FLAG;
	}

	public void setCOMP_PC_PAID_FLAG_LABEL(
			HtmlOutputLabel COMP_PC_PAID_FLAG_LABEL) {
		this.COMP_PC_PAID_FLAG_LABEL = COMP_PC_PAID_FLAG_LABEL;
	}

	public void setCOMP_PC_PAID_FLAG(HtmlSelectOneMenu COMP_PC_PAID_FLAG) {
		this.COMP_PC_PAID_FLAG = COMP_PC_PAID_FLAG;
	}

	public HtmlOutputLabel getCOMP_PC_REF_NO_LABEL() {
		return COMP_PC_REF_NO_LABEL;
	}

	public HtmlInputText getCOMP_PC_REF_NO() {
		return COMP_PC_REF_NO;
	}

	public void setCOMP_PC_REF_NO_LABEL(HtmlOutputLabel COMP_PC_REF_NO_LABEL) {
		this.COMP_PC_REF_NO_LABEL = COMP_PC_REF_NO_LABEL;
	}

	public void setCOMP_PC_REF_NO(HtmlInputText COMP_PC_REF_NO) {
		this.COMP_PC_REF_NO = COMP_PC_REF_NO;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_CUST_EXCH_RATE_LABEL() {
		return COMP_UI_M_POL_CUST_EXCH_RATE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_CUST_EXCH_RATE() {
		return COMP_UI_M_POL_CUST_EXCH_RATE;
	}

	public void setCOMP_UI_M_POL_CUST_EXCH_RATE_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_CUST_EXCH_RATE_LABEL) {
		this.COMP_UI_M_POL_CUST_EXCH_RATE_LABEL = COMP_UI_M_POL_CUST_EXCH_RATE_LABEL;
	}

	public void setCOMP_UI_M_POL_CUST_EXCH_RATE(
			HtmlInputText COMP_UI_M_POL_CUST_EXCH_RATE) {
		this.COMP_UI_M_POL_CUST_EXCH_RATE = COMP_UI_M_POL_CUST_EXCH_RATE;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_CUST_CURR_CODE_LABEL() {
		return COMP_UI_M_POL_CUST_CURR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_CUST_CURR_CODE() {
		return COMP_UI_M_POL_CUST_CURR_CODE;
	}

	public void setCOMP_UI_M_POL_CUST_CURR_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_CUST_CURR_CODE_LABEL) {
		this.COMP_UI_M_POL_CUST_CURR_CODE_LABEL = COMP_UI_M_POL_CUST_CURR_CODE_LABEL;
	}

	public void setCOMP_UI_M_POL_CUST_CURR_CODE(
			HtmlInputText COMP_UI_M_POL_CUST_CURR_CODE) {
		this.COMP_UI_M_POL_CUST_CURR_CODE = COMP_UI_M_POL_CUST_CURR_CODE;
	}

	public HtmlOutputLabel getCOMP_PC_FC_BASIC_PREM_LABEL() {
		return COMP_PC_FC_BASIC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_BASIC_PREM() {
		return COMP_PC_FC_BASIC_PREM;
	}

	public void setCOMP_PC_FC_BASIC_PREM_LABEL(
			HtmlOutputLabel COMP_PC_FC_BASIC_PREM_LABEL) {
		this.COMP_PC_FC_BASIC_PREM_LABEL = COMP_PC_FC_BASIC_PREM_LABEL;
	}

	public void setCOMP_PC_FC_BASIC_PREM(HtmlInputText COMP_PC_FC_BASIC_PREM) {
		this.COMP_PC_FC_BASIC_PREM = COMP_PC_FC_BASIC_PREM;
	}

	public HtmlOutputLabel getCOMP_PC_LC_BASIC_PREM_LABEL() {
		return COMP_PC_LC_BASIC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_BASIC_PREM() {
		return COMP_PC_LC_BASIC_PREM;
	}

	public void setCOMP_PC_LC_BASIC_PREM_LABEL(
			HtmlOutputLabel COMP_PC_LC_BASIC_PREM_LABEL) {
		this.COMP_PC_LC_BASIC_PREM_LABEL = COMP_PC_LC_BASIC_PREM_LABEL;
	}

	public void setCOMP_PC_LC_BASIC_PREM(HtmlInputText COMP_PC_LC_BASIC_PREM) {
		this.COMP_PC_LC_BASIC_PREM = COMP_PC_LC_BASIC_PREM;
	}

	public HtmlOutputLabel getCOMP_PC_FC_CHARGE_AMT_LABEL() {
		return COMP_PC_FC_CHARGE_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_CHARGE_AMT() {
		return COMP_PC_FC_CHARGE_AMT;
	}

	public void setCOMP_PC_FC_CHARGE_AMT_LABEL(
			HtmlOutputLabel COMP_PC_FC_CHARGE_AMT_LABEL) {
		this.COMP_PC_FC_CHARGE_AMT_LABEL = COMP_PC_FC_CHARGE_AMT_LABEL;
	}

	public void setCOMP_PC_FC_CHARGE_AMT(HtmlInputText COMP_PC_FC_CHARGE_AMT) {
		this.COMP_PC_FC_CHARGE_AMT = COMP_PC_FC_CHARGE_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_LC_CHARGE_AMT_LABEL() {
		return COMP_PC_LC_CHARGE_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_CHARGE_AMT() {
		return COMP_PC_LC_CHARGE_AMT;
	}

	public void setCOMP_PC_LC_CHARGE_AMT_LABEL(
			HtmlOutputLabel COMP_PC_LC_CHARGE_AMT_LABEL) {
		this.COMP_PC_LC_CHARGE_AMT_LABEL = COMP_PC_LC_CHARGE_AMT_LABEL;
	}

	public void setCOMP_PC_LC_CHARGE_AMT(HtmlInputText COMP_PC_LC_CHARGE_AMT) {
		this.COMP_PC_LC_CHARGE_AMT = COMP_PC_LC_CHARGE_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_FC_ADDL_PREM_LABEL() {
		return COMP_PC_FC_ADDL_PREM_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_ADDL_PREM() {
		return COMP_PC_FC_ADDL_PREM;
	}

	public void setCOMP_PC_FC_ADDL_PREM_LABEL(
			HtmlOutputLabel COMP_PC_FC_ADDL_PREM_LABEL) {
		this.COMP_PC_FC_ADDL_PREM_LABEL = COMP_PC_FC_ADDL_PREM_LABEL;
	}

	public void setCOMP_PC_FC_ADDL_PREM(HtmlInputText COMP_PC_FC_ADDL_PREM) {
		this.COMP_PC_FC_ADDL_PREM = COMP_PC_FC_ADDL_PREM;
	}

	public HtmlOutputLabel getCOMP_PC_LC_ADDL_PREM_LABEL() {
		return COMP_PC_LC_ADDL_PREM_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_ADDL_PREM() {
		return COMP_PC_LC_ADDL_PREM;
	}

	public void setCOMP_PC_LC_ADDL_PREM_LABEL(
			HtmlOutputLabel COMP_PC_LC_ADDL_PREM_LABEL) {
		this.COMP_PC_LC_ADDL_PREM_LABEL = COMP_PC_LC_ADDL_PREM_LABEL;
	}

	public void setCOMP_PC_LC_ADDL_PREM(HtmlInputText COMP_PC_LC_ADDL_PREM) {
		this.COMP_PC_LC_ADDL_PREM = COMP_PC_LC_ADDL_PREM;
	}

	public HtmlOutputLabel getCOMP_PC_FC_CHARGE_LABEL() {
		return COMP_PC_FC_CHARGE_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_CHARGE() {
		return COMP_PC_FC_CHARGE;
	}

	public void setCOMP_PC_FC_CHARGE_LABEL(
			HtmlOutputLabel COMP_PC_FC_CHARGE_LABEL) {
		this.COMP_PC_FC_CHARGE_LABEL = COMP_PC_FC_CHARGE_LABEL;
	}

	public void setCOMP_PC_FC_CHARGE(HtmlInputText COMP_PC_FC_CHARGE) {
		this.COMP_PC_FC_CHARGE = COMP_PC_FC_CHARGE;
	}

	public HtmlOutputLabel getCOMP_PC_LC_CHARGE_LABEL() {
		return COMP_PC_LC_CHARGE_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_CHARGE() {
		return COMP_PC_LC_CHARGE;
	}

	public void setCOMP_PC_LC_CHARGE_LABEL(
			HtmlOutputLabel COMP_PC_LC_CHARGE_LABEL) {
		this.COMP_PC_LC_CHARGE_LABEL = COMP_PC_LC_CHARGE_LABEL;
	}

	public void setCOMP_PC_LC_CHARGE(HtmlInputText COMP_PC_LC_CHARGE) {
		this.COMP_PC_LC_CHARGE = COMP_PC_LC_CHARGE;
	}

	public HtmlOutputLabel getCOMP_PC_FC_LOAD_AMT_LABEL() {
		return COMP_PC_FC_LOAD_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_LOAD_AMT() {
		return COMP_PC_FC_LOAD_AMT;
	}

	public void setCOMP_PC_FC_LOAD_AMT_LABEL(
			HtmlOutputLabel COMP_PC_FC_LOAD_AMT_LABEL) {
		this.COMP_PC_FC_LOAD_AMT_LABEL = COMP_PC_FC_LOAD_AMT_LABEL;
	}

	public void setCOMP_PC_FC_LOAD_AMT(HtmlInputText COMP_PC_FC_LOAD_AMT) {
		this.COMP_PC_FC_LOAD_AMT = COMP_PC_FC_LOAD_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_LC_LOAD_AMT_LABEL() {
		return COMP_PC_LC_LOAD_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_LOAD_AMT() {
		return COMP_PC_LC_LOAD_AMT;
	}

	public void setCOMP_PC_LC_LOAD_AMT_LABEL(
			HtmlOutputLabel COMP_PC_LC_LOAD_AMT_LABEL) {
		this.COMP_PC_LC_LOAD_AMT_LABEL = COMP_PC_LC_LOAD_AMT_LABEL;
	}

	public void setCOMP_PC_LC_LOAD_AMT(HtmlInputText COMP_PC_LC_LOAD_AMT) {
		this.COMP_PC_LC_LOAD_AMT = COMP_PC_LC_LOAD_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_FC_DISCOUNT_LABEL() {
		return COMP_PC_FC_DISCOUNT_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_DISCOUNT() {
		return COMP_PC_FC_DISCOUNT;
	}

	public void setCOMP_PC_FC_DISCOUNT_LABEL(
			HtmlOutputLabel COMP_PC_FC_DISCOUNT_LABEL) {
		this.COMP_PC_FC_DISCOUNT_LABEL = COMP_PC_FC_DISCOUNT_LABEL;
	}

	public void setCOMP_PC_FC_DISCOUNT(HtmlInputText COMP_PC_FC_DISCOUNT) {
		this.COMP_PC_FC_DISCOUNT = COMP_PC_FC_DISCOUNT;
	}

	public HtmlOutputLabel getCOMP_PC_LC_DISCOUNT_LABEL() {
		return COMP_PC_LC_DISCOUNT_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_DISCOUNT() {
		return COMP_PC_LC_DISCOUNT;
	}

	public void setCOMP_PC_LC_DISCOUNT_LABEL(
			HtmlOutputLabel COMP_PC_LC_DISCOUNT_LABEL) {
		this.COMP_PC_LC_DISCOUNT_LABEL = COMP_PC_LC_DISCOUNT_LABEL;
	}

	public void setCOMP_PC_LC_DISCOUNT(HtmlInputText COMP_PC_LC_DISCOUNT) {
		this.COMP_PC_LC_DISCOUNT = COMP_PC_LC_DISCOUNT;
	}

	public HtmlOutputLabel getCOMP_PC_FC_GROSS_PREM_LABEL() {
		return COMP_PC_FC_GROSS_PREM_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_GROSS_PREM() {
		return COMP_PC_FC_GROSS_PREM;
	}

	public void setCOMP_PC_FC_GROSS_PREM_LABEL(
			HtmlOutputLabel COMP_PC_FC_GROSS_PREM_LABEL) {
		this.COMP_PC_FC_GROSS_PREM_LABEL = COMP_PC_FC_GROSS_PREM_LABEL;
	}

	public void setCOMP_PC_FC_GROSS_PREM(HtmlInputText COMP_PC_FC_GROSS_PREM) {
		this.COMP_PC_FC_GROSS_PREM = COMP_PC_FC_GROSS_PREM;
	}

	public HtmlOutputLabel getCOMP_PC_LC_GROSS_PREM_LABEL() {
		return COMP_PC_LC_GROSS_PREM_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_GROSS_PREM() {
		return COMP_PC_LC_GROSS_PREM;
	}

	public void setCOMP_PC_LC_GROSS_PREM_LABEL(
			HtmlOutputLabel COMP_PC_LC_GROSS_PREM_LABEL) {
		this.COMP_PC_LC_GROSS_PREM_LABEL = COMP_PC_LC_GROSS_PREM_LABEL;
	}

	public void setCOMP_PC_LC_GROSS_PREM(HtmlInputText COMP_PC_LC_GROSS_PREM) {
		this.COMP_PC_LC_GROSS_PREM = COMP_PC_LC_GROSS_PREM;
	}

	public HtmlOutputLabel getCOMP_UI_M_FC_LOAN_INT_LABEL() {
		return COMP_UI_M_FC_LOAN_INT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FC_LOAN_INT() {
		return COMP_UI_M_FC_LOAN_INT;
	}

	public void setCOMP_UI_M_FC_LOAN_INT_LABEL(
			HtmlOutputLabel COMP_UI_M_FC_LOAN_INT_LABEL) {
		this.COMP_UI_M_FC_LOAN_INT_LABEL = COMP_UI_M_FC_LOAN_INT_LABEL;
	}

	public void setCOMP_UI_M_FC_LOAN_INT(HtmlInputText COMP_UI_M_FC_LOAN_INT) {
		this.COMP_UI_M_FC_LOAN_INT = COMP_UI_M_FC_LOAN_INT;
	}

	public HtmlOutputLabel getCOMP_UI_M_LC_LOAN_INT_LABEL() {
		return COMP_UI_M_LC_LOAN_INT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LC_LOAN_INT() {
		return COMP_UI_M_LC_LOAN_INT;
	}

	public void setCOMP_UI_M_LC_LOAN_INT_LABEL(
			HtmlOutputLabel COMP_UI_M_LC_LOAN_INT_LABEL) {
		this.COMP_UI_M_LC_LOAN_INT_LABEL = COMP_UI_M_LC_LOAN_INT_LABEL;
	}

	public void setCOMP_UI_M_LC_LOAN_INT(HtmlInputText COMP_UI_M_LC_LOAN_INT) {
		this.COMP_UI_M_LC_LOAN_INT = COMP_UI_M_LC_LOAN_INT;
	}

	public HtmlOutputLabel getCOMP_PC_FC_UNPAID_PREM_INT_LABEL() {
		return COMP_PC_FC_UNPAID_PREM_INT_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_UNPAID_PREM_INT() {
		return COMP_PC_FC_UNPAID_PREM_INT;
	}

	public void setCOMP_PC_FC_UNPAID_PREM_INT_LABEL(
			HtmlOutputLabel COMP_PC_FC_UNPAID_PREM_INT_LABEL) {
		this.COMP_PC_FC_UNPAID_PREM_INT_LABEL = COMP_PC_FC_UNPAID_PREM_INT_LABEL;
	}

	public void setCOMP_PC_FC_UNPAID_PREM_INT(
			HtmlInputText COMP_PC_FC_UNPAID_PREM_INT) {
		this.COMP_PC_FC_UNPAID_PREM_INT = COMP_PC_FC_UNPAID_PREM_INT;
	}

	public HtmlOutputLabel getCOMP_PC_LC_UNPAID_PREM_INT_LABEL() {
		return COMP_PC_LC_UNPAID_PREM_INT_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_UNPAID_PREM_INT() {
		return COMP_PC_LC_UNPAID_PREM_INT;
	}

	public void setCOMP_PC_LC_UNPAID_PREM_INT_LABEL(
			HtmlOutputLabel COMP_PC_LC_UNPAID_PREM_INT_LABEL) {
		this.COMP_PC_LC_UNPAID_PREM_INT_LABEL = COMP_PC_LC_UNPAID_PREM_INT_LABEL;
	}

	public void setCOMP_PC_LC_UNPAID_PREM_INT(
			HtmlInputText COMP_PC_LC_UNPAID_PREM_INT) {
		this.COMP_PC_LC_UNPAID_PREM_INT = COMP_PC_LC_UNPAID_PREM_INT;
	}

	public HtmlOutputLabel getCOMP_UI_M_LC_NET_PREM_LABEL() {
		return COMP_UI_M_LC_NET_PREM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LC_NET_PREM() {
		return COMP_UI_M_LC_NET_PREM;
	}

	public void setCOMP_UI_M_LC_NET_PREM_LABEL(
			HtmlOutputLabel COMP_UI_M_LC_NET_PREM_LABEL) {
		this.COMP_UI_M_LC_NET_PREM_LABEL = COMP_UI_M_LC_NET_PREM_LABEL;
	}

	public void setCOMP_UI_M_LC_NET_PREM(HtmlInputText COMP_UI_M_LC_NET_PREM) {
		this.COMP_UI_M_LC_NET_PREM = COMP_UI_M_LC_NET_PREM;
	}

	public HtmlOutputLabel getCOMP_PC_LC_AVLB_BAL_AMT_LABEL() {
		return COMP_PC_LC_AVLB_BAL_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_AVLB_BAL_AMT() {
		return COMP_PC_LC_AVLB_BAL_AMT;
	}

	public void setCOMP_PC_LC_AVLB_BAL_AMT_LABEL(
			HtmlOutputLabel COMP_PC_LC_AVLB_BAL_AMT_LABEL) {
		this.COMP_PC_LC_AVLB_BAL_AMT_LABEL = COMP_PC_LC_AVLB_BAL_AMT_LABEL;
	}

	public void setCOMP_PC_LC_AVLB_BAL_AMT(HtmlInputText COMP_PC_LC_AVLB_BAL_AMT) {
		this.COMP_PC_LC_AVLB_BAL_AMT = COMP_PC_LC_AVLB_BAL_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_POL_NO_LABEL() {
		return COMP_UI_M_PC_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_POL_NO() {
		return COMP_UI_M_PC_POL_NO;
	}

	public void setCOMP_UI_M_PC_POL_NO_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_POL_NO_LABEL) {
		this.COMP_UI_M_PC_POL_NO_LABEL = COMP_UI_M_PC_POL_NO_LABEL;
	}

	public void setCOMP_UI_M_PC_POL_NO(HtmlInputText COMP_UI_M_PC_POL_NO) {
		this.COMP_UI_M_PC_POL_NO = COMP_UI_M_PC_POL_NO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_EMPLOYER_CODE() {
		return COMP_UI_M_BUT_LOV_EMPLOYER_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_EMPLOYER_CODE(
			HtmlCommandButton COMP_UI_M_BUT_LOV_EMPLOYER_CODE) {
		this.COMP_UI_M_BUT_LOV_EMPLOYER_CODE = COMP_UI_M_BUT_LOV_EMPLOYER_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_CONTRACTOR_CODE() {
		return COMP_UI_M_BUT_LOV_CONTRACTOR_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_CONTRACTOR_CODE(
			HtmlCommandButton COMP_UI_M_BUT_LOV_CONTRACTOR_CODE) {
		this.COMP_UI_M_BUT_LOV_CONTRACTOR_CODE = COMP_UI_M_BUT_LOV_CONTRACTOR_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_POL_CUST_CURR_CODE() {
		return COMP_UI_M_BUT_LOV_POL_CUST_CURR_CODE;
	}

	public void setCOMP_UI_M_BUT_LOV_POL_CUST_CURR_CODE(
			HtmlCommandButton COMP_UI_M_BUT_LOV_POL_CUST_CURR_CODE) {
		this.COMP_UI_M_BUT_LOV_POL_CUST_CURR_CODE = COMP_UI_M_BUT_LOV_POL_CUST_CURR_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_REINSTATE() {
		return COMP_UI_M_BUT_REINSTATE;
	}

	public void setCOMP_UI_M_BUT_REINSTATE(
			HtmlCommandButton COMP_UI_M_BUT_REINSTATE) {
		this.COMP_UI_M_BUT_REINSTATE = COMP_UI_M_BUT_REINSTATE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_INT_DTLS() {
		return COMP_UI_M_BUT_INT_DTLS;
	}

	public void setCOMP_UI_M_BUT_INT_DTLS(
			HtmlCommandButton COMP_UI_M_BUT_INT_DTLS) {
		this.COMP_UI_M_BUT_INT_DTLS = COMP_UI_M_BUT_INT_DTLS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BROKER_DTLS() {
		return COMP_UI_M_BUT_BROKER_DTLS;
	}

	public void setCOMP_UI_M_BUT_BROKER_DTLS(
			HtmlCommandButton COMP_UI_M_BUT_BROKER_DTLS) {
		this.COMP_UI_M_BUT_BROKER_DTLS = COMP_UI_M_BUT_BROKER_DTLS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PYMT_DTLS() {
		return COMP_UI_M_BUT_PYMT_DTLS;
	}

	public void setCOMP_UI_M_BUT_PYMT_DTLS(
			HtmlCommandButton COMP_UI_M_BUT_PYMT_DTLS) {
		this.COMP_UI_M_BUT_PYMT_DTLS = COMP_UI_M_BUT_PYMT_DTLS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CHG_DTL() {
		return COMP_UI_M_BUT_CHG_DTL;
	}

	public void setCOMP_UI_M_BUT_CHG_DTL(HtmlCommandButton COMP_UI_M_BUT_CHG_DTL) {
		this.COMP_UI_M_BUT_CHG_DTL = COMP_UI_M_BUT_CHG_DTL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_FAC() {
		return COMP_UI_M_BUT_FAC;
	}

	public void setCOMP_UI_M_BUT_FAC(HtmlCommandButton COMP_UI_M_BUT_FAC) {
		this.COMP_UI_M_BUT_FAC = COMP_UI_M_BUT_FAC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOAN_INT() {
		return COMP_UI_M_BUT_LOAN_INT;
	}

	public void setCOMP_UI_M_BUT_LOAN_INT(
			HtmlCommandButton COMP_UI_M_BUT_LOAN_INT) {
		this.COMP_UI_M_BUT_LOAN_INT = COMP_UI_M_BUT_LOAN_INT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_APPROVE() {
		return COMP_UI_M_BUT_APPROVE;
	}

	public void setCOMP_UI_M_BUT_APPROVE(HtmlCommandButton COMP_UI_M_BUT_APPROVE) {
		this.COMP_UI_M_BUT_APPROVE = COMP_UI_M_BUT_APPROVE;
	}

	public PT_IL_PREM_COLL getPT_IL_PREM_COLL_BEAN() {
		return PT_IL_PREM_COLL_BEAN;
	}

	public void setPT_IL_PREM_COLL_BEAN(PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN) {
		this.PT_IL_PREM_COLL_BEAN = PT_IL_PREM_COLL_BEAN;
	}

	public String gotoPayment() throws Exception {

		String mappedBeanName = "PILT020_COMPOSITE_ACTION";
		PT_IL_PYMT_DTLS bean = null;
		PT_IL_PREM_COLL premBean = null;
		CommonUtils utility = new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean = (PILT020_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		PT_IL_POLICY policyBean = actionBean.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN();
		CommonUtils.setGlobalVariable("GLOBAL.TXN_TYPE", "PC");
		// CommonUtils.setGlobalVariable("GLOBAL.EXCH_RATE",
		// policyBean.getPOL_CUST_EXCH_RATE().toString());
		CommonUtils.setGlobalVariable("GLOBAL.EXCH_RATE", "20.0");
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		/*
		 * String C1= "SELECT
		 * MIN(PC_SYS_ID),SUM(PC_FC_PAID_AMT),SUM(PC_LC_PAID_AMT) FROM
		 * PT_IL_PREM_COLL WHERE PC_POL_SYS_ID='"+policyBean.getPOL_SYS_ID()+"' " +
		 * "AND NVL(PC_PAID_FLAG,'N') = 'Y' AND PC_PAID_DT IS NOT NULL"; //
		 */
		premBean = actionBean.getDUMMY_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN(); // 29627
		if (null != premBean.getUI_M_PC_POL_NO()) {
			String C1 = "select POL_SYS_ID from pt_il_policy where POL_NO = '"
					+ premBean.getUI_M_PC_POL_NO() + "'";
			System.out.println("Query for POL_SYS_ID----------->" + C1);
			rs = handler
					.executeSelectStatement(C1, CommonUtils.getConnection());
			String polsysid = null;
			while (rs.next()) {
				polsysid = rs.getInt("POL_SYS_ID") + "";
			}
			bean = new PT_IL_PYMT_DTLS();
			if (null != polsysid && !polsysid.isEmpty()) {
				String C2 = "SELECT MIN(PC_SYS_ID),SUM(PC_FC_PAID_AMT),SUM(PC_LC_PAID_AMT) FROM PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID='"
						+ polsysid
						+ "' AND NVL(PC_PAID_FLAG,'N')= 'Y' AND PC_PAID_DT IS NOT NULL";
				rs = handler.executeSelectStatement(C2, CommonUtils
						.getConnection());
				if (rs.next()) {
					CommonUtils.setGlobalVariable("GLOBAL.TXN_SYS_ID", rs
							.getInt(1)
							+ "");
					System.out.println("The Global Parameter inside>>>>>>>>>>"
							+ CommonUtils.getGlobalObject("GLOBAL.TXN_SYS_ID"));
					CommonUtils.setGlobalVariable("GLOBAL.FC_AMT", rs
							.getDouble(2)
							+ "");
					CommonUtils.setGlobalVariable("GLOBAL.LC_AMT", rs
							.getDouble(3)
							+ "");
				}

				String PD_TXN_TYPE = CommonUtils
						.getGlobalVariable("GLOBAL.TXN_TYPE");
				Double TXN_SYS_ID = Double.parseDouble(CommonUtils
						.getGlobalVariable("GLOBAL.TXN_SYS_ID"));
				String PC_FC_AMT = CommonUtils
						.getGlobalVariable("GLOBAL.FC_AMT");
				Double FC_AMT = Double.parseDouble(PC_FC_AMT);
				String PC_LC_AMT = CommonUtils
						.getGlobalVariable("GLOBAL.LC_AMT");
				Double LC_AMT = Double.parseDouble(PC_LC_AMT);
				bean.setPD_TXN_TYPE(CommonUtils
						.getGlobalVariable("GLOBAL.TXN_TYPE"));
				bean.setPD_FC_AMT(FC_AMT);
				bean.setPD_LC_AMT(LC_AMT);
			}

		}
		// PT_IL_PYMT_DTLS_ACTION paymentDetail = new PT_IL_PYMT_DTLS_ACTION(
		// "goBacktoDummy1", bean, true);
		// return paymentDetail.gotoPaymentDetails();
		com.iii.pel.forms.PILT017.PT_IL_PYMT_DTLS_ACTION paymentDetail = new com.iii.pel.forms.PILT017.PT_IL_PYMT_DTLS_ACTION(
				"goBacktoDummy1", bean, true);
		return paymentDetail.gotoPaymentDetails();

	}

	public List<SelectItem> getPL_STATUS() throws Exception {
		if (PL_STATUS.size() == 0) {
			PL_STATUS.clear();
			PL_STATUS = ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PILT020", "PT_IL_PREM_COLL",
					"PT_IL_PREM_COLL.PC_PAID_FLAG", "IL_PREM_STAT");
			// PL_STATUS=ListItemUtil.getDropDownListValue(connection, formName,
			// blockName, comboFieldName, comboFieldId)
		}

		return PL_STATUS;
	}

	public void setPL_STATUS(List<SelectItem> pl_status) {
		PL_STATUS = pl_status;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public void post(ActionEvent ae) {
		String message = null;
		getWarningMap().clear();
		try {
			getWarningMap().clear();
			if (PT_IL_PREM_COLL_BEAN.getROWID() == null) {
				new CRUDHandler().executeInsert(PT_IL_PREM_COLL_BEAN,
						new CommonUtils().getConnection());
				fetchList.add(PT_IL_PREM_COLL_BEAN);
				// resetSelectedRow();
				PT_IL_PREM_COLL_BEAN.setRowSelected(true);
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insert");

			} else if (PT_IL_PREM_COLL_BEAN.getROWID() != null) {
				new CRUDHandler().executeUpdate(PT_IL_PREM_COLL_BEAN,
						new CommonUtils().getConnection());
				// resetSelectedRow();
				PT_IL_PREM_COLL_BEAN.setRowSelected(true);
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update");
			}

			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					message);

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}
	}

	public void deleteRow(ActionEvent ae) {
		String message = null;
		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isDELETE_ALLOWED()) {
				if (PT_IL_PREM_COLL_BEAN.getROWID() != null) {
					// executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PT_IL_PREM_COLL_BEAN,
							CommonUtils.getConnection());
					message = Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$delete");
					getWarningMap().put("deleteRow", message);

					getWarningMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					fetchList.remove(PT_IL_PREM_COLL_BEAN);

				}

				if (fetchList.size() > 0) {
					setPT_IL_PREM_COLL_BEAN(fetchList.get(0));
				} else {
					// AddRow(ae);
				}
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$delete");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
				getWarningMap().put("deleteRow", message);
				// resetAllComponent();

			} else {
				getErrorMap().clear();
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
	}

	CRUDHandler handler = new CRUDHandler();
	private int rowIndex;
	List<Integer> DeleteRowId = new ArrayList<Integer>();

	public void Save_Or_UpdateRecord() {

		System.out.println("....................\n\n");
		System.out.println("Into Save Record ");
		System.out.println("\n\n....................");
		Add_Or_Update(null);

		// PT_IL_PREM_COLL_BEAN = fetchList.get(getDataTable().getRowIndex());
		/*
		 * try { handler.executeInsert(PT_IL_PREM_COLL_BEAN, CommonUtils
		 * .getConnection()); } catch (Exception exception) { // TODO: handle
		 * exception exception.printStackTrace(); }
		 */

		try {
			CommonUtils.getConnection().commit();
		} catch (Exception commit_exception) {
			// TODO: handle exception
			commit_exception.printStackTrace();
		}
		System.out.println("Into Save Record Completed");
	}

	// Save on Tabout and data is not commited

	// Global variables are not set so throws exception
	public void Add_Or_Update(ActionEvent e) {

		PT_IL_PREM_COLL_BEAN = fetchList.get(getDataTable().getRowIndex());
		try {
			if (PT_IL_PREM_COLL_BEAN.getROWID() == ""
					|| PT_IL_PREM_COLL_BEAN.getROWID().length() == 0) {
				handler.executeInsert(PT_IL_PREM_COLL_BEAN, CommonUtils
						.getConnection());
			} else {
				handler.executeUpdate(PT_IL_PREM_COLL_BEAN, CommonUtils
						.getConnection());
			}
			System.out.println("NO Problem Insert Works!!");
		} catch (Exception exception) {
			// TODO: handle exception
			exception.printStackTrace();
		}
	}

	// This Method is not called anywere in jsp.Need clear picture to where to
	// call it
	public List Fetch() {

		System.out.println("Fetching the data ");

		DUMMY1_ACTION dummyAction1 = new DUMMY1_ACTION();
		String select_Query = dummyAction1.trig_pre_query_pt_il_prem_coll();
		// String select_Query ="select
		// PM_LIFE_TAX_APPL_PROD.rowid,rownum,PM_LIFE_TAX_APPL_PROD.* from
		// PM_LIFE_TAX_APPL_PROD where rownum<=25";
		try {
			fetchList = handler.fetch(select_Query,
					"com.iii.pel.forms.PILT020.PT_IL_PREM_COLL", CommonUtils
							.getConnection());

		} catch (Exception e) {

			e.printStackTrace();
		}

		return fetchList;
	}

	// Assign The RowId that has to be Deleted

	boolean checked = false;

	public void assign_RowID(ActionEvent event) throws Exception {
		System.out.println("The Delete Call");
		String mappedBeanName = "PILT020_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean = (PILT020_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		DUMMY1_ACTION dummy1 = actionBean.getDUMMY1_ACTION_BEAN();
		DUMMY_ACTION dummy = actionBean.getDUMMY_ACTION_BEAN();
		String componentValue = (String) ((UIInput) (event.getComponent()
				.getParent())).getSubmittedValue();
		boolean isChecked = Boolean.parseBoolean(componentValue);
		boolean keepLooking = true;
		int row_Index = getDataTable().getRowIndex();
		System.out
				.println("PT_IL_PREM_COLL_ACTION.assign_RowID()---[current row]"
						+ row_Index);
		int iCount = 0;
		PT_IL_PREM_COLL premBean = (PT_IL_PREM_COLL) getDataTable()
				.getRowData();
		if (isChecked) {
			if (DeleteRowId.size() == 0) {
				DeleteRowId.add(row_Index);
				// fetchList.get(row_Index).setChecked(true);
			} else {
				// String
				// message=Messages.getString(PELConstants.pelErrorMessagePath,
				// "91054");
				String message = "Please Select only one record at a time";
				// fetchList.get(row_Index).setChecked(false);
				dummy1.getErrorMap().clear();
				dummy1.getErrorMap().put("current", message);
				dummy1.getErrorMap().put("someKey", message);
				throw new Exception(message);
			}
		} else {
			while (iCount < DeleteRowId.size() && keepLooking) {
				int rowIndex = DeleteRowId.get(iCount);
				dummy1.getErrorMap().clear();
				// fetchList.get(row_Index).setChecked(false);
				if (rowIndex == row_Index) {
					DeleteRowId.remove(iCount);
					keepLooking = false;
				}
				iCount++;
			}
		}
		System.out.println("The Row Index is " + getDataTable().getRowData());
		System.out.println("PT_IL_PREM_COLL_ACTION.assign_RowID()--- dummy: "
				+ dummy);
		dummy.setPT_IL_PREM_COLL_BEAN(premBean);

	}

	public void delete_Record() {
		System.out.println(DeleteRowId.size());

		Iterator<Integer> delItr = DeleteRowId.iterator();

		int rowDeleted = 0;
		try {
			while (delItr.hasNext()) {
				int del_RowId = Integer.parseInt(delItr.next().toString());
				System.out.println("Row ID to be Deleted..........>>>> "
						+ del_RowId);
				setRowIndex(del_RowId);
				System.out.println("Row Index to be Deleted..........>>>> "
						+ getRowIndex());
				try {
					PT_IL_PREM_COLL_BEAN = (PT_IL_PREM_COLL) fetchList
							.get(getRowIndex());
					handler.executeDelete(PT_IL_PREM_COLL_BEAN, CommonUtils
							.getConnection());
					fetchList.remove(getRowIndex());
				} catch (IndexOutOfBoundsException boundExp) {
					System.out.println("List is out of Bound");
					DeleteRowId.clear();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.getConnection().commit();
				DeleteRowId.clear();
			} catch (Exception exception) {
				// TODO: handle exception
				exception.printStackTrace();
			}
		}

	}

	/*
	 * public void setFetchList(List<PT_IL_PREM_COLL> fetchList) {
	 * this.fetchList = fetchList; }
	 */

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	public HtmlSelectBooleanCheckbox getCOMP_CHECK_BOX() {
		return COMP_CHECK_BOX;
	}

	public void setCOMP_CHECK_BOX(HtmlSelectBooleanCheckbox comp_check_box) {
		COMP_CHECK_BOX = comp_check_box;
	}

	public HtmlOutputLabel getCOMP_PL_STATUS_LABEL() {
		return COMP_PL_STATUS_LABEL;
	}

	public void setCOMP_PL_STATUS_LABEL(HtmlOutputLabel comp_pl_status_label) {
		COMP_PL_STATUS_LABEL = comp_pl_status_label;
	}

	public HtmlSelectOneMenu getCOMP_PL_STATUS() {
		return COMP_PL_STATUS;
	}

	public void setCOMP_PL_STATUS(HtmlSelectOneMenu comp_pl_status) {
		COMP_PL_STATUS = comp_pl_status;
	}

	public void getDetails(ActionEvent event) {
		try {
			int rowIndex = dataTable.getRowIndex();
			if (fetchList.size() != 0) {
				PT_IL_PREM_COLL_BEAN = (PT_IL_PREM_COLL) dataTable.getRowData();
				resetRowSelection();
				PT_IL_PREM_COLL_BEAN.setRowSelected(true);
				// componentResetVales();
				resetAllComponent();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void resetRowSelection() {
		if (fetchList != null && fetchList.size() > 0) {
			for (int index = 0, size = fetchList.size(); index < size; index++) {
				fetchList.get(index).setRowSelected(false);
			}
		}
	}

	public String trig_pre_query_pt_il_prem_coll() {
		String mappedBeanName = "PILT020_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean = (PILT020_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		String query = " SELECT ROWID,PC_SYS_ID,PC_RI_CLOSE_FLAG,PC_PREM_TYPE,PC_POL_SYS_ID,PC_SCHD_PYMT_DT,PC_PAID_DT,PC_FAC_CLOSE_FLAG,PC_FC_AVLB_BAL_AMT,PC_FC_PAID_AMT,PC_LC_PAID_AMT,PC_PAID_FLAG,PC_REF_NO,PC_FC_BASIC_PREM,PC_LC_BASIC_PREM,PC_FC_CHARGE_AMT,PC_LC_CHARGE_AMT,PC_FC_ADDL_PREM,PC_LC_ADDL_PREM,PC_FC_CHARGE,PC_LC_CHARGE,PC_FC_LOAD_AMT,PC_LC_LOAD_AMT,PC_FC_DISCOUNT,PC_LC_DISCOUNT,PC_FC_GROSS_PREM,PC_LC_GROSS_PREM,PC_FC_UNPAID_PREM_INT,PC_LC_UNPAID_PREM_INT,PC_LC_AVLB_BAL_AMT FROM PT_IL_PREM_COLL ";
		DUMMY1_ACTION dummyBean = (DUMMY1_ACTION) actionBean
				.getDUMMY1_ACTION_BEAN();

		String where = "WHERE ";

		where = where + "PC_EMPLOYER_CODE='"
				+ dummyBean.getDUMMY1_BEAN().getUI_M_EMPLOYER_CODE()
				+ "' AND PC_PAID_FLAG != 'A'";

		/*
		 * String where = null; // Before Approval if
		 * ("N".equals(MigratingFunctions.nvl(CommonUtils
		 * .getGlobalVariable("GLOBAL.M_SUCC"), "N"))) {
		 * 
		 * if (dummyBean.getCOMP_UI_M_EMPLOYER_CODE().getSubmittedValue() !=
		 * null) { where = "PC_EMPLOYER_CODE = '" +
		 * dummyBean.getCOMP_UI_M_EMPLOYER_CODE() .getSubmittedValue() + "' AND
		 * PC_PAID_FLAG != 'A'"; } else { where = "PC_CONT_CODE = '" +
		 * dummyBean.getCOMP_UI_M_CONTRACTOR_CODE() .getSubmittedValue() + "'
		 * AND PC_PAID_FLAG !='A' AND PC_SCHD_PYMT_DT BETWEEN='" +
		 * dummyBean.getCOMP_UI_M_DUE_PERIOD_FM() .getSubmittedValue() + "' AND '" +
		 * dummyBean.getCOMP_UI_M_DUE_PERIOD_TO() .getSubmittedValue() + "'"; }
		 * }// After Approval else if
		 * (dummyBean.getCOMP_UI_M_EMPLOYER_CODE().getSubmittedValue() != null) {
		 * where = "PC_EMPLOYER_CODE = '" +
		 * dummyBean.getCOMP_UI_M_EMPLOYER_CODE() .getSubmittedValue() + "' AND
		 * PC_PAID_FLAG != 'A'"; } else { where = "PC_CONT_CODE = '" +
		 * dummyBean.getCOMP_UI_M_CONTRACTOR_CODE() .getSubmittedValue() + "'
		 * AND PC_PAID_FLAG !='A' AND PC_SCHD_PYMT_DT BETWEEN='" +
		 * dummyBean.getCOMP_UI_M_DUE_PERIOD_FM() .getSubmittedValue() + "' AND '" +
		 * dummyBean.getCOMP_UI_M_DUE_PERIOD_TO() .getSubmittedValue() + "'"; }
		 * 
		 */
		query = query + " " + where;
		System.out.println("Formed Query is ............." + query);

		return query;
	}

	public void PT_IL_PREM_ONTAB(ActionEvent e) {
		CommonUtils util = new CommonUtils();
		String selectQuery = trig_pre_query_pt_il_prem_coll();
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		String mappedBeanName = "PILT020_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean = (PILT020_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		DUMMY1 dummy1Bean = actionBean.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN();
		PT_IL_PREM_COLL PT_IL_PREM_COLL_POP = new PT_IL_PREM_COLL();
		PT_IL_PREM_COLL_ACTION PREM_COLL = new PT_IL_PREM_COLL_ACTION();

		/*
		 * String PREM_COLL_SYS_ID = COMPOSITE_BEAN
		 * .getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN()
		 * .getPC_SYS_ID(); int CHARGE_SYS_ID;
		 * 
		 * 
		 * try { CHARGE_SYS_ID = Integer.parseInt(COMPOSITE_BEAN
		 * .getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN()
		 * .getPT_IL_PREM_COLL_CHARGE_BEAN().getPCC_SYS_ID() .toString()); }
		 * catch (Exception e1) { // TODO: handle exception
		 * System.out.println("Into Catch"); CHARGE_SYS_ID = 242; }
		 * 
		 * 
		 * System.out.println("........................\n\n");
		 * System.out.println("PERMENANT SYSID .........." + PREM_COLL_SYS_ID);
		 * System.out.println("CHARGE SYSID .........." + CHARGE_SYS_ID);
		 * 
		 * System.out.println("\n\n........................");
		 * 
		 */

		// populate the next bean for the next page
		System.out.println("selectQuery.........................."
				+ selectQuery);
		DBProcedures proc = new DBProcedures();
		List<PT_IL_PREM_COLL> Prem_coll_list = new ArrayList<PT_IL_PREM_COLL>();
		try {
			rs = handler.executeSelectStatement(selectQuery, CommonUtils
					.getConnection());
			while (rs.next()) {
				PT_IL_PREM_COLL_BEAN = new PT_IL_PREM_COLL();
				PT_IL_PREM_COLL_BEAN.setROWID(rs.getString("ROWID"));
				PT_IL_PREM_COLL_BEAN.setPC_FAC_CLOSE_FLAG(rs
						.getString("PC_FAC_CLOSE_FLAG"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_ADDL_PREM(rs
						.getDouble("PC_FC_ADDL_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_AVLB_BAL_AMT(rs
						.getDouble("PC_FC_AVLB_BAL_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_BASIC_PREM(rs
						.getDouble("PC_FC_BASIC_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_CHARGE(rs
						.getDouble("PC_FC_CHARGE"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_CHARGE_AMT(rs
						.getDouble("PC_FC_CHARGE_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_DISCOUNT(rs
						.getDouble("PC_FC_DISCOUNT"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_GROSS_PREM(rs
						.getDouble("PC_FC_GROSS_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_LOAD_AMT(rs
						.getDouble("PC_FC_LOAD_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_PAID_AMT(rs
						.getDouble("PC_FC_PAID_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_FC_UNPAID_PREM_INT(rs
						.getDouble("PC_FC_UNPAID_PREM_INT"));
				List<String> fc_unpaid_prem = proc.callP_VAL_ROUND_AMT(
						actionBean.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN()
								.getUI_M_POL_CURR_CODE(), PT_IL_PREM_COLL_BEAN
								.getPC_FC_UNPAID_PREM_INT().toString(), "R");
				PT_IL_PREM_COLL_BEAN.setPC_FC_UNPAID_PREM_INT(Double
						.valueOf(fc_unpaid_prem.get(0)));
				PT_IL_PREM_COLL_BEAN.setPC_LC_ADDL_PREM(rs
						.getDouble("PC_LC_ADDL_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_AVLB_BAL_AMT(rs
						.getDouble("PC_LC_AVLB_BAL_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_BASIC_PREM(rs
						.getDouble("PC_LC_BASIC_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_CHARGE(rs
						.getDouble("PC_LC_CHARGE"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_CHARGE_AMT(rs
						.getDouble("PC_LC_CHARGE_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_DISCOUNT(rs
						.getDouble("PC_LC_DISCOUNT"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_GROSS_PREM(rs
						.getDouble("PC_LC_GROSS_PREM"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_LOAD_AMT(rs
						.getDouble("PC_LC_LOAD_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_PAID_AMT(rs
						.getDouble("PC_LC_PAID_AMT"));
				PT_IL_PREM_COLL_BEAN.setPC_LC_UNPAID_PREM_INT(rs
						.getDouble("PC_LC_UNPAID_PREM_INT"));
				List<String> lc_unpaid_prem = proc.callP_VAL_ROUND_AMT(
						actionBean.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN()
								.getUI_M_POL_CURR_CODE(), PT_IL_PREM_COLL_BEAN
								.getPC_LC_UNPAID_PREM_INT().toString(), "R");
				PT_IL_PREM_COLL_BEAN.setPC_LC_UNPAID_PREM_INT(Double
						.valueOf(lc_unpaid_prem.get(0)));
				PT_IL_PREM_COLL_BEAN.setPC_PAID_DT(rs.getDate("PC_PAID_DT"));
				PT_IL_PREM_COLL_BEAN.setPC_PAID_FLAG(rs
						.getString("PC_PAID_FLAG"));
				PT_IL_PREM_COLL_BEAN.setPC_POL_SYS_ID(rs
						.getDouble("PC_POL_SYS_ID"));
				PT_IL_PREM_COLL_BEAN.setPC_PREM_TYPE(rs
						.getString("PC_PREM_TYPE"));
				PT_IL_PREM_COLL_BEAN.setPC_REF_NO(rs.getString("PC_REF_NO"));
				PT_IL_PREM_COLL_BEAN.setPC_RI_CLOSE_FLAG(rs
						.getString("PC_RI_CLOSE_FLAG"));
				PT_IL_PREM_COLL_BEAN.setPC_SCHD_PYMT_DT(rs
						.getDate("PC_SCHD_PYMT_DT"));
				PT_IL_PREM_COLL_BEAN.setPC_SYS_ID(rs.getInt("PC_SYS_ID"));
				PT_IL_PREM_COLL_BEAN.setUI_M_FC_LOAN_INT(111.0);
				// P_VAL_ROUND_AMT procedure can be used instead of
				// java.lang.Math.rint(bean.getUI_M_FC_NET_PREM());
				PT_IL_PREM_COLL_BEAN.setUI_M_LC_LOAN_INT(111.00);
				PT_IL_PREM_COLL_BEAN.setUI_M_LC_NET_PREM(PT_IL_PREM_COLL_BEAN
						.getPC_LC_GROSS_PREM()
						+ PT_IL_PREM_COLL_BEAN.getPC_LC_CHARGE()
						+ PT_IL_PREM_COLL_BEAN.getPC_LC_UNPAID_PREM_INT());
				PT_IL_PREM_COLL_BEAN.setUI_M_FC_NET_PREM(PT_IL_PREM_COLL_BEAN
						.getPC_FC_GROSS_PREM()
						+ PT_IL_PREM_COLL_BEAN.getPC_FC_CHARGE()
						+ PT_IL_PREM_COLL_BEAN.getPC_FC_UNPAID_PREM_INT());
				List<String> lc_net_prem = proc.callP_VAL_ROUND_AMT(actionBean
						.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN()
						.getUI_M_POL_CURR_CODE(), PT_IL_PREM_COLL_BEAN
						.getUI_M_LC_NET_PREM().toString(), "R");
				List<String> fc_net_prem = proc.callP_VAL_ROUND_AMT(actionBean
						.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN()
						.getUI_M_POL_CURR_CODE(), PT_IL_PREM_COLL_BEAN
						.getUI_M_FC_NET_PREM().toString(), "R");
				PT_IL_PREM_COLL_BEAN.setUI_M_LC_NET_PREM(Double
						.valueOf(lc_net_prem.get(0)));
				PT_IL_PREM_COLL_BEAN.setUI_M_FC_NET_PREM(Double
						.valueOf(fc_net_prem.get(0)));
				PT_IL_PREM_COLL_BEAN.setUI_M_POL_CUST_CURR_CODE(dummy1Bean
						.getUI_M_POL_CURR_CODE());
				PT_IL_PREM_COLL_BEAN
						.setUI_M_POL_CUST_EXCH_RATE(PT_IL_PREM_COLL_POP
								.getUI_M_POL_CUST_EXCH_RATE());
				Prem_coll_list.add(PT_IL_PREM_COLL_BEAN);

			}

			if (Prem_coll_list.size() > 0) {
				fetchList = Prem_coll_list;
				resetAllComponent();
				this.setPT_IL_PREM_COLL_BEAN(fetchList.get(0));
				fetchList.get(0).setRowSelected(true);
			}

			// double M_FC_NET_PREM =

			/*
			 * Prem_coll_list = handler.fetch(selectQuery,
			 * "com.iii.pel.forms.PILT020.PT_IL_PREM_COLL",
			 * CommonUtils.getConnection());
			 */
			// PM_LIFE_TAX_COMPOSITE_BEAN.getPM_LIFE_TAX_APPL_PROD_COMPOSITE().setFetchList(list);
		} catch (Exception e12) {
			// TODO: handle exception
			e12.printStackTrace();
		}

		// return "PT_TL_CHARGE_SETUP";

	}

	/**
	 * Instantiates all components in PT_IL_PREM_COLL_ACTION
	 */
	public void instantiateAllComponent() {
		// Instantiating HtmlInputText
		COMP_UI_M_FC_NET_PREM = new HtmlInputText();
		COMP_PC_FC_AVLB_BAL_AMT = new HtmlInputText();
		COMP_PC_FC_PAID_AMT = new HtmlInputText();
		COMP_PC_LC_PAID_AMT = new HtmlInputText();
		COMP_PC_REF_NO = new HtmlInputText();
		COMP_UI_M_POL_CUST_EXCH_RATE = new HtmlInputText();
		COMP_UI_M_POL_CUST_CURR_CODE = new HtmlInputText();
		COMP_PC_FC_BASIC_PREM = new HtmlInputText();
		COMP_PC_LC_BASIC_PREM = new HtmlInputText();
		COMP_PC_FC_CHARGE_AMT = new HtmlInputText();
		COMP_PC_LC_CHARGE_AMT = new HtmlInputText();
		COMP_PC_FC_ADDL_PREM = new HtmlInputText();
		COMP_PC_LC_ADDL_PREM = new HtmlInputText();
		COMP_PC_FC_CHARGE = new HtmlInputText();
		COMP_PC_LC_CHARGE = new HtmlInputText();
		COMP_PC_FC_LOAD_AMT = new HtmlInputText();
		COMP_PC_LC_LOAD_AMT = new HtmlInputText();
		COMP_PC_FC_DISCOUNT = new HtmlInputText();
		COMP_PC_LC_DISCOUNT = new HtmlInputText();
		COMP_PC_FC_GROSS_PREM = new HtmlInputText();
		COMP_PC_LC_GROSS_PREM = new HtmlInputText();
		COMP_UI_M_FC_LOAN_INT = new HtmlInputText();
		COMP_UI_M_LC_LOAN_INT = new HtmlInputText();
		COMP_PC_FC_UNPAID_PREM_INT = new HtmlInputText();
		COMP_PC_LC_UNPAID_PREM_INT = new HtmlInputText();
		COMP_UI_M_LC_NET_PREM = new HtmlInputText();
		COMP_PC_LC_AVLB_BAL_AMT = new HtmlInputText();
		COMP_UI_M_PC_POL_NO = new HtmlInputText();

		// Instantiating HtmlSelectOneMenu
		COMP_PC_PAID_FLAG = new HtmlSelectOneMenu();
		COMP_PL_STATUS = new HtmlSelectOneMenu();

		// Instantiating HtmlCalendar
		COMP_PC_SCHD_PYMT_DT = new HtmlCalendar();
		COMP_PC_PAID_DT = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_LOV_EMPLOYER_CODE = new HtmlCommandButton();
		COMP_UI_M_BUT_LOV_CONTRACTOR_CODE = new HtmlCommandButton();
		COMP_UI_M_BUT_LOV_POL_CUST_CURR_CODE = new HtmlCommandButton();
		COMP_UI_M_BUT_REINSTATE = new HtmlCommandButton();
		COMP_UI_M_BUT_INT_DTLS = new HtmlCommandButton();
		COMP_UI_M_BUT_BROKER_DTLS = new HtmlCommandButton();
		COMP_UI_M_BUT_PYMT_DTLS = new HtmlCommandButton();
		COMP_UI_M_BUT_CHG_DTL = new HtmlCommandButton();
		COMP_UI_M_BUT_FAC = new HtmlCommandButton();
		COMP_UI_M_BUT_LOAN_INT = new HtmlCommandButton();
		COMP_UI_M_BUT_APPROVE = new HtmlCommandButton();
		COMP_POPUP=new HtmlAjaxCommandButton();

	}

	/**
	 * Resets all components in PT_IL_PREM_COLL_ACTION
	 */
	public void resetAllComponent() {
		// Reseting HtmlInputText
		COMP_UI_M_FC_NET_PREM.resetValue();
		COMP_PC_FC_AVLB_BAL_AMT.resetValue();
		COMP_PC_FC_PAID_AMT.resetValue();
		COMP_PC_LC_PAID_AMT.resetValue();
		COMP_PC_REF_NO.resetValue();
		COMP_UI_M_POL_CUST_EXCH_RATE.resetValue();
		COMP_UI_M_POL_CUST_CURR_CODE.resetValue();
		COMP_PC_FC_BASIC_PREM.resetValue();
		COMP_PC_LC_BASIC_PREM.resetValue();
		COMP_PC_FC_CHARGE_AMT.resetValue();
		COMP_PC_LC_CHARGE_AMT.resetValue();
		COMP_PC_FC_ADDL_PREM.resetValue();
		COMP_PC_LC_ADDL_PREM.resetValue();
		COMP_PC_FC_CHARGE.resetValue();
		COMP_PC_LC_CHARGE.resetValue();
		COMP_PC_FC_LOAD_AMT.resetValue();
		COMP_PC_LC_LOAD_AMT.resetValue();
		COMP_PC_FC_DISCOUNT.resetValue();
		COMP_PC_LC_DISCOUNT.resetValue();
		COMP_PC_FC_GROSS_PREM.resetValue();
		COMP_PC_LC_GROSS_PREM.resetValue();
		COMP_UI_M_FC_LOAN_INT.resetValue();
		COMP_UI_M_LC_LOAN_INT.resetValue();
		COMP_PC_FC_UNPAID_PREM_INT.resetValue();
		COMP_PC_LC_UNPAID_PREM_INT.resetValue();
		COMP_UI_M_LC_NET_PREM.resetValue();
		COMP_PC_LC_AVLB_BAL_AMT.resetValue();
		COMP_UI_M_PC_POL_NO.resetValue();

		// Reseting HtmlSelectOneMenu
		COMP_PC_PAID_FLAG.resetValue();
		COMP_PL_STATUS.resetValue();

		// Reseting HtmlCalendar
		COMP_PC_SCHD_PYMT_DT.resetValue();
		COMP_PC_PAID_DT.resetValue();

		// Reseting HtmlCommandButton
		/*
		 * COMP_UI_M_BUT_LOV_EMPLOYER_CODE.resetValue();
		 * COMP_UI_M_BUT_LOV_CONTRACTOR_CODE.resetValue();
		 * COMP_UI_M_BUT_LOV_POL_CUST_CURR_CODE.resetValue();
		 * COMP_UI_M_BUT_REINSTATE.resetValue();
		 * COMP_UI_M_BUT_INT_DTLS.resetValue();
		 * COMP_UI_M_BUT_BROKER_DTLS.resetValue();
		 * COMP_UI_M_BUT_PYMT_DTLS.resetValue();
		 * COMP_UI_M_BUT_CHG_DTL.resetValue(); COMP_UI_M_BUT_FAC.resetValue();
		 * COMP_UI_M_BUT_LOAN_INT.resetValue();
		 * COMP_UI_M_BUT_APPROVE.resetValue();
		 */

	}

	public HtmlAjaxCommandButton getCOMP_POPUP() {
		return COMP_POPUP;
	}

	public void setCOMP_POPUP(HtmlAjaxCommandButton comp_popup) {
		COMP_POPUP = comp_popup;
	}

}
