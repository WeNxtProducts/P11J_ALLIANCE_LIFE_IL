/*package com.iii.pel.jasperreports;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.SimpleConnectionAgent;
import com.iii.premia.common.constants.REPORT_UTIL_CONSTANTS;
import com.iii.premia.common.utils.ReportUtils;

 *//**
 * Servlet implementation class for Servlet: ReportServlet
 *
 */

/*commented by dhinesh*/
/*
 public class ReportServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;

   private final static ResourceBundle resourceBundle = ResourceBundle
	.getBundle("Report_ID");

	public ReportServlet() {
		super();
	}   	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}  	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReportUtils repUtils = new ReportUtils();
		OutputStream outputStream = null;
		InputStream inputStream = null;
		String compCode=request.getParameter("compCode");
		String host=request.getParameter("host");
		String port=request.getParameter("port");
		String path=request.getParameter("path");
		String server=request.getParameter("server");
		String userId=request.getParameter("userId");
		String desType=request.getParameter("desType");
		String parameterString=null;
		Iterator<Entry<String, String>> itr=null;
		Entry<String, String> entryMap=null;
		Map<String,String> parameterMap=(Map<String, String>) request.getSession().getAttribute("parameterMap");
		String selectedFileType=request.getParameter("selectedFileType");
		String repId=request.getParameter("repId");
		String rKeyNo=request.getParameter("rKeyNo");
		String pModuleCode=request.getParameter("pModuleCode");
		String reportServerURLString=null;
		String mLangCode=request.getParameter("mLangCode");
		Map<String,String> reportExcelMap=null;
		String clientId = null;
		Connection connectionCreate = null;
		HttpSession session=request.getSession();
		URL url=null;
		URLConnection urlConnection=null;
		String line=null; 
		BufferedReader in=null;
		int len;
		byte[] buffer = new byte[4096]; // tweaking this number may increase performance 

		try {
				if(parameterMap!=null && parameterMap.size()>0){

					itr = parameterMap.entrySet().iterator();

					 while(itr.hasNext()){

						 entryMap=itr.next();

						 if(parameterString==null){

							parameterString="&"+entryMap.getKey()+"="+entryMap.getValue();

						}else{

							parameterString=parameterString+"&"+entryMap.getKey()+"="+entryMap.getValue(); 
						}
					 }
				}

				reportServerURLString=repUtils.reportServerURLString(host, port, path, userId,
																		server, repId, desType,
																		selectedFileType, rKeyNo, compCode,
																		pModuleCode, mLangCode, parameterString);
				System.out.println("ReportServlet.doXXXX: "+reportServerURLString);
				if(REPORT_UTIL_CONSTANTS.reportPDFFormat.equals(selectedFileType)||
						REPORT_UTIL_CONSTANTS.reportWordFormat.equals(selectedFileType)){

					if(REPORT_UTIL_CONSTANTS.reportPDFFormat.equals(selectedFileType)){

						response.setContentType("application/pdf");

					}else if(REPORT_UTIL_CONSTANTS.reportWordFormat.equals(selectedFileType)){

						response.setContentType("application/msword");
					}
					response.sendRedirect(reportServerURLString);

				}else if(REPORT_UTIL_CONSTANTS.reportExcelFormat.equals(selectedFileType)){

					if(session != null){
						clientId = (String) session.getAttribute("CLIENT_ID");
						connectionCreate = ((SimpleConnectionAgent) getServletContext()
								.getAttribute("connectionAgent")).getConnection(clientId);
					}
					url=new URL(reportServerURLString);
					urlConnection=url.openConnection();
					in= new BufferedReader(new InputStreamReader(urlConnection.getInputStream())); 
					System.out.println("---------- Oracle Report Server feedback --------------");
					while ((line = in.readLine()) != null) {
					 //System.out.println(line); 
					}

					reportExcelMap=repUtils.getReportExcelFileMap(repId, rKeyNo,connectionCreate);		

					// Wait for report creation
					waitForReportFileCreation(repId, reportExcelMap.get("reportExcelFilePath")+".xls");

					System.out.println("---------- Oracle Report Server feedback End --------------");
					outputStream = response.getOutputStream();
					response.setContentType("application/vnd.ms-excel");
					response.setHeader("Content-Disposition", "attachment; filename="+reportExcelMap.get("reportFileName")+".xls");
					inputStream = new FileInputStream(reportExcelMap.get("reportExcelFilePath")+".xls");
					while ((len = inputStream.read(buffer)) != -1)   
					{   
						outputStream.write(buffer, 0, len);   
					}   
					outputStream.flush();
					outputStream.close();
					inputStream.close();
				}


		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errormessage", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsf/include/error-page.xhtml");
			dispatcher.forward(request, response);
		}

		System.out.println("REP_GL_ID       :"+request.getParameter("repId"));
		System.out.println("REP_SEQ_ID       :"+request.getParameter("rKeyNo")); 
	response.sendRedirect("http://"+resourceBundle.getString("IP_address")+":"+resourceBundle.getString("port")+"/PREMIA_REPORT/IntegratePremiaReport?REP_ID="+resourceBundle.getString(request.getParameter("repId"))+"&REP_GL_ID="+request.getParameter("repId")+"&REP_SEQ_ID="+request.getParameter("rKeyNo"));


	}   

	private void waitForReportFileCreation(String repId, String filePath) throws Exception{
		long oldSize = -1;
		long currentSize = -1;
		long time = new Date().getTime();
		long timeOut = time + 5000;
		int counter = 0;
		File file = new File(filePath);
		String message = null;

		try{
			message = "[Report-" + repId + "] Report creation in progress..";
			System.out.println(message);
			//throw new Exception("Test error page.");
			do{
				time = new Date().getTime();
				currentSize = file.length();

				if(time >= timeOut){
					message = "[Report-" + repId + "] Report timed out.";
					System.out.println(message);
					throw new Exception(message);
				}else if(currentSize == oldSize){
					counter++;
					if(counter == 3){
						message = "[Report-" + repId + "] Report created successfully.";
						System.out.println(message);
						break;
					}
				}else{
					message = "[Report-" + repId + "] Current size of the report is: " + currentSize + "b";
					System.out.println(message);
					oldSize = currentSize;
				}
				Thread.sleep(10);
			}while(true);
		} catch (InterruptedException e) {
			message = "[Report-" + repId + "] Could not generate report, process interrupted.";
			System.out.println(message);
			throw new Exception(message);
		}
	}
}*/

/*end*/

package com.iii.pel.jasperreports;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.apps.persistence.SimpleConnectionAgent;
import com.iii.premia.common.constants.REPORT_UTIL_CONSTANTS;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.ReportUtils;

/**
 * Servlet implementation class for Servlet: ReportServlet
 *
 */
