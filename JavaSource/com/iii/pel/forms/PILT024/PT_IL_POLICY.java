package com.iii.pel.forms.PILT024;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_POLICY")
public class PT_IL_POLICY extends BaseValueBean {

	@Column(name = "POL_SYS_ID")
	private Long POL_SYS_ID;
	
	@Column(name = "POL_FLEX_30")
	private String POL_FLEX_30;

	@Column(name = "POL_FLEX_26")
	private String POL_FLEX_26;

	@Column(name = "POL_FLEX_25")
	private String POL_FLEX_25;

	@Column(name = "POL_FLEX_24")
	private String POL_FLEX_24;

	@Column(name = "POL_FLEX_23")
	private String POL_FLEX_23;

	@Column(name = "POL_FLEX_22")
	private String POL_FLEX_22;

	@Column(name = "POL_FLEX_27")
	private String POL_FLEX_27;

	@Column(name = "POL_FLEX_29")
	private String POL_FLEX_29;

	@Column(name = "POL_FLEX_28")
	private String POL_FLEX_28;

	@Column(name = "POL_FLEX_01")
	private String POL_FLEX_01;

	@Column(name = "POL_FLEX_02")
	private String POL_FLEX_02;

	@Column(name = "POL_FLEX_03")
	private String POL_FLEX_03;

	@Column(name = "POL_FLEX_04")
	private String POL_FLEX_04;

	@Column(name = "POL_FLEX_05")
	private String POL_FLEX_05;

	@Column(name = "POL_FLEX_06")
	private String POL_FLEX_06;

	@Column(name = "POL_FLEX_07")
	private String POL_FLEX_07;

	@Column(name = "POL_FLEX_08")
	private String POL_FLEX_08;

	@Column(name = "POL_FLEX_09")
	private String POL_FLEX_09;

	@Column(name = "POL_FLEX_10")
	private String POL_FLEX_10;

	@Column(name = "POL_FLEX_11")
	private String POL_FLEX_11;

	@Column(name = "POL_FLEX_12")
	private String POL_FLEX_12;

	@Column(name = "POL_FLEX_13")
	private String POL_FLEX_13;

	@Column(name = "POL_FLEX_14")
	private String POL_FLEX_14;

	@Column(name = "POL_FLEX_15")
	private String POL_FLEX_15;

	@Column(name = "POL_FLEX_16")
	private String POL_FLEX_16;

	@Column(name = "POL_FLEX_17")
	private String POL_FLEX_17;

	@Column(name = "POL_FLEX_18")
	private String POL_FLEX_18;

	@Column(name = "POL_FLEX_19")
	private String POL_FLEX_19;

	@Column(name = "POL_FLEX_20")
	private String POL_FLEX_20;

	@Column(name = "POL_FLEX_21")
	private String POL_FLEX_21;

	@Column(name = "POL_NO")
	private String POL_NO;

	@Column(name = "POL_CUST_CODE")
	private String POL_CUST_CODE;

	@Column(name = "UI_M_POL_CUST_NAME")
	private String UI_M_POL_CUST_NAME;

	@Column(name = "POL_CONT_CODE")
	private String POL_CONT_CODE;

	@Column(name = "POL_ASSURED_NAME")
	private String POL_ASSURED_NAME;

	@Column(name = "POL_CUST_CURR_CODE")
	private String POL_CUST_CURR_CODE;

	@Column(name = "UI_M_POL_CUST_CURR_CODE_DESC")
	private String UI_M_POL_CUST_CURR_CODE_DESC;

	@Column(name = "POL_PROD_CODE")
	private String POL_PROD_CODE;

	@Column(name = "UI_M_POL_PROD_CODE_DESC")
	private String UI_M_POL_PROD_CODE_DESC;

	@Column(name = "POL_ISSUE_DT")
	private Date POL_ISSUE_DT;

	@Column(name = "POL_EXPIRY_DT")
	private Date POL_EXPIRY_DT;

	@Column(name = "POL_START_DT")
	private Date POL_START_DT;

	@Column(name = "POL_MODE_OF_PYMT")
	private String POL_MODE_OF_PYMT;

	@Column(name = "UI_M_PAID_DT")
	private Date UI_M_PAID_DT;
	
	@Column(name = "POL_FAC_YN")
	private String POL_FAC_YN;
	
	private Double POL_CUST_EXCH_RATE;
	
