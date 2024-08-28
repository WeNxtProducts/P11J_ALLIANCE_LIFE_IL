package com.iii.pel.forms.PILR_FUN_01;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class IP_REP_INFO_DELEGATE {

	public void executeSaveAction(IP_REP_INFO ip_rep_info_bean) {
		Connection connection=null;
		CRUDHandler handler=new CRUDHandler();
		int i=0;
		try{
			connection=CommonUtils.getConnection();
			if(ip_rep_info_bean.getROWID()==null){
				i=handler.executeInsert(ip_rep_info_bean, connection);
			}else{
				i=handler.executeUpdate(ip_rep_info_bean, connection);
			}

			System.out.println("No. of Inserted Rows :"+i);
		}catch(SQLException exception){
			exception.printStackTrace();
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
		} catch (DBException e) {
			e.printStackTrace();
		}finally{
			try {
				connection.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public String getRepKeyNo() {
		String repKeyNo=null;
		ResultSet resultSet=null;
		CRUDHandler handler=new CRUDHandler();
		Connection connection=null;

		try {
			connection=CommonUtils.getConnection();
			String sqlQuery=IP_REP_INFO_SQL_QUERY_CONSTANTS.IP_REP_INFO_REP_KEY_NO_SEQUENCE;
			Object[] objects={};
			resultSet=handler.executeSelectStatement(sqlQuery, connection,objects);
			if(resultSet.next()){
				repKeyNo=resultSet.getString(1);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return repKeyNo;
	}
}
