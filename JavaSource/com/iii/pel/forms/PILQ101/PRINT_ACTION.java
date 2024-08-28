package com.iii.pel.forms.PILQ101;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POLICY;
import com.iii.pel.forms.REPORT.IP_REP_INFO;
import com.iii.pel.util.Email_Procedure_Call;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ReportUtils;

public class PRINT_ACTION extends CommonReportAction{
	
	/*Added by Janani on 29/08/2016 for Dynamic Report Configuration*/
	private  final static ResourceBundle resourceBundle=ResourceBundle.getBundle("FalconReports");

	/*End*/
	
	
private PRINT_HELPER helper;
public PT_IL_POLICY_ACTION compositeAction;
// Added by saranya for ssp call id FALCONQC-1715539 0n 19-07-2016
private PT_IL_PREM_COLL_ACTION PT_IL_PREM_COLL_ACTION_BEAN;

public PT_IL_PREM_COLL_ACTION getPT_IL_PREM_COLL_ACTION_BEAN() {
	return PT_IL_PREM_COLL_ACTION_BEAN;
}

public void setPT_IL_PREM_COLL_ACTION_BEAN(
		PT_IL_PREM_COLL_ACTION pT_IL_PREM_COLL_ACTION_BEAN) {
	PT_IL_PREM_COLL_ACTION_BEAN = pT_IL_PREM_COLL_ACTION_BEAN;
}
//End
public PRINT_ACTION() {
	helper=new PRINT_HELPER();
	PT_IL_PREM_COLL_ACTION_BEAN=new PT_IL_PREM_COLL_ACTION();
}
	StringBuffer url=null;
	
	
	public String printButtonAction() throws Exception {
		
		System.out.println("Enter printButtonAction");
		callReportModalPanel();
		
		PT_IL_PREM_COLL_ACTION_BEAN.populate_details();
		//setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK());
	
	return getRedirectUrl();
	}
	
	
	
	/*
	 * 
	 * Commented by Janani on 12.9.2016 for dynamic report config
	 * 
	 * public String runActionAfterValidate() {
		CommonUtils.clearMaps(this);
		HttpServletResponse response = null;
		
		try {
			url=new StringBuffer(getRedirectUrl());
			String pol_no=compositeAction.getPT_IL_POLICY_BEAN().getPOL_NO();
			Double NETAMT=compositeAction.getPT_IL_POLICY_BEAN().getUI_M_NET_FC_PAID_AMT();
			Double Charge=compositeAction.getPT_IL_POLICY_BEAN().getUI_M_REINS_FC_CHARGE();
			System.out.println("value of Charge--->"+Charge);
			// Added by saranya for ssp call id FALCONQC-1715539 0n 19-07-2016
			String PREMIUMDUE= CommonUtils.getGlobalVariable("GLOBAL.Global_FC_GROSS");
			System.out.println("value FC GROSS=======>   ::"+PREMIUMDUE);
			//end
			Double INTEREST =compositeAction.getPT_IL_POLICY_BEAN().getUI_M_INTEREST();
			System.out.println("INTEREST  ::"+INTEREST);
			Date DATE =compositeAction.getPT_IL_POLICY_BEAN().getUI_M_REINSTMT_DT();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String date=df.format(DATE);
			System.out.println(date);
			System.out.println("pol_no"+pol_no);
			System.out.println("NETAMT   :::"+NETAMT);
			// Modified by saranya for ssp call id FALCONQC-1715539 0n 19-07-2016
			url.append("ReportType=QuotationReport&POL_NO="+pol_no+"&NETAMT="+NETAMT+"&INTEREST="+INTEREST+"&PREMIUMDUE="+PREMIUMDUE+"&Charge="+Charge);
			//end
 setRedirectUrl(url.toString());
			if (getRedirectUrl() != null) {
				response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
				response.sendRedirect(getRedirectUrl());
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("runAction", e.getMessage());
		}
		return null;
	}
	
	*
	*End
	*
	*/
	
	
/*Added by Janani on 12.9.2016 for dynamic report config*/
	
