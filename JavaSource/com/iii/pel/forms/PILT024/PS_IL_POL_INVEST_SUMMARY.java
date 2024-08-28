package com.iii.pel.forms.PILT024;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PS_IL_POL_INVEST_SUMMARY")
public class PS_IL_POL_INVEST_SUMMARY extends BaseValueBean {

	@Column(name = "PIS_SYS_ID")
	private Long PIS_SYS_ID;

	@Column(name = "PIS_SYS_ID")
	private Long PIS_POL_SYS_ID;

	@Column(name = "PIS_SYS_ID")
	private Long PIS_PC_SYS_ID;

	@Column(name = "PIS_SYS_ID")
	private Long PIS_PCD_SYS_ID;

	@Column(name = "PIS_FLEX_11")
	private String PIS_FLEX_11;

	@Column(name = "PIS_FLEX_28")
	private String PIS_FLEX_28;

	@Column(name = "PIS_FLEX_27")
	private String PIS_FLEX_27;

	@Column(name = "PIS_FLEX_26")
	private String PIS_FLEX_26;

	@Column(name = "PIS_FLEX_25")
	private String PIS_FLEX_25;

	@Column(name = "PIS_FLEX_24")
	private String PIS_FLEX_24;

	@Column(name = "PIS_FLEX_30")
	private String PIS_FLEX_30;

	/*
	 * modified by Ameen on 26-05-2017 as per Gaurav sugg.
	 * @Column(name = "PIS_FLEX_01")
	private String PIS_FLEX_01;

	@Column(name = "PIS_FLEX_02")
	private String PIS_FLEX_02;*/
	
	@Column(name = "PIS_FLEX_01")
	private Double PIS_FLEX_01;

	@Column(name = "PIS_FLEX_02")
	private Double PIS_FLEX_02;

	/*
	 * modified by Ameen on 26-05-2017 as per Gaurav sugg.
	 * @Column(name = "PIS_FLEX_03")
	private String PIS_FLEX_03;

	@Column(name = "PIS_FLEX_04")
	private String PIS_FLEX_04;*/
	
	@Column(name = "PIS_FLEX_03")
	private Date PIS_FLEX_03;

	@Column(name = "PIS_FLEX_04")
	private Date PIS_FLEX_04;

	@Column(name = "PIS_FLEX_05")
	private String PIS_FLEX_05;

	@Column(name = "PIS_FLEX_06")
	private String PIS_FLEX_06;

	@Column(name = "PIS_FLEX_07")
	private String PIS_FLEX_07;

	@Column(name = "PIS_FLEX_08")
	private String PIS_FLEX_08;

	@Column(name = "PIS_FLEX_09")
	private String PIS_FLEX_09;

	@Column(name = "PIS_FLEX_10")
	private String PIS_FLEX_10;

	@Column(name = "PIS_FLEX_29")
	private String PIS_FLEX_29;

	@Column(name = "PIS_FLEX_12")
	private String PIS_FLEX_12;

	@Column(name = "PIS_FLEX_13")
	private String PIS_FLEX_13;

	@Column(name = "PIS_FLEX_14")
	private String PIS_FLEX_14;

	@Column(name = "PIS_FLEX_15")
	private String PIS_FLEX_15;

	@Column(name = "PIS_FLEX_16")
	private String PIS_FLEX_16;

	@Column(name = "PIS_FLEX_17")
	private String PIS_FLEX_17;

	@Column(name = "PIS_FLEX_18")
	private String PIS_FLEX_18;

	@Column(name = "PIS_FLEX_19")
	private String PIS_FLEX_19;

	@Column(name = "PIS_FLEX_20")
	private String PIS_FLEX_20;

	@Column(name = "PIS_FLEX_21")
	private String PIS_FLEX_21;

	@Column(name = "PIS_FLEX_22")
	private String PIS_FLEX_22;

	@Column(name = "PIS_FLEX_23")
	private String PIS_FLEX_23;

