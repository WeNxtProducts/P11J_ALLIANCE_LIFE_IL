package com.iii.pel.forms.PILM021;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class BP extends BaseValueBean {
private String BP_CAS_ACTY_CODE_1;
	
	private String BP_CAS_ACTY_CODE_2;

	

	public String getBP_CAS_ACTY_CODE_2() {
		return BP_CAS_ACTY_CODE_2;
	}

	public void setBP_CAS_ACTY_CODE_2(String bp_cas_acty_code_2) {
		BP_CAS_ACTY_CODE_2 = bp_cas_acty_code_2;
	}

	public String getBP_CAS_ACTY_CODE_1() {
		return BP_CAS_ACTY_CODE_1;
	}

	public void setBP_CAS_ACTY_CODE_1(String bp_cas_acty_code_1) {
		BP_CAS_ACTY_CODE_1 = bp_cas_acty_code_1;
	}

}
