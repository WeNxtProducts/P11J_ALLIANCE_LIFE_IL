package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.utils.LIFELIB;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PILT006_APAC_PROCEDURE {

	private static final Log log = LogFactory
			.getLog(PILT006_APAC_PROCEDURE.class);

	/**
	 * 
	 * @param CLAIM_POL_NO
	 * @param connection
	 * @throws Exception
	 */
	public void L_CLAIM_VALID_POL_NO(String CLAIM_POL_NO,
			PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		CRUDHandler handler = new CRUDHandler();
		String sql_C1 = "SELECT POL_NO, POL_SYS_ID FROM   PT_IL_POLICY "
				+ "WHERE  POL_NO     = ? " + "AND POL_DS_TYPE  = 2 "
				+ "AND    POL_STATUS IN ('A','E','P','R')";
		String POL_NO = null;
		Long POL_SYS_ID = null;
		ResultSet rst = null;
		ResultSet rst2 = null;
		try {
			rst = handler.executeSelectStatement(sql_C1, CommonUtils
					.getConnection(), new Object[] { CLAIM_POL_NO });
			if (rst.next()) {
				POL_NO = rst.getString(1);
				POL_SYS_ID = rst.getLong(2);
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
						.getPT_IL_CLAIM_BEAN().setCLAIM_POL_SYS_ID(POL_SYS_ID);
				compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
						.setCLAIM_SYS_ID(POL_SYS_ID);
			} else {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71081",
						new Object[] { POL_NO }));
			}

			Double M_CALC_METHOD = compositeAction.getPT_IL_CLAIM_ACTION_BEAN()
					.getPT_IL_CLAIM_BEAN().getUI_M_CALC_METHOD();
			String sql_C2 = "SELECT 'X' FROM   PT_IL_CLAIM_COVER_DTLS A,PM_IL_CLM_REPAY B "
					+ "WHERE A.CCD_COVER_CODE= B.CR_COVER_CODE AND    A.CCD_LOSS_TYPE  = B.CR_LOSS_TYPE "
					+ "AND  A.CCD_DISAB_TYPE = B.CR_DISABLE_TYPE "
					+ "AND  NVL(CR_POLICY_VALID_YN,'N')   = 'N' "
					+ "AND    NVL(CR_APPLIED_ON,'X')!='W' AND    A.CCD_CLAIM_SYS_ID IN ("
					+ "SELECT CLAIM_SYS_ID FROM   PT_IL_CLAIM WHERE  CLAIM_POL_NO = ? "
					+ "AND    CLAIM_TYPE IN('A','D'))";
			String M_TEMP = null;
			if ((M_CALC_METHOD == null ? 0.0 : M_CALC_METHOD) == 1.0) {
				rst2 = handler.executeSelectStatement(sql_C2, CommonUtils
						.getConnection(), new Object[] { CLAIM_POL_NO });
				while (rst2.next()) {
					M_TEMP = rst2.getString(1);
				}
				if ((M_TEMP == null ? "Y" : M_TEMP).equals("X")) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71179",
							new Object[] { POL_NO, "Registered", "Death" }));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rst);
				CommonUtils.closeCursor(rst2);
			} catch (Exception e) {
			}
		}
	}

	/**
	 * 
	 * @param connection
	 * @throws Exception
	 * @throws ValidatorException
	 */
	public void L_CLAIM_ASSR_VALID(PT_IL_CLAIM PT_IL_CLAIM_BEAN,String currValue)
			throws Exception {
		String selectQuery = "SELECT POAD_ASSR_CODE,POAD_ASSURED_NAME  FROM PT_IL_POL_ASSURED_DTLS "
				+ "WHERE  POAD_POL_SYS_ID = ? " + "AND POAD_ASSR_CODE  = ?";
		// PT_IL_CLAIM_ACTION claimAction =
		// PILT006_APAC_ACTION_INSTANCE.getClaimActionInstance();
		Long CLAIM_POL_SYS_ID = PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID();
		String assrCode = PT_IL_CLAIM_BEAN.getCLAIM_ASSR_CODE();
		CRUDHandler handler = new CRUDHandler();
		String M_ASSR_CODE = null;
		String M_ASSR_NAME = null;
		ResultSet rst = null;
		try {
			rst = handler.executeSelectStatement(selectQuery, CommonUtils
					.getConnection(),
					new Object[] { CLAIM_POL_SYS_ID, currValue });
			if (rst.next()) {
				M_ASSR_CODE = rst.getString(1);
				M_ASSR_NAME = rst.getString(2);
				PT_IL_CLAIM_BEAN.setUI_M_CLAIM_ASS_NAME(M_ASSR_NAME);
				PT_IL_CLAIM_BEAN.setCLAIM_ASSR_CODE(M_ASSR_CODE);
			} else {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91121"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param connection
	 * @param CLAIM_NO
	 * @throws Exception
	 * @throws ValidatorException
	 */
	public void L_UNIQUE_CLAIM_NO(PT_IL_CLAIM claimBean) throws Exception {
		String sql_C1 = "SELECT  CLAIM_NO,ROWID FROM   PT_IL_CLAIM	WHERE  CLAIM_NO = ?";
		PT_IL_CLAIM_ACTION claimAction = PILT006_APAC_ACTION_INSTANCE
				.getClaimActionInstance();
		CRUDHandler handler = new CRUDHandler();
		String M_CLAIM_NO = null;
		ResultSet rst = null;
		try {
			rst = handler.executeSelectStatement(sql_C1, CommonUtils
					.getConnection(), new Object[] { claimBean.getCLAIM_NO() });
			if (rst.next()) {
				if (CommonUtils.isDuplicate(claimBean.getROWID(), rst
						.getString(2))) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71101"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
			}
		}
	}

	public void L_VALUE_FETCH(PILT006_APAC_COMPOSITE_ACTION compositeAction)
			throws ValidatorException {
		DUMMY dummyBean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		String sql_C1 = "SELECT POL_START_DT, POL_DIVN_CODE, POL_CLASS_CODE,"
				+ "POL_PLAN_CODE, POL_UW_YEAR, POL_FC_CURR_SA,POL_LC_CURR_SA, "
				+ "POL_CUST_CURR_CODE, POL_SA_CURR_CODE,POL_CUST_EXCH_RATE, "
				+ "POL_SA_EXCH_RATE, POL_EXPIRY_DT ,POL_STATUS, POL_NL_FM_DT, "
				+ "POL_NL_TO_DT,POL_CUST_CODE, POL_FC_SUM_ASSURED,POL_PROD_CODE,POL_CONT_CODE "
				+ "FROM   PT_IL_POLICY	WHERE  POL_SYS_ID    = ?";
		System.out.println(sql_C1);
		Long M_POL_SYS_ID = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID();
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst = null;
		try {
			rst = handler.executeSelectStatement(sql_C1, new CommonUtils()
					.getConnection(), new Object[] { M_POL_SYS_ID });
			while (rst.next()) {

				dummyBean.setM_POL_START_DT(rst.getDate("POL_START_DT"));
				dummyBean.setM_POL_DIVN_CODE(rst.getString("POL_DIVN_CODE"));
				dummyBean.setM_POL_CLASS_CODE(rst.getString("POL_CLASS_CODE"));
				dummyBean.setM_POL_PLAN_CODE(rst.getString("POL_PLAN_CODE"));
				dummyBean.setM_POL_UW_YEAR(rst.getInt("POL_UW_YEAR"));
				dummyBean.setM_POL_FC_SUM_ASSURED(rst
						.getDouble("POL_FC_CURR_SA"));
				dummyBean.setM_POL_LC_SUM_ASSURED(rst
						.getDouble("POL_LC_CURR_SA"));
				dummyBean.setM_POL_CUST_CURR_CODE_1(rst
						.getString("POL_CUST_CURR_CODE"));
				dummyBean.setM_POL_SA_CURR_CODE_1(rst
						.getString("POL_SA_CURR_CODE"));
				dummyBean.setM_POL_CUST_CURR_EXCH_RATE_1(rst
						.getDouble("POL_CUST_EXCH_RATE"));
				dummyBean.setM_POL_SA_CURR_EXCH_RATE_1(rst
						.getDouble("POL_SA_EXCH_RATE"));
				dummyBean.setM_POL_END_DT(rst.getDate("POL_EXPIRY_DT"));
				dummyBean.setM_POL_STATUS(rst.getString("POL_STATUS"));
				dummyBean.setM_POL_NL_FM_DT(rst.getDate("POL_NL_FM_DT"));
				dummyBean.setM_POL_NL_TO_DT(rst.getDate("POL_NL_TO_DT"));
				dummyBean.setCLAIM_CUST_CODE(rst.getString("POL_CUST_CODE"));
				dummyBean.setM_SUM_ASSURED(rst.getString("POL_FC_SUM_ASSURED"));
				dummyBean.setM_POL_PROD_CODE(rst.getString("POL_PROD_CODE"));
				/*Commentted by saranya for Hands on point num 11 on 10-02-2017*/
				/*if(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().
						getPT_IL_CLAIM_BEAN().getCLAIM_ASSR_CODE() == null){*/
				dummyBean.setCLAIM_ASSR_CODE(rst.getString("POL_CONT_CODE"));
			/*	}*/
				/*End*/

			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @throws ValidatorException
	 */
	public void L_ED_SETTL_BUT(PT_IL_CLAIM_ACTION claimAction)
			throws ValidatorException {
		Connection connection = PILT006_APAC_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = new CRUDHandler();

		PT_IL_CLAIM claimBean = claimAction.getPT_IL_CLAIM_BEAN();
		ResultSet rs_C1 = null;
		ResultSet rs_C7 = null;
		ResultSet rs_C2 = null;
		try {
			String sql_C1 = "SELECT CS_STATUS_CODE FROM  PT_IL_CLAIM_STATUS  WHERE  CS_SYS_ID  =  (   SELECT MAX(CS_SYS_ID)  FROM  PT_IL_CLAIM_STATUS   WHERE  CS_CLM_SYS_ID  = ?  ) ";
			String sql_C7 = "SELECT DISTINCT 'X' FROM  PT_IL_DOC_TODO_LIST_STATUS  WHERE  DTLS_CLM_SYS_ID  = ?  AND DTLS_GROUP_CODE  IN  (   SELECT DTG_GROUP_CODE  FROM  PM_IL_DOC_TODO_GROUP   WHERE  DTG_DS_CODE  = ?   AND DTG_GROUP_TYPE  = 'CHKLST'  )  AND DTLS_APPR_STS  IN ( 'NA'  , 'N'  )  AND NVL(DTLS_MANDATORY_YN, 'N')  = 'Y' ";
			String sql_C2 = "SELECT 'X' FROM  PT_IL_CLAIM_PAID  WHERE  CP_CLAIM_SYS_ID  = ? ";
			String M_DUMMY2 = null;
			String M_DUMMY1 = null;
			String M_DUMMY = null;
			rs_C1 = handler.executeSelectStatement(sql_C1, connection,
					new Object[] { claimBean.getCLAIM_SYS_ID() });
			if (rs_C1.next()) {
				M_DUMMY = rs_C1.getString(1);
			}

			if (claimBean.getCLAIM_SYS_ID() == null) {
				claimAction.getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(true);
			} else if (CommonUtils.nvl(M_DUMMY, "P").equals("CL05")) {
				claimAction.getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(false);
			} else {
				rs_C2 = handler.executeSelectStatement(sql_C2, connection,
						new Object[] { claimBean.getCLAIM_SYS_ID() });
				if (rs_C2.next()) {
					M_DUMMY2 = rs_C2.getString(1);
					claimAction.getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(true);
				} else {
					claimAction.getCOMP_UI_M_BUT_SETTLEMENT()
							.setDisabled(false);
				}
			}

			rs_C7 = handler.executeSelectStatement(sql_C7, connection,
					new Object[] { claimBean.getCLAIM_SYS_ID(),
							claimBean.getCLAIM_DS_CODE() });
			if (rs_C7.next()) {
				M_DUMMY1 = rs_C7.getString(1);
			} else {
				M_DUMMY1 = "Y";
			}

			if (M_DUMMY1.equals("X")) {
				claimAction.getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rs_C1);
				CommonUtils.closeCursor(rs_C2);
				CommonUtils.closeCursor(rs_C7);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 */
	public void IL_QUERY_DISABLE() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		PT_IL_CLAIM_ACTION claimAction = PILT006_APAC_ACTION_INSTANCE
				.getClaimActionInstance();
		PILT006_APAC_COMPOSITE_ACTION pilt006_apac_composite_action = PILT006_APAC_ACTION_INSTANCE
				.getCompositeActionInstance();

		String CALLING_FORM = CommonUtils.getGlobalVariable("CALLING_FORM");

		if ((CALLING_FORM != null && CALLING_FORM.startsWith("PILQ104_APAC"))) {
			claimAction.disableAllComponent(true);
			pilt006_apac_composite_action
					.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
					.disableAllComponent(true);
			pilt006_apac_composite_action.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN()
					.disableAllComponent(true);
			pilt006_apac_composite_action.getPT_IL_BONUS_ACTION_BEAN()
					.disableAllComponent(true);
			pilt006_apac_composite_action.getPT_IL_CLAIM_STATUS_ACTION_BEAN()
					.disableAllComponent(true);
			pilt006_apac_composite_action
					.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
					.disableAllComponent(true);
			pilt006_apac_composite_action
					.getPT_IL_CLAIM_ACC_FIR_DTLS_ACTION_BEAN()
					.disableAllComponent(true);

			claimAction.getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(true);
			claimAction.getCOMP_UI_M_BUT_CLOSE().setDisabled(true);
			claimAction.getCOMP_UI_M_BUT_STAUS_CHANGE().setDisabled(true);
			claimAction.getCOMP_UI_M_BUT_FRZ().setDisabled(true);
		}
	}

	/**
	 * 
	 * @param connection
	 * @throws ValidatorException
	 */
	public void L_CLAIM_VALID_POL_NO_1(DUMMY DUMMY_BEAN)
			throws ValidatorException {
		String M_POL_NO = null;
		PT_IL_CLAIM_ACTION claimAction = PILT006_APAC_ACTION_INSTANCE
				.getClaimActionInstance();
		String CLAIM_POL_NO = claimAction.getPT_IL_CLAIM_BEAN()
				.getCLAIM_POL_NO();
		String query = "SELECT POL_NO, POL_SYS_ID FROM PT_IL_POLICY "
				+ "WHERE POL_NO = ? AND POL_DS_TYPE = '2'";
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst = null;
		try {
			rst = handler.executeSelectStatement(query, CommonUtils
					.getConnection(), new Object[] { CLAIM_POL_NO });
			while (rst.next()) {
				M_POL_NO = rst.getString("POL_NO");
				claimAction.getPT_IL_CLAIM_BEAN().setCLAIM_POL_SYS_ID(
						rst.getLong("POL_SYS_ID"));
				DUMMY_BEAN.setM_POL_SYS_ID(rst.getLong("POL_SYS_ID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param connection
	 * @throws ValidatorException
	 */
	public void L_CLAIM_ASSR_DESC(PT_IL_CLAIM_ACTION PT_IL_CLAIM_ACTION_BEAN)
			throws ValidatorException {
		String selectQuery = "SELECT POAD_ASSURED_NAME "
				+ "FROM   PT_IL_POL_ASSURED_DTLS "
				+ "WHERE  POAD_POL_SYS_ID    = ? "
				+ "AND    POAD_ASSR_CODE     = ?";
		Long CLAIM_POL_SYS_ID = PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN()
				.getCLAIM_POL_SYS_ID();
		String assrCode = PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN()
				.getCLAIM_ASSR_CODE();
		CRUDHandler handler = new CRUDHandler();
		String POAD_ASSURED_NAME = null;
		ResultSet rst = null;
		try {
			rst = handler.executeSelectStatement(selectQuery, CommonUtils
					.getConnection(),
					new Object[] { CLAIM_POL_SYS_ID, assrCode });
			while (rst.next()) {
				POAD_ASSURED_NAME = rst.getString("POAD_ASSURED_NAME");
			}
			PT_IL_CLAIM_ACTION_BEAN.getCOMP_UI_M_CLAIM_ASS_NAME()
					.setSubmittedValue(POAD_ASSURED_NAME);
			PT_IL_CLAIM_ACTION_BEAN.getPT_IL_CLAIM_BEAN()
					.setUI_M_CLAIM_ASS_NAME(POAD_ASSURED_NAME);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<String> P_VAL_CURR(String currCode, String currName,
			String nameFlag, String errFlag, String custCode)
			throws ValidatorException {
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				currCode);
		OracleParameter param2 = new OracleParameter("inout1", "STRING",
				"IN OUT", currName);
		OracleParameter param3 = new OracleParameter("in2", "STRING", "IN",
				nameFlag);
		OracleParameter param4 = new OracleParameter("in3", "STRING", "IN",
				errFlag);
		OracleParameter param5 = new OracleParameter("in4", "STRING", "IN",
				custCode);
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		OracleProcedureHandler handler = new OracleProcedureHandler();
		ArrayList<OracleParameter> outputList = null;
		try {
			outputList = handler.execute(parameterList, CommonUtils
					.getConnection(), "P_VAL_CURR");
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		ArrayList<String> outputData = new ArrayList<String>();
		Iterator<OracleParameter> itr = outputList.iterator();
		while (itr.hasNext()) {
			outputData.add(itr.next().getValue());
		}
		return outputData;
	}

	/**
	 * 
	 * @param P_CURR_CODE-IN
	 * @param P_BUY_SELL-IN
	 * @param P_EFF_DT-IN
	 * @param P_EXHG_RATE-IN
	 *            OUT
	 * @param P_WAR_ERR-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> P_GET_EXCHANGE_RATE(Object P_CURR_CODE,
			Object P_BUY_SELL, Object P_EFF_DT, Object P_EXHG_RATE,
			Object P_WAR_ERR) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_CURR_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_BUY_SELL);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, P_EFF_DT);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN OUT4",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.IN_OUT, P_EXHG_RATE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_WAR_ERR);
			parameterList.add(param5);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P_GET_EXCHANGE_RATE");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 * 
	 * @param P_POL_SYS_ID-IN
	 * @param P_CLM_SYS_ID-IN
	 * @param P_CLAIM_TYPE-IN
	 * @param P_EFF_DT-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> P_INS_CLM_DOLIST(Object P_POL_SYS_ID,
			Object P_CLM_SYS_ID, Object P_CLAIM_TYPE, Object P_EFF_DT)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_CLM_SYS_ID);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_TYPE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, P_EFF_DT);
			parameterList.add(param4);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_CLAIM.P_INS_CLM_DOLIST");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	public static void L_INS_EST_RECORDS(PT_IL_CLAIM claimBean,
			PT_IL_CLAIM_ESTIMATE estimateBean, DUMMY dummyBean)
			throws Exception {
		/*Modified by saranya for Hands on point num 23 on 14/02/2014*/
		estimateBean.setUI_M_CE_FC_EST_TOT_DED(CommonUtils.nvl(estimateBean
				.getCE_FC_PREM_OS(), 0.0d)
				+ CommonUtils.nvl(estimateBean.getCE_FC_PREM_OS_INT(), 0.0d)
				+ CommonUtils.nvl(estimateBean.getCE_FC_LOAN_OS(), 0.0d)
				+ CommonUtils.nvl(estimateBean.getCE_FC_LOAN_INT(), 0.0d));
				/*+CommonUtils.nvl(estimateBean.getCE_FC_CLM_PROC_FEE(), 0.0d)+
				Added by gopi for Hands on feed back point num 16 in ZB on 15/02/2017
				CommonUtils.nvl(estimateBean.getCE_FC_FEE_PAID_HOSP(), 0.0d));
				end*/

		/*end*/
		estimateBean.setUI_M_CE_FC_EST_TOT_DED(LIFELIB.P_VAL_ROUND_AMT(
				claimBean.getCLAIM_CURR_CODE(), estimateBean
						.getUI_M_CE_FC_EST_TOT_DED(), "R"));
		estimateBean.setUI_M_CE_LC_EST_TOT_DED(estimateBean
				.getUI_M_CE_FC_EST_TOT_DED()
				* claimBean.getCLAIM_EXCH_RATE());
		estimateBean.setUI_M_CE_LC_EST_TOT_DED(LIFELIB.P_VAL_ROUND_AMT(
				dummyBean.getM_BASE_CURR(), estimateBean
						.getUI_M_CE_LC_EST_TOT_DED(), "R"));
		/*Modified by saranya for Hands on point num 23 on 14/02/2014*/
		estimateBean.setCE_FC_NET_EST_AMT(CommonUtils.nvl(estimateBean
				.getCE_FC_EST_AMT(), 0.0d)
				+ CommonUtils.nvl(estimateBean.getCE_FC_PREM_OS(), 0.0d)
				+ CommonUtils.nvl(estimateBean.getCE_FC_PREM_OS_INT(), 0.0d)
				+ CommonUtils.nvl(estimateBean.getCE_FC_LOAN_OS(), 0.0d)
				+ CommonUtils.nvl(estimateBean.getCE_FC_LOAN_INT(), 0.0d)
				+ CommonUtils.nvl(estimateBean.getCE_FC_ACC_PROFIT(), 0.0d));
			/*	+ CommonUtils.nvl(estimateBean.getCE_FC_CLM_PROC_FEE(), 0.0d)+
				Added by gopi for Hands on feed back point num 16 in ZB on 15/02/2017
				CommonUtils.nvl(estimateBean.getCE_FC_FEE_PAID_HOSP(), 0.0d));
				end*/
		/*end*/
		estimateBean.setUI_M_CE_LC_EST_TOT_DED(LIFELIB.P_VAL_ROUND_AMT(
				claimBean.getCLAIM_CURR_CODE(), estimateBean
						.getCE_FC_NET_EST_AMT(), "R"));
		estimateBean.setCE_LC_NET_EST_AMT(estimateBean.getCE_FC_NET_EST_AMT()
				* claimBean.getCLAIM_EXCH_RATE());
		estimateBean.setUI_M_CE_LC_EST_TOT_DED(LIFELIB.P_VAL_ROUND_AMT(
				dummyBean.getM_BASE_CURR(),
				estimateBean.getCE_LC_NET_EST_AMT(), "R"));
		if (estimateBean.getCE_SETL_START_DT() == null) {
			estimateBean.setCE_SETL_START_DT(claimBean.getCLAIM_LOSS_DT());
		}

		// TODO need to check if can be handled
		// HIDE_VIEW('PT_IL_CLAIM_ESTIMATE_1');
	}

	/**
	 * Program Unit P_VAL_FC_LC_TOLERANCE
	 * 
	 * @param CE_FC_EST_AMT
	 *            IN
	 * @param CE_LC_EST_AMT
	 *            IN
	 * @param CLAIM_EXCH_RATE
	 *            IN
	 * @param P_ERR_FLAG
	 *            IN
	 * @return M_CODE_DESC M_CODE_DESC
	 * @throws Exception
	 */
	public static String P_VAL_FC_LC_TOLERANCE(Double P_FC_VAL,
			Double P_LC_VAL, Double P_EXGE_RATE, String P_ERR_FLAG)
			throws Exception {
		String M_CODE_DESC = null;
		Double M_TOL_PERC = 0.0d;
		Double M_EXGE_RATE = null;
		ArrayList<String> outList = null;

		try {
			outList = DBProcedures.callP_VAL_SYSTEM("ROUNDOFTOL", "ROUNDOFTOL",
					M_CODE_DESC, "E", String.valueOf(M_TOL_PERC));
			if (!outList.isEmpty() && outList.size() > 0) {
				if (outList.get(0) != null) {
					M_CODE_DESC = outList.get(0);
				}
				if (outList.get(1) != null) {
					M_TOL_PERC = Double.parseDouble(outList.get(1));
				}
			}
			if (CommonUtils.nvl(P_FC_VAL, 0.0d) == 0.0d
					|| CommonUtils.nvl(P_LC_VAL, 0.0d) == 0.0d
					|| CommonUtils.nvl(P_EXGE_RATE, 0.0d) == 0.0d) {
				return null;
			}

			M_EXGE_RATE = CommonUtils.nvl(P_LC_VAL, 0.0d)
					/ CommonUtils.nvl(P_FC_VAL, 0.0d);
			if (((Math.abs(M_EXGE_RATE - P_EXGE_RATE) / M_EXGE_RATE) * 100) > M_TOL_PERC) {
				if ("E".equals(P_ERR_FLAG) || "W".equals(P_ERR_FLAG)) {
					if ("E".equals(P_ERR_FLAG)) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "1038"));
					}
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return M_CODE_DESC;
	}

	/**
	 * 
	 * @param connection
	 * @throws ValidatorException
	 */
	public void L_UNIQUE_SET_CODES(
			PT_IL_CLAIM_COVER_DTLS PT_IL_CLAIM_DTS_CLAIM_BEAN,
			PT_IL_CLAIM PT_IL_CLAIM_BEAN) throws Exception {
		String C1 = "SELECT 1 FROM PT_IL_CLAIM_COVER_DTLS "
				+ "WHERE  CCD_COVER_CODE = ? "
				+ "AND CCD_LOSS_TYPE  = ? AND CCD_DISAB_TYPE = ? AND CCD_CLAIM_SYS_ID = ? ";
		int M_TEMP = 0;

		CRUDHandler handler = new CRUDHandler();
		String M_ASSR_CODE = null;
		ResultSet C1_REC = null;
		Object[] obj = new Object[] {
				PT_IL_CLAIM_DTS_CLAIM_BEAN.getCCD_COVER_CODE(),
				PT_IL_CLAIM_DTS_CLAIM_BEAN.getCCD_LOSS_TYPE(),
				PT_IL_CLAIM_DTS_CLAIM_BEAN.getCCD_DISAB_TYPE(),
				PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID() };
		log.info("Inside L_UNIQUE_SET_CODES Values" + obj);
		try {

			/*
			 * IF M_BLK IS NULL THEN RETURN;
			 */

			C1_REC = handler.executeSelectStatement(C1, CommonUtils
					.getConnection(), obj);
			if (C1_REC.next()) {
				M_TEMP = C1_REC.getInt(1);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71018"));
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(C1_REC);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * L_CLM_EST_COVER VALID.
	 * @throws Exception 
	 */
	public void L_CLM_EST_COVER_VALID(
			PT_IL_CLAIM_COVER_DTLS PT_IL_CLAIM_COVER_DTLS_BEAN,
			DUMMY DUMMY_BEAN, PT_IL_CLAIM PT_IL_CLAIM_BEAN)
			throws ValidatorException 
	
	{
		String C1 = "SELECT COVER_TYPE FROM PM_IL_COVER WHERE COVER_CODE = ? ";
		String C2 = "SELECT 'X' FROM PT_IL_POLICY WHERE POL_SYS_ID = ? AND POL_PLAN_CODE = ? ";
		
		String C3 = "SELECT POAC_COVER_CODE, POAC_APPL_ALL FROM PT_IL_POL_ADDL_COVER " +
				"WHERE POAC_POL_SYS_ID = ? AND POAC_COVER_CODE = ? UNION SELECT POACH_O_COVER_CODE,POACH_O_APPL_ALL " +
          "FROM PH_IL_POL_ADDL_COVER WHERE POACH_O_COVER_CODE IN " +
          "(SELECT CC_COVER_CODE FROM PM_IL_CLAIM_COVER WHERE CC_CLAIM_TYPE = ? " +
          "AND ? BETWEEN " +
          "NVL(CC_EFF_FM_DT, TO_DATE('01/01/1900', 'DD/MM/YYYY')) AND " +
          "NVL(CC_EFF_TO_DT, TO_DATE('31/12/2999', 'DD/MM/YYYY'))) " +
          "AND POACH_POL_SYS_ID = ? " +
          " AND POACH_O_ASSR_CODE = ? " +
          "AND POACH_N_DEL_FLAG = 'Y' " +
          "AND EXISTS (SELECT 1 FROM PH_IL_POLICY " +
          "WHERE POLH_SYS_ID = POACH_POL_SYS_ID " +
          "AND  POLH_END_NO_IDX = POACH_END_NO_IDX " +
          "AND ? BETWEEN POLH_N_END_DT AND " +
          "POLH_N_END_EFF_FROM_DT) ";
		
		String C4 = "SELECT 'X' FROM PT_IL_POL_ADDL_COVER WHERE POAC_POL_SYS_ID = ? " +
				"AND POAC_COVER_CODE = ? AND POAC_ASSR_CODE = ? UNION SELECT 'X' " +
          "FROM PH_IL_POL_ADDL_COVER WHERE POACH_O_COVER_CODE IN " +
          "(SELECT CC_COVER_CODE FROM PM_IL_CLAIM_COVER WHERE CC_CLAIM_TYPE = ? " +
          "AND ? BETWEEN " +
          "NVL(CC_EFF_FM_DT, TO_DATE('01/01/1900', 'DD/MM/YYYY')) AND " +
          "NVL(CC_EFF_TO_DT, TO_DATE('31/12/2999', 'DD/MM/YYYY'))) " +
          "AND POACH_POL_SYS_ID = ? " +
          " AND POACH_O_ASSR_CODE = ? " +
          "AND POACH_N_DEL_FLAG = 'Y' " +
          "AND EXISTS (SELECT 1 FROM PH_IL_POLICY " +
          "WHERE POLH_SYS_ID = POACH_POL_SYS_ID " +
          "AND  POLH_END_NO_IDX = POACH_END_NO_IDX " +
          "AND ? BETWEEN POLH_N_END_DT AND " +
          "POLH_N_END_EFF_FROM_DT) " ;

		String M_DUMMY = "";
		String M_COVER_TYPE = null;
		String M_CR_COVER_CODE = null;
		String M_APPL_ALL = null;

		CRUDHandler handler = new CRUDHandler();
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		ResultSet C4_REC = null;

		/*Added by Janani on 08.09.2017 for ZBILQC-1723914*/
		
		String C5 = "SELECT PFMD_MEMB_TYPE FROM PT_IL_POL_FUNERAL_MEMB_DTLS,PT_IL_CLAIM WHERE PFMD_POL_SYS_ID=CLAIM_POL_SYS_ID AND PFMD_CUST_CODE= ?";
		ResultSet C5_REC = null;
		
		Object[] c5_obj = new Object[] { PT_IL_CLAIM_BEAN
				.getCLAIM_MEMB_CODE() };
		
		String MEMB_TYPE = null;
		
		/*End of ZBILQC-1723914*/
		
		Object[] c1_obj = new Object[] { PT_IL_CLAIM_COVER_DTLS_BEAN
				.getCCD_COVER_CODE() };

		Object[] c2_obj = new Object[] {
				PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID(),
				PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE() };

		Object[] c4_obj = new Object[] {
				PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID(),
				PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE(),
				PT_IL_CLAIM_BEAN.getCLAIM_ASSR_CODE(),
				PT_IL_CLAIM_BEAN.getCLAIM_TYPE(),
				PT_IL_CLAIM_BEAN.getCLAIM_LOSS_DT(),
				PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID(),
				PT_IL_CLAIM_BEAN.getCLAIM_ASSR_CODE(),
				PT_IL_CLAIM_BEAN.getCLAIM_LOSS_DT()};

		if (PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE() != null) {
			try {
				log.info("========c1_obj==========>" + c1_obj);
				C1_REC = handler.executeSelectStatement(C1, CommonUtils
						.getConnection(), c1_obj);
				if (C1_REC.next()) {
					M_COVER_TYPE = C1_REC.getString("COVER_TYPE");
					PT_IL_CLAIM_COVER_DTLS_BEAN.setCOVER_TYPE(M_COVER_TYPE);
				} else {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71006"));
				}

				if ("B".equalsIgnoreCase(M_COVER_TYPE)
						|| "S".equalsIgnoreCase(M_COVER_TYPE)) {
					log.info("========c2_obj==========>" + c2_obj);
					C2_REC = handler.executeSelectStatement(C2, CommonUtils
							.getConnection(), c2_obj);
					if (C2_REC.next()) {
						M_DUMMY = C2_REC.getString(1);
					} else {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath,
								"Not a valid Plan for this Policy!!"));
					}
				} else if ("A".equalsIgnoreCase(M_COVER_TYPE)) {
					
					String plan_type=null;
					String Query="select plan_type from pm_il_plan, pt_il_policy where PLAN_CODE = POL_PLAN_CODE AND POL_SYS_ID=?";
					ResultSet rs=new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection(), new Object[]{PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID()});
					while(rs.next())
					{
						plan_type=rs.getString("plan_type");
					}
					
					/*addded by raja on 14-08-2017 for discussed with gourav*/ 
					if(plan_type!=null && !(plan_type.equalsIgnoreCase("L") || plan_type.equalsIgnoreCase("H")))
					{
					log.info("========c2_obj==========>" + c2_obj);
					C3_REC = handler.executeSelectStatement(C3, CommonUtils
							.getConnection(), new Object[]{PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID(),
						PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE(),
						PT_IL_CLAIM_BEAN.getCLAIM_TYPE(),
						PT_IL_CLAIM_BEAN.getCLAIM_LOSS_DT(),
						PT_IL_CLAIM_BEAN.getCLAIM_POL_SYS_ID(),
						PT_IL_CLAIM_BEAN.getCLAIM_ASSR_CODE(),
						PT_IL_CLAIM_BEAN.getCLAIM_LOSS_DT()});
					if (C3_REC.next()) {
						M_CR_COVER_CODE = C3_REC.getString(1);
						M_APPL_ALL = C3_REC.getString(2);
						// compositeAction.getPT_IL_CLAIM
					} else {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "71006"));
					}
					}
					/*end*/
					log.info("========c4_obj==========>" + c4_obj);
					
					
					/*Added by Janani on 08.09.2017 for ZBILQC-1723914*/
					
					C5_REC = handler.executeSelectStatement(C5, CommonUtils
							.getConnection(), c5_obj);
					if (C5_REC.next()) {
						MEMB_TYPE = C5_REC.getString(1);
					}
					/*Added by kavitha on 20.03.2019 for KIC*/
					if(MEMB_TYPE!=null && !MEMB_TYPE.equalsIgnoreCase("MM"))
					{
					
					/*End of ZBILQC-1723914*/
					
					C4_REC = handler.executeSelectStatement(C4, CommonUtils
							.getConnection(), c4_obj);
					if (C4_REC.next()) {
						M_DUMMY = C4_REC.getString(1);
					} else {
						
						/*Modified by Janani on 07.09.2017 for ZB while saving cover code*/
						/*throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath,
								"Cover not valid for the Assured !!"));*/
						
						throw new Exception("Cover not valid for the Assured !!");
						
						/*End*/
						
					}
					
					
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				log.debug("Exception" + e.getMessage());
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			} finally {
				try {
					CommonUtils.closeCursor(C1_REC);
					CommonUtils.closeCursor(C2_REC);
					CommonUtils.closeCursor(C3_REC);
					CommonUtils.closeCursor(C4_REC);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}


	/**
	 * 
	 * @throws ValidatorException
	 */
	public void L_CLM_EST_LOSS_VALID(String M_BLK) throws ValidatorException {

		String M_CR_LOSS_TYPE = null;
		CRUDHandler handler = new CRUDHandler();
		String M_ASSR_CODE = null;
		ResultSet C1_REC = null;

		String C1 = "SELECT CR_LOSS_TYPE FROM PM_IL_CLM_REPAY "
				+ "WHERE  CR_LOSS_TYPE = ? " + "AND CR_COVER_CODE  = ? ";

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		PILT006_APAC_COMPOSITE_ACTION compositeAction = ((PILT006_APAC_COMPOSITE_ACTION) sessionMap
				.get("PILT006_APAC_COMPOSITE_ACTION"));

		PT_IL_CLAIM_COVER_DTLS pt_il_claim_cover_dtls = compositeAction
				.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
				.getPT_IL_CLAIM_COVER_DTLS_BEAN();
		if (M_BLK == null) {
			return;
		}
		Object[] obj = new Object[] {
				pt_il_claim_cover_dtls.getCCD_LOSS_TYPE(),
				pt_il_claim_cover_dtls.getCCD_COVER_CODE() };
		log.info("Inside L_CLM_EST_LOSS_VALID Values" + obj);
		try {
			C1_REC = handler.executeSelectStatement(C1, CommonUtils
					.getConnection(), obj);
			if (C1_REC.next()) {
				M_CR_LOSS_TYPE = C1_REC.getString(1);
			} else {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71102"));
			}

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(C1_REC);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @throws ValidatorException
	 */
	public void L_CLM_EST_DISABLE_VALID(String M_BLK) throws ValidatorException {

		String M_CR_LOSS_TYPE = null;
		CRUDHandler handler = new CRUDHandler();
		String M_ASSR_CODE = null;
		ResultSet C1_REC = null;

		String C1 = "SELECT CR_LOSS_TYPE FROM PM_IL_CLM_REPAY "
				+ "WHERE  CR_LOSS_TYPE = ? "
				+ "AND CR_COVER_CODE  = ? AND CR_DISABLE_TYPE = ? ";

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		PILT006_APAC_COMPOSITE_ACTION compositeAction = ((PILT006_APAC_COMPOSITE_ACTION) sessionMap
				.get("PILT006_APAC_COMPOSITE_ACTION"));

		PT_IL_CLAIM_COVER_DTLS pt_il_claim_cover_dtls = compositeAction
				.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
				.getPT_IL_CLAIM_COVER_DTLS_BEAN();
		if (M_BLK == null) {
			return;
		}
		Object[] obj = new Object[] {
				pt_il_claim_cover_dtls.getCCD_LOSS_TYPE(),
				pt_il_claim_cover_dtls.getCCD_COVER_CODE(),
				pt_il_claim_cover_dtls.getCCD_DISAB_TYPE() };
		log.info("Inside L_CLM_EST_DISABLE_VALID Values" + obj);
		try {
			C1_REC = handler.executeSelectStatement(C1, CommonUtils
					.getConnection(), obj);
			if (C1_REC.next()) {
				M_CR_LOSS_TYPE = C1_REC.getString(1);
			} else {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71102"));
			}

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(C1_REC);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 */
	public void L_CLOSE_FLAG_CHK() throws Exception {
		String M_DUMMY = null;
		String M_COVER_SA_CALC = null;

		String C1 = "SELECT DISTINCT 'X' FROM PT_IL_DOC_TODO_LIST_STATUS "
				+ "WHERE DTLS_CLM_SYS_ID =  ? AND DTLS_APPR_STS   = 'N' ";
		String C2 = "SELECT COVER_SA_CALC FROM   PM_IL_COVER "
				+ "WHERE  COVER_CODE = ? ";

		ResultSet C1_REC = null;
		ResultSet C2_REC = null;

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		PILT006_APAC_COMPOSITE_ACTION compositeAction = ((PILT006_APAC_COMPOSITE_ACTION) sessionMap
				.get("PILT006_APAC_COMPOSITE_ACTION"));

		PT_IL_CLAIM_COVER_DTLS coverBean = compositeAction
				.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
				.getPT_IL_CLAIM_COVER_DTLS_BEAN();

		if ("Y".equals(CommonUtils.nvl(coverBean.getCCD_CLOSE_FLAG(), "N"))) {
			compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
					.getCOMP_CCD_FRZ_FLAG().setDisabled(true);
			/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
			//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
			//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
			String ps_value=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
			if(ps_value!=null && ps_value.equalsIgnoreCase("2")){
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
			}else{
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
					}
			//end
			compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
					.getCOMP_CCD_COVER_CODE().setDisabled(true);
			compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
					.getCOMP_CCD_LOSS_TYPE().setDisabled(true);
			compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
					.getCOMP_CCD_DISAB_TYPE().setDisabled(true);
		} else if ("N".equals(CommonUtils.nvl(coverBean.getCCD_CLOSE_FLAG(),
				"N"))) {
			if ("Y".equals(CommonUtils.nvl(coverBean.getCCD_FRZ_FLAG(), "N"))) {
				/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
				//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
				//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
				String ps_value=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
				if(ps_value!=null && ps_value.equalsIgnoreCase("2")){
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
					}else{
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
						}
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.getCOMP_CCD_COVER_CODE().setDisabled(true);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.getCOMP_CCD_LOSS_TYPE().setDisabled(true);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.getCOMP_CCD_DISAB_TYPE().setDisabled(true);
			} else if ("N".equals(CommonUtils.nvl(coverBean.getCCD_FRZ_FLAG(),
					"N"))) {

				if (compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.getCOMP_CCD_FC_EST_AMT().isDisabled()) {
					/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
					//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
							//.getCOMP_CCD_FC_EST_AMT().setDisabled(false);
					String ps_value=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
					if(ps_value!=null && ps_value.equalsIgnoreCase("2")){
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
					}else{
							compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(false);
							}
					//end
				}
				if (compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.getCOMP_CCD_LC_EST_AMT().isDisabled()) {
					/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
					//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
							//.getCOMP_CCD_LC_EST_AMT().setDisabled(false);
					String ps_value=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
					if(ps_value!=null && ps_value.equalsIgnoreCase("2")){
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
					}else{
							compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(false);
							}
					//end
				}
				if (compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.getCOMP_CCD_COVER_CODE().isDisabled()) {
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
							.getCOMP_CCD_COVER_CODE().setDisabled(false);
				}
				if (compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.getCOMP_CCD_LOSS_TYPE().isDisabled()) {
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
							.getCOMP_CCD_LOSS_TYPE().setDisabled(false);
				}
				if (compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.getCOMP_CCD_DISAB_TYPE().isDisabled()) {
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
							.getCOMP_CCD_DISAB_TYPE().setDisabled(false);
				}
				/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
				//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						//.getCOMP_CCD_FC_EST_AMT().setDisabled(false);
				//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						//.getCOMP_CCD_LC_EST_AMT().setDisabled(false);
				String ps_value=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
				if(ps_value!=null && ps_value.equalsIgnoreCase("2")){
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
				}else{
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(false);
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(false);
						}
				if ("PA".equals(CommonUtils.nvl(coverBean.getCCD_SET_FLAG(),
						"X"))) {
					/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
					//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
							//.getCOMP_CCD_FC_EST_AMT().setDisabled(true);
					//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
							//.getCOMP_CCD_LC_EST_AMT().setDisabled(true);
					String ps_value_1=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
					if(ps_value_1!=null && ps_value_1.equalsIgnoreCase("2")){
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
					}else{
							compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
							compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);

							}
				}
				/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
				//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						//.getCOMP_CCD_FC_EST_AMT().setDisabled(true);
				//end
				//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						//.getCOMP_CCD_LC_EST_AMT().setDisabled(true);
				String ps_value_1=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
				if(ps_value_1!=null && ps_value_1.equalsIgnoreCase("2")){
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
				}else{
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
						}
				//end
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.getCOMP_CCD_COVER_CODE().setDisabled(true);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.getCOMP_CCD_LOSS_TYPE().setDisabled(true);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.getCOMP_CCD_DISAB_TYPE().setDisabled(true);

			} else if ("N".equals(CommonUtils.nvl(
					coverBean.getCCD_CLOSE_FLAG(), "N"))) {
				/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
				//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						//.getCOMP_CCD_FC_EST_AMT().setDisabled(false);
				
				//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						//.getCOMP_CCD_LC_EST_AMT().setDisabled(false);
				String ps_value_1=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
				if(ps_value_1!=null && ps_value_1.equalsIgnoreCase("2")){
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
				}else{
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(false);
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(false);
						}
				//end
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.getCOMP_CCD_COVER_CODE().setDisabled(false);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.getCOMP_CCD_LOSS_TYPE().setDisabled(false);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.getCOMP_CCD_DISAB_TYPE().setDisabled(false);
			}
		}

		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			Object[] obj_C2 = new Object[] { coverBean.getCCD_COVER_CODE() };
			C2_REC = handler.executeSelectStatement(C2, connection, obj_C2);
			if (C2_REC.next()) {
				M_COVER_SA_CALC = C2_REC.getString("COVER_SA_CALC");
			}

			if ("O".equalsIgnoreCase(compositeAction
					.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
					.getCLAIM_TYPE())
					&& "D".equals(CommonUtils.nvl(compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
							.getM_PLAN_TYPE(), "X"))
					|| "G".equals(CommonUtils.nvl(M_COVER_SA_CALC, "X"))) {
				if (compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.getCOMP_CCD_FC_EST_AMT().isDisabled()
						&& compositeAction
								.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
								.getCOMP_CCD_LC_EST_AMT().isDisabled()) {
					/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
					//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
							//.getCOMP_CCD_FC_EST_AMT().setDisabled(true);
					
					//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
							//.getCOMP_CCD_LC_EST_AMT().setDisabled(true);
					String ps_value_1=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
					if(ps_value_1!=null && ps_value_1.equalsIgnoreCase("2")){
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
					}else{
							compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
							compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
							}//end
				} else {
					if (compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
							.getCOMP_CCD_FC_EST_AMT().isDisabled()
							&& compositeAction
									.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
									.getCOMP_CCD_LC_EST_AMT().isDisabled()) {
						/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
						//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
								//.getCOMP_CCD_FC_EST_AMT().setDisabled(false);
						
						//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
								//.getCOMP_CCD_LC_EST_AMT().setDisabled(false);
						String ps_value_1=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
						if(ps_value_1!=null && ps_value_1.equalsIgnoreCase("2")){
							compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
							compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
						}else{
								compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(false);
								compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(false);
								}//end
					}
				}
			}

			Object[] obj_C1 = new Object[] { compositeAction
					.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN()
					.getCLAIM_SYS_ID() };
			log.info("obj_c1" + obj_C1);
			C1_REC = handler.executeSelectStatement(C1, connection, obj_C1);
			if (C1_REC.next()) {
				M_DUMMY = C1_REC.getString(1);
			}

			if ("X".equals(CommonUtils.nvl(M_DUMMY, "Y"))) {
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(true);
			} else {
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_SETTLEMENT().setDisabled(false);
			}

			L_ED_SETTL_BUT(compositeAction.getPT_IL_CLAIM_ACTION_BEAN());

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new Exception(exception.getMessage());
		} finally {
			CommonUtils.closeCursor(C1_REC);
			CommonUtils.closeCursor(C2_REC);
		}
	}

	/**
	 * 
	 * @param P_POL_SYS_ID-IN
	 * @param P_FC_CIC_AMT-OUT
	 * @param P_LC_CIC_AMT-OUT
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> P_CALC_CIC_COVER(Object P_POL_SYS_ID,
			Object P_FC_CIC_AMT, Object P_LC_CIC_AMT) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("OUT2",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("OUT3",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param3);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_CLAIM.P_CALC_CIC_COVER");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 * 
	 * @param P_CLAIM_TYPE-IN
	 * @param P_CLAIM_LOSS_DT-IN
	 * @param P_POL_SYS_ID-IN
	 * @param P_CLAIM_SYS_ID-IN
	 * @param P_POL_SA_CURR_CODE-IN
	 * @param P_CLAIM_CURR_CODE-IN
	 * @param P_CLAIM_EXCH_RATE-IN
	 * @param P_FC_CIC_AMT-IN
	 * @param P_LC_CIC_AMT-IN
	 * @param P_CLAIM_ASSR_CODE-IN
	 * @param P_POL_INCORPORATED_YN-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> INS_CLM_CVR_RSA(Object P_CLAIM_TYPE,
			Object P_CLAIM_LOSS_DT, Object P_POL_SYS_ID, Object P_CLAIM_SYS_ID,
			Object P_POL_SA_CURR_CODE, Object P_CLAIM_CURR_CODE,
			Object P_CLAIM_EXCH_RATE, Object P_FC_CIC_AMT, Object P_LC_CIC_AMT,
			Object P_CLAIM_ASSR_CODE, Object P_POL_INCORPORATED_YN)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_TYPE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_LOSS_DT);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_POL_SA_CURR_CODE);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_CURR_CODE);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_EXCH_RATE);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.IN, P_FC_CIC_AMT);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.IN, P_LC_CIC_AMT);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_ASSR_CODE);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("IN11",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_POL_INCORPORATED_YN);
			parameterList.add(param11);
			

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_CLAIM.INS_CLM_CVR_RSA");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 * 
	 * @param P_CLAIM_TYPE-IN
	 * @param P_CLAIM_LOSS_DT-IN
	 * @param P_POL_SYS_ID-IN
	 * @param P_CLAIM_SYS_ID-IN
	 * @param P_POL_SA_CURR_CODE-IN
	 * @param P_CLAIM_CURR_CODE-IN
	 * @param P_CLAIM_EXCH_RATE-IN
	 * @param P_FC_CIC_AMT-IN
	 * @param P_LC_CIC_AMT-IN
	 * @param P_CLAIM_ASSR_CODE-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> P_INS_CLM_CVR_DTLS(Object P_CLAIM_TYPE,
			Object P_CLAIM_LOSS_DT, Object P_POL_SYS_ID, Object P_CLAIM_SYS_ID,
			Object P_POL_SA_CURR_CODE, Object P_CLAIM_CURR_CODE,
			Object P_CLAIM_EXCH_RATE, Object P_FC_CIC_AMT, Object P_LC_CIC_AMT,
			Object P_CLAIM_ASSR_CODE,
			/*added by raja on 04-03-2017 for funeral benefit fsd*/
			Object P_CLAIM_MEMB_CODE
			/*end*/) throws Exception {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_TYPE);
			parameterList.add(param1);
			/*
			 * commented by Dhinesh on 5-7-2017 for ssp call id : 
			 * 
			 * OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, CommonUtils
							.truncDate((Date) P_CLAIM_LOSS_DT));
			parameterList.add(param2);*/
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, CommonUtils.dateToStringFormat((Date)P_CLAIM_LOSS_DT));
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_POL_SA_CURR_CODE);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_CURR_CODE);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_EXCH_RATE);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.IN, P_FC_CIC_AMT);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.IN, P_LC_CIC_AMT);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_ASSR_CODE);
			parameterList.add(param10);
			/*added by raja on 04-03-2017 for funeral benefit fsd*/
			OracleParameter param11 = new OracleParameter("IN11",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_MEMB_CODE);
			parameterList.add(param11);
			/*end*/

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_CLAIM.P_INS_CLM_CVR_DTLS");
		} catch (Exception e) {
			/*Commentted by saritha on 08-02-2017 for RM018T - FSD_IL_ZB Life_012b_Claim Waiting period COMMENTS*/
			/*ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());*/
			throw new Exception(e.getMessage());
		}
		return outputList;
	}

	/**
	 * 
	 * @param P_POL_SYS_ID-IN
	 * @param P_REF_SYS_ID-IN
	 * @param P_TRAN_TYPE-IN
	 * @param P_TRAN_FLAG-IN
	 * @param P_TRAN_DATE-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> INS_PT_IL_FUND_TRAN_DTL(
			Object P_POL_SYS_ID, Object P_REF_SYS_ID, Object P_TRAN_TYPE,
			Object P_TRAN_FLAG, Object P_TRAN_DATE) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_REF_SYS_ID);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_TRAN_TYPE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_TRAN_FLAG);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, P_TRAN_DATE);
			parameterList.add(param5);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_FUND_ALLOC.INS_PT_IL_FUND_TRAN_DTL");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 * 
	 * @param connection
	 * @throws ValidatorException
	 */
	public void L_CALC_FEB_EST() throws ValidatorException {

		PILT006_APAC_COMPOSITE_ACTION pilt006_apac_composite_action = PILT006_APAC_ACTION_INSTANCE
				.getCompositeActionInstance();

		PT_IL_CLAIM_ACTION claimAction = PILT006_APAC_ACTION_INSTANCE
				.getClaimActionInstance();
		PT_IL_CLAIM_COVER_DTLS_ACTION claimCoverDtlsAction = PILT006_APAC_ACTION_INSTANCE
				.getClaimCoverDtlsActionInstance();
		// int rowIndex =
		// claimCoverDtlsAction.getCOMP_CLAIM_COVER_DTLS_DATATABLE().getRowIndex();
		CRUDHandler handler = new CRUDHandler();
		PT_IL_CLAIM_COVER_DTLS coverDtlsBean = claimCoverDtlsAction
				.getPT_IL_CLAIM_COVER_DTLS_BEAN();
		String CLAIM_TYPE = claimAction.getPT_IL_CLAIM_BEAN().getCLAIM_TYPE();
		String CCD_LOSS_TYPE = coverDtlsBean.getCCD_LOSS_TYPE();
		Double CCD_LC_EST_AMT = coverDtlsBean.getCCD_LC_EST_AMT();
		Double CCD_FC_EST_AMT = coverDtlsBean.getCCD_FC_EST_AMT();
		Double CLAIM_EXCH_RATE = claimAction.getPT_IL_CLAIM_BEAN()
				.getCLAIM_EXCH_RATE();
		String CLAIM_CURR_CODE = claimAction.getPT_IL_CLAIM_BEAN()
				.getCLAIM_CURR_CODE();
		String M_BASE_CURR = claimAction.getPT_IL_CLAIM_BEAN()
				.getUI_M_BASE_CURR();
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		ResultSet C4_REC = null;
		try {
			String M_PS_CODE_DESC = null;
			String M_POL_PROD_CODE = null;
			String M_POL_CUST_CODE = null;
			Double M_POL_LC_SUM_ASSURED = null;
			String M_POL_MASTER_POL_NO = null;
			Double M_MP_LC_FUNERAL_EXP_LMT = null;
			Double M_MP_LC_FUNERAL_EXP_AMT = null;
			String M_COVER_SA_CALC = null;
			String C1 = "SELECT PS_CODE_DESC FROM  PP_SYSTEM  WHERE  PS_TYPE  = 'IL_FEB_LOSTY' ";
			String C2 = "SELECT    POL_PROD_CODE,    POL_CUST_CODE,    POL_LC_SUM_ASSURED,    POL_MASTER_POL_NO FROM  PT_IL_POLICY  "
					+ "WHERE  POL_NO  = ?  AND POL_SYS_ID  = ?  AND POL_DS_TYPE  = '2' ";
			String C3 = "SELECT    MP_LC_FUNERAL_EXP_LMT,    MP_LC_FUNERAL_EXP_AMT FROM  PM_IL_MASTER_POLICY  WHERE  MP_CUST_CODE  = ?  AND MP_PROD_CODE  = ? ";

			String C4 = "SELECT COVER_SA_CALC FROM   PM_IL_COVER WHERE  COVER_CODE = ?";

			if (CLAIM_TYPE.equals("D") || CLAIM_TYPE.equals("A")) {
				C1_REC = handler.executeSelectStatement(C1, CommonUtils
						.getConnection());
				if (C1_REC.next()) {
					M_PS_CODE_DESC = C1_REC.getString(1);
				}
				if (CCD_LOSS_TYPE.equals(M_PS_CODE_DESC)) {
					C2_REC = handler.executeSelectStatement(C2, CommonUtils
							.getConnection(),
							new Object[] {
									claimAction.getPT_IL_CLAIM_BEAN()
											.getCLAIM_POL_NO(),
									claimAction.getPT_IL_CLAIM_BEAN()
											.getCLAIM_SYS_ID() });
					if (C2_REC.next()) {
						M_POL_PROD_CODE = C2_REC.getString(1);
						M_POL_CUST_CODE = C2_REC.getString(2);
						M_POL_LC_SUM_ASSURED = C2_REC.getDouble(3);
						M_POL_MASTER_POL_NO = C2_REC.getString(4);
					}
					if (M_POL_MASTER_POL_NO != null) {
						C3_REC = handler.executeSelectStatement(C3, CommonUtils
								.getConnection(), new Object[] {
								M_POL_CUST_CODE, M_POL_PROD_CODE });
						if (C3_REC.next()) {
							M_MP_LC_FUNERAL_EXP_LMT = C3_REC.getDouble(1);
							M_MP_LC_FUNERAL_EXP_AMT = C3_REC.getDouble(2);
						}
						if ((M_POL_LC_SUM_ASSURED == null ? 0.0
								: M_POL_LC_SUM_ASSURED) >= (M_MP_LC_FUNERAL_EXP_LMT == null ? 0.0
								: M_MP_LC_FUNERAL_EXP_LMT)) {
							CCD_LC_EST_AMT = (M_MP_LC_FUNERAL_EXP_AMT == null ? 0.0
									: M_MP_LC_FUNERAL_EXP_AMT);
							CCD_FC_EST_AMT = CCD_LC_EST_AMT / CLAIM_EXCH_RATE;
							ArrayList<OracleParameter> outputList = P_VAL_ROUND_AMT(
									CLAIM_CURR_CODE, CCD_FC_EST_AMT, "R");
							CCD_FC_EST_AMT = (Double) outputList.get(0)
									.getValueObject();
							coverDtlsBean.setCCD_FC_EST_AMT(CCD_FC_EST_AMT);
							outputList = P_VAL_ROUND_AMT(M_BASE_CURR,
									CCD_LC_EST_AMT, "R");
							CCD_LC_EST_AMT = (Double) outputList.get(0)
									.getValueObject();
							coverDtlsBean.setCCD_LC_EST_AMT(CCD_LC_EST_AMT);
							claimCoverDtlsAction.getCOMP_CCD_FC_EST_AMT()
									.setDisabled(true);
							claimCoverDtlsAction.getCOMP_CCD_LC_EST_AMT()
									.setDisabled(true);
						} else {
							CCD_LC_EST_AMT = 0.0;
							CCD_FC_EST_AMT = 0.0;
							claimCoverDtlsAction.getCOMP_CCD_FC_EST_AMT()
									.setDisabled(false);
							claimCoverDtlsAction.getCOMP_CCD_LC_EST_AMT()
									.setDisabled(false);
						}
					} else {
						claimCoverDtlsAction.getCOMP_CCD_FC_EST_AMT()
								.setDisabled(false);
						claimCoverDtlsAction.getCOMP_CCD_LC_EST_AMT()
								.setDisabled(false);
					}
				}
			}

			C4_REC = handler.executeSelectStatement(C4, CommonUtils
					.getConnection(), new Object[] { coverDtlsBean
					.getCCD_COVER_CODE() });
			if (C4_REC.next()) {
				M_COVER_SA_CALC = C4_REC.getString(1);
			}

			if (CLAIM_TYPE != null
					&& "O".equalsIgnoreCase(CLAIM_TYPE)
					&& ("D".equals(CommonUtils.nvl(
							pilt006_apac_composite_action
									.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
									.getM_PLAN_TYPE(), "D")) || "G"
							.equals(CommonUtils.nvl(M_COVER_SA_CALC, "X")))) {

				if (!claimCoverDtlsAction.getCOMP_CCD_FC_EST_AMT().isDisabled()
						&& !claimCoverDtlsAction.getCOMP_CCD_LC_EST_AMT()
								.isDisabled()) {
					/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
					//claimCoverDtlsAction.getCOMP_CCD_FC_EST_AMT().setDisabled(
							//true);
					//claimCoverDtlsAction.getCOMP_CCD_LC_EST_AMT().setDisabled(
							//true);
					String ps_value_1=claimCoverDtlsAction.getPS_VALUE();
					if(ps_value_1!=null && ps_value_1.equalsIgnoreCase("2")){
						claimCoverDtlsAction.getCOMP_CCD_FC_EST_AMT().setDisabled(true);
						claimCoverDtlsAction.getCOMP_CCD_LC_EST_AMT().setDisabled(true);
					}else{
						claimCoverDtlsAction.getCOMP_CCD_FC_EST_AMT().setDisabled(true);
						claimCoverDtlsAction.getCOMP_CCD_LC_EST_AMT().setDisabled(true);
							}//end
				}
			} else {
				if (!claimCoverDtlsAction.getCOMP_CCD_FC_EST_AMT().isDisabled()
						&& !claimCoverDtlsAction.getCOMP_CCD_LC_EST_AMT()
								.isDisabled()) {
					/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
					//claimCoverDtlsAction.getCOMP_CCD_FC_EST_AMT().setDisabled(
							//false);
					//claimCoverDtlsAction.getCOMP_CCD_LC_EST_AMT().setDisabled(
							//false);
					String ps_value_1=claimCoverDtlsAction.getPS_VALUE();
					if(ps_value_1!=null && ps_value_1.equalsIgnoreCase("2")){
						claimCoverDtlsAction.getCOMP_CCD_FC_EST_AMT().setDisabled(true);
						claimCoverDtlsAction.getCOMP_CCD_LC_EST_AMT().setDisabled(true);
					}else{
						claimCoverDtlsAction.getCOMP_CCD_FC_EST_AMT().setDisabled(false);
						claimCoverDtlsAction.getCOMP_CCD_LC_EST_AMT().setDisabled(false);
							}//end
				}
			}

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(C1_REC);
				CommonUtils.closeCursor(C2_REC);
				CommonUtils.closeCursor(C3_REC);
				CommonUtils.closeCursor(C4_REC);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void L_CALC_PTPD_EST() throws ValidatorException {
		PILT006_APAC_COMPOSITE_ACTION pilt006_apac_composite_action = PILT006_APAC_ACTION_INSTANCE
				.getCompositeActionInstance();

		PT_IL_CLAIM_ACTION claimAction = PILT006_APAC_ACTION_INSTANCE
				.getClaimActionInstance();
		PT_IL_CLAIM_COVER_DTLS_ACTION claimCoverDtlsAction = PILT006_APAC_ACTION_INSTANCE
				.getClaimCoverDtlsActionInstance();
		// int rowIndex =
		// claimCoverDtlsAction.getCOMP_CLAIM_COVER_DTLS_DATATABLE().getRowIndex();
		CRUDHandler handler = new CRUDHandler();
		PT_IL_CLAIM_COVER_DTLS coverDtlsBean = claimCoverDtlsAction
				.getPT_IL_CLAIM_COVER_DTLS_BEAN();
		String CLAIM_TYPE = claimAction.getPT_IL_CLAIM_BEAN().getCLAIM_TYPE();
		String CCD_LOSS_TYPE = coverDtlsBean.getCCD_LOSS_TYPE();
		Double CCD_LC_EST_AMT = coverDtlsBean.getCCD_LC_EST_AMT();
		Double CCD_FC_EST_AMT = coverDtlsBean.getCCD_FC_EST_AMT();
		Double CLAIM_EXCH_RATE = claimAction.getPT_IL_CLAIM_BEAN()
				.getCLAIM_EXCH_RATE();
		String CLAIM_CURR_CODE = claimAction.getPT_IL_CLAIM_BEAN()
				.getCLAIM_CURR_CODE();
		String M_BASE_CURR = claimAction.getPT_IL_CLAIM_BEAN()
				.getUI_M_BASE_CURR();
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		String M_COVER_SA_CALC = null;
		try {
			String M_PS_CODE_DESC = null;
			Double M_POL_FC_PRE_TPD_BNF = null;
			Double M_POL_LC_PRE_TPD_BNF = null;
			String C1 = "SELECT PS_CODE_DESC FROM  PP_SYSTEM  WHERE  PS_TYPE  = 'IL_PTPD_LOTY' ";
			String C2 = "SELECT    POL_FC_PRE_TPD_BNF,    POL_LC_PRE_TPD_BNF FROM  PT_IL_POLICY  WHERE  "
					+ "POL_NO  = ?  "
					+ "AND POL_SYS_ID  = ?  "
					+ "AND POL_DS_TYPE  = '2' ";
			String C3 = "SELECT COVER_SA_CALC FROM PM_IL_COVER WHERE  COVER_CODE = ? ";

			if (CLAIM_TYPE.equals("O")) {
				C1_REC = handler.executeSelectStatement(C1, CommonUtils
						.getConnection());
				if (C1_REC.next()) {
					M_PS_CODE_DESC = C1_REC.getString(1);
				}
				if (CCD_LOSS_TYPE != null
						&& CCD_LOSS_TYPE.equals(M_PS_CODE_DESC)) {
					C2_REC = handler
							.executeSelectStatement(C2, CommonUtils
									.getConnection(),
									new Object[] {
											claimAction.getPT_IL_CLAIM_BEAN()
													.getCLAIM_POL_NO(),
											pilt006_apac_composite_action
													.getDUMMY_ACTION_BEAN()
													.getDUMMY_BEAN()
													.getM_POL_SYS_ID() });
					if (C2_REC.next()) {
						M_POL_FC_PRE_TPD_BNF = C2_REC.getDouble(1);
						M_POL_LC_PRE_TPD_BNF = C2_REC.getDouble(2);
					}
					coverDtlsBean
							.setCCD_FC_EST_AMT((M_POL_FC_PRE_TPD_BNF == null ? 0.0
									: M_POL_FC_PRE_TPD_BNF));
					coverDtlsBean
							.setCCD_LC_EST_AMT((M_POL_LC_PRE_TPD_BNF == null ? 0.0
									: M_POL_LC_PRE_TPD_BNF));
					/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
					//pilt006_apac_composite_action.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
					//pilt006_apac_composite_action.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
					String ps_value_1=claimCoverDtlsAction.getPS_VALUE();
					if(ps_value_1!=null && ps_value_1.equalsIgnoreCase("2")){
						pilt006_apac_composite_action.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
						pilt006_apac_composite_action.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
					}else{
						pilt006_apac_composite_action.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
						pilt006_apac_composite_action.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
							}//end
				} else {
					/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
					//pilt006_apac_composite_action.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(false);
				    //pilt006_apac_composite_action.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(false);
					String ps_value_1=claimCoverDtlsAction.getPS_VALUE();
					if(ps_value_1!=null && ps_value_1.equalsIgnoreCase("2")){
						pilt006_apac_composite_action.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
						pilt006_apac_composite_action.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
					}else{
						pilt006_apac_composite_action.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(false);
						pilt006_apac_composite_action.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(false);
							}//end
					if ("PA".equals(CommonUtils.nvl(coverDtlsBean
							.getCCD_SET_FLAG(), "X"))) {
						/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
						//pilt006_apac_composite_action.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
						//pilt006_apac_composite_action.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
						String ps_value_2=claimCoverDtlsAction.getPS_VALUE();
						if(ps_value_2!=null && ps_value_2.equalsIgnoreCase("2")){
							pilt006_apac_composite_action.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
							pilt006_apac_composite_action.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
						}else{
							pilt006_apac_composite_action.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
							pilt006_apac_composite_action.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
								}//end
					}
				}

				C3_REC = handler.executeSelectStatement(C3, CommonUtils
						.getConnection(), new Object[] { coverDtlsBean
						.getCCD_COVER_CODE() });
				if (C3_REC.next()) {
					M_COVER_SA_CALC = C3_REC.getString(1);
					if ("O".equalsIgnoreCase(claimAction.getPT_IL_CLAIM_BEAN()
							.getCLAIM_TYPE())
							&& "D".equals(CommonUtils.nvl(
									pilt006_apac_composite_action
											.getDUMMY_ACTION_BEAN()
											.getDUMMY_BEAN().getM_PLAN_TYPE(),
									"X"))
							|| "G"
									.equals(CommonUtils.nvl(M_COVER_SA_CALC,
											"X"))) {
						if (!pilt006_apac_composite_action
								.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
								.getCOMP_CCD_FC_EST_AMT().isDisabled()
								&& !pilt006_apac_composite_action
										.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
										.getCOMP_CCD_LC_EST_AMT().isDisabled()) {
							/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
							//pilt006_apac_composite_action.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
							//pilt006_apac_composite_action.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
							String ps_value_2=claimCoverDtlsAction.getPS_VALUE();
							if(ps_value_2!=null && ps_value_2.equalsIgnoreCase("2")){
								pilt006_apac_composite_action.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
								pilt006_apac_composite_action.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
							}else{
								pilt006_apac_composite_action.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
								pilt006_apac_composite_action.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
									}//end
						}
					} else {
						if (!pilt006_apac_composite_action
								.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
								.getCOMP_CCD_FC_EST_AMT().isDisabled()
								&& !pilt006_apac_composite_action
										.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
										.getCOMP_CCD_LC_EST_AMT().isDisabled()) {
							pilt006_apac_composite_action
									.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
									.getCOMP_CCD_FC_EST_AMT()
									.setDisabled(false);
							pilt006_apac_composite_action
									.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
									.getCOMP_CCD_LC_EST_AMT()
									.setDisabled(false);
						}
					}
				}
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(C1_REC);
				CommonUtils.closeCursor(C2_REC);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param P_CURR_CODE-IN
	 * @param P_AMT-IN
	 *            OUT
	 * @param P_VAL_ROUND-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> P_VAL_ROUND_AMT(Object P_CURR_CODE,
			Object P_AMT, Object P_VAL_ROUND) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_CURR_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN OUT2",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.IN_OUT, P_AMT);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_VAL_ROUND);
			parameterList.add(param3);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P_VAL_ROUND_AMT");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 * 
	 * @param P_POL_SYS_ID-IN
	 * @param P_CLM_SYS_ID-IN
	 * @param P_CLM_CURR_CODE-IN
	 * @param P_CLM_LOSS_DT-IN
	 * @param P_CCD_COVER_CODE-IN
	 * @param P_CCD_SYS_ID-IN
	 * @param P_CCD_FC_EST_AMT-IN
	 * @param P_CCD_LC_EST_AMT-IN
	 * @param P_ASSR_CODE-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> P_INSERT_FAC_CLM_EST(Object P_POL_SYS_ID,
			Object P_CLM_SYS_ID, Object P_CLM_CURR_CODE, Object P_CLM_LOSS_DT,
			Object P_CCD_COVER_CODE, Object P_CCD_SYS_ID,
			Object P_CCD_FC_EST_AMT, Object P_CCD_LC_EST_AMT, Object P_ASSR_CODE)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_CLM_SYS_ID);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_CLM_CURR_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, P_CLM_LOSS_DT);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_CCD_COVER_CODE);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_CCD_SYS_ID);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.IN, P_CCD_FC_EST_AMT);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.IN, P_CCD_LC_EST_AMT);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_ASSR_CODE);
			parameterList.add(param9);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_CLAIM.P_INSERT_FAC_CLM_EST");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 * 
	 * @param P_CLAIM_POL_SYS_ID-IN
	 * @param P_CLAIM_SYS_ID-IN
	 * @param P_CLAIM_CURR_CODE-IN
	 * @param P_CLAIM_LOSS_DT-IN
	 * @param P_CCD_COVER_CODE-IN
	 * @param P_CCD_SYS_ID-IN
	 * @param P_CCD_FC_EST_AMT-IN
	 * @param P_CCD_LC_EST_AMT-IN
	 * @param P_CLAIM_ASSR_CODE-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> INS_TREATY_ESTIMATE(
			Object P_CLAIM_POL_SYS_ID, Object P_CLAIM_SYS_ID,
			Object P_CLAIM_CURR_CODE, Object P_CLAIM_LOSS_DT,
			Object P_CCD_COVER_CODE, Object P_CCD_SYS_ID,
			Object P_CCD_FC_EST_AMT, Object P_CCD_LC_EST_AMT,
			Object P_CLAIM_ASSR_CODE) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_CURR_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter(
					"IN4",
					OracleParameter.DATA_TYPE.TIMESTAMP,
					OracleParameter.DIRECTION_TYPE.IN,
					CommonUtils
							.utilDateToTimeStampConverter((Date) P_CLAIM_LOSS_DT));
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_CCD_COVER_CODE);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_CCD_SYS_ID);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.IN, P_CCD_FC_EST_AMT);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.IN, P_CCD_LC_EST_AMT);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_ASSR_CODE);
			parameterList.add(param9);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_CLAIM.INS_TREATY_ESTIMATE");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 * 
	 * @param P_CLAIM_SYS_ID-IN
	 * @param P_CS_STATUS_CODE-IN
	 * @param P_CS_STATUS_DT-IN
	 * @param P_CS_REASON_CODE-IN
	 * @param P_CS_REMARKS-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> P_INSERT_CLAIM_STATUS(
			Object P_CLAIM_SYS_ID, Object P_CS_STATUS_CODE,
			Object P_CS_STATUS_DT, Object P_CS_REASON_CODE, Object P_CS_REMARKS)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_CS_STATUS_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, P_CS_STATUS_DT);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_CS_REASON_CODE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_CS_REMARKS);
			parameterList.add(param5);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_CLAIM.P_INSERT_CLAIM_STATUS");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 * 
	 * @param P_CLAIM_SYS_ID-IN
	 * @param P_PAID_FLAG-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> REV_CLM_RESERVE(Object P_CLAIM_SYS_ID,
			Object P_PAID_FLAG) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_PAID_FLAG);
			parameterList.add(param2);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_CLAIM.REV_CLM_RESERVE");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/**
	 * 
	 * @param PT_IL_DOC_TODO_LIST_STATUS_BEAN
	 * @throws Exception
	 */
	public void IL_UNIQUE_TODOLIST_SRNO(
			PT_IL_DOC_TODO_LIST_STATUS PT_IL_DOC_TODO_LIST_STATUS_BEAN)
			throws Exception {
		String C1 = "	SELECT 'X' FROM   PT_IL_DOC_TODO_LIST_STATUS "
				+ "WHERE  DTLS_SR_NO       = ? "
				+ "AND    DTLS_POL_SYS_ID  = ? "
				+ "AND    NVL(DTLS_END_NO_IDX,0)  = NVL(?,0) "
				+ "AND    DTLS_GROUP_CODE = ?";
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst = null;
		String M_TODOLIST_SRNO = null;
		try {
			Object obj[] = new Object[] {
					PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_SR_NO(),
					PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_POL_SYS_ID(),
					PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_END_NO_IDX(),
					PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_GROUP_CODE() };

			rst = handler.executeSelectStatement(C1, CommonUtils
					.getConnection(), obj);
			while (rst.next()) {
				M_TODOLIST_SRNO = rst.getString(1);
				/*
				 * throw new Exception(Messages.getString(
				 * PELConstants.pelErrorMessagePath, "91028", new Object[] {
				 * "001" }));
				 */
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param PT_IL_CLAIM_BEAN
	 * @return
	 */
	public List<String> L_VALIDATE_CHECKLIST(PT_IL_CLAIM PT_IL_CLAIM_BEAN)
			throws Exception {
		List<String> list = new ArrayList<String>();
		String M_DUMMY = null;
		String M_DTG_GROUP_CODE = null;
		String M_DTG_GROUP_CODE_1 = null;
		String M_CHK = null;
		String M_UWQ = null;

		String C1 = "SELECT DTG_GROUP_CODE FROM   PM_IL_DOC_TODO_GROUP "
				+ "WHERE  DTG_GROUP_TYPE = 'CHKLST'  " + "AND DTG_DS_CODE=? "
				+ "AND DTG_DS_TYPE='4'";

		String C2 = "SELECT DTG_GROUP_CODE FROM PM_IL_DOC_TODO_GROUP "
				+ "WHERE DTG_GROUP_TYPE = 'UWQUERY'   " + "AND DTG_DS_CODE=? "
				+ "AND DTG_DS_TYPE='4'";

		String C3 = "SELECT 'X' FROM PT_IL_DOC_TODO_LIST_STATUS "
				+ "WHERE DTLS_CLM_SYS_ID = ? "
				+ "AND DTLS_APPR_STS IN ('NA','N')  "
				+ "AND DTLS_MANDATORY_YN = 'Y'  " + "AND DTLS_GROUP_CODE = ?";

		String C4 = "SELECT 'X' FROM PT_IL_DOC_TODO_LIST_STATUS "
				+ "WHERE DTLS_CLM_SYS_ID = ? "
				+ "AND DTLS_APPR_STS IN ('NA','Y')  "
				+ "AND DTLS_MANDATORY_YN = 'Y'  " + "AND DTLS_GROUP_CODE= ?";
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		ResultSet C4_REC = null;

		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			C1_REC = handler.executeSelectStatement(C1, connection,
					new Object[] { CommonUtils
							.getGlobalVariable("GLOBAL.M_PARA_1") });
			if (C1_REC.next()) {
				M_DTG_GROUP_CODE = C1_REC.getString(1);
			}

			C3_REC = handler.executeSelectStatement(C3, connection,
					new Object[] { PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID(),
							M_DTG_GROUP_CODE });
			if (C3_REC.next()) {
				M_DUMMY = C3_REC.getString(1);
			}

			if ("X".equals(CommonUtils.nvl(M_DUMMY, "Y"))) {
				M_CHK = "N";
			} else {
				M_CHK = "Y";
			}

			C2_REC = handler.executeSelectStatement(C2, connection,
					new Object[] { CommonUtils
							.getGlobalVariable("GLOBAL.M_PARA_1") });
			if (C1_REC.next()) {
				M_DTG_GROUP_CODE_1 = C2_REC.getString(1);
			}

			C4_REC = handler.executeSelectStatement(C4, connection,
					new Object[] { PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID(),
							M_DTG_GROUP_CODE });
			if (C4_REC.next()) {
				M_DUMMY = C4_REC.getString(1);
			}

			if ("X".equals(CommonUtils.nvl(M_DUMMY, "Y"))) {
				M_UWQ = "N";
			} else {
				M_UWQ = "Y";
			}

			list.add(M_CHK);
			list.add(M_UWQ);
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(C1_REC);
			} catch (Exception exc) {
			}
			try {
				CommonUtils.closeCursor(C2_REC);
			} catch (Exception exc) {
			}
			try {
				CommonUtils.closeCursor(C3_REC);
			} catch (Exception exc) {
			}
			try {
				CommonUtils.closeCursor(C4_REC);
			} catch (Exception exc) {
			}
		}

		return list;
	}

	/**
	 * 
	 * @param P_POL_SYS_ID-IN
	 * @param P_PC_SYS_ID-IN
	 * @param P_DATE-IN
	 * @param P_PC_FC_NET_PREM-OUT
	 * @param P_PC_LC_NET_PREM-OUT
	 * @param P_PC_FC_UNPAID_PREM_INT-OUT
	 * @param P_PC_LC_UNPAID_PREM_INT-OUT
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> P_CALC_UNPAID_PREM_INT(
			Object P_POL_SYS_ID, Object P_PC_SYS_ID, Object P_DATE,
			Object P_PC_FC_NET_PREM, Object P_PC_LC_NET_PREM,
			Object P_PC_FC_UNPAID_PREM_INT, Object P_PC_LC_UNPAID_PREM_INT)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_PC_SYS_ID);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, P_DATE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("OUT4",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("OUT5",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("OUT6",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("OUT7",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT, "");
			parameterList.add(param7);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_PREM_COLL.P_CALC_UNPAID_PREM_INT");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	
/*Added by Raja for RM018T - FSD_IL_ZB Life_010-Maximum Funeral  Benefit Limit*/
	
	public ArrayList<OracleParameter> PROC_CALL_CALC_CLM_CVR_EST_AMT_F(Object P_MEMB_CODE,
			Object P_CLAIM_POL_NO, Object P_CLAIM_TYPE, Object P_CLAIM_EXCH_RATE,Object P_CCD_COVER_CODE,
			Object P_CCD_LOSS_TYPE, Object P_CCD_DISAB_TYPE,
			Object P_CLAIM_LOSS_DT, Object P_CLAIM_ASSR_CODE, Object P_M_BASE_CURR,
			Object P_CCD_FC_EST_AMT, Object P_CCD_LC_EST_AMT, Object P_CCD_RATE,
			Object P_CCD_RATE_PER, Object P_CCD_PERIOD)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",	OracleParameter.DATA_TYPE.STRING,	OracleParameter.DIRECTION_TYPE.IN, P_MEMB_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING,	OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_POL_NO);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_TYPE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4",	OracleParameter.DATA_TYPE.DOUBLE,	OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_EXCH_RATE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5",	OracleParameter.DATA_TYPE.STRING,	OracleParameter.DIRECTION_TYPE.IN, P_CCD_COVER_CODE);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6",	OracleParameter.DATA_TYPE.STRING,OracleParameter.DIRECTION_TYPE.IN, P_CCD_LOSS_TYPE);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7",OracleParameter.DATA_TYPE.STRING,OracleParameter.DIRECTION_TYPE.IN, P_CCD_DISAB_TYPE);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN8",	OracleParameter.DATA_TYPE.DATE,OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_LOSS_DT);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9",	OracleParameter.DATA_TYPE.STRING,OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_ASSR_CODE);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10",OracleParameter.DATA_TYPE.STRING,OracleParameter.DIRECTION_TYPE.IN, P_M_BASE_CURR);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("OUT1",OracleParameter.DATA_TYPE.DOUBLE,OracleParameter.DIRECTION_TYPE.OUT, P_CCD_FC_EST_AMT);
			parameterList.add(param11);
			OracleParameter param12 = new OracleParameter("OUT2",	OracleParameter.DATA_TYPE.DOUBLE,OracleParameter.DIRECTION_TYPE.OUT, P_CCD_LC_EST_AMT);
			parameterList.add(param12);
			OracleParameter param13 = new OracleParameter("OUT3",	OracleParameter.DATA_TYPE.DOUBLE,OracleParameter.DIRECTION_TYPE.OUT, P_CCD_RATE);
			parameterList.add(param13);
			OracleParameter param14 = new OracleParameter("OUT4",OracleParameter.DATA_TYPE.LONG,OracleParameter.DIRECTION_TYPE.OUT, P_CCD_RATE_PER);
			parameterList.add(param14);
			OracleParameter param15 = new OracleParameter("OUT5",OracleParameter.DATA_TYPE.INTEGER,OracleParameter.DIRECTION_TYPE.OUT, P_CCD_PERIOD);
			parameterList.add(param15);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,"p9ilpk_claim.CALC_CLM_CVR_EST_AMT_F");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	/*End*/

	
