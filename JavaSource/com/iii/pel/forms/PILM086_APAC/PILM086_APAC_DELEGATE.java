package com.iii.pel.forms.PILM086_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PILM086_APAC_DELEGATE {
	public void executeSelectStatement(PILM086_APAC_COMPOSITE_ACTION PILM086_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PM_BUS_RULE_HDR.* FROM PM_BUS_RULE_HDR WHERE ROWID = ?";
		System.out.println("HELLO");
		Connection connection = null;
		ResultSet resultSet = null;
		System.out.println(PILM086_APAC_COMPOSITE_ACTION_BEAN.getPILM086_ACTION_BEAN().getPILM086_BEAN().getROWID());
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[]{
							PILM086_APAC_COMPOSITE_ACTION_BEAN.getPILM086_ACTION_BEAN()
							.getPILM086_BEAN().getROWID()});
			PILM086_APAC_BEAN PILM086_BEAN = new PILM086_APAC_BEAN();
			while (resultSet.next()) {
				PILM086_BEAN.setROWID(resultSet.getString("ROWID"));
				PILM086_BEAN.setBRH_APPL_LEVEL(resultSet.getString("BRH_APPL_LEVEL"));
				PILM086_BEAN.setBRH_ASSR_TYPE(resultSet.getString("BRH_ASSR_TYPE"));
				PILM086_BEAN.setBRH_COVER_CODE_FM(resultSet.getString("BRH_COVER_CODE_FM"));
				PILM086_BEAN.setBRH_COVER_CODE_TO(resultSet.getString("BRH_COVER_CODE_TO"));
				PILM086_BEAN.setBRH_DATE_FM(resultSet.getDate("BRH_DATE_FM"));
				PILM086_BEAN.setBRH_DATE_TO(resultSet.getDate("BRH_DATE_TO"));
				PILM086_BEAN.setBRH_ERR_FLAG(resultSet.getString("BRH_ERR_FLAG"));
				PILM086_BEAN.setBRH_GRP_ID(resultSet.getString("BRH_GRP_ID"));
				PILM086_BEAN.setBRH_HINT(resultSet.getString("BRH_HINT"));
				PILM086_BEAN.setBRH_MOD_VALUE_YN(resultSet.getString("BRH_MOD_VALUE_YN"));
				PILM086_BEAN.setBRH_PDS_CODE_FM(resultSet.getString("BRH_PDS_CODE_FM"));
				PILM086_BEAN.setBRH_PDS_CODE_TO(resultSet.getString("BRH_PDS_CODE_TO"));
				
				/*Modified by saritha on 08-07-2017 for Business Rule Master*/
				/*PILM086_BEAN.setBRH_PROD_CODE(resultSet.getString("BRH_PROD_CODE"));*/
				PILM086_BEAN.setBRH_PROD_CODE_FM(resultSet.getString("BRH_PROD_CODE_FM"));
				PILM086_BEAN.setBRH_PROD_CODE_TO(resultSet.getString("BRH_PROD_CODE_TO"));
				/*End*/
				PILM086_BEAN.setBRH_SRC_BUS_CODE_FM(resultSet.getString("BRH_SRC_BUS_CODE_FM"));
				PILM086_BEAN.setBRH_SRC_BUS_CODE_TO(resultSet.getString("BRH_SRC_BUS_CODE_TO"));
				PILM086_BEAN.setBRH_TXN_DISP_TEXT(resultSet.getString("BRH_TXN_DISP_TEXT"));
				PILM086_BEAN.setBRH_TXN_DISP_TYPE(resultSet.getString("BRH_TXN_DISP_TYPE"));
				/*Added by saritha on 25-07-2017 for ssp call id ZBILQC-1732436*/
				PILM086_BEAN.setBRH_APL_SCREEN(resultSet.getString("BRH_APL_SCREEN"));
				/*End*/
				
				PILM086_BEAN.setBRH_SYS_ID(resultSet.getLong("BRH_SYS_ID"));
				/*End*/
				
			}
			PILM086_APAC_COMPOSITE_ACTION_BEAN.getPILM086_ACTION_BEAN()
					.setPILM086_BEAN(PILM086_BEAN);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
