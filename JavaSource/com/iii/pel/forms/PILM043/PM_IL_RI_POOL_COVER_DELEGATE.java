package com.iii.pel.forms.PILM043;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_RI_POOL_COVER_DELEGATE {

	public int updateData(PM_IL_RI_POOL_COVER pm_il_ri_pool_cover) throws Exception
	{
		CRUDHandler handler = new CRUDHandler();
//		ConnectionAgent connectionAgent = null;
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(pm_il_ri_pool_cover, connection);
//			connection.commit();
		} catch (Exception exc) {
			throw exc;
		} 
		return rowUpdated;
	}
	
	public int deleteData(PM_IL_RI_POOL_COVER pm_il_ri_pool_cover)
	{

//		ConnectionAgent connectionAgent = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(pm_il_ri_pool_cover, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return deletedRows;
	}
	
	/*
	 * Suggestion Box for Cover Code.
	 */
	public List prepareCoverCodeList(String coverCode, List RI_POOL_COVER_LIST) throws DBException{
		String query = null;
		Connection connection = CommonUtils.getConnection();
		if ("*".equalsIgnoreCase(coverCode)) {
			query = PM_IL_RI_POOL_SETUP_CONSTANTS.PILM043$PM_IL_RI_POOL_SETUP$RPCVR_CODE$LOV1;
			Object[] object={};
			RI_POOL_COVER_LIST = coverCodeLOV(connection, query, object);

		} else {
			coverCode = coverCode + "%";
			Object[] object={coverCode.toUpperCase()};
			query = PM_IL_RI_POOL_SETUP_CONSTANTS.PILM043$PM_IL_RI_POOL_SETUP$RPCVR_CODE$LOV2;
			RI_POOL_COVER_LIST = coverCodeLOV(connection, query, object);
		}
		return RI_POOL_COVER_LIST;
	}
	
	public List coverCodeLOV(Connection connection, String query, Object[] object)
		{
		 	List RI_POOL_COVER_LIST = new ArrayList();
		 	CRUDHandler handler = new CRUDHandler();
		 	ResultSet resultSet = null;
			try
			{
				resultSet=handler.executeSelectStatement(query, connection, object);
				while(resultSet.next())
				{
					PM_IL_RI_POOL_COVER pm_il_ri_pool_cover = new PM_IL_RI_POOL_COVER();
//					PM_IL_PREM_ACCOUNT_SETUP pm_il_prem_account_setup = new PM_IL_PREM_ACCOUNT_SETUP();
					pm_il_ri_pool_cover.setRPCVR_CODE(resultSet.getString(1));
					pm_il_ri_pool_cover.setUI_M_RPCVR_CODE_DESC(resultSet.getString(2));
					RI_POOL_COVER_LIST.add(pm_il_ri_pool_cover);
				}
			}
			catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				new CommonUtils().closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return RI_POOL_COVER_LIST;
	}

	public List getCoverDetailsValues()
	{
		ResultSet resultSet = null;
		List<PM_IL_RI_POOL_COVER> result = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			result = new ArrayList<PM_IL_RI_POOL_COVER>();
			String queryString = PM_IL_RI_POOL_SETUP_CONSTANTS.PILM043$PM_IL_RI_POOL_SETUP$FETCH_COVER_DETAILS;
			PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION pm_il_ri_pool_setup_composite_action = (PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PILM043_PM_IL_RI_POOL_SETUP_COMPOSITE_ACTION");
			String poolCode = pm_il_ri_pool_setup_composite_action.PM_IL_RI_POOL_SETUP_ACTION.getPM_IL_RI_POOL_SETUP_BEAN().getRPS_CODE();
			Object[] values = {poolCode};
			resultSet = handler.executeSelectStatement(queryString, connection, values);
			while (resultSet.next()) {
				PM_IL_RI_POOL_COVER pm_il_ri_pool_cover = new PM_IL_RI_POOL_COVER();
				pm_il_ri_pool_cover.setRPCVR_CODE(resultSet.getString("RPCVR_CODE"));
				pm_il_ri_pool_cover.setRPCVR_SHARE_PERC(resultSet.getDouble("RPCVR_SHARE_PERC"));
				pm_il_ri_pool_cover.setROWID(resultSet.getString("ROWID"));
				pm_il_ri_pool_cover.setRPCVR_CR_DT(resultSet.getDate("RPCVR_CR_DT"));
				pm_il_ri_pool_cover.setRPCVR_CR_UID(resultSet.getString("RPCVR_CR_UID"));
				pm_il_ri_pool_cover.setRPCVR_UPD_DT(resultSet.getDate("RPCVR_UPD_DT"));
				pm_il_ri_pool_cover.setRPCVR_UPD_UID(resultSet.getString("RPCVR_UPD_UID"));
				result.add(pm_il_ri_pool_cover);
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
	
	 public String P_VAL_COVER(String coverCode, String name_Flag, String error_Flag)
		{
			 	Connection connection = null;
			 	String outputValue = null;
				ArrayList parameterList = new ArrayList();
				ArrayList outputList  = new ArrayList();
				OracleParameter param1 = new OracleParameter("in1","STRING","IN",coverCode);
				OracleParameter param2 = new OracleParameter("inout1","STRING","IN OUT","");
				OracleParameter param3 = new OracleParameter("in2","STRING","IN", null);
				OracleParameter param4 = new OracleParameter("in3","STRING","IN",name_Flag);
				OracleParameter param5 = new OracleParameter("in4","STRING","IN",error_Flag);
				parameterList.add(param1);
				parameterList.add(param2);
				parameterList.add(param3);
				parameterList.add(param4);
				parameterList.add(param5);
				
				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				try {
					connection = CommonUtils.getConnection();
//					PCOPK_SYS_VARS(connection);
					outputList = procHandler.execute(parameterList, connection, "P_VAL_COVER");
					Iterator<OracleParameter> iterator = outputList.iterator();
					while(iterator.hasNext())
					{
						OracleParameter oracleParameter = iterator.next();
						outputValue = oracleParameter.getValue();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				return outputValue;
			}
	 
	 public String getRPCVR_DESC(String coverCode)
		{
			ResultSet resultSet = null;
			String result = null;
			Connection connection = null;
			CRUDHandler handler = new CRUDHandler();
			try {
				connection = new CommonUtils().getConnection();
				String queryString = PM_IL_RI_POOL_SETUP_CONSTANTS.PILM043$PM_IL_RI_POOL_SETUP$RPCVR_CODE$LOV2;
				Object[] values = {coverCode};
				
				resultSet = handler.executeSelectStatement(queryString, connection, values);
				while (resultSet.next()) {
					result = resultSet.getString(2);
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
