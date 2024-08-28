package com.iii.pel.forms.PILP080;



public class IP_REP_INFO_HELPER {


	public void executeQuery(PILP080_COMPOSITE_ACTION compositeAction) throws Exception {
		new IP_REP_INFO_DELEGATE().executeSelectStatement(compositeAction);
	}

}