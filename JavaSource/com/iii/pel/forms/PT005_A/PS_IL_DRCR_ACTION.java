package com.iii.pel.forms.PT005_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PS_IL_DRCR_ACTION extends CommonAction {
	private PT_IL_POLICY PT_IL_POLICY_BEAN;

	private HtmlOutputLabel COMP_DRCR_TXN_CODE_LABEL;

	private HtmlInputText COMP_DRCR_TXN_CODE;

	private HtmlOutputLabel COMP_DRCR_DOC_DT_LABEL;

	private HtmlCalendar COMP_DRCR_DOC_DT;

	private HtmlOutputLabel COMP_DRCR_DOC_NO_LABEL;

	private HtmlInputText COMP_DRCR_DOC_NO;

	private HtmlOutputLabel COMP_DRCR_SEQ_NO_LABEL;

	private HtmlInputText COMP_DRCR_SEQ_NO;

	private HtmlOutputLabel COMP_DRCR_DOC_TYPE_LABEL;

	private HtmlInputText COMP_DRCR_DOC_TYPE;

	private HtmlOutputLabel COMP_DRCR_DRCR_FLAG_LABEL;

	private HtmlInputText COMP_DRCR_DRCR_FLAG;

	private HtmlOutputLabel COMP_DRCR_CURR_CODE_LABEL;

	private HtmlInputText COMP_DRCR_CURR_CODE;

	private HtmlOutputLabel COMP_DRCR_FC_AMT_LABEL;

	private HtmlInputText COMP_DRCR_FC_AMT;

	private HtmlOutputLabel COMP_DRCR_LC_AMT_LABEL;

	private HtmlInputText COMP_DRCR_LC_AMT;

	private HtmlOutputLabel COMP_DRCR_MAIN_ACNT_CODE_LABEL;

	private HtmlInputText COMP_DRCR_MAIN_ACNT_CODE;

	private HtmlOutputLabel COMP_DRCR_SUB_ACNT_CODE_LABEL;

	private HtmlInputText COMP_DRCR_SUB_ACNT_CODE;

	private HtmlOutputLabel COMP_DRCR_ACNT_YEAR_LABEL;

	private HtmlInputText COMP_DRCR_ACNT_YEAR;

	private HtmlOutputLabel COMP_DRCR_POST_YN_LABEL;

	private HtmlInputText COMP_DRCR_POST_YN;

	private HtmlOutputLabel COMP_DRCR_ANLY_CODE_1_LABEL;

	private HtmlInputText COMP_DRCR_ANLY_CODE_1;

	private HtmlOutputLabel COMP_DRCR_POL_NO_LABEL;

	private HtmlInputText COMP_DRCR_POL_NO;

	private HtmlOutputLabel COMP_DRCR_ANLY_CODE_2_LABEL;

	private HtmlInputText COMP_DRCR_ANLY_CODE_2;

	private HtmlOutputLabel COMP_DRCR_CUST_CODE_LABEL;

	private HtmlInputText COMP_DRCR_CUST_CODE;

	private HtmlOutputLabel COMP_UI_M_DRCR_CUST_NAME_LABEL;

	private HtmlInputText COMP_UI_M_DRCR_CUST_NAME;

	private HtmlOutputLabel COMP_DRCR_ACTY_CODE_1_LABEL;

	private HtmlInputText COMP_DRCR_ACTY_CODE_1;

	private HtmlOutputLabel COMP_DRCR_CLAIM_NO_LABEL;

	private HtmlInputText COMP_DRCR_CLAIM_NO;

	private HtmlOutputLabel COMP_DRCR_ACTY_CODE_2_LABEL;

	private HtmlInputText COMP_DRCR_ACTY_CODE_2;

	private HtmlOutputLabel COMP_DRCR_END_NO_LABEL;

	private HtmlInputText COMP_DRCR_END_NO;

	private HtmlOutputLabel COMP_DRCR_NARRATION_LABEL;

	private HtmlInputText COMP_DRCR_NARRATION;

	private HtmlOutputLabel COMP_UI_M_MAIN_ACNT_DESC_LABEL;

	private HtmlInputText COMP_UI_M_MAIN_ACNT_DESC;

	private HtmlOutputLabel COMP_DRCR_BL_NARRATION_LABEL;

	private HtmlInputText COMP_DRCR_BL_NARRATION;

	private HtmlOutputLabel COMP_UI_M_SUB_ACNT_DESC_LABEL;

	private HtmlInputText COMP_UI_M_SUB_ACNT_DESC;

	private PS_IL_DRCR PS_IL_DRCR_BEAN;
	
	private UIDataTable dataTable;

	private List<PS_IL_DRCR> dataList_PS_IL_DRCR = new ArrayList<PS_IL_DRCR>();

	public PS_IL_DRCR_ACTION() {
		PS_IL_DRCR_BEAN = new PS_IL_DRCR();
		PT_IL_POLICY_BEAN=new PT_IL_POLICY();
		intitiateAll();
	}

	public PT_IL_POLICY getPT_IL_POLICY_BEAN() {
		return PT_IL_POLICY_BEAN;
	}

	public void setPT_IL_POLICY_BEAN(PT_IL_POLICY pT_IL_POLICY_BEAN) {
		PT_IL_POLICY_BEAN = pT_IL_POLICY_BEAN;
	}

	public HtmlOutputLabel getCOMP_DRCR_TXN_CODE_LABEL() {
		return COMP_DRCR_TXN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_TXN_CODE() {
		return COMP_DRCR_TXN_CODE;
	}

	public void setCOMP_DRCR_TXN_CODE_LABEL(HtmlOutputLabel COMP_DRCR_TXN_CODE_LABEL) {
		this.COMP_DRCR_TXN_CODE_LABEL = COMP_DRCR_TXN_CODE_LABEL;
	}

	public void setCOMP_DRCR_TXN_CODE(HtmlInputText COMP_DRCR_TXN_CODE) {
		this.COMP_DRCR_TXN_CODE = COMP_DRCR_TXN_CODE;
	}

	public HtmlOutputLabel getCOMP_DRCR_DOC_DT_LABEL() {
		return COMP_DRCR_DOC_DT_LABEL;
	}

	public HtmlCalendar getCOMP_DRCR_DOC_DT() {
		return COMP_DRCR_DOC_DT;
	}

	public void setCOMP_DRCR_DOC_DT_LABEL(HtmlOutputLabel COMP_DRCR_DOC_DT_LABEL) {
		this.COMP_DRCR_DOC_DT_LABEL = COMP_DRCR_DOC_DT_LABEL;
	}

	public void setCOMP_DRCR_DOC_DT(HtmlCalendar COMP_DRCR_DOC_DT) {
		this.COMP_DRCR_DOC_DT = COMP_DRCR_DOC_DT;
	}

	public HtmlOutputLabel getCOMP_DRCR_DOC_NO_LABEL() {
		return COMP_DRCR_DOC_NO_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_DOC_NO() {
		return COMP_DRCR_DOC_NO;
	}

	public void setCOMP_DRCR_DOC_NO_LABEL(HtmlOutputLabel COMP_DRCR_DOC_NO_LABEL) {
		this.COMP_DRCR_DOC_NO_LABEL = COMP_DRCR_DOC_NO_LABEL;
	}

	public void setCOMP_DRCR_DOC_NO(HtmlInputText COMP_DRCR_DOC_NO) {
		this.COMP_DRCR_DOC_NO = COMP_DRCR_DOC_NO;
	}

	public HtmlOutputLabel getCOMP_DRCR_SEQ_NO_LABEL() {
		return COMP_DRCR_SEQ_NO_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_SEQ_NO() {
		return COMP_DRCR_SEQ_NO;
	}

	public void setCOMP_DRCR_SEQ_NO_LABEL(HtmlOutputLabel COMP_DRCR_SEQ_NO_LABEL) {
		this.COMP_DRCR_SEQ_NO_LABEL = COMP_DRCR_SEQ_NO_LABEL;
	}

	public void setCOMP_DRCR_SEQ_NO(HtmlInputText COMP_DRCR_SEQ_NO) {
		this.COMP_DRCR_SEQ_NO = COMP_DRCR_SEQ_NO;
	}

	public HtmlOutputLabel getCOMP_DRCR_DOC_TYPE_LABEL() {
		return COMP_DRCR_DOC_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_DOC_TYPE() {
		return COMP_DRCR_DOC_TYPE;
	}

	public void setCOMP_DRCR_DOC_TYPE_LABEL(HtmlOutputLabel COMP_DRCR_DOC_TYPE_LABEL) {
		this.COMP_DRCR_DOC_TYPE_LABEL = COMP_DRCR_DOC_TYPE_LABEL;
	}

	public void setCOMP_DRCR_DOC_TYPE(HtmlInputText COMP_DRCR_DOC_TYPE) {
		this.COMP_DRCR_DOC_TYPE = COMP_DRCR_DOC_TYPE;
	}

	public HtmlOutputLabel getCOMP_DRCR_DRCR_FLAG_LABEL() {
		return COMP_DRCR_DRCR_FLAG_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_DRCR_FLAG() {
		return COMP_DRCR_DRCR_FLAG;
	}

	public void setCOMP_DRCR_DRCR_FLAG_LABEL(HtmlOutputLabel COMP_DRCR_DRCR_FLAG_LABEL) {
		this.COMP_DRCR_DRCR_FLAG_LABEL = COMP_DRCR_DRCR_FLAG_LABEL;
	}

	public void setCOMP_DRCR_DRCR_FLAG(HtmlInputText COMP_DRCR_DRCR_FLAG) {
		this.COMP_DRCR_DRCR_FLAG = COMP_DRCR_DRCR_FLAG;
	}

	public HtmlOutputLabel getCOMP_DRCR_CURR_CODE_LABEL() {
		return COMP_DRCR_CURR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_CURR_CODE() {
		return COMP_DRCR_CURR_CODE;
	}

	public void setCOMP_DRCR_CURR_CODE_LABEL(HtmlOutputLabel COMP_DRCR_CURR_CODE_LABEL) {
		this.COMP_DRCR_CURR_CODE_LABEL = COMP_DRCR_CURR_CODE_LABEL;
	}

	public void setCOMP_DRCR_CURR_CODE(HtmlInputText COMP_DRCR_CURR_CODE) {
		this.COMP_DRCR_CURR_CODE = COMP_DRCR_CURR_CODE;
	}

	public HtmlOutputLabel getCOMP_DRCR_FC_AMT_LABEL() {
		return COMP_DRCR_FC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_FC_AMT() {
		return COMP_DRCR_FC_AMT;
	}

	public void setCOMP_DRCR_FC_AMT_LABEL(HtmlOutputLabel COMP_DRCR_FC_AMT_LABEL) {
		this.COMP_DRCR_FC_AMT_LABEL = COMP_DRCR_FC_AMT_LABEL;
	}

	public void setCOMP_DRCR_FC_AMT(HtmlInputText COMP_DRCR_FC_AMT) {
		this.COMP_DRCR_FC_AMT = COMP_DRCR_FC_AMT;
	}

	public HtmlOutputLabel getCOMP_DRCR_LC_AMT_LABEL() {
		return COMP_DRCR_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_LC_AMT() {
		return COMP_DRCR_LC_AMT;
	}

	public void setCOMP_DRCR_LC_AMT_LABEL(HtmlOutputLabel COMP_DRCR_LC_AMT_LABEL) {
		this.COMP_DRCR_LC_AMT_LABEL = COMP_DRCR_LC_AMT_LABEL;
	}

	public void setCOMP_DRCR_LC_AMT(HtmlInputText COMP_DRCR_LC_AMT) {
		this.COMP_DRCR_LC_AMT = COMP_DRCR_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_DRCR_MAIN_ACNT_CODE_LABEL() {
		return COMP_DRCR_MAIN_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_MAIN_ACNT_CODE() {
		return COMP_DRCR_MAIN_ACNT_CODE;
	}

	public void setCOMP_DRCR_MAIN_ACNT_CODE_LABEL(HtmlOutputLabel COMP_DRCR_MAIN_ACNT_CODE_LABEL) {
		this.COMP_DRCR_MAIN_ACNT_CODE_LABEL = COMP_DRCR_MAIN_ACNT_CODE_LABEL;
	}

	public void setCOMP_DRCR_MAIN_ACNT_CODE(HtmlInputText COMP_DRCR_MAIN_ACNT_CODE) {
		this.COMP_DRCR_MAIN_ACNT_CODE = COMP_DRCR_MAIN_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_DRCR_SUB_ACNT_CODE_LABEL() {
		return COMP_DRCR_SUB_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_SUB_ACNT_CODE() {
		return COMP_DRCR_SUB_ACNT_CODE;
	}

	public void setCOMP_DRCR_SUB_ACNT_CODE_LABEL(HtmlOutputLabel COMP_DRCR_SUB_ACNT_CODE_LABEL) {
		this.COMP_DRCR_SUB_ACNT_CODE_LABEL = COMP_DRCR_SUB_ACNT_CODE_LABEL;
	}

	public void setCOMP_DRCR_SUB_ACNT_CODE(HtmlInputText COMP_DRCR_SUB_ACNT_CODE) {
		this.COMP_DRCR_SUB_ACNT_CODE = COMP_DRCR_SUB_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_DRCR_ACNT_YEAR_LABEL() {
		return COMP_DRCR_ACNT_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_ACNT_YEAR() {
		return COMP_DRCR_ACNT_YEAR;
	}

	public void setCOMP_DRCR_ACNT_YEAR_LABEL(HtmlOutputLabel COMP_DRCR_ACNT_YEAR_LABEL) {
		this.COMP_DRCR_ACNT_YEAR_LABEL = COMP_DRCR_ACNT_YEAR_LABEL;
	}

	public void setCOMP_DRCR_ACNT_YEAR(HtmlInputText COMP_DRCR_ACNT_YEAR) {
		this.COMP_DRCR_ACNT_YEAR = COMP_DRCR_ACNT_YEAR;
	}

	public HtmlOutputLabel getCOMP_DRCR_POST_YN_LABEL() {
		return COMP_DRCR_POST_YN_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_POST_YN() {
		return COMP_DRCR_POST_YN;
	}

	public void setCOMP_DRCR_POST_YN_LABEL(HtmlOutputLabel COMP_DRCR_POST_YN_LABEL) {
		this.COMP_DRCR_POST_YN_LABEL = COMP_DRCR_POST_YN_LABEL;
	}

	public void setCOMP_DRCR_POST_YN(HtmlInputText COMP_DRCR_POST_YN) {
		this.COMP_DRCR_POST_YN = COMP_DRCR_POST_YN;
	}

	public HtmlOutputLabel getCOMP_DRCR_ANLY_CODE_1_LABEL() {
		return COMP_DRCR_ANLY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_ANLY_CODE_1() {
		return COMP_DRCR_ANLY_CODE_1;
	}

	public void setCOMP_DRCR_ANLY_CODE_1_LABEL(HtmlOutputLabel COMP_DRCR_ANLY_CODE_1_LABEL) {
		this.COMP_DRCR_ANLY_CODE_1_LABEL = COMP_DRCR_ANLY_CODE_1_LABEL;
	}

	public void setCOMP_DRCR_ANLY_CODE_1(HtmlInputText COMP_DRCR_ANLY_CODE_1) {
		this.COMP_DRCR_ANLY_CODE_1 = COMP_DRCR_ANLY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_DRCR_POL_NO_LABEL() {
		return COMP_DRCR_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_POL_NO() {
		return COMP_DRCR_POL_NO;
	}

	public void setCOMP_DRCR_POL_NO_LABEL(HtmlOutputLabel COMP_DRCR_POL_NO_LABEL) {
		this.COMP_DRCR_POL_NO_LABEL = COMP_DRCR_POL_NO_LABEL;
	}

	public void setCOMP_DRCR_POL_NO(HtmlInputText COMP_DRCR_POL_NO) {
		this.COMP_DRCR_POL_NO = COMP_DRCR_POL_NO;
	}

	public HtmlOutputLabel getCOMP_DRCR_ANLY_CODE_2_LABEL() {
		return COMP_DRCR_ANLY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_ANLY_CODE_2() {
		return COMP_DRCR_ANLY_CODE_2;
	}

	public void setCOMP_DRCR_ANLY_CODE_2_LABEL(HtmlOutputLabel COMP_DRCR_ANLY_CODE_2_LABEL) {
		this.COMP_DRCR_ANLY_CODE_2_LABEL = COMP_DRCR_ANLY_CODE_2_LABEL;
	}

	public void setCOMP_DRCR_ANLY_CODE_2(HtmlInputText COMP_DRCR_ANLY_CODE_2) {
		this.COMP_DRCR_ANLY_CODE_2 = COMP_DRCR_ANLY_CODE_2;
	}

	public HtmlOutputLabel getCOMP_DRCR_CUST_CODE_LABEL() {
		return COMP_DRCR_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_CUST_CODE() {
		return COMP_DRCR_CUST_CODE;
	}

	public void setCOMP_DRCR_CUST_CODE_LABEL(HtmlOutputLabel COMP_DRCR_CUST_CODE_LABEL) {
		this.COMP_DRCR_CUST_CODE_LABEL = COMP_DRCR_CUST_CODE_LABEL;
	}

	public void setCOMP_DRCR_CUST_CODE(HtmlInputText COMP_DRCR_CUST_CODE) {
		this.COMP_DRCR_CUST_CODE = COMP_DRCR_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DRCR_CUST_NAME_LABEL() {
		return COMP_UI_M_DRCR_CUST_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DRCR_CUST_NAME() {
		return COMP_UI_M_DRCR_CUST_NAME;
	}

	public void setCOMP_UI_M_DRCR_CUST_NAME_LABEL(HtmlOutputLabel COMP_UI_M_DRCR_CUST_NAME_LABEL) {
		this.COMP_UI_M_DRCR_CUST_NAME_LABEL = COMP_UI_M_DRCR_CUST_NAME_LABEL;
	}

	public void setCOMP_UI_M_DRCR_CUST_NAME(HtmlInputText COMP_UI_M_DRCR_CUST_NAME) {
		this.COMP_UI_M_DRCR_CUST_NAME = COMP_UI_M_DRCR_CUST_NAME;
	}

	public HtmlOutputLabel getCOMP_DRCR_ACTY_CODE_1_LABEL() {
		return COMP_DRCR_ACTY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_ACTY_CODE_1() {
		return COMP_DRCR_ACTY_CODE_1;
	}

	public void setCOMP_DRCR_ACTY_CODE_1_LABEL(HtmlOutputLabel COMP_DRCR_ACTY_CODE_1_LABEL) {
		this.COMP_DRCR_ACTY_CODE_1_LABEL = COMP_DRCR_ACTY_CODE_1_LABEL;
	}

	public void setCOMP_DRCR_ACTY_CODE_1(HtmlInputText COMP_DRCR_ACTY_CODE_1) {
		this.COMP_DRCR_ACTY_CODE_1 = COMP_DRCR_ACTY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_DRCR_CLAIM_NO_LABEL() {
		return COMP_DRCR_CLAIM_NO_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_CLAIM_NO() {
		return COMP_DRCR_CLAIM_NO;
	}

	public void setCOMP_DRCR_CLAIM_NO_LABEL(HtmlOutputLabel COMP_DRCR_CLAIM_NO_LABEL) {
		this.COMP_DRCR_CLAIM_NO_LABEL = COMP_DRCR_CLAIM_NO_LABEL;
	}

	public void setCOMP_DRCR_CLAIM_NO(HtmlInputText COMP_DRCR_CLAIM_NO) {
		this.COMP_DRCR_CLAIM_NO = COMP_DRCR_CLAIM_NO;
	}

	public HtmlOutputLabel getCOMP_DRCR_ACTY_CODE_2_LABEL() {
		return COMP_DRCR_ACTY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_ACTY_CODE_2() {
		return COMP_DRCR_ACTY_CODE_2;
	}

	public void setCOMP_DRCR_ACTY_CODE_2_LABEL(HtmlOutputLabel COMP_DRCR_ACTY_CODE_2_LABEL) {
		this.COMP_DRCR_ACTY_CODE_2_LABEL = COMP_DRCR_ACTY_CODE_2_LABEL;
	}

	public void setCOMP_DRCR_ACTY_CODE_2(HtmlInputText COMP_DRCR_ACTY_CODE_2) {
		this.COMP_DRCR_ACTY_CODE_2 = COMP_DRCR_ACTY_CODE_2;
	}

	public HtmlOutputLabel getCOMP_DRCR_END_NO_LABEL() {
		return COMP_DRCR_END_NO_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_END_NO() {
		return COMP_DRCR_END_NO;
	}

	public void setCOMP_DRCR_END_NO_LABEL(HtmlOutputLabel COMP_DRCR_END_NO_LABEL) {
		this.COMP_DRCR_END_NO_LABEL = COMP_DRCR_END_NO_LABEL;
	}

	public void setCOMP_DRCR_END_NO(HtmlInputText COMP_DRCR_END_NO) {
		this.COMP_DRCR_END_NO = COMP_DRCR_END_NO;
	}

	public HtmlOutputLabel getCOMP_DRCR_NARRATION_LABEL() {
		return COMP_DRCR_NARRATION_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_NARRATION() {
		return COMP_DRCR_NARRATION;
	}

	public void setCOMP_DRCR_NARRATION_LABEL(HtmlOutputLabel COMP_DRCR_NARRATION_LABEL) {
		this.COMP_DRCR_NARRATION_LABEL = COMP_DRCR_NARRATION_LABEL;
	}

	public void setCOMP_DRCR_NARRATION(HtmlInputText COMP_DRCR_NARRATION) {
		this.COMP_DRCR_NARRATION = COMP_DRCR_NARRATION;
	}

	public HtmlOutputLabel getCOMP_UI_M_MAIN_ACNT_DESC_LABEL() {
		return COMP_UI_M_MAIN_ACNT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_MAIN_ACNT_DESC() {
		return COMP_UI_M_MAIN_ACNT_DESC;
	}

	public void setCOMP_UI_M_MAIN_ACNT_DESC_LABEL(HtmlOutputLabel COMP_UI_M_MAIN_ACNT_DESC_LABEL) {
		this.COMP_UI_M_MAIN_ACNT_DESC_LABEL = COMP_UI_M_MAIN_ACNT_DESC_LABEL;
	}

	public void setCOMP_UI_M_MAIN_ACNT_DESC(HtmlInputText COMP_UI_M_MAIN_ACNT_DESC) {
		this.COMP_UI_M_MAIN_ACNT_DESC = COMP_UI_M_MAIN_ACNT_DESC;
	}

	public HtmlOutputLabel getCOMP_DRCR_BL_NARRATION_LABEL() {
		return COMP_DRCR_BL_NARRATION_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_BL_NARRATION() {
		return COMP_DRCR_BL_NARRATION;
	}

	public void setCOMP_DRCR_BL_NARRATION_LABEL(HtmlOutputLabel COMP_DRCR_BL_NARRATION_LABEL) {
		this.COMP_DRCR_BL_NARRATION_LABEL = COMP_DRCR_BL_NARRATION_LABEL;
	}

	public void setCOMP_DRCR_BL_NARRATION(HtmlInputText COMP_DRCR_BL_NARRATION) {
		this.COMP_DRCR_BL_NARRATION = COMP_DRCR_BL_NARRATION;
	}

	public HtmlOutputLabel getCOMP_UI_M_SUB_ACNT_DESC_LABEL() {
		return COMP_UI_M_SUB_ACNT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_SUB_ACNT_DESC() {
		return COMP_UI_M_SUB_ACNT_DESC;
	}

	public void setCOMP_UI_M_SUB_ACNT_DESC_LABEL(HtmlOutputLabel COMP_UI_M_SUB_ACNT_DESC_LABEL) {
		this.COMP_UI_M_SUB_ACNT_DESC_LABEL = COMP_UI_M_SUB_ACNT_DESC_LABEL;
	}

	public void setCOMP_UI_M_SUB_ACNT_DESC(HtmlInputText COMP_UI_M_SUB_ACNT_DESC) {
		this.COMP_UI_M_SUB_ACNT_DESC = COMP_UI_M_SUB_ACNT_DESC;
	}

	public PS_IL_DRCR getPS_IL_DRCR_BEAN() {
		return PS_IL_DRCR_BEAN;
	}

	public void setPS_IL_DRCR_BEAN(PS_IL_DRCR PS_IL_DRCR_BEAN) {
		this.PS_IL_DRCR_BEAN = PS_IL_DRCR_BEAN;
	}

	public List<PS_IL_DRCR> getDataList_PS_IL_DRCR() {
		return dataList_PS_IL_DRCR;
	}

	public void setDataListPS_IL_DRCR(List<PS_IL_DRCR> dataList_PS_IL_DRCR) {
		this.dataList_PS_IL_DRCR = dataList_PS_IL_DRCR;
	}
	
	
	public String preBack()
	{
		String actionClass = "PT005_A_PS_IL_DRCR_SEARCH_PAGE_ACTION";
		String actionMethod = "fetchDataBaseDetails";
		String returnString= "navigateToAccountQuerySearchPage";
		CommonUtils commonUtils = new CommonUtils();
		commonUtils.callRetaintion(actionClass, actionMethod);
			
		return returnString;
	}

	public UIDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public void setDataList_PS_IL_DRCR(List<PS_IL_DRCR> dataList_PS_IL_DRCR) {
		this.dataList_PS_IL_DRCR = dataList_PS_IL_DRCR;
	}
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			if (dataList_PS_IL_DRCR.size() != 0) {
				PS_IL_DRCR_BEAN = (PS_IL_DRCR) dataTable
						.getRowData();
			}
			resetAllComponent();
			// Reset selection for other beans
			resetSelectedRow();
			PS_IL_DRCR_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap()
					.put(com.iii.premia.common.constants.PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
	private void resetSelectedRow() {
		Iterator<PS_IL_DRCR> iterator = dataList_PS_IL_DRCR.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}
	public void resetAllComponent()
	{
		COMP_DRCR_TXN_CODE.resetValue();
		COMP_DRCR_DOC_DT.resetValue();
		COMP_DRCR_DOC_NO.resetValue();
		COMP_DRCR_SEQ_NO.resetValue();
		COMP_DRCR_DOC_TYPE.resetValue();
		COMP_DRCR_DRCR_FLAG.resetValue();
		COMP_DRCR_CURR_CODE.resetValue();
		COMP_DRCR_FC_AMT.resetValue();
		COMP_DRCR_LC_AMT.resetValue();
		COMP_DRCR_MAIN_ACNT_CODE.resetValue();
		COMP_DRCR_SUB_ACNT_CODE.resetValue();
		COMP_DRCR_ACNT_YEAR.resetValue();
		COMP_DRCR_POST_YN.resetValue();
		COMP_DRCR_ANLY_CODE_1.resetValue();
		COMP_DRCR_POL_NO.resetValue();
		COMP_DRCR_ANLY_CODE_2.resetValue();
		COMP_DRCR_CUST_CODE.resetValue();
		COMP_UI_M_DRCR_CUST_NAME.resetValue();
		COMP_DRCR_ACTY_CODE_1.resetValue();
		COMP_DRCR_CLAIM_NO.resetValue();
		COMP_DRCR_ACTY_CODE_2.resetValue();
		COMP_DRCR_END_NO.resetValue();
		COMP_DRCR_NARRATION.resetValue();
		COMP_UI_M_MAIN_ACNT_DESC.resetValue();
		COMP_DRCR_BL_NARRATION.resetValue();
		COMP_UI_M_SUB_ACNT_DESC.resetValue();
	}
	public void intitiateAll()
	{
		COMP_DRCR_TXN_CODE=new HtmlInputText();
		COMP_DRCR_DOC_DT=new HtmlCalendar();
		COMP_DRCR_DOC_NO=new HtmlInputText();
		COMP_DRCR_SEQ_NO=new HtmlInputText();
		COMP_DRCR_DOC_TYPE=new HtmlInputText();
		COMP_DRCR_DRCR_FLAG=new HtmlInputText();
		COMP_DRCR_CURR_CODE=new HtmlInputText();
		COMP_DRCR_FC_AMT=new HtmlInputText();
		COMP_DRCR_LC_AMT=new HtmlInputText();
		COMP_DRCR_MAIN_ACNT_CODE=new HtmlInputText();
		COMP_DRCR_SUB_ACNT_CODE=new HtmlInputText();
		COMP_DRCR_ACNT_YEAR=new HtmlInputText();
		COMP_DRCR_POST_YN=new HtmlInputText();
		COMP_DRCR_ANLY_CODE_1=new HtmlInputText();
		COMP_DRCR_POL_NO=new HtmlInputText();
		COMP_DRCR_ANLY_CODE_2=new HtmlInputText();
		COMP_DRCR_CUST_CODE=new HtmlInputText();
		COMP_UI_M_DRCR_CUST_NAME=new HtmlInputText();
		COMP_DRCR_ACTY_CODE_1=new HtmlInputText();
		COMP_DRCR_CLAIM_NO=new HtmlInputText();
		COMP_DRCR_ACTY_CODE_2=new HtmlInputText();
		COMP_DRCR_END_NO=new HtmlInputText();
		COMP_DRCR_NARRATION=new HtmlInputText();
		COMP_UI_M_MAIN_ACNT_DESC=new HtmlInputText();
		COMP_DRCR_BL_NARRATION=new HtmlInputText();
		COMP_UI_M_SUB_ACNT_DESC=new HtmlInputText();
	}
	
	public void getDetails(ActionEvent event) {
		try {
			int rowIndex = dataTable.getRowIndex();
			if (dataList_PS_IL_DRCR.size() != 0) {
				PS_IL_DRCR_BEAN = (PS_IL_DRCR) dataTable.getRowData();
				//resetRowSelection();
				resetSelectedRow();
				PS_IL_DRCR_BEAN.setRowSelected(true);
				resetAllComponent();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	
	public void onLoad(PhaseEvent event) throws DBException, SQLException {
		String ROWID=null;
		System.out.println("inside onLoad........................");
		try {
		 if (isBlockFlag()) {
			 
		 PS_IL_DRCR_DELEAGTE  ps_il_drcr_deleagte=new PS_IL_DRCR_DELEAGTE();
		 List<PS_IL_DRCR> dataList=new ArrayList<PS_IL_DRCR>();
		 dataList=ps_il_drcr_deleagte.getBlockData(this);
		 System.out.println("size of list-------------"+dataList.size());
		 setDataListPS_IL_DRCR(dataList);
		  setBlockFlag(false);
		 }
		
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	

		/*String ROWID = null; 
		String POL_CUST_CODE = null;
		
		if(isBlockFlag()){
			ROWID = CommonUtils.getGlobalVariable("GLOBAL.POLICY_ROWID");
			POL_CUST_CODE = CommonUtils.getGlobalVariable("GLOBAL.POLICY_POL_CUST_CODE");
			
			if((ROWID != null) && (POL_CUST_CODE != null)){
				populate_PT_IL_POLICY(ROWID);
				populate_PS_IL_DRCR(PT_GL_POLICY_BEAN.getPOL_SYS_ID());
				
			}else{
				
			}
			setBlockFlag(false);
		}*/
	}
	private void populate_PT_IL_POLICY(String rowid) throws Exception{
		String policyQuery = "SELECT ROWID,POL_SYS_ID,POL_CUST_CODE,POL_NO,POL_END_NO FROM PT_GL_POLICY WHERE ROWID = ?";
		CRUDHandler handler = new CRUDHandler();
		Connection con = CommonUtils.getConnection();
		Object[] obj = new Object[1];
		obj[0] = rowid;
		ResultSet rs =  handler.executeSelectStatement(policyQuery, con, obj);
		while(rs.next()){
			PT_IL_POLICY_BEAN.setROWID(rs.getString(1));
			PT_IL_POLICY_BEAN.setPOL_SYS_ID(rs.getString(2)==null?"":String.valueOf(rs.getString(2)));
			PT_IL_POLICY_BEAN.setPOL_CUST_CODE(rs.getString(3)==null?"":String.valueOf(rs.getString(3)));
			PT_IL_POLICY_BEAN.setPOL_NO(rs.getString(4)==null?"":String.valueOf(rs.getString(4)));
//			PT_GL_POLICY_BEAN.setPOL_QUOT_NO(rs.getString(5)==null?"":String.valueOf(rs.getString(5)));
			PT_IL_POLICY_BEAN.setPOL_END_NO(rs.getString(5)==null?"":String.valueOf(rs.getString(5)));
			PT_IL_POLICY_BEAN.setCUST_NAME(getCustomerName(PT_IL_POLICY_BEAN.getPOL_CUST_CODE()));
		}
		return;
	}
	private String getCustomerName(String CUST_CODE) throws Exception{
		String CUST_NAME = "";
		String query ="SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE = ?";
		Connection con = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		Object[] obj = new Object[1];
		obj[0] = CUST_CODE;
		ResultSet rs = handler.executeSelectStatement(query, con, obj);
		while(rs.next()){
			CUST_NAME = rs.getString(1);
		}
		rs.close();
		return CUST_NAME;
	}
}
