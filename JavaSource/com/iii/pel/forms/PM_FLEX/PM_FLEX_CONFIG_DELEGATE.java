package com.iii.pel.forms.PM_FLEX;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_FLEX_CONFIG_DELEGATE {

	public void executeSelectStatement (PM_FLEX_CONFIG_ACTION compositeAction) throws Exception { 
		String selectStatement="SELECT ROWID, IM_PROG_FIELD_DEFN.* FROM IM_PROG_FIELD_DEFN WHERE ROWID = ?";
		Connection connection=null;
		ResultSet resultSet=null;
		try {
			connection=CommonUtils.getConnection();
			resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection, 
					new Object[]{compositeAction.getPM_FLEX_CONFIG_BEAN().getROWID()});
			PM_FLEX_CONFIG PM_FLEX_CONFIG_BEAN = new PM_FLEX_CONFIG();
			while (resultSet.next()) {
				PM_FLEX_CONFIG_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_FLEX_CONFIG_BEAN.setIFD_PROG_CODE(resultSet.getString("PFD_PROG_CODE"));
				PM_FLEX_CONFIG_BEAN.setIFD_PB_BLK_NAME(resultSet.getString("PFD_PB_BLK_NAME"));
			}
			compositeAction.setPM_FLEX_CONFIG_BEAN(PM_FLEX_CONFIG_BEAN);
		} 
		finally { 
			CommonUtils.closeCursor(resultSet);
		} 
	} 
	
	
	public void fetchDeatils(PM_FLEX_CONFIG_ACTION action) throws Exception{
		String selectStatement = " SELECT ROWID,IM_PROG_FIELD_DEFN.* FROM  IM_PROG_FIELD_DEFN WHERE PFD_PROG_CODE= ? " +
				 				" AND PFD_PB_BLK_NAME = ? AND PFD_FLD_NAME LIKE '%FLEX%' " ;
		Connection connection = null;
		ResultSet resultSet = null;
		action.getDataList_PM_FLEX_CONFIG().clear();
		try{
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(selectStatement, connection, 
					new Object[]{action.getPM_FLEX_CONFIG_BEAN().getUI_IFD_PROG_CODE(),
								 action.getPM_FLEX_CONFIG_BEAN().getUI_IFD_PB_BLK_NAME()});
			PM_FLEX_CONFIG PM_FLEX_CONFIG_BEAN = null;
			while(resultSet.next()){
				PM_FLEX_CONFIG_BEAN = new PM_FLEX_CONFIG();
				PM_FLEX_CONFIG_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_FLEX_CONFIG_BEAN.setIFD_DATA_TYPE(resultSet.getString("PFD_DATA_TYPE"));
				PM_FLEX_CONFIG_BEAN.setIFD_DFLT_VALUE(resultSet.getString("PFD_DFLT_VALUE"));
				PM_FLEX_CONFIG_BEAN.setIFD_FLD_LEN(resultSet.getInt("PFD_FLD_LEN"));
				PM_FLEX_CONFIG_BEAN.setIFD_HIDE_YN_NUM(resultSet.getInt("PFD_HIDE_YN_NUM"));
				PM_FLEX_CONFIG_BEAN.setIFD_MANDATORY_YN_NUM(resultSet.getInt("PFD_MANDATORY_YN_NUM"));
				PM_FLEX_CONFIG_BEAN.setIFD_PB_BLK_NAME(resultSet.getString("PFD_PB_BLK_NAME"));
				PM_FLEX_CONFIG_BEAN.setUI_IFD_PB_BLK_NAME(resultSet.getString("PFD_PB_BLK_NAME"));
				PM_FLEX_CONFIG_BEAN.setIFD_PBF_FLD_NAME(resultSet.getString("PFD_FLD_NAME"));
				PM_FLEX_CONFIG_BEAN.setIFD_PROG_CODE(resultSet.getString("PFD_PROG_CODE"));
				PM_FLEX_CONFIG_BEAN.setUI_IFD_PROG_CODE(resultSet.getString("PFD_PROG_CODE"));
				PM_FLEX_CONFIG_BEAN.setIFD_PROMPT(resultSet.getString("PFD_PROMPT"));
				PM_FLEX_CONFIG_BEAN.setPFD_ENTERABLE_YN_NUM(resultSet.getInt("PFD_ENTERABLE_YN_NUM"));
				PM_FLEX_CONFIG_BEAN.setPFD_UPDATEABLE_YN_NUM(resultSet.getInt("PFD_UPDATEABLE_YN_NUM"));
				//PM_FLEX_CONFIG_BEAN.setIFD_HIDE_YN_NUM(resultSet.getInt("PFD_HIDE_YN_NUM"));
				action.getDataList_PM_FLEX_CONFIG().add(PM_FLEX_CONFIG_BEAN);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
	}
}
