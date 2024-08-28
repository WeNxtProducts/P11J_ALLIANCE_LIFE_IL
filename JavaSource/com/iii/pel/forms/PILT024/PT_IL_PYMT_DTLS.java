package com.iii.pel.forms.PILT024;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_PYMT_DTLS")
public class PT_IL_PYMT_DTLS extends BaseValueBean {

	@Column(name = "PD_SR_NO")
	private Double PD_SR_NO;

	@Column(name = "PD_PAY_MODE")
	private String PD_PAY_MODE;

	@Column(name = "PD_DPD_REF_ID")
	private String PD_DPD_REF_ID;

	@Column(name = "PD_FC_AMT")
	private Double PD_FC_AMT;

	@Column(name = "PD_LC_AMT")
	private Double PD_LC_AMT;

	@Column(name = "PD_PAID_FOR")
	private String PD_PAID_FOR;

	@Column(name = "PD_CHQ_NO")
	private String PD_CHQ_NO;

	@Column(name = "PD_CHQ_DT")
	private Date PD_CHQ_DT;

	@Column(name = "PD_BANK_NAME")
	private String PD_BANK_NAME;

	@Column(name = "UI_M_BANK_NAME_DESC")
	private String UI_M_BANK_NAME_DESC;

	@Column(name = "PD_BRANCH_NAME")
	private String PD_BRANCH_NAME;

	@Column(name = "PD_CUST_NAME")
	private String PD_CUST_NAME;

	@Column(name = "PD_ADDR_01")
	private String PD_ADDR_01;

	@Column(name = "PD_ADDR_02")
	private String PD_ADDR_02;

	@Column(name = "PD_ADDR_03")
	private String PD_ADDR_03;

	@Column(name = "PD_REMARKS")
	private String PD_REMARKS;

	@Column(name = "PD_CURR_CODE")
	private String PD_CURR_CODE;

	@Column(name = "UI_M_PD_CURR_CODE_DESC")
	private String UI_M_PD_CURR_CODE_DESC;

	@Column(name = "PD_LC_CHARGE")
	private Double PD_LC_CHARGE;

	@Column(name = "PD_FC_CHARGE")
	private Double PD_FC_CHARGE;

	@Column(name = "PD_FLEX_04")
	private String PD_FLEX_04;

	@Column(name = "PD_FLEX_05")
	private String PD_FLEX_05;

	@Column(name = "PD_FLEX_06")
	private String PD_FLEX_06;

	@Column(name = "PD_FLEX_07")
	private String PD_FLEX_07;

	@Column(name = "PD_FLEX_08")
	private String PD_FLEX_08;

	@Column(name = "PD_FLEX_09")
	private String PD_FLEX_09;

	@Column(name = "PD_FLEX_10")
	private String PD_FLEX_10;

	@Column(name = "PD_FLEX_11")
	private String PD_FLEX_11;

	@Column(name = "PD_FLEX_12")
	private String PD_FLEX_12;

	@Column(name = "PD_FLEX_13")
	private String PD_FLEX_13;

	@Column(name = "PD_FLEX_14")
	private String PD_FLEX_14;

	@Column(name = "PD_FLEX_15")
	private String PD_FLEX_15;

	@Column(name = "PD_FLEX_16")
	private String PD_FLEX_16;

	@Column(name = "PD_FLEX_17")
	private String PD_FLEX_17;

	@Column(name = "PD_FLEX_18")
	private String PD_FLEX_18;

	@Column(name = "PD_FLEX_19")
	private String PD_FLEX_19;

	@Column(name = "PD_FLEX_20")
	private String PD_FLEX_20;

	@Column(name = "PD_FLEX_21")
	private String PD_FLEX_21;

	@Column(name = "PD_FLEX_22")
	private String PD_FLEX_22;

	@Column(name = "PD_FLEX_23")
	private String PD_FLEX_23;

	@Column(name = "PD_FLEX_24")
	private String PD_FLEX_24;

	@Column(name = "PD_FLEX_25")
	private String PD_FLEX_25;

	@Column(name = "PD_FLEX_26")
	private String PD_FLEX_26;

	@Column(name = "PD_FLEX_27")
	private String PD_FLEX_27;

	@Column(name = "PD_FLEX_28")
	private String PD_FLEX_28;

	@Column(name = "PD_FLEX_29")
	private String PD_FLEX_29;

