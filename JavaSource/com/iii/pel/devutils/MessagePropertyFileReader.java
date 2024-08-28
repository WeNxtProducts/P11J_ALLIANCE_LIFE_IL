package com.iii.pel.devutils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Set;
import com.iii.apps.persistence.CRUDHandler;
public class MessagePropertyFileReader {
	/*
	 * The following method added by sujatha: for to read the multiple 
	 * message properties file and insert into temporary table
	 */
	
	public static void main(String[] args) throws Exception {
		MessagePropertyFileReader messagePropertyFileReader = new MessagePropertyFileReader();
		String path = "D:\\PropertiesFile"; 
		String files;
		Properties properties = new Properties();
		FileReader reader;
		try {
			File folder = new File(path);
			File[] listOfFiles = folder.listFiles(); 
			for (int i = 0; i < listOfFiles.length; i++)  {
			  if (listOfFiles[i].isFile()) {
				  files = listOfFiles[i].getName();
				  reader = new FileReader(path + "\\" +listOfFiles[i].getName());
				  properties.load(reader);
				  Set<Object> keys = properties.keySet();
				  for (Object obj : keys) {
						System.out.println(obj.toString() + "="
								+ properties.getProperty(obj.toString()));
						String formId = messagePropertyFileReader.getFormId(files);
						messagePropertyFileReader.insertIntoTempTable(obj.toString(),properties.getProperty(obj.toString()),formId);
					}
				   properties.keySet().clear();
				   System.out.println(files);
				 }
			}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} catch (IOException e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} 
	}
	
	public static Connection prepareConnection() throws Exception{
		Connection connection = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@10.44.0.59:1521:ORCL";
		String user = "P11J_LIFE_QC";
		String password = "P11J_LIFE_QC";
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		return connection;
	}
	
	private  String getFormId(String value){
		String files = value;
		String deleString = "_";
		String returnValue = null;
		String[] formId = files.split(deleString);
		String[] value1 = formId[1].split(".properties");
		if(value.contains("_APAC")){
			returnValue = value1[0].concat("_APAC");
		}
		else if(value.contains("_A")){
			returnValue = value1[0].concat("_A");
		}
		else if(value.contains("_A_TISB")){
			returnValue = value1[0].concat("_A_TISB");
		}
		else if(value.contains("_TISB")){
			returnValue = value1[0].concat("_TISB");
		}
		else{
			returnValue = value1[0];
		}
		System.out.println("returnValue is:" + returnValue);
		return returnValue;
	}
	
	private void insertIntoTempTable(String key,String value,String formId) throws Exception{
		try {
			Connection connection = prepareConnection();
			CRUDHandler handler = new CRUDHandler();
			String C1 = "INSERT INTO MSG_PROPERTY VALUES(?,?,?)";
			handler.executeInsertStatement(C1, connection, new Object[] {
					key,value,formId});
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}
	
	/*
	 * The following method for to read the single message properties file
	 * 
	 * public static void main(String[] args) throws Exception {
		Properties properties = new Properties();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@10.44.0.59:1521:orcl", "P11J_LIFE_QC",
				"P11J_LIFE_QC");
		CRUDHandler handler = new CRUDHandler();
		String C1 = "INSERT INTO MSG_PROPERTY VALUES(?,?)";
		String propertiesFile = "D:\\WorkSpace\\INDIVIDUALDPLI\\JavaSource\\messageProperties_PILP014.properties";
		FileReader reader = new FileReader(propertiesFile);
		properties.load(reader);
		Set<Object> keys = properties.keySet();
		for (Object obj : keys) {
			System.out.println(obj.toString() + "="
					+ properties.getProperty(obj.toString()));
			handler.executeInsertStatement(C1, con, new Object[] {
					obj.toString(), properties.getProperty(obj.toString()) });
		}
	}*/
	
	
}
