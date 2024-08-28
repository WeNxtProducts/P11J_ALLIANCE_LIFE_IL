package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class PILM035_APAC_DBProcedures {
	public static String P_VAL_CVR_GRP(String P_CVR_GRP_CODE,
			String P_CVR_GRP_DESC, String P_NAME_FLAG, String P_ERR_FLAG)
			throws Exception {
		String CURSOR_C1 = "SELECT DECODE( ? , 'N', CGH_DESC, CGH_LONG_DESC), DECODE( ? ,'N',CGH_BL_DESC,CGH_BL_LONG_DESC)"
				+ " FROM   PM_IL_CVR_GROUP_HDR WHERE  CGH_GROUP_CODE = ? ";
		String M_NAME = null;
		String M_BL_NAME = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection;
		try {
			connection = CommonUtils.getConnection();

			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { P_NAME_FLAG, P_NAME_FLAG, P_CVR_GRP_CODE });
			if (resultSet.next()) {
				M_NAME = resultSet.getString(1);
				M_BL_NAME = resultSet.getString(2);
			} else {
				if ("W".equals(P_ERR_FLAG) || "E".equals(P_ERR_FLAG)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "92000"));
				}
			}
			if ("1".equals(CommonUtils.SUBSTR(CommonUtils
					.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"), 5, 1))
					|| "ENG".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_LANG_CODE"))) {
				P_CVR_GRP_DESC = M_NAME;
			} else {
				P_CVR_GRP_DESC = M_BL_NAME;
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return P_CVR_GRP_DESC;
	}

	public static void L_VAL_GRP_UNIQUE(String PACG_PROD_CODE,
			String PACG_CVR_GROUP_CODE, String ROWID) throws Exception {
		String CURSOR_C1 = "SELECT 'X' FROM   PM_IL_PROD_APPL_CVR_GRP WHERE  PACG_PROD_CODE = ? AND PACG_CVR_GROUP_CODE =  ? ";
		String CURSOR_C2 = "SELECT 'X' FROM PM_IL_PROD_APPL_CVR_GRP WHERE PACG_PROD_CODE = ? AND PACG_CVR_GROUP_CODE = ? AND ROWID <> ? ";
		String M_DUMMY = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection;
		try {
			connection = CommonUtils.getConnection();

			if (ROWID == null) {
				resultSet = handler.executeSelectStatement(CURSOR_C1,
						connection, new Object[] { PACG_PROD_CODE,
								PACG_CVR_GROUP_CODE });
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91999"));
				}
			} else {
				resultSet1 = handler.executeSelectStatement(CURSOR_C2,
						connection, new Object[] { PACG_PROD_CODE,
								PACG_CVR_GROUP_CODE, ROWID });
				if (resultSet1.next()) {
					M_DUMMY = resultSet1.getString(1);
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91999"));
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 *
	 * @param P_PIPD_SRNO-IN
	 * @param P_PROD_CODE-IN
	 * @param P_ROWID-IN
	 *
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> L_INVEST_SRNO_UNIQUE(Object P_PIPD_SRNO,
			Object P_PROD_CODE, Object P_ROWID) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.INTEGER,
					OracleParameter.DIRECTION_TYPE.IN, P_PIPD_SRNO);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_PROD_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_ROWID);
			parameterList.add(param3);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"PILM035_APAC.L_INVEST_SRNO_UNIQUE");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
}
