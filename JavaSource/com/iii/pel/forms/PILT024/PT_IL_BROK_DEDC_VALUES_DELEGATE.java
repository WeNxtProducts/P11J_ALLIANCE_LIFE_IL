package com.iii.pel.forms.PILT024;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_BROK_DEDC_VALUES_DELEGATE {
	public void executeSelectStatement(PILT024_COMPOSITE_ACTION compositeAction)
	throws Exception {
String selectStatement = "SELECT ROWID, PT_IL_BROK_DEDC_VALUES.* FROM PT_IL_BROK_DEDC_VALUES WHERE PIS_POL_SYS_ID = ?";
Connection connection = null;
ResultSet resultSet = null;
try {
	connection = CommonUtils.getConnection();
	resultSet = new CRUDHandler().executeSelectStatement(
			selectStatement, connection, new Object[] { compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
									.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
	PT_IL_BROK_DEDC_VALUES PT_IL_BROK_DEDC_VALUES_BEAN = new PT_IL_BROK_DEDC_VALUES();
	while (resultSet.next()) {
		
		PT_IL_BROK_DEDC_VALUES_BEAN.setROWID(resultSet.getString("ROWID"));
		PT_IL_BROK_DEDC_VALUES_BEAN.setBDV_POL_SYS_ID(resultSet.getLong("BDV_POL_SYS_ID"));
		PT_IL_BROK_DEDC_VALUES_BEAN.setBDV_PC_SYS_ID(resultSet.getLong("BDV_PC_SYS_ID"));
		PT_IL_BROK_DEDC_VALUES_BEAN.setBDV_BV_SYS_ID(resultSet.getLong("BDV_BV_SYS_ID"));
		PT_IL_BROK_DEDC_VALUES_BEAN.setBDV_BROKER_CODE(resultSet.getString("BDV_BROKER_CODE"));
		PT_IL_BROK_DEDC_VALUES_BEAN.setBDV_CODE(resultSet.getString("BDV_CODE"));
		PT_IL_BROK_DEDC_VALUES_BEAN.setBDV_RATE(resultSet.getDouble("BDV_RATE"));
		PT_IL_BROK_DEDC_VALUES_BEAN.setBDV_RATE_PER(resultSet.getDouble("BDV_RATE_PER"));
		PT_IL_BROK_DEDC_VALUES_BEAN.setBDV_FC_VALUE(resultSet.getDouble("BDV_FC_VALUE"));
		PT_IL_BROK_DEDC_VALUES_BEAN.setBDV_LC_VALUE(resultSet.getDouble("BDV_LC_VALUE"));

		compositeAction.getPT_IL_BROK_DEDC_VALUES_ACTION_BEAN()
				.getDataList_PT_IL_BROK_DEDC_VALUES().add(
						PT_IL_BROK_DEDC_VALUES_BEAN);

	}
} catch (Exception e) {
	e.printStackTrace();
	throw e;
}

}
}
