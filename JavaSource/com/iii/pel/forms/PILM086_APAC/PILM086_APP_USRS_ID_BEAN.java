package com.iii.pel.forms.PILM086_APAC;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
@Table(name="PM_BUS_RULE_APPL_USER")
public class PILM086_APP_USRS_ID_BEAN extends BaseValueBean{
	@Column(name="BRAU_USER_ID")
	private String BRAU_USER_ID;
	@Column(name="BRAU_USER_DESC")
	private String BRAU_USER_DESC;
	public String getBRAU_USER_ID() {
		return BRAU_USER_ID;
	}
	public void setBRAU_USER_ID(String bRAU_USER_ID) {
		BRAU_USER_ID = bRAU_USER_ID;
	}
	public String getBRAU_USER_DESC() {
		return BRAU_USER_DESC;
	}
	public void setBRAU_USER_DESC(String bRAU_USER_DESC) {
		BRAU_USER_DESC = bRAU_USER_DESC;
	}
	

}
