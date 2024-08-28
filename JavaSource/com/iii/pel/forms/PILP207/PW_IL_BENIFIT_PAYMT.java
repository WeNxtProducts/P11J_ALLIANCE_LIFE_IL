package com.iii.pel.forms.PILP207;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PW_IL_BENIFIT_PAYMT")
public class PW_IL_BENIFIT_PAYMT extends BaseValueBean {
	
	@Column(name="PIBP_CLIENT_ID")
	private String PIBP_CLIENT_ID;
	
	@Column(name="PIBP_POLICY_ID")
	private String PIBP_POLICY_ID;
	
	@Column(name="PIBP_CLIENT_NAME")
	private String PIBP_CLIENT_NAME;
	
	@Column(name="PIBP_ACC_NUMBER")
	private String PIBP_ACC_NUMBER;
	
	@Column(name="PIBP_ACC_TYPE")
	private String PIBP_ACC_TYPE;
	
	@Column(name="PIBP_BANK_CODE")
	private String PIBP_BANK_CODE;
	
	@Column(name="PIBP_BRANCH_SHORT_CODE")
	private String PIBP_BRANCH_SHORT_CODE;
	
	@Column(name="PIBP_ACC_NAME")
	private String PIBP_ACC_NAME;
	
	@Column(name="PIBP_PAYMENT_DT")
	private Date PIBP_PAYMENT_DT;
	
	@Column(name="PIBP_AMOUNT")
	private double PIBP_AMOUNT;
	
	@Column(name="PIBP_LIFE_TYPE")
	private String PIBP_LIFE_TYPE;
	
	@Column(name="PIBP_COMPANY")
	private String PIBP_COMPANY;
	
	@Column(name="PIBP_GROSS_AMOUNT")
	private Double PIBP_GROSS_AMOUNT;
	
	@Column(name="PIBP_MED_AID_DEDUCTION")
	private Double PIBP_MED_AID_DEDUCTION;
	
	@Column(name="PIBP_POL_PREMIUM")
	private Double PIBP_POL_PREMIUM;
	
	@Column(name="PIBP_PAYE")
	private Double PIBP_PAYE;
	
	@Column(name="PIBP_LOST_POL_FEES")
	private Double PIBP_LOST_POL_FEES;
	
	@Column(name="PIBP_PROCSS_FEES")
	private Double PIBP_PROCSS_FEES;
	
	@Column(name="PIBP_BANK_TRANSFER_FEES")
	private Double PIBP_BANK_TRANSFER_FEES;
	
	@Column(name="PIBP_OUT_STANDING_LOAN")
	private Double PIBP_OUT_STANDING_LOAN;
	
	@Column(name="PIBP_OTHRS_CHARGE")
	private Double PIBP_OTHRS_CHARGE;
	
	@Column(name="PIBP_NET_AMOUNT")
	private Double PIBP_NET_AMOUNT;
	
	@Column(name="PIBP_PROD_CODE")
	private String PIBP_PROD_CODE;
	
	@Column(name="PIBP_FILE_NAME")
	private String PIBP_FILE_NAME;
	
	public String[] RE_GEN_FILE_NAME;
	
	public String[] getRE_GEN_FILE_NAME() {
		return RE_GEN_FILE_NAME;
	}

	public void setRE_GEN_FILE_NAME(String[] rE_GEN_FILE_NAME) {
		RE_GEN_FILE_NAME = rE_GEN_FILE_NAME;
	}
	

	public String getPIBP_FILE_NAME() {
		return PIBP_FILE_NAME;
	}

	public void setPIBP_FILE_NAME(String pIBP_FILE_NAME) {
		PIBP_FILE_NAME = pIBP_FILE_NAME;
	}

	private Date UI_M_PIBP_PAYMENT_FM_DT;
	private Date UI_M_PIBP_PAYMENT_TO_DT;
	
	private Date UI_M_PIBP_RE_GEN_FM_DT;
	private Date UI_M_PIBP_RE_GEN_TO_DT;
	
	
	

	public Date getUI_M_PIBP_RE_GEN_FM_DT() {
		return UI_M_PIBP_RE_GEN_FM_DT;
	}

