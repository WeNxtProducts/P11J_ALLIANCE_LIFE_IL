package com.iii.pel.forms.PILP085_APAC;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "")
public class CTRL extends BaseValueBean {

	@Column(name = "UI_M_USER_DISP")
	private String UI_M_USER_DISP;
	private String UI_M_COMM_DEL;

	public String getUI_M_COMM_DEL() {
		return UI_M_COMM_DEL;
	}

	public void setUI_M_COMM_DEL(String ui_m_comm_del) {
		UI_M_COMM_DEL = ui_m_comm_del;
	}

	public String getUI_M_USER_DISP() {
		return UI_M_USER_DISP;
	}

	public void setUI_M_USER_DISP(String UI_M_USER_DISP) {
		this.UI_M_USER_DISP = UI_M_USER_DISP;
	}
}