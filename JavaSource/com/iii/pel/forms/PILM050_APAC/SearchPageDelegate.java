package com.iii.pel.forms.PILM050_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	}*/

	public ArrayList<PM_IL_BANK_ACCOUNT_SETUP> fetchPolicyDetails(SearchPageDetailsAction action) throws Exception{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		//PolicyDetails details = null;
		PM_IL_BANK_ACCOUNT_SETUP details = null;
		ArrayList<PM_IL_BANK_ACCOUNT_SETUP> detailsList = null;
		//String initPolCustCode = null;
		//String  initcustbankcode;
		String initDivnCode;
		boolean condFlag = false;
		//int initPolPeriod = 0;
		String initmainaccountcode ;
		/*String sqlQuery = "select  POL_SYS_ID, POL_UW_YEAR, POL_NO, "
			+ "POL_CUST_CODE, POL_ASSURED_NAME, "
			+ "POL_PERIOD, POL_START_DT, POL_EXPIRY_DT "
			+ "from pt_il_policy";*/
		
		String sqlQuery = "select  BAS_CUST_BANK_CODE , BAS_OUR_BANK_CODE, BAS_MAIN_ACNT_CODE, "
			+ "BAS_SUB_ACNT_CODE,BAS_DIVN_CODE,"
			+ "BAS_VALUE_FROM,BAS_VALUE_TO," + "ROWID,BAS_TXN_TYPE" 
			+ " FROM PM_IL_BANK_ACCOUNT_SETUP";
		System.out.println("sqlQuery---------------->"+sqlQuery);

		// Applying initial filter to query string
		if(action != null){
			initDivnCode =  action.getInitBasDivnCode();
			initmainaccountcode = action.getInitMainaccountcode();
			if(initDivnCode != null && initDivnCode.trim().length()>0){
				sqlQuery = sqlQuery+" where BAS_DIVN_CODE LIKE '%"+initDivnCode.trim().toUpperCase()+"%'";
				System.out.println("#########"+sqlQuery);
				condFlag = true;
			}
			else if(!"".equals(initmainaccountcode)){
				sqlQuery = sqlQuery + " where UPPER(BAS_MAIN_ACNT_CODE) LIKE '%"+initmainaccountcode+"%'";
				System.out.println("%%%%%%%%"+sqlQuery);
				condFlag = true;
				
			}
			/*if(initPolPeriod > 0){
				if(condFlag){
					sqlQuery = sqlQuery+" and POL_PERIOD="+initPolPeriod;
				}else{
					sqlQuery = sqlQuery+" where POL_PERIOD="+initPolPeriod;
				}*/
			}
		
		
		// Fetch details
		connection = CommonUtils.getConnection();
		if(connection != null){
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery(sqlQuery);
				detailsList = new ArrayList<PM_IL_BANK_ACCOUNT_SETUP>();
				while (resultSet.next()) {
					details = new PM_IL_BANK_ACCOUNT_SETUP();
					/*details.setPOL_SYS_ID(resultSet.getString(1));
					details.setPOL_UW_YEAR(resultSet.getString(2));
					details.setPOL_NO(resultSet.getString(3));
					details.setPOL_CUST_CODE(resultSet.getString(4));
					details.setPOL_ASSURED_NAME(resultSet.getString(5));
					details.setPOL_PERIOD(resultSet.getString(6));
					details.setPOL_START_DT(resultSet.getString(7));
					details.setPOL_EXPIRY_DT(resultSet.getString(8));*/
					details.setBAS_CUST_BANK_CODE(resultSet.getString(1));
					//details.setBANK_CUST_BANK_CODE(resultSet.getString(1));
					details.setBAS_OUR_BANK_CODE(resultSet.getString(2));
					//details.setBANK_CUST_OUR_CODE(resultSet.getString(2));
					details.setBAS_MAIN_ACNT_CODE(resultSet.getString(3));
					//details.setBANK_MAIN_ACNT_CODE(resultSet.getString(3));
					details.setBAS_SUB_ACNT_CODE(resultSet.getString(4));
					//details.setBANK_SUB_ACNT_CODE(resultSet.getString(4));
					details.setBAS_DIVN_CODE(resultSet.getString(5));
					//details.setBANK_BRANCH(resultSet.getString(5));
					//details.setBANK_VALUE_FROM(resultSet.getString(6));
					//details.setBANK_VALUE_TO(resultSet.getString(7));
					details.setROWID(resultSet.getString(8));
					details.setBAS_TXN_TYPE(resultSet.getString(9));
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
	
}
