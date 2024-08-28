package com.iii.pel.forms.PILM034;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name="PP_LIST_ITEM_VALUES")
public class PP_LIST_ITEM_VALUES {

	@Column(name="ROWID")
	private String ROWID;
	
	@Column(name="LIV_CODE")
	private String LIV_CODE;

	private String LIV_CODE_DESC;



	public String getLIV_CODE() {
		return LIV_CODE;
	}

	public void setLIV_CODE(String LIV_CODE) {
		this.LIV_CODE = LIV_CODE;
	}

	public String getLIV_CODE_DESC() {
		return LIV_CODE_DESC;
	}

	public void setLIV_CODE_DESC(String LIV_CODE_DESC) {
		this.LIV_CODE_DESC = LIV_CODE_DESC;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}
}
