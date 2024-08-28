package com.iii.pel.forms.PILM001;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name="")
public class PM_IL_CLASS_BL {

	@Column(name="CLASS_BL_NAME")
	private String CLASS_BL_NAME;

	@Column(name="CLASS_BL_SHORT_NAME")
	private String CLASS_BL_SHORT_NAME;



	public String getCLASS_BL_NAME() {
		return CLASS_BL_NAME;
	}

	public void setCLASS_BL_NAME(String CLASS_BL_NAME) {
		this.CLASS_BL_NAME = CLASS_BL_NAME;
	}

	public String getCLASS_BL_SHORT_NAME() {
		return CLASS_BL_SHORT_NAME;
	}

	public void setCLASS_BL_SHORT_NAME(String CLASS_BL_SHORT_NAME) {
		this.CLASS_BL_SHORT_NAME = CLASS_BL_SHORT_NAME;
	}
}
