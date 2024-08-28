package com.iii.premia.common.commonimpl.sso.ssomanager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_APPLICATION_SETUP_DELEGATE {

	public ArrayList<PM_APPLICATION_DTLS> executeQuery() throws Exception {
		ArrayList<PM_APPLICATION_DTLS> PM_APPLICATION_DTLS_LIST = new ArrayList<PM_APPLICATION_DTLS>();
		PM_APPLICATION_DTLS PM_APPLICATION_DTLS_BEAN = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(SSO_MANAGER_CONSTANTS.SSO_MANAGER_PM_APPLICATION_SETUP_QUERY, 
					connection);
			while(resultSet.next()){
				PM_APPLICATION_DTLS_BEAN = new PM_APPLICATION_DTLS();
				PM_APPLICATION_DTLS_BEAN.setROWID(resultSet.getString("ROWID"));
				PM_APPLICATION_DTLS_BEAN.setPAD_APPL_CODE(resultSet.getString("PAD_APPL_CODE"));
				PM_APPLICATION_DTLS_BEAN.setPAD_APPL_DESC(resultSet.getString("PAD_APPL_DESC"));
				PM_APPLICATION_DTLS_BEAN.setPAD_APPL_URL(resultSet.getString("PAD_APPL_URL"));
				PM_APPLICATION_DTLS_LIST.add(PM_APPLICATION_DTLS_BEAN);
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
		
		return PM_APPLICATION_DTLS_LIST;
	}

	public IM_SYSTEM_SETUP postQuery(PM_APPLICATION_DTLS PM_APPLICATION_DTLS_BEAN) throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		IM_SYSTEM_SETUP IM_SYSTEM_SETUP_BEAN = null;
		
		try {
			connection = CommonUtils.getConnection();
			IM_SYSTEM_SETUP_BEAN = new IM_SYSTEM_SETUP();
			resultSet = handler.executeSelectStatement(SSO_MANAGER_CONSTANTS.SSO_MANAGER_PM_APPLICATION_SETUP_POST_QUERY, 
					connection,
					new Object[]{PM_APPLICATION_DTLS_BEAN.getPAD_APPL_CODE(),
						Messages.getString("messageProperties_SSO", "IM_SYSTEM_SETUP$PARA_MODULE")});
			if(resultSet.next()){
				IM_SYSTEM_SETUP_BEAN.setROWID(resultSet.getString("ROWID"));
				IM_SYSTEM_SETUP_BEAN.setPARA_CODE(resultSet.getString("PARA_CODE"));
				IM_SYSTEM_SETUP_BEAN.setPARA_NAME(resultSet.getString("PARA_NAME"));
				IM_SYSTEM_SETUP_BEAN.setPARA_BL_NAME(resultSet.getString("PARA_BL_NAME"));
				IM_SYSTEM_SETUP_BEAN.setPARA_MODULE(resultSet.getString("PARA_MODULE"));
				IM_SYSTEM_SETUP_BEAN.setPARA_VALUE(resultSet.getString("PARA_VALUE"));
				IM_SYSTEM_SETUP_BEAN.setPARA_VALUE_NUM(resultSet.getString("PARA_VALUE_NUM"));
				IM_SYSTEM_SETUP_BEAN.setPARA_USER_MOD_YN_NUM(resultSet.getInt("PARA_USER_MOD_YN_NUM"));
				IM_SYSTEM_SETUP_BEAN.setPARA_CR_UID(resultSet.getString("PARA_CR_UID"));
				IM_SYSTEM_SETUP_BEAN.setPARA_CR_DT(resultSet.getDate("PARA_CR_DT"));
				IM_SYSTEM_SETUP_BEAN.setPARA_UPD_UID(resultSet.getString("PARA_UPD_UID"));
				IM_SYSTEM_SETUP_BEAN.setPARA_UPD_DT(resultSet.getDate("PARA_UPD_DT"));
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
		
		return IM_SYSTEM_SETUP_BEAN;
	}

	public IM_SYSTEM_SETUP postRecord(PM_APPLICATION_DTLS PM_APPLICATION_DTLS_BEAN, 
			IM_SYSTEM_SETUP IM_SYSTEM_SETUP_BEAN) throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		
		try {
			connection = CommonUtils.getConnection();
			handler.executeInsert(IM_SYSTEM_SETUP_BEAN, connection);
			handler.executeInsert(PM_APPLICATION_DTLS_BEAN, connection);
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
		
		return IM_SYSTEM_SETUP_BEAN;
	}

	public void deleteRecord(PM_APPLICATION_DTLS PM_APPLICATION_DTLS_BEAN) throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		
		try {
			connection = CommonUtils.getConnection();
			
			// Deleting PM_APPLICATION_DTLS entry
			handler.executeDeleteStatement(SSO_MANAGER_CONSTANTS.SSO_MANAGER_PM_APPLICATION_DTLS_DELETE, 
					connection, 
					new Object[]{PM_APPLICATION_DTLS_BEAN.getPAD_APPL_CODE()});
			
			// Deleting IM_SYSTEM_SETUP entry
			handler.executeDeleteStatement(SSO_MANAGER_CONSTANTS.SSO_MANAGER_IM_SYSTEM_SETUP_DELETE, 
					connection, 
					new Object[]{PM_APPLICATION_DTLS_BEAN.getPAD_APPL_CODE(),
					Messages.getString("messageProperties_SSO", "IM_SYSTEM_SETUP$PARA_MODULE")});
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	// Validators
	public void validateAppCode(String beanRowId, String currentvalue) throws Exception{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(
					SSO_MANAGER_CONSTANTS.SSO_MANAGER_IM_SYSTEM_SETUP_APP_CODE_DUPLICATE_CHECK, 
					connection, 
					new Object[]{currentvalue});
			if(resultSet.next()){
				if(CommonUtils.isDuplicate(beanRowId, resultSet.getString("ROWID"))){
					throw new Exception(Messages.getString("messageProperties_SSO", 
							"SSO$APPLICATION$DTLS$DUPLICATE_APP_CODE"));
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
	public void validateAppName(String beanRowId, String crrentValue) throws Exception{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(
					SSO_MANAGER_CONSTANTS.SSO_MANAGER_IM_SYSTEM_SETUP_APP_NAME_DUPLICATE_CHECK, 
					connection, 
					new Object[]{crrentValue});
			if(resultSet.next()){
				if(CommonUtils.isDuplicate(beanRowId, resultSet.getString("ROWID"))){
					throw new Exception(Messages.getString("messageProperties_SSO", 
							"SSO$APPLICATION$DTLS$DUPLICATE_APP_NAME"));
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
}
