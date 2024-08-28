package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_BROKER_DEDUCTION_DELEGATE {
	public void executeSelectStatement(
			PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_POL_BROKER_DEDUCTION.* FROM PT_IL_POL_BROKER_DEDUCTION WHERE " +
								 " PT_IL_POL_BROKER_DEDUCTION.PBDED_POBH_SYS_ID = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction
				.getPT_IL_POL_BROKER_DEDUCTION_ACTION_BEAN()
				.getDataList_PT_IL_POL_BROKER_DEDUCTION().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{compositeAction.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
							.getPT_IL_POL_BROKER_HEAD_BEAN().getPOBH_SYS_ID()});
			while (resultSet.next()) {
				PT_IL_POL_BROKER_DEDUCTION PT_IL_POL_BROKER_DEDUCTION_BEAN = new PT_IL_POL_BROKER_DEDUCTION();
				PT_IL_POL_BROKER_DEDUCTION_BEAN
						.setROWID(resultSet.getString("ROWID"));
				PT_IL_POL_BROKER_DEDUCTION_BEAN.setPBDED_SYS_ID(resultSet
						.getLong("PBDED_SYS_ID"));
				PT_IL_POL_BROKER_DEDUCTION_BEAN.setPBDED_POBH_SYS_ID(resultSet
						.getLong("PBDED_POBH_SYS_ID"));
				PT_IL_POL_BROKER_DEDUCTION_BEAN.setPBDED_CODE(resultSet
						.getString("PBDED_CODE"));
				PT_IL_POL_BROKER_DEDUCTION_BEAN.setPBDED_RATE(resultSet
						.getDouble("PBDED_RATE"));
				PT_IL_POL_BROKER_DEDUCTION_BEAN.setPBDED_RATE_PER(resultSet
						.getDouble("PBDED_RATE_PER"));
				PT_IL_POL_BROKER_DEDUCTION_BEAN.setPBDED_DEL_FLAG(resultSet
						.getString("PBDED_DEL_FLAG"));
				PT_IL_POL_BROKER_DEDUCTION_BEAN.setPBDED_CR_DT(resultSet
						.getDate("PBDED_CR_DT"));
				PT_IL_POL_BROKER_DEDUCTION_BEAN.setPBDED_CR_UID(resultSet
						.getString("PBDED_CR_UID"));
				PT_IL_POL_BROKER_DEDUCTION_BEAN.setPBDED_UPD_UID(resultSet
						.getString("PBDED_UPD_UID"));
				PT_IL_POL_BROKER_DEDUCTION_BEAN.setPBDED_UPD_DT(resultSet
						.getDate("PBDED_UPD_DT"));
				PT_IL_POL_BROKER_DEDUCTION_BEAN.setPBDED_UPD_UID(resultSet
						.getString("PBDED_UPD_UID"));
				// this fild is not avilable in DB SIDE
			/*	PT_IL_POL_BROKER_DTL_BEAN.setPOBD_RANK_CODE(resultSet
						.getString("POBD_RANK_CODE"));*/

				compositeAction
						.getPT_IL_POL_BROKER_DEDUCTION_ACTION_BEAN()
						.getDataList_PT_IL_POL_BROKER_DEDUCTION().add(
								PT_IL_POL_BROKER_DEDUCTION_BEAN);
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
