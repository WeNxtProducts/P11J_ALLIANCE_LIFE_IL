package com.iii.pel.forms.PILT016A_APAC;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

import com.iii.premia.common.action.CommonAction;

public class PM_IL_CONTRACTOR_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_PROP_AVLB_LABEL;

	private HtmlInputText COMP_UI_M_PROP_AVLB;

	private HtmlOutputLabel COMP_UI_M_POL_AVLB_LABEL;

	private HtmlInputText COMP_UI_M_POL_AVLB;

	private PM_IL_CONTRACTOR PM_IL_CONTRACTOR_BEAN;

	public PM_IL_CONTRACTOR_ACTION() {
		PM_IL_CONTRACTOR_BEAN = new PM_IL_CONTRACTOR();
	}

	public HtmlOutputLabel getCOMP_UI_M_PROP_AVLB_LABEL() {
		return COMP_UI_M_PROP_AVLB_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PROP_AVLB() {
		return COMP_UI_M_PROP_AVLB;
	}

	public void setCOMP_UI_M_PROP_AVLB_LABEL(HtmlOutputLabel COMP_UI_M_PROP_AVLB_LABEL) {
		this.COMP_UI_M_PROP_AVLB_LABEL = COMP_UI_M_PROP_AVLB_LABEL;
	}

	public void setCOMP_UI_M_PROP_AVLB(HtmlInputText COMP_UI_M_PROP_AVLB) {
		this.COMP_UI_M_PROP_AVLB = COMP_UI_M_PROP_AVLB;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_AVLB_LABEL() {
		return COMP_UI_M_POL_AVLB_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_AVLB() {
		return COMP_UI_M_POL_AVLB;
	}

	public void setCOMP_UI_M_POL_AVLB_LABEL(HtmlOutputLabel COMP_UI_M_POL_AVLB_LABEL) {
		this.COMP_UI_M_POL_AVLB_LABEL = COMP_UI_M_POL_AVLB_LABEL;
	}

	public void setCOMP_UI_M_POL_AVLB(HtmlInputText COMP_UI_M_POL_AVLB) {
		this.COMP_UI_M_POL_AVLB = COMP_UI_M_POL_AVLB;
	}

	public PM_IL_CONTRACTOR getPM_IL_CONTRACTOR_BEAN() {
		return PM_IL_CONTRACTOR_BEAN;
	}

	public void setPM_IL_CONTRACTOR_BEAN(PM_IL_CONTRACTOR PM_IL_CONTRACTOR_BEAN) {
		this.PM_IL_CONTRACTOR_BEAN = PM_IL_CONTRACTOR_BEAN;
	}
}
