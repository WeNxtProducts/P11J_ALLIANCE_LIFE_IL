package com.iii.pel.forms.PILM086_APAC;

 
import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;


@Table(name="PM_BUS_RULE_APPL_CUST")
public class PILM086_APAC_APP_CUS_BEAN extends BaseValueBean{

	@Column(name="BRAC_CUST_CLASS")
	private String BRAC_CUST_CLASS;
	@Column(name="BRAC_CUST_CLASS_DESC")
	private String BRAC_CUST_CLASS_DESC;
	
	@Column(name="BRAC_BRH_SYS_ID")
	private long BRAC_BRH_SYS_ID;
	@Column(name="BRAC_SYS_ID")
	private long BRAC_SYS_ID;
	
	
	

	public long getBRAC_BRH_SYS_ID() {
		return BRAC_BRH_SYS_ID;
	}
	public void setBRAC_BRH_SYS_ID(long bRAC_BRH_SYS_ID) {
		BRAC_BRH_SYS_ID = bRAC_BRH_SYS_ID;
	}
	public long getBRAC_SYS_ID() {
		return BRAC_SYS_ID;
	}
	public void setBRAC_SYS_ID(long bRAC_SYS_ID) {
		BRAC_SYS_ID = bRAC_SYS_ID;
	}
	public String getBRAC_CUST_CLASS() {
		return BRAC_CUST_CLASS;
	}
	public void setBRAC_CUST_CLASS(String bRAC_CUST_CLASS) {
		BRAC_CUST_CLASS = bRAC_CUST_CLASS;
	}
	public String getBRAC_CUST_CLASS_DESC() {
		return BRAC_CUST_CLASS_DESC;
	}
	public void setBRAC_CUST_CLASS_DESC(String bRAC_CUST_CLASS_DESC) {
		BRAC_CUST_CLASS_DESC = bRAC_CUST_CLASS_DESC;
	}

	
}
