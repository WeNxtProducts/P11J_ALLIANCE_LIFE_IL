package com.iii.pel.forms.PILT002_APAC;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POL_BROKER_HEAD_ORIGINAL")
public class PT_IL_POL_BROKER_HEAD_ORIGINAL extends BaseValueBean {
	@Column(name="POBH_ORI_POL_SYS_ID")
	private long POBH_ORI_POL_SYS_ID;
	@Column(name="POBH_ORI_AGENT_CODE")
	private String POBH_ORI_AGENT_CODE;
	@Column(name="POBH_ORI_SHARE_PERC")
	private double POBH_ORI_SHARE_PERC;
	@Column(name="POBH_ORI_COMMISSION")
	private double POBH_ORI_COMMISSION;
	
	public long getPOBH_ORI_POL_SYS_ID() {
		return POBH_ORI_POL_SYS_ID;
	}
	public void setPOBH_ORI_POL_SYS_ID(long pOBH_ORI_POL_SYS_ID) {
		POBH_ORI_POL_SYS_ID = pOBH_ORI_POL_SYS_ID;
	}
	public String getPOBH_ORI_AGENT_CODE() {
		return POBH_ORI_AGENT_CODE;
	}
	public void setPOBH_ORI_AGENT_CODE(String pOBH_ORI_AGENT_CODE) {
		POBH_ORI_AGENT_CODE = pOBH_ORI_AGENT_CODE;
	}
	public double getPOBH_ORI_SHARE_PERC() {
		return POBH_ORI_SHARE_PERC;
	}
	public void setPOBH_ORI_SHARE_PERC(double pOBH_ORI_SHARE_PERC) {
		POBH_ORI_SHARE_PERC = pOBH_ORI_SHARE_PERC;
	}
	public double getPOBH_ORI_COMMISSION() {
		return POBH_ORI_COMMISSION;
	}
	public void setPOBH_ORI_COMMISSION(double pOBH_ORI_COMMISSION) {
		POBH_ORI_COMMISSION = pOBH_ORI_COMMISSION;
	}
	
	
	

}
