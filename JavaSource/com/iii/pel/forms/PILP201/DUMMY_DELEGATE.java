package com.iii.pel.forms.PILP201;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;


public class DUMMY_DELEGATE {
	
	public void executeSaveAction(PILP201_REP021_IP_REP_INFO ip_rep_info_bean) {
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
}
