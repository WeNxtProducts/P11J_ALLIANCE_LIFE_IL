package com.iii.pel.forms.PILP053_APAC;

import java.util.Date;

import com.iii.premia.common.bean.BaseValueBean;

//@Table(name = "")
public class SURRENDER extends BaseValueBean {

	//@Column(name = "UI_M_POL_PROD_CODE")
	private String UI_M_POL_PROD_CODE;

	//@Column(name = "UI_M_POL_PROD_CODE_DESC")
	private String UI_M_POL_PROD_CODE_DESC;

	//@Column(name = "UI_M_POL_CUST_CODE")
	private String UI_M_POL_CUST_CODE;

	//@Column(name = "UI_M_POL_CUST_NAME")
	private String UI_M_POL_CUST_NAME;

	//@Column(name = "UI_M_POL_PLAN_CODE")
	private String UI_M_POL_PLAN_CODE;

	//@Column(name = "UI_M_POL_PLAN_CODE_DESC")
	private String UI_M_POL_PLAN_CODE_DESC;

	//@Column(name = "UI_M_SMV_REASON_CODE")
	private String UI_M_SMV_REASON_CODE;

	//@Column(name = "UI_M_SMV_REASON_CODE_DESC")
	private String UI_M_SMV_REASON_CODE_DESC;

	//@Column(name = "UI_M_SMV_REMARKS")
	private String UI_M_SMV_REMARKS;

	//@Column(name = "UI_M_POL_START_DT")
	private Date UI_M_POL_START_DT;

	//@Column(name = "UI_M_POL_EXPIRY_DT")
	private Date UI_M_POL_EXPIRY_DT;

	//@Column(name = "UI_M_PC_SCHD_PYMT_DT")
	private Date UI_M_PC_SCHD_PYMT_DT;

	//@Column(name = "UI_M_N_PC_SCHD_PYMT_DT")
	private Date UI_M_N_PC_SCHD_PYMT_DT;

	//@Column(name = "UI_M_PC_SURR_LETTER_DATE")
	private Date UI_M_PC_SURR_LETTER_DATE;

	//@Column(name = "UI_M_M_PC_SCHD_PYMT_DT")
	private Date UI_M_M_PC_SCHD_PYMT_DT;

	//@Column(name = "UI_M_ASSURED_CODE")
	private String UI_M_ASSURED_CODE;

	//@Column(name = "UI_M_ASSURED_NAME")
	private String UI_M_ASSURED_NAME;

	//@Column(name = "SMV_FC_NET_PAID_AMT")
	private Double SMV_FC_NET_PAID_AMT ;

	//@Column(name = "UI_M_R_PC_SCHD_PYMT_DT")
	private Date UI_M_R_PC_SCHD_PYMT_DT;

	//Newly Added 

	private String UI_M_POL_NO;

	private Date UI_M_POL_TRAN_DT;

	private String UI_M_POL_DIVN_CODE;
	private String UI_M_POL_CLASS_CODE;
	private Integer UI_M_POL_UW_YEAR;

	private Double SMV_FC_RED_SA;

	private Double SMV_LC_RED_SA;

	private Double SMV_FC_ACC_PROFIT;

	private Double SMV_LC_ACC_PROFIT;

	public Double getSMV_FC_RED_SA() {
		return SMV_FC_RED_SA;
	}

	public void setSMV_FC_RED_SA(Double smv_fc_red_sa) {
		SMV_FC_RED_SA = smv_fc_red_sa;
	}

	public Double getSMV_LC_RED_SA() {
		return SMV_LC_RED_SA;
	}

	public void setSMV_LC_RED_SA(Double smv_lc_red_sa) {
		SMV_LC_RED_SA = smv_lc_red_sa;
	}

	public Double getSMV_FC_ACC_PROFIT() {
		return SMV_FC_ACC_PROFIT;
	}

	public void setSMV_FC_ACC_PROFIT(Double smv_fc_acc_profit) {
		SMV_FC_ACC_PROFIT = smv_fc_acc_profit;
	}

	public Double getSMV_LC_ACC_PROFIT() {
		return SMV_LC_ACC_PROFIT;
	}

	public void setSMV_LC_ACC_PROFIT(Double smv_lc_acc_profit) {
		SMV_LC_ACC_PROFIT = smv_lc_acc_profit;
	}

