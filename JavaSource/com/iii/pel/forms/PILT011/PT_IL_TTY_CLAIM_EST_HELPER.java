package com.iii.pel.forms.PILT011;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_TTY_CLAIM_EST_HELPER {
	PILT011_COMPOSITE_ACTION compositeAction;
	/*PT_IL_TTY_CLAIM_EST PT_IL_TTY_CLAIM_EST_BEAN= compositeAction.getPT_IL_TTY_CLAIM_EST_ACTION_BEAN().getPT_IL_TTY_CLAIM_EST_BEAN();*/
	public void executeQuery(PILT011_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_IL_TTY_CLAIM_EST_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PT_IL_TTY_CLAIM_EST> dataList = compositeAction
				.getPT_IL_TTY_CLAIM_EST_ACTION_BEAN()
				.getClaimEstList();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_TTY_CLAIM_EST PT_IL_TTY_CLAIM_EST_BEAN = dataList.get(0);
			PT_IL_TTY_CLAIM_EST_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_TTY_CLAIM_EST_ACTION_BEAN()
					.setPT_IL_TTY_CLAIM_EST_BEAN(PT_IL_TTY_CLAIM_EST_BEAN);
		}
	}
	public void pre_form(PT_IL_TTY_CLAIM_EST PT_IL_TTY_CLAIM_EST_BEAN,PILT011_COMPOSITE_ACTION compositeAction)throws Exception{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Object[] values = null;
		/* added by raja on 18-08-2017 for ZBILQC-1722999 */
		/*String C1 = " SELECT CLAIM_POL_NO,CLAIM_NO" +
				"	      FROM   PT_IL_CLAIM" +
				"	      WHERE  CLAIM_POL_SYS_ID = ?" +
				"	      AND    CLAIM_SYS_ID     = ?";*/
		String C1 = " SELECT CLAIM_POL_NO,CLAIM_NO,POL_CUST_CURR_CODE" +
				"	      FROM   PT_IL_CLAIM,PT_IL_POLICY" +
				"	      WHERE  CLAIM_POL_SYS_ID = POL_SYS_ID" +
				"	      AND    CLAIM_SYS_ID     = ?";
		
		/*END*/
		Long POL_SYS_ID = null;
		Long CLM_SYS_ID = null;
		try{
			if(!"".equals(CommonUtils.getGlobalObject("GLOBAL.POL_SYS_ID").toString())){
			POL_SYS_ID = Long.valueOf(CommonUtils.getGlobalObject("GLOBAL.POL_SYS_ID").toString());
			}
			if(!"".equals(CommonUtils.getGlobalObject("GLOBAL.CLM_SYS_ID").toString())){
			CLM_SYS_ID = Long.valueOf(CommonUtils.getGlobalObject("GLOBAL.CLM_SYS_ID").toString());
			}
			connection = CommonUtils.getConnection();
			/*if(POL_SYS_ID != null && CLM_SYS_ID != null){
//			DUMMY_BEAN.setUI_M_POL_SYS_ID(POL_SYS_ID);
//			DUMMY_BEAN.setUI_M_CLM_SYS_ID(CLM_SYS_ID);
			}
			if(CommonUtils.getGlobalObject("GLOBAL.COVER_CODE") != null){
			DUMMY_BEAN.setUI_M_COVER_CODE(CommonUtils.getGlobalObject("GLOBAL.COVER_CODE").toString());
			}*/
			/* added by raja on 18-08-2017 for ZBILQC-1722999 */
			/*values = new Object[]{POL_SYS_ID,CLM_SYS_ID};*/
			values = new Object[]{CLM_SYS_ID};
			resultSet = handler.executeSelectStatement(C1, connection,values);
			if(resultSet.next()){
				/*DUMMY_BEAN.setUI_M_POL_NO_1(resultSet.getString(1));
				DUMMY_BEAN.setUI_M_CLM_NO_1(resultSet.getString(2));*/
			//DUMMY_BEAN.setUI_M_POL_NO_2(DUMMY_BEAN.getUI_M_POL_NO_1());
				//DUMMY_BEAN.setUI_M_CLM_NO_2(DUMMY_BEAN.getUI_M_CLM_NO_1());
				/*PT_IL_TTY_CLAIM_EST PT_IL_TTY_CLAIM_EST_BEAN= compositeAction.getPT_IL_TTY_CLAIM_EST_ACTION_BEAN().getPT_IL_TTY_CLAIM_EST_BEAN();*/
				PT_IL_TTY_CLAIM_EST_BEAN.setUI_M_POL_NO_1(resultSet.getString(1));
				PT_IL_TTY_CLAIM_EST_BEAN.setUI_M_CLM_NO_1(resultSet.getString(2));
				PT_IL_TTY_CLAIM_EST_BEAN.setFCE_CLAIM_CURR_CODE(resultSet.getString("POL_CUST_CURR_CODE"));
				
				ArrayList<String> pvalList = new ArrayList<String>();
				PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
				pvalList = new ArrayList<String>();
				pvalList = pkg_pilt002_apac.P_VAL_CURR(PT_IL_TTY_CLAIM_EST_BEAN.getFCE_CLAIM_CURR_CODE(), 
						PT_IL_TTY_CLAIM_EST_BEAN.getUI_M_CURR_DESC_1(), "N", "N",null);
				if (!pvalList.isEmpty()) {
					PT_IL_TTY_CLAIM_EST_BEAN.setUI_M_CURR_DESC_1(pvalList.get(0));
				}
				
				/*END*/
				//COMP_UI_M_POL_NO_1.
				//COMP_UI_M_CLM_NO_1
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}
}
