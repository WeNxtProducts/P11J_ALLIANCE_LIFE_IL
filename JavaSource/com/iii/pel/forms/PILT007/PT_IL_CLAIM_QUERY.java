package com.iii.pel.forms.PILT007;

import java.io.Serializable;

public class PT_IL_CLAIM_QUERY implements Cloneable, Serializable {
	
	private String CLAIM_NUMBER;
	private String POLICY_NUMBER;
	private String CLAIM_NUMBER_FILTER;
	private String POLICY_NUMBER_FILTER;
	private String ASSURED_NAME_FILTER;

	public String getCLAIM_NUMBER() {
		return CLAIM_NUMBER;
	}

	public void setCLAIM_NUMBER(String claim_number) {
		CLAIM_NUMBER = claim_number;
	}

	public String getPOLICY_NUMBER() {
		return POLICY_NUMBER;
	}

	public void setPOLICY_NUMBER(String policy_number) {
		POLICY_NUMBER = policy_number;
	}

	public String getCLAIM_NUMBER_FILTER() {
		return CLAIM_NUMBER_FILTER;
	}

	public void setCLAIM_NUMBER_FILTER(String claim_number_filter) {
		CLAIM_NUMBER_FILTER = claim_number_filter;
	}

	public String getPOLICY_NUMBER_FILTER() {
		return POLICY_NUMBER_FILTER;
	}

	public void setPOLICY_NUMBER_FILTER(String policy_number_filter) {
		POLICY_NUMBER_FILTER = policy_number_filter;
	}

	public String getASSURED_NAME_FILTER() {
		return ASSURED_NAME_FILTER;
	}

	public void setASSURED_NAME_FILTER(String assured_name_filter) {
		ASSURED_NAME_FILTER = assured_name_filter;
	}

}
