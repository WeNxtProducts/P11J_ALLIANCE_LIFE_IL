package com.iii.pel.forms.PILP008;

import javax.faces.component.html.HtmlInputText;

public class CANVAS3_ACTION {

	private HtmlInputText COMP_ROWID;

	private CANVAS3 CANVAS3_BEAN;

	public CANVAS3_ACTION() {
		CANVAS3_BEAN = new CANVAS3();
	}

	public HtmlInputText getCOMP_ROWID() {
		return COMP_ROWID;
	}

	public void setCOMP_ROWID(HtmlInputText COMP_ROWID) {
		this.COMP_ROWID = COMP_ROWID;
	}

	public CANVAS3 getCANVAS3_BEAN() {
		return CANVAS3_BEAN;
	}

	public void setCANVAS3_BEAN(CANVAS3 CANVAS3_BEAN) {
		this.CANVAS3_BEAN = CANVAS3_BEAN;
	}
}
