package com.iii.premia.common.commonimpl.sso.ssomanager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class SSO_MANAGER_SEARCH_DELEGATE {
	public ArrayList<PM_LOGIN_SWITCH> getSSOAppMappingList(PM_LOGIN_SWITCH ssoMapping) throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		ArrayList<PM_LOGIN_SWITCH> ssoAppMappingList = new ArrayList<PM_LOGIN_SWITCH>();
		PM_LOGIN_SWITCH ssoAppMapping = null;
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(SSO_MANAGER_CONSTANTS.SSO_MANAGER_SEARCH_APP_MAPPING_FETCH_QUERY, 
					connection,
					new Object[]{ssoMapping.getPLS_FM_APPLICATION() == null?"%":ssoMapping.getPLS_FM_APPLICATION()+"%",
							ssoMapping.getPLS_FM_USER_ID() == null?"%":ssoMapping.getPLS_FM_USER_ID()+"%",
							ssoMapping.getPLS_FM_COMPANY() == null?"%":ssoMapping.getPLS_FM_COMPANY()+"%",
							ssoMapping.getPLS_FM_DIVISION() == null?"%":ssoMapping.getPLS_FM_DIVISION()+"%",
							ssoMapping.getPLS_FM_DEPARTMENT() == null?"%":ssoMapping.getPLS_FM_DEPARTMENT()+"%"/*,
							ssoMapping.getPLS_TO_APPLICATION() == null?"%":ssoMapping.getPLS_TO_APPLICATION()+"%",
							ssoMapping.getPLS_TO_USER_ID() == null?"%":ssoMapping.getPLS_TO_USER_ID()+"%",
							ssoMapping.getPLS_TO_USER_PWD() == null?"%":ssoMapping.getPLS_TO_USER_PWD()+"%",
							ssoMapping.getPLS_TO_COMPANY() == null?"%":ssoMapping.getPLS_TO_COMPANY()+"%",
							ssoMapping.getPLS_TO_DIVISION() == null?"%":ssoMapping.getPLS_TO_DIVISION()+"%",
							ssoMapping.getPLS_TO_DEPARTMENT() == null?"%":ssoMapping.getPLS_TO_DEPARTMENT()+"%",*/
							});
			while(resultSet.next()){
				ssoAppMapping = new PM_LOGIN_SWITCH();
				//ssoAppMapping.setROWID(resultSet.getString("ROWID"));
				ssoAppMapping.setPLS_FM_APPLICATION(resultSet.getString("PLS_FM_APPLICATION"));
				ssoAppMapping.setPLS_FM_USER_ID(resultSet.getString("PLS_FM_USER_ID"));
				ssoAppMapping.setPLS_FM_USER_PWD(resultSet.getString("PLS_FM_USER_PWD"));
				ssoAppMapping.setPLS_FM_COMPANY(resultSet.getString("PLS_FM_COMPANY"));
				ssoAppMapping.setPLS_FM_DIVISION(resultSet.getString("PLS_FM_DIVISION"));
				ssoAppMapping.setPLS_FM_DEPARTMENT(resultSet.getString("PLS_FM_DEPARTMENT"));
				/*ssoAppMapping.setPLS_TO_APPLICATION(resultSet.getString("PLS_TO_APPLICATION"));
				ssoAppMapping.setPLS_TO_USER_ID(resultSet.getString("PLS_TO_USER_ID"));
				ssoAppMapping.setPLS_TO_USER_PWD(resultSet.getString("PLS_TO_USER_PWD"));
				ssoAppMapping.setPLS_TO_COMPANY(resultSet.getString("PLS_TO_COMPANY"));
				ssoAppMapping.setPLS_TO_DIVISION(resultSet.getString("PLS_TO_DIVISION"));
				ssoAppMapping.setPLS_TO_DEPARTMENT(resultSet.getString("PLS_TO_DEPARTMENT"));*/
				ssoAppMappingList.add(ssoAppMapping);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
		
		return ssoAppMappingList;
	}
}
