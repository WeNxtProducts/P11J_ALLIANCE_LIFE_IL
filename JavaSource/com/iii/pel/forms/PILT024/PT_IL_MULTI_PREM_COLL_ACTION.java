package com.iii.pel.forms.PILT024;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_MULTI_PREM_COLL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PMPC_FLEX_30_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_30;

	private HtmlOutputLabel COMP_PMPC_FLEX_27_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_27;

	private HtmlOutputLabel COMP_PMPC_FLEX_26_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_26;

	private HtmlOutputLabel COMP_PMPC_FLEX_25_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_25;

	private HtmlOutputLabel COMP_PMPC_FLEX_24_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_24;

	private HtmlOutputLabel COMP_PMPC_FLEX_28_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_28;

	private HtmlOutputLabel COMP_PMPC_FLEX_29_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_29;

	private HtmlOutputLabel COMP_PMPC_FLEX_01_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_01;

	private HtmlOutputLabel COMP_PMPC_FLEX_02_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_02;

	private HtmlOutputLabel COMP_PMPC_FLEX_03_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_03;

	private HtmlOutputLabel COMP_PMPC_FLEX_04_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_04;

	private HtmlOutputLabel COMP_PMPC_FLEX_05_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_05;

	private HtmlOutputLabel COMP_PMPC_FLEX_06_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_06;

	private HtmlOutputLabel COMP_PMPC_FLEX_07_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_07;

	private HtmlOutputLabel COMP_PMPC_FLEX_08_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_08;

	private HtmlOutputLabel COMP_PMPC_FLEX_09_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_09;

	private HtmlOutputLabel COMP_PMPC_FLEX_10_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_10;

	private HtmlOutputLabel COMP_PMPC_FLEX_11_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_11;

	private HtmlOutputLabel COMP_PMPC_FLEX_12_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_12;

	private HtmlOutputLabel COMP_PMPC_FLEX_13_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_13;

	private HtmlOutputLabel COMP_PMPC_FLEX_14_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_14;

	private HtmlOutputLabel COMP_PMPC_FLEX_15_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_15;

	private HtmlOutputLabel COMP_PMPC_FLEX_16_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_16;

	private HtmlOutputLabel COMP_PMPC_FLEX_17_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_17;

	private HtmlOutputLabel COMP_PMPC_FLEX_18_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_18;

	private HtmlOutputLabel COMP_PMPC_FLEX_19_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_19;

	private HtmlOutputLabel COMP_PMPC_FLEX_20_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_20;

	private HtmlOutputLabel COMP_PMPC_FLEX_21_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_21;

	private HtmlOutputLabel COMP_PMPC_FLEX_22_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_22;

	private HtmlOutputLabel COMP_PMPC_FLEX_23_LABEL;

	private HtmlInputText COMP_PMPC_FLEX_23;

	private HtmlOutputLabel COMP_PMPC_CHARGE_FC_AMT_LABEL;

	private HtmlInputText COMP_PMPC_CHARGE_FC_AMT;

	private HtmlOutputLabel COMP_PMPC_CHARGE_LC_AMT_LABEL;

	private HtmlInputText COMP_PMPC_CHARGE_LC_AMT;

	private HtmlOutputLabel COMP_PMPC_COLL_COUNT_LABEL;

	private HtmlInputText COMP_PMPC_COLL_COUNT;

	private HtmlOutputLabel COMP_PMPC_PAID_DT_LABEL;

	private HtmlCalendar COMP_PMPC_PAID_DT;

	private HtmlOutputLabel COMP_PMPC_APPRV_DT_LABEL;

	private HtmlCalendar COMP_PMPC_APPRV_DT;

	private HtmlOutputLabel COMP_PMPC_PAID_FLAG_LABEL;

	private HtmlInputText COMP_PMPC_PAID_FLAG;

	private HtmlOutputLabel COMP_PMPC_FC_PAID_AMT_LABEL;

	private HtmlInputText COMP_PMPC_FC_PAID_AMT;

	private HtmlOutputLabel COMP_PMPC_LC_PAID_AMT_LABEL;

	private HtmlInputText COMP_PMPC_LC_PAID_AMT;

	private HtmlOutputLabel COMP_PMPC_RISK_FC_AMT_LABEL;

	private HtmlInputText COMP_PMPC_RISK_FC_AMT;

	private HtmlOutputLabel COMP_PMPC_RISK_LC_AMT_LABEL;

	private HtmlInputText COMP_PMPC_RISK_LC_AMT;

	private HtmlOutputLabel COMP_UI_M_CHARGE_FC_AMT_LABEL;

	private HtmlInputText COMP_UI_M_CHARGE_FC_AMT;

	private HtmlOutputLabel COMP_UI_M_CHARGE_LC_AMT_LABEL;

	private HtmlInputText COMP_UI_M_CHARGE_LC_AMT;

	private HtmlOutputLabel COMP_PMPC_PREM_CONTRI_FC_AMT_LABEL;

	private HtmlInputText COMP_PMPC_PREM_CONTRI_FC_AMT;

	private HtmlOutputLabel COMP_PMPC_PREM_CONTRI_LC_AMT_LABEL;

	private HtmlInputText COMP_PMPC_PREM_CONTRI_LC_AMT;

	private HtmlOutputLabel COMP_PMPC_TOPUP_CONTRI_FC_AMT_LABEL;

	private HtmlInputText COMP_PMPC_TOPUP_CONTRI_FC_AMT;

	private HtmlOutputLabel COMP_PMPC_TOPUP_CONTRI_LC_AMT_LABEL;

	private HtmlInputText COMP_PMPC_TOPUP_CONTRI_LC_AMT;

	private PT_IL_MULTI_PREM_COLL PT_IL_MULTI_PREM_COLL_BEAN;

	public PILT024_COMPOSITE_ACTION compositeAction;

	private PT_IL_MULTI_PREM_COLL_HELPER helper;
	
	private UIData dataTable;

	private List<PT_IL_MULTI_PREM_COLL> dataList_PT_IL_MULTI_PREM_COLL = new ArrayList<PT_IL_MULTI_PREM_COLL>();

	public PT_IL_MULTI_PREM_COLL_ACTION() {

		PT_IL_MULTI_PREM_COLL_BEAN = new PT_IL_MULTI_PREM_COLL();
		helper = new PT_IL_MULTI_PREM_COLL_HELPER();
	}
	
	public void onLoad(PhaseEvent event) throws Exception {
		try {
			if (isFormFlag()) {
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				helper.executeQuery(compositeAction);
				if (PT_IL_MULTI_PREM_COLL_BEAN.getROWID() != null) {
				} else {
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_30_LABEL() {
		return COMP_PMPC_FLEX_30_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_30() {
		return COMP_PMPC_FLEX_30;
	}

	public void setCOMP_PMPC_FLEX_30_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_30_LABEL) {
		this.COMP_PMPC_FLEX_30_LABEL = COMP_PMPC_FLEX_30_LABEL;
	}

	public void setCOMP_PMPC_FLEX_30(HtmlInputText COMP_PMPC_FLEX_30) {
		this.COMP_PMPC_FLEX_30 = COMP_PMPC_FLEX_30;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_27_LABEL() {
		return COMP_PMPC_FLEX_27_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_27() {
		return COMP_PMPC_FLEX_27;
	}

	public void setCOMP_PMPC_FLEX_27_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_27_LABEL) {
		this.COMP_PMPC_FLEX_27_LABEL = COMP_PMPC_FLEX_27_LABEL;
	}

	public void setCOMP_PMPC_FLEX_27(HtmlInputText COMP_PMPC_FLEX_27) {
		this.COMP_PMPC_FLEX_27 = COMP_PMPC_FLEX_27;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_26_LABEL() {
		return COMP_PMPC_FLEX_26_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_26() {
		return COMP_PMPC_FLEX_26;
	}

	public void setCOMP_PMPC_FLEX_26_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_26_LABEL) {
		this.COMP_PMPC_FLEX_26_LABEL = COMP_PMPC_FLEX_26_LABEL;
	}

	public void setCOMP_PMPC_FLEX_26(HtmlInputText COMP_PMPC_FLEX_26) {
		this.COMP_PMPC_FLEX_26 = COMP_PMPC_FLEX_26;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_25_LABEL() {
		return COMP_PMPC_FLEX_25_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_25() {
		return COMP_PMPC_FLEX_25;
	}

	public void setCOMP_PMPC_FLEX_25_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_25_LABEL) {
		this.COMP_PMPC_FLEX_25_LABEL = COMP_PMPC_FLEX_25_LABEL;
	}

	public void setCOMP_PMPC_FLEX_25(HtmlInputText COMP_PMPC_FLEX_25) {
		this.COMP_PMPC_FLEX_25 = COMP_PMPC_FLEX_25;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_24_LABEL() {
		return COMP_PMPC_FLEX_24_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_24() {
		return COMP_PMPC_FLEX_24;
	}

	public void setCOMP_PMPC_FLEX_24_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_24_LABEL) {
		this.COMP_PMPC_FLEX_24_LABEL = COMP_PMPC_FLEX_24_LABEL;
	}

	public void setCOMP_PMPC_FLEX_24(HtmlInputText COMP_PMPC_FLEX_24) {
		this.COMP_PMPC_FLEX_24 = COMP_PMPC_FLEX_24;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_28_LABEL() {
		return COMP_PMPC_FLEX_28_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_28() {
		return COMP_PMPC_FLEX_28;
	}

	public void setCOMP_PMPC_FLEX_28_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_28_LABEL) {
		this.COMP_PMPC_FLEX_28_LABEL = COMP_PMPC_FLEX_28_LABEL;
	}

	public void setCOMP_PMPC_FLEX_28(HtmlInputText COMP_PMPC_FLEX_28) {
		this.COMP_PMPC_FLEX_28 = COMP_PMPC_FLEX_28;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_29_LABEL() {
		return COMP_PMPC_FLEX_29_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_29() {
		return COMP_PMPC_FLEX_29;
	}

	public void setCOMP_PMPC_FLEX_29_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_29_LABEL) {
		this.COMP_PMPC_FLEX_29_LABEL = COMP_PMPC_FLEX_29_LABEL;
	}

	public void setCOMP_PMPC_FLEX_29(HtmlInputText COMP_PMPC_FLEX_29) {
		this.COMP_PMPC_FLEX_29 = COMP_PMPC_FLEX_29;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_01_LABEL() {
		return COMP_PMPC_FLEX_01_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_01() {
		return COMP_PMPC_FLEX_01;
	}

	public void setCOMP_PMPC_FLEX_01_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_01_LABEL) {
		this.COMP_PMPC_FLEX_01_LABEL = COMP_PMPC_FLEX_01_LABEL;
	}

	public void setCOMP_PMPC_FLEX_01(HtmlInputText COMP_PMPC_FLEX_01) {
		this.COMP_PMPC_FLEX_01 = COMP_PMPC_FLEX_01;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_02_LABEL() {
		return COMP_PMPC_FLEX_02_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_02() {
		return COMP_PMPC_FLEX_02;
	}

	public void setCOMP_PMPC_FLEX_02_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_02_LABEL) {
		this.COMP_PMPC_FLEX_02_LABEL = COMP_PMPC_FLEX_02_LABEL;
	}

	public void setCOMP_PMPC_FLEX_02(HtmlInputText COMP_PMPC_FLEX_02) {
		this.COMP_PMPC_FLEX_02 = COMP_PMPC_FLEX_02;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_03_LABEL() {
		return COMP_PMPC_FLEX_03_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_03() {
		return COMP_PMPC_FLEX_03;
	}

	public void setCOMP_PMPC_FLEX_03_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_03_LABEL) {
		this.COMP_PMPC_FLEX_03_LABEL = COMP_PMPC_FLEX_03_LABEL;
	}

	public void setCOMP_PMPC_FLEX_03(HtmlInputText COMP_PMPC_FLEX_03) {
		this.COMP_PMPC_FLEX_03 = COMP_PMPC_FLEX_03;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_04_LABEL() {
		return COMP_PMPC_FLEX_04_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_04() {
		return COMP_PMPC_FLEX_04;
	}

	public void setCOMP_PMPC_FLEX_04_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_04_LABEL) {
		this.COMP_PMPC_FLEX_04_LABEL = COMP_PMPC_FLEX_04_LABEL;
	}

	public void setCOMP_PMPC_FLEX_04(HtmlInputText COMP_PMPC_FLEX_04) {
		this.COMP_PMPC_FLEX_04 = COMP_PMPC_FLEX_04;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_05_LABEL() {
		return COMP_PMPC_FLEX_05_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_05() {
		return COMP_PMPC_FLEX_05;
	}

	public void setCOMP_PMPC_FLEX_05_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_05_LABEL) {
		this.COMP_PMPC_FLEX_05_LABEL = COMP_PMPC_FLEX_05_LABEL;
	}

	public void setCOMP_PMPC_FLEX_05(HtmlInputText COMP_PMPC_FLEX_05) {
		this.COMP_PMPC_FLEX_05 = COMP_PMPC_FLEX_05;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_06_LABEL() {
		return COMP_PMPC_FLEX_06_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_06() {
		return COMP_PMPC_FLEX_06;
	}

	public void setCOMP_PMPC_FLEX_06_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_06_LABEL) {
		this.COMP_PMPC_FLEX_06_LABEL = COMP_PMPC_FLEX_06_LABEL;
	}

	public void setCOMP_PMPC_FLEX_06(HtmlInputText COMP_PMPC_FLEX_06) {
		this.COMP_PMPC_FLEX_06 = COMP_PMPC_FLEX_06;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_07_LABEL() {
		return COMP_PMPC_FLEX_07_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_07() {
		return COMP_PMPC_FLEX_07;
	}

	public void setCOMP_PMPC_FLEX_07_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_07_LABEL) {
		this.COMP_PMPC_FLEX_07_LABEL = COMP_PMPC_FLEX_07_LABEL;
	}

	public void setCOMP_PMPC_FLEX_07(HtmlInputText COMP_PMPC_FLEX_07) {
		this.COMP_PMPC_FLEX_07 = COMP_PMPC_FLEX_07;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_08_LABEL() {
		return COMP_PMPC_FLEX_08_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_08() {
		return COMP_PMPC_FLEX_08;
	}

	public void setCOMP_PMPC_FLEX_08_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_08_LABEL) {
		this.COMP_PMPC_FLEX_08_LABEL = COMP_PMPC_FLEX_08_LABEL;
	}

	public void setCOMP_PMPC_FLEX_08(HtmlInputText COMP_PMPC_FLEX_08) {
		this.COMP_PMPC_FLEX_08 = COMP_PMPC_FLEX_08;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_09_LABEL() {
		return COMP_PMPC_FLEX_09_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_09() {
		return COMP_PMPC_FLEX_09;
	}

	public void setCOMP_PMPC_FLEX_09_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_09_LABEL) {
		this.COMP_PMPC_FLEX_09_LABEL = COMP_PMPC_FLEX_09_LABEL;
	}

	public void setCOMP_PMPC_FLEX_09(HtmlInputText COMP_PMPC_FLEX_09) {
		this.COMP_PMPC_FLEX_09 = COMP_PMPC_FLEX_09;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_10_LABEL() {
		return COMP_PMPC_FLEX_10_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_10() {
		return COMP_PMPC_FLEX_10;
	}

	public void setCOMP_PMPC_FLEX_10_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_10_LABEL) {
		this.COMP_PMPC_FLEX_10_LABEL = COMP_PMPC_FLEX_10_LABEL;
	}

	public void setCOMP_PMPC_FLEX_10(HtmlInputText COMP_PMPC_FLEX_10) {
		this.COMP_PMPC_FLEX_10 = COMP_PMPC_FLEX_10;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_11_LABEL() {
		return COMP_PMPC_FLEX_11_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_11() {
		return COMP_PMPC_FLEX_11;
	}

	public void setCOMP_PMPC_FLEX_11_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_11_LABEL) {
		this.COMP_PMPC_FLEX_11_LABEL = COMP_PMPC_FLEX_11_LABEL;
	}

	public void setCOMP_PMPC_FLEX_11(HtmlInputText COMP_PMPC_FLEX_11) {
		this.COMP_PMPC_FLEX_11 = COMP_PMPC_FLEX_11;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_12_LABEL() {
		return COMP_PMPC_FLEX_12_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_12() {
		return COMP_PMPC_FLEX_12;
	}

	public void setCOMP_PMPC_FLEX_12_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_12_LABEL) {
		this.COMP_PMPC_FLEX_12_LABEL = COMP_PMPC_FLEX_12_LABEL;
	}

	public void setCOMP_PMPC_FLEX_12(HtmlInputText COMP_PMPC_FLEX_12) {
		this.COMP_PMPC_FLEX_12 = COMP_PMPC_FLEX_12;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_13_LABEL() {
		return COMP_PMPC_FLEX_13_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_13() {
		return COMP_PMPC_FLEX_13;
	}

	public void setCOMP_PMPC_FLEX_13_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_13_LABEL) {
		this.COMP_PMPC_FLEX_13_LABEL = COMP_PMPC_FLEX_13_LABEL;
	}

	public void setCOMP_PMPC_FLEX_13(HtmlInputText COMP_PMPC_FLEX_13) {
		this.COMP_PMPC_FLEX_13 = COMP_PMPC_FLEX_13;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_14_LABEL() {
		return COMP_PMPC_FLEX_14_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_14() {
		return COMP_PMPC_FLEX_14;
	}

	public void setCOMP_PMPC_FLEX_14_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_14_LABEL) {
		this.COMP_PMPC_FLEX_14_LABEL = COMP_PMPC_FLEX_14_LABEL;
	}

	public void setCOMP_PMPC_FLEX_14(HtmlInputText COMP_PMPC_FLEX_14) {
		this.COMP_PMPC_FLEX_14 = COMP_PMPC_FLEX_14;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_15_LABEL() {
		return COMP_PMPC_FLEX_15_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_15() {
		return COMP_PMPC_FLEX_15;
	}

	public void setCOMP_PMPC_FLEX_15_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_15_LABEL) {
		this.COMP_PMPC_FLEX_15_LABEL = COMP_PMPC_FLEX_15_LABEL;
	}

	public void setCOMP_PMPC_FLEX_15(HtmlInputText COMP_PMPC_FLEX_15) {
		this.COMP_PMPC_FLEX_15 = COMP_PMPC_FLEX_15;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_16_LABEL() {
		return COMP_PMPC_FLEX_16_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_16() {
		return COMP_PMPC_FLEX_16;
	}

	public void setCOMP_PMPC_FLEX_16_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_16_LABEL) {
		this.COMP_PMPC_FLEX_16_LABEL = COMP_PMPC_FLEX_16_LABEL;
	}

	public void setCOMP_PMPC_FLEX_16(HtmlInputText COMP_PMPC_FLEX_16) {
		this.COMP_PMPC_FLEX_16 = COMP_PMPC_FLEX_16;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_17_LABEL() {
		return COMP_PMPC_FLEX_17_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_17() {
		return COMP_PMPC_FLEX_17;
	}

	public void setCOMP_PMPC_FLEX_17_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_17_LABEL) {
		this.COMP_PMPC_FLEX_17_LABEL = COMP_PMPC_FLEX_17_LABEL;
	}

	public void setCOMP_PMPC_FLEX_17(HtmlInputText COMP_PMPC_FLEX_17) {
		this.COMP_PMPC_FLEX_17 = COMP_PMPC_FLEX_17;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_18_LABEL() {
		return COMP_PMPC_FLEX_18_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_18() {
		return COMP_PMPC_FLEX_18;
	}

	public void setCOMP_PMPC_FLEX_18_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_18_LABEL) {
		this.COMP_PMPC_FLEX_18_LABEL = COMP_PMPC_FLEX_18_LABEL;
	}

	public void setCOMP_PMPC_FLEX_18(HtmlInputText COMP_PMPC_FLEX_18) {
		this.COMP_PMPC_FLEX_18 = COMP_PMPC_FLEX_18;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_19_LABEL() {
		return COMP_PMPC_FLEX_19_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_19() {
		return COMP_PMPC_FLEX_19;
	}

	public void setCOMP_PMPC_FLEX_19_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_19_LABEL) {
		this.COMP_PMPC_FLEX_19_LABEL = COMP_PMPC_FLEX_19_LABEL;
	}

	public void setCOMP_PMPC_FLEX_19(HtmlInputText COMP_PMPC_FLEX_19) {
		this.COMP_PMPC_FLEX_19 = COMP_PMPC_FLEX_19;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_20_LABEL() {
		return COMP_PMPC_FLEX_20_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_20() {
		return COMP_PMPC_FLEX_20;
	}

	public void setCOMP_PMPC_FLEX_20_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_20_LABEL) {
		this.COMP_PMPC_FLEX_20_LABEL = COMP_PMPC_FLEX_20_LABEL;
	}

	public void setCOMP_PMPC_FLEX_20(HtmlInputText COMP_PMPC_FLEX_20) {
		this.COMP_PMPC_FLEX_20 = COMP_PMPC_FLEX_20;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_21_LABEL() {
		return COMP_PMPC_FLEX_21_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_21() {
		return COMP_PMPC_FLEX_21;
	}

	public void setCOMP_PMPC_FLEX_21_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_21_LABEL) {
		this.COMP_PMPC_FLEX_21_LABEL = COMP_PMPC_FLEX_21_LABEL;
	}

	public void setCOMP_PMPC_FLEX_21(HtmlInputText COMP_PMPC_FLEX_21) {
		this.COMP_PMPC_FLEX_21 = COMP_PMPC_FLEX_21;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_22_LABEL() {
		return COMP_PMPC_FLEX_22_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_22() {
		return COMP_PMPC_FLEX_22;
	}

	public void setCOMP_PMPC_FLEX_22_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_22_LABEL) {
		this.COMP_PMPC_FLEX_22_LABEL = COMP_PMPC_FLEX_22_LABEL;
	}

	public void setCOMP_PMPC_FLEX_22(HtmlInputText COMP_PMPC_FLEX_22) {
		this.COMP_PMPC_FLEX_22 = COMP_PMPC_FLEX_22;
	}

	public HtmlOutputLabel getCOMP_PMPC_FLEX_23_LABEL() {
		return COMP_PMPC_FLEX_23_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FLEX_23() {
		return COMP_PMPC_FLEX_23;
	}

	public void setCOMP_PMPC_FLEX_23_LABEL(
			HtmlOutputLabel COMP_PMPC_FLEX_23_LABEL) {
		this.COMP_PMPC_FLEX_23_LABEL = COMP_PMPC_FLEX_23_LABEL;
	}

	public void setCOMP_PMPC_FLEX_23(HtmlInputText COMP_PMPC_FLEX_23) {
		this.COMP_PMPC_FLEX_23 = COMP_PMPC_FLEX_23;
	}

	public HtmlOutputLabel getCOMP_PMPC_CHARGE_FC_AMT_LABEL() {
		return COMP_PMPC_CHARGE_FC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_CHARGE_FC_AMT() {
		return COMP_PMPC_CHARGE_FC_AMT;
	}

	public void setCOMP_PMPC_CHARGE_FC_AMT_LABEL(
			HtmlOutputLabel COMP_PMPC_CHARGE_FC_AMT_LABEL) {
		this.COMP_PMPC_CHARGE_FC_AMT_LABEL = COMP_PMPC_CHARGE_FC_AMT_LABEL;
	}

	public void setCOMP_PMPC_CHARGE_FC_AMT(HtmlInputText COMP_PMPC_CHARGE_FC_AMT) {
		this.COMP_PMPC_CHARGE_FC_AMT = COMP_PMPC_CHARGE_FC_AMT;
	}

	public HtmlOutputLabel getCOMP_PMPC_CHARGE_LC_AMT_LABEL() {
		return COMP_PMPC_CHARGE_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_CHARGE_LC_AMT() {
		return COMP_PMPC_CHARGE_LC_AMT;
	}

	public void setCOMP_PMPC_CHARGE_LC_AMT_LABEL(
			HtmlOutputLabel COMP_PMPC_CHARGE_LC_AMT_LABEL) {
		this.COMP_PMPC_CHARGE_LC_AMT_LABEL = COMP_PMPC_CHARGE_LC_AMT_LABEL;
	}

	public void setCOMP_PMPC_CHARGE_LC_AMT(HtmlInputText COMP_PMPC_CHARGE_LC_AMT) {
		this.COMP_PMPC_CHARGE_LC_AMT = COMP_PMPC_CHARGE_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_PMPC_COLL_COUNT_LABEL() {
		return COMP_PMPC_COLL_COUNT_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_COLL_COUNT() {
		return COMP_PMPC_COLL_COUNT;
	}

	public void setCOMP_PMPC_COLL_COUNT_LABEL(
			HtmlOutputLabel COMP_PMPC_COLL_COUNT_LABEL) {
		this.COMP_PMPC_COLL_COUNT_LABEL = COMP_PMPC_COLL_COUNT_LABEL;
	}

	public void setCOMP_PMPC_COLL_COUNT(HtmlInputText COMP_PMPC_COLL_COUNT) {
		this.COMP_PMPC_COLL_COUNT = COMP_PMPC_COLL_COUNT;
	}

	public HtmlOutputLabel getCOMP_PMPC_PAID_DT_LABEL() {
		return COMP_PMPC_PAID_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PMPC_PAID_DT() {
		return COMP_PMPC_PAID_DT;
	}

	public void setCOMP_PMPC_PAID_DT_LABEL(
			HtmlOutputLabel COMP_PMPC_PAID_DT_LABEL) {
		this.COMP_PMPC_PAID_DT_LABEL = COMP_PMPC_PAID_DT_LABEL;
	}

	public void setCOMP_PMPC_PAID_DT(HtmlCalendar COMP_PMPC_PAID_DT) {
		this.COMP_PMPC_PAID_DT = COMP_PMPC_PAID_DT;
	}

	public HtmlOutputLabel getCOMP_PMPC_APPRV_DT_LABEL() {
		return COMP_PMPC_APPRV_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PMPC_APPRV_DT() {
		return COMP_PMPC_APPRV_DT;
	}

	public void setCOMP_PMPC_APPRV_DT_LABEL(
			HtmlOutputLabel COMP_PMPC_APPRV_DT_LABEL) {
		this.COMP_PMPC_APPRV_DT_LABEL = COMP_PMPC_APPRV_DT_LABEL;
	}

	public void setCOMP_PMPC_APPRV_DT(HtmlCalendar COMP_PMPC_APPRV_DT) {
		this.COMP_PMPC_APPRV_DT = COMP_PMPC_APPRV_DT;
	}

	public HtmlOutputLabel getCOMP_PMPC_PAID_FLAG_LABEL() {
		return COMP_PMPC_PAID_FLAG_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_PAID_FLAG() {
		return COMP_PMPC_PAID_FLAG;
	}

	public void setCOMP_PMPC_PAID_FLAG_LABEL(
			HtmlOutputLabel COMP_PMPC_PAID_FLAG_LABEL) {
		this.COMP_PMPC_PAID_FLAG_LABEL = COMP_PMPC_PAID_FLAG_LABEL;
	}

	public void setCOMP_PMPC_PAID_FLAG(HtmlInputText COMP_PMPC_PAID_FLAG) {
		this.COMP_PMPC_PAID_FLAG = COMP_PMPC_PAID_FLAG;
	}

	public HtmlOutputLabel getCOMP_PMPC_FC_PAID_AMT_LABEL() {
		return COMP_PMPC_FC_PAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_FC_PAID_AMT() {
		return COMP_PMPC_FC_PAID_AMT;
	}

	public void setCOMP_PMPC_FC_PAID_AMT_LABEL(
			HtmlOutputLabel COMP_PMPC_FC_PAID_AMT_LABEL) {
		this.COMP_PMPC_FC_PAID_AMT_LABEL = COMP_PMPC_FC_PAID_AMT_LABEL;
	}

	public void setCOMP_PMPC_FC_PAID_AMT(HtmlInputText COMP_PMPC_FC_PAID_AMT) {
		this.COMP_PMPC_FC_PAID_AMT = COMP_PMPC_FC_PAID_AMT;
	}

	public HtmlOutputLabel getCOMP_PMPC_LC_PAID_AMT_LABEL() {
		return COMP_PMPC_LC_PAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_LC_PAID_AMT() {
		return COMP_PMPC_LC_PAID_AMT;
	}

	public void setCOMP_PMPC_LC_PAID_AMT_LABEL(
			HtmlOutputLabel COMP_PMPC_LC_PAID_AMT_LABEL) {
		this.COMP_PMPC_LC_PAID_AMT_LABEL = COMP_PMPC_LC_PAID_AMT_LABEL;
	}

	public void setCOMP_PMPC_LC_PAID_AMT(HtmlInputText COMP_PMPC_LC_PAID_AMT) {
		this.COMP_PMPC_LC_PAID_AMT = COMP_PMPC_LC_PAID_AMT;
	}

	public HtmlOutputLabel getCOMP_PMPC_RISK_FC_AMT_LABEL() {
		return COMP_PMPC_RISK_FC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_RISK_FC_AMT() {
		return COMP_PMPC_RISK_FC_AMT;
	}

	public void setCOMP_PMPC_RISK_FC_AMT_LABEL(
			HtmlOutputLabel COMP_PMPC_RISK_FC_AMT_LABEL) {
		this.COMP_PMPC_RISK_FC_AMT_LABEL = COMP_PMPC_RISK_FC_AMT_LABEL;
	}

	public void setCOMP_PMPC_RISK_FC_AMT(HtmlInputText COMP_PMPC_RISK_FC_AMT) {
		this.COMP_PMPC_RISK_FC_AMT = COMP_PMPC_RISK_FC_AMT;
	}

	public HtmlOutputLabel getCOMP_PMPC_RISK_LC_AMT_LABEL() {
		return COMP_PMPC_RISK_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_RISK_LC_AMT() {
		return COMP_PMPC_RISK_LC_AMT;
	}

	public void setCOMP_PMPC_RISK_LC_AMT_LABEL(
			HtmlOutputLabel COMP_PMPC_RISK_LC_AMT_LABEL) {
		this.COMP_PMPC_RISK_LC_AMT_LABEL = COMP_PMPC_RISK_LC_AMT_LABEL;
	}

	public void setCOMP_PMPC_RISK_LC_AMT(HtmlInputText COMP_PMPC_RISK_LC_AMT) {
		this.COMP_PMPC_RISK_LC_AMT = COMP_PMPC_RISK_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_CHARGE_FC_AMT_LABEL() {
		return COMP_UI_M_CHARGE_FC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CHARGE_FC_AMT() {
		return COMP_UI_M_CHARGE_FC_AMT;
	}

	public void setCOMP_UI_M_CHARGE_FC_AMT_LABEL(
			HtmlOutputLabel COMP_UI_M_CHARGE_FC_AMT_LABEL) {
		this.COMP_UI_M_CHARGE_FC_AMT_LABEL = COMP_UI_M_CHARGE_FC_AMT_LABEL;
	}

	public void setCOMP_UI_M_CHARGE_FC_AMT(HtmlInputText COMP_UI_M_CHARGE_FC_AMT) {
		this.COMP_UI_M_CHARGE_FC_AMT = COMP_UI_M_CHARGE_FC_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_CHARGE_LC_AMT_LABEL() {
		return COMP_UI_M_CHARGE_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CHARGE_LC_AMT() {
		return COMP_UI_M_CHARGE_LC_AMT;
	}

	public void setCOMP_UI_M_CHARGE_LC_AMT_LABEL(
			HtmlOutputLabel COMP_UI_M_CHARGE_LC_AMT_LABEL) {
		this.COMP_UI_M_CHARGE_LC_AMT_LABEL = COMP_UI_M_CHARGE_LC_AMT_LABEL;
	}

	public void setCOMP_UI_M_CHARGE_LC_AMT(HtmlInputText COMP_UI_M_CHARGE_LC_AMT) {
		this.COMP_UI_M_CHARGE_LC_AMT = COMP_UI_M_CHARGE_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_PMPC_PREM_CONTRI_FC_AMT_LABEL() {
		return COMP_PMPC_PREM_CONTRI_FC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_PREM_CONTRI_FC_AMT() {
		return COMP_PMPC_PREM_CONTRI_FC_AMT;
	}

	public void setCOMP_PMPC_PREM_CONTRI_FC_AMT_LABEL(
			HtmlOutputLabel COMP_PMPC_PREM_CONTRI_FC_AMT_LABEL) {
		this.COMP_PMPC_PREM_CONTRI_FC_AMT_LABEL = COMP_PMPC_PREM_CONTRI_FC_AMT_LABEL;
	}

	public void setCOMP_PMPC_PREM_CONTRI_FC_AMT(
			HtmlInputText COMP_PMPC_PREM_CONTRI_FC_AMT) {
		this.COMP_PMPC_PREM_CONTRI_FC_AMT = COMP_PMPC_PREM_CONTRI_FC_AMT;
	}

	public HtmlOutputLabel getCOMP_PMPC_PREM_CONTRI_LC_AMT_LABEL() {
		return COMP_PMPC_PREM_CONTRI_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_PREM_CONTRI_LC_AMT() {
		return COMP_PMPC_PREM_CONTRI_LC_AMT;
	}

	public void setCOMP_PMPC_PREM_CONTRI_LC_AMT_LABEL(
			HtmlOutputLabel COMP_PMPC_PREM_CONTRI_LC_AMT_LABEL) {
		this.COMP_PMPC_PREM_CONTRI_LC_AMT_LABEL = COMP_PMPC_PREM_CONTRI_LC_AMT_LABEL;
	}

	public void setCOMP_PMPC_PREM_CONTRI_LC_AMT(
			HtmlInputText COMP_PMPC_PREM_CONTRI_LC_AMT) {
		this.COMP_PMPC_PREM_CONTRI_LC_AMT = COMP_PMPC_PREM_CONTRI_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_PMPC_TOPUP_CONTRI_FC_AMT_LABEL() {
		return COMP_PMPC_TOPUP_CONTRI_FC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_TOPUP_CONTRI_FC_AMT() {
		return COMP_PMPC_TOPUP_CONTRI_FC_AMT;
	}

	public void setCOMP_PMPC_TOPUP_CONTRI_FC_AMT_LABEL(
			HtmlOutputLabel COMP_PMPC_TOPUP_CONTRI_FC_AMT_LABEL) {
		this.COMP_PMPC_TOPUP_CONTRI_FC_AMT_LABEL = COMP_PMPC_TOPUP_CONTRI_FC_AMT_LABEL;
	}

	public void setCOMP_PMPC_TOPUP_CONTRI_FC_AMT(
			HtmlInputText COMP_PMPC_TOPUP_CONTRI_FC_AMT) {
		this.COMP_PMPC_TOPUP_CONTRI_FC_AMT = COMP_PMPC_TOPUP_CONTRI_FC_AMT;
	}

	public HtmlOutputLabel getCOMP_PMPC_TOPUP_CONTRI_LC_AMT_LABEL() {
		return COMP_PMPC_TOPUP_CONTRI_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PMPC_TOPUP_CONTRI_LC_AMT() {
		return COMP_PMPC_TOPUP_CONTRI_LC_AMT;
	}

	public void setCOMP_PMPC_TOPUP_CONTRI_LC_AMT_LABEL(
			HtmlOutputLabel COMP_PMPC_TOPUP_CONTRI_LC_AMT_LABEL) {
		this.COMP_PMPC_TOPUP_CONTRI_LC_AMT_LABEL = COMP_PMPC_TOPUP_CONTRI_LC_AMT_LABEL;
	}

	public void setCOMP_PMPC_TOPUP_CONTRI_LC_AMT(
			HtmlInputText COMP_PMPC_TOPUP_CONTRI_LC_AMT) {
		this.COMP_PMPC_TOPUP_CONTRI_LC_AMT = COMP_PMPC_TOPUP_CONTRI_LC_AMT;
	}

	public PT_IL_MULTI_PREM_COLL getPT_IL_MULTI_PREM_COLL_BEAN() {
		return PT_IL_MULTI_PREM_COLL_BEAN;
	}

	public void setPT_IL_MULTI_PREM_COLL_BEAN(
			PT_IL_MULTI_PREM_COLL PT_IL_MULTI_PREM_COLL_BEAN) {
		this.PT_IL_MULTI_PREM_COLL_BEAN = PT_IL_MULTI_PREM_COLL_BEAN;
	}

	public List<PT_IL_MULTI_PREM_COLL> getDataList_PT_IL_MULTI_PREM_COLL() {
		return dataList_PT_IL_MULTI_PREM_COLL;
	}

	public void setDataListPT_IL_MULTI_PREM_COLL(
			List<PT_IL_MULTI_PREM_COLL> dataList_PT_IL_MULTI_PREM_COLL) {
		this.dataList_PT_IL_MULTI_PREM_COLL = dataList_PT_IL_MULTI_PREM_COLL;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PT_IL_MULTI_PREM_COLL_BEAN = new PT_IL_MULTI_PREM_COLL();
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

				new CRUDHandler().executeDelete(PT_IL_MULTI_PREM_COLL_BEAN,
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
				dataList_PT_IL_MULTI_PREM_COLL
						.remove(PT_IL_MULTI_PREM_COLL_BEAN);
				if (dataList_PT_IL_MULTI_PREM_COLL.size() > 0) {

					PT_IL_MULTI_PREM_COLL_BEAN = dataList_PT_IL_MULTI_PREM_COLL
							.get(0);
				} else if (dataList_PT_IL_MULTI_PREM_COLL.size() == 0) {

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
			if (PT_IL_MULTI_PREM_COLL_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {

				new CRUDHandler().executeInsert(PT_IL_MULTI_PREM_COLL_BEAN,
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
				dataList_PT_IL_MULTI_PREM_COLL.add(PT_IL_MULTI_PREM_COLL_BEAN);
			} else if (PT_IL_MULTI_PREM_COLL_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {

				new CRUDHandler().executeUpdate(PT_IL_MULTI_PREM_COLL_BEAN,
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
		COMP_PMPC_FLEX_30.resetValue();
		COMP_PMPC_FLEX_27.resetValue();
		COMP_PMPC_FLEX_26.resetValue();
		COMP_PMPC_FLEX_25.resetValue();
		COMP_PMPC_FLEX_24.resetValue();
		COMP_PMPC_FLEX_28.resetValue();
		COMP_PMPC_FLEX_29.resetValue();
		COMP_PMPC_FLEX_01.resetValue();
		COMP_PMPC_FLEX_02.resetValue();
		COMP_PMPC_FLEX_03.resetValue();
		COMP_PMPC_FLEX_04.resetValue();
		COMP_PMPC_FLEX_05.resetValue();
		COMP_PMPC_FLEX_06.resetValue();
		COMP_PMPC_FLEX_07.resetValue();
		COMP_PMPC_FLEX_08.resetValue();
		COMP_PMPC_FLEX_09.resetValue();
		COMP_PMPC_FLEX_10.resetValue();
		COMP_PMPC_FLEX_11.resetValue();
		COMP_PMPC_FLEX_12.resetValue();
		COMP_PMPC_FLEX_13.resetValue();
		COMP_PMPC_FLEX_14.resetValue();
		COMP_PMPC_FLEX_15.resetValue();
		COMP_PMPC_FLEX_16.resetValue();
		COMP_PMPC_FLEX_17.resetValue();
		COMP_PMPC_FLEX_18.resetValue();
		COMP_PMPC_FLEX_19.resetValue();
		COMP_PMPC_FLEX_20.resetValue();
		COMP_PMPC_FLEX_21.resetValue();
		COMP_PMPC_FLEX_22.resetValue();
		COMP_PMPC_FLEX_23.resetValue();
		COMP_PMPC_CHARGE_FC_AMT.resetValue();
		COMP_PMPC_CHARGE_LC_AMT.resetValue();
		COMP_PMPC_COLL_COUNT.resetValue();
		COMP_PMPC_PAID_DT.resetValue();
		COMP_PMPC_APPRV_DT.resetValue();
		COMP_PMPC_PAID_FLAG.resetValue();
		COMP_PMPC_FC_PAID_AMT.resetValue();
		COMP_PMPC_LC_PAID_AMT.resetValue();
		COMP_PMPC_RISK_FC_AMT.resetValue();
		COMP_PMPC_RISK_LC_AMT.resetValue();
		COMP_UI_M_CHARGE_FC_AMT.resetValue();
		COMP_UI_M_CHARGE_LC_AMT.resetValue();
		COMP_PMPC_PREM_CONTRI_FC_AMT.resetValue();
		COMP_PMPC_PREM_CONTRI_LC_AMT.resetValue();
		COMP_PMPC_TOPUP_CONTRI_FC_AMT.resetValue();
		COMP_PMPC_TOPUP_CONTRI_LC_AMT.resetValue();
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
}