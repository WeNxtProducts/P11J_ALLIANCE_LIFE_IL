package com.iii.pel.devutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;



public class ResultSetUtility {
	public static Connection prepareConnection() throws Exception{
		Connection connection = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@10.44.0.59:1521:ORCL";
		String user = "P11J_LIFE";
		String password = "P11J_LIFE";
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return connection;
	}
	
	public static void prepareResultSetOperation(String resultSetObjectName, String beanName, String tableName){
		String query = "SELECT ROWID, "+tableName+".* FROM "+tableName+" WHERE 1 = 2";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSetMetaData metaData = null;
		
		try {
			connection = prepareConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			metaData = resultSet.getMetaData();
			for(int index=1, columnCount = metaData.getColumnCount(); index <= columnCount; index++){
				System.out.println(beanName+".set"+metaData.getColumnName(index)
						+"("+resultSetObjectName+".get"
						+getJavaType(metaData.getColumnType(index))
						+"(\""+metaData.getColumnName(index) + "\"));");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {connection.close();} catch (SQLException e) {}
		}
	}
	
	private static String getJavaType(int sqlType){
		String javaType = null;
		
		switch(sqlType){
		case Types.CHAR:
		case Types.VARCHAR:
			javaType = "String";
			break;
		case Types.INTEGER:
		case Types.NUMERIC:
			javaType = "Int";
			break;
		case Types.DATE:
			javaType = "Date";
			break;
		case Types.DOUBLE:
		case Types.FLOAT:
			javaType = "Double";
			break;
		default:
			javaType = "String";
		}
		
		return javaType;
	}
	
	public static void main(String[] args) {
		prepareResultSetOperation("resultSet", "PS_IL_POL_INVEST_SUMMARY_BEAN", "PS_IL_POL_INVEST_SUMMARY");
	}
}
