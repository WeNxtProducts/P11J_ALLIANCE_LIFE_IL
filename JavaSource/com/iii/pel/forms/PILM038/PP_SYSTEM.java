package com.iii.pel.forms.PILM038;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PP_SYSTEM")
public class PP_SYSTEM extends BaseValueBean {

	@Column(name="PS_CODE")
	private String PS_CODE;

	private String UI_M_CODE_DESC;



	public String getPS_CODE() {
		return PS_CODE;
	}

	public void setPS_CODE(String PS_CODE) {
		this.PS_CODE = PS_CODE;
	}

	public String getUI_M_CODE_DESC() {
		return UI_M_CODE_DESC;
	}

	public void setUI_M_CODE_DESC(String UI_M_CODE_DESC) {
		this.UI_M_CODE_DESC = UI_M_CODE_DESC;
	}
}
