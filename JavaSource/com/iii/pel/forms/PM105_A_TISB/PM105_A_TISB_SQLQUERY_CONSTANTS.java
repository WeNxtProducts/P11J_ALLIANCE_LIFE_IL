package com.iii.pel.forms.PM105_A_TISB;

public interface PM105_A_TISB_SQLQUERY_CONSTANTS {
	
	// TODO rownum condition to be removed for SELECT_ALL_PM_IL_CODES_ACCOUNT_SETUP string while merging
	
	final String SELECT_ALL_PM_IL_CODES_ACCOUNT_SETUP="SELECT ROWNUM,PM_IL_CODES_ACCOUNT_SETUP.ROWID," +
			"CACS_SRC_BUS_FM,CACS_SRC_BUS_TO,CACS_DIVN_FM_CODE,CACS_DIVN_TO_CODE,CACS_DEPT_FM_CODE," +
			"CACS_DEPT_TO_CODE,CACS_BUS_FM_CODE,CACS_BUS_TO_CODE,CACS_SETUP_TYPE," +
			"CACS_FORCE_DIVN_YN,CACS_FORCE_DEPT_YN,CACS_MAIN_ACNT_CODE,CACS_SUB_ACNT_CODE," +
			"CACS_DIVN_CODE,CACS_DEPT_CODE,CACS_ANLY_CODE_1,CACS_ANLY_CODE_2,CACS_ACTY_CODE_1," +
			"CACS_ACTY_CODE_2,CACS_FRZ_FLAG FROM PM_IL_CODES_ACCOUNT_SETUP WHERE 1=1 AND ROWNUM<=50";
	
}
