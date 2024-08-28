package com.iii.pel.forms.PILT024;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POLICY_DELEGATE {
	public void executeSelectStatement(
			PILT024_COMPOSITE_ACTION PILT024_COMPOSITE_ACTION_BEAN)
			throws Exception {
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		String executeQuery = "SELECT ROWID, PT_IL_POLICY.* FROM PT_IL_POLICY WHERE ROWID=? ";
		ResultSet resultSet = null;
		/*Added by Ameen on 22-05-2016*/
		String custDescQry = "SELECT CUST_NAME FROM PT_IL_POLICY,PM_CUSTOMER WHERE POL_NO = ?"
				+ " AND POL_CUST_CODE = CUST_CODE";
		String currDecQry = "SELECT CURR_NAME FROM PT_IL_POLICY,FM_CURRENCY WHERE CURR_CODE = POL_CUST_CURR_CODE AND POL_NO = ?";
		String lastPaiDtQry = "SELECT MAX(PC_SCHD_PYMT_DT) FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = ? AND NVL(PC_PAID_FLAG,'N') = 'A'";
		ResultSet custDescRS = null;
		ResultSet currDecRS = null;
		ResultSet lastPaiDtRS = null;
		/*End*/

		con = CommonUtils.getConnection();
		PT_IL_POLICY PT_IL_POLICY_BEAN = null;
		PT_IL_POLICY policyBean = PILT024_COMPOSITE_ACTION_BEAN
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();

		resultSet = handler.executeSelectStatement(executeQuery, con,
				new Object[] { policyBean.getROWID() });

		while (resultSet.next()) {
			PT_IL_POLICY_BEAN = new PT_IL_POLICY();
			PT_IL_POLICY_BEAN.setROWID(resultSet.getString("ROWID"));
			PT_IL_POLICY_BEAN.setPOL_SYS_ID(resultSet.getLong("POL_SYS_ID"));
			PT_IL_POLICY_BEAN.setPOL_NO(resultSet.getString("POL_NO"));
			PT_IL_POLICY_BEAN
					.setPOL_ISSUE_DT(resultSet.getDate("POL_ISSUE_DT"));
			PT_IL_POLICY_BEAN.setPOL_PLAN_CODE(resultSet
					.getString("POL_PLAN_CODE"));
			PT_IL_POLICY_BEAN.setPOL_CUST_CODE(resultSet
					.getString("POL_CUST_CODE"));
			/*Added by Ameen on 22-05-2017 as per Gaurav sugg.*/
			custDescRS = handler.executeSelectStatement(custDescQry, con,
					new Object []{PT_IL_POLICY_BEAN.getPOL_NO()});
			if(custDescRS.next()){
				PT_IL_POLICY_BEAN.setUI_M_POL_CUST_NAME(custDescRS.getString("CUST_NAME"));
			}
			PT_IL_POLICY_BEAN.setPOL_CUST_CURR_CODE(resultSet
					.getString("POL_CUST_CURR_CODE"));
			currDecRS = handler.executeSelectStatement(currDecQry, con,
					new Object []{PT_IL_POLICY_BEAN.getPOL_NO()});
			if(currDecRS.next()){
				PT_IL_POLICY_BEAN.setUI_M_POL_CUST_CURR_CODE_DESC(currDecRS.getString("CURR_NAME"));
			}
			/*End*/
			PT_IL_POLICY_BEAN.setPOL_CONT_CODE(resultSet
					.getString("POL_CONT_CODE"));
			PT_IL_POLICY_BEAN.setPOL_ASSURED_NAME(resultSet
					.getString("POL_ASSURED_NAME"));
			PT_IL_POLICY_BEAN.setPOL_CUST_EXCH_RATE(resultSet
					.getDouble("POL_CUST_EXCH_RATE"));
			PT_IL_POLICY_BEAN
					.setPOL_START_DT(resultSet.getDate("POL_START_DT"));
			PT_IL_POLICY_BEAN.setPOL_EXPIRY_DT(resultSet
					.getDate("POL_EXPIRY_DT"));
			PT_IL_POLICY_BEAN.setPOL_MODE_OF_PYMT(resultSet
					.getString("POL_MODE_OF_PYMT"));
			/*Added by Ameen on 22-05-2017  as per Gaurav sugg.*/
			lastPaiDtRS = handler.executeSelectStatement(lastPaiDtQry, con,
					new Object []{PT_IL_POLICY_BEAN.getPOL_SYS_ID()});
			if(lastPaiDtRS.next()){
				PT_IL_POLICY_BEAN.setUI_M_PREV_PAY_DT(lastPaiDtRS.getDate(1));
			}
			/*End*/
			PT_IL_POLICY_BEAN.setPOL_PROD_CODE(resultSet
					.getString("POL_PROD_CODE"));

			PILT024_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY_ACTION_BEAN()
					.setPT_IL_POLICY_BEAN(PT_IL_POLICY_BEAN);
		}

	}
}
