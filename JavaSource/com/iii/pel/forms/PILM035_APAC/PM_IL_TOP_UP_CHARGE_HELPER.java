package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_TOP_UP_CHARGE_HELPER {

	public void executeQuery(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PM_IL_TOP_UP_CHARGE_DELEGATE()
					.executeSelectStatement(compositeAction);
			List<PM_IL_TOP_UP_CHARGE> dataList = compositeAction
					.getPM_IL_TOP_UP_CHARGE_ACTION_BEAN()
					.getDataList_PM_IL_TOP_UP_CHARGE();
			if (dataList != null && dataList.size() > 0) {
				PM_IL_TOP_UP_CHARGE PM_IL_TOP_UP_CHARGE_BEAN = dataList.get(0);
				PM_IL_TOP_UP_CHARGE_BEAN.setRowSelected(true);
				compositeAction.getPM_IL_TOP_UP_CHARGE_ACTION_BEAN()
						.setPM_IL_TOP_UP_CHARGE_BEAN(PM_IL_TOP_UP_CHARGE_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void PRE_INSERT(PILM035_APAC_COMPOSITE_ACTION compositeAction)throws Exception {

		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();

		PM_IL_TOP_UP_CHARGE pm_il_top_up_charge_bean = compositeAction
				.getPM_IL_TOP_UP_CHARGE_ACTION_BEAN()
				.getPM_IL_TOP_UP_CHARGE_BEAN();

		try {
			L_UNIQUE_TOP_UP_EFF_DT(compositeAction);
			pm_il_top_up_charge_bean.setTUC_CR_DT(new CommonUtils()
					.getCurrentDate());
			pm_il_top_up_charge_bean.setTUC_CR_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
			pm_il_top_up_charge_bean.setTUC_PROD_CODE(pm_il_product_bean
					.getPROD_CODE());
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}
	}

	public void PRE_UPDATE(PILM035_APAC_COMPOSITE_ACTION compositeAction)throws Exception {
		PM_IL_TOP_UP_CHARGE pm_il_top_up_charge_bean = compositeAction
				.getPM_IL_TOP_UP_CHARGE_ACTION_BEAN()
				.getPM_IL_TOP_UP_CHARGE_BEAN();

		try {
			L_UNIQUE_TOP_UP_EFF_DT(compositeAction);
			pm_il_top_up_charge_bean.setTUC_UPD_DT(new CommonUtils()
					.getCurrentDate());
			pm_il_top_up_charge_bean.setTUC_UPD_UID(CommonUtils
					.getControlBean().getM_USER_ID());
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}
	}
	
	public void TUC_AMT_LC_FROM_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction)throws Exception {
		PM_IL_TOP_UP_CHARGE pm_il_top_up_charge_bean = compositeAction
				.getPM_IL_TOP_UP_CHARGE_ACTION_BEAN()
				.getPM_IL_TOP_UP_CHARGE_BEAN();
		 
		try {
			if (pm_il_top_up_charge_bean.getTUC_AMT_LC_FROM() != null
					&& pm_il_top_up_charge_bean.getTUC_AMT_LC_TO() != null) {
				if (pm_il_top_up_charge_bean.getTUC_AMT_LC_FROM() > pm_il_top_up_charge_bean
						.getTUC_AMT_LC_TO()) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "10064"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void TUC_AMT_LC_TO_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction)throws Exception {
		try {
			PM_IL_TOP_UP_CHARGE pm_il_top_up_charge_bean = compositeAction
					.getPM_IL_TOP_UP_CHARGE_ACTION_BEAN()
					.getPM_IL_TOP_UP_CHARGE_BEAN();
			if (pm_il_top_up_charge_bean.getTUC_AMT_LC_FROM() != null
					&& pm_il_top_up_charge_bean.getTUC_AMT_LC_TO() != null) {
				if (pm_il_top_up_charge_bean.getTUC_AMT_LC_FROM() > pm_il_top_up_charge_bean
						.getTUC_AMT_LC_TO()) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "10064"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}
	}
	
	public void TUC_EFF_FM_DT_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		try {
			PM_IL_TOP_UP_CHARGE pm_il_top_up_charge_bean = compositeAction
					.getPM_IL_TOP_UP_CHARGE_ACTION_BEAN()
					.getPM_IL_TOP_UP_CHARGE_BEAN();
			if (pm_il_top_up_charge_bean.getTUC_EFF_FM_DT() != null
					&& pm_il_top_up_charge_bean.getTUC_EFF_TO_DT() != null) {
				if (pm_il_top_up_charge_bean.getTUC_EFF_FM_DT().after(
						pm_il_top_up_charge_bean.getTUC_EFF_TO_DT())) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91001"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}

	}
	
	public void TUC_EFF_TO_DT_WHEN_VALIDATE_ITEM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction)throws Exception {
		try {
			PM_IL_TOP_UP_CHARGE pm_il_top_up_charge_bean = compositeAction
					.getPM_IL_TOP_UP_CHARGE_ACTION_BEAN()
					.getPM_IL_TOP_UP_CHARGE_BEAN();
			if (pm_il_top_up_charge_bean.getTUC_EFF_FM_DT() != null
					&& pm_il_top_up_charge_bean.getTUC_EFF_TO_DT() != null) {
				if (pm_il_top_up_charge_bean.getTUC_EFF_FM_DT().after(
						pm_il_top_up_charge_bean.getTUC_EFF_TO_DT())) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91001"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}

	}

	public void L_UNIQUE_TOP_UP_EFF_DT(
			PILM035_APAC_COMPOSITE_ACTION compositeAction)throws Exception {

		String M_DUMMY = null;
		Connection con = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		Object[] c1values = null;
		Object[] c2values = null;
		CRUDHandler handler = new CRUDHandler();

		PM_IL_TOP_UP_CHARGE pm_il_top_up_charge_bean = compositeAction
				.getPM_IL_TOP_UP_CHARGE_ACTION_BEAN()
				.getPM_IL_TOP_UP_CHARGE_BEAN();

		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();

		String C1 = "SELECT 'X' " + "FROM   PM_IL_TOP_UP_CHARGE "
				+ "WHERE  TUC_PROD_CODE    = ?"
				+ "AND    (? BETWEEN TUC_AMT_LC_FROM AND TUC_AMT_LC_TO "
				+ "OR     ? BETWEEN TUC_AMT_LC_FROM AND TUC_AMT_LC_TO) "
				+ "AND    (? BETWEEN TUC_EFF_FM_DT AND TUC_EFF_TO_DT "
				+ "OR    ? BETWEEN TUC_EFF_FM_DT AND TUC_EFF_TO_DT)";

		String C2 = "SELECT 'X' " + "FROM   PM_IL_TOP_UP_CHARGE "
				+ "WHERE  TUC_PROD_CODE    = ? "
				+ "AND    (? BETWEEN TUC_AMT_LC_FROM AND TUC_AMT_LC_TO "
				+ "OR      ? BETWEEN TUC_AMT_LC_FROM AND TUC_AMT_LC_TO) "
				+ "AND    (? BETWEEN TUC_EFF_FM_DT AND TUC_EFF_TO_DT "
				+ "OR     ? BETWEEN TUC_EFF_FM_DT AND TUC_EFF_TO_DT) "
				+ "AND    ROWID <> ?";

		try {
			con = CommonUtils.getConnection();
			if (pm_il_top_up_charge_bean.getROWID() == null) {
				c1values = new Object[] { pm_il_product_bean.getPROD_CODE(),
						pm_il_top_up_charge_bean.getTUC_AMT_LC_FROM(),
						pm_il_top_up_charge_bean.getTUC_AMT_LC_TO(),
						pm_il_top_up_charge_bean.getTUC_EFF_FM_DT(),
						pm_il_top_up_charge_bean.getTUC_EFF_TO_DT() };
				rs1 = handler.executeSelectStatement(C1, con, c1values);
				while (rs1.next()) {
					M_DUMMY = rs1.getString(1);
				}
				if ("X".equalsIgnoreCase(M_DUMMY)) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91049"));
				}
			} else {
				c2values = new Object[] { pm_il_product_bean.getPROD_CODE(),
						pm_il_top_up_charge_bean.getTUC_AMT_LC_FROM(),
						pm_il_top_up_charge_bean.getTUC_AMT_LC_TO(),
						pm_il_top_up_charge_bean.getTUC_EFF_FM_DT(),
						pm_il_top_up_charge_bean.getTUC_EFF_TO_DT(),
						pm_il_top_up_charge_bean.getROWID() };
				rs2 = handler.executeSelectStatement(C2, con, c2values);
				while (rs2.next()) {
					M_DUMMY = rs2.getString(1);
				}
				if ("X".equalsIgnoreCase(M_DUMMY)) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91049"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();throw e;
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
