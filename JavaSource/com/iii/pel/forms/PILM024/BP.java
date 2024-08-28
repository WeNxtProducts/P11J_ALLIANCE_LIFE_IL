package com.iii.pel.forms.PILM024;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

/**
 * @author 50795
 *
 */
@Table(name="")
public class BP extends BaseValueBean {

	private String B_CLMAS_ACTY_CODE_1;
	
	private String B_CLMAS_ACTY_CODE_2;

	public String getB_CLMAS_ACTY_CODE_2() {
		return B_CLMAS_ACTY_CODE_2;
	}

	public void setB_CLMAS_ACTY_CODE_2(String b_clmas_acty_code_2) {
		B_CLMAS_ACTY_CODE_2 = b_clmas_acty_code_2;
	}

	public String getB_CLMAS_ACTY_CODE_1() {
		return B_CLMAS_ACTY_CODE_1;
	}

	public void setB_CLMAS_ACTY_CODE_1(String b_clmas_acty_code_1) {
		B_CLMAS_ACTY_CODE_1 = b_clmas_acty_code_1;
	}
	
}
