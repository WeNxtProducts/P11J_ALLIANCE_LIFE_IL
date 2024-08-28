/**
 * 
 */
package com.iii.pel.forms.PILQ109;

import java.util.Date;

/**
 * @author 55944
 *
 */
public class PT_IL_CLAIM extends com.iii.premia.common.bean.BaseValueBean{
	/*
	 * 
	 */
	private String CLAIM_NO;
	/*
	 * 
	 */
	private Date CLAIM_DATE;
	/*
	 * 
	 */
	private Double CLAIM_AMOUNT;
	
	public String getCLAIM_NO() {
		return CLAIM_NO;
	}
	public void setCLAIM_NO(String claim_no) {
		CLAIM_NO = claim_no;
	}
	public Date getCLAIM_DATE() {
		return CLAIM_DATE;
	}
	public void setCLAIM_DATE(Date claim_date) {
		CLAIM_DATE = claim_date;
	}
	public Double getCLAIM_AMOUNT() {
		return CLAIM_AMOUNT;
	}
	public void setCLAIM_AMOUNT(Double claim_amount) {
		CLAIM_AMOUNT = claim_amount;
	}
	
	
}
