package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_MED_EXAM_DTL_1_DELEGATE {
	public void executeSelectStatement(
			PILQ003_COMPOSITE_ACTION compositeAction,
			Long POAD_POL_SYS_ID, Long POAD_SYS_ID) throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getPT_IL_POL_MED_EXAM_DTL_1_ACTION_BEAN()
				.getDataList_PT_IL_POL_MED_EXAM_DTL_1().clear();
		try {
			connection = CommonUtils.getConnection();
			if (POAD_POL_SYS_ID != null && POAD_SYS_ID != null) {
				String selectStatement = "SELECT ROWID, PT_IL_POL_MED_EXAM_DTL.* FROM PT_IL_POL_MED_EXAM_DTL " +
											" WHERE PMED_POAD_SYS_ID = ? AND  PMED_POL_SYS_ID = ? ";
				resultSet = new CRUDHandler().executeSelectStatement(
						selectStatement, connection, new Object[] {
								POAD_SYS_ID, POAD_POL_SYS_ID });

			} else {
				String selectStatement = "SELECT ROWID, PT_IL_POL_MED_EXAM_DTL.* FROM PT_IL_POL_MED_EXAM_DTL " +
											" WHERE PMED_POL_SYS_ID = ? ";
				resultSet = new CRUDHandler().executeSelectStatement(
						selectStatement, connection, new Object[] { POAD_POL_SYS_ID });
			}
			while (resultSet.next()) {
				PT_IL_POL_MED_EXAM_DTL_1 PT_IL_POL_MED_EXAM_DTL_1_BEAN = new PT_IL_POL_MED_EXAM_DTL_1();
				PT_IL_POL_MED_EXAM_DTL_1_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_POL_MED_EXAM_DTL_1_BEAN.setPMED_SYS_ID(resultSet
						.getLong("PMED_SYS_ID"));
				PT_IL_POL_MED_EXAM_DTL_1_BEAN.setPMED_POL_SYS_ID(resultSet
						.getLong("PMED_POL_SYS_ID"));
				PT_IL_POL_MED_EXAM_DTL_1_BEAN.setPMED_END_NO_IDX(resultSet
						.getInt("PMED_END_NO_IDX"));
				PT_IL_POL_MED_EXAM_DTL_1_BEAN.setPMED_POAD_SYS_ID(resultSet
						.getLong("PMED_POAD_SYS_ID"));
				PT_IL_POL_MED_EXAM_DTL_1_BEAN.setPMED_EXAM_CODE(resultSet
						.getString("PMED_EXAM_CODE"));
				PT_IL_POL_MED_EXAM_DTL_1_BEAN.setPMED_STATUS(resultSet
						.getString("PMED_STATUS"));
				PT_IL_POL_MED_EXAM_DTL_1_BEAN.setPMED_CR_DT(resultSet
						.getDate("PMED_CR_DT"));
				PT_IL_POL_MED_EXAM_DTL_1_BEAN.setPMED_CR_UID(resultSet
						.getString("PMED_CR_UID"));
				PT_IL_POL_MED_EXAM_DTL_1_BEAN.setPMED_UPD_DT(resultSet
						.getDate("PMED_UPD_DT"));
				PT_IL_POL_MED_EXAM_DTL_1_BEAN.setPMED_UPD_UID(resultSet
						.getString("PMED_UPD_UID"));
				PT_IL_POL_MED_EXAM_DTL_1_BEAN.setPMED_CLINIC_CODE(resultSet
						.getString("PMED_CLINIC_CODE"));
				PT_IL_POL_MED_EXAM_DTL_1_BEAN.setPMED_PVT_LC_AMT(resultSet
						.getDouble("PMED_PVT_LC_AMT"));
				PT_IL_POL_MED_EXAM_DTL_1_BEAN.setPMED_GOVT_LC_AMT(resultSet
						.getDouble("PMED_GOVT_LC_AMT"));
				PT_IL_POL_MED_EXAM_DTL_1_BEAN.setPMED_REP_REC_DT(resultSet
						.getDate("PMED_REP_REC_DT"));
				PT_IL_POL_MED_EXAM_DTL_1_BEAN.setPMED_DEL_FLAG(resultSet
						.getString("PMED_DEL_FLAG"));

				compositeAction.getPT_IL_POL_MED_EXAM_DTL_1_ACTION_BEAN()
						.getDataList_PT_IL_POL_MED_EXAM_DTL_1().add(
								PT_IL_POL_MED_EXAM_DTL_1_BEAN);
			}
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
