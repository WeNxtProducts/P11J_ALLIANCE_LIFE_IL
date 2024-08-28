package com.iii.pel.forms.PILQ111_APAC;

import java.util.Date;

import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

public class PILQ111_APAC_SEARCH_BEAN extends BaseValueBean{
	
	private String DIVN_CODE_FILTER;
	private String DEPT_CODE_FILTER;
	private String PROD_CODE_FILTER;
	private String COVER_CODE_FILTER;
	private String TTY_TYPE_FILTER;
	private Date FM_DT_FILTER;
	private Date TO_DT_FILTER;
	
	private String PROD_CODE;
	private String COVER_CODE;
	private String TTY_TYPE;
	private String DIVN_CODE;
	private String DEPT_CODE;
	private Date FM_DT;
	private Date TO_DT;

	
	public String getDIVN_CODE_FILTER() {
		return DIVN_CODE_FILTER;
	}
	public void setDIVN_CODE_FILTER(String divn_code_filter) {
		DIVN_CODE_FILTER = divn_code_filter;
	}
	public String getDEPT_CODE_FILTER() {
		return DEPT_CODE_FILTER;
	}
	public void setDEPT_CODE_FILTER(String dept_code_filter) {
		DEPT_CODE_FILTER = dept_code_filter;
	}
	public String getPROD_CODE_FILTER() {
		return PROD_CODE_FILTER;
	}
	public void setPROD_CODE_FILTER(String prod_code_filter) {
		PROD_CODE_FILTER = prod_code_filter;
	}
	public String getCOVER_CODE_FILTER() {
		return COVER_CODE_FILTER;
	}
	public void setCOVER_CODE_FILTER(String cover_code_filter) {
		COVER_CODE_FILTER = cover_code_filter;
	}
	public String getTTY_TYPE_FILTER() {
		return TTY_TYPE_FILTER;
	}
	public void setTTY_TYPE_FILTER(String tty_type_filter) {
		TTY_TYPE_FILTER = tty_type_filter;
	}
	public String getPROD_CODE() {
		return PROD_CODE;
	}
	public void setPROD_CODE(String prod_code) {
		PROD_CODE = prod_code;
	}
	public String getCOVER_CODE() {
		return COVER_CODE;
	}
	public void setCOVER_CODE(String cover_code) {
		COVER_CODE = cover_code;
	}
	public String getTTY_TYPE() {
		return TTY_TYPE;
	}
	public void setTTY_TYPE(String tty_type) {
		TTY_TYPE = tty_type;
	}
	public String getDIVN_CODE() {
		return DIVN_CODE;
	}
	public void setDIVN_CODE(String divn_code) {
		DIVN_CODE = divn_code;
	}
	public String getDEPT_CODE() {
		return DEPT_CODE;
	}
	public void setDEPT_CODE(String dept_code) {
		DEPT_CODE = dept_code;
	}
	public Date getFM_DT() {
		return FM_DT;
	}
	public void setFM_DT(Date fm_dt) {
		FM_DT = fm_dt;
	}
	public Date getTO_DT() {
		return TO_DT;
	}
	public void setTO_DT(Date to_dt) {
		TO_DT = to_dt;
	}
	public Date getFM_DT_FILTER() {
		return FM_DT_FILTER;
	}
	public void setFM_DT_FILTER(Date fm_dt_filter) {
		FM_DT_FILTER = fm_dt_filter;
	}
	public Date getTO_DT_FILTER() {
		return TO_DT_FILTER;
	}
	public void setTO_DT_FILTER(Date to_dt_filter) {
		TO_DT_FILTER = to_dt_filter;
	}


}
