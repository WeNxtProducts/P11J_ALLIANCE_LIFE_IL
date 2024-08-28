package com.iii.pel.forms.PILT009;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_FAC_PART_CUST_HELPER {
	
	public void fetchRecord(PT_IL_FAC_PART_CUST_ACTION facPartCustAction) throws Exception {
		
		PT_IL_FAC_PART_CUST_PRE_QUERY(facPartCustAction);
		facPartCustAction.setDataListPT_IL_FAC_PART_CUST(EXECUTE_QUERY(facPartCustAction.getPT_IL_FAC_OUT_BEAN()));
		
		if (facPartCustAction.getDataListPT_IL_FAC_PART_CUST().size()>0) {
			facPartCustAction.setPT_IL_FAC_PART_CUST_BEAN(facPartCustAction.getDataListPT_IL_FAC_PART_CUST().get(0));
			facPartCustAction.getPT_IL_FAC_PART_CUST_BEAN().setRowSelected(true);
		}
		
		for(PT_IL_FAC_PART_CUST facPartCustBean : facPartCustAction.getDataListPT_IL_FAC_PART_CUST()) {
			PT_IL_FAC_PART_CUST_POST_QUERY(facPartCustBean);
		}
	}
	
	public void PT_IL_FAC_PART_CUST_PRE_QUERY(PT_IL_FAC_PART_CUST_ACTION facPartCustAction) throws Exception {
		
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		CommonUtils commonUtils = new CommonUtils();
		
		PILT009_COMPOSITE_ACTION compositeAction = (PILT009_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PILT009_COMPOSITE_ACTION");
		
		try {
			connection = CommonUtils.getConnection();
			
			values = new Object[1];
			values[0] = facPartCustAction.getPT_IL_FAC_OUT_BEAN().getFO_SYS_ID();
			
			resultSet = handler.executeSelectStatement(PILT009_SQL_CONSTANTS.SELECT_SUM_FPCU_SHARE_PERC, connection, values);
			
			if(resultSet.next()) {
				
				compositeAction.getPILT009_PT_IL_FAC_OUT_ACTION().getDUMMY_BEAN().setUI_M_FPCU_SHARE_PERC_TOT(resultSet.getDouble(1));
			} else {
				
				compositeAction.getPILT009_PT_IL_FAC_OUT_ACTION().getDUMMY_BEAN().setUI_M_FPCU_SHARE_PERC_TOT(0.0);
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
	}
	
	public List<PT_IL_FAC_PART_CUST> EXECUTE_QUERY(PT_IL_FAC_OUT facOutBean) throws Exception {
		
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		
		PT_IL_FAC_PART_CUST facPartCustBean = null;
		List<PT_IL_FAC_PART_CUST> list = null;
		try {
			connection = CommonUtils.getConnection();
			
			values = new Object[1];
			values[0] = facOutBean.getFO_SYS_ID();
			resultSet = handler.executeSelectStatement(PILT009_SQL_CONSTANTS.SELECT_PT_IL_FAC_PART_CUST, connection, values);
			
			list = new ArrayList<PT_IL_FAC_PART_CUST>();

			while(resultSet.next()) {
				facPartCustBean = new PT_IL_FAC_PART_CUST();
				
				facPartCustBean.setROWID(resultSet.getString(1));
				facPartCustBean.setFPCU_SYS_ID(resultSet.getDouble(2));
				facPartCustBean.setFPCU_FO_SYS_ID(resultSet.getDouble(3));
				facPartCustBean.setFPCU_CUST_CODE(resultSet.getString(4));
				facPartCustBean.setFPCU_SHARE_PERC(resultSet.getDouble(5));
				facPartCustBean.setFPCU_COMM_FIRST_YR(resultSet.getDouble(6));
				facPartCustBean.setFPCU_COMM_SUB_YRS(resultSet.getDouble(7));
				facPartCustBean.setFPCU_TAX_FIRST_YR(resultSet.getDouble(8));
				facPartCustBean.setFPCU_TAX_SUB_YRS(resultSet.getDouble(9));
				facPartCustBean.setFPCU_RETRO_YN(resultSet.getString(10));
				facPartCustBean.setFPCU_RETRO_SHARE_PERC(resultSet.getDouble(11));
				facPartCustBean.setFPCU_RETRO_COMM_FIRST_YR(resultSet.getDouble(12));
				facPartCustBean.setFPCU_RETRO_COMM_SUB_YRS(resultSet.getDouble(13));
				facPartCustBean.setFPCU_RETRO_TAX_FIRST_YR(resultSet.getDouble(14));
				facPartCustBean.setFPCU_RETRO_TAX_SUB_YRS(resultSet.getDouble(15));
				facPartCustBean.setFPCU_DEL_FLAG(resultSet.getString(16));
				facPartCustBean.setFPCU_CR_DT(resultSet.getDate(17));
				facPartCustBean.setFPCU_CR_UID(resultSet.getString(18));
				facPartCustBean.setFPCU_UPD_DT(resultSet.getDate(19));
				facPartCustBean.setFPCU_UPD_UID(resultSet.getString(20));
				facPartCustBean.setFPCU_PC_SYS_ID(resultSet.getDouble(21));
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
	
	public void PT_IL_FAC_PART_CUST_POST_QUERY(PT_IL_FAC_PART_CUST facPartCustBean) throws Exception {
		
		Connection connection = null;
		ArrayList<String> valueList = null;
		DBProcedures procedures = new DBProcedures();
		CommonUtils commonUtils = new CommonUtils();
		
		PILT009_COMPOSITE_ACTION compositeAction = (PILT009_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PILT009_COMPOSITE_ACTION");
		
		try {
			connection = CommonUtils.getConnection();
			
			valueList = procedures.helperP_VAL_CLASS_CUST(
					"REINS", facPartCustBean.getFPCU_CUST_CODE(), "N", "N");
			
			if(valueList != null && valueList.size() > 0) {
				facPartCustBean.setUI_M_FPCU_CUST_DESC(valueList.get(0));
			}
			
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorsAndWarningforProcedure(connection, FacesContext.getCurrentInstance(),
					"PT_IL_FAC_PART_CUST", compositeAction.getPILT009_PT_IL_FAC_PART_CUST_ACTION().getErrorMap());
			throw e;
		}
	}
}
