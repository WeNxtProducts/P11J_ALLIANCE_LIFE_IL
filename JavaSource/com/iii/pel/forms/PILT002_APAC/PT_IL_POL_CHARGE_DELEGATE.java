package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_POL_CHARGE_DELEGATE {
	public void executeSelectStatement(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		String selectStatement = " SELECT ROWID, PT_IL_POL_CHARGE.* FROM PT_IL_POL_CHARGE WHERE  "
				+ " PT_IL_POL_CHARGE.POC_POL_SYS_ID = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getPT_IL_POL_CHARGE_ACTION_BEAN()
				.getDataList_PT_IL_POL_CHARGE().clear();
		try {
			
			/*added by raja on 19-04-2017*/
			ArrayList<String> list = null;
			DBProcedures procedures = new  DBProcedures();
			/*end*/
			

			
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
			while (resultSet.next()) {
				PT_IL_POL_CHARGE PT_IL_POL_CHARGE_BEAN = new PT_IL_POL_CHARGE();
				PT_IL_POL_CHARGE_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_POL_CHARGE_BEAN.setPOC_SYS_ID(resultSet
						.getLong("POC_SYS_ID"));
				PT_IL_POL_CHARGE_BEAN.setPOC_POL_SYS_ID(resultSet
						.getLong("POC_POL_SYS_ID"));
				PT_IL_POL_CHARGE_BEAN.setPOC_CHRG_CODE(resultSet
						.getString("POC_CHRG_CODE"));
				PT_IL_POL_CHARGE_BEAN.setPOC_LC_VALUE(resultSet
						.getDouble("POC_LC_VALUE"));
				PT_IL_POL_CHARGE_BEAN.setPOC_FC_VALUE(resultSet
						.getDouble("POC_FC_VALUE"));
				PT_IL_POL_CHARGE_BEAN.setPOC_ORG_LC_VALUE(resultSet
						.getDouble("POC_ORG_LC_VALUE"));
				PT_IL_POL_CHARGE_BEAN.setPOC_ORG_FC_VALUE(resultSet
						.getDouble("POC_ORG_FC_VALUE"));
				PT_IL_POL_CHARGE_BEAN.setPOC_DEL_FLAG(resultSet
						.getString("POC_DEL_FLAG"));
				PT_IL_POL_CHARGE_BEAN.setPOC_CR_DT(resultSet
						.getDate("POC_CR_DT"));
				PT_IL_POL_CHARGE_BEAN.setPOC_CR_UID(resultSet
						.getString("POC_CR_UID"));
				PT_IL_POL_CHARGE_BEAN.setPOC_UPD_DT(resultSet
						.getDate("POC_UPD_DT"));
				PT_IL_POL_CHARGE_BEAN.setPOC_UPD_UID(resultSet
						.getString("POC_UPD_UID"));
				PT_IL_POL_CHARGE_BEAN.setPOC_RATE(resultSet
						.getDouble("POC_RATE"));
				PT_IL_POL_CHARGE_BEAN.setPOC_RATE_PER(resultSet
						.getDouble("POC_RATE_PER"));
				PT_IL_POL_CHARGE_BEAN.setPOC_APPLIED_ON(resultSet
						.getString("POC_APPLIED_ON"));
				PT_IL_POL_CHARGE_BEAN.setPOC_CUST_SHARE_PERC(resultSet
						.getDouble("POC_CUST_SHARE_PERC"));
				PT_IL_POL_CHARGE_BEAN.setPOC_APPLY_PERIOD(resultSet
						.getString("POC_APPLY_PERIOD"));
				PT_IL_POL_CHARGE_BEAN.setPOC_TYPE(resultSet
						.getString("POC_TYPE"));
				
				
				/*added by raja on 19-04-2017*/
				if(PT_IL_POL_CHARGE_BEAN.getPOC_CHRG_CODE()!=null)
				{
				list = procedures.P_VAL_CODES("IL_CHARGE",PT_IL_POL_CHARGE_BEAN.getPOC_CHRG_CODE(),
						PT_IL_POL_CHARGE_BEAN.getUI_M_POC_CHARGE_DESC(),"N","N",null);
				if (list != null && !list.isEmpty()) {
					if (list.get(0)!= null) {
						PT_IL_POL_CHARGE_BEAN.setUI_M_POC_CHARGE_DESC(list.get(0));
					}
				}
				}
				/*end*/

				
				compositeAction.getPT_IL_POL_CHARGE_ACTION_BEAN()
						.getDataList_PT_IL_POL_CHARGE().add(
								PT_IL_POL_CHARGE_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
