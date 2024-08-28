package com.iii.pel.jasperreports;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
import org.apache.poi.xssf.usermodel.XSSFFont;

import com.iii.apps.persistence.CRUDHandler;

public class PremiaExceWriter_AgentWiseBusiness {
	private final static ResourceBundle resourceBundle = ResourceBundle
			.getBundle("Report_ID");
	public String AgentFileName(String fileName){

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
	
	/*commented by gopi for excelwrite in home patch on 25/09/17*/
	/*public String createDir(String DirName){
		final String dir = System.getProperty("user.dir");
		System.out.println("current dir = " + dir);
		int rootindex = dir.indexOf(File.separator);
		System.out.println(dir.substring(0, rootindex));
		added by gopi for dynamic excel folder create on 12/05/17
		File filedir = new File(dir.substring(0, rootindex)+File.separator+DirName);
		End
		if(!filedir.exists()){
			filedir.mkdir();
		}
		added by gopi for dynamic excel folder create on 12/05/17
		String rootpath = dir.substring(0, rootindex)+File.separator+DirName+File.separator;
		End
		System.out.println("Root Path        "+rootpath);

		return rootpath;
	}*/
	//end
	/*added by gopi for excelwrite in home patch on 25/09/17*/
	public String createDir(String DirName){
		final String dir = System.getProperty("user.home");
		System.out.println("current dir = " + dir);

		//int rootindex = dir.indexOf(File.separator);

		//System.out.println(dir.substring(0, rootindex));
		
		/*added by gopi for dynamic excel folder create on 12/05/17*/
		File filedir = new File(dir+File.separator+DirName);

		/*File filedir = new File(dir.substring(0, rootindex)+File.separator+"AgentWiseExcel");*/

		/*End*/
		
		
		if(!filedir.exists()){
			filedir.mkdir();
		}

		/*added by gopi for dynamic excel folder create on 12/05/17*/
		
		/*String rootpath = dir.substring(0, rootindex)+File.separator+"AgentWiseExcel"+File.separator;*/

		String rootpath = dir+File.separator+DirName+File.separator;
		
		/*End*/
		
		
		
		System.out.println("Root Path        "+rootpath);

		return rootpath;
	}
	//end
	public String writeAgentWiseExcel(ArrayList<String> list1,Connection con,String fileName , String ReportName , List param) throws ParseException{

		String excelGenPath = "";
		Connection conn = null;
		ResultSet rs = null;
		
	/*	String P_SEQ_VAL=list1.get(0);*/
		
		String AgentWiseFileName = AgentFileName(fileName);
		System.out.println("agentwise_business ==>>>>"+AgentWiseFileName);
		
		/*added by gopi on 12/05/17*/
		
		/*String directory=createDir();*/
		String directory=createDir("AgentWiseExcel");
				
		/*End*/
		
		
		
		System.out.println("directory ==>>>"+directory);
		excelGenPath=directory+""+AgentWiseFileName+".xls";
		System.out.println("agentwise_business ==>>>>"+AgentWiseFileName+"::directory ==>>>"+directory+"::excelGenPath==>>>>"+excelGenPath);
		
		
		
		Workbook workbook = (Workbook) new HSSFWorkbook();

		Sheet studentsSheet = workbook.createSheet("agentwise_business");

		HSSFCellStyle borderStyle=(HSSFCellStyle) workbook.createCellStyle();
		borderStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		borderStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		borderStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		borderStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);

		int rowIndex = 2;
		int rootrowIndex = 2;
		Row secondRow = studentsSheet.createRow(rowIndex++);
		Row firstRow = studentsSheet.createRow(rootrowIndex++);
		Row beforeFirstRow = studentsSheet.createRow(0);
		Row beforeSecondRow = studentsSheet.createRow(1);
		int cellIndex = 0;

		beforeFirstRow.createCell(0).setCellValue("Agent code");
		beforeFirstRow.createCell(1).setCellValue("Agent Name");


		Cell cell  = null;
		CellStyle style = null;
		CellRangeAddress basicRang = null;

		cell = beforeFirstRow.createCell(2);
		cell.setCellValue("RSP");
		style = workbook.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		cell.setCellStyle(style);
		basicRang = new CellRangeAddress(0,0,2,5);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		studentsSheet.addMergedRegion(new CellRangeAddress(0,0,2,5));

		cell = beforeFirstRow.createCell(6);
		cell.setCellValue("FAP");
		style = workbook.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		cell.setCellStyle(style);
		basicRang = new CellRangeAddress(0,0,6,9);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		studentsSheet.addMergedRegion(new CellRangeAddress(0,0,6,9));

		cell = beforeFirstRow.createCell(10);
		cell.setCellValue("MPP");
		style = workbook.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		cell.setCellStyle(style);
		basicRang = new CellRangeAddress(0,0,10,13);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		studentsSheet.addMergedRegion(new CellRangeAddress(0,0,10,13));

		cell = beforeFirstRow.createCell(14);
		cell.setCellValue("LPP-SWISS RE");
		style = workbook.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		cell.setCellStyle(style);
		basicRang = new CellRangeAddress(0,0,14,17);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		studentsSheet.addMergedRegion(new CellRangeAddress(0,0,14,17));


		cell = beforeFirstRow.createCell(18);
		cell.setCellValue("LPPM-MUNICHE RE");
		style = workbook.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		cell.setCellStyle(style);
		basicRang = new CellRangeAddress(0,0,18,21);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		studentsSheet.addMergedRegion(new CellRangeAddress(0,0,18,21));




		CellStyle firststyle = workbook.createCellStyle();
		firststyle.setBorderTop(CellStyle.BORDER_THIN);
		firststyle.setBorderBottom(CellStyle.BORDER_THIN);
		firststyle.setBorderLeft(CellStyle.BORDER_THIN);
		firststyle.setBorderRight(CellStyle.BORDER_THIN);

		Cell firstCell2 = beforeSecondRow.createCell(2);
		firstCell2.setCellValue("No of policies");
		firstCell2.setCellStyle(firststyle);

		Cell firstCell3 = beforeSecondRow.createCell(3);
		firstCell3.setCellValue("Total sum assured");
		firstCell3.setCellStyle(firststyle);

		Cell firstCell4 = beforeSecondRow.createCell(4);
		firstCell4.setCellValue("Premium ");
		firstCell4.setCellStyle(firststyle);

		Cell firstCell5 = beforeSecondRow.createCell(5);
		firstCell5.setCellValue("Commission");
		firstCell5.setCellStyle(firststyle);


		Cell firstCell6 = beforeSecondRow.createCell(6);
		firstCell6.setCellValue("No of policies");
		firstCell6.setCellStyle(firststyle);

		Cell firstCell7 = beforeSecondRow.createCell(7);
		firstCell7.setCellValue("Total sum assured");
		firstCell7.setCellStyle(firststyle);

		Cell firstCell8 = beforeSecondRow.createCell(8);
		firstCell8.setCellValue("Premium");
		firstCell8.setCellStyle(firststyle);

		Cell firstCell9 = beforeSecondRow.createCell(9);
		firstCell9.setCellValue("Commission");
		firstCell9.setCellStyle(firststyle);

		//

		Cell firstCell10 = beforeSecondRow.createCell(10);
		firstCell10.setCellValue("No of policies");
		firstCell10.setCellStyle(firststyle);

		Cell firstCell11 = beforeSecondRow.createCell(11);
		firstCell11.setCellValue("Total sum assured");
		firstCell11.setCellStyle(firststyle);

		Cell firstCell12 = beforeSecondRow.createCell(12);
		firstCell12.setCellValue("Premium ");
		firstCell12.setCellStyle(firststyle);

		Cell firstCell13 = beforeSecondRow.createCell(13);
		firstCell13.setCellValue("Commission");
		firstCell13.setCellStyle(firststyle);


		Cell firstCell14 = beforeSecondRow.createCell(14);
		firstCell14.setCellValue("No of policies");
		firstCell14.setCellStyle(firststyle);

		Cell firstCell15 = beforeSecondRow.createCell(15);
		firstCell15.setCellValue("Total sum assured");
		firstCell15.setCellStyle(firststyle);

		Cell firstCell16 = beforeSecondRow.createCell(16);
		firstCell16.setCellValue("Premium ");
		firstCell16.setCellStyle(firststyle);

		Cell firstCell17 = beforeSecondRow.createCell(17);
		firstCell17.setCellValue("Commission");
		firstCell17.setCellStyle(firststyle);


		Cell firstCell18 = beforeSecondRow.createCell(18);
		firstCell18.setCellValue("No of policies");
		firstCell18.setCellStyle(firststyle);

		Cell firstCell19 = beforeSecondRow.createCell(19);
		firstCell19.setCellValue("Total sum assured");
		firstCell9.setCellStyle(firststyle);

		Cell firstCell20 = beforeSecondRow.createCell(20);
		firstCell20.setCellValue("Premium ");
		firstCell20.setCellStyle(firststyle);

		Cell firstCell21 = beforeSecondRow.createCell(21);
		firstCell21.setCellValue("Commission");
		firstCell21.setCellStyle(firststyle);


		try{
			
			String AgentCodeFM = null;
			String AgentCodeTO = null;
			String ApproveDateFM = null;
			String ApproveDateTO = null;
			
			List<String> paramList = new ArrayList<String>();
			
			 AgentCodeFM    = param.get(0).toString().trim();
			 AgentCodeTO    = param.get(1).toString().trim(); 
			 ApproveDateFM  = param.get(2).toString().trim(); 
			 ApproveDateTO  = param.get(3).toString().trim(); 
			
			String QueryCount= resourceBundle.getString("P11_PILR_15B_CountQuery");
			String MainQuery=resourceBundle.getString("P11_PILR_15B_MainQuery");
			ResultSet res=new CRUDHandler().executeSelectStatement(QueryCount, con, 
					new Object[]{ AgentCodeFM,AgentCodeTO,ApproveDateFM,ApproveDateTO });
			if(res.next()){
				if(res.getInt(1)>0){

					try {
						rs = new CRUDHandler().executeSelectStatement(MainQuery,con,
								new Object[]{ AgentCodeFM,AgentCodeTO,ApproveDateFM,ApproveDateTO });


						while(rs.next())
						{
							System.out.println("inside resultset while ::"+rowIndex);
							Row row = studentsSheet.createRow(rowIndex++);
							cellIndex = 0;

							row.createCell(cellIndex++).setCellValue(rs.getString("PAP_AGENT_CODE"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PAP_AGENT_NAME"));

							row.createCell(cellIndex++).setCellValue(rs.getString("PAP_RSP_NO_OF_POL"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PAP_RSP_TOT_SA"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PAP_RSP_PREM"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PAP_RSP_COMM"));

							row.createCell(cellIndex++).setCellValue(rs.getString("PAP_FAP_NO_OF_POL"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PAP_FAP_TOT_SA"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PAP_FAP_PREM"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PAP_FAP_COMM"));

							row.createCell(cellIndex++).setCellValue(rs.getString("PAP_MPP_NO_OF_POL"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PAP_MPP_TOT_SA"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PAP_MPP_PREM"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PAP_MPP_COMM"));

							row.createCell(cellIndex++).setCellValue(rs.getString("PAP_LPPA_NO_OF_POL"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PAP_LPPA_TOT_SA"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PAP_LPPA_PREM"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PAP_LPPA_COMM"));

							row.createCell(cellIndex++).setCellValue(rs.getString("PAP_LPPM_NO_OF_POL"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PAP_LPPM_TOT_SA"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PAP_LPPM_PREM"));
							row.createCell(cellIndex++).setCellValue(rs.getString("PAP_LPPM_COMM"));



						}
						System.out.println("cellindex"+cellIndex);
						for(int a = 0 ;a<cellIndex;a++){
							studentsSheet.autoSizeColumn(a);
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}

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

	/*modified by gopi for ssp call id ZBILQC-1731319 on14/07/17*/
/*added by gopi for policy movement report on 10/05/17*/
	
	public String writePolicyMovementReportExcel(ArrayList<String> list1,Connection con,String fileName , String ReportName ,List param ) throws ParseException, Exception{

		

		String CountQuery="select count(POAC_COVER_CODE) count from (SELECT DISTINCT POAC_COVER_CODE FROM PT_IL_POL_ADDL_COVER, PM_IL_PROD_APPL_COVER WHERE POAC_COVER_CODE = PAC_COVER_CODE "
				+ "AND PAC_PROD_CODE = ? ORDER BY POAC_COVER_CODE)";
		
		String CoverQuery="SELECT DISTINCT POAC_COVER_CODE FROM PT_IL_POL_ADDL_COVER, PM_IL_PROD_APPL_COVER WHERE POAC_COVER_CODE = PAC_COVER_CODE "
				+ "AND PAC_PROD_CODE =? ORDER BY POAC_COVER_CODE";
		
		String GetProd_code="SELECT PROD_CODE,PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE= ? ";
		
		
		String DetailQuery= null;
		String excelGenPath = "";
	//	Connection con = null;
		ResultSet rs,rs1,rs2,rs4= null;
		
	/*	String P_SEQ_VAL=list1.get(0);*/
		
		String AgentWiseFileName =fileName;
		System.out.println("agentwise_business ==>>>>"+AgentWiseFileName);
		String directory=createDir("ExcelWritingFolder");
		System.out.println("directory ==>>>"+directory);
		excelGenPath=directory+""+AgentWiseFileName+".xls";
		System.out.println("agentwise_business ==>>>>"+AgentWiseFileName+"::directory ==>>>"+directory+"::excelGenPath==>>>>"+excelGenPath);
		Workbook workbook =  (Workbook) new HSSFWorkbook();
		
		
		Font font = workbook.createFont();
		font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
		font.setFontHeightInPoints(Short.parseShort("12"));
		font.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
		
		Sheet studentsSheet = workbook.createSheet("PolicyMovementSheet");
		CellStyle style = null;
		style = workbook.createCellStyle();
		CellRangeAddress basicRang = null;
		Cell cell=null;
		Row RootRow = null;
	
		DataFormat hssfDataFormat = workbook.createDataFormat();
		
		String Prod_code =null;
		String Peroid_from =null;
		String Peroid_to =null;
		
		Prod_code  = param.get(0).toString().trim();
		Peroid_from = param.get(1).toString().trim();
		Peroid_to = param.get(2).toString().trim();
		
		
		int rowIndex1 = 0;
		short cellIndex1 = 2;
		
		/*RootRow = studentsSheet.createRow(rowIndex1);
		RootRow.createCell(cellIndex1).setCellValue("ZB LIFE ASSURANCE LIMITED");*/
	
		RootRow = studentsSheet.createRow(rowIndex1);
		cell = RootRow.createCell(cellIndex1);
		cell.setCellValue("ZB LIFE ASSURANCE LIMITED");
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints(Short.parseShort("10"));
		font.setFontName("Times New Roman");
		style.setFont(font);
		cell.setCellStyle(style);	
		//end
	
		basicRang = new CellRangeAddress(0,0,2,2);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		//RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		//RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		//RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
				
		/*RootRow = studentsSheet.createRow(2);
		RootRow.createCell((short) 1).setCellValue("POLICY MOVEMENTS SUMMARY REPORT FOR PERIOD");*/
		RootRow = studentsSheet.createRow(2);
		cell = RootRow.createCell((short) 1);
		cell.setCellValue("POLICY MOVEMENTS SUMMARY REPORT FOR PERIOD");
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints(Short.parseShort("10"));
		font.setFontName("Times New Roman");
		style.setFont(font);
		cell.setCellStyle(style);	
		studentsSheet.addMergedRegion(new CellRangeAddress(2,2,1,2));
		
		
		/*RootRow.createCell((short) 3).setCellValue(Peroid_from);
		basicRang = new CellRangeAddress(2,2,3,3);*/
		cell = RootRow.createCell((short) 3);
		cell.setCellValue(Peroid_from);
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints(Short.parseShort("10"));
		font.setFontName("Times New Roman");
		style.setFont(font);
		cell.setCellStyle(style);	
		basicRang = new CellRangeAddress(2,2,3,3);
		RegionUtil.setBorderBottom(CellStyle.BORDER_DOTTED,basicRang,studentsSheet,workbook);
		
		
		
		
		/*RootRow.createCell((short) 4).setCellValue("TO");*/
		cell = RootRow.createCell((short) 4);
		cell.setCellValue("TO");
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints(Short.parseShort("10"));
		font.setFontName("Times New Roman");
		style.setFont(font);
		cell.setCellStyle(style);	
		
		
		/*RootRow.createCell((short)5).setCellValue(Peroid_to);*/
		cell = RootRow.createCell((short) 5);
		cell.setCellValue(Peroid_to);
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints(Short.parseShort("10"));
		font.setFontName("Times New Roman");
		style.setFont(font);
		cell.setCellStyle(style);	
		basicRang = new CellRangeAddress(2,2,5,5);
		RegionUtil.setBorderBottom(CellStyle.BORDER_DOTTED,basicRang,studentsSheet,workbook);
		
		
		
		
		
		
		RootRow = studentsSheet.createRow(4);
		/*RootRow.createCell((short)2).setCellValue("PREMIUMS AND SUMS ASSURED");*/
		cell = RootRow.createCell((short) 2);
		cell.setCellValue("PREMIUMS AND SUMS ASSURED");
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints(Short.parseShort("10"));
		font.setFontName("Arial");
		style.setFont(font);
		cell.setCellStyle(style);	
		basicRang = new CellRangeAddress(4,4,2,2);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);

	
		
		/*		
		RootRow = studentsSheet.createRow(6);
		RootRow.createCell((short)1).setCellValue("PLAN CODE:");*/
	
			
		
		/*RootRow.createCell((short)2).setCellValue(Prod_code);
		basicRang = new CellRangeAddress(6,6,2,2);
		RegionUtil.setBorderBottom(CellStyle.BORDER_DOTTED,basicRang,studentsSheet,workbook);*/
		
		/*RootRow.createCell((short)3).setCellValue("PRODUCT DESCRIPTION:");*/
		
		int rowIndex = 9;
		int rootrowIndex = rowIndex;
		
		short cellIndex = 3;
		
		RootRow = studentsSheet.createRow(rowIndex++);

		int BeforerowIndex;
		int AfterrootrowIndex;
		
		
		//RootRow.createCell(cellIndex++).setCellValue(" R                     I                  D                   E                    R                   S  ");
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue(" R                     I                  D                   E                    R                   S  ");
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints(Short.parseShort("10"));
		font.setFontName("Times New Roman");
		style.setFont(font);
		cell.setCellStyle(style);	
		
		/*RootRow.createCell(cellIndex++).setCellValue("I");
		RootRow.createCell(cellIndex++).setCellValue("D");
		RootRow.createCell(cellIndex++).setCellValue("E");
		RootRow.createCell(cellIndex++).setCellValue("R");
		RootRow.createCell(cellIndex++).setCellValue("S");*/
		
		/*basicRang = new CellRangeAddress(9,9,3,10);//0,0,0,0
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		*/
		
		
		
		
		
		
		
		
		
	/*	basicRang = new CellRangeAddress(9,9,11,11);//0,0,0,0
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		*/
		basicRang = new CellRangeAddress(9,9,0,0);//0,0,0,0
		//RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		basicRang = new CellRangeAddress(9,9,1,1);//0,0,0,0
		//RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		
		basicRang = new CellRangeAddress(9,9,2,2);//0,0,0,0
		//RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		
		
		
		
		int Row_Number = rowIndex++;
		RootRow = studentsSheet.createRow(Row_Number);
		cellIndex=0;
		
		//RootRow.createCell(cellIndex++).setCellValue("Movement  Type");
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Movement  Type");
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints(Short.parseShort("10"));
		font.setFontName("Times New Roman");
		style.setFont(font);
		cell.setCellStyle(style);	
		basicRang = new CellRangeAddress(Row_Number,Row_Number,0,0);
		//RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		//RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		
		//RootRow.createCell(cellIndex++).setCellValue("Basic Annual Premiums");
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Basic Annual Premiums(including Policy Fees)");
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints(Short.parseShort("10"));
		font.setFontName("Times New Roman");
		style.setFont(font);
		cell.setCellStyle(style);	
		basicRang = new CellRangeAddress(Row_Number,Row_Number,1,1);//10,10,3,4
		//RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		//RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		
		//RootRow.createCell(cellIndex++).setCellValue("Basic Sums");
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Basic Sums Assured (excluding Riders)");
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints(Short.parseShort("10"));
		font.setFontName("Times New Roman");
		style.setFont(font);
		cell.setCellStyle(style);	
		basicRang = new CellRangeAddress(Row_Number,Row_Number,2,2);//10,10,3,4
		//RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		//RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		
		//CellRangeAddress basicRang = null;
		
		
		String DetailQuery_Rider =" " ;
		//String Prod_code1 ="203";
		int rowcount=0 ;
		//int MergeCell_X=0;
		///int MergeCell_Y=0;
		String cover_code=null;
		try {
			//con = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(CountQuery,con,new Object[]{ Prod_code});
			rs1 =  new CRUDHandler().executeSelectStatement(CoverQuery,con,new Object[]{ Prod_code});
			int Cell_RANGE_X=0;
			int Cell_RANGE_Y=0;
			int Cell_NUMBER=0;
			while(rs.next())
			{
				rowcount = rs.getInt("count");
			
			}
			System.out.println("RowCount   :   "+rowcount);
			while(rs1.next())
			{
				Cell_NUMBER=cellIndex++;//10th row ,3 cell 
				Cell_RANGE_X=Cell_NUMBER;//3
				Cell_RANGE_Y=Cell_RANGE_X + 1;//3+1=4
				//MergeCell_X=cellIndex;
				//RootRow.createCell(Cell_NUMBER).setCellValue(rs1.getString("POAC_COVER_CODE"));
				
				cell = RootRow.createCell(Cell_NUMBER);
				cell.setCellValue(rs1.getString("POAC_COVER_CODE"));
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				font.setFontHeightInPoints(Short.parseShort("10"));
				font.setFontName("Times New Roman");
				style.setFont(font);
				style.setAlignment(CellStyle.ALIGN_CENTER);
				cell.setCellStyle(style);
				basicRang = new CellRangeAddress(9,9,Cell_RANGE_X,Cell_RANGE_Y);
				RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				//RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
	
				basicRang = new CellRangeAddress(Row_Number,Row_Number,Cell_RANGE_X,Cell_RANGE_Y);//10,10,3,4
				RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				studentsSheet.addMergedRegion(new CellRangeAddress(Row_Number,Row_Number,Cell_RANGE_X,Cell_RANGE_Y));	
				cellIndex++;
				
			}
			System.out.println("cellIndex   :  "+cellIndex);
			
			Cell_NUMBER=cellIndex; 
			Cell_RANGE_X=Cell_NUMBER;
			
			
			
			basicRang = new CellRangeAddress(9,9,Cell_RANGE_X,Cell_RANGE_X);
			RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
			RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
			RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
			RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
			
			//RootRow.createCell(cellIndex++).setCellValue("Total Annual Premiums(BASIC plus RIDERS)");
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Total Annual Premiums(BASIC plus RIDERS)");
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("10"));
			font.setFontName("Times New Roman");
			style.setFont(font);
			cell.setCellStyle(style);
			
			
			basicRang = new CellRangeAddress(Row_Number,Row_Number,Cell_RANGE_X,Cell_RANGE_X);//10,10,3,4
			//RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
			//RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
			RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
			RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
			
			
			
			
			
			
			Row_Number = rowIndex++;//11
			RootRow = studentsSheet.createRow(Row_Number);
			
			basicRang = new CellRangeAddress(Row_Number,Row_Number,0,0);//10,10,3,4
			//RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
			//RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
			RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
			RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);

			basicRang = new CellRangeAddress(Row_Number,Row_Number,1,1);//10,10,3,4
			//RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
			//RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
			RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
			RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
			
			basicRang = new CellRangeAddress(Row_Number,Row_Number,3,3);//10,10,3,4
			//RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
			//RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
			RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
			RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
			
			
			
			
			cellIndex = 3;
			rs1 =  new CRUDHandler().executeSelectStatement(CoverQuery,con,new Object[]{ Prod_code});
			while(rs1.next())
			{

				Cell_NUMBER=cellIndex++; 
				Cell_RANGE_X=Cell_NUMBER;//3
				Cell_RANGE_Y=Cell_RANGE_X;
				System.out.println("Row_Number     : "+Row_Number);
				System.out.println("Cell_RANGE_X   : "+Cell_RANGE_X);
				//RootRow.createCell(Cell_NUMBER).setCellValue("Annual Premiums");
				cell = RootRow.createCell(Cell_NUMBER);
				cell.setCellValue("Annual Premiums");
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				font.setFontHeightInPoints(Short.parseShort("10"));
				font.setFontName("Times New Roman");
				style.setFont(font);
				cell.setCellStyle(style);	
				
				basicRang = new CellRangeAddress(Row_Number,Row_Number,Cell_RANGE_X,Cell_RANGE_X);//10,10,3,4
				RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				
				Cell_NUMBER=cellIndex++; 
				Cell_RANGE_X=Cell_NUMBER;//3
				Cell_RANGE_Y=Cell_RANGE_X;
				//RootRow.createCell(Cell_NUMBER).setCellValue("Sums Assured");
				cell = RootRow.createCell(Cell_NUMBER);
				cell.setCellValue("Sums Assured");
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				font.setFontHeightInPoints(Short.parseShort("10"));
				font.setFontName("Times New Roman");
				style.setFont(font);
				cell.setCellStyle(style);	
				
				basicRang = new CellRangeAddress(Row_Number,Row_Number,Cell_RANGE_X,Cell_RANGE_X);//10,10,3,4
				RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
			}
			
			Cell_NUMBER=cellIndex; 
			Cell_RANGE_X=Cell_NUMBER;
			basicRang = new CellRangeAddress(Row_Number,Row_Number,Cell_RANGE_X,Cell_RANGE_X);//10,10,3,4
			RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
			//RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
			RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
			RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
			
			
			
			
			String  Rider_AP="PW_IL_RIDER_AP";
			String  Rider_SA="PW_IL_RIDER_SA";
			
			for(int i=1;i<=rowcount;i++)
			{
				DetailQuery_Rider = DetailQuery_Rider+ Rider_AP+i+" , "+Rider_SA+i+",";
			}
			DetailQuery="select PW_IL_MOVEMENT_TYPE,PW_IL_ANNUAL_PREM,PW_IL_SUM_ASSURED, "+ DetailQuery_Rider+" PW_IL_TOT_ANNUAL_PREM,PW_SYS_ID,PW_IL_PROD_CODE from PW_IL_POLICY_MOVEMENT";
			System.out.println("DetailQuery   : "+DetailQuery);
			rs2 =  new CRUDHandler().executeSelectStatement(DetailQuery,con);
			
			Row_Number = rowIndex++;//12
			cellIndex =0;
			System.out.println("Row_Number 1 :  "+Row_Number);
			while(rs2.next()){
				
			int a=Row_Number;
			
				RootRow = studentsSheet.createRow(a);
				
				Row_Number++;
				cellIndex =0;
				
				Cell_NUMBER=cellIndex; 
				Cell_RANGE_X=Cell_NUMBER;//3
				
				System.out.println("rowIndex 1 :  "+rowIndex +"Row_Number   : "+Row_Number +"cellIndex  : "+cellIndex);
				//RootRow.createCell(cellIndex++).setCellValue(rs2.getString("PW_IL_MOVEMENT_TYPE"));
				cell = RootRow.createCell(cellIndex++);
				cell.setCellValue(rs2.getString("PW_IL_MOVEMENT_TYPE"));
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				font.setFontHeightInPoints(Short.parseShort("10"));
				font.setFontName("Times New Roman");
				style.setFont(font);
				style.setAlignment(CellStyle.ALIGN_LEFT);
				cell.setCellStyle(style);	
				
				basicRang = new CellRangeAddress(a,a,Cell_RANGE_X,Cell_RANGE_X);//10,10,3,4
				RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				
				Cell_NUMBER=cellIndex; 
				Cell_RANGE_X=Cell_NUMBER;
				
				//RootRow.createCell(cellIndex++).setCellValue(rs2.getDouble("PW_IL_ANNUAL_PREM"));
				cell = RootRow.createCell(cellIndex++);
				if(rs2.getDouble("PW_IL_ANNUAL_PREM")!=0)
				{
					cell.setCellValue(rs2.getDouble("PW_IL_ANNUAL_PREM"));
				}
				else{
					cell.setCellValue("0.00");
					//style.setAlignment(CellStyle.ALIGN_RIGHT);
				}
				
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				font.setFontHeightInPoints(Short.parseShort("10"));
				font.setFontName("Times New Roman");
				style.setFont(font);
				style.setDataFormat(hssfDataFormat.getFormat("#,##0.00"));
				style.setAlignment(CellStyle.ALIGN_RIGHT);
				cell.setCellStyle(style);	
				
				basicRang = new CellRangeAddress(a,a,Cell_RANGE_X,Cell_RANGE_X);//10,10,3,4
				RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				
				Cell_NUMBER=cellIndex; 
				Cell_RANGE_X=Cell_NUMBER;
				//RootRow.createCell(cellIndex++).setCellValue(rs2.getDouble("PW_IL_SUM_ASSURED"));
				cell = RootRow.createCell(cellIndex++);
				
				//String res = new BigDecimal(rs2.getDouble("PW_IL_SUM_ASSURED")).toPlainString();
				
				
				
				if(rs2.getDouble("PW_IL_SUM_ASSURED")!=0)
				{
					cell.setCellValue(rs2.getDouble("PW_IL_SUM_ASSURED"));
				}
				else{
					cell.setCellValue("0.00");
					//style.setAlignment(CellStyle.ALIGN_RIGHT);
				}
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				font.setFontHeightInPoints(Short.parseShort("10"));
				font.setFontName("Times New Roman");
				style.setFont(font);
				style.setDataFormat(hssfDataFormat.getFormat("#,##0.00"));
				cell.setCellStyle(style);	
				
				basicRang = new CellRangeAddress(a,a,Cell_RANGE_X,Cell_RANGE_X);//10,10,3,4
				RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				
				for(int i=1;i<=rowcount;i++)
				{
					
					Cell_NUMBER=cellIndex; 
					Cell_RANGE_X=Cell_NUMBER;
					
					//RootRow.createCell(cellIndex++).setCellValue(rs2.getDouble(Rider_AP+i));
					cell = RootRow.createCell(cellIndex++);
					if(rs2.getDouble(Rider_AP+i)!=0)
					{
						cell.setCellValue(rs2.getDouble(Rider_AP+i));
					}
					else{
						cell.setCellValue("0.00");
					//	style.setAlignment(CellStyle.ALIGN_RIGHT);
					}
					
					font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
					font.setFontHeightInPoints(Short.parseShort("10"));
					font.setFontName("Times New Roman");
					style.setFont(font);
					style.setDataFormat(hssfDataFormat.getFormat("#,##0.00"));
					cell.setCellStyle(style);
					
					basicRang = new CellRangeAddress(a,a,Cell_RANGE_X,Cell_RANGE_X);//10,10,3,4
					RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
					RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
					RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
					RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
					
					Cell_NUMBER=cellIndex; 
					Cell_RANGE_X=Cell_NUMBER;
					//RootRow.createCell(cellIndex++).setCellValue(rs2.getDouble(Rider_SA+i));
					cell = RootRow.createCell(cellIndex++);
					if(rs2.getDouble(Rider_SA+i)!=0)
					{
						cell.setCellValue(rs2.getDouble(Rider_SA+i));
					}
					else{
						cell.setCellValue("0.00");
						//style.setAlignment(CellStyle.ALIGN_RIGHT);
					}
					
					font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
					font.setFontHeightInPoints(Short.parseShort("10"));
					font.setFontName("Times New Roman");
					style.setFont(font);
					style.setDataFormat(hssfDataFormat.getFormat("#,##0.00"));
					cell.setCellStyle(style);
					
					
					basicRang = new CellRangeAddress(a,a,Cell_RANGE_X,Cell_RANGE_X);//10,10,3,4
					RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
					RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
					RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
					RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				}
				
				Cell_NUMBER=cellIndex; 
				Cell_RANGE_X=Cell_NUMBER;
				
				//RootRow.createCell(cellIndex++).setCellValue(rs2.getDouble("PW_IL_TOT_ANNUAL_PREM"));
				cell = RootRow.createCell(cellIndex++);
				if(rs2.getDouble("PW_IL_TOT_ANNUAL_PREM")!=0)
				{
					cell.setCellValue(rs2.getDouble("PW_IL_TOT_ANNUAL_PREM"));
				}
				else{
					cell.setCellValue("0.00");
					//style.setAlignment(CellStyle.ALIGN_RIGHT);
				}
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				font.setFontHeightInPoints(Short.parseShort("10"));
				font.setFontName("Times New Roman");
				style.setFont(font);
				style.setDataFormat(hssfDataFormat.getFormat("#,##0.00"));
				cell.setCellStyle(style);	
				
				basicRang = new CellRangeAddress(a,a,Cell_RANGE_X,Cell_RANGE_X);//10,10,3,4
				RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				//rowIndex++;
			}
			rs4 =  new CRUDHandler().executeSelectStatement(GetProd_code,con,new Object[]{ Prod_code});
			if(rs4.next())
			{
				String prod_desc=rs4.getString("PROD_DESC");
				System.out.println("prodcut description"+prod_desc);
			
			
			RootRow = studentsSheet.createRow(6);
			//RootRow.createCell((short)1).setCellValue("PLAN CODE:");
			
			cell = RootRow.createCell((short) 1);
			cell.setCellValue("PLAN CODE:");
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("10"));
			font.setFontName("Times New Roman");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			
			//RootRow.createCell((short)2).setCellValue(Prod_code);
			cell = RootRow.createCell((short) 2);
			cell.setCellValue(Prod_code);
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("10"));
			font.setFontName("Times New Roman");
			style.setFont(font);
			style.setAlignment(CellStyle.ALIGN_LEFT);
			cell.setCellStyle(style);	
			basicRang = new CellRangeAddress(6,6,2,2);
			RegionUtil.setBorderBottom(CellStyle.BORDER_DOTTED,basicRang,studentsSheet,workbook);
			
			//RootRow.createCell((short)3).setCellValue("PRODUCT DESCRIPTION:");
			
			cell = RootRow.createCell((short) 3);
			cell.setCellValue("PRODUCT DESCRIPTION:");
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("10"));
			font.setFontName("Times New Roman");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			
			//RootRow.createCell((short)4).setCellValue(prod_desc);
			
			cell = RootRow.createCell((short)4);
			cell.setCellValue(prod_desc);
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("10"));
			font.setFontName("Times New Roman");
			style.setFont(font);
			cell.setCellStyle(style);	
			basicRang = new CellRangeAddress(6,6,4,4);
			RegionUtil.setBorderBottom(CellStyle.BORDER_DOTTED,basicRang,studentsSheet,workbook);
			}
			System.out.println("cellindex"+cellIndex);
			
			int Cell_Count_Final = rowcount*2 ;
			Cell_Count_Final=Cell_Count_Final+3;
			int Cell_Count_Final_Align = Cell_Count_Final/2;
			studentsSheet.addMergedRegion(new CellRangeAddress(9,9,3,Cell_Count_Final));
			basicRang = new CellRangeAddress(9,9,4,Cell_Count_Final);//0,0,0,0
			//RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
			RegionUtil.setBorderTop(CellStyle.ALIGN_CENTER,basicRang,studentsSheet,workbook);
			//RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
			//RegionUtil.setBorderLeft(CellStyle.ALIGN_CENTER,basicRang,studentsSheet,workbook);	
			basicRang = new CellRangeAddress(9,9,Cell_Count_Final_Align,Cell_Count_Final);//0,0,0,0
			//RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
			RegionUtil.setBorderTop(CellStyle.ALIGN_CENTER,basicRang,studentsSheet,workbook);
			for(int a = 0 ;a<cellIndex;a++){
				studentsSheet.autoSizeColumn(a);
			}
			
			
			}  
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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
	//end 
	/*modified by gopi for ssp call id ZBILQC-1731319 on14/07/17*/
	/*added by gopi for No of policies report in policy movement report */

	public String writeNO_of_Policy_ReportExcel(ArrayList<String> list1,Connection con,String fileName , String ReportName ,List param ) throws ParseException, Exception{
		String CountQuery="select count(POAC_COVER_CODE) count from (SELECT DISTINCT POAC_COVER_CODE FROM PT_IL_POL_ADDL_COVER, PM_IL_PROD_APPL_COVER WHERE POAC_COVER_CODE = PAC_COVER_CODE "
				+ "AND PAC_PROD_CODE = ? ORDER BY POAC_COVER_CODE)";
		
		String CoverQuery="SELECT DISTINCT POAC_COVER_CODE FROM PT_IL_POL_ADDL_COVER, PM_IL_PROD_APPL_COVER WHERE POAC_COVER_CODE = PAC_COVER_CODE "
				+ "AND PAC_PROD_CODE =? ORDER BY POAC_COVER_CODE";
		
		String GetProd_code="SELECT PROD_CODE,PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE= ? ";
		
		
		String DetailQuery= null;
		String excelGenPath = "";
	//	Connection con = null;
		ResultSet rs,rs1,rs2,rs4= null;
		
	/*	String P_SEQ_VAL=list1.get(0);*/
		
		String AgentWiseFileName =fileName;
		System.out.println("agentwise_business ==>>>>"+AgentWiseFileName);
		String directory=createDir("ExcelWritingFolder");
		System.out.println("directory ==>>>"+directory);
		excelGenPath=directory+""+AgentWiseFileName+".xls";
		System.out.println("agentwise_business ==>>>>"+AgentWiseFileName+"::directory ==>>>"+directory+"::excelGenPath==>>>>"+excelGenPath);
		Workbook workbook =  (Workbook) new HSSFWorkbook();
		
		Sheet studentsSheet = workbook.createSheet("PolicyMovementSheet");
		CellStyle style = null;
		style = workbook.createCellStyle();
		CellRangeAddress basicRang = null;
		Cell cell=null;

		Row RootRow = null;
		
		Font font = workbook.createFont();
		font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
		font.setFontHeightInPoints(Short.parseShort("12"));
		font.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
		
		
		DataFormat hssfDataFormat = workbook.createDataFormat(); 
		
		CellStyle charcellStyle = workbook.createCellStyle();
		

		/*
		CellStyle numericcellStyle = wb.createCellStyle();
		numericcellStyle.setAlignment(CellStyle.ALIGN_RIGHT);
		font = wb.createFont();
		font.setFontName(datacolumnStyle[0]);
		font.setFontHeightInPoints(Short.parseShort(datacolumnStyle[1]));
		numericcellStyle.setFont(font);
		DataFormat dfor = wb.createDataFormat();
		numericcellStyle.setDataFormat(dfor.getFormat("#,#0.000"));
		*/
		String Prod_code =null;
		String Peroid_from =null;
		String Peroid_to =null;
		
		Prod_code  = param.get(0).toString().trim();
		Peroid_from = param.get(1).toString().trim();
		Peroid_to = param.get(2).toString().trim();
		
		
		int rowIndex1 = 0;
		short cellIndex1 =1;
		
		RootRow = studentsSheet.createRow(rowIndex1);
		//RootRow.createCell(cellIndex1).setCellValue("ZB LIFE ASSURANCE LIMITED");
		cell = RootRow.createCell(cellIndex1);
		cell.setCellValue("ZB LIFE ASSURANCE LIMITED");
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints(Short.parseShort("10"));
		font.setFontName("Times New Roman");
		style.setFont(font);
		cell.setCellStyle(style);	
		basicRang = new CellRangeAddress(0,0,1,1);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		//RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		//RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		//RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
				
		RootRow = studentsSheet.createRow(2);
		//RootRow.createCell((short) 1).setCellValue("POLICY MOVEMENTS SUMMARY REPORT FOR PERIOD");
		cell = RootRow.createCell((short) 0);
		cell.setCellValue("POLICY MOVEMENTS SUMMARY REPORT FOR PERIOD");
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints(Short.parseShort("10"));
		font.setFontName("Times New Roman");
		style.setFont(font);
		cell.setCellStyle(style);	
		studentsSheet.addMergedRegion(new CellRangeAddress(2,2,0,1));
		
		//RootRow.createCell((short) 3).setCellValue(Peroid_from);
		cell = RootRow.createCell((short)2);
		cell.setCellValue(Peroid_from);
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints(Short.parseShort("10"));
		font.setFontName("Times New Roman");
		style.setFont(font);
		cell.setCellStyle(style);
		basicRang = new CellRangeAddress(2,2,2,2);
		RegionUtil.setBorderBottom(CellStyle.BORDER_DOTTED,basicRang,studentsSheet,workbook);
		
		//RootRow.createCell((short) 4).setCellValue("TO");
		cell = RootRow.createCell((short) 3);
		cell.setCellValue("TO");
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints(Short.parseShort("10"));
		font.setFontName("Times New Roman");
		style.setFont(font);
		cell.setCellStyle(style);	
		
		//RootRow.createCell((short)5).setCellValue(Peroid_to);
		cell = RootRow.createCell((short) 4);
		cell.setCellValue(Peroid_to);
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints(Short.parseShort("10"));
		font.setFontName("Times New Roman");
		style.setFont(font);
		cell.setCellStyle(style);	
		
		basicRang = new CellRangeAddress(2,2,4,4);
		RegionUtil.setBorderBottom(CellStyle.BORDER_DOTTED,basicRang,studentsSheet,workbook);
		
		RootRow = studentsSheet.createRow(4);
		//RootRow.createCell((short)2).setCellValue("NUMBER OF POLICIES AND RIDERS");
		cell = RootRow.createCell((short) 1);
		cell.setCellValue("NUMBER OF POLICIES AND RIDERS");
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints(Short.parseShort("10"));
		font.setFontName("Times New Roman");
		style.setFont(font);
		cell.setCellStyle(style);
		basicRang = new CellRangeAddress(4,4,1,1);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		//studentsSheet.addMergedRegion(new CellRangeAddress(4,4,2,2));
		
		/*RootRow = studentsSheet.createRow(6);
		RootRow.createCell((short)1).setCellValue("PLAN CODE:");
		RootRow.createCell((short)2).setCellValue(Prod_code);
		basicRang = new CellRangeAddress(6,6,2,2);
		RegionUtil.setBorderBottom(CellStyle.BORDER_DOTTED,basicRang,studentsSheet,workbook);
		RootRow.createCell((short)3).setCellValue("PRODUCT DESCRIPTION:");*/
		
		int rowIndex = 9;
		int rootrowIndex = rowIndex;
		
		short cellIndex = 2;
		
		RootRow = studentsSheet.createRow(rowIndex++);

		int BeforerowIndex;
		int AfterrootrowIndex;
		
		
		rs1 =  new CRUDHandler().executeSelectStatement(CoverQuery,con,new Object[]{Prod_code});
		int Cell_NUMBERQ=cellIndex++;//10th row ,3 cell 
		int Cell_RANGE_XQ=Cell_NUMBERQ;//3
		int Cell_RANGE_YQ=Cell_RANGE_XQ;//3+1=4
		int row_count=1;
		while(rs1.next())
		{
			//RootRow.createCell(Cell_NUMBERQ).setCellValue("Number of Riders");
			cell = RootRow.createCell(Cell_NUMBERQ);
			cell.setCellValue("Number of Riders");
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("10"));
			font.setFontName("Times New Roman");
			style.setFont(font);
			style.setAlignment(CellStyle.ALIGN_CENTER);
			cell.setCellStyle(style);	
			
			basicRang = new CellRangeAddress(9,9,Cell_RANGE_XQ,Cell_RANGE_YQ);
			//RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
			RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
			RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
			RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
			studentsSheet.addMergedRegion(new CellRangeAddress(9,9,Cell_RANGE_XQ,Cell_RANGE_YQ));
			row_count++;
		}
		
		System.out.println("row_count   : "+row_count);
		
		basicRang = new CellRangeAddress(9,9,1,1);//0,0,0,0
		//RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		//RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		//RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		
		
		
		basicRang = new CellRangeAddress(9,9,0,2);//0,0,0,0
		//RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		
		basicRang = new CellRangeAddress(9,9,3,row_count);//0,0,0,0
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
	
		
	
		
		
		int Row_Number = rowIndex++;//10th row
		RootRow = studentsSheet.createRow(Row_Number);
		cellIndex=0;
		
		//RootRow.createCell(cellIndex++).setCellValue("Movement  Type");
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Movement  Type");
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints(Short.parseShort("10"));
		font.setFontName("Times New Roman");
		charcellStyle.setFont(font);
		charcellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		cell.setCellStyle(style);
		cell.setCellStyle(charcellStyle);
		basicRang = new CellRangeAddress(Row_Number,Row_Number,0,0);//10,10,3,4
		//RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		//RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		//RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		//RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		
		//RootRow.createCell(cellIndex++).setCellValue("Number of Policies");
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Number of Policies");
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints(Short.parseShort("10"));
		font.setFontName("Times New Roman");
		charcellStyle.setFont(font);
		charcellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		cell.setCellStyle(style);
		cell.setCellStyle(charcellStyle);
		basicRang = new CellRangeAddress(Row_Number,Row_Number,1,1);//10,10,3,4
		//RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		//RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
		/*
		RootRow.createCell(cellIndex++).setCellValue("Basic Sums");
		basicRang = new CellRangeAddress(Row_Number,Row_Number,2,2);//10,10,3,4
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);*/
		
		//CellRangeAddress basicRang = null;
		
		
		String DetailQuery_Rider =" " ;
		
		int rowcount=0 ;
		//int MergeCell_X=0;
		///int MergeCell_Y=0;
		String cover_code=null;
		try {
			//con = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(CountQuery,con,new Object[]{ Prod_code});
			rs1 =  new CRUDHandler().executeSelectStatement(CoverQuery,con,new Object[]{ Prod_code});
			int Cell_RANGE_X=0;
			int Cell_RANGE_Y=0;
			int Cell_NUMBER=0;
			while(rs.next())
			{
				rowcount = rs.getInt("count");
			
			}
			System.out.println("RowCount   :   "+rowcount);
			while(rs1.next())
			{
				Cell_NUMBER=cellIndex++;
				Cell_RANGE_X=Cell_NUMBER;
				Cell_RANGE_Y=Cell_RANGE_X+1;
				
				//RootRow.createCell(Cell_NUMBER).setCellValue(rs1.getString("POAC_COVER_CODE"));
				cell = RootRow.createCell(Cell_NUMBER);
				cell.setCellValue(rs1.getString("POAC_COVER_CODE"));
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				font.setFontHeightInPoints(Short.parseShort("10"));
				font.setFontName("Times New Roman");
				style.setFont(font);
				cell.setCellStyle(style);
				basicRang = new CellRangeAddress(Row_Number,Row_Number,Cell_RANGE_X,Cell_RANGE_X);//10,10,3,4
				RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				studentsSheet.addMergedRegion(new CellRangeAddress(Row_Number,Row_Number,Cell_RANGE_X,Cell_RANGE_X));
				
							
				//cellIndex++;
				
			}
			
			
			
			
			String  Rider_AP="PW_IL_COUNT_RIDER";
			
			for(int i=1;i<=rowcount;i++)
			{
				DetailQuery_Rider = DetailQuery_Rider+ Rider_AP+i+",";
			}
			String finalquery=DetailQuery_Rider.substring(0,DetailQuery_Rider.length()-1);
			
			DetailQuery="SELECT PW_IL_MOVEMENT_TYPE , PW_IL_COUNT_POL_NO,"+ finalquery+" FROM PW_IL_NO_POLICY ";
			rs2 =  new CRUDHandler().executeSelectStatement(DetailQuery,con);
			
			Row_Number = rowIndex++;
			
			while(rs2.next()){
				int a=Row_Number;
				RootRow = studentsSheet.createRow(a);
				
				Row_Number++;
				cellIndex =0;
				

				Cell_NUMBER=cellIndex; 
				Cell_RANGE_X=Cell_NUMBER;//3 
				
			//	RootRow.createCell(cellIndex++).setCellValue(rs2.getString("PW_IL_MOVEMENT_TYPE"));
				cell = RootRow.createCell(cellIndex++);
				cell.setCellValue(rs2.getString("PW_IL_MOVEMENT_TYPE"));
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				font.setFontHeightInPoints(Short.parseShort("10"));
				font.setFontName("Times New Roman");
				style.setFont(font);
				style.setAlignment(CellStyle.ALIGN_LEFT);
				cell.setCellStyle(style);	
				
				basicRang = new CellRangeAddress(a,a,Cell_RANGE_X,Cell_RANGE_X);//10,10,3,4
				RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				
				Cell_NUMBER=cellIndex; 
				Cell_RANGE_X=Cell_NUMBER;
			//	RootRow.createCell(cellIndex++).setCellValue(rs2.getDouble("PW_IL_COUNT_POL_NO"));
				cell = RootRow.createCell(cellIndex++);
				if(rs2.getDouble("PW_IL_COUNT_POL_NO")!=0)
				{
					cell.setCellValue(rs2.getDouble("PW_IL_COUNT_POL_NO"));
				}
				else{
					cell.setCellValue("0.00");
					
				}
				//cell.setCellValue(rs2.getDouble("PW_IL_COUNT_POL_NO"));
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				font.setFontHeightInPoints(Short.parseShort("10"));
				font.setFontName("Times New Roman");
				style.setFont(font);
				style.setDataFormat(hssfDataFormat.getFormat("#,##0.00"));
				style.setAlignment(CellStyle.ALIGN_RIGHT);
				cell.setCellStyle(style);	
				
				basicRang = new CellRangeAddress(a,a,Cell_RANGE_X,Cell_RANGE_X);//10,10,3,4
				RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				
				for(int i=1;i<=rowcount;i++)
				{
					Cell_NUMBER=cellIndex; 
					Cell_RANGE_X=Cell_NUMBER;
				//	RootRow.createCell(cellIndex++).setCellValue(rs2.getDouble(Rider_AP+i));
					cell = RootRow.createCell(cellIndex++);
					if(rs2.getDouble(Rider_AP+i)!=0)
					{
						cell.setCellValue(rs2.getDouble(Rider_AP+i));
					}
					else{
						cell.setCellValue("0.00");
					}
					
					font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
					font.setFontHeightInPoints(Short.parseShort("10"));
					font.setFontName("Times New Roman");
					style.setFont(font);
					style.setDataFormat(hssfDataFormat.getFormat("#,##0.00"));
					style.setAlignment(CellStyle.ALIGN_RIGHT);
					cell.setCellStyle(style);
					
					basicRang = new CellRangeAddress(a,a,Cell_RANGE_X,Cell_RANGE_X);//10,10,3,4
					RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
					RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
					RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
					RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				}
				
			
				
			}
			
			
			
			
			rs4 =  new CRUDHandler().executeSelectStatement(GetProd_code,con,new Object[]{ Prod_code});
			if(rs4.next())
			{
				String prod_desc=rs4.getString("PROD_DESC");
				System.out.println("prodcut description"+prod_desc);
			
			
			RootRow = studentsSheet.createRow(6);
			//RootRow.createCell((short)1).setCellValue("PLAN CODE:");
			cell = RootRow.createCell((short) 0);
			cell.setCellValue("PLAN CODE:");
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("10"));
			font.setFontName("Times New Roman");
			style.setFont(font);
			cell.setCellStyle(style);
			//RootRow.createCell((short)2).setCellValue(Prod_code);
			cell = RootRow.createCell((short) 1);
			cell.setCellValue(Prod_code);
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("10"));
			font.setFontName("Times New Roman");
			style.setFont(font);
			//style.setAlignment(CellStyle.ALIGN_LEFT);
			cell.setCellStyle(style);	
			basicRang = new CellRangeAddress(6,6,1,1);
			RegionUtil.setBorderBottom(CellStyle.BORDER_DOTTED,basicRang,studentsSheet,workbook);
			//RootRow.createCell((short)3).setCellValue("PRODUCT DESCRIPTION:");
			cell = RootRow.createCell((short)2);
			cell.setCellValue("PRODUCT DESCRIPTION:");
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("10"));
			font.setFontName("Times New Roman");
			style.setFont(font);
			cell.setCellStyle(style);	
			//RootRow.createCell((short)4).setCellValue(prod_desc);
			cell = RootRow.createCell((short)3);
			cell.setCellValue(prod_desc);
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("10"));
			font.setFontName("Times New Roman");
			style.setFont(font);
			//style.setAlignment(CellStyle.ALIGN_LEFT);
			cell.setCellStyle(style);	
			basicRang = new CellRangeAddress(6,6,3,3);
			RegionUtil.setBorderBottom(CellStyle.BORDER_DOTTED,basicRang,studentsSheet,workbook);
			}
			
			System.out.println("cellindex"+cellIndex);
			for(int a = 0 ;a<cellIndex;a++){
				studentsSheet.autoSizeColumn(a);
			}
			
			
			}  
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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
	/*end*/
	/*added by gopi for unit movement report on 10/05/17*/
	public String writeUnitMovementReportExcel(ArrayList<String> list1,Connection con,String fileName , String ReportName ,List param) throws ParseException, Exception{

		


		String excelGenPath = "";
	//	Connection con = null;
		ResultSet rs,rs1,rs2,rs3,rs4,rs5,rs6 = null;
		
	/*	String P_SEQ_VAL=list1.get(0);*/
		
		String AgentWiseFileName =fileName;
		System.out.println("agentwise_business ==>>>>"+AgentWiseFileName);
		String directory=createDir("ExcelWritingFolder");
		System.out.println("directory ==>>>"+directory);
		excelGenPath=directory+""+AgentWiseFileName+".xls";
		System.out.println("agentwise_business ==>>>>"+AgentWiseFileName+"::directory ==>>>"+directory+"::excelGenPath==>>>>"+excelGenPath);
		Workbook workbook =  (Workbook) new HSSFWorkbook();
		Cell cell = null;
		/*Sheet studentsSheet = workbook.createSheet("XPMAL FMR");*/
		CellStyle style = null;
		style = workbook.createCellStyle();

		Font font = workbook.createFont();
		font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
		font.setFontHeightInPoints(Short.parseShort("12"));
		font.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
		
		
		DataFormat hssfDataFormat = workbook.createDataFormat(); 
		
		
		HSSFRow RootRow = null;
		CellRangeAddress basicRang = null;
		
		String Fund_code = null;
		String Peroid_from = null;
		String Peroid_to = null;
		String Prod_desc=null;
	
		Fund_code  =param.get(0).toString().trim();
		Peroid_from = param.get(1).toString().trim();
		Peroid_to =param.get(2).toString().trim();
		Sheet studentsSheet=null;
		if(Fund_code.equalsIgnoreCase("XPMAL")){
		studentsSheet = workbook.createSheet("XPMAL FMR");
		}else{
			studentsSheet = workbook.createSheet("XRACL FMR");
		}
		
		
		int rowIndex1 = 0;
		short cellIndex1 = 2;
		
		Row beforeFirstRow = studentsSheet.createRow(rowIndex1);
		cell = beforeFirstRow.createCell(cellIndex1);
		//as per the girish sir suggestion amneded final no need cell.setCellValue("AMENDED-FINAL");
		cell.setCellValue("");
		style = workbook.createCellStyle();
		font = workbook.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints(Short.parseShort("18"));
		font.setFontName("Calibri");
		style.setFont(font);
		cell.setCellStyle(style);
	
		Row beforesevenRow = studentsSheet.createRow(6);
		cell = beforesevenRow.createCell(0);
		cell.setCellValue("Fund Code:");
		style = workbook.createCellStyle();
		font = workbook.createFont();
		font.setFontHeightInPoints(Short.parseShort("11"));
		font.setFontName("Calibri");
		style.setFont(font);
		cell.setCellStyle(style);
		
		cell = beforesevenRow.createCell(2);
		cell.setCellValue(Fund_code);
		style = workbook.createCellStyle();
		font = workbook.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints(Short.parseShort("18"));
		font.setFontName("Arial");
		style.setFont(font);
		cell.setCellStyle(style);
		
		/*Row beforenineRow = studentsSheet.createRow(8);
		cell = beforenineRow.createCell(0);
		cell.setCellValue("Fund Description:");
		cell = beforenineRow.createCell(2);
		cell.setCellValue(Prod_desc);*/
		
		
		Row beforelevenRow = studentsSheet.createRow(10);
		cell = beforelevenRow.createCell(1);
		cell.setCellValue("Units");
		
		/*Modified by Janani on 19.08.2017 for ZBILQC-1731172*/
		
		//cell = beforelevenRow.createCell(2);
		
		cell = beforelevenRow.createCell(3);
		
		/*End*/
		
		cell.setCellValue("Amount");
		
		int rowIndex=11;
		String DetailQuery= null;
		String DetailQuery1= null;
		String DetailQuery2 = null;
		String DetailQuery3 = null;
		String DetailQuery4 = null;
		String DetailQuery5 = null;
		DetailQuery="select * from PW_IL_UNIT_FWD";
		DetailQuery1="select * from PW_IL_MOVEMENT_ON";
		DetailQuery2="select * from  PW_IL_MOVEMENT_OFF";
		DetailQuery3="select * from PW_IL_UNIT_MVEMENT";
		DetailQuery4="SELECT DISTINCT UFRD_FUND_CODE,FS_DESC FROM PT_IL_UNIT_FUND_REG_DTL,PM_IL_FUND_SETUP"
				+ " WHERE UFRD_FUND_CODE =FS_CODE AND UFRD_FUND_CODE= ? ";
		
		DetailQuery5="select * from pw_il_unit_ip";
		//String DetailQuery_Rider =" " ;
		//String Prod_code1 ="203";
		//int rowcount=0 ;

		String cover_code=null;
		try{
			rs1 =  new CRUDHandler().executeSelectStatement(DetailQuery,con);
			rs2 =  new CRUDHandler().executeSelectStatement(DetailQuery1,con);
			rs3 =  new CRUDHandler().executeSelectStatement(DetailQuery2,con);
			rs4 =  new CRUDHandler().executeSelectStatement(DetailQuery3,con);
			rs5 =  new CRUDHandler().executeSelectStatement(DetailQuery4,con,new Object[]{Fund_code});
			rs6 =  new CRUDHandler().executeSelectStatement(DetailQuery5,con);

			int cellIndex=0;
			int cellIndex2=0;
			int cellIndex3=0;
			int cellIndex4=0;
			int cellIndex5=0;
			int cellIndex6=0;
			int cellIndex7=0;
			int cellIndex8=0;
			int cellIndex9=0;
			
			while(rs1.next()){
				rowIndex++;	
				Row beforetwelveRow = studentsSheet.createRow(rowIndex++);
				cellIndex=0;
				cell = beforetwelveRow.createCell(cellIndex++);
				cell.setCellValue(rs1.getString("PW_IL_MVE_FWD"));
				style = workbook.createCellStyle();
				font = workbook.createFont();
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				font.setFontHeightInPoints(Short.parseShort("11"));
				font.setFontName("Calibri");
				style.setFont(font);
				cell.setCellStyle(style);
				
				cell = beforetwelveRow.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_FWD_UNITS"));
				style = workbook.createCellStyle();
				font = workbook.createFont();
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				font.setFontHeightInPoints(Short.parseShort("11"));
				font.setFontName("Calibri");
				style.setFont(font);
				style.setDataFormat(hssfDataFormat.getFormat("#,##0.000"));
				cell.setCellStyle(style);
				
				
				/*Added by Janani on 19.08.2017 for ZBILQC-1731172*/
				
				cell = beforetwelveRow.createCell(cellIndex++);
				cell.setCellValue("");
				
				/*End*/
				
				cell = beforetwelveRow.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_FWD_AMT"));
				style = workbook.createCellStyle();
				font = workbook.createFont();
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				font.setFontHeightInPoints(Short.parseShort("11"));
				font.setFontName("Calibri");
				style.setFont(font);
				style.setDataFormat(hssfDataFormat.getFormat("#,##0.00"));
				cell.setCellStyle(style);
						
				
			}
			Row row6 = studentsSheet.createRow(rowIndex++);
			cellIndex5=0;
			///////////
			Row row7 = studentsSheet.createRow(rowIndex++);
			///////
			cell = row7.createCell(cellIndex5++);
			/////
			cell.setCellValue("2. Movements On");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("11"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);
	          
			 Row row10 = studentsSheet.createRow(rowIndex++);
				while(rs2.next()){
				    Row beforesixteenRow = studentsSheet.createRow(rowIndex++);
					cellIndex2=0;
					cell = beforesixteenRow.createCell(cellIndex2++);
					cell.setCellValue(rs2.getString("PW_IL_MOVEMENT"));
					style = workbook.createCellStyle();
					font = workbook.createFont();
					font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					cell.setCellStyle(style);
					
					
					cell = beforesixteenRow.createCell(cellIndex2++);
					cell.setCellValue(rs2.getInt("PW_IL_MVE_UNITS"));
					style = workbook.createCellStyle();
					font = workbook.createFont();
					font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					style.setDataFormat(hssfDataFormat.getFormat("#,##0.000"));
					cell.setCellStyle(style);
					//cell.setCellType(Cell.CELL_TYPE_NUMERIC);
					
					/*Added by Janani on 19.08.2017 for ZBILQC-1731172*/
					
					cell = beforesixteenRow.createCell(cellIndex2++);
					cell.setCellValue("");
					
					/*End*/
					
					cell = beforesixteenRow.createCell(cellIndex2++);
					cell.setCellValue(rs2.getInt("PW_IL_MVE_AMT"));
					style = workbook.createCellStyle();
					font = workbook.createFont();
					font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					style.setDataFormat(hssfDataFormat.getFormat("#,##0.00"));
					cell.setCellStyle(style);
				}
				
				Row row1 = studentsSheet.createRow(rowIndex++);
				Row row11 = studentsSheet.createRow(rowIndex++);
				cellIndex5=0;
				cell = row11.createCell(cellIndex5++);
				/////
				cell.setCellValue("3. Movements Off");
				style = workbook.createCellStyle();
				font = workbook.createFont();
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				font.setFontHeightInPoints(Short.parseShort("11"));
				font.setFontName("Calibri");
				style.setFont(font);
				cell.setCellStyle(style);
				
				
				Row row2 = studentsSheet.createRow(rowIndex++);
				cellIndex6=2;
				cell = row2.createCell(cellIndex6++);
				cell.setCellValue("Gross Value");

				/*Added by Janani on 19.08.2017 for ZBILQC-1731172*/
				
				style = workbook.createCellStyle();
				style.setAlignment(CellStyle.ALIGN_CENTER);
				cell.setCellStyle(style);
				
				/*End*/
				
				cell = row2.createCell(cellIndex6++);
				cell.setCellValue("Actual Paid");
				
				/*Added by Janani on 19.08.2017 for ZBILQC-1731172*/

				style = workbook.createCellStyle();
				style.setAlignment(CellStyle.ALIGN_CENTER);
				cell.setCellStyle(style);

				/*End*/
				
				
				cell = row2.createCell(cellIndex6++);
				cell.setCellValue("Diff.Due to General Fund");
				
				/*Added by Janani on 19.08.2017 for ZBILQC-1731172*/

				style = workbook.createCellStyle();
				style.setAlignment(CellStyle.ALIGN_CENTER);
				cell.setCellStyle(style);

				/*End*/
				
				
				while(rs3.next()){
					Row beforetwentysevenRow = studentsSheet.createRow(rowIndex++);
					 cellIndex3=0;
					cell = beforetwentysevenRow.createCell(cellIndex3++);
					cell.setCellValue(rs3.getString("PW_IL_MOVEMENT"));
					style = workbook.createCellStyle();
					font = workbook.createFont();
					font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					cell.setCellStyle(style);
					
					cell = beforetwentysevenRow.createCell(cellIndex3++);
					cell.setCellValue(rs3.getInt("PW_IL_MVE_UNITS"));
					style = workbook.createCellStyle();
					font = workbook.createFont();
					font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					style.setDataFormat(hssfDataFormat.getFormat("#,##0.000"));
					cell.setCellStyle(style);
					
					cell = beforetwentysevenRow.createCell(cellIndex3++);
					cell.setCellValue(rs3.getInt("PW_IL_MVE_GROSS_AMT"));
					style = workbook.createCellStyle();
					font = workbook.createFont();
					font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					style.setDataFormat(hssfDataFormat.getFormat("#,##0.00"));
					cell.setCellStyle(style);
					
					cell = beforetwentysevenRow.createCell(cellIndex3++);
					cell.setCellValue(rs3.getInt("PW_IL_MVE_ACTUAL_PAID"));
					style = workbook.createCellStyle();
					font = workbook.createFont();
					font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					style.setDataFormat(hssfDataFormat.getFormat("#,##0.00"));
					cell.setCellStyle(style);
					
					cell = beforetwentysevenRow.createCell(cellIndex3++);
					cell.setCellValue(rs3.getInt("PW_IL_DIFF_FUND"));
					style = workbook.createCellStyle();
					font = workbook.createFont();
					font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					style.setDataFormat(hssfDataFormat.getFormat("#,##0.00"));
					cell.setCellStyle(style);
				}
				
			
				Row row12 = studentsSheet.createRow(rowIndex++);
				
				while(rs4.next()){
					Row beforefiftythreeRow = studentsSheet.createRow(rowIndex++);
					cellIndex4=0;
					cell = beforefiftythreeRow.createCell(cellIndex4++);
					cell.setCellValue(rs4.getString("PW_IL_NET_MVEMENT"));
					style = workbook.createCellStyle();
					font = workbook.createFont();
					font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
					font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					cell.setCellStyle(style);
					
					
					
					
					cell = beforefiftythreeRow.createCell(cellIndex4++);
					cell.setCellValue(rs4.getInt("PW_IL_UNIT_FWD"));
					style = workbook.createCellStyle();
					font = workbook.createFont();
					font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
					font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					style.setDataFormat(hssfDataFormat.getFormat("#,##0.000"));
					cell.setCellStyle(style);
					
					
					cell = beforefiftythreeRow.createCell(cellIndex4++);
					cell.setCellValue(rs4.getInt("PW_IL_UNITS_VAL"));
					style = workbook.createCellStyle();
					style.setDataFormat(hssfDataFormat.getFormat("#,##0.00"));
					cell.setCellStyle(style);
					
					cell = beforefiftythreeRow.createCell(cellIndex4++);
					cell.setCellValue(rs4.getString("PW_IL_UNIT_DIFF"));
					cell = beforefiftythreeRow.createCell(cellIndex4++);
					cell.setCellValue(rs4.getString("PW_IL_BID_PRICE"));
					cell = beforefiftythreeRow.createCell(cellIndex4++);
					cell.setCellValue(rs4.getString("PW_IL_VAL_DIFF"));
					rowIndex++;
				}
				
				
			
				
				int rowIncrement=rowIndex++;
				
				/*Row row3 = studentsSheet.createRow(rowIncrement);
				cellIndex7=0;
				cell = row3.createCell(cellIndex7++);
				cell.setCellValue("NB: PARTIAL WITHDRAWALS INCLUDE A TRANCACTION FOR "
						+ "ASSS0127543 FOR 1301.00 AND THE CORRESPONDING UNITS"
						+ " WHICH IS MISSING FROM UNIT TRANSACTIONS FOR DECEMBER 2015");
				style = workbook.createCellStyle();
				font = workbook.createFont();
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				font.setFontHeightInPoints(Short.parseShort("11"));
				font.setFontName("Calibri");
				style.setFont(font);
				cell.setCellStyle(style);
				basicRang = new CellRangeAddress(rowIncrement,rowIncrement,0,15);//10,10,3,4
				RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
				RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
				studentsSheet.addMergedRegion(new CellRangeAddress(rowIncrement,rowIncrement,0,10));
				rowIndex++;*/
				
				Row row4 = studentsSheet.createRow(rowIndex++);
				cellIndex8=0;
				cell = row4.createCell(cellIndex8++);
				cell.setCellValue("PREPARED BY...............SIGNED..............DATE:........................");
				style = workbook.createCellStyle();
				font = workbook.createFont();
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				font.setFontHeightInPoints(Short.parseShort("11"));
				font.setFontName("Calibri");
				style.setFont(font);
				cell.setCellStyle(style);
				studentsSheet.addMergedRegion(new CellRangeAddress(rowIncrement,rowIncrement,0,3));
				rowIndex+=3;
				
				Row row5 = studentsSheet.createRow(rowIndex++);
				cellIndex9=0;
				cell = row5.createCell(cellIndex9++);
				cell.setCellValue("REVIEWED BY:............SIGNED............DATE: .....................");
				style = workbook.createCellStyle();
				font = workbook.createFont();
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				font.setFontHeightInPoints(Short.parseShort("11"));
				font.setFontName("Calibri");
				style.setFont(font);
				cell.setCellStyle(style);
				studentsSheet.addMergedRegion(new CellRangeAddress(rowIncrement,rowIncrement,0,3));
				rowIndex++;
				
				
				
				while(rs5.next()){
					
					
					Prod_desc=rs5.getString("FS_DESC");
					System.out.println("wefrete"+Prod_desc);
				
					
				}
				
				Row beforenineRow = studentsSheet.createRow(8);
				cell = beforenineRow.createCell(0);
				cell.setCellValue("Fund Description:");
				style = workbook.createCellStyle();
				font = workbook.createFont();
				font.setFontHeightInPoints(Short.parseShort("11"));
				font.setFontName("Calibri");
				style.setFont(font);
				cell.setCellStyle(style);
				
				cell = beforenineRow.createCell(2);
				cell.setCellValue(Prod_desc);
				style = workbook.createCellStyle();
				font = workbook.createFont();
				font.setFontHeightInPoints(Short.parseShort("11"));
				font.setFontName("Calibri");
				style.setFont(font);
				cell.setCellStyle(style);
				
				String date1=null;
				String date2=null;
				String date3=null;
	
				while(rs6.next()){
					
					
				date1=new SimpleDateFormat("dd/MMMM/yyyy").format(rs6.getDate("PW_IL_PERIOD_FM")).toString().toUpperCase();
				date2=new SimpleDateFormat("dd/MMMM/yyyy").format(rs6.getDate("PW_IL_PERIOD_TO")).toString().toUpperCase();
				date3=new SimpleDateFormat("MMMM/yyyy").format(rs6.getDate("PW_IL_PERIOD_FM")).toString().toUpperCase();
				
				}
				
				
				/*Modified by Janani on 19.08.2017 for ZBILQC-1731172*/
				
				
				/*String final_first_date=date1.replace("/", "");
				String final_to_date=date2.replace("/", "");
				String final_third_date=date3.replace("/", "");*/
				
				String final_first_date=date1.replace("/", " ");
				String final_to_date=date2.replace("/", " ");
				String final_third_date=date3.replace("/", " ");
				
				/*End*/
				
				Row beforesecondRow = studentsSheet.createRow(1);
				cell = beforesecondRow.createCell(0);
				cell.setCellValue("FUND MOVEMENT REPORT");
				style = workbook.createCellStyle();
				font = workbook.createFont();
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				font.setFontHeightInPoints(Short.parseShort("18"));
				font.setFontName("Calibri");
				style.setFont(font);
				cell.setCellStyle(style);
				

				
				cell = beforesecondRow.createCell(2);
				cell.setCellValue(final_third_date);
				style = workbook.createCellStyle();
				font = workbook.createFont();
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				font.setFontHeightInPoints(Short.parseShort("18"));
				font.setFontName("Calibri");
				style.setFont(font);
				cell.setCellStyle(style);
				
				
				
				
				Row beforefiveRow = studentsSheet.createRow(4);
				cell = beforefiveRow.createCell(0);
				cell.setCellValue("PERIOD");
				style = workbook.createCellStyle();
				font = workbook.createFont();
				font.setFontHeightInPoints(Short.parseShort("11"));
				font.setFontName("Calibri");
				style.setFont(font);
				cell.setCellStyle(style);
				
				
				
				
				
				
				cell = beforefiveRow.createCell(2);
				cell.setCellValue(final_first_date);
				
				style = workbook.createCellStyle();
				font = workbook.createFont();
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				font.setFontHeightInPoints(Short.parseShort("12"));
				font.setFontName("Calibri");
				style.setFont(font);
				cell.setCellStyle(style);	
				
				
				cell = beforefiveRow.createCell(3);
				cell.setCellValue("TO");
				style = workbook.createCellStyle();
				font = workbook.createFont();
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				font.setFontHeightInPoints(Short.parseShort("12"));
				font.setFontName("Calibri");
				style.setFont(font);
				cell.setCellStyle(style);	
				
				cell = beforefiveRow.createCell(4);
				cell.setCellValue(final_to_date);
				style = workbook.createCellStyle();
				font = workbook.createFont();
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				font.setFontHeightInPoints(Short.parseShort("12"));
				font.setFontName("Calibri");
				style.setFont(font);
				cell.setCellStyle(style);	
							
				
				System.out.println("cellindex"+cellIndex);
				for(int a = 0 ;a<cellIndex;a++){
					studentsSheet.autoSizeColumn(a);
				}
			
			}  
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
	//end
	/*added by gopi for ssp call id ZBLIFE-1449094 on 09/11/17*/	
	
	public String writeDue_Commission_ReportExcel(ArrayList<String> list1,Connection con,String fileName , String ReportName,List param) throws ParseException, Exception{

		
		String DetailQuery= null;
		String excelGenPath = "";
	//	Connection con = null;
		ResultSet rs,rs1,rs2,rs4= null;
		
	/*	String P_SEQ_VAL=list1.get(0);*/
		
		String AgentWiseFileName =fileName;
		System.out.println("agentwise_business ==>>>>"+AgentWiseFileName);
		String directory=createDir("ExcelWritingFolder");
		System.out.println("directory ==>>>"+directory);
		excelGenPath=directory+""+AgentWiseFileName+".xls";
		System.out.println("agentwise_business ==>>>>"+AgentWiseFileName+"::directory ==>>>"+directory+"::excelGenPath==>>>>"+excelGenPath);
		Workbook workbook =  (Workbook) new HSSFWorkbook();
		
		Sheet studentsSheet = workbook.createSheet("DueCommissionReport");
		CellStyle style = null;
		style = workbook.createCellStyle();
		CellRangeAddress basicRang = null;
		Cell cell=null;

		Row RootRow = null;
		
		Font font = workbook.createFont();
		font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
		font.setFontHeightInPoints(Short.parseShort("12"));
		font.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
		
		DataFormat hssfDataFormat = workbook.createDataFormat();
		
		
		/*String Prod_code =null;
		String Peroid_from =null;
		String Peroid_to =null;
		
		Prod_code  = param.get(0).toString().trim();
		Peroid_from = param.get(1).toString().trim();
		Peroid_to = param.get(2).toString().trim();*/
		String sequence_number=null;
		sequence_number=list1.get(0).toString().trim();
		
		int rowIndex =0;
		short cellIndex = 0;
		
			RootRow = studentsSheet.createRow(rowIndex++);
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Agent Number");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Agent Name");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Agent Region");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Branch Name");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Branch");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("First Year RAP");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Renewal RAP");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("First Year Life");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Renewal Life");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Prime Plan - First Year");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Prime Plan - Renewal");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Seed - First Year");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Seed - Renewal");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Net Agent Commission");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Payroll No");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);
			
			
			String QUERY= null;
			
			/* QUERY="SELECT PSAD_ACV_AGENT_CODE,PSAD_AGENT_NAME,PSAD_CUST_AGENCY_BRANCH_CODE,PSAD_CUST_REGION_CODE,PSAD_DIVN_NAME"
					+ ",PSAD_FNRAP_ACV_FC_VALUE,PSAD_FRAP_ACV_FC_VALUE,PSAD_RNRAP_ACV_FC_VALUE,"
					+ "PSAD_RRAP_ACV_FC_VALUE,PSAD_FPRIME_ACV_FC_VALUE,PSAD_RPRIME_ACV_FC_VALUE," 
					+ "PSAD_FSEED_ACV_FC_VALUE,PSAD_RSEED_ACV_FC_VALUE,PSAD_NET_VALUE FROM PW_IL_SUM_AGENT_DUE WHERE PSAD_SYS_ID=? ";  */
					
			QUERY="SELECT PSAD_ACV_AGENT_CODE,PSAD_AGENT_NAME,PSAD_CUST_AGENCY_BRANCH_CODE,PSAD_CUST_REGION_CODE,PSAD_DIVN_NAME"
					+ ",PSAD_FNRAP_ACV_FC_VALUE,PSAD_FRAP_ACV_FC_VALUE,PSAD_NET_VALUE,PSAD_RNRAP_ACV_FC_VALUE,"
					+ "PSAD_RRAP_ACV_FC_VALUE,PSAD_INCOME_FILE_NO FROM PW_IL_SUM_AGENT_DUE WHERE PSAD_SYS_ID=? ";
			
			try{
				rs1 =  new CRUDHandler().executeSelectStatement(QUERY,con,new Object[] {sequence_number});
				System.out.println("***********sequence_number******>"+sequence_number);
								
				/*Added by Janani on 17.01.2018 for ZBLIFE-1472007*/
			/*	style = workbook.createCellStyle();*/
				//font = workbook.createFont();
				
				/*End of ZBLIFE-1472007*/
				
				Font String_font = workbook.createFont();
				String_font.setFontHeightInPoints(Short.parseShort("11"));
				String_font.setFontName("Calibri");
				
                CellStyle String_style = null;
				String_style = workbook.createCellStyle();
				String_style.setFont(String_font);
				String_style.setAlignment(CellStyle.ALIGN_LEFT);
				
				
				Font Value_font = workbook.createFont();
				Value_font.setFontHeightInPoints(Short.parseShort("11"));
				Value_font.setFontName("Calibri");
				
				
                CellStyle Value_style = null;
                Value_style = workbook.createCellStyle();
                Value_style.setFont(Value_font);
                Value_style.setAlignment(CellStyle.ALIGN_RIGHT);
                Value_style.setDataFormat(hssfDataFormat.getFormat("#0.00"));
				
				
				
				while(rs1.next()){

					
					/*Commented Style,font by Janani on 17.01.2018 for ZBLIFE-1472007*/
					
					Row RootRow_ONE = studentsSheet.createRow(rowIndex++);
					cellIndex=0;
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getString("PSAD_ACV_AGENT_CODE"));
					//style = workbook.createCellStyle();
					//font = workbook.createFont();
					/*font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					style.setAlignment(CellStyle.ALIGN_RIGHT);*/
					cell.setCellStyle(Value_style);
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getString("PSAD_AGENT_NAME"));
					//style = workbook.createCellStyle();
					//font = workbook.createFont();
					/*font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);*/
					cell.setCellStyle(String_style);
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getString("PSAD_CUST_REGION_CODE"));
				//	style = workbook.createCellStyle();
					//font = workbook.createFont();
					/*font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					style.setAlignment(CellStyle.ALIGN_RIGHT);*/
					cell.setCellStyle(Value_style);
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getString("PSAD_DIVN_NAME"));
					//style = workbook.createCellStyle();
					//font = workbook.createFont();
					/*font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);*/
					cell.setCellStyle(String_style);
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getString("PSAD_CUST_AGENCY_BRANCH_CODE"));
				//	style = workbook.createCellStyle();
					//font = workbook.createFont();
					/*font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					style.setAlignment(CellStyle.ALIGN_RIGHT);*/
					cell.setCellStyle(Value_style);
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getDouble("PSAD_FRAP_ACV_FC_VALUE"));//first year rap
					//style = workbook.createCellStyle();
					//font = workbook.createFont();
					/*font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					style.setDataFormat(hssfDataFormat.getFormat("#0.00"));*/
					cell.setCellStyle(Value_style);
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getDouble("PSAD_RRAP_ACV_FC_VALUE"));//renewal rap
					//style = workbook.createCellStyle();
					//font = workbook.createFont();
					/*font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					style.setDataFormat(hssfDataFormat.getFormat("#0.00"));*/
					cell.setCellStyle(Value_style);
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getDouble("PSAD_FNRAP_ACV_FC_VALUE"));//first year life
					//style = workbook.createCellStyle();
					//font = workbook.createFont();
				/*	font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					style.setDataFormat(hssfDataFormat.getFormat("#0.00"));*/
					cell.setCellStyle(Value_style);
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getDouble("PSAD_RNRAP_ACV_FC_VALUE"));//renewal life
					//style = workbook.createCellStyle();
					//font = workbook.createFont();
					/*font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					style.setDataFormat(hssfDataFormat.getFormat("#0.00"));*/
					cell.setCellStyle(Value_style);
					
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getDouble("PSAD_FPRIME_ACV_FC_VALUE"));//Prime plan first year
					//style = workbook.createCellStyle();
					//font = workbook.createFont();
					/*font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					style.setDataFormat(hssfDataFormat.getFormat("#0.00"));*/
					cell.setCellStyle(Value_style);
					
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getDouble("PSAD_RPRIME_ACV_FC_VALUE"));//Prime plan renewal
					//style = workbook.createCellStyle();
					//font = workbook.createFont();
					/*font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					style.setDataFormat(hssfDataFormat.getFormat("#0.00"));*/
					cell.setCellStyle(Value_style);
					
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getDouble("PSAD_FSEED_ACV_FC_VALUE"));//Seed first year
					//style = workbook.createCellStyle();
					//font = workbook.createFont();
					/*font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					style.setDataFormat(hssfDataFormat.getFormat("#0.00"));*/
					cell.setCellStyle(Value_style);
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getDouble("PSAD_RSEED_ACV_FC_VALUE"));//Seed renewal
				//	style = workbook.createCellStyle();
					//font = workbook.createFont();
					/*font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					style.setDataFormat(hssfDataFormat.getFormat("#0.00"));*/
					cell.setCellStyle(Value_style);
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getDouble("PSAD_NET_VALUE"));//net agent commission
					//style = workbook.createCellStyle();
					//font = workbook.createFont();
					/*font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					style.setDataFormat(hssfDataFormat.getFormat("#0.00"));*/
					cell.setCellStyle(Value_style);
					
					/*End of ZBLIFE-1472007*/
					
					/*Newly Added By Dhinesh on 05-03-2018*/
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getString("PSAD_INCOME_FILE_NO"));
					style = workbook.createCellStyle();
					//font = workbook.createFont();
					font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					style.setAlignment(CellStyle.ALIGN_RIGHT);
					cell.setCellStyle(style);
					
					
					/*End*/
				}

				System.out.println("cellindex"+cellIndex);
				for(int a = 0 ;a<cellIndex;a++){
					studentsSheet.autoSizeColumn(a);
				}
				
				
				}  
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

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
	
	/*Added by Ameen on 28-11-2017 for ZBLIFE-1457951 */
	
	public String pw_il_check_off_error_log(Connection con,String fileName , String ReportName,List param) throws ParseException, Exception{
		
		String excelGenPath = "";
		ResultSet rs1= null;
		
		String AgentWiseFileName =fileName;
		System.out.println("agentwise_business ==>>>>"+AgentWiseFileName);
		String directory=createDir("ExcelWritingFolder");
		System.out.println("directory ==>>>"+directory);
		excelGenPath=directory+""+AgentWiseFileName+".xls";
		System.out.println("agentwise_business ==>>>>"+AgentWiseFileName+"::directory ==>>>"+directory+"::excelGenPath==>>>>"+excelGenPath);
		Workbook workbook =  (Workbook) new HSSFWorkbook();
		
		Sheet studentsSheet = workbook.createSheet("ErrorLog");
		CellStyle style = null;
		style = workbook.createCellStyle();
		CellRangeAddress basicRang = null;
		Cell cell=null;

		Row RootRow = null;
		
		Font font = workbook.createFont();
		font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
		font.setFontHeightInPoints(Short.parseShort("12"));
		font.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
		
		DataFormat hssfDataFormat = workbook.createDataFormat();
		
		String sequence_number=null;
		sequence_number=param.get(0).toString().trim();
		
		int rowIndex =0;
		short cellIndex = 0;
		
			RootRow = studentsSheet.createRow(rowIndex++);
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Process Date");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Reference No.");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Employer Code");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Pay Mode");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Policy No.");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Due Date");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Due Amount");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Reason");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			
			String QUERY= null;
			
			QUERY="SELECT * FROM PW_IL_CHECK_OFF_ERROR_LOG WHERE COER_REF_NO = ?";
			String proDate="";
			String dueDate="";
			try{
				rs1 =  new CRUDHandler().executeSelectStatement(QUERY,con,new Object[]{sequence_number});
				System.out.println("***********sequence_number******>"+sequence_number);
				style = workbook.createCellStyle();
				font = workbook.createFont();
				while(rs1.next()){
					if(rs1.getDate("COER_PROCESS_DT") != null){
						proDate=new SimpleDateFormat("dd/MM/yyyy").format(rs1.getDate("COER_PROCESS_DT")).toString().toUpperCase();
					}
					Row RootRow_ONE = studentsSheet.createRow(rowIndex++);
					cellIndex=0;
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(proDate);
					/*style = workbook.createCellStyle();
					font = workbook.createFont();*/
					font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					cell.setCellStyle(style);
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getString("COER_REF_NO"));
					/*style = workbook.createCellStyle();
					font = workbook.createFont();*/
					font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					cell.setCellStyle(style);
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getString("COER_EMPLOYER_CODE"));
					/*style = workbook.createCellStyle();
					font = workbook.createFont();*/
					font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					style.setAlignment(CellStyle.ALIGN_RIGHT);
					cell.setCellStyle(style);
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getString("COER_PAY_MODE"));
					/*style = workbook.createCellStyle();
					font = workbook.createFont();*/
					font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					cell.setCellStyle(style);
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getString("COER_POL_NO"));
					/*style = workbook.createCellStyle();
					font = workbook.createFont();*/
					font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					cell.setCellStyle(style);
					
					cell = RootRow_ONE.createCell(cellIndex++);
					if(rs1.getDate("COER_DUE_DATE") != null){
						dueDate=new SimpleDateFormat("dd/MM/yyyy").format(rs1.getDate("COER_DUE_DATE")).toString().toUpperCase();
					}
					cell.setCellValue(dueDate);
					/*style = workbook.createCellStyle();
					font = workbook.createFont();*/
					font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					cell.setCellStyle(style);
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getDouble("COER_DUE_AMT"));
					/*style = workbook.createCellStyle();
					font = workbook.createFont();*/
					font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					cell.setCellStyle(style);
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getString("COER_REASON"));
					/*style = workbook.createCellStyle();
					font = workbook.createFont();*/
					font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					cell.setCellStyle(style);
					
					
				}

				System.out.println("cellindex"+cellIndex);
				for(int a = 0 ;a<cellIndex;a++){
					studentsSheet.autoSizeColumn(a);
				}
				
				
				}  
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

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

	/*End*/
	
	/*added by daisy 18-09-2018 kic-term reserve*/
	public String writeTerma_ReportExcel(ArrayList<String> list1,Connection con,String fileName , String ReportName,List param) throws ParseException, Exception{

		
		String DetailQuery= null;
		String excelGenPath = "";
	//	Connection con = null;
		ResultSet rs,rs1,rs2,rs4= null;
		
	/*	String P_SEQ_VAL=list1.get(0);*/
		
		String AgentWiseFileName =fileName;
		System.out.println("agentwise_business ==>>>>"+AgentWiseFileName);
		String directory=createDir("ExcelWritingFolder");
		System.out.println("directory ==>>>"+directory);
		excelGenPath=directory+""+AgentWiseFileName+".xls";
		System.out.println("agentwise_business ==>>>>"+AgentWiseFileName+"::directory ==>>>"+directory+"::excelGenPath==>>>>"+excelGenPath);
		Workbook workbook =  (Workbook) new HSSFWorkbook();
		
		Sheet studentsSheet = workbook.createSheet("Term-Reserve Report");
		CellStyle style = null;
		style = workbook.createCellStyle();
		CellRangeAddress basicRang = null;
		Cell cell=null;

		Row RootRow = null;
		
		Font font = workbook.createFont();
		font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
		font.setFontHeightInPoints(Short.parseShort("12"));
		font.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
		
		DataFormat hssfDataFormat = workbook.createDataFormat();
		
		
		/*String Prod_code =null;
		String Peroid_from =null;
		String Peroid_to =null;
		
		Prod_code  = param.get(0).toString().trim();
		Peroid_from = param.get(1).toString().trim();
		Peroid_to = param.get(2).toString().trim();*/
		String sequence_number=null;
		sequence_number=list1.get(0).toString().trim();
		
		int rowIndex =0;
		short cellIndex = 0;
			
			RootRow = studentsSheet.createRow(rowIndex++);
						
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Row");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			/*Added and pasted by Daisy on 29-01-2019*/
			/*Added by Ameen on 21-12-2018 as sugg. by Bala*/
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Policy No.");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);
			/*End*/
		
			/*Added by Daisy on 29-01-2019 as sugg. by Vaithisvaran*/
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Policy Term");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);
			
			/*Newly Added by Daisy on 04-04-2019 for KIC Term reserve report : Remove column no. of insured and 
			  add Modal gross premium (COI for Gold term – T02), Issue date, Maturity Date, Currency, Client Net fund for Terma Plus  as sugg. by Sreeram*/

			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Issue Date");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Maturity Date");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Currency");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);
			
			/*End*/
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Premium Frequency");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Product");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);
			/*End*/
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Age");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Remaining duration in months");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			/*Newly Added by Daisy on 04-04-2019 for KIC Term reserve report : Remove column no. of insured and 
			  add Modal gross premium (COI for Gold term – T02), Issue date, Maturity Date, Currency, Client Net fund for Terma Plus  as sugg. by Sreeram*/
			/*cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Number of insureds");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	*/
			
			/*End*/
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Sum @ Risk");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Net level premium");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);
			
			/*Newly Added by Daisy on 04-04-2019 for KIC Term reserve report : Remove column no. of insured and 
			  add Modal gross premium (COI for Gold term – T02), Issue date, Maturity Date, Currency, Client Net fund for Terma Plus  as sugg. by Sreeram*/

			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Modal Premium");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Client Net Fund Query");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);
			
			/*End*/
			
			cell = RootRow.createCell(cellIndex++);
			cell.setCellValue("Reserve");
			style = workbook.createCellStyle();
			font = workbook.createFont();
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints(Short.parseShort("12"));
			font.setFontName("Calibri");
			style.setFont(font);
			cell.setCellStyle(style);	
			
			String QUERY= null;
			
			/*
			 * modified by Ameen on 21-12-2018 as sugg. by Bala
			 * QUERY="SELECT CUST_ROW_ID,CUST_AGE,CUST_COUNT_NUM,CUST_NO_OF_INSURED,CUST_SUM_ASSD,CUST_BASIC_PREMIUM,CUST_RESERVE_AMT FROM PW_TERMA_REPORT WHERE CUST_SYS_ID =?";*/
			/* modified by Daisy on 29-01-2019 as sugg. by Vaithisvaran
			/*QUERY="SELECT CUST_POL_NO,CUST_ROW_ID,CUST_AGE,CUST_COUNT_NUM,CUST_NO_OF_INSURED,CUST_SUM_ASSD,CUST_BASIC_PREMIUM,CUST_RESERVE_AMT FROM PW_TERMA_REPORT WHERE CUST_SYS_ID =?";*/
			
			/*Modified by saritha on 04-04-2019 for KIC Term reserve report : Remove column no. of insured and 
			 * add Modal gross premium (COI for Gold term – T02), Issue date, Maturity Date, Currency, Client Net fund for Terma Plus*/
			
			//QUERY="SELECT CUST_POL_NO,CUST_ROW_ID,CUST_AGE,CUST_COUNT_NUM,CUST_NO_OF_INSURED,CUST_SUM_ASSD,CUST_BASIC_PREMIUM,CUST_POL_PERIOD,CUST_POL_MODE_OF_PYMT,CUST_POL_PROD_CODE,CUST_RESERVE_AMT FROM PW_TERMA_REPORT WHERE CUST_SYS_ID = ?";
			QUERY="SELECT CUST_POL_NO, CUST_ROW_ID, CUST_AGE, TO_CHAR(CUST_POL_START_DT, 'DD/MM/RRRR') START_DATE, TO_CHAR(CUST_EXPIRY_DT, 'DD/MM/RRRR') EXPIRY_DATE, CUST_CURRENCY, CUST_COUNT_NUM, CUST_SUM_ASSD, CUST_BASIC_PREMIUM, CUST_POL_PERIOD,"
					+ " CUST_POL_MODE_OF_PYMT, CUST_POL_PROD_CODE, CUST_LC_PREM, CUST_PNFD_GROSS_CF_VAL, CUST_RESERVE_AMT FROM PW_TERMA_REPORT WHERE CUST_SYS_ID = ?";
			/*End*/
			try{
				rs1 =  new CRUDHandler().executeSelectStatement(QUERY,con,new Object[] {sequence_number});
				System.out.println("***********sequence_number******>"+sequence_number);
								
				/*Added by Janani on 17.01.2018 for ZBLIFE-1472007*/
			/*	style = workbook.createCellStyle();*/
				//font = workbook.createFont();
				
				/*End of ZBLIFE-1472007*/
				
				Font String_font = workbook.createFont();
				String_font.setFontHeightInPoints(Short.parseShort("11"));
				String_font.setFontName("Calibri");
				
                CellStyle String_style = null;
				String_style = workbook.createCellStyle();
				String_style.setFont(String_font);
				String_style.setAlignment(CellStyle.ALIGN_RIGHT);
				
				
			/*	Font Value_font = workbook.createFont();
				Value_font.setFontHeightInPoints(Short.parseShort("11"));
				Value_font.setFontName("Calibri");*/
				
				
                CellStyle Value_style = null;
                Value_style = workbook.createCellStyle();
                Value_style.setFont(String_font);
                Value_style.setAlignment(CellStyle.ALIGN_RIGHT);
                Value_style.setDataFormat(hssfDataFormat.getFormat("#0.00"));
				
				
                
                
                
                
				
				while(rs1.next()){

					
					/*Commented Style,font by Janani on 17.01.2018 for ZBLIFE-1472007*/
					
					Row RootRow_ONE = studentsSheet.createRow(rowIndex++);
					cellIndex=0;
										
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getInt("CUST_ROW_ID"));
					//style = workbook.createCellStyle();
					//font = workbook.createFont();
					/*font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					style.setAlignment(CellStyle.ALIGN_RIGHT);*/
					cell.setCellStyle(String_style);
					/*Added and pasted by Daisy on 29-01-2019*/
					/*Added by Ameen on 21-12-2018 as sugg. by Bala*/
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getString("CUST_POL_NO"));
					/*end*/
					/*Added by Daisy on 29-01-2019 as sugg. by Vaithisvaran*/
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getInt("CUST_POL_PERIOD"));
					cell.setCellStyle(String_style);
					
					/*Newly added by saritha on 04-04-2019 for KIC Term reserve report : Remove column no. of insured and 
					 * add Modal gross premium (COI for Gold term – T02), Issue date, Maturity Date, Currency, Client Net fund for Terma Plus*/
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getString("START_DATE"));
					cell.setCellStyle(String_style);
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getString("EXPIRY_DATE"));
					cell.setCellStyle(String_style);
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getString("CUST_CURRENCY"));
					cell.setCellStyle(String_style);
					
					/*End*/
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getString("CUST_POL_MODE_OF_PYMT"));
					cell.setCellStyle(String_style);
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getString("CUST_POL_PROD_CODE"));
					cell.setCellStyle(String_style);
					/*End*/
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getString("CUST_AGE"));
					//style = workbook.createCellStyle();
					//font = workbook.createFont();
					/*font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);*/
					cell.setCellStyle(String_style);
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getInt("CUST_COUNT_NUM"));
				//	style = workbook.createCellStyle();
					//font = workbook.createFont();
					/*font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					style.setAlignment(CellStyle.ALIGN_RIGHT);*/
					cell.setCellStyle(String_style);
					
					/*Commentted by Daisy on 04-04-2019 for KIC Term reserve report : Remove column no. of insured and 
					  add Modal gross premium (COI for Gold term – T02), Issue date, Maturity Date, Currency, Client Net fund for Terma Plus  as sugg. by Sreeram*/
					
					/*cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getInt("CUST_NO_OF_INSURED"));
					//style = workbook.createCellStyle();
					//font = workbook.createFont();s
					font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					cell.setCellStyle(String_style);*/
					
					/*End*/
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getDouble("CUST_SUM_ASSD"));
				//	style = workbook.createCellStyle();
					//font = workbook.createFont();
					/*font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					style.setAlignment(CellStyle.ALIGN_RIGHT);*/
					cell.setCellStyle(String_style);
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getDouble("CUST_BASIC_PREMIUM"));//first year rap
					//style = workbook.createCellStyle();
					//font = workbook.createFont();
					/*font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					style.setDataFormat(hssfDataFormat.getFormat("#0.00"));*/
					cell.setCellStyle(Value_style);
					
					/*Newly added by saritha on 04-04-2019 for KIC Term reserve report : Remove column no. of insured and 
					 * add Modal gross premium (COI for Gold term – T02), Issue date, Maturity Date, Currency, Client Net fund for Terma Plus*/
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getDouble("CUST_LC_PREM"));
					cell.setCellStyle(Value_style);
					
					/*Newly added by saritha on 04-04-2019 for KIC Term reserve report : Remove column no. of insured and 
					 * add Modal gross premium (COI for Gold term – T02), Issue date, Maturity Date, Currency, Client Net fund for Terma Plus*/
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getDouble("CUST_PNFD_GROSS_CF_VAL"));
					cell.setCellStyle(Value_style);
					
					/*End*/
					
					cell = RootRow_ONE.createCell(cellIndex++);
					cell.setCellValue(rs1.getDouble("CUST_RESERVE_AMT"));//first year rap
					//style = workbook.createCellStyle();
					//font = workbook.createFont();
					/*font.setFontHeightInPoints(Short.parseShort("11"));
					font.setFontName("Calibri");
					style.setFont(font);
					style.setDataFormat(hssfDataFormat.getFormat("#0.00"));*/
					cell.setCellStyle(Value_style);
					
					
				}

				System.out.println("cellindex"+cellIndex);
				for(int a = 0 ;a<cellIndex;a++){
					studentsSheet.autoSizeColumn(a);
				}
				
				
				}  
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

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
	/*ended by daisy 18-09-2018 kic-term reserve*/
	/*added by gopi for Surrender,Maturity and lapse report on 23/02/2018*/
    public String New_Business_ReportExcel(ArrayList<String> list1,Connection con,String fileName , String ReportName,List param) throws ParseException, Exception{

	
	String DetailQuery= null;
	String excelGenPath = "";
//	Connection con = null;
	ResultSet rs,rs1,rs2,rs4= null;
	
/*	String P_SEQ_VAL=list1.get(0);*/
	
	String AgentWiseFileName =fileName;
	System.out.println("agentwise_business ==>>>>"+AgentWiseFileName);
	String directory=createDir("ExcelWritingFolder");
	System.out.println("directory ==>>>"+directory);
	excelGenPath=directory+""+AgentWiseFileName+".xls";
	System.out.println("agentwise_business ==>>>>"+AgentWiseFileName+"::directory ==>>>"+directory+"::excelGenPath==>>>>"+excelGenPath);
	Workbook workbook =  (Workbook) new HSSFWorkbook();
	
	/*Sheet studentsSheet = workbook.createSheet("New_Business");*/
	Sheet studentsSheet=null;
	String transaction_code =null;
	String sequence_number=null;
	sequence_number=list1.get(0).toString().trim();
	//String Peroid_to =null;
	
	/*
	 * modified by Ameen on 28-12-2018 for KIC to set sheet name based on lov
	 * transaction_code  = param.get(2).toString().trim();*/
	transaction_code  = param.get(4).toString().trim();
	if(transaction_code.equalsIgnoreCase("N")){
		studentsSheet = workbook.createSheet("NEW_BUSINESS");
		}else{
			studentsSheet = workbook.createSheet("RENEWAL_BUSINESS");
		}
	
	
	/*CellStyle style = null;
	style = workbook.createCellStyle();
	style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	*/
	
	CellRangeAddress basicRang = null;
	Cell cell=null;

	Row RootRow = null;
	
	Font font = workbook.createFont();
	font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
	font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
	font.setFontHeightInPoints(Short.parseShort("11"));
	font.setFontName("Calibri");
	DataFormat hssfDataFormat = workbook.createDataFormat();
	
	
	CellStyle backgroundStyle = null;
	backgroundStyle = workbook.createCellStyle();
	
	
	CellStyle style = null;
	style = workbook.createCellStyle();
	style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	
	
	
	
	int rowIndex_new =0;
	//Modified Daisy on 05-01-2019 for KIC - NEW BUSINESS AND NEW RENEWAL
		/*short cellIndex_new =18;*/
		short cellIndex_new =20;
	
	RootRow = studentsSheet.createRow(rowIndex_new);
	RootRow.setHeight((short)900);
	
	cell = RootRow.createCell(cellIndex_new++);
	//cell.setCellValue("Accidental Death");
		cell.setCellValue("ACCIDENTAL DEATH BENEFIT RIDER");//Modified Daisy on17-12-2018 for KIC - NEW BUSINESS AND NEW RENEWAL
	backgroundStyle.setFont(font);
	backgroundStyle.setAlignment(CellStyle.ALIGN_CENTER);
	cell.setCellStyle(backgroundStyle);
	backgroundStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	backgroundStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	cell.setCellStyle(backgroundStyle);
	//Modified Daisy on 05-01-2019 for KIC - NEW BUSINESS AND NEW RENEWAL
		/*studentsSheet.addMergedRegion(new CellRangeAddress(0,0,18,23));
		basicRang = new CellRangeAddress(0,0,18,23);*/
		studentsSheet.addMergedRegion(new CellRangeAddress(0,0,20,25));
		basicRang = new CellRangeAddress(0,0,20,25);
		/*End*/
	RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);	
	RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	
	short cellindex_count=cellIndex_new++;
	int cellindexfinal=cellindex_count+5;
	cell = RootRow.createCell(cellindexfinal);
	//cell.setCellValue("PTD accident any occupation");
	cell.setCellValue("CRITICAL ILLNESS 11 DISEASES");//Modified Daisy on17-12-2018 for KIC - NEW BUSINESS AND NEW RENEWAL
	backgroundStyle.setFont(font);
	backgroundStyle.setAlignment(CellStyle.ALIGN_CENTER);
	cell.setCellStyle(backgroundStyle);
	backgroundStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	backgroundStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	cell.setCellStyle(backgroundStyle);
	//Modified Daisy on 05-01-2019 for KIC - NEW BUSINESS AND NEW RENEWAL
		/*studentsSheet.addMergedRegion(new CellRangeAddress(0,0,24,29));
		basicRang = new CellRangeAddress(0,0,24,29);*/
		studentsSheet.addMergedRegion(new CellRangeAddress(0,0,26,31));
		basicRang = new CellRangeAddress(0,0,26,31);
		/*End*/
	RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);	
	RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);

	
	short cellindex_count1=cellIndex_new++;
	int cellindexfinal1=cellindex_count1+10;
	cell = RootRow.createCell(cellindexfinal1);
	//cell.setCellValue("PTD Sickness any occupation");
		cell.setCellValue("CRITICAL ILLNESS 38 DISEASES");//Modified Daisy on17-12-2018 for KIC - NEW BUSINESS AND NEW RENEWAL
	backgroundStyle.setFont(font);
	backgroundStyle.setAlignment(CellStyle.ALIGN_CENTER);
	cell.setCellStyle(backgroundStyle);
	backgroundStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	backgroundStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	cell.setCellStyle(backgroundStyle);
	//Modified Daisy on 05-01-2019 for KIC - NEW BUSINESS AND NEW RENEWAL
		/*studentsSheet.addMergedRegion(new CellRangeAddress(0,0,30,35));
		basicRang = new CellRangeAddress(0,0,30,35);*/
		studentsSheet.addMergedRegion(new CellRangeAddress(0,0,32,37));
		basicRang = new CellRangeAddress(0,0,32,37);
	/*End*/
	RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);	
	RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	
	

	short cellindex_count2=cellIndex_new++;
	int cellindexfinal2=cellindex_count2+15;
	cell = RootRow.createCell(cellindexfinal2);
	//cell.setCellValue("PTD accident (own or suited)");
		cell.setCellValue("INCOME BENEFIT RIDER DEATH");//Modified Daisy on17-12-2018 for KIC - NEW BUSINESS AND NEW RENEWAL
	backgroundStyle.setFont(font);
	backgroundStyle.setAlignment(CellStyle.ALIGN_CENTER);
	cell.setCellStyle(backgroundStyle);
	backgroundStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	backgroundStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	cell.setCellStyle(backgroundStyle);
	//Modified Daisy on 05-01-2019 for KIC - NEW BUSINESS AND NEW RENEWAL
		/*studentsSheet.addMergedRegion(new CellRangeAddress(0,0,36,41));
		basicRang = new CellRangeAddress(0,0,36,41);*/
		studentsSheet.addMergedRegion(new CellRangeAddress(0,0,38,43));
		basicRang = new CellRangeAddress(0,0,38,43);
	/*End*/
	RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);	
	RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	
	short cellindex_count3=cellIndex_new++;
	int cellindexfinal3=cellindex_count3+20;
	cell = RootRow.createCell(cellindexfinal3);
	//cell.setCellValue("PTD Sickness (own or suited)");
		cell.setCellValue("INCOME BENEFIT RIDER (TPD)");//Modified Daisy on17-12-2018 for KIC - NEW BUSINESS AND NEW RENEWAL
	backgroundStyle.setFont(font);
	backgroundStyle.setAlignment(CellStyle.ALIGN_CENTER);
	cell.setCellStyle(backgroundStyle);
	backgroundStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	backgroundStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	cell.setCellStyle(backgroundStyle);
	//Modified Daisy on 05-01-2019 for KIC - NEW BUSINESS AND NEW RENEWAL
		/*studentsSheet.addMergedRegion(new CellRangeAddress(0,0,42,47));
		basicRang = new CellRangeAddress(0,0,42,47);*/
		studentsSheet.addMergedRegion(new CellRangeAddress(0,0,44,49));
		basicRang = new CellRangeAddress(0,0,44,49);
	/*End*/
	RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);	
	RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	
	short cellindex_count4=cellIndex_new++;
	int cellindexfinal4=cellindex_count4+25;
	cell = RootRow.createCell(cellindexfinal4);
	//cell.setCellValue("PPD accident");
		cell.setCellValue("PPD (ACCIDENT&SICKNESS)");//Modified Daisy on17-12-2018 for KIC - NEW BUSINESS AND NEW RENEWAL
	backgroundStyle.setFont(font);
	backgroundStyle.setAlignment(CellStyle.ALIGN_CENTER);
	cell.setCellStyle(backgroundStyle);
	backgroundStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	backgroundStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	cell.setCellStyle(backgroundStyle);
	//Modified Daisy on 05-01-2019 for KIC - NEW BUSINESS AND NEW RENEWAL
		/*studentsSheet.addMergedRegion(new CellRangeAddress(0,0,48,53));
		basicRang = new CellRangeAddress(0,0,48,53);*/
		studentsSheet.addMergedRegion(new CellRangeAddress(0,0,50,55));
		basicRang = new CellRangeAddress(0,0,50,55);
	/*End*/
	RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);	
	RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	
	short cellindex_count5=cellIndex_new++;
	int cellindexfinal5=cellindex_count5+30;
	cell = RootRow.createCell(cellindexfinal5);
	//cell.setCellValue("PPD sickness");
		cell.setCellValue("PPD (ACCIDENT)");//Modified Daisy on17-12-2018 for KIC - NEW BUSINESS AND NEW RENEWAL
	backgroundStyle.setFont(font);
	backgroundStyle.setAlignment(CellStyle.ALIGN_CENTER);
	cell.setCellStyle(backgroundStyle);
	backgroundStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	backgroundStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	cell.setCellStyle(backgroundStyle);
	//Modified Daisy on 05-01-2019 for KIC - NEW BUSINESS AND NEW RENEWAL
		/*studentsSheet.addMergedRegion(new CellRangeAddress(0,0,54,59));
		basicRang = new CellRangeAddress(0,0,54,59);*/
		studentsSheet.addMergedRegion(new CellRangeAddress(0,0,56,61));
		basicRang = new CellRangeAddress(0,0,56,61);
	/*End*/
	RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);	
	RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	
	short cellindex_count6=cellIndex_new++;
	int cellindexfinal6=cellindex_count6+35;
	cell = RootRow.createCell(cellindexfinal6);
	//cell.setCellValue("TTD Accident");
		cell.setCellValue("PASSIVE WAR RISK (DEATH)");//Modified Daisy on17-12-2018 for KIC - NEW BUSINESS AND NEW RENEWAL
	backgroundStyle.setFont(font);
	backgroundStyle.setAlignment(CellStyle.ALIGN_CENTER);
	cell.setCellStyle(backgroundStyle);
	backgroundStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	backgroundStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	cell.setCellStyle(backgroundStyle);
	//Modified Daisy on 05-01-2019 for KIC - NEW BUSINESS AND NEW RENEWAL
