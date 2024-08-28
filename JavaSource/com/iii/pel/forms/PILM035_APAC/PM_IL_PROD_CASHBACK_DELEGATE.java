package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_CASHBACK_DELEGATE {
	private static final PILM035_APAC_COMPOSITE_ACTION compositeAction = null;


	public void executeSelectStatement(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		/*Added by saranya on 02/01/2017 for RM018T - FSD_IL_ZB Life_028-Cash Back*/
		String Query = "SELECT ROWID, PM_IL_PROD_CASHBACK.* FROM PM_IL_PROD_CASHBACK WHERE PCB_PROD_CODE=?";
		Connection connection = null;
		ResultSet QueryresultSet = null;
		compositeAction.getPM_IL_PROD_CASHBACK_ACTION_BEAN().getDataList_PM_IL_PROD_CASHBACK().clear();
		try {
			connection = CommonUtils.getConnection();
		System.out.println("PROD_CODE  :"+compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN()
				.getPM_IL_PRODUCT_BEAN().getPROD_CODE());
		QueryresultSet=new CRUDHandler().executeSelectStatement(
				Query, connection, new Object[] {compositeAction
						.getPM_IL_PRODUCT_ACTION_BEAN()
						.getPM_IL_PRODUCT_BEAN().getPROD_CODE()});
		
		while (QueryresultSet.next()) {
			PM_IL_PROD_CASHBACK PM_IL_PROD_CASHBACK_BEAN=new PM_IL_PROD_CASHBACK();
			PM_IL_PROD_CASHBACK_BEAN.setROWID(QueryresultSet
					.getString("ROWID"));
			PM_IL_PROD_CASHBACK_BEAN.setPCB_APPL_ON(QueryresultSet
					.getString("PCB_APPL_ON"));
			/* Modified PCB_PERC MAX LENGTH from Integer to Double by pidugu raj dt: 22-10-2020 as suggested by sivarajan for Alliance IL*/
			/*PM_IL_PROD_CASHBACK_BEAN.setPCB_PERC(QueryresultSet
					.getInt("PCB_PERC"));*/
			PM_IL_PROD_CASHBACK_BEAN.setPCB_PERC(QueryresultSet
					.getDouble("PCB_PERC"));
			/* End Modified PCB_PERC MAX LENGTH from Integer to Double by pidugu raj dt: 22-10-2020 as suggested by sivarajan for Alliance IL*/
			PM_IL_PROD_CASHBACK_BEAN.setPCB_COMP_YRS(QueryresultSet
					.getInt("PCB_COMP_YRS"));
			PM_IL_PROD_CASHBACK_BEAN.setPCB_CR_DT(QueryresultSet
					.getDate("PCB_CR_DT"));
			PM_IL_PROD_CASHBACK_BEAN.setPCB_CR_UID(QueryresultSet
					.getString("PCB_CR_UID"));
			PM_IL_PROD_CASHBACK_BEAN.setPCB_UPD_DT(QueryresultSet
					.getDate("PCB_UPD_DT"));
			PM_IL_PROD_CASHBACK_BEAN.setPCB_UPD_UID(QueryresultSet
					.getString("PCB_UPD_UID"));
			compositeAction.getPM_IL_PROD_CASHBACK_ACTION_BEAN().getDataList_PM_IL_PROD_CASHBACK().add(PM_IL_PROD_CASHBACK_BEAN);
		}
		/*End*/
		/*Added by saranya on 02/01/2017 for RM018T - FSD_IL_ZB Life_028-Cash Back*/
		/*compositeAction.getPM_IL_PROD_CASHBACK_ACTION_BEAN()
						.setPM_IL_PROD_CASHBACK_BEAN(PM_IL_PROD_CASHBACK_BEAN);*/
		
		/*End*/
	} catch (Exception e) {
		e.printStackTrace();
		throw e;
	} finally {
		CommonUtils.closeCursor(QueryresultSet);
	}
	}

}
