package com.iii.pel.forms.PILM036;

import java.util.List;

import com.iii.apps.persistence.Column;
import com.iii.premia.common.bean.BaseValueBean;

public class PM_IL_BONUS_QUERY extends BaseValueBean {
	@Column(name="BONUS_CODE")
	private String BONUS_CODE;
	@Column(name="BONUS_YRS")
	private String BONUS_YRS;
	@Column(name="BONUS_TYPE")
	private String BONUS_TYPE;
	@Column(name="BONUS_CR_DT")
	private List<String> BONUS_TYPE_LIST;
	private String BONUS_CODE_FILTER;
	private String BONUS_YRS_FILTER;
	private String BONUS_TYPE_FILTER;
	private String BONUS_CODE_DESC_FILTER;
	public String getBONUS_CODE_DESC_FILTER() {
		return BONUS_CODE_DESC_FILTER;
	}
	public void setBONUS_CODE_DESC_FILTER(String bonus_code_desc_filter) {
		BONUS_CODE_DESC_FILTER = bonus_code_desc_filter;
	}
	public String getBONUS_CODE() {
		return BONUS_CODE;
	}
	public void setBONUS_CODE(String bonus_code) {
		BONUS_CODE = bonus_code;
	}
	public String getBONUS_YRS() {
		return BONUS_YRS;
	}
	public void setBONUS_YRS(String bonus_yrs) {
		BONUS_YRS = bonus_yrs;
	}
	public String getBONUS_TYPE() {
		return BONUS_TYPE;
	}
	public void setBONUS_TYPE(String bonus_type) {
		BONUS_TYPE = bonus_type;
	}
	public String getBONUS_CODE_FILTER() {
		return BONUS_CODE_FILTER;
	}
	public void setBONUS_CODE_FILTER(String bonus_code_filter) {
		BONUS_CODE_FILTER = bonus_code_filter;
	}
	public String getBONUS_YRS_FILTER() {
		return BONUS_YRS_FILTER;
	}
	public void setBONUS_YRS_FILTER(String bonus_yrs_filter) {
		BONUS_YRS_FILTER = bonus_yrs_filter;
	}
	public String getBONUS_TYPE_FILTER() {
		return BONUS_TYPE_FILTER;
	}
	public void setBONUS_TYPE_FILTER(String bonus_type_filter) {
		BONUS_TYPE_FILTER = bonus_type_filter;
	}
	public List<String> getBONUS_TYPE_LIST() {
		return BONUS_TYPE_LIST;
	}
	public void setBONUS_TYPE_LIST(List<String> bonus_code_desc) {
		BONUS_TYPE_LIST = bonus_code_desc;
	}

}