	public String getUI_M_POL_DIVN_CODE() {
		return UI_M_POL_DIVN_CODE;
	}

	public void setUI_M_POL_DIVN_CODE(String ui_m_pol_divn_code) {
		UI_M_POL_DIVN_CODE = ui_m_pol_divn_code;
	}

	public String getUI_M_POL_CLASS_CODE() {
		return UI_M_POL_CLASS_CODE;
	}

	public void setUI_M_POL_CLASS_CODE(String ui_m_pol_class_code) {
		UI_M_POL_CLASS_CODE = ui_m_pol_class_code;
	}

	public Integer getUI_M_POL_UW_YEAR() {
		return UI_M_POL_UW_YEAR;
	}

	public void setUI_M_POL_UW_YEAR(Integer ui_m_pol_uw_year) {
		UI_M_POL_UW_YEAR = ui_m_pol_uw_year;
	}

	public Date getUI_M_POL_TRAN_DT() {
		return UI_M_POL_TRAN_DT;
	}

	public void setUI_M_POL_TRAN_DT(Date uI_M_POL_TRAN_DT) {
		UI_M_POL_TRAN_DT = uI_M_POL_TRAN_DT;
	}

	public String getUI_M_POL_NO() {
		return UI_M_POL_NO;
	}

	public void setUI_M_POL_NO(String uI_M_POL_NO) {
		UI_M_POL_NO = uI_M_POL_NO;
	}

	public String getUI_M_POL_PROD_CODE() {
		return UI_M_POL_PROD_CODE;
	}

	public void setUI_M_POL_PROD_CODE(String UI_M_POL_PROD_CODE) {
		this.UI_M_POL_PROD_CODE = UI_M_POL_PROD_CODE;
	}

	public String getUI_M_POL_PROD_CODE_DESC() {
		return UI_M_POL_PROD_CODE_DESC;
	}

	public void setUI_M_POL_PROD_CODE_DESC(String UI_M_POL_PROD_CODE_DESC) {
		this.UI_M_POL_PROD_CODE_DESC = UI_M_POL_PROD_CODE_DESC;
	}

	public String getUI_M_POL_CUST_CODE() {
		return UI_M_POL_CUST_CODE;
	}

	public void setUI_M_POL_CUST_CODE(String UI_M_POL_CUST_CODE) {
		this.UI_M_POL_CUST_CODE = UI_M_POL_CUST_CODE;
	}

	public String getUI_M_POL_CUST_NAME() {
		return UI_M_POL_CUST_NAME;
	}

	public void setUI_M_POL_CUST_NAME(String UI_M_POL_CUST_NAME) {
		this.UI_M_POL_CUST_NAME = UI_M_POL_CUST_NAME;
	}

	public String getUI_M_POL_PLAN_CODE() {
		return UI_M_POL_PLAN_CODE;
	}

	public void setUI_M_POL_PLAN_CODE(String UI_M_POL_PLAN_CODE) {
		this.UI_M_POL_PLAN_CODE = UI_M_POL_PLAN_CODE;
	}

	public String getUI_M_POL_PLAN_CODE_DESC() {
		return UI_M_POL_PLAN_CODE_DESC;
	}

	public void setUI_M_POL_PLAN_CODE_DESC(String UI_M_POL_PLAN_CODE_DESC) {
		this.UI_M_POL_PLAN_CODE_DESC = UI_M_POL_PLAN_CODE_DESC;
	}

	public String getUI_M_SMV_REASON_CODE() {
		return UI_M_SMV_REASON_CODE;
	}

	public void setUI_M_SMV_REASON_CODE(String UI_M_SMV_REASON_CODE) {
		this.UI_M_SMV_REASON_CODE = UI_M_SMV_REASON_CODE;
	}

	public String getUI_M_SMV_REASON_CODE_DESC() {
		return UI_M_SMV_REASON_CODE_DESC;
	}

	public void setUI_M_SMV_REASON_CODE_DESC(String UI_M_SMV_REASON_CODE_DESC) {
		this.UI_M_SMV_REASON_CODE_DESC = UI_M_SMV_REASON_CODE_DESC;
	}

