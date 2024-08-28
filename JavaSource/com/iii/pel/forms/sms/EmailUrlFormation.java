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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.richfaces.component.html.HtmlModalPanel;

import com.iii.apps.persistence.CRUDHandler;



import com.iii.apps.persistence.ConnectionManager;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.apps.persistence.PremiaCryptograph;
import com.iii.pel.util.Email_Procedure_Call;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ReportUtils;

public class EmailUrlFormation extends CommonAction{

	private final static Logger log= Logger
			.getLogger(EmailUrlFormation.class);

	private ResourceBundle resourceBundleApp = ResourceBundle.getBundle("Report_ID");

	private ResourceBundle resourceBundleDatabase = ResourceBundle.getBundle("login");

	Connection dbConnection =null;

	private IP_REP_INFO_DUMMY IP_REP_INFO_DUMMY_BEAN;
	
	
	public IP_REP_INFO_DUMMY getIP_REP_INFO_DUMMY_BEAN() {
		return IP_REP_INFO_DUMMY_BEAN;
	}

	public void setIP_REP_INFO_DUMMY_BEAN(IP_REP_INFO_DUMMY iP_REP_INFO_DUMMY_BEAN) {
		IP_REP_INFO_DUMMY_BEAN = iP_REP_INFO_DUMMY_BEAN;
	}

	public void setCOMP_REPORT_MODAL_PANEL(HtmlModalPanel cOMP_REPORT_MODAL_PANEL) {
		COMP_REPORT_MODAL_PANEL = cOMP_REPORT_MODAL_PANEL;
	}



	private HtmlModalPanel COMP_REPORT_MODAL_PANEL;

	public HtmlModalPanel getCOMP_REPORT_MODAL_PANEL() {
		return COMP_REPORT_MODAL_PANEL;
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


	String url;
	public EmailUrlFormation(){

		IP_REP_INFO_DUMMY_BEAN = new IP_REP_INFO_DUMMY();
		
		
	}
	public String RedirectUrl;

	public String getRedirectUrl() {
		return RedirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		RedirectUrl = redirectUrl;
	}



	String repKeyNo ;


	public String getRepKeyNo() {
		return repKeyNo;
	}

	public void setRepKeyNo(String repKeyNo) {
		this.repKeyNo = repKeyNo;
	}

	public String runAction()
	{
		Connection connection = null;
		String POL_SYS_ID=null;

		ResultSet resultSet=null;
		CRUDHandler handler=new CRUDHandler();

		url =  resourceBundleApp.getString("xdocsSchedule");
		System.out.println("emailUrl  "+url);
		setRedirectUrl(url);

		String query ="SELECT SEQ_REP_KEY_NO.NEXTVAL FROM DUAL";
		try{
			connection=getConnection();
			resultSet=handler.executeSelectStatement(query, connection);
			if(resultSet.next()){
				setRepKeyNo(resultSet.getString(1));
			}


			if (IP_REP_INFO_DUMMY_BEAN.getROWID() == null) {
				System.out.println("ENTER IP_REP_INFO_BEAN");

				POL_SYS_ID =String.valueOf(getPolsysid());
				PRE_INSERT(this.IP_REP_INFO_DUMMY_BEAN);
				IP_REP_INFO_DUMMY_BEAN.setREP_VALUE_1(POL_SYS_ID);

				System.out.println("getREP_KEY_NO             "+IP_REP_INFO_DUMMY_BEAN.getREP_KEY_NO());

				String ins_query = "INSERT INTO IP_REP_INFO (REP_KEY_NO,REP_ID,REP_VALUE_1) VALUES (?,?,?)";
				
				int recordCount = handler.executeInsertStatement(ins_query, connection,new Object[]{IP_REP_INFO_DUMMY_BEAN.getREP_KEY_NO(),IP_REP_INFO_DUMMY_BEAN.getREP_ID(),
						IP_REP_INFO_DUMMY_BEAN.getREP_VALUE_1()});
				
				System.out.println("recordCount       "+recordCount);
			/*	int recordCount = handler.executeInsert(IP_REP_INFO_DUMMY_BEAN,
						connection)*/;
				connection.commit();
			}else {

				PRE_UPDATE(this.IP_REP_INFO_DUMMY_BEAN);
				//IP_REP_INFO_BEAN.setREP_ID(getUI_REPORT_TYPE());
				connection.commit();
			}



		}catch(Exception e){
			e.printStackTrace();
		}


		return "";
	}

	/*Added by Daisy for maturity on 19-11-2018*/
	public String runActionAfterValidateForEmail() {

		Connection connection = null;
		String repKeyNo=null;
		ResultSet resultSet=null;
		CRUDHandler handler=new CRUDHandler();
		
		try {
			String rep_template_name=null;
			connection=getConnection();

			setRedirectUrl(getRedirectUrl()+"REP_KEY_NO="+IP_REP_INFO_DUMMY_BEAN.getREP_KEY_NO()+"&REP_ID=FLALETREP137&REPORT_TYPE=FLALETREP137&STATUS=A&MODULE_ID="+resourceBundleApp.getString("module_id"));

			System.out.println("End");

			String emailStatusMessage = sendPostRequest_Maturity(getRedirectUrl());					


			System.out.println("message ============>>>>>>>>>>" + emailStatusMessage);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					emailStatusMessage);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					emailStatusMessage);  

			} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("runAction", e.getMessage());
		}
		return null;
	}
	/*End*/
