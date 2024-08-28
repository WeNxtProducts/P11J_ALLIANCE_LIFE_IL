package com.iii.pel.forms.PM102_A_TISB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class SearchPageDelegate {

	/*public Connection getConnection() throws Exception {
		Connection connectionCreate = null;
		ServletContext context = (ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext();
		connectionCreate = ((SimpleConnectionAgent) context
				.getAttribute("connectionAgent")).getConnection(12345);
		return connectionCreate;
		
		// Temp code to get the connection
		Connection connection = null;
		String driverClass = "oracle.jdbc.driver.OracleDriver";
		String databaseUrl = "jdbc:oracle:thin:@10.44.0.138:1521:orcl";
		String databaseUser = "PEL_LIFE";
		String databasePassword = "PEL_LIFE";

		Class.forName(driverClass);
		connection = DriverManager.getConnection(databaseUrl, databaseUser,
				databasePassword);
		return connection;
	}
*/
	public ArrayList<PolicyDetails> fetchPolicyDetails(SearchPageDetailsAction action) throws Exception{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		PolicyDetails details = null;
		ArrayList<PolicyDetails> detailsList = null;
		//String initPolCustCode = null;
		String  initcustbankcode;
		boolean condFlag = false;
		//int initPolPeriod = 0;
		int initmainaccountcode = 0;
		/*String sqlQuery = "select  POL_SYS_ID, POL_UW_YEAR, POL_NO, "
			+ "POL_CUST_CODE, POL_ASSURED_NAME, "
			+ "POL_PERIOD, POL_START_DT, POL_EXPIRY_DT "
			+ "from pt_il_policy";*/
		
		String sqlQuery = "SELECT APAT_RATE,APAT_AGE,APAT_CODE,ROWID FROM PM_AGENT_PF_ACNT_TYPE" ;
			
		System.out.println("PolicyDelegate.fetchPolicyDetails()-sqlQuery"+sqlQuery);

		// Applying initial filter to query string
		/*if(action != null){
			initPolCustCode = action.getInitPolCustCode();
			initPolPeriod = action.getInitPolPeriod();
			initcustbankcode =  action.getInitCustbankcode();
			initmainaccountcode = action.getInitMainaccountcode();
			if(initcustbankcode != null && initcustbankcode.trim().length()>0){
				sqlQuery = sqlQuery+" where UPPER(POL_CUST_CODE) LIKE '%"+initcustbankcode.trim().toUpperCase()+"%'";
				condFlag = true;
			}
			if(initPolPeriod > 0){
				if(condFlag){
					sqlQuery = sqlQuery+" and POL_PERIOD="+initPolPeriod;
				}else{
					sqlQuery = sqlQuery+" where POL_PERIOD="+initPolPeriod;
				}
			}
		}*/
		
		// Fetch details
		
		connection = getConnection();
		if(connection != null){
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery(sqlQuery);
				detailsList = new ArrayList<PolicyDetails>();
				while (resultSet.next()) {
					details = new PolicyDetails();
					/*details.setPOL_SYS_ID(resultSet.getString(1));
					details.setPOL_UW_YEAR(resultSet.getString(2));
					details.setPOL_NO(resultSet.getString(3));
					details.setPOL_CUST_CODE(resultSet.getString(4));
					details.setPOL_ASSURED_NAME(resultSet.getString(5));
					details.setPOL_PERIOD(resultSet.getString(6));
					details.setPOL_START_DT(resultSet.getString(7));
					details.setPOL_EXPIRY_DT(resultSet.getString(8));*/
					details.setAPAT_RATE(resultSet.getDouble(1));
					details.setAPAT_AGE(resultSet.getDouble(2));
					details.setAPAT_CODE(resultSet.getString(3));
					details.setROWID(resultSet.getString(4));
					detailsList.add(details);
				}
			}catch (SQLException e) {
				e.printStackTrace();
				//throw new Exception(e.getMessage());
			}finally{
				//connection.close();
			}
		}
		return detailsList;
	}
	public Connection getConnection() throws Exception{
		/*FacesContext fc = FacesContext.getCurrentInstance();
		ServletContext context = (ServletContext)fc.getExternalContext().getContext();
		SimpleConnectionAgent connectionAgent =  (SimpleConnectionAgent) context.getAttribute("connectionAgent");
		return connectionAgent.getConnection("System.currentTimeMillis()");*/
		
		Connection connection = null;
		try{
			connection = CommonUtils.getConnection();
		} catch(DBException e){
			throw new Exception(e.getMessage());
		}
		
		return connection;
	}
}
