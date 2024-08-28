package com.iii.pel.jasperreports;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;










/*import org.apache.poi.XSSF.usermodel.XSSFCellStyle;
import org.apache.poi.XSSF.usermodel.XSSFRow;
import org.apache.poi.XSSF.usermodel.XSSFWorkbook;*/
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.utils.CommonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ExcelReports {
	/*Modified by rakesh on 19-03-2020 for orient*/
	public void writeExcelDeatails(HttpServletResponse response,String polSysId,Connection con,String dateFrmandTo,String repId,List paramvalues)throws ParseException{
		  List<JasperPrint> jpList = null;
		  JasperReport jr = null;
		  JasperPrint jp = null;
		  JRPdfExporter exporter = null;
		  ByteArrayOutputStream out = null;
		  JRXlsxExporter xlsExporter = null;
		  String fileName = null;
		  ArrayList<String> jasperFileName = null;
		  String jasperPath = null;
		  String query = null;
		  ResultSet rs = null;
		  ResultSet rs1 = null;
		  ResultSet rsMultiReport = null;
		  String queryMultiReport = null;
		  String queryParam = null;
		  boolean xls = false;
		  HashMap  param = null;
		  HashMap<String,String> paramVarValues = null;
		  BufferedOutputStream bos = null;
		  byte[]  writeVal = null;
		  /*End*/
		  String[] pol_sys_id = null;
		try{
			System.out.println("-- polSysId --  "+polSysId);
			paramVarValues = new HashMap<String,String>();
			
			/*Added by saritha on 03-01-2020 for ORIENT - OCD Payout Process(Premium Possiession Report)*/
			if(polSysId !=null){
				pol_sys_id = polSysId.split("&&&");
				if(pol_sys_id != null && pol_sys_id.length == 2){
					paramVarValues.put("polSysId", pol_sys_id[1]);
				}else{
					paramVarValues.put("polSysId", pol_sys_id[0]);
				}
				paramVarValues.put("dateFrmandTo", dateFrmandTo);
			}
			/*Added by rakesh on 19-03-2020 for orient*/
			else
			{
				for(int i=0; i < paramvalues.size();i++)
				{
					paramVarValues.put("PARAM"+(i+2), (String) paramvalues.get(i));
					System.out.println("paramVarValues         "+(String) paramvalues.get(i));
				}
				
			}
			//END
		
			
			
			//jasperPath = System.getProperty("user.home")+File.separator+"JasperReportPath"+File.separator;
			String url5 = System.getProperty("user.home");
			/*End*/
			jasperPath = url5;
			query = "SELECT * FROM PM_REP_TAB_HDR WHERE PMRTH_REP_CATG = 'LJ' AND PMRTH_REP_ID = ?";
			rs = new CRUDHandler().executeSelectStatement(query, con, new Object[]{repId});
			if(rs.next()){
				jasperFileName = new ArrayList<String>();
				jasperFileName.add(rs.getString("PMRTH_REP_TEMP_NAME_ID"));
				fileName = rs.getString("PMRTH_REP_NAME");
				if("Y".equalsIgnoreCase(rs.getString("PMRTH_MULTI_REPORT"))){
					  if(rs.getString("PMRTH_MULTIPLE_REPORT_NAMES") != null ){
						  List<String> jList = Arrays.asList(rs.getString("PMRTH_MULTIPLE_REPORT_NAMES").split(","));
						  for(int i=0; i< jList.size(); i++){
							  queryMultiReport = "SELECT * FROM PM_REP_TAB_HDR WHERE PMRTH_REP_CATG = 'JAS' AND PMRTH_REP_ID='"+jList.get(i)+"'";
							  rsMultiReport = new CRUDHandler().executeSelectStatement(queryMultiReport, con);
							  if(rsMultiReport.next()){
								  jasperFileName.add(rsMultiReport.getString("PMRTH_REP_TEMP_NAME_ID"));
							  }
						  }
					  }
				  }
				  if("xls".equalsIgnoreCase(rs.getString("PMRTH_REPORT_CATG"))){
					  xls = true;
				  }
				  queryParam = "SELECT * FROM PM_REP_TAB_MED WHERE PMRTM_REP_ID LIKE '%"+repId+"%'";
				  rs1 = new CRUDHandler().executeSelectStatement(queryParam, con);
				  param = new HashMap<String,String>();
				  while(rs1.next()){
						  if("Y".equalsIgnoreCase(rs1.getString("PMRTM_REP_VAR"))){
							  param.put(rs1.getString("PMRTM_REP_PARAM_NAME"),paramVarValues.get(rs1.getString("PMRTM_REP_PARAM_VALUE")));
						  }  
				  }
				  jpList = new ArrayList<JasperPrint>();
				  for(int i=0;i<jasperFileName.size();i++){
					  jr = (JasperReport)JRLoader.loadObject(jasperPath+jasperFileName.get(i));
					  jp = JasperFillManager.fillReport(jr, param, con);
					  jpList.add(jp);
				  }
				  out = new ByteArrayOutputStream();
				  if(xls){
				  		xlsExporter = new  JRXlsxExporter();
				  		xlsExporter.setParameter(JRXlsExporterParameter.JASPER_PRINT_LIST,jpList);
				  		xlsExporter.setParameter(JRExporterParameter.OUTPUT_STREAM,out);
				  		xlsExporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
		    	  		xlsExporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
		    	  		xlsExporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
		    	  		xlsExporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
		    	  		xlsExporter.exportReport();
		    	  		
		    	  		response.setContentType("application/vnd.openxml");
		    	  		response.setHeader("Content-Disposition", "inline; filename="+fileName+".xlsx");
						response.setHeader("Pragma", "public");
						response.setHeader("Cache-Control", "no-store");
						response.addHeader("Cache-Control", "max-age=0");
			 	}
			}
			writeVal = out.toByteArray();
		      bos = new BufferedOutputStream(response
		              .getOutputStream());
		      bos.write(writeVal);
		      bos.flush();
		      bos.close();
		      System.out.println("end of processRequest");
		}catch(Exception e){
			e.printStackTrace();
		}
		/* Added by Shahbaz khan 16/03/2020 for Close the result Set */
		finally {
					try {
						CommonUtils.closeCursor(rs1);
						CommonUtils.closeCursor(rs);
						CommonUtils.closeCursor(rsMultiReport);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
	}


}
