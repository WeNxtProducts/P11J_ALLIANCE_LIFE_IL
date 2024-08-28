package com.iii.pel.forms.PILP021;

public interface PILP021_SQLQUERY_CONSTANTS {
	final String FETCH_ROW_COUNT="25";
	
	final String LOV_FM_TO_PROD_CODE="SELECT PROD_CODE,PROD_DESC,PROD_BL_DESC FROM " +
			"PM_IL_PRODUCT WHERE PROD_CODE IS NOT NULL AND ROWNUM <= ?";
	
	final String LOV_FM_TO_PROP_NO="SELECT POL_NO,POL_ASSURED_NAME FROM PT_IL_POLICY " +
			"WHERE POL_DS_TYPE = '1' AND POL_ADDL_STATUS IN('B08','C01','C02') " +
			"AND NVL(POL_CONVERT_YN,'N') = 'N' AND POL_ISSUE_DT BETWEEN " +
			"TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') AND ROWNUM <= ?";
	
	
}
