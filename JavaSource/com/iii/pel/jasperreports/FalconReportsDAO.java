package com.iii.pel.jasperreports;



import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;


public class FalconReportsDAO{

	final ResourceBundle resourceBundle=ResourceBundle.getBundle("FalconReports_Surrender");
	 
	private HashMap param; 

   public byte[] generateJasperPrint(String policy_no,String to) throws Exception
	{
	   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	   Date date = new Date();
	   String dat=dateFormat.format(date);
		byte[] policyReport = null;
		String nop=resourceBundle.getString("nop");
			String dos=resourceBundle.getString("dos");
			String svomr=resourceBundle.getString("svomr");
			String lessloan=resourceBundle.getString("lessloan");
			String lessloanint=resourceBundle.getString("lessloanint");
			String balancepay=resourceBundle.getString("balancepay");
			System.out.println(nop+dos+svomr+lessloan+lessloanint+balancepay);
		
		System.out.println("entered into generateJasperPrint ");
		
		try
		{

			System.out.println("resourceBundle.getString(path)       "+resourceBundle.getString("pdf_gen_path"));	          
				File pdfFilepath = new File(resourceBundle.getString("pdf_gen_path")+("/WEB-INF/reports/Surrender_value_Intimation.jasper"));
	          		       
				JasperReport jr = (JasperReport)JRLoader.loadObject(pdfFilepath);
				System.out.println(jr);
	   			
			
				param = new HashMap();
				param.put("Policy_no", policy_no);
				param.put("to", to);
				param.put("date",dat);
				param.put("Name_policy", nop);
				param.put("Date_surr", dos);
				param.put("Surr_val", svomr);
				param.put("Less_loan", lessloan);
				param.put("Less_loan_int", lessloanint);
				param.put("balance_pay", balancepay);
				
				JasperPrint jp = JasperFillManager.fillReport(jr, param);
				policyReport = JasperExportManager.exportReportToPdf(jp);
				
System.out.println("policyReport      "+policyReport);
			
			
		
		
		
		} catch (MissingResourceException e) {
        	 
        	 
		}
         
        catch(Exception e){
        	 
         
   		
    	}
		 return policyReport;
		 
		
	}
	
   

   
}