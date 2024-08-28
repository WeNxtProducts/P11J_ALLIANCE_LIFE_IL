package com.iii.pel.forms.PILP203;

import java.util.Date;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;


@Table(name = "PT_IL_POL_BROKER_HEAD_ORIGINAL")
public class PT_IL_POL_BROKER_HEAD_ORIGINAL extends BaseValueBean {
	
	@Column(name="POBH_ORI_POL_NO")
	private String POBH_ORI_POL_NO;
	@Column(name="POBH_ORI_POL_SYS_ID")
	private long POBH_ORI_POL_SYS_ID;
	@Column(name="POBH_ORI_AGENT_CODE")
	private String POBH_ORI_AGENT_CODE;
	@Column(name="POBH_ORI_SHARE_PERC")
	private double POBH_ORI_SHARE_PERC;
	@Column(name="POBH_ORI_COMMISSION")
	private double POBH_ORI_COMMISSION;
	private String POBH_ORI_AGENT_DESC;
	@Column(name="POBH_ORI_DATE")
	private Date POBH_ORI_DATE;
	private String UI_POBH_ORI_AGENT_CODE_DESC;
	
	public Date getPOBH_ORI_DATE() {
		return POBH_ORI_DATE;
	}
	public void setPOBH_ORI_DATE(java.util.Date value) {
		POBH_ORI_DATE = value;
	}
	public String getPOBH_ORI_POL_NO() {
		return POBH_ORI_POL_NO;
	}
	public void setPOBH_ORI_POL_NO(String pOBH_ORI_POL_NO) {
		POBH_ORI_POL_NO = pOBH_ORI_POL_NO;
	}
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
	public String getPOBH_ORI_AGENT_DESC() {
		return POBH_ORI_AGENT_DESC;
	}
	public void setPOBH_ORI_AGENT_DESC(String pOBH_ORI_AGENT_DESC) {
		POBH_ORI_AGENT_DESC = pOBH_ORI_AGENT_DESC;
	}
	
	private String UI_POBH_ORI_POL_NO_DESC;

	public String getUI_POBH_ORI_POL_NO_DESC() {
		return UI_POBH_ORI_POL_NO_DESC;
	}
	public void setUI_POBH_ORI_POL_NO_DESC(String uI_POBH_ORI_POL_NO_DESC) {
		UI_POBH_ORI_POL_NO_DESC = uI_POBH_ORI_POL_NO_DESC;
	}
	
	public String getUI_POBH_ORI_AGENT_CODE_DESC() {
		return UI_POBH_ORI_AGENT_CODE_DESC;
	}
	public void setUI_POBH_ORI_AGENT_CODE_DESC(String uI_POBH_ORI_AGENT_CODE_DESC) {
		UI_POBH_ORI_AGENT_CODE_DESC = uI_POBH_ORI_AGENT_CODE_DESC;
	}

}
