package com.iii.pel.forms.PILT006_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_CLAIM_ESTIMATE")
public class PT_IL_CLAIM_ESTIMATE extends BaseValueBean {

	@Column(name="CE_SYS_ID")
	private Long CE_SYS_ID;

	@Column(name="CE_CLAIM_SYS_ID")
	private Long CE_CLAIM_SYS_ID;

	@Column(name="CE_EST_SETL_UNIT")
	private String CE_EST_SETL_UNIT;

	@Column(name="CE_EST_NO_OF_UNITS")
	private Double CE_EST_NO_OF_UNITS;

	@Column(name="CE_LC_EST_AMT")
	private Double CE_LC_EST_AMT;

	@Column(name="CE_FC_EST_AMT")
	private Double CE_FC_EST_AMT;

	@Column(name="CE_LC_PREM_OS")
	private Double CE_LC_PREM_OS;

	@Column(name="CE_FC_PREM_OS")
	private Double CE_FC_PREM_OS;

	@Column(name="CE_LC_LOAN_OS")
	private Double CE_LC_LOAN_OS;

	@Column(name="CE_FC_LOAN_OS")
	private Double CE_FC_LOAN_OS;

	@Column(name="CE_LC_LOAN_INT")
	private Double CE_LC_LOAN_INT;

	@Column(name="CE_FC_LOAN_INT")
	private Double CE_FC_LOAN_INT;

	@Column(name="CE_LC_ACC_PROFIT")
	private Double CE_LC_ACC_PROFIT;

	@Column(name="CE_FC_ACC_PROFIT")
	private Double CE_FC_ACC_PROFIT;

	@Column(name="CE_LC_NET_EST_AMT")
	private Double CE_LC_NET_EST_AMT;

	@Column(name="CE_FC_NET_EST_AMT")
	private Double CE_FC_NET_EST_AMT;

	@Column(name="CE_ACT_SETL_UNIT")
	private String CE_ACT_SETL_UNIT;

	@Column(name="CE_ACT_NO_OF_UNITS")
	private Double CE_ACT_NO_OF_UNITS;

	@Column(name="CE_SETL_START_DT")
	private Date CE_SETL_START_DT;

	@Column(name="CE_LC_PAID_AMT")
	private Double CE_LC_PAID_AMT;

	@Column(name="CE_FC_PAID_AMT")
	private Double CE_FC_PAID_AMT;

	@Column(name="CE_REF_NO")
	private String CE_REF_NO;

	@Column(name="CE_REMARKS")
	private String CE_REMARKS;

	@Column(name="CE_FRZ_FLAG")
	private String CE_FRZ_FLAG;

	@Column(name="CE_CLOSE_FLAG")
	private String CE_CLOSE_FLAG;

	@Column(name="CE_CR_UID")
	private String CE_CR_UID;

	@Column(name="CE_CR_DT")
	private Date CE_CR_DT;

	@Column(name="CE_UPD_UID")
	private String CE_UPD_UID;

	@Column(name="CE_UPD_DT")
	private Date CE_UPD_DT;

	@Column(name="CE_LC_PREM_OS_INT")
	private Double CE_LC_PREM_OS_INT;

	@Column(name="CE_FC_PREM_OS_INT")
	private Double CE_FC_PREM_OS_INT;

	@Column(name="CE_UNIT_LC_AMT")
	private Double CE_UNIT_LC_AMT;

	@Column(name="CE_UNIT_FC_AMT")
	private Double CE_UNIT_FC_AMT;

	@Column(name="CE_UNPAID_PREM_FLAG")
	private String CE_UNPAID_PREM_FLAG;

	

	

	private Double UI_M_CE_FC_EST_TOT_DED;
	private Double UI_M_CE_LC_EST_TOT_DED;

