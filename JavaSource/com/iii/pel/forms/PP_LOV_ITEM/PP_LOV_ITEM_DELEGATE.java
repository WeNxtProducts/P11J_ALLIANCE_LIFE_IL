package com.iii.pel.forms.PP_LOV_ITEM;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PP_LOV_ITEM_DELEGATE {

	public ArrayList<PP_LOV_ITEM> fetchValueForLov(
			PP_LOV_ITEM_ACTION lovAction)throws ValidatorException, Exception {

		
		CRUDHandler handler = new CRUDHandler();

		ArrayList<PP_LOV_ITEM> lovDetails =  new ArrayList<PP_LOV_ITEM>();
		PP_LOV_ITEM valueBean = null;
		String queryString = null;

		ResultSet resultSet = null;
		Object[] objects = {lovAction.getPP_LOV_ITEM_BEAN().getPLD_PROG_CODE()};
		queryString = PP_LOV_ITEM_QUERY_CONSTANTS.FETCH_LOV_DETAILS;
		
		try {
			Connection connection = CommonUtils.getConnection(); 
			resultSet = handler.executeSelectStatement(queryString, connection,objects);

			if(resultSet != null) {
				while(resultSet.next()) {
					valueBean = new PP_LOV_ITEM();
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
                     valueBean.setRowSelected(false);
					lovDetails.add(valueBean);
				}
				lovAction.setLovDetailsList(lovDetails);
				if(lovDetails.size()>0)
				{
					lovAction.setPP_LOV_ITEM_BEAN(lovDetails.get(0));
					lovAction.getPP_LOV_ITEM_BEAN().setRowSelected(true);					
				}
				else
				{
					lovAction.setPP_LOV_ITEM_BEAN(new PP_LOV_ITEM());
				}
				lovAction.resetAllComponent();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
		return lovDetails;
	}
	
	public int updateLovDetails(PP_LOV_ITEM gridValueBean) {
		int rowUpdated = 0;
			
			Connection con = null;
			CRUDHandler handler = null;
			
			try {
				con =CommonUtils.getConnection();
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

	public ArrayList<PP_LOV_ITEM> fetchlovList(
			PP_LOV_ITEM_SEARCH_ACTION action) {

		
		CRUDHandler handler = new CRUDHandler();

		ArrayList<PP_LOV_ITEM> lovSerchDetails = null;
		PP_LOV_ITEM valueBean = null;
		String queryString = null;

		ResultSet resultSet = null;
		queryString = PP_LOV_ITEM_QUERY_CONSTANTS.FETCH_LOV_SERCH_DETAILS;
		
		String progCode =  action.getPLD_PROG_CODE_SEARCH() + PP_LOV_ITEM_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
	    String blockName =  action.getPLD_BLOCK_NAME_SEARCH() + PP_LOV_ITEM_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
	    String fieldName =  action.getPLD_FIELD_NAME_SEARCH()+ PP_LOV_ITEM_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
	    Object[] objects = {progCode,blockName,fieldName};
		
		try {
			Connection connection = CommonUtils.getConnection(); 
			resultSet = handler.executeSelectStatement(queryString, connection,objects);

			if(resultSet != null) {
				lovSerchDetails = new ArrayList<PP_LOV_ITEM>();
				
				while(resultSet.next()) {
					valueBean = new PP_LOV_ITEM();
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
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lovSerchDetails;
	
	}
	public ArrayList<PP_LOV_ITEM> fetchlovList1(
			PP_LOV_ITEM_ACTION action) {

		
		CRUDHandler handler = new CRUDHandler();

		ArrayList<PP_LOV_ITEM> lovSerchDetails = null;
		PP_LOV_ITEM valueBean = null;
		String queryString = null;
		
		ResultSet resultSet = null;
		queryString = PP_LOV_ITEM_QUERY_CONSTANTS.FETCH_LOV_SERCH_DETAILS;
		
		String progCode =  action.getPLD_PROG_CODE_SEARCH() + PP_LOV_ITEM_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
	    String blockName =  action.getPLD_BLOCK_NAME_SEARCH() + PP_LOV_ITEM_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
	    String fieldName =  action.getPLD_FIELD_NAME_SEARCH()+ PP_LOV_ITEM_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
	    Object[] objects = {progCode,blockName,fieldName};
		
		try {
			Connection connection = CommonUtils.getConnection(); 
			resultSet = handler.executeSelectStatement(queryString, connection,objects);

			if(resultSet != null) {
				lovSerchDetails = new ArrayList<PP_LOV_ITEM>();
				
				while(resultSet.next()) {
					valueBean = new PP_LOV_ITEM();
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
					valueBean.setRowSelected(false);
	                lovSerchDetails.add(valueBean);
				}
				action.setLovDetailsList(lovSerchDetails);
				if(lovSerchDetails.size()>0)
				{
					action.setPP_LOV_ITEM_BEAN(lovSerchDetails.get(0));
					action.getPP_LOV_ITEM_BEAN().setRowSelected(true);
				}
				else
				{
				action.setPP_LOV_ITEM_BEAN(new PP_LOV_ITEM());
				}
			action.resetAllComponent();	
					
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lovSerchDetails;
	
	}

	
	
	
	public int deleteLovDetails(PP_LOV_ITEM listBean) {

		
		Connection connection;
		CRUDHandler handler =null;
		
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
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
