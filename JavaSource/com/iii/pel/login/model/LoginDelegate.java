package com.iii.pel.login.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.ConnectionManager;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.apps.persistence.PremiaCryptograph;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class LoginDelegate {

	/*Added by Gopi on 5/3/2016 for CompanyCode defaul(Start)*/



public Connection getConnection() throws Exception {
		Connection connection = null;
		String driver_class = Messages.getString("login","jdbc.datasource.driver");
		String driver_url = Messages.getString("login","login_db_url");
		String user_name = Messages.getString("login","login_db_user_name");
		String user_pwd = Messages.getString("login","login_db_password");

        // [ Added for cryptography in property file, Dated: 21-Oct-2011, implemented by: Yalamanda/Manoj
			driver_class = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, driver_class);
			driver_url = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, driver_url);
			user_name = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, user_name);
			user_pwd = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, user_pwd);
    	// Added for cryptography in property file ]    
		
		Class.forName(driver_class);
		System.out.println("driver_url : " + driver_url);
		System.out.println("user_name : " + user_name);
		System.out.println("user_pwd : " + user_pwd);
		connection = DriverManager.getConnection(driver_url,user_name,user_pwd);
		connection.setAutoCommit(false);
		return connection;
	}



public String executeSelectStatement() throws Exception
{
		System.out.println("entering into executeSelectStatement");
	    Connection connection = null;
		String selectStatement = "SELECT COMP_CODE FROM PM_COMPANY";
	    ResultSet resultSet = null;
	    Object[] queryObject = (Object[])null;
	    
	    String companycode = null;
	    try {
	      connection = getConnection();
	    
	        queryObject = new Object[] { 
	           };
 
	      

	      resultSet = new CRUDHandler().executeSelectStatement(
	        selectStatement, connection, queryObject);
	      while (resultSet.next()) {
	      companycode=resultSet.getString("COMP_CODE");
	      }
	      
	    } catch (Exception exception) {
	        exception.printStackTrace();
	        throw new Exception(exception.getMessage());
	      } finally {
	        CommonUtils.closeCursor(resultSet);
	      }
	      System.out.println(companycode);
		return companycode;

}
/*End*/


/*Added by Gopi on 5/3/2016 for Default branch code and Department code(Start)*/
public String executeDefaultBranch(String userName) throws Exception
	{
	System.out.println("userName  IN executeDefaultBranch      "+userName);
	 
		String compcode="101";
		System.out.println("entering into executeDefaultBranch" + userName);
		 Connection connection = null;
			String selectStatement = "SELECT MUCD_DIVN_CODE,MUCD_DEPT_CODE FROM MENU_USER_COMP_DIVN,PM_COMPANY WHERE MUCD_USER_ID = ?  AND MUCD_DIVN_CODE = COMP_DFLT_DIVN AND MUCD_DEPT_CODE = COMP_DFLT_DEPT";
		    ResultSet resultSet = null ;                  
		    Object[] queryObject = (Object[])null;
		    
		    String divisionCode = null;
		    String deptcode = null;
		    try {
		      connection = getConnection();
		    
		      /*Changed by Dhinesh on 30/11/2016 for display default branch*/
		        queryObject = new Object[] { userName
		           };
	 /*End*/
		      

		      resultSet = new CRUDHandler().executeSelectStatement(
		        selectStatement, connection, queryObject);
		      while (resultSet.next()) {
		    	  divisionCode=resultSet.getString("MUCD_DIVN_CODE");
		    	  deptcode =resultSet.getString("MUCD_DEPT_CODE");
		      }
		      
		      /*Added by Ram on 30/11/2016 for Display error Message in label*/
		      if(divisionCode == null)
		      {
		    	  throw new Exception("Branch does not Exists");
		      }
		      if(deptcode == null)
		      {
		    	  throw new Exception("Department Code does not Exists");
		      }
		      /*End*/
		      
		    } catch (Exception exception) {
		        exception.printStackTrace();
		        throw new Exception(exception.getMessage());
		      } finally {
		        CommonUtils.closeCursor(resultSet);
		      }
		    System.out.println("djsdhasjdfnklj"+divisionCode);
		    System.out.println("djsdhasjdfnklj"+deptcode);
		return divisionCode+","+deptcode;
	}

/*End*/

/*Added by ganesh on 13-02-2018 to resolve the login issue in onsite*/
public ArrayList<OracleParameter> P_USER_PWD_ENCRYPT(
		String P_USERID,
		Object P_PASSWORD, Connection connection) throws ProcedureException {
	ArrayList<OracleParameter> parameterList = null;
	ArrayList<OracleParameter> outputList = null;
	try {
		parameterList = new ArrayList<OracleParameter>();
		outputList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_USERID);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PASSWORD);
		parameterList.add(param2);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.executeProc(parameterList, connection,
				"P_USER_PWD_ENCRYPT");
	} catch(Exception e) {
		ErrorHelpUtil.getErrorForProcedure(connection);
		throw new ProcedureException(e.getMessage());
	}
	return outputList;
}
/*end*/


}
