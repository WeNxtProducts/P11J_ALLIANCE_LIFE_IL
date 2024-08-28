package com.iii.pel.forms.PILP090_APAC;

import com.iii.pel.forms.PILP004.MATURITY;
import com.iii.premia.common.utils.CommonUtils;

public class PERSISTENCY_HELPER {
	CommonUtils commonUtils = new CommonUtils();
	
	public void WHEN_CREATE_RECORD(PERSISTENCY PERSISTENCY_BEAN) throws Exception {
		PERSISTENCY_BEAN.setPRODUCTION_FM_DT(commonUtils.getCurrentDate());
		PERSISTENCY_BEAN.setPRODUCTION_TO_DT(commonUtils.getCurrentDate());

	}

}
