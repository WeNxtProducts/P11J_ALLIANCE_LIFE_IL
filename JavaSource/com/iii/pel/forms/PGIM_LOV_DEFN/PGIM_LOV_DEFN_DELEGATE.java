package com.iii.pel.forms.PGIM_LOV_DEFN;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PGIM_LOV_DEFN_DELEGATE {

	public ArrayList<PGIM_LOV_DEFN> fetchValueForLov(
			PGIM_LOV_DEFN_ACTION lovAction)throws ValidatorException {

		CommonUtils commonUtils = new CommonUtils();
		CRUDHandler handler = new CRUDHandler();

		ArrayList<PGIM_LOV_DEFN> lovDetails = null;
		PGIM_LOV_DEFN valueBean = null;
		String queryString = null;

		ResultSet resultSet = null;
		Object[] objects = {lovAction.getPGIM_LOV_DEFN_BEAN().getPLD_PROG_CODE()};
		queryString = PGIM_LOV_DEFN_QUERY_CONSTANTS.FETCH_LOV_DETAILS;
		
		try {
			Connection connection = commonUtils.getConnection(); 
			resultSet = handler.executeSelectStatement(queryString, connection,objects);

			if(resultSet != null) {
				lovDetails = new ArrayList<PGIM_LOV_DEFN>();
				
				while(resultSet.next()) {
					valueBean = new PGIM_LOV_DEFN();
					valueBean.setROWID(resultSet.getString("ROWID"));
					valueBean.setPLD_PROG_CODE(resultSet.getString("PLD_PROG_CODE"));
					valueBean.setPLD_BLOCK_NAME(resultSet.getString("PLD_BLOCK_NAME"));
					valueBean.setPLD_FIELD_NAME(resultSet.getString("PLD_FIELD_NAME"));
					valueBean.setPLD_LOV_TITLE(resultSet.getString("PLD_LOV_TITLE"));
					valueBean.setPLD_LOV_TITLE_BL(resultSet.getString("PLD_LOV_TITLE_BL"));
					valueBean.setPLD_LOV_SELECT_STMT(resultSet.getString("PLD_LOV_SELECT_STMT"));
					valueBean.setPLD_COLUMN_HEAD(resultSet.getString("PLD_COLUMN_HEAD"));
					valueBean.setPLD_COLUMN_HEAD_BL(resultSet.getString("PLD_COLUMN_HEAD_BL"));
					valueBean.setPLD_PARA_COL_1(resultSet.getString("PLD_PARA_COL_1"));
					valueBean.setPLD_PARA_COL_2(resultSet.getString("PLD_PARA_COL_2"));
					valueBean.setPLD_PARA_COL_3(resultSet.getString("PLD_PARA_COL_3"));
					valueBean.setPLD_PARA_COL_4(resultSet.getString("PLD_PARA_COL_4"));
					valueBean.setPLD_PARA_COL_5(resultSet.getString("PLD_PARA_COL_5"));
					valueBean.setPLD_CR_UID(resultSet.getString("PLD_CR_UID"));
					valueBean.setPLD_CR_DT(resultSet.getDate("PLD_CR_DT"));
					valueBean.setPLD_LOV_NO_OF_COLUMN(resultSet.getDouble("PLD_LOV_NO_OF_COLUMN"));

					lovDetails.add(valueBean);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lovDetails;
	}
	
	public int updateLovDetails(PGIM_LOV_DEFN gridValueBean) {
		int rowUpdated = 0;
			CommonUtils commonUtils = new CommonUtils();
			Connection con = null;
			CRUDHandler handler = null;
			
			try {
				con =commonUtils.getConnection();
				if(con != null){
					handler = new CRUDHandler();
					System.out.println("ID.::::::::::::::::"+gridValueBean.getPLD_CR_UID());
					System.out.println("PROD.::::::::::::::::"+gridValueBean.getPLD_PROG_CODE());
					rowUpdated = handler.executeInsert(gridValueBean, con);;
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
			
	 	return rowUpdated;
	}

	public ArrayList<PGIM_LOV_DEFN> fetchlovList(
			PGIM_LOV_DEFN_SEARCH_ACTION action) {

		CommonUtils commonUtils = new CommonUtils();
		CRUDHandler handler = new CRUDHandler();

		ArrayList<PGIM_LOV_DEFN> lovSerchDetails = null;
		PGIM_LOV_DEFN valueBean = null;
		String queryString = null;

		ResultSet resultSet = null;
		queryString = PGIM_LOV_DEFN_QUERY_CONSTANTS.FETCH_LOV_SERCH_DETAILS;
		
		String progCode = action.getPLD_PROG_CODE_SEARCH() + PGIM_LOV_DEFN_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
	    String blockName = action.getPLD_BLOCK_NAME_SEARCH() + PGIM_LOV_DEFN_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
	    String fieldName = action.getPLD_FIELD_NAME_SEARCH();
	    Object[] objects = {progCode,blockName,fieldName};
		
		try {
			Connection connection = commonUtils.getConnection(); 
			resultSet = handler.executeSelectStatement(queryString, connection,objects);

			if(resultSet != null) {
				lovSerchDetails = new ArrayList<PGIM_LOV_DEFN>();
				
				while(resultSet.next()) {
					valueBean = new PGIM_LOV_DEFN();
					valueBean.setROWID(resultSet.getString("ROWID"));
					valueBean.setPLD_PROG_CODE(resultSet.getString("PLD_PROG_CODE"));
					valueBean.setPLD_BLOCK_NAME(resultSet.getString("PLD_BLOCK_NAME"));
					valueBean.setPLD_FIELD_NAME(resultSet.getString("PLD_FIELD_NAME"));
					valueBean.setPLD_LOV_TITLE(resultSet.getString("PLD_LOV_TITLE"));
					
					lovSerchDetails.add(valueBean);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lovSerchDetails;
	
	}

	public int deleteLovDetails(PGIM_LOV_DEFN listBean) {

		CommonUtils commonUtils = new CommonUtils();
		Connection connection;
		CRUDHandler handler =null;
		
		int deletedRows = 0;
		try {
			connection = commonUtils.getConnection();
			if(connection != null){
				handler = new CRUDHandler();
				deletedRows = handler.executeDelete(listBean, connection);
			}
		} catch (DBException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	 return deletedRows;
	}
}