	private String POL_PLAN_CODE;
	
	private String UI_M_PLAN_TYPE;
	
	private Date UI_M_PREV_INST_DUE_DT;
	
	private Date UI_M_CURR_INV_DUE_DT;
	
	private Date UI_M_PREV_PAY_DT;

	

	public Date getUI_M_PREV_INST_DUE_DT() {
		return UI_M_PREV_INST_DUE_DT;
	}

	public void setUI_M_PREV_INST_DUE_DT(Date ui_m_prev_inst_due_dt) {
		UI_M_PREV_INST_DUE_DT = ui_m_prev_inst_due_dt;
	}

	public Date getUI_M_CURR_INV_DUE_DT() {
		return UI_M_CURR_INV_DUE_DT;
	}

	public void setUI_M_CURR_INV_DUE_DT(Date ui_m_curr_inv_due_dt) {
		UI_M_CURR_INV_DUE_DT = ui_m_curr_inv_due_dt;
	}

	public Date getUI_M_PREV_PAY_DT() {
		return UI_M_PREV_PAY_DT;
	}

	public void setUI_M_PREV_PAY_DT(Date ui_m_prev_pay_dt) {
		UI_M_PREV_PAY_DT = ui_m_prev_pay_dt;
	}

	public String getUI_M_PLAN_TYPE() {
		return UI_M_PLAN_TYPE;
	}

	public void setUI_M_PLAN_TYPE(String ui_m_plan_type) {
		UI_M_PLAN_TYPE = ui_m_plan_type;
	}

	public String getPOL_PLAN_CODE() {
		return POL_PLAN_CODE;
	}

	public void setPOL_PLAN_CODE(String pol_plan_code) {
		POL_PLAN_CODE = pol_plan_code;
	}

	public Double getPOL_CUST_EXCH_RATE() {
		return POL_CUST_EXCH_RATE;
	}

	public void setPOL_CUST_EXCH_RATE(Double pol_cust_exch_rate) {
		POL_CUST_EXCH_RATE = pol_cust_exch_rate;
	}

	public String getPOL_FLEX_30() {
		return POL_FLEX_30;
	}

	public void setPOL_FLEX_30(String POL_FLEX_30) {
		this.POL_FLEX_30 = POL_FLEX_30;
	}

	public String getPOL_FLEX_26() {
		return POL_FLEX_26;
	}

	public void setPOL_FLEX_26(String POL_FLEX_26) {
		this.POL_FLEX_26 = POL_FLEX_26;
	}

	public String getPOL_FLEX_25() {
		return POL_FLEX_25;
	}

	public void setPOL_FLEX_25(String POL_FLEX_25) {
		this.POL_FLEX_25 = POL_FLEX_25;
	}

	public String getPOL_FLEX_24() {
		return POL_FLEX_24;
	}

	public void setPOL_FLEX_24(String POL_FLEX_24) {
		this.POL_FLEX_24 = POL_FLEX_24;
	}

	public String getPOL_FLEX_23() {
		return POL_FLEX_23;
	}

	public void setPOL_FLEX_23(String POL_FLEX_23) {
		this.POL_FLEX_23 = POL_FLEX_23;
	}

	public String getPOL_FLEX_22() {
		return POL_FLEX_22;
	}

	public void setPOL_FLEX_22(String POL_FLEX_22) {
		this.POL_FLEX_22 = POL_FLEX_22;
	}

	public String getPOL_FLEX_27() {
		return POL_FLEX_27;
	}

	public void setPOL_FLEX_27(String POL_FLEX_27) {
		this.POL_FLEX_27 = POL_FLEX_27;
	}

	public String getPOL_FLEX_29() {
		return POL_FLEX_29;
	}

	public void setPOL_FLEX_29(String POL_FLEX_29) {
		this.POL_FLEX_29 = POL_FLEX_29;
	}

	public String getPOL_FLEX_28() {
		return POL_FLEX_28;
	}

	public void setPOL_FLEX_28(String POL_FLEX_28) {
		this.POL_FLEX_28 = POL_FLEX_28;
	}

	public String getPOL_FLEX_01() {
		return POL_FLEX_01;
	}

	public void setPOL_FLEX_01(String POL_FLEX_01) {
		this.POL_FLEX_01 = POL_FLEX_01;
	}

