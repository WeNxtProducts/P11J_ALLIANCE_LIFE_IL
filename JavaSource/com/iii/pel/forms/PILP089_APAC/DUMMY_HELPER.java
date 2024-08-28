package com.iii.pel.forms.PILP089_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;



public class DUMMY_HELPER {
	
	/**
	 * 
	 * @throws Exception
	 */
	public void whenNewRecordInstance() throws Exception{
		
		String C1 = "SELECT NVL(AS_MOD_ACC_FLAG_YN,'N')	FROM   PM_APPR_SETUP WHERE  AS_USER_ID = ? ";
		CRUDHandler handler = null;
		Connection connection = null;
		ResultSet C1_REC = null;
		String M_FLAG=null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			String userId = CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
			C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{userId});
			if(C1_REC.next()){
				M_FLAG = C1_REC.getString(1);
			}
		}catch(Exception exception){
			throw exception;
		}finally{
			CommonUtils.closeCursor(C1_REC);
		}
	}
	
	
	public void when_validate_item_M_ACNT_YEAR_FM(DUMMY DUMMY_BEAN)throws Exception{
		String C1 = " SELECT CAY_FRM_DT,CAY_TO_DT " +
				"  FROM FM_COMP_ACNT_YEAR" +
				" WHERE   CAY_ACNT_YEAR = ?";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try{
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection,new Object[]{DUMMY_BEAN.getUI_M_ACNT_YEAR_FM()});
			if(resultSet.next()){
				DUMMY_BEAN.setUI_M_ACNT_FM_DATE_1(resultSet.getDate(1));
				DUMMY_BEAN.setUI_M_ACNT_TO_DATE_1(resultSet.getDate(2));
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}
	
	public void when_validate_item_M_ACNT_YEAR_TO(DUMMY DUMMY_BEAN)throws Exception{
		String C1 = " SELECT CAY_FRM_DT,CAY_TO_DT " +
				"  FROM FM_COMP_ACNT_YEAR " +
				" WHERE   CAY_ACNT_YEAR = ? ";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try{
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection,new Object[]{DUMMY_BEAN.getUI_M_ACNT_YEAR_TO()});
			if(resultSet.next()){
				DUMMY_BEAN.setUI_M_ACNT_FM_DATE_2(resultSet.getDate(1));
				DUMMY_BEAN.setUI_M_ACNT_TO_DATE_2(resultSet.getDate(2));
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
	}
	
	
	public void executeQuery(PILP089_APAC_COMPOSITE_ACTION compositeAction){
		String query = "SELECT * FROM PW_IL_PA_PROFIT";
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		try{
			resultSet = handler.executeSelectStatement(query, CommonUtils.getConnection());
			
			while(resultSet.next()){
				PW_IL_PA_PROFIT PW_IL_PA_PROFIT_BEAN = new PW_IL_PA_PROFIT();
				PW_IL_PA_PROFIT_BEAN.setPP_POL_NO(resultSet.getString("PP_POL_NO"));
				PW_IL_PA_PROFIT_BEAN.setPP_POL_PROD_CODE(resultSet.getString("PP_POL_PROD_CODE"));
				PW_IL_PA_PROFIT_BEAN.setPP_POL_PLAN_CODE(resultSet.getString("PP_POL_PLAN_CODE"));
				PW_IL_PA_PROFIT_BEAN.setPP_POL_APPRV_DT(resultSet.getDate("PP_POL_APPRV_DT"));
				PW_IL_PA_PROFIT_BEAN.setPP_POL_SYS_ID(resultSet.getLong("PP_POL_SYS_ID"));
				PW_IL_PA_PROFIT_BEAN.setPP_PROCESS_YN(resultSet.getString("PP_PROCESS_YN"));
				PW_IL_PA_PROFIT_BEAN.setPP_POL_END_NO(resultSet.getString("PP_POL_END_NO"));
				compositeAction.getPW_IL_PA_PROFIT_ACTION_BEAN().getDataList_PW_IL_PA_PROFIT().add(PW_IL_PA_PROFIT_BEAN);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}

