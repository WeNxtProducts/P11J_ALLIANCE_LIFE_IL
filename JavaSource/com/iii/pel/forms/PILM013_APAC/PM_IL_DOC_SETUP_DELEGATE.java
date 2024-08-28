package com.iii.pel.forms.PILM013_APAC;

import java.sql.Connection;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_SETUP_DELEGATE {

	public int  deleteData(PM_IL_DOC_SETUP pm_il_doc_setup)
	{
			Connection connection = null;
			CRUDHandler handler = null;
			int deletedRows = 0;
			try {
				handler = new CRUDHandler();
				connection = CommonUtils.getConnection();
				deletedRows = handler.executeDelete(pm_il_doc_setup, connection);
				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return deletedRows;
		
	}
	
}
