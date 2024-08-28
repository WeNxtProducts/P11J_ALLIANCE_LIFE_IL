package com.iii.pel.forms.PILT083;

import com.iii.apps.persistence.BaseValueBean;
import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name="SRST_REDEMPTION ")
public class SRST_REDEMPTION extends BaseValueBean{
	
 @Column(name="RDMP_SYS_ID")
 private  Long RDMP_SYS_ID ;
 
 @Column(name="RDMP_REQ")
 private String	RDMP_REQ;   
 
 @Column(name="RDMP_BY")
 private String	RDMP_BY;    
 
 @Column(name="RDMP_AMOUNT")
 private Double	RDMP_AMOUNT;
 
 @Column(name="RDMP_FUND_NAME")
 private String	RDMP_FUND_NAME;
                            
 @Column(name="RDMP_ALLOC_PERC") 
 private Double	RDMP_FUND_ALLOCATION;
 
 @Column(name="RDMP_AVAIL_NO_UNITS")
 private Integer	RDMP_AVAIL_NO_UNITS;    
 
 private Integer RDMP_AVAIL_NO_OF_UNITS;
 
 
 
 @Column(name="RDMP_HDR_SYS_ID")
 private Long	RDMP_HDR_SYS_ID;

public Long getRDMP_SYS_ID() {
	return RDMP_SYS_ID;
}

public void setRDMP_SYS_ID(Long rDMP_SYS_ID) {
	RDMP_SYS_ID = rDMP_SYS_ID;
}

public String getRDMP_REQ() {
	return RDMP_REQ;
}

public void setRDMP_REQ(String rDMP_REQ) {
	RDMP_REQ = rDMP_REQ;
}

public String getRDMP_BY() {
	return RDMP_BY;
}

public void setRDMP_BY(String rDMP_BY) {
	RDMP_BY = rDMP_BY;
}

public Double getRDMP_AMOUNT() {
	return RDMP_AMOUNT;
}

public void setRDMP_AMOUNT(Double rDMP_AMOUNT) {
	RDMP_AMOUNT = rDMP_AMOUNT;
}

public String getRDMP_FUND_NAME() {
	return RDMP_FUND_NAME;
}

public void setRDMP_FUND_NAME(String rDMP_FUND_NAME) {
	RDMP_FUND_NAME = rDMP_FUND_NAME;
}


public Double getRDMP_FUND_ALLOCATION() {
	return RDMP_FUND_ALLOCATION;
}

public void setRDMP_FUND_ALLOCATION(Double rDMP_FUND_ALLOCATION) {
	RDMP_FUND_ALLOCATION = rDMP_FUND_ALLOCATION;
}

public Integer getRDMP_AVAIL_NO_UNITS() {
	return RDMP_AVAIL_NO_UNITS;
}

public void setRDMP_AVAIL_NO_UNITS(Integer rDMP_AVAIL_NO_UNITS) {
	RDMP_AVAIL_NO_UNITS = rDMP_AVAIL_NO_UNITS;
}

public Long getRDMP_HDR_SYS_ID() {
	return RDMP_HDR_SYS_ID;
}

public void setRDMP_HDR_SYS_ID(Long rDMP_HDR_SYS_ID) {
	RDMP_HDR_SYS_ID = rDMP_HDR_SYS_ID;
}

public Integer getRDMP_AVAIL_NO_OF_UNITS() {
	return RDMP_AVAIL_NO_OF_UNITS;
}

public void setRDMP_AVAIL_NO_OF_UNITS(Integer rdmp_avail_no_of_units) {
	RDMP_AVAIL_NO_OF_UNITS = rdmp_avail_no_of_units;
}     
 
 
 

}
