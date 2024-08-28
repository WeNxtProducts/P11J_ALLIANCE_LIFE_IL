package com.iii.pel.forms.PILT024;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlInputText;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_PREM_COLL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PC_SCHD_PYMT_DT_LABEL;

	private HtmlCalendar COMP_PC_SCHD_PYMT_DT;

	private HtmlOutputLabel COMP_PC_WAIVE_PREM_YN_LABEL;

	private HtmlSelectOneMenu COMP_PC_WAIVE_PREM_YN;

	private HtmlOutputLabel COMP_PC_WAIVE_LOAN_YN_LABEL;

	private HtmlSelectOneMenu COMP_PC_WAIVE_LOAN_YN;

	private HtmlOutputLabel COMP_PC_FC_BASIC_PREM_LABEL;

	private HtmlInputText COMP_PC_FC_BASIC_PREM;

	private HtmlOutputLabel COMP_PC_LC_BASIC_PREM_LABEL;

	private HtmlInputText COMP_PC_LC_BASIC_PREM;

	private HtmlOutputLabel COMP_UI_M_PC_FC_PAID_BASIC_PREM_LABEL;

	private HtmlInputText COMP_UI_M_PC_FC_PAID_BASIC_PREM;

	private HtmlOutputLabel COMP_UI_M_PC_LC_PAID_BASIC_PREM_LABEL;

	private HtmlInputText COMP_UI_M_PC_LC_PAID_BASIC_PREM;

	private HtmlOutputLabel COMP_UI_M_PC_FC_BAL_BASIC_PREM_LABEL;

	private HtmlInputText COMP_UI_M_PC_FC_BAL_BASIC_PREM;

	private HtmlOutputLabel COMP_UI_M_PC_LC_BAL_BASIC_PREM_LABEL;

	private HtmlInputText COMP_UI_M_PC_LC_BAL_BASIC_PREM;

	private HtmlOutputLabel COMP_PC_FC_ADDL_PREM_LABEL;

	private HtmlInputText COMP_PC_FC_ADDL_PREM;

	private HtmlOutputLabel COMP_PC_LC_ADDL_PREM_LABEL;

	private HtmlInputText COMP_PC_LC_ADDL_PREM;

	private HtmlOutputLabel COMP_UI_M_PC_FC_PAID_ADDL_PREM_LABEL;

	private HtmlInputText COMP_UI_M_PC_FC_PAID_ADDL_PREM;

	private HtmlOutputLabel COMP_UI_M_PC_LC_PAID_ADDL_PREM_LABEL;

	private HtmlInputText COMP_UI_M_PC_LC_PAID_ADDL_PREM;

	private HtmlOutputLabel COMP_UI_M_PC_FC_BAL_ADDL_PREM_LABEL;

	private HtmlInputText COMP_UI_M_PC_FC_BAL_ADDL_PREM;

	private HtmlOutputLabel COMP_UI_M_PC_LC_BAL_ADDL_PREM_LABEL;

	private HtmlInputText COMP_UI_M_PC_LC_BAL_ADDL_PREM;

	private HtmlOutputLabel COMP_PC_FC_LOAD_AMT_LABEL;

	private HtmlInputText COMP_PC_FC_LOAD_AMT;

	private HtmlOutputLabel COMP_PC_LC_LOAD_AMT_LABEL;

	private HtmlInputText COMP_PC_LC_LOAD_AMT;

	private HtmlOutputLabel COMP_UI_M_PC_FC_PAID_LOAD_LABEL;

	private HtmlInputText COMP_UI_M_PC_FC_PAID_LOAD;

	private HtmlOutputLabel COMP_UI_M_PC_LC_PAID_LOAD_LABEL;

	private HtmlInputText COMP_UI_M_PC_LC_PAID_LOAD;

	private HtmlOutputLabel COMP_UI_M_PC_FC_BAL_LOAD_AMT_LABEL;

	private HtmlInputText COMP_UI_M_PC_FC_BAL_LOAD_AMT;

	private HtmlOutputLabel COMP_UI_M_PC_LC_BAL_LOAD_AMT_LABEL;

	private HtmlInputText COMP_UI_M_PC_LC_BAL_LOAD_AMT;

	private HtmlOutputLabel COMP_PC_FC_DISCOUNT_LABEL;

	private HtmlInputText COMP_PC_FC_DISCOUNT;

	private HtmlOutputLabel COMP_PC_LC_DISCOUNT_LABEL;

	private HtmlInputText COMP_PC_LC_DISCOUNT;

	private HtmlOutputLabel COMP_UI_M_PC_FC_PAID_DISC_LABEL;

	private HtmlInputText COMP_UI_M_PC_FC_PAID_DISC;

	private HtmlOutputLabel COMP_UI_M_PC_LC_PAID_DISC_LABEL;

	private HtmlInputText COMP_UI_M_PC_LC_PAID_DISC;

	private HtmlOutputLabel COMP_UI_M_PC_FC_BAL_DISC_LABEL;

	private HtmlInputText COMP_UI_M_PC_FC_BAL_DISC;

	private HtmlOutputLabel COMP_UI_M_PC_LC_BAL_DISC_LABEL;

	private HtmlInputText COMP_UI_M_PC_LC_BAL_DISC;

	private HtmlOutputLabel COMP_PC_FC_CHARGE_LABEL;

	private HtmlInputText COMP_PC_FC_CHARGE;

	private HtmlOutputLabel COMP_PC_LC_CHARGE_LABEL;

	private HtmlInputText COMP_PC_LC_CHARGE;

	private HtmlOutputLabel COMP_UI_M_PC_FC_PAID_CUST_CHRG_LABEL;

	private HtmlInputText COMP_UI_M_PC_FC_PAID_CUST_CHRG;

	private HtmlOutputLabel COMP_UI_M_PC_LC_PAID_CUST_CHRG_LABEL;

	private HtmlInputText COMP_UI_M_PC_LC_PAID_CUST_CHRG;

	private HtmlOutputLabel COMP_UI_M_PC_FC_BAL_CUST_CHRG_LABEL;

	private HtmlInputText COMP_UI_M_PC_FC_BAL_CUST_CHRG;

	private HtmlOutputLabel COMP_UI_M_PC_LC_BAL_CUST_CHRG_LABEL;

	private HtmlInputText COMP_UI_M_PC_LC_BAL_CUST_CHRG;

	private HtmlOutputLabel COMP_PC_FC_DUE_CONTR_LABEL;

	private HtmlInputText COMP_PC_FC_DUE_CONTR;

	private HtmlOutputLabel COMP_PC_LC_DUE_CONTR_LABEL;

	private HtmlInputText COMP_PC_LC_DUE_CONTR;

	private HtmlOutputLabel COMP_UI_M_PC_FC_PAID_CONTR_LABEL;

	private HtmlInputText COMP_UI_M_PC_FC_PAID_CONTR;

	private HtmlOutputLabel COMP_UI_M_PC_LC_PAID_CONTR_LABEL;

	private HtmlInputText COMP_UI_M_PC_LC_PAID_CONTR;

	private HtmlOutputLabel COMP_UI_M_PC_FC_BAL_CONTR_LABEL;

	private HtmlInputText COMP_UI_M_PC_FC_BAL_CONTR;

	private HtmlOutputLabel COMP_UI_M_PC_LC_BAL_CONTR_LABEL;

	private HtmlInputText COMP_UI_M_PC_LC_BAL_CONTR;

	private HtmlOutputLabel COMP_UI_M_TOPUP_DUE_FC_AMT_LABEL;

	private HtmlInputText COMP_UI_M_TOPUP_DUE_FC_AMT;

	private HtmlOutputLabel COMP_UI_M_TOPUP_DUE_LC_AMT_LABEL;

	private HtmlInputText COMP_UI_M_TOPUP_DUE_LC_AMT;

	private HtmlOutputLabel COMP_UI_M_TOPUP_PAID_FC_AMT_LABEL;

	private HtmlInputText COMP_UI_M_TOPUP_PAID_FC_AMT;

	private HtmlOutputLabel COMP_UI_M_TOPUP_PAID_LC_AMT_LABEL;

	private HtmlInputText COMP_UI_M_TOPUP_PAID_LC_AMT;

	private HtmlOutputLabel COMP_UI_M_TOPUP_BAL_LC_AMT_LABEL;

	private HtmlInputText COMP_UI_M_TOPUP_BAL_LC_AMT;

	private HtmlOutputLabel COMP_UI_M_TOPUP_BAL_FC_AMT_LABEL;

	private HtmlInputText COMP_UI_M_TOPUP_BAL_FC_AMT;

	private HtmlOutputLabel COMP_PC_FC_INV_DUE_CHRG_LABEL;

	private HtmlInputText COMP_PC_FC_INV_DUE_CHRG;

	private HtmlOutputLabel COMP_PC_LC_INV_DUE_CHRG_LABEL;

	private HtmlInputText COMP_PC_LC_INV_DUE_CHRG;

	private HtmlOutputLabel COMP_UI_M_PC_FC_INV_PAID_CHRG_LABEL;

	private HtmlInputText COMP_UI_M_PC_FC_INV_PAID_CHRG;

	private HtmlOutputLabel COMP_UI_M_PC_LC_INV_PAID_CHRG_LABEL;

	private HtmlInputText COMP_UI_M_PC_LC_INV_PAID_CHRG;

	private HtmlOutputLabel COMP_UI_M_PC_FC_INV_BAL_CHRG_LABEL;

	private HtmlInputText COMP_UI_M_PC_FC_INV_BAL_CHRG;

	private HtmlOutputLabel COMP_UI_M_PC_LC_INV_BAL_CHRG_LABEL;

	private HtmlInputText COMP_UI_M_PC_LC_INV_BAL_CHRG;

	private HtmlOutputLabel COMP_PC_FLEX_12_LABEL;

	private HtmlInputText COMP_PC_FLEX_12;

	private HtmlOutputLabel COMP_PC_FLEX_30_LABEL;

	private HtmlInputText COMP_PC_FLEX_30;

	private HtmlOutputLabel COMP_PC_FLEX_29_LABEL;

	private HtmlInputText COMP_PC_FLEX_29;

	private HtmlOutputLabel COMP_PC_FLEX_01_LABEL;

	private HtmlInputText COMP_PC_FLEX_01;

	private HtmlOutputLabel COMP_PC_FLEX_02_LABEL;

	private HtmlInputText COMP_PC_FLEX_02;

	private HtmlOutputLabel COMP_PC_FLEX_03_LABEL;

	private HtmlInputText COMP_PC_FLEX_03;

	private HtmlOutputLabel COMP_PC_FLEX_04_LABEL;

	private HtmlInputText COMP_PC_FLEX_04;

	private HtmlOutputLabel COMP_PC_FLEX_05_LABEL;

	private HtmlInputText COMP_PC_FLEX_05;

	private HtmlOutputLabel COMP_PC_FLEX_06_LABEL;

	private HtmlInputText COMP_PC_FLEX_06;

	private HtmlOutputLabel COMP_PC_FLEX_07_LABEL;

	private HtmlInputText COMP_PC_FLEX_07;

	private HtmlOutputLabel COMP_PC_FLEX_08_LABEL;

	private HtmlInputText COMP_PC_FLEX_08;

	private HtmlOutputLabel COMP_PC_FLEX_09_LABEL;

	private HtmlInputText COMP_PC_FLEX_09;

	private HtmlOutputLabel COMP_PC_FLEX_10_LABEL;

	private HtmlInputText COMP_PC_FLEX_10;

	private HtmlOutputLabel COMP_PC_FLEX_11_LABEL;

	private HtmlInputText COMP_PC_FLEX_11;

	private HtmlOutputLabel COMP_PC_FLEX_13_LABEL;

	private HtmlInputText COMP_PC_FLEX_13;

	private HtmlOutputLabel COMP_PC_FLEX_14_LABEL;

	private HtmlInputText COMP_PC_FLEX_14;

	private HtmlOutputLabel COMP_PC_FLEX_15_LABEL;

	private HtmlInputText COMP_PC_FLEX_15;

	private HtmlOutputLabel COMP_PC_FLEX_16_LABEL;

	private HtmlInputText COMP_PC_FLEX_16;

	private HtmlOutputLabel COMP_PC_FLEX_17_LABEL;

	private HtmlInputText COMP_PC_FLEX_17;

	private HtmlOutputLabel COMP_PC_FLEX_18_LABEL;

	private HtmlInputText COMP_PC_FLEX_18;

	private HtmlOutputLabel COMP_PC_FLEX_19_LABEL;

	private HtmlInputText COMP_PC_FLEX_19;

	private HtmlOutputLabel COMP_PC_FLEX_20_LABEL;

	private HtmlInputText COMP_PC_FLEX_20;

	private HtmlOutputLabel COMP_PC_FLEX_21_LABEL;

	private HtmlInputText COMP_PC_FLEX_21;

	private HtmlOutputLabel COMP_PC_FLEX_22_LABEL;

	private HtmlInputText COMP_PC_FLEX_22;

	private HtmlOutputLabel COMP_PC_FLEX_23_LABEL;

	private HtmlInputText COMP_PC_FLEX_23;

	private HtmlOutputLabel COMP_PC_FLEX_24_LABEL;

	private HtmlInputText COMP_PC_FLEX_24;

	private HtmlOutputLabel COMP_PC_FLEX_25_LABEL;

	private HtmlInputText COMP_PC_FLEX_25;

	private HtmlOutputLabel COMP_PC_FLEX_26_LABEL;

	private HtmlInputText COMP_PC_FLEX_26;

	private HtmlOutputLabel COMP_PC_FLEX_27_LABEL;

	private HtmlInputText COMP_PC_FLEX_27;

	private HtmlOutputLabel COMP_PC_FLEX_28_LABEL;

	private HtmlInputText COMP_PC_FLEX_28;

	private HtmlOutputLabel COMP_UI_M_PREV_INST_DUE_DT_LABEL;

	private HtmlCalendar COMP_UI_M_PREV_INST_DUE_DT;

	private HtmlOutputLabel COMP_UI_M_PREV_PAY_DT_LABEL;

	private HtmlCalendar COMP_UI_M_PREV_PAY_DT;

	private HtmlOutputLabel COMP_UI_M_CURR_INV_DUE_DT_LABEL;

	private HtmlCalendar COMP_UI_M_CURR_INV_DUE_DT;

	private HtmlCommandButton COMP_UI_M_BUT_APPROVE;

	private HtmlCommandButton COMP_UI_M_BUT_BROKER_DTLS;

	private HtmlCommandButton COMP_UI_M_BUT_CHG_DTL;

	private HtmlCommandButton COMP_UI_M_BUT_CVR_DTL;

	private HtmlCommandButton COMP_UI_M_BUT_FAC;

	private HtmlCommandButton COMP_UI_M_BUT_INT_DTLS;

	private HtmlCommandButton COMP_UI_M_BUT_INVEST_DETAILS;

	private HtmlCommandButton COMP_UI_M_BUT_PYMT_DTLS;

	private HtmlCommandButton COMP_UI_M_BUT_RNEW_PREM_COLL;
	

	private PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN;

	public PILT024_COMPOSITE_ACTION compositeAction;

	private PT_IL_PREM_COLL_HELPER helper;
	
	private List<SelectItem> listPC_WAIVE_PREM_YN = new ArrayList<SelectItem>();
	
	private List<SelectItem> listPC_WAIVE_LOAN_YN = new ArrayList<SelectItem>();

	public List<SelectItem> getListPC_WAIVE_LOAN_YN() {
		return listPC_WAIVE_LOAN_YN;
	}

	public void setListPC_WAIVE_LOAN_YN(List<SelectItem> listPC_WAIVE_LOAN_YN) {
		this.listPC_WAIVE_LOAN_YN = listPC_WAIVE_LOAN_YN;
	}

	public List<SelectItem> getListPC_WAIVE_PREM_YN() {
		return listPC_WAIVE_PREM_YN;
	}

	public void setListPC_WAIVE_PREM_YN(List<SelectItem> listPC_WAIVE_PREM_YN) {
		this.listPC_WAIVE_PREM_YN = listPC_WAIVE_PREM_YN;
	}

	public PT_IL_PREM_COLL_ACTION() {

		PT_IL_PREM_COLL_BEAN = new PT_IL_PREM_COLL();
		helper = new PT_IL_PREM_COLL_HELPER();
		
		try {
			setListPC_WAIVE_PREM_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILT024",
					"PT_IL_PREM_COLL", "PT_IL_PREM_COLL.PC_WAIVE_PREM_YN",
					"YESNO"));
			setListPC_WAIVE_LOAN_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILT024",
					"PT_IL_PREM_COLL", "PT_IL_PREM_COLL.PC_WAIVE_LOAN_YN",
					"YESNO"));
			
		} catch (DBException e) {
			e.printStackTrace();
			try {
				throw e;
			} catch (DBException e1) {
				e1.printStackTrace();
			}
		}
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

	public HtmlOutputLabel getCOMP_PC_WAIVE_PREM_YN_LABEL() {
		return COMP_PC_WAIVE_PREM_YN_LABEL;
	}

	

	public void setCOMP_PC_WAIVE_PREM_YN_LABEL(
			HtmlOutputLabel COMP_PC_WAIVE_PREM_YN_LABEL) {
		this.COMP_PC_WAIVE_PREM_YN_LABEL = COMP_PC_WAIVE_PREM_YN_LABEL;
	}



	public HtmlSelectOneMenu getCOMP_PC_WAIVE_PREM_YN() {
		return COMP_PC_WAIVE_PREM_YN;
	}

	public void setCOMP_PC_WAIVE_PREM_YN(HtmlSelectOneMenu comp_pc_waive_prem_yn) {
		COMP_PC_WAIVE_PREM_YN = comp_pc_waive_prem_yn;
	}

	public HtmlOutputLabel getCOMP_PC_WAIVE_LOAN_YN_LABEL() {
		return COMP_PC_WAIVE_LOAN_YN_LABEL;
	}


	public void setCOMP_PC_WAIVE_LOAN_YN_LABEL(
			HtmlOutputLabel COMP_PC_WAIVE_LOAN_YN_LABEL) {
		this.COMP_PC_WAIVE_LOAN_YN_LABEL = COMP_PC_WAIVE_LOAN_YN_LABEL;
	}


	public HtmlSelectOneMenu getCOMP_PC_WAIVE_LOAN_YN() {
		return COMP_PC_WAIVE_LOAN_YN;
	}

	public void setCOMP_PC_WAIVE_LOAN_YN(HtmlSelectOneMenu comp_pc_waive_loan_yn) {
		COMP_PC_WAIVE_LOAN_YN = comp_pc_waive_loan_yn;
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

	public HtmlOutputLabel getCOMP_UI_M_PC_FC_PAID_BASIC_PREM_LABEL() {
		return COMP_UI_M_PC_FC_PAID_BASIC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_FC_PAID_BASIC_PREM() {
		return COMP_UI_M_PC_FC_PAID_BASIC_PREM;
	}

	public void setCOMP_UI_M_PC_FC_PAID_BASIC_PREM_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_FC_PAID_BASIC_PREM_LABEL) {
		this.COMP_UI_M_PC_FC_PAID_BASIC_PREM_LABEL = COMP_UI_M_PC_FC_PAID_BASIC_PREM_LABEL;
	}

	public void setCOMP_UI_M_PC_FC_PAID_BASIC_PREM(
			HtmlInputText COMP_UI_M_PC_FC_PAID_BASIC_PREM) {
		this.COMP_UI_M_PC_FC_PAID_BASIC_PREM = COMP_UI_M_PC_FC_PAID_BASIC_PREM;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_LC_PAID_BASIC_PREM_LABEL() {
		return COMP_UI_M_PC_LC_PAID_BASIC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_LC_PAID_BASIC_PREM() {
		return COMP_UI_M_PC_LC_PAID_BASIC_PREM;
	}

	public void setCOMP_UI_M_PC_LC_PAID_BASIC_PREM_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_LC_PAID_BASIC_PREM_LABEL) {
		this.COMP_UI_M_PC_LC_PAID_BASIC_PREM_LABEL = COMP_UI_M_PC_LC_PAID_BASIC_PREM_LABEL;
	}

	public void setCOMP_UI_M_PC_LC_PAID_BASIC_PREM(
			HtmlInputText COMP_UI_M_PC_LC_PAID_BASIC_PREM) {
		this.COMP_UI_M_PC_LC_PAID_BASIC_PREM = COMP_UI_M_PC_LC_PAID_BASIC_PREM;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_FC_BAL_BASIC_PREM_LABEL() {
		return COMP_UI_M_PC_FC_BAL_BASIC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_FC_BAL_BASIC_PREM() {
		return COMP_UI_M_PC_FC_BAL_BASIC_PREM;
	}

	public void setCOMP_UI_M_PC_FC_BAL_BASIC_PREM_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_FC_BAL_BASIC_PREM_LABEL) {
		this.COMP_UI_M_PC_FC_BAL_BASIC_PREM_LABEL = COMP_UI_M_PC_FC_BAL_BASIC_PREM_LABEL;
	}

	public void setCOMP_UI_M_PC_FC_BAL_BASIC_PREM(
			HtmlInputText COMP_UI_M_PC_FC_BAL_BASIC_PREM) {
		this.COMP_UI_M_PC_FC_BAL_BASIC_PREM = COMP_UI_M_PC_FC_BAL_BASIC_PREM;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_LC_BAL_BASIC_PREM_LABEL() {
		return COMP_UI_M_PC_LC_BAL_BASIC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_LC_BAL_BASIC_PREM() {
		return COMP_UI_M_PC_LC_BAL_BASIC_PREM;
	}

	public void setCOMP_UI_M_PC_LC_BAL_BASIC_PREM_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_LC_BAL_BASIC_PREM_LABEL) {
		this.COMP_UI_M_PC_LC_BAL_BASIC_PREM_LABEL = COMP_UI_M_PC_LC_BAL_BASIC_PREM_LABEL;
	}

	public void setCOMP_UI_M_PC_LC_BAL_BASIC_PREM(
			HtmlInputText COMP_UI_M_PC_LC_BAL_BASIC_PREM) {
		this.COMP_UI_M_PC_LC_BAL_BASIC_PREM = COMP_UI_M_PC_LC_BAL_BASIC_PREM;
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

	public HtmlOutputLabel getCOMP_UI_M_PC_FC_PAID_ADDL_PREM_LABEL() {
		return COMP_UI_M_PC_FC_PAID_ADDL_PREM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_FC_PAID_ADDL_PREM() {
		return COMP_UI_M_PC_FC_PAID_ADDL_PREM;
	}

	public void setCOMP_UI_M_PC_FC_PAID_ADDL_PREM_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_FC_PAID_ADDL_PREM_LABEL) {
		this.COMP_UI_M_PC_FC_PAID_ADDL_PREM_LABEL = COMP_UI_M_PC_FC_PAID_ADDL_PREM_LABEL;
	}

	public void setCOMP_UI_M_PC_FC_PAID_ADDL_PREM(
			HtmlInputText COMP_UI_M_PC_FC_PAID_ADDL_PREM) {
		this.COMP_UI_M_PC_FC_PAID_ADDL_PREM = COMP_UI_M_PC_FC_PAID_ADDL_PREM;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_LC_PAID_ADDL_PREM_LABEL() {
		return COMP_UI_M_PC_LC_PAID_ADDL_PREM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_LC_PAID_ADDL_PREM() {
		return COMP_UI_M_PC_LC_PAID_ADDL_PREM;
	}

	public void setCOMP_UI_M_PC_LC_PAID_ADDL_PREM_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_LC_PAID_ADDL_PREM_LABEL) {
		this.COMP_UI_M_PC_LC_PAID_ADDL_PREM_LABEL = COMP_UI_M_PC_LC_PAID_ADDL_PREM_LABEL;
	}

	public void setCOMP_UI_M_PC_LC_PAID_ADDL_PREM(
			HtmlInputText COMP_UI_M_PC_LC_PAID_ADDL_PREM) {
		this.COMP_UI_M_PC_LC_PAID_ADDL_PREM = COMP_UI_M_PC_LC_PAID_ADDL_PREM;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_FC_BAL_ADDL_PREM_LABEL() {
		return COMP_UI_M_PC_FC_BAL_ADDL_PREM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_FC_BAL_ADDL_PREM() {
		return COMP_UI_M_PC_FC_BAL_ADDL_PREM;
	}

	public void setCOMP_UI_M_PC_FC_BAL_ADDL_PREM_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_FC_BAL_ADDL_PREM_LABEL) {
		this.COMP_UI_M_PC_FC_BAL_ADDL_PREM_LABEL = COMP_UI_M_PC_FC_BAL_ADDL_PREM_LABEL;
	}

	public void setCOMP_UI_M_PC_FC_BAL_ADDL_PREM(
			HtmlInputText COMP_UI_M_PC_FC_BAL_ADDL_PREM) {
		this.COMP_UI_M_PC_FC_BAL_ADDL_PREM = COMP_UI_M_PC_FC_BAL_ADDL_PREM;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_LC_BAL_ADDL_PREM_LABEL() {
		return COMP_UI_M_PC_LC_BAL_ADDL_PREM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_LC_BAL_ADDL_PREM() {
		return COMP_UI_M_PC_LC_BAL_ADDL_PREM;
	}

	public void setCOMP_UI_M_PC_LC_BAL_ADDL_PREM_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_LC_BAL_ADDL_PREM_LABEL) {
		this.COMP_UI_M_PC_LC_BAL_ADDL_PREM_LABEL = COMP_UI_M_PC_LC_BAL_ADDL_PREM_LABEL;
	}

	public void setCOMP_UI_M_PC_LC_BAL_ADDL_PREM(
			HtmlInputText COMP_UI_M_PC_LC_BAL_ADDL_PREM) {
		this.COMP_UI_M_PC_LC_BAL_ADDL_PREM = COMP_UI_M_PC_LC_BAL_ADDL_PREM;
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

	public HtmlOutputLabel getCOMP_UI_M_PC_FC_PAID_LOAD_LABEL() {
		return COMP_UI_M_PC_FC_PAID_LOAD_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_FC_PAID_LOAD() {
		return COMP_UI_M_PC_FC_PAID_LOAD;
	}

	public void setCOMP_UI_M_PC_FC_PAID_LOAD_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_FC_PAID_LOAD_LABEL) {
		this.COMP_UI_M_PC_FC_PAID_LOAD_LABEL = COMP_UI_M_PC_FC_PAID_LOAD_LABEL;
	}

	public void setCOMP_UI_M_PC_FC_PAID_LOAD(
			HtmlInputText COMP_UI_M_PC_FC_PAID_LOAD) {
		this.COMP_UI_M_PC_FC_PAID_LOAD = COMP_UI_M_PC_FC_PAID_LOAD;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_LC_PAID_LOAD_LABEL() {
		return COMP_UI_M_PC_LC_PAID_LOAD_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_LC_PAID_LOAD() {
		return COMP_UI_M_PC_LC_PAID_LOAD;
	}

	public void setCOMP_UI_M_PC_LC_PAID_LOAD_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_LC_PAID_LOAD_LABEL) {
		this.COMP_UI_M_PC_LC_PAID_LOAD_LABEL = COMP_UI_M_PC_LC_PAID_LOAD_LABEL;
	}

	public void setCOMP_UI_M_PC_LC_PAID_LOAD(
			HtmlInputText COMP_UI_M_PC_LC_PAID_LOAD) {
		this.COMP_UI_M_PC_LC_PAID_LOAD = COMP_UI_M_PC_LC_PAID_LOAD;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_FC_BAL_LOAD_AMT_LABEL() {
		return COMP_UI_M_PC_FC_BAL_LOAD_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_FC_BAL_LOAD_AMT() {
		return COMP_UI_M_PC_FC_BAL_LOAD_AMT;
	}

	public void setCOMP_UI_M_PC_FC_BAL_LOAD_AMT_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_FC_BAL_LOAD_AMT_LABEL) {
		this.COMP_UI_M_PC_FC_BAL_LOAD_AMT_LABEL = COMP_UI_M_PC_FC_BAL_LOAD_AMT_LABEL;
	}

	public void setCOMP_UI_M_PC_FC_BAL_LOAD_AMT(
			HtmlInputText COMP_UI_M_PC_FC_BAL_LOAD_AMT) {
		this.COMP_UI_M_PC_FC_BAL_LOAD_AMT = COMP_UI_M_PC_FC_BAL_LOAD_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_LC_BAL_LOAD_AMT_LABEL() {
		return COMP_UI_M_PC_LC_BAL_LOAD_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_LC_BAL_LOAD_AMT() {
		return COMP_UI_M_PC_LC_BAL_LOAD_AMT;
	}

	public void setCOMP_UI_M_PC_LC_BAL_LOAD_AMT_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_LC_BAL_LOAD_AMT_LABEL) {
		this.COMP_UI_M_PC_LC_BAL_LOAD_AMT_LABEL = COMP_UI_M_PC_LC_BAL_LOAD_AMT_LABEL;
	}

	public void setCOMP_UI_M_PC_LC_BAL_LOAD_AMT(
			HtmlInputText COMP_UI_M_PC_LC_BAL_LOAD_AMT) {
		this.COMP_UI_M_PC_LC_BAL_LOAD_AMT = COMP_UI_M_PC_LC_BAL_LOAD_AMT;
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

	public HtmlOutputLabel getCOMP_UI_M_PC_FC_PAID_DISC_LABEL() {
		return COMP_UI_M_PC_FC_PAID_DISC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_FC_PAID_DISC() {
		return COMP_UI_M_PC_FC_PAID_DISC;
	}

	public void setCOMP_UI_M_PC_FC_PAID_DISC_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_FC_PAID_DISC_LABEL) {
		this.COMP_UI_M_PC_FC_PAID_DISC_LABEL = COMP_UI_M_PC_FC_PAID_DISC_LABEL;
	}

	public void setCOMP_UI_M_PC_FC_PAID_DISC(
			HtmlInputText COMP_UI_M_PC_FC_PAID_DISC) {
		this.COMP_UI_M_PC_FC_PAID_DISC = COMP_UI_M_PC_FC_PAID_DISC;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_LC_PAID_DISC_LABEL() {
		return COMP_UI_M_PC_LC_PAID_DISC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_LC_PAID_DISC() {
		return COMP_UI_M_PC_LC_PAID_DISC;
	}

	public void setCOMP_UI_M_PC_LC_PAID_DISC_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_LC_PAID_DISC_LABEL) {
		this.COMP_UI_M_PC_LC_PAID_DISC_LABEL = COMP_UI_M_PC_LC_PAID_DISC_LABEL;
	}

	public void setCOMP_UI_M_PC_LC_PAID_DISC(
			HtmlInputText COMP_UI_M_PC_LC_PAID_DISC) {
		this.COMP_UI_M_PC_LC_PAID_DISC = COMP_UI_M_PC_LC_PAID_DISC;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_FC_BAL_DISC_LABEL() {
		return COMP_UI_M_PC_FC_BAL_DISC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_FC_BAL_DISC() {
		return COMP_UI_M_PC_FC_BAL_DISC;
	}

	public void setCOMP_UI_M_PC_FC_BAL_DISC_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_FC_BAL_DISC_LABEL) {
		this.COMP_UI_M_PC_FC_BAL_DISC_LABEL = COMP_UI_M_PC_FC_BAL_DISC_LABEL;
	}

	public void setCOMP_UI_M_PC_FC_BAL_DISC(
			HtmlInputText COMP_UI_M_PC_FC_BAL_DISC) {
		this.COMP_UI_M_PC_FC_BAL_DISC = COMP_UI_M_PC_FC_BAL_DISC;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_LC_BAL_DISC_LABEL() {
		return COMP_UI_M_PC_LC_BAL_DISC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_LC_BAL_DISC() {
		return COMP_UI_M_PC_LC_BAL_DISC;
	}

	public void setCOMP_UI_M_PC_LC_BAL_DISC_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_LC_BAL_DISC_LABEL) {
		this.COMP_UI_M_PC_LC_BAL_DISC_LABEL = COMP_UI_M_PC_LC_BAL_DISC_LABEL;
	}

	public void setCOMP_UI_M_PC_LC_BAL_DISC(
			HtmlInputText COMP_UI_M_PC_LC_BAL_DISC) {
		this.COMP_UI_M_PC_LC_BAL_DISC = COMP_UI_M_PC_LC_BAL_DISC;
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

	public HtmlOutputLabel getCOMP_UI_M_PC_FC_PAID_CUST_CHRG_LABEL() {
		return COMP_UI_M_PC_FC_PAID_CUST_CHRG_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_FC_PAID_CUST_CHRG() {
		return COMP_UI_M_PC_FC_PAID_CUST_CHRG;
	}

	public void setCOMP_UI_M_PC_FC_PAID_CUST_CHRG_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_FC_PAID_CUST_CHRG_LABEL) {
		this.COMP_UI_M_PC_FC_PAID_CUST_CHRG_LABEL = COMP_UI_M_PC_FC_PAID_CUST_CHRG_LABEL;
	}

	public void setCOMP_UI_M_PC_FC_PAID_CUST_CHRG(
			HtmlInputText COMP_UI_M_PC_FC_PAID_CUST_CHRG) {
		this.COMP_UI_M_PC_FC_PAID_CUST_CHRG = COMP_UI_M_PC_FC_PAID_CUST_CHRG;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_LC_PAID_CUST_CHRG_LABEL() {
		return COMP_UI_M_PC_LC_PAID_CUST_CHRG_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_LC_PAID_CUST_CHRG() {
		return COMP_UI_M_PC_LC_PAID_CUST_CHRG;
	}

	public void setCOMP_UI_M_PC_LC_PAID_CUST_CHRG_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_LC_PAID_CUST_CHRG_LABEL) {
		this.COMP_UI_M_PC_LC_PAID_CUST_CHRG_LABEL = COMP_UI_M_PC_LC_PAID_CUST_CHRG_LABEL;
	}

	public void setCOMP_UI_M_PC_LC_PAID_CUST_CHRG(
			HtmlInputText COMP_UI_M_PC_LC_PAID_CUST_CHRG) {
		this.COMP_UI_M_PC_LC_PAID_CUST_CHRG = COMP_UI_M_PC_LC_PAID_CUST_CHRG;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_FC_BAL_CUST_CHRG_LABEL() {
		return COMP_UI_M_PC_FC_BAL_CUST_CHRG_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_FC_BAL_CUST_CHRG() {
		return COMP_UI_M_PC_FC_BAL_CUST_CHRG;
	}

	public void setCOMP_UI_M_PC_FC_BAL_CUST_CHRG_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_FC_BAL_CUST_CHRG_LABEL) {
		this.COMP_UI_M_PC_FC_BAL_CUST_CHRG_LABEL = COMP_UI_M_PC_FC_BAL_CUST_CHRG_LABEL;
	}

	public void setCOMP_UI_M_PC_FC_BAL_CUST_CHRG(
			HtmlInputText COMP_UI_M_PC_FC_BAL_CUST_CHRG) {
		this.COMP_UI_M_PC_FC_BAL_CUST_CHRG = COMP_UI_M_PC_FC_BAL_CUST_CHRG;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_LC_BAL_CUST_CHRG_LABEL() {
		return COMP_UI_M_PC_LC_BAL_CUST_CHRG_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_LC_BAL_CUST_CHRG() {
		return COMP_UI_M_PC_LC_BAL_CUST_CHRG;
	}

	public void setCOMP_UI_M_PC_LC_BAL_CUST_CHRG_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_LC_BAL_CUST_CHRG_LABEL) {
		this.COMP_UI_M_PC_LC_BAL_CUST_CHRG_LABEL = COMP_UI_M_PC_LC_BAL_CUST_CHRG_LABEL;
	}

	public void setCOMP_UI_M_PC_LC_BAL_CUST_CHRG(
			HtmlInputText COMP_UI_M_PC_LC_BAL_CUST_CHRG) {
		this.COMP_UI_M_PC_LC_BAL_CUST_CHRG = COMP_UI_M_PC_LC_BAL_CUST_CHRG;
	}

	public HtmlOutputLabel getCOMP_PC_FC_DUE_CONTR_LABEL() {
		return COMP_PC_FC_DUE_CONTR_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_DUE_CONTR() {
		return COMP_PC_FC_DUE_CONTR;
	}

	public void setCOMP_PC_FC_DUE_CONTR_LABEL(
			HtmlOutputLabel COMP_PC_FC_DUE_CONTR_LABEL) {
		this.COMP_PC_FC_DUE_CONTR_LABEL = COMP_PC_FC_DUE_CONTR_LABEL;
	}

	public void setCOMP_PC_FC_DUE_CONTR(HtmlInputText COMP_PC_FC_DUE_CONTR) {
		this.COMP_PC_FC_DUE_CONTR = COMP_PC_FC_DUE_CONTR;
	}

	public HtmlOutputLabel getCOMP_PC_LC_DUE_CONTR_LABEL() {
		return COMP_PC_LC_DUE_CONTR_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_DUE_CONTR() {
		return COMP_PC_LC_DUE_CONTR;
	}

	public void setCOMP_PC_LC_DUE_CONTR_LABEL(
			HtmlOutputLabel COMP_PC_LC_DUE_CONTR_LABEL) {
		this.COMP_PC_LC_DUE_CONTR_LABEL = COMP_PC_LC_DUE_CONTR_LABEL;
	}

	public void setCOMP_PC_LC_DUE_CONTR(HtmlInputText COMP_PC_LC_DUE_CONTR) {
		this.COMP_PC_LC_DUE_CONTR = COMP_PC_LC_DUE_CONTR;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_FC_PAID_CONTR_LABEL() {
		return COMP_UI_M_PC_FC_PAID_CONTR_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_FC_PAID_CONTR() {
		return COMP_UI_M_PC_FC_PAID_CONTR;
	}

	public void setCOMP_UI_M_PC_FC_PAID_CONTR_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_FC_PAID_CONTR_LABEL) {
		this.COMP_UI_M_PC_FC_PAID_CONTR_LABEL = COMP_UI_M_PC_FC_PAID_CONTR_LABEL;
	}

	public void setCOMP_UI_M_PC_FC_PAID_CONTR(
			HtmlInputText COMP_UI_M_PC_FC_PAID_CONTR) {
		this.COMP_UI_M_PC_FC_PAID_CONTR = COMP_UI_M_PC_FC_PAID_CONTR;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_LC_PAID_CONTR_LABEL() {
		return COMP_UI_M_PC_LC_PAID_CONTR_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_LC_PAID_CONTR() {
		return COMP_UI_M_PC_LC_PAID_CONTR;
	}

	public void setCOMP_UI_M_PC_LC_PAID_CONTR_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_LC_PAID_CONTR_LABEL) {
		this.COMP_UI_M_PC_LC_PAID_CONTR_LABEL = COMP_UI_M_PC_LC_PAID_CONTR_LABEL;
	}

	public void setCOMP_UI_M_PC_LC_PAID_CONTR(
			HtmlInputText COMP_UI_M_PC_LC_PAID_CONTR) {
		this.COMP_UI_M_PC_LC_PAID_CONTR = COMP_UI_M_PC_LC_PAID_CONTR;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_FC_BAL_CONTR_LABEL() {
		return COMP_UI_M_PC_FC_BAL_CONTR_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_FC_BAL_CONTR() {
		return COMP_UI_M_PC_FC_BAL_CONTR;
	}

	public void setCOMP_UI_M_PC_FC_BAL_CONTR_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_FC_BAL_CONTR_LABEL) {
		this.COMP_UI_M_PC_FC_BAL_CONTR_LABEL = COMP_UI_M_PC_FC_BAL_CONTR_LABEL;
	}

	public void setCOMP_UI_M_PC_FC_BAL_CONTR(
			HtmlInputText COMP_UI_M_PC_FC_BAL_CONTR) {
		this.COMP_UI_M_PC_FC_BAL_CONTR = COMP_UI_M_PC_FC_BAL_CONTR;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_LC_BAL_CONTR_LABEL() {
		return COMP_UI_M_PC_LC_BAL_CONTR_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_LC_BAL_CONTR() {
		return COMP_UI_M_PC_LC_BAL_CONTR;
	}

	public void setCOMP_UI_M_PC_LC_BAL_CONTR_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_LC_BAL_CONTR_LABEL) {
		this.COMP_UI_M_PC_LC_BAL_CONTR_LABEL = COMP_UI_M_PC_LC_BAL_CONTR_LABEL;
	}

	public void setCOMP_UI_M_PC_LC_BAL_CONTR(
			HtmlInputText COMP_UI_M_PC_LC_BAL_CONTR) {
		this.COMP_UI_M_PC_LC_BAL_CONTR = COMP_UI_M_PC_LC_BAL_CONTR;
	}

	public HtmlOutputLabel getCOMP_UI_M_TOPUP_DUE_FC_AMT_LABEL() {
		return COMP_UI_M_TOPUP_DUE_FC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TOPUP_DUE_FC_AMT() {
		return COMP_UI_M_TOPUP_DUE_FC_AMT;
	}

	public void setCOMP_UI_M_TOPUP_DUE_FC_AMT_LABEL(
			HtmlOutputLabel COMP_UI_M_TOPUP_DUE_FC_AMT_LABEL) {
		this.COMP_UI_M_TOPUP_DUE_FC_AMT_LABEL = COMP_UI_M_TOPUP_DUE_FC_AMT_LABEL;
	}

	public void setCOMP_UI_M_TOPUP_DUE_FC_AMT(
			HtmlInputText COMP_UI_M_TOPUP_DUE_FC_AMT) {
		this.COMP_UI_M_TOPUP_DUE_FC_AMT = COMP_UI_M_TOPUP_DUE_FC_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_TOPUP_DUE_LC_AMT_LABEL() {
		return COMP_UI_M_TOPUP_DUE_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TOPUP_DUE_LC_AMT() {
		return COMP_UI_M_TOPUP_DUE_LC_AMT;
	}

	public void setCOMP_UI_M_TOPUP_DUE_LC_AMT_LABEL(
			HtmlOutputLabel COMP_UI_M_TOPUP_DUE_LC_AMT_LABEL) {
		this.COMP_UI_M_TOPUP_DUE_LC_AMT_LABEL = COMP_UI_M_TOPUP_DUE_LC_AMT_LABEL;
	}

	public void setCOMP_UI_M_TOPUP_DUE_LC_AMT(
			HtmlInputText COMP_UI_M_TOPUP_DUE_LC_AMT) {
		this.COMP_UI_M_TOPUP_DUE_LC_AMT = COMP_UI_M_TOPUP_DUE_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_TOPUP_PAID_FC_AMT_LABEL() {
		return COMP_UI_M_TOPUP_PAID_FC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TOPUP_PAID_FC_AMT() {
		return COMP_UI_M_TOPUP_PAID_FC_AMT;
	}

	public void setCOMP_UI_M_TOPUP_PAID_FC_AMT_LABEL(
			HtmlOutputLabel COMP_UI_M_TOPUP_PAID_FC_AMT_LABEL) {
		this.COMP_UI_M_TOPUP_PAID_FC_AMT_LABEL = COMP_UI_M_TOPUP_PAID_FC_AMT_LABEL;
	}

	public void setCOMP_UI_M_TOPUP_PAID_FC_AMT(
			HtmlInputText COMP_UI_M_TOPUP_PAID_FC_AMT) {
		this.COMP_UI_M_TOPUP_PAID_FC_AMT = COMP_UI_M_TOPUP_PAID_FC_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_TOPUP_PAID_LC_AMT_LABEL() {
		return COMP_UI_M_TOPUP_PAID_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TOPUP_PAID_LC_AMT() {
		return COMP_UI_M_TOPUP_PAID_LC_AMT;
	}

	public void setCOMP_UI_M_TOPUP_PAID_LC_AMT_LABEL(
			HtmlOutputLabel COMP_UI_M_TOPUP_PAID_LC_AMT_LABEL) {
		this.COMP_UI_M_TOPUP_PAID_LC_AMT_LABEL = COMP_UI_M_TOPUP_PAID_LC_AMT_LABEL;
	}

	public void setCOMP_UI_M_TOPUP_PAID_LC_AMT(
			HtmlInputText COMP_UI_M_TOPUP_PAID_LC_AMT) {
		this.COMP_UI_M_TOPUP_PAID_LC_AMT = COMP_UI_M_TOPUP_PAID_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_TOPUP_BAL_LC_AMT_LABEL() {
		return COMP_UI_M_TOPUP_BAL_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TOPUP_BAL_LC_AMT() {
		return COMP_UI_M_TOPUP_BAL_LC_AMT;
	}

	public void setCOMP_UI_M_TOPUP_BAL_LC_AMT_LABEL(
			HtmlOutputLabel COMP_UI_M_TOPUP_BAL_LC_AMT_LABEL) {
		this.COMP_UI_M_TOPUP_BAL_LC_AMT_LABEL = COMP_UI_M_TOPUP_BAL_LC_AMT_LABEL;
	}

	public void setCOMP_UI_M_TOPUP_BAL_LC_AMT(
			HtmlInputText COMP_UI_M_TOPUP_BAL_LC_AMT) {
		this.COMP_UI_M_TOPUP_BAL_LC_AMT = COMP_UI_M_TOPUP_BAL_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_TOPUP_BAL_FC_AMT_LABEL() {
		return COMP_UI_M_TOPUP_BAL_FC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TOPUP_BAL_FC_AMT() {
		return COMP_UI_M_TOPUP_BAL_FC_AMT;
	}

	public void setCOMP_UI_M_TOPUP_BAL_FC_AMT_LABEL(
			HtmlOutputLabel COMP_UI_M_TOPUP_BAL_FC_AMT_LABEL) {
		this.COMP_UI_M_TOPUP_BAL_FC_AMT_LABEL = COMP_UI_M_TOPUP_BAL_FC_AMT_LABEL;
	}

	public void setCOMP_UI_M_TOPUP_BAL_FC_AMT(
			HtmlInputText COMP_UI_M_TOPUP_BAL_FC_AMT) {
		this.COMP_UI_M_TOPUP_BAL_FC_AMT = COMP_UI_M_TOPUP_BAL_FC_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_FC_INV_DUE_CHRG_LABEL() {
		return COMP_PC_FC_INV_DUE_CHRG_LABEL;
	}

	public HtmlInputText getCOMP_PC_FC_INV_DUE_CHRG() {
		return COMP_PC_FC_INV_DUE_CHRG;
	}

	public void setCOMP_PC_FC_INV_DUE_CHRG_LABEL(
			HtmlOutputLabel COMP_PC_FC_INV_DUE_CHRG_LABEL) {
		this.COMP_PC_FC_INV_DUE_CHRG_LABEL = COMP_PC_FC_INV_DUE_CHRG_LABEL;
	}

	public void setCOMP_PC_FC_INV_DUE_CHRG(HtmlInputText COMP_PC_FC_INV_DUE_CHRG) {
		this.COMP_PC_FC_INV_DUE_CHRG = COMP_PC_FC_INV_DUE_CHRG;
	}

	public HtmlOutputLabel getCOMP_PC_LC_INV_DUE_CHRG_LABEL() {
		return COMP_PC_LC_INV_DUE_CHRG_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_INV_DUE_CHRG() {
		return COMP_PC_LC_INV_DUE_CHRG;
	}

	public void setCOMP_PC_LC_INV_DUE_CHRG_LABEL(
			HtmlOutputLabel COMP_PC_LC_INV_DUE_CHRG_LABEL) {
		this.COMP_PC_LC_INV_DUE_CHRG_LABEL = COMP_PC_LC_INV_DUE_CHRG_LABEL;
	}

	public void setCOMP_PC_LC_INV_DUE_CHRG(HtmlInputText COMP_PC_LC_INV_DUE_CHRG) {
		this.COMP_PC_LC_INV_DUE_CHRG = COMP_PC_LC_INV_DUE_CHRG;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_FC_INV_PAID_CHRG_LABEL() {
		return COMP_UI_M_PC_FC_INV_PAID_CHRG_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_FC_INV_PAID_CHRG() {
		return COMP_UI_M_PC_FC_INV_PAID_CHRG;
	}

	public void setCOMP_UI_M_PC_FC_INV_PAID_CHRG_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_FC_INV_PAID_CHRG_LABEL) {
		this.COMP_UI_M_PC_FC_INV_PAID_CHRG_LABEL = COMP_UI_M_PC_FC_INV_PAID_CHRG_LABEL;
	}

	public void setCOMP_UI_M_PC_FC_INV_PAID_CHRG(
			HtmlInputText COMP_UI_M_PC_FC_INV_PAID_CHRG) {
		this.COMP_UI_M_PC_FC_INV_PAID_CHRG = COMP_UI_M_PC_FC_INV_PAID_CHRG;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_LC_INV_PAID_CHRG_LABEL() {
		return COMP_UI_M_PC_LC_INV_PAID_CHRG_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_LC_INV_PAID_CHRG() {
		return COMP_UI_M_PC_LC_INV_PAID_CHRG;
	}

	public void setCOMP_UI_M_PC_LC_INV_PAID_CHRG_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_LC_INV_PAID_CHRG_LABEL) {
		this.COMP_UI_M_PC_LC_INV_PAID_CHRG_LABEL = COMP_UI_M_PC_LC_INV_PAID_CHRG_LABEL;
	}

	public void setCOMP_UI_M_PC_LC_INV_PAID_CHRG(
			HtmlInputText COMP_UI_M_PC_LC_INV_PAID_CHRG) {
		this.COMP_UI_M_PC_LC_INV_PAID_CHRG = COMP_UI_M_PC_LC_INV_PAID_CHRG;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_FC_INV_BAL_CHRG_LABEL() {
		return COMP_UI_M_PC_FC_INV_BAL_CHRG_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_FC_INV_BAL_CHRG() {
		return COMP_UI_M_PC_FC_INV_BAL_CHRG;
	}

	public void setCOMP_UI_M_PC_FC_INV_BAL_CHRG_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_FC_INV_BAL_CHRG_LABEL) {
		this.COMP_UI_M_PC_FC_INV_BAL_CHRG_LABEL = COMP_UI_M_PC_FC_INV_BAL_CHRG_LABEL;
	}

	public void setCOMP_UI_M_PC_FC_INV_BAL_CHRG(
			HtmlInputText COMP_UI_M_PC_FC_INV_BAL_CHRG) {
		this.COMP_UI_M_PC_FC_INV_BAL_CHRG = COMP_UI_M_PC_FC_INV_BAL_CHRG;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_LC_INV_BAL_CHRG_LABEL() {
		return COMP_UI_M_PC_LC_INV_BAL_CHRG_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_LC_INV_BAL_CHRG() {
		return COMP_UI_M_PC_LC_INV_BAL_CHRG;
	}

	public void setCOMP_UI_M_PC_LC_INV_BAL_CHRG_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_LC_INV_BAL_CHRG_LABEL) {
		this.COMP_UI_M_PC_LC_INV_BAL_CHRG_LABEL = COMP_UI_M_PC_LC_INV_BAL_CHRG_LABEL;
	}

	public void setCOMP_UI_M_PC_LC_INV_BAL_CHRG(
			HtmlInputText COMP_UI_M_PC_LC_INV_BAL_CHRG) {
		this.COMP_UI_M_PC_LC_INV_BAL_CHRG = COMP_UI_M_PC_LC_INV_BAL_CHRG;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_12_LABEL() {
		return COMP_PC_FLEX_12_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_12() {
		return COMP_PC_FLEX_12;
	}

	public void setCOMP_PC_FLEX_12_LABEL(HtmlOutputLabel COMP_PC_FLEX_12_LABEL) {
		this.COMP_PC_FLEX_12_LABEL = COMP_PC_FLEX_12_LABEL;
	}

	public void setCOMP_PC_FLEX_12(HtmlInputText COMP_PC_FLEX_12) {
		this.COMP_PC_FLEX_12 = COMP_PC_FLEX_12;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_30_LABEL() {
		return COMP_PC_FLEX_30_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_30() {
		return COMP_PC_FLEX_30;
	}

	public void setCOMP_PC_FLEX_30_LABEL(HtmlOutputLabel COMP_PC_FLEX_30_LABEL) {
		this.COMP_PC_FLEX_30_LABEL = COMP_PC_FLEX_30_LABEL;
	}

	public void setCOMP_PC_FLEX_30(HtmlInputText COMP_PC_FLEX_30) {
		this.COMP_PC_FLEX_30 = COMP_PC_FLEX_30;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_29_LABEL() {
		return COMP_PC_FLEX_29_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_29() {
		return COMP_PC_FLEX_29;
	}

	public void setCOMP_PC_FLEX_29_LABEL(HtmlOutputLabel COMP_PC_FLEX_29_LABEL) {
		this.COMP_PC_FLEX_29_LABEL = COMP_PC_FLEX_29_LABEL;
	}

	public void setCOMP_PC_FLEX_29(HtmlInputText COMP_PC_FLEX_29) {
		this.COMP_PC_FLEX_29 = COMP_PC_FLEX_29;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_01_LABEL() {
		return COMP_PC_FLEX_01_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_01() {
		return COMP_PC_FLEX_01;
	}

	public void setCOMP_PC_FLEX_01_LABEL(HtmlOutputLabel COMP_PC_FLEX_01_LABEL) {
		this.COMP_PC_FLEX_01_LABEL = COMP_PC_FLEX_01_LABEL;
	}

	public void setCOMP_PC_FLEX_01(HtmlInputText COMP_PC_FLEX_01) {
		this.COMP_PC_FLEX_01 = COMP_PC_FLEX_01;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_02_LABEL() {
		return COMP_PC_FLEX_02_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_02() {
		return COMP_PC_FLEX_02;
	}

	public void setCOMP_PC_FLEX_02_LABEL(HtmlOutputLabel COMP_PC_FLEX_02_LABEL) {
		this.COMP_PC_FLEX_02_LABEL = COMP_PC_FLEX_02_LABEL;
	}

	public void setCOMP_PC_FLEX_02(HtmlInputText COMP_PC_FLEX_02) {
		this.COMP_PC_FLEX_02 = COMP_PC_FLEX_02;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_03_LABEL() {
		return COMP_PC_FLEX_03_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_03() {
		return COMP_PC_FLEX_03;
	}

	public void setCOMP_PC_FLEX_03_LABEL(HtmlOutputLabel COMP_PC_FLEX_03_LABEL) {
		this.COMP_PC_FLEX_03_LABEL = COMP_PC_FLEX_03_LABEL;
	}

	public void setCOMP_PC_FLEX_03(HtmlInputText COMP_PC_FLEX_03) {
		this.COMP_PC_FLEX_03 = COMP_PC_FLEX_03;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_04_LABEL() {
		return COMP_PC_FLEX_04_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_04() {
		return COMP_PC_FLEX_04;
	}

	public void setCOMP_PC_FLEX_04_LABEL(HtmlOutputLabel COMP_PC_FLEX_04_LABEL) {
		this.COMP_PC_FLEX_04_LABEL = COMP_PC_FLEX_04_LABEL;
	}

	public void setCOMP_PC_FLEX_04(HtmlInputText COMP_PC_FLEX_04) {
		this.COMP_PC_FLEX_04 = COMP_PC_FLEX_04;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_05_LABEL() {
		return COMP_PC_FLEX_05_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_05() {
		return COMP_PC_FLEX_05;
	}

	public void setCOMP_PC_FLEX_05_LABEL(HtmlOutputLabel COMP_PC_FLEX_05_LABEL) {
		this.COMP_PC_FLEX_05_LABEL = COMP_PC_FLEX_05_LABEL;
	}

	public void setCOMP_PC_FLEX_05(HtmlInputText COMP_PC_FLEX_05) {
		this.COMP_PC_FLEX_05 = COMP_PC_FLEX_05;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_06_LABEL() {
		return COMP_PC_FLEX_06_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_06() {
		return COMP_PC_FLEX_06;
	}

	public void setCOMP_PC_FLEX_06_LABEL(HtmlOutputLabel COMP_PC_FLEX_06_LABEL) {
		this.COMP_PC_FLEX_06_LABEL = COMP_PC_FLEX_06_LABEL;
	}

	public void setCOMP_PC_FLEX_06(HtmlInputText COMP_PC_FLEX_06) {
		this.COMP_PC_FLEX_06 = COMP_PC_FLEX_06;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_07_LABEL() {
		return COMP_PC_FLEX_07_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_07() {
		return COMP_PC_FLEX_07;
	}

	public void setCOMP_PC_FLEX_07_LABEL(HtmlOutputLabel COMP_PC_FLEX_07_LABEL) {
		this.COMP_PC_FLEX_07_LABEL = COMP_PC_FLEX_07_LABEL;
	}

	public void setCOMP_PC_FLEX_07(HtmlInputText COMP_PC_FLEX_07) {
		this.COMP_PC_FLEX_07 = COMP_PC_FLEX_07;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_08_LABEL() {
		return COMP_PC_FLEX_08_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_08() {
		return COMP_PC_FLEX_08;
	}

	public void setCOMP_PC_FLEX_08_LABEL(HtmlOutputLabel COMP_PC_FLEX_08_LABEL) {
		this.COMP_PC_FLEX_08_LABEL = COMP_PC_FLEX_08_LABEL;
	}

	public void setCOMP_PC_FLEX_08(HtmlInputText COMP_PC_FLEX_08) {
		this.COMP_PC_FLEX_08 = COMP_PC_FLEX_08;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_09_LABEL() {
		return COMP_PC_FLEX_09_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_09() {
		return COMP_PC_FLEX_09;
	}

	public void setCOMP_PC_FLEX_09_LABEL(HtmlOutputLabel COMP_PC_FLEX_09_LABEL) {
		this.COMP_PC_FLEX_09_LABEL = COMP_PC_FLEX_09_LABEL;
	}

	public void setCOMP_PC_FLEX_09(HtmlInputText COMP_PC_FLEX_09) {
		this.COMP_PC_FLEX_09 = COMP_PC_FLEX_09;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_10_LABEL() {
		return COMP_PC_FLEX_10_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_10() {
		return COMP_PC_FLEX_10;
	}

	public void setCOMP_PC_FLEX_10_LABEL(HtmlOutputLabel COMP_PC_FLEX_10_LABEL) {
		this.COMP_PC_FLEX_10_LABEL = COMP_PC_FLEX_10_LABEL;
	}

	public void setCOMP_PC_FLEX_10(HtmlInputText COMP_PC_FLEX_10) {
		this.COMP_PC_FLEX_10 = COMP_PC_FLEX_10;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_11_LABEL() {
		return COMP_PC_FLEX_11_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_11() {
		return COMP_PC_FLEX_11;
	}

	public void setCOMP_PC_FLEX_11_LABEL(HtmlOutputLabel COMP_PC_FLEX_11_LABEL) {
		this.COMP_PC_FLEX_11_LABEL = COMP_PC_FLEX_11_LABEL;
	}

	public void setCOMP_PC_FLEX_11(HtmlInputText COMP_PC_FLEX_11) {
		this.COMP_PC_FLEX_11 = COMP_PC_FLEX_11;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_13_LABEL() {
		return COMP_PC_FLEX_13_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_13() {
		return COMP_PC_FLEX_13;
	}

	public void setCOMP_PC_FLEX_13_LABEL(HtmlOutputLabel COMP_PC_FLEX_13_LABEL) {
		this.COMP_PC_FLEX_13_LABEL = COMP_PC_FLEX_13_LABEL;
	}

	public void setCOMP_PC_FLEX_13(HtmlInputText COMP_PC_FLEX_13) {
		this.COMP_PC_FLEX_13 = COMP_PC_FLEX_13;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_14_LABEL() {
		return COMP_PC_FLEX_14_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_14() {
		return COMP_PC_FLEX_14;
	}

	public void setCOMP_PC_FLEX_14_LABEL(HtmlOutputLabel COMP_PC_FLEX_14_LABEL) {
		this.COMP_PC_FLEX_14_LABEL = COMP_PC_FLEX_14_LABEL;
	}

	public void setCOMP_PC_FLEX_14(HtmlInputText COMP_PC_FLEX_14) {
		this.COMP_PC_FLEX_14 = COMP_PC_FLEX_14;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_15_LABEL() {
		return COMP_PC_FLEX_15_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_15() {
		return COMP_PC_FLEX_15;
	}

	public void setCOMP_PC_FLEX_15_LABEL(HtmlOutputLabel COMP_PC_FLEX_15_LABEL) {
		this.COMP_PC_FLEX_15_LABEL = COMP_PC_FLEX_15_LABEL;
	}

	public void setCOMP_PC_FLEX_15(HtmlInputText COMP_PC_FLEX_15) {
		this.COMP_PC_FLEX_15 = COMP_PC_FLEX_15;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_16_LABEL() {
		return COMP_PC_FLEX_16_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_16() {
		return COMP_PC_FLEX_16;
	}

	public void setCOMP_PC_FLEX_16_LABEL(HtmlOutputLabel COMP_PC_FLEX_16_LABEL) {
		this.COMP_PC_FLEX_16_LABEL = COMP_PC_FLEX_16_LABEL;
	}

	public void setCOMP_PC_FLEX_16(HtmlInputText COMP_PC_FLEX_16) {
		this.COMP_PC_FLEX_16 = COMP_PC_FLEX_16;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_17_LABEL() {
		return COMP_PC_FLEX_17_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_17() {
		return COMP_PC_FLEX_17;
	}

	public void setCOMP_PC_FLEX_17_LABEL(HtmlOutputLabel COMP_PC_FLEX_17_LABEL) {
		this.COMP_PC_FLEX_17_LABEL = COMP_PC_FLEX_17_LABEL;
	}

	public void setCOMP_PC_FLEX_17(HtmlInputText COMP_PC_FLEX_17) {
		this.COMP_PC_FLEX_17 = COMP_PC_FLEX_17;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_18_LABEL() {
		return COMP_PC_FLEX_18_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_18() {
		return COMP_PC_FLEX_18;
	}

	public void setCOMP_PC_FLEX_18_LABEL(HtmlOutputLabel COMP_PC_FLEX_18_LABEL) {
		this.COMP_PC_FLEX_18_LABEL = COMP_PC_FLEX_18_LABEL;
	}

	public void setCOMP_PC_FLEX_18(HtmlInputText COMP_PC_FLEX_18) {
		this.COMP_PC_FLEX_18 = COMP_PC_FLEX_18;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_19_LABEL() {
		return COMP_PC_FLEX_19_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_19() {
		return COMP_PC_FLEX_19;
	}

	public void setCOMP_PC_FLEX_19_LABEL(HtmlOutputLabel COMP_PC_FLEX_19_LABEL) {
		this.COMP_PC_FLEX_19_LABEL = COMP_PC_FLEX_19_LABEL;
	}

	public void setCOMP_PC_FLEX_19(HtmlInputText COMP_PC_FLEX_19) {
		this.COMP_PC_FLEX_19 = COMP_PC_FLEX_19;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_20_LABEL() {
		return COMP_PC_FLEX_20_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_20() {
		return COMP_PC_FLEX_20;
	}

	public void setCOMP_PC_FLEX_20_LABEL(HtmlOutputLabel COMP_PC_FLEX_20_LABEL) {
		this.COMP_PC_FLEX_20_LABEL = COMP_PC_FLEX_20_LABEL;
	}

	public void setCOMP_PC_FLEX_20(HtmlInputText COMP_PC_FLEX_20) {
		this.COMP_PC_FLEX_20 = COMP_PC_FLEX_20;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_21_LABEL() {
		return COMP_PC_FLEX_21_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_21() {
		return COMP_PC_FLEX_21;
	}

	public void setCOMP_PC_FLEX_21_LABEL(HtmlOutputLabel COMP_PC_FLEX_21_LABEL) {
		this.COMP_PC_FLEX_21_LABEL = COMP_PC_FLEX_21_LABEL;
	}

	public void setCOMP_PC_FLEX_21(HtmlInputText COMP_PC_FLEX_21) {
		this.COMP_PC_FLEX_21 = COMP_PC_FLEX_21;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_22_LABEL() {
		return COMP_PC_FLEX_22_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_22() {
		return COMP_PC_FLEX_22;
	}

	public void setCOMP_PC_FLEX_22_LABEL(HtmlOutputLabel COMP_PC_FLEX_22_LABEL) {
		this.COMP_PC_FLEX_22_LABEL = COMP_PC_FLEX_22_LABEL;
	}

	public void setCOMP_PC_FLEX_22(HtmlInputText COMP_PC_FLEX_22) {
		this.COMP_PC_FLEX_22 = COMP_PC_FLEX_22;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_23_LABEL() {
		return COMP_PC_FLEX_23_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_23() {
		return COMP_PC_FLEX_23;
	}

	public void setCOMP_PC_FLEX_23_LABEL(HtmlOutputLabel COMP_PC_FLEX_23_LABEL) {
		this.COMP_PC_FLEX_23_LABEL = COMP_PC_FLEX_23_LABEL;
	}

	public void setCOMP_PC_FLEX_23(HtmlInputText COMP_PC_FLEX_23) {
		this.COMP_PC_FLEX_23 = COMP_PC_FLEX_23;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_24_LABEL() {
		return COMP_PC_FLEX_24_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_24() {
		return COMP_PC_FLEX_24;
	}

	public void setCOMP_PC_FLEX_24_LABEL(HtmlOutputLabel COMP_PC_FLEX_24_LABEL) {
		this.COMP_PC_FLEX_24_LABEL = COMP_PC_FLEX_24_LABEL;
	}

	public void setCOMP_PC_FLEX_24(HtmlInputText COMP_PC_FLEX_24) {
		this.COMP_PC_FLEX_24 = COMP_PC_FLEX_24;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_25_LABEL() {
		return COMP_PC_FLEX_25_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_25() {
		return COMP_PC_FLEX_25;
	}

	public void setCOMP_PC_FLEX_25_LABEL(HtmlOutputLabel COMP_PC_FLEX_25_LABEL) {
		this.COMP_PC_FLEX_25_LABEL = COMP_PC_FLEX_25_LABEL;
	}

	public void setCOMP_PC_FLEX_25(HtmlInputText COMP_PC_FLEX_25) {
		this.COMP_PC_FLEX_25 = COMP_PC_FLEX_25;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_26_LABEL() {
		return COMP_PC_FLEX_26_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_26() {
		return COMP_PC_FLEX_26;
	}

	public void setCOMP_PC_FLEX_26_LABEL(HtmlOutputLabel COMP_PC_FLEX_26_LABEL) {
		this.COMP_PC_FLEX_26_LABEL = COMP_PC_FLEX_26_LABEL;
	}

	public void setCOMP_PC_FLEX_26(HtmlInputText COMP_PC_FLEX_26) {
		this.COMP_PC_FLEX_26 = COMP_PC_FLEX_26;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_27_LABEL() {
		return COMP_PC_FLEX_27_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_27() {
		return COMP_PC_FLEX_27;
	}

	public void setCOMP_PC_FLEX_27_LABEL(HtmlOutputLabel COMP_PC_FLEX_27_LABEL) {
		this.COMP_PC_FLEX_27_LABEL = COMP_PC_FLEX_27_LABEL;
	}

	public void setCOMP_PC_FLEX_27(HtmlInputText COMP_PC_FLEX_27) {
		this.COMP_PC_FLEX_27 = COMP_PC_FLEX_27;
	}

	public HtmlOutputLabel getCOMP_PC_FLEX_28_LABEL() {
		return COMP_PC_FLEX_28_LABEL;
	}

	public HtmlInputText getCOMP_PC_FLEX_28() {
		return COMP_PC_FLEX_28;
	}

	public void setCOMP_PC_FLEX_28_LABEL(HtmlOutputLabel COMP_PC_FLEX_28_LABEL) {
		this.COMP_PC_FLEX_28_LABEL = COMP_PC_FLEX_28_LABEL;
	}

	public void setCOMP_PC_FLEX_28(HtmlInputText COMP_PC_FLEX_28) {
		this.COMP_PC_FLEX_28 = COMP_PC_FLEX_28;
	}

	public HtmlOutputLabel getCOMP_UI_M_PREV_INST_DUE_DT_LABEL() {
		return COMP_UI_M_PREV_INST_DUE_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_PREV_INST_DUE_DT() {
		return COMP_UI_M_PREV_INST_DUE_DT;
	}

	public void setCOMP_UI_M_PREV_INST_DUE_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_PREV_INST_DUE_DT_LABEL) {
		this.COMP_UI_M_PREV_INST_DUE_DT_LABEL = COMP_UI_M_PREV_INST_DUE_DT_LABEL;
	}

	public void setCOMP_UI_M_PREV_INST_DUE_DT(
			HtmlCalendar COMP_UI_M_PREV_INST_DUE_DT) {
		this.COMP_UI_M_PREV_INST_DUE_DT = COMP_UI_M_PREV_INST_DUE_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_PREV_PAY_DT_LABEL() {
		return COMP_UI_M_PREV_PAY_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_PREV_PAY_DT() {
		return COMP_UI_M_PREV_PAY_DT;
	}

	public void setCOMP_UI_M_PREV_PAY_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_PREV_PAY_DT_LABEL) {
		this.COMP_UI_M_PREV_PAY_DT_LABEL = COMP_UI_M_PREV_PAY_DT_LABEL;
	}

	public void setCOMP_UI_M_PREV_PAY_DT(HtmlCalendar COMP_UI_M_PREV_PAY_DT) {
		this.COMP_UI_M_PREV_PAY_DT = COMP_UI_M_PREV_PAY_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_CURR_INV_DUE_DT_LABEL() {
		return COMP_UI_M_CURR_INV_DUE_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_CURR_INV_DUE_DT() {
		return COMP_UI_M_CURR_INV_DUE_DT;
	}

	public void setCOMP_UI_M_CURR_INV_DUE_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_CURR_INV_DUE_DT_LABEL) {
		this.COMP_UI_M_CURR_INV_DUE_DT_LABEL = COMP_UI_M_CURR_INV_DUE_DT_LABEL;
	}

	public void setCOMP_UI_M_CURR_INV_DUE_DT(
			HtmlCalendar COMP_UI_M_CURR_INV_DUE_DT) {
		this.COMP_UI_M_CURR_INV_DUE_DT = COMP_UI_M_CURR_INV_DUE_DT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_APPROVE() {
		return COMP_UI_M_BUT_APPROVE;
	}

	public void setCOMP_UI_M_BUT_APPROVE(HtmlCommandButton COMP_UI_M_BUT_APPROVE) {
		this.COMP_UI_M_BUT_APPROVE = COMP_UI_M_BUT_APPROVE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BROKER_DTLS() {
		return COMP_UI_M_BUT_BROKER_DTLS;
	}

	public void setCOMP_UI_M_BUT_BROKER_DTLS(
			HtmlCommandButton COMP_UI_M_BUT_BROKER_DTLS) {
		this.COMP_UI_M_BUT_BROKER_DTLS = COMP_UI_M_BUT_BROKER_DTLS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CHG_DTL() {
		return COMP_UI_M_BUT_CHG_DTL;
	}

	public void setCOMP_UI_M_BUT_CHG_DTL(HtmlCommandButton COMP_UI_M_BUT_CHG_DTL) {
		this.COMP_UI_M_BUT_CHG_DTL = COMP_UI_M_BUT_CHG_DTL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CVR_DTL() {
		return COMP_UI_M_BUT_CVR_DTL;
	}

	public void setCOMP_UI_M_BUT_CVR_DTL(HtmlCommandButton COMP_UI_M_BUT_CVR_DTL) {
		this.COMP_UI_M_BUT_CVR_DTL = COMP_UI_M_BUT_CVR_DTL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_FAC() {
		return COMP_UI_M_BUT_FAC;
	}

	public void setCOMP_UI_M_BUT_FAC(HtmlCommandButton COMP_UI_M_BUT_FAC) {
		this.COMP_UI_M_BUT_FAC = COMP_UI_M_BUT_FAC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_INT_DTLS() {
		return COMP_UI_M_BUT_INT_DTLS;
	}

	public void setCOMP_UI_M_BUT_INT_DTLS(
			HtmlCommandButton COMP_UI_M_BUT_INT_DTLS) {
		this.COMP_UI_M_BUT_INT_DTLS = COMP_UI_M_BUT_INT_DTLS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_INVEST_DETAILS() {
		return COMP_UI_M_BUT_INVEST_DETAILS;
	}

	public void setCOMP_UI_M_BUT_INVEST_DETAILS(
			HtmlCommandButton COMP_UI_M_BUT_INVEST_DETAILS) {
		this.COMP_UI_M_BUT_INVEST_DETAILS = COMP_UI_M_BUT_INVEST_DETAILS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PYMT_DTLS() {
		return COMP_UI_M_BUT_PYMT_DTLS;
	}

	public void setCOMP_UI_M_BUT_PYMT_DTLS(
			HtmlCommandButton COMP_UI_M_BUT_PYMT_DTLS) {
		this.COMP_UI_M_BUT_PYMT_DTLS = COMP_UI_M_BUT_PYMT_DTLS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_RNEW_PREM_COLL() {
		return COMP_UI_M_BUT_RNEW_PREM_COLL;
	}

	public void setCOMP_UI_M_BUT_RNEW_PREM_COLL(
			HtmlCommandButton COMP_UI_M_BUT_RNEW_PREM_COLL) {
		this.COMP_UI_M_BUT_RNEW_PREM_COLL = COMP_UI_M_BUT_RNEW_PREM_COLL;
	}

	public PT_IL_PREM_COLL getPT_IL_PREM_COLL_BEAN() {
		return PT_IL_PREM_COLL_BEAN;
	}

	public void setPT_IL_PREM_COLL_BEAN(PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN) {
		this.PT_IL_PREM_COLL_BEAN = PT_IL_PREM_COLL_BEAN;
	}

	public PILT024_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT024_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}
	
	
	
	public String clickMoreInfo(){
		
		return "PILT024_PT_IL_PREM_COLL_BREAKUP";
	}
	
	//Added by Ameen on 15-05-2017
	
/*	public void validatePC_WAIVE_PREM_YN(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		String CURSOR_1 = "SELECT 'X' FROM   PT_IL_PREM_COLL_DTL WHERE  PCD_PC_SYS_ID = ?";
		ResultSet rs1 = null;
	    String M_FLAG = null;
		try {
			PT_IL_PREM_COLL_BEAN.setPC_WAIVE_PREM_YN((String) value);
			if("N".equalsIgnoreCase(PT_IL_PREM_COLL_BEAN.getPC_WAIVE_PREM_YN())){
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_FC_UNPAID_PREM_INT().setDisabled(true);
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_LC_UNPAID_PREM_INT().setDisabled(true);
			}else{
				rs1 = new CRUDHandler().executeSelectStatement(CURSOR_1, CommonUtils.getConnection(),
						new Object[]{compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_PC_SYS_ID()});
				if(rs1.next()){
					M_FLAG = rs1.getString(1);
				}
				if(!"X".equalsIgnoreCase(CommonUtils.nvl(M_FLAG ,"Y"))){
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_FC_UNPAID_PREM_INT().setDisabled(false);
					if(!CommonUtils.getGlobalVariable("GLOBAL.M_BASE_CURR").
							equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_CUST_CURR_CODE())){
						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_LC_UNPAID_PREM_INT().setDisabled(false);
					}else{
						compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_LC_UNPAID_PREM_INT().setDisabled(true);
					}
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}
	
	public void validatePC_WAIVE_LOAN_YN(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
	    String M_FLAG = null;
		try {
			PT_IL_PREM_COLL_BEAN.setPC_WAIVE_PREM_YN((String) value);
			if("N".equalsIgnoreCase(PT_IL_PREM_COLL_BEAN.getPC_WAIVE_PREM_YN())){
				
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}*/
	
	public void resetPremDtlsComponents(){
		COMP_PC_FC_BASIC_PREM.resetValue();
		COMP_PC_LC_BASIC_PREM.resetValue();
		COMP_UI_M_PC_FC_PAID_BASIC_PREM.resetValue();
		COMP_UI_M_PC_LC_PAID_BASIC_PREM.resetValue();
		COMP_PC_FC_ADDL_PREM.resetValue();
		COMP_PC_LC_ADDL_PREM.resetValue();
		COMP_UI_M_PC_FC_PAID_ADDL_PREM.resetValue();
		COMP_UI_M_PC_LC_PAID_ADDL_PREM.resetValue();
		COMP_PC_FC_LOAD_AMT.resetValue();
		COMP_PC_LC_LOAD_AMT.resetValue();
		COMP_UI_M_PC_FC_PAID_LOAD.resetValue();
		COMP_UI_M_PC_LC_PAID_LOAD.resetValue();
		COMP_PC_FC_DISCOUNT.resetValue();
		COMP_PC_LC_DISCOUNT.resetValue();
		COMP_UI_M_PC_FC_PAID_DISC.resetValue();
		COMP_UI_M_PC_LC_PAID_DISC.resetValue();
		COMP_PC_FC_CHARGE.resetValue();
		COMP_PC_LC_CHARGE.resetValue();
		COMP_UI_M_PC_FC_PAID_CUST_CHRG.resetValue();
		COMP_UI_M_PC_LC_PAID_CUST_CHRG.resetValue();
		COMP_PC_FC_DUE_CONTR.resetValue();
		COMP_PC_LC_DUE_CONTR.resetValue();
		COMP_UI_M_PC_FC_PAID_CONTR.resetValue();
		COMP_UI_M_PC_LC_PAID_CONTR.resetValue();
		COMP_UI_M_TOPUP_DUE_FC_AMT.resetValue();
		COMP_UI_M_TOPUP_DUE_LC_AMT.resetValue();
		COMP_UI_M_TOPUP_PAID_FC_AMT.resetValue();
		COMP_UI_M_TOPUP_PAID_LC_AMT.resetValue();
		COMP_PC_FC_INV_DUE_CHRG.resetValue();
		COMP_PC_LC_INV_DUE_CHRG.resetValue();
		COMP_UI_M_PC_FC_INV_PAID_CHRG.resetValue();
		COMP_UI_M_PC_LC_INV_PAID_CHRG.resetValue();
	}
	
	//End
	
}