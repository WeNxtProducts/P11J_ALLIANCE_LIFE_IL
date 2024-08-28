package com.iii.pel.forms.PILM035_APAC;
import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_APPL_CVR_GRP_DELEGATE { 

public void executeSelectStatement (PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception { 
	  String selectStatement="SELECT ROWID, PM_IL_PROD_APPL_CVR_GRP.* FROM PM_IL_PROD_APPL_CVR_GRP WHERE PACG_PROD_CODE = ? ";
	  
	  
	  Connection connection=null;
	  ResultSet resultSet=null;
	
	  compositeAction.getPM_IL_PROD_APPL_CVR_GRP_ACTION_BEAN().getDataList_PM_IL_PROD_APPL_CVR_GRP().clear();
		 try {
			 connection=CommonUtils.getConnection();
			
			 resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection,
					 new Object[]{compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_CODE()});
			 while (resultSet.next()) {
				 PM_IL_PROD_APPL_CVR_GRP PM_IL_PROD_APPL_CVR_GRP_BEAN = new PM_IL_PROD_APPL_CVR_GRP();
				 PM_IL_PROD_APPL_CVR_GRP_BEAN.setROWID(resultSet.getString("ROWID"));
				 PM_IL_PROD_APPL_CVR_GRP_BEAN.setPACG_PROD_CODE(resultSet.getString("PACG_PROD_CODE"));
				 PM_IL_PROD_APPL_CVR_GRP_BEAN.setPACG_CVR_GROUP_CODE(resultSet.getString("PACG_CVR_GROUP_CODE"));
				 PM_IL_PROD_APPL_CVR_GRP_BEAN.setPACG_MANDATORY_YN(resultSet.getString("PACG_MANDATORY_YN"));
				 PM_IL_PROD_APPL_CVR_GRP_BEAN.setPACG_DEFAULT_YN(resultSet.getString("PACG_DEFAULT_YN"));
				 PM_IL_PROD_APPL_CVR_GRP_BEAN.setPACG_FRZ_FLAG(resultSet.getString("PACG_FRZ_FLAG"));
				 PM_IL_PROD_APPL_CVR_GRP_BEAN.setPACG_CR_DT(resultSet.getDate("PACG_CR_DT"));
				 PM_IL_PROD_APPL_CVR_GRP_BEAN.setPACG_CR_UID(resultSet.getString("PACG_CR_UID"));
				 PM_IL_PROD_APPL_CVR_GRP_BEAN.setPACG_UPD_DT(resultSet.getDate("PACG_UPD_DT"));
				 PM_IL_PROD_APPL_CVR_GRP_BEAN.setPACG_UPD_UID(resultSet.getString("PACG_UPD_UID"));
		
				 compositeAction.getPM_IL_PROD_APPL_CVR_GRP_ACTION_BEAN().getDataList_PM_IL_PROD_APPL_CVR_GRP().add(PM_IL_PROD_APPL_CVR_GRP_BEAN);
			 }
		 } 
		 finally { 
			 CommonUtils.closeCursor(resultSet);
		 } 
} 
	 
	 
	 


}
