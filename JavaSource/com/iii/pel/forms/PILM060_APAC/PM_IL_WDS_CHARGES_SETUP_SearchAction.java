package com.iii.pel.forms.PILM060_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_WDS_CHARGES_SETUP_SearchAction extends CommonAction {
	
	public String insertButtonAction() {
		PM_IL_WDS_CHARGES_SETUP_ACTION actionBean = new PM_IL_WDS_CHARGES_SETUP_ACTION();
		actionBean.getErrorMap().clear();
		actionBean.getWarningMap().clear();
		
		String outcome = null;
		CommonUtils.setGlobalObject("PILM060_APAC_PM_IL_WDS_CHARGES_SETUP_ACTION",
				actionBean);
		outcome = "PILM060_APAC_PM_IL_WDS_CHARGES_SETUP";
		CommonUtils.clearMaps(actionBean);
		return outcome;
	
	}

	public String updateButtonAction(String rowId){

		try{
			Connection connection = null;
			ResultSet resultSet = null;
			String productCode = null;
			String productCodeDesc = null;
			String query = "SELECT  PROD_CODE,PROD_DESC  FROM PM_IL_PRODUCT WHERE ROWID = ? ";	
			PM_IL_WDS_CHARGES_SETUP_ACTION actionBean = new PM_IL_WDS_CHARGES_SETUP_ACTION();
			CommonUtils.setGlobalObject(
					"PILM060_APAC_PM_IL_WDS_CHARGES_SETUP_ACTION", actionBean);
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query, connection,new Object[]{rowId});
			if(resultSet.next()){
				productCode = resultSet.getString(1);
				productCodeDesc = resultSet.getString(2);
			}
			actionBean.getPM_IL_WDS_CHARGES_SETUP_BEAN().setUI_M_PROD_CODE(productCode);
			actionBean.getPM_IL_WDS_CHARGES_SETUP_BEAN().setUI_M_PROD_CODE_DESC(productCodeDesc);
			fetchMasterRecord(actionBean, productCode,productCodeDesc);
			
			/*Added  by Janani on 14.07.2017 for ZBILQC-1724475*/
			
			System.out.println("getWCS_SETUP_TYPE in updateButtonAction                   "+actionBean.
					getPM_IL_WDS_CHARGES_SETUP_BEAN().getWCS_SETUP_TYPE());
			
			if(actionBean.getPM_IL_WDS_CHARGES_SETUP_BEAN().getWCS_SETUP_TYPE().equalsIgnoreCase("S"))
			{
				actionBean.getCOMP_WCS_YRS_FM_LABEL().setValue("Term from");
				actionBean.getCOMP_WCS_YRS_TO_LABEL().setValue("Term To");
				
			}
			else if(actionBean.getPM_IL_WDS_CHARGES_SETUP_BEAN().getWCS_SETUP_TYPE().equalsIgnoreCase("W"))
			{
				System.out.println("getWCS_SETUP_TYPE is W");
				
				actionBean.getCOMP_WCS_YRS_FM_LABEL().setValue("Premium Paying years from");
				actionBean.getCOMP_WCS_YRS_TO_LABEL().setValue("Premium Paying years to");
			}

			/*End*/
			
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return "PILM060_APAC_PM_IL_WDS_CHARGES_SETUP";
	}
	
	public void fetchMasterRecord(PM_IL_WDS_CHARGES_SETUP_ACTION actionBean,String productCode,String productCodeDesc) throws Exception{
		try{
		String selectQuery = "SELECT ROWID, PM_IL_WDS_CHARGES_SETUP.* FROM  PM_IL_WDS_CHARGES_SETUP WHERE WCS_PROD_CODE='"+ productCode +"'";
		
		List<PM_IL_WDS_CHARGES_SETUP> list = new CRUDHandler().fetch(selectQuery, "com.iii.pel.forms.PILM060_APAC.PM_IL_WDS_CHARGES_SETUP", CommonUtils.getConnection());
		
			actionBean.setGridValueList(list);
			PM_IL_WDS_CHARGES_SETUP pm_il_wds_charges_setup_bean = null;
			Iterator<PM_IL_WDS_CHARGES_SETUP> iterator = actionBean.getGridValueList().iterator();
			if(list.size()>0){
				pm_il_wds_charges_setup_bean = actionBean.getGridValueList().get(0);
				pm_il_wds_charges_setup_bean.setUI_M_PROD_CODE(productCode);
				pm_il_wds_charges_setup_bean.setUI_M_PROD_CODE_DESC(productCodeDesc);
				actionBean.setPM_IL_WDS_CHARGES_SETUP_BEAN(pm_il_wds_charges_setup_bean);
				actionBean.postQuery(pm_il_wds_charges_setup_bean);
				pm_il_wds_charges_setup_bean.setRowSelected(true);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	 public StringBuffer customizeQuery(StringBuffer query, ArrayList<Object> valueList){
	    	int whereIndex = query.indexOf("WHERE")+6;
	    	query.insert(whereIndex, " PLAN_TYPE = ? AND ");
	    	valueList.add("U");
	    	
	    	return query;
	    }
	
	
	
}
