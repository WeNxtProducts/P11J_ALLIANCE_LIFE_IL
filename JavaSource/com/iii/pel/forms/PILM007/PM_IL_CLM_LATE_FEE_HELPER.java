package com.iii.pel.forms.PILM007;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_CLM_LATE_FEE_HELPER {

	PILM007_PROCS_HELPER pilm007_procs_helper = new PILM007_PROCS_HELPER();

	public void CLF_NO_TO_DAYS_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_LATE_FEE pm_il_clm_late_fee_bean = compositeAction
				.getPM_IL_CLM_LATE_FEE_ACTION_BEAN()
				.getPM_IL_CLM_LATE_FEE_BEAN();
		try {
			if (pm_il_clm_late_fee_bean.getCLF_NO_FM_DAYS() != null) {
				if (pm_il_clm_late_fee_bean.getCLF_NO_FM_DAYS() > (Integer) currValue) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "80015"));
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CLF_EFF_TO_DT_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_LATE_FEE pm_il_clm_late_fee_bean = compositeAction
				.getPM_IL_CLM_LATE_FEE_ACTION_BEAN()
				.getPM_IL_CLM_LATE_FEE_BEAN();
		try {

			if (pm_il_clm_late_fee_bean.getCLF_EFF_FM_DT() != null) {
				if (pm_il_clm_late_fee_bean.getCLF_EFF_FM_DT().after((Date)currValue))
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91010"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CLF_EFF_FM_DT_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_LATE_FEE pm_il_clm_late_fee_bean = compositeAction
				.getPM_IL_CLM_LATE_FEE_ACTION_BEAN()
				.getPM_IL_CLM_LATE_FEE_BEAN();
		Connection con = null;
		try {
			con = CommonUtils.getConnection();

			if (pm_il_clm_late_fee_bean.getCLF_EFF_TO_DT() != null) {
				if ((pm_il_clm_late_fee_bean.getCLF_EFF_FM_DT()
						.after(pm_il_clm_late_fee_bean.getCLF_EFF_TO_DT())))
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71145"));

			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CLF_NO_FM_DAYS_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_LATE_FEE pm_il_clm_late_fee_bean = compositeAction
				.getPM_IL_CLM_LATE_FEE_ACTION_BEAN()
				.getPM_IL_CLM_LATE_FEE_BEAN();
		Connection con = null;
		try {
			con = CommonUtils.getConnection();

			if (pm_il_clm_late_fee_bean.getCLF_NO_TO_DAYS() != null) {
				if (pm_il_clm_late_fee_bean.getCLF_NO_FM_DAYS() > pm_il_clm_late_fee_bean
						.getCLF_NO_TO_DAYS()) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91054"));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CLF_MAX_LC_AMT_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_LATE_FEE pm_il_clm_late_fee_bean = compositeAction
				.getPM_IL_CLM_LATE_FEE_ACTION_BEAN()
				.getPM_IL_CLM_LATE_FEE_BEAN();
		Connection con = null;
		try {
			con = CommonUtils.getConnection();

			if (pm_il_clm_late_fee_bean.getCLF_MIN_LC_AMT() != null) {
				if (pm_il_clm_late_fee_bean.getCLF_MIN_LC_AMT() > (Double)currValue) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "81086"));
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PRE_BLOCK(PILM007_COMPOSITE_ACTION compositeAction)
			throws Exception {

		Connection con = null;
		try {
			con = CommonUtils.getConnection();
			/*
			 * if ((FORM_FAILURE)) {
			 * CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "TRUE"); }
			 * ctrl_bean.setM_DELETE_MSG_FLAG("N");
			 */
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PRE_INSERT(PILM007_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_IL_CLM_LATE_FEE pm_il_clm_late_fee_bean = compositeAction
				.getPM_IL_CLM_LATE_FEE_ACTION_BEAN()
				.getPM_IL_CLM_LATE_FEE_BEAN();
		PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();
		Connection con = null;

		try {
			con = CommonUtils.getConnection();

			pilm007_procs_helper.L_CHECK_UNIQUE_CLM_LATE_FEE(compositeAction);
			pm_il_clm_late_fee_bean.setCLF_COVER_CODE(pm_il_clm_repay_bean
					.getCR_COVER_CODE());
			pm_il_clm_late_fee_bean.setCLF_LOSS_TYPE(pm_il_clm_repay_bean
					.getCR_LOSS_TYPE());
			pm_il_clm_late_fee_bean.setCLF_DISABLE_TYPE(pm_il_clm_repay_bean
					.getCR_DISABLE_TYPE());
			pm_il_clm_late_fee_bean.setCLF_CR_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			pm_il_clm_late_fee_bean.setCLF_CR_DT(new CommonUtils()
					.getCurrentDate());

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PRE_UPDATE(PILM007_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_IL_CLM_LATE_FEE pm_il_clm_late_fee_bean = compositeAction
				.getPM_IL_CLM_LATE_FEE_ACTION_BEAN()
				.getPM_IL_CLM_LATE_FEE_BEAN();
		Connection con = null;
		try {
			con = CommonUtils.getConnection();

			pilm007_procs_helper.L_CHECK_UNIQUE_CLM_LATE_FEE(compositeAction);
			pm_il_clm_late_fee_bean.setCLF_UPD_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			pm_il_clm_late_fee_bean.setCLF_UPD_DT(new CommonUtils()
					.getCurrentDate());

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CLF_MIN_LC_AMT_WHEN_VALIDATE_ITEM(
			PILM007_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_CLM_LATE_FEE pm_il_clm_late_fee_bean = compositeAction
				.getPM_IL_CLM_LATE_FEE_ACTION_BEAN()
				.getPM_IL_CLM_LATE_FEE_BEAN();
		Connection con = null;
		try {
			con = CommonUtils.getConnection();

			if (pm_il_clm_late_fee_bean.getCLF_MAX_LC_AMT() != null) {
				if (pm_il_clm_late_fee_bean.getCLF_MIN_LC_AMT() > pm_il_clm_late_fee_bean
						.getCLF_MAX_LC_AMT()) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "81086"));
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void executeQuery(PILM007_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PM_IL_CLM_LATE_FEE_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PM_IL_CLM_LATE_FEE> dataList = compositeAction
				.getPM_IL_CLM_LATE_FEE_ACTION_BEAN()
				.getDataList_PM_IL_CLM_LATE_FEE();
		if (dataList != null && dataList.size() > 0) {
			PM_IL_CLM_LATE_FEE PM_IL_CLM_LATE_FEE_BEAN = dataList.get(0);
			PM_IL_CLM_LATE_FEE_BEAN.setRowSelected(true);
			compositeAction.getPM_IL_CLM_LATE_FEE_ACTION_BEAN()
					.setPM_IL_CLM_LATE_FEE_BEAN(PM_IL_CLM_LATE_FEE_BEAN);
		}
	}

}
