package com.iii.pel.forms.PILT003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;



public class PT_IL_LOAN_INT_COLL_HELPER {
	
	public void executeQuery(PILT003_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PT_IL_LOAN_INT_COLL_DELEGATE()
					.executeSelectStatement(compositeAction);
			if (compositeAction.getPT_IL_LOAN_INT_COLL_ACTION_BEAN()
					.getDataList_PT_IL_LOAN_INT_COLL().size() > 0) {
				compositeAction
						.getPT_IL_LOAN_INT_COLL_ACTION_BEAN()
						.setPT_IL_LOAN_INT_COLL_BEAN(
								compositeAction
										.getPT_IL_LOAN_INT_COLL_ACTION_BEAN()
										.getDataList_PT_IL_LOAN_INT_COLL()
										.get(0));
				compositeAction.getPT_IL_LOAN_INT_COLL_ACTION_BEAN()
						.getPT_IL_LOAN_INT_COLL_BEAN().setRowSelected(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void POST_QUERY(PT_IL_LOAN_INT_COLL PT_IL_LOAN_INT_COLL_BEAN) throws Exception{
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			String C2 ="SELECT LOAN_DT, LOAN_CURR_CODE, LOAN_EXCH_RATE FROM   PT_IL_LOAN WHERE  " +
					"LOAN_SYS_ID = ?";
			Object[] c1values = {PT_IL_LOAN_INT_COLL_BEAN.getLIC_LOAN_SYS_ID()};
			resultSet = handler.executeSelectStatement(C2, connection, c1values);
			if(resultSet.next()){
				PT_IL_LOAN_INT_COLL_BEAN.setUI_M_LOAN_DT(resultSet.getDate(1));
				PT_IL_LOAN_INT_COLL_BEAN.setUI_M_LOAN_CURR_CODE(resultSet.getString(2));
				PT_IL_LOAN_INT_COLL_BEAN.setUI_M_LOAN_EXCH_RATE(resultSet.getDouble(3));
			}
			  /* L_CHECK_LOAN_DTLS;
			   L_SHOW_LOAN_DTLS;
			P_SET_FC_NUM_FMT_MASK(:PT_IL_POLICY.POL_CUST_CURR_CODE ); */
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void WHEN_NEW_BLOCK_INSTANCE(PT_IL_LOAN_INT_COLL PT_IL_LOAN_INT_COLL_BEAN) throws Exception{
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			String C2 ="SELECT LOAN_DT, LOAN_CURR_CODE, LOAN_EXCH_RATE FROM   PT_IL_LOAN WHERE  " +
					"LOAN_SYS_ID = ?";
			Object[] c1values = {PT_IL_LOAN_INT_COLL_BEAN.getLIC_LOAN_SYS_ID()};
			resultSet = handler.executeSelectStatement(C2, connection, c1values);
			if(resultSet.next()){
				PT_IL_LOAN_INT_COLL_BEAN.setUI_M_LOAN_DT(resultSet.getDate(1));
				PT_IL_LOAN_INT_COLL_BEAN.setUI_M_LOAN_CURR_CODE(resultSet.getString(2));
				PT_IL_LOAN_INT_COLL_BEAN.setUI_M_LOAN_EXCH_RATE(resultSet.getDouble(3));
			}
			  // L_CHECK_LOAN_DTLS;
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage()); 
		}
	}
	public void PRE_UPDATE(PT_IL_LOAN_INT_COLL PT_IL_LOAN_INT_COLL_BEAN) throws Exception{
		try {
			PT_IL_LOAN_INT_COLL_BEAN.setLIC_UPD_DT(new CommonUtils().getCurrentDate());
			PT_IL_LOAN_INT_COLL_BEAN.setLIC_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
			PT_IL_LOAN_INT_COLL_BEAN.setUI_M_FC_LOAN_INT(PT_IL_LOAN_INT_COLL_BEAN.getLIC_FC_INT_AMT());
			PT_IL_LOAN_INT_COLL_BEAN.setUI_M_LC_LOAN_INT(PT_IL_LOAN_INT_COLL_BEAN.getLIC_LC_INT_AMT());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
}

