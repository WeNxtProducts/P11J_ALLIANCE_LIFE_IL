package com.iii.pel.forms.PILP053_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PW_IL_REVIEW_MED_DTL_HELPER {

	public void executeQuery(PILP053_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PW_IL_REVIEW_MED_DTL_DELEGATE()
					.executeSelectStatement(compositeAction);
			List<PW_IL_REVIEW_MED_DTL> dataList = compositeAction
					.getPW_IL_REVIEW_MED_DTL_ACTION_BEAN()
					.getDataList_PW_IL_REVIEW_MED_DTL();
			if (dataList != null && dataList.size() > 0) {
				PW_IL_REVIEW_MED_DTL PW_IL_REVIEW_MED_DTL_BEAN = dataList
						.get(0);
				PW_IL_REVIEW_MED_DTL_BEAN.setRowSelected(true);
				compositeAction
						.getPW_IL_REVIEW_MED_DTL_ACTION_BEAN()
						.setPW_IL_REVIEW_MED_DTL_BEAN(PW_IL_REVIEW_MED_DTL_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void POST_QUERY(PILP053_APAC_COMPOSITE_ACTION compositeAction)throws Exception {
		String C1 = null;
		Connection connection = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			C1 = "SELECT COVER_DESC " + "FROM   PM_IL_COVER "
					+ "WHERE  COVER_CODE = ?";
			rs = handler
					.executeSelectStatement(C1, connection,
							new Object[] { compositeAction
									.getPW_IL_REVIEW_MED_DTL_ACTION_BEAN()
									.getPW_IL_REVIEW_MED_DTL_BEAN()
									.getRMD_COVER_CODE() });
			while (rs.next()) {
				compositeAction
						.getPW_IL_REVIEW_MED_DTL_ACTION_BEAN()
						.getPW_IL_REVIEW_MED_DTL_BEAN()
						.setUI_M_RMD_COVER_CODE_DESC(rs.getString("COVER_DESC"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
