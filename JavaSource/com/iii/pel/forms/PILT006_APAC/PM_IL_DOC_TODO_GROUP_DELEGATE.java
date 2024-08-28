package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_TODO_GROUP_DELEGATE {
	/**
	 * 
	 * @param PILT006_APAC_COMPOSITE_ACTION_BEAN
	 * @throws Exception
	 */
	public void executeSelectStatement(
			PILT006_APAC_COMPOSITE_ACTION PILT006_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT TODO.ROWID, TODO.* FROM PM_IL_DOC_TODO_GROUP TODO WHERE  DTG_DS_CODE = ? ";
		

		Connection connection = null;
		ResultSet resultSet = null;
		List<PM_IL_DOC_TODO_GROUP> list = new ArrayList<PM_IL_DOC_TODO_GROUP>();
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{PILT006_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_DS_CODE()});
			while (resultSet.next()) {
				PM_IL_DOC_TODO_GROUP PM_IL_DOC_TODO_GROUP_BEAN = new PM_IL_DOC_TODO_GROUP();
				PM_IL_DOC_TODO_GROUP_BEAN
						.setROWID(resultSet.getString("ROWID"));
				PM_IL_DOC_TODO_GROUP_BEAN.setDTG_DS_TYPE(resultSet
						.getString("DTG_DS_TYPE"));
				PM_IL_DOC_TODO_GROUP_BEAN.setDTG_DS_CODE(resultSet
						.getString("DTG_DS_CODE"));
				PM_IL_DOC_TODO_GROUP_BEAN.setDTG_GROUP_CODE(resultSet
						.getString("DTG_GROUP_CODE"));
				PM_IL_DOC_TODO_GROUP_BEAN.setDTG_RESULT(resultSet
						.getString("DTG_RESULT"));
				PM_IL_DOC_TODO_GROUP_BEAN.setDTG_CR_DT(resultSet
						.getDate("DTG_CR_DT"));
				PM_IL_DOC_TODO_GROUP_BEAN.setDTG_CR_UID(resultSet
						.getString("DTG_CR_UID"));
				PM_IL_DOC_TODO_GROUP_BEAN.setDTG_UPD_DT(resultSet
						.getDate("DTG_UPD_DT"));
				PM_IL_DOC_TODO_GROUP_BEAN.setDTG_UPD_UID(resultSet
						.getString("DTG_UPD_UID"));
				PM_IL_DOC_TODO_GROUP_BEAN.setDTG_GROUP_TYPE(resultSet
						.getString("DTG_GROUP_TYPE"));
				PM_IL_DOC_TODO_GROUP_BEAN.setDTG_GROUP_DESC(resultSet
						.getString("DTG_GROUP_DESC"));
				PM_IL_DOC_TODO_GROUP_BEAN.setUI_M_DTG_GROUP_CODE_DESC("");
				list.add(PM_IL_DOC_TODO_GROUP_BEAN);
			}
			
			PILT006_APAC_COMPOSITE_ACTION_BEAN.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().setDataList_PM_IL_DOC_TODO_GROUP(list);
			
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
