package com.iii.pel.forms.PILT009;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_FAC_CUST_RETRO_HELPER {

	public void fetchRecord(PT_IL_FAC_CUST_RETRO_ACTION facCustRetroAction) throws Exception {

		facCustRetroAction.setDataListPT_IL_FAC_CUST_RETRO(EXECUTE_QUERY(facCustRetroAction.getPT_IL_FAC_OUT_BEAN()));
		if (facCustRetroAction.getDataListPT_IL_FAC_CUST_RETRO().size()>0) {
			facCustRetroAction.setPT_IL_FAC_CUST_RETRO_BEAN(facCustRetroAction.getDataListPT_IL_FAC_CUST_RETRO().get(0));
			facCustRetroAction.getPT_IL_FAC_CUST_RETRO_BEAN().setRowSelected(true);
		}
	}

	private List<PT_IL_FAC_CUST_RETRO> EXECUTE_QUERY(PT_IL_FAC_OUT facOutBean) throws Exception {
		
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		
		PT_IL_FAC_CUST_RETRO facPartCustBean = null;
		List<PT_IL_FAC_CUST_RETRO> list = null;
		try {
			connection = CommonUtils.getConnection();
			
			values = new Object[1];
			values[0] = facOutBean.getFO_SYS_ID();
			resultSet = handler.executeSelectStatement(PILT009_SQL_CONSTANTS.SELECT_PT_IL_FAC_CUST_RETRO, connection, values);
			
			list = new ArrayList<PT_IL_FAC_CUST_RETRO>();

			while(resultSet.next()) {
				facPartCustBean = new PT_IL_FAC_CUST_RETRO();
				
				facPartCustBean.setROWID(resultSet.getString(1));
				facPartCustBean.setFCR_SYS_ID(resultSet.getDouble(2));
				facPartCustBean.setFCR_FPCU_SYS_ID(resultSet.getDouble(3));
				facPartCustBean.setFCR_FO_SYS_ID(resultSet.getDouble(4));
				facPartCustBean.setFCR_REF_NO(resultSet.getString(5));
				facPartCustBean.setFCR_SHARE_PERC(resultSet.getDouble(6));
				facPartCustBean.setFCR_RETRO_COMM_FIRST_YR(resultSet.getDouble(7));
				facPartCustBean.setFCR_RETRO_COMM_SUB_YRS(resultSet.getDouble(8));
				facPartCustBean.setFCR_RETRO_TAX_FIRST_YR(resultSet.getDouble(9));
				facPartCustBean.setFCR_RETRO_TAX_SUB_YRS(resultSet.getDouble(10));
				facPartCustBean.setFCR_DEL_FLAG(resultSet.getString(11));
				facPartCustBean.setFCR_CR_DT(resultSet.getDate(12));
				facPartCustBean.setFCR_CR_UID(resultSet.getString(13));
				facPartCustBean.setFCR_UPD_DT(resultSet.getDate(14));
				facPartCustBean.setFCR_UPD_UID(resultSet.getString(15));
				
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
