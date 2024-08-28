package com.iii.pel.forms.PILP016;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class CTRL extends BaseValueBean {

	@Column(name="UI_M_USER_DISP")
	private String UI_M_USER_DISP;
	
	private String UI_M_POL_APPRV_STATUS;
	
	private Integer UI_M_POL_END_NO_IDX ;

	public String getUI_M_POL_APPRV_STATUS() {
		return UI_M_POL_APPRV_STATUS;
	}

	public void setUI_M_POL_APPRV_STATUS(String ui_m_pol_apprv_status) {
		UI_M_POL_APPRV_STATUS = ui_m_pol_apprv_status;
	}

	public String getUI_M_USER_DISP() {
		return UI_M_USER_DISP;
	}

	public void setUI_M_USER_DISP(String UI_M_USER_DISP) {
		this.UI_M_USER_DISP = UI_M_USER_DISP;
	}

	public Integer getUI_M_POL_END_NO_IDX() {
		return UI_M_POL_END_NO_IDX;
	}

	public void setUI_M_POL_END_NO_IDX(Integer ui_m_pol_end_no_idx) {
		UI_M_POL_END_NO_IDX = ui_m_pol_end_no_idx;
	}

}