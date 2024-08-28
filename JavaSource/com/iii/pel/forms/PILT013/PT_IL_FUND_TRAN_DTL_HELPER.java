package com.iii.pel.forms.PILT013;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_FUND_TRAN_DTL_HELPER {

	CRUDHandler handler = new CRUDHandler();

	public void POST_QUERY(PILT013_COMPOSITE_ACTION compositeAction)
			throws Exception {
		CRUDHandler handler = new CRUDHandler();
		PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl_bean = compositeAction
				.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
				.getPT_IL_FUND_TRAN_DTL_BEAN();
		Connection con = null;
		ResultSet rs = null;
		String M_FS_DESC = null;
		String C1 = "SELECT FS_DESC FROM   PM_IL_FUND_SETUP WHERE  FS_CODE = ?";
		try {
			con=CommonUtils.getConnection();
			rs = handler
					.executeSelectStatement(C1, con,
							new Object[] { pt_il_fund_tran_dtl_bean
									.getFTD_FUND_CODE() });
			while (rs.next()) {
				M_FS_DESC = rs.getString(1);
			}
			pt_il_fund_tran_dtl_bean.setUI_M_FTD_FUND_DESC(M_FS_DESC);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void WHEN_NEW_BLOCK_INSTANCE(PILT013_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		Connection con = null;
		ResultSet rs = null;
		String M_PLAN_TYPE = null;
		String C1 = "SELECT PLAN_TYPE FROM PM_IL_PLAN "
				+ "WHERE  NVL(PLAN_FRZ_FLAG,'N') = 'N' "
				+ "AND PLAN_CODE = (SELECT POL_PLAN_CODE FROM PT_IL_POLICY "
				+ "WHERE  POL_NO = ? " + "AND    POL_DS_TYPE = '2')";
		/*
		 * CURSOR C2 IS SELECT COUNT(*) FROM PT_IL_FUND_TRAN_DTL WHERE
		 * FTD_TRAN_TYPE='S' AND
		 * FTD_POL_SYS_ID=pt_il_policy_bean.getPOL_SYS_ID() AND
		 * FTD_TRAN_SYS_ID=pt_il_policy_bean.getPOL_SYS_ID();
		 */

		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(C1, con,
					new Object[] { pt_il_policy_bean.getPOL_NO() });
			if(rs.next()){
				M_PLAN_TYPE = rs.getString(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void executeQuery(PILT013_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_IL_FUND_TRAN_DTL_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PT_IL_FUND_TRAN_DTL> dataList = compositeAction
				.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
				.getDataList_PT_IL_FUND_TRAN_DTL();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_FUND_TRAN_DTL PT_IL_FUND_TRAN_DTL_BEAN = dataList.get(0);
			PT_IL_FUND_TRAN_DTL_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_FUND_TRAN_DTL_ACTION_BEAN()
					.setPT_IL_FUND_TRAN_DTL_BEAN(PT_IL_FUND_TRAN_DTL_BEAN);
		}
	}

}
