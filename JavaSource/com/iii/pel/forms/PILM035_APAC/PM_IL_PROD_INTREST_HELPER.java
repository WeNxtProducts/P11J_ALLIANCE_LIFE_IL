package com.iii.pel.forms.PILM035_APAC;

import java.util.List;

import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_INTREST_HELPER {
	
	public void  WHEN_CREATE_RECORD(PILM035_APAC_COMPOSITE_ACTION compositeAction){
		
		
	}
	public void  preInsert(PM_IL_PROD_INTREST PM_IL_PROD_INTREST_BEAN,PILM035_APAC_COMPOSITE_ACTION compositeAction){
		PM_IL_PRODUCT PM_IL_PRODUCT_BEAN=compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try{
		PM_IL_PROD_INTREST_BEAN.setPRI_PROD_CODE(PM_IL_PRODUCT_BEAN.getPROD_CODE());
		PM_IL_PROD_INTREST_BEAN.setPRI_CR_DT(new CommonUtils().getCurrentDate());
		PM_IL_PROD_INTREST_BEAN.setPRI_CR_UID(CommonUtils.getControlBean().getUSER_ID());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void  preUpdate(PM_IL_PROD_INTREST PM_IL_PROD_INTREST_BEAN,PILM035_APAC_COMPOSITE_ACTION compositeAction){
		PM_IL_PRODUCT PM_IL_PRODUCT_BEAN=compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
		PM_IL_PROD_INTREST_BEAN.setPRI_UPD_DT(new CommonUtils().getCurrentDate());
		PM_IL_PROD_INTREST_BEAN.setPRI_UPD_UID(CommonUtils.getControlBean().getUSER_ID());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void executeQuery(PILM035_APAC_COMPOSITE_ACTION compositeAction){
		try {
			new PM_IL_PROD_INTREST_DELEGATE().executeSelectStatement(compositeAction);
			
			
			List<PM_IL_PROD_INTREST> dataList = compositeAction
					.getPM_IL_PROD_INTREST_ACTION_BEAN()
					.getDataList_PM_IL_PROD_INTREST();
			if (dataList != null && dataList.size() > 0) {
				PM_IL_PROD_INTREST PM_IL_PROD_INTREST_BEAN = dataList
						.get(0);
				PM_IL_PROD_INTREST_BEAN.setRowSelected(true);
				compositeAction.getPM_IL_PROD_INTREST_ACTION_BEAN()
						.setPM_IL_PROD_INTREST_BEAN(
								PM_IL_PROD_INTREST_BEAN);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
