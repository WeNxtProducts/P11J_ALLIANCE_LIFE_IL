package com.iii.pel.forms.PILQ003;


import java.util.List;

import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_STATUS_1_HELPER {

    public void executeQuery(PILQ003_COMPOSITE_ACTION compositeAction)
	    throws Exception {
	new PT_IL_POL_STATUS_1_DELEGATE()
		.executeSelectStatement(compositeAction);

	List<PT_IL_POL_STATUS_1> dataList = compositeAction
		.getPT_IL_POL_STATUS_1_ACTION_BEAN()
		.getDataList_PT_IL_POL_STATUS_1();
	if (dataList != null && dataList.size() > 0) {
	    PT_IL_POL_STATUS_1 PT_IL_POL_STATUS_1_BEAN = dataList.get(0);
	    PT_IL_POL_STATUS_1_BEAN.setRowSelected(true);
	    compositeAction.getPT_IL_POL_STATUS_1_ACTION_BEAN()
		    .setPT_IL_POL_STATUS_1_BEAN(PT_IL_POL_STATUS_1_BEAN);
	}
    }

    /**
     * @param policyBean
     * @param ctrlBean
     * @param status2Bean
     * @throws Exception
     */
    public void preInsert(PT_IL_POLICY policyBean, CTRL ctrlBean,PT_IL_POL_STATUS_1 status1Bean) throws Exception{
    	try {
    		status1Bean.setPS_CR_DT(new CommonUtils().getCurrentDate());
    		status1Bean.setPS_CR_UID(ctrlBean.getUSER_ID());
    		// added by dileshwar  :- its necessary according to executeQuery
    		status1Bean.setPS_STATUS_TYPE("R");
    		status1Bean.setPS_POL_SYS_ID(policyBean.getPOL_SYS_ID());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
    }
    
}
