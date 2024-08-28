package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.LIFELIB;
import com.iii.pel.utils.PKG_PILQ003;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_SURR_MAT_VALUES_HELPER {

	public void executeQuery(PILQ003_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try{
		new PT_IL_SURR_MAT_VALUES_DELEGATE()
				.executeSelectStatement(compositeAction);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenNewBlockInstance(
			PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_SURR_MAT_VALUES_ACTION matValuesAction = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN();
		PT_IL_SURR_MAT_VALUES matValuesBean = matValuesAction
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN();
		try {
			executeQuery(compositeAction);
			matValuesAction.getCOMP_SMV_FC_RED_SA_LABEL().setRendered(true);
			matValuesAction.getCOMP_SMV_LC_RED_SA_LABEL().setRendered(true);
			matValuesAction.getCOMP_SMV_FC_ACC_PROFIT_LABEL().setRendered(true);
			matValuesAction.getCOMP_SMV_LC_ACC_PROFIT_LABEL().setRendered(true);
			// TODO:This component not found
			// SET_ITEM_PROPERTY ('BP.B_SURR_PROFIT', DISPLAYED, PROPERTY_TRUE);
			// SET_ITEM_PROPERTY ('BP.B_SURR_POL', DISPLAYED, PROPERTY_TRUE);
			if ("S".equals(policyBean.getPOL_STATUS())
					|| "M".equals(policyBean.getPOL_STATUS())) {
				matValuesAction.getCOMP_SMV_FC_RED_SA_LABEL()
						.setRendered(false);
				matValuesAction.getCOMP_SMV_LC_RED_SA_LABEL()
						.setRendered(false);
				matValuesAction.getCOMP_SMV_FC_ACC_PROFIT_LABEL().setRendered(
						false);
				matValuesAction.getCOMP_SMV_LC_ACC_PROFIT_LABEL().setRendered(
						false);
			} else if ("P".equals(policyBean.getPOL_STATUS())) {
				// TODO:This component not found
				// SET_ITEM_PROPERTY ('BP.B_SURR_PROFIT', DISPLAYED,
				// PROPERTY_TRUE);
				// SET_ITEM_PROPERTY ('BP.B_SURR_POL', DISPLAYED,
				// PROPERTY_TRUE);

			}
			if ("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE")
					.substring(1, 2))) {
				matValuesAction.setUPDATE_ALLOWED(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void postQuery(PT_IL_POLICY policyBean,
			PT_IL_SURR_MAT_VALUES matValuesBean) throws Exception {
		String CURSOR_C1 = "SELECT SMV_FC_CHARGE_AMT, SMV_LC_CHARGE_AMT FROM PT_IL_SURR_MAT_VALUES WHERE SMV_POL_SYS_ID =  ? ";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		PKG_PILQ003 localProcedure = new PKG_PILQ003();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { policyBean.getPOL_SYS_ID() });
			if (resultSet.next()) {
				matValuesBean.setUI_M_FC_TOT_CHARGE(resultSet.getDouble(1));
				matValuesBean.setUI_M_LC_TOT_CHARGE(resultSet.getDouble(2));
			} else {
				matValuesBean.setUI_M_FC_TOT_CHARGE(0.00);
				matValuesBean.setUI_M_LC_TOT_CHARGE(0.00);
			}
			CommonUtils.closeCursor(resultSet);
			localProcedure.IL_ENDT_003_004_FINAL_NET_VAL(matValuesBean,
					policyBean);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
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

	}

	public void preInsert(PT_IL_SURR_MAT_VALUES matValuesBean, CTRL ctrlBean,PT_IL_POLICY policyBean)
			throws Exception {

		String CURSOR_C1 = "SELECT PIL_SMV_SYS_ID.NEXTVAL FROM   DUAL ";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection);
			if (resultSet.next()) {
				matValuesBean.setSMV_SYS_ID(resultSet.getLong(1));
			}
			CommonUtils.closeCursor(resultSet);
			matValuesBean.setSMV_POL_SYS_ID(policyBean.getPOL_SYS_ID());
			matValuesBean.setSMV_CR_DT(new CommonUtils().getCurrentDate());
			matValuesBean.setSMV_CR_UID(ctrlBean.getUSER_ID());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
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

	}

	public void preQuery(PILQ003_COMPOSITE_ACTION compositeAction) {
		Long POL_SYS_ID = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN().getPOL_SYS_ID();
		/*compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.setDEFAULT_WHERE("SMV_STATUS_CODE <> 'R' ");*/
		compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN().setSMV_POL_SYS_ID(POL_SYS_ID);
	}

	public void preUpdate(PT_IL_SURR_MAT_VALUES matValueBean,
			PT_IL_POLICY policyBean, CTRL ctrlBean) throws Exception {

		String UPDATE_QUERY = "UPDATE PT_IL_SURR_PROFIT SET  SP_LC_SURR_PROFIT = ? , SP_FC_SURR_PROFIT = ?"
				+ "WHERE  SP_POL_SYS_ID = ? AND    SP_SURR_DT    = ? ";
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			if ("P".equals(policyBean.getUI_M_SURR_MAT())) {
				policyBean.setPOL_FC_CURR_SA(matValueBean
						.getSMV_FC_GROSS_VALUE());
				policyBean.setPOL_LC_CURR_SA(matValueBean
						.getSMV_LC_GROSS_VALUE());
			}
			if ("S".equals(policyBean.getUI_M_SURR_MAT())) {
				handler.executeUpdateStatement(UPDATE_QUERY, connection,
						new Object[] { matValueBean.getSMV_FC_ACC_PROFIT(),
								matValueBean.getSMV_LC_ACC_PROFIT(),
								policyBean.getPOL_SYS_ID(),
								matValueBean.getSMV_DATE() });
			}
			matValueBean.setSMV_UPD_DT(new CommonUtils().getCurrentDate());
			matValueBean.setSMV_UPD_UID(ctrlBean.getUSER_ID());

		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void SMV_FC_RED_SA_WHEN_VALIDATE_ITEM(
			PT_IL_SURR_MAT_VALUES matValuesBean, PT_IL_POLICY policyBean,
			DUMMY dummyBean) throws Exception {
		//DBProcedures procedures = new DBProcedures();
		PKG_PILQ003 procedures = new PKG_PILQ003();
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		try {
			list = procedures.P_VAL_ROUND_AMT(policyBean
					.getPOL_SA_CURR_CODE(), CommonUtils.getProcedureValue(matValuesBean.getSMV_FC_RED_SA())
					, "V");
			if(list != null && !list.isEmpty()){
				if(list.get(0) != null){
				System.out.println(list.get(0));
			matValuesBean.setSMV_FC_RED_SA(Double.parseDouble(list.get(0)));
			matValuesBean.setSMV_LC_RED_SA(matValuesBean.getSMV_FC_RED_SA()
					* policyBean.getPOL_SA_EXCH_RATE());
				}
			}
			list1 = procedures.P_VAL_ROUND_AMT(dummyBean
					.getUI_M_BASE_CURR(),CommonUtils.getProcedureValue(	matValuesBean.getSMV_LC_RED_SA())
					, "R");
			if(list1 != null && !list1.isEmpty()){
				if(list1.get(0) != null){
			matValuesBean.setSMV_LC_RED_SA(Double.parseDouble(list1.get(0)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void SMV_LC_RED_SA_WHEN_VALIDATE_ITEM(
			PT_IL_SURR_MAT_VALUES matValuesBean, PT_IL_POLICY policyBean,
			DUMMY dummyBean) throws Exception {
		PKG_PILQ003 localProcedure = new PKG_PILQ003();
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> list = null;
		//ArrayList<String> list1 = null;
		try {
			list = localProcedure.P_VAL_ROUND_AMT(dummyBean
					.getUI_M_BASE_CURR(),CommonUtils.getProcedureValue(matValuesBean.getSMV_LC_RED_SA())
					, "V");
			if(list != null && !list.isEmpty()){
				if(list.get(0) != null){
				matValuesBean.setSMV_LC_RED_SA(Double.parseDouble(list.get(0)));
				}
			}

			procedures.callP_VAL_FC_LC_TOLERANCE(CommonUtils.getProcedureValue(matValuesBean
					.getSMV_FC_RED_SA()),CommonUtils.getProcedureValue(matValuesBean
					.getSMV_LC_RED_SA()),CommonUtils.getProcedureValue(policyBean
					.getPOL_SA_EXCH_RATE()), "E");
			if(matValuesBean.getSMV_FC_ACC_PROFIT() != null){
			matValuesBean.setSMV_FC_GROSS_VALUE(matValuesBean
					.getSMV_FC_RED_SA()
					+ matValuesBean.getSMV_FC_ACC_PROFIT());
			}
			if( matValuesBean.getSMV_LC_ACC_PROFIT() != null){
			matValuesBean.setSMV_LC_GROSS_VALUE(matValuesBean
					.getSMV_LC_RED_SA()
					+ matValuesBean.getSMV_LC_ACC_PROFIT());
			}

			localProcedure.IL_ENDT_003_004_FINAL_NET_VAL(matValuesBean,
					policyBean);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void SMV_FC_ACC_PROFIT_WHEN_VALIDATE_ITEM(
			PT_IL_SURR_MAT_VALUES matValuesBean, PT_IL_POLICY policyBean,
			DUMMY dummyBean) throws Exception {
		//DBProcedures procedures = new DBProcedures();
		PKG_PILQ003 procedures = new PKG_PILQ003();
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		try {
			list = procedures.P_VAL_ROUND_AMT(policyBean
					.getPOL_SA_CURR_CODE(), CommonUtils.getProcedureValue(matValuesBean
					.getSMV_FC_ACC_PROFIT()), "V");
			if(list != null && !list.isEmpty()){
				if(list.get(0) != null){
			matValuesBean.setSMV_FC_ACC_PROFIT(Double.parseDouble(list.get(0)));
					}
				}
			matValuesBean.setSMV_LC_ACC_PROFIT(matValuesBean
					.getSMV_FC_ACC_PROFIT()
					* policyBean.getPOL_SA_EXCH_RATE());
			list1 = procedures.P_VAL_ROUND_AMT(dummyBean
					.getUI_M_BASE_CURR(), CommonUtils.getProcedureValue(matValuesBean.getSMV_LC_ACC_PROFIT())
					, "R");
			if(list1 != null && !list1.isEmpty()){
				if(list1.get(0) != null){
			matValuesBean
					.setSMV_LC_ACC_PROFIT(Double.parseDouble(list1.get(0)));
				}
				}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void SMV_LC_ACC_PROFIT_WHEN_VALIDATE_ITEM(
			PT_IL_SURR_MAT_VALUES matValuesBean, PT_IL_POLICY policyBean,
			DUMMY dummyBean) throws Exception {
		PKG_PILQ003 localProcedure = new PKG_PILQ003();
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> list = null;
	//	ArrayList<String> list1 = null;
		try {
			list = localProcedure.P_VAL_ROUND_AMT(dummyBean
					.getUI_M_BASE_CURR(), CommonUtils.getProcedureValue(matValuesBean.getSMV_LC_ACC_PROFIT())
					, "V");
			if(list != null && !list.isEmpty()){
				if(list.get(0) != null){
			matValuesBean.setSMV_LC_ACC_PROFIT(Double.parseDouble(list.get(0)));
				}
				}
			procedures.callP_VAL_FC_LC_TOLERANCE(CommonUtils.getProcedureValue(matValuesBean
					.getSMV_FC_ACC_PROFIT()), CommonUtils.getProcedureValue(matValuesBean
					.getSMV_LC_ACC_PROFIT()),CommonUtils.getProcedureValue(policyBean
					.getPOL_SA_EXCH_RATE()), "E");
			matValuesBean.setSMV_FC_GROSS_VALUE(matValuesBean
					.getSMV_FC_RED_SA()
					+ matValuesBean.getSMV_FC_ACC_PROFIT());
			matValuesBean.setSMV_LC_GROSS_VALUE(matValuesBean
					.getSMV_LC_RED_SA()
					+ matValuesBean.getSMV_LC_ACC_PROFIT());

			localProcedure.IL_ENDT_003_004_FINAL_NET_VAL(matValuesBean,
					policyBean);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void SMV_FC_UNPAID_PREM_WHEN_VALIDATE_ITEM(
			PT_IL_SURR_MAT_VALUES matValuesBean, PT_IL_POLICY policyBean,
			DUMMY dummyBean) throws Exception {
		//DBProcedures procedures = new DBProcedures();
		PKG_PILQ003 procedures = new PKG_PILQ003();
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		PKG_PILQ003 localProcedure = new PKG_PILQ003();

		try {
			list = procedures.P_VAL_ROUND_AMT(policyBean
					.getPOL_SA_CURR_CODE(), CommonUtils.getProcedureValue(matValuesBean
					.getSMV_FC_UNPAID_PREM()), "V");
			if(list != null && !list.isEmpty()){
				if(list.get(0) != null){
			matValuesBean
					.setSMV_FC_UNPAID_PREM(Double.parseDouble(list.get(0)));
				}
				}
			matValuesBean.setSMV_LC_UNPAID_PREM(matValuesBean
					.getSMV_FC_UNPAID_PREM()
					* policyBean.getPOL_SA_EXCH_RATE());

			list1 = procedures.P_VAL_ROUND_AMT(dummyBean
					.getUI_M_BASE_CURR(), CommonUtils.getProcedureValue(matValuesBean.getSMV_LC_UNPAID_PREM())
					, "R");
			if(list1 != null && list1.isEmpty()){
				if(list1.get(0) != null){
			matValuesBean.setSMV_LC_UNPAID_PREM(Double
					.parseDouble(list1.get(0)));
			}
			}
			localProcedure.IL_ENDT_003_004_FINAL_NET_VAL(matValuesBean,
					policyBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void SMV_LC_UNPAID_PREM_WHEN_VALIDATE_ITEM(
			PT_IL_SURR_MAT_VALUES matValuesBean, PT_IL_POLICY policyBean,
			DUMMY dummyBean) throws Exception {
		//DBProcedures procedures = new DBProcedures();
		PKG_PILQ003 procedures = new PKG_PILQ003();
		LIFELIB lifelib = new LIFELIB();
		ArrayList<String> list = null;
		try {
			list = procedures.P_VAL_ROUND_AMT(dummyBean
					.getUI_M_BASE_CURR(),CommonUtils.getProcedureValue
														(matValuesBean.getSMV_LC_UNPAID_PREM()), "V");
			if(list != null && !list.isEmpty()){
				if(list.get(0) != null){
			matValuesBean
					.setSMV_LC_UNPAID_PREM(Double.parseDouble(list.get(0)));
				}
			}

			lifelib.callP_VAL_FC_LC_TOLERANCE(CommonUtils.getProcedureValue(matValuesBean
					.getSMV_FC_UNPAID_PREM()),CommonUtils.getProcedureValue( matValuesBean
					.getSMV_LC_UNPAID_PREM()),CommonUtils.getProcedureValue(policyBean
					.getPOL_SA_EXCH_RATE()), "E");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		}
	}
}
