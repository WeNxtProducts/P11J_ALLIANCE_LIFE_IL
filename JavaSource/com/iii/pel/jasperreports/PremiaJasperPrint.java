package com.iii.pel.jasperreports;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFRegionUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.util.StringUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.apps.persistence.SimpleConnectionAgent;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.login.dao.ConnectionManager;
import com.iii.pel.util.RUPEE_TO_WORD;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfGState;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;
//import com.lowagie.text.pdf.codec.Base64.OutputStream;
/**
 * Servlet implementation class PdfStreamingServlet
 */

public class PremiaJasperPrint extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  final static ResourceBundle resourceBundle=ResourceBundle.getBundle("FalconReports");
	/**
	 * @see HttpServlet#HttpServlet()
	 * 
	 */
	public PremiaJasperPrint() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//RI-Bordeaux filepath
	
	
    
    //end RI-Bordeaux

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		try {
			processRequest(request, response);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void processRequest(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException, JRException {
		String excelPath = null;
		
		/*Added by Ram on 28/12/2016 for add cover letter in Policy document*/
		byte[] baTop;
/*End*/
		
		byte[] ba1;
		byte[] ba2;
		byte[] ba3;
		
		/*Added by Ram on 26/11/2016 for PPD Cover addition*/
		byte[]  ba4;
		/*End*/
		// fetch pdf
		byte[] pdf = new byte[] {}; // Load PDF byte[] into here
		if (pdf != null) {
			Connection con = null;

			/*added by dhinesh*/
			String clientId = null;
			HttpSession session=request.getSession();


			/*end*/
			try
			{
				System.out.println("Enter the PremiaJasperPrint ********** processRequest");

				/*Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@10.44.0.59:1521:ORCL", "P11J_FALCON_LIFE", "P11J_FALCON_LIFE");
				 */ 
				/*added by dhinesh*/
				
				if(session != null){
					System.out.println("INSIDE SESSION          ");
					System.out.println("clientId         :"+session.getAttribute("CLIENT_ID"));
					clientId = (String) session.getAttribute("CLIENT_ID");
					con = ((SimpleConnectionAgent) getServletContext()
							.getAttribute("connectionAgent")).getConnection(clientId);
				}
				/*end*/

				String contentType = "application/pdf";


				String JasperReportName=request.getParameter("JasperReportName");
				System.out.println("value of JasperReportName in premiajasperprint"+JasperReportName);
				String JasperPolSysId=request.getParameter("JasperPolSysId");
				
				//added by agalya 12/07/2016
				String RenewalPremium=request.getParameter("RenewalPremium");

				/*Added by Jagadeesh*/
				HashMap param = new HashMap();
				System.out.println("CON OBJECT VALUE   : "+con);
				
				/*Added by Ram on 28/12/2016 for add cover letter in Policy document*/
				File pdfFilepathTop = null;
				/*End*/
				
				File pdfFilepath = null;
				File pdfFilepath2 = null;
				File pdfFilepath3 = null;
				
				/*Added by Ram on 26/11/2016 for PPD Cover Condition Adding*/
				File pdfFilepath4 = null;
				/*End*/
				
				String Rep_id = CommonUtils.nvl(request.getParameter("REP_ID"),"");   
				System.out.println("Test Test Rep_id : "+Rep_id);
				
				
				String Rep_key=request.getParameter("REP_KEY");
				System.out.println("rep_id "+Rep_id);
				System.out.println("Rep_key "+Rep_key);
				INPUT_BEAN ip = select(Rep_id, Rep_key, con);
				System.out.println("RESULTED OBJ"+ip);
				String v1=ip.getREP_VALUE_1();
				String v2=ip.getREP_VALUE_2();
				String v3=ip.getREP_VALUE_3();
				String v4=ip.getREP_VALUE_4();
				String v5=ip.getREP_VALUE_5();
				String v6=ip.getREP_VALUE_6();
				System.out.println(v1);
				System.out.println(v2);
				System.out.println(v3);
				System.out.println(v4);
				System.out.println(v5);
				System.out.println(v6);

				//added by krithika on 25-03-2016
				String POL_STATUS=(request.getParameter("POL_STATUS")!=null)?request.getParameter("POL_STATUS"):"";
				String POL_NO=request.getParameter("POL_NO");
				String POL_SYS_ID=request.getParameter("POL_SYS_ID");
				System.out.println("value of POL_SYS_ID======>"+POL_SYS_ID);
				
				String reportQuery = "SELECT * FROM PP_SYSTEM1 WHERE PS_TYPE = ? AND PS_CODE = ?";
				String filepath = null;
				ResultSet reportPathRS = new CRUDHandler().executeSelectStatement(reportQuery, con,new Object[]{"REPORT_PATH","ILREP001"});
				while(reportPathRS.next())
				{
					filepath = reportPathRS.getString("PS_CODE_DESC");
					
				}
				filepath = filepath.replaceAll("E:/PREMIA-JAVA/ILReports", "C:/Falcon_Reports_IL");
				System.out.println("filepath          "+filepath);
				
				String QuestionnaireReportName = request.getParameter("QuestionnaireReportName");
				
				String Flag_Status=request.getParameter("Flag_Status");
				
				//added by Agalya on 24-05-2016
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
				//end
				
				String RevivalReportName = (request.getParameter("RevivalReportName")!=null)?request.getParameter("RevivalReportName"):"";
				String PolicyScheduleReport=request.getParameter("PolicyScheduleReport");
				String PolicyScheduleArabic=request.getParameter("PolicyScheduleArabic");
				System.out.println("jasper sys id"+POL_SYS_ID);
				
				/*Added by Ram on 21/12/2016 for Debit Note Report Development*/
				String SCHEDULE_REPORT_TYPE = request.getParameter("SCHEDULE_REPORT_TYPE");
				System.out.println("SCHEDULE_REPORT_TYPE       "+SCHEDULE_REPORT_TYPE);
				/*End*/
				//added by krithika on 29-04-2016
				
				String ReviewsheetScheduleReport=request.getParameter("ReviewsheetScheduleReport");
				String QuotationReviewsheetReport=request.getParameter("QuotationReviewsheetReport");
				String GeneralEndromentReport=request.getParameter("GeneralEndromentReport");
				String SMV_POL_NO=request.getParameter("SMV_POL_NO");
				//added by krithika on 240516
				String SURRENDERREPORT=request.getParameter("SURRENDERREPORT");
				String Paymentslipagent=request.getParameter("Paymentslipagent");
				   
				   if(SURRENDERREPORT!=null)
					{
					  
						ResultSet resultSet = null;
						String POL_Num=null;
						CRUDHandler handler = new CRUDHandler();	
						String query = "SELECT pol_sys_id FROM PT_IL_POLICY where pol_no='"+SMV_POL_NO+"'";
						System.out.println("query exe sucess"+query);	     
						resultSet = new CRUDHandler().executeSelectStatement(query, con);
						System.out.println("value for insert"+	handler.executeSelectStatement(query, con));
						while (resultSet.next()) {
							POL_Num=resultSet.getString("pol_sys_id");

						}
						 //FALCONQC-1714512 - added by saranya
						   System.out.println("Surrender_value_Intimation.jasper value of Pol_Sys_id"+POL_Num);
							ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
						       ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
						       ArrayList<String> returnList = new ArrayList<String>();
						       OracleParameter param111 = new OracleParameter("IN1","INT","IN",POL_Num);
						       parameterList.add(param111);
						       OracleProcedureHandler procHandler = new OracleProcedureHandler();
						       outputList = procHandler.execute(parameterList, con,
						               "P_INS_SURR_MAT_PERC");
						       con.commit();
						       Iterator<OracleParameter> iterator = outputList.iterator();
						       while (iterator.hasNext()) {
						    	   System.out.println("Call procedure");
						           OracleParameter oracleParameter = iterator.next();
						           System.out.println("Output value:::" + oracleParameter.getValue());
						           returnList.add(oracleParameter.getValue());
						       }
						 //end
						System.out.println("value of pol_no"+POL_Num);

						pdfFilepath = new File(filepath
								+("/FALCONREPORTNEW/Surrender_value_Intimation.jasper"));
						param.put("POL_Num", POL_Num);
						System.out.println("file path of SURRENDERREPORT "+pdfFilepath);
					

					}
				   
				   
				   /*Added by ameen for quick quote*/
					
					String ReportName=request.getParameter("QQUICK_REPORT_TYPE");
					String QUOT_PROD_CODE=request.getParameter("QUOT_PROD_CODE");//QUICK_QUOTE_PROD
					 String COMMVALUE=request.getParameter("COMMVALUE");
					 String QUOT_VALUE=request.getParameter("QUOT_VALUE");
						System.out.println("quot value--->"+QUOT_VALUE );
					System.out.println("reportname in premiaadmin"+ReportName);
					   if(ReportName!=null)
						{		
						   System.out.println("Inside premiajasperprint quotationreviewsheet");
						   System.out.println("ReportName ::::::"+ReportName);
							/*pdfFilepath = new File(filepath
									+ ("/Quotation_Review_Sheet.jasper"));
							param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));*/
						   if(ReportName.equals("1")){
							   System.out.println("inisdeeee 11");
							 
							   pdfFilepath = new File(filepath
										+ ("/Quotation_Letter/Quotation_review_sheet.jasper"));
								 param.put("QUOT_IDX_NO", request.getParameter("QUOT_IDX_NO"));
								 param.put("QUOT_SYS_ID", request.getParameter("QUOT_SYS_ID"));
								 param.put("PROD_CODE", request.getParameter("QUOT_PROD_CODE"));
								 //System.out.println("12344444555556666677778888888888"+session.getAttribute("GLOBAL.M_USER_ID"));
								 String userName=session.getAttribute("GLOBAL.M_USER_ID").toString();
							//System.out.println("userName hhhhh "+userName);
								 param.put("USERNAME",userName);
								 param.put("COMMVALUE",COMMVALUE);
								 param.put("QUOT_MOP",QUOT_VALUE);
								 System.out.println("AFT PDF"+COMMVALUE);
								 if(COMMVALUE != null && (!COMMVALUE.equals("null")))
									{
										param.put("COMMVALUE",Double.parseDouble(COMMVALUE));
									}
									else
									{
										param.put("COMMVALUE",0.00);
									}
								  
						   }
						   
						   if(ReportName.equals("2")){
							   System.out.println("inisdeeee 22");
								   
								   pdfFilepath = new File(filepath
											+ ("/Quotation_Letter/cover_confirmation_swissre.jasper"));
									param.put("QUOT_NO", request.getParameter("QUOT_NO"));
									param.put("QUOT_IDX_NO", request.getParameter("QUOT_IDX_NO"));
							  
						   }
						   
						   if(ReportName.equals("3")){
							   System.out.println("inisdeeee 33");
							   
								   pdfFilepath = new File(filepath
											+ ("/Quotation_Letter/Quotation_swissre.jasper"));
									param.put("QUOT_NO", request.getParameter("QUOT_NO"));
									param.put("QUOT_IDX_NO", request.getParameter("QUOT_IDX_NO"));
									//FOR COVER CODE DESC.
									param.put("PROD_CODE", request.getParameter("QUOT_PROD_CODE"));
									param.put("PTDA_COVER", request.getParameter("ptdaCover"));
									param.put("PTDS_COVER", request.getParameter("ptdsCover"));
									param.put("PPD_COVER", request.getParameter("ppdCover"));
									param.put("MOP_FREQ", request.getParameter("QUOT_MOP"));
							   
						   }
						   
						   if(ReportName.equals("4")){//MUNICHRE
							   pdfFilepath = new File(filepath
										+ ("/Quotation_Letter/cover_confirmation.jasper"));
								param.put("QUOT_NO", request.getParameter("QUOT_NO"));
								param.put("QUOT_IDX_NO", request.getParameter("QUOT_IDX_NO"));
						   }
						   
						   if(ReportName.equals("5")){//MUNICHRE
							   System.out.println("inisdeeee 33");
							   pdfFilepath = new File(filepath
										+ ("/Quotation_Letter/quotation letter.jasper"));
							   	param.put("QUOT_NO", request.getParameter("QUOT_NO"));
								param.put("QUOT_IDX_NO", request.getParameter("QUOT_IDX_NO"));
								//FOR COVER CODE DESC.
								param.put("PTDA_COVER", request.getParameter("ptdaCover"));
								param.put("PTDS_COVER", request.getParameter("ptdsCover"));
								param.put("PPD_COVER", request.getParameter("ppdCover"));
								param.put("PWR_COVER", request.getParameter("pwrcover"));
							   
						   }
						   
						}
						
					
					/*end*/
				   
				
				
				/*added by krithika on 20-4-16*/
				/*String ReportName=request.getParameter("REPORT_TYPE");
				System.out.println("reportname in premiaadmin"+ReportName);
				   if(ReportName!=null)
					{		
					   System.out.println("Inside premiajasperprint quotationreviewsheet");
						pdfFilepath = new File(filepath
								+ ("/Quotation_Review_Sheet.jasper"));
						param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));

					}*/
				   //end
				
				   /*added by saranya for revial questionaries on 24 -05 -2016
					 *
					 */
				   if(POL_STATUS.equals("R"))
					{
						System.out.println("R----->"+POL_STATUS);
						pdfFilepath = new File(filepath
								+ ("/revival.jasper"));
						System.out.println(pdfFilepath);
						param.put("POL_SYS_ID",POL_SYS_ID );
						
					}
					/*end*/ 
				
				
				String Revivalreport=request.getParameter("ReportType");
				System.out.println("QuestionnaireReportName   : "+QuestionnaireReportName);
				String POL_Num=request.getParameter("POL_NO");
				System.out.println("JASPER  POL_Num   :"+POL_Num);
				String NETAMT  =request.getParameter("NETAMT");
				System.out.println(" jasper NETAMT:"+ NETAMT);
				String Charge  =request.getParameter("Charge");
				System.out.println(" jasper servlet Charge:"+ Charge);
				String INTEREST =request.getParameter("INTEREST");
				System.out.println("INTEREST:"+ INTEREST);
				String PREMIUMDUE =request.getParameter("PREMIUMDUE");
				System.out.println("PREMIUMDUE:"+ PREMIUMDUE);
				/*String date =request.getParameter("date");
				System.out.println("DATE:"+ date);*/
			if(Revivalreport!=null)
				{
					pdfFilepath = new File(filepath
							+ ("/FALCONREPORTNEW/Revival Quotation.jasper"));
					param.put("POL_NO",POL_Num);
					param.put("NETAMT",NETAMT);
					param.put("PREMIUMDUE",PREMIUMDUE);
					param.put("INTEREST",INTEREST);
					param.put("Charge",Charge);
					
					if(NETAMT != null && (!NETAMT.equals("null")))
					{
						param.put("NETAMT",Double.parseDouble(NETAMT));
					}
					else
					{
						param.put("NETAMT",0.00);
					}
					if(INTEREST != null && (!INTEREST.equals("null")))
					{
						param.put("INTEREST",Double.parseDouble(INTEREST));	
					}
					else
					{
						param.put("INTEREST",0.00);
					}
					if(PREMIUMDUE != null && (!PREMIUMDUE.equals("null")))
					{
						System.out.println("PREMIUMDUE  1");
						param.put("PREMIUMDUE",Double.parseDouble(PREMIUMDUE));	
					}
					else
					{
						System.out.println("PREMIUMDUE  2");
						param.put("PREMIUMDUE",0.00);
					}	
					if(Charge != null && (!Charge.equals("null")))
					{
						System.out.println("Charge  1");
						param.put("Charge",Double.parseDouble(Charge));	
					}
					else
					{
						System.out.println("Charge  2");
						param.put("Charge",0.00);
					}		
				}
				
				System.out.println("param       "+param);
				
				/*ADDED BY KRITHIKA ON 17-4-15*/
				String EndormentScheduleReport=request.getParameter("EndormentScheduleReport");
				String endo_number=request.getParameter("endo_number");
							
								   if(EndormentScheduleReport!=null)
									{					
									   /*pdfFilepath = new File(filepath
										+ ("/Endorsement.jasper"));
								param.put("POLH_SYS_ID", request.getParameter("POL_SYS_ID"));
								param.put("END_NO_IDX", request.getParameter("endo_number"));*/
							   
							   ArrayList endList = new ArrayList();
								HashMap endMap = new HashMap();
								
								pdfFilepath = new File(filepath
										+ ("/Endorsement.jasper"));
								String END_DESC=request.getParameter("END_DESC");
								String END_CODE = request.getParameter("END_CODE");
								System.out.println("END_DESC ===>>>"+END_DESC);
								String END_NO_IDX = request.getParameter("endo_number");
								/*Added by Ram on 01/11/2016 for Endorsement Slip Report Issue*/
								int endorsementNumber = 0;
								if(endo_number != null)
								{
									endorsementNumber = Integer.parseInt(request.getParameter("endo_number"));
								}
								endorsementNumber--;
								System.out.println("endorsementNumber       "+endorsementNumber+"         "+request.getParameter("endo_number"));
								END_NO_IDX = String.valueOf(endorsementNumber);
								/*End*/
								//PILT002_APAC_COMPOSITE_ACTION mainCompositeAction = (PILT002_APAC_COMPOSITE_ACTION)CommonUtils.getGlobalObject("PILT002_APAC_COMPOSITE_ACTION");
								PILT002_APAC_COMPOSITE_ACTION mainCompositeAction = (PILT002_APAC_COMPOSITE_ACTION)session.getAttribute("PILT002_APAC_COMPOSITE_ACTION");
								System.out.println("after session of maincompositeaction"+mainCompositeAction);
								String end_query = null;
								ResultSet end_rs = null;
								String OLD_VALUE1 = null;
								String NEW_VALUE1 = null;
								String OLD_VALUE2 = null;
								String NEW_VALUE2 = null;
								String OLD_VALUE3 = null;
								String NEW_VALUE3 = null;
								String OLD_VALUE4 = null;
								String NEW_VALUE4 = null;
								String OLD_VALUE5 = null;
								String NEW_VALUE5 = null;
								String OLD_VALUE6 = null;
								String NEW_VALUE6 = null;
								String OLD_VALUE7 = null;
								String NEW_VALUE7 = null;
								String End_Code_Type=null;
								Long pol_sys_id=mainCompositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID();
								String End_Code_Query="SELECT POLH_N_END_CODE FROM PH_IL_POLICY WHERE POLH_SYS_ID="+POL_SYS_ID +" AND  POLH_END_NO_IDX ="+END_NO_IDX;
							
								
								System.out.println("End_Code_Query   : "+End_Code_Query);

								end_rs=new CRUDHandler().executeSelectStatement(End_Code_Query, con);
								while(end_rs.next()){
									End_Code_Type = end_rs.getString("POLH_N_END_CODE");
								
									 System.out.println("End_Code_Type     : "+End_Code_Type);
								}
								
								

								if(End_Code_Type.equalsIgnoreCase("GEN001")){
									//end_query = "SELECT POLH_O_ASSURED_NAME FROM PH_IL_POLICY WHERE POLH_SYS_ID = '"+pol_sys_id+"'";
									end_query = "SELECT POLH_O_ASSURED_NAME,POLH_N_ASSURED_NAME FROM PH_IL_POLICY WHERE POLH_SYS_ID ="+pol_sys_id+" AND POLH_END_NO_IDX ="+END_NO_IDX;
									end_rs=new CRUDHandler().executeSelectStatement(end_query, con);
									while(end_rs.next()){
										OLD_VALUE1 = end_rs.getString("POLH_O_ASSURED_NAME");
										NEW_VALUE1 = end_rs.getString("POLH_N_ASSURED_NAME");
										System.out.println(" ASSR_NAME_OLD_VALUE1 =="+OLD_VALUE1+"ASSR_NAME_NEW_VALUE1 =="+NEW_VALUE1);
									}

								}
								else if(End_Code_Type.equalsIgnoreCase("GEN002")){
									//end_query = "SELECT PBENH_O_REF_ID1,PBENH_O_CATG_CODE,PBENH_O_AGE,PBENH_O_RELATION_CODE,PBENH_O_PERC FROM PH_IL_POL_BENEFICIARY WHERE PBENH_POL_SYS_ID = '"+pol_sys_id+"'";
									end_query = "SELECT PBENH_O_REF_ID1,PBENH_N_REF_ID1,PBENH_O_CATG_CODE,PBENH_N_CATG_CODE,PBENH_O_AGE,PBENH_N_AGE,PBENH_O_RELATION_CODE,"
											+"PBENH_N_RELATION_CODE,PBENH_O_PERC,PBENH_N_PERC FROM PH_IL_POL_BENEFICIARY WHERE PBENH_POL_SYS_ID ="+pol_sys_id+" AND PBENH_END_NO_IDX ="+END_NO_IDX;
									end_rs=new CRUDHandler().executeSelectStatement(end_query, con);
									while(end_rs.next()){
									OLD_VALUE1 = end_rs.getString("PBENH_O_REF_ID1");
									NEW_VALUE1 = end_rs.getString("PBENH_N_REF_ID1");
									OLD_VALUE2 = end_rs.getString("PBENH_O_CATG_CODE");
									NEW_VALUE2 = end_rs.getString("PBENH_N_CATG_CODE");
									OLD_VALUE3 = end_rs.getString("PBENH_O_AGE");
									NEW_VALUE3 = end_rs.getString("PBENH_N_AGE");
									OLD_VALUE4 = end_rs.getString("PBENH_O_RELATION_CODE");
									NEW_VALUE4 = end_rs.getString("PBENH_N_RELATION_CODE");
									OLD_VALUE5 = end_rs.getString("PBENH_O_PERC");
									NEW_VALUE5 = end_rs.getString("PBENH_N_PERC");
									System.out.println(" =============>>>CITIZEN_ID<<<=========== :"+OLD_VALUE1);
									}
								}
								else if(End_Code_Type.equalsIgnoreCase("GEN003")){
									end_query = "SELECT PBENH_O_AGE,PBENH_N_AGE,PBENH_O_PERC,PBENH_N_PERC,PBENH_O_BNF_NAME,PBENH_N_BNF_NAME,"
											+ "PBENH_O_BANK_CODE,PBENH_N_BANK_CODE,PBENH_O_DIVISION,PBENH_N_DIVISION,PBENH_O_ACNT_NO,PBENH_N_ACNT_NO "
											+ "FROM PH_IL_POL_BENEFICIARY WHERE PBENH_POL_SYS_ID ="+pol_sys_id+" AND PBENH_END_NO_IDX ="+END_NO_IDX;
									end_rs=new CRUDHandler().executeSelectStatement(end_query, con);
									while(end_rs.next()){
										OLD_VALUE1 = end_rs.getString("PBENH_O_AGE");
										NEW_VALUE1 = end_rs.getString("PBENH_N_AGE");
										OLD_VALUE2 = end_rs.getString("PBENH_O_PERC");
										NEW_VALUE2 = end_rs.getString("PBENH_N_PERC");
										OLD_VALUE3 = end_rs.getString("PBENH_O_BNF_NAME");
										NEW_VALUE3 = end_rs.getString("PBENH_N_BNF_NAME");
										OLD_VALUE4 = end_rs.getString("PBENH_O_BANK_CODE");
										NEW_VALUE4 = end_rs.getString("PBENH_N_BANK_CODE");
										OLD_VALUE5 = end_rs.getString("PBENH_O_DIVISION");
										OLD_VALUE5 = end_rs.getString("PBENH_N_DIVISION");
										NEW_VALUE6 = end_rs.getString("PBENH_O_ACNT_NO");
										NEW_VALUE6 = end_rs.getString("PBENH_N_ACNT_NO");
										System.out.println(" =============>>>CITIZEN_ID<<<=========== :"+OLD_VALUE1);
									}
									System.out.println("OLD_VALUE1=="+OLD_VALUE1+"OLD_VALUE2 =="+OLD_VALUE2+"OLD_VALUE3 =="+OLD_VALUE3+"OLD_VALUE4 =="+OLD_VALUE4+"OLD_VALUE5 =="+OLD_VALUE5+"OLD_VALUE6 =="+OLD_VALUE6+
											"NEW_VALUE1 =="+NEW_VALUE1+"NEW_VALUE2 =="+NEW_VALUE2+"NEW_VALUE3 =="+NEW_VALUE3+"NEW_VALUE4 =="+NEW_VALUE4+"NEW_VALUE5 =="+NEW_VALUE5+"NEW_VALUE6 =="+NEW_VALUE6);

								}else if(End_Code_Type.equalsIgnoreCase("GEN004")){

								}else if(End_Code_Type.equalsIgnoreCase("GEN005")){
									System.out.println("pol_sys_id   : "+pol_sys_id);

									//end_query = "SELECT POLH_O_RES_ADDRESS_1,POLH_N_RES_ADDRESS_1,POLH_O_RES_ADDRESS_2,POLH_N_RES_ADDRESS_2,POLH_O_RES_ADDRESS_3,POLH_N_RES_ADDRESS_3 FROM PH_IL_POLICY WHERE POLH_SYS_ID ="+pol_sys_id+" AND POLH_END_NO_IDX ="+END_NO_IDX;
									/*Query Modified by Ram on 25/11/2016 for display Postal Code description instead of code in Reports.
									 * 
									 * end_query = "SELECT POLH_O_RES_ADDRESS_1,POLH_N_RES_ADDRESS_1,POLH_O_RES_ADDRESS_2,POLH_N_RES_ADDRESS_2,POLH_O_RES_ADDRESS_3,POLH_N_RES_ADDRESS_3,POLH_O_RES_AREA_CODE,"
												+ "POLH_N_RES_AREA_CODE,POLH_O_CITY_CODE,POLH_N_CITY_CODE,POLH_O_STATE_CODE,POLH_N_STATE_CODE,POLH_O_COUNT_CODE,POLH_N_COUNT_CODE FROM PH_IL_POLICY "
												+ "WHERE POLH_SYS_ID ="+pol_sys_id+" AND POLH_END_NO_IDX ="+END_NO_IDX;*/
									
									end_query = "SELECT POLH_O_RES_ADDRESS_1,POLH_N_RES_ADDRESS_1,POLH_O_RES_ADDRESS_2,POLH_N_RES_ADDRESS_2,POLH_O_RES_ADDRESS_3,"
											+ "POLH_N_RES_ADDRESS_3,(SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'POSTAL' AND POLH_O_RES_AREA_CODE = PC_CODE)"
											+ "POLH_O_RES_AREA_CODE,(SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'POSTAL' AND POLH_N_RES_AREA_CODE = PC_CODE)"
											+ "POLH_N_RES_AREA_CODE,(SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'CITY' AND POLH_O_CITY_CODE = PC_CODE)POLH_O_CITY_CODE,"
											+ "(SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'CITY' AND POLH_N_CITY_CODE = PC_CODE)POLH_N_RES_AREA_CODE,"
											+ "(SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'CITY' AND POLH_N_CITY_CODE = PC_CODE)POLH_N_CITY_CODE,"
											+ "(SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'STATE' AND POLH_O_STATE_CODE = PC_CODE)POLH_O_STATE_CODE,"
											+ "(SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'STATE' AND POLH_N_STATE_CODE = PC_CODE)POLH_N_STATE_CODE,"
											+ "(SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'COUNTRY' AND POLH_O_COUNT_CODE = PC_CODE)POLH_O_COUNT_CODE,"
											+ "(SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'COUNTRY' AND POLH_N_COUNT_CODE = PC_CODE)POLH_N_COUNT_CODE "
											+ "FROM PH_IL_POLICY WHERE "
											+ "POLH_SYS_ID ="+pol_sys_id+" AND POLH_END_NO_IDX ="+END_NO_IDX;
									
									System.out.println("end_query    : "+end_query);

									end_rs=new CRUDHandler().executeSelectStatement(end_query, con);
									while(end_rs.next()){
										OLD_VALUE1 = end_rs.getString("POLH_O_RES_ADDRESS_1");
										NEW_VALUE1 = end_rs.getString("POLH_N_RES_ADDRESS_1");
										OLD_VALUE2 = end_rs.getString("POLH_O_RES_ADDRESS_2");
										NEW_VALUE2 = end_rs.getString("POLH_N_RES_ADDRESS_2");
										OLD_VALUE3 = end_rs.getString("POLH_O_RES_ADDRESS_3");
										NEW_VALUE3 = end_rs.getString("POLH_N_RES_ADDRESS_3");
										OLD_VALUE4 = end_rs.getString("POLH_O_RES_AREA_CODE");
										NEW_VALUE4 = end_rs.getString("POLH_N_RES_AREA_CODE");
										OLD_VALUE5 = end_rs.getString("POLH_O_CITY_CODE");
										NEW_VALUE5 = end_rs.getString("POLH_N_CITY_CODE");
										OLD_VALUE6 = end_rs.getString("POLH_O_STATE_CODE");
										NEW_VALUE6 = end_rs.getString("POLH_N_STATE_CODE");
										OLD_VALUE7 = end_rs.getString("POLH_O_COUNT_CODE");
										NEW_VALUE7 = end_rs.getString("POLH_N_COUNT_CODE");
										System.out.println("ADDRESS 1 ==>>> :"+OLD_VALUE1);
									}
									System.out.println("OLD_VALUE1 =="+OLD_VALUE1+"OLD_VALUE2 =="+OLD_VALUE2+"OLD_VALUE3 =="+OLD_VALUE3+
											"NEW_VALUE1 =="+NEW_VALUE1+"NEW_VALUE2 =="+NEW_VALUE2+"NEW_VALUE3 =="+NEW_VALUE3);

								}else if(End_Code_Type.equalsIgnoreCase("GEN006")){
									//end_query = "SELECT POLH_O_MOBILE_NO,POLH_N_MOBILE_NO FROM PH_IL_POLICY WHERE POLH_SYS_ID ="+pol_sys_id+" AND POLH_END_NO_IDX ="+END_NO_IDX;
									end_query = "SELECT POLH_O_RES_PHONE_NO,POLH_N_RES_PHONE_NO,POLH_O_MOBILE_NO,POLH_N_MOBILE_NO FROM PH_IL_POLICY WHERE POLH_SYS_ID ="+pol_sys_id+" AND POLH_END_NO_IDX ="+END_NO_IDX;
									end_rs=new CRUDHandler().executeSelectStatement(end_query, con);
									while(end_rs.next()){
										OLD_VALUE1 = end_rs.getString("POLH_O_RES_PHONE_NO");
										NEW_VALUE1 = end_rs.getString("POLH_N_RES_PHONE_NO");
										OLD_VALUE2 = end_rs.getString("POLH_O_MOBILE_NO");
										NEW_VALUE2 = end_rs.getString("POLH_N_MOBILE_NO");
									}
									System.out.println("OLD_VALUE1            "+OLD_VALUE1+"OLD_VALUE2      "+OLD_VALUE2+"OLD_VALUE3      "+OLD_VALUE3+
											"NEW_VALUE1       "+NEW_VALUE1+"NEW_VALUE2        "+NEW_VALUE2+"NEW_VALUE3            "+NEW_VALUE3);

								}else if(End_Code_Type.equalsIgnoreCase("GEN007")){
									System.out.println("************* ENTER THE GEN007 **************");
									end_query = "SELECT POLH_O_FLEX_26,POLH_N_FLEX_26 FROM PH_IL_POLICY WHERE POLH_SYS_ID ="+pol_sys_id+" AND POLH_END_NO_IDX ="+END_NO_IDX;
									end_rs=new CRUDHandler().executeSelectStatement(end_query, con);
									while(end_rs.next()){
										OLD_VALUE1 = end_rs.getString("POLH_O_FLEX_26");
										NEW_VALUE1 = end_rs.getString("POLH_N_FLEX_26");
									}
								}else if(End_Code_Type.equalsIgnoreCase("ADDRIDER") || End_Code_Type.equalsIgnoreCase("DELRIDER")){
									System.out.println("************* ENTER THE ADDRIDER/DELRIDER **************");
									//QUERY ADDED IN REPORT LEVEL IN SEPERATE DETAIL BAND WITH PRINT EXPRESSION 
								}else if(End_Code_Type.equalsIgnoreCase("ALTERM") || End_Code_Type.equalsIgnoreCase("INCTERM") || End_Code_Type.equalsIgnoreCase("DECTERM")){
									System.out.println("************* ENTER THE ALTERM **************");
									/*end_query = "SELECT POLH_O_PERIOD, POLH_N_PERIOD, POLH_O_LC_BASIC_PREM, POLH_N_LC_BASIC_PREM FROM PH_IL_POLICY "
											+ "WHERE POLH_SYS_ID = "+pol_sys_id+" UNION ALL SELECT POACH_O_PERIOD, POACH_N_PERIOD, POACH_O_LC_PREM, "
											+ "POACH_N_LC_PREM FROM PH_IL_POL_ADDL_COVER WHERE POACH_POL_SYS_ID = "+pol_sys_id+" AND POACH_END_NO_IDX = "+END_NO_IDX;
									System.out.println("end_query ==>>>>>"+end_query);
									end_rs=new CRUDHandler().executeSelectStatement(end_query, con);
									while(end_rs.next()){
										OLD_VALUE1 = end_rs.getString("POLH_O_PERIOD");
										NEW_VALUE1 = end_rs.getString("POLH_N_PERIOD");
										OLD_VALUE2 = end_rs.getString("POLH_O_LC_BASIC_PREM");
										NEW_VALUE2 = end_rs.getString("POLH_N_LC_BASIC_PREM");
										System.out
												.println("OLD_VALUE1 =="+OLD_VALUE1+" NEW_VALUE1=="+NEW_VALUE1+" OLD_VALUE2 =="+OLD_VALUE2+" NEW_VALUE2=="+NEW_VALUE2);
									}*/
								}else if(End_Code_Type.equalsIgnoreCase("MOP")){
									System.out.println("************* ENTER THE MOP **************");
									end_query = "SELECT POLH_O_MODE_OF_PYMT, POLH_N_MODE_OF_PYMT, POLH_O_LC_BASIC_PREM, POLH_N_LC_BASIC_PREM FROM PH_IL_POLICY "
											+ "WHERE POLH_SYS_ID = "+pol_sys_id+"AND POLH_END_NO_IDX ="+END_NO_IDX;
									end_rs=new CRUDHandler().executeSelectStatement(end_query, con);
									while(end_rs.next()){
										if(end_rs.getString("POLH_O_MODE_OF_PYMT").equalsIgnoreCase("Y")){
											OLD_VALUE1 = "YEARLY";
										}
										if(end_rs.getString("POLH_O_MODE_OF_PYMT").equalsIgnoreCase("H")){
											OLD_VALUE1 = "HALF YEARLY";
										}
										if(end_rs.getString("POLH_O_MODE_OF_PYMT").equalsIgnoreCase("Q")){
											OLD_VALUE1 = "QUARTERLY";
										}
										if(end_rs.getString("POLH_O_MODE_OF_PYMT").equalsIgnoreCase("M")){
											OLD_VALUE1 = "MONTHLY";
										}
									    if(end_rs.getString("POLH_O_MODE_OF_PYMT").equalsIgnoreCase("S")){
											OLD_VALUE1 = "SINGLE";
										}
									    if(end_rs.getString("POLH_N_MODE_OF_PYMT").equalsIgnoreCase("Y")){
									    	NEW_VALUE1 = "YEARLY";
									    }
									    if(end_rs.getString("POLH_N_MODE_OF_PYMT").equalsIgnoreCase("H")){
									    	NEW_VALUE1 = "HALF YEARLY";
									    }
									    if(end_rs.getString("POLH_N_MODE_OF_PYMT").equalsIgnoreCase("Q")){
									    	NEW_VALUE1 = "QUARTERLY";
									    }
									    if(end_rs.getString("POLH_N_MODE_OF_PYMT").equalsIgnoreCase("M")){
									    	NEW_VALUE1 = "MONTHLY";
									    }
									    if(end_rs.getString("POLH_N_MODE_OF_PYMT").equalsIgnoreCase("S")){
									    	NEW_VALUE1 = "SINGLE";
									    }
										OLD_VALUE2 = end_rs.getString("POLH_O_LC_BASIC_PREM");
										NEW_VALUE2 = end_rs.getString("POLH_N_LC_BASIC_PREM");
									}
								}else if(End_Code_Type.equalsIgnoreCase("DECSA")){
									System.out.println("************* ENTER THE DECSA **************");
									
									end_query = "SELECT POLH_N_FC_SUM_ASSURED, POLH_N_FC_BASIC_PREM, POLH_O_FC_SUM_ASSURED, POLH_O_FC_BASIC_PREM FROM PH_IL_POLICY "
											+ "WHERE POLH_SYS_ID = "+pol_sys_id+" UNION ALL SELECT POACH_N_LC_SA, POACH_N_LC_PREM, POACH_O_LC_SA, POACH_O_LC_PREM FROM "
											+ "PH_IL_POL_ADDL_COVER WHERE POACH_POL_SYS_ID = "+pol_sys_id+" AND POACH_END_NO_IDX = "+END_NO_IDX;
									end_rs=new CRUDHandler().executeSelectStatement(end_query, con);
									while(end_rs.next()){
										OLD_VALUE1 = end_rs.getString("POLH_O_FC_SUM_ASSURED");
										NEW_VALUE1 = end_rs.getString("POLH_N_FC_SUM_ASSURED");
										OLD_VALUE2 = end_rs.getString("POLH_O_FC_BASIC_PREM");
										NEW_VALUE2 = end_rs.getString("POLH_N_FC_BASIC_PREM");
									}
								}else if(End_Code_Type.equalsIgnoreCase("INCSA")){
									System.out.println("************* ENTER THE INCSA **************");
									end_query = "SELECT POLH_N_LC_SUM_ASSURED, POLH_N_LC_BASIC_PREM, POLH_O_LC_SUM_ASSURED, POLH_O_LC_BASIC_PREM FROM PH_IL_POLICY WHERE POLH_SYS_ID = "+pol_sys_id+
											 " UNION ALL SELECT POACH_N_LC_SA, POACH_N_LC_PREM, POACH_O_LC_SA, POACH_O_LC_PREM FROM PH_IL_POL_ADDL_COVER WHERE "
											+ "POACH_POL_SYS_ID = "+pol_sys_id+" AND POACH_END_NO_IDX = "+END_NO_IDX;
									System.out.println("INSCA SUM ASSURED     : "+end_query);
									end_rs=new CRUDHandler().executeSelectStatement(end_query, con);
									while(end_rs.next()){
										OLD_VALUE1 = end_rs.getString("POLH_O_LC_SUM_ASSURED");
										NEW_VALUE1 = end_rs.getString("POLH_N_LC_SUM_ASSURED");
										OLD_VALUE2 = end_rs.getString("POLH_O_LC_BASIC_PREM");
										NEW_VALUE2 = end_rs.getString("POLH_N_LC_BASIC_PREM");
									}
								}

								if(OLD_VALUE1 !=null)
								{
									if(NEW_VALUE1==null || NEW_VALUE1.equals(""))
									{
										NEW_VALUE1="---";

									}
								}else if(OLD_VALUE1 == null || OLD_VALUE1.equals(""))
								{
									if(NEW_VALUE1!=null)
									{
										OLD_VALUE1="---";

									}
								}
								
								if(OLD_VALUE2!=null)
								{
									if(NEW_VALUE2==null || NEW_VALUE2.equals(""))
									{
										NEW_VALUE2="---";

									}
								}else if(OLD_VALUE2 == null || OLD_VALUE2.equals(""))
								{
									if(NEW_VALUE2!=null )
									{
										OLD_VALUE2="---";

									}
								}
								
								if(OLD_VALUE3!=null)
								{
									if(NEW_VALUE3==null || NEW_VALUE3.equals(""))
									{
										NEW_VALUE3="---";

									}
								}else if(OLD_VALUE3 == null || OLD_VALUE3.equals(""))
								{
									if(NEW_VALUE3!=null)
									{
										OLD_VALUE3="---";

									}
								}
								if(OLD_VALUE4!=null)
								{
									if(NEW_VALUE4==null || NEW_VALUE4.equals(""))
									{
										NEW_VALUE4="---";

									}
								}else if(OLD_VALUE4 == null || OLD_VALUE4.equals(""))
								{
									if(NEW_VALUE4!=null)
									{
										OLD_VALUE4="---";

									}
								}
								
								if(OLD_VALUE5!=null)
								{
									if(NEW_VALUE5==null || NEW_VALUE5.equals(""))
									{
										NEW_VALUE5="---";

									}
								}else if(OLD_VALUE5 == null || OLD_VALUE5.equals(""))
								{
									if(NEW_VALUE5!=null)
									{
										OLD_VALUE5="---";

									}
								}
								
								if(OLD_VALUE6!=null)
								{
									if(NEW_VALUE6==null || NEW_VALUE6.equals(""))
									{
										NEW_VALUE6="---";

									}
								}else if(OLD_VALUE6 == null || OLD_VALUE6.equals(""))
								{
									if(NEW_VALUE6!=null)
									{
										OLD_VALUE6="---";

									}
								}
								
								if(OLD_VALUE7!=null)
								{
									if(NEW_VALUE7==null || NEW_VALUE7.equals(""))
									{
										NEW_VALUE7="---";

									}
								}else if(OLD_VALUE7 == null || OLD_VALUE7.equals(""))
								{
									if(NEW_VALUE7!=null)
									{
										OLD_VALUE7="---";

									}
								}
								
								/*if(OLD_VALUE1 == null)
								{
									OLD_VALUE1 = "";
								}
								if(OLD_VALUE2 == null)
								{
									OLD_VALUE2 = "";
								}
								if(OLD_VALUE3 == null)
								{
									OLD_VALUE3 = "";
								}
								if(OLD_VALUE4 == null)
								{
									OLD_VALUE4 = "";
								}
								if(OLD_VALUE5 == null)
								{
									OLD_VALUE5 = "";
								}
								if(OLD_VALUE6 == null)
								{
									OLD_VALUE6 = "";
								}
								
								if(NEW_VALUE1 == null)
								{
									NEW_VALUE1 = "";
								}
								if(NEW_VALUE2 == null)
								{
									NEW_VALUE2 = "";
								}
								if(NEW_VALUE3 == null)
								{
									NEW_VALUE3 = "";
								}
								if(NEW_VALUE4 == null)
								{
									NEW_VALUE4 = "";
								}
								if(NEW_VALUE5 == null)
								{
									NEW_VALUE5 = "";
								}
								if(NEW_VALUE6 == null)
								{
									NEW_VALUE6 = "";
								}*/
								System.out.println("End_Code_Type =="+End_Code_Type+" END_NO_IDX =="+END_NO_IDX+" OLD_VALUE1=="+OLD_VALUE1+" OLD_VALUE2 =="+OLD_VALUE2+" OLD_VALUE3 =="+OLD_VALUE3+" OLD_VALUE4 =="+OLD_VALUE4+" OLD_VALUE5 =="+OLD_VALUE5+" OLD_VALUE6 =="+OLD_VALUE6+
										" NEW_VALUE1 =="+NEW_VALUE1+" NEW_VALUE2 =="+NEW_VALUE2+" NEW_VALUE3 =="+NEW_VALUE3+" NEW_VALUE4 =="+NEW_VALUE4+" NEW_VALUE5 =="+NEW_VALUE5+" NEW_VALUE6 =="+NEW_VALUE6);
								
								System.out.println("POL_SYS_ID =="+request.getParameter("POL_SYS_ID"));
								System.out.println("END_NO_IDX =="+ request.getParameter("endo_number"));
								System.out.println("END_TITLE =="+request.getParameter("END_DESC"));
								System.out.println("END_TYPE =="+request.getParameter("END_TYPE"));
								
								param.put("POLH_SYS_ID", request.getParameter("POL_SYS_ID"));
								/*	param.put("END_NO_IDX", request.getParameter("endo_number"));*/
							
								/*Modified by Ram on 01/11/2016 for Endorsement Slip Report Issue*/
								param.put("END_NO_IDX", String.valueOf(endorsementNumber));
								/*End*/

								param.put("END_TITLE", request.getParameter("END_DESC"));
								param.put("END_TYPE", request.getParameter("END_TYPE"));
								param.put("OLD_VALUE1", OLD_VALUE1);
								param.put("NEW_VALUE1", NEW_VALUE1);
								param.put("OLD_VALUE2", OLD_VALUE2);
								param.put("NEW_VALUE2", NEW_VALUE2);
								param.put("OLD_VALUE3", OLD_VALUE3);
								param.put("NEW_VALUE3", NEW_VALUE3);
								param.put("OLD_VALUE4", OLD_VALUE4);
								param.put("NEW_VALUE4", NEW_VALUE4);
								param.put("OLD_VALUE5", OLD_VALUE5);
								param.put("NEW_VALUE5", NEW_VALUE5);
								param.put("OLD_VALUE6", OLD_VALUE6);
								param.put("NEW_VALUE6", NEW_VALUE6);

								
								/*ADDED BY AMEEN ON 07/11/2016 FOR CANCELLATION OF POLICY ENDORSEMENT FALCONLIFE-1353197*/
								if(End_Code_Type.equalsIgnoreCase("CANPOL") || End_Code_Type.equalsIgnoreCase("PRO-CANCEL") || End_Code_Type.equalsIgnoreCase("CAN-POL-WOC"))
								{
									System.out.println("************* ENTER INTO CANPOL NEW SEPERATE REPORT **************");
									pdfFilepath = new File(filepath
											+ ("/CanpolEndorsement.jasper"));
									
									param.put("POLH_SYS_ID", request.getParameter("POL_SYS_ID"));
								
									param.put("END_NO_IDX", String.valueOf(endorsementNumber));
									param.put("END_TITLE", request.getParameter("END_DESC"));
								}
								/*END CANCELLATION OF POLICY ENDORSEMENT*/
								
									}
								   //END
				
				String questionnaire = null;
				questionnaire=request.getParameter("QuestionnaireReportName");
				
				/*Changed by Ram on 20/11/2016 for Reports outside path configuration
				 * 
				 * File imgfile=new File(filepath+("/WEB-INF/images/arbpic.jpg"));*/ 
				
				File imgfile=new File(filepath+("/images/arbpic.jpg"));
				
				System.out.println("pdfFilepath");
				System.out.println(pdfFilepath);
				
				//end
				
				
				
			//	Added By Saritha Premium Default Notice 21.3.2016
				String POL_SYS_ID_FM=ip.getREP_VALUE_3();
				String POL_SYS_ID_TO=ip.getREP_VALUE_4();	
				String POL_CUST_ID_FM=ip.getREP_VALUE_1();
				String POL_CUST_ID_TO=ip.getREP_VALUE_2();
				//End



				if(Rep_id != null)
				{
					//Added By Saritha Premium Default Notice 21.3.2016
					//Edited by saranya premium default notice 24-05-2016
					if(Rep_id.equalsIgnoreCase("P11_PILR_031")){						
						pdfFilepath = new File(filepath+ ("/FALCONREPORTNEW/PremiumNEW.jasper"));						
						param.put("pol_num_fm",POL_SYS_ID_FM);					
						param.put("pol_no_to",POL_SYS_ID_TO);						
						param.put("prod_fm",POL_CUST_ID_FM);					
						param.put("prod_to",POL_CUST_ID_TO);						
					} //End			
					else if(Rep_id.equalsIgnoreCase("P11_PILR_002")){
						pdfFilepath = new File(filepath
								+ ("/FALCONREPORTNEW/PRemainder.jasper"));
						param.put("P_DATE_FM", ip.getREP_VALUE_1());
						param.put("P_DATE_TO", ip.getREP_VALUE_2());
						param.put("P_CUST_CODE_FM", ip.getREP_VALUE_5());
						param.put("P_CUST_CODE_TO", ip.getREP_VALUE_6());
						param.put("P_POL_NO_FM", ip.getREP_VALUE_3());
						param.put("P_POL_NO_TO", ip.getREP_VALUE_4());					

					}
					else if(Rep_id.equalsIgnoreCase("P11_PILR_029")){
						//Lapse letter
						pdfFilepath = new File(filepath
								+ ("/FALCONREPORTNEW/LapseLetter.jasper"));
						param.put("P_PROD_CODE_FM", ip.getREP_VALUE_1());
						param.put("P_PROD_CODE_TO", ip.getREP_VALUE_2());
						param.put("P_DATE_FM", ip.getREP_VALUE_5());
						param.put("P_DATE_TO", ip.getREP_VALUE_6());
						param.put("P_POL_NO_FM", ip.getREP_VALUE_3());
						param.put("P_POL_NO_TO", ip.getREP_VALUE_4());
					}
					else if(Rep_id.equalsIgnoreCase("P11_PILR_030")){
						pdfFilepath = new File(filepath
								+ ("/FalconQuestionaires/Maturity Reminder.jasper"));
						param.put("P_PROD_CODE_FM", ip.getREP_VALUE_1());
						param.put("P_PROD_CODE_TO", ip.getREP_VALUE_2());
						param.put("P_DATE_FM", ip.getREP_VALUE_5());
						param.put("P_DATE_TO", ip.getREP_VALUE_6());
						param.put("P_POL_NO_FM", ip.getREP_VALUE_3());
						param.put("P_POL_NO_TO", ip.getREP_VALUE_4());
					}
					//added by saranya for ssp call id FALCONQC-1716577
					else if(Rep_id.equalsIgnoreCase("P11_PILR_006")){
						System.out.println("*****************   Enter the P11_PILR_006 Block ******************");
						
						String RepID=request.getParameter("REP_ID");
						String RepKeyNo=request.getParameter("REP_KEY");
						ip =select(RepID,RepKeyNo,con);
						
						String EMPLOYER= ip.getREP_VALUE_1();
						String SYSDATE= ip.getREP_VALUE_2();						
						System.out.println("P11_PILR_006  Rep_ID Bean Value   :  "+ip.toString());
						pdfFilepath = new File(filepath
								+ ("/Salary_deduction.jasper"));
						param.put("SYSDATE", SYSDATE);
						param.put("EMPLOYER", EMPLOYER);
						
						System.out.println("*****************   Enter the P11_PILR_006 Block ******************");
					}else if(Rep_id.equalsIgnoreCase("P11_PILR_003")){
						System.out.println("*****************   Enter the P11_PILR_003 Block ******************");
						
						String RepID=request.getParameter("REP_ID");
						String RepKeyNo=request.getParameter("REP_KEY");
						ip =select(RepID,RepKeyNo,con);
						
						String MICR= ip.getREP_VALUE_1();
						String SYSDATE= ip.getREP_VALUE_2();						
						System.out.println("PILR_REP070_DEB  Rep_ID Bean Value   :  "+ip.toString());
						pdfFilepath = new File(filepath
								+ ("/Direct Debit.jasper"));
						param.put("SYSDATE", SYSDATE);
						param.put("MICR", MICR);
						
						System.out.println("*****************   Enter the P11_PILR_006 Block ******************");
					}
					//end
					/*added by gopi FOR MATURITY NOTICE*/
					else if(Rep_id.equals("P11_PILR_23A"))
					{
					        INPUT_BEAN ip1 = selectValues(Rep_id, Rep_key, con);
					        System.out.println("**************RESULTED OBJ***************"+ip);
						String P_DATE_FM = ip1.getREP_VALUE_1();
						String P_DATE_TO =ip1.getREP_VALUE_2();
						String P_DIV_FM =ip1.getREP_VALUE_3();
						String P_DIV_TO =ip1.getREP_VALUE_4();
						String P_PROD_CODE_FM =ip1.getREP_VALUE_5();
						String P_PROD_CODE_TO =ip1.getREP_VALUE_6();
                     				callmaturitynoticeprocedure(P_DATE_FM,P_DATE_TO,P_DIV_FM,P_DIV_TO,P_PROD_CODE_FM,P_PROD_CODE_TO,con);
						pdfFilepath = new File(filepath
								+ ("/MaturityNotice.jasper"));
						
						param.put("P_DATE_FM",P_DATE_FM);
						param.put("P_DATE_TO",P_DATE_TO);
						param.put("P_DIV_FM",P_DIV_FM);
						param.put("P_DIV_TO",P_DIV_TO);
						param.put("P_PROD_CODE_FM",P_PROD_CODE_FM);
						param.put("P_PROD_CODE_TO",P_PROD_CODE_TO);
					}
					else if(Rep_id.equals("P11_PILR_032"))
					{
						INPUT_BEAN ip_CHK_DIS = select(Rep_id, Rep_key, con);
						System.out.println("RESULTED OBJ"+ip);
				     
						System.out.println("**************P11_PILR_032 RESULTED OBJ***************"+ip);
						String P_CUST_CODE_FM =ip_CHK_DIS.getREP_VALUE_1();
						String P_CUST_CODE_TO =ip_CHK_DIS.getREP_VALUE_2();
						String P_TXN_FM =ip_CHK_DIS.getREP_VALUE_3();
						String P_TXN_TO =ip_CHK_DIS.getREP_VALUE_4();
						String P_DOC_NO_FM =ip_CHK_DIS.getREP_VALUE_5();
						String P_DOC_NO_TO =ip_CHK_DIS.getREP_VALUE_6();
						String P_DATE_FM = ip_CHK_DIS.getREP_VALUE_7();
						String P_DATE_TO =ip_CHK_DIS.getREP_VALUE_8();
						/*callmaturitynoticeprocedure(P_DATE_FM,P_DATE_TO,P_DIV_FM,P_DIV_TO,P_PROD_CODE_FM,P_PROD_CODE_TO,con);*/
						pdfFilepath = new File(filepath
								+ ("/Cheque Dishonoured.jasper"));

						param.put("CUST_CODE_FM",P_CUST_CODE_FM);
						param.put("CUST_CODE_TO",P_CUST_CODE_TO);
						param.put("TXN_FM",P_TXN_FM);
						param.put("TXN_TO",P_TXN_TO);
						param.put("DOC_FM",P_DOC_NO_FM);
						param.put("DOC_TO",P_DOC_NO_TO);
						param.put("DATE_FM",P_DATE_FM);
						param.put("DATE_TO",P_DATE_TO);
				}
				//End

					/*ADDED BY SARANYA FOR BONUS CERTIFICATE ON FALCONQC-1716094*/
					else if("P11_PILR_012".equalsIgnoreCase(Rep_id)){
					pdfFilepath = new File(filepath
							+ ("/Bonus_Certificate.jasper"));
											
					}
										
										/*END*/

				}
				//End


				//added by dhinesh on 16.3.2016 for questionnaire report


				//String questionnaire = null;
				//questionnaire=request.getParameter("QuestionnaireReportName");
				//File imgfile=new File(filepath+("/WEB-INF/images/arbpic.jpg"));


				String Name="الاسم";
				String Occupation="المهنة";
				String Passport="رلم جواز السفر";
				String Address="العنوان";
				String Date ="التار خٌ";
				String Age="العمر";
				String Nationality="الجنس ةٌ";
				String Text="";
				String TB=") سل )درن";
				String MajorOperations="عمل اٌت جراح ةٌ كب رٌة";
				String Malaria="ملار اٌ";
				String Dysentery="دسنطار اٌ";
				String EntericFever="حمى معو ةٌ";


				String Jaundice ="رٌلان / التهاب كبدي";
				String Gonorrhoea="س لٌان";
				String Syphillis="زهري";
				String SkinDiseases="أمراض جلد ةٌ";
				String SickleCellAnaemia="أن مٌ اٌ الخل ةٌ المنجل ةٌ";
				String Stroke=") سكتة دماغ ةٌ )ضربة";
				String Hypertension="إرتفاع ف ضغط الدم";
				String HeartDisease   ="أمراض الملب";
				String Diabetes="مرض السكر";
				String Asthma="ربو / حساس ٌة";
				String RenalDisease="أمراض الكل";
				String Arthritis ="التهاب المفاصل";                                 
				String Anaemia ="فمر الدم";                                         
				String PepticUlcer="لرحة المعدة";
				String Psychiatric="أمراض نفس ةٌ وعصب ةٌ";
				String Epilepsy="صرع / صداع نصف";
				String AnymajorIllness="أي مرض هام";
				String Title1="إستمارة الفحص الطبي والتقرير الطبي لتأمين القروض البنكية";
				String Title2="ملاحظة : يجب تعبئة الفقرات من بمعر  فة المقترض";
				String Static_var3="للنساء فقط";
				String duration="هل أنت حامل؟ ف حالة الحمل اذكري المدة";
				String Problems="؟ هل تعان نٌ من مشاكل صح ةٌ مرتبطة بأمراض النساء";
				String Declare="أصرح بأن المعلومات الممدمة منى أعلاه صح حٌة حسب معرفت واعتمادي";
				String paragraph="أوافك على أن مٌوم المستشفى أو الع ٌادة والطب بٌ المولع أدناه بتمد مٌ المعلومات الت لد تحتاجها الشركة حول وضع الصح ، وأعف هٌم من كافة المسئول اٌت المانون ةٌ";
				String paragraph1="الت لد تترتب على ل اٌمهم بذلن . كما ألر بأن تار خٌ الطب الموضح أعلاه حم مٌ اٌ وأن أ ةٌ معلومات مغلوطة ستحرمن من برنامج التأم نٌ .";
				String Signatureoflife="توقيع المؤمن عليه";
				String SignatureofExaminer="توقيع المسئول عن الفحص";
				String Date1="التار خٌ";


				String Report="الفحص الطب ";
				String Name2="الاسم الأول. ";
				String Sex="الجنس";
				String cm1="سم";
				String cm2="الطول ";
				String weight1="ك لٌو غرام ";
				String weight2="الوزن ";
				String exam="نوع الفحص الطب ";
				String results="ئج ";
				String Rt1="ال سٌرى ";
				String Rt2="ال مٌنى ";
				String eye="الع وٌن ";
				String ear="الأذن ";
				String system="فحص أجهزة الجسم ";
				String vascular="الملب والأوع ةٌ الدمو ةٌ ";
				String heart="لملب ";
				String test="فحص البول ";
				String bp="ضغط الدم ";
				String pulse="النبض ";
				String respire="الجهاز التنفس ";
				String lungs="رئت نٌ";
				String gastro="المعدة والأمعاء ";
				String abdomen="طن ";
				String liver=" د";
				String spleen="طحال";
				String ascites="تجمع السائل ";
				String others="رى";
				String hernia="اق ";
				String geneto="الجهاز نٌ البول والتناسل ";
				String kidneys="الكل ";
				String bladder="المثانة ";
				String testis="الخص تٌ ٌن ";
				String PV="لمهبل ";
				String skelital="اله كٌل العظم ";
				String dental="الأسنان والفم ";
				String extremitis="الأطراف ";
				String deformitis="التشوهات ";
				String skin="الجل ";
				String veneral="الأمراض التناسل ةٌ ";
				String clinical="سر رٌ ٌا ";
				String tick1="ف حالة النف";
				String tick2="ف حالة الإ جٌاب و";
				String tick3="هل سبك وأن تعرضت لآي من الأمراض التال ةٌ ضع علامة";
				String cross="( X )";
				String tick="( √ )";
				String Dt="التار خٌ";
				String tension="إرتفاع ف ضغط الدم";
				String heartdi="أمراض الملب";
				String peptic="لرحة المعدة";
				String information="أصرح بأن المعلومات الممدمة منى أعلاه صح حٌة حسب معرفت واعتمادي";

				String ArbName="الاسم"; 
				String ArbDate="الالتاريخ"; 
				String ArbAge =" العمرل";
				String ArbOccupation=" المهنـة";
				String ArbIDCard="رقم جواز السفر";
				String ArbNationality="..الجنسية";
				String ArbAddress="العنوان";
				String ArbBP="ضغـط الـدم";
				String ArbHtCms=".سم  الطـول ";  
				String ArbWtKg = "  كيلو غرام …. الوزن  ";
				String ArbTB =" سل (درن)";
				String ArbPc="العنوان";
				String ArbHypertension="أمراض القلب/ ";
				String ArbMajorOperations="  عمليات جراحية كبيرة ";
				String ArbHeartDisease="  إرتفاع في ضغط الدم " ;
				String ArbMalaria=" ملاريا ";
				String ArbDiabetes=" مرض السكر ";
				String ArbDysentery=" دسنطاريا ";
				String ArbAsthmaAllergy=" ربو / حساسيـة ";
				String ArbEntericfever=" حمى معوية";
				String ArbRenalDisease="أمراض الكلي ";
				String ArbJaundiceHepatitis="يرقان / التهاب كبدي";
				String ArbArthritis="التهاب المفاصل "; 
				String ArbGonorrhoea="سيلان ";
				String ArbAnaemia="فقـر الــدم " ;
				String ArbSyphilis="زهــري";
				String ArbPepticUlcer="قرحـة المعـدة ";
				String ArbSkinDiseases="أمراض جلدية";
				String ArbPsychiatricProblems="أمراض نفسية وعصبية ";
				String ArbSickleCell="أنيميا الخلية المنجلية";
				String ArbEpilepsyMigraine="صرع / صداع نصفي";
				String ArbStroke="سكتة دماغية (ضربة)";
				String ArbAnymajorIllness="أي مرض هـام ";
				String ArbFORFEMALECANDIDATESONLY="للنســــاء فقــــط ";
				String ArbAreyoupregnan="هل أنت حامل؟ في حالة الحمل اذكري المدة ";
				String ArbHead="أصرح بأن المعلومات المقدمة منى أعلاه صحيحة حسب معرفتـي واعتقادي";
				String ArbPara1="أوافق على أن يقوم المستشفى أو العيـادة والطبيب الموقع أدناه بتقديم المعلومات التي قد تحتاجها الشركة حول وضعي الصحي ، وأعفيهم من كافة";
				String ArbPara2="المسئوليات القانونية التي قد تترتب على قيامهم بذلك . كما أقر بأن تاريخي الطبي الموضح أعلاه حقيقيا وأن أية معلومات مغلوطة ستحرمني من";
				String ArbPara3="برنامج التأمين .";
				String ArbSignature="توقيع المؤمن عليه " ;
				String Arbcorrect1=" في حالة النفي";
				String Arbtick1="هل سبق وأن تعرضت لآي من الأمراض التالية ضع علامة  ";
				String Arbtick2="( X )";
				String Arbtick3=" في حالة الإيجاب و";
				String Arbtick4="( √ )";



				/*Added by Gopi for Premium receipt on 13-04-2016 */
				String DEP_REF_NO = request.getParameter("DEP_REF_NO");
				String DEP_DOC_NO =  request.getParameter("DEP_DOC_NO");
				
				//added by agalya 12/07/2016
				String PC_REF_NO = request.getParameter("PC_REF_NO");
				System.out.println("pol no   :  :"+PC_REF_NO);
				String PC_DRCR_DOC_NO = request.getParameter("PC_DRCR_DOC_NO");
				System.out.println("DOC no   :  :"+PC_DRCR_DOC_NO);
				
				String PC_DRCR_DOC_DT= request.getParameter("PC_DRCR_DOC_DT");
				System.out.println("PC_DRCR_DOC_DT  :  :"+PC_DRCR_DOC_DT);
				
				String userId = (String) session.getAttribute("GLOBAL.M_USER_ID");
				RUPEE_TO_WORD rupee = new RUPEE_TO_WORD();
				String DEP_LC_DEP_AMT =rupee.getamtfromtable(DEP_REF_NO,DEP_DOC_NO,con);
				
				//added by agalya 12/07/2016
				String DEP_LC_DEP_AMT1 =rupee.getamountfromtable(PC_REF_NO,PC_DRCR_DOC_NO,con);
				System.out.println("testesting----->"+DEP_LC_DEP_AMT1);
				
				//double DEP_AMT = Double.parseDouble(DEP_LC_DEP_AMT);
				String PAYMENT_MODE=rupee.paymentMode(DEP_REF_NO,con);
			
				//added by agalya 12/07/2016
				String PAYMENT_MODE1=rupee.paymentMode1(PC_REF_NO,con);
				
                System.out.println("DEP_LC_DEP_AMT    : "+DEP_LC_DEP_AMT+"......"+   PAYMENT_MODE);
				//String amt=rupee.getRupeeinword(DEP_LC_DEP_AMT+".000");
                /*String amt=rupee.getRupeeinword(CommonUtils.Decimal_Convert(DEP_LC_DEP_AMT));
               */ 
			
				//added by agalya 12/07/2016
				System.out.println("DEP_LC_DEP_AMT1    : "+DEP_LC_DEP_AMT1+"......"+   PAYMENT_MODE1);
				//String amt1=rupee.getRupeeinword(DEP_LC_DEP_AMT1+".000");
				/*String amt1 = rupee.getRupeeinword(CommonUtils.Decimal_Convert(DEP_LC_DEP_AMT1));*/
				String Mode_of_pay=null;
				String sentance1 = resourceBundle.getString("word_1");
				String sentance2 =resourceBundle.getString("word_2");  
				String sentance3 =resourceBundle.getString("word_3"); 
			/*	String Totalword=sentance1+DEP_LC_DEP_AMT+"(R.O."+amt+sentance2+" "+PAYMENT_MODE+" "+sentance3;*/
				 
				String Totalword1=null;
				
				String PolicyScheduleSubReport = request.getParameter("PolicyScheduleSubReport");
				
				String ReportType=request.getParameter("POL_NO");
				
				
				System.out.println("PremiaJasperPrint" +ReportType );
				
				String LOANREVIEWSHEET=request.getParameter("LOANREVIEWSHEET");
				//added by agalya on 060616
				
				String QuotationForLoan = request.getParameter("QuotationForLoan");
				String LoanAgreement = request.getParameter("LoanAgreement");
				//end
				
				
						
			String SURRENDER_PAID_TYPE =request.getParameter("SURRENDER_PAID_TYPE");
			String Quotation_Letter = request.getParameter("Quotation_Letter");//Added by Ameen for Quotation Letter FALCONQC-1716555 
			String Quotation_PROD_CODE = request.getParameter("PROD_CODE");//Added by Ameen for Quotation Letter FALCONQC-1716555 
			System.out.println("quotation_letter ==>>"+Quotation_Letter+"::quotation_PROD_CODE==>>"+Quotation_PROD_CODE);//Added by Ameen for Quotation Letter FALCONQC-1716555 
				if(SURRENDER_PAID_TYPE!=null)
				{
					String amt=rupee.getRupeeinword(CommonUtils.Decimal_Convert(DEP_LC_DEP_AMT));
					String Totalword=sentance1+DEP_LC_DEP_AMT+"(R.O."+amt+sentance2+" "+PAYMENT_MODE+" "+sentance3;
					
					if(SURRENDER_PAID_TYPE.equals("SURRENDER"))
					{
						pdfFilepath = new File(filepath
								+ ("/FALCONREPORTNEW/SURRENDER_CALCULATION.jasper"));
						param.put("SMV_POL_NO",SMV_POL_NO);
						System.out.println("param 1        "+param);
					
					}else 
					{
						pdfFilepath = new File(filepath
								+ ("/FALCONREPORTNEW/SURRENDER_LOAN_REVIEW_SHEET.jasper"));
						param.put("SMV_POL_NO",SMV_POL_NO);
					}
					//added by gopinath for loan review sheet
				}else if(LOANREVIEWSHEET!=null)
				{					
					System.out.println("*****************LOANREVIEWSHEET****************");
					pdfFilepath = new File(filepath
							+ ("/FALCONREPORTNEW/New_Loan_Review_sheet.jasper"));				

				}else if(PolicyScheduleReport!=null){
					
				 System.out.println("Enter into PolicyScheduleReport ");
				
					ResultSet resultSet = null;
					String POAC_COVER_CODE=null;
					String Prod_code=null;
					CRUDHandler handler = new CRUDHandler();	
					String pol_sys_is=request.getParameter("POL_SYS_ID");
					System.out.println("pol_sys_is       "+pol_sys_is);

					String query ="SELECT POL_SYS_ID, POL_NO, POL_PROD_CODE, PROD_DESC,POAC_COVER_CODE, COVER_LONG_DESC FROM PT_IL_POLICY, PT_IL_POL_ADDL_COVER, PM_IL_PRODUCT, PM_IL_COVER WHERE POAC_POL_SYS_ID=POL_SYS_ID AND POL_PROD_CODE=PROD_CODE AND POAC_COVER_CODE=COVER_CODE AND POL_SYS_ID='"+pol_sys_is+"'";

						

					resultSet = new CRUDHandler().executeSelectStatement(query, con);
                    int loop = 0;
					while (resultSet.next()) {
						
						POAC_COVER_CODE=resultSet.getString("POAC_COVER_CODE");
						Prod_code=resultSet.getString("POL_PROD_CODE");
						System.out.println("POAC_COVER_CODE       "+POAC_COVER_CODE+"     Prod_code       "+Prod_code);
						param.put("param"+loop, POAC_COVER_CODE);
						loop++;
						param.put("param"+loop, Prod_code);
						loop++;
						System.out.println("param in loop       "+param);
					}	

 if(loop < 15)
 {
	 for(int start = loop;start <= 15;start++)
	 {
		 param.put("param"+start, null);
	 }
 }
				
 /*Added by Ram on 28/12/2016 for add cover letter in Policy document*/
 pdfFilepathTop = new File(filepath
			+ ("/FalconPolicySchedule/FalconPolicyScheduleTop.jasper"));
 /*End*/
 
            /*pdfFilepath = new File(filepath
			+ ("/FalconPolicySchedule/FalconPolicySchedule.jasper"));*/
 
 pdfFilepath = new File(filepath
			+ ("/FalconPolicySchedule/PolicySchedule.jasper"));
 
					pdfFilepath2 = new File(filepath
							+ ("/FalconPolicySchedule/FalconPolicySchedule2.jasper"));
					
					/*Added and Changed existing one by Ram on 26/11/2016 for PPD Cover addition*/
					pdfFilepath3 = new File(filepath
							+ ("/FalconPolicySchedule/FalconPolicySchedule3.jasper"));
					
					
					pdfFilepath4 = new File(filepath
							+ ("/FalconPolicySchedule/FalconPolicySchedule4.jasper"));
					/*End*/
					
					param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
					param.put("Flag_Status", request.getParameter("Flag_Status"));
					param.put("Intermediary", "Intermediary");
					System.out.println("parametrs        "+param);
					//added by agalya
					/*param.put("param0", request.getParameter("param0"));
					param.put("param1", request.getParameter("param1"));
					param.put("param2", request.getParameter("param2"));
					param.put("param3", request.getParameter("param3"));
					param.put("param4", request.getParameter("param4"));
					param.put("param5", request.getParameter("param5"));
					param.put("param6", request.getParameter("param6"));
					param.put("param7", request.getParameter("param7"));
					param.put("param8", request.getParameter("param8"));
					param.put("param9", request.getParameter("param9"));
					param.put("param10", request.getParameter("param10"));
					param.put("param11", request.getParameter("param11"));
					param.put("param12", request.getParameter("param12"));
					param.put("param13", request.getParameter("param13"));
					param.put("param14", request.getParameter("param14"));
					param.put("param15", request.getParameter("param15"));*/
					//end
					
				}
				/*Added by Ram on 22/12/2016 for Debit Note Report Development*/
				else if(SCHEDULE_REPORT_TYPE != null && SCHEDULE_REPORT_TYPE.equals("Debit Note"))
				{
					System.out.println("Welcome to SCHEDULE_REPORT_TYcoPE");
					pdfFilepath = new File(filepath
							+ ("/FalconPolicySchedule/DebitNote.jasper"));
					
					ResultSet resultSet = null;
					 
					CRUDHandler handler = new CRUDHandler();	
					String pol_sys_is=request.getParameter("POL_SYS_ID");
					System.out.println("pol_sys_is       "+pol_sys_is);

					String query ="  SELECT F_DEBIT_NOTE_AMOUNT('"+pol_sys_is+"' ) FROM DUAL";
					String totalAmount = "1";
					 resultSet = handler.executeSelectStatement(query, con);
					while (resultSet.next()) {
						totalAmount = resultSet.getString(1);
					} 
					System.out.println("totalAmount     "+totalAmount);
					String convertedValue = Decimal_Convert(totalAmount);
					System.out.println("convertedValue     "+convertedValue);
					String debitAmountinWords =rupee.getRupeeinword(convertedValue,con);
					param.put("debitAmountinWords", debitAmountinWords);
					param.put("POL_SYS_ID", POL_SYS_ID);
				}
				/*End*/
				
				/*Added by Ram on 22/12/2016 for Credit Note Report Development*/
				else if(SCHEDULE_REPORT_TYPE != null && SCHEDULE_REPORT_TYPE.equals("Credit Note"))
				{
					System.out.println("Welcome to SCHEDULE_REPORT_TYcoPE");
					pdfFilepath = new File(filepath
							+ ("/FalconPolicySchedule/CreditNote.jasper"));
					
					ResultSet resultSet = null;
					 
					CRUDHandler handler = new CRUDHandler();	
					String pol_sys_is=request.getParameter("POL_SYS_ID");
					System.out.println("pol_sys_is       "+pol_sys_is);

					String query ="  SELECT F_GET_COMM_ENTRY('"+pol_sys_is+"' ) FROM DUAL";
					String totalAmount = "1";
					 resultSet = handler.executeSelectStatement(query, con);
					while (resultSet.next()) {
						totalAmount = resultSet.getString(1);
					} 
					System.out.println("totalAmount     "+totalAmount);
					String convertedValue = Decimal_Convert(totalAmount);
					System.out.println("convertedValue     "+convertedValue);
					String debitAmountinWords =rupee.getRupeeinword(convertedValue,con);
					param.put("debitAmountinWords", debitAmountinWords);
					param.put("POL_SYS_ID", POL_SYS_ID);
				}
				/*End*/
				/*Added by Ram on 26/12/2016 for Propsal Decline Letter*/
				else if(SCHEDULE_REPORT_TYPE != null && SCHEDULE_REPORT_TYPE.equals("Proposal Decline Letter"))
				{
					System.out.println("Welcome to Proposal Decline Letter");
					pdfFilepath = new File(filepath
							+ ("/FalconPolicySchedule/ProposalDeclineLetter.jasper"));
					 
					param.put("POL_SYS_ID", POL_SYS_ID);
				}
				/*End*/
				//added by krithika for empty report binding on 29-04-2016
				else if(Paymentslipagent!=null){
					pdfFilepath = new File(filepath                                                                                                                      
							+ ("/paymentslip_agent.jasper"));
					param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
				}
				//added by agalya on 060616
				else if(QuotationForLoan!=null){
					pdfFilepath = new File(filepath                                                                                                                      
							+ ("/QuotationForLoan.jasper"));
					param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
				}
				else if(LoanAgreement!=null){
					pdfFilepath = new File(filepath                                                                                                                      
							+ ("/PolicyLoan.jasper"));
					param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
				}
				//end
				
				else if(ReviewsheetScheduleReport!=null){
					System.out.println("enter into ReviewsheetScheduleReport in premiajasperprint");
					pdfFilepath = new File(filepath
							+  ("/Policy_review_sheet.jasper"));
					param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
				}
				else if(PolicyScheduleSubReport!=null){
					System.out.println("inside the subprocess policy schedule");
					pdfFilepath = new File(filepath
							+ ("/PolicyScheduleSubReport.jasper"));
					param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
					param.put("DS_TYPE", request.getParameter("DS_TYPE"));
					
					/*Added by Ram on 19/11/2016 for DSA Print Tabular format*/
					String totalCont = request.getParameter("TOTAL_COUNT");
					System.out.println("totalCont     "+totalCont);
					if(totalCont != null)
					{
						param.put("TOTAL_COUNT", Integer.parseInt(totalCont));	
					}
					else
					{
						param.put("TOTAL_COUNT", 0);
					}
					/*End*/
				}
				else if(GeneralEndromentReport!=null){
					System.out.println("enter into ReviewsheetScheduleReport in premiajasperprint");
					pdfFilepath = new File(filepath
							+ ("/Quotationaries/sickle.jasper"));
					param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
				}
				else if(QuotationReviewsheetReport!=null){/*Changed by Ram on 23/11/2016 for Common Report maintainance
					System.out.println("enter into ReviewsheetScheduleReport in premiajasperprint");
					pdfFilepath = new File(filepath
							+ ("/Quotation_Review_Sheet.jasper"));
					param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
				*/
					

					System.out.println("enter into ReviewsheetScheduleReport in premiajasperprint");
					pdfFilepath = new File(filepath
							+ ("/Proposal_Review_Sheet.jasper"));
					param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
				
				}//end
				
				//ADDED BY AMEEN 17-8-2016 FOR QUOTATION LETTER IN PROPOSAL LEVEL FALCONQC-1716555 
				
				else if(Quotation_Letter!=null)
				{ 
				if(Quotation_Letter.equalsIgnoreCase("Quotation Letter"))
				{
					/*Changed by Ram on 23/11/2016 for Common Proposal Letter concept
					 * 
					 * if(Quotation_PROD_CODE.equals("122")){
						System.out.println("$ INSIDE QUOTATION LETTER MUNICHRE $ AND Quotation_PROD_CODE ==>>"+Quotation_PROD_CODE);
								pdfFilepath = new File(filepath
										+ ("/Proposal_Quotation_Letter/quotation_letter_munichre.jasper"));
								param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
								param.put("PTDA_COVER", request.getParameter("PTDACover"));
								param.put("PTDS_COVER", request.getParameter("PTDSCover"));
								param.put("PPD_COVER", request.getParameter("PPDCover"));
								param.put("PWR_COVER", request.getParameter("PWRCover"));
					}else{
						System.out.println("$ INSIDE QUOTATION LETTER SWISSRE $ AND Quotation_PROD_CODE ==>>"+Quotation_PROD_CODE );
						pdfFilepath = new File(filepath
										+ ("/Proposal_Quotation_Letter/quotation_letter_swissre.jasper"));
						param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
						param.put("PTDA_COVER", request.getParameter("PTDACover"));
						param.put("PPD_COVER", request.getParameter("PPDCover"));
						param.put("MOP_FREQ", request.getParameter("POL_MOP"));
						param.put("PROD_CODE", request.getParameter("PROD_CODE"));
						param.put("MED_FLAG", request.getParameter("MED_FLAG"));
						param.put("PTDS_COVER", request.getParameter("PTDSCover"));
					}*/
					
					 
						System.out.println("$ INSIDE QUOTATION LETTER SWISSRE $ AND Quotation_PROD_CODE ==>>"+Quotation_PROD_CODE );
						pdfFilepath = new File(filepath
										+ ("/Proposal_Quotation_Letter/PropsalLetter.jasper"));
						param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
						param.put("PTDA_COVER", request.getParameter("PTDACover"));
						param.put("PPD_COVER", request.getParameter("PPDCover"));
						param.put("MOP_FREQ", request.getParameter("POL_MOP"));
						param.put("PROD_CODE", request.getParameter("PROD_CODE"));
						param.put("MED_FLAG", request.getParameter("MED_FLAG"));
						param.put("PTDS_COVER", request.getParameter("PTDSCover"));
					 

				}
				if(Quotation_Letter.equalsIgnoreCase("Acceptance Letter"))
				{
					
					/*Changed by Ram on 24/11/2016 for Common Acceptance Letter concept
					 * 
					 * if(Quotation_PROD_CODE.equals("122")){
						System.out.println("$ INSIDE ACCEPTANCE LETTER MUNICHRE $ AND Quotation_PROD_CODE ==>>"+Quotation_PROD_CODE);
						pdfFilepath = new File(filepath
								+ ("/Proposal_Quotation_Letter/acceptance_letter_munichre.jasper"));
						param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
					}else{
						System.out.println("$ INSIDE ACCEPTANCE LETTER SWISSRE $ AND Quotation_PROD_CODE ==>>"+Quotation_PROD_CODE);
						pdfFilepath = new File(filepath
								+ ("/Proposal_Quotation_Letter/acceptance_letter_swissre.jasper"));
						param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
						param.put("PROD_CODE", request.getParameter("PROD_CODE"));
					}*/
					
					 
						System.out.println("$ INSIDE ACCEPTANCE LETTER MUNICHRE $ AND Quotation_PROD_CODE ==>>"+Quotation_PROD_CODE);
						 
						pdfFilepath = new File(filepath
								+ ("/Proposal_Quotation_Letter/AcceptanceLetter.jasper"));
						param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
						param.put("PROD_CODE", request.getParameter("PROD_CODE"));
				 

				}
			}
				
				//END QUOTATION LETTER
				
				//added by agalya 18/07/2016 for ssp call -FALCONQC-1715236 
			
				
				else if(RenewalPremium!=null){
				
					ResultSet resultSet = null;
					CRUDHandler handler = new CRUDHandler();	
					String query = "SELECT  DECODE(POL_MODE_OF_PYMT, 'Y','Yearly', 'M','Monthly', 'Q','Quarterly','S','Single') MODE_OF_PAY FROM PT_IL_POLICY where pol_no='"+PC_REF_NO+"'";
					System.out.println("query exe sucess"+query);	     
					resultSet = new CRUDHandler().executeSelectStatement(query, con);
					System.out.println("value for insert"+	handler.executeSelectStatement(query, con));
					while (resultSet.next()) {
						Mode_of_pay=resultSet.getString("MODE_OF_PAY");
					}
					Totalword1=" Being "+Mode_of_pay+" premium for "+PC_DRCR_DOC_DT +" Received on Policy No: "+PC_REF_NO;
					
					System.out.println("enter into RenewalPremium in premiajasperprint");
					pdfFilepath = new File(filepath
							+ ("/Renewal_Premium_Collection.jasper"));
					/*param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
					System.out.println("POL_SYS_ID    :"+request.getParameter("POL_SYS_ID"));*/
					param.put("POL_SYS_ID",PC_REF_NO);
					System.out.println("PC_REF_NO    :"+PC_REF_NO);
					
					param.put("P_DEP_DOC_NO",PC_DRCR_DOC_NO);
					System.out.println("PC_DRCR_DOC_NO    :"+PC_DRCR_DOC_NO);
					
					param.put("USER_ID",userId);
					System.out.println("userId1    :"+userId);
					
					param.put("CUR_WORD_1",Totalword1);
					System.out.println("Totalword1    :"+Totalword1);
					
					if(DEP_LC_DEP_AMT1 != null && (!DEP_LC_DEP_AMT1.equals("null")))
					{
						//param.put("DEP_LC_DEP_AMT",Double.parseDouble(DEP_LC_DEP_AMT1));
						param.put("DEP_LC_DEP_AMT",CommonUtils.Decimal_Convert(DEP_LC_DEP_AMT1));
					}
					else
					{
						param.put("DEP_LC_DEP_AMT", 0.000);
					}
					
					System.out.println("DEP_LC_DEP_AMT1    :"+DEP_LC_DEP_AMT1);
					
					/*Added by Ram on 23/12/2016*/
					String amt1 = rupee.getRupeeinword(CommonUtils.Decimal_Convert(DEP_LC_DEP_AMT1));
					/*End*/
					param.put("CUR_WORD_3","R.O."+amt1);
					System.out.println("amt1    :"+amt1);
					
				}
				
				else if(DEP_REF_NO!=null)
				{					
					System.out.println("MONTHLY_PREMIUM_RECEIPTS");
					pdfFilepath = new File(filepath
							+ ("/FALCONREPORTNEW/MONTHLY_PREMIUM_RECEIPTS.jasper"));
					param.put("POL_SYS_ID",DEP_REF_NO);
					System.out.println("DEP_REF_NO    :"+DEP_REF_NO);
					
					param.put("P_DEP_DOC_NO",DEP_DOC_NO);
					System.out.println("P_DEP_DOC_NO    :"+DEP_DOC_NO);
					
					param.put("USER_ID",userId);
					System.out.println("DEP_REF_NO    :"+userId);
					
					/*Added by Ram on 23/12/2016*/
					String amt=rupee.getRupeeinword(CommonUtils.Decimal_Convert(DEP_LC_DEP_AMT));
					String Totalword=sentance1+DEP_LC_DEP_AMT+"(R.O."+amt+sentance2+" "+PAYMENT_MODE+" "+sentance3;
					/*End*/
					
					param.put("CUR_WORD_1",Totalword);
					System.out.println("Totalword    :"+Totalword);
					
					//added by agalya
					if(DEP_LC_DEP_AMT != null && (!DEP_LC_DEP_AMT.equals("null")))
					{
						//param.put("DEP_LC_DEP_AMT",Double.parseDouble(DEP_LC_DEP_AMT));
						param.put("DEP_LC_DEP_AMT",CommonUtils.Decimal_Convert(DEP_LC_DEP_AMT));
					}
					else
					{
						//param.put("DEP_LC_DEP_AMT", 0.0);
						param.put("DEP_LC_DEP_AMT", 0.000);
					}
					
					System.out.println("DEP_LC_DEP_AMT    :"+DEP_LC_DEP_AMT);
					//end
					
				/*	param.put("DEP_LC_DEP_AMT", DEP_LC_DEP_AMT);
					System.out.println("DEP_LC_DEP_AMT    :"+DEP_LC_DEP_AMT);*/
					
					//param.put("CUR_WORD_2",sentance3);
					param.put("CUR_WORD_3","R.O."+amt);
					System.out.println("amt    :"+amt);

				}else if((questionnaire!=null)||(PolicyScheduleArabic!=null))
				{

					if("FINANCIALQUESTIONAIRE SWISS".equalsIgnoreCase(questionnaire))
					{
						System.out.println("FINANCIALQUESTIONAIRE SWISS");
						pdfFilepath = new File(filepath
								+ ("/Quotationaries/FinancialQuestionairreSwissre.jasper"));
						param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
					}else if("CARDIAC SURGERY CARDIOLOGIST".equalsIgnoreCase(questionnaire))
					{
						System.out.println("CARDIAC SURGERY CARDIOLOGIST");
						pdfFilepath = new File(filepath
								+ ("/Quotationaries/CADCABGQR.jasper"));
						param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
						System.out.println("POL_SYS_ID in premia ------->"+POL_SYS_ID);
					}
					else if("General Provision For Arabic".equalsIgnoreCase(PolicyScheduleArabic))
					{
						System.out.println("General Provision For Arabic");
						pdfFilepath = new File(filepath
								+ ("/Quotationaries/FalconPolicySchedule_Arabic.jasper"));
					}
					
					else if("FINANCIALQUESTIONNAIRE LETTER".equalsIgnoreCase(questionnaire))
					{
						System.out.println("FINANCIALQUESTIONNAIRE LETTER");
						pdfFilepath = new File(filepath
								+ ("/Quotationaries/Financialqr.jasper"));
						param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
						
					}else if("SICKLE CELL DISEASE".equalsIgnoreCase(questionnaire))
					{
						System.out.println("SICKLE CELL DISEASE");
						pdfFilepath = new File(filepath
								+ ("/Quotationaries/sickle.jasper"));
						param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
						
					}else if("PEPTICULCER QUESTIONNAIRE".equalsIgnoreCase(questionnaire))
					{
						pdfFilepath = new File(filepath
								+ ("/Quotationaries/PepticUlcer.jasper"));
						param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
						param.put("FalconImage", imgfile.toString() );
						
					}else if("FINANCIALQUESTIONNAIRE BANKLOAN SWISS".equalsIgnoreCase(questionnaire))
					{
						pdfFilepath = new File(filepath
								+ ("/Quotationaries/Financial_questionnaire.jasper"));	
						param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
						
					}else if("DIABETES MELLITUS".equalsIgnoreCase(questionnaire))
					{
						pdfFilepath = new File(filepath
								+ ("/Quotationaries/Diabetes_ Mellitus_Questionnaire.jasper"));
						param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
						System.out.println("POL_SYS_ID in premia ------->"+POL_SYS_ID);

					}else if("DIVING QUESTIONNAIRE".equalsIgnoreCase(questionnaire))
					{
						pdfFilepath = new File(filepath
								+ ("/Quotationaries/DIVINGQUESTIONNAIRE.jasper"));
						param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
						System.out.println("POL_SYS_ID in premia ------->"+POL_SYS_ID);

					}else if("TUMOUR QUESTIONNAIRE".equalsIgnoreCase(questionnaire))
					{
						System.out.println("TUMOUR QUESTIONNAIRE");
						pdfFilepath = new File(filepath
								+ ("/Quotationaries/TumourQuestionnaire.jasper"));
						param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
						System.out.println("POL_SYS_ID in premia ------->"+POL_SYS_ID);

					}else if("OCCUPATION QUESTIONNAIRE_1".equalsIgnoreCase(questionnaire))
					{
						pdfFilepath = new File(filepath
								+ ("/Quotationaries/OCCUPATIONQUESTIONNAIRE-1.jasper"));
						param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
						System.out.println("POL_SYS_ID in premia ------->"+POL_SYS_ID);
					}else if("OCCUPATION QUESTIONNAIRE_2".equalsIgnoreCase(questionnaire))
					{
						pdfFilepath = new File(filepath
								+ ("/Quotationaries/OCCUPATIONQUESTIONNAIRE-2.jasper"));
						param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
						System.out.println("POL_SYS_ID in premia ------->"+POL_SYS_ID);

					}else if("FINANCIALQUESTIONNAIRE SHORTFORM".equalsIgnoreCase(questionnaire))
					{
						pdfFilepath = new File(filepath
								+ ("/Quotationaries/FINANCIALQUESTIONNAIREshortform.jasper"));
						param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));

					}else if("ASTHMA RESPIRATORY DISORDERS".equalsIgnoreCase(questionnaire))
					{
						pdfFilepath = new File(filepath
								+ ("/Quotationaries/Asthma.jasper"));
						param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
						System.out.println("POL_SYS_ID in premia ------->"+POL_SYS_ID);

					}else if("HEALTH DECLARATION ARABICGL".equalsIgnoreCase(questionnaire))
					{
						pdfFilepath = new File(filepath
								+ ("/Quotationaries/HDArabicGL.jasper"));
						param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
						param.put("logo", imgfile.toString() );
						param.put("Name", ArbName);
						param.put("Date", ArbDate);
						param.put("Age", ArbAge);
						param.put("IDCard", ArbIDCard);
						param.put("Occupation", ArbOccupation);
						param.put("Nationality", ArbNationality);
						param.put("BP",ArbBP);
						param.put("WtKg", ArbWtKg);
						param.put("HtCms", ArbHtCms);
						param.put("Hypertension", ArbHypertension);
						param.put("MajorOperations", ArbMajorOperations);
						param.put("Malaria", ArbMalaria);
						param.put("Dysentery", ArbDysentery);
						param.put("Entericfever", ArbEntericfever);
						param.put("Gonorrhoea", ArbGonorrhoea);
						param.put("Syphilis", ArbSyphilis);
						param.put("SkinDiseases", ArbSkinDiseases);
						param.put("Stroke", ArbStroke);
						param.put("SickleCell", ArbSickleCell); 
						param.put("JaundiceHepatitis", ArbJaundiceHepatitis);
						param.put("AnymajorIllness", ArbAnymajorIllness);
						param.put("EpilepsyMigraine",ArbEpilepsyMigraine);
						param.put("PsychiatricProblems",ArbPsychiatricProblems);
						param.put("TB", ArbTB);
						param.put("RenalDisease", ArbRenalDisease);
						param.put("PepticUlcer", ArbPepticUlcer);
						param.put("FORFEMALECANDIDATESONLY", ArbFORFEMALECANDIDATESONLY);
						param.put("Address", ArbAddress);
						param.put("Diabetes", ArbDiabetes);
						param.put("Arthritis", ArbArthritis);
						param.put("Pc", ArbPc);
						param.put("HeartDisease", ArbHeartDisease);
						param.put("Anaemia",ArbAnaemia);
						param.put("Areyoupregnan",ArbAreyoupregnan);
						param.put("Head", ArbHead);
						param.put("Para1", ArbPara1);
						param.put("Para2", ArbPara2);
						param.put("Para3", ArbPara3);
						param.put("Signature", ArbSignature);
						param.put("AsthmaAllergy", ArbAsthmaAllergy);
						param.put("Syphilis", ArbSyphilis);
						param.put("correct1", Arbcorrect1);
						param.put("tick1", Arbtick1);
						param.put("tick2", Arbtick2);
						param.put("tick3",Arbtick3);
						param.put("tick4",Arbtick4);

					}else if("BLOODPRESSURE".equalsIgnoreCase(questionnaire))
					{
						pdfFilepath = new File(filepath
								+ ("/Quotationaries/BloodPressure.jasper"));
						param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
						System.out.println("POL_SYS_ID in premia ------->"+POL_SYS_ID);
						
					}else if("CORONARY ARTERY DISEASE QUESTIONNAIRE".equalsIgnoreCase(questionnaire))
					{
						pdfFilepath = new File(filepath
								+ ("/Quotationaries/CADQUES.jasper"));
						param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
						System.out.println("POL_SYS_ID in premia ------->"+POL_SYS_ID);

					}else if("THYROID QUESTIONNAIRE".equalsIgnoreCase(questionnaire))
					{
						System.out.println("THYROID");
						pdfFilepath = new File(filepath
								+ ("/Quotationaries/Thyroid.jasper"));
						param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));

					}else if("KEYMANINSURANCE QUESTIONNAIRE".equalsIgnoreCase(questionnaire))
					{
						pdfFilepath = new File(filepath
								+ ("/Quotationaries/KEYMANINSURANCEQUESTIONNAIRE.jasper"));
						param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
					}
					
					
					else if("MILITARY AVIATION".equalsIgnoreCase(questionnaire))
					{
						System.out.println("MILITARY AVIATION");
						pdfFilepath = new File(filepath
								+ ("/Quotationaries/military.jasper"));
						param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
					}
					
					else if("STROKE QUESTIONNAIRE".equalsIgnoreCase(questionnaire))
					{
						pdfFilepath = new File(filepath
								+ ("/Quotationaries/Stroke.jasper"));
						param.put("POL_SYS_ID", request.getParameter("POL_SYS_ID"));
					}else if("MEDICALEXAMINATION FORM ".equalsIgnoreCase(questionnaire))
					{
						System.out.println("inside the medical "+questionnaire);
						pdfFilepath = new File(filepath
								+ ("/Quotationaries/Medical Report FIC 2008.jasper"));
						param.put("Name", Name);
						param.put("Occupation", Occupation);
						param.put("Passport", Passport);
						param.put("Address", Address);
						param.put("Age", Age);
						param.put("Nationality", Nationality);
						param.put("Text", Text);
						param.put("TB", TB);
						param.put("MajorOperations", MajorOperations);
						param.put("Malaria", Malaria);
						param.put("Dysentery", Dysentery);
						param.put("EntericFever", EntericFever);
						param.put("Jaundice", Jaundice);
						param.put("Gonorrhoea", Gonorrhoea);
						param.put("Syphillis", Syphillis);
						param.put("SkinDiseases", SkinDiseases);
						param.put("SickleCellAnaemia", SickleCellAnaemia);
						param.put("Stroke", Stroke);
						param.put("Asthma", Asthma);
						param.put("Diabetes", Diabetes);
						param.put("RenalDisease", RenalDisease);
						param.put("Arthritis", Arthritis);
						param.put("AnymajorIllness", AnymajorIllness);
						param.put("Epilepsy", Epilepsy);
						param.put("Psychiatric", Psychiatric);
						param.put("PepticUlcer", PepticUlcer);
						param.put("Anaemia", Anaemia);
				
					
						
						param.put("HeartDisease", HeartDisease);
						param.put("Hypertension", Hypertension);
						param.put("Title1", Title1);
						param.put("Title2", Title2);
						param.put("Static_var3", Static_var3);
						param.put("duration", duration);
						param.put("Problems", Problems);
						param.put("paragraph", paragraph);
						param.put("paragraph1", paragraph1);
						param.put("Signatureoflife", Signatureoflife);
						param.put("SignatureofExaminer", SignatureofExaminer);
						param.put("Date1", Date1);
						param.put("Report", Report);
						param.put("Name2", Name2);
						param.put("Sex", Sex);
						param.put("cm1", cm1);
						param.put("cm2", cm2);
						param.put("weight1", weight1);
						param.put("weight2", weight2);
						param.put("exam", exam);
						param.put("results", results);
						param.put("Rt1", Rt1);
						param.put("Rt2", Rt2);
						param.put("eye", eye);
						param.put("ear", ear);
						param.put("system", system);
						param.put("vascular", vascular);
						param.put("heart", heart);
						param.put("test", test);
						param.put("bp", bp);
						param.put("pulse", pulse);
						param.put("respire", respire);
						param.put("lungs", lungs);
						param.put("gastro", gastro);
						param.put("abdomen", abdomen);
						param.put("liver", liver);
						param.put("spleen", spleen);
						param.put("ascites", ascites);
						param.put("others", others);
						param.put("hernia", hernia);
						param.put("geneto", geneto);
						param.put("kidneys", kidneys);
						param.put("bladder", bladder);
						param.put("testis", testis);
						param.put("PV", PV);
						param.put("skelital", skelital);
						param.put("dental", dental);
						param.put("extremitis", extremitis);
						param.put("deformitis", deformitis);
						param.put("skin", skin);
						param.put("veneral", veneral);
						param.put("clinical", clinical);
						param.put("tick1", tick1);
						param.put("tick2", tick2);
						param.put("tick3", tick3);
						param.put("cross", cross);
						param.put("tick", tick);
						param.put("Dt", Dt);
						param.put("tension", tension);
						param.put("heartdi", heartdi);
						param.put("peptic", peptic);
						param.put("information", information);
						param.put("POL_SYS_ID",POL_SYS_ID);
						System.out.println("inside mecidal POL_SYS_ID -------------->"+POL_SYS_ID);
						
					}	
				}else if(JasperReportName!=null)
				{
					if("Payment".equalsIgnoreCase(JasperReportName))
					{
						System.out.println("Payment");
						pdfFilepath = new File(filepath
								+ ("/FALCONREPORTNEW/Payment.jasper"));
						param.put("POL_SYS_ID", JasperPolSysId);	
					}
					else if("SurrenderValue".equalsIgnoreCase(JasperReportName))
					{
						System.out.println("SurrenderValue");
						pdfFilepath = new File(filepath
								+ ("/FALCONREPORTNEW/Surrender_value_Intimation.jasper"));
						param.put("POL_SYS_ID", JasperPolSysId);
					}
					
					else if("MaturityPayoutReviewSheet".equalsIgnoreCase(JasperReportName))
					{
						System.out.println("inside the MaturityPayoutReviewSheet---->");
						
					
						ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
					       ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
					       ArrayList<String> returnList = new ArrayList<String>();
					       OracleParameter param21 = new OracleParameter("IN1","INT","IN",JasperPolSysId);
					       parameterList.add(param21);
					       OracleProcedureHandler procHandler = new OracleProcedureHandler();
					       outputList = procHandler.execute(parameterList, con,
					               "P_PROC_SURR_CALC");
					       con.commit();
					       Iterator<OracleParameter> iterator = outputList.iterator();
					       while (iterator.hasNext()) {
					    	   System.out.println("Call procedure");
					           OracleParameter oracleParameter = iterator.next();
					           System.out.println("Output value:::" + oracleParameter.getValue());
					           returnList.add(oracleParameter.getValue());
					       }
					       pdfFilepath = new File(filepath
									+ ("/FALCONREPORTNEW/MATURITY_PAYOUT_REVIEW_SHEET.jasper"));
							param.put("POL_SYS_ID", JasperPolSysId);
					}
					
					
					else if("SURRENDERREVIEWSHEET".equalsIgnoreCase(JasperReportName))
					{
                       /* String  Pol_Sys_id=null;
						ResultSet resultSet = null;*/
						/*CRUDHandler handler = new CRUDHandler();	*/
						/*String query = "SELECT pol_sys_id FROM PT_IL_POLICY where pol_no='"+JasperPolSysId+"'";
						System.out.println("query exe sucess"+query);	     
						resultSet = new CRUDHandler().executeSelectStatement(query, con);
						System.out.println("value for insert"+	handler.executeSelectStatement(query, con));
						while (resultSet.next()) {
							Pol_Sys_id=resultSet.getString("Pol_Sys_id");

						}*/
						System.out.println("value of Pol_Sys_id"+JasperPolSysId);
						ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
					       ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
					       ArrayList<String> returnList = new ArrayList<String>();
					       OracleParameter param111 = new OracleParameter("IN1","INT","IN",JasperPolSysId);
					       parameterList.add(param111);
					       OracleProcedureHandler procHandler = new OracleProcedureHandler();
					       outputList = procHandler.execute(parameterList, con,
					               "P_PROC_SURR_CALC");
					       con.commit();
					       Iterator<OracleParameter> iterator = outputList.iterator();
					       while (iterator.hasNext()) {
					    	   System.out.println("Call procedure");
					           OracleParameter oracleParameter = iterator.next();
					           System.out.println("Output value:::" + oracleParameter.getValue());
					           returnList.add(oracleParameter.getValue());
					       }
						pdfFilepath = new File(filepath
								+ ("/FALCONREPORTNEW/SURRENDER_CALCULATION.jasper"));
						param.put("Pol_Sys_id",JasperPolSysId);
						System.out.println("file path of SURRENDERREVIWSHEET "+pdfFilepath);
						System.out.println("param 2        "+param);
					}
					
					else if("PAIDUPREVIEWSHEET".equalsIgnoreCase(JasperReportName))
					{
						System.out.println("SurrenderValue");
						
						/* ResultSet resultSet = null;*/
							/*	String POL_Num=null;*/
								/*CRUDHandler handler = new CRUDHandler();	
								String query = "SELECT pol_sys_id FROM PT_IL_POLICY where pol_no='"+JasperPolSysId+"'";
								System.out.println("query exe sucess"+query);	     
								resultSet = new CRUDHandler().executeSelectStatement(query, con);
								System.out.println("value for insert"+	handler.executeSelectStatement(query, con));
								while (resultSet.next()) {
									Pol_Sys_id=resultSet.getString("Pol_Sys_id");

								}*/
								System.out.println("value of Pol_Sys_id"+JasperPolSysId);
								ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
							       ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
							       ArrayList<String> returnList = new ArrayList<String>();
							       OracleParameter param21 = new OracleParameter("IN1","INT","IN",JasperPolSysId);
							       parameterList.add(param21);
							       OracleProcedureHandler procHandler = new OracleProcedureHandler();
							       outputList = procHandler.execute(parameterList, con,
							               "P_PROC_SURR_CALC");
							       con.commit();
							       Iterator<OracleParameter> iterator = outputList.iterator();
							       while (iterator.hasNext()) {
							    	   System.out.println("Call procedure");
							           OracleParameter oracleParameter = iterator.next();
							           System.out.println("Output value:::" + oracleParameter.getValue());
							           returnList.add(oracleParameter.getValue());
							       }
								pdfFilepath = new File(filepath
										+ ("/FALCONREPORTNEW/SURRENDERPAIDUP.jasper"));
						               param.put("Pol_Sys_id",JasperPolSysId);
					}
					
					
					
					else if("MaturityNotice".equalsIgnoreCase(JasperReportName))
					{				
						System.out.println("MaturityNotice");
						pdfFilepath = new File(filepath
								+ ("/FALCONREPORTNEW/Maturity Reminder.jasper"));
						param.put("POL_SYS_ID", JasperPolSysId);	
					}
					else if("SurrenderDischargeForm".equalsIgnoreCase(JasperReportName))
					{
						System.out.println("LifeAssrSurrDischarge");
						pdfFilepath = new File(filepath
								+ ("/FALCONREPORTNEW/LIFEASSURANCE.jasper"));
						param.put("POL_SYS_ID", JasperPolSysId);
						param.put("sentance1",resourceBundle.getString("LA_SENTENCE1"));
						param.put("sentance2",resourceBundle.getString("LA_SENTENCE2"));
						param.put("sentance3",resourceBundle.getString("LA_SENTENCE3"));

					}
					else if("MaturityDischargeForm".equalsIgnoreCase(JasperReportName))
					{
						System.out.println("LifeAssMaturityDischarge");
						pdfFilepath = new File(filepath
								+ ("/FALCONREPORTNEW/MaturityDischargeForm.jasper"));
						param.put("POL_SYS_ID", JasperPolSysId);
					
						
						/*param.put("SENTANCE1",resourceBundle.getString("SENTENCE1"));
						param.put("SENTANCE2",resourceBundle.getString("SENTENCE2"));
						param.put("SENTANCE3",resourceBundle.getString("SENTENCE3"));*/


					}
					/*Added By janani 24.5.2016*/
					else if("ClaimDischargeForm".equalsIgnoreCase(JasperReportName))
					{
						System.out.println("ClaimDischargeForm");
						/*Modified by Saritha on 27.11.2016
						 * 
						 * pdfFilepath = new File(filepath
								+ ("/FALCONREPORTNEW/ClaimDischargeForm.jasper"));*/
						 
						
						pdfFilepath = new File(filepath
								+ ("/SurrenderMaturity/ClaimDischargeForm.jasper"));

						 /*End	*/
						param.put("POL_SYS_ID", JasperPolSysId);
						param.put("SENTANCE1",resourceBundle.getString("SENTENCE1"));
						param.put("SENTANCE2",resourceBundle.getString("SENTENCE2"));
						param.put("SENTANCE3",resourceBundle.getString("SENTENCE3"));


					}
					//end
				}else
				{
					System.out.println("Report name Empty");	
					Rep_id = request.getParameter("REP_ID");   
					String Rep_name=request.getParameter("REP_Name");   

					if(Rep_id != null)
					{

						//ADDED BY RAM FOR FALCONPOLICY SCHEDULE ON 16.3.2016

						if(Rep_id.equals("P11_PILS_001"))
						{

							pdfFilepath = new File(filepath
									+ ("/FalconPolicySchedule.jasper"));
							param.put("POL_SYS_ID", request.getParameter("Pol_sys_id"));

						 
							//added by nathiya on 18.3.2016 for quotation letter


							String type = request.getParameter("Type");
							System.out.println("Report Type        "+type);
							if(type != null)
							{
								if(type.equals("Q"))
								{
									pdfFilepath = new File(filepath
											+ ("/Quotation_letter.jasper"));
									param.put("POL_SYS_ID", request.getParameter("Pol_sys_id"));	
								}
								else if(type.equals("P"))
								{
									pdfFilepath = new File(filepath
											+ ("/FalconPolicySchedule.jasper"));
									param.put("POL_SYS_ID", request.getParameter("Pol_sys_id"));	
								} 
							}

						}
						//END

						else if(Rep_id.equals("PILR_LET_FN"))
						{
							System.out.println("Welcome to Fund Statement");
							pdfFilepath = new File(filepath
									+ ("/FundStatement.jasper"));
							param.put("Pol_sys_id", request.getParameter("Pol_sys_id"));
						}
						else if(Rep_id.equals("PILR_REC001"))
						{
							pdfFilepath = new File(filepath
									+ ("/PremiumReceipt.jasper"));
							param.put("POL_SYS_ID_PARAM", request.getParameter("POL_SYS_ID_PARAM"));

						}
						else if(Rep_id.equals("PGLR004A"))
						{
							pdfFilepath = new File(filepath
									+ ("/DebitNote.jasper"));
							param.put("DRCR_POL_SYS_ID", request.getParameter("POL_SYS_ID"));
							param.put("DRCR_END_NO_IDX", request.getParameter("END_NO_IDX"));
						}
						else if(Rep_id.equals("PGLR_PRO_C"))
						{
							pdfFilepath = new File(filepath
									+ ("/Proforma_Debit_Note.jasper"));
							param.put("DRCR_POL_SYS_ID", request.getParameter("POL_SYS_ID"));
						}

						//added by raja on 18.3.2016


						else if(Rep_id.equals("P11_PILS_032"))
						{

							pdfFilepath = new File(filepath
									+ ("/FalconQuestionaires/Endorsement.jasper"));
							param.put("POLH_SYS_ID", request.getParameter("P_POL_SYS_ID"));
							param.put("END_NO_IDX", request.getParameter("P_POL_END_NO_IDX"));

						}

						//added for ri bordeox
						else if(Rep_id.equals("P11_PILR_036"))
						{


							ArrayList<String> list1 = new ArrayList<String>();		
							INPUT_BEAN ip5= new INPUT_BEAN();
							ip =select(request.getParameter("REP_ID"),request.getParameter("REP_KEY"),con);
							String RepID=request.getParameter("REP_ID");
							String RepKeyNo=request.getParameter("REP_KEY");
							String P_PRODUCT_FM= ip.getREP_VALUE_1();
							String P_PRODUCT_TO= ip.getREP_VALUE_2();
							String P_DIVN_FM= ip.getREP_VALUE_3();
							String P_DIVN_TO= ip.getREP_VALUE_4();
							String P_CUST_FM = ip.getREP_VALUE_5();
							String P_CUST_TO = ip.getREP_VALUE_6();
							String P_DATE_FM= ip.getREP_VALUE_7();
							String P_DATE_TO= ip.getREP_VALUE_8();
							
							//formating date into commonutil date format
							SimpleDateFormat RIsdf = new SimpleDateFormat("dd-MMM-yyyy");
							//String fmt_P_DATE_FM=RIsdf.format(new SimpleDateFormat("dd/MM/yyyy").parse(P_DATE_FM));
							Date ddfm = new SimpleDateFormat("dd/MM/yyyy").parse(P_DATE_FM);
							String fmt_P_DATE_FM = CommonUtils.dateToStringFormatter(ddfm);
							System.out.println("fmt_P_DATE_FM =====>>>>"+fmt_P_DATE_FM);
							//String fmt_P_DATE_TO=RIsdf.format(new SimpleDateFormat("dd/MM/yyyy").parse(P_DATE_TO));
							Date ddto = new SimpleDateFormat("dd/MM/yyyy").parse(P_DATE_TO);
							String fmt_P_DATE_TO=CommonUtils.dateToStringFormatter(ddto);
							System.out.println("fmt_P_DATE_FM =====>>>>"+fmt_P_DATE_TO);
							//end
							
							list1=P_RI_BORD_REG(P_PRODUCT_FM, P_PRODUCT_TO, P_DIVN_FM,
									P_DIVN_TO,P_CUST_FM,P_CUST_TO,P_DATE_FM, P_DATE_TO,
									con);
							
							/*list1=P_RI_BORD_REG(P_PRODUCT_FM, P_PRODUCT_TO, P_DIVN_FM,
									P_DIVN_TO,P_CUST_FM,P_CUST_TO,fmt_P_DATE_FM, fmt_P_DATE_TO,
									con);*/
							 excelPath = writeStudentsListToExcel(list1,con);
							
							/*	pdfFilepath = new File(filepath
									+ ("/Cheque Dishonoured.jasper"));*/

							/*pdfFilepath = new File(filepath
									+ ("/RI_Borderex.jasper"));


							
							System.out.println("*test sysout         "+P_SEQ_VAL);
							
							param.put("P_SEQ_VAL",P_SEQ_VAL);//P_SEQ_VAL
							param.put("P_TOT_BAS_ORG_SA",P_TOT_BAS_ORG_SA);
							param.put("P_TOT_BAS_CURR_SA",P_TOT_BAS_CURR_SA);
							param.put("P_TOT_BAS_RI_SA",P_TOT_BAS_RI_SA);
							param.put("P_TOT_BAS_LOAD",P_TOT_BAS_LOAD);
							param.put("P_TOT_BAS_RATE",P_TOT_BAS_RATE);
							param.put("P_TOT_BAS_RI_PREM",P_TOT_BAS_RI_PREM);
							param.put("P_TOT_ATA_CURR_SA",P_TOT_ATA_CURR_SA);
							param.put("P_TOT_ATA_RI_SA",P_TOT_ATA_RI_SA);
							param.put("P_TOT_ATA_RATE",P_TOT_ATA_RATE);
							param.put("P_TOT_ATA_RI_PREM",P_TOT_ATA_RI_PREM);
						        param.put("P_TOT_PTD_CURR_SA",P_TOT_PTD_CURR_SA);
							param.put("P_TOT_PTD_RI_SA",P_TOT_PTD_RI_SA);
							param.put("P_TOT_PTD_LOAD",P_TOT_PTD_LOAD);
							param.put("P_TOT_PTD_RATE",P_TOT_PTD_RATE);
							param.put("P_TOT_PTD_RI_PREM",P_TOT_PTD_RI_PREM);
							param.put("P_TOT_PPD_CURR_SA",P_TOT_PPD_CURR_SA);
							param.put("P_TOT_PPD_RI_SA",P_TOT_PPD_RI_SA);
							param.put("P_TOT_PPD_RATE",P_TOT_PPD_RATE);
							param.put("P_TOT_PPD_RI_PREM",P_TOT_PPD_RI_PREM);
							param.put("P_TOT_ADB_CURR_SA",P_TOT_ADB_CURR_SA);
							param.put("P_TOT_ADB_RI_SA",P_TOT_ADB_RI_SA);
							param.put("P_TOT_ADB_RATE",P_TOT_ADB_RATE);
							param.put("P_TOT_ADB_RI_PREM",P_TOT_ADB_RI_PREM);
							param.put("P_TOT_PA_CURR_SA",P_TOT_PA_CURR_SA);
							param.put("P_TOT_PA_RI_SA",P_TOT_PA_RI_SA);
							param.put("P_TOT_PA_RATE",P_TOT_PA_RATE);
							param.put("P_TOT_PA_RI_PREM",P_TOT_PA_RI_PREM);
							param.put("P_TOT_RI_SUM",P_TOT_RI_SUM);*/
						}

					//	end

					}
				}

				String Pol_Sys_id=null;
				String SURRENDERREVIWSHEET =request.getParameter("SURRENDERREVIWSHEET");
				String PAIDUPREVIWSHEET=request.getParameter("PAIDUPREVIWSHEET");
				if(SURRENDERREVIWSHEET!=null)
				{
				  
							ResultSet resultSet = null;
							CRUDHandler handler = new CRUDHandler();	
							String query = "SELECT pol_sys_id FROM PT_IL_POLICY where pol_no='"+SMV_POL_NO+"'";
							System.out.println("query exe sucess"+query);	     
							resultSet = new CRUDHandler().executeSelectStatement(query, con);
							System.out.println("value for insert"+	handler.executeSelectStatement(query, con));
							while (resultSet.next()) {
								Pol_Sys_id=resultSet.getString("Pol_Sys_id");

							}
							System.out.println("value of Pol_Sys_id"+Pol_Sys_id);
							ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
						       ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
						       ArrayList<String> returnList = new ArrayList<String>();
						       OracleParameter param111 = new OracleParameter("IN1","INT","IN",Pol_Sys_id);
						       parameterList.add(param111);
						       OracleProcedureHandler procHandler = new OracleProcedureHandler();
						       outputList = procHandler.execute(parameterList, con,
						               "P_PROC_SURR_CALC");
						       con.commit();
						       Iterator<OracleParameter> iterator = outputList.iterator();
						       while (iterator.hasNext()) {
						    	   System.out.println("Call procedure");
						           OracleParameter oracleParameter = iterator.next();
						           System.out.println("Output value:::" + oracleParameter.getValue());
						           returnList.add(oracleParameter.getValue());
						       }
							pdfFilepath = new File(filepath
									+ ("/FALCONREPORTNEW/SURRENDER_CALCULATION.jasper"));
							param.put("Pol_Sys_id",Pol_Sys_id);
							System.out.println("file path of SURRENDERREVIWSHEET "+pdfFilepath);
							System.out.println("param  3       "+param);

						}else if(PAIDUPREVIWSHEET!=null)
					{
					  
						 ResultSet resultSet = null;
						/*	String POL_Num=null;*/
							CRUDHandler handler = new CRUDHandler();	
							String query = "SELECT pol_sys_id FROM PT_IL_POLICY where pol_no='"+SMV_POL_NO+"'";
							System.out.println("query exe sucess"+query);	     
							resultSet = new CRUDHandler().executeSelectStatement(query, con);
							System.out.println("value for insert"+	handler.executeSelectStatement(query, con));
							while (resultSet.next()) {
								Pol_Sys_id=resultSet.getString("Pol_Sys_id");

							}
							System.out.println("value of Pol_Sys_id"+Pol_Sys_id);
							ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
						       ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
						       ArrayList<String> returnList = new ArrayList<String>();
						       OracleParameter param21 = new OracleParameter("IN1","INT","IN",Pol_Sys_id);
						       parameterList.add(param21);
						       OracleProcedureHandler procHandler = new OracleProcedureHandler();
						       outputList = procHandler.execute(parameterList, con,
						               "P_PROC_SURR_CALC");
						       con.commit();
						       Iterator<OracleParameter> iterator = outputList.iterator();
						       while (iterator.hasNext()) {
						    	   System.out.println("Call procedure");
						           OracleParameter oracleParameter = iterator.next();
						           System.out.println("Output value:::" + oracleParameter.getValue());
						           returnList.add(oracleParameter.getValue());
						       }
							pdfFilepath = new File(filepath
									+ ("/FALCONREPORTNEW/SURRENDERPAIDUP.jasper"));
							param.put("Pol_Sys_id",Pol_Sys_id);
							System.out.println("file path of PAIDUPREVIWSHEET "+pdfFilepath);
					
					}
					 	
					//End
				
		System.out.println("pdfFilepath");
		if(pdfFilepath != null)
		{System.out.println(pdfFilepath);
		/*Added by Ameen for Policy Scgedule Merge Report 23-10-2016*/
		System.out.println(pdfFilepath2);
		System.out.println(pdfFilepath3);
		/*end*/
		/*added by dhinesh on 16.3.2016 for questionnaire report*/

		/*
		 * commented by Ameen for Policy Scgedule Merge Report 23-10-2016
		 * JasperReport jr = (JasperReport) JRLoader.loadObject(pdfFilepath);
		JasperReport jr2 = (JasperReport) JRLoader.loadObject(pdfFilepath2);*/
		/*Added by Ameen for Policy Scgedule Merge Report 23-10-2016*/
		
		/*Added by Ram on 28/12/2016 for add cover letter in Policy document*/
		JasperReport jrTop = null;
		/*End*/
		
		JasperReport jr = null;
		JasperReport jr2 = null;
		JasperReport jr3 = null;
		
		/*Added by Ram on 26/11/2016 for PPD Cover addition*/
		JasperReport jr4 = null;
		/*End*/
		
		/*Added by Ram on 28/12/2016 for add cover letter in Policy document*/
		JasperPrint jpTop=null;
		/*End*/
		
		JasperPrint jp=null;
		JasperPrint jp2=null;
		JasperPrint jp3=null;
		
		/*Added by Ram on 26/11/2016 for PPD Cover addition*/
		JasperPrint jp4=null;
		/*End*/
		System.out.println("PolicyScheduleReport       "+PolicyScheduleReport);
		if(PolicyScheduleReport!=null){
			
			/*Added by Ram on 28/12/2016 for add cover letter in Policy document*/
			jrTop = (JasperReport) JRLoader.loadObject(pdfFilepathTop);
			/*End*/
			
			jr = (JasperReport) JRLoader.loadObject(pdfFilepath);
			
			/*Commented by Ram on 02/01/2017*/
/*			jr2 = (JasperReport) JRLoader.loadObject(pdfFilepath2);
			jr3 = (JasperReport) JRLoader.loadObject(pdfFilepath3);*/
			/*End*/
			
			/*Added by Ram on 26/11/2016 for PPD Cover addition*/
			jr4 = (JasperReport) JRLoader.loadObject(pdfFilepath4);
			/*End*/
			
		}else{
			jr = (JasperReport) JRLoader.loadObject(pdfFilepath);
		}
		/*end*/
		//if((questionnaire!=null)||(PolicyScheduleArabic!=null))
		int PPDACoverCount = 0;
		if((PolicyScheduleArabic!=null)){
			JRBeanCollectionDataSource jbs = new JRBeanCollectionDataSource(null);
			jp = JasperFillManager.fillReport(jr,param, new JREmptyDataSource());
		}else{
			
			
			String PPDAquery = " SELECT * FROM PT_IL_POLICY,PT_IL_POL_ADDL_COVER "
            		+ "WHERE POL_SYS_ID = POAC_POL_SYS_ID AND POL_SYS_ID = ? AND POAC_COVER_CODE LIKE 'PPD%'";
            
            ResultSet ppdRS = new CRUDHandler().executeSelectStatement(PPDAquery, con,new Object[]{POL_SYS_ID});
            while(ppdRS.next())
            {
            	PPDACoverCount++;
            }
            
			/*Added by Ram on 28/12/2016 for add cover letter in Policy document*/
			if(PolicyScheduleReport!=null)
			{
			
			jpTop = JasperFillManager.fillReport(jrTop, param, con);
			
			int jpTop_pages=jpTop.getPages().size();
			System.out.println("Top report size :::::"+jpTop_pages);
			param.put("PAGE_NO", jpTop_pages);
			/*End*/
			jp = JasperFillManager.fillReport(jr, param, con);
			/*Added by Ameen for Policy Scgedule Merge Report 23-10-2016*/
			if(PolicyScheduleReport!=null){
				
				int jp_pages=jp.getPages().size();
				
				/*Modified by Ram on 28/12/2016 for Add Coverletter in Policy Document*/
			 
				
				/*int jp3_pages=0;
				 
				jp3_pages=jpTop_pages+jp_pages;
				End
				System.out.println("jp3_pages = "+jp3_pages);
				param.put("PAGE_NO", jp3_pages);
				jp3 = JasperFillManager.fillReport(jr3, param, con);
				
				System.out.println("jp_pages2 INPUT :::::"+jpTop_pages+jp_pages+jp3.getPages().size());
				Modified by Ram on 28/12/2016 for Add Coverletter in Policy Document
				param.put("PAGE_NO", (jpTop_pages+jp_pages+jp3.getPages().size()));
				End
				jp2 = JasperFillManager.fillReport(jr2, param, con);
				
				int jp2_pages=jp2.getPages().size();
				System.out.println("jp2_pages    "+jp2_pages);
				
				jp3_pages = jp3.getPages().size();*/
				int jp4_pages=jpTop_pages+jp_pages;
				
				
				param.put("PAGE_NO", jp4_pages);
				jp4 = JasperFillManager.fillReport(jr4, param, con);
				
				System.out.println("jp4.getPages().size()  "+jp4.getPages().size());
			}
			
		}
			else
			{
				jp = JasperFillManager.fillReport(jr,param, con);
			}
			/*end*/
		}
						
			if(jp.getPages() != null && jp.getPages().size() == 0)
			{
				RequestDispatcher dis = request.getRequestDispatcher("/jsf/error/noRecordFound.xhtml");
				dis.forward(request, response);	
			}
			else
			{
				ba1 = JasperExportManager.exportReportToPdf(jp);
				
				System.out.println("ba1        : "+ba1);
				
				// set pdf content
				response.setContentType("application/pdf");
				
				/*
				 * commented by Ameen for Policy Schedule Merge Report 23-10-2016
				 * BufferedOutputStream fos1 = new BufferedOutputStream(response
						.getOutputStream());
				fos1.write(ba1);
				fos1.flush();
				fos1.close();*/
				
				if(PolicyScheduleReport!=null){
					
					System.out.println("POLICY SCHEDULE REPORT APPEND IF");
					
					/*Added by Ram on 28/12/2016 for add cover letter in Policy document*/
					baTop = JasperExportManager.exportReportToPdf(jpTop);
					/*End*/
					
					/*ba2 = JasperExportManager.exportReportToPdf(jp2);
					ba3 = JasperExportManager.exportReportToPdf(jp3);*/
					
					 /*Added by Ram on 26/11/2016 for PPD Cover addition*/
					ba4 = JasperExportManager.exportReportToPdf(jp4);
					/*End*/
					
					/*System.out.println("ba2        : "+ba2);
					System.out.println("ba3        : "+ba3);*/
					byte[] pol_scld_rep = null;
					List<InputStream> list = new ArrayList<InputStream>();
					
					/*Added by Ram on 28/12/2016 for add cover letter in Policy document*/
					InputStream bbaTop = new ByteArrayInputStream(baTop);
					/*End*/
					
					InputStream bba1 = new ByteArrayInputStream(ba1);
		        	/*InputStream bba2 = new ByteArrayInputStream(ba2);
		        	InputStream bba3 = new ByteArrayInputStream(ba3);*/
		        	  /*Added by Ram on 26/11/2016 for PPD Cover addition*/
		        	InputStream bba4 = new ByteArrayInputStream(ba4);
		        	/*End*/
		        	
		        	/*Added by Ram on 28/12/2016 for add cover letter in Policy document*/
		        	list.add(bbaTop);
		        	/*End*/
		        	
		        	list.add(bba1);
		        	/*list.add(bba3);
		            list.add(bba2);*/
		            /*Added by Ram on 26/11/2016 for PPD Cover addition*/
		            if(PPDACoverCount > 0)
		            {
		            	 list.add(bba4);	
		            }
		           
		            /*End*/
		            
		             
		            
		            OutputStream out = new ByteArrayOutputStream();
		             
		            doMerge(list, out);
		            ByteArrayOutputStream bos = (ByteArrayOutputStream)out;
					pol_scld_rep = bos.toByteArray();
					/*fos1.write(list);//write(list);
					fos1.flush();
					fos1.close();*/
					BufferedOutputStream fos1 = new BufferedOutputStream(response
							.getOutputStream());
					fos1.write(pol_scld_rep);//write(list);
					fos1.flush();
					fos1.close();
					System.out.println("END APPEND IF");
				}else{
					
					BufferedOutputStream fos1 = new BufferedOutputStream(response
							.getOutputStream());
					fos1.write(ba1);
					fos1.flush();
					fos1.close();
				}
				
				/*BufferedOutputStream fos1 = new BufferedOutputStream(response
						.getOutputStream());*/
				
				// ObjectOutputStream out = new ObjectOutputStream(response.getOutputStream());
				//out.writeObject(list);
				
			}}else if(Rep_id!=null && Rep_id.equals("P11_PILR_036")){
			if(excelPath!=null && !excelPath.equals("")){
				System.out.println("Dhinesh 9876");
				File file = new File(excelPath);
				FileInputStream fileInputStream=null;

		        File excelfile = new File("D:\\testing.xls");

		        byte[] bFile = new byte[(int) file.length()];

		            //convert file into array of bytes
			    fileInputStream = new FileInputStream(file);
			    fileInputStream.read(bFile);
			    fileInputStream.close();


				FileOutputStream fos = new FileOutputStream("D:/TEST.xls");
				fos.write(bFile);
				fos.close();
				
				if (response != null) {
					response.setHeader("Content-disposition", "attachment;filename=RI-BORDERAX.xls");
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
		
			}
			catch (Exception e) {
				e.printStackTrace();
			}

		}
	}



	/*Added by Jagadeesh*/

	public static INPUT_BEAN select(String Rep_id,String Rep_key,Connection con)throws Exception{
		System.out.println("entering into the select Method ");
		INPUT_BEAN ip= new INPUT_BEAN();
		System.out.println("BEAN OBJECT"+ip);
		try {
			System.out.println("Rep_id     : "+Rep_id);
			System.out.println("Rep_key    : "+Rep_key);
			
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
				
				/*Added by Saranya 31.5.2016*/

				ip.setREP_VALUE_7(rs.getString("REP_VALUE_7"));
				ip.setREP_VALUE_8(rs.getString("REP_VALUE_8"));
				
				/*End*/
			}
			
			System.out.println("ip.getREP_VALUE_1   : "+ip.getREP_VALUE_1());

		} catch (Exception e) {
			e.printStackTrace();

		}
		return ip;

	}

	/*End*/


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(request, response);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*ADDED BY GOPI*/
	public static INPUT_BEAN selectValues(String Rep_id,String Rep_key,Connection con)throws Exception{
		System.out.println("**************************entering into the selectValues***********************");
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
				//ip.setREP_VALUE_7(rs.getString("REP_VALUE_7"));
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		System.out.println("****************output of selectValues************"+ip);
		return ip;

	}
	/*ADDED BY GOPI FOR MATURITY NOTICE */
	public void callmaturitynoticeprocedure(String startdate,String expiredate,
			String divisionfm ,String divisionto,
			String productfm, String productto,Connection con) throws Exception {    
		
	
		try {
			System.out.println("*************Enter the  callDemo  Block*****************");
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("IN1", "DATE", "IN",startdate);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("IN2", "DATE", "IN",expiredate);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",divisionfm);
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",divisionto);
		parameterList.add(param4);
		OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",productfm);
		parameterList.add(param5);
		OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",productto);
		parameterList.add(param6);
	    OracleProcedureHandler procHandler = new OracleProcedureHandler();
	    outputList = procHandler.execute(parameterList, con,"P_IL_PREM_MAT");
	    con.commit();
	    Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out
					.println("Output value:" + oracleParameter.getValue());
		}
	   	   
		} catch (DBException e) {
			e.printStackTrace();
		}	
	}
	//added for RI bordeoux
	public ArrayList<String>  P_RI_BORD_REG(String P_PRODUCT_FM,String P_PRODUCT_TO, String P_DIVN_FM,
			String P_DIVN_TO,String P_CUST_FM,String P_CUST_TO,String P_DATE_FM, String P_DATE_TO,
			Connection con) throws Exception {    
		ArrayList<String> parameterList1 = new ArrayList<String>();
		try {
			String P_SEQ_VAL="";
			String P_TOT_BAS_ORG_SA="";
			String P_TOT_BAS_CURR_SA="";
			String P_TOT_BAS_RI_SA="";
			String P_TOT_BAS_LOAD="";
			String P_TOT_BAS_RATE ="";
			String P_TOT_BAS_RI_PREM="";
			String P_TOT_ATA_CURR_SA="";
			String P_TOT_ATA_RI_SA="";
			String P_TOT_ATA_RATE="";
			String P_TOT_ATA_RI_PREM="";
			String P_TOT_PTD_CURR_SA ="";
			String P_TOT_PTD_RI_SA ="";
			String P_TOT_PTD_LOAD="";
			String P_TOT_PTD_RATE="";
			String P_TOT_PTD_RI_PREM="";
			String P_TOT_PPD_CURR_SA="";
			String P_TOT_PPD_RI_SA="";
			String P_TOT_PPD_RATE="";
			String P_TOT_PPD_RI_PREM="";
			String P_TOT_ADB_CURR_SA="";
			String P_TOT_ADB_RI_SA="";
			String P_TOT_ADB_RATE="";
			String P_TOT_ADB_RI_PREM="";
			String P_TOT_PA_CURR_SA="";
			String P_TOT_PA_RI_SA="";
			String P_TOT_PA_RATE="";
			String P_TOT_PA_RI_PREM ="";
			String P_TOT_RI_SUM ="";


			System.out.println("P_PRODUCT_FM    : "+P_PRODUCT_FM);
			System.out.println("P_PRODUCT_TO    : "+P_PRODUCT_TO);
			System.out.println("P_DIVN_FM       : "+P_DIVN_FM);
			System.out.println("P_DIVN_TO       : "+P_DIVN_TO);
			System.out.println("P_CUST_FM       : "+P_CUST_FM);
			System.out.println("P_CUST_TO       : "+P_CUST_TO);
			System.out.println("P_DATE_FM       : "+P_DATE_FM);
			System.out.println("P_DATE_TO       : "+P_DATE_TO);


			ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
			ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PRODUCT_FM);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_PRODUCT_TO);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_DIVN_FM);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_DIVN_TO);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_CUST_FM);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_CUST_TO);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_DATE_FM);
			OracleParameter param8 = new OracleParameter("IN8", "STRING", "IN",P_DATE_TO);
			OracleParameter param9 = new OracleParameter("OUT1", "INT", "OUT",P_SEQ_VAL);
			OracleParameter param10 = new OracleParameter("OUT2", "DOUBLE", "OUT",P_TOT_BAS_ORG_SA);
			OracleParameter param11 = new OracleParameter("OUT3", "DOUBLE","OUT",P_TOT_BAS_CURR_SA);
			OracleParameter param12 = new OracleParameter("OUT4", "DOUBLE", "OUT",P_TOT_BAS_RI_SA);
			OracleParameter param13 = new OracleParameter("OUT5", "DOUBLE", "OUT",P_TOT_BAS_LOAD);
			OracleParameter param14 = new OracleParameter("OUT6", "DOUBLE", "OUT",P_TOT_BAS_RATE);
			OracleParameter param15 = new OracleParameter("OUT7", "DOUBLE", "OUT",P_TOT_BAS_RI_PREM);
			OracleParameter param16 = new OracleParameter("OUT8", "DOUBLE", "OUT",P_TOT_ATA_CURR_SA);
			OracleParameter param17 = new OracleParameter("OUT9", "DOUBLE", "OUT",P_TOT_ATA_RI_SA);
			OracleParameter param18 = new OracleParameter("OUT10", "DOUBLE", "OUT",P_TOT_ATA_RATE);
			OracleParameter param19 = new OracleParameter("OUT11", "DOUBLE", "OUT",P_TOT_ATA_RI_PREM);
			OracleParameter param20 = new OracleParameter("OUT12", "DOUBLE", "OUT",P_TOT_PTD_CURR_SA);
			OracleParameter param21 = new OracleParameter("OUT13", "DOUBLE", "OUT",P_TOT_PTD_RI_SA);
			OracleParameter param22 = new OracleParameter("OUT14", "DOUBLE", "OUT",P_TOT_PTD_LOAD);
			OracleParameter param23 = new OracleParameter("OUT15", "DOUBLE", "OUT",P_TOT_PTD_RATE);
			OracleParameter param24 = new OracleParameter("OUT16", "DOUBLE", "OUT",P_TOT_PTD_RI_PREM);
			OracleParameter param25 = new OracleParameter("OUT17", "DOUBLE", "OUT",P_TOT_PPD_CURR_SA);
			OracleParameter param26 = new OracleParameter("OUT18", "DOUBLE", "OUT",P_TOT_PPD_RI_SA);
			OracleParameter param27 = new OracleParameter("OUT19", "DOUBLE", "OUT",P_TOT_PPD_RATE);
			OracleParameter param28 = new OracleParameter("OUT20", "DOUBLE", "OUT",P_TOT_PPD_RI_PREM);
			OracleParameter param29 = new OracleParameter("OUT21", "DOUBLE", "OUT",P_TOT_ADB_CURR_SA);
			OracleParameter param30 = new OracleParameter("OUT22", "DOUBLE", "OUT",P_TOT_ADB_RI_SA);
			OracleParameter param31 = new OracleParameter("OUT23", "DOUBLE", "OUT",P_TOT_ADB_RATE);
			OracleParameter param32 = new OracleParameter("OUT24", "DOUBLE", "OUT",P_TOT_ADB_RI_PREM);
			OracleParameter param33 = new OracleParameter("OUT25", "DOUBLE", "OUT",P_TOT_PA_CURR_SA);
			OracleParameter param34 = new OracleParameter("OUT26", "DOUBLE", "OUT", P_TOT_PA_RI_SA);
			OracleParameter param35 = new OracleParameter("OUT27", "DOUBLE", "OUT",P_TOT_PA_RATE);
			OracleParameter param36 = new OracleParameter("OUT28", "DOUBLE", "OUT",P_TOT_PA_RI_PREM);
			OracleParameter param37 = new OracleParameter("OUT29", "DOUBLE", "OUT",P_TOT_RI_SUM);


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
			parameterList.add(param12);
			parameterList.add(param13);
			parameterList.add(param14);
			parameterList.add(param15);
			parameterList.add(param16); 
			parameterList.add(param17);
			parameterList.add(param18);
			parameterList.add(param19);
			parameterList.add(param20);
			parameterList.add(param21);
			parameterList.add(param22);
			parameterList.add(param23); 
			parameterList.add(param24); 
			parameterList.add(param25);
			parameterList.add(param26); 
			parameterList.add(param27);    
			parameterList.add(param28); 
			parameterList.add(param29);
			parameterList.add(param30);
			parameterList.add(param31);
			parameterList.add(param32);
			parameterList.add(param33);
			parameterList.add(param34);
			parameterList.add(param35);
			parameterList.add(param36);
			parameterList.add(param37);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, con,
					"P_RI_BORD_REG");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while (iterator.hasNext()) {
				OracleParameter oracleParameter = iterator.next();
				parameterList1.add(oracleParameter.getValue());
			}


		} catch (DBException e) {
			e.printStackTrace();
		}
		return parameterList1;

	}
