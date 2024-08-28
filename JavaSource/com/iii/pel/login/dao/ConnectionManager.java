package com.iii.pel.login.dao;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

public class ConnectionManager {
	
//	private static DataSource dataSource = null;
	
	/*public static Connection getConnection(){
		Connection connection = null;
		InitialContext initialContext = null;
        String jndiName = null;
        try {
            if (dataSource == null) {
                initialContext = new InitialContext();
                jndiName = PropertyManager.getValue("jdbc.datasource.jndiname");
                dataSource = (DataSource) initialContext.lookup(jndiName);
            }
            connection = dataSource.getConnection();
        } catch (NamingException exc) {
        } catch (SQLException exc) {
        }
		return connection;
	}*/
	
	public static Connection getConnection(HttpServletRequest request){
		Connection connection = null;
		/*try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@10.44.0.131:1521:IORCL", "P9STM_CORE", "P9STM_CORE");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		connection = (Connection) request.getSession().getAttribute("CONNECTION.LOGIN");
//		connection = (Connection)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("CONNECTION.LOGIN");
		return connection;
	}

}