	public void setUI_M_CE_LC_EST_TOT_DED(Double UI_M_CE_LC_EST_TOT_DED) {
		this.UI_M_CE_LC_EST_TOT_DED = UI_M_CE_LC_EST_TOT_DED;
	}
	public Double getUI_M_CE_LC_EST_TOT_DED() {
		 return UI_M_CE_LC_EST_TOT_DED;
	}
	public void setCE_CLOSE_FLAG(String CE_CLOSE_FLAG) {
		this.CE_CLOSE_FLAG = CE_CLOSE_FLAG;
	}
	public String getCE_CLOSE_FLAG() {
		 return CE_CLOSE_FLAG;
	}
	public void setCE_FC_LOAN_OS(Double CE_FC_LOAN_OS) {
		this.CE_FC_LOAN_OS = CE_FC_LOAN_OS;
	}
	public Double getCE_FC_LOAN_OS() {
		 return CE_FC_LOAN_OS;
	}
	public void setCE_FC_PREM_OS(Double CE_FC_PREM_OS) {
		this.CE_FC_PREM_OS = CE_FC_PREM_OS;
	}
	public Double getCE_FC_PREM_OS() {
		 return CE_FC_PREM_OS;
	}
	public void setCE_CLAIM_SYS_ID(Long CE_CLAIM_SYS_ID) {
		this.CE_CLAIM_SYS_ID = CE_CLAIM_SYS_ID;
	}
	public Long getCE_CLAIM_SYS_ID() {
		 return CE_CLAIM_SYS_ID;
	}
	public void setCE_LC_NET_EST_AMT(Double CE_LC_NET_EST_AMT) {
		this.CE_LC_NET_EST_AMT = CE_LC_NET_EST_AMT;
	}
	public Double getCE_LC_NET_EST_AMT() {
		 return CE_LC_NET_EST_AMT;
	}
	public void setCE_UPD_DT(Date CE_UPD_DT) {
		this.CE_UPD_DT = CE_UPD_DT;
	}
	public Date getCE_UPD_DT() {
		 return CE_UPD_DT;
	}
	public void setCE_ACT_SETL_UNIT(String CE_ACT_SETL_UNIT) {
		this.CE_ACT_SETL_UNIT = CE_ACT_SETL_UNIT;
	}
	public String getCE_ACT_SETL_UNIT() {
		 return CE_ACT_SETL_UNIT;
	}
	public void setCE_UNIT_FC_AMT(Double CE_UNIT_FC_AMT) {
		this.CE_UNIT_FC_AMT = CE_UNIT_FC_AMT;
	}
	public Double getCE_UNIT_FC_AMT() {
		 return CE_UNIT_FC_AMT;
	}
	
	public void setCE_EST_SETL_UNIT(String CE_EST_SETL_UNIT) {
		this.CE_EST_SETL_UNIT = CE_EST_SETL_UNIT;
	}
	public String getCE_EST_SETL_UNIT() {
		 return CE_EST_SETL_UNIT;
	}
	public void setCE_LC_PREM_OS_INT(Double CE_LC_PREM_OS_INT) {
		this.CE_LC_PREM_OS_INT = CE_LC_PREM_OS_INT;
	}
	public Double getCE_LC_PREM_OS_INT() {
		 return CE_LC_PREM_OS_INT;
	}
	public void setCE_FC_LOAN_INT(Double CE_FC_LOAN_INT) {
		this.CE_FC_LOAN_INT = CE_FC_LOAN_INT;
	}
	public Double getCE_FC_LOAN_INT() {
		 return CE_FC_LOAN_INT;
	}
	public void setCE_FC_EST_AMT(Double CE_FC_EST_AMT) {
		this.CE_FC_EST_AMT = CE_FC_EST_AMT;
	}
	public Double getCE_FC_EST_AMT() {
		 return CE_FC_EST_AMT;
	}
	public void setCE_LC_EST_AMT(Double CE_LC_EST_AMT) {
		this.CE_LC_EST_AMT = CE_LC_EST_AMT;
	}
	public Double getCE_LC_EST_AMT() {
		 return CE_LC_EST_AMT;
	}
	public void setCE_UNPAID_PREM_FLAG(String CE_UNPAID_PREM_FLAG) {
		this.CE_UNPAID_PREM_FLAG = CE_UNPAID_PREM_FLAG;
	}
	public String getCE_UNPAID_PREM_FLAG() {
		 return CE_UNPAID_PREM_FLAG;
	}
	public void setCE_UNIT_LC_AMT(Double CE_UNIT_LC_AMT) {
		this.CE_UNIT_LC_AMT = CE_UNIT_LC_AMT;
	}
	public Double getCE_UNIT_LC_AMT() {
		 return CE_UNIT_LC_AMT;
	}
	public void setCE_FC_ACC_PROFIT(Double CE_FC_ACC_PROFIT) {
		this.CE_FC_ACC_PROFIT = CE_FC_ACC_PROFIT;
	}
	public Double getCE_FC_ACC_PROFIT() {
		 return CE_FC_ACC_PROFIT;
	}
	public void setCE_EST_NO_OF_UNITS(Double CE_EST_NO_OF_UNITS) {
		this.CE_EST_NO_OF_UNITS = CE_EST_NO_OF_UNITS;
	}
	public Double getCE_EST_NO_OF_UNITS() {
		 return CE_EST_NO_OF_UNITS;
	}
	public void setCE_FC_PREM_OS_INT(Double CE_FC_PREM_OS_INT) {
		this.CE_FC_PREM_OS_INT = CE_FC_PREM_OS_INT;
	}
	public Double getCE_FC_PREM_OS_INT() {
		 return CE_FC_PREM_OS_INT;
	}
	public void setCE_REMARKS(String CE_REMARKS) {
		this.CE_REMARKS = CE_REMARKS;
	}
	public String getCE_REMARKS() {
		 return CE_REMARKS;
	}
	
