package com.iii.pel.forms.PILP200;

import java.util.Date;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class REN_PREM_PROCESS extends BaseValueBean {

	private String UI_M_FM_POL_NO;

	private String UI_M_TO_POL_NO;

	private Date UI_M_FM_DT;

	private Date UI_M_TO_DT;



	public String getUI_M_FM_POL_NO() {
		return UI_M_FM_POL_NO;
	}

	public void setUI_M_FM_POL_NO(String UI_M_FM_POL_NO) {
		this.UI_M_FM_POL_NO = UI_M_FM_POL_NO;
	}

	public String getUI_M_TO_POL_NO() {
		return UI_M_TO_POL_NO;
	}

	public void setUI_M_TO_POL_NO(String UI_M_TO_POL_NO) {
		this.UI_M_TO_POL_NO = UI_M_TO_POL_NO;
	}

	public Date getUI_M_FM_DT() {
		 return UI_M_FM_DT;
	}

	public void setUI_M_FM_DT(Date UI_M_FM_DT) {
		this.UI_M_FM_DT = UI_M_FM_DT;
	}

	public Date getUI_M_TO_DT() {
		 return UI_M_TO_DT;
	}

	public void setUI_M_TO_DT(Date UI_M_TO_DT) {
		this.UI_M_TO_DT = UI_M_TO_DT;
	}
}
