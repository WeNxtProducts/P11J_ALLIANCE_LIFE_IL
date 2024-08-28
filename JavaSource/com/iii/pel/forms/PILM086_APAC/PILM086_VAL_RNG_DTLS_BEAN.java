package com.iii.pel.forms.PILM086_APAC;






import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
@Table(name="PM_BUS_RULE_DTL3")
public class PILM086_VAL_RNG_DTLS_BEAN extends BaseValueBean{
	
	@Column(name="BRD3_VALUE_FM")
	private String BRD3_VALUE_FM;
	@Column(name="BRD3_VALUE_TO")	
	private String BRD3_VALUE_TO;
	@Column(name="BRD3_DATE_FM")
	private Date BRD3_DATE_FM;
	@Column(name="BRD3_DATE_TO")
	private Date BRD3_DATE_TO;
	@Column(name="BRD3_DTL_SNO")
	private int BRD3_DTL_SNO;
	@Column(name="BRD3_SYS_ID")
	private long BRD3_SYS_ID;
	
	
	/*added by raja*/
	
	@Column(name="BRD3_BRH_SYS_ID")
	private long BRD3_BRH_SYS_ID;
	
	@Column(name="BRD3_CR_DT")
	private Date BRD3_CR_DT;
	
	@Column(name="BRD3_UPD_DT")
	private Date BRD3_UPD_DT;
	
	@Column(name="BRD3_CR_UID")
	private String BRD3_CR_UID;
	
	@Column(name="BRD3_UPD_UID")
	private String BRD3_UPD_UID;
	
	
	/*end*/
	
	public long getBRD3_BRH_SYS_ID() {
		return BRD3_BRH_SYS_ID;
	}
	public void setBRD3_BRH_SYS_ID(long bRD3_BRH_SYS_ID) {
		BRD3_BRH_SYS_ID = bRD3_BRH_SYS_ID;
	}
	public Date getBRD3_CR_DT() {
		return BRD3_CR_DT;
	}
	public void setBRD3_CR_DT(Date bRD3_CR_DT) {
		BRD3_CR_DT = bRD3_CR_DT;
	}
	public Date getBRD3_UPD_DT() {
		return BRD3_UPD_DT;
	}
	public void setBRD3_UPD_DT(Date bRD3_UPD_DT) {
		BRD3_UPD_DT = bRD3_UPD_DT;
	}
	public String getBRD3_CR_UID() {
		return BRD3_CR_UID;
	}
	public void setBRD3_CR_UID(String bRD3_CR_UID) {
		BRD3_CR_UID = bRD3_CR_UID;
	}
	public String getBRD3_UPD_UID() {
		return BRD3_UPD_UID;
	}
	public void setBRD3_UPD_UID(String bRD3_UPD_UID) {
		BRD3_UPD_UID = bRD3_UPD_UID;
	}
	public long getBRD3_SYS_ID() {
		return BRD3_SYS_ID;
	}
	public void setBRD3_SYS_ID(long bRD3_SYS_ID) {
		BRD3_SYS_ID = bRD3_SYS_ID;
	}
	public String getBRD3_VALUE_FM() {
		return BRD3_VALUE_FM;
	}
	public void setBRD3_VALUE_FM(String bRD3_VALUE_FM) {
		BRD3_VALUE_FM = bRD3_VALUE_FM;
	}
	public String getBRD3_VALUE_TO() {
		return BRD3_VALUE_TO;
	}
	public void setBRD3_VALUE_TO(String bRD3_VALUE_TO) {
		BRD3_VALUE_TO = bRD3_VALUE_TO;
	}

	public Date getBRD3_DATE_FM() {
		return BRD3_DATE_FM;
	}
	public void setBRD3_DATE_FM(Date bRD3_DATE_FM) {
		BRD3_DATE_FM = bRD3_DATE_FM;
	}
	public Date getBRD3_DATE_TO() {
		return BRD3_DATE_TO;
	}
	public void setBRD3_DATE_TO(Date bRD3_DATE_TO) {
		BRD3_DATE_TO = bRD3_DATE_TO;
	}
	public int getBRD3_DTL_SNO() {
		return BRD3_DTL_SNO;
	}
	public void setBRD3_DTL_SNO(int bRD3_DTL_SNO) {
		BRD3_DTL_SNO = bRD3_DTL_SNO;
	}
	
	
	
	
	
	
	
}
