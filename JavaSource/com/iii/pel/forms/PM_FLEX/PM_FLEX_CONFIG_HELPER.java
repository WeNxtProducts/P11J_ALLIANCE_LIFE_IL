package com.iii.pel.forms.PM_FLEX;

import java.util.List;

import com.iii.premia.common.utils.CommonUtils;


public class PM_FLEX_CONFIG_HELPER {

	public void executeQuery(PM_FLEX_CONFIG_ACTION compositeAction) throws Exception {
		new PM_FLEX_CONFIG_DELEGATE().executeSelectStatement(compositeAction);
	}
	
	public void fetchDeatilsCloumn(PM_FLEX_CONFIG_ACTION action) throws Exception{
		try{
			new PM_FLEX_CONFIG_DELEGATE().fetchDeatils(action);
			 List<PM_FLEX_CONFIG> dataList = action.getDataList_PM_FLEX_CONFIG();
				 if(dataList!=null && dataList.size() > 0){
					PM_FLEX_CONFIG PM_FLEX_CONFIG_BEAN = dataList.get(0);
					PM_FLEX_CONFIG_BEAN.setRowSelected(true);
							action.setPM_FLEX_CONFIG_BEAN(PM_FLEX_CONFIG_BEAN);
				}
			}catch (Exception e) {
				e.printStackTrace();
				throw e;
			} 
	}
	
	public void preUpdate(PM_FLEX_CONFIG PM_FLEX_CONFIG_BEAN) throws Exception{
		try{
			PM_FLEX_CONFIG_BEAN.setPFD_UPD_UID(CommonUtils.getControlBean().getUSER_ID());
			PM_FLEX_CONFIG_BEAN.setPFD_UPD_DT(new CommonUtils().getCurrentDate());
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
		
}
