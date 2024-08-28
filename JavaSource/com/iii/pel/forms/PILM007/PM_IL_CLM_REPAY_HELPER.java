package com.iii.pel.forms.PILM007;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.PCOPK_GENERAL;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_CLM_REPAY_HELPER {

	CRUDHandler handler = new CRUDHandler();
	PILM007_PROCS_HELPER pilm007_procs_helper = new PILM007_PROCS_HELPER();
	DBProcedures dbProcedure = new DBProcedures();
	PCOPK_GENERAL pcopk_general= new PCOPK_GENERAL();

	public void CR_EFF_TO_DT_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
			if (pm_il_clm_repay_bean.getCR_EFF_FM_DT() != null
					&& pm_il_clm_repay_bean.getCR_EFF_TO_DT() != null) {
				if (pm_il_clm_repay_bean.getCR_EFF_FM_DT().after(
						pm_il_clm_repay_bean.getCR_EFF_TO_DT())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71145"));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CR_APPLIED_ON_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();
		Integer M_EXISTS = 0;
		String C2 = "SELECT 1 FROM   PM_IL_PLAN WHERE  PLAN_CODE = ? AND    PLAN_TYPE='U' "
				+ "AND    NVL(?,'XX') IN ('PA','SP','SPP','PP','PPS','PS','PPP','SMIN','SMAX')";
		Integer M_EXISTS1 = 0;
		String C3 = "SELECT 1 FROM   PM_IL_PLAN WHERE  PLAN_CODE IN (SELECT PROD_PLAN_CODE FROM   PM_IL_PRODUCT,PM_IL_PROD_APPL_COVER "
				+ "WHERE  PROD_CODE = PAC_PROD_CODE AND    PAC_COVER_CODE =?) "
				+ "AND    PLAN_TYPE='U' AND    NVL(?,'XX') IN ('PA','SP','SPP','PP','PPS','PS','PPP','SMIN','SMAX')";

		Connection con = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		try {
			con = CommonUtils.getConnection();
			rs2 = handler.executeSelectStatement(C2, con, new Object[] {
					pm_il_clm_repay_bean.getCR_COVER_CODE(), currValue });
			if (rs2.next()) {
				M_EXISTS = rs2.getInt(1);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_UNIT_PRICE().setDisabled(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_UNIT_PRICE().setRendered(true);
			} else {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_UNIT_PRICE().setDisabled(true);
				rs3 = handler.executeSelectStatement(C3, con, new Object[] {
						pm_il_clm_repay_bean.getCR_COVER_CODE(), currValue });
				if (rs3.next()) {
					M_EXISTS1 = rs3.getInt(1);
					compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
							.getCOMP_CR_UNIT_PRICE().setDisabled(false);
					compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
							.getCOMP_CR_UNIT_PRICE().setRendered(true);
				} else {
					pm_il_clm_repay_bean.setCR_UNIT_PRICE("N");
					compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
							.getCOMP_CR_UNIT_PRICE().setDisabled(true);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CR_PERIOD_TO_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();

		try {
			if ((Double) currValue < pm_il_clm_repay_bean.getCR_PERIOD_FROM()) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71014"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	
	public void CR_PREM_PAYABLE_YN_WHEN_VALIDATE_ITEM(PM_IL_CLM_REPAY pm_il_clm_repay_bean,
			String currValue,PM_IL_CLM_REPAY_ACTION action){
		if (currValue.equalsIgnoreCase("Y")) {
			pm_il_clm_repay_bean.setCR_POLICY_VALID_YN("N");
			action.getCOMP_CR_POLICY_VALID_YN().setDisabled(true);
		} else {
			pm_il_clm_repay_bean.setCR_POLICY_VALID_YN(pm_il_clm_repay_bean
					.getCR_POLICY_VALID_YN());
			action.getCOMP_CR_POLICY_VALID_YN().setDisabled(false);
		}
		
	}

	public void CR_MIN_VALUE_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();
		try {

			if ("P".equals(pm_il_clm_repay_bean.getCR_MIN_TYPE())
					|| "F".equals(pm_il_clm_repay_bean.getCR_MIN_TYPE())) {
				if ((Double) currValue < 1)
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "81085"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void CR_POLICY_VALID_YN_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();

		String M_PS_CODE = null;
		String C1 = "SELECT PS_CODE FROM PP_SYSTEM WHERE PS_TYPE LIKE 'IL_DEATH'";
		ResultSet rs = null;
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(C1, con);
			while (rs.next()) {
				M_PS_CODE = rs.getString(1);
			}
			if (pm_il_clm_repay_bean.getCR_LOSS_TYPE().equals(M_PS_CODE)) {
				pm_il_clm_repay_bean.setCR_POLICY_VALID_YN("N");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CR_WAITING_YN_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		if ("N".equals(currValue))
			compositeAction.getDUMMY_ACTION_BEAN()
					.getCOMP_UI_M_BUT_WAIT_PERIOD().setDisabled(true);
		else
			compositeAction.getDUMMY_ACTION_BEAN()
					.getCOMP_UI_M_BUT_WAIT_PERIOD().setDisabled(false);

	}

	public void CR_MIN_TYPE_WHEN_LIST_CHANGED(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();

		try {
			if ("N".equals(currValue)) {
				pm_il_clm_repay_bean.setCR_MIN_VALUE(null);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_MIN_VALUE().setDisabled(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_MIN_VALUE().setRequired(false);
			} else if ("P".equals(currValue) || "F".equals(currValue)) {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_MIN_VALUE().setDisabled(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_MIN_VALUE().setRequired(true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CR_APPLIED_ON_WHEN_LIST_CHANGED(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();
		Connection con = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;

		try {
			con = CommonUtils.getConnection();
			Integer M_EXISTS = null;
			String C2 = " SELECT 1 FROM   PM_IL_PLAN WHERE  PLAN_CODE = pm_il_clm_repay_bean.getCR_COVER_CODE() AND    PLAN_TYPE='U' "
					+ "AND    NVL(pm_il_clm_repay_bean.getCR_APPLIED_ON(),'XX') IN ('PA','SP','SPP','PP','PPS','PS','PPP','SMIN','SMAX')";
			Integer M_EXISTS1 = null;

			String C3 = " SELECT 1 FROM   PM_IL_PLAN WHERE  PLAN_CODE IN (SELECT PROD_PLAN_CODE FROM   PM_IL_PRODUCT,PM_IL_PROD_APPL_COVER "
					+ "WHERE  PROD_CODE =PAC_PROD_CODE AND    PAC_COVER_CODE =pm_il_clm_repay_bean.getCR_COVER_CODE()) AND    PLAN_TYPE='U' "
					+ "AND    NVL(pm_il_clm_repay_bean.getCR_APPLIED_ON(),'XX') IN ('PA','SP','SPP','PP','PPS','PS','PPP','SMIN','SMAX')";

			rs2 = handler.executeSelectStatement(C2, con, new Object[] {
					pm_il_clm_repay_bean.getCR_COVER_CODE(), currValue });
			if (rs2.next()) {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_UNIT_PRICE().setDisabled(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_UNIT_PRICE().setRendered(true);
			} else {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_UNIT_PRICE().setDisabled(true);
				rs3 = handler.executeSelectStatement(C3, con, new Object[] {
						pm_il_clm_repay_bean.getCR_COVER_CODE(), currValue });
				if (rs3.next()) {
					M_EXISTS1 = rs3.getInt(1);
					compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
							.getCOMP_CR_UNIT_PRICE().setDisabled(false);
					compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
							.getCOMP_CR_UNIT_PRICE().setRendered(true);
				} else {
					pm_il_clm_repay_bean.setCR_UNIT_PRICE("N");
					compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
							.getCOMP_CR_UNIT_PRICE().setDisabled(true);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CR_UNIT_PRICE_WHEN_LIST_CHANGED(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();
		Connection con = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;

		try {
			if ("W".equals(pm_il_clm_repay_bean.getCR_PERIOD_UNIT())) {
				pm_il_clm_repay_bean.setCR_PERIOD_TO(pm_il_clm_repay_bean
						.getCR_PERIOD_TO());
				pm_il_clm_repay_bean.setCR_PAY_MODE("W");
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_PERIOD_TO().setDisabled(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_PERIOD_TO().setRendered(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_PERIOD_TO().setRequired(true);

			} else if ("M".equals(pm_il_clm_repay_bean.getCR_PERIOD_UNIT())) {
				pm_il_clm_repay_bean.setCR_PERIOD_TO(pm_il_clm_repay_bean
						.getCR_PERIOD_TO());
				pm_il_clm_repay_bean.setCR_PAY_MODE("M");
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_PERIOD_TO().setDisabled(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_PERIOD_TO().setRendered(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_PERIOD_TO().setRequired(true);
			} else if ("Y".equals(pm_il_clm_repay_bean.getCR_PERIOD_UNIT())) {
				pm_il_clm_repay_bean.setCR_PERIOD_TO(pm_il_clm_repay_bean
						.getCR_PERIOD_TO());
				pm_il_clm_repay_bean.setCR_PAY_MODE("Y");
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_PERIOD_TO().setDisabled(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_PERIOD_TO().setRendered(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_PERIOD_TO().setRequired(true);

			} else if ("D".equals(pm_il_clm_repay_bean.getCR_PERIOD_UNIT())) {
				pm_il_clm_repay_bean.setCR_PERIOD_TO(pm_il_clm_repay_bean
						.getCR_PERIOD_TO());
				pm_il_clm_repay_bean.setCR_PAY_MODE("D");
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_PERIOD_TO().setDisabled(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_PERIOD_TO().setRendered(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_PERIOD_TO().setRequired(true);
			} else if ("S".equals(pm_il_clm_repay_bean.getCR_PERIOD_UNIT())) {
				pm_il_clm_repay_bean.setCR_PERIOD_TO(1);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_PERIOD_TO().setDisabled(false);
				pm_il_clm_repay_bean.setCR_PERIOD_TO(pm_il_clm_repay_bean
						.getCR_PERIOD_TO());
				pm_il_clm_repay_bean.setCR_PAY_MODE("S");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CR_LOSS_TYPE_KEY_LISTVAL(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		Connection con = null;
		try {
			con = CommonUtils.getConnection();

			// P_CALL_LOV('PM_IL_CLM_REPAY.CR_LOSS_TYPE','IL_LOS_TYP');

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CR_LOSS_TYPE_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();

		Connection con = null;
		String M_PS_CODE = null;
		ResultSet rs1 = null;
		try {
			con = CommonUtils.getConnection();
		    String C1 = " SELECT PS_CODE FROM PP_SYSTEM WHERE PS_TYPE LIKE 'IL_DEATH'";
			rs1 = handler.executeSelectStatement(C1, con);
			while (rs1.next()) {
				M_PS_CODE = rs1.getString(1);
			}
			if (M_PS_CODE.equals(currValue)) {
				pm_il_clm_repay_bean.setCR_POLICY_VALID_YN("N");
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_POLICY_VALID_YN().setDisabled(true);
			} else {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_POLICY_VALID_YN().setDisabled(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_POLICY_VALID_YN().setRendered(true);
			}

			ArrayList<OracleParameter> outList1 = pcopk_general.P_VAL_CODES("IL_LOS_TYP",
					(String) currValue, pm_il_clm_repay_bean
					.getUI_M_LOSS_DESC(), "N", "E", "","",CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),"");

			String desc = null;
			if(outList1!=null && outList1.size()>0)
				desc = outList1.get(0).getValue();
			outList1.clear();
			/*String desc = pilm007_procs_helper.P_VAL_CODES(con, "IL_LOS_TYP",
					(String) currValue, pm_il_clm_repay_bean
							.getUI_M_LOSS_DESC(), "N", "E", "");*/
			pm_il_clm_repay_bean.setUI_M_LOSS_DESC(desc);
			pm_il_clm_repay_bean.setCR_DISABLE_TYPE(pm_il_clm_repay_bean
					.getCR_DISABLE_TYPE());

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			CommonUtils.closeCursor(rs1);
		}

	}

	public void CR_COVER_CODE_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();
		Connection con = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		Integer M_eXISTS = null;
		Integer M_EXISTS1 = null;

		String M_COVER_CLASS = null;
		try {
			con = CommonUtils.getConnection();

			Object[] rsObj1 = new Object[2];
			rsObj1[0] = (String)currValue;
			rsObj1[1] = pm_il_clm_repay_bean.getCR_APPLIED_ON();

			rs1 = handler
					.executeSelectStatement(
							PILM007_QUERYCONSTANTS.CR_COVER_CODE$WHEN_VALIDATE_ITEM_CURSOR_QRY_1,
							con, rsObj1);
			if (rs1.next()) {
				M_eXISTS = rs1.getInt(1);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_UNIT_PRICE().setDisabled(false);
			} else {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_UNIT_PRICE().setDisabled(true);
				rs3 = handler
						.executeSelectStatement(
								PILM007_QUERYCONSTANTS.CR_COVER_CODE$WHEN_VALIDATE_ITEM_CURSOR_QRY_2,
								con, rsObj1);
				if (rs3.next()) {
					M_EXISTS1 = rs3.getInt(1);
					compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
							.getCOMP_CR_UNIT_PRICE().setDisabled(true);
				} else {
					pm_il_clm_repay_bean.setCR_UNIT_PRICE("N");
					compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
							.getCOMP_CR_UNIT_PRICE().setDisabled(true);
				}
			}
			rs2 = handler
					.executeSelectStatement(
							PILM007_QUERYCONSTANTS.CR_COVER_CODE$WHEN_VALIDATE_ITEM_CURSOR_QRY_3,
							con, new Object[] { (String)currValue });
			if (rs2.next()) {
				M_COVER_CLASS = rs2.getString(1);
			}

			if (CommonUtils.nvl(M_COVER_CLASS, "X").equals("M")) {
				pm_il_clm_repay_bean.setCR_RATE(100.0);
				pm_il_clm_repay_bean.setCR_RATE_PER(100.0);
				pm_il_clm_repay_bean.setCR_APPLIED_ON("M");

				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_RATE().setDisabled(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_RATE_PER().setDisabled(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_APPLIED_ON().setDisabled(true);
			} else {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_RATE().setDisabled(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_RATE_PER().setDisabled(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_APPLIED_ON().setDisabled(false);
			}

			ArrayList<String> outList = dbProcedure.callP_VAL_COVER_PROC(
					(String) currValue, pm_il_clm_repay_bean
							.getUI_M_COVER_DESC(), "", "N", "E");
			if (outList != null && outList.size() > 0) {
				pm_il_clm_repay_bean.setUI_M_COVER_DESC(outList.get(0));
			}
			pm_il_clm_repay_bean.setCR_DISABLE_TYPE(pm_il_clm_repay_bean
					.getCR_DISABLE_TYPE());

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			CommonUtils.closeCursor(rs1);
		}
	}

	public void CR_COVER_CODE_KEY_LISTVAL(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		Connection con = null;
		try {
			con = CommonUtils.getConnection();

			// P_CALL_LOV('PM_IL_CLM_REPAY.CR_COVER_CODE');

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CR_COVER_CODE_KEY_PREV_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		Connection con = null;
		try {
			con = CommonUtils.getConnection();

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CR_MAX_VALUE_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();

		Connection con = null;
		try {
			Double currValues = (Double)currValue;
			con = CommonUtils.getConnection();
			if ("P".equals(pm_il_clm_repay_bean.getCR_MAX_TYPE())
					|| "F".equals(pm_il_clm_repay_bean.getCR_MAX_TYPE())) {
				if (currValues < 1)
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "81085"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	

	public void CR_LIEN_YN_WHEN_LIST_CHANGED(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		DUMMY_ACTION DUMMY_ACTION_BEAN = compositeAction.getDUMMY_ACTION_BEAN();
		try {
			if ("N".equals((String) currValue)) {
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_CR_LIEN_YN().setDisabled(
						true);
			} else {
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_CR_LIEN_YN().setDisabled(
						false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CR_LATE_FEE_YN_WHEN_LIST_CHANGED(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {
			if ("Y".equals((String) currValue)) {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_LATE_FEE_TYPE().setDisabled(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_LATE_FEE_TYPE().setRequired(true);
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_LATE_FEE_DTLS().setDisabled(false);
			} else {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_LATE_FEE_TYPE().setRequired(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_LATE_FEE_TYPE().setDisabled(true);
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_LATE_FEE_DTLS().setDisabled(true);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CR_MAX_TYPE_WHEN_LIST_CHANGED(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();
		try {
			if ("N".equals(currValue)) {
				pm_il_clm_repay_bean.setCR_MAX_VALUE(null);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_MAX_VALUE().setDisabled(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_MAX_VALUE().setRequired(false);
			} else if ("P".equals(currValue) || "F".equals(currValue)) {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_MAX_VALUE().setDisabled(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_MAX_VALUE().setRequired(true);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	


	public void CR_HIBAH_FEE_AMT_KEY_NEXT_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		Connection con = null;
		try {
			con = CommonUtils.getConnection();

			/*--GO_BLOCK('PM_IL_CLM_REPAY_DTL');*/

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CR_HIBAH_FEE_AMT_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		Double currValues = (Double) currValue;
		try {
			if (currValues < 0)
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "81085"));

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CR_HIBAH_YN_WHEN_LIST_CHANGED(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		Connection con = null;
		try {
			if ("Y".equals(currValue)) {
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_CR_HIBA_YN().setDisabled(false);
				
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_HIBAH_FEE_AMT_LABEL().setRendered(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_HIBAH_FEE_AMT().setRendered(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_HIBAH_FEE_AMT().setDisabled(false);
			} else {
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_CR_HIBA_YN().setDisabled(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
					.getCOMP_CR_HIBAH_FEE_AMT_LABEL().setRendered(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_HIBAH_FEE_AMT().setRendered(false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CR_HIBAH_YN_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		Connection con = null;
		try {
			con = CommonUtils.getConnection();
			if ("Y".equals(currValue)) {
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_CR_HIBA_YN().setDisabled(false);
			} else {
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_CR_HIBA_YN().setDisabled(true);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CR_DISABLE_TYPE_KEY_LISTVAL(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		Connection con = null;
		try {
			con = CommonUtils.getConnection();

			// P_CALL_LOV('PM_IL_CLM_REPAY.CR_DISABLE_TYPE','IL_DIS_TYP');

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	/* Modified By Dhinesh on 16-8-2017 for ssp call id : ZBILQC-1730139 */
	public void CR_RESERVE_TYPE_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();
		Connection con = null;
		try {
			if ("S".equals(currValue)) {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_RESERVE_OPTIONS().setDisabled(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setDisabled(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setRequired(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_RESERVE_CR_BASIS().setDisabled(true);

				pm_il_clm_repay_bean.setCR_RESERVE_OPTIONS("N");
				pm_il_clm_repay_bean.setCR_RESERVE_CR_BASIS("N");
			} else {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_RESERVE_OPTIONS().setDisabled(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_RESERVE_OPTIONS().setRendered(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setDisabled(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setRequired(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_RESERVE_CR_BASIS().setDisabled(false);
				pm_il_clm_repay_bean.setCR_RESERVE_OPTIONS("F");
				pm_il_clm_repay_bean.setCR_RESERVE_CR_BASIS("T");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	
	/* End */

	public void CR_RESERVE_OPTIONS_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();
		try {
			if ("F".equals(currValue) || currValue == null) {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setDisabled(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setRendered(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setRequired(true);
				if (currValue == null) {
					pm_il_clm_repay_bean.setCR_RESERVE_OPTIONS("F");
				}
				pm_il_clm_repay_bean.setCR_RESERVE_CR_BASIS("T");
			} else if ("C".equals(pm_il_clm_repay_bean.getCR_RESERVE_OPTIONS())) {
				pm_il_clm_repay_bean.setCR_NO_OF_YEARS(null);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setRequired(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setDisabled(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setRendered(false);

				pm_il_clm_repay_bean.setCR_RESERVE_CR_BASIS("T");
			} else {
				pm_il_clm_repay_bean.setCR_NO_OF_YEARS(null);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setDisabled(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setRendered(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setRequired(false);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CR_RESERVE_CR_BASIS_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();
		try {
			if (currValue == null) {
				pm_il_clm_repay_bean.setCR_RESERVE_CR_BASIS("T");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CR_RATE_PER_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();
		try {
			if ((Integer) currValue < 1) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "81085"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CR_RESERVE_CR_BASIS_WHEN_LIST_CHANGED(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();
		try {
			if (currValue == null) {
				pm_il_clm_repay_bean.setCR_RESERVE_CR_BASIS("T");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CR_RESERVE_OPTIONS_WHEN_LIST_CHANGED(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();
		try {
			if ("F".equals(currValue) || currValue == null) {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setDisabled(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setRendered(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setRequired(true);
				if (currValue == null) {
					pm_il_clm_repay_bean.setCR_RESERVE_OPTIONS("F");
				}
				pm_il_clm_repay_bean.setCR_RESERVE_CR_BASIS("T");
			} else if ("C".equals(pm_il_clm_repay_bean.getCR_RESERVE_OPTIONS())) {
				pm_il_clm_repay_bean.setCR_NO_OF_YEARS(null);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setRequired(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setDisabled(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setRendered(false);

				pm_il_clm_repay_bean.setCR_RESERVE_CR_BASIS("T");
			} else {
				pm_il_clm_repay_bean.setCR_NO_OF_YEARS(null);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setDisabled(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setRendered(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setRequired(false);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CR_RESERVE_TYPE_WHEN_LIST_CHANGED(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();
		Connection con = null;
		try {
			if ("S".equals(currValue)) {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_RESERVE_OPTIONS().setDisabled(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setDisabled(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setRequired(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_RESERVE_CR_BASIS().setDisabled(true);

				pm_il_clm_repay_bean.setCR_RESERVE_OPTIONS("N");
				pm_il_clm_repay_bean.setCR_RESERVE_CR_BASIS("N");
			} else {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_RESERVE_OPTIONS().setDisabled(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_RESERVE_OPTIONS().setRendered(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setDisabled(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setRequired(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_RESERVE_CR_BASIS().setDisabled(false);
				pm_il_clm_repay_bean.setCR_RESERVE_OPTIONS("F");
				pm_il_clm_repay_bean.setCR_RESERVE_CR_BASIS("T");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CR_DISABLE_TYPE_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();
		Connection con = null;
		try {
			con = CommonUtils.getConnection();

			ArrayList<OracleParameter> outList1 = pcopk_general.P_VAL_CODES("IL_DIS_TYP",
					(String) currValue, pm_il_clm_repay_bean
					.getUI_M_DISABLE_DESC(), "N", "E" ,"","",CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),"");

			String desc = null;
			if(outList1!=null && outList1.size()>0)
				desc = outList1.get(0).getValue();
			outList1.clear();

			/*String desc = pilm007_procs_helper.P_VAL_CODES(con, "IL_DIS_TYP",
					(String) currValue, pm_il_clm_repay_bean
							.getUI_M_DISABLE_DESC(), "N", "E", "");*/
			pm_il_clm_repay_bean.setUI_M_DISABLE_DESC(desc);
			pm_il_clm_repay_bean.setCR_DISABLE_TYPE(pm_il_clm_repay_bean
					.getCR_DISABLE_TYPE());

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CR_EFF_FM_DT_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();
		try {
			Date from_date = (Date) currValue;
			if (from_date != null
					&& pm_il_clm_repay_bean.getCR_EFF_TO_DT() != null) {
				if (from_date.after(pm_il_clm_repay_bean.getCR_EFF_TO_DT()))
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71145"));

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void executeQuery(PILM007_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PM_IL_CLM_REPAY_DELEGATE().executeSelectStatement(compositeAction);
	}

	public void CR_LIEN_YN_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object value) {
		// TODO Auto-generated method stub
		if("N".equals(value)) 
		  compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_CR_LIEN_YN().setDisabled(true);
		else
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_CR_LIEN_YN().setDisabled(false);
		

	}

	public void PILM007_PRE_FORM() {
		if (CommonUtils.getGlobalVariable("CALLING_FORM") == null) {
			CommonUtils.setGlobalVariable("GLOBAL.M_PRIVILEGE", "YYY");
			CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "FALSE");
			CommonUtils.setGlobalVariable("GLOBAL.M_PARA_1", "");
			// CommonUtils.setGlobalVariable("GLOBAL.M_MODULE_NAME :=
			// GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),FORM_NAME);
			CommonUtils
					.setGlobalVariable("GLOBAL.M_DFLT_VALUES", "00101    01");
			CommonUtils.setGlobalVariable("GLOBAL.M_CL_BASIS", "");// HIBAH
		}

	}

	public void PRE_INSERT(PM_IL_CLM_REPAY pm_il_clm_repay_bean)
			throws Exception {

		/* Added By Jaya On 11/12/2002 */
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
			ArrayList<String> outList = dbProcedure.callP_VAL_COVER_PROC(
					(String) pm_il_clm_repay_bean.getCR_COVER_CODE(),
					pm_il_clm_repay_bean.getUI_M_COVER_DESC(), "", "N", "E");
			if (outList != null && outList.size() > 0) {
				pm_il_clm_repay_bean.setUI_M_COVER_DESC(outList.get(0));
			}
			
			ArrayList<OracleParameter> outList1 = pcopk_general.P_VAL_CODES("IL_LOS_TYP",
					pm_il_clm_repay_bean.getCR_LOSS_TYPE(),
					pm_il_clm_repay_bean.getUI_M_LOSS_DESC(), "N", "E" ,"","",CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),"");

			String desc = null;
			if(outList1!=null && outList1.size()>0)
				desc = outList1.get(0).getValue();
			outList1.clear();

			/*String desc = pilm007_procs_helper.P_VAL_CODES(con, "IL_LOS_TYP",
					pm_il_clm_repay_bean.getCR_LOSS_TYPE(),
					pm_il_clm_repay_bean.getUI_M_LOSS_DESC(), "N", "E", "");*/
			pm_il_clm_repay_bean.setUI_M_LOSS_DESC(desc);

			
			/*desc = pilm007_procs_helper.P_VAL_CODES(con, "IL_DIS_TYP",
					pm_il_clm_repay_bean.getCR_DISABLE_TYPE(),
					pm_il_clm_repay_bean.getUI_M_DISABLE_DESC(), "N", "E", "");*/
			outList1 = pcopk_general.P_VAL_CODES("IL_DIS_TYP",
					pm_il_clm_repay_bean.getCR_DISABLE_TYPE(),
					pm_il_clm_repay_bean.getUI_M_DISABLE_DESC(), "N", "E" ,"","",CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),"");

			desc = null;
			if(outList1!=null && outList1.size()>0)
				desc = outList1.get(0).getValue();
			outList1.clear();
			pm_il_clm_repay_bean.setUI_M_DISABLE_DESC(desc);

			if ("P".equals(pm_il_clm_repay_bean.getCR_MIN_TYPE())
					|| "F".equals(pm_il_clm_repay_bean.getCR_MIN_TYPE())) {
				if (pm_il_clm_repay_bean.getCR_MIN_VALUE() == null)
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91016"));
			}

			if ("P".equals(pm_il_clm_repay_bean.getCR_MAX_TYPE())
					|| "F".equals(pm_il_clm_repay_bean.getCR_MAX_TYPE())) {
				if (pm_il_clm_repay_bean.getCR_MAX_VALUE() == null)
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91017"));
			}

			if (pm_il_clm_repay_bean.getCR_MIN_TYPE().equals(
					pm_il_clm_repay_bean.getCR_MAX_TYPE())) {
				if (pm_il_clm_repay_bean.getCR_MIN_VALUE() != null
						&& pm_il_clm_repay_bean.getCR_MAX_VALUE() != null)
					if (pm_il_clm_repay_bean.getCR_MIN_VALUE() > pm_il_clm_repay_bean
							.getCR_MAX_VALUE())
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "81086"));
			}

			pilm007_procs_helper.L_DUP_CLM_SETUP(pm_il_clm_repay_bean);
			pm_il_clm_repay_bean
					.setCR_CR_DT(new CommonUtils().getCurrentDate());
			pm_il_clm_repay_bean.setCR_CR_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void PRE_UPDATE(PM_IL_CLM_REPAY pm_il_clm_repay_bean)
			throws Exception {
		/* Added By Jaya On 11/12/2002 */
		Connection con = null;
		try {
			if ("P".equals(pm_il_clm_repay_bean.getCR_MIN_TYPE())
					|| "F".equals(pm_il_clm_repay_bean.getCR_MIN_TYPE())) {
				if (pm_il_clm_repay_bean.getCR_MIN_VALUE() == null)
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91016"));
			}

			if ("P".equals(pm_il_clm_repay_bean.getCR_MAX_TYPE())
					|| "F".equals(pm_il_clm_repay_bean.getCR_MAX_TYPE())) {
				if (pm_il_clm_repay_bean.getCR_MAX_VALUE() == null)
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91017"));
			}

			if (pm_il_clm_repay_bean.getCR_MIN_TYPE().equals(
					pm_il_clm_repay_bean.getCR_MAX_TYPE())) {
				if (pm_il_clm_repay_bean.getCR_MIN_VALUE() != null
						&& pm_il_clm_repay_bean.getCR_MAX_VALUE() != null) {
					if (pm_il_clm_repay_bean.getCR_MIN_VALUE() > pm_il_clm_repay_bean
							.getCR_MAX_VALUE())
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "81086"));
				}
			}
			pilm007_procs_helper.L_DUP_CLM_SETUP(pm_il_clm_repay_bean);
			pm_il_clm_repay_bean.setCR_UPD_DT(new CommonUtils()
					.getCurrentDate());
			pm_il_clm_repay_bean.setCR_UPD_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void POST_QUERY(PILM007_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();

		Connection con = null;
		String m_frm_desc=null;
		try {
			con = CommonUtils.getConnection();

			if(pm_il_clm_repay_bean.getCR_HIBAH_YN()!=null){
			if ("Y".equals(pm_il_clm_repay_bean.getCR_HIBAH_YN())) {
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_CR_HIBA_YN().setDisabled(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_HIBAH_FEE_AMT().setRendered(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
					.getCOMP_CR_HIBAH_FEE_AMT_LABEL().setRendered(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_HIBAH_FEE_AMT().setDisabled(false);
			} else {
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_CR_HIBA_YN().setDisabled(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
					.getCOMP_CR_HIBAH_FEE_AMT_LABEL().setRendered(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_HIBAH_FEE_AMT().setRendered(false);
			}
			}

			ArrayList<String> outList = dbProcedure.callP_VAL_COVER_PROC(
					(String) pm_il_clm_repay_bean.getCR_COVER_CODE(),
					pm_il_clm_repay_bean.getUI_M_COVER_DESC(), "", "N", "N");
			if (outList != null && outList.size() > 0) {
				pm_il_clm_repay_bean.setUI_M_COVER_DESC(outList.get(0));
			}
			outList.clear();
			ArrayList<OracleParameter> outList1 = pcopk_general.P_VAL_CODES("IL_LOS_TYP", 
					pm_il_clm_repay_bean.getCR_LOSS_TYPE(),
					pm_il_clm_repay_bean.getUI_M_LOSS_DESC(),
					"N", "N" ,"","",CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),"");

			String desc = null;
			if(outList1!=null && outList1.size()>0)
				desc = outList1.get(0).getValue();
			outList1.clear();
			/*String desc = pilm007_procs_helper.P_VAL_CODES(con, "IL_LOS_TYP",
					pm_il_clm_repay_bean.getCR_LOSS_TYPE(),
					pm_il_clm_repay_bean.getUI_M_LOSS_DESC(), "N", "N", "");*/
			pm_il_clm_repay_bean.setUI_M_LOSS_DESC(desc);

			outList1 = pcopk_general.P_VAL_CODES("IL_DIS_TYP", 
					pm_il_clm_repay_bean.getCR_DISABLE_TYPE(),
					pm_il_clm_repay_bean.getUI_M_DISABLE_DESC(),
					"N", "N" ,"","",CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),"");

			/*String desc1 = pilm007_procs_helper.P_VAL_CODES(con, "IL_DIS_TYP",
					pm_il_clm_repay_bean.getCR_DISABLE_TYPE(),
					pm_il_clm_repay_bean.getUI_M_DISABLE_DESC(), "N", "N", "");*/
			String desc1 = null;
			if(outList1!=null && outList1.size()>0)
				desc1 = outList1.get(0).getValue();
			outList1.clear();
			pm_il_clm_repay_bean.setUI_M_DISABLE_DESC(desc1);
			if(pm_il_clm_repay_bean.getCR_FM_CODE()!=null){
				String c1="SELECT FRM_DESC FROM PM_IL_FORMULA WHERE FRM_CODE=?";
				CRUDHandler handler=new CRUDHandler();
				ResultSet rs=handler.executeSelectStatement(c1, con,new Object[]{pm_il_clm_repay_bean.getCR_FM_CODE()} );
				while(rs.next()){
					m_frm_desc=rs.getString(1);
					
				}
				pm_il_clm_repay_bean.setCR_FORMULA_DESC(m_frm_desc);
			}
			if("S".equalsIgnoreCase(pm_il_clm_repay_bean.getCR_PAY_MODE())){
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN().setCR_PERIOD_FROM(1);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN().getCOMP_CR_PERIOD_FROM().setDisabled(true);


			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void WHEN_NEW_RECORD_INSTANCE(
			PILM007_COMPOSITE_ACTION compositeAction) throws Exception {

		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();
		String M_COVER_CLASS = null;
		String C1 = " SELECT COVER_CLASS FROM   PM_IL_COVER WHERE  COVER_CODE = ?";
		Integer M_EXISTS = null;
		String C2 = "SELECT 1 FROM   PM_IL_PLAN WHERE  PLAN_CODE = ? "
				+ "AND    PLAN_TYPE='U' AND    NVL(?,'XX') IN ('PA','SP','SPP','PP','PPS','PS','PPP','SMIN','SMAX') ";
		Integer M_EXISTS1 = null;
		String C3 = " SELECT 1 FROM   PM_IL_PLAN WHERE  PLAN_CODE IN (SELECT PROD_PLAN_CODE FROM   PM_IL_PRODUCT,PM_IL_PROD_APPL_COVER "
				+ "WHERE  PROD_CODE =PAC_PROD_CODE AND    PAC_COVER_CODE =?) AND    PLAN_TYPE='U' "
				+ "AND    NVL(?,'XX') IN ('PA','SP','SPP','PP','PPS','PS','PPP','SMIN','SMAX') ";

		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
			rs2 = handler.executeSelectStatement(C2, con, new Object[] {
					pm_il_clm_repay_bean.getCR_COVER_CODE(),
					pm_il_clm_repay_bean.getCR_APPLIED_ON() });
			if (rs2.next()) {
				M_EXISTS = rs2.getInt(1);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_UNIT_PRICE().setDisabled(false);
//				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
//						.getCOMP_CR_UNIT_PRICE().setRendered(true);
			} else {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_UNIT_PRICE().setDisabled(true);
				rs3 = handler.executeSelectStatement(C3, con, new Object[] {
						pm_il_clm_repay_bean.getCR_COVER_CODE(),
						pm_il_clm_repay_bean.getCR_APPLIED_ON() });
				if (rs3.next()) {
					M_EXISTS1 = rs3.getInt(1);
					compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
							.getCOMP_CR_UNIT_PRICE().setDisabled(false);
//					compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
//							.getCOMP_CR_UNIT_PRICE().setRendered(true);
				} else
					compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
							.getCOMP_CR_UNIT_PRICE().setDisabled(true);
			}

			rs1 = handler.executeSelectStatement(C1, con,
					new Object[] { pm_il_clm_repay_bean.getCR_COVER_CODE() });
			while (rs1.next()) {
				M_COVER_CLASS = rs1.getString(1);
			}
			if (CommonUtils.nvl(M_COVER_CLASS, "X").equals("M")) {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_RATE().setDisabled(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_RATE_PER().setDisabled(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_APPLIED_ON().setDisabled(true);
			} else {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_RATE().setDisabled(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_RATE_PER().setDisabled(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_APPLIED_ON().setDisabled(false);
			}

			if ("N".equals(pm_il_clm_repay_bean.getCR_MIN_TYPE())) {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_MIN_VALUE().setDisabled(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_MIN_VALUE().setRequired(false);
			} else if ("P".equals(pm_il_clm_repay_bean.getCR_MIN_TYPE())
					|| "F".equals(pm_il_clm_repay_bean.getCR_MIN_TYPE())) {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_MIN_VALUE().setDisabled(false);
//				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
//						.getCOMP_CR_MIN_VALUE().setRendered(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_MIN_VALUE().setRequired(true);
			}

			/** Code For Max Type* */
			if ("N".equals(pm_il_clm_repay_bean.getCR_MAX_TYPE())) {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_MAX_VALUE().setDisabled(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_APPLIED_ON().setRequired(false);
			} else if ("P".equals(pm_il_clm_repay_bean.getCR_MAX_TYPE())
					|| "F".equals(pm_il_clm_repay_bean.getCR_MAX_TYPE())) {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_MAX_VALUE().setDisabled(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_MAX_VALUE().setRequired(true);
			}

			if ("N".equals(pm_il_clm_repay_bean.getCR_LATE_FEE_YN())) {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_LATE_FEE_TYPE().setRequired(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_LATE_FEE_TYPE().setDisabled(true);
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_LATE_FEE_DTLS().setDisabled(true);
			} else {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_LATE_FEE_TYPE().setDisabled(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_LATE_FEE_TYPE().setRequired(true);
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_LATE_FEE_DTLS().setDisabled(false);
			}

			if ("Y".equals(pm_il_clm_repay_bean.getCR_HIBAH_YN())) {
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_CR_HIBA_YN().setDisabled(false);
			} else {
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_CR_HIBA_YN().setDisabled(true);
//				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
//						.getCOMP_CR_HIBAH_FEE_AMT().setRendered(false);
			}

			if ("Y".equals(pm_il_clm_repay_bean.getCR_WAITING_YN()))
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_WAIT_PERIOD().setDisabled(false);
			else
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_WAIT_PERIOD().setDisabled(true);

			if ("Y".equals(pm_il_clm_repay_bean.getCR_LIEN_YN()))
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_CR_LIEN_YN().setDisabled(false);
			else
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_UI_M_BUT_CR_LIEN_YN().setDisabled(true);

			if ("S".equals(pm_il_clm_repay_bean.getCR_RESERVE_TYPE())) {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_RESERVE_OPTIONS().setDisabled(true);
				/*compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setRequired(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setDisabled(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_RESERVE_CR_BASIS().setDisabled(true);*/
			} else {
				if ("F".equals(pm_il_clm_repay_bean.getCR_RESERVE_OPTIONS())) {
					compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
							.getCOMP_CR_RESERVE_OPTIONS().setDisabled(false);
//					compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
//							.getCOMP_CR_RESERVE_OPTIONS().setRendered(true);
					/*compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
							.getCOMP_CR_NO_OF_YEARS().setDisabled(false);
					compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
							.getCOMP_CR_NO_OF_YEARS().setRequired(true);
					compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
							.getCOMP_CR_RESERVE_CR_BASIS().setDisabled(false);*/
				} else if ("C".equals(pm_il_clm_repay_bean
						.getCR_RESERVE_OPTIONS())) {
					compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
							.getCOMP_CR_RESERVE_OPTIONS().setDisabled(false);
//					compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
//							.getCOMP_CR_RESERVE_OPTIONS().setRendered(true);
					/*compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
							.getCOMP_CR_NO_OF_YEARS().setRequired(false);
					compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
							.getCOMP_CR_NO_OF_YEARS().setDisabled(true);
					compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
							.getCOMP_CR_RESERVE_CR_BASIS().setDisabled(false);*/
				}
			}
			/*Added by raja for Hospital cash plan on 05/05/2017*/
			if(pm_il_clm_repay_bean.getCR_COVER_CODE()!=null && !pm_il_clm_repay_bean.getCR_COVER_CODE().equalsIgnoreCase("210"))
					{
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN().getCOMP_CR_MAX_VISITS().setDisabled(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN().getCOMP_CR_WAIT_HRS().setDisabled(true);
					}
			/*end*/
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void WHEN_CREATE_RECORD(PILM007_COMPOSITE_ACTION compositeAction) {
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();
		pm_il_clm_repay_bean.setCR_PERIOD_FROM(1);
		pm_il_clm_repay_bean.setCR_PERIOD_UNIT("W");
		pm_il_clm_repay_bean.setCR_PAY_MODE("W");
		pm_il_clm_repay_bean.setCR_POLICY_VALID_YN("N");
		pm_il_clm_repay_bean.setCR_PREM_PAYABLE_YN("N");
		pm_il_clm_repay_bean.setCR_RATE(100.0);
		pm_il_clm_repay_bean.setCR_RATE_PER(100.0);
		pm_il_clm_repay_bean.setCR_APPLIED_ON("SA");
		pm_il_clm_repay_bean.setCR_MIN_TYPE("N");
		pm_il_clm_repay_bean.setCR_MAX_TYPE("N");
		pm_il_clm_repay_bean.setCR_LATE_FEE_YN("N");
		pm_il_clm_repay_bean.setCR_LATE_FEE_TYPE("I");
		pm_il_clm_repay_bean.setCR_RESERVE_CR_BASIS("T");
		pm_il_clm_repay_bean.setCR_PAY_TO("A");
		pm_il_clm_repay_bean.setCR_UNIT_PRICE("N");
		pm_il_clm_repay_bean.setCR_PREM_DED("N");
		pm_il_clm_repay_bean.setCR_WAITING_YN("N");
		pm_il_clm_repay_bean.setCR_LIEN_YN("N");

		pm_il_clm_repay_bean.setCR_HIBAH_YN("N");
//hidden no.of years,reserve creation basis,reserve option, cr_period_to so commented on when create record 
		if ("W".equals(pm_il_clm_repay_bean.getCR_PERIOD_UNIT())) {
			/*pm_il_clm_repay_bean.setCR_PERIOD_TO(pm_il_clm_repay_bean
					.getCR_PERIOD_TO());
			pm_il_clm_repay_bean.setCR_PAY_MODE("W");
			compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
					.getCOMP_CR_PERIOD_TO().setDisabled(false);
//			compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
//					.getCOMP_CR_PERIOD_TO().setRendered(true);
			/*compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
					.getCOMP_CR_PERIOD_TO().setRequired(true);*/
		} else if ("M".equals(pm_il_clm_repay_bean.getCR_PERIOD_UNIT())) {
		/*	pm_il_clm_repay_bean.setCR_PERIOD_TO(pm_il_clm_repay_bean
					.getCR_PERIOD_TO());
			pm_il_clm_repay_bean.setCR_PAY_MODE("M");
			compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
					.getCOMP_CR_PERIOD_TO().setDisabled(false);
//			compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
//					.getCOMP_CR_PERIOD_TO().setRendered(true);
			/*compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
					.getCOMP_CR_PERIOD_TO().setRequired(true);*/
		} else if ("Y".equals(pm_il_clm_repay_bean.getCR_PERIOD_UNIT())) {
			/*pm_il_clm_repay_bean.setCR_PERIOD_TO(pm_il_clm_repay_bean
					.getCR_PERIOD_TO());
			pm_il_clm_repay_bean.setCR_PAY_MODE("Y");
			compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
					.getCOMP_CR_PERIOD_TO().setDisabled(false);
//			compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
//					.getCOMP_CR_PERIOD_TO().setRendered(true);
			/*compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
					.getCOMP_CR_PERIOD_TO().setRequired(true);*/
		} else if ("D".equals(pm_il_clm_repay_bean.getCR_PERIOD_UNIT())) {
			/*pm_il_clm_repay_bean.setCR_PERIOD_TO(pm_il_clm_repay_bean
					.getCR_PERIOD_TO());*/
			pm_il_clm_repay_bean.setCR_PAY_MODE("D");
			/*compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
					.getCOMP_CR_PERIOD_TO().setDisabled(false);
			compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
					.getCOMP_CR_PERIOD_TO().setRequired(true);*/
			/*compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
					.getCOMP_CR_PERIOD_TO().setRequired(true);*/
		} else if ("S".equals(pm_il_clm_repay_bean.getCR_PERIOD_UNIT())) {
			/*pm_il_clm_repay_bean.setCR_PERIOD_TO(1);
			compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
					.getCOMP_CR_PERIOD_TO().setDisabled(false);
			pm_il_clm_repay_bean.setCR_PERIOD_TO(pm_il_clm_repay_bean
					.getCR_PERIOD_TO());*/
			pm_il_clm_repay_bean.setCR_PAY_MODE("S");
		}

		pm_il_clm_repay_bean.setCR_RESERVE_TYPE("S");
		if ("S".equals(pm_il_clm_repay_bean.getCR_RESERVE_TYPE())) {
			pm_il_clm_repay_bean.setCR_RESERVE_OPTIONS("N");
			pm_il_clm_repay_bean.setCR_RESERVE_CR_BASIS("N");
		/*	compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
					.getCOMP_CR_RESERVE_OPTIONS().setDisabled(true);
			compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
					.getCOMP_CR_NO_OF_YEARS().setDisabled(true);
			compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
					.getCOMP_CR_RESERVE_CR_BASIS().setDisabled(true);*/
		} else {
			if ("F".equals(pm_il_clm_repay_bean.getCR_RESERVE_OPTIONS())) {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_RESERVE_OPTIONS().setDisabled(false);
//				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
//						.getCOMP_CR_RESERVE_OPTIONS().setRendered(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setDisabled(false);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_RESERVE_CR_BASIS().setDisabled(false);
				pm_il_clm_repay_bean.setCR_RESERVE_OPTIONS("F");
				pm_il_clm_repay_bean.setCR_RESERVE_CR_BASIS("T");
			} else if ("C".equals(pm_il_clm_repay_bean.getCR_RESERVE_OPTIONS())) {
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_RESERVE_OPTIONS().setDisabled(false);
//				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
//						.getCOMP_CR_RESERVE_OPTIONS().setRendered(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_NO_OF_YEARS().setDisabled(true);
				compositeAction.getPM_IL_CLM_REPAY_ACTION_BEAN()
						.getCOMP_CR_RESERVE_CR_BASIS().setDisabled(false);
				pm_il_clm_repay_bean.setCR_RESERVE_OPTIONS("C");
				pm_il_clm_repay_bean.setCR_RESERVE_CR_BASIS("T");
			}

		}

	}

	public void PRE_DELETE(PM_IL_CLM_REPAY pm_il_clm_repay_bean)
			throws Exception {
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
			String deleteQuery = "DELETE FROM PM_IL_CLM_REPAY_DTL P "
					+ "WHERE P.CRD_CR_COVER_CODE = ? "
					+ "and P.CRD_CR_LOSS_TYPE = ? "
					+ "and P.CRD_CR_DISABLE_TYPE = ?";

			handler.executeDeleteStatement(deleteQuery, con, new Object[] {
					pm_il_clm_repay_bean.getCR_COVER_CODE(),
					pm_il_clm_repay_bean.getCR_LOSS_TYPE(),
					pm_il_clm_repay_bean.getCR_DISABLE_TYPE() });
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<LovBean> callLov(String query, Object[] obj) {
		PM_IL_CLM_REPAY_DELEGATE delegate = new PM_IL_CLM_REPAY_DELEGATE();
		List<LovBean> suggestionList = null;
		suggestionList = delegate.prepareLovList(query, obj);
		return suggestionList;
	}

}