/*Added by daisy for maturity on20-11-2018*/
	public void PRE_INSERT(IP_REP_INFO_DUMMY iP_REP_INFO_DUMMY_BEAN) {

		try {

			//iP_REP_INFO_DUMMY_BEAN.setREP_KEY_NO(new ReportUtils().getRepKeyNo());
			iP_REP_INFO_DUMMY_BEAN.setREP_KEY_NO(getRepKeyNo());

			iP_REP_INFO_DUMMY_BEAN.setREP_ID(resourceBundleApp.getString("module_id"));
			/*iP_REP_INFO_DUMMY_BEAN.setREP_VALUE_20(CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"));
			iP_REP_INFO_DUMMY_BEAN.setREP_VALUE_21(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			iP_REP_INFO_DUMMY_BEAN.setREP_CR_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			iP_REP_INFO_DUMMY_BEAN.setREP_CR_DT(new CommonUtils().getCurrentDate());*/

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void PRE_UPDATE(IP_REP_INFO_DUMMY iP_REP_INFO_DUMMY_BEAN) {

		try {
			iP_REP_INFO_DUMMY_BEAN.setREP_ID(resourceBundleApp.getString("module_id"));
			/*iP_REP_INFO_DUMMY_BEAN.setREP_VALUE_20(CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"));
			iP_REP_INFO_DUMMY_BEAN.setREP_VALUE_21(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			iP_REP_INFO_DUMMY_BEAN.setREP_UPD_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			iP_REP_INFO_DUMMY_BEAN.setREP_UPD_DT(new CommonUtils().getCurrentDate());*/

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*End*/
	public String cancelModalPanel(){
		getCOMP_REPORT_MODAL_PANEL().setShowWhenRendered(false);
		return "";
	}

	public Long getPolsysid() throws Exception{

		CRUDHandler handler =null;
		String prod_code=null;
		String pol_sys_id=null;
		dbConnection = getConnection();	
		handler =new CRUDHandler();

		try
		{


			String query = "SELECT POL_PROD_CODE,POL_SYS_ID FROM PT_IL_SURR_MAT_VALUES,PT_IL_POLICY WHERE SMV_POL_SYS_ID=POL_SYS_ID AND SMV_TYPE='M'";
			System.out.println("Entered for the mail remainder for maturity................");

			ResultSet maturityrs = null;

			maturityrs = handler.executeSelectStatement(query, dbConnection);	
			while(maturityrs.next())
			{

				prod_code= maturityrs.getString("POL_PROD_CODE");
				pol_sys_id= maturityrs.getString("POL_SYS_ID");

				System.out.println("pol_sys_id             "+pol_sys_id);
				
				// Email_Procedure_Call.emailTriggerProcCall(prod_code, "M", pol_sys_id, "C","",dbConnection);
			}

		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Long.parseLong(pol_sys_id);
	}

	/*Added by Daisy on 16-11-2018 for email with attachment*/

	public String sendPostRequest_Maturity(String redirectURL) throws Exception {

		StringBuffer response = new StringBuffer();

		try{

			System.out.println("Redirect URL--->" + redirectURL);

			redirectURL = redirectURL+"&attachment=Y";
			System.out.println("Post URL-->"+redirectURL);

			URL obj = new URL(redirectURL);

			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			int responseCode = con.getResponseCode();

			System.out.println("GET Response Code :: " + responseCode);
			if (responseCode == HttpURLConnection.HTTP_OK) {

				String polSysID = getPolsysid().toString();
				String prodCode = getProdCode(polSysID);

				response.append(emailStatusMsg(prodCode, "MAA", polSysID, "C", redirectURL));

			} else {
				System.out.println("GET request not worked");
				response.append("Unable to send the email");
			}


		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return response != null ? response.toString() : "";
	}


	/*public String sendPostRequest(String finalURL) throws Exception{
	finalURL = finalURL+"&viewtype=email";
	System.out.println("Post URL-->"+finalURL);


	URL obj = new URL(finalURL.split("\\?")[0]);
	String POST_PARAMS = finalURL.split("\\?")[1];
	System.out.println("POST_PARAMS --"+POST_PARAMS);
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	con.setRequestMethod("POST");
	con.setRequestProperty("User-Agent", "Mozilla/5.0");

	// For POST only - START
	con.setDoOutput(true);
	OutputStream os = con.getOutputStream();
	os.write(POST_PARAMS.getBytes());
	os.flush();
	os.close();
	// For POST only - END

	int responseCode = con.getResponseCode();
	StringBuffer response = new StringBuffer();
	StringBuffer outPutFileName = new StringBuffer();
	System.out.println("POST Response Code :: " + responseCode);

	if (responseCode == HttpURLConnection.HTTP_OK) { //success
		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));

		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			outPutFileName.append(inputLine);
		}
		in.close();


		System.out.println("Received Attachment File names---->[" + outPutFileName+"]");	

		String polSysID = getPolsysid().toString();
		String prodCode = getProdCode(polSysID);

		String emailStatusMessage = Email_Procedure_Call.emailStatusMsg(prodCode, "MAA", polSysID, "C", outPutFileName.toString());
		System.out.println("Email Response message in post request--->"+emailStatusMessage);
		response.append(outPutFileName.toString().equals("")?"Unable to send attachment for this approval":emailStatusMessage);

	} else {
		System.out.println("POST request not worked");
		response.append("Unable to send the email");
	}

	return (response!=null?response.toString():"");
}*/

	public String getProdCode(String polSysID) throws Exception {
		Connection connection = null;
		ResultSet resultSet = null;
		String prodCode = null;
		String query = "SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID = ?";
		try {
			connection = getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query,
					connection, new Object[] { polSysID });
			if (resultSet.next()) {
				prodCode = resultSet.getString(1);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
		return prodCode;
	}


	//end
	/*End*/


	public String emailStatusMsg(String P_PROD_CODE,String P_MAIL_TYPE, String P_POL_SYS_ID, String P_CUST_TYPE,String P_MAIL_PATH) throws Exception

	{
		StringBuilder statusMessge =  new StringBuilder(" - ");
		/*Modified by Saranya RM018T - FSD_IL_ZB Life_016-Queried Proposals v1 on 27-12-2016*/

		/*Modified by ganesh on 04-07-2017, handling null when procedure returns null */
		String mailFlag = CommonUtils.nvl(emailTriggerProcCall(P_PROD_CODE, P_MAIL_TYPE, P_POL_SYS_ID, P_CUST_TYPE, P_MAIL_PATH,getConnection()),"N");
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


	public static String emailTriggerProcCall(String P_PROD_CODE,String P_MAIL_TYPE, String P_POL_SYS_ID, String P_CUST_TYPE,String P_MAIL_PATH,Connection con) throws Exception{

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

		con.commit();

		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			out=(String)oracleParameter.getValue();
		}
		return out;
	}


	public String templateDescription(String templateCode){

		String selectTemplateDescQuery = "SELECT initcap(LIV_CODE_DESC) FROM PP_LIST_ITEM_VALUES WHERE LIV_CODE = ?";
		StringBuilder selectTemplateDesc = null;
		CRUDHandler handler =  new CRUDHandler();
		Connection con = null;

		try {
			con = getConnection();
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
/*Added by daisy for lapse on20-11-2018*/
	public String runActionlapse()
	{
		Connection connection = null;
		String POL_SYS_ID=null;

		ResultSet resultSet=null;
		CRUDHandler handler=new CRUDHandler();

		url =  resourceBundleApp.getString("xdocsSchedule");
		System.out.println("emailUrl  "+url);
		setRedirectUrl(url);

		String query ="SELECT SEQ_REP_KEY_NO.NEXTVAL FROM DUAL";
		try{
			connection=getConnection();
			resultSet=handler.executeSelectStatement(query, connection);
			if(resultSet.next()){
				setRepKeyNo(resultSet.getString(1));
			}


			if (IP_REP_INFO_DUMMY_BEAN.getROWID() == null) {
				System.out.println("ENTER IP_REP_INFO_BEAN");

				POL_SYS_ID =String.valueOf(getPol_sys_id_lapse());
				PRE_INSERT(this.IP_REP_INFO_DUMMY_BEAN);
				IP_REP_INFO_DUMMY_BEAN.setREP_VALUE_1(POL_SYS_ID);

				System.out.println("getREP_KEY_NO             "+IP_REP_INFO_DUMMY_BEAN.getREP_KEY_NO());

				String ins_query = "INSERT INTO IP_REP_INFO (REP_KEY_NO,REP_ID,REP_VALUE_1) VALUES (?,?,?)";
				
				int recordCount = handler.executeInsertStatement(ins_query, connection,new Object[]{IP_REP_INFO_DUMMY_BEAN.getREP_KEY_NO(),IP_REP_INFO_DUMMY_BEAN.getREP_ID(),
						IP_REP_INFO_DUMMY_BEAN.getREP_VALUE_1()});
				
				System.out.println("recordCount       "+recordCount);
			/*	int recordCount = handler.executeInsert(IP_REP_INFO_DUMMY_BEAN,
						connection)*/;
				connection.commit();
			}else {

				PRE_UPDATE(this.IP_REP_INFO_DUMMY_BEAN);
				//IP_REP_INFO_BEAN.setREP_ID(getUI_REPORT_TYPE());
				connection.commit();
			}



		}catch(Exception e){
			e.printStackTrace();
		}


		return "";
	}
	
	public String runActionAfterValidateForLapseEmail() {

		Connection connection = null;
		String repKeyNo=null;
		ResultSet resultSet=null;
		CRUDHandler handler=new CRUDHandler();
		
		try {
			String rep_template_name=null;
			connection=getConnection();

			setRedirectUrl(getRedirectUrl()+"REP_KEY_NO="+IP_REP_INFO_DUMMY_BEAN.getREP_KEY_NO()+"&REP_ID=FLALETREP130&REPORT_TYPE=FLALETREP130&STATUS=A&MODULE_ID="+resourceBundleApp.getString("mod_id"));

			System.out.println("End");

			String emailStatusMessage = sendPostRequest_Lapse(getRedirectUrl());					


			System.out.println("message ============>>>>>>>>>>" + emailStatusMessage);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					emailStatusMessage);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					emailStatusMessage);  

			} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("runAction", e.getMessage());
		}
		return null;
	}
	
	public Long getPol_sys_id_lapse()
	{
		Date issue_date=null;
		String mail_id=null;
		String pol_sys_id=null;
		String prod_code=null;
		ResultSet remainderResultSet = null;
		ResultSet remainderResultSet1 = null;
		ResultSet remainderResultSet2 = null;
		
		try
		{
			dbConnection = getConnection();
			Date simpledateformat = new Date();
			String sysDate=new SimpleDateFormat("dd/MMM/yyyy").format(simpledateformat);
			CRUDHandler handler=new CRUDHandler();
			System.out.println("status date:::::"+sysDate);
			String LapsedreminderQuery="SELECT POL_PROD_CODE,POL_SYS_ID FROM PT_IL_POLICY,PT_IL_POL_STATUS "
					+ "WHERE PS_POL_SYS_ID=POL_SYS_ID AND PS_STATUS ='I05' AND NVL(TO_DATE(PS_CR_DT,'DD/MM/RRRR'),TO_DATE(PS_STATUS_DT,'DD/MM/RRRR')) =?";
			/*end*/
			remainderResultSet2=handler.executeSelectStatement(LapsedreminderQuery, dbConnection,
					new Object[] {sysDate});
			while(remainderResultSet2.next())
			{

				prod_code=remainderResultSet2.getString("POL_PROD_CODE");
				pol_sys_id=remainderResultSet2.getString("POL_SYS_ID");
				/*System.out.println("product code"+prod_code);
				System.out.println("polsysid"+pol_sys_id);
				System.out.println("enter into the lapsed remainder mail schedule");*/
				//Email_Procedure_Call.emailTriggerProcCall(prod_code, "LAP", pol_sys_id.toString(),"C", "",dbConnection);

			}
			System.out.println("pol_sys_id"+pol_sys_id);
			
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Long.parseLong(pol_sys_id);
	}
	
	
	public void PRE_INSERT_lap(IP_REP_INFO_DUMMY iP_REP_INFO_DUMMY_BEAN) {

		try {

			//iP_REP_INFO_DUMMY_BEAN.setREP_KEY_NO(new ReportUtils().getRepKeyNo());
			iP_REP_INFO_DUMMY_BEAN.setREP_KEY_NO(getRepKeyNo());

			iP_REP_INFO_DUMMY_BEAN.setREP_ID(resourceBundleApp.getString("mod_id"));
			/*iP_REP_INFO_DUMMY_BEAN.setREP_VALUE_20(CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"));
			iP_REP_INFO_DUMMY_BEAN.setREP_VALUE_21(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			iP_REP_INFO_DUMMY_BEAN.setREP_CR_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			iP_REP_INFO_DUMMY_BEAN.setREP_CR_DT(new CommonUtils().getCurrentDate());*/

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void PRE_UPDATE_lap(IP_REP_INFO_DUMMY iP_REP_INFO_DUMMY_BEAN) {

		try {
			iP_REP_INFO_DUMMY_BEAN.setREP_ID(resourceBundleApp.getString("mod_id"));
			/*iP_REP_INFO_DUMMY_BEAN.setREP_VALUE_20(CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"));
			iP_REP_INFO_DUMMY_BEAN.setREP_VALUE_21(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			iP_REP_INFO_DUMMY_BEAN.setREP_UPD_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			iP_REP_INFO_DUMMY_BEAN.setREP_UPD_DT(new CommonUtils().getCurrentDate());*/

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String sendPostRequest_Lapse(String redirectURL) throws Exception {

		StringBuffer response = new StringBuffer();

		try{

			System.out.println("Redirect URL--->" + redirectURL);

			redirectURL = redirectURL+"&attachment=Y";
			System.out.println("Post URL-->"+redirectURL);

			URL obj = new URL(redirectURL);

			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			int responseCode = /*con.getResponseCode()*/200;

			System.out.println("GET Response Code :: " + responseCode);
			if (responseCode == HttpURLConnection.HTTP_OK) {

				String polSysID = getPol_sys_id_lapse().toString();
				String prodCode = getProdCode(polSysID);

				response.append(emailStatusMsg(prodCode, "LAP", polSysID,"C", redirectURL));

			} else {
				System.out.println("GET request not worked");
				response.append("Unable to send the email");
			}


		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return response != null ? response.toString() : "";
	}

	/*End*/
	
	//Added by rakesh on 04-12-2019 for policy document attachment through scheduler process
	public void emailAction(String polsysid, String prod_code,String pol_ds_type)
			 throws Exception  {
		String message = "";
		String fileName = null;
		try {
			String pro = prod_code;
				long pol_sys_id = Long.parseLong(polsysid);
				String P_CUST_TYPE = "C";
				String moduleID = "PILT002_APAC";

				//fileName=System.getProperty("user.home")+"/Report0.pdf,"+System.getProperty("user.home")+"/Report1.pdf,"+System.getProperty("user.home")+"/Report2.pdf";
				//fileName=System.getProperty("user.home")+"/Report10.pdf,";
				if(pol_ds_type.equalsIgnoreCase("1"))
				{
					fileName="Quotation_Document.pdf";
					schedulerunAction(pol_sys_id,moduleID,prod_code,pol_ds_type);
					schedulerunActionAfterValidate(prod_code,moduleID,pol_ds_type);
					String emailStatusMessage = schedulesendGet(polsysid,
							getRedirectUrl1(),
							pro, P_CUST_TYPE, "", fileName, "",pol_ds_type);
					System.out.println("EMAIL STATUS MESSAGE-->"
							+ emailStatusMessage);
					if(emailStatusMessage != null && "Y".equalsIgnoreCase(emailStatusMessage)){
						updatePolicyTab(polsysid);
					}
					message = message + emailStatusMessage;
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
							message);
				}
				else
				{
					fileName=System.getProperty("user.home")+"/PolicyDocument.pdf,"+System.getProperty("user.home")+"/PolicyDocument1.pdf,"+System.getProperty("user.home")+"/PolicyDocument2.pdf";
					schedulerunAction(pol_sys_id,moduleID,prod_code,pol_ds_type);
					schedulerunActionAfterValidate(prod_code,moduleID,pol_ds_type);
					String emailStatusMessage = schedulesendGet(polsysid,
							getRedirectUrl1() + "&attachment=Y",
							pro, P_CUST_TYPE, "", fileName, "",pol_ds_type);
					System.out.println("EMAIL STATUS MESSAGE-->"
							+ emailStatusMessage);
					message = message + emailStatusMessage;
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
							message);
				}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public String schedulerunAction(long POLSYSID,String moduleID,String prod_code,String pol_ds_type) {
		
		Connection runActionConnection = null;
		String query ="SELECT SEQ_REP_KEY_NO.NEXTVAL FROM DUAL";
		String getREPIDQuery ="SELECT PMLIT_KEY FROM PM_REP_TAB_DTL WHERE PMLIT_PROD_CODE = ?";
		ResultSet rs=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		String repid="";
		String repid1="";
		String repid2="";

		ResultSet resultSet=null;
		CRUDHandler handler=new CRUDHandler();
		try {
				String POL_SYS_ID = String.valueOf(POLSYSID);
				runActionConnection=getConnection();
				if(pol_ds_type.equalsIgnoreCase("2"))
				{
					rs = handler.executeSelectStatement(getREPIDQuery, runActionConnection, new Object[]{prod_code,resourceBundleApp.getString("POL_XDOC")});
					while(rs.next())
					{
						repid = rs.getString(1);
					}
					rs1 = handler.executeSelectStatement(getREPIDQuery, runActionConnection, new Object[]{prod_code,resourceBundleApp.getString("POL_WORD")});
					while(rs1.next())
					{
						repid1 = rs1.getString(1);
					}
					rs2 = handler.executeSelectStatement(getREPIDQuery, runActionConnection, new Object[]{prod_code,resourceBundleApp.getString("POL_SCHEDULE")});
					while(rs2.next())
					{
						repid2 = rs2.getString(1);
					}
					
					String header_logo = System.getProperty("user.home")+"\\"+resourceBundleApp.getString("jasper_logo_path")+"\\"+
								resourceBundleApp.getString("lifeschedulelogo");
					String schedulerepid = resourceBundleApp.getString("schedule")+prod_code;
					String wordingrepid = resourceBundleApp.getString("wording")+prod_code;
					String welletterrepid = resourceBundleApp.getString("wel_letter")+prod_code;
					if (IP_REP_INFO_DUMMY_BEAN.getROWID() == null) {
						if(repid.equalsIgnoreCase(welletterrepid))
						{
							resultSet=handler.executeSelectStatement(query, runActionConnection);
							if(resultSet.next()){
								setRepKeyNo(resultSet.getString(1));
							}
							System.out.println("ENTER IP_REP_INFO_DUMMY_BEAN");
							//PRE_INSERT(this.IP_REP_INFO_DUMMY_BEAN);
							IP_REP_INFO_DUMMY_BEAN.setREP_KEY_NO(getRepKeyNo());
							IP_REP_INFO_DUMMY_BEAN.setREP_ID(moduleID);
							IP_REP_INFO_DUMMY_BEAN.setREP_VALUE_1(POL_SYS_ID);
							IP_REP_INFO_DUMMY_BEAN.setREP_VALUE_20("001");
							IP_REP_INFO_DUMMY_BEAN.setREP_VALUE_21("ENG");
							
							String ins_query = "INSERT INTO IP_REP_INFO (REP_KEY_NO,REP_ID,REP_VALUE_1,REP_VALUE_20,REP_VALUE_21) VALUES (?,?,?,?,?)";
							int recordCount = new CRUDHandler().executeInsertStatement(ins_query, runActionConnection,new Object[]{IP_REP_INFO_DUMMY_BEAN.getREP_KEY_NO(),IP_REP_INFO_DUMMY_BEAN.getREP_ID(),
									IP_REP_INFO_DUMMY_BEAN.getREP_VALUE_1(),IP_REP_INFO_DUMMY_BEAN.getREP_VALUE_20(),IP_REP_INFO_DUMMY_BEAN.getREP_VALUE_21()});
							System.out.println("IP_REP_TABLE insert count -- ["
									+ recordCount + "]");
							runActionConnection.commit();
						}
						if(repid1.equalsIgnoreCase(wordingrepid))
						{
							resultSet=handler.executeSelectStatement(query, runActionConnection);
							if(resultSet.next()){
								setRepKeyNo(resultSet.getString(1));
							}
							System.out.println("ENTER IP_REP_INFO_DUMMY_BEAN1");
							IP_REP_INFO_DUMMY_BEAN.setREP_KEY_NO(getRepKeyNo());
							IP_REP_INFO_DUMMY_BEAN.setREP_ID(repid1);
							IP_REP_INFO_DUMMY_BEAN.setREP_VALUE_1("3");
							IP_REP_INFO_DUMMY_BEAN.setREP_VALUE_2("POL_SYS_ID&&&"+POL_SYS_ID);
							IP_REP_INFO_DUMMY_BEAN.setREP_VALUE_3("LOGO1"+"&&&"+header_logo);
							
							System.out.println("getREP_KEY_NO             "+IP_REP_INFO_DUMMY_BEAN.getREP_KEY_NO());
		
							String ins_query = "INSERT INTO IP_REP_INFO (REP_KEY_NO,REP_ID,REP_VALUE_1,REP_VALUE_2,REP_VALUE_3) VALUES (?,?,?,?,?)";
							
							int recordCount = new CRUDHandler().executeInsertStatement(ins_query, runActionConnection,new Object[]{IP_REP_INFO_DUMMY_BEAN.getREP_KEY_NO(),IP_REP_INFO_DUMMY_BEAN.getREP_ID(),
									IP_REP_INFO_DUMMY_BEAN.getREP_VALUE_1(),IP_REP_INFO_DUMMY_BEAN.getREP_VALUE_2(),IP_REP_INFO_DUMMY_BEAN.getREP_VALUE_3()});
							
							System.out.println("IP_REP_TABLE insert count -- ["
									+ recordCount + "]");
							runActionConnection.commit();
						}
						if(repid2.equalsIgnoreCase(schedulerepid))
						{
							resultSet=handler.executeSelectStatement(query, runActionConnection);
							if(resultSet.next()){
								setRepKeyNo(resultSet.getString(1));
							}
							System.out.println("ENTER IP_REP_INFO_DUMMY_BEAN1");
							IP_REP_INFO_DUMMY_BEAN.setREP_KEY_NO(getRepKeyNo());
							IP_REP_INFO_DUMMY_BEAN.setREP_ID(repid2);
							IP_REP_INFO_DUMMY_BEAN.setREP_VALUE_1("3");
							IP_REP_INFO_DUMMY_BEAN.setREP_VALUE_2("POL_SYS_ID&&&"+POL_SYS_ID);
							IP_REP_INFO_DUMMY_BEAN.setREP_VALUE_3("LOGO1"+"&&&"+header_logo);
							
							System.out.println("getREP_KEY_NO             "+IP_REP_INFO_DUMMY_BEAN.getREP_KEY_NO());
		
							String ins_query = "INSERT INTO IP_REP_INFO (REP_KEY_NO,REP_ID,REP_VALUE_1,REP_VALUE_2,REP_VALUE_3) VALUES (?,?,?,?,?)";
							
							int recordCount = new CRUDHandler().executeInsertStatement(ins_query, runActionConnection,new Object[]{IP_REP_INFO_DUMMY_BEAN.getREP_KEY_NO(),IP_REP_INFO_DUMMY_BEAN.getREP_ID(),
									IP_REP_INFO_DUMMY_BEAN.getREP_VALUE_1(),IP_REP_INFO_DUMMY_BEAN.getREP_VALUE_2(),IP_REP_INFO_DUMMY_BEAN.getREP_VALUE_3()});
							
							System.out.println("IP_REP_TABLE insert count -- ["
									+ recordCount + "]");
							runActionConnection.commit();
						}
				} else {

					PRE_UPDATE(this.IP_REP_INFO_DUMMY_BEAN);
				}
			}
			else
			{
				rs = handler.executeSelectStatement(getREPIDQuery, runActionConnection, new Object[]{prod_code});
				while(rs.next())
				{
					repid = rs.getString(1);
				}
				
				String header_logo = System.getProperty("user.home")+"/"+resourceBundleApp.getString("jasper_logo_path")+"/"+
							resourceBundleApp.getString("receipt_header_logo");
				String sign_logo = System.getProperty("user.home")+"/"+resourceBundleApp.getString("jasper_logo_path")+"/"+
						resourceBundleApp.getString("receipt_footer_logo");
				if (IP_REP_INFO_DUMMY_BEAN.getROWID() == null) {
					
						resultSet=handler.executeSelectStatement(query, runActionConnection);
						if(resultSet.next()){
							setRepKeyNo(resultSet.getString(1));
						}
						System.out.println("ENTER IP_REP_INFO_DUMMY_BEAN1");
						IP_REP_INFO_DUMMY_BEAN.setREP_KEY_NO(getRepKeyNo());
						IP_REP_INFO_DUMMY_BEAN.setREP_ID(repid);
						IP_REP_INFO_DUMMY_BEAN.setREP_VALUE_1("4");
						IP_REP_INFO_DUMMY_BEAN.setREP_VALUE_2("POL_SYS_ID&&&"+POL_SYS_ID);
						IP_REP_INFO_DUMMY_BEAN.setREP_VALUE_3("LOGO1"+"&&&"+header_logo);
						IP_REP_INFO_DUMMY_BEAN.setREP_VALUE_4("LOGO2"+"&&&"+sign_logo);
						
						System.out.println("getREP_KEY_NO             "+IP_REP_INFO_DUMMY_BEAN.getREP_KEY_NO());
	
						String ins_query = "INSERT INTO IP_REP_INFO (REP_KEY_NO,REP_ID,REP_VALUE_1,REP_VALUE_2,REP_VALUE_3,REP_VALUE_4) VALUES (?,?,?,?,?,?)";
						
						int recordCount = new CRUDHandler().executeInsertStatement(ins_query, runActionConnection,new Object[]{IP_REP_INFO_DUMMY_BEAN.getREP_KEY_NO(),IP_REP_INFO_DUMMY_BEAN.getREP_ID(),
								IP_REP_INFO_DUMMY_BEAN.getREP_VALUE_1(),IP_REP_INFO_DUMMY_BEAN.getREP_VALUE_2(),IP_REP_INFO_DUMMY_BEAN.getREP_VALUE_3(),IP_REP_INFO_DUMMY_BEAN.getREP_VALUE_4()});
						
						System.out.println("IP_REP_TABLE insert count -- ["
								+ recordCount + "]");
						runActionConnection.commit();
					
			} else {

				PRE_UPDATE(this.IP_REP_INFO_DUMMY_BEAN);
			}	
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Print_Action", e.getMessage());
		}finally{
			if(runActionConnection != null){
				try {
					runActionConnection.commit();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public String schedulerunActionAfterValidate(String prod_code,String moduleID,String pol_ds_type) {
		HttpServletResponse response = null;

		String getREPIDQuery ="SELECT PMLIT_KEY FROM PM_REP_TAB_DTL WHERE PMLIT_PROD_CODE = ?";
		ResultSet rs=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		String repid="";
		String repid1="";
		String repid2="";
		Connection con = null;
		CRUDHandler handler=new CRUDHandler();
		url =  resourceBundleApp.getString("Jasper_bordeauxUrl");
		url1 =  resourceBundleApp.getString("mdocsUrl");
		System.out.println("emailUrl  "+url+url1);
		String repidurl=null;
		String repid1url=null;
		String repid2url=null;
		String rep_template_name = null;
		try {
			con= getConnection();
			ArrayList<String> list = new ArrayList<String>();
			if(pol_ds_type.equalsIgnoreCase("2"))
			{
				rs = handler.executeSelectStatement(getREPIDQuery, con, new Object[]{prod_code,resourceBundleApp.getString("POL_XDOC")});
				while(rs.next())
				{
					repid = rs.getString(1);
				}
				rs1 = handler.executeSelectStatement(getREPIDQuery, con, new Object[]{prod_code,resourceBundleApp.getString("POL_WORD")});
				while(rs1.next())
				{
					repid1 = rs1.getString(1);
				}
				rs2 = handler.executeSelectStatement(getREPIDQuery, con, new Object[]{prod_code,resourceBundleApp.getString("POL_SCHEDULE")});
				while(rs2.next())
				{
					repid2 = rs2.getString(1);
				}
				String schedulerepid = resourceBundleApp.getString("schedule")+prod_code;
				String wordingrepid = resourceBundleApp.getString("wording")+prod_code;
				String welletterrepid = resourceBundleApp.getString("wel_letter")+prod_code;
				if(repid.equalsIgnoreCase(welletterrepid))
				{
					Alternate_Rep_ID(repid);
					String ALT_REP_KEY_NO = scheduleAlternate_Rep_ID();
					rep_template_name = "repKeyNo=" + ALT_REP_KEY_NO
							+ "&repId=" + moduleID
							+ "&templateId=&templateRepId="+repid
							+ "&Type=M&viewtype=view";
					repidurl=url1+rep_template_name;
					System.out.println("repidurl   : " + repidurl);
					System.out.println("rep_template_name "+ rep_template_name);
	
				}
				if(repid1.equalsIgnoreCase(wordingrepid))
				{
					Alternate_Rep_ID(repid1);
					String ALT_REP_KEY_NO = scheduleAlternate_Rep_ID();
					rep_template_name = "&REP_ID=" + repid1
							+ "&REP_KEY_NO=" + ALT_REP_KEY_NO
							+ "&viewtype=view";
					repid1url=url+rep_template_name;
					System.out.println("repid1url   : " + repid1url);
					System.out.println("rep_template_name "+ rep_template_name);
				}
				if(repid2.equalsIgnoreCase(schedulerepid))
				{
					Alternate_Rep_ID(repid2);
					String ALT_REP_KEY_NO = scheduleAlternate_Rep_ID();
					rep_template_name = "&REP_ID=" + repid2
							+ "&REP_KEY_NO=" + ALT_REP_KEY_NO
							+ "&viewtype=view";
					repid2url=url+rep_template_name;
					System.out.println("repid2url   : " + repid2url);
					System.out.println("rep_template_name "+ rep_template_name);
				}
				setRedirectUrl1(repidurl+","+repid1url+","+repid2url);	
			}
			else
			{
				rs = handler.executeSelectStatement(getREPIDQuery, con, new Object[]{prod_code});
				while(rs.next())
				{
					repid = rs.getString(1);
				}
				
				Alternate_Rep_ID(repid);
				String ALT_REP_KEY_NO = scheduleAlternate_Rep_ID();
				rep_template_name = "&REP_ID=" + repid
							+ "&REP_KEY_NO=" + getRepKeyNo()
							+ "&viewtype=view";
				repidurl=url+rep_template_name;
				System.out.println("repid1url   : " + repidurl);
				System.out.println("rep_template_name "+ rep_template_name);
				setRedirectUrl1(repidurl);	
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("runAction", e.getMessage());
		}
		return null;
	}
	
	//END
	
	public String schedulesendGet(String pol_sys_id,String redirectURL, String productCode,
			String mailSendTo,String emailTemplateType, String fileName, String statusCode,String ds_type) throws Exception 
		{
		StringBuffer response = new StringBuffer();
		String returnValue = null;
		Connection connection = null;
		try{

			System.out.println("Redirect URL--->" + redirectURL);

			//redirectURL = redirectURL+"&attachment=Y";
			System.out.println("Post URL-->"+redirectURL);
			int responseCode = 0 ;
			URL obj = null;
			HttpURLConnection con = null;
			connection = getConnection();
			if(ds_type.equalsIgnoreCase("2"))
			{
					for(int j=0;j<redirectURL.split(",").length;j++)
					{
						obj = new URL(redirectURL.split(",")[j]);
						con = (HttpURLConnection) obj.openConnection();
						System.out.println("url"+obj);
					
						con.setRequestMethod("GET");
						con.setRequestProperty("User-Agent", "Mozilla/5.0");
						responseCode = con.getResponseCode();
		
						if(responseCode == HttpURLConnection.HTTP_OK)
						{
								System.out.println("Success");
						}
						else
						{
							System.out.println("Failed");
						}
						con.disconnect();
					}
					if (responseCode == HttpURLConnection.HTTP_OK) {
						
						String polSysID = pol_sys_id;
						String prodCode = productCode;
						response.append(Email_Procedure_Call.emailTriggerProcCallWithFileName(prodCode, "POL", polSysID, "C", redirectURL,fileName,null, connection));
					} else {
						System.out.println("GET request not worked");
						response.append("Unable to send the email");
					}	
			}
			else
			{
				obj = new URL(redirectURL);
				con = (HttpURLConnection) obj.openConnection();
				con.setRequestMethod("GET");
				//con.connect();
				responseCode = con.getResponseCode();

				if(responseCode == HttpURLConnection.HTTP_OK)
				{
						System.out.println("Success");
				}
				else
				{
					System.out.println("Failed");
				}
				con.disconnect();
				System.out.println("GET Response Code :: " + responseCode);
				if (responseCode == HttpURLConnection.HTTP_OK) {
	
					String polSysID = pol_sys_id;
					String prodCode = productCode;
					returnValue = Email_Procedure_Call.emailTriggerProcCallWithFileName(prodCode, "001", polSysID, "C", redirectURL,fileName,null, connection);
					connection.commit();
					response.append(returnValue);
				} else {
					System.out.println("GET request not worked");
					response.append("Unable to send the email");
				}	
			}
				
			

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			if(connection !=null){
				connection.close();
			}
		}

		//return response != null ? response.toString() : "";
		return returnValue;
	}

	public void Alternate_Rep_ID(String reporttypevalue) throws SQLException{
		Connection connection = null;
		String Alt_Rep_ID=null;
		String Multi_Rep_ID=null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = getConnection();
			String Query="SELECT PMRTH_PRNT_ALT_REP_ID FROM pm_rep_tab_hdr WHERE PMRTH_REP_ID = ?";
			String Query1="SELECT PMRTH_MULTIPLE_REPORT_NAMES FROM pm_rep_tab_hdr WHERE PMRTH_REP_ID = ?";
			
			System.out.println("UI_REPORT_TYPE()  :"+reporttypevalue);
			ResultSet rs2 = new CRUDHandler().executeSelectStatement(Query, connection,new Object[]{reporttypevalue});
			while(rs2.next())
			{
				Alt_Rep_ID=rs2.getString("PMRTH_PRNT_ALT_REP_ID");
			}
			setAlternate_Rep_ID(Alt_Rep_ID);
			ResultSet rs = new CRUDHandler().executeSelectStatement(Query1, connection,new Object[]{getAlternate_Rep_ID()});
			while(rs.next())
			{
				Multi_Rep_ID=rs.getString("PMRTH_MULTIPLE_REPORT_NAMES");
			}
			setMultiple_Rep_ID(Multi_Rep_ID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String scheduleAlternate_Rep_ID() throws SQLException{
		String ALT_REP_KEY_NO= null;
		try {
				if(getAlternate_Rep_ID()!=null){
					String Report_Type=getAlternate_Rep_ID();
					if(getMultiple_Rep_ID()!=null){
						
						ALT_REP_KEY_NO=IP_REP_INFO_DUMMY_BEAN.getREP_KEY_NO()+",";
						String[] Split_Rep_ID = getMultiple_Rep_ID().split(",");
						int length=Split_Rep_ID.length;
						System.out.println("Length  :"+length);
						for(int i=0;i<length-1;i++){
							IP_REP_INFO_DUMMY_BEAN=new IP_REP_INFO_DUMMY();	
							runAction();
							ALT_REP_KEY_NO=ALT_REP_KEY_NO+IP_REP_INFO_DUMMY_BEAN.getREP_KEY_NO()+",";
							System.out.println("ALT_REP_KEY_NO   :"+ALT_REP_KEY_NO);
						}
						ALT_REP_KEY_NO=ALT_REP_KEY_NO.substring(0,ALT_REP_KEY_NO.length()-1);
						System.out.println("ALT_REP_KEY_NO  substring :"+ALT_REP_KEY_NO);
					}
				}
			}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ALT_REP_KEY_NO;
	}

	private String UI_REPORT_TYPE;
	public String Alternate_Rep_ID;

	public String Multiple_Rep_ID;

	public String mailAttachReq;

	public String getMailAttachReq() {
		return mailAttachReq;
	}
	public void setMailAttachReq(String mailAttachReq) {
		this.mailAttachReq = mailAttachReq;
	}
	public String getMultiple_Rep_ID() {
		return Multiple_Rep_ID;
	}
	public void setMultiple_Rep_ID(String multiple_Rep_ID) {
		Multiple_Rep_ID = multiple_Rep_ID;
	}
	public String getAlternate_Rep_ID() {
		return Alternate_Rep_ID;
	}

	public void setAlternate_Rep_ID(String alternate_Rep_ID) {
		Alternate_Rep_ID = alternate_Rep_ID;
	}
	public String getUI_REPORT_TYPE() {
		return UI_REPORT_TYPE;
	}

	public void setUI_REPORT_TYPE(String uI_REPORT_TYPE) {
		UI_REPORT_TYPE = uI_REPORT_TYPE;
	}
	String url1;
	String url2;
	public String RedirectUrl1;

	public String getRedirectUrl1() {
		return RedirectUrl1;
	}

	public void setRedirectUrl1(String redirectUrl1) {
		RedirectUrl1 = redirectUrl1;
	}
	//END
	/**/
	public void updatePolicyTab(String polSysId){
		Connection connection = null;
		String query = null;
		CRUDHandler handler = new CRUDHandler();
		try{
			connection = getConnection();
			query = "UPDATE PT_IL_POLICY SET POL_MAIL_STATUS = 'Y' WHERE POL_SYS_ID =?";
			handler.executeUpdateStatement(query, connection, new Object[]{polSysId});
			connection.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