	public void setUI_M_PIBP_RE_GEN_FM_DT(Date uI_M_PIBP_RE_GEN_FM_DT) {
		UI_M_PIBP_RE_GEN_FM_DT = uI_M_PIBP_RE_GEN_FM_DT;
	}

	public Date getUI_M_PIBP_RE_GEN_TO_DT() {
		return UI_M_PIBP_RE_GEN_TO_DT;
	}

	public void setUI_M_PIBP_RE_GEN_TO_DT(Date uI_M_PIBP_RE_GEN_TO_DT) {
		UI_M_PIBP_RE_GEN_TO_DT = uI_M_PIBP_RE_GEN_TO_DT;
	}

	public String getPIBP_PROD_CODE() {
		return PIBP_PROD_CODE;
	}

	public void setPIBP_PROD_CODE(String pIBP_PROD_CODE) {
		PIBP_PROD_CODE = pIBP_PROD_CODE;
	}

	public String getPIBP_CLIENT_ID() {
		return PIBP_CLIENT_ID;
	}

	public void setPIBP_CLIENT_ID(String pIBP_CLIENT_ID) {
		PIBP_CLIENT_ID = pIBP_CLIENT_ID;
	}

	public String getPIBP_POLICY_ID() {
		return PIBP_POLICY_ID;
	}

	public void setPIBP_POLICY_ID(String pIBP_POLICY_ID) {
		PIBP_POLICY_ID = pIBP_POLICY_ID;
	}

	public String getPIBP_CLIENT_NAME() {
		return PIBP_CLIENT_NAME;
	}

	public void setPIBP_CLIENT_NAME(String pIBP_CLIENT_NAME) {
		PIBP_CLIENT_NAME = pIBP_CLIENT_NAME;
	}

	public String getPIBP_ACC_NUMBER() {
		return PIBP_ACC_NUMBER;
	}

	public void setPIBP_ACC_NUMBER(String pIBP_ACC_NUMBER) {
		PIBP_ACC_NUMBER = pIBP_ACC_NUMBER;
	}

	public String getPIBP_ACC_TYPE() {
		return PIBP_ACC_TYPE;
	}

	public void setPIBP_ACC_TYPE(String pIBP_ACC_TYPE) {
		PIBP_ACC_TYPE = pIBP_ACC_TYPE;
	}

	public String getPIBP_BANK_CODE() {
		return PIBP_BANK_CODE;
	}

	public void setPIBP_BANK_CODE(String pIBP_BANK_CODE) {
		PIBP_BANK_CODE = pIBP_BANK_CODE;
	}

	public String getPIBP_BRANCH_SHORT_CODE() {
		return PIBP_BRANCH_SHORT_CODE;
	}

	public void setPIBP_BRANCH_SHORT_CODE(String pIBP_BRANCH_SHORT_CODE) {
		PIBP_BRANCH_SHORT_CODE = pIBP_BRANCH_SHORT_CODE;
	}

	public String getPIBP_ACC_NAME() {
		return PIBP_ACC_NAME;
	}

	public void setPIBP_ACC_NAME(String pIBP_ACC_NAME) {
		PIBP_ACC_NAME = pIBP_ACC_NAME;
	}

	public Date getPIBP_PAYMENT_DT() {
		return PIBP_PAYMENT_DT;
	}

	public void setPIBP_PAYMENT_DT(Date pIBP_PAYMENT_DT) {
		PIBP_PAYMENT_DT = pIBP_PAYMENT_DT;
	}

	public double getPIBP_AMOUNT() {
		return PIBP_AMOUNT;
	}

	public void setPIBP_AMOUNT(double d) {
		PIBP_AMOUNT = d;
	}

	public String getPIBP_LIFE_TYPE() {
		return PIBP_LIFE_TYPE;
	}

	public void setPIBP_LIFE_TYPE(String pIBP_LIFE_TYPE) {
		PIBP_LIFE_TYPE = pIBP_LIFE_TYPE;
	}

	public String getPIBP_COMPANY() {
		return PIBP_COMPANY;
	}

