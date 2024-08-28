package com.iii.pel.forms.PILT024;

import java.io.*;
import java.util.*;
import com.iii.apps.persistence.*;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.constants.PELConstants;

@Table(name = "PT_IL_BROKER_VALUES")
public class PT_IL_BROKER_VALUES extends BaseValueBean {

	@Column(name = "BV_FLEX_30")
	private String BV_FLEX_30;

	@Column(name = "BV_FLEX_27")
	private String BV_FLEX_27;

	@Column(name = "BV_FLEX_28")
	private String BV_FLEX_28;

	@Column(name = "BV_FLEX_29")
	private String BV_FLEX_29;

	@Column(name = "BV_FLEX_01")
	private String BV_FLEX_01;

	@Column(name = "BV_FLEX_02")
	private String BV_FLEX_02;

	@Column(name = "BV_FLEX_03")
	private String BV_FLEX_03;

	@Column(name = "BV_FLEX_04")
	private String BV_FLEX_04;

	@Column(name = "BV_FLEX_05")
	private String BV_FLEX_05;

	@Column(name = "BV_FLEX_06")
	private String BV_FLEX_06;

	@Column(name = "BV_FLEX_07")
	private String BV_FLEX_07;

	@Column(name = "BV_FLEX_08")
	private String BV_FLEX_08;

	@Column(name = "BV_FLEX_09")
	private String BV_FLEX_09;

	@Column(name = "BV_FLEX_10")
	private String BV_FLEX_10;

	@Column(name = "BV_FLEX_11")
	private String BV_FLEX_11;

	@Column(name = "BV_FLEX_12")
	private String BV_FLEX_12;

	@Column(name = "BV_FLEX_13")
	private String BV_FLEX_13;

	@Column(name = "BV_FLEX_14")
	private String BV_FLEX_14;

	@Column(name = "BV_FLEX_15")
	private String BV_FLEX_15;

	@Column(name = "BV_FLEX_16")
	private String BV_FLEX_16;

	@Column(name = "BV_FLEX_17")
	private String BV_FLEX_17;

	@Column(name = "BV_FLEX_18")
	private String BV_FLEX_18;

	@Column(name = "BV_FLEX_19")
	private String BV_FLEX_19;

	@Column(name = "BV_FLEX_20")
	private String BV_FLEX_20;

	@Column(name = "BV_FLEX_21")
	private String BV_FLEX_21;

	@Column(name = "BV_FLEX_22")
	private String BV_FLEX_22;

	@Column(name = "BV_FLEX_23")
	private String BV_FLEX_23;

	@Column(name = "BV_FLEX_24")
	private String BV_FLEX_24;

	@Column(name = "BV_FLEX_25")
	private String BV_FLEX_25;

	@Column(name = "BV_FLEX_26")
	private String BV_FLEX_26;

	@Column(name = "BV_BROKER_CODE")
	private String BV_BROKER_CODE;

	@Column(name = "BV_COVER_CODE")
	private String BV_COVER_CODE;

	@Column(name = "BV_COMM_CODE")
	private String BV_COMM_CODE;

	@Column(name = "BV_YEAR")
	private Integer BV_YEAR;

	@Column(name = "BV_RATE")
	private Double BV_RATE;

	@Column(name = "BV_RATE_PER")
	private Integer BV_RATE_PER;

	@Column(name = "BV_FC_VALUE")
	private Double BV_FC_VALUE;

	@Column(name = "UI_M_BROKER_DESC")
	private String UI_M_BROKER_DESC;

	@Column(name = "UI_M_COVER_DESC")
	private String UI_M_COVER_DESC;

	@Column(name = "BV_LC_VALUE")
	private Double BV_LC_VALUE;

	@Column(name = "BV_TOT_FC_DED")
	private Double BV_TOT_FC_DED;

	@Column(name = "BV_TOT_LC_DED")
	private Double BV_TOT_LC_DED;

	@Column(name = "BV_NET_FC_VALUE")
	private Double BV_NET_FC_VALUE;

	@Column(name = "BV_NET_LC_VALUE")
	private Double BV_NET_LC_VALUE;
	
	@Column(name = "BV_POL_SYS_ID")
	private Long BV_POL_SYS_ID;
	
	@Column(name = "BV_PC_SYS_ID")
	private Long BV_PC_SYS_ID;
	
	@Column(name = "BV_CURR_CODE")
	private String BV_CURR_CODE;
	
	@Column(name = "BV_SYS_ID")
	private Long BV_SYS_ID;
	

	public Long getBV_SYS_ID() {
		return BV_SYS_ID;
	}

	public void setBV_SYS_ID(Long bv_sys_id) {
		BV_SYS_ID = bv_sys_id;
	}

	public String getBV_FLEX_30() {
		return BV_FLEX_30;
	}

	public void setBV_FLEX_30(String BV_FLEX_30) {
		this.BV_FLEX_30 = BV_FLEX_30;
	}

	public String getBV_FLEX_27() {
		return BV_FLEX_27;
	}

	public void setBV_FLEX_27(String BV_FLEX_27) {
		this.BV_FLEX_27 = BV_FLEX_27;
	}

