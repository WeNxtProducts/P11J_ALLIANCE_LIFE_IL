package com.iii.pel.forms.PILT010;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class PILT010_PROCEDURE {

	public void P9ILPK_RI_ALLOC_P_APPRV_FAC(Connection connection,
			String P_POL_SYS_ID, String P_PC_SYS_ID, String P_PC_SCHD_DATE,
			String P_FAC_YN, String P_POL_END_FLAG) throws ValidatorException {
		PV_IL_POL_RI_DETL_ACTION pvRiDetlAction = PILT010_ACTION_INSTANCE
				.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				P_POL_SYS_ID);
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
				P_PC_SYS_ID);
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
				P_PC_SCHD_DATE);
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
				P_FAC_YN);
		OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",
				P_POL_END_FLAG);
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		OracleProcedureHandler handler = new OracleProcedureHandler();
		try {
			handler.execute(parameterList, connection,
					"P9ILPK_RI_ALLOC.P_APPRV_FAC");
		} catch (Exception se) {
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(connection,
					FacesContext.getCurrentInstance(), "M_BUT_SYSTEM_CALC",
					pvRiDetlAction.getErrorMap(), pvRiDetlAction
							.getWarningMap());
			String errorString = pvRiDetlAction.getErrorMap().get("current");
			if (errorString != null) {
				throw new ValidatorException(new FacesMessage(errorString));
			} else {
				throw new ValidatorException(new FacesMessage(se.getMessage()));
			}
		}
	}

	public void L_CHECK_RI_PREM_ALLOC() throws ValidatorException {
		Connection connection = PILT010_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = new CRUDHandler();
		double M_SUM_CEDED = -1;
		double M_SUM_ALLOCATED = -1;
		ResultSet vembu_C1 = null;
		PT_IL_RI_DETL_ACTION ptRiDetlAction = PILT010_ACTION_INSTANCE
				.getPT_IL_RI_DETL_ACTION_INSTANCE();
		Integer RD_SYS_ID = ptRiDetlAction.getPT_IL_RI_DETL_BEAN()
				.getRD_SYS_ID();
		Long RD_POL_SYS_ID = ptRiDetlAction.getPT_IL_RI_DETL_BEAN()
				.getRD_POL_SYS_ID();
		Integer RD_END_NO_IDX = ptRiDetlAction.getPT_IL_RI_DETL_BEAN()
				.getRD_END_NO_IDX();
		String RD_COVER_CODE = ptRiDetlAction.getPT_IL_RI_DETL_BEAN()
				.getRD_COVER_CODE();
		String RD_TREATY_CODE = ptRiDetlAction.getPT_IL_RI_DETL_BEAN()
				.getRD_TREATY_CODE();
		String RD_ASSR_CODE = ptRiDetlAction.getPT_IL_RI_DETL_BEAN()
				.getRD_ASSR_CODE();
		try {
			String sql_C1 = "SELECT   'X',  NVL(RD_FC_SUM_CEDED, 0),    SUM(RPA_RI_FC_SA) + SUM(RPA_RET_FC_SA) "
					+ "FROM  PT_IL_RI_PREM_ALLOC,   PT_IL_RI_DETL  "
					+ "WHERE  RD_SYS_ID  = RPA_RD_SYS_ID  "
					+ "AND RD_SYS_ID  = ?  "
					+ "AND RPA_POL_SYS_ID  = ?  "
					+ "AND RPA_END_NO_IDX  = ? "
					+ "AND RPA_COVER_CODE  = ? "
					+ "AND RPA_TREATY_CODE  = ? "
					+ "AND NVL(RPA_RI_CLOSE_FLAG, 'N')  = ?  "
					+ "AND NVL(RPA_FRZ_FLAG, 'N')  <> ?  "
					+ "AND NVL(RD_ASSR_CODE, 'XXXXXXXXXXXX')  = NVL(?, 'XXXXXXXXXXXX') "
					+ "GROUP BY  RD_FC_SUM_CEDED  ";
			vembu_C1 = handler.executeSelectStatement(sql_C1, connection,
					new Object[] { RD_SYS_ID, RD_POL_SYS_ID, RD_END_NO_IDX,
							RD_COVER_CODE, RD_TREATY_CODE, "N", "U",
							RD_ASSR_CODE });
			String M_TEMP = null;
			if (vembu_C1.next()) {
				M_TEMP = vembu_C1.getString(1);
				M_SUM_CEDED = vembu_C1.getDouble(2);
				M_SUM_ALLOCATED = vembu_C1.getDouble(3);
			}
			if (M_TEMP != null) {
				if (M_SUM_CEDED > 0) {
					if (M_SUM_CEDED != M_SUM_ALLOCATED) {
						throw new ValidatorException(Messages.getMessage(
								PELConstants.pelErrorMessagePath, "71234",
								new Object[] { RD_COVER_CODE, M_SUM_CEDED,
										M_SUM_ALLOCATED }));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(vembu_C1);
			} catch (Exception e) {
			}
		}
	}

	public void L_CHECK_POL_SA_PREM() throws ValidatorException {
		Connection connection = PILT010_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = new CRUDHandler();
		PT_IL_RI_DETL_ACTION ptRiDetlAction = PILT010_ACTION_INSTANCE
				.getPT_IL_RI_DETL_ACTION_INSTANCE();
		PV_IL_POL_RI_DETL_ACTION pvPolRiDetlAction = PILT010_ACTION_INSTANCE
				.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		Double RD_FC_POL_SA = ptRiDetlAction.getPT_IL_RI_DETL_BEAN()
				.getRD_FC_POL_SA();
		Double RD_FC_POL_PREM = ptRiDetlAction.getPT_IL_RI_DETL_BEAN()
				.getRD_FC_POL_PREM();
		Integer RD_SYS_ID = ptRiDetlAction.getPT_IL_RI_DETL_BEAN()
				.getRD_SYS_ID();
		Long RD_POL_SYS_ID = pvPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN()
				.getRD_POL_SYS_ID();
		Integer RD_END_NO_IDX = pvPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN()
				.getRD_END_NO_IDX();
		Double M_RPA_POL_SA = null;
		Double M_RPA_POL_PREM = null;
		String sql_C1 = "SELECT    SUM(NVL(RPA_RI_FC_POL_SA, 0)) + SUM(NVL(RPA_RET_FC_POL_SA, 0)),    "
				+ "SUM(NVL(RPA_RI_FC_POL_PREM, 0)) + SUM(NVL(RPA_RET_FC_POL_PREM, 0)) "
				+ "FROM  PT_IL_RI_PREM_ALLOC  "
				+ "WHERE  RPA_POL_SYS_ID  = ? "
				+ "AND RPA_END_NO_IDX  = ?  " + "AND RPA_RD_SYS_ID  = ? ";
		ResultSet vembu_C1 = null;
		try {
			vembu_C1 = handler.executeSelectStatement(sql_C1, connection,
					new Object[] { RD_POL_SYS_ID, RD_END_NO_IDX, RD_SYS_ID });
			if (vembu_C1.next()) {
				M_RPA_POL_SA = vembu_C1.getDouble(1);
				M_RPA_POL_PREM = vembu_C1.getDouble(2);
			}
			if (M_RPA_POL_SA != RD_FC_POL_SA) {
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath,
						"POLICY SUM ASSURED DOES NOT TALLY."));
			}
			if (M_RPA_POL_PREM != RD_FC_POL_PREM) {
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath,
						"POLICY PREMIUM DOES NOT TALLY"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(vembu_C1);
			} catch (Exception e) {
			}
		}
	}

	public void L_RI_APPRV() throws ValidatorException {
	}

	public void L_RI_INS_LOAD() throws ValidatorException {
	}

	public void L_CHK_DISC_LOAD_DUPLICATE() throws ValidatorException {
	}

	public void L_CHK_UNIQUE_DISC_SRNO() throws ValidatorException {
	}

	public void L_INS_MNTH_RI_STAT() throws ValidatorException {
	}

	public void L_INSERT_COMMISSION() throws ValidatorException {
	}

	public ArrayList<OracleParameter> P10ilpk_Ri_Close(String P_POL_SYS_ID,
			String P_POL_END_NO_IDX, String P_YEAR) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_POL_END_NO_IDX);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					P_YEAR);
			parameterList.add(param3);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P10ilpk_Ri_Close.P_RI_CLOSE");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

}
