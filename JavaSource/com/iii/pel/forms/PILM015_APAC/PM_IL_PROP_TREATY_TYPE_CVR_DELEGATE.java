package com.iii.pel.forms.PILM015_APAC;

import java.sql.Connection;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROP_TREATY_TYPE_CVR_DELEGATE {
	
	
	public String insertValues(PM_IL_PROP_TREATY_TYPE_CVR_ACTION typeWiseAction) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		List valueBeanList = null;

		try {
			connection = CommonUtils.getConnection();
			valueBeanList = typeWiseAction.getDataTableList();
			for (int i = 0; i < valueBeanList.size(); i++) {

				PM_IL_PROP_TREATY_TYPE_CVR valueBean = (PM_IL_PROP_TREATY_TYPE_CVR) valueBeanList
						.get(i);

				int row = handler.executeInsert(valueBean, connection);
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

