package com.iii.pel.forms.PILP010;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PW_ERROR_MESSAGE")
public class PW_ERROR_MESSAGE extends BaseValueBean {

	@Column(name="EM_ENG_MSG")
	private String EM_ENG_MSG;

	@Column(name="EM_ENG_ACTION")
	private String EM_ENG_ACTION;

	public String getEM_ENG_MSG() {
		return EM_ENG_MSG;
	}

	public void setEM_ENG_MSG(String EM_ENG_MSG) {
		this.EM_ENG_MSG = EM_ENG_MSG;
	}

	public String getEM_ENG_ACTION() {
		return EM_ENG_ACTION;
	}

	public void setEM_ENG_ACTION(String EM_ENG_ACTION) {
		this.EM_ENG_ACTION = EM_ENG_ACTION;
	}
	
}
