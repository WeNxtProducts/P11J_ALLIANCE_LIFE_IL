package com.iii.pel.forms.PILP042_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.LIFELIB;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.runtime.functions.MigratingFunctions;

public class PILP042_APAC_HELPER {

	public void pilp042_apac_pre_form() throws Exception {
		CommonUtils utils = new CommonUtils();
		PILP042_APAC_COMPOSITE_ACTION compositeAction = (PILP042_APAC_COMPOSITE_ACTION) utils
				.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		String M_FILE = null;
		String M_TITLE = null;
		// Base_Curr changes PREMIAGDC-0030	helperF_GET_BASE_CURRENCY added
		String P_CURR_CODE = null;
		String P_NAME = null;
		int P_DECIMAL = -1;
		// Base_Curr changes PREMIAGDC-0030	helperF_GET_BASE_CURRENCY added
		DBProcedures procedures = new DBProcedures();
		DUMMY_ACTION action = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY dummyBean = action.getDUMMY_BEAN();
		try {
			if (CommonUtils.getGlobalVariable("GLOBAL.M_FAILURE") == null) {
				CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "FALSE");
			}
			if (CommonUtils.getGlobalVariable("GLOBAL.M_NAME") == null) {
				CommonUtils.setGlobalVariable("GLOBAL.M_NAME",
						"COMPANY NAME..................PROGRAM NAME");
			}
			if (CommonUtils.getGlobalVariable("GLOBAL.M_DFLT_VALUES") == null) {
				CommonUtils.setGlobalVariable("GLOBAL.M_DFLT_VALUES",
						"00101    01");
			}
			CommonUtils.setGlobalVariable("GLOBAL.M_MODULE_NAME",
					"PILP042_APAC");
			if (CommonUtils.getGlobalVariable("GLOBAL.M_CHECK_FLAG") == null) {
				CommonUtils.setGlobalVariable("GLOBAL.M_CHECK_FLAG", "FALSE");
			}
			if (CommonUtils.getGlobalVariable("GLOBAL.M_REVERSAL_FLAG") == null) {
				CommonUtils.setGlobalVariable("GLOBAL.M_REVERSAL_FLAG", "N");
			}
			
			ArrayList<String> list = procedures.helperF_GET_BASE_CURRENCY(CommonUtils.getGlobalVariable("GLOBAL.M_COMP_CODE"), "N", P_CURR_CODE, P_NAME, P_DECIMAL+"", "E");
			if(list!= null && list.size()>0){
				P_CURR_CODE = list.get(0);
				P_NAME = list.get(1);
				P_DECIMAL = CommonUtils.parseToInt(list.get(2));
				dummyBean.setUI_M_BASE_CURR(P_CURR_CODE);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/*
	 * WHEN_NEW_FORM_INSTANCE
	 */

	public void pilp042_apac_when_new_form_instance() throws Exception {
		CommonUtils utils = new CommonUtils();
		PILP042_APAC_COMPOSITE_ACTION compositeAction = (PILP042_APAC_COMPOSITE_ACTION) utils
				.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		PT_IL_FUND_TRAN_HDR_ACTION actionBean = compositeAction
				.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN();
		PT_IL_FUND_TRAN_DTL_1_ACTION dtl_1_actionBean = compositeAction
				.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN();
		try {
			CommonUtils.setGlobalVariable("GLOBAL.FLAG1", null);
			CommonUtils.setGlobalVariable("GLOBAL.FLAG2", "0");
			CommonUtils.setGlobalVariable("GLOBAL.FLAG3", null);
			CommonUtils.setGlobalVariable("GLOBAL.BUY_BLOCK_ENT_YN", "N");
			CommonUtils.setGlobalVariable("GLOBAL.PREV_PERC_VALUE", "0");
			actionBean.getCOMP_UI_M_GET_FUND().setDisabled(true);
			actionBean.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
			actionBean.getCOMP_UI_M_STATUS_BUT().setDisabled(false);
			actionBean.setDELETE_ALLOWED(false);
			dtl_1_actionBean.setDELETE_ALLOWED(false);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/*
	 * PT_IL_FUND_TRAN_HDR Block_Level Triggers
	 */

	public void pilp042_apac_pt_il_fund_tran_hdr_pre_insert() throws Exception {
		CommonUtils utils = new CommonUtils();
		Connection connection = null;
		connection = CommonUtils.getConnection();
		PILP042_APAC_COMPOSITE_ACTION compositeAction = (PILP042_APAC_COMPOSITE_ACTION) utils
				.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		PT_IL_FUND_TRAN_HDR_ACTION actionBean = compositeAction
				.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN();
		PT_IL_FUND_TRAN_HDR valueBean = actionBean
				.getPT_IL_FUND_TRAN_HDR_BEAN();
		CRUDHandler handler = null;
		handler = new CRUDHandler();
		Long M_P9IL_FTH_SYS_ID = null;
		ResultSet resultSet = null;
		try {
			String sql_C1 = PILP042_APAC_SQL_QUERY_CONSTANTS.PT_IL_FUND_TRAN_HDR_PRE_INSERT;
			Object[] object = {};
			resultSet = handler.executeSelectStatement(sql_C1, connection,
					object);
			if (resultSet.next()) {
				M_P9IL_FTH_SYS_ID = resultSet.getLong(1);
			}
			valueBean.setFTH_SYS_ID(M_P9IL_FTH_SYS_ID);
			valueBean.setFTH_CR_DT(utils.getCurrentDate());
			valueBean.setFTH_CR_UID(compositeAction.getControlBean()
					.getM_USER_ID());
			valueBean.setFTH_APPRV_STATUS("N");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void pilp042_apac_pt_il_fund_tran_hdr_when_create_record()
			throws Exception {
		CommonUtils utils = new CommonUtils();
		PILP042_APAC_COMPOSITE_ACTION compositeAction = (PILP042_APAC_COMPOSITE_ACTION) utils
				.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		PT_IL_FUND_TRAN_HDR_ACTION actionBean = compositeAction
				.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN();
		PT_IL_FUND_TRAN_HDR valueBean = actionBean
				.getPT_IL_FUND_TRAN_HDR_BEAN();
		try {
			valueBean.setFTH_SWITCH_DT(utils.truncDate(utils.getCurrentDate()));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void pilp042_apac_pt_il_fund_tran_hdr_post_query() throws Exception {
		CommonUtils utils = new CommonUtils();
		PILP042_APAC_COMPOSITE_ACTION compositeAction = (PILP042_APAC_COMPOSITE_ACTION) utils
				.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		PT_IL_FUND_TRAN_HDR_ACTION actionBean = compositeAction
				.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN();
		PT_IL_FUND_TRAN_HDR valueBean = actionBean
				.getPT_IL_FUND_TRAN_HDR_BEAN();
		DBProcedures dbProcedures = new DBProcedures();
		Connection connection = null;
		connection = CommonUtils.getConnection();
		CRUDHandler handler = null;
		handler = new CRUDHandler();
		String M_POL_CUST_CODE = null;
		String M_POL_PROD_CODE = null;
		String M_CUST_NAME = null;
		String M_PROD_NAME = null;
		String M_FTH_APPRV_STATUS = null;
		double M_CNT1 = -1;
		double M_CNT2 = -1;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		try {
			String sql_C1 = PILP042_APAC_SQL_QUERY_CONSTANTS.PT_IL_FUND_TRAN_HDR_POST_QUERY_QUERY1;
			Object[] object1 = { actionBean.getCOMP_FTH_POL_NO()
					.getSubmittedValue() };
			resultSet1 = handler.executeSelectStatement(sql_C1, connection,
					object1);
			if (resultSet1.next()) {
				M_POL_CUST_CODE = resultSet1.getString(1);
				M_POL_PROD_CODE = resultSet1.getString(2);
			} else {
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "80251"));
			}
			CommonUtils.setGlobalVariable("GLOBAL.FLAG1", "1");
			/*ArrayList<String> list = dbProcedures.callP_VAL_CUST(
					M_POL_CUST_CODE, "N", "E", null);*/
			ArrayList<String> list = new LIFELIB().P_VAL_CUST(M_POL_CUST_CODE,
					M_CUST_NAME, "N", "N", null);
			if (list != null && list.size() > 0) {
				M_CUST_NAME = list.get(0);
			}

			String sql_C2 = PILP042_APAC_SQL_QUERY_CONSTANTS.PT_IL_FUND_TRAN_HDR_POST_QUERY_QUERY2;
			Object[] object2 = { M_POL_PROD_CODE };
			resultSet2 = handler.executeSelectStatement(sql_C2, connection,
					object2);
			if (resultSet2.next()) {
				M_PROD_NAME = resultSet2.getString(1);
			}
			valueBean.setUI_M_FTH_CUST_CODE(M_POL_CUST_CODE);
			actionBean.getCOMP_UI_M_FTH_CUST_CODE().resetValue();
			valueBean.setUI_M_FTH_PROD_CODE(M_POL_PROD_CODE);
			actionBean.getCOMP_UI_M_FTH_PROD_CODE().resetValue();
			valueBean.setUI_M_FTH_PROD_DESC(M_PROD_NAME);
			actionBean.getCOMP_UI_M_FTH_PROD_DESC().resetValue();
			valueBean.setUI_M_FTH_CUST_NAME(M_CUST_NAME);
			actionBean.getCOMP_UI_M_FTH_CUST_NAME().resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(resultSet1);
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void pilp042_apac_pt_il_fund_tran_hdr_when_new_record_instance()
			throws Exception {
		CommonUtils utils = new CommonUtils();
		PILP042_APAC_COMPOSITE_ACTION compositeAction = (PILP042_APAC_COMPOSITE_ACTION) utils
				.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		PT_IL_FUND_TRAN_HDR_ACTION actionBean = compositeAction
				.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN();
		PT_IL_FUND_TRAN_HDR valueBean = actionBean
				.getPT_IL_FUND_TRAN_HDR_BEAN();
		PT_IL_FUND_TRAN_DTL_1_ACTION dtl_1_actionBean = compositeAction
				.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN();
		PT_IL_FUND_TRAN_DTL_ACTION dtlAction = compositeAction
				.getPT_IL_FUND_TRAN_DTL_ACTION();
		DUMMY_ACTION dummyAction = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY dummyValue = dummyAction.getDUMMY_BEAN();
		DBProcedures dbProcedures = new DBProcedures();
		Connection connection = null;
		connection = CommonUtils.getConnection();
		CRUDHandler handler = null;
		handler = new CRUDHandler();
		String M_FTH_APPRV_STATUS = null;
		String M_FTH_APPRV_DT = null;
		double M_CNT1 = -1;
		double M_CNT2 = -1;
		String M_DUMMY = null;
		String M_DUMMY_1 = null;
		String M_PS_VALUE = null;
		String M_FTH_STATUS_CODE = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet4 = null;
		ResultSet resultSet5 = null;
		ResultSet resultSet6 = null;
		try {
			String sql_C4 = PILP042_APAC_SQL_QUERY_CONSTANTS.PT_IL_FUND_TRAN_HDR_WHEN_NEW_RECORD_INSTANCE_QUERY4;
			Object[] object4 = { valueBean.getFTH_SYS_ID() };
			resultSet4 = handler.executeSelectStatement(sql_C4, connection,
					object4);
			if (resultSet4.next()) {
				M_CNT1 = resultSet4.getDouble(1);
			}

			String sql_C5 = PILP042_APAC_SQL_QUERY_CONSTANTS.PT_IL_FUND_TRAN_HDR_WHEN_NEW_RECORD_INSTANCE_QUERY5;
			Object[] object5 = { valueBean.getFTH_SYS_ID() };
			resultSet5 = handler.executeSelectStatement(sql_C5, connection,
					object5);
			if (resultSet5.next()) {
				M_CNT2 = resultSet5.getDouble(1);
			}

			String sql_C3 = PILP042_APAC_SQL_QUERY_CONSTANTS.PT_IL_FUND_TRAN_HDR_WHEN_NEW_RECORD_INSTANCE_QUERY3;
			Object[] object3 = { valueBean.getFTH_SYS_ID() };
			resultSet3 = handler.executeSelectStatement(sql_C3, connection,
					object3);
			if (resultSet3.next()) {
				M_FTH_APPRV_STATUS = resultSet3.getString(1);
				M_FTH_APPRV_DT = resultSet3.getString(2);
				M_FTH_STATUS_CODE = resultSet3.getString(3);
			}

			if (M_FTH_APPRV_STATUS == "A") {
				dtl_1_actionBean.setUPDATE_ALLOWED(false);
				dtl_1_actionBean.setINSERT_ALLOWED(false);
				dtl_1_actionBean.setDELETE_ALLOWED(false);
				dtlAction.setUPDATE_ALLOWED(false);
				dtlAction.setINSERT_ALLOWED(false);
				dtlAction.setDELETE_ALLOWED(false);
				actionBean.setUPDATE_ALLOWED(false);
				actionBean.setINSERT_ALLOWED(false);
				actionBean.setDELETE_ALLOWED(false);
				actionBean.getCOMP_UI_M_GET_FUND().setDisabled(true);
				actionBean.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
				actionBean.getCOMP_UI_M_APPRV_STATUS().setRendered(false);
				actionBean.getCOMP_UI_M_APPRV_DT_LABEL().setRendered(false);
				actionBean.getCOMP_UI_M_STATUS_BUT().setDisabled(true);
				dummyValue.setUI_M_APPRV_STATUS("APPROVED");
				// actionBean.setCOMP_UI_M_APPRV_STATUS(dummyValue.getUI_M_APPRV_STATUS());
				// SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY.M_APPRV_STATUS",VISIBLE,PROPERTY_TRUE);
				// SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY.M_APPRV_DT",VISIBLE,PROPERTY_TRUE);
				// SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("PT_IL_FUND_TRAN_HDR.M_STATUS_BUT",ENABLED,PROPERTY_FALSE);
				// :DUMMY.M_APPRV_DT=ConvertFunctions.to_date(M_FTH_APPRV_DT,"DD/MM/RRRR");
				// :DUMMY.M_FTH_APPRV_USER_ID=:PT_IL_FUND_TRAN_HDR.FTH_APPRV_USER_ID;
			} else if ("N".equals(M_FTH_APPRV_STATUS) && M_CNT2 >= 0
					&& M_CNT1 > 0) {
				dtl_1_actionBean.setUPDATE_ALLOWED(true);
				dtl_1_actionBean.setINSERT_ALLOWED(true);
				dtl_1_actionBean.setDELETE_ALLOWED(true);
				actionBean.getCOMP_UI_M_GET_FUND().setDisabled(true);
				dtlAction.setUPDATE_ALLOWED(true);
				dtlAction.setINSERT_ALLOWED(true);
				dtlAction.setDELETE_ALLOWED(true);
				actionBean.setUPDATE_ALLOWED(true);
				actionBean.setINSERT_ALLOWED(true);
				actionBean.setDELETE_ALLOWED(true);
				actionBean.getCOMP_UI_M_APPRV_STATUS().setRendered(false);
				actionBean.getCOMP_UI_M_STATUS_BUT().setDisabled(false);
				actionBean.getCOMP_UI_M_BUT_APPROVE().setDisabled(false);
				dummyValue.setUI_M_APPRV_STATUS("NOT APPROVED");
				dummyValue.setUI_M_APPRV_DT(null);
				dummyValue.setUI_M_FTH_APPRV_USER_ID(actionBean
						.getPT_IL_FUND_TRAN_HDR_BEAN().getFTH_APPRV_USER_ID());

				/*
				 * :DUMMY.M_APPRV_STATUS="NOT APPROVED"; :DUMMY.M_APPRV_DT=null;
				 * :DUMMY.M_FTH_APPRV_USER_ID=:PT_IL_FUND_TRAN_HDR.FTH_APPRV_USER_ID;
				 */
			} else if ("N".equals(M_FTH_APPRV_STATUS) && M_CNT1 == 0) {
				dtl_1_actionBean.setUPDATE_ALLOWED(true);
				dtl_1_actionBean.setINSERT_ALLOWED(true);
				dtl_1_actionBean.setDELETE_ALLOWED(true);
				dtlAction.setUPDATE_ALLOWED(true);
				dtlAction.setINSERT_ALLOWED(true);
				dtlAction.setDELETE_ALLOWED(true);
				actionBean.setUPDATE_ALLOWED(true);
				actionBean.setINSERT_ALLOWED(true);
				actionBean.setDELETE_ALLOWED(true);
				actionBean.getCOMP_UI_M_GET_FUND().setDisabled(false);
				actionBean.getCOMP_UI_M_STATUS_BUT().setDisabled(true);
				dummyValue.setUI_M_APPRV_STATUS(null);
				dummyValue.setUI_M_APPRV_DT(null);
				dummyValue.setUI_M_FTH_APPRV_USER_ID(actionBean
						.getPT_IL_FUND_TRAN_HDR_BEAN().getFTH_APPRV_USER_ID());
			}
			String sql_C6 = PILP042_APAC_SQL_QUERY_CONSTANTS.PT_IL_FUND_TRAN_HDR_WHEN_NEW_RECORD_INSTANCE_QUERY6;
			Object[] object6 = { valueBean.getFTH_SYS_ID(),
					valueBean.getFTH_POL_SYS_ID() };
			resultSet6 = handler.executeSelectStatement(sql_C6, connection,
					object6);
			if (resultSet6.next()) {
				M_DUMMY_1 = resultSet6.getString(1);
			}
			if (M_DUMMY_1 != null && M_FTH_APPRV_STATUS != "A") {
				ArrayList<String> list = dbProcedures.callP_VAL_SYSTEM(
						"IL_TRAN_STAT", M_DUMMY_1, "N");
				if (list != null && list.size() > 0) {
					M_DUMMY = list.get(0);
					M_PS_VALUE = list.get(1);
				}
				// P_VAL_SYSTEM.P_VAL_SYSTEM("IL_TRAN_STAT",M_DUMMY_1,M_DUMMY,"N",M_PS_VALUE);
				dummyValue.setUI_M_APPRV_STATUS(M_DUMMY_1 + "" + ":" + ""
						+ M_DUMMY);
				// :DUMMY.M_APPRV_STATUS=M_DUMMY_1+""+":"+""+M_DUMMY;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(resultSet3);
				CommonUtils.closeCursor(resultSet4);
				CommonUtils.closeCursor(resultSet5);
				CommonUtils.closeCursor(resultSet6);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * ITEM_LEVEL_TRIGGERS
	 */

	public void pilp042_apac_fth_pol_no_when_validate_item() throws Exception {
		CommonUtils utils = new CommonUtils();
		Connection connection = null;
		connection = CommonUtils.getConnection();
		CRUDHandler handler = null;
		handler = new CRUDHandler();
		DBProcedures dbProcedures = new DBProcedures();
		PILP042_APAC_COMPOSITE_ACTION compositeAction = (PILP042_APAC_COMPOSITE_ACTION) utils
				.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		PT_IL_FUND_TRAN_HDR_ACTION actionBean = compositeAction
				.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN();
		PT_IL_FUND_TRAN_HDR valueBean = actionBean
				.getPT_IL_FUND_TRAN_HDR_BEAN();
		DUMMY_ACTION actionDummy = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY dummy = actionDummy.getDUMMY_BEAN();
		ResultSet resultSet1 = null;
		ResultSet resultSet6 = null;
		ResultSet resultSet7 = null;
		ResultSet resultSet5 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet4 = null;
		Long M_POL_SYS_ID = null;
		String M_POL_CUST_CODE = null;
		String M_POL_PROD_CODE = null;
		String M_POL_PREM_PAY_YRS = null;
		int M_DUMMY = 0;
		int M_WCS_NO_OF_TRANS = 0;
		Double M_WCS_RATE = 0d;
		Double M_WCS_RATE_PER = 0d;
		Double M_WCS_MIN_VALUE = 0d;
		Double M_WCS_MAX_VALUE = 0d;
		String M_FTH_APPRV_STATUS = null;
		String M_FTH_STATUS_CODE = null;
		String M_CUST_NAME = null;
		String M_PROD_NAME = null;
		int M_NO_OF_SW_FOR_THIS_POL = 0;

		try {
			String Query1 = PILP042_APAC_SQL_QUERY_CONSTANTS.FTH_POL_NO_WHEN_VAL_SELECT_QUERY1;
			System.out.println("POL_NO >>>>>>>>>>>>>>>>>>>:"
					+ actionBean.getCOMP_FTH_POL_NO().getSubmittedValue());
			Object[] object1 = { actionBean.getCOMP_FTH_POL_NO()
					.getSubmittedValue() };
			resultSet1 = handler.executeSelectStatement(Query1, connection,
					object1);

			if (resultSet1.next()) {
				M_POL_SYS_ID = resultSet1.getLong(1);
				M_POL_CUST_CODE = resultSet1.getString(2);
				M_POL_PROD_CODE = resultSet1.getString(3);
				dummy.setPOL_CUST_EXCH_RATE(resultSet1.getString(4));
				M_POL_PREM_PAY_YRS = resultSet1.getString(5);
			} else {
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "80251"));
			}
			if (actionBean.getCOMP_FTH_POL_NO().getSubmittedValue() != null) {
				String Query6 = PILP042_APAC_SQL_QUERY_CONSTANTS.FTH_POL_NO_WHEN_VAL_SELECT_QUERY6;
				Object[] object6 = { actionBean.getCOMP_FTH_POL_NO()
						.getSubmittedValue() };
				resultSet6 = handler.executeSelectStatement(Query6, connection,
						object6);
				if (resultSet6.next()) {
					M_DUMMY = resultSet6.getInt(1);
				}

				String Quert7 = PILP042_APAC_SQL_QUERY_CONSTANTS.FTH_POL_NO_WHEN_VAL_SELECT_QUERY7;
				Object[] object7 = { M_POL_PROD_CODE, M_POL_PREM_PAY_YRS };
				resultSet7 = handler.executeSelectStatement(Quert7, connection,
						object7);
				if (resultSet7.next()) {
					M_WCS_NO_OF_TRANS = resultSet7.getInt(1);
					M_WCS_RATE = resultSet7.getDouble(2);
					M_WCS_RATE_PER = resultSet7.getDouble(3);
					M_WCS_MIN_VALUE = resultSet7.getDouble(4);
					M_WCS_MAX_VALUE = resultSet7.getDouble(5);
				}else{
					/*Modified by pidugu raj dt: 08-10-2018 as per sivaraman suggestion
					 * throw new Exception("Setup not defined ");*/
					throw new Exception("Switching Charge Setup not defined ");
					/*End*/
				}
				if (M_DUMMY < (MigratingFunctions.nvl(M_WCS_NO_OF_TRANS,
						M_DUMMY))) {
					actionBean.getPT_IL_FUND_TRAN_HDR_BEAN().setFTH_FEE_LC_AMT(
							0.0);
			
				} else {
					
					  actionBean.getPT_IL_FUND_TRAN_HDR_BEAN().setFTH_FEE_LC_AMT(
					  M_WCS_RATE / M_WCS_RATE_PER);
					 // actionBean.getCOMP_FTH_FEE_LC_AMT().resetValue();
					  /*if(!(actionBean.getPT_IL_FUND_TRAN_HDR_BEAN().getFTH_FEE_LC_AMT() >= M_WCS_MIN_VALUE && actionBean
					  .getPT_IL_FUND_TRAN_HDR_BEAN().getFTH_FEE_LC_AMT() <=
					  M_WCS_MAX_VALUE)) {
					  actionBean.getPT_IL_FUND_TRAN_HDR_BEAN()
					  .setFTH_FEE_LC_AMT(null);  
					  throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"90010",new 
					  Object[]{"SWITCHING FEE",M_WCS_MIN_VALUE,M_WCS_MAX_VALUE})); }
					 */
				}
				actionBean.getCOMP_FTH_FEE_LC_AMT().resetValue();
				String Query5 = PILP042_APAC_SQL_QUERY_CONSTANTS.FTH_POL_NO_WHEN_VAL_SELECT_QUERY5;
				Object[] object5 = { actionBean.getCOMP_FTH_POL_NO()
						.getSubmittedValue() };
				resultSet5 = handler.executeSelectStatement(Query5, connection,
						object5);
				if (resultSet5.next()) {
					M_FTH_APPRV_STATUS = resultSet5.getString(1);
					M_FTH_STATUS_CODE = resultSet5.getString(2);
				}

				if ("A".equals(MigratingFunctions.nvl(M_FTH_APPRV_STATUS, "A"))) {
					/*ArrayList<String> list = dbProcedures.helperP_VAL_CUST(
							M_POL_CUST_CODE, "N", "E");*/
					ArrayList<String> list = new LIFELIB().P_VAL_CUST(M_POL_CUST_CODE,
							M_CUST_NAME, "N", "N", null);
					if (list != null && list.size() > 0) {
						M_CUST_NAME = list.get(0);
					}
				} else if ("N".equals(MigratingFunctions.nvl(
						M_FTH_APPRV_STATUS, "N"))
						&& !"D".equals(MigratingFunctions.nvl(
								M_FTH_STATUS_CODE, "N"))
						&& !"R".equals(MigratingFunctions.nvl(
								M_FTH_STATUS_CODE, "N"))) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91433",
							new Object[] { actionBean.getCOMP_FTH_POL_NO()
									.getSubmittedValue() }));
				}

				String Query2 = PILP042_APAC_SQL_QUERY_CONSTANTS.FTH_POL_NO_WHEN_VAL_SELECT_QUERY2;
				Object[] object2 = { M_POL_PROD_CODE };
				resultSet2 = handler.executeSelectStatement(Query2, connection,
						object2);
				if (resultSet2.next()) {
					M_PROD_NAME = resultSet2.getString(1);
				}

				String Query4 = PILP042_APAC_SQL_QUERY_CONSTANTS.FTH_POL_NO_WHEN_VAL_SELECT_QUERY4;
				Object[] object4 = { actionBean.getCOMP_FTH_POL_NO()
						.getSubmittedValue() };
				resultSet4 = handler.executeSelectStatement(Query4, connection,
						object4);
				if (resultSet4.next()) {
					M_NO_OF_SW_FOR_THIS_POL = resultSet4.getInt(1);
				}
				valueBean.setUI_M_FTH_CUST_CODE(M_POL_CUST_CODE);
				actionBean.getCOMP_UI_M_FTH_CUST_CODE().resetValue();
				valueBean.setUI_M_FTH_CUST_NAME(M_CUST_NAME);
				actionBean.getCOMP_UI_M_FTH_CUST_NAME().resetValue();
				System.out.println("CUST_NAME :"
						+ valueBean.getUI_M_FTH_CUST_NAME());
				valueBean.setUI_M_FTH_PROD_CODE(M_POL_PROD_CODE);
				actionBean.getCOMP_UI_M_FTH_PROD_CODE().resetValue();
				valueBean.setUI_M_FTH_PROD_DESC(M_PROD_NAME);
				actionBean.getCOMP_UI_M_FTH_PROD_DESC().resetValue();
				valueBean.setFTH_POL_SYS_ID(M_POL_SYS_ID);
				valueBean.setFTH_SEQ_NO(M_NO_OF_SW_FOR_THIS_POL);
				actionBean.getCOMP_FTH_SEQ_NO().resetValue();
				valueBean.setFTH_SWITCH_DT(new Date());
				actionBean.getCOMP_UI_M_GET_FUND().setDisabled(false);
				pilp042_apac_pt_il_fund_tran_hdr_post_query();
			} else {
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "71153"));
			}
			CommonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID", M_POL_SYS_ID.toString());
		} catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet1);
				CommonUtils.closeCursor(resultSet2);
				CommonUtils.closeCursor(resultSet4);
				CommonUtils.closeCursor(resultSet5);
				CommonUtils.closeCursor(resultSet6);
				CommonUtils.closeCursor(resultSet7);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Switch_Date
	 */

	public void pilp042_apac_pt_il_fund_tran_hdr_fth_switch_dt_when_validate_item()
			throws Exception {
		CommonUtils utils = new CommonUtils();
		PILP042_APAC_COMPOSITE_ACTION compositeAction = (PILP042_APAC_COMPOSITE_ACTION) utils
				.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		PT_IL_FUND_TRAN_HDR_ACTION actionBean = compositeAction
				.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN();
		PT_IL_FUND_TRAN_HDR valueBean = actionBean
				.getPT_IL_FUND_TRAN_HDR_BEAN();
		try {
			if (actionBean.getCOMP_FTH_SWITCH_DT().getAsDate(
					actionBean.getCOMP_FTH_SWITCH_DT().getSubmittedValue())
					.before(utils.truncDate(new Date()))) {
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "91064"));
			}
			actionBean.getCOMP_UI_M_GET_FUND().setDisabled(false);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/*
	 * Switch_Fee
	 */

	public void pilp042_apac_pt_il_fund_tran_hdr_fth_fee_lc_amt_when_validate_item()
			throws Exception {
		CommonUtils utils = new CommonUtils();
		Connection connection = null;
		connection = CommonUtils.getConnection();
		CRUDHandler handler = null;
		handler = new CRUDHandler();
		PILP042_APAC_COMPOSITE_ACTION compositeAction = (PILP042_APAC_COMPOSITE_ACTION) utils
				.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		PT_IL_FUND_TRAN_HDR_ACTION actionBean = compositeAction
				.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN();

		Double M_WCS_MIN_VALUE = 0d;
		Double M_WCS_MAX_VALUE = 0d;
		Double M_POL_PREM_PAY_YRS = 0d;
		String M_POL_PROD_CODE = null;
		Double M_WCS_NO_OF_TRANS = 0d;
		double M_DUMMY = -1;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		try {
			String sql_C2 = PILP042_APAC_SQL_QUERY_CONSTANTS.FTH_FEE_LC_AMT_WHEN_VAL_SELECT_QUERY2;
			System.out.println("polcy no is :"
					+ actionBean.getCOMP_FTH_POL_NO().getSubmittedValue());
			Object[] object2 = { actionBean.getCOMP_FTH_POL_NO()
					.getSubmittedValue() };
			resultSet2 = handler.executeSelectStatement(sql_C2, connection,
					object2);
			if (resultSet2.next()) {
				M_POL_PREM_PAY_YRS = resultSet2.getDouble(1);
				System.out.println("premium pay years :" + M_POL_PREM_PAY_YRS);
				M_POL_PROD_CODE = resultSet2.getString(2);
				System.out.println("M_POL_PROD_CODE :" + M_POL_PROD_CODE);
			}

			String sql_C1 = PILP042_APAC_SQL_QUERY_CONSTANTS.FTH_FEE_LC_AMT_WHEN_VAL_SELECT_QUERY1;
			Object[] object1 = { M_POL_PROD_CODE, M_POL_PREM_PAY_YRS };
			resultSet1 = handler.executeSelectStatement(sql_C1, connection,
					object1);
			if (resultSet1.next()) {
				M_WCS_MIN_VALUE = resultSet1.getDouble(1);
				System.out.println("M_WCS_MIN_VALUE :" + M_WCS_MIN_VALUE);
				M_WCS_MAX_VALUE = resultSet1.getDouble(2);
				System.out.println("M_WCS_MAX_VALUE :" + M_WCS_MAX_VALUE);
				M_WCS_NO_OF_TRANS = resultSet1.getDouble(3);
				System.out.println("M_WCS_NO_OF_TRANS :" + M_WCS_NO_OF_TRANS);
			}

			String sql_C3 = PILP042_APAC_SQL_QUERY_CONSTANTS.FTH_FEE_LC_AMT_WHEN_VAL_SELECT_QUERY3;
			Object[] object3 = { actionBean.getCOMP_FTH_POL_NO()
					.getSubmittedValue() };
			resultSet3 = handler.executeSelectStatement(sql_C3, connection,
					object3);
			if (resultSet3.next()) {
				M_DUMMY = resultSet3.getDouble(1);
				System.out.println("M_DUMMY" + M_DUMMY);
			}

			if (M_DUMMY > 0.0) {
				if ((M_DUMMY < MigratingFunctions.nvl(M_WCS_NO_OF_TRANS,
						M_DUMMY) && Double.parseDouble(actionBean
						.getCOMP_FTH_FEE_LC_AMT().getSubmittedValue()
						.toString()) != 0.0)
						|| M_DUMMY > MigratingFunctions.nvl(M_WCS_NO_OF_TRANS,
								M_DUMMY)) {

					if (M_WCS_MIN_VALUE != 0 && M_WCS_MAX_VALUE != 0) {
						if (!(Double.parseDouble(actionBean
								.getCOMP_FTH_FEE_LC_AMT().getSubmittedValue()
								.toString()) >= M_WCS_MIN_VALUE && (Double
								.parseDouble(actionBean
										.getCOMP_FTH_FEE_LC_AMT()
										.getSubmittedValue().toString()) <= M_WCS_MAX_VALUE))) {
							
							actionBean.getPT_IL_FUND_TRAN_HDR_BEAN().setFTH_FEE_LC_AMT(null);
							throw new ValidatorException(Messages.getMessage(
									PELConstants.pelErrorMessagePath, "90010",
									new Object[] { "SWITCHING FEE",
											M_WCS_MIN_VALUE, M_WCS_MAX_VALUE }));
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(resultSet1);
				CommonUtils.closeCursor(resultSet2);
				CommonUtils.closeCursor(resultSet3);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Long preInsertValidation() throws Exception {

		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		Long sysId = null;
		ResultSet resultSet = null;
		try {

			String query = "SELECT P9IL_FTH_SYS_ID.NEXTVAL FROM  DUAL  ";
			Object[] objects = {};

			resultSet = handler.executeSelectStatement(query, connection,
					objects);
			if (resultSet.next()) {
				sysId = resultSet.getLong(1);
				System.out.println("Sys Id: " + sysId);
			}
			if (resultSet.isAfterLast() || resultSet.isBeforeFirst()) {
				System.out.println("Cannot Generate System id");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
		return sysId;
	}

	/*
	 * M_GET_FUND_WHEN_BUTTON_PRESSED
	 */
	public void pilp042_apac_pt_il_fund_tran_hdr_m_get_fund_when_button_pressed() {
		CommonUtils utils = new CommonUtils();
		PILP042_APAC_COMPOSITE_ACTION compositeAction = (PILP042_APAC_COMPOSITE_ACTION) utils
				.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		PT_IL_FUND_TRAN_HDR_ACTION actionBean = compositeAction
				.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN();
		PT_IL_FUND_TRAN_HDR valueBean = actionBean
				.getPT_IL_FUND_TRAN_HDR_BEAN();
		DUMMY_ACTION dummyAction = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY dummyValue = dummyAction.getDUMMY_BEAN();
		DBProcedures dbProcedures = new DBProcedures();
		String M_WHERE = null;

		try {
			compositeAction.getControlBean().setM_COMM_DEL("P");
			compositeAction.getControlBean().setM_COMM_DEL(null);
			dbProcedures.callP9ILPK_FUND_ALLOC_P_INS_FUND_TRAN_DTL(valueBean
					.getFTH_POL_SYS_ID()
					+ "", valueBean.getFTH_SYS_ID() + "", CommonUtils
					.dateToStringFormatter(valueBean.getFTH_SWITCH_DT()));
			M_WHERE = " FTD_SELECT_YN IS NOT NULL ";
			dummyValue.setUI_M_APPRV_STATUS("NOT APPROVED");
			dummyValue.setUI_M_APPRV_DT(null);
			actionBean.getCOMP_UI_M_GET_FUND().setDisabled(true);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	/*
	 * M_BUT_APPROVE_WHEN_BUTTON_PRESSED
	 */
	public void pilp042_apac_pt_il_fund_tran_hdr_m_but_approve_when_button_pressed()
			throws Exception {
		String M_WHERE = null;
		String M_WHERE1 = null;
		DBProcedures dbProcedures = new DBProcedures();
		CommonUtils utils = new CommonUtils();
		PILP042_APAC_COMPOSITE_ACTION compositeAction = (PILP042_APAC_COMPOSITE_ACTION) utils
				.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		PT_IL_FUND_TRAN_HDR_ACTION actionBean = compositeAction
				.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN();
		PT_IL_FUND_TRAN_DTL_1_ACTION dtl_1_actionBean = compositeAction
				.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN();
		PT_IL_FUND_TRAN_DTL_ACTION dtlAction = compositeAction
				.getPT_IL_FUND_TRAN_DTL_ACTION();
		PT_IL_FUND_TRAN_HDR valueBean = actionBean
				.getPT_IL_FUND_TRAN_HDR_BEAN();
		DUMMY_ACTION dummyAction = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY dummyValue = dummyAction.getDUMMY_BEAN();

		L_CHECK_NEXT_PRICING_DATE();

		dbProcedures.callP9ILPK_FUND_ALLOC_P_TRANS_FUND_REG_HDR_DTL(valueBean
				.getFTH_SYS_ID()
				+ "", valueBean.getFTH_POL_SYS_ID() + "", "H");
		M_WHERE = null;
		M_WHERE1 = null;
		M_WHERE = " FTD_TRAN_SYS_ID = " + valueBean.getFTH_SYS_ID()
				+ " AND  FTD_SELECT_YN IS NULL";
		M_WHERE1 = " FTH_SYS_ID = " + valueBean.getFTH_SYS_ID();
		dtlAction.setDELETE_ALLOWED(false);
		dtlAction.setUPDATE_ALLOWED(false);
		dtlAction.setINSERT_ALLOWED(false);
		actionBean.setUPDATE_ALLOWED(false);
		actionBean.setINSERT_ALLOWED(false);
		dtl_1_actionBean.setUPDATE_ALLOWED(false);
		dtl_1_actionBean.setINSERT_ALLOWED(false);
		compositeAction.getControlBean().setM_COMM_DEL("C");
		utils.doComitt();
		compositeAction.getControlBean().setM_COMM_DEL(null);

		M_WHERE = " FTD_SELECT_YN IS NULL";
		M_WHERE1 = null;
		compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION().getWarningMap().put(
				"current", "Approved");
		compositeAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN()
				.getPT_IL_FUND_TRAN_HDR_BEAN().setFTH_APPRV_STATUS("Approved");

	}

	/**
	 * @throws Exception
	 */
	public void L_CHECK_NEXT_PRICING_DATE() throws Exception {
		System.out.println("INSIDE NEXT PRICING DATE");
		String M_FTH_STATUS_CODE = null;
		String M_FTD_FUND_CODE = null;
		String M_UNIT_RATE = null;
		String M_FTD_TRAN_FLAG = null;
		double M_COUNT_FTD_FUND_CODE = -1;
		String M_SUM_MIN_BAL = null;
		PILP042_APAC_COMPOSITE_ACTION compAction = (PILP042_APAC_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		PT_IL_FUND_TRAN_HDR headerValueBean = compAction
				.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN()
				.getPT_IL_FUND_TRAN_HDR_BEAN();
		double FTD_POL_SYS_ID = headerValueBean.getFTH_POL_SYS_ID();
		double FTH_SYS_ID = headerValueBean.getFTH_SYS_ID();
		String FTH_POL_NO = headerValueBean.getFTH_POL_NO();
		String sql_C1 = "SELECT FTD_FUND_CODE,FTD_TRAN_FLAG "
				+ "FROM  PT_IL_FUND_TRAN_DTL  " + "WHERE  FTD_POL_SYS_ID  =? "
				+ "AND FTD_TRAN_TYPE  = 'H'  AND FTD_TRAN_FLAG  = 'S'  "
				+ "AND FTD_SELECT_YN  = 'Y' "
				+ "UNION  SELECT    FTD_FUND_CODE,FTD_TRAN_FLAG "
				+ "FROM  PT_IL_FUND_TRAN_DTL  " + "WHERE  FTD_POL_SYS_ID=?  "
				+ "AND FTD_TRAN_TYPE  = 'H'  AND FTD_TRAN_FLAG  = 'B'   ";
		Object value1[] = { FTD_POL_SYS_ID, FTD_POL_SYS_ID };
		ResultSet vembu_C1 = null;
		String sql_C2 = "SELECT FTH_STATUS_CODE "
				+ "FROM  PT_IL_FUND_TRAN_HDR  " + "WHERE  FTH_SYS_ID=? "
				+ "AND FTH_POL_SYS_ID=? ";

		Object value2[] = { FTD_POL_SYS_ID, FTD_POL_SYS_ID };
		// Object value2[] = {FTD_POL_SYS_ID,FTD_POL_SYS_ID };
		ResultSet vembu_C2 = null;
		String M_FS_SW_MAX_NO = null;
		double M_TOT_NO_SW = -1;
		String sql_C3 = "SELECT FS_SW_MAX_NO " + "FROM  PM_IL_FUND_SETUP  "
				+ "WHERE  FS_CODE  = '" + M_FTD_FUND_CODE + "'";
		ResultSet vembu_C3 = null;
		String sql_C4 = "SELECT COUNT(FTD_FUND_CODE) "
				+ "FROM  PT_IL_FUND_TRAN_HDR,PT_IL_FUND_TRAN_DTL  "
				+ "WHERE  FTH_SYS_ID  = FTD_TRAN_SYS_ID  "
				+ "AND FTH_POL_NO  =? "
				+ "AND FTD_FUND_CODE=?"
				+ "  AND FTD_TRAN_TYPE='H' "
				+ "AND FTH_APPRV_STATUS='A' "
				+ "AND FTD_TRAN_FLAG  = 'S' GROUP BY FTD_FUND_CODE,FTH_SWITCH_DT";
		ResultSet vembu_C4 = null;
		Object value4[] = { FTH_POL_NO, M_FTD_FUND_CODE };
		String sql_C5 = "SELECT FTD_FUND_CODE " + "FROM  PT_IL_FUND_TRAN_DTL  "
				+ "WHERE  FTD_POL_SYS_ID  =? " + "AND FTD_TRAN_SYS_ID  =? "
				+ "AND FTD_TRAN_TYPE  = 'H'  AND FTD_TRAN_FLAG  = 'S' "
				+ "AND FTD_SELECT_YN  = 'Y' GROUP BY  FTD_FUND_CODE  ";
		ResultSet vembu_C5 = null;
		Object value5[] = { FTD_POL_SYS_ID, FTH_SYS_ID };
		Connection vembu_conn = null;
		CRUDHandler handler = new CRUDHandler();

		String switchDate = CommonUtils.dateToStringFormatter(headerValueBean
				.getFTH_SWITCH_DT());

		try {
			System.out.println("INSIDE TRY");
			vembu_conn = CommonUtils.getConnection();
			vembu_C5 = handler.executeSelectStatement(sql_C5, vembu_conn,
					value5);
			System.out.println("vembu5" + vembu_C5);
			while (vembu_C5.next()) {
				M_FTD_FUND_CODE = vembu_C5.getString(1);
				System.out.println("M_FTD_FUND_CODE :" + M_FTD_FUND_CODE);
			}
			vembu_C3 = handler.executeSelectStatement(sql_C3, vembu_conn);
			System.out.println("vembu3" + vembu_C3);
			if (vembu_C3.next()) {
				M_FS_SW_MAX_NO = vembu_C3.getString(1);
				System.out.println("M_FS_SW_MAX_NO :" + M_FS_SW_MAX_NO);
			}
			System.out.println("vembu3" + vembu_C4);
			vembu_C4 = handler.executeSelectStatement(sql_C4, vembu_conn,
					value4);
			if (vembu_C4.next()) {
				M_TOT_NO_SW = vembu_C4.getDouble(1);
				System.out.println("M_TOT_NO_SW :" + M_TOT_NO_SW);
			}
			if (M_FS_SW_MAX_NO != null) {
				if (M_TOT_NO_SW >= MigratingFunctions.nvl(Double
						.parseDouble(M_FS_SW_MAX_NO), 0)) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91459"));
				}
			}
			vembu_C2 = handler.executeSelectStatement(sql_C2, vembu_conn,
					value2);
			if (vembu_C2.next()) {
				M_FTH_STATUS_CODE = vembu_C2.getString(1);
				System.out.println("M_FTH_STATUS_CODE :" + M_FTH_STATUS_CODE);
			}
			vembu_C1 = handler.executeSelectStatement(sql_C1, vembu_conn,
					value1);
			{
				if (vembu_C1.next()) {
					M_FTD_FUND_CODE = vembu_C1.getString(1);
					M_FTD_TRAN_FLAG = vembu_C1.getString(2);
				}
				if (vembu_C1.next()) {
					DBProcedures procedures = new DBProcedures();
					M_UNIT_RATE = procedures
							.callPKG_PILP042_APAC_P_GET_UNIT_PRICE(
									M_FTD_FUND_CODE, switchDate, "S",
									M_FTD_TRAN_FLAG);
					System.out.println("M_UNIT_RATE:" + M_UNIT_RATE);

				}
				if (M_UNIT_RATE != null) {

					if (MigratingFunctions.nvl(Double.parseDouble(M_UNIT_RATE),
							0) > 0) {
						System.out.println("AL Bil");
					} else {
						Object value[] = { "NEXT PRICING DATE",
								"AVAILABLE FOR THE FUND", M_FTD_FUND_CODE };
						throw new ValidatorException(Messages.getMessage(
								PELConstants.pelErrorMessagePath, "91014",
								value));

					}
				}
			}

		}

		finally {
			if (vembu_C1 != null) {
				try {
					vembu_C1.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (vembu_C2 != null) {
				try {
					vembu_C2.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (vembu_C3 != null) {
				try {
					vembu_C3.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (vembu_C4 != null) {
				try {
					vembu_C4.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (vembu_C5 != null) {
				try {
					vembu_C5.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * M_STATUS_BUT-WHEN-BUTTON-PRESSED
	 */

	public void pilp042_apac_pt_il_fund_tran_hdr_m_status_but_when_button_pressed()
			throws Exception {
		CommonUtils utils = new CommonUtils();
		PILP042_APAC_COMPOSITE_ACTION compositeAction = (PILP042_APAC_COMPOSITE_ACTION) utils
				.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		DUMMY_ACTION dummyAction = compositeAction.getDUMMY_ACTION_BEAN();
		DUMMY dummyValue = dummyAction.getDUMMY_BEAN();
		try {
			/*
			 * if(:SYSTEM.FORM_STATUS=="CHANGED" && :DUMMY.M_WD_STATUS_CODE !=
			 * null){
			 * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(71048,:GLOBAL.M_LANG_CODE);
			 * throw new FORM_TRIGGER_FAILURE(); }
			 */
			dummyValue.setM_WD_STATUS_DT(utils.getCurrentDate());
			dummyValue.setM_WD_STATUS_CODE(null);
			dummyValue.setM_WD_REASON_CODE(null);
			dummyValue.setM_WD_REMARKS(null);
			dummyValue.setM_WD_STATUS_CODE_DESC(null);
			dummyValue.setM_WD_REASON_CODE_DESC(null);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
