package com.iii.pel.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILM106.PILM106_A_QUERYCONSTANTS;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class Email_Procedure_Call {
	
	/*Connection con Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
	public static String emailTriggerProcCall(String P_PROD_CODE,String P_MAIL_TYPE, String P_POL_SYS_ID, String P_CUST_TYPE,String P_MAIL_PATH,Connection con) throws Exception{
		
		/*Connection con=CommonUtils.getConnection();*/
		System.out.println("P_MAIL_TYPE-->"+P_MAIL_TYPE);
		String out="";
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PROD_CODE);
		  parameterList.add(param1); 
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_MAIL_TYPE);
		  parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_SYS_ID);
		  parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CUST_TYPE);
		  parameterList.add(param4);
		  OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_MAIL_PATH);
		  parameterList.add(param5);
		OracleParameter param6 = new OracleParameter("OUT1", "STRING", "OUT",out);
	    parameterList.add(param6);
	    
	    OracleProcedureHandler procHandler = new OracleProcedureHandler();
	    outputList = procHandler.execute(parameterList, con,
	            "P_MAIL_TEMP");
	    /*con.commit() Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
	    /* CommonUtils.doComitt();*/
	    con.commit();
	   /* End*/
	    Iterator<OracleParameter> iterator = outputList.iterator();
	    while (iterator.hasNext()) {
	        OracleParameter oracleParameter = iterator.next();
	        System.out.println("Output value:::" + oracleParameter.getValue());
			out=(String)oracleParameter.getValue();
	    }
		return out;
		}

	
	
	
    public static String emailStatusMsg(String P_PROD_CODE,String P_MAIL_TYPE, String P_POL_SYS_ID, String P_CUST_TYPE,String P_MAIL_PATH) throws Exception
    	
	{
    	StringBuilder statusMessge =  new StringBuilder(" - ");
    	/*Modified by Saranya RM018T - FSD_IL_ZB Life_016-Queried Proposals v1 on 27-12-2016*/
    
    	/*Modified by ganesh on 04-07-2017, handling null when procedure returns null */
          String mailFlag = CommonUtils.nvl(emailTriggerProcCall(P_PROD_CODE, P_MAIL_TYPE, P_POL_SYS_ID, P_CUST_TYPE, P_MAIL_PATH,CommonUtils.getConnection()),"N");
    	/*end*/
    	/*End*/
    	System.out.println("Mail status Flag--->["+mailFlag+"]--- P_CUST_TYPE ["+P_CUST_TYPE+"]");
    	
    	if((P_CUST_TYPE.equalsIgnoreCase("B"))){
    		
    		if(mailFlag.equals("YY")){
    			
    			statusMessge.append("Mail sent sucessfully");
    			
    		}else if(mailFlag.equals("T")){
    			
    			statusMessge.append("Email template is unavailable in master setup "+templateDescription(P_MAIL_TYPE));
    		    			
    		}else if(mailFlag.equalsIgnoreCase("NN")){
    			
    			statusMessge.append("Unable to send the email due to the unavailability of both Customer and Agent email id");
    				
    		}else if(mailFlag.equalsIgnoreCase("NY")){
    			
    			statusMessge.append("Unable to send the email due to the unavailability of Customer email id");
    				
    		}else if(mailFlag.equalsIgnoreCase("YN")){
    			
    			statusMessge.append("Unable to send the email due to the unavailability of Agent email id");
    				
    		}
    		//Added by ganesh on 21-06-2017, rare case if procedure not handled dualFlag it will use
    		else if(mailFlag.equalsIgnoreCase("Y")){   
    			
    			statusMessge.append("Mail sent sucessfully");
    		}else{
    			statusMessge.append("Unable to send the email due to the unavailability of both Customer and Agent email id");
    		}
    		/*end*/
    	}else{
    		
    		if(mailFlag.equals("Y")){
    			
    			statusMessge.append("Mail sent sucessfully");
    			
    		}else if(mailFlag.equals("T")){
    			
    			statusMessge.append("Email template is unavailable in master setup "+templateDescription(P_MAIL_TYPE));
    		    			
    		}else {
    			
    			if(P_CUST_TYPE.equalsIgnoreCase("C")){
    				statusMessge.append("Unable to send the email due to the unavailability of Customer email id");
    			}else if(P_CUST_TYPE.equalsIgnoreCase("A")){
    				statusMessge.append("Unable to send the email due to the unavailability of Agent email id");
    			}
    			
    		}
  		
    		
    	}
    	
    	
    	return statusMessge.toString();   
    	
    	
    	
    }
    
    /*Modified private to public by ganesh on 21-06-2017 for proposal status*/
    public static String templateDescription(String templateCode){
    	
    	String selectTemplateDescQuery = "SELECT initcap(LIV_CODE_DESC) FROM PP_LIST_ITEM_VALUES WHERE LIV_CODE = ?";
    	StringBuilder selectTemplateDesc = null;
    	CRUDHandler handler =  new CRUDHandler();
    	Connection con = null;
    			
    	try {
    		con = CommonUtils.getConnection();
    		selectTemplateDesc = new StringBuilder(""); 
			ResultSet rs1=handler.executeSelectStatement(selectTemplateDescQuery, con, new Object[]{templateCode});
			if(rs1.next()){
				selectTemplateDesc.append("for ").append(rs1.getString(1));
				
			}
			System.out.println("Template Description --->["+selectTemplateDesc+"]");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return selectTemplateDesc.toString();
    }
    
    
    
    /*Added by Janani on 20.06.2017 for ZBILQC-1721256*/
    
    
public static String claim_emailTriggerProcCall(String P_PROD_CODE,String P_MAIL_TYPE, String P_POL_SYS_ID, String P_CUST_TYPE,String P_MAIL_PATH,Connection con,String P_CLM_SYS_ID) throws Exception{
		
		/*Connection con=CommonUtils.getConnection();*/
		System.out.println("P_MAIL_TYPE-->"+P_MAIL_TYPE);
		String out="";
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PROD_CODE);
		  parameterList.add(param1); 
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_MAIL_TYPE);
		  parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_SYS_ID);
		  parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CUST_TYPE);
		  parameterList.add(param4);
		  OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_MAIL_PATH);
		  parameterList.add(param5);
		OracleParameter param6 = new OracleParameter("OUT1", "STRING", "OUT",out);
	    parameterList.add(param6);
	    
	    OracleParameter param7 = new OracleParameter("IN6", "STRING", "IN",P_CLM_SYS_ID);
	    parameterList.add(param7);	    
	   
	    OracleProcedureHandler procHandler = new OracleProcedureHandler();
	    outputList = procHandler.execute(parameterList, con,
	            "P_MAIL_TEMP");
	    /*con.commit() Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
	    /* CommonUtils.doComitt();*/
	    con.commit();
	   /* End*/
	    Iterator<OracleParameter> iterator = outputList.iterator();
	    while (iterator.hasNext()) {
	        OracleParameter oracleParameter = iterator.next();
	        System.out.println("Output value:::" + oracleParameter.getValue());
			out=(String)oracleParameter.getValue();
	    }
		return out;
		}
    
