package com.iii.pel.jasperreports;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JExcelApiExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.ConnectionManager;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.apps.persistence.PremiaCryptograph;
import com.iii.apps.persistence.SimpleConnectionAgent;
import com.iii.premia.common.utils.CommonUtils;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfGState;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Servlet implementation class PREMIASchedule
 */
public class PREMIASchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Added by Ganesh on 16-03-2017 for claim mail sending with attachment as per Vinoth sugg.
	
		private final static ResourceBundle resourceBundleDatabase = ResourceBundle
				.getBundle("login");
		
		//end   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PREMIASchedule() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**writePolicyMovementReportExcel
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Get Method");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to POST Method");
		String REP_ID = request.getParameter("REP_ID");
		String REP_KEY_NO = request.getParameter("REP_KEY_NO");
		//Added by Ganesh on 16-03-2017 for claim mail sending with attachment as per Vinoth sugg.
				String viewType = request.getParameter("viewtype");
				//end
		
				/*Newly Added By Dhinesh on 22.03.2017*/		
				String ReportName = null;
				String excelPath = null;		
				/*End*/
				

				
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		
		System.out.println("REP_ID          "+REP_ID+" REP_KEY_NO     "+REP_KEY_NO);
		  
		List<String> paramList = new ArrayList<String>();
		
		Connection con = null;
		String clientId = null;
		byte[] ba1;
		HttpSession session=request.getSession();
		if(session != null){
			System.out.println("INSIDE SESSION IN Premia Schedule         ");
			System.out.println("clientId         :"+session.getAttribute("CLIENT_ID"));
			clientId = (String) session.getAttribute("CLIENT_ID");
			try {
				HashMap param = new HashMap();
				//Added by Ganesh on 16-03-2017 for claim mail sending with attachment as per Vinoth sugg
				/*
				 * Modified the connection object for mail purpose by ganesh
				 */
				if(clientId!=null){
					con = ((SimpleConnectionAgent) getServletContext()
							.getAttribute("connectionAgent")).getConnection(clientId);
					}else{
						con = getJDBCConnection();
					}
			
	    File jasperFilepath = null;
	    
		String query = "SELECT * FROM pm_rep_tab_hdr WHERE PMRTH_REP_ID = ?";
		ResultSet rs = new CRUDHandler().executeSelectStatement(query, con,new Object[]{REP_ID});
		String jasperReportName = null,connectionReqd = null, procedureReqd = null,reportType = null,reportCategory = null;
		/*added by gopi for excel write home path on 25/09/17*/
		String excelFileName = "ReportFile";
		//end
		/*Addded by Sivarajan on 04/02/2020 for Alliance IL*/
		 String multiReport = null;
		 String polSysId = null;
		 String relatedDoc = null;
		/*End*/
		while(rs.next())
		{
			jasperReportName = rs.getString("PMRTH_REP_TEMP_NAME_ID");
			relatedDoc = jasperReportName;
			connectionReqd = rs.getString("PMRTH_CONN_REQD");
			procedureReqd = rs.getString("PMRTH_PROC_REQD");
			reportType = rs.getString("PMRTH_REP_CATG");
			reportCategory = rs.getString("PMRTH_REPORT_CATG");
			
			
			/*Newly Added By Dhinesh on 22.03.2017*/
			ReportName = rs.getString("PMRTH_REP_NAME");
			/*End*/
			/*added by gopi for excelwrite in home patch on 25/09/17*/
			excelFileName =  rs.getString("PMRTH_REP_TEMP_NAME_ID");
			//end  excelwrite in home patch on 25/09/17 
			
			/*Added by Sivarajan on 04/02/2020 for Alliance IL*/
			multiReport = rs.getString("PMRTH_MULTI_REPORT");
			/*End*/
			
			
		}
		/*Added by ganesh on 29-08-2017 for fetch jasper from homepath with custom directory*/
		String url5 = System.getProperty("user.home");// modified by daisy for Agent Payout statement
		jasperReportName = url5+jasperReportName;
		/*end*/
		
		System.out.println("jasperReportName           "+jasperReportName);
		System.out.println("connectionReqd           "+connectionReqd);
		System.out.println("procedureReqd           "+procedureReqd);
		System.out.println("reportType           "+reportType);
		System.out.println("reportCategory           "+reportCategory);
		
		/*Added by ganesh on 17-08-2017 to fetch the jasper filename for save and attachment mail */
		
		//String downloadFileName = jasperReportName.substring(jasperReportName.lastIndexOf("/")).split("\\.")[0]+"_"+REP_KEY_NO+".pdf";
		String downloadFileName = ((ReportName!=null)?ReportName:"Report")+"_"+REP_KEY_NO+".pdf";
		/*end*/
		System.out.println("Download Filename-->"+downloadFileName+"<--");
		if(jasperReportName != null  &&jasperReportName.endsWith("pdf")){
			  try {
				  OutputStream os = response.getOutputStream();
				  byte[] buf = new byte[8192];
				  InputStream is = new FileInputStream(jasperReportName);
				  int c = 0;
				  while ((c = is.read(buf, 0, buf.length)) > 0) {
				      os.write(buf, 0, c);   
				  }
				  os.flush();
				  os.close();
				  is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(jasperReportName != null && relatedDoc != null)
		{
			jasperFilepath = new File(jasperReportName);
			query = "SELECT * FROM IP_REP_INFO WHERE REP_KEY_NO = ?";
rs = new CRUDHandler().executeSelectStatement(query, con,new Object[]{REP_KEY_NO});
			
			while(rs.next())
			{
				
				/*
				 * 
				 * modified by gopi for new business summary report on 08/06/17
				 * 
				 * if(reportType != null && reportType.equals("X"))*/
				if(reportType != null && reportType.equals("X") || /*reportType.equals("J") ||*/ reportType.equals("LJ"))
				{
					//end
					for(int valueCount = 1;valueCount <= 8;valueCount++)
					{
						String paramValue = rs.getString("REP_VALUE_"+valueCount);
						paramList.add(paramValue);
					}

					
					/*int repValueCount = rs.getInt("rep_value_1");
					System.out.println("repValueCount       "+repValueCount);
					for(int valueCount = 2;valueCount <= repValueCount;valueCount++)
					{
						
						String paramNameValue = rs.getString("REP_VALUE_"+valueCount);
						String paramName = null;
						String paramValue = null;
						if(paramNameValue != null)
						{
							StringTokenizer token = new StringTokenizer(paramNameValue,"&&&");
							
							 
							while(token.hasMoreTokens())
							{
								if(paramName == null)
								{
									paramName = token.nextToken();
								}
								else if(paramValue == null)
								{
									paramValue = token.nextToken();
									paramList.add(paramValue);
								}
								
								
								
							}
							System.out.println("In if loop paramName   "+paramName+"   paramValue    "+paramValue);
							param.put(paramName, paramValue);
						}
						else
						{
							System.out.println("In else loop paramName   "+paramName+"   paramValue    "+paramValue);
							param.put("param"+valueCount, paramValue);
						}
					}*/
					
				}
				else
				{
					
				
				
				int repValueCount = rs.getInt("rep_value_1");
				System.out.println("repValueCount       "+repValueCount);
				for(int valueCount = 2;valueCount <= repValueCount;valueCount++)
				{
					
					String paramNameValue = rs.getString("REP_VALUE_"+valueCount);
					String paramName = null;
					String paramValue = null;
					if(paramNameValue != null)
					{
						StringTokenizer token = new StringTokenizer(paramNameValue,"&&&");
						
						 
						while(token.hasMoreTokens())
						{
							if(paramName == null)
							{
								paramName = token.nextToken();
							}
							else if(paramValue == null)
							{
								paramValue = token.nextToken();
								paramList.add(paramValue);
							}
							
							if(paramName != null && "POL_SYS_ID".equals(paramName)){
								polSysId = paramValue;
							}
							
						}
						System.out.println("In if loop paramName   "+paramName+"   paramValue    "+paramValue);
						param.put(paramName, paramValue);
					}
					else
					{
						System.out.println("In else loop paramName   "+paramName+"   paramValue    "+paramValue);
						param.put("param"+valueCount, paramValue);
					}
				}
				
			}
				
			}
			/*Added by Sivarajan on 07/02/2020 for Orient IL */
			String queryParam = "SELECT * FROM PM_REP_TAB_MED WHERE PMRTM_REP_ID LIKE '%"+REP_ID+"%'";
			rs = new CRUDHandler().executeSelectStatement(queryParam, con);
			while(rs.next()){
				param.put(rs.getString("PMRTM_REP_PARAM_NAME"),System.getProperty("user.home")+rs.getString("PMRTM_REP_PARAM_VALUE"));
			}
			/*End*/
			/*Added by Daisy on 11-11-2020 for RI-Bordeax for AllianceIL*/
			if(reportType != null && (reportType.equals("LJ") && reportCategory.equalsIgnoreCase("XLS"))){
				/*Added by Sivarajan on 11/03/2020 for Orient IL*/
				if(procedureReqd != null)
				{
					
					int paramCount = 0,valuecount = 0;
					String IOParam = null,ParamDatatype = null, ProcName = null; 
					
					if(procedureReqd.equals("Y"))
					{
						query = "SELECT * FROM PM_REP_PROC_PARAMS WHERE PMRTH_REP_ID = ?";
						rs = new CRUDHandler().executeSelectStatement(query, con,new Object[]{REP_ID});
						
						while(rs.next())
						{
							IOParam = rs.getString("PMRTH_PARAM_TYPE");
							ParamDatatype = rs.getString("PMRTH_PARAM_DATATYPE");
							ProcName = rs.getString("PMRTH_PROC_NAME");
							
							System.out.println("IOParam           "+IOParam);
							System.out.println("ParamDatatype           "+ParamDatatype);
							System.out.println("ProcName           "+ProcName);
							
							OracleParameter param111;
							if(IOParam != null)
							{
								if(IOParam.equals("IN"))
								{
									param111 = new OracleParameter(IOParam+(paramCount+1),ParamDatatype,IOParam,paramList.get(valuecount));
								    parameterList.add(param111);	
								    valuecount++;
								}
								else
								{
									param111 = new OracleParameter(IOParam+(paramCount+1),ParamDatatype,IOParam,null);
								    parameterList.add(param111);	
								    	
								}
							}
							paramCount++;
						}
							
						
						    outputList = procHandler.execute(parameterList, con,
						    		ProcName);
						    Iterator<OracleParameter> iterator = outputList.iterator();
							while (iterator.hasNext()) {
								OracleParameter oracleParameter = iterator.next();
								//list1.add(oracleParameter.getValue());
								/*Modified by rakesh on 19-03-2020 for orient*/
								 new ExcelReports().writeExcelDeatails(response, oracleParameter.getValue().toString(),con,null,REP_ID,null);
							}
						   
					}
					
				
				}
				/*End*/
			}else{
			if(procedureReqd != null)
			{
				
				int paramCount = 0,valuecount = 0;
				String IOParam = null,ParamDatatype = null, ProcName = null; 
				
				if(procedureReqd.equals("Y"))
				{
					query = "SELECT * FROM PM_REP_PROC_PARAMS WHERE PMRTH_REP_ID = ?";
					rs = new CRUDHandler().executeSelectStatement(query, con,new Object[]{REP_ID});
					
					while(rs.next())
					{
						IOParam = rs.getString("PMRTH_PARAM_TYPE");
						ParamDatatype = rs.getString("PMRTH_PARAM_DATATYPE");
						ProcName = rs.getString("PMRTH_PROC_NAME");
						
						System.out.println("IOParam           "+IOParam);
						System.out.println("ParamDatatype           "+ParamDatatype);
						System.out.println("ProcName           "+ProcName);
						
						OracleParameter param111;
						if(IOParam != null)
						{
							if(IOParam.equals("IN"))
							{
								param111 = new OracleParameter(IOParam+(paramCount+1),ParamDatatype,IOParam,paramList.get(valuecount));
							    parameterList.add(param111);	
							    valuecount++;
							}
							else
							{
								param111 = new OracleParameter(IOParam+(paramCount+1),ParamDatatype,IOParam,null);
							    parameterList.add(param111);	
							    	
							}
						}
						paramCount++;
					}
						
					
					    outputList = procHandler.execute(parameterList, con,
					    		ProcName);
				}
				/*Added by Sivarajan on 15-02-2019 for KIC Agent Payout Statement*/
				else if(procedureReqd.equals("P"))
				{
					String value1=null,value2=null,value3=null,value4=null,value5=null,value6=null;
					int count=0;
					ResultSet rs1 = null;
					query = "SELECT REP_VALUE_1,REP_VALUE_2,REP_VALUE_3,REP_VALUE_4,REP_VALUE_5,REP_VALUE_6 FROM IP_REP_INFO WHERE REP_KEY_NO = ?";
					rs = new CRUDHandler().executeSelectStatement(query, con,new Object[]{REP_KEY_NO});
					if (rs.next())
					{
					   value1 = rs.getString("REP_VALUE_1");
					   value2 = rs.getString("REP_VALUE_2");
					   value3 = rs.getString("REP_VALUE_3");
					   value4 = rs.getString("REP_VALUE_4");
					   value5 = rs.getString("REP_VALUE_5");
					   value6 = rs.getString("REP_VALUE_6");
					}
					query = "SELECT * FROM PM_REP_PROC_PARAMS WHERE PMRTH_REP_ID = ?";
					rs = new CRUDHandler().executeSelectStatement(query, con,new Object[]{REP_ID});
					if(rs.next()){
						ProcName = rs.getString("PMRTH_PROC_NAME");
					}
					int out =0;
					String pattern = "dd-MMM-yyyy";
				    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				    System.out.println(new Date(value5));
				    String date = simpleDateFormat.format(new SimpleDateFormat("dd/MM/yyyy").parse(value5));
				    String[] date1 = date.split("-");
				    parameterList = new ArrayList<OracleParameter>();
					outputList =new ArrayList<OracleParameter>();
					procHandler = new OracleProcedureHandler();
					System.out.println("ProcName           "+ProcName);
					OracleParameter param11 = new OracleParameter("IN1", "STRING", "IN",value1);
					parameterList.add(param11); 
					OracleParameter param12 = new OracleParameter("IN2", "STRING", "IN",value2);
					parameterList.add(param12);
					OracleParameter param13 = new OracleParameter("IN3", "STRING", "IN",value3);
					parameterList.add(param13);
					OracleParameter param14 = new OracleParameter("IN4", "STRING", "IN",value4);
					parameterList.add(param14);
					OracleParameter param15 = new OracleParameter("IN5", "STRING", "IN",value5);
					parameterList.add(param15);
					OracleParameter param16 = new OracleParameter("IN6", "STRING", "IN",value6);
					parameterList.add(param16);
					OracleParameter param17 = new OracleParameter("OUT7", "INT", "OUT",String.valueOf(out));
					parameterList.add(param17);
							
					outputList = procHandler.execute(parameterList, con,
						    		ProcName);
						    
					if(reportType != null && (reportType.equals("LJ"))){
						System.out.println("param         "+param);
						JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFilepath);
						JasperPrint jp=null;
						HashMap param1 = new HashMap();	
						Iterator<OracleParameter> iterator = outputList.iterator();
						while (iterator.hasNext()) {
							OracleParameter oracleParameter = iterator.next();
							query = "SELECT PACL_BROKER_CODE FROM PW_AGENT_COMM_LBL WHERE PACL_SYS_ID =?";
							rs1 = new CRUDHandler().executeSelectStatement(query, con,new Object[]{oracleParameter.getValue()});
							while(rs1.next()){
								param1.put("POL_SYS_ID", Integer.parseInt(oracleParameter.getValue()));
								param1.put("AGENT_CODE", rs1.getString("PACL_BROKER_CODE"));
								param1.put("SUBREPORT_PATH", url5);
								downloadFileName =rs1.getString("PACL_BROKER_CODE")+"_"+date1[1]+date1[2]+".pdf";
								if(connectionReqd != null)
								{
									System.out.println("cr         "+connectionReqd);
									if(connectionReqd.equals("Y"))
									{
										jp = JasperFillManager.fillReport(jr, param1, con);		
							
									}
									else
									{
										jp = JasperFillManager.fillReport(jr,param, new JREmptyDataSource());
									}
								}
								else
								{
									jp = JasperFillManager.fillReport(jr, param, con);
								}
								System.out.println("jp.getPages().size()          "+jp.getPages().size());
								if(jp.getPages() != null && jp.getPages().size() == 0)
								{
										System.out.println("No policy had been taken"+value3);
								}
								else
								{
									ba1 = JasperExportManager.exportReportToPdf(jp);
									System.out.println("Bal   : "+ba1.length);
									response.setContentType("application/pdf");
									response.setHeader("Content-Disposition", "inline; filename=" +downloadFileName+";");
									String fileName = getFileName(ba1, REP_KEY_NO, REP_ID, downloadFileName);
								}
							}
						}
					}
				}
			}
		}/*End*/
		if(!procedureReqd.equals("P"))
		{
			if(reportCategory != null && (reportCategory.equals("S") || reportCategory.equals("X")))
			{
				 
			
			if(reportType != null && (reportType.equals("X")))
			{
				ArrayList<String> list1 = new ArrayList<String>();		
				Iterator<OracleParameter> iterator = outputList.iterator();
				while (iterator.hasNext()) {
					OracleParameter oracleParameter = iterator.next();
					list1.add(oracleParameter.getValue());
				}
				/*String excelPath = new PremiaExceWriter().writeRIBordexExcel(list1,con,jasperReportName);*/
				/*
				 * commented by Dhiensh on 29.3.2017
				 * 
				 * String excelPath = new PremiaExceWriter().writeRIBordexExcel(list1,con,jasperReportName);*/
				
				/*added by gopi for excelwrite in home patch on 25/09/17*/
				jasperReportName = excelFileName;
				/*end*/
				
				if("PREMIREP077".equalsIgnoreCase(REP_ID))
				{

					excelPath = new PremiaExceWriter().writeRIBordexExcel(list1,con,jasperReportName);
				
				}
				//added by gopi for policy and unit report on 27/05/17
				else if("PREMIREP535".equalsIgnoreCase(REP_ID))
				{
					excelPath = new PremiaExceWriter_AgentWiseBusiness().writePolicyMovementReportExcel(list1,con,jasperReportName,ReportName,paramList);
				}
				else if("PREMIREP536".equalsIgnoreCase(REP_ID))
				{
				excelPath = new PremiaExceWriter_AgentWiseBusiness().writeNO_of_Policy_ReportExcel(list1,con,jasperReportName,ReportName,paramList);	
				}
				else if("PREMIREP538".equalsIgnoreCase(REP_ID))
				{
				excelPath = new PremiaExceWriter_AgentWiseBusiness().writeUnitMovementReportExcel(list1,con,jasperReportName,ReportName,paramList);	
				/*End*/
						
				}
				/*added by gopi for ssp call id ZBLIFE-1449094 on 09/11/17*/
				else if("PREMIREP573".equalsIgnoreCase(REP_ID))
				{
				excelPath = new PremiaExceWriter_AgentWiseBusiness().writeDue_Commission_ReportExcel(list1,con,jasperReportName,ReportName,paramList);	
						
				}
				/*End*/
				/*added by Ameen for ssp call id ZBLIFE-1457951 on 28-11-2017*/
				else if("PREMIREP574".equalsIgnoreCase(REP_ID))
				{
				excelPath = new PremiaExceWriter_AgentWiseBusiness().pw_il_check_off_error_log(con,jasperReportName,ReportName,paramList);	
						
				}
				/*End*/
				
				/*added by gopi for terma report on 13/02/2018*/
				else if("PREMIREP579".equalsIgnoreCase(REP_ID))
				{
				excelPath = new PremiaExceWriter_AgentWiseBusiness().writeTerma_ReportExcel(list1,con,jasperReportName,ReportName,paramList);	
				
				}
				/*added by gopi for terma report on 13/02/2018*/
				else if("PREMIREP584".equalsIgnoreCase(REP_ID))
				{
					excelPath = new PremiaExceWriter_AgentWiseBusiness().New_Business_ReportExcel(list1,con,jasperReportName,ReportName,paramList);	
				}
				
				else
				{

					excelPath = new PremiaExceWriter_AgentWiseBusiness().writeAgentWiseExcel(list1,con,jasperReportName,ReportName,paramList);
				}	
				

				if(excelPath!=null && !excelPath.equals("")){
					System.out.println("Dhinesh 9876");
					File file = new File(excelPath);
					FileInputStream fileInputStream=null;

			      
			        byte[] bFile = new byte[(int) file.length()];

			            //convert file into array of bytes
				    fileInputStream = new FileInputStream(file);
				    fileInputStream.read(bFile);
				    fileInputStream.close();


					 
					if (response != null) {
						response.setHeader("Content-disposition", "attachment;filename="+jasperReportName+".xls");
						response.setContentLength(bFile.length);							
						response.setContentType("application/vnd.ms-excel");
						//response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
					}

					BufferedOutputStream fos1 = new BufferedOutputStream(response
							.getOutputStream());
					fos1.write(bFile);
					fos1.flush();
					fos1.close();
				}else{
					
					System.out.println("inside empty ri-bordeax");
					RequestDispatcher dis = request.getRequestDispatcher("/jsf/error/reportNotGenerate.xhtml");
					dis.forward(request, response);
				}
				
			}
			//added by gopi for new business summary report on 27/05/17
			else if(reportType != null && (reportType.equals("LJ")) && reportCategory.equals("X")){

				System.out.println("param         "+param);
				JasperReport jr1 = (JasperReport) JRLoader.loadObject(jasperFilepath);
				JasperPrint jp1=null;
				
				if(connectionReqd != null)
				{
					if(connectionReqd.equals("Y"))
					{
						jp1 = JasperFillManager.fillReport(jr1, param, con);		
					}
					else
					{
						jp1 = JasperFillManager.fillReport(jr1,param, new JREmptyDataSource());
					}
				}
				else
				{
					jp1 = JasperFillManager.fillReport(jr1, param, con);
				}
				
				System.out.println("jp.getPages().size()          "+jp1.getPages().size());
				if(jp1.getPages() != null && jp1.getPages().size() == 0)
				{
						//modified by Ganesh on 16-03-2017 for claim mail sending with attachment as per Vinoth sugg.
											if(viewType!=null && viewType.equals("email")){
												PrintWriter emailErrorOut = response.getWriter();
												emailErrorOut.println("");
												
											}else{
											RequestDispatcher dis = request.getRequestDispatcher("/jsf/error/reportNotGenerate.xhtml");
											dis.forward(request, response);
											}
											//end
				}
				else
				{
					  //  String xlsFileName = "D://ReportOutput.xlsx";

					    try {
					       
					        ByteArrayOutputStream baos = new ByteArrayOutputStream();
					        JRXlsxExporter exporter = getCommonXlsxExporter();

					        exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jp1);
					        exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, baos); // fill byte array output stream

					        exporter.exportReport();

					     //   response.setHeader("Content-disposition", "attachment;filename="+jasperReportName+".xls");

					        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
					        response.setHeader("Content-disposition", "attachment; filename=" + "New Business Production Summary.xlsx");
					        response.setContentLength(baos.size());
					        response.getOutputStream().write(baos.toByteArray());
					       // response.reset();
					    } catch (Exception ex) {
					        ex.printStackTrace();
					    }
					
					

					
				}
				
			
			}
			
			//end
			else
			{
				System.out.println("param         "+param);
				JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFilepath);
				JasperPrint jp=null;
				
				if(connectionReqd != null)
				{
					if(connectionReqd.equals("Y"))
					{
						jp = JasperFillManager.fillReport(jr, param, con);		
					}
					else
					{
						jp = JasperFillManager.fillReport(jr,param, new JREmptyDataSource());
					}
				}
				else
				{
					jp = JasperFillManager.fillReport(jr, param, con);
				}
				
				System.out.println("jp.getPages().size()          "+jp.getPages().size());
				if(jp.getPages() != null && jp.getPages().size() == 0)
				{
						//modified by Ganesh on 16-03-2017 for claim mail sending with attachment as per Vinoth sugg.
											if(viewType!=null && viewType.equals("email")){
												PrintWriter emailErrorOut = response.getWriter();
												emailErrorOut.println("");
												
											}else{
											RequestDispatcher dis = request.getRequestDispatcher("/jsf/error/noRecordFound.xhtml");
											dis.forward(request, response);
											}
											//end
				}
				else
				{
					ba1 = JasperExportManager.exportReportToPdf(jp);
					System.out.println("Bal   : "+ba1.length);
					// set pdf content
					response.setContentType("application/pdf");
					/* Added by ganesh on 17-08-2017 for ZBILQC-1719657 */
					response.setHeader("Content-Disposition", "inline; filename=" +downloadFileName+";");
					/*end*/
					/*Added by Sivarajan on 04/02/2020 for Alliance IL*/
					/*if(multiReport != null && "DL".equalsIgnoreCase(multiReport)){
					 getReturnPath(con,polSysId);
							ba1 = outList.get(i);
						}
					}*/
					/*End*/
					/*commented by ganesh on 16-03-2016 for enabling mail with attachment
					 * 
					 * BufferedOutputStream fos1 = new BufferedOutputStream(response
							.getOutputStream());
					fos1.write(ba1);
					fos1.flush();
					fos1.close();*/
					//Added by Ganesh on 16-03-2017 for claim mail sending with attachment as per Vinoth sugg.
					
					
					if(viewType!=null && viewType.equals("email")){
						/* Added by ganesh on 17-08-2017 for ZBILQC-1719657 */
						String fileName = getFileName(ba1, REP_KEY_NO, REP_ID, downloadFileName);
						PrintWriter emailWriterOne = response.getWriter();
						emailWriterOne.println(fileName);
						
					}else{
					BufferedOutputStream fos1 = new BufferedOutputStream(response
							.getOutputStream());
					
					
					if(multiReport != null && "DL".equalsIgnoreCase(multiReport)){
						
						
						List<InputStream> byteList = new ArrayList<InputStream>();
						byteList.add(new ByteArrayInputStream(ba1));
						ArrayList<byte[]> outList = getReturnPath(con,polSysId);
						for(int i = 0 ; i < outList.size();i++){
							byteList.add(new ByteArrayInputStream(outList.get(i)));
						}
						OutputStream out = new ByteArrayOutputStream();
						doMerge(byteList, out);
						ByteArrayOutputStream bos = (ByteArrayOutputStream)out;
						byte[] pol_scld_rep = null;
						pol_scld_rep = bos.toByteArray();
						fos1.write(pol_scld_rep);//write(list);
						fos1.flush();
						fos1.close();
						
					}else{
						fos1.write(ba1);
						fos1.flush();
						fos1.close();
					}
					
					}
					//end
				}
				
			}
			}
			else
			{
				System.out.println("Multiple reports");
				List<InputStream> byteList = new ArrayList<InputStream>();
				 
query = "SELECT REP_VALUE_59 FROM IP_REP_INFO  WHERE REP_KEY_NO = ?";
rs = new CRUDHandler().executeSelectStatement(query, con,new Object[]{REP_KEY_NO});
			String reportNames = null;
			while(rs.next())
			{
				reportNames = rs.getString(1);
			}
			if(reportNames != null)
			{
				StringTokenizer token = new StringTokenizer(reportNames,",");
				while(token.hasMoreTokens())
				{
					String reportName = (String)token.nextToken();
					System.out.println("reportName     "+reportName);
					if(reportName != null)
					{
						query = "SELECT * FROM pm_rep_tab_hdr WHERE PMRTH_REP_ID = ?";
						rs = new CRUDHandler().executeSelectStatement(query, con,new Object[]{reportName});
						
						while(rs.next())
						{
							jasperReportName = rs.getString("PMRTH_REP_TEMP_NAME_ID");
							connectionReqd = rs.getString("PMRTH_CONN_REQD");
							procedureReqd = rs.getString("PMRTH_PROC_REQD");
							reportType = rs.getString("PMRTH_REP_CATG");
							reportCategory = rs.getString("PMRTH_REPORT_CATG");
						}
						System.out.println("jasperReportName           "+jasperReportName);
						System.out.println("connectionReqd           "+connectionReqd);
						System.out.println("procedureReqd           "+procedureReqd);
						System.out.println("reportType           "+reportType);
						System.out.println("reportCategory           "+reportCategory);
						if(jasperReportName != null)
						{
							jasperFilepath = new File(jasperReportName);
						}
						System.out.println("param         "+param);
						JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFilepath);
						JasperPrint jp=null;
						
						if(connectionReqd != null)
						{
							if(connectionReqd.equals("Y"))
							{
								jp = JasperFillManager.fillReport(jr, param, con);		
							}
							else
							{
								jp = JasperFillManager.fillReport(jr,param, new JREmptyDataSource());
							}
						}
						else
						{
							jp = JasperFillManager.fillReport(jr, param, con);
						}
						
						System.out.println("jp.getPages().size()          "+jp.getPages().size());
						 
							ba1 = JasperExportManager.exportReportToPdf(jp);
							System.out.println("Bal   : "+ba1.length);
							
						 
						InputStream bba1 = new ByteArrayInputStream(ba1);
						byteList.add(bba1);
						
					}
				}
			}
				
			OutputStream out = new ByteArrayOutputStream();
			doMerge(byteList, out);
			ByteArrayOutputStream bos = (ByteArrayOutputStream)out;
			byte[] pol_scld_rep = null;
			pol_scld_rep = bos.toByteArray();
			 
			/*commented by ganesh on 16-03-2016 for enabling mail with attachment
			 * 
			 
			BufferedOutputStream fos1 = new BufferedOutputStream(response
					.getOutputStream());
			fos1.write(pol_scld_rep);//write(list);
			fos1.flush();
			fos1.close();
			*/	
			//Added by Ganesh on 16-03-2017 for claim mail sending with attachment as per Vinoth sugg.
			if(viewType!=null && viewType.equals("email")){
				/* Added by ganesh on 17-08-2017 for ZBILQC-1719657 */
				String fileName = getFileName(pol_scld_rep, REP_KEY_NO, REP_ID, downloadFileName);
				PrintWriter emailWriterTwo = response.getWriter();
				emailWriterTwo.println(fileName);
			
			}else{
				BufferedOutputStream fos1 = new BufferedOutputStream(response
						.getOutputStream());
				fos1.write(pol_scld_rep);//write(list);
				fos1.flush();
				fos1.close();
			}
			
			//end
				
			}	
			
			}
		}else{ //Added by Sivarajan on 07/01/2021 
			BufferedOutputStream fos1 = new BufferedOutputStream(response
					.getOutputStream());
				List<InputStream> byteList = new ArrayList<InputStream>();
				ArrayList<byte[]> outList = getReturnPath(con,REP_KEY_NO);
				for(int i = 0 ; i < outList.size();i++){
					byteList.add(new ByteArrayInputStream(outList.get(i)));
				}
				OutputStream out = new ByteArrayOutputStream();
				doMerge(byteList, out);
				ByteArrayOutputStream bos = (ByteArrayOutputStream)out;
				byte[] pol_scld_rep = null;
				pol_scld_rep = bos.toByteArray();
				fos1.write(pol_scld_rep);//write(list);
				fos1.flush();
				fos1.close();
		}
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				//modified by Ganesh on 16-03-2017 for claim mail sending with attachment as per Vinoth sugg.				
				if(viewType!=null && viewType.equals("email")){
					PrintWriter emailErrorOut = response.getWriter();
					emailErrorOut.println("");
					
				}else{
					RequestDispatcher dis = request.getRequestDispatcher("/jsf/error/reportNotGenerate.xhtml");
					dis.forward(request, response);
				}
