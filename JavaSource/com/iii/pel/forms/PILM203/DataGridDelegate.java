package com.iii.pel.forms.PILM203;

import java.sql.Connection;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class DataGridDelegate {
	
	
	public Connection getConnection() throws Exception{
		return CommonUtils.getConnection();
	}
	
	public int updateData(Object dataGridBean) throws Exception
	{
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		
		try {
			connection = getConnection();
			rowUpdated = dbHandler.executeInsert(dataGridBean, connection);
			//connection.commit();
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}

	public String saveData() {
		try {
			getConnection().commit();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return "";
	}
	
	
	
	public int deleteData(Object gridValueBean)
	{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = getConnection();
			deletedRows = handler.executeDelete(gridValueBean, connection);
//			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}
	
}
