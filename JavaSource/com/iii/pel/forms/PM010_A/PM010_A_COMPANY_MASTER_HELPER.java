package com.iii.pel.forms.PM010_A;

import com.iii.premia.common.utils.CommonUtils;


public class PM010_A_COMPANY_MASTER_HELPER {
	
	public void executeQuery(PM010_A_COMPOSITE_ACTION compositeAction)
			throws Exception {
		System.out.println("helper execute");
		new PM010_A_COMPANY_MASTER_DELEGATE().executeSelectStatement(compositeAction);
	}
	
}
