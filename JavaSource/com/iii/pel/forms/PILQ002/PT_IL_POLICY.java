package com.iii.pel.forms.PILQ002;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name="PT_IL_POLICY")
public class PT_IL_POLICY {
//	[Muthu Added
	@Column(name="POL_SYS_ID")
	private Long POL_SYS_ID;
	
	@Column(name="ROWID")
	private String ROWID;
	
	private String M_DUMMY;
	
	private String M_POL_PLAN_CODE;

	private String M_POL_PROD_CODE;
	
	@Column(name="POL_DS_TYPE")
	private String POL_DS_TYPE;
	
	@Column(name="POL_DS_CODE")
	private String POL_DS_CODE;
	
	public String getPOL_DS_TYPE() {
		return POL_DS_TYPE;
	}

	public void setPOL_DS_TYPE(String pol_ds_type) {
		POL_DS_TYPE = pol_ds_type;
	}

	public String getPOL_DS_CODE() {
		return POL_DS_CODE;
	}

	public void setPOL_DS_CODE(String pol_ds_code) {
		POL_DS_CODE = pol_ds_code;
	}

	public Long getPOL_SYS_ID() {
		return POL_SYS_ID;
	}

	public void setPOL_SYS_ID(Long pol_sys_id) {
		POL_SYS_ID = pol_sys_id;
	}

	public String getM_DUMMY() {
		return M_DUMMY;
	}

	public void setM_DUMMY(String m_dummy) {
		M_DUMMY = m_dummy;
	}

	public String getM_POL_PLAN_CODE() {
		return M_POL_PLAN_CODE;
	}

	public void setM_POL_PLAN_CODE(String m_pol_plan_code) {
		M_POL_PLAN_CODE = m_pol_plan_code;
	}

	public String getM_POL_PROD_CODE() {
		return M_POL_PROD_CODE;
	}

	public void setM_POL_PROD_CODE(String m_pol_prod_code) {
		M_POL_PROD_CODE = m_pol_prod_code;
	}
//	Muthu Added]
	
	
	@Column(name="POL_NO")
	private String POL_NO;

	@Column(name="POL_ASSRD_REF_ID1")
	private String POL_ASSRD_REF_ID1;

	@Column(name="POL_ASSRD_REF_ID2")
	private String POL_ASSRD_REF_ID2;

	@Column(name="POL_ISSUE_DT")
	private Date POL_ISSUE_DT;

	@Column(name="POL_START_DT")
	private Date POL_START_DT;

	@Column(name="POL_PROD_CODE")
	private String POL_PROD_CODE;

	@Column(name="POL_PLAN_CODE")
	private String POL_PLAN_CODE;

	@Column(name="POL_CUST_CODE")
	private String POL_CUST_CODE;

	@Column(name="POL_RES_ADDRESS_1")
	private String POL_RES_ADDRESS_1;

	@Column(name="POL_RES_ADDRESS_2")
	private String POL_RES_ADDRESS_2;

	@Column(name="POL_RES_ADDRESS_3")
	private String POL_RES_ADDRESS_3;

	private String UI_M_PROD_DESC;

	private String UI_M_PLAN_DESC;

	private String UI_M_CUST_DESC;

	@Column(name="POL_EXPIRY_DT")
	private Date POL_EXPIRY_DT;

	public String getPOL_NO() {
		return POL_NO;
	}

	public void setPOL_NO(String POL_NO) {
		this.POL_NO = POL_NO;
	}

	public String getPOL_ASSRD_REF_ID1() {
		return POL_ASSRD_REF_ID1;
	}

	public void setPOL_ASSRD_REF_ID1(String POL_ASSRD_REF_ID1) {
		this.POL_ASSRD_REF_ID1 = POL_ASSRD_REF_ID1;
	}

	public String getPOL_ASSRD_REF_ID2() {
		return POL_ASSRD_REF_ID2;
	}

	public void setPOL_ASSRD_REF_ID2(String POL_ASSRD_REF_ID2) {
		this.POL_ASSRD_REF_ID2 = POL_ASSRD_REF_ID2;
	}

	public Date getPOL_ISSUE_DT() {
		 return POL_ISSUE_DT;
	}

	public void setPOL_ISSUE_DT(Date POL_ISSUE_DT) {
		this.POL_ISSUE_DT = POL_ISSUE_DT;
	}

	public Date getPOL_START_DT() {
		 return POL_START_DT;
	}

	public void setPOL_START_DT(Date POL_START_DT) {
		this.POL_START_DT = POL_START_DT;
	}

	public String getPOL_PROD_CODE() {
		return POL_PROD_CODE;
	}

	public void setPOL_PROD_CODE(String POL_PROD_CODE) {
		this.POL_PROD_CODE = POL_PROD_CODE;
	}

	public String getPOL_PLAN_CODE() {
		return POL_PLAN_CODE;
	}

	public void setPOL_PLAN_CODE(String POL_PLAN_CODE) {
		this.POL_PLAN_CODE = POL_PLAN_CODE;
	}

	public String getPOL_CUST_CODE() {
		return POL_CUST_CODE;
	}

	public void setPOL_CUST_CODE(String POL_CUST_CODE) {
		this.POL_CUST_CODE = POL_CUST_CODE;
	}

	public String getPOL_RES_ADDRESS_1() {
		return POL_RES_ADDRESS_1;
	}

	public void setPOL_RES_ADDRESS_1(String POL_RES_ADDRESS_1) {
		this.POL_RES_ADDRESS_1 = POL_RES_ADDRESS_1;
	}

	public String getPOL_RES_ADDRESS_2() {
		return POL_RES_ADDRESS_2;
	}

	public void setPOL_RES_ADDRESS_2(String POL_RES_ADDRESS_2) {
		this.POL_RES_ADDRESS_2 = POL_RES_ADDRESS_2;
	}

