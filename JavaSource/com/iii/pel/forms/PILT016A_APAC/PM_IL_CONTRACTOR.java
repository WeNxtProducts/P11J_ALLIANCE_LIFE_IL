package com.iii.pel.forms.PILT016A_APAC;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_CONTRACTOR")
public class PM_IL_CONTRACTOR extends BaseValueBean {

	private Double UI_M_PROP_AVLB;

	private String UI_M_POL_AVLB;



	public Double getUI_M_PROP_AVLB() {
		return UI_M_PROP_AVLB;
	}

	public void setUI_M_PROP_AVLB(Double UI_M_PROP_AVLB) {
		this.UI_M_PROP_AVLB = UI_M_PROP_AVLB;
	}

	public String getUI_M_POL_AVLB() {
		return UI_M_POL_AVLB;
	}

	public void setUI_M_POL_AVLB(String UI_M_POL_AVLB) {
		this.UI_M_POL_AVLB = UI_M_POL_AVLB;
	}
}
