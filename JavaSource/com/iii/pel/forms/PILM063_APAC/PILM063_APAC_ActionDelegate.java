package com.iii.pel.forms.PILM063_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.iii.premia.common.utils.CommonUtils;

public class PILM063_APAC_ActionDelegate {
	
	public ResultSet PILM063_APAC_LOV(String query){
		Statement stmt=null;
		ResultSet rs = null;
		try {
				stmt = getConnection().createStatement();
				rs = stmt.executeQuery(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rs;
	} 
	
	/** Database Connection*/
	private Connection getConnection() throws Exception{
		Connection con = CommonUtils.getConnection();
		return con;
	}
	/** Database Connection*/
}
