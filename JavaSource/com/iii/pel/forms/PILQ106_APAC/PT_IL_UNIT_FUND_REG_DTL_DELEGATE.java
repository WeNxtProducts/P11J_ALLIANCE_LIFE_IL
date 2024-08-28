package com.iii.pel.forms.PILQ106_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_UNIT_FUND_REG_DTL_DELEGATE {
	public void executeSelectStatement(
			PILQ106_APAC_COMPOSITE_ACTION PILQ106_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		Object[] values = null;
		/*
		 * MODIFEID BY AMEEN ON 19-06-2017 FOR ZBILQC-1727874
		 * String selectStatement = "SELECT ROWID, PT_IL_UNIT_FUND_REG_DTL.* FROM" +
				" PT_IL_UNIT_FUND_REG_DTL WHERE UFRD_UFRH_SYS_ID=? ";*/
		String selectStatement = "SELECT ROWID, UFRD_SYS_ID, UFRD_UFRH_SYS_ID, UFRD_FUND_CODE, UFRD_FUND_PERC, UFRD_NO_OF_UNITS, UFRD_UNIT_PUR_LC_AMT, UFRD_UNIT_SEL_LC_AMT, "
				+ "UFRD_UNIT_TOT_LC_VALUE, UFRD_CR_UID,UFRD_CR_DT, UFRD_UPD_UID, UFRD_UPD_DT, UFRD_UNIT_DATE, TO_CHAR(UFRD_UNIT_DATE,'DD/MM/RRRR') UNIT_DATE, UFRD_TOP_UP_UNITS, UFRD_PREM_UNITS, UFRD_START_UNITS, UFRD_START_UNIT_VALUE " +
				"FROM PT_IL_UNIT_FUND_REG_DTL WHERE UFRD_UFRH_SYS_ID=? ";
		Connection connection = null;
		ResultSet resultSet = null;
		PILQ106_APAC_COMPOSITE_ACTION_BEAN
				.getPT_IL_UNIT_FUND_REG_DTL_ACTION_BEAN()
				.getDataList_PT_IL_UNIT_FUND_REG_DTL().clear();
		try {
			connection = CommonUtils.getConnection();
			values = new Object[]{PILQ106_APAC_COMPOSITE_ACTION_BEAN
					.getPT_IL_UNIT_FUND_REG_HDR_ACTION_BEAN()
					.getPT_IL_UNIT_FUND_REG_HDR_BEAN().getUFRH_SYS_ID()};
			
			if(PILQ106_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_UNIT_FUND_REG_DTL_ACTION_BEAN().getPT_IL_UNIT_FUND_REG_DTL_BEAN().getM_WHERE()!=null){
			    
			    selectStatement = selectStatement + " AND " +PILQ106_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_UNIT_FUND_REG_DTL_ACTION_BEAN().getPT_IL_UNIT_FUND_REG_DTL_BEAN().getM_WHERE();
			}
			
			
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, values);
			while (resultSet.next()) {
				PT_IL_UNIT_FUND_REG_DTL PT_IL_UNIT_FUND_REG_DTL_BEAN = new PT_IL_UNIT_FUND_REG_DTL();
				PT_IL_UNIT_FUND_REG_DTL_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_UNIT_FUND_REG_DTL_BEAN.setUFRD_SYS_ID(resultSet
						.getLong("UFRD_SYS_ID"));
				PT_IL_UNIT_FUND_REG_DTL_BEAN.setUFRD_UFRH_SYS_ID(resultSet
						.getLong("UFRD_UFRH_SYS_ID"));
				PT_IL_UNIT_FUND_REG_DTL_BEAN.setUFRD_FUND_CODE(resultSet
						.getString("UFRD_FUND_CODE"));
				PT_IL_UNIT_FUND_REG_DTL_BEAN.setUFRD_FUND_PERC(resultSet
						.getDouble("UFRD_FUND_PERC"));
				PT_IL_UNIT_FUND_REG_DTL_BEAN.setUFRD_NO_OF_UNITS(resultSet
						.getDouble("UFRD_NO_OF_UNITS"));
				PT_IL_UNIT_FUND_REG_DTL_BEAN.setUFRD_UNIT_PUR_LC_AMT(resultSet
						.getDouble("UFRD_UNIT_PUR_LC_AMT"));
				PT_IL_UNIT_FUND_REG_DTL_BEAN.setUFRD_UNIT_SEL_LC_AMT(resultSet
						.getDouble("UFRD_UNIT_SEL_LC_AMT"));
				PT_IL_UNIT_FUND_REG_DTL_BEAN
						.setUFRD_UNIT_TOT_LC_VALUE(resultSet
								.getDouble("UFRD_UNIT_TOT_LC_VALUE"));
				PT_IL_UNIT_FUND_REG_DTL_BEAN.setUFRD_CR_UID(resultSet
						.getString("UFRD_CR_UID"));
				PT_IL_UNIT_FUND_REG_DTL_BEAN.setUFRD_CR_DT(resultSet
						.getDate("UFRD_CR_DT"));
				PT_IL_UNIT_FUND_REG_DTL_BEAN.setUFRD_UPD_UID(resultSet
						.getString("UFRD_UPD_UID"));
				PT_IL_UNIT_FUND_REG_DTL_BEAN.setUFRD_UPD_DT(resultSet
						.getDate("UFRD_UPD_DT"));
				PT_IL_UNIT_FUND_REG_DTL_BEAN.setUFRD_UNIT_DATE(resultSet
						.getDate("UFRD_UNIT_DATE"));
				/*ADDED BY AMEEN ON 19-06-2017 FOR ZBILQC-1727874*/
				PT_IL_UNIT_FUND_REG_DTL_BEAN.setUI_M_UFRD_UNIT_DATE(resultSet
						.getString("UNIT_DATE"));
				PT_IL_UNIT_FUND_REG_DTL_BEAN.setUFRD_TOP_UP_UNITS(resultSet
						.getDouble("UFRD_TOP_UP_UNITS"));
				PT_IL_UNIT_FUND_REG_DTL_BEAN.setUFRD_PREM_UNITS(resultSet
						.getDouble("UFRD_PREM_UNITS"));
				PT_IL_UNIT_FUND_REG_DTL_BEAN.setUFRD_START_UNITS(resultSet
						.getDouble("UFRD_START_UNITS"));
				PT_IL_UNIT_FUND_REG_DTL_BEAN.setUFRD_START_UNIT_VALUE(resultSet
						.getDouble("UFRD_START_UNIT_VALUE"));

				new PT_IL_UNIT_FUND_REG_DTL_HELPER().postQuery(PILQ106_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_UNIT_FUND_REG_HDR_ACTION_BEAN().getPT_IL_UNIT_FUND_REG_HDR_BEAN(),
						PT_IL_UNIT_FUND_REG_DTL_BEAN);
				PILQ106_APAC_COMPOSITE_ACTION_BEAN
						.getPT_IL_UNIT_FUND_REG_DTL_ACTION_BEAN()
						.getDataList_PT_IL_UNIT_FUND_REG_DTL().add(
								PT_IL_UNIT_FUND_REG_DTL_BEAN);
			}
		} 
		catch (Exception e) {
		    // TODO: handle exception
		    e.printStackTrace();
		    throw new Exception(e.getMessage());
		}finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
