/**
 * 
 */
package com.iii.pel.forms.PILP109_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

/**
 * @author 55368
 *
 */
public class PILP109_APAC_DUMMY_HELPER {

	/**
	 * 
	 */
	public void buttonProcess(PILP109_APAC_DUMMY DUMMY_BEAN) throws Exception{
		try{
			
			P9ILPK_END_OF_DAY_PROC_P_POL_CREATE(DUMMY_BEAN.getPT_PROD_FROM(),DUMMY_BEAN.getPT_PROD_TO());
			
		}catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}
	}
	
	/**
	 * 
	 * @param productCodeFm
	 * @param productCodeTo
	 * @throws ProcedureException
	 */
	private void P9ILPK_END_OF_DAY_PROC_P_POL_CREATE(String productCodeFm,String productCodeTo) throws ProcedureException{
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();

			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, productCodeFm);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, productCodeTo);
			
			parameterList.add(param1);
			parameterList.add(param2);
			
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_END_OF_DAY_PROC.P_POL_CREATE");
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(connection);
		}
	}
	
	     
    public void validateProductCode(String polCode) throws Exception{
    	Connection connection =null;
    	CRUDHandler handler = new CRUDHandler();
    	ResultSet resultSet = null;
    	String C1="select prod_code from PM_IL_PRODUCT where prod_code=?";
    	try{
    		connection = CommonUtils.getConnection();
    		resultSet = handler.executeSelectStatement(C1, connection,new Object[]{polCode});
    		if(!resultSet.next()){
    			throw new Exception("Invalid Product Code");
    		}
    		
    	}catch(Exception exception){
    		exception.printStackTrace();
    		throw exception;
    	}finally{
    		CommonUtils.closeCursor(resultSet);
    	}
    }
}
