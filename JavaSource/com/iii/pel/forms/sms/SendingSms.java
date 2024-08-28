package com.iii.pel.forms.sms;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.ConnectionManager;
import com.iii.apps.persistence.PremiaCryptograph;
import com.iii.pel.forms.MailManager.MailCreater;
import com.iii.pel.forms.MailManager.MailVO;
import com.iii.pel.util.Email_Procedure_Call;
import com.iii.premia.common.utils.CommonUtils;

public class SendingSms {
	private final static Logger log= Logger
			.getLogger(SendingSms.class);
	Connection dbConnection =null;
	private ResourceBundle resourceBundleApp = ResourceBundle.getBundle("Application");
	private ResourceBundle resourceBundleDatabase = ResourceBundle.getBundle("login");
	public Email_Procedure_Call email_procedure_call=new Email_Procedure_Call();
	
	public SendingSms() { 
		
		log.info("Email Object instantiated");
		
	}
	
		
	public Connection getConnection() throws  Exception {
		Connection dbCon=null;
		String userName = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, resourceBundleDatabase.getString("login_db_user_name"));
		String passWord = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, resourceBundleDatabase.getString("login_db_password"));
		String jdbcURL = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, resourceBundleDatabase.getString("login_db_url"));
		String jdbcDriver = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, resourceBundleDatabase.getString("jdbc.datasource.driver"));
	
		log.info("DB Username["+userName+"]");
		try{
			Class.forName(jdbcDriver);
			dbCon = DriverManager.getConnection(jdbcURL,userName,passWord);
			dbCon.setAutoCommit(false);
			log.info("Database Connected successfully");
		}catch(Exception e){
			
			log.info("While connecting Database");
			e.printStackTrace();
		}
		return dbCon;
	}

	
	
	/*Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
	public void lapseremainderMail()
	{
		try {

		Date issue_date=null;
		String mail_id=null;
		Long pol_sys_id=null;
		String prod_code=null;
		ResultSet remainderResultSet = null;
		ResultSet remainderResultSet1 = null;
		ResultSet remainderResultSet2 = null;
		dbConnection = getConnection();
		Date simpledateformat = new Date();
		String sysDate=new SimpleDateFormat("dd/MMM/yyyy").format(simpledateformat);
		CRUDHandler handler=new CRUDHandler();
		System.out.println("status date:::::"+sysDate);
		
		/*Modified by ganesh on 29-11-2017 for ZBLIFE-1458884*/
		/*String Prelapse1reminderQuery="SELECT POL_PROD_CODE,POL_SYS_ID FROM PT_IL_POLICY,PT_IL_POL_STATUS "
										+ "WHERE PS_POL_SYS_ID=POL_SYS_ID AND PS_STATUS ='L01' AND PS_STATUS_DT =?";*/
		String Prelapse1reminderQuery="SELECT POL_PROD_CODE,POL_SYS_ID FROM PT_IL_POLICY,PT_IL_POL_STATUS "
				+ "WHERE PS_POL_SYS_ID=POL_SYS_ID AND PS_STATUS ='L01' AND NVL(TO_DATE(PS_CR_DT,'DD/MM/RRRR'),TO_DATE(PS_STATUS_DT,'DD/MM/RRRR')) =?";
		/*end*/
		remainderResultSet=handler.executeSelectStatement(Prelapse1reminderQuery, dbConnection,
				new Object[]{sysDate});
		while(remainderResultSet.next())
		{
			prod_code=remainderResultSet.getString("POL_PROD_CODE");
			pol_sys_id=remainderResultSet.getLong("POL_SYS_ID");
			/*System.out.println("product code"+prod_code);
			System.out.println("polsysid"+pol_sys_id);
			System.out.println("enter into the pre-lapse1 remainder mail schedule");*/
			Email_Procedure_Call.emailTriggerProcCall(prod_code, "PL1", pol_sys_id.toString(),"C", "",dbConnection);

		}
		/*Modified by ganesh on 29-11-2017 for ZBLIFE-1458884*/
		/*String Prelapse2reminderQuery="SELECT POL_PROD_CODE,POL_SYS_ID FROM PT_IL_POLICY,PT_IL_POL_STATUS "
										+ "WHERE PS_POL_SYS_ID=POL_SYS_ID AND PS_STATUS ='L02' AND PS_STATUS_DT =?";*/
		String Prelapse2reminderQuery="SELECT POL_PROD_CODE,POL_SYS_ID FROM PT_IL_POLICY,PT_IL_POL_STATUS "
				+ "WHERE PS_POL_SYS_ID=POL_SYS_ID AND PS_STATUS ='L02' AND NVL(TO_DATE(PS_CR_DT,'DD/MM/RRRR'),TO_DATE(PS_STATUS_DT,'DD/MM/RRRR')) =?";
		/*end*/

		remainderResultSet1=handler.executeSelectStatement(Prelapse2reminderQuery, dbConnection,
				new Object[] {sysDate});
		while(remainderResultSet1.next())
		{

			prod_code=remainderResultSet1.getString("POL_PROD_CODE");
			pol_sys_id=remainderResultSet1.getLong("POL_SYS_ID");
			/*System.out.println("product code"+prod_code);
			System.out.println("polsysid"+pol_sys_id);
			System.out.println("enter into the pre-lapse2 remainder mail schedule");*/
			Email_Procedure_Call.emailTriggerProcCall(prod_code, "PL2", pol_sys_id.toString(),"C", "",dbConnection);

		}
		/*Modified by ganesh on 29-11-2017 for ZBLIFE-1458884*/
		/*String LapsedreminderQuery="SELECT POL_PROD_CODE,POL_SYS_ID FROM PT_IL_POLICY,PT_IL_POL_STATUS "
									+ "WHERE PS_POL_SYS_ID=POL_SYS_ID AND PS_STATUS ='I05' AND PS_STATUS_DT =?";*/
		String LapsedreminderQuery="SELECT POL_PROD_CODE,POL_SYS_ID FROM PT_IL_POLICY,PT_IL_POL_STATUS "
				+ "WHERE PS_POL_SYS_ID=POL_SYS_ID AND PS_STATUS ='I05' AND NVL(TO_DATE(PS_CR_DT,'DD/MM/RRRR'),TO_DATE(PS_STATUS_DT,'DD/MM/RRRR')) =?";
		/*end*/
		remainderResultSet2=handler.executeSelectStatement(LapsedreminderQuery, dbConnection,
				new Object[] {sysDate});
		while(remainderResultSet2.next())
		{

			prod_code=remainderResultSet2.getString("POL_PROD_CODE");
			pol_sys_id=remainderResultSet2.getLong("POL_SYS_ID");
			/*System.out.println("product code"+prod_code);
			System.out.println("polsysid"+pol_sys_id);
			System.out.println("enter into the lapsed remainder mail schedule");*/
			Email_Procedure_Call.emailTriggerProcCall(prod_code, "LAP", pol_sys_id.toString(),"C", "",dbConnection);

		}
		 
		/* End*/
			
		/*Commentted by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
		
		/*Date expiry_date=null;
		int exp_day_count=0;
		String user_name=null;
		
	   	String tomail="SELECT USER_EXPIRY_DAY_COUNT,USER_PASS_EXP_DATE,USER_ID FROM MENU_USER";
	   	ResultSet userResultSet = null;
	   	userResultSet=handler.executeSelectStatement(tomail, dbConnection);
	   	while(userResultSet.next())
	   	{
	   		expiry_date=userResultSet.getDate("USER_PASS_EXP_DATE");
	   		exp_day_count=userResultSet.getInt("USER_EXPIRY_DAY_COUNT");
	   		user_name=userResultSet.getString("USER_ID");
	   		System.out.println("user id  === >  "+userResultSet.getString("USER_ID"));
	   		System.out.println("user id  === >  "+CommonUtils.subtractDate(expiry_date, date));
	   		System.out.println("Compare To === > "+expiry_date.compareTo(date));
	   		
	   		
	   		SimpleDateFormat fomat=new SimpleDateFormat("yyyy-MM-dd");
	   		int remainingdays=CommonUtils.subtractDate(expiry_date, date)+1;
	   		if(remainingdays==exp_day_count)
	   		{
	   			System.out.println("your password is going to expiry on "+exp_day_count+" days");
	   		}
	   		if(CommonUtils.subtractDate(expiry_date, date)==0)
	   		{
	   			System.out.println("your password is going to expiry on today");
	   			String subject="SELECT PMT_PROD_CODE,PMT_MAIL_SUB,PMT_MAIL_TEXT FROM PM_LIFE_MAIL_TEMPLATE WHERE PMT_MAIL_TYPE = 'EXP'";
			   	String tomailquery="SELECT USER_EMAIL_ID FROM MENU_USER WHERE USER_ID= ?";
			   	String insert="INSERT INTO PW_LIFE_EMAIL_DATA (PLED_SRNO, PLED_TYPE, PLED_TO, PLED_SUB, PLED_BODY, PLED_STATUS) VALUES (PIL_MAIL_SYS_ID.NEXTVAL,?,?,?,?,?)";
			   	String out="N";
			   	ResultSet rs2=null;
			   	ResultSet rs3=null;
			   	Object[] values = { user_name };
			   	int seqno = 0;
			   	String productcode = null;
			   	String sub = null;
			   	String body = null;
			   	String mailid = null;
			   	Connection con=getConnection();
			   	System.out.println("Connection :"+con);

			   	rs2=new CRUDHandler().executeSelectStatement(subject, con);
			   	rs3=new CRUDHandler().executeSelectStatement(tomail, con, values);
			  
			   	if(rs2.next()){
			   		productcode=rs2.getString("PMT_PROD_CODE");
			   		sub=rs2.getString("PMT_MAIL_SUB");
			   		body=rs2.getString("PMT_MAIL_TEXT");
			   	}
			   	if(rs3.next()){
			   		mailid=rs3.getString("USER_EMAIL_ID");
			   		if(mailid!=null){
			   		out="Y";
			   		}
			   	}
			   	System.out.println("seqno  :"+seqno);
			   	System.out.println("mailid  :"+mailid);
				System.out.println("sub  :"+sub);
				System.out.println("body  :"+body);
			   	Object[] values1 = {"EXP",mailid,sub,body,"N" };
			   	new CRUDHandler().executeInsertStatement(insert, con, values1);
			   	con.commit();
	   		}
	   	}*/
		
		/*End*/
	   	
	   	sendMail();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	
	
	public void sendMail() {
		try{
			log.info("Entered Send Mail method   ");
		MailVO mailVO= new MailVO();
		CRUDHandler handler;		
		String emailDataQuery=null;
		boolean isMailSend = false;
		
		ResultSet emailResultSet = null;
		List<String> emailToList = null;	
		/* Added by ganesh on 28-06-2017,ZBILQC-1725181 */
		List<String> emailCcList = null;
		
		/* end */
		
		dbConnection = getConnection();		
		handler = new CRUDHandler();	
		List<File> emailFileList = null;
		emailDataQuery = resourceBundleApp.getString("email.datafetchquery");
		emailResultSet = handler.executeSelectStatement(emailDataQuery, dbConnection);
				
		while(emailResultSet.next()){
			/*Added by Raja R on 04-07-2016.SSP Call ID - FALCONQC-1714578
            Start*/ 
			emailToList = new ArrayList<String>();	
			
			/* Added by ganesh on 28-06-2017,ZBILQC-1725181 */
			emailCcList = new ArrayList<String>();
			/* end */
			
			emailFileList = new ArrayList<File>();
			log.info("Count :"+emailResultSet.getInt("PLED_COUNT"));
			String error = null;
			int count = emailResultSet.getInt("PLED_COUNT");
			/*End of SSP Call ID - FALCONQC-1714578 */
			isMailSend = false; //reset the flag initially for all records, once mail sent it becomes true.
			log.info("Before mail flag ["+emailResultSet.getString("PLED_STATUS")+"]");
			if(emailResultSet.getString("PLED_STATUS").equalsIgnoreCase("N")){
				log.info("Ready to setup the mail Process");				
				if(emailResultSet.getString("PLED_TO")!=null){				
				emailToList.add(emailResultSet.getString("PLED_TO"));
				
				mailVO.setToList(emailToList);				
				mailVO.setSubject(emailResultSet.getString("PLED_SUB"));
				mailVO.setMessageBody(emailResultSet.getString("PLED_BODY"));
				if(emailResultSet.getString("PLED_FILE_NAME") != null){
					mailVO.setFileName(emailResultSet.getString("PLED_FILE_NAME"));
				}
					
				if(emailResultSet.getString("PLED_FILE_PATH")!=null){
					/*commented added by Sivarajan on 12-08-2018 for FSD_IL_FLA_005*/
					/*for(int j=0;j<emailResultSet.getString("PLED_FILE_PATH").split("\\|").length;j++){
						//emailFileList.add(new File(emailResultSet.getString("PLED_FILE_PATH").split("\\|")[j]));
					}
					mailVO.setFileList(emailFileList);*/
					/*End*/
					
					/*Added by Sivarajan on 12-08-2018 for FSD_IL_FLA_005*/
					URL url = new URL((String)emailResultSet.getString("PLED_FILE_PATH"));
					System.out.println("url"+url);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					InputStream is = null;
					is = url.openStream();
					byte[] byteChunk = new byte[1024]; // Or whatever size you want to read in at a time.
					for (int readNum; (readNum = is.read(byteChunk)) != -1;) {
						baos.write(byteChunk, 0, readNum); //no doubt here is 0				               
		            }

					mailVO.setByteArray(baos.toByteArray());
					/*End*/
				}
			
				/* Added by ganesh on 28-06-2017,ZBILQC-1725181 */
				if (emailResultSet.getString("PLED_CC") != null) {
					emailCcList = Arrays.asList(emailResultSet
							.getString("PLED_CC").split(","));
					mailVO.setCcList(emailToList);
				}
				/* end */
				
				
				log.info("To email List size:"+emailToList.size());
				log.info("sub"+mailVO.getSubject());
				log.info("sub"+mailVO.getMessageBody());	
				
				log.info("After sendMail method call ");
				log.info("ref ID"+emailResultSet.getString("PLED_SRNO"));
				String beforeUpdateQuery= "UPDATE PW_LIFE_EMAIL_DATA SET PLED_STATUS ='Y' WHERE PLED_STATUS='N' AND PLED_SRNO = ?";
				new CRUDHandler().executeUpdateStatement(beforeUpdateQuery,dbConnection, new Object[] { emailResultSet.getString("PLED_SRNO")});
				dbConnection.commit();

				
				try{
				
					MailCreater mailCreater = new MailCreater();
					mailCreater.sendMail(mailVO);
					isMailSend = true;
					log.info("mail Send Status :"+isMailSend);
				}catch(Exception e1){
					//isMailSend = false;
					log.error("failed!"+e1);
					error=e1.toString();
					
					
				}
				
				
				//updating mail flag to Y if success
				if(!isMailSend){
					if(count<3){
						log.info("After sendMail method call where count lesser than 3 ");
						int dbcount=count+1;
						String afterUpdateQuery= "UPDATE PW_LIFE_EMAIL_DATA SET PLED_STATUS ='N', PLED_COUNT = ?, PLED_REMARKS = ? WHERE PLED_STATUS='Y' AND PLED_SRNO = ?";
						new CRUDHandler().executeUpdateStatement(afterUpdateQuery,dbConnection, new Object[] {dbcount,error,emailResultSet.getString("PLED_SRNO")});
						dbConnection.commit();
					}else{
						log.info("After sendMail method call where count greater than 3 ");
						String afterUpdateQuery= "UPDATE PW_LIFE_EMAIL_DATA SET PLED_STATUS ='F' WHERE PLED_STATUS='Y' AND PLED_SRNO = ?";
						new CRUDHandler().executeUpdateStatement(afterUpdateQuery,dbConnection, new Object[] {emailResultSet.getString("PLED_SRNO")});
						dbConnection.commit();
					}
				}	
			}	
			
			}
			
		}
		
		/*Added by saritha on 29-06-2017 for ssp call id ZBILQC-1719714 &ZBILQC-1719734*/
		emailResultSet.close();
		/*End*/
		}catch(Exception e){
			e.printStackTrace();
			//throw new RuntimeException(e);
			
		}finally{
			try {
				dbConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		

	}
/*Added by Saranya  for RM018T - FSD_IL_ZB Life_016-Queried Proposals v1 on 26-12-2016*/
	public void remainderMail()
	{
		try {
			CRUDHandler handler =null;		
			Date issue_date=null;
			Date date = new Date();
			//String mail_id=null;
			String prod_code=null;
			String pol_sys_id=null;
			String pol_addl_status=null;
			int Remainder1= 0;
			int Remainder2= 0;
			int Remainder3= 0;
			int Final=0;
			dbConnection = getConnection();	
			handler =new CRUDHandler();
			/*Modified by saranya for ssp call ZBILQC-1719374 & ZBILQC-1719334  on 09-02-2017*/
			/*String reminderQuery="select POL_ADDL_STATUS,POL_START_DT,POL_PROD_CODE,
			 * POL_SYS_ID from pt_il_policy where pol_status='N'";*/
			String reminderQuery="SELECT DISTINCT POL_ADDL_STATUS,POL_START_DT,"
					+ "POL_PROD_CODE,POL_SYS_ID FROM PT_IL_POLICY,PT_IL_DOC_TODO_LIST_STATUS "
					+ "WHERE POL_STATUS = 'N' AND POL_SYS_ID = DTLS_POL_SYS_ID AND DTLS_APPR_STS = 'N' "
					+ "AND DTLS_MANDATORY_YN = 'Y' UNION SELECT DISTINCT POL_ADDL_STATUS,"
					+ "POL_START_DT,POL_PROD_CODE,POL_SYS_ID FROM PT_IL_POLICY,  PT_IL_POL_MED_EXAM_DTL "
					+ "WHERE POL_STATUS = 'N' AND POL_SYS_ID = PMED_POL_SYS_ID  AND PMED_STATUS = 'N'";
			/*End*/
			String query=" SELECT PS_VALUE FROM PP_SYSTEM1 WHERE PS_TYPE='IL_PROP_CAN' AND PS_CODE=?";
			ResultSet remainderResultSet = null;
			ResultSet  resultSet1= null;
			ResultSet  resultSet2= null;
			ResultSet  resultSet3= null;
			ResultSet  resultSet4= null;
			String path=resourceBundleApp.getString("path");
			resultSet1 = handler.executeSelectStatement(query, dbConnection,
					new Object[] {"REM1"});
			if (resultSet1.next()) {
				Remainder1 = resultSet1.getInt(1);
			}
			resultSet2 = handler.executeSelectStatement(query, dbConnection,
					new Object[] {"REM2"});
			if (resultSet2.next()) {
				Remainder2 = resultSet2.getInt(1);
			}
			resultSet3 = handler.executeSelectStatement(query, dbConnection,
					new Object[] {"REM3"});
			if (resultSet3.next()) {
				Remainder3 = resultSet3.getInt(1);
			}
			resultSet4 = handler.executeSelectStatement(query, dbConnection,
					new Object[] {"FINAL"});
			if (resultSet4.next()) {
				Remainder3 = resultSet4.getInt(1);
			}
			remainderResultSet=handler.executeSelectStatement(reminderQuery, dbConnection);
			while(remainderResultSet.next())
			{
				issue_date=remainderResultSet.getDate("POL_START_DT");
				/*mail_id=remainderResultSet.getString("POL_FLEX_26");*/
				prod_code=remainderResultSet.getString("POL_PROD_CODE");
				pol_sys_id=remainderResultSet.getString("POL_SYS_ID");
				pol_addl_status=remainderResultSet.getString("POL_ADDL_STATUS");
				/*System.out.println("pol_sys id  ===  >"+pol_sys_id);
			System.out.println("number of days ====== >"+CommonUtils.subtractDate(date, issue_date).toString());*/
		/*	Modified by saranya for this ssp call id ZBILQC-1719374 & ZBILQC-1719334 on 11-02-2017*/
			// For ZB life Have to send mail for Both Client and agent
				if(CommonUtils.subtractDate(date, issue_date)==Remainder1)/* || CommonUtils.subtractDate(current_date, issue_date)==60 || CommonUtils.subtractDate(current_date, issue_date)==75*/
				{
					/*System.out.println("en ter into the remainder mail schedule");
					System.out.println("pol_sys_id   ==  "+pol_sys_id);*/
					Email_Procedure_Call.emailTriggerProcCall(prod_code, "RM1", pol_sys_id, "B", "",dbConnection);
				}
				else if(CommonUtils.subtractDate(date, issue_date)==Remainder2)
				{
					/*System.out.println("enter into 2nd remainder mail schedule");
					System.out.println("pol_sys_id   ==  "+pol_sys_id);*/
					Email_Procedure_Call.emailTriggerProcCall(prod_code, "RM2", pol_sys_id, "B", "",dbConnection);
				}
				else if(CommonUtils.subtractDate(date, issue_date)==Remainder3)
				{
					/*System.out.println("enter into 3nd remainder mail schedule");
					System.out.println("pol_sys_id   ==  "+pol_sys_id);*/
					Email_Procedure_Call.emailTriggerProcCall(prod_code, "RM3", pol_sys_id, "B", "",dbConnection);
				}
				else if((CommonUtils.subtractDate(date, issue_date)>=Final)&&("N01".equalsIgnoreCase(pol_addl_status)))
				{
					/*System.out.println("enter into Final remainder mail schedule");
					System.out.println("pol_sys_id   ==  "+pol_sys_id);*/
					Email_Procedure_Call.emailTriggerProcCall(prod_code, "FINAL", pol_sys_id, "B", "",dbConnection);
				}
				/*End*/
			}
			sendMail();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

/*End*/

	/*Added by Shankar on 27/036/2017*/
	
	public void PolicydispatchMethod()
	{
		try{
			CRUDHandler handler =new CRUDHandler();
			dbConnection = getConnection();	
			ResultSet  resultSet1= null;
			ResultSet  resultSet2= null;
			String prod_code=null;
			String pol_sys_id=null;
			int PS_VALUE=0;
			String Query="SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE IN ('IL_REM_1','IL_REM_2','IL_REM_3')";

			String Query1="SELECT POL_SYS_ID,POL_DISPATCH_MTD,POL_PROD_CODE FROM PT_IL_POLICY"
							+" WHERE TRUNC(POL_APPRV_DT)=TRUNC(SYSDATE - ?)";

			resultSet1 = handler.executeSelectStatement(Query, dbConnection);

			while(resultSet1.next())
			{
				PS_VALUE=resultSet1.getInt("PS_VALUE");
				resultSet2 = handler.executeSelectStatement(Query1, dbConnection, new Object[] {PS_VALUE});
				
				while(resultSet2.next())
				{
					prod_code=resultSet2.getString("POL_PROD_CODE");
					pol_sys_id=resultSet2.getString("POL_SYS_ID");
					Email_Procedure_Call.emailTriggerProcCall(prod_code, "RDC", pol_sys_id, "O", "",dbConnection);
				}
			
		
		

			}	
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	/*End*/
	
	/*Added by Ameen as per Kuzhandhai Vel sir sugg. on 05-07-2017 for ZBILQC-1725217 */
	
	public void claimRemaideMails(){
		System.out.println("::inside claimRemaideMails::");

		String clmNoQry = "SELECT CLAIM_NO,CLAIM_SYS_ID,CLAIM_APPRV_DT,CLAIM_POL_SYS_ID,CE_FC_EST_AMT,CE_FC_PAID_AMT,POL_PROD_CODE "
						+ "FROM PT_IL_CLAIM, PT_IL_CLAIM_ESTIMATE, PT_IL_POLICY WHERE CLAIM_STATUS = 'A' AND CE_CLAIM_SYS_ID = CLAIM_SYS_ID "
						+ "AND POL_SYS_ID = CLAIM_POL_SYS_ID";
		

		String remDaysQry = "SELECT PS_VALUE FROM PP_SYSTEM1 WHERE PS_TYPE='IL_CLM_STL' AND PS_CODE = ?";
		ResultSet clmNoRS = null;

		String claimNo = "";
		long clmSysId = 0;
		String claimPolSysId = "";
		String prod_code = "";
		Date claimApprvDt = null;
		int REM1=0;
		int REM2=0;
		int REM3=0;
		Double estAmt = 0.0;
		Double paidAmt = 0.0;
		Double balAmt = 0.0;
		
		ResultSet  rem1RS= null;
		ResultSet  rem2RS= null;
		ResultSet  rem3RS= null;
		
		
		
		try {
			dbConnection = getConnection();
			//getting days to send mail from system parameter as of 05-07-2017  REM1 = 30 days, REM2 = 60 days, REM3 = 90 days
			rem1RS = new CRUDHandler().executeSelectStatement(remDaysQry, dbConnection,
					new Object[] {"REM1"});
			if (rem1RS.next()) {
				REM1 = rem1RS.getInt(1);
			}
			rem2RS = new CRUDHandler().executeSelectStatement(remDaysQry, dbConnection,
					new Object[] {"REM2"});
			if (rem2RS.next()) {
				REM2 = rem2RS.getInt(1);
			}
			rem3RS = new CRUDHandler().executeSelectStatement(remDaysQry, dbConnection,
					new Object[] {"REM3"});
			if (rem3RS.next()) {
				REM3 = rem3RS.getInt(1);
			}
			System.out.println("REM1 ::" + REM1 + ":: REM2 ::" + REM2 + ":: REM3 ::" + REM3);
			//end getting days
			clmNoRS = new CRUDHandler().executeSelectStatement(clmNoQry, dbConnection);
			while(clmNoRS.next()){
				claimNo = clmNoRS.getString("CLAIM_NO");
				clmSysId = clmNoRS.getLong("CLAIM_SYS_ID");
				claimApprvDt = clmNoRS.getDate("CLAIM_APPRV_DT");
				claimPolSysId = clmNoRS.getString("CLAIM_POL_SYS_ID");
				prod_code = clmNoRS.getString("POL_PROD_CODE");
				estAmt = clmNoRS.getDouble("CE_FC_EST_AMT");
				paidAmt = clmNoRS.getDouble("CE_FC_PAID_AMT");
				balAmt = paidAmt - estAmt;
				
				System.out.println("CLAIM_NO ::" + claimNo +"::CLMSYSID::" + clmSysId + "::CLAIMAPPRVDT::" + claimApprvDt + 
									"::CLAIMPOLSYSID::" + claimPolSysId + "::PROD_CODE::" + prod_code + "::BALAMT::" + balAmt);
				
				System.out.println("test1 ::::" + CommonUtils.addDaysToDate(claimApprvDt, REM1).equals(new Date()));
				System.out.println("test2 ::::" + CommonUtils.addDaysToDate(claimApprvDt, REM2).equals(new Date()));
				System.out.println("test3 ::::" + CommonUtils.addDaysToDate(claimApprvDt, REM3).equals(new Date()));
			
				if(claimApprvDt != null && !claimApprvDt.equals(new Date())){
					
					if(CommonUtils.addDaysToDate(claimApprvDt, REM1).equals(new Date()) && balAmt != 0.0){
						Email_Procedure_Call.emailTriggerProcCall(prod_code, "RM1", claimPolSysId, "C", "",dbConnection);
					}
					
					else if(CommonUtils.addDaysToDate(claimApprvDt, REM2).equals(new Date()) && balAmt != 0.0){
						Email_Procedure_Call.emailTriggerProcCall(prod_code, "RM1", claimPolSysId, "C", "",dbConnection);
					}
					
					else if( CommonUtils.addDaysToDate(claimApprvDt, REM3).equals(new Date()) && balAmt != 0.0){
						Email_Procedure_Call.emailTriggerProcCall(prod_code, "RM1", claimPolSysId, "C", "",dbConnection);
					}
					
				}
				
			}
			sendMail();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				dbConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	/*End*/
	
	/*Added by Ameen on 15-12-2017 for ZBLIFE-1461947/automated email triggering for manual med. creation*/
	public void dailyMedicalReminder()
	{
		try {
			CRUDHandler handler =null;		
			Date issue_date=null;
			Date date = new Date();
			String prod_code=null;
			String pol_sys_id=null;
			String pol_addl_status=null;
			String mailSentStatus=null;
			long pmed_sys_id=0;
			boolean rsFlag=false;
			/*Added by ganesh on 20-12-2017 to check mail for agent or customer*/
			String sourceOfBusiness = "C";
			/*end*/
			
			dbConnection = getConnection();	
			handler =new CRUDHandler();
			
			String reminderQuery="SELECT DISTINCT POL_ADDL_STATUS,"
					+ "POL_START_DT,POL_PROD_CODE,POL_SYS_ID,POL_SRC_OF_BUS,PMED_SYS_ID FROM PT_IL_POLICY,  PT_IL_POL_MED_EXAM_DTL "
					+ "WHERE POL_STATUS = 'N' AND POL_SYS_ID = PMED_POL_SYS_ID  AND PMED_STATUS = 'N' AND PMED_FLEX_05 = 'N'";

			ResultSet remainderResultSet = null;
			
			remainderResultSet=handler.executeSelectStatement(reminderQuery, dbConnection);
			System.out.println("<<dailyMedicalReminder ....method>>");
			while(remainderResultSet.next())
			{
				issue_date=remainderResultSet.getDate("POL_START_DT");
				prod_code=remainderResultSet.getString("POL_PROD_CODE");
				pol_sys_id=remainderResultSet.getString("POL_SYS_ID");
				pol_addl_status=remainderResultSet.getString("POL_ADDL_STATUS");
				pmed_sys_id=remainderResultSet.getLong("PMED_SYS_ID");
				/*Added by ganesh on 20-12-2017 to check mail for agent or customer*/
				if("075".equalsIgnoreCase(remainderResultSet.getString("POL_SRC_OF_BUS"))){
					sourceOfBusiness = "B";
				}
				/*end*/
				Email_Procedure_Call.emailTriggerProcCall(prod_code, "MRM", pol_sys_id, sourceOfBusiness, "",dbConnection);
				
				handler.executeUpdateStatement("UPDATE PT_IL_POL_MED_EXAM_DTL SET PMED_FLEX_05 = 'Y' WHERE PMED_SYS_ID = '"+pmed_sys_id+"'", dbConnection);
				rsFlag=true;
			}
			System.out.println("<<dailyMedicalReminder ....method PMED_POL_SYS_ID update >> = " + rsFlag);
			if(rsFlag)
				dbConnection.commit();
			
			//sendMail();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/*End*/
	
	/*added by Ameen on 14-01-2020 for VLA maturity remainder*/
	public void maturityRemainder(){
		/*String matPolQry = " SELECT POL_SYS_ID, POL_PROD_CODE FROM "
				+ "(SELECT * FROM PT_IL_POLICY, PM_CUSTOMER WHERE POL_CUST_CODE = CUST_CODE AND POL_STATUS = 'A' "
				+ "AND POL_APPRV_STATUS = 'A' AND POL_ADDL_STATUS = 'I00' AND ADD_MONTHS(POL_EXPIRY_DT, -3) = "
				+ "(SELECT MIN(PC_SCHD_PYMT_DT) - 1 FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = POL_SYS_ID AND PC_PAID_DT IS NULL))";*/
		/*String matPolQry = "SELECT POL_SYS_ID, POL_PROD_CODE FROM (SELECT * FROM PT_IL_POLICY, PM_CUSTOMER WHERE "
				+ "POL_CUST_CODE = CUST_CODE AND POL_STATUS = 'A' AND POL_APPRV_STATUS = 'A' AND POL_ADDL_STATUS = 'I00' "
				+ "AND POL_EXPIRY_DT - 41 = (SELECT TRUNC(SYSDATE) FROM DUAL))";*/
		/*String matPolQry = "SELECT POL_SYS_ID, POL_PROD_CODE FROM (SELECT * FROM PT_IL_POLICY, PM_CUSTOMER WHERE "
				+ "POL_CUST_CODE = CUST_CODE AND POL_STATUS = 'A' AND POL_APPRV_STATUS = 'A' AND POL_ADDL_STATUS = "
				+ "'I00' AND POL_DS_TYPE = 2 AND POL_EXPIRY_DT - 70 = (SELECT TRUNC(SYSDATE) FROM DUAL) )";*/
		String matPolQry = "SELECT POL_SYS_ID, POL_PROD_CODE FROM (SELECT * FROM PT_IL_POLICY, PM_CUSTOMER WHERE "
				+ "POL_CUST_CODE = CUST_CODE AND POL_STATUS = 'A' AND POL_APPRV_STATUS = 'A' AND POL_ADDL_STATUS = "
				+ "'I00' AND POL_DS_TYPE = 2 AND POL_EXPIRY_DT - 90 = (SELECT TRUNC(SYSDATE) FROM DUAL))";
		
		ResultSet rs = null;
		String polSysId = null;
		String prodCode = null;
		try {
			dbConnection = getConnection();
			rs = new CRUDHandler().executeSelectStatement(matPolQry, dbConnection);
			while(rs.next()){
				polSysId = rs.getString("POL_SYS_ID");
				prodCode = rs.getString("POL_PROD_CODE");
				
				Email_Procedure_Call.emailTriggerProcCall(prodCode, "MNOT", polSysId, "C", "",dbConnection);
			}
			System.out.println("MATURITY MAIL SCHEDULER END ..");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				dbConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/*end*/
}
