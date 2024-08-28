package com.iii.pel.forms.PILT024;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import org.richfaces.component.html.HtmlInputText;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_BROKER_VALUES_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_BV_FLEX_30_LABEL;

	private HtmlInputText COMP_BV_FLEX_30;

	private HtmlOutputLabel COMP_BV_FLEX_27_LABEL;

	private HtmlInputText COMP_BV_FLEX_27;

	private HtmlOutputLabel COMP_BV_FLEX_28_LABEL;

	private HtmlInputText COMP_BV_FLEX_28;

	private HtmlOutputLabel COMP_BV_FLEX_29_LABEL;

	private HtmlInputText COMP_BV_FLEX_29;

	private HtmlOutputLabel COMP_BV_FLEX_01_LABEL;

	private HtmlInputText COMP_BV_FLEX_01;

	private HtmlOutputLabel COMP_BV_FLEX_02_LABEL;

	private HtmlInputText COMP_BV_FLEX_02;

	private HtmlOutputLabel COMP_BV_FLEX_03_LABEL;

	private HtmlInputText COMP_BV_FLEX_03;

	private HtmlOutputLabel COMP_BV_FLEX_04_LABEL;

	private HtmlInputText COMP_BV_FLEX_04;

	private HtmlOutputLabel COMP_BV_FLEX_05_LABEL;

	private HtmlInputText COMP_BV_FLEX_05;

	private HtmlOutputLabel COMP_BV_FLEX_06_LABEL;

	private HtmlInputText COMP_BV_FLEX_06;

	private HtmlOutputLabel COMP_BV_FLEX_07_LABEL;

	private HtmlInputText COMP_BV_FLEX_07;

	private HtmlOutputLabel COMP_BV_FLEX_08_LABEL;

	private HtmlInputText COMP_BV_FLEX_08;

	private HtmlOutputLabel COMP_BV_FLEX_09_LABEL;

	private HtmlInputText COMP_BV_FLEX_09;

	private HtmlOutputLabel COMP_BV_FLEX_10_LABEL;

	private HtmlInputText COMP_BV_FLEX_10;

	private HtmlOutputLabel COMP_BV_FLEX_11_LABEL;

	private HtmlInputText COMP_BV_FLEX_11;

	private HtmlOutputLabel COMP_BV_FLEX_12_LABEL;

	private HtmlInputText COMP_BV_FLEX_12;

	private HtmlOutputLabel COMP_BV_FLEX_13_LABEL;

	private HtmlInputText COMP_BV_FLEX_13;

	private HtmlOutputLabel COMP_BV_FLEX_14_LABEL;

	private HtmlInputText COMP_BV_FLEX_14;

	private HtmlOutputLabel COMP_BV_FLEX_15_LABEL;

	private HtmlInputText COMP_BV_FLEX_15;

	private HtmlOutputLabel COMP_BV_FLEX_16_LABEL;

	private HtmlInputText COMP_BV_FLEX_16;

	private HtmlOutputLabel COMP_BV_FLEX_17_LABEL;

	private HtmlInputText COMP_BV_FLEX_17;

	private HtmlOutputLabel COMP_BV_FLEX_18_LABEL;

	private HtmlInputText COMP_BV_FLEX_18;

	private HtmlOutputLabel COMP_BV_FLEX_19_LABEL;

	private HtmlInputText COMP_BV_FLEX_19;

	private HtmlOutputLabel COMP_BV_FLEX_20_LABEL;

	private HtmlInputText COMP_BV_FLEX_20;

	private HtmlOutputLabel COMP_BV_FLEX_21_LABEL;

	private HtmlInputText COMP_BV_FLEX_21;

	private HtmlOutputLabel COMP_BV_FLEX_22_LABEL;

	private HtmlInputText COMP_BV_FLEX_22;

	private HtmlOutputLabel COMP_BV_FLEX_23_LABEL;

	private HtmlInputText COMP_BV_FLEX_23;

	private HtmlOutputLabel COMP_BV_FLEX_24_LABEL;

	private HtmlInputText COMP_BV_FLEX_24;

	private HtmlOutputLabel COMP_BV_FLEX_25_LABEL;

	private HtmlInputText COMP_BV_FLEX_25;

	private HtmlOutputLabel COMP_BV_FLEX_26_LABEL;

	private HtmlInputText COMP_BV_FLEX_26;

	private HtmlOutputLabel COMP_BV_BROKER_CODE_LABEL;

	private HtmlInputText COMP_BV_BROKER_CODE;

	private HtmlOutputLabel COMP_BV_COVER_CODE_LABEL;

	private HtmlInputText COMP_BV_COVER_CODE;

	private HtmlOutputLabel COMP_BV_COMM_CODE_LABEL;

	private HtmlInputText COMP_BV_COMM_CODE;

	private HtmlOutputLabel COMP_BV_YEAR_LABEL;

	private HtmlInputText COMP_BV_YEAR;

	private HtmlOutputLabel COMP_BV_RATE_LABEL;

	private HtmlInputText COMP_BV_RATE;

	private HtmlOutputLabel COMP_BV_RATE_PER_LABEL;

	private HtmlInputText COMP_BV_RATE_PER;

	private HtmlOutputLabel COMP_BV_FC_VALUE_LABEL;

	private HtmlInputText COMP_BV_FC_VALUE;

	private HtmlOutputLabel COMP_UI_M_BROKER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_BROKER_DESC;

	private HtmlOutputLabel COMP_UI_M_COVER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_COVER_DESC;

	private HtmlOutputLabel COMP_BV_LC_VALUE_LABEL;

	private HtmlInputText COMP_BV_LC_VALUE;

	private HtmlOutputLabel COMP_BV_TOT_FC_DED_LABEL;

	private HtmlInputText COMP_BV_TOT_FC_DED;

	private HtmlOutputLabel COMP_BV_TOT_LC_DED_LABEL;

	private HtmlInputText COMP_BV_TOT_LC_DED;

	private HtmlOutputLabel COMP_BV_NET_FC_VALUE_LABEL;

	private HtmlInputText COMP_BV_NET_FC_VALUE;

	private HtmlOutputLabel COMP_BV_NET_LC_VALUE_LABEL;

	private HtmlInputText COMP_BV_NET_LC_VALUE;

	private HtmlCommandButton COMP_UI_M_BUT_BDV_DEDC;

	private HtmlCommandButton COMP_UI_M_BUT_PREM_COLL;

	private PT_IL_BROKER_VALUES PT_IL_BROKER_VALUES_BEAN;

	public PILT024_COMPOSITE_ACTION compositeAction;
	
	private UIData dataTable;

	private PT_IL_BROKER_VALUES_HELPER helper;

	private List<PT_IL_BROKER_VALUES> dataList_PT_IL_BROKER_VALUES = new ArrayList<PT_IL_BROKER_VALUES>();

	public PT_IL_BROKER_VALUES_ACTION() {

		PT_IL_BROKER_VALUES_BEAN = new PT_IL_BROKER_VALUES();
		helper = new PT_IL_BROKER_VALUES_HELPER();
	}

	public void onLoad(PhaseEvent event) throws Exception {
		try {
			if (isFormFlag()) {
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				// helper.executeQuery(compositeAction);
				if (PT_IL_BROKER_VALUES_BEAN.getROWID() != null) {
				} else {
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_30_LABEL() {
		return COMP_BV_FLEX_30_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_30() {
		return COMP_BV_FLEX_30;
	}

	public void setCOMP_BV_FLEX_30_LABEL(HtmlOutputLabel COMP_BV_FLEX_30_LABEL) {
		this.COMP_BV_FLEX_30_LABEL = COMP_BV_FLEX_30_LABEL;
	}

	public void setCOMP_BV_FLEX_30(HtmlInputText COMP_BV_FLEX_30) {
		this.COMP_BV_FLEX_30 = COMP_BV_FLEX_30;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_27_LABEL() {
		return COMP_BV_FLEX_27_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_27() {
		return COMP_BV_FLEX_27;
	}

	public void setCOMP_BV_FLEX_27_LABEL(HtmlOutputLabel COMP_BV_FLEX_27_LABEL) {
		this.COMP_BV_FLEX_27_LABEL = COMP_BV_FLEX_27_LABEL;
	}

	public void setCOMP_BV_FLEX_27(HtmlInputText COMP_BV_FLEX_27) {
		this.COMP_BV_FLEX_27 = COMP_BV_FLEX_27;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_28_LABEL() {
		return COMP_BV_FLEX_28_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_28() {
		return COMP_BV_FLEX_28;
	}

	public void setCOMP_BV_FLEX_28_LABEL(HtmlOutputLabel COMP_BV_FLEX_28_LABEL) {
		this.COMP_BV_FLEX_28_LABEL = COMP_BV_FLEX_28_LABEL;
	}

	public void setCOMP_BV_FLEX_28(HtmlInputText COMP_BV_FLEX_28) {
		this.COMP_BV_FLEX_28 = COMP_BV_FLEX_28;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_29_LABEL() {
		return COMP_BV_FLEX_29_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_29() {
		return COMP_BV_FLEX_29;
	}

	public void setCOMP_BV_FLEX_29_LABEL(HtmlOutputLabel COMP_BV_FLEX_29_LABEL) {
		this.COMP_BV_FLEX_29_LABEL = COMP_BV_FLEX_29_LABEL;
	}

	public void setCOMP_BV_FLEX_29(HtmlInputText COMP_BV_FLEX_29) {
		this.COMP_BV_FLEX_29 = COMP_BV_FLEX_29;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_01_LABEL() {
		return COMP_BV_FLEX_01_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_01() {
		return COMP_BV_FLEX_01;
	}

	public void setCOMP_BV_FLEX_01_LABEL(HtmlOutputLabel COMP_BV_FLEX_01_LABEL) {
		this.COMP_BV_FLEX_01_LABEL = COMP_BV_FLEX_01_LABEL;
	}

	public void setCOMP_BV_FLEX_01(HtmlInputText COMP_BV_FLEX_01) {
		this.COMP_BV_FLEX_01 = COMP_BV_FLEX_01;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_02_LABEL() {
		return COMP_BV_FLEX_02_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_02() {
		return COMP_BV_FLEX_02;
	}

	public void setCOMP_BV_FLEX_02_LABEL(HtmlOutputLabel COMP_BV_FLEX_02_LABEL) {
		this.COMP_BV_FLEX_02_LABEL = COMP_BV_FLEX_02_LABEL;
	}

	public void setCOMP_BV_FLEX_02(HtmlInputText COMP_BV_FLEX_02) {
		this.COMP_BV_FLEX_02 = COMP_BV_FLEX_02;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_03_LABEL() {
		return COMP_BV_FLEX_03_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_03() {
		return COMP_BV_FLEX_03;
	}

	public void setCOMP_BV_FLEX_03_LABEL(HtmlOutputLabel COMP_BV_FLEX_03_LABEL) {
		this.COMP_BV_FLEX_03_LABEL = COMP_BV_FLEX_03_LABEL;
	}

	public void setCOMP_BV_FLEX_03(HtmlInputText COMP_BV_FLEX_03) {
		this.COMP_BV_FLEX_03 = COMP_BV_FLEX_03;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_04_LABEL() {
		return COMP_BV_FLEX_04_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_04() {
		return COMP_BV_FLEX_04;
	}

	public void setCOMP_BV_FLEX_04_LABEL(HtmlOutputLabel COMP_BV_FLEX_04_LABEL) {
		this.COMP_BV_FLEX_04_LABEL = COMP_BV_FLEX_04_LABEL;
	}

	public void setCOMP_BV_FLEX_04(HtmlInputText COMP_BV_FLEX_04) {
		this.COMP_BV_FLEX_04 = COMP_BV_FLEX_04;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_05_LABEL() {
		return COMP_BV_FLEX_05_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_05() {
		return COMP_BV_FLEX_05;
	}

	public void setCOMP_BV_FLEX_05_LABEL(HtmlOutputLabel COMP_BV_FLEX_05_LABEL) {
		this.COMP_BV_FLEX_05_LABEL = COMP_BV_FLEX_05_LABEL;
	}

	public void setCOMP_BV_FLEX_05(HtmlInputText COMP_BV_FLEX_05) {
		this.COMP_BV_FLEX_05 = COMP_BV_FLEX_05;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_06_LABEL() {
		return COMP_BV_FLEX_06_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_06() {
		return COMP_BV_FLEX_06;
	}

	public void setCOMP_BV_FLEX_06_LABEL(HtmlOutputLabel COMP_BV_FLEX_06_LABEL) {
		this.COMP_BV_FLEX_06_LABEL = COMP_BV_FLEX_06_LABEL;
	}

	public void setCOMP_BV_FLEX_06(HtmlInputText COMP_BV_FLEX_06) {
		this.COMP_BV_FLEX_06 = COMP_BV_FLEX_06;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_07_LABEL() {
		return COMP_BV_FLEX_07_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_07() {
		return COMP_BV_FLEX_07;
	}

	public void setCOMP_BV_FLEX_07_LABEL(HtmlOutputLabel COMP_BV_FLEX_07_LABEL) {
		this.COMP_BV_FLEX_07_LABEL = COMP_BV_FLEX_07_LABEL;
	}

	public void setCOMP_BV_FLEX_07(HtmlInputText COMP_BV_FLEX_07) {
		this.COMP_BV_FLEX_07 = COMP_BV_FLEX_07;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_08_LABEL() {
		return COMP_BV_FLEX_08_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_08() {
		return COMP_BV_FLEX_08;
	}

	public void setCOMP_BV_FLEX_08_LABEL(HtmlOutputLabel COMP_BV_FLEX_08_LABEL) {
		this.COMP_BV_FLEX_08_LABEL = COMP_BV_FLEX_08_LABEL;
	}

	public void setCOMP_BV_FLEX_08(HtmlInputText COMP_BV_FLEX_08) {
		this.COMP_BV_FLEX_08 = COMP_BV_FLEX_08;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_09_LABEL() {
		return COMP_BV_FLEX_09_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_09() {
		return COMP_BV_FLEX_09;
	}

	public void setCOMP_BV_FLEX_09_LABEL(HtmlOutputLabel COMP_BV_FLEX_09_LABEL) {
		this.COMP_BV_FLEX_09_LABEL = COMP_BV_FLEX_09_LABEL;
	}

	public void setCOMP_BV_FLEX_09(HtmlInputText COMP_BV_FLEX_09) {
		this.COMP_BV_FLEX_09 = COMP_BV_FLEX_09;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_10_LABEL() {
		return COMP_BV_FLEX_10_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_10() {
		return COMP_BV_FLEX_10;
	}

	public void setCOMP_BV_FLEX_10_LABEL(HtmlOutputLabel COMP_BV_FLEX_10_LABEL) {
		this.COMP_BV_FLEX_10_LABEL = COMP_BV_FLEX_10_LABEL;
	}

	public void setCOMP_BV_FLEX_10(HtmlInputText COMP_BV_FLEX_10) {
		this.COMP_BV_FLEX_10 = COMP_BV_FLEX_10;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_11_LABEL() {
		return COMP_BV_FLEX_11_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_11() {
		return COMP_BV_FLEX_11;
	}

	public void setCOMP_BV_FLEX_11_LABEL(HtmlOutputLabel COMP_BV_FLEX_11_LABEL) {
		this.COMP_BV_FLEX_11_LABEL = COMP_BV_FLEX_11_LABEL;
	}

	public void setCOMP_BV_FLEX_11(HtmlInputText COMP_BV_FLEX_11) {
		this.COMP_BV_FLEX_11 = COMP_BV_FLEX_11;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_12_LABEL() {
		return COMP_BV_FLEX_12_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_12() {
		return COMP_BV_FLEX_12;
	}

	public void setCOMP_BV_FLEX_12_LABEL(HtmlOutputLabel COMP_BV_FLEX_12_LABEL) {
		this.COMP_BV_FLEX_12_LABEL = COMP_BV_FLEX_12_LABEL;
	}

	public void setCOMP_BV_FLEX_12(HtmlInputText COMP_BV_FLEX_12) {
		this.COMP_BV_FLEX_12 = COMP_BV_FLEX_12;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_13_LABEL() {
		return COMP_BV_FLEX_13_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_13() {
		return COMP_BV_FLEX_13;
	}

	public void setCOMP_BV_FLEX_13_LABEL(HtmlOutputLabel COMP_BV_FLEX_13_LABEL) {
		this.COMP_BV_FLEX_13_LABEL = COMP_BV_FLEX_13_LABEL;
	}

	public void setCOMP_BV_FLEX_13(HtmlInputText COMP_BV_FLEX_13) {
		this.COMP_BV_FLEX_13 = COMP_BV_FLEX_13;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_14_LABEL() {
		return COMP_BV_FLEX_14_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_14() {
		return COMP_BV_FLEX_14;
	}

	public void setCOMP_BV_FLEX_14_LABEL(HtmlOutputLabel COMP_BV_FLEX_14_LABEL) {
		this.COMP_BV_FLEX_14_LABEL = COMP_BV_FLEX_14_LABEL;
	}

	public void setCOMP_BV_FLEX_14(HtmlInputText COMP_BV_FLEX_14) {
		this.COMP_BV_FLEX_14 = COMP_BV_FLEX_14;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_15_LABEL() {
		return COMP_BV_FLEX_15_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_15() {
		return COMP_BV_FLEX_15;
	}

	public void setCOMP_BV_FLEX_15_LABEL(HtmlOutputLabel COMP_BV_FLEX_15_LABEL) {
		this.COMP_BV_FLEX_15_LABEL = COMP_BV_FLEX_15_LABEL;
	}

	public void setCOMP_BV_FLEX_15(HtmlInputText COMP_BV_FLEX_15) {
		this.COMP_BV_FLEX_15 = COMP_BV_FLEX_15;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_16_LABEL() {
		return COMP_BV_FLEX_16_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_16() {
		return COMP_BV_FLEX_16;
	}

	public void setCOMP_BV_FLEX_16_LABEL(HtmlOutputLabel COMP_BV_FLEX_16_LABEL) {
		this.COMP_BV_FLEX_16_LABEL = COMP_BV_FLEX_16_LABEL;
	}

	public void setCOMP_BV_FLEX_16(HtmlInputText COMP_BV_FLEX_16) {
		this.COMP_BV_FLEX_16 = COMP_BV_FLEX_16;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_17_LABEL() {
		return COMP_BV_FLEX_17_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_17() {
		return COMP_BV_FLEX_17;
	}

	public void setCOMP_BV_FLEX_17_LABEL(HtmlOutputLabel COMP_BV_FLEX_17_LABEL) {
		this.COMP_BV_FLEX_17_LABEL = COMP_BV_FLEX_17_LABEL;
	}

	public void setCOMP_BV_FLEX_17(HtmlInputText COMP_BV_FLEX_17) {
		this.COMP_BV_FLEX_17 = COMP_BV_FLEX_17;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_18_LABEL() {
		return COMP_BV_FLEX_18_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_18() {
		return COMP_BV_FLEX_18;
	}

	public void setCOMP_BV_FLEX_18_LABEL(HtmlOutputLabel COMP_BV_FLEX_18_LABEL) {
		this.COMP_BV_FLEX_18_LABEL = COMP_BV_FLEX_18_LABEL;
	}

	public void setCOMP_BV_FLEX_18(HtmlInputText COMP_BV_FLEX_18) {
		this.COMP_BV_FLEX_18 = COMP_BV_FLEX_18;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_19_LABEL() {
		return COMP_BV_FLEX_19_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_19() {
		return COMP_BV_FLEX_19;
	}

	public void setCOMP_BV_FLEX_19_LABEL(HtmlOutputLabel COMP_BV_FLEX_19_LABEL) {
		this.COMP_BV_FLEX_19_LABEL = COMP_BV_FLEX_19_LABEL;
	}

	public void setCOMP_BV_FLEX_19(HtmlInputText COMP_BV_FLEX_19) {
		this.COMP_BV_FLEX_19 = COMP_BV_FLEX_19;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_20_LABEL() {
		return COMP_BV_FLEX_20_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_20() {
		return COMP_BV_FLEX_20;
	}

	public void setCOMP_BV_FLEX_20_LABEL(HtmlOutputLabel COMP_BV_FLEX_20_LABEL) {
		this.COMP_BV_FLEX_20_LABEL = COMP_BV_FLEX_20_LABEL;
	}

	public void setCOMP_BV_FLEX_20(HtmlInputText COMP_BV_FLEX_20) {
		this.COMP_BV_FLEX_20 = COMP_BV_FLEX_20;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_21_LABEL() {
		return COMP_BV_FLEX_21_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_21() {
		return COMP_BV_FLEX_21;
	}

	public void setCOMP_BV_FLEX_21_LABEL(HtmlOutputLabel COMP_BV_FLEX_21_LABEL) {
		this.COMP_BV_FLEX_21_LABEL = COMP_BV_FLEX_21_LABEL;
	}

	public void setCOMP_BV_FLEX_21(HtmlInputText COMP_BV_FLEX_21) {
		this.COMP_BV_FLEX_21 = COMP_BV_FLEX_21;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_22_LABEL() {
		return COMP_BV_FLEX_22_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_22() {
		return COMP_BV_FLEX_22;
	}

	public void setCOMP_BV_FLEX_22_LABEL(HtmlOutputLabel COMP_BV_FLEX_22_LABEL) {
		this.COMP_BV_FLEX_22_LABEL = COMP_BV_FLEX_22_LABEL;
	}

	public void setCOMP_BV_FLEX_22(HtmlInputText COMP_BV_FLEX_22) {
		this.COMP_BV_FLEX_22 = COMP_BV_FLEX_22;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_23_LABEL() {
		return COMP_BV_FLEX_23_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_23() {
		return COMP_BV_FLEX_23;
	}

	public void setCOMP_BV_FLEX_23_LABEL(HtmlOutputLabel COMP_BV_FLEX_23_LABEL) {
		this.COMP_BV_FLEX_23_LABEL = COMP_BV_FLEX_23_LABEL;
	}

	public void setCOMP_BV_FLEX_23(HtmlInputText COMP_BV_FLEX_23) {
		this.COMP_BV_FLEX_23 = COMP_BV_FLEX_23;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_24_LABEL() {
		return COMP_BV_FLEX_24_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_24() {
		return COMP_BV_FLEX_24;
	}

	public void setCOMP_BV_FLEX_24_LABEL(HtmlOutputLabel COMP_BV_FLEX_24_LABEL) {
		this.COMP_BV_FLEX_24_LABEL = COMP_BV_FLEX_24_LABEL;
	}

	public void setCOMP_BV_FLEX_24(HtmlInputText COMP_BV_FLEX_24) {
		this.COMP_BV_FLEX_24 = COMP_BV_FLEX_24;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_25_LABEL() {
		return COMP_BV_FLEX_25_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_25() {
		return COMP_BV_FLEX_25;
	}

	public void setCOMP_BV_FLEX_25_LABEL(HtmlOutputLabel COMP_BV_FLEX_25_LABEL) {
		this.COMP_BV_FLEX_25_LABEL = COMP_BV_FLEX_25_LABEL;
	}

	public void setCOMP_BV_FLEX_25(HtmlInputText COMP_BV_FLEX_25) {
		this.COMP_BV_FLEX_25 = COMP_BV_FLEX_25;
	}

	public HtmlOutputLabel getCOMP_BV_FLEX_26_LABEL() {
		return COMP_BV_FLEX_26_LABEL;
	}

	public HtmlInputText getCOMP_BV_FLEX_26() {
		return COMP_BV_FLEX_26;
	}

	public void setCOMP_BV_FLEX_26_LABEL(HtmlOutputLabel COMP_BV_FLEX_26_LABEL) {
		this.COMP_BV_FLEX_26_LABEL = COMP_BV_FLEX_26_LABEL;
	}

	public void setCOMP_BV_FLEX_26(HtmlInputText COMP_BV_FLEX_26) {
		this.COMP_BV_FLEX_26 = COMP_BV_FLEX_26;
	}

	public HtmlOutputLabel getCOMP_BV_BROKER_CODE_LABEL() {
		return COMP_BV_BROKER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BV_BROKER_CODE() {
		return COMP_BV_BROKER_CODE;
	}

	public void setCOMP_BV_BROKER_CODE_LABEL(
			HtmlOutputLabel COMP_BV_BROKER_CODE_LABEL) {
		this.COMP_BV_BROKER_CODE_LABEL = COMP_BV_BROKER_CODE_LABEL;
	}

	public void setCOMP_BV_BROKER_CODE(HtmlInputText COMP_BV_BROKER_CODE) {
		this.COMP_BV_BROKER_CODE = COMP_BV_BROKER_CODE;
	}

	public HtmlOutputLabel getCOMP_BV_COVER_CODE_LABEL() {
		return COMP_BV_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BV_COVER_CODE() {
		return COMP_BV_COVER_CODE;
	}

	public void setCOMP_BV_COVER_CODE_LABEL(
			HtmlOutputLabel COMP_BV_COVER_CODE_LABEL) {
		this.COMP_BV_COVER_CODE_LABEL = COMP_BV_COVER_CODE_LABEL;
	}

	public void setCOMP_BV_COVER_CODE(HtmlInputText COMP_BV_COVER_CODE) {
		this.COMP_BV_COVER_CODE = COMP_BV_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_BV_COMM_CODE_LABEL() {
		return COMP_BV_COMM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_BV_COMM_CODE() {
		return COMP_BV_COMM_CODE;
	}

	public void setCOMP_BV_COMM_CODE_LABEL(
			HtmlOutputLabel COMP_BV_COMM_CODE_LABEL) {
		this.COMP_BV_COMM_CODE_LABEL = COMP_BV_COMM_CODE_LABEL;
	}

	public void setCOMP_BV_COMM_CODE(HtmlInputText COMP_BV_COMM_CODE) {
		this.COMP_BV_COMM_CODE = COMP_BV_COMM_CODE;
	}

	public HtmlOutputLabel getCOMP_BV_YEAR_LABEL() {
		return COMP_BV_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_BV_YEAR() {
		return COMP_BV_YEAR;
	}

	public void setCOMP_BV_YEAR_LABEL(HtmlOutputLabel COMP_BV_YEAR_LABEL) {
		this.COMP_BV_YEAR_LABEL = COMP_BV_YEAR_LABEL;
	}

	public void setCOMP_BV_YEAR(HtmlInputText COMP_BV_YEAR) {
		this.COMP_BV_YEAR = COMP_BV_YEAR;
	}

	public HtmlOutputLabel getCOMP_BV_RATE_LABEL() {
		return COMP_BV_RATE_LABEL;
	}

	public HtmlInputText getCOMP_BV_RATE() {
		return COMP_BV_RATE;
	}

	public void setCOMP_BV_RATE_LABEL(HtmlOutputLabel COMP_BV_RATE_LABEL) {
		this.COMP_BV_RATE_LABEL = COMP_BV_RATE_LABEL;
	}

	public void setCOMP_BV_RATE(HtmlInputText COMP_BV_RATE) {
		this.COMP_BV_RATE = COMP_BV_RATE;
	}

	public HtmlOutputLabel getCOMP_BV_RATE_PER_LABEL() {
		return COMP_BV_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_BV_RATE_PER() {
		return COMP_BV_RATE_PER;
	}

	public void setCOMP_BV_RATE_PER_LABEL(HtmlOutputLabel COMP_BV_RATE_PER_LABEL) {
		this.COMP_BV_RATE_PER_LABEL = COMP_BV_RATE_PER_LABEL;
	}

	public void setCOMP_BV_RATE_PER(HtmlInputText COMP_BV_RATE_PER) {
		this.COMP_BV_RATE_PER = COMP_BV_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_BV_FC_VALUE_LABEL() {
		return COMP_BV_FC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_BV_FC_VALUE() {
		return COMP_BV_FC_VALUE;
	}

	public void setCOMP_BV_FC_VALUE_LABEL(HtmlOutputLabel COMP_BV_FC_VALUE_LABEL) {
		this.COMP_BV_FC_VALUE_LABEL = COMP_BV_FC_VALUE_LABEL;
	}

	public void setCOMP_BV_FC_VALUE(HtmlInputText COMP_BV_FC_VALUE) {
		this.COMP_BV_FC_VALUE = COMP_BV_FC_VALUE;
	}

	public HtmlOutputLabel getCOMP_UI_M_BROKER_DESC_LABEL() {
		return COMP_UI_M_BROKER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_BROKER_DESC() {
		return COMP_UI_M_BROKER_DESC;
	}

	public void setCOMP_UI_M_BROKER_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_BROKER_DESC_LABEL) {
		this.COMP_UI_M_BROKER_DESC_LABEL = COMP_UI_M_BROKER_DESC_LABEL;
	}

	public void setCOMP_UI_M_BROKER_DESC(HtmlInputText COMP_UI_M_BROKER_DESC) {
		this.COMP_UI_M_BROKER_DESC = COMP_UI_M_BROKER_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_COVER_DESC_LABEL() {
		return COMP_UI_M_COVER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_COVER_DESC() {
		return COMP_UI_M_COVER_DESC;
	}

	public void setCOMP_UI_M_COVER_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_COVER_DESC_LABEL) {
		this.COMP_UI_M_COVER_DESC_LABEL = COMP_UI_M_COVER_DESC_LABEL;
	}

	public void setCOMP_UI_M_COVER_DESC(HtmlInputText COMP_UI_M_COVER_DESC) {
		this.COMP_UI_M_COVER_DESC = COMP_UI_M_COVER_DESC;
	}

	public HtmlOutputLabel getCOMP_BV_LC_VALUE_LABEL() {
		return COMP_BV_LC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_BV_LC_VALUE() {
		return COMP_BV_LC_VALUE;
	}

	public void setCOMP_BV_LC_VALUE_LABEL(HtmlOutputLabel COMP_BV_LC_VALUE_LABEL) {
		this.COMP_BV_LC_VALUE_LABEL = COMP_BV_LC_VALUE_LABEL;
	}

	public void setCOMP_BV_LC_VALUE(HtmlInputText COMP_BV_LC_VALUE) {
		this.COMP_BV_LC_VALUE = COMP_BV_LC_VALUE;
	}

	public HtmlOutputLabel getCOMP_BV_TOT_FC_DED_LABEL() {
		return COMP_BV_TOT_FC_DED_LABEL;
	}

	public HtmlInputText getCOMP_BV_TOT_FC_DED() {
		return COMP_BV_TOT_FC_DED;
	}

	public void setCOMP_BV_TOT_FC_DED_LABEL(
			HtmlOutputLabel COMP_BV_TOT_FC_DED_LABEL) {
		this.COMP_BV_TOT_FC_DED_LABEL = COMP_BV_TOT_FC_DED_LABEL;
	}

	public void setCOMP_BV_TOT_FC_DED(HtmlInputText COMP_BV_TOT_FC_DED) {
		this.COMP_BV_TOT_FC_DED = COMP_BV_TOT_FC_DED;
	}

	public HtmlOutputLabel getCOMP_BV_TOT_LC_DED_LABEL() {
		return COMP_BV_TOT_LC_DED_LABEL;
	}

	public HtmlInputText getCOMP_BV_TOT_LC_DED() {
		return COMP_BV_TOT_LC_DED;
	}

	public void setCOMP_BV_TOT_LC_DED_LABEL(
			HtmlOutputLabel COMP_BV_TOT_LC_DED_LABEL) {
		this.COMP_BV_TOT_LC_DED_LABEL = COMP_BV_TOT_LC_DED_LABEL;
	}

	public void setCOMP_BV_TOT_LC_DED(HtmlInputText COMP_BV_TOT_LC_DED) {
		this.COMP_BV_TOT_LC_DED = COMP_BV_TOT_LC_DED;
	}

	public HtmlOutputLabel getCOMP_BV_NET_FC_VALUE_LABEL() {
		return COMP_BV_NET_FC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_BV_NET_FC_VALUE() {
		return COMP_BV_NET_FC_VALUE;
	}

	public void setCOMP_BV_NET_FC_VALUE_LABEL(
			HtmlOutputLabel COMP_BV_NET_FC_VALUE_LABEL) {
		this.COMP_BV_NET_FC_VALUE_LABEL = COMP_BV_NET_FC_VALUE_LABEL;
	}

	public void setCOMP_BV_NET_FC_VALUE(HtmlInputText COMP_BV_NET_FC_VALUE) {
		this.COMP_BV_NET_FC_VALUE = COMP_BV_NET_FC_VALUE;
	}

	public HtmlOutputLabel getCOMP_BV_NET_LC_VALUE_LABEL() {
		return COMP_BV_NET_LC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_BV_NET_LC_VALUE() {
		return COMP_BV_NET_LC_VALUE;
	}

	public void setCOMP_BV_NET_LC_VALUE_LABEL(
			HtmlOutputLabel COMP_BV_NET_LC_VALUE_LABEL) {
		this.COMP_BV_NET_LC_VALUE_LABEL = COMP_BV_NET_LC_VALUE_LABEL;
	}

	public void setCOMP_BV_NET_LC_VALUE(HtmlInputText COMP_BV_NET_LC_VALUE) {
		this.COMP_BV_NET_LC_VALUE = COMP_BV_NET_LC_VALUE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BDV_DEDC() {
		return COMP_UI_M_BUT_BDV_DEDC;
	}

	public void setCOMP_UI_M_BUT_BDV_DEDC(
			HtmlCommandButton COMP_UI_M_BUT_BDV_DEDC) {
		this.COMP_UI_M_BUT_BDV_DEDC = COMP_UI_M_BUT_BDV_DEDC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PREM_COLL() {
		return COMP_UI_M_BUT_PREM_COLL;
	}

	public void setCOMP_UI_M_BUT_PREM_COLL(
			HtmlCommandButton COMP_UI_M_BUT_PREM_COLL) {
		this.COMP_UI_M_BUT_PREM_COLL = COMP_UI_M_BUT_PREM_COLL;
	}

	public PT_IL_BROKER_VALUES getPT_IL_BROKER_VALUES_BEAN() {
		return PT_IL_BROKER_VALUES_BEAN;
	}

	public void setPT_IL_BROKER_VALUES_BEAN(
			PT_IL_BROKER_VALUES PT_IL_BROKER_VALUES_BEAN) {
		this.PT_IL_BROKER_VALUES_BEAN = PT_IL_BROKER_VALUES_BEAN;
	}

	public List<PT_IL_BROKER_VALUES> getDataList_PT_IL_BROKER_VALUES() {
		return dataList_PT_IL_BROKER_VALUES;
	}

	public void setDataListPT_IL_BROKER_VALUES(
			List<PT_IL_BROKER_VALUES> dataList_PT_IL_BROKER_VALUES) {
		this.dataList_PT_IL_BROKER_VALUES = dataList_PT_IL_BROKER_VALUES;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PT_IL_BROKER_VALUES_BEAN = new PT_IL_BROKER_VALUES();
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

				new CRUDHandler().executeDelete(PT_IL_BROKER_VALUES_BEAN,
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
				dataList_PT_IL_BROKER_VALUES.remove(PT_IL_BROKER_VALUES_BEAN);
				if (dataList_PT_IL_BROKER_VALUES.size() > 0) {

					PT_IL_BROKER_VALUES_BEAN = dataList_PT_IL_BROKER_VALUES
							.get(0);
				} else if (dataList_PT_IL_BROKER_VALUES.size() == 0) {

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
			if (PT_IL_BROKER_VALUES_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {

				new CRUDHandler().executeInsert(PT_IL_BROKER_VALUES_BEAN,
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
				dataList_PT_IL_BROKER_VALUES.add(PT_IL_BROKER_VALUES_BEAN);
			} else if (PT_IL_BROKER_VALUES_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {

				new CRUDHandler().executeUpdate(PT_IL_BROKER_VALUES_BEAN,
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
		COMP_BV_FLEX_30.resetValue();
		COMP_BV_FLEX_27.resetValue();
		COMP_BV_FLEX_28.resetValue();
		COMP_BV_FLEX_29.resetValue();
		COMP_BV_FLEX_01.resetValue();
		COMP_BV_FLEX_02.resetValue();
		COMP_BV_FLEX_03.resetValue();
		COMP_BV_FLEX_04.resetValue();
		COMP_BV_FLEX_05.resetValue();
		COMP_BV_FLEX_06.resetValue();
		COMP_BV_FLEX_07.resetValue();
		COMP_BV_FLEX_08.resetValue();
		COMP_BV_FLEX_09.resetValue();
		COMP_BV_FLEX_10.resetValue();
		COMP_BV_FLEX_11.resetValue();
		COMP_BV_FLEX_12.resetValue();
		COMP_BV_FLEX_13.resetValue();
		COMP_BV_FLEX_14.resetValue();
		COMP_BV_FLEX_15.resetValue();
		COMP_BV_FLEX_16.resetValue();
		COMP_BV_FLEX_17.resetValue();
		COMP_BV_FLEX_18.resetValue();
		COMP_BV_FLEX_19.resetValue();
		COMP_BV_FLEX_20.resetValue();
		COMP_BV_FLEX_21.resetValue();
		COMP_BV_FLEX_22.resetValue();
		COMP_BV_FLEX_23.resetValue();
		COMP_BV_FLEX_24.resetValue();
		COMP_BV_FLEX_25.resetValue();
		COMP_BV_FLEX_26.resetValue();
		COMP_BV_BROKER_CODE.resetValue();
		COMP_BV_COVER_CODE.resetValue();
		COMP_BV_COMM_CODE.resetValue();
		COMP_BV_YEAR.resetValue();
		COMP_BV_RATE.resetValue();
		COMP_BV_RATE_PER.resetValue();
		COMP_BV_FC_VALUE.resetValue();
		COMP_UI_M_BROKER_DESC.resetValue();
		COMP_UI_M_COVER_DESC.resetValue();
		COMP_BV_LC_VALUE.resetValue();
		COMP_BV_TOT_FC_DED.resetValue();
		COMP_BV_TOT_LC_DED.resetValue();
		COMP_BV_NET_FC_VALUE.resetValue();
		COMP_BV_NET_LC_VALUE.resetValue();
		// COMP_UI_M_BUT_BDV_DEDC.resetValue();
		// COMP_UI_M_BUT_PREM_COLL.resetValue();
	}

	public PILT024_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT024_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public void setDataList_PT_IL_BROKER_VALUES(
			List<PT_IL_BROKER_VALUES> dataList_PT_IL_BROKER_VALUES) {
		this.dataList_PT_IL_BROKER_VALUES = dataList_PT_IL_BROKER_VALUES;
	}
}