package com.iii.pel.forms.PILT024;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_MULTI_PREM_COLL")
public class PT_IL_MULTI_PREM_COLL extends BaseValueBean {
	
	@Column(name = "PMPC_PC_SYS_ID")
	private Long PMPC_PC_SYS_ID;
	
	@Column(name = "PMPC_POL_SYS_ID")
	private Long PMPC_POL_SYS_ID;
	
	@Column(name = "PMPC_DRCR_ACNT_YEAR")
	private Integer PMPC_DRCR_ACNT_YEAR;
	
	@Column(name = "PMPC_DRCR_TXN_CODE")
	private String PMPC_DRCR_TXN_CODE;
	
	@Column(name = "PMPC_DRCR_DOC_NO")
	private Integer PMPC_DRCR_DOC_NO;
	
	@Column(name = "PMPC_DRCR_DOC_DT")
	private Date PMPC_DRCR_DOC_DT;
	
	@Column(name = "PMPC_TRAN_DT")
	private Date PMPC_TRAN_DT;
	
	@Column(name = "PMPC_GROSS_CONTRI_FC_AMT")
	private Double PMPC_GROSS_CONTRI_FC_AMT;
	
	@Column(name = "PMPC_GROSS_CONTRI_LC_AMT")
	private Double PMPC_GROSS_CONTRI_LC_AMT;
	
	@Column(name = "PMPC_PREM_CHARGE_FC_AMT")
	private Double PMPC_PREM_CHARGE_FC_AMT;
	
	@Column(name = "PMPC_PREM_CHARGE_LC_AMT")
	private Double PMPC_PREM_CHARGE_LC_AMT;
	
	@Column(name = "PMPC_TOPUP_CHARGE_FC_AMT")
	private Double PMPC_TOPUP_CHARGE_FC_AMT;
	
	@Column(name = "PMPC_TOPUP_CHARGE_LC_AMT")
	private Double PMPC_TOPUP_CHARGE_LC_AMT;
	
	@Column(name = "PMPC_SYS_ID")
	private Long PMPC_SYS_ID;
	
	@Column(name = "PMPC_FLEX_30")
	private String PMPC_FLEX_30;

	@Column(name = "PMPC_FLEX_27")
	private String PMPC_FLEX_27;

	@Column(name = "PMPC_FLEX_26")
	private String PMPC_FLEX_26;

	@Column(name = "PMPC_FLEX_25")
	private String PMPC_FLEX_25;

	@Column(name = "PMPC_FLEX_24")
	private String PMPC_FLEX_24;

	@Column(name = "PMPC_FLEX_28")
	private String PMPC_FLEX_28;

	@Column(name = "PMPC_FLEX_29")
	private String PMPC_FLEX_29;

	@Column(name = "PMPC_FLEX_01")
	private String PMPC_FLEX_01;

	@Column(name = "PMPC_FLEX_02")
	private String PMPC_FLEX_02;

	@Column(name = "PMPC_FLEX_03")
	private String PMPC_FLEX_03;

	@Column(name = "PMPC_FLEX_04")
	private String PMPC_FLEX_04;

	@Column(name = "PMPC_FLEX_05")
	private String PMPC_FLEX_05;

	@Column(name = "PMPC_FLEX_06")
	private String PMPC_FLEX_06;

	@Column(name = "PMPC_FLEX_07")
	private String PMPC_FLEX_07;

	@Column(name = "PMPC_FLEX_08")
	private String PMPC_FLEX_08;

	@Column(name = "PMPC_FLEX_09")
	private String PMPC_FLEX_09;

	@Column(name = "PMPC_FLEX_10")
	private String PMPC_FLEX_10;

	@Column(name = "PMPC_FLEX_11")
	private String PMPC_FLEX_11;

	@Column(name = "PMPC_FLEX_12")
	private String PMPC_FLEX_12;

	@Column(name = "PMPC_FLEX_13")
	private String PMPC_FLEX_13;

	@Column(name = "PMPC_FLEX_14")
	private String PMPC_FLEX_14;

