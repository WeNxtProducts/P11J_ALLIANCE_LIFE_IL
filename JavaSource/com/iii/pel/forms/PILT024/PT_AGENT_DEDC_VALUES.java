package com.iii.pel.forms.PILT024;

import java.io.*;
import java.util.*;
import com.iii.apps.persistence.*;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.constants.PELConstants;

@Table(name = "PT_AGENT_DEDC_VALUES")
public class PT_AGENT_DEDC_VALUES extends BaseValueBean {

	@Column(name = "ADV_FLEX_30")
	private String ADV_FLEX_30;

	@Column(name = "ADV_FLEX_28")
	private String ADV_FLEX_28;

	@Column(name = "ADV_FLEX_29")
	private String ADV_FLEX_29;

	@Column(name = "ADV_FLEX_01")
	private String ADV_FLEX_01;

	@Column(name = "ADV_FLEX_02")
	private String ADV_FLEX_02;

	@Column(name = "ADV_FLEX_03")
	private String ADV_FLEX_03;

	@Column(name = "ADV_FLEX_04")
	private String ADV_FLEX_04;

	@Column(name = "ADV_FLEX_05")
	private String ADV_FLEX_05;

	@Column(name = "ADV_FLEX_06")
	private String ADV_FLEX_06;

	@Column(name = "ADV_FLEX_07")
	private String ADV_FLEX_07;

	@Column(name = "ADV_FLEX_08")
	private String ADV_FLEX_08;

	@Column(name = "ADV_FLEX_09")
	private String ADV_FLEX_09;

	@Column(name = "ADV_FLEX_10")
	private String ADV_FLEX_10;

	@Column(name = "ADV_FLEX_11")
	private String ADV_FLEX_11;

	@Column(name = "ADV_FLEX_12")
	private String ADV_FLEX_12;

	@Column(name = "ADV_FLEX_13")
	private String ADV_FLEX_13;

	@Column(name = "ADV_FLEX_14")
	private String ADV_FLEX_14;

	@Column(name = "ADV_FLEX_15")
	private String ADV_FLEX_15;

	@Column(name = "ADV_FLEX_16")
	private String ADV_FLEX_16;

	@Column(name = "ADV_FLEX_17")
	private String ADV_FLEX_17;

	@Column(name = "ADV_FLEX_18")
	private String ADV_FLEX_18;

	@Column(name = "ADV_FLEX_19")
	private String ADV_FLEX_19;

	@Column(name = "ADV_FLEX_20")
	private String ADV_FLEX_20;

	@Column(name = "ADV_FLEX_21")
	private String ADV_FLEX_21;

	@Column(name = "ADV_FLEX_22")
	private String ADV_FLEX_22;

	@Column(name = "ADV_FLEX_23")
	private String ADV_FLEX_23;

	@Column(name = "ADV_FLEX_24")
	private String ADV_FLEX_24;

	@Column(name = "ADV_FLEX_25")
	private String ADV_FLEX_25;

	@Column(name = "ADV_FLEX_26")
	private String ADV_FLEX_26;

	@Column(name = "ADV_FLEX_27")
	private String ADV_FLEX_27;

	@Column(name = "ADV_BROKER_CODE")
	private String ADV_BROKER_CODE;

	@Column(name = "UI_M_ADV_BROKER_DESC")
	private String UI_M_ADV_BROKER_DESC;

	@Column(name = "ADV_CODE")
	private String ADV_CODE;

	@Column(name = "ADV_RATE")
	private Double ADV_RATE;

	@Column(name = "ADV_RATE_PER")
	private Double ADV_RATE_PER;

	@Column(name = "ADV_FC_VALUE")
	private Double ADV_FC_VALUE;

	@Column(name = "ADV_LC_VALUE")
	private Double ADV_LC_VALUE;

	@Column(name = "UI_M_ADV_CODE_DESC")
	private String UI_M_ADV_CODE_DESC;

	public String getADV_FLEX_30() {
		return ADV_FLEX_30;
	}

	public void setADV_FLEX_30(String ADV_FLEX_30) {
		this.ADV_FLEX_30 = ADV_FLEX_30;
	}

	public String getADV_FLEX_28() {
		return ADV_FLEX_28;
	}