	@Column(name = "PD_FLEX_30")
	private String PD_FLEX_30;

	@Column(name = "PD_FLEX_03")
	private String PD_FLEX_03;

	@Column(name = "PD_FLEX_01")
	private String PD_FLEX_01;

	@Column(name = "PD_FLEX_02")
	private String PD_FLEX_02;

	@Column(name = "PD_CC_TYPE")
	private String PD_CC_TYPE;

	@Column(name = "PD_CC_NO")
	private String PD_CC_NO;

	@Column(name = "PD_CC_NAME")
	private String PD_CC_NAME;

	@Column(name = "PD_CC_EXP_DT")
	private Date PD_CC_EXP_DT;

	public Double getPD_SR_NO() {
		return PD_SR_NO;
	}

	public void setPD_SR_NO(Double PD_SR_NO) {
		this.PD_SR_NO = PD_SR_NO;
	}

	public String getPD_PAY_MODE() {
		return PD_PAY_MODE;
	}

	public void setPD_PAY_MODE(String PD_PAY_MODE) {
		this.PD_PAY_MODE = PD_PAY_MODE;
	}

	public String getPD_DPD_REF_ID() {
		return PD_DPD_REF_ID;
	}

	public void setPD_DPD_REF_ID(String PD_DPD_REF_ID) {
		this.PD_DPD_REF_ID = PD_DPD_REF_ID;
	}

	public Double getPD_FC_AMT() {
		return PD_FC_AMT;
	}

	public void setPD_FC_AMT(Double PD_FC_AMT) {
		this.PD_FC_AMT = PD_FC_AMT;
	}

	public Double getPD_LC_AMT() {
		return PD_LC_AMT;
	}

	public void setPD_LC_AMT(Double PD_LC_AMT) {
		this.PD_LC_AMT = PD_LC_AMT;
	}

	public String getPD_PAID_FOR() {
		return PD_PAID_FOR;
	}

	public void setPD_PAID_FOR(String PD_PAID_FOR) {
		this.PD_PAID_FOR = PD_PAID_FOR;
	}

	public String getPD_CHQ_NO() {
		return PD_CHQ_NO;
	}

	public void setPD_CHQ_NO(String PD_CHQ_NO) {
		this.PD_CHQ_NO = PD_CHQ_NO;
	}

	public Date getPD_CHQ_DT() {
		return PD_CHQ_DT;
	}

	public void setPD_CHQ_DT(Date PD_CHQ_DT) {
		this.PD_CHQ_DT = PD_CHQ_DT;
	}

	public String getPD_BANK_NAME() {
		return PD_BANK_NAME;
	}

	public void setPD_BANK_NAME(String PD_BANK_NAME) {
		this.PD_BANK_NAME = PD_BANK_NAME;
	}

	public String getUI_M_BANK_NAME_DESC() {
		return UI_M_BANK_NAME_DESC;
	}

	public void setUI_M_BANK_NAME_DESC(String UI_M_BANK_NAME_DESC) {
		this.UI_M_BANK_NAME_DESC = UI_M_BANK_NAME_DESC;
	}

	public String getPD_BRANCH_NAME() {
		return PD_BRANCH_NAME;
	}

	public void setPD_BRANCH_NAME(String PD_BRANCH_NAME) {
		this.PD_BRANCH_NAME = PD_BRANCH_NAME;
	}

	public String getPD_CUST_NAME() {
		return PD_CUST_NAME;
	}

	public void setPD_CUST_NAME(String PD_CUST_NAME) {
		this.PD_CUST_NAME = PD_CUST_NAME;
	}

	public String getPD_ADDR_01() {
		return PD_ADDR_01;
	}

	public void setPD_ADDR_01(String PD_ADDR_01) {
		this.PD_ADDR_01 = PD_ADDR_01;
	}

	public String getPD_ADDR_02() {
		return PD_ADDR_02;
	}

	public void setPD_ADDR_02(String PD_ADDR_02) {
		this.PD_ADDR_02 = PD_ADDR_02;
	}

	public String getPD_ADDR_03() {
		return PD_ADDR_03;
	}

	public void setPD_ADDR_03(String PD_ADDR_03) {
		this.PD_ADDR_03 = PD_ADDR_03;
	}

	public String getPD_REMARKS() {
		return PD_REMARKS;
	}

