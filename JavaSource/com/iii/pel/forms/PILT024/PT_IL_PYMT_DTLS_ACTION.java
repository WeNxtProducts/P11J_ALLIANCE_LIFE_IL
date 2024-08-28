package com.iii.pel.forms.PILT024;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;

import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlInputText;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PYMT_DTLS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PD_SR_NO_LABEL;

	private HtmlInputText COMP_PD_SR_NO;

	private HtmlOutputLabel COMP_PD_PAY_MODE_LABEL;

	private HtmlInputText COMP_PD_PAY_MODE;

	private HtmlOutputLabel COMP_PD_DPD_REF_ID_LABEL;

	private HtmlInputText COMP_PD_DPD_REF_ID;

	private HtmlOutputLabel COMP_PD_FC_AMT_LABEL;

	private HtmlInputText COMP_PD_FC_AMT;

	private HtmlOutputLabel COMP_PD_LC_AMT_LABEL;

	private HtmlInputText COMP_PD_LC_AMT;

	private HtmlOutputLabel COMP_PD_PAID_FOR_LABEL;

	private HtmlInputText COMP_PD_PAID_FOR;

	private HtmlOutputLabel COMP_PD_CHQ_NO_LABEL;

	private HtmlInputText COMP_PD_CHQ_NO;

	private HtmlOutputLabel COMP_PD_CHQ_DT_LABEL;

	private HtmlCalendar COMP_PD_CHQ_DT;

	private HtmlOutputLabel COMP_PD_BANK_NAME_LABEL;

	private HtmlInputText COMP_PD_BANK_NAME;

	private HtmlOutputLabel COMP_UI_M_BANK_NAME_DESC_LABEL;

	private HtmlInputText COMP_UI_M_BANK_NAME_DESC;

	private HtmlOutputLabel COMP_PD_BRANCH_NAME_LABEL;

	private HtmlInputText COMP_PD_BRANCH_NAME;

	private HtmlOutputLabel COMP_PD_CUST_NAME_LABEL;

	private HtmlInputText COMP_PD_CUST_NAME;

	private HtmlOutputLabel COMP_PD_ADDR_01_LABEL;

	private HtmlInputText COMP_PD_ADDR_01;

	private HtmlOutputLabel COMP_PD_ADDR_02_LABEL;

	private HtmlInputText COMP_PD_ADDR_02;

	private HtmlOutputLabel COMP_PD_ADDR_03_LABEL;

	private HtmlInputText COMP_PD_ADDR_03;

	private HtmlOutputLabel COMP_PD_REMARKS_LABEL;

	private HtmlInputText COMP_PD_REMARKS;

	private HtmlOutputLabel COMP_PD_CURR_CODE_LABEL;

	private HtmlInputText COMP_PD_CURR_CODE;

	private HtmlOutputLabel COMP_UI_M_PD_CURR_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PD_CURR_CODE_DESC;

	private HtmlOutputLabel COMP_PD_LC_CHARGE_LABEL;

	private HtmlInputText COMP_PD_LC_CHARGE;

	private HtmlOutputLabel COMP_PD_FC_CHARGE_LABEL;

	private HtmlInputText COMP_PD_FC_CHARGE;

	private HtmlOutputLabel COMP_PD_FLEX_04_LABEL;

	private HtmlInputText COMP_PD_FLEX_04;

	private HtmlOutputLabel COMP_PD_FLEX_05_LABEL;

	private HtmlInputText COMP_PD_FLEX_05;

	private HtmlOutputLabel COMP_PD_FLEX_06_LABEL;

	private HtmlInputText COMP_PD_FLEX_06;

	private HtmlOutputLabel COMP_PD_FLEX_07_LABEL;

	private HtmlInputText COMP_PD_FLEX_07;

	private HtmlOutputLabel COMP_PD_FLEX_08_LABEL;

	private HtmlInputText COMP_PD_FLEX_08;

	private HtmlOutputLabel COMP_PD_FLEX_09_LABEL;

	private HtmlInputText COMP_PD_FLEX_09;

	private HtmlOutputLabel COMP_PD_FLEX_10_LABEL;

	private HtmlInputText COMP_PD_FLEX_10;

	private HtmlOutputLabel COMP_PD_FLEX_11_LABEL;

	private HtmlInputText COMP_PD_FLEX_11;

	private HtmlOutputLabel COMP_PD_FLEX_12_LABEL;

	private HtmlInputText COMP_PD_FLEX_12;

	private HtmlOutputLabel COMP_PD_FLEX_13_LABEL;

	private HtmlInputText COMP_PD_FLEX_13;

	private HtmlOutputLabel COMP_PD_FLEX_14_LABEL;

	private HtmlInputText COMP_PD_FLEX_14;

	private HtmlOutputLabel COMP_PD_FLEX_15_LABEL;

	private HtmlInputText COMP_PD_FLEX_15;

	private HtmlOutputLabel COMP_PD_FLEX_16_LABEL;

	private HtmlInputText COMP_PD_FLEX_16;

	private HtmlOutputLabel COMP_PD_FLEX_17_LABEL;

	private HtmlInputText COMP_PD_FLEX_17;

	private HtmlOutputLabel COMP_PD_FLEX_18_LABEL;

	private HtmlInputText COMP_PD_FLEX_18;

	private HtmlOutputLabel COMP_PD_FLEX_19_LABEL;

	private HtmlInputText COMP_PD_FLEX_19;

	private HtmlOutputLabel COMP_PD_FLEX_20_LABEL;

	private HtmlInputText COMP_PD_FLEX_20;

	private HtmlOutputLabel COMP_PD_FLEX_21_LABEL;

	private HtmlInputText COMP_PD_FLEX_21;

	private HtmlOutputLabel COMP_PD_FLEX_22_LABEL;

	private HtmlInputText COMP_PD_FLEX_22;

	private HtmlOutputLabel COMP_PD_FLEX_23_LABEL;

	private HtmlInputText COMP_PD_FLEX_23;

	private HtmlOutputLabel COMP_PD_FLEX_24_LABEL;

	private HtmlInputText COMP_PD_FLEX_24;

	private HtmlOutputLabel COMP_PD_FLEX_25_LABEL;

	private HtmlInputText COMP_PD_FLEX_25;

	private HtmlOutputLabel COMP_PD_FLEX_26_LABEL;

	private HtmlInputText COMP_PD_FLEX_26;

	private HtmlOutputLabel COMP_PD_FLEX_27_LABEL;

	private HtmlInputText COMP_PD_FLEX_27;

	private HtmlOutputLabel COMP_PD_FLEX_28_LABEL;

	private HtmlInputText COMP_PD_FLEX_28;

	private HtmlOutputLabel COMP_PD_FLEX_29_LABEL;

	private HtmlInputText COMP_PD_FLEX_29;

	private HtmlOutputLabel COMP_PD_FLEX_30_LABEL;

	private HtmlInputText COMP_PD_FLEX_30;

	private HtmlOutputLabel COMP_PD_FLEX_03_LABEL;

	private HtmlInputText COMP_PD_FLEX_03;

	private HtmlOutputLabel COMP_PD_FLEX_01_LABEL;

	private HtmlInputText COMP_PD_FLEX_01;

	private HtmlOutputLabel COMP_PD_FLEX_02_LABEL;

	private HtmlInputText COMP_PD_FLEX_02;

	private HtmlOutputLabel COMP_PD_CC_TYPE_LABEL;

	private HtmlInputText COMP_PD_CC_TYPE;

	private HtmlOutputLabel COMP_PD_CC_NO_LABEL;

	private HtmlInputText COMP_PD_CC_NO;

	private HtmlOutputLabel COMP_PD_CC_NAME_LABEL;

	private HtmlInputText COMP_PD_CC_NAME;

	private HtmlOutputLabel COMP_PD_CC_EXP_DT_LABEL;

	private HtmlCalendar COMP_PD_CC_EXP_DT;

	private HtmlCommandButton COMP_UI_M_BUT_MORE;

	private HtmlCommandButton COMP_UI_M_BUT_PYMT_DTLS_MAIN;

	private PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN;

	public PILT024_COMPOSITE_ACTION compositeAction;

	private PT_IL_PYMT_DTLS_HELPER helper;

	private List<PT_IL_PYMT_DTLS> dataList_PT_IL_PYMT_DTLS = new ArrayList<PT_IL_PYMT_DTLS>();

	public PT_IL_PYMT_DTLS_ACTION() {

		PT_IL_PYMT_DTLS_BEAN = new PT_IL_PYMT_DTLS();
		helper = new PT_IL_PYMT_DTLS_HELPER();
	}

	public HtmlOutputLabel getCOMP_PD_SR_NO_LABEL() {
		return COMP_PD_SR_NO_LABEL;
	}

	public HtmlInputText getCOMP_PD_SR_NO() {
		return COMP_PD_SR_NO;
	}

	public void setCOMP_PD_SR_NO_LABEL(HtmlOutputLabel COMP_PD_SR_NO_LABEL) {
		this.COMP_PD_SR_NO_LABEL = COMP_PD_SR_NO_LABEL;
	}

	public void setCOMP_PD_SR_NO(HtmlInputText COMP_PD_SR_NO) {
		this.COMP_PD_SR_NO = COMP_PD_SR_NO;
	}

	public HtmlOutputLabel getCOMP_PD_PAY_MODE_LABEL() {
		return COMP_PD_PAY_MODE_LABEL;
	}

	public HtmlInputText getCOMP_PD_PAY_MODE() {
		return COMP_PD_PAY_MODE;
	}

	public void setCOMP_PD_PAY_MODE_LABEL(HtmlOutputLabel COMP_PD_PAY_MODE_LABEL) {
		this.COMP_PD_PAY_MODE_LABEL = COMP_PD_PAY_MODE_LABEL;
	}

	public void setCOMP_PD_PAY_MODE(HtmlInputText COMP_PD_PAY_MODE) {
		this.COMP_PD_PAY_MODE = COMP_PD_PAY_MODE;
	}

	public HtmlOutputLabel getCOMP_PD_DPD_REF_ID_LABEL() {
		return COMP_PD_DPD_REF_ID_LABEL;
	}

	public HtmlInputText getCOMP_PD_DPD_REF_ID() {
		return COMP_PD_DPD_REF_ID;
	}

	public void setCOMP_PD_DPD_REF_ID_LABEL(
			HtmlOutputLabel COMP_PD_DPD_REF_ID_LABEL) {
		this.COMP_PD_DPD_REF_ID_LABEL = COMP_PD_DPD_REF_ID_LABEL;
	}

	public void setCOMP_PD_DPD_REF_ID(HtmlInputText COMP_PD_DPD_REF_ID) {
		this.COMP_PD_DPD_REF_ID = COMP_PD_DPD_REF_ID;
	}

	public HtmlOutputLabel getCOMP_PD_FC_AMT_LABEL() {
		return COMP_PD_FC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PD_FC_AMT() {
		return COMP_PD_FC_AMT;
	}

	public void setCOMP_PD_FC_AMT_LABEL(HtmlOutputLabel COMP_PD_FC_AMT_LABEL) {
		this.COMP_PD_FC_AMT_LABEL = COMP_PD_FC_AMT_LABEL;
	}

	public void setCOMP_PD_FC_AMT(HtmlInputText COMP_PD_FC_AMT) {
		this.COMP_PD_FC_AMT = COMP_PD_FC_AMT;
	}

	public HtmlOutputLabel getCOMP_PD_LC_AMT_LABEL() {
		return COMP_PD_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PD_LC_AMT() {
		return COMP_PD_LC_AMT;
	}

	public void setCOMP_PD_LC_AMT_LABEL(HtmlOutputLabel COMP_PD_LC_AMT_LABEL) {
		this.COMP_PD_LC_AMT_LABEL = COMP_PD_LC_AMT_LABEL;
	}

	public void setCOMP_PD_LC_AMT(HtmlInputText COMP_PD_LC_AMT) {
		this.COMP_PD_LC_AMT = COMP_PD_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_PD_PAID_FOR_LABEL() {
		return COMP_PD_PAID_FOR_LABEL;
	}

	public HtmlInputText getCOMP_PD_PAID_FOR() {
		return COMP_PD_PAID_FOR;
	}

	public void setCOMP_PD_PAID_FOR_LABEL(HtmlOutputLabel COMP_PD_PAID_FOR_LABEL) {
		this.COMP_PD_PAID_FOR_LABEL = COMP_PD_PAID_FOR_LABEL;
	}

	public void setCOMP_PD_PAID_FOR(HtmlInputText COMP_PD_PAID_FOR) {
		this.COMP_PD_PAID_FOR = COMP_PD_PAID_FOR;
	}

	public HtmlOutputLabel getCOMP_PD_CHQ_NO_LABEL() {
		return COMP_PD_CHQ_NO_LABEL;
	}

	public HtmlInputText getCOMP_PD_CHQ_NO() {
		return COMP_PD_CHQ_NO;
	}

	public void setCOMP_PD_CHQ_NO_LABEL(HtmlOutputLabel COMP_PD_CHQ_NO_LABEL) {
		this.COMP_PD_CHQ_NO_LABEL = COMP_PD_CHQ_NO_LABEL;
	}

	public void setCOMP_PD_CHQ_NO(HtmlInputText COMP_PD_CHQ_NO) {
		this.COMP_PD_CHQ_NO = COMP_PD_CHQ_NO;
	}

	public HtmlOutputLabel getCOMP_PD_CHQ_DT_LABEL() {
		return COMP_PD_CHQ_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PD_CHQ_DT() {
		return COMP_PD_CHQ_DT;
	}

	public void setCOMP_PD_CHQ_DT_LABEL(HtmlOutputLabel COMP_PD_CHQ_DT_LABEL) {
		this.COMP_PD_CHQ_DT_LABEL = COMP_PD_CHQ_DT_LABEL;
	}

	public void setCOMP_PD_CHQ_DT(HtmlCalendar COMP_PD_CHQ_DT) {
		this.COMP_PD_CHQ_DT = COMP_PD_CHQ_DT;
	}

	public HtmlOutputLabel getCOMP_PD_BANK_NAME_LABEL() {
		return COMP_PD_BANK_NAME_LABEL;
	}

	public HtmlInputText getCOMP_PD_BANK_NAME() {
		return COMP_PD_BANK_NAME;
	}

	public void setCOMP_PD_BANK_NAME_LABEL(
			HtmlOutputLabel COMP_PD_BANK_NAME_LABEL) {
		this.COMP_PD_BANK_NAME_LABEL = COMP_PD_BANK_NAME_LABEL;
	}

	public void setCOMP_PD_BANK_NAME(HtmlInputText COMP_PD_BANK_NAME) {
		this.COMP_PD_BANK_NAME = COMP_PD_BANK_NAME;
	}

	public HtmlOutputLabel getCOMP_UI_M_BANK_NAME_DESC_LABEL() {
		return COMP_UI_M_BANK_NAME_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BANK_NAME_DESC() {
		return COMP_UI_M_BANK_NAME_DESC;
	}

	public void setCOMP_UI_M_BANK_NAME_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_BANK_NAME_DESC_LABEL) {
		this.COMP_UI_M_BANK_NAME_DESC_LABEL = COMP_UI_M_BANK_NAME_DESC_LABEL;
	}

	public void setCOMP_UI_M_BANK_NAME_DESC(
			HtmlInputText COMP_UI_M_BANK_NAME_DESC) {
		this.COMP_UI_M_BANK_NAME_DESC = COMP_UI_M_BANK_NAME_DESC;
	}

	public HtmlOutputLabel getCOMP_PD_BRANCH_NAME_LABEL() {
		return COMP_PD_BRANCH_NAME_LABEL;
	}

	public HtmlInputText getCOMP_PD_BRANCH_NAME() {
		return COMP_PD_BRANCH_NAME;
	}

	public void setCOMP_PD_BRANCH_NAME_LABEL(
			HtmlOutputLabel COMP_PD_BRANCH_NAME_LABEL) {
		this.COMP_PD_BRANCH_NAME_LABEL = COMP_PD_BRANCH_NAME_LABEL;
	}

	public void setCOMP_PD_BRANCH_NAME(HtmlInputText COMP_PD_BRANCH_NAME) {
		this.COMP_PD_BRANCH_NAME = COMP_PD_BRANCH_NAME;
	}

	public HtmlOutputLabel getCOMP_PD_CUST_NAME_LABEL() {
		return COMP_PD_CUST_NAME_LABEL;
	}

	public HtmlInputText getCOMP_PD_CUST_NAME() {
		return COMP_PD_CUST_NAME;
	}

	public void setCOMP_PD_CUST_NAME_LABEL(
			HtmlOutputLabel COMP_PD_CUST_NAME_LABEL) {
		this.COMP_PD_CUST_NAME_LABEL = COMP_PD_CUST_NAME_LABEL;
	}

	public void setCOMP_PD_CUST_NAME(HtmlInputText COMP_PD_CUST_NAME) {
		this.COMP_PD_CUST_NAME = COMP_PD_CUST_NAME;
	}

	public HtmlOutputLabel getCOMP_PD_ADDR_01_LABEL() {
		return COMP_PD_ADDR_01_LABEL;
	}

	public HtmlInputText getCOMP_PD_ADDR_01() {
		return COMP_PD_ADDR_01;
	}

	public void setCOMP_PD_ADDR_01_LABEL(HtmlOutputLabel COMP_PD_ADDR_01_LABEL) {
		this.COMP_PD_ADDR_01_LABEL = COMP_PD_ADDR_01_LABEL;
	}

	public void setCOMP_PD_ADDR_01(HtmlInputText COMP_PD_ADDR_01) {
		this.COMP_PD_ADDR_01 = COMP_PD_ADDR_01;
	}

	public HtmlOutputLabel getCOMP_PD_ADDR_02_LABEL() {
		return COMP_PD_ADDR_02_LABEL;
	}

	public HtmlInputText getCOMP_PD_ADDR_02() {
		return COMP_PD_ADDR_02;
	}

	public void setCOMP_PD_ADDR_02_LABEL(HtmlOutputLabel COMP_PD_ADDR_02_LABEL) {
		this.COMP_PD_ADDR_02_LABEL = COMP_PD_ADDR_02_LABEL;
	}

	public void setCOMP_PD_ADDR_02(HtmlInputText COMP_PD_ADDR_02) {
		this.COMP_PD_ADDR_02 = COMP_PD_ADDR_02;
	}

	public HtmlOutputLabel getCOMP_PD_ADDR_03_LABEL() {
		return COMP_PD_ADDR_03_LABEL;
	}

	public HtmlInputText getCOMP_PD_ADDR_03() {
		return COMP_PD_ADDR_03;
	}

	public void setCOMP_PD_ADDR_03_LABEL(HtmlOutputLabel COMP_PD_ADDR_03_LABEL) {
		this.COMP_PD_ADDR_03_LABEL = COMP_PD_ADDR_03_LABEL;
	}

	public void setCOMP_PD_ADDR_03(HtmlInputText COMP_PD_ADDR_03) {
		this.COMP_PD_ADDR_03 = COMP_PD_ADDR_03;
	}

	public HtmlOutputLabel getCOMP_PD_REMARKS_LABEL() {
		return COMP_PD_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_PD_REMARKS() {
		return COMP_PD_REMARKS;
	}

	public void setCOMP_PD_REMARKS_LABEL(HtmlOutputLabel COMP_PD_REMARKS_LABEL) {
		this.COMP_PD_REMARKS_LABEL = COMP_PD_REMARKS_LABEL;
	}

	public void setCOMP_PD_REMARKS(HtmlInputText COMP_PD_REMARKS) {
		this.COMP_PD_REMARKS = COMP_PD_REMARKS;
	}

	public HtmlOutputLabel getCOMP_PD_CURR_CODE_LABEL() {
		return COMP_PD_CURR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PD_CURR_CODE() {
		return COMP_PD_CURR_CODE;
	}

	public void setCOMP_PD_CURR_CODE_LABEL(
			HtmlOutputLabel COMP_PD_CURR_CODE_LABEL) {
		this.COMP_PD_CURR_CODE_LABEL = COMP_PD_CURR_CODE_LABEL;
	}

	public void setCOMP_PD_CURR_CODE(HtmlInputText COMP_PD_CURR_CODE) {
		this.COMP_PD_CURR_CODE = COMP_PD_CURR_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PD_CURR_CODE_DESC_LABEL() {
		return COMP_UI_M_PD_CURR_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PD_CURR_CODE_DESC() {
		return COMP_UI_M_PD_CURR_CODE_DESC;
	}

	public void setCOMP_UI_M_PD_CURR_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PD_CURR_CODE_DESC_LABEL) {
		this.COMP_UI_M_PD_CURR_CODE_DESC_LABEL = COMP_UI_M_PD_CURR_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PD_CURR_CODE_DESC(
			HtmlInputText COMP_UI_M_PD_CURR_CODE_DESC) {
		this.COMP_UI_M_PD_CURR_CODE_DESC = COMP_UI_M_PD_CURR_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_PD_LC_CHARGE_LABEL() {
		return COMP_PD_LC_CHARGE_LABEL;
	}

	public HtmlInputText getCOMP_PD_LC_CHARGE() {
		return COMP_PD_LC_CHARGE;
	}

	public void setCOMP_PD_LC_CHARGE_LABEL(
			HtmlOutputLabel COMP_PD_LC_CHARGE_LABEL) {
		this.COMP_PD_LC_CHARGE_LABEL = COMP_PD_LC_CHARGE_LABEL;
	}

	public void setCOMP_PD_LC_CHARGE(HtmlInputText COMP_PD_LC_CHARGE) {
		this.COMP_PD_LC_CHARGE = COMP_PD_LC_CHARGE;
	}

	public HtmlOutputLabel getCOMP_PD_FC_CHARGE_LABEL() {
		return COMP_PD_FC_CHARGE_LABEL;
	}

	public HtmlInputText getCOMP_PD_FC_CHARGE() {
		return COMP_PD_FC_CHARGE;
	}

	public void setCOMP_PD_FC_CHARGE_LABEL(
			HtmlOutputLabel COMP_PD_FC_CHARGE_LABEL) {
		this.COMP_PD_FC_CHARGE_LABEL = COMP_PD_FC_CHARGE_LABEL;
	}

	public void setCOMP_PD_FC_CHARGE(HtmlInputText COMP_PD_FC_CHARGE) {
		this.COMP_PD_FC_CHARGE = COMP_PD_FC_CHARGE;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_04_LABEL() {
		return COMP_PD_FLEX_04_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_04() {
		return COMP_PD_FLEX_04;
	}

	public void setCOMP_PD_FLEX_04_LABEL(HtmlOutputLabel COMP_PD_FLEX_04_LABEL) {
		this.COMP_PD_FLEX_04_LABEL = COMP_PD_FLEX_04_LABEL;
	}

	public void setCOMP_PD_FLEX_04(HtmlInputText COMP_PD_FLEX_04) {
		this.COMP_PD_FLEX_04 = COMP_PD_FLEX_04;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_05_LABEL() {
		return COMP_PD_FLEX_05_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_05() {
		return COMP_PD_FLEX_05;
	}

	public void setCOMP_PD_FLEX_05_LABEL(HtmlOutputLabel COMP_PD_FLEX_05_LABEL) {
		this.COMP_PD_FLEX_05_LABEL = COMP_PD_FLEX_05_LABEL;
	}

	public void setCOMP_PD_FLEX_05(HtmlInputText COMP_PD_FLEX_05) {
		this.COMP_PD_FLEX_05 = COMP_PD_FLEX_05;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_06_LABEL() {
		return COMP_PD_FLEX_06_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_06() {
		return COMP_PD_FLEX_06;
	}

	public void setCOMP_PD_FLEX_06_LABEL(HtmlOutputLabel COMP_PD_FLEX_06_LABEL) {
		this.COMP_PD_FLEX_06_LABEL = COMP_PD_FLEX_06_LABEL;
	}

	public void setCOMP_PD_FLEX_06(HtmlInputText COMP_PD_FLEX_06) {
		this.COMP_PD_FLEX_06 = COMP_PD_FLEX_06;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_07_LABEL() {
		return COMP_PD_FLEX_07_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_07() {
		return COMP_PD_FLEX_07;
	}

	public void setCOMP_PD_FLEX_07_LABEL(HtmlOutputLabel COMP_PD_FLEX_07_LABEL) {
		this.COMP_PD_FLEX_07_LABEL = COMP_PD_FLEX_07_LABEL;
	}

	public void setCOMP_PD_FLEX_07(HtmlInputText COMP_PD_FLEX_07) {
		this.COMP_PD_FLEX_07 = COMP_PD_FLEX_07;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_08_LABEL() {
		return COMP_PD_FLEX_08_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_08() {
		return COMP_PD_FLEX_08;
	}

	public void setCOMP_PD_FLEX_08_LABEL(HtmlOutputLabel COMP_PD_FLEX_08_LABEL) {
		this.COMP_PD_FLEX_08_LABEL = COMP_PD_FLEX_08_LABEL;
	}

	public void setCOMP_PD_FLEX_08(HtmlInputText COMP_PD_FLEX_08) {
		this.COMP_PD_FLEX_08 = COMP_PD_FLEX_08;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_09_LABEL() {
		return COMP_PD_FLEX_09_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_09() {
		return COMP_PD_FLEX_09;
	}

	public void setCOMP_PD_FLEX_09_LABEL(HtmlOutputLabel COMP_PD_FLEX_09_LABEL) {
		this.COMP_PD_FLEX_09_LABEL = COMP_PD_FLEX_09_LABEL;
	}

	public void setCOMP_PD_FLEX_09(HtmlInputText COMP_PD_FLEX_09) {
		this.COMP_PD_FLEX_09 = COMP_PD_FLEX_09;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_10_LABEL() {
		return COMP_PD_FLEX_10_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_10() {
		return COMP_PD_FLEX_10;
	}

	public void setCOMP_PD_FLEX_10_LABEL(HtmlOutputLabel COMP_PD_FLEX_10_LABEL) {
		this.COMP_PD_FLEX_10_LABEL = COMP_PD_FLEX_10_LABEL;
	}

	public void setCOMP_PD_FLEX_10(HtmlInputText COMP_PD_FLEX_10) {
		this.COMP_PD_FLEX_10 = COMP_PD_FLEX_10;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_11_LABEL() {
		return COMP_PD_FLEX_11_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_11() {
		return COMP_PD_FLEX_11;
	}

	public void setCOMP_PD_FLEX_11_LABEL(HtmlOutputLabel COMP_PD_FLEX_11_LABEL) {
		this.COMP_PD_FLEX_11_LABEL = COMP_PD_FLEX_11_LABEL;
	}

	public void setCOMP_PD_FLEX_11(HtmlInputText COMP_PD_FLEX_11) {
		this.COMP_PD_FLEX_11 = COMP_PD_FLEX_11;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_12_LABEL() {
		return COMP_PD_FLEX_12_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_12() {
		return COMP_PD_FLEX_12;
	}

	public void setCOMP_PD_FLEX_12_LABEL(HtmlOutputLabel COMP_PD_FLEX_12_LABEL) {
		this.COMP_PD_FLEX_12_LABEL = COMP_PD_FLEX_12_LABEL;
	}

	public void setCOMP_PD_FLEX_12(HtmlInputText COMP_PD_FLEX_12) {
		this.COMP_PD_FLEX_12 = COMP_PD_FLEX_12;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_13_LABEL() {
		return COMP_PD_FLEX_13_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_13() {
		return COMP_PD_FLEX_13;
	}

	public void setCOMP_PD_FLEX_13_LABEL(HtmlOutputLabel COMP_PD_FLEX_13_LABEL) {
		this.COMP_PD_FLEX_13_LABEL = COMP_PD_FLEX_13_LABEL;
	}

	public void setCOMP_PD_FLEX_13(HtmlInputText COMP_PD_FLEX_13) {
		this.COMP_PD_FLEX_13 = COMP_PD_FLEX_13;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_14_LABEL() {
		return COMP_PD_FLEX_14_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_14() {
		return COMP_PD_FLEX_14;
	}

	public void setCOMP_PD_FLEX_14_LABEL(HtmlOutputLabel COMP_PD_FLEX_14_LABEL) {
		this.COMP_PD_FLEX_14_LABEL = COMP_PD_FLEX_14_LABEL;
	}

	public void setCOMP_PD_FLEX_14(HtmlInputText COMP_PD_FLEX_14) {
		this.COMP_PD_FLEX_14 = COMP_PD_FLEX_14;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_15_LABEL() {
		return COMP_PD_FLEX_15_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_15() {
		return COMP_PD_FLEX_15;
	}

	public void setCOMP_PD_FLEX_15_LABEL(HtmlOutputLabel COMP_PD_FLEX_15_LABEL) {
		this.COMP_PD_FLEX_15_LABEL = COMP_PD_FLEX_15_LABEL;
	}

	public void setCOMP_PD_FLEX_15(HtmlInputText COMP_PD_FLEX_15) {
		this.COMP_PD_FLEX_15 = COMP_PD_FLEX_15;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_16_LABEL() {
		return COMP_PD_FLEX_16_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_16() {
		return COMP_PD_FLEX_16;
	}

	public void setCOMP_PD_FLEX_16_LABEL(HtmlOutputLabel COMP_PD_FLEX_16_LABEL) {
		this.COMP_PD_FLEX_16_LABEL = COMP_PD_FLEX_16_LABEL;
	}

	public void setCOMP_PD_FLEX_16(HtmlInputText COMP_PD_FLEX_16) {
		this.COMP_PD_FLEX_16 = COMP_PD_FLEX_16;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_17_LABEL() {
		return COMP_PD_FLEX_17_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_17() {
		return COMP_PD_FLEX_17;
	}

	public void setCOMP_PD_FLEX_17_LABEL(HtmlOutputLabel COMP_PD_FLEX_17_LABEL) {
		this.COMP_PD_FLEX_17_LABEL = COMP_PD_FLEX_17_LABEL;
	}

	public void setCOMP_PD_FLEX_17(HtmlInputText COMP_PD_FLEX_17) {
		this.COMP_PD_FLEX_17 = COMP_PD_FLEX_17;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_18_LABEL() {
		return COMP_PD_FLEX_18_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_18() {
		return COMP_PD_FLEX_18;
	}

	public void setCOMP_PD_FLEX_18_LABEL(HtmlOutputLabel COMP_PD_FLEX_18_LABEL) {
		this.COMP_PD_FLEX_18_LABEL = COMP_PD_FLEX_18_LABEL;
	}

	public void setCOMP_PD_FLEX_18(HtmlInputText COMP_PD_FLEX_18) {
		this.COMP_PD_FLEX_18 = COMP_PD_FLEX_18;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_19_LABEL() {
		return COMP_PD_FLEX_19_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_19() {
		return COMP_PD_FLEX_19;
	}

	public void setCOMP_PD_FLEX_19_LABEL(HtmlOutputLabel COMP_PD_FLEX_19_LABEL) {
		this.COMP_PD_FLEX_19_LABEL = COMP_PD_FLEX_19_LABEL;
	}

	public void setCOMP_PD_FLEX_19(HtmlInputText COMP_PD_FLEX_19) {
		this.COMP_PD_FLEX_19 = COMP_PD_FLEX_19;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_20_LABEL() {
		return COMP_PD_FLEX_20_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_20() {
		return COMP_PD_FLEX_20;
	}

	public void setCOMP_PD_FLEX_20_LABEL(HtmlOutputLabel COMP_PD_FLEX_20_LABEL) {
		this.COMP_PD_FLEX_20_LABEL = COMP_PD_FLEX_20_LABEL;
	}

	public void setCOMP_PD_FLEX_20(HtmlInputText COMP_PD_FLEX_20) {
		this.COMP_PD_FLEX_20 = COMP_PD_FLEX_20;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_21_LABEL() {
		return COMP_PD_FLEX_21_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_21() {
		return COMP_PD_FLEX_21;
	}

	public void setCOMP_PD_FLEX_21_LABEL(HtmlOutputLabel COMP_PD_FLEX_21_LABEL) {
		this.COMP_PD_FLEX_21_LABEL = COMP_PD_FLEX_21_LABEL;
	}

	public void setCOMP_PD_FLEX_21(HtmlInputText COMP_PD_FLEX_21) {
		this.COMP_PD_FLEX_21 = COMP_PD_FLEX_21;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_22_LABEL() {
		return COMP_PD_FLEX_22_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_22() {
		return COMP_PD_FLEX_22;
	}

	public void setCOMP_PD_FLEX_22_LABEL(HtmlOutputLabel COMP_PD_FLEX_22_LABEL) {
		this.COMP_PD_FLEX_22_LABEL = COMP_PD_FLEX_22_LABEL;
	}

	public void setCOMP_PD_FLEX_22(HtmlInputText COMP_PD_FLEX_22) {
		this.COMP_PD_FLEX_22 = COMP_PD_FLEX_22;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_23_LABEL() {
		return COMP_PD_FLEX_23_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_23() {
		return COMP_PD_FLEX_23;
	}

	public void setCOMP_PD_FLEX_23_LABEL(HtmlOutputLabel COMP_PD_FLEX_23_LABEL) {
		this.COMP_PD_FLEX_23_LABEL = COMP_PD_FLEX_23_LABEL;
	}

	public void setCOMP_PD_FLEX_23(HtmlInputText COMP_PD_FLEX_23) {
		this.COMP_PD_FLEX_23 = COMP_PD_FLEX_23;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_24_LABEL() {
		return COMP_PD_FLEX_24_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_24() {
		return COMP_PD_FLEX_24;
	}

	public void setCOMP_PD_FLEX_24_LABEL(HtmlOutputLabel COMP_PD_FLEX_24_LABEL) {
		this.COMP_PD_FLEX_24_LABEL = COMP_PD_FLEX_24_LABEL;
	}

	public void setCOMP_PD_FLEX_24(HtmlInputText COMP_PD_FLEX_24) {
		this.COMP_PD_FLEX_24 = COMP_PD_FLEX_24;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_25_LABEL() {
		return COMP_PD_FLEX_25_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_25() {
		return COMP_PD_FLEX_25;
	}

	public void setCOMP_PD_FLEX_25_LABEL(HtmlOutputLabel COMP_PD_FLEX_25_LABEL) {
		this.COMP_PD_FLEX_25_LABEL = COMP_PD_FLEX_25_LABEL;
	}

	public void setCOMP_PD_FLEX_25(HtmlInputText COMP_PD_FLEX_25) {
		this.COMP_PD_FLEX_25 = COMP_PD_FLEX_25;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_26_LABEL() {
		return COMP_PD_FLEX_26_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_26() {
		return COMP_PD_FLEX_26;
	}

	public void setCOMP_PD_FLEX_26_LABEL(HtmlOutputLabel COMP_PD_FLEX_26_LABEL) {
		this.COMP_PD_FLEX_26_LABEL = COMP_PD_FLEX_26_LABEL;
	}

	public void setCOMP_PD_FLEX_26(HtmlInputText COMP_PD_FLEX_26) {
		this.COMP_PD_FLEX_26 = COMP_PD_FLEX_26;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_27_LABEL() {
		return COMP_PD_FLEX_27_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_27() {
		return COMP_PD_FLEX_27;
	}

	public void setCOMP_PD_FLEX_27_LABEL(HtmlOutputLabel COMP_PD_FLEX_27_LABEL) {
		this.COMP_PD_FLEX_27_LABEL = COMP_PD_FLEX_27_LABEL;
	}

	public void setCOMP_PD_FLEX_27(HtmlInputText COMP_PD_FLEX_27) {
		this.COMP_PD_FLEX_27 = COMP_PD_FLEX_27;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_28_LABEL() {
		return COMP_PD_FLEX_28_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_28() {
		return COMP_PD_FLEX_28;
	}

	public void setCOMP_PD_FLEX_28_LABEL(HtmlOutputLabel COMP_PD_FLEX_28_LABEL) {
		this.COMP_PD_FLEX_28_LABEL = COMP_PD_FLEX_28_LABEL;
	}

	public void setCOMP_PD_FLEX_28(HtmlInputText COMP_PD_FLEX_28) {
		this.COMP_PD_FLEX_28 = COMP_PD_FLEX_28;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_29_LABEL() {
		return COMP_PD_FLEX_29_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_29() {
		return COMP_PD_FLEX_29;
	}

	public void setCOMP_PD_FLEX_29_LABEL(HtmlOutputLabel COMP_PD_FLEX_29_LABEL) {
		this.COMP_PD_FLEX_29_LABEL = COMP_PD_FLEX_29_LABEL;
	}

	public void setCOMP_PD_FLEX_29(HtmlInputText COMP_PD_FLEX_29) {
		this.COMP_PD_FLEX_29 = COMP_PD_FLEX_29;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_30_LABEL() {
		return COMP_PD_FLEX_30_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_30() {
		return COMP_PD_FLEX_30;
	}

	public void setCOMP_PD_FLEX_30_LABEL(HtmlOutputLabel COMP_PD_FLEX_30_LABEL) {
		this.COMP_PD_FLEX_30_LABEL = COMP_PD_FLEX_30_LABEL;
	}

	public void setCOMP_PD_FLEX_30(HtmlInputText COMP_PD_FLEX_30) {
		this.COMP_PD_FLEX_30 = COMP_PD_FLEX_30;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_03_LABEL() {
		return COMP_PD_FLEX_03_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_03() {
		return COMP_PD_FLEX_03;
	}

	public void setCOMP_PD_FLEX_03_LABEL(HtmlOutputLabel COMP_PD_FLEX_03_LABEL) {
		this.COMP_PD_FLEX_03_LABEL = COMP_PD_FLEX_03_LABEL;
	}

	public void setCOMP_PD_FLEX_03(HtmlInputText COMP_PD_FLEX_03) {
		this.COMP_PD_FLEX_03 = COMP_PD_FLEX_03;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_01_LABEL() {
		return COMP_PD_FLEX_01_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_01() {
		return COMP_PD_FLEX_01;
	}

	public void setCOMP_PD_FLEX_01_LABEL(HtmlOutputLabel COMP_PD_FLEX_01_LABEL) {
		this.COMP_PD_FLEX_01_LABEL = COMP_PD_FLEX_01_LABEL;
	}

	public void setCOMP_PD_FLEX_01(HtmlInputText COMP_PD_FLEX_01) {
		this.COMP_PD_FLEX_01 = COMP_PD_FLEX_01;
	}

	public HtmlOutputLabel getCOMP_PD_FLEX_02_LABEL() {
		return COMP_PD_FLEX_02_LABEL;
	}

	public HtmlInputText getCOMP_PD_FLEX_02() {
		return COMP_PD_FLEX_02;
	}

	public void setCOMP_PD_FLEX_02_LABEL(HtmlOutputLabel COMP_PD_FLEX_02_LABEL) {
		this.COMP_PD_FLEX_02_LABEL = COMP_PD_FLEX_02_LABEL;
	}

	public void setCOMP_PD_FLEX_02(HtmlInputText COMP_PD_FLEX_02) {
		this.COMP_PD_FLEX_02 = COMP_PD_FLEX_02;
	}

	public HtmlOutputLabel getCOMP_PD_CC_TYPE_LABEL() {
		return COMP_PD_CC_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_PD_CC_TYPE() {
		return COMP_PD_CC_TYPE;
	}

	public void setCOMP_PD_CC_TYPE_LABEL(HtmlOutputLabel COMP_PD_CC_TYPE_LABEL) {
		this.COMP_PD_CC_TYPE_LABEL = COMP_PD_CC_TYPE_LABEL;
	}

	public void setCOMP_PD_CC_TYPE(HtmlInputText COMP_PD_CC_TYPE) {
		this.COMP_PD_CC_TYPE = COMP_PD_CC_TYPE;
	}

	public HtmlOutputLabel getCOMP_PD_CC_NO_LABEL() {
		return COMP_PD_CC_NO_LABEL;
	}

	public HtmlInputText getCOMP_PD_CC_NO() {
		return COMP_PD_CC_NO;
	}

	public void setCOMP_PD_CC_NO_LABEL(HtmlOutputLabel COMP_PD_CC_NO_LABEL) {
		this.COMP_PD_CC_NO_LABEL = COMP_PD_CC_NO_LABEL;
	}

	public void setCOMP_PD_CC_NO(HtmlInputText COMP_PD_CC_NO) {
		this.COMP_PD_CC_NO = COMP_PD_CC_NO;
	}

	public HtmlOutputLabel getCOMP_PD_CC_NAME_LABEL() {
		return COMP_PD_CC_NAME_LABEL;
	}

	public HtmlInputText getCOMP_PD_CC_NAME() {
		return COMP_PD_CC_NAME;
	}

	public void setCOMP_PD_CC_NAME_LABEL(HtmlOutputLabel COMP_PD_CC_NAME_LABEL) {
		this.COMP_PD_CC_NAME_LABEL = COMP_PD_CC_NAME_LABEL;
	}

	public void setCOMP_PD_CC_NAME(HtmlInputText COMP_PD_CC_NAME) {
		this.COMP_PD_CC_NAME = COMP_PD_CC_NAME;
	}

	public HtmlOutputLabel getCOMP_PD_CC_EXP_DT_LABEL() {
		return COMP_PD_CC_EXP_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PD_CC_EXP_DT() {
		return COMP_PD_CC_EXP_DT;
	}

	public void setCOMP_PD_CC_EXP_DT_LABEL(
			HtmlOutputLabel COMP_PD_CC_EXP_DT_LABEL) {
		this.COMP_PD_CC_EXP_DT_LABEL = COMP_PD_CC_EXP_DT_LABEL;
	}

	public void setCOMP_PD_CC_EXP_DT(HtmlCalendar COMP_PD_CC_EXP_DT) {
		this.COMP_PD_CC_EXP_DT = COMP_PD_CC_EXP_DT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MORE() {
		return COMP_UI_M_BUT_MORE;
	}

	public void setCOMP_UI_M_BUT_MORE(HtmlCommandButton COMP_UI_M_BUT_MORE) {
		this.COMP_UI_M_BUT_MORE = COMP_UI_M_BUT_MORE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PYMT_DTLS_MAIN() {
		return COMP_UI_M_BUT_PYMT_DTLS_MAIN;
	}

	public void setCOMP_UI_M_BUT_PYMT_DTLS_MAIN(
			HtmlCommandButton COMP_UI_M_BUT_PYMT_DTLS_MAIN) {
		this.COMP_UI_M_BUT_PYMT_DTLS_MAIN = COMP_UI_M_BUT_PYMT_DTLS_MAIN;
	}

	public PT_IL_PYMT_DTLS getPT_IL_PYMT_DTLS_BEAN() {
		return PT_IL_PYMT_DTLS_BEAN;
	}

	public void setPT_IL_PYMT_DTLS_BEAN(PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN) {
		this.PT_IL_PYMT_DTLS_BEAN = PT_IL_PYMT_DTLS_BEAN;
	}

	public List<PT_IL_PYMT_DTLS> getDataList_PT_IL_PYMT_DTLS() {
		return dataList_PT_IL_PYMT_DTLS;
	}

	public void setDataListPT_IL_PYMT_DTLS(
			List<PT_IL_PYMT_DTLS> dataList_PT_IL_PYMT_DTLS) {
		this.dataList_PT_IL_PYMT_DTLS = dataList_PT_IL_PYMT_DTLS;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PT_IL_PYMT_DTLS_BEAN = new PT_IL_PYMT_DTLS();
				resetAllComponent();
			} else {

				getErrorMap().put(
						"addRow",
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

	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {

				new PT_IL_PYMT_DTLS_HELPER().preDelete();
				new CRUDHandler().executeDelete(PT_IL_PYMT_DTLS_BEAN,
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
				dataList_PT_IL_PYMT_DTLS.remove(PT_IL_PYMT_DTLS_BEAN);
				if (dataList_PT_IL_PYMT_DTLS.size() > 0) {

					PT_IL_PYMT_DTLS_BEAN = dataList_PT_IL_PYMT_DTLS.get(0);
				} else if (dataList_PT_IL_PYMT_DTLS.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
			} else {

				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
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
			if (PT_IL_PYMT_DTLS_BEAN.getROWID() == null && isINSERT_ALLOWED()) {

				new PT_IL_PYMT_DTLS_HELPER().preInsert(PT_IL_PYMT_DTLS_BEAN);
				new CRUDHandler().executeInsert(PT_IL_PYMT_DTLS_BEAN,
						CommonUtils.getConnection());
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
				dataList_PT_IL_PYMT_DTLS.add(PT_IL_PYMT_DTLS_BEAN);
			} else if (PT_IL_PYMT_DTLS_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {

				new PT_IL_PYMT_DTLS_HELPER().preUpdate(PT_IL_PYMT_DTLS_BEAN);
				new CRUDHandler().executeUpdate(PT_IL_PYMT_DTLS_BEAN,
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
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

	}

	private void resetAllComponent() {
		COMP_PD_SR_NO.resetValue();
		COMP_PD_PAY_MODE.resetValue();
		COMP_PD_DPD_REF_ID.resetValue();
		COMP_PD_FC_AMT.resetValue();
		COMP_PD_LC_AMT.resetValue();
		COMP_PD_PAID_FOR.resetValue();
		COMP_PD_CHQ_NO.resetValue();
		COMP_PD_CHQ_DT.resetValue();
		COMP_PD_BANK_NAME.resetValue();
		COMP_UI_M_BANK_NAME_DESC.resetValue();
		COMP_PD_BRANCH_NAME.resetValue();
		COMP_PD_CUST_NAME.resetValue();
		COMP_PD_ADDR_01.resetValue();
		COMP_PD_ADDR_02.resetValue();
		COMP_PD_ADDR_03.resetValue();
		COMP_PD_REMARKS.resetValue();
		COMP_PD_CURR_CODE.resetValue();
		COMP_UI_M_PD_CURR_CODE_DESC.resetValue();
		COMP_PD_LC_CHARGE.resetValue();
		COMP_PD_FC_CHARGE.resetValue();
		COMP_PD_FLEX_04.resetValue();
		COMP_PD_FLEX_05.resetValue();
		COMP_PD_FLEX_06.resetValue();
		COMP_PD_FLEX_07.resetValue();
		COMP_PD_FLEX_08.resetValue();
		COMP_PD_FLEX_09.resetValue();
		COMP_PD_FLEX_10.resetValue();
		COMP_PD_FLEX_11.resetValue();
		COMP_PD_FLEX_12.resetValue();
		COMP_PD_FLEX_13.resetValue();
		COMP_PD_FLEX_14.resetValue();
		COMP_PD_FLEX_15.resetValue();
		COMP_PD_FLEX_16.resetValue();
		COMP_PD_FLEX_17.resetValue();
		COMP_PD_FLEX_18.resetValue();
		COMP_PD_FLEX_19.resetValue();
		COMP_PD_FLEX_20.resetValue();
		COMP_PD_FLEX_21.resetValue();
		COMP_PD_FLEX_22.resetValue();
		COMP_PD_FLEX_23.resetValue();
		COMP_PD_FLEX_24.resetValue();
		COMP_PD_FLEX_25.resetValue();
		COMP_PD_FLEX_26.resetValue();
		COMP_PD_FLEX_27.resetValue();
		COMP_PD_FLEX_28.resetValue();
		COMP_PD_FLEX_29.resetValue();
		COMP_PD_FLEX_30.resetValue();
		COMP_PD_FLEX_03.resetValue();
		COMP_PD_FLEX_01.resetValue();
		COMP_PD_FLEX_02.resetValue();
		COMP_PD_CC_TYPE.resetValue();
		COMP_PD_CC_NO.resetValue();
		COMP_PD_CC_NAME.resetValue();
		COMP_PD_CC_EXP_DT.resetValue();
		//COMP_UI_M_BUT_MORE.resetValue();
		//COMP_UI_M_BUT_PYMT_DTLS_MAIN.resetValue();
	}

	public PILT024_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT024_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}
}