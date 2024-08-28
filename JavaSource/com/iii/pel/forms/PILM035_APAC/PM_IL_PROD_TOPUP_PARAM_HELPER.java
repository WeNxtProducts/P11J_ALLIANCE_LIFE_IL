package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_TOPUP_PARAM_HELPER {

	public void executeQuery(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PM_IL_PROD_TOPUP_PARAM_DELEGATE()
					.executeSelectStatement(compositeAction);
			List<PM_IL_PROD_TOPUP_PARAM> dataList = compositeAction
					.getPM_IL_PROD_TOPUP_PARAM_ACTION_BEAN()
					.getDataList_PM_IL_PROD_TOPUP_PARAM();
			if (dataList != null && dataList.size() > 0) {
				PM_IL_PROD_TOPUP_PARAM PM_IL_PROD_TOPUP_PARAM_BEAN = dataList
						.get(0);
				PM_IL_PROD_TOPUP_PARAM_BEAN.setRowSelected(true);
				compositeAction.getPM_IL_PROD_TOPUP_PARAM_ACTION_BEAN()
						.setPM_IL_PROD_TOPUP_PARAM_BEAN(
								PM_IL_PROD_TOPUP_PARAM_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void PRE_INSERT(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			PM_IL_PROD_TOPUP_PARAM pm_il_prod_topup_param_bean = compositeAction
					.getPM_IL_PROD_TOPUP_PARAM_ACTION_BEAN()
					.getPM_IL_PROD_TOPUP_PARAM_BEAN();
			PM_IL_PRODUCT pm_il_product_bean = compositeAction
					.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
			L_CHECK_UNIQUE_TOP_UP_PARAM(compositeAction);
			pm_il_prod_topup_param_bean.setPTP_CR_DT(new CommonUtils()
					.getCurrentDate());
			pm_il_prod_topup_param_bean.setPTP_CR_UID(CommonUtils
					.getControlBean().getM_USER_ID());
			pm_il_prod_topup_param_bean.setPTP_PROD_CODE(pm_il_product_bean
					.getPROD_CODE());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void PRE_UPDATE(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			PM_IL_PROD_TOPUP_PARAM pm_il_prod_topup_param_bean = compositeAction
					.getPM_IL_PROD_TOPUP_PARAM_ACTION_BEAN()
					.getPM_IL_PROD_TOPUP_PARAM_BEAN();
			L_CHECK_UNIQUE_TOP_UP_PARAM(compositeAction);
			pm_il_prod_topup_param_bean.setPTP_UPD_DT(new CommonUtils()
					.getCurrentDate());
			pm_il_prod_topup_param_bean.setPTP_UPD_UID(CommonUtils
					.getControlBean().getM_USER_ID());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void WHEN_CREATE_RECORD(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			PM_IL_PROD_TOPUP_PARAM pm_il_prod_topup_param_bean = compositeAction
					.getPM_IL_PROD_TOPUP_PARAM_ACTION_BEAN()
					.getPM_IL_PROD_TOPUP_PARAM_BEAN();
			pm_il_prod_topup_param_bean.setPTP_MODE_OF_PYMT("M");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void PTP_LC_MIN_AMT_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction)throws Exception {
		try {
			PM_IL_PROD_TOPUP_PARAM pm_il_prod_topup_param_bean = compositeAction
					.getPM_IL_PROD_TOPUP_PARAM_ACTION_BEAN()
					.getPM_IL_PROD_TOPUP_PARAM_BEAN();
			if (pm_il_prod_topup_param_bean.getPTP_LC_MAX_AMT() != null) {
				if (pm_il_prod_topup_param_bean.getPTP_LC_MAX_AMT() < pm_il_prod_topup_param_bean
						.getPTP_LC_MIN_AMT()) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91238"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void PTP_LC_MAX_AMT_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		try {
			PM_IL_PROD_TOPUP_PARAM pm_il_prod_topup_param_bean = compositeAction
					.getPM_IL_PROD_TOPUP_PARAM_ACTION_BEAN()
					.getPM_IL_PROD_TOPUP_PARAM_BEAN();
			if (pm_il_prod_topup_param_bean.getPTP_LC_MIN_AMT() != null) {
				if (pm_il_prod_topup_param_bean.getPTP_LC_MAX_AMT() < pm_il_prod_topup_param_bean
						.getPTP_LC_MIN_AMT()) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "80022"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	

	public void L_CHECK_UNIQUE_TOP_UP_PARAM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) {

		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();

		PM_IL_PROD_TOPUP_PARAM pm_il_prod_topup_param_bean = compositeAction
				.getPM_IL_PROD_TOPUP_PARAM_ACTION_BEAN()
				.getPM_IL_PROD_TOPUP_PARAM_BEAN();

		Connection con = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] c1values = null;
		Object[] c2values = null;
		String M_DUMMY = null;

		String C1 = "SELECT 'A' " + "FROM PM_IL_PROD_TOPUP_PARAM "
				+ "WHERE ?=PTP_PROD_CODE "
				+ "AND (? BETWEEN PTP_LC_MIN_AMT AND PTP_LC_MAX_AMT "
				+ "OR ? BETWEEN PTP_LC_MIN_AMT AND PTP_LC_MAX_AMT) "
				+ "AND ? = PTP_MODE_OF_PYMT";

		String C2 = "SELECT 'A' " + "FROM PM_IL_PROD_TOPUP_PARAM "
				+ "WHERE ?=PTP_PROD_CODE "
				+ "AND (? BETWEEN PTP_LC_MIN_AMT AND PTP_LC_MAX_AMT "
				+ "OR ? BETWEEN PTP_LC_MIN_AMT AND PTP_LC_MAX_AMT) "
				+ "AND ? = PTP_MODE_OF_PYMT " + "AND ROWID <> ?";

		try {
			if (pm_il_prod_topup_param_bean.getROWID() == null) {
				c1values = new Object[] { pm_il_product_bean.getPROD_CODE(),
						pm_il_prod_topup_param_bean.getPTP_LC_MIN_AMT(),
						pm_il_prod_topup_param_bean.getPTP_LC_MAX_AMT(),
						pm_il_prod_topup_param_bean.getPTP_MODE_OF_PYMT() };
				rs1 = handler.executeSelectStatement(C1, con, c1values);
				while (rs1.next()) {
					M_DUMMY = rs1.getString(1);
				}
				if (M_DUMMY != null) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "80005"));
				}
			} else {
				c2values = new Object[] { pm_il_product_bean.getPROD_CODE(),
						pm_il_prod_topup_param_bean.getPTP_LC_MIN_AMT(),
						pm_il_prod_topup_param_bean.getPTP_LC_MAX_AMT(),
						pm_il_prod_topup_param_bean.getPTP_MODE_OF_PYMT(),
						pm_il_prod_topup_param_bean.getROWID() };
				rs2 = handler.executeSelectStatement(C2, con, c2values);
				while (rs2.next()) {
					M_DUMMY = rs2.getString(1);
				}
				if (M_DUMMY != null) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "80005"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
