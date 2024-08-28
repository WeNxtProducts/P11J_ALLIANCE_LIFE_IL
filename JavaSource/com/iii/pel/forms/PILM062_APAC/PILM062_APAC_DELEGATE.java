package com.iii.pel.forms.PILM062_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PILM062_APAC_DELEGATE {

	public List<PM_IL_PROD_GROUP> getGroupCodeLov(String groupCode) throws Exception {

		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();

		List<PM_IL_PROD_GROUP> list = null;
		ResultSet resultSet = null;
		String query = null;
		Object[] obj = {};
		try {
			connection = CommonUtils.getConnection();
			
			list = new ArrayList<PM_IL_PROD_GROUP>();
			if("*".equalsIgnoreCase(groupCode)) {
				
				query = PILM062_APAC_SQL_QUERY_CONSTANTS.SELECT_PC_CODE_LOV;
				obj = new Object[2];
				obj[0] = "IL_PRD_GRP";
				obj[1] = PELConstants.suggetionRecordSize;
				
			} else {
				
				query = PILM062_APAC_SQL_QUERY_CONSTANTS.SELECT_PC_CODE_LOV_LIKE;
				obj = new Object[3];
				obj[0] = "IL_PRD_GRP";
				obj[1] = groupCode + "%";
				obj[2] = PELConstants.suggetionRecordSize;

			}

			resultSet = handler.executeSelectStatement(query, connection, obj);
			
			while(resultSet.next()) {
				PM_IL_PROD_GROUP PM_IL_PROD_GROUP_BEAN = new PM_IL_PROD_GROUP();
				
				PM_IL_PROD_GROUP_BEAN.setPG_CODE(resultSet.getString(1));
				PM_IL_PROD_GROUP_BEAN.setPG_CODE_DESC(resultSet.getString(2));
				list.add(PM_IL_PROD_GROUP_BEAN);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch(SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public List<PM_IL_PROD_GROUP> getProductCodeLov(String productCode) throws Exception {

		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();

		List<PM_IL_PROD_GROUP> list = null;
		ResultSet resultSet = null;
		String query = null;
		Object[] obj = {};
		try {
			connection = CommonUtils.getConnection();
			
			list = new ArrayList<PM_IL_PROD_GROUP>();
			if("*".equalsIgnoreCase(productCode)) {
				
				query = PILM062_APAC_SQL_QUERY_CONSTANTS.SELECT_PROD_CODE_LOV;
				obj = new Object[1];
				obj[0] = PELConstants.suggetionRecordSize;
				
			} else {
				
				query = PILM062_APAC_SQL_QUERY_CONSTANTS.SELECT_PROD_CODE_LOV_LIKE;
				obj = new Object[2];
				obj[0] = productCode + "%";
				obj[1] = PELConstants.suggetionRecordSize;

			}

			resultSet = handler.executeSelectStatement(query, connection, obj);
			
			while(resultSet.next()) {
				PM_IL_PROD_GROUP PM_IL_PROD_GROUP_BEAN = new PM_IL_PROD_GROUP();
				
				PM_IL_PROD_GROUP_BEAN.setPG_PROD_CODE(resultSet.getString(1));
				PM_IL_PROD_GROUP_BEAN.setPG_PROD_CODE_DESC(resultSet.getString(2));
				list.add(PM_IL_PROD_GROUP_BEAN);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch(SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public List<PM_IL_PROD_GROUP> fetchData(String pgCode) throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();

		ResultSet resultSet = null;
		PM_IL_PROD_GROUP prodGroup = null;
		Object[] obj = {pgCode};
		List<PM_IL_PROD_GROUP> prodGroupList = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(PILM062_APAC_SQL_QUERY_CONSTANTS.FETCH_RECORDS, connection, obj);
			prodGroupList = new ArrayList<PM_IL_PROD_GROUP>();
			while(resultSet.next()) {
				prodGroup = new PM_IL_PROD_GROUP(); 
				prodGroup.setROWID(resultSet.getString("ROWID"));
				prodGroup.setPG_CODE(resultSet.getString("PG_CODE"));
				prodGroup.setPG_PROD_CODE(resultSet.getString("PG_PROD_CODE"));
				prodGroup.setPG_CR_UID(resultSet.getString("PG_CR_UID"));
				prodGroup.setPG_CR_DT(resultSet.getDate("PG_CR_DT"));
				prodGroup = new PILM062_APAC_HELPER().PM_IL_PROD_GROUP_POST_QUERY(prodGroup);
				prodGroupList.add(prodGroup);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
		return prodGroupList;
	}
	
	public List<PM_IL_PROD_GROUP> fetchProdGroupList(SEARCH_BEAN searchBean) throws Exception {
		
		Connection connection = null;
		ResultSet resultSet = null;
		PM_IL_PROD_GROUP bean  = null;
		List<PM_IL_PROD_GROUP> QUERY_DATA_LIST = null;
		
		try {
			
			connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			String query = null;
			Object[] values = {searchBean.getGROUP_CODE(),searchBean.getPRODUCT_CODE()};
			if(searchBean.getGROUP_CODE().trim().isEmpty() && searchBean.getPRODUCT_CODE().isEmpty()) {
				query = "SELECT PM_IL_PROD_GROUP.*  FROM  PM_IL_PROD_GROUP ";
				resultSet = handler.executeSelectStatement(query, connection);
			}else {
				query = PILM062_APAC_SQL_QUERY_CONSTANTS.PILM062_APAC_SEARCH_LIST_QUERY;
				resultSet = handler.executeSelectStatement(query, connection, values);
			}
			QUERY_DATA_LIST = new ArrayList<PM_IL_PROD_GROUP>();
				
			
			while(resultSet.next()){
				bean = new PM_IL_PROD_GROUP();
				String PG_CODE = resultSet.getString(1);
				String PG_PROD_CODE = resultSet.getString(2);
				bean.setPG_CODE(PG_CODE);
				bean.setPG_PROD_CODE(PG_PROD_CODE);
				
				
				QUERY_DATA_LIST.add(bean);
			}
			
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
		return QUERY_DATA_LIST;
	}
	
	public int updateData(PM_IL_PROD_GROUP prodGroup) throws Exception {

		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();

		int rowUpdated = 0;

		try {
			connection = CommonUtils.getConnection();

			rowUpdated = handler.executeInsert(prodGroup, connection);

		} catch (Exception exc) {
			exc.printStackTrace();
			throw exc;
		}
		return rowUpdated;
	}
	
	public void deleteData(PM_IL_PROD_GROUP prodGroup) throws Exception {
		
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();

		try {
			connection = CommonUtils.getConnection();

			handler.executeDelete(prodGroup, connection);
			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
			throw exc;
		}
	}
}