	public String getPOL_FLEX_02() {
		return POL_FLEX_02;
	}

	public void setPOL_FLEX_02(String POL_FLEX_02) {
		this.POL_FLEX_02 = POL_FLEX_02;
	}

	public String getPOL_FLEX_03() {
		return POL_FLEX_03;
	}

	public void setPOL_FLEX_03(String POL_FLEX_03) {
		this.POL_FLEX_03 = POL_FLEX_03;
	}

	public String getPOL_FLEX_04() {
		return POL_FLEX_04;
	}

	public void setPOL_FLEX_04(String POL_FLEX_04) {
		this.POL_FLEX_04 = POL_FLEX_04;
	}

	public String getPOL_FLEX_05() {
		return POL_FLEX_05;
	}

	public void setPOL_FLEX_05(String POL_FLEX_05) {
		this.POL_FLEX_05 = POL_FLEX_05;
	}

	public String getPOL_FLEX_06() {
		return POL_FLEX_06;
	}

	public void setPOL_FLEX_06(String POL_FLEX_06) {
		this.POL_FLEX_06 = POL_FLEX_06;
	}

	public String getPOL_FLEX_07() {
		return POL_FLEX_07;
	}

	public void setPOL_FLEX_07(String POL_FLEX_07) {
		this.POL_FLEX_07 = POL_FLEX_07;
	}

	public String getPOL_FLEX_08() {
		return POL_FLEX_08;
	}

	public void setPOL_FLEX_08(String POL_FLEX_08) {
		this.POL_FLEX_08 = POL_FLEX_08;
	}

	public String getPOL_FLEX_09() {
		return POL_FLEX_09;
	}

	public void setPOL_FLEX_09(String POL_FLEX_09) {
		this.POL_FLEX_09 = POL_FLEX_09;
	}

	public String getPOL_FLEX_10() {
		return POL_FLEX_10;
	}

	public void setPOL_FLEX_10(String POL_FLEX_10) {
		this.POL_FLEX_10 = POL_FLEX_10;
	}

	public String getPOL_FLEX_11() {
		return POL_FLEX_11;
	}

	public void setPOL_FLEX_11(String POL_FLEX_11) {
		this.POL_FLEX_11 = POL_FLEX_11;
	}

	public String getPOL_FLEX_12() {
		return POL_FLEX_12;
	}

	public void setPOL_FLEX_12(String POL_FLEX_12) {
		this.POL_FLEX_12 = POL_FLEX_12;
	}

	public String getPOL_FLEX_13() {
		return POL_FLEX_13;
	}

	public void setPOL_FLEX_13(String POL_FLEX_13) {
		this.POL_FLEX_13 = POL_FLEX_13;
	}

	public String getPOL_FLEX_14() {
		return POL_FLEX_14;
	}

	public void setPOL_FLEX_14(String POL_FLEX_14) {
		this.POL_FLEX_14 = POL_FLEX_14;
	}

	public String getPOL_FLEX_15() {
		return POL_FLEX_15;
	}

	public void setPOL_FLEX_15(String POL_FLEX_15) {
		this.POL_FLEX_15 = POL_FLEX_15;
	}

	public String getPOL_FLEX_16() {
		return POL_FLEX_16;
	}

	public void setPOL_FLEX_16(String POL_FLEX_16) {
		this.POL_FLEX_16 = POL_FLEX_16;
	}

	public String getPOL_FLEX_17() {
		return POL_FLEX_17;
	}

	public void setPOL_FLEX_17(String POL_FLEX_17) {
		this.POL_FLEX_17 = POL_FLEX_17;
	}

	public String getPOL_FLEX_18() {
		return POL_FLEX_18;
	}

	public void setPOL_FLEX_18(String POL_FLEX_18) {
		this.POL_FLEX_18 = POL_FLEX_18;
	}

	public String getPOL_FLEX_19() {
		return POL_FLEX_19;
	}

	public void setPOL_FLEX_19(String POL_FLEX_19) {
		this.POL_FLEX_19 = POL_FLEX_19;
	}

	public String getPOL_FLEX_20() {
		return POL_FLEX_20;
	}

	public void setPOL_FLEX_20(String POL_FLEX_20) {
		this.POL_FLEX_20 = POL_FLEX_20;
	}

	public String getPOL_FLEX_21() {
		return POL_FLEX_21;
	}

