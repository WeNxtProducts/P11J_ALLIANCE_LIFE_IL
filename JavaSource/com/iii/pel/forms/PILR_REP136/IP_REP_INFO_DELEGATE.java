package com.iii.pel.forms.PILR_REP136;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

public List<PILR_REP136_LovBean> agencyCodeLov(String custCode)
{
	List<PILR_REP136_LovBean> agencyCodeList=new ArrayList<PILR_REP136_LovBean>();
	String selectQuery="SELECT ROWID,CUST_CODE,CUST_NAME,CUST_BL_NAME,CUST_LONG_NAME," +
						"CUST_REF_ID1,CUST_ADDR1 FROM PM_CUSTOMER  " +
						"WHERE PM_CUSTOMER.CUST_FRZ_FLAG = 'N'";
	ResultSet resultSet=null;
	try
	{
	if(!"*".equals(custCode))
	{
		selectQuery=selectQuery+" AND CUST_CODE LIKE '"+custCode+"%'";
	}
	Connection connection=CommonUtils.getConnection();
	resultSet=new CRUDHandler().executeSelectStatement(selectQuery, connection);
	while(resultSet.next())
	{
		PILR_REP136_LovBean lovBean=new PILR_REP136_LovBean();
		lovBean.setCustCode(resultSet.getString("CUST_CODE"));
		lovBean.setCustName(resultSet.getString("CUST_NAME"));
		lovBean.setCustLongName(resultSet.getString("CUST_LONG_NAME"));
		lovBean.setCust_ref_id1(resultSet.getString("CUST_REF_ID1"));
		lovBean.setCustAddr1(resultSet.getString("CUST_ADDR1"));
		agencyCodeList.add(lovBean);
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return agencyCodeList;
}
public List<PILR_REP136_LovBean> unitCodeLov(String unitCode)
{
	List<PILR_REP136_LovBean> agencyCodeList=new ArrayList<PILR_REP136_LovBean>();
	String selectQuery="SELECT ROWID,PC_CODE,PC_DESC,PC_BL_DESC " +
						"FROM PM_CODES WHERE PC_TYPE = 'UNITCODE' " +
						"AND PC_FRZ_FLAG = 'N' AND PC_CLASS_CODE IS NULL";
	ResultSet resultSet=null;
	try
	{
	if(!"*".equals(unitCode))
	{
		selectQuery=selectQuery+" AND  PC_CODE LIKE '"+unitCode+"%'";
	}
	Connection connection=CommonUtils.getConnection();
	resultSet=new CRUDHandler().executeSelectStatement(selectQuery, connection);
	while(resultSet.next())
	{
		PILR_REP136_LovBean lovBean=new PILR_REP136_LovBean();
		lovBean.setPc_code(resultSet.getString("PC_CODE"));
		lovBean.setPc_desc(resultSet.getString("PC_DESC"));
		agencyCodeList.add(lovBean);
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return agencyCodeList;
}
public List<PILR_REP136_LovBean> marketCodeLov(String marketCode)
{
	List<PILR_REP136_LovBean> agencyCodeList=new ArrayList<PILR_REP136_LovBean>();
	String selectQuery="SELECT ROWID,PC_CODE,PC_DESC,PC_BL_DESC " +
						"FROM PM_CODES WHERE PC_TYPE = 'MKTCODE'  " +
						"AND PC_FRZ_FLAG = 'N' AND PC_CLASS_CODE IS NULL";
	ResultSet resultSet=null;
	try
	{
	if(!"*".equals(marketCode))
	{
		selectQuery=selectQuery+" AND  PC_CODE LIKE '"+marketCode+"%'";
	}
	Connection connection=CommonUtils.getConnection();
	resultSet=new CRUDHandler().executeSelectStatement(selectQuery, connection);
	while(resultSet.next())
	{
		PILR_REP136_LovBean lovBean=new PILR_REP136_LovBean();
		lovBean.setPc_code(resultSet.getString("PC_CODE"));
		lovBean.setPc_desc(resultSet.getString("PC_DESC"));
		agencyCodeList.add(lovBean);
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return agencyCodeList;
}
public List<PILR_REP136_LovBean> agentCodeLov(String agentCode)
{
	List<PILR_REP136_LovBean> agencyCodeList=new ArrayList<PILR_REP136_LovBean>();
	String selectQuery="SELECT CUST_CODE, CUST_NAME FROM PM_CUSTOMER WHERE CUST_CLASS IN (SELECT CCLAS_CODE  FROM PM_CUST_CLASS, PP_SYSTEM WHERE INSTR(PS_CODE_DESC,'''' || DECODE(PS_VALUE, 2, CCLAS_CODE, CCLAS_TYPE) || '''') <> 0 AND PS_CODE = 'BROKER' AND PS_TYPE = 'LOV_CUST') AND CUST_FRZ_FLAG = 'N'";
	ResultSet resultSet=null;
	try
	{
	if(!"*".equals(agentCode))
	{
		selectQuery=selectQuery+" AND  CUST_CODE LIKE '"+agentCode+"%'";
	}
	Connection connection=CommonUtils.getConnection();
	resultSet=new CRUDHandler().executeSelectStatement(selectQuery, connection);
	while(resultSet.next())
	{
		PILR_REP136_LovBean lovBean=new PILR_REP136_LovBean();
		lovBean.setCustCode(resultSet.getString("CUST_CODE"));
		lovBean.setCustName(resultSet.getString("CUST_NAME"));
		agencyCodeList.add(lovBean);
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return agencyCodeList;
}

}
