package com.iii.pel.forms.PM290;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.ServletContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.SimpleConnectionAgent;
import com.iii.pel.login.util.PasswordSetupUtility;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;


public class PM290_PASSWORD_SETUP_HELPER {

	
	public void validateCurrentPassword(PM290_PASSWORD_SETUP_ACTION pm290_password_setup_action,String currentPassword) throws Exception{
		
		PM290_PASSWORD_SETUP pm290_password_setup=pm290_password_setup_action.getPASSWORD_SETUP_BEAN();
		String sql_C1 = "SELECT DECRYPT(USER_PASSWD,'3iInfotech') " +
						"FROM   MENU_USER " +
						"WHERE  USER_ID = ?";
		ResultSet rst_C1 = null;
		CRUDHandler handler = null;
		Connection connection = null;
		String dbCurrentPassword=null;
		
		try {
			 
			  connection = CommonUtils.getConnection(); 
			 
			handler = new CRUDHandler();
			rst_C1 = handler.executeSelectStatement(sql_C1, connection,	new Object[] {pm290_password_setup.getUSER_NAME()});
			if(rst_C1.next()) {
				
				dbCurrentPassword=rst_C1.getString(1);
				if(!dbCurrentPassword.equals(currentPassword)){

					//pm290_password_setup_action.getCOMP_NEW_USER_PASSWORD().setDisabled(true);
					//pm290_password_setup_action.getCOMP_CONFIRM_NEW_USER_PASSWORD().setDisabled(true);
					
					throw new ValidatorException(new FacesMessage("Invalid Password - Please Retry"));
				
				}else{
					
					//pm290_password_setup_action.getCOMP_NEW_USER_PASSWORD().setDisabled(false);
					//pm290_password_setup_action.getCOMP_CONFIRM_NEW_USER_PASSWORD().setDisabled(false);
				}
			}
			CommonUtils.closeCursor(rst_C1);
			/*if (!M_DEC_PASSWD.equals(M_PASSWD)) {
				USER_LOGIN_COUNT++;
				if (USER_LOGIN_COUNT >= M_LOGIN_COUNT) {
					throw new ValidatorException(new FacesMessage("Login Attempt Limit Exceeded : This User id is Locked Contact Administrator"));
				} else {
					USER_LOGIN_COUNT++;
					if (USER_LOGIN_COUNT == M_LOGIN_COUNT) {
						throw new ValidatorException(new FacesMessage("Invalid Password - Please Retry - You have only One attempt Left"));
					} else {
						throw new ValidatorException(new FacesMessage("Invalid Password - Please Retry"));
					}
				}*/
			
			
			String Query="";
			}catch (Exception e) {
				e.printStackTrace();
				throw e;
			}finally {
				CommonUtils.closeCursor(rst_C1);
			}
	}

