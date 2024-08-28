package com.iii.pel.forms.PILM015_APAC;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_PROP_TREATY_TYPE_DELEGATE {

	public int updateForTreatyType(PM_IL_PROP_TREATY_TYPE pm_il_prop_treaty_type)
			throws Exception {
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(pm_il_prop_treaty_type,
					connection);
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}

	public int deleteData(PM_IL_PROP_TREATY_TYPE gridValueBean) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
//		double sysId1 = gridValueBean.getPTT_SYS_ID();
//		String treatyCustomerDelete = "DELETE FROM PM_IL_PROP_TREATY_PART_CUST  WHERE PTPC_PTT_SYS_ID = '"
//			+ sysId1 + "'";
//	    String treatyCoverDelete = "DELETE FROM PM_IL_PROP_TREATY_COVER WHERE PTC_PTT_SYS_ID='"
//			+ sysId1 + "'";
//	    String treatyTypeWiseDelete = " DELETE FROM PM_IL_PROP_TREATY_TYPE_COVER P  WHERE P.PTTC_PTT_SYS_ID = '"
//			+ sysId1 + "'";
			
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
//			handler.executeDeleteStatement(treatyCustomerDelete, connection);
//			handler.executeDeleteStatement(treatyCoverDelete, connection);
//			handler.executeDeleteStatement(treatyTypeWiseDelete, connection);
			deletedRows = handler.executeDelete(gridValueBean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
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

	public List getValuesForTreatyType() {

		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		List list = null;
		try {
			list = new ArrayList();
			connection = CommonUtils.getConnection();
			String query = "select PM_IL_PROP_TREATY_TYPE.*,"
					+ "ROWID AS COLUMNROWID from PM_IL_PROP_TREATY_TYPE ";
			list = dbHandler.fetch(query,
					"com.iii.pel.forms.PILM015_APAC.PM_IL_PROP_TREATY_TYPE",
					connection);
			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return list;
	}

	public String insertValues(PM_IL_PROP_TREATY_TYPE_ACTION typeAction) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		List valueBeanList = null;
		CommonUtils commonUtils = new CommonUtils();
		try {
			connection = CommonUtils.getConnection();
			valueBeanList = typeAction.getDataTableList();
			for (int i = 0; i < valueBeanList.size(); i++) {

				PM_IL_PROP_TREATY_TYPE treatyValueBean = (PM_IL_PROP_TREATY_TYPE) valueBeanList.get(i);
				treatyValueBean.setPTT_CR_DT(commonUtils.getCurrentDate());
				treatyValueBean.setPTT_CR_UID(CommonUtils.getControlBean().getM_USER_ID());

				int row = handler.executeInsert(treatyValueBean, connection);

				if (row > 0) {
					System.out
							.println("<-------------Insertion Successful---------->");
				}
			}

			connection.commit();

		} catch (Exception exception) {

			exception.printStackTrace();

		} finally {

			try {

			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		return "inserted";
	}

}
