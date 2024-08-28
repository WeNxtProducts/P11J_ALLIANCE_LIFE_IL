package com.iii.pel.forms.PILT002_APAC;
import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
public class PT_IL_POL_CONDITION_DELEGATE { 
	public void executeSelectStatement (PILT002_APAC_COMPOSITE_ACTION PILT002_APAC_COMPOSITE_ACTION_BEAN) 
	throws Exception { 
		String selectStatement="SELECT ROWID, PT_IL_POL_CONDITION.* FROM PT_IL_POL_CONDITION " +
				"WHERE PLCOND_POL_SYS_ID = ?";
		Connection connection=null;
		ResultSet resultSet=null;
		PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POL_CONDITION_ACTION_BEAN()
			.getDataList_PT_IL_POL_CONDITION().clear();
		try {
			connection=CommonUtils.getConnection();
			System.out.println(" pol_sys_id ====> "+PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
			resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection, 
					new Object[]{PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
			while (resultSet.next()) {
				PT_IL_POL_CONDITION PT_IL_POL_CONDITION_BEAN = new PT_IL_POL_CONDITION();
				PT_IL_POL_CONDITION_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_POL_CONDITION_BEAN.setPLCOND_SYS_ID(resultSet.getLong("PLCOND_SYS_ID"));
				PT_IL_POL_CONDITION_BEAN.setPLCOND_POL_SYS_ID(resultSet.getLong("PLCOND_POL_SYS_ID"));
				PT_IL_POL_CONDITION_BEAN.setPLCOND_CODE(resultSet.getString("PLCOND_CODE"));
				PT_IL_POL_CONDITION_BEAN.setPLCOND_DESC(resultSet.getString("PLCOND_DESC"));
				PT_IL_POL_CONDITION_BEAN.setPLCOND_DEL_FLAG(resultSet.getString("PLCOND_DEL_FLAG"));
				PT_IL_POL_CONDITION_BEAN.setPLCOND_CR_DT(resultSet.getDate("PLCOND_CR_DT"));
				PT_IL_POL_CONDITION_BEAN.setPLCOND_CR_UID(resultSet.getString("PLCOND_CR_UID"));
				PT_IL_POL_CONDITION_BEAN.setPLCOND_UPD_DT(resultSet.getDate("PLCOND_UPD_DT"));
				PT_IL_POL_CONDITION_BEAN.setPLCOND_UPD_UID(resultSet.getString("PLCOND_UPD_UID"));

				/*Added by Ram on 15/11/2016 for Condition issue*/
				PT_IL_POL_CONDITION_BEAN.setPLCOND_COND_TYP(resultSet.getString("PLCOND_COND_TYP"));
				/*End*/
				PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POL_CONDITION_ACTION_BEAN()
					.getDataList_PT_IL_POL_CONDITION().add(PT_IL_POL_CONDITION_BEAN);
			}
		} 
		finally { 
			CommonUtils.closeCursor(resultSet);
		} 
	} 
}
