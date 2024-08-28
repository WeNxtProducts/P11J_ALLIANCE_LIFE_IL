package com.iii.pel.forms.PM102;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class AG_INCENTIVES_TRGT_STP_HELPER {

	public void executeQuery(PM102_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new AG_INCENTIVES_TRGT_STP_DELEGATE()
					.executeSelectStatement(compositeAction);

			List<AG_INCENTIVES_TRGT_STP> dataList = compositeAction
					.getAG_INCENTIVES_TRGT_STP_ACTION_BEAN()
					.getDataList_AG_INCENTIVES_TRGT_STP();
			if (dataList != null && dataList.size() > 0) {
				AG_INCENTIVES_TRGT_STP AG_INCENTIVES_TRGT_STP_BEAN = dataList
						.get(0);
				AG_INCENTIVES_TRGT_STP_BEAN.setRowSelected(true);
				compositeAction.getAG_INCENTIVES_TRGT_STP_ACTION_BEAN()
						.setAG_INCENTIVES_TRGT_STP_BEAN(
								AG_INCENTIVES_TRGT_STP_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void preUpdate(AG_INCENTIVES_TRGT_STP AG_INCENTIVES_TRGT_STP_BEAN)
			throws Exception {
		try {
			AG_INCENTIVES_TRGT_STP_BEAN.setOLD_UPD_DT(new CommonUtils()
					.getCurrentDate());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void postQuery(AG_INCENTIVES_TRGT_STP AG_INCENTIVES_TRGT_STP_BEAN) {

		String levelDescQry = "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'AG_INC_LEVEL' AND PC_CODE = ?";
		String modeDescQry = "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'AG_INC_PER' AND PC_CODE = ?";
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try {
			con = CommonUtils.getConnection();
			rs1 = handler
					.executeSelectStatement(levelDescQry, con,
							new Object[] { AG_INCENTIVES_TRGT_STP_BEAN
									.getTSD_LEVEL() });
			if (rs1.next()) {
				AG_INCENTIVES_TRGT_STP_BEAN.setTSD_LEVEL_DESC(rs1.getString(1));
			}
			rs2 = handler.executeSelectStatement(modeDescQry, con,
					new Object[] { AG_INCENTIVES_TRGT_STP_BEAN.getTSD_MODE() });
			if (rs2.next()) {
				AG_INCENTIVES_TRGT_STP_BEAN.setTSD_MODE_DESC(rs2.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