/* New method Added by Sivarajan on 13-08-2018 for FSD_IL_FLA_005*/
public static String emailTriggerProcCallWithFileName(String P_PROD_CODE,String P_MAIL_TYPE, String P_POL_SYS_ID, String P_CUST_TYPE,String P_MAIL_PATH,String fileName,String P_STATUS_CODE,Connection con) throws Exception{
	
	/*Connection con=CommonUtils.getConnection();*/
	System.out.println("P_MAIL_TYPE-->"+P_MAIL_TYPE);
	String out="";
	ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
	ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
	OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PROD_CODE);
	  parameterList.add(param1); 
	OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_MAIL_TYPE);
	  parameterList.add(param2);
	OracleParameter param3 = new OracleParameter("IN3", "LONG", "IN",P_POL_SYS_ID);
	  parameterList.add(param3);
	OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CUST_TYPE);
	  parameterList.add(param4);
	  OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_MAIL_PATH);
	  parameterList.add(param5);
	 
	OracleParameter param6 = new OracleParameter("OUT1", "STRING", "OUT",out);
    parameterList.add(param6);
    
    OracleParameter param7 = new OracleParameter("IN6", "STRING", "IN","");
	  parameterList.add(param7);
	  
	  OracleParameter param8 = new OracleParameter("IN7", "STRING", "IN",fileName);
	  parameterList.add(param8);
	  
	  OracleParameter param9 = new OracleParameter("IN8", "STRING", "IN",P_STATUS_CODE);
	  parameterList.add(param9);
	  
    
    OracleProcedureHandler procHandler = new OracleProcedureHandler();
    outputList = procHandler.execute(parameterList, con,
            "P_MAIL_TEMP");
    /*con.commit() Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
    /* CommonUtils.doComitt();*/
    con.commit();
   /* End*/
    Iterator<OracleParameter> iterator = outputList.iterator();
    while (iterator.hasNext()) {
        OracleParameter oracleParameter = iterator.next();
        System.out.println("Output value:::" + oracleParameter.getValue());
		out=(String)oracleParameter.getValue();
    }
	return out;
	}
