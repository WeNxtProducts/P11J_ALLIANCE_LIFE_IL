package com.iii.pel.forms.PP100_1APAC;

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

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;



public class PP_UPLOAD_FILE_DTLS_HELPER {
	
	
	public String INSERT_XL_PW_TABLES(File file ,PP_UPLOAD_FILE_DTLS_ACTION pp_upload_file_dtls_action) throws Exception{
		InputStream inputStream = null;
		POIFSFileSystem fileSystem = null;
		HSSFWorkbook workbook = null;
		HSSFSheet sheet = null;
		/*Modified by Ram on 13/03/2017
		 * Iterator<HSSFRow> rows = null;
		 * End
		 * */
		Iterator rows = null;
		Iterator<HSSFCell> cells = null;
		HSSFCell cell = null;
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		List<Object> PW1 = null;
		Object[] obj = null;
		String INSERT_QUERY = " INSERT INTO PW_IL_AUTO_UPLOAD_DATA(AUD_FILE, AUD_FIELD_1, AUD_FIELD_2, " +
				" AUD_FIELD_3, AUD_FIELD_4, AUD_FIELD_5," +
				" AUD_FIELD_6, AUD_FIELD_7, AUD_FIELD_8," +
				" AUD_FIELD_9, AUD_FIELD_10, AUD_FIELD_11," +
				" AUD_FIELD_12, AUD_FIELD_13, AUD_FIELD_14," +
				" AUD_FIELD_15, AUD_FIELD_16, AUD_FIELD_17," +
				" AUD_FIELD_18, AUD_FIELD_19, AUD_FIELD_20," +
				" AUD_FIELD_21, AUD_FIELD_22, AUD_FIELD_23," +
				" AUD_FIELD_24, AUD_FIELD_25, AUD_FIELD_26," +
				" AUD_FIELD_27, AUD_FIELD_28, AUD_FIELD_29," +
				" AUD_FIELD_30,AUD_FIELD_31,  AUD_FIELD_32," +
				" AUD_FIELD_33,  AUD_FIELD_34,  AUD_FIELD_35," +
				" AUD_FIELD_36,  AUD_FIELD_37,  AUD_FIELD_38," +
				" AUD_FIELD_39,  AUD_FIELD_40,  AUD_FIELD_56," +
				" AUD_CR_UID, AUD_CR_DT, AUD_SUCC_YN) " +
				" VALUES (? , ? , ? , ? , ? , ? ," +
				" ?, ? , ? , ? , ? , ? ,? , ? , ? ,? ,? , ? ," +
				" ? , ? , ? , " +
				" ? , ? , ? , " +
				" ? , ? , ? ,? , ? , ? ," +
				" ? ,? ,  ? ," +
				" ? , ? ,  ? ,? ,  ? ,  ? ,? ,  ? , ? , ? , ? ,? )";

           try{
        	   connection = CommonUtils.getConnection();
        	   fileSystem = new POIFSFileSystem(new FileInputStream(file));
        	   workbook = new HSSFWorkbook(fileSystem);
        	   sheet = workbook.getSheetAt(0);
        	   rows = sheet.rowIterator();
        	   /*Modified by Ram on 13/03/2017
        	    * 
        	    * HSSFRow row = rows.next();*/
        	   HSSFRow row = (HSSFRow) rows.next();
        	   /*End*/
        	   int M_END_COL   = 0;
        	   int size = 0;
        	   while(rows.hasNext()){
        		   /*Modified by Ram on 13/03/2017
        		    * 
        		    * row = rows.next();*/
        		   row = (HSSFRow) rows.next();
        		   /*End*/
        		   PW1 = new ArrayList<Object>(M_END_COL);
        		   if(row != null && !row.equals("")){
        			   size =row.getLastCellNum();
        			   for(int index = 0; index < size ;index++ ){
        				   cell =   row.getCell((short)index);
       					PW1.add(validateAndRetriveExcelData(cell,  row.getRowNum(), index, 
       								"GL EMP UPLOAD", "ERRORREF" ));
        			   }
        			   System.out.println(row.getRowNum()+"=num="+row.getFirstCellNum()+"FIRST -- LAST "+row.getLastCellNum()+PW1.size()+" PW1 VALUES "+PW1);
        			   obj = new Object[]{
        					  file.getPath(),
   							PW1.get(0),
   							PW1.get(1),
   							PW1.get(2),
   							PW1.get(3),
   							PW1.get(4),
   							PW1.get(5),
   							PW1.get(6),
   							PW1.get(7),
   							PW1.get(8),
   							PW1.get(9),
   							PW1.get(10),
   							PW1.get(11),
   							PW1.get(12),
   							PW1.get(13),
   							PW1.get(14),
   							PW1.get(15),
   							PW1.get(16),
   							PW1.get(17),
   							PW1.get(18),
   							PW1.get(19),
   							PW1.get(20),
   							PW1.get(21),
   							PW1.get(22),
   							PW1.get(23),
   							PW1.get(24),
   							PW1.get(25),
   							PW1.get(26),
   							PW1.get(27),
   							PW1.get(28),
   							PW1.get(29),
   							PW1.get(30),
   							PW1.get(31),
   							PW1.get(32),
   							PW1.get(33),
   							PW1.get(34),
   							PW1.get(35),
   							PW1.get(36),
   							PW1.get(37),
   							PW1.get(38),
   							PW1.get(39),
   							PW1.get(40),
   							CommonUtils.getControlBean().getUSER_ID(),
   							new CommonUtils().getCurrentDate(),
   							"Y"
   							/*PW1.get(41),
   							 PW1.get(43),
   							PW1.get(44),
   							PW1.get(45),
   							PW1.get(46),
   							PW1.get(47),
   							PW1.get(48),
   							PW1.get(49),
   							PW1.get(50),
   							PW1.get(51),
   							PW1.get(52)*/ };
        			   
        			   int status = handler.executeInsertStatement(INSERT_QUERY, connection, obj);
        			   CommonUtils.doComitt();
        			   System.out.println("Inserted into table ");
        		   }
        	   }
        	   
        	   PR_CALC_DRIP(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"), 
        			   			CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2"));
        	
           }catch (Exception e) {
        	   e.printStackTrace();
        	   throw e;
        	   
		}
		return null;
		
	}
	
	
	
	   /**
    *
    * @param P_PARA_1-IN
    * @param P_PARA_2-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> PR_CALC_DRIP(
                    Object P_PARA_1,
         Object P_PARA_2) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PARA_1);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_PARA_2);
          parameterList.add(param2);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_PP100_1APAC.PR_CALC_DRIP");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }

	
	
	
	
	
	
	private Object validateAndRetriveExcelData(HSSFCell cell, int rowNumber, int columnNumber, 
			String riskId, String errorRef ){ 
		Object value = null;
		int cellNumber = columnNumber;

			//System.out.println("COL NUM "+columnNumber +" cellNumber < 37 "+ (cellNumber < 37));
			if(cellNumber < 57){
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
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 6:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 7:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 8:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 9:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 10:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 11:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 12:	
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;	
				case 13:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 14:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 15:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 16:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 17:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 18:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 19:	
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;	
				case 20:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 21:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 22:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 23:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 24:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 25:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 26:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 27:	
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;	
				case 28:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 29:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 30:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 31:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 32:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 33:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 34:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 35:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 36:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 37:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 38:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 39:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 40:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 41:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 42:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 43:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 44:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 45:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 46:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 47:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 48:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 49:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 50:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 51:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 52:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 53:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 54:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 55:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				case 56:
					value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
					break;
				
				default:
					break;
				}
			 
		} 
		
		return value;
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
	
}

