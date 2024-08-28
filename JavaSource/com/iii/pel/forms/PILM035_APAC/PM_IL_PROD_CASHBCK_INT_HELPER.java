package com.iii.pel.forms.PILM035_APAC;


import java.sql.Connection;
import java.util.Date;
import java.util.List;

import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
public class PM_IL_PROD_CASHBCK_INT_HELPER {

	PILM035_APAC_PROCS_HELPER PILM035_APAC_PROCS_HELPER_BEAN = new PILM035_APAC_PROCS_HELPER();

	public void CASHBCK_NO_TO_DAYS_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PROD_CASHBCK_INT PM_IL_PROD_CASHBCK_INT_bean = compositeAction
				.getPM_IL_PROD_CASHBCK_INT_ACTION_BEAN()
				.getPM_IL_PROD_CASHBCK_INT_BEAN();
		try {
			if (PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_NO_FM_DAYS() != null) {
				if (PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_NO_FM_DAYS() > (Integer) currValue) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "80015"));
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CASHBCK_EFF_TO_DT_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PROD_CASHBCK_INT PM_IL_PROD_CASHBCK_INT_bean = compositeAction
				.getPM_IL_PROD_CASHBCK_INT_ACTION_BEAN()
				.getPM_IL_PROD_CASHBCK_INT_BEAN();
		try {

			if (PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_EFF_FM_DT() != null) {
				if (PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_EFF_FM_DT().after((Date)currValue))
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91010"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CASHBCK_EFF_FM_DT_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PROD_CASHBCK_INT PM_IL_PROD_CASHBCK_INT_bean = compositeAction
				.getPM_IL_PROD_CASHBCK_INT_ACTION_BEAN()
				.getPM_IL_PROD_CASHBCK_INT_BEAN();
		Connection con = null;
		try {
			con = CommonUtils.getConnection();

			if (PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_EFF_TO_DT() != null) {
				if ((PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_EFF_FM_DT()
						.after(PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_EFF_TO_DT())))
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71145"));

			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CASHBCK_NO_FM_DAYS_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PROD_CASHBCK_INT PM_IL_PROD_CASHBCK_INT_bean = compositeAction
				.getPM_IL_PROD_CASHBCK_INT_ACTION_BEAN()
				.getPM_IL_PROD_CASHBCK_INT_BEAN();
		Connection con = null;
		try {
			con = CommonUtils.getConnection();

			if (PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_NO_TO_DAYS() != null) {
				if (PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_NO_FM_DAYS() > PM_IL_PROD_CASHBCK_INT_bean
						.getCASHBCK_NO_TO_DAYS()) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91054"));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CASHBCK_MAX_LC_AMT_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PROD_CASHBCK_INT PM_IL_PROD_CASHBCK_INT_bean = compositeAction
				.getPM_IL_PROD_CASHBCK_INT_ACTION_BEAN()
				.getPM_IL_PROD_CASHBCK_INT_BEAN();
		Connection con = null;
		try {
			con = CommonUtils.getConnection();

			if (PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_MIN_LC_AMT() != null) {
				if (PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_MIN_LC_AMT() > (Double)currValue) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "81086"));
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PRE_BLOCK(PILM035_APAC_COMPOSITE_ACTION compositeAction)
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

	public void PRE_INSERT(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_IL_PROD_CASHBCK_INT PM_IL_PROD_CASHBCK_INT_bean = compositeAction
				.getPM_IL_PROD_CASHBCK_INT_ACTION_BEAN()
				.getPM_IL_PROD_CASHBCK_INT_BEAN();
			Connection con = null;

		try {
			con = CommonUtils.getConnection();
			PM_IL_PROD_CASHBCK_INT_bean.setCASHBCK_PROD_CODE(compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_CODE());
			PILM035_APAC_PROCS_HELPER_BEAN.L_CHECK_UNIQUE_CLM_LATE_FEE(compositeAction);
			
			PM_IL_PROD_CASHBCK_INT_bean.setCASHBCK_CR_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			PM_IL_PROD_CASHBCK_INT_bean.setCASHBCK_CR_DT(new CommonUtils()
					.getCurrentDate());
			PM_IL_PROD_CASHBCK_INT_bean.setCASHBCK_CR_DT(new CommonUtils()
			.getCurrentDate());
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PRE_UPDATE(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_IL_PROD_CASHBCK_INT PM_IL_PROD_CASHBCK_INT_bean = compositeAction
				.getPM_IL_PROD_CASHBCK_INT_ACTION_BEAN()
				.getPM_IL_PROD_CASHBCK_INT_BEAN();
		Connection con = null;
		try {
			con = CommonUtils.getConnection();

			PILM035_APAC_PROCS_HELPER_BEAN.L_CHECK_UNIQUE_CLM_LATE_FEE(compositeAction);
			PM_IL_PROD_CASHBCK_INT_bean.setCASHBCK_UPD_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			PM_IL_PROD_CASHBCK_INT_bean.setCASHBCK_UPD_DT(new CommonUtils()
					.getCurrentDate());

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void CASHBCK_MIN_LC_AMT_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PROD_CASHBCK_INT PM_IL_PROD_CASHBCK_INT_bean = compositeAction
				.getPM_IL_PROD_CASHBCK_INT_ACTION_BEAN()
				.getPM_IL_PROD_CASHBCK_INT_BEAN();
		Connection con = null;
		try {
			con = CommonUtils.getConnection();

			if (PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_MAX_LC_AMT() != null) {
				if (PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_MIN_LC_AMT() > PM_IL_PROD_CASHBCK_INT_bean
						.getCASHBCK_MAX_LC_AMT()) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "81086"));
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void executeQuery(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PM_IL_PROD_CASHBCK_INT_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PM_IL_PROD_CASHBCK_INT> dataList = compositeAction
				.getPM_IL_PROD_CASHBCK_INT_ACTION_BEAN()
				.getDataList_PM_IL_PROD_CASHBCK_INT();
		if (dataList != null && dataList.size() > 0) {
			PM_IL_PROD_CASHBCK_INT PM_IL_PROD_CASHBCK_INT_BEAN = dataList.get(0);
			PM_IL_PROD_CASHBCK_INT_BEAN.setRowSelected(true);
			compositeAction.getPM_IL_PROD_CASHBCK_INT_ACTION_BEAN()
					.setPM_IL_PROD_CASHBCK_INT_BEAN(PM_IL_PROD_CASHBCK_INT_BEAN);
		}
	}

}