	public String getPOL_RES_ADDRESS_3() {
		return POL_RES_ADDRESS_3;
	}

	public void setPOL_RES_ADDRESS_3(String POL_RES_ADDRESS_3) {
		this.POL_RES_ADDRESS_3 = POL_RES_ADDRESS_3;
	}

	public String getUI_M_PROD_DESC() {
		return UI_M_PROD_DESC;
	}

	public void setUI_M_PROD_DESC(String UI_M_PROD_DESC) {
		this.UI_M_PROD_DESC = UI_M_PROD_DESC;
	}

	public String getUI_M_PLAN_DESC() {
		return UI_M_PLAN_DESC;
	}

	public void setUI_M_PLAN_DESC(String UI_M_PLAN_DESC) {
		this.UI_M_PLAN_DESC = UI_M_PLAN_DESC;
	}

	public String getUI_M_CUST_DESC() {
		return UI_M_CUST_DESC;
	}

	public void setUI_M_CUST_DESC(String UI_M_CUST_DESC) {
		this.UI_M_CUST_DESC = UI_M_CUST_DESC;
	}

	public Date getPOL_EXPIRY_DT() {
		 return POL_EXPIRY_DT;
	}

	public void setPOL_EXPIRY_DT(Date POL_EXPIRY_DT) {
		this.POL_EXPIRY_DT = POL_EXPIRY_DT;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	//added by agalya for ssp call- FALCONQC-1715634
	
	private Date UI_LAST_PREM_PAID_DATE;
	private Date UI_LAST_UNPAID_PREM_DUE_DATE;
	private Double UI_SURR_VALUE;
	private Double UM_EXCESS_DEPOSIT;
	private Double LOAN_FC_UNPAID_PREM;
	private Double LOAN_FC_UNPAID_PREM_INT;
	public Double getUM_EXCESS_DEPOSIT() {
		return UM_EXCESS_DEPOSIT;
	}

	public void setUM_EXCESS_DEPOSIT(Double uM_EXCESS_DEPOSIT) {
		UM_EXCESS_DEPOSIT = uM_EXCESS_DEPOSIT;
	}


	private Double LOAN_FC_OS_AMOUNT;
	public Double getLOAN_FC_UNPAID_PREM() {
		return LOAN_FC_UNPAID_PREM;
	}

	public void setLOAN_FC_UNPAID_PREM(Double lOAN_FC_UNPAID_PREM) {
		LOAN_FC_UNPAID_PREM = lOAN_FC_UNPAID_PREM;
	}

	public Double getLOAN_FC_UNPAID_PREM_INT() {
		return LOAN_FC_UNPAID_PREM_INT;
	}

	public void setLOAN_FC_UNPAID_PREM_INT(Double lOAN_FC_UNPAID_PREM_INT) {
		LOAN_FC_UNPAID_PREM_INT = lOAN_FC_UNPAID_PREM_INT;
	}

	public Double getLOAN_FC_OS_AMOUNT() {
		return LOAN_FC_OS_AMOUNT;
	}

	public void setLOAN_FC_OS_AMOUNT(Double lOAN_FC_OS_AMOUNT) {
		LOAN_FC_OS_AMOUNT = lOAN_FC_OS_AMOUNT;
	}

	public Double getLOAN_FC_OS_LOAN_INT() {
		return LOAN_FC_OS_LOAN_INT;
	}

	public void setLOAN_FC_OS_LOAN_INT(Double lOAN_FC_OS_LOAN_INT) {
		LOAN_FC_OS_LOAN_INT = lOAN_FC_OS_LOAN_INT;
	}


	private Double LOAN_FC_OS_LOAN_INT;
	
	public Double getUI_PAIDUP_VALUE() {
		return UI_PAIDUP_VALUE;
	}

	public void setUI_PAIDUP_VALUE(Double uI_PAIDUP_VALUE) {
		UI_PAIDUP_VALUE = uI_PAIDUP_VALUE;
	}


	private Double UI_PAIDUP_VALUE;

	
	public Date getUI_LAST_PREM_PAID_DATE() {
		return UI_LAST_PREM_PAID_DATE;
	}

	public void setUI_LAST_PREM_PAID_DATE(Date uI_LAST_PREM_PAID_DATE) {
		UI_LAST_PREM_PAID_DATE = uI_LAST_PREM_PAID_DATE;
	}

	public Date getUI_LAST_UNPAID_PREM_DUE_DATE() {
		return UI_LAST_UNPAID_PREM_DUE_DATE;
	}

	public void setUI_LAST_UNPAID_PREM_DUE_DATE(Date uI_LAST_UNPAID_PREM_DUE_DATE) {
		UI_LAST_UNPAID_PREM_DUE_DATE = uI_LAST_UNPAID_PREM_DUE_DATE;
	}

	public Double getUI_SURR_VALUE() {
		return UI_SURR_VALUE;
	}

	public Date getAS_ON_DT() {
		return AS_ON_DT;
	}

	public void setAS_ON_DT(Date aS_ON_DT) {
		AS_ON_DT = aS_ON_DT;
	}

	public void setUI_SURR_VALUE(Double uI_SURR_VALUE) {
		UI_SURR_VALUE = uI_SURR_VALUE;
	}
	
	private Date AS_ON_DT;
	
	
	//end
	
	/*added by gopi for quotation print on 30/05/17*/
	private String UI_M_QUOT_TYPE;

	public String getUI_M_QUOT_TYPE() {
		return UI_M_QUOT_TYPE;
	}

	public void setUI_M_QUOT_TYPE(String uI_M_QUOT_TYPE) {
		UI_M_QUOT_TYPE = uI_M_QUOT_TYPE;
	}
	
	//end
	
	
	
	
}
