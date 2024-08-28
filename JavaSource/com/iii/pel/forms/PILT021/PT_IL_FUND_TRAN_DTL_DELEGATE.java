package com.iii.pel.forms.PILT021;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_FUND_TRAN_DTL_DELEGATE {
	public void executeSelectStatement(PILT021_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String selectStatement = "SELECT ROWID, PT_IL_FUND_TRAN_DTL.* FROM PT_IL_FUND_TRAN_DTL WHERE "
				+ "FTD_TRAN_SYS_ID = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
				.getDataList_PT_IL_FUND_TRAN_DTL().clear();
		try {
			if (compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
					.getDEFAULT_WHERE() != null) {
				selectStatement = selectStatement
						+ " AND "
						+ compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
								.getDEFAULT_WHERE();
			}
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getPT_IL_WITHDRAWAL_ACTION_BEAN()
							.getPT_IL_WITHDRAWAL_BEAN().getWD_SYS_ID() });
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
				 
				 PT_IL_FUND_TRAN_DTL_BEAN.setUI_M_FTD_FUND_DESC(
						 fundDesc(PT_IL_FUND_TRAN_DTL_BEAN.getFTD_FUND_CODE()));
				compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
						.getDataList_PT_IL_FUND_TRAN_DTL().add(
								PT_IL_FUND_TRAN_DTL_BEAN);
				
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	
	
	public String fundDesc(String fundCode) throws Exception{
		String fundDescription = null;
		Connection connection = null;
		ResultSet resultSet = null;
		String C1 = "SELECT FS_DESC FROM PM_IL_FUND_SETUP WHERE FS_CODE = ?";
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(C1, connection, new Object[]{fundCode});
			if(resultSet.next()){
				fundDescription = resultSet.getString(1);
			}
			CommonUtils.closeCursor(resultSet);
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return fundDescription;
		
	}

}
