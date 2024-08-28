package com.iii.pel.forms.PILQ116_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PAYVOU_HDR_DELEGATE {
	public void executeSelectStatement(
			PILQ116_APAC_COMPOSITE_ACTION PILQ116_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_PAYVOU_HDR.* FROM PT_IL_PAYVOU_HDR WHERE ";
		Connection connection = null;
		ResultSet resultSet = null;
		PILQ116_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_PAYVOU_HDR_ACTION_BEAN()
				.getDataList_PT_IL_PAYVOU_HDR().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection);
			while (resultSet.next()) {
				PT_IL_PAYVOU_HDR PT_IL_PAYVOU_HDR_BEAN = new PT_IL_PAYVOU_HDR();
				PT_IL_PAYVOU_HDR_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_PAYVOU_HDR_BEAN.setPAH_SYS_ID(resultSet
						.getLong("PAH_SYS_ID"));
				PT_IL_PAYVOU_HDR_BEAN.setPAH_CONTROL_NO(resultSet
						.getString("PAH_CONTROL_NO"));
				PT_IL_PAYVOU_HDR_BEAN.setPAH_TYPE(resultSet
						.getString("PAH_TYPE"));
				PT_IL_PAYVOU_HDR_BEAN.setPAH_FM_DT(resultSet
						.getDate("PAH_FM_DT"));
				PT_IL_PAYVOU_HDR_BEAN.setPAH_TO_DT(resultSet
						.getDate("PAH_TO_DT"));
				PT_IL_PAYVOU_HDR_BEAN.setPAH_PRO_DT(resultSet
						.getDate("PAH_PRO_DT"));
				PT_IL_PAYVOU_HDR_BEAN.setPAH_FREEZE_FLAG(resultSet
						.getString("PAH_FREEZE_FLAG"));
				PT_IL_PAYVOU_HDR_BEAN.setPAH_APPRV_DT(resultSet
						.getDate("PAH_APPRV_DT"));
				PT_IL_PAYVOU_HDR_BEAN.setPAH_APPRV_STATUS(resultSet
						.getString("PAH_APPRV_STATUS"));
				PT_IL_PAYVOU_HDR_BEAN.setPAH_MATCH_STATUS(resultSet
						.getString("PAH_MATCH_STATUS"));
				PT_IL_PAYVOU_HDR_BEAN.setPAH_CR_DT(resultSet
						.getDate("PAH_CR_DT"));
				PT_IL_PAYVOU_HDR_BEAN.setPAH_CR_UID(resultSet
						.getString("PAH_CR_UID"));
				PT_IL_PAYVOU_HDR_BEAN.setPAH_UPD_DT(resultSet
						.getDate("PAH_UPD_DT"));
				PT_IL_PAYVOU_HDR_BEAN.setPAH_UPD_UID(resultSet
						.getString("PAH_UPD_UID"));
				PT_IL_PAYVOU_HDR_BEAN.setPAH_REF_NO(resultSet
						.getString("PAH_REF_NO"));

				PILQ116_APAC_COMPOSITE_ACTION_BEAN
						.getPT_IL_PAYVOU_HDR_ACTION_BEAN()
						.getDataList_PT_IL_PAYVOU_HDR().add(
								PT_IL_PAYVOU_HDR_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}