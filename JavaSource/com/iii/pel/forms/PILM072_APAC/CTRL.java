package com.iii.pel.forms.PILM072_APAC;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class CTRL extends BaseValueBean {

	@Column(name="UI_M_USER_DISP")
	private String UI_M_USER_DISP;
	
	private String UI_M_DELETE_MSG_FLAG;


	/**
	 * @return the uI_M_DELETE_MSG_FLAG
	 */
	public String getUI_M_DELETE_MSG_FLAG() {
		return UI_M_DELETE_MSG_FLAG;
	}

	/**
	 * @param ui_m_delete_msg_flag the uI_M_DELETE_MSG_FLAG to set
	 */
	public void setUI_M_DELETE_MSG_FLAG(String ui_m_delete_msg_flag) {
		UI_M_DELETE_MSG_FLAG = ui_m_delete_msg_flag;
	}

	public String getUI_M_USER_DISP() {
		return UI_M_USER_DISP;
	}

	public void setUI_M_USER_DISP(String UI_M_USER_DISP) {
		this.UI_M_USER_DISP = UI_M_USER_DISP;
	}
}
