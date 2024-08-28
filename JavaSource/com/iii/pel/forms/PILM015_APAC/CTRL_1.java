package com.iii.pel.forms.PILM015_APAC;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class CTRL_1 extends BaseValueBean {

	private String UI_M_CP_TREATY_CODE;

	private String UI_M_CP_TREATY_DESC;

	private Integer UI_M_CP_UW_YEAR;

	private String UI_M_CP_DEST_TREATY_CODE;

	private Integer UI_M_CP_DEST_UW_YEAR;
	
	private Integer M_PT_SYS_ID;

	public String getUI_M_CP_TREATY_CODE() {
		return UI_M_CP_TREATY_CODE;
	}

	public void setUI_M_CP_TREATY_CODE(String ui_m_cp_treaty_code) {
		UI_M_CP_TREATY_CODE = ui_m_cp_treaty_code;
	}

	public String getUI_M_CP_TREATY_DESC() {
		return UI_M_CP_TREATY_DESC;
	}

	public void setUI_M_CP_TREATY_DESC(String ui_m_cp_treaty_desc) {
		UI_M_CP_TREATY_DESC = ui_m_cp_treaty_desc;
	}

	public Integer getUI_M_CP_UW_YEAR() {
		return UI_M_CP_UW_YEAR;
	}

	public void setUI_M_CP_UW_YEAR(Integer ui_m_cp_uw_year) {
		UI_M_CP_UW_YEAR = ui_m_cp_uw_year;
	}

	public String getUI_M_CP_DEST_TREATY_CODE() {
		return UI_M_CP_DEST_TREATY_CODE;
	}

	public void setUI_M_CP_DEST_TREATY_CODE(String ui_m_cp_dest_treaty_code) {
		UI_M_CP_DEST_TREATY_CODE = ui_m_cp_dest_treaty_code;
	}

	public Integer getUI_M_CP_DEST_UW_YEAR() {
		return UI_M_CP_DEST_UW_YEAR;
	}

	public void setUI_M_CP_DEST_UW_YEAR(Integer ui_m_cp_dest_uw_year) {
		UI_M_CP_DEST_UW_YEAR = ui_m_cp_dest_uw_year;
	}

	public Integer getM_PT_SYS_ID() {
		return M_PT_SYS_ID;
	}

	public void setM_PT_SYS_ID(Integer m_pt_sys_id) {
		M_PT_SYS_ID = m_pt_sys_id;
	}



	}
