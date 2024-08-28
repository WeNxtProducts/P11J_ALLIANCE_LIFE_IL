package com.iii.pel.forms.PILT020;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
@Table(name="PT_IL_POLICY")
public class PT_IL_POLICY extends BaseValueBean {

	@Column(name="POL_SYS_ID")
	private int POL_SYS_ID ;
	
	@Column(name="POL_START_DT")
	private Date POL_START_DT ;
	
	@Column(name="POL_EXPIRY_DATE")
	private Date  POL_EXPIRY_DATE ;
	
	@Column(name="POL_NO")
	private String POL_NO ;
	
	@Column(name="POL_CUST_CURR_CODE")
	private String POL_CUST_CURR_CODE ;
	
	@Column(name="POL_CUST_EXCH_RATE")
	private Double POL_CUST_EXCH_RATE ;
	
	@Column(name="POL_STATUS")
	private String POL_STATUS ;
	
	@Column(name="POL_PLAN_CODE")
	private String POL_PLAN_CODE ;
	
	

	
	
	public int getPOL_SYS_ID() {
		return POL_SYS_ID;
	}

	public void setPOL_SYS_ID(int pol_sys_id) {
		POL_SYS_ID = pol_sys_id;
	} void setPOL_PLAN_CODE(String pol_plan_code) {
		POL_PLAN_CODE = pol_plan_code;
	}

	public Date getPOL_START_DT() {
		return POL_START_DT;
	}

	public void setPOL_START_DT(Date pol_start_dt) {
		POL_START_DT = pol_start_dt;
	}

	public Date getPOL_EXPIRY_DATE() {
		return POL_EXPIRY_DATE;
	}

	public void setPOL_EXPIRY_DATE(Date pol_expiry_date) {
		POL_EXPIRY_DATE = pol_expiry_date;
	}

	public String getPOL_NO() {
		return POL_NO;
	}

	public void setPOL_NO(String pol_no) {
		POL_NO = pol_no;
	}

	public String getPOL_CUST_CURR_CODE() {
		return POL_CUST_CURR_CODE;
	}

	public void setPOL_CUST_CURR_CODE(String pol_cust_curr_code) {
		POL_CUST_CURR_CODE = pol_cust_curr_code;
	}

	public Double getPOL_CUST_EXCH_RATE() {
		return POL_CUST_EXCH_RATE;
	}

	public void setPOL_CUST_EXCH_RATE(Double pol_cust_exch_rate) {
		POL_CUST_EXCH_RATE = pol_cust_exch_rate;
	}

	public String getPOL_STATUS() {
		return POL_STATUS;
	}

	public void setPOL_STATUS(String pol_status) {
		POL_STATUS = pol_status;
	}

	public String getPOL_PLAN_CODE() {
		return POL_PLAN_CODE;
	}

}