	@Column(name = "PIS_SR_NO")
	private Integer PIS_SR_NO;

	@Column(name = "PIS_DT")
	private Date PIS_DT;

	@Column(name = "PIS_FC_MOP_INVEST_AMT")
	private Double PIS_FC_MOP_INVEST_AMT;

	@Column(name = "PIS_FC_OPBAL")
	private Double PIS_FC_OPBAL;

	@Column(name = "PIS_FC_TOTAL_CONTR")
	private Double PIS_FC_TOTAL_CONTR;

	@Column(name = "PIS_FC_TOTAL_INTEREST")
	private Double PIS_FC_TOTAL_INTEREST;

	@Column(name = "PIS_FC_CLBAL")
	private Double PIS_FC_CLBAL;

	@Column(name = "PIS_FC_CURR_SA")
	private Double PIS_FC_CURR_SA;

	@Column(name = "PIS_LC_MOP_INVEST_AMT")
	private Double PIS_LC_MOP_INVEST_AMT;

	@Column(name = "PIS_LC_OPBAL")
	private Double PIS_LC_OPBAL;

	@Column(name = "PIS_LC_TOTAL_CONTR")
	private Double PIS_LC_TOTAL_CONTR;

	@Column(name = "PIS_LC_TOTAL_INTEREST")
	private Double PIS_LC_TOTAL_INTEREST;

	@Column(name = "PIS_LC_CLBAL")
	private Double PIS_LC_CLBAL;

	@Column(name = "PIS_LC_CURR_SA")
	private Double PIS_LC_CURR_SA;

	@Column(name = "PIS_FC_MOP_GROSS_CONTR")
	private Double PIS_FC_MOP_GROSS_CONTR;

	@Column(name = "PIS_LC_MOP_GROSS_CONTR")
	private Double PIS_LC_MOP_GROSS_CONTR;

	@Column(name = "PIS_FC_MOP_NET_CONTR")
	private Double PIS_FC_MOP_NET_CONTR;

	@Column(name = "PIS_LC_MOP_NET_CONTR")
	private Double PIS_LC_MOP_NET_CONTR;

	@Column(name = "PIS_FC_MOP_INTEREST")
	private Double PIS_FC_MOP_INTEREST;

	@Column(name = "PIS_LC_MOP_INTEREST")
	private Double PIS_LC_MOP_INTEREST;

	@Column(name = "PIS_FC_OPBAL_INTEREST")
	private Double PIS_FC_OPBAL_INTEREST;

	@Column(name = "PIS_LC_OPBAL_INTEREST")
	private Double PIS_LC_OPBAL_INTEREST;

	@Column(name = "PIS_FC_RISK_SA")
	private Double PIS_FC_RISK_SA;

	@Column(name = "PIS_LC_RISK_SA")
	private Double PIS_LC_RISK_SA;
	

	public Double getPIS_FC_MOP_INTEREST() {
		return PIS_FC_MOP_INTEREST;
	}

	public void setPIS_FC_MOP_INTEREST(Double pis_fc_mop_interest) {
		PIS_FC_MOP_INTEREST = pis_fc_mop_interest;
	}

	public Double getPIS_LC_MOP_INTEREST() {
		return PIS_LC_MOP_INTEREST;
	}

	public void setPIS_LC_MOP_INTEREST(Double pis_lc_mop_interest) {
		PIS_LC_MOP_INTEREST = pis_lc_mop_interest;
	}

	public Double getPIS_FC_OPBAL_INTEREST() {
		return PIS_FC_OPBAL_INTEREST;
	}

	public void setPIS_FC_OPBAL_INTEREST(Double pis_fc_opbal_interest) {
		PIS_FC_OPBAL_INTEREST = pis_fc_opbal_interest;
	}

	public Double getPIS_LC_OPBAL_INTEREST() {
		return PIS_LC_OPBAL_INTEREST;
	}

