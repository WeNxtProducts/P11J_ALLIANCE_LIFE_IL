package com.iii.pel.forms.PILM038;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PILM038_CRUD 
{
	Connection connection = null;
	List classMasterList=new ArrayList();
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

/*public void  PM_IL_BANK_ACCOUNT_SETUP_PRE_INSERT() throws Exception{
	System.out.println("PM_IL_BANK_ACCOUNT_SETUP_ACTION.PM_IL_BANK_ACCOUNT_SETUP_PRE_INSERT()-Inside");
	 connection = getConnection();
        try
        {
            double M_TEMP=-1;
            CRUDHandler handler = new CRUDHandler();
            String selectQuery1=QueryRepository.PM_IL_BANK_ACCOUNT_SETUP_PRE_INSERT_sql_C1;
            //ResultSet rs=null;
            //Statement stmt_C1=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String selectQuery2=QueryRepository.PM_IL_BANK_ACCOUNT_SETUP_PRE_INSERT_sql_C2;
            //ResultSet rs1=null;
            // Statement stmt_C2=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            //if(isInsert())
          	  System.out.println("PM_IL_BANK_ACCOUNT_SETUP_ACTION.PM_IL_BANK_ACCOUNT_SETUP_PRE_INSERT()-11");
          	  
            	ResultSet rs = handler.executeSelectStatement(selectQuery1, con);
                if(rs!=null)
                {
                    rs.close();
                }
                //rs=stmt_C1.executeQuery(sql_C1);
                if(rs.next())
                {
                    M_TEMP=rs.getDouble(1);
                }
                if(!rs.isLast())
                {
                   // STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(1033,:CTRL.M_LANG_CODE);
                    rs.close();
                    //throw new FORM_TRIGGER_FAILURE();
                }
                rs.close();
            }
            else
            {
            	System.out.println("PM_IL_BANK_ACCOUNT_SETUP_ACTION.PM_IL_BANK_ACCOUNT_SETUP_PRE_INSERT()-ELSE-INSIDE");
            	
            	
            	ResultSet rs1 = handler.executeSelectStatement(selectQuery2, con);
                if(rs1!=null)
                {
                    rs1.close();
                }
                if(rs1.next())
                {
                    M_TEMP=rs1.getDouble(1);
                }
                if(!rs1.isLast())
                {
                    //STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(1033,:CTRL.M_LANG_CODE);
                    rs1.close();
                    //throw new FORM_TRIGGER_FAILURE();
                }
                rs1.close();
            }
        catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        finally
        {
            if(con != null)
            {
                //SwisSqlConnection.getInstance().closeConnection(con);
            	con.close();
            }
        }
	
        ControlBean controlbean = new ControlBean();
	
   PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_CR_DT(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
   PM_IL_BANK_ACCOUNT_SETUP_BEAN.setBAS_CR_UID(controlbean.getM_USER_ID());
}*/







public boolean validateClassCode(String classCode)
{
	ResultSet resultSet=null;
	boolean isExistedClassCode=false;
	try 
	{
		connection=CommonUtils.getConnection();
		String selectQuery="SELECT CC_COVER_CODE FROM PM_IL_CLAIM_COVER WHERE CC_CLAIM_TYPE='"+classCode+"'";
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
		}catch(Exception se){}
	}
	return isExistedClassCode;
	
}