	@Column(name = "PMPC_FLEX_15")
	private String PMPC_FLEX_15;

	@Column(name = "PMPC_FLEX_16")
	private String PMPC_FLEX_16;

	@Column(name = "PMPC_FLEX_17")
	private String PMPC_FLEX_17;

	@Column(name = "PMPC_FLEX_18")
	private String PMPC_FLEX_18;

	@Column(name = "PMPC_FLEX_19")
	private String PMPC_FLEX_19;

	@Column(name = "PMPC_FLEX_20")
	private String PMPC_FLEX_20;

	@Column(name = "PMPC_FLEX_21")
	private String PMPC_FLEX_21;

	@Column(name = "PMPC_FLEX_22")
	private String PMPC_FLEX_22;

	@Column(name = "PMPC_FLEX_23")
	private String PMPC_FLEX_23;

	@Column(name = "PMPC_CHARGE_FC_AMT")
	private Double PMPC_CHARGE_FC_AMT;

	@Column(name = "PMPC_CHARGE_LC_AMT")
	private Double PMPC_CHARGE_LC_AMT;

	@Column(name = "PMPC_COLL_COUNT")
	private Double PMPC_COLL_COUNT;

	@Column(name = "PMPC_PAID_DT")
	private Date PMPC_PAID_DT;

	@Column(name = "PMPC_APPRV_DT")
	private Date PMPC_APPRV_DT;

	@Column(name = "PMPC_PAID_FLAG")
	private String PMPC_PAID_FLAG;

	@Column(name = "PMPC_FC_PAID_AMT")
	private Double PMPC_FC_PAID_AMT;

	@Column(name = "PMPC_LC_PAID_AMT")
	private Double PMPC_LC_PAID_AMT;

	@Column(name = "PMPC_RISK_FC_AMT")
	private Double PMPC_RISK_FC_AMT;

	@Column(name = "PMPC_RISK_LC_AMT")
	private Double PMPC_RISK_LC_AMT;

	@Column(name = "UI_M_CHARGE_FC_AMT")
	private Double UI_M_CHARGE_FC_AMT;

	@Column(name = "UI_M_CHARGE_LC_AMT")
	private Double UI_M_CHARGE_LC_AMT;

	@Column(name = "PMPC_PREM_CONTRI_FC_AMT")
	private Double PMPC_PREM_CONTRI_FC_AMT;

	@Column(name = "PMPC_PREM_CONTRI_LC_AMT")
	private Double PMPC_PREM_CONTRI_LC_AMT;

	@Column(name = "PMPC_TOPUP_CONTRI_FC_AMT")
	private Double PMPC_TOPUP_CONTRI_FC_AMT;

	@Column(name = "PMPC_TOPUP_CONTRI_LC_AMT")
	private Double PMPC_TOPUP_CONTRI_LC_AMT;

	public String getPMPC_FLEX_30() {
		return PMPC_FLEX_30;
	}

	public void setPMPC_FLEX_30(String PMPC_FLEX_30) {
		this.PMPC_FLEX_30 = PMPC_FLEX_30;
	}

	public String getPMPC_FLEX_27() {
		return PMPC_FLEX_27;
	}

	public void setPMPC_FLEX_27(String PMPC_FLEX_27) {
		this.PMPC_FLEX_27 = PMPC_FLEX_27;
	}

	public String getPMPC_FLEX_26() {
		return PMPC_FLEX_26;
	}

	public void setPMPC_FLEX_26(String PMPC_FLEX_26) {
		this.PMPC_FLEX_26 = PMPC_FLEX_26;
	}

	public String getPMPC_FLEX_25() {
		return PMPC_FLEX_25;
	}

	public void setPMPC_FLEX_25(String PMPC_FLEX_25) {
		this.PMPC_FLEX_25 = PMPC_FLEX_25;
	}

	public String getPMPC_FLEX_24() {
		return PMPC_FLEX_24;
	}

	public void setPMPC_FLEX_24(String PMPC_FLEX_24) {
		this.PMPC_FLEX_24 = PMPC_FLEX_24;
	}

