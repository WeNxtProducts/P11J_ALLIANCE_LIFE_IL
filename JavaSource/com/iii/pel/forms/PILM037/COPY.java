package com.iii.pel.forms.PILM037;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class COPY extends BaseValueBean {

	private String UI_M_BSET_PLAN_CODE_SOURCE;

	private String UI_M_BSET_PLAN_CODE_DESC_SOURCE;

	private Integer UI_M_BSET_YEAR_FROM;

	private Integer UI_M_BSET_YEAR_TO;

	private String UI_M_BSET_PLAN_CODE_DEST;

	private String UI_M_BSET_PLAN_CODE_DESC_DEST;
	
	public String getUI_M_BSET_PLAN_CODE_SOURCE() {
		return UI_M_BSET_PLAN_CODE_SOURCE;
	}

	public void setUI_M_BSET_PLAN_CODE_SOURCE(String UI_M_BSET_PLAN_CODE_SOURCE) {
		this.UI_M_BSET_PLAN_CODE_SOURCE = UI_M_BSET_PLAN_CODE_SOURCE;
	}

	public String getUI_M_BSET_PLAN_CODE_DESC_SOURCE() {
		return UI_M_BSET_PLAN_CODE_DESC_SOURCE;
	}

	public void setUI_M_BSET_PLAN_CODE_DESC_SOURCE(String UI_M_BSET_PLAN_CODE_DESC_SOURCE) {
		this.UI_M_BSET_PLAN_CODE_DESC_SOURCE = UI_M_BSET_PLAN_CODE_DESC_SOURCE;
	}

	

	public Integer getUI_M_BSET_YEAR_FROM() {
		return UI_M_BSET_YEAR_FROM;
	}

	public void setUI_M_BSET_YEAR_FROM(Integer ui_m_bset_year_from) {
		UI_M_BSET_YEAR_FROM = ui_m_bset_year_from;
	}

	public Integer getUI_M_BSET_YEAR_TO() {
		return UI_M_BSET_YEAR_TO;
	}

	public void setUI_M_BSET_YEAR_TO(Integer ui_m_bset_year_to) {
		UI_M_BSET_YEAR_TO = ui_m_bset_year_to;
	}

	public String getUI_M_BSET_PLAN_CODE_DEST() {
		return UI_M_BSET_PLAN_CODE_DEST;
	}

	public void setUI_M_BSET_PLAN_CODE_DEST(String UI_M_BSET_PLAN_CODE_DEST) {
		this.UI_M_BSET_PLAN_CODE_DEST = UI_M_BSET_PLAN_CODE_DEST;
	}

	public String getUI_M_BSET_PLAN_CODE_DESC_DEST() {
		return UI_M_BSET_PLAN_CODE_DESC_DEST;
	}

	public void setUI_M_BSET_PLAN_CODE_DESC_DEST(String UI_M_BSET_PLAN_CODE_DESC_DEST) {
		this.UI_M_BSET_PLAN_CODE_DESC_DEST = UI_M_BSET_PLAN_CODE_DESC_DEST;
	}
	
	
	

	
	
}
