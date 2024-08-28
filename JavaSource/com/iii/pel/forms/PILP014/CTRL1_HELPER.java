package com.iii.pel.forms.PILP014;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class CTRL1_HELPER {


	Connection connection = null;
	HttpSession session = null;

	public CTRL1_HELPER() {
		FacesContext context = FacesContext.getCurrentInstance();
		session = (HttpSession) context.getExternalContext().getSession(true);
	}
	
    public ArrayList<OracleParameter> EOD_FETCH(Date UI_M_PROCESS_DT, String UI_M_GROUP_ID)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, UI_M_PROCESS_DT);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, UI_M_GROUP_ID);
			parameterList.add(param2);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_EOD.P_FETCH_DTLS");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
    
    public ArrayList<OracleParameter> PROCESS_BUTTON(Date UI_M_PROCESS_DT, int P_BH_SYS_ID)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, UI_M_PROCESS_DT);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.INTEGER,
					OracleParameter.DIRECTION_TYPE.IN, P_BH_SYS_ID);
			parameterList.add(param2);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_EOD.P_PROCESS_EOD");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
		}
    
		public void whenDateValidator(Date val)throws Exception{
			try{
				if(val.after(new CommonUtils().getCurrentDate())){
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "20307"));
				}
				}catch(Exception e){
					e.printStackTrace();
					throw e;
				}
		}
	
	public void validateSeq(int value, int BD_SYS_ID) throws Exception {

		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		int BH_SYS_ID = 0;
		String query = "SELECT 'X' FROM PP_BATCH_DTLS WHERE BD_BH_SYS_ID = ?  AND BD_BM_EXEC_SEQ = ? ";
		String BH_query = "SELECT BD_BH_SYS_ID FROM PP_BATCH_DTLS WHERE BD_SYS_ID = ? ";
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(BH_query,
					connection, new Object[] { BD_SYS_ID });
			if (resultSet.next()) {
				BH_SYS_ID = resultSet.getInt(1);
			}
			resultSet2 = new CRUDHandler().executeSelectStatement(query,
					connection, new Object[] { BH_SYS_ID, value });
			if (resultSet2.next()) {
				throw new Exception("Duplicate Sequence Number");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
}