//	studentsSheet.addMergedRegion(new CellRangeAddress(0,0,60,65));
//	basicRang = new CellRangeAddress(0,0,60,65);
	studentsSheet.addMergedRegion(new CellRangeAddress(0,0,62,67));
	basicRang = new CellRangeAddress(0,0,62,67);
	/*End*/
	RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);	
	RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	
	short cellindex_count7=cellIndex_new++;
	int cellindexfinal7=cellindex_count7+40;
	cell = RootRow.createCell(cellindexfinal7);
	//cell.setCellValue("Medex");
		cell.setCellValue("PASSIVE WAR RISK (PTD)");//Modified Daisy on17-12-2018 for KIC - NEW BUSINESS AND NEW RENEWAL
	backgroundStyle.setFont(font);
	backgroundStyle.setAlignment(CellStyle.ALIGN_CENTER);
	cell.setCellStyle(backgroundStyle);
	backgroundStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	backgroundStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	cell.setCellStyle(backgroundStyle);
	//Modified Daisy on 05-01-2019 for KIC - NEW BUSINESS AND NEW RENEWAL
		/*studentsSheet.addMergedRegion(new CellRangeAddress(0,0,66,71));
		basicRang = new CellRangeAddress(0,0,66,71);*/
		studentsSheet.addMergedRegion(new CellRangeAddress(0,0,68,73));
		basicRang = new CellRangeAddress(0,0,68,73);
	/*End*/
	RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);	
	RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	
	
	short cellindex_count8=cellIndex_new++;
	int cellindexfinal8=cellindex_count8+45;
	cell = RootRow.createCell(cellindexfinal8);
	//cell.setCellValue("PWR in case of death");
		cell.setCellValue("PASSIVE WAR RISK (PPD)");//Modified Daisy on17-12-2018 for KIC - NEW BUSINESS AND NEW RENEWAL
	backgroundStyle.setFont(font);
	backgroundStyle.setAlignment(CellStyle.ALIGN_CENTER);
	cell.setCellStyle(backgroundStyle);
	backgroundStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	backgroundStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	cell.setCellStyle(backgroundStyle);
	//Modified Daisy on 05-01-2019 for KIC - NEW BUSINESS AND NEW RENEWAL
		/*studentsSheet.addMergedRegion(new CellRangeAddress(0,0,72,77));
		basicRang = new CellRangeAddress(0,0,72,77);*/
		studentsSheet.addMergedRegion(new CellRangeAddress(0,0,74,79));
		basicRang = new CellRangeAddress(0,0,74,79);
	/*End*/
	RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);	
	RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	
	short cellindex_count9=cellIndex_new++;
	int cellindexfinal9=cellindex_count9+50;
	cell = RootRow.createCell(cellindexfinal9);
	//cell.setCellValue("PWR death and PTD accident own or suited or any occupation and PPD accident");
		cell.setCellValue("TOTAL PERMANENT DISABILITY A&S");//Modified Daisy on17-12-2018 for KIC - NEW BUSINESS AND NEW RENEWAL
	backgroundStyle.setFont(font);
	backgroundStyle.setAlignment(CellStyle.ALIGN_CENTER);
	cell.setCellStyle(backgroundStyle);
	backgroundStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	backgroundStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	cell.setCellStyle(backgroundStyle);
	//Modified Daisy on 05-01-2019 for KIC - NEW BUSINESS AND NEW RENEWAL
		/*studentsSheet.addMergedRegion(new CellRangeAddress(0,0,78,83));
		basicRang = new CellRangeAddress(0,0,78,83);*/
		studentsSheet.addMergedRegion(new CellRangeAddress(0,0,80,85));
		basicRang = new CellRangeAddress(0,0,80,85);
	/*End*/
	RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);	
	RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	
	short cellindex_count10=cellIndex_new++;
	int cellindexfinal10=cellindex_count10+55;
	cell = RootRow.createCell(cellindexfinal10);
	//cell.setCellValue("WOP ( PTD own or suited or any occupation)");
    //cell.setCellValue("WOP ( PTD own or suited or any occupation)");//Modified Daisy on17-12-2018 for KIC - NEW BUSINESS AND NEW RENEWAL
	cell.setCellValue("TOTAL PERMANENT DISABILITY ACC");//Modified Daisy on 18-12-2018 for KIC - NEW BUSINESS AND NEW RENEWAL
	backgroundStyle.setFont(font);
	backgroundStyle.setAlignment(CellStyle.ALIGN_CENTER);
	cell.setCellStyle(backgroundStyle);
	backgroundStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	backgroundStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	cell.setCellStyle(backgroundStyle);
	//Modified Daisy on 05-01-2019 for KIC - NEW BUSINESS AND NEW RENEWAL
		/*studentsSheet.addMergedRegion(new CellRangeAddress(0,0,84,89));
		basicRang = new CellRangeAddress(0,0,84,89);*/
		studentsSheet.addMergedRegion(new CellRangeAddress(0,0,86,91));
		basicRang = new CellRangeAddress(0,0,86,91);
	/*End*/
	RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);	
	RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	
	/*Added by Daisy on17-12-2018 for KIC - NEW BUSINESS AND NEW RENEWAL*/
	short cellindex_count11=cellIndex_new++;
	int cellindexfinal11=cellindex_count11+60;
	cell = RootRow.createCell(cellindexfinal11);
	cell.setCellValue("WOP-Proposer Disability");
	backgroundStyle.setFont(font);
	backgroundStyle.setAlignment(CellStyle.ALIGN_CENTER);
	cell.setCellStyle(backgroundStyle);
	backgroundStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	backgroundStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	cell.setCellStyle(backgroundStyle);
	//Modified Daisy on 05-01-2019 for KIC - NEW BUSINESS AND NEW RENEWAL
		/*studentsSheet.addMergedRegion(new CellRangeAddress(0,0,90,95));
		basicRang = new CellRangeAddress(0,0,90,95);*/
		studentsSheet.addMergedRegion(new CellRangeAddress(0,0,92,97));
		basicRang = new CellRangeAddress(0,0,92,97);
	/*End*/
	RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);	
	RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	/*End*/
	
	/*Added by Daisy on 18-12-2018 for KIC - NEW BUSINESS AND NEW RENEWAL*/
	short cellindex_count12=cellIndex_new++;
	int cellindexfinal12=cellindex_count12+65;
	cell = RootRow.createCell(cellindexfinal12);
	cell.setCellValue("ADDITIONAL LIFE INSURANCE");
	backgroundStyle.setFont(font);
	backgroundStyle.setAlignment(CellStyle.ALIGN_CENTER);
	cell.setCellStyle(backgroundStyle);
	backgroundStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	backgroundStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	cell.setCellStyle(backgroundStyle);
	//Modified Daisy on 05-01-2019 for KIC - NEW BUSINESS AND NEW RENEWAL
		/*studentsSheet.addMergedRegion(new CellRangeAddress(0,0,96,101));
		basicRang = new CellRangeAddress(0,0,96,101);*/
		studentsSheet.addMergedRegion(new CellRangeAddress(0,0,98,103));
		basicRang = new CellRangeAddress(0,0,98,103);
	/*End*/
	RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);	
	RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);

	short cellindex_count13=cellIndex_new++;
	int cellindexfinal13=cellindex_count13+70;
	cell = RootRow.createCell(cellindexfinal13);
	cell.setCellValue("CI STANDALONE 11 DISEASES");
	backgroundStyle.setFont(font);
	backgroundStyle.setAlignment(CellStyle.ALIGN_CENTER);
	cell.setCellStyle(backgroundStyle);
	backgroundStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	backgroundStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	cell.setCellStyle(backgroundStyle);
	//Modified Daisy on 05-01-2019 for KIC - NEW BUSINESS AND NEW RENEWAL
		/*studentsSheet.addMergedRegion(new CellRangeAddress(0,0,102,107));
		basicRang = new CellRangeAddress(0,0,102,107);*/
		studentsSheet.addMergedRegion(new CellRangeAddress(0,0,104,109));
		basicRang = new CellRangeAddress(0,0,104,109);
	/*End*/
	RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);	
	RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);

	short cellindex_count14=cellIndex_new++;
	int cellindexfinal14=cellindex_count14+75;
	cell = RootRow.createCell(cellindexfinal14);
	cell.setCellValue("CI STANDALONE 38 DISEASES");
	backgroundStyle.setFont(font);
	backgroundStyle.setAlignment(CellStyle.ALIGN_CENTER);
	cell.setCellStyle(backgroundStyle);
	backgroundStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	backgroundStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	cell.setCellStyle(backgroundStyle);
	//Modified Daisy on 05-01-2019 for KIC - NEW BUSINESS AND NEW RENEWAL
		/*studentsSheet.addMergedRegion(new CellRangeAddress(0,0,108,113));
		basicRang = new CellRangeAddress(0,0,108,113);*/
		studentsSheet.addMergedRegion(new CellRangeAddress(0,0,110,115));
		basicRang = new CellRangeAddress(0,0,110,115);
	/*End*/
	RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);	
	RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	/*End*/

	/*short cellindex_count11=cellIndex_new++;
	int cellindexfinal11=cellindex_count11+60;
	cell = RootRow.createCell(cellindexfinal11);
	
	short cellindex_count12=cellIndex_new++;
	int cellindexfinal12=cellindex_count12+65;
	cell = RootRow.createCell(cellindexfinal12);
	studentsSheet.addMergedRegion(new CellRangeAddress(0,0,96,96));
	//studentsSheet.addMergedRegion(new CellRangeAddress(0,0,90,90));
	basicRang = new CellRangeAddress(0,0,90,90);*/
	
	/*Commented and Modified by Daisy  on 17-12-2018*/
	/*short cellindex_count11=cellIndex_new++;
	int cellindexfinal11=cellindex_count11+60;
	cell = RootRow.createCell(cellindexfinal11);
	studentsSheet.addMergedRegion(new CellRangeAddress(0,0,90,90));
	basicRang = new CellRangeAddress(0,0,90,90);*/
	/*short cellindex_count12=cellIndex_new++;
	int cellindexfinal12=cellindex_count12+65;
	cell = RootRow.createCell(cellindexfinal12);
	studentsSheet.addMergedRegion(new CellRangeAddress(0,0,96,96));
	basicRang = new CellRangeAddress(0,0,96,96);*/
	short cellindex_count15=cellIndex_new++;
	int cellindexfinal15=cellindex_count15+80;
	cell = RootRow.createCell(cellindexfinal15);
	//Modified Daisy on 05-01-2019 for KIC - NEW BUSINESS AND NEW RENEWAL
		/*studentsSheet.addMergedRegion(new CellRangeAddress(0,0,96,96));
		basicRang = new CellRangeAddress(0,0,96,96);//Commented for added cell for kic report on 18-12-2018
		studentsSheet.addMergedRegion(new CellRangeAddress(0,0,114,114));
		basicRang = new CellRangeAddress(0,0,114,114);*/
		studentsSheet.addMergedRegion(new CellRangeAddress(0,0,116,116));
		basicRang = new CellRangeAddress(0,0,116,116);
	/*End*/
	/*End*/
	RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);	
	//RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	
	
	
	
	
	
	
	
	
	
	 int rowIndex =1;
	 short cellIndex =0;
	
	    
	 /*Added by Daisy on 03-01-2019*/
	    RootRow = studentsSheet.createRow(rowIndex++);//Added for replacement by Daisy on 05-01-2019
		cell = RootRow.createCell(cellIndex++);
		RootRow.setHeight((short)1000);//Added for replacement by Daisy on 05-01-2019
		//Added for replacement by Daisy on 05-01-2019
		/*cell.setCellValue("Date From");*/
		cell.setCellValue("Premium Paid Date From");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019
		/*basicRang = new CellRangeAddress(1,1,117,117);*/
		basicRang = new CellRangeAddress(1,1,0,0);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		//Added for replacement by Daisy on 05-01-2019
		/*cell.setCellValue("Date To");*/
		cell.setCellValue("Premium Paid Date To");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
		/*basicRang = new CellRangeAddress(1,1,118,118);*/
		basicRang = new CellRangeAddress(1,1,1,1);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		/*End*/
	    
	    /*RootRow = studentsSheet.createRow(rowIndex++);*///Commented by Daisy on 05-01-2019
		cell = RootRow.createCell(cellIndex++);
		RootRow.setHeight((short)1000);
		cell.setCellValue("Insured No.");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,0,0);*/
				basicRang = new CellRangeAddress(1,1,2,2);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	
		
		cell = RootRow.createCell(cellIndex++);
		RootRow.setHeight((short)1000);
		cell.setCellValue("Insured Name");
		style.setFont(font);
		cell.setCellStyle(style);	
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,1,1);*/
				basicRang = new CellRangeAddress(1,1,3,3);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		
		cell = RootRow.createCell(cellIndex++);
		RootRow.setHeight((short)1000);
		cell.setCellValue("Sex");
		style.setFont(font);
		cell.setCellStyle(style);	
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,2,2);*/
				basicRang = new CellRangeAddress(1,1,4,4);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		
	
		cell = RootRow.createCell(cellIndex++);
		RootRow.setHeight((short)1000);
		cell.setCellValue("Birth Date");
		style.setFont(font);
		cell.setCellStyle(style);	
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,3,3);*/
				basicRang = new CellRangeAddress(1,1,5,5);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		
		cell = RootRow.createCell(cellIndex++);
		RootRow.setHeight((short)1000);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*cell.setCellValue("Insured Age");*/
		cell.setCellValue("RI Insured Age");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,4,4);*/
				basicRang = new CellRangeAddress(1,1,6,6);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Product");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,5,5);*/
				basicRang = new CellRangeAddress(1,1,7,7);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Policy Num");*/
		cell.setCellValue("Policy Number");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,6,6);*/
				basicRang = new CellRangeAddress(1,1,8,8);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Policy Duration");
		style.setFont(font);
		cell.setCellStyle(style);	
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,7,7);*/
				basicRang = new CellRangeAddress(1,1,9,9);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Currency");
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
		/*basicRang = new CellRangeAddress(1,1,8,8);*/
		basicRang = new CellRangeAddress(1,1,10,10);
		/*End*/	
		/*basicRang = new CellRangeAddress(1,1,8,8);*//*Commented by Daisy for border*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Occupation");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,9,9);*/
				basicRang = new CellRangeAddress(1,1,11,11);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Occupation class");*/
		cell.setCellValue("Occupation Class");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
     	/*basicRang = new CellRangeAddress(1,1,10,10);*/
		basicRang = new CellRangeAddress(1,1,12,12);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		/*Added by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Medical Class");
		style.setFont(font);
		cell.setCellStyle(style);
		basicRang = new CellRangeAddress(1,1,13,13);
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		/*End*/
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Issue Date");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,11,11);*/
		
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
		//basicRang = new CellRangeAddress(1,1,13,13);
		basicRang = new CellRangeAddress(1,1,14,14);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Sum Insured");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,12,12);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,14,14);
				basicRang = new CellRangeAddress(1,1,15,15);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Sum Re-Insured");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,13,13);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,15,15);
				basicRang = new CellRangeAddress(1,1,16,16);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Monthly_PREMIUM");*/
		cell.setCellValue("Monthly Premium");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,14,14);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,16,16);
				basicRang = new CellRangeAddress(1,1,17,17);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Death Flat");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
		//basicRang = new CellRangeAddress(1,1,15,15);
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
		//basicRang = new CellRangeAddress(1,1,17,17);
		basicRang = new CellRangeAddress(1,1,18,18);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Death %");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,16,16);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,18,18);
				basicRang = new CellRangeAddress(1,1,19,19);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
