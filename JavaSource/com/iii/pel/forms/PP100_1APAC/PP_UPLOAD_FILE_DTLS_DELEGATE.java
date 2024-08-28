package com.iii.pel.forms.PP100_1APAC;

import java.sql.Connection;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import java.sql.ResultSet;

public class PP_UPLOAD_FILE_DTLS_DELEGATE {
	public void executeSelectStatement(
			PP100_1APAC_COMPOSITE_ACTION PP100_1APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PP_UPLOAD_FILE_DTLS.* FROM PP_UPLOAD_FILE_DTLS WHERE ";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			PP_UPLOAD_FILE_DTLS PP_UPLOAD_FILE_DTLS_BEAN = new PP_UPLOAD_FILE_DTLS();
			while (resultSet.next()) {
				PP_UPLOAD_FILE_DTLS_BEAN.setROWID(resultSet.getString("ROWID"));
				PP_UPLOAD_FILE_DTLS_BEAN.setUFD_FORMAT_ID(resultSet
						.getString("UFD_FORMAT_ID"));
				PP_UPLOAD_FILE_DTLS_BEAN.setUFD_FORMAT_DESC(resultSet
						.getString("UFD_FORMAT_DESC"));
				PP_UPLOAD_FILE_DTLS_BEAN.setUFD_FILE_TYPE(resultSet
						.getString("UFD_FILE_TYPE"));
				PP_UPLOAD_FILE_DTLS_BEAN.setUFD_DELIMETER(resultSet
						.getString("UFD_DELIMETER"));
				PP_UPLOAD_FILE_DTLS_BEAN.setUFD_DEST_TABLE(resultSet
						.getString("UFD_DEST_TABLE"));
				PP_UPLOAD_FILE_DTLS_BEAN.setUFD_DATE_FORMAT(resultSet
						.getString("UFD_DATE_FORMAT"));
				PP_UPLOAD_FILE_DTLS_BEAN.setUFD_TAB_TYPE(resultSet
						.getString("UFD_TAB_TYPE"));

			}
			PP100_1APAC_COMPOSITE_ACTION_BEAN
					.getPP_UPLOAD_FILE_DTLS_ACTION_BEAN()
					.setPP_UPLOAD_FILE_DTLS_BEAN(PP_UPLOAD_FILE_DTLS_BEAN);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}