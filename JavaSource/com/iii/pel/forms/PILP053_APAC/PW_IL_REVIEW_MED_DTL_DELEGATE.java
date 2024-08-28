package com.iii.pel.forms.PILP053_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PW_IL_REVIEW_MED_DTL_DELEGATE {
	public void executeSelectStatement(
			PILP053_APAC_COMPOSITE_ACTION PILP053_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PW_IL_REVIEW_MED_DTL.* FROM PW_IL_REVIEW_MED_DTL";
		Connection connection = null;
		ResultSet resultSet = null;
		PILP053_APAC_COMPOSITE_ACTION_BEAN
				.getPW_IL_REVIEW_MED_DTL_ACTION_BEAN()
				.getDataList_PW_IL_REVIEW_MED_DTL().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			while (resultSet.next()) {
				PW_IL_REVIEW_MED_DTL PW_IL_REVIEW_MED_DTL_BEAN = new PW_IL_REVIEW_MED_DTL();
				PW_IL_REVIEW_MED_DTL_BEAN
						.setROWID(resultSet.getString("ROWID"));
				PW_IL_REVIEW_MED_DTL_BEAN.setRMD_YEAR(resultSet
						.getDouble("RMD_YEAR"));
				PW_IL_REVIEW_MED_DTL_BEAN.setRMD_COVER_CODE(resultSet
						.getString("RMD_COVER_CODE"));
				PW_IL_REVIEW_MED_DTL_BEAN.setRMD_SUM_ASSURED(resultSet
						.getDouble("RMD_SUM_ASSURED"));
				PW_IL_REVIEW_MED_DTL_BEAN.setRMD_PREMIUM(resultSet
						.getDouble("RMD_PREMIUM"));
				PW_IL_REVIEW_MED_DTL_BEAN.setRMD_AGE(resultSet
						.getDouble("RMD_AGE"));
				PW_IL_REVIEW_MED_DTL_BEAN.setRMD_UNEARN_CONT_AMT(resultSet
						.getDouble("RMD_UNEARN_CONT_AMT"));
				PW_IL_REVIEW_MED_DTL_BEAN.setRMD_LOAD_FLAG(resultSet
						.getString("RMD_LOAD_FLAG"));
				PW_IL_REVIEW_MED_DTL_BEAN.setRMD_RATE(resultSet
						.getDouble("RMD_RATE"));
				PW_IL_REVIEW_MED_DTL_BEAN.setRMD_LOAD(resultSet
						.getDouble("RMD_LOAD"));
				PW_IL_REVIEW_MED_DTL_BEAN.setRMD_DISC(resultSet
						.getDouble("RMD_DISC"));
				PW_IL_REVIEW_MED_DTL_BEAN.setRMD_NET_PREM(resultSet
						.getDouble("RMD_NET_PREM"));

				PILP053_APAC_COMPOSITE_ACTION_BEAN
						.getPW_IL_REVIEW_MED_DTL_ACTION_BEAN()
						.getDataList_PW_IL_REVIEW_MED_DTL().add(
								PW_IL_REVIEW_MED_DTL_BEAN);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