public Object fetchClassDetails(String classCode,Object obj)
{
	
	ResultSet resultSet=null;
	PM_IL_CLAIM_COVER beanClass=(PM_IL_CLAIM_COVER) obj;
	try 
	{
		String query="SELECT CC_COVER_CODE,CC_PROD_CODE,CC_CLAIM_TYPE" +
		"FROM PM_IL_CLAIM_COVER WHERE CC_CLAIM_TYPE='"+classCode+"'";
		System.out.println("In The Select Statement: "+query);
		connection=CommonUtils.getConnection();
		CRUDHandler handler=new CRUDHandler();
		resultSet=handler.executeSelectStatement(query, connection);
		while(resultSet.next())
		{
			beanClass.setCC_COVER_CODE(resultSet.getString(1));
			//beanClass.setCC_PROD_CODE(resultSet.getString(2));
			//beanClass.setUI_M_CC_COVER_CODE_DESC(resultSet.getString(2));
			//beanClass.setCC_EFF_FM_DT(resultSet.getDate(3));
			//beanClass.setCC_EFF_TO_DT(resultSet.getDate(4));
			beanClass.setCC_CR_DT(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
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
		}catch(Exception se){}
	}
	return beanClass;
}
public List fetchClassMasterDetails(ClassMasterSearch classMaster)
{
	ResultSet resultSet=null;
	
	try 
	{
		boolean firstFlag=false;
		String query ="SELECT a.ROWID,a.CC_COVER_CODE,CC_PROD_CODE,CC_CLAIM_TYPE FROM " +
				"PM_IL_CLAIM_COVER a,PM_IL_COVER b WHERE a.CC_COVER_CODE=b.COVER_CODE";
/*		String query = "SELECT ROWID,CC_COVER_CODE,COVER_DESC,CC_EFF_FM_DT,CC_EFF_TO_DT"
			+ " FROM PM_IL_CLAIM_COVER,PM_IL_COVER";*/
		//+ " WHERE CC_COVER_CODE=COVER_CODE"
		
		//SELECT CC_COVER_CODE,COVER_DESC,CC_EFF_FM_DT,CC_EFF_TO_DT FROM PM_IL_CLAIM_COVER,PM_IL_COVER
		//WHERE CC_COVER_CODE=COVER_CODE
		
		
		if(classMaster.getInitClasscode()!=null&&classMaster.getInitClasscode().trim().length()>0)
		{
			//query=query+" WHERE CC_COVER_CODE=COVER_CODE AND UPPER(CC_CLAIM_TYPE) LIKE " + "'"
			//+ classMaster.getInitClasscode().toUpperCase() + "%'";
			query = query+" AND UPPER(a.CC_CLAIM_TYPE) " +
				"LIKE '"+classMaster.getInitClasscode().toUpperCase() + "%'";
			firstFlag=true;
		}
		/*if(classMaster.getInitClassname()!=null&&classMaster.getInitClassname().trim().length()>0)
		{
			if(!firstFlag)
			{
			query=query+" WHERE CC_COVER_CODE=COVER_CODE AND UPPER(CC_CLAIM_TYPE) LIKE " + "'"
			+ classMaster.getInitClassname().toUpperCase() + "%'";
			}
			else
			{
				query=query+" WHERE CC_COVER_CODE=COVER_CODE AND UPPER(CC_COVER_CODE) LIKE " + "'"
				+ classMaster.getInitClassname().toUpperCase() + "%'";
			}
		}*/
		connection=CommonUtils.getConnection();
		CRUDHandler handler=new CRUDHandler();
		System.out.println("Select Query:  "+query);
		resultSet=handler.executeSelectStatement(query, connection);
		while(resultSet.next())
		{
			PM_IL_CLAIM_COVER beanClass=new PM_IL_CLAIM_COVER();
			//PP_SYSTEM ppsystemclass = new PP_SYSTEM();
			beanClass.setROWID(resultSet.getString(1));
			beanClass.setCC_COVER_CODE(resultSet.getString(2));
			//beanClass.setCC_PROD_CODE(resultSet.getString(3));
			//beanClass.setROWID(resultSet.getString(4));
			beanClass.setCC_CLAIM_TYPE(resultSet.getString(4));
			beanClass.setCC_CR_DT(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
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
		}catch(Exception se){}
	}
	return classMasterList;
}
/*public Connection getConnection() throws Exception
{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@10.44.0.138:1521:ORCL","pel_life","pel_life"); 
	return connection;
}*/




public int executeUpdate(PM_IL_CLAIM_COVER pm_im_class)
{
	int rowsEffected=0;
	try
	{
		String updateQuery="UPDATE PM_IL_CLAIM_COVER SET CC_COVER_CODE='"+pm_im_class.getCC_COVER_CODE()+"'," +
				"CC_CLAIM_TYPE='"+pm_im_class.getCC_CLAIM_TYPE()+"'," +
				"setCC_CR_DT='"+pm_im_class.getCC_CR_DT()+"'," +
				" WHERE CC_COVER_CODE='"+pm_im_class.getCC_COVER_CODE()+"'";
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
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	return rowsEffected;
}






public int executeDelete(PM_IL_CLAIM_COVER pm_il_class)
{
	try{
	connection=CommonUtils.getConnection();
	String deleteQuery="DELETE FROM PM_IL_CLAIM_COVER WHERE CC_COVER_CODE='"+pm_il_class.getCC_COVER_CODE()+"'";
	CRUDHandler handler=new CRUDHandler();
	int deleted=handler.executeDeleteStatement(deleteQuery, connection);
	if(deleted>0)
	{
		connection.commit();
		System.out.println("Record Deleted");
	}
	else
	{
		System.out.println("Record Not Deleted");
	}
	}
	catch(Exception e)
	{
		try 
		{
			connection.rollback();
		} catch (Exception se) 
		{
			
		}
		e.printStackTrace();
	}
	
	return 0;
}

public List getClassMasterList() {
	return classMasterList;
}

public void setClassMasterList(List classMasterList) {
	this.classMasterList = classMasterList;
}
}
