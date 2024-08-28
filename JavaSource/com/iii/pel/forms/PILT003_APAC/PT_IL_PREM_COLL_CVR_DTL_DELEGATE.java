package com.iii.pel.forms.PILT003_APAC;

import java.sql.Connection;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import java.sql.ResultSet;

public class PT_IL_PREM_COLL_CVR_DTL_DELEGATE {
	public void executeSelectStatement(
			PILT003_APAC_COMPOSITE_ACTION PILT003_APAC_COMPOSITE_ACTION_BEAN)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_PREM_COLL_CVR_DTL.* FROM PT_IL_PREM_COLL_CVR_DTL " +
				"WHERE  PT_IL_PREM_COLL_CVR_DTL.PCCD_PC_SYS_ID = ? ";
		Connection connection = null;
		ResultSet resultSet = null;
		PILT003_APAC_COMPOSITE_ACTION_BEAN
				.getPT_IL_PREM_COLL_CVR_DTL_ACTION_BEAN()
				.getDataList_PT_IL_PREM_COLL_CVR_DTL().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[] {PILT003_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getPC_SYS_ID()});
			while (resultSet.next()) {
				PT_IL_PREM_COLL_CVR_DTL PT_IL_PREM_COLL_CVR_DTL_BEAN = new PT_IL_PREM_COLL_CVR_DTL();
				PT_IL_PREM_COLL_CVR_DTL_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_IL_PREM_COLL_CVR_DTL_BEAN.setPCCD_POL_SYS_ID(resultSet
						.getLong("PCCD_POL_SYS_ID"));
				PT_IL_PREM_COLL_CVR_DTL_BEAN.setPCCD_PC_SYS_ID(resultSet
						.getLong("PCCD_PC_SYS_ID"));
				PT_IL_PREM_COLL_CVR_DTL_BEAN.setPCCD_COVER_CODE(resultSet
						.getString("PCCD_COVER_CODE"));
				PT_IL_PREM_COLL_CVR_DTL_BEAN.setPCCD_FC_RISK_PREM_AMT(resultSet
						.getDouble("PCCD_FC_RISK_PREM_AMT"));
				PT_IL_PREM_COLL_CVR_DTL_BEAN.setPCCD_LC_RISK_PREM_AMT(resultSet
						.getDouble("PCCD_LC_RISK_PREM_AMT"));
				PT_IL_PREM_COLL_CVR_DTL_BEAN.setPCCD_FC_INV_PREM_AMT(resultSet
						.getDouble("PCCD_FC_INV_PREM_AMT"));
				PT_IL_PREM_COLL_CVR_DTL_BEAN.setPCCD_LC_INV_PREM_AMT(resultSet
						.getDouble("PCCD_LC_INV_PREM_AMT"));
				PT_IL_PREM_COLL_CVR_DTL_BEAN.setPCCD_FC_RISK_LOAD_AMT(resultSet
						.getDouble("PCCD_FC_RISK_LOAD_AMT"));
				PT_IL_PREM_COLL_CVR_DTL_BEAN.setPCCD_LC_RISK_LOAD_AMT(resultSet
						.getDouble("PCCD_LC_RISK_LOAD_AMT"));
				PT_IL_PREM_COLL_CVR_DTL_BEAN.setPCCD_FC_INV_LOAD_AMT(resultSet
						.getDouble("PCCD_FC_INV_LOAD_AMT"));
				PT_IL_PREM_COLL_CVR_DTL_BEAN.setPCCD_LC_INV_LOAD_AMT(resultSet
						.getDouble("PCCD_LC_INV_LOAD_AMT"));
				PT_IL_PREM_COLL_CVR_DTL_BEAN.setPCCD_FC_RISK_DISC_AMT(resultSet
						.getDouble("PCCD_FC_RISK_DISC_AMT"));
				PT_IL_PREM_COLL_CVR_DTL_BEAN.setPCCD_LC_RISK_DISC_AMT(resultSet
						.getDouble("PCCD_LC_RISK_DISC_AMT"));
				PT_IL_PREM_COLL_CVR_DTL_BEAN.setPCCD_FC_INV_DISC_AMT(resultSet
						.getDouble("PCCD_FC_INV_DISC_AMT"));
				PT_IL_PREM_COLL_CVR_DTL_BEAN.setPCCD_LC_INV_DISC_AMT(resultSet
						.getDouble("PCCD_LC_INV_DISC_AMT"));
				PT_IL_PREM_COLL_CVR_DTL_BEAN.setPCCD_CR_DT(resultSet
						.getDate("PCCD_CR_DT"));
				PT_IL_PREM_COLL_CVR_DTL_BEAN.setPCCD_CR_UID(resultSet
						.getString("PCCD_CR_UID"));
				PT_IL_PREM_COLL_CVR_DTL_BEAN.setPCCD_PROD_CODE(resultSet
						.getString("PCCD_PROD_CODE"));
				PT_IL_PREM_COLL_CVR_DTL_BEAN.setUI_M_PCCD_TOTAL_FC_CVR_PREM_INV(PT_IL_PREM_COLL_CVR_DTL_BEAN.getPCCD_FC_INV_PREM_AMT()+
						PT_IL_PREM_COLL_CVR_DTL_BEAN.getPCCD_FC_INV_LOAD_AMT()-PT_IL_PREM_COLL_CVR_DTL_BEAN.getPCCD_FC_INV_DISC_AMT());
				PT_IL_PREM_COLL_CVR_DTL_BEAN.setUI_M_PCCD_TOTAL_FC_CVR_PREM_RISK(PT_IL_PREM_COLL_CVR_DTL_BEAN.getPCCD_FC_RISK_PREM_AMT()+PT_IL_PREM_COLL_CVR_DTL_BEAN.getPCCD_FC_RISK_LOAD_AMT()-PT_IL_PREM_COLL_CVR_DTL_BEAN.getPCCD_FC_RISK_DISC_AMT());
				PT_IL_PREM_COLL_CVR_DTL_BEAN.setUI_M_PCCD_TOTAL_LC_CR_PREM_RISK(PT_IL_PREM_COLL_CVR_DTL_BEAN.getUI_M_PCCD_TOTAL_FC_CVR_PREM_RISK());
				PT_IL_PREM_COLL_CVR_DTL_BEAN.setUI_M_PCCD_TOTAL_LC_CVR_PREM_INV(PT_IL_PREM_COLL_CVR_DTL_BEAN.getUI_M_PCCD_TOTAL_FC_CVR_PREM_INV());
				
				PILT003_APAC_COMPOSITE_ACTION_BEAN
						.getPT_IL_PREM_COLL_CVR_DTL_ACTION_BEAN()
						.getDataList_PT_IL_PREM_COLL_CVR_DTL().add(
								PT_IL_PREM_COLL_CVR_DTL_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}