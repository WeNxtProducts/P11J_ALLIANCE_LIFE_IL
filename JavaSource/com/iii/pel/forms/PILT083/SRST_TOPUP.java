package com.iii.pel.forms.PILT083;

import com.iii.apps.persistence.BaseValueBean;
import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name="SRST_TOPUP")
public class SRST_TOPUP extends BaseValueBean {

@Column(name="TUP_SYS_ID")	
private Long	TUP_SYS_ID;       

@Column(name="TUP_FUND_NAME")
private String	TUP_FUND_NAME;     

@Column(name="TUP_FUND_ALLOC")
private Double	TUP_FUND_ALLOCATION;  

@Column(name="TUP_AVAIL_NO_OF_UNITS")
private Integer	TUP_AVAIL_NO_OF_UNITS ; 

@Column(name="TUP_HDR_SYS_ID")
private Long	TUP_HDR_SYS_ID;

@Column(name="TUP_AMOUNT")
private Double TUP_AMOUNT;

public Double getTUP_AMOUNT() {
	return TUP_AMOUNT;
}

public void setTUP_AMOUNT(Double tup_amount) {
	TUP_AMOUNT = tup_amount;
}

public Long getTUP_SYS_ID() {
	return TUP_SYS_ID;
}

public void setTUP_SYS_ID(Long tUP_SYS_ID) {
	TUP_SYS_ID = tUP_SYS_ID;
}

public String getTUP_FUND_NAME() {
	return TUP_FUND_NAME;
}

public void setTUP_FUND_NAME(String tUP_FUND_NAME) {
	TUP_FUND_NAME = tUP_FUND_NAME;
}




public Double getTUP_FUND_ALLOCATION() {
	return TUP_FUND_ALLOCATION;
}

public void setTUP_FUND_ALLOCATION(Double tUP_FUND_ALLOCATION) {
	TUP_FUND_ALLOCATION = tUP_FUND_ALLOCATION;
}

public Integer getTUP_AVAIL_NO_OF_UNITS() {
	return TUP_AVAIL_NO_OF_UNITS;
}

public void setTUP_AVAIL_NO_OF_UNITS(Integer tUP_AVAIL_NO_OF_UNITS) {
	TUP_AVAIL_NO_OF_UNITS = tUP_AVAIL_NO_OF_UNITS;
}

public Long getTUP_HDR_SYS_ID() {
	return TUP_HDR_SYS_ID;
}

public void setTUP_HDR_SYS_ID(Long tUP_HDR_SYS_ID) {
	TUP_HDR_SYS_ID = tUP_HDR_SYS_ID;
}          



}
