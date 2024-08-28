package com.iii.pel.forms.PILM016_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_CONTRACTOR_SERACH_DELEGATE{
	
	public int deleteData(PM_IL_CONTRACTOR pm_il_contractor) throws Exception{
		CRUDHandler handler=new CRUDHandler();
		Connection connection = null;
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(pm_il_contractor, connection);
			connection.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return deletedRows;
	}
}
