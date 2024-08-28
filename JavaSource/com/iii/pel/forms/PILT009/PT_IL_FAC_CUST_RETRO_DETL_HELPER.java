package com.iii.pel.forms.PILT009;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_FAC_CUST_RETRO_DETL_HELPER {

	public void fetchRecord(PT_IL_FAC_CUST_RETRO_DETL_ACTION custRetroDetlAction)
			throws Exception {
		custRetroDetlAction
				.setDataListPT_IL_FAC_CUST_RETRO_DETL(EXECUTE_QUERY(custRetroDetlAction
						.getPT_IL_FAC_CUST_RETRO_BEAN()));
		if (custRetroDetlAction.getDataListPT_IL_FAC_CUST_RETRO_DETL().size() > 0) {

			custRetroDetlAction.setPT_IL_FAC_CUST_RETRO_DETL_BEAN(custRetroDetlAction
							.getDataListPT_IL_FAC_CUST_RETRO_DETL().get(0));
			custRetroDetlAction.getPT_IL_FAC_CUST_RETRO_DETL_BEAN().setRowSelected(true);
		}
	}

	private List<PT_IL_FAC_CUST_RETRO_DETL> EXECUTE_QUERY(
			PT_IL_FAC_CUST_RETRO custRetroBean) throws Exception {

		Connection connection = null;
		ResultSet resultSet = null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();

		PT_IL_FAC_CUST_RETRO_DETL facPartCustBean = null;
		List<PT_IL_FAC_CUST_RETRO_DETL> list = null;
		try {
			connection = CommonUtils.getConnection();

			values = new Object[1];
			values[0] = custRetroBean.getFCR_SYS_ID();
			resultSet = handler.executeSelectStatement(
					PILT009_SQL_CONSTANTS.SELECT_PT_IL_FAC_CUST_RETRO_DETL,
					connection, values);

			list = new ArrayList<PT_IL_FAC_CUST_RETRO_DETL>();

			while (resultSet.next()) {
				facPartCustBean = new PT_IL_FAC_CUST_RETRO_DETL();

				facPartCustBean.setROWID(resultSet.getString(1));
				facPartCustBean.setFCRD_SYS_ID(resultSet.getDouble(2));
				facPartCustBean.setFCRD_FCR_SYS_ID(resultSet.getDouble(3));
				facPartCustBean.setFCRD_FD_SYS_ID(resultSet.getDouble(4));
				facPartCustBean.setFCRD_SA_CURR_CODE(resultSet.getString(5));
				facPartCustBean.setFCRD_FC_RETRO_SUM_ASSURED(resultSet
						.getDouble(6));
				facPartCustBean.setFCRD_LC_RETRO_SUM_ASSURED(resultSet
						.getDouble(7));
				facPartCustBean.setFCRD_FC_RETRO_PREM(resultSet.getDouble(8));
				facPartCustBean.setFCRD_LC_RETRO_PREM(resultSet.getDouble(9));
				facPartCustBean.setFCRD_FC_RETRO_COMM(resultSet.getDouble(10));
				facPartCustBean.setFCRD_LC_RETRO_COMM(resultSet.getDouble(11));
				facPartCustBean.setFCRD_FC_RETRO_TAX(resultSet.getDouble(12));
				facPartCustBean.setFCRD_LC_RETRO_TAX(resultSet.getDouble(13));
				facPartCustBean.setFCRD_SCHD_DT(resultSet.getDate(14));
				facPartCustBean.setFCRD_RETRO_CLOSE_YN(resultSet.getString(15));
				facPartCustBean.setFCRD_DEL_FLAG(resultSet.getString(16));
				facPartCustBean.setFCRD_CR_DT(resultSet.getDate(17));
				facPartCustBean.setFCRD_CR_UID(resultSet.getString(18));
				facPartCustBean.setFCRD_UPD_DT(resultSet.getDate(19));
				facPartCustBean.setFCRD_UPD_UID(resultSet.getString(20));
				facPartCustBean.setRowSelected(false);

				list.add(facPartCustBean);
			}

		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
		return list;
	}

}