	public String getPMPC_FLEX_28() {
		return PMPC_FLEX_28;
	}

	public void setPMPC_FLEX_28(String PMPC_FLEX_28) {
		this.PMPC_FLEX_28 = PMPC_FLEX_28;
	}

	public String getPMPC_FLEX_29() {
		return PMPC_FLEX_29;
	}

	public void setPMPC_FLEX_29(String PMPC_FLEX_29) {
		this.PMPC_FLEX_29 = PMPC_FLEX_29;
	}

	public String getPMPC_FLEX_01() {
		return PMPC_FLEX_01;
	}

	public void setPMPC_FLEX_01(String PMPC_FLEX_01) {
		this.PMPC_FLEX_01 = PMPC_FLEX_01;
	}

	public String getPMPC_FLEX_02() {
		return PMPC_FLEX_02;
	}

	public void setPMPC_FLEX_02(String PMPC_FLEX_02) {
		this.PMPC_FLEX_02 = PMPC_FLEX_02;
	}

	public String getPMPC_FLEX_03() {
		return PMPC_FLEX_03;
	}

	public void setPMPC_FLEX_03(String PMPC_FLEX_03) {
		this.PMPC_FLEX_03 = PMPC_FLEX_03;
	}

	public String getPMPC_FLEX_04() {
		return PMPC_FLEX_04;
	}

	public void setPMPC_FLEX_04(String PMPC_FLEX_04) {
		this.PMPC_FLEX_04 = PMPC_FLEX_04;
	}

	public String getPMPC_FLEX_05() {
		return PMPC_FLEX_05;
	}

	public void setPMPC_FLEX_05(String PMPC_FLEX_05) {
		this.PMPC_FLEX_05 = PMPC_FLEX_05;
	}

	public String getPMPC_FLEX_06() {
		return PMPC_FLEX_06;
	}

	public void setPMPC_FLEX_06(String PMPC_FLEX_06) {
		this.PMPC_FLEX_06 = PMPC_FLEX_06;
	}

	public String getPMPC_FLEX_07() {
		return PMPC_FLEX_07;
	}

	public void setPMPC_FLEX_07(String PMPC_FLEX_07) {
		this.PMPC_FLEX_07 = PMPC_FLEX_07;
	}

	public String getPMPC_FLEX_08() {
		return PMPC_FLEX_08;
	}

	public void setPMPC_FLEX_08(String PMPC_FLEX_08) {
		this.PMPC_FLEX_08 = PMPC_FLEX_08;
	}

	public String getPMPC_FLEX_09() {
		return PMPC_FLEX_09;
	}

	public void setPMPC_FLEX_09(String PMPC_FLEX_09) {
		this.PMPC_FLEX_09 = PMPC_FLEX_09;
	}

	public String getPMPC_FLEX_10() {
		return PMPC_FLEX_10;
	}

	public void setPMPC_FLEX_10(String PMPC_FLEX_10) {
		this.PMPC_FLEX_10 = PMPC_FLEX_10;
	}

	public String getPMPC_FLEX_11() {
		return PMPC_FLEX_11;
	}

	public void setPMPC_FLEX_11(String PMPC_FLEX_11) {
		this.PMPC_FLEX_11 = PMPC_FLEX_11;
	}

	public String getPMPC_FLEX_12() {
		return PMPC_FLEX_12;
	}

	public void setPMPC_FLEX_12(String PMPC_FLEX_12) {
		this.PMPC_FLEX_12 = PMPC_FLEX_12;
	}

	public String getPMPC_FLEX_13() {
		return PMPC_FLEX_13;
	}

	public void setPMPC_FLEX_13(String PMPC_FLEX_13) {
		this.PMPC_FLEX_13 = PMPC_FLEX_13;
	}

	public String getPMPC_FLEX_14() {
		return PMPC_FLEX_14;
	}

	public void setPMPC_FLEX_14(String PMPC_FLEX_14) {
		this.PMPC_FLEX_14 = PMPC_FLEX_14;
	}

	public String getPMPC_FLEX_15() {
		return PMPC_FLEX_15;
	}