	public void setPIS_LC_OPBAL_INTEREST(Double pis_lc_opbal_interest) {
		PIS_LC_OPBAL_INTEREST = pis_lc_opbal_interest;
	}

	public Double getPIS_FC_RISK_SA() {
		return PIS_FC_RISK_SA;
	}

	public void setPIS_FC_RISK_SA(Double pis_fc_risk_sa) {
		PIS_FC_RISK_SA = pis_fc_risk_sa;
	}

	public Double getPIS_LC_RISK_SA() {
		return PIS_LC_RISK_SA;
	}

	public void setPIS_LC_RISK_SA(Double pis_lc_risk_sa) {
		PIS_LC_RISK_SA = pis_lc_risk_sa;
	}

	public String getPIS_FLEX_11() {
		return PIS_FLEX_11;
	}

	public void setPIS_FLEX_11(String PIS_FLEX_11) {
		this.PIS_FLEX_11 = PIS_FLEX_11;
	}

	public String getPIS_FLEX_28() {
		return PIS_FLEX_28;
	}

	public void setPIS_FLEX_28(String PIS_FLEX_28) {
		this.PIS_FLEX_28 = PIS_FLEX_28;
	}

	public String getPIS_FLEX_27() {
		return PIS_FLEX_27;
	}

	public void setPIS_FLEX_27(String PIS_FLEX_27) {
		this.PIS_FLEX_27 = PIS_FLEX_27;
	}

	public String getPIS_FLEX_26() {
		return PIS_FLEX_26;
	}

	public void setPIS_FLEX_26(String PIS_FLEX_26) {
		this.PIS_FLEX_26 = PIS_FLEX_26;
	}

	public String getPIS_FLEX_25() {
		return PIS_FLEX_25;
	}

	public void setPIS_FLEX_25(String PIS_FLEX_25) {
		this.PIS_FLEX_25 = PIS_FLEX_25;
	}

	public String getPIS_FLEX_24() {
		return PIS_FLEX_24;
	}

	public void setPIS_FLEX_24(String PIS_FLEX_24) {
		this.PIS_FLEX_24 = PIS_FLEX_24;
	}

	public String getPIS_FLEX_30() {
		return PIS_FLEX_30;
	}

	public void setPIS_FLEX_30(String PIS_FLEX_30) {
		this.PIS_FLEX_30 = PIS_FLEX_30;
	}

	/*
	 * commented by Ameen on 26-05-2017 as per Gaurav sugg.
	 * public String getPIS_FLEX_01() {
		return PIS_FLEX_01;
	}

	public void setPIS_FLEX_01(String PIS_FLEX_01) {
		this.PIS_FLEX_01 = PIS_FLEX_01;
	}

	public String getPIS_FLEX_02() {
		return PIS_FLEX_02;
	}

	public void setPIS_FLEX_02(String PIS_FLEX_02) {
		this.PIS_FLEX_02 = PIS_FLEX_02;
	}*/
	
	

	public Double getPIS_FLEX_01() {
		return PIS_FLEX_01;
	}

	public void setPIS_FLEX_01(Double pIS_FLEX_01) {
		PIS_FLEX_01 = pIS_FLEX_01;
	}

	public Double getPIS_FLEX_02() {
		return PIS_FLEX_02;
	}

	public void setPIS_FLEX_02(Double pIS_FLEX_02) {
		PIS_FLEX_02 = pIS_FLEX_02;
	}
	
	/*
	 * commented by Ameen on 26-05-2017 as per Gaurav sugg.
	 * public String getPIS_FLEX_03() {
		return PIS_FLEX_03;
	}

	public void setPIS_FLEX_03(String PIS_FLEX_03) {
		this.PIS_FLEX_03 = PIS_FLEX_03;
	}

	public String getPIS_FLEX_04() {
		return PIS_FLEX_04;
	}

	public void setPIS_FLEX_04(String PIS_FLEX_04) {
		this.PIS_FLEX_04 = PIS_FLEX_04;
	}*/
	
