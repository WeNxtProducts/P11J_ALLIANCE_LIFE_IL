package com.iii.pel.forms.PILP201;

import java.util.Date;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class DUMMY extends BaseValueBean {

	private String UI_M_POL_NO_FM;

	private String UI_M_POL_NO_TO;

	private Date UI_M_PROCESS_DT;

	public String getUI_M_POL_NO_FM() {
		return UI_M_POL_NO_FM;
	}

	public void setUI_M_POL_NO_FM(String UI_M_POL_NO_FM) {
		this.UI_M_POL_NO_FM = UI_M_POL_NO_FM;
	}

	public String getUI_M_POL_NO_TO() {
		return UI_M_POL_NO_TO;
	}

	public void setUI_M_POL_NO_TO(String UI_M_POL_NO_TO) {
		this.UI_M_POL_NO_TO = UI_M_POL_NO_TO;
	}

	public Date getUI_M_PROCESS_DT() {
		 return UI_M_PROCESS_DT;
	}

	public void setUI_M_PROCESS_DT(Date UI_M_PROCESS_DT) {
		this.UI_M_PROCESS_DT = UI_M_PROCESS_DT;
	}
}
