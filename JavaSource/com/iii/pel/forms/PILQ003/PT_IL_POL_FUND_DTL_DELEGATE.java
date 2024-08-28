package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_FUND_DTL_DELEGATE {
    public void executeSelectStatement(PILQ003_COMPOSITE_ACTION compositeAction)throws Exception {
	
   String selectStatement = "SELECT ROWID,PT_IL_POL_FUND_DTL.* FROM PT_IL_POL_FUND_DTL WHERE PT_IL_POL_FUND_DTL.POFD_POL_SYS_ID = ? ";
   Connection connection = null;
   ResultSet resultSet = null;
   compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().getDataList_PT_IL_POL_FUND_DTL().clear();
	
   try {
	    connection = CommonUtils.getConnection();
	    resultSet = new CRUDHandler().executeSelectStatement(selectStatement, connection, new Object[] {
	    		compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
			   
	    while (resultSet.next()) {
		PT_IL_POL_FUND_DTL PT_IL_POL_FUND_DTL_BEAN = new PT_IL_POL_FUND_DTL();
		PT_IL_POL_FUND_DTL_BEAN.setROWID(resultSet.getString("ROWID"));
		PT_IL_POL_FUND_DTL_BEAN.setPOFD_POL_SYS_ID(resultSet.getLong("POFD_POL_SYS_ID"));
		PT_IL_POL_FUND_DTL_BEAN.setPOFD_FUND_CODE(resultSet.getString("POFD_FUND_CODE"));
		PT_IL_POL_FUND_DTL_BEAN.setPOFD_FUND_PERC(resultSet.getDouble("POFD_FUND_PERC"));
		PT_IL_POL_FUND_DTL_BEAN.setPOFD_CR_DT(resultSet.getDate("POFD_CR_DT"));
		PT_IL_POL_FUND_DTL_BEAN.setPOFD_CR_UID(resultSet.getString("POFD_CR_UID"));
		PT_IL_POL_FUND_DTL_BEAN.setPOFD_UPD_DT(resultSet.getDate("POFD_UPD_DT"));
		PT_IL_POL_FUND_DTL_BEAN.setPOFD_UPD_UID(resultSet.getString("POFD_UPD_UID"));
		PT_IL_POL_FUND_DTL_BEAN.setPOFD_SYS_ID(resultSet.getLong("POFD_SYS_ID"));
		PT_IL_POL_FUND_DTL_BEAN.setPOFD_FUND_DIR_TYPE(resultSet.getString("POFD_FUND_DIR_TYPE"));
		PT_IL_POL_FUND_DTL_BEAN.setPOFD_EFF_FM_DT(resultSet.getDate("POFD_EFF_FM_DT"));
		PT_IL_POL_FUND_DTL_BEAN.setPOFD_EFF_TO_DT(resultSet.getDate("POFD_EFF_TO_DT"));
		PT_IL_POL_FUND_DTL_BEAN.setPOFD_DEL_FLAG(resultSet.getString("POFD_DEL_FLAG"));

		compositeAction.getPT_IL_POL_FUND_DTL_ACTION_BEAN().getDataList_PT_IL_POL_FUND_DTL().add(PT_IL_POL_FUND_DTL_BEAN);
	    }
	} finally {
		try {
			CommonUtils.closeCursor(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    }

}