/*Modified by Ram on 21/12/2016 for NullPointer Exception in CommonUtils Constructor*/
	public String Decimal_Convert(String Value)
	{
		
		System.out.println(" Decimal_Convert  value  :  "+Value);
		if(Value != null && Double.parseDouble(Value)>0)
		{
			 
			int decimalPlaces=3;
			 

			
			BigDecimal bd = new BigDecimal(Value);
			bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);

			return bd.toString();
		}
		else
		{
			
			return "0.000";
		}
		
	}
	
	/*End*/
	//RI-Bordeaux
	
	public String writeStudentsListToExcel(ArrayList<String> list1,Connection con) throws ParseException{
		
		//String excelGenPath = "D:/testWriteStudents.xls";
		String excelGenPath = "";
    	Connection conn = null;
    	ResultSet rs = null;
    	String RIBordeauxFileName = riBorderauxFileName();
    	System.out.println("RIBordeauxFileName ==>>>>"+RIBordeauxFileName);
    	String directory=createDir();
    	System.out.println("directory ==>>>"+directory);
    	excelGenPath=directory+""+RIBordeauxFileName+".xls";
	    System.out.println("RIBordeauxFileName ==>>>>"+RIBordeauxFileName+"::directory ==>>>"+directory+"::excelGenPath==>>>>"+excelGenPath);
        // Using XSSF for xlsx format, for xls use HSSF
        Workbook workbook = (Workbook) new HSSFWorkbook();

        Sheet studentsSheet = workbook.createSheet("RI_Bordeaux");

        HSSFCellStyle borderStyle=(HSSFCellStyle) workbook.createCellStyle();
        borderStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        borderStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        borderStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        borderStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        
        int rowIndex = 3;
        int rootrowIndex = 2;
        Row secondRow = studentsSheet.createRow(rowIndex++);
        Row firstRow = studentsSheet.createRow(rootrowIndex++);
        Row beforeFirstRow = studentsSheet.createRow(0);
        Row beforeSecondRow = studentsSheet.createRow(1);
        Row totalRow = studentsSheet.createRow(rowIndex++);
        int cellIndex = 0;
        beforeFirstRow.createCell(2).setCellValue("Renewal and New Business");
        beforeSecondRow.createCell(2).setCellValue("Due Date of Bordereaux");
        
        
        Cell datecell = beforeSecondRow.createCell(5);
        
        
        CellStyle cellStyle = datecell.getCellStyle();
        DataFormat df  = workbook.createDataFormat();
        cellStyle.setDataFormat(df.getFormat("dd-MM-yy"));
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        datecell.setCellValue( c.getTime() );
        datecell.setCellStyle(cellStyle);
        
        
        Cell cell = firstRow.createCell(20);
        cell.setCellValue("BASIC");
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        cell.setCellStyle(style);
        
        CellRangeAddress basicRang = new CellRangeAddress(2,2,20,27);
        
        RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
        RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
        RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
        RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
        
        studentsSheet.addMergedRegion(new CellRangeAddress(
                2, //first row (0-based)
                2, //last row  (0-based)
                20, //first column (0-based)
                27  //last column  (0-based)
        ));
        
        
        
        cell = firstRow.createCell(28);
        cell.setCellValue("ATA RIDER");
        style = workbook.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        cell.setCellStyle(style);
        CellRangeAddress ataRang = new CellRangeAddress(2,2,28,34);
        
        RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,ataRang,studentsSheet,workbook);
        RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,ataRang,studentsSheet,workbook);
        RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,ataRang,studentsSheet,workbook);
        RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,ataRang,studentsSheet,workbook);
        
        studentsSheet.addMergedRegion(new CellRangeAddress(2,2,28,34));
        
        cell = firstRow.createCell(35);
        cell.setCellValue("PTD RIDER");
        style = workbook.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        cell.setCellStyle(style);
        CellRangeAddress ptdRang = new CellRangeAddress(2,2,35,41);
        
        RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,ptdRang,studentsSheet,workbook);
        RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,ptdRang,studentsSheet,workbook);
        RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,ptdRang,studentsSheet,workbook);
        RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,ptdRang,studentsSheet,workbook);
        
        studentsSheet.addMergedRegion(new CellRangeAddress(
                2, //first row (0-based)
                2, //last row  (0-based)
                35, //first column (0-based)
                41  //last column  (0-based)
        ));
        
        cell = firstRow.createCell(42);
        cell.setCellValue("PPD RIDER");
        style = workbook.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        cell.setCellStyle(style);
        CellRangeAddress ppdRang = new CellRangeAddress(2,2,42,48);
        
        RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,ppdRang,studentsSheet,workbook);
        RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,ppdRang,studentsSheet,workbook);
        RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,ppdRang,studentsSheet,workbook);
        RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,ppdRang,studentsSheet,workbook);
        
        studentsSheet.addMergedRegion(new CellRangeAddress(
                2, //first row (0-based)
                2, //last row  (0-based)
                42, //first column (0-based)
                48  //last column  (0-based)
        ));
        
        cell = firstRow.createCell(49);
        cell.setCellValue("ADB RIDER");
        style = workbook.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        cell.setCellStyle(style);
        CellRangeAddress adbRang = new CellRangeAddress(2,2,49,55);
        
        RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,adbRang,studentsSheet,workbook);
        RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,adbRang,studentsSheet,workbook);
        RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,adbRang,studentsSheet,workbook);
        RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,adbRang,studentsSheet,workbook);
        
        studentsSheet.addMergedRegion(new CellRangeAddress(
                2, //first row (0-based)
                2, //last row  (0-based)
                49, //first column (0-based)
                55  //last column  (0-based)
        ));
        
        cell = firstRow.createCell(56);
        cell.setCellValue("PA RIDER");
        style = workbook.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        cell.setCellStyle(style);
        CellRangeAddress paRang = new CellRangeAddress(2,2,56,62);
        
        RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,paRang,studentsSheet,workbook);
        RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,paRang,studentsSheet,workbook);
        RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,paRang,studentsSheet,workbook);
        RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,paRang,studentsSheet,workbook);
        
        studentsSheet.addMergedRegion(new CellRangeAddress(
                2, //first row (0-based)
                2, //last row  (0-based)
                56, //first column (0-based)
                62  //last column  (0-based)
        ));
        
        cell = firstRow.createCell(63);
        cell.setCellValue("TOTAL");
        style = workbook.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        cell.setCellStyle(style);
        CellRangeAddress totalRang = new CellRangeAddress(2,2,63,65);
        
       // RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,rang,studentsSheet,workbook);
        RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,totalRang,studentsSheet,workbook);
        RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,totalRang,studentsSheet,workbook);
        RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,totalRang,studentsSheet,workbook);
        RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,totalRang,studentsSheet,workbook);
        
        studentsSheet.addMergedRegion(new CellRangeAddress(
                2, //first row (0-based)
                2, //last row  (0-based)
                63, //first column (0-based)
                65  //last column  (0-based)
        ));
        
        String P_SEQ_VAL=list1.get(0);
		String P_TOT_BAS_ORG_SA=list1.get(1);
		String P_TOT_BAS_CURR_SA=list1.get(2);
		String P_TOT_BAS_RI_SA=list1.get(3);
		String P_TOT_BAS_LOAD=list1.get(4);
		String P_TOT_BAS_RATE =list1.get(5);
		String P_TOT_BAS_RI_PREM=list1.get(6);
		String P_TOT_ATA_CURR_SA=list1.get(7);
		String P_TOT_ATA_RI_SA=list1.get(8);
		String P_TOT_ATA_RATE=list1.get(9);
		String P_TOT_ATA_RI_PREM=list1.get(10);
		String P_TOT_PTD_CURR_SA =list1.get(11);
		String P_TOT_PTD_RI_SA =list1.get(12);
		String P_TOT_PTD_LOAD=list1.get(13);
		String P_TOT_PTD_RATE=list1.get(14);
		String P_TOT_PTD_RI_PREM=list1.get(15);
		String P_TOT_PPD_CURR_SA=list1.get(16);
		String P_TOT_PPD_RI_SA=list1.get(17);
		String P_TOT_PPD_RATE=list1.get(18);
		String P_TOT_PPD_RI_PREM=list1.get(19);
		String P_TOT_ADB_CURR_SA=list1.get(20);
		String P_TOT_ADB_RI_SA=list1.get(21);
		String P_TOT_ADB_RATE=list1.get(22);
		String P_TOT_ADB_RI_PREM=list1.get(23);
		String P_TOT_PA_CURR_SA=list1.get(24);
		String P_TOT_PA_RI_SA=list1.get(25);
		String P_TOT_PA_RATE=list1.get(26);
		String P_TOT_PA_RI_PREM =list1.get(27);
		String P_TOT_RI_SUM =list1.get(28);
		
		
        /*firstRow.createCell(cellIndex++).setCellValue("Serial No.");
		firstRow.createCell(cellIndex++).setCellValue("Company name");
firstRow.createCell(cellIndex++).setCellValue("Treaty ID/name");
firstRow.createCell(cellIndex++).setCellValue("Policy ID");
firstRow.createCell(cellIndex++).setCellValue("Currency");
firstRow.createCell(cellIndex++).setCellValue("Policy Status*");
firstRow.createCell(cellIndex++).setCellValue("Policy period- Start date");
firstRow.createCell(cellIndex++).setCellValue("Policy period- End date");
firstRow.createCell(cellIndex++).setCellValue("Insured Name");
firstRow.createCell(cellIndex++).setCellValue("Insured DOB");
firstRow.createCell(cellIndex++).setCellValue("Age Definition***");
firstRow.createCell(cellIndex++).setCellValue("Current Age for RSP and Original age for Others");
firstRow.createCell(cellIndex++).setCellValue("Gender Code");
firstRow.createCell(cellIndex++).setCellValue("Insured Country");
firstRow.createCell(cellIndex++).setCellValue("Insured Occupation Code");
firstRow.createCell(cellIndex++).setCellValue("Frequency of payment");
firstRow.createCell(cellIndex++).setCellValue("Original Product/Plan Name");
firstRow.createCell(cellIndex++).setCellValue("Benefit Description**");
firstRow.createCell(cellIndex++).setCellValue("UW RatingCode");
firstRow.createCell(cellIndex++).setCellValue("Medical Exam Code");
secondRow.createCell(cellIndex++).setCellValue("Original Sum at Risk");
totalRow.createCell(20).setCellValue(P_TOT_BAS_ORG_SA);
secondRow.createCell(cellIndex++).setCellValue("Current Sum at Risk");
totalRow.createCell(21).setCellValue(P_TOT_BAS_CURR_SA);
        secondRow.createCell(cellIndex++).setCellValue("Reinsurance Share %");
        secondRow.createCell(cellIndex++).setCellValue("Current Reinsured Sum at Risk");
        totalRow.createCell(23).setCellValue(P_TOT_BAS_RI_SA);
        secondRow.createCell(cellIndex++).setCellValue("Loading");
        totalRow.createCell(24).setCellValue(P_TOT_BAS_LOAD);
        secondRow.createCell(cellIndex++).setCellValue("'RI premium rate (Current age for RSP)");
        totalRow.createCell(25).setCellValue(P_TOT_BAS_RATE);
        secondRow.createCell(cellIndex++).setCellValue("'Basic SA Reinsured Premium");
        totalRow.createCell(26).setCellValue(P_TOT_BAS_RI_PREM);
        secondRow.createCell(cellIndex++).setCellValue("Reinsured Extra Premium for RSP");
        secondRow.createCell(cellIndex++).setCellValue("ATA Sum at Risk");
        totalRow.createCell(28).setCellValue(P_TOT_ATA_CURR_SA);
        secondRow.createCell(cellIndex++).setCellValue("Reinsurance Share %");
        secondRow.createCell(cellIndex++).setCellValue("ATA Reinsured Sum at Risk");
        totalRow.createCell(30).setCellValue(P_TOT_ATA_RI_SA);
        secondRow.createCell(cellIndex++).setCellValue("Loading");
        secondRow.createCell(cellIndex++).setCellValue("'ATA RI prem rate (Current  age for RSP)");
        totalRow.createCell(32).setCellValue(P_TOT_ATA_RATE);
        secondRow.createCell(cellIndex++).setCellValue("'ATA Reinsured Premium");
        totalRow.createCell(33).setCellValue(P_TOT_ATA_RI_PREM);
        secondRow.createCell(cellIndex++).setCellValue("Reinsured Extra Premium RSP");
        secondRow.createCell(cellIndex++).setCellValue("PTD Sum at Risk");
        totalRow.createCell(35).setCellValue(P_TOT_PTD_CURR_SA);
        secondRow.createCell(cellIndex++).setCellValue("Reinsurance Share %");
        secondRow.createCell(cellIndex++).setCellValue("PTD Reinsured Sum at Risk");
        totalRow.createCell(37).setCellValue(P_TOT_PTD_RI_SA);
        secondRow.createCell(cellIndex++).setCellValue("Loading");
        totalRow.createCell(38).setCellValue(P_TOT_PTD_LOAD);
        secondRow.createCell(cellIndex++).setCellValue("'PTD Prem rate(Current  age for RSP)");
        totalRow.createCell(39).setCellValue(P_TOT_PTD_RATE);
        secondRow.createCell(cellIndex++).setCellValue("'PTD 'Reinsured Premium");
        totalRow.createCell(40).setCellValue(P_TOT_PTD_RI_PREM);
        secondRow.createCell(cellIndex++).setCellValue("Reinsured Extra Premium RSP");
        secondRow.createCell(cellIndex++).setCellValue("PPD Sum at Risk");
        totalRow.createCell(42).setCellValue(P_TOT_PPD_CURR_SA);
        secondRow.createCell(cellIndex++).setCellValue("Reinsurance Share %");
        secondRow.createCell(cellIndex++).setCellValue("PPD Reinsured Sum at Risk");
        totalRow.createCell(44).setCellValue(P_TOT_PPD_RI_SA);
        secondRow.createCell(cellIndex++).setCellValue("Loading");
        secondRow.createCell(cellIndex++).setCellValue("PPD Prem rate(0.23 %0)");
        totalRow.createCell(46).setCellValue(P_TOT_PPD_RATE);
        secondRow.createCell(cellIndex++).setCellValue("PPD 'Reinsured Premium ");
        totalRow.createCell(47).setCellValue(P_TOT_PPD_RI_PREM);
        secondRow.createCell(cellIndex++).setCellValue("Reinsured Extra Premium RSP");
        secondRow.createCell(cellIndex++).setCellValue("ADB Sum at Risk");
        totalRow.createCell(49).setCellValue(P_TOT_ADB_CURR_SA);
        secondRow.createCell(cellIndex++).setCellValue("Reinsurance Share %");
        secondRow.createCell(cellIndex++).setCellValue("ADB Reinsured Sum at Risk");
        totalRow.createCell(51).setCellValue(P_TOT_ADB_RI_SA);
        secondRow.createCell(cellIndex++).setCellValue("Loading");
        secondRow.createCell(cellIndex++).setCellValue("Premium Rate");
        totalRow.createCell(53).setCellValue(P_TOT_ADB_RATE);
        secondRow.createCell(cellIndex++).setCellValue("Reinsured Premium");
        totalRow.createCell(54).setCellValue(P_TOT_ADB_RI_PREM);
        secondRow.createCell(cellIndex++).setCellValue("Reinsured Extra Premium-RSP");
        secondRow.createCell(cellIndex++).setCellValue("PA Sum at Risk");
        totalRow.createCell(56).setCellValue(P_TOT_PA_CURR_SA);
        secondRow.createCell(cellIndex++).setCellValue("Reinsurance Share %");
        secondRow.createCell(cellIndex++).setCellValue("PA Reinsured Sum at Risk");
        totalRow.createCell(58).setCellValue(P_TOT_PA_RI_SA);
        secondRow.createCell(cellIndex++).setCellValue("Loading");
        secondRow.createCell(cellIndex++).setCellValue("Premium Rate");
        totalRow.createCell(60).setCellValue(P_TOT_PA_RATE);
        secondRow.createCell(cellIndex++).setCellValue("Reinsured Premium");
        totalRow.createCell(61).setCellValue(P_TOT_PA_RI_PREM);
        secondRow.createCell(cellIndex++).setCellValue("Reinsured Extra Premium");
        secondRow.createCell(cellIndex++).setCellValue("RI PREMIUM");
        totalRow.createCell(63).setCellValue(P_TOT_RI_SUM);
        secondRow.createCell(cellIndex++).setCellValue("RI EXTRA PREMIUM");
        secondRow.createCell(cellIndex++).setCellValue("TOTAL RI PREMIUM");
        totalRow.createCell(65).setCellValue(P_TOT_RI_SUM);
        firstRow.createCell(cellIndex++).setCellValue("Comments if any");*/
        
		CellStyle firststyle = workbook.createCellStyle();
		firststyle.setBorderTop(CellStyle.BORDER_THIN);
		firststyle.setBorderBottom(CellStyle.BORDER_THIN);
		firststyle.setBorderLeft(CellStyle.BORDER_THIN);
		firststyle.setBorderRight(CellStyle.BORDER_THIN);
		
		//total row style
		
		CellStyle totalStyle = workbook.createCellStyle();
		
		Cell firstCell1 = firstRow.createCell(cellIndex++);
		firstCell1.setCellValue("Serial No.");
		firstCell1.setCellStyle(firststyle);
		
        totalRow.createCell(0).setCellValue("total");
        Cell firstCell2 = firstRow.createCell(cellIndex++);
		firstCell2.setCellValue("Company name");
		firstCell2.setCellStyle(firststyle);
		
		Cell firstCell3 = firstRow.createCell(cellIndex++);
		firstCell3.setCellValue("Treaty ID/name");
		firstCell3.setCellStyle(firststyle);
		
        Cell firstCell4 = firstRow.createCell(cellIndex++);
		firstCell4.setCellValue("Policy ID");
		firstCell4.setCellStyle(firststyle);
		
		Cell firstCell5 = firstRow.createCell(cellIndex++);
		firstCell5.setCellValue("Currency");
		firstCell5.setCellStyle(firststyle);
		
        Cell firstCell6 = firstRow.createCell(cellIndex++);
		firstCell6.setCellValue("Policy Status*");
		firstCell6.setCellStyle(firststyle);
		
		Cell firstCell7 = firstRow.createCell(cellIndex++);
		firstCell7.setCellValue("Policy period- Start date");
		firstCell7.setCellStyle(firststyle);
		
        Cell firstCell8 = firstRow.createCell(cellIndex++);
		firstCell8.setCellValue("Policy period- End date");
		firstCell8.setCellStyle(firststyle);
		
		Cell firstCell9 = firstRow.createCell(cellIndex++);
		firstCell9.setCellValue("Insured Name");
		firstCell9.setCellStyle(firststyle);

		Cell firstCell10 = firstRow.createCell(cellIndex++);
		firstCell10.setCellValue("Insured DOB");
		firstCell10.setCellStyle(firststyle);
		
		Cell firstCell11 = firstRow.createCell(cellIndex++);
		firstCell11.setCellValue("Age Definition***");
		firstCell11.setCellStyle(firststyle);

		Cell firstCell12 = firstRow.createCell(cellIndex++);
		firstCell12.setCellValue("Current Age for RSP and Original age for Others");
		firstCell12.setCellStyle(firststyle);
		
		Cell firstCell13 = firstRow.createCell(cellIndex++);
		firstCell13.setCellValue("Gender Code");
		firstCell13.setCellStyle(firststyle);

		Cell firstCell14 = firstRow.createCell(cellIndex++);
		firstCell14.setCellValue("Insured Country");
		firstCell14.setCellStyle(firststyle);
		
		Cell firstCell15 = firstRow.createCell(cellIndex++);
		firstCell15.setCellValue("Insured Occupation Code");
		firstCell15.setCellStyle(firststyle);
		
        Cell firstCell16 = firstRow.createCell(cellIndex++);
		firstCell16.setCellValue("Frequency of payment");
		firstCell16.setCellStyle(firststyle);
		
		Cell firstCell17 = firstRow.createCell(cellIndex++);
		firstCell17.setCellValue("Original Product/Plan Name");
		firstCell17.setCellStyle(firststyle);
		
        Cell firstCell18 = firstRow.createCell(cellIndex++);
		firstCell18.setCellValue("Benefit Description**");
		firstCell18.setCellStyle(firststyle);
		
		secondRow.createCell(17).setCellValue("Term");
		
		Cell firstCell19 = firstRow.createCell(cellIndex++);
		firstCell19.setCellValue("UW RatingCode");
		firstCell19.setCellStyle(firststyle);
		
        Cell firstCell20 = firstRow.createCell(cellIndex++);
		firstCell20.setCellValue("Medical Exam Code");
		firstCell20.setCellStyle(firststyle);
		
		Cell secondCell1 = secondRow.createCell(cellIndex++);
		secondCell1.setCellValue("Original Sum at Risk");
		secondCell1.setCellStyle(firststyle);
		
		totalRow.createCell(20).setCellValue(P_TOT_BAS_ORG_SA);

		Cell secondCell2 = secondRow.createCell(cellIndex++);
		secondCell2.setCellValue("Current Sum at Risk");
		secondCell2.setCellStyle(firststyle);
		
		totalRow.createCell(21).setCellValue(P_TOT_BAS_CURR_SA);
		
		Cell secondCell3 = secondRow.createCell(cellIndex++);
		secondCell3.setCellValue("Reinsurance Share %");
		secondCell3.setCellStyle(firststyle);

		Cell secondCell4 = secondRow.createCell(cellIndex++);
		secondCell4.setCellValue("Current Reinsured Sum at Risk");
		secondCell4.setCellStyle(firststyle);
		
		 totalRow.createCell(23).setCellValue(P_TOT_BAS_RI_SA);
		
		Cell secondCell5 = secondRow.createCell(cellIndex++);
		secondCell5.setCellValue("Loading");
		secondCell5.setCellStyle(firststyle);

		totalRow.createCell(24).setCellValue(P_TOT_BAS_LOAD);
		
		Cell secondCell6 = secondRow.createCell(cellIndex++);
		secondCell6.setCellValue("RI premium rate (Current age for RSP)");
		secondCell6.setCellStyle(firststyle);
		
		totalRow.createCell(25).setCellValue(P_TOT_BAS_RATE);
		
		Cell secondCell7 = secondRow.createCell(cellIndex++);
		secondCell7.setCellValue("Basic SA Reinsured Premium");
		secondCell7.setCellStyle(firststyle);
		
		totalRow.createCell(26).setCellValue(P_TOT_BAS_RI_PREM);
		
        Cell secondCell8 = secondRow.createCell(cellIndex++);
        secondCell8.setCellValue("Reinsured Extra Premium for RSP");
        secondCell8.setCellStyle(firststyle);
		
		Cell secondCell9 = secondRow.createCell(cellIndex++);
		secondCell9.setCellValue("ATA Sum at Risk");
		secondCell9.setCellStyle(firststyle);
		
		totalRow.createCell(28).setCellValue(P_TOT_ATA_CURR_SA);
		
        Cell secondCell10 = secondRow.createCell(cellIndex++);
        secondCell10.setCellValue("Reinsurance Share %");
        secondCell10.setCellStyle(firststyle);
		
		Cell secondCell11 = secondRow.createCell(cellIndex++);
		secondCell11.setCellValue("ATA Reinsured Sum at Risk");
		secondCell11.setCellStyle(firststyle);
		
		totalRow.createCell(30).setCellValue(P_TOT_ATA_RI_SA);
		
        Cell secondCell12 = secondRow.createCell(cellIndex++);
        secondCell12.setCellValue("Loading");
        secondCell12.setCellStyle(firststyle);
		
		Cell secondCell13 = secondRow.createCell(cellIndex++);
		secondCell13.setCellValue("ATA RI prem rate (Current  age for RSP)");
		secondCell13.setCellStyle(firststyle);
		
		totalRow.createCell(32).setCellValue(P_TOT_ATA_RATE);

		Cell secondCell14 = secondRow.createCell(cellIndex++);
		secondCell14.setCellValue("ATA Reinsured Premium");
		secondCell14.setCellStyle(firststyle);
		
		totalRow.createCell(33).setCellValue(P_TOT_ATA_RI_PREM);
		
		Cell secondCell15 = secondRow.createCell(cellIndex++);
		secondCell15.setCellValue("Reinsured Extra Premium RSP");
		secondCell15.setCellStyle(firststyle);

		Cell secondCell16 = secondRow.createCell(cellIndex++);
		secondCell16.setCellValue("PTD Sum at Risk");
		secondCell16.setCellStyle(firststyle);
		
		totalRow.createCell(35).setCellValue(P_TOT_PTD_CURR_SA);
		
		Cell secondCell17 = secondRow.createCell(cellIndex++);
		secondCell17.setCellValue("Reinsurance Share %");
		secondCell17.setCellStyle(firststyle);

		Cell secondCell18 = secondRow.createCell(cellIndex++);
		secondCell18.setCellValue("PTD Reinsured Sum at Risk");
		secondCell18.setCellStyle(firststyle);
		
		totalRow.createCell(37).setCellValue(P_TOT_PTD_RI_SA);
		
		Cell secondCell19 = secondRow.createCell(cellIndex++);
		secondCell19.setCellValue("Loading");
		secondCell19.setCellStyle(firststyle);
		
		totalRow.createCell(38).setCellValue(P_TOT_PTD_LOAD);
		
        Cell secondCell20 = secondRow.createCell(cellIndex++);
        secondCell20.setCellValue("PTD Prem rate(Current  age for RSP)");
        secondCell20.setCellStyle(firststyle);
        
        totalRow.createCell(39).setCellValue(P_TOT_PTD_RATE);
		
		Cell secondCell21 = secondRow.createCell(cellIndex++);
		secondCell21.setCellValue("PTD 'Reinsured Premium");
		secondCell21.setCellStyle(firststyle);
		
		totalRow.createCell(40).setCellValue(P_TOT_PTD_RI_PREM);
		
        Cell secondCell22 = secondRow.createCell(cellIndex++);
        secondCell22.setCellValue("Reinsured Extra Premium RSP");
        secondCell22.setCellStyle(firststyle);
		
		Cell secondCell23 = secondRow.createCell(cellIndex++);
		secondCell23.setCellValue("PPD Sum at Risk");
		secondCell23.setCellStyle(firststyle);
		
		totalRow.createCell(42).setCellValue(P_TOT_PPD_CURR_SA);
		
        Cell secondCell24 = secondRow.createCell(cellIndex++);
        secondCell24.setCellValue("Reinsurance Share %");
        secondCell24.setCellStyle(firststyle);
		
		Cell secondCell25 = secondRow.createCell(cellIndex++);
		secondCell25.setCellValue("PPD Reinsured Sum at Risk");
		secondCell25.setCellStyle(firststyle);
		
		totalRow.createCell(44).setCellValue(P_TOT_PPD_RI_SA);

		Cell secondCell26 = secondRow.createCell(cellIndex++);
		secondCell26.setCellValue("Loading");
		secondCell26.setCellStyle(firststyle);
		
		Cell secondCell27 = secondRow.createCell(cellIndex++);
		secondCell27.setCellValue("PPD Prem rate(0.23 %0)");
		secondCell27.setCellStyle(firststyle);
		
		totalRow.createCell(46).setCellValue(P_TOT_PPD_RATE);

		Cell secondCell28 = secondRow.createCell(cellIndex++);
		secondCell28.setCellValue("PPD 'Reinsured Premium ");
		secondCell28.setCellStyle(firststyle);
		
		totalRow.createCell(47).setCellValue(P_TOT_PPD_RI_PREM);
		
		Cell secondCell29 = secondRow.createCell(cellIndex++);
		secondCell29.setCellValue("Reinsured Extra Premium RSP");
		secondCell29.setCellStyle(firststyle);

		Cell secondCell30 = secondRow.createCell(cellIndex++);
		secondCell30.setCellValue("ADB Sum at Risk");
		secondCell30.setCellStyle(firststyle);
		
		totalRow.createCell(49).setCellValue(P_TOT_ADB_CURR_SA);
		
		Cell secondCell31 = secondRow.createCell(cellIndex++);
		secondCell31.setCellValue("Reinsurance Share %");
		secondCell31.setCellStyle(firststyle);
		
        Cell secondCell32 = secondRow.createCell(cellIndex++);
        secondCell32.setCellValue("ADB Reinsured Sum at Risk");
        secondCell32.setCellStyle(firststyle);
        
        totalRow.createCell(51).setCellValue(P_TOT_ADB_RI_SA);
		
		Cell secondCell33 = secondRow.createCell(cellIndex++);
		secondCell33.setCellValue("Loading");
		secondCell33.setCellStyle(firststyle);
		
        Cell secondCell34 = secondRow.createCell(cellIndex++);
        secondCell34.setCellValue("Premium Rate");
        secondCell34.setCellStyle(firststyle);
        
        totalRow.createCell(53).setCellValue(P_TOT_ADB_RATE);
        
        Cell secondCell35 = secondRow.createCell(cellIndex++);
		secondCell35.setCellValue("Reinsured Premium");
		secondCell35.setCellStyle(firststyle);
		
		totalRow.createCell(54).setCellValue(P_TOT_ADB_RI_PREM);
		
        Cell secondCell36 = secondRow.createCell(cellIndex++);
        secondCell36.setCellValue("Reinsured Extra Premium-RSP");
        secondCell36.setCellStyle(firststyle);
		
		Cell secondCell37 = secondRow.createCell(cellIndex++);
		secondCell37.setCellValue("PA Sum at Risk");
		secondCell37.setCellStyle(firststyle);
		
		totalRow.createCell(56).setCellValue(P_TOT_PA_CURR_SA);
		
		Cell secondCell38 = secondRow.createCell(cellIndex++);
		secondCell38.setCellValue("Reinsurance Share %");
		secondCell38.setCellStyle(firststyle);
		
		Cell secondCell39 = secondRow.createCell(cellIndex++);
		secondCell39.setCellValue("PA Reinsured Sum at Risk");
		secondCell39.setCellStyle(firststyle);
		
		totalRow.createCell(58).setCellValue(P_TOT_PA_RI_SA);
		
		Cell secondCell40 = secondRow.createCell(cellIndex++);
		secondCell40.setCellValue("Loading");
		secondCell40.setCellStyle(firststyle);
		
		Cell secondCell41 = secondRow.createCell(cellIndex++);
		secondCell41.setCellValue("Premium Rate");
		secondCell41.setCellStyle(firststyle);
		
		 totalRow.createCell(60).setCellValue(P_TOT_PA_RATE);

		Cell secondCell42 = secondRow.createCell(cellIndex++);
		secondCell42.setCellValue("Reinsured Premium");
		secondCell42.setCellStyle(firststyle);
		
		totalRow.createCell(61).setCellValue(P_TOT_PA_RI_PREM);
		
		Cell secondCell43 = secondRow.createCell(cellIndex++);
		secondCell43.setCellValue("Reinsured Extra Premium");
		secondCell43.setCellStyle(firststyle);
		
        Cell secondCell44 = secondRow.createCell(cellIndex++);
        secondCell44.setCellValue("RI PREMIUM");
        secondCell44.setCellStyle(firststyle);
        
        totalRow.createCell(63).setCellValue(P_TOT_RI_SUM);
        
		Cell secondCell45 = secondRow.createCell(cellIndex++);
		secondCell45.setCellValue("RI EXTRA PREMIUM");
		secondCell45.setCellStyle(firststyle);
		
        Cell secondCell46 = secondRow.createCell(cellIndex++);
        secondCell46.setCellValue("TOTAL RI PREMIUM");
        secondCell46.setCellStyle(firststyle);
        
        totalRow.createCell(65).setCellValue(P_TOT_RI_SUM);
        
        Cell firstCell21 = firstRow.createCell(cellIndex++);
        firstCell21.setCellValue("Comments if any");
        firstCell21.setCellStyle(firststyle);
		
        
       try{
        String qw="select count(*) from PW_RI_BORDX_REG WHERE PRBR_SYS_ID = "+P_SEQ_VAL;
		ResultSet res=new CRUDHandler().executeSelectStatement(qw, con);
if(res.next()){
	if(res.getInt(1)>0){
		System.out.println("count ====>>"+res.getString(1));
		System.out.println("before inside resultset while P_SEQ_VAL::"+P_SEQ_VAL);
        
        try {
        	/*Class.forName("oracle.jdbc.driver.OracleDriver");  
        	conn=DriverManager.getConnection(  
        			"jdbc:oracle:thin:@10.44.0.59:1521:ORCL","P11J_FALCON_LIFE_2016","P11J_FALCON_LIFE_2016");  */
			rs = new CRUDHandler().executeSelectStatement("SELECT PRBR_SRNO,PRBR_COMP_NAME,PRBR_TRTY_DESC,PRBR_POL_NO,PRBR_CURR_CODE,PRBR_POL_STAT,TO_CHAR(PRBR_FM_DT,'DD/MM/YYYY'),TO_CHAR(PRBR_TO_DT,'DD/MM/YYYY'),"
					+ "PRBR_ASSR_NAME,TO_CHAR(PRBR_ASSR_DOB,'DD/MM/YYYY'),PRBR_AGE_DEFN,PRBR_ASSR_AGE,PRBR_ASSR_CATG,PRBR_ASSR_COUNTRY,PRBR_OCCU,PRBR_MOP,"
					+ "(SELECT PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE = PRBR_PROD_CODE) PROD_DESC,PRBR_TERM,PRBR_UW_RATING,PRBR_MED_CODE,PRBR_BAS_ORG_SA,"
					+ "PRBR_BAS_CURR_SA,PRBR_BAS_SHARE,PRBR_BAS_RI_SA,PRBR_BAS_LOAD,PRBR_BAS_RATE,PRBR_BAS_RI_PREM,PRBR_BAS_RI_EXT_PREM,PRBR_ATA_CURR_SA,"
					+ "PRBR_ATA_SHARE,PRBR_ATA_RI_SA,PRBR_ATA_LOAD,PRBR_ATA_RATE,PRBR_ATA_RI_PREM,PRBR_ATA_RI_EXT_PREM,PRBR_PTD_CURR_SA,PRBR_PTD_SHARE,PRBR_PTD_RI_SA,"
					+ "PRBR_PTD_LOAD,PRBR_PTD_RATE,PRBR_PTD_RI_PREM,PRBR_PTD_RI_EXT_PREM,PRBR_PPD_CURR_SA,PRBR_PPD_SHARE,PRBR_PPD_RI_SA,PRBR_PPD_LOAD,PRBR_PPD_RATE,"
					+ "PRBR_PPD_RI_PREM,PRBR_PPD_RI_EXT_PREM,PRBR_ADB_CURR_SA,PRBR_ADB_SHARE,PRBR_ADB_RI_SA,PRBR_ADB_LOAD,PRBR_ADB_RATE,PRBR_ADB_RI_PREM,"
					+ "PRBR_ADB_RI_EXT_PREM,PRBR_PA_CURR_SA,PRBR_PA_SHARE,PRBR_PA_RI_SA,PRBR_PA_LOAD,PRBR_PA_RATE,PRBR_PA_RI_PREM,PRBR_PA_RI_EXT_PREM,PRBR_TOT_RI_PREM,"
					+ "PRBR_TOT_RI_EXT_PREM,PRBR_TOT_PREM,PRBR_COMMENTS FROM PW_RI_BORDX_REG WHERE PRBR_SYS_ID = "+P_SEQ_VAL+" ORDER BY PRBR_SRNO", con);
			
			
		
		while(rs.next())
		{
			System.out.println("inside resultset while ::"+rowIndex);
            Row row = studentsSheet.createRow(rowIndex++);
            cellIndex = 0;
           
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_SRNO"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_COMP_NAME"));
row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_TRTY_DESC"));
row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_POL_NO"));
row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_CURR_CODE"));
row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_POL_STAT"));
row.createCell(cellIndex++).setCellValue(rs.getString("TO_CHAR(PRBR_FM_DT,'DD/MM/YYYY')"));
row.createCell(cellIndex++).setCellValue(rs.getString("TO_CHAR(PRBR_TO_DT,'DD/MM/YYYY')"));
row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_ASSR_NAME"));
row.createCell(cellIndex++).setCellValue(rs.getString("TO_CHAR(PRBR_ASSR_DOB,'DD/MM/YYYY')"));
row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_AGE_DEFN"));
row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_ASSR_AGE"));
row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_ASSR_CATG"));
row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_ASSR_COUNTRY"));
row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_OCCU"));
row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_MOP"));
row.createCell(cellIndex++).setCellValue(rs.getString("PROD_DESC"));
row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_TERM"));
row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_UW_RATING"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_MED_CODE"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_BAS_ORG_SA"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_BAS_CURR_SA"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_BAS_SHARE"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_BAS_RI_SA"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_BAS_LOAD"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_BAS_RATE"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_BAS_RI_PREM"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_BAS_RI_EXT_PREM"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_ATA_CURR_SA"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_ATA_SHARE"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_ATA_RI_SA"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_ATA_LOAD"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_ATA_RATE"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_ATA_RI_PREM"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_ATA_RI_EXT_PREM"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_PTD_CURR_SA"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_PTD_SHARE"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_PTD_RI_SA"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_PTD_LOAD"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_PTD_RATE"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_PTD_RI_PREM"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_PTD_RI_EXT_PREM"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_PPD_CURR_SA"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_PPD_SHARE"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_PPD_RI_SA"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_PPD_LOAD"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_PPD_RATE"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_PPD_RI_PREM"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_PPD_RI_EXT_PREM"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_ADB_CURR_SA"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_ADB_SHARE"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_ADB_RI_SA"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_ADB_LOAD"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_ADB_RATE"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_ADB_RI_PREM"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_ADB_RI_EXT_PREM"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_PA_CURR_SA"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_PA_SHARE"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_PA_RI_SA"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_PA_LOAD"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_PA_RATE"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_PA_RI_PREM"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_PA_RI_EXT_PREM"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_TOT_RI_PREM"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_TOT_RI_EXT_PREM"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_TOT_PREM"));
            row.createCell(cellIndex++).setCellValue(rs.getString("PRBR_COMMENTS"));
            
           /* //first place in row is name
            row.createCell(cellIndex++).setCellValue(rs.getString(""));

            //second place in row is marks in maths
            row.createCell(cellIndex++).setCellValue(student.getMaths());

            //third place in row is marks in Science
            row.createCell(cellIndex++).setCellValue(student.getScience());

            //fourth place in row is marks in English
            row.createCell(cellIndex++).setCellValue(student.getEnglish());*/

        
		}
		System.out.println("cellindex"+cellIndex);
		for(int a = 0 ;a<cellIndex;a++){
			studentsSheet.autoSizeColumn(a);
		}
        } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
      //write this workbook in excel file.
        try {
            FileOutputStream fos = new FileOutputStream(excelGenPath);
            workbook.write(fos);
            fos.close();

            System.out.println(excelGenPath + " is successfully written");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return excelGenPath;
	}

    }
       }catch(Exception e){
    	   e.printStackTrace();
       }
       return "";
}
	public String riBorderauxFileName(){
		String fileName="RI_Bordeaux";
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		String today=dateFormat.format(date);
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        String time=sdf.format(cal.getTime());
        fileName=fileName+"_"+today+time;
        //System.out.println("filename =====>>>>>>>>"+fileName);
        return fileName;
	}

	public String createDir(){
		final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        
        int rootindex = dir.indexOf(File.separator);
        
        System.out.println(dir.substring(0, rootindex));
        
        File filedir = new File(dir.substring(0, rootindex)+File.separator+"RI-Bordeauxreports");
        
        if(!filedir.exists()){
        	filedir.mkdir();
        }
						
		String rootpath = dir.substring(0, rootindex)+File.separator+"RI-Bordeauxreports"+File.separator;
		
		System.out.println("Root Path        "+rootpath);
		
		return rootpath;
	}
	//FalconPolicyScheduleMerge
	
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
			
}
