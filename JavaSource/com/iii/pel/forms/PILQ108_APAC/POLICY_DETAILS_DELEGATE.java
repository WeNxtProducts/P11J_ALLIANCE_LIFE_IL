package com.iii.pel.forms.PILQ108_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;



public class POLICY_DETAILS_DELEGATE {
	public void executeSelectStatement(
			PILQ108_APAC_COMPOSITE_ACTION PILQ108_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_POLICY.* FROM PT_IL_POLICY WHERE ".concat(PILQ108_APAC_COMPOSITE_ACTION_BEAN.getWHERE_QUERY());
		Connection connection = null;
		ResultSet resultSet = null;
		List<POLICY_DETAILS > list = new ArrayList<POLICY_DETAILS>();
		POLICY_DETAILS_HELPER helper = new POLICY_DETAILS_HELPER();
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			PILQ108_APAC_COMPOSITE_ACTION_BEAN.getPOLICY_DETAILS_ACTION_BEAN().getDataList_POLICY_DETAILS().clear();
			while (resultSet.next()) {
				POLICY_DETAILS POLICY_DETAILS_BEAN = new POLICY_DETAILS();
				POLICY_DETAILS_BEAN.setROWID(resultSet.getString("ROWID"));
				POLICY_DETAILS_BEAN.setPOL_NO(resultSet.getString("POL_NO"));
				POLICY_DETAILS_BEAN.setPOL_PROP_NO(resultSet.getString("POL_PROP_NO"));
				POLICY_DETAILS_BEAN.setPOL_START_DT(resultSet.getDate("POL_START_DT"));
				POLICY_DETAILS_BEAN.setPOL_EXPIRY_DT(resultSet.getDate("POL_EXPIRY_DT"));
				POLICY_DETAILS_BEAN.setPOL_STATUS(resultSet.getString("POL_STATUS"));
				POLICY_DETAILS_BEAN.setPOL_ADDL_STATUS(resultSet.getString("POL_ADDL_STATUS"));
				
				helper.postQuery(POLICY_DETAILS_BEAN);
				list.add(POLICY_DETAILS_BEAN);
			}
			PILQ108_APAC_COMPOSITE_ACTION_BEAN.getPOLICY_DETAILS_ACTION_BEAN().setDataListPOLICY_DETAILS(list);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
