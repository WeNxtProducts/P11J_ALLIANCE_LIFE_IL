package com.iii.pel.forms.PILT013;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_FUND_TRAN_DTL_DELEGATE {
	public void executeSelectStatement(
			PILT013_COMPOSITE_ACTION PILT013_COMPOSITE_ACTION_BEAN)
			throws Exception {
		PT_IL_POLICY  pt_il_policy_bean = PILT013_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
//		String selectStatement = "SELECT ROWID, PT_IL_FUND_TRAN_DTL.* FROM PT_IL_FUND_TRAN_DTL WHERE ";
		String selectStatement = "SELECT PT_IL_FUND_TRAN_DTL.ROWID, PT_IL_FUND_TRAN_DTL.* FROM PT_IL_FUND_TRAN_DTL, PT_IL_SURR_MAT_VALUES, PT_IL_POLICY " +
		"WHERE PT_IL_FUND_TRAN_DTL.FTD_POL_SYS_ID=PT_IL_SURR_MAT_VALUES.SMV_POL_SYS_ID AND " +
		//"PT_IL_FUND_TRAN_DTL.FTD_TRAN_TYPE=PT_IL_SURR_MAT_VALUES.SMV_TYPE AND " +
		"PT_IL_FUND_TRAN_DTL.FTD_TRAN_SYS_ID =PT_IL_SURR_MAT_VALUES.SMV_SYS_ID " +
		"AND PT_IL_SURR_MAT_VALUES.SMV_POL_SYS_ID = PT_IL_POLICY.POL_SYS_ID " +
		"AND NVL(SMV_STATUS_CODE,'X') <> 'R' AND POL_SYS_ID = ?";

		
		Connection connection = null;
		ResultSet resultSet = null;
		PILT013_COMPOSITE_ACTION_BEAN.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
				.getDataList_PT_IL_FUND_TRAN_DTL().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[]{pt_il_policy_bean.getPOL_SYS_ID()});
			while (resultSet.next()) {
				PT_IL_FUND_TRAN_DTL PT_IL_FUND_TRAN_DTL_BEAN = new PT_IL_FUND_TRAN_DTL();
				PT_IL_FUND_TRAN_DTL_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_IL_FUND_TRAN_DTL_BEAN.setFTD_SYS_ID(resultSet
						.getLong("FTD_SYS_ID"));
				PT_IL_FUND_TRAN_DTL_BEAN.setFTD_TRAN_SYS_ID(resultSet
						.getLong("FTD_TRAN_SYS_ID"));
				PT_IL_FUND_TRAN_DTL_BEAN.setFTD_POL_SYS_ID(resultSet
						.getLong("FTD_POL_SYS_ID"));
				PT_IL_FUND_TRAN_DTL_BEAN.setFTD_TRAN_TYPE(resultSet
						.getString("FTD_TRAN_TYPE"));
				PT_IL_FUND_TRAN_DTL_BEAN.setFTD_TRAN_FLAG(resultSet
						.getString("FTD_TRAN_FLAG"));
				PT_IL_FUND_TRAN_DTL_BEAN.setFTD_FUND_CODE(resultSet
						.getString("FTD_FUND_CODE"));
				PT_IL_FUND_TRAN_DTL_BEAN.setFTD_FUND_PERC(resultSet
						.getDouble("FTD_FUND_PERC"));
				PT_IL_FUND_TRAN_DTL_BEAN.setFTD_NO_OF_UNITS(resultSet
						.getDouble("FTD_NO_OF_UNITS"));
				PT_IL_FUND_TRAN_DTL_BEAN.setFTD_UNIT_PUR_PRICE(resultSet
						.getDouble("FTD_UNIT_PUR_PRICE"));
				PT_IL_FUND_TRAN_DTL_BEAN.setFTD_UNIT_SEL_PRICE(resultSet
						.getDouble("FTD_UNIT_SEL_PRICE"));
				PT_IL_FUND_TRAN_DTL_BEAN.setFTD_UNIT_LC_AMT(resultSet
						.getDouble("FTD_UNIT_LC_AMT"));
				PT_IL_FUND_TRAN_DTL_BEAN.setFTD_SELECT_YN(resultSet
						.getString("FTD_SELECT_YN"));
				PT_IL_FUND_TRAN_DTL_BEAN.setFTD_NO_SEL_UNITS(resultSet
						.getDouble("FTD_NO_SEL_UNITS"));
				PT_IL_FUND_TRAN_DTL_BEAN.setFTD_NO_ALLOC_LC_AMT(resultSet
						.getDouble("FTD_NO_ALLOC_LC_AMT"));
				PT_IL_FUND_TRAN_DTL_BEAN.setFTD_CR_UID(resultSet
						.getString("FTD_CR_UID"));
				PT_IL_FUND_TRAN_DTL_BEAN.setFTD_CR_DT(resultSet
						.getDate("FTD_CR_DT"));
				PT_IL_FUND_TRAN_DTL_BEAN.setFTD_UPD_UID(resultSet
						.getString("FTD_UPD_UID"));
				PT_IL_FUND_TRAN_DTL_BEAN.setFTD_UPD_DT(resultSet
						.getDate("FTD_UPD_DT"));
				PT_IL_FUND_TRAN_DTL_BEAN.setFTD_TOP_UP_UNITS(resultSet
						.getDouble("FTD_TOP_UP_UNITS"));
				PT_IL_FUND_TRAN_DTL_BEAN.setFTD_PREM_UNITS(resultSet
						.getDouble("FTD_PREM_UNITS"));
				PT_IL_FUND_TRAN_DTL_BEAN.setFTD_TOP_UP_SEL_UNITS(resultSet
						.getDouble("FTD_TOP_UP_SEL_UNITS"));
				PT_IL_FUND_TRAN_DTL_BEAN.setFTD_PREM_SEL_UNITS(resultSet
						.getDouble("FTD_PREM_SEL_UNITS"));
				PT_IL_FUND_TRAN_DTL_BEAN.setFTD_UNIT_TYPE(resultSet
						.getString("FTD_UNIT_TYPE"));
				PT_IL_FUND_TRAN_DTL_BEAN.setFTD_BEF_SWT_PERC(resultSet
						.getDouble("FTD_BEF_SWT_PERC"));
				PT_IL_FUND_TRAN_DTL_BEAN.setFTD_WITHDRAWAL_BY(resultSet
						.getString("FTD_WITHDRAWAL_BY"));

				PILT013_COMPOSITE_ACTION_BEAN
						.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
						.getDataList_PT_IL_FUND_TRAN_DTL().add(
								PT_IL_FUND_TRAN_DTL_BEAN);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

}
