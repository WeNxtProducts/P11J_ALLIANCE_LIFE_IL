package com.iii.pel.forms.PILT002_APAC;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "")
public class CTRL extends BaseValueBean {

    @Column(name = "UI_M_USER_DISP")
    private String UI_M_USER_DISP;

    private String UI_M_USER_ID;

    private String UI_M_PARA_1;

    private String UI_M_PROG_NAME;

    private String UI_M_SCR_NAME;

    private String UI_M_GOFLD_NAME;

    private String UI_M_LANG_CODE;

    private String UI_M_COMP_CODE;

    private String UI_M_DIVN_CODE;

    private String UI_M_DEPT_CODE;

    private String UI_M_COMM_DEL;

    private String UI_M_DELETE_MSG_FLAG;

    public String getUI_M_DELETE_MSG_FLAG() {
	return UI_M_DELETE_MSG_FLAG;
    }

    public void setUI_M_DELETE_MSG_FLAG(String ui_m_delete_msg_flag) {
	UI_M_DELETE_MSG_FLAG = ui_m_delete_msg_flag;
    }

    public String getUI_M_USER_DISP() {
	return UI_M_USER_DISP;
    }

    public void setUI_M_USER_DISP(String UI_M_USER_DISP) {
	this.UI_M_USER_DISP = UI_M_USER_DISP;
    }

    public String getUI_M_USER_ID() {
	return UI_M_USER_ID;
    }

    public void setUI_M_USER_ID(String ui_m_user_id) {
	UI_M_USER_ID = ui_m_user_id;
    }

    public String getUI_M_PARA_1() {
	return UI_M_PARA_1;
    }

    public void setUI_M_PARA_1(String ui_m_para_1) {
	UI_M_PARA_1 = ui_m_para_1;
    }

    public String getUI_M_PROG_NAME() {
	return UI_M_PROG_NAME;
    }

    public void setUI_M_PROG_NAME(String ui_m_prog_name) {
	UI_M_PROG_NAME = ui_m_prog_name;
    }

    public String getUI_M_SCR_NAME() {
	return UI_M_SCR_NAME;
    }

    public void setUI_M_SCR_NAME(String ui_m_scr_name) {
	UI_M_SCR_NAME = ui_m_scr_name;
    }

    public String getUI_M_GOFLD_NAME() {
	return UI_M_GOFLD_NAME;
    }

    public void setUI_M_GOFLD_NAME(String ui_m_gofld_name) {
	UI_M_GOFLD_NAME = ui_m_gofld_name;
    }

    public String getUI_M_LANG_CODE() {
	return UI_M_LANG_CODE;
    }

    public void setUI_M_LANG_CODE(String ui_m_lang_code) {
	UI_M_LANG_CODE = ui_m_lang_code;
    }

    public String getUI_M_COMP_CODE() {
	return UI_M_COMP_CODE;
    }

    public void setUI_M_COMP_CODE(String ui_m_comp_code) {
	UI_M_COMP_CODE = ui_m_comp_code;
    }

    public String getUI_M_DIVN_CODE() {
	return UI_M_DIVN_CODE;
    }

    public void setUI_M_DIVN_CODE(String ui_m_divn_code) {
	UI_M_DIVN_CODE = ui_m_divn_code;
    }

    public String getUI_M_DEPT_CODE() {
	return UI_M_DEPT_CODE;
    }

    public void setUI_M_DEPT_CODE(String ui_m_dept_code) {
	UI_M_DEPT_CODE = ui_m_dept_code;
    }

    public String getUI_M_COMM_DEL() {
	return UI_M_COMM_DEL;
    }

    public void setUI_M_COMM_DEL(String ui_m_comm_del) {
	UI_M_COMM_DEL = ui_m_comm_del;
    }
}
