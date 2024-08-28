package com.iii.premia.common.commonimpl.sso.ssomanager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_LOGIN_SWITCH_DELEGATE {
	public ArrayList<PM_LOGIN_SWITCH> executeQuery(PM_LOGIN_SWITCH loginSwitchFrom) throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		ArrayList<PM_LOGIN_SWITCH> ssoAppMappingList = new ArrayList<PM_LOGIN_SWITCH>();
		PM_LOGIN_SWITCH loginSwitchTo = null;
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(SSO_MANAGER_CONSTANTS.SSO_MANAGER_PM_LOGIN_SWITCH_QUERY, 
					connection,
					new Object[]{loginSwitchFrom.getPLS_FM_APPLICATION(),
							loginSwitchFrom.getPLS_FM_USER_ID(),
							loginSwitchFrom.getPLS_FM_COMPANY(),
							loginSwitchFrom.getPLS_FM_DIVISION(),
							loginSwitchFrom.getPLS_FM_DEPARTMENT()
							});
			while(resultSet.next()){
				loginSwitchTo = new PM_LOGIN_SWITCH();
				loginSwitchTo.setROWID(resultSet.getString("ROWID"));
				loginSwitchTo.setPLS_FM_APPLICATION(resultSet.getString("PLS_FM_APPLICATION"));
				loginSwitchTo.setPLS_FM_USER_ID(resultSet.getString("PLS_FM_USER_ID"));
				loginSwitchTo.setPLS_FM_USER_PWD(resultSet.getString("PLS_FM_USER_PWD"));
				loginSwitchTo.setPLS_FM_COMPANY(resultSet.getString("PLS_FM_COMPANY"));
				loginSwitchTo.setPLS_FM_DIVISION(resultSet.getString("PLS_FM_DIVISION"));
				loginSwitchTo.setPLS_FM_DEPARTMENT(resultSet.getString("PLS_FM_DEPARTMENT"));
				loginSwitchTo.setPLS_TO_APPLICATION(resultSet.getString("PLS_TO_APPLICATION"));
				loginSwitchTo.setPLS_TO_USER_ID(resultSet.getString("PLS_TO_USER_ID"));
				loginSwitchTo.setPLS_TO_USER_PWD(resultSet.getString("PLS_TO_USER_PWD"));
				loginSwitchTo.setPLS_TO_COMPANY(resultSet.getString("PLS_TO_COMPANY"));
				loginSwitchTo.setPLS_TO_DIVISION(resultSet.getString("PLS_TO_DIVISION"));
				loginSwitchTo.setPLS_TO_DEPARTMENT(resultSet.getString("PLS_TO_DEPARTMENT"));
				ssoAppMappingList.add(loginSwitchTo);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
		
		return ssoAppMappingList;
	}
	
	public void deleteRecord(PM_LOGIN_SWITCH toLoginSwitch) throws Exception{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();

		try {
			connection = CommonUtils.getConnection();
			handler.executeDeleteStatement(SSO_MANAGER_CONSTANTS.SSO_MANAGER_PM_LOGIN_SWITCH_DELETE, 
					connection, 
					new Object[]{toLoginSwitch.getROWID()});
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void validateDuplicateSwitch(PM_LOGIN_SWITCH toLoginSwitch) throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(SSO_MANAGER_CONSTANTS.SSO_MANAGER_PM_LOGIN_SWITCH_DUPLICATE_CHECK, 
					connection,
					new Object[]{toLoginSwitch.getPLS_FM_APPLICATION(),
						toLoginSwitch.getPLS_FM_USER_ID(),
						toLoginSwitch.getPLS_FM_COMPANY(),
						toLoginSwitch.getPLS_FM_DIVISION(),
						toLoginSwitch.getPLS_FM_DEPARTMENT(),
						toLoginSwitch.getPLS_TO_APPLICATION(),
						toLoginSwitch.getPLS_TO_USER_ID(),
						toLoginSwitch.getPLS_TO_COMPANY(),
						toLoginSwitch.getPLS_TO_DIVISION(),
						toLoginSwitch.getPLS_TO_DEPARTMENT()});
			if(resultSet.next()){
				if(CommonUtils.isDuplicate(toLoginSwitch.getROWID(), resultSet.getString("ROWID"))){
					throw new Exception(Messages.getString("messageProperties_SSO", 
							"SSO$APPLICATION$SWITCH$DUPLICATE"));
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
	}
	
	public void postRecord(PM_LOGIN_SWITCH toLoginSwitch) throws Exception{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();

		try {
			connection = CommonUtils.getConnection();
			handler.executeInsert(toLoginSwitch, connection);
			// Updating passwords
			handler.executeUpdateStatement(SSO_MANAGER_CONSTANTS.SSO_MANAGER_PM_LOGIN_SWITCH_UPDATE_PASSWORDS, 
					connection, new Object[]{toLoginSwitch.getROWID()});
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public ArrayList<LovBean> prepareSuggestions(final String query, Object[] values) throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		LovBean lovBean = null;
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();

		try {
			connection = CommonUtils.getConnection();
			
			resultSet = handler.executeSelectStatement(query, connection, values);
			while(resultSet.next()){
				lovBean = new LovBean();
				lovBean.setLovCode(resultSet.getString(1));
				lovBean.setLovName(resultSet.getString(2));
				if(resultSet.getMetaData().getColumnCount() > 2){
					lovBean.setLovName1(resultSet.getString(3));
				}
				suggestionList.add(lovBean);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
	
		return suggestionList;
	}
	
	public void deleteMapping(PM_LOGIN_SWITCH fromLoginSwitch) throws Exception{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();

		try {
			connection = CommonUtils.getConnection();
			handler.executeDeleteStatement(SSO_MANAGER_CONSTANTS.SSO_MANAGER_PM_LOGIN_SWITCH_DELETE_MAPPING, 
					connection, 
					new Object[]{fromLoginSwitch.getPLS_FM_APPLICATION(),
						fromLoginSwitch.getPLS_FM_USER_ID(),
						fromLoginSwitch.getPLS_FM_COMPANY(),
						fromLoginSwitch.getPLS_FM_DIVISION(),
						fromLoginSwitch.getPLS_FM_DEPARTMENT()});
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

}