	public void setCE_REF_NO(String CE_REF_NO) {
		this.CE_REF_NO = CE_REF_NO;
	}
	public String getCE_REF_NO() {
		 return CE_REF_NO;
	}
	public void setCE_LC_LOAN_INT(Double CE_LC_LOAN_INT) {
		this.CE_LC_LOAN_INT = CE_LC_LOAN_INT;
	}
	public Double getCE_LC_LOAN_INT() {
		 return CE_LC_LOAN_INT;
	}
	public void setCE_LC_LOAN_OS(Double CE_LC_LOAN_OS) {
		this.CE_LC_LOAN_OS = CE_LC_LOAN_OS;
	}
	public Double getCE_LC_LOAN_OS() {
		 return CE_LC_LOAN_OS;
	}
	public void setCE_FC_NET_EST_AMT(Double CE_FC_NET_EST_AMT) {
		this.CE_FC_NET_EST_AMT = CE_FC_NET_EST_AMT;
	}
	public Double getCE_FC_NET_EST_AMT() {
		 return CE_FC_NET_EST_AMT;
	}
	public void setCE_SYS_ID(Long CE_SYS_ID) {
		this.CE_SYS_ID = CE_SYS_ID;
	}
	public Long getCE_SYS_ID() {
		 return CE_SYS_ID;
	}
	public void setCE_CR_DT(Date CE_CR_DT) {
		this.CE_CR_DT = CE_CR_DT;
	}
	public Date getCE_CR_DT() {
		 return CE_CR_DT;
	}
	public void setCE_LC_PREM_OS(Double CE_LC_PREM_OS) {
		this.CE_LC_PREM_OS = CE_LC_PREM_OS;
	}
	public Double getCE_LC_PREM_OS() {
		 return CE_LC_PREM_OS;
	}
	public void setUI_M_CE_FC_EST_TOT_DED(Double UI_M_CE_FC_EST_TOT_DED) {
		this.UI_M_CE_FC_EST_TOT_DED = UI_M_CE_FC_EST_TOT_DED;
	}
	public Double getUI_M_CE_FC_EST_TOT_DED() {
		 return UI_M_CE_FC_EST_TOT_DED;
	}
	public void setCE_ACT_NO_OF_UNITS(Double CE_ACT_NO_OF_UNITS) {
		this.CE_ACT_NO_OF_UNITS = CE_ACT_NO_OF_UNITS;
	}
	public Double getCE_ACT_NO_OF_UNITS() {
		 return CE_ACT_NO_OF_UNITS;
	}
	public void setCE_CR_UID(String CE_CR_UID) {
		this.CE_CR_UID = CE_CR_UID;
	}
	public String getCE_CR_UID() {
		 return CE_CR_UID;
	}
	public void setCE_SETL_START_DT(Date CE_SETL_START_DT) {
		this.CE_SETL_START_DT = CE_SETL_START_DT;
	}
	public Date getCE_SETL_START_DT() {
		 return CE_SETL_START_DT;
	}
	public void setCE_FC_PAID_AMT(Double CE_FC_PAID_AMT) {
		this.CE_FC_PAID_AMT = CE_FC_PAID_AMT;
	}
	public Double getCE_FC_PAID_AMT() {
		 return CE_FC_PAID_AMT;
	}
	public void setCE_FRZ_FLAG(String CE_FRZ_FLAG) {
		this.CE_FRZ_FLAG = CE_FRZ_FLAG;
	}
	public String getCE_FRZ_FLAG() {
		 return CE_FRZ_FLAG;
	}
	public void setCE_LC_PAID_AMT(Double CE_LC_PAID_AMT) {
		this.CE_LC_PAID_AMT = CE_LC_PAID_AMT;
	}
	public Double getCE_LC_PAID_AMT() {
		 return CE_LC_PAID_AMT;
	}
	public void setCE_UPD_UID(String CE_UPD_UID) {
		this.CE_UPD_UID = CE_UPD_UID;
	}
	public String getCE_UPD_UID() {
		 return CE_UPD_UID;
	}
	public void setCE_LC_ACC_PROFIT(Double CE_LC_ACC_PROFIT) {
		this.CE_LC_ACC_PROFIT = CE_LC_ACC_PROFIT;
	}
	public Double getCE_LC_ACC_PROFIT() {
		 return CE_LC_ACC_PROFIT;
	}
	
