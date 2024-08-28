package com.iii.pel.forms.PILP075;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.OracleFunctionHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class PKG_PILP075_CANC_REFN 
{
	public ArrayList<OracleParameter> P_CANCEL_APPRV(
			int P_PCF_SYS_ID,
			int P_POL_SYS_ID,
			Date P_APPROVAL_DT) throws ProcedureException {
		System.out.println("Enter P_CANCEL_APPRV Procedure");
		System.out.println("P_PCF_SYS_ID   : "+P_PCF_SYS_ID); 
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_PCF_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,new CommonUtils().dateToStringFormat(P_APPROVAL_DT));
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("OUT4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param4);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			
			outputList = procHandler.executeProc(parameterList, connection,
					"P10ILPK_PILP075_LLB.P_CANCEL_APPRV");
			System.out.println("outputList.get(0).getValue()   : "+outputList.get(0).getValueObject());
			
			
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	
	public int  P_ELAP_MNTH(
			Date P_REFUND_DT,
			String P_POL_SYS_ID,
			int Tot_Mon_Elpsd) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			
			//System.out.println("new CommonUtils().dateToStringFormat(P_REFUND_DT)    :  "+new CommonUtils().dateToStringFormat(P_REFUND_DT));
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, new CommonUtils().dateToStringFormat(P_REFUND_DT));
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, Integer.parseInt(P_POL_SYS_ID));
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("OUT3", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param3);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P10ILPK_PILP075_LLB.P_ELAP_MNTH");
		
			System.out.println("outputList.get(0).getValue()   : "+outputList.get(0).getValueObject());
			Tot_Mon_Elpsd =Integer.parseInt(outputList.get(0).getValueObject().toString());
			
		
		} catch(Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		
		return Tot_Mon_Elpsd;
	}
	
	
	public Double  P_COMM_CALC(
			int PCF_SYS_ID,
			int PCF_POL_SYS_ID) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		Double PCF_COMM_FC_RFND=0.0;
		try {
			
			System.out.println("ENTER THE P_COMM_CALC ");
			connection = CommonUtils.getConnection();
			/*connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, PCF_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, PCF_POL_SYS_ID);
			parameterList.add(param2);

			OracleFunctionHandler procHandler = new OracleFunctionHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P10ILPK_PILP075_LLB.P_COMM_CALC");
			
			System.out.println("outputList.get(0).getValue()   : "+outputList.get(0).getValueObject());
			PCF_COMM_FC_RFND = Double.parseDouble(outputList.get(0).getValueObject().toString());
			
			
			
			
		*/
			
			
			
			
			
			
			
			String sql = "{ ? = call P10ILPK_PILP075_LLB.P_COMM_CALC(?,?) }";
			CallableStatement statement = connection.prepareCall(sql);
			statement.setLong(2,PCF_SYS_ID);
			statement.setLong(3,PCF_POL_SYS_ID);
			statement.registerOutParameter(1, java.sql.Types.DOUBLE);  

			statement.execute();   
			//this is the main line
			
			System.out.println("statement.getLong(1)    : "+statement.getLong(1));
			PCF_COMM_FC_RFND = statement.getDouble(1);
			
			System.out.println("id    : "+PCF_COMM_FC_RFND);
			
			
			
			
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		
		
		return PCF_COMM_FC_RFND;
	}
	
	public ArrayList<OracleParameter> P_CALC_REFUND(
			int P_PCF_SYS_ID,
			int P_POL_SYS_ID,
			Date P_REFUND_DT,
			int P_YEAR,
			String P_REFUND_PREM,
			Double P_RECOVER_COMM) throws ProcedureException {
		System.out.println("Enter P_CANCEL_APPRV Procedure");
		System.out.println("P_PCF_SYS_ID   : "+P_PCF_SYS_ID); 
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_PCF_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
			parameterList.add(param2);
			System.out.println("P_REFUND_DT      "+P_REFUND_DT+"       new CommonUtils().dateToStringFormat(P_REFUND_DT)     "+new CommonUtils().dateToStringFormat(P_REFUND_DT));
			OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,new CommonUtils().dateToStringFormat(P_REFUND_DT));
			parameterList.add(param3);
			
			OracleParameter param4 = new OracleParameter("OUT4", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.OUT, P_YEAR);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("OUT5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, P_REFUND_PREM);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("OUT6", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT, P_RECOVER_COMM);
			parameterList.add(param6);
			
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			
			outputList = procHandler.executeProc(parameterList, connection,
					"P10ILPK_PILP075_LLB.P_CALC_REFUND");
			System.out.println("outputList.get(0).getValue()   : "+outputList.get(0).getValueObject());
			
			
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
}
