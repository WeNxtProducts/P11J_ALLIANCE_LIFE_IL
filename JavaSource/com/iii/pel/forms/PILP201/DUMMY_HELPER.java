package com.iii.pel.forms.PILP201;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class DUMMY_HELPER {

	public DUMMY_HELPER() {
	}

	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public List<LovBean> getPolicyNumber(String value){
		List<LovBean> list = new ArrayList<LovBean>();
		Connection connection =null;
		CRUDHandler handler = null;
		LovBean lovBean =null;
		String C1="SELECT POL_NO FROM PT_IL_POLICY WHERE  (POL_DS_TYPE = '2' AND   POL_STATUS ='A')  AND ROWNUM < 20";
		String C1_APPEND=" SELECT POL_NO FROM PT_IL_POLICY WHERE (POL_DS_TYPE = '2' AND   POL_STATUS ='A')  AND (POL_NO LIKE ?) AND ROWNUM < 20"; 
		ResultSet C1_REC = null;
		try{
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			if("*".equalsIgnoreCase(value)){
				System.out.println("C1"+C1);
				C1_REC = handler.executeSelectStatement(C1, connection);
			}else{
				System.out.println("C1_APPEND"+C1_APPEND);
				C1_REC = handler.executeSelectStatement(C1_APPEND, connection,new Object[]{value + "%"});
			}
			while(C1_REC.next()){
				lovBean = new LovBean();
				lovBean.setCode(C1_REC.getString(1));
				//lovBean.setName(C1_REC.getString(2));
				list.add(lovBean);
			}
			
		}catch(Exception exception){
			exception.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(C1_REC);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<OracleParameter> PROC_ANIVR_PROCESS(Object P_POL_NO_FROM,
			Object P_POL_NO_TO, Object P_PROCESS_DATE ,String procedureName) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		System.out.println("ProcedureName=================>"+procedureName);
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_POL_NO_FROM);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_POL_NO_TO);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN OUT3",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, P_PROCESS_DATE);
			parameterList.add(param3);
			
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					procedureName);
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	
	
}