//		cell.setCellValue("Extra premium ");
		cell.setCellValue("Extra Premium ");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,17,17);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,19,19);
				basicRang = new CellRangeAddress(1,1,20,20);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Sum Insured");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,18,18);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,20,20);
				basicRang = new CellRangeAddress(1,1,21,21);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Sum reinsured");*/
		cell.setCellValue("Sum Reinsured");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,19,19);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,21,21);
				basicRang = new CellRangeAddress(1,1,22,22);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*Commentted &Modified by saritha on 05-01-2019 for KIC - NEW BUSINESS AND NEW RENEWAL*/ 
		/*cell.setCellValue("Monthly PREMIUM");*/
		cell.setCellValue("Monthly Premium");
		/*End*/
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,20,20);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,22,22);
				basicRang = new CellRangeAddress(1,1,23,23);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*Commentted &Modified by saritha on 05-01-2019 for KIC - NEW BUSINESS AND NEW RENEWAL*/
		/*cell.setCellValue("Flat Exra rate");*/
		cell.setCellValue("Flat Extra Rate");
		/*End*/
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,21,21);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,23,23);
				basicRang = new CellRangeAddress(1,1,24,24);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);

		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Percentage Extra rate");*/
		cell.setCellValue("Percentage Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,22,22);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,24,24);
				basicRang = new CellRangeAddress(1,1,25,25);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Extra Premium");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
	    /*basicRang = new CellRangeAddress(1,1,23,23);*/
		//basicRang = new CellRangeAddress(1,1,25,25);
		basicRang = new CellRangeAddress(1,1,26,26);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
	
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Sum Insured");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,24,24);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,26,26);
				basicRang = new CellRangeAddress(1,1,27,27);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Sum reinsured");*/
		cell.setCellValue("Sum Reinsured");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,25,25);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,27,27);
				basicRang = new CellRangeAddress(1,1,28,28);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*Commentted &Modified by saritha on 05-01-2019 for KIC - NEW BUSINESS AND NEW RENEWAL*/ 
		/*cell.setCellValue("Monthly PREMIUM");*/
		cell.setCellValue("Monthly Premium");
		/*End*/
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,26,26);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,28,28);
				basicRang = new CellRangeAddress(1,1,29,29);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*Commentted &Modified by saritha on 05-01-2019 for KIC - NEW BUSINESS AND NEW RENEWAL*/
		/*cell.setCellValue("Flat Exra rate");*/
		cell.setCellValue("Flat Extra Rate");
		/*End*/
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,27,27);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,29,29);
				basicRang = new CellRangeAddress(1,1,30,30);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);

		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Percentage Extra rate");*/
		cell.setCellValue("Percentage Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,28,28);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,30,30);
				basicRang = new CellRangeAddress(1,1,31,31);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Extra Premium");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,29,29);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,31,31);
				basicRang = new CellRangeAddress(1,1,32,32);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Sum Insured");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,30,30);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,32,32);
				basicRang = new CellRangeAddress(1,1,33,33);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Sum reinsured");*/
		cell.setCellValue("Sum Reinsured");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,31,31);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,33,33);
				basicRang = new CellRangeAddress(1,1,34,34);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Monthly PREMIUM");*/
		cell.setCellValue("Monthly Premium");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,32,32);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,34,34);
				basicRang = new CellRangeAddress(1,1,35,35);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Flat Exra rate");*/
		cell.setCellValue("Flat Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,33,33);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,35,35);
				basicRang = new CellRangeAddress(1,1,36,36);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);

		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Percentage Extra rate");*/
		cell.setCellValue("Percentage Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,34,34);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,36,36);
				basicRang = new CellRangeAddress(1,1,37,37);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Extra Premium");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,35,35);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,37,37);
				basicRang = new CellRangeAddress(1,1,38,38);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Sum Insured");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,36,36);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,38,38);
				basicRang = new CellRangeAddress(1,1,39,39);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Sum reinsured");*/
		cell.setCellValue("Sum Reinsured");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,37,37);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,39,39);
				basicRang = new CellRangeAddress(1,1,40,40);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Monthly PREMIUM");*/
		cell.setCellValue("Monthly Premium");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,38,38);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,40,40);
				basicRang = new CellRangeAddress(1,1,41,41);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Flat Exra rate");*/
		cell.setCellValue("Flat Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,39,39);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,41,41);
				basicRang = new CellRangeAddress(1,1,42,42);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);

		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Percentage Extra rate");*/
		cell.setCellValue("Percentage Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,40,40);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,42,42);
				basicRang = new CellRangeAddress(1,1,43,43);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Extra Premium");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,41,41);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,43,43);
				basicRang = new CellRangeAddress(1,1,44,44);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Sum Insured");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,42,42);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,44,44);
				basicRang = new CellRangeAddress(1,1,45,45);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Sum reinsured");*/
		cell.setCellValue("Sum Reinsured");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,43,43);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,45,45);
				basicRang = new CellRangeAddress(1,1,46,46);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Monthly PREMIUM");*/
		cell.setCellValue("Monthly Premium");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,44,44);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				basicRang = new CellRangeAddress(1,1,47,47);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Flat Exra rate");*/
		cell.setCellValue("Flat Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,45,45);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,47,47);
				basicRang = new CellRangeAddress(1,1,48,48);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);

		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Percentage Extra rate");*/
		cell.setCellValue("Percentage Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,46,46);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,48,48);
				basicRang = new CellRangeAddress(1,1,49,49);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Extra Premium");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,47,47);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,49,49);
				basicRang = new CellRangeAddress(1,1,50,50);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Sum Insured");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,48,48);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,50,50);
				basicRang = new CellRangeAddress(1,1,51,51);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Sum reinsured");*/
		/*cell.setCellValue("Sum Rreinsured");*///Commented and Modified by Daisy on 05-01-2019
		cell.setCellValue("Sum Reinsured");//Commented and Modified by Daisy on 10-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,49,49);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,51,51);
				basicRang = new CellRangeAddress(1,1,52,52);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Monthly PREMIUM");*/
		/*cell.setCellValue("Monthly Premiium");*///Commented and Modified by Daisy on 05-01-2019
		cell.setCellValue("Monthly Premium");//Commented and Modified by Daisy on 10-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,50,50);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,52,52);
				basicRang = new CellRangeAddress(1,1,53,53);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Flat Exra rate");*/
		cell.setCellValue("Flat Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,51,51);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,53,53);
				basicRang = new CellRangeAddress(1,1,54,54);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);

		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Percentage Extra rate");*/
		cell.setCellValue("Percentage Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,52,52);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,54,54);
				basicRang = new CellRangeAddress(1,1,55,55);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Extra Premium");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,53,53);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,55,55);
				basicRang = new CellRangeAddress(1,1,56,56);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Sum Insured");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,54,54);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,56,56);
				basicRang = new CellRangeAddress(1,1,57,57);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Sum reinsured");*/
		cell.setCellValue("Sum Reinsured");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,55,55);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,57,57);
				basicRang = new CellRangeAddress(1,1,58,58);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Monthly PREMIUM");*/
		cell.setCellValue("Monthly Premium");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,56,56);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,58,58);
				basicRang = new CellRangeAddress(1,1,59,59);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Flat Exra rate");*/
		cell.setCellValue("Flat Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,57,57);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,59,59);
				basicRang = new CellRangeAddress(1,1,60,60);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);

		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Percentage Extra rate");*/
		cell.setCellValue("Percentage Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
		//basicRang = new CellRangeAddress(1,1,58,58);
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
		//basicRang = new CellRangeAddress(1,1,60,60);
		basicRang = new CellRangeAddress(1,1,61,61);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Extra Premium");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,59,59);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,61,61);
				basicRang = new CellRangeAddress(1,1,62,62);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Sum Insured");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,60,60);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,62,62);
				basicRang = new CellRangeAddress(1,1,63,63);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Sum reinsured");*/
		cell.setCellValue("Sum Reinsured");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,61,61);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,63,63);
				basicRang = new CellRangeAddress(1,1,64,64);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Monthly PREMIUM");*/
		cell.setCellValue("Monthly Premium");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,62,62);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,64,64);
				basicRang = new CellRangeAddress(1,1,65,65);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Flat Exra rate");*/
		cell.setCellValue("Flat Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,63,63);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,65,65);
				basicRang = new CellRangeAddress(1,1,66,66);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);

		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Percentage Extra rate");*/
		cell.setCellValue("Percentage Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,64,64);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,66,66);
				basicRang = new CellRangeAddress(1,1,67,67);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Extra Premium");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,65,65);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,67,67);
				basicRang = new CellRangeAddress(1,1,68,68);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Sum Insured");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,66,66);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,68,68);
				basicRang = new CellRangeAddress(1,1,69,69);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Sum reinsured");*/
		cell.setCellValue("Sum Reinsured");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,67,67);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,69,69);
				basicRang = new CellRangeAddress(1,1,70,70);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Monthly PREMIUM");*/
		cell.setCellValue("Monthly Premium");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,68,68);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,70,70);
				basicRang = new CellRangeAddress(1,1,71,71);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Flat Exra rate");*/
		cell.setCellValue("Flat Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,69,69);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,71,71);
				basicRang = new CellRangeAddress(1,1,72,72);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);

		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Percentage Extra rate");*/
		cell.setCellValue("Percentage Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,70,70);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,72,72);
				basicRang = new CellRangeAddress(1,1,73,73);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Extra Premium");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,71,71);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,73,73);
				basicRang = new CellRangeAddress(1,1,74,74);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Sum Insured");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,72,72);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,74,74);
				basicRang = new CellRangeAddress(1,1,75,75);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Sum reinsured");*/
		cell.setCellValue("Sum Reinsured");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,73,73);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,75,75);
				basicRang = new CellRangeAddress(1,1,76,76);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Monthly PREMIUM");*/
		cell.setCellValue("Monthly Premium");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,74,74);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,76,76);
				basicRang = new CellRangeAddress(1,1,77,77);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Flat Exra rate");*/
		cell.setCellValue("Flat Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,75,75);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,77,77);
				basicRang = new CellRangeAddress(1,1,78,78);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);

		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Percentage Extra rate");*/
		cell.setCellValue("Percentage Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,76,76);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,78,78);
				basicRang = new CellRangeAddress(1,1,79,79);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Extra Premium");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,77,77);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,79,79);
				basicRang = new CellRangeAddress(1,1,80,80);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
	
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Sum Insured");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,78,78);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,80,80);
				basicRang = new CellRangeAddress(1,1,81,81);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Sum reinsured");*/
		cell.setCellValue("Sum Reinsured");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,79,79);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,81,81);
				basicRang = new CellRangeAddress(1,1,82,82);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Monthly PREMIUM");*/
		/*cell.setCellValue("Monthly Premiium");*///Commented and Modified by Daisy on 05-01-2019
		cell.setCellValue("Monthly Premium");//Commented and Modified by Daisy on 10-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,80,80);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,82,82);
				basicRang = new CellRangeAddress(1,1,83,83);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Flat Exra rate");*/
		cell.setCellValue("Flat Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,81,81);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,83,83);
				basicRang = new CellRangeAddress(1,1,84,84);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);

		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Percentage Extra rate");*/
		cell.setCellValue("Percentage Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,82,82);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,84,84);
				basicRang = new CellRangeAddress(1,1,85,85);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Extra Premium");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,83,83);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,85,85);
				basicRang = new CellRangeAddress(1,1,86,86);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Sum Insured");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
		/*basicRang = new CellRangeAddress(1,1,84,84);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
		//basicRang = new CellRangeAddress(1,1,86,86);
		basicRang = new CellRangeAddress(1,1,87,87);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Sum reinsured");*/
		cell.setCellValue("Sum Reinsured");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
		/*		basicRang = new CellRangeAddress(1,1,85,85);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,87,87);
				basicRang = new CellRangeAddress(1,1,88,88);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Monthly PREMIUM");*/
		cell.setCellValue("Monthly Premium");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,86,86);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,88,88);
				basicRang = new CellRangeAddress(1,1,89,89);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Flat Exra rate");*/
		cell.setCellValue("Flat Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,87,87);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,89,89);
				basicRang = new CellRangeAddress(1,1,90,90);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);

		cell = RootRow.createCell(cellIndex++);
