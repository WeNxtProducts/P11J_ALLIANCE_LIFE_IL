package com.iii.pel.forms.PILM040;


public class PM_IL_MASTER_POLICY_SETUP_SEARCH_PAGE{
	
	private String customerCode;
	private String productCode;
	private String policyNumber;
	private String SEARCH_BY_FAS_FUND_CODE_TO;
	private String FILTER_BY_FAS_SRC_BUS_FM;
	private String FILTER_BY_FAS_SRC_BUS_TO;
	private boolean selectedCheckBox;
	
	
	public boolean isSelectedCheckBox() {
		return selectedCheckBox;
	}
	public void setSelectedCheckBox(boolean selectedCheckBox) {
		this.selectedCheckBox = selectedCheckBox;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getSEARCH_BY_FAS_FUND_CODE_TO() {
		return SEARCH_BY_FAS_FUND_CODE_TO;
	}
	public void setSEARCH_BY_FAS_FUND_CODE_TO(String search_by_fas_fund_code_to) {
		SEARCH_BY_FAS_FUND_CODE_TO = search_by_fas_fund_code_to;
	}
	public String getFILTER_BY_FAS_SRC_BUS_FM() {
		return FILTER_BY_FAS_SRC_BUS_FM;
	}
	public void setFILTER_BY_FAS_SRC_BUS_FM(String filter_by_fas_src_bus_fm) {
		FILTER_BY_FAS_SRC_BUS_FM = filter_by_fas_src_bus_fm;
	}
	public String getFILTER_BY_FAS_SRC_BUS_TO() {
		return FILTER_BY_FAS_SRC_BUS_TO;
	}
	public void setFILTER_BY_FAS_SRC_BUS_TO(String filter_by_fas_src_bus_to) {
		FILTER_BY_FAS_SRC_BUS_TO = filter_by_fas_src_bus_to;
	}
	
	
	

}
