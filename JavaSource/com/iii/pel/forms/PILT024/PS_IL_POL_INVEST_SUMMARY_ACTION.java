package com.iii.pel.forms.PILT024;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlInputText;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BENEFICIARY;
import com.iii.pel.forms.PILT010.PT_IL_RI_DETL;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PS_IL_POL_INVEST_SUMMARY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PIS_FLEX_11_LABEL;

	private HtmlInputText COMP_PIS_FLEX_11;

	private HtmlOutputLabel COMP_PIS_FLEX_28_LABEL;

	private HtmlInputText COMP_PIS_FLEX_28;

	private HtmlOutputLabel COMP_PIS_FLEX_27_LABEL;

	private HtmlInputText COMP_PIS_FLEX_27;

	private HtmlOutputLabel COMP_PIS_FLEX_26_LABEL;

	private HtmlInputText COMP_PIS_FLEX_26;

	private HtmlOutputLabel COMP_PIS_FLEX_25_LABEL;

	private HtmlInputText COMP_PIS_FLEX_25;

	private HtmlOutputLabel COMP_PIS_FLEX_24_LABEL;

	private HtmlInputText COMP_PIS_FLEX_24;

	private HtmlOutputLabel COMP_PIS_FLEX_30_LABEL;

	private HtmlInputText COMP_PIS_FLEX_30;

	private HtmlOutputLabel COMP_PIS_FLEX_01_LABEL;

	private HtmlInputText COMP_PIS_FLEX_01;

	private HtmlOutputLabel COMP_PIS_FLEX_02_LABEL;

	private HtmlInputText COMP_PIS_FLEX_02;

	private HtmlOutputLabel COMP_PIS_FLEX_03_LABEL;

	private HtmlCalendar COMP_PIS_FLEX_03; /*modified by Ameen on 29-05-2017 as per Gaurav sugg.*/

	private HtmlOutputLabel COMP_PIS_FLEX_04_LABEL;

	private HtmlCalendar COMP_PIS_FLEX_04; /*modified by Ameen on 29-05-2017 as per Gaurav sugg.*/

	private HtmlOutputLabel COMP_PIS_FLEX_05_LABEL;

	private HtmlInputText COMP_PIS_FLEX_05;

	private HtmlOutputLabel COMP_PIS_FLEX_06_LABEL;

	private HtmlInputText COMP_PIS_FLEX_06;

	private HtmlOutputLabel COMP_PIS_FLEX_07_LABEL;

	private HtmlInputText COMP_PIS_FLEX_07;

	private HtmlOutputLabel COMP_PIS_FLEX_08_LABEL;

	private HtmlInputText COMP_PIS_FLEX_08;

	private HtmlOutputLabel COMP_PIS_FLEX_09_LABEL;

	private HtmlInputText COMP_PIS_FLEX_09;

	private HtmlOutputLabel COMP_PIS_FLEX_10_LABEL;

	private HtmlInputText COMP_PIS_FLEX_10;

	private HtmlOutputLabel COMP_PIS_FLEX_29_LABEL;

	private HtmlInputText COMP_PIS_FLEX_29;

	private HtmlOutputLabel COMP_PIS_FLEX_12_LABEL;

	private HtmlInputText COMP_PIS_FLEX_12;

	private HtmlOutputLabel COMP_PIS_FLEX_13_LABEL;

	private HtmlInputText COMP_PIS_FLEX_13;

	private HtmlOutputLabel COMP_PIS_FLEX_14_LABEL;

	private HtmlInputText COMP_PIS_FLEX_14;

	private HtmlOutputLabel COMP_PIS_FLEX_15_LABEL;

	private HtmlInputText COMP_PIS_FLEX_15;

	private HtmlOutputLabel COMP_PIS_FLEX_16_LABEL;

	private HtmlInputText COMP_PIS_FLEX_16;

	private HtmlOutputLabel COMP_PIS_FLEX_17_LABEL;

	private HtmlInputText COMP_PIS_FLEX_17;

	private HtmlOutputLabel COMP_PIS_FLEX_18_LABEL;

	private HtmlInputText COMP_PIS_FLEX_18;

	private HtmlOutputLabel COMP_PIS_FLEX_19_LABEL;

	private HtmlInputText COMP_PIS_FLEX_19;

	private HtmlOutputLabel COMP_PIS_FLEX_20_LABEL;

	private HtmlInputText COMP_PIS_FLEX_20;

	private HtmlOutputLabel COMP_PIS_FLEX_21_LABEL;

	private HtmlInputText COMP_PIS_FLEX_21;

	private HtmlOutputLabel COMP_PIS_FLEX_22_LABEL;

	private HtmlInputText COMP_PIS_FLEX_22;

	private HtmlOutputLabel COMP_PIS_FLEX_23_LABEL;

	private HtmlInputText COMP_PIS_FLEX_23;

	private HtmlOutputLabel COMP_PIS_SR_NO_LABEL;

	private HtmlInputText COMP_PIS_SR_NO;

	private HtmlOutputLabel COMP_PIS_DT_LABEL;

	private HtmlCalendar COMP_PIS_DT;

	private HtmlOutputLabel COMP_PIS_FC_MOP_INVEST_AMT_LABEL;

	private HtmlInputText COMP_PIS_FC_MOP_INVEST_AMT;

	private HtmlOutputLabel COMP_PIS_FC_OPBAL_LABEL;

	private HtmlInputText COMP_PIS_FC_OPBAL;

	private HtmlOutputLabel COMP_PIS_FC_TOTAL_CONTR_LABEL;

	private HtmlInputText COMP_PIS_FC_TOTAL_CONTR;

	private HtmlOutputLabel COMP_PIS_FC_TOTAL_INTEREST_LABEL;

	private HtmlInputText COMP_PIS_FC_TOTAL_INTEREST;

	private HtmlOutputLabel COMP_PIS_FC_CLBAL_LABEL;

	private HtmlInputText COMP_PIS_FC_CLBAL;

	private HtmlOutputLabel COMP_PIS_FC_CURR_SA_LABEL;

	private HtmlInputText COMP_PIS_FC_CURR_SA;

	private HtmlOutputLabel COMP_PIS_LC_MOP_INVEST_AMT_LABEL;

	private HtmlInputText COMP_PIS_LC_MOP_INVEST_AMT;

	private HtmlOutputLabel COMP_PIS_LC_OPBAL_LABEL;

	private HtmlInputText COMP_PIS_LC_OPBAL;

	private HtmlOutputLabel COMP_PIS_LC_TOTAL_CONTR_LABEL;

	private HtmlInputText COMP_PIS_LC_TOTAL_CONTR;

	private HtmlOutputLabel COMP_PIS_LC_TOTAL_INTEREST_LABEL;

	private HtmlInputText COMP_PIS_LC_TOTAL_INTEREST;

	private HtmlOutputLabel COMP_PIS_LC_CLBAL_LABEL;

	private HtmlInputText COMP_PIS_LC_CLBAL;

	private HtmlOutputLabel COMP_PIS_LC_CURR_SA_LABEL;

	private HtmlInputText COMP_PIS_LC_CURR_SA;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN_2;

	private PS_IL_POL_INVEST_SUMMARY PS_IL_POL_INVEST_SUMMARY_BEAN;

	public PILT024_COMPOSITE_ACTION compositeAction;

	private PS_IL_POL_INVEST_SUMMARY_HELPER helper;

	private List<PS_IL_POL_INVEST_SUMMARY> dataList_PS_IL_POL_INVEST_SUMMARY = new ArrayList<PS_IL_POL_INVEST_SUMMARY>();

	private UIData dataTable;
	
	private HtmlOutputLabel COMP_UI_M_PREMIUM_DUE_DATE_LABEL;
	
	private HtmlCalendar COMP_UI_M_PREMIUM_DUE_DATE;
	
	private HtmlOutputLabel COMP_UI_M_PREMIUM_PAID_DATE_LABEL;
	
	private HtmlCalendar COMP_UI_M_PREMIUM_PAID_DATE;
	
	public HtmlOutputLabel getCOMP_UI_M_PREMIUM_DUE_DATE_LABEL() {
		return COMP_UI_M_PREMIUM_DUE_DATE_LABEL;
	}

	public void setCOMP_UI_M_PREMIUM_DUE_DATE_LABEL(
			HtmlOutputLabel cOMP_UI_M_PREMIUM_DUE_DATE_LABEL) {
		COMP_UI_M_PREMIUM_DUE_DATE_LABEL = cOMP_UI_M_PREMIUM_DUE_DATE_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_PREMIUM_DUE_DATE() {
		return COMP_UI_M_PREMIUM_DUE_DATE;
	}

	public void setCOMP_UI_M_PREMIUM_DUE_DATE(
			HtmlCalendar cOMP_UI_M_PREMIUM_DUE_DATE) {
		COMP_UI_M_PREMIUM_DUE_DATE = cOMP_UI_M_PREMIUM_DUE_DATE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PREMIUM_PAID_DATE_LABEL() {
		return COMP_UI_M_PREMIUM_PAID_DATE_LABEL;
	}

	public void setCOMP_UI_M_PREMIUM_PAID_DATE_LABEL(
			HtmlOutputLabel cOMP_UI_M_PREMIUM_PAID_DATE_LABEL) {
		COMP_UI_M_PREMIUM_PAID_DATE_LABEL = cOMP_UI_M_PREMIUM_PAID_DATE_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_PREMIUM_PAID_DATE() {
		return COMP_UI_M_PREMIUM_PAID_DATE;
	}

	public void setCOMP_UI_M_PREMIUM_PAID_DATE(
			HtmlCalendar cOMP_UI_M_PREMIUM_PAID_DATE) {
		COMP_UI_M_PREMIUM_PAID_DATE = cOMP_UI_M_PREMIUM_PAID_DATE;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public void setDataList_PS_IL_POL_INVEST_SUMMARY(
			List<PS_IL_POL_INVEST_SUMMARY> dataList_PS_IL_POL_INVEST_SUMMARY) {
		this.dataList_PS_IL_POL_INVEST_SUMMARY = dataList_PS_IL_POL_INVEST_SUMMARY;
	}

	public PS_IL_POL_INVEST_SUMMARY_ACTION() {

		PS_IL_POL_INVEST_SUMMARY_BEAN = new PS_IL_POL_INVEST_SUMMARY();
		helper = new PS_IL_POL_INVEST_SUMMARY_HELPER();
		/*Added by Ameen on 17-05-2017*/
		initializeAllComponent();
		/*End*/
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_11_LABEL() {
		return COMP_PIS_FLEX_11_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_11() {
		return COMP_PIS_FLEX_11;
	}

	public void setCOMP_PIS_FLEX_11_LABEL(HtmlOutputLabel COMP_PIS_FLEX_11_LABEL) {
		this.COMP_PIS_FLEX_11_LABEL = COMP_PIS_FLEX_11_LABEL;
	}

	public void setCOMP_PIS_FLEX_11(HtmlInputText COMP_PIS_FLEX_11) {
		this.COMP_PIS_FLEX_11 = COMP_PIS_FLEX_11;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_28_LABEL() {
		return COMP_PIS_FLEX_28_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_28() {
		return COMP_PIS_FLEX_28;
	}

	public void setCOMP_PIS_FLEX_28_LABEL(HtmlOutputLabel COMP_PIS_FLEX_28_LABEL) {
		this.COMP_PIS_FLEX_28_LABEL = COMP_PIS_FLEX_28_LABEL;
	}

	public void setCOMP_PIS_FLEX_28(HtmlInputText COMP_PIS_FLEX_28) {
		this.COMP_PIS_FLEX_28 = COMP_PIS_FLEX_28;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_27_LABEL() {
		return COMP_PIS_FLEX_27_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_27() {
		return COMP_PIS_FLEX_27;
	}

	public void setCOMP_PIS_FLEX_27_LABEL(HtmlOutputLabel COMP_PIS_FLEX_27_LABEL) {
		this.COMP_PIS_FLEX_27_LABEL = COMP_PIS_FLEX_27_LABEL;
	}

	public void setCOMP_PIS_FLEX_27(HtmlInputText COMP_PIS_FLEX_27) {
		this.COMP_PIS_FLEX_27 = COMP_PIS_FLEX_27;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_26_LABEL() {
		return COMP_PIS_FLEX_26_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_26() {
		return COMP_PIS_FLEX_26;
	}

	public void setCOMP_PIS_FLEX_26_LABEL(HtmlOutputLabel COMP_PIS_FLEX_26_LABEL) {
		this.COMP_PIS_FLEX_26_LABEL = COMP_PIS_FLEX_26_LABEL;
	}

	public void setCOMP_PIS_FLEX_26(HtmlInputText COMP_PIS_FLEX_26) {
		this.COMP_PIS_FLEX_26 = COMP_PIS_FLEX_26;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_25_LABEL() {
		return COMP_PIS_FLEX_25_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_25() {
		return COMP_PIS_FLEX_25;
	}

	public void setCOMP_PIS_FLEX_25_LABEL(HtmlOutputLabel COMP_PIS_FLEX_25_LABEL) {
		this.COMP_PIS_FLEX_25_LABEL = COMP_PIS_FLEX_25_LABEL;
	}

	public void setCOMP_PIS_FLEX_25(HtmlInputText COMP_PIS_FLEX_25) {
		this.COMP_PIS_FLEX_25 = COMP_PIS_FLEX_25;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_24_LABEL() {
		return COMP_PIS_FLEX_24_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_24() {
		return COMP_PIS_FLEX_24;
	}

	public void setCOMP_PIS_FLEX_24_LABEL(HtmlOutputLabel COMP_PIS_FLEX_24_LABEL) {
		this.COMP_PIS_FLEX_24_LABEL = COMP_PIS_FLEX_24_LABEL;
	}

	public void setCOMP_PIS_FLEX_24(HtmlInputText COMP_PIS_FLEX_24) {
		this.COMP_PIS_FLEX_24 = COMP_PIS_FLEX_24;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_30_LABEL() {
		return COMP_PIS_FLEX_30_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_30() {
		return COMP_PIS_FLEX_30;
	}

	public void setCOMP_PIS_FLEX_30_LABEL(HtmlOutputLabel COMP_PIS_FLEX_30_LABEL) {
		this.COMP_PIS_FLEX_30_LABEL = COMP_PIS_FLEX_30_LABEL;
	}

	public void setCOMP_PIS_FLEX_30(HtmlInputText COMP_PIS_FLEX_30) {
		this.COMP_PIS_FLEX_30 = COMP_PIS_FLEX_30;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_01_LABEL() {
		return COMP_PIS_FLEX_01_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_01() {
		return COMP_PIS_FLEX_01;
	}

	public void setCOMP_PIS_FLEX_01_LABEL(HtmlOutputLabel COMP_PIS_FLEX_01_LABEL) {
		this.COMP_PIS_FLEX_01_LABEL = COMP_PIS_FLEX_01_LABEL;
	}

	public void setCOMP_PIS_FLEX_01(HtmlInputText COMP_PIS_FLEX_01) {
		this.COMP_PIS_FLEX_01 = COMP_PIS_FLEX_01;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_02_LABEL() {
		return COMP_PIS_FLEX_02_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_02() {
		return COMP_PIS_FLEX_02;
	}

	public void setCOMP_PIS_FLEX_02_LABEL(HtmlOutputLabel COMP_PIS_FLEX_02_LABEL) {
		this.COMP_PIS_FLEX_02_LABEL = COMP_PIS_FLEX_02_LABEL;
	}

	public void setCOMP_PIS_FLEX_02(HtmlInputText COMP_PIS_FLEX_02) {
		this.COMP_PIS_FLEX_02 = COMP_PIS_FLEX_02;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_03_LABEL() {
		return COMP_PIS_FLEX_03_LABEL;
	}

	public HtmlCalendar getCOMP_PIS_FLEX_03() {
		return COMP_PIS_FLEX_03;
	}

	public void setCOMP_PIS_FLEX_03_LABEL(HtmlOutputLabel COMP_PIS_FLEX_03_LABEL) {
		this.COMP_PIS_FLEX_03_LABEL = COMP_PIS_FLEX_03_LABEL;
	}

	public void setCOMP_PIS_FLEX_03(HtmlCalendar COMP_PIS_FLEX_03) {
		this.COMP_PIS_FLEX_03 = COMP_PIS_FLEX_03;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_04_LABEL() {
		return COMP_PIS_FLEX_04_LABEL;
	}

	public HtmlCalendar getCOMP_PIS_FLEX_04() {
		return COMP_PIS_FLEX_04;
	}

	public void setCOMP_PIS_FLEX_04_LABEL(HtmlOutputLabel COMP_PIS_FLEX_04_LABEL) {
		this.COMP_PIS_FLEX_04_LABEL = COMP_PIS_FLEX_04_LABEL;
	}

	public void setCOMP_PIS_FLEX_04(HtmlCalendar COMP_PIS_FLEX_04) {
		this.COMP_PIS_FLEX_04 = COMP_PIS_FLEX_04;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_05_LABEL() {
		return COMP_PIS_FLEX_05_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_05() {
		return COMP_PIS_FLEX_05;
	}

	public void setCOMP_PIS_FLEX_05_LABEL(HtmlOutputLabel COMP_PIS_FLEX_05_LABEL) {
		this.COMP_PIS_FLEX_05_LABEL = COMP_PIS_FLEX_05_LABEL;
	}

	public void setCOMP_PIS_FLEX_05(HtmlInputText COMP_PIS_FLEX_05) {
		this.COMP_PIS_FLEX_05 = COMP_PIS_FLEX_05;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_06_LABEL() {
		return COMP_PIS_FLEX_06_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_06() {
		return COMP_PIS_FLEX_06;
	}

	public void setCOMP_PIS_FLEX_06_LABEL(HtmlOutputLabel COMP_PIS_FLEX_06_LABEL) {
		this.COMP_PIS_FLEX_06_LABEL = COMP_PIS_FLEX_06_LABEL;
	}

	public void setCOMP_PIS_FLEX_06(HtmlInputText COMP_PIS_FLEX_06) {
		this.COMP_PIS_FLEX_06 = COMP_PIS_FLEX_06;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_07_LABEL() {
		return COMP_PIS_FLEX_07_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_07() {
		return COMP_PIS_FLEX_07;
	}

	public void setCOMP_PIS_FLEX_07_LABEL(HtmlOutputLabel COMP_PIS_FLEX_07_LABEL) {
		this.COMP_PIS_FLEX_07_LABEL = COMP_PIS_FLEX_07_LABEL;
	}

	public void setCOMP_PIS_FLEX_07(HtmlInputText COMP_PIS_FLEX_07) {
		this.COMP_PIS_FLEX_07 = COMP_PIS_FLEX_07;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_08_LABEL() {
		return COMP_PIS_FLEX_08_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_08() {
		return COMP_PIS_FLEX_08;
	}

	public void setCOMP_PIS_FLEX_08_LABEL(HtmlOutputLabel COMP_PIS_FLEX_08_LABEL) {
		this.COMP_PIS_FLEX_08_LABEL = COMP_PIS_FLEX_08_LABEL;
	}

	public void setCOMP_PIS_FLEX_08(HtmlInputText COMP_PIS_FLEX_08) {
		this.COMP_PIS_FLEX_08 = COMP_PIS_FLEX_08;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_09_LABEL() {
		return COMP_PIS_FLEX_09_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_09() {
		return COMP_PIS_FLEX_09;
	}

	public void setCOMP_PIS_FLEX_09_LABEL(HtmlOutputLabel COMP_PIS_FLEX_09_LABEL) {
		this.COMP_PIS_FLEX_09_LABEL = COMP_PIS_FLEX_09_LABEL;
	}

	public void setCOMP_PIS_FLEX_09(HtmlInputText COMP_PIS_FLEX_09) {
		this.COMP_PIS_FLEX_09 = COMP_PIS_FLEX_09;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_10_LABEL() {
		return COMP_PIS_FLEX_10_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_10() {
		return COMP_PIS_FLEX_10;
	}

	public void setCOMP_PIS_FLEX_10_LABEL(HtmlOutputLabel COMP_PIS_FLEX_10_LABEL) {
		this.COMP_PIS_FLEX_10_LABEL = COMP_PIS_FLEX_10_LABEL;
	}

	public void setCOMP_PIS_FLEX_10(HtmlInputText COMP_PIS_FLEX_10) {
		this.COMP_PIS_FLEX_10 = COMP_PIS_FLEX_10;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_29_LABEL() {
		return COMP_PIS_FLEX_29_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_29() {
		return COMP_PIS_FLEX_29;
	}

	public void setCOMP_PIS_FLEX_29_LABEL(HtmlOutputLabel COMP_PIS_FLEX_29_LABEL) {
		this.COMP_PIS_FLEX_29_LABEL = COMP_PIS_FLEX_29_LABEL;
	}

	public void setCOMP_PIS_FLEX_29(HtmlInputText COMP_PIS_FLEX_29) {
		this.COMP_PIS_FLEX_29 = COMP_PIS_FLEX_29;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_12_LABEL() {
		return COMP_PIS_FLEX_12_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_12() {
		return COMP_PIS_FLEX_12;
	}

	public void setCOMP_PIS_FLEX_12_LABEL(HtmlOutputLabel COMP_PIS_FLEX_12_LABEL) {
		this.COMP_PIS_FLEX_12_LABEL = COMP_PIS_FLEX_12_LABEL;
	}

	public void setCOMP_PIS_FLEX_12(HtmlInputText COMP_PIS_FLEX_12) {
		this.COMP_PIS_FLEX_12 = COMP_PIS_FLEX_12;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_13_LABEL() {
		return COMP_PIS_FLEX_13_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_13() {
		return COMP_PIS_FLEX_13;
	}

	public void setCOMP_PIS_FLEX_13_LABEL(HtmlOutputLabel COMP_PIS_FLEX_13_LABEL) {
		this.COMP_PIS_FLEX_13_LABEL = COMP_PIS_FLEX_13_LABEL;
	}

	public void setCOMP_PIS_FLEX_13(HtmlInputText COMP_PIS_FLEX_13) {
		this.COMP_PIS_FLEX_13 = COMP_PIS_FLEX_13;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_14_LABEL() {
		return COMP_PIS_FLEX_14_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_14() {
		return COMP_PIS_FLEX_14;
	}

	public void setCOMP_PIS_FLEX_14_LABEL(HtmlOutputLabel COMP_PIS_FLEX_14_LABEL) {
		this.COMP_PIS_FLEX_14_LABEL = COMP_PIS_FLEX_14_LABEL;
	}

	public void setCOMP_PIS_FLEX_14(HtmlInputText COMP_PIS_FLEX_14) {
		this.COMP_PIS_FLEX_14 = COMP_PIS_FLEX_14;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_15_LABEL() {
		return COMP_PIS_FLEX_15_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_15() {
		return COMP_PIS_FLEX_15;
	}

	public void setCOMP_PIS_FLEX_15_LABEL(HtmlOutputLabel COMP_PIS_FLEX_15_LABEL) {
		this.COMP_PIS_FLEX_15_LABEL = COMP_PIS_FLEX_15_LABEL;
	}

	public void setCOMP_PIS_FLEX_15(HtmlInputText COMP_PIS_FLEX_15) {
		this.COMP_PIS_FLEX_15 = COMP_PIS_FLEX_15;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_16_LABEL() {
		return COMP_PIS_FLEX_16_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_16() {
		return COMP_PIS_FLEX_16;
	}

	public void setCOMP_PIS_FLEX_16_LABEL(HtmlOutputLabel COMP_PIS_FLEX_16_LABEL) {
		this.COMP_PIS_FLEX_16_LABEL = COMP_PIS_FLEX_16_LABEL;
	}

	public void setCOMP_PIS_FLEX_16(HtmlInputText COMP_PIS_FLEX_16) {
		this.COMP_PIS_FLEX_16 = COMP_PIS_FLEX_16;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_17_LABEL() {
		return COMP_PIS_FLEX_17_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_17() {
		return COMP_PIS_FLEX_17;
	}

	public void setCOMP_PIS_FLEX_17_LABEL(HtmlOutputLabel COMP_PIS_FLEX_17_LABEL) {
		this.COMP_PIS_FLEX_17_LABEL = COMP_PIS_FLEX_17_LABEL;
	}

	public void setCOMP_PIS_FLEX_17(HtmlInputText COMP_PIS_FLEX_17) {
		this.COMP_PIS_FLEX_17 = COMP_PIS_FLEX_17;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_18_LABEL() {
		return COMP_PIS_FLEX_18_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_18() {
		return COMP_PIS_FLEX_18;
	}

	public void setCOMP_PIS_FLEX_18_LABEL(HtmlOutputLabel COMP_PIS_FLEX_18_LABEL) {
		this.COMP_PIS_FLEX_18_LABEL = COMP_PIS_FLEX_18_LABEL;
	}

	public void setCOMP_PIS_FLEX_18(HtmlInputText COMP_PIS_FLEX_18) {
		this.COMP_PIS_FLEX_18 = COMP_PIS_FLEX_18;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_19_LABEL() {
		return COMP_PIS_FLEX_19_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_19() {
		return COMP_PIS_FLEX_19;
	}

	public void setCOMP_PIS_FLEX_19_LABEL(HtmlOutputLabel COMP_PIS_FLEX_19_LABEL) {
		this.COMP_PIS_FLEX_19_LABEL = COMP_PIS_FLEX_19_LABEL;
	}

	public void setCOMP_PIS_FLEX_19(HtmlInputText COMP_PIS_FLEX_19) {
		this.COMP_PIS_FLEX_19 = COMP_PIS_FLEX_19;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_20_LABEL() {
		return COMP_PIS_FLEX_20_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_20() {
		return COMP_PIS_FLEX_20;
	}

	public void setCOMP_PIS_FLEX_20_LABEL(HtmlOutputLabel COMP_PIS_FLEX_20_LABEL) {
		this.COMP_PIS_FLEX_20_LABEL = COMP_PIS_FLEX_20_LABEL;
	}

	public void setCOMP_PIS_FLEX_20(HtmlInputText COMP_PIS_FLEX_20) {
		this.COMP_PIS_FLEX_20 = COMP_PIS_FLEX_20;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_21_LABEL() {
		return COMP_PIS_FLEX_21_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_21() {
		return COMP_PIS_FLEX_21;
	}

	public void setCOMP_PIS_FLEX_21_LABEL(HtmlOutputLabel COMP_PIS_FLEX_21_LABEL) {
		this.COMP_PIS_FLEX_21_LABEL = COMP_PIS_FLEX_21_LABEL;
	}

	public void setCOMP_PIS_FLEX_21(HtmlInputText COMP_PIS_FLEX_21) {
		this.COMP_PIS_FLEX_21 = COMP_PIS_FLEX_21;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_22_LABEL() {
		return COMP_PIS_FLEX_22_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_22() {
		return COMP_PIS_FLEX_22;
	}

	public void setCOMP_PIS_FLEX_22_LABEL(HtmlOutputLabel COMP_PIS_FLEX_22_LABEL) {
		this.COMP_PIS_FLEX_22_LABEL = COMP_PIS_FLEX_22_LABEL;
	}

	public void setCOMP_PIS_FLEX_22(HtmlInputText COMP_PIS_FLEX_22) {
		this.COMP_PIS_FLEX_22 = COMP_PIS_FLEX_22;
	}

	public HtmlOutputLabel getCOMP_PIS_FLEX_23_LABEL() {
		return COMP_PIS_FLEX_23_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FLEX_23() {
		return COMP_PIS_FLEX_23;
	}

	public void setCOMP_PIS_FLEX_23_LABEL(HtmlOutputLabel COMP_PIS_FLEX_23_LABEL) {
		this.COMP_PIS_FLEX_23_LABEL = COMP_PIS_FLEX_23_LABEL;
	}

	public void setCOMP_PIS_FLEX_23(HtmlInputText COMP_PIS_FLEX_23) {
		this.COMP_PIS_FLEX_23 = COMP_PIS_FLEX_23;
	}

	public HtmlOutputLabel getCOMP_PIS_SR_NO_LABEL() {
		return COMP_PIS_SR_NO_LABEL;
	}

	public HtmlInputText getCOMP_PIS_SR_NO() {
		return COMP_PIS_SR_NO;
	}

	public void setCOMP_PIS_SR_NO_LABEL(HtmlOutputLabel COMP_PIS_SR_NO_LABEL) {
		this.COMP_PIS_SR_NO_LABEL = COMP_PIS_SR_NO_LABEL;
	}

	public void setCOMP_PIS_SR_NO(HtmlInputText COMP_PIS_SR_NO) {
		this.COMP_PIS_SR_NO = COMP_PIS_SR_NO;
	}

	public HtmlOutputLabel getCOMP_PIS_DT_LABEL() {
		return COMP_PIS_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PIS_DT() {
		return COMP_PIS_DT;
	}

	public void setCOMP_PIS_DT_LABEL(HtmlOutputLabel COMP_PIS_DT_LABEL) {
		this.COMP_PIS_DT_LABEL = COMP_PIS_DT_LABEL;
	}

	public void setCOMP_PIS_DT(HtmlCalendar COMP_PIS_DT) {
		this.COMP_PIS_DT = COMP_PIS_DT;
	}

	public HtmlOutputLabel getCOMP_PIS_FC_MOP_INVEST_AMT_LABEL() {
		return COMP_PIS_FC_MOP_INVEST_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FC_MOP_INVEST_AMT() {
		return COMP_PIS_FC_MOP_INVEST_AMT;
	}

	public void setCOMP_PIS_FC_MOP_INVEST_AMT_LABEL(
			HtmlOutputLabel COMP_PIS_FC_MOP_INVEST_AMT_LABEL) {
		this.COMP_PIS_FC_MOP_INVEST_AMT_LABEL = COMP_PIS_FC_MOP_INVEST_AMT_LABEL;
	}

	public void setCOMP_PIS_FC_MOP_INVEST_AMT(
			HtmlInputText COMP_PIS_FC_MOP_INVEST_AMT) {
		this.COMP_PIS_FC_MOP_INVEST_AMT = COMP_PIS_FC_MOP_INVEST_AMT;
	}

	public HtmlOutputLabel getCOMP_PIS_FC_OPBAL_LABEL() {
		return COMP_PIS_FC_OPBAL_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FC_OPBAL() {
		return COMP_PIS_FC_OPBAL;
	}

	public void setCOMP_PIS_FC_OPBAL_LABEL(
			HtmlOutputLabel COMP_PIS_FC_OPBAL_LABEL) {
		this.COMP_PIS_FC_OPBAL_LABEL = COMP_PIS_FC_OPBAL_LABEL;
	}

	public void setCOMP_PIS_FC_OPBAL(HtmlInputText COMP_PIS_FC_OPBAL) {
		this.COMP_PIS_FC_OPBAL = COMP_PIS_FC_OPBAL;
	}

	public HtmlOutputLabel getCOMP_PIS_FC_TOTAL_CONTR_LABEL() {
		return COMP_PIS_FC_TOTAL_CONTR_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FC_TOTAL_CONTR() {
		return COMP_PIS_FC_TOTAL_CONTR;
	}

	public void setCOMP_PIS_FC_TOTAL_CONTR_LABEL(
			HtmlOutputLabel COMP_PIS_FC_TOTAL_CONTR_LABEL) {
		this.COMP_PIS_FC_TOTAL_CONTR_LABEL = COMP_PIS_FC_TOTAL_CONTR_LABEL;
	}

	public void setCOMP_PIS_FC_TOTAL_CONTR(HtmlInputText COMP_PIS_FC_TOTAL_CONTR) {
		this.COMP_PIS_FC_TOTAL_CONTR = COMP_PIS_FC_TOTAL_CONTR;
	}

	public HtmlOutputLabel getCOMP_PIS_FC_TOTAL_INTEREST_LABEL() {
		return COMP_PIS_FC_TOTAL_INTEREST_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FC_TOTAL_INTEREST() {
		return COMP_PIS_FC_TOTAL_INTEREST;
	}

	public void setCOMP_PIS_FC_TOTAL_INTEREST_LABEL(
			HtmlOutputLabel COMP_PIS_FC_TOTAL_INTEREST_LABEL) {
		this.COMP_PIS_FC_TOTAL_INTEREST_LABEL = COMP_PIS_FC_TOTAL_INTEREST_LABEL;
	}

	public void setCOMP_PIS_FC_TOTAL_INTEREST(
			HtmlInputText COMP_PIS_FC_TOTAL_INTEREST) {
		this.COMP_PIS_FC_TOTAL_INTEREST = COMP_PIS_FC_TOTAL_INTEREST;
	}

	public HtmlOutputLabel getCOMP_PIS_FC_CLBAL_LABEL() {
		return COMP_PIS_FC_CLBAL_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FC_CLBAL() {
		return COMP_PIS_FC_CLBAL;
	}

	public void setCOMP_PIS_FC_CLBAL_LABEL(
			HtmlOutputLabel COMP_PIS_FC_CLBAL_LABEL) {
		this.COMP_PIS_FC_CLBAL_LABEL = COMP_PIS_FC_CLBAL_LABEL;
	}

	public void setCOMP_PIS_FC_CLBAL(HtmlInputText COMP_PIS_FC_CLBAL) {
		this.COMP_PIS_FC_CLBAL = COMP_PIS_FC_CLBAL;
	}

	public HtmlOutputLabel getCOMP_PIS_FC_CURR_SA_LABEL() {
		return COMP_PIS_FC_CURR_SA_LABEL;
	}

	public HtmlInputText getCOMP_PIS_FC_CURR_SA() {
		return COMP_PIS_FC_CURR_SA;
	}

	public void setCOMP_PIS_FC_CURR_SA_LABEL(
			HtmlOutputLabel COMP_PIS_FC_CURR_SA_LABEL) {
		this.COMP_PIS_FC_CURR_SA_LABEL = COMP_PIS_FC_CURR_SA_LABEL;
	}

	public void setCOMP_PIS_FC_CURR_SA(HtmlInputText COMP_PIS_FC_CURR_SA) {
		this.COMP_PIS_FC_CURR_SA = COMP_PIS_FC_CURR_SA;
	}

	public HtmlOutputLabel getCOMP_PIS_LC_MOP_INVEST_AMT_LABEL() {
		return COMP_PIS_LC_MOP_INVEST_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PIS_LC_MOP_INVEST_AMT() {
		return COMP_PIS_LC_MOP_INVEST_AMT;
	}

	public void setCOMP_PIS_LC_MOP_INVEST_AMT_LABEL(
			HtmlOutputLabel COMP_PIS_LC_MOP_INVEST_AMT_LABEL) {
		this.COMP_PIS_LC_MOP_INVEST_AMT_LABEL = COMP_PIS_LC_MOP_INVEST_AMT_LABEL;
	}

	public void setCOMP_PIS_LC_MOP_INVEST_AMT(
			HtmlInputText COMP_PIS_LC_MOP_INVEST_AMT) {
		this.COMP_PIS_LC_MOP_INVEST_AMT = COMP_PIS_LC_MOP_INVEST_AMT;
	}

	public HtmlOutputLabel getCOMP_PIS_LC_OPBAL_LABEL() {
		return COMP_PIS_LC_OPBAL_LABEL;
	}

	public HtmlInputText getCOMP_PIS_LC_OPBAL() {
		return COMP_PIS_LC_OPBAL;
	}

	public void setCOMP_PIS_LC_OPBAL_LABEL(
			HtmlOutputLabel COMP_PIS_LC_OPBAL_LABEL) {
		this.COMP_PIS_LC_OPBAL_LABEL = COMP_PIS_LC_OPBAL_LABEL;
	}

	public void setCOMP_PIS_LC_OPBAL(HtmlInputText COMP_PIS_LC_OPBAL) {
		this.COMP_PIS_LC_OPBAL = COMP_PIS_LC_OPBAL;
	}

	public HtmlOutputLabel getCOMP_PIS_LC_TOTAL_CONTR_LABEL() {
		return COMP_PIS_LC_TOTAL_CONTR_LABEL;
	}

	public HtmlInputText getCOMP_PIS_LC_TOTAL_CONTR() {
		return COMP_PIS_LC_TOTAL_CONTR;
	}

	public void setCOMP_PIS_LC_TOTAL_CONTR_LABEL(
			HtmlOutputLabel COMP_PIS_LC_TOTAL_CONTR_LABEL) {
		this.COMP_PIS_LC_TOTAL_CONTR_LABEL = COMP_PIS_LC_TOTAL_CONTR_LABEL;
	}

	public void setCOMP_PIS_LC_TOTAL_CONTR(HtmlInputText COMP_PIS_LC_TOTAL_CONTR) {
		this.COMP_PIS_LC_TOTAL_CONTR = COMP_PIS_LC_TOTAL_CONTR;
	}

	public HtmlOutputLabel getCOMP_PIS_LC_TOTAL_INTEREST_LABEL() {
		return COMP_PIS_LC_TOTAL_INTEREST_LABEL;
	}

	public HtmlInputText getCOMP_PIS_LC_TOTAL_INTEREST() {
		return COMP_PIS_LC_TOTAL_INTEREST;
	}

	public void setCOMP_PIS_LC_TOTAL_INTEREST_LABEL(
			HtmlOutputLabel COMP_PIS_LC_TOTAL_INTEREST_LABEL) {
		this.COMP_PIS_LC_TOTAL_INTEREST_LABEL = COMP_PIS_LC_TOTAL_INTEREST_LABEL;
	}

	public void setCOMP_PIS_LC_TOTAL_INTEREST(
			HtmlInputText COMP_PIS_LC_TOTAL_INTEREST) {
		this.COMP_PIS_LC_TOTAL_INTEREST = COMP_PIS_LC_TOTAL_INTEREST;
	}

	public HtmlOutputLabel getCOMP_PIS_LC_CLBAL_LABEL() {
		return COMP_PIS_LC_CLBAL_LABEL;
	}

	public HtmlInputText getCOMP_PIS_LC_CLBAL() {
		return COMP_PIS_LC_CLBAL;
	}

	public void setCOMP_PIS_LC_CLBAL_LABEL(
			HtmlOutputLabel COMP_PIS_LC_CLBAL_LABEL) {
		this.COMP_PIS_LC_CLBAL_LABEL = COMP_PIS_LC_CLBAL_LABEL;
	}

	public void setCOMP_PIS_LC_CLBAL(HtmlInputText COMP_PIS_LC_CLBAL) {
		this.COMP_PIS_LC_CLBAL = COMP_PIS_LC_CLBAL;
	}

	public HtmlOutputLabel getCOMP_PIS_LC_CURR_SA_LABEL() {
		return COMP_PIS_LC_CURR_SA_LABEL;
	}

	public HtmlInputText getCOMP_PIS_LC_CURR_SA() {
		return COMP_PIS_LC_CURR_SA;
	}

	public void setCOMP_PIS_LC_CURR_SA_LABEL(
			HtmlOutputLabel COMP_PIS_LC_CURR_SA_LABEL) {
		this.COMP_PIS_LC_CURR_SA_LABEL = COMP_PIS_LC_CURR_SA_LABEL;
	}

	public void setCOMP_PIS_LC_CURR_SA(HtmlInputText COMP_PIS_LC_CURR_SA) {
		this.COMP_PIS_LC_CURR_SA = COMP_PIS_LC_CURR_SA;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN_2() {
		return COMP_UI_M_BUT_MAIN_2;
	}

	public void setCOMP_UI_M_BUT_MAIN_2(HtmlCommandButton COMP_UI_M_BUT_MAIN_2) {
		this.COMP_UI_M_BUT_MAIN_2 = COMP_UI_M_BUT_MAIN_2;
	}

	public PS_IL_POL_INVEST_SUMMARY getPS_IL_POL_INVEST_SUMMARY_BEAN() {
		return PS_IL_POL_INVEST_SUMMARY_BEAN;
	}

	public void setPS_IL_POL_INVEST_SUMMARY_BEAN(
			PS_IL_POL_INVEST_SUMMARY PS_IL_POL_INVEST_SUMMARY_BEAN) {
		this.PS_IL_POL_INVEST_SUMMARY_BEAN = PS_IL_POL_INVEST_SUMMARY_BEAN;
	}

	public List<PS_IL_POL_INVEST_SUMMARY> getDataList_PS_IL_POL_INVEST_SUMMARY() {
		return dataList_PS_IL_POL_INVEST_SUMMARY;
	}

	public void setDataListPS_IL_POL_INVEST_SUMMARY(
			List<PS_IL_POL_INVEST_SUMMARY> dataList_PS_IL_POL_INVEST_SUMMARY) {
		this.dataList_PS_IL_POL_INVEST_SUMMARY = dataList_PS_IL_POL_INVEST_SUMMARY;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PS_IL_POL_INVEST_SUMMARY_BEAN = new PS_IL_POL_INVEST_SUMMARY();
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

				new PS_IL_POL_INVEST_SUMMARY_HELPER().preDelete();
				new CRUDHandler().executeDelete(PS_IL_POL_INVEST_SUMMARY_BEAN,
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
				dataList_PS_IL_POL_INVEST_SUMMARY
						.remove(PS_IL_POL_INVEST_SUMMARY_BEAN);
				if (dataList_PS_IL_POL_INVEST_SUMMARY.size() > 0) {

					PS_IL_POL_INVEST_SUMMARY_BEAN = dataList_PS_IL_POL_INVEST_SUMMARY
							.get(0);
				} else if (dataList_PS_IL_POL_INVEST_SUMMARY.size() == 0) {

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
			if (PS_IL_POL_INVEST_SUMMARY_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {

				new PS_IL_POL_INVEST_SUMMARY_HELPER()
						.preInsert(PS_IL_POL_INVEST_SUMMARY_BEAN);
				new CRUDHandler().executeInsert(PS_IL_POL_INVEST_SUMMARY_BEAN,
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
				dataList_PS_IL_POL_INVEST_SUMMARY
						.add(PS_IL_POL_INVEST_SUMMARY_BEAN);
			} else if (PS_IL_POL_INVEST_SUMMARY_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {

				new PS_IL_POL_INVEST_SUMMARY_HELPER()
						.preUpdate(PS_IL_POL_INVEST_SUMMARY_BEAN);
				new CRUDHandler().executeUpdate(PS_IL_POL_INVEST_SUMMARY_BEAN,
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

	public void onLoad(PhaseEvent event) throws Exception {
		try {
			if (isFormFlag()) {
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				helper.executeQuery(compositeAction);
				if (PS_IL_POL_INVEST_SUMMARY_BEAN.getROWID() != null) {
				} else {
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	private void resetAllComponent() {
		COMP_PIS_FLEX_11.resetValue();
		COMP_PIS_FLEX_28.resetValue();
		COMP_PIS_FLEX_27.resetValue();
		COMP_PIS_FLEX_26.resetValue();
		COMP_PIS_FLEX_25.resetValue();
		COMP_PIS_FLEX_24.resetValue();
		COMP_PIS_FLEX_30.resetValue();
		COMP_PIS_FLEX_01.resetValue();
		COMP_PIS_FLEX_02.resetValue();
		COMP_PIS_FLEX_03.resetValue();
		COMP_PIS_FLEX_04.resetValue();
		COMP_PIS_FLEX_05.resetValue();
		COMP_PIS_FLEX_06.resetValue();
		COMP_PIS_FLEX_07.resetValue();
		COMP_PIS_FLEX_08.resetValue();
		COMP_PIS_FLEX_09.resetValue();
		COMP_PIS_FLEX_10.resetValue();
		COMP_PIS_FLEX_29.resetValue();
		COMP_PIS_FLEX_12.resetValue();
		COMP_PIS_FLEX_13.resetValue();
		COMP_PIS_FLEX_14.resetValue();
		COMP_PIS_FLEX_15.resetValue();
		COMP_PIS_FLEX_16.resetValue();
		COMP_PIS_FLEX_17.resetValue();
		COMP_PIS_FLEX_18.resetValue();
		COMP_PIS_FLEX_19.resetValue();
		COMP_PIS_FLEX_20.resetValue();
		COMP_PIS_FLEX_21.resetValue();
		COMP_PIS_FLEX_22.resetValue();
		COMP_PIS_FLEX_23.resetValue();
		COMP_PIS_SR_NO.resetValue();
		COMP_PIS_DT.resetValue();
		COMP_PIS_FC_MOP_INVEST_AMT.resetValue();
		COMP_PIS_FC_OPBAL.resetValue();
		COMP_PIS_FC_TOTAL_CONTR.resetValue();
		COMP_PIS_FC_TOTAL_INTEREST.resetValue();
		COMP_PIS_FC_CLBAL.resetValue();
		COMP_PIS_FC_CURR_SA.resetValue();
		COMP_PIS_LC_MOP_INVEST_AMT.resetValue();
		COMP_PIS_LC_OPBAL.resetValue();
		COMP_PIS_LC_TOTAL_CONTR.resetValue();
		COMP_PIS_LC_TOTAL_INTEREST.resetValue();
		COMP_PIS_LC_CLBAL.resetValue();
		COMP_PIS_LC_CURR_SA.resetValue();
		// COMP_UI_M_BUT_MAIN_2.resetValue();
	}

	public PILT024_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT024_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public String mainButAction() {
		String outCome = null;
		outCome = "PILT024_PT_IL_POLICY";
		return outCome;
	}
	/*Added by Ameen on 17-05-2017 as per Gaurav sugg.*/ 
	public void getDetails() {
		try {
			resetSelectedRow();
			PS_IL_POL_INVEST_SUMMARY_BEAN = (PS_IL_POL_INVEST_SUMMARY) dataTable.getRowData();
			resetAllComponent();
			PS_IL_POL_INVEST_SUMMARY_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void resetSelectedRow() {
		Iterator<PS_IL_POL_INVEST_SUMMARY> PS_IL_POL_INVEST_SUMMARY_ITR = dataList_PS_IL_POL_INVEST_SUMMARY.iterator();
		while (PS_IL_POL_INVEST_SUMMARY_ITR.hasNext()) {
			PS_IL_POL_INVEST_SUMMARY_ITR.next().setRowSelected(false);
		}
	}
	private void initializeAllComponent() {
		COMP_PIS_FLEX_11 = new HtmlInputText();
		COMP_PIS_FLEX_28 = new HtmlInputText();
		COMP_PIS_FLEX_27 = new HtmlInputText();
		COMP_PIS_FLEX_26 = new HtmlInputText();
		COMP_PIS_FLEX_25 = new HtmlInputText();
		COMP_PIS_FLEX_24 = new HtmlInputText();
		COMP_PIS_FLEX_30 = new HtmlInputText();
		COMP_PIS_FLEX_01 = new HtmlInputText();
		COMP_PIS_FLEX_02 = new HtmlInputText();
		COMP_PIS_FLEX_03 = new HtmlCalendar();
		COMP_PIS_FLEX_04 = new HtmlCalendar();
		COMP_PIS_FLEX_05 = new HtmlInputText();
		COMP_PIS_FLEX_06 = new HtmlInputText();
		COMP_PIS_FLEX_07 = new HtmlInputText();
		COMP_PIS_FLEX_08 = new HtmlInputText();
		COMP_PIS_FLEX_09 = new HtmlInputText();
		COMP_PIS_FLEX_10 = new HtmlInputText();
		COMP_PIS_FLEX_29 = new HtmlInputText();
		COMP_PIS_FLEX_12 = new HtmlInputText();
		COMP_PIS_FLEX_13 = new HtmlInputText();
		COMP_PIS_FLEX_14 = new HtmlInputText();
		COMP_PIS_FLEX_15 = new HtmlInputText();
		COMP_PIS_FLEX_16 = new HtmlInputText();
		COMP_PIS_FLEX_17 = new HtmlInputText();
		COMP_PIS_FLEX_18 = new HtmlInputText();
		COMP_PIS_FLEX_19 = new HtmlInputText();
		COMP_PIS_FLEX_20 = new HtmlInputText();
		COMP_PIS_FLEX_21 = new HtmlInputText();
		COMP_PIS_FLEX_22 = new HtmlInputText();
		COMP_PIS_FLEX_23 = new HtmlInputText();
		COMP_PIS_SR_NO = new HtmlInputText();
		COMP_PIS_DT = new HtmlCalendar();
		COMP_PIS_FC_MOP_INVEST_AMT = new HtmlInputText();
		COMP_PIS_FC_OPBAL = new HtmlInputText();
		COMP_PIS_FC_TOTAL_CONTR = new HtmlInputText();
		COMP_PIS_FC_TOTAL_INTEREST = new HtmlInputText();
		COMP_PIS_FC_CLBAL = new HtmlInputText();
		COMP_PIS_FC_CURR_SA = new HtmlInputText();
		COMP_PIS_LC_MOP_INVEST_AMT = new HtmlInputText();
		COMP_PIS_LC_OPBAL = new HtmlInputText();
		COMP_PIS_LC_TOTAL_CONTR = new HtmlInputText();
		COMP_PIS_LC_TOTAL_INTEREST = new HtmlInputText();
		COMP_PIS_LC_CLBAL = new HtmlInputText();
		COMP_PIS_LC_CURR_SA = new HtmlInputText();
	}
	
	/*End*/
}