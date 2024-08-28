package com.iii.pel.forms.PILM043;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_RI_POOL_CUST_DELEGATE {

	public int updateData(PM_IL_RI_POOL_CUST pm_il_ri_pool_cust) throws Exception
	{
		CRUDHandler handler = new CRUDHandler();
//		ConnectionAgent connectionAgent = null;
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
//		connectionAgent = new ConnectionAgent();
		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(pm_il_ri_pool_cust, connection);
//			connection.commit();
		} catch (Exception exc) {
			throw exc;
		} 
		return rowUpdated;
	}
	
	public int deleteData(PM_IL_RI_POOL_CUST pm_il_ri_pool_cust)
	{

//		ConnectionAgent connectionAgent = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
//		connectionAgent = new ConnectionAgent();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(pm_il_ri_pool_cust, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return deletedRows;
	}
	
	/*
	 * Suggestion Box for Customer Code
	 */
	public List prepareCustomerCodeList(String customerCode, List RI_POOL_CUST_LIST) throws DBException{
		String query = null;
		CRUDHandler handler = new CRUDHandler();
		CRUDHandler dbHandler = new CRUDHandler();
		Connection connection = CommonUtils.getConnection();
		if ("*".equalsIgnoreCase(customerCode)) {
			query = PM_IL_RI_POOL_SETUP_CONSTANTS.PILM043$PM_IL_RI_POOL_SETUP$RPCUST_CODE$LOV1;
			Object[] object={CommonUtils.getControlBean().getM_DIVN_CODE()};
			RI_POOL_CUST_LIST = cutomerCodeLOV(connection, query, object);

		} else {
			customerCode = customerCode + "%";
			Object[] object={CommonUtils.getControlBean().getM_DIVN_CODE(), customerCode.toUpperCase()};
			query = PM_IL_RI_POOL_SETUP_CONSTANTS.PILM043$PM_IL_RI_POOL_SETUP$RPCUST_CODE$LOV2;
			RI_POOL_CUST_LIST = cutomerCodeLOV(connection, query, object);
		}
		return RI_POOL_CUST_LIST;
	}
	
	 public List cutomerCodeLOV(Connection connection, String query, Object[] object)
		{
		 	List RI_POOL_CUST_LIST = new ArrayList();
		 	CRUDHandler handler = new CRUDHandler();
		 	ResultSet resultSet = null;
			try
			{
				resultSet=handler.executeSelectStatement(query, connection, object);
				while(resultSet.next())
				{
					PM_IL_RI_POOL_CUST pm_il_ri_pool_cust = new PM_IL_RI_POOL_CUST();
					pm_il_ri_pool_cust.setRPCUST_CODE(resultSet.getString(1));
					pm_il_ri_pool_cust.setUI_M_RPCUST_CODE_DESC(resultSet.getString(2));
					RI_POOL_CUST_LIST.add(pm_il_ri_pool_cust);
				}
			}
			catch (Exception e) {
			e.printStackTrace();
		}
		return RI_POOL_CUST_LIST;
	}
	 
	 public List getCustomerDetailsValues(String poolCode, String coverCode){
			ResultSet resultSet = null;
			List<PM_IL_RI_POOL_CUST> result = null;
			Connection connection = null;
			CRUDHandler handler = new CRUDHandler();
			try {
				connection = CommonUtils.getConnection();
				result = new ArrayList<PM_IL_RI_POOL_CUST>();
				String queryString = PM_IL_RI_POOL_SETUP_CONSTANTS.PILM043$PM_IL_RI_POOL_SETUP$FETCH_CUSTOMER_DETAILS;
				PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION pm_il_ri_pool_setup_composite_action = (PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION");
//				String poolCode = pm_il_ri_pool_setup_composite_action.PM_IL_RI_POOL_SETUP_ACTION.getPM_IL_RI_POOL_SETUP_BEAN().getRPS_CODE();
				Object[] values = {poolCode, coverCode};
				resultSet = handler.executeSelectStatement(queryString, connection, values);
				while (resultSet.next()) {
					PM_IL_RI_POOL_CUST pm_il_ri_pool_cust = new PM_IL_RI_POOL_CUST();
					pm_il_ri_pool_cust.setRPCUST_RPS_CODE(resultSet.getString("RPCUST_RPS_CODE"));
					pm_il_ri_pool_cust.setRPCUST_RPCVR_CODE(resultSet.getString("RPCUST_RPCVR_CODE"));
					pm_il_ri_pool_cust.setRPCUST_CODE(resultSet.getString("RPCUST_CODE"));
					pm_il_ri_pool_cust.setRPCUST_SHARE_PERC(resultSet.getDouble("RPCUST_SHARE_PERC"));
					pm_il_ri_pool_cust.setRPCUST_NEW_COMM(resultSet.getDouble("RPCUST_NEW_COMM"));
					pm_il_ri_pool_cust.setRPCUST_REN_COMM(resultSet.getDouble("RPCUST_REN_COMM"));
					pm_il_ri_pool_cust.setRPCUST_NEW_TAX(resultSet.getDouble("RPCUST_NEW_TAX"));
					pm_il_ri_pool_cust.setRPCUST_REN_TAX(resultSet.getDouble("RPCUST_REN_TAX"));
					pm_il_ri_pool_cust.setRPCUST_RETRO_SHARE_PERC(resultSet.getDouble("RPCUST_RETRO_SHARE_PERC"));
					pm_il_ri_pool_cust.setRPCUST_RETRO_NEW_COMM(resultSet.getDouble("RPCUST_RETRO_NEW_COMM"));
					pm_il_ri_pool_cust.setRPCUST_RETRO_REN_COMM(resultSet.getDouble("RPCUST_RETRO_REN_COMM"));
					pm_il_ri_pool_cust.setRPCUST_RETRO_NEW_TAX(resultSet.getDouble("RPCUST_RETRO_NEW_TAX"));
					pm_il_ri_pool_cust.setRPCUST_RETRO_REN_TAX(resultSet.getDouble("RPCUST_RETRO_REN_TAX"));
					pm_il_ri_pool_cust.setRPCUST_CR_DT(resultSet.getDate("RPCUST_CR_DT"));
					pm_il_ri_pool_cust.setRPCUST_CR_UID(resultSet.getString("RPCUST_CR_UID"));
//					pm_il_ri_pool_cust.setRPCUST_UPD_DT(resultSet.getDate("RPCUST_UPD_DT"));
//					pm_il_ri_pool_cust.setRPCUST_UPD_UID(resultSet.getString("RPCUST_UPD_UID"));
					pm_il_ri_pool_cust.setROWID(resultSet.getString("ROWID"));
					result.add(pm_il_ri_pool_cust);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (DBException e) {
				e.printStackTrace();
			}finally{
				try {
					new CommonUtils().closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return result;
		}
	 
	 /*
	  * Save functionlity
	  */
	public String saveData()
	{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();	
			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return "";
	}
	
	public String getCUST_DESC(String custCode)
	{
		ResultSet resultSet = null;
		String result = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ControlBean controlBean = CommonUtils.getControlBean();
		String divnCode = controlBean.getM_DIVN_CODE();
		
		try {
			connection = new CommonUtils().getConnection();
			String queryString = PM_IL_RI_POOL_SETUP_CONSTANTS.PILM043$PM_IL_RI_POOL_SETUP$RPCUST_CODE$LOV2;
			Object[] values = {divnCode,custCode};
				
			resultSet = handler.executeSelectStatement(queryString, connection, values);
			
			while (resultSet.next()) {
				result = resultSet.getString(2);
				result = result == null ? "" : result;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}finally{
			try {
				new CommonUtils().closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
}