	public void setPMPC_FLEX_15(String PMPC_FLEX_15) {
		this.PMPC_FLEX_15 = PMPC_FLEX_15;
	}

	public String getPMPC_FLEX_16() {
		return PMPC_FLEX_16;
	}

	public void setPMPC_FLEX_16(String PMPC_FLEX_16) {
		this.PMPC_FLEX_16 = PMPC_FLEX_16;
	}

	public String getPMPC_FLEX_17() {
		return PMPC_FLEX_17;
	}

	public void setPMPC_FLEX_17(String PMPC_FLEX_17) {
		this.PMPC_FLEX_17 = PMPC_FLEX_17;
	}

	public String getPMPC_FLEX_18() {
		return PMPC_FLEX_18;
	}

	public void setPMPC_FLEX_18(String PMPC_FLEX_18) {
		this.PMPC_FLEX_18 = PMPC_FLEX_18;
	}

	public String getPMPC_FLEX_19() {
		return PMPC_FLEX_19;
	}

	public void setPMPC_FLEX_19(String PMPC_FLEX_19) {
		this.PMPC_FLEX_19 = PMPC_FLEX_19;
	}

	public String getPMPC_FLEX_20() {
		return PMPC_FLEX_20;
	}

	public void setPMPC_FLEX_20(String PMPC_FLEX_20) {
		this.PMPC_FLEX_20 = PMPC_FLEX_20;
	}

	public String getPMPC_FLEX_21() {
		return PMPC_FLEX_21;
	}

	public void setPMPC_FLEX_21(String PMPC_FLEX_21) {
		this.PMPC_FLEX_21 = PMPC_FLEX_21;
	}

	public String getPMPC_FLEX_22() {
		return PMPC_FLEX_22;
	}

	public void setPMPC_FLEX_22(String PMPC_FLEX_22) {
		this.PMPC_FLEX_22 = PMPC_FLEX_22;
	}

	public String getPMPC_FLEX_23() {
		return PMPC_FLEX_23;
	}

	public void setPMPC_FLEX_23(String PMPC_FLEX_23) {
		this.PMPC_FLEX_23 = PMPC_FLEX_23;
	}

	public Double getPMPC_CHARGE_FC_AMT() {
		return PMPC_CHARGE_FC_AMT;
	}

	public void setPMPC_CHARGE_FC_AMT(Double PMPC_CHARGE_FC_AMT) {
		this.PMPC_CHARGE_FC_AMT = PMPC_CHARGE_FC_AMT;
	}

	public Double getPMPC_CHARGE_LC_AMT() {
		return PMPC_CHARGE_LC_AMT;
	}

	public void setPMPC_CHARGE_LC_AMT(Double PMPC_CHARGE_LC_AMT) {
		this.PMPC_CHARGE_LC_AMT = PMPC_CHARGE_LC_AMT;
	}

	public Double getPMPC_COLL_COUNT() {
		return PMPC_COLL_COUNT;
	}

	public void setPMPC_COLL_COUNT(Double PMPC_COLL_COUNT) {
		this.PMPC_COLL_COUNT = PMPC_COLL_COUNT;
	}

	public Date getPMPC_PAID_DT() {
		return PMPC_PAID_DT;
	}

	public void setPMPC_PAID_DT(Date PMPC_PAID_DT) {
		this.PMPC_PAID_DT = PMPC_PAID_DT;
	}

	public Date getPMPC_APPRV_DT() {
		return PMPC_APPRV_DT;
	}

	public void setPMPC_APPRV_DT(Date PMPC_APPRV_DT) {
		this.PMPC_APPRV_DT = PMPC_APPRV_DT;
	}

	public String getPMPC_PAID_FLAG() {
		return PMPC_PAID_FLAG;
	}

	public void setPMPC_PAID_FLAG(String PMPC_PAID_FLAG) {
		this.PMPC_PAID_FLAG = PMPC_PAID_FLAG;
	}

	public Double getPMPC_FC_PAID_AMT() {
		return PMPC_FC_PAID_AMT;
	}

