package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_SA_INST_PYMT2_HELPER {

	public void executeQuery(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PM_IL_SA_INST_PYMT2_DELEGATE()
					.executeSelectStatement(compositeAction);
			List<PM_IL_SA_INST_PYMT2> dataList = compositeAction
					.getPM_IL_SA_INST_PYMT2_ACTION_BEAN()
					.getDataList_PM_IL_SA_INST_PYMT2();
			if (dataList != null && dataList.size() > 0) {
				PM_IL_SA_INST_PYMT2 PM_IL_SA_INST_PYMT2_BEAN = dataList.get(0);
				PM_IL_SA_INST_PYMT2_BEAN.setRowSelected(true);
				compositeAction.getPM_IL_SA_INST_PYMT2_ACTION_BEAN()
						.setPM_IL_SA_INST_PYMT2_BEAN(PM_IL_SA_INST_PYMT2_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}
	}

	public void PRE_INSERT(PILM035_APAC_COMPOSITE_ACTION compositeAction)throws Exception {
		PM_IL_SA_INST_PYMT2 pm_il_sa_inst_pymt2_bean = compositeAction
				.getPM_IL_SA_INST_PYMT2_ACTION_BEAN()
				.getPM_IL_SA_INST_PYMT2_BEAN();
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
			pm_il_sa_inst_pymt2_bean.setSIP_PLAN_CODE(pm_il_product_bean
					.getPROD_PLAN_CODE());
			pm_il_sa_inst_pymt2_bean.setSIP_PROD_CODE(pm_il_product_bean
					.getPROD_CODE());
			L_VAL_PYMT_NUM_UNIQUE1(compositeAction);
			pm_il_sa_inst_pymt2_bean.setSIP_CR_DT(new CommonUtils()
					.getCurrentDate());
			pm_il_sa_inst_pymt2_bean.setSIP_CR_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}

	}

	public void PRE_UPDATE(PILM035_APAC_COMPOSITE_ACTION compositeAction)throws Exception {
		PM_IL_SA_INST_PYMT2 pm_il_sa_inst_pymt2_bean = compositeAction
				.getPM_IL_SA_INST_PYMT2_ACTION_BEAN()
				.getPM_IL_SA_INST_PYMT2_BEAN();
		try {
			L_VAL_PYMT_NUM_UNIQUE1(compositeAction);
			pm_il_sa_inst_pymt2_bean.setSIP_UPD_DT(new CommonUtils()
					.getCurrentDate());
			pm_il_sa_inst_pymt2_bean.setSIP_UPD_UID(CommonUtils
					.getControlBean().getM_USER_ID());
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}

	}

	public void L_VAL_PYMT_NUM_UNIQUE1(
			PILM035_APAC_COMPOSITE_ACTION compositeAction)throws Exception {

		PM_IL_SA_INST_PYMT2 pm_il_sa_inst_pymt2_bean = compositeAction
				.getPM_IL_SA_INST_PYMT2_ACTION_BEAN()
				.getPM_IL_SA_INST_PYMT2_BEAN();
		String C1 = "SELECT ROWID  FROM   PM_IL_SA_INST_PYMT "
				+ "WHERE  SIP_PROD_CODE   = ? " + "AND		 SIP_PLAN_CODE   = ? "
				+ "AND    SIP_NUMR_PERIOD = ?";
		String C2 = "SELECT 'X' " + "FROM   PM_IL_SA_INST_PYMT "
				+ "WHERE  SIP_PROD_CODE  = ? " + "AND		 SIP_PLAN_CODE  = ? "
				+ "AND    SIP_NUMR_PERIOD = ? " + "AND    ROWID          <> ?";
		Connection con = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		CRUDHandler hander = new CRUDHandler();
		Object[] c1values = null;
		Object[] c2values = null;

		String M_DUMMY = null;
		try {
			con = CommonUtils.getConnection();
				c1values = new Object[] {
						pm_il_sa_inst_pymt2_bean.getSIP_PROD_CODE(),
						pm_il_sa_inst_pymt2_bean.getSIP_PLAN_CODE(),
						pm_il_sa_inst_pymt2_bean.getSIP_NUMR_PERIOD() };
				rs1 = hander.executeSelectStatement(C1, con, c1values);
				if (rs1.next()) {
					M_DUMMY = rs1.getString(1);
					if (CommonUtils.isDuplicate(pm_il_sa_inst_pymt2_bean.getROWID(), M_DUMMY)) {
						throw new ValidatorException(Messages.getMessage(
								PELConstants.pelErrorMessagePath, "91041",new Object[]{"Period"}));
					}
				}
				/* //} else {
				c2values = new Object[] {
						pm_il_sa_inst_pymt2_bean.getSIP_PROD_CODE(),
						pm_il_sa_inst_pymt2_bean.getSIP_PLAN_CODE(),
						pm_il_sa_inst_pymt2_bean.getSIP_NUMR_PERIOD(),
						pm_il_sa_inst_pymt2_bean.getROWID() };
				rs2 = hander.executeSelectStatement(C2, con, c2values);
				while (rs2.next()) {
					M_DUMMY = rs2.getString(2);
				}
				if (M_DUMMY != null) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91041",new Object[]{"Period"}));
				}
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			CommonUtils.closeCursor(rs1);
		}
	}

	public void WHEN_VALIDATE_ITEM_SIP_NUMR_PERIOD(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		PM_IL_SA_INST_PYMT2 pm_il_sa_inst_pymt2_bean = compositeAction
				.getPM_IL_SA_INST_PYMT2_ACTION_BEAN()
				.getPM_IL_SA_INST_PYMT2_BEAN();
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
			L_VAL_PYMT_NUM_UNIQUE1(compositeAction);
			if (pm_il_sa_inst_pymt2_bean.getSIP_NUMR_PERIOD() != null) {
				if (((CommonUtils.nvl(pm_il_sa_inst_pymt2_bean
						.getSIP_NUMR_PERIOD(), 0)) < 0)
						|| ((CommonUtils.nvl(pm_il_sa_inst_pymt2_bean
								.getSIP_NUMR_PERIOD(), 0)) >= (CommonUtils.nvl(
								pm_il_product_bean.getPROD_PERIOD(), 0)))) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91014",
							new Object[]{"Installment Period","Greater than 0 " +
									"and Less than ",pm_il_product_bean.getPROD_PERIOD()}));
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
