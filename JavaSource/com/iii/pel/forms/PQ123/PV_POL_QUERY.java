package com.iii.pel.forms.PQ123;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PV_POL_QUERY")
public class PV_POL_QUERY extends BaseValueBean {

	@Column(name="POL_MODULE")
	private String POL_MODULE;

	@Column(name="POL_NO")
	private String POL_NO;

	@Column(name="POL_ISSUE_DT")
	private Date POL_ISSUE_DT;

	@Column(name="POL_LC_SUM_ASSURED")
	private Double POL_LC_SUM_ASSURED;

	@Column(name="POL_LC_PREM")
	private String POL_LC_PREM;

	@Column(name="POL_EXPIRY_DT")
	private Date POL_EXPIRY_DT;

	@Column(name="POL_APPRV_STATUS")
	private String POL_APPRV_STATUS;

	private String CUST_CODE;
	
	private String CUST_DESC;
	
	@Column(name="POL_SYS_ID")
	private Double POL_SYS_ID;
	
	private boolean selected;

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Double getPOL_SYS_ID() {
		return POL_SYS_ID;
	}

	public String getPOL_APPRV_STATUS() {
		return POL_APPRV_STATUS;
	}

	public void setPOL_APPRV_STATUS(String pol_apprv_status) {
		POL_APPRV_STATUS = pol_apprv_status;
	}

	public void setPOL_SYS_ID(Double pol_sys_id) {
		POL_SYS_ID = pol_sys_id;
	}

	public String getCUST_CODE() {
		return CUST_CODE;
	}

	public void setCUST_CODE(String cust_code) {
		CUST_CODE = cust_code;
	}

	public String getCUST_DESC() {
		return CUST_DESC;
	}

	public void setCUST_DESC(String cust_desc) {
		CUST_DESC = cust_desc;
	}

	public String getPOL_MODULE() {
		return POL_MODULE;
	}

	public void setPOL_MODULE(String POL_MODULE) {
		this.POL_MODULE = POL_MODULE;
	}

	public String getPOL_NO() {
		return POL_NO;
	}

	public void setPOL_NO(String POL_NO) {
		this.POL_NO = POL_NO;
	}

	public Date getPOL_ISSUE_DT() {
		 return POL_ISSUE_DT;
	}

	public void setPOL_ISSUE_DT(Date POL_ISSUE_DT) {
		this.POL_ISSUE_DT = POL_ISSUE_DT;
	}

	public Double getPOL_LC_SUM_ASSURED() {
		return POL_LC_SUM_ASSURED;
	}

	public void setPOL_LC_SUM_ASSURED(Double POL_LC_SUM_ASSURED) {
		this.POL_LC_SUM_ASSURED = POL_LC_SUM_ASSURED;
	}

	public String getPOL_LC_PREM() {
		return POL_LC_PREM;
	}

	public void setPOL_LC_PREM(String POL_LC_PREM) {
		this.POL_LC_PREM = POL_LC_PREM;
	}

	public Date getPOL_EXPIRY_DT() {
		 return POL_EXPIRY_DT;
	}

	public void setPOL_EXPIRY_DT(Date POL_EXPIRY_DT) {
		this.POL_EXPIRY_DT = POL_EXPIRY_DT;
	}




}
