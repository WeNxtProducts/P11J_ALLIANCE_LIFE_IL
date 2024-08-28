package com.iii.pel.forms.PILT002_APAC;

import java.util.List;

import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_RED_SA_HELPER {

    public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)
	    throws Exception {
	new PT_IL_POL_RED_SA_DELEGATE().executeSelectStatement(compositeAction);

	List<PT_IL_POL_RED_SA> dataList = compositeAction
		.getPT_IL_POL_RED_SA_ACTION_BEAN()
		.getDataList_PT_IL_POL_RED_SA();
	if (dataList != null && dataList.size() > 0) {
	    PT_IL_POL_RED_SA PT_IL_POL_RED_SA_BEAN = dataList.get(0);
	    PT_IL_POL_RED_SA_BEAN.setRowSelected(true);
	    compositeAction.getPT_IL_POL_RED_SA_ACTION_BEAN()
		    .setPT_IL_POL_RED_SA_BEAN(PT_IL_POL_RED_SA_BEAN);
	}
    }

    public String UI_M_BUT_RD_SA_WHEN_BUTTON_PRESSED(
	    PT_IL_POLICY pt_il_policy_bean) {
	String outCome = null;
	try {

	    CommonUtils.setGlobalVariable("GLOBAL.M_RSA_POL_SYS_ID",
		    pt_il_policy_bean.getPOL_SYS_ID()+"" );
	    CommonUtils.setGlobalVariable("GLOBAL.M_RSA_END_NO_IDX",
		    pt_il_policy_bean.getPOL_END_NO_IDX()+"" );
	    // CALL_FORM("PILT036_APAC",NO_HIDE,NO_REPLACE);
	    outCome = "PILT036_APAC";
	} catch (Exception e) {

	    e.printStackTrace();

	}
	return outCome;
    }
    public String UI_M_BUT_RD_SA1_WHEN_BUTTON_PRESSED(
	    PT_IL_POLICY pt_il_policy_bean) {
	String outCome = null;
	try {
	     
	    CommonUtils.setGlobalVariable("GLOBAL.M_RSA_POL_SYS_ID",
		    pt_il_policy_bean.getPOL_SYS_ID()+"");
	    if("S".equalsIgnoreCase(CommonUtils.nvl( pt_il_policy_bean.getPOL_STATUS(), "N"))){
		 CommonUtils.setGlobalVariable("GLOBAL.M_RSA_END_NO_IDX",
			(CommonUtils.nvl(  pt_il_policy_bean.getPOL_END_NO_IDX(),0)-1 )+"");
	    }
	    else{
		 CommonUtils.setGlobalVariable("GLOBAL.M_RSA_END_NO_IDX",
			    pt_il_policy_bean.getPOL_END_NO_IDX()+"" );
	    }
	   
	    // CALL_FORM("PILT036_APAC",NO_HIDE,NO_REPLACE);
	    outCome = "PILT036_APAC";
	} catch (Exception e) {
	    
	    e.printStackTrace();
	    
	}
	return outCome;
    }

}
