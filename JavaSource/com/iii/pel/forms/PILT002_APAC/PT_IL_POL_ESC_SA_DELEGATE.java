package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_ESC_SA_DELEGATE {
	public void executeSelectStatement(
		    PILT002_APAC_COMPOSITE_ACTION PILT002_APAC_COMPOSITE_ACTION_BEAN)
		    throws Exception {
		/*Commented by Saranya on 07/04/2017 as per Siva suggestion
		 * 
		 * String selectStatement = "SELECT ROWID, PT_IL_POL_ESC_SA.* FROM PT_IL_POL_ESC_SA WHERE  PT_IL_POL_ESC_SA.PES_POL_SYS_ID =  ?  AND PT_IL_POL_ESC_SA.PES_MONTH >0";
		 * 
		 * End
		 * */
		
		String selectStatement = "SELECT ROWID, PT_IL_POL_ESC_SA.* FROM PT_IL_POL_ESC_SA WHERE  PT_IL_POL_ESC_SA.PES_POL_SYS_ID = ? AND PT_IL_POL_ESC_SA.PES_MONTH >0 ORDER BY PES_MONTH ";
		
		System.out.println("Query  :"+selectStatement);
		Connection connection = null;
		ResultSet resultSet = null;
		PILT002_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_POL_ESC_SA_ACTION_BEAN()
			.getDataList_PT_IL_POL_ESC_SA().clear();
		try {
		    connection = CommonUtils.getConnection();
		    System.out.println("ROWID  :"+PILT002_APAC_COMPOSITE_ACTION_BEAN
						    .getPT_IL_POL_ESC_SA_ACTION_BEAN()
						    .getPT_IL_POL_ESC_SA_BEAN().getROWID());
		    System.out.println("POL_SYS_ID  :"+PILT002_APAC_COMPOSITE_ACTION_BEAN
					    .getPT_IL_POLICY_ACTION_BEAN()
					    .getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
		    resultSet = new CRUDHandler().executeSelectStatement(
			    selectStatement, connection, new Object[] {
				    PILT002_APAC_COMPOSITE_ACTION_BEAN
					    .getPT_IL_POLICY_ACTION_BEAN()
					    .getPT_IL_POLICY_BEAN().getPOL_SYS_ID() });
		    while (resultSet.next()) {
		    	PT_IL_POL_ESC_SA PT_IL_POL_ESC_SA_BEAN = new PT_IL_POL_ESC_SA();
			//System.out.println("PES_MONTH    Test : "+resultSet.getDouble("PES_MONTH"));
			
			PT_IL_POL_ESC_SA_BEAN.setROWID(resultSet.getString("ROWID"));
			PT_IL_POL_ESC_SA_BEAN.setPES_SYS_ID(resultSet
				.getDouble("PES_SYS_ID"));
			PT_IL_POL_ESC_SA_BEAN.setPES_POL_SYS_ID(resultSet
				.getLong("PES_POL_SYS_ID"));
			PT_IL_POL_ESC_SA_BEAN.setPES_END_NO_IDX(resultSet
				.getDouble("PES_END_NO_IDX"));
			PT_IL_POL_ESC_SA_BEAN.setPES_MONTH(resultSet
				.getDouble("PES_MONTH"));
			PT_IL_POL_ESC_SA_BEAN.setPES_PYMT_DT(resultSet
					.getDate("PES_PYMT_DT"));
			PT_IL_POL_ESC_SA_BEAN.setPES_FC_OPEN_BAL(resultSet
					.getDouble("PES_FC_OPEN_BAL"));
			PT_IL_POL_ESC_SA_BEAN.setPES_LC_OPEN_BAL(resultSet
					.getDouble("PES_LC_OPEN_BAL"));
			PT_IL_POL_ESC_SA_BEAN.setPES_FC_SA(resultSet
				.getDouble("PES_FC_SA"));
			PT_IL_POL_ESC_SA_BEAN.setPES_LC_SA(resultSet
				.getDouble("PES_LC_SA"));
			PT_IL_POL_ESC_SA_BEAN.setPES_CR_DT(resultSet
				.getDate("PES_CR_DT"));
			PT_IL_POL_ESC_SA_BEAN.setPES_CR_UID(resultSet
				.getString("PES_CR_UID"));
			PT_IL_POL_ESC_SA_BEAN.setPES_UPD_DT(resultSet
				.getDate("PES_UPD_DT"));
			PT_IL_POL_ESC_SA_BEAN.setPES_UPD_UID(resultSet
				.getString("PES_UPD_UID"));
			PT_IL_POL_ESC_SA_BEAN.setPES_COVER_CODE(resultSet
				.getString("PES_COVER_CODE"));
			
			

			PILT002_APAC_COMPOSITE_ACTION_BEAN
				.getPT_IL_POL_ESC_SA_ACTION_BEAN()
				.getDataList_PT_IL_POL_ESC_SA().add(
						PT_IL_POL_ESC_SA_BEAN);
		    }
		} finally {
		    CommonUtils.closeCursor(resultSet);
		}
	    }

}
