package com.iii.pel.forms.PILT024;

import java.io.*;
import java.util.*;
import com.iii.apps.persistence.*;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.constants.PELConstants;

@Table(name = "PT_IL_BROK_DEDC_VALUES")
public class PT_IL_BROK_DEDC_VALUES extends BaseValueBean {

	@Column(name = "BDV_POL_SYS_ID")
	private Long BDV_POL_SYS_ID;
	
	@Column(name = "BDV_PC_SYS_ID")
	private Long BDV_PC_SYS_ID;
	
	@Column(name = "BDV_BV_SYS_ID")
	private Long BDV_BV_SYS_ID;
	
	@Column(name = "BDV_FLEX_30")
	private String BDV_FLEX_30;

	@Column(name = "BDV_FLEX_28")
	private String BDV_FLEX_28;

	@Column(name = "BDV_FLEX_29")
	private String BDV_FLEX_29;

	@Column(name = "BDV_FLEX_01")
	private String BDV_FLEX_01;

	@Column(name = "BDV_FLEX_02")
	private String BDV_FLEX_02;

	@Column(name = "BDV_FLEX_03")
	private String BDV_FLEX_03;

	@Column(name = "BDV_FLEX_04")
	private String BDV_FLEX_04;

	@Column(name = "BDV_FLEX_05")
	private String BDV_FLEX_05;

	@Column(name = "BDV_FLEX_06")
	private String BDV_FLEX_06;

	@Column(name = "BDV_FLEX_07")
	private String BDV_FLEX_07;

	@Column(name = "BDV_FLEX_08")
	private String BDV_FLEX_08;

	@Column(name = "BDV_FLEX_09")
	private String BDV_FLEX_09;

	@Column(name = "BDV_FLEX_10")
	private String BDV_FLEX_10;

	@Column(name = "BDV_FLEX_11")
	private String BDV_FLEX_11;

	@Column(name = "BDV_FLEX_12")
	private String BDV_FLEX_12;

	@Column(name = "BDV_FLEX_13")
	private String BDV_FLEX_13;

	@Column(name = "BDV_FLEX_14")
	private String BDV_FLEX_14;

	@Column(name = "BDV_FLEX_15")
	private String BDV_FLEX_15;

	@Column(name = "BDV_FLEX_16")
	private String BDV_FLEX_16;

	@Column(name = "BDV_FLEX_17")
	private String BDV_FLEX_17;

	@Column(name = "BDV_FLEX_18")
	private String BDV_FLEX_18;

	@Column(name = "BDV_FLEX_19")
	private String BDV_FLEX_19;

	@Column(name = "BDV_FLEX_20")
	private String BDV_FLEX_20;

	@Column(name = "BDV_FLEX_21")
	private String BDV_FLEX_21;

	@Column(name = "BDV_FLEX_22")
	private String BDV_FLEX_22;

	@Column(name = "BDV_FLEX_23")
	private String BDV_FLEX_23;

	@Column(name = "BDV_FLEX_24")
	private String BDV_FLEX_24;

	@Column(name = "BDV_FLEX_25")
	private String BDV_FLEX_25;

	@Column(name = "BDV_FLEX_26")
	private String BDV_FLEX_26;

	@Column(name = "BDV_FLEX_27")
	private String BDV_FLEX_27;

	@Column(name = "BDV_BROKER_CODE")
	private String BDV_BROKER_CODE;

	private String UI_M_BDV_BROKER_DESC;

	@Column(name = "BDV_CODE")
	private String BDV_CODE;

	@Column(name = "BDV_RATE")
	private Double BDV_RATE;

	@Column(name = "BDV_RATE_PER")
	private Double BDV_RATE_PER;

	@Column(name = "BDV_FC_VALUE")
	private Double BDV_FC_VALUE;

	@Column(name = "BDV_LC_VALUE")
	private Double BDV_LC_VALUE;

	private String UI_M_BDV_CODE_DESC;

	public String getBDV_FLEX_30() {
		return BDV_FLEX_30;
	}

	public void setBDV_FLEX_30(String BDV_FLEX_30) {
		this.BDV_FLEX_30 = BDV_FLEX_30;
	}

	public String getBDV_FLEX_28() {
		return BDV_FLEX_28;
	}

	public void setBDV_FLEX_28(String BDV_FLEX_28) {
		this.BDV_FLEX_28 = BDV_FLEX_28;
	}

	public String getBDV_FLEX_29() {
		return BDV_FLEX_29;
	}

	public void setBDV_FLEX_29(String BDV_FLEX_29) {
		this.BDV_FLEX_29 = BDV_FLEX_29;
	}

