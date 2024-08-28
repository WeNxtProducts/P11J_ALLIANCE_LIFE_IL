package com.iii.pel.forms.PILM086_APAC;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
@Table(name="PM_BUS_RULE_APPL_USER_GROUP")
public class PILM086_APP_USRS_BEAN extends BaseValueBean{
	@Column(name="BRAUG_UG_ID")
	private String BRAUG_UG_ID;
	@Column(name="BRAUG_UG_DESC")
	private String BRAUG_UG_DESC;
	@Column(name="BRAUG_BRH_SYS_ID")
	public long BRAUG_BRH_SYS_ID;
	
	



	public long getBRAUG_BRH_SYS_ID() {
		return BRAUG_BRH_SYS_ID;
	}
	public void setBRAUG_BRH_SYS_ID(long bRAUG_BRH_SYS_ID) {
		BRAUG_BRH_SYS_ID = bRAUG_BRH_SYS_ID;
	}
	public String getBRAUG_UG_ID() {
		return BRAUG_UG_ID;
	}
	public void setBRAUG_UG_ID(String bRAUG_UG_ID) {
		BRAUG_UG_ID = bRAUG_UG_ID;
	}
	public String getBRAUG_UG_DESC() {
		return BRAUG_UG_DESC;
	}
	public void setBRAUG_UG_DESC(String bRAUG_UG_DESC) {
		BRAUG_UG_DESC = bRAUG_UG_DESC;
	}

}
