package com.iii.pel.forms.PILM107;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_BANK_BRANCH")
public class PM_BANK_BRANCH extends BaseValueBean {

	
	@Column(name="BR_BANK_CODE")
	private String BR_BANK_CODE;
	
	@Column(name="BR_BANK_BRANCH_CODE")
	private String BR_BANK_BRANCH_NAME;
	
	@Column(name="BR_BANK_SORT_CODE")
	private String BR_BANK_SORT_CODE;

	public String getBR_BANK_CODE() {
		return BR_BANK_CODE;
	}

	public void setBR_BANK_CODE(String bR_BANK_CODE) {
		BR_BANK_CODE = bR_BANK_CODE;
	}

	public String getBR_BANK_BRANCH_NAME() {
		return BR_BANK_BRANCH_NAME;
	}

	public void setBR_BANK_BRANCH_NAME(String bR_BANK_BRANCH_NAME) {
		BR_BANK_BRANCH_NAME = bR_BANK_BRANCH_NAME;
	}

	public String getBR_BANK_SORT_CODE() {
		return BR_BANK_SORT_CODE;
	}

	public void setBR_BANK_SORT_CODE(String bR_BANK_SORT_CODE) {
		BR_BANK_SORT_CODE = bR_BANK_SORT_CODE;
	}

	

	
	
	
	
}
