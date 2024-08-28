package com.iii.pel.forms.PILT032_APAC;

import java.sql.Connection;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import java.sql.ResultSet;


public class PT_IL_RECEIPT_TRANS_HDR_DELEGATE {
	public void executeSelectStatement(
			PILT032_APAC_COMPOSITE_ACTION PILT032_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT PT_IL_RECEIPT_TRANS_HDR.* FROM PT_IL_RECEIPT_TRANS_HDR" +
				" WHERE ROWID = ? " ;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			if(PILT032_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getDEFAULT_WHERE() != null){
				selectStatement = selectStatement  
				+ PILT032_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getDEFAULT_WHERE();
			}
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[] {PILT032_APAC_COMPOSITE_ACTION_BEAN.
							getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN().getPT_IL_RECEIPT_TRANS_HDR_BEAN().getROWID()});
			PT_IL_RECEIPT_TRANS_HDR PT_IL_RECEIPT_TRANS_HDR_BEAN = new PT_IL_RECEIPT_TRANS_HDR();
			while (resultSet.next()) {
				//PT_IL_RECEIPT_TRANS_HDR_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_SYS_ID(resultSet.getLong("RTH_SYS_ID"));
				PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_SRC_POL_SYS_ID(resultSet.getLong("RTH_SRC_POL_SYS_ID"));
				PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_SRC_POL_NO(resultSet.getString("RTH_SRC_POL_NO"));
				PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_SRC_LC_AMT(resultSet.getDouble("RTH_SRC_LC_AMT"));
				PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_PROCESS_DT(resultSet.getDate("RTH_PROCESS_DT"));
				PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_APPRV_DT(resultSet.getDate("RTH_APPRV_DT"));
				PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_APPRV_STATUS(resultSet.getString("RTH_APPRV_STATUS"));
				PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_APPRV_USER(resultSet.getString("RTH_APPRV_USER"));
				PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_CR_DT(resultSet.getDate("RTH_CR_DT"));
				PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_CR_UID(resultSet.getString("RTH_CR_UID"));
				PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_UPD_DT(resultSet.getDate("RTH_UPD_DT"));
				PT_IL_RECEIPT_TRANS_HDR_BEAN.setRTH_UPD_UID(resultSet.getString("RTH_UPD_UID"));

			}
			PILT032_APAC_COMPOSITE_ACTION_BEAN
					.getPT_IL_RECEIPT_TRANS_HDR_ACTION_BEAN()
					.setPT_IL_RECEIPT_TRANS_HDR_BEAN(
							PT_IL_RECEIPT_TRANS_HDR_BEAN);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}