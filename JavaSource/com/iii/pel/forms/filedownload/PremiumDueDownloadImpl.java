package com.iii.pel.forms.filedownload;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PremiumDueDownloadImpl implements FileDownload {
	List<String> headercaptionList = null;
	String DataQuery = null;
	

	public void writeCSVToResponse(HttpServletResponse response,
			StringBuffer baos, String fileName, Connection connection) {
		ResultSet rstPath = null;
		BufferedWriter out = null;
		FileInputStream inStream = null;
		OutputStream outStream = null;
		File theDir = null;
		try {
			String pathPDD = null;
			String pathQuery = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = ?";

			rstPath = new CRUDHandler().executeSelectStatement(pathQuery,
					connection, new Object[] { "EOD_REP_PATH" });

			if (rstPath.next()) {
				pathPDD = rstPath.getString(1);
				theDir = new File(pathPDD);
				if (!theDir.exists()) {
					try {
						theDir.mkdir();

					} catch (SecurityException se) {
						se.printStackTrace();
					}

				}

				theDir = new File(pathPDD+ File.separator + fileName);
				out = new BufferedWriter(new FileWriter(theDir, false));
				out.write(baos.toString());
				out.close();

				inStream = new FileInputStream(theDir);
				response.setContentType("text/csv");
				response.setHeader("Content-disposition",
						"attachment;filename=" + fileName);
				outStream = response.getOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				while ((bytesRead = inStream.read(buffer)) != -1) {
					outStream.write(buffer, 0, bytesRead);
				}

				inStream.close();
				outStream.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (out != null) {
					out.close();
				}
				if (inStream != null) {
					inStream.close();
				}
				if (outStream != null) {
					outStream.close();
				}
				CommonUtils.closeCursor(rstPath);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public void createCSV(String fileName, HttpServletRequest request, HttpServletResponse response) {

		Connection con = null;
		StringBuffer writer = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs1 = null;
		String memb_id = null;
		ResultSet totalResultSet = null;
		int columCount;
		try {

			System.out.println("Premium Due Download generation...");
			con = DBUtils.getJDBCConnection();
			String mainQuery = "SELECT DISTINCT(DOW_FIELD_1),DOW_MAP_CODE FROM PW_IL_DOWNLOAD_DATA";

			totalResultSet = handler.executeSelectStatement(mainQuery, con);

			while (totalResultSet.next()) {
				writer = new StringBuffer();
				memb_id = totalResultSet.getString(2);
				headercaptionList = getHeader(memb_id,con);
				DataQuery = getDataQuery(headercaptionList.size());
				DataQuery = DataQuery + " FROM PW_IL_DOWNLOAD_DATA WHERE DOW_FIELD_1 = ? AND DOW_MAP_CODE = ?";
				for (String pcol1 : headercaptionList) {
					writer.append(pcol1);
					writer.append(',');
				}
				writer.append('\n');

				rs1 = handler.executeSelectStatement(DataQuery, con, new Object[]{totalResultSet.getString(1), totalResultSet.getString(2)});
				
				columCount = rs1.getMetaData().getColumnCount();
				while (rs1.next()) {
					for (int i = 1; i <= columCount; i++) {
						writer.append(rs1.getString(i) == null ? "" + "," : rs1
								.getString(i) + ",");
					}
					writer.append("\n");
				}

				writer.append('\n');
				writeCSVToResponse(response, writer,
						totalResultSet.getString(2) + "_" + fileName, con);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(totalResultSet);
				if(con!=null){
					con.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}

	private List<String> getHeader(String memb_id,Connection con){
		String C1 = "SELECT * FROM PM_IL_DATA_UPLOAD_MAPPING WHERE DUM_MAP_CODE=?";
		String C2 = "SELECT DUDD_PARA_NAME FROM PM_IL_DATA_UPLOAD_DEFN_DTL WHERE DUDD_PARA_TYPE = 'P' AND DUDD_DUDH_DEF_CODE=? AND DUDD_SERIAL_NO=?";
		ResultSet rs1 = null, rs2 = null;
		List<String> columnlist = new ArrayList<String>();
		CRUDHandler handler = new CRUDHandler();
		try{
		rs1 = handler.executeSelectStatement(C1, con, new Object[] { memb_id });
		if (rs1.next()) {
			columnlist.add("Reference No");
			String DUM_DEF_CODE = rs1.getString("DUM_DEF_CODE");
			for (int i = 1; i <= 20; i++) {

				String Column_name = "DUM_FIELD_"
						+ (i <= 9 ? String.format("%02d", i) : String
								.valueOf(i));

				if (!("0".equalsIgnoreCase(rs1.getString(Column_name)))) {

					rs2 = handler.executeSelectStatement(C2, con, new Object[] {
							DUM_DEF_CODE, rs1.getString(Column_name) });
					if (rs2.next()) {
						columnlist.add(rs2.getString("DUDD_PARA_NAME"));
					}

				}
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return columnlist;

	}

	private String getDataQuery(int size) {
		String DB_Query = "SELECT DOW_REF_NO,";

		for (int i = 1; i <= size; i++) {
			DB_Query = DB_Query + " DOW_FIELD_" + i + ",";
		}
		DB_Query = DB_Query.substring(0, DB_Query.length() - 1);
		return DB_Query;

	}
	
}