	public void setPD_REMARKS(String PD_REMARKS) {
		this.PD_REMARKS = PD_REMARKS;
	}

	public String getPD_CURR_CODE() {
		return PD_CURR_CODE;
	}

	public void setPD_CURR_CODE(String PD_CURR_CODE) {
		this.PD_CURR_CODE = PD_CURR_CODE;
	}

	public String getUI_M_PD_CURR_CODE_DESC() {
		return UI_M_PD_CURR_CODE_DESC;
	}

	public void setUI_M_PD_CURR_CODE_DESC(String UI_M_PD_CURR_CODE_DESC) {
		this.UI_M_PD_CURR_CODE_DESC = UI_M_PD_CURR_CODE_DESC;
	}

	public Double getPD_LC_CHARGE() {
		return PD_LC_CHARGE;
	}

	public void setPD_LC_CHARGE(Double PD_LC_CHARGE) {
		this.PD_LC_CHARGE = PD_LC_CHARGE;
	}

	public Double getPD_FC_CHARGE() {
		return PD_FC_CHARGE;
	}

	public void setPD_FC_CHARGE(Double PD_FC_CHARGE) {
		this.PD_FC_CHARGE = PD_FC_CHARGE;
	}

	public String getPD_FLEX_04() {
		return PD_FLEX_04;
	}

	public void setPD_FLEX_04(String PD_FLEX_04) {
		this.PD_FLEX_04 = PD_FLEX_04;
	}

	public String getPD_FLEX_05() {
		return PD_FLEX_05;
	}

	public void setPD_FLEX_05(String PD_FLEX_05) {
		this.PD_FLEX_05 = PD_FLEX_05;
	}

	public String getPD_FLEX_06() {
		return PD_FLEX_06;
	}

	public void setPD_FLEX_06(String PD_FLEX_06) {
		this.PD_FLEX_06 = PD_FLEX_06;
	}

	public String getPD_FLEX_07() {
		return PD_FLEX_07;
	}

	public void setPD_FLEX_07(String PD_FLEX_07) {
		this.PD_FLEX_07 = PD_FLEX_07;
	}

	public String getPD_FLEX_08() {
		return PD_FLEX_08;
	}

	public void setPD_FLEX_08(String PD_FLEX_08) {
		this.PD_FLEX_08 = PD_FLEX_08;
	}

	public String getPD_FLEX_09() {
		return PD_FLEX_09;
	}

	public void setPD_FLEX_09(String PD_FLEX_09) {
		this.PD_FLEX_09 = PD_FLEX_09;
	}

	public String getPD_FLEX_10() {
		return PD_FLEX_10;
	}

	public void setPD_FLEX_10(String PD_FLEX_10) {
		this.PD_FLEX_10 = PD_FLEX_10;
	}

	public String getPD_FLEX_11() {
		return PD_FLEX_11;
	}

	public void setPD_FLEX_11(String PD_FLEX_11) {
		this.PD_FLEX_11 = PD_FLEX_11;
	}

	public String getPD_FLEX_12() {
		return PD_FLEX_12;
	}

	public void setPD_FLEX_12(String PD_FLEX_12) {
		this.PD_FLEX_12 = PD_FLEX_12;
	}

	public String getPD_FLEX_13() {
		return PD_FLEX_13;
	}

	public void setPD_FLEX_13(String PD_FLEX_13) {
		this.PD_FLEX_13 = PD_FLEX_13;
	}

	public String getPD_FLEX_14() {
		return PD_FLEX_14;
	}

	public void setPD_FLEX_14(String PD_FLEX_14) {
		this.PD_FLEX_14 = PD_FLEX_14;
	}

	public String getPD_FLEX_15() {
		return PD_FLEX_15;
	}

	public void setPD_FLEX_15(String PD_FLEX_15) {
		this.PD_FLEX_15 = PD_FLEX_15;
	}

	public String getPD_FLEX_16() {
		return PD_FLEX_16;
	}

	public void setPD_FLEX_16(String PD_FLEX_16) {
		this.PD_FLEX_16 = PD_FLEX_16;
	}

	public String getPD_FLEX_17() {
		return PD_FLEX_17;
	}

	public void setPD_FLEX_17(String PD_FLEX_17) {
		this.PD_FLEX_17 = PD_FLEX_17;
	}

	public String getPD_FLEX_18() {
		return PD_FLEX_18;
	}

