package com.iii.pel.forms.PILM107;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;


public class PM_BANK_BRANCH_HELPER {

  
	public void executeQuery(PILM107_COMPOSITE_ACTION compositeAction) throws Exception {
		new PM_BANK_BRANCH_DELEGATE().executeSelectStatement(compositeAction);

 	 List<PM_BANK_BRANCH> dataList = compositeAction.
	getPM_BANK_BRANCH_ACTION_BEAN().getDataList_PM_BANK_BRANCH();
	 if(dataList!=null && dataList.size() > 0){
		PM_BANK_BRANCH PM_BANK_BRANCH_BEAN = dataList.get(0);
		PM_BANK_BRANCH_BEAN.setRowSelected(true);
				compositeAction.getPM_BANK_BRANCH_ACTION_BEAN()
		.setPM_BANK_BRANCH_BEAN(PM_BANK_BRANCH_BEAN);
		compositeAction.getPM_BANK_BRANCH_ACTION_BEAN().resetAllComponent();		
				
	}else{
		PM_BANK_BRANCH PM_BANK_BRANCH_BEAN = new PM_BANK_BRANCH(); 
		compositeAction.getPM_BANK_BRANCH_ACTION_BEAN()
		.setPM_BANK_BRANCH_BEAN(PM_BANK_BRANCH_BEAN);
	}
	}
	

	
	/*public void preInsert(PM_BANK_BRANCH divisionBean,PM_CUSTOMER customerBean) throws Exception{
		
		
		try {
			divisionBean.setCDIV_CUST_CODE(customerBean.getCUST_CODE());			
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}
	
	public void preUpdate(PM_BANK_BRANCH divisionBean) throws Exception{
		try {
			divisionBean.setCDIV_UPD_DT(new CommonUtils().getCurrentDate());
			divisionBean.setCDIV_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
*/
}