	public void setADV_FLEX_28(String ADV_FLEX_28) {
		this.ADV_FLEX_28 = ADV_FLEX_28;
	}

	public String getADV_FLEX_29() {
		return ADV_FLEX_29;
	}

	public void setADV_FLEX_29(String ADV_FLEX_29) {
		this.ADV_FLEX_29 = ADV_FLEX_29;
	}

	public String getADV_FLEX_01() {
		return ADV_FLEX_01;
	}

	public void setADV_FLEX_01(String ADV_FLEX_01) {
		this.ADV_FLEX_01 = ADV_FLEX_01;
	}

	public String getADV_FLEX_02() {
		return ADV_FLEX_02;
	}

	public void setADV_FLEX_02(String ADV_FLEX_02) {
		this.ADV_FLEX_02 = ADV_FLEX_02;
	}

	public String getADV_FLEX_03() {
		return ADV_FLEX_03;
	}

	public void setADV_FLEX_03(String ADV_FLEX_03) {
		this.ADV_FLEX_03 = ADV_FLEX_03;
	}

	public String getADV_FLEX_04() {
		return ADV_FLEX_04;
	}

	public void setADV_FLEX_04(String ADV_FLEX_04) {
		this.ADV_FLEX_04 = ADV_FLEX_04;
	}

	public String getADV_FLEX_05() {
		return ADV_FLEX_05;
	}

	public void setADV_FLEX_05(String ADV_FLEX_05) {
		this.ADV_FLEX_05 = ADV_FLEX_05;
	}

	public String getADV_FLEX_06() {
		return ADV_FLEX_06;
	}

	public void setADV_FLEX_06(String ADV_FLEX_06) {
		this.ADV_FLEX_06 = ADV_FLEX_06;
	}

	public String getADV_FLEX_07() {
		return ADV_FLEX_07;
	}

	public void setADV_FLEX_07(String ADV_FLEX_07) {
		this.ADV_FLEX_07 = ADV_FLEX_07;
	}

	public String getADV_FLEX_08() {
		return ADV_FLEX_08;
	}

	public void setADV_FLEX_08(String ADV_FLEX_08) {
		this.ADV_FLEX_08 = ADV_FLEX_08;
	}

	public String getADV_FLEX_09() {
		return ADV_FLEX_09;
	}

	public void setADV_FLEX_09(String ADV_FLEX_09) {
		this.ADV_FLEX_09 = ADV_FLEX_09;
	}

	public String getADV_FLEX_10() {
		return ADV_FLEX_10;
	}

	public void setADV_FLEX_10(String ADV_FLEX_10) {
		this.ADV_FLEX_10 = ADV_FLEX_10;
	}

	public String getADV_FLEX_11() {
		return ADV_FLEX_11;
	}

	public void setADV_FLEX_11(String ADV_FLEX_11) {
		this.ADV_FLEX_11 = ADV_FLEX_11;
	}

	public String getADV_FLEX_12() {
		return ADV_FLEX_12;
	}

	public void setADV_FLEX_12(String ADV_FLEX_12) {
		this.ADV_FLEX_12 = ADV_FLEX_12;
	}

	public String getADV_FLEX_13() {
		return ADV_FLEX_13;
	}

	public void setADV_FLEX_13(String ADV_FLEX_13) {
		this.ADV_FLEX_13 = ADV_FLEX_13;
	}

	public String getADV_FLEX_14() {
		return ADV_FLEX_14;
	}

	public void setADV_FLEX_14(String ADV_FLEX_14) {
		this.ADV_FLEX_14 = ADV_FLEX_14;
	}

	public String getADV_FLEX_15() {
		return ADV_FLEX_15;
	}

	public void setADV_FLEX_15(String ADV_FLEX_15) {
		this.ADV_FLEX_15 = ADV_FLEX_15;
	}

	public String getADV_FLEX_16() {
		return ADV_FLEX_16;
	}

	public void setADV_FLEX_16(String ADV_FLEX_16) {
		this.ADV_FLEX_16 = ADV_FLEX_16;
	}

	public String getADV_FLEX_17() {
		return ADV_FLEX_17;
	}

	public void setADV_FLEX_17(String ADV_FLEX_17) {
		this.ADV_FLEX_17 = ADV_FLEX_17;
	}

