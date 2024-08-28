package com.iii.pel.forms.PILM060_APAC;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_WDS_CHARGES_SETUP_DataGridDelegate {
	
	public List fetchValues(String prodCode){
		String code = prodCode;
		Connection con = null;
		CRUDHandler dbHandler = new CRUDHandler();
		String fetchQuery = "select ROWID,PM_IL_WDS_CHARGES_SETUP.* from PM_IL_WDS_CHARGES_SETUP where WCS_PROD_CODE='"+code+"'";
		List list = null;
		try{
			list =new ArrayList();
			con = getConnection();
			System.out
					.println("PM_IL_WDS_CHARGES_SETUP_DataGridDelegate.fetchValues()--QUERY---["+fetchQuery+"]");
			list = dbHandler.fetch(fetchQuery, "com.iii.pel.forms.PILM060_APAC.PM_IL_WDS_CHARGES_SETUP", con);
			System.out
					.println("PM_IL_WDS_CHARGES_SETUP_DataGridDelegate.fetchValues()---["+list.size()+"]");
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public int updateData(PM_IL_WDS_CHARGES_SETUP dataGridBean) throws Exception
	{
		System.out
				.println("PM_IL_WDS_CHARGES_SETUP_DataGridDelegate.updateData()---------1------------");
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		
		try {
			connection = getConnection();
			//dataGridBean.setROWID(dataGridBean.getROWID()==null?"":dataGridBean.getROWID());
			System.out
					.println("PM_IL_WDS_CHARGES_SETUP_DataGridDelegate.updateData()---["+dataGridBean.getWCS_PROD_CODE()+"]");
			
			rowUpdated = dbHandler.executeInsert(dataGridBean, connection);
			System.out
			.println("PM_IL_WDS_CHARGES_SETUP_DataGridDelegate.updateData()---------2------------");
			connection.commit();
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}

	
	
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
	
	public String saveData(PM_IL_WDS_CHARGES_SETUP_ACTION gridActionBean)
	{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		List<PM_IL_WDS_CHARGES_SETUP> valueBeanList = new ArrayList<PM_IL_WDS_CHARGES_SETUP>();
		try {
			connection = getConnection();
			valueBeanList = gridActionBean.getGridValueList();
			for(int index = 0;index<valueBeanList.size(); index++)
			{
				PM_IL_WDS_CHARGES_SETUP gridValueBean = (PM_IL_WDS_CHARGES_SETUP)valueBeanList.get(index);
				System.out.println("prod---------------------->"+gridActionBean.getPM_IL_WDS_CHARGES_SETUP_BEAN().getUI_M_PROD_CODE());
				gridValueBean.setWCS_PROD_CODE(gridActionBean.getPM_IL_WDS_CHARGES_SETUP_BEAN().getUI_M_PROD_CODE());
				System.out.println("rowid------------------"+gridValueBean.getROWID());
				handler.executeInsert(gridValueBean, connection);
			}
			
			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return "";
	}
	
	
	public CRUDHandler getHandler(){
		return new CRUDHandler();
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

}
