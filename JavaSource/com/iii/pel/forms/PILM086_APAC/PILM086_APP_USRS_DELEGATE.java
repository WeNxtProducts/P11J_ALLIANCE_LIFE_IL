package com.iii.pel.forms.PILM086_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PILM086_APP_USRS_DELEGATE {
	public void executeSelectStatement(
			PILM086_APAC_COMPOSITE_ACTION PILM086_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		System.out.println("DELEGATE CLASS CALLED FOR APPLICABLE USER DELEGATE");
		
		String selectStatement = "SELECT ROWID,PM_BUS_RULE_APPL_USER.* FROM PM_BUS_RULE_APPL_USER WHERE BRAU_UG_ID = ?";
		System.out.println("QUERY"+selectStatement);
		Connection connection = null;
		ResultSet resultSet = null;
		
		PILM086_APP_USRS_BEAN V=new PILM086_APP_USRS_BEAN();
		System.out.println("Bean User Group"+PILM086_APAC_COMPOSITE_ACTION_BEAN.getPILM086_APP_USRS_ACTION_BEAN().getUSRS_BEAN().getBRAUG_UG_ID());
		String input=PILM086_APAC_COMPOSITE_ACTION_BEAN.getPILM086_APP_USRS_ACTION_BEAN().getUSRS_BEAN().getBRAUG_UG_ID();
		
		PILM086_APAC_COMPOSITE_ACTION_BEAN.getPILM086_APP_USRS_ACTION_BEAN().getDataList_PILM086_APP_USRS_ID_BEAN().clear();
		try {
			connection=CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(selectStatement, connection, new Object[]{input});
			while (resultSet.next()) {
				PILM086_APP_USRS_ID_BEAN VAL_BEAN = new PILM086_APP_USRS_ID_BEAN();
				VAL_BEAN.setROWID(resultSet.getString("ROWID"));
				VAL_BEAN.setBRAU_USER_ID(resultSet.getString("BRAU_USER_ID"));
				VAL_BEAN.setBRAU_USER_DESC(resultSet.getString("BRAU_USER_DESC"));
				PILM086_APAC_COMPOSITE_ACTION_BEAN.getPILM086_APP_USRS_ACTION_BEAN().getDataList_PILM086_APP_USRS_ID_BEAN().add(VAL_BEAN);					
			}
			System.out.println("size"+PILM086_APAC_COMPOSITE_ACTION_BEAN.getPILM086_APP_USRS_ACTION_BEAN().getDataList_PILM086_APP_USRS_ID_BEAN().size());
		} 
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