	public String runActionAfterValidate() {
		CommonUtils.clearMaps(this);
		HttpServletResponse response = null;
		HttpServletRequest request = null;
		try {
			
			url=new StringBuffer(getRedirectUrl());
			String pol_no=compositeAction.getPT_IL_POLICY_BEAN().getPOL_NO();
			Double NETAMT=compositeAction.getPT_IL_POLICY_BEAN().getUI_M_NET_FC_PAID_AMT();
			Double Charge=compositeAction.getPT_IL_POLICY_BEAN().getUI_M_REINS_FC_CHARGE();
			System.out.println("value of Charge--->"+Charge);
			// Added by saranya for ssp call id FALCONQC-1715539 0n 19-07-2016
			/*Added by ganesh on 16-08-2017 for ZBILQC-1719657, as suggested by Mr.siva*/ 
			String PREMIUMDUE=String.valueOf(Double.valueOf(CommonUtils.getGlobalVariable("GLOBAL.Global_FC_GROSS"))+Double.valueOf(CommonUtils.getGlobalVariable("GLOBAL.FC_CHARGE_SUM")));
			Double INTEREST =compositeAction.getPT_IL_POLICY_BEAN().getUI_M_INTEREST();
			/*Added by janani for dynamic report config on 29.08.2016*/
			String report_id = resourceBundle.getString("RevivalQuotation");
			IP_REP_INFO repInfo = new IP_REP_INFO();
			String REP_KEY_NO = new ReportUtils().getRepKeyNo();
			
			/*Newly added By Dhinesh on 19-06-2017*/
			String pol_sys_id = null;
			pol_sys_id = compositeAction.getPT_IL_POLICY_BEAN().getPOL_SYS_ID().toString();
			/*END*/
			
			String Reinsteemnt_Date= CommonUtils.dateToStringFormat(compositeAction.getPT_IL_POLICY_BEAN().getUI_M_REINSTMT_DT());
			

			System.out.println("REP_KEY_NO          :"+REP_KEY_NO);
			repInfo.setREP_KEY_NO(REP_KEY_NO);
			/*Modified by ganesh on 07-09-2017, for ZBILQC-1719657*/
			//repInfo.setREP_VALUE_1("7");
			int currencyDecimalDigits = 0;
			if(CommonUtils.getGlobalObject("CURRENCY")!=null){
				currencyDecimalDigits = Integer.valueOf((CommonUtils.getGlobalObject("CURRENCY").toString()));
				System.out.println("Actual Currency Decimal Points-->"+currencyDecimalDigits);
			}else{
				currencyDecimalDigits = 2;
			}
			
			repInfo.setREP_VALUE_1("8");
			/*END*/
			repInfo.setREP_VALUE_2("POL_NO"+"&&&"+pol_no.toString());

			if(NETAMT != null)
			{
				repInfo.setREP_VALUE_3("NETAMT"+"&&&"+NETAMT);
			}
			else
			{
				repInfo.setREP_VALUE_3("NETAMT"+"&&&"+Double.valueOf("0.000"));
			}
			if(INTEREST != null)
			{
			
				repInfo.setREP_VALUE_4("INTEREST"+"&&&"+CommonUtils.Decimal_Convert(String.valueOf(INTEREST)));

			}
			else
			{
				repInfo.setREP_VALUE_4("INTEREST"+"&&&"+Double.valueOf("0.000"));
			}
			if(PREMIUMDUE != null)
			{
				repInfo.setREP_VALUE_5("PREMIUMDUE"+"&&&"+CommonUtils.Decimal_Convert(PREMIUMDUE));

			}
			else
			{

				repInfo.setREP_VALUE_5("PREMIUMDUE"+"&&&"+Double.valueOf("0.000"));
			}	
			if(Charge != null)
			{
				repInfo.setREP_VALUE_6("Charge"+"&&&"+String.valueOf(CommonUtils.Decimal_Convert(String.valueOf(Charge))));
			}
			else
			{
				repInfo.setREP_VALUE_6("Charge"+"&&&"+Double.valueOf("0.000"));
			}
			/*Newly added By Dhinesh on 19-06-2017*/
			if(pol_sys_id != null)
			{
				repInfo.setREP_VALUE_7("POL_SYS_ID"+"&&&"+pol_sys_id);
			}
			
			/* End */
			/*Modified by ganesh on 07-09-2017, for ZBILQC-1719657*/			
			if(compositeAction.getPT_IL_POLICY_BEAN().getUI_M_AVAIL_FC_DEP_AMT()!=null){
				
					
					repInfo.setREP_VALUE_8("AVAIL_DEPOSIT"+"&&&"+new BigDecimal(String.valueOf(compositeAction.getPT_IL_POLICY_BEAN().getUI_M_AVAIL_FC_DEP_AMT())).setScale(currencyDecimalDigits, BigDecimal.ROUND_HALF_UP).toString());
				
			}else{
				repInfo.setREP_VALUE_8("Charge"+"&&&"+CommonUtils.Decimal_Convert("0"));
			}
			/*END*/
			Connection conn = CommonUtils.getConnection();
			int ins = new CRUDHandler().executeInsert(repInfo, conn);
			conn.commit();


			url.append("REP_KEY_NO="+REP_KEY_NO+"&REP_ID="+report_id);

			/*end*/	
			
			
			/*Newly added By Dhinesh on 19-06-2017*/
			P_MEDICAL_EXAM_DTL(pol_sys_id,Reinsteemnt_Date);
			/*End*/
			
			
			setRedirectUrl(url.toString());
			
			/*Newly added By Dhinesh on 19-06-2017*/
			String Email_reinst = CommonUtils.nvl(CommonUtils.getGlobalVariable("GLOBAL.EMAIL_REINST"), "False");
			/*END*/
			
			if (getRedirectUrl() != null && !"TRUE".equalsIgnoreCase(Email_reinst)) {
				response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
				response.sendRedirect(getRedirectUrl());
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("runAction", e.getMessage());
		}
		return null;
	}
	
	
	
	/*end*/
	
	
	public String runAction(){
		try {
			System.out.println("******** Enter the RunAction Method ********");
			/*System.out.println("POL_NO  253    : "+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO());
			System.out.println("getPOL_SYS_ID  253    : "+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
			*/
			setRedirectUrl(helper.WHEN_BUTTON_PRESSED_M_BUT_OK());
			//runActionAfterValidate();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Print_Action", e.getMessage());
		}
		return getRedirectUrl();
	}

	
	
	/*Added by Janani on 12.9.2016 for dynamic report config*/
	
	public String Decimal_Convert(String Value)
	{
		if(Value != null)
		{
			int decimalPlaces=3;
			/*System.out.println("CommonUtils.getGlobalVariable(CURR_DECIMAL)  : "+CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL"));
		 decimalPlaces=(int)CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL");*/
			System.out.println("decimalPlaces   : "+decimalPlaces);


			BigDecimal bd = new BigDecimal(Value);
			bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_DOWN);

			return bd.toString();
		}
		else
		{
			return "0.000";
		}
	}
	
	
	/*end*/
	
	
	public String emailButtonAction() throws Exception {
		HttpServletRequest request= null;
		try {
			request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
			String Url = null;
			compositeAction.getPRINT_ACTION_BEAN().runAction();
			CommonUtils.setGlobalVariable("GLOBAL.EMAIL_REINST", "TRUE");
			compositeAction.getPRINT_ACTION_BEAN().runActionAfterValidate();
			Url = "http://"+request.getServerName() +":"+request.getServerPort()+"/"+compositeAction.getPRINT_ACTION_BEAN().getRedirectUrl();
			String emailStatusMessage = sendPostRequest(Url);					
			System.out.println("message ============>>>>>>>>>>" + emailStatusMessage);
			compositeAction.getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					emailStatusMessage);
			compositeAction.getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					emailStatusMessage);
			CommonUtils.setGlobalVariable("GLOBAL.EMAIL_REINST", "FALSE");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public String getProdCode(String polSysID) throws Exception {
		 Connection connection = null;
		 ResultSet resultSet = null;
		 String prodCode = null;
		 String query = "SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_SYS_ID = ?";
		 try {
			 connection = CommonUtils.getConnection();
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
	
	
	public String sendPostRequest(String finalURL) throws Exception{
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
			
			String polSysID = compositeAction.getPT_IL_POLICY_BEAN().getPOL_SYS_ID().toString();
			String prodCode = getProdCode(polSysID);
			//Modifed template name by ganesh on 17-08-2017			
			String emailStatusMessage = Email_Procedure_Call.emailStatusMsg(prodCode, "REI", polSysID, "C", outPutFileName.toString());
			System.out.println("Email Response message in post request--->"+emailStatusMessage);
			response.append(outPutFileName.toString().equals("")?"Unable to send attachment for this approval":emailStatusMessage);
			
		} else {
			System.out.println("POST request not worked");
			response.append("Unable to send the email");
		}
		
		return (response!=null?response.toString():"");
	}	
	
	public void P_MEDICAL_EXAM_DTL(String POL_SYS_ID , String Reinstatedate) throws ProcedureException
	 {
		 Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
			 System.out.println("Enter into  Endos dt validation");
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
           OracleParameter param1 = new OracleParameter("IN1", "LONG", "IN",POL_SYS_ID);
           parameterList.add(param1);
           OracleParameter param2 = new OracleParameter("IN2", "DATE", "IN",Reinstatedate);
           parameterList.add(param2);
           
           OracleProcedureHandler procHandler = new OracleProcedureHandler();
           outputList = procHandler.execute(parameterList, connection,"P9ILPK_ZB_REPORT.P_MEDICAL_EXAM_DTL");
           CommonUtils.getConnection().commit();
        } catch(Exception e) {
        	ErrorHelpUtil.getErrorForProcedure(connection);
               throw new ProcedureException(e.getMessage());
        }
       //return outputList;
   }
	
	
	public String getpol_sys_id(String pol_no)
			throws Exception {
		Connection connection = null;
		ResultSet rs = null;
		Object[] value = null;
		CRUDHandler handler = new CRUDHandler();
		String query = "SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO = ?";
		Integer prodperiod = 0;
		value = new Object[] { pol_no };
		String pol_sys_id =null;
		try {
			connection = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(query, connection, value);

			if (rs.next()) {
				pol_sys_id = rs.getString("POL_SYS_ID");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return pol_sys_id;
	}
	
}