	public String getBDV_FLEX_01() {
		return BDV_FLEX_01;
	}

	public void setBDV_FLEX_01(String BDV_FLEX_01) {
		this.BDV_FLEX_01 = BDV_FLEX_01;
	}

	public String getBDV_FLEX_02() {
		return BDV_FLEX_02;
	}

	public void setBDV_FLEX_02(String BDV_FLEX_02) {
		this.BDV_FLEX_02 = BDV_FLEX_02;
	}

	public String getBDV_FLEX_03() {
		return BDV_FLEX_03;
	}

	public void setBDV_FLEX_03(String BDV_FLEX_03) {
		this.BDV_FLEX_03 = BDV_FLEX_03;
	}

	public String getBDV_FLEX_04() {
		return BDV_FLEX_04;
	}

	public void setBDV_FLEX_04(String BDV_FLEX_04) {
		this.BDV_FLEX_04 = BDV_FLEX_04;
	}

	public String getBDV_FLEX_05() {
		return BDV_FLEX_05;
	}

	public void setBDV_FLEX_05(String BDV_FLEX_05) {
		this.BDV_FLEX_05 = BDV_FLEX_05;
	}

	public String getBDV_FLEX_06() {
		return BDV_FLEX_06;
	}

	public void setBDV_FLEX_06(String BDV_FLEX_06) {
		this.BDV_FLEX_06 = BDV_FLEX_06;
	}

	public String getBDV_FLEX_07() {
		return BDV_FLEX_07;
	}

	public void setBDV_FLEX_07(String BDV_FLEX_07) {
		this.BDV_FLEX_07 = BDV_FLEX_07;
	}

	public String getBDV_FLEX_08() {
		return BDV_FLEX_08;
	}

	public void setBDV_FLEX_08(String BDV_FLEX_08) {
		this.BDV_FLEX_08 = BDV_FLEX_08;
	}

	public String getBDV_FLEX_09() {
		return BDV_FLEX_09;
	}

	public void setBDV_FLEX_09(String BDV_FLEX_09) {
		this.BDV_FLEX_09 = BDV_FLEX_09;
	}

	public String getBDV_FLEX_10() {
		return BDV_FLEX_10;
	}

	public void setBDV_FLEX_10(String BDV_FLEX_10) {
		this.BDV_FLEX_10 = BDV_FLEX_10;
	}

	public String getBDV_FLEX_11() {
		return BDV_FLEX_11;
	}

	public void setBDV_FLEX_11(String BDV_FLEX_11) {
		this.BDV_FLEX_11 = BDV_FLEX_11;
	}

	public String getBDV_FLEX_12() {
		return BDV_FLEX_12;
	}

	public void setBDV_FLEX_12(String BDV_FLEX_12) {
		this.BDV_FLEX_12 = BDV_FLEX_12;
	}

	public String getBDV_FLEX_13() {
		return BDV_FLEX_13;
	}

	public void setBDV_FLEX_13(String BDV_FLEX_13) {
		this.BDV_FLEX_13 = BDV_FLEX_13;
	}

	public String getBDV_FLEX_14() {
		return BDV_FLEX_14;
	}

	public void setBDV_FLEX_14(String BDV_FLEX_14) {
		this.BDV_FLEX_14 = BDV_FLEX_14;
	}

	public String getBDV_FLEX_15() {
		return BDV_FLEX_15;
	}

	public void setBDV_FLEX_15(String BDV_FLEX_15) {
		this.BDV_FLEX_15 = BDV_FLEX_15;
	}

	public String getBDV_FLEX_16() {
		return BDV_FLEX_16;
	}

	public void setBDV_FLEX_16(String BDV_FLEX_16) {
		this.BDV_FLEX_16 = BDV_FLEX_16;
	}

	public String getBDV_FLEX_17() {
		return BDV_FLEX_17;
	}

	public void setBDV_FLEX_17(String BDV_FLEX_17) {
		this.BDV_FLEX_17 = BDV_FLEX_17;
	}

	public String getBDV_FLEX_18() {
		return BDV_FLEX_18;
	}

	public void setBDV_FLEX_18(String BDV_FLEX_18) {
		this.BDV_FLEX_18 = BDV_FLEX_18;
	}

	public String getBDV_FLEX_19() {
		return BDV_FLEX_19;
	}

	public void setBDV_FLEX_19(String BDV_FLEX_19) {
		this.BDV_FLEX_19 = BDV_FLEX_19;
	}

	public String getBDV_FLEX_20() {
		return BDV_FLEX_20;
	}

