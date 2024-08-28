package com.iii.pel.forms.PILP007;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "")
public class DUMMY extends BaseValueBean {

	private String UI_M_POL_NO_FROM;

	private String UI_M_POL_NO_TO;

	private Date UI_M_FROM_DATE;

	private Date UI_M_TO_DATE;

	private Double UI_M_BASE_CURR;

	@Column(name = "UI_M_SURR_TYPE")
	private String UI_M_SURR_TYPE;

	
	public String getUI_M_POL_NO_FROM() {
		return UI_M_POL_NO_FROM;
	}

	public void setUI_M_POL_NO_FROM(String UI_M_POL_NO_FROM) {
		this.UI_M_POL_NO_FROM = UI_M_POL_NO_FROM;
	}

	public String getUI_M_POL_NO_TO() {
		return UI_M_POL_NO_TO;
	}

	public void setUI_M_POL_NO_TO(String UI_M_POL_NO_TO) {
		this.UI_M_POL_NO_TO = UI_M_POL_NO_TO;
	}

	public Date getUI_M_FROM_DATE() {
		return UI_M_FROM_DATE;
	}

	public void setUI_M_FROM_DATE(Date UI_M_FROM_DATE) {
		this.UI_M_FROM_DATE = UI_M_FROM_DATE;
	}

	public Date getUI_M_TO_DATE() {
		return UI_M_TO_DATE;
	}

	public void setUI_M_TO_DATE(Date UI_M_TO_DATE) {
		this.UI_M_TO_DATE = UI_M_TO_DATE;
	}

	public String getUI_M_SURR_TYPE() {
		return UI_M_SURR_TYPE;
	}

	public void setUI_M_SURR_TYPE(String UI_M_SURR_TYPE) {
		this.UI_M_SURR_TYPE = UI_M_SURR_TYPE;
	}

	public Double getUI_M_BASE_CURR() {
		return UI_M_BASE_CURR;
	}

	public void setUI_M_BASE_CURR(Double ui_m_base_curr) {
		UI_M_BASE_CURR = ui_m_base_curr;
	}
}