	public String getPIS_FLEX_05() {
		return PIS_FLEX_05;
	}

	public Date getPIS_FLEX_03() {
		return PIS_FLEX_03;
	}

	public void setPIS_FLEX_03(Date pIS_FLEX_03) {
		PIS_FLEX_03 = pIS_FLEX_03;
	}

	public Date getPIS_FLEX_04() {
		return PIS_FLEX_04;
	}

	public void setPIS_FLEX_04(Date pIS_FLEX_04) {
		PIS_FLEX_04 = pIS_FLEX_04;
	}

	public void setPIS_FLEX_05(String PIS_FLEX_05) {
		this.PIS_FLEX_05 = PIS_FLEX_05;
	}

	public String getPIS_FLEX_06() {
		return PIS_FLEX_06;
	}

	public void setPIS_FLEX_06(String PIS_FLEX_06) {
		this.PIS_FLEX_06 = PIS_FLEX_06;
	}

	public String getPIS_FLEX_07() {
		return PIS_FLEX_07;
	}

	public void setPIS_FLEX_07(String PIS_FLEX_07) {
		this.PIS_FLEX_07 = PIS_FLEX_07;
	}

	public String getPIS_FLEX_08() {
		return PIS_FLEX_08;
	}

	public void setPIS_FLEX_08(String PIS_FLEX_08) {
		this.PIS_FLEX_08 = PIS_FLEX_08;
	}

	public String getPIS_FLEX_09() {
		return PIS_FLEX_09;
	}

	public void setPIS_FLEX_09(String PIS_FLEX_09) {
		this.PIS_FLEX_09 = PIS_FLEX_09;
	}

	public String getPIS_FLEX_10() {
		return PIS_FLEX_10;
	}

	public void setPIS_FLEX_10(String PIS_FLEX_10) {
		this.PIS_FLEX_10 = PIS_FLEX_10;
	}

	public String getPIS_FLEX_29() {
		return PIS_FLEX_29;
	}

	public void setPIS_FLEX_29(String PIS_FLEX_29) {
		this.PIS_FLEX_29 = PIS_FLEX_29;
	}

	public String getPIS_FLEX_12() {
		return PIS_FLEX_12;
	}

	public void setPIS_FLEX_12(String PIS_FLEX_12) {
		this.PIS_FLEX_12 = PIS_FLEX_12;
	}

	public String getPIS_FLEX_13() {
		return PIS_FLEX_13;
	}

	public void setPIS_FLEX_13(String PIS_FLEX_13) {
		this.PIS_FLEX_13 = PIS_FLEX_13;
	}

	public String getPIS_FLEX_14() {
		return PIS_FLEX_14;
	}

	public void setPIS_FLEX_14(String PIS_FLEX_14) {
		this.PIS_FLEX_14 = PIS_FLEX_14;
	}

	public String getPIS_FLEX_15() {
		return PIS_FLEX_15;
	}

	public void setPIS_FLEX_15(String PIS_FLEX_15) {
		this.PIS_FLEX_15 = PIS_FLEX_15;
	}

	public String getPIS_FLEX_16() {
		return PIS_FLEX_16;
	}

	public void setPIS_FLEX_16(String PIS_FLEX_16) {
		this.PIS_FLEX_16 = PIS_FLEX_16;
	}

	public String getPIS_FLEX_17() {
		return PIS_FLEX_17;
	}

	public void setPIS_FLEX_17(String PIS_FLEX_17) {
		this.PIS_FLEX_17 = PIS_FLEX_17;
	}

	public String getPIS_FLEX_18() {
		return PIS_FLEX_18;
	}

	public void setPIS_FLEX_18(String PIS_FLEX_18) {
		this.PIS_FLEX_18 = PIS_FLEX_18;
	}

	public String getPIS_FLEX_19() {
		return PIS_FLEX_19;
	}

	public void setPIS_FLEX_19(String PIS_FLEX_19) {
		this.PIS_FLEX_19 = PIS_FLEX_19;
	}

