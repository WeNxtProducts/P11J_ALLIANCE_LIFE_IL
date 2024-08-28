package com.iii.pel.forms.PM094_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_AGENT_BONUS_RATES_DELEGATE {

	public int updateData(PM_AGENT_BONUS_RATES pm_agent_bonus_rates)
			throws Exception {

		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;

		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(pm_agent_bonus_rates,
					connection);
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}

	public int deleteData(PM_AGENT_BONUS_RATES gridValueBean) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(gridValueBean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}

	public List getCodeList(String code, List CodeList) {
		String query;
		if ("*".equalsIgnoreCase(code)) {
			query = " SELECT PC_CODE,PC_DESC " + " FROM PM_CODES "
					+ " WHERE  PC_TYPE='AGNRANK'" + " ORDER BY 1ASC";

			CodeList = codeLOV(query);
		} else {

			query = " SELECT PC_CODE,PC_DESC " + " FROM PM_CODES "
					+ " WHERE  PC_TYPE='AGNRANK'"
					+ " AND UPPER(PC_CODE) LIKE '" + code.toUpperCase() + "%'"
					+ " ORDER BY 1ASC ";

			CodeList = codeLOV(query);

		}

		return CodeList;
	}

	public String getCodeDesc(String Code, List codeList) {
		Iterator iterator = codeList.iterator();
		String codedesc = null;
		while (iterator.hasNext()) {
			PM_AGENT_BONUS_RATES pm_agent_bonus_rates = (PM_AGENT_BONUS_RATES) iterator
					.next();
			if (Code.equalsIgnoreCase(pm_agent_bonus_rates.getUI_M_ABR_RANK_CODE())) {
				codedesc = pm_agent_bonus_rates
						.getUI_M_ABR_RANK_CODE_DESC();
			}
		}
		return codedesc;
	}

	public List<PM_AGENT_BONUS_RATES> codeLOV(String query) {
		List<PM_AGENT_BONUS_RATES> codeList = new ArrayList<PM_AGENT_BONUS_RATES>();
		ResultSet resultSet = null;

		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection);
			while (resultSet.next()) {

				PM_AGENT_BONUS_RATES pm_agent_bonus_rates = new PM_AGENT_BONUS_RATES();
				pm_agent_bonus_rates.setUI_M_ABR_RANK_CODE(resultSet
						.getString(1));
				pm_agent_bonus_rates.setUI_M_ABR_RANK_CODE_DESC(resultSet
						.getString(2));
				codeList.add(pm_agent_bonus_rates);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return codeList;
	}
	
	public List<SelectItem> comboBoxValues(String formName, String blockname,
			String component, String componentId) {
		Connection connection = null;
		List<SelectItem> listItem = new java.util.ArrayList<SelectItem>();
		try {
			connection = CommonUtils.getConnection();
			listItem = (List<SelectItem>) ListItemUtil.getDropDownListValue(
					connection, formName, blockname, component, componentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listItem;
	}

}
