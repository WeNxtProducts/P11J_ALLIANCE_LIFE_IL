package com.iii.pel.forms.PILT024;

import java.io.*;
import java.util.*;
import com.iii.apps.persistence.*;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.constants.PELConstants;

@Table(name = "PT_AGENT_COMM_VALUES")
public class PT_AGENT_COMM_VALUES extends BaseValueBean {

	@Column(name = "ACV_FLEX_30")
	private String ACV_FLEX_30;

	@Column(name = "ACV_FLEX_25")
	private String ACV_FLEX_25;

	@Column(name = "ACV_FLEX_26")
	private String ACV_FLEX_26;

	@Column(name = "ACV_FLEX_29")
	private String ACV_FLEX_29;

	@Column(name = "ACV_FLEX_28")
	private String ACV_FLEX_28;

	@Column(name = "ACV_FLEX_27")
	private String ACV_FLEX_27;

	@Column(name = "ACV_FLEX_01")
	private String ACV_FLEX_01;

	@Column(name = "ACV_FLEX_02")
	private String ACV_FLEX_02;

	@Column(name = "ACV_FLEX_03")
	private String ACV_FLEX_03;

	@Column(name = "ACV_FLEX_04")
	private String ACV_FLEX_04;

	@Column(name = "ACV_FLEX_05")
	private String ACV_FLEX_05;

	@Column(name = "ACV_FLEX_06")
	private String ACV_FLEX_06;

	@Column(name = "ACV_FLEX_07")
	private String ACV_FLEX_07;

	@Column(name = "ACV_FLEX_08")
	private String ACV_FLEX_08;

	@Column(name = "ACV_FLEX_09")
	private String ACV_FLEX_09;

	@Column(name = "ACV_FLEX_10")
	private String ACV_FLEX_10;

	@Column(name = "ACV_FLEX_11")
	private String ACV_FLEX_11;

	@Column(name = "ACV_FLEX_12")
	private String ACV_FLEX_12;

	@Column(name = "ACV_FLEX_13")
	private String ACV_FLEX_13;

	@Column(name = "ACV_FLEX_14")
	private String ACV_FLEX_14;

	@Column(name = "ACV_FLEX_15")
	private String ACV_FLEX_15;

	@Column(name = "ACV_FLEX_16")
	private String ACV_FLEX_16;

	@Column(name = "ACV_FLEX_17")
	private String ACV_FLEX_17;

	@Column(name = "ACV_FLEX_18")
	private String ACV_FLEX_18;

	@Column(name = "ACV_FLEX_19")
	private String ACV_FLEX_19;

	@Column(name = "ACV_FLEX_20")
	private String ACV_FLEX_20;

	@Column(name = "ACV_FLEX_21")
	private String ACV_FLEX_21;

	@Column(name = "ACV_FLEX_22")
	private String ACV_FLEX_22;

	@Column(name = "ACV_FLEX_23")
	private String ACV_FLEX_23;

	@Column(name = "ACV_FLEX_24")
	private String ACV_FLEX_24;

	@Column(name = "ACV_AGENT_CODE")
	private String ACV_AGENT_CODE;

	@Column(name = "ACV_COMM_CODE")
	private String ACV_COMM_CODE;

	@Column(name = "ACV_LEVEL")
	private Double ACV_LEVEL;

	@Column(name = "ACV_YEAR")
	private Double ACV_YEAR;

	@Column(name = "ACV_RATE")
	private Double ACV_RATE;

	@Column(name = "ACV_RATE_PER")
	private Double ACV_RATE_PER;

	@Column(name = "ACV_FC_VALUE")
	private Double ACV_FC_VALUE;

	@Column(name = "ACV_LC_VALUE")
	private Double ACV_LC_VALUE;

	@Column(name = "UI_M_ACV_AGENT_DESC")
	private String UI_M_ACV_AGENT_DESC;

	@Column(name = "UI_M_ACV_COMM_DESC")
	private String UI_M_ACV_COMM_DESC;

	@Column(name = "ACV_COVER_CODE")
	private String ACV_COVER_CODE;

	@Column(name = "UI_M_ACV_COVER_DESC")
	private String UI_M_ACV_COVER_DESC;

	@Column(name = "ACV_AGENT_RANK_CODE")
	private String ACV_AGENT_RANK_CODE;

