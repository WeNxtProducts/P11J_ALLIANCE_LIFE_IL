package com.iii.pel.forms.PILM035_APAC;

import java.util.List;

import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_SA_INST_PYMT_HELPER {
	public void PRE_BLOCK(PILM035_APAC_COMPOSITE_ACTION compositeAction) {
	}

	public void WHEN_NEW_BLOCK_INSTANCE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) {
	}

	public void PRE_UPDATE(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			PM_IL_SA_INST_PYMT pm_il_sa_inst_pymt_bean = compositeAction
					.getPM_IL_SA_INST_PYMT_ACTION_BEAN()
					.getPM_IL_SA_INST_PYMT_BEAN();
			pm_il_sa_inst_pymt_bean.setSIP_UPD_DT(new CommonUtils()
					.getCurrentDate());
			pm_il_sa_inst_pymt_bean.setSIP_UPD_UID(CommonUtils.getControlBean()
					.getUSER_ID());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void PRE_INSERT(PILM035_APAC_COMPOSITE_ACTION compositeAction)
		throws Exception {
		try {
			PM_IL_SA_INST_PYMT pm_il_sa_inst_pymt_bean = compositeAction
					.getPM_IL_SA_INST_PYMT_ACTION_BEAN()
					.getPM_IL_SA_INST_PYMT_BEAN();
			PM_IL_PRODUCT pm_il_product_bean = compositeAction
					.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
			pm_il_sa_inst_pymt_bean.setSIP_PLAN_CODE(pm_il_product_bean
					.getPROD_PLAN_CODE());
			pm_il_sa_inst_pymt_bean.setSIP_PROD_CODE(pm_il_product_bean
					.getPROD_CODE());
			pm_il_sa_inst_pymt_bean.setSIP_CR_DT(new CommonUtils()
					.getCurrentDate());
			pm_il_sa_inst_pymt_bean.setSIP_CR_UID(CommonUtils.getControlBean()
					.getUSER_ID());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void executeQuery(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PM_IL_SA_INST_PYMT_DELEGATE()
					.executeSelectStatement(compositeAction);
			List<PM_IL_SA_INST_PYMT> dataList = compositeAction
					.getPM_IL_SA_INST_PYMT_ACTION_BEAN()
					.getDataList_PM_IL_SA_INST_PYMT();
			if (dataList != null && dataList.size() > 0) {
				PM_IL_SA_INST_PYMT PM_IL_SA_INST_PYMT_BEAN = dataList.get(0);
				PM_IL_SA_INST_PYMT_BEAN.setRowSelected(true);
				compositeAction.getPM_IL_SA_INST_PYMT_ACTION_BEAN()
						.setPM_IL_SA_INST_PYMT_BEAN(PM_IL_SA_INST_PYMT_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
