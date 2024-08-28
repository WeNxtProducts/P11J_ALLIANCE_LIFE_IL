package com.iii.pel.forms.PILP022;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name="")
public class CTRL {

	private String UI_M_CURSOR_HINT_REC;

	@Column(name="UI_M_USER_DISP")
	private String UI_M_USER_DISP;
	private String M_PARA_1;
	private String M_USER_ID;
	private String M_PROG_NAME;
	private String M_SCR_NAME;
	private String M_GOFLD_NAME;
	private String M_LANG_CODE;
	private String M_COMP_CODE;
	private String M_DIVN_CODE;
	private String M_DEPT_CODE;

	public String getM_PARA_1() {
		return M_PARA_1;
	}

	public void setM_PARA_1(String m_para_1) {
		M_PARA_1 = m_para_1;
	}

	public String getM_USER_ID() {
		return M_USER_ID;
	}

	public void setM_USER_ID(String m_user_id) {
		M_USER_ID = m_user_id;
	}

	public String getM_PROG_NAME() {
		return M_PROG_NAME;
	}

	public void setM_PROG_NAME(String m_prog_name) {
		M_PROG_NAME = m_prog_name;
	}

	public String getM_SCR_NAME() {
		return M_SCR_NAME;
	}

	public void setM_SCR_NAME(String m_scr_name) {
		M_SCR_NAME = m_scr_name;
	}

	public String getM_GOFLD_NAME() {
		return M_GOFLD_NAME;
	}

	public void setM_GOFLD_NAME(String m_gofld_name) {
		M_GOFLD_NAME = m_gofld_name;
	}

	public String getM_LANG_CODE() {
		return M_LANG_CODE;
	}

	public void setM_LANG_CODE(String m_lang_code) {
		M_LANG_CODE = m_lang_code;
	}

	public String getM_COMP_CODE() {
		return M_COMP_CODE;
	}

	public void setM_COMP_CODE(String m_comp_code) {
		M_COMP_CODE = m_comp_code;
	}

	public String getM_DIVN_CODE() {
		return M_DIVN_CODE;
	}

	public void setM_DIVN_CODE(String m_divn_code) {
		M_DIVN_CODE = m_divn_code;
	}

	public String getM_DEPT_CODE() {
		return M_DEPT_CODE;
	}

	public void setM_DEPT_CODE(String m_dept_code) {
		M_DEPT_CODE = m_dept_code;
	}

	public String getUI_M_CURSOR_HINT_REC() {
		return UI_M_CURSOR_HINT_REC;
	}

	public void setUI_M_CURSOR_HINT_REC(String UI_M_CURSOR_HINT_REC) {
		this.UI_M_CURSOR_HINT_REC = UI_M_CURSOR_HINT_REC;
	}

	public String getUI_M_USER_DISP() {
		return UI_M_USER_DISP;
	}

	public void setUI_M_USER_DISP(String UI_M_USER_DISP) {
		this.UI_M_USER_DISP = UI_M_USER_DISP;
	}
}
