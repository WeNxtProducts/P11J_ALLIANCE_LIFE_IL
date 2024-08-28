package com.iii.pel.forms.PILM030;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_HTWT_DTL_DELEGATE {

	CommonUtils commonutils = null;

	public PM_IL_HTWT_DTL_DELEGATE() {
		commonutils = new CommonUtils();
	}

	public List getValues() {
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		List list = null;

		try {
			list = new ArrayList();
			connection = commonutils.getConnection();

			String query = "select HTWT_HEIGHT_FM,HTWT_HEIGHT_TO,HTWT_WEIGHT_FM,HTWT_WEIGHT_TO,HTWT_EFF_FM_DT,HTWT_EFF_TO_DT,HTWT_SYS_ID,"
					+ "ROWID AS COLUMNROWID " + "from PM_IL_HTWT_DTL ";
			list = dbHandler.fetch(query,
					"com.iii.pel.forms.PILM030.PM_IL_HTWT_DTL", connection);
			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return list;
	}

	public int updateData(PM_IL_HTWT_DTL pm_il_htwt_dtl) throws Exception {
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;

		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(pm_il_htwt_dtl, connection);
//			connection.commit();
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}

	public int deleteData(PM_IL_HTWT_DTL pm_il_htwt_dtl) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(pm_il_htwt_dtl, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}

	public double preInsertValidation() throws Exception {

		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		double sysId = 1.0;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			String query = "SELECT PIL_HTWT_SYS_ID.NEXTVAL SYS_ID FROM  DUAL ";
			//Object[] objects = {};
			// L_VALIDATE_RANGE.L_VALIDATE_RANGE();
			resultSet = handler.executeSelectStatement(query,connection);
			if (resultSet.next()) {
				sysId = resultSet.getInt(1);
				System.out.println("Sys Id: " + sysId);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			new CommonUtils().closeCursor(resultSet);
//			resultSet.close();
		}
		return sysId;
	}

	
}