	public String getADV_FLEX_18() {
		return ADV_FLEX_18;
	}

	public void setADV_FLEX_18(String ADV_FLEX_18) {
		this.ADV_FLEX_18 = ADV_FLEX_18;
	}

	public String getADV_FLEX_19() {
		return ADV_FLEX_19;
	}

	public void setADV_FLEX_19(String ADV_FLEX_19) {
		this.ADV_FLEX_19 = ADV_FLEX_19;
	}

	public String getADV_FLEX_20() {
		return ADV_FLEX_20;
	}

	public void setADV_FLEX_20(String ADV_FLEX_20) {
		this.ADV_FLEX_20 = ADV_FLEX_20;
	}

	public String getADV_FLEX_21() {
		return ADV_FLEX_21;
	}

	public void setADV_FLEX_21(String ADV_FLEX_21) {
		this.ADV_FLEX_21 = ADV_FLEX_21;
	}

	public String getADV_FLEX_22() {
		return ADV_FLEX_22;
	}

	public void setADV_FLEX_22(String ADV_FLEX_22) {
		this.ADV_FLEX_22 = ADV_FLEX_22;
	}

	public String getADV_FLEX_23() {
		return ADV_FLEX_23;
	}

	public void setADV_FLEX_23(String ADV_FLEX_23) {
		this.ADV_FLEX_23 = ADV_FLEX_23;
	}

	public String getADV_FLEX_24() {
		return ADV_FLEX_24;
	}

	public void setADV_FLEX_24(String ADV_FLEX_24) {
		this.ADV_FLEX_24 = ADV_FLEX_24;
	}

	public String getADV_FLEX_25() {
		return ADV_FLEX_25;
	}

	public void setADV_FLEX_25(String ADV_FLEX_25) {
		this.ADV_FLEX_25 = ADV_FLEX_25;
	}

	public String getADV_FLEX_26() {
		return ADV_FLEX_26;
	}

	public void setADV_FLEX_26(String ADV_FLEX_26) {
		this.ADV_FLEX_26 = ADV_FLEX_26;
	}

	public String getADV_FLEX_27() {
		return ADV_FLEX_27;
	}

	public void setADV_FLEX_27(String ADV_FLEX_27) {
		this.ADV_FLEX_27 = ADV_FLEX_27;
	}

	public String getADV_BROKER_CODE() {
		return ADV_BROKER_CODE;
	}

	public void setADV_BROKER_CODE(String ADV_BROKER_CODE) {
		this.ADV_BROKER_CODE = ADV_BROKER_CODE;
	}

	public String getUI_M_ADV_BROKER_DESC() {
		return UI_M_ADV_BROKER_DESC;
	}

	public void setUI_M_ADV_BROKER_DESC(String UI_M_ADV_BROKER_DESC) {
		this.UI_M_ADV_BROKER_DESC = UI_M_ADV_BROKER_DESC;
	}

	public String getADV_CODE() {
		return ADV_CODE;
	}

	public void setADV_CODE(String ADV_CODE) {
		this.ADV_CODE = ADV_CODE;
	}

	public Double getADV_RATE() {
		return ADV_RATE;
	}

	public void setADV_RATE(Double ADV_RATE) {
		this.ADV_RATE = ADV_RATE;
	}

	public Double getADV_RATE_PER() {
		return ADV_RATE_PER;
	}

	public void setADV_RATE_PER(Double ADV_RATE_PER) {
		this.ADV_RATE_PER = ADV_RATE_PER;
	}

	public Double getADV_FC_VALUE() {
		return ADV_FC_VALUE;
	}

	public void setADV_FC_VALUE(Double ADV_FC_VALUE) {
		this.ADV_FC_VALUE = ADV_FC_VALUE;
	}

	public Double getADV_LC_VALUE() {
		return ADV_LC_VALUE;
	}

	public void setADV_LC_VALUE(Double ADV_LC_VALUE) {
		this.ADV_LC_VALUE = ADV_LC_VALUE;
	}

	public String getUI_M_ADV_CODE_DESC() {
		return UI_M_ADV_CODE_DESC;
	}

	public void setUI_M_ADV_CODE_DESC(String UI_M_ADV_CODE_DESC) {
		this.UI_M_ADV_CODE_DESC = UI_M_ADV_CODE_DESC;
	}
}