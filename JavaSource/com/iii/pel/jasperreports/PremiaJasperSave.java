package com.iii.pel.jasperreports;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;

import org.quartz.xml.ValidationException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILP016.PRINT_ACTION;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT002_APAC_QE.PILT002_APAC_QE_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT002_APAC_QE.PW_IL_QQUOT_ASSURED_DTLS;
import com.iii.pel.forms.PILT002_APAC_QE.PW_IL_QUICK_QUOTE;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
/**
 * Servlet implementation class PdfStreamingServlet
 */

public class PremiaJasperSave extends CommonAction {
	private static final long serialVersionUID = 1L;
	private  final static ResourceBundle resourceBundle=ResourceBundle.getBundle("FalconReports");
	private  final static ResourceBundle applnResourceBundle=ResourceBundle.getBundle("Application");
	
	public void saveJasperAsPDF(Object obj) throws ValidatorException, Exception {
	
		
		/*Added by Ram on 13/03/2017 for Common Report by Customerwise
		PRINT_ACTION PRINT_ACTION_BEAN = null;
		 if(applnResourceBundle.getString("isJasperReports") != null)
		 {
			 if(applnResourceBundle.getString("isJasperReports").equals("Y"))
			 {
				 PRINT_ACTION_BEAN = (PRINT_ACTION)obj; 	 
			 }
			 else
			 {
				 PRINT_ACTION_BEAN = (PRINT_ACTION)obj;
			 }
		 }
		 
		
		 ENd*/
		 
		
		
		PRINT_ACTION PRINT_ACTION_BEAN = null;
		
		
		byte[] byteArr;
		Connection connection = null;
		HttpServletRequest request = null;
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		File filepath = null;
		
		connection = CommonUtils.getConnection();
		request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String Pol_sys_id = (String) CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID");		
		//String type = request.getParameter("Type");
		String type = PRINT_ACTION_BEAN.getUI_M_POL_ENDT();
		String realPath = request.getRealPath("/");
		
		System.out.println("Real Path        "+realPath);
		System.out.println(type+" --POLSYSID-->"+Pol_sys_id);
		
		if(type != null)
		{
			if(type.equals("Quotation"))
			{
				filepath = new File(request.getRealPath("/")
						+ ("/WEB-INF/reports/Quotation_Review_Sheet.jasper"));
				param.put("POL_SYS_ID", Pol_sys_id);
			}
			else if(type.equals("Policy"))
			{
				filepath = new File(request.getRealPath("/")
						+ ("/WEB-INF/reports/FalconPolicySchedule.jasper"));
				param.put("POL_SYS_ID", Pol_sys_id);	
			} 
		}
		
		JasperReport jr = (JasperReport) JRLoader.loadObject(filepath);
		JasperPrint jp=null;
		
		jp = JasperFillManager.fillReport(jr, param, connection);
		

		/*END*/

		byteArr = JasperExportManager.exportReportToPdf(jp);
		
		System.out.println("Bal   : "+byteArr);
		
		final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        
        int rootindex = dir.indexOf(File.separator);
        
        System.out.println(dir.substring(0, rootindex));
        
        File filedir = new File(dir.substring(0, rootindex)+File.separator+"pdf");
        
        if(!filedir.exists()){
        	filedir.mkdir();
        }
						
		String rootpath = dir.substring(0, rootindex)+File.separator+"pdf"+File.separator;
		
		System.out.println("Root Path        "+rootpath);
		
		String fileName = type+"_"+Pol_sys_id+".pdf";
		
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
        
        CommonUtils commonUtils = new CommonUtils();
		PILT002_APAC_COMPOSITE_ACTION compositeActionsa = (PILT002_APAC_COMPOSITE_ACTION) commonUtils
			    .getMappedBeanFromSession("PILT002_APAC_COMPOSITE_ACTION");
		String pro=compositeActionsa.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE();
		
		
		if("N".equalsIgnoreCase(emailTriggerProcCall(pro,"POL",CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID").toString(),"C",outfile.getAbsolutePath()))){
			//throw new ValidatorException(new FacesMessage("Unable to send mail to Customer due to email Id is unavailable"));
			throw new ValidatorException(new FacesMessage("Unable to send mail to Customer due to email Id is unavailable"));
		}
		
		/*if("Y".equalsIgnoreCase(getAttachment_YN())){
		
		if("N".equalsIgnoreCase(emailTriggerProcCall(pro,"POL",CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID").toString(),"C",outfile.getAbsolutePath()))){
			throw new ValidatorException(new FacesMessage("Unable to send mail to Customer due to email Id is unavailable"));
		}
		}else{
			if("N".equalsIgnoreCase(emailTriggerProcCall(pro,"POL",CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID").toString(),"C",""))){
				throw new ValidatorException(new FacesMessage("Unable to send mail to Customer due to email Id is unavailable"));
			}
		}*/
	
	}
	
public void saveJasperPDFQuestionaries(com.iii.pel.forms.PILT002_APAC.PRINT_ACTION PRINT_ACTION_BEAN,PILT002_APAC_COMPOSITE_ACTION compositeAction) throws ValidatorException, Exception {
		
		byte[] byteArr;
		Connection connection = null;
		HttpServletRequest request = null;
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		File pdfFilepath = null;
		String totalFilePath="";
		
		connection = CommonUtils.getConnection();
		request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		File imgfile=new File(request.getRealPath("/")+("/WEB-INF/images/arbpic.jpg"));
				
		
		List<String> questionaireType = new ArrayList<String>();
		//String pdfFilepath = request.getRealPath("/");
		questionaireType = PRINT_ACTION_BEAN.getUI_M_SCHEDULE_TYPE();
		
		System.out.println("Real Path        "+pdfFilepath);
		System.out.println("Select Questionaire type ["+questionaireType+"]");
		
		String Name="Ø§Ù„Ø§Ø³Ù…";
		String Occupation="Ø§Ù„Ù…Ù‡Ù†Ø©";
		String Passport="Ø±Ù„Ù… Ø¬ÙˆØ§Ø² Ø§Ù„Ø³Ù�Ø±";
		String Address="Ø§Ù„Ø¹Ù†ÙˆØ§Ù†";
		String Date ="Ø§Ù„ØªØ§Ø± Ø®ÙŒ";
		String Age="Ø§Ù„Ø¹Ù…Ø±";
		String Nationality="Ø§Ù„Ø¬Ù†Ø³ Ø©ÙŒ";
		String Text="";
		String TB=") Ø³Ù„ )Ø¯Ø±Ù†";
		String MajorOperations="Ø¹Ù…Ù„ Ø§ÙŒØª Ø¬Ø±Ø§Ø­ Ø©ÙŒ ÙƒØ¨ Ø±ÙŒØ©";
		String Malaria="Ù…Ù„Ø§Ø± Ø§ÙŒ";
		String Dysentery="Ø¯Ø³Ù†Ø·Ø§Ø± Ø§ÙŒ";
		String EntericFever="Ø­Ù…Ù‰ Ù…Ø¹Ùˆ Ø©ÙŒ";


		String Jaundice ="Ø±ÙŒÙ„Ø§Ù† / Ø§Ù„ØªÙ‡Ø§Ø¨ ÙƒØ¨Ø¯ÙŠ";
		String Gonorrhoea="Ø³ Ù„ÙŒØ§Ù†";
		String Syphillis="Ø²Ù‡Ø±ÙŠ";
		String SkinDiseases="Ø£Ù…Ø±Ø§Ø¶ Ø¬Ù„Ø¯ Ø©ÙŒ";
		String SickleCellAnaemia="Ø£Ù† Ù…ÙŒ Ø§ÙŒ Ø§Ù„Ø®Ù„ Ø©ÙŒ Ø§Ù„Ù…Ù†Ø¬Ù„ Ø©ÙŒ";
		String Stroke=") Ø³ÙƒØªØ© Ø¯Ù…Ø§Øº Ø©ÙŒ )Ø¶Ø±Ø¨Ø©";
		String Hypertension="Ø¥Ø±ØªÙ�Ø§Ø¹ Ù� Ø¶ØºØ· Ø§Ù„Ø¯Ù…";
		String HeartDisease   ="Ø£Ù…Ø±Ø§Ø¶ Ø§Ù„Ù…Ù„Ø¨";
		String Diabetes="Ù…Ø±Ø¶ Ø§Ù„Ø³ÙƒØ±";
		String Asthma="Ø±Ø¨Ùˆ / Ø­Ø³Ø§Ø³ ÙŒØ©";
		String RenalDisease="Ø£Ù…Ø±Ø§Ø¶ Ø§Ù„ÙƒÙ„";
		String Arthritis ="Ø§Ù„ØªÙ‡Ø§Ø¨ Ø§Ù„Ù…Ù�Ø§ØµÙ„";                                 
		String Anaemia ="Ù�Ù…Ø± Ø§Ù„Ø¯Ù…";                                         
		String PepticUlcer="Ù„Ø±Ø­Ø© Ø§Ù„Ù…Ø¹Ø¯Ø©";
		String Psychiatric="Ø£Ù…Ø±Ø§Ø¶ Ù†Ù�Ø³ Ø©ÙŒ ÙˆØ¹ØµØ¨ Ø©ÙŒ";
		String Epilepsy="ØµØ±Ø¹ / ØµØ¯Ø§Ø¹ Ù†ØµÙ�";
		String AnymajorIllness="Ø£ÙŠ Ù…Ø±Ø¶ Ù‡Ø§Ù…";
		String Title1="Ø¥Ø³ØªÙ…Ø§Ø±Ø© Ø§Ù„Ù�Ø­Øµ Ø§Ù„Ø·Ø¨ÙŠ ÙˆØ§Ù„ØªÙ‚Ø±ÙŠØ± Ø§Ù„Ø·Ø¨ÙŠ Ù„ØªØ£Ù…ÙŠÙ† Ø§Ù„Ù‚Ø±ÙˆØ¶ Ø§Ù„Ø¨Ù†ÙƒÙŠØ©";
		String Title2="Ù…Ù„Ø§Ø­Ø¸Ø© : ÙŠØ¬Ø¨ ØªØ¹Ø¨Ø¦Ø© Ø§Ù„Ù�Ù‚Ø±Ø§Øª Ù…Ù† Ø¨Ù…Ø¹Ø±  Ù�Ø© Ø§Ù„Ù…Ù‚ØªØ±Ø¶";
		String Static_var3="Ù„Ù„Ù†Ø³Ø§Ø¡ Ù�Ù‚Ø·";
		String duration="Ù‡Ù„ Ø£Ù†Øª Ø­Ø§Ù…Ù„ØŸ Ù� Ø­Ø§Ù„Ø© Ø§Ù„Ø­Ù…Ù„ Ø§Ø°ÙƒØ±ÙŠ Ø§Ù„Ù…Ø¯Ø©";
		String Problems="ØŸ Ù‡Ù„ ØªØ¹Ø§Ù† Ù†ÙŒ Ù…Ù† Ù…Ø´Ø§ÙƒÙ„ ØµØ­ Ø©ÙŒ Ù…Ø±ØªØ¨Ø·Ø© Ø¨Ø£Ù…Ø±Ø§Ø¶ Ø§Ù„Ù†Ø³Ø§Ø¡";
		String Declare="Ø£ØµØ±Ø­ Ø¨Ø£Ù† Ø§Ù„Ù…Ø¹Ù„ÙˆÙ…Ø§Øª Ø§Ù„Ù…Ù…Ø¯Ù…Ø© Ù…Ù†Ù‰ Ø£Ø¹Ù„Ø§Ù‡ ØµØ­ Ø­ÙŒØ© Ø­Ø³Ø¨ Ù…Ø¹Ø±Ù�Øª ÙˆØ§Ø¹ØªÙ…Ø§Ø¯ÙŠ";
		String paragraph="Ø£ÙˆØ§Ù�Ùƒ Ø¹Ù„Ù‰ Ø£Ù† Ù…ÙŒÙˆÙ… Ø§Ù„Ù…Ø³ØªØ´Ù�Ù‰ Ø£Ùˆ Ø§Ù„Ø¹ ÙŒØ§Ø¯Ø© ÙˆØ§Ù„Ø·Ø¨ Ø¨ÙŒ Ø§Ù„Ù…ÙˆÙ„Ø¹ Ø£Ø¯Ù†Ø§Ù‡ Ø¨ØªÙ…Ø¯ Ù…ÙŒ Ø§Ù„Ù…Ø¹Ù„ÙˆÙ…Ø§Øª Ø§Ù„Øª Ù„Ø¯ ØªØ­ØªØ§Ø¬Ù‡Ø§ Ø§Ù„Ø´Ø±ÙƒØ© Ø­ÙˆÙ„ ÙˆØ¶Ø¹ Ø§Ù„ØµØ­ ØŒ ÙˆØ£Ø¹Ù� Ù‡ÙŒÙ… Ù…Ù† ÙƒØ§Ù�Ø© Ø§Ù„Ù…Ø³Ø¦ÙˆÙ„ Ø§ÙŒØª Ø§Ù„Ù…Ø§Ù†ÙˆÙ† Ø©ÙŒ";
		String paragraph1="Ø§Ù„Øª Ù„Ø¯ ØªØªØ±ØªØ¨ Ø¹Ù„Ù‰ Ù„ Ø§ÙŒÙ…Ù‡Ù… Ø¨Ø°Ù„Ù† . ÙƒÙ…Ø§ Ø£Ù„Ø± Ø¨Ø£Ù† ØªØ§Ø± Ø®ÙŒ Ø§Ù„Ø·Ø¨ Ø§Ù„Ù…ÙˆØ¶Ø­ Ø£Ø¹Ù„Ø§Ù‡ Ø­Ù… Ù…ÙŒ Ø§ÙŒ ÙˆØ£Ù† Ø£ Ø©ÙŒ Ù…Ø¹Ù„ÙˆÙ…Ø§Øª Ù…ØºÙ„ÙˆØ·Ø© Ø³ØªØ­Ø±Ù…Ù† Ù…Ù† Ø¨Ø±Ù†Ø§Ù…Ø¬ Ø§Ù„ØªØ£Ù… Ù†ÙŒ .";
		String Signatureoflife="ØªÙˆÙ‚ÙŠØ¹ Ø§Ù„Ù…Ø¤Ù…Ù† Ø¹Ù„ÙŠÙ‡";
		String SignatureofExaminer="ØªÙˆÙ‚ÙŠØ¹ Ø§Ù„Ù…Ø³Ø¦ÙˆÙ„ Ø¹Ù† Ø§Ù„Ù�Ø­Øµ";
		String Date1="Ø§Ù„ØªØ§Ø± Ø®ÙŒ";


		String Report="Ø§Ù„Ù�Ø­Øµ Ø§Ù„Ø·Ø¨ ";
		String Name2="Ø§Ù„Ø§Ø³Ù… Ø§Ù„Ø£ÙˆÙ„. ";
		String Sex="Ø§Ù„Ø¬Ù†Ø³";
		String cm1="Ø³Ù…";
		String cm2="Ø§Ù„Ø·ÙˆÙ„ ";
		String weight1="Ùƒ Ù„ÙŒÙˆ ØºØ±Ø§Ù… ";
		String weight2="Ø§Ù„ÙˆØ²Ù† ";
		String exam="Ù†ÙˆØ¹ Ø§Ù„Ù�Ø­Øµ Ø§Ù„Ø·Ø¨ ";
		String results="Ø¦Ø¬ ";
		String Rt1="Ø§Ù„ Ø³ÙŒØ±Ù‰ ";
		String Rt2="Ø§Ù„ Ù…ÙŒÙ†Ù‰ ";
		String eye="Ø§Ù„Ø¹ ÙˆÙŒÙ† ";
		String ear="Ø§Ù„Ø£Ø°Ù† ";
		String system="Ù�Ø­Øµ Ø£Ø¬Ù‡Ø²Ø© Ø§Ù„Ø¬Ø³Ù… ";
		String vascular="Ø§Ù„Ù…Ù„Ø¨ ÙˆØ§Ù„Ø£ÙˆØ¹ Ø©ÙŒ Ø§Ù„Ø¯Ù…Ùˆ Ø©ÙŒ ";
		String heart="Ù„Ù…Ù„Ø¨ ";
		String test="Ù�Ø­Øµ Ø§Ù„Ø¨ÙˆÙ„ ";
		String bp="Ø¶ØºØ· Ø§Ù„Ø¯Ù… ";
		String pulse="Ø§Ù„Ù†Ø¨Ø¶ ";
		String respire="Ø§Ù„Ø¬Ù‡Ø§Ø² Ø§Ù„ØªÙ†Ù�Ø³ ";
		String lungs="Ø±Ø¦Øª Ù†ÙŒ";
		String gastro="Ø§Ù„Ù…Ø¹Ø¯Ø© ÙˆØ§Ù„Ø£Ù…Ø¹Ø§Ø¡ ";
		String abdomen="Ø·Ù† ";
		String liver=" Ø¯";
		String spleen="Ø·Ø­Ø§Ù„";
		String ascites="ØªØ¬Ù…Ø¹ Ø§Ù„Ø³Ø§Ø¦Ù„ ";
		String others="Ø±Ù‰";
		String hernia="Ø§Ù‚ ";
		String geneto="Ø§Ù„Ø¬Ù‡Ø§Ø² Ù†ÙŒ Ø§Ù„Ø¨ÙˆÙ„ ÙˆØ§Ù„ØªÙ†Ø§Ø³Ù„ ";
		String kidneys="Ø§Ù„ÙƒÙ„ ";
		String bladder="Ø§Ù„Ù…Ø«Ø§Ù†Ø© ";
		String testis="Ø§Ù„Ø®Øµ ØªÙŒ ÙŒÙ† ";
		String PV="Ù„Ù…Ù‡Ø¨Ù„ ";
		String skelital="Ø§Ù„Ù‡ ÙƒÙŒÙ„ Ø§Ù„Ø¹Ø¸Ù… ";
		String dental="Ø§Ù„Ø£Ø³Ù†Ø§Ù† ÙˆØ§Ù„Ù�Ù… ";
		String extremitis="Ø§Ù„Ø£Ø·Ø±Ø§Ù� ";
		String deformitis="Ø§Ù„ØªØ´ÙˆÙ‡Ø§Øª ";
		String skin="Ø§Ù„Ø¬Ù„ ";
		String veneral="Ø§Ù„Ø£Ù…Ø±Ø§Ø¶ Ø§Ù„ØªÙ†Ø§Ø³Ù„ Ø©ÙŒ ";
		String clinical="Ø³Ø± Ø±ÙŒ ÙŒØ§ ";
		String tick1="Ù� Ø­Ø§Ù„Ø© Ø§Ù„Ù†Ù�";
		String tick2="Ù� Ø­Ø§Ù„Ø© Ø§Ù„Ø¥ Ø¬ÙŒØ§Ø¨ Ùˆ";
		String tick3="Ù‡Ù„ Ø³Ø¨Ùƒ ÙˆØ£Ù† ØªØ¹Ø±Ø¶Øª Ù„Ø¢ÙŠ Ù…Ù† Ø§Ù„Ø£Ù…Ø±Ø§Ø¶ Ø§Ù„ØªØ§Ù„ Ø©ÙŒ Ø¶Ø¹ Ø¹Ù„Ø§Ù…Ø©";
		String cross="( X )";
		String tick="( âˆš )";
		String Dt="Ø§Ù„ØªØ§Ø± Ø®ÙŒ";
		String tension="Ø¥Ø±ØªÙ�Ø§Ø¹ Ù� Ø¶ØºØ· Ø§Ù„Ø¯Ù…";
		String heartdi="Ø£Ù…Ø±Ø§Ø¶ Ø§Ù„Ù…Ù„Ø¨";
		String peptic="Ù„Ø±Ø­Ø© Ø§Ù„Ù…Ø¹Ø¯Ø©";
		String information="Ø£ØµØ±Ø­ Ø¨Ø£Ù† Ø§Ù„Ù…Ø¹Ù„ÙˆÙ…Ø§Øª Ø§Ù„Ù…Ù…Ø¯Ù…Ø© Ù…Ù†Ù‰ Ø£Ø¹Ù„Ø§Ù‡ ØµØ­ Ø­ÙŒØ© Ø­Ø³Ø¨ Ù…Ø¹Ø±Ù�Øª ÙˆØ§Ø¹ØªÙ…Ø§Ø¯ÙŠ";

		String ArbName="Ø§Ù„Ø§Ø³Ù…"; 
		String ArbDate="Ø§Ù„Ø§Ù„ØªØ§Ø±ÙŠØ®"; 
		String ArbAge =" Ø§Ù„Ø¹Ù…Ø±Ù„";
		String ArbOccupation=" Ø§Ù„Ù…Ù‡Ù†Ù€Ø©";
		String ArbIDCard="Ø±Ù‚Ù… Ø¬ÙˆØ§Ø² Ø§Ù„Ø³Ù�Ø±";
		String ArbNationality="..Ø§Ù„Ø¬Ù†Ø³ÙŠØ©";
		String ArbAddress="Ø§Ù„Ø¹Ù†ÙˆØ§Ù†";
		String ArbBP="Ø¶ØºÙ€Ø· Ø§Ù„Ù€Ø¯Ù…";
		String ArbHtCms=".Ø³Ù…  Ø§Ù„Ø·Ù€ÙˆÙ„ ";  
		String ArbWtKg = "  ÙƒÙŠÙ„Ùˆ ØºØ±Ø§Ù… â€¦. Ø§Ù„ÙˆØ²Ù†  ";
		String ArbTB =" Ø³Ù„ (Ø¯Ø±Ù†)";
		String ArbPc="Ø§Ù„Ø¹Ù†ÙˆØ§Ù†";
		String ArbHypertension="Ø£Ù…Ø±Ø§Ø¶ Ø§Ù„Ù‚Ù„Ø¨/ ";
		String ArbMajorOperations="  Ø¹Ù…Ù„ÙŠØ§Øª Ø¬Ø±Ø§Ø­ÙŠØ© ÙƒØ¨ÙŠØ±Ø© ";
		String ArbHeartDisease="  Ø¥Ø±ØªÙ�Ø§Ø¹ Ù�ÙŠ Ø¶ØºØ· Ø§Ù„Ø¯Ù… " ;
		String ArbMalaria=" Ù…Ù„Ø§Ø±ÙŠØ§ ";
		String ArbDiabetes=" Ù…Ø±Ø¶ Ø§Ù„Ø³ÙƒØ± ";
		String ArbDysentery=" Ø¯Ø³Ù†Ø·Ø§Ø±ÙŠØ§ ";
		String ArbAsthmaAllergy=" Ø±Ø¨Ùˆ / Ø­Ø³Ø§Ø³ÙŠÙ€Ø© ";
		String ArbEntericfever=" Ø­Ù…Ù‰ Ù…Ø¹ÙˆÙŠØ©";
		String ArbRenalDisease="Ø£Ù…Ø±Ø§Ø¶ Ø§Ù„ÙƒÙ„ÙŠ ";
		String ArbJaundiceHepatitis="ÙŠØ±Ù‚Ø§Ù† / Ø§Ù„ØªÙ‡Ø§Ø¨ ÙƒØ¨Ø¯ÙŠ";
		String ArbArthritis="Ø§Ù„ØªÙ‡Ø§Ø¨ Ø§Ù„Ù…Ù�Ø§ØµÙ„ "; 
		String ArbGonorrhoea="Ø³ÙŠÙ„Ø§Ù† ";
		String ArbAnaemia="Ù�Ù‚Ù€Ø± Ø§Ù„Ù€Ù€Ø¯Ù… " ;
		String ArbSyphilis="Ø²Ù‡Ù€Ù€Ø±ÙŠ";
		String ArbPepticUlcer="Ù‚Ø±Ø­Ù€Ø© Ø§Ù„Ù…Ø¹Ù€Ø¯Ø© ";
		String ArbSkinDiseases="Ø£Ù…Ø±Ø§Ø¶ Ø¬Ù„Ø¯ÙŠØ©";
		String ArbPsychiatricProblems="Ø£Ù…Ø±Ø§Ø¶ Ù†Ù�Ø³ÙŠØ© ÙˆØ¹ØµØ¨ÙŠØ© ";
		String ArbSickleCell="Ø£Ù†ÙŠÙ…ÙŠØ§ Ø§Ù„Ø®Ù„ÙŠØ© Ø§Ù„Ù…Ù†Ø¬Ù„ÙŠØ©";
		String ArbEpilepsyMigraine="ØµØ±Ø¹ / ØµØ¯Ø§Ø¹ Ù†ØµÙ�ÙŠ";
		String ArbStroke="Ø³ÙƒØªØ© Ø¯Ù…Ø§ØºÙŠØ© (Ø¶Ø±Ø¨Ø©)";
		String ArbAnymajorIllness="Ø£ÙŠ Ù…Ø±Ø¶ Ù‡Ù€Ø§Ù… ";
		String ArbFORFEMALECANDIDATESONLY="Ù„Ù„Ù†Ø³Ù€Ù€Ù€Ù€Ø§Ø¡ Ù�Ù‚Ù€Ù€Ù€Ù€Ø· ";
		String ArbAreyoupregnan="Ù‡Ù„ Ø£Ù†Øª Ø­Ø§Ù…Ù„ØŸ Ù�ÙŠ Ø­Ø§Ù„Ø© Ø§Ù„Ø­Ù…Ù„ Ø§Ø°ÙƒØ±ÙŠ Ø§Ù„Ù…Ø¯Ø© ";
		String ArbHead="Ø£ØµØ±Ø­ Ø¨Ø£Ù† Ø§Ù„Ù…Ø¹Ù„ÙˆÙ…Ø§Øª Ø§Ù„Ù…Ù‚Ø¯Ù…Ø© Ù…Ù†Ù‰ Ø£Ø¹Ù„Ø§Ù‡ ØµØ­ÙŠØ­Ø© Ø­Ø³Ø¨ Ù…Ø¹Ø±Ù�ØªÙ€ÙŠ ÙˆØ§Ø¹ØªÙ‚Ø§Ø¯ÙŠ";
		String ArbPara1="Ø£ÙˆØ§Ù�Ù‚ Ø¹Ù„Ù‰ Ø£Ù† ÙŠÙ‚ÙˆÙ… Ø§Ù„Ù…Ø³ØªØ´Ù�Ù‰ Ø£Ùˆ Ø§Ù„Ø¹ÙŠÙ€Ø§Ø¯Ø© ÙˆØ§Ù„Ø·Ø¨ÙŠØ¨ Ø§Ù„Ù…ÙˆÙ‚Ø¹ Ø£Ø¯Ù†Ø§Ù‡ Ø¨ØªÙ‚Ø¯ÙŠÙ… Ø§Ù„Ù…Ø¹Ù„ÙˆÙ…Ø§Øª Ø§Ù„ØªÙŠ Ù‚Ø¯ ØªØ­ØªØ§Ø¬Ù‡Ø§ Ø§Ù„Ø´Ø±ÙƒØ© Ø­ÙˆÙ„ ÙˆØ¶Ø¹ÙŠ Ø§Ù„ØµØ­ÙŠ ØŒ ÙˆØ£Ø¹Ù�ÙŠÙ‡Ù… Ù…Ù† ÙƒØ§Ù�Ø©";
		String ArbPara2="Ø§Ù„Ù…Ø³Ø¦ÙˆÙ„ÙŠØ§Øª Ø§Ù„Ù‚Ø§Ù†ÙˆÙ†ÙŠØ© Ø§Ù„ØªÙŠ Ù‚Ø¯ ØªØªØ±ØªØ¨ Ø¹Ù„Ù‰ Ù‚ÙŠØ§Ù…Ù‡Ù… Ø¨Ø°Ù„Ùƒ . ÙƒÙ…Ø§ Ø£Ù‚Ø± Ø¨Ø£Ù† ØªØ§Ø±ÙŠØ®ÙŠ Ø§Ù„Ø·Ø¨ÙŠ Ø§Ù„Ù…ÙˆØ¶Ø­ Ø£Ø¹Ù„Ø§Ù‡ Ø­Ù‚ÙŠÙ‚ÙŠØ§ ÙˆØ£Ù† Ø£ÙŠØ© Ù…Ø¹Ù„ÙˆÙ…Ø§Øª Ù…ØºÙ„ÙˆØ·Ø© Ø³ØªØ­Ø±Ù…Ù†ÙŠ Ù…Ù†";
		String ArbPara3="Ø¨Ø±Ù†Ø§Ù…Ø¬ Ø§Ù„ØªØ£Ù…ÙŠÙ† .";
		String ArbSignature="ØªÙˆÙ‚ÙŠØ¹ Ø§Ù„Ù…Ø¤Ù…Ù† Ø¹Ù„ÙŠÙ‡ " ;
		String Arbcorrect1=" Ù�ÙŠ Ø­Ø§Ù„Ø© Ø§Ù„Ù†Ù�ÙŠ";
		String Arbtick1="Ù‡Ù„ Ø³Ø¨Ù‚ ÙˆØ£Ù† ØªØ¹Ø±Ø¶Øª Ù„Ø¢ÙŠ Ù…Ù† Ø§Ù„Ø£Ù…Ø±Ø§Ø¶ Ø§Ù„ØªØ§Ù„ÙŠØ© Ø¶Ø¹ Ø¹Ù„Ø§Ù…Ø©  ";
		String Arbtick2="( X )";
		String Arbtick3=" Ù�ÙŠ Ø­Ø§Ù„Ø© Ø§Ù„Ø¥ÙŠØ¬Ø§Ø¨ Ùˆ";
		String Arbtick4="( âˆš )";
		
		if(questionaireType != null)
		{

		for(int i=0;i<questionaireType.size();i++){

			if("FINANCIALQUESTIONAIRE SWISS".equalsIgnoreCase(questionaireType.get(i)))
			{
				System.out.println("FINANCIALQUESTIONAIRE SWISS");
				pdfFilepath = new File(request.getRealPath("/")
						+ ("/WEB-INF/reports/Quotationaries/FinancialQuestionairreSwissre.jasper"));
			}else if("CARDIAC SURGERY CARDIOLOGIST".equalsIgnoreCase(questionaireType.get(i)))
			{
				System.out.println("CARDIAC SURGERY CARDIOLOGIST");
				pdfFilepath = new File(request.getRealPath("/")
						+ ("/WEB-INF/reports/Quotationaries/CADCABGQR.jasper"));
			}else if("FINANCIALQUESTIONNAIRE LETTER".equalsIgnoreCase(questionaireType.get(i)))
			{
				System.out.println("FINANCIALQUESTIONNAIRE LETTER");
				pdfFilepath = new File(request.getRealPath("/")
						+ ("/WEB-INF/reports/Quotationaries/Financialqr.jasper"));
				
			}else if("SICKLE CELL DISEASE".equalsIgnoreCase(questionaireType.get(i)))
			{
				System.out.println("SICKLE CELL DISEASE");
				pdfFilepath = new File(request.getRealPath("/")
						+ ("/WEB-INF/reports/Quotationaries/sickle.jasper"));
			}else if("PEPTICULCER QUESTIONNAIRE".equalsIgnoreCase(questionaireType.get(i)))
			{
				pdfFilepath = new File(request.getRealPath("/")
						+ ("/WEB-INF/reports/Quotationaries/PepticUlcer.jasper"));
			}else if("FINANCIALQUESTIONNAIRE BANKLOAN SWISS".equalsIgnoreCase(questionaireType.get(i)))
			{
				pdfFilepath = new File(request.getRealPath("/")
						+ ("/WEB-INF/reports/Quotationaries/Financial_questionnaire.jasper"));
			}else if("DIABETES MELLITUS".equalsIgnoreCase(questionaireType.get(i)))
			{
				pdfFilepath = new File(request.getRealPath("/")
						+ ("/WEB-INF/reports/Quotationaries/Diabetes_ Mellitus_Questionnaire.jasper"));

			}else if("DIVING QUESTIONNAIRE".equalsIgnoreCase(questionaireType.get(i)))
			{
				pdfFilepath = new File(request.getRealPath("/")
						+ ("/WEB-INF/reports/Quotationaries/DIVINGQUESTIONNAIRE.jasper"));

			}else if("TUMOUR QUESTIONNAIRE".equalsIgnoreCase(questionaireType.get(i)))
			{
				System.out.println("TUMOUR QUESTIONNAIRE");
				pdfFilepath = new File(request.getRealPath("/")
						+ ("/WEB-INF/reports/Quotationaries/TumourQuestionnaire.jasper"));
			}else if("OCCUPATION QUESTIONNAIRE_1".equalsIgnoreCase(questionaireType.get(i)))
			{
				pdfFilepath = new File(request.getRealPath("/")
						+ ("/WEB-INF/reports/Quotationaries/OCCUPATIONQUESTIONNAIRE-1.jasper"));
			}else if("OCCUPATION QUESTIONNAIRE_2".equalsIgnoreCase(questionaireType.get(i)))
			{
				pdfFilepath = new File(request.getRealPath("/")
						+ ("/WEB-INF/reports/Quotationaries/OCCUPATIONQUESTIONNAIRE-2.jasper"));

			}else if("FINANCIALQUESTIONNAIRE SHORTFORM".equalsIgnoreCase(questionaireType.get(i)))
			{
				pdfFilepath = new File(request.getRealPath("/")
						+ ("/WEB-INF/reports/Quotationaries/FINANCIALQUESTIONNAIREshortform.jasper"));

			}else if("ASTHMA RESPIRATORY DISORDERS".equalsIgnoreCase(questionaireType.get(i)))
			{
				pdfFilepath = new File(request.getRealPath("/")
						+ ("/WEB-INF/reports/Quotationaries/Asthma.jasper"));

			}else if("HEALTH DECLARATION ARABICGL".equalsIgnoreCase(questionaireType.get(i)))
			{
				pdfFilepath = new File(request.getRealPath("/")
						+ ("/WEB-INF/reports/Quotationaries/HDArabicGL.jasper"));
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

			}else if("BLOODPRESSURE".equalsIgnoreCase(questionaireType.get(i)))
			{
				pdfFilepath = new File(request.getRealPath("/")
						+ ("/WEB-INF/reports/Quotationaries/BloodPressure.jasper"));

			}else if("CORONARY ARTERY DISEASE QUESTIONNAIRE".equalsIgnoreCase(questionaireType.get(i)))
			{
				pdfFilepath = new File(request.getRealPath("/")
						+ ("/WEB-INF/reports/Quotationaries/CADQUES.jasper"));

			}else if("THYROID QUESTIONNAIRE".equalsIgnoreCase(questionaireType.get(i)))
			{
				System.out.println("THYROID");
				pdfFilepath = new File(request.getRealPath("/")
						+ ("/WEB-INF/reports/Quotationaries/Thyroid.jasper"));

			}else if("KEYMANINSURANCE QUESTIONNAIRE".equalsIgnoreCase(questionaireType.get(i)))
			{
				pdfFilepath = new File(request.getRealPath("/")
						+ ("/WEB-INF/reports/Quotationaries/KEYMANINSURANCEQUESTIONNAIRE.jasper"));

			}
			
			
			else if("MILITARY AVIATION".equalsIgnoreCase(questionaireType.get(i)))
			{
				System.out.println("MILITARY AVIATION");
				pdfFilepath = new File(request.getRealPath("/")
						+ ("/WEB-INF/reports/Quotationaries/military.jasper"));
			}
			
			else if("STROKE QUESTIONNAIRE".equalsIgnoreCase(questionaireType.get(i)))
			{
				pdfFilepath = new File(request.getRealPath("/")
						+ ("/WEB-INF/reports/Quotationaries/Stroke.jasper"));
			}else if("MEDICALEXAMINATION FORM".equalsIgnoreCase(questionaireType.get(i)))
			{
				pdfFilepath = new File(request.getRealPath("/")
						+ ("/WEB-INF/reports/Quotationaries/MedicalReportFIC2008.jasper"));
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
				param.put("Stroke", Stroke);
				param.put("SickleCellAnaemia", SickleCellAnaemia);
				param.put("SkinDiseases", SkinDiseases);
				param.put("AnymajorIllness", AnymajorIllness);
				param.put("Epilepsy", Epilepsy);
				param.put("Psychiatric", Psychiatric);
				param.put("PepticUlcer", PepticUlcer);
				param.put("Anaemia", Anaemia);
				param.put("Arthritis", Arthritis);
				param.put("RenalDisease", RenalDisease);
				param.put("Asthma", Asthma);
				param.put("Diabetes", Diabetes);
				param.put("HeartDisease", HeartDisease);
				param.put("Hypertension", Hypertension);
				param.put("Title2", Title2);
				param.put("Title1", Title1);
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
			}	
		
	
		
		JasperReport jr = (JasperReport) JRLoader.loadObject(pdfFilepath);
		JasperPrint jp=null;
		
		if(questionaireType.get(i)!=null){
			JRBeanCollectionDataSource jbs = new JRBeanCollectionDataSource(null);
			jp = JasperFillManager.fillReport(jr,param, new JREmptyDataSource());
		}else{
			jp = JasperFillManager.fillReport(jr, param, connection);
		}
		
		
		
		

		/*END*/

		byteArr = JasperExportManager.exportReportToPdf(jp);
		
		System.out.println("Bal   : "+byteArr);
		
		final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        
        int rootindex = dir.indexOf(File.separator);
        
        System.out.println(dir.substring(0, rootindex));
        
        File filedir = new File(dir.substring(0, rootindex)+File.separator+"pdf");
        
        if(!filedir.exists()){
        	filedir.mkdir();
        }
						
		String rootpath = dir.substring(0, rootindex)+File.separator+"pdf"+File.separator;
		
		System.out.println("Root Path        "+rootpath);
		
		String fileName = questionaireType.get(i)+".pdf";
		
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
        connection.close();
        
        totalFilePath += outfile.getAbsolutePath()+"|";
       
        
		}
}
		
		/*Added by Raja R on 04-07-2016.SSP Call ID - FALCONQC-1714578
        Start*/
		System.out.println("QUTIONNARIES TYPE   :::::   "+compositeAction.getPRINT_ACTION_BEAN().getUI_M_QUESTIONNAIRE_TYPE());

		
		String reportType = "";
		if(compositeAction.getPRINT_ACTION_BEAN().getUI_M_QUESTIONNAIRE_TYPE().equals("OCCUPATION")){
			reportType = "OQN";
			
		}else if(compositeAction.getPRINT_ACTION_BEAN().getUI_M_QUESTIONNAIRE_TYPE().equals("MEDICAL")){
			reportType = "MQN";
			
		}else if(compositeAction.getPRINT_ACTION_BEAN().getUI_M_QUESTIONNAIRE_TYPE().equals("FINANCIAL")){
			reportType = "FQN";
			
		}
		
		else if(compositeAction.getPRINT_ACTION_BEAN().getUI_M_QUESTIONNAIRE_TYPE().equals("BMI")){
			reportType = "BQN";
		}
		
		else {
			reportType = "POL";
		}
		
		/*End of SSP Call ID - FALCONQC-1714578 */
		
		
		System.out.println("POL-->"+compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
		String propPolSysId = (compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DS_TYPE().equals("1"))?compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROP_SYS_ID().toString():compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID().toString();
		
		/*Added by Raja R on 04-07-2016.SSP Call ID - FALCONQC-1714578
        Start*/
		
		String procOutValue = emailTriggerProcCall(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE(),reportType,compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID().toString(),"C",totalFilePath);
		System.out.println("filepaths-->["+totalFilePath+"]");
		if("N".equalsIgnoreCase(procOutValue)){
			throw new ValidatorException(new FacesMessage("Unable to send mail to Customer due to email Id is unavailable"));
		}else if("T".equalsIgnoreCase(procOutValue)){
			throw new ValidatorException(new FacesMessage("Email template is unavailable in master setup"));
		}		
		/*End of SSP Call ID - FALCONQC-1714578 */
	}
	

	public String emailTriggerProcCall(String P_PROD_CODE,String P_MAIL_TYPE, String P_POL_SYS_ID, String P_CUST_TYPE,String P_MAIL_PATH) throws Exception{
	
	Connection con=CommonUtils.getConnection();
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
    CommonUtils.doComitt();
    Iterator<OracleParameter> iterator = outputList.iterator();
    while (iterator.hasNext()) {
        OracleParameter oracleParameter = iterator.next();
        System.out.println("Output value:::" + oracleParameter.getValue());
		out=(String)oracleParameter.getValue();
    }
	return out;
	}




public String getAttachment_YN()
		throws Exception {
	ResultSet resultSet = null;
	String attachfrzflag=" ";
	String s1 = " SELECT PMT_ATTACH_YN FROM PM_LIFE_MAIL_TEMPLATE WHERE PMT_MAIL_TYPE= ?";
	try {
		
		resultSet = new CRUDHandler().executeSelectStatement(s1,
				CommonUtils.getConnection(), new Object[] {"POL"});
		if (resultSet.next()) {
			attachfrzflag = resultSet.getString("PMT_ATTACH_YN");
		}
	
		//	L_GEN_POL_ENDT_NO(compositeAction);

	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} finally {
		try {
			CommonUtils.closeCursor(resultSet);
		} catch (Exception e) {
		}
	}
	return attachfrzflag;

}






}
