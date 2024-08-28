package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILM013_APAC.PM_IL_DOC_DFLT_CHARGE;
import com.iii.pel.forms.PILM013_APAC.PM_IL_DOC_DFLT_CHARGE_ACTION;
import com.iii.pel.forms.PILM013_APAC.PM_IL_DOC_DFLT_CHARGE_DELEGATE;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POLICY;
import com.iii.pel.utils.PCOPK_GENERAL;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_CLAIM_CHRG_HELPER {

	
	private PT_IL_CLAIM_CHRG_DELEGATE pm_il_claim_chrg_delegate = null;
	
	public void preInsert(PT_IL_CLAIM PT_IL_CLAIM_BEAN,PT_IL_CLAIM_CHRG PT_IL_CLAIM_CHRG_BEAN) throws Exception {
		String SEQUENCE_QUERY = "SELECT PIL_CC_SYS_ID.NEXTVAL FROM DUAL";
		ResultSet resultSet = null;
		try {
			resultSet = new CRUDHandler().executeSelectStatement(SEQUENCE_QUERY, CommonUtils.getConnection());
			if (resultSet.next()) {
				PT_IL_CLAIM_CHRG_BEAN.setCC_SYS_ID(resultSet.getLong(1));
			}
			PT_IL_CLAIM_CHRG_BEAN.setCC_CLM_SYS_ID(PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage()); 
		}finally {try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}};
	}

	
	
	public void POST_QUERY(PILT006_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {

		Connection con = null;
		try {
			compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN().getCOMP_CC_CHRG_LC_VALUE().setDisabled(true);
			compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN().getCOMP_CC_CHRG_FC_VALUE().setDisabled(true);
			//compositeAction.getPT_IL_SURR_CHRG_ACTION_BEAN().getCOMP_SRC_SMV_LC_VALUE().setDisabled(true);
			//compositeAction.getPT_IL_SURR_CHRG_ACTION_BEAN().getCOMP_SRC_SMV_FC_VALUE().setDisabled(true);
			compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN().getCOMP_CC_CHRG_CODE().setDisabled(true);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void executeQuery(PILT006_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_IL_CLAIM_CHRG_DELEGATE().executeSelectStatement(compositeAction);

		List<PT_IL_CLAIM_CHRG> dataList = compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN().getDataList_PT_IL_SURR_CHRG();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_CLAIM_CHRG PT_IL_CLAIM_CHRG_BEAN = dataList.get(0);
			PT_IL_CLAIM_CHRG_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN()
					.setPT_IL_CLAIM_CHRG_BEAN(PT_IL_CLAIM_CHRG_BEAN);
		}
	}
	public void DDCHG_CODE_WHEN_VALIDATE_ITEM(String chargeCode,
			PT_IL_CLAIM_CHRG pm_il_doc_dflt_charge) throws Exception {
		pm_il_claim_chrg_delegate = new PT_IL_CLAIM_CHRG_DELEGATE();
		try {
			/* P_VAL_CODES procedure calling */
			pm_il_doc_dflt_charge.setUI_M_CC_CHRG_CODE_DESC((DBProcedures.callP_VAL_CODES("IL_CHARGE", chargeCode, null, "E", null)).get(0));
			pm_il_doc_dflt_charge.setCC_CHRG_CODE(chargeCode);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*Added by saritha on 28-02-2018 for Charge Foreign Currency Amount calculation Issues*/
	
	public ArrayList<OracleParameter> callP_INS_CLM_ADD_DEL_CHRGS(
			Long P_CLM_SYS_ID,
			String P_DDCHG_CODE,
			double P_RATE,
			double P_RATE_PER,
			double P_CC_CHRG_FC_VALUE) throws Exception {

		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_CLM_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_DDCHG_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_RATE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, P_RATE_PER);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("OUT1", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.OUT,P_CC_CHRG_FC_VALUE);
			parameterList.add(param5);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P_INS_CLM_ADD_DEL_CHRGS");

			connection.commit();
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			e.printStackTrace();
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	
	/*End*/
	
}
