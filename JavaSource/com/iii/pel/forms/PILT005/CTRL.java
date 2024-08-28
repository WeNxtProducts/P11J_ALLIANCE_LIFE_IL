package com.iii.pel.forms.PILT005;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name="")
public class CTRL {

	private String UI_M_CURSOR_HINT_REC;

	@Column(name="UI_M_USER_DISP")
	private String UI_M_USER_DISP;



	public String getUI_M_CURSOR_HINT_REC() {
		return UI_M_CURSOR_HINT_REC;
	}

	public void setUI_M_CURSOR_HINT_REC(String UI_M_CURSOR_HINT_REC) {
		this.UI_M_CURSOR_HINT_REC = UI_M_CURSOR_HINT_REC;
	}

	public String getUI_M_USER_DISP() {
		return UI_M_USER_DISP;
	}

	public void setUI_M_USER_DISP(String UI_M_USER_DISP) {
		this.UI_M_USER_DISP = UI_M_USER_DISP;
	}
}
