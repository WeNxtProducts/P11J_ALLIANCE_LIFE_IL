package com.iii.pel.forms.PILM035_APAC;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILP017.PW_IL_UPLOAD_FILE_DTLS;
import com.iii.pel.forms.PILP017.PW_IL_UPLOAD_FILE_DTLS_ACTION;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_UPLOAD_HELPER {

	


	public void UPLOAD_WBP(PM_IL_PRODUCT_UPLOAD_ACTION PM_IL_PRODUCT_UPLOAD_ACTION_BEAN) throws Exception {

	 String colName="";
		try{ 
			PM_IL_PROD_UPLOAD_FILE_DTLS PM_IL_PROD_UPLOAD_FILE_DTLS_BEAN = PM_IL_PRODUCT_UPLOAD_ACTION_BEAN.getPM_IL_PROD_UPLOAD_FILE_DTLS_BEAN();

			if(PM_IL_PROD_UPLOAD_FILE_DTLS_BEAN.getFILE_PATH()!=null){
				INSERT_XL_PW_TABLE(PM_IL_PROD_UPLOAD_FILE_DTLS_BEAN.getFILE_PATH(),
						PM_IL_PRODUCT_UPLOAD_ACTION_BEAN  );
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}  
	}
 

	@SuppressWarnings("unchecked")
	private String INSERT_XL_PW_TABLE(File file,PM_IL_PRODUCT_UPLOAD_ACTION PM_IL_PRODUCT_UPLOAD_ACTION_BEAN)
	throws Exception {

		InputStream inputStream = null;
		POIFSFileSystem fileSystem = null;
		HSSFWorkbook workBook = null;
		HSSFSheet sheet    = null;
		Iterator<Row> rows = null;
		Iterator<HSSFCell> cells = null;
		HSSFCell cell = null;
		ResultSet resultSet = null,rsChkExist=null;
		Connection connection = null;
		CRUDHandler handler = null;
		List<Object> PW1 = null;
		Object M_BUFFER = null;
		String M_POL_NO = null;
		Long M_POL_SYS_ID = null;
		Long sys_ud_sys_id = null;
		Object[] obj = null;
		
		ResultSet rs_seq = null;
		String seqquery = "SELECT SEQ_UD_SYS_ID.NEXTVAL " +
									"FROM DUAL";
		//String deleteQuery = "DELETE FROM PW_IL_UPLOAD_DATA";
		String deleteErrorLog= "DELETE FROM PT_IL_CHECK_OFF_TRANS_DTL";
		String INSERT_INTO_PW_IL_UPLOAD_DATA = "INSERT INTO PM_IL_PROD_APPL_COND(PACOND_PROD_CODE,PACOND_COND_CODE," +
				"PACOND_COVER_CODE,PACOND_DFLT_YN,PACOND_TYPE,PACOND_DISP_SEQ_NO,PACOND_CR_UID,PACOND_CR_DT) VALUES " +
				"(?,?,?,?,?,?,?,?) ";
		
String UserName =null;
		try
		{ 
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			Date dt = new Date() ;
			dt = new CommonUtils().getCurrentDate();
			
			UserName =CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
			
			fileSystem = new POIFSFileSystem (new FileInputStream(file));
			workBook = new HSSFWorkbook (fileSystem);
			sheet    = workBook.getSheetAt (0);
			int M_END_COL   = 0;
			int status=0;
			rows     = sheet.rowIterator();
			HSSFRow row = (HSSFRow) rows.next();
			
			
			/*handler.executeDeleteStatement(deleteQuery, connection);
			connection.commit();*/
			
			/*handler.executeDeleteStatement(deleteErrorLog, connection);
			connection.commit();*/
			while(rows.hasNext()){
				
				row = (HSSFRow) rows.next();
				PW1 = new ArrayList<Object>(M_END_COL);
				
				// Index iterator
				if(row!=null && !row.equals("")){
				for(int index=0, size=row.getLastCellNum(); index<size; index++){
					cell =   row.getCell((short)index);
					PW1.add(validateAndRetriveExcelData(cell,  row.getRowNum(), index, 
								"UPLOAD", "ERRORREF" ));
					 	
				}
				/*rs_seq = handler.executeSelectStatement(seqquery, connection);
				if(rs_seq.next()){
					sys_ud_sys_id = rs_seq.getLong(1);
				}*/
				}
				System.out.println("GLOBAL.M_USER_ID   :  "+CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
				System.out.println(row.getRowNum()+"=num="+row.getFirstCellNum()+"FIRST -- LAST "+row.getLastCellNum()+PW1.size()+" PW1 VALUES "+PW1);
			 
				
				obj = new Object[]{ 
			 				PW1.get(0),
							PW1.get(1),
							PW1.get(2),
							PW1.get(3),
							PW1.get(4),
							PW1.get(5),
							UserName,
							dt
						 };
			 	
			 	status= handler.executeInsertStatement(INSERT_INTO_PW_IL_UPLOAD_DATA,
							connection,obj); 
			 	status+=status;
			}
			connection.commit();
		
		 
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
			CommonUtils.closeCursor(rsChkExist);
		}
		return "";

	}

	
	private Object validateAndRetriveExcelData(HSSFCell cell, int rowNumber, int columnNumber, 
		String riskId, String errorRef ){ 
	Object value = null;
	int cellNumber = columnNumber;

		if(cellNumber < 10){
			switch (cellNumber){
			case 0:
				value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
				break;
			case 1:
				value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
				break;
			case 2:
				value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
				break;
			case 3:
				value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
				break;
			case 4:
				value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
				break;
			case 5:
				value = getNumericIntegerValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
				break;
			/*case 6:
				value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
				break;
			case 7:
				value = CommonUtils.dateToStringFormat(getDateValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef ));
				break;
				*/
			default:
				break;
			}
		 
	} 
	
	return value;
}


	// Validators
	private boolean isValidNumber(HSSFCell cell, boolean nullable){
		Short columnNumber = null;
		Integer columnTypeInExcel = null;
		boolean valid = true;
		
		if(cell != null){
			//columnNumber = cell.getCellNum(); 
			columnTypeInExcel = cell.getCellType();
			if(columnTypeInExcel != cell.CELL_TYPE_NUMERIC && columnTypeInExcel != cell.CELL_TYPE_FORMULA){
				if(!nullable && columnTypeInExcel == cell.CELL_TYPE_BLANK){
					valid = false;
				}
			}
		}else{
			if(!nullable && cell == null){
				valid = false;
			}
		}
		return valid;
	}
	private boolean isValidString(HSSFCell cell, boolean nullable){
		Integer columnTypeInExcel = null; 
		boolean valid = true;
		if(cell != null ){
			columnTypeInExcel = cell.getCellType();
			if(columnTypeInExcel != HSSFCell.CELL_TYPE_STRING && columnTypeInExcel != HSSFCell.CELL_TYPE_NUMERIC){
				if(!nullable && columnTypeInExcel == cell.CELL_TYPE_BLANK){
					valid = false;
				}
			}
		}else{
			if(!nullable && cell == null){
				valid = false;
			}
		}
		return valid;
	}
	private boolean isValidDate(HSSFCell cell, boolean nullable){
		Integer columnTypeInExcel = null; 
		boolean valid = true;
		if(cell != null ){
			columnTypeInExcel = cell.getCellType();
			// if column 1 is date in databse
			if(columnTypeInExcel != HSSFCell.CELL_TYPE_NUMERIC ){
				// Date is not date
				// Log Error for [row,column] Value is not Date
				if(!nullable && columnTypeInExcel == cell.CELL_TYPE_BLANK){
					valid = false;
				}
			}
		}else{
			if(!nullable && cell == null){
				valid = false;
			}
		}
		return valid;
	}
	
	
	
	// Value retrievers
	private Integer getNumericIntegerValueOfCell(HSSFCell cell, 
			int rowNumber, int columnNumber, boolean nullable, String riskId, String errorRef){
		Integer integerValue = null;
		Double comSysNumber = null;
		
		// Log error if found invalid
		if(!isValidNumber(cell, nullable)){
			logError(rowNumber, columnNumber, "Invalid Number value", riskId, errorRef );
		}
		
		if(cell != null){
			if(cell.getCellType()!= HSSFCell.CELL_TYPE_BLANK && cell.getCellType()== HSSFCell.CELL_TYPE_NUMERIC){
				comSysNumber = cell.getNumericCellValue();
				integerValue = comSysNumber.intValue();
			}else if(cell.getCellType() == HSSFCell.CELL_TYPE_STRING){
				if(cell.getRichStringCellValue()  != null && !cell.getRichStringCellValue().equals("")){
					integerValue = Integer.parseInt(cell.getRichStringCellValue().toString());
				}
			}
		}
	 	System.out.println("  Number: "+integerValue);
		// Null check if field is not nullable
		if(!nullable && integerValue == null){
			logError(rowNumber, columnNumber, "Value can not be null", riskId, errorRef );
		}
		return integerValue;
	}
	private Double getNumericDoubleValueOfCell(HSSFCell cell, 
			int rowNumber,int columnNumber, boolean nullable, String riskId, String errorRef){
		Double comSysNumber = null;
		// Log error if found invalid
		if(!isValidNumber(cell, nullable)){
			logError(rowNumber, columnNumber, "Invalid Number value", riskId, errorRef );
		}
		
		if(cell != null){
			if(cell.getCellType()!= HSSFCell.CELL_TYPE_BLANK){
				comSysNumber = cell.getNumericCellValue();
			}
		}
		/*NumberFormat f = NumberFormat.getInstance();  
		f.setGroupingUsed(false);
		String refinedNumber = f.format(comSysNumber); 
		System.out.println("-----------8<---------Formated Number: "+refinedNumber);*/
		
		// Null check if field is not nullable
		if(!nullable && comSysNumber == null){
			logError(rowNumber, columnNumber, "Value can not be null", riskId, errorRef );
		}

		return comSysNumber;
	}
	private String getStringValueOfCell(HSSFCell cell, 
			int rowNumber,int columnNumber, boolean nullable, String riskId, String errorRef){
		// Log error if found invalid
		if(!isValidString(cell, nullable)){
			logError(rowNumber, columnNumber, "Invalid String value", riskId, errorRef );
		}
		
		String value = null;
		if(cell != null){
			if(cell.getCellType()!= HSSFCell.CELL_TYPE_BLANK){
				if(cell.getCellType() == HSSFCell.CELL_TYPE_STRING){
					if(cell.getRichStringCellValue() != null){
						value = cell.getRichStringCellValue().toString();
					}
				}else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
					Double comSysNumber = cell.getNumericCellValue();  
					NumberFormat f = NumberFormat.getInstance();  
					f.setGroupingUsed(false);
					value = f.format(comSysNumber); 
				}
			}
		}
		// Null check if field is not nullable
		if(!nullable && (value == null || value.trim().isEmpty())){
			logError(rowNumber, columnNumber, "Value can not be null", riskId, errorRef );
		}
		
		return value;
	}
	public static java.util.Date stringToUtilDate(String dateString){

		java.util.Date date = null;
		try {
			//date = new SimpleDateFormat(MessagePropertyManager.getValue("pel_date_format")).parse(dateString);
			date = new SimpleDateFormat(PELConstants.pelDateFormat).parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	private Date getDateValueOfCell(HSSFCell cell, 
			int rowNumber,int columnNumber, boolean nullable, String riskId, String errorRef){
		// Log error if found invalid
		if(!isValidDate(cell, nullable)){
			logError(rowNumber, columnNumber, "Invalid Date value", riskId, errorRef );
		}
		
		Date date = null;
		if(cell != null){
			if(cell.getCellType()!= HSSFCell.CELL_TYPE_BLANK){
				System.out.println(" cell.toString().length() "+cell.toString().trim().length());
						  if(cell.toString().trim().length()==0){
							date = null;//CommonUtils.stringToUtilDate(cell.getRichStringCellValue().toString());
						  }else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
							  date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
						  }
						  else if(cell.getCellType() == HSSFCell.CELL_TYPE_STRING){
							  date=	stringToUtilDate(cell.getRichStringCellValue().toString());
						  }
			}
		}

		// Null check if field is not nullable
		if(!nullable && date == null){
			logError(rowNumber, columnNumber, "Value can not be null", riskId, errorRef );
		}
		
		return date;
	}
	private void logError(int rowNumber, int columnNumber, String message, 
		String riskId, String errorRef){
	String query = "INSERT INTO PW_ERR_DATA (ERR_RISK_ID,ERR_DESC,ERR_REFERENCE,ERR_POL_NO) VALUES(?,?,?,?)";
	Connection connection = null;
	CRUDHandler handler = new CRUDHandler();
	
	try {
		connection = CommonUtils.getConnection();
		handler.executeInsertStatement(query, connection, new Object[]{riskId,
				"Row: "+rowNumber+", Column: "+columnNumber+", Error: "+message,
				errorRef });
	} catch (DBException e) {
		// Absorbing error purposefully
		e.printStackTrace();
	} catch (SQLException e) {
		// Absorbing error purposefully
		e.printStackTrace();
	}
}

	

	
}
