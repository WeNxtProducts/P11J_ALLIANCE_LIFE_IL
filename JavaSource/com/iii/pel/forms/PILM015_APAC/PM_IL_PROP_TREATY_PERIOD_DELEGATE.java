package com.iii.pel.forms.PILM015_APAC;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROP_TREATY_PERIOD_DELEGATE {

	public int deleteData(PM_IL_PROP_TREATY_PERIOD gridValueBean) throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(gridValueBean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return deletedRows;
	}

	public int update(PM_IL_PROP_TREATY_PERIOD pm_il_prop_treaty_period)
			throws Exception {
		ControlBean controlBean = new ControlBean();
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		try {
			Connection connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(pm_il_prop_treaty_period,
					connection);
			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new Exception(exc.getMessage());
		}
		return rowUpdated;
	}

	public List getValuesForHeader(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception {
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		String treatyCode = compositeAction.getPM_IL_PROP_TREATY_ACTION()
				.getPM_IL_PROP_TREATY_BEAN().getPT_TREATY_CODE();
		List list = null;
		try {
			list = new ArrayList();
			connection = CommonUtils.getConnection();
			String query = "select PM_IL_PROP_TREATY_PERIOD.*,"
					+ "ROWID AS COLUMNROWID from PM_IL_PROP_TREATY_PERIOD WHERE PPTP_PT_TREATY_CODE='"
					+ treatyCode + "'";
			list = dbHandler.fetch(query,
					"com.iii.pel.forms.PILM015_APAC.PM_IL_PROP_TREATY_PERIOD",
					connection);
			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new Exception(exc.getMessage());
		}
		return list;
	}

}
