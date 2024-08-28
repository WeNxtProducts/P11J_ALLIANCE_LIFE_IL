package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM055_APAC.CompositeAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.runtime.functions.NumericFunctions;

public class PM_IL_PRODUCT_HELPER {

	Object[] values = null;
	DBProcedures dbprocedures = new DBProcedures();

	public void PROD_PREM_PAY_YRS_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		int PREM_PAY_YRS = (Integer) currValue;
		try {
			if (CommonUtils.nvl(PREM_PAY_YRS, 0) < 1
					|| CommonUtils.nvl(PREM_PAY_YRS, 0) > CommonUtils.nvl(
							pm_il_product_bean.getPROD_PERIOD(), 0)) {
				/* to fix this call LIFE_JAVA-1662378 error message was changed by sujatha
				 throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[]{
								"Product Premium Paying Years",
								"Greater than 0",
								"and Less Than or Equal to"
										+ pm_il_product_bean.getPROD_PERIOD()}));*/
/*Added by Janani on 13-04-2017 for Handson Feedback Point Change Certificate to Policy*/
				
				/*throw new Exception("Premium Paying Years should be Greater than Or Equal to Certificate term");*/
				throw new Exception("Premium Paying Years should be Greater than Or Equal to Certificate term");
				
				/*End*/
			}
			
			if (CommonUtils.nvl(pm_il_product_bean.getPROD_PREM_PAY_YRS(),
					0) != CommonUtils.nvl(pm_il_product_bean
					.getPROD_PERIOD(), 0)) {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TARIFF_TERM_FLAG().setDisabled(false);
			} else {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TARIFF_TERM_FLAG().setDisabled(true);
			}
			/*if (CommonUtils.nvl(PREM_PAY_YRS, 0) < CommonUtils.nvl(
					pm_il_product_bean.getPROD_PERIOD(), 0)) {

				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TARIFF_TERM_FLAG().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TARIFF_TERM_FLAG().setRendered(false);
				pm_il_product_bean.setPROD_TARIFF_TERM_FLAG("1");
			} else {
				pm_il_product_bean.setPROD_TARIFF_TERM_FLAG("1");
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TARIFF_TERM_FLAG().setDisabled(true);
			}*/
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_SA_INST_PYMT_TYPE_WHEN_LIST_CHANGED(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection con = null;
		String M_DUMMY = null;
		Object[] values = null;
		ResultSet rs1 = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			con = CommonUtils.getConnection();
			String C1 = "SELECT 'X' ,PROD_SA_INST_PYMT_TYPE FROM "
					+ "PM_IL_PRODUCT WHERE " + "PROD_CODE =  ?";
			values = new Object[]{pm_il_product_bean.getPROD_CODE()};
			rs1 = handler.executeSelectStatement(C1, con, values);
			while (rs1.next()) {
				M_DUMMY = rs1.getString(1);
				dummy_bean.setUI_M_PROD_SA_INST_PYMT_TYPE(rs1.getString(2));
			}
			if (dummy_bean.getUI_M_PROD_SA_INST_PYMT_TYPE() != pm_il_product_bean
					.getPROD_SA_INST_PYMT_TYPE()) {
				dummy_bean.setUI_M_DUMMY(0);
				dummy_bean.setUI_M_DUMMY1(0);
			}
			if ("A".equalsIgnoreCase(pm_il_product_bean
					.getPROD_SA_INST_PYMT_TYPE())) {
				/*
				 * compositeAction.getTabbedBar().setTabEnabled(
				 * PILM035_APAC_COMPOSITE_ACTION.TAB_PM_IL_SA_INST_PYMT);
				 * compositeAction.getTabbedBar().setTabEnabled(
				 * PILM035_APAC_COMPOSITE_ACTION.TAB_PM_IL_SA_INST_PYMT1);
				 */
				compositeAction.getWizard().enableWizardItem(
						"PILM035_APAC_PM_IL_SA_INST_PYMT");
				compositeAction.getWizard().enableWizardItem(
						"PILM035_APAC_PM_IL_SA_INST_PYMT1");
			} else if ("B".equalsIgnoreCase(pm_il_product_bean
					.getPROD_SA_INST_PYMT_TYPE())) {
				/*
				 * compositeAction.getTabbedBar().setTabDisabled(
				 * PILM035_APAC_COMPOSITE_ACTION.TAB_PM_IL_SA_INST_PYMT);
				 * compositeAction.getTabbedBar().setTabEnabled(
				 * PILM035_APAC_COMPOSITE_ACTION.TAB_PM_IL_SA_INST_PYMT1);
				 */
				compositeAction.getWizard().disableWizardItem(
						"PILM035_APAC_PM_IL_SA_INST_PYMT");
				compositeAction.getWizard().enableWizardItem(
						"PILM035_APAC_PM_IL_SA_INST_PYMT1");
			} else if ("C".equalsIgnoreCase(pm_il_product_bean
					.getPROD_SA_INST_PYMT_TYPE())) {
				/*
				 * compositeAction.getTabbedBar().setTabDisabled(
				 * PILM035_APAC_COMPOSITE_ACTION.TAB_PM_IL_SA_INST_PYMT);
				 * compositeAction.getTabbedBar().setTabDisabled(
				 * PILM035_APAC_COMPOSITE_ACTION.TAB_PM_IL_SA_INST_PYMT1);
				 */
				compositeAction.getWizard().disableWizardItem(
						"PILM035_APAC_PM_IL_SA_INST_PYMT");
				compositeAction.getWizard().disableWizardItem(
						"PILM035_APAC_PM_IL_SA_INST_PYMT2");
			}
			if ("C".equalsIgnoreCase(pm_il_product_bean
					.getPROD_SA_INST_PYMT_TYPE())) {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_AMT_TYPE().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_AMT_TYPE().setRendered(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_RATE().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_RATE().setRendered(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_RATE_PER().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_RATE_PER().setRendered(true);
			} else if ("B".equalsIgnoreCase(pm_il_product_bean
					.getPROD_SA_INST_PYMT_TYPE())) {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_AMT_TYPE().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_AMT_TYPE().setRendered(true);
			} else {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_AMT_TYPE().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_RATE().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_RATE_PER().setDisabled(true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			CommonUtils.closeCursor(rs1);
		}
	}

	public void PROD_ROUND_OPTION_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String rod_round_option = (String) currValue;
		try {
			if ("R".equalsIgnoreCase(rod_round_option)
					|| "I".equalsIgnoreCase(rod_round_option)
					|| "U".equalsIgnoreCase(rod_round_option)
					|| "D".equalsIgnoreCase(rod_round_option)) {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_ROUND_VALUE().setDisabled(false);
			} else {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_ROUND_VALUE().setDisabled(true);
			}
			if ("R".equalsIgnoreCase(rod_round_option)
					|| "I".equalsIgnoreCase(rod_round_option)
					|| "U".equalsIgnoreCase(rod_round_option)
					|| "D".equalsIgnoreCase(rod_round_option)) {

				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_ROUND_VALUE().setRequired(true);
			} else {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_ROUND_VALUE().setRequired(false);
			}
			if ("I".equalsIgnoreCase(rod_round_option)) {
				pm_il_product_bean.setPROD_ROUND_VALUE(5);
			} else {
				pm_il_product_bean.setPROD_ROUND_VALUE(null);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_THRESHOLD_PERC_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		double prod_threshold_perc = (Double) currValue;
		try {
			if (CommonUtils.nvl(prod_threshold_perc, 0) < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "60111"));
			}
			if (CommonUtils.nvl(prod_threshold_perc, 0) > 100) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71017"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_AGENT_HIRE_YN_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
			if ("Y"
					.equalsIgnoreCase(pm_il_product_bean
							.getPROD_AGENT_HIRE_YN())
					&& "6".equalsIgnoreCase(pm_il_product_bean
							.getPROD_BROK_CALC_MTHD())) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3206",
						new Object[]{"Actual Premium Paid cannot "
								+ "be selected if Agent Hierarchy is yes"}));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_GRP_THRESHOLD_PERC_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		double prod_grp_threshold_perc = (Double) currValue;
		try {
			if (CommonUtils.nvl(prod_grp_threshold_perc, 0) < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "60111"));
			}
			if (CommonUtils.nvl(prod_grp_threshold_perc, 0) > 100) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71017"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_SA_INST_PYMT_TYPE_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		PM_IL_PRODUCT_ACTION pm_il_product_action_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Connection con = null;
		Object[] values = null;
		ResultSet rs1 = null;
		String M_DUMMY = null;
		CRUDHandler handler = new CRUDHandler();
		String PROD_SA_INST_PYMT_TYPE = (String) currValue;
		try {
			con = CommonUtils.getConnection();
			String C1 = "SELECT 'X' ,PROD_SA_INST_PYMT_TYPE "
					+ "FROM   PM_IL_PRODUCT " + "WHERE  PROD_CODE = ?";
			values = new Object[]{pm_il_product_bean.getPROD_CODE()};
			rs1 = handler.executeSelectStatement(C1, con, values);
			while (rs1.next()) {
				M_DUMMY = rs1.getString(1);
				dummy_bean.setUI_M_PROD_SA_INST_PYMT_TYPE(rs1.getString(2));
			}
			if (dummy_bean.getUI_M_PROD_SA_INST_PYMT_TYPE() != PROD_SA_INST_PYMT_TYPE) {
				dummy_bean.setUI_M_DUMMY(0);
				dummy_bean.setUI_M_DUMMY1(0);
			}
			if ("A".equalsIgnoreCase(PROD_SA_INST_PYMT_TYPE)) {

				/*
				 * compositeAction.getTabbedBar().setTabDisabled(
				 * compositeAction.TAB_PM_IL_SA_INST_PYMT1);
				 * compositeAction.getTabbedBar().setTabEnabled(
				 * compositeAction.TAB_PM_IL_SA_INST_PYMT);
				 */
				compositeAction.getWizard().disableWizardItem(
						"PILM035_APAC_PM_IL_SA_INST_PYMT1");
				compositeAction.getWizard().enableWizardItem(
						"PILM035_APAC_PM_IL_SA_INST_PYMT");
			} else if ("B".equalsIgnoreCase(PROD_SA_INST_PYMT_TYPE)) {
				/*
				 * compositeAction.getTabbedBar().setTabDisabled(
				 * compositeAction.TAB_PM_IL_SA_INST_PYMT);
				 * compositeAction.getTabbedBar().setTabEnabled(
				 * compositeAction.TAB_PM_IL_SA_INST_PYMT1);
				 */
				compositeAction.getWizard().disableWizardItem(
						"PILM035_APAC_PM_IL_SA_INST_PYMT");
				compositeAction.getWizard().enableWizardItem(
						"PILM035_APAC_PM_IL_SA_INST_PYMT1");
			} else if ("C".equalsIgnoreCase(pm_il_product_bean
					.getPROD_SA_INST_PYMT_TYPE())) {
				/*
				 * compositeAction.getTabbedBar().setTabDisabled(
				 * compositeAction.TAB_PM_IL_SA_INST_PYMT);
				 * compositeAction.getTabbedBar().setTabDisabled(
				 * compositeAction.TAB_PM_IL_SA_INST_PYMT1);
				 */
				compositeAction.getWizard().disableWizardItem(
						"PILM035_APAC_PM_IL_SA_INST_PYMT");
				compositeAction.getWizard().disableWizardItem(
						"PILM035_APAC_PM_IL_SA_INST_PYMT1");
			}else if("D".equalsIgnoreCase(pm_il_product_bean
					.getPROD_SA_INST_PYMT_TYPE())){
				if("Y".equalsIgnoreCase(pm_il_product_bean.getPROD_JOINT_LIFE_YN())){
					compositeAction.getWizard().disableWizardItem(
											"PILM035_APAC_PM_IL_SA_INST_PYMT");
					compositeAction.getWizard().disableWizardItem(
											"PILM035_APAC_PM_IL_SA_INST_PYMT1");
					compositeAction.getWizard().enableWizardItem(
											"PILM035_APAC_PM_IL_SA_INST_PYMT2");
				}else{
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "92055"));
				}
			}

			if ("C".equalsIgnoreCase(PROD_SA_INST_PYMT_TYPE) || "D".equalsIgnoreCase(PROD_SA_INST_PYMT_TYPE)) {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_AMT_TYPE().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_AMT_TYPE().setRendered(true);

				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_AMT_TYPE().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_AMT_TYPE().setRendered(true);

				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_RATE().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_RATE().setRendered(true);

				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_RATE_PER().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_RATE_PER().setRendered(true);

			} else if ("B".equalsIgnoreCase(PROD_SA_INST_PYMT_TYPE)) {

				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_AMT_TYPE().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_AMT_TYPE().setRendered(true);
			} else {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_AMT_TYPE().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_RATE().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_RATE_PER().setDisabled(true);
			}

			if ("B" != PROD_SA_INST_PYMT_TYPE || "C" != PROD_SA_INST_PYMT_TYPE) {
				P_DISB_TXT(pm_il_product_action_bean);
			} else if ("B".equalsIgnoreCase(PROD_SA_INST_PYMT_TYPE)
					|| "C".equalsIgnoreCase(PROD_SA_INST_PYMT_TYPE)) {
				P_ENAB_TXT(pm_il_product_action_bean);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			CommonUtils.closeCursor(rs1);
		}
	}

