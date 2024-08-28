package com.iii.pel.forms.MailManager;

import java.io.BufferedReader;
import org.apache.poi.ss.usermodel.Row;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.ConnectionManager;
import com.iii.apps.persistence.PremiaCryptograph;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

/**
 * Servlet implementation class CsvDownloader
 */
public class CsvDownloader extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<String> headercaptionList =null;
	private final static ResourceBundle resourceBundleDatabase = ResourceBundle
			.getBundle("login");
	String DataQuery=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CsvDownloader() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub





		String File_Type=request.getParameter("FILE_TYPE");
		String fileName=request.getParameter("FILE_NAME");
		String Member_Id=request.getParameter("MAP_ID");
		try {
			if("CSV".equalsIgnoreCase(File_Type)){
				StringBuffer bos;

				bos = createCSV(Member_Id);
				writeCSVToResponse(response, bos, fileName);	



			}	/* Newly Added by Dhinesh on 29-06-2018 for FLA - RM018T - FSD_IL_FLA_004-Common Data Upload-R1_final */
			else if("txt".equalsIgnoreCase(File_Type)){
				StringBuffer bos;

				bos = createText(Member_Id);
				writeResponse_To_Text(response, bos, fileName);	
				
				/* End */

			}else{
				HSSFWorkbook wb;
				wb=createXLS(Member_Id,fileName);
				writeExcelToResponse(response,	wb,fileName);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void writeExcelToResponse(HttpServletResponse response,
			HSSFWorkbook generatedExcel, String filename) throws IOException {


		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Expires", "0");
		response.setHeader("Cache-Control",
				"must-revalidate, post-check=0, pre-check=0");
		response.setHeader("Pragma", "public");
		response.setHeader("Content-disposition",
				"attachment;filename=" + filename + ".xls");
	/*	response.addCookie(Constants.DOWNLOAD_COOKIE, "true",
				new HashMap<String, Object>());*/
		OutputStream out = response.getOutputStream();
		generatedExcel.write(out);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		generatedExcel.write(baos);
		//baosMap.put(filename + ".xlsx", baos);
		response.flushBuffer();
	}

	public Connection getJDBCConnection() throws  Exception {
		Connection dbCon=null;
		String userName = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, resourceBundleDatabase.getString("login_db_user_name"));
		String passWord = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, resourceBundleDatabase.getString("login_db_password"));
		String jdbcURL = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, resourceBundleDatabase.getString("login_db_url"));
		String jdbcDriver = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, resourceBundleDatabase.getString("jdbc.datasource.driver"));
	
		
		try{
			Class.forName(jdbcDriver);
			dbCon = DriverManager.getConnection(jdbcURL,userName,passWord);
			dbCon.setAutoCommit(false);
		
		}catch(Exception e){
			
			
			e.printStackTrace();
		}
		return dbCon;
	}
	public StringBuffer createCSV(String memb_id) throws Exception{
		int decimal =0;
		Connection con = null;
		String DecimalformatQuery ="SELECT COL_CURR_FORMAT  FROM REP_COLS WHERE COL_NAME = ? AND REP_SYS_ID =?";
		StringBuffer writer = new StringBuffer();
		CRUDHandler handler = new CRUDHandler();
		con = getJDBCConnection(); 
	
		ResultSet rs1= null;
		headercaptionList=getHeader(memb_id);
		DataQuery=getDataQuery(headercaptionList.size());
		DataQuery = DataQuery+" FROM PW_IL_DOWNLOAD_DATA";
		for (String pcol1 : headercaptionList) {
			writer.append(pcol1);
			writer.append(',');
		}writer.append('\n');

		rs1 = handler.executeSelectStatement(DataQuery, con);
		int columCount;
		columCount = rs1.getMetaData().getColumnCount();
		while (rs1.next()) {
			//writer.append(rs1.getString("DOW_REF_NO")==null ? "" : rs1.getString("DOW_REF_NO")+",");
			for(int i=1;i<=columCount;i++){
				
				/*Modified by Janani on 05.02.2018 for priority2 issue*/
				//writer.append(rs1.getString(i)==null ? "": rs1.getString(i)+",");
				writer.append(rs1.getString(i)==null ? ""+"," : rs1.getString(i)+",");
				/*End*/
			}
			writer.append("\n");
		}
		

				/*writer.append(jsonHasMap.get(i).get(
						pcol1) !=null?jsonHasMap.get(i).get(
						pcol1).toString():"");
				writer.append(',');
			*/
			writer.append('\n');
			
			return writer;
		}
	
	/* Newly Added by Dhinesh on 29-06-2018 for FLA - RM018T - FSD_IL_FLA_004-Common Data Upload-R1_final */
	public StringBuffer createText(String memb_id) throws Exception{
		int decimal =0;
		Connection con = null;
		String DecimalformatQuery ="SELECT COL_CURR_FORMAT  FROM REP_COLS WHERE COL_NAME = ? AND REP_SYS_ID =?";
		StringBuffer writer = new StringBuffer();
		CRUDHandler handler = new CRUDHandler();
		con = getJDBCConnection(); 

		ResultSet rs1= null;
		headercaptionList=getHeader(memb_id);
		DataQuery=getDataQuery(headercaptionList.size());
		DataQuery = DataQuery+" FROM PW_IL_DOWNLOAD_DATA";
		for (String pcol1 : headercaptionList) {
			writer.append(pcol1);
			writer.append(',');
		}writer.append('\n');

		rs1 = handler.executeSelectStatement(DataQuery, con);
		int columCount;
		columCount = rs1.getMetaData().getColumnCount();
		while (rs1.next()) {
			for(int i=1;i<=columCount;i++){
				writer.append(rs1.getString(i)==null ? ""+"," : rs1.getString(i)+",");
			}
			writer.append("\n");
		}
		writer.append('\n');

		return writer;
	}
	
	/* End */
	
	private String getDataQuery(int size) {
		String DB_Query="SELECT DOW_REF_NO,";
		
		for(int i=1;i<=size;i++){
			DB_Query=DB_Query+" DOW_FIELD_"+i+",";
		}
		DB_Query=DB_Query.substring(0, DB_Query.length()-1);
		return DB_Query;
		
		
		
	}
	
	
	
	
	private List<String> getHeader(String memb_id) throws Exception{
		Connection con = null;
		String C1 ="SELECT * FROM PM_IL_DATA_UPLOAD_MAPPING WHERE DUM_MAP_CODE=?";
		String C2="SELECT DUDD_PARA_NAME FROM PM_IL_DATA_UPLOAD_DEFN_DTL WHERE DUDD_PARA_TYPE = 'P' AND DUDD_DUDH_DEF_CODE=? AND DUDD_SERIAL_NO=?";
		ResultSet rs1= null, rs2= null;
		List<String> columnlist= new ArrayList<String>();
		CRUDHandler handler = new CRUDHandler();
		 con = getJDBCConnection(); 
		rs1 = handler.executeSelectStatement(C1, con,
				new Object[] { memb_id });
		if(rs1.next()){
			columnlist.add("Reference No");
			String DUM_DEF_CODE=rs1.getString("DUM_DEF_CODE");
			for(int i=1;i<=20;i++){

				String Column_name="DUM_FIELD_"+(i<=9?String.format("%02d", i):String.valueOf(i));

				if(!("0".equalsIgnoreCase(rs1.getString(Column_name)))){

					rs2 = handler.executeSelectStatement(C2, con,
							new Object[] { DUM_DEF_CODE,rs1.getString(Column_name) });
					if(rs2.next()){
						columnlist.add(rs2.getString("DUDD_PARA_NAME"));
					}

				}
			}
		}
		return columnlist;

	}
		
	
	private void writeCSVToResponse(HttpServletResponse response,
			StringBuffer baos, String fileName) {
		try {
			response.reset();
			response.setContentType("text/csv");
			response.setHeader("Expires", "0");
			response.setHeader("Cache-Control",
					"must-revalidate, post-check=0, pre-check=0");
			response.setHeader("Pragma", "public");
			response.setHeader("Content-disposition",
					"attachment;filename=" + fileName + ".csv");
			response.setContentLength(baos.length());
			InputStream in  =  new ByteArrayInputStream(baos.toString().getBytes());
			OutputStream out = response.getOutputStream();
			  byte[] outputByte = new byte[4096];
			  while(in.read(outputByte, 0, 4096) != -1)
				{
					out.write(outputByte, 0, 4096);
				}
			  in.close();
				out.flush();
				out.close();
				response.flushBuffer();			
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
	
	/* Newly Added by Dhinesh on 29-06-2018 for FLA - RM018T - FSD_IL_FLA_004-Common Data Upload-R1_final */
	
	private void writeResponse_To_Text(HttpServletResponse response,
			StringBuffer baos, String fileName) {
		try {
			response.reset();
			response.setContentType("text/csv");
			response.setHeader("Expires", "0");
			response.setHeader("Cache-Control",
					"must-revalidate, post-check=0, pre-check=0");
			response.setHeader("Pragma", "public");
			response.setHeader("Content-disposition",
					"attachment;filename=" + fileName + ".txt");
			response.setContentLength(baos.length());
			InputStream in  =  new ByteArrayInputStream(baos.toString().getBytes());
			OutputStream out = response.getOutputStream();
			  byte[] outputByte = new byte[4096];
			  while(in.read(outputByte, 0, 4096) != -1)
				{
					out.write(outputByte, 0, 4096);
				}
			  in.close();
				out.flush();
				out.close();
				response.flushBuffer();			
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	/* End */

	/*
	 * 
	 * Commented By Dhinesh on 2/11/2017 
	 * 
	 * public HSSFWorkbook createXLS(String memb_id,String fileName) throws Exception{

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(fileName);
		sheet.setMargin(Sheet.LeftMargin,1); //REP_FORMAT_BEAN.getRFT_MARGIN_LEFT()
		sheet.setMargin(Sheet.RightMargin,1); //REP_FORMAT_BEAN.getRFT_MARGIN_RIGHT()
		sheet.setMargin(Sheet.TopMargin,1);//REP_FORMAT_BEAN.getRFT_MARGIN_TOP()
		sheet.setMargin(Sheet.BottomMargin,1);//REP_FORMAT_BEAN.getRFT_MARGIN_BOTTOM()
		wb.setSheetName(wb.getSheetIndex(fileName), fileName);
		String datacolumnStyle[] ="Calibri,11,Bold".split(","); // REP_FORMAT_BEAN.getRFT_COLUMN_FONT_STYLE()
		String datafc_color[] = "0,0,0".split(",");//REP_FORMAT_BEAN.getRFT_COLUMN_FORE_COLOR()

		String headPropStyle[] = "Calibri,12,Bold".split(",");//REP_FORMAT_BEAN.getRFT_REP_HEAD_FONT_STYLE()
		String f_color[] = "255,0,0".split(","); //REP_FORMAT_BEAN.getRFT_REP_HEAD_FORE_COLOR()

		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		HSSFFont font = wb.createFont();
		font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
		font.setFontHeightInPoints(Short.parseShort("12"));
		if ("Bold".equals(headPropStyle[2])) {
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		} else {
			font.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
		}
		cellStyle.setFont(font);
		HSSFCell cell = null;
		HSSFRow row1 ;
		int count = 0;
		int i=-1;
		String columnStyle[] = "Calibri,11,Bold".split(","); //REP_FORMAT_BEAN.getRFT_COLUMN_FONT_STYLE()
		String fc_color[] ="0,0,0".split(","); //REP_FORMAT_BEAN.getRFT_COLUMN_FORE_COLOR()
		HSSFCellStyle colDetailcellStyle = wb.createCellStyle();
		font = wb.createFont();
		font.setFontName(columnStyle[0]);
		if ("Bold".equals(columnStyle[2])) {
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		} else {
			font.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
		}
		headercaptionList=getHeader(memb_id);
		DataQuery=getDataQuery(headercaptionList.size());
		DataQuery = DataQuery+" FROM PW_IL_DOWNLOAD_DATA";
		colDetailcellStyle.setFont(font);
		for (String p1 : headercaptionList) {
			cell = cdetail.createCell(j);
			cell.setCellValue(p1);
			cell.setCellStyle(colDetailcellStyle);
			j++;
		}
		HSSFRow cheader = sheet.createRow(i + 1);
		short col=0;
		short WID=5000;
		for (String val: headercaptionList) {
			if (!val.equals("")) {
				sheet.autoSizeColumn(col);
				cell = cheader.createCell(col);
				cell.setCellValue(val);
				cellStyle = wb.createCellStyle();
				font = wb.createFont();
				font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
				font.setFontHeightInPoints(Short.parseShort("12"));
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				cellStyle.setFont(font);
				cell.setCellStyle(cellStyle);
				sheet.setColumnWidth(col, WID);
			}
			col++;
		}
		i = i + 1;
		cheader = sheet.createRow(i++);   // moved by sankaranarayanan for remove extra line
		CRUDHandler handler = new CRUDHandler();
		Connection con = getJDBCConnection(); 
		ResultSet rs1= null;
		rs1 = handler.executeSelectStatement(DataQuery, con);
		int columCount;
		columCount = rs1.getMetaData().getColumnCount();
		while (rs1.next()) {
			col=0;
			cheader = sheet.createRow(i++);
			for(int cr=1;cr<=columCount;cr++){
				sheet.autoSizeColumn(col);
				cell = cheader.createCell(col);
				cell.setCellValue(rs1.getString(cr)==null ? "" : rs1.getString(cr));
				cellStyle = wb.createCellStyle();
				font = wb.createFont();
				font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
				font.setFontHeightInPoints(Short.parseShort("12"));
				cellStyle.setFont(font);
				cell.setCellStyle(cellStyle);
				sheet.setColumnWidth(col, WID);
				col++;
			}
			
		}
		return wb;
	} */
	
	
	
	
	
	
	public HSSFWorkbook createXLS(String memb_id,String fileName) throws Exception
	{

		headercaptionList=getHeader(memb_id);
		DataQuery=getDataQuery(headercaptionList.size());
		DataQuery = DataQuery+" FROM PW_IL_DOWNLOAD_DATA";
		
		Workbook workbook = (Workbook) new HSSFWorkbook();

		Sheet studentsSheet = workbook.createSheet(fileName);
		int rowIndex = 0;
		int cellIndex = 0;
		
		Row row = null;
		row = studentsSheet.createRow(rowIndex++);
		for(int cr=0;cr<headercaptionList.size();cr++)
		{
			row.createCell(cellIndex++).setCellValue(headercaptionList.get(cr));
		}
		cellIndex = 0;
		
		CRUDHandler handler = new CRUDHandler();
		Connection con = getJDBCConnection(); 
		ResultSet rs1= null;
		rs1 = handler.executeSelectStatement(DataQuery, con);
		int columCount;
		columCount = rs1.getMetaData().getColumnCount();
		while(rs1.next())
		{
			row = studentsSheet.createRow(rowIndex++);
			for(int cr=1;cr<columCount;cr++)
			{
				row.createCell(cellIndex++).setCellValue(rs1.getString(cr)==null ? "" : rs1.getString(cr));
			}
			cellIndex = 0;
            
		}
		
		
		return (HSSFWorkbook) workbook;
	} 
	
	
}
