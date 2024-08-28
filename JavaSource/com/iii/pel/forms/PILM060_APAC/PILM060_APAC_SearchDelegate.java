package com.iii.pel.forms.PILM060_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PILM060_APAC_SearchDelegate {
	
/*	public ArrayList<PM_IL_WDS_CHARGES_SETUP> fetchMasterBlock(PM_IL_WDS_CHARGES_SETUP_SearchAction searchAction) {
		
		 * Modified The Query For The Search Page As Per The New Requirement In Call PREMIA-GDC-1138676 
		 * 
		 * Old Query Is Commented
		 
		ArrayList<PM_IL_WDS_CHARGES_SETUP> masterList = new ArrayList<PM_IL_WDS_CHARGES_SETUP>();
		PM_IL_WDS_CHARGES_SETUP searchBean = searchAction.getSearchBean();
		String PCode = searchBean.getUI_M_PROD_CODE();
		String query = null;
		ResultSet rs = null;
		
		if ((PCode == null || PCode.equals(""))) {
			query = "SELECT  PROD_CODE,PROD_DESC FROM PM_IL_PRODUCT,PM_IL_PLAN WHERE PROD_PLAN_CODE = PLAN_CODE AND PLAN_TYPE = 'U'";
		} else if ((PCode != null || !PCode.equals(""))) {
			query = "SELECT  PROD_CODE,PROD_DESC FROM PM_IL_PRODUCT,PM_IL_PLAN WHERE PROD_CODE LIKE "
					+ PCode+ "%'" + " AND PROD_PLAN_CODE = PLAN_CODE AND PLAN_TYPE = 'U'";
		}
		
		try {
			rs = getHandler().executeSelectStatement(query, CommonUtils.getConnection());
			while (rs.next()) {
				PM_IL_WDS_CHARGES_SETUP searchBean1 = new PM_IL_WDS_CHARGES_SETUP();
				searchBean1.setWCS_PROD_CODE(rs.getString("PROD_CODE"));
				searchBean1.setUI_M_PROD_CODE_DESC(rs.getString("PROD_DESC"));
				masterList.add(searchBean1);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return masterList;
	}*/
	
	
	public int deleteData(PM_IL_WDS_CHARGES_SETUP gridValueBean)
	{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = getConnection();
			deletedRows = handler.executeDelete(gridValueBean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}
	

	public Connection getConnection() {
		Connection con = null;
		try{
	 con =CommonUtils.getConnection();
		}catch (Exception e) {
			e.printStackTrace();
		}
	return con;
		
	}

	public CRUDHandler getHandler() {
		return new CRUDHandler();
	}

}