	@Column(name = "UI_M_ACV_AGENT_RANK_CODE")
	private String UI_M_ACV_AGENT_RANK_CODE;

	@Column(name = "ACV_COMM_TYPE")
	private String ACV_COMM_TYPE;

	@Column(name = "ACV_TOT_FC_DED")
	private Double ACV_TOT_FC_DED;

	@Column(name = "ACV_TOT_LC_DED")
	private Double ACV_TOT_LC_DED;

	@Column(name = "ACV_NET_FC_VALUE")
	private Double ACV_NET_FC_VALUE;

	@Column(name = "ACV_NET_LC_VALUE")
	private Double ACV_NET_LC_VALUE;

	public String getACV_FLEX_30() {
		return ACV_FLEX_30;
	}

	public void setACV_FLEX_30(String ACV_FLEX_30) {
		this.ACV_FLEX_30 = ACV_FLEX_30;
	}

	public String getACV_FLEX_25() {
		return ACV_FLEX_25;
	}

	public void setACV_FLEX_25(String ACV_FLEX_25) {
		this.ACV_FLEX_25 = ACV_FLEX_25;
	}

	public String getACV_FLEX_26() {
		return ACV_FLEX_26;
	}

	public void setACV_FLEX_26(String ACV_FLEX_26) {
		this.ACV_FLEX_26 = ACV_FLEX_26;
	}

	public String getACV_FLEX_29() {
		return ACV_FLEX_29;
	}

	public void setACV_FLEX_29(String ACV_FLEX_29) {
		this.ACV_FLEX_29 = ACV_FLEX_29;
	}

	public String getACV_FLEX_28() {
		return ACV_FLEX_28;
	}

	public void setACV_FLEX_28(String ACV_FLEX_28) {
		this.ACV_FLEX_28 = ACV_FLEX_28;
	}

	public String getACV_FLEX_27() {
		return ACV_FLEX_27;
	}

	public void setACV_FLEX_27(String ACV_FLEX_27) {
		this.ACV_FLEX_27 = ACV_FLEX_27;
	}

	public String getACV_FLEX_01() {
		return ACV_FLEX_01;
	}

	public void setACV_FLEX_01(String ACV_FLEX_01) {
		this.ACV_FLEX_01 = ACV_FLEX_01;
	}

	public String getACV_FLEX_02() {
		return ACV_FLEX_02;
	}

	public void setACV_FLEX_02(String ACV_FLEX_02) {
		this.ACV_FLEX_02 = ACV_FLEX_02;
	}

	public String getACV_FLEX_03() {
		return ACV_FLEX_03;
	}

	public void setACV_FLEX_03(String ACV_FLEX_03) {
		this.ACV_FLEX_03 = ACV_FLEX_03;
	}

	public String getACV_FLEX_04() {
		return ACV_FLEX_04;
	}

	public void setACV_FLEX_04(String ACV_FLEX_04) {
		this.ACV_FLEX_04 = ACV_FLEX_04;
	}

	public String getACV_FLEX_05() {
		return ACV_FLEX_05;
	}

	public void setACV_FLEX_05(String ACV_FLEX_05) {
		this.ACV_FLEX_05 = ACV_FLEX_05;
	}

	public String getACV_FLEX_06() {
		return ACV_FLEX_06;
	}

	public void setACV_FLEX_06(String ACV_FLEX_06) {
		this.ACV_FLEX_06 = ACV_FLEX_06;
	}

	public String getACV_FLEX_07() {
		return ACV_FLEX_07;
	}

	public void setACV_FLEX_07(String ACV_FLEX_07) {
		this.ACV_FLEX_07 = ACV_FLEX_07;
	}

	public String getACV_FLEX_08() {
		return ACV_FLEX_08;
	}

	public void setACV_FLEX_08(String ACV_FLEX_08) {
		this.ACV_FLEX_08 = ACV_FLEX_08;
	}

	public String getACV_FLEX_09() {
		return ACV_FLEX_09;
	}

	public void setACV_FLEX_09(String ACV_FLEX_09) {
		this.ACV_FLEX_09 = ACV_FLEX_09;
	}

	public String getACV_FLEX_10() {
		return ACV_FLEX_10;
	}