	//EXCESS AMOUNT FIELD AS PER SIVA SUGG. ADDED BY AMEEN ON 17/08/2016
	private Double UI_M_EXCESS_AMOUNT;

	public Double getUI_M_EXCESS_AMOUNT() {
		return UI_M_EXCESS_AMOUNT;
	}
	public void setUI_M_EXCESS_AMOUNT(Double uI_M_EXCESS_AMOUNT) {
		UI_M_EXCESS_AMOUNT = uI_M_EXCESS_AMOUNT;
	}
	//ADVANCE PREMIUM FIELD  ADDED BY SARANYA ON 26/08/2016
	private Double UI_M_ADVANCE_PREMIUM;

	public Double getUI_M_ADVANCE_PREMIUM() {
		return UI_M_ADVANCE_PREMIUM;
	}
	public void setUI_M_ADVANCE_PREMIUM(Double uI_M_ADVANCE_PREMIUM) {
		UI_M_ADVANCE_PREMIUM = uI_M_ADVANCE_PREMIUM;
	}
	/*end*/
	/*Added by saranya for Hands on point num 23 on 14/02/2017*/
	/*@Column(name="CE_FC_CLM_PROC_FEE")
	private Double CE_FC_CLM_PROC_FEE;
	
	@Column(name="CE_LC_CLM_PROC_FEE")
	private Double CE_LC_CLM_PROC_FEE;

	public Double getCE_FC_CLM_PROC_FEE() {
		return CE_FC_CLM_PROC_FEE;
	}
	public void setCE_FC_CLM_PROC_FEE(Double cE_FC_CLM_PROC_FEE) {
		CE_FC_CLM_PROC_FEE = cE_FC_CLM_PROC_FEE;
	}
	public Double getCE_LC_CLM_PROC_FEE() {
		return CE_LC_CLM_PROC_FEE;
	}
	public void setCE_LC_CLM_PROC_FEE(Double cE_LC_CLM_PROC_FEE) {
		CE_LC_CLM_PROC_FEE = cE_LC_CLM_PROC_FEE;
	}*/
	/*End*/
	/*Added by gopi for Hands on feed back point num 16 in ZB on 15/02/2017 
	@Column(name="CE_FC_FEE_PAID_HOSP")
	private Double CE_FC_FEE_PAID_HOSP;

	public Double getCE_FC_FEE_PAID_HOSP() {
		return CE_FC_FEE_PAID_HOSP;
	}
	public void setCE_FC_FEE_PAID_HOSP(Double cE_FC_FEE_PAID_HOSP) {
		CE_FC_FEE_PAID_HOSP = cE_FC_FEE_PAID_HOSP;
	}
	@Column(name="CE_LC_FEE_PAID_HOSP")
	private Double CE_LC_FEE_PAID_HOSP;

	public Double getCE_LC_FEE_PAID_HOSP() {
		return CE_LC_FEE_PAID_HOSP;
	}
	public void setCE_LC_FEE_PAID_HOSP(Double cE_LC_FEE_PAID_HOSP) {
		CE_LC_FEE_PAID_HOSP = cE_LC_FEE_PAID_HOSP;
	}
	
	end*/
	
	/*Added by gopi for Hands on feed back point num 16 in ZB on 24/02/2017 */
	@Column(name="CE_TOTAL_CHRG_AMT")
	private Double CE_TOTAL_CHRG_AMT;

	public Double getCE_TOTAL_CHRG_AMT() {
		return CE_TOTAL_CHRG_AMT;
	}
	public void setCE_TOTAL_CHRG_AMT(Double cE_TOTAL_CHRG_AMT) {
		CE_TOTAL_CHRG_AMT = cE_TOTAL_CHRG_AMT;
	}
	
	

}
