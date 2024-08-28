package com.iii.pel.forms.sms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.net.ssl.HttpsURLConnection;

import sun.misc.BASE64Encoder;

import com.google.gson.Gson;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.ConnectionManager;
import com.iii.apps.persistence.PremiaCryptograph;

public class SmsGenerator {
	private ResourceBundle resourceBundleApp = ResourceBundle.getBundle("Application");
	private ResourceBundle resourceBundleDatabase = ResourceBundle.getBundle("login");

	
	public String generateSMS(String requestContent){
		
		String responseCode = null;
		try {

			URL url = new URL(resourceBundleApp.getString("sms.url"));
			
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", resourceBundleApp.getString("sms.contenttype"));
			
		    
		    final String userName = resourceBundleApp.getString("sms.username");
		    final String password = resourceBundleApp.getString("sms.password");
			byte[] encodedPassword = ( userName + ":" + password ).getBytes();
		    BASE64Encoder encoder = new BASE64Encoder();
		    conn.setRequestProperty( "Authorization",
		                            "Basic " + encoder.encode( encodedPassword ) );

			//String input = "{ \"originator\":\"test\", \"destination\":\"263779775185\", \"messageText\":\"Test Sms from 3iInfotech\", \"messageReference\":\"R99577E\", \"messageDate\": \"20150301230156\" }";
		    
		    String input = requestContent;
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				/*throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());*/
				System.out.println("Failed : HTTP error code : "
						+ conn.getResponseCode());
				responseCode = "Failed : HTTP error code : "
						+ conn.getResponseCode();
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Sms Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println("Sms Response-->"+output);
			}

			conn.disconnect();

		  }catch(Exception e){
			 responseCode = "Unknown error";
			 e.printStackTrace();
		 }
		
		return responseCode;
	}
	
	public void triggerSMS(){
		CRUDHandler handler;
		Connection dbConnection = null; 
		//SendingSms smsUtil = new SendingSms();
		Map<String,String> smsDataMap = null; 
		String beforeUpdateQuery="";
		try{
			System.out.println("Started Sms Trigger...");
			System.out.println("test");
			dbConnection = getConnection();	
			handler = new CRUDHandler();
			String smsDataQuery = resourceBundleApp.getString("sms.datafetchquery");
			ResultSet smsResultSet = handler.executeSelectStatement(smsDataQuery, dbConnection);
			smsDataMap = new HashMap<String,String>();
			Gson gsonObj = new Gson();
			String errorMsg = null;
			
			while(smsResultSet.next()){
				smsDataMap.put("originator", "PREMIADMIN");
				smsDataMap.put("destination", smsResultSet.getString("PLED_TO"));
				smsDataMap.put("messageText", smsResultSet.getString("PLED_BODY"));
				smsDataMap.put("messageReference", "R"+smsResultSet.getString("PLED_SRNO")+"E");
				smsDataMap.put("messageDate", new SimpleDateFormat("yyyyMMddHHmmSS").format(new Date()));
				
				System.out.println("totalMsg->"+smsDataMap.toString());
				
				if(smsResultSet.getString("PLED_TO")!=null)	{							
					errorMsg = generateSMS(gsonObj.toJson(smsDataMap));
				}else{
					errorMsg = "Destination Number not available";
				}
				System.out.println("Response code-->"+errorMsg);
				if(errorMsg!=null){
					beforeUpdateQuery= "UPDATE PW_LIFE_EMAIL_DATA SET PLED_STATUS ='F',PLED_REMARKS=? WHERE PLED_STATUS='N' AND PLED_SRNO = ?";
				}else{
					beforeUpdateQuery= "UPDATE PW_LIFE_EMAIL_DATA SET PLED_STATUS ='Y',PLED_REMARKS=? WHERE PLED_STATUS='N' AND PLED_SRNO = ?";
				}
				new CRUDHandler().executeUpdateStatement(beforeUpdateQuery,dbConnection, new Object[] { errorMsg,smsResultSet.getString("PLED_SRNO")});
				dbConnection.commit();
				
				
			}
			System.out.println();
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			
			if(dbConnection!=null){
				try {
					dbConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		//return "";
		
	}
	
	public static void main(String args[]){
		
		SmsGenerator sendSMS = new SmsGenerator();
		sendSMS.triggerSMS();
	}
	
	public Connection getConnection() throws  Exception {
		Connection dbCon=null;
		String userName = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, resourceBundleDatabase.getString("login_db_user_name"));
		String passWord = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, resourceBundleDatabase.getString("login_db_password"));
		String jdbcURL = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, resourceBundleDatabase.getString("login_db_url"));
		String jdbcDriver = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, resourceBundleDatabase.getString("jdbc.datasource.driver"));
	
		try{
			Class.forName(jdbcDriver);
			dbCon = DriverManager.getConnection(jdbcURL,userName,passWord);
			dbCon.setAutoCommit(false);
		}catch(Exception e){
			
			e.printStackTrace();
		}
		return dbCon;
	}
}