	public String getPIS_FLEX_20() {
		return PIS_FLEX_20;
	}

	public void setPIS_FLEX_20(String PIS_FLEX_20) {
		this.PIS_FLEX_20 = PIS_FLEX_20;
	}

	public String getPIS_FLEX_21() {
		return PIS_FLEX_21;
	}

	public void setPIS_FLEX_21(String PIS_FLEX_21) {
		this.PIS_FLEX_21 = PIS_FLEX_21;
	}

	public String getPIS_FLEX_22() {
		return PIS_FLEX_22;
	}

	public void setPIS_FLEX_22(String PIS_FLEX_22) {
		this.PIS_FLEX_22 = PIS_FLEX_22;
	}

	public String getPIS_FLEX_23() {
		return PIS_FLEX_23;
	}

	public void setPIS_FLEX_23(String PIS_FLEX_23) {
		this.PIS_FLEX_23 = PIS_FLEX_23;
	}

	public Long getPIS_POL_SYS_ID() {
		return PIS_POL_SYS_ID;
	}

	public void setPIS_POL_SYS_ID(Long pis_pol_sys_id) {
		PIS_POL_SYS_ID = pis_pol_sys_id;
	}

	public Long getPIS_PC_SYS_ID() {
		return PIS_PC_SYS_ID;
	}

	public void setPIS_PC_SYS_ID(Long pis_pc_sys_id) {
		PIS_PC_SYS_ID = pis_pc_sys_id;
	}

	public Long getPIS_PCD_SYS_ID() {
		return PIS_PCD_SYS_ID;
	}

	public void setPIS_PCD_SYS_ID(Long pis_pcd_sys_id) {
		PIS_PCD_SYS_ID = pis_pcd_sys_id;
	}

	public Integer getPIS_SR_NO() {
		return PIS_SR_NO;
	}

	public void setPIS_SR_NO(Integer pis_sr_no) {
		PIS_SR_NO = pis_sr_no;
	}

	public Date getPIS_DT() {
		return PIS_DT;
	}

	public void setPIS_DT(Date PIS_DT) {
		this.PIS_DT = PIS_DT;
	}

	public Double getPIS_FC_MOP_INVEST_AMT() {
		return PIS_FC_MOP_INVEST_AMT;
	}

	public void setPIS_FC_MOP_INVEST_AMT(Double PIS_FC_MOP_INVEST_AMT) {
		this.PIS_FC_MOP_INVEST_AMT = PIS_FC_MOP_INVEST_AMT;
	}

	public Double getPIS_FC_OPBAL() {
		return PIS_FC_OPBAL;
	}

	public void setPIS_FC_OPBAL(Double PIS_FC_OPBAL) {
		this.PIS_FC_OPBAL = PIS_FC_OPBAL;
	}

	public Double getPIS_FC_TOTAL_CONTR() {
		return PIS_FC_TOTAL_CONTR;
	}

	public void setPIS_FC_TOTAL_CONTR(Double PIS_FC_TOTAL_CONTR) {
		this.PIS_FC_TOTAL_CONTR = PIS_FC_TOTAL_CONTR;
	}

	public Double getPIS_FC_TOTAL_INTEREST() {
		return PIS_FC_TOTAL_INTEREST;
	}

	public void setPIS_FC_TOTAL_INTEREST(Double PIS_FC_TOTAL_INTEREST) {
		this.PIS_FC_TOTAL_INTEREST = PIS_FC_TOTAL_INTEREST;
	}

	public Double getPIS_FC_CLBAL() {
		return PIS_FC_CLBAL;
	}

	public void setPIS_FC_CLBAL(Double PIS_FC_CLBAL) {
		this.PIS_FC_CLBAL = PIS_FC_CLBAL;
	}

	public Double getPIS_FC_CURR_SA() {
		return PIS_FC_CURR_SA;
	}