/*End*/

    public static String claim_emailStatusMsg(String P_PROD_CODE,String P_MAIL_TYPE, String P_POL_SYS_ID, String P_CUST_TYPE,String P_MAIL_PATH,String P_CLM_SYS_ID) throws Exception


{
	StringBuilder statusMessge =  new StringBuilder(" - ");
	
	String mailFlag = claim_emailTriggerProcCall(P_PROD_CODE, P_MAIL_TYPE, P_POL_SYS_ID, P_CUST_TYPE, P_MAIL_PATH,CommonUtils.getConnection(),P_CLM_SYS_ID);
	
	System.out.println("Mail status Flag--->["+mailFlag+"]--- P_CUST_TYPE ["+P_CUST_TYPE+"]");

	if((P_CUST_TYPE.equalsIgnoreCase("B"))){

		if(mailFlag.equals("YY")){

			statusMessge.append("Mail sent sucessfully");

		}else if(mailFlag.equals("T")){

			statusMessge.append("Email template is unavailable in master setup "+templateDescription(P_MAIL_TYPE));

		}else if(mailFlag.equalsIgnoreCase("NN")){

			statusMessge.append("Unable to send the email due to the unavailability of both Customer and Agent email id");

		}else if(mailFlag.equalsIgnoreCase("NY")){

			statusMessge.append("Unable to send the email due to the unavailability of Customer email id");

		}else if(mailFlag.equalsIgnoreCase("YN")){

			statusMessge.append("Unable to send the email due to the unavailability of Agent email id");

		}

	}else{

		if(mailFlag.equals("Y")){

			statusMessge.append("Mail sent sucessfully");

		}else if(mailFlag.equals("T")){

			statusMessge.append("Email template is unavailable in master setup "+templateDescription(P_MAIL_TYPE));

		}else {

			if(P_CUST_TYPE.equalsIgnoreCase("C")){
				statusMessge.append("Unable to send the email due to the unavailability of Customer email id");
			}else if(P_CUST_TYPE.equalsIgnoreCase("A")){
				statusMessge.append("Unable to send the email due to the unavailability of Agent email id");
			}

		}


	}


	return statusMessge.toString();   



}

    /*Added by ganesh on 19-09-2017 for ZBILQC-1732146*/
    public static String emailStatusDynamicMsg(String P_PROD_CODE,String P_MAIL_TYPE, String P_POL_SYS_ID, String P_CUST_TYPE,String P_MAIL_PATH) throws Exception
	
	{
    	StringBuilder statusMessge =  new StringBuilder(" - ");    	
        String mailFlag = CommonUtils.nvl(emailTriggerProcCall(P_PROD_CODE, P_MAIL_TYPE, P_POL_SYS_ID, P_CUST_TYPE, P_MAIL_PATH,CommonUtils.getConnection()),"N");    	
    	System.out.println("Mail status Flag--->["+mailFlag+"]--- P_CUST_TYPE ["+P_CUST_TYPE+"]");
    	String templateDescription = fetchTemplateDescription(P_MAIL_TYPE);
    	
    	if((P_CUST_TYPE.equalsIgnoreCase("B"))){
    		
    		if(mailFlag.equals("YY")){
    			
    			statusMessge.append("Mail sent sucessfully");
    			
    		}else if(mailFlag.equals("T")){
    			
    			statusMessge.append(templateDescription+ " email template is unavailable in master setup");
    		    			
    		}else if(mailFlag.equalsIgnoreCase("NN")){
    			
    			statusMessge.append("Unable to send the "+templateDescription+" email due to the unavailability of both Customer and Agent email id");
    				
    		}else if(mailFlag.equalsIgnoreCase("NY")){
    			
    			statusMessge.append("Unable to send the "+templateDescription+" email due to the unavailability of Customer email id");
    				
    		}else if(mailFlag.equalsIgnoreCase("YN")){
    			
    			statusMessge.append("Unable to send the "+templateDescription+" email due to the unavailability of Agent email id");
    				
    		}
    		//Added by ganesh on 21-06-2017, rare case if procedure not handled dualFlag it will use
    		else if(mailFlag.equalsIgnoreCase("Y")){   
    			
    			statusMessge.append(templateDescription+" mail sent sucessfully");
    		}else{
    			statusMessge.append("Unable to send the "+templateDescription+" email due to the unavailability of both Customer and Agent email id");
    		}
    		/*end*/
    	}else{
    		
    		if(mailFlag.equals("Y")){
    			
    			statusMessge.append(templateDescription+" mail sent sucessfully");
    			
    		}else if(mailFlag.equals("T")){
    			
    			statusMessge.append(templateDescription+ " email template is unavailable in master setup");
    		    			
    		}else {
    			
    			if(P_CUST_TYPE.equalsIgnoreCase("C")){
    				statusMessge.append("Unable to send the "+templateDescription+" email due to the unavailability of Customer email id");
    			}else if(P_CUST_TYPE.equalsIgnoreCase("A")){
    				statusMessge.append("Unable to send the "+templateDescription+" email due to the unavailability of Agent email id");
    			}
    			
    		}
  		
    		
    	}
    	
    	
    	return statusMessge.toString(); 
    	
    	
    }
