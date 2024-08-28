package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_FUND_TRAN_DTL_HELPER {
	public void executeQuery(PT_IL_FUND_TRAN_DTL_ACTION fundTranDtlAction) throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		String FUND_TRAN_DTL_EXE_QUERY_CURSOR_C1 = "SELECT ROWID, PT_IL_FUND_TRAN_DTL.* FROM PT_IL_FUND_TRAN_DTL WHERE ";      
		CRUDHandler handler = new CRUDHandler();
		PT_IL_FUND_TRAN_DTL fundTranDtlBean = null;
		
		try {
			// Clear old data
			fundTranDtlAction.getDataList_PT_IL_FUND_TRAN_DTL().clear();
			fundTranDtlAction.setUI_M_TOTAL_LC_VALUE(0.0d);
			
			connection = CommonUtils.getConnection();
			if(fundTranDtlAction.getDEFAULT_WHERE() != null){
				FUND_TRAN_DTL_EXE_QUERY_CURSOR_C1 = FUND_TRAN_DTL_EXE_QUERY_CURSOR_C1 
					+ fundTranDtlAction.getDEFAULT_WHERE();
			}
			resultSet = handler.executeSelectStatement(FUND_TRAN_DTL_EXE_QUERY_CURSOR_C1, connection);
			while(resultSet.next()){
				fundTranDtlBean = new PT_IL_FUND_TRAN_DTL();
				fundTranDtlBean.setROWID(resultSet.getString("ROWID"));
				fundTranDtlBean.setFTD_SYS_ID(resultSet.getLong("FTD_SYS_ID"));
				fundTranDtlBean.setFTD_TRAN_SYS_ID(resultSet.getLong("FTD_TRAN_SYS_ID"));
				fundTranDtlBean.setFTD_POL_SYS_ID(resultSet.getLong("FTD_POL_SYS_ID"));
				fundTranDtlBean.setFTD_TRAN_TYPE(resultSet.getString("FTD_TRAN_TYPE"));
				fundTranDtlBean.setFTD_TRAN_FLAG(resultSet.getString("FTD_TRAN_FLAG"));
				fundTranDtlBean.setFTD_FUND_CODE(resultSet.getString("FTD_FUND_CODE"));
				fundTranDtlBean.setFTD_FUND_PERC(resultSet.getDouble("FTD_FUND_PERC"));
				fundTranDtlBean.setFTD_NO_OF_UNITS(resultSet.getDouble("FTD_NO_OF_UNITS"));
				fundTranDtlBean.setFTD_UNIT_PUR_PRICE(resultSet.getDouble("FTD_UNIT_PUR_PRICE"));
				fundTranDtlBean.setFTD_UNIT_SEL_PRICE(resultSet.getDouble("FTD_UNIT_SEL_PRICE"));
				fundTranDtlBean.setFTD_UNIT_LC_AMT(resultSet.getDouble("FTD_UNIT_LC_AMT"));
				fundTranDtlBean.setFTD_SELECT_YN(resultSet.getString("FTD_SELECT_YN"));
				fundTranDtlBean.setFTD_NO_SEL_UNITS(resultSet.getDouble("FTD_NO_SEL_UNITS"));
				fundTranDtlBean.setFTD_NO_ALLOC_LC_AMT(resultSet.getDouble("FTD_NO_ALLOC_LC_AMT"));
				fundTranDtlBean.setFTD_CR_UID(resultSet.getString("FTD_CR_UID"));
				fundTranDtlBean.setFTD_CR_DT(resultSet.getDate("FTD_CR_DT"));
				fundTranDtlBean.setFTD_UPD_UID(resultSet.getString("FTD_UPD_UID"));
				fundTranDtlBean.setFTD_UPD_DT(resultSet.getDate("FTD_UPD_DT"));
				fundTranDtlBean.setFTD_TOP_UP_UNITS(resultSet.getDouble("FTD_TOP_UP_UNITS"));
				fundTranDtlBean.setFTD_PREM_UNITS(resultSet.getDouble("FTD_PREM_UNITS"));
				fundTranDtlBean.setFTD_TOP_UP_SEL_UNITS(resultSet.getDouble("FTD_TOP_UP_SEL_UNITS"));
				fundTranDtlBean.setFTD_PREM_SEL_UNITS(resultSet.getDouble("FTD_PREM_SEL_UNITS"));
				fundTranDtlBean.setFTD_UNIT_TYPE(resultSet.getString("FTD_UNIT_TYPE"));
				fundTranDtlBean.setFTD_BEF_SWT_PERC(resultSet.getDouble("FTD_BEF_SWT_PERC"));
				fundTranDtlBean.setFTD_WITHDRAWAL_BY(resultSet.getString("FTD_WITHDRAWAL_BY"));
				
				fundTranDtlAction.setUI_M_TOTAL_LC_VALUE(
						fundTranDtlAction.getUI_M_TOTAL_LC_VALUE() + fundTranDtlBean.getFTD_UNIT_LC_AMT());
				fundTranDtlAction.getDataList_PT_IL_FUND_TRAN_DTL().add(fundTranDtlBean);
			}
			
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
	}
	
	public void postQuery(PT_IL_FUND_TRAN_DTL fundTranDtlBean) throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		String FUND_TRAN_DTL_EXE_QUERY_CURSOR_C1 = "SELECT FS_DESC "
			+ "FROM PM_IL_FUND_SETUP "
			+ "WHERE FS_CODE = ?";       
		CRUDHandler handler = new CRUDHandler();
		Object[] values = null;
		
		try {
			connection = CommonUtils.getConnection();
			values = new Object[]{fundTranDtlBean.getFTD_FUND_CODE()};
			resultSet = handler.executeSelectStatement(FUND_TRAN_DTL_EXE_QUERY_CURSOR_C1, 
					connection, values);
			if(resultSet.next()){
				fundTranDtlBean.setFTD_FUND_CODE_DESC(resultSet.getString(1));
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
	}	

	public void whenNewBlockInstance(PT_IL_CLAIM claimBean, 
			PT_IL_FUND_TRAN_DTL_ACTION fundTransferDtlAction) throws Exception {
		/*Connection connection = null;
		ResultSet resultSet = null;
		String WNBS_FUND_TRAN_DTL_CURSOR_C1 = "SELECT PLAN_TYPE "      
			+ "FROM   PM_IL_PLAN "
			+ "WHERE  NVL(PLAN_FRZ_FLAG,'N') = 'N' "
			+ "AND    PLAN_CODE = (SELECT POL_PLAN_CODE " 
                           + "FROM   PT_IL_POLICY " 
                           + "WHERE  POL_NO = ? "  
                           + "AND    POL_DS_TYPE = '2')";
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		String M_PLAN_TYPE = null;
		
		try {
			connection = CommonUtils.getConnection();
			values = new Object[]{claimBean.getCLAIM_POL_NO()};
			resultSet = handler.executeSelectStatement(WNBS_FUND_TRAN_DTL_CURSOR_C1, 
					connection, values);
			if(resultSet.next()){
				M_PLAN_TYPE = resultSet.getString(1);
			}*/
			
			if(claimBean.getCLAIM_POL_NO() != null){
				fundTransferDtlAction.setDEFAULT_WHERE(" FTD_POL_SYS_ID = "+claimBean.getCLAIM_POL_SYS_ID()
						+" AND FTD_TRAN_TYPE='C' AND  FTD_TRAN_SYS_ID = "+claimBean.getCLAIM_SYS_ID());
			}
		/*} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}*/
	}

}
