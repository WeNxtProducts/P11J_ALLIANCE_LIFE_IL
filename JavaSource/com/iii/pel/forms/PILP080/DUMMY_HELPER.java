package com.iii.pel.forms.PILP080;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_HELPER extends CommonAction {
	public void M_BUT_GENERATE(PILP080_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String C1 = "SELECT PARA_VALUE FROM   PCOM_APP_PARAMETER WHERE  PARA_CODE= ? AND  PARA_SUB_CODE  = ?";
		PT_IL_PV_MED_HDR PT_IL_PV_MED_HDR_BEAN = compositeAction
				.getPT_IL_PV_MED_HDR_ACTION_BEAN().getPT_IL_PV_MED_HDR_BEAN();
		String M_PARA_VALUE = null;
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<String>();
		try {
			con = CommonUtils.getConnection();
			if (PT_IL_PV_MED_HDR_BEAN.getPMH_VOUCH_NO() == null
					|| (PT_IL_PV_MED_HDR_BEAN.getPMH_VOUCH_NO()).isEmpty()) {
				rs = handler.executeSelectStatement(C1, con, new Object[] {
						"IL_MED_GN_NO", "IL_MED_GN_NO" });
				while (rs.next()) {
					M_PARA_VALUE = rs.getString(1);

				}
				list = P_GEN_AUTO_NO(M_PARA_VALUE, "N", CommonUtils
						.getProcedureValue(PT_IL_PV_MED_HDR_BEAN
								.getPMH_VOUCH_NO()));
				if (list != null && list.size() > 0) {
					PT_IL_PV_MED_HDR_BEAN.setPMH_VOUCH_NO(list.get(0));
				}
			} else {
				throw new Exception("Voucher No. already generated");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(rs);
		}

	}

	public ArrayList<String> P_GEN_AUTO_NO(String P_CCLAS_CODE,
			String P_DUMMY_YN, String P_VOUCH_NO) throws SQLException,
			Exception {
		Connection connection = null;
		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
				P_CCLAS_CODE);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				P_DUMMY_YN);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("OUT3", "STRING", "OUT",
				P_VOUCH_NO);
		parameterList.add(param3);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
				"P9ILPK_MEDICAL_FEES.P_GEN_AUTO_NO");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}

	public void M_BUT_REP(PILP080_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PT_IL_PV_MED_HDR PT_IL_PV_MED_HDR_BEAN = compositeAction
				.getPT_IL_PV_MED_HDR_ACTION_BEAN().getPT_IL_PV_MED_HDR_BEAN();
		String C1 = "SELECT PARA_VALUE  FROM   PCOM_APP_PARAMETER WHERE  PARA_CODE  = ?";
		String M_REPORT_ID = null;
		int M_REP_KEY_NO;
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;

		try {
			rs = handler.executeSelectStatement(C1, con,
					new Object[] { "IL_MED_REP" });
			while (rs.next()) {
				M_REPORT_ID = rs.getString(1);
			}
			String c2 = "INSERT INTO IP_REP_INFO(REP_KEY_NO,REP_ID, REP_VALUE_1,REP_VALUE_58,REP_VALUE_59,REP_VALUE_60,REP_VALUE_61,REP_CR_UID,REP_CR_DT)"
					+ " VALUES(?,?,?,?,?,?,?,?,?) ";

			// CREATE_REP_KEY_NO(M_REP_KEY_NO);
			handler.executeInsertStatement(c2, con, new Object[] {
					"M_REP_KEY_NO", "M_REPORT_ID",
					PT_IL_PV_MED_HDR_BEAN.getPMH_SYS_ID(),
					"GLOBAL.M_DIVN_CODE", "GLOBAL.M_DEPT_CODE",
					"GLOBAL.M_COMP_CODE", "GLOBAL.M_LANG_CODE",
					"GLOBAL.M_USER_ID", new CommonUtils().getCurrentDate() });

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(rs);
		}

	}

	public void M_BUT_APPROVE(PILP080_COMPOSITE_ACTION compositeAction)
			throws Exception {

		ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
		String M_ERR_YN = null;

		try {
			PT_IL_PV_MED_HDR PT_IL_PV_MED_HDR_BEAN = compositeAction
					.getPT_IL_PV_MED_HDR_ACTION_BEAN()
					.getPT_IL_PV_MED_HDR_BEAN();
			if (PT_IL_PV_MED_HDR_BEAN.getPMH_VOUCH_NO() == null) {
				throw new Exception("Voucher NO should be generated");
			}

			list = MED_FEE_APPR(PT_IL_PV_MED_HDR_BEAN.getPMH_CLINIC_CODE(),
					PT_IL_PV_MED_HDR_BEAN.getPMH_SYS_ID(),
					PT_IL_PV_MED_HDR_BEAN.getPMH_PROCESS_DT(), M_ERR_YN);

			M_ERR_YN = (String) list.get(0).getValueObject();
			if ((CommonUtils.nvl(M_ERR_YN, "N")).equalsIgnoreCase("Y")) {
				compositeAction.getPT_IL_PV_MED_HDR_ACTION_BEAN()
						.getWarningMap().put(
								PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								" Process Completed successfully");
				compositeAction.getPT_IL_PV_MED_HDR_ACTION_BEAN()
						.getWarningMap().put(
								PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
								" Process Completed successfully");
				compositeAction.getPT_IL_PV_MED_HDR_ACTION_BEAN().getHelper().executeQuery(compositeAction);
			} else {
				M_ERR_YN = "N";
				throw new Exception("Process not completed successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		// return outcome;
	}

	public ArrayList<OracleParameter> MED_FEE_APPR(Object P_CLINIC_CODE,
			 Object P_PMH_SYS_ID, Object P_PROCESS_DT,
			Object P_ERR_FLAG) throws ProcedureException,
			com.iii.premia.common.exception.ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_CLINIC_CODE);
			parameterList.add(param1);
			/*OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_PROD_CODE);
			parameterList.add(param2);*/
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_PMH_SYS_ID);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, P_PROCESS_DT);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("OUT1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.OUT, P_ERR_FLAG);
			parameterList.add(param4);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"MED_FEE_APPR");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

}
