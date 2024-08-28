package com.iii.pel.forms.PILM015_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROP_TTYCOV_GRP_DELEGATE {
	
	public int delete(PM_IL_PROP_TTYCOV_GRP gridValueBean) throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(gridValueBean, connection);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return deletedRows;
	}

	public int update(
			PM_IL_PROP_TTYCOV_GRP pm_il_prop_ttycov_grp) throws Exception {
		ControlBean controlBean = new ControlBean();
		Connection connection = CommonUtils.getConnection();
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		try {
			rowUpdated = dbHandler.executeInsert(pm_il_prop_ttycov_grp,
					connection);
			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new Exception(exc.getMessage());
		}
		return rowUpdated;
	}
	public double preInsertValidation() throws Exception{
		CRUDHandler handler = new CRUDHandler();
		double sysId = 1D;
		ResultSet resultSet = null;
		String query = "SELECT PIL_MEH_SYS_ID.NEXTVAL FROM  DUAL  ";
		try {
			Connection connection = CommonUtils.getConnection();
			Object[] objects = {};
			resultSet = handler.executeSelectStatement(query, connection,
					objects);
			if (resultSet.next()) {
				sysId = resultSet.getDouble(1);
				System.out.println("Sys Id: " + sysId);
			}
			if (resultSet.isAfterLast() || resultSet.isBeforeFirst()) {
				System.out.println("Cannot Generate System id");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
		return sysId;
	}
	
	public String getCoverCodeDesc(String coverCode, List ttyCovGroupList) {
		Iterator iterator = ttyCovGroupList.iterator();
		String codedesc = null;
		while (iterator.hasNext()) {
			PM_IL_PROP_TTYCOV_GRP pm_il_prop_ttycov_grp = (PM_IL_PROP_TTYCOV_GRP) iterator
					.next();
			if (coverCode.equalsIgnoreCase(pm_il_prop_ttycov_grp
					.getPTG_COVER_CODE())) {
				codedesc = pm_il_prop_ttycov_grp.getUI_M_PTG_COVER_CODE_DESC();
			}
		}
		return codedesc;
	}
	
}
