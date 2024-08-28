package com.iii.pel.forms.filedownload;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface FileDownload {
	
	public void writeCSVToResponse(HttpServletResponse response,
			StringBuffer baos, String fileName, Connection connection);
	
	public void createCSV(String fileName, HttpServletRequest request, HttpServletResponse response);

}
