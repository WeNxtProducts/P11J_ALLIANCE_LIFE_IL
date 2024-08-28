package com.iii.pel.forms.filedownload;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iii.premia.common.utils.CommonUtils;

public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FileDownload fileDownloadUtils = null;

	public FileDownloadServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String fileName = null;
		String reportType = request.getParameter("reptype");
		String schedulerDate = request.getParameter("sysdate");	
		if(schedulerDate==null){			
			schedulerDate = CommonUtils.dateToStringFormatter(new Date());
			System.out.println("Date null-Optional Date"+schedulerDate);
			
		}
		System.out.println("File Download servlets starts--> " + reportType);
		System.out.println("File Download given date--> " + schedulerDate);

		try {
			if ("PDD".equalsIgnoreCase(reportType)) { // Premium Due Download
				fileDownloadUtils = new PremiumDueDownloadImpl();
				fileName = "DD_"+schedulerDate+ ".csv";
			} else if ("SSP".equalsIgnoreCase(reportType)) { // Smart Stream
																
				fileDownloadUtils = new SmartStreamDownloadImpl();
			} else if ("PNP".equalsIgnoreCase(reportType)) { // Paynet Process
				
				fileDownloadUtils = new PaynetProcessDownloadImpl();
			}

			if (fileDownloadUtils != null)
				fileDownloadUtils.createCSV(fileName, request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