//end
			}
		}
	}
	
	public static void doMerge(List<InputStream> list, OutputStream outputStream)
		    throws DocumentException, IOException {

		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, outputStream);

		document.open();
		PdfContentByte cb = writer.getDirectContent();

		for (InputStream in : list) {
		    PdfReader reader = new PdfReader(in);
		    for (int i = 1; i <= reader.getNumberOfPages(); i++) {
		        document.newPage();
		       
		        PdfImportedPage page = writer.getImportedPage(reader, i);
		     
		        cb.addTemplate(page, 0, 0);

		        PdfContentByte dc = writer.getDirectContent();

		        BaseFont bf = BaseFont.createFont (BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.EMBEDDED);
		        dc.beginText ();
		        dc.setFontAndSize (bf, 132);
		        //dc.setColorFill (new Color (0xFE, 0xA0, 0xA0));
		        PdfGState gs2 = new PdfGState ();
		        gs2.setFillOpacity (0.5f );
		        dc.setGState (gs2);
		     //   dc.showTextAligned (Element.ALIGN_LEFT, reportbundle.getString("watermark"), 200, 280, 50) ;
		        dc.endText ();

		    }
		}


		outputStream.flush();
		document.close();
		outputStream.close();
		}
 
	/*Added by Ganesh on 16/03/2017 for Mail attachment*/
	public Connection getJDBCConnection() throws  Exception {
		Connection dbCon=null;
		String userName = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, resourceBundleDatabase.getString("login_db_user_name"));
		String passWord = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, resourceBundleDatabase.getString("login_db_password"));
		String jdbcURL = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, resourceBundleDatabase.getString("login_db_url"));
		String jdbcDriver = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, resourceBundleDatabase.getString("jdbc.datasource.driver"));
	
		
		try{
			System.out.println("welcome to getConnectionforXDOCS      "+userName+"  "+passWord+"  "+jdbcURL+"  "+jdbcDriver+"  ");
			Class.forName(jdbcDriver);
			dbCon = DriverManager.getConnection(jdbcURL,userName,passWord);
			dbCon.setAutoCommit(false);
			
			System.out.println("dbCon     "+dbCon);
			
		}catch(Exception e){
			
			
			e.printStackTrace();
		}
		return dbCon;
	}
