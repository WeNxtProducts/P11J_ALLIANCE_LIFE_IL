package com.iii.pel.forms.PILM015_APAC;

import java.sql.Connection;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROP_TREATY_PART_CUST_DELEGATE {

	public String insertValues(PM_IL_PROP_TREATY_PART_CUST_ACTION customerAction) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		List valueBeanList = null;

		try {
			connection = CommonUtils.getConnection();
			valueBeanList = customerAction.getDataTableList();
			for (int i = 0; i < valueBeanList.size(); i++) {

				PM_IL_PROP_TREATY_PART_CUST customerValueBean = (PM_IL_PROP_TREATY_PART_CUST) valueBeanList
						.get(i);

				int row = handler.executeInsert(customerValueBean, connection);
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