/*Added by sankara narayanan for Hospital cash plan on 27/04/2017*/
	
	
	
	public static ArrayList<OracleParameter>  P_HOSPITAL_VALIDATION(Object P_CLM_POL_SYS_ID,
			      Object P_PMEM_PLAN_CODE, Object P_PMEN_MEMB_CODE,Object P_ICD_DISEASE_CODE,
			      Date P_CLAIM_HOSP_ADDM_DT, Date P_CLAIM_HOSP_DSCHG_DT, Object P_ERR_MSG, Object P_ERR_NO)
			throws Exception {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			
			String addm_date=CommonUtils.dateToStringFormatterWithTimeStamp(P_CLAIM_HOSP_ADDM_DT);
			String dschg_date=CommonUtils.dateToStringFormatterWithTimeStamp(P_CLAIM_HOSP_DSCHG_DT);
			
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",	OracleParameter.DATA_TYPE.LONG,	OracleParameter.DIRECTION_TYPE.IN, P_CLM_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING,	OracleParameter.DIRECTION_TYPE.IN, P_PMEM_PLAN_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PMEN_MEMB_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4",	OracleParameter.DATA_TYPE.STRING,	OracleParameter.DIRECTION_TYPE.IN, P_ICD_DISEASE_CODE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, addm_date);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6",	OracleParameter.DATA_TYPE.STRING,	OracleParameter.DIRECTION_TYPE.IN, dschg_date);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("OUT1",	OracleParameter.DATA_TYPE.STRING,	OracleParameter.DIRECTION_TYPE.OUT, P_ERR_MSG);
			parameterList.add(param7);
			/*Added by Ameen on 30-08-2017 as per Gaurav sugg.*/
			OracleParameter param8 = new OracleParameter("OUT2",	OracleParameter.DATA_TYPE.INTEGER,	OracleParameter.DIRECTION_TYPE.OUT, P_ERR_NO);
			parameterList.add(param8);
			

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,"P9ILPK_CLAIM.P_HOSP_CASH_VALIDATION");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error message ==== "+e.getMessage());
			
			/*changed by raja on 04-05-2017 for Hospital cash plan*/
			/*//ErrorHelpUtil.getErrorForProcedure(connection);
			throw new Exception(e.getMessage());*/
			
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
			/*end*/
		}
		return outputList;
	}
	
	/*END*/
	/*added by gopi for ppd rider cover issue on 21/03/2019*/
	
	public ArrayList<OracleParameter> P_PPDA_EST_AMT(Object P_CLAIM_SYS_ID,Object P_RATE,Object P_RATE_PER,
			Object P_CLAIM_FC_EST_AMT_NEW, Object P_CLAIM_LC_EST_AMT_NEW)
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",	OracleParameter.DATA_TYPE.LONG,	OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DOUBLE,	OracleParameter.DIRECTION_TYPE.IN, P_RATE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_RATE_PER);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("OUT1",	OracleParameter.DATA_TYPE.DOUBLE,	OracleParameter.DIRECTION_TYPE.OUT, P_CLAIM_FC_EST_AMT_NEW);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("OUT2",	OracleParameter.DATA_TYPE.DOUBLE,	OracleParameter.DIRECTION_TYPE.OUT, P_CLAIM_LC_EST_AMT_NEW);
			parameterList.add(param5);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,"P9ILPK_CLAIM.P_PPDA_EST_AMT");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	//end

}
