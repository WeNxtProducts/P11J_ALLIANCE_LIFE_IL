package com.iii.pel.forms.PILM037;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_PLAN")
public class PM_IL_PLAN extends BaseValueBean {

	@Column(name="PLAN_CODE")
	private String PLAN_CODE;
	
	private String UI_M_PLAN_CODE_DESC;

	public String getPLAN_CODE() {
		return PLAN_CODE;
	}

	public void setPLAN_CODE(String plan_code) {
		PLAN_CODE = plan_code;
	}

	public String getUI_M_PLAN_CODE_DESC() {
		return UI_M_PLAN_CODE_DESC;
	}

	public void setUI_M_PLAN_CODE_DESC(String ui_m_plan_code_desc) {
		UI_M_PLAN_CODE_DESC = ui_m_plan_code_desc;
	}
}
