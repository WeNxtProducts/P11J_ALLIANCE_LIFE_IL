package com.iii.pel.forms.MailManager;

import java.sql.Connection;
import java.sql.DriverManager;

import com.iii.apps.persistence.ConnectionManager;
import com.iii.apps.persistence.PremiaCryptograph;
import com.iii.pel.forms.sms.SendingSms;
import com.iii.pel.util.Email_Procedure_Call;

public class sendemailMain {
	SendingSms sendingSms = new SendingSms();
	Connection dbConnection =null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		sendemailMain app = new sendemailMain();
        try {
            app.sendEmail();
        } catch (Exception e) {
            e.printStackTrace();
        }

	}
	
	void sendEmail() throws Exception{
		System.out.println("Database Connected successfully");
		
		sendingSms.sendMail();
//		dbConnection = getConnection();

//		Email_Procedure_Call.emailTriggerProcCall("1100", "RM1", "222", "B", "",dbConnection);
	}
	
	public Connection getConnection() throws  Exception {
		Connection dbCon=null;
		String userName = "P11_AI_LIVE";
		String passWord = "P11_AI_LIVE";
		String jdbcURL = "jdbc:oracle:thin:@192.168.1.80:1521:orcl";
		String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
	
		System.out.println("DB Username["+userName+"]");
		try{
			Class.forName(jdbcDriver);
			dbCon = DriverManager.getConnection(jdbcURL,userName,passWord);
			dbCon.setAutoCommit(false);
			System.out.println("Database Connected successfully");
		}catch(Exception e){
			
//			log.info("While connecting Database");
			e.printStackTrace();
		}
		return dbCon;
	}
}


//import java.sql.Connection;
//import java.sql.DriverManager;
//import javax.mail.MessagingException;
//import com.iii.pel.forms.sms.SendingSms;
//
//public class sendemailMain {
//    SendingSms sendingSms = new SendingSms();
//    Connection dbConnection = null;
//
//    public static void main(String[] args) {
//        sendemailMain app = new sendemailMain();
//        try {
//            app.sendEmail();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    void sendEmail() throws Exception {
//        System.out.println("Database Connected successfully");
//
//        sendingSms.sendMail();
//        // dbConnection = getConnection();
//        // Email_Procedure_Call.emailTriggerProcCall("1100", "RM1", "222", "B", "", dbConnection);
//    }
//
//    public Connection getConnection() throws Exception {
//        Connection dbCon = null;
//        String userName = "P11_AI_LIVE";
//        String passWord = "P11_AI_LIVE";
//        String jdbcURL = "jdbc:oracle:thin:@192.168.1.80:1521:orcl";
//        String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
//
//        System.out.println("DB Username[" + userName + "]");
//        try {
//            Class.forName(jdbcDriver);
//            dbCon = DriverManager.getConnection(jdbcURL, userName, passWord);
//            dbCon.setAutoCommit(false);
//            System.out.println("Database Connected successfully");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return dbCon;
//    }
//}
//
