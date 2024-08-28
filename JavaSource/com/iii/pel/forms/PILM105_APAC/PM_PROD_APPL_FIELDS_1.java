package com.iii.pel.forms.PILM105_APAC;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_PROD_APPL_FIELDS_1")
public class PM_PROD_APPL_FIELDS_1 extends BaseValueBean {

	@Column(name="PPAF_PROD_CODE")
	private String PPAF_PROD_CODE;

	public void setPPAF_PROD_CODE(String PPAF_PROD_CODE) {
		this.PPAF_PROD_CODE = PPAF_PROD_CODE;
	}
	public String getPPAF_PROD_CODE() {
		 return PPAF_PROD_CODE;
	}

}