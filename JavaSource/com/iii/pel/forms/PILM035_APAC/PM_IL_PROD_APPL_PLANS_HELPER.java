package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_PROD_APPL_PLANS_HELPER {

	public void executeQuery(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PM_IL_PROD_APPL_PLANS_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PM_IL_PROD_APPL_SUB_PLAN> dataList = compositeAction
				.getPM_IL_PROD_APPL_PLANS_ACTION_BEAN()
				.getDataList_PM_IL_PROD_APPL_PLANS();
		if (dataList != null && dataList.size() > 0) {
			PM_IL_PROD_APPL_SUB_PLAN PM_IL_PROD_APPL_PLANS_BEAN = dataList.get(0);
			PM_IL_PROD_APPL_PLANS_BEAN.setRowSelected(true);
			compositeAction.getPM_IL_PROD_APPL_PLANS_ACTION_BEAN()
					.setPM_IL_PROD_APPL_PLANS_BEAN(PM_IL_PROD_APPL_PLANS_BEAN);
		}
	}

	public void WHEN_NEW_RECORD_INSTANCE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
	}

	public void PRE_INSERT(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {

		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		PM_IL_PROD_APPL_SUB_PLAN pm_il_prod_appl_plans_bean = compositeAction
				.getPM_IL_PROD_APPL_PLANS_ACTION_BEAN()
				.getPM_IL_PROD_APPL_PLANS_BEAN();
		try {
			pm_il_prod_appl_plans_bean.setPAP_PROD_CODE(pm_il_product_bean
					.getPROD_CODE());
			L_DUP_SUB_PLAN_CODE(compositeAction);
			// :PM_IL_PROD_APPL_PLANS.PAP_SR_NO := :SYSTEM.TRIGGER_RECORD;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void PRE_UPDATE(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			L_DUP_SUB_PLAN_CODE(compositeAction);
			// :PM_IL_PROD_APPL_PLANS.PAP_SR_NO := :SYSTEM.TRIGGER_RECORD;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void POST_QUERY(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {


		try {
			DBProcedures dbProcedures = new DBProcedures();
			PM_IL_PROD_APPL_SUB_PLAN pm_il_prod_appl_plans_bean = compositeAction
					.getPM_IL_PROD_APPL_PLANS_ACTION_BEAN()
					.getPM_IL_PROD_APPL_PLANS_BEAN();
			
			pm_il_prod_appl_plans_bean
					.setUI_M_PAP_PROD_CODE_DESC(compositeAction
							.getPM_IL_PRODUCT_ACTION_BEAN()
							.getPM_IL_PRODUCT_BEAN().getPROD_DESC());
			ArrayList<String> PAP_SUB_PLAN_CODE_LIST = dbProcedures
					.P_VAL_CODES("IL_SUB_PLAN",
							pm_il_prod_appl_plans_bean.getPAP_SUB_PLAN_CODE(),
							pm_il_prod_appl_plans_bean.getUI_M_PAP_SUB_PLAN_CODE(), 
							"N", "N", null);
			if(PAP_SUB_PLAN_CODE_LIST != null && !(PAP_SUB_PLAN_CODE_LIST.isEmpty())){
				System.out.println("getUI_M_PAP_SUB_PLAN_CODE                     "+PAP_SUB_PLAN_CODE_LIST.get(0));
				pm_il_prod_appl_plans_bean.setUI_M_PAP_SUB_PLAN_CODE(PAP_SUB_PLAN_CODE_LIST
						.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void L_DUP_SUB_PLAN_CODE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PM_IL_PROD_APPL_SUB_PLAN pm_il_prod_appl_plans_bean = compositeAction
				.getPM_IL_PROD_APPL_PLANS_ACTION_BEAN()
				.getPM_IL_PROD_APPL_PLANS_BEAN();
		
		PM_IL_PRODUCT PM_IL_PRODUCT_BEAN=compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		
		String C1 = " SELECT ROWID " + "FROM   PM_IL_PROD_APPL_SUB_PLAN "
				+ "WHERE  PAP_SUB_PLAN_CODE = ? AND PAP_PROD_CODE = ?";

		String C2 = "SELECT 'X'  " + "FROM   PM_IL_PROD_APPL_SUB_PLAN "
				+ "WHERE  PAP_SUB_PLAN_CODE = ?" + "AND    ROWID  != ?";
		Connection con = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		String beanRowId1 = null;
		String dbRowId1 = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			con = CommonUtils.getConnection();
			
			if (pm_il_prod_appl_plans_bean.getROWID() == null) {
				rs1 = handler.executeSelectStatement(C1, con,
						new Object[] { pm_il_prod_appl_plans_bean
								.getPAP_SUB_PLAN_CODE(),PM_IL_PRODUCT_BEAN.getPROD_CODE() });
				if (rs1.next()) {
					dbRowId1 = rs1.getString("ROWID");
					beanRowId1 = pm_il_prod_appl_plans_bean.getROWID();
					if(CommonUtils.isDuplicate(beanRowId1, dbRowId1)){
						throw new ValidatorException(Messages.getMessage(
								PELConstants.pelErrorMessagePath, "91949"));
					}
				}
			} else {
				rs2 = handler.executeSelectStatement(C2, con, new Object[] {
						pm_il_prod_appl_plans_bean.getPAP_SUB_PLAN_CODE(),
						pm_il_prod_appl_plans_bean.getROWID() });
				if (rs2.next()) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91949"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void PAP_SUB_PLAN_CODE_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PM_IL_PROD_APPL_SUB_PLAN pm_il_prod_appl_plans_bean = compositeAction
				.getPM_IL_PROD_APPL_PLANS_ACTION_BEAN()
				.getPM_IL_PROD_APPL_PLANS_BEAN();
		try {
			if (pm_il_prod_appl_plans_bean.getPAP_SUB_PLAN_CODE() != null) {

				ArrayList<String> PAP_SUB_PLAN_CODE = new DBProcedures()
						.P_VAL_CODES("IL_SUB_PLAN",
								pm_il_prod_appl_plans_bean.getPAP_SUB_PLAN_CODE(),
								pm_il_prod_appl_plans_bean.getUI_M_PAP_SUB_PLAN_CODE(), 
								"N", "E", null);
				pm_il_prod_appl_plans_bean
						.setPAP_SUB_PLAN_CODE(PAP_SUB_PLAN_CODE.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
