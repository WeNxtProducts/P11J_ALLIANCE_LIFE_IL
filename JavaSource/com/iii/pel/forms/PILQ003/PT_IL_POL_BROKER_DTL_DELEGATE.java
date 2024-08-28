package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_BROKER_DTL_DELEGATE {
	public void executeSelectStatement(
			PILQ003_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_POL_BROKER_DTL.* FROM PT_IL_POL_BROKER_DTL WHERE " +
								 " PT_IL_POL_BROKER_DTL.POBD_POBH_SYS_ID = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction
				.getPT_IL_POL_BROKER_DTL_ACTION_BEAN()
				.getDataList_PT_IL_POL_BROKER_DTL().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
							.getPT_IL_POL_BROKER_HEAD_BEAN().getPOBH_SYS_ID()});
			while (resultSet.next()) {
				PT_IL_POL_BROKER_DTL PT_IL_POL_BROKER_DTL_BEAN = new PT_IL_POL_BROKER_DTL();
				PT_IL_POL_BROKER_DTL_BEAN
						.setROWID(resultSet.getString("ROWID"));
				PT_IL_POL_BROKER_DTL_BEAN.setPOBD_SYS_ID(resultSet
						.getLong("POBD_SYS_ID"));
				PT_IL_POL_BROKER_DTL_BEAN.setPOBD_POBH_SYS_ID(resultSet
						.getLong("POBD_POBH_SYS_ID"));
				PT_IL_POL_BROKER_DTL_BEAN.setPOBD_YEAR_FROM(resultSet
						.getInt("POBD_YEAR_FROM"));
				PT_IL_POL_BROKER_DTL_BEAN.setPOBD_YEAR_TO(resultSet
						.getInt("POBD_YEAR_TO"));
				PT_IL_POL_BROKER_DTL_BEAN.setPOBD_DEL_FLAG(resultSet
						.getString("POBD_DEL_FLAG"));
				PT_IL_POL_BROKER_DTL_BEAN.setPOBD_CR_DT(resultSet
						.getDate("POBD_CR_DT"));
				PT_IL_POL_BROKER_DTL_BEAN.setPOBD_CR_UID(resultSet
						.getString("POBD_CR_UID"));
				PT_IL_POL_BROKER_DTL_BEAN.setPOBD_UPD_DT(resultSet
						.getDate("POBD_UPD_DT"));
				PT_IL_POL_BROKER_DTL_BEAN.setPOBD_UPD_UID(resultSet
						.getString("POBD_UPD_UID"));
				PT_IL_POL_BROKER_DTL_BEAN.setPOBD_RATE(resultSet
						.getDouble("POBD_RATE"));
				PT_IL_POL_BROKER_DTL_BEAN.setPOBD_RATE_PER(resultSet
						.getDouble("POBD_RATE_PER"));
				// this fild is not avilable in DB SIDE
			/*	PT_IL_POL_BROKER_DTL_BEAN.setPOBD_RANK_CODE(resultSet
						.getString("POBD_RANK_CODE"));*/

				compositeAction
						.getPT_IL_POL_BROKER_DTL_ACTION_BEAN()
						.getDataList_PT_IL_POL_BROKER_DTL().add(
								PT_IL_POL_BROKER_DTL_BEAN);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
			
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
 
}