	public void setBDV_FLEX_20(String BDV_FLEX_20) {
		this.BDV_FLEX_20 = BDV_FLEX_20;
	}

	public String getBDV_FLEX_21() {
		return BDV_FLEX_21;
	}

	public void setBDV_FLEX_21(String BDV_FLEX_21) {
		this.BDV_FLEX_21 = BDV_FLEX_21;
	}

	public String getBDV_FLEX_22() {
		return BDV_FLEX_22;
	}

	public void setBDV_FLEX_22(String BDV_FLEX_22) {
		this.BDV_FLEX_22 = BDV_FLEX_22;
	}

	public String getBDV_FLEX_23() {
		return BDV_FLEX_23;
	}

	public void setBDV_FLEX_23(String BDV_FLEX_23) {
		this.BDV_FLEX_23 = BDV_FLEX_23;
	}

	public String getBDV_FLEX_24() {
		return BDV_FLEX_24;
	}

	public void setBDV_FLEX_24(String BDV_FLEX_24) {
		this.BDV_FLEX_24 = BDV_FLEX_24;
	}

	public String getBDV_FLEX_25() {
		return BDV_FLEX_25;
	}

	public void setBDV_FLEX_25(String BDV_FLEX_25) {
		this.BDV_FLEX_25 = BDV_FLEX_25;
	}

	public String getBDV_FLEX_26() {
		return BDV_FLEX_26;
	}

	public void setBDV_FLEX_26(String BDV_FLEX_26) {
		this.BDV_FLEX_26 = BDV_FLEX_26;
	}

	public String getBDV_FLEX_27() {
		return BDV_FLEX_27;
	}

	public void setBDV_FLEX_27(String BDV_FLEX_27) {
		this.BDV_FLEX_27 = BDV_FLEX_27;
	}

	public String getBDV_BROKER_CODE() {
		return BDV_BROKER_CODE;
	}

	public void setBDV_BROKER_CODE(String BDV_BROKER_CODE) {
		this.BDV_BROKER_CODE = BDV_BROKER_CODE;
	}

	public String getUI_M_BDV_BROKER_DESC() {
		return UI_M_BDV_BROKER_DESC;
	}

	public void setUI_M_BDV_BROKER_DESC(String UI_M_BDV_BROKER_DESC) {
		this.UI_M_BDV_BROKER_DESC = UI_M_BDV_BROKER_DESC;
	}

	public String getBDV_CODE() {
		return BDV_CODE;
	}

	public void setBDV_CODE(String BDV_CODE) {
		this.BDV_CODE = BDV_CODE;
	}

	public Double getBDV_RATE() {
		return BDV_RATE;
	}

	public void setBDV_RATE(Double BDV_RATE) {
		this.BDV_RATE = BDV_RATE;
	}

	public Double getBDV_RATE_PER() {
		return BDV_RATE_PER;
	}

	public void setBDV_RATE_PER(Double BDV_RATE_PER) {
		this.BDV_RATE_PER = BDV_RATE_PER;
	}

	public Double getBDV_FC_VALUE() {
		return BDV_FC_VALUE;
	}

	public void setBDV_FC_VALUE(Double BDV_FC_VALUE) {
		this.BDV_FC_VALUE = BDV_FC_VALUE;
	}

	public Double getBDV_LC_VALUE() {
		return BDV_LC_VALUE;
	}

	public void setBDV_LC_VALUE(Double BDV_LC_VALUE) {
		this.BDV_LC_VALUE = BDV_LC_VALUE;
	}

	public String getUI_M_BDV_CODE_DESC() {
		return UI_M_BDV_CODE_DESC;
	}

	public void setUI_M_BDV_CODE_DESC(String UI_M_BDV_CODE_DESC) {
		this.UI_M_BDV_CODE_DESC = UI_M_BDV_CODE_DESC;
	}

	public Long getBDV_POL_SYS_ID() {
		return BDV_POL_SYS_ID;
	}

	public void setBDV_POL_SYS_ID(Long bdv_pol_sys_id) {
		BDV_POL_SYS_ID = bdv_pol_sys_id;
	}

	public Long getBDV_PC_SYS_ID() {
		return BDV_PC_SYS_ID;
	}

	public void setBDV_PC_SYS_ID(Long bdv_pc_sys_id) {
		BDV_PC_SYS_ID = bdv_pc_sys_id;
	}

	public Long getBDV_BV_SYS_ID() {
		return BDV_BV_SYS_ID;
	}

	public void setBDV_BV_SYS_ID(Long bdv_bv_sys_id) {
		BDV_BV_SYS_ID = bdv_bv_sys_id;
	}
}