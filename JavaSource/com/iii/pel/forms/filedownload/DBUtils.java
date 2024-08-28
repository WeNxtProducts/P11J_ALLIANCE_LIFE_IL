package com.iii.pel.forms.filedownload;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

import com.iii.apps.persistence.ConnectionManager;
import com.iii.apps.persistence.PremiaCryptograph;

public class DBUtils {
	private final static ResourceBundle resourceBundleDatabase = ResourceBundle
			.getBundle("login");

	public static Connection getJDBCConnection() throws Exception {
		Connection dbCon = null;
		String userName = PremiaCryptograph.decrypt(
				ConnectionManager.ENCRYPTION_KEY,
				resourceBundleDatabase.getString("login_db_user_name"));
		String passWord = PremiaCryptograph.decrypt(
				ConnectionManager.ENCRYPTION_KEY,
				resourceBundleDatabase.getString("login_db_password"));
		String jdbcURL = PremiaCryptograph.decrypt(
				ConnectionManager.ENCRYPTION_KEY,
				resourceBundleDatabase.getString("login_db_url"));
		String jdbcDriver = PremiaCryptograph.decrypt(
				ConnectionManager.ENCRYPTION_KEY,
				resourceBundleDatabase.getString("jdbc.datasource.driver"));

		try {
			Class.forName(jdbcDriver);
			dbCon = DriverManager.getConnection(jdbcURL, userName, passWord);
			dbCon.setAutoCommit(false);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return dbCon;
	}

}
