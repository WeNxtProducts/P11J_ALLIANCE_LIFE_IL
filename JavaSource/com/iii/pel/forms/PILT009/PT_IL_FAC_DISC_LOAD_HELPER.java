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

public class PT_IL_FAC_DISC_LOAD_HELPER {

	public void fetchRecord(PT_IL_FAC_DISC_LOAD_ACTION discLoadAction) throws Exception {
		
		discLoadAction.setDataListPT_IL_FAC_DISC_LOAD(EXECUTE_QUERY(discLoadAction.getPT_IL_FAC_DETL_BEAN()));
		
		for(PT_IL_FAC_DISC_LOAD discLoadBean : discLoadAction.getDataListPT_IL_FAC_DISC_LOAD()) {
			
			//PT_IL_FAC_DISC_LOAD_POST_QUERY(discLoadBean);
		}
		if (discLoadAction.getDataListPT_IL_FAC_DISC_LOAD().size()>0) {
			discLoadAction.setPT_IL_FAC_DISC_LOAD_BEAN(discLoadAction.getDataListPT_IL_FAC_DISC_LOAD().get(0));
			discLoadAction.getPT_IL_FAC_DISC_LOAD_BEAN().setRowSelected(true);
			
		}else{
			PT_IL_FAC_DISC_LOAD	discLoad = new PT_IL_FAC_DISC_LOAD();
			discLoadAction.setPT_IL_FAC_DISC_LOAD_BEAN(discLoad);
		}
		
	}

	public List<PT_IL_FAC_DISC_LOAD> EXECUTE_QUERY(PT_IL_FAC_DETL facDetlBean) throws Exception {
		
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
	
		PT_IL_FAC_DISC_LOAD facDiscLoadBean = null;
		List<PT_IL_FAC_DISC_LOAD> list = null;
		try {
			connection = CommonUtils.getConnection();
			
			values = new Object[1];
			values[0] = facDetlBean.getFD_SYS_ID();
			resultSet = handler.executeSelectStatement(PILT009_SQL_CONSTANTS.SELECT_PT_IL_FAC_DISC_LOAD, connection, values);
			
			list = new ArrayList<PT_IL_FAC_DISC_LOAD>();

			while(resultSet.next()) {
				facDiscLoadBean = new PT_IL_FAC_DISC_LOAD();
				
				facDiscLoadBean.setROWID(resultSet.getString(1));
				facDiscLoadBean.setFDL_SYS_ID(resultSet.getDouble(2));
				facDiscLoadBean.setFDL_FD_SYS_ID(resultSet.getDouble(3));
				facDiscLoadBean.setFDL_SRNO(resultSet.getDouble(4));
				facDiscLoadBean.setFDL_DISC_LOAD_TYPE(resultSet.getString(5));
				facDiscLoadBean.setFDL_DISC_LOAD_CODE(resultSet.getString(6));
				facDiscLoadBean.setFDL_RATE(resultSet.getDouble(7));
				facDiscLoadBean.setFDL_RATE_PER(resultSet.getDouble(8));
				facDiscLoadBean.setFDL_APPL_PERC(resultSet.getDouble(9));
				facDiscLoadBean.setFDL_FC_DISC_LOAD_VALUE(resultSet.getDouble(10));
				facDiscLoadBean.setFDL_LC_DISC_LOAD_VALUE(resultSet.getDouble(11));
				facDiscLoadBean.setFDL_CR_DT(resultSet.getDate(12));
				facDiscLoadBean.setFDL_CR_UID(resultSet.getString(13));
				facDiscLoadBean.setFDL_UPD_DT(resultSet.getDate(14));
				facDiscLoadBean.setFDL_UPD_UID(resultSet.getString(15));
				facDiscLoadBean.setRowSelected(false);
				
				list.add(facDiscLoadBean);
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
	
	public void PT_IL_FAC_DISC_LOAD_POST_QUERY(PT_IL_FAC_DISC_LOAD facDiscLoadBean) throws Exception {
		
		String M_TYPE = null;
		
		Connection connection = null;
		ArrayList<String> valueList = null;
		DBProcedures procedures = new DBProcedures();
		CommonUtils commonUtils = new CommonUtils();
		
		PILT009_COMPOSITE_ACTION compositeAction = (PILT009_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PILT009_COMPOSITE_ACTION");
		
		try {
			connection = CommonUtils.getConnection();
			
			if(facDiscLoadBean.getFDL_DISC_LOAD_CODE() != null) {
				
				if("D".equals(facDiscLoadBean.getFDL_DISC_LOAD_CODE())) {
					M_TYPE = "IL_DISC";	
				} else {
					M_TYPE = "IL_LOAD";
				}
				
				valueList = procedures.helperP_VAL_CODES(
						M_TYPE,
						facDiscLoadBean.getFDL_DISC_LOAD_CODE(),
						"N", "E", null);
				
				if(valueList != null && valueList.size() > 0) {
					facDiscLoadBean.setUI_M_DISCLOAD_DESC(valueList.get(0));
				}
			}
			
			
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorsAndWarningforProcedure(connection, FacesContext.getCurrentInstance(),
					"PT_IL_FAC_DISC_LOAD", compositeAction.getPILT009_PT_IL_FAC_DISC_LOAD_ACTION().getErrorMap());
			throw e;
		} 
	}
			
}