public static String fetchTemplateDescription(String templateCode){
    	
    	String selectTemplateDescQuery = "SELECT initcap(LIV_CODE_DESC) FROM PP_LIST_ITEM_VALUES WHERE LIV_CODE = ?";
    	StringBuilder selectTemplateDesc = null;
    	CRUDHandler handler =  new CRUDHandler();
    	Connection con = null;
    			
    	try {
    		con = CommonUtils.getConnection();
    		selectTemplateDesc = new StringBuilder(""); 
			ResultSet rs1=handler.executeSelectStatement(selectTemplateDescQuery, con, new Object[]{templateCode});
			if(rs1.next()){
				selectTemplateDesc.append(rs1.getString(1));
				
			}
			System.out.println("Template Description --->["+selectTemplateDesc+"]");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return selectTemplateDesc.toString();
    }
    
    /*End*/

    /*Added by ganesh on 13-07-2017, fetching To and CC based on the email template code */
    CRUDHandler emailTypeHandler = null;
    ResultSet emailTypeResultSet = null;
    public String buildEmailType(String emailTemplateID, String productID, Connection dbConnection, String staticCustType) throws SQLException{
		emailTypeHandler = new CRUDHandler();		
		String emailTypeValue = staticCustType;//By default setting static customer type
		String emailTypeQuery = "SELECT PMT_KEY_MAIL_TO||'~'||PMT_KEY_MAIL_CC FROM PM_LIFE_MAIL_TEMPLATE WHERE PMT_MAIL_TYPE = ? AND PMT_PROD_CODE = ?";
		emailTypeResultSet = emailTypeHandler.executeSelectStatement(emailTypeQuery, dbConnection,
				new Object[] {emailTemplateID, productID});
		if (emailTypeResultSet.next()) {
			emailTypeValue = emailTypeResultSet.getString(1);
		}
		emailTypeResultSet.close();
		return emailTypeValue.trim().equalsIgnoreCase("~")?staticCustType:emailTypeValue;
	}
    
}
