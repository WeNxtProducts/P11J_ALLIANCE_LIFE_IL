package com.iii.pel.forms.PILP014;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class BP extends BaseValueBean {

	private String B_PROCESSING_MSG;

	public String getB_PROCESSING_MSG() {
		return B_PROCESSING_MSG;
	}

	public void setB_PROCESSING_MSG(String b_processing_msg) {
		B_PROCESSING_MSG = b_processing_msg;
	}

}
