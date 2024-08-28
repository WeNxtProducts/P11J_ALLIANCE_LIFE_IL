package com.iii.premia.common.commonimpl.dms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class DMSCryptograph {
	public static String encode(String string){
		String encodedString = null;
		String DECRYPT_QUERY = "SELECT ENCRYPT(?,'3iInfotech') FROM DUAL";
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(DECRYPT_QUERY, 
					connection, new Object[]{string});
			if(resultSet.next()){
				encodedString = resultSet.getString(1);
			}
		}  catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception e){}
		}
		
		return encodedString;
	}
	
	public static String decode(String string){
		String decodedString = null;
		String DECRYPT_QUERY = "SELECT DECRYPT(?,'3iInfotech') FROM DUAL";
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(DECRYPT_QUERY, 
					connection, new Object[]{string});
			if(resultSet.next()){
				decodedString = resultSet.getString(1);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception e){}
		}
		
		return decodedString;
	}
}