	public void setPIBP_COMPANY(String pIBP_COMPANY) {
		PIBP_COMPANY = pIBP_COMPANY;
	}

	public Double getPIBP_GROSS_AMOUNT() {
		return PIBP_GROSS_AMOUNT;
	}

	public void setPIBP_GROSS_AMOUNT(Double pIBP_GROSS_AMOUNT) {
		PIBP_GROSS_AMOUNT = pIBP_GROSS_AMOUNT;
	}

	public Double getPIBP_MED_AID_DEDUCTION() {
		return PIBP_MED_AID_DEDUCTION;
	}

	public void setPIBP_MED_AID_DEDUCTION(Double pIBP_MED_AID_DEDUCTION) {
		PIBP_MED_AID_DEDUCTION = pIBP_MED_AID_DEDUCTION;
	}

	public Double getPIBP_POL_PREMIUM() {
		return PIBP_POL_PREMIUM;
	}

	public void setPIBP_POL_PREMIUM(Double pIBP_POL_PREMIUM) {
		PIBP_POL_PREMIUM = pIBP_POL_PREMIUM;
	}

	public Double getPIBP_PAYE() {
		return PIBP_PAYE;
	}

	public void setPIBP_PAYE(Double pIBP_PAYE) {
		PIBP_PAYE = pIBP_PAYE;
	}

	public Double getPIBP_LOST_POL_FEES() {
		return PIBP_LOST_POL_FEES;
	}

	public void setPIBP_LOST_POL_FEES(Double pIBP_LOST_POL_FEES) {
		PIBP_LOST_POL_FEES = pIBP_LOST_POL_FEES;
	}

	public Double getPIBP_PROCSS_FEES() {
		return PIBP_PROCSS_FEES;
	}

	public void setPIBP_PROCSS_FEES(Double pIBP_PROCSS_FEES) {
		PIBP_PROCSS_FEES = pIBP_PROCSS_FEES;
	}

	public Double getPIBP_BANK_TRANSFER_FEES() {
		return PIBP_BANK_TRANSFER_FEES;
	}

	public void setPIBP_BANK_TRANSFER_FEES(Double pIBP_BANK_TRANSFER_FEES) {
		PIBP_BANK_TRANSFER_FEES = pIBP_BANK_TRANSFER_FEES;
	}

	public Double getPIBP_OUT_STANDING_LOAN() {
		return PIBP_OUT_STANDING_LOAN;
	}

	public void setPIBP_OUT_STANDING_LOAN(Double pIBP_OUT_STANDING_LOAN) {
		PIBP_OUT_STANDING_LOAN = pIBP_OUT_STANDING_LOAN;
	}

	public Double getPIBP_OTHRS_CHARGE() {
		return PIBP_OTHRS_CHARGE;
	}

	public void setPIBP_OTHRS_CHARGE(Double pIBP_OTHRS_CHARGE) {
		PIBP_OTHRS_CHARGE = pIBP_OTHRS_CHARGE;
	}

	public Double getPIBP_NET_AMOUNT() {
		return PIBP_NET_AMOUNT;
	}

	public void setPIBP_NET_AMOUNT(Double pIBP_NET_AMOUNT) {
		PIBP_NET_AMOUNT = pIBP_NET_AMOUNT;
	}

	public Date getUI_M_PIBP_PAYMENT_FM_DT() {
		return UI_M_PIBP_PAYMENT_FM_DT;
	}

	public void setUI_M_PIBP_PAYMENT_FM_DT(Date uI_M_PIBP_PAYMENT_FM_DT) {
		UI_M_PIBP_PAYMENT_FM_DT = uI_M_PIBP_PAYMENT_FM_DT;
	}

	public Date getUI_M_PIBP_PAYMENT_TO_DT() {
		return UI_M_PIBP_PAYMENT_TO_DT;
	}

	public void setUI_M_PIBP_PAYMENT_TO_DT(Date uI_M_PIBP_PAYMENT_TO_DT) {
		UI_M_PIBP_PAYMENT_TO_DT = uI_M_PIBP_PAYMENT_TO_DT;
	}
	
	
	
	
	
}
