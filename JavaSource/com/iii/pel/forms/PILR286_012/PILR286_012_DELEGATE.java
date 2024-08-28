package com.iii.pel.forms.PILR286_012;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.utils.CommonUtils;

public class PILR286_012_DELEGATE {

	public void executeSaveAction(IP_REP_INFO ip_rep_info_bean) throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int i = 0;
		try {
			connection = CommonUtils.getConnection();
			if (ip_rep_info_bean.getROWID() == null) {
				i = handler.executeInsert(ip_rep_info_bean, connection);
			} else {
				i = handler.executeUpdate(ip_rep_info_bean, connection);
			}
			connection.commit();
		} finally {
			
		}
	}
	
	
	public List<LovBean> prepareLovList(String query, Object[] obj) {
		List<LovBean> suggestionList = new ArrayList<LovBean>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, obj);
			while (resultSet.next()) {
				LovBean bean = new LovBean();
				bean.setLovCode(resultSet.getString(1));
				bean.setLovName(resultSet.getString(2));
				suggestionList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return suggestionList;
	}
	
	public List<LovBean> prepareDepttLovList(String query, Object[] obj) {
		List<LovBean> suggestionList = new ArrayList<LovBean>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		int columnCount = -1;
		try {
			Connection connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, obj);
			columnCount = resultSet.getMetaData().getColumnCount();
			while (resultSet.next()) {
				LovBean bean = new LovBean();
				bean.setLovCode(resultSet.getString(1));
				bean.setLovName(resultSet.getString(2));
				if(columnCount > 2){
					bean.setLovName1(resultSet.getString(3));
				}
				suggestionList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return suggestionList;
	}
}