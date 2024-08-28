package com.iii.pel.forms.PILM071_APAC;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PILM071_APAC_DELEGATE {
	
	public ArrayList<PM_LIFE_ENDT_NUMBER_SETUP> fetchListValue(PILM071_APAC_SEARCH_ACTION action){
		String selectQuery = PILM071_APAC_QUERY_CONSTANT.FETCH_SEARCH_RECORD;
		PM_LIFE_ENDT_NUMBER_SETUP valueBean = null;
		ArrayList<PM_LIFE_ENDT_NUMBER_SETUP> detailsList = null;
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		Object tempObject[] = new Object[2];
		Object object[] = null;
		String prefix = action.getInitPrefix();
		String suffix = action.getInitSuffix();
		int index = 0;
		boolean whereAdded = false;
		try {
			if (prefix != null && !prefix.trim().isEmpty()) {
				selectQuery = selectQuery+ " WHERE ENS_PREFIX LIKE ?";
				tempObject[index++] = prefix + "%";
				whereAdded = true;
			}
			if (suffix != null && !suffix.trim().isEmpty()) {
				if (whereAdded) {
					selectQuery = selectQuery+ " AND ENS_SUFFIX LIKE ?";
				} else {
					selectQuery = selectQuery+ " WHERE ENS_SUFFIX LIKE ?";
					whereAdded = true;
				}
				tempObject[index++] = suffix + "%";
			}
			object = new Object[index];
			for (int idx = 0; idx < index; idx++) {
				object[idx] = tempObject[idx];
			}
			con = CommonUtils.getConnection();
			if (con != null) {
				handler = new CRUDHandler();
				detailsList = new ArrayList<PM_LIFE_ENDT_NUMBER_SETUP>();
				rst = handler.executeSelectStatement(selectQuery, con,object);
				while (rst.next()) {
					valueBean = new PM_LIFE_ENDT_NUMBER_SETUP();
						valueBean.setROWID(rst.getString(1));
						valueBean.setENS_ENDT_TYPE(rst.getString("ENS_ENDT_TYPE"));                                                                                                                                                                                   
						valueBean.setENS_PREFIX(rst.getString("ENS_PREFIX"));                                                                                                                                                                                     
						valueBean.setENS_SUFFIX(rst.getString("ENS_SUFFIX"));                                                                                                                                                                                    
						valueBean.setENS_SEPARATOR(rst.getString("ENS_SEPARATOR"));                                                                                                                                                                                  
						valueBean.setENS_ZERO_PAD(rst.getInt("ENS_ZERO_PAD"));                                                                                                                                                                                     
						valueBean.setENS_CR_DT(rst.getDate("ENS_CR_DT"));                                                                                                                                                                                             
						valueBean.setENS_CR_UID(rst.getString("ENS_CR_UID"));                                                                                                                                                                                     
						valueBean.setENS_UPD_DT(rst.getDate("ENS_UPD_DT"));                                                                                                                                                                                             
						valueBean.setENS_UPD_UID(rst.getString("ENS_UPD_UID"));
						detailsList.add(valueBean);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return detailsList;
	}
	
	public PM_LIFE_ENDT_NUMBER_SETUP fetchEndNoDetails(String rowId) {
		Connection con = null;
		ResultSet rst = null;
		CRUDHandler handler = null;
		PM_LIFE_ENDT_NUMBER_SETUP valueBean = null;
		try {
			con = CommonUtils.getConnection();
			if (con != null) {
				handler = new CRUDHandler();
				Object[] values = { rowId };
				rst  = handler.executeSelectStatement(PILM071_APAC_QUERY_CONSTANT.FETCH_RECORD, con, values);
				if(rst.next()) {
					valueBean = new PM_LIFE_ENDT_NUMBER_SETUP();
						valueBean.setROWID(rst.getString(1));
						valueBean.setENS_ENDT_TYPE(rst.getString("ENS_ENDT_TYPE"));                                                                                                                                                                                   
						valueBean.setENS_PREFIX(rst.getString("ENS_PREFIX"));                                                                                                                                                                                     
						valueBean.setENS_SUFFIX(rst.getString("ENS_SUFFIX"));                                                                                                                                                                                    
						valueBean.setENS_SEPARATOR(rst.getString("ENS_SEPARATOR"));                                                                                                                                                                                  
						valueBean.setENS_ZERO_PAD(rst.getInt("ENS_ZERO_PAD"));                                                                                                                                                                                     
						valueBean.setENS_CR_DT(rst.getDate("ENS_CR_DT"));                                                                                                                                                                                             
						valueBean.setENS_CR_UID(rst.getString("ENS_CR_UID"));                                                                                                                                                                                     
						valueBean.setENS_UPD_DT(rst.getDate("ENS_UPD_DT"));                                                                                                                                                                                             
						valueBean.setENS_UPD_UID(rst.getString("ENS_UPD_UID"));
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return valueBean;
	}
	public int updateLifeEndt(PM_LIFE_ENDT_NUMBER_SETUP valueBean) throws Exception{
		Connection con = null;
		CRUDHandler handler = null;
		int recordCount = 0;
		try {
			con = CommonUtils.getConnection();
			if (con != null) {
				handler = new CRUDHandler();
				recordCount = handler.executeInsert(valueBean, con);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return recordCount;
	}
}