/*End*/
	/* Modified by ganesh on 17-08-2017 for ZBILQC-1719657 */
	public String getFileName(byte[] byteArr,String REP_KEY_NO, String REP_ID, String downloadFileName) throws IOException{
		System.out.println("Bal   : "+byteArr);
		
		/*Commented by ganesh on 31-08-2017, for email attachment report issue */
		/*final String dir = System.getProperty("user.dir");        
        int rootindex = dir.indexOf(File.separator);        
        System.out.println(dir.substring(0, rootindex));        
        File filedir = new File(dir.substring(0, rootindex)+File.separator+"pdf");
        
        if(!filedir.exists()){
        	filedir.mkdir();
        }
						
		String rootpath = dir.substring(0, rootindex)+File.separator+"pdf"+File.separator;		
		System.out.println("Root Path        "+rootpath);*/
		/*end*/
		
		/*Added by ganesh on 31-08-2017, for email attachment report issue */
		String dir = System.getProperty("user.home");                
        File filedir = new File(dir+File.separator+"pdf");
        
        if(!filedir.exists()){
        	filedir.mkdir();
        }
						
		String rootpath = dir+File.separator+"pdf"+File.separator;		
		System.out.println("Root Path        "+rootpath);
		/*end*/
		
		/*Added by ganesh on 17-08-2017 for ZBILQC-1719657*/
		//String fileName = REP_ID+"_"+REP_KEY_NO+".pdf";
		String fileName = downloadFileName;
		/*end*/
		File outfile = new File (rootpath+fileName);
		
		if (!outfile.exists()) {
			outfile.createNewFile();
		}
		
		System.out.println(outfile.getParent());
		
		FileOutputStream oFile = new FileOutputStream(outfile);
		
		BufferedOutputStream bout=new BufferedOutputStream(oFile);				
		 
        for (Byte b: byteArr) {  
        	bout.write(b);  
        }  
        bout.close();
		
		
		return outfile.getAbsolutePath();
		
	}
	//added by Daisy for Agent Payout Statement
	public String getFile(byte[] byteArr,String REP_KEY_NO, String REP_ID, String downloadFileName) throws IOException{
		System.out.println("Bal   : "+byteArr);
		
		/*Commented by ganesh on 31-08-2017, for email attachment report issue */
		/*final String dir = System.getProperty("user.dir");        
        int rootindex = dir.indexOf(File.separator);        
        System.out.println(dir.substring(0, rootindex));        
        File filedir = new File(dir.substring(0, rootindex)+File.separator+"pdf");
        
        if(!filedir.exists()){
        	filedir.mkdir();
        }
						
		String rootpath = dir.substring(0, rootindex)+File.separator+"pdf"+File.separator;		
		System.out.println("Root Path        "+rootpath);*/
		/*end*/
		
		/*Added by ganesh on 31-08-2017, for email attachment report issue */
		String dir = System.getProperty("user.home");                
        File filedir = new File(dir+File.separator+"Agent_Statement");
        
        if(!filedir.exists()){
        	filedir.mkdir();
        }
						
		String rootpath = dir+File.separator+"Agent_Statement"+File.separator;		
		System.out.println("Root Path        "+rootpath);
		/*end*/
		
		/*Added by ganesh on 17-08-2017 for ZBILQC-1719657*/
		//String fileName = REP_ID+"_"+REP_KEY_NO+".pdf";
		String fileName = downloadFileName;
		/*end*/
		File outfile = new File (rootpath+fileName);
		
		if (!outfile.exists()) {
			outfile.createNewFile();
		}
		
		System.out.println(outfile.getParent());
		
		FileOutputStream oFile = new FileOutputStream(outfile);
		
		BufferedOutputStream bout=new BufferedOutputStream(oFile);				
		 
        for (Byte b: byteArr) {  
        	bout.write(b);  
        }  
        bout.close();
		
		
		return outfile.getAbsolutePath();
		
	}
	
	/*End*/

	/*added by gopi for policy and unit report on 27/05/17*/
	private JRXlsxExporter getCommonXlsxExporter(){
	    JRXlsxExporter exporter = new JRXlsxExporter();
	    exporter.setParameter(JRXlsExporterParameter.IGNORE_PAGE_MARGINS, Boolean.TRUE);
	    exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
	//    exporter.setParameter(JRXlsExporterParameter.IS_AUTO_DETECT_CELL_TYPE, Boolean.TRUE);
	    exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
	    exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
	    exporter.setParameter(JExcelApiExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
	    //exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);


	    return exporter;
	}
	
	/*Added by Sivarajan on 06/02/2020 for Aliance IL*/
	private ArrayList<byte[]> getReturnPath(Connection con, String repKeyNo){
		ArrayList<byte[]> outList = null;
		String query = null;
		String query1 = null;
		String query2 = null;
		String polSys_id = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		String arr[] = null;
		outList = new ArrayList<byte[]>();
		try{
			query2 = "SELECT REP_VALUE_2 FROM IP_REP_INFO WHERE REP_KEY_NO = ?";
			query = "SELECT DTLS_SYS_ID FROM PT_IL_DOC_TODO_LIST_STATUS WHERE DTLS_POL_SYS_ID IN (?)";
			query1 = "SELECT LIMG_FILE_PATH FROM PM_IL_IMAGES WHERE LIMG_TRANSACTION_ID=? AND LIMG_IMAGE_FILE LIKE '%.pdf'";
			rs2 = new CRUDHandler().executeSelectStatement(query2,con,new Object[]{repKeyNo});
			if(rs2.next()){
				polSys_id = rs2.getString("REP_VALUE_2");
				arr = polSys_id.split("&&&");
				rs = new CRUDHandler().executeSelectStatement(query,con,new Object[]{arr[1]});
				while(rs.next()){
					rs1 = new CRUDHandler().executeSelectStatement(query1,con,new Object[]{rs.getString("DTLS_SYS_ID")});
					while(rs1.next()){
						File downloadFile = new File(rs1.getString("LIMG_FILE_PATH"));
				        FileInputStream inStream = new FileInputStream(downloadFile);
				        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
				        byte[] buffer = new byte[4096];
				        int bytesRead = -1;
				        while ((bytesRead = inStream.read(buffer)) != -1) {
				            outStream.write(buffer, 0, bytesRead);
				        }
						outList.add(outStream.toByteArray());
						inStream.close();
					}
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return outList;
	}
	/*End*/
}
