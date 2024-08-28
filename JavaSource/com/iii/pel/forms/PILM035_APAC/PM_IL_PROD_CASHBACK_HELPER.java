package com.iii.pel.forms.PILM035_APAC;

import java.util.List;

import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_CASHBACK_HELPER {
	
	public void executeQuery(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PM_IL_PROD_CASHBACK_DELEGATE()
					.executeSelectStatement(compositeAction);
			List<PM_IL_PROD_CASHBACK> dataList = compositeAction.getPM_IL_PROD_CASHBACK_ACTION_BEAN().getDataList_PM_IL_PROD_CASHBACK();
			if (dataList != null && dataList.size() > 0) {
				PM_IL_PROD_CASHBACK PM_IL_PROD_CASHBACK_BEAN = dataList
						.get(0);
				PM_IL_PROD_CASHBACK_BEAN.setRowSelected(true);
				compositeAction.getPM_IL_PROD_CASHBACK_ACTION_BEAN()
						.setPM_IL_PROD_CASHBACK_BEAN(
								PM_IL_PROD_CASHBACK_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	public void PRE_INSERT(PILM035_APAC_COMPOSITE_ACTION compositeAction)throws Exception {
		PM_IL_PROD_CASHBACK PM_IL_PROD_CASHBACK_BEAN = compositeAction.getPM_IL_PROD_CASHBACK_ACTION_BEAN().getPM_IL_PROD_CASHBACK_BEAN();
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
			PM_IL_PROD_CASHBACK_BEAN.setPCB_PROD_CODE(pm_il_product_bean
					.getPROD_CODE());
			PM_IL_PROD_CASHBACK_BEAN.setPCB_CR_DT(new CommonUtils()
					.getCurrentDate());
			PM_IL_PROD_CASHBACK_BEAN.setPCB_UPD_UID(CommonUtils
					.getControlBean().getUSER_ID());
			//L_UNIQUE_MODETERM(compositeAction);

		} catch (Exception e) {
			e.printStackTrace();throw e;
		}
	}

	public void PRE_UPDATE(PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		PM_IL_PROD_CASHBACK PM_IL_PROD_CASHBACK_BEAN = compositeAction.getPM_IL_PROD_CASHBACK_ACTION_BEAN().getPM_IL_PROD_CASHBACK_BEAN();
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
			/*Newly added by pidugu raj dt: 22-10-2020 since product code not defaulted to PM_IL_PROD_CASHBACK during update*/
			PM_IL_PROD_CASHBACK_BEAN.setPCB_PROD_CODE(pm_il_product_bean
					.getPROD_CODE());
			/*Newly added by pidugu raj dt: 22-10-2020 since product code not defaulted to PM_IL_PROD_CASHBACK during update*/
			PM_IL_PROD_CASHBACK_BEAN.setPCB_UPD_DT(new CommonUtils()
					.getCurrentDate());
			PM_IL_PROD_CASHBACK_BEAN.setPCB_CR_DT(new CommonUtils()
			.getCurrentDate());
			PM_IL_PROD_CASHBACK_BEAN.setPCB_UPD_UID(CommonUtils
					.getControlBean().getM_USER_ID());
			PM_IL_PROD_CASHBACK_BEAN.setPCB_CR_UID("PREMIADMIN");
			 //L_UNIQUE_MODETERM(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}
	}

}
