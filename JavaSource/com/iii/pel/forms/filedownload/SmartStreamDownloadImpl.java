package com.iii.pel.forms.filedownload;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SmartStreamDownloadImpl implements FileDownload {
	
	List<String> headercaptionList = null;
	String DataQuery = null;

	public void writeCSVToResponse(HttpServletResponse response,
			StringBuffer baos, String fileName, Connection connection) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void createCSV(String fileName, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			System.out.println("Smart Stream Download generation...");
			response.sendRedirect(request.getContextPath()
					+ "/SmartStreamProcessServlet?pathflag=yes");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