public class ReportServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	private final static ResourceBundle resourceBundle = ResourceBundle
			.getBundle("Report_ID");
	private final static ResourceBundle flagBundle = ResourceBundle.getBundle("JasperReport"); 
	public ReportServlet() {
		super();
	}   	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}  	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*	ReportUtils repUtils = new ReportUtils();
		OutputStream outputStream = null;
		InputStream inputStream = null;
		String compCode=request.getParameter("compCode");
		String host=request.getParameter("host");
		String port=request.getParameter("port");
		String path=request.getParameter("path");
		String server=request.getParameter("server");
		String userId=request.getParameter("userId");
		String desType=request.getParameter("desType");
		String parameterString=null;
		Iterator<Entry<String, String>> itr=null;
		Entry<String, String> entryMap=null;
		Map<String,String> parameterMap=(Map<String, String>) request.getSession().getAttribute("parameterMap");
		String selectedFileType=request.getParameter("selectedFileType");
		String repId=request.getParameter("repId");
		String rKeyNo=request.getParameter("rKeyNo");
		String pModuleCode=request.getParameter("pModuleCode");
		String reportServerURLString=null;
		String mLangCode=request.getParameter("mLangCode");
		Map<String,String> reportExcelMap=null;
		String clientId = null;
		Connection connectionCreate = null;
		HttpSession session=request.getSession();
		URL url=null;
		URLConnection urlConnection=null;
		String line=null; 
		BufferedReader in=null;
		int len;
		byte[] buffer = new byte[4096]; // tweaking this number may increase performance 

		try {
				if(parameterMap!=null && parameterMap.size()>0){

					itr = parameterMap.entrySet().iterator();

					 while(itr.hasNext()){

						 entryMap=itr.next();

						 if(parameterString==null){

							parameterString="&"+entryMap.getKey()+"="+entryMap.getValue();

						}else{

							parameterString=parameterString+"&"+entryMap.getKey()+"="+entryMap.getValue(); 
						}
					 }
				}

				reportServerURLString=repUtils.reportServerURLString(host, port, path, userId,
																		server, repId, desType,
																		selectedFileType, rKeyNo, compCode,
																		pModuleCode, mLangCode, parameterString);
				System.out.println("ReportServlet.doXXXX: "+reportServerURLString);
				if(REPORT_UTIL_CONSTANTS.reportPDFFormat.equals(selectedFileType)||
						REPORT_UTIL_CONSTANTS.reportWordFormat.equals(selectedFileType)){

					if(REPORT_UTIL_CONSTANTS.reportPDFFormat.equals(selectedFileType)){

						response.setContentType("application/pdf");

					}else if(REPORT_UTIL_CONSTANTS.reportWordFormat.equals(selectedFileType)){

						response.setContentType("application/msword");
					}
					response.sendRedirect(reportServerURLString);

				}else if(REPORT_UTIL_CONSTANTS.reportExcelFormat.equals(selectedFileType)){

					if(session != null){
						clientId = (String) session.getAttribute("CLIENT_ID");
						connectionCreate = ((SimpleConnectionAgent) getServletContext()
								.getAttribute("connectionAgent")).getConnection(clientId);
					}
					url=new URL(reportServerURLString);
					urlConnection=url.openConnection();
					in= new BufferedReader(new InputStreamReader(urlConnection.getInputStream())); 
					System.out.println("---------- Oracle Report Server feedback --------------");
					while ((line = in.readLine()) != null) {
					 //System.out.println(line); 
					}

					reportExcelMap=repUtils.getReportExcelFileMap(repId, rKeyNo,connectionCreate);		

					// Wait for report creation
					waitForReportFileCreation(repId, reportExcelMap.get("reportExcelFilePath")+".xls");

					System.out.println("---------- Oracle Report Server feedback End --------------");
					outputStream = response.getOutputStream();
					response.setContentType("application/vnd.ms-excel");
					response.setHeader("Content-Disposition", "attachment; filename="+reportExcelMap.get("reportFileName")+".xls");
					inputStream = new FileInputStream(reportExcelMap.get("reportExcelFilePath")+".xls");
					while ((len = inputStream.read(buffer)) != -1)   
					{   
						outputStream.write(buffer, 0, len);   
					}   
					outputStream.flush();
					outputStream.close();
					inputStream.close();
				}


		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errormessage", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsf/include/error-page.xhtml");
			dispatcher.forward(request, response);
		}*/

		/*added by dhinesh*/
		
		Connection con = null;

		/*added by dhinesh*/
		String clientId = null;
		HttpSession session=request.getSession();
		if(session != null){
			System.out.println("INSIDE SESSION          ");
			System.out.println("clientId         :"+session.getAttribute("CLIENT_ID"));
			clientId = (String) session.getAttribute("CLIENT_ID");
			try {
				con = ((SimpleConnectionAgent) getServletContext()
						.getAttribute("connectionAgent")).getConnection(clientId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String prod_code=request.getParameter("PROD_CODE");	
		//String prod_code="10105";
		String delims=",";
		String REP_Name =null;

if(prod_code!=null){

		System.out.println("call report servlet **********");
		
		Enumeration <String> keys = flagBundle.getKeys();
		while (keys.hasMoreElements()) {
			System.out.println("INSIDE WHILE LOOP");
			String key = keys.nextElement();
			System.out.println("key :"+key);
			String value = flagBundle.getString(key);
			System.out.println("value :"+value);
			StringTokenizer	 tokenizer=new StringTokenizer(value, delims);
			while (tokenizer.hasMoreElements()) { 
				System.out.println("WHILE LOOP ");
				value=(String) tokenizer.nextElement()	;
				System.out.println("value :"+value);
				System.out.println("prod_code :"+prod_code);
				if(prod_code.equalsIgnoreCase(value)){
					REP_Name=key;
					System.out.println("Report_name : "+REP_Name);
					break;
				}else
				{
					System.out.println("***************** Product Code Value NULL ");
				}
			}
		}
}
//		System.out.println("Report_name : "+REP_Name);
		String REP_ID=request.getParameter("repId");
		String Pol_sys_id=request.getParameter("P_POL_SYS_ID");
		
		/*Added by Jagadeesh*/
		
		String REP_KEY=request.getParameter("rKeyNo");
		
		/*END*/
		System.out.println("REP_GL_ID       :"+request.getParameter("repId"));
		System.out.println("REP_SEQ_ID       :"+request.getParameter("rKeyNo")); 
		System.out.println("");
	
		

		String JasperReportName=request.getParameter("JasperReportName");
		String JasperPolSysId=request.getParameter("JasperPolSysId");
		System.out.println("BEFORE IF REP_Name   : "+REP_Name);
		
		
		
		
		
		
		/*String QuestionnaireReportName=request.getParameter("ReportType"); ADDED by krithika on 30-03-2016*/
		String QuestionnaireReportName=request.getParameter("QuestionnaireReportName");
		
		String RevivalReportName=request.getParameter("RevivalReportName");
		
		/*added by Agalya on 24-05-2016*/
		
		String param0=request.getParameter("param0");
		String param1=request.getParameter("param1");
		String param2=request.getParameter("param2");
		String param3=request.getParameter("param3");	
		String param4=request.getParameter("param4");
		String param5=request.getParameter("param5");
		String param6=request.getParameter("param6");
		String param7=request.getParameter("param7");
		String param8=request.getParameter("param8");
		String param9=request.getParameter("param9");
		String param10=request.getParameter("param10");
		String param11=request.getParameter("param11");
		String param12=request.getParameter("param12");
		String param13=request.getParameter("param13");
		String param14=request.getParameter("param14");
		String param15=request.getParameter("param15");
		
		/*end*/
		
		//Saritha
		System.out.println("QuestionnaireReportName   : "+QuestionnaireReportName);
		String POL_NO=request.getParameter("POL_NO");
		System.out.println("REport servlet pol_sys_id   :"+POL_NO);
		String NETAMT  =request.getParameter("NETAMT");
		System.out.println("REport servlet NETAMT:"+ NETAMT);
		String Charge  =request.getParameter("Charge");
		System.out.println("REport servlet Charge:"+ Charge);
		String INTEREST =request.getParameter("INTEREST");
		System.out.println("INTEREST:"+ INTEREST);
		String PREMIUMDUE =request.getParameter("PREMIUMDUE");
        System.out.println("PREMIUMDUE   ::"+PREMIUMDUE);
		/*String date =request.getParameter("date");
		System.out.println("DATE:"+ date);*/
		String reportType=request.getParameter("ReportType");		
		System.out.println("QuotationReport    "+reportType);
		System.out.println("QuestionnaireReportName   : "+QuestionnaireReportName);
		String DEP_REF_NO = request.getParameter("DEP_REF_NO");
		String DEP_DOC_NO =((String) session.getAttribute("DEP_DOC_NO")!=null)?(String) session.getAttribute("DEP_DOC_NO"):"";//getting the value which is already assigned in PILT016A_APAC_PT_IL_DEPOSIT_DELEGATE in session.
		System.out.println("DEP_DOC_NO--->["+DEP_DOC_NO+"]");
		String SMV_POL_NO=request.getParameter("SMV_POL_NO");
		String SURRENDER_PAID_TYPE=request.getParameter("SURRENDER_PAID_TYPE");
		
		////added by krithika on 25-03-2016
		String POL_STATUS = request.getParameter("POL_STATUS");		
		String POL_SYS_ID = request.getParameter("POL_SYS_ID");
		//SARITHA
		System.out.println("REport servlet POL_SYS_ID  :"+POL_SYS_ID);
		String endo_number=request.getParameter("endo_number");
		
		String PolicyScheduleReport=request.getParameter("PolicyScheduleReport");
		String SCHEDULE_REPORT_TYPE=request.getParameter("SCHEDULE_REPORT_TYPE");
		String ReportName=request.getParameter("REPORT_TYPE");
		String Paymentslipagent=request.getParameter("Paymentslipagent");
		/*ADDED BY KRITHIKA ON 17-4-15*/
		String EndormentScheduleReport=request.getParameter("EndormentScheduleReport");
		
		//added by agalya 12/07/2016
		String RenewalPremium=request.getParameter("RenewalPremium");
		String PC_REF_NO= request.getParameter("PC_REF_NO");
		String PC_DRCR_DOC_NO = request.getParameter("PC_DRCR_DOC_NO");	
		String PC_DRCR_DOC_DT = request.getParameter("PC_DRCR_DOC_DT");	
		//END
		System.out.println("PolicyScheduleReport"+PolicyScheduleReport);
		System.out.println("SCHEDULE_REPORT_TYPE"+SCHEDULE_REPORT_TYPE);
		

		//Added by 
		String  LOAN_POL_SYS_ID = request.getParameter("LOAN_POL_SYS_ID");
		System.out.println("LOAN_POL_SYS_ID"+request.getParameter("LOAN_POL_SYS_ID"));
		String LOANREVIEWSHEET = request.getParameter("LOANREVIEWSHEET");
		System.out.println("LOANREVIEWSHEET"+request.getParameter("LOANREVIEWSHEET"));

		//added by krithika for report binding on 29042016
		String QuotationReviewsheetReport=request.getParameter("QuotationReviewsheetReport");
		String GeneralEndromentReport=request.getParameter("GeneralEndromentReport");
		String ReviewsheetScheduleReport=request.getParameter("ReviewsheetScheduleReport");
		String PolicyScheduleArabic=request.getParameter("PolicyScheduleArabic");
		System.out.println("PolicyScheduleArabic==========>"+PolicyScheduleArabic);
		//Added by Ameen for Quotation Letter FALCONQC-1716555 
		String Quotation_Letter = request.getParameter("Quotation_Letter");
		String Quotation_PROD_CODE = request.getParameter("PROD_CODE");
		String PTDACover = request.getParameter("PTDACover");
		String PTDSCover = request.getParameter("PTDSCover");
		String PPDCover = request.getParameter("PPDCover");
		String PWRCover = request.getParameter("PWRCover");
		String POL_MOP = request.getParameter("POL_MOP");
		String prod_value =  request.getParameter("prod_value");
		String MED_FLAG = request.getParameter("MED_FLAG");
		System.out.println("quotation_letter ==>>"+Quotation_Letter+"::quotation_PROD_CODE==>>"+Quotation_PROD_CODE+"::PTDCover ==>"+PTDACover+
							"::PPDCover==>>"+PPDCover+"::POL_MOP==>"+POL_MOP+"::prod_value==>>"+prod_value+"::PTDSCover==>>"+PTDSCover);
		//end Quotation Letter
//added by krithika on 2405216
		String SURRENDERREPORT = request.getParameter("SURRENDERREPORT");
		
		
		
		
		/*Added By Saritha 25.5.2016*/
		
		String SURRENDERREVIWSHEET=request.getParameter("SURRENDERREVIWSHEET");
		String PAIDUPREVIWSHEET=request.getParameter("PAIDUPREVIWSHEET");
		String Flag_Status=request.getParameter("Flag_Status");
		
		/*End*/
		//added by agalya on 03-06-2016
		String PolicyScheduleSubReport = request.getParameter("PolicyScheduleSubReport");
		String val = request.getParameter("DS_TYPE");
		//added by agalya for loan argeement
		String QuotationForLoan = request.getParameter("QuotationForLoan");
		String LoanAgreement = request.getParameter("LoanAgreement");
		//end 
		int endoNumberInt=0;
		
		String Quot_report_type=request.getParameter("QQUICK_REPORT_TYPE");
		String QUOT_IDX_NO=request.getParameter("QUOT_IDX_NO");
		String QUOT_SYS_ID=request.getParameter("QUOT_SYS_ID");
		String QUOT_PROD_CODE=request.getParameter("QUOT_PROD_CODE");//QUICK_QUOTE_PROD
		String QUOT_NO=request.getParameter("QUOT_NO");
		String COMMVALUE=request.getParameter("COMMVALUE");
		String QUOT_VALUE=request.getParameter("QUOT_VALUE");
		System.out.println("quot value in report--->"+QUOT_VALUE );
		System.out.println("Quotation letter type ***************"+Quot_report_type);
		if(Quot_report_type!=null){
			if(Quot_report_type.equals("1")){
				System.out.println("inside 1");
				//String POL_SYS_ID=request.getParameter("POL_SYS_ID");
				String strurl="http://"+resourceBundle.getString("IP_address")+":"+resourceBundle.getString("port")+"/FalconIL/PremiaJasperPrint?JasperReportName=munichre_review_slip"+"&QUOT_IDX_NO="+QUOT_IDX_NO+"&QUOT_SYS_ID="+QUOT_SYS_ID+"&QUOT_PROD_CODE="+QUOT_PROD_CODE+"&COMMVALUE="+COMMVALUE+"&QUOT_VALUE="+QUOT_VALUE; 
				System.out.println("Reportservlet url   : "+strurl);
				RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?POL_SYS_ID="+POL_SYS_ID);  
		        rd.forward(request, response); 
			}
			if(Quot_report_type.equals("2")){
				System.out.println("inside 2 COVER *******");
				//String QUOT_NO=request.getParameter("QUOT_NO");
				//String QUOT_IDX_NO=request.getParameter("QUOT_IDX_NO");
				String strurl="http://"+resourceBundle.getString("IP_address")+":"+resourceBundle.getString("port")+"/FalconIL/PremiaJasperPrint?JasperReportName=cover_confirmation"+"&QUOT_NO="+QUOT_NO+"&QUOT_IDX_NO="+QUOT_IDX_NO+"&QUOT_PROD_CODE="+QUOT_PROD_CODE; 
				System.out.println("Reportservlet url   : "+strurl);
				RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?POL_SYS_ID="+POL_SYS_ID);  
		        rd.forward(request, response); 
			}
			if(Quot_report_type.equals("3")){
				System.out.println("inside 3");
				//FOR COVER CODE DESC.
				String ptdaCover=request.getParameter("ptdaCover");
				String ptdsCover=request.getParameter("ptdsCover");
				String ppdCover=request.getParameter("ppdCover");
				String QUOT_MOP=request.getParameter("QUOT_MOP");
				String strurl="http://"+resourceBundle.getString("IP_address")+":"+resourceBundle.getString("port")+"/FalconIL/PremiaJasperPrint?JasperReportName=quotation letter"+"&QUOT_NO="+QUOT_NO+"&QUOT_IDX_NO="+QUOT_IDX_NO+"&QUOT_PROD_CODE="+QUOT_PROD_CODE+"&QUOT_MOP="+QUOT_MOP+"&ptdaCover="+ptdaCover+"&ppdCover="+ppdCover+"&ptdsCover="+ptdsCover; 
				System.out.println("Reportservlet url   : "+strurl);
				RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?POL_SYS_ID="+POL_SYS_ID);  
		        rd.forward(request, response); 
			}
			if(Quot_report_type.equals("4")){//MUNICHRE COVER
				System.out.println("inside 4 COVER *******");
				//String QUOT_NO=request.getParameter("QUOT_NO");
				//String QUOT_IDX_NO=request.getParameter("QUOT_IDX_NO");
				String strurl="http://"+resourceBundle.getString("IP_address")+":"+resourceBundle.getString("port")+"/FalconIL/PremiaJasperPrint?JasperReportName=cover_confirmation"+"&QUOT_NO="+QUOT_NO+"&QUOT_IDX_NO="+QUOT_IDX_NO+"&QUOT_PROD_CODE="+QUOT_PROD_CODE; 
				System.out.println("Reportservlet url   : "+strurl);
				RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?POL_SYS_ID="+POL_SYS_ID);  
		        rd.forward(request, response); 
			}
			if(Quot_report_type.equals("5")){//MUNICHRE QUOTATION
				System.out.println("inside 5 QTN");
				//FOR COVER CODE DESC.
				String ptdaCover=request.getParameter("ptdaCover");
				String ptdsCover=request.getParameter("ptdsCover");
				String ppdCover=request.getParameter("ppdCover");
				String pwrcover=request.getParameter("pwrcover");
				String strurl="http://"+resourceBundle.getString("IP_address")+":"+resourceBundle.getString("port")+"/FalconIL/PremiaJasperPrint?JasperReportName=quotation letter"+"&QUOT_NO="+QUOT_NO+"&QUOT_IDX_NO="+QUOT_IDX_NO+"&ptdCover="+ptdaCover+"&ppdaCover="+ppdCover+"&pwrcover="+pwrcover+"&ptdsCover="+ptdsCover; 
				System.out.println("Reportservlet url   : "+strurl);
				RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?POL_SYS_ID="+POL_SYS_ID);  
		        rd.forward(request, response); 
			}
		}
		
		/*END*/
		

		/*String RevivalReport=" ";
		if(endo_number!=null){
			 endoNumberInt=Integer.parseInt(endo_number);
			RevivalReport=(request.getParameter("RevivalReportName")!=null)?request.getParameter("RevivalReportName"):"";
		
		}*/
		else if(PolicyScheduleReport!=null)
		{   //edited by agalya for policy schedule on 24-05-2016
			System.out.println("enter into PolicyScheduleReport");
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?PolicyScheduleReport="+PolicyScheduleReport+"&SCHEDULE_REPORT_TYPE="
			          +SCHEDULE_REPORT_TYPE +"&POL_SYS_ID="+POL_SYS_ID+"&Flag_Status="+Flag_Status+"&param0="+param0+"&param1="+param1+
                      "&param2="+param2+"&param3="+param3+"&param4="+param4+"&param5="+param5+"&param6="+param6+"&param7="+param7+
                      "&param8="+param8+"&param9="+param9+"&param10="+param10+"&param11="
                      +param11+"&param12="+param12+"&param13="+param13+"&param14="+param14+"&param15="+param15); 
			rd.forward(request, response);
		}
		/*Added by Ram on 21/12/2016 for Debit Note Report Development*/
		else if(SCHEDULE_REPORT_TYPE != null && SCHEDULE_REPORT_TYPE.equals("Debit Note"))
		{
			System.out.println("Welcome to SCHEDULE_REPORT_TYPE      "+SCHEDULE_REPORT_TYPE);
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?SCHEDULE_REPORT_TYPE="
			          +SCHEDULE_REPORT_TYPE +"&POL_SYS_ID="+POL_SYS_ID+"&Flag_Status="+Flag_Status);
			rd.forward(request, response);
		}
		/*End*/
		
		/*Added by Ram on 28/12/2016 for Credit Note Report Development*/
		else if(SCHEDULE_REPORT_TYPE != null && SCHEDULE_REPORT_TYPE.equals("Credit Note"))
		{
			System.out.println("Welcome to SCHEDULE_REPORT_TYPE      "+SCHEDULE_REPORT_TYPE);
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?SCHEDULE_REPORT_TYPE="
			          +SCHEDULE_REPORT_TYPE +"&POL_SYS_ID="+POL_SYS_ID+"&Flag_Status="+Flag_Status);
			rd.forward(request, response);
		}
		/*End*/
		
		/*Added by Ram on 26/12/2016 for Proposal Decline Letter Report Development*/
		else if(SCHEDULE_REPORT_TYPE != null && SCHEDULE_REPORT_TYPE.equals("Proposal Decline Letter"))
		{
			System.out.println("Welcome to SCHEDULE_REPORT_TYPE      "+SCHEDULE_REPORT_TYPE);
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?SCHEDULE_REPORT_TYPE="
			          +SCHEDULE_REPORT_TYPE +"&POL_SYS_ID="+POL_SYS_ID+"&Flag_Status="+Flag_Status);
			rd.forward(request, response);
		}
		/*End*/
		/*ADDED BY KRITHIKA ON 17-4-15*/
		else if(EndormentScheduleReport!=null)
		{
			System.out.println("enter into EndormentScheduleReport");
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?EndormentScheduleReport="+EndormentScheduleReport+"&POL_SYS_ID="+POL_SYS_ID +"&POL_SYS_ID="+POL_SYS_ID);  
			rd.forward(request, response);
		}else if(SURRENDERREPORT!=null)
		{
			System.out.println("enter into EndormentScheduleReport");
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?SURRENDERREPORT="+SURRENDERREPORT+"&POL_SYS_ID="+SMV_POL_NO);  
			rd.forward(request, response);
		
}
		//added by agalya for loan agreement
		
		
		
		
		else if(PolicyScheduleArabic!=null)
		{
			System.out.println("enter into EndormentScheduleReport");
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?PolicyScheduleArabic="+PolicyScheduleArabic);  
			rd.forward(request, response);
		
}
		else if(LoanAgreement!=null)
		{
			System.out.println("enter into LoanAgreement");
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?LoanAgreement="+LoanAgreement+"&POL_SYS_ID="+POL_SYS_ID);  
			rd.forward(request, response);
		
}
		else if(QuotationForLoan!=null)
		{
			System.out.println("enter into QuotationForLoan");
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?QuotationForLoan="+QuotationForLoan+"&POL_SYS_ID="+POL_SYS_ID);  
			rd.forward(request, response);
		
}
		//end
		
		
		
		//added by krithika for empty report binding on 29042016
		else if(QuotationReviewsheetReport!=null)
		{
			System.out.println("enter into EndormentScheduleReport");
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?QuotationReviewsheetReport="+QuotationReviewsheetReport+"&POL_SYS_ID="+POL_SYS_ID );  
			rd.forward(request, response);
		}	
		//added by agalya for policy schedule subreport on 03-06-2016
		else if(PolicyScheduleSubReport!=null)
		{
			System.out.println("enter into EndormentScheduleReport");
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?PolicyScheduleSubReport="+PolicyScheduleSubReport+"&POL_SYS_ID="+POL_SYS_ID+"&DS_TYPE="+val);  
			rd.forward(request, response);
		}
		else if(GeneralEndromentReport!=null)
		{
			System.out.println("enter into EndormentScheduleReport");
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?GeneralEndromentReport="+GeneralEndromentReport+"&POL_SYS_ID="+POL_SYS_ID );  
			rd.forward(request, response);
		}
		else if(Paymentslipagent!=null)
		{
			System.out.println("enter into EndormentScheduleReport");
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?Paymentslipagent="+Paymentslipagent+"&POL_SYS_ID="+POL_SYS_ID);  
			rd.forward(request, response);
		}
		//added by agalya 12/07/2016
		else if(RenewalPremium!=null)
		{
			System.out.println("enter into RenewalPremiumReport");
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?RenewalPremium="+RenewalPremium+"&PC_REF_NO="+PC_REF_NO+"&PC_DRCR_DOC_NO="+PC_DRCR_DOC_NO+"&PC_DRCR_DOC_DT="+PC_DRCR_DOC_DT);  
			rd.forward(request, response);
		}
		//end
		
		else if(ReviewsheetScheduleReport!=null)
		{
			System.out.println("enter into EndormentScheduleReport");
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?ReviewsheetScheduleReport="+ReviewsheetScheduleReport+"&POL_SYS_ID="+POL_SYS_ID +"&POL_SYS_ID="+POL_SYS_ID);  
			rd.forward(request, response);
		}
		//ADDED BY AMEEN 17-8-2016 FOR QUOTATION LETTER IN PROPOSAL LEVEL FALCONQC-1716555 
		else if(Quotation_Letter!=null){ 
		if(Quotation_Letter.equalsIgnoreCase("Quotation Letter"))
		{
			System.out.println("enter into EndormentScheduleReport");
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?Quotation_Letter="+Quotation_Letter+"&POL_SYS_ID="+POL_SYS_ID+"&PROD_CODE="+Quotation_PROD_CODE+"&PTDACover="+PTDACover+"&PPDCover="+PPDCover+"&POL_MOP="+POL_MOP+"&PWRCover="+PWRCover+"&MED_FLAG="+MED_FLAG+"&PTDSCover="+PTDSCover);  
			rd.forward(request, response);
		}
		if(Quotation_Letter.equalsIgnoreCase("Acceptance Letter"))
		{
			System.out.println("enter into EndormentScheduleReport");
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?Quotation_Letter="+Quotation_Letter+"&POL_SYS_ID="+POL_SYS_ID+"&PROD_CODE="+Quotation_PROD_CODE);  
			rd.forward(request, response);
		}
		}
		//END QUOTATION LETTER
		else if(ReportName!=null){
			System.out.println("Inside report servlet of quotation review sheet");
			String strurl="http://"+resourceBundle.getString("IP_address")+":"+resourceBundle.getString("port")+"/FalconIL/PremiaJasperPrint?JasperReportName="+"LifeAssMaturityDischarge"+"&JasperPolSysId="+JasperPolSysId; 
			
			System.out.println("Reportservlet url   : "+strurl);
		
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?POL_SYS_ID="+POL_SYS_ID);  
	        rd.forward(request, response); 
			
			/*response.sendRedirect(strurl);	*/
			
		}
		/*END*/
		else if(SURRENDER_PAID_TYPE!=null)
		{
			
				RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?SURRENDER_PAID_TYPE="+SURRENDER_PAID_TYPE+"&SMV_POL_NO="+SMV_POL_NO);  
				rd.forward(request, response);
			
		}
		else if(SURRENDERREVIWSHEET!=null)
		{
			
				RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?SURRENDERREVIWSHEET="+SURRENDERREVIWSHEET+"&SMV_POL_NO="+SMV_POL_NO);  
				rd.forward(request, response);
				
				//END
		}else if(PAIDUPREVIWSHEET!=null)
				{
					
						RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?PAIDUPREVIWSHEET="+PAIDUPREVIWSHEET+"&SMV_POL_NO="+SMV_POL_NO);  
						rd.forward(request, response);
		}	//ADDED BY SARANYA for revival quotation
		else if(reportType!=null){
			System.out.println("ENTER THE QuestionnaireReportName IF BLOCK");
			System.out.println("POL_NO"+POL_NO);
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?POL_NO="+POL_NO+"&NETAMT="+NETAMT+"&INTEREST="+INTEREST+"&PREMIUMDUE="+PREMIUMDUE+"&Charge="+Charge);  
			//RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?POL_NO="+POL_NO+"&INTEREST="+INTEREST+"&NETAMT="+NETAMT+"&SCHEDULE="+SCHEDULE);
	        rd.forward(request, response); 
			
			/*response.sendRedirect(strurl);	*/
		}
		//END
		else if(DEP_REF_NO!=null){
			System.out.println("ENTER DEP_REF_NO BLOCK");
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?DEP_REF_NO="+DEP_REF_NO+"&DEP_DOC_NO="+DEP_DOC_NO);  
	        rd.forward(request, response);
		}else if(QuestionnaireReportName!=null){
			System.out.println("QuestionnaireReportName IF BLOCK");
			
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?QuestionnaireReportName="+QuestionnaireReportName+"&POL_SYS_ID="+POL_SYS_ID);  
	        rd.forward(request, response); 
			
		}else if(JasperReportName!=null){
			String strurl="http://"+resourceBundle.getString("IP_address")+":"+resourceBundle.getString("port")+"/FalconIL/PremiaJasperPrint?JasperReportName="+"LifeAssMaturityDischarge"+"&JasperPolSysId="+JasperPolSysId; 
			
			System.out.println("Reportservlet url   : "+strurl);
		
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?JasperReportName="+JasperReportName+"&JasperPolSysId="+JasperPolSysId);  
	        rd.forward(request, response); 
			
			/*response.sendRedirect(strurl);	*/
			
		}
		//added by saranya for revival
		else if(RevivalReportName!=null)
		{
			System.out.println("enter into revial quotation report servlet");

			// RequestDispatcher
			// rd=request.getRequestDispatcher("PremiaJasperPrint?POL_STATUS="+POL_STATUS+"&POL_NO="+POL_NO+"&POL_SYS_ID="+POL_SYS_ID);
			RequestDispatcher rd = request
					.getRequestDispatcher("/PremiaJasperPrint?"+"&POL_STATUS="+POL_STATUS+"&POL_SYS_ID="+POL_SYS_ID);
			System.out.println("report servlet file path" + rd);
			rd.forward(request, response);
		}
		//*end*//
	//added by gopinath for loan review sheet
		else if(LOANREVIEWSHEET!=null)
		{
			try {
			System.out.println("Enter the  LOANREVIEWSHEET if Block ");
				
				call_P_PROC_IL_LOAN_REVIEW(LOAN_POL_SYS_ID,con);
				RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?LOANREVIEWSHEET="+LOANREVIEWSHEET);  
				rd.forward(request, response);
			
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		else if(REP_Name!=null)
		{
			System.out.println("REP_Name    : "+REP_Name);
			System.out.println("REP_ID      : "+REP_ID);
			if (REP_ID.equalsIgnoreCase("P11_PILS_001")) 
			{
				//response.sendRedirect("http://"+resourceBundle.getString("IP_address")+":"+resourceBundle.getString("port")+"/IndividualLife_JaperReport/PremiaJasperPrint?Pol_sys_id="+Pol_sys_id+"&REP_ID="+REP_ID+"&REP_Name="+REP_Name);	
			
				RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?Pol_sys_id="+Pol_sys_id+"&REP_ID="+REP_ID+"&REP_Name="+REP_Name);  
		        rd.forward(request, response); 
			}else if (REP_ID.equalsIgnoreCase("PILR_LET_FN")) {
				//response.sendRedirect("http://"+resourceBundle.getString("IP_address")+":"+resourceBundle.getString("port")+"/IndividualLife_JaperReport/PremiaJasperPrint?Pol_sys_id="+Pol_sys_id+"&REP_ID="+REP_ID);
				RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?Pol_sys_id="+Pol_sys_id+"&REP_ID="+REP_ID);  
		        rd.forward(request, response); 
			
			}
				
			else {
				//response.sendRedirect("http://"+resourceBundle.getString("IP_address")+":"+resourceBundle.getString("port")+"/IndividualLife_JaperReport/PremiaJasperPrint?Pol_sys_id="+Pol_sys_id+"&REP_ID="+REP_ID);
				RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?Pol_sys_id="+Pol_sys_id+"&REP_ID="+REP_ID);  
		        rd.forward(request, response); 
			}


		}/*Added by Jagadeesh*/
		
		else if(REP_ID !=null)
		{
			
			System.out.println("ENTERS INTO REP_ID !=null");
			
			
			
		 if (REP_ID.equalsIgnoreCase("P11_PILR_002")) 
		{
			
			System.out.println("ENTERS INTO P11_PILR_002");
			
			//response.sendRedirect("http://"+resourceBundle.getString("IP_address")+":"+resourceBundle.getString("port")+"/IndividualLife_JaperReport/PremiaJasperPrint?Pol_sys_id="+Pol_sys_id+"&REP_ID="+REP_ID+"&REP_Name="+REP_Name);	
		/*Premium Due Remainder*/
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?REP_ID="+REP_ID+"&REP_KEY="+REP_KEY);  
	        rd.forward(request, response); 
		}else if (REP_ID.equalsIgnoreCase("P11_PILR_029")) {
			
			System.out.println("ENTERS INTO P11_PILR_029");
			
			//response.sendRedirect("http://"+resourceBundle.getString("IP_address")+":"+resourceBundle.getString("port")+"/IndividualLife_JaperReport/PremiaJasperPrint?Pol_sys_id="+Pol_sys_id+"&REP_ID="+REP_ID);
		/*Lapse letter*/
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?REP_ID="+REP_ID+"&REP_KEY="+REP_KEY);  
	        rd.forward(request, response); 
		
		}
		 //ADDED BY SARANYA
      else if (REP_ID.equalsIgnoreCase("P11_PILR_006")) {
			
			System.out.println("ENTERS INTO P11_PILR_006");
            RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?REP_ID="+REP_ID+"&REP_KEY="+REP_KEY);  
	        rd.forward(request, response); 
		
		} else if (REP_ID.equalsIgnoreCase("P11_PILR_003")) {
			
			System.out.println("ENTERS INTO P11_PILR_003");
            RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?REP_ID="+REP_ID+"&REP_KEY="+REP_KEY);  
	        rd.forward(request, response); 
		
		}
		 //END
		else if (REP_ID.equalsIgnoreCase("P11_PILR_030")){
			
			System.out.println("ENTERS INTO P11_PILR_030");
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?REP_ID="+REP_ID+"&REP_KEY="+REP_KEY);   
	        rd.forward(request, response); 
		}
		 /*Added By Saritha 21.3.2016*/
		else if (REP_ID.equalsIgnoreCase("P11_PILR_031")){		
			System.out.println("ENTERS INTO P11_PILR_031");
			
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?REP_ID="+REP_ID+"&REP_KEY="+REP_KEY);   
			rd.forward(request, response); 
			 } /*End*/	
		 /*added by raja on 18.3.2016*/
		 
		 //added by gopi for Maturity notice on 27-05-2016
		else if(REP_ID.equalsIgnoreCase("P11_PILR_23A"))
		{
			
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?REP_ID="+REP_ID+"&REP_KEY="+REP_KEY); 
 
			rd.forward(request, response); 	
		}
		else if (REP_ID.equalsIgnoreCase("P11_PILR_032")){
			
			System.out.println("ENTERS INTO P11_PILR_032");
			
			//response.sendRedirect("http://"+resourceBundle.getString("IP_address")+":"+resourceBundle.getString("port")+"/IndividualLife_JaperReport/PremiaJasperPrint?Pol_sys_id="+Pol_sys_id+"&REP_ID="+REP_ID);
		/*Maturity Remainder*/
			RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?REP_ID="+REP_ID+"&REP_KEY="+REP_KEY);   
	        rd.forward(request, response); 
		}else if(REP_ID.equalsIgnoreCase("P11_PILR_025")){
			System.out.println("sound REP_ID.equalsIgnoreCase(");
			try {
				INPUT_BEAN ip= new INPUT_BEAN();
				ip =select1(request.getParameter("repId"),request.getParameter("rKeyNo"),con);
				String RepID=request.getParameter("repId");
				String RepKeyNo=request.getParameter("rKeyNo");
				String P_DATE_FM= ip.getREP_VALUE_1();
				String P_DATE_TO= ip.getREP_VALUE_2();
				String P_DIVN_FM= ip.getREP_VALUE_3();
				String P_DIVN_TO= ip.getREP_VALUE_4();
				String P_DEPT_FM= ip.getREP_VALUE_5();
				String P_DEPT_TO= ip.getREP_VALUE_6();
				String P_PLAN_CODE_FM= ip.getREP_VALUE_7();
				String P_PLAN_CODE_TO= ip.getREP_VALUE_8();
				String P_CLASS_CODE_FM= ip.getREP_VALUE_9();
				String P_CLASS_CODE_TO= ip.getREP_VALUE_10();
						String seqno=callResetProc(P_DIVN_FM, P_DIVN_TO, P_DEPT_FM,
						 P_DEPT_TO,P_PLAN_CODE_FM, P_PLAN_CODE_TO,
						 P_DATE_FM,P_DATE_TO, P_CLASS_CODE_FM,
						 P_CLASS_CODE_TO,con);
						insert(seqno,RepKeyNo,con,RepID);			
			
				/*Modifed by Ram on 28/12/2016
				 * 
				 * response.sendRedirect("http://"+resourceBundle.getString("IP_address")+":"+resourceBundle.getString("port")+"/PREMIA_REPORT/IntegratePremiaReport?REP_ID="+resourceBundle.getString(request.getParameter("repId"))+"&REP_GL_ID="+request.getParameter("repId")+"&REP_SEQ_ID="+request.getParameter("rKeyNo")+"&seqno="+seqno);*/
						response.sendRedirect("http://"+resourceBundle.getString("IP_address")+":"+resourceBundle.getString("port")+"/"
				+resourceBundle.getString("PREMIA_REPORT_NAME")+"/IntegratePremiaReport?REP_ID="+resourceBundle.getString(request.getParameter("repId"))+"&REP_GL_ID="+request.getParameter("repId")+"&REP_SEQ_ID="+request.getParameter("rKeyNo")+"&seqno="+seqno);
						/*End*/
						
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(REP_ID.equalsIgnoreCase("P11_PILR_035")){System.out.println(" P11_PILR_035 REP_ID.equalsIgnoreCase(");
		try {
			
			INPUT_BEAN ip= new INPUT_BEAN();
			ip =select1(request.getParameter("repId"),request.getParameter("rKeyNo"),con);
			String RepID=request.getParameter("repId");
			String RepKeyNo=request.getParameter("rKeyNo");
			String P_PRODUCT_FM= ip.getREP_VALUE_1();
			String P_PRODUCT_TO= ip.getREP_VALUE_2();
			String P_DIVN_FM= ip.getREP_VALUE_3();
			String P_DIVN_TO= ip.getREP_VALUE_4();
			String P_DATE_FM= ip.getREP_VALUE_5();
			String P_DATE_TO= ip.getREP_VALUE_6();
			String P_AGENT_CODE_FM= ip.getREP_VALUE_7();
			String P_AGENT_CODE_TO= ip.getREP_VALUE_8();
			String P_RI_CODE_FM= ip.getREP_VALUE_9();
			String P_RI_CODE_TO= ip.getREP_VALUE_10();
				
					String seqno=callPW_INS_REN_COMM1(P_PRODUCT_FM, P_PRODUCT_TO, P_DIVN_FM,
						P_DIVN_TO,P_DATE_FM, P_DATE_TO,
						P_AGENT_CODE_FM,P_AGENT_CODE_TO, P_RI_CODE_FM,
						P_RI_CODE_TO,con);
					insert(seqno,RepKeyNo,con,RepID);	
			/*Modifed by Ram on 28/12/2016
			 * 
			 * response.sendRedirect("http://"+resourceBundle.getString("IP_address")+":"+resourceBundle.getString("port")+"/PREMIA_REPORT/IntegratePremiaReport?REP_ID="+resourceBundle.getString(request.getParameter("repId"))+"&REP_GL_ID="+request.getParameter("repId")+"&REP_SEQ_ID="+request.getParameter("rKeyNo")+"&seqno="+seqno);*/
					response.sendRedirect("http://"+resourceBundle.getString("IP_address")+":"+resourceBundle.getString("port")
							+"/"+resourceBundle.getString("PREMIA_REPORT_NAME")+"/IntegratePremiaReport?REP_ID="+resourceBundle.getString(request.getParameter("repId"))+"&REP_GL_ID="+request.getParameter("repId")+"&REP_SEQ_ID="+request.getParameter("rKeyNo")+"&seqno="+seqno);
					/*End*/
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		}else if(REP_ID.equalsIgnoreCase("P11_PILR_036"))
		{
			System.out.println(" P11_PILR_035 REP_ID.equalsIgnoreCase(");
			try {


				response.sendRedirect("PremiaJasperPrint?REP_ID="+REP_ID+"&REP_KEY="+REP_KEY);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		//ADDED BY SANKAR FOR QUOTATION REGISTER ON 21-07-2016
				else if("P11_PILR_033".equalsIgnoreCase(REP_ID))
				{
					System.out.println(" P11_PILR_033 REP_ID.equalsIgnoreCase(");
					try {

/*response.sendRedirect("http://"+resourceBundle.getString("IP_address")+":"+resourceBundle.getString("port")+"/PREMIA_REPORT/IntegratePremiaReport?REP_ID="+resourceBundle.getString(request.getParameter("repId"))+"&REP_GL_ID="+request.getParameter("repId")+"&REP_SEQ_ID="+request.getParameter("rKeyNo"));*/
						
						/*Modified by Ram on 28/1/2016*/
						response.sendRedirect("http://"+resourceBundle.getString("IP_address")+":"+resourceBundle.getString("port")
								+"/"+resourceBundle.getString("PREMIA_REPORT_NAME")+"/IntegratePremiaReport?REP_ID="+resourceBundle.getString(request.getParameter("repId"))+"&REP_GL_ID="+request.getParameter("repId")+"&REP_SEQ_ID="+request.getParameter("rKeyNo"));
						/*End*/
						//response.sendRedirect("PremiaJasperPrint?REP_ID="+REP_ID+"&REP_KEY="+REP_KEY);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}//END
		 
		 /*ADDED BY Saranya FOR BONUS CERTIFICATE ssp call id FALCONQC-1716094*/
			      else if ("P11_PILR_012".equalsIgnoreCase(REP_ID)) {
						
			    	  INPUT_BEAN ip= new INPUT_BEAN();
						
					
						try {
							ip =select1(request.getParameter("repId"),request.getParameter("rKeyNo"),con);
							String RepID=request.getParameter("repId");
							String RepKeyNo=request.getParameter("rKeyNo");
							String P_PRODUCT_FM= ip.getREP_VALUE_1();
							String P_PRODUCT_TO= ip.getREP_VALUE_2();
							String POLNO_FM= ip.getREP_VALUE_3();
							String POLNO_TO= ip.getREP_VALUE_4();
							String AS_OF_DT= ip.getREP_VALUE_5();
							BONUS_CERTIFICATE(P_PRODUCT_FM, P_PRODUCT_TO, POLNO_FM,
									POLNO_TO,AS_OF_DT,con);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
			            RequestDispatcher rd=request.getRequestDispatcher("PremiaJasperPrint?REP_ID="+REP_ID+"&REP_KEY="+REP_KEY);  
				        rd.forward(request, response); 
					   
					}
					 //END
		 
		 
		 
		else
		{
			System.out.println("ENTERS INTO P11_PILR_001");
			System.out.println("URL   : "+"http://"+resourceBundle.getString("IP_address")+":"+resourceBundle.getString("port")+"/PREMIA_REPORT/IntegratePremiaReport?REP_ID="+resourceBundle.getString(request.getParameter("repId"))+"&REP_GL_ID="+request.getParameter("repId")+"&REP_SEQ_ID="+request.getParameter("rKeyNo"));
			
			/*Modified by Ram on 28/12/2016
			 * 
			 * response.sendRedirect("http://"+resourceBundle.getString("IP_address")+":"+resourceBundle.getString("port")+"/PREMIA_REPORT/IntegratePremiaReport?REP_ID="+resourceBundle.getString(request.getParameter("repId"))+"&REP_GL_ID="+request.getParameter("repId")+"&REP_SEQ_ID="+request.getParameter("rKeyNo"));*/
			response.sendRedirect("http://"+resourceBundle.getString("IP_address")+":"+resourceBundle.getString("port")
					+"/"+resourceBundle.getString("PREMIA_REPORT_NAME")+"/IntegratePremiaReport?REP_ID="+resourceBundle.getString(request.getParameter("repId"))+"&REP_GL_ID="+request.getParameter("repId")+"&REP_SEQ_ID="+request.getParameter("rKeyNo"));
			/*End*/
		}
		 
		 /*end*/
		 
		}
		/*END*/
		else
		{
			System.out.println("ENTER ELSE PART ");
			/*Modifed by Ram on 28/12/2016
			 * 
			 * response.sendRedirect("http://"+resourceBundle.getString("IP_address")+":"+resourceBundle.getString("port")+"/PREMIA_REPORT/IntegratePremiaReport?REP_ID="+resourceBundle.getString(request.getParameter("repId"))+"&REP_GL_ID="+request.getParameter("repId")+"&REP_SEQ_ID="+request.getParameter("rKeyNo"));*/
			response.sendRedirect("http://"+resourceBundle.getString("IP_address")+":"+resourceBundle.getString("port")
					+"/"+resourceBundle.getString("PREMIA_REPORT_NAME")+"/IntegratePremiaReport?REP_ID="+resourceBundle.getString(request.getParameter("repId"))+"&REP_GL_ID="+request.getParameter("repId")+"&REP_SEQ_ID="+request.getParameter("rKeyNo"));
			/*End*/
		}


	}   
	
	/*end*/

	private void waitForReportFileCreation(String repId, String filePath) throws Exception{
		long oldSize = -1;
		long currentSize = -1;
		long time = new Date().getTime();
		long timeOut = time + 5000;
		int counter = 0;
		File file = new File(filePath);
		String message = null;

		try{
			message = "[Report-" + repId + "] Report creation in progress..";
			System.out.println(message);
			//throw new Exception("Test error page.");
			do{
				time = new Date().getTime();
				currentSize = file.length();

				if(time >= timeOut){
					message = "[Report-" + repId + "] Report timed out.";
					System.out.println(message);
					throw new Exception(message);
				}else if(currentSize == oldSize){
					counter++;
					if(counter == 3){
						message = "[Report-" + repId + "] Report created successfully.";
						System.out.println(message);
						break;
					}
				}else{
					message = "[Report-" + repId + "] Current size of the report is: " + currentSize + "b";
					System.out.println(message);
					oldSize = currentSize;
				}
				Thread.sleep(10);
			}while(true);
		} catch (InterruptedException e) {
			message = "[Report-" + repId + "] Could not generate report, process interrupted.";
			System.out.println(message);
			throw new Exception(message);
		}
	}

public String callResetProc(String P_DIVN_FM, String P_DIVN_TO, String P_DEPT_FM, String P_DEPT_TO,
		String P_PLAN_CODE_FM,String P_PLAN_CODE_TO, String P_DATE_FM, 
		String P_DATE_TO, String P_CLASS_CODE_FM, String P_CLASS_CODE_TO ,Connection con) throws Exception {    
String seqno="";

	try {
		String P_SEQ_NO="";

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_DIVN_FM);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_DIVN_TO);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_DEPT_FM);
		OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_DEPT_TO);
		OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_PLAN_CODE_FM);
		OracleParameter param6 = new OracleParameter("IN6", "DATE", "IN",P_PLAN_CODE_TO);
		OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_DATE_FM);
		OracleParameter param8 = new OracleParameter("IN8", "DATE", "IN",P_DATE_TO);
		OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_CLASS_CODE_FM);
		OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_CLASS_CODE_TO);
		OracleParameter param11 = new OracleParameter("OUT1", "STRING", "OUT",P_SEQ_NO);


    parameterList.add(param1);
    parameterList.add(param2);
    parameterList.add(param3);
    parameterList.add(param4);
    parameterList.add(param5);
    parameterList.add(param6);
    parameterList.add(param7);
    parameterList.add(param8);
    parameterList.add(param9);
    parameterList.add(param10);
    parameterList.add(param11);
    
    OracleProcedureHandler procHandler = new OracleProcedureHandler();
    outputList = procHandler.execute(parameterList, con,
            "P_IL_PREM_REG");
    Iterator<OracleParameter> iterator = outputList.iterator();
    while (iterator.hasNext()) {
        OracleParameter oracleParameter = iterator.next();
        seqno=oracleParameter.getValue();
    }
   
	} catch (DBException e) {
		e.printStackTrace();
	}
	
	return seqno;
}

public static INPUT_BEAN select1(String Rep_id,String Rep_key,Connection con)throws Exception{
	System.out.println("select 1"+Rep_id+","+Rep_key);
	System.out.println("entering into the register bean");
	INPUT_BEAN ip= new INPUT_BEAN();
	System.out.println("BEAN OBJECT"+ip);
	try {
		CRUDHandler handler = new CRUDHandler();			 
		String query = "SELECT * FROM IP_REP_INFO WHERE REP_ID= ? AND REP_KEY_NO= ?";
		ResultSet rs = handler.executeSelectStatement(query, con, new Object[]{Rep_id,Rep_key});
		while (rs.next()) {
			
			ip.setREP_VALUE_1(rs.getString("REP_VALUE_1"));
			ip.setREP_VALUE_2(rs.getString("REP_VALUE_2"));
			ip.setREP_VALUE_3(rs.getString("REP_VALUE_3"));
			ip.setREP_VALUE_4(rs.getString("REP_VALUE_4"));
			ip.setREP_VALUE_5(rs.getString("REP_VALUE_5"));
			ip.setREP_VALUE_6(rs.getString("REP_VALUE_6"));
			ip.setREP_VALUE_7(rs.getString("REP_VALUE_7"));
			ip.setREP_VALUE_8(rs.getString("REP_VALUE_8"));
			ip.setREP_VALUE_9(rs.getString("REP_VALUE_9"));
			ip.setREP_VALUE_10(rs.getString("REP_VALUE_10"));
		}
	
} catch (Exception e) {
	e.printStackTrace();

}
	return ip;
	
}
public  String insert( String seqno,String Rep_key,Connection con,String Rep_id)throws Exception{
	System.out.println("select 1"+seqno+","+Rep_key);
	System.out.println("entering into the insert bean");
	INPUT_BEAN ip= new INPUT_BEAN();
	System.out.println("BEAN OBJECT"+ip);
	
		System.out.println("inside insert try block");
		CRUDHandler handler = new CRUDHandler();			 
		String query = "UPDATE  IP_REP_INFO SET REP_VALUE_11='"+seqno+"' WHERE REP_KEY_NO= '"+Rep_key+"'"; 
		System.out.println("query exe sucess"+query);	     
		handler.executeUpdateStatement(query, con);
		System.out.println("value for insert"+	handler.executeUpdateStatement(query, con));
		con.commit();
	return "";
}
//added by gopinath
public void call_P_PROC_IL_LOAN_REVIEW(String LOAN_POL_SYS_ID,Connection con) throws Exception {    
	
	
	try {
		System.out.println("Enter the  call_P_PROC_IL_LOAN_REVIEW  Block ");
	ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
	ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
	OracleParameter param1 = new OracleParameter("IN1", "INT", "IN",LOAN_POL_SYS_ID);
	parameterList.add(param1);
    OracleProcedureHandler procHandler = new OracleProcedureHandler();
    outputList = procHandler.execute(parameterList, con,"P_PROC_IL_LOAN_REVIEW");
   	   
	} catch (DBException e) {
		e.printStackTrace();
	}
	finally
	{
		con.commit();
		System.out.println("***********  Connection commited successfully *********** ");
	}
	
	
}

public String callPW_INS_REN_COMM1(String P_PRODUCT_FM, String P_PRODUCT_TO, String P_DIVN_FM,
		String P_DIVN_TO, String P_DATE_FM, String P_DATE_TO, String P_AGENT_CODE_FM,
		String P_AGENT_CODE_TO, String P_RI_CODE_FM, String P_RI_CODE_TO ,Connection con) throws Exception {    
String seqno="";

	try {
		String P_SEQ_NO="";
	ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
	ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
	OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PRODUCT_FM);
	OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PRODUCT_TO);
	OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_DIVN_FM);
	OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_DIVN_TO);
	OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_DATE_FM);
	OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_DATE_TO);
	OracleParameter param7 = new OracleParameter("IN7", "DATE", "IN",P_AGENT_CODE_FM);
	OracleParameter param8 = new OracleParameter("IN8", "DATE", "IN",P_AGENT_CODE_TO);
	OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_RI_CODE_FM);
	OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_RI_CODE_TO);
	OracleParameter param11 = new OracleParameter("OUT1", "STRING", "OUT",P_SEQ_NO);
    parameterList.add(param1);
    parameterList.add(param2);
    parameterList.add(param3);
    parameterList.add(param4);
    parameterList.add(param5);
    parameterList.add(param6);
    parameterList.add(param7);
    parameterList.add(param8);
    parameterList.add(param9);
    parameterList.add(param10);
    parameterList.add(param11);
    
    OracleProcedureHandler procHandler = new OracleProcedureHandler();
    outputList = procHandler.execute(parameterList, con,
            "PW_INS_REN_COMM1");
    Iterator<OracleParameter> iterator = outputList.iterator();
    while (iterator.hasNext()) {
        OracleParameter oracleParameter = iterator.next();
        seqno=oracleParameter.getValue();
    }
   
	} catch (DBException e) {
		e.printStackTrace();
	}
	
	return seqno;
}

/*End*/

/*ADDED BY Saranya FOR BONUS CERTIFICATE ssp call id FALCONQC-1716094*/


public void BONUS_CERTIFICATE(String P_PROD_CODE_FM, String P_PROD_CODE_TO, String P_POL_NO_FM,
		String P_POL_NO_TO, String P_AS_ON_DT ,Connection con) throws Exception {    
String seqno="";

	try {
	
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PROD_CODE_FM);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PROD_CODE_TO);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_NO_FM);
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_POL_NO_TO);
		parameterList.add(param4);
		OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_AS_ON_DT);
		parameterList.add(param5);
    
    OracleProcedureHandler procHandler = new OracleProcedureHandler();
    outputList = procHandler.execute(parameterList, con,
            "BONUS_CERTIFICATE");
    con.commit();
   /* Iterator<OracleParameter> iterator = outputList.iterator();
    while (iterator.hasNext()) {
        OracleParameter oracleParameter = iterator.next();
        seqno=oracleParameter.getValue();
    }
   */
	} catch (DBException e) {
		e.printStackTrace();
	}
	
	
}






/*END*/


}