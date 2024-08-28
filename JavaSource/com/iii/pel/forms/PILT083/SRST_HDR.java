package com.iii.pel.forms.PILT083;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="SRST_HEADER")
public class SRST_HDR extends BaseValueBean{

	@Column(name="SRST_SYS_ID")
	private Long SRST_SYS_ID;
	
	@Column(name="SRST_REF_NO")
	private String SRST_REF_NO;
	
	@Column(name="SRST_POL_CENTER")
	private String  SRST_POL_CENTER;
	
	@Column(name="SRST_POL_CUST_NAME")
	private String  SRST_POL_CUST_NAME;
	
	@Column(name="SRST_POL_CUST_CODE")
	private String SRST_POL_CUST_CODE;
	
	@Column(name="SRST_POL_PROD_NAME")
	private String SRST_POL_PROD_NAME;
	
	@Column(name="SRST_POL_NO")
	private String SRST_POL_NO;
	
	@Column(name="SRST_DT")
	private Date SRST_DT;
	
	@Column(name="SRST_REQ_TYPE")
	private String SRST_REQ_TYPE;
	
	
	
	public Long getSRST_SYS_ID() {
		return SRST_SYS_ID;
	}
	public void setSRST_SYS_ID(Long srst_sys_id) {
		SRST_SYS_ID = srst_sys_id;
	}
	public String getSRST_REF_NO() {
		return SRST_REF_NO;
	}
	public void setSRST_REF_NO(String srst_ref_no) {
		SRST_REF_NO = srst_ref_no;
	}
	public String getSRST_POL_CENTER() {
		return SRST_POL_CENTER;
	}
	public void setSRST_POL_CENTER(String srst_pol_center) {
		SRST_POL_CENTER = srst_pol_center;
	}
	public String getSRST_POL_CUST_NAME() {
		return SRST_POL_CUST_NAME;
	}
	public void setSRST_POL_CUST_NAME(String srst_pol_cust_name) {
		SRST_POL_CUST_NAME = srst_pol_cust_name;
	}
	public String getSRST_POL_CUST_CODE() {
		return SRST_POL_CUST_CODE;
	}
	public void setSRST_POL_CUST_CODE(String srst_pol_cust_code) {
		SRST_POL_CUST_CODE = srst_pol_cust_code;
	}
	public String getSRST_POL_PROD_NAME() {
		return SRST_POL_PROD_NAME;
	}
	public void setSRST_POL_PROD_NAME(String srst_pol_prod_name) {
		SRST_POL_PROD_NAME = srst_pol_prod_name;
	}
	public String getSRST_POL_NO() {
		return SRST_POL_NO;
	}
	public void setSRST_POL_NO(String srst_pol_no) {
		SRST_POL_NO = srst_pol_no;
	}
	public Date getSRST_DT() {
		return SRST_DT;
	}
	public void setSRST_DT(Date srst_dt) {
		SRST_DT = srst_dt;
	}
	public String getSRST_REQ_TYPE() {
		return SRST_REQ_TYPE;
	}
	public void setSRST_REQ_TYPE(String srst_req_type) {
		SRST_REQ_TYPE = srst_req_type;
	}
	
}
