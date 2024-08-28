package com.iii.pel.forms.PILM086_APAC;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_BUS_RULE_DTL2")
public class PM_BUS_RULE_DTL2 extends BaseValueBean{

	@Column(name="BRD2_BRH_SYS_ID")
	private long BRD2_BRH_SYS_ID;
	
	@Column(name="BRD2_DTL_SNO")
	private int BRD2_DTL_SNO;
	
	@Column(name="BRD2_TAB_NAME")
	private String BRD2_TAB_NAME;
	
	@Column(name="BRD2_LINK_TAB_NAME")
	private String BRD2_LINK_TAB_NAME;
	
	@Column(name="BRD2_LINK_COL_NAME")
	private String BRD2_LINK_COL_NAME;
	
	@Column(name="BRD2_COL_NAME")
	private String BRD2_COL_NAME;
	
	@Column(name="BRD2_COL_FUNC")
	private String BRD2_COL_FUNC;
	
	@Column(name="BRD2_OPERATOR")
	private String BRD2_OPERATOR;
	
	@Column(name="BRD2_LINK_VALUE")
	private String BRD2_LINK_VALUE;
	
	private String BRD2_TAB_NAME_DESC;
	
	private String BRD2_COL_NAME_DESC;

	
	

	public long getBRD2_BRH_SYS_ID() {
		return BRD2_BRH_SYS_ID;
	}

	public void setBRD2_BRH_SYS_ID(long bRD2_BRH_SYS_ID) {
		BRD2_BRH_SYS_ID = bRD2_BRH_SYS_ID;
	}

	public int getBRD2_DTL_SNO() {
		return BRD2_DTL_SNO;
	}

	public void setBRD2_DTL_SNO(int bRD2_DTL_SNO) {
		BRD2_DTL_SNO = bRD2_DTL_SNO;
	}

	public String getBRD2_TAB_NAME() {
		return BRD2_TAB_NAME;
	}

	public void setBRD2_TAB_NAME(String bRD2_TAB_NAME) {
		BRD2_TAB_NAME = bRD2_TAB_NAME;
	}

	public String getBRD2_LINK_TAB_NAME() {
		return BRD2_LINK_TAB_NAME;
	}

	public void setBRD2_LINK_TAB_NAME(String bRD2_LINK_TAB_NAME) {
		BRD2_LINK_TAB_NAME = bRD2_LINK_TAB_NAME;
	}

	public String getBRD2_LINK_COL_NAME() {
		return BRD2_LINK_COL_NAME;
	}

	public void setBRD2_LINK_COL_NAME(String bRD2_LINK_COL_NAME) {
		BRD2_LINK_COL_NAME = bRD2_LINK_COL_NAME;
	}

	public String getBRD2_COL_NAME() {
		return BRD2_COL_NAME;
	}

	public void setBRD2_COL_NAME(String bRD2_COL_NAME) {
		BRD2_COL_NAME = bRD2_COL_NAME;
	}

	public String getBRD2_COL_FUNC() {
		return BRD2_COL_FUNC;
	}

	public void setBRD2_COL_FUNC(String bRD2_COL_FUNC) {
		BRD2_COL_FUNC = bRD2_COL_FUNC;
	}

	public String getBRD2_OPERATOR() {
		return BRD2_OPERATOR;
	}

	public void setBRD2_OPERATOR(String bRD2_OPERATOR) {
		BRD2_OPERATOR = bRD2_OPERATOR;
	}

	public String getBRD2_LINK_VALUE() {
		return BRD2_LINK_VALUE;
	}

	public void setBRD2_LINK_VALUE(String bRD2_LINK_VALUE) {
		BRD2_LINK_VALUE = bRD2_LINK_VALUE;
	}

	public String getBRD2_TAB_NAME_DESC() {
		return BRD2_TAB_NAME_DESC;
	}

	public void setBRD2_TAB_NAME_DESC(String bRD2_TAB_NAME_DESC) {
		BRD2_TAB_NAME_DESC = bRD2_TAB_NAME_DESC;
	}

	public String getBRD2_COL_NAME_DESC() {
		return BRD2_COL_NAME_DESC;
	}

	public void setBRD2_COL_NAME_DESC(String bRD2_COL_NAME_DESC) {
		BRD2_COL_NAME_DESC = bRD2_COL_NAME_DESC;
	}
	
}
