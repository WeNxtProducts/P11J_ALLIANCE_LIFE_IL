package com.iii.pel.login.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.MailManager.MailCreater;
import com.iii.pel.forms.MailManager.MailVO;
import com.iii.premia.common.utils.CommonUtils;


public class PasswordSetupUtility {
	
	//**** Added for Password Management ****///
	public static int countForPasswordHistory(){
		
		int count=-1;
		CRUDHandler handler= new CRUDHandler();
		ResultSet resultSet=null;
		Connection connection=null;
		
		try {
			connection=CommonUtils.getConnection();
			resultSet=handler.executeSelectStatement("SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE='CODES' AND PS_CODE='VAL_PW_CNT'", connection);
			if(resultSet.next()){
				
				count=resultSet.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	/*Method arguement added by R. Raja on 14-12-2016 for RM018T - FSD_IL_ZB Life_030_PREMIA Security*/
	public static  int getNoOfDaysForPasswordHistory( String user_name){
		
		int days=-1;
		CRUDHandler handler= new CRUDHandler();
		ResultSet resultSet=null;
		Connection connection=null;
		
		try {
			connection=CommonUtils.getConnection();
			
			/*Commented by R. Raja on 14-12-2016 for RM018T - FSD_IL_ZB Life_030_PREMIA Security*/ 
			//resultSet=handler.executeSelectStatement("SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE='CODES' AND PS_CODE='USR_EXP_DT'", connection);
			/*end*/
			
			/*added by R. Raja on 14-12-2016 for RM018T - FSD_IL_ZB Life_030_PREMIA Security*/ 
			resultSet=handler.executeSelectStatement("SELECT USER_EXPIRY_DAY_COUNT FROM MENU_USER WHERE USER_ID='"+user_name+"'", connection);
			/*end*/
			if(resultSet.next()){
				days=resultSet.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return days;
	}
	
	public static int getMinReqLengthForPassword(){
		
		int len=-1;
		CRUDHandler handler= new CRUDHandler();
		ResultSet resultSet=null;
		Connection connection=null;
		
		try {
			connection=CommonUtils.getConnection();
			resultSet=handler.executeSelectStatement("SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE='CODES' AND PS_CODE='MIN_PW_LEN'", connection);
			if(resultSet.next()){
				
				len=resultSet.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return len;
	}

	public static void sendNotificationMail(MailVO mailVO) throws Exception {

		MailCreater creater = new MailCreater();;

		try {
				creater.sendMail(mailVO);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
	}
	
	public static String getPassword() {
		
		int lengthOfPassword=getMinReqLengthForPassword();
	    char[] pw = new char[lengthOfPassword];
	    int c  = 'A';
	    for (int i=0; i < lengthOfPassword; i++)
	    {
	    	// r1 = (int)(Math.random() * 3);
	    	//  switch(r1) {
	        //case 0: c = '0' +  (int)(Math.random() * 10); break;
	        //case 1: c = 'a' +  (int)(Math.random() * 26); break;
	    	c = 'A' +  (int)(Math.random() * 26); 
	    	// }
	    	pw[i] = (char)c;
	    }
	    return new String(pw);
	  }
	
	public static void setPASS_EXP_MESSAGE_InSession(String message){
		
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		sessionMap.put("PASS_EXP_MESSAGE", message);
	}
	
	public static String getPASS_EXP_MESSAGE_InSession(String message){
		
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		return (String)sessionMap.get("PASS_EXP_MESSAGE");
	}

	/*Added by Janani on 03.05.2018 as required by Vinoth for changing Password success msg in green color*/ 
	
	public static void setPASS_SUCC_MESSAGE_InSession(String message){

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		sessionMap.put("PASS_SUCC_MESSAGE", message);
	}

	/*End*/
	
	
}
