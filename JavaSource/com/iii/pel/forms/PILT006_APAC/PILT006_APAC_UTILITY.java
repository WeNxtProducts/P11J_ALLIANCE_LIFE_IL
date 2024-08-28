package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.iii.apps.persistence.CRUDHandler;

@Deprecated
public class PILT006_APAC_UTILITY {

	 
    public Date getDate(Connection conn){
    	String query = "SELECT SYSDATE FROM DUAL";
    	
    	CRUDHandler handler = new CRUDHandler();
    	ResultSet resultSet = null;
    	Date date = null;
    	
    	try {
			resultSet = handler.executeSelectStatement(query, conn);
			if(resultSet.next()){
				date = resultSet.getDate("SYSDATE");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return date;
    }
}