	public String getUI_M_SMV_REMARKS() {
		return UI_M_SMV_REMARKS;
	}

	public void setUI_M_SMV_REMARKS(String UI_M_SMV_REMARKS) {
		this.UI_M_SMV_REMARKS = UI_M_SMV_REMARKS;
	}

	public Date getUI_M_POL_START_DT() {
		return UI_M_POL_START_DT;
	}

	public void setUI_M_POL_START_DT(Date UI_M_POL_START_DT) {
		this.UI_M_POL_START_DT = UI_M_POL_START_DT;
	}

	public Date getUI_M_POL_EXPIRY_DT() {
		return UI_M_POL_EXPIRY_DT;
	}

	public void setUI_M_POL_EXPIRY_DT(Date UI_M_POL_EXPIRY_DT) {
		this.UI_M_POL_EXPIRY_DT = UI_M_POL_EXPIRY_DT;
	}

	public Date getUI_M_PC_SCHD_PYMT_DT() {
		return UI_M_PC_SCHD_PYMT_DT;
	}

	public void setUI_M_PC_SCHD_PYMT_DT(Date UI_M_PC_SCHD_PYMT_DT) {
		this.UI_M_PC_SCHD_PYMT_DT = UI_M_PC_SCHD_PYMT_DT;
	}

	public Date getUI_M_N_PC_SCHD_PYMT_DT() {
		return UI_M_N_PC_SCHD_PYMT_DT;
	}

	public void setUI_M_N_PC_SCHD_PYMT_DT(Date UI_M_N_PC_SCHD_PYMT_DT) {
		this.UI_M_N_PC_SCHD_PYMT_DT = UI_M_N_PC_SCHD_PYMT_DT;
	}

	public Date getUI_M_PC_SURR_LETTER_DATE() {
		return UI_M_PC_SURR_LETTER_DATE;
	}

	public void setUI_M_PC_SURR_LETTER_DATE(Date UI_M_PC_SURR_LETTER_DATE) {
		this.UI_M_PC_SURR_LETTER_DATE = UI_M_PC_SURR_LETTER_DATE;
	}

	public Date getUI_M_M_PC_SCHD_PYMT_DT() {
		return UI_M_M_PC_SCHD_PYMT_DT;
	}

	public void setUI_M_M_PC_SCHD_PYMT_DT(Date UI_M_M_PC_SCHD_PYMT_DT) {
		this.UI_M_M_PC_SCHD_PYMT_DT = UI_M_M_PC_SCHD_PYMT_DT;
	}

	public String getUI_M_ASSURED_CODE() {
		return UI_M_ASSURED_CODE;
	}

	public void setUI_M_ASSURED_CODE(String UI_M_ASSURED_CODE) {
		this.UI_M_ASSURED_CODE = UI_M_ASSURED_CODE;
	}

	public String getUI_M_ASSURED_NAME() {
		return UI_M_ASSURED_NAME;
	}

	public void setUI_M_ASSURED_NAME(String UI_M_ASSURED_NAME) {
		this.UI_M_ASSURED_NAME = UI_M_ASSURED_NAME;
	}

	public Double getSMV_FC_NET_PAID_AMT() {
		return SMV_FC_NET_PAID_AMT;
	}

	public void setSMV_FC_NET_PAID_AMT(Double SMV_FC_NET_PAID_AMT) {
		this.SMV_FC_NET_PAID_AMT = SMV_FC_NET_PAID_AMT;
	}

	public Date getUI_M_R_PC_SCHD_PYMT_DT() {
		return UI_M_R_PC_SCHD_PYMT_DT;
	}

	public void setUI_M_R_PC_SCHD_PYMT_DT(Date UI_M_R_PC_SCHD_PYMT_DT) {
		this.UI_M_R_PC_SCHD_PYMT_DT = UI_M_R_PC_SCHD_PYMT_DT;
	}
	
/*	added by ram*/

	
	private String UI_M_SURRENDER_CHRG;

	public String getUI_M_SURRENDER_CHRG() {
		return UI_M_SURRENDER_CHRG;
	}

	public void setUI_M_SURRENDER_CHRG(String uI_M_SURRENDER_CHRG) {
		UI_M_SURRENDER_CHRG = uI_M_SURRENDER_CHRG;
	}
	
	

/*end*/
}
