package com.iii.pel.forms.PILM203;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

/**
 * 
 * @author 53060
 * 09-December-08
 */
public class PM_IL_COVER_DELEGATE {
	
	public int insertData(PM_IL_COVER pm_il_cover)
	{
		int rowsUpdated = 0;
		Connection connection = null;
		CRUDHandler handler = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			rowsUpdated = handler.executeInsert(pm_il_cover, connection);
			connection.commit();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rowsUpdated;
	}

	public String getRowId(PM_IL_COVER pm_il_cover)
	{
		String rowid = null;
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet resultSet = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			String query=PM_IL_MED_COVER_CONSTANTS.PM_IL_MED_COVER_ROWID;
			Object[] params = {pm_il_cover.getCOVER_CODE()};
			resultSet = handler.executeSelectStatement(query, connection, params);
			if(resultSet.next())
			{
				rowid = resultSet.getString(1);
			}
			
			connection.commit();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rowid;
	}
	
	
	public void setExistingValues(PM_IL_COVER pm_il_cover)
	{
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet resultSet = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			String query= PM_IL_MED_COVER_CONSTANTS.PM_IL_MED_COVER_SEARCH_QUERY;
			Object[] params = {pm_il_cover.getROWID()};
			resultSet = handler.executeSelectStatement(query, connection, params);
			if(resultSet.next())
			{
				pm_il_cover.setCOVER_CODE(resultSet.getString("COVER_CODE"));
				pm_il_cover.setCOVER_DESC(resultSet.getString("COVER_DESC"));
				pm_il_cover.setCOVER_LIMIT_TYPE(resultSet.getString("COVER_LIMIT_TYPE"));
				pm_il_cover.setCOVER_LIMIT_DAYS(resultSet.getDouble("COVER_LIMIT_DAYS"));
				pm_il_cover.setCOVER_LC_LIMIT(resultSet.getDouble("COVER_LC_LIMIT"));
				pm_il_cover.setCOVER_PER_DAY_LC_AMT(resultSet.getDouble("COVER_PER_DAY_LC_AMT"));
				pm_il_cover.setROWID(resultSet.getString("ROWID"));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
		try {
			CommonUtils.closeCursor(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	}
	
	
	public int updateBenefitDetails(PM_IL_CVR_BNF_LINK pm_il_cvr_bnf_link) throws Exception
	{
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		
		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(pm_il_cvr_bnf_link, connection);
			connection.commit();
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}
	
	//Added by deepika(Dec-26)
	public void cacadeDelete(String COVERC_CODE,String BNF_CODE)
	{
			Object[] params = {COVERC_CODE, BNF_CODE};
			String query1 = PM_IL_MED_COVER_CONSTANTS.PM_IL_BNF_PRE_DELETE_QUERY1;
			String query2 = PM_IL_MED_COVER_CONSTANTS.PM_IL_BNF_PRE_DELETE_QUERY2;
			String query3 = PM_IL_MED_COVER_CONSTANTS.PM_IL_BNF_PRE_DELETE_QUERY3;
			PRE_DELETE(query1, params);
			PRE_DELETE(query2, params);
			PRE_DELETE(query3, params);
			
			
	}
	
	
	public void PRE_DELETE(String query,Object[] params)
	{
		Connection connection = null;
		CRUDHandler handler = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			handler.executeDeleteStatement(query, connection, params);
			connection.commit();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String L_VAL_SBNF_UNIQUE(String BNF_CODE,String SBNF_CODE,String COVER_CODE)
	{
		
		String query = null;
		String returnValue = null;
		query = PM_IL_MED_COVER_CONSTANTS.PM_IL_SBNF$L_VAL_SBNF_UNIQUE$QUERY1;
		Object[] params = {SBNF_CODE,BNF_CODE,COVER_CODE};
		returnValue = duplicateCheck(query, params);
			/*if(pm_il_cvr_sbnf_link.getROWID()==null)
			{
				query = PM_IL_MED_COVER_CONSTANTS.PM_IL_SBNF$L_VAL_SBNF_UNIQUE$QUERY1;
				Object[] params = {pm_il_cvr_sbnf_link.getBSBL_BNF_CODE(),BNF_CODE,COVER_CODE};
				returnValue = duplicateCheck(query, params);
				
			}else{
				query = PM_IL_MED_COVER_CONSTANTS.PM_IL_SBNF$L_VAL_SBNF_UNIQUE$QUERY2;
				Object[] params = {pm_il_cvr_sbnf_link.getBSBL_BNF_CODE(),BNF_CODE,COVER_CODE,pm_il_cvr_sbnf_link.getROWID()};
				returnValue = duplicateCheck(query, params);
			}*/
			return returnValue;
	
	}
	
	public String duplicateCheck(String query,Object[] params)
	{
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet resultSet = null;
		String M_DUMMY = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection, params);
			if(resultSet.next())
			{
				M_DUMMY = resultSet.getString(1);
			}
		}catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return M_DUMMY;
		
	}
	
}
