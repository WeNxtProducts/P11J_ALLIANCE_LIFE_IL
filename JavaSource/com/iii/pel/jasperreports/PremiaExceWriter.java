package com.iii.pel.jasperreports;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;

import com.iii.apps.persistence.CRUDHandler;

public class PremiaExceWriter {

	public String riBorderauxFileName(String fileName){
		 
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
	
public String writeRIBordexExcel(ArrayList<String> list1,Connection con,String fileName) throws ParseException{
		
		//String excelGenPath = "D:/testWriteStudents.xls";
		String excelGenPath = "";
    	Connection conn = null;
    	ResultSet rs = null;
    	String RIBordeauxFileName = riBorderauxFileName(fileName);
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
	

}
