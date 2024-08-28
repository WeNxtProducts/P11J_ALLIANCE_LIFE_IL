package com.iii.pel.forms.PILM007;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class PILM007_PROCS_HELPER {
	CRUDHandler handler = new CRUDHandler();

	public void L_CHECK_UNIQUE_CLM_LATE_FEE(
			PILM007_COMPOSITE_ACTION compositeAction) throws Exception {
		PM_IL_CLM_LATE_FEE pm_il_clm_late_fee_bean = compositeAction
				.getPM_IL_CLM_LATE_FEE_ACTION_BEAN()
				.getPM_IL_CLM_LATE_FEE_BEAN();
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();

		Connection con = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try {
			con = CommonUtils.getConnection();
			// if (("INSERT").equals(system_bean.getRECORD_STATUS())) {
			if (pm_il_clm_late_fee_bean.getROWID() == null) {
				String M_DUMMY = null;

				Object[] rsObj1 = new Object[11];
				rsObj1[0] = pm_il_clm_late_fee_bean.getCLF_NO_FM_DAYS();
				rsObj1[1] = pm_il_clm_late_fee_bean.getCLF_NO_TO_DAYS();
				rsObj1[2] = pm_il_clm_late_fee_bean.getCLF_NO_FM_DAYS();
				rsObj1[3] = pm_il_clm_late_fee_bean.getCLF_NO_TO_DAYS();
				rsObj1[4] = pm_il_clm_late_fee_bean.getCLF_EFF_FM_DT();
				rsObj1[5] = pm_il_clm_late_fee_bean.getCLF_EFF_TO_DT();
				rsObj1[6] = pm_il_clm_late_fee_bean.getCLF_EFF_FM_DT();
				rsObj1[7] = pm_il_clm_late_fee_bean.getCLF_EFF_TO_DT();
				rsObj1[8] = pm_il_clm_repay_bean.getCR_COVER_CODE();
				rsObj1[9] = pm_il_clm_repay_bean.getCR_LOSS_TYPE();
				rsObj1[10] = pm_il_clm_repay_bean.getCR_DISABLE_TYPE();

				rs1 = handler
						.executeSelectStatement(
								" SELECT ROWID FROM PM_IL_CLM_LATE_FEE WHERE (CLF_NO_FM_DAYS  BETWEEN  ?  AND  ?  OR       CLF_NO_TO_DAYS  BETWEEN  ?  AND  ? ) AND     (CLF_EFF_FM_DT   BETWEEN  ?   AND  ?  OR       CLF_EFF_TO_DT   BETWEEN  ?   AND  ? ) AND      CLF_COVER_CODE     =  ?  AND      CLF_LOSS_TYPE      =  ?  AND      CLF_DISABLE_TYPE   =  ? ",
								con, rsObj1);
				while (rs1.next()) {
					M_DUMMY = rs1.getString(1);
					if (CommonUtils.isDuplicate(pm_il_clm_late_fee_bean
							.getROWID(), M_DUMMY))
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91049"));
				}

			} else {
				String M_DUMMY = null;

				Object[] rsObj2 = new Object[12];
				rsObj2[0] = pm_il_clm_late_fee_bean.getCLF_NO_FM_DAYS();
				rsObj2[1] = pm_il_clm_late_fee_bean.getCLF_NO_TO_DAYS();
				rsObj2[2] = pm_il_clm_late_fee_bean.getCLF_NO_FM_DAYS();
				rsObj2[3] = pm_il_clm_late_fee_bean.getCLF_NO_TO_DAYS();
				rsObj2[4] = pm_il_clm_late_fee_bean.getCLF_EFF_FM_DT();
				rsObj2[5] = pm_il_clm_late_fee_bean.getCLF_EFF_TO_DT();
				rsObj2[6] = pm_il_clm_late_fee_bean.getCLF_EFF_FM_DT();
				rsObj2[7] = pm_il_clm_late_fee_bean.getCLF_EFF_TO_DT();
				rsObj2[8] = pm_il_clm_repay_bean.getCR_COVER_CODE();
				rsObj2[9] = pm_il_clm_repay_bean.getCR_LOSS_TYPE();
				rsObj2[10] = pm_il_clm_repay_bean.getCR_DISABLE_TYPE();
				rsObj2[11] = pm_il_clm_late_fee_bean.getROWID();

				rs2 = handler
						.executeSelectStatement(
								" SELECT ROWID FROM    PM_IL_CLM_LATE_FEE WHERE   (CLF_NO_FM_DAYS BETWEEN  ?  AND  ?  OR       CLF_NO_TO_DAYS BETWEEN  ?  AND  ? ) AND     (CLF_EFF_FM_DT   BETWEEN  ?   AND  ?  OR       CLF_EFF_TO_DT   BETWEEN  ?   AND  ? ) AND      CLF_COVER_CODE     =  ?  AND      CLF_LOSS_TYPE      =  ?  AND      CLF_DISABLE_TYPE   =  ?  AND      ROWID <>  ? ",
								con, rsObj2);
				while (rs2.next()) {
					M_DUMMY = rs2.getString(1);
					if (CommonUtils.isDuplicate(pm_il_clm_late_fee_bean
							.getROWID(), M_DUMMY))
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91049"));
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			CommonUtils.closeCursor(rs1);
			CommonUtils.closeCursor(rs2);
		}
	}

	public void L_CHK_UNIQUE_LIEN(PILM007_COMPOSITE_ACTION compositeAction) {
		// TODO Auto-generated method stub

	}

	public String P_VAL_CODES(Connection connection, String CODE_TYPE,
			String CODE, String desc, String flag1, String flag2, String flag3)throws Exception {
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		String output = null;
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				CODE_TYPE);
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
				CODE);
		OracleParameter param3 = new OracleParameter("inout1", "STRING",
				"IN OUT", desc);
		OracleParameter param4 = new OracleParameter("in3", "STRING", "IN",
				flag1);
		OracleParameter param5 = new OracleParameter("in4", "STRING", "IN",
				flag2);
		OracleParameter param6 = new OracleParameter("in5", "STRING", "IN",
				flag3);
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		parameterList.add(param6);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		try {
			outputList = procHandler.execute(parameterList, connection,
					"P_VAL_CODES");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while (iterator.hasNext()) {
				OracleParameter oracleParameter = iterator.next();
				System.out
						.println("Output value:" + oracleParameter.getValue());
				output = oracleParameter.getValue();
				desc = output;
			}
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
            throw new ProcedureException(e.getMessage());
		}
		return output;
	}

	public void L_DUP_CLM_SETUP(PM_IL_CLM_REPAY pm_il_clm_repay_bean)
			throws Exception {
		String C1 = "SELECT ROWID FROM   PM_IL_CLM_REPAY WHERE  CR_COVER_CODE 	 = ? "
				+ "AND    CR_LOSS_TYPE  	 = ? "
				+ "AND    CR_DISABLE_TYPE  = ? "
				+ "AND    (((NVL(?,TO_DATE('01/01/1900','DD/MM/RRRR')) BETWEEN NVL(CR_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) AND NVL(CR_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR'))) "
				+ "OR       (NVL(?,TO_DATE('31/12/2999','DD/MM/RRRR')) BETWEEN NVL(CR_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) AND NVL(CR_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')))) "
				+ "OR ((NVL(CR_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) BETWEEN NVL(?,TO_DATE('01/01/1900','DD/MM/RRRR')) AND NVL(?,TO_DATE('31/12/2999','DD/MM/RRRR'))) "
				+ "OR       (NVL(CR_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')) BETWEEN NVL(?,TO_DATE('01/01/1900','DD/MM/RRRR')) AND NVL(?,TO_DATE('31/12/2999','DD/MM/RRRR')))))";

		String C2 = " SELECT ROWID FROM   PM_IL_CLM_REPAY WHERE  CR_COVER_CODE 	 = ? AND    CR_LOSS_TYPE  	 = ? "
				+ "AND    CR_DISABLE_TYPE  = ? AND    (((NVL(?,TO_DATE('01/01/1900','DD/MM/RRRR')) BETWEEN NVL(CR_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) AND NVL(CR_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')))"
				+ "  	 OR       (NVL(?,TO_DATE('31/12/2999','DD/MM/RRRR')) BETWEEN NVL(CR_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) AND NVL(CR_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR'))))"
				+ "	   	 OR   ((NVL(CR_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) BETWEEN NVL(?,TO_DATE('01/01/1900','DD/MM/RRRR')) AND NVL(?,TO_DATE('31/12/2999','DD/MM/RRRR')))"
				+ " 	 OR       (NVL(CR_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')) BETWEEN NVL(?,TO_DATE('01/01/1900','DD/MM/RRRR')) AND NVL(?,TO_DATE('31/12/2999','DD/MM/RRRR')))))"
				+ " 	 AND    ROWID  != ? ";

		ResultSet rs1 = null;
		ResultSet rs2 = null;
		Connection con = null;
		try {
			if (pm_il_clm_repay_bean.getROWID() == null) {
				rs1 = handler.executeSelectStatement(C1, con, new Object[] {
						pm_il_clm_repay_bean.getCR_COVER_CODE(),
						pm_il_clm_repay_bean.getCR_LOSS_TYPE(),
						pm_il_clm_repay_bean.getCR_DISABLE_TYPE(),
						pm_il_clm_repay_bean.getCR_EFF_FM_DT(),
						pm_il_clm_repay_bean.getCR_EFF_TO_DT(),
						pm_il_clm_repay_bean.getCR_EFF_FM_DT(),
						pm_il_clm_repay_bean.getCR_EFF_TO_DT(),
						pm_il_clm_repay_bean.getCR_EFF_FM_DT(),
						pm_il_clm_repay_bean.getCR_EFF_TO_DT() });
				while (rs1.next()) {
					if (CommonUtils.isDuplicate(
							pm_il_clm_repay_bean.getROWID(), rs1.getString(1)))
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "71015"));
				}
			} else {// :SYSTEM.RECORD_STATUS = 'CHANGED' THEN
				rs2 = handler.executeSelectStatement(C2, con, new Object[] {
						pm_il_clm_repay_bean.getCR_COVER_CODE(),
						pm_il_clm_repay_bean.getCR_LOSS_TYPE(),
						pm_il_clm_repay_bean.getCR_DISABLE_TYPE(),
						pm_il_clm_repay_bean.getCR_EFF_FM_DT(),
						pm_il_clm_repay_bean.getCR_EFF_TO_DT(),
						pm_il_clm_repay_bean.getCR_EFF_FM_DT(),
						pm_il_clm_repay_bean.getCR_EFF_TO_DT(),
						pm_il_clm_repay_bean.getCR_EFF_FM_DT(),
						pm_il_clm_repay_bean.getCR_EFF_TO_DT(),
						pm_il_clm_repay_bean.getROWID() });
				while (rs2.next()) {
					if (CommonUtils.isDuplicate(
							pm_il_clm_repay_bean.getROWID(), rs2.getString(1)))
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "71015"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void L_UNIQUE_PAY_SETUP(PM_IL_CLM_REPAY_DTL pm_il_clm_repay_dtl_bean)
			throws Exception {
		String M_TEMP = null;
		String M_CHECK = null;

		String C1 = " SELECT ROWID FROM PM_IL_CLM_REPAY_DTL "
				+ "WHERE CRD_CR_COVER_CODE = ? "
				+ "AND   CRD_CR_LOSS_TYPE = ? "
				+ "AND   CRD_CR_DISABLE_TYPE = ? "
				+ "AND   CRD_COVER_CODE  =? "
				+ "AND   CRD_LOSS_TYPE  =? "
				+ "AND   CRD_DISABLE_TYPE = ?";

		String C2 = " SELECT 'X' FROM PM_IL_CLM_REPAY_DTL "
				+ "WHERE CRD_CR_COVER_CODE =? "
				+ "AND   CRD_CR_LOSS_TYPE = ? "
				+ "AND   CRD_CR_DISABLE_TYPE =? "
				+ "AND   CRD_COVER_CODE  =? "
				+ "AND   CRD_LOSS_TYPE  =? "
				+ "AND   CRD_DISABLE_TYPE = ? "
				+ "AND   ROWID <> ?";

		ResultSet rs1 = null;
		ResultSet rs2 = null;
		Connection con = null;
		try {
			con = CommonUtils.getConnection();

			if (pm_il_clm_repay_dtl_bean.getROWID() == null) {
				rs1 = handler.executeSelectStatement(C1, con, new Object[] {
						pm_il_clm_repay_dtl_bean.getCRD_CR_COVER_CODE(),
						pm_il_clm_repay_dtl_bean.getCRD_CR_LOSS_TYPE(),
						pm_il_clm_repay_dtl_bean.getCRD_CR_DISABLE_TYPE(),
						pm_il_clm_repay_dtl_bean.getCRD_COVER_CODE(),
						pm_il_clm_repay_dtl_bean.getCRD_LOSS_TYPE(),
						pm_il_clm_repay_dtl_bean.getCRD_DISABLE_TYPE() });
				while (rs1.next()) {
					M_TEMP = rs1.getString(1);
					if (CommonUtils.isDuplicate(pm_il_clm_repay_dtl_bean
							.getROWID(), M_TEMP))
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "71015"));
				}
			} else {

				rs2 = handler.executeSelectStatement(C2, con, new Object[] {
						pm_il_clm_repay_dtl_bean.getCRD_CR_COVER_CODE(),
						pm_il_clm_repay_dtl_bean.getCRD_CR_LOSS_TYPE(),
						pm_il_clm_repay_dtl_bean.getCRD_CR_DISABLE_TYPE(),
						pm_il_clm_repay_dtl_bean.getCRD_COVER_CODE(),
						pm_il_clm_repay_dtl_bean.getCRD_LOSS_TYPE(),
						pm_il_clm_repay_dtl_bean.getCRD_DISABLE_TYPE(),
						pm_il_clm_repay_dtl_bean.getROWID() });
				while (rs2.next()) {
					M_CHECK = rs2.getString(1);
					if (CommonUtils.isDuplicate(pm_il_clm_repay_dtl_bean
							.getROWID(), M_CHECK))
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "71015"));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void L_CHK_UNIQUE_WAIT_PERIOD(
			PM_IL_CLM_WAIT_PERIOD pm_il_clm_wait_period_bean,
			PM_IL_CLM_REPAY pm_il_clm_repay_bean) throws Exception {
		String M_DUMMY = null;
		String C1 = "SELECT 'X' FROM    PM_IL_CLM_WAIT_PERIOD"
				+ " WHERE   (CWP_FM_DAYS  BETWEEN ? AND ?"
				+ "  OR       CWP_TO_DAYS  BETWEEN ? AND ?)"
				+ "   AND      CWP_COVER_CODE     = ?"
				+ "  AND      CWP_LOSS_CODE      = ?"
				+ " AND      CWP_DISABLE_TYPE   = ?";

		String C2 = "SELECT 'X' FROM    PM_IL_CLM_WAIT_PERIOD "
				+ "WHERE   (CWP_FM_DAYS  BETWEEN ? AND ?"
				+ "OR       CWP_TO_DAYS  BETWEEN ? AND ?) "
				+ "AND      CWP_COVER_CODE     = ? "
				+ "AND      CWP_LOSS_CODE      = ? "
				+ "AND      CWP_DISABLE_TYPE   = ? AND ROWID <> ?";

		Connection con = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try {
			con = CommonUtils.getConnection();
			// IF :SYSTEM.RECORD_STATUS = 'INSERT' THEN
			if (pm_il_clm_repay_bean.getROWID() == null) {
				rs1 = handler.executeSelectStatement(C1, con, new Object[] {
						pm_il_clm_wait_period_bean.getCWP_FM_DAYS(),
						pm_il_clm_wait_period_bean.getCWP_TO_DAYS(),
						pm_il_clm_wait_period_bean.getCWP_FM_DAYS(),
						pm_il_clm_wait_period_bean.getCWP_TO_DAYS(),
						pm_il_clm_repay_bean.getCR_COVER_CODE(),
						pm_il_clm_repay_bean.getCR_LOSS_TYPE(),
						pm_il_clm_repay_bean.getCR_DISABLE_TYPE() });
				M_DUMMY = rs1.getString(1);
				if (CommonUtils.isDuplicate(pm_il_clm_repay_bean.getROWID(),
						M_DUMMY))
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91049"));
			} else {
				rs2 = handler.executeSelectStatement(C2, con, new Object[] {
						pm_il_clm_wait_period_bean.getCWP_FM_DAYS(),
						pm_il_clm_wait_period_bean.getCWP_TO_DAYS(),
						pm_il_clm_wait_period_bean.getCWP_FM_DAYS(),
						pm_il_clm_wait_period_bean.getCWP_TO_DAYS(),
						pm_il_clm_repay_bean.getCR_COVER_CODE(),
						pm_il_clm_repay_bean.getCR_LOSS_TYPE(),
						pm_il_clm_repay_bean.getCR_DISABLE_TYPE(),
						pm_il_clm_wait_period_bean.getROWID() });
				while(rs2.next()){
				M_DUMMY = rs2.getString(1);
				if (CommonUtils.isDuplicate(pm_il_clm_repay_bean.getROWID(),
						M_DUMMY))
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91049"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally{
			CommonUtils.closeCursor(rs1);
			CommonUtils.closeCursor(rs2);
		}

	}
}