	public void setACV_FLEX_10(String ACV_FLEX_10) {
		this.ACV_FLEX_10 = ACV_FLEX_10;
	}

	public String getACV_FLEX_11() {
		return ACV_FLEX_11;
	}

	public void setACV_FLEX_11(String ACV_FLEX_11) {
		this.ACV_FLEX_11 = ACV_FLEX_11;
	}

	public String getACV_FLEX_12() {
		return ACV_FLEX_12;
	}

	public void setACV_FLEX_12(String ACV_FLEX_12) {
		this.ACV_FLEX_12 = ACV_FLEX_12;
	}

	public String getACV_FLEX_13() {
		return ACV_FLEX_13;
	}

	public void setACV_FLEX_13(String ACV_FLEX_13) {
		this.ACV_FLEX_13 = ACV_FLEX_13;
	}

	public String getACV_FLEX_14() {
		return ACV_FLEX_14;
	}

	public void setACV_FLEX_14(String ACV_FLEX_14) {
		this.ACV_FLEX_14 = ACV_FLEX_14;
	}

	public String getACV_FLEX_15() {
		return ACV_FLEX_15;
	}

	public void setACV_FLEX_15(String ACV_FLEX_15) {
		this.ACV_FLEX_15 = ACV_FLEX_15;
	}

	public String getACV_FLEX_16() {
		return ACV_FLEX_16;
	}

	public void setACV_FLEX_16(String ACV_FLEX_16) {
		this.ACV_FLEX_16 = ACV_FLEX_16;
	}

	public String getACV_FLEX_17() {
		return ACV_FLEX_17;
	}

	public void setACV_FLEX_17(String ACV_FLEX_17) {
		this.ACV_FLEX_17 = ACV_FLEX_17;
	}

	public String getACV_FLEX_18() {
		return ACV_FLEX_18;
	}

	public void setACV_FLEX_18(String ACV_FLEX_18) {
		this.ACV_FLEX_18 = ACV_FLEX_18;
	}

	public String getACV_FLEX_19() {
		return ACV_FLEX_19;
	}

	public void setACV_FLEX_19(String ACV_FLEX_19) {
		this.ACV_FLEX_19 = ACV_FLEX_19;
	}

	public String getACV_FLEX_20() {
		return ACV_FLEX_20;
	}

	public void setACV_FLEX_20(String ACV_FLEX_20) {
		this.ACV_FLEX_20 = ACV_FLEX_20;
	}

	public String getACV_FLEX_21() {
		return ACV_FLEX_21;
	}

	public void setACV_FLEX_21(String ACV_FLEX_21) {
		this.ACV_FLEX_21 = ACV_FLEX_21;
	}

	public String getACV_FLEX_22() {
		return ACV_FLEX_22;
	}

	public void setACV_FLEX_22(String ACV_FLEX_22) {
		this.ACV_FLEX_22 = ACV_FLEX_22;
	}

	public String getACV_FLEX_23() {
		return ACV_FLEX_23;
	}

	public void setACV_FLEX_23(String ACV_FLEX_23) {
		this.ACV_FLEX_23 = ACV_FLEX_23;
	}

	public String getACV_FLEX_24() {
		return ACV_FLEX_24;
	}

	public void setACV_FLEX_24(String ACV_FLEX_24) {
		this.ACV_FLEX_24 = ACV_FLEX_24;
	}

	public String getACV_AGENT_CODE() {
		return ACV_AGENT_CODE;
	}

	public void setACV_AGENT_CODE(String ACV_AGENT_CODE) {
		this.ACV_AGENT_CODE = ACV_AGENT_CODE;
	}

	public String getACV_COMM_CODE() {
		return ACV_COMM_CODE;
	}

	public void setACV_COMM_CODE(String ACV_COMM_CODE) {
		this.ACV_COMM_CODE = ACV_COMM_CODE;
	}

	public Double getACV_LEVEL() {
		return ACV_LEVEL;
	}

	public void setACV_LEVEL(Double ACV_LEVEL) {
		this.ACV_LEVEL = ACV_LEVEL;
	}

	public Double getACV_YEAR() {
		return ACV_YEAR;
	}

	public void setACV_YEAR(Double ACV_YEAR) {
		this.ACV_YEAR = ACV_YEAR;
	}

