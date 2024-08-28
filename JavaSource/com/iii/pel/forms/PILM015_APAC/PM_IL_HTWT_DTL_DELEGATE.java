package com.iii.pel.forms.PILM015_APAC;

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

	public List<PM_IL_HTWT_DTL> prepareHeightWeightDetails(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception {
		List<PM_IL_HTWT_DTL> medList = new ArrayList<PM_IL_HTWT_DTL>();
		ResultSet resultSet = null;
		CommonUtils commonUtils = new CommonUtils();
		try {
			Connection connection = CommonUtils.getConnection();
			String selectQuery = PM_IL_HTWT_DTL_CONSTANTS.FETCH_HTWT_RECORDS;
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(selectQuery, connection, new Object[]{compositeAction.getPM_IL_PROP_TREATY_ACTION().getPM_IL_PROP_TREATY_BEAN().getPT_SYS_ID()});
			while (resultSet.next()) {
				PM_IL_HTWT_DTL bean = new PM_IL_HTWT_DTL();
				bean.setROWID(resultSet.getString(1));
				bean.setHTWT_SYS_ID(resultSet.getDouble(2));
				bean.setHTWT_PT_SYS_ID(resultSet.getDouble(3));
				bean.setHTWT_HEIGHT_FM(resultSet.getDouble(4));
				bean.setHTWT_HEIGHT_TO(resultSet.getDouble(5));
				bean.setHTWT_WEIGHT_FM(resultSet.getDouble(6));
				bean.setHTWT_WEIGHT_TO(resultSet.getDouble(7));
				bean.setHTWT_CR_DT(resultSet.getDate(8));
				bean.setHTWT_CR_UID(resultSet.getString(9));
				bean.setHTWT_UPD_DT(resultSet.getDate(10));
				bean.setHTWT_UPD_UID(resultSet.getString(11));
				bean.setHTWT_EFF_FM_DT(resultSet.getDate(12));
				bean.setHTWT_EFF_TO_DT(resultSet.getDate(13));
				medList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return medList;
	}

	public int updateData(PM_IL_HTWT_DTL pm_il_htwt_dtl) throws Exception {
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(pm_il_htwt_dtl, connection);
			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new Exception(exc.getMessage());
		}
		return rowUpdated;
	}

	public int deleteData(PM_IL_HTWT_DTL pm_il_htwt_dtl) throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(pm_il_htwt_dtl, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return deletedRows;
	}

	public double preInsertValidation() throws Exception {
		CommonUtils commonUtils = new CommonUtils();
		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		double sysId = 1.0;
		ResultSet resultSet = null;
		try {
			String query = "SELECT PIL_HTWT_SYS_ID.NEXTVAL SYS_ID FROM  DUAL ";
			Object[] objects = {};
			resultSet = handler.executeSelectStatement(query, connection,
					objects);
			if (resultSet.next()) {
				sysId = resultSet.getInt(1);
			}
			if (resultSet.isAfterLast() || resultSet.isBeforeFirst()) {
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sysId;
	}

}