	public String getBV_FLEX_28() {
		return BV_FLEX_28;
	}

	public void setBV_FLEX_28(String BV_FLEX_28) {
		this.BV_FLEX_28 = BV_FLEX_28;
	}

	public String getBV_FLEX_29() {
		return BV_FLEX_29;
	}

	public void setBV_FLEX_29(String BV_FLEX_29) {
		this.BV_FLEX_29 = BV_FLEX_29;
	}

	public String getBV_FLEX_01() {
		return BV_FLEX_01;
	}

	public void setBV_FLEX_01(String BV_FLEX_01) {
		this.BV_FLEX_01 = BV_FLEX_01;
	}

	public String getBV_FLEX_02() {
		return BV_FLEX_02;
	}

	public void setBV_FLEX_02(String BV_FLEX_02) {
		this.BV_FLEX_02 = BV_FLEX_02;
	}

	public String getBV_FLEX_03() {
		return BV_FLEX_03;
	}

	public void setBV_FLEX_03(String BV_FLEX_03) {
		this.BV_FLEX_03 = BV_FLEX_03;
	}

	public String getBV_FLEX_04() {
		return BV_FLEX_04;
	}

	public void setBV_FLEX_04(String BV_FLEX_04) {
		this.BV_FLEX_04 = BV_FLEX_04;
	}

	public String getBV_FLEX_05() {
		return BV_FLEX_05;
	}

	public void setBV_FLEX_05(String BV_FLEX_05) {
		this.BV_FLEX_05 = BV_FLEX_05;
	}

	public String getBV_FLEX_06() {
		return BV_FLEX_06;
	}

	public void setBV_FLEX_06(String BV_FLEX_06) {
		this.BV_FLEX_06 = BV_FLEX_06;
	}

	public String getBV_FLEX_07() {
		return BV_FLEX_07;
	}

	public void setBV_FLEX_07(String BV_FLEX_07) {
		this.BV_FLEX_07 = BV_FLEX_07;
	}

	public String getBV_FLEX_08() {
		return BV_FLEX_08;
	}

	public void setBV_FLEX_08(String BV_FLEX_08) {
		this.BV_FLEX_08 = BV_FLEX_08;
	}

	public String getBV_FLEX_09() {
		return BV_FLEX_09;
	}

	public void setBV_FLEX_09(String BV_FLEX_09) {
		this.BV_FLEX_09 = BV_FLEX_09;
	}

	public String getBV_FLEX_10() {
		return BV_FLEX_10;
	}

	public void setBV_FLEX_10(String BV_FLEX_10) {
		this.BV_FLEX_10 = BV_FLEX_10;
	}

	public String getBV_FLEX_11() {
		return BV_FLEX_11;
	}

	public void setBV_FLEX_11(String BV_FLEX_11) {
		this.BV_FLEX_11 = BV_FLEX_11;
	}

	public String getBV_FLEX_12() {
		return BV_FLEX_12;
	}

	public void setBV_FLEX_12(String BV_FLEX_12) {
		this.BV_FLEX_12 = BV_FLEX_12;
	}

	public String getBV_FLEX_13() {
		return BV_FLEX_13;
	}

	public void setBV_FLEX_13(String BV_FLEX_13) {
		this.BV_FLEX_13 = BV_FLEX_13;
	}

	public String getBV_FLEX_14() {
		return BV_FLEX_14;
	}

	public void setBV_FLEX_14(String BV_FLEX_14) {
		this.BV_FLEX_14 = BV_FLEX_14;
	}

	public String getBV_FLEX_15() {
		return BV_FLEX_15;
	}

	public void setBV_FLEX_15(String BV_FLEX_15) {
		this.BV_FLEX_15 = BV_FLEX_15;
	}

	public String getBV_FLEX_16() {
		return BV_FLEX_16;
	}

	public void setBV_FLEX_16(String BV_FLEX_16) {
		this.BV_FLEX_16 = BV_FLEX_16;
	}

	public String getBV_FLEX_17() {
		return BV_FLEX_17;
	}

	public void setBV_FLEX_17(String BV_FLEX_17) {
		this.BV_FLEX_17 = BV_FLEX_17;
	}

	public String getBV_FLEX_18() {
		return BV_FLEX_18;
	}

	public void setBV_FLEX_18(String BV_FLEX_18) {
		this.BV_FLEX_18 = BV_FLEX_18;
	}

	public String getBV_FLEX_19() {
		return BV_FLEX_19;
	}

	public void setBV_FLEX_19(String BV_FLEX_19) {
		this.BV_FLEX_19 = BV_FLEX_19;
	}

	public String getBV_FLEX_20() {
		return BV_FLEX_20;
	}

	public void setBV_FLEX_20(String BV_FLEX_20) {
		this.BV_FLEX_20 = BV_FLEX_20;
	}

	public String getBV_FLEX_21() {
		return BV_FLEX_21;
	}

	public void setBV_FLEX_21(String BV_FLEX_21) {
		this.BV_FLEX_21 = BV_FLEX_21;
	}

	public String getBV_FLEX_22() {
		return BV_FLEX_22;
	}