//		cell.setCellValue("Percentage Extra rate");
		cell.setCellValue("Percentage Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,88,88);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,90,90);
				basicRang = new CellRangeAddress(1,1,91,91);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Extra Premium");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,89,89);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,91,91);
				basicRang = new CellRangeAddress(1,1,92,92);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		
		
		/*Added by Daisy on17-12-2018 for KIC - NEW BUSINESS AND NEW RENEWAL*/
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Sum Insured");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,90,90);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,92,92);
				basicRang = new CellRangeAddress(1,1,93,93);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Sum reinsured");*/
		cell.setCellValue("Sum Reinsured");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,91,91);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,93,93);
				basicRang = new CellRangeAddress(1,1,94,94);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Monthly PREMIUM");*/
		cell.setCellValue("Monthly Premium");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,92,92);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,94,94);
				basicRang = new CellRangeAddress(1,1,95,95);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Flat Exra rate");*/
		cell.setCellValue("Flat Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,93,93);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,95,95);
				basicRang = new CellRangeAddress(1,1,96,96);
				/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);

		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Percentage Extra rate");*/
		cell.setCellValue("Percentage Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,94,94);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,96,96);
				basicRang = new CellRangeAddress(1,1,97,97);
				/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Extra Premium");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,95,95);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,97,97);
				basicRang = new CellRangeAddress(1,1,98,98);
				/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		/*End*/
		
		/*Added by Daisy on 18-12-2018 for KIC - NEW BUSINESS AND NEW RENEWAL*/
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Sum Insured");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,96,96);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,98,98);
				basicRang = new CellRangeAddress(1,1,99,99);
				/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Sum reinsured");*/
		cell.setCellValue("Sum Reinsured");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,97,97);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,99,99);
				basicRang = new CellRangeAddress(1,1,100,100);
				/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Monthly PREMIUM");*/
		cell.setCellValue("Monthly Premium");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,98,98);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,100,100);
				basicRang = new CellRangeAddress(1,1,101,101);
				/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Flat Exra rate");*/
		cell.setCellValue("Flat Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,99,99);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,101,101);
				basicRang = new CellRangeAddress(1,1,102,102);
				/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);

		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Percentage Extra rate");*/
		cell.setCellValue("Percentage Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,100,100);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,102,102);
				basicRang = new CellRangeAddress(1,1,103,103);
				/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Extra Premium");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
		/*	basicRang = new CellRangeAddress(1,1,101,101);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
			//basicRang = new CellRangeAddress(1,1,103,103);
			basicRang = new CellRangeAddress(1,1,104,104);
			/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Sum Insured");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,102,102);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,104,104);
				basicRang = new CellRangeAddress(1,1,105,105);
				/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Sum reinsured");*/
		cell.setCellValue("Sum Reinsured");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,103,103);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,105,105);
				basicRang = new CellRangeAddress(1,1,106,106);
				/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Monthly PREMIUM");*/
		cell.setCellValue("Monthly Premium");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,104,104);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,106,106);
				basicRang = new CellRangeAddress(1,1,107,107);
				/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Flat Exra rate");*/
		cell.setCellValue("Flat Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,105,105);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,107,107);
				basicRang = new CellRangeAddress(1,1,108,108);
				/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);

		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Percentage Extra rate");*/
		cell.setCellValue("Percentage Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,106,106);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,108,108);
				basicRang = new CellRangeAddress(1,1,109,109);
				/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Extra Premium");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,107,107);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,109,109);
				basicRang = new CellRangeAddress(1,1,110,110);
				/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Sum Insured");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,108,108);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,110,110);
				basicRang = new CellRangeAddress(1,1,111,111);
				/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Sum reinsured");*/
		cell.setCellValue("Sum Reinsured");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,109,109);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,111,111);
				basicRang = new CellRangeAddress(1,1,112,112);
				/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Monthly PREMIUM");*/
		cell.setCellValue("Monthly Premium");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,110,110);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,112,112);
				basicRang = new CellRangeAddress(1,1,113,113);
				/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Flat Exra rate");*/
		cell.setCellValue("Flat Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,111,111);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,113,113);
				basicRang = new CellRangeAddress(1,1,114,114);
				/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);

		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Percentage Extra rate");*/
		cell.setCellValue("Percentage Extra Rate");//Commented and Modified by Daisy on 05-01-2019
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,112,112);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,114,114);
				basicRang = new CellRangeAddress(1,1,115,115);
				/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Extra Premium");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
				/*basicRang = new CellRangeAddress(1,1,113,113);*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				//basicRang = new CellRangeAddress(1,1,115,115);
				basicRang = new CellRangeAddress(1,1,116,116);
				/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		/*End*/
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Total Additional Premium");
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
		//basicRang = new CellRangeAddress(1,1,90,90);
		//basicRang = new CellRangeAddress(1,1,96,96);
		/*basicRang = new CellRangeAddress(1,1,114,114);//Added by Daisy on 18-12-2018*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
		//basicRang = new CellRangeAddress(1,1,116,116);
		basicRang = new CellRangeAddress(1,1,117,117);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("Total due premium");*/
		cell.setCellValue("Total Due Premium");//Commented and modified by Daisy on 05-01-2019 for KIC
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
		//basicRang = new CellRangeAddress(1,1,97,97);
		/*basicRang = new CellRangeAddress(1,1,115,115);//Added by Daisy on 18-12-2018*/
		/*basicRang = new CellRangeAddress(1,1,115,115);//Added by Daisy on 18-12-2018*/
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
		//basicRang = new CellRangeAddress(1,1,117,117);
		basicRang = new CellRangeAddress(1,1,118,118);
		/*End*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		/*cell.setCellValue("underwriter");*/
		cell.setCellValue("Underwriter");//Commented and modified by Daisy on 05-01-2019 for KIC
		style.setFont(font);
		cell.setCellStyle(style);
		//Added for replacement by Daisy on 05-01-2019 for KIC
		//basicRang = new CellRangeAddress(1,1,98,98);
		/*Modified by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
		//basicRang = new CellRangeAddress(1,1,118,118);
		basicRang = new CellRangeAddress(1,1,119,119);
		/*End*/
		/*basicRang = new CellRangeAddress(1,1,116,116);//Added by Daisy on 18-12-2018*/
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		//Commented and replaced by Daisy on 05-01-2019 for KIC	
		/*Added by Daisy on 03-01-2019
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Date From");
		style.setFont(font);
		cell.setCellStyle(style);
		basicRang = new CellRangeAddress(1,1,117,117);
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		
		cell = RootRow.createCell(cellIndex++);
		cell.setCellValue("Date To");
		style.setFont(font);
		cell.setCellStyle(style);
		basicRang = new CellRangeAddress(1,1,118,118);
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN,basicRang,studentsSheet,workbook);
		End*/
		
		String QUERY= null;
		
		/*QUERY="SELECT PW_IL_NBF_INSURED_NO,PW_IL_NBF_INSURED_NAME,PW_IL_NBF_SEX,PW_IL_NBF_BIRTH_DT,PW_IL_NBF_INSURED_AGE,PW_IL_NBF_PRODUCT"
				+ ",PW_IL_NBF_POL_NO,PW_IL_NBF_POL_DURATION,PW_IL_NBF_CURR,PW_IL_NBF_OCC,PW_IL_NBF_OCC_CLASS,PW_IL_NBF_ISSUE_DT,"
				+ "PW_IL_NBF_SA,PW_IL_NBF_SUM_RE_INSURED,PW_IL_NBF_MON_PREM,PW_IL_NBF_DEATH_FLAT,PW_IL_NBF_DEATH_PRE,PW_IL_NBF_EX_PREM,"
				+ "PW_IL_NBF_ACCB_SA,PW_IL_NBF_ACCB_RI,PW_IL_NBF_ACCB_MON_PREM,PW_IL_NBF_ACCB_FLAT_EX_RATE,PW_IL_NBF_ACCB_PER_EX_RATE,"
				+ "PW_IL_NBF_ACCB_EX_PREM,PW_IL_NBF_PTDACCO_SA,PW_IL_NBF_PTDACCO_RI,PW_IL_NBF_PTDACCO_MON_PREM,PW_IL_NBF_PTDACCO_FLAT_EX_RATE"
				+ ",PW_IL_NBF_PTDACCO_PER_EX_RATE,PW_IL_NBF_PTDACCO_EX_PREM,PW_IL_NBF_PTDSO_SA,PW_IL_NBF_PTDSO_RI,PW_IL_NBF_PTDSO_MON_PREM"
				+ ",PW_IL_NBF_PTDSO_FLAT_EX_RATE,PW_IL_NBF_PTDSO_PER_EX_RATE,PW_IL_NBF_PTDSO_EX_PREMIUM,PW_IL_NBF_PTDA_SA,PW_IL_NBF_PTDA_RI"
				+ ",PW_IL_NBF_PTDA_MON_PREM,PW_IL_NBF_PTDA_FLAT_EX_RATE,PW_IL_NBF_PTDA_PER_EX_RATE,PW_IL_NBF_PTDA_EX_PREM,PW_IL_NBF_PTDS_SA"
				+ ",PW_IL_NBF_PTDS_RI,PW_IL_NBF_PTDS_MON_PREM,PW_IL_NBF_PTDS_FLAT_EX_RATE,PW_IL_NBF_PTDS_PER_EX_RATE,PW_IL_NBF_PTDS_EX_PREM"
				+ ",PW_IL_NBF_PPDA_SA,PW_IL_NBF_PPDA_RI,PW_IL_NBF_PPDA_MON_PREM,PW_IL_NBF_PPDA_FLAT_EX_RATE,PW_IL_NBF_PPDA_PER_EX_RATE,"
				+ "PW_IL_NBF_PPDA_EX_PREM,PW_IL_NBF_PPDS_SA,PW_IL_NBF_PPDS_RI,PW_IL_NBF_PPDS_MON_PREM,PW_IL_NBF_PPDS_FLAT_EX_RATE,"
				+ "PW_IL_NBF_PPDS_PER_EX_RATE,PW_IL_NBF_PPDS_EX_PREMIUM,PW_IL_NBF_TTDA_SA,PW_IL_NBF_TTDA_RI,PW_IL_NBF_TTDA_MON_PREM,"
				+ "PW_IL_NBF_TTDA_FLAT_EX_RATE,PW_IL_NBF_TTDA_PER_EX_RATE,PW_IL_NBF_TTDA_EX_PREMIUM,PW_IL_NBF_MED_SA,PW_IL_NBF_MED_RI,"
				+ "PW_IL_NBF_MED_MON_PREM,PW_IL_NBF_MED_FLAT_EX_RATE,PW_IL_NBF_MED_PER_EX_RATE,PW_IL_NBF_MED_EX_PREMIUM,PW_IL_NBF_PWR_SA,"
				+ "PW_IL_NBF_PWR_RI,PW_IL_NBF_PWR_MON_PREM,PW_IL_NBF_PWR_FLAT_EX_RATE,PW_IL_NBF_PWR_PER_EX_RATE,PW_IL_NBF_PWR_EX_PREMIUM,"
				+ "PW_IL_NBF_PWRPTD_SA,PW_IL_NBF_PWRPTD_RI,PW_IL_NBF_PWRPTD_MON_PREM,PW_IL_NBF_PWRPTD_FLAT_EX_RATE,PW_IL_NBF_PWRPTD_PER_EX_RATE,"
				+ "PW_IL_NBF_PWRPTD_EX_PREM,PW_IL_NBF_WOP_SA,PW_IL_NBF_WOP_RI,PW_IL_NBF_WOP_MON_PREM,PW_IL_NBF_WOP_FLAT_EX_RATE,"
				+ "PW_IL_NBF_WOP_PER_EX_RATE,PW_IL_NBF_WOP_EX_PREM,PW_IL_NBF_TOT_ADDL_PREM,PW_IL_NBF_TOL_DUE_PREM,PW_IL_NBF_UW,PW_IL_NBF_WOPDD_SA,"
				+ "PW_IL_NBF_WOPDD_RI,PW_IL_NBF_WOPDD_MON_PREM,PW_IL_NBF_WOPDD_FLAT_EX_RATE,PW_IL_NBF_WOPDD_PER_EX_RATE PW_IL_NBF_WOPDD_EX_PREM"
				+ " FROM PW_IL_NEW_BUSINESS_FYP WHERE PW_IL_NBF_SEQ_OUT=? ";*/
		
		/*Modified and added by Daisy on 17-12-2018 KIC - NEW BUSINESS AND NEW RENEWAL*/
		/*QUERY="SELECT PW_IL_NBF_INSURED_NO, PW_IL_NBF_INSURED_NAME, PW_IL_NBF_SEX, PW_IL_NBF_BIRTH_DT, PW_IL_NBF_INSURED_AGE, PW_IL_NBF_PRODUCT, "
				+ "PW_IL_NBF_POL_NO, PW_IL_NBF_POL_DURATION, PW_IL_NBF_CURR, PW_IL_NBF_OCC, PW_IL_NBF_OCC_CLASS, PW_IL_NBF_ISSUE_DT, PW_IL_NBF_SA,"
				+ "PW_IL_NBF_SUM_RE_INSURED,PW_IL_NBF_MON_PREM,PW_IL_NBF_DEATH_FLAT, PW_IL_NBF_DEATH_PRE, PW_IL_NBF_EX_PREM, PW_IL_NBF_ACCB_SA,"
				+ "PW_IL_NBF_ACCB_RI, PW_IL_NBF_ACCB_MON_PREM, PW_IL_NBF_ACCB_FLAT_EX_RATE, PW_IL_NBF_ACCB_PER_EX_RATE, PW_IL_NBF_ACCB_EX_PREM, "
				+ "PW_IL_NBF_PTDACCO_SA, PW_IL_NBF_PTDACCO_RI, PW_IL_NBF_PTDACCO_MON_PREM, PW_IL_NBF_PTDACCO_FLAT_EX_RATE, PW_IL_NBF_PTDACCO_PER_EX_RATE,"
				+ "PW_IL_NBF_PTDACCO_EX_PREM, PW_IL_NBF_PTDSO_SA, PW_IL_NBF_PTDSO_RI, PW_IL_NBF_PTDSO_MON_PREM, PW_IL_NBF_PTDSO_FLAT_EX_RATE,"
				+ "PW_IL_NBF_PTDSO_PER_EX_RATE, PW_IL_NBF_PTDSO_EX_PREMIUM, PW_IL_NBF_PTDA_SA, PW_IL_NBF_PTDA_RI, PW_IL_NBF_PTDA_MON_PREM, PW_IL_NBF_PTDA_FLAT_EX_RATE,"
				+ "PW_IL_NBF_PTDA_PER_EX_RATE, PW_IL_NBF_PTDA_EX_PREM, PW_IL_NBF_PTDS_SA, PW_IL_NBF_PTDS_RI, PW_IL_NBF_PTDS_MON_PREM, PW_IL_NBF_PTDS_FLAT_EX_RATE,"
				+ "PW_IL_NBF_PTDS_PER_EX_RATE, PW_IL_NBF_PTDS_EX_PREM, PW_IL_NBF_PPDA_SA, PW_IL_NBF_PPDA_RI, PW_IL_NBF_PPDA_MON_PREM, PW_IL_NBF_PPDA_FLAT_EX_RATE,"
				+ "PW_IL_NBF_PPDA_PER_EX_RATE, PW_IL_NBF_PPDA_EX_PREM, PW_IL_NBF_PPDS_SA, PW_IL_NBF_PPDS_RI, PW_IL_NBF_PPDS_MON_PREM, PW_IL_NBF_PPDS_FLAT_EX_RATE,"
				+ "PW_IL_NBF_PPDS_PER_EX_RATE, PW_IL_NBF_PPDS_EX_PREMIUM, PW_IL_NBF_TTDA_SA, PW_IL_NBF_TTDA_RI, PW_IL_NBF_TTDA_MON_PREM, PW_IL_NBF_TTDA_FLAT_EX_RATE,"
				+ "PW_IL_NBF_TTDA_PER_EX_RATE, PW_IL_NBF_TTDA_EX_PREMIUM, PW_IL_NBF_MED_SA, PW_IL_NBF_MED_RI, PW_IL_NBF_MED_MON_PREM, PW_IL_NBF_MED_FLAT_EX_RATE,"
				+ "PW_IL_NBF_MED_PER_EX_RATE, PW_IL_NBF_MED_EX_PREMIUM, PW_IL_NBF_PWR_SA, PW_IL_NBF_PWR_RI, PW_IL_NBF_PWR_MON_PREM, PW_IL_NBF_PWR_FLAT_EX_RATE,"
				+ "PW_IL_NBF_PWR_PER_EX_RATE, PW_IL_NBF_PWR_EX_PREMIUM, PW_IL_NBF_PWRPTD_SA, PW_IL_NBF_PWRPTD_RI, PW_IL_NBF_PWRPTD_MON_PREM, PW_IL_NBF_PWRPTD_FLAT_EX_RATE,"
				+ "PW_IL_NBF_PWRPTD_PER_EX_RATE, PW_IL_NBF_PWRPTD_EX_PREM, PW_IL_NBF_WOP_SA, PW_IL_NBF_WOP_RI, PW_IL_NBF_WOP_MON_PREM, PW_IL_NBF_WOP_FLAT_EX_RATE,"
				+ "PW_IL_NBF_WOP_PER_EX_RATE, PW_IL_NBF_WOP_EX_PREM, PW_IL_NBF_WOPDD_SA, PW_IL_NBF_WOPDD_RI, PW_IL_NBF_WOPDD_MON_PREM, PW_IL_NBF_WOPDD_FLAT_EX_RATE,"
				+ "PW_IL_NBF_WOPDD_PER_EX_RATE, PW_IL_NBF_WOPDD_EX_PREM, PW_IL_NBF_ALI_SA,PW_IL_NBF_ALI_RI,PW_IL_NBF_ALI_MON_PREM,PW_IL_NBF_ALI_FLAT_EX_RATE,PW_IL_NBF_ALI_PER_EX_RATE,"
				+ "PW_IL_NBF_ALI_EX_PREM,PW_IL_NBF_CI11S_SA,PW_IL_NBF_CI11S_RI,PW_IL_NBF_CI11S_MON_PREM,PW_IL_NBF_CI11S_FLAT_EX_RATE,PW_IL_NBF_CI11S_PER_EX_RATE,"
				+ "PW_IL_NBF_CI11S_EX_PREM,PW_IL_NBF_CI38S_SA,PW_IL_NBF_CI38S_RI,PW_IL_NBF_CI38S_MON_PREM,PW_IL_NBF_CI38S_FLAT_EX_RATE,PW_IL_NBF_CI38S_PER_EX_RATE,"
				+ "PW_IL_NBF_CI38S_EX_PREM, PW_IL_NBF_TOT_ADDL_PREM, PW_IL_NBF_TOL_DUE_PREM, PW_IL_NBF_UW FROM PW_IL_NEW_BUSINESS_FYP WHERE PW_IL_NBF_SEQ_OUT = ?";*/
		
		
		/*Commentted&Modified by saritha on 03-04-2019 for New Business&Renewal Business NB & Add Medical class (Khazina both product)*/
		
		/*QUERY="SELECT PW_IL_NBF_INSURED_NO, PW_IL_NBF_INSURED_NAME, PW_IL_NBF_SEX, PW_IL_NBF_BIRTH_DT, PW_IL_NBF_INSURED_AGE, PW_IL_NBF_PRODUCT, "
				+ "PW_IL_NBF_POL_NO, PW_IL_NBF_POL_DURATION, PW_IL_NBF_CURR, PW_IL_NBF_OCC, PW_IL_NBF_OCC_CLASS, PW_IL_NBF_ISSUE_DT, PW_IL_NBF_SA,"
				+ "PW_IL_NBF_SUM_RE_INSURED,PW_IL_NBF_MON_PREM,PW_IL_NBF_DEATH_FLAT, PW_IL_NBF_DEATH_PRE, PW_IL_NBF_EX_PREM, PW_IL_NBF_ACCB_SA,"
				+ "PW_IL_NBF_ACCB_RI, PW_IL_NBF_ACCB_MON_PREM, PW_IL_NBF_ACCB_FLAT_EX_RATE, PW_IL_NBF_ACCB_PER_EX_RATE, PW_IL_NBF_ACCB_EX_PREM, "
				+ "PW_IL_NBF_PTDACCO_SA, PW_IL_NBF_PTDACCO_RI, PW_IL_NBF_PTDACCO_MON_PREM, PW_IL_NBF_PTDACCO_FLAT_EX_RATE, PW_IL_NBF_PTDACCO_PER_EX_RATE,"
				+ "PW_IL_NBF_PTDACCO_EX_PREM, PW_IL_NBF_PTDSO_SA, PW_IL_NBF_PTDSO_RI, PW_IL_NBF_PTDSO_MON_PREM, PW_IL_NBF_PTDSO_FLAT_EX_RATE,"
				+ "PW_IL_NBF_PTDSO_PER_EX_RATE, PW_IL_NBF_PTDSO_EX_PREMIUM, PW_IL_NBF_PTDA_SA, PW_IL_NBF_PTDA_RI, PW_IL_NBF_PTDA_MON_PREM, PW_IL_NBF_PTDA_FLAT_EX_RATE,"
				+ "PW_IL_NBF_PTDA_PER_EX_RATE, PW_IL_NBF_PTDA_EX_PREM, PW_IL_NBF_PTDS_SA, PW_IL_NBF_PTDS_RI, PW_IL_NBF_PTDS_MON_PREM, PW_IL_NBF_PTDS_FLAT_EX_RATE,"
				+ "PW_IL_NBF_PTDS_PER_EX_RATE, PW_IL_NBF_PTDS_EX_PREM, PW_IL_NBF_PPDA_SA, PW_IL_NBF_PPDA_RI, PW_IL_NBF_PPDA_MON_PREM, PW_IL_NBF_PPDA_FLAT_EX_RATE,"
				+ "PW_IL_NBF_PPDA_PER_EX_RATE, PW_IL_NBF_PPDA_EX_PREM, PW_IL_NBF_PPDS_SA, PW_IL_NBF_PPDS_RI, PW_IL_NBF_PPDS_MON_PREM, PW_IL_NBF_PPDS_FLAT_EX_RATE,"
				+ "PW_IL_NBF_PPDS_PER_EX_RATE, PW_IL_NBF_PPDS_EX_PREMIUM, PW_IL_NBF_TTDA_SA, PW_IL_NBF_TTDA_RI, PW_IL_NBF_TTDA_MON_PREM, PW_IL_NBF_TTDA_FLAT_EX_RATE,"
				+ "PW_IL_NBF_TTDA_PER_EX_RATE, PW_IL_NBF_TTDA_EX_PREMIUM, PW_IL_NBF_MED_SA, PW_IL_NBF_MED_RI, PW_IL_NBF_MED_MON_PREM, PW_IL_NBF_MED_FLAT_EX_RATE,"
				+ "PW_IL_NBF_MED_PER_EX_RATE, PW_IL_NBF_MED_EX_PREMIUM, PW_IL_NBF_PWR_SA, PW_IL_NBF_PWR_RI, PW_IL_NBF_PWR_MON_PREM, PW_IL_NBF_PWR_FLAT_EX_RATE,"
				+ "PW_IL_NBF_PWR_PER_EX_RATE, PW_IL_NBF_PWR_EX_PREMIUM, PW_IL_NBF_PWRPTD_SA, PW_IL_NBF_PWRPTD_RI, PW_IL_NBF_PWRPTD_MON_PREM, PW_IL_NBF_PWRPTD_FLAT_EX_RATE,"
				+ "PW_IL_NBF_PWRPTD_PER_EX_RATE, PW_IL_NBF_PWRPTD_EX_PREM, PW_IL_NBF_WOP_SA, PW_IL_NBF_WOP_RI, PW_IL_NBF_WOP_MON_PREM, PW_IL_NBF_WOP_FLAT_EX_RATE,"
				+ "PW_IL_NBF_WOP_PER_EX_RATE, PW_IL_NBF_WOP_EX_PREM, PW_IL_NBF_WOPDD_SA, PW_IL_NBF_WOPDD_RI, PW_IL_NBF_WOPDD_MON_PREM, PW_IL_NBF_WOPDD_FLAT_EX_RATE,"
				+ "PW_IL_NBF_WOPDD_PER_EX_RATE, PW_IL_NBF_WOPDD_EX_PREM, PW_IL_NBF_ALI_SA,PW_IL_NBF_ALI_RI,PW_IL_NBF_ALI_MON_PREM,PW_IL_NBF_ALI_FLAT_EX_RATE,PW_IL_NBF_ALI_PER_EX_RATE,"
				+ "PW_IL_NBF_ALI_EX_PREM,PW_IL_NBF_CI11S_SA,PW_IL_NBF_CI11S_RI,PW_IL_NBF_CI11S_MON_PREM,PW_IL_NBF_CI11S_FLAT_EX_RATE,PW_IL_NBF_CI11S_PER_EX_RATE,"
				+ "PW_IL_NBF_CI11S_EX_PREM,PW_IL_NBF_CI38S_SA,PW_IL_NBF_CI38S_RI,PW_IL_NBF_CI38S_MON_PREM,PW_IL_NBF_CI38S_FLAT_EX_RATE,PW_IL_NBF_CI38S_PER_EX_RATE,"
				+ "PW_IL_NBF_CI38S_EX_PREM, PW_IL_NBF_TOT_ADDL_PREM, PW_IL_NBF_TOL_DUE_PREM, PW_IL_NBF_UW,PW_IL_NBF_DATE_FM,PW_IL_NBF_DATE_TO"
				+ " FROM PW_IL_NEW_BUSINESS_FYP WHERE PW_IL_NBF_SEQ_OUT = ?";*/
		/*End*/
		
		QUERY="SELECT PW_IL_NBF_INSURED_NO, PW_IL_NBF_INSURED_NAME, PW_IL_NBF_SEX, PW_IL_NBF_BIRTH_DT, PW_IL_NBF_INSURED_AGE, PW_IL_NBF_PRODUCT, "
				+ "PW_IL_NBF_POL_NO, PW_IL_NBF_POL_DURATION, PW_IL_NBF_CURR, PW_IL_NBF_OCC, PW_IL_NBF_OCC_CLASS, PW_IL_NBF_ISSUE_DT, PW_IL_NBF_SA,"
				+ "PW_IL_NBF_SUM_RE_INSURED,PW_IL_NBF_MON_PREM,PW_IL_NBF_DEATH_FLAT, PW_IL_NBF_DEATH_PRE, PW_IL_NBF_EX_PREM, PW_IL_NBF_ACCB_SA,"
				+ "PW_IL_NBF_ACCB_RI, PW_IL_NBF_ACCB_MON_PREM, PW_IL_NBF_ACCB_FLAT_EX_RATE, PW_IL_NBF_ACCB_PER_EX_RATE, PW_IL_NBF_ACCB_EX_PREM, "
				+ "PW_IL_NBF_PTDACCO_SA, PW_IL_NBF_PTDACCO_RI, PW_IL_NBF_PTDACCO_MON_PREM, PW_IL_NBF_PTDACCO_FLAT_EX_RATE, PW_IL_NBF_PTDACCO_PER_EX_RATE,"
				+ "PW_IL_NBF_PTDACCO_EX_PREM, PW_IL_NBF_PTDSO_SA, PW_IL_NBF_PTDSO_RI, PW_IL_NBF_PTDSO_MON_PREM, PW_IL_NBF_PTDSO_FLAT_EX_RATE,"
				+ "PW_IL_NBF_PTDSO_PER_EX_RATE, PW_IL_NBF_PTDSO_EX_PREMIUM, PW_IL_NBF_PTDA_SA, PW_IL_NBF_PTDA_RI, PW_IL_NBF_PTDA_MON_PREM, PW_IL_NBF_PTDA_FLAT_EX_RATE,"
				+ "PW_IL_NBF_PTDA_PER_EX_RATE, PW_IL_NBF_PTDA_EX_PREM, PW_IL_NBF_PTDS_SA, PW_IL_NBF_PTDS_RI, PW_IL_NBF_PTDS_MON_PREM, PW_IL_NBF_PTDS_FLAT_EX_RATE,"
				+ "PW_IL_NBF_PTDS_PER_EX_RATE, PW_IL_NBF_PTDS_EX_PREM, PW_IL_NBF_PPDA_SA, PW_IL_NBF_PPDA_RI, PW_IL_NBF_PPDA_MON_PREM, PW_IL_NBF_PPDA_FLAT_EX_RATE,"
				+ "PW_IL_NBF_PPDA_PER_EX_RATE, PW_IL_NBF_PPDA_EX_PREM, PW_IL_NBF_PPDS_SA, PW_IL_NBF_PPDS_RI, PW_IL_NBF_PPDS_MON_PREM, PW_IL_NBF_PPDS_FLAT_EX_RATE,"
				+ "PW_IL_NBF_PPDS_PER_EX_RATE, PW_IL_NBF_PPDS_EX_PREMIUM, PW_IL_NBF_TTDA_SA, PW_IL_NBF_TTDA_RI, PW_IL_NBF_TTDA_MON_PREM, PW_IL_NBF_TTDA_FLAT_EX_RATE,"
				+ "PW_IL_NBF_TTDA_PER_EX_RATE, PW_IL_NBF_TTDA_EX_PREMIUM, PW_IL_NBF_MED_SA, PW_IL_NBF_MED_RI, PW_IL_NBF_MED_MON_PREM, PW_IL_NBF_MED_FLAT_EX_RATE,"
				+ "PW_IL_NBF_MED_PER_EX_RATE, PW_IL_NBF_MED_EX_PREMIUM, PW_IL_NBF_PWR_SA, PW_IL_NBF_PWR_RI, PW_IL_NBF_PWR_MON_PREM, PW_IL_NBF_PWR_FLAT_EX_RATE,"
				+ "PW_IL_NBF_PWR_PER_EX_RATE, PW_IL_NBF_PWR_EX_PREMIUM, PW_IL_NBF_PWRPTD_SA, PW_IL_NBF_PWRPTD_RI, PW_IL_NBF_PWRPTD_MON_PREM, PW_IL_NBF_PWRPTD_FLAT_EX_RATE,"
				+ "PW_IL_NBF_PWRPTD_PER_EX_RATE, PW_IL_NBF_PWRPTD_EX_PREM, PW_IL_NBF_WOP_SA, PW_IL_NBF_WOP_RI, PW_IL_NBF_WOP_MON_PREM, PW_IL_NBF_WOP_FLAT_EX_RATE,"
				+ "PW_IL_NBF_WOP_PER_EX_RATE, PW_IL_NBF_WOP_EX_PREM, PW_IL_NBF_WOPDD_SA, PW_IL_NBF_WOPDD_RI, PW_IL_NBF_WOPDD_MON_PREM, PW_IL_NBF_WOPDD_FLAT_EX_RATE,"
				+ "PW_IL_NBF_WOPDD_PER_EX_RATE, PW_IL_NBF_WOPDD_EX_PREM, PW_IL_NBF_ALI_SA,PW_IL_NBF_ALI_RI,PW_IL_NBF_ALI_MON_PREM,PW_IL_NBF_ALI_FLAT_EX_RATE,PW_IL_NBF_ALI_PER_EX_RATE,"
				+ "PW_IL_NBF_ALI_EX_PREM,PW_IL_NBF_CI11S_SA,PW_IL_NBF_CI11S_RI,PW_IL_NBF_CI11S_MON_PREM,PW_IL_NBF_CI11S_FLAT_EX_RATE,PW_IL_NBF_CI11S_PER_EX_RATE,"
				+ "PW_IL_NBF_CI11S_EX_PREM,PW_IL_NBF_CI38S_SA,PW_IL_NBF_CI38S_RI,PW_IL_NBF_CI38S_MON_PREM,PW_IL_NBF_CI38S_FLAT_EX_RATE,PW_IL_NBF_CI38S_PER_EX_RATE,"
				+ "PW_IL_NBF_CI38S_EX_PREM, PW_IL_NBF_TOT_ADDL_PREM, PW_IL_NBF_TOL_DUE_PREM, PW_IL_NBF_UW,PW_IL_NBF_DATE_FM,PW_IL_NBF_DATE_TO,PW_IL_NBF_MED_CLASS"
				+ " FROM PW_IL_NEW_BUSINESS_FYP WHERE PW_IL_NBF_SEQ_OUT = ?";
		
		
		try{			rs1 =  new CRUDHandler().executeSelectStatement(QUERY,con,new Object[] {sequence_number});
			System.out.println("***********sequence_number******>"+sequence_number);
							
			/*Added by Janani on 17.01.2018 for ZBLIFE-1472007*/
		/*	style = workbook.createCellStyle();*/
			//font = workbook.createFont();
			
			/*End of ZBLIFE-1472007*/
			
			Font String_font = workbook.createFont();
			String_font.setFontHeightInPoints(Short.parseShort("11"));
			String_font.setFontName("Calibri");
			
            CellStyle String_style = null;
			String_style = workbook.createCellStyle();
			String_style.setFont(String_font);
			String_style.setAlignment(CellStyle.ALIGN_LEFT);
			
			
		/*	Font Value_font = workbook.createFont();
			Value_font.setFontHeightInPoints(Short.parseShort("11"));
			Value_font.setFontName("Calibri");*/
			
			
            CellStyle Value_style = null;
            Value_style = workbook.createCellStyle();
            Value_style.setFont(String_font);
            Value_style.setAlignment(CellStyle.ALIGN_RIGHT);
            //Value_style.setDataFormat(hssfDataFormat.getFormat("#0.00"));
            /*Added by Sivarajan on 11-02-2019 for two digits change into three digits*/
            Value_style.setDataFormat(hssfDataFormat.getFormat("#,##0.000"));//Commented and Added by Daisy on 20-12-2018
			/*End*/
			
            
            int Cell_RANGE_X=0;
			int Cell_RANGE_Y=0;
			int Cell_NUMBER=0;
			/*Added by Daisy for date format on 03-01-2019*/
			String dueDate="";
			String dueDate1="";
            /*End*/
            
			
			while(rs1.next()){

				Row RootRow_ONE = studentsSheet.createRow(rowIndex++);
				
				cellIndex=0;
				
				/*Replaced and Added by Daisy on 05-01-2019*/
				cell = RootRow_ONE.createCell(cellIndex++);
				dueDate=new SimpleDateFormat("dd/MM/yyyy").format(rs1.getDate("PW_IL_NBF_DATE_FM")).toString().toUpperCase();
				cell.setCellValue(dueDate);
				cell.setCellStyle(String_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				dueDate1=new SimpleDateFormat("dd/MM/yyyy").format(rs1.getDate("PW_IL_NBF_DATE_TO")).toString().toUpperCase();
				cell.setCellValue(dueDate1);
				cell.setCellStyle(String_style);
				/*End*/
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getString("PW_IL_NBF_INSURED_NO"));
				cell.setCellStyle(String_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getString("PW_IL_NBF_INSURED_NAME"));
				cell.setCellStyle(String_style);
			
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getString("PW_IL_NBF_SEX"));
				cell.setCellStyle(String_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getString("PW_IL_NBF_BIRTH_DT"));
				cell.setCellStyle(String_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_INSURED_AGE"));
				cell.setCellStyle(String_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getString("PW_IL_NBF_PRODUCT"));
				cell.setCellStyle(String_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getString("PW_IL_NBF_POL_NO"));
				cell.setCellStyle(String_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_POL_DURATION"));
				cell.setCellStyle(String_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getString("PW_IL_NBF_CURR"));
				cell.setCellStyle(String_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getString("PW_IL_NBF_OCC"));
				cell.setCellStyle(String_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getString("PW_IL_NBF_OCC_CLASS"));
				cell.setCellStyle(String_style);
				
				/*Newly Added by saritha on 03-04-2019 for New Business&Renewal Business, Add Medical class (Khazina both product)*/
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getString("PW_IL_NBF_MED_CLASS"));
				cell.setCellStyle(String_style);
				
				/*End*/
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getString("PW_IL_NBF_ISSUE_DT"));
				cell.setCellStyle(String_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_SA"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_SUM_RE_INSURED"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				//cell.setCellValue(rs1.getInt("PW_IL_NBF_MON_PREM"));Commented and added by Saritha on 19-12-2018
				cell.setCellValue(rs1.getDouble("PW_IL_NBF_MON_PREM"));
				cell.setCellStyle(Value_style);
				
				
				cell = RootRow_ONE.createCell(cellIndex++);
				//cell.setCellValue(rs1.getString("PW_IL_NBF_DEATH_FLAT"));Commented and Added by Daisy for Decimal points on 08-04-2019
				cell.setCellValue(rs1.getDouble("PW_IL_NBF_DEATH_FLAT"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				//cell.setCellValue(rs1.getInt("PW_IL_NBF_DEATH_PRE"));Commented and Added by Daisy for Decimal points on 08-04-2019
				cell.setCellValue(rs1.getDouble("PW_IL_NBF_DEATH_PRE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_EX_PREM"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_ACCB_SA"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_ACCB_RI"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				/*
				 * modified by Ameen on 24-12-2018
				 * cell.setCellValue(rs1.getInt("PW_IL_NBF_ACCB_MON_PREM"));*/
				cell.setCellValue(rs1.getDouble("PW_IL_NBF_ACCB_MON_PREM"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_ACCB_FLAT_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_ACCB_PER_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_ACCB_EX_PREM"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PTDACCO_SA"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PTDACCO_RI"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				/*
				 * modified by Ameen on 24-12-2018
				 * cell.setCellValue(rs1.getInt("PW_IL_NBF_PTDACCO_MON_PREM"));*/
				cell.setCellValue(rs1.getDouble("PW_IL_NBF_PTDACCO_MON_PREM"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PTDACCO_FLAT_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PTDACCO_PER_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PTDACCO_EX_PREM"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PTDSO_SA"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PTDSO_RI"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				/*
				 * modified by Ameen on 24-12-2018
				 * cell.setCellValue(rs1.getInt("PW_IL_NBF_PTDSO_MON_PREM"));*/
				cell.setCellValue(rs1.getDouble("PW_IL_NBF_PTDSO_MON_PREM"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PTDSO_FLAT_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PTDSO_PER_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PTDSO_EX_PREMIUM"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PTDA_SA"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PTDA_RI"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				/*
				 * modified by Ameen on 24-12-2018
				 * cell.setCellValue(rs1.getInt("PW_IL_NBF_PTDA_MON_PREM"));*/
				cell.setCellValue(rs1.getDouble("PW_IL_NBF_PTDA_MON_PREM"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PTDA_FLAT_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PTDA_PER_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PTDA_EX_PREM"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PTDS_SA"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PTDS_RI"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				/*
				 * modified by Ameen on 24-12-2018
				 * cell.setCellValue(rs1.getInt("PW_IL_NBF_PTDS_MON_PREM"));*/
				cell.setCellValue(rs1.getDouble("PW_IL_NBF_PTDS_MON_PREM"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PTDS_FLAT_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PTDS_PER_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PTDS_EX_PREM"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PPDA_SA"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PPDA_RI"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				/*
				 * modified by Ameen on 24-12-2018
				 * cell.setCellValue(rs1.getInt("PW_IL_NBF_PPDA_MON_PREM"));*/
				cell.setCellValue(rs1.getDouble("PW_IL_NBF_PPDA_MON_PREM"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PPDA_FLAT_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PPDA_PER_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PPDA_EX_PREM"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PPDS_SA"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PPDS_RI"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				/*
				 * modified by Ameen on 24-12-2018
				 * cell.setCellValue(rs1.getInt("PW_IL_NBF_PPDS_MON_PREM"));*/
				cell.setCellValue(rs1.getDouble("PW_IL_NBF_PPDS_MON_PREM"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PPDS_FLAT_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PPDS_PER_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PPDS_EX_PREMIUM"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_TTDA_SA"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_TTDA_RI"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				/*
				 * modified by Ameen on 24-12-2018
				 * cell.setCellValue(rs1.getInt("PW_IL_NBF_TTDA_MON_PREM"));*/
				cell.setCellValue(rs1.getDouble("PW_IL_NBF_TTDA_MON_PREM"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_TTDA_FLAT_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_TTDA_PER_EX_RATE"));
				cell.setCellStyle(Value_style);
				

				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_TTDA_EX_PREMIUM"));
				cell.setCellStyle(Value_style);
				

				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_MED_SA"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_MED_RI"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				/*
				 * modified by Ameen on 24-12-2018
				 * cell.setCellValue(rs1.getInt("PW_IL_NBF_MED_MON_PREM"));*/
				cell.setCellValue(rs1.getDouble("PW_IL_NBF_MED_MON_PREM"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_MED_FLAT_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_MED_PER_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_MED_EX_PREMIUM"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PWR_SA"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PWR_RI"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				/*
				 * modified by Ameen on 24-12-2018
				 * cell.setCellValue(rs1.getInt("PW_IL_NBF_PWR_MON_PREM"));*/
				cell.setCellValue(rs1.getDouble("PW_IL_NBF_PWR_MON_PREM"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PWR_FLAT_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PWR_PER_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PWR_EX_PREMIUM"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PWRPTD_SA"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PWRPTD_RI"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				/*
				 * modified by Ameen on 24-12-2018
				 * cell.setCellValue(rs1.getInt("PW_IL_NBF_PWRPTD_MON_PREM"));*/
				cell.setCellValue(rs1.getDouble("PW_IL_NBF_PWRPTD_MON_PREM"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PWRPTD_FLAT_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PWRPTD_PER_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_PWRPTD_EX_PREM"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_WOP_SA"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_WOP_RI"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				/*
				 * modified by Ameen on 24-12-2018
				 * cell.setCellValue(rs1.getInt("PW_IL_NBF_WOP_MON_PREM"));*/
				cell.setCellValue(rs1.getDouble("PW_IL_NBF_WOP_MON_PREM"));
				cell.setCellStyle(Value_style);
				

				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_WOP_FLAT_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_WOP_PER_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_WOP_EX_PREM"));
				cell.setCellStyle(Value_style);
				
				
				/*Added by daisy on 17-12-2018 KIC - NEW BUSINESS AND NEW RENEWAL*/
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_WOPDD_SA"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_WOPDD_RI"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				/*
				 * modified by Ameen on 24-12-2018
				 * cell.setCellValue(rs1.getInt("PW_IL_NBF_WOPDD_MON_PREM"));*/
				cell.setCellValue(rs1.getDouble("PW_IL_NBF_WOPDD_MON_PREM"));
				cell.setCellStyle(Value_style);
				

				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_WOPDD_FLAT_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_WOPDD_PER_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_WOPDD_EX_PREM"));
				cell.setCellStyle(Value_style);
		        /*End*/
		
				/*Added by daisy on 18-12-2018 KIC - NEW BUSINESS AND NEW RENEWAL*/
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_ALI_SA"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_ALI_RI"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				/*
				 * modified by Ameen on 24-12-2018
				 * cell.setCellValue(rs1.getInt("PW_IL_NBF_ALI_MON_PREM"));*/
				cell.setCellValue(rs1.getDouble("PW_IL_NBF_ALI_MON_PREM"));
				cell.setCellStyle(Value_style);
				

				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_ALI_FLAT_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_ALI_PER_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_ALI_EX_PREM"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_CI11S_SA"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_CI11S_RI"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				/*
				 * modified by Ameen on 24-12-2018
				 * cell.setCellValue(rs1.getInt("PW_IL_NBF_CI11S_MON_PREM"));*/
				cell.setCellValue(rs1.getDouble("PW_IL_NBF_CI11S_MON_PREM"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_CI11S_FLAT_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_CI11S_PER_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_CI11S_EX_PREM"));
				cell.setCellStyle(Value_style); 
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_CI38S_SA"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_CI38S_RI"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				/*
				 * modified by Ameen on 24-12-2018
				 * cell.setCellValue(rs1.getInt("PW_IL_NBF_CI38S_MON_PREM"));*/
				cell.setCellValue(rs1.getDouble("PW_IL_NBF_CI38S_MON_PREM"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_CI38S_FLAT_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_CI38S_PER_EX_RATE"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_CI38S_EX_PREM"));
				cell.setCellStyle(Value_style);
				/*End*/
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getInt("PW_IL_NBF_TOT_ADDL_PREM"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				//Commented by daisy date:20-12-2018 cell.setCellValue(rs1.getInt("PW_IL_NBF_TOL_DUE_PREM"));
				cell.setCellValue(rs1.getDouble("PW_IL_NBF_TOL_DUE_PREM"));
				cell.setCellStyle(Value_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				cell.setCellValue(rs1.getString("PW_IL_NBF_UW"));
				cell.setCellStyle(String_style);
				/*
				Added by Daisy on 03-01-2019
				cell = RootRow_ONE.createCell(cellIndex++);
				dueDate=new SimpleDateFormat("dd/MM/yyyy").format(rs1.getDate("PW_IL_NBF_DATE_FM")).toString().toUpperCase();
				cell.setCellValue(dueDate);
				cell.setCellStyle(String_style);
				
				cell = RootRow_ONE.createCell(cellIndex++);
				dueDate1=new SimpleDateFormat("dd/MM/yyyy").format(rs1.getDate("PW_IL_NBF_DATE_TO")).toString().toUpperCase();
				cell.setCellValue(dueDate1);
				cell.setCellStyle(String_style);
				End
*/
				
			}

			System.out.println("cellindex"+cellIndex);
			for(int a = 0 ;a<cellIndex;a++){
				studentsSheet.autoSizeColumn(a);
			}
			
			
			}  
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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



    /*end*/

}