	public void setPIS_FC_CURR_SA(Double PIS_FC_CURR_SA) {
		this.PIS_FC_CURR_SA = PIS_FC_CURR_SA;
	}

	public Double getPIS_LC_MOP_INVEST_AMT() {
		return PIS_LC_MOP_INVEST_AMT;
	}

	public void setPIS_LC_MOP_INVEST_AMT(Double PIS_LC_MOP_INVEST_AMT) {
		this.PIS_LC_MOP_INVEST_AMT = PIS_LC_MOP_INVEST_AMT;
	}

	public Double getPIS_LC_OPBAL() {
		return PIS_LC_OPBAL;
	}

	public void setPIS_LC_OPBAL(Double PIS_LC_OPBAL) {
		this.PIS_LC_OPBAL = PIS_LC_OPBAL;
	}

	public Double getPIS_LC_TOTAL_CONTR() {
		return PIS_LC_TOTAL_CONTR;
	}

	public void setPIS_LC_TOTAL_CONTR(Double PIS_LC_TOTAL_CONTR) {
		this.PIS_LC_TOTAL_CONTR = PIS_LC_TOTAL_CONTR;
	}

	public Double getPIS_LC_TOTAL_INTEREST() {
		return PIS_LC_TOTAL_INTEREST;
	}

	public void setPIS_LC_TOTAL_INTEREST(Double PIS_LC_TOTAL_INTEREST) {
		this.PIS_LC_TOTAL_INTEREST = PIS_LC_TOTAL_INTEREST;
	}

	public Double getPIS_LC_CLBAL() {
		return PIS_LC_CLBAL;
	}

	public void setPIS_LC_CLBAL(Double PIS_LC_CLBAL) {
		this.PIS_LC_CLBAL = PIS_LC_CLBAL;
	}

	public Double getPIS_LC_CURR_SA() {
		return PIS_LC_CURR_SA;
	}

	public void setPIS_LC_CURR_SA(Double PIS_LC_CURR_SA) {
		this.PIS_LC_CURR_SA = PIS_LC_CURR_SA;
	}

	public Long getPIS_SYS_ID() {
		return PIS_SYS_ID;
	}

	public void setPIS_SYS_ID(Long pis_sys_id) {
		PIS_SYS_ID = pis_sys_id;
	}

	public Double getPIS_FC_MOP_GROSS_CONTR() {
		return PIS_FC_MOP_GROSS_CONTR;
	}

	public void setPIS_FC_MOP_GROSS_CONTR(Double pis_fc_mop_gross_contr) {
		PIS_FC_MOP_GROSS_CONTR = pis_fc_mop_gross_contr;
	}

	public Double getPIS_LC_MOP_GROSS_CONTR() {
		return PIS_LC_MOP_GROSS_CONTR;
	}

	public void setPIS_LC_MOP_GROSS_CONTR(Double pis_lc_mop_gross_contr) {
		PIS_LC_MOP_GROSS_CONTR = pis_lc_mop_gross_contr;
	}

	public Double getPIS_FC_MOP_NET_CONTR() {
		return PIS_FC_MOP_NET_CONTR;
	}

	public void setPIS_FC_MOP_NET_CONTR(Double pis_fc_mop_net_contr) {
		PIS_FC_MOP_NET_CONTR = pis_fc_mop_net_contr;
	}

	public Double getPIS_LC_MOP_NET_CONTR() {
		return PIS_LC_MOP_NET_CONTR;
	}

	public void setPIS_LC_MOP_NET_CONTR(Double pis_lc_mop_net_contr) {
		PIS_LC_MOP_NET_CONTR = pis_lc_mop_net_contr;
	}
	
	/*ADDED BY RAJA ON 15-07-2017 FOR ZBILQC-1731999*/
	private String evenrecord;


	public String getEvenrecord() {
		return evenrecord;
	}

	public void setEvenrecord(String evenrecord) {
		this.evenrecord = evenrecord;
	}
	
	/*end*/

}