	public void setPMPC_FC_PAID_AMT(Double PMPC_FC_PAID_AMT) {
		this.PMPC_FC_PAID_AMT = PMPC_FC_PAID_AMT;
	}

	public Double getPMPC_LC_PAID_AMT() {
		return PMPC_LC_PAID_AMT;
	}

	public void setPMPC_LC_PAID_AMT(Double PMPC_LC_PAID_AMT) {
		this.PMPC_LC_PAID_AMT = PMPC_LC_PAID_AMT;
	}

	public Double getPMPC_RISK_FC_AMT() {
		return PMPC_RISK_FC_AMT;
	}

	public void setPMPC_RISK_FC_AMT(Double PMPC_RISK_FC_AMT) {
		this.PMPC_RISK_FC_AMT = PMPC_RISK_FC_AMT;
	}

	public Double getPMPC_RISK_LC_AMT() {
		return PMPC_RISK_LC_AMT;
	}

	public void setPMPC_RISK_LC_AMT(Double PMPC_RISK_LC_AMT) {
		this.PMPC_RISK_LC_AMT = PMPC_RISK_LC_AMT;
	}

	public Double getUI_M_CHARGE_FC_AMT() {
		return UI_M_CHARGE_FC_AMT;
	}

	public void setUI_M_CHARGE_FC_AMT(Double UI_M_CHARGE_FC_AMT) {
		this.UI_M_CHARGE_FC_AMT = UI_M_CHARGE_FC_AMT;
	}

	public Double getUI_M_CHARGE_LC_AMT() {
		return UI_M_CHARGE_LC_AMT;
	}

	public void setUI_M_CHARGE_LC_AMT(Double UI_M_CHARGE_LC_AMT) {
		this.UI_M_CHARGE_LC_AMT = UI_M_CHARGE_LC_AMT;
	}

	public Double getPMPC_PREM_CONTRI_FC_AMT() {
		return PMPC_PREM_CONTRI_FC_AMT;
	}

	public void setPMPC_PREM_CONTRI_FC_AMT(Double PMPC_PREM_CONTRI_FC_AMT) {
		this.PMPC_PREM_CONTRI_FC_AMT = PMPC_PREM_CONTRI_FC_AMT;
	}

	public Double getPMPC_PREM_CONTRI_LC_AMT() {
		return PMPC_PREM_CONTRI_LC_AMT;
	}

	public void setPMPC_PREM_CONTRI_LC_AMT(Double PMPC_PREM_CONTRI_LC_AMT) {
		this.PMPC_PREM_CONTRI_LC_AMT = PMPC_PREM_CONTRI_LC_AMT;
	}

	public Double getPMPC_TOPUP_CONTRI_FC_AMT() {
		return PMPC_TOPUP_CONTRI_FC_AMT;
	}

	public void setPMPC_TOPUP_CONTRI_FC_AMT(Double PMPC_TOPUP_CONTRI_FC_AMT) {
		this.PMPC_TOPUP_CONTRI_FC_AMT = PMPC_TOPUP_CONTRI_FC_AMT;
	}

	public Double getPMPC_TOPUP_CONTRI_LC_AMT() {
		return PMPC_TOPUP_CONTRI_LC_AMT;
	}

	public void setPMPC_TOPUP_CONTRI_LC_AMT(Double PMPC_TOPUP_CONTRI_LC_AMT) {
		this.PMPC_TOPUP_CONTRI_LC_AMT = PMPC_TOPUP_CONTRI_LC_AMT;
	}

	public Long getPMPC_SYS_ID() {
		return PMPC_SYS_ID;
	}

	public void setPMPC_SYS_ID(Long pmpc_sys_id) {
		PMPC_SYS_ID = pmpc_sys_id;
	}

	public Long getPMPC_PC_SYS_ID() {
		return PMPC_PC_SYS_ID;
	}

	public void setPMPC_PC_SYS_ID(Long pmpc_pc_sys_id) {
		PMPC_PC_SYS_ID = pmpc_pc_sys_id;
	}

	public Long getPMPC_POL_SYS_ID() {
		return PMPC_POL_SYS_ID;
	}