	public void setPD_FLEX_18(String PD_FLEX_18) {
		this.PD_FLEX_18 = PD_FLEX_18;
	}

	public String getPD_FLEX_19() {
		return PD_FLEX_19;
	}

	public void setPD_FLEX_19(String PD_FLEX_19) {
		this.PD_FLEX_19 = PD_FLEX_19;
	}

	public String getPD_FLEX_20() {
		return PD_FLEX_20;
	}

	public void setPD_FLEX_20(String PD_FLEX_20) {
		this.PD_FLEX_20 = PD_FLEX_20;
	}

	public String getPD_FLEX_21() {
		return PD_FLEX_21;
	}

	public void setPD_FLEX_21(String PD_FLEX_21) {
		this.PD_FLEX_21 = PD_FLEX_21;
	}

	public String getPD_FLEX_22() {
		return PD_FLEX_22;
	}

	public void setPD_FLEX_22(String PD_FLEX_22) {
		this.PD_FLEX_22 = PD_FLEX_22;
	}

	public String getPD_FLEX_23() {
		return PD_FLEX_23;
	}

	public void setPD_FLEX_23(String PD_FLEX_23) {
		this.PD_FLEX_23 = PD_FLEX_23;
	}

	public String getPD_FLEX_24() {
		return PD_FLEX_24;
	}

	public void setPD_FLEX_24(String PD_FLEX_24) {
		this.PD_FLEX_24 = PD_FLEX_24;
	}

	public String getPD_FLEX_25() {
		return PD_FLEX_25;
	}

	public void setPD_FLEX_25(String PD_FLEX_25) {
		this.PD_FLEX_25 = PD_FLEX_25;
	}

	public String getPD_FLEX_26() {
		return PD_FLEX_26;
	}

	public void setPD_FLEX_26(String PD_FLEX_26) {
		this.PD_FLEX_26 = PD_FLEX_26;
	}

	public String getPD_FLEX_27() {
		return PD_FLEX_27;
	}

	public void setPD_FLEX_27(String PD_FLEX_27) {
		this.PD_FLEX_27 = PD_FLEX_27;
	}

	public String getPD_FLEX_28() {
		return PD_FLEX_28;
	}

	public void setPD_FLEX_28(String PD_FLEX_28) {
		this.PD_FLEX_28 = PD_FLEX_28;
	}

	public String getPD_FLEX_29() {
		return PD_FLEX_29;
	}

	public void setPD_FLEX_29(String PD_FLEX_29) {
		this.PD_FLEX_29 = PD_FLEX_29;
	}

	public String getPD_FLEX_30() {
		return PD_FLEX_30;
	}

	public void setPD_FLEX_30(String PD_FLEX_30) {
		this.PD_FLEX_30 = PD_FLEX_30;
	}

	public String getPD_FLEX_03() {
		return PD_FLEX_03;
	}

	public void setPD_FLEX_03(String PD_FLEX_03) {
		this.PD_FLEX_03 = PD_FLEX_03;
	}

	public String getPD_FLEX_01() {
		return PD_FLEX_01;
	}

	public void setPD_FLEX_01(String PD_FLEX_01) {
		this.PD_FLEX_01 = PD_FLEX_01;
	}

	public String getPD_FLEX_02() {
		return PD_FLEX_02;
	}

	public void setPD_FLEX_02(String PD_FLEX_02) {
		this.PD_FLEX_02 = PD_FLEX_02;
	}

	public String getPD_CC_TYPE() {
		return PD_CC_TYPE;
	}

	public void setPD_CC_TYPE(String PD_CC_TYPE) {
		this.PD_CC_TYPE = PD_CC_TYPE;
	}

	public String getPD_CC_NO() {
		return PD_CC_NO;
	}

	public void setPD_CC_NO(String PD_CC_NO) {
		this.PD_CC_NO = PD_CC_NO;
	}

	public String getPD_CC_NAME() {
		return PD_CC_NAME;
	}

	public void setPD_CC_NAME(String PD_CC_NAME) {
		this.PD_CC_NAME = PD_CC_NAME;
	}

	public Date getPD_CC_EXP_DT() {
		return PD_CC_EXP_DT;
	}

	public void setPD_CC_EXP_DT(Date PD_CC_EXP_DT) {
		this.PD_CC_EXP_DT = PD_CC_EXP_DT;
	}
}