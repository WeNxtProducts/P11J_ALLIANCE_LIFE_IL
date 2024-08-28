package com.iii.pel.forms.PILT009;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_FAC_PART_CUST_DETL_HELPER {

	public void fetchRecord(PT_IL_FAC_PART_CUST_DETL_ACTION partCustDtlAction)  throws Exception {
		
		partCustDtlAction.setDataListPT_IL_FAC_PART_CUST_DETL(EXECUTE_QUERY(partCustDtlAction.getPT_IL_FAC_PART_CUST_BEAN()));
		
		if (partCustDtlAction.getDataListPT_IL_FAC_PART_CUST_DETL().size()>0) {
			partCustDtlAction.setPT_IL_FAC_PART_CUST_DETL_BEAN(partCustDtlAction.getDataListPT_IL_FAC_PART_CUST_DETL().get(0));
			partCustDtlAction.getPT_IL_FAC_PART_CUST_DETL_BEAN().setRowSelected(true);
		}
		
	}

	public List<PT_IL_FAC_PART_CUST_DETL> EXECUTE_QUERY(PT_IL_FAC_PART_CUST facPartCustBean) throws Exception {
		
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		
		PT_IL_FAC_PART_CUST_DETL facPartCustDtlBean = null;
		List<PT_IL_FAC_PART_CUST_DETL> list = null;
		try {
			connection = CommonUtils.getConnection();
			
			values = new Object[1];
			values[0] = facPartCustBean.getFPCU_SYS_ID ();
			resultSet = handler.executeSelectStatement(PILT009_SQL_CONSTANTS.SELECT_PT_IL_FAC_PART_CUST_DETL, connection, values);
			
			list = new ArrayList<PT_IL_FAC_PART_CUST_DETL>();

			while(resultSet.next()) {
				facPartCustDtlBean = new PT_IL_FAC_PART_CUST_DETL();
				
				facPartCustDtlBean.setROWID(resultSet.getString(1));
				facPartCustDtlBean.setFPCUD_SYS_ID(resultSet.getDouble(2));
				facPartCustDtlBean.setFPCUD_FO_SYS_ID(resultSet.getDouble(3));
				facPartCustDtlBean.setFPCUD_FPCU_SYS_ID(resultSet.getDouble(4));
				facPartCustDtlBean.setFPCUD_FD_SYS_ID(resultSet.getDouble(5));
				facPartCustDtlBean.setFPCUD_SA_CURR_CODE(resultSet.getString(6));
				facPartCustDtlBean.setFPCUD_FC_SUM_ASSURED(resultSet.getDouble(7));
				facPartCustDtlBean.setFPCUD_LC_SUM_ASSURED(resultSet.getDouble(8));
				facPartCustDtlBean.setFPCUD_FC_PREM(resultSet.getDouble(9));
				facPartCustDtlBean.setFPCUD_LC_PREM(resultSet.getDouble(10));
				facPartCustDtlBean.setFPCUD_FC_COMM(resultSet.getDouble(11));
				facPartCustDtlBean.setFPCUD_LC_COMM(resultSet.getDouble(12));
				facPartCustDtlBean.setFPCUD_FC_TAX(resultSet.getDouble(13));
				facPartCustDtlBean.setFPCUD_LC_TAX(resultSet.getDouble(14));
				facPartCustDtlBean.setFPCUD_FC_RETRO_SUM_ASSURED(resultSet.getDouble(15));
				facPartCustDtlBean.setFPCUD_LC_RETRO_SUM_ASSURED(resultSet.getDouble(16));
				facPartCustDtlBean.setFPCUD_FC_RETRO_PREM(resultSet.getDouble(17));
				facPartCustDtlBean.setFPCUD_LC_RETRO_PREM(resultSet.getDouble(18));
				facPartCustDtlBean.setFPCUD_FC_RETRO_COMM(resultSet.getDouble(19));
				facPartCustDtlBean.setFPCUD_LC_RETRO_COMM(resultSet.getDouble(20));
				facPartCustDtlBean.setFPCUD_FC_RETRO_TAX(resultSet.getDouble(21));
				facPartCustDtlBean.setFPCUD_LC_RETRO_TAX(resultSet.getDouble(22));
				facPartCustDtlBean.setFPCUD_SCHD_DT(resultSet.getDate(23));
				facPartCustDtlBean.setFPCUD_FAC_CLOSE_YN(resultSet.getString(24));
				facPartCustDtlBean.setFPCUD_DEL_FLAG(resultSet.getString(25));
				facPartCustDtlBean.setFPCUD_CR_DT(resultSet.getDate(26));
				facPartCustDtlBean.setFPCUD_CR_UID(resultSet.getString(27));
				facPartCustDtlBean.setFPCUD_UPD_DT(resultSet.getDate(28));
				facPartCustDtlBean.setFPCUD_UPD_UID(resultSet.getString(29));
				facPartCustBean.setRowSelected(false);
				
				list.add(facPartCustDtlBean);
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
