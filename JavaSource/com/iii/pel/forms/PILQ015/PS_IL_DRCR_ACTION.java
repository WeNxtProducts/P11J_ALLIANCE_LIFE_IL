package com.iii.pel.forms.PILQ015;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.premia.common.action.CommonAction;

public class PS_IL_DRCR_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_DRCR_DRCR_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_DRCR_DRCR_FLAG;

	private HtmlOutputLabel COMP_DRCR_TXN_CODE_LABEL;

	private HtmlInputText COMP_DRCR_TXN_CODE;

	private HtmlOutputLabel COMP_DRCR_DOC_NO_LABEL;

	private HtmlInputText COMP_DRCR_DOC_NO;

	private HtmlOutputLabel COMP_DRCR_SEQ_NO_LABEL;

	private HtmlInputText COMP_DRCR_SEQ_NO;

	private HtmlOutputLabel COMP_DRCR_DOC_DT_LABEL;

	private HtmlCalendar COMP_DRCR_DOC_DT;

	private HtmlOutputLabel COMP_DRCR_POL_NO_LABEL;

	private HtmlInputText COMP_DRCR_POL_NO;

	private HtmlOutputLabel COMP_DRCR_LC_AMT_LABEL;

	private HtmlInputText COMP_DRCR_LC_AMT;

	private HtmlOutputLabel COMP_DRCR_MAIN_ACNT_CODE_LABEL;

	private HtmlInputText COMP_DRCR_MAIN_ACNT_CODE;

	private HtmlOutputLabel COMP_DRCR_SUB_ACNT_CODE_LABEL;

	private HtmlInputText COMP_DRCR_SUB_ACNT_CODE;

	private HtmlOutputLabel COMP_UI_M_DRCR_LC_TOT_DR_LABEL;

	private HtmlInputText COMP_UI_M_DRCR_LC_TOT_DR;

	private HtmlOutputLabel COMP_DRCR_NARRATION_LABEL;

	private HtmlInputText COMP_DRCR_NARRATION;

	private HtmlOutputLabel COMP_DRCR_POST_YN_LABEL;

	private HtmlSelectOneMenu COMP_DRCR_POST_YN;

	private HtmlOutputLabel COMP_UI_M_DRCR_LC_TOT_CR_LABEL;

	private HtmlInputText COMP_UI_M_DRCR_LC_TOT_CR;

	private HtmlOutputLabel COMP_DRCR_END_NO_LABEL;

	private HtmlInputText COMP_DRCR_END_NO;

	private HtmlOutputLabel COMP_DRCR_ANLY_CODE_1_LABEL;

	private HtmlInputText COMP_DRCR_ANLY_CODE_1;

	private HtmlOutputLabel COMP_DRCR_ANLY_CODE_2_LABEL;

	private HtmlInputText COMP_DRCR_ANLY_CODE_2;

	private HtmlOutputLabel COMP_DRCR_ACTY_CODE_1_LABEL;

	private HtmlInputText COMP_DRCR_ACTY_CODE_1;

	private HtmlOutputLabel COMP_DRCR_ACTY_CODE_2_LABEL;

	private HtmlInputText COMP_DRCR_ACTY_CODE_2;

	private HtmlOutputLabel COMP_DRCR_CUST_CODE_LABEL;

	private HtmlInputText COMP_DRCR_CUST_CODE;

	private HtmlOutputLabel COMP_DRCR_DIVN_CODE_LABEL;

	private HtmlInputText COMP_DRCR_DIVN_CODE;

	private HtmlOutputLabel COMP_DRCR_DEPT_CODE_LABEL;

	private HtmlInputText COMP_DRCR_DEPT_CODE;

	private HtmlOutputLabel COMP_DRCR_CLAIM_NO_LABEL;

	private HtmlInputText COMP_DRCR_CLAIM_NO;

	private PS_IL_DRCR PS_IL_DRCR_BEAN;
	
	private List ynList;
	
	private UIData data;
	
	private String  filterByDRCR_TXN_CODE;
	private String  filterByDRCR_DOC_NO;
	private String  filterByDRCR_SEQ_NO;
	private String  filterByDRCR_DOC_DT;
	private String  filterByDRCR_MAIN_ACNT_CODE;
	private String  filterByDRCR_SUB_ACNT_CODE;
	private String filterByDRCR_LC_AMT;

	private List<PS_IL_DRCR> dataList_PS_IL_DRCR = new ArrayList<PS_IL_DRCR>();
	
	PT_IL_POLICY_DELEGATE delegate = new PT_IL_POLICY_DELEGATE();

	public PS_IL_DRCR_ACTION() {
		PS_IL_DRCR_BEAN = new PS_IL_DRCR();
		ynList = delegate.comboBoxValues("PILQ015", "PS_IL_DRCR",
				"PS_IL_DRCR.DRCR_POST_YN", "ILPOSTFLAG");
	}

	public HtmlOutputLabel getCOMP_DRCR_DRCR_FLAG_LABEL() {
		return COMP_DRCR_DRCR_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DRCR_DRCR_FLAG() {
		return COMP_DRCR_DRCR_FLAG;
	}

	public void setCOMP_DRCR_DRCR_FLAG_LABEL(HtmlOutputLabel COMP_DRCR_DRCR_FLAG_LABEL) {
		this.COMP_DRCR_DRCR_FLAG_LABEL = COMP_DRCR_DRCR_FLAG_LABEL;
	}

	public void setCOMP_DRCR_DRCR_FLAG(HtmlSelectOneMenu COMP_DRCR_DRCR_FLAG) {
		this.COMP_DRCR_DRCR_FLAG = COMP_DRCR_DRCR_FLAG;
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

	public HtmlOutputLabel getCOMP_DRCR_DOC_DT_LABEL() {
		return COMP_DRCR_DOC_DT_LABEL;
	}

	public HtmlCalendar getCOMP_DRCR_DOC_DT() {
		return COMP_DRCR_DOC_DT;
	}
	
	public void getDetails() {
		try {
			if ( dataList_PS_IL_DRCR.size() != 0) {				
			    this.PS_IL_DRCR_BEAN = (PS_IL_DRCR) data.getRowData();
			}
			resetAllComponent();			
			resetSelectedRow();
			this.PS_IL_DRCR_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void resetAllComponent(){
		// Reseting HtmlInputText
		
		COMP_UI_M_DRCR_LC_TOT_DR.resetValue();
		COMP_UI_M_DRCR_LC_TOT_CR.resetValue();
		COMP_DRCR_POST_YN.resetValue();
		COMP_DRCR_NARRATION.resetValue();
		COMP_DRCR_END_NO.resetValue();
	//	COMP_DRCR_DRCR_FLAG.resetValue();
		COMP_DRCR_DIVN_CODE.resetValue();
		COMP_DRCR_DEPT_CODE.resetValue();
		COMP_DRCR_CUST_CODE.resetValue();
		COMP_DRCR_CLAIM_NO.resetValue();
		COMP_DRCR_ANLY_CODE_2.resetValue();
		COMP_DRCR_ANLY_CODE_1.resetValue();
		COMP_DRCR_ACTY_CODE_2.resetValue();
		COMP_DRCR_ACTY_CODE_1.resetValue();
		
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PS_IL_DRCR>  iterator = dataList_PS_IL_DRCR.iterator();
		while(iterator.hasNext()){
			iterator.next().setRowSelected(false);
		}
	}

	public void setCOMP_DRCR_DOC_DT_LABEL(HtmlOutputLabel COMP_DRCR_DOC_DT_LABEL) {
		this.COMP_DRCR_DOC_DT_LABEL = COMP_DRCR_DOC_DT_LABEL;
	}

	public void setCOMP_DRCR_DOC_DT(HtmlCalendar COMP_DRCR_DOC_DT) {
		this.COMP_DRCR_DOC_DT = COMP_DRCR_DOC_DT;
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

	public HtmlOutputLabel getCOMP_UI_M_DRCR_LC_TOT_DR_LABEL() {
		return COMP_UI_M_DRCR_LC_TOT_DR_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DRCR_LC_TOT_DR() {
		return COMP_UI_M_DRCR_LC_TOT_DR;
	}

	public void setCOMP_UI_M_DRCR_LC_TOT_DR_LABEL(HtmlOutputLabel COMP_UI_M_DRCR_LC_TOT_DR_LABEL) {
		this.COMP_UI_M_DRCR_LC_TOT_DR_LABEL = COMP_UI_M_DRCR_LC_TOT_DR_LABEL;
	}

	public void setCOMP_UI_M_DRCR_LC_TOT_DR(HtmlInputText COMP_UI_M_DRCR_LC_TOT_DR) {
		this.COMP_UI_M_DRCR_LC_TOT_DR = COMP_UI_M_DRCR_LC_TOT_DR;
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

	public HtmlOutputLabel getCOMP_DRCR_POST_YN_LABEL() {
		return COMP_DRCR_POST_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DRCR_POST_YN() {
		return COMP_DRCR_POST_YN;
	}

	public void setCOMP_DRCR_POST_YN_LABEL(HtmlOutputLabel COMP_DRCR_POST_YN_LABEL) {
		this.COMP_DRCR_POST_YN_LABEL = COMP_DRCR_POST_YN_LABEL;
	}

	public void setCOMP_DRCR_POST_YN(HtmlSelectOneMenu COMP_DRCR_POST_YN) {
		this.COMP_DRCR_POST_YN = COMP_DRCR_POST_YN;
	}

	public HtmlOutputLabel getCOMP_UI_M_DRCR_LC_TOT_CR_LABEL() {
		return COMP_UI_M_DRCR_LC_TOT_CR_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DRCR_LC_TOT_CR() {
		return COMP_UI_M_DRCR_LC_TOT_CR;
	}

	public void setCOMP_UI_M_DRCR_LC_TOT_CR_LABEL(HtmlOutputLabel COMP_UI_M_DRCR_LC_TOT_CR_LABEL) {
		this.COMP_UI_M_DRCR_LC_TOT_CR_LABEL = COMP_UI_M_DRCR_LC_TOT_CR_LABEL;
	}

	public void setCOMP_UI_M_DRCR_LC_TOT_CR(HtmlInputText COMP_UI_M_DRCR_LC_TOT_CR) {
		this.COMP_UI_M_DRCR_LC_TOT_CR = COMP_UI_M_DRCR_LC_TOT_CR;
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

	public HtmlOutputLabel getCOMP_DRCR_DIVN_CODE_LABEL() {
		return COMP_DRCR_DIVN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_DIVN_CODE() {
		return COMP_DRCR_DIVN_CODE;
	}

	public void setCOMP_DRCR_DIVN_CODE_LABEL(HtmlOutputLabel COMP_DRCR_DIVN_CODE_LABEL) {
		this.COMP_DRCR_DIVN_CODE_LABEL = COMP_DRCR_DIVN_CODE_LABEL;
	}

	public void setCOMP_DRCR_DIVN_CODE(HtmlInputText COMP_DRCR_DIVN_CODE) {
		this.COMP_DRCR_DIVN_CODE = COMP_DRCR_DIVN_CODE;
	}

	public HtmlOutputLabel getCOMP_DRCR_DEPT_CODE_LABEL() {
		return COMP_DRCR_DEPT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DRCR_DEPT_CODE() {
		return COMP_DRCR_DEPT_CODE;
	}

	public void setCOMP_DRCR_DEPT_CODE_LABEL(HtmlOutputLabel COMP_DRCR_DEPT_CODE_LABEL) {
		this.COMP_DRCR_DEPT_CODE_LABEL = COMP_DRCR_DEPT_CODE_LABEL;
	}

	public void setCOMP_DRCR_DEPT_CODE(HtmlInputText COMP_DRCR_DEPT_CODE) {
		this.COMP_DRCR_DEPT_CODE = COMP_DRCR_DEPT_CODE;
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

	public List getYnList() {
		return ynList;
	}

	public void setYnList(List ynList) {
		this.ynList = ynList;
	}

	public void setDataList_PS_IL_DRCR(List<PS_IL_DRCR> dataList_PS_IL_DRCR) {
		this.dataList_PS_IL_DRCR = dataList_PS_IL_DRCR;
	}

	public UIData getData() {
		return data;
	}

	public void setData(UIData data) {
		this.data = data;
	}

	public String getFilterByDRCR_TXN_CODE() {
		return filterByDRCR_TXN_CODE;
	}

	public void setFilterByDRCR_TXN_CODE(String filterByDRCR_TXN_CODE) {
		this.filterByDRCR_TXN_CODE = filterByDRCR_TXN_CODE;
	}

	public String getFilterByDRCR_DOC_NO() {
		return filterByDRCR_DOC_NO;
	}

	public void setFilterByDRCR_DOC_NO(String filterByDRCR_DOC_NO) {
		this.filterByDRCR_DOC_NO = filterByDRCR_DOC_NO;
	}

	public String getFilterByDRCR_SEQ_NO() {
		return filterByDRCR_SEQ_NO;
	}

	public void setFilterByDRCR_SEQ_NO(String filterByDRCR_SEQ_NO) {
		this.filterByDRCR_SEQ_NO = filterByDRCR_SEQ_NO;
	}

	public String getFilterByDRCR_DOC_DT() {
		return filterByDRCR_DOC_DT;
	}

	public void setFilterByDRCR_DOC_DT(String filterByDRCR_DOC_DT) {
		this.filterByDRCR_DOC_DT = filterByDRCR_DOC_DT;
	}

	public String getFilterByDRCR_MAIN_ACNT_CODE() {
		return filterByDRCR_MAIN_ACNT_CODE;
	}

	public void setFilterByDRCR_MAIN_ACNT_CODE(String filterByDRCR_MAIN_ACNT_CODE) {
		this.filterByDRCR_MAIN_ACNT_CODE = filterByDRCR_MAIN_ACNT_CODE;
	}

	public String getFilterByDRCR_SUB_ACNT_CODE() {
		return filterByDRCR_SUB_ACNT_CODE;
	}

	public void setFilterByDRCR_SUB_ACNT_CODE(String filterByDRCR_SUB_ACNT_CODE) {
		this.filterByDRCR_SUB_ACNT_CODE = filterByDRCR_SUB_ACNT_CODE;
	}

	public String getFilterByDRCR_LC_AMT() {
		return filterByDRCR_LC_AMT;
	}

	public void setFilterByDRCR_LC_AMT(String filterByDRCR_LC_AMT) {
		this.filterByDRCR_LC_AMT = filterByDRCR_LC_AMT;
	}
}
