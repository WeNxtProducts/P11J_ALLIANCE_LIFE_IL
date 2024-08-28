package com.iii.pel.forms.PILM034;
import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
public class PM_IL_TAR_DTL_DELEGATE { 
	/*public void executeSelectStatement (PILM034_COMPOSITE_ACTION PILM034_COMPOSITE_ACTION_BEAN)
	throws Exception { 
		String selectStatement="SELECT ROWID, PM_IL_TAR_DTL.* FROM PM_IL_TAR_DTL";// WHERE 
		Connection connection=null;
		ResultSet resultSet=null;
		PILM034_COMPOSITE_ACTION_BEAN.getPM_IL_TAR_DTL_ACTION_BEAN().getDataList_PM_IL_TAR_DTL().clear();
		try {
			connection=CommonUtils.getConnection();
			resultSet=new CRUDHandler().executeSelectStatement(selectStatement,connection);
			while (resultSet.next()) {
				PM_IL_TAR_DTL PM_IL_TAR_DTL_BEAN = new PM_IL_TAR_DTL();
				PM_IL_TAR_DTL_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_01_FM(resultSet.getString("TD_PARA_01_FM"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_02_FM(resultSet.getString("TD_PARA_02_FM"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_03_FM(resultSet.getString("TD_PARA_03_FM"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_04_FM(resultSet.getString("TD_PARA_04_FM"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_05_FM(resultSet.getString("TD_PARA_05_FM"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_06_FM(resultSet.getString("TD_PARA_06_FM"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_07_FM(resultSet.getString("TD_PARA_07_FM"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_08_FM(resultSet.getString("TD_PARA_08_FM"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_09_FM(resultSet.getString("TD_PARA_09_FM"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_10_FM(resultSet.getString("TD_PARA_10_FM"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_01_TO(resultSet.getString("TD_PARA_01_TO"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_02_TO(resultSet.getString("TD_PARA_02_TO"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_03_TO(resultSet.getString("TD_PARA_03_TO"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_04_TO(resultSet.getString("TD_PARA_04_TO"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_05_TO(resultSet.getString("TD_PARA_05_TO"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_06_TO(resultSet.getString("TD_PARA_06_TO"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_07_TO(resultSet.getString("TD_PARA_07_TO"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_08_TO(resultSet.getString("TD_PARA_08_TO"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_09_TO(resultSet.getString("TD_PARA_09_TO"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_10_TO(resultSet.getString("TD_PARA_10_TO"));
				PM_IL_TAR_DTL_BEAN.setTD_RATE(resultSet.getDouble("TD_RATE"));
				PM_IL_TAR_DTL_BEAN.setTD_CHAR_RATE(resultSet.getString("TD_CHAR_RATE"));
				PM_IL_TAR_DTL_BEAN.setTD_EFF_FM_DT(resultSet.getDate("TD_EFF_FM_DT"));
				PM_IL_TAR_DTL_BEAN.setTD_EFF_TO_DT(resultSet.getDate("TD_EFF_TO_DT"));
				PM_IL_TAR_DTL_BEAN.setTD_MINIMUM(resultSet.getDouble("TD_MINIMUM"));
				PM_IL_TAR_DTL_BEAN.setTD_MAXIMUM(resultSet.getDouble("TD_MAXIMUM"));
				
				PILM034_COMPOSITE_ACTION_BEAN.getPM_IL_TAR_DTL_ACTION_BEAN().
				getDataList_PM_IL_TAR_DTL().add(PM_IL_TAR_DTL_BEAN);
			}
		} 
		finally { 
			CommonUtils.closeCursor(resultSet);
		} 
	} */
	public void executeSelectStatement (PILM034_COMPOSITE_ACTION 
			PILM034_COMPOSITE_ACTION_BEAN, String TH_CODE, String TH_PARAM_TYPE) throws Exception { 
		String selectStatement="SELECT PM_IL_TAR_DTL.ROWID, PM_IL_TAR_DTL.* FROM " +
			"PM_IL_TAR_HDR,PM_IL_TAR_DTL WHERE PM_IL_TAR_DTL.TD_TH_CODE = " +
			"PM_IL_TAR_HDR.TH_CODE AND PM_IL_TAR_DTL.TD_PARAM_TYPE = PM_IL_TAR_HDR.TH_PARAM_TYPE " +
			"AND PM_IL_TAR_DTL.TD_TH_CODE = ? AND PM_IL_TAR_DTL.TD_PARAM_TYPE = ?";
		Connection connection=null;
		ResultSet resultSet=null;
		PILM034_COMPOSITE_ACTION_BEAN.getPM_IL_TAR_DTL_ACTION_BEAN().getDataList_PM_IL_TAR_DTL().clear();
		try {
			connection=CommonUtils.getConnection();
			resultSet=new CRUDHandler().executeSelectStatement(
					selectStatement,connection, new Object[]{TH_CODE,TH_PARAM_TYPE});
			while (resultSet.next()) {
				PM_IL_TAR_DTL PM_IL_TAR_DTL_BEAN = new PM_IL_TAR_DTL();
				PM_IL_TAR_DTL_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_IL_TAR_DTL_BEAN.setTD_TH_CODE(resultSet.getString("TD_TH_CODE"));
				PM_IL_TAR_DTL_BEAN.setTD_PARAM_TYPE(resultSet.getString("TD_PARAM_TYPE"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_01_FM(resultSet.getString("TD_PARA_01_FM"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_02_FM(resultSet.getString("TD_PARA_02_FM"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_03_FM(resultSet.getString("TD_PARA_03_FM"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_04_FM(resultSet.getString("TD_PARA_04_FM"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_05_FM(resultSet.getString("TD_PARA_05_FM"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_06_FM(resultSet.getString("TD_PARA_06_FM"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_07_FM(resultSet.getString("TD_PARA_07_FM"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_08_FM(resultSet.getString("TD_PARA_08_FM"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_09_FM(resultSet.getString("TD_PARA_09_FM"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_10_FM(resultSet.getString("TD_PARA_10_FM"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_01_TO(resultSet.getString("TD_PARA_01_TO"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_02_TO(resultSet.getString("TD_PARA_02_TO"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_03_TO(resultSet.getString("TD_PARA_03_TO"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_04_TO(resultSet.getString("TD_PARA_04_TO"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_05_TO(resultSet.getString("TD_PARA_05_TO"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_06_TO(resultSet.getString("TD_PARA_06_TO"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_07_TO(resultSet.getString("TD_PARA_07_TO"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_08_TO(resultSet.getString("TD_PARA_08_TO"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_09_TO(resultSet.getString("TD_PARA_09_TO"));
				PM_IL_TAR_DTL_BEAN.setTD_PARA_10_TO(resultSet.getString("TD_PARA_10_TO"));
				PM_IL_TAR_DTL_BEAN.setTD_RATE(resultSet.getDouble("TD_RATE"));
				PM_IL_TAR_DTL_BEAN.setTD_CHAR_RATE(resultSet.getString("TD_CHAR_RATE"));
				PM_IL_TAR_DTL_BEAN.setTD_EFF_FM_DT(resultSet.getDate("TD_EFF_FM_DT"));
				PM_IL_TAR_DTL_BEAN.setTD_EFF_TO_DT(resultSet.getDate("TD_EFF_TO_DT"));
				PM_IL_TAR_DTL_BEAN.setTD_MINIMUM(resultSet.getDouble("TD_MINIMUM"));
				PM_IL_TAR_DTL_BEAN.setTD_MAXIMUM(resultSet.getDouble("TD_MAXIMUM"));
				
				PILM034_COMPOSITE_ACTION_BEAN.getPM_IL_TAR_DTL_ACTION_BEAN().
				getDataList_PM_IL_TAR_DTL().add(PM_IL_TAR_DTL_BEAN);
			}
		} 
		finally { 
			CommonUtils.closeCursor(resultSet);
		} 
	}
}
