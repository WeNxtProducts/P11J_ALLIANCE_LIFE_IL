package com.iii.pel.forms.PILT024;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;

import org.richfaces.component.html.HtmlInputText;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PREM_COLL_CVR_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PCCD_FLEX_30_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_30;

	private HtmlOutputLabel COMP_PCCD_FLEX_16_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_16;

	private HtmlOutputLabel COMP_PCCD_FLEX_28_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_28;

	private HtmlOutputLabel COMP_PCCD_FLEX_29_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_29;

	private HtmlOutputLabel COMP_PCCD_FLEX_27_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_27;

	private HtmlOutputLabel COMP_PCCD_FLEX_26_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_26;

	private HtmlOutputLabel COMP_PCCD_FLEX_25_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_25;

	private HtmlOutputLabel COMP_PCCD_FLEX_24_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_24;

	private HtmlOutputLabel COMP_PCCD_FLEX_23_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_23;

	private HtmlOutputLabel COMP_PCCD_FLEX_22_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_22;

	private HtmlOutputLabel COMP_PCCD_FLEX_21_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_21;

	private HtmlOutputLabel COMP_PCCD_FLEX_20_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_20;

	private HtmlOutputLabel COMP_PCCD_FLEX_19_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_19;

	private HtmlOutputLabel COMP_PCCD_FLEX_18_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_18;

	private HtmlOutputLabel COMP_PCCD_FLEX_17_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_17;

	private HtmlOutputLabel COMP_PCCD_FLEX_01_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_01;

	private HtmlOutputLabel COMP_PCCD_FLEX_02_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_02;

	private HtmlOutputLabel COMP_PCCD_FLEX_03_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_03;

	private HtmlOutputLabel COMP_PCCD_FLEX_04_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_04;

	private HtmlOutputLabel COMP_PCCD_FLEX_05_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_05;

	private HtmlOutputLabel COMP_PCCD_FLEX_06_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_06;

	private HtmlOutputLabel COMP_PCCD_FLEX_07_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_07;

	private HtmlOutputLabel COMP_PCCD_FLEX_08_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_08;

	private HtmlOutputLabel COMP_PCCD_FLEX_09_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_09;

	private HtmlOutputLabel COMP_PCCD_FLEX_10_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_10;

	private HtmlOutputLabel COMP_PCCD_FLEX_11_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_11;

	private HtmlOutputLabel COMP_PCCD_FLEX_12_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_12;

	private HtmlOutputLabel COMP_PCCD_FLEX_13_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_13;

	private HtmlOutputLabel COMP_PCCD_FLEX_14_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_14;

	private HtmlOutputLabel COMP_PCCD_FLEX_15_LABEL;

	private HtmlInputText COMP_PCCD_FLEX_15;

	private HtmlOutputLabel COMP_B_PCCD_PREMIUM_LABEL;

	private HtmlInputText COMP_B_PCCD_PREMIUM;

	private HtmlOutputLabel COMP_B_PCCD_DISCOUNT_LABEL;

	private HtmlInputText COMP_B_PCCD_DISCOUNT;

	private HtmlOutputLabel COMP_B_PCCD_LOADING_LABEL;

	private HtmlInputText COMP_B_PCCD_LOADING;

	private HtmlOutputLabel COMP_B_M_PCCD_TOTAL_CVR_PREM_LABEL;

	private HtmlInputText COMP_B_M_PCCD_TOTAL_CVR_PREM;

	private HtmlOutputLabel COMP_PCCD_COVER_CODE_LABEL;

	private HtmlInputText COMP_PCCD_COVER_CODE;

	private HtmlOutputLabel COMP_PCCD_FC_RISK_PREM_AMT_LABEL;

	private HtmlInputText COMP_PCCD_FC_RISK_PREM_AMT;

	private HtmlOutputLabel COMP_PCCD_FC_INV_PREM_AMT_LABEL;

	private HtmlInputText COMP_PCCD_FC_INV_PREM_AMT;

	private HtmlOutputLabel COMP_PCCD_FC_RISK_DISC_AMT_LABEL;

	private HtmlInputText COMP_PCCD_FC_RISK_DISC_AMT;

	private HtmlOutputLabel COMP_PCCD_FC_INV_DISC_AMT_LABEL;

	private HtmlInputText COMP_PCCD_FC_INV_DISC_AMT;

	private HtmlOutputLabel COMP_PCCD_FC_RISK_LOAD_AMT_LABEL;

	private HtmlInputText COMP_PCCD_FC_RISK_LOAD_AMT;

	private HtmlOutputLabel COMP_PCCD_FC_INV_LOAD_AMT_LABEL;

	private HtmlInputText COMP_PCCD_FC_INV_LOAD_AMT;

	private HtmlOutputLabel COMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_FC_LABEL;

	private HtmlInputText COMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_FC;

	private HtmlOutputLabel COMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_FC_LABEL;

	private HtmlInputText COMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_FC;

	private HtmlOutputLabel COMP_PCCD_LC_RISK_PREM_AMT_LABEL;

	private HtmlInputText COMP_PCCD_LC_RISK_PREM_AMT;

	private HtmlOutputLabel COMP_PCCD_LC_INV_PREM_AMT_LABEL;

	private HtmlInputText COMP_PCCD_LC_INV_PREM_AMT;

	private HtmlOutputLabel COMP_PCCD_LC_RISK_DISC_AMT_LABEL;

	private HtmlInputText COMP_PCCD_LC_RISK_DISC_AMT;

	private HtmlOutputLabel COMP_PCCD_LC_INV_DISC_AMT_LABEL;

	private HtmlInputText COMP_PCCD_LC_INV_DISC_AMT;

	private HtmlOutputLabel COMP_PCCD_LC_RISK_LOAD_AMT_LABEL;

	private HtmlInputText COMP_PCCD_LC_RISK_LOAD_AMT;

	private HtmlOutputLabel COMP_PCCD_LC_INV_LOAD_AMT_LABEL;

	private HtmlInputText COMP_PCCD_LC_INV_LOAD_AMT;

	private HtmlOutputLabel COMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_LC_LABEL;

	private HtmlInputText COMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_LC;

	private HtmlOutputLabel COMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_LC_LABEL;

	private HtmlInputText COMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_LC;

	private PT_IL_PREM_COLL_CVR_DTL PT_IL_PREM_COLL_CVR_DTL_BEAN;

	public PILT024_COMPOSITE_ACTION compositeAction;

	private PT_IL_PREM_COLL_CVR_DTL_HELPER helper;

	private List<PT_IL_PREM_COLL_CVR_DTL> dataList_PT_IL_PREM_COLL_CVR_DTL = new ArrayList<PT_IL_PREM_COLL_CVR_DTL>();

	public PT_IL_PREM_COLL_CVR_DTL_ACTION() {

		PT_IL_PREM_COLL_CVR_DTL_BEAN = new PT_IL_PREM_COLL_CVR_DTL();
		helper = new PT_IL_PREM_COLL_CVR_DTL_HELPER();
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_30_LABEL() {
		return COMP_PCCD_FLEX_30_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_30() {
		return COMP_PCCD_FLEX_30;
	}

	public void setCOMP_PCCD_FLEX_30_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_30_LABEL) {
		this.COMP_PCCD_FLEX_30_LABEL = COMP_PCCD_FLEX_30_LABEL;
	}

	public void setCOMP_PCCD_FLEX_30(HtmlInputText COMP_PCCD_FLEX_30) {
		this.COMP_PCCD_FLEX_30 = COMP_PCCD_FLEX_30;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_16_LABEL() {
		return COMP_PCCD_FLEX_16_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_16() {
		return COMP_PCCD_FLEX_16;
	}

	public void setCOMP_PCCD_FLEX_16_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_16_LABEL) {
		this.COMP_PCCD_FLEX_16_LABEL = COMP_PCCD_FLEX_16_LABEL;
	}

	public void setCOMP_PCCD_FLEX_16(HtmlInputText COMP_PCCD_FLEX_16) {
		this.COMP_PCCD_FLEX_16 = COMP_PCCD_FLEX_16;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_28_LABEL() {
		return COMP_PCCD_FLEX_28_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_28() {
		return COMP_PCCD_FLEX_28;
	}

	public void setCOMP_PCCD_FLEX_28_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_28_LABEL) {
		this.COMP_PCCD_FLEX_28_LABEL = COMP_PCCD_FLEX_28_LABEL;
	}

	public void setCOMP_PCCD_FLEX_28(HtmlInputText COMP_PCCD_FLEX_28) {
		this.COMP_PCCD_FLEX_28 = COMP_PCCD_FLEX_28;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_29_LABEL() {
		return COMP_PCCD_FLEX_29_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_29() {
		return COMP_PCCD_FLEX_29;
	}

	public void setCOMP_PCCD_FLEX_29_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_29_LABEL) {
		this.COMP_PCCD_FLEX_29_LABEL = COMP_PCCD_FLEX_29_LABEL;
	}

	public void setCOMP_PCCD_FLEX_29(HtmlInputText COMP_PCCD_FLEX_29) {
		this.COMP_PCCD_FLEX_29 = COMP_PCCD_FLEX_29;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_27_LABEL() {
		return COMP_PCCD_FLEX_27_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_27() {
		return COMP_PCCD_FLEX_27;
	}

	public void setCOMP_PCCD_FLEX_27_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_27_LABEL) {
		this.COMP_PCCD_FLEX_27_LABEL = COMP_PCCD_FLEX_27_LABEL;
	}

	public void setCOMP_PCCD_FLEX_27(HtmlInputText COMP_PCCD_FLEX_27) {
		this.COMP_PCCD_FLEX_27 = COMP_PCCD_FLEX_27;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_26_LABEL() {
		return COMP_PCCD_FLEX_26_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_26() {
		return COMP_PCCD_FLEX_26;
	}

	public void setCOMP_PCCD_FLEX_26_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_26_LABEL) {
		this.COMP_PCCD_FLEX_26_LABEL = COMP_PCCD_FLEX_26_LABEL;
	}

	public void setCOMP_PCCD_FLEX_26(HtmlInputText COMP_PCCD_FLEX_26) {
		this.COMP_PCCD_FLEX_26 = COMP_PCCD_FLEX_26;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_25_LABEL() {
		return COMP_PCCD_FLEX_25_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_25() {
		return COMP_PCCD_FLEX_25;
	}

	public void setCOMP_PCCD_FLEX_25_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_25_LABEL) {
		this.COMP_PCCD_FLEX_25_LABEL = COMP_PCCD_FLEX_25_LABEL;
	}

	public void setCOMP_PCCD_FLEX_25(HtmlInputText COMP_PCCD_FLEX_25) {
		this.COMP_PCCD_FLEX_25 = COMP_PCCD_FLEX_25;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_24_LABEL() {
		return COMP_PCCD_FLEX_24_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_24() {
		return COMP_PCCD_FLEX_24;
	}

	public void setCOMP_PCCD_FLEX_24_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_24_LABEL) {
		this.COMP_PCCD_FLEX_24_LABEL = COMP_PCCD_FLEX_24_LABEL;
	}

	public void setCOMP_PCCD_FLEX_24(HtmlInputText COMP_PCCD_FLEX_24) {
		this.COMP_PCCD_FLEX_24 = COMP_PCCD_FLEX_24;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_23_LABEL() {
		return COMP_PCCD_FLEX_23_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_23() {
		return COMP_PCCD_FLEX_23;
	}

	public void setCOMP_PCCD_FLEX_23_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_23_LABEL) {
		this.COMP_PCCD_FLEX_23_LABEL = COMP_PCCD_FLEX_23_LABEL;
	}

	public void setCOMP_PCCD_FLEX_23(HtmlInputText COMP_PCCD_FLEX_23) {
		this.COMP_PCCD_FLEX_23 = COMP_PCCD_FLEX_23;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_22_LABEL() {
		return COMP_PCCD_FLEX_22_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_22() {
		return COMP_PCCD_FLEX_22;
	}

	public void setCOMP_PCCD_FLEX_22_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_22_LABEL) {
		this.COMP_PCCD_FLEX_22_LABEL = COMP_PCCD_FLEX_22_LABEL;
	}

	public void setCOMP_PCCD_FLEX_22(HtmlInputText COMP_PCCD_FLEX_22) {
		this.COMP_PCCD_FLEX_22 = COMP_PCCD_FLEX_22;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_21_LABEL() {
		return COMP_PCCD_FLEX_21_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_21() {
		return COMP_PCCD_FLEX_21;
	}

	public void setCOMP_PCCD_FLEX_21_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_21_LABEL) {
		this.COMP_PCCD_FLEX_21_LABEL = COMP_PCCD_FLEX_21_LABEL;
	}

	public void setCOMP_PCCD_FLEX_21(HtmlInputText COMP_PCCD_FLEX_21) {
		this.COMP_PCCD_FLEX_21 = COMP_PCCD_FLEX_21;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_20_LABEL() {
		return COMP_PCCD_FLEX_20_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_20() {
		return COMP_PCCD_FLEX_20;
	}

	public void setCOMP_PCCD_FLEX_20_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_20_LABEL) {
		this.COMP_PCCD_FLEX_20_LABEL = COMP_PCCD_FLEX_20_LABEL;
	}

	public void setCOMP_PCCD_FLEX_20(HtmlInputText COMP_PCCD_FLEX_20) {
		this.COMP_PCCD_FLEX_20 = COMP_PCCD_FLEX_20;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_19_LABEL() {
		return COMP_PCCD_FLEX_19_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_19() {
		return COMP_PCCD_FLEX_19;
	}

	public void setCOMP_PCCD_FLEX_19_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_19_LABEL) {
		this.COMP_PCCD_FLEX_19_LABEL = COMP_PCCD_FLEX_19_LABEL;
	}

	public void setCOMP_PCCD_FLEX_19(HtmlInputText COMP_PCCD_FLEX_19) {
		this.COMP_PCCD_FLEX_19 = COMP_PCCD_FLEX_19;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_18_LABEL() {
		return COMP_PCCD_FLEX_18_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_18() {
		return COMP_PCCD_FLEX_18;
	}

	public void setCOMP_PCCD_FLEX_18_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_18_LABEL) {
		this.COMP_PCCD_FLEX_18_LABEL = COMP_PCCD_FLEX_18_LABEL;
	}

	public void setCOMP_PCCD_FLEX_18(HtmlInputText COMP_PCCD_FLEX_18) {
		this.COMP_PCCD_FLEX_18 = COMP_PCCD_FLEX_18;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_17_LABEL() {
		return COMP_PCCD_FLEX_17_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_17() {
		return COMP_PCCD_FLEX_17;
	}

	public void setCOMP_PCCD_FLEX_17_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_17_LABEL) {
		this.COMP_PCCD_FLEX_17_LABEL = COMP_PCCD_FLEX_17_LABEL;
	}

	public void setCOMP_PCCD_FLEX_17(HtmlInputText COMP_PCCD_FLEX_17) {
		this.COMP_PCCD_FLEX_17 = COMP_PCCD_FLEX_17;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_01_LABEL() {
		return COMP_PCCD_FLEX_01_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_01() {
		return COMP_PCCD_FLEX_01;
	}

	public void setCOMP_PCCD_FLEX_01_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_01_LABEL) {
		this.COMP_PCCD_FLEX_01_LABEL = COMP_PCCD_FLEX_01_LABEL;
	}

	public void setCOMP_PCCD_FLEX_01(HtmlInputText COMP_PCCD_FLEX_01) {
		this.COMP_PCCD_FLEX_01 = COMP_PCCD_FLEX_01;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_02_LABEL() {
		return COMP_PCCD_FLEX_02_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_02() {
		return COMP_PCCD_FLEX_02;
	}

	public void setCOMP_PCCD_FLEX_02_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_02_LABEL) {
		this.COMP_PCCD_FLEX_02_LABEL = COMP_PCCD_FLEX_02_LABEL;
	}

	public void setCOMP_PCCD_FLEX_02(HtmlInputText COMP_PCCD_FLEX_02) {
		this.COMP_PCCD_FLEX_02 = COMP_PCCD_FLEX_02;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_03_LABEL() {
		return COMP_PCCD_FLEX_03_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_03() {
		return COMP_PCCD_FLEX_03;
	}

	public void setCOMP_PCCD_FLEX_03_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_03_LABEL) {
		this.COMP_PCCD_FLEX_03_LABEL = COMP_PCCD_FLEX_03_LABEL;
	}

	public void setCOMP_PCCD_FLEX_03(HtmlInputText COMP_PCCD_FLEX_03) {
		this.COMP_PCCD_FLEX_03 = COMP_PCCD_FLEX_03;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_04_LABEL() {
		return COMP_PCCD_FLEX_04_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_04() {
		return COMP_PCCD_FLEX_04;
	}

	public void setCOMP_PCCD_FLEX_04_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_04_LABEL) {
		this.COMP_PCCD_FLEX_04_LABEL = COMP_PCCD_FLEX_04_LABEL;
	}

	public void setCOMP_PCCD_FLEX_04(HtmlInputText COMP_PCCD_FLEX_04) {
		this.COMP_PCCD_FLEX_04 = COMP_PCCD_FLEX_04;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_05_LABEL() {
		return COMP_PCCD_FLEX_05_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_05() {
		return COMP_PCCD_FLEX_05;
	}

	public void setCOMP_PCCD_FLEX_05_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_05_LABEL) {
		this.COMP_PCCD_FLEX_05_LABEL = COMP_PCCD_FLEX_05_LABEL;
	}

	public void setCOMP_PCCD_FLEX_05(HtmlInputText COMP_PCCD_FLEX_05) {
		this.COMP_PCCD_FLEX_05 = COMP_PCCD_FLEX_05;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_06_LABEL() {
		return COMP_PCCD_FLEX_06_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_06() {
		return COMP_PCCD_FLEX_06;
	}

	public void setCOMP_PCCD_FLEX_06_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_06_LABEL) {
		this.COMP_PCCD_FLEX_06_LABEL = COMP_PCCD_FLEX_06_LABEL;
	}

	public void setCOMP_PCCD_FLEX_06(HtmlInputText COMP_PCCD_FLEX_06) {
		this.COMP_PCCD_FLEX_06 = COMP_PCCD_FLEX_06;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_07_LABEL() {
		return COMP_PCCD_FLEX_07_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_07() {
		return COMP_PCCD_FLEX_07;
	}

	public void setCOMP_PCCD_FLEX_07_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_07_LABEL) {
		this.COMP_PCCD_FLEX_07_LABEL = COMP_PCCD_FLEX_07_LABEL;
	}

	public void setCOMP_PCCD_FLEX_07(HtmlInputText COMP_PCCD_FLEX_07) {
		this.COMP_PCCD_FLEX_07 = COMP_PCCD_FLEX_07;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_08_LABEL() {
		return COMP_PCCD_FLEX_08_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_08() {
		return COMP_PCCD_FLEX_08;
	}

	public void setCOMP_PCCD_FLEX_08_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_08_LABEL) {
		this.COMP_PCCD_FLEX_08_LABEL = COMP_PCCD_FLEX_08_LABEL;
	}

	public void setCOMP_PCCD_FLEX_08(HtmlInputText COMP_PCCD_FLEX_08) {
		this.COMP_PCCD_FLEX_08 = COMP_PCCD_FLEX_08;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_09_LABEL() {
		return COMP_PCCD_FLEX_09_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_09() {
		return COMP_PCCD_FLEX_09;
	}

	public void setCOMP_PCCD_FLEX_09_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_09_LABEL) {
		this.COMP_PCCD_FLEX_09_LABEL = COMP_PCCD_FLEX_09_LABEL;
	}

	public void setCOMP_PCCD_FLEX_09(HtmlInputText COMP_PCCD_FLEX_09) {
		this.COMP_PCCD_FLEX_09 = COMP_PCCD_FLEX_09;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_10_LABEL() {
		return COMP_PCCD_FLEX_10_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_10() {
		return COMP_PCCD_FLEX_10;
	}

	public void setCOMP_PCCD_FLEX_10_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_10_LABEL) {
		this.COMP_PCCD_FLEX_10_LABEL = COMP_PCCD_FLEX_10_LABEL;
	}

	public void setCOMP_PCCD_FLEX_10(HtmlInputText COMP_PCCD_FLEX_10) {
		this.COMP_PCCD_FLEX_10 = COMP_PCCD_FLEX_10;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_11_LABEL() {
		return COMP_PCCD_FLEX_11_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_11() {
		return COMP_PCCD_FLEX_11;
	}

	public void setCOMP_PCCD_FLEX_11_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_11_LABEL) {
		this.COMP_PCCD_FLEX_11_LABEL = COMP_PCCD_FLEX_11_LABEL;
	}

	public void setCOMP_PCCD_FLEX_11(HtmlInputText COMP_PCCD_FLEX_11) {
		this.COMP_PCCD_FLEX_11 = COMP_PCCD_FLEX_11;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_12_LABEL() {
		return COMP_PCCD_FLEX_12_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_12() {
		return COMP_PCCD_FLEX_12;
	}

	public void setCOMP_PCCD_FLEX_12_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_12_LABEL) {
		this.COMP_PCCD_FLEX_12_LABEL = COMP_PCCD_FLEX_12_LABEL;
	}

	public void setCOMP_PCCD_FLEX_12(HtmlInputText COMP_PCCD_FLEX_12) {
		this.COMP_PCCD_FLEX_12 = COMP_PCCD_FLEX_12;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_13_LABEL() {
		return COMP_PCCD_FLEX_13_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_13() {
		return COMP_PCCD_FLEX_13;
	}

	public void setCOMP_PCCD_FLEX_13_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_13_LABEL) {
		this.COMP_PCCD_FLEX_13_LABEL = COMP_PCCD_FLEX_13_LABEL;
	}

	public void setCOMP_PCCD_FLEX_13(HtmlInputText COMP_PCCD_FLEX_13) {
		this.COMP_PCCD_FLEX_13 = COMP_PCCD_FLEX_13;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_14_LABEL() {
		return COMP_PCCD_FLEX_14_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_14() {
		return COMP_PCCD_FLEX_14;
	}

	public void setCOMP_PCCD_FLEX_14_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_14_LABEL) {
		this.COMP_PCCD_FLEX_14_LABEL = COMP_PCCD_FLEX_14_LABEL;
	}

	public void setCOMP_PCCD_FLEX_14(HtmlInputText COMP_PCCD_FLEX_14) {
		this.COMP_PCCD_FLEX_14 = COMP_PCCD_FLEX_14;
	}

	public HtmlOutputLabel getCOMP_PCCD_FLEX_15_LABEL() {
		return COMP_PCCD_FLEX_15_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FLEX_15() {
		return COMP_PCCD_FLEX_15;
	}

	public void setCOMP_PCCD_FLEX_15_LABEL(
			HtmlOutputLabel COMP_PCCD_FLEX_15_LABEL) {
		this.COMP_PCCD_FLEX_15_LABEL = COMP_PCCD_FLEX_15_LABEL;
	}

	public void setCOMP_PCCD_FLEX_15(HtmlInputText COMP_PCCD_FLEX_15) {
		this.COMP_PCCD_FLEX_15 = COMP_PCCD_FLEX_15;
	}

	public HtmlOutputLabel getCOMP_B_PCCD_PREMIUM_LABEL() {
		return COMP_B_PCCD_PREMIUM_LABEL;
	}

	public HtmlInputText getCOMP_B_PCCD_PREMIUM() {
		return COMP_B_PCCD_PREMIUM;
	}

	public void setCOMP_B_PCCD_PREMIUM_LABEL(
			HtmlOutputLabel COMP_B_PCCD_PREMIUM_LABEL) {
		this.COMP_B_PCCD_PREMIUM_LABEL = COMP_B_PCCD_PREMIUM_LABEL;
	}

	public void setCOMP_B_PCCD_PREMIUM(HtmlInputText COMP_B_PCCD_PREMIUM) {
		this.COMP_B_PCCD_PREMIUM = COMP_B_PCCD_PREMIUM;
	}

	public HtmlOutputLabel getCOMP_B_PCCD_DISCOUNT_LABEL() {
		return COMP_B_PCCD_DISCOUNT_LABEL;
	}

	public HtmlInputText getCOMP_B_PCCD_DISCOUNT() {
		return COMP_B_PCCD_DISCOUNT;
	}

	public void setCOMP_B_PCCD_DISCOUNT_LABEL(
			HtmlOutputLabel COMP_B_PCCD_DISCOUNT_LABEL) {
		this.COMP_B_PCCD_DISCOUNT_LABEL = COMP_B_PCCD_DISCOUNT_LABEL;
	}

	public void setCOMP_B_PCCD_DISCOUNT(HtmlInputText COMP_B_PCCD_DISCOUNT) {
		this.COMP_B_PCCD_DISCOUNT = COMP_B_PCCD_DISCOUNT;
	}

	public HtmlOutputLabel getCOMP_B_PCCD_LOADING_LABEL() {
		return COMP_B_PCCD_LOADING_LABEL;
	}

	public HtmlInputText getCOMP_B_PCCD_LOADING() {
		return COMP_B_PCCD_LOADING;
	}

	public void setCOMP_B_PCCD_LOADING_LABEL(
			HtmlOutputLabel COMP_B_PCCD_LOADING_LABEL) {
		this.COMP_B_PCCD_LOADING_LABEL = COMP_B_PCCD_LOADING_LABEL;
	}

	public void setCOMP_B_PCCD_LOADING(HtmlInputText COMP_B_PCCD_LOADING) {
		this.COMP_B_PCCD_LOADING = COMP_B_PCCD_LOADING;
	}

	public HtmlOutputLabel getCOMP_B_M_PCCD_TOTAL_CVR_PREM_LABEL() {
		return COMP_B_M_PCCD_TOTAL_CVR_PREM_LABEL;
	}

	public HtmlInputText getCOMP_B_M_PCCD_TOTAL_CVR_PREM() {
		return COMP_B_M_PCCD_TOTAL_CVR_PREM;
	}

	public void setCOMP_B_M_PCCD_TOTAL_CVR_PREM_LABEL(
			HtmlOutputLabel COMP_B_M_PCCD_TOTAL_CVR_PREM_LABEL) {
		this.COMP_B_M_PCCD_TOTAL_CVR_PREM_LABEL = COMP_B_M_PCCD_TOTAL_CVR_PREM_LABEL;
	}

	public void setCOMP_B_M_PCCD_TOTAL_CVR_PREM(
			HtmlInputText COMP_B_M_PCCD_TOTAL_CVR_PREM) {
		this.COMP_B_M_PCCD_TOTAL_CVR_PREM = COMP_B_M_PCCD_TOTAL_CVR_PREM;
	}

	public HtmlOutputLabel getCOMP_PCCD_COVER_CODE_LABEL() {
		return COMP_PCCD_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_COVER_CODE() {
		return COMP_PCCD_COVER_CODE;
	}

	public void setCOMP_PCCD_COVER_CODE_LABEL(
			HtmlOutputLabel COMP_PCCD_COVER_CODE_LABEL) {
		this.COMP_PCCD_COVER_CODE_LABEL = COMP_PCCD_COVER_CODE_LABEL;
	}

	public void setCOMP_PCCD_COVER_CODE(HtmlInputText COMP_PCCD_COVER_CODE) {
		this.COMP_PCCD_COVER_CODE = COMP_PCCD_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_PCCD_FC_RISK_PREM_AMT_LABEL() {
		return COMP_PCCD_FC_RISK_PREM_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FC_RISK_PREM_AMT() {
		return COMP_PCCD_FC_RISK_PREM_AMT;
	}

	public void setCOMP_PCCD_FC_RISK_PREM_AMT_LABEL(
			HtmlOutputLabel COMP_PCCD_FC_RISK_PREM_AMT_LABEL) {
		this.COMP_PCCD_FC_RISK_PREM_AMT_LABEL = COMP_PCCD_FC_RISK_PREM_AMT_LABEL;
	}

	public void setCOMP_PCCD_FC_RISK_PREM_AMT(
			HtmlInputText COMP_PCCD_FC_RISK_PREM_AMT) {
		this.COMP_PCCD_FC_RISK_PREM_AMT = COMP_PCCD_FC_RISK_PREM_AMT;
	}

	public HtmlOutputLabel getCOMP_PCCD_FC_INV_PREM_AMT_LABEL() {
		return COMP_PCCD_FC_INV_PREM_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FC_INV_PREM_AMT() {
		return COMP_PCCD_FC_INV_PREM_AMT;
	}

	public void setCOMP_PCCD_FC_INV_PREM_AMT_LABEL(
			HtmlOutputLabel COMP_PCCD_FC_INV_PREM_AMT_LABEL) {
		this.COMP_PCCD_FC_INV_PREM_AMT_LABEL = COMP_PCCD_FC_INV_PREM_AMT_LABEL;
	}

	public void setCOMP_PCCD_FC_INV_PREM_AMT(
			HtmlInputText COMP_PCCD_FC_INV_PREM_AMT) {
		this.COMP_PCCD_FC_INV_PREM_AMT = COMP_PCCD_FC_INV_PREM_AMT;
	}

	public HtmlOutputLabel getCOMP_PCCD_FC_RISK_DISC_AMT_LABEL() {
		return COMP_PCCD_FC_RISK_DISC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FC_RISK_DISC_AMT() {
		return COMP_PCCD_FC_RISK_DISC_AMT;
	}

	public void setCOMP_PCCD_FC_RISK_DISC_AMT_LABEL(
			HtmlOutputLabel COMP_PCCD_FC_RISK_DISC_AMT_LABEL) {
		this.COMP_PCCD_FC_RISK_DISC_AMT_LABEL = COMP_PCCD_FC_RISK_DISC_AMT_LABEL;
	}

	public void setCOMP_PCCD_FC_RISK_DISC_AMT(
			HtmlInputText COMP_PCCD_FC_RISK_DISC_AMT) {
		this.COMP_PCCD_FC_RISK_DISC_AMT = COMP_PCCD_FC_RISK_DISC_AMT;
	}

	public HtmlOutputLabel getCOMP_PCCD_FC_INV_DISC_AMT_LABEL() {
		return COMP_PCCD_FC_INV_DISC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FC_INV_DISC_AMT() {
		return COMP_PCCD_FC_INV_DISC_AMT;
	}

	public void setCOMP_PCCD_FC_INV_DISC_AMT_LABEL(
			HtmlOutputLabel COMP_PCCD_FC_INV_DISC_AMT_LABEL) {
		this.COMP_PCCD_FC_INV_DISC_AMT_LABEL = COMP_PCCD_FC_INV_DISC_AMT_LABEL;
	}

	public void setCOMP_PCCD_FC_INV_DISC_AMT(
			HtmlInputText COMP_PCCD_FC_INV_DISC_AMT) {
		this.COMP_PCCD_FC_INV_DISC_AMT = COMP_PCCD_FC_INV_DISC_AMT;
	}

	public HtmlOutputLabel getCOMP_PCCD_FC_RISK_LOAD_AMT_LABEL() {
		return COMP_PCCD_FC_RISK_LOAD_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FC_RISK_LOAD_AMT() {
		return COMP_PCCD_FC_RISK_LOAD_AMT;
	}

	public void setCOMP_PCCD_FC_RISK_LOAD_AMT_LABEL(
			HtmlOutputLabel COMP_PCCD_FC_RISK_LOAD_AMT_LABEL) {
		this.COMP_PCCD_FC_RISK_LOAD_AMT_LABEL = COMP_PCCD_FC_RISK_LOAD_AMT_LABEL;
	}

	public void setCOMP_PCCD_FC_RISK_LOAD_AMT(
			HtmlInputText COMP_PCCD_FC_RISK_LOAD_AMT) {
		this.COMP_PCCD_FC_RISK_LOAD_AMT = COMP_PCCD_FC_RISK_LOAD_AMT;
	}

	public HtmlOutputLabel getCOMP_PCCD_FC_INV_LOAD_AMT_LABEL() {
		return COMP_PCCD_FC_INV_LOAD_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_FC_INV_LOAD_AMT() {
		return COMP_PCCD_FC_INV_LOAD_AMT;
	}

	public void setCOMP_PCCD_FC_INV_LOAD_AMT_LABEL(
			HtmlOutputLabel COMP_PCCD_FC_INV_LOAD_AMT_LABEL) {
		this.COMP_PCCD_FC_INV_LOAD_AMT_LABEL = COMP_PCCD_FC_INV_LOAD_AMT_LABEL;
	}

	public void setCOMP_PCCD_FC_INV_LOAD_AMT(
			HtmlInputText COMP_PCCD_FC_INV_LOAD_AMT) {
		this.COMP_PCCD_FC_INV_LOAD_AMT = COMP_PCCD_FC_INV_LOAD_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_FC_LABEL() {
		return COMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_FC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_FC() {
		return COMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_FC;
	}

	public void setCOMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_FC_LABEL(
			HtmlOutputLabel COMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_FC_LABEL) {
		this.COMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_FC_LABEL = COMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_FC_LABEL;
	}

	public void setCOMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_FC(
			HtmlInputText COMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_FC) {
		this.COMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_FC = COMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_FC;
	}

	public HtmlOutputLabel getCOMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_FC_LABEL() {
		return COMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_FC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_FC() {
		return COMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_FC;
	}

	public void setCOMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_FC_LABEL(
			HtmlOutputLabel COMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_FC_LABEL) {
		this.COMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_FC_LABEL = COMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_FC_LABEL;
	}

	public void setCOMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_FC(
			HtmlInputText COMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_FC) {
		this.COMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_FC = COMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_FC;
	}

	public HtmlOutputLabel getCOMP_PCCD_LC_RISK_PREM_AMT_LABEL() {
		return COMP_PCCD_LC_RISK_PREM_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_LC_RISK_PREM_AMT() {
		return COMP_PCCD_LC_RISK_PREM_AMT;
	}

	public void setCOMP_PCCD_LC_RISK_PREM_AMT_LABEL(
			HtmlOutputLabel COMP_PCCD_LC_RISK_PREM_AMT_LABEL) {
		this.COMP_PCCD_LC_RISK_PREM_AMT_LABEL = COMP_PCCD_LC_RISK_PREM_AMT_LABEL;
	}

	public void setCOMP_PCCD_LC_RISK_PREM_AMT(
			HtmlInputText COMP_PCCD_LC_RISK_PREM_AMT) {
		this.COMP_PCCD_LC_RISK_PREM_AMT = COMP_PCCD_LC_RISK_PREM_AMT;
	}

	public HtmlOutputLabel getCOMP_PCCD_LC_INV_PREM_AMT_LABEL() {
		return COMP_PCCD_LC_INV_PREM_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_LC_INV_PREM_AMT() {
		return COMP_PCCD_LC_INV_PREM_AMT;
	}

	public void setCOMP_PCCD_LC_INV_PREM_AMT_LABEL(
			HtmlOutputLabel COMP_PCCD_LC_INV_PREM_AMT_LABEL) {
		this.COMP_PCCD_LC_INV_PREM_AMT_LABEL = COMP_PCCD_LC_INV_PREM_AMT_LABEL;
	}

	public void setCOMP_PCCD_LC_INV_PREM_AMT(
			HtmlInputText COMP_PCCD_LC_INV_PREM_AMT) {
		this.COMP_PCCD_LC_INV_PREM_AMT = COMP_PCCD_LC_INV_PREM_AMT;
	}

	public HtmlOutputLabel getCOMP_PCCD_LC_RISK_DISC_AMT_LABEL() {
		return COMP_PCCD_LC_RISK_DISC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_LC_RISK_DISC_AMT() {
		return COMP_PCCD_LC_RISK_DISC_AMT;
	}

	public void setCOMP_PCCD_LC_RISK_DISC_AMT_LABEL(
			HtmlOutputLabel COMP_PCCD_LC_RISK_DISC_AMT_LABEL) {
		this.COMP_PCCD_LC_RISK_DISC_AMT_LABEL = COMP_PCCD_LC_RISK_DISC_AMT_LABEL;
	}

	public void setCOMP_PCCD_LC_RISK_DISC_AMT(
			HtmlInputText COMP_PCCD_LC_RISK_DISC_AMT) {
		this.COMP_PCCD_LC_RISK_DISC_AMT = COMP_PCCD_LC_RISK_DISC_AMT;
	}

	public HtmlOutputLabel getCOMP_PCCD_LC_INV_DISC_AMT_LABEL() {
		return COMP_PCCD_LC_INV_DISC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_LC_INV_DISC_AMT() {
		return COMP_PCCD_LC_INV_DISC_AMT;
	}

	public void setCOMP_PCCD_LC_INV_DISC_AMT_LABEL(
			HtmlOutputLabel COMP_PCCD_LC_INV_DISC_AMT_LABEL) {
		this.COMP_PCCD_LC_INV_DISC_AMT_LABEL = COMP_PCCD_LC_INV_DISC_AMT_LABEL;
	}

	public void setCOMP_PCCD_LC_INV_DISC_AMT(
			HtmlInputText COMP_PCCD_LC_INV_DISC_AMT) {
		this.COMP_PCCD_LC_INV_DISC_AMT = COMP_PCCD_LC_INV_DISC_AMT;
	}

	public HtmlOutputLabel getCOMP_PCCD_LC_RISK_LOAD_AMT_LABEL() {
		return COMP_PCCD_LC_RISK_LOAD_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_LC_RISK_LOAD_AMT() {
		return COMP_PCCD_LC_RISK_LOAD_AMT;
	}

	public void setCOMP_PCCD_LC_RISK_LOAD_AMT_LABEL(
			HtmlOutputLabel COMP_PCCD_LC_RISK_LOAD_AMT_LABEL) {
		this.COMP_PCCD_LC_RISK_LOAD_AMT_LABEL = COMP_PCCD_LC_RISK_LOAD_AMT_LABEL;
	}

	public void setCOMP_PCCD_LC_RISK_LOAD_AMT(
			HtmlInputText COMP_PCCD_LC_RISK_LOAD_AMT) {
		this.COMP_PCCD_LC_RISK_LOAD_AMT = COMP_PCCD_LC_RISK_LOAD_AMT;
	}

	public HtmlOutputLabel getCOMP_PCCD_LC_INV_LOAD_AMT_LABEL() {
		return COMP_PCCD_LC_INV_LOAD_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCCD_LC_INV_LOAD_AMT() {
		return COMP_PCCD_LC_INV_LOAD_AMT;
	}

	public void setCOMP_PCCD_LC_INV_LOAD_AMT_LABEL(
			HtmlOutputLabel COMP_PCCD_LC_INV_LOAD_AMT_LABEL) {
		this.COMP_PCCD_LC_INV_LOAD_AMT_LABEL = COMP_PCCD_LC_INV_LOAD_AMT_LABEL;
	}

	public void setCOMP_PCCD_LC_INV_LOAD_AMT(
			HtmlInputText COMP_PCCD_LC_INV_LOAD_AMT) {
		this.COMP_PCCD_LC_INV_LOAD_AMT = COMP_PCCD_LC_INV_LOAD_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_LC_LABEL() {
		return COMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_LC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_LC() {
		return COMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_LC;
	}

	public void setCOMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_LC_LABEL(
			HtmlOutputLabel COMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_LC_LABEL) {
		this.COMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_LC_LABEL = COMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_LC_LABEL;
	}

	public void setCOMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_LC(
			HtmlInputText COMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_LC) {
		this.COMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_LC = COMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_LC;
	}

	public HtmlOutputLabel getCOMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_LC_LABEL() {
		return COMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_LC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_LC() {
		return COMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_LC;
	}

	public void setCOMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_LC_LABEL(
			HtmlOutputLabel COMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_LC_LABEL) {
		this.COMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_LC_LABEL = COMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_LC_LABEL;
	}

	public void setCOMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_LC(
			HtmlInputText COMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_LC) {
		this.COMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_LC = COMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_LC;
	}

	public PT_IL_PREM_COLL_CVR_DTL getPT_IL_PREM_COLL_CVR_DTL_BEAN() {
		return PT_IL_PREM_COLL_CVR_DTL_BEAN;
	}

	public void setPT_IL_PREM_COLL_CVR_DTL_BEAN(
			PT_IL_PREM_COLL_CVR_DTL PT_IL_PREM_COLL_CVR_DTL_BEAN) {
		this.PT_IL_PREM_COLL_CVR_DTL_BEAN = PT_IL_PREM_COLL_CVR_DTL_BEAN;
	}

	public List<PT_IL_PREM_COLL_CVR_DTL> getDataList_PT_IL_PREM_COLL_CVR_DTL() {
		return dataList_PT_IL_PREM_COLL_CVR_DTL;
	}

	public void setDataListPT_IL_PREM_COLL_CVR_DTL(
			List<PT_IL_PREM_COLL_CVR_DTL> dataList_PT_IL_PREM_COLL_CVR_DTL) {
		this.dataList_PT_IL_PREM_COLL_CVR_DTL = dataList_PT_IL_PREM_COLL_CVR_DTL;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PT_IL_PREM_COLL_CVR_DTL_BEAN = new PT_IL_PREM_COLL_CVR_DTL();
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

				new PT_IL_PREM_COLL_CVR_DTL_HELPER().preDelete();
				new CRUDHandler().executeDelete(PT_IL_PREM_COLL_CVR_DTL_BEAN,
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
				dataList_PT_IL_PREM_COLL_CVR_DTL
						.remove(PT_IL_PREM_COLL_CVR_DTL_BEAN);
				if (dataList_PT_IL_PREM_COLL_CVR_DTL.size() > 0) {

					PT_IL_PREM_COLL_CVR_DTL_BEAN = dataList_PT_IL_PREM_COLL_CVR_DTL
							.get(0);
				} else if (dataList_PT_IL_PREM_COLL_CVR_DTL.size() == 0) {

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
			if (PT_IL_PREM_COLL_CVR_DTL_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {

				new PT_IL_PREM_COLL_CVR_DTL_HELPER()
						.preInsert(PT_IL_PREM_COLL_CVR_DTL_BEAN);
				new CRUDHandler().executeInsert(PT_IL_PREM_COLL_CVR_DTL_BEAN,
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
				dataList_PT_IL_PREM_COLL_CVR_DTL
						.add(PT_IL_PREM_COLL_CVR_DTL_BEAN);
			} else if (PT_IL_PREM_COLL_CVR_DTL_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {

				new PT_IL_PREM_COLL_CVR_DTL_HELPER()
						.preUpdate(PT_IL_PREM_COLL_CVR_DTL_BEAN);
				new CRUDHandler().executeUpdate(PT_IL_PREM_COLL_CVR_DTL_BEAN,
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
		COMP_PCCD_FLEX_30.resetValue();
		COMP_PCCD_FLEX_16.resetValue();
		COMP_PCCD_FLEX_28.resetValue();
		COMP_PCCD_FLEX_29.resetValue();
		COMP_PCCD_FLEX_27.resetValue();
		COMP_PCCD_FLEX_26.resetValue();
		COMP_PCCD_FLEX_25.resetValue();
		COMP_PCCD_FLEX_24.resetValue();
		COMP_PCCD_FLEX_23.resetValue();
		COMP_PCCD_FLEX_22.resetValue();
		COMP_PCCD_FLEX_21.resetValue();
		COMP_PCCD_FLEX_20.resetValue();
		COMP_PCCD_FLEX_19.resetValue();
		COMP_PCCD_FLEX_18.resetValue();
		COMP_PCCD_FLEX_17.resetValue();
		COMP_PCCD_FLEX_01.resetValue();
		COMP_PCCD_FLEX_02.resetValue();
		COMP_PCCD_FLEX_03.resetValue();
		COMP_PCCD_FLEX_04.resetValue();
		COMP_PCCD_FLEX_05.resetValue();
		COMP_PCCD_FLEX_06.resetValue();
		COMP_PCCD_FLEX_07.resetValue();
		COMP_PCCD_FLEX_08.resetValue();
		COMP_PCCD_FLEX_09.resetValue();
		COMP_PCCD_FLEX_10.resetValue();
		COMP_PCCD_FLEX_11.resetValue();
		COMP_PCCD_FLEX_12.resetValue();
		COMP_PCCD_FLEX_13.resetValue();
		COMP_PCCD_FLEX_14.resetValue();
		COMP_PCCD_FLEX_15.resetValue();
		COMP_B_PCCD_PREMIUM.resetValue();
		COMP_B_PCCD_DISCOUNT.resetValue();
		COMP_B_PCCD_LOADING.resetValue();
		COMP_B_M_PCCD_TOTAL_CVR_PREM.resetValue();
		COMP_PCCD_COVER_CODE.resetValue();
		COMP_PCCD_FC_RISK_PREM_AMT.resetValue();
		COMP_PCCD_FC_INV_PREM_AMT.resetValue();
		COMP_PCCD_FC_RISK_DISC_AMT.resetValue();
		COMP_PCCD_FC_INV_DISC_AMT.resetValue();
		COMP_PCCD_FC_RISK_LOAD_AMT.resetValue();
		COMP_PCCD_FC_INV_LOAD_AMT.resetValue();
		COMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_FC.resetValue();
		COMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_FC.resetValue();
		COMP_PCCD_LC_RISK_PREM_AMT.resetValue();
		COMP_PCCD_LC_INV_PREM_AMT.resetValue();
		COMP_PCCD_LC_RISK_DISC_AMT.resetValue();
		COMP_PCCD_LC_INV_DISC_AMT.resetValue();
		COMP_PCCD_LC_RISK_LOAD_AMT.resetValue();
		COMP_PCCD_LC_INV_LOAD_AMT.resetValue();
		COMP_UI_M_PCCD_TOTAL_CVR_PREM_RISK_LC.resetValue();
		COMP_UI_M_PCCD_TOTAL_CVR_PREM_INV_LC.resetValue();
	}

	public PILT024_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT024_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}
}