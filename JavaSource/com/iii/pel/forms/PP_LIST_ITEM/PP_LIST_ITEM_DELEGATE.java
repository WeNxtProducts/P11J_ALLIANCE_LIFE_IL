package com.iii.pel.forms.PP_LIST_ITEM;


import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;



public class PP_LIST_ITEM_DELEGATE extends com.iii.premia.common.bean.LovBean{

	public ArrayList<PP_LIST_ITEM> fetchListItem(PP_LIST_ITEM_ACTION listItemAction)
	throws ValidatorException, Exception {

		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;

		ArrayList<PP_LIST_ITEM> listItem = null;
		PP_LIST_ITEM listItemBean = null;

		
		try {
			Connection connection = CommonUtils.getConnection();
			Object[] rowId = {listItemAction.getPP_LIST_ITEM_BEAN().getROWID()};
			resultSet = handler.executeSelectStatement(PP_LIST_ITEM_QUERY_CONSTANTS.SELECT_LIST_ITEMS,
					connection,rowId);

			if(resultSet != null) {
				listItem = new ArrayList<PP_LIST_ITEM>();
				
				while(resultSet.next()) {
					listItemBean = new PP_LIST_ITEM();
					listItemBean.setROWID(resultSet.getString("ROWID"));
					listItemBean.setLI_MODULE_NAME(resultSet.getString("LI_MODULE_NAME"));
					listItemBean.setLI_BLOCK_NAME(resultSet.getString("LI_BLOCK_NAME"));
					listItemBean.setLI_ITEM_NAME(resultSet.getString("LI_ITEM_NAME"));
					listItemBean.setLI_SYS_PARAM(resultSet.getString("LI_SYS_PARAM"));
					listItemBean.setLI_REMARKS(resultSet.getString("LI_REMARKS"));
					listItemBean.setLI_EXTERNAL_TABLE_YN(resultSet.getString("LI_EXTERNAL_TABLE_YN"));
					listItemBean.setLI_WHERE_CLAUSE(resultSet.getString("LI_WHERE_CLAUSE"));
					listItemBean.setLI_DFLT_VALUE(resultSet.getString("LI_DFLT_VALUE"));
					listItemBean.setRowSelected(false);
					listItem.add(listItemBean);
				}
				listItemAction.setListItemList(listItem);
				if(listItem.size()>0){
					listItemAction.setPP_LIST_ITEM_BEAN(listItem.get(0));
					listItemAction.getPP_LIST_ITEM_BEAN().setRowSelected(true);
				}
				listItemAction.resetAllComponent();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
		return listItem;
	}
	 
	public ArrayList<PP_LIST_ITEM> fetchSearchListItem(
			PP_LIST_ITEM_SEARCH_ACTION action) {

		CRUDHandler handler = new CRUDHandler();
		String moduleName="",blockName="",itemName="";
		ArrayList<PP_LIST_ITEM> listItemSerchDetails = null;
		PP_LIST_ITEM valueBean ;
		String queryString = null;

		ResultSet resultSet = null;
		queryString = PP_LIST_ITEM_QUERY_CONSTANTS.FETCH_LIST_ITEM_SERCH_DETAILS;
		
		 moduleName = action.getLI_MODULE_NAME_SEARCH() + PP_LIST_ITEM_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
	     blockName = action.getLI_BLOCK_NAME_SEARCH() + PP_LIST_ITEM_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
	     itemName = action.getLI_ITEM_NAME_SEARCH()+ PP_LIST_ITEM_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
	   
	    
	    Object[] objects = {moduleName,blockName,itemName};
		
		try {
			Connection connection = CommonUtils.getConnection(); 
			resultSet = handler.executeSelectStatement(queryString, connection,objects);

			if(resultSet != null) {
				listItemSerchDetails = new ArrayList<PP_LIST_ITEM>();
				
				while(resultSet.next()) {
					valueBean = new PP_LIST_ITEM();
					valueBean.setROWID(resultSet.getString("ROWID"));
					valueBean.setLI_MODULE_NAME(resultSet.getString("LI_MODULE_NAME"));
					valueBean.setLI_BLOCK_NAME(resultSet.getString("LI_BLOCK_NAME"));
					valueBean.setLI_ITEM_NAME(resultSet.getString("LI_ITEM_NAME"));
					valueBean.setLI_SYS_PARAM(resultSet.getString("LI_SYS_PARAM"));
					valueBean.setLI_REMARKS(resultSet.getString("LI_REMARKS"));
					listItemSerchDetails.add(valueBean);
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
		return listItemSerchDetails;
	}

	public int deleteListItemDetails(PP_LIST_ITEM listBean) {

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

	public int deleteListItemValues(PP_LIST_ITEM_VALUES listBean) {

		
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
	
	public int updateListItemDetails(PP_LIST_ITEM detailsBean) {
		int rowUpdated = 0;
		
		Connection con = null;
		CRUDHandler handler = null;
		
		try {
			con =CommonUtils.getConnection();
			if(con != null){
				handler = new CRUDHandler();
				rowUpdated = handler.executeInsert(detailsBean, con);;
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
	
	public int updateListItemValues(PP_LIST_ITEM_VALUES detailsBean) {
		int rowUpdated = 0;
		
		Connection con = null;
		CRUDHandler handler = null;
		
		try {
			con =CommonUtils.getConnection();
			if(con != null){
				handler = new CRUDHandler();
				rowUpdated = handler.executeInsert(detailsBean, con);;
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

	public ArrayList<PP_LIST_ITEM_VALUES> fetchListItemValues(PP_LIST_ITEM_ACTION pp_list_item_action_bean)
		throws Exception {
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		ArrayList<PP_LIST_ITEM_VALUES> listItemValues = null;
		PP_LIST_ITEM_VALUES listItemValueBean = null;
		
		try {
			Connection connection = CommonUtils.getConnection();
			Object[] paramName = {pp_list_item_action_bean.getPP_LIST_ITEM_BEAN().getLI_SYS_PARAM()};
			resultSet = handler.executeSelectStatement(PP_LIST_ITEM_QUERY_CONSTANTS.SELECT_LIST_ITEMS_VALUES,
					connection,paramName);

			if(resultSet != null) {
				listItemValues = new ArrayList<PP_LIST_ITEM_VALUES>();
				while(resultSet.next()) {
					listItemValueBean = new PP_LIST_ITEM_VALUES();
					listItemValueBean.setROWID(resultSet.getString("ROWID"));
					listItemValueBean.setLIV_SYS_PARAM(resultSet.getString("LIV_SYS_PARAM"));
					listItemValueBean.setLIV_DESC(resultSet.getString("LIV_DESC"));
					listItemValueBean.setLIV_CODE(resultSet.getString("LIV_CODE"));
					listItemValueBean.setLIV_CODE_DESC(resultSet.getString("LIV_CODE_DESC"));
					listItemValueBean.setLIV_BL_CODE_DESC(resultSet.getString("LIV_BL_CODE_DESC"));
					listItemValueBean.setLIV_CR_DT(resultSet.getDate("LIV_CR_DT"));
					listItemValueBean.setLIV_CR_UID(resultSet.getString("LIV_CR_UID"));
					listItemValueBean.setLIV_UPD_DT(resultSet.getDate("LIV_UPD_DT"));
					listItemValueBean.setLIV_UPD_UID(resultSet.getString("LIV_UPD_UID"));
					listItemValueBean.setLIV_REQD_YN(resultSet.getString("LIV_REQD_YN"));
					listItemValueBean.setRowSelected(true);
					listItemValueBean.setRowSelected(false);
					listItemValues.add(listItemValueBean);
				}
				
				pp_list_item_action_bean.setListItemValuesList(listItemValues);
				if(listItemValues.size()>0){
					pp_list_item_action_bean.setPP_LIST_ITEM_VALUES_BEAN(listItemValues.get(0));
					pp_list_item_action_bean.getPP_LIST_ITEM_VALUES_BEAN().setRowSelected(true);
				}else{
						pp_list_item_action_bean.setPP_LIST_ITEM_VALUES_BEAN(new PP_LIST_ITEM_VALUES());
				}
				pp_list_item_action_bean.resetAllChildComponent();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{
			CommonUtils.closeCursor(resultSet);
		}
		return listItemValues;
	}
		
	public List<LovBean> LI_SYS_PARAM_Suggestions(Object value) throws Exception{
		String query = "SELECT DISTINCT LIV_SYS_PARAM,LIV_DESC "
				+ "FROM   PP_LIST_ITEM_VALUES WHERE (LIV_SYS_PARAM LIKE ? OR LIV_DESC LIKE ?)"
				+ " AND ROWNUM < 20 ORDER BY 1 ";
		List<LovBean> beanList = new ArrayList<LovBean>();
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		Object[] values = null;
		ResultSet resultSet = null;
		LovBean lovBean = null;
		
		try {
			value = "*".equals(value) ? "%" : value + "%";
			values = new Object[]{value, value};
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, values);
			while(resultSet.next()){
				lovBean = new LovBean();
				lovBean.setCode(resultSet.getString("LIV_SYS_PARAM"));
				lovBean.setName(resultSet.getString("LIV_DESC"));
				beanList.add(lovBean);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception e){}
		}
		
		return beanList;  
	}

}
