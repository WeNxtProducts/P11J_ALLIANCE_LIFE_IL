package com.iii.pel.common.workflow;

import java.util.Date;

import com.iii.premia.common.utils.CommonUtils;



public class Pgiw_wf_tran_dtls {
	private String createUserDate;
	private String createUserName;
	private String customerName;
	private String divisionName;
	private String fromDate;
	private String policyNumber;
	private String productName;
	private String quotationNumber;
	private String toDate;
	private String claimNumber;
	private String estimateAmount;
	/* Added by kavitha for RoadMap*/
	private String fullWithdrawal;
	private String withdrawalDate;
	private String UI_M_CREATE_USER_DATE;
	private String UI_M_DUE_DATE;
	private Date taskDueDate;
	private Date taskAssignedDate;
	private String UI_M_TASK_ASSIGNED_DT;
	private String UI_M_TASK_DUE_DT;
	private String customerCode;
	private String nationalId;
	private String assignTaskTo;
	private String sys_Id;
	/*End*/
	/*Added by kavitha on 10.12.2019 for orient ocd workflow*/
	private String transactionType;
	private String transactionReqNo;
	private String transactionApprovalDate;
	private String status;
	
	
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getQuotationNumber() {
		return quotationNumber;
	}
	public void setQuotationNumber(String quotationNumber) {
		this.quotationNumber = quotationNumber;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getClaimNumber() {
		return claimNumber;
	}
	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}
	public String getEstimateAmount() {
		return estimateAmount;
	}
	public void setEstimateAmount(String estimateAmount) {
		this.estimateAmount = estimateAmount;
	}
	/* Added by kavitha for RoadMap*/
	public String getFullWithdrawal() {
		return fullWithdrawal;
	}
	public void setFullWithdrawal(String fullWithdrawal) {
		this.fullWithdrawal = fullWithdrawal;
	}
	public String getWithdrawalDate() {
		return withdrawalDate;
	}
	public void setWithdrawalDate(String withdrawalDate) {
		this.withdrawalDate = withdrawalDate;
	}
	public String getUI_M_CREATE_USER_DATE() {
		return UI_M_CREATE_USER_DATE;
	}
	public void setUI_M_CREATE_USER_DATE(String uI_M_CREATE_USER_DATE) {
		UI_M_CREATE_USER_DATE = uI_M_CREATE_USER_DATE;
	}
	public String getCreateUserDate() {
		return createUserDate;
	}
	public void setCreateUserDate(String createUserDate) {
		this.createUserDate = createUserDate;
	}
	public String getUI_M_DUE_DATE() {
		return UI_M_DUE_DATE;
	}
	public void setUI_M_DUE_DATE(String uI_M_DUE_DATE) {
		UI_M_DUE_DATE = uI_M_DUE_DATE;
	}
	
	
	public Date getTaskAssignedDate() {
		return taskAssignedDate;
	}
	public void setTaskAssignedDate(Date taskAssignedDate) {
		UI_M_TASK_ASSIGNED_DT = CommonUtils.dateToPELStringFormatterWithTimeStamp(taskAssignedDate);
		this.taskAssignedDate = taskAssignedDate;
	}
	public String getUI_M_TASK_ASSIGNED_DT() {
		return UI_M_TASK_ASSIGNED_DT;
	}
	public void setUI_M_TASK_ASSIGNED_DT(String uI_M_TASK_ASSIGNED_DT) {
		UI_M_TASK_ASSIGNED_DT = uI_M_TASK_ASSIGNED_DT;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getNationalId() {
		return nationalId;
	}
	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}
	public Date getTaskDueDate() {
		return taskDueDate;
	}
	public void setTaskDueDate(Date taskDueDate) {
		UI_M_TASK_DUE_DT = CommonUtils.dateToPELStringFormatterWithTimeStamp(taskDueDate);
		this.taskDueDate = taskDueDate;
	}
	public String getUI_M_TASK_DUE_DT() {
		return UI_M_TASK_DUE_DT;
	}
	public void setUI_M_TASK_DUE_DT(String uI_M_TASK_DUE_DT) {
		UI_M_TASK_DUE_DT = uI_M_TASK_DUE_DT;
	}
	public String getSys_Id() {
		return sys_Id;
	}
	public void setSys_Id(String sys_Id) {
		this.sys_Id = sys_Id;
	}
	public String getAssignTaskTo() {
		return assignTaskTo;
	}
	public void setAssignTaskTo(String assignTaskTo) {
		this.assignTaskTo = assignTaskTo;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionReqNo() {
		return transactionReqNo;
	}
	public void setTransactionReqNo(String transactionReqNo) {
		this.transactionReqNo = transactionReqNo;
	}
	public String getTransactionApprovalDate() {
		return transactionApprovalDate;
	}
	public void setTransactionApprovalDate(String transactionApprovalDate) {
		this.transactionApprovalDate = transactionApprovalDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	/*End*/
	
	
	
	
}
