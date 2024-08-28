package com.iii.pel.forms.PILM001;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;



public class PILM001_CRUD 
{
public int executeInsert(Object insertObject)
{
	Connection connection=null;
	int effectedRows=0;
	try
	{
	connection=CommonUtils.getConnection();
	CRUDHandler crudHandler=new CRUDHandler();
	effectedRows=crudHandler.executeInsert(insertObject,connection);
	if(effectedRows>0)
	{
		System.out.println("Inserted Rows!.....");
		connection.commit();
	}
	else
	{
		System.out.println("Not Inserted!...");
	}
	}
	catch(Exception e)
	{
		try{
		connection.rollback();}catch(SQLException se){se.printStackTrace();}
		e.printStackTrace();
	}
	
	
	return effectedRows;
}
public boolean validateClassCode(String classCode)
{
	Connection connection=null;
	ResultSet resultSet=null;
	boolean isExistedClassCode=false;
	try 
	{
		connection=CommonUtils.getConnection();
		String selectQuery="SELECT CLASS_CODE FROM PM_IL_CLASS WHERE CLASS_CODE='"+classCode+"'";
		CRUDHandler handler=new CRUDHandler();
		resultSet=handler.executeSelectStatement(selectQuery,connection);
		if(resultSet.next())
		{
			isExistedClassCode=true;
		}
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	finally
	{
		try
		{
		resultSet.getStatement().close();
		resultSet.close();
		//connection.close();
		}catch(Exception se){}
	}
	return isExistedClassCode;
	
}

public Object fetchClassDetails(String classCode,Object obj)
{
	Connection connection=null;
	ResultSet resultSet=null;
	PM_IL_CLASS beanClass=(PM_IL_CLASS) obj;
	try 
	{
		String query="SELECT ROWID,CLASS_CODE,CLASS_NAME,CLASS_SHORT_NAME,CLASS_FACIN_YN,CLASS_FRZ_FLAG,CLASS_BL_NAME,CLASS_BL_SHORT_NAME,CLASS_CR_DT,CLASS_CR_UID,CLASS_UPD_DT,CLASS_UPD_UID " +
		"FROM PM_IL_CLASS WHERE CLASS_CODE='"+classCode+"'";
		System.out.println("In The Select Statement: "+query);
		connection=CommonUtils.getConnection();
		CRUDHandler handler=new CRUDHandler();
		resultSet=handler.executeSelectStatement(query, connection);
		while(resultSet.next())
		{
			beanClass.setROWID(resultSet.getString("ROWID"));
			beanClass.setCLASS_CODE(resultSet.getString("CLASS_CODE"));
			beanClass.setCLASS_NAME(resultSet.getString("CLASS_NAME"));
			beanClass.setCLASS_SHORT_NAME(resultSet.getString("CLASS_SHORT_NAME"));
			beanClass.setCLASS_BL_NAME(resultSet.getString("CLASS_BL_NAME"));
			beanClass.setCLASS_BL_SHORT_NAME(resultSet.getString("CLASS_BL_SHORT_NAME"));
			beanClass.setCLASS_FACIN_YN(resultSet.getString("CLASS_FACIN_YN"));
			beanClass.setCLASS_FRZ_FLAG(resultSet.getString("CLASS_FRZ_FLAG"));
			beanClass.setCLASS_CR_DT(resultSet.getDate("CLASS_CR_DT"));
			beanClass.setCLASS_CR_UID(resultSet.getString("CLASS_CR_UID"));
			beanClass.setCLASS_UPD_DT(resultSet.getDate("CLASS_UPD_DT"));
			beanClass.setCLASS_UPD_UID(resultSet.getString("CLASS_UPD_UID"));
			beanClass.setInsertMode(false);

			
		}
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
	finally
	{
		try{
		resultSet.getStatement().close();
		resultSet.close();
		//connection.close();
		}catch(Exception se){}
	}
	return beanClass;
}
public ArrayList fetchClassMasterDetails(ClassMasterSearch classMaster)
{
	Connection connection=null;
	ResultSet resultSet=null;
	ArrayList classMasterList=new ArrayList();
	try 
	{
		boolean firstFlag=false;
		String query = "SELECT CLASS_CODE,CLASS_NAME,ROWID "
				+ "FROM PM_IL_CLASS";
		if(classMaster.getInitClasscode()!=null&&classMaster.getInitClasscode().trim().length()>0)
		{
			query=query+" WHERE UPPER(CLASS_CODE) LIKE " + "'"
			+ classMaster.getInitClasscode().toUpperCase() + "%'";
			firstFlag=true;
		}
		if(classMaster.getInitClassname()!=null&&classMaster.getInitClassname().trim().length()>0)
		{
			if(!firstFlag)
			{
			query=query+" WHERE UPPER(CLASS_NAME) LIKE " + "'"
			+ classMaster.getInitClassname().toUpperCase() + "%'";
			}
			else
			{
				query=query+" AND UPPER(CLASS_NAME) LIKE " + "'"
				+ classMaster.getInitClassname().toUpperCase() + "%'";
			}
		}
		connection=CommonUtils.getConnection();
		CRUDHandler handler=new CRUDHandler();
		
		resultSet=handler.executeSelectStatement(query, connection);
		while(resultSet.next())
		{
			PM_IL_CLASS beanClass=new PM_IL_CLASS();
			beanClass.setCLASS_CODE(resultSet.getString("CLASS_CODE"));
			beanClass.setCLASS_NAME(resultSet.getString("CLASS_NAME"));
			beanClass.setROWID(resultSet.getString("ROWID"));
			classMasterList.add(beanClass);
		}
	} 
	catch (Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		try{
		resultSet.getStatement().close();
		resultSet.close();
		//connection.close();
		}catch(Exception se){}
	}
	return classMasterList;
}
public int executeUpdate(PM_IL_CLASS pm_im_class)
{
	Connection connection=null;
	int rowsEffected=0;
	try
	{
		String updateQuery="UPDATE PM_IL_CLASS SET CLASS_NAME='"+pm_im_class.getCLASS_NAME()+"'," +
				"CLASS_SHORT_NAME='"+pm_im_class.getCLASS_SHORT_NAME()+"'," +
				"CLASS_FACIN_YN='"+pm_im_class.getCLASS_FACIN_YN()+"' WHERE CLASS_CODE='"+pm_im_class.getCLASS_CODE()+"'";
		connection=CommonUtils.getConnection();
		System.out.println(updateQuery);
		CRUDHandler handler=new CRUDHandler();
		rowsEffected=handler.executeUpdateStatement(updateQuery,connection);
		if(rowsEffected>0)
		{
			connection.commit();
			System.out.println("Record Updated");
		}
		else
		{
			System.out.println("Record Not Updated");
		}
	} 
	catch (Exception e) 
	{try 
	{
		connection.rollback();
	} catch (Exception ae) {
		ae.printStackTrace();
	}
		e.printStackTrace();
	}
	finally
	{
		try {
			//connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	return rowsEffected;
}
public int executeDelete(List<PM_IL_CLASS> deleteList)
{
	Connection connection=null;
	int recordDeleted=0;
	try{
	connection=CommonUtils.getConnection();
	CRUDHandler handler=new CRUDHandler();
	for(int listidx=0;listidx<deleteList.size();listidx++)
	{
		PM_IL_CLASS pm_il_class=deleteList.get(listidx);
		recordDeleted=handler.executeDelete(pm_il_class,connection);
	}
	if(recordDeleted>0)
	{
		//connection.commit();
		System.out.println("Record Deleted");
	}
	else
	{
		System.out.println("Record Not Deleted");
	}
	}
	catch(Exception e)
	{
			e.printStackTrace();
	}
	
	return recordDeleted;
}
public List<SelectItem> comboValues(String formName,String blkName,String fieldName,String fieldId)
{
	List<SelectItem> comboList=new ArrayList<SelectItem>();
	try
	{
	Connection connection=CommonUtils.getConnection();
	ListItemUtil itemUtil=new ListItemUtil();
	comboList=itemUtil.getDropDownListValue(connection, formName, blkName,fieldName,fieldId);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return comboList;
}
}
