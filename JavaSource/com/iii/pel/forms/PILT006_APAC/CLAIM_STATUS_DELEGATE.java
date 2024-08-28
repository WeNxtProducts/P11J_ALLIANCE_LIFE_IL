package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class CLAIM_STATUS_DELEGATE {
	//[BugId:Fix Shankar Bodduluri 19-03-09 getting connection from CommonUtil class getConnection()
/*	public Connection getConnection() throws Exception {
		Connection connection = null;
		String driverClass = "oracle.jdbc.driver.OracleDriver";
		String databaseUrl = "jdbc:oracle:thin:@10.44.0.138:1521:orcl";
		String databaseName = "pel_life";
		String databasePwd = "pel_life";

		Class.forName(driverClass);
		connection = DriverManager.getConnection(databaseUrl, databaseName,
				databasePwd);

		return connection;
	}*/
	//[BugId:Fix Shankar Bodduluri 19-03-09 getting connection from CommonUtil class getConnection()	
	public Connection getConnection() throws Exception {
		Connection connection = null;
		connection = CommonUtils.getConnection();

		return connection;
	}

	@SuppressWarnings("unchecked")
	public ArrayList getValues() {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		ArrayList list = null;
		try {
			System.out.println("INSIDE CLAIM STATUS");
			list = new ArrayList();
			connection = getConnection();
			String query = "SELECT CS_STATUS_CODE,CS_REASON_CODE,CS_STATUS_DT,CS_STATUS_UID,"
					+ "CS_REMARKS FROM PT_IL_CLAIM_STATUS";
			resultSet = handler.executeSelectStatement(query, connection);
			while (resultSet.next()) {
				PT_IL_CLAIM_STATUS claim_status = new PT_IL_CLAIM_STATUS();
				claim_status.setCS_STATUS_CODE(resultSet
						.getString("CS_STATUS_CODE"));
				claim_status.setCS_REASON_CODE(resultSet
						.getString("CS_REASON_CODE"));
				claim_status.setCS_STATUS_DT(resultSet.getDate("CS_STATUS_DT"));
				claim_status.setUI_M_REASON_CODE_DESC(resultSet
						.getString("CS_STATUS_UID"));
				claim_status.setCS_REMARKS(resultSet.getString("CS_REMARKS"));
				list.add(claim_status);
			}
			// list=(ArrayList)handler.fetch(query,
			// "com.iii.pel.forms.PILM050_APAC.PT_IL_CLAIM_STATUS", connection);
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public ArrayList todoGroupValues() {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		ArrayList list = null;
		try {
			list = new ArrayList();
			connection = getConnection();
			String query = "select DTG_GROUP_TYPE,DTG_GROUP_CODE,DTG_GROUP_DESC from PM_IL_DOC_TODO_GROUP";
			resultSet = handler.executeSelectStatement(query, connection);
			while (resultSet.next()) {
				PM_IL_DOC_TODO_GROUP todo_group_bean = new PM_IL_DOC_TODO_GROUP();
				todo_group_bean.setDTG_GROUP_TYPE(resultSet
						.getString("DTG_GROUP_TYPE"));
				todo_group_bean.setDTG_GROUP_CODE(resultSet
						.getString("DTG_GROUP_CODE"));
				todo_group_bean.setDTG_GROUP_DESC(resultSet
						.getString("DTG_GROUP_DESC"));
				list.add(todo_group_bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public ArrayList todoListValues() {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		@SuppressWarnings("unused")
		ResultSet resultSet = null;
		ArrayList list = null;

		try {
			list = new ArrayList();
			connection = getConnection();
			String query = "SELECT DTLS_CLM_SYS_ID,DTLS_SR_NO,DTLS_TODO_LIST_ITEM,DTLS_MANDATORY_YN," +
					"DTLS_APPR_STS,DTLS_DOC_REC_DT,DTLS_REMARKS from PT_IL_DOC_TODO_LIST_STATUS " +
					"WHERE EXISTS ( SELECT PT_IL_CLAIM.ROWID FROM PT_IL_CLAIM " +
					"WHERE CLAIM_SYS_ID=DTLS_CLM_SYS_ID AND PT_IL_CLAIM.ROWID = nvl('',PT_IL_CLAIM.ROWID))";
			resultSet = handler.executeSelectStatement(query, connection);
			while (resultSet.next()) {
				PT_IL_DOC_TODO_LIST_STATUS todo_list_bean = new PT_IL_DOC_TODO_LIST_STATUS();
				todo_list_bean.setDTLS_SR_NO(resultSet.getLong("DTLS_SR_NO"));
				todo_list_bean.setDTLS_TODO_LIST_ITEM(resultSet
						.getString("DTLS_TODO_LIST_ITEM"));
				todo_list_bean.setDTLS_MANDATORY_YN(resultSet
						.getString("DTLS_MANDATORY_YN"));
				todo_list_bean.setDTLS_APPR_STS(resultSet
						.getString("DTLS_APPR_STS"));
				todo_list_bean.setDTLS_DOC_REC_DT(resultSet
						.getDate("DTLS_DOC_REC_DT"));
				todo_list_bean.setDTLS_REMARKS(resultSet
						.getString("DTLS_REMARKS"));
				list.add(todo_list_bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList fundTranValues()
	{
		Connection connection =null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		ArrayList list = null;
		
		try {
			list = new ArrayList();
			connection = getConnection();
			String query = "select FTD_FUND_CODE,FTD_PREM_UNITS,FTD_TOP_UP_UNITS,FTD_NO_OF_UNITS," +
					"FTD_UNIT_SEL_PRICE,FTD_UNIT_LC_AMT from PT_IL_FUND_TRAN_DTL";
			resultSet= handler.executeSelectStatement(query, connection);
			while(resultSet.next())
			{
				PT_IL_FUND_TRAN_DTL fund_tran_bean = new PT_IL_FUND_TRAN_DTL();
				fund_tran_bean.setFTD_FUND_CODE(resultSet.getString("FTD_FUND_CODE"));
				fund_tran_bean.setFTD_PREM_UNITS(resultSet.getDouble("FTD_PREM_UNITS"));
				fund_tran_bean.setFTD_TOP_UP_UNITS(resultSet.getDouble("FTD_TOP_UP_UNITS"));
				fund_tran_bean.setFTD_NO_OF_UNITS(resultSet.getDouble("FTD_NO_OF_UNITS"));
				fund_tran_bean.setFTD_UNIT_SEL_PRICE(resultSet.getDouble("FTD_UNIT_SEL_PRICE"));
				fund_tran_bean.setFTD_UNIT_LC_AMT(resultSet.getDouble("FTD_UNIT_LC_AMT"));
				list.add(fund_tran_bean);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList reminderValues()
	{
		Connection connection =null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		ArrayList list = null;
		try {
			list = new ArrayList();
			connection = getConnection();
			String query = "SELECT CS_STATUS_DT,CS_REMINDER_NO,CS_STATUS_CODE,CS_STATUS_UID " +
					"FROM PT_IL_CLAIM_STATUS,PT_IL_CLAIM WHERE CLAIM_SYS_ID=CS_CLM_SYS_ID";
			resultSet=handler.executeSelectStatement(query, connection);
			while(resultSet.next())
			{
				PT_IL_CLAIM_STATUS_2 claim_reminder_bean = new PT_IL_CLAIM_STATUS_2();
				claim_reminder_bean.setCS_STATUS_DT(resultSet.getDate("CS_STATUS_DT"));
				claim_reminder_bean.setCS_REMINDER_NO(resultSet.getDouble("CS_REMINDER_NO"));
				claim_reminder_bean.setCS_STATUS_CODE(resultSet.getString("CS_STATUS_CODE"));
				claim_reminder_bean.setCS_STATUS_UID(resultSet.getString("CS_STATUS_UID"));
				list.add(claim_reminder_bean);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
}








