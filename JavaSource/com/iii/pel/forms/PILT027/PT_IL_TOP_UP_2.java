package com.iii.pel.forms.PILT027;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class PT_IL_TOP_UP_2 extends BaseValueBean {

	private String UI_M_REASON_CODE;

	private String UI_M_DESC;

	private String UI_M_REMARKS;



	public String getUI_M_REASON_CODE() {
		return UI_M_REASON_CODE;
	}

	public void setUI_M_REASON_CODE(String UI_M_REASON_CODE) {
		this.UI_M_REASON_CODE = UI_M_REASON_CODE;
	}

	public String getUI_M_DESC() {
		return UI_M_DESC;
	}

	public void setUI_M_DESC(String UI_M_DESC) {
		this.UI_M_DESC = UI_M_DESC;
	}

	public String getUI_M_REMARKS() {
		return UI_M_REMARKS;
	}

	public void setUI_M_REMARKS(String UI_M_REMARKS) {
		this.UI_M_REMARKS = UI_M_REMARKS;
	}
}
