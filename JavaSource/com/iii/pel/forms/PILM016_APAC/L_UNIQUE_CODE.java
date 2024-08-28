package com.iii.pel.forms.PILM016_APAC;


import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
/*
This class is corresponding to the plsql stored procedure L_UNIQUE_CODE
*/
class L_UNIQUE_CODE
{
	public Connection getConnection() throws Exception{
/*		ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		Connection connection = ((SimpleConnectionAgent)context.getAttribute("connectionAgent")).getConnection("12345");*/
		Connection connection = CommonUtils.getConnection();
		return connection;
	}
	
    public  void L_UNIQUE_CODE() 
    {
       
    	CRUDHandler handler=new CRUDHandler();
    	ResultSet resultSet=null;
    	 String resultData=null;
    	String selectQuery="SELECT 'X' FROM  PM_IL_CONTRACTOR  WHERE  CONT_CODE  =?";
    	
		try {
			
			resultSet=handler.executeSelectStatement(selectQuery, getConnection());
			 if(resultSet.next())
	            {
	            	resultData=resultSet.getString(1);
	            }
	            if(!resultSet.isLast())
	            {
	                //STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(71026,:CTRL.M_LANG_CODE);
	                /*71026--This Code already exists.*/
	            	System.out.println("Error Message  :This Code is already exists");
	                //throw new FORM_TRIGGER_FAILURE();
	            }
	    			getConnection().commit();
	            resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
        
       
}




