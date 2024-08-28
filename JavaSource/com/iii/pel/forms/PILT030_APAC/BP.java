package com.iii.pel.forms.PILT030_APAC;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class BP extends BaseValueBean {

	private String B_PROCESSING_MSG;
	
	private String B_PAPD_PAY_APPRV_CODE;

	public String getB_PAPD_PAY_APPRV_CODE() {
		return B_PAPD_PAY_APPRV_CODE;
	}

	public void setB_PAPD_PAY_APPRV_CODE(String b_papd_pay_apprv_code) {
		B_PAPD_PAY_APPRV_CODE = b_papd_pay_apprv_code;
	}

	public String getB_PROCESSING_MSG() {
		return B_PROCESSING_MSG;
	}

	public void setB_PROCESSING_MSG(String b_processing_msg) {
		B_PROCESSING_MSG = b_processing_msg;
	}
	
}