	public void setPOL_FLEX_21(String POL_FLEX_21) {
		this.POL_FLEX_21 = POL_FLEX_21;
	}

	public String getPOL_NO() {
		return POL_NO;
	}

	public void setPOL_NO(String POL_NO) {
		this.POL_NO = POL_NO;
	}

	public String getPOL_CUST_CODE() {
		return POL_CUST_CODE;
	}

	public void setPOL_CUST_CODE(String POL_CUST_CODE) {
		this.POL_CUST_CODE = POL_CUST_CODE;
	}

	public String getUI_M_POL_CUST_NAME() {
		return UI_M_POL_CUST_NAME;
	}

	public void setUI_M_POL_CUST_NAME(String UI_M_POL_CUST_NAME) {
		this.UI_M_POL_CUST_NAME = UI_M_POL_CUST_NAME;
	}

	public String getPOL_CONT_CODE() {
		return POL_CONT_CODE;
	}

	public void setPOL_CONT_CODE(String POL_CONT_CODE) {
		this.POL_CONT_CODE = POL_CONT_CODE;
	}

	public String getPOL_ASSURED_NAME() {
		return POL_ASSURED_NAME;
	}

	public void setPOL_ASSURED_NAME(String POL_ASSURED_NAME) {
		this.POL_ASSURED_NAME = POL_ASSURED_NAME;
	}

	public String getPOL_CUST_CURR_CODE() {
		return POL_CUST_CURR_CODE;
	}

	public void setPOL_CUST_CURR_CODE(String POL_CUST_CURR_CODE) {
		this.POL_CUST_CURR_CODE = POL_CUST_CURR_CODE;
	}

	public String getUI_M_POL_CUST_CURR_CODE_DESC() {
		return UI_M_POL_CUST_CURR_CODE_DESC;
	}

	public void setUI_M_POL_CUST_CURR_CODE_DESC(
			String UI_M_POL_CUST_CURR_CODE_DESC) {
		this.UI_M_POL_CUST_CURR_CODE_DESC = UI_M_POL_CUST_CURR_CODE_DESC;
	}

	public String getPOL_PROD_CODE() {
		return POL_PROD_CODE;
	}

	public void setPOL_PROD_CODE(String POL_PROD_CODE) {
		this.POL_PROD_CODE = POL_PROD_CODE;
	}

	public String getUI_M_POL_PROD_CODE_DESC() {
		return UI_M_POL_PROD_CODE_DESC;
	}

	public void setUI_M_POL_PROD_CODE_DESC(String UI_M_POL_PROD_CODE_DESC) {
		this.UI_M_POL_PROD_CODE_DESC = UI_M_POL_PROD_CODE_DESC;
	}

	public Date getPOL_ISSUE_DT() {
		return POL_ISSUE_DT;
	}

	public void setPOL_ISSUE_DT(Date POL_ISSUE_DT) {
		this.POL_ISSUE_DT = POL_ISSUE_DT;
	}

	public Date getPOL_EXPIRY_DT() {
		return POL_EXPIRY_DT;
	}

	public void setPOL_EXPIRY_DT(Date POL_EXPIRY_DT) {
		this.POL_EXPIRY_DT = POL_EXPIRY_DT;
	}

	public Date getPOL_START_DT() {
		return POL_START_DT;
	}

	public void setPOL_START_DT(Date POL_START_DT) {
		this.POL_START_DT = POL_START_DT;
	}

	public String getPOL_MODE_OF_PYMT() {
		return POL_MODE_OF_PYMT;
	}

	public void setPOL_MODE_OF_PYMT(String POL_MODE_OF_PYMT) {
		this.POL_MODE_OF_PYMT = POL_MODE_OF_PYMT;
	}

	public Date getUI_M_PAID_DT() {
		return UI_M_PAID_DT;
	}

	public void setUI_M_PAID_DT(Date UI_M_PAID_DT) {
		this.UI_M_PAID_DT = UI_M_PAID_DT;
	}

	public Long getPOL_SYS_ID() {
		return POL_SYS_ID;
	}

	public void setPOL_SYS_ID(Long pol_sys_id) {
		POL_SYS_ID = pol_sys_id;
	}

	public String getPOL_FAC_YN() {
		return POL_FAC_YN;
	}

	public void setPOL_FAC_YN(String pol_fac_yn) {
		POL_FAC_YN = pol_fac_yn;
	}
}