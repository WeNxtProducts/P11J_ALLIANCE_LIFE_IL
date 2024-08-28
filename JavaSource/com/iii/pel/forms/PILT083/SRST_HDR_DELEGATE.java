package com.iii.pel.forms.PILT083;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.utils.CommonUtils;

public class SRST_HDR_DELEGATE {

	public void executeSelectStatement(PILT083_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String selectStatement = "SELECT * FROM SRST_HEADER WHERE ROWID=?";
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getSRST_HDR_ACTION_BEAN().getBeanList().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getSRST_HDR_ACTION_BEAN().getSRST_HDR_BEAN()
							.getROWID() });
			while (resultSet.next()) {
				SRST_HDR SRST_HDR_BEAN = new SRST_HDR();
				SRST_HDR_BEAN.setSRST_DT(resultSet.getDate("SRST_DT"));
				SRST_HDR_BEAN
						.setSRST_REF_NO(resultSet.getString("SRST_REF_NO"));
				SRST_HDR_BEAN.setSRST_POL_CENTER(resultSet
						.getString("SRST_POL_CENTER"));
				SRST_HDR_BEAN.setSRST_POL_CUST_NAME(resultSet
						.getString("SRST_POL_CUST_NAME"));
				SRST_HDR_BEAN.setSRST_POL_CUST_CODE(resultSet
						.getString("SRST_POL_CUST_CODE"));
				SRST_HDR_BEAN.setSRST_POL_PROD_NAME(resultSet
						.getString("SRST_POL_PROD_NAME"));
				SRST_HDR_BEAN
						.setSRST_POL_NO(resultSet.getString("SRST_POL_NO"));
				SRST_HDR_BEAN.setSRST_SYS_ID(resultSet.getLong("SRST_SYS_ID"));

				compositeAction.getSRST_HDR_ACTION_BEAN().getBeanList().add(
						SRST_HDR_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	public List<LovBean> prepareLovList(String query, Object[] obj)
			throws Exception {

		List<LovBean> suggestionList = new ArrayList<LovBean>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			LovBean bean = null;
			resultSet = handler.executeSelectStatement(query, connection, obj);
			while (resultSet.next()) {
				bean = new LovBean();
				bean.setLovCode(resultSet.getString(1));
				suggestionList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
		return suggestionList;
	}

}
