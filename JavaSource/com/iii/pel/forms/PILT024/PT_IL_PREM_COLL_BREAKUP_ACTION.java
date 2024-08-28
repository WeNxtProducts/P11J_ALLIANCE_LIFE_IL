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

public class PT_IL_PREM_COLL_BREAKUP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PCB_FLEX_30_LABEL;

	private HtmlInputText COMP_PCB_FLEX_30;

	private HtmlOutputLabel COMP_PCB_FLEX_13_LABEL;

	private HtmlInputText COMP_PCB_FLEX_13;

	private HtmlOutputLabel COMP_PCB_FLEX_12_LABEL;

	private HtmlInputText COMP_PCB_FLEX_12;

	private HtmlOutputLabel COMP_PCB_FLEX_14_LABEL;

	private HtmlInputText COMP_PCB_FLEX_14;

	private HtmlOutputLabel COMP_PCB_FLEX_29_LABEL;

	private HtmlInputText COMP_PCB_FLEX_29;

	private HtmlOutputLabel COMP_PCB_FLEX_28_LABEL;

	private HtmlInputText COMP_PCB_FLEX_28;

	private HtmlOutputLabel COMP_PCB_FLEX_27_LABEL;

	private HtmlInputText COMP_PCB_FLEX_27;

	private HtmlOutputLabel COMP_PCB_FLEX_26_LABEL;

	private HtmlInputText COMP_PCB_FLEX_26;

	private HtmlOutputLabel COMP_PCB_FLEX_25_LABEL;

	private HtmlInputText COMP_PCB_FLEX_25;

	private HtmlOutputLabel COMP_PCB_FLEX_24_LABEL;

	private HtmlInputText COMP_PCB_FLEX_24;

	private HtmlOutputLabel COMP_PCB_FLEX_23_LABEL;

	private HtmlInputText COMP_PCB_FLEX_23;

	private HtmlOutputLabel COMP_PCB_FLEX_22_LABEL;

	private HtmlInputText COMP_PCB_FLEX_22;

	private HtmlOutputLabel COMP_PCB_FLEX_21_LABEL;

	private HtmlInputText COMP_PCB_FLEX_21;

	private HtmlOutputLabel COMP_PCB_FLEX_20_LABEL;

	private HtmlInputText COMP_PCB_FLEX_20;

	private HtmlOutputLabel COMP_PCB_FLEX_19_LABEL;

	private HtmlInputText COMP_PCB_FLEX_19;

	private HtmlOutputLabel COMP_PCB_FLEX_18_LABEL;

	private HtmlInputText COMP_PCB_FLEX_18;

	private HtmlOutputLabel COMP_PCB_FLEX_17_LABEL;

	private HtmlInputText COMP_PCB_FLEX_17;

	private HtmlOutputLabel COMP_PCB_FLEX_16_LABEL;

	private HtmlInputText COMP_PCB_FLEX_16;

	private HtmlOutputLabel COMP_PCB_FLEX_15_LABEL;

	private HtmlInputText COMP_PCB_FLEX_15;

	private HtmlOutputLabel COMP_PCB_FLEX_01_LABEL;

	private HtmlInputText COMP_PCB_FLEX_01;

	private HtmlOutputLabel COMP_PCB_FLEX_02_LABEL;

	private HtmlInputText COMP_PCB_FLEX_02;

	private HtmlOutputLabel COMP_PCB_FLEX_03_LABEL;

	private HtmlInputText COMP_PCB_FLEX_03;

	private HtmlOutputLabel COMP_PCB_FLEX_04_LABEL;

	private HtmlInputText COMP_PCB_FLEX_04;

	private HtmlOutputLabel COMP_PCB_FLEX_05_LABEL;

	private HtmlInputText COMP_PCB_FLEX_05;

	private HtmlOutputLabel COMP_PCB_FLEX_06_LABEL;

	private HtmlInputText COMP_PCB_FLEX_06;

	private HtmlOutputLabel COMP_PCB_FLEX_07_LABEL;

	private HtmlInputText COMP_PCB_FLEX_07;

	private HtmlOutputLabel COMP_PCB_FLEX_08_LABEL;

	private HtmlInputText COMP_PCB_FLEX_08;

	private HtmlOutputLabel COMP_PCB_FLEX_09_LABEL;

	private HtmlInputText COMP_PCB_FLEX_09;

	private HtmlOutputLabel COMP_PCB_FLEX_10_LABEL;

	private HtmlInputText COMP_PCB_FLEX_10;

	private HtmlOutputLabel COMP_PCB_FLEX_11_LABEL;

	private HtmlInputText COMP_PCB_FLEX_11;

	private HtmlOutputLabel COMP_PCB_CODE_LABEL;

	private HtmlInputText COMP_PCB_CODE;

	private HtmlOutputLabel COMP_PCB_TYPE_LABEL;

	private HtmlInputText COMP_PCB_TYPE;

	private HtmlOutputLabel COMP_PCB_FC_DUE_AMT_LABEL;

	private HtmlInputText COMP_PCB_FC_DUE_AMT;

	private HtmlOutputLabel COMP_PCB_LC_DUE_AMT_LABEL;

	private HtmlInputText COMP_PCB_LC_DUE_AMT;

	private HtmlOutputLabel COMP_UI_M_PCB_FC_PAID_AMT_LABEL;

	private HtmlInputText COMP_UI_M_PCB_FC_PAID_AMT;

	private HtmlOutputLabel COMP_UI_M_PCB_LC_PAID_AMT_LABEL;

	private HtmlInputText COMP_UI_M_PCB_LC_PAID_AMT;

	private HtmlOutputLabel COMP_UI_M_PCB_FC_BAL_AMT_LABEL;

	private HtmlInputText COMP_UI_M_PCB_FC_BAL_AMT;

	private HtmlOutputLabel COMP_UI_M_PCB_LC_BAL_AMT_LABEL;

	private HtmlInputText COMP_UI_M_PCB_LC_BAL_AMT;

	private HtmlOutputLabel COMP_UI_M_PC_FC_DUE_CONTR_LABEL;

	private HtmlInputText COMP_UI_M_PC_FC_DUE_CONTR;

	private HtmlOutputLabel COMP_UI_M_PC_LC_DUE_CONTR_LABEL;

	private HtmlInputText COMP_UI_M_PC_LC_DUE_CONTR;

	private HtmlOutputLabel COMP_UI_M_PC_FC_PAID_CONTR_LABEL;

	private HtmlInputText COMP_UI_M_PC_FC_PAID_CONTR;

	private HtmlOutputLabel COMP_UI_M_PC_LC_PAID_CONTR_LABEL;

	private HtmlInputText COMP_UI_M_PC_LC_PAID_CONTR;

	private HtmlOutputLabel COMP_UI_M_PC_FC_BAL_CONTR_LABEL;

	private HtmlInputText COMP_UI_M_PC_FC_BAL_CONTR;

	private HtmlOutputLabel COMP_UI_M_PC_LC_BAL_CONTR_LABEL;

	private HtmlInputText COMP_UI_M_PC_LC_BAL_CONTR;

	private HtmlOutputLabel COMP_UI_M_TOPUP_FC_DUE_LABEL;

	private HtmlInputText COMP_UI_M_TOPUP_FC_DUE;

	private HtmlOutputLabel COMP_UI_M_TOPUP_LC_DUE_LABEL;

	private HtmlInputText COMP_UI_M_TOPUP_LC_DUE;

	private HtmlOutputLabel COMP_UI_M_TOPUP_FC_PAID_LABEL;

	private HtmlInputText COMP_UI_M_TOPUP_FC_PAID;

	private HtmlOutputLabel COMP_UI_M_TOPUP_LC_PAID_LABEL;

	private HtmlInputText COMP_UI_M_TOPUP_LC_PAID;

	private HtmlOutputLabel COMP_UI_M_TOPUP_FC_BAL_LABEL;

	private HtmlInputText COMP_UI_M_TOPUP_FC_BAL;

	private HtmlOutputLabel COMP_UI_M_TOPUP_LC_BAL_LABEL;

	private HtmlInputText COMP_UI_M_TOPUP_LC_BAL;

	private HtmlOutputLabel COMP_UI_M_PCB_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PCB_CODE_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN_1;

	private PT_IL_PREM_COLL_BREAKUP PT_IL_PREM_COLL_BREAKUP_BEAN;

	public PILT024_COMPOSITE_ACTION compositeAction;

	private PT_IL_PREM_COLL_BREAKUP_HELPER helper;
	
	private UIData dataTable;

	private List<PT_IL_PREM_COLL_BREAKUP> dataList_PT_IL_PREM_COLL_BREAKUP = new ArrayList<PT_IL_PREM_COLL_BREAKUP>();

	public PT_IL_PREM_COLL_BREAKUP_ACTION() {

		PT_IL_PREM_COLL_BREAKUP_BEAN = new PT_IL_PREM_COLL_BREAKUP();
		helper = new PT_IL_PREM_COLL_BREAKUP_HELPER();
	}

	public void onLoad(PhaseEvent event) throws Exception {
		try {
			if (isFormFlag()) {
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				helper.executeQuery(compositeAction);
				if (PT_IL_PREM_COLL_BREAKUP_BEAN.getROWID() != null) {
				} else {
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_30_LABEL() {
		return COMP_PCB_FLEX_30_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_30() {
		return COMP_PCB_FLEX_30;
	}

	public void setCOMP_PCB_FLEX_30_LABEL(HtmlOutputLabel COMP_PCB_FLEX_30_LABEL) {
		this.COMP_PCB_FLEX_30_LABEL = COMP_PCB_FLEX_30_LABEL;
	}

	public void setCOMP_PCB_FLEX_30(HtmlInputText COMP_PCB_FLEX_30) {
		this.COMP_PCB_FLEX_30 = COMP_PCB_FLEX_30;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_13_LABEL() {
		return COMP_PCB_FLEX_13_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_13() {
		return COMP_PCB_FLEX_13;
	}

	public void setCOMP_PCB_FLEX_13_LABEL(HtmlOutputLabel COMP_PCB_FLEX_13_LABEL) {
		this.COMP_PCB_FLEX_13_LABEL = COMP_PCB_FLEX_13_LABEL;
	}

	public void setCOMP_PCB_FLEX_13(HtmlInputText COMP_PCB_FLEX_13) {
		this.COMP_PCB_FLEX_13 = COMP_PCB_FLEX_13;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_12_LABEL() {
		return COMP_PCB_FLEX_12_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_12() {
		return COMP_PCB_FLEX_12;
	}

	public void setCOMP_PCB_FLEX_12_LABEL(HtmlOutputLabel COMP_PCB_FLEX_12_LABEL) {
		this.COMP_PCB_FLEX_12_LABEL = COMP_PCB_FLEX_12_LABEL;
	}

	public void setCOMP_PCB_FLEX_12(HtmlInputText COMP_PCB_FLEX_12) {
		this.COMP_PCB_FLEX_12 = COMP_PCB_FLEX_12;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_14_LABEL() {
		return COMP_PCB_FLEX_14_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_14() {
		return COMP_PCB_FLEX_14;
	}

	public void setCOMP_PCB_FLEX_14_LABEL(HtmlOutputLabel COMP_PCB_FLEX_14_LABEL) {
		this.COMP_PCB_FLEX_14_LABEL = COMP_PCB_FLEX_14_LABEL;
	}

	public void setCOMP_PCB_FLEX_14(HtmlInputText COMP_PCB_FLEX_14) {
		this.COMP_PCB_FLEX_14 = COMP_PCB_FLEX_14;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_29_LABEL() {
		return COMP_PCB_FLEX_29_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_29() {
		return COMP_PCB_FLEX_29;
	}

	public void setCOMP_PCB_FLEX_29_LABEL(HtmlOutputLabel COMP_PCB_FLEX_29_LABEL) {
		this.COMP_PCB_FLEX_29_LABEL = COMP_PCB_FLEX_29_LABEL;
	}

	public void setCOMP_PCB_FLEX_29(HtmlInputText COMP_PCB_FLEX_29) {
		this.COMP_PCB_FLEX_29 = COMP_PCB_FLEX_29;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_28_LABEL() {
		return COMP_PCB_FLEX_28_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_28() {
		return COMP_PCB_FLEX_28;
	}

	public void setCOMP_PCB_FLEX_28_LABEL(HtmlOutputLabel COMP_PCB_FLEX_28_LABEL) {
		this.COMP_PCB_FLEX_28_LABEL = COMP_PCB_FLEX_28_LABEL;
	}

	public void setCOMP_PCB_FLEX_28(HtmlInputText COMP_PCB_FLEX_28) {
		this.COMP_PCB_FLEX_28 = COMP_PCB_FLEX_28;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_27_LABEL() {
		return COMP_PCB_FLEX_27_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_27() {
		return COMP_PCB_FLEX_27;
	}

	public void setCOMP_PCB_FLEX_27_LABEL(HtmlOutputLabel COMP_PCB_FLEX_27_LABEL) {
		this.COMP_PCB_FLEX_27_LABEL = COMP_PCB_FLEX_27_LABEL;
	}

	public void setCOMP_PCB_FLEX_27(HtmlInputText COMP_PCB_FLEX_27) {
		this.COMP_PCB_FLEX_27 = COMP_PCB_FLEX_27;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_26_LABEL() {
		return COMP_PCB_FLEX_26_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_26() {
		return COMP_PCB_FLEX_26;
	}

	public void setCOMP_PCB_FLEX_26_LABEL(HtmlOutputLabel COMP_PCB_FLEX_26_LABEL) {
		this.COMP_PCB_FLEX_26_LABEL = COMP_PCB_FLEX_26_LABEL;
	}

	public void setCOMP_PCB_FLEX_26(HtmlInputText COMP_PCB_FLEX_26) {
		this.COMP_PCB_FLEX_26 = COMP_PCB_FLEX_26;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_25_LABEL() {
		return COMP_PCB_FLEX_25_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_25() {
		return COMP_PCB_FLEX_25;
	}

	public void setCOMP_PCB_FLEX_25_LABEL(HtmlOutputLabel COMP_PCB_FLEX_25_LABEL) {
		this.COMP_PCB_FLEX_25_LABEL = COMP_PCB_FLEX_25_LABEL;
	}

	public void setCOMP_PCB_FLEX_25(HtmlInputText COMP_PCB_FLEX_25) {
		this.COMP_PCB_FLEX_25 = COMP_PCB_FLEX_25;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_24_LABEL() {
		return COMP_PCB_FLEX_24_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_24() {
		return COMP_PCB_FLEX_24;
	}

	public void setCOMP_PCB_FLEX_24_LABEL(HtmlOutputLabel COMP_PCB_FLEX_24_LABEL) {
		this.COMP_PCB_FLEX_24_LABEL = COMP_PCB_FLEX_24_LABEL;
	}

	public void setCOMP_PCB_FLEX_24(HtmlInputText COMP_PCB_FLEX_24) {
		this.COMP_PCB_FLEX_24 = COMP_PCB_FLEX_24;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_23_LABEL() {
		return COMP_PCB_FLEX_23_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_23() {
		return COMP_PCB_FLEX_23;
	}

	public void setCOMP_PCB_FLEX_23_LABEL(HtmlOutputLabel COMP_PCB_FLEX_23_LABEL) {
		this.COMP_PCB_FLEX_23_LABEL = COMP_PCB_FLEX_23_LABEL;
	}

	public void setCOMP_PCB_FLEX_23(HtmlInputText COMP_PCB_FLEX_23) {
		this.COMP_PCB_FLEX_23 = COMP_PCB_FLEX_23;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_22_LABEL() {
		return COMP_PCB_FLEX_22_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_22() {
		return COMP_PCB_FLEX_22;
	}

	public void setCOMP_PCB_FLEX_22_LABEL(HtmlOutputLabel COMP_PCB_FLEX_22_LABEL) {
		this.COMP_PCB_FLEX_22_LABEL = COMP_PCB_FLEX_22_LABEL;
	}

	public void setCOMP_PCB_FLEX_22(HtmlInputText COMP_PCB_FLEX_22) {
		this.COMP_PCB_FLEX_22 = COMP_PCB_FLEX_22;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_21_LABEL() {
		return COMP_PCB_FLEX_21_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_21() {
		return COMP_PCB_FLEX_21;
	}

	public void setCOMP_PCB_FLEX_21_LABEL(HtmlOutputLabel COMP_PCB_FLEX_21_LABEL) {
		this.COMP_PCB_FLEX_21_LABEL = COMP_PCB_FLEX_21_LABEL;
	}

	public void setCOMP_PCB_FLEX_21(HtmlInputText COMP_PCB_FLEX_21) {
		this.COMP_PCB_FLEX_21 = COMP_PCB_FLEX_21;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_20_LABEL() {
		return COMP_PCB_FLEX_20_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_20() {
		return COMP_PCB_FLEX_20;
	}

	public void setCOMP_PCB_FLEX_20_LABEL(HtmlOutputLabel COMP_PCB_FLEX_20_LABEL) {
		this.COMP_PCB_FLEX_20_LABEL = COMP_PCB_FLEX_20_LABEL;
	}

	public void setCOMP_PCB_FLEX_20(HtmlInputText COMP_PCB_FLEX_20) {
		this.COMP_PCB_FLEX_20 = COMP_PCB_FLEX_20;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_19_LABEL() {
		return COMP_PCB_FLEX_19_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_19() {
		return COMP_PCB_FLEX_19;
	}

	public void setCOMP_PCB_FLEX_19_LABEL(HtmlOutputLabel COMP_PCB_FLEX_19_LABEL) {
		this.COMP_PCB_FLEX_19_LABEL = COMP_PCB_FLEX_19_LABEL;
	}

	public void setCOMP_PCB_FLEX_19(HtmlInputText COMP_PCB_FLEX_19) {
		this.COMP_PCB_FLEX_19 = COMP_PCB_FLEX_19;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_18_LABEL() {
		return COMP_PCB_FLEX_18_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_18() {
		return COMP_PCB_FLEX_18;
	}

	public void setCOMP_PCB_FLEX_18_LABEL(HtmlOutputLabel COMP_PCB_FLEX_18_LABEL) {
		this.COMP_PCB_FLEX_18_LABEL = COMP_PCB_FLEX_18_LABEL;
	}

	public void setCOMP_PCB_FLEX_18(HtmlInputText COMP_PCB_FLEX_18) {
		this.COMP_PCB_FLEX_18 = COMP_PCB_FLEX_18;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_17_LABEL() {
		return COMP_PCB_FLEX_17_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_17() {
		return COMP_PCB_FLEX_17;
	}

	public void setCOMP_PCB_FLEX_17_LABEL(HtmlOutputLabel COMP_PCB_FLEX_17_LABEL) {
		this.COMP_PCB_FLEX_17_LABEL = COMP_PCB_FLEX_17_LABEL;
	}

	public void setCOMP_PCB_FLEX_17(HtmlInputText COMP_PCB_FLEX_17) {
		this.COMP_PCB_FLEX_17 = COMP_PCB_FLEX_17;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_16_LABEL() {
		return COMP_PCB_FLEX_16_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_16() {
		return COMP_PCB_FLEX_16;
	}

	public void setCOMP_PCB_FLEX_16_LABEL(HtmlOutputLabel COMP_PCB_FLEX_16_LABEL) {
		this.COMP_PCB_FLEX_16_LABEL = COMP_PCB_FLEX_16_LABEL;
	}

	public void setCOMP_PCB_FLEX_16(HtmlInputText COMP_PCB_FLEX_16) {
		this.COMP_PCB_FLEX_16 = COMP_PCB_FLEX_16;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_15_LABEL() {
		return COMP_PCB_FLEX_15_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_15() {
		return COMP_PCB_FLEX_15;
	}

	public void setCOMP_PCB_FLEX_15_LABEL(HtmlOutputLabel COMP_PCB_FLEX_15_LABEL) {
		this.COMP_PCB_FLEX_15_LABEL = COMP_PCB_FLEX_15_LABEL;
	}

	public void setCOMP_PCB_FLEX_15(HtmlInputText COMP_PCB_FLEX_15) {
		this.COMP_PCB_FLEX_15 = COMP_PCB_FLEX_15;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_01_LABEL() {
		return COMP_PCB_FLEX_01_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_01() {
		return COMP_PCB_FLEX_01;
	}

	public void setCOMP_PCB_FLEX_01_LABEL(HtmlOutputLabel COMP_PCB_FLEX_01_LABEL) {
		this.COMP_PCB_FLEX_01_LABEL = COMP_PCB_FLEX_01_LABEL;
	}

	public void setCOMP_PCB_FLEX_01(HtmlInputText COMP_PCB_FLEX_01) {
		this.COMP_PCB_FLEX_01 = COMP_PCB_FLEX_01;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_02_LABEL() {
		return COMP_PCB_FLEX_02_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_02() {
		return COMP_PCB_FLEX_02;
	}

	public void setCOMP_PCB_FLEX_02_LABEL(HtmlOutputLabel COMP_PCB_FLEX_02_LABEL) {
		this.COMP_PCB_FLEX_02_LABEL = COMP_PCB_FLEX_02_LABEL;
	}

	public void setCOMP_PCB_FLEX_02(HtmlInputText COMP_PCB_FLEX_02) {
		this.COMP_PCB_FLEX_02 = COMP_PCB_FLEX_02;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_03_LABEL() {
		return COMP_PCB_FLEX_03_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_03() {
		return COMP_PCB_FLEX_03;
	}

	public void setCOMP_PCB_FLEX_03_LABEL(HtmlOutputLabel COMP_PCB_FLEX_03_LABEL) {
		this.COMP_PCB_FLEX_03_LABEL = COMP_PCB_FLEX_03_LABEL;
	}

	public void setCOMP_PCB_FLEX_03(HtmlInputText COMP_PCB_FLEX_03) {
		this.COMP_PCB_FLEX_03 = COMP_PCB_FLEX_03;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_04_LABEL() {
		return COMP_PCB_FLEX_04_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_04() {
		return COMP_PCB_FLEX_04;
	}

	public void setCOMP_PCB_FLEX_04_LABEL(HtmlOutputLabel COMP_PCB_FLEX_04_LABEL) {
		this.COMP_PCB_FLEX_04_LABEL = COMP_PCB_FLEX_04_LABEL;
	}

	public void setCOMP_PCB_FLEX_04(HtmlInputText COMP_PCB_FLEX_04) {
		this.COMP_PCB_FLEX_04 = COMP_PCB_FLEX_04;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_05_LABEL() {
		return COMP_PCB_FLEX_05_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_05() {
		return COMP_PCB_FLEX_05;
	}

	public void setCOMP_PCB_FLEX_05_LABEL(HtmlOutputLabel COMP_PCB_FLEX_05_LABEL) {
		this.COMP_PCB_FLEX_05_LABEL = COMP_PCB_FLEX_05_LABEL;
	}

	public void setCOMP_PCB_FLEX_05(HtmlInputText COMP_PCB_FLEX_05) {
		this.COMP_PCB_FLEX_05 = COMP_PCB_FLEX_05;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_06_LABEL() {
		return COMP_PCB_FLEX_06_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_06() {
		return COMP_PCB_FLEX_06;
	}

	public void setCOMP_PCB_FLEX_06_LABEL(HtmlOutputLabel COMP_PCB_FLEX_06_LABEL) {
		this.COMP_PCB_FLEX_06_LABEL = COMP_PCB_FLEX_06_LABEL;
	}

	public void setCOMP_PCB_FLEX_06(HtmlInputText COMP_PCB_FLEX_06) {
		this.COMP_PCB_FLEX_06 = COMP_PCB_FLEX_06;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_07_LABEL() {
		return COMP_PCB_FLEX_07_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_07() {
		return COMP_PCB_FLEX_07;
	}

	public void setCOMP_PCB_FLEX_07_LABEL(HtmlOutputLabel COMP_PCB_FLEX_07_LABEL) {
		this.COMP_PCB_FLEX_07_LABEL = COMP_PCB_FLEX_07_LABEL;
	}

	public void setCOMP_PCB_FLEX_07(HtmlInputText COMP_PCB_FLEX_07) {
		this.COMP_PCB_FLEX_07 = COMP_PCB_FLEX_07;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_08_LABEL() {
		return COMP_PCB_FLEX_08_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_08() {
		return COMP_PCB_FLEX_08;
	}

	public void setCOMP_PCB_FLEX_08_LABEL(HtmlOutputLabel COMP_PCB_FLEX_08_LABEL) {
		this.COMP_PCB_FLEX_08_LABEL = COMP_PCB_FLEX_08_LABEL;
	}

	public void setCOMP_PCB_FLEX_08(HtmlInputText COMP_PCB_FLEX_08) {
		this.COMP_PCB_FLEX_08 = COMP_PCB_FLEX_08;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_09_LABEL() {
		return COMP_PCB_FLEX_09_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_09() {
		return COMP_PCB_FLEX_09;
	}

	public void setCOMP_PCB_FLEX_09_LABEL(HtmlOutputLabel COMP_PCB_FLEX_09_LABEL) {
		this.COMP_PCB_FLEX_09_LABEL = COMP_PCB_FLEX_09_LABEL;
	}

	public void setCOMP_PCB_FLEX_09(HtmlInputText COMP_PCB_FLEX_09) {
		this.COMP_PCB_FLEX_09 = COMP_PCB_FLEX_09;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_10_LABEL() {
		return COMP_PCB_FLEX_10_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_10() {
		return COMP_PCB_FLEX_10;
	}

	public void setCOMP_PCB_FLEX_10_LABEL(HtmlOutputLabel COMP_PCB_FLEX_10_LABEL) {
		this.COMP_PCB_FLEX_10_LABEL = COMP_PCB_FLEX_10_LABEL;
	}

	public void setCOMP_PCB_FLEX_10(HtmlInputText COMP_PCB_FLEX_10) {
		this.COMP_PCB_FLEX_10 = COMP_PCB_FLEX_10;
	}

	public HtmlOutputLabel getCOMP_PCB_FLEX_11_LABEL() {
		return COMP_PCB_FLEX_11_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FLEX_11() {
		return COMP_PCB_FLEX_11;
	}

	public void setCOMP_PCB_FLEX_11_LABEL(HtmlOutputLabel COMP_PCB_FLEX_11_LABEL) {
		this.COMP_PCB_FLEX_11_LABEL = COMP_PCB_FLEX_11_LABEL;
	}

	public void setCOMP_PCB_FLEX_11(HtmlInputText COMP_PCB_FLEX_11) {
		this.COMP_PCB_FLEX_11 = COMP_PCB_FLEX_11;
	}

	public HtmlOutputLabel getCOMP_PCB_CODE_LABEL() {
		return COMP_PCB_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PCB_CODE() {
		return COMP_PCB_CODE;
	}

	public void setCOMP_PCB_CODE_LABEL(HtmlOutputLabel COMP_PCB_CODE_LABEL) {
		this.COMP_PCB_CODE_LABEL = COMP_PCB_CODE_LABEL;
	}

	public void setCOMP_PCB_CODE(HtmlInputText COMP_PCB_CODE) {
		this.COMP_PCB_CODE = COMP_PCB_CODE;
	}

	public HtmlOutputLabel getCOMP_PCB_TYPE_LABEL() {
		return COMP_PCB_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_PCB_TYPE() {
		return COMP_PCB_TYPE;
	}

	public void setCOMP_PCB_TYPE_LABEL(HtmlOutputLabel COMP_PCB_TYPE_LABEL) {
		this.COMP_PCB_TYPE_LABEL = COMP_PCB_TYPE_LABEL;
	}

	public void setCOMP_PCB_TYPE(HtmlInputText COMP_PCB_TYPE) {
		this.COMP_PCB_TYPE = COMP_PCB_TYPE;
	}

	public HtmlOutputLabel getCOMP_PCB_FC_DUE_AMT_LABEL() {
		return COMP_PCB_FC_DUE_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCB_FC_DUE_AMT() {
		return COMP_PCB_FC_DUE_AMT;
	}

	public void setCOMP_PCB_FC_DUE_AMT_LABEL(
			HtmlOutputLabel COMP_PCB_FC_DUE_AMT_LABEL) {
		this.COMP_PCB_FC_DUE_AMT_LABEL = COMP_PCB_FC_DUE_AMT_LABEL;
	}

	public void setCOMP_PCB_FC_DUE_AMT(HtmlInputText COMP_PCB_FC_DUE_AMT) {
		this.COMP_PCB_FC_DUE_AMT = COMP_PCB_FC_DUE_AMT;
	}

	public HtmlOutputLabel getCOMP_PCB_LC_DUE_AMT_LABEL() {
		return COMP_PCB_LC_DUE_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PCB_LC_DUE_AMT() {
		return COMP_PCB_LC_DUE_AMT;
	}

	public void setCOMP_PCB_LC_DUE_AMT_LABEL(
			HtmlOutputLabel COMP_PCB_LC_DUE_AMT_LABEL) {
		this.COMP_PCB_LC_DUE_AMT_LABEL = COMP_PCB_LC_DUE_AMT_LABEL;
	}

	public void setCOMP_PCB_LC_DUE_AMT(HtmlInputText COMP_PCB_LC_DUE_AMT) {
		this.COMP_PCB_LC_DUE_AMT = COMP_PCB_LC_DUE_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_PCB_FC_PAID_AMT_LABEL() {
		return COMP_UI_M_PCB_FC_PAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PCB_FC_PAID_AMT() {
		return COMP_UI_M_PCB_FC_PAID_AMT;
	}

	public void setCOMP_UI_M_PCB_FC_PAID_AMT_LABEL(
			HtmlOutputLabel COMP_UI_M_PCB_FC_PAID_AMT_LABEL) {
		this.COMP_UI_M_PCB_FC_PAID_AMT_LABEL = COMP_UI_M_PCB_FC_PAID_AMT_LABEL;
	}

	public void setCOMP_UI_M_PCB_FC_PAID_AMT(
			HtmlInputText COMP_UI_M_PCB_FC_PAID_AMT) {
		this.COMP_UI_M_PCB_FC_PAID_AMT = COMP_UI_M_PCB_FC_PAID_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_PCB_LC_PAID_AMT_LABEL() {
		return COMP_UI_M_PCB_LC_PAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PCB_LC_PAID_AMT() {
		return COMP_UI_M_PCB_LC_PAID_AMT;
	}

	public void setCOMP_UI_M_PCB_LC_PAID_AMT_LABEL(
			HtmlOutputLabel COMP_UI_M_PCB_LC_PAID_AMT_LABEL) {
		this.COMP_UI_M_PCB_LC_PAID_AMT_LABEL = COMP_UI_M_PCB_LC_PAID_AMT_LABEL;
	}

	public void setCOMP_UI_M_PCB_LC_PAID_AMT(
			HtmlInputText COMP_UI_M_PCB_LC_PAID_AMT) {
		this.COMP_UI_M_PCB_LC_PAID_AMT = COMP_UI_M_PCB_LC_PAID_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_PCB_FC_BAL_AMT_LABEL() {
		return COMP_UI_M_PCB_FC_BAL_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PCB_FC_BAL_AMT() {
		return COMP_UI_M_PCB_FC_BAL_AMT;
	}

	public void setCOMP_UI_M_PCB_FC_BAL_AMT_LABEL(
			HtmlOutputLabel COMP_UI_M_PCB_FC_BAL_AMT_LABEL) {
		this.COMP_UI_M_PCB_FC_BAL_AMT_LABEL = COMP_UI_M_PCB_FC_BAL_AMT_LABEL;
	}

	public void setCOMP_UI_M_PCB_FC_BAL_AMT(
			HtmlInputText COMP_UI_M_PCB_FC_BAL_AMT) {
		this.COMP_UI_M_PCB_FC_BAL_AMT = COMP_UI_M_PCB_FC_BAL_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_PCB_LC_BAL_AMT_LABEL() {
		return COMP_UI_M_PCB_LC_BAL_AMT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PCB_LC_BAL_AMT() {
		return COMP_UI_M_PCB_LC_BAL_AMT;
	}

	public void setCOMP_UI_M_PCB_LC_BAL_AMT_LABEL(
			HtmlOutputLabel COMP_UI_M_PCB_LC_BAL_AMT_LABEL) {
		this.COMP_UI_M_PCB_LC_BAL_AMT_LABEL = COMP_UI_M_PCB_LC_BAL_AMT_LABEL;
	}

	public void setCOMP_UI_M_PCB_LC_BAL_AMT(
			HtmlInputText COMP_UI_M_PCB_LC_BAL_AMT) {
		this.COMP_UI_M_PCB_LC_BAL_AMT = COMP_UI_M_PCB_LC_BAL_AMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_FC_DUE_CONTR_LABEL() {
		return COMP_UI_M_PC_FC_DUE_CONTR_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_FC_DUE_CONTR() {
		return COMP_UI_M_PC_FC_DUE_CONTR;
	}

	public void setCOMP_UI_M_PC_FC_DUE_CONTR_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_FC_DUE_CONTR_LABEL) {
		this.COMP_UI_M_PC_FC_DUE_CONTR_LABEL = COMP_UI_M_PC_FC_DUE_CONTR_LABEL;
	}

	public void setCOMP_UI_M_PC_FC_DUE_CONTR(
			HtmlInputText COMP_UI_M_PC_FC_DUE_CONTR) {
		this.COMP_UI_M_PC_FC_DUE_CONTR = COMP_UI_M_PC_FC_DUE_CONTR;
	}

	public HtmlOutputLabel getCOMP_UI_M_PC_LC_DUE_CONTR_LABEL() {
		return COMP_UI_M_PC_LC_DUE_CONTR_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PC_LC_DUE_CONTR() {
		return COMP_UI_M_PC_LC_DUE_CONTR;
	}

	public void setCOMP_UI_M_PC_LC_DUE_CONTR_LABEL(
			HtmlOutputLabel COMP_UI_M_PC_LC_DUE_CONTR_LABEL) {
		this.COMP_UI_M_PC_LC_DUE_CONTR_LABEL = COMP_UI_M_PC_LC_DUE_CONTR_LABEL;
	}

	public void setCOMP_UI_M_PC_LC_DUE_CONTR(
			HtmlInputText COMP_UI_M_PC_LC_DUE_CONTR) {
		this.COMP_UI_M_PC_LC_DUE_CONTR = COMP_UI_M_PC_LC_DUE_CONTR;
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

	public HtmlOutputLabel getCOMP_UI_M_TOPUP_FC_DUE_LABEL() {
		return COMP_UI_M_TOPUP_FC_DUE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TOPUP_FC_DUE() {
		return COMP_UI_M_TOPUP_FC_DUE;
	}

	public void setCOMP_UI_M_TOPUP_FC_DUE_LABEL(
			HtmlOutputLabel COMP_UI_M_TOPUP_FC_DUE_LABEL) {
		this.COMP_UI_M_TOPUP_FC_DUE_LABEL = COMP_UI_M_TOPUP_FC_DUE_LABEL;
	}

	public void setCOMP_UI_M_TOPUP_FC_DUE(HtmlInputText COMP_UI_M_TOPUP_FC_DUE) {
		this.COMP_UI_M_TOPUP_FC_DUE = COMP_UI_M_TOPUP_FC_DUE;
	}

	public HtmlOutputLabel getCOMP_UI_M_TOPUP_LC_DUE_LABEL() {
		return COMP_UI_M_TOPUP_LC_DUE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TOPUP_LC_DUE() {
		return COMP_UI_M_TOPUP_LC_DUE;
	}

	public void setCOMP_UI_M_TOPUP_LC_DUE_LABEL(
			HtmlOutputLabel COMP_UI_M_TOPUP_LC_DUE_LABEL) {
		this.COMP_UI_M_TOPUP_LC_DUE_LABEL = COMP_UI_M_TOPUP_LC_DUE_LABEL;
	}

	public void setCOMP_UI_M_TOPUP_LC_DUE(HtmlInputText COMP_UI_M_TOPUP_LC_DUE) {
		this.COMP_UI_M_TOPUP_LC_DUE = COMP_UI_M_TOPUP_LC_DUE;
	}

	public HtmlOutputLabel getCOMP_UI_M_TOPUP_FC_PAID_LABEL() {
		return COMP_UI_M_TOPUP_FC_PAID_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TOPUP_FC_PAID() {
		return COMP_UI_M_TOPUP_FC_PAID;
	}

	public void setCOMP_UI_M_TOPUP_FC_PAID_LABEL(
			HtmlOutputLabel COMP_UI_M_TOPUP_FC_PAID_LABEL) {
		this.COMP_UI_M_TOPUP_FC_PAID_LABEL = COMP_UI_M_TOPUP_FC_PAID_LABEL;
	}

	public void setCOMP_UI_M_TOPUP_FC_PAID(HtmlInputText COMP_UI_M_TOPUP_FC_PAID) {
		this.COMP_UI_M_TOPUP_FC_PAID = COMP_UI_M_TOPUP_FC_PAID;
	}

	public HtmlOutputLabel getCOMP_UI_M_TOPUP_LC_PAID_LABEL() {
		return COMP_UI_M_TOPUP_LC_PAID_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TOPUP_LC_PAID() {
		return COMP_UI_M_TOPUP_LC_PAID;
	}

	public void setCOMP_UI_M_TOPUP_LC_PAID_LABEL(
			HtmlOutputLabel COMP_UI_M_TOPUP_LC_PAID_LABEL) {
		this.COMP_UI_M_TOPUP_LC_PAID_LABEL = COMP_UI_M_TOPUP_LC_PAID_LABEL;
	}

	public void setCOMP_UI_M_TOPUP_LC_PAID(HtmlInputText COMP_UI_M_TOPUP_LC_PAID) {
		this.COMP_UI_M_TOPUP_LC_PAID = COMP_UI_M_TOPUP_LC_PAID;
	}

	public HtmlOutputLabel getCOMP_UI_M_TOPUP_FC_BAL_LABEL() {
		return COMP_UI_M_TOPUP_FC_BAL_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TOPUP_FC_BAL() {
		return COMP_UI_M_TOPUP_FC_BAL;
	}

	public void setCOMP_UI_M_TOPUP_FC_BAL_LABEL(
			HtmlOutputLabel COMP_UI_M_TOPUP_FC_BAL_LABEL) {
		this.COMP_UI_M_TOPUP_FC_BAL_LABEL = COMP_UI_M_TOPUP_FC_BAL_LABEL;
	}

	public void setCOMP_UI_M_TOPUP_FC_BAL(HtmlInputText COMP_UI_M_TOPUP_FC_BAL) {
		this.COMP_UI_M_TOPUP_FC_BAL = COMP_UI_M_TOPUP_FC_BAL;
	}

	public HtmlOutputLabel getCOMP_UI_M_TOPUP_LC_BAL_LABEL() {
		return COMP_UI_M_TOPUP_LC_BAL_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TOPUP_LC_BAL() {
		return COMP_UI_M_TOPUP_LC_BAL;
	}

	public void setCOMP_UI_M_TOPUP_LC_BAL_LABEL(
			HtmlOutputLabel COMP_UI_M_TOPUP_LC_BAL_LABEL) {
		this.COMP_UI_M_TOPUP_LC_BAL_LABEL = COMP_UI_M_TOPUP_LC_BAL_LABEL;
	}

	public void setCOMP_UI_M_TOPUP_LC_BAL(HtmlInputText COMP_UI_M_TOPUP_LC_BAL) {
		this.COMP_UI_M_TOPUP_LC_BAL = COMP_UI_M_TOPUP_LC_BAL;
	}

	public HtmlOutputLabel getCOMP_UI_M_PCB_CODE_DESC_LABEL() {
		return COMP_UI_M_PCB_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PCB_CODE_DESC() {
		return COMP_UI_M_PCB_CODE_DESC;
	}

	public void setCOMP_UI_M_PCB_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PCB_CODE_DESC_LABEL) {
		this.COMP_UI_M_PCB_CODE_DESC_LABEL = COMP_UI_M_PCB_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_PCB_CODE_DESC(HtmlInputText COMP_UI_M_PCB_CODE_DESC) {
		this.COMP_UI_M_PCB_CODE_DESC = COMP_UI_M_PCB_CODE_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN_1() {
		return COMP_UI_M_BUT_MAIN_1;
	}

	public void setCOMP_UI_M_BUT_MAIN_1(HtmlCommandButton COMP_UI_M_BUT_MAIN_1) {
		this.COMP_UI_M_BUT_MAIN_1 = COMP_UI_M_BUT_MAIN_1;
	}

	public PT_IL_PREM_COLL_BREAKUP getPT_IL_PREM_COLL_BREAKUP_BEAN() {
		return PT_IL_PREM_COLL_BREAKUP_BEAN;
	}

	public void setPT_IL_PREM_COLL_BREAKUP_BEAN(
			PT_IL_PREM_COLL_BREAKUP PT_IL_PREM_COLL_BREAKUP_BEAN) {
		this.PT_IL_PREM_COLL_BREAKUP_BEAN = PT_IL_PREM_COLL_BREAKUP_BEAN;
	}

	public List<PT_IL_PREM_COLL_BREAKUP> getDataList_PT_IL_PREM_COLL_BREAKUP() {
		return dataList_PT_IL_PREM_COLL_BREAKUP;
	}

	public void setDataListPT_IL_PREM_COLL_BREAKUP(
			List<PT_IL_PREM_COLL_BREAKUP> dataList_PT_IL_PREM_COLL_BREAKUP) {
		this.dataList_PT_IL_PREM_COLL_BREAKUP = dataList_PT_IL_PREM_COLL_BREAKUP;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PT_IL_PREM_COLL_BREAKUP_BEAN = new PT_IL_PREM_COLL_BREAKUP();
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
				new CRUDHandler().executeDelete(PT_IL_PREM_COLL_BREAKUP_BEAN,
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
				dataList_PT_IL_PREM_COLL_BREAKUP
						.remove(PT_IL_PREM_COLL_BREAKUP_BEAN);
				if (dataList_PT_IL_PREM_COLL_BREAKUP.size() > 0) {

					PT_IL_PREM_COLL_BREAKUP_BEAN = dataList_PT_IL_PREM_COLL_BREAKUP
							.get(0);
				} else if (dataList_PT_IL_PREM_COLL_BREAKUP.size() == 0) {

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
			if (PT_IL_PREM_COLL_BREAKUP_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				new CRUDHandler().executeInsert(PT_IL_PREM_COLL_BREAKUP_BEAN,
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
				dataList_PT_IL_PREM_COLL_BREAKUP
						.add(PT_IL_PREM_COLL_BREAKUP_BEAN);
			} else if (PT_IL_PREM_COLL_BREAKUP_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				new CRUDHandler().executeUpdate(PT_IL_PREM_COLL_BREAKUP_BEAN,
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
		COMP_PCB_FLEX_30.resetValue();
		COMP_PCB_FLEX_13.resetValue();
		COMP_PCB_FLEX_12.resetValue();
		COMP_PCB_FLEX_14.resetValue();
		COMP_PCB_FLEX_29.resetValue();
		COMP_PCB_FLEX_28.resetValue();
		COMP_PCB_FLEX_27.resetValue();
		COMP_PCB_FLEX_26.resetValue();
		COMP_PCB_FLEX_25.resetValue();
		COMP_PCB_FLEX_24.resetValue();
		COMP_PCB_FLEX_23.resetValue();
		COMP_PCB_FLEX_22.resetValue();
		COMP_PCB_FLEX_21.resetValue();
		COMP_PCB_FLEX_20.resetValue();
		COMP_PCB_FLEX_19.resetValue();
		COMP_PCB_FLEX_18.resetValue();
		COMP_PCB_FLEX_17.resetValue();
		COMP_PCB_FLEX_16.resetValue();
		COMP_PCB_FLEX_15.resetValue();
		COMP_PCB_FLEX_01.resetValue();
		COMP_PCB_FLEX_02.resetValue();
		COMP_PCB_FLEX_03.resetValue();
		COMP_PCB_FLEX_04.resetValue();
		COMP_PCB_FLEX_05.resetValue();
		COMP_PCB_FLEX_06.resetValue();
		COMP_PCB_FLEX_07.resetValue();
		COMP_PCB_FLEX_08.resetValue();
		COMP_PCB_FLEX_09.resetValue();
		COMP_PCB_FLEX_10.resetValue();
		COMP_PCB_FLEX_11.resetValue();
		COMP_PCB_CODE.resetValue();
		COMP_PCB_TYPE.resetValue();
		COMP_PCB_FC_DUE_AMT.resetValue();
		COMP_PCB_LC_DUE_AMT.resetValue();
		COMP_UI_M_PCB_FC_PAID_AMT.resetValue();
		COMP_UI_M_PCB_LC_PAID_AMT.resetValue();
		COMP_UI_M_PCB_FC_BAL_AMT.resetValue();
		COMP_UI_M_PCB_LC_BAL_AMT.resetValue();
		COMP_UI_M_PC_FC_DUE_CONTR.resetValue();
		COMP_UI_M_PC_LC_DUE_CONTR.resetValue();
		COMP_UI_M_PC_FC_PAID_CONTR.resetValue();
		COMP_UI_M_PC_LC_PAID_CONTR.resetValue();
		COMP_UI_M_PC_FC_BAL_CONTR.resetValue();
		COMP_UI_M_PC_LC_BAL_CONTR.resetValue();
		COMP_UI_M_TOPUP_FC_DUE.resetValue();
		COMP_UI_M_TOPUP_LC_DUE.resetValue();
		COMP_UI_M_TOPUP_FC_PAID.resetValue();
		COMP_UI_M_TOPUP_LC_PAID.resetValue();
		COMP_UI_M_TOPUP_FC_BAL.resetValue();
		COMP_UI_M_TOPUP_LC_BAL.resetValue();
		COMP_UI_M_PCB_CODE_DESC.resetValue();
		// COMP_UI_M_BUT_MAIN_1.resetValue();
	}

	public PILT024_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT024_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PT_IL_PREM_COLL_BREAKUP_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_PREM_COLL_BREAKUP_HELPER helper) {
		this.helper = helper;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public void setDataList_PT_IL_PREM_COLL_BREAKUP(
			List<PT_IL_PREM_COLL_BREAKUP> dataList_PT_IL_PREM_COLL_BREAKUP) {
		this.dataList_PT_IL_PREM_COLL_BREAKUP = dataList_PT_IL_PREM_COLL_BREAKUP;
	}
	
	
	public String goMain(){
		return "PILT024_PT_IL_POLICY";
	}
}