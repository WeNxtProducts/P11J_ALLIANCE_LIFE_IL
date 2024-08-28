package com.iii.pel.forms.PILM040;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_MASTER_POLICY_SEARCH_PAGE_DELEGATE {

	

	public ArrayList<PM_IL_MASTER_POLICY> fetchClassMasterDetails(
			PM_IL_MASTER_POLICY_SEARCH_PAGE_ACTION pm_il_master_policy_search_page_action) {

	
		ResultSet resultSet = null;
		ArrayList<PM_IL_MASTER_POLICY> classMasterList = new ArrayList<PM_IL_MASTER_POLICY>();
		
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();

		String query = null;
		try {
			connection = CommonUtils.getConnection();

			// String query = "SELECT CONT_REF_ID1,CONT_NAME,CONT_CODE,ROWID"
			// + " FROM PM_IL_CONTRACTOR";
			String customerCode = pm_il_master_policy_search_page_action
					.getCustomerCode().trim().toUpperCase();
			String productCode = pm_il_master_policy_search_page_action
					.getProductCode().trim().toUpperCase();

			if ((customerCode != null && customerCode.length() > 1)
					&& (productCode != null && productCode.length() > 1)) {

				query = PILM040_SQLQUERY_CONSTANTS.SELECT_PM_IL_MASTER_POLICY_SEARCH
						+ "('"
						+ customerCode
						+ "',MP_CUST_CODE) AND MP_PROD_CODE LIKE NVL('"
						+ productCode + "',MP_PROD_CODE)";
				System.out.println("Enter if condition :" + query);
				resultSet = handler.executeSelectStatement(query, connection);

			} else {

				customerCode = customerCode + "%";
				productCode = productCode + "%";
				query = PILM040_SQLQUERY_CONSTANTS.SELECT_PM_IL_MASTER_POLICY_SEARCH
						+ "('"
						+ customerCode
						+ "',MP_CUST_CODE) AND MP_PROD_CODE LIKE NVL('"
						+ productCode + "',MP_PROD_CODE)";
				resultSet = handler.executeSelectStatement(query, connection);

			}
			System.out.println("QUERY   :" + query);

			int rowIndex = 0;
			if (resultSet != null) {
				while (resultSet.next()) {
					PM_IL_MASTER_POLICY pm_il_master_policy = new PM_IL_MASTER_POLICY();

					if (resultSet.getString("MP_CUST_CODE") != null) {
						pm_il_master_policy.setMP_CUST_CODE(resultSet
								.getString("MP_CUST_CODE").toUpperCase());
					}
					if (resultSet.getString("MP_PROD_CODE") != null) {
						pm_il_master_policy.setMP_PROD_CODE(resultSet
								.getString("MP_PROD_CODE").toUpperCase());
					}

					pm_il_master_policy.setROWID(resultSet.getString("ROWID"));
					
					classMasterList.add(pm_il_master_policy);
				}
			}
			resultSet.getStatement().close();
			resultSet.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return classMasterList;
	}

	public int deleteData(PM_IL_MASTER_POLICY pm_il_master_policy) {
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;

		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();

			deletedRows = handler
					.executeDelete(pm_il_master_policy, connection);
			connection.commit();
			System.out.println("Deletion Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("The deleted rows " + deletedRows);
		return deletedRows;
	}

}
