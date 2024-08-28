package com.iii.pel.forms.PILM011;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_CODES")
public class PM_CODES extends BaseValueBean {

	@Column(name="PC_CODE")
	private String PC_CODE;

	@Column(name="PC_DESC")
	private String PC_DESC;
	
	private String filterText;
	
	

	public String getPC_CODE() {
		return PC_CODE;
	}

	public void setPC_CODE(String PC_CODE) {
		this.PC_CODE = PC_CODE;
	}

	public String getPC_DESC() {
		return PC_DESC;
	}

	public void setPC_DESC(String PC_DESC) {
		this.PC_DESC = PC_DESC;
	}

	public String getFilterText() {
		return filterText;
	}

	public void setFilterText(String filterText) {
		this.filterText = filterText;
	}

}
