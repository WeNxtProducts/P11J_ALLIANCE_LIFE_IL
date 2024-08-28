package com.iii.pel.forms.PILP017;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class PW_IL_UPLOAD_HELPER{

	/*public  String getColName(String fileName) throws Exception
	{
		List cellDataList = new ArrayList();
		String colName=null;
		try {
			List<Object> rowValue = null;
			HSSFCell cell=null;
			Object obj = "";
			FileInputStream fileInputStream = new FileInputStream(fileName);
			POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
			HSSFWorkbook workBook = new HSSFWorkbook(fsFileSystem);
			HSSFSheet hssfSheet = workBook.getSheetAt(0);
			Iterator rowIterator = hssfSheet.rowIterator();
			rowValue = new ArrayList<Object>();
			while (rowIterator.hasNext()) {
				HSSFRow hssfRow = (HSSFRow) rowIterator.next();
			//	System.out.println("hssfRow.INITIAL_CAPACITY "+hssfRow.getPhysicalNumberOfCells()  + hssfRow.INITIAL_CAPACITY);
				if(hssfRow.getRowNum()==0 && hssfRow!=null && !hssfRow.equals(""))
					for(int index=0, size=hssfRow.getLastCellNum(); index<size; index++){
						cell = (HSSFCell) hssfRow.getCell((short)index);
					 //System.out.println(size+"--"+index+" COlNAME "+rowValue);
						if(cell !=null &&  cell.toString()!="")
							rowValue.add( cell.toString() );
					}
			}
			System.out.println( " row "+rowValue);
			 
			 for (int col = 0; col < rowValue.size(); col++) {
				if(rowValue.get(col)!=null && !rowValue.get(col).equals(""))
					colName =colName + ","+ rowValue.get(col).toString();
				//System.out.println( " COlNAME "+colName);
			}
			while (rowIterator.hasNext()) {
				HSSFRow hssfRow = (HSSFRow) rowIterator.next();
				if(hssfRow.getRowNum()==0){
					Iterator  colIterator = hssfRow.cellIterator();
					if(hssfRow!=null && !hssfRow.equals(""))
						for(int index=1, size=colIterator.toString().length(); index<size; index++){
							System.out.println(size+"--"+index+" COlNAME "+colName);
							cell = (HSSFCell) hssfRow.getCell((short)index);
							 colName = colName + cell.toString();
						}
				}
					 
			}
			 colName = colName.replaceFirst(",", "");
			System.out.println( " COlNAME "+colName);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return colName;
	}
	
	*/public void UPLOAD_WBP(PW_IL_UPLOAD_FILE_DTLS_ACTION PW_IL_UPLOAD_FILE_DTLS_ACTION_BEAN) throws Exception {

	 String colName="";
		try{ 
			PW_IL_UPLOAD_FILE_DTLS PW_IL_UPLOAD_FILE_DTLS_BEAN = PW_IL_UPLOAD_FILE_DTLS_ACTION_BEAN.getPW_IL_UPLOAD_FILE_DTLS_BEAN();

			if(PW_IL_UPLOAD_FILE_DTLS_BEAN.getFILE_PATH()!=null){
				//colName = getColName(PP_UPLOAD_FILE_DTLS_BEAN.getFILE_PATH().toString());
				/*aDDED BY SANKARA NARAYANAN ON 13/04/2017*/
				if("XLS".equals(acceptiletype(PW_IL_UPLOAD_FILE_DTLS_BEAN.getFILE_NAME()))||"XLSX".equals(acceptiletype(PW_IL_UPLOAD_FILE_DTLS_BEAN.getFILE_NAME()))){
				/*
				 * 
				 * INSERT_XL_PW_TABLE(PW_IL_UPLOAD_FILE_DTLS_BEAN.getFILE_PATH(),
						PW_IL_UPLOAD_FILE_DTLS_ACTION_BEAN  );*/
					
					INSERT_XL_PW_PROC(PW_IL_UPLOAD_FILE_DTLS_BEAN.getFILE_PATH(),
						PW_IL_UPLOAD_FILE_DTLS_ACTION_BEAN );
				
				}else if("CSV".equals(acceptiletype(PW_IL_UPLOAD_FILE_DTLS_BEAN.getFILE_NAME()))){
				/*	INSERT_CSV_PW_TABLE(PW_IL_UPLOAD_FILE_DTLS_BEAN.getFILE_PATH(),
							PW_IL_UPLOAD_FILE_DTLS_ACTION_BEAN  );*/
					
					INSERT_CSV_PW_PROC(PW_IL_UPLOAD_FILE_DTLS_BEAN.getFILE_PATH(),
							PW_IL_UPLOAD_FILE_DTLS_ACTION_BEAN);
				}//END
				/* Newly Added by Dhinesh on 29-06-2018 for FLA - RM018T - FSD_IL_FLA_004-Common Data Upload-R1_final */ 
				else if("txt".equalsIgnoreCase(acceptiletype(PW_IL_UPLOAD_FILE_DTLS_BEAN.getFILE_NAME()))){
					
					INSERT_TXT_PW_PROC(PW_IL_UPLOAD_FILE_DTLS_BEAN.getFILE_PATH(),
								PW_IL_UPLOAD_FILE_DTLS_ACTION_BEAN);
					}
			    /* End */	
				
				
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
	
	
	
	/*aDDED BY SANKARA NARAYANAN ON 13/04/2017*/
public PW_IL_UPLOAD_DATA assignBeanValues(HSSFRow row, int rowCount){
		
	PW_IL_UPLOAD_DATA Bean =  new PW_IL_UPLOAD_DATA();
		System.out.println("Row Count =="+rowCount);
		Bean.setUD_REFF_NO(getStringValueOfCell(row.getCell((short)0),  rowCount, 0, true, "IL DATA UPLOAD", "ERRORREF" ));
		Bean.setUD_FLEX_01(getStringValueOfCell(row.getCell((short)1),  rowCount, 1, true, "IL DATA UPLOAD", "ERRORREF" ));
		Bean.setUD_FLEX_02(getStringValueOfCell(row.getCell((short)2),  rowCount, 2, true, "IL DATA UPLOAD", "ERRORREF" ));
		Bean.setUD_FLEX_03(getStringValueOfCell(row.getCell((short)3),  rowCount, 3, true, "IL DATA UPLOAD", "ERRORREF" ));
		Bean.setUD_FLEX_04(getStringValueOfCell(row.getCell((short)4),  rowCount, 4, true, "IL DATA UPLOAD", "ERRORREF" ));
		Bean.setUD_FLEX_05(getStringValueOfCell(row.getCell((short)5),  rowCount, 5, true, "IL DATA UPLOAD", "ERRORREF" ));
		Bean.setUD_FLEX_06(getStringValueOfCell(row.getCell((short)6),  rowCount, 6, true, "IL DATA UPLOAD", "ERRORREF" ));
		Bean.setUD_FLEX_07(getStringValueOfCell(row.getCell((short)7),  rowCount, 7, true, "IL DATA UPLOAD", "ERRORREF" ));
		Bean.setUD_FLEX_08(getStringValueOfCell(row.getCell((short)8),  rowCount, 8, true,  "IL DATA UPLOAD", "ERRORREF" ));
		Bean.setUD_FLEX_09(getStringValueOfCell(row.getCell((short)9),  rowCount, 9, true,  "IL DATA UPLOAD", "ERRORREF" ));
		Bean.setUD_FLEX_10(getStringValueOfCell(row.getCell((short)10),  rowCount, 10, true,  "IL DATA UPLOAD", "ERRORREF" ));
		Bean.setUD_FLEX_11(getStringValueOfCell(row.getCell((short)11),  rowCount, 11, true,  "IL DATA UPLOAD", "ERRORREF" ));
		Bean.setUD_FLEX_12(getStringValueOfCell(row.getCell((short)12),  rowCount, 12, true, "IL DATA UPLOAD", "ERRORREF" ));
		Bean.setUD_FLEX_13(getStringValueOfCell(row.getCell((short)13),  rowCount, 13, true,  "IL DATA UPLOAD", "ERRORREF" ));
		Bean.setUD_FLEX_14(getStringValueOfCell(row.getCell((short)14),  rowCount, 14, true,  "IL DATA UPLOAD", "ERRORREF" ));
		Bean.setUD_FLEX_15(getStringValueOfCell(row.getCell((short)15),  rowCount, 15, true,  "IL DATA UPLOAD", "ERRORREF" ));
		Bean.setUD_FLEX_16(getStringValueOfCell(row.getCell((short)16),  rowCount, 16, true,  "IL DATA UPLOAD", "ERRORREF" ));
		Bean.setUD_FLEX_17(getStringValueOfCell(row.getCell((short)17),  rowCount, 17, true,  "IL DATA UPLOAD", "ERRORREF" ));
		Bean.setUD_FLEX_18(getStringValueOfCell(row.getCell((short)18),  rowCount, 18, true,  "IL DATA UPLOAD", "ERRORREF" ));
		Bean.setUD_FLEX_19(getStringValueOfCell(row.getCell((short)19),  rowCount, 19, true,  "IL DATA UPLOAD", "ERRORREF" ));
		Bean.setUD_FLEX_20(getStringValueOfCell(row.getCell((short)20),  rowCount, 20, true,  "IL DATA UPLOAD", "ERRORREF" ));
		
		
		return Bean;
		
	}
 

public PW_IL_UPLOAD_DATA assignBeanValues(String[] row) throws Exception{
	
	PW_IL_UPLOAD_DATA Bean =  new PW_IL_UPLOAD_DATA();
	Method method = null;
		Bean.setUD_REFF_NO(row[0]!=null?row[0]:null);
		for(int i=1;i<row.length;i++){
			/*Modified by ganesh on 14-12-2017 due to java bean not available issue */
			if(i<10){
				method = Bean.getClass().getMethod(
					"setUD_FLEX_0" + i, String.class);
			}else{
				method = Bean.getClass().getMethod(
						"setUD_FLEX_" + i, String.class);
			}
			/*end*/
			method.invoke(Bean,
					row[i]);
		}
				
		return Bean;
		
	}

/*Modified by Janani on 24.07.2018 for FLA dynamic upload issues,as suggested by Chandramohan*/
/*public void CALL_INSERT_PROC(ARRAY arrayOfRecords, Connection connection)*/

public void CALL_INSERT_PROC(ARRAY arrayOfRecords,
	Object  P_MAP_ID,
	Connection connection)
	
	/*End*/
	throws ProcedureException {
String message = null;
ArrayList<OracleParameter> parameterList = null;
ArrayList<OracleParameter> outputList = null;
try {
	parameterList = new ArrayList<OracleParameter>();
	outputList = new ArrayList<OracleParameter>();
	OracleParameter param1 = new OracleParameter("P_GET_DATA",
			OracleParameter.DATA_TYPE.OBJECT,
			OracleParameter.DIRECTION_TYPE.IN, arrayOfRecords);
	System.out.println("ss = " + param1.toString());
	parameterList.add(param1);
	
	OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_MAP_ID);
	parameterList.add(param2);
	
	OracleProcedureHandler procHandler = new OracleProcedureHandler();
	ArrayList arrList = new ArrayList();
	arrList.add(param1);
	procHandler.executeProc(parameterList, connection, "P9ILPK_SALARY_CHKOFF.PR_INS_IL_UPLOAD_T");

} catch (Exception e) {
	e.printStackTrace();

	ErrorHelpUtil.getErrorForProcedure(connection);
	throw new ProcedureException(e.getMessage());
}

}
	
	private String INSERT_XL_PW_PROC(File file,PW_IL_UPLOAD_FILE_DTLS_ACTION PW_IL_UPLOAD_FILE_DTLS_ACTION_BEAN)
			throws Exception {

		POIFSFileSystem fileSystem = null;
		HSSFWorkbook workBook = null;
		HSSFSheet sheet = null;
		Iterator<Row> rows = null;
		/*Iterator<Row> rows = null;*/
		HSSFCell cell = null;
		ResultSet resultSet = null, rsChkExist = null;
		Connection connection = null;
		CRUDHandler handler = null;


		try {
			List<Object> listObject =new ArrayList<Object>();
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			//OPCPackage pkg = OPCPackage.open(new File("file.xlsx"));
			fileSystem = new POIFSFileSystem(new FileInputStream(file));
			workBook = new HSSFWorkbook(fileSystem);
			sheet = workBook.getSheetAt(0);
			int rowCount = 0;
			String chkExsit = " select UD_SYS_ID,UD_REFF_NO from PW_IL_UPLOAD_DATA WHERE UD_REFF_NO=? ";
			String seqquery = "SELECT SEQ_UD_SYS_ID.NEXTVAL " +
					"FROM DUAL";
			rows = sheet.rowIterator();
			HSSFRow row = (HSSFRow) rows.next();
			Object[] obj = null;
			Long sys_ud_sys_id=null;
			ResultSet rs_seq=null;
			long excelReadStartTime = System.nanoTime();

			ArrayDescriptor arrayDescriptor = ArrayDescriptor.createDescriptor("TAB_IL_EMP", connection);
			StructDescriptor recDescriptor = StructDescriptor.createDescriptor("OBJ_IL_EMP", connection);			

			Object[] array_of_records = new Object[sheet.getLastRowNum()];
			short columncount = row.getLastCellNum();
			ArrayList<PW_IL_UPLOAD_DATA> DataList =  new ArrayList<PW_IL_UPLOAD_DATA>();
			while (rows.hasNext()) {
				row = (HSSFRow) rows.next();
				if (row != null && !row.equals(""))
					DataList.add(assignBeanValues(row,rowCount));
				rs_seq = handler.executeSelectStatement(seqquery, connection);
				if(rs_seq.next()){
					sys_ud_sys_id = rs_seq.getLong(1);
				}
				obj = new Object[] {
						sys_ud_sys_id	,
						DataList.get(rowCount).getUD_REFF_NO()	,
						DataList.get(rowCount).getUD_FLEX_01()	,
						DataList.get(rowCount).getUD_FLEX_02()	,
						DataList.get(rowCount).getUD_FLEX_03()	,
						DataList.get(rowCount).getUD_FLEX_04()	,
						DataList.get(rowCount).getUD_FLEX_05()	,
						DataList.get(rowCount).getUD_FLEX_06()	,
						DataList.get(rowCount).getUD_FLEX_07()	,
						DataList.get(rowCount).getUD_FLEX_08()	,
						DataList.get(rowCount).getUD_FLEX_09()	,
						DataList.get(rowCount).getUD_FLEX_10()	,
						DataList.get(rowCount).getUD_FLEX_11()	,
						DataList.get(rowCount).getUD_FLEX_12()	,
						DataList.get(rowCount).getUD_FLEX_13()	,
						DataList.get(rowCount).getUD_FLEX_14()	,
						DataList.get(rowCount).getUD_FLEX_15()	,
						DataList.get(rowCount).getUD_FLEX_16()	,
						DataList.get(rowCount).getUD_FLEX_17()	,
						DataList.get(rowCount).getUD_FLEX_18()	,
						DataList.get(rowCount).getUD_FLEX_19()	,
						DataList.get(rowCount).getUD_FLEX_20()	
				};


				if (row.getRowNum() == 1) {
					rsChkExist = handler.executeSelectStatement(chkExsit,
							connection, new Object[] { DataList.get(0).getUD_REFF_NO() });

					if (rsChkExist.next()) {
						throw new Exception(
								Messages.getString(
										PELConstants.pelErrorMessagePath,
										"92269",
										new Object[] { "Kindly check the Reference number column same as already uploaded" }));

					}
				}
				listObject.add(obj);
				rowCount += 1;
			}

			Object[] objArr = getCovertToObjectArr(listObject);
			ARRAY oracle_array = new ARRAY(arrayDescriptor, connection, objArr);	

			/*Modified by Janani on 24.07.2018 for FLA dynamic upload issues,as suggested by Chandramohan*/
			//CALL_INSERT_PROC(oracle_array, connection);
			
			CALL_INSERT_PROC(oracle_array,
					CommonUtils.getGlobalObject("UI_M_MAP_CODE"),
					connection);
			
			/*End*/

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
//END
	@SuppressWarnings("unchecked")
	private String INSERT_XL_PW_TABLE(File file,PW_IL_UPLOAD_FILE_DTLS_ACTION PW_IL_UPLOAD_FILE_DTLS_ACTION_BEAN)
	throws Exception {

		//Variables required for reading excel 
		//Variables required for reading excel 
		InputStream inputStream = null;
		POIFSFileSystem fileSystem = null;
		HSSFWorkbook workBook = null;
		HSSFSheet sheet    = null;
		//modified by Agalya for excelupload relogin error was came for spp ref no- FALCONQC-1715615
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
		String deleteQuery = "DELETE FROM PW_IL_UPLOAD_DATA";
		String deleteErrorLog= "DELETE FROM PT_IL_CHECK_OFF_TRANS_DTL";
		String INSERT_INTO_PW_IL_UPLOAD_DATA = "INSERT INTO PW_IL_UPLOAD_DATA  (UD_SYS_ID,UD_FLEX_01," +
				"  UD_FLEX_02,  UD_FLEX_03,  UD_FLEX_04) VALUES " +
				"	(?,?,?,?, ?) ";
		try
		{ 
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			
			//reading excel
//			inputStream = new FileInputStream (xlsPath);
			fileSystem = new POIFSFileSystem (new FileInputStream(file));
			workBook = new HSSFWorkbook (fileSystem);
			sheet    = workBook.getSheetAt (0);
			int M_END_COL   = 0;
			//added for set the rik_sysid 
			int status=0;
			//String chkExsit = " SELECT PEMP_ID,PEMP_REF_NO FROM PW_GL_EMP_UPLOAD WHERE PEMP_REF_NO=? ";
			// Commented by Kavitha to upload multiple Excel 
			
		/*	handler.executeSelectStatement(" DELETE FROM PW_GL_EMP_UPLOAD ",
					connection, new Object[]{});
			 */
		
			rows     = sheet.rowIterator();
			//modified by Agalya for excelupload relogin error was came for spp ref no- FALCONQC-1715615
			HSSFRow row = (HSSFRow) rows.next();
			
			
			handler.executeDeleteStatement(deleteQuery, connection);
			connection.commit();
			
			handler.executeDeleteStatement(deleteErrorLog, connection);
			connection.commit();
			while(rows.hasNext()){
				//modified by Agalya for excelupload relogin error was came for spp ref no- FALCONQC-1715615
				
				row = (HSSFRow) rows.next();
				PW1 = new ArrayList<Object>(M_END_COL);
				
				// Index iterator
				if(row!=null && !row.equals("")){
				for(int index=0, size=row.getLastCellNum(); index<size; index++){
					cell =   row.getCell((short)index);
					PW1.add(validateAndRetriveExcelData(cell,  row.getRowNum(), index, 
								"UPLOAD", "ERRORREF" ));
					 	
				}
				rs_seq = handler.executeSelectStatement(seqquery, connection);
				if(rs_seq.next()){
					sys_ud_sys_id = rs_seq.getLong(1);
				}
				}
				System.out.println(row.getRowNum()+"=num="+row.getFirstCellNum()+"FIRST -- LAST "+row.getLastCellNum()+PW1.size()+" PW1 VALUES "+PW1);
			 	obj = new Object[]{ 
			 			sys_ud_sys_id,
							PW1.get(0),
							PW1.get(1),
							PW1.get(2),
							PW1.get(3)
							/*PW1.get(4),*/
							/*PW1.get(5),
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
							PW1.get(41),
							PW1.get(42),
							PW1.get(43),
							PW1.get(44),
							PW1.get(45),
							PW1.get(46),
							PW1.get(47),
							PW1.get(48),
							PW1.get(49),
							PW1.get(51),
							PW1.get(52)*/ };
			 	
			 	/*if( row.getRowNum()==1){
				 	rsChkExist = handler.executeSelectStatement(chkExsit,
				 	   			           					connection, new Object[]{PW1.get(10)});
				 	
				 	while(rsChkExist.next()){
				 		if(PW1.get(0).equals( rsChkExist.getString(1)) &&
				 							PW1.get(10).equals( rsChkExist.getString(2))){
				 			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"92269",
				 			      new Object[] { "Excel is already uploaded."  }));
				 		}else{
				 			//if("PGLT002".equals(CommonUtils.getGlobalVariable("CALLING_FORM"))){
				 			//	CommonUtils.setGlobalVariable("GLOBAL.REF_NO",PW1.get(10).toString());
				 			//}
				 		}
				 	}
				 	CommonUtils.setGlobalVariable("GLOBAL.REF_NO",PW1.get(10).toString()); 
			 	}*/
			 /*	handler.executeDeleteStatement(deleteQuery, connection);
			 	*/
			 	status= handler.executeInsertStatement(  INSERT_INTO_PW_IL_UPLOAD_DATA,
							connection,obj); 
			 	//System.out.println(INSERT_INTO_PW_GL_EMP_UPLOAD+" Obj VALUE "+obj);
			 	status+=status;
			}
			CommonUtils.doComitt();
			 
			//Log is commented
			/*resultSet = handler.executeSelectStatement(UPLOAD_QUERYCONSTANTS.GET_ERROR_LOG_QUERY, 
					connection );*/
			/* if(status >0){
				 	PP_UPLOAD_FILE_DTLS_ACTION_BEAN.setPROCESS_DISABLE(false);
					PP_UPLOAD_FILE_DTLS_ACTION_BEAN.getWarningMap().put("SAVE",
					         Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
					PP_UPLOAD_FILE_DTLS_ACTION_BEAN.getWarningMap().put(
					           PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					           Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
			 }
			 else if(status==0){
				 PP_UPLOAD_FILE_DTLS_ACTION_BEAN.getWarningMap().put("SAVE",
				      Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$upload$failed"));
				 PP_UPLOAD_FILE_DTLS_ACTION_BEAN.getWarningMap().put(
				      PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				       Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$upload$failed"));
				                        			
			 }*/
		 
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

		//System.out.println("COL NUM "+columnNumber +" cellNumber < 37 "+ (cellNumber < 37));
		if(cellNumber < 5){
			switch (cellNumber){
			case 0:
				value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
				break;
			case 1:
				value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
				break;
				case 2:
				
				/*commented by R Raja on 22-02-2017 for Upload Issue*/
				//value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
				value = CommonUtils.dateToStringFormat(getDateValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef ));
				/*commented by R Raja on 22-02-2017 for Upload Issue*/
				//value = CommonUtils.dateToStringFormat(getDateValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef ));
				
				/*end*/
				break;
				
				/*changed by raja on 03-03-2017*/
				
			/*case 3:
				value = getNumericIntegerValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
				break;*/
				
			case 3:
				value = getNumericDoubleValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
				break;
				
				/*end*/
			case 4:
				value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
				break;
			/*case 5:
				value = CommonUtils.dateToStringFormat(getDateValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef ));
				break;
			case 6:	
				value = CommonUtils.dateToStringFormat(getDateValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef ));
				break;	
			case 7:
				value = getNumericIntegerValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
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
			case 34:{
				value = CommonUtils.dateToStringFormat(getDateValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef ));
				if(value==null)
					value=null;
				break;	
			}
			case 35:
				value = getNumericIntegerValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
				break;
			case 36:
				value = getNumericIntegerValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
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
				value = getNumericIntegerValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
				break;
			case 41:	
				value = getStringValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
				break;
			case 42:	
				value = CommonUtils.dateToStringFormat(getDateValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef ));
				break;
			case 43:	
				value = getNumericIntegerValueOfCell(cell, rowNumber,columnNumber, true, riskId, errorRef );
				break;*/
			default:
				break;
			}
		 
	} 
	//System.out.println(" COL NUM " +cellNumber + " CELL VALUE "+value);
	
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
	
//	ADDED BY SANKARA NARAYANAN FOR csv upload

	 public String acceptiletype(String Fname) {
	       String exten=null;
	       exten =Fname.substring(Fname.indexOf(".")+1, Fname.length()).toUpperCase();
	       return exten;
	       
	     }//end
		
		@SuppressWarnings("unchecked")
		private String INSERT_CSV_PW_TABLE(File file,PW_IL_UPLOAD_FILE_DTLS_ACTION PW_IL_UPLOAD_FILE_DTLS_ACTION_BEAN)
		throws Exception {

			
			 BufferedReader br = null;
		    String line = "";
			ResultSet resultSet = null,rsChkExist=null;
			Connection connection = null;
			CRUDHandler handler = null;
			Long sys_ud_sys_id = null;
			Object[] obj = null;
			
			ResultSet rs_seq = null;
			String seqquery = "SELECT SEQ_UD_SYS_ID.NEXTVAL " +
										"FROM DUAL";
			String deleteQuery = "DELETE FROM PW_IL_UPLOAD_DATA";
			String deleteErrorLog= "DELETE FROM PT_IL_CHECK_OFF_TRANS_DTL";
			String INSERT_INTO_PW_IL_UPLOAD_DATA = "INSERT INTO PW_IL_UPLOAD_DATA  (UD_SYS_ID,UD_FLEX_01," +
					"  UD_FLEX_02,  UD_FLEX_03,  UD_FLEX_04) VALUES " +
					"	(?,?,?,?, ?) ";
			try
			{ 	connection = CommonUtils.getConnection();
				handler = new CRUDHandler();
				  br = new BufferedReader(new FileReader(file));
		          br.readLine();
				int status=0;
				handler.executeDeleteStatement(deleteQuery, connection);
				connection.commit();
				handler.executeDeleteStatement(deleteErrorLog, connection);
				connection.commit();
			 while ((line = br.readLine()) != null) {
				 String[] Data = line.split(",");
					rs_seq = handler.executeSelectStatement(seqquery, connection);
					if(rs_seq.next()){
						sys_ud_sys_id = rs_seq.getLong(1);
					}
					
				 	obj = new Object[]{ 
				 			sys_ud_sys_id,
				 				Data[0],
				 				Data[1],
				 				Data[2],
				 				Data[3],
				 				/*Data[4],
								Data[5],
								Data[6],
								Data[7],
								Data[8],
								Data[9],
								Data[10],
								Data[11],
								Data[12],
								Data[13],
								Data[14],
								Data[15],
								Data[16],
								Data[17],
								Data[18],
								Data[19],
								Data[20],
								Data[21],
								Data[22],
								Data[23],
								Data[24],
								Data[25],
								Data[26],
								Data[27],
								Data[28],
								Data[29],
								Data[30],
								Data[31],
								Data[32],
								Data[33],
								Data[34],
								Data[35],
								Data[36],
								Data[37],
								Data[38],
								Data[39],
								Data[40],
								Data[41],
								Data[42],
								Data[43],
								Data[44],
								Data[45],
								Data[46],
								Data[47],
								Data[48],
								Data[49],
								Data[51],
								Data[52]*/ };
				 
				 	status= handler.executeInsertStatement(  INSERT_INTO_PW_IL_UPLOAD_DATA,
								connection,obj); 
				 	
				 	status+=status;
				}
				CommonUtils.doComitt();
				 
		
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
		
		/*END*/
		
			
		private void INSERT_CSV_PW_PROC(File file,PW_IL_UPLOAD_FILE_DTLS_ACTION PW_IL_UPLOAD_FILE_DTLS_ACTION_BEAN)
				throws Exception {

			BufferedReader br = null;
		    String line = "";
			//ResultSet resultSet = null, rsChkExist = null;
			Connection connection = null;
			CRUDHandler handler = null;
			ResultSet rs_seq=null;
		
			try {
				connection = CommonUtils.getConnection();
				handler = new CRUDHandler();
			  int rowCount = 0;
				String chkExsit = " select UD_SYS_ID,UD_REFF_NO from PW_IL_UPLOAD_DATA WHERE UD_REFF_NO=? ";
				String seqquery = "SELECT SEQ_UD_SYS_ID.NEXTVAL " +
						"FROM DUAL";
				Object[] obj = null;
				Long sys_ud_sys_id=null;
				
				long excelReadStartTime = System.nanoTime();
				
				ArrayDescriptor arrayDescriptor = ArrayDescriptor.createDescriptor("TAB_IL_EMP", connection);
				StructDescriptor recDescriptor = StructDescriptor.createDescriptor("OBJ_IL_EMP", connection);			
				 br = new BufferedReader(new FileReader(file));
		          br.readLine();
		          int linenumber = 0;
  	            while (br.readLine() != null){
  	        	linenumber++;
  	            }
  	            br.close();
  	          br = new BufferedReader(new FileReader(file));
  	        br.readLine();
				Object[] array_of_records = new Object[linenumber];
				ArrayList<PW_IL_UPLOAD_DATA> DataList =  new ArrayList<PW_IL_UPLOAD_DATA>(linenumber);
				/*Moved outside the loop by ganesh on 26-12-2017 for upload performance issue*/
				Object[] dummyObject = new Object[]{};
				 STRUCT oracle_record =null;
				String[] Data = null;
				 rs_seq = handler.executeSelectStatement(seqquery, connection, dummyObject);
					if(rs_seq.next()){
						sys_ud_sys_id = rs_seq.getLong(1);
					}
				rs_seq.close();
				/*end*/
				 while ((line = br.readLine()) != null) {
					  Data = line.split(",");					 
						DataList.add(assignBeanValues(Data));
						sys_ud_sys_id +=1;
						obj = new Object[] {
								sys_ud_sys_id	,
								DataList.get(rowCount).getUD_REFF_NO()	,
								DataList.get(rowCount).getUD_FLEX_01()	,
								DataList.get(rowCount).getUD_FLEX_02()	,
								DataList.get(rowCount).getUD_FLEX_03()	,
								DataList.get(rowCount).getUD_FLEX_04()	,
								DataList.get(rowCount).getUD_FLEX_05()	,
								DataList.get(rowCount).getUD_FLEX_06()	,
								DataList.get(rowCount).getUD_FLEX_07()	,
								DataList.get(rowCount).getUD_FLEX_08()	,
								DataList.get(rowCount).getUD_FLEX_09()	,
								DataList.get(rowCount).getUD_FLEX_10()	,
								DataList.get(rowCount).getUD_FLEX_11()	,
								DataList.get(rowCount).getUD_FLEX_12()	,
								DataList.get(rowCount).getUD_FLEX_13()	,
								DataList.get(rowCount).getUD_FLEX_14()	,
								DataList.get(rowCount).getUD_FLEX_15()	,
								DataList.get(rowCount).getUD_FLEX_16()	,
								DataList.get(rowCount).getUD_FLEX_17()	,
								DataList.get(rowCount).getUD_FLEX_18()	,
								DataList.get(rowCount).getUD_FLEX_19()	,
								DataList.get(rowCount).getUD_FLEX_20()	
						};
					 
						/*Commented by ganesh on 26-12-2017 for upload performance issue */
						/*rsChkExist = handler.executeSelectStatement(chkExsit,
								connection, new Object[] { DataList.get(0).getUD_REFF_NO() });

						if (rsChkExist.next()) {
							throw new Exception(
									Messages.getString(
											PELConstants.pelErrorMessagePath,
											"92269",
											new Object[] { "Kindly check the Reference number column same as already uploaded" }));

						}
						rsChkExist.close();*/
					
				  oracle_record = new STRUCT(recDescriptor, connection, obj);
					array_of_records[rowCount] = oracle_record;
					rowCount += 1;
			}
				 long excelReadEndTime = System.nanoTime();
				 System.out.println("Excel Elapsed time in milliseconds:-->"+(excelReadEndTime-excelReadStartTime)/1000000);
				ARRAY oracle_array = new ARRAY(arrayDescriptor, connection, array_of_records);

				/*Modified by Janani on 24.07.2018 for FLA dynamic upload issues,as suggested by Chandramohan*/
				//CALL_INSERT_PROC(oracle_array, connection);
				
				CALL_INSERT_PROC(oracle_array,
						CommonUtils.getGlobalObject("UI_M_MAP_CODE"),
						connection);
				
				/*End*/
				
				connection.commit();
				long insertDBTime = System.nanoTime();
				 System.out.println("Database Elapsed time in milliseconds:-->"+(insertDBTime-excelReadEndTime)/1000000);
			

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
				/*CommonUtils.closeCursor(resultSet);
				CommonUtils.closeCursor(rsChkExist);*/
				CommonUtils.closeCursor(rs_seq);
				if(br!=null){
					br.close();
				}
			}
			//return "";

		}
		
		
		
		/* Newly Added by Dhinesh on 29-06-2018 for FLA - RM018T - FSD_IL_FLA_004-Common Data Upload-R1_final */
		
		private void INSERT_TXT_PW_PROC(File file,PW_IL_UPLOAD_FILE_DTLS_ACTION PW_IL_UPLOAD_FILE_DTLS_ACTION_BEAN)
				throws Exception {

			BufferedReader br = null;
		    String line = "";
			//ResultSet resultSet = null, rsChkExist = null;
			Connection connection = null;
			CRUDHandler handler = null;
			ResultSet rs_seq=null;
		
			try {
				connection = CommonUtils.getConnection();
				handler = new CRUDHandler();
			  int rowCount = 0;
				String chkExsit = " select UD_SYS_ID,UD_REFF_NO from PW_IL_UPLOAD_DATA WHERE UD_REFF_NO=? ";
				String seqquery = "SELECT SEQ_UD_SYS_ID.NEXTVAL " +
						"FROM DUAL";
				Object[] obj = null;
				Long sys_ud_sys_id=null;
				
				long excelReadStartTime = System.nanoTime();
				
				ArrayDescriptor arrayDescriptor = ArrayDescriptor.createDescriptor("TAB_IL_EMP", connection);
				StructDescriptor recDescriptor = StructDescriptor.createDescriptor("OBJ_IL_EMP", connection);			
				 br = new BufferedReader(new FileReader(file));
		          br.readLine();
		          int linenumber = 0;
  	            while (br.readLine() != null){
  	        	linenumber++;
  	            }
  	            br.close();
  	          br = new BufferedReader(new FileReader(file));
  	        br.readLine();
				Object[] array_of_records = new Object[linenumber];
				ArrayList<PW_IL_UPLOAD_DATA> DataList =  new ArrayList<PW_IL_UPLOAD_DATA>(linenumber);
				Object[] dummyObject = new Object[]{};
				 STRUCT oracle_record =null;
				String[] Data = null;
				 rs_seq = handler.executeSelectStatement(seqquery, connection, dummyObject);
					if(rs_seq.next()){
						sys_ud_sys_id = rs_seq.getLong(1);
					}
				rs_seq.close();
				 while ((line = br.readLine()) != null) {
					  Data = line.split(",");					 
						DataList.add(assignBeanValues(Data));
						sys_ud_sys_id +=1;
						obj = new Object[] {
								sys_ud_sys_id	,
								DataList.get(rowCount).getUD_REFF_NO()	,
								DataList.get(rowCount).getUD_FLEX_01()	,
								DataList.get(rowCount).getUD_FLEX_02()	,
								DataList.get(rowCount).getUD_FLEX_03()	,
								DataList.get(rowCount).getUD_FLEX_04()	,
								DataList.get(rowCount).getUD_FLEX_05()	,
								DataList.get(rowCount).getUD_FLEX_06()	,
								DataList.get(rowCount).getUD_FLEX_07()	,
								DataList.get(rowCount).getUD_FLEX_08()	,
								DataList.get(rowCount).getUD_FLEX_09()	,
								DataList.get(rowCount).getUD_FLEX_10()	,
								DataList.get(rowCount).getUD_FLEX_11()	,
								DataList.get(rowCount).getUD_FLEX_12()	,
								DataList.get(rowCount).getUD_FLEX_13()	,
								DataList.get(rowCount).getUD_FLEX_14()	,
								DataList.get(rowCount).getUD_FLEX_15()	,
								DataList.get(rowCount).getUD_FLEX_16()	,
								DataList.get(rowCount).getUD_FLEX_17()	,
								DataList.get(rowCount).getUD_FLEX_18()	,
								DataList.get(rowCount).getUD_FLEX_19()	,
								DataList.get(rowCount).getUD_FLEX_20()	
						};
					 
					
				  oracle_record = new STRUCT(recDescriptor, connection, obj);
					array_of_records[rowCount] = oracle_record;
					rowCount += 1;
			}
				 long excelReadEndTime = System.nanoTime();
				 System.out.println("Excel Elapsed time in milliseconds:-->"+(excelReadEndTime-excelReadStartTime)/1000000);
				ARRAY oracle_array = new ARRAY(arrayDescriptor, connection, array_of_records);
				
				
				/*Modified by Janani on 24.07.2018 for FLA dynamic upload issues,as suggested by Chandramohan*/
				//CALL_INSERT_PROC(oracle_array, connection);
				
				CALL_INSERT_PROC(oracle_array,
						CommonUtils.getGlobalObject("UI_M_MAP_CODE"),
						connection);
				
				/*End*/
				
				connection.commit();
				long insertDBTime = System.nanoTime();
				 System.out.println("Database Elapsed time in milliseconds:-->"+(insertDBTime-excelReadEndTime)/1000000);
			

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
				
				CommonUtils.closeCursor(rs_seq);
				if(br!=null){
					br.close();
				}
			}

		}
		/* End */

		/*public ARRAY getConvertToORACLEARRAY(String Descriptor,List objList) throws SQLException, IllegalArgumentException, IllegalAccessException{
			
			Object[] objArr = getCovertToObjectArr(objList);
			
			ArrayDescriptor descrip = ArrayDescriptor.createDescriptor(
					Descriptor, springDAO.getDataSourceConn());
			
			ARRAY oracleArray = new ARRAY(descrip, springDAO.getDataSourceConn(), objArr);
			
			return oracleArray;
			
		}*/

		private Object[] getCovertToObjectArr(List objList) throws IllegalArgumentException, IllegalAccessException {
			// TODO Auto-generated method stub
			
			Object[] objColumn = null;
			Object[] objRow = new Object[objList.size()];
			
			for (int row=0; row< objList.size(); row++) {
				
				Object arrobj = (Object)objList.get(row);			
						
				Class classObj = arrobj.getClass();
				Field[] fields = classObj.getDeclaredFields();
				objColumn = new Object[fields.length];
				int i = 0;
				for(Field field: fields){
					field.setAccessible(true);
					
					objColumn[i] = field.get(arrobj);
					i++;	
				}
					
				objRow[row]=arrobj;			
				
			}		
			return objRow;
		}
		
		//END
}