	public Double getACV_RATE() {
		return ACV_RATE;
	}

	public void setACV_RATE(Double ACV_RATE) {
		this.ACV_RATE = ACV_RATE;
	}

	public Double getACV_RATE_PER() {
		return ACV_RATE_PER;
	}

	public void setACV_RATE_PER(Double ACV_RATE_PER) {
		this.ACV_RATE_PER = ACV_RATE_PER;
	}

	public Double getACV_FC_VALUE() {
		return ACV_FC_VALUE;
	}

	public void setACV_FC_VALUE(Double ACV_FC_VALUE) {
		this.ACV_FC_VALUE = ACV_FC_VALUE;
	}

	public Double getACV_LC_VALUE() {
		return ACV_LC_VALUE;
	}

	public void setACV_LC_VALUE(Double ACV_LC_VALUE) {
		this.ACV_LC_VALUE = ACV_LC_VALUE;
	}

	public String getUI_M_ACV_AGENT_DESC() {
		return UI_M_ACV_AGENT_DESC;
	}

	public void setUI_M_ACV_AGENT_DESC(String UI_M_ACV_AGENT_DESC) {
		this.UI_M_ACV_AGENT_DESC = UI_M_ACV_AGENT_DESC;
	}

	public String getUI_M_ACV_COMM_DESC() {
		return UI_M_ACV_COMM_DESC;
	}

	public void setUI_M_ACV_COMM_DESC(String UI_M_ACV_COMM_DESC) {
		this.UI_M_ACV_COMM_DESC = UI_M_ACV_COMM_DESC;
	}

	public String getACV_COVER_CODE() {
		return ACV_COVER_CODE;
	}

	public void setACV_COVER_CODE(String ACV_COVER_CODE) {
		this.ACV_COVER_CODE = ACV_COVER_CODE;
	}

	public String getUI_M_ACV_COVER_DESC() {
		return UI_M_ACV_COVER_DESC;
	}

	public void setUI_M_ACV_COVER_DESC(String UI_M_ACV_COVER_DESC) {
		this.UI_M_ACV_COVER_DESC = UI_M_ACV_COVER_DESC;
	}

	public String getACV_AGENT_RANK_CODE() {
		return ACV_AGENT_RANK_CODE;
	}

	public void setACV_AGENT_RANK_CODE(String ACV_AGENT_RANK_CODE) {
		this.ACV_AGENT_RANK_CODE = ACV_AGENT_RANK_CODE;
	}

	public String getUI_M_ACV_AGENT_RANK_CODE() {
		return UI_M_ACV_AGENT_RANK_CODE;
	}

	public void setUI_M_ACV_AGENT_RANK_CODE(String UI_M_ACV_AGENT_RANK_CODE) {
		this.UI_M_ACV_AGENT_RANK_CODE = UI_M_ACV_AGENT_RANK_CODE;
	}

	public String getACV_COMM_TYPE() {
		return ACV_COMM_TYPE;
	}

	public void setACV_COMM_TYPE(String ACV_COMM_TYPE) {
		this.ACV_COMM_TYPE = ACV_COMM_TYPE;
	}

	public Double getACV_TOT_FC_DED() {
		return ACV_TOT_FC_DED;
	}

	public void setACV_TOT_FC_DED(Double ACV_TOT_FC_DED) {
		this.ACV_TOT_FC_DED = ACV_TOT_FC_DED;
	}

	public Double getACV_TOT_LC_DED() {
		return ACV_TOT_LC_DED;
	}

	public void setACV_TOT_LC_DED(Double ACV_TOT_LC_DED) {
		this.ACV_TOT_LC_DED = ACV_TOT_LC_DED;
	}

	public Double getACV_NET_FC_VALUE() {
		return ACV_NET_FC_VALUE;
	}

	public void setACV_NET_FC_VALUE(Double ACV_NET_FC_VALUE) {
		this.ACV_NET_FC_VALUE = ACV_NET_FC_VALUE;
	}

	public Double getACV_NET_LC_VALUE() {
		return ACV_NET_LC_VALUE;
	}

	public void setACV_NET_LC_VALUE(Double ACV_NET_LC_VALUE) {
		this.ACV_NET_LC_VALUE = ACV_NET_LC_VALUE;
	}
}