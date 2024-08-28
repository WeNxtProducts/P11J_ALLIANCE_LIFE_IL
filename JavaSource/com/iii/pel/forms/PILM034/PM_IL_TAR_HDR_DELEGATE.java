package com.iii.pel.forms.PILM034;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_TAR_HDR_DELEGATE {
	public void executeSelectStatement(
			PILM034_COMPOSITE_ACTION PILM034_COMPOSITE_ACTION_BEAN)
			throws Exception {

		Connection connection = null;
		ResultSet resultSet = null;
		String selectStatement = "SELECT ROWID, PM_IL_TAR_HDR.* FROM PM_IL_TAR_HDR "
				+ "WHERE PM_IL_TAR_HDR.ROWID= ? ";

		PILM034_COMPOSITE_ACTION_BEAN.getPM_IL_TAR_HDR_ACTION_BEAN()
				.getDataList().clear();
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[] { PILM034_COMPOSITE_ACTION_BEAN
							.getPM_IL_TAR_HDR_ACTION_BEAN()
							.getPM_IL_TAR_HDR_BEAN().getROWID() });
			while (resultSet.next()) {
				PM_IL_TAR_HDR PM_IL_TAR_HDR_BEAN = new PM_IL_TAR_HDR();
				PM_IL_TAR_HDR_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_IL_TAR_HDR_BEAN.setTH_BL_DESC(resultSet
						.getString("th_bl_desc"));
				PM_IL_TAR_HDR_BEAN.setTH_CODE(resultSet.getString("th_code"));
				PM_IL_TAR_HDR_BEAN.setTH_DESC(resultSet.getString("th_desc"));
				PM_IL_TAR_HDR_BEAN.setTH_EFF_FM_DT(resultSet
						.getDate("th_eff_fm_dt"));
				PM_IL_TAR_HDR_BEAN.setTH_EFF_TO_DT(resultSet
						.getDate("th_eff_to_dt"));
				PM_IL_TAR_HDR_BEAN
						.setTH_PARA_01(resultSet.getInt("th_para_01"));
				PM_IL_TAR_HDR_BEAN
						.setTH_PARA_02(resultSet.getInt("th_para_02"));
				PM_IL_TAR_HDR_BEAN
						.setTH_PARA_03(resultSet.getInt("th_para_03"));
				PM_IL_TAR_HDR_BEAN
						.setTH_PARA_04(resultSet.getInt("th_para_04"));
				PM_IL_TAR_HDR_BEAN
						.setTH_PARA_05(resultSet.getInt("th_para_05"));
				PM_IL_TAR_HDR_BEAN
						.setTH_PARA_06(resultSet.getInt("th_para_06"));
				PM_IL_TAR_HDR_BEAN
						.setTH_PARA_07(resultSet.getInt("th_para_07"));
				PM_IL_TAR_HDR_BEAN
						.setTH_PARA_08(resultSet.getInt("th_para_08"));
				PM_IL_TAR_HDR_BEAN
						.setTH_PARA_09(resultSet.getInt("th_para_09"));
				PM_IL_TAR_HDR_BEAN
						.setTH_PARA_10(resultSet.getInt("th_para_10"));
				PM_IL_TAR_HDR_BEAN.setTH_PARAM_TYPE(resultSet
						.getString("th_param_type"));
				PM_IL_TAR_HDR_BEAN.setTH_RATE_PER(resultSet
						.getInt("th_rate_per"));
				// PM_IL_TAR_HDR_BEAN.setUI_M_TH_CODE(resultSet.getString("th_desc"));
				PM_IL_TAR_HDR_BEAN.setTH_CR_DT(resultSet.getDate("th_cr_dt"));
				PM_IL_TAR_HDR_BEAN.setTH_CR_UID(resultSet
						.getString("th_cr_uid"));
				PILM034_COMPOSITE_ACTION_BEAN.getPM_IL_TAR_HDR_ACTION_BEAN()
						.getDataList().add(PM_IL_TAR_HDR_BEAN);
			}
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	/**
	 * Generic method to populate lov's
	 * 
	 * @param query
	 * @param values
	 * @return ArrayList<LovBean>
	 * @throws Exception
	 */
	public ArrayList<LovBean> populateLovs(String query, Object values[])
			throws Exception {
		
		System.out.println("values       "+values+"     query      "+query);
		ArrayList<LovBean> list = null;
		ResultSet resultSet = null;
		Connection connection = null;

		LovBean lovbean = null;
		PreparedStatement statement = null;
		try {
			connection = CommonUtils.getConnection();
			if (connection != null) {
				statement = connection.prepareStatement(query);
				if (values.length > 0 && values != null) {
					for (int index = 1; index <= values.length; index++) {
						statement.setObject(index, values[index-1]);
					}
				}
			}
			resultSet = statement.executeQuery();
			list = new ArrayList<LovBean>();
			while (resultSet.next()) {
				lovbean = new LovBean();
				lovbean.setCode(resultSet.getString(1));
				lovbean.setName(resultSet.getString(2));
				list.add(lovbean);
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