	public void validateNewPassword(PM290_PASSWORD_SETUP_ACTION pm290_password_setup_action,String newPassword) throws Exception {
		
		int len=newPassword.trim().length();
		System.out.println("Length of new password :"+len);
		PM290_PASSWORD_SETUP pm290_password_setup=pm290_password_setup_action.getPASSWORD_SETUP_BEAN();
		int lengthToBeValidated=PasswordSetupUtility.getMinReqLengthForPassword();
		CRUDHandler handler=new CRUDHandler();
		Connection connection=null;
		ResultSet resultSet=null;
		
		try{
			connection=CommonUtils.getConnection();
			if(len>=lengthToBeValidated){
				
				// Added by Mrityunjay for Caps Checking > Start
				USER_PASSWORD_WHEN_VALIDATE_ITEM(newPassword);
				// Added by Mrityunjay for Caps Checking > End

				// New password can not be equals to the old password
				if(newPassword.equals(pm290_password_setup.getOLD_USER_PASSWORD())){
					throw new ValidatorException(new FacesMessage("Invalid new Password - Cannot be similar to current password!"));
				}else{

					// New password should not match old 3 passwords used
					resultSet=handler.executeSelectStatement("SELECT DECRYPT(UPH_PWD,'3iInfotech') FROM USER_PWD_HISTORY WHERE UPH_USER_ID= ? ", 
							connection,
							new Object[]{pm290_password_setup.getUSER_NAME()});
					while(resultSet.next()){
						if(newPassword.equals(resultSet.getString(1))){
							
							/*ADDED BY RAJA ON 15-06-2017 FOR ZBILQC-1718815*/
							//throw new ValidatorException(new FacesMessage("Invalid new Password - Cannot be similar to last"+PasswordSetupUtility.countForPasswordHistory()+" password!"));
							/*END*/
						}
					}
					//pm290_password_setup_action.getCOMP_CONFIRM_NEW_USER_PASSWORD().setDisabled(false);
				}
			}else{
				throw new ValidatorException(new FacesMessage("Invalid new Password - Must contain "+lengthToBeValidated+" characters!"));
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			try {CommonUtils.closeCursor(resultSet);}catch (Exception e){}
		}
		
		
		
	}

	public void validateConfirmNewPassword(PM290_PASSWORD_SETUP_ACTION pm290_password_setup_action,	String confirmPassword) {
		
		PM290_PASSWORD_SETUP pm290_password_setup=pm290_password_setup_action.getPASSWORD_SETUP_BEAN();
		
		if(pm290_password_setup.getNEW_USER_PASSWORD().equals(confirmPassword)){
			
			//pm290_password_setup_action.getCOMP_UI_M_BUT_OK().setDisabled(false);
			
		}else{
			
			throw new ValidatorException(new FacesMessage("Invalid Entry - Mismatch in new and confirm password!"));
		}
	}

	public void updateData(PM290_PASSWORD_SETUP password_setup_bean) throws Exception {
		
		CRUDHandler handler=new CRUDHandler();
		Connection connection=null;
		ResultSet resultSet1=null;
		ResultSet resultSet2=null;
		Integer noOfExpDays=null;
		Date expDate=null;
		/*added by raja on 10-06-2017 for ZBILQC-1718815*/
		Date sysDate=new CommonUtils().getCurrentDateAndTimeNew();
		/*end*/
		int recordCount=0;
		int pwdHistryCount=PasswordSetupUtility.countForPasswordHistory();
		String updatePasswordQuery = "UPDATE MENU_USER SET USER_PASSWD=ENCRYPT(?,'3iInfotech')," +
			"USER_PASS_EXP_DATE=?,USER_UPD_USER_ID=?,USER_UPD_DATE=? WHERE USER_ID=? ";
		String passwordHistoryUpdateQuery = "UPDATE USER_PWD_HISTORY SET UPH_USER_ID=?,UPH_PWD=ENCRYPT(?,'3iInfotech'),UPH_PWD_DATE=?" +
			" WHERE UPH_PWD_DATE IN(SELECT MIN(UPH_PWD_DATE) FROM USER_PWD_HISTORY WHERE UPH_USER_ID=?)";
		
		/*added by raja on 10-06-2017 for ZBILQC-1718815*/
		String passwordHistoryInsertQuery = "INSERT INTO USER_PWD_HISTORY(UPH_USER_ID,UPH_PWD,UPH_PWD_DATE,UPH_SYS_ID)VALUES(?,ENCRYPT(?,'3iInfotech'),?,?)";
		
		String passwordHistoryCount="select USER_PWD_REUSE_COUNT from MENU_USER WHERE USER_ID=?";
		
		String passwordHistoryQuery="select * from  USER_PWD_HISTORY where uph_user_id=? order by UPH_SYS_ID desc";
		/*String passwordHistoryCount = "SELECT ROWID FROM USER_PWD_HISTORY WHERE UPH_USER_ID=?";*/
		/*added by R. Raja on 14-12-2016 for RM018T - FSD_IL_ZB Life_030_PREMIA Security*/
		String username=null;
		/*end*/
		
		long sys_id=0;
		try {
			connection=CommonUtils.getConnection();
				
			/*added by raja on 10-06-2017 for ZBILQC-1718815*/
			String CURSOR_C1 = "SELECT PWD_UPH_SYS_ID.NEXTVAL FROM DUAL ";
			ResultSet rsSeq = handler.executeSelectStatement(CURSOR_C1, connection);
			if (rsSeq.next()) {
				sys_id=rsSeq.getLong(1);
			}
			/*end*/
			/*added by R. Raja on 14-12-2016 for RM018T - FSD_IL_ZB Life_030_PREMIA Security*/
			username=password_setup_bean.getUSER_NAME();
			noOfExpDays=PasswordSetupUtility.getNoOfDaysForPasswordHistory(username);
			/*end*/
			expDate=CommonUtils.addDaysToDate(sysDate,noOfExpDays);

			//update new password and expiry date of password for the user
			handler.executeUpdateStatement(updatePasswordQuery,
					connection,
					new Object[]{password_setup_bean.getNEW_USER_PASSWORD(),
						CommonUtils.getProcedureValue(expDate),
						password_setup_bean.getUSER_NAME(),
						CommonUtils.getProcedureValue(sysDate),
						password_setup_bean.getUSER_NAME()
					});
		
		
			// Password history count for the user
			resultSet2=handler.executeSelectStatement(passwordHistoryCount, 
					connection,
					new Object[]{password_setup_bean.getUSER_NAME()});
			while(resultSet2.next()){
				/*added by raja on 10-06-2017 for ZBILQC-1718815*/
				/*recordCount++;*/
				recordCount=resultSet2.getInt("USER_PWD_REUSE_COUNT");
				/*end*/
			}
			
			
			/*if(recordCount>=pwdHistryCount){
				// Updating oldest record if already count is equals to allowed password count 
				handler.executeUpdateStatement(passwordHistoryUpdateQuery, 
						connection,
						new Object[]{password_setup_bean.getUSER_NAME(),
							password_setup_bean.getNEW_USER_PASSWORD(),
							new CommonUtils().getCurrentDateAndTime(),
							password_setup_bean.getUSER_NAME()
						}
				);
			}*//*else{*/
				// Inserting new record if less count then allowed count
				handler.executeInsertStatement(passwordHistoryInsertQuery,
						connection,
						new Object[]{password_setup_bean.getUSER_NAME(),
							password_setup_bean.getNEW_USER_PASSWORD(),
							sysDate,sys_id
						}
				);
			/*}*/
				
				
			
			new CommonUtils().doComitt();
			
			clearPASS_EXP_MESSAGE(password_setup_bean.getUSER_NAME());
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			CommonUtils.closeCursor(resultSet1);
			CommonUtils.closeCursor(resultSet2);
		}
	}
	
	
	public void clearPASS_EXP_MESSAGE(String userId) throws Exception {
	
		int EXPIRYDAY = 0;
		int PWD_NOTIFY_DAY = 0;
		
		String sql_C1 = "SELECT   NVL(TRUNC(USER_PASS_EXP_DATE)-TRUNC(SYSDATE),0) " +
				"FROM     MENU_USER " +
				"WHERE    USER_ID = ?";//M_USER_ID_INPUT
		ResultSet rst_C1 = null;
		String sql_C2 = "SELECT   NVL(PS_VALUE,3) " +
				"FROM     PP_SYSTEM " +
				"WHERE    PS_TYPE ='PNOTN_DAYS'";
		ResultSet rst_C2 = null;
		CRUDHandler handler = null;
		Connection connection = null;
		
		try {
			connection=CommonUtils.getConnection();
			handler = new CRUDHandler();
			rst_C1 = handler.executeSelectStatement(sql_C1, connection,	new Object[] {userId});
			if (rst_C1.next()) {
				
				EXPIRYDAY = rst_C1.getInt(1);
				
			} 
			CommonUtils.closeCursor(rst_C1);
			rst_C2 = handler.executeSelectStatement(sql_C2, connection,
					new Object[] {});
			while (rst_C2.next()) {
				PWD_NOTIFY_DAY = rst_C2.getInt(1);
			}
			CommonUtils.closeCursor(rst_C2);
			PWD_NOTIFY_DAY = (PWD_NOTIFY_DAY == 0 ? 3 : PWD_NOTIFY_DAY);

			if (EXPIRYDAY > PWD_NOTIFY_DAY) {
				
				PasswordSetupUtility.setPASS_EXP_MESSAGE_InSession("");
			}
		} finally {
			CommonUtils.closeCursor(rst_C1);
			CommonUtils.closeCursor(rst_C2);
			if (connection != null)
				connection.close();
		}
	}
	
	public void USER_PASSWORD_WHEN_VALIDATE_ITEM(String  password) throws Exception {
		 boolean isCap=false;
		 
		 if(password!=null){
               for(int i=0;i<password.length();i++) {
               	isCap=isCapsAvalable(password.charAt(i));
               	if(isCap) {
               		break;
               	}
               }
               if(!isCap) {
   				throw new Exception("Password should contains atleast one capital letter");
               	
               }
		 }		
	}
	
	private boolean isCapsAvalable(char c) {
		boolean result=false;
		if(c >= 65 && c<=90) {
			result= true;
		}
		return result;
			
	}
}
