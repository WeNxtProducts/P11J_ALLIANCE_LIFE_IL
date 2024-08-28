package com.iii.pel.forms.CHART;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class ChartHelper {
	public ArrayList<ChartBean> executeQuery() throws Exception{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ArrayList<ChartBean> chartList = new ArrayList<ChartBean>();
		ChartBean chartBean = null;
		ResultSet resultSet = null;
		ResultSet resultSetUserAcociated = null;
		String query = "SELECT ROWID, PGIM_PORTAL_CHART_QUERY.* FROM PGIM_PORTAL_CHART_QUERY ORDER BY CHART_ID";
		String queryUserAssociated = "SELECT CHART_ID, CHART_USER_ID, CHART_DISP_SEQ_NO " +
				"FROM PGIM_PORTAL_CHART_USER_MAPPING WHERE CHART_ID=? ORDER BY CHART_USER_ID";
		ArrayList<String> userAssociatedList = null;
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection);
			while(resultSet.next()){
				chartBean = new ChartBean();
				chartBean.setROWID(resultSet.getString("ROWID"));
				chartBean.setCHART_ID(resultSet.getString("CHART_ID"));
				chartBean.setCHART_DESC(resultSet.getString("CHART_DESC"));
				chartBean.setCHART_TYPE(resultSet.getString("CHART_TYPE"));
				chartBean.setCHART_QUERY(resultSet.getString("CHART_QUERY"));
				chartBean.setUPDATED_BY(resultSet.getString("UPDATED_BY"));
				chartBean.setUPDATED_DATE(resultSet.getDate("UPDATED_DATE"));
				chartList.add(chartBean);
				
				// Preparing associated user list
				resultSetUserAcociated = handler.executeSelectStatement(queryUserAssociated, 
						connection, new Object[]{chartBean.getCHART_ID()});
				userAssociatedList = new ArrayList<String>();
				while(resultSetUserAcociated.next()){
					userAssociatedList.add(resultSetUserAcociated.getString("CHART_USER_ID"));
				}
				chartBean.setAssociatedUserList((String[]) userAssociatedList.toArray(chartBean.getAssociatedUserList()));
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}  finally{
			try{CommonUtils.closeCursor(resultSet);CommonUtils.closeCursor(resultSetUserAcociated);
			}catch(Exception e){}
		}
		
		return chartList;
	}
	
	public void deleteChart(ChartBean chartBean) throws Exception{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String DELETE_CHART_USER_MAPPING = "DELETE FROM PGIM_PORTAL_CHART_USER_MAPPING WHERE CHART_ID=?";
		
		try {
			connection = CommonUtils.getConnection();
			// Delete chart mapping
			handler.executeDeleteStatement(DELETE_CHART_USER_MAPPING, connection, 
					new Object[]{chartBean.getCHART_ID()});
			// Delete chart
			handler.executeDelete(chartBean, connection);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} 
		}

	public void postChart(ChartBean chartBean) throws Exception{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String DELETE_CHART_USER_MAPPING = "DELETE FROM PGIM_PORTAL_CHART_USER_MAPPING WHERE CHART_ID=?";
		String INSERT_CHART_USER_MAPPING = "INSERT INTO PGIM_PORTAL_CHART_USER_MAPPING(CHART_ID, CHART_USER_ID, CHART_DISP_SEQ_NO) VALUES (?,?,?)";
		Object[] values = null;
		
		try {
			connection = CommonUtils.getConnection();
			prePost(chartBean);
			if(chartBean.getROWID() == null){
				handler.executeInsert(chartBean, connection);
			}else{
				handler.executeUpdate(chartBean, connection);
			}
			
			// Update user association
			handler.executeDeleteStatement(DELETE_CHART_USER_MAPPING, connection, 
					new Object[]{chartBean.getCHART_ID()});
			if(chartBean.getAssociatedUserList() != null){
				for(int index=0, size=chartBean.getAssociatedUserList().length; index<size; index++){
					// Defaulting sequence number as 1
					values = new Object[]{chartBean.getCHART_ID(), chartBean.getAssociatedUserList()[index], 1};
					handler.executeInsertStatement(INSERT_CHART_USER_MAPPING, connection, values);
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void prePost(ChartBean chartBean){
		chartBean.setUPDATED_BY(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
		chartBean.setUPDATED_DATE(new Date());
	}
	
	public void duplicateChartIdValidator(ChartBean chartBean, String chartId) throws Exception{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		String query = "SELECT ROWID FROM PGIM_PORTAL_CHART_QUERY WHERE CHART_ID=?";
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, new Object[]{chartId});
			if(resultSet.next()){
				if(CommonUtils.isDuplicate(chartBean.getROWID(), resultSet.getString("ROWID"))){
					throw new Exception(Messages.getString("messageProperties_CHART", 
							"CHART$CHART_CREATOR$CHART_ID$duplicatechartid"));
				}
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception e){}
		}
		
	}

	public ArrayList<SelectItem> prepareChartTypesList() throws Exception{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ArrayList<SelectItem> chartTypes = new ArrayList<SelectItem>();
		SelectItem selectItem = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM PGIM_PORTAL_CHART_TYPE";
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection);
			while(resultSet.next()){
				selectItem = new SelectItem();
				selectItem.setValue(resultSet.getString("CHART_TYPE_ID"));
				selectItem.setLabel(resultSet.getString("CHART_TYPE_DESC"));
				chartTypes.add(selectItem);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}  finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception e){}
		}
		
		return chartTypes;
	}

	public ArrayList<SelectItem> prepareUserList() throws Exception{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ArrayList<SelectItem> userList = new ArrayList<SelectItem>();
		SelectItem selectItem = null;
		ResultSet resultSet = null;
		String query = "SELECT USER_ID, USER_ID FROM MENU_USER ORDER BY 1";
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection);
			while(resultSet.next()){
				selectItem = new SelectItem();
				selectItem.setValue(resultSet.getString("USER_ID"));
				selectItem.setLabel(resultSet.getString("USER_ID"));
				userList.add(selectItem);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}  finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception e){}
		}
		
		return userList;
	}
	
}
