package com.iii.pel.forms.PILP017;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PW_IL_UPLOAD_FILE_DTLS_HELPER{

	public static void readExcelFile(String fileName) throws Exception
	{
		List cellDataList = new ArrayList();
		String insertQry=null;
		try {
			List<Object> rowValue = null;
			HSSFCell cell=null;
			Object obj = "";
			FileInputStream fileInputStream = new FileInputStream(fileName);
			POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
			HSSFWorkbook workBook = new HSSFWorkbook(fsFileSystem);
			HSSFSheet hssfSheet = workBook.getSheetAt(0);
			Iterator rowIterator = hssfSheet.rowIterator();
			while (rowIterator.hasNext()) {
				HSSFRow hssfRow = (HSSFRow) rowIterator.next();
			//	System.out.println("hssfRow.INITIAL_CAPACITY "+hssfRow.getPhysicalNumberOfCells()  + hssfRow.INITIAL_CAPACITY);
				rowValue = new ArrayList<Object>();
				if(hssfRow!=null && !hssfRow.equals(""))
					for(int index=0, size=hssfRow.getLastCellNum(); index<size; index++){
						cell = (HSSFCell) hssfRow.getCell((short)index);
						rowValue.add(  validateAndRetriveExcelData(cell ));
					}
				cellDataList.add(rowValue);
			}
			saveValuesFromExcel(cellDataList);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	private   void readExcelFileWithEmptyCell(String fileName)
	{
		List cellDataList = new ArrayList();
		InputStream inputStream = null;
		POIFSFileSystem fileSystem = null;
		HSSFWorkbook workBook = null;
		HSSFSheet sheet    = null;
		Iterator rows = null;
		Iterator<HSSFCell> cells = null;
		HSSFCell cell = null;

		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = null;
		List<String> PW1 = null;
		Object M_BUFFER = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(fileName);
			POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
		 
			 
			workBook  = new HSSFWorkbook (fsFileSystem);
			sheet    = workBook .getSheetAt (0);
	 
			rows     = sheet.rowIterator();
			HSSFRow row = (HSSFRow) rows.next();
		 
				// Index iterator
				for(int index=0, size=row.getLastCellNum(); index<size; index++){
					cell = (HSSFCell) row.getCell((short)index);

					// Validating and retriveing value from cell
					PW1.add(validateAndRetriveExcelData(cell ));
				}

				System.out.println("PW1:::row"+row.getRowNum()+":::::"+"SIZE::"+PW1.size());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		saveEmpValuesFromExcel(cellDataList);
	}

	 
	private static  String saveValuesFromExcel(List cellDataList) throws Exception {
		String colName = "";
		String status = "";
		String values="";
		String totRows="";
		int success=0;
		String insert = " insert into PW_GL_EMP_UPLOAD( " ;
		CRUDHandler handler = new CRUDHandler();
		Connection connection =null;
		try{
		//	connection= CommonUtils.getConnection();
			for (int row = 0; row < cellDataList.size(); row++) {
				List cellTempList = (List) cellDataList.get(row);
				System.out.println("cell temp list >> "+cellTempList );
				//if(!cellTempList.toArray().length )
				for (int col = 0; col< cellTempList.size(); col++) {
					String hssfCell = (String) cellTempList.get(col);
					 String stringCellValue ="";
						if(hssfCell!=null)
							stringCellValue = hssfCell.toString();
					if(row==0 && hssfCell !=null){
						colName =colName+","+hssfCell.toString(); 
						
					}
					else{
						if(hssfCell ==null || hssfCell.equals(""))
							stringCellValue=null;
						else
							stringCellValue = hssfCell.toString();
						
						values =values +", '"+stringCellValue+"'";
					} 
					//System.out.print(stringCellValue + "\t");
				}
				if(row==0  )
					colName = colName.replaceFirst( ",", " ");
				values = values.replaceFirst(",", "");
				
		 
				if(isNullvalue(values)){
					String insertQuery =  insert  + colName + ") values  ( "+ values +" )";
					System.out.println("   insert qry  "+insertQuery);
					values=" ";
					success = handler.executeInsertStatement(insertQuery,connection);
				}
			}
			if(success>0)
				status = " Record inserted successfully ";
	/*	colName = colName.replaceFirst(",", "");
		System.out.println("COL NAME : "+ colName);
		System.out.println(" TOT ROWS " + totRows.replaceFirst(",", ""));
		insertQuery = insertQuery + colName + " values "+ totRows;*/
	 
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		finally{
			connection.commit();
		}
		 return status;
	}
	
	private static Boolean isNullvalue(String value) {
		try {
			value = value.replace(",", "");
		
			if(value.length()>0)
				 return true;
			else
				return false;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	private static  String saveEmpValuesFromExcel(List cellDataList) {
		String colName = "";
		String status = "";
		String values="";
		String totRows="";
		String insertQuery = " INSERT INTO PW_GL_EMP_UPLOAD  " ;
		CRUDHandler handler = new CRUDHandler();
		int success=0;
		try{
			for (int row = 0; row < cellDataList.size(); row++) {
				List cellTempList = (List) cellDataList.get(row);
				System.out.println("cell temp list >> "+cellTempList );
				//if(!cellTempList.toArray().length )
				if(row==0  ){
					cellTempList.toString().replace("[", "("); 
					colName =  cellTempList.toString().replace("]", ")");
				}
				else{
					cellTempList.toString().replace("[", "("); 
					values =  cellTempList.toString().replace("]", ")");
					if(isNullvalue(values)){
						insertQuery =  insertQuery + colName + " values "+ values;
						System.out.println("   insert qry  "+insertQuery);
						success = handler.executeInsertStatement(insertQuery, CommonUtils.getConnection());
					}
					success+=success;
				}
			
			}
			/*colName = colName.replaceFirst(",", "");
			System.out.println("COL NAME : "+ colName);
			System.out.println(" TOT ROWS " + totRows.replaceFirst(",", ""));
			insertQuery = insertQuery + colName + " values "+ totRows;
			*/
			//	int success = handler.executeInsertStatement(insertQuery, CommonUtils.getConnection());
			
			/*if(success>0)
				status = " Record inserted successfully ";*/
			
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return status;
	}

	/*
	private static void printToConsole(List cellDataList)
	{
		for (int i = 0; i < cellDataList.size(); i++)
		{
			ArrayList cellTempList = (ArrayList) cellDataList ;
			System.out.println("ROW "+ cellTempList);
			for (int j = 0; j < cellTempList.size(); j++)
			{
				ArrayList<String> hssfCell =   (ArrayList<String>) cellTempList.get( 0);
				//String stringCellValue = hssfCell.toString();
				System.out.print("hssfCell "+hssfCell+"---" + "\t");
			}
			System.out.println();
		}
	}
*/ 
	 public static void main(String[] args) throws Exception
	{
	/* String file = "C://Documents and Settings/55221/Desktop/details/dd/Employee Excel Upload Template/EMPLOYEE_UPLOAD_FORMAT_P9_V.xls";
		File fileName = new File(file);
		//readExcelFileWithEmptyCell(fileName);
		//new PP_UPLOAD_FILE_DTLS_HELPER().readExcelFile(file );
		readExcelFile(file );*/
	} 
	 
	private static String validateAndRetriveExcelData(HSSFCell cell  ){ 
		 int cellType =-1;
         String cellTypeDesc = null;
         String cellValue = null;
       if(cell ==null){
    	   cellType=-1;
       }
       else{
    	   cellType=cell.getCellType();
       }
	// Regular columns
		/*	System.out.println( "CELL_TYPE_BLANK" +cell.CELL_TYPE_BLANK + 
			                    "\n BOOL "+cell.CELL_TYPE_BOOLEAN +
			                    "\n NO " +cell.CELL_TYPE_NUMERIC+
			                    "\n STR "+cell.CELL_TYPE_STRING+
			                    "\n FORMULA "+cell.CELL_TYPE_FORMULA);*/
			 switch (cellType) {
		            case 0:
		                cellTypeDesc = "NUMERIC";
		                Double doubleValue = cell.getNumericCellValue();
		                cellValue = doubleValue.toString();
		                break;
		            case -1:
		                cellTypeDesc = "NULL";
		                cellValue = "";
		                break;
		            case 1:
		            	cellTypeDesc = "STRING";
		            	cellValue = cell.getStringCellValue();
		            	break;
		            case 2:
		                cellTypeDesc = "FORMULA";
		                cellValue = cell.getCellFormula();
		                break;
		            case 3:
		                cellTypeDesc = "BLANK";
		                cellValue = " ";
		                break;
		            case 4:
		                cellTypeDesc = "BOOLEAN";
		                boolean booleanValue = cell.getBooleanCellValue();
		                cellValue = ""+booleanValue;
		                break;
		            case 5:
		                cellTypeDesc = "ERROR";
		                byte byteValue = cell.getErrorCellValue();
		                cellValue = ""+byteValue;
		                break;
		            }
		       //     System.out.println("Column " + ++columnNumber + " has value " + cellValue + " of type " + cellTypeDesc);

	return cellValue;
}
 
}