	public void setPMPC_POL_SYS_ID(Long pmpc_pol_sys_id) {
		PMPC_POL_SYS_ID = pmpc_pol_sys_id;
	}

	public Integer getPMPC_DRCR_ACNT_YEAR() {
		return PMPC_DRCR_ACNT_YEAR;
	}

	public void setPMPC_DRCR_ACNT_YEAR(Integer pmpc_drcr_acnt_year) {
		PMPC_DRCR_ACNT_YEAR = pmpc_drcr_acnt_year;
	}

	public String getPMPC_DRCR_TXN_CODE() {
		return PMPC_DRCR_TXN_CODE;
	}

	public void setPMPC_DRCR_TXN_CODE(String pmpc_drcr_txn_code) {
		PMPC_DRCR_TXN_CODE = pmpc_drcr_txn_code;
	}

	public Integer getPMPC_DRCR_DOC_NO() {
		return PMPC_DRCR_DOC_NO;
	}

	public void setPMPC_DRCR_DOC_NO(Integer pmpc_drcr_doc_no) {
		PMPC_DRCR_DOC_NO = pmpc_drcr_doc_no;
	}

	public Date getPMPC_DRCR_DOC_DT() {
		return PMPC_DRCR_DOC_DT;
	}

	public void setPMPC_DRCR_DOC_DT(Date pmpc_drcr_doc_dt) {
		PMPC_DRCR_DOC_DT = pmpc_drcr_doc_dt;
	}

	public Date getPMPC_TRAN_DT() {
		return PMPC_TRAN_DT;
	}

	public void setPMPC_TRAN_DT(Date pmpc_tran_dt) {
		PMPC_TRAN_DT = pmpc_tran_dt;
	}

	public Double getPMPC_GROSS_CONTRI_FC_AMT() {
		return PMPC_GROSS_CONTRI_FC_AMT;
	}

	public void setPMPC_GROSS_CONTRI_FC_AMT(Double pmpc_gross_contri_fc_amt) {
		PMPC_GROSS_CONTRI_FC_AMT = pmpc_gross_contri_fc_amt;
	}

	public Double getPMPC_GROSS_CONTRI_LC_AMT() {
		return PMPC_GROSS_CONTRI_LC_AMT;
	}

	public void setPMPC_GROSS_CONTRI_LC_AMT(Double pmpc_gross_contri_lc_amt) {
		PMPC_GROSS_CONTRI_LC_AMT = pmpc_gross_contri_lc_amt;
	}

	public Double getPMPC_PREM_CHARGE_FC_AMT() {
		return PMPC_PREM_CHARGE_FC_AMT;
	}

	public void setPMPC_PREM_CHARGE_FC_AMT(Double pmpc_prem_charge_fc_amt) {
		PMPC_PREM_CHARGE_FC_AMT = pmpc_prem_charge_fc_amt;
	}

	public Double getPMPC_PREM_CHARGE_LC_AMT() {
		return PMPC_PREM_CHARGE_LC_AMT;
	}

	public void setPMPC_PREM_CHARGE_LC_AMT(Double pmpc_prem_charge_lc_amt) {
		PMPC_PREM_CHARGE_LC_AMT = pmpc_prem_charge_lc_amt;
	}

	public Double getPMPC_TOPUP_CHARGE_FC_AMT() {
		return PMPC_TOPUP_CHARGE_FC_AMT;
	}

	public void setPMPC_TOPUP_CHARGE_FC_AMT(Double pmpc_topup_charge_fc_amt) {
		PMPC_TOPUP_CHARGE_FC_AMT = pmpc_topup_charge_fc_amt;
	}

	public Double getPMPC_TOPUP_CHARGE_LC_AMT() {
		return PMPC_TOPUP_CHARGE_LC_AMT;
	}

	public void setPMPC_TOPUP_CHARGE_LC_AMT(Double pmpc_topup_charge_lc_amt) {
		PMPC_TOPUP_CHARGE_LC_AMT = pmpc_topup_charge_lc_amt;
	}
}