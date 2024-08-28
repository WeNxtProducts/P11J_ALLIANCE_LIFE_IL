package com.iii.pel.forms.PILM075_APAC;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_END_SETUP_DET_DELEGATE {
	
	public int updateData(PM_IL_END_SETUP_DET pm_il_end_setup_det) throws Exception
	{
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(pm_il_end_setup_det, connection);
		} catch (Exception exc) {
			throw exc;
		} 
		return rowUpdated;
	}
	
	public int deleteData(PM_IL_END_SETUP_DET pm_il_end_setup_det)
	{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(pm_il_end_setup_det, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return deletedRows;
	}
	
	/* [BugId:PREMIAGDC-000069 Deepika 25-Feb-09 Newly added method for L_COPY_USER_DTLS procedure calling for copy action */
	public ArrayList L_COPY_USER_DTLS(PM_IL_END_APPR_COPY pm_il_end_appr_copy)throws Exception
	{
		//Test CVS
		ArrayList parameterList = new ArrayList();
		ArrayList outputList  = new ArrayList();
		ArrayList<String> resultList = new ArrayList<String>();
		Connection connection = null;
		try{
		OracleParameter param1 = new OracleParameter("in1","STRING","IN",pm_il_end_appr_copy.getEAS_DEST_AS_USER_ID());
		OracleParameter param2 = new OracleParameter("in2","STRING","IN",pm_il_end_appr_copy.getEAS_DEST_AS_FM_PROD_CODE());
		OracleParameter param3 = new OracleParameter("in3","STRING","IN",pm_il_end_appr_copy.getEAS_DEST_AS_TO_PROD_CODE());
		OracleParameter param4 = new OracleParameter("in4","STRING","IN", pm_il_end_appr_copy.getEAS_AS_FM_PROD_CODE());
		OracleParameter param5 = new OracleParameter("in5","STRING","IN",pm_il_end_appr_copy.getEAS_AS_TO_PROD_CODE());
		OracleParameter param6 = new OracleParameter("in6","STRING","IN", pm_il_end_appr_copy.getEAS_AS_USER_ID());
		OracleParameter param7 = new OracleParameter("in7","STRING","IN", pm_il_end_appr_copy.getEAS_FM_END_CODE());
		OracleParameter param8 = new OracleParameter("in8","STRING","IN", pm_il_end_appr_copy.getEAS_TO_END_CODE());
		OracleParameter param9 = new OracleParameter("in9","STRING","IN", pm_il_end_appr_copy.getEAS_AS_FM_PROD_CODE());
		OracleParameter param10 = new OracleParameter("in10","STRING","IN", pm_il_end_appr_copy.getEAS_DEST_AS_TO_PROD_CODE());
		OracleParameter param11 = new OracleParameter("in11","STRING","IN", pm_il_end_appr_copy.getEAS_DEST_AS_USER_ID());
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		parameterList.add(param6);
		parameterList.add(param7);
		parameterList.add(param8);
		parameterList.add(param9);
		parameterList.add(param10);
		parameterList.add(param11);
		String value = null;
		
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		
			connection = CommonUtils.getConnection();
			outputList = procHandler.execute(parameterList, connection, "PKG_PILM039.L_COPY_USER_DTLS");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while(iterator.hasNext())
			{
				OracleParameter oracleParameter = iterator.next();
				if(oracleParameter.getValue()!=null)
				{
					value = oracleParameter.getValue();
					resultList.add(value);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return resultList;
	}
	/* BugId:PREMIAGDC-000069 Deepika 25-Feb-09 Newly added method for L_COPY_USER_DTLS procedure calling for copy action] */
}
