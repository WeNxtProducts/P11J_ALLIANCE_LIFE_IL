package com.iii.pel.forms.PM094_A;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_AGENT_BONUS_APPL_PROD_DELEGATE {

	public int deleteApplProd(PM_AGENT_BONUS_APPL_PROD bean) throws DBException {
		int deletedRec=-1;
		Connection connection=CommonUtils.getConnection();
		CRUDHandler handler=new CRUDHandler();
		try {
			deletedRec=handler.executeDelete(bean, connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deletedRec;
	}

	public int executeInsert(PM_AGENT_BONUS_APPL_PROD gridValueBean) throws DBException {
		Connection connection=CommonUtils.getConnection();
		CRUDHandler handler=new CRUDHandler();
		int i=-1;
		try {
			i=handler.executeInsert(gridValueBean, connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public List prodCodeLOV(String query, Object[] object) {
		List<PM_AGENT_BONUS_APPL_PROD> prodCodeList = new ArrayList<PM_AGENT_BONUS_APPL_PROD>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection=null;
		try
			{
			connection=CommonUtils.getConnection();
			System.out.println("qUERY :"+query);
			System.out.println(" Object :"+object);
			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				PM_AGENT_BONUS_APPL_PROD pm_agent_bonus_appl_prod = new PM_AGENT_BONUS_APPL_PROD();
				pm_agent_bonus_appl_prod.setABAP_PROD_CODE(resultSet.getString(1));
				pm_agent_bonus_appl_prod.setUI_M_ABAP_PROD_CODE_DESC(resultSet.getString(2));
				prodCodeList.add(pm_agent_bonus_appl_prod);
			}
			}
			catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return prodCodeList;
	}

}
