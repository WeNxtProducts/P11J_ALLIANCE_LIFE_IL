package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_WD_PARAM_DTL_HELPER {

	public void PRE_BLOCK(PILM035_APAC_COMPOSITE_ACTION compositeAction) {
	}

	public void WHEN_NEW_BLOCK_INSTANCE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) {
	}

	public void PRE_INSERT(PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception
			{
		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();

		PM_IL_PROD_WD_PARAM_DTL pm_il_prod_wd_param_dtl_bean = compositeAction
				.getPM_IL_PROD_WD_PARAM_DTL_ACTION_BEAN()
				.getPM_IL_PROD_WD_PARAM_DTL_BEAN();
		PM_IL_PROD_WD_PARAM_HDR pm_il_prod_wd_param_hdr_bean = compositeAction
				.getPM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN()
				.getPM_IL_PROD_WD_PARAM_HDR_BEAN();
		String c1 = " SELECT P9IL_PWPD_SYS_ID.NEXTVAL FROM   DUAL";
		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(c1, con);
			L_UNIQUE_WITHDRAWAL_EFF_DT(compositeAction);
			while (rs.next()) {
				pm_il_prod_wd_param_dtl_bean.setPWPD_SYS_ID(rs.getInt(1));
			}
			pm_il_prod_wd_param_dtl_bean.setPWPD_CR_DT(new CommonUtils()
					.getCurrentDate());
			pm_il_prod_wd_param_dtl_bean.setPWPD_CR_UID(CommonUtils
					.getControlBean().getUSER_ID());
			pm_il_prod_wd_param_dtl_bean
					.setPWPD_PWPH_SYS_ID(pm_il_prod_wd_param_hdr_bean
							.getPWPH_SYS_ID());

		} catch (Exception e) {
			e.printStackTrace();
			compositeAction.getPM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN()
					.getErrorMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							e.getMessage());
			compositeAction.getPM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN()
					.getErrorMap().put("insert", e.getMessage());
			//throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void PRE_UPDATE(PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception
			{
		try {
			PM_IL_PROD_WD_PARAM_DTL pm_il_prod_wd_param_dtl_bean = compositeAction
					.getPM_IL_PROD_WD_PARAM_DTL_ACTION_BEAN()
					.getPM_IL_PROD_WD_PARAM_DTL_BEAN();
			L_UNIQUE_WITHDRAWAL_EFF_DT(compositeAction);
			pm_il_prod_wd_param_dtl_bean.setPWPD_UPD_DT(new CommonUtils()
					.getCurrentDate());
			pm_il_prod_wd_param_dtl_bean.setPWPD_UPD_UID(CommonUtils
					.getGlobalVariable("GLOBAL.USER_ID"));
		} catch (Exception e) {
			e.printStackTrace();
			compositeAction.getPM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN()
					.getErrorMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							e.getMessage());
			compositeAction.getPM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN()
					.getErrorMap().put("update", e.getMessage());
		}

	}

	public void L_UNIQUE_WITHDRAWAL_EFF_DT(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		Connection con = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		String M_DUMMY = null;
		CRUDHandler handler = new CRUDHandler();
		PM_IL_PROD_WD_PARAM_DTL pm_il_prod_wd_param_dtl_bean = compositeAction
				.getPM_IL_PROD_WD_PARAM_DTL_ACTION_BEAN()
				.getPM_IL_PROD_WD_PARAM_DTL_BEAN();
		PM_IL_PROD_WD_PARAM_HDR pm_il_prod_wd_param_hdr_bean = compositeAction
				.getPM_IL_PROD_WD_PARAM_HDR_ACTION_BEAN()
				.getPM_IL_PROD_WD_PARAM_HDR_BEAN();
		String C1 = "SELECT 'X' FROM   PM_IL_PROD_WD_PARAM_DTL WHERE  PWPD_PWPH_SYS_ID = ? AND ( "
				+ "? BETWEEN PWPD_FM_PREM_PAY_YRS AND PWPD_TO_PREM_PAY_YRS "
				+ "OR  ? BETWEEN PWPD_FM_PREM_PAY_YRS AND PWPD_TO_PREM_PAY_YRS)";
		String C2 = " SELECT 'X'  FROM   PM_IL_PROD_WD_PARAM_DTL  WHERE  PWPD_PWPH_SYS_ID = ? AND ( "
				+ " ? BETWEEN PWPD_FM_PREM_PAY_YRS AND PWPD_TO_PREM_PAY_YRS "
				+ "OR ? BETWEEN PWPD_FM_PREM_PAY_YRS AND PWPD_TO_PREM_PAY_YRS )"
				+ "AND  ROWID <> ?";
		try {
			con = CommonUtils.getConnection();
			Object[] c1values = {
					pm_il_prod_wd_param_hdr_bean.getPWPH_SYS_ID(),
					pm_il_prod_wd_param_dtl_bean.getPWPD_FM_PREM_PAY_YRS(),
					pm_il_prod_wd_param_dtl_bean.getPWPD_TO_PREM_PAY_YRS() };
			rs1 = handler.executeSelectStatement(C1, con, c1values);
			if (pm_il_prod_wd_param_dtl_bean.getROWID() == null) {
				while (rs1.next()) {
					M_DUMMY = rs1.getString(1);
				}
			}
			Object[] c2values = {
					pm_il_prod_wd_param_hdr_bean.getPWPH_SYS_ID(),
					pm_il_prod_wd_param_dtl_bean.getPWPD_FM_PREM_PAY_YRS(),
					pm_il_prod_wd_param_dtl_bean.getPWPD_TO_PREM_PAY_YRS(),
					pm_il_prod_wd_param_dtl_bean.getROWID() };
			rs2 = handler.executeSelectStatement(C2, con, c2values);
			if ("X".equalsIgnoreCase(M_DUMMY)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91049"));
			} else {
				while (rs2.next()) {
					M_DUMMY = rs2.getString(1);
				}
			}
			if ("X".equalsIgnoreCase(M_DUMMY)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91049"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void WHEN_VALIDATATE_ITEM_PWPD_FM_PREM_PAY_YRS(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)throws Exception {
		PM_IL_PROD_WD_PARAM_DTL pm_il_prod_wd_param_dtl_bean = compositeAction
				.getPM_IL_PROD_WD_PARAM_DTL_ACTION_BEAN()
				.getPM_IL_PROD_WD_PARAM_DTL_BEAN();
		Double PWPD_FM_PREM_PAY_YRS = (Double) currValue;
		try {
			if (pm_il_prod_wd_param_dtl_bean.getPWPD_TO_PREM_PAY_YRS() != null) {
				if (PWPD_FM_PREM_PAY_YRS > pm_il_prod_wd_param_dtl_bean
						.getPWPD_TO_PREM_PAY_YRS()) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71047"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}

	}

	public void WHEN_VALIDATATE_ITEM_PWPD_TO_PREM_PAY_YRS(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)throws Exception {
		PM_IL_PROD_WD_PARAM_DTL pm_il_prod_wd_param_dtl_bean = compositeAction
				.getPM_IL_PROD_WD_PARAM_DTL_ACTION_BEAN()
				.getPM_IL_PROD_WD_PARAM_DTL_BEAN();
		Double PWPD_TO_PREM_PAY_YRS = (Double) currValue;
		try {
			if (pm_il_prod_wd_param_dtl_bean.getPWPD_FM_PREM_PAY_YRS() != null) {
				if (pm_il_prod_wd_param_dtl_bean.getPWPD_FM_PREM_PAY_YRS() > PWPD_TO_PREM_PAY_YRS) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91032"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}

	}

	public void WHEN_VALIDATE_ITEM_PWPD_LC_MIN_AMT(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)throws Exception {
		PM_IL_PROD_WD_PARAM_DTL pm_il_prod_wd_param_dtl_bean = compositeAction
				.getPM_IL_PROD_WD_PARAM_DTL_ACTION_BEAN()
				.getPM_IL_PROD_WD_PARAM_DTL_BEAN();
		Double PWPD_LC_MIN_AMT = (Double) currValue;
		try {
			if (pm_il_prod_wd_param_dtl_bean.getPWPD_LC_MAX_AMT() != null) {
				if (pm_il_prod_wd_param_dtl_bean.getPWPD_LC_MAX_AMT() < PWPD_LC_MIN_AMT) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91238"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}

	}

	public void WHEN_VALIDATE_ITEM_PWPD_LC_MAX_AMT(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)throws Exception {
		PM_IL_PROD_WD_PARAM_DTL pm_il_prod_wd_param_dtl_bean = compositeAction
				.getPM_IL_PROD_WD_PARAM_DTL_ACTION_BEAN()
				.getPM_IL_PROD_WD_PARAM_DTL_BEAN();
		Double PWPD_LC_MAX_AMT = (Double) currValue;
		try {
			if (pm_il_prod_wd_param_dtl_bean.getPWPD_LC_MIN_AMT() != null) {
				if (PWPD_LC_MAX_AMT < pm_il_prod_wd_param_dtl_bean
						.getPWPD_LC_MIN_AMT()) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "48695"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}

	}

	public void executeQuery(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PM_IL_PROD_WD_PARAM_DTL_DELEGATE()
					.executeSelectStatement(compositeAction);
			List<PM_IL_PROD_WD_PARAM_DTL> dataList = compositeAction
					.getPM_IL_PROD_WD_PARAM_DTL_ACTION_BEAN()
					.getDataList_PM_IL_PROD_WD_PARAM_DTL();
			if (dataList != null && dataList.size() > 0) {
				PM_IL_PROD_WD_PARAM_DTL PM_IL_PROD_WD_PARAM_DTL_BEAN = dataList
						.get(0);
				PM_IL_PROD_WD_PARAM_DTL_BEAN.setRowSelected(true);
				compositeAction.getPM_IL_PROD_WD_PARAM_DTL_ACTION_BEAN()
						.setPM_IL_PROD_WD_PARAM_DTL_BEAN(
								PM_IL_PROD_WD_PARAM_DTL_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}
	}

}
