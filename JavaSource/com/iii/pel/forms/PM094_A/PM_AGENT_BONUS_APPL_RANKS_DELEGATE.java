package com.iii.pel.forms.PM094_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_AGENT_BONUS_APPL_RANKS_DELEGATE {

	public int updateData(PM_AGENT_BONUS_APPL_RANKS pm_agent_bonus_appl_ranks)
			throws Exception {
	
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;

		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(pm_agent_bonus_appl_ranks, connection);
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}

	public int deleteData(PM_AGENT_BONUS_APPL_RANKS gridValueBean) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(gridValueBean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}

	public List getCodeList(String code, List CodeList) {
		String query;
		if ("*".equalsIgnoreCase(code)) {
			query=  " SELECT PC_CODE,PC_DESC " +
			  " FROM PM_CODES " +
			  " WHERE  PC_TYPE='AGNRANK'"+
				" ORDER BY 1ASC";
		

			CodeList = codeLOV(query);
		} else {

			query = " SELECT PC_CODE,PC_DESC " +
			  " FROM PM_CODES " +
			  " WHERE  PC_TYPE='AGNRANK'"+
					 " AND UPPER(PC_CODE) LIKE '" + code.toUpperCase() + "%'" +
							" ORDER BY 1ASC ";
	

			CodeList = codeLOV(query);

		}

		return CodeList;
	}
	
	/**/
	public List getCodeListForClassFM(String code, List CodeList) {
		String query;
		if ("*".equalsIgnoreCase(code)) {
			/*query=  " SELECT PC_CODE,PC_DESC " +
			  " FROM PM_CODES " +
			  " WHERE  PC_TYPE='AGNRANK'"+
				" ORDER BY 1ASC";*/
			
			
			
			
			
			query=  "SELECT DISTINCT CUST_CLASS,CCLAS_CLASS_DESC"
					+ "FROM PM_CUSTOMER,PM_CUST_CLASS"
					+ "WHERE CUST_CLASS IN ('AG01','AG02','AG03','AG04','STF','TIED') "
					+ "AND CCLAS_CODE = CUST_CLASS";
		

			CodeList = codeLovForClassFm(query);
		} else {

			/*query = " SELECT PC_CODE,PC_DESC " +
			  " FROM PM_CODES " +
			  " WHERE  PC_TYPE='AGNRANK'"+
					 " AND UPPER(PC_CODE) LIKE '" + code.toUpperCase() + "%'" +
							" ORDER BY 1ASC ";*/
			
			/*query=  "SELECT DISTINCT CUST_CLASS,CCLAS_CLASS_DESC FROM PM_CUSTOMER,PM_CUST_CLASS"
					+ " WHERE CUST_CLASS LIKE '" + code.toUpperCase() + "%'" +
					" AND CCLAS_CODE = CUST_CLASS";*/
			
			/*query = "SELECT DISTINCT CUST_CLASS,CCLAS_CLASS_DESC	FROM PM_CUSTOMER,PM_CUST_CLASS WHERE CUST_CLASS like '" + code.toUpperCase() + "%' AND CCLAS_CODE = CUST_CLASS";*/
			query=  "SELECT DISTINCT CUST_CLASS,CCLAS_CLASS_DESC"
					+ " FROM PM_CUSTOMER,PM_CUST_CLASS"
					+ " WHERE CUST_CLASS IN ('AG01','AG02','AG03','AG04','STF','TIED') "
					+ " AND CCLAS_CODE = CUST_CLASS";
	

			CodeList = codeLovForClassFm(query);

		}

		return CodeList;
	}
	
	public List getCodeListForClassTo(String code, List CodeList) {
		String query;
		if ("*".equalsIgnoreCase(code)) {
			/*query=  " SELECT PC_CODE,PC_DESC " +
			  " FROM PM_CODES " +
			  " WHERE  PC_TYPE='AGNRANK'"+
				" ORDER BY 1ASC";*/
			
			
			
			
			
			query=  "SELECT DISTINCT CUST_CLASS,CCLAS_CLASS_DESC"
					+ "FROM PM_CUSTOMER,PM_CUST_CLASS"
					+ "WHERE CUST_CLASS IN ('AG01','AG02','AG03','AG04','STF','TIED') "
					+ "AND CCLAS_CODE = CUST_CLASS";
		

			CodeList = codeLovForClassTo(query);
		} else {

			/*query = " SELECT PC_CODE,PC_DESC " +
			  " FROM PM_CODES " +
			  " WHERE  PC_TYPE='AGNRANK'"+
					 " AND UPPER(PC_CODE) LIKE '" + code.toUpperCase() + "%'" +
							" ORDER BY 1ASC ";*/
			
			/*query=  "SELECT DISTINCT CUST_CLASS,CCLAS_CLASS_DESC"
					+ "FROM PM_CUSTOMER,PM_CUST_CLASS"
					+ "WHERE CUST_CLASS LIKE '" + code.toUpperCase() + "%'" +
					" AND CCLAS_CODE = CUST_CLASS";*/
			
			query=  "SELECT DISTINCT CUST_CLASS,CCLAS_CLASS_DESC"
					+ " FROM PM_CUSTOMER,PM_CUST_CLASS"
					+ " WHERE CUST_CLASS IN ('AG01','AG02','AG03','AG04','STF','TIED') "
					+ " AND CCLAS_CODE = CUST_CLASS";

			CodeList = codeLovForClassTo(query);

		}

		return CodeList;
	}
	
	/**/
	

	public String getCodeDesc(String Code, List codeList) {
		Iterator iterator = codeList.iterator();
		String codedesc = null;
		while (iterator.hasNext()) {
			PM_AGENT_BONUS_APPL_RANKS pm_agent_bonus_appl_ranks = (PM_AGENT_BONUS_APPL_RANKS) iterator
					.next();
			if (Code.equalsIgnoreCase(pm_agent_bonus_appl_ranks.getABAR_RANK_CODE())) {
				codedesc = pm_agent_bonus_appl_ranks.getUI_M_ABS_AGENT_RANK_DESC();
			}
		}
		return codedesc;
	}

	public List<PM_AGENT_BONUS_APPL_RANKS> codeLOV(String query) {
		List<PM_AGENT_BONUS_APPL_RANKS> codeList = new ArrayList<PM_AGENT_BONUS_APPL_RANKS>();
	   ResultSet resultSet = null;
		
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
		    resultSet = handler.executeSelectStatement(query,
					connection);
			while (resultSet.next()) {

				PM_AGENT_BONUS_APPL_RANKS pm_agent_bonus_appl_ranks = new PM_AGENT_BONUS_APPL_RANKS();
				pm_agent_bonus_appl_ranks.setABAR_RANK_CODE(resultSet.getString(1));
				pm_agent_bonus_appl_ranks.setUI_M_ABS_AGENT_RANK_DESC(resultSet
						.getString(2));
				codeList.add(pm_agent_bonus_appl_ranks);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				 CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return codeList;
	}
	
	/**/
	public List<PM_AGENT_BONUS_APPL_RANKS> codeLovForClassFm(String query) {
		List<PM_AGENT_BONUS_APPL_RANKS> codeList = new ArrayList<PM_AGENT_BONUS_APPL_RANKS>();
	   ResultSet resultSet = null;
		
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
		    resultSet = handler.executeSelectStatement(query,
					connection);
			while (resultSet.next()) {

				PM_AGENT_BONUS_APPL_RANKS pm_agent_bonus_appl_ranks = new PM_AGENT_BONUS_APPL_RANKS();
				pm_agent_bonus_appl_ranks.setABAR_CLASS_FM(resultSet.getString(1));
				pm_agent_bonus_appl_ranks.setUI_M_ABAR_CLASS_FM_DESC(resultSet
						.getString(2));
				codeList.add(pm_agent_bonus_appl_ranks);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				 CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return codeList;
	}
	
	public List<PM_AGENT_BONUS_APPL_RANKS> codeLovForClassTo(String query) {
		List<PM_AGENT_BONUS_APPL_RANKS> codeList = new ArrayList<PM_AGENT_BONUS_APPL_RANKS>();
	   ResultSet resultSet = null;
		
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
		    resultSet = handler.executeSelectStatement(query,
					connection);
			while (resultSet.next()) {

				PM_AGENT_BONUS_APPL_RANKS pm_agent_bonus_appl_ranks = new PM_AGENT_BONUS_APPL_RANKS();
				pm_agent_bonus_appl_ranks.setABAR_CLASS_TO(resultSet.getString(1));
				pm_agent_bonus_appl_ranks.setUI_M_ABAR_CLASS_TO_DESC(resultSet
						.getString(2));
				codeList.add(pm_agent_bonus_appl_ranks);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				 CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return codeList;
	}
	
	
	
	
}
