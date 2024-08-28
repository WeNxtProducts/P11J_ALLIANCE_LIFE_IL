package com.iii.pel.forms.PILT003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PREM_COLL_CVR_DTL_HELPER {
	
	public void executeQuery(PILT003_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PT_IL_PREM_COLL_CVR_DTL_DELEGATE()
					.executeSelectStatement(compositeAction);
			if (compositeAction.getPT_IL_PREM_COLL_CVR_DTL_ACTION_BEAN()
					.getDataList_PT_IL_PREM_COLL_CVR_DTL().size() > 0) {
				compositeAction.getPT_IL_PREM_COLL_CVR_DTL_ACTION_BEAN()
						.setPT_IL_PREM_COLL_CVR_DTL_BEAN(
								compositeAction
										.getPT_IL_PREM_COLL_CVR_DTL_ACTION_BEAN()
										.getDataList_PT_IL_PREM_COLL_CVR_DTL().get(0));
				compositeAction.getPT_IL_PREM_COLL_CVR_DTL_ACTION_BEAN()
						.getPT_IL_PREM_COLL_CVR_DTL_BEAN().setRowSelected(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void POST_QUERY(PT_IL_PREM_COLL_CVR_DTL PT_IL_PREM_COLL_CVR_DTL_BEAN) throws Exception {
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			String M_COVER_DESC = null;

			String C1 = "SELECT COVER_DESC FROM   PM_IL_COVER"
					+ " WHERE  COVER_CODE = ?";
			Object[] c1values = { PT_IL_PREM_COLL_CVR_DTL_BEAN
					.getPCCD_COVER_CODE() };
			resultSet = handler
					.executeSelectStatement(C1, connection, c1values);

			if (PT_IL_PREM_COLL_CVR_DTL_BEAN.getPCCD_COVER_CODE() != null) {
				if (resultSet.next()) {
					M_COVER_DESC = resultSet.getString(1);
				}
				PT_IL_PREM_COLL_CVR_DTL_BEAN
						.setUI_M_PCCD_COVER_DESC(M_COVER_DESC);
			} else {
				PT_IL_PREM_COLL_CVR_DTL_BEAN.setUI_M_PCCD_COVER_DESC(null);
			}
			//P_SET_FC_NUM_FMT_MASK(:PT_IL_POLICY.POL_CUST_CURR_CODE ); 
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void WHEN_VALIDATE_PCCD_COVER_CODE(
			PT_IL_PREM_COLL_CVR_DTL PT_IL_PREM_COLL_CVR_DTL_BEAN) throws Exception {
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			String C1 = "SELECT COVER_DESC FROM   PM_IL_COVER WHERE  COVER_CODE = ?";
			String M_COVER_DESC = null;

			if (PT_IL_PREM_COLL_CVR_DTL_BEAN.getPCCD_COVER_CODE() != null) {
				Object[] c1values = { PT_IL_PREM_COLL_CVR_DTL_BEAN
						.getPCCD_COVER_CODE() };
				resultSet = handler.executeSelectStatement(C1, connection,
						c1values);
				if (resultSet.next()) {
					M_COVER_DESC = resultSet.getString(1);
				}
				PT_IL_PREM_COLL_CVR_DTL_BEAN
						.setUI_M_PCCD_COVER_DESC(M_COVER_DESC);
			} else {
				PT_IL_PREM_COLL_CVR_DTL_BEAN.setUI_M_PCCD_COVER_DESC(null);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}
