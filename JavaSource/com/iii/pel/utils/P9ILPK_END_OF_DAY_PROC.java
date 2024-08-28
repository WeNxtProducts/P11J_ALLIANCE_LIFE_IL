package com.iii.pel.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class P9ILPK_END_OF_DAY_PROC {
	/**
	 * @throws Exception 
	 * 
	 */
	public static void END_OF_DAY_PROC(String M_PRO_FOR,
			String M_POLICY_FM,
			String M_POLICY_TO,
			String M_TO_DT) throws Exception {
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",M_POLICY_FM);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",M_POLICY_TO);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",M_TO_DT);
		parameterList.add(param3);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			if("S".equalsIgnoreCase(M_PRO_FOR)){
				procHandler.execute(parameterList, connection, "P9ilpk_End_Of_Day_Proc.p_upd_surr_approval");
			}else if("W".equalsIgnoreCase(M_PRO_FOR)){
				procHandler.execute(parameterList, connection, "P9ilpk_End_Of_Day_Proc.P_UPD_WITHDRAWAL_APPROVAL");
			}else if("C".equalsIgnoreCase(M_PRO_FOR)){
				procHandler.execute(parameterList, connection, "P9ilpk_End_Of_Day_Proc.P_UPD_CANCEL_APPROVAL");
			}else if("B".equalsIgnoreCase(M_PRO_FOR)){
				procHandler.execute(parameterList, connection, "P9ilpk_End_Of_Day_Proc.P_CANCEL_BENEFIT");
			}else if("M".equalsIgnoreCase(M_PRO_FOR)){
				procHandler.execute(parameterList, connection, "P9ilpk_End_Of_Day_Proc.p_upd_mat_approval");
			}else if("L".equalsIgnoreCase(M_PRO_FOR)){
				procHandler.execute(parameterList, connection, "P9ilpk_End_Of_Day_Proc.P_UPD_CLAIM_APPROVAL");
			}
			else if("PH".equalsIgnoreCase(M_PRO_FOR)){
				procHandler.execute(parameterList, connection, "P9ilpk_End_Of_Day_Proc.P_UPD_PREM_HOLIDAY");
			}
		
		} catch (DBException e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(connection);
            throw new ProcedureException(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(connection);
            throw new ProcedureException(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(connection);
            throw new ProcedureException(e.getMessage());
		}
		finally{
			
		  	try{
		  	connection.commit();
			ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			}
			catch (Exception e) {
			}
		}
	}
}
