package com.iii.pel.forms.PILM075_APAC;

import java.sql.Connection;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_END_SETUP_DET_DELEGATE1 {

	public int updateData(PM_IL_END_SETUP_DET1 pm_il_end_setup_det1) throws Exception
	{
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(pm_il_end_setup_det1, connection);
		} catch (Exception exc) {
			throw exc;
		} 
		return rowUpdated;
	}
	
	public int deleteData(PM_IL_END_SETUP_DET1 pm_il_end_setup_det1)
	{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(pm_il_end_setup_det1, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return deletedRows;
	}

}
