package com.iii.pel.forms.PILM086_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PILM086_APAC_SQL_DELIGATE {
	
	public void executeSelectStatement(
			PILM086_APAC_COMPOSITE_ACTION PILM086_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		System.out.println("inside delegate ");
		
		/*String selectStatement = "SELECT ROWID,BRH_SYS_ID,BRH_PROD_CODE,BRH_COVER_CODE_TO,BRH_WHERE_CLAUSE FROM PM_BUS_RULE_HDR where ROWID = ?";*/
		String selectStatement = "SELECT ROWID,BRH_SYS_ID,BRH_PROD_CODE_TO,BRH_COVER_CODE_TO,BRH_WHERE_CLAUSE FROM PM_BUS_RULE_HDR where ROWID = ?";
		System.out.println("rUN AFTER THE QUERY=========");
		Connection connection = null;
		ResultSet resultSet = null;
		//PILM086_APAC_COMPOSITE_ACTION_BEAN.getPILM086_APAC_SQLSCRIPT_ACTION_BEAN().getDataList_PILM086_APAC_SQL_BEAN().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{ PILM086_APAC_COMPOSITE_ACTION_BEAN.getPILM086_ACTION_BEAN()
							.getPILM086_BEAN().getROWID() });
			while (resultSet.next()) {
				PILM086_APAC_SQL_BEAN APAC_SQL_BEAN = new PILM086_APAC_SQL_BEAN();
				
				APAC_SQL_BEAN.setROWID(resultSet.getString("ROWID"));
				System.out.println("rowid==============="+resultSet.getString("ROWID"));
				APAC_SQL_BEAN.setBRH_SYS_ID(resultSet.getString("BRH_SYS_ID"));
				System.out.println("BRH_SYS_ID==============="+resultSet.getString("BRH_SYS_ID"));
				
				/*Added by saritha on 17-07-2017 for ssp call id ZBILQC-1729014*/
				/*APAC_SQL_BEAN.setBRH_PROD_CODE(resultSet.getString("BRH_PROD_CODE"));*/
				APAC_SQL_BEAN.setBRH_PROD_CODE_TO(resultSet.getString("BRH_PROD_CODE_TO"));
				System.out.println("BRH_PROD_CODE_TO==============="+resultSet.getString("BRH_PROD_CODE_TO"));
				/*End*/
				APAC_SQL_BEAN.setBRH_COVER_CODE_TO(resultSet.getString("BRH_COVER_CODE_TO"));
				System.out.println("BRH_COVER_CODE_TO==============="+resultSet.getString("BRH_COVER_CODE_TO"));
				APAC_SQL_BEAN.setBRH_WHERE_CLAUSE(resultSet.getString("BRH_WHERE_CLAUSE"));
				System.out.println("BRH_WHERE_CLAUSE==============="+resultSet.getString("BRH_WHERE_CLAUSE"));
				
				PILM086_APAC_COMPOSITE_ACTION_BEAN.getPILM086_APAC_SQLSCRIPT_ACTION_BEAN().getDataList_PILM086_APAC_SQL_BEAN().add(APAC_SQL_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
}
