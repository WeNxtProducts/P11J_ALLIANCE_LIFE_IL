package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_SA_INST_PYMT1_HELPER {

	public void PRE_BLOCK(PILM035_APAC_COMPOSITE_ACTION compositeAction) {
	}

	public void WHEN_NEW_BLOCK_INSTANCE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) {

	}

	public void PRE_INSERT(PILM035_APAC_COMPOSITE_ACTION compositeAction)throws Exception {
		PM_IL_SA_INST_PYMT1 pm_il_sa_inst_pymt1_bean = compositeAction
				.getPM_IL_SA_INST_PYMT1_ACTION_BEAN()
				.getPM_IL_SA_INST_PYMT1_BEAN();
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
			pm_il_sa_inst_pymt1_bean.setSIP_PROD_CODE(pm_il_product_bean
					.getPROD_CODE());
			pm_il_sa_inst_pymt1_bean.setSIP_PLAN_CODE(pm_il_product_bean
					.getPROD_PLAN_CODE());
			L_VAL_PYMT_NUM_UNIQUE(compositeAction);
			pm_il_sa_inst_pymt1_bean.setSIP_CR_DT(new CommonUtils()
					.getCurrentDate());
			pm_il_sa_inst_pymt1_bean.setSIP_CR_UID(CommonUtils
					.getGlobalVariable("GLOBAL.USER_ID"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void PRE_UPDATE(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			PM_IL_SA_INST_PYMT1 pm_il_sa_inst_pymt1_bean = compositeAction
					.getPM_IL_SA_INST_PYMT1_ACTION_BEAN()
					.getPM_IL_SA_INST_PYMT1_BEAN();
			L_VAL_PYMT_NUM_UNIQUE(compositeAction);
			pm_il_sa_inst_pymt1_bean.setSIP_UPD_DT(new CommonUtils()
					.getCurrentDate());
			pm_il_sa_inst_pymt1_bean.setSIP_UPD_UID(CommonUtils
					.getGlobalVariable("GLOBAL.USER_ID"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void WHEN_VALIDATE_ITEM_SIP_NUMBER_PERIOD(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)throws Exception {
		PM_IL_SA_INST_PYMT1 pm_il_sa_inst_pymt1_bean = compositeAction
				.getPM_IL_SA_INST_PYMT1_ACTION_BEAN()
				.getPM_IL_SA_INST_PYMT1_BEAN();
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		Integer SIP_NUMR_PERIOD = (Integer) currValue;
		Integer PROD_PERIOD = pm_il_product_bean.getPROD_PERIOD();
		try {
			L_VAL_PYMT_NUM_UNIQUE(compositeAction);
			if (SIP_NUMR_PERIOD != null) {
				if (((CommonUtils.nvl(SIP_NUMR_PERIOD, 0)) < 0)
						|| ((CommonUtils.nvl(SIP_NUMR_PERIOD, 0)) >= (CommonUtils
								.nvl(PROD_PERIOD, 0)))) {
					throw new Exception(
							Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"91014",
											new Object[] {
													"Installment Period",
													"Greater than 0 and  Less than ",
													+PROD_PERIOD }));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void L_VAL_PYMT_NUM_UNIQUE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PM_IL_SA_INST_PYMT1 pm_il_sa_inst_pymt1_bean = compositeAction
				.getPM_IL_SA_INST_PYMT1_ACTION_BEAN()
				.getPM_IL_SA_INST_PYMT1_BEAN();
		Connection con = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		CRUDHandler handler = new CRUDHandler();
		String c1 = "SELECT ROWID FROM   PM_IL_SA_INST_PYMT WHERE  SIP_PROD_CODE   = ? AND "
				+ "SIP_PLAN_CODE   = ? AND  SIP_NUMR_PERIOD = ?";
		String c2 = " SELECT 'X'  FROM   PM_IL_SA_INST_PYMT WHERE  SIP_PROD_CODE  = ? AND "
				+ "SIP_PLAN_CODE  = ? AND SIP_NUMR_PERIOD = ? AND ROWID <> ? ";

		String M_DUMMY = null;
		try {
			con = CommonUtils.getConnection();
			Object[] c1values = { pm_il_sa_inst_pymt1_bean.getSIP_PROD_CODE(),
					pm_il_sa_inst_pymt1_bean.getSIP_PLAN_CODE(),
					pm_il_sa_inst_pymt1_bean.getSIP_NUMR_PERIOD() };
			rs1 = handler.executeSelectStatement(c1, con, c1values);
				if (rs1.next()) {
					M_DUMMY = rs1.getString(1);
					if (CommonUtils.isDuplicate(pm_il_sa_inst_pymt1_bean.getROWID(), M_DUMMY)) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91041",
								new Object[] { "Period" }));
					}
				}

			/*else {
				Object[] c2values = {
						pm_il_sa_inst_pymt1_bean.getSIP_PROD_CODE(),
						pm_il_sa_inst_pymt1_bean.getSIP_PLAN_CODE(),
						pm_il_sa_inst_pymt1_bean.getSIP_NUMR_PERIOD(),
						pm_il_sa_inst_pymt1_bean.getROWID() };
				rs2 = handler.executeSelectStatement(c2, con, c2values);
				while (rs2.next()) {
					M_DUMMY = rs2.getString(1);
				}
				if (M_DUMMY != null) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91041",
							new Object[] { "Period" }));
				}
			}*/
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
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

	public void executeQuery(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PM_IL_SA_INST_PYMT1_DELEGATE()
					.executeSelectStatement(compositeAction);
			List<PM_IL_SA_INST_PYMT1> dataList = compositeAction
					.getPM_IL_SA_INST_PYMT1_ACTION_BEAN()
					.getDataList_PM_IL_SA_INST_PYMT1();
			if (dataList != null && dataList.size() > 0) {
				PM_IL_SA_INST_PYMT1 PM_IL_SA_INST_PYMT1_BEAN = dataList.get(0);
				PM_IL_SA_INST_PYMT1_BEAN.setRowSelected(true);
				compositeAction.getPM_IL_SA_INST_PYMT1_ACTION_BEAN()
						.setPM_IL_SA_INST_PYMT1_BEAN(PM_IL_SA_INST_PYMT1_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}
