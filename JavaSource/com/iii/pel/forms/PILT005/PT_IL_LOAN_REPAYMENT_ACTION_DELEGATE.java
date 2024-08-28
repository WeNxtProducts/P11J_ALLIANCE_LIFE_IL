package com.iii.pel.forms.PILT005;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_LOAN_REPAYMENT_ACTION_DELEGATE {
	
	

	public Double P_VAL_ROUND_AMT_Delegate(String var1, String var2, String var3,String compID){
		/* var1 - IN Parameter
		 * var2 - IN OUT Parameter
		 * var3 - IN Parameter
		 * */
		
		Double result = 0.0;
		Connection con = null;
		try {
			ArrayList<OracleParameter> inputVarList = new ArrayList<OracleParameter>();

			OracleParameter inputParam1 = new OracleParameter("in1","STRING","IN",var1);
			OracleParameter inputParam2 = new OracleParameter("in2","STRING","IN OUT",var2);
			OracleParameter inputParam3 = new OracleParameter("in3","STRING","IN",var3);
			inputVarList.add(inputParam1);
			inputVarList.add(inputParam2);
			inputVarList.add(inputParam3);
			
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			con = CommonUtils.getConnection();
			
			List resultList = procHandler.execute(inputVarList, con, "P_VAL_ROUND_AMT");
			Iterator resultIterator = resultList.iterator();
			
			while (resultIterator.hasNext()) {
				OracleParameter object = (OracleParameter) resultIterator.next();
				result = Double.valueOf(object.getValue().toString());
//				System.out.println("Result = "+result);
			}
		} catch (Exception e) {}
		finally{
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(con, FacesContext.getCurrentInstance(),compID,getLoanRepaymentAction().getErrorMap(),getLoanRepaymentAction().getWarningMap());
		}
			
			
		return result;
	}

	public Double P_GET_EXCHANGE_RATE_Delegate(String var1, String var2, String var3, String var4, String var5, String compID){
		/*
		 * var1 - IN Parameter
		 * var2 - IN Parameter
		 * var3 - IN Parameter
		 * var4 - OUT Parameter
		 * var5 - IN Parameter
		 * 
		 * */
		Double result = 0.0;
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
			OracleProcedureHandler procHandler = new OracleProcedureHandler();

			ArrayList<OracleParameter> inputVarList = new ArrayList<OracleParameter>();
			OracleParameter inputParam1 = new OracleParameter("in1","STRING","IN",var1);
			OracleParameter inputParam2 = new OracleParameter("in2","STRING","IN",var2);
			OracleParameter inputParam3 = new OracleParameter("in3","STRING","IN",var3);
			OracleParameter inputParam4 = new OracleParameter("in4","STRING","OUT",var4);
			OracleParameter inputParam5 = new OracleParameter("in5","STRING","IN",var5);
			inputVarList.add(inputParam1);
			inputVarList.add(inputParam2);
			inputVarList.add(inputParam3);
			inputVarList.add(inputParam4);
			inputVarList.add(inputParam5);

			List exchangeRate = procHandler.execute(inputVarList, con, "P_GET_EXCHANGE_RATE");
			Iterator exchangeIter = exchangeRate.iterator();
			while (exchangeIter.hasNext()) {
				OracleParameter object = (OracleParameter) exchangeIter.next();
				result = Double.valueOf(object.getValue().toString());
			}
		} catch (Exception e) {}
		finally{
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(con, FacesContext.getCurrentInstance(),compID,getLoanRepaymentAction().getErrorMap(),getLoanRepaymentAction().getWarningMap());
		}
			
		return result;
	}
	
	public Double P_VAL_FC_LC_TOLERANCE_Delegate(String var1, String var2, String var3, String var4,String compID) {
		/*
		 * var1 - IN Parameter
		 * var2 - IN Parameter
		 * var3 - IN Parameter
		 * var4 - IN Parameter
		 * 
		 * */
		Double result = 0.0;
		Connection con=null;
		try{
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			 con = CommonUtils.getConnection();
			
			ArrayList<OracleParameter> toleranceList = new ArrayList<OracleParameter>();
			OracleParameter toleranceParam1 = new OracleParameter("in1","STRING","IN",var1);
			OracleParameter toleranceParam2 = new OracleParameter("in2","STRING","IN",var2);
			OracleParameter toleranceParam3 = new OracleParameter("in3","STRING","OUT",var3);
			OracleParameter toleranceParam4 = new OracleParameter("in4","STRING","IN",var4);
			toleranceList.add(toleranceParam1);
			toleranceList.add(toleranceParam2);
			toleranceList.add(toleranceParam3);
			toleranceList.add(toleranceParam4);
			
			List toleranceResult = procHandler.execute(toleranceList, con, "P_VAL_FC_LC_TOLERANCE");
			Iterator toleranceIter = toleranceList.iterator();
			while (toleranceIter.hasNext()) {
				OracleParameter object = (OracleParameter) toleranceIter.next();
				result = Double.valueOf(object.getValue().toString());
			}
		}catch (Exception e) {}
		finally{
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(con, FacesContext.getCurrentInstance(),compID,getLoanRepaymentAction().getErrorMap(),getLoanRepaymentAction().getWarningMap());
		}
		return result;
	}
	
	public int CALC_LOAN_INTEREST_Delegate(String var1, String var2, String var3, String var4,String compID){
		/*
		 * var1 - IN Parameter
		 * var2 - IN Parameter
		 * var3 - IN Parameter
		 * var4 - OUT Parameter
		 * */
		Connection con = null;
		int calcLocalIntValue = 0;
		try {
			con = CommonUtils.getConnection();
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1","STRING","IN",var1);
			OracleParameter param2 = new OracleParameter("in2","STRING","IN",var2);
			OracleParameter param3 = new OracleParameter("in3","STRING","IN",var3);
			OracleParameter param4 = new OracleParameter("in4","STRING","OUT",var4);
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			paramList.add(param4);

			List calcLocalInt = new ArrayList();
			calcLocalInt = procHandler.execute(paramList, con, "P9ILPK_LOAN.CALC_LOAN_INTEREST");
			Iterator it = calcLocalInt.iterator();
			while (it.hasNext()) {
				OracleParameter type = (OracleParameter) it.next();
				calcLocalIntValue = Integer.parseInt(type.getValue().toString());
			}
			
		} catch (Exception e) {}
		finally{
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(con, FacesContext.getCurrentInstance(),compID,getLoanRepaymentAction().getErrorMap(),getLoanRepaymentAction().getWarningMap());
		}
		return calcLocalIntValue;
	}
	
	private PT_IL_LOAN_REPAYMENT_ACTION getLoanRepaymentAction(){
		Map sessionMap= FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		PT_IL_LOAN_REPAYMENT_ACTION action = (PT_IL_LOAN_REPAYMENT_ACTION) sessionMap.get("PILT005_PT_IL_LOAN_REPAYMENT_ACTION");
		return action;
	}
	
	
}
