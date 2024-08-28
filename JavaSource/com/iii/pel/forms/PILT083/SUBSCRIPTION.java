package com.iii.pel.forms.PILT083;

import com.iii.apps.persistence.BaseValueBean;
import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name="SRST_SUBSCRIPTION")
public class SUBSCRIPTION extends BaseValueBean {
	
	@Column(name="SUBSCR_SYS_ID")
	private Long SUBSCR_SYS_ID;
	
	@Column(name="SUBSCR_AMOUNT")
	private Double SUBBSCR_AMOUNT;
	
	@Column(name="SUBSCR_FUND_NAME")
	private String  SUBSCR_FUND_NAME;
	
	@Column(name="SUBSCR_FUND_ALLOCATION")
	private  Double SUBSCR_FUND_ALLOCATION;
	
	@Column(name="SUBSCR_AVAIL_NO_OF_UNITS")
	private Double SUBSCR_AVAIL_NO_OF_UNITS;
	
	@Column(name="SUBSCR_HDR_SYS_ID")
	private Long SUBSCR_HDR_SYS_ID;
	
	public Long getSUBSCR_SYS_ID() {
		return SUBSCR_SYS_ID;
	}

	public void setSUBSCR_SYS_ID(Long sUBSCR_SYS_ID) {
		SUBSCR_SYS_ID = sUBSCR_SYS_ID;
	}

	public Long getSUBSCR_HDR_SYS_ID() {
		return SUBSCR_HDR_SYS_ID;
	}

	public void setSUBSCR_HDR_SYS_ID(Long sUBSCR_HDR_SYS_ID) {
		SUBSCR_HDR_SYS_ID = sUBSCR_HDR_SYS_ID;
	}

	public Double getSUBBSCR_AMOUNT() {
		return SUBBSCR_AMOUNT;
	}

	public void setSUBBSCR_AMOUNT(Double sUBBSCR_AMOUNT) {
		SUBBSCR_AMOUNT = sUBBSCR_AMOUNT;
	}

	public String getSUBSCR_FUND_NAME() {
		return SUBSCR_FUND_NAME;
	}

	public void setSUBSCR_FUND_NAME(String sUBSCR_FUND_NAME) {
		SUBSCR_FUND_NAME = sUBSCR_FUND_NAME;
	}

	public Double getSUBSCR_FUND_ALLOCATION() {
		return SUBSCR_FUND_ALLOCATION;
	}

	public void setSUBSCR_FUND_ALLOCATION(Double sUBSCR_FUND_ALLOCATION) {
		SUBSCR_FUND_ALLOCATION = sUBSCR_FUND_ALLOCATION;
	}

	public Double getSUBSCR_AVAIL_NO_OF_UNITS() {
		return SUBSCR_AVAIL_NO_OF_UNITS;
	}

	public void setSUBSCR_AVAIL_NO_OF_UNITS(Double sUBSCR_AVAIL_NO_OF_UNITS) {
		SUBSCR_AVAIL_NO_OF_UNITS = sUBSCR_AVAIL_NO_OF_UNITS;
	}
	
	
	

}
