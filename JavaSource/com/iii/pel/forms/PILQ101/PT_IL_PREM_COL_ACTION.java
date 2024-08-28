package com.iii.pel.forms.PILQ101;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.premia.common.action.CommonAction;

public class PT_IL_PREM_COL_ACTION extends CommonAction {
	
private HtmlOutputLabel COMP_M_REINST_CODE_LABEL;
	
	private HtmlInputText COMP_M_REINST_CODE;
	
	private HtmlOutputLabel COMP_M_REINSTMT_DT_LABEL;
	
	private HtmlCalendar COMP_M_REINSTMT_DT;
	
	
	public HtmlOutputLabel getCOMP_M_REINST_CODE_LABEL() {
		return COMP_M_REINST_CODE_LABEL;
	}

	public void setCOMP_M_REINST_CODE_LABEL(HtmlOutputLabel COMP_M_REINST_CODE_LABEL) {
		this.COMP_M_REINST_CODE_LABEL = COMP_M_REINST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_M_REINST_CODE() {
		return COMP_M_REINST_CODE;
	}

	public void setCOMP_M_REINST_CODE(HtmlInputText COMP_M_REINST_CODE) {
		this.COMP_M_REINST_CODE = COMP_M_REINST_CODE;
	}

	public HtmlOutputLabel getCOMP_M_REINSTMT_DT_LABEL() {
		return COMP_M_REINSTMT_DT_LABEL;
	}

	public void setCOMP_M_REINSTMT_DT_LABEL(HtmlOutputLabel COMP_M_REINSTMT_DT_LABEL) {
		this.COMP_M_REINSTMT_DT_LABEL = COMP_M_REINSTMT_DT_LABEL;
	}

	public HtmlCalendar getCOMP_M_REINSTMT_DT() {
		return COMP_M_REINSTMT_DT;
	}

	public void setCOMP_M_REINSTMT_DT(HtmlCalendar COMP_M_REINSTMT_DT) {
		this.COMP_M_REINSTMT_DT = COMP_M_REINSTMT_DT;
	}

}