	public void PROD_DEF_PERIOD_FLAG_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		String prod_def_period_flag = (String) currValue;
		try {
			if ("Y".equalsIgnoreCase(prod_def_period_flag)) {
			} else {
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_DS_CODE_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		PM_IL_PRODUCT_ACTION pm_il_product_action_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN();
		try {
			//below modified by kavitha on 08.01.2019 as per siva sir sugg
			/*if ("C" != pm_il_product_bean.getPROD_SA_INST_PYMT_TYPE()) {*/
			/*Modified by kavitha on 08.01.2019 */
			if (!"C".equals(pm_il_product_bean.getPROD_SA_INST_PYMT_TYPE())) {
				P_DISB_TXT(pm_il_product_action_bean);
			} else if ("C".equalsIgnoreCase(pm_il_product_bean
					.getPROD_SA_INST_PYMT_TYPE())
					|| "B".equalsIgnoreCase(pm_il_product_bean
							.getPROD_SA_INST_PYMT_TYPE())) {
				P_ENAB_TXT(pm_il_product_action_bean);
			}
			if (pm_il_product_bean.getPROD_DS_CODE() != null) {

				String prod_ds_code_desc = dbprocedures.P_VAL_DS(
						(String) currValue, "N", "E");
				pm_il_product_bean.setUI_M_PROD_DS_CODE_DESC(prod_ds_code_desc);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_FUND_ALLOWED_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
			if (pm_il_product_bean.getPROD_EFF_FM_DT() != null
					&& pm_il_product_bean.getPROD_EFF_TO_DT() != null) {
				if (pm_il_product_bean.getPROD_EFF_FM_DT().after(
						pm_il_product_bean.getPROD_EFF_TO_DT())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91001"));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_TOL_CHK_YN_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
			if (pm_il_product_bean.getPROD_EFF_FM_DT() != null
					&& pm_il_product_bean.getPROD_EFF_TO_DT() != null) {
				if (pm_il_product_bean.getPROD_EFF_FM_DT().after(
						pm_il_product_bean.getPROD_EFF_TO_DT())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91001"));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_COOLOFF_DAYS_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		int prod_cooloff_days = (Integer) currValue;
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
			if (prod_cooloff_days != 0) {
				if (prod_cooloff_days > pm_il_product_bean
						.getPROD_ENDT_VAL_DAYS()) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91140"));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_SA_ADD_FACTOR_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
			if (pm_il_product_bean.getPROD_SA_ADD_FACTOR() != null) {
				ArrayList<String> code_desc = new DBProcedures()
						.P_VAL_CODES_PM_CHARGER(
								"IL_VAL_TAR",
								pm_il_product_bean.getPROD_SA_ADD_FACTOR(),
								pm_il_product_bean.getPROD_SA_ADD_FACTOR_DESC(),
								"N", "N", null);
				pm_il_product_bean.setPROD_SA_ADD_FACTOR_DESC(code_desc.get(0));
			} else {
				pm_il_product_bean.setPROD_SA_ADD_FACTOR_DESC("");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_ENDT_VAL_DAYS_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_PREM_CALC_MTHD_WHEN_LIST_CHANGED(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_PREM_CALC_MTHD_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		Connection con = null;
		ResultSet rs1 = null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		String prod_prem_calc_mthd = (String) currValue;
		String M_PLAN_RED_SA_BASIS = null;
		String C1 = "SELECT PLAN_RED_SA_BASIS " + "FROM PM_IL_PLAN "
				+ "WHERE PLAN_CODE = ?";
		try {
			con = CommonUtils.getConnection();
			values = new Object[]{pm_il_product_bean.getPROD_PLAN_CODE()};
			rs1 = handler.executeSelectStatement(C1, con, values);
			while (rs1.next()) {
				M_PLAN_RED_SA_BASIS = rs1.getString(1);
			}

			if ("R".equalsIgnoreCase(M_PLAN_RED_SA_BASIS)
					&& "X".equalsIgnoreCase(prod_prem_calc_mthd)) {

				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_CONT_LOAD_RATE().setRequired(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_CONT_LOAD_RATE_PER().setRequired(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_EXP_LOAD_RATE().setRequired(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_EXP_LOAD_RATE_PER().setRequired(true);

				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MRTA_RATE_CALC_YN().setRequired(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MRTA_RATE_CALC_YN().setDisabled(true);

				// SET_ITEM_PROPERTY('PM_IL_PRODUCT.PROD_MRTA_RATE_CALC_YN',NAVIGABLE,PROPERTY_FALSE);
				// SET_ITEM_PROPERTY('PM_IL_PRODUCT.PROD_MRTA_RATE_CALC_YN',UPDATE_ALLOWED,PROPERTY_FALSE);
			}

			else if ("R".equalsIgnoreCase(M_PLAN_RED_SA_BASIS)
					&& "T".equalsIgnoreCase(prod_prem_calc_mthd)) {

				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_CONT_LOAD_RATE().setRequired(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_CONT_LOAD_RATE_PER().setRequired(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_EXP_LOAD_RATE().setRequired(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_EXP_LOAD_RATE_PER().setRequired(false);

				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MRTA_RATE_CALC_YN().setRequired(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MRTA_RATE_CALC_YN().setDisabled(false);

				// SET_ITEM_PROPERTY('PM_IL_PRODUCT.PROD_MRTA_RATE_CALC_YN',NAVIGABLE,PROPERTY_TRUE);
				// SET_ITEM_PROPERTY('PM_IL_PRODUCT.PROD_MRTA_RATE_CALC_YN',UPDATE_ALLOWED,PROPERTY_TRUE);
			}
			if ("T".equalsIgnoreCase(prod_prem_calc_mthd)) {

				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MRTA_RATE_CALC_YN().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MRTA_RATE_CALC_YN().setRequired(true);
				// SET_ITEM_PROPERTY('PM_IL_PRODUCT.PROD_MRTA_RATE_CALC_YN',NAVIGABLE,PROPERTY_TRUE);
				// SET_ITEM_PROPERTY('PM_IL_PRODUCT.PROD_MRTA_RATE_CALC_YN',UPDATE_ALLOWED,PROPERTY_TRUE);
			} else if ("X".equalsIgnoreCase(prod_prem_calc_mthd)) {
				pm_il_product_bean.setPROD_MRTA_RATE_CALC_YN(null);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MRTA_RATE_CALC_YN().setDisabled(true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			CommonUtils.closeCursor(rs1);
		}
	}

	public void PROD_AFTWD_LC_MINBAL_KEY_NEXT_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_BCH_CODE_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();

		String prod_bch_code = (String) currValue;
		String M_PROD_BCH_CODE_DESC = null;
		Connection con = null;
		ResultSet rs1 = null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			con = CommonUtils.getConnection();
			String C1 = "SELECT BCH_DESC FROM  PM_BROKER_COMM_HDR "
					+ "WHERE  BCH_CODE = ?";

			values = new Object[]{prod_bch_code};
			rs1 = handler.executeSelectStatement(C1, con, values);
			if (prod_bch_code != null) {

				while (rs1.next()) {
					M_PROD_BCH_CODE_DESC = rs1.getString(1);
				}
				if (M_PROD_BCH_CODE_DESC == null
						|| M_PROD_BCH_CODE_DESC.equals("")) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "3206"));
				} else {
					pm_il_product_bean
							.setPROD_BCH_CODE_DESC(M_PROD_BCH_CODE_DESC);
				}

			} else {
				pm_il_product_bean.setPROD_BCH_CODE_DESC(null);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			CommonUtils.closeCursor(rs1);
		}
	}

	public void PROD_BCH_CODE_KEY_LISTVAL(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_COMM_RND_DEC_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		int prod_comm_rnd_dec = (Integer) currValue;
		Connection con = null;
		ResultSet rs1 = null;
		CRUDHandler handler = new CRUDHandler();
		int M_CUR_DEC = 0;
		Object[] values = null;
		String C1 = "SELECT CURR_DECIMAL "
			+ "FROM   FM_CURRENCY,FP_PARAMETER "
			+ "WHERE  CURR_CODE =  PARA_VALUE "
			+ "AND    PARA_ID	 = 'BASE.CURR'";
		try {
			con = CommonUtils.getConnection();

			rs1 = handler.executeSelectStatement(C1, con);
			while (rs1.next()) {
				M_CUR_DEC = rs1.getInt(1);
			}
			if ((CommonUtils.nvl(prod_comm_rnd_dec, 0) > CommonUtils.nvl(
					M_CUR_DEC, 0))
					|| (CommonUtils.nvl(prod_comm_rnd_dec, 0) < 0)) {

				values = new Object[]{CommonUtils.nvl(M_CUR_DEC, 0)};
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91260", values));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			CommonUtils.closeCursor(rs1);
		}
	}

	public void ITEM760_WHEN_BUTTON_PRESSED(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void M_BUT_LOV_PROD_BCH_CODE_WHEN_BUTTON_PRESSED(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void M_LOV_PROD_SURRENDER_FACTOR_WHEN_BUTTON_PRESSED(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void M_EDIT_PROD_BL_DESC_WHEN_BUTTON_PRESSED(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void M_LOV_BUT_PROD_SURR_PLUS_FACTO_WHEN_BUTTON_PRESSED(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_MAT_AMT_TYPE_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		String prod_mat_amt_type = (String) currValue;
		try {
			if ("PAPN".equalsIgnoreCase(prod_mat_amt_type)
					|| "N".equalsIgnoreCase(prod_mat_amt_type)) {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_SURR_PLUS_FACTOR().setDisabled(false);
			} else {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_SURR_PLUS_FACTOR().setDisabled(true);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_MAT_AMT_TYPE_WHEN_LIST_CHANGED(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		String prod_mat_amt_type = (String) currValue;
		try {
			if ("PAPN".equalsIgnoreCase(prod_mat_amt_type)
					|| "N".equalsIgnoreCase(prod_mat_amt_type)) {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_SURR_PLUS_FACTOR().setDisabled(false);
			} else {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_SURR_PLUS_FACTOR().setDisabled(true);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_SURR_PLUS_FACTOR_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String prod_surr_plus_factor = (String) currValue;
		try {
			if (prod_surr_plus_factor != null) {
				ArrayList<String> prod_surr_plus_factor_desc = dbprocedures
						.P_VAL_CODES_PM_CHARGER("IL_VAL_TAR",
								prod_surr_plus_factor, pm_il_product_bean
										.getPROD_SURR_PLUS_FACTOR_DESC(), "E",
								"N", null, null, "ENG", null);
				pm_il_product_bean
						.setPROD_SURR_PLUS_FACTOR_DESC(prod_surr_plus_factor_desc
								.get(0));
			} else {
				pm_il_product_bean.setPROD_SURR_PLUS_FACTOR_DESC(null);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_MAT_AMT_TYPE_KEY_PREV_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_PERIOD_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		int PROD_PERIOD = (Integer) currValue;
		int dummy_plan_period_from =0;
		int dummy_plan_period_to = 0;
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		try {
			 if(dummy_bean.getUI_M_PLAN_PERIOD_FROM() != null){
			 dummy_plan_period_from = dummy_bean.getUI_M_PLAN_PERIOD_FROM();
			 }
			 if(dummy_bean.getUI_M_PLAN_PERIOD_TO() != null){
			 dummy_plan_period_to = dummy_bean.getUI_M_PLAN_PERIOD_TO();
			 }
			if (CommonUtils.nvl(PROD_PERIOD, 0) < 1
					|| ((CommonUtils.nvl(PROD_PERIOD, 0) < dummy_plan_period_from) && (CommonUtils
							.nvl(PROD_PERIOD, 0) > dummy_plan_period_to))) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[]{"Product Peroiod in Between ",
								dummy_bean.getUI_M_PLAN_PERIOD_FROM(), " and "+
								dummy_bean.getUI_M_PLAN_PERIOD_TO()}));
				// STD_MESSAGE_ROUTINE(91014,:CTRL.M_LANG_CODE,' Product Peroiod
				// ',' Between '||:DUMMY.M_PLAN_PERIOD_FROM,' and
				// '||:DUMMY.M_PLAN_PERIOD_TO);
				// RAISE FORM_TRIGGER_FAILURE;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_PERIOD_PRE_TEXT_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PBN_BACK_CVR_WHEN_BUTTON_PRESSED(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void M_BUT_WAK_CODE_LOV_WHEN_BUTTON_PRESSED(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void M_BUT_LOV_PROD_PLAN_CODE_WHEN_BUTTON_PRESSED(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_EFF_TO_DT_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		Date to_date = (Date) currValue;
		try {
			if (pm_il_product_bean.getPROD_EFF_FM_DT() != null
					&& to_date != null) {
				if (pm_il_product_bean.getPROD_EFF_FM_DT().after(to_date)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91001"));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_MIN_SURR_AMT_KEY_PREV_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_MIN_SURR_AMT_KEY_NEXT_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_MORT_CODE_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String prod_mort_code = (String) currValue;
		try {
			if (prod_mort_code != null) {
				ArrayList<String> prod_mort_code_desc = dbprocedures
						.P_VAL_CODES_PM_CHARGER("IL_VAL_TAR", prod_mort_code,
								pm_il_product_bean.getPROD_MORT_CODE_DESC(),
								"N", "N", null, null, "ENG", null);
				pm_il_product_bean.setPROD_MORT_CODE_DESC(prod_mort_code_desc
						.get(0));
			} else {
				pm_il_product_bean.setPROD_MORT_CODE_DESC(null);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_MORT_CODE_KEY_LISTVAL(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_TOLL_LIMIT_YN_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String prod_toll_limit_yn = (String) currValue;
		try {
			if ("N".equalsIgnoreCase(prod_toll_limit_yn)) {
				pm_il_product_bean.setPROD_INTER_FUND_YN("N");
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INTER_FUND_YN().setDisabled(true);
			}
			if ("Y".equalsIgnoreCase(prod_toll_limit_yn)) {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INTER_FUND_YN().setDisabled(false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_PLAN_CODE_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		ResultSet rs = null;
		ResultSet rs2 = null;
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values = null;
		Object[] c2values = null;
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String M_COVER_SA_CALC = null;
		String M_PLAN_SA_INST_PYMT_YN = null;
		String M_PLAN_TYPE = null;
		String M_PLAN_RED_SA_BASIS = null;

		String c1 = " SELECT  NVL(PLAN_SA_INST_PYMT_YN,'N'),NVL(PLAN_PERIOD_FROM,0), "
				+ "NVL(PLAN_PERIOD_TO,0),NVL(PLAN_MAX_AGE_ON_MAT,0),PLAN_TYPE, PLAN_RED_SA_BASIS "
				+ "FROM    PM_IL_PLAN WHERE   PLAN_CODE = ?";

		String c2 = " SELECT COVER_SA_CALC FROM   PM_IL_COVER "
				+ "WHERE  COVER_CODE = ?  ";

		try {
			if (!(currValue.equals(pm_il_product_bean.getPROD_PLAN_CODE()))) {
				con = CommonUtils.getConnection();
				String plan_code_desc = DBProcedures.P_VAL_PLAN(con,
						pm_il_product_bean.getPROD_PLAN_CODE(),
						pm_il_product_bean.getUI_M_PROD_PLAN_CODE_DESC(), "N",
						"E");
				if(plan_code_desc != null){
				pm_il_product_bean.setUI_M_PROD_PLAN_CODE_DESC(plan_code_desc);
				}
				pm_il_product_bean.setPROD_PERIOD(0);
				pm_il_product_bean.setPROD_PREM_PAY_YRS(0);
				pm_il_product_bean.setPROD_MATU_DT(pm_il_product_bean.getPROD_MATU_DT());
				values = new Object[]{(String) currValue};
				rs = handler.executeSelectStatement(c1, con, values);
				while (rs.next()) {
					M_PLAN_SA_INST_PYMT_YN = rs.getString(1);
					dummy_bean.setUI_M_PLAN_PERIOD_FROM(rs.getInt(2));
					dummy_bean.setUI_M_PLAN_PERIOD_TO(rs.getInt(3));
					dummy_bean.setUI_M_PLAN_MAX_AGE_ON_MAT(rs.getInt(4));
					M_PLAN_TYPE = rs.getString(5);
					M_PLAN_RED_SA_BASIS = rs.getString(6);
				}

				if ("J".equalsIgnoreCase(M_PLAN_TYPE)) {
					pm_il_product_bean.setPROD_JOINT_LIFE_YN("Y");
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_JOINT_LIFE_YN().setDisabled(true);
				} else {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_JOINT_LIFE_YN().setDisabled(false);
				}

				if ("N".equalsIgnoreCase(M_PLAN_SA_INST_PYMT_YN)) {

					pm_il_product_bean.setPROD_SA_INST_PYMT_TYPE("C");
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_SA_INST_PYMT_TYPE().setDisabled(true);
					/*
					 * compositeAction.getTabbedBar().setTabDisabled(
					 * compositeAction.TAB_PM_IL_SA_INST_PYMT);
					 * compositeAction.getTabbedBar().setTabDisabled(
					 * compositeAction.TAB_PM_IL_SA_INST_PYMT1);
					 * compositeAction.getTabbedBar().setTabDisabled(
					 * compositeAction.TAB_PM_IL_SA_INST_PYMT2);
					 */
					compositeAction.getWizard().disableWizardItem(
							"PILM035_APAC_PM_IL_SA_INST_PYMT");
					compositeAction.getWizard().disableWizardItem(
							"PILM035_APAC_PM_IL_SA_INST_PYMT1");
					compositeAction.getWizard().disableWizardItem(
							"PILM035_APAC_PM_IL_SA_INST_PYMT2");
				} else {

					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_SA_INST_PYMT_TYPE()
							.setDisabled(false);

					/*
					 * compositeAction.getTabbedBar().setTabEnabled(
					 * compositeAction.TAB_PM_IL_SA_INST_PYMT);
					 * compositeAction.getTabbedBar().setTabEnabled(
					 * compositeAction.TAB_PM_IL_SA_INST_PYMT1);
					 * compositeAction.getTabbedBar().setTabEnabled(
					 * compositeAction.TAB_PM_IL_SA_INST_PYMT2);
					 */
					compositeAction.getWizard().enableWizardItem(
							"PILM035_APAC_PM_IL_SA_INST_PYMT");
					compositeAction.getWizard().enableWizardItem(
							"PILM035_APAC_PM_IL_SA_INST_PYMT1");
					compositeAction.getWizard().enableWizardItem(
							"PILM035_APAC_PM_IL_SA_INST_PYMT2");
				}

				if ("R".equalsIgnoreCase(M_PLAN_RED_SA_BASIS)) {

					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_ENDT_VAL_DAYS().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_ENDT_VAL_DAYS().setRequired(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_COOLOFF_DAYS().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_COOLOFF_DAYS().setRequired(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_EMI_TOLERANCE().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_EMI_TOLERANCE().setRequired(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_AGE_SET_BACK().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MORT_CODE().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_CBC_YN().setDisabled(false);
				} else {
					pm_il_product_bean.setPROD_ENDT_VAL_DAYS(0);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_ENDT_VAL_DAYS().setDisabled(true);
					pm_il_product_bean.setPROD_COOLOFF_DAYS(0);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_COOLOFF_DAYS().setDisabled(true);

					pm_il_product_bean.setPROD_MORT_CODE("");
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MORT_CODE().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MORT_CODE().setRequired(false);
					compositeAction
							.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
							.getCOMP_PALT_LOAD_APPL_PERC().setDisabled(true);
					pm_il_product_bean.setPROD_AGE_SET_BACK(0);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_AGE_SET_BACK().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_AGE_SET_BACK().setRequired(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_CBC_YN().setDisabled(false);
				}
				/*if (("M".equalsIgnoreCase(M_PLAN_TYPE))
						|| ("U".equalsIgnoreCase(M_PLAN_TYPE))
						|| ("R".equalsIgnoreCase(M_PLAN_RED_SA_BASIS))) {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_MORE_INFO_3().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_REM_INFO_5().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_MORE_INFO_2().setDisabled(false);
				} else {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_MORE_INFO_3().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_REM_INFO_5().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_MORE_INFO_2().setDisabled(true);

				}*/
				
				if("M".equalsIgnoreCase(M_PLAN_TYPE))
				{
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
					.getCOMP_MORE_INFO_2().setDisabled(false);
				}
				else
				{
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
					.getCOMP_MORE_INFO_2().setDisabled(true);
				}
				if("U".equalsIgnoreCase(M_PLAN_TYPE))
				{
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
					.getCOMP_MORE_INFO_3().setDisabled(false);
				}
				else
				{
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
					.getCOMP_MORE_INFO_3().setDisabled(true);
				}
				if (("D".equalsIgnoreCase(M_PLAN_TYPE))) {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_ANNUITY_PARAPETERS_TAB()
							.setDisabled(false);
				} else {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_ANNUITY_PARAPETERS_TAB().setDisabled(true);
				}

				if (("M".equalsIgnoreCase(M_PLAN_TYPE))
						|| ("R".equalsIgnoreCase(M_PLAN_RED_SA_BASIS))) {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MAX_DEFER_MONTHS().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MAX_DEFER_MONTHS().setRequired(true);
					pm_il_product_bean.setPROD_MAX_DEFER_MONTHS(null);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_DEF_PERIOD_FLAG().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_DEF_PERIOD_FLAG().setRequired(true);
					pm_il_product_bean.setPROD_DEF_PERIOD_FLAG("M");
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_RSA_CALC_TYP().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_RSA_CALC_TYP().setRequired(true);
					pm_il_product_bean.setPROD_RSA_CALC_TYP("F");
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_CONT_LOAD_RATE().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_CONT_LOAD_RATE().setRequired(true);
					pm_il_product_bean.setPROD_CONT_LOAD_RATE(0.0);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_CONT_LOAD_RATE_PER().setDisabled(
									false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_CONT_LOAD_RATE_PER()
							.setRequired(true);
					pm_il_product_bean.setPROD_CONT_LOAD_RATE_PER(0);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_EXP_LOAD_RATE().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_EXP_LOAD_RATE().setRequired(true);
					pm_il_product_bean.setPROD_EXP_LOAD_RATE(0.0);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_EXP_LOAD_RATE_PER()
							.setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_EXP_LOAD_RATE_PER().setRequired(true);
					pm_il_product_bean.setPROD_EXP_LOAD_RATE_PER(0);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_PREM_CALC_MTHD().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_BASIS().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_PERC().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_PERC().setRequired(true);
					pm_il_product_bean.setPROD_INST_PERC(0.0);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_RATE_PER().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_RATE_PER().setRequired(true);
					pm_il_product_bean.setPROD_INST_RATE_PER(0.0);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_AGE_SET_BACK().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_AGE_SET_BACK().setRequired(true);
					pm_il_product_bean.setPROD_AGE_SET_BACK(0);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MRTA_RATE_CALC_YN()
							.setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MRTA_RATE_CALC_YN().setRequired(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MORT_CODE().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MORT_CODE().setRequired(true);
					pm_il_product_bean.setPROD_MORT_CODE("");
				} else {
					pm_il_product_bean.setPROD_MAX_DEFER_MONTHS(0);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MAX_DEFER_MONTHS().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MAX_DEFER_MONTHS().setRequired(false);
					pm_il_product_bean.setPROD_DEF_PERIOD_FLAG("N");
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_DEF_PERIOD_FLAG().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_DEF_PERIOD_FLAG().setRequired(false);
					pm_il_product_bean.setPROD_RSA_CALC_TYP("N");
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_RSA_CALC_TYP().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_RSA_CALC_TYP().setRequired(false);
					pm_il_product_bean.setPROD_CONT_LOAD_RATE(0.0);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_CONT_LOAD_RATE_PER()
							.setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_CONT_LOAD_RATE_PER().setRequired(
									false);
					pm_il_product_bean.setPROD_CONT_LOAD_RATE_PER(0);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_EXP_LOAD_RATE().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_EXP_LOAD_RATE().setRequired(false);
					pm_il_product_bean.setPROD_EXP_LOAD_RATE(0.0);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_EXP_LOAD_RATE().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_EXP_LOAD_RATE().setRequired(false);
					pm_il_product_bean.setPROD_EXP_LOAD_RATE_PER(0);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_EXP_LOAD_RATE_PER().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_EXP_LOAD_RATE_PER()
							.setRequired(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_PREM_CALC_MTHD().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_BASIS().setDisabled(true);
					pm_il_product_bean.setPROD_INST_PERC(0.0);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_PERC().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_PERC().setRequired(false);
					pm_il_product_bean.setPROD_INST_RATE_PER(0.0);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_RATE_PER().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_RATE_PER().setRequired(false);
					pm_il_product_bean.setPROD_AGE_SET_BACK(0);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_AGE_SET_BACK().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_AGE_SET_BACK().setRequired(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MRTA_RATE_CALC_YN().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MRTA_RATE_CALC_YN()
							.setRequired(false);
					pm_il_product_bean.setPROD_MORT_CODE("");
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MORT_CODE().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MORT_CODE().setRequired(false);
					pm_il_product_bean.setPROD_MORT_CODE_DESC("");
					compositeAction
							.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
							.getCOMP_PALT_LOAD_APPL_PERC().setDisabled(true);
				}

				if (M_PLAN_TYPE != "M" && M_PLAN_TYPE != "N") {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_ENDT_VAL_DAYS().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_COOLOFF_DAYS().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_EMI_TOLERANCE().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_AGE_SET_BACK().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MORT_CODE().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_CBC_YN().setDisabled(false);

				}

				if (M_PLAN_TYPE != "M" || M_PLAN_TYPE != "U") {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_MORE_INFO_3().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_REM_INFO_5().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_WITHDRAW_YN().setDisabled(false);
				}

				else if ("M".equalsIgnoreCase(M_PLAN_TYPE)
						|| ("U".equalsIgnoreCase(M_PLAN_TYPE))) {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_WITHDRAW_YN().setDisabled(true);

				}

				if ("R".equalsIgnoreCase(M_PLAN_RED_SA_BASIS)
						&& ("N".equalsIgnoreCase(pm_il_product_bean
								.getPROD_INST_BASIS()))) {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_PERC().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_PERC().setRequired(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_RATE_PER().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_RATE_PER().setRequired(false);
				} else if (("R".equalsIgnoreCase(M_PLAN_RED_SA_BASIS))
						&& ("P".equalsIgnoreCase(pm_il_product_bean
								.getPROD_INST_BASIS()))) {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_PERC().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_PERC().setRequired(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_RATE_PER().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_RATE_PER().setRequired(true);
				} else {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_PERC().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_PERC().setRequired(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_RATE_PER().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_RATE_PER().setRequired(false);
				}
				if ("U".equalsIgnoreCase(M_PLAN_TYPE)) {
					/*
					 * compositeAction.getTabbedBar().setTabEnabled(
					 * compositeAction.TAB_PM_IL_PROD_APPL_FUND);
					 */
					compositeAction.getWizard().enableWizardItem(
							"PILM035_APAC_PM_IL_PROD_APPL_FUND");
				} else {
					/*
					 * compositeAction.getTabbedBar().setTabDisabled(
					 * compositeAction.TAB_PM_IL_PROD_APPL_FUND);
					 */
					compositeAction.getWizard().disableWizardItem(
							"PILM035_APAC_PM_IL_PROD_APPL_FUND");
				}

				c2values = new Object[]{(String) currValue};
				rs2 = handler.executeSelectStatement(c2, con, c2values);
				while (rs2.next()) {
					M_COVER_SA_CALC = rs2.getString(1);
				}

				if ("D".equalsIgnoreCase(M_COVER_SA_CALC)
						|| "A".equalsIgnoreCase(M_COVER_SA_CALC)
						|| "H".equalsIgnoreCase(M_COVER_SA_CALC)) {

					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_SA_FACTOR().setDisabled(false);
				}
				if ("H".equalsIgnoreCase(M_COVER_SA_CALC)) {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_SA_FACTOR().setDisabled(false);
				} else {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_SA_FACTOR().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_SA_ADD_FACTOR().setDisabled(true);
				}
				if ("C" != pm_il_product_bean.getPROD_SA_INST_PYMT_TYPE()
						|| "B" != pm_il_product_bean
								.getPROD_SA_INST_PYMT_TYPE()) {
				} else if (("C".equalsIgnoreCase(pm_il_product_bean
						.getPROD_SA_INST_PYMT_TYPE()))
						|| ("B".equalsIgnoreCase(pm_il_product_bean
								.getPROD_SA_INST_PYMT_TYPE()))) {
				}

				if (("R".equalsIgnoreCase(M_PLAN_RED_SA_BASIS) && ("T"
						.equalsIgnoreCase(pm_il_product_bean
								.getPROD_PREM_CALC_MTHD())))) {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MRTA_RATE_CALC_YN()
							.setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MRTA_RATE_CALC_YN().setRequired(true);
				} else if (("R".equalsIgnoreCase(M_PLAN_RED_SA_BASIS))
						&& ("X".equalsIgnoreCase(pm_il_product_bean
								.getPROD_PREM_CALC_MTHD()))) {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MRTA_RATE_CALC_YN().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MRTA_RATE_CALC_YN()
							.setRequired(false);
				}

				if ("U".equalsIgnoreCase(M_PLAN_TYPE)) {

					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_BUY_BASIS().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_ALLOC_TYPE().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_CALC_ALLOC().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_PREM_HOLIDAY_CODE()
							.setDisabled(false);

				} else {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_BUY_BASIS().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_ALLOC_TYPE().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_CALC_ALLOC().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_PREM_HOLIDAY_CODE().setDisabled(true);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(rs);
			CommonUtils.closeCursor(rs2);
		}

	}

	public void PROD_PREM_HOLIDAY_CODE_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String prod_prem_holiday_code = (String) currValue;
		try {
			if (prod_prem_holiday_code != null) {
				ArrayList<String> prod_prem_holiday_code_desc = dbprocedures
						.P_VAL_CODES_PM_CHARGER("IL_VAL_TAR",
								prod_prem_holiday_code, pm_il_product_bean
										.getPROD_PREM_HOLIDAY_CODE_DESC(), "N",
								"E", null, null, "ENG", null);
				pm_il_product_bean
						.setPROD_PREM_HOLIDAY_CODE_DESC(prod_prem_holiday_code_desc
								.get(0));
			} else {
				pm_il_product_bean.setPROD_PREM_HOLIDAY_CODE_DESC(null);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_PREM_TARIFF_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String prod_prem_tariff = (String) currValue;
		try {
			if (prod_prem_tariff != null) {
				ArrayList<String> prod_prem_tariff_desc = dbprocedures
						.P_VAL_CODES_PM_CHARGER("IL_VAL_TAR", prod_prem_tariff,
								pm_il_product_bean.getPROD_PREM_TARIFF_DESC(),
								"N", "E", null, null, "ENG", null);
				pm_il_product_bean
						.setPROD_PREM_TARIFF_DESC(prod_prem_tariff_desc.get(0));
			} else {
				pm_il_product_bean.setPROD_PREM_TARIFF_DESC("");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_MATU_DT_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		Connection con = null;
		Object[] values = null;
		ResultSet rs1 = null;
		String M_PLAN_TYPE = null;
		CRUDHandler handler = new CRUDHandler();
		String PROD_MATU_DT = (String) currValue;
		try {
			con = CommonUtils.getConnection();

			String C1 = "SELECT  PLAN_TYPE FROM  PM_IL_PLAN "
					+ "WHERE  PLAN_CODE = ?";
			values = new Object[]{pm_il_product_bean.getPROD_PLAN_CODE()};
			rs1 = handler.executeSelectStatement(C1, con, values);
			while (rs1.next()) {
				M_PLAN_TYPE = rs1.getString(1);
			}

			if (!("E".equalsIgnoreCase(M_PLAN_TYPE))&& !("U".equalsIgnoreCase(M_PLAN_TYPE))
					&& !("O".equalsIgnoreCase(PROD_MATU_DT))) {
				pm_il_product_bean.setPROD_MATU_DT("O");
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91453"));
			}

			
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			CommonUtils.closeCursor(rs1);
		}
	}

	public void PROD_MATU_DT_WHEN_LIST_CHANGED(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		Connection con = null;
		Object[] values = null;
		ResultSet rs1 = null;
		String M_PLAN_TYPE = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			con = CommonUtils.getConnection();

			String C1 = "SELECT  PLAN_TYPE " + "FROM  PM_IL_PLAN "
					+ "WHERE  PLAN_CODE = :PM_IL_PRODUCT.PROD_PLAN_CODE";
			values = new Object[]{pm_il_product_bean.getPROD_PLAN_CODE()};
			rs1 = handler.executeSelectStatement(C1, con, values);
			while (rs1.next()) {
				M_PLAN_TYPE = rs1.getString(1);
			}
			if ("E" != M_PLAN_TYPE 
					&& "O" != pm_il_product_bean.getPROD_MATU_DT()) {
				pm_il_product_bean.setPROD_MATU_DT("O");
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91453"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			CommonUtils.closeCursor(rs1);
		}
	}

	public void PROD_AUTO_UW_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
			if ("P".equalsIgnoreCase(pm_il_product_bean.getPROD_INST_BASIS())) {

				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INST_PERC().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INST_PERC().setRequired(true);

				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INST_RATE_PER().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INST_RATE_PER().setRequired(true);
			} else {

				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INST_PERC().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INST_PERC().setRequired(false);

				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INST_RATE_PER().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INST_RATE_PER().setRequired(false);

				pm_il_product_bean.setPROD_INST_PERC(null);
				pm_il_product_bean.setPROD_INST_RATE_PER(null);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_DESC_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String prod_desc = (String) currValue;
		try {
			if (pm_il_product_bean.getPROD_LONG_DESC() == null) {
				pm_il_product_bean.setPROD_LONG_DESC(prod_desc);
			}
			if (pm_il_product_bean.getPROD_SHORT_DESC() == null) {
				pm_il_product_bean.setPROD_SHORT_DESC(subString(prod_desc, 0,
						30));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	private String subString(String inputString, int startIndex, int endIndex) {
		String selectQuery = "SELECT SUBSTR('" + inputString + "',"
				+ startIndex + "," + endIndex + ") FROM DUAL";
		String retString = null;
		Connection con = null;
		ResultSet rs = null;
		Statement statament = null;

		try {
			con = CommonUtils.getConnection();
			statament = con.createStatement();
			rs = statament.executeQuery(selectQuery);
			if (rs.next()) {
				retString = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return retString;
	}

	public void M_EDIT_PROD_SHORT_DESC_WHEN_BUTTON_PRESSED(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void M_EDIT_PROD_BL_LONG_DESC_WHEN_BUTTON_PRESSED(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_INST_BASIS_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String prod_inst_basis = (String) currValue;
		try {
			if ("P".equalsIgnoreCase(prod_inst_basis)) {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INST_PERC().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INST_PERC().setRequired(true);

				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INST_RATE_PER().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INST_RATE_PER().setRequired(true);
			} else {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INST_PERC().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INST_PERC().setRequired(false);

				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INST_RATE_PER().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INST_RATE_PER().setRequired(false);
				pm_il_product_bean.setPROD_INST_PERC(null);
				pm_il_product_bean.setPROD_INST_RATE_PER(null);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_INST_BASIS_WHEN_LIST_CHANGED(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String prod_inst_basis = (String) currValue;
		try {
			if ("P".equalsIgnoreCase(prod_inst_basis)) {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INST_PERC().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INST_PERC().setRequired(true);

				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INST_RATE_PER().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INST_RATE_PER().setRequired(true);
			} else {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INST_PERC().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INST_PERC().setRequired(false);

				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INST_RATE_PER().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INST_RATE_PER().setRequired(false);
				pm_il_product_bean.setPROD_INST_PERC(null);
				pm_il_product_bean.setPROD_INST_RATE_PER(null);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_INST_PERC_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		double prod_inst_perc = (Double) currValue;
		try {
			if (CommonUtils.nvl(prod_inst_perc, 0) < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71042"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_SURR_CALC_TYPE_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
					throws Exception {
				String prod_surr_calc_type = (String) currValue;
				System.out.println("value of:"+prod_surr_calc_type);
		try {
			if ("ST".equalsIgnoreCase(prod_surr_calc_type)) {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
				.getCOMP_PROD_SURRENDER_FACTOR().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
				.getCOMP_PROD_SURRENDER_FACTOR().setRequired(true);
			} else if ("RW".equalsIgnoreCase(prod_surr_calc_type)) {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
				.getCOMP_PROD_SURRENDER_FACTOR().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
				.getCOMP_PROD_SURRENDER_FACTOR().setRequired(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
				.getCOMP_PROD_WAKFEE_FACTOR().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
				.getCOMP_PROD_WAKFEE_FACTOR().setRequired(true);
			}
			else {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
				.getCOMP_PROD_SURRENDER_FACTOR().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
				.getCOMP_PROD_SURRENDER_FACTOR().setRequired(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
				.getCOMP_PROD_WAKFEE_FACTOR().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
				.getCOMP_PROD_WAKFEE_FACTOR().setRequired(false);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_SURR_CALC_TYPE_WHEN_LIST_CHANGED(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		String prod_surr_calc_type = (String) currValue;
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
			if ("ST".equalsIgnoreCase(prod_surr_calc_type)) {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_SURRENDER_FACTOR().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_SURRENDER_FACTOR().setRequired(true);
			} else if ("RW".equalsIgnoreCase(prod_surr_calc_type)) {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_SURRENDER_FACTOR().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_SURRENDER_FACTOR().setRequired(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_WAKFEE_FACTOR().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_WAKFEE_FACTOR().setRequired(true);
			} else {
				pm_il_product_bean.setPROD_SURRENDER_FACTOR("");
				pm_il_product_bean.setPROD_SURRENDER_FACTOR_DESC("");
				pm_il_product_bean.setPROD_WAKFEE_FACTOR("");
				pm_il_product_bean.setPROD_WAKFEE_FACTOR_DESC("");
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_SURRENDER_FACTOR().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_SURRENDER_FACTOR().setRequired(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_WAKFEE_FACTOR().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_WAKFEE_FACTOR().setRequired(false);
			}

			if (pm_il_product_bean.getROWID() != null) {
				pm_il_product_bean.setPROD_SURRENDER_FACTOR("");
				pm_il_product_bean.setPROD_SURRENDER_FACTOR_DESC("");
				pm_il_product_bean.setPROD_WAKFEE_FACTOR("");
				pm_il_product_bean.setPROD_WAKFEE_FACTOR_DESC("");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_SURRENDER_FACTOR_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String prod_surrender_factor = (String) currValue;
		try {
			if (prod_surrender_factor != null) {
				ArrayList<String> prod_surrender_factor_desc = dbprocedures
						.P_VAL_CODES_PM_CHARGER("IL_VAL_TAR",
								prod_surrender_factor, pm_il_product_bean
										.getPROD_SURRENDER_FACTOR_DESC(), "E",
								"N", null, null, "ENG", null);
				pm_il_product_bean
						.setPROD_SURRENDER_FACTOR_DESC(prod_surrender_factor_desc
								.get(0));
			} else {
				pm_il_product_bean.setPROD_SURRENDER_FACTOR_DESC(null);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_WITHDRAW_YN_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
			if ("Y".equalsIgnoreCase(CommonUtils.nvl(pm_il_product_bean
					.getPROD_WITHDRAW_YN(), "N"))) {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_UI_M_BUT_WITHDRAW_DETAIL().setDisabled(false);
			} else {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_UI_M_BUT_WITHDRAW_DETAIL().setDisabled(true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_WAKFEE_FACTOR_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		Connection con = null;
		ResultSet rs1 = null;
		Object[] c1values = null;
		CRUDHandler handler = new CRUDHandler();
		String M_TEMP = null;
		String C1 = "SELECT 'X' FROM PM_CODES "
				+ "WHERE PC_TYPE ='IL_VAL_TAR' AND PC_CODE =  ?";
		try {
			con = CommonUtils.getConnection();
			if (pm_il_product_bean.getPROD_WAKFEE_FACTOR() != null) {
				ArrayList<String> codedesc = new DBProcedures()
						.P_VAL_CODES_PM_CHARGER(
								"IL_VAL_TAR",
								pm_il_product_bean.getPROD_WAKFEE_FACTOR(),
								pm_il_product_bean.getPROD_WAKFEE_FACTOR_DESC(),
								"E", "N", null, null, "ENG", null);
				pm_il_product_bean.setPROD_WAKFEE_FACTOR_DESC(codedesc.get(0));
				c1values = new Object[]{pm_il_product_bean
						.getPROD_WAKFEE_FACTOR()};
				rs1 = handler.executeSelectStatement(C1, con, c1values);
				while (rs1.next()) {
					M_TEMP = rs1.getString(1);
				}
				if (M_TEMP == null) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "1010"));
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_TOPUP_CHARGE_TYPE_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String prod_topup_charge_type = (String) currValue;
		try {
			if ("Y".equalsIgnoreCase(pm_il_product_bean.getPROD_TOPUP_YN())) {
				if ("S".equalsIgnoreCase(prod_topup_charge_type)) {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_FUND_FEE().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_FUND_FEE().setRequired(true);

					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_FUND_FEE_RATE_PER()
							.setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_FUND_FEE_RATE_PER().setRequired(true);
					/*pm_il_product_bean.setPROD_FUND_FEE(0.0);
					pm_il_product_bean.setPROD_FUND_FEE_RATE_PER(0.0);*/

					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_UI_M_BUT_TOP_UP_DETAIL().setDisabled(true);
				} else if ("L".equalsIgnoreCase(prod_topup_charge_type)
						|| "B".equalsIgnoreCase(prod_topup_charge_type)) {
					pm_il_product_bean.setPROD_FUND_FEE(0.0);
					pm_il_product_bean.setPROD_FUND_FEE_RATE_PER(0.0);

					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_FUND_FEE().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_FUND_FEE().setRequired(false);

					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_FUND_FEE_RATE_PER().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_FUND_FEE_RATE_PER()
							.setRequired(false);

					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_UI_M_BUT_TOP_UP_DETAIL()
							.setDisabled(false);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_TOPUP_CHARGE_TYPE_WHEN_LIST_CHANGED(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String prod_topup_charge_type = (String) currValue;
		try {
			if ("Y".equalsIgnoreCase(pm_il_product_bean.getPROD_TOPUP_YN())) {
				if ("S".equalsIgnoreCase(prod_topup_charge_type)) {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_FUND_FEE().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_FUND_FEE().setRequired(true);

					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_FUND_FEE_RATE_PER()
							.setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_FUND_FEE_RATE_PER().setRequired(true);
					/*pm_il_product_bean.setPROD_FUND_FEE(0.0);
					pm_il_product_bean.setPROD_FUND_FEE_RATE_PER(0.0);*/

					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_UI_M_BUT_TOP_UP_DETAIL().setDisabled(true);
				} else if ("L".equalsIgnoreCase(prod_topup_charge_type)
						|| "B".equalsIgnoreCase(prod_topup_charge_type)) {
					pm_il_product_bean.setPROD_FUND_FEE(0.0);
					pm_il_product_bean.setPROD_FUND_FEE_RATE_PER(0.0);

					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_FUND_FEE().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_FUND_FEE().setRequired(false);

					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_FUND_FEE_RATE_PER().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_FUND_FEE_RATE_PER()
							.setRequired(false);

					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_UI_M_BUT_TOP_UP_DETAIL()
							.setDisabled(false);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_TOPUP_PROD_PERC_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		double prod_topup_prod_perc = (Double) currValue;
		try {
			if (prod_topup_prod_perc > 100) {
				throw new Exception(
						"Top Up Production Percentage should not be greater than 100");
				// STD_MESSAGE_ROUTINE(91014,:CTRL.M_LANG_CODE,'Top Up
				// Production Percentage should not be greater than 100');
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_TOPUP_WAK_CODE_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
			if (pm_il_product_bean.getPROD_TOPUP_WAK_CODE() != null) {
				ArrayList<String> codedesc = new DBProcedures()
						.P_VAL_CODES_PM_CHARGER(
								"IL_MORT_CODE",
								pm_il_product_bean.getPROD_TOPUP_WAK_CODE(),
								pm_il_product_bean.getUI_M_PROD_WAK_CODE_DESC(),
								"N", "N", null, null, null, null);
				pm_il_product_bean.setUI_M_PROD_WAK_CODE_DESC(codedesc.get(0));
			} else {
				pm_il_product_bean.setUI_M_PROD_WAK_CODE_DESC("");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_MAX_AGE_ON_MAT_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		Connection con = null;
		ResultSet rs1 = null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		double M_VALUE = 0;
		int prod_max_age_on_mat = (Integer) currValue;

		try {
			con = CommonUtils.getConnection();
			String C1 = "SELECT PLAN_PERIOD_FROM + PLAN_AGE_TO "
					+ "FROM   PM_IL_PLAN " + "WHERE  PLAN_CODE = ?";
			values = new Object[]{pm_il_product_bean.getPROD_PLAN_CODE()};
			rs1 = handler.executeSelectStatement(C1, con, values);
			while (rs1.next()) {
				M_VALUE = rs1.getDouble(1);
			}

			if (prod_max_age_on_mat <= 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "59005"));
			}

			if (prod_max_age_on_mat > M_VALUE) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91986"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			CommonUtils.closeCursor(rs1);
		}
	}

	public void PROD_TOPUP_COMM_CODE_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		Connection con = null;
		String prod_topup_comm_code = (String) currValue;
		ResultSet rs1 = null;
		Object[] values = null;
		String M_PROD_BCH_CODE_DESC = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			con = CommonUtils.getConnection();
			String C1 = "SELECT BCH_DESC " + "FROM   PM_BROKER_COMM_HDR "
					+ "WHERE  BCH_CODE = ?";
			values = new Object[]{prod_topup_comm_code};
			rs1 = handler.executeSelectStatement(C1, con, values);

			if (prod_topup_comm_code != null) {
				while (rs1.next()) {
					M_PROD_BCH_CODE_DESC = rs1.getString(1);
				}
				if (M_PROD_BCH_CODE_DESC == null
						|| M_PROD_BCH_CODE_DESC.equals("")) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "3206"));
				}
				pm_il_product_bean
						.setPROD_TOPUP_COMM_DESCRIPTION(M_PROD_BCH_CODE_DESC);

			} else {
				pm_il_product_bean.setPROD_TOPUP_COMM_DESCRIPTION("");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_PRODUCTION_PERC_KEY_NEXT_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_TOPUP_YN_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String prod_topup_yn = (String) currValue;
		try {
			if ("Y".equalsIgnoreCase(CommonUtils.nvl(prod_topup_yn, "N"))) {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_MIN_YRS().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_PROD_PERC().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_COMM_CODE().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_FUND_FEE().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_FUND_FEE_RATE_PER().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_CHARGE_TYPE().setDisabled(false);

				pm_il_product_bean.setPROD_TOPUP_MIN_YRS(null);
				pm_il_product_bean.setPROD_TOPUP_PROD_PERC(null);
				pm_il_product_bean.setPROD_TOPUP_COMM_CODE(null);
				pm_il_product_bean.setPROD_FUND_FEE(null);
				pm_il_product_bean.setPROD_FUND_FEE_RATE_PER(null);
				pm_il_product_bean.setPROD_TOPUP_CHARGE_TYPE(null);
				
				//[Added by Akash To enable TOPUP button 
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_TOPUP_PARAM().setDisabled(false);
				//Added by Akash To enable TOPUP button]
				
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_MIN_YRS().setRequired(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_PROD_PERC().setRequired(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_FUND_FEE().setRequired(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_FUND_FEE_RATE_PER().setRequired(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_CHARGE_TYPE().setRequired(true);

				pm_il_product_bean.setPROD_FUND_FEE(null);
				pm_il_product_bean.setPROD_FUND_FEE_RATE_PER(null);
			} else {
				pm_il_product_bean.setPROD_TOPUP_MIN_YRS(null);
				pm_il_product_bean.setPROD_TOPUP_PROD_PERC(null);
				pm_il_product_bean.setPROD_TOPUP_COMM_CODE(null);
				pm_il_product_bean.setPROD_FUND_FEE(null);
				pm_il_product_bean.setPROD_FUND_FEE_RATE_PER(null);
				pm_il_product_bean.setPROD_TOPUP_CHARGE_TYPE(null);
				pm_il_product_bean.setPROD_TOPUP_COMM_DESCRIPTION(null);

				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_MIN_YRS().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_PROD_PERC().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_COMM_CODE().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_FUND_FEE().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_FUND_FEE_RATE_PER().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_CHARGE_TYPE().setDisabled(true);

				//[Added by Akash To enable TOPUP button 
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_M_BUT_TOPUP_PARAM().setDisabled(true);
				//Added by Akash To enable TOPUP button]
				
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_MIN_YRS().setRequired(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_PROD_PERC().setRequired(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_FUND_FEE().setRequired(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_FUND_FEE_RATE_PER().setRequired(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_CHARGE_TYPE().setRequired(false);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_SURR_YRS_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		Connection con = null;
		ResultSet rs1 = null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		int M_PLAN_PERIOD_FROM = 0;
		int prod_surr_yrs = (Integer) currValue;
		try {
			con = CommonUtils.getConnection();

			String C1 = "SELECT PLAN_PERIOD_FROM " + "FROM   PM_IL_PLAN "
					+ "WHERE  PLAN_CODE = ?";
			values = new Object[]{pm_il_product_bean.getPROD_PLAN_CODE()};
			rs1 = handler.executeSelectStatement(C1, con, values);
			while (rs1.next()) {
				M_PLAN_PERIOD_FROM = rs1.getInt(1);
			}
			if (prod_surr_yrs > M_PLAN_PERIOD_FROM) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			CommonUtils.closeCursor(rs1);
		}
	}

	public void PROD_MIN_SA_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		int prod_min_sa = (Integer) currValue;
		try {

			if (prod_min_sa <= 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "59005"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_PRODUCTION_PERC_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		double prod_production_perc = (Double) currValue;
		try {
			if (CommonUtils.nvl(prod_production_perc, 0) < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "60111"));
			}
			if (CommonUtils.nvl(prod_production_perc, 0) > 100) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71017"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PRE_FORM(PILM035_APAC_COMPOSITE_ACTION compositeAction) {

		ResultSet rs1 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
			DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
					.getDUMMY_BEAN();

			if (CommonUtils.getGlobalVariable("CALLING_FORM") != null) {
				CommonUtils.setGlobalVariable("M_PRIVILEGE", "YYY");
				CommonUtils.setGlobalVariable("M_FAILURE", "FALSE");
				CommonUtils.setGlobalVariable("M_USER_ID", "PREMIA");
				CommonUtils.setGlobalVariable("M_NAME",
						"COMPANY NAME..................PROGRAM NAME");
				CommonUtils.setGlobalVariable("M_LANG_CODE", "ENG");
				CommonUtils.setGlobalVariable("M_PARA_1", " ");
				CommonUtils.setGlobalVariable("M_FOR_LANG_CODE", "ARBR1");
				CommonUtils.setGlobalVariable("M_MODULE_NAME", "PILM035_APAC");
			}
			dummy_bean.setPM_IL_PRODUCT_CF("Y");
			dummy_bean.setPM_IL_PROD_APPL_COVER_CF("N");
			dummy_bean.setPM_IL_PROD_APPL_COND_CF("N");
			dummy_bean.setPM_IL_SA_INST_PYMT_CF("N");
			dummy_bean.setPM_IL_SA_INST_PYMT1_CF("N");
			dummy_bean.setPM_IL_PROD_APPL_BONUS_CF("N");
			dummy_bean.setPM_IL_PROD_APPL_LOAD_TARIFF_CF("N");
			dummy_bean.setPM_IL_PROD_PREM_LIMIT_CF("N");

			String C1 = "SELECT PS_VALUE  FROM   PP_SYSTEM "
					+ "WHERE  PS_TYPE = 'IL_CALC_MTHD'";
			rs1 = handler.executeSelectStatement(C1, con);
			while (rs1.next()) {
				dummy_bean.setUI_M_PS_VALUE(rs1.getInt(1));
			}
			
			//COMMENTED BY AKASH TO MAKE NORMAL FLOW FOR SYSTEM.
			
			
			/*if (dummy_bean.getUI_M_PS_VALUE() != 1) {

				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_MORE_INFO_1().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_MORE_INFO_3().setDisabled(true);
			} else {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_MORE_INFO_1().setDisabled(false);
			}*/
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void POST_QUERY(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {

		PM_IL_PRODUCT_ACTION pm_il_product_action_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN();
		PM_IL_PRODUCT pm_il_product_bean = pm_il_product_action_bean
				.getPM_IL_PRODUCT_BEAN();

		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		String M_COVER_SA_CALC = null;

		String M_PLAN_SA_INST_PYMT_YN = null;
		String M_PLAN_TYPE = null;
		String M_PLAN_RED_SA_BASIS = null;
		String B_MATURITY_PARAMETERS = null;
		String B_MONTHS = null;
		ResultSet rs1 = null;
		ResultSet rs7 = null;
		ResultSet rs2 = null;

		CRUDHandler handler = new CRUDHandler();
		Object[] c2values = null;
		Connection con = null;
		try {
			con = CommonUtils.getConnection();

			String C1 = "SELECT  NVL(PLAN_SA_INST_PYMT_YN,'N'),NVL(PLAN_PERIOD_FROM,0), "
					+ "NVL(PLAN_PERIOD_TO,0),NVL(PLAN_MAX_AGE_ON_MAT,0),PLAN_TYPE,PLAN_RED_SA_BASIS FROM "
					+ "PM_IL_PLAN WHERE  PLAN_CODE = ?";

			String C2 = "SELECT BCH_DESC FROM   PM_BROKER_COMM_HDR "
					+ "WHERE  BCH_CODE = ?";

			String C6 = "SELECT TH_DESC FROM   PM_IL_TAR_HDR "
					+ "WHERE  TH_CODE =:PM_IL_PRODUCT.PROD_SA_FACTOR";
			//[addded reminder field by akash  to implement reminder functionality.
			
			
			if("N".equals(pm_il_product_bean.getPROD_REM_YN())){
				pm_il_product_action_bean.getCOMP_REM_INFO_4().setDisabled(true);
				
			}else{
				pm_il_product_action_bean.getCOMP_REM_INFO_4().setDisabled(false);
			}

			//addded reminder field by akash  to implement reminder functionality.]
			
			String PROD_PLAN_CODE_DESC = DBProcedures.P_VAL_PLAN(con,
					pm_il_product_bean.getPROD_PLAN_CODE(), pm_il_product_bean
							.getUI_M_PROD_PLAN_CODE_DESC(), "N", "N");
			/*Commented by saritha on 13-12-2016 for plan code description */
			/*pm_il_product_bean.setUI_M_PROD_PLAN_CODE_DESC(PROD_PLAN_CODE_DESC);*/
			/*End*/
			ArrayList<String> PROD_MORT_CODE_DESC = dbprocedures
					.P_VAL_CODES_PM_CHARGER("IL_MORT_CODE", pm_il_product_bean
							.getPROD_MORT_CODE(), pm_il_product_bean
							.getPROD_MORT_CODE_DESC(), "N", "N", null, null,
							"ENG", null);
			pm_il_product_bean.setPROD_MORT_CODE_DESC(PROD_MORT_CODE_DESC
					.get(0));
			ArrayList<String> UI_M_PROD_WAK_CODE_DESC = dbprocedures
					.P_VAL_CODES_PM_CHARGER("IL_MORT_CODE", pm_il_product_bean
							.getPROD_TOPUP_WAK_CODE(), pm_il_product_bean
							.getUI_M_PROD_WAK_CODE_DESC(), "N", "N", null,
							null, "ENG", null);
			pm_il_product_bean
					.setUI_M_PROD_WAK_CODE_DESC(UI_M_PROD_WAK_CODE_DESC.get(0));

			if ((pm_il_product_bean.getPROD_DS_CODE() != null)) {
				String ds_code_desc = dbprocedures.P_VAL_DS(pm_il_product_bean
						.getPROD_DS_CODE(), "N", "E");
				pm_il_product_bean.setUI_M_PROD_DS_CODE_DESC(ds_code_desc);
			}
			String C7 = "SELECT NVL(COVER_SA_CALC,'X') FROM   PM_IL_COVER "
					+ "WHERE  COVER_CODE =?";
			values = new Object[]{pm_il_product_bean.getPROD_PLAN_CODE()};
			rs7 = handler.executeSelectStatement(C7, con, values);
			while (rs7.next()) {
				M_COVER_SA_CALC = rs7.getString(1);
			}
			if ("D".equalsIgnoreCase(M_COVER_SA_CALC) || "F".equalsIgnoreCase(M_COVER_SA_CALC)
					|| "A".equalsIgnoreCase(M_COVER_SA_CALC)) {

				/*pm_il_product_action_bean.getCOMP_PROD_SA_FACTOR().setDisabled(
						false);
				/*pm_il_product_action_bean.getCOMP_PROD_SA_FACTOR().setRendered(
						true);*/
			} else {
				/*pm_il_product_action_bean.getCOMP_PROD_SA_FACTOR().setDisabled(
						true);
				pm_il_product_action_bean.getCOMP_PROD_SA_FACTOR().setRendered(
						false);*/
			}

			values = new Object[]{pm_il_product_bean.getPROD_PLAN_CODE()};
			rs1 = handler.executeSelectStatement(C1, con, values);
			while (rs1.next()) {
				M_PLAN_SA_INST_PYMT_YN = rs1.getString(1);
				dummy_bean.setUI_M_PLAN_PERIOD_FROM(rs1.getInt(2));
				dummy_bean.setUI_M_PLAN_PERIOD_TO(rs1.getInt(3));
				dummy_bean.setUI_M_PLAN_MAX_AGE_ON_MAT(rs1.getInt(4));
				M_PLAN_TYPE = rs1.getString(5);
				M_PLAN_RED_SA_BASIS = rs1.getString(6);
			}

			if ("M".equalsIgnoreCase(M_PLAN_TYPE)
					|| "N".equalsIgnoreCase(M_PLAN_TYPE)
					|| "R".equalsIgnoreCase(M_PLAN_RED_SA_BASIS)) {
				pm_il_product_action_bean.getCOMP_PROD_ENDT_VAL_DAYS()
						.setDisabled(false);
				pm_il_product_action_bean.getCOMP_PROD_ENDT_VAL_DAYS()
						.setRendered(true);
				pm_il_product_action_bean.getCOMP_PROD_ENDT_VAL_DAYS()
						.setRequired(true);

				pm_il_product_action_bean.getCOMP_PROD_COOLOFF_DAYS()
						.setDisabled(false);
				pm_il_product_action_bean.getCOMP_PROD_COOLOFF_DAYS()
						.setRendered(true);
				pm_il_product_action_bean.getCOMP_PROD_COOLOFF_DAYS()
						.setRequired(true);

				pm_il_product_action_bean.getCOMP_PROD_EMI_TOLERANCE()
						.setDisabled(false);
				pm_il_product_action_bean.getCOMP_PROD_EMI_TOLERANCE()
						.setRendered(true);
				pm_il_product_action_bean.getCOMP_PROD_EMI_TOLERANCE()
						.setRequired(true);

				pm_il_product_action_bean.getCOMP_PROD_AGE_SET_BACK()
						.setDisabled(false);
				pm_il_product_action_bean.getCOMP_PROD_AGE_SET_BACK()
						.setRendered(true);
				pm_il_product_action_bean.getCOMP_PROD_AGE_SET_BACK()
						.setRequired(true);

				pm_il_product_action_bean.getCOMP_PROD_CBC_YN().setDisabled(
						false);
				pm_il_product_action_bean.getCOMP_PROD_CBC_YN().setRendered(
						true);

			} else {

				pm_il_product_action_bean.getCOMP_PROD_ENDT_VAL_DAYS()
						.setDisabled(true);
				pm_il_product_action_bean.getCOMP_PROD_COOLOFF_DAYS()
						.setDisabled(true);
				pm_il_product_action_bean.getCOMP_PROD_AGE_SET_BACK()
						.setDisabled(true);

				pm_il_product_action_bean.getCOMP_PROD_EMI_TOLERANCE()
						.setDisabled(true);
				pm_il_product_action_bean.getCOMP_PROD_EMI_TOLERANCE()
						.setRequired(false);
				pm_il_product_action_bean.getCOMP_PROD_CBC_YN().setDisabled(
						false);
			}

			if ("R".equalsIgnoreCase(M_PLAN_RED_SA_BASIS)||("M".equalsIgnoreCase(M_PLAN_TYPE))) {

				pm_il_product_action_bean.getCOMP_PROD_MAX_DEFER_MONTHS()
						.setDisabled(false);
				pm_il_product_action_bean.getCOMP_PROD_MAX_DEFER_MONTHS()
						.setRendered(true);
				pm_il_product_action_bean.getCOMP_PROD_MAX_DEFER_MONTHS()
						.setRequired(true);

				pm_il_product_action_bean.getCOMP_PROD_DEF_PERIOD_FLAG()
						.setDisabled(false);
				pm_il_product_action_bean.getCOMP_PROD_DEF_PERIOD_FLAG()
						.setRendered(true);
				pm_il_product_action_bean.getCOMP_PROD_DEF_PERIOD_FLAG()
						.setRequired(true);

				pm_il_product_action_bean.getCOMP_PROD_RSA_CALC_TYP()
						.setDisabled(false);
				pm_il_product_action_bean.getCOMP_PROD_RSA_CALC_TYP()
						.setRendered(true);
				pm_il_product_action_bean.getCOMP_PROD_RSA_CALC_TYP()
						.setRequired(true);

				pm_il_product_action_bean.getCOMP_PROD_CONT_LOAD_RATE()
						.setDisabled(false);
				pm_il_product_action_bean.getCOMP_PROD_CONT_LOAD_RATE()
						.setRendered(true);
				pm_il_product_action_bean.getCOMP_PROD_CONT_LOAD_RATE()
						.setRequired(true);

				pm_il_product_action_bean.getCOMP_PROD_CONT_LOAD_RATE_PER()
						.setDisabled(false);
				pm_il_product_action_bean.getCOMP_PROD_CONT_LOAD_RATE_PER()
						.setRendered(true);
				pm_il_product_action_bean.getCOMP_PROD_CONT_LOAD_RATE_PER()
						.setRequired(true);

				pm_il_product_action_bean.getCOMP_PROD_EXP_LOAD_RATE()
						.setDisabled(false);
				pm_il_product_action_bean.getCOMP_PROD_EXP_LOAD_RATE()
						.setRendered(true);
				pm_il_product_action_bean.getCOMP_PROD_EXP_LOAD_RATE()
						.setRequired(true);

				pm_il_product_action_bean.getCOMP_PROD_EXP_LOAD_RATE_PER()
						.setDisabled(false);
				pm_il_product_action_bean.getCOMP_PROD_EXP_LOAD_RATE_PER()
						.setRendered(true);
				pm_il_product_action_bean.getCOMP_PROD_EXP_LOAD_RATE_PER()
						.setRequired(true);

			}

			if ("R".equalsIgnoreCase(M_PLAN_RED_SA_BASIS)
					&& "X".equalsIgnoreCase(pm_il_product_bean
							.getPROD_PREM_CALC_MTHD())) {

				pm_il_product_action_bean.getCOMP_PROD_CONT_LOAD_RATE()
						.setRequired(true);
				pm_il_product_action_bean.getCOMP_PROD_EXP_LOAD_RATE_PER()
						.setRequired(true);
				pm_il_product_action_bean.getCOMP_PROD_EXP_LOAD_RATE()
						.setRequired(true);

				pm_il_product_action_bean.getCOMP_PROD_EXP_LOAD_RATE_PER()
						.setRequired(true);
				pm_il_product_action_bean.getCOMP_PROD_MRTA_RATE_CALC_YN()
						.setDisabled(true);
				pm_il_product_action_bean.getCOMP_PROD_MRTA_RATE_CALC_YN()
						.setRendered(false);
				pm_il_product_action_bean.getCOMP_PROD_MRTA_RATE_CALC_YN()
						.setRequired(false);
			} else {
				if ("R".equalsIgnoreCase(M_PLAN_RED_SA_BASIS)
						&& "T".equalsIgnoreCase(pm_il_product_bean
								.getPROD_PREM_CALC_MTHD())) {

					pm_il_product_action_bean.getCOMP_PROD_CONT_LOAD_RATE()
							.setRequired(false);
					pm_il_product_action_bean.getCOMP_PROD_CONT_LOAD_RATE_PER()
							.setRequired(false);
					pm_il_product_action_bean.getCOMP_PROD_EXP_LOAD_RATE()
							.setRequired(false);
					pm_il_product_action_bean.getCOMP_PROD_EXP_LOAD_RATE_PER()
							.setRequired(false);
					pm_il_product_action_bean.getCOMP_PROD_EXP_LOAD_RATE_PER()
							.setDisabled(false);
					pm_il_product_action_bean.getCOMP_PROD_EXP_LOAD_RATE_PER()
							.setRendered(true);
					pm_il_product_action_bean.getCOMP_PROD_MRTA_RATE_CALC_YN()
							.setRequired(true);
				} else {
					pm_il_product_action_bean.getCOMP_PROD_MAX_DEFER_MONTHS()
							.setDisabled(true);
					pm_il_product_action_bean.getCOMP_PROD_MAX_DEFER_MONTHS()
							.setRequired(false);

					pm_il_product_action_bean.getCOMP_PROD_DEF_PERIOD_FLAG()
							.setDisabled(true);
					pm_il_product_action_bean.getCOMP_PROD_DEF_PERIOD_FLAG()
							.setRequired(false);

					pm_il_product_action_bean.getCOMP_PROD_RSA_CALC_TYP()
							.setDisabled(true);
					pm_il_product_action_bean.getCOMP_PROD_RSA_CALC_TYP()
							.setRequired(false);

					pm_il_product_action_bean.getCOMP_PROD_CONT_LOAD_RATE()
							.setDisabled(true);
					pm_il_product_action_bean.getCOMP_PROD_CONT_LOAD_RATE()
							.setRequired(false);

					pm_il_product_action_bean.getCOMP_PROD_CONT_LOAD_RATE_PER()
							.setDisabled(true);
					pm_il_product_action_bean.getCOMP_PROD_CONT_LOAD_RATE_PER()
							.setRequired(false);

					pm_il_product_action_bean.getCOMP_PROD_EXP_LOAD_RATE()
							.setDisabled(true);
					pm_il_product_action_bean.getCOMP_PROD_EXP_LOAD_RATE()
							.setRequired(false);

					pm_il_product_action_bean.getCOMP_PROD_EXP_LOAD_RATE_PER()
							.setDisabled(true);
					pm_il_product_action_bean.getCOMP_PROD_EXP_LOAD_RATE_PER()
							.setRequired(false);

					pm_il_product_action_bean.getCOMP_PROD_EXP_LOAD_RATE_PER()
							.setDisabled(true);
					compositeAction
							.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
							.getCOMP_PALT_LOAD_APPL_PERC().setDisabled(true);
				}
			}
			
			//COMMENTED BY AKASH TO MAKE NORMAL FLOW FOR SYSTEM.

			/*if (dummy_bean.getUI_M_PS_VALUE() != 1) {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_MORE_INFO_1().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_MORE_INFO_3().setDisabled(false);
			} else {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_MORE_INFO_1().setDisabled(false);
			}*/

			if ("Y".equalsIgnoreCase(CommonUtils.nvl(pm_il_product_bean
					.getPROD_WITHDRAW_YN(), "N"))) {
				pm_il_product_action_bean.getCOMP_UI_M_BUT_WITHDRAW_DETAIL()
						.setDisabled(false);
			} else {
				pm_il_product_action_bean.getCOMP_UI_M_BUT_WITHDRAW_DETAIL()
						.setDisabled(true);
			}
			if ("Y".equalsIgnoreCase(CommonUtils.nvl(pm_il_product_bean
					.getPROD_TOPUP_YN(), "N"))) {
				pm_il_product_action_bean.getCOMP_PROD_TOPUP_MIN_YRS()
						.setDisabled(false);
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_M_BUT_TOPUP_PARAM().setDisabled(false);
				pm_il_product_action_bean.getCOMP_PROD_TOPUP_PROD_PERC()
						.setDisabled(false);
				pm_il_product_action_bean.getCOMP_PROD_FUND_FEE().setDisabled(
						false);
				pm_il_product_action_bean.getCOMP_PROD_FUND_FEE_RATE_PER()
						.setDisabled(false);
				pm_il_product_action_bean.getCOMP_PROD_TOPUP_CHARGE_TYPE()
						.setDisabled(false);

				if ("S".equalsIgnoreCase(pm_il_product_bean
						.getPROD_TOPUP_CHARGE_TYPE())) {
					pm_il_product_action_bean.getCOMP_UI_M_BUT_TOP_UP_DETAIL()
							.setDisabled(true);
				} else if ("L".equalsIgnoreCase(pm_il_product_bean
						.getPROD_TOPUP_CHARGE_TYPE())
						|| "B".equalsIgnoreCase(pm_il_product_bean
								.getPROD_TOPUP_CHARGE_TYPE())) {
					pm_il_product_action_bean.getCOMP_UI_M_BUT_TOP_UP_DETAIL()
							.setDisabled(false);
				}

				pm_il_product_action_bean.getCOMP_PROD_TOPUP_MIN_YRS()
						.setRendered(true);
				pm_il_product_action_bean.getCOMP_PROD_TOPUP_PROD_PERC()
						.setRendered(true);
				pm_il_product_action_bean.getCOMP_PROD_FUND_FEE().setRendered(
						true);
				pm_il_product_action_bean.getCOMP_PROD_FUND_FEE_RATE_PER()
						.setRendered(true);
				pm_il_product_action_bean.getCOMP_PROD_TOPUP_CHARGE_TYPE()
						.setRendered(true);

				pm_il_product_action_bean.getCOMP_PROD_TOPUP_MIN_YRS()
						.setRequired(true);
				pm_il_product_action_bean.getCOMP_PROD_TOPUP_PROD_PERC()
						.setRequired(true);
				pm_il_product_action_bean.getCOMP_PROD_FUND_FEE().setRequired(
						true);
				pm_il_product_action_bean.getCOMP_PROD_FUND_FEE_RATE_PER()
						.setRequired(true);
				pm_il_product_action_bean.getCOMP_PROD_TOPUP_CHARGE_TYPE()
						.setRequired(true);
			} else {
				pm_il_product_action_bean.getCOMP_PROD_TOPUP_MIN_YRS()
						.setDisabled(true);
				pm_il_product_action_bean.getCOMP_PROD_TOPUP_PROD_PERC()
						.setDisabled(true);
				pm_il_product_action_bean.getCOMP_PROD_FUND_FEE().setDisabled(
						true);
				pm_il_product_action_bean.getCOMP_PROD_FUND_FEE_RATE_PER()
						.setDisabled(true);
				pm_il_product_action_bean.getCOMP_PROD_TOPUP_CHARGE_TYPE()
						.setDisabled(true);
				pm_il_product_action_bean.getCOMP_UI_M_BUT_TOP_UP_DETAIL()
						.setDisabled(true);
				pm_il_product_action_bean.getCOMP_PROD_TOPUP_MIN_YRS()
						.setRequired(true);
				pm_il_product_action_bean.getCOMP_PROD_TOPUP_PROD_PERC()
						.setRequired(true);
				pm_il_product_action_bean.getCOMP_PROD_FUND_FEE().setRequired(
						true);
				pm_il_product_action_bean.getCOMP_PROD_FUND_FEE_RATE_PER()
						.setRequired(true);
				pm_il_product_action_bean.getCOMP_PROD_TOPUP_CHARGE_TYPE()
						.setRequired(true);
			}

			if (M_PLAN_RED_SA_BASIS != "R") {
				pm_il_product_action_bean.getCOMP_PROD_ENDT_VAL_DAYS()
						.setDisabled(false);
				pm_il_product_action_bean.getCOMP_PROD_ENDT_VAL_DAYS()
						.setRendered(true);
				pm_il_product_action_bean.getCOMP_PROD_COOLOFF_DAYS()
						.setDisabled(false);
				pm_il_product_action_bean.getCOMP_PROD_COOLOFF_DAYS()
						.setRendered(true);
				pm_il_product_action_bean.getCOMP_PROD_EMI_TOLERANCE()
						.setDisabled(false);
				pm_il_product_action_bean.getCOMP_PROD_EMI_TOLERANCE()
						.setRendered(true);
				pm_il_product_action_bean.getCOMP_PROD_AGE_SET_BACK()
						.setDisabled(false);
				pm_il_product_action_bean.getCOMP_PROD_AGE_SET_BACK()
						.setRendered(true);

				pm_il_product_action_bean.getCOMP_PROD_CBC_YN().setDisabled(
						false);
				pm_il_product_action_bean.getCOMP_PROD_CBC_YN().setRendered(
						true);

			}
			if (M_PLAN_TYPE != "M" || M_PLAN_RED_SA_BASIS != "R") {
				/*compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_MORE_INFO_3().setDisabled(false);*/
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_MORE_INFO_2().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_REM_INFO_5().setDisabled(false);
				pm_il_product_action_bean.getCOMP_PROD_WITHDRAW_YN()
						.setDisabled(false);
				pm_il_product_action_bean.getCOMP_PROD_WITHDRAW_YN()
						.setRendered(true);
			} else {
				/*compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_MORE_INFO_3().setDisabled(false);*/
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_REM_INFO_5().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_MORE_INFO_2().setDisabled(false);
			}
			if ("M".equalsIgnoreCase(M_PLAN_TYPE)
					|| "R".equalsIgnoreCase(M_PLAN_RED_SA_BASIS)) {
				pm_il_product_action_bean.getCOMP_PROD_PREM_CALC_MTHD()
						.setDisabled(false);
				pm_il_product_action_bean.getCOMP_PROD_PREM_CALC_MTHD()
						.setRendered(true);

				pm_il_product_action_bean.getCOMP_PROD_INST_BASIS()
						.setDisabled(false);
			/*pm_il_product_action_bean.getCOMP_PROD_INST_BASIS()
						.setRendered(true);*/
			} else {
				pm_il_product_action_bean.getCOMP_PROD_PREM_CALC_MTHD()
						.setDisabled(true);
			/*pm_il_product_action_bean.getCOMP_PROD_PREM_CALC_MTHD()
						.setRendered(false);*/
				pm_il_product_action_bean.getCOMP_PROD_INST_BASIS()
						.setDisabled(true);
				pm_il_product_action_bean.getCOMP_PROD_INST_BASIS()
						.setRendered(false);
				pm_il_product_action_bean.getCOMP_PROD_INST_PERC().setDisabled(
						true);

			}

			if ("R".equalsIgnoreCase(M_PLAN_RED_SA_BASIS)
					&& "N".equalsIgnoreCase(pm_il_product_bean
							.getPROD_INST_BASIS())) {
				pm_il_product_action_bean.getCOMP_PROD_INST_PERC().setDisabled(
						true);

				pm_il_product_action_bean.getCOMP_PROD_INST_PERC().setRequired(
						false);

				pm_il_product_action_bean.getCOMP_PROD_INST_RATE_PER()
						.setDisabled(true);
				
				pm_il_product_action_bean.getCOMP_PROD_INST_RATE_PER()
						.setRequired(false);
			} else if ("R".equalsIgnoreCase(M_PLAN_RED_SA_BASIS)
					&& "P".equalsIgnoreCase(pm_il_product_bean
							.getPROD_INST_BASIS())) {

				pm_il_product_action_bean.getCOMP_PROD_INST_PERC().setDisabled(
						false);

				pm_il_product_action_bean.getCOMP_PROD_INST_PERC().setRequired(
						true);
				pm_il_product_action_bean.getCOMP_PROD_INST_RATE_PER()
						.setDisabled(false);
				
				pm_il_product_action_bean.getCOMP_PROD_INST_RATE_PER()
						.setRequired(true);
			} else {

				pm_il_product_action_bean.getCOMP_PROD_INST_PERC().setDisabled(
						true);

				pm_il_product_action_bean.getCOMP_PROD_INST_PERC().setRequired(
						false);

				pm_il_product_action_bean.getCOMP_PROD_INST_RATE_PER()
						.setDisabled(true);
				
				pm_il_product_action_bean.getCOMP_PROD_INST_RATE_PER()
						.setRequired(false);
			}
			if ("U".equalsIgnoreCase(M_PLAN_TYPE)) {
				/*
				 * compositeAction.getTabbedBar().setTabEnabled(
				 * compositeAction.TAB_PM_IL_PROD_APPL_FUND);
				 */
				compositeAction.getWizard().enableWizardItem(
						"PILM035_APAC_PM_IL_PROD_APPL_FUND");
			} else {
				/*
				 * compositeAction.getTabbedBar().setTabDisabled(
				 * compositeAction.TAB_PM_IL_PROD_APPL_FUND);
				 */
				compositeAction.getWizard().disableWizardItem(
						"PILM035_APAC_PM_IL_PROD_APPL_FUND");
			}

			if (pm_il_product_bean.getPROD_PREM_TARIFF() != null) {

				ArrayList<String> prem_tariff_desc = dbprocedures
						.P_VAL_CODES_PM_CHARGER("IL_VAL_TAR",
								pm_il_product_bean.getPROD_PREM_TARIFF(),
								pm_il_product_bean.getPROD_PREM_TARIFF_DESC(),
								"N", "N", null, null, "ENG", null);
				pm_il_product_bean.setPROD_PREM_TARIFF_DESC(prem_tariff_desc
						.get(0));
			}

			if (pm_il_product_bean.getPROD_SA_TARIFF() != null) {

				ArrayList<String> PROD_SA_TARIFF_DESC = dbprocedures
						.P_VAL_CODES_PM_CHARGER("IL_VAL_TAR",
								pm_il_product_bean.getPROD_SA_TARIFF(),
								pm_il_product_bean.getPROD_SA_TARIFF_DESC(),
								"N", "N", null, null, "ENG", null);
				pm_il_product_bean.setPROD_SA_TARIFF_DESC(PROD_SA_TARIFF_DESC
						.get(0));
			}

			if (pm_il_product_bean.getPROD_SA_FACTOR() != null) {
				ArrayList<String> PROD_SA_FACTOR_DESC = dbprocedures
						.P_VAL_CODES_PM_CHARGER("IL_VAL_TAR",
								pm_il_product_bean.getPROD_SA_FACTOR(),
								pm_il_product_bean.getPROD_SA_FACTOR_DESC(),
								"N", "N", null, null, "ENG", null);
				pm_il_product_bean.setPROD_SA_FACTOR_DESC(PROD_SA_FACTOR_DESC
						.get(0));
			}
			if (pm_il_product_bean.getPROD_PREM_HOLIDAY_CODE() != null) {
				ArrayList<String> PROD_PREM_HOLIDAY_CODE_DESC = dbprocedures
						.P_VAL_CODES_PM_CHARGER("IL_VAL_TAR",
								pm_il_product_bean.getPROD_PREM_HOLIDAY_CODE(),
								pm_il_product_bean
										.getPROD_PREM_HOLIDAY_CODE_DESC(), "N",
								"N", null, null, "ENG", null);
				pm_il_product_bean
						.setPROD_PREM_HOLIDAY_CODE_DESC(PROD_PREM_HOLIDAY_CODE_DESC
								.get(0));
			}
			if (("R"
					.equalsIgnoreCase(pm_il_product_bean.getPROD_ROUND_OPTION()))
					|| ("I".equalsIgnoreCase(pm_il_product_bean
							.getPROD_ROUND_OPTION()) || ("U"
							.equalsIgnoreCase(pm_il_product_bean
									.getPROD_ROUND_OPTION()) || ("D"
							.equalsIgnoreCase(pm_il_product_bean
									.getPROD_ROUND_OPTION()))))) {

				pm_il_product_action_bean.getCOMP_PROD_ROUND_VALUE()
						.setDisabled(false);
			} else {
				pm_il_product_action_bean.getCOMP_PROD_ROUND_VALUE()
						.setDisabled(true);
			}

			if (("R"
					.equalsIgnoreCase(pm_il_product_bean.getPROD_ROUND_OPTION()))
					|| ("I".equalsIgnoreCase(pm_il_product_bean
							.getPROD_ROUND_OPTION()) || ("U"
							.equalsIgnoreCase(pm_il_product_bean
									.getPROD_ROUND_OPTION()) || ("D"
							.equalsIgnoreCase(pm_il_product_bean
									.getPROD_ROUND_OPTION()))))) {
				pm_il_product_action_bean.getCOMP_PROD_ROUND_VALUE()
						.setRequired(true);
			} else {
				pm_il_product_action_bean.getCOMP_PROD_ROUND_VALUE()
						.setRequired(false);
			}
			if ("C".equalsIgnoreCase(pm_il_product_bean
					.getPROD_SA_INST_PYMT_TYPE())) {
				B_MATURITY_PARAMETERS = "Maturity Parameters";

				pm_il_product_action_bean.getCOMP_PROD_MAT_AMT_TYPE()
						.setDisabled(false);
				pm_il_product_action_bean.getCOMP_PROD_MAT_AMT_TYPE()
						.setRendered(true);

				pm_il_product_action_bean.getCOMP_PROD_MAT_RATE().setDisabled(
						false);
				pm_il_product_action_bean.getCOMP_PROD_MAT_RATE().setRendered(
						true);

				pm_il_product_action_bean.getCOMP_PROD_MAT_RATE_PER()
						.setDisabled(false);
				pm_il_product_action_bean.getCOMP_PROD_MAT_RATE_PER()
						.setRendered(true);

			} else if ("B".equalsIgnoreCase(pm_il_product_bean
					.getPROD_SA_INST_PYMT_TYPE())) {
				B_MATURITY_PARAMETERS = "Maturity Parameters";

				pm_il_product_action_bean.getCOMP_PROD_MAT_AMT_TYPE()
						.setDisabled(false);
				pm_il_product_action_bean.getCOMP_PROD_MAT_AMT_TYPE()
						.setRendered(true);

			} else {
				B_MATURITY_PARAMETERS = "";

				pm_il_product_action_bean.getCOMP_PROD_MAT_AMT_TYPE()
						.setDisabled(true);
				pm_il_product_action_bean.getCOMP_PROD_MAT_RATE().setDisabled(
						true);
				pm_il_product_action_bean.getCOMP_PROD_MAT_RATE_PER()
						.setDisabled(true);
			}

			if ((pm_il_product_bean.getPROD_SA_INST_PYMT_TYPE() != "C")
					|| (pm_il_product_bean.getPROD_SA_INST_PYMT_TYPE() != "B")) {
				P_DISB_TXT(pm_il_product_action_bean);

			} else if ("".equalsIgnoreCase(pm_il_product_bean
					.getPROD_SA_INST_PYMT_TYPE())
					|| "B".equalsIgnoreCase(pm_il_product_bean
							.getPROD_SA_INST_PYMT_TYPE())) {
				P_ENAB_TXT(pm_il_product_action_bean);
			}

			// OPEN C2(:PM_IL_PRODUCT.PROD_TOPUP_COMM_CODE);
			c2values = new Object[]{pm_il_product_bean
					.getPROD_TOPUP_COMM_CODE()};
			rs2 = handler.executeSelectStatement(C2, con, c2values);
			while (rs2.next()) {
				pm_il_product_bean.setPROD_TOPUP_COMM_DESCRIPTION(rs2
						.getString(1));
			}
			if ("F"
					.equalsIgnoreCase(pm_il_product_bean
							.getPROD_COMM_RND_TYPE())) {
				pm_il_product_action_bean.getCOMP_PROD_COMM_RND_DEC()
						.setDisabled(true);
			} else {
				pm_il_product_action_bean.getCOMP_PROD_COMM_RND_DEC()
						.setDisabled(false);
				pm_il_product_action_bean.getCOMP_PROD_COMM_RND_DEC()
						.setRendered(true);
			}
			if ("PAPN".equalsIgnoreCase(pm_il_product_bean
					.getPROD_MAT_AMT_TYPE())
					|| "N".equalsIgnoreCase(pm_il_product_bean
							.getPROD_MAT_AMT_TYPE())) {
				pm_il_product_action_bean.getCOMP_PROD_SURR_PLUS_FACTOR()
						.setDisabled(false);
				pm_il_product_action_bean.getCOMP_PROD_SURR_PLUS_FACTOR()
						.setRendered(true);
			} else {
				pm_il_product_action_bean.getCOMP_PROD_SURR_PLUS_FACTOR()
						.setDisabled(true);
			}
			if (pm_il_product_bean.getPROD_SURR_PLUS_FACTOR() != null) {
				ArrayList<String> PROD_SURR_PLUS_FACTOR_DESC = dbprocedures
						.P_VAL_CODES_PM_CHARGER("IL_VAL_TAR",
								pm_il_product_bean.getPROD_SURR_PLUS_FACTOR(),
								pm_il_product_bean
										.getPROD_SURR_PLUS_FACTOR_DESC(), "N",
								"N", null, null, "ENG", null);
				pm_il_product_bean
						.setPROD_SURR_PLUS_FACTOR_DESC(PROD_SURR_PLUS_FACTOR_DESC
								.get(0));
			} else {
				pm_il_product_bean.setPROD_SURR_PLUS_FACTOR_DESC(null);
			}
			if (pm_il_product_bean.getPROD_SURRENDER_FACTOR() != null) {
				ArrayList<String> PROD_SURRENDER_FACTOR_DESC = dbprocedures
						.P_VAL_CODES_PM_CHARGER("IL_VAL_TAR",
								pm_il_product_bean.getPROD_SURRENDER_FACTOR(),
								pm_il_product_bean
										.getPROD_SURRENDER_FACTOR_DESC(), "N",
								"N", null, null, "ENG", null);
				pm_il_product_bean
						.setPROD_SURRENDER_FACTOR_DESC(PROD_SURRENDER_FACTOR_DESC
								.get(0));

			} else {
				pm_il_product_bean.setPROD_SURRENDER_FACTOR_DESC("");
			}
			if (pm_il_product_bean.getPROD_WAKFEE_FACTOR() != null) {
				ArrayList<String> PROD_WAKFEE_FACTOR_DESC = dbprocedures
						.P_VAL_CODES_PM_CHARGER(
								"IL_VAL_TAR",
								pm_il_product_bean.getPROD_WAKFEE_FACTOR(),
								pm_il_product_bean.getPROD_WAKFEE_FACTOR_DESC(),
								"E", "N", null, null, "ENG", null);
				pm_il_product_bean
						.setPROD_WAKFEE_FACTOR_DESC(PROD_WAKFEE_FACTOR_DESC
								.get(0));

			} else {
				pm_il_product_bean.setPROD_SURRENDER_FACTOR_DESC("");
			}
			if ("Y".equalsIgnoreCase(pm_il_product_bean
					.getPROD_DEF_PERIOD_FLAG())) {
				B_MONTHS = "Years";
			} else {
				B_MONTHS = "Months";
			}
			if ("Y".equalsIgnoreCase(pm_il_product_bean
					.getPROD_SA_BY_PLAN_BASIS_YN())) {
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_APPL_SUB_PLANS()
						.setDisabled(false);
			} else if ("N".equalsIgnoreCase(pm_il_product_bean
					.getPROD_SA_BY_PLAN_BASIS_YN())) {
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_APPL_SUB_PLANS()
						.setDisabled(true);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs7);
				CommonUtils.closeCursor(rs2);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	public void check_conortakaful(PM_IL_PRODUCT_ACTION pm_il_product_action_bean)throws Exception{
		Connection con=null;
		ResultSet rs=null;
		CRUDHandler handler=null;
		int val=0;
		try{
			con=CommonUtils.getConnection();
			handler=new CRUDHandler();
			String c1="SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE='IL_CALC_MTHD'";
			rs= handler.executeSelectStatement(c1, con);
			if(rs.next()){
				val=rs.getInt(1);
			}
			if(val==1){
				pm_il_product_action_bean.getCOMP_PROD_MAT_AMT_TYPE().setDisabled(
						false);
		}else if(val==2){
			pm_il_product_action_bean.getCOMP_PROD_WAKFEE_FACTOR_LABEL().setRendered(false);
			pm_il_product_action_bean.getCOMP_PROD_WAKFEE_FACTOR().setRendered(false);
			pm_il_product_action_bean.getCOMP_PROD_WAKFEE_FACTOR_DESC().setRendered(false);
			pm_il_product_action_bean.getCOMP_PROD_WAKFEE_FACTOR_IMAGE().setRendered(false);
			pm_il_product_action_bean.getCOMP_PROD_TOPUP_WAK_CODE_LABEL().setRendered(false);
			pm_il_product_action_bean.getCOMP_PROD_TOPUP_WAK_CODE().setRendered(false);
			pm_il_product_action_bean.getCOMP_UI_M_PROD_WAK_CODE_DESC().setRendered(false);
			pm_il_product_action_bean.getCOMP_UI_M_PROD_WAK_CODE_IMAGE().setRendered(false);
			pm_il_product_action_bean.getCOMP_PROD_WAQAF_PERIOD_FM_LABEL().setRendered(false);
			pm_il_product_action_bean.getCOMP_PROD_WAQAF_PERIOD_FM().setRendered(false);
			pm_il_product_action_bean.getCOMP_PROD_WAQAF_PERIOD_TO_LABEL().setRendered(false);
			pm_il_product_action_bean.getCOMP_PROD_WAQAF_PERIOD_TO().setRendered(false);
			pm_il_product_action_bean.getCOMP_PROD_SURR_PLUS_FACTOR_LABEL().setRendered(false);
			pm_il_product_action_bean.getCOMP_PROD_SURR_PLUS_FACTOR().setRendered(false);
			pm_il_product_action_bean.getCOMP_PROD_SURR_PLUS_FACTOR_DESC().setRendered(false);
			pm_il_product_action_bean.getCOMP_PROD_SURR_PLUS_FACTOR_IMAGE().setRendered(false);
			pm_il_product_action_bean.getCOMP_PROD_PREM_HOLIDAY_CODE().setRendered(false);
			pm_il_product_action_bean.getCOMP_UI_M_PROD_PREM_HOLIDAY_CODE_DESC().setRendered(false);
			pm_il_product_action_bean.getCOMP_PROD_PREM_HOLIDAY_CODE_LABEL().setRendered(false);
		}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			CommonUtils.closeCursor(rs);
		}
	}

	private void P_DISB_TXT(PM_IL_PRODUCT_ACTION pm_il_product_action_bean)
			throws Exception {
		
		try {
			
			pm_il_product_action_bean.getCOMP_PROD_MAT_AMT_TYPE().setDisabled(
					true);
			
			pm_il_product_action_bean.getCOMP_PROD_MAT_RATE().setDisabled(true);
			pm_il_product_action_bean.getCOMP_PROD_MAT_RATE_PER().setDisabled(
					true);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	

	private void P_ENAB_TXT(PM_IL_PRODUCT_ACTION pm_il_product_action_bean)
			throws Exception {

		try {
			pm_il_product_action_bean.getCOMP_PROD_MAT_AMT_TYPE().setDisabled(
					false);
			if ("B".equalsIgnoreCase(pm_il_product_action_bean
					.getPM_IL_PRODUCT_BEAN().getPROD_SA_INST_PYMT_TYPE())) {
				pm_il_product_action_bean.getCOMP_PROD_MAT_RATE().setDisabled(
						false);
				pm_il_product_action_bean.getCOMP_PROD_MAT_RATE_PER()
						.setDisabled(false);
			}
			pm_il_product_action_bean.getCOMP_PROD_MAT_AMT_TYPE().setDisabled(
					false);
			if ("B".equalsIgnoreCase(pm_il_product_action_bean
					.getPM_IL_PRODUCT_BEAN().getPROD_SA_INST_PYMT_TYPE())) {
				pm_il_product_action_bean.getCOMP_PROD_MAT_RATE().setDisabled(
						false);
				pm_il_product_action_bean.getCOMP_PROD_MAT_RATE_PER()
						.setDisabled(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void POST_UPDATE(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		Double M_DURATION = 0.0;
		String M_FLAG = null;
		Connection con = null;
		PM_IL_PRODUCT pm_il_product_bean = null;
		Integer M_DUMMY = 0;
		String M_PROD_SA_INST_PYMT_TYPE = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values = null;
		try {
			con = CommonUtils.getConnection();
			pm_il_product_bean = compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
					.getPM_IL_PRODUCT_BEAN();
			M_PROD_SA_INST_PYMT_TYPE = dummy_bean
					.getUI_M_PROD_SA_INST_PYMT_TYPE();
			String prod_code = pm_il_product_bean.getPROD_CODE();
			String prod_plan_code = pm_il_product_bean.getPROD_PLAN_CODE();

			String delQuery = "DELETE FROM PM_IL_SA_INST_PYMT WHERE  SIP_PROD_CODE = ? "
					+ "AND SIP_PLAN_CODE = ?";
			values = new Object[]{prod_code, prod_plan_code};

			if ("B".equalsIgnoreCase(CommonUtils.nvl(M_PROD_SA_INST_PYMT_TYPE,
					pm_il_product_bean.getPROD_SA_INST_PYMT_TYPE()))
					&& M_DUMMY == 0) {
				handler.executeDeleteStatement(delQuery, con, values);
				dummy_bean.setUI_M_DUMMY(1);
			}
			if ("A".equalsIgnoreCase(pm_il_product_bean
					.getPROD_SA_INST_PYMT_TYPE())
					&& M_DUMMY == 0) {
				M_FLAG = "Y";
				if ("A".equalsIgnoreCase(CommonUtils.nvl(
						M_PROD_SA_INST_PYMT_TYPE, pm_il_product_bean
								.getPROD_SA_INST_PYMT_TYPE()))) {
					if (CommonUtils.nvl(dummy_bean.getUI_M_PROD_PERIOD(),
							pm_il_product_bean.getPROD_PERIOD()) != CommonUtils
							.nvl(pm_il_product_bean.getPROD_PERIOD(), 0)
							|| CommonUtils.nvl(dummy_bean
									.getUI_M_PROD_PERIOD_MULTIPLE(),
									pm_il_product_bean
											.getPROD_PERIOD_MULTIPLE()) != CommonUtils
									.nvl(pm_il_product_bean
											.getPROD_PERIOD_MULTIPLE(), 0)) {
						dummy_bean.setUI_M_PROD_PERIOD(pm_il_product_bean
								.getPROD_PERIOD());
						dummy_bean
								.setUI_M_PROD_PERIOD_MULTIPLE(pm_il_product_bean
										.getPROD_PERIOD_MULTIPLE());
						values = new Object[]{
								pm_il_product_bean.getPROD_CODE(),
								pm_il_product_bean.getPROD_PLAN_CODE()};
						String delQry1 = "DELETE FROM PM_IL_SA_INST_PYMT WHERE  "
								+ "SIP_PROD_CODE  = ? AND SIP_PLAN_CODE  = ?";
						handler.executeDeleteStatement(delQry1, con, values);
					} else
						M_FLAG = "N";
				}
				if ("Y".equalsIgnoreCase(M_FLAG)) {

					M_DURATION = NumericFunctions.round(CommonUtils.nvl(
							pm_il_product_bean.getPROD_PERIOD(), 0)
							/ CommonUtils.nvl(pm_il_product_bean
									.getPROD_PERIOD_MULTIPLE(), 1));
					values = new Object[]{
							pm_il_product_bean.getPROD_CODE(),
							pm_il_product_bean.getPROD_PLAN_CODE(),
							M_DURATION,
							new java.sql.Date(Calendar.getInstance()
									.getTimeInMillis()),
							CommonUtils.getControlBean().getM_USER_ID()};
					for (int i = 0; i < M_DURATION; i++) {
						String qry = "INSERT INTO PM_IL_SA_INST_PYMT "
								+ "(SIP_PROD_CODE, SIP_PLAN_CODE, SIP_PERC,SIP_NUMR_PERIOD,"
								+ "SIP_DEMR_PERIOD,SIP_REMARKS,SIP_BL_REMARKS,SIP_CR_DT,SIP_CR_UID,"
								+ " SIP_UPD_DT,SIP_UPD_UID) "
								+ "VALUES ( ?, ?, 0, I, ?, null, null, ?, ?, null, null)";
						dummy_bean.setUI_M_DUMMY1(1);
					}
				} else {
					if (("B".equalsIgnoreCase(pm_il_product_bean
							.getPROD_SA_INST_PYMT_TYPE()) || ("C"
							.equalsIgnoreCase(pm_il_product_bean
									.getPROD_SA_INST_PYMT_TYPE())))
							&& dummy_bean.getUI_M_DUMMY() == 0) {
						values = new Object[]{
								pm_il_product_bean.getPROD_CODE(),
								pm_il_product_bean.getPROD_PLAN_CODE()};
						String qry = "DELETE FROM PM_IL_SA_INST_PYMT WHERE "
								+ " SIP_PROD_CODE  = ? AND  SIP_PLAN_CODE  = ?";
						handler.executeDeleteStatement(qry, con, values);
						dummy_bean.setUI_M_DUMMY(1);
					}

				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PRE_DELETE(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String M_DUMMY = null;
		PM_IL_PRODUCT_ACTION pm_il_product_action_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN();
		PM_IL_PRODUCT pm_il_product_bean = pm_il_product_action_bean
				.getPM_IL_PRODUCT_BEAN();
		Connection con = null;
		ResultSet rs1 = null;
		CRUDHandler handler = null;
		try {
			con = CommonUtils.getConnection();
			handler = new CRUDHandler();
			String C1 = "SELECT 'X'  FROM   PT_IL_POLICY WHERE  POL_PROD_CODE = ?";
			Object[] values = {pm_il_product_bean.getPROD_CODE()};
			rs1 = handler.executeSelectStatement(C1, con, values);
			if (rs1.next()) {
				M_DUMMY = rs1.getString(1);
			}
			if (M_DUMMY != null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91059"));
			} else {
				cascadeDelete(pm_il_product_bean);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void cascadeDelete(PM_IL_PRODUCT pm_il_product) throws Exception {

		Connection con = null;
		CRUDHandler handler = null;
		try {
			con = CommonUtils.getConnection();
			handler = new CRUDHandler();

			Object[] values = {pm_il_product.getPROD_CODE()};
			Object[] values1 = {pm_il_product.getPROD_CODE(),
					pm_il_product.getPROD_PLAN_CODE()};

			String PM_IL_PROD_APPL_COND_QUERY = "DELETE FROM PM_IL_PROD_APPL_COND P "
					+ " WHERE P.PACOND_PROD_CODE = ?";
			handler.executeDeleteStatement(PM_IL_PROD_APPL_COND_QUERY, con,
					values);

			String PM_IL_PROD_APPL_BONUS_QUERY = "DELETE FROM PM_IL_PROD_APPL_BONUS P "
					+ "WHERE P.PAB_PROD_CODE = ?";
			handler.executeDeleteStatement(PM_IL_PROD_APPL_BONUS_QUERY, con,
					values);

			String PM_IL_PROD_APPL_LOAD_TARIFF_QUERY = " DELETE FROM PM_IL_PROD_APPL_LOAD_TARIFF P WHERE"
					+ " P.PALT_PROD_CODE = ?";
			handler.executeDeleteStatement(PM_IL_PROD_APPL_LOAD_TARIFF_QUERY,
					con, values);

			String PM_IL_PROD_APPL_COVER_QUERY = " DELETE FROM PM_IL_PROD_APPL_COVER P WHERE "
					+ "P.PAC_PROD_CODE = ?";
			handler.executeDeleteStatement(PM_IL_PROD_APPL_COVER_QUERY, con,
					values);

			String PM_IL_SA_INST_PYMT_QUERY = "DELETE FROM PM_IL_SA_INST_PYMT P "
					+ "WHERE P.SIP_PROD_CODE = ? and P.SIP_PLAN_CODE = ?";
			handler.executeDeleteStatement(PM_IL_SA_INST_PYMT_QUERY, con,
					values1);

			String PM_IL_PROD_PREM_LIMIT_QUERY = "DELETE FROM "
					+ "PM_IL_PROD_PREM_LIMIT P WHERE P.PPL_PROD_CODE = ?";
			handler.executeDeleteStatement(PM_IL_PROD_PREM_LIMIT_QUERY, con,
					values);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void PRE_UPDATE(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_IL_PRODUCT_ACTION pm_il_product_action_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN();
		PM_IL_PRODUCT pm_il_product_bean = pm_il_product_action_bean
				.getPM_IL_PRODUCT_BEAN();
		try {
			pm_il_product_bean.setPROD_UPD_DT(new java.sql.Date(Calendar
					.getInstance().getTimeInMillis()));
			pm_il_product_bean.setPROD_UPD_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void WHEN_CREATE_RECORD(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		Connection con = null;
		CRUDHandler handler = null;
		String M_PLAN_TYPE = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		PM_IL_PRODUCT_ACTION pm_il_product_action_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN();
		PM_IL_PRODUCT pm_il_product_bean = pm_il_product_action_bean
				.getPM_IL_PRODUCT_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		try {
			con = CommonUtils.getConnection();
			handler = new CRUDHandler();
			String C1 = "SELECT  NVL(PLAN_SA_INST_PYMT_YN,'N'),NVL(PLAN_PERIOD_FROM,0), "
					+ "NVL(PLAN_PERIOD_TO,0),NVL(PLAN_MAX_AGE_ON_MAT,0),PLAN_TYPE FROM  "
					+ "PM_IL_PLAN WHERE  PLAN_CODE = ?";
			values = new Object[]{pm_il_product_bean.getPROD_PLAN_CODE()};
			rs1 = handler.executeSelectStatement(C1, con, values);
			while (rs1.next()) {
				dummy_bean.setUI_M_PLAN_PERIOD_FROM(rs1.getInt(2));
				dummy_bean.setUI_M_PLAN_PERIOD_TO(rs1.getInt(3));
				dummy_bean.setUI_M_PLAN_MAX_AGE_ON_MAT(rs1.getInt(4));
				M_PLAN_TYPE = rs1.getString(5);
			}

			String C2 = "SELECT CURR_DECIMAL FROM   FM_CURRENCY,FP_PARAMETER WHERE "
					+ "CURR_CODE =  PARA_VALUE AND    PARA_ID	 = 'BASE.CURR'";
			rs2 = handler.executeSelectStatement(C2, con);
			while (rs2.next()) {
				pm_il_product_bean.setPROD_COMM_RND_DEC(rs2.getInt(1));
			}
			pm_il_product_bean.setPROD_SA_BY_PLAN_BASIS_YN("N");
			pm_il_product_bean.setPROD_AGE_CALC_FLAG("2");
			pm_il_product_bean.setPROD_TARIFF_TERM_FLAG("1");
			pm_il_product_bean.setPROD_JOINT_LIFE_YN("N");
			pm_il_product_bean.setPROD_SA_INST_PYMT_TYPE("C");
			pm_il_product_bean.setPROD_CBC_YN("N");
			pm_il_product_bean.setPROD_AUTO_APPROV("N");
			pm_il_product_bean.setPROD_CONT_LOAD_RATE_PER(100);
			pm_il_product_bean.setPROD_EXP_LOAD_RATE_PER(100);
			pm_il_product_bean.setPROD_WITHDRAW_YN("N");
			pm_il_product_bean.setPROD_TOPUP_YN("N");

			pm_il_product_bean.setPROD_COMM_RND_TYPE("U");
			pm_il_product_bean.setPROD_THR_BASIS("S");
			pm_il_product_bean.setPROD_BROK_CALC_MTHD("2");
			pm_il_product_bean.setPROD_PRODUCTION_PERC(100.0);
			pm_il_product_bean.setPROD_THRESHOLD_PERC(100.0);
			pm_il_product_bean.setPROD_GRP_THRESHOLD_PERC(100.0);
			pm_il_product_bean.setPROD_PREM_CALC_MTHD("T");
			pm_il_product_bean.setPROD_INST_BASIS("N");
			pm_il_product_bean.setPROD_PERIOD_MULTIPLE(1);
			pm_il_product_bean.setPROD_CALC_ALLOC("A");
			pm_il_product_bean.setPROD_ROUND_OPTION("N");
			pm_il_product_bean.setPROD_PRODUCT_TYPE("T");
			pm_il_product_bean.setPROD_LOAD_CHARGE_YN("Y");
			pm_il_product_bean.setPROD_SERVICE_TAX_YN("N");
			pm_il_product_bean.setPROD_MODE_OF_CALC("A");
			pm_il_product_bean.setPROD_AGENT_HIRE_YN("N");
			pm_il_product_bean.setPROD_MATU_DT("O");
			pm_il_product_bean.setPROD_DRIP_MTHD("W");
			/*Added saranya for RM018T - FSD_IL_ZB Life_001-Education Endowment Plan COMMENTS on 13-03-2017*/
			pm_il_product_bean.setPROD_UNIT_LINK_TYPE("NA");
			compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getCOMP_PROD_UNIT_LINK_TYPE().resetValue();
			/*End*/
			pm_il_product_bean.setPROD_INTER_FUND_YN("N");
			pm_il_product_bean.setPROD_TOLL_LIMIT_YN("N");
			pm_il_product_bean.setPROD_RI_RECOV_BASIS("P");
			pm_il_product_bean.setPROD_SA_BY_PLAN_BASIS_YN("N");
			pm_il_product_bean.setPROD_MASTER_CERT_YN("N");
			pm_il_product_bean.setPROD_TRAN_RATE_YN("N");
			if ("M".equalsIgnoreCase(M_PLAN_TYPE)) {
				pm_il_product_bean.setPROD_AGE_SET_BACK(0);
				pm_il_product_bean.setPROD_SURR_CALC_TYPE("U");
				pm_il_product_bean.setPROD_DEF_PERIOD_FLAG("M");
				pm_il_product_bean.setPROD_RSA_CALC_TYP("F");
			} else {
				pm_il_product_bean.setPROD_ENDT_VAL_DAYS(0);
				pm_il_product_bean.setPROD_COOLOFF_DAYS(0);
				pm_il_product_bean.setPROD_MAX_DEFER_MONTHS(0);
				pm_il_product_bean.setPROD_DEF_PERIOD_FLAG("N");
				pm_il_product_bean.setPROD_RSA_CALC_TYP("N");
				pm_il_product_bean.setPROD_CONT_LOAD_RATE(0.0);
				pm_il_product_bean.setPROD_CONT_LOAD_RATE_PER(0);
				pm_il_product_bean.setPROD_EXP_LOAD_RATE(0.0);
				pm_il_product_bean.setPROD_EXP_LOAD_RATE_PER(0);
				pm_il_product_bean.setPROD_MORT_CODE("");
				pm_il_product_bean.setPROD_EMI_TOLERANCE(0);
				pm_il_product_bean.setPROD_AGE_SET_BACK(0);
				pm_il_product_bean.setPROD_SURR_CALC_TYPE("S");
			}
			pm_il_product_bean.setPROD_ALLOC_TYPE("N");
			pm_il_product_bean.setPROD_BUY_BASIS("T");
			pm_il_product_bean.setPROD_AUTO_UW("N");
			pm_il_product_bean.setPROD_MAT_AMT_TYPE("SA");
			pm_il_product_bean.setPROD_MAT_RATE_PER(1);
			pm_il_product_bean.setPROD_MRTA_RATE_CALC_YN("T");

			//pm_il_product_bean.setPROD_PREM_COMP_EVENT("1");
			pm_il_product_bean.setPROD_TOPUP_CHARGE_TYPE("S");

			/*
			 * compositeAction.getTabbedBar().setTabEnabled(
			 * compositeAction.TAB_PM_IL_SA_INST_PYMT);
			 * compositeAction.getTabbedBar().setTabEnabled(
			 * compositeAction.TAB_PM_IL_SA_INST_PYMT1);
			 * compositeAction.getTabbedBar().setTabEnabled(
			 * compositeAction.TAB_PM_IL_SA_INST_PYMT2);
			 */
			compositeAction.getWizard().enableWizardItem(
					"PILM035_APAC_PM_IL_SA_INST_PYMT");
			compositeAction.getWizard().enableWizardItem(
					"PILM035_APAC_PM_IL_SA_INST_PYMT1");
			compositeAction.getWizard().enableWizardItem(
					"PILM035_APAC_PM_IL_SA_INST_PYMT2");

			pm_il_product_action_bean.getCOMP_PROD_TARIFF_TERM_FLAG()
					.setDisabled(false);
			pm_il_product_action_bean.getCOMP_PROD_TARIFF_TERM_FLAG()
					.setRendered(true);
			pm_il_product_action_bean.getCOMP_PROD_SA_INST_PYMT_TYPE()
					.setDisabled(false);
			pm_il_product_action_bean.getCOMP_PROD_SA_INST_PYMT_TYPE()
					.setRendered(true);
			pm_il_product_action_bean.getCOMP_PROD_JOINT_LIFE_YN().setDisabled(
					false);
			pm_il_product_action_bean.getCOMP_PROD_JOINT_LIFE_YN().setRendered(
					true);
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_APPL_SUB_PLANS()
					.setDisabled(true);
			/*Added by sankara narayanan for hospital cash plan on 21-04-2017*/
			pm_il_product_bean.setPROD_INTR_SAVINGS_YN("N");
			/*end*/
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void WHEN_NEW_RECORD_INSTANCE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		Connection con = null;
		ResultSet rs = null;
		String M_PLAN_SA_INST_PYMT_YN = null;
		CRUDHandler handler = new CRUDHandler();
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();

		String M_PLAN_TYPE = null;
		String M_PLAN_RED_SA_BASIS = null;
		try {
			con = CommonUtils.getConnection();
			String C1 = "SELECT  NVL(PLAN_SA_INST_PYMT_YN,'N'),PLAN_TYPE,PLAN_RED_SA_BASIS "
					+ "FROM  PM_IL_PLAN " + "WHERE   PLAN_CODE = ?";
			
			Object[] c1values = {pm_il_product_bean.getPROD_PLAN_CODE()};
			rs = handler.executeSelectStatement(C1, con, c1values);
			
			//[addded reminder field by akash  to implement reminder functionality.
			
			
			if("N".equals(pm_il_product_bean.getPROD_REM_YN())){
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getCOMP_REM_INFO_4().setDisabled(true);
				
			}else{
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getCOMP_REM_INFO_4().setDisabled(false);
			}

			//addded reminder field by akash  to implement reminder functionality.]
			if (pm_il_product_bean.getROWID() != null) {
				while (rs.next()) {
					M_PLAN_SA_INST_PYMT_YN = rs.getString(1);
					M_PLAN_TYPE = rs.getString(2);
					M_PLAN_RED_SA_BASIS = rs.getString(3);
				}
				if ("A".equalsIgnoreCase(pm_il_product_bean
						.getPROD_SA_INST_PYMT_TYPE())) {
					/*
					 * compositeAction.getTabbedBar().setTabDisabled(
					 * compositeAction.TAB_PM_IL_SA_INST_PYMT1);
					 * compositeAction.getTabbedBar().setTabEnabled(
					 * compositeAction.TAB_PM_IL_SA_INST_PYMT);
					 * compositeAction.getTabbedBar().setTabDisabled(
					 * compositeAction.TAB_PM_IL_SA_INST_PYMT2);
					 */
					compositeAction.getWizard().enableWizardItem(
							"PILM035_APAC_PM_IL_SA_INST_PYMT");
					compositeAction.getWizard().disableWizardItem(
							"PILM035_APAC_PM_IL_SA_INST_PYMT1");
					compositeAction.getWizard().disableWizardItem(
							"PILM035_APAC_PM_IL_SA_INST_PYMT2");

					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_SA_INST_PYMT_TYPE()
							.setDisabled(false);
				} else if ("B".equalsIgnoreCase(pm_il_product_bean
						.getPROD_SA_INST_PYMT_TYPE())) {

					/*
					 * compositeAction.getTabbedBar().setTabDisabled(
					 * compositeAction.TAB_PM_IL_SA_INST_PYMT);
					 * compositeAction.getTabbedBar().setTabEnabled(
					 * compositeAction.TAB_PM_IL_SA_INST_PYMT1);
					 * compositeAction.getTabbedBar().setTabDisabled(
					 * compositeAction.TAB_PM_IL_SA_INST_PYMT2);
					 */
					compositeAction.getWizard().disableWizardItem(
							"PILM035_APAC_PM_IL_SA_INST_PYMT");
					compositeAction.getWizard().enableWizardItem(
							"PILM035_APAC_PM_IL_SA_INST_PYMT1");
					compositeAction.getWizard().disableWizardItem(
							"PILM035_APAC_PM_IL_SA_INST_PYMT2");

					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_SA_INST_PYMT_TYPE()
							.setDisabled(false);

				} else if ("C".equalsIgnoreCase(pm_il_product_bean
						.getPROD_SA_INST_PYMT_TYPE())) {
					/*
					 * compositeAction.getTabbedBar().setTabDisabled(
					 * compositeAction.TAB_PM_IL_SA_INST_PYMT);
					 * compositeAction.getTabbedBar().setTabDisabled(
					 * compositeAction.TAB_PM_IL_SA_INST_PYMT1);
					 * compositeAction.getTabbedBar().setTabDisabled(
					 * compositeAction.TAB_PM_IL_SA_INST_PYMT2);
					 */
					compositeAction.getWizard().disableWizardItem(
							"PILM035_APAC_PM_IL_SA_INST_PYMT");
					compositeAction.getWizard().disableWizardItem(
							"PILM035_APAC_PM_IL_SA_INST_PYMT1");
					compositeAction.getWizard().disableWizardItem(
							"PILM035_APAC_PM_IL_SA_INST_PYMT2");

					if ("N".equalsIgnoreCase(M_PLAN_SA_INST_PYMT_YN)) {
						compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
								.getCOMP_PROD_SA_INST_PYMT_TYPE().setDisabled(
										true);
					}
				} else if ("D".equalsIgnoreCase(pm_il_product_bean
						.getPROD_SA_INST_PYMT_TYPE())) {
					/*
					 * compositeAction.getTabbedBar().setTabDisabled(
					 * compositeAction.TAB_PM_IL_SA_INST_PYMT);
					 * compositeAction.getTabbedBar().setTabDisabled(
					 * compositeAction.TAB_PM_IL_SA_INST_PYMT1);
					 * compositeAction.getTabbedBar().setTabEnabled(
					 * compositeAction.TAB_PM_IL_SA_INST_PYMT2);
					 */
					compositeAction.getWizard().disableWizardItem(
							"PILM035_APAC_PM_IL_SA_INST_PYMT");
					compositeAction.getWizard().disableWizardItem(
							"PILM035_APAC_PM_IL_SA_INST_PYMT1");
					compositeAction.getWizard().enableWizardItem(
							"PILM035_APAC_PM_IL_SA_INST_PYMT2");
				}

				if ("J".equalsIgnoreCase(M_PLAN_TYPE)) {
					pm_il_product_bean.setPROD_JOINT_LIFE_YN("Y");
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_JOINT_LIFE_YN().setDisabled(true);
				} else {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_JOINT_LIFE_YN().setDisabled(false);
				}

				if (CommonUtils.nvl(pm_il_product_bean.getPROD_PREM_PAY_YRS(),
						0) != CommonUtils.nvl(pm_il_product_bean
						.getPROD_PERIOD(), 0)) {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_TARIFF_TERM_FLAG().setDisabled(false);
				} else {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_TARIFF_TERM_FLAG().setDisabled(true);
				}
				if ("R".equalsIgnoreCase(M_PLAN_RED_SA_BASIS)||("M".equalsIgnoreCase(M_PLAN_TYPE))) {

					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MAX_DEFER_MONTHS().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MAX_DEFER_MONTHS().setRequired(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_DEF_PERIOD_FLAG().setRequired(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_DEF_PERIOD_FLAG().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_RSA_CALC_TYP().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_RSA_CALC_TYP().setRequired(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_CONT_LOAD_RATE().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_CONT_LOAD_RATE().setRequired(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_CONT_LOAD_RATE_PER()
							.setRequired(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_CONT_LOAD_RATE_PER().setDisabled(
									false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_EXP_LOAD_RATE().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_EXP_LOAD_RATE().setRequired(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_EXP_LOAD_RATE_PER()
							.setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_EXP_LOAD_RATE_PER().setRequired(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_PREM_CALC_MTHD().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_BASIS().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_PERC().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_PERC().setRequired(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_RATE_PER().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_RATE_PER().setRequired(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_AGE_SET_BACK().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_AGE_SET_BACK().setRequired(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MRTA_RATE_CALC_YN().setRequired(true);
				} else {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MAX_DEFER_MONTHS().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MAX_DEFER_MONTHS().setRequired(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_DEF_PERIOD_FLAG().setRequired(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_DEF_PERIOD_FLAG().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_RSA_CALC_TYP().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_RSA_CALC_TYP().setRequired(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_CONT_LOAD_RATE().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_CONT_LOAD_RATE().setRequired(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_CONT_LOAD_RATE_PER().setRequired(
									false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_CONT_LOAD_RATE_PER()
							.setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_EXP_LOAD_RATE().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_EXP_LOAD_RATE().setRequired(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_EXP_LOAD_RATE_PER().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_EXP_LOAD_RATE_PER()
							.setRequired(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_PREM_CALC_MTHD().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_BASIS().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_PERC().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_PERC().setRequired(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_RATE_PER().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_RATE_PER().setRequired(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_AGE_SET_BACK().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_AGE_SET_BACK().setRequired(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MRTA_RATE_CALC_YN()
							.setRequired(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MRTA_RATE_CALC_YN().setDisabled(true);
					compositeAction
							.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
							.getCOMP_PALT_LOAD_APPL_PERC().setDisabled(true);
				}

				if (("R".equalsIgnoreCase(M_PLAN_RED_SA_BASIS))
						&& ("N".equalsIgnoreCase(pm_il_product_bean
								.getPROD_INST_BASIS()))) {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_PERC().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_PERC().setRequired(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_RATE_PER().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_RATE_PER().setRequired(false);
				} else if ("R".equalsIgnoreCase(M_PLAN_RED_SA_BASIS)
						&& ("P".equalsIgnoreCase(pm_il_product_bean
								.getPROD_INST_BASIS()))) {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_PERC().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_PERC().setRequired(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_RATE_PER().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_RATE_PER().setRequired(true);
				} else {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_PERC().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_PERC().setRequired(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_RATE_PER().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_INST_RATE_PER().setRequired(false);
				}
			}
			if ("U".equalsIgnoreCase(M_PLAN_TYPE)) {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_BUY_BASIS().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_ALLOC_TYPE().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_CALC_ALLOC().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_PREM_HOLIDAY_CODE().setDisabled(false);
				compositeAction.getWizard().enableWizardItem("PILM035_APAC_PM_IL_PROD_CONTRI_CHARGE");
				compositeAction.getWizard().enableWizardItem("PILM035_APAC_PM_IL_PROD_INVEST_PREM_DEDC");
				//compositeAction.getWizard().disableWizardItem("PILM035_APAC_PM_IL_PROD_APPL_BONUS");
				compositeAction.getWizard().enableWizardItem("PILM035_APAC_PM_IL_PROD_APPL_BONUS");
			} else {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_BUY_BASIS().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_ALLOC_TYPE().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_CALC_ALLOC().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_PREM_HOLIDAY_CODE().setDisabled(true);
				compositeAction.getWizard().disableWizardItem("PILM035_APAC_PM_IL_PROD_CONTRI_CHARGE");
				compositeAction.getWizard().disableWizardItem("PILM035_APAC_PM_IL_PROD_INVEST_PREM_DEDC");
				compositeAction.getWizard().enableWizardItem("PILM035_APAC_PM_IL_PROD_APPL_BONUS");
			}
			if ("T".equalsIgnoreCase(M_PLAN_TYPE))
			{
				compositeAction.getWizard().disableWizardItem("PILM035_APAC_PM_IL_PROD_APPL_BONUS");
			}
			
			if (("R"
					.equalsIgnoreCase(pm_il_product_bean.getPROD_ROUND_OPTION()) || ("I"
					.equalsIgnoreCase(pm_il_product_bean.getPROD_ROUND_OPTION()) || ("U"
					.equalsIgnoreCase(pm_il_product_bean.getPROD_ROUND_OPTION()) || ("D"
					.equalsIgnoreCase(pm_il_product_bean.getPROD_ROUND_OPTION())))))) {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_ROUND_VALUE().setDisabled(false);
			} else {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_ROUND_VALUE().setDisabled(true);
			}
			if (("R"
					.equalsIgnoreCase(pm_il_product_bean.getPROD_ROUND_OPTION()) || ("I"
					.equalsIgnoreCase(pm_il_product_bean.getPROD_ROUND_OPTION()) || ("U"
					.equalsIgnoreCase(pm_il_product_bean.getPROD_ROUND_OPTION()) || ("D"
					.equalsIgnoreCase(pm_il_product_bean.getPROD_ROUND_OPTION())))))) {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_ROUND_VALUE().setRequired(true);
			} else {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_ROUND_VALUE().setRequired(false);
			}

			/*if ("M".equalsIgnoreCase(M_PLAN_TYPE)
					|| "U".equalsIgnoreCase(M_PLAN_TYPE)
					|| "R".equalsIgnoreCase(M_PLAN_TYPE)) {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_MORE_INFO_3().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_REM_INFO_5().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_MORE_INFO_2().setDisabled(false);
			} else {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_MORE_INFO_3().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_REM_INFO_5().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_MORE_INFO_2().setDisabled(true);
			}*/
			if("M".equalsIgnoreCase(M_PLAN_TYPE))
			{
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
				.getCOMP_MORE_INFO_2().setDisabled(false);
			}
			else
			{
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
				.getCOMP_MORE_INFO_2().setDisabled(true);
			}
			if("U".equalsIgnoreCase(M_PLAN_TYPE))
			{
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
				.getCOMP_MORE_INFO_3().setDisabled(false);
			}
			else
			{
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
				.getCOMP_MORE_INFO_3().setDisabled(true);
			}
			if ("U".equalsIgnoreCase(M_PLAN_TYPE)) {
				/*
				 * compositeAction.getTabbedBar().setTabEnabled(
				 * compositeAction.TAB_PM_IL_PROD_APPL_FUND);
				 */
				compositeAction.getWizard().enableWizardItem(
						"PILM035_APAC_PM_IL_PROD_APPL_FUND");
			} else {
				/*
				 * compositeAction.getTabbedBar().setTabDisabled(
				 * compositeAction.TAB_PM_IL_PROD_APPL_FUND);
				 */
				compositeAction.getWizard().disableWizardItem(
						"PILM035_APAC_PM_IL_PROD_APPL_FUND");
			}

			if ("T".equalsIgnoreCase(pm_il_product_bean
					.getPROD_PREM_CALC_MTHD())
					&& "R".equalsIgnoreCase(M_PLAN_RED_SA_BASIS)) {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MRTA_RATE_CALC_YN().setDisabled(false);
			} else if ("X".equalsIgnoreCase(pm_il_product_bean
					.getPROD_PREM_CALC_MTHD())) {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MRTA_RATE_CALC_YN().setDisabled(true);
			}

			if ("Y".equalsIgnoreCase(CommonUtils.nvl(pm_il_product_bean
					.getPROD_TOPUP_YN(), "N"))) {
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_M_BUT_TOPUP_PARAM().setDisabled(false);
				if ("S".equalsIgnoreCase(pm_il_product_bean
						.getPROD_TOPUP_CHARGE_TYPE())) {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_UI_M_BUT_TOP_UP_DETAIL().setDisabled(true);
				} else if (("L".equalsIgnoreCase(pm_il_product_bean
						.getPROD_TOPUP_CHARGE_TYPE()) || ("B"
						.equalsIgnoreCase(pm_il_product_bean
								.getPROD_TOPUP_CHARGE_TYPE())))) {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_UI_M_BUT_TOP_UP_DETAIL()
							.setDisabled(false);
				}
			} else if ("N".equalsIgnoreCase(CommonUtils.nvl(pm_il_product_bean
					.getPROD_TOPUP_YN(), "N"))) {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_UI_M_BUT_TOP_UP_DETAIL().setDisabled(true);
				compositeAction.getDUMMY_ACTION_BEAN()
						.getCOMP_M_BUT_TOPUP_PARAM().setDisabled(true);
			}
			if ("Y".equalsIgnoreCase(CommonUtils.nvl(pm_il_product_bean
					.getPROD_TOPUP_YN(), "N"))) {

				if (compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_MIN_YRS().isDisabled() == true) {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_TOPUP_MIN_YRS().setDisabled(false);
				}
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_PROD_PERC().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_COMM_CODE().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_FUND_FEE().setDisabled(false);

				if (compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_FUND_FEE_RATE_PER().isDisabled() == true) {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_FUND_FEE_RATE_PER()
							.setDisabled(false);
				}
				if (compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_CHARGE_TYPE().isDisabled() == true) {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_TOPUP_CHARGE_TYPE()
							.setDisabled(false);
				}
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_MIN_YRS().setRequired(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_PROD_PERC().setRequired(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_FUND_FEE().setRequired(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_FUND_FEE_RATE_PER().setRequired(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_CHARGE_TYPE().setRequired(true);
			} else {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_MIN_YRS().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_PROD_PERC().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_COMM_CODE().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_FUND_FEE().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_FUND_FEE_RATE_PER().setDisabled(true);

				if (compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_CHARGE_TYPE().isDisabled() == false) {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_TOPUP_CHARGE_TYPE().setDisabled(true);
				}
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_MIN_YRS().setRequired(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_PROD_PERC().setRequired(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_FUND_FEE().setRequired(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_FUND_FEE_RATE_PER().setRequired(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_TOPUP_CHARGE_TYPE().setRequired(false);
			}

			if ("Y".equalsIgnoreCase(pm_il_product_bean.getPROD_TOPUP_YN())) {
				if ("S".equalsIgnoreCase(pm_il_product_bean
						.getPROD_TOPUP_CHARGE_TYPE())) {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_FUND_FEE().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_FUND_FEE().setRequired(true);
					if (compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_FUND_FEE_RATE_PER().isDisabled() == true) {
						compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
								.getCOMP_PROD_FUND_FEE_RATE_PER().setDisabled(
										false);
					}
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_FUND_FEE().setDisabled(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_FUND_FEE_RATE_PER().setRequired(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_UI_M_BUT_TOP_UP_DETAIL().setDisabled(true);
				} else if (("L".equalsIgnoreCase(pm_il_product_bean
						.getPROD_TOPUP_CHARGE_TYPE()) || ("B"
						.equalsIgnoreCase(pm_il_product_bean
								.getPROD_TOPUP_CHARGE_TYPE())))) {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_FUND_FEE().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_FUND_FEE().setRequired(false);

					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_FUND_FEE_RATE_PER().setDisabled(true);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_FUND_FEE_RATE_PER()
							.setRequired(false);
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_UI_M_BUT_TOP_UP_DETAIL()
							.setDisabled(false);
				}
			}
			if ("Y".equalsIgnoreCase(CommonUtils.nvl(pm_il_product_bean
					.getPROD_WITHDRAW_YN(), "N"))) {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_UI_M_BUT_WITHDRAW_DETAIL().setDisabled(false);
			} else {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_UI_M_BUT_WITHDRAW_DETAIL().setDisabled(true);
			}

			if ("N"
					.equalsIgnoreCase(pm_il_product_bean
							.getPROD_TOLL_LIMIT_YN())) {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INTER_FUND_YN().setDisabled(true);
			} else {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_INTER_FUND_YN().setDisabled(false);
			}

			if ("C".equalsIgnoreCase(pm_il_product_bean
					.getPROD_SA_INST_PYMT_TYPE())) {
				// :BP.B_MATURITY_PARAMETERS := 'Maturity Parameters';

				if (compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_AMT_TYPE().isDisabled() == true) {
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
							.getCOMP_PROD_MAT_AMT_TYPE().setDisabled(false);
				}
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_RATE().setDisabled(false);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_RATE_PER().setDisabled(false);
			} else if ("B".equalsIgnoreCase(pm_il_product_bean
					.getPROD_SA_INST_PYMT_TYPE())) {
				// :BP.B_MATURITY_PARAMETERS := 'Maturity Parameters';
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_AMT_TYPE().setDisabled(false);
			} else {
				// :BP.B_MATURITY_PARAMETERS := NULL;
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_AMT_TYPE().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_RATE().setDisabled(true);
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_MAT_RATE_PER().setDisabled(true);
			}

			if ("Y".equalsIgnoreCase(pm_il_product_bean
					.getPROD_SA_BY_PLAN_BASIS_YN())) {
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_APPL_SUB_PLANS()
						.setDisabled(false);
			} else if ("N".equalsIgnoreCase(pm_il_product_bean
					.getPROD_SA_BY_PLAN_BASIS_YN())) {
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_APPL_SUB_PLANS()
						.setDisabled(true);
			}
			compositeAction.getWizard().disableWizardItem(
			"PILM035_APAC_PM_IL_PROD_PREM_LIMIT");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void PRE_BLOCK(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PRE_INSERT(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_IL_PRODUCT_ACTION pm_il_product_action_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN();
		PM_IL_PRODUCT pm_il_product_bean = pm_il_product_action_bean
				.getPM_IL_PRODUCT_BEAN();
		try {
			pm_il_product_bean.setPROD_CR_DT(new java.sql.Date(Calendar
					.getInstance().getTimeInMillis()));
			pm_il_product_bean.setPROD_CR_UID(CommonUtils.getControlBean()
					.getM_USER_ID());

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void WHEN_NEW_BLOCK_INSTANCE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void KEY_PRVBLK(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void ON_CHECK_DELETE_MASTER(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void ON_POPULATE_DETAILS(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

		PM_IL_PRODUCT pm_il_product = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
			if (pm_il_product.getROWID() != null) {
				new PM_IL_PROD_APPL_COND_DELEGATE()
						.executeSelectStatement(compositeAction);
				new PM_IL_PROD_APPL_BONUS_DELEGATE()
						.executeSelectStatement(compositeAction);
				new PM_IL_PROD_APPL_LOAD_TARIFF_DELEGATE()
						.executeSelectStatement(compositeAction);
				new PM_IL_PROD_APPL_COVER_DELEGATE()
						.executeSelectStatement(compositeAction);

				if (pm_il_product.getPROD_PLAN_CODE() != null) {
					new PM_IL_SA_INST_PYMT_DELEGATE()
							.executeSelectStatement(compositeAction);
					new PM_IL_SA_INST_PYMT1_DELEGATE()
							.executeSelectStatement(compositeAction);
				}
				new PM_IL_PROD_PREM_LIMIT_DELEGATE()
						.executeSelectStatement(compositeAction);
				new PM_IL_PROD_APPL_FUND_DELEGATE()
						.executeSelectStatement(compositeAction);
				new PM_IL_TOP_UP_CHARGE_DELEGATE()
						.executeSelectStatement(compositeAction);
				new PM_IL_PROD_APPL_FUND_1_DELEGATE()
						.executeSelectStatement(compositeAction);
				new PM_IL_PROD_WD_PARAM_HDR_DELEGATE()
						.executeSelectStatement(compositeAction);
				new PM_IL_PROD_TOPUP_PARAM_DELEGATE()
						.executeSelectStatement(compositeAction);
				new PM_IL_PROD_APPL_PLANS_DELEGATE()
						.executeSelectStatement(compositeAction);
				// new
				// PM_IL_PROD_SURR_PAID_FACTOR_DELEGATE().executeSelectStatement(compositeAction);
				new PM_IL_PROD_APPL_CVR_GRP_DELEGATE()
						.executeSelectStatement(compositeAction);
				new PM_IL_PROD_INSURER_DELEGATE().executeSelectStatement(compositeAction);

			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void POST_INSERT(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_IL_PRODUCT_ACTION pm_il_product_action_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN();
		PM_IL_PRODUCT pm_il_product_bean = pm_il_product_action_bean
				.getPM_IL_PRODUCT_BEAN();
		String product_plan_code = pm_il_product_bean.getPROD_PLAN_CODE();
		Date sysdate = new java.sql.Date(Calendar.getInstance()
				.getTimeInMillis());
		String userId = CommonUtils.getControlBean().getM_USER_ID();
		Connection con = null;
		CRUDHandler handler = null;
		Double M_DURATION = 0.0;

		try {
			con = CommonUtils.getConnection();
			handler = new CRUDHandler();

			if ("A".equalsIgnoreCase(pm_il_product_bean
					.getPROD_SA_INST_PYMT_TYPE())) {
				String insertQry = "INSERT INTO PM_IL_SA_INST_PYMT (SIP_PROD_CODE, "
						+ "SIP_PLAN_CODE, "
						+ "SIP_PERC, "
						+ "SIP_NUMR_PERIOD, "
						+ "SIP_DEMR_PERIOD, "
						+ "SIP_REMARKS, "
						+ "SIP_BL_REMARKS, "
						+ "SIP_CR_DT, "
						+ "SIP_CR_UID, "
						+ "SIP_UPD_DT, "
						+ "SIP_UPD_UID) "
						+ "VALUES (?, ?, 0, I, ?, null, null, ?, ?, null, null)";

				M_DURATION = CommonUtils.roundDouble(new Double(CommonUtils
						.nvl(pm_il_product_bean.getPROD_PERIOD(), 0))
						/ CommonUtils.nvl(pm_il_product_bean.getPROD_PERIOD(),
								1));
				Object[] values = {pm_il_product_bean.getPROD_CODE(),
						product_plan_code, M_DURATION, sysdate, userId};
				for (int i = 0; i < M_DURATION; i++) {
					handler.executeInsertStatement(insertQry, con, values);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}

	}

	public void PROD_SA_BY_PLAN_BASIS_YN_KEY_NEXT_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_SA_BY_PLAN_BASIS_YN_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		String prod_sa_by_plan_basis_yn = (String) currValue;
		try {
			if ("Y".equalsIgnoreCase(prod_sa_by_plan_basis_yn)) {
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_APPL_SUB_PLANS()
						.setDisabled(false);
				
				/* Newly Added By Dhinesh on 13-06-2018 for FLA SSP call id  : FLALIFEQC-1754274 */
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getCOMP_PROD_SA_TARIFF().setRequired(true);
				/* End */
				
			} else if ("N".equalsIgnoreCase(prod_sa_by_plan_basis_yn)) {
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_APPL_SUB_PLANS()
						.setDisabled(true);
				
				/* Newly Added By Dhinesh on 13-06-2018 for FLA SSP call id  : FLALIFEQC-1754274 */
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getCOMP_PROD_SA_TARIFF().setRequired(false);
				/* End */
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_SA_BY_PLAN_BASIS_YN_WHEN_LIST_CHANGED(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		String prod_sa_by_plan_basis_yn = (String) currValue;
		try {
			if ("Y".equalsIgnoreCase(prod_sa_by_plan_basis_yn)) {
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_APPL_SUB_PLANS()
						.setDisabled(false);
			} else if ("N".equalsIgnoreCase(prod_sa_by_plan_basis_yn)) {
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_APPL_SUB_PLANS()
						.setDisabled(true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_CBC_YN_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String PROD_CBC_YN = (String) currValue;
		try {
			if ("Y".equalsIgnoreCase(PROD_CBC_YN)) {
				pm_il_product_bean.setPROD_AUTO_APPROV("Y");
			} else {
				pm_il_product_bean.setPROD_AUTO_APPROV("N");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_CBC_YN_WHEN_LIST_CHANGED(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_CODE_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		Connection con = null;
		Object[] values = null;
		ResultSet rs1 = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			String M_DUMMY = null;
			String prod_code = (String) currValue;
			con = CommonUtils.getConnection();
			String C1 = " SELECT ROWID FROM   PM_IL_PRODUCT "
					+ "WHERE  PROD_CODE =  ?";
			values = new Object[]{prod_code};
			rs1 = handler.executeSelectStatement(C1, con, values);
			while (rs1.next()) {
				M_DUMMY = rs1.getString(1);
				if (CommonUtils.isDuplicate(pm_il_product_bean.getROWID(),
						M_DUMMY))
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "19001"));
			}

		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void PROD_COMM_RND_TYPE_WHEN_LIST_CHANGED(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		String prod_comm_rnd_type = (String) currValue;
		try {
			if ("F".equalsIgnoreCase(prod_comm_rnd_type)) {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_COMM_RND_DEC().setDisabled(true);
			} else {
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getCOMP_PROD_COMM_RND_DEC().setDisabled(false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_DEF_PERIOD_FM_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
			if (pm_il_product_bean.getPROD_DEF_PERIOD_FM() > 100) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[]{"Deferred Period From", "less than 100"}));
			} else if (pm_il_product_bean.getPROD_DEF_PERIOD_FM() < 0) {
				throw new ValidatorException(Messages
						.getMessage(PELConstants.pelErrorMessagePath, "91014",
								new Object[]{"Deferred Period From",
										"greater than 100"}));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void M_EDIT_PROD_LOND_DESC_WHEN_BUTTON_PRESSED(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void M_LOV_PROD_WAKFEE_FACTOR_WHEN_BUTTON_PRESSED(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_BROK_CALC_MTHD_WHEN_LIST_CHANGED(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_BROK_CALC_MTHD_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String prod_brok_calc_mthd = (String) currValue;
		try {
			if ("1".equalsIgnoreCase(prod_brok_calc_mthd)
					|| "5".equalsIgnoreCase(prod_brok_calc_mthd)) {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_BCH_CODE().setDisabled(false);
			} else {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_BCH_CODE().setDisabled(true);
			}
			if ("Y"
					.equalsIgnoreCase(pm_il_product_bean
							.getPROD_AGENT_HIRE_YN())
					&& "6".equals(pm_il_product_bean.getPROD_BROK_CALC_MTHD())) {

				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3206",
						new Object[]{"Actual Premium Paid cannot "
								+ "be selected if Agent Hierarchy is yes"}));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_BROK_CALC_MTHD_WHEN_LIST_CHANGED(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		PM_IL_PROD_APPL_COVER pm_il_prod_appl_cover_bean = compositeAction
				.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
				.getPM_IL_PROD_APPL_COVER_BEAN();

		try {
			if ("1".equalsIgnoreCase(pm_il_product_bean
					.getPROD_BROK_CALC_MTHD())
					|| "5".equalsIgnoreCase(pm_il_product_bean
							.getPROD_BROK_CALC_MTHD())) {
				compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
						.getCOMP_PAC_BCH_CODE().setDisabled(false);
				if ((pm_il_prod_appl_cover_bean.getPAC_BCH_CODE() == null)) {
					pm_il_prod_appl_cover_bean
							.setPAC_BCH_CODE(pm_il_product_bean
									.getPROD_BCH_CODE());
				} else {
					pm_il_prod_appl_cover_bean.setPAC_BCH_CODE("");
					compositeAction.getPM_IL_PROD_APPL_COVER_ACTION_BEAN()
							.getCOMP_PAC_BCH_CODE().setDisabled(true);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void PROD_SA_FACTOR_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String prod_sa_factor = (String) currValue;
		try {
			if (prod_sa_factor != null) {
				ArrayList<String> PROD_SA_FACTOR_DESC = dbprocedures
						.P_VAL_CODES_PM_CHARGER("IL_VAL_TAR", prod_sa_factor,
								pm_il_product_bean.getPROD_SA_FACTOR_DESC(),
								"N", "N", null, null, "ENG", null);
				pm_il_product_bean.setPROD_SA_FACTOR_DESC(PROD_SA_FACTOR_DESC
						.get(0));
			} else {
				pm_il_product_bean.setPROD_SA_FACTOR_DESC(null);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_SA_TARIFF_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String prod_sa_tariff = (String) currValue;
		try {
			if (prod_sa_tariff != null) {
				ArrayList<String> PROD_SA_TARIFF_DESC = dbprocedures
						.P_VAL_CODES_PM_CHARGER("IL_VAL_TAR", prod_sa_tariff,
								pm_il_product_bean.getPROD_SA_TARIFF_DESC(),
								"N", "E", null, null, "ENG", null);
				pm_il_product_bean.setPROD_SA_TARIFF_DESC(PROD_SA_TARIFF_DESC
						.get(0));
			} else {
				pm_il_product_bean.setPROD_SA_TARIFF_DESC(null);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_SA_FACTOR_KEY_LISTVAL(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_BL_DESC_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String prod_bl_desc = (String) currValue;
		try {
			pm_il_product_bean.setPROD_BL_LONG_DESC(prod_bl_desc);
			pm_il_product_bean.setPROD_BL_SHORT_DESC(CommonUtils.SUBSTR(
					prod_bl_desc, 0, 30));
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_DEF_PERIOD_TO_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
			if (pm_il_product_bean.getPROD_DEF_PERIOD_TO() > 100) {

				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[]{"Deferred Period To", "less than 100"}));
			} else if (pm_il_product_bean.getPROD_DEF_PERIOD_TO() < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[]{"Deferred Period To", "greater than 100"}));
			}

			if (pm_il_product_bean.getPROD_DEF_PERIOD_TO() < pm_il_product_bean
					.getPROD_DEF_PERIOD_FM()) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "90008",
						new Object[]{"To Year", "From Year"}));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_WAQAF_PERIOD_FM_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
			if (pm_il_product_bean.getPROD_WAQAF_PERIOD_FM() > 100) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[]{"Waqaf Period From", "less than 100"}));
			} else if (pm_il_product_bean.getPROD_WAQAF_PERIOD_FM() < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[]{"Waqaf Period From", "greater than 100"}));
			}

			if (pm_il_product_bean.getPROD_WAQAF_PERIOD_FM() < pm_il_product_bean
					.getPROD_DEF_PERIOD_FM()
					&& pm_il_product_bean.getPROD_WAQAF_PERIOD_FM() > pm_il_product_bean
							.getPROD_DEF_PERIOD_TO()) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71205"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_WAQAF_PERIOD_TO_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
			if (pm_il_product_bean.getPROD_WAQAF_PERIOD_TO() > 100) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[]{"Waqaf Period To", "less than 100"}));
			} else if (pm_il_product_bean.getPROD_WAQAF_PERIOD_FM() < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[]{"Waqaf Period To", "greater than 100"}));
			}
			if (pm_il_product_bean.getPROD_WAQAF_PERIOD_TO() < pm_il_product_bean
					.getPROD_DEF_PERIOD_FM()
					&& pm_il_product_bean.getPROD_WAQAF_PERIOD_FM() > pm_il_product_bean
							.getPROD_DEF_PERIOD_TO()) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71205"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_EFF_FM_DT_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();

		Date fm_date = (Date) currValue;
		try {
			if (fm_date != null
					&& pm_il_product_bean.getPROD_EFF_TO_DT() != null) {
				if (fm_date.after(pm_il_product_bean.getPROD_EFF_TO_DT())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91001"));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PROD_MASTER_CERT_YN_KEY_NEXT_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		try {

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void executeQuery(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PM_IL_PRODUCT_DELEGATE()
					.executeSelectStatement(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/*
	 * the below method newly added by sujatha for top up multiple validator 
	 */
	public void validPROD_TOPUP_MULTIPLE(Double currValue,
			PM_IL_PRODUCT PM_IL_PRODUCT_BEAN) throws Exception {
		String planType = getPlanType(PM_IL_PRODUCT_BEAN);
		if (null != planType && "U".equalsIgnoreCase(planType)) {
			if (null == currValue || currValue == 0.0) {
				try {
					throw new Exception(
							"Top up Multiple : Value should be greaterthan 0");
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception(e.getMessage());
				}
			}
		}

	}

	public String getPlanType(PM_IL_PRODUCT PM_IL_PRODUCT_BEAN)
			throws Exception {
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String planType = null;
		String C1 = "SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE = ?";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection,
					new Object[] { PM_IL_PRODUCT_BEAN.getPROD_PLAN_CODE() });
			if (resultSet.next()) {
				planType = resultSet.getString(1);
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
		}finally{try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}}
		return planType;
	}
	
	
}
