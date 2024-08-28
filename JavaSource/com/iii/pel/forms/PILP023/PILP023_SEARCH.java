package com.iii.pel.forms.PILP023;

import java.io.Serializable;

public class PILP023_SEARCH implements Serializable{
	
	private String initPolNo;
	private String initTxnType;
	private String CBH_TXN_TYPE;
	private String CBH_POL_NO;
	private String CBH_POL_ISSUE_DT;
	private String CBH_POL_SYS_ID;
	
	public String getInitPolNo() {
		return initPolNo;
	}
	public void setInitPolNo(String initPolNo) {
		this.initPolNo = initPolNo;
	}
	public String getInitTxnType() {
		return initTxnType;
	}
	public void setInitTxnType(String initTxnType) {
		this.initTxnType = initTxnType;
	}
	public String getCBH_TXN_TYPE() {
		return CBH_TXN_TYPE;
	}
	public void setCBH_TXN_TYPE(String cbh_txn_type) {
		CBH_TXN_TYPE = cbh_txn_type;
	}
	public String getCBH_POL_NO() {
		return CBH_POL_NO;
	}
	public void setCBH_POL_NO(String cbh_pol_no) {
		CBH_POL_NO = cbh_pol_no;
	}
	public String getCBH_POL_ISSUE_DT() {
		return CBH_POL_ISSUE_DT;
	}
	public void setCBH_POL_ISSUE_DT(String cbh_pol_issue_dt) {
		CBH_POL_ISSUE_DT = cbh_pol_issue_dt;
	}
	public String getCBH_POL_SYS_ID() {
		return CBH_POL_SYS_ID;
	}
	public void setCBH_POL_SYS_ID(String cbh_pol_sys_id) {
		CBH_POL_SYS_ID = cbh_pol_sys_id;
	}

}