	public void setBV_FLEX_22(String BV_FLEX_22) {
		this.BV_FLEX_22 = BV_FLEX_22;
	}

	public String getBV_FLEX_23() {
		return BV_FLEX_23;
	}

	public void setBV_FLEX_23(String BV_FLEX_23) {
		this.BV_FLEX_23 = BV_FLEX_23;
	}

	public String getBV_FLEX_24() {
		return BV_FLEX_24;
	}

	public void setBV_FLEX_24(String BV_FLEX_24) {
		this.BV_FLEX_24 = BV_FLEX_24;
	}

	public String getBV_FLEX_25() {
		return BV_FLEX_25;
	}

	public void setBV_FLEX_25(String BV_FLEX_25) {
		this.BV_FLEX_25 = BV_FLEX_25;
	}

	public String getBV_FLEX_26() {
		return BV_FLEX_26;
	}

	public void setBV_FLEX_26(String BV_FLEX_26) {
		this.BV_FLEX_26 = BV_FLEX_26;
	}

	public String getBV_BROKER_CODE() {
		return BV_BROKER_CODE;
	}

	public void setBV_BROKER_CODE(String BV_BROKER_CODE) {
		this.BV_BROKER_CODE = BV_BROKER_CODE;
	}

	public String getBV_COVER_CODE() {
		return BV_COVER_CODE;
	}

	public void setBV_COVER_CODE(String BV_COVER_CODE) {
		this.BV_COVER_CODE = BV_COVER_CODE;
	}

	public String getBV_COMM_CODE() {
		return BV_COMM_CODE;
	}

	public void setBV_COMM_CODE(String BV_COMM_CODE) {
		this.BV_COMM_CODE = BV_COMM_CODE;
	}

	

	public Integer getBV_YEAR() {
		return BV_YEAR;
	}

	public void setBV_YEAR(Integer bv_year) {
		BV_YEAR = bv_year;
	}

	public Long getBV_POL_SYS_ID() {
		return BV_POL_SYS_ID;
	}

	public void setBV_POL_SYS_ID(Long bv_pol_sys_id) {
		BV_POL_SYS_ID = bv_pol_sys_id;
	}

	public Long getBV_PC_SYS_ID() {
		return BV_PC_SYS_ID;
	}

	public void setBV_PC_SYS_ID(Long bv_pc_sys_id) {
		BV_PC_SYS_ID = bv_pc_sys_id;
	}

	public String getBV_CURR_CODE() {
		return BV_CURR_CODE;
	}

	public void setBV_CURR_CODE(String bv_curr_code) {
		BV_CURR_CODE = bv_curr_code;
	}

	public Double getBV_RATE() {
		return BV_RATE;
	}

	public void setBV_RATE(Double BV_RATE) {
		this.BV_RATE = BV_RATE;
	}

	

	public Integer getBV_RATE_PER() {
		return BV_RATE_PER;
	}

	public void setBV_RATE_PER(Integer bv_rate_per) {
		BV_RATE_PER = bv_rate_per;
	}

	public Double getBV_FC_VALUE() {
		return BV_FC_VALUE;
	}

	public void setBV_FC_VALUE(Double BV_FC_VALUE) {
		this.BV_FC_VALUE = BV_FC_VALUE;
	}

	public String getUI_M_BROKER_DESC() {
		return UI_M_BROKER_DESC;
	}

	public void setUI_M_BROKER_DESC(String UI_M_BROKER_DESC) {
		this.UI_M_BROKER_DESC = UI_M_BROKER_DESC;
	}

	public String getUI_M_COVER_DESC() {
		return UI_M_COVER_DESC;
	}

	public void setUI_M_COVER_DESC(String UI_M_COVER_DESC) {
		this.UI_M_COVER_DESC = UI_M_COVER_DESC;
	}

	public Double getBV_LC_VALUE() {
		return BV_LC_VALUE;
	}

	public void setBV_LC_VALUE(Double BV_LC_VALUE) {
		this.BV_LC_VALUE = BV_LC_VALUE;
	}

	public Double getBV_TOT_FC_DED() {
		return BV_TOT_FC_DED;
	}

	public void setBV_TOT_FC_DED(Double BV_TOT_FC_DED) {
		this.BV_TOT_FC_DED = BV_TOT_FC_DED;
	}

	public Double getBV_TOT_LC_DED() {
		return BV_TOT_LC_DED;
	}

	public void setBV_TOT_LC_DED(Double BV_TOT_LC_DED) {
		this.BV_TOT_LC_DED = BV_TOT_LC_DED;
	}

	public Double getBV_NET_FC_VALUE() {
		return BV_NET_FC_VALUE;
	}

	public void setBV_NET_FC_VALUE(Double BV_NET_FC_VALUE) {
		this.BV_NET_FC_VALUE = BV_NET_FC_VALUE;
	}

	public Double getBV_NET_LC_VALUE() {
		return BV_NET_LC_VALUE;
	}

	public void setBV_NET_LC_VALUE(Double BV_NET_LC_VALUE) {
		this.BV_NET_LC_VALUE = BV_NET_LC_VALUE;
	}